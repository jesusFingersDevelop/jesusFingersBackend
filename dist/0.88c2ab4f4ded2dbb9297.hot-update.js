exports.id = 0;
exports.ids = null;
exports.modules = {

/***/ 14:
/***/ (() => {

throw new Error("Module parse failed: Cannot use keyword 'await' outside an async function (18:25)\nFile was processed with these loaders:\n * ./node_modules/ts-loader/index.js\nYou may need an additional loader to handle the result of these loaders.\n|     kakaoCode(body) {\n|         let users;\n>         const getToken = await axios_1.default.post(`https://kauth.kakao.com/oauth/token?grant_type=authorization_code&client_id=${process.env.REST_API_KEY}&redirect_uri=${process.env.REDIRECT_URI}&code=${body.code}&client_secret=${process.env.CLIENT_SECRET}`, '');\n|         console.log(getToken.data);\n|         return users;");

/***/ })

};
exports.runtime =
/******/ function(__webpack_require__) { // webpackRuntimeModules
/******/ /* webpack/runtime/getFullHash */
/******/ (() => {
/******/ 	__webpack_require__.h = () => ("0085ed9adcafb6b0f8c9")
/******/ })();
/******/ 
/******/ }
;