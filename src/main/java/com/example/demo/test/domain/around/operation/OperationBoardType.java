package com.example.demo.test.domain.around.operation;

public enum OperationBoardType {
    HAIR_SHOP("내주변 헤어샵"),
    NAIL_SHOP("내주변 네일샵"),
    STYLER("내주변 디자이너");

    private final String text;

    OperationBoardType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static class Values {
        public static final String HAIR_SHOP = "HAIR_SHOP";
        public static final String NAIL_SHOP = "NAIL_SHOP";
        public static final String STYLER = "STYLER";
    }
}
