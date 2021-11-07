exports.id = 0;
exports.ids = null;
exports.modules = {

/***/ 14:
/***/ (() => {

throw new Error("Module parse failed: Unexpected token (18:272)\nFile was processed with these loaders:\n * ./node_modules/ts-loader/index.js\nYou may need an additional loader to handle the result of these loaders.\n|     kakaoCode(body) {\n|         let users;\n>         const getToken = axios_1.default.post(`https://kauth.kakao.com/oauth/token?grant_type=authorization_code&client_id=${process.env.REST_API_KEY}&redirect_uri=${process.env.REDIRECT_URI}&code=${body.code}&client_secret=${process.env.CLIENT_SECRET}`, '').then(res => ());\n|         return res;\n|         ;");

/***/ })

};
exports.runtime =
/******/ function(__webpack_require__) { // webpackRuntimeModules
/******/ /* webpack/runtime/getFullHash */
/******/ (() => {
/******/ 	__webpack_require__.h = () => ("ee13b99ae89465a46ce2")
/******/ })();
/******/ 
/******/ }
;