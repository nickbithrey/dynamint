package org.innovation.dynamint.channel.file;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.innovation.dynamint.channel.BaseChannel;
import org.innovation.dynamint.channel.timer.TimerChannel;

@Entity
@Table(name = "FILE_CHANNEL")
public class FileChannel extends BaseChannel implements TimerChannel {

    private String filenamePattern;

    private String moveSuccess;

    private String moveFailure;

    private String moveInProgress;

    private String cron;

    public FileChannel() {
        setType("file");
    }

    public String getFilenamePattern() {
        return filenamePattern;
    }

    public void setFilenamePattern(String filenamePattern) {
        this.filenamePattern = filenamePattern;
    }

    public String getMoveSuccess() {
        return moveSuccess;
    }

    public void setMoveSuccess(String moveSuccess) {
        this.moveSuccess = moveSuccess;
    }

    public String getMoveFailure() {
        return moveFailure;
    }

    public void setMoveFailure(String moveFailure) {
        this.moveFailure = moveFailure;
    }

    public String getMoveInProgress() {
        return moveInProgress;
    }

    public void setMoveInProgress(String moveInProgress) {
        this.moveInProgress = moveInProgress;
    }

    @Override
    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

}
