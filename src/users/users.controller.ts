import { Controller, Get, Post, Req, Res, UseGuards } from '@nestjs/common';
import { UsersService } from './users.service';
import { AuthService } from '../auth/auth.service';
import { Response } from 'express';
import { ApiOperation, ApiTags } from '@nestjs/swagger';
import { KakaoAuthGuard } from '../auth/guard/kakao-auth.guard';

@ApiTags('user')
@Controller('api/v1/users')
export class UsersController {
  constructor(
    private readonly usersService: UsersService,
    private readonly authService: AuthService,
  ) {}

  @ApiOperation({ summary: '카카오 로그인', description: '카카오 로그인 api' })
  @UseGuards(KakaoAuthGuard)
  @Get('auth/kakao')
  kakaoLogin() {
    return;
  }

  @ApiOperation({
    summary: '카카오 로그인 콜백',
    description: '카카오 로그인 콜백 라우터',
  })
  @UseGuards(KakaoAuthGuard)
  @Get('auth/kakao/callback')
  async kakaocallback(@Req() req, @Res() res: Response) {
    const { access_token, refresh_token } = req.user;
    res.cookie('access_token', access_token);
    res.cookie('refresh_token', refresh_token);
    res.redirect(process.env.CLIENT_URL);
  }
}
