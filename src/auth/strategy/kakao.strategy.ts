import { Injectable } from '@nestjs/common';
import { PassportStrategy } from '@nestjs/passport';
import { Strategy } from 'passport-kakao';
import { AuthService } from '../auth.service';
import { UsersService } from '../../users/users.service';

@Injectable()
export class KakaoStrategy extends PassportStrategy(Strategy) {
  constructor(
    private readonly authService: AuthService,
    private readonly usersService: UsersService,
  ) {
    super({
      clientID: process.env.REST_API_KEY,
      clientSecret: process.env.CLIENT_SECRET,
      callbackURL: process.env.REDIRECT_URI,
    });
  }

  async validate(
    accessToken: string,
    refreshToken: string,
    profile: any,
    done: any,
  ): Promise<any> {
    console.log(profile);
    const user = await this.authService.validateUser(profile.id);
    console.log(user);
    if (!user) {
      const userNick = profile.name;
      //  여기서 회원가입 시키기
      const user = await this.usersService.findUserById(profile.id);
      const access_token = await this.authService.createAccessToken(user);
    }
    const access_token = await this.authService.createAccessToken(user);
    return { access_token };
  }
}
