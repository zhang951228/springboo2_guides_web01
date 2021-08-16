import org.apache.commons.lang.StringUtils;

/**
 * @Auther: Z151
 * @Date: 2021/8/16 11:37
 */
public class myTest01 {

    public static void main(String[] args) {
/*        System.out.println(StringUtils.isNumeric("55"));
        System.out.println(StringUtils.isNumeric("55.23"));
        System.out.println(StringUtils.isNumeric("0.23"));
        System.out.println(StringUtils.isNumeric(".23"));*/

        System.out.println(isFloatNumber("55"));
        System.out.println(isFloatNumber("55.23"));
        System.out.println(isFloatNumber("0.23"));
        System.out.println(isFloatNumber(".23"));
        System.out.println(isFloatNumber("2."));
        System.out.println(isFloatNumber("."));
    }

    public static boolean isFloatNumber(String str){
        String reg = "^[0-9]+(.[0-9]+)?$";
        return str.matches(reg);
    }
}
