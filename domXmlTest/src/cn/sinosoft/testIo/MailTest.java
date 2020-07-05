/*
package cn.sinosoft.testIo;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
public class MailTest {
    */
/**
     * 获取邮箱信息
     *
     * @param emailAdress 需要解析的邮箱地址
     * @param password    邮箱的授权密码
     * @throws Exception
     *//*

    public static void resceive(String emailAdress, String password) throws Exception {

        // 准备连接服务器的会话信息
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "pop3"); // 协议
        props.setProperty("mail.pop3.port", "110"); // 端口
        props.setProperty("mail.pop3.host", "pop.163.com"); // pop3服务器
        props.setProperty("mail.smtp.auth", "true");

        // 创建Session实例对象
        Session session = Session.getDefaultInstance(props);
        session.setDebug(false);
        Store store = session.getStore();
        store.connect("liuguotong1314@163.com", "AOHFWYDHUGIUANYF");

        // 获得收件箱
        Folder folder = store.getFolder("INBOX");
        

         * Folder.READ_ONLY：只读权限 Folder.READ_WRITE：可读可写（可以修改邮件的状态）
         

        folder.open(Folder.READ_WRITE); // 打开收件箱

        // 由于POP3协议无法获知邮件的状态,所以getUnreadMessageCount得到的是收件箱的邮件总数
        System.out.println("未读邮件数: " + folder.getUnreadMessageCount());
        // 由于POP3协议无法获知邮件的状态,所以下面得到的结果始终都是为0
        System.out.println("删除邮件数: " + folder.getDeletedMessageCount());
        System.out.println("新邮件: " + folder.getNewMessageCount());

        // 获得收件箱中的邮件总数
        System.out.println("邮件总数: " + folder.getMessageCount());

        // 得到收件箱中的所有邮件,并解析
        Message[] messages = folder.getMessages();
        parseMessage(messages);

        // 释放资源
        folder.close(true);
        store.close();
    }

   
/**
     * 解析邮件
     *
     * @param messages 要解析的邮件列表
     *//*

    public static void parseMessage(Message... messages) throws MessagingException, IOException {
        if (messages == null || messages.length < 1)
            throw new MessagingException("未找到要解析的邮件!");

        for (int i = 0, count = messages.length; i < count; i++) {
            MimeMessage msg = (MimeMessage) messages[i];
            System.out.println("------------------解析第" + msg.getMessageNumber() + "封邮件-------------------- ");
            System.out.println("主题: " + msg.getSubject());
            System.out.println("发件人: " + msg.getFrom());
            System.out.println("收件人：" + getReceiveAddress(msg, null));
            System.out.println("发送时间：" + msg.getSentDate());
            System.out.println("是否已读：" + isSeen(msg));
            System.out.println("邮件优先级：" + getPriority(msg));
            System.out.println("是否需要回执：" + isReplySign(msg));
            System.out.println("邮件大小：" + msg.getSize() * 1024 + "kb");
            boolean isContainerAttachment = isContainAttachment(msg);
            System.out.println("是否包含附件：" + isContainerAttachment);
            if (isContainerAttachment) {
                saveAttachment(msg, "D:\\zch\\mailTest\\"); // 保存附件
            }
            StringBuffer content = new StringBuffer(30);
            getMailTextContent(msg, content);
            System.out.println("邮件正文：" + (content.length() > 100 ? content.substring(0, 100) + "..." : content));
            System.out.println("------------------第" + msg.getMessageNumber() + "封邮件解析结束-------------------- ");
            System.out.println();

        }
    }
    */
/**
     * 根据收件人类型，获取邮件收件人、抄送和密送地址。如果收件人类型为空，则获得所有的收件人
     * <p>
     * Message.RecipientType.TO 收件人
     * </p>
     * <p>
     * Message.RecipientType.CC 抄送
     * </p>
     * <p>
     * Message.RecipientType.BCC 密送
     * </p>
     *
     * @param msg
     *            邮件内容
     * @param type
     *            收件人类型
     * @return 收件人1 <邮件地址1>, 收件人2 <邮件地址2>, ...
     * @throws MessagingException
     *//*

    public static String getReceiveAddress(MimeMessage msg, Message.RecipientType type) throws MessagingException {
        StringBuffer receiveAddress = new StringBuffer();
        Address[] addresss = null;
        if (type == null) {
            addresss = msg.getAllRecipients();
        } else {
            addresss = msg.getRecipients(type);
        }

        if (addresss == null || addresss.length < 1)
            throw new MessagingException("没有收件人!");
        for (Address address : addresss) {
            InternetAddress internetAddress = (InternetAddress) address;
            receiveAddress.append(internetAddress.toUnicodeString()).append(",");
        }

        receiveAddress.deleteCharAt(receiveAddress.length() - 1); // 删除最后一个逗号

        return receiveAddress.toString();
    }


}
*/
