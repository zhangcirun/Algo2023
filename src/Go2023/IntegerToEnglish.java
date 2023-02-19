package Go2023;

public class IntegerToEnglish {
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        int hundred = num % 1000;
        num /= 1000;

        int thousand = num % 1000;
        num /= 1000;

        int million = num % 1000;
        num /= 1000;

        int billion = num % 1000;

        StringBuilder sb = new StringBuilder();

        if (billion > 0) {
            sb.append(threeDigitsToString(billion)).append( " Billion");
        }

        if (million > 0) {
            if (billion > 0) {
                sb.append(" ");
            }
            sb.append(threeDigitsToString(million)).append(" Million");
        }

        if (thousand > 0) {
            if (million > 0 || billion > 0) {
                sb.append(" ");
            }
            sb.append(threeDigitsToString(thousand)).append(" Thousand");
        }

        if (hundred > 0) {
            if (thousand > 0 || million > 0 || billion > 0) {
                sb.append(" ");
            }
            sb.append(threeDigitsToString(hundred));
        }

        return sb.toString();
    }

    private String threeDigitsToString(int digit) {
        int two = digit % 100;
        int hundred = digit / 100 % 10;

        StringBuilder sb = new StringBuilder();

        if (hundred > 0) {
            sb.append(singleDigitToString(hundred)).append(" Hundred");
        }

        if (two > 0) {
            if (hundred > 0) {
                sb.append(" ");
            }
            sb.append(twoDigitsToString(two));
        }

        return sb.toString();
    }

    private String singleDigitToString(int num) {
        switch(num) {
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
        }
        return "";
    }

    private String twoDigitsToString(int num) {
        if (num >= 10 && num <= 19) {
            switch (num) {
                case 10: return "Ten";
                case 11: return "Eleven";
                case 12: return "Twelve";
                case 13: return "Thirteen";
                case 14: return "Fourteen";
                case 15: return "Fifteen";
                case 16: return "Sixteen";
                case 17: return "Seventeen";
                case 18: return "Eighteen";
                case 19: return "Nineteen";
            }
        }

        int one = num % 10;
        int hundred = num / 10 % 10;

        StringBuilder sb = new StringBuilder();

        if (hundred > 0) {
            switch (hundred) {
                case 2: sb.append("Twenty");break;
                case 3: sb.append("Thirty");break;
                case 4: sb.append("Forty");break;
                case 5: sb.append("Fifty");break;
                case 6: sb.append("Sixty");break;
                case 7: sb.append("Seventy");break;
                case 8: sb.append("Eighty");break;
                case 9: sb.append("Ninety");break;
            }

            if (one > 0) {
                sb.append(" ");
            }
        }

        sb.append(singleDigitToString(one));

        return sb.toString();
    }
}
