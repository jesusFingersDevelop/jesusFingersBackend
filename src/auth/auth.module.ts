import { PassportModule } from '@nestjs/passport';
import { forwardRef, Module } from '@nestjs/common';
import { AuthService } from './auth.service';
import { JwtModule } from '@nestjs/jwt';
import { UsersModule } from '../users/users.module';
import { KakaoStrategy } from './strategy/kakao.strategy';
import { JwtStrategy } from './strategy/jwt.strategy';

// @ts-ignore
@Module({
  imports: [
    forwardRef(() => UsersModule),
    PassportModule.register({ defaultStrategy: 'jwt', session: false }),
    JwtModule.register({
      secret: process.env.JWT_SECRET,
      signOptions: { expiresIn: '1y' },
    }),
  ],
  providers: [AuthService, JwtStrategy, KakaoStrategy],
  exports: [AuthService, JwtModule, PassportModule],
})
export class AuthModule {}
