import { Injectable } from '@nestjs/common';
import axios from 'axios';
import { InjectRepository } from '@nestjs/typeorm';
import { Users } from '../entities/users.entity';
import { Repository } from 'typeorm';
import { v4 as uuid } from 'uuid';

@Injectable()
export class UsersService {
  constructor(
    @InjectRepository(Users)
    private readonly usersRepository: Repository<Users>,
  ) {}

  async kakaoCode(body) {
    // access code로 access token을 발급받는다.
    const getToken = await axios.post(
      `https://kauth.kakao.com/oauth/token?grant_type=authorization_code&client_id=${process.env.REST_API_KEY}&redirect_uri=${process.env.REDIRECT_URI}&code=${body.code}&client_secret=${process.env.CLIENT_SECRET}`,
      '',
    );
    // access token으로 유저정보를 받아온다.
    console.log(getToken.data.access_token);
    const config = {
      headers: { Authorization: `Bearer ${getToken.data.access_token}` },
    };
    const getUserInfo = await axios.post(
      `https://kapi.kakao.com/v2/user/me`,
      '',
      config,
    );
    // console.log(getToken);
    return getUserInfo.data;
  }

  async findUserById(kakaoId: number | string): Promise<Users | undefined> {
    return await this.usersRepository.findOne(kakaoId);
  }

  async createKakaoUser(
    user: Users,
    id: string,
    userEmail: string,
  ): Promise<void> {
    user.userId = uuid();
    user.kakaoId = id;
    user.userProvider = 'kakao';
    user.userEmail = userEmail;
  }
}
