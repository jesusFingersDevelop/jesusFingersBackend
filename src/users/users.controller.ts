import { Body, Controller, Get, Post, Req } from '@nestjs/common';
import { AnyArray } from 'mongoose';
import { UsersService } from './users.service';

@Controller('api/v1/users')
export class UsersController {
  constructor(private readonly usersService: UsersService) {}

  @Get()
  getTest() {
    return 'test';
  }

  @Post('kakaoToken')
  getKakaoToken(@Body() body: any) {
    return this.usersService.kakaoToken(body);
  }

  @Post('jwt')
  async login() {}
}
