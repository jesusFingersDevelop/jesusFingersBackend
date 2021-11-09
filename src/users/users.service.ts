import { Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import axios from 'axios';
import { User } from 'src/entities/user.entity';
import { Repository } from 'typeorm';
import { v4 as uuid } from 'uuid';

@Injectable()
export class UsersService {
  constructor(
    @InjectRepository(User)
    private readonly usersRepository: Repository<User>,
  ) {}

  findAll(): Promise<User[]> {
    return this.usersRepository.find();
  }
  findeOne(id: string): Promise<User> {
    return this.usersRepository.findOne(id);
  }
  async remove(id: string): Promise<void> {
    await this.usersRepository.delete(id);
  }
  async saveUser(user: User): Promise<void> {
    user.isActive = true;
    user.lastName = 'minkyung';
    user.kakaoId = uuid();
    user.firstName = 'bongsun';
    await this.usersRepository.save(user);
  }

  async kakaoCode(body, user: User) {
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

  getKakaoUsers() {}
}
