import { Body, Controller, Get, Post, Req } from '@nestjs/common';
import { UsersService } from './users.service';

@Controller('api/v1/users')
export class UsersController {
  constructor(private readonly usersService: UsersService) {}

  @Get()
  getTest() {
    return 'test';
  }

  //   @Post('kakaocode')
  //   getKakaoUser(@Body() body: any) {
  //     return this.usersService.kakaoCode(body);
  //   }

  @Post('jwt')
  async login() {}
}
