/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceDueDtVO.java
*@FileTitle : InvoiceDueDtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.06.26 정휘택 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo;

import java.util.HashMap;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.javamail.Mail;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정휘택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvEmlVO {

	private static final long serialVersionUID = 1L;
		
	/* Column Info */
	private Mail mail = null;
	/* Column Info */
	private String custEml = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String emlSndNo = null;
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String invSeq = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String attach = null;
	/* Column Info */
	private String attachView = null;
	/* Column Info */
	private String attach2 = null;
	/* Column Info */
	private String attachView2= null;
	/* Column Info */
	private String rdType= null;	
	/* Column Info */
	private String blSrcNoTitle = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvEmlVO() {}

	public InvEmlVO(Mail mail, String custEml, String vvd, String custCd, String invNo, String emlSndNo, String blSrcNo, String invSeq, String ofcCd, String portCd, String attach, String attachView, String attach2, String attachView2, String rdType, String blSrcNoTitle) {
		//this.mail = mail;
		this.custEml = custEml;
		this.vvd = vvd;
		this.custCd = custCd;
		this.invNo = invNo;
		this.emlSndNo = emlSndNo;
		this.blSrcNo = blSrcNo;
		this.invSeq = invSeq;
		this.ofcCd = ofcCd;
		this.portCd = portCd;
		this.attach = attach;
		this.attachView = attachView;
		this.attach2 = attach2;
		this.attachView2 = attachView2;
		this.rdType = rdType;
		this.blSrcNoTitle = blSrcNoTitle;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		//this.hashColumns.put("mail", getMail());
		this.hashColumns.put("custEml", getCustEml());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("custCd", getCustCd());
		this.hashColumns.put("invNo", getInvNo());
		this.hashColumns.put("emlSndNo", getEmlSndNo());
		this.hashColumns.put("blSrcNo", getBlSrcNo());
		this.hashColumns.put("invSeq", getInvSeq());
		this.hashColumns.put("ofcCd", getOfcCd());
		this.hashColumns.put("portCd", getPortCd());
		this.hashColumns.put("attach", getAttach());
		this.hashColumns.put("attachView", getAttachView());
		this.hashColumns.put("attach2", getAttach2());
		this.hashColumns.put("attachView2", getAttachView2());
		this.hashColumns.put("rdType", getRdType());
		this.hashColumns.put("blSrcNoTitle", getBlSrcNoTitle());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		//this.hashFields.put("mail", "mail");
		this.hashFields.put("cust_eml", "custEml");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("eml_snd_no", "emlSndNo");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("attach", "attach");
		this.hashFields.put("attach_view", "attachView");
		this.hashFields.put("attach2", "attach2");
		this.hashFields.put("attach_view2", "attachView2");
		this.hashFields.put("rd_type", "rdType");
		this.hashFields.put("bl_src_no_title", "blSrcNoTitle");
		return this.hashFields;
	}
	
	/**
	 * @return the mail
	 */
	public Mail getMail() {
		return mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(Mail mail) {
		this.mail = mail;
	}

	/**
	 * @return the custEml
	 */
	public String getCustEml() {
		return custEml;
	}

	/**
	 * @param custEml the custEml to set
	 */
	public void setCustEml(String custEml) {
		this.custEml = custEml;
	}

	/**
	 * @return the vvd
	 */
	public String getVvd() {
		return vvd;
	}

	/**
	 * @param vvd the vvd to set
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	/**
	 * @return the custCd
	 */
	public String getCustCd() {
		return custCd;
	}

	/**
	 * @param custCd the custCd to set
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}

	/**
	 * @return the invNo
	 */
	public String getInvNo() {
		return invNo;
	}

	/**
	 * @param invNo the invNo to set
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}

	/**
	 * @return the emlSndNo
	 */
	public String getEmlSndNo() {
		return emlSndNo;
	}

	/**
	 * @param emlSndNo the emlSndNo to set
	 */
	public void setEmlSndNo(String emlSndNo) {
		this.emlSndNo = emlSndNo;
	}

	/**
	 * @return the blSrcNo
	 */
	public String getBlSrcNo() {
		return blSrcNo;
	}

	/**
	 * @param blSrcNo the blSrcNo to set
	 */
	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
	}

	/**
	 * @return the invSeq
	 */
	public String getInvSeq() {
		return invSeq;
	}

	/**
	 * @param invSeq the invSeq to set
	 */
	public void setInvSeq(String invSeq) {
		this.invSeq = invSeq;
	}

	/**
	 * @return the ofcCd
	 */
	public String getOfcCd() {
		return ofcCd;
	}

	/**
	 * @param ofcCd the ofcCd to set
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	/**
	 * @return the portCd
	 */
	public String getPortCd() {
		return portCd;
	}

	/**
	 * @param portCd the portCd to set
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}

	/**
	 * @return the attach
	 */
	public String getAttach() {
		return attach;
	}

	/**
	 * @param attach the attach to set
	 */
	public void setAttach(String attach) {
		this.attach = attach;
	}

	/**
	 * @return the attachView
	 */
	public String getAttachView() {
		return attachView;
	}

	/**
	 * @param attachView the attachView to set
	 */
	public void setAttachView(String attachView) {
		this.attachView = attachView;
	}

	/**
	 * @return the attach2
	 */
	public String getAttach2() {
		return attach2;
	}

	/**
	 * @param attach2 the attach2 to set
	 */
	public void setAttach2(String attach2) {
		this.attach2 = attach2;
	}

	/**
	 * @return the attachView2
	 */
	public String getAttachView2() {
		return attachView2;
	}

	/**
	 * @param attachView2 the attachView2 to set
	 */
	public void setAttachView2(String attachView2) {
		this.attachView2 = attachView2;
	}

	/**
	 * @return the rdType
	 */
	public String getRdType() {
		return rdType;
	}

	/**
	 * @param rdType the rdType to set
	 */
	public void setRdType(String rdType) {
		this.rdType = rdType;
	}

	/**
	 * @return the blSrcNoTitle
	 */
	public String getBlSrcNoTitle() {
		return blSrcNoTitle;
	}

	/**
	 * @param blSrcNoTitle the blSrcNoTitle to set
	 */
	public void setBlSrcNoTitle(String blSrcNoTitle) {
		this.blSrcNoTitle = blSrcNoTitle;
	}

}
