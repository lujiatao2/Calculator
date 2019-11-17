class CalcAlgorithm {

    //屏幕显示值
    private static String DISPLAY_VALUE = "0";
    //实际计算值
    private static double LAST_VALUE = 0;
    //上次按下的操作按钮（即加减乘除和重置按钮）
    private static CalcButton LAST_OPERATOR_BUTTON = CalcButton.RESET;
    //上次按下的按钮
    private static CalcButton LAST_BUTTON = CalcButton.RESET;
    //除数为零提示
    private static final String DIVIDE_ZREO = "除数不能为零！";

    /***
     * 计算
     * @param calcButton 按钮
     * @return 屏幕显示值
     */
    static String calculate(CalcButton calcButton) {
        switch (calcButton) {
            case ZERO:
                DISPLAY_VALUE = handleNum("0");
                break;
            case ONE:
                DISPLAY_VALUE = handleNum("1");
                break;
            case TWO:
                DISPLAY_VALUE = handleNum("2");
                break;
            case THREE:
                DISPLAY_VALUE = handleNum("3");
                break;
            case FOUR:
                DISPLAY_VALUE = handleNum("4");
                break;
            case FIVE:
                DISPLAY_VALUE = handleNum("5");
                break;
            case SIX:
                DISPLAY_VALUE = handleNum("6");
                break;
            case SEVEN:
                DISPLAY_VALUE = handleNum("7");
                break;
            case EIGHT:
                DISPLAY_VALUE = handleNum("8");
                break;
            case NINE:
                DISPLAY_VALUE = handleNum("9");
                break;
            case DOT:
                DISPLAY_VALUE = handleNum(".");
                break;
            case ADD:
            case SUBTRACT:
            case MULTIPLY:
            case DIVIDE:
            case EQUAL:
                DISPLAY_VALUE = handleOperator();
                DISPLAY_VALUE = DISPLAY_VALUE.endsWith(".0") ? DISPLAY_VALUE.substring(0, DISPLAY_VALUE.length() - 2) : DISPLAY_VALUE;//去掉整数后面的小数点和零
                LAST_OPERATOR_BUTTON = calcButton;
                break;
            case RESET:
                DISPLAY_VALUE = "0";
                LAST_OPERATOR_BUTTON = calcButton;
                LAST_VALUE = 0;
        }
        LAST_BUTTON = DISPLAY_VALUE.equals(DIVIDE_ZREO) ? CalcButton.RESET : calcButton;//除数为零重置LAST_BUTTON为CalcButton.RESET
        return DISPLAY_VALUE;
    }

    /**
     * 处理按下数字和小数点按钮，实际计算值，返回屏幕显示值
     *
     * @param input 输入内容
     * @return 屏幕显示值
     */
    private static String handleNum(String input) {
        String result = "0";
        //上次按下的按钮为操作或重置按钮，则将屏幕显示值设为输入的值
        if (LAST_BUTTON.equals(CalcButton.ADD) || LAST_BUTTON.equals(CalcButton.SUBTRACT) || LAST_BUTTON.equals(CalcButton.MULTIPLY) || LAST_BUTTON.equals(CalcButton.DIVIDE) || LAST_BUTTON.equals(CalcButton.EQUAL) || LAST_BUTTON.equals(CalcButton.RESET)) {
            result = input.equals(".") ? "0." : input;//判断是否输入"."
        } else {
            if (input.equals(".")) {
                result = DISPLAY_VALUE.contains(".") ? DISPLAY_VALUE : DISPLAY_VALUE + ".";//不能输入多个小数点
            } else if (DISPLAY_VALUE.equals("0")) {
                result = input;
            } else {
                result = DISPLAY_VALUE + input;
            }
        }
        //初始化计算的值
        if (LAST_OPERATOR_BUTTON == CalcButton.RESET) {
            LAST_VALUE = Double.parseDouble(result);
        }
        return result;
    }

    /***
     * 处理按下操作按钮，更新实际计算值，返回屏幕显示值
     * @return 屏幕显示值
     */
    private static String handleOperator() {
        String result = "0";
        if (LAST_OPERATOR_BUTTON == CalcButton.RESET) {
            result = DISPLAY_VALUE;
        } else {
            switch (LAST_OPERATOR_BUTTON) {
                case ADD:
                    result = String.valueOf(LAST_VALUE + Double.parseDouble(DISPLAY_VALUE));
                    LAST_VALUE = Double.parseDouble(result);
                    break;
                case SUBTRACT:
                    result = String.valueOf(LAST_VALUE - Double.parseDouble(DISPLAY_VALUE));
                    LAST_VALUE = Double.parseDouble(result);
                    break;
                case MULTIPLY:
                    result = String.valueOf(LAST_VALUE * Double.parseDouble(DISPLAY_VALUE));
                    LAST_VALUE = Double.parseDouble(result);
                    break;
                case DIVIDE:
                    //除数不能为零
                    if (DISPLAY_VALUE.equals("0")) {
                        LAST_OPERATOR_BUTTON = CalcButton.RESET;
                        LAST_VALUE = 0;
                        result = DIVIDE_ZREO;
                    } else {
                        result = String.valueOf(LAST_VALUE / Double.parseDouble(DISPLAY_VALUE));
                        LAST_VALUE = Double.parseDouble(result);
                    }
                    break;
                case EQUAL:
                    result = DISPLAY_VALUE;
            }
        }
        return result;
    }

}
