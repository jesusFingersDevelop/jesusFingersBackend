"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const common_1 = require("@nestjs/common");
const core_1 = require("@nestjs/core");
const swagger_1 = require("@nestjs/swagger");
const express_basic_auth_1 = __importDefault(require("express-basic-auth"));
const app_module_1 = require("./app.module");
const http_exception_filter_1 = require("./common/exceptions/http-exception.filter");
async function bootstrap() {
    const app = await core_1.NestFactory.create(app_module_1.AppModule);
    app.useGlobalPipes(new common_1.ValidationPipe());
    app.useGlobalFilters(new http_exception_filter_1.HttpExceptionFilter());
    app.use(['/api', '/api-json'], (0, express_basic_auth_1.default)({
        challenge: true,
        users: {
            [process.env.SWAGGER_USER]: process.env.SWAGGER_PASSWORD,
        },
    }));
    const config = new swagger_1.DocumentBuilder()
        .setTitle('Jesusfingers')
        .setDescription('Jesusfingers API description')
        .setVersion('1.0')
        .addTag('열심히 만들어보자구 ㅎ_ㅎ')
        .build();
    const document = swagger_1.SwaggerModule.createDocument(app, config);
    swagger_1.SwaggerModule.setup('api', app, document);
    app.enableCors({
        origin: true,
        credentials: true,
    });
    const PORT = process.env.PORT;
    await app.listen(PORT);
    console.log(`hello this is ${PORT} port`);
    if (module.hot) {
        module.hot.accept();
        module.hot.dispose(() => app.close());
    }
}
bootstrap();
//# sourceMappingURL=main.js.map