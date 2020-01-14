package multithreads.ch4.downloader;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import util.Debug;
import util.Tools;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicLong;

public class Storage implements Closeable, AutoCloseable {
    private final RandomAccessFile storeFile;
    private final FileChannel storeChannel;
    protected final AtomicLong totalWrites = new AtomicLong(0);

    public Storage(long fileSize, String fileShortName) throws Exception {
        String fullFileName = System.getProperty("java.io.tmpdir") + "/" + fileShortName;
        String localFileName;
        localFileName = createStoreFile(fileSize, fullFileName);
        storeFile = new RandomAccessFile(localFileName,"rw");
        storeChannel = storeFile.getChannel();
    }

    public int store(long offset, ByteBuffer byteBuf) throws IOException {
        int length;
        storeChannel.write(byteBuf,offset);
        length = byteBuf.limit();
        totalWrites.addAndGet(length);
        return length;
    }

    public long getTotalWrites() {
        return totalWrites.get();
    }

    private String createStoreFile(final long fileSize, String fullFileName) throws IOException {
        Debug.info("create local file %s", fullFileName);
//        File file = new File(fullFileName);
//        RandomAccessFile raf;
//        raf = new RandomAccessFile(file, "rw");
//        try {
//            raf.setLength(fileSize);
//        } finally {
//            Tools.silentClose(raf);
//        }
        return fullFileName;
    }

    @Override
    public synchronized void close() throws IOException {
        if(storeChannel.isOpen()){
            Tools.silentClose(storeChannel, storeFile);
        }
    }

}
