/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltBkgRevDrNoteVO.java
*@FileTitle : RsltBkgRevDrNoteVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.19
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2010.01.19 김대호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김대호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltBkgRevDrNoteVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltBkgRevDrNoteVO> models = new ArrayList<RsltBkgRevDrNoteVO>();
	
	/* Column Info */
	private String rctOfcCd = null;
	/* Column Info */
	private String respbRhqCd = null;
	/* Column Info */
	private String issOfcCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ctrtTpCd = null;
	/* Column Info */
	private String umchRmk = null;
	/* Column Info */
	private String rdnNo = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rdnStsNm = null;
	/* Column Info */
	private String revAudToolCd = null;
	/* Column Info */
	private String blNoChk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rdnIssDtWk = null;
	/* Column Info */
	private String umchSubTpCd = null;
	/* Column Info */
	private String blNoTp = null;
	/* Column Info */
	private String rdnStsCd = null;
	/* Column Info */
	private String receiverRmk = null;
	/* Column Info */
	private String rctRhqCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rdnIssRsnCd = null;
	/* Column Info */
	private String bkgNoSplit = null;
	/* Column Info */
	private String bkgCorrNo = null;
	/* Column Info */
	private String progSeq = null;
	/* Column Info */
	private String rdnRmk = null;
	/* Column Info */
	private String rvisSeq = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String stsUpdDt = null;
	/* Column Info */
	private String scRfaNo = null;
	/* Column Info */
	private String umchTpCd = null;
	/* Column Info */
	private String rdnIssDt = null;
	/* Column Info */
	private String respbOfcCd = null;
	/* Column Info */
	private String rdnKndCd = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String n3ptyNo = null;
	/* Column Info */
	private String atchFileLnkId = null;
	/* Column Info */
	private String fileCnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltBkgRevDrNoteVO() {}

	public RsltBkgRevDrNoteVO(String ibflag, String pagerows, String rdnNo, String rvisSeq, String issOfcCd, String rctRhqCd, String rctOfcCd, String respbOfcCd, String umchTpCd, String umchSubTpCd, String rdnIssRsnCd, String umchRmk, String rdnStsCd, String rdnStsNm, String rdnIssDt, String rdnIssDtWk, String creUsrId, String creDt, String updUsrId, String updDt, String bkgNo, String bkgCorrNo, String blNo, String scRfaNo, String stsUpdDt, String respbRhqCd, String revAudToolCd, String ctrtTpCd, String blNoChk, String blNoTp, String receiverRmk, String bkgNoSplit, String progSeq, String rdnRmk, String rdnKndCd, String invNo, String vvdCd, String n3ptyNo, String atchFileLnkId, String fileCnt) {
		this.rctOfcCd = rctOfcCd;
		this.respbRhqCd = respbRhqCd;
		this.issOfcCd = issOfcCd;
		this.creDt = creDt;
		this.ctrtTpCd = ctrtTpCd;
		this.umchRmk = umchRmk;
		this.rdnNo = rdnNo;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.rdnStsNm = rdnStsNm;
		this.revAudToolCd = revAudToolCd;
		this.blNoChk = blNoChk;
		this.ibflag = ibflag;
		this.rdnIssDtWk = rdnIssDtWk;
		this.umchSubTpCd = umchSubTpCd;
		this.blNoTp = blNoTp;
		this.rdnStsCd = rdnStsCd;
		this.receiverRmk = receiverRmk;
		this.rctRhqCd = rctRhqCd;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.rdnIssRsnCd = rdnIssRsnCd;
		this.bkgNoSplit = bkgNoSplit;
		this.bkgCorrNo = bkgCorrNo;
		this.progSeq = progSeq;
		this.rdnRmk = rdnRmk;
		this.rvisSeq = rvisSeq;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.stsUpdDt = stsUpdDt;
		this.scRfaNo = scRfaNo;
		this.umchTpCd = umchTpCd;
		this.rdnIssDt = rdnIssDt;
		this.respbOfcCd = respbOfcCd;
		this.rdnKndCd = rdnKndCd;
		this.invNo = invNo;
		this.vvdCd = vvdCd;
		this.n3ptyNo = n3ptyNo;
		this.atchFileLnkId = atchFileLnkId;
		this.fileCnt = fileCnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rct_ofc_cd", getRctOfcCd());
		this.hashColumns.put("respb_rhq_cd", getRespbRhqCd());
		this.hashColumns.put("iss_ofc_cd", getIssOfcCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ctrt_tp_cd", getCtrtTpCd());
		this.hashColumns.put("umch_rmk", getUmchRmk());
		this.hashColumns.put("rdn_no", getRdnNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rdn_sts_nm", getRdnStsNm());
		this.hashColumns.put("rev_aud_tool_cd", getRevAudToolCd());
		this.hashColumns.put("bl_no_chk", getBlNoChk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rdn_iss_dt_wk", getRdnIssDtWk());
		this.hashColumns.put("umch_sub_tp_cd", getUmchSubTpCd());
		this.hashColumns.put("bl_no_tp", getBlNoTp());
		this.hashColumns.put("rdn_sts_cd", getRdnStsCd());
		this.hashColumns.put("receiver_rmk", getReceiverRmk());
		this.hashColumns.put("rct_rhq_cd", getRctRhqCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rdn_iss_rsn_cd", getRdnIssRsnCd());
		this.hashColumns.put("bkg_no_split", getBkgNoSplit());
		this.hashColumns.put("bkg_corr_no", getBkgCorrNo());
		this.hashColumns.put("prog_seq", getProgSeq());
		this.hashColumns.put("rdn_rmk", getRdnRmk());
		this.hashColumns.put("rvis_seq", getRvisSeq());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("sts_upd_dt", getStsUpdDt());
		this.hashColumns.put("sc_rfa_no", getScRfaNo());
		this.hashColumns.put("umch_tp_cd", getUmchTpCd());
		this.hashColumns.put("rdn_iss_dt", getRdnIssDt());
		this.hashColumns.put("respb_ofc_cd", getRespbOfcCd());
		this.hashColumns.put("rdn_knd_cd", getRdnKndCd());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("n3pty_no", getN3ptyNo());
		this.hashColumns.put("atch_file_lnk_id", getAtchFileLnkId());
		this.hashColumns.put("file_cnt", getFileCnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rct_ofc_cd", "rctOfcCd");
		this.hashFields.put("respb_rhq_cd", "respbRhqCd");
		this.hashFields.put("iss_ofc_cd", "issOfcCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ctrt_tp_cd", "ctrtTpCd");
		this.hashFields.put("umch_rmk", "umchRmk");
		this.hashFields.put("rdn_no", "rdnNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rdn_sts_nm", "rdnStsNm");
		this.hashFields.put("rev_aud_tool_cd", "revAudToolCd");
		this.hashFields.put("bl_no_chk", "blNoChk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rdn_iss_dt_wk", "rdnIssDtWk");
		this.hashFields.put("umch_sub_tp_cd", "umchSubTpCd");
		this.hashFields.put("bl_no_tp", "blNoTp");
		this.hashFields.put("rdn_sts_cd", "rdnStsCd");
		this.hashFields.put("receiver_rmk", "receiverRmk");
		this.hashFields.put("rct_rhq_cd", "rctRhqCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rdn_iss_rsn_cd", "rdnIssRsnCd");
		this.hashFields.put("bkg_no_split", "bkgNoSplit");
		this.hashFields.put("bkg_corr_no", "bkgCorrNo");
		this.hashFields.put("prog_seq", "progSeq");
		this.hashFields.put("rdn_rmk", "rdnRmk");
		this.hashFields.put("rvis_seq", "rvisSeq");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("sts_upd_dt", "stsUpdDt");
		this.hashFields.put("sc_rfa_no", "scRfaNo");
		this.hashFields.put("umch_tp_cd", "umchTpCd");
		this.hashFields.put("rdn_iss_dt", "rdnIssDt");
		this.hashFields.put("respb_ofc_cd", "respbOfcCd");
		this.hashFields.put("rdn_knd_cd", "rdnKndCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("n3pty_no", "n3ptyNo");
		this.hashFields.put("file_cnt", "fileCnt");
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return umchRmk
	 */
	public String getUmchRmk() {
		return this.umchRmk;
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
	 * Column Info
	 * @return blNoChk
	 */
	public String getBlNoChk() {
		return this.blNoChk;
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
	 * @return rdnIssDtWk
	 */
	public String getRdnIssDtWk() {
		return this.rdnIssDtWk;
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
	 * @return blNoTp
	 */
	public String getBlNoTp() {
		return this.blNoTp;
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
	 * @return receiverRmk
	 */
	public String getReceiverRmk() {
		return this.receiverRmk;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @return bkgNoSplit
	 */
	public String getBkgNoSplit() {
		return this.bkgNoSplit;
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
	 * @return progSeq
	 */
	public String getProgSeq() {
		return this.progSeq;
	}
	
	/**
	 * Column Info
	 * @return rdnRmk
	 */
	public String getRdnRmk() {
		return this.rdnRmk;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return stsUpdDt
	 */
	public String getStsUpdDt() {
		return this.stsUpdDt;
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
	 * @return rdnKndCd
	 */
	public String getRdnKndCd() {
		return this.rdnKndCd;
	}
	
	/**
	 * Column Info
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyNo
	 */
	public String getN3ptyNo() {
		return this.n3ptyNo;
	}
	
	/**
	 * Column Info
	 * @return atchFileLnkId
	 */
	public String getAtchFileLnkId() {
		return this.atchFileLnkId;
	}
	
	/**
	 * Column Info
	 * @return fileCnt
	 */
	public String getFileCnt() {
		return this.fileCnt;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param umchRmk
	 */
	public void setUmchRmk(String umchRmk) {
		this.umchRmk = umchRmk;
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
	 * Column Info
	 * @param blNoChk
	 */
	public void setBlNoChk(String blNoChk) {
		this.blNoChk = blNoChk;
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
	 * @param rdnIssDtWk
	 */
	public void setRdnIssDtWk(String rdnIssDtWk) {
		this.rdnIssDtWk = rdnIssDtWk;
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
	 * @param blNoTp
	 */
	public void setBlNoTp(String blNoTp) {
		this.blNoTp = blNoTp;
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
	 * @param receiverRmk
	 */
	public void setReceiverRmk(String receiverRmk) {
		this.receiverRmk = receiverRmk;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
	 * @param bkgNoSplit
	 */
	public void setBkgNoSplit(String bkgNoSplit) {
		this.bkgNoSplit = bkgNoSplit;
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
	 * @param progSeq
	 */
	public void setProgSeq(String progSeq) {
		this.progSeq = progSeq;
	}
	
	/**
	 * Column Info
	 * @param rdnRmk
	 */
	public void setRdnRmk(String rdnRmk) {
		this.rdnRmk = rdnRmk;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param stsUpdDt
	 */
	public void setStsUpdDt(String stsUpdDt) {
		this.stsUpdDt = stsUpdDt;
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
	 * @param rdnKndCd
	 */
	public void setRdnKndCd(String rdnKndCd) {
		this.rdnKndCd = rdnKndCd;
	}
	
	/**
	 * Column Info
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyNo
	 */
	public void setN3ptyNo(String n3ptyNo) {
		this.n3ptyNo = n3ptyNo;
	}
	
	/**
	 * Column Info
	 * @param atchFileLnkId
	 */
	public void setAtchFileLnkId(String atchFileLnkId) {
		this.atchFileLnkId = atchFileLnkId;
	}
	
	/**
	 * Column Info
	 * @param fileCnt
	 */
	public void setFileCnt(String fileCnt) {
		this.fileCnt = fileCnt;
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
		setRespbRhqCd(JSPUtil.getParameter(request, prefix + "respb_rhq_cd", ""));
		setIssOfcCd(JSPUtil.getParameter(request, prefix + "iss_ofc_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCtrtTpCd(JSPUtil.getParameter(request, prefix + "ctrt_tp_cd", ""));
		setUmchRmk(JSPUtil.getParameter(request, prefix + "umch_rmk", ""));
		setRdnNo(JSPUtil.getParameter(request, prefix + "rdn_no", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRdnStsNm(JSPUtil.getParameter(request, prefix + "rdn_sts_nm", ""));
		setRevAudToolCd(JSPUtil.getParameter(request, prefix + "rev_aud_tool_cd", ""));
		setBlNoChk(JSPUtil.getParameter(request, prefix + "bl_no_chk", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRdnIssDtWk(JSPUtil.getParameter(request, prefix + "rdn_iss_dt_wk", ""));
		setUmchSubTpCd(JSPUtil.getParameter(request, prefix + "umch_sub_tp_cd", ""));
		setBlNoTp(JSPUtil.getParameter(request, prefix + "bl_no_tp", ""));
		setRdnStsCd(JSPUtil.getParameter(request, prefix + "rdn_sts_cd", ""));
		setReceiverRmk(JSPUtil.getParameter(request, prefix + "receiver_rmk", ""));
		setRctRhqCd(JSPUtil.getParameter(request, prefix + "rct_rhq_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setRdnIssRsnCd(JSPUtil.getParameter(request, prefix + "rdn_iss_rsn_cd", ""));
		setBkgNoSplit(JSPUtil.getParameter(request, prefix + "bkg_no_split", ""));
		setBkgCorrNo(JSPUtil.getParameter(request, prefix + "bkg_corr_no", ""));
		setProgSeq(JSPUtil.getParameter(request, prefix + "prog_seq", ""));
		setRdnRmk(JSPUtil.getParameter(request, prefix + "rdn_rmk", ""));
		setRvisSeq(JSPUtil.getParameter(request, prefix + "rvis_seq", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setStsUpdDt(JSPUtil.getParameter(request, prefix + "sts_upd_dt", ""));
		setScRfaNo(JSPUtil.getParameter(request, prefix + "sc_rfa_no", ""));
		setUmchTpCd(JSPUtil.getParameter(request, prefix + "umch_tp_cd", ""));
		setRdnIssDt(JSPUtil.getParameter(request, prefix + "rdn_iss_dt", ""));
		setRespbOfcCd(JSPUtil.getParameter(request, prefix + "respb_ofc_cd", ""));
		setRdnKndCd(JSPUtil.getParameter(request, "rdn_knd_cd", ""));
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setN3ptyNo(JSPUtil.getParameter(request, "n3pty_no", ""));
		setAtchFileLnkId(JSPUtil.getParameter(request, "atch_file_lnk_id", ""));
		setFileCnt(JSPUtil.getParameter(request, "file_cnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltBkgRevDrNoteVO[]
	 */
	public RsltBkgRevDrNoteVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltBkgRevDrNoteVO[]
	 */
	public RsltBkgRevDrNoteVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltBkgRevDrNoteVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rctOfcCd = (JSPUtil.getParameter(request, prefix	+ "rct_ofc_cd", length));
			String[] respbRhqCd = (JSPUtil.getParameter(request, prefix	+ "respb_rhq_cd", length));
			String[] issOfcCd = (JSPUtil.getParameter(request, prefix	+ "iss_ofc_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ctrtTpCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_tp_cd", length));
			String[] umchRmk = (JSPUtil.getParameter(request, prefix	+ "umch_rmk", length));
			String[] rdnNo = (JSPUtil.getParameter(request, prefix	+ "rdn_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rdnStsNm = (JSPUtil.getParameter(request, prefix	+ "rdn_sts_nm", length));
			String[] revAudToolCd = (JSPUtil.getParameter(request, prefix	+ "rev_aud_tool_cd", length));
			String[] blNoChk = (JSPUtil.getParameter(request, prefix	+ "bl_no_chk", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rdnIssDtWk = (JSPUtil.getParameter(request, prefix	+ "rdn_iss_dt_wk", length));
			String[] umchSubTpCd = (JSPUtil.getParameter(request, prefix	+ "umch_sub_tp_cd", length));
			String[] blNoTp = (JSPUtil.getParameter(request, prefix	+ "bl_no_tp", length));
			String[] rdnStsCd = (JSPUtil.getParameter(request, prefix	+ "rdn_sts_cd", length));
			String[] receiverRmk = (JSPUtil.getParameter(request, prefix	+ "receiver_rmk", length));
			String[] rctRhqCd = (JSPUtil.getParameter(request, prefix	+ "rct_rhq_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] rdnIssRsnCd = (JSPUtil.getParameter(request, prefix	+ "rdn_iss_rsn_cd", length));
			String[] bkgNoSplit = (JSPUtil.getParameter(request, prefix	+ "bkg_no_split", length));
			String[] bkgCorrNo = (JSPUtil.getParameter(request, prefix	+ "bkg_corr_no", length));
			String[] progSeq = (JSPUtil.getParameter(request, prefix	+ "prog_seq", length));
			String[] rdnRmk = (JSPUtil.getParameter(request, prefix	+ "rdn_rmk", length));
			String[] rvisSeq = (JSPUtil.getParameter(request, prefix	+ "rvis_seq", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] stsUpdDt = (JSPUtil.getParameter(request, prefix	+ "sts_upd_dt", length));
			String[] scRfaNo = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_no", length));
			String[] umchTpCd = (JSPUtil.getParameter(request, prefix	+ "umch_tp_cd", length));
			String[] rdnIssDt = (JSPUtil.getParameter(request, prefix	+ "rdn_iss_dt", length));
			String[] respbOfcCd = (JSPUtil.getParameter(request, prefix	+ "respb_ofc_cd", length));
			String[] rdnKndCd = (JSPUtil.getParameter(request, prefix	+ "rdn_knd_cd", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] n3ptyNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_no", length));
			String[] atchFileLnkId = (JSPUtil.getParameter(request, prefix	+ "atch_file_lnk_id", length));
			String[] fileCnt = (JSPUtil.getParameter(request, prefix	+ "file_cnt", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltBkgRevDrNoteVO();
				if (rctOfcCd[i] != null)
					model.setRctOfcCd(rctOfcCd[i]);
				if (respbRhqCd[i] != null)
					model.setRespbRhqCd(respbRhqCd[i]);
				if (issOfcCd[i] != null)
					model.setIssOfcCd(issOfcCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ctrtTpCd[i] != null)
					model.setCtrtTpCd(ctrtTpCd[i]);
				if (umchRmk[i] != null)
					model.setUmchRmk(umchRmk[i]);
				if (rdnNo[i] != null)
					model.setRdnNo(rdnNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rdnStsNm[i] != null)
					model.setRdnStsNm(rdnStsNm[i]);
				if (revAudToolCd[i] != null)
					model.setRevAudToolCd(revAudToolCd[i]);
				if (blNoChk[i] != null)
					model.setBlNoChk(blNoChk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rdnIssDtWk[i] != null)
					model.setRdnIssDtWk(rdnIssDtWk[i]);
				if (umchSubTpCd[i] != null)
					model.setUmchSubTpCd(umchSubTpCd[i]);
				if (blNoTp[i] != null)
					model.setBlNoTp(blNoTp[i]);
				if (rdnStsCd[i] != null)
					model.setRdnStsCd(rdnStsCd[i]);
				if (receiverRmk[i] != null)
					model.setReceiverRmk(receiverRmk[i]);
				if (rctRhqCd[i] != null)
					model.setRctRhqCd(rctRhqCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rdnIssRsnCd[i] != null)
					model.setRdnIssRsnCd(rdnIssRsnCd[i]);
				if (bkgNoSplit[i] != null)
					model.setBkgNoSplit(bkgNoSplit[i]);
				if (bkgCorrNo[i] != null)
					model.setBkgCorrNo(bkgCorrNo[i]);
				if (progSeq[i] != null)
					model.setProgSeq(progSeq[i]);
				if (rdnRmk[i] != null)
					model.setRdnRmk(rdnRmk[i]);
				if (rvisSeq[i] != null)
					model.setRvisSeq(rvisSeq[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (stsUpdDt[i] != null)
					model.setStsUpdDt(stsUpdDt[i]);
				if (scRfaNo[i] != null)
					model.setScRfaNo(scRfaNo[i]);
				if (umchTpCd[i] != null)
					model.setUmchTpCd(umchTpCd[i]);
				if (rdnIssDt[i] != null)
					model.setRdnIssDt(rdnIssDt[i]);
				if (respbOfcCd[i] != null)
					model.setRespbOfcCd(respbOfcCd[i]);
				if (rdnKndCd[i] != null)
					model.setRdnKndCd(rdnKndCd[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (n3ptyNo[i] != null)
					model.setN3ptyNo(n3ptyNo[i]);
				if (atchFileLnkId[i] != null)
					model.setAtchFileLnkId(atchFileLnkId[i]);
				if (fileCnt[i] != null)
					model.setFileCnt(fileCnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltBkgRevDrNoteVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltBkgRevDrNoteVO[]
	 */
	public RsltBkgRevDrNoteVO[] getRsltBkgRevDrNoteVOs(){
		RsltBkgRevDrNoteVO[] vos = (RsltBkgRevDrNoteVO[])models.toArray(new RsltBkgRevDrNoteVO[models.size()]);
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
		this.respbRhqCd = this.respbRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issOfcCd = this.issOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtTpCd = this.ctrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchRmk = this.umchRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdnNo = this.rdnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdnStsNm = this.rdnStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revAudToolCd = this.revAudToolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoChk = this.blNoChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdnIssDtWk = this.rdnIssDtWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchSubTpCd = this.umchSubTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoTp = this.blNoTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdnStsCd = this.rdnStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.receiverRmk = this.receiverRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctRhqCd = this.rctRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdnIssRsnCd = this.rdnIssRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoSplit = this.bkgNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCorrNo = this.bkgCorrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.progSeq = this.progSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdnRmk = this.rdnRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisSeq = this.rvisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsUpdDt = this.stsUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaNo = this.scRfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchTpCd = this.umchTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdnIssDt = this.rdnIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.respbOfcCd = this.respbOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdnKndCd = this.rdnKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNo = this.n3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileLnkId = this.atchFileLnkId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileCnt = this.fileCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
