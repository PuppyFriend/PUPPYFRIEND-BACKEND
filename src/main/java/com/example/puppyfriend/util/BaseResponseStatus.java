package com.example.puppyfriend.util;

import lombok.Getter;

@Getter
public enum BaseResponseStatus {

    SUCCESS(true, 1000, "요청에 성공하였습니다."),
    EMPTY_TOKEN(false, 1001, "토큰을 확인해주세요."),

    /*
     * 4000: [POST]
     * */
    POST_EMPTY(false, 4777, "내용 입력해주세요."),
    POST_USER_ID_EMPTY(false, 4778, "해당하는 유저 정보가 없습니다."),
    POST_OVER(false, 4779, "제한 글자 45자를 초과했습니다."),
    POST_BACKGROUND_COLOR(false, 4780, "배경사진을 선택해주세요."),
    POST_USER_NOT_FOUND(false, 4781, "해당 유저를 찾지 못했습니다."),

    INTERNAL_SERVER_ERROR(false, 5000, "토큰을 확인해주세요."),
    ;

    private final boolean isSuccess;
    private final int code;
    private final String message;

    private BaseResponseStatus(boolean isSuccess, int code, String message) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }
}