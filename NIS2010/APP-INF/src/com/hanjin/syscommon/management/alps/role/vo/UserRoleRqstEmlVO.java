/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RqstRoleEmlVO.java
*@FileTitle : RqstRoleEmlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.14  
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.management.alps.role.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UserRoleRqstEmlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UserRoleRqstEmlVO> models = new ArrayList<UserRoleRqstEmlVO>();
	
	/* Column Info */
	private String rqstDt = null;
	/* Column Info */
	private String rqstUsrId = null;
	/* Column Info */
	private String subject = null;
	/* Column Info */
	private String rqstUsrNm = null;
	/* Column Info */
	private String rqstModule = null;
	/* Column Info */
	private String sendUsrEmail = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String content = null;
	/* Column Info */
	private String rqstOfcNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String receiptUsrNm = null;
	/* Column Info */
	private String sendUsrNm = null;
	/* Column Info */
	private String receiptUsrEmail = null;
	/* Column Info */
	private String rqstRoleCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public UserRoleRqstEmlVO() {}

	public UserRoleRqstEmlVO(String ibflag, String pagerows, String sendUsrNm, String sendUsrEmail, String receiptUsrNm, String receiptUsrEmail, String subject, String content, String rqstUsrId, String rqstUsrNm, String rqstOfcNm, String rqstModule, String rqstRoleCd, String rqstDt) {
		this.rqstDt = rqstDt;
		this.rqstUsrId = rqstUsrId;
		this.subject = subject;
		this.rqstUsrNm = rqstUsrNm;
		this.rqstModule = rqstModule;
		this.sendUsrEmail = sendUsrEmail;
		this.pagerows = pagerows;
		this.content = content;
		this.rqstOfcNm = rqstOfcNm;
		this.ibflag = ibflag;
		this.receiptUsrNm = receiptUsrNm;
		this.sendUsrNm = sendUsrNm;
		this.receiptUsrEmail = receiptUsrEmail;
		this.rqstRoleCd = rqstRoleCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("rqst_usr_id", getRqstUsrId());
		this.hashColumns.put("subject", getSubject());
		this.hashColumns.put("rqst_usr_nm", getRqstUsrNm());
		this.hashColumns.put("rqst_module", getRqstModule());
		this.hashColumns.put("send_usr_email", getSendUsrEmail());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("content", getContent());
		this.hashColumns.put("rqst_ofc_nm", getRqstOfcNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("receipt_usr_nm", getReceiptUsrNm());
		this.hashColumns.put("send_usr_nm", getSendUsrNm());
		this.hashColumns.put("receipt_usr_email", getReceiptUsrEmail());
		this.hashColumns.put("rqst_role_cd", getRqstRoleCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("rqst_usr_id", "rqstUsrId");
		this.hashFields.put("subject", "subject");
		this.hashFields.put("rqst_usr_nm", "rqstUsrNm");
		this.hashFields.put("rqst_module", "rqstModule");
		this.hashFields.put("send_usr_email", "sendUsrEmail");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("content", "content");
		this.hashFields.put("rqst_ofc_nm", "rqstOfcNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("receipt_usr_nm", "receiptUsrNm");
		this.hashFields.put("send_usr_nm", "sendUsrNm");
		this.hashFields.put("receipt_usr_email", "receiptUsrEmail");
		this.hashFields.put("rqst_role_cd", "rqstRoleCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rqstDt
	 */
	public String getRqstDt() {
		return this.rqstDt;
	}
	
	/**
	 * Column Info
	 * @return rqstUsrId
	 */
	public String getRqstUsrId() {
		return this.rqstUsrId;
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
	 * @return rqstUsrNm
	 */
	public String getRqstUsrNm() {
		return this.rqstUsrNm;
	}
	
	/**
	 * Column Info
	 * @return rqstModule
	 */
	public String getRqstModule() {
		return this.rqstModule;
	}
	
	/**
	 * Column Info
	 * @return sendUsrEmail
	 */
	public String getSendUsrEmail() {
		return this.sendUsrEmail;
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
	 * @return content
	 */
	public String getContent() {
		return this.content;
	}
	
	/**
	 * Column Info
	 * @return rqstOfcNm
	 */
	public String getRqstOfcNm() {
		return this.rqstOfcNm;
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
	 * @return receiptUsrNm
	 */
	public String getReceiptUsrNm() {
		return this.receiptUsrNm;
	}
	
	/**
	 * Column Info
	 * @return sendUsrNm
	 */
	public String getSendUsrNm() {
		return this.sendUsrNm;
	}
	
	/**
	 * Column Info
	 * @return receiptUsrEmail
	 */
	public String getReceiptUsrEmail() {
		return this.receiptUsrEmail;
	}
	
	/**
	 * Column Info
	 * @return rqstRoleCd
	 */
	public String getRqstRoleCd() {
		return this.rqstRoleCd;
	}
	

	/**
	 * Column Info
	 * @param rqstDt
	 */
	public void setRqstDt(String rqstDt) {
		this.rqstDt = rqstDt;
	}
	
	/**
	 * Column Info
	 * @param rqstUsrId
	 */
	public void setRqstUsrId(String rqstUsrId) {
		this.rqstUsrId = rqstUsrId;
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
	 * @param rqstUsrNm
	 */
	public void setRqstUsrNm(String rqstUsrNm) {
		this.rqstUsrNm = rqstUsrNm;
	}
	
	/**
	 * Column Info
	 * @param rqstModule
	 */
	public void setRqstModule(String rqstModule) {
		this.rqstModule = rqstModule;
	}
	
	/**
	 * Column Info
	 * @param sendUsrEmail
	 */
	public void setSendUsrEmail(String sendUsrEmail) {
		this.sendUsrEmail = sendUsrEmail;
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
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * Column Info
	 * @param rqstOfcNm
	 */
	public void setRqstOfcNm(String rqstOfcNm) {
		this.rqstOfcNm = rqstOfcNm;
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
	 * @param receiptUsrNm
	 */
	public void setReceiptUsrNm(String receiptUsrNm) {
		this.receiptUsrNm = receiptUsrNm;
	}
	
	/**
	 * Column Info
	 * @param sendUsrNm
	 */
	public void setSendUsrNm(String sendUsrNm) {
		this.sendUsrNm = sendUsrNm;
	}
	
	/**
	 * Column Info
	 * @param receiptUsrEmail
	 */
	public void setReceiptUsrEmail(String receiptUsrEmail) {
		this.receiptUsrEmail = receiptUsrEmail;
	}
	
	/**
	 * Column Info
	 * @param rqstRoleCd
	 */
	public void setRqstRoleCd(String rqstRoleCd) {
		this.rqstRoleCd = rqstRoleCd;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
		setRqstUsrId(JSPUtil.getParameter(request, prefix + "rqst_usr_id", ""));
		setSubject(JSPUtil.getParameter(request, prefix + "subject", ""));
		setRqstUsrNm(JSPUtil.getParameter(request, prefix + "rqst_usr_nm", ""));
		setRqstModule(JSPUtil.getParameter(request, prefix + "rqst_module", ""));
		setSendUsrEmail(JSPUtil.getParameter(request, prefix + "send_usr_email", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setContent(JSPUtil.getParameter(request, prefix + "content", ""));
		setRqstOfcNm(JSPUtil.getParameter(request, prefix + "rqst_ofc_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setReceiptUsrNm(JSPUtil.getParameter(request, prefix + "receipt_usr_nm", ""));
		setSendUsrNm(JSPUtil.getParameter(request, prefix + "send_usr_nm", ""));
		setReceiptUsrEmail(JSPUtil.getParameter(request, prefix + "receipt_usr_email", ""));
		setRqstRoleCd(JSPUtil.getParameter(request, prefix + "rqst_role_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RqstRoleEmlVO[]
	 */
	public UserRoleRqstEmlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RqstRoleEmlVO[]
	 */
	public UserRoleRqstEmlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UserRoleRqstEmlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] rqstUsrId = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_id", length));
			String[] subject = (JSPUtil.getParameter(request, prefix	+ "subject", length));
			String[] rqstUsrNm = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_nm", length));
			String[] rqstModule = (JSPUtil.getParameter(request, prefix	+ "rqst_module", length));
			String[] sendUsrEmail = (JSPUtil.getParameter(request, prefix	+ "send_usr_email", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] content = (JSPUtil.getParameter(request, prefix	+ "content", length));
			String[] rqstOfcNm = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] receiptUsrNm = (JSPUtil.getParameter(request, prefix	+ "receipt_usr_nm", length));
			String[] sendUsrNm = (JSPUtil.getParameter(request, prefix	+ "send_usr_nm", length));
			String[] receiptUsrEmail = (JSPUtil.getParameter(request, prefix	+ "receipt_usr_email", length));
			String[] rqstRoleCd = (JSPUtil.getParameter(request, prefix	+ "rqst_role_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new UserRoleRqstEmlVO();
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (rqstUsrId[i] != null)
					model.setRqstUsrId(rqstUsrId[i]);
				if (subject[i] != null)
					model.setSubject(subject[i]);
				if (rqstUsrNm[i] != null)
					model.setRqstUsrNm(rqstUsrNm[i]);
				if (rqstModule[i] != null)
					model.setRqstModule(rqstModule[i]);
				if (sendUsrEmail[i] != null)
					model.setSendUsrEmail(sendUsrEmail[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (content[i] != null)
					model.setContent(content[i]);
				if (rqstOfcNm[i] != null)
					model.setRqstOfcNm(rqstOfcNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (receiptUsrNm[i] != null)
					model.setReceiptUsrNm(receiptUsrNm[i]);
				if (sendUsrNm[i] != null)
					model.setSendUsrNm(sendUsrNm[i]);
				if (receiptUsrEmail[i] != null)
					model.setReceiptUsrEmail(receiptUsrEmail[i]);
				if (rqstRoleCd[i] != null)
					model.setRqstRoleCd(rqstRoleCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRqstRoleEmlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RqstRoleEmlVO[]
	 */
	public UserRoleRqstEmlVO[] getRqstRoleEmlVOs(){
		UserRoleRqstEmlVO[] vos = (UserRoleRqstEmlVO[])models.toArray(new UserRoleRqstEmlVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrId = this.rqstUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subject = this.subject .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrNm = this.rqstUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstModule = this.rqstModule .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendUsrEmail = this.sendUsrEmail .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.content = this.content .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcNm = this.rqstOfcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.receiptUsrNm = this.receiptUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendUsrNm = this.sendUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.receiptUsrEmail = this.receiptUsrEmail .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstRoleCd = this.rqstRoleCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
