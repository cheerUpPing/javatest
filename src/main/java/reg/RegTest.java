package reg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 2017/7/12 14:54.
 * <p>
 * Email: cheerUpPing@163.com
 */
public class RegTest {

    public static void main(String[] args) {
        Pattern mannerReg = Pattern.compile("\\d+场-((\\d,)*\\d+)关");
        Matcher mannerMatcher = mannerReg.matcher("4场-2,3,4关");
        String msg = "\u001DL  \u001B3\u001A\u001Bc0�\u001BM\u0001\u001D!\u0010\u001Ba\u0001\u001B3\"中国体育彩票\u001B3\u001A\u001BM \u001D! \u001Ba\u0001竞彩足球让球胜平负   2x1203557-122412-151728-35 C174DBD1 00061239─────────────────────\u001BM \u001D! \u001Ba 第1场  周四019 让球:主-1主队:波托西国民 Vs 客队:拉普拉塔大学生平@3.400元第2场  周四020 让球:主-1主队:弗拉门戈 Vs 客队:格雷米奥平@3.400元(选项固定奖金额为每1元投注对应的奖金额)本票最高可能固定奖金:23.12元 *  *  * *  *  * *  *  * *  *  * *  *  * *  *  * *  *  * *  *  * *  *  * *  *  * *  *  * *  *  * *  *  * *  *  * *  *  * *  *  * *  *  * *  *  * *  *  * *  *  * *  *  * *  *  * *  *  * *  *  * *  *  * *  *  * *  *  *\u001BM \u001D! \u001Ba\u0001─────────────────────倍数:1  合计:      2元 2017-07-12 16:15:25110566701 地址：南海区松岗澳涌市场2号之三 \u001Bd\u0001（网点号：05667）\u001Bd\u0001竞彩13日赛事 08:00 弗鲁米嫩塞 vs 博塔弗戈\u001Bd\u0001，超级大乐透第17079期奖池：38.58亿\u001Bd\u0001中国竞彩网 http://www.sporttery.cn\u001Bd\u0001\u001Dp\u0004\u0002\u0014\u0006\u0003\u0006\u001Dq\u0004\u001DkK \u0001\u0002\u001D20355712241215172835 00061239\u001Bd \u001DVB";
        if (mannerMatcher.find()){
            String all = mannerMatcher.group();
            String cut = mannerMatcher.group(1);
            System.out.println(all+"------------------"+cut);
        }else {
            mannerReg = Pattern.compile("(\\d+x\\d+)");
        }
        mannerReg = Pattern.compile("(\\d+x\\d+)");
        mannerMatcher = mannerReg.matcher(msg);
        if (mannerMatcher.find()){
            String xx = mannerMatcher.group(1);
            System.out.println(xx);
        }
    }
}
