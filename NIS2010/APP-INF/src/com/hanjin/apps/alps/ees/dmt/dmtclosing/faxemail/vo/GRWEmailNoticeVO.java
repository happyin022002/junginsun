/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GRWEmailNoticeVO.java
*@FileTitle : GRWEmailNoticeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.17
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.17  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtclosing.faxemail.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class GRWEmailNoticeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GRWEmailNoticeVO> models = new ArrayList<GRWEmailNoticeVO>();
	
	/* Column Info */
	private String textcontent = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String subject = null;
	/* Column Info */
	private String darNo = null;
	/* Column Info */
	private String apvlNo = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String recipient = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String sender = null;
	/* Column Info */
	private String verNo = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String htmltemplate = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String comments = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GRWEmailNoticeVO() {}

	public GRWEmailNoticeVO(String ibflag, String pagerows, String sender, String subject, String recipient, String textcontent, String htmltemplate, String darNo, String verNo, String apvlNo, String status, String scNo, String rfaNo, String propNo, String blNo, String custCd, String custNm, String comments) {
		this.textcontent = textcontent;
		this.custNm = custNm;
		this.status = status;
		this.subject = subject;
		this.darNo = darNo;
		this.apvlNo = apvlNo;
		this.blNo = blNo;
		this.recipient = recipient;
		this.pagerows = pagerows;
		this.sender = sender;
		this.verNo = verNo;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.propNo = propNo;
		this.htmltemplate = htmltemplate;
		this.custCd = custCd;
		this.scNo = scNo;
		this.comments = comments;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("textcontent", getTextcontent());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("subject", getSubject());
		this.hashColumns.put("dar_no", getDarNo());
		this.hashColumns.put("apvl_no", getApvlNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("recipient", getRecipient());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sender", getSender());
		this.hashColumns.put("ver_no", getVerNo());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("htmltemplate", getHtmltemplate());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("comments", getComments());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("textcontent", "textcontent");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("status", "status");
		this.hashFields.put("subject", "subject");
		this.hashFields.put("dar_no", "darNo");
		this.hashFields.put("apvl_no", "apvlNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("recipient", "recipient");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sender", "sender");
		this.hashFields.put("ver_no", "verNo");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("htmltemplate", "htmltemplate");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("comments", "comments");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return textcontent
	 */
	public String getTextcontent() {
		return this.textcontent;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Column Info
	 * @return subject
	 */
	public String getSubject() {
		return this.subject;
	}
	
	/**
	 * Column Info
	 * @return darNo
	 */
	public String getDarNo() {
		return this.darNo;
	}
	
	/**
	 * Column Info
	 * @return apvlNo
	 */
	public String getApvlNo() {
		return this.apvlNo;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return recipient
	 */
	public String getRecipient() {
		return this.recipient;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return sender
	 */
	public String getSender() {
		return this.sender;
	}
	
	/**
	 * Column Info
	 * @return verNo
	 */
	public String getVerNo() {
		return this.verNo;
	}
	
	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return htmltemplate
	 */
	public String getHtmltemplate() {
		return this.htmltemplate;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return comments
	 */
	public String getComments() {
		return this.comments;
	}
	

	/**
	 * Column Info
	 * @param textcontent
	 */
	public void setTextcontent(String textcontent) {
		this.textcontent = textcontent;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Column Info
	 * @param subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	/**
	 * Column Info
	 * @param darNo
	 */
	public void setDarNo(String darNo) {
		this.darNo = darNo;
	}
	
	/**
	 * Column Info
	 * @param apvlNo
	 */
	public void setApvlNo(String apvlNo) {
		this.apvlNo = apvlNo;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param recipient
	 */
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param sender
	 */
	public void setSender(String sender) {
		this.sender = sender;
	}
	
	/**
	 * Column Info
	 * @param verNo
	 */
	public void setVerNo(String verNo) {
		this.verNo = verNo;
	}
	
	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param htmltemplate
	 */
	public void setHtmltemplate(String htmltemplate) {
		this.htmltemplate = htmltemplate;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param comments
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTextcontent(JSPUtil.getParameter(request, "textcontent", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setStatus(JSPUtil.getParameter(request, "status", ""));
		setSubject(JSPUtil.getParameter(request, "subject", ""));
		setDarNo(JSPUtil.getParameter(request, "dar_no", ""));
		setApvlNo(JSPUtil.getParameter(request, "apvl_no", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setRecipient(JSPUtil.getParameter(request, "recipient", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSender(JSPUtil.getParameter(request, "sender", ""));
		setVerNo(JSPUtil.getParameter(request, "ver_no", ""));
		setRfaNo(JSPUtil.getParameter(request, "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setHtmltemplate(JSPUtil.getParameter(request, "htmltemplate", ""));
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setComments(JSPUtil.getParameter(request, "comments", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GRWEmailNoticeVO[]
	 */
	public GRWEmailNoticeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GRWEmailNoticeVO[]
	 */
	public GRWEmailNoticeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GRWEmailNoticeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] textcontent = (JSPUtil.getParameter(request, prefix	+ "textcontent", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] subject = (JSPUtil.getParameter(request, prefix	+ "subject", length));
			String[] darNo = (JSPUtil.getParameter(request, prefix	+ "dar_no", length));
			String[] apvlNo = (JSPUtil.getParameter(request, prefix	+ "apvl_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] recipient = (JSPUtil.getParameter(request, prefix	+ "recipient", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sender = (JSPUtil.getParameter(request, prefix	+ "sender", length));
			String[] verNo = (JSPUtil.getParameter(request, prefix	+ "ver_no", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] htmltemplate = (JSPUtil.getParameter(request, prefix	+ "htmltemplate", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] comments = (JSPUtil.getParameter(request, prefix	+ "comments", length));
			
			for (int i = 0; i < length; i++) {
				model = new GRWEmailNoticeVO();
				if (textcontent[i] != null)
					model.setTextcontent(textcontent[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (subject[i] != null)
					model.setSubject(subject[i]);
				if (darNo[i] != null)
					model.setDarNo(darNo[i]);
				if (apvlNo[i] != null)
					model.setApvlNo(apvlNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (recipient[i] != null)
					model.setRecipient(recipient[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sender[i] != null)
					model.setSender(sender[i]);
				if (verNo[i] != null)
					model.setVerNo(verNo[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (htmltemplate[i] != null)
					model.setHtmltemplate(htmltemplate[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (comments[i] != null)
					model.setComments(comments[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGRWEmailNoticeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GRWEmailNoticeVO[]
	 */
	public GRWEmailNoticeVO[] getGRWEmailNoticeVOs(){
		GRWEmailNoticeVO[] vos = (GRWEmailNoticeVO[])models.toArray(new GRWEmailNoticeVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.textcontent = this.textcontent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subject = this.subject .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.darNo = this.darNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apvlNo = this.apvlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.recipient = this.recipient .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sender = this.sender .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.verNo = this.verNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htmltemplate = this.htmltemplate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comments = this.comments .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
