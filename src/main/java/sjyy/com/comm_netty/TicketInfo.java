package sjyy.com.comm_netty;

import java.io.InputStream;
import java.sql.Blob;

/**
 * Created by cm on 2017/1/12.
 */
public class TicketInfo {

    private int chipinid;

    private long tempId;

    private Blob ticketImage; // 票信息

    private long voteProccessTime; //最迟出票时间

    public int getChipinid() {
        return chipinid;
    }

    public void setChipinid(int chipinid) {
        this.chipinid = chipinid;
    }

    public long getTempId() {
        return tempId;
    }

    public void setTempId(long tempId) {
        this.tempId = tempId;
    }

    public Blob getTicketImage() {
        return ticketImage;
    }

    public void setTicketImage(Blob ticketImage) {
        this.ticketImage = ticketImage;
    }

    public long getVoteProccessTime() {
        return voteProccessTime;
    }

    public void setVoteProccessTime(long voteProccessTime) {
        this.voteProccessTime = voteProccessTime;
    }

    @Override
    public String toString() {
        return "TicketInfo{" +
                "chipinid=" + chipinid +
                ", tempId=" + tempId +
                ", ticketImage=" + ticketImage +
                ", voteProccessTime=" + voteProccessTime +
                '}';
    }
}