package jp.co.aforce.been;

public class MemberInformation implements java.io.Serializable{
	
	private String MEMBER_ID;
	private String LAST_NAME;
	private String FARST_NAME;
	private String SEX;
	private int BIRTH_YEAR;
	private int BIRTH_MONTH;
	private int BIRTH_DAY;
	private String PHONE_NUMBER;
	private String MAIL_ADDRESS;
	private String JOB;
	//会員番号
	public String getId() {
		return MEMBER_ID;
	}
	public void setId(String MEMBER_ID) {
		this.MEMBER_ID=MEMBER_ID;
	}
	//名前_姓
	public String getLname() {
		return LAST_NAME;
	}
	public void setLname(String LAST_NAME) {
		this.LAST_NAME=LAST_NAME;
	}
	//名前_名
	public String getFname() {
		return FARST_NAME;
	}
	public void setFname(String FARST_NAME) {
		this.FARST_NAME=FARST_NAME;
	}
	//性別
	public String getSex() {
		return SEX;
	}
	public void setSex(String SEX) {
		this.SEX=SEX;
	}
	//生年月日_年
	public int getByear() {
		return BIRTH_YEAR;
	}
	public void setByear(int BIRTH_YEAR) {
		this.BIRTH_YEAR=BIRTH_YEAR;
	} 
	//生年月日_月
	public int getBmonth() {
		return BIRTH_MONTH;
	}
	public void setBmonth(int BIRTH_MONTH) {
		this.BIRTH_MONTH=BIRTH_MONTH;
	}
	//生年月日_日
	public int getBday() {
		return BIRTH_DAY;
	}
	public void setBday(int BIRTH_DAY) {
		this.BIRTH_DAY=BIRTH_DAY;
	}
	//電話番号
	public String getPnumber() {
		return PHONE_NUMBER;
	}
	public void setPnumber(String PHONE_NUMBER) {
		this.PHONE_NUMBER=PHONE_NUMBER;
	}
	//メールアドレス
	public String getMail() {
		return MAIL_ADDRESS;
	}
	public void setMail(String MAIL_ADDRESS) {
		this.MAIL_ADDRESS=MAIL_ADDRESS;
	}
	//仕事
	public String getJob() {
		return JOB;
	}
	public void setJob(String JOB) {
		this.JOB=JOB;
	}

}
