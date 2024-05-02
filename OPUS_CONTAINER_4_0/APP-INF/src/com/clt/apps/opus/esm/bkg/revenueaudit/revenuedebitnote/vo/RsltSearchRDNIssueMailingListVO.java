/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltSearchRDNIssueMailingListVO.java
*@FileTitle : RsltSearchRDNIssueMailingListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.09
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2010.02.09 김대호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김대호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltSearchRDNIssueMailingListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltSearchRDNIssueMailingListVO> models = new ArrayList<RsltSearchRDNIssueMailingListVO>();
	
	/* Column Info */
	private String errorKind = null;
	/* Column Info */
	private String mailTitle = null;
	/* Column Info */
	private String rctOfcCd = null;
	/* Column Info */
	private String umchRmk = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String contFm = null;
	/* Column Info */
	private String rdnNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rdnIssDtWk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String userGb = null;
	/* Column Info */
	private String scRfaNo = null;
	/* Column Info */
	private String groupGb = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String sufStr = null;
	/* Column Info */
	private String usrEml = null;
	/* Column Info */
	private String rdnIssDt = null;
	/* Column Info */
	private String preStr = null;
	/* Column Info */
	private String rdnAmount = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltSearchRDNIssueMailingListVO() {}

	public RsltSearchRDNIssueMailingListVO(String ibflag, String pagerows, String userGb, String groupGb, String blNo, String usrId, String usrEml, String preStr, String sufStr, String mailTitle, String rctOfcCd, String contFm, String rdnNo, String rdnAmount, String rdnIssDt, String rdnIssDtWk, String scRfaNo, String errorKind, String umchRmk) {
		this.errorKind = errorKind;
		this.mailTitle = mailTitle;
		this.rctOfcCd = rctOfcCd;
		this.umchRmk = umchRmk;
		this.blNo = blNo;
		this.contFm = contFm;
		this.rdnNo = rdnNo;
		this.pagerows = pagerows;
		this.rdnIssDtWk = rdnIssDtWk;
		this.ibflag = ibflag;
		this.userGb = userGb;
		this.scRfaNo = scRfaNo;
		this.groupGb = groupGb;
		this.usrId = usrId;
		this.sufStr = sufStr;
		this.usrEml = usrEml;
		this.rdnIssDt = rdnIssDt;
		this.preStr = preStr;
		this.rdnAmount = rdnAmount;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("error_kind", getErrorKind());
		this.hashColumns.put("mail_title", getMailTitle());
		this.hashColumns.put("rct_ofc_cd", getRctOfcCd());
		this.hashColumns.put("umch_rmk", getUmchRmk());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("cont_fm", getContFm());
		this.hashColumns.put("rdn_no", getRdnNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rdn_iss_dt_wk", getRdnIssDtWk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("user_gb", getUserGb());
		this.hashColumns.put("sc_rfa_no", getScRfaNo());
		this.hashColumns.put("group_gb", getGroupGb());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("suf_str", getSufStr());
		this.hashColumns.put("usr_eml", getUsrEml());
		this.hashColumns.put("rdn_iss_dt", getRdnIssDt());
		this.hashColumns.put("pre_str", getPreStr());
		this.hashColumns.put("rdn_amount", getRdnAmount());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("error_kind", "errorKind");
		this.hashFields.put("mail_title", "mailTitle");
		this.hashFields.put("rct_ofc_cd", "rctOfcCd");
		this.hashFields.put("umch_rmk", "umchRmk");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("cont_fm", "contFm");
		this.hashFields.put("rdn_no", "rdnNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rdn_iss_dt_wk", "rdnIssDtWk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("user_gb", "userGb");
		this.hashFields.put("sc_rfa_no", "scRfaNo");
		this.hashFields.put("group_gb", "groupGb");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("suf_str", "sufStr");
		this.hashFields.put("usr_eml", "usrEml");
		this.hashFields.put("rdn_iss_dt", "rdnIssDt");
		this.hashFields.put("pre_str", "preStr");
		this.hashFields.put("rdn_amount", "rdnAmount");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return errorKind
	 */
	public String getErrorKind() {
		return this.errorKind;
	}
	
	/**
	 * Column Info
	 * @return mailTitle
	 */
	public String getMailTitle() {
		return this.mailTitle;
	}
	
	/**
	 * Column Info
	 * @return rctOfcCd
	 */
	public String getRctOfcCd() {
		return this.rctOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rdnRmk
	 */
	public String getUmchRmk() {
		return this.umchRmk;
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
	 * @return contFm
	 */
	public String getContFm() {
		return this.contFm;
	}
	
	/**
	 * Column Info
	 * @return rdnNo
	 */
	public String getRdnNo() {
		return this.rdnNo;
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
	 * @return rdnIssDtWk
	 */
	public String getRdnIssDtWk() {
		return this.rdnIssDtWk;
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
	 * @return userGb
	 */
	public String getUserGb() {
		return this.userGb;
	}
	
	/**
	 * Column Info
	 * @return scRfaNo
	 */
	public String getScRfaNo() {
		return this.scRfaNo;
	}
	
	/**
	 * Column Info
	 * @return groupGb
	 */
	public String getGroupGb() {
		return this.groupGb;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return sufStr
	 */
	public String getSufStr() {
		return this.sufStr;
	}
	
	/**
	 * Column Info
	 * @return usrEml
	 */
	public String getUsrEml() {
		return this.usrEml;
	}
	
	/**
	 * Column Info
	 * @return rdnIssDt
	 */
	public String getRdnIssDt() {
		return this.rdnIssDt;
	}
	
	/**
	 * Column Info
	 * @return preStr
	 */
	public String getPreStr() {
		return this.preStr;
	}
	
	/**
	 * Column Info
	 * @return rdnAmount
	 */
	public String getRdnAmount() {
		return this.rdnAmount;
	}
	

	/**
	 * Column Info
	 * @param errorKind
	 */
	public void setErrorKind(String errorKind) {
		this.errorKind = errorKind;
	}
	
	/**
	 * Column Info
	 * @param mailTitle
	 */
	public void setMailTitle(String mailTitle) {
		this.mailTitle = mailTitle;
	}
	
	/**
	 * Column Info
	 * @param rctOfcCd
	 */
	public void setRctOfcCd(String rctOfcCd) {
		this.rctOfcCd = rctOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rdnRmk
	 */
	public void setRdnRmk(String rdnRmk) {
		this.umchRmk = rdnRmk;
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
	 * @param contFm
	 */
	public void setContFm(String contFm) {
		this.contFm = contFm;
	}
	
	/**
	 * Column Info
	 * @param rdnNo
	 */
	public void setRdnNo(String rdnNo) {
		this.rdnNo = rdnNo;
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
	 * @param rdnIssDtWk
	 */
	public void setRdnIssDtWk(String rdnIssDtWk) {
		this.rdnIssDtWk = rdnIssDtWk;
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
	 * @param userGb
	 */
	public void setUserGb(String userGb) {
		this.userGb = userGb;
	}
	
	/**
	 * Column Info
	 * @param scRfaNo
	 */
	public void setScRfaNo(String scRfaNo) {
		this.scRfaNo = scRfaNo;
	}
	
	/**
	 * Column Info
	 * @param groupGb
	 */
	public void setGroupGb(String groupGb) {
		this.groupGb = groupGb;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param sufStr
	 */
	public void setSufStr(String sufStr) {
		this.sufStr = sufStr;
	}
	
	/**
	 * Column Info
	 * @param usrEml
	 */
	public void setUsrEml(String usrEml) {
		this.usrEml = usrEml;
	}
	
	/**
	 * Column Info
	 * @param rdnIssDt
	 */
	public void setRdnIssDt(String rdnIssDt) {
		this.rdnIssDt = rdnIssDt;
	}
	
	/**
	 * Column Info
	 * @param preStr
	 */
	public void setPreStr(String preStr) {
		this.preStr = preStr;
	}
	
	/**
	 * Column Info
	 * @param rdnAmount
	 */
	public void setRdnAmount(String rdnAmount) {
		this.rdnAmount = rdnAmount;
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
		setErrorKind(JSPUtil.getParameter(request, prefix + "error_kind", ""));
		setMailTitle(JSPUtil.getParameter(request, prefix + "mail_title", ""));
		setRctOfcCd(JSPUtil.getParameter(request, prefix + "rct_ofc_cd", ""));
		setRdnRmk(JSPUtil.getParameter(request, prefix + "umch_rmk", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setContFm(JSPUtil.getParameter(request, prefix + "cont_fm", ""));
		setRdnNo(JSPUtil.getParameter(request, prefix + "rdn_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRdnIssDtWk(JSPUtil.getParameter(request, prefix + "rdn_iss_dt_wk", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUserGb(JSPUtil.getParameter(request, prefix + "user_gb", ""));
		setScRfaNo(JSPUtil.getParameter(request, prefix + "sc_rfa_no", ""));
		setGroupGb(JSPUtil.getParameter(request, prefix + "group_gb", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setSufStr(JSPUtil.getParameter(request, prefix + "suf_str", ""));
		setUsrEml(JSPUtil.getParameter(request, prefix + "usr_eml", ""));
		setRdnIssDt(JSPUtil.getParameter(request, prefix + "rdn_iss_dt", ""));
		setPreStr(JSPUtil.getParameter(request, prefix + "pre_str", ""));
		setRdnAmount(JSPUtil.getParameter(request, prefix + "rdn_amount", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltSearchRDNIssueMailingListVO[]
	 */
	public RsltSearchRDNIssueMailingListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltSearchRDNIssueMailingListVO[]
	 */
	public RsltSearchRDNIssueMailingListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltSearchRDNIssueMailingListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] errorKind = (JSPUtil.getParameter(request, prefix	+ "error_kind", length));
			String[] mailTitle = (JSPUtil.getParameter(request, prefix	+ "mail_title", length));
			String[] rctOfcCd = (JSPUtil.getParameter(request, prefix	+ "rct_ofc_cd", length));
			String[] rdnRmk = (JSPUtil.getParameter(request, prefix	+ "umch_rmk", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] contFm = (JSPUtil.getParameter(request, prefix	+ "cont_fm", length));
			String[] rdnNo = (JSPUtil.getParameter(request, prefix	+ "rdn_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rdnIssDtWk = (JSPUtil.getParameter(request, prefix	+ "rdn_iss_dt_wk", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] userGb = (JSPUtil.getParameter(request, prefix	+ "user_gb", length));
			String[] scRfaNo = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_no", length));
			String[] groupGb = (JSPUtil.getParameter(request, prefix	+ "group_gb", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] sufStr = (JSPUtil.getParameter(request, prefix	+ "suf_str", length));
			String[] usrEml = (JSPUtil.getParameter(request, prefix	+ "usr_eml", length));
			String[] rdnIssDt = (JSPUtil.getParameter(request, prefix	+ "rdn_iss_dt", length));
			String[] preStr = (JSPUtil.getParameter(request, prefix	+ "pre_str", length));
			String[] rdnAmount = (JSPUtil.getParameter(request, prefix	+ "rdn_amount", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltSearchRDNIssueMailingListVO();
				if (errorKind[i] != null)
					model.setErrorKind(errorKind[i]);
				if (mailTitle[i] != null)
					model.setMailTitle(mailTitle[i]);
				if (rctOfcCd[i] != null)
					model.setRctOfcCd(rctOfcCd[i]);
				if (rdnRmk[i] != null)
					model.setRdnRmk(rdnRmk[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (contFm[i] != null)
					model.setContFm(contFm[i]);
				if (rdnNo[i] != null)
					model.setRdnNo(rdnNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rdnIssDtWk[i] != null)
					model.setRdnIssDtWk(rdnIssDtWk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (userGb[i] != null)
					model.setUserGb(userGb[i]);
				if (scRfaNo[i] != null)
					model.setScRfaNo(scRfaNo[i]);
				if (groupGb[i] != null)
					model.setGroupGb(groupGb[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (sufStr[i] != null)
					model.setSufStr(sufStr[i]);
				if (usrEml[i] != null)
					model.setUsrEml(usrEml[i]);
				if (rdnIssDt[i] != null)
					model.setRdnIssDt(rdnIssDt[i]);
				if (preStr[i] != null)
					model.setPreStr(preStr[i]);
				if (rdnAmount[i] != null)
					model.setRdnAmount(rdnAmount[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltSearchRDNIssueMailingListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltSearchRDNIssueMailingListVO[]
	 */
	public RsltSearchRDNIssueMailingListVO[] getRsltSearchRDNIssueMailingListVOs(){
		RsltSearchRDNIssueMailingListVO[] vos = (RsltSearchRDNIssueMailingListVO[])models.toArray(new RsltSearchRDNIssueMailingListVO[models.size()]);
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
		this.errorKind = this.errorKind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mailTitle = this.mailTitle .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctOfcCd = this.rctOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchRmk = this.umchRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contFm = this.contFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdnNo = this.rdnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdnIssDtWk = this.rdnIssDtWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userGb = this.userGb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaNo = this.scRfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.groupGb = this.groupGb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sufStr = this.sufStr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrEml = this.usrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdnIssDt = this.rdnIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preStr = this.preStr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdnAmount = this.rdnAmount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
