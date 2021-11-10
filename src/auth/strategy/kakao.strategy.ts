import { Injectable } from '@nestjs/common';
import { PassportStrategy } from '@nestjs/passport';
import { Strategy } from 'passport-kakao';
import { AuthService } from '../auth.service';

@Injectable()
export class KakaoStrategy extends PassportStrategy(Strategy) {
  constructor(private authService: AuthService) {
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
    const user = await this.authService.validateUser(profile.id);
    if (!user) {
      const userNick = profile.name;
      await
    }
  }
}
