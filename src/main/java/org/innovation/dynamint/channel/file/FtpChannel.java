package org.innovation.dynamint.channel.file;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * class name as {@link FileChannel} but sets a different type
 *
 * @author nick.bithrey
 *
 */
@Entity
@Table(name = "FTP_CHANNEL")
public class FtpChannel extends FileChannel {

    public FtpChannel() {
        setType("ftp");
    }

}
