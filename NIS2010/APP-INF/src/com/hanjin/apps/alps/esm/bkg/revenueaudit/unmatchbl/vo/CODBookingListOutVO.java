/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CODBookingListOutVO.java
*@FileTitle : CODBookingListOutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.26
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.26  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo;

import java.lang.reflect.Field;
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CODBookingListOutVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CODBookingListOutVO> models = new ArrayList<CODBookingListOutVO>();
	
	/* Column Info */
	private String selfAudit = null;
	/* Column Info */
	private String dvcRatUtCd = null;
	/* Column Info */
	private String newPorYdCd = null;
	/* Column Info */
	private String rtAplyDt = null;
	/* Column Info */
	private String bdrFlg = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String codRatUtCd = null;
	/* Column Info */
	private String dvcCurrCd = null;
	/* Column Info */
	private String codAmt = null;
	/* Column Info */
	private String codCurrCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String rdnNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ctrtNo = null;
	/* Column Info */
	private String rdnStsNm = null;
	/* Column Info */
	private String oldPolYdCd = null;
	/* Column Info */
	private String newDelYdCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String umchRsnRmk = null;
	/* Column Info */
	private String codRqstSeq = null;
	/* Column Info */
	private String oldDelYdCd = null;
	/* Column Info */
	private String oftAmt = null;
	/* Column Info */
	private String oftCurrCd = null;
	/* Column Info */
	private String codRqstRsnCd = null;
	/* Column Info */
	private String bkgCtrtTpCd = null;
	/* Column Info */
	private String dvcAmt = null;
	/* Column Info */
	private String codChgCd = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String rgnGrpAvcRmk = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String oldPodYdCd = null;
	/* Column Info */
	private String newPolYdCd = null;
	/* Column Info */
	private String oftRatUtCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String newPodYdCd = null;
	/* Column Info */
	private String oldPorYdCd = null;
	/* Column Info */
	private String blCnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CODBookingListOutVO() {}

	public CODBookingListOutVO(String ibflag, String pagerows, String seq, String rhqCd, String bkgOfcCd, String svcScpCd, String bkgNo, String blNo, String bdrFlg, String rtAplyDt, String vpsEtdDt, String bkgCtrtTpCd, String ctrtNo, String codRqstRsnCd, String codRqstSeq, String rdnNo, String selfAudit, String rdnStsNm, String umchRsnRmk, String rgnGrpAvcRmk, String oldPorYdCd, String oldPolYdCd, String oldPodYdCd, String oldDelYdCd, String newPorYdCd, String newPolYdCd, String newPodYdCd, String newDelYdCd, String oftRatUtCd, String oftAmt, String oftCurrCd, String dvcRatUtCd, String dvcAmt, String dvcCurrCd, String blCnt, String codChgCd, String codRatUtCd, String codAmt, String codCurrCd) {
		this.selfAudit = selfAudit;
		this.dvcRatUtCd = dvcRatUtCd;
		this.newPorYdCd = newPorYdCd;
		this.rtAplyDt = rtAplyDt;
		this.bdrFlg = bdrFlg;
		this.svcScpCd = svcScpCd;
		this.codRatUtCd = codRatUtCd;
		this.dvcCurrCd = dvcCurrCd;
		this.codAmt = codAmt;
		this.codCurrCd = codCurrCd;
		this.blNo = blNo;
		this.rdnNo = rdnNo;
		this.pagerows = pagerows;
		this.ctrtNo = ctrtNo;
		this.rdnStsNm = rdnStsNm;
		this.oldPolYdCd = oldPolYdCd;
		this.newDelYdCd = newDelYdCd;
		this.ibflag = ibflag;
		this.umchRsnRmk = umchRsnRmk;
		this.codRqstSeq = codRqstSeq;
		this.oldDelYdCd = oldDelYdCd;
		this.oftAmt = oftAmt;
		this.oftCurrCd = oftCurrCd;
		this.codRqstRsnCd = codRqstRsnCd;
		this.bkgCtrtTpCd = bkgCtrtTpCd;
		this.dvcAmt = dvcAmt;
		this.codChgCd = codChgCd;
		this.bkgOfcCd = bkgOfcCd;
		this.rgnGrpAvcRmk = rgnGrpAvcRmk;
		this.vpsEtdDt = vpsEtdDt;
		this.rhqCd = rhqCd;
		this.oldPodYdCd = oldPodYdCd;
		this.newPolYdCd = newPolYdCd;
		this.oftRatUtCd = oftRatUtCd;
		this.bkgNo = bkgNo;
		this.seq = seq;
		this.newPodYdCd = newPodYdCd;
		this.oldPorYdCd = oldPorYdCd;
		this.blCnt = blCnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("self_audit", getSelfAudit());
		this.hashColumns.put("dvc_rat_ut_cd", getDvcRatUtCd());
		this.hashColumns.put("new_por_yd_cd", getNewPorYdCd());
		this.hashColumns.put("rt_aply_dt", getRtAplyDt());
		this.hashColumns.put("bdr_flg", getBdrFlg());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("cod_rat_ut_cd", getCodRatUtCd());
		this.hashColumns.put("dvc_curr_cd", getDvcCurrCd());
		this.hashColumns.put("cod_amt", getCodAmt());
		this.hashColumns.put("cod_curr_cd", getCodCurrCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("rdn_no", getRdnNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ctrt_no", getCtrtNo());
		this.hashColumns.put("rdn_sts_nm", getRdnStsNm());
		this.hashColumns.put("old_pol_yd_cd", getOldPolYdCd());
		this.hashColumns.put("new_del_yd_cd", getNewDelYdCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("umch_rsn_rmk", getUmchRsnRmk());
		this.hashColumns.put("cod_rqst_seq", getCodRqstSeq());
		this.hashColumns.put("old_del_yd_cd", getOldDelYdCd());
		this.hashColumns.put("oft_amt", getOftAmt());
		this.hashColumns.put("oft_curr_cd", getOftCurrCd());
		this.hashColumns.put("cod_rqst_rsn_cd", getCodRqstRsnCd());
		this.hashColumns.put("bkg_ctrt_tp_cd", getBkgCtrtTpCd());
		this.hashColumns.put("dvc_amt", getDvcAmt());
		this.hashColumns.put("cod_chg_cd", getCodChgCd());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("rgn_grp_avc_rmk", getRgnGrpAvcRmk());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("old_pod_yd_cd", getOldPodYdCd());
		this.hashColumns.put("new_pol_yd_cd", getNewPolYdCd());
		this.hashColumns.put("oft_rat_ut_cd", getOftRatUtCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("new_pod_yd_cd", getNewPodYdCd());
		this.hashColumns.put("old_por_yd_cd", getOldPorYdCd());
		this.hashColumns.put("bl_cnt", getBlCnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("self_audit", "selfAudit");
		this.hashFields.put("dvc_rat_ut_cd", "dvcRatUtCd");
		this.hashFields.put("new_por_yd_cd", "newPorYdCd");
		this.hashFields.put("rt_aply_dt", "rtAplyDt");
		this.hashFields.put("bdr_flg", "bdrFlg");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("cod_rat_ut_cd", "codRatUtCd");
		this.hashFields.put("dvc_curr_cd", "dvcCurrCd");
		this.hashFields.put("cod_amt", "codAmt");
		this.hashFields.put("cod_curr_cd", "codCurrCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("rdn_no", "rdnNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ctrt_no", "ctrtNo");
		this.hashFields.put("rdn_sts_nm", "rdnStsNm");
		this.hashFields.put("old_pol_yd_cd", "oldPolYdCd");
		this.hashFields.put("new_del_yd_cd", "newDelYdCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("umch_rsn_rmk", "umchRsnRmk");
		this.hashFields.put("cod_rqst_seq", "codRqstSeq");
		this.hashFields.put("old_del_yd_cd", "oldDelYdCd");
		this.hashFields.put("oft_amt", "oftAmt");
		this.hashFields.put("oft_curr_cd", "oftCurrCd");
		this.hashFields.put("cod_rqst_rsn_cd", "codRqstRsnCd");
		this.hashFields.put("bkg_ctrt_tp_cd", "bkgCtrtTpCd");
		this.hashFields.put("dvc_amt", "dvcAmt");
		this.hashFields.put("cod_chg_cd", "codChgCd");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("rgn_grp_avc_rmk", "rgnGrpAvcRmk");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("old_pod_yd_cd", "oldPodYdCd");
		this.hashFields.put("new_pol_yd_cd", "newPolYdCd");
		this.hashFields.put("oft_rat_ut_cd", "oftRatUtCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("new_pod_yd_cd", "newPodYdCd");
		this.hashFields.put("old_por_yd_cd", "oldPorYdCd");
		this.hashFields.put("bl_cnt", "blCnt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return selfAudit
	 */
	public String getSelfAudit() {
		return this.selfAudit;
	}
	
	/**
	 * Column Info
	 * @return dvcRatUtCd
	 */
	public String getDvcRatUtCd() {
		return this.dvcRatUtCd;
	}
	
	/**
	 * Column Info
	 * @return newPorYdCd
	 */
	public String getNewPorYdCd() {
		return this.newPorYdCd;
	}
	
	/**
	 * Column Info
	 * @return rtAplyDt
	 */
	public String getRtAplyDt() {
		return this.rtAplyDt;
	}
	
	/**
	 * Column Info
	 * @return bdrFlg
	 */
	public String getBdrFlg() {
		return this.bdrFlg;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return codRatUtCd
	 */
	public String getCodRatUtCd() {
		return this.codRatUtCd;
	}
	
	/**
	 * Column Info
	 * @return dvcCurrCd
	 */
	public String getDvcCurrCd() {
		return this.dvcCurrCd;
	}
	
	/**
	 * Column Info
	 * @return codAmt
	 */
	public String getCodAmt() {
		return this.codAmt;
	}
	
	/**
	 * Column Info
	 * @return codCurrCd
	 */
	public String getCodCurrCd() {
		return this.codCurrCd;
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
	 * @return ctrtNo
	 */
	public String getCtrtNo() {
		return this.ctrtNo;
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
	 * @return oldPolYdCd
	 */
	public String getOldPolYdCd() {
		return this.oldPolYdCd;
	}
	
	/**
	 * Column Info
	 * @return newDelYdCd
	 */
	public String getNewDelYdCd() {
		return this.newDelYdCd;
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
	 * @return umchRsnRmk
	 */
	public String getUmchRsnRmk() {
		return this.umchRsnRmk;
	}
	
	/**
	 * Column Info
	 * @return codRqstSeq
	 */
	public String getCodRqstSeq() {
		return this.codRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return oldDelYdCd
	 */
	public String getOldDelYdCd() {
		return this.oldDelYdCd;
	}
	
	/**
	 * Column Info
	 * @return oftAmt
	 */
	public String getOftAmt() {
		return this.oftAmt;
	}
	
	/**
	 * Column Info
	 * @return oftCurrCd
	 */
	public String getOftCurrCd() {
		return this.oftCurrCd;
	}
	
	/**
	 * Column Info
	 * @return codRqstRsnCd
	 */
	public String getCodRqstRsnCd() {
		return this.codRqstRsnCd;
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
	 * @return dvcAmt
	 */
	public String getDvcAmt() {
		return this.dvcAmt;
	}
	
	/**
	 * Column Info
	 * @return codChgCd
	 */
	public String getCodChgCd() {
		return this.codChgCd;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rgnGrpAvcRmk
	 */
	public String getRgnGrpAvcRmk() {
		return this.rgnGrpAvcRmk;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return oldPodYdCd
	 */
	public String getOldPodYdCd() {
		return this.oldPodYdCd;
	}
	
	/**
	 * Column Info
	 * @return newPolYdCd
	 */
	public String getNewPolYdCd() {
		return this.newPolYdCd;
	}
	
	/**
	 * Column Info
	 * @return oftRatUtCd
	 */
	public String getOftRatUtCd() {
		return this.oftRatUtCd;
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
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return newPodYdCd
	 */
	public String getNewPodYdCd() {
		return this.newPodYdCd;
	}
	
	/**
	 * Column Info
	 * @return oldPorYdCd
	 */
	public String getOldPorYdCd() {
		return this.oldPorYdCd;
	}
	
	/**
	 * Column Info
	 * @return blCnt
	 */
	public String getBlCnt() {
		return this.blCnt;
	}
	

	/**
	 * Column Info
	 * @param selfAudit
	 */
	public void setSelfAudit(String selfAudit) {
		this.selfAudit = selfAudit;
	}
	
	/**
	 * Column Info
	 * @param dvcRatUtCd
	 */
	public void setDvcRatUtCd(String dvcRatUtCd) {
		this.dvcRatUtCd = dvcRatUtCd;
	}
	
	/**
	 * Column Info
	 * @param newPorYdCd
	 */
	public void setNewPorYdCd(String newPorYdCd) {
		this.newPorYdCd = newPorYdCd;
	}
	
	/**
	 * Column Info
	 * @param rtAplyDt
	 */
	public void setRtAplyDt(String rtAplyDt) {
		this.rtAplyDt = rtAplyDt;
	}
	
	/**
	 * Column Info
	 * @param bdrFlg
	 */
	public void setBdrFlg(String bdrFlg) {
		this.bdrFlg = bdrFlg;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param codRatUtCd
	 */
	public void setCodRatUtCd(String codRatUtCd) {
		this.codRatUtCd = codRatUtCd;
	}
	
	/**
	 * Column Info
	 * @param dvcCurrCd
	 */
	public void setDvcCurrCd(String dvcCurrCd) {
		this.dvcCurrCd = dvcCurrCd;
	}
	
	/**
	 * Column Info
	 * @param codAmt
	 */
	public void setCodAmt(String codAmt) {
		this.codAmt = codAmt;
	}
	
	/**
	 * Column Info
	 * @param codCurrCd
	 */
	public void setCodCurrCd(String codCurrCd) {
		this.codCurrCd = codCurrCd;
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
	 * @param ctrtNo
	 */
	public void setCtrtNo(String ctrtNo) {
		this.ctrtNo = ctrtNo;
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
	 * @param oldPolYdCd
	 */
	public void setOldPolYdCd(String oldPolYdCd) {
		this.oldPolYdCd = oldPolYdCd;
	}
	
	/**
	 * Column Info
	 * @param newDelYdCd
	 */
	public void setNewDelYdCd(String newDelYdCd) {
		this.newDelYdCd = newDelYdCd;
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
	 * @param umchRsnRmk
	 */
	public void setUmchRsnRmk(String umchRsnRmk) {
		this.umchRsnRmk = umchRsnRmk;
	}
	
	/**
	 * Column Info
	 * @param codRqstSeq
	 */
	public void setCodRqstSeq(String codRqstSeq) {
		this.codRqstSeq = codRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param oldDelYdCd
	 */
	public void setOldDelYdCd(String oldDelYdCd) {
		this.oldDelYdCd = oldDelYdCd;
	}
	
	/**
	 * Column Info
	 * @param oftAmt
	 */
	public void setOftAmt(String oftAmt) {
		this.oftAmt = oftAmt;
	}
	
	/**
	 * Column Info
	 * @param oftCurrCd
	 */
	public void setOftCurrCd(String oftCurrCd) {
		this.oftCurrCd = oftCurrCd;
	}
	
	/**
	 * Column Info
	 * @param codRqstRsnCd
	 */
	public void setCodRqstRsnCd(String codRqstRsnCd) {
		this.codRqstRsnCd = codRqstRsnCd;
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
	 * @param dvcAmt
	 */
	public void setDvcAmt(String dvcAmt) {
		this.dvcAmt = dvcAmt;
	}
	
	/**
	 * Column Info
	 * @param codChgCd
	 */
	public void setCodChgCd(String codChgCd) {
		this.codChgCd = codChgCd;
	}
	
	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rgnGrpAvcRmk
	 */
	public void setRgnGrpAvcRmk(String rgnGrpAvcRmk) {
		this.rgnGrpAvcRmk = rgnGrpAvcRmk;
	}
	
	/**
	 * Column Info
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param oldPodYdCd
	 */
	public void setOldPodYdCd(String oldPodYdCd) {
		this.oldPodYdCd = oldPodYdCd;
	}
	
	/**
	 * Column Info
	 * @param newPolYdCd
	 */
	public void setNewPolYdCd(String newPolYdCd) {
		this.newPolYdCd = newPolYdCd;
	}
	
	/**
	 * Column Info
	 * @param oftRatUtCd
	 */
	public void setOftRatUtCd(String oftRatUtCd) {
		this.oftRatUtCd = oftRatUtCd;
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
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param newPodYdCd
	 */
	public void setNewPodYdCd(String newPodYdCd) {
		this.newPodYdCd = newPodYdCd;
	}
	
	/**
	 * Column Info
	 * @param oldPorYdCd
	 */
	public void setOldPorYdCd(String oldPorYdCd) {
		this.oldPorYdCd = oldPorYdCd;
	}
	
	/**
	 * Column Info
	 * @param blCnt
	 */
	public void setBlCnt(String blCnt) {
		this.blCnt = blCnt;
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
		setSelfAudit(JSPUtil.getParameter(request, prefix + "self_audit", ""));
		setDvcRatUtCd(JSPUtil.getParameter(request, prefix + "dvc_rat_ut_cd", ""));
		setNewPorYdCd(JSPUtil.getParameter(request, prefix + "new_por_yd_cd", ""));
		setRtAplyDt(JSPUtil.getParameter(request, prefix + "rt_aply_dt", ""));
		setBdrFlg(JSPUtil.getParameter(request, prefix + "bdr_flg", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setCodRatUtCd(JSPUtil.getParameter(request, prefix + "cod_rat_ut_cd", ""));
		setDvcCurrCd(JSPUtil.getParameter(request, prefix + "dvc_curr_cd", ""));
		setCodAmt(JSPUtil.getParameter(request, prefix + "cod_amt", ""));
		setCodCurrCd(JSPUtil.getParameter(request, prefix + "cod_curr_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setRdnNo(JSPUtil.getParameter(request, prefix + "rdn_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCtrtNo(JSPUtil.getParameter(request, prefix + "ctrt_no", ""));
		setRdnStsNm(JSPUtil.getParameter(request, prefix + "rdn_sts_nm", ""));
		setOldPolYdCd(JSPUtil.getParameter(request, prefix + "old_pol_yd_cd", ""));
		setNewDelYdCd(JSPUtil.getParameter(request, prefix + "new_del_yd_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUmchRsnRmk(JSPUtil.getParameter(request, prefix + "umch_rsn_rmk", ""));
		setCodRqstSeq(JSPUtil.getParameter(request, prefix + "cod_rqst_seq", ""));
		setOldDelYdCd(JSPUtil.getParameter(request, prefix + "old_del_yd_cd", ""));
		setOftAmt(JSPUtil.getParameter(request, prefix + "oft_amt", ""));
		setOftCurrCd(JSPUtil.getParameter(request, prefix + "oft_curr_cd", ""));
		setCodRqstRsnCd(JSPUtil.getParameter(request, prefix + "cod_rqst_rsn_cd", ""));
		setBkgCtrtTpCd(JSPUtil.getParameter(request, prefix + "bkg_ctrt_tp_cd", ""));
		setDvcAmt(JSPUtil.getParameter(request, prefix + "dvc_amt", ""));
		setCodChgCd(JSPUtil.getParameter(request, prefix + "cod_chg_cd", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setRgnGrpAvcRmk(JSPUtil.getParameter(request, prefix + "rgn_grp_avc_rmk", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setOldPodYdCd(JSPUtil.getParameter(request, prefix + "old_pod_yd_cd", ""));
		setNewPolYdCd(JSPUtil.getParameter(request, prefix + "new_pol_yd_cd", ""));
		setOftRatUtCd(JSPUtil.getParameter(request, prefix + "oft_rat_ut_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setNewPodYdCd(JSPUtil.getParameter(request, prefix + "new_pod_yd_cd", ""));
		setOldPorYdCd(JSPUtil.getParameter(request, prefix + "old_por_yd_cd", ""));
		setBlCnt(JSPUtil.getParameter(request, prefix + "bl_cnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CODBookingListOutVO[]
	 */
	public CODBookingListOutVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CODBookingListOutVO[]
	 */
	public CODBookingListOutVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CODBookingListOutVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] selfAudit = (JSPUtil.getParameter(request, prefix	+ "self_audit", length));
			String[] dvcRatUtCd = (JSPUtil.getParameter(request, prefix	+ "dvc_rat_ut_cd", length));
			String[] newPorYdCd = (JSPUtil.getParameter(request, prefix	+ "new_por_yd_cd", length));
			String[] rtAplyDt = (JSPUtil.getParameter(request, prefix	+ "rt_aply_dt", length));
			String[] bdrFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_flg", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] codRatUtCd = (JSPUtil.getParameter(request, prefix	+ "cod_rat_ut_cd", length));
			String[] dvcCurrCd = (JSPUtil.getParameter(request, prefix	+ "dvc_curr_cd", length));
			String[] codAmt = (JSPUtil.getParameter(request, prefix	+ "cod_amt", length));
			String[] codCurrCd = (JSPUtil.getParameter(request, prefix	+ "cod_curr_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] rdnNo = (JSPUtil.getParameter(request, prefix	+ "rdn_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ctrtNo = (JSPUtil.getParameter(request, prefix	+ "ctrt_no", length));
			String[] rdnStsNm = (JSPUtil.getParameter(request, prefix	+ "rdn_sts_nm", length));
			String[] oldPolYdCd = (JSPUtil.getParameter(request, prefix	+ "old_pol_yd_cd", length));
			String[] newDelYdCd = (JSPUtil.getParameter(request, prefix	+ "new_del_yd_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] umchRsnRmk = (JSPUtil.getParameter(request, prefix	+ "umch_rsn_rmk", length));
			String[] codRqstSeq = (JSPUtil.getParameter(request, prefix	+ "cod_rqst_seq", length));
			String[] oldDelYdCd = (JSPUtil.getParameter(request, prefix	+ "old_del_yd_cd", length));
			String[] oftAmt = (JSPUtil.getParameter(request, prefix	+ "oft_amt", length));
			String[] oftCurrCd = (JSPUtil.getParameter(request, prefix	+ "oft_curr_cd", length));
			String[] codRqstRsnCd = (JSPUtil.getParameter(request, prefix	+ "cod_rqst_rsn_cd", length));
			String[] bkgCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrt_tp_cd", length));
			String[] dvcAmt = (JSPUtil.getParameter(request, prefix	+ "dvc_amt", length));
			String[] codChgCd = (JSPUtil.getParameter(request, prefix	+ "cod_chg_cd", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] rgnGrpAvcRmk = (JSPUtil.getParameter(request, prefix	+ "rgn_grp_avc_rmk", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] oldPodYdCd = (JSPUtil.getParameter(request, prefix	+ "old_pod_yd_cd", length));
			String[] newPolYdCd = (JSPUtil.getParameter(request, prefix	+ "new_pol_yd_cd", length));
			String[] oftRatUtCd = (JSPUtil.getParameter(request, prefix	+ "oft_rat_ut_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] newPodYdCd = (JSPUtil.getParameter(request, prefix	+ "new_pod_yd_cd", length));
			String[] oldPorYdCd = (JSPUtil.getParameter(request, prefix	+ "old_por_yd_cd", length));
			String[] blCnt = (JSPUtil.getParameter(request, prefix	+ "bl_cnt", length));
			
			for (int i = 0; i < length; i++) {
				model = new CODBookingListOutVO();
				if (selfAudit[i] != null)
					model.setSelfAudit(selfAudit[i]);
				if (dvcRatUtCd[i] != null)
					model.setDvcRatUtCd(dvcRatUtCd[i]);
				if (newPorYdCd[i] != null)
					model.setNewPorYdCd(newPorYdCd[i]);
				if (rtAplyDt[i] != null)
					model.setRtAplyDt(rtAplyDt[i]);
				if (bdrFlg[i] != null)
					model.setBdrFlg(bdrFlg[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (codRatUtCd[i] != null)
					model.setCodRatUtCd(codRatUtCd[i]);
				if (dvcCurrCd[i] != null)
					model.setDvcCurrCd(dvcCurrCd[i]);
				if (codAmt[i] != null)
					model.setCodAmt(codAmt[i]);
				if (codCurrCd[i] != null)
					model.setCodCurrCd(codCurrCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (rdnNo[i] != null)
					model.setRdnNo(rdnNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ctrtNo[i] != null)
					model.setCtrtNo(ctrtNo[i]);
				if (rdnStsNm[i] != null)
					model.setRdnStsNm(rdnStsNm[i]);
				if (oldPolYdCd[i] != null)
					model.setOldPolYdCd(oldPolYdCd[i]);
				if (newDelYdCd[i] != null)
					model.setNewDelYdCd(newDelYdCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (umchRsnRmk[i] != null)
					model.setUmchRsnRmk(umchRsnRmk[i]);
				if (codRqstSeq[i] != null)
					model.setCodRqstSeq(codRqstSeq[i]);
				if (oldDelYdCd[i] != null)
					model.setOldDelYdCd(oldDelYdCd[i]);
				if (oftAmt[i] != null)
					model.setOftAmt(oftAmt[i]);
				if (oftCurrCd[i] != null)
					model.setOftCurrCd(oftCurrCd[i]);
				if (codRqstRsnCd[i] != null)
					model.setCodRqstRsnCd(codRqstRsnCd[i]);
				if (bkgCtrtTpCd[i] != null)
					model.setBkgCtrtTpCd(bkgCtrtTpCd[i]);
				if (dvcAmt[i] != null)
					model.setDvcAmt(dvcAmt[i]);
				if (codChgCd[i] != null)
					model.setCodChgCd(codChgCd[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (rgnGrpAvcRmk[i] != null)
					model.setRgnGrpAvcRmk(rgnGrpAvcRmk[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (oldPodYdCd[i] != null)
					model.setOldPodYdCd(oldPodYdCd[i]);
				if (newPolYdCd[i] != null)
					model.setNewPolYdCd(newPolYdCd[i]);
				if (oftRatUtCd[i] != null)
					model.setOftRatUtCd(oftRatUtCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (newPodYdCd[i] != null)
					model.setNewPodYdCd(newPodYdCd[i]);
				if (oldPorYdCd[i] != null)
					model.setOldPorYdCd(oldPorYdCd[i]);
				if (blCnt[i] != null)
					model.setBlCnt(blCnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCODBookingListOutVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CODBookingListOutVO[]
	 */
	public CODBookingListOutVO[] getCODBookingListOutVOs(){
		CODBookingListOutVO[] vos = (CODBookingListOutVO[])models.toArray(new CODBookingListOutVO[models.size()]);
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
		this.selfAudit = this.selfAudit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvcRatUtCd = this.dvcRatUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPorYdCd = this.newPorYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAplyDt = this.rtAplyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlg = this.bdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codRatUtCd = this.codRatUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvcCurrCd = this.dvcCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codAmt = this.codAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codCurrCd = this.codCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdnNo = this.rdnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtNo = this.ctrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdnStsNm = this.rdnStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPolYdCd = this.oldPolYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newDelYdCd = this.newDelYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchRsnRmk = this.umchRsnRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codRqstSeq = this.codRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldDelYdCd = this.oldDelYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oftAmt = this.oftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oftCurrCd = this.oftCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codRqstRsnCd = this.codRqstRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrtTpCd = this.bkgCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvcAmt = this.dvcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codChgCd = this.codChgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnGrpAvcRmk = this.rgnGrpAvcRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPodYdCd = this.oldPodYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPolYdCd = this.newPolYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oftRatUtCd = this.oftRatUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPodYdCd = this.newPodYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPorYdCd = this.oldPorYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCnt = this.blCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
