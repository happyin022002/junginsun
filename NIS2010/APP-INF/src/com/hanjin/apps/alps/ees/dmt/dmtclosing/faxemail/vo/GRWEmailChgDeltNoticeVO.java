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

public class GRWEmailChgDeltNoticeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GRWEmailChgDeltNoticeVO> models = new ArrayList<GRWEmailChgDeltNoticeVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String htmltemplate = null;
	/* Column Info */
	private String sender = null;	
	/* Column Info */
	private String recipient = null;	
	/* Column Info */
	private String subject = null;	
	/* Column Info */
	private String textcontent = null;
	/* Column Info */
	private String bkgNo = null;	
	/* Column Info */
	private String cntrNo = null;	
	/* Column Info */
	private String dmdtTrfCd = null;	
	/* Column Info */
	private String chgDeltStsCd = null;
	/* Column Info */
	private String chgDeltPathCd = null;
	/* Column Info */
	private String chgDeltUsrOfcCd = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GRWEmailChgDeltNoticeVO() {}

	public GRWEmailChgDeltNoticeVO(String ibflag, String pagerows, String htmltemplate, String sender, String recipient, String subject, String textcontent, String bkgNo, String cntrNo, String dmdtTrfCd, String chgDeltStsCd, String chgDeltPathCd, String chgDeltUsrOfcCd) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.htmltemplate = htmltemplate;
		this.sender = sender;
		this.recipient = recipient;
		this.subject = subject;
		this.textcontent = textcontent;
		this.bkgNo = bkgNo;
		this.cntrNo = cntrNo;
		this.dmdtTrfCd = dmdtTrfCd;
		this.chgDeltStsCd = chgDeltStsCd;
		this.chgDeltPathCd = chgDeltPathCd;
		this.chgDeltUsrOfcCd = chgDeltUsrOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("htmltemplate", getHtmltemplate());
		this.hashColumns.put("sender", getSender());
		this.hashColumns.put("recipient", getRecipient());
		this.hashColumns.put("subject", getSubject());
		this.hashColumns.put("textcontent", getTextcontent());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("chg_delt_sts_cd", getChgDeltStsCd());
		this.hashColumns.put("chg_delt_path_cd", getChgDeltPathCd());
		this.hashColumns.put("chg_delt_usr_ofc_cd", getChgDeltUsrOfcCd());

		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashColumns.put("ibflag", "ibflag");
		this.hashColumns.put("pagerows", "pagerows");
		this.hashColumns.put("htmltemplate", "htmltemplate");
		this.hashColumns.put("sender", "sender");
		this.hashColumns.put("recipient", "recipient");
		this.hashColumns.put("subject", "subject");
		this.hashColumns.put("textcontent", "textcontent");
		this.hashColumns.put("bkg_no", "bkgNo");
		this.hashColumns.put("cntr_no", "cntrNo");
		this.hashColumns.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashColumns.put("chg_delt_sts_cd", "chgDeltStsCd");
		this.hashColumns.put("chg_delt_path_cd", "chgDeltPathCd");
		this.hashColumns.put("chg_delt_usr_ofc_cd", "chgDeltUsrOfcCd");
		
		return this.hashFields;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
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
	 * @return htmltemplate
	 */
	public String getHtmltemplate() {
		return this.htmltemplate;
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
	 * @return recipient
	 */
	public String getRecipient() {
		return this.recipient;
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
	 * @return textcontent
	 */
	public String getTextcontent() {
		return this.textcontent;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return this.dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @return chgDeltStsCd
	 */
	public String getChgDeltStsCd() {
		return this.chgDeltStsCd;
	}
	
	/**
	 * Column Info
	 * @return chgDeltPathCd
	 */
	public String getChgDeltPathCd() {
		return this.chgDeltPathCd;
	}
	
	/**
	 * Column Info
	 * @return chgDeltUsrOfcCd
	 */
	public String getChgDeltUsrOfcCd() {
		return this.chgDeltUsrOfcCd;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
	 * @param htmltemplate
	 */
	public void setHtmltemplate(String htmltemplate) {
		this.htmltemplate = htmltemplate;
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
	 * @param recipient
	 */
	public void setRecipient(String recipient) {
		this.recipient = recipient;
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
	 * @param textcontent
	 */
	public void setTextcontent(String textcontent) {
		this.textcontent = textcontent;
	}

	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	/**
	 * Column Info
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
	}

	/**
	 * Column Info
	 * @param chgDeltStsCd
	 */
	public void setChgDeltStsCd(String chgDeltStsCd) {
		this.chgDeltStsCd = chgDeltStsCd;
	}

	/**
	 * Column Info
	 * @param chgDeltPathCd
	 */
	public void setChgDeltPathCd(String chgDeltPathCd) {
		this.chgDeltPathCd = chgDeltPathCd;
	}

	/**
	 * Column Info
	 * @param chgDeltUsrOfcCd
	 */
	public void setChgDeltUsrOfcCd(String chgDeltUsrOfcCd) {
		this.chgDeltUsrOfcCd = chgDeltUsrOfcCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setHtmltemplate(JSPUtil.getParameter(request, "htmltemplate", ""));
		setSender(JSPUtil.getParameter(request, "sender", ""));
		setRecipient(JSPUtil.getParameter(request, "recipient", ""));
		setSubject(JSPUtil.getParameter(request, "subject", ""));
		setTextcontent(JSPUtil.getParameter(request, "textcontent", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, "dmdt_trf_cd", ""));
		setChgDeltStsCd(JSPUtil.getParameter(request, "chg_delt_sts_cd", ""));
		setChgDeltPathCd(JSPUtil.getParameter(request, "chg_delt_path_cd", ""));
		setChgDeltUsrOfcCd(JSPUtil.getParameter(request, "chg_delt_usr_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GRWEmailChgDeltNoticeVO[]
	 */
	public GRWEmailChgDeltNoticeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GRWEmailChgDeltNoticeVO[]
	 */
	public GRWEmailChgDeltNoticeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GRWEmailChgDeltNoticeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
			String[] htmltemplate = (JSPUtil.getParameter(request, prefix + "htmltemplate", length));
			String[] sender = (JSPUtil.getParameter(request, prefix + "sender", length));
			String[] recipient = (JSPUtil.getParameter(request, prefix + "recipient", length));
			String[] subject = (JSPUtil.getParameter(request, prefix + "subject", length));
			String[] textcontent = (JSPUtil.getParameter(request, prefix + "textcontent", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix + "cntr_no", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", length));
			String[] chgDeltStsCd = (JSPUtil.getParameter(request, prefix + "chg_delt_sts_cd", length));
			String[] chgDeltPathCd = (JSPUtil.getParameter(request, prefix + "chg_delt_path_cd", length));
			String[] chgDeltUsrOfcCd = (JSPUtil.getParameter(request, prefix + "chg_delt_usr_ofc_cd", length));

			
			for (int i = 0; i < length; i++) {
				model = new GRWEmailChgDeltNoticeVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);	
				if (htmltemplate[i] != null)
					model.setHtmltemplate(htmltemplate[i]);
				if (sender[i] != null)
					model.setSender(sender[i]);	
				if (recipient[i] != null)
					model.setRecipient(recipient[i]);
				if (subject[i] != null)
					model.setSubject(subject[i]);	
				if (textcontent[i] != null)
					model.setTextcontent(textcontent[i]);					
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);	
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (chgDeltStsCd[i] != null)
					model.setChgDeltStsCd(chgDeltStsCd[i]);	
				if (chgDeltPathCd[i] != null)
					model.setChgDeltPathCd(chgDeltPathCd[i]);
				if (chgDeltUsrOfcCd[i] != null)
					model.setChgDeltUsrOfcCd(chgDeltUsrOfcCd[i]);	

				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGRWEmailNoticeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GRWEmailChgDeltNoticeVO[]
	 */
	public GRWEmailChgDeltNoticeVO[] getGRWEmailNoticeVOs(){
		GRWEmailChgDeltNoticeVO[] vos = (GRWEmailChgDeltNoticeVO[])models.toArray(new GRWEmailChgDeltNoticeVO[models.size()]);
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
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htmltemplate = this.htmltemplate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sender = this.sender.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.recipient = this.recipient.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subject = this.subject.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.textcontent = this.textcontent.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgDeltStsCd = this.chgDeltStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgDeltPathCd = this.chgDeltPathCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgDeltUsrOfcCd = this.chgDeltUsrOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
