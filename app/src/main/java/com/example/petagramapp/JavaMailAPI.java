package com.example.petagramapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailAPI extends AsyncTask<Void,Void,Void>  {

    //Variables
    private Context mContext;
    private Session mSession;

    private String mEmail;
    private String mSubject;
    private String mMessage;
    private String emailuser;

    private ProgressDialog mProgressDialog;


    public JavaMailAPI(Context mContext, String mSubject, String mMessage, String emailuser) {
        this.mContext = mContext;
        this.emailuser= emailuser;
        //this.mEmail = mEmail;
        this.mSubject = mSubject;
        this.mMessage = mMessage;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        mProgressDialog = ProgressDialog.show(mContext,"Sending message", "Please wait...",false,false);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        mProgressDialog.dismiss();


        Toast.makeText(mContext,"Message Sent",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected Void doInBackground(Void... params) {

        Properties props = new Properties();


        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        //Creating a new session
        mSession = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {

                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(Utils.EMAIL, Utils.PASSWORD);
                    }
                });

        try {

            MimeMessage mm = new MimeMessage(mSession);


            mm.setFrom(new InternetAddress(Utils.EMAIL));

            mEmail= "shirgom@icloud.com";
            mm.addRecipient(Message.RecipientType.TO, new InternetAddress(mEmail));

            mm.setSubject(mSubject);

            mm.setText(mMessage);
            mm.setText(emailuser);


            Transport.send(mm);


        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
