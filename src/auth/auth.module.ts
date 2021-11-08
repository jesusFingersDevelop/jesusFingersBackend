import { Module } from '@nestjs/common';
import { PassportModule } from '@nestjs/passport';
import { AuthService } from './auth.service';
import { JwtModule} from '@nestjs/jwt'
import { JwtStrategy } from './jwt/jwt.strategy';

@Module({
  imports: [
    PassportModule.register({defaultStrategy: 'jwt', session:false}),
    JwtModule.register({
      secret: process.env.JWT_SECRET,
      signOptions: {expiresIn: '1y'}
    })
  ]
  providers: [AuthService, JwtStrategy]
})
export class AuthModule {}
