import { Injectable } from '@nestjs/common';
import { UsersService } from '../users/users.service';
import { JwtService } from '@nestjs/jwt';
import { User } from '../../entity/users.entity';

@Injectable()
export class AuthService {
  constructor(
    private readonly userService: UsersService,
    private readonly jwtService: JwtService,
  ) {}

  async validateUser(id: number | string): Promise<User | undefined> {
    return await this.userService.findeUserById(id);
  }

  async createAccessToken(user: User) {
    const payload = {
      id: user.userId,
    };
    return this.jwtService.sign(payload, {
      secret: process.env.JWT_SECRET,
      expiresIn: '60m',
    });
  }

  // async createRefreshToken(user: User) {
  //   const payload = {
  //     id: user.userId,
  //   };
  //   const refreshToken = this.jwtService.sign(payload, {
  //     secret: process.env.JWT_SECRET,
  //     expiresIn: '30d',
  //   });
  // }
}
