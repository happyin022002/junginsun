/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AvailableOffHireConfirmVO.java
*@FileTitle : AvailableOffHireConfirmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.10.08 장준우
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.vo;

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
 * @author 장준우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AvailableOffHireConfirmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<AvailableOffHireConfirmVO> models = new ArrayList<AvailableOffHireConfirmVO>();

	/* Column Info */
	private String offhCnfmDt = null;
	/* Column Info */
	private String trsSpNm = null;
	/* Column Info */
	private String onhYdCd = null;
	/* Column Info */
	private String offhYdCd = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String trsInvNo = null;
	/* Column Info */
	private String crntYdCd = null;
	/* Column Info */
	private String polEtdDt = null;
	/* Column Info */
	private String onhDt = null;
	/* Column Info */
	private String cnmvDt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usedDays = null;
	/* Column Info */
	private String trsSpCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String trsSoNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String evntOfcCd = null;
	/* Column Info */
	private String mnrCost = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String offhDueDt = null;
	/* Column Info */
	private String trsWoNo = null;
	/* Column Info */
	private String podEtaDt = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String minOnhDys = null;
	/* Column Info */
	private String offhSeq = null;
	/* Column Info */
	private String mvmtStsCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String sccCd = null;
	/* Column Info */
	private String offhStsCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String fullFlg = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String onhFreeDys = null;
	/* Column Info */
	private String remQty = null;
	/* Column Info */
	private String cfmQty = null;
	/* Column Info */
	private String totQty = null;
	/* Column Info */
	private String cntrQty = null;
	/* Column Info */
	private String complexPk = null;
	/* Column Info */
	private String mtyRtnYdCd = null;
	/* Column Info */
	private String orgRtnYdCd = null;
	/* Column Info */
	private String lseVndrUrl = null;
	/* Column Info */
	private String offhRefNo = null;
	/* Column Info */
	private String sndUsrId = null;
	/* Column Info */
	private String cfmUsrId = null;
	/* Column Info */
	private String refNo = null;
	/*	Column Info	*/
	private  String	 rstr_usg_lbl_tp   =  null;
	/*	Column Info	*/
	private  String	 rstr_usg_lbl_desc   =  null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public AvailableOffHireConfirmVO() {}

	public AvailableOffHireConfirmVO(String ibflag, String refNo, String cnmvDt, String offhRefNo, String sndUsrId, String cfmUsrId, String lseVndrUrl, String pagerows, String orgRtnYdCd, String mtyRtnYdCd, String complexPk, String remQty, String cfmQty, String sccCd, String totQty, String cntrQty, String vndrSeq, String vndrAbbrNm, String vndrLglEngNm, String agmtNo, String agmtCtyCd, String agmtSeq, String lstmCd, String cntrNo, String cntrTpszCd, String crntYdCd, String offhYdCd, String offhDueDt, String fullFlg, String mvmtStsCd, String onhYdCd, String onhDt, String minOnhDys, String onhFreeDys, String usedDays, String mnrCost, String bkgNo, String blNo, String polCd, String podCd, String delCd, String evntOfcCd, String polEtdDt, String podEtaDt, String vvdCd, String trsSoNo, String trsWoNo, String trsInvNo, String trsSpCd, String trsSpNm, String offhSeq, String offhStsCd, String offhCnfmDt, String updUsrId,String rstr_usg_lbl_tp,String rstr_usg_lbl_desc) {
		this.offhCnfmDt = offhCnfmDt;
		this.trsSpNm = trsSpNm;
		this.onhYdCd = onhYdCd;
		this.offhYdCd = offhYdCd;
		this.vndrLglEngNm = vndrLglEngNm;
		this.trsInvNo = trsInvNo;
		this.crntYdCd = crntYdCd;
		this.polEtdDt = polEtdDt;
		this.onhDt = onhDt;
		this.cnmvDt = cnmvDt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.usedDays = usedDays;
		this.trsSpCd = trsSpCd;
		this.vvdCd = vvdCd;
		this.trsSoNo = trsSoNo;
		this.cntrTpszCd = cntrTpszCd;
		this.agmtCtyCd = agmtCtyCd;
		this.lstmCd = lstmCd;
		this.updUsrId = updUsrId;
		this.evntOfcCd = evntOfcCd;
		this.mnrCost = mnrCost;
		this.agmtSeq = agmtSeq;
		this.delCd = delCd;
		this.agmtNo = agmtNo;
		this.offhDueDt = offhDueDt;
		this.trsWoNo = trsWoNo;
		this.podEtaDt = podEtaDt;
		this.podCd = podCd;
		this.minOnhDys = minOnhDys;
		this.offhSeq = offhSeq;
		this.mvmtStsCd = mvmtStsCd;
		this.bkgNo = bkgNo;
		this.sccCd = sccCd;
		this.offhStsCd = offhStsCd;
		this.cntrNo = cntrNo;
		this.vndrSeq = vndrSeq;
		this.fullFlg = fullFlg;
		this.vndrAbbrNm = vndrAbbrNm;
		this.onhFreeDys = onhFreeDys;
		this.remQty = remQty;
		this.cfmQty = cfmQty;
		this.totQty = totQty;
		this.cntrQty = cntrQty;
		this.complexPk = complexPk;
		this.mtyRtnYdCd = mtyRtnYdCd;
		this.orgRtnYdCd = orgRtnYdCd;
		this.lseVndrUrl = lseVndrUrl;
		this.offhRefNo = offhRefNo;
		this.sndUsrId = sndUsrId;
		this.cfmUsrId = cfmUsrId;
		this.refNo = refNo;
		this.rstr_usg_lbl_tp  = rstr_usg_lbl_tp ;
		this.rstr_usg_lbl_desc  = rstr_usg_lbl_desc ;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("offh_cnfm_dt", getOffhCnfmDt());
		this.hashColumns.put("trs_sp_nm", getTrsSpNm());
		this.hashColumns.put("onh_yd_cd", getOnhYdCd());
		this.hashColumns.put("offh_yd_cd", getOffhYdCd());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("trs_inv_no", getTrsInvNo());
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());
		this.hashColumns.put("pol_etd_dt", getPolEtdDt());
		this.hashColumns.put("onh_dt", getOnhDt());
		this.hashColumns.put("cnmv_dt", getCnmvDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("used_days", getUsedDays());
		this.hashColumns.put("trs_sp_cd", getTrsSpCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("trs_so_no", getTrsSoNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("evnt_ofc_cd", getEvntOfcCd());
		this.hashColumns.put("mnr_cost", getMnrCost());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("offh_due_dt", getOffhDueDt());
		this.hashColumns.put("trs_wo_no", getTrsWoNo());
		this.hashColumns.put("pod_eta_dt", getPodEtaDt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("min_onh_dys", getMinOnhDys());
		this.hashColumns.put("offh_seq", getOffhSeq());
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("offh_sts_cd", getOffhStsCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("full_flg", getFullFlg());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("onh_free_dys", getOnhFreeDys());
		this.hashColumns.put("rem_qty", getRemQty());
		this.hashColumns.put("cfm_qty", getCfmQty());
		this.hashColumns.put("tot_qty", getTotQty());
		this.hashColumns.put("cntr_qty", getCntrQty());
		this.hashColumns.put("complex_pk", getComplexPk());
		this.hashColumns.put("mty_rtn_yd_cd", getMtyRtnYdCd());
		this.hashColumns.put("org_rtn_yd_cd", getOrgRtnYdCd());
		this.hashColumns.put("lse_vndr_url", getLseVndrUrl());
		this.hashColumns.put("offh_ref_no", getOffhRefNo());
		this.hashColumns.put("snd_usr_id", getSndUsrId());
		this.hashColumns.put("cfm_usr_id", getCfmUsrId());
		this.hashColumns.put("ref_no", getRefNo());
		this.hashColumns.put("rstr_usg_lbl_tp", getRstr_usg_lbl_tp());
		this.hashColumns.put("rstr_usg_lbl_desc", getRstr_usg_lbl_desc());

		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("offh_cnfm_dt", "offhCnfmDt");
		this.hashFields.put("trs_sp_nm", "trsSpNm");
		this.hashFields.put("onh_yd_cd", "onhYdCd");
		this.hashFields.put("offh_yd_cd", "offhYdCd");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("trs_inv_no", "trsInvNo");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("pol_etd_dt", "polEtdDt");
		this.hashFields.put("onh_dt", "onhDt");
		this.hashFields.put("cnmv_dt", "cnmvDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("used_days", "usedDays");
		this.hashFields.put("trs_sp_cd", "trsSpCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("trs_so_no", "trsSoNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("evnt_ofc_cd", "evntOfcCd");
		this.hashFields.put("mnr_cost", "mnrCost");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("offh_due_dt", "offhDueDt");
		this.hashFields.put("trs_wo_no", "trsWoNo");
		this.hashFields.put("pod_eta_dt", "podEtaDt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("min_onh_dys", "minOnhDys");
		this.hashFields.put("offh_seq", "offhSeq");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("offh_sts_cd", "offhStsCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("full_flg", "fullFlg");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("onh_free_dys", "onhFreeDys");
		this.hashFields.put("rem_qty", "remQty");
		this.hashFields.put("cfm_qty", "cfmQty");
		this.hashFields.put("tot_qty", "totQty");
		this.hashFields.put("cntr_qty", "cntrQty");
		this.hashFields.put("complex_pk", "complexPk");
		this.hashFields.put("mty_rtn_yd_cd", "mtyRtnYdCd");
		this.hashFields.put("org_rtn_yd_cd", "orgRtnYdCd");
		this.hashFields.put("lse_vndr_url", "lseVndrUrl");
		this.hashFields.put("offh_ref_no", "offhRefNo");
		this.hashFields.put("snd_usr_id", "sndUsrId");
		this.hashFields.put("cfm_usr_id", "cfmUsrId");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("rstr_usg_lbl_tp", "rstr_usg_lbl_tp");
		this.hashFields.put("rstr_usg_lbl_desc", "rstr_usg_lbl_desc");

		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return offhCnfmDt
	 */
	public String getOffhCnfmDt() {
		return this.offhCnfmDt;
	}

	/**
	 * Column Info
	 * @return trsSpNm
	 */
	public String getTrsSpNm() {
		return this.trsSpNm;
	}

	/**
	 * Column Info
	 * @return onhYdCd
	 */
	public String getOnhYdCd() {
		return this.onhYdCd;
	}

	/**
	 * Column Info
	 * @return offhYdCd
	 */
	public String getOffhYdCd() {
		return this.offhYdCd;
	}

	/**
	 * Column Info
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}

	/**
	 * Column Info
	 * @return trsInvNo
	 */
	public String getTrsInvNo() {
		return this.trsInvNo;
	}

	/**
	 * Column Info
	 * @return crntYdCd
	 */
	public String getCrntYdCd() {
		return this.crntYdCd;
	}

	/**
	 * Column Info
	 * @return polEtdDt
	 */
	public String getPolEtdDt() {
		return this.polEtdDt;
	}

	/**
	 * Column Info
	 * @return onhDt
	 */
	public String getOnhDt() {
		return this.onhDt;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return usedDays
	 */
	public String getUsedDays() {
		return this.usedDays;
	}

	/**
	 * Column Info
	 * @return trsSpCd
	 */
	public String getTrsSpCd() {
		return this.trsSpCd;
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
	 * @return trsSoNo
	 */
	public String getTrsSoNo() {
		return this.trsSoNo;
	}

	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}

	/**
	 * Column Info
	 * @return agmtCtyCd
	 */
	public String getAgmtCtyCd() {
		return this.agmtCtyCd;
	}

	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
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
	 * @return evntOfcCd
	 */
	public String getEvntOfcCd() {
		return this.evntOfcCd;
	}

	/**
	 * Column Info
	 * @return mnrCost
	 */
	public String getMnrCost() {
		return this.mnrCost;
	}

	/**
	 * Column Info
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}

	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}

	/**
	 * Column Info
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}

	/**
	 * Column Info
	 * @return offhDueDt
	 */
	public String getOffhDueDt() {
		return this.offhDueDt;
	}

	/**
	 * Column Info
	 * @return trsWoNo
	 */
	public String getTrsWoNo() {
		return this.trsWoNo;
	}

	/**
	 * Column Info
	 * @return podEtaDt
	 */
	public String getPodEtaDt() {
		return this.podEtaDt;
	}

	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}

	/**
	 * Column Info
	 * @return minOnhDys
	 */
	public String getMinOnhDys() {
		return this.minOnhDys;
	}

	/**
	 * Column Info
	 * @return offhSeq
	 */
	public String getOffhSeq() {
		return this.offhSeq;
	}

	/**
	 * Column Info
	 * @return mvmtStsCd
	 */
	public String getMvmtStsCd() {
		return this.mvmtStsCd;
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
	 * @return sccCd
	 */
	public String getSccCd() {
		return this.sccCd;
	}

	/**
	 * Column Info
	 * @return offhStsCd
	 */
	public String getOffhStsCd() {
		return this.offhStsCd;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}

	/**
	 * Column Info
	 * @return fullFlg
	 */
	public String getFullFlg() {
		return this.fullFlg;
	}

	/**
	 * Column Info
	 * @return vndrAbbrNm
	 */
	public String getVndrAbbrNm() {
		return this.vndrAbbrNm;
	}

	/**
	 * Column Info
	 * @return onhFreeDys
	 */
	public String getOnhFreeDys() {
		return this.onhFreeDys;
	}


	/**
	 * Column Info
	 * @param offhCnfmDt
	 */
	public void setOffhCnfmDt(String offhCnfmDt) {
		this.offhCnfmDt = offhCnfmDt;
	}

	/**
	 * Column Info
	 * @param trsSpNm
	 */
	public void setTrsSpNm(String trsSpNm) {
		this.trsSpNm = trsSpNm;
	}

	/**
	 * Column Info
	 * @param onhYdCd
	 */
	public void setOnhYdCd(String onhYdCd) {
		this.onhYdCd = onhYdCd;
	}

	/**
	 * Column Info
	 * @param offhYdCd
	 */
	public void setOffhYdCd(String offhYdCd) {
		this.offhYdCd = offhYdCd;
	}

	/**
	 * Column Info
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
	}

	/**
	 * Column Info
	 * @param trsInvNo
	 */
	public void setTrsInvNo(String trsInvNo) {
		this.trsInvNo = trsInvNo;
	}

	/**
	 * Column Info
	 * @param crntYdCd
	 */
	public void setCrntYdCd(String crntYdCd) {
		this.crntYdCd = crntYdCd;
	}

	/**
	 * Column Info
	 * @param polEtdDt
	 */
	public void setPolEtdDt(String polEtdDt) {
		this.polEtdDt = polEtdDt;
	}

	/**
	 * Column Info
	 * @param onhDt
	 */
	public void setOnhDt(String onhDt) {
		this.onhDt = onhDt;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param usedDays
	 */
	public void setUsedDays(String usedDays) {
		this.usedDays = usedDays;
	}

	/**
	 * Column Info
	 * @param trsSpCd
	 */
	public void setTrsSpCd(String trsSpCd) {
		this.trsSpCd = trsSpCd;
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
	 * @param trsSoNo
	 */
	public void setTrsSoNo(String trsSoNo) {
		this.trsSoNo = trsSoNo;
	}

	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}

	/**
	 * Column Info
	 * @param agmtCtyCd
	 */
	public void setAgmtCtyCd(String agmtCtyCd) {
		this.agmtCtyCd = agmtCtyCd;
	}

	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
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
	 * @param evntOfcCd
	 */
	public void setEvntOfcCd(String evntOfcCd) {
		this.evntOfcCd = evntOfcCd;
	}

	/**
	 * Column Info
	 * @param mnrCost
	 */
	public void setMnrCost(String mnrCost) {
		this.mnrCost = mnrCost;
	}

	/**
	 * Column Info
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}

	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}

	/**
	 * Column Info
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}

	/**
	 * Column Info
	 * @param offhDueDt
	 */
	public void setOffhDueDt(String offhDueDt) {
		this.offhDueDt = offhDueDt;
	}

	/**
	 * Column Info
	 * @param trsWoNo
	 */
	public void setTrsWoNo(String trsWoNo) {
		this.trsWoNo = trsWoNo;
	}

	/**
	 * Column Info
	 * @param podEtaDt
	 */
	public void setPodEtaDt(String podEtaDt) {
		this.podEtaDt = podEtaDt;
	}

	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}

	/**
	 * Column Info
	 * @param minOnhDys
	 */
	public void setMinOnhDys(String minOnhDys) {
		this.minOnhDys = minOnhDys;
	}

	/**
	 * Column Info
	 * @param offhSeq
	 */
	public void setOffhSeq(String offhSeq) {
		this.offhSeq = offhSeq;
	}

	/**
	 * Column Info
	 * @param mvmtStsCd
	 */
	public void setMvmtStsCd(String mvmtStsCd) {
		this.mvmtStsCd = mvmtStsCd;
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
	 * @param sccCd
	 */
	public void setSccCd(String sccCd) {
		this.sccCd = sccCd;
	}

	/**
	 * Column Info
	 * @param offhStsCd
	 */
	public void setOffhStsCd(String offhStsCd) {
		this.offhStsCd = offhStsCd;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}

	/**
	 * Column Info
	 * @param fullFlg
	 */
	public void setFullFlg(String fullFlg) {
		this.fullFlg = fullFlg;
	}

	/**
	 * Column Info
	 * @param vndrAbbrNm
	 */
	public void setVndrAbbrNm(String vndrAbbrNm) {
		this.vndrAbbrNm = vndrAbbrNm;
	}

	/**
	 * Column Info
	 * @param onhFreeDys
	 */
	public void setOnhFreeDys(String onhFreeDys) {
		this.onhFreeDys = onhFreeDys;
	}

	/**
	 * @return the totQty
	 */
	public String getTotQty() {
		return totQty;
	}

	/**
	 * @param totQty the totQty to set
	 */
	public void setTotQty(String totQty) {
		this.totQty = totQty;
	}

	/**
	 * @return the cntrQty
	 */
	public String getCntrQty() {
		return cntrQty;
	}

	/**
	 * @param cntrQty the cntrQty to set
	 */
	public void setCntrQty(String cntrQty) {
		this.cntrQty = cntrQty;
	}

	/**
	 * @return the complexPk
	 */
	public String getComplexPk() {
		return complexPk;
	}

	/**
	 * @param complexPk the complexPk to set
	 */
	public void setComplexPk(String complexPk) {
		this.complexPk = complexPk;
	}

	/**
	 * @return the cfmQty
	 */
	public String getCfmQty() {
		return cfmQty;
	}

	/**
	 * @param cfmQty the cfmQty to set
	 */
	public void setCfmQty(String cfmQty) {
		this.cfmQty = cfmQty;
	}

	/**
	 * @return the mtyRtnYdCd
	 */
	public String getMtyRtnYdCd() {
		return mtyRtnYdCd;
	}

	/**
	 * @param mtyRtnYdCd the mtyRtnYdCd to set
	 */
	public void setMtyRtnYdCd(String mtyRtnYdCd) {
		this.mtyRtnYdCd = mtyRtnYdCd;
		this.orgRtnYdCd = mtyRtnYdCd;
	}

	/**
	 * @return the orgRtnYdCd
	 */
	public String getOrgRtnYdCd() {
		return mtyRtnYdCd;
	}

	/**
	 * @param orgRtnYdCd the orgRtnYdCd to set
	 */
	public void setOrgRtnYdCd(String orgRtnYdCd) {
		this.orgRtnYdCd = orgRtnYdCd;
	}

	/**
	 * @return the lseVndrUrl
	 */
	public String getLseVndrUrl() {
		return lseVndrUrl;
	}

	/**
	 * @return the offhRefNo
	 */
	public String getOffhRefNo() {
		return offhRefNo;
	}

	/**
	 * @param offhRefNo the offhRefNo to set
	 */
	public void setOffhRefNo(String offhRefNo) {
		this.offhRefNo = offhRefNo;
	}

	/**
	 * @return the sndUsrId
	 */
	public String getSndUsrId() {
		return sndUsrId;
	}

	/**
	 * @param sndUsrId the sndUsrId to set
	 */
	public void setSndUsrId(String sndUsrId) {
		this.sndUsrId = sndUsrId;
	}

	/**
	 * @return the cfmUsrId
	 */
	public String getCfmUsrId() {
		return cfmUsrId;
	}

	/**
	 * @param cfmUsrId the cfmUsrId to set
	 */
	public void setCfmUsrId(String cfmUsrId) {
		this.cfmUsrId = cfmUsrId;
	}

	/**
	 * @param lseVndrUrl the lseVndrUrl to set
	 */
	public void setLseVndrUrl(String lseVndrUrl) {
		this.lseVndrUrl = lseVndrUrl;
	}

	/**
	 * @return the remQty
	 */
	public String getRemQty() {
		return remQty;
	}

	/**
	 * @param remQty the remQty to set
	 */
	public void setRemQty(String remQty) {
		this.remQty = remQty;
	}

	/**
	 * @return the cnmvDt
	 */
	public String getCnmvDt() {
		return cnmvDt;
	}

	/**
	 * @param cnmvDt the cnmvDt to set
	 */
	public void setCnmvDt(String cnmvDt) {
		this.cnmvDt = cnmvDt;
	}

	/**
	 * @return the refNo
	 */
	public String getRefNo() {
		return refNo;
	}

	/**
	 * @param refNo the refNo to set
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	
	/**
	* Column Info
	* @param  rstr_usg_lbl_tp
	*/
	public void	setRstr_usg_lbl_tp( String	rstr_usg_lbl_tp ) {
		this.rstr_usg_lbl_tp =	rstr_usg_lbl_tp;
	}
 
	/**
	 * Column Info
	 * @return	rstr_usg_lbl_tp
	 */
	 public	 String	getRstr_usg_lbl_tp() {
		 return	this.rstr_usg_lbl_tp;
	 } 

	 
	 /**
	* Column Info
	* @param  rstr_usg_lbl_desc
	*/
	public void	setRstr_usg_lbl_desc( String	rstr_usg_lbl_desc ) {
		this.rstr_usg_lbl_desc =	rstr_usg_lbl_desc;
	}
 
	/**
	 * Column Info
	 * @return	rstr_usg_lbl_desc
	 */
	 public	 String	getRstr_usg_lbl_desc() {
		 return	this.rstr_usg_lbl_desc;
	 } 

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOffhCnfmDt(JSPUtil.getParameter(request, "offh_cnfm_dt", ""));
		setTrsSpNm(JSPUtil.getParameter(request, "trs_sp_nm", ""));
		setOnhYdCd(JSPUtil.getParameter(request, "onh_yd_cd", ""));
		setOffhYdCd(JSPUtil.getParameter(request, "offh_yd_cd", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, "vndr_lgl_eng_nm", ""));
		setTrsInvNo(JSPUtil.getParameter(request, "trs_inv_no", ""));
		setCrntYdCd(JSPUtil.getParameter(request, "crnt_yd_cd", ""));
		setPolEtdDt(JSPUtil.getParameter(request, "pol_etd_dt", ""));
		setOnhDt(JSPUtil.getParameter(request, "onh_dt", ""));
		setCnmvDt(JSPUtil.getParameter(request, "cnmv_dt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUsedDays(JSPUtil.getParameter(request, "used_days", ""));
		setTrsSpCd(JSPUtil.getParameter(request, "trs_sp_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setTrsSoNo(JSPUtil.getParameter(request, "trs_so_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, "agmt_cty_cd", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setEvntOfcCd(JSPUtil.getParameter(request, "evnt_ofc_cd", ""));
		setMnrCost(JSPUtil.getParameter(request, "mnr_cost", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setOffhDueDt(JSPUtil.getParameter(request, "offh_due_dt", ""));
		setTrsWoNo(JSPUtil.getParameter(request, "trs_wo_no", ""));
		setPodEtaDt(JSPUtil.getParameter(request, "pod_eta_dt", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setMinOnhDys(JSPUtil.getParameter(request, "min_onh_dys", ""));
		setOffhSeq(JSPUtil.getParameter(request, "offh_seq", ""));
		setMvmtStsCd(JSPUtil.getParameter(request, "mvmt_sts_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setSccCd(JSPUtil.getParameter(request, "scc_cd", ""));
		setOffhStsCd(JSPUtil.getParameter(request, "offh_sts_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setFullFlg(JSPUtil.getParameter(request, "full_flg", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, "vndr_abbr_nm", ""));
		setOnhFreeDys(JSPUtil.getParameter(request, "onh_free_dys", ""));
		setRemQty(JSPUtil.getParameter(request, "rem_qty", ""));
		setCfmQty(JSPUtil.getParameter(request, "cfm_qty", ""));
		setTotQty(JSPUtil.getParameter(request, "tot_qty", ""));
		setCntrQty(JSPUtil.getParameter(request, "cntr_qty", ""));
		setComplexPk(JSPUtil.getParameter(request, "complex_pk", ""));
		setMtyRtnYdCd(JSPUtil.getParameter(request, "mty_rtn_yd_cd", ""));
		setOrgRtnYdCd(JSPUtil.getParameter(request, "org_rtn_yd_cd", ""));
		setLseVndrUrl(JSPUtil.getParameter(request, "lse_vndr_url", ""));
		setOffhRefNo(JSPUtil.getParameter(request, "offh_ref_no", ""));
		setSndUsrId(JSPUtil.getParameter(request, "snd_usr_id", ""));
		setCfmUsrId(JSPUtil.getParameter(request, "cfm_usr_id", ""));
		setRefNo(JSPUtil.getParameter(request, "ref_no", ""));
		setRstr_usg_lbl_tp(JSPUtil.getParameter(request,	 "rstr_usg_lbl_tp", ""));
		setRstr_usg_lbl_desc(JSPUtil.getParameter(request,	 "rstr_usg_lbl_desc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AvailableOffHireConfirmVO[]
	 */
	public AvailableOffHireConfirmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return AvailableOffHireConfirmVO[]
	 */
	public AvailableOffHireConfirmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AvailableOffHireConfirmVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] offhCnfmDt = (JSPUtil.getParameter(request, prefix	+ "offh_cnfm_dt", length));
			String[] trsSpNm = (JSPUtil.getParameter(request, prefix	+ "trs_sp_nm", length));
			String[] onhYdCd = (JSPUtil.getParameter(request, prefix	+ "onh_yd_cd", length));
			String[] offhYdCd = (JSPUtil.getParameter(request, prefix	+ "offh_yd_cd", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] trsInvNo = (JSPUtil.getParameter(request, prefix	+ "trs_inv_no", length));
			String[] crntYdCd = (JSPUtil.getParameter(request, prefix	+ "crnt_yd_cd", length));
			String[] polEtdDt = (JSPUtil.getParameter(request, prefix	+ "pol_etd_dt", length));
			String[] onhDt = (JSPUtil.getParameter(request, prefix	+ "onh_dt", length));
			String[] cnmvDt = (JSPUtil.getParameter(request, prefix	+ "cnmv_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usedDays = (JSPUtil.getParameter(request, prefix	+ "used_days", length));
			String[] trsSpCd = (JSPUtil.getParameter(request, prefix	+ "trs_sp_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] trsSoNo = (JSPUtil.getParameter(request, prefix	+ "trs_so_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] evntOfcCd = (JSPUtil.getParameter(request, prefix	+ "evnt_ofc_cd", length));
			String[] mnrCost = (JSPUtil.getParameter(request, prefix	+ "mnr_cost", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] offhDueDt = (JSPUtil.getParameter(request, prefix	+ "offh_due_dt", length));
			String[] trsWoNo = (JSPUtil.getParameter(request, prefix	+ "trs_wo_no", length));
			String[] podEtaDt = (JSPUtil.getParameter(request, prefix	+ "pod_eta_dt", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] minOnhDys = (JSPUtil.getParameter(request, prefix	+ "min_onh_dys", length));
			String[] offhSeq = (JSPUtil.getParameter(request, prefix	+ "offh_seq", length));
			String[] mvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd", length));
			String[] offhStsCd = (JSPUtil.getParameter(request, prefix	+ "offh_sts_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] fullFlg = (JSPUtil.getParameter(request, prefix	+ "full_flg", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm", length));
			String[] onhFreeDys = (JSPUtil.getParameter(request, prefix	+ "onh_free_dys", length));
			String[] remQty = (JSPUtil.getParameter(request, prefix	+ "rem_qty", length));
			String[] cfmQty = (JSPUtil.getParameter(request, prefix	+ "cfm_qty", length));
			String[] totQty = (JSPUtil.getParameter(request, prefix	+ "tot_qty", length));
			String[] cntrQty = (JSPUtil.getParameter(request, prefix	+ "cntr_qty", length));
			String[] complexPk = (JSPUtil.getParameter(request, prefix	+ "complex_pk", length));
			String[] mtyRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "mty_rtn_yd_cd", length));
			String[] orgRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "org_rtn_yd_cd", length));
			String[] lseVndrUrl = (JSPUtil.getParameter(request, prefix	+ "lse_vndr_url", length));
			String[] offhRefNo = (JSPUtil.getParameter(request, prefix	+ "offh_ref_no", length));
			String[] sndUsrId = (JSPUtil.getParameter(request, prefix	+ "snd_usr_id", length));
			String[] cfmUsrId = (JSPUtil.getParameter(request, prefix	+ "cfm_usr_id", length));
			String[] refNo = (JSPUtil.getParameter(request, prefix	+ "ref_no", length));
			String[] rstr_usg_lbl_tp =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_lbl_tp".trim(),	length));
			String[] rstr_usg_lbl_desc =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_lbl_desc".trim(),	length));

			for (int i = 0; i < length; i++) {
				model = new AvailableOffHireConfirmVO();
				if (offhCnfmDt[i] != null)
					model.setOffhCnfmDt(offhCnfmDt[i]);
				if (trsSpNm[i] != null)
					model.setTrsSpNm(trsSpNm[i]);
				if (onhYdCd[i] != null)
					model.setOnhYdCd(onhYdCd[i]);
				if (offhYdCd[i] != null)
					model.setOffhYdCd(offhYdCd[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (trsInvNo[i] != null)
					model.setTrsInvNo(trsInvNo[i]);
				if (crntYdCd[i] != null)
					model.setCrntYdCd(crntYdCd[i]);
				if (polEtdDt[i] != null)
					model.setPolEtdDt(polEtdDt[i]);
				if (onhDt[i] != null)
					model.setOnhDt(onhDt[i]);
				if (cnmvDt[i] != null)
					model.setCnmvDt(cnmvDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usedDays[i] != null)
					model.setUsedDays(usedDays[i]);
				if (trsSpCd[i] != null)
					model.setTrsSpCd(trsSpCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (trsSoNo[i] != null)
					model.setTrsSoNo(trsSoNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (evntOfcCd[i] != null)
					model.setEvntOfcCd(evntOfcCd[i]);
				if (mnrCost[i] != null)
					model.setMnrCost(mnrCost[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (offhDueDt[i] != null)
					model.setOffhDueDt(offhDueDt[i]);
				if (trsWoNo[i] != null)
					model.setTrsWoNo(trsWoNo[i]);
				if (podEtaDt[i] != null)
					model.setPodEtaDt(podEtaDt[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (minOnhDys[i] != null)
					model.setMinOnhDys(minOnhDys[i]);
				if (offhSeq[i] != null)
					model.setOffhSeq(offhSeq[i]);
				if (mvmtStsCd[i] != null)
					model.setMvmtStsCd(mvmtStsCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
				if (offhStsCd[i] != null)
					model.setOffhStsCd(offhStsCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (fullFlg[i] != null)
					model.setFullFlg(fullFlg[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (onhFreeDys[i] != null)
					model.setOnhFreeDys(onhFreeDys[i]);
				if (totQty[i] != null)
					model.setTotQty(totQty[i]);
				if (remQty[i] != null)
					model.setRemQty(remQty[i]);
				if (cfmQty[i] != null)
					model.setCfmQty(cfmQty[i]);
				if (cntrQty[i] != null)
					model.setCntrQty(cntrQty[i]);
				if (complexPk[i] != null)
					model.setComplexPk(complexPk[i]);
				if (mtyRtnYdCd[i] != null)
					model.setMtyRtnYdCd(mtyRtnYdCd[i]);
				if (orgRtnYdCd[i] != null)
					model.setOrgRtnYdCd(orgRtnYdCd[i]);
				if (lseVndrUrl[i] != null)
					model.setLseVndrUrl(lseVndrUrl[i]);
				if (offhRefNo[i] != null)
					model.setOffhRefNo(offhRefNo[i]);
				if (sndUsrId[i] != null)
					model.setSndUsrId(sndUsrId[i]);
				if (cfmUsrId[i] != null)
					model.setCfmUsrId(cfmUsrId[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				if ( rstr_usg_lbl_tp[i] !=	null)
					model.setRstr_usg_lbl_tp( rstr_usg_lbl_tp[i]);
				if ( rstr_usg_lbl_desc[i] !=	null)
					model.setRstr_usg_lbl_desc( rstr_usg_lbl_desc[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAvailableOffHireConfirmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AvailableOffHireConfirmVO[]
	 */
	public AvailableOffHireConfirmVO[] getAvailableOffHireConfirmVOs(){
		AvailableOffHireConfirmVO[] vos = (AvailableOffHireConfirmVO[])models.toArray(new AvailableOffHireConfirmVO[models.size()]);
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
		this.offhCnfmDt = this.offhCnfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsSpNm = this.trsSpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhYdCd = this.onhYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhYdCd = this.offhYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsInvNo = this.trsInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd = this.crntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEtdDt = this.polEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhDt = this.onhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvDt = this.cnmvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usedDays = this.usedDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsSpCd = this.trsSpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsSoNo = this.trsSoNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntOfcCd = this.evntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrCost = this.mnrCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhDueDt = this.offhDueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsWoNo = this.trsWoNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podEtaDt = this.podEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minOnhDys = this.minOnhDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhSeq = this.offhSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd = this.mvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhStsCd = this.offhStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullFlg = this.fullFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhFreeDys = this.onhFreeDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remQty = this.remQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmQty = this.cfmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totQty = this.totQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrQty = this.cntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.complexPk = this.complexPk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyRtnYdCd = this.mtyRtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRtnYdCd = this.orgRtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseVndrUrl = this.lseVndrUrl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhRefNo = this.offhRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndUsrId = this.sndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmUsrId = this.cfmUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo = this.refNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstr_usg_lbl_tp =	this.rstr_usg_lbl_tp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstr_usg_lbl_desc =	this.rstr_usg_lbl_desc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
