/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltBkgRevDrNotesStatusVO.java
*@FileTitle : RsltBkgRevDrNotesStatusVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.06
*@LastModifier : 류선우
*@LastVersion : 1.0
* 2010.05.06 류선우 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.vo;

import java.lang.reflect.Field;
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
 * @author 류선우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltBkgRevDrNotesStatusVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltBkgRevDrNotesStatusVO> models = new ArrayList<RsltBkgRevDrNotesStatusVO>();
	
	/* Column Info */
	private String rctOfcCd = null;
	/* Column Info */
	private String revAudToolNm = null;
	/* Column Info */
	private String respbRhqCd = null;
	/* Column Info */
	private String issOfcCd = null;
	/* Column Info */
	private String receiverUsrId = null;
	/* Column Info */
	private String ctrtTpCd = null;
	/* Column Info */
	private String rdnNo = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String umchRmk = null;
	/* Column Info */
	private String issUsrId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rdnStsNm = null;
	/* Column Info */
	private String revAudToolCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String umchSubTpCd = null;
	/* Column Info */
	private String rdnStsCd = null;
	/* Column Info */
	private String rctRhqCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rdnIssRsnCd = null;
	/* Column Info */
	private String bkgCorrNo = null;
	/* Column Info */
	private String rvisSeq = null;
	/* Column Info */
	private String rdnIssDtTo = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String usdAmt = null;
	/* Column Info */
	private String scRfaNo = null;
	/* Column Info */
	private String umchTpCd = null;
	/* Column Info */
	private String rdnIssDt = null;
	/* Column Info */
	private String respbOfcCd = null;
	/* Column Info */
	private String rdnIssDtFrom = null;
	/* Column Info */
	private String stlUsrId = null;
	/* Column Info */
	private String officeRdnRmk = null;
	/* Column Info */
	private String receiverRdnRmk = null;
	/* Column Info */
	private String bkgCtrtTpCd = null;
	/* Column Info */
	private String erUmchTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltBkgRevDrNotesStatusVO() {}

	public RsltBkgRevDrNotesStatusVO(String erUmchTpCd, String bkgCtrtTpCd, String ibflag, String pagerows, String issOfcCd, String rctRhqCd, String rctOfcCd, String respbRhqCd, String respbOfcCd, String bkgNo, String blNo, String scRfaNo, String ctrtTpCd, String rdnNo, String rvisSeq, String rdnStsCd, String rdnStsNm, String umchTpCd, String umchSubTpCd, String rdnIssRsnCd, String usdAmt, String umchRmk, String bkgCorrNo, String officeRdnRmk, String receiverRdnRmk, String revAudToolCd, String revAudToolNm, String rdnIssDt, String updDt, String issUsrId, String stlUsrId, String receiverUsrId, String rdnIssDtFrom, String rdnIssDtTo) {
		this.rctOfcCd = rctOfcCd;
		this.revAudToolNm = revAudToolNm;
		this.respbRhqCd = respbRhqCd;
		this.issOfcCd = issOfcCd;
		this.receiverUsrId = receiverUsrId;
		this.ctrtTpCd = ctrtTpCd;
		this.rdnNo = rdnNo;
		this.blNo = blNo;
		this.umchRmk = umchRmk;
		this.issUsrId = issUsrId;
		this.pagerows = pagerows;
		this.rdnStsNm = rdnStsNm;
		this.revAudToolCd = revAudToolCd;
		this.ibflag = ibflag;
		this.umchSubTpCd = umchSubTpCd;
		this.rdnStsCd = rdnStsCd;
		this.rctRhqCd = rctRhqCd;
		this.updDt = updDt;
		this.rdnIssRsnCd = rdnIssRsnCd;
		this.bkgCorrNo = bkgCorrNo;
		this.rvisSeq = rvisSeq;
		this.rdnIssDtTo = rdnIssDtTo;
		this.bkgNo = bkgNo;
		this.usdAmt = usdAmt;
		this.scRfaNo = scRfaNo;
		this.umchTpCd = umchTpCd;
		this.rdnIssDt = rdnIssDt;
		this.respbOfcCd = respbOfcCd;
		this.rdnIssDtFrom = rdnIssDtFrom;
		this.stlUsrId = stlUsrId;
		this.officeRdnRmk = officeRdnRmk;
		this.receiverRdnRmk = receiverRdnRmk;
		this.bkgCtrtTpCd = bkgCtrtTpCd;
		this.erUmchTpCd = erUmchTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rct_ofc_cd", getRctOfcCd());
		this.hashColumns.put("rev_aud_tool_nm", getRevAudToolNm());
		this.hashColumns.put("respb_rhq_cd", getRespbRhqCd());
		this.hashColumns.put("iss_ofc_cd", getIssOfcCd());
		this.hashColumns.put("receiver_usr_id", getReceiverUsrId());
		this.hashColumns.put("ctrt_tp_cd", getCtrtTpCd());
		this.hashColumns.put("rdn_no", getRdnNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("umch_rmk", getUmchRmk());
		this.hashColumns.put("iss_usr_id", getIssUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rdn_sts_nm", getRdnStsNm());
		this.hashColumns.put("rev_aud_tool_cd", getRevAudToolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("umch_sub_tp_cd", getUmchSubTpCd());
		this.hashColumns.put("rdn_sts_cd", getRdnStsCd());
		this.hashColumns.put("rct_rhq_cd", getRctRhqCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rdn_iss_rsn_cd", getRdnIssRsnCd());
		this.hashColumns.put("bkg_corr_no", getBkgCorrNo());
		this.hashColumns.put("rvis_seq", getRvisSeq());
		this.hashColumns.put("rdn_iss_dt_to", getRdnIssDtTo());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("usd_amt", getUsdAmt());
		this.hashColumns.put("sc_rfa_no", getScRfaNo());
		this.hashColumns.put("umch_tp_cd", getUmchTpCd());
		this.hashColumns.put("rdn_iss_dt", getRdnIssDt());
		this.hashColumns.put("respb_ofc_cd", getRespbOfcCd());
		this.hashColumns.put("rdn_iss_dt_from", getRdnIssDtFrom());
		this.hashColumns.put("stl_usr_id", getStlUsrId());
		this.hashColumns.put("office_rdn_rmk", getOfficeRdnRmk());
		this.hashColumns.put("receiver_rdn_rmk", getReceiverRdnRmk());
		this.hashColumns.put("bkg_ctrt_tp_cd", getBkgCtrtTpCd());
		this.hashColumns.put("er_umch_tp_cd", getErUmchTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rct_ofc_cd", "rctOfcCd");
		this.hashFields.put("rev_aud_tool_nm", "revAudToolNm");
		this.hashFields.put("respb_rhq_cd", "respbRhqCd");
		this.hashFields.put("iss_ofc_cd", "issOfcCd");
		this.hashFields.put("receiver_usr_id", "receiverUsrId");
		this.hashFields.put("ctrt_tp_cd", "ctrtTpCd");
		this.hashFields.put("rdn_no", "rdnNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("umch_rmk", "umchRmk");
		this.hashFields.put("iss_usr_id", "issUsrId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rdn_sts_nm", "rdnStsNm");
		this.hashFields.put("rev_aud_tool_cd", "revAudToolCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("umch_sub_tp_cd", "umchSubTpCd");
		this.hashFields.put("rdn_sts_cd", "rdnStsCd");
		this.hashFields.put("rct_rhq_cd", "rctRhqCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rdn_iss_rsn_cd", "rdnIssRsnCd");
		this.hashFields.put("bkg_corr_no", "bkgCorrNo");
		this.hashFields.put("rvis_seq", "rvisSeq");
		this.hashFields.put("rdn_iss_dt_to", "rdnIssDtTo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("usd_amt", "usdAmt");
		this.hashFields.put("sc_rfa_no", "scRfaNo");
		this.hashFields.put("umch_tp_cd", "umchTpCd");
		this.hashFields.put("rdn_iss_dt", "rdnIssDt");
		this.hashFields.put("respb_ofc_cd", "respbOfcCd");
		this.hashFields.put("rdn_iss_dt_from", "rdnIssDtFrom");
		this.hashFields.put("stl_usr_id", "stlUsrId");
		this.hashFields.put("office_rdn_rmk", "officeRdnRmk");
		this.hashFields.put("receiver_rdn_rmk", "receiverRdnRmk");
		this.hashFields.put("bkg_ctrt_tp_cd", "bkgCtrtTpCd");
		this.hashFields.put("er_umch_tp_cd", "erUmchTpCd");
		return this.hashFields;
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
	 * @return revAudToolNm
	 */
	public String getRevAudToolNm() {
		return this.revAudToolNm;
	}
	
	/**
	 * Column Info
	 * @return respbRhqCd
	 */
	public String getRespbRhqCd() {
		return this.respbRhqCd;
	}
	
	/**
	 * Column Info
	 * @return issOfcCd
	 */
	public String getIssOfcCd() {
		return this.issOfcCd;
	}
	
	/**
	 * Column Info
	 * @return receiverUsrId
	 */
	public String getReceiverUsrId() {
		return this.receiverUsrId;
	}
	
	/**
	 * Column Info
	 * @return ctrtTpCd
	 */
	public String getCtrtTpCd() {
		return this.ctrtTpCd;
	}
	
	/**
	 * Column Info
	 * @return rdnNo
	 */
	public String getRdnNo() {
		return this.rdnNo;
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
	 * @return umchRmk
	 */
	public String getUmchRmk() {
		return this.umchRmk;
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
	 * Column Info
	 * @return rdnStsNm
	 */
	public String getRdnStsNm() {
		return this.rdnStsNm;
	}
	
	/**
	 * Column Info
	 * @return revAudToolCd
	 */
	public String getRevAudToolCd() {
		return this.revAudToolCd;
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
	 * @return umchSubTpCd
	 */
	public String getUmchSubTpCd() {
		return this.umchSubTpCd;
	}
	
	/**
	 * Column Info
	 * @return rdnStsCd
	 */
	public String getRdnStsCd() {
		return this.rdnStsCd;
	}
	
	/**
	 * Column Info
	 * @return rctRhqCd
	 */
	public String getRctRhqCd() {
		return this.rctRhqCd;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return rdnIssRsnCd
	 */
	public String getRdnIssRsnCd() {
		return this.rdnIssRsnCd;
	}
	
	/**
	 * Column Info
	 * @return bkgCorrNo
	 */
	public String getBkgCorrNo() {
		return this.bkgCorrNo;
	}
	
	/**
	 * Column Info
	 * @return rvisSeq
	 */
	public String getRvisSeq() {
		return this.rvisSeq;
	}
	
	/**
	 * Column Info
	 * @return rdnIssDtTo
	 */
	public String getRdnIssDtTo() {
		return this.rdnIssDtTo;
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
	 * @return usdAmt
	 */
	public String getUsdAmt() {
		return this.usdAmt;
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
	 * @return umchTpCd
	 */
	public String getUmchTpCd() {
		return this.umchTpCd;
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
	 * @return respbOfcCd
	 */
	public String getRespbOfcCd() {
		return this.respbOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rdnIssDtFrom
	 */
	public String getRdnIssDtFrom() {
		return this.rdnIssDtFrom;
	}
	
	/**
	 * Column Info
	 * @return stlUsrId
	 */
	public String getStlUsrId() {
		return this.stlUsrId;
	}
	
	/**
	 * Column Info
	 * @return officeRdnRmk
	 */
	public String getOfficeRdnRmk() {
		return this.officeRdnRmk;
	}
	
	/**
	 * Column Info
	 * @return receiverRdnRmk
	 */
	public String getReceiverRdnRmk() {
		return this.receiverRdnRmk;
	}
	/**
	 * Column Info
	 * @return bkgCtrtTpCd
	 */
	public String getBkgCtrtTpCd() {
		return this.bkgCtrtTpCd;
	}
	/**
	 * Column Info
	 * @return umchTpCd
	 */
	public String getErUmchTpCd() {
		return this.erUmchTpCd;
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
	 * @param revAudToolNm
	 */
	public void setRevAudToolNm(String revAudToolNm) {
		this.revAudToolNm = revAudToolNm;
	}
	
	/**
	 * Column Info
	 * @param respbRhqCd
	 */
	public void setRespbRhqCd(String respbRhqCd) {
		this.respbRhqCd = respbRhqCd;
	}
	
	/**
	 * Column Info
	 * @param issOfcCd
	 */
	public void setIssOfcCd(String issOfcCd) {
		this.issOfcCd = issOfcCd;
	}
	
	/**
	 * Column Info
	 * @param receiverUsrId
	 */
	public void setReceiverUsrId(String receiverUsrId) {
		this.receiverUsrId = receiverUsrId;
	}
	
	/**
	 * Column Info
	 * @param ctrtTpCd
	 */
	public void setCtrtTpCd(String ctrtTpCd) {
		this.ctrtTpCd = ctrtTpCd;
	}
	
	/**
	 * Column Info
	 * @param rdnNo
	 */
	public void setRdnNo(String rdnNo) {
		this.rdnNo = rdnNo;
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
	 * @param umchRmk
	 */
	public void setUmchRmk(String umchRmk) {
		this.umchRmk = umchRmk;
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
	 * Column Info
	 * @param rdnStsNm
	 */
	public void setRdnStsNm(String rdnStsNm) {
		this.rdnStsNm = rdnStsNm;
	}
	
	/**
	 * Column Info
	 * @param revAudToolCd
	 */
	public void setRevAudToolCd(String revAudToolCd) {
		this.revAudToolCd = revAudToolCd;
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
	 * @param umchSubTpCd
	 */
	public void setUmchSubTpCd(String umchSubTpCd) {
		this.umchSubTpCd = umchSubTpCd;
	}
	
	/**
	 * Column Info
	 * @param rdnStsCd
	 */
	public void setRdnStsCd(String rdnStsCd) {
		this.rdnStsCd = rdnStsCd;
	}
	
	/**
	 * Column Info
	 * @param rctRhqCd
	 */
	public void setRctRhqCd(String rctRhqCd) {
		this.rctRhqCd = rctRhqCd;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param rdnIssRsnCd
	 */
	public void setRdnIssRsnCd(String rdnIssRsnCd) {
		this.rdnIssRsnCd = rdnIssRsnCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCorrNo
	 */
	public void setBkgCorrNo(String bkgCorrNo) {
		this.bkgCorrNo = bkgCorrNo;
	}
	
	/**
	 * Column Info
	 * @param rvisSeq
	 */
	public void setRvisSeq(String rvisSeq) {
		this.rvisSeq = rvisSeq;
	}
	
	/**
	 * Column Info
	 * @param rdnIssDtTo
	 */
	public void setRdnIssDtTo(String rdnIssDtTo) {
		this.rdnIssDtTo = rdnIssDtTo;
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
	 * @param usdAmt
	 */
	public void setUsdAmt(String usdAmt) {
		this.usdAmt = usdAmt;
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
	 * @param umchTpCd
	 */
	public void setUmchTpCd(String umchTpCd) {
		this.umchTpCd = umchTpCd;
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
	 * @param respbOfcCd
	 */
	public void setRespbOfcCd(String respbOfcCd) {
		this.respbOfcCd = respbOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rdnIssDtFrom
	 */
	public void setRdnIssDtFrom(String rdnIssDtFrom) {
		this.rdnIssDtFrom = rdnIssDtFrom;
	}
	
	/**
	 * Column Info
	 * @param stlUsrId
	 */
	public void setStlUsrId(String stlUsrId) {
		this.stlUsrId = stlUsrId;
	}
	
	/**
	 * Column Info
	 * @param officeRdnRmk
	 */
	public void setOfficeRdnRmk(String officeRdnRmk) {
		this.officeRdnRmk = officeRdnRmk;
	}
	
	/**
	 * Column Info
	 * @param receiverRdnRmk
	 */
	public void setReceiverRdnRmk(String receiverRdnRmk) {
		this.receiverRdnRmk = receiverRdnRmk;
	}
	/**
	 * Column Info
	 * @param bkgCtrtTpCd
	 */
	public void setBkgCtrtTpCd(String bkgCtrtTpCd) {
		this.bkgCtrtTpCd = bkgCtrtTpCd;
	}
	/**
	 * Column Info
	 * @param umchTpCd
	 */
	public void setErUmchTpCd(String erUmchTpCd) {
		this.erUmchTpCd = erUmchTpCd;
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
		setRctOfcCd(JSPUtil.getParameter(request, prefix + "rct_ofc_cd", ""));
		setRevAudToolNm(JSPUtil.getParameter(request, prefix + "rev_aud_tool_nm", ""));
		setRespbRhqCd(JSPUtil.getParameter(request, prefix + "respb_rhq_cd", ""));
		setIssOfcCd(JSPUtil.getParameter(request, prefix + "iss_ofc_cd", ""));
		setReceiverUsrId(JSPUtil.getParameter(request, prefix + "receiver_usr_id", ""));
		setCtrtTpCd(JSPUtil.getParameter(request, prefix + "ctrt_tp_cd", ""));
		setRdnNo(JSPUtil.getParameter(request, prefix + "rdn_no", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setUmchRmk(JSPUtil.getParameter(request, prefix + "umch_rmk", ""));
		setIssUsrId(JSPUtil.getParameter(request, prefix + "iss_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRdnStsNm(JSPUtil.getParameter(request, prefix + "rdn_sts_nm", ""));
		setRevAudToolCd(JSPUtil.getParameter(request, prefix + "rev_aud_tool_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUmchSubTpCd(JSPUtil.getParameter(request, prefix + "umch_sub_tp_cd", ""));
		setRdnStsCd(JSPUtil.getParameter(request, prefix + "rdn_sts_cd", ""));
		setRctRhqCd(JSPUtil.getParameter(request, prefix + "rct_rhq_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setRdnIssRsnCd(JSPUtil.getParameter(request, prefix + "rdn_iss_rsn_cd", ""));
		setBkgCorrNo(JSPUtil.getParameter(request, prefix + "bkg_corr_no", ""));
		setRvisSeq(JSPUtil.getParameter(request, prefix + "rvis_seq", ""));
		setRdnIssDtTo(JSPUtil.getParameter(request, prefix + "rdn_iss_dt_to", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setUsdAmt(JSPUtil.getParameter(request, prefix + "usd_amt", ""));
		setScRfaNo(JSPUtil.getParameter(request, prefix + "sc_rfa_no", ""));
		setUmchTpCd(JSPUtil.getParameter(request, prefix + "umch_tp_cd", ""));
		setRdnIssDt(JSPUtil.getParameter(request, prefix + "rdn_iss_dt", ""));
		setRespbOfcCd(JSPUtil.getParameter(request, prefix + "respb_ofc_cd", ""));
		setRdnIssDtFrom(JSPUtil.getParameter(request, prefix + "rdn_iss_dt_from", ""));
		setStlUsrId(JSPUtil.getParameter(request, prefix + "stl_usr_id", ""));
		setOfficeRdnRmk(JSPUtil.getParameter(request, prefix + "office_rdn_rmk", ""));
		setReceiverRdnRmk(JSPUtil.getParameter(request, prefix + "receiver_rdn_rmk", ""));
		setBkgCtrtTpCd(JSPUtil.getParameter(request, prefix + "bkg_ctrt_tp_cd", ""));
		setErUmchTpCd(JSPUtil.getParameter(request, prefix + "er_umch_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltBkgRevDrNotesStatusVO[]
	 */
	public RsltBkgRevDrNotesStatusVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltBkgRevDrNotesStatusVO[]
	 */
	public RsltBkgRevDrNotesStatusVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltBkgRevDrNotesStatusVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rctOfcCd = (JSPUtil.getParameter(request, prefix	+ "rct_ofc_cd", length));
			String[] revAudToolNm = (JSPUtil.getParameter(request, prefix	+ "rev_aud_tool_nm", length));
			String[] respbRhqCd = (JSPUtil.getParameter(request, prefix	+ "respb_rhq_cd", length));
			String[] issOfcCd = (JSPUtil.getParameter(request, prefix	+ "iss_ofc_cd", length));
			String[] receiverUsrId = (JSPUtil.getParameter(request, prefix	+ "receiver_usr_id", length));
			String[] ctrtTpCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_tp_cd", length));
			String[] rdnNo = (JSPUtil.getParameter(request, prefix	+ "rdn_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] umchRmk = (JSPUtil.getParameter(request, prefix	+ "umch_rmk", length));
			String[] issUsrId = (JSPUtil.getParameter(request, prefix	+ "iss_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rdnStsNm = (JSPUtil.getParameter(request, prefix	+ "rdn_sts_nm", length));
			String[] revAudToolCd = (JSPUtil.getParameter(request, prefix	+ "rev_aud_tool_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] umchSubTpCd = (JSPUtil.getParameter(request, prefix	+ "umch_sub_tp_cd", length));
			String[] rdnStsCd = (JSPUtil.getParameter(request, prefix	+ "rdn_sts_cd", length));
			String[] rctRhqCd = (JSPUtil.getParameter(request, prefix	+ "rct_rhq_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] rdnIssRsnCd = (JSPUtil.getParameter(request, prefix	+ "rdn_iss_rsn_cd", length));
			String[] bkgCorrNo = (JSPUtil.getParameter(request, prefix	+ "bkg_corr_no", length));
			String[] rvisSeq = (JSPUtil.getParameter(request, prefix	+ "rvis_seq", length));
			String[] rdnIssDtTo = (JSPUtil.getParameter(request, prefix	+ "rdn_iss_dt_to", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] usdAmt = (JSPUtil.getParameter(request, prefix	+ "usd_amt", length));
			String[] scRfaNo = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_no", length));
			String[] umchTpCd = (JSPUtil.getParameter(request, prefix	+ "umch_tp_cd", length));
			String[] rdnIssDt = (JSPUtil.getParameter(request, prefix	+ "rdn_iss_dt", length));
			String[] respbOfcCd = (JSPUtil.getParameter(request, prefix	+ "respb_ofc_cd", length));
			String[] rdnIssDtFrom = (JSPUtil.getParameter(request, prefix	+ "rdn_iss_dt_from", length));
			String[] stlUsrId = (JSPUtil.getParameter(request, prefix	+ "stl_usr_id", length));
			String[] officeRdnRmk = (JSPUtil.getParameter(request, prefix	+ "office_rdn_rmk", length));
			String[] receiverRdnRmk = (JSPUtil.getParameter(request, prefix	+ "receiver_rdn_rmk", length));
			String[] bkgCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrt_tp_cd", length));
			String[] erUmchTpCd = (JSPUtil.getParameter(request, prefix	+ "er_umch_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltBkgRevDrNotesStatusVO();
				if (rctOfcCd[i] != null)
					model.setRctOfcCd(rctOfcCd[i]);
				if (revAudToolNm[i] != null)
					model.setRevAudToolNm(revAudToolNm[i]);
				if (respbRhqCd[i] != null)
					model.setRespbRhqCd(respbRhqCd[i]);
				if (issOfcCd[i] != null)
					model.setIssOfcCd(issOfcCd[i]);
				if (receiverUsrId[i] != null)
					model.setReceiverUsrId(receiverUsrId[i]);
				if (ctrtTpCd[i] != null)
					model.setCtrtTpCd(ctrtTpCd[i]);
				if (rdnNo[i] != null)
					model.setRdnNo(rdnNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (umchRmk[i] != null)
					model.setUmchRmk(umchRmk[i]);
				if (issUsrId[i] != null)
					model.setIssUsrId(issUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rdnStsNm[i] != null)
					model.setRdnStsNm(rdnStsNm[i]);
				if (revAudToolCd[i] != null)
					model.setRevAudToolCd(revAudToolCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (umchSubTpCd[i] != null)
					model.setUmchSubTpCd(umchSubTpCd[i]);
				if (rdnStsCd[i] != null)
					model.setRdnStsCd(rdnStsCd[i]);
				if (rctRhqCd[i] != null)
					model.setRctRhqCd(rctRhqCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rdnIssRsnCd[i] != null)
					model.setRdnIssRsnCd(rdnIssRsnCd[i]);
				if (bkgCorrNo[i] != null)
					model.setBkgCorrNo(bkgCorrNo[i]);
				if (rvisSeq[i] != null)
					model.setRvisSeq(rvisSeq[i]);
				if (rdnIssDtTo[i] != null)
					model.setRdnIssDtTo(rdnIssDtTo[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (usdAmt[i] != null)
					model.setUsdAmt(usdAmt[i]);
				if (scRfaNo[i] != null)
					model.setScRfaNo(scRfaNo[i]);
				if (umchTpCd[i] != null)
					model.setUmchTpCd(umchTpCd[i]);
				if (rdnIssDt[i] != null)
					model.setRdnIssDt(rdnIssDt[i]);
				if (respbOfcCd[i] != null)
					model.setRespbOfcCd(respbOfcCd[i]);
				if (rdnIssDtFrom[i] != null)
					model.setRdnIssDtFrom(rdnIssDtFrom[i]);
				if (stlUsrId[i] != null)
					model.setStlUsrId(stlUsrId[i]);
				if (officeRdnRmk[i] != null)
					model.setOfficeRdnRmk(officeRdnRmk[i]);
				if (receiverRdnRmk[i] != null)
					model.setReceiverRdnRmk(receiverRdnRmk[i]);
				if (bkgCtrtTpCd[i] != null)
					model.setBkgCtrtTpCd(bkgCtrtTpCd[i]);
				if (erUmchTpCd[i] != null)
					model.setErUmchTpCd(erUmchTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltBkgRevDrNotesStatusVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltBkgRevDrNotesStatusVO[]
	 */
	public RsltBkgRevDrNotesStatusVO[] getRsltBkgRevDrNotesStatusVOs(){
		RsltBkgRevDrNotesStatusVO[] vos = (RsltBkgRevDrNotesStatusVO[])models.toArray(new RsltBkgRevDrNotesStatusVO[models.size()]);
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
		this.rctOfcCd = this.rctOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revAudToolNm = this.revAudToolNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.respbRhqCd = this.respbRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issOfcCd = this.issOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.receiverUsrId = this.receiverUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtTpCd = this.ctrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdnNo = this.rdnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchRmk = this.umchRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issUsrId = this.issUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdnStsNm = this.rdnStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revAudToolCd = this.revAudToolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchSubTpCd = this.umchSubTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdnStsCd = this.rdnStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctRhqCd = this.rctRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdnIssRsnCd = this.rdnIssRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCorrNo = this.bkgCorrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisSeq = this.rvisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdnIssDtTo = this.rdnIssDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdAmt = this.usdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaNo = this.scRfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchTpCd = this.umchTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdnIssDt = this.rdnIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.respbOfcCd = this.respbOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdnIssDtFrom = this.rdnIssDtFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlUsrId = this.stlUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.officeRdnRmk = this.officeRdnRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.receiverRdnRmk = this.receiverRdnRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrtTpCd = this.bkgCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.erUmchTpCd = this.erUmchTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
