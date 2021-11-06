import { Injectable } from '@nestjs/common';
import axios from 'axios';

@Injectable()
export class UsersService {
  kakaoCode() {
    const REST_API_KEY = process.env.REST_API_KEY;
    const REDIRECT_URI = process.env.REDIRECT_URI;
    const redirectUrl = axios
      .get(
        `https://kauth.kakao.com/oauth/authorize?client_id=${REST_API_KEY}&redirect_uri=${REDIRECT_URI}&response_type=code`,
      )
      .then((res) => {
        return res;
      });
    // .catch((res) => console.log(res));

    return 'redirectUrl';
  }

  kakaoToken(body) {
    const headers: object = {
      'Content-type': 'application/x-www-form-urlencoded;charset=utf-8',
    };

    const getToken = axios
      .post(
        `https://kauth.kakao.com/oauth/token?grant_type=authorization_code&client_id=${process.env.REST_API_KEY}&redirect_uri=${process.env.REDIRECT_URI}&code=${body.code}&client_secret=${process.env.CLIENT_SECRET}`,
        '',
        headers,
      )
      .then((response) => {
        console.log(response);
      });

    return;
    // return body;
  }
}
