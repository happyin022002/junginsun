/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchInvoiceStatusVO.java
*@FileTitle : SearchInvoiceStatusVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.12
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.12  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchInvoiceStatusVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchInvoiceStatusVO> models = new ArrayList<SearchInvoiceStatusVO>();
	
	/* Column Info */
	private String userOfcCd = null;
	/* Column Info */
	private String cltAgnFlg = null;
	/* Column Info */
	private String sHisSeq = null;
	/* Column Info */
	private String sErpifYn = null;
	/* Column Info */
	private String rn = null;
	/* Column Info */
	private String cntcInfoValidyn = null;
	/* Column Info */
	private String sFinalFlg = null;
	/* Column Info */
	private String userEmail = null;
	/* Column Info */
	private String issueYn = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntcInfo = null;
	/* Column Info */
	private String sCltAgnFlg = null;
	/* Column Info */
	private String n3ptyInvStsCd = null;
	/* Column Info */
	private String vndrCustNm = null;
	/* Column Info */
	private String sInquiryonlyYn = null;
	/* Column Info */
	private String sN3ptyInvNo = null;
	/* Column Info */
	private String isAu = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String sN3ptyInvRmdCd = null;
	/* Column Info */
	private String userName = null;
	/* Column Info */
	private String sIssueYn = null;
	/* Column Info */
	private String sN3ptyInvStsCd = null;
	/* Column Info */
	private String sInfo = null;
	/* Column Info */
	private String sFinalInvoice = null;
	/* Column Info */
	private String inforowcount = null;
	/* Column Info */
	private String sN3ptyInvHisSeq = null;
	/* Column Info */
	private String vndrCustEml = null;
	/* Column Info */
	private String erpifYn = null;
	/* Column Info */
	private String sContactInfo = null;
	/* Column Info */
	private String sN3ptyNo = null;
	/* Column Info */
	private String sBilLoc = null;
	/* Column Info */
	private String bilToLocDivCd = null;
	/* Column Info */
	private String sN3ptyInvIfTpCd = null;
	/* Column Info */
	private String sN3ptyInvRvisCd = null;
	/* Column Info */
	private String sDaoN3ptyBilTpCd = null;
	/* Column Info */
	private String sN3ptyInvIfTpNm = null;
	/* Column Info */
	private String sN3ptyInvRvisSeq = null;
	/* Column Info */
	private String tmplParam = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String dummy = null;
	/* Column Info */
	private String faxEmlSndNo = null;
	/* Column Info */
	private String trdPartyVal = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchInvoiceStatusVO() {}

	public SearchInvoiceStatusVO(String ibflag, String pagerows, String cltAgnFlg, String userOfcCd, String sErpifYn, String sHisSeq, String rn, String cntcInfoValidyn, String sFinalFlg, String userEmail, String issueYn, String sCltAgnFlg, String cntcInfo, String n3ptyInvStsCd, String vndrCustNm, String sInquiryonlyYn, String sN3ptyInvNo, String userId, String sN3ptyInvRmdCd, String userName, String sIssueYn, String sN3ptyInvStsCd, String sInfo, String sFinalInvoice, String inforowcount, String sN3ptyInvHisSeq, String vndrCustEml, String sContactInfo, String erpifYn, String sBilLoc, String bilToLocDivCd, String sN3ptyInvIfTpCd, String sN3ptyInvRvisCd, String sDaoN3ptyBilTpCd, String sN3ptyInvIfTpNm, String sN3ptyInvRvisSeq, String tmplParam, String faxNo, String dummy, String isAu, String sN3ptyNo, String faxEmlSndNo, String trdPartyVal) {
		this.userOfcCd = userOfcCd;
		this.cltAgnFlg = cltAgnFlg;
		this.sHisSeq = sHisSeq;
		this.sErpifYn = sErpifYn;
		this.rn = rn;
		this.cntcInfoValidyn = cntcInfoValidyn;
		this.sFinalFlg = sFinalFlg;
		this.userEmail = userEmail;
		this.issueYn = issueYn;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.cntcInfo = cntcInfo;
		this.sCltAgnFlg = sCltAgnFlg;
		this.n3ptyInvStsCd = n3ptyInvStsCd;
		this.vndrCustNm = vndrCustNm;
		this.sInquiryonlyYn = sInquiryonlyYn;
		this.sN3ptyInvNo = sN3ptyInvNo;
		this.isAu = isAu;
		this.userId = userId;
		this.sN3ptyInvRmdCd = sN3ptyInvRmdCd;
		this.userName = userName;
		this.sIssueYn = sIssueYn;
		this.sN3ptyInvStsCd = sN3ptyInvStsCd;
		this.sInfo = sInfo;
		this.sFinalInvoice = sFinalInvoice;
		this.inforowcount = inforowcount;
		this.sN3ptyInvHisSeq = sN3ptyInvHisSeq;
		this.vndrCustEml = vndrCustEml;
		this.erpifYn = erpifYn;
		this.sContactInfo = sContactInfo;
		this.sN3ptyNo = sN3ptyNo;
		this.sBilLoc = sBilLoc;
		this.bilToLocDivCd = bilToLocDivCd;
		this.sN3ptyInvIfTpCd = sN3ptyInvIfTpCd;
		this.sN3ptyInvRvisCd = sN3ptyInvRvisCd;
		this.sDaoN3ptyBilTpCd = sDaoN3ptyBilTpCd;
		this.sN3ptyInvIfTpNm = sN3ptyInvIfTpNm;
		this.sN3ptyInvRvisSeq = sN3ptyInvRvisSeq;
		this.tmplParam = tmplParam;
		this.faxNo = faxNo;
		this.dummy = dummy;
		this.faxEmlSndNo = faxEmlSndNo;
		this.trdPartyVal = trdPartyVal;
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("user_ofc_cd", getUserOfcCd());
		this.hashColumns.put("clt_agn_flg", getCltAgnFlg());
		this.hashColumns.put("s_his_seq", getSHisSeq());
		this.hashColumns.put("s_erpif_yn", getSErpifYn());
		this.hashColumns.put("rn", getRn());
		this.hashColumns.put("cntc_info_validyn", getCntcInfoValidyn());
		this.hashColumns.put("s_final_flg", getSFinalFlg());
		this.hashColumns.put("user_email", getUserEmail());
		this.hashColumns.put("issue_yn", getIssueYn());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntc_info", getCntcInfo());
		this.hashColumns.put("s_clt_agn_flg", getSCltAgnFlg());
		this.hashColumns.put("n3pty_inv_sts_cd", getN3ptyInvStsCd());
		this.hashColumns.put("vndr_cust_nm", getVndrCustNm());
		this.hashColumns.put("s_inquiryonly_yn", getSInquiryonlyYn());
		this.hashColumns.put("s_n3pty_inv_no", getSN3ptyInvNo());
		this.hashColumns.put("is_au", getIsAu());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("s_n3pty_inv_rmd_cd", getSN3ptyInvRmdCd());
		this.hashColumns.put("user_name", getUserName());
		this.hashColumns.put("s_issue_yn", getSIssueYn());
		this.hashColumns.put("s_n3pty_inv_sts_cd", getSN3ptyInvStsCd());
		this.hashColumns.put("s_info", getSInfo());
		this.hashColumns.put("s_final_invoice", getSFinalInvoice());
		this.hashColumns.put("inforowcount", getInforowcount());
		this.hashColumns.put("s_n3pty_inv_his_seq", getSN3ptyInvHisSeq());
		this.hashColumns.put("vndr_cust_eml", getVndrCustEml());
		this.hashColumns.put("erpif_yn", getErpifYn());
		this.hashColumns.put("s_contact_info", getSContactInfo());
		this.hashColumns.put("s_n3pty_no", getSN3ptyNo());
		this.hashColumns.put("s_bil_loc", getSBilLoc());
		this.hashColumns.put("bil_to_loc_div_cd", getBilToLocDivCd());
		this.hashColumns.put("s_n3pty_inv_if_tp_cd", getSN3ptyInvIfTpCd());
		this.hashColumns.put("s_n3pty_inv_rvis_cd", getSN3ptyInvRvisCd());
		this.hashColumns.put("s_dao_n3pty_bil_tp_cd", getSDaoN3ptyBilTpCd());
		this.hashColumns.put("s_n3pty_inv_if_tp_nm", getSN3ptyInvIfTpNm());
		this.hashColumns.put("s_n3pty_inv_rvis_seq", getSN3ptyInvRvisSeq());
		this.hashColumns.put("tmpl_param", getTmplParam());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("dummy", getDummy());
		this.hashColumns.put("fax_eml_snd_no", getFaxEmlSndNo());
		this.hashColumns.put("trd_party_val", getTrdPartyVal());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("user_ofc_cd", "userOfcCd");
		this.hashFields.put("clt_agn_flg", "cltAgnFlg");
		this.hashFields.put("s_his_seq", "sHisSeq");
		this.hashFields.put("s_erpif_yn", "sErpifYn");
		this.hashFields.put("rn", "rn");
		this.hashFields.put("cntc_info_validyn", "cntcInfoValidyn");
		this.hashFields.put("s_final_flg", "sFinalFlg");
		this.hashFields.put("user_email", "userEmail");
		this.hashFields.put("issue_yn", "issueYn");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntc_info", "cntcInfo");
		this.hashFields.put("s_clt_agn_flg", "sCltAgnFlg");
		this.hashFields.put("n3pty_inv_sts_cd", "n3ptyInvStsCd");
		this.hashFields.put("vndr_cust_nm", "vndrCustNm");
		this.hashFields.put("s_inquiryonly_yn", "sInquiryonlyYn");
		this.hashFields.put("s_n3pty_inv_no", "sN3ptyInvNo");
		this.hashFields.put("is_au", "isAu");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("s_n3pty_inv_rmd_cd", "sN3ptyInvRmdCd");
		this.hashFields.put("user_name", "userName");
		this.hashFields.put("s_issue_yn", "sIssueYn");
		this.hashFields.put("s_n3pty_inv_sts_cd", "sN3ptyInvStsCd");
		this.hashFields.put("s_info", "sInfo");
		this.hashFields.put("s_final_invoice", "sFinalInvoice");
		this.hashFields.put("inforowcount", "inforowcount");
		this.hashFields.put("s_n3pty_inv_his_seq", "sN3ptyInvHisSeq");
		this.hashFields.put("vndr_cust_eml", "vndrCustEml");
		this.hashFields.put("erpif_yn", "erpifYn");
		this.hashFields.put("s_contact_info", "sContactInfo");
		this.hashFields.put("s_n3pty_no", "sN3ptyNo");
		this.hashFields.put("s_bil_loc", "sBilLoc");
		this.hashFields.put("bil_to_loc_div_cd", "bilToLocDivCd");
		this.hashFields.put("s_n3pty_inv_if_tp_cd", "sN3ptyInvIfTpCd");
		this.hashFields.put("s_n3pty_inv_rvis_cd", "sN3ptyInvRvisCd");
		this.hashFields.put("s_dao_n3pty_bil_tp_cd", "sDaoN3ptyBilTpCd");
		this.hashFields.put("s_n3pty_inv_if_tp_nm", "sN3ptyInvIfTpNm");
		this.hashFields.put("s_n3pty_inv_rvis_seq", "sN3ptyInvRvisSeq");
		this.hashFields.put("tmpl_param", "tmplParam");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("dummy", "dummy");
		this.hashFields.put("fax_eml_snd_no", "faxEmlSndNo");
		this.hashFields.put("trd_party_val", "trdPartyVal");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return userOfcCd
	 */
	public String getUserOfcCd() {
		return this.userOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cltAgnFlg
	 */
	public String getCltAgnFlg() {
		return this.cltAgnFlg;
	}
	
	/**
	 * Column Info
	 * @return sHisSeq
	 */
	public String getSHisSeq() {
		return this.sHisSeq;
	}
	
	/**
	 * Column Info
	 * @return sErpifYn
	 */
	public String getSErpifYn() {
		return this.sErpifYn;
	}
	
	/**
	 * Column Info
	 * @return rn
	 */
	public String getRn() {
		return this.rn;
	}
	
	/**
	 * Column Info
	 * @return cntcInfoValidyn
	 */
	public String getCntcInfoValidyn() {
		return this.cntcInfoValidyn;
	}
	
	/**
	 * Column Info
	 * @return sFinalFlg
	 */
	public String getSFinalFlg() {
		return this.sFinalFlg;
	}
	
	/**
	 * Column Info
	 * @return userEmail
	 */
	public String getUserEmail() {
		return this.userEmail;
	}
	
	/**
	 * Column Info
	 * @return issueYn
	 */
	public String getIssueYn() {
		return this.issueYn;
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
	 * @return cntcInfo
	 */
	public String getCntcInfo() {
		return this.cntcInfo;
	}
	
	/**
	 * Column Info
	 * @return sCltAgnFlg
	 */
	public String getSCltAgnFlg() {
		return this.sCltAgnFlg;
	}
	
	/**
	 * Column Info
	 * @return n3ptyInvStsCd
	 */
	public String getN3ptyInvStsCd() {
		return this.n3ptyInvStsCd;
	}
	
	/**
	 * Column Info
	 * @return vndrCustNm
	 */
	public String getVndrCustNm() {
		return this.vndrCustNm;
	}
	
	/**
	 * Column Info
	 * @return sInquiryonlyYn
	 */
	public String getSInquiryonlyYn() {
		return this.sInquiryonlyYn;
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
	 * @return isAu
	 */
	public String getIsAu() {
		return this.isAu;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return sN3ptyInvRmdCd
	 */
	public String getSN3ptyInvRmdCd() {
		return this.sN3ptyInvRmdCd;
	}
	
	/**
	 * Column Info
	 * @return userName
	 */
	public String getUserName() {
		return this.userName;
	}
	
	/**
	 * Column Info
	 * @return sIssueYn
	 */
	public String getSIssueYn() {
		return this.sIssueYn;
	}
	
	/**
	 * Column Info
	 * @return sN3ptyInvStsCd
	 */
	public String getSN3ptyInvStsCd() {
		return this.sN3ptyInvStsCd;
	}
	
	/**
	 * Column Info
	 * @return sInfo
	 */
	public String getSInfo() {
		return this.sInfo;
	}
	
	/**
	 * Column Info
	 * @return sFinalInvoice
	 */
	public String getSFinalInvoice() {
		return this.sFinalInvoice;
	}
	
	/**
	 * Column Info
	 * @return inforowcount
	 */
	public String getInforowcount() {
		return this.inforowcount;
	}
	
	/**
	 * Column Info
	 * @return sN3ptyInvHisSeq
	 */
	public String getSN3ptyInvHisSeq() {
		return this.sN3ptyInvHisSeq;
	}
	
	/**
	 * Column Info
	 * @return vndrCustEml
	 */
	public String getVndrCustEml() {
		return this.vndrCustEml;
	}
	
	/**
	 * Column Info
	 * @return erpifYn
	 */
	public String getErpifYn() {
		return this.erpifYn;
	}
	
	/**
	 * Column Info
	 * @return sContactInfo
	 */
	public String getSContactInfo() {
		return this.sContactInfo;
	}
	
	/**
	 * Column Info
	 * @return sN3ptyNo
	 */
	public String getSN3ptyNo() {
		return this.sN3ptyNo;
	}
	
	/**
	 * Column Info
	 * @return sBilLoc
	 */
	public String getSBilLoc() {
		return this.sBilLoc;
	}
	
	/**
	 * Column Info
	 * @return bilToLocDivCd
	 */
	public String getBilToLocDivCd() {
		return this.bilToLocDivCd;
	}
	
	/**
	 * Column Info
	 * @return sN3ptyInvIfTpCd
	 */
	public String getSN3ptyInvIfTpCd() {
		return this.sN3ptyInvIfTpCd;
	}
	
	/**
	 * Column Info
	 * @return sN3ptyInvRvisCd
	 */
	public String getSN3ptyInvRvisCd() {
		return this.sN3ptyInvRvisCd;
	}
	
	/**
	 * Column Info
	 * @return sDaoN3ptyBilTpCd
	 */
	public String getSDaoN3ptyBilTpCd() {
		return this.sDaoN3ptyBilTpCd;
	}
	
	/**
	 * Column Info
	 * @return sN3ptyInvIfTpNm
	 */
	public String getSN3ptyInvIfTpNm() {
		return this.sN3ptyInvIfTpNm;
	}
	
	/**
	 * Column Info
	 * @return sN3ptyInvRvisSeq
	 */
	public String getSN3ptyInvRvisSeq() {
		return this.sN3ptyInvRvisSeq;
	}
	
	/**
	 * Column Info
	 * @return tmplParam
	 */
	public String getTmplParam() {
		return this.tmplParam;
	}
	
	/**
	 * Column Info
	 * @return faxNo
	 */
	public String getFaxNo() {
		return this.faxNo;
	}
	
	/**
	 * Column Info
	 * @return dummy
	 */
	public String getDummy() {
		return this.dummy;
	}
	
	/**
	 * Column Info
	 * @return faxEmlSndNo
	 */
	public String getFaxEmlSndNo() {
		return this.faxEmlSndNo;
	}
	
	/**
	 * Column Info
	 * @return trdPartyVal
	 */
	public String getTrdPartyVal() {
		return this.trdPartyVal;
	}
	

	/**
	 * Column Info
	 * @param userOfcCd
	 */
	public void setUserOfcCd(String userOfcCd) {
		this.userOfcCd = userOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cltAgnFlg
	 */
	public void setCltAgnFlg(String cltAgnFlg) {
		this.cltAgnFlg = cltAgnFlg;
	}
	
	/**
	 * Column Info
	 * @param sHisSeq
	 */
	public void setSHisSeq(String sHisSeq) {
		this.sHisSeq = sHisSeq;
	}
	
	/**
	 * Column Info
	 * @param sErpifYn
	 */
	public void setSErpifYn(String sErpifYn) {
		this.sErpifYn = sErpifYn;
	}
	
	/**
	 * Column Info
	 * @param rn
	 */
	public void setRn(String rn) {
		this.rn = rn;
	}
	
	/**
	 * Column Info
	 * @param cntcInfoValidyn
	 */
	public void setCntcInfoValidyn(String cntcInfoValidyn) {
		this.cntcInfoValidyn = cntcInfoValidyn;
	}
	
	/**
	 * Column Info
	 * @param sFinalFlg
	 */
	public void setSFinalFlg(String sFinalFlg) {
		this.sFinalFlg = sFinalFlg;
	}
	
	/**
	 * Column Info
	 * @param userEmail
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	/**
	 * Column Info
	 * @param issueYn
	 */
	public void setIssueYn(String issueYn) {
		this.issueYn = issueYn;
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
	 * @param cntcInfo
	 */
	public void setCntcInfo(String cntcInfo) {
		this.cntcInfo = cntcInfo;
	}
	
	/**
	 * Column Info
	 * @param sCltAgnFlg
	 */
	public void setSCltAgnFlg(String sCltAgnFlg) {
		this.sCltAgnFlg = sCltAgnFlg;
	}
	
	/**
	 * Column Info
	 * @param n3ptyInvStsCd
	 */
	public void setN3ptyInvStsCd(String n3ptyInvStsCd) {
		this.n3ptyInvStsCd = n3ptyInvStsCd;
	}
	
	/**
	 * Column Info
	 * @param vndrCustNm
	 */
	public void setVndrCustNm(String vndrCustNm) {
		this.vndrCustNm = vndrCustNm;
	}
	
	/**
	 * Column Info
	 * @param sInquiryonlyYn
	 */
	public void setSInquiryonlyYn(String sInquiryonlyYn) {
		this.sInquiryonlyYn = sInquiryonlyYn;
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
	 * @param isAu
	 */
	public void setIsAu(String isAu) {
		this.isAu = isAu;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param sN3ptyInvRmdCd
	 */
	public void setSN3ptyInvRmdCd(String sN3ptyInvRmdCd) {
		this.sN3ptyInvRmdCd = sN3ptyInvRmdCd;
	}
	
	/**
	 * Column Info
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * Column Info
	 * @param sIssueYn
	 */
	public void setSIssueYn(String sIssueYn) {
		this.sIssueYn = sIssueYn;
	}
	
	/**
	 * Column Info
	 * @param sN3ptyInvStsCd
	 */
	public void setSN3ptyInvStsCd(String sN3ptyInvStsCd) {
		this.sN3ptyInvStsCd = sN3ptyInvStsCd;
	}
	
	/**
	 * Column Info
	 * @param sInfo
	 */
	public void setSInfo(String sInfo) {
		this.sInfo = sInfo;
	}
	
	/**
	 * Column Info
	 * @param sFinalInvoice
	 */
	public void setSFinalInvoice(String sFinalInvoice) {
		this.sFinalInvoice = sFinalInvoice;
	}
	
	/**
	 * Column Info
	 * @param inforowcount
	 */
	public void setInforowcount(String inforowcount) {
		this.inforowcount = inforowcount;
	}
	
	/**
	 * Column Info
	 * @param sN3ptyInvHisSeq
	 */
	public void setSN3ptyInvHisSeq(String sN3ptyInvHisSeq) {
		this.sN3ptyInvHisSeq = sN3ptyInvHisSeq;
	}
	
	/**
	 * Column Info
	 * @param vndrCustEml
	 */
	public void setVndrCustEml(String vndrCustEml) {
		this.vndrCustEml = vndrCustEml;
	}
	
	/**
	 * Column Info
	 * @param erpifYn
	 */
	public void setErpifYn(String erpifYn) {
		this.erpifYn = erpifYn;
	}
	
	/**
	 * Column Info
	 * @param sContactInfo
	 */
	public void setSContactInfo(String sContactInfo) {
		this.sContactInfo = sContactInfo;
	}
	
	/**
	 * Column Info
	 * @param sN3ptyNo
	 */
	public void setSN3ptyNo(String sN3ptyNo) {
		this.sN3ptyNo = sN3ptyNo;
	}
	
	/**
	 * Column Info
	 * @param sBilLoc
	 */
	public void setSBilLoc(String sBilLoc) {
		this.sBilLoc = sBilLoc;
	}
	
	/**
	 * Column Info
	 * @param bilToLocDivCd
	 */
	public void setBilToLocDivCd(String bilToLocDivCd) {
		this.bilToLocDivCd = bilToLocDivCd;
	}
	
	/**
	 * Column Info
	 * @param sN3ptyInvIfTpCd
	 */
	public void setSN3ptyInvIfTpCd(String sN3ptyInvIfTpCd) {
		this.sN3ptyInvIfTpCd = sN3ptyInvIfTpCd;
	}
	
	/**
	 * Column Info
	 * @param sN3ptyInvRvisCd
	 */
	public void setSN3ptyInvRvisCd(String sN3ptyInvRvisCd) {
		this.sN3ptyInvRvisCd = sN3ptyInvRvisCd;
	}
	
	/**
	 * Column Info
	 * @param sDaoN3ptyBilTpCd
	 */
	public void setSDaoN3ptyBilTpCd(String sDaoN3ptyBilTpCd) {
		this.sDaoN3ptyBilTpCd = sDaoN3ptyBilTpCd;
	}
	
	/**
	 * Column Info
	 * @param sN3ptyInvIfTpNm
	 */
	public void setSN3ptyInvIfTpNm(String sN3ptyInvIfTpNm) {
		this.sN3ptyInvIfTpNm = sN3ptyInvIfTpNm;
	}
	
	/**
	 * Column Info
	 * @param sN3ptyInvRvisSeq
	 */
	public void setSN3ptyInvRvisSeq(String sN3ptyInvRvisSeq) {
		this.sN3ptyInvRvisSeq = sN3ptyInvRvisSeq;
	}
	
	/**
	 * Column Info
	 * @param tmplParam
	 */
	public void setTmplParam(String tmplParam) {
		this.tmplParam = tmplParam;
	}
	
	/**
	 * Column Info
	 * @param faxNo
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	
	/**
	 * Column Info
	 * @param dummy
	 */
	public void setDummy(String dummy) {
		this.dummy = dummy;
	}
	
	/**
	 * Column Info
	 * @param faxEmlSndNo
	 */
	public void setFaxEmlSndNo(String faxEmlSndNo) {
		this.faxEmlSndNo = faxEmlSndNo;
	}
	
	/**
	 * Column Info
	 * @param trdPartyVal
	 */
	public void setTrdPartyVal(String trdPartyVal) {
		this.trdPartyVal = trdPartyVal;
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
		setUserOfcCd(JSPUtil.getParameter(request, prefix + "user_ofc_cd", ""));
		setCltAgnFlg(JSPUtil.getParameter(request, prefix + "clt_agn_flg", ""));
		setSHisSeq(JSPUtil.getParameter(request, prefix + "s_his_seq", ""));
		setSErpifYn(JSPUtil.getParameter(request, prefix + "s_erpif_yn", ""));
		setRn(JSPUtil.getParameter(request, prefix + "rn", ""));
		setCntcInfoValidyn(JSPUtil.getParameter(request, prefix + "cntc_info_validyn", ""));
		setSFinalFlg(JSPUtil.getParameter(request, prefix + "s_final_flg", ""));
		setUserEmail(JSPUtil.getParameter(request, prefix + "user_email", ""));
		setIssueYn(JSPUtil.getParameter(request, prefix + "issue_yn", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntcInfo(JSPUtil.getParameter(request, prefix + "cntc_info", ""));
		setSCltAgnFlg(JSPUtil.getParameter(request, prefix + "s_clt_agn_flg", ""));
		setN3ptyInvStsCd(JSPUtil.getParameter(request, prefix + "n3pty_inv_sts_cd", ""));
		setVndrCustNm(JSPUtil.getParameter(request, prefix + "vndr_cust_nm", ""));
		setSInquiryonlyYn(JSPUtil.getParameter(request, prefix + "s_inquiryonly_yn", ""));
		setSN3ptyInvNo(JSPUtil.getParameter(request, prefix + "s_n3pty_inv_no", ""));
		setIsAu(JSPUtil.getParameter(request, prefix + "is_au", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setSN3ptyInvRmdCd(JSPUtil.getParameter(request, prefix + "s_n3pty_inv_rmd_cd", ""));
		setUserName(JSPUtil.getParameter(request, prefix + "user_name", ""));
		setSIssueYn(JSPUtil.getParameter(request, prefix + "s_issue_yn", ""));
		setSN3ptyInvStsCd(JSPUtil.getParameter(request, prefix + "s_n3pty_inv_sts_cd", ""));
		setSInfo(JSPUtil.getParameter(request, prefix + "s_info", ""));
		setSFinalInvoice(JSPUtil.getParameter(request, prefix + "s_final_invoice", ""));
		setInforowcount(JSPUtil.getParameter(request, prefix + "inforowcount", ""));
		setSN3ptyInvHisSeq(JSPUtil.getParameter(request, prefix + "s_n3pty_inv_his_seq", ""));
		setVndrCustEml(JSPUtil.getParameter(request, prefix + "vndr_cust_eml", ""));
		setErpifYn(JSPUtil.getParameter(request, prefix + "erpif_yn", ""));
		setSContactInfo(JSPUtil.getParameter(request, prefix + "s_contact_info", ""));
		setSN3ptyNo(JSPUtil.getParameter(request, prefix + "s_n3pty_no", ""));
		setSBilLoc(JSPUtil.getParameter(request, prefix + "s_bil_loc", ""));
		setBilToLocDivCd(JSPUtil.getParameter(request, prefix + "bil_to_loc_div_cd", ""));
		setSN3ptyInvIfTpCd(JSPUtil.getParameter(request, prefix + "s_n3pty_inv_if_tp_cd", ""));
		setSN3ptyInvRvisCd(JSPUtil.getParameter(request, prefix + "s_n3pty_inv_rvis_cd", ""));
		setSDaoN3ptyBilTpCd(JSPUtil.getParameter(request, prefix + "s_dao_n3pty_bil_tp_cd", ""));
		setSN3ptyInvIfTpNm(JSPUtil.getParameter(request, prefix + "s_n3pty_inv_if_tp_nm", ""));
		setSN3ptyInvRvisSeq(JSPUtil.getParameter(request, prefix + "s_n3pty_inv_rvis_seq", ""));
		setTmplParam(JSPUtil.getParameter(request, prefix + "tmpl_param", ""));
		setFaxNo(JSPUtil.getParameter(request, prefix + "fax_no", ""));
		setDummy(JSPUtil.getParameter(request, prefix + "dummy", ""));
		setFaxEmlSndNo(JSPUtil.getParameter(request, prefix + "fax_eml_snd_no", ""));
		setTrdPartyVal(JSPUtil.getParameter(request, prefix + "trd_party_val", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchInvoiceStatusVO[]
	 */
	public SearchInvoiceStatusVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchInvoiceStatusVO[]
	 */
	public SearchInvoiceStatusVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchInvoiceStatusVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] userOfcCd = (JSPUtil.getParameter(request, prefix	+ "user_ofc_cd", length));
			String[] cltAgnFlg = (JSPUtil.getParameter(request, prefix	+ "clt_agn_flg", length));
			String[] sHisSeq = (JSPUtil.getParameter(request, prefix	+ "s_his_seq", length));
			String[] sErpifYn = (JSPUtil.getParameter(request, prefix	+ "s_erpif_yn", length));
			String[] rn = (JSPUtil.getParameter(request, prefix	+ "rn", length));
			String[] cntcInfoValidyn = (JSPUtil.getParameter(request, prefix	+ "cntc_info_validyn", length));
			String[] sFinalFlg = (JSPUtil.getParameter(request, prefix	+ "s_final_flg", length));
			String[] userEmail = (JSPUtil.getParameter(request, prefix	+ "user_email", length));
			String[] issueYn = (JSPUtil.getParameter(request, prefix	+ "issue_yn", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntcInfo = (JSPUtil.getParameter(request, prefix	+ "cntc_info", length));
			String[] sCltAgnFlg = (JSPUtil.getParameter(request, prefix	+ "s_clt_agn_flg", length));
			String[] n3ptyInvStsCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_inv_sts_cd", length));
			String[] vndrCustNm = (JSPUtil.getParameter(request, prefix	+ "vndr_cust_nm", length));
			String[] sInquiryonlyYn = (JSPUtil.getParameter(request, prefix	+ "s_inquiryonly_yn", length));
			String[] sN3ptyInvNo = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_inv_no", length));
			String[] isAu = (JSPUtil.getParameter(request, prefix	+ "is_au", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] sN3ptyInvRmdCd = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_inv_rmd_cd", length));
			String[] userName = (JSPUtil.getParameter(request, prefix	+ "user_name", length));
			String[] sIssueYn = (JSPUtil.getParameter(request, prefix	+ "s_issue_yn", length));
			String[] sN3ptyInvStsCd = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_inv_sts_cd", length));
			String[] sInfo = (JSPUtil.getParameter(request, prefix	+ "s_info", length));
			String[] sFinalInvoice = (JSPUtil.getParameter(request, prefix	+ "s_final_invoice", length));
			String[] inforowcount = (JSPUtil.getParameter(request, prefix	+ "inforowcount", length));
			String[] sN3ptyInvHisSeq = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_inv_his_seq", length));
			String[] vndrCustEml = (JSPUtil.getParameter(request, prefix	+ "vndr_cust_eml", length));
			String[] erpifYn = (JSPUtil.getParameter(request, prefix	+ "erpif_yn", length));
			String[] sContactInfo = (JSPUtil.getParameter(request, prefix	+ "s_contact_info", length));
			String[] sN3ptyNo = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_no", length));
			String[] sBilLoc = (JSPUtil.getParameter(request, prefix	+ "s_bil_loc", length));
			String[] bilToLocDivCd = (JSPUtil.getParameter(request, prefix	+ "bil_to_loc_div_cd", length));
			String[] sN3ptyInvIfTpCd = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_inv_if_tp_cd", length));
			String[] sN3ptyInvRvisCd = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_inv_rvis_cd", length));
			String[] sDaoN3ptyBilTpCd = (JSPUtil.getParameter(request, prefix	+ "s_dao_n3pty_bil_tp_cd", length));
			String[] sN3ptyInvIfTpNm = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_inv_if_tp_nm", length));
			String[] sN3ptyInvRvisSeq = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_inv_rvis_seq", length));
			String[] tmplParam = (JSPUtil.getParameter(request, prefix	+ "tmpl_param", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] dummy = (JSPUtil.getParameter(request, prefix	+ "dummy", length));
			String[] faxEmlSndNo = (JSPUtil.getParameter(request, prefix	+ "fax_eml_snd_no", length));
			String[] trdPartyVal = (JSPUtil.getParameter(request, prefix	+ "trd_party_val", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchInvoiceStatusVO();
				if (userOfcCd[i] != null)
					model.setUserOfcCd(userOfcCd[i]);
				if (cltAgnFlg[i] != null)
					model.setCltAgnFlg(cltAgnFlg[i]);
				if (sHisSeq[i] != null)
					model.setSHisSeq(sHisSeq[i]);
				if (sErpifYn[i] != null)
					model.setSErpifYn(sErpifYn[i]);
				if (rn[i] != null)
					model.setRn(rn[i]);
				if (cntcInfoValidyn[i] != null)
					model.setCntcInfoValidyn(cntcInfoValidyn[i]);
				if (sFinalFlg[i] != null)
					model.setSFinalFlg(sFinalFlg[i]);
				if (userEmail[i] != null)
					model.setUserEmail(userEmail[i]);
				if (issueYn[i] != null)
					model.setIssueYn(issueYn[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntcInfo[i] != null)
					model.setCntcInfo(cntcInfo[i]);
				if (sCltAgnFlg[i] != null)
					model.setSCltAgnFlg(sCltAgnFlg[i]);
				if (n3ptyInvStsCd[i] != null)
					model.setN3ptyInvStsCd(n3ptyInvStsCd[i]);
				if (vndrCustNm[i] != null)
					model.setVndrCustNm(vndrCustNm[i]);
				if (sInquiryonlyYn[i] != null)
					model.setSInquiryonlyYn(sInquiryonlyYn[i]);
				if (sN3ptyInvNo[i] != null)
					model.setSN3ptyInvNo(sN3ptyInvNo[i]);
				if (isAu[i] != null)
					model.setIsAu(isAu[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (sN3ptyInvRmdCd[i] != null)
					model.setSN3ptyInvRmdCd(sN3ptyInvRmdCd[i]);
				if (userName[i] != null)
					model.setUserName(userName[i]);
				if (sIssueYn[i] != null)
					model.setSIssueYn(sIssueYn[i]);
				if (sN3ptyInvStsCd[i] != null)
					model.setSN3ptyInvStsCd(sN3ptyInvStsCd[i]);
				if (sInfo[i] != null)
					model.setSInfo(sInfo[i]);
				if (sFinalInvoice[i] != null)
					model.setSFinalInvoice(sFinalInvoice[i]);
				if (inforowcount[i] != null)
					model.setInforowcount(inforowcount[i]);
				if (sN3ptyInvHisSeq[i] != null)
					model.setSN3ptyInvHisSeq(sN3ptyInvHisSeq[i]);
				if (vndrCustEml[i] != null)
					model.setVndrCustEml(vndrCustEml[i]);
				if (erpifYn[i] != null)
					model.setErpifYn(erpifYn[i]);
				if (sContactInfo[i] != null)
					model.setSContactInfo(sContactInfo[i]);
				if (sN3ptyNo[i] != null)
					model.setSN3ptyNo(sN3ptyNo[i]);
				if (sBilLoc[i] != null)
					model.setSBilLoc(sBilLoc[i]);
				if (bilToLocDivCd[i] != null)
					model.setBilToLocDivCd(bilToLocDivCd[i]);
				if (sN3ptyInvIfTpCd[i] != null)
					model.setSN3ptyInvIfTpCd(sN3ptyInvIfTpCd[i]);
				if (sN3ptyInvRvisCd[i] != null)
					model.setSN3ptyInvRvisCd(sN3ptyInvRvisCd[i]);
				if (sDaoN3ptyBilTpCd[i] != null)
					model.setSDaoN3ptyBilTpCd(sDaoN3ptyBilTpCd[i]);
				if (sN3ptyInvIfTpNm[i] != null)
					model.setSN3ptyInvIfTpNm(sN3ptyInvIfTpNm[i]);
				if (sN3ptyInvRvisSeq[i] != null)
					model.setSN3ptyInvRvisSeq(sN3ptyInvRvisSeq[i]);
				if (tmplParam[i] != null)
					model.setTmplParam(tmplParam[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (dummy[i] != null)
					model.setDummy(dummy[i]);
				if (faxEmlSndNo[i] != null)
					model.setFaxEmlSndNo(faxEmlSndNo[i]);
				if (trdPartyVal[i] != null)
					model.setTrdPartyVal(trdPartyVal[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchInvoiceStatusVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchInvoiceStatusVO[]
	 */
	public SearchInvoiceStatusVO[] getSearchInvoiceStatusVOs(){
		SearchInvoiceStatusVO[] vos = (SearchInvoiceStatusVO[])models.toArray(new SearchInvoiceStatusVO[models.size()]);
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
		this.userOfcCd = this.userOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltAgnFlg = this.cltAgnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sHisSeq = this.sHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sErpifYn = this.sErpifYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rn = this.rn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcInfoValidyn = this.cntcInfoValidyn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFinalFlg = this.sFinalFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userEmail = this.userEmail .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issueYn = this.issueYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcInfo = this.cntcInfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCltAgnFlg = this.sCltAgnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyInvStsCd = this.n3ptyInvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCustNm = this.vndrCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sInquiryonlyYn = this.sInquiryonlyYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyInvNo = this.sN3ptyInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isAu = this.isAu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyInvRmdCd = this.sN3ptyInvRmdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userName = this.userName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIssueYn = this.sIssueYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyInvStsCd = this.sN3ptyInvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sInfo = this.sInfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFinalInvoice = this.sFinalInvoice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inforowcount = this.inforowcount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyInvHisSeq = this.sN3ptyInvHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCustEml = this.vndrCustEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.erpifYn = this.erpifYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sContactInfo = this.sContactInfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyNo = this.sN3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBilLoc = this.sBilLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilToLocDivCd = this.bilToLocDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyInvIfTpCd = this.sN3ptyInvIfTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyInvRvisCd = this.sN3ptyInvRvisCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDaoN3ptyBilTpCd = this.sDaoN3ptyBilTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyInvIfTpNm = this.sN3ptyInvIfTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyInvRvisSeq = this.sN3ptyInvRvisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmplParam = this.tmplParam .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dummy = this.dummy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxEmlSndNo = this.faxEmlSndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdPartyVal = this.trdPartyVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
