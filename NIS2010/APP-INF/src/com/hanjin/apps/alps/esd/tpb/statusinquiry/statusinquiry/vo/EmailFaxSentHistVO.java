/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EmailFaxSentHistVO.java
*@FileTitle : EmailFaxSentHistVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.23  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.vo;

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

public class EmailFaxSentHistVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EmailFaxSentHistVO> models = new ArrayList<EmailFaxSentHistVO>();
	
	/* Column Info */
	private String sCustSeq = null;
	/* Column Info */
	private String n3ptyInvRvisCd = null;
	/* Column Info */
	private String sndDt = null;
	/* Column Info */
	private String sIfCtrlCd = null;
	/* Column Info */
	private String n3ptyInvNo = null;
	/* Column Info */
	private String issUsrId = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sN3ptyInvNo = null;
	/* Column Info */
	private String trdPartyNm = null;
	/* Column Info */
	private String sEdate = null;
	/* Column Info */
	private String vndrCustEmlFax = null;
	/* Column Info */
	private String n3ptyInvSndTpCd = null;
	/* Column Info */
	private String sVndrSeq = null;
	/* Column Info */
	private String sCustCntCd = null;
	/* Column Info */
	private String sSdate = null;
	/* Column Info */
	private String sIfOfcCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String invIssLoclDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String sndrid = null;
	/* Column Info */
	private String faxEmlSndRsltMsg = null;
	/* Column Info */
	private String sN3ptyIfTpCd = null;
	/* Column Info */
	private String sIfRhqCd = null;
	/* Column Info */
	private String trdPartyCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public EmailFaxSentHistVO() {}

	public EmailFaxSentHistVO(String ibflag, String pagerows, String n3ptyInvNo, String n3ptyInvRvisCd, String trdPartyCd, String trdPartyNm, String n3ptyInvSndTpCd, String vndrCustEmlFax, String sndDt, String faxEmlSndRsltMsg, String creUsrId, String invIssLoclDt, String issUsrId, String ofcCd, String sSdate, String sEdate, String sN3ptyInvNo, String sIfRhqCd, String sIfCtrlCd, String sIfOfcCd, String sN3ptyIfTpCd, String sVndrSeq, String sCustCntCd, String sCustSeq, String sndrid) {
		this.sCustSeq = sCustSeq;
		this.n3ptyInvRvisCd = n3ptyInvRvisCd;
		this.sndDt = sndDt;
		this.sIfCtrlCd = sIfCtrlCd;
		this.n3ptyInvNo = n3ptyInvNo;
		this.issUsrId = issUsrId;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.sN3ptyInvNo = sN3ptyInvNo;
		this.trdPartyNm = trdPartyNm;
		this.sEdate = sEdate;
		this.vndrCustEmlFax = vndrCustEmlFax;
		this.n3ptyInvSndTpCd = n3ptyInvSndTpCd;
		this.sVndrSeq = sVndrSeq;
		this.sCustCntCd = sCustCntCd;
		this.sSdate = sSdate;
		this.sIfOfcCd = sIfOfcCd;
		this.ofcCd = ofcCd;
		this.invIssLoclDt = invIssLoclDt;
		this.creUsrId = creUsrId;
		this.sndrid = sndrid;
		this.faxEmlSndRsltMsg = faxEmlSndRsltMsg;
		this.sN3ptyIfTpCd = sN3ptyIfTpCd;
		this.sIfRhqCd = sIfRhqCd;
		this.trdPartyCd = trdPartyCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("s_cust_seq", getSCustSeq());
		this.hashColumns.put("n3pty_inv_rvis_cd", getN3ptyInvRvisCd());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("s_if_ctrl_cd", getSIfCtrlCd());
		this.hashColumns.put("n3pty_inv_no", getN3ptyInvNo());
		this.hashColumns.put("iss_usr_id", getIssUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s_n3pty_inv_no", getSN3ptyInvNo());
		this.hashColumns.put("trd_party_nm", getTrdPartyNm());
		this.hashColumns.put("s_edate", getSEdate());
		this.hashColumns.put("vndr_cust_eml_fax", getVndrCustEmlFax());
		this.hashColumns.put("n3pty_inv_snd_tp_cd", getN3ptyInvSndTpCd());
		this.hashColumns.put("s_vndr_seq", getSVndrSeq());
		this.hashColumns.put("s_cust_cnt_cd", getSCustCntCd());
		this.hashColumns.put("s_sdate", getSSdate());
		this.hashColumns.put("s_if_ofc_cd", getSIfOfcCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("inv_iss_locl_dt", getInvIssLoclDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("sndrid", getSndrid());
		this.hashColumns.put("fax_eml_snd_rslt_msg", getFaxEmlSndRsltMsg());
		this.hashColumns.put("s_n3pty_if_tp_cd", getSN3ptyIfTpCd());
		this.hashColumns.put("s_if_rhq_cd", getSIfRhqCd());
		this.hashColumns.put("trd_party_cd", getTrdPartyCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("s_cust_seq", "sCustSeq");
		this.hashFields.put("n3pty_inv_rvis_cd", "n3ptyInvRvisCd");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("s_if_ctrl_cd", "sIfCtrlCd");
		this.hashFields.put("n3pty_inv_no", "n3ptyInvNo");
		this.hashFields.put("iss_usr_id", "issUsrId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s_n3pty_inv_no", "sN3ptyInvNo");
		this.hashFields.put("trd_party_nm", "trdPartyNm");
		this.hashFields.put("s_edate", "sEdate");
		this.hashFields.put("vndr_cust_eml_fax", "vndrCustEmlFax");
		this.hashFields.put("n3pty_inv_snd_tp_cd", "n3ptyInvSndTpCd");
		this.hashFields.put("s_vndr_seq", "sVndrSeq");
		this.hashFields.put("s_cust_cnt_cd", "sCustCntCd");
		this.hashFields.put("s_sdate", "sSdate");
		this.hashFields.put("s_if_ofc_cd", "sIfOfcCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("inv_iss_locl_dt", "invIssLoclDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("sndrid", "sndrid");
		this.hashFields.put("fax_eml_snd_rslt_msg", "faxEmlSndRsltMsg");
		this.hashFields.put("s_n3pty_if_tp_cd", "sN3ptyIfTpCd");
		this.hashFields.put("s_if_rhq_cd", "sIfRhqCd");
		this.hashFields.put("trd_party_cd", "trdPartyCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sCustSeq
	 */
	public String getSCustSeq() {
		return this.sCustSeq;
	}
	
	/**
	 * Column Info
	 * @return n3ptyInvRvisCd
	 */
	public String getN3ptyInvRvisCd() {
		return this.n3ptyInvRvisCd;
	}
	
	/**
	 * Column Info
	 * @return sndDt
	 */
	public String getSndDt() {
		return this.sndDt;
	}
	
	/**
	 * Column Info
	 * @return sIfCtrlCd
	 */
	public String getSIfCtrlCd() {
		return this.sIfCtrlCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyInvNo
	 */
	public String getN3ptyInvNo() {
		return this.n3ptyInvNo;
	}
	
	/**
	 * Column Info
	 * @return issUsrId
	 */
	public String getIssUsrId() {
		return this.issUsrId;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return sN3ptyInvNo
	 */
	public String getSN3ptyInvNo() {
		return this.sN3ptyInvNo;
	}
	
	/**
	 * Column Info
	 * @return trdPartyNm
	 */
	public String getTrdPartyNm() {
		return this.trdPartyNm;
	}
	
	/**
	 * Column Info
	 * @return sEdate
	 */
	public String getSEdate() {
		return this.sEdate;
	}
	
	/**
	 * Column Info
	 * @return vndrCustEmlFax
	 */
	public String getVndrCustEmlFax() {
		return this.vndrCustEmlFax;
	}
	
	/**
	 * Column Info
	 * @return n3ptyInvSndTpCd
	 */
	public String getN3ptyInvSndTpCd() {
		return this.n3ptyInvSndTpCd;
	}
	
	/**
	 * Column Info
	 * @return sVndrSeq
	 */
	public String getSVndrSeq() {
		return this.sVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return sCustCntCd
	 */
	public String getSCustCntCd() {
		return this.sCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return sSdate
	 */
	public String getSSdate() {
		return this.sSdate;
	}
	
	/**
	 * Column Info
	 * @return sIfOfcCd
	 */
	public String getSIfOfcCd() {
		return this.sIfOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return invIssLoclDt
	 */
	public String getInvIssLoclDt() {
		return this.invIssLoclDt;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return sndrid
	 */
	public String getSndrid() {
		return this.sndrid;
	}
	
	/**
	 * Column Info
	 * @return faxEmlSndRsltMsg
	 */
	public String getFaxEmlSndRsltMsg() {
		return this.faxEmlSndRsltMsg;
	}
	
	/**
	 * Column Info
	 * @return sN3ptyIfTpCd
	 */
	public String getSN3ptyIfTpCd() {
		return this.sN3ptyIfTpCd;
	}
	
	/**
	 * Column Info
	 * @return sIfRhqCd
	 */
	public String getSIfRhqCd() {
		return this.sIfRhqCd;
	}
	
	/**
	 * Column Info
	 * @return trdPartyCd
	 */
	public String getTrdPartyCd() {
		return this.trdPartyCd;
	}
	

	/**
	 * Column Info
	 * @param sCustSeq
	 */
	public void setSCustSeq(String sCustSeq) {
		this.sCustSeq = sCustSeq;
	}
	
	/**
	 * Column Info
	 * @param n3ptyInvRvisCd
	 */
	public void setN3ptyInvRvisCd(String n3ptyInvRvisCd) {
		this.n3ptyInvRvisCd = n3ptyInvRvisCd;
	}
	
	/**
	 * Column Info
	 * @param sndDt
	 */
	public void setSndDt(String sndDt) {
		this.sndDt = sndDt;
	}
	
	/**
	 * Column Info
	 * @param sIfCtrlCd
	 */
	public void setSIfCtrlCd(String sIfCtrlCd) {
		this.sIfCtrlCd = sIfCtrlCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyInvNo
	 */
	public void setN3ptyInvNo(String n3ptyInvNo) {
		this.n3ptyInvNo = n3ptyInvNo;
	}
	
	/**
	 * Column Info
	 * @param issUsrId
	 */
	public void setIssUsrId(String issUsrId) {
		this.issUsrId = issUsrId;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param sN3ptyInvNo
	 */
	public void setSN3ptyInvNo(String sN3ptyInvNo) {
		this.sN3ptyInvNo = sN3ptyInvNo;
	}
	
	/**
	 * Column Info
	 * @param trdPartyNm
	 */
	public void setTrdPartyNm(String trdPartyNm) {
		this.trdPartyNm = trdPartyNm;
	}
	
	/**
	 * Column Info
	 * @param sEdate
	 */
	public void setSEdate(String sEdate) {
		this.sEdate = sEdate;
	}
	
	/**
	 * Column Info
	 * @param vndrCustEmlFax
	 */
	public void setVndrCustEmlFax(String vndrCustEmlFax) {
		this.vndrCustEmlFax = vndrCustEmlFax;
	}
	
	/**
	 * Column Info
	 * @param n3ptyInvSndTpCd
	 */
	public void setN3ptyInvSndTpCd(String n3ptyInvSndTpCd) {
		this.n3ptyInvSndTpCd = n3ptyInvSndTpCd;
	}
	
	/**
	 * Column Info
	 * @param sVndrSeq
	 */
	public void setSVndrSeq(String sVndrSeq) {
		this.sVndrSeq = sVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param sCustCntCd
	 */
	public void setSCustCntCd(String sCustCntCd) {
		this.sCustCntCd = sCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param sSdate
	 */
	public void setSSdate(String sSdate) {
		this.sSdate = sSdate;
	}
	
	/**
	 * Column Info
	 * @param sIfOfcCd
	 */
	public void setSIfOfcCd(String sIfOfcCd) {
		this.sIfOfcCd = sIfOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param invIssLoclDt
	 */
	public void setInvIssLoclDt(String invIssLoclDt) {
		this.invIssLoclDt = invIssLoclDt;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param sndrid
	 */
	public void setSndrid(String sndrid) {
		this.sndrid = sndrid;
	}
	
	/**
	 * Column Info
	 * @param faxEmlSndRsltMsg
	 */
	public void setFaxEmlSndRsltMsg(String faxEmlSndRsltMsg) {
		this.faxEmlSndRsltMsg = faxEmlSndRsltMsg;
	}
	
	/**
	 * Column Info
	 * @param sN3ptyIfTpCd
	 */
	public void setSN3ptyIfTpCd(String sN3ptyIfTpCd) {
		this.sN3ptyIfTpCd = sN3ptyIfTpCd;
	}
	
	/**
	 * Column Info
	 * @param sIfRhqCd
	 */
	public void setSIfRhqCd(String sIfRhqCd) {
		this.sIfRhqCd = sIfRhqCd;
	}
	
	/**
	 * Column Info
	 * @param trdPartyCd
	 */
	public void setTrdPartyCd(String trdPartyCd) {
		this.trdPartyCd = trdPartyCd;
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
		setSCustSeq(JSPUtil.getParameter(request, prefix + "s_cust_seq", ""));
		setN3ptyInvRvisCd(JSPUtil.getParameter(request, prefix + "n3pty_inv_rvis_cd", ""));
		setSndDt(JSPUtil.getParameter(request, prefix + "snd_dt", ""));
		setSIfCtrlCd(JSPUtil.getParameter(request, prefix + "s_if_ctrl_cd", ""));
		setN3ptyInvNo(JSPUtil.getParameter(request, prefix + "n3pty_inv_no", ""));
		setIssUsrId(JSPUtil.getParameter(request, prefix + "iss_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSN3ptyInvNo(JSPUtil.getParameter(request, prefix + "s_n3pty_inv_no", ""));
		setTrdPartyNm(JSPUtil.getParameter(request, prefix + "trd_party_nm", ""));
		setSEdate(JSPUtil.getParameter(request, prefix + "s_edate", ""));
		setVndrCustEmlFax(JSPUtil.getParameter(request, prefix + "vndr_cust_eml_fax", ""));
		setN3ptyInvSndTpCd(JSPUtil.getParameter(request, prefix + "n3pty_inv_snd_tp_cd", ""));
		setSVndrSeq(JSPUtil.getParameter(request, prefix + "s_vndr_seq", ""));
		setSCustCntCd(JSPUtil.getParameter(request, prefix + "s_cust_cnt_cd", ""));
		setSSdate(JSPUtil.getParameter(request, prefix + "s_sdate", ""));
		setSIfOfcCd(JSPUtil.getParameter(request, prefix + "s_if_ofc_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setInvIssLoclDt(JSPUtil.getParameter(request, prefix + "inv_iss_locl_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSndrid(JSPUtil.getParameter(request, prefix + "sndrid", ""));
		setFaxEmlSndRsltMsg(JSPUtil.getParameter(request, prefix + "fax_eml_snd_rslt_msg", ""));
		setSN3ptyIfTpCd(JSPUtil.getParameter(request, prefix + "s_n3pty_if_tp_cd", ""));
		setSIfRhqCd(JSPUtil.getParameter(request, prefix + "s_if_rhq_cd", ""));
		setTrdPartyCd(JSPUtil.getParameter(request, prefix + "trd_party_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EmailFaxSentHistVO[]
	 */
	public EmailFaxSentHistVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EmailFaxSentHistVO[]
	 */
	public EmailFaxSentHistVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EmailFaxSentHistVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sCustSeq = (JSPUtil.getParameter(request, prefix	+ "s_cust_seq", length));
			String[] n3ptyInvRvisCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_inv_rvis_cd", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] sIfCtrlCd = (JSPUtil.getParameter(request, prefix	+ "s_if_ctrl_cd", length));
			String[] n3ptyInvNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_inv_no", length));
			String[] issUsrId = (JSPUtil.getParameter(request, prefix	+ "iss_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sN3ptyInvNo = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_inv_no", length));
			String[] trdPartyNm = (JSPUtil.getParameter(request, prefix	+ "trd_party_nm", length));
			String[] sEdate = (JSPUtil.getParameter(request, prefix	+ "s_edate", length));
			String[] vndrCustEmlFax = (JSPUtil.getParameter(request, prefix	+ "vndr_cust_eml_fax", length));
			String[] n3ptyInvSndTpCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_inv_snd_tp_cd", length));
			String[] sVndrSeq = (JSPUtil.getParameter(request, prefix	+ "s_vndr_seq", length));
			String[] sCustCntCd = (JSPUtil.getParameter(request, prefix	+ "s_cust_cnt_cd", length));
			String[] sSdate = (JSPUtil.getParameter(request, prefix	+ "s_sdate", length));
			String[] sIfOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_if_ofc_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] invIssLoclDt = (JSPUtil.getParameter(request, prefix	+ "inv_iss_locl_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] sndrid = (JSPUtil.getParameter(request, prefix	+ "sndrid", length));
			String[] faxEmlSndRsltMsg = (JSPUtil.getParameter(request, prefix	+ "fax_eml_snd_rslt_msg", length));
			String[] sN3ptyIfTpCd = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_if_tp_cd", length));
			String[] sIfRhqCd = (JSPUtil.getParameter(request, prefix	+ "s_if_rhq_cd", length));
			String[] trdPartyCd = (JSPUtil.getParameter(request, prefix	+ "trd_party_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new EmailFaxSentHistVO();
				if (sCustSeq[i] != null)
					model.setSCustSeq(sCustSeq[i]);
				if (n3ptyInvRvisCd[i] != null)
					model.setN3ptyInvRvisCd(n3ptyInvRvisCd[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (sIfCtrlCd[i] != null)
					model.setSIfCtrlCd(sIfCtrlCd[i]);
				if (n3ptyInvNo[i] != null)
					model.setN3ptyInvNo(n3ptyInvNo[i]);
				if (issUsrId[i] != null)
					model.setIssUsrId(issUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sN3ptyInvNo[i] != null)
					model.setSN3ptyInvNo(sN3ptyInvNo[i]);
				if (trdPartyNm[i] != null)
					model.setTrdPartyNm(trdPartyNm[i]);
				if (sEdate[i] != null)
					model.setSEdate(sEdate[i]);
				if (vndrCustEmlFax[i] != null)
					model.setVndrCustEmlFax(vndrCustEmlFax[i]);
				if (n3ptyInvSndTpCd[i] != null)
					model.setN3ptyInvSndTpCd(n3ptyInvSndTpCd[i]);
				if (sVndrSeq[i] != null)
					model.setSVndrSeq(sVndrSeq[i]);
				if (sCustCntCd[i] != null)
					model.setSCustCntCd(sCustCntCd[i]);
				if (sSdate[i] != null)
					model.setSSdate(sSdate[i]);
				if (sIfOfcCd[i] != null)
					model.setSIfOfcCd(sIfOfcCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (invIssLoclDt[i] != null)
					model.setInvIssLoclDt(invIssLoclDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (sndrid[i] != null)
					model.setSndrid(sndrid[i]);
				if (faxEmlSndRsltMsg[i] != null)
					model.setFaxEmlSndRsltMsg(faxEmlSndRsltMsg[i]);
				if (sN3ptyIfTpCd[i] != null)
					model.setSN3ptyIfTpCd(sN3ptyIfTpCd[i]);
				if (sIfRhqCd[i] != null)
					model.setSIfRhqCd(sIfRhqCd[i]);
				if (trdPartyCd[i] != null)
					model.setTrdPartyCd(trdPartyCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEmailFaxSentHistVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EmailFaxSentHistVO[]
	 */
	public EmailFaxSentHistVO[] getEmailFaxSentHistVOs(){
		EmailFaxSentHistVO[] vos = (EmailFaxSentHistVO[])models.toArray(new EmailFaxSentHistVO[models.size()]);
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
		this.sCustSeq = this.sCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyInvRvisCd = this.n3ptyInvRvisCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIfCtrlCd = this.sIfCtrlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyInvNo = this.n3ptyInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issUsrId = this.issUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyInvNo = this.sN3ptyInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdPartyNm = this.trdPartyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEdate = this.sEdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCustEmlFax = this.vndrCustEmlFax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyInvSndTpCd = this.n3ptyInvSndTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVndrSeq = this.sVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustCntCd = this.sCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSdate = this.sSdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIfOfcCd = this.sIfOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIssLoclDt = this.invIssLoclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndrid = this.sndrid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxEmlSndRsltMsg = this.faxEmlSndRsltMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyIfTpCd = this.sN3ptyIfTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIfRhqCd = this.sIfRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdPartyCd = this.trdPartyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
