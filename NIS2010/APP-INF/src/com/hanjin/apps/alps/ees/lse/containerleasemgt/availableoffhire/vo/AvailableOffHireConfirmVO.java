/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AvailableOffHireConfirmVO.java
*@FileTitle : AvailableOffHireConfirmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.15
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2011.12.15 김종옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.vo;

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
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AvailableOffHireConfirmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AvailableOffHireConfirmVO> models = new ArrayList<AvailableOffHireConfirmVO>();
	
	/* Column Info */
	private String trsSpNm = null;
	/* Column Info */
	private String onhYdCd = null;
	/* Column Info */
	private String offhYdCd = null;
	/* Column Info */
	private String totQty = null;
	/* Column Info */
	private String polEtdDt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String trsSoNo = null;
	/* Column Info */
	private String cfmUsrId = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String cnmvDt = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String cfmQty = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String minOnhDys = null;
	/* Column Info */
	private String sndUsrId = null;
	/* Column Info */
	private String offhSeq = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String fullFlg = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String offhCnfmDt = null;
	/* Column Info */
	private String lseVndrUrl = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String trsInvNo = null;
	/* Column Info */
	private String crntYdCd = null;
	/* Column Info */
	private String onhDt = null;
	/* Column Info */
	private String usedDays = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String trsSpCd = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String cntrQty = null;
	/* Column Info */
	private String complexPk = null;
	/* Column Info */
	private String orgRtnYdCd = null;
	/* Column Info */
	private String evntOfcCd = null;
	/* Column Info */
	private String mnrCost = null;
	/* Column Info */
	private String offhRefNo = null;
	/* Column Info */
	private String offhDueDt = null;
	/* Column Info */
	private String trsWoNo = null;
	/* Column Info */
	private String podEtaDt = null;
	/* Column Info */
	private String mvmtStsCd = null;
	/* Column Info */
	private String sccCd = null;
	/* Column Info */
	private String offhStsCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String remQty = null;
	/* Column Info */
	private String rqstOfcCd = null;
	/* Column Info */
	private String refNo = null;
	/* Column Info */
	private String mtyRtnYdCd = null;
	/* Column Info */
	private String onhFreeDys = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AvailableOffHireConfirmVO() {}

	public AvailableOffHireConfirmVO(String ibflag, String pagerows, String offhCnfmDt, String trsSpNm, String onhYdCd, String offhYdCd, String vndrLglEngNm, String trsInvNo, String crntYdCd, String polEtdDt, String onhDt, String cnmvDt, String blNo, String polCd, String usedDays, String trsSpCd, String vvdCd, String trsSoNo, String cntrTpszCd, String agmtCtyCd, String lstmCd, String updUsrId, String evntOfcCd, String mnrCost, String agmtSeq, String delCd, String agmtNo, String offhDueDt, String trsWoNo, String podEtaDt, String podCd, String minOnhDys, String offhSeq, String mvmtStsCd, String bkgNo, String sccCd, String offhStsCd, String cntrNo, String vndrSeq, String fullFlg, String vndrAbbrNm, String onhFreeDys, String remQty, String cfmQty, String totQty, String cntrQty, String complexPk, String mtyRtnYdCd, String orgRtnYdCd, String lseVndrUrl, String offhRefNo, String sndUsrId, String cfmUsrId, String refNo, String rqstOfcCd) {
		this.trsSpNm = trsSpNm;
		this.onhYdCd = onhYdCd;
		this.offhYdCd = offhYdCd;
		this.totQty = totQty;
		this.polEtdDt = polEtdDt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.vvdCd = vvdCd;
		this.cntrTpszCd = cntrTpszCd;
		this.trsSoNo = trsSoNo;
		this.cfmUsrId = cfmUsrId;
		this.lstmCd = lstmCd;
		this.updUsrId = updUsrId;
		this.agmtSeq = agmtSeq;
		this.cnmvDt = cnmvDt;
		this.delCd = delCd;
		this.agmtNo = agmtNo;
		this.cfmQty = cfmQty;
		this.podCd = podCd;
		this.minOnhDys = minOnhDys;
		this.sndUsrId = sndUsrId;
		this.offhSeq = offhSeq;
		this.bkgNo = bkgNo;
		this.vndrSeq = vndrSeq;
		this.fullFlg = fullFlg;
		this.vndrAbbrNm = vndrAbbrNm;
		this.offhCnfmDt = offhCnfmDt;
		this.lseVndrUrl = lseVndrUrl;
		this.vndrLglEngNm = vndrLglEngNm;
		this.trsInvNo = trsInvNo;
		this.crntYdCd = crntYdCd;
		this.onhDt = onhDt;
		this.usedDays = usedDays;
		this.ibflag = ibflag;
		this.trsSpCd = trsSpCd;
		this.agmtCtyCd = agmtCtyCd;
		this.cntrQty = cntrQty;
		this.complexPk = complexPk;
		this.orgRtnYdCd = orgRtnYdCd;
		this.evntOfcCd = evntOfcCd;
		this.mnrCost = mnrCost;
		this.offhRefNo = offhRefNo;
		this.offhDueDt = offhDueDt;
		this.trsWoNo = trsWoNo;
		this.podEtaDt = podEtaDt;
		this.mvmtStsCd = mvmtStsCd;
		this.sccCd = sccCd;
		this.offhStsCd = offhStsCd;
		this.cntrNo = cntrNo;
		this.remQty = remQty;
		this.rqstOfcCd = rqstOfcCd;
		this.refNo = refNo;
		this.mtyRtnYdCd = mtyRtnYdCd;
		this.onhFreeDys = onhFreeDys;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("trs_sp_nm", getTrsSpNm());
		this.hashColumns.put("onh_yd_cd", getOnhYdCd());
		this.hashColumns.put("offh_yd_cd", getOffhYdCd());
		this.hashColumns.put("tot_qty", getTotQty());
		this.hashColumns.put("pol_etd_dt", getPolEtdDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("trs_so_no", getTrsSoNo());
		this.hashColumns.put("cfm_usr_id", getCfmUsrId());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("cnmv_dt", getCnmvDt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("cfm_qty", getCfmQty());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("min_onh_dys", getMinOnhDys());
		this.hashColumns.put("snd_usr_id", getSndUsrId());
		this.hashColumns.put("offh_seq", getOffhSeq());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("full_flg", getFullFlg());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("offh_cnfm_dt", getOffhCnfmDt());
		this.hashColumns.put("lse_vndr_url", getLseVndrUrl());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("trs_inv_no", getTrsInvNo());
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());
		this.hashColumns.put("onh_dt", getOnhDt());
		this.hashColumns.put("used_days", getUsedDays());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("trs_sp_cd", getTrsSpCd());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("cntr_qty", getCntrQty());
		this.hashColumns.put("complex_pk", getComplexPk());
		this.hashColumns.put("org_rtn_yd_cd", getOrgRtnYdCd());
		this.hashColumns.put("evnt_ofc_cd", getEvntOfcCd());
		this.hashColumns.put("mnr_cost", getMnrCost());
		this.hashColumns.put("offh_ref_no", getOffhRefNo());
		this.hashColumns.put("offh_due_dt", getOffhDueDt());
		this.hashColumns.put("trs_wo_no", getTrsWoNo());
		this.hashColumns.put("pod_eta_dt", getPodEtaDt());
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("offh_sts_cd", getOffhStsCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("rem_qty", getRemQty());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("ref_no", getRefNo());
		this.hashColumns.put("mty_rtn_yd_cd", getMtyRtnYdCd());
		this.hashColumns.put("onh_free_dys", getOnhFreeDys());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("trs_sp_nm", "trsSpNm");
		this.hashFields.put("onh_yd_cd", "onhYdCd");
		this.hashFields.put("offh_yd_cd", "offhYdCd");
		this.hashFields.put("tot_qty", "totQty");
		this.hashFields.put("pol_etd_dt", "polEtdDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("trs_so_no", "trsSoNo");
		this.hashFields.put("cfm_usr_id", "cfmUsrId");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("cnmv_dt", "cnmvDt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("cfm_qty", "cfmQty");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("min_onh_dys", "minOnhDys");
		this.hashFields.put("snd_usr_id", "sndUsrId");
		this.hashFields.put("offh_seq", "offhSeq");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("full_flg", "fullFlg");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("offh_cnfm_dt", "offhCnfmDt");
		this.hashFields.put("lse_vndr_url", "lseVndrUrl");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("trs_inv_no", "trsInvNo");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("onh_dt", "onhDt");
		this.hashFields.put("used_days", "usedDays");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("trs_sp_cd", "trsSpCd");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("cntr_qty", "cntrQty");
		this.hashFields.put("complex_pk", "complexPk");
		this.hashFields.put("org_rtn_yd_cd", "orgRtnYdCd");
		this.hashFields.put("evnt_ofc_cd", "evntOfcCd");
		this.hashFields.put("mnr_cost", "mnrCost");
		this.hashFields.put("offh_ref_no", "offhRefNo");
		this.hashFields.put("offh_due_dt", "offhDueDt");
		this.hashFields.put("trs_wo_no", "trsWoNo");
		this.hashFields.put("pod_eta_dt", "podEtaDt");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("offh_sts_cd", "offhStsCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("rem_qty", "remQty");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("mty_rtn_yd_cd", "mtyRtnYdCd");
		this.hashFields.put("onh_free_dys", "onhFreeDys");
		return this.hashFields;
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
	 * @return totQty
	 */
	public String getTotQty() {
		return this.totQty;
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
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
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
	 * @return trsSoNo
	 */
	public String getTrsSoNo() {
		return this.trsSoNo;
	}
	
	/**
	 * Column Info
	 * @return cfmUsrId
	 */
	public String getCfmUsrId() {
		return this.cfmUsrId;
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
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}
	
	/**
	 * Column Info
	 * @return cnmvDt
	 */
	public String getCnmvDt() {
		return this.cnmvDt;
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
	 * @return cfmQty
	 */
	public String getCfmQty() {
		return this.cfmQty;
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
	 * @return sndUsrId
	 */
	public String getSndUsrId() {
		return this.sndUsrId;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return offhCnfmDt
	 */
	public String getOffhCnfmDt() {
		return this.offhCnfmDt;
	}
	
	/**
	 * Column Info
	 * @return lseVndrUrl
	 */
	public String getLseVndrUrl() {
		return this.lseVndrUrl;
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
	 * @return onhDt
	 */
	public String getOnhDt() {
		return this.onhDt;
	}
	
	/**
	 * Column Info
	 * @return usedDays
	 */
	public String getUsedDays() {
		return this.usedDays;
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
	 * @return trsSpCd
	 */
	public String getTrsSpCd() {
		return this.trsSpCd;
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
	 * @return cntrQty
	 */
	public String getCntrQty() {
		return this.cntrQty;
	}
	
	/**
	 * Column Info
	 * @return complexPk
	 */
	public String getComplexPk() {
		return this.complexPk;
	}
	
	/**
	 * Column Info
	 * @return orgRtnYdCd
	 */
	public String getOrgRtnYdCd() {
		return this.orgRtnYdCd;
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
	 * @return offhRefNo
	 */
	public String getOffhRefNo() {
		return this.offhRefNo;
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
	 * @return mvmtStsCd
	 */
	public String getMvmtStsCd() {
		return this.mvmtStsCd;
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
	 * @return remQty
	 */
	public String getRemQty() {
		return this.remQty;
	}
	
	/**
	 * Column Info
	 * @return rqstOfcCd
	 */
	public String getRqstOfcCd() {
		return this.rqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @return refNo
	 */
	public String getRefNo() {
		return this.refNo;
	}
	
	/**
	 * Column Info
	 * @return mtyRtnYdCd
	 */
	public String getMtyRtnYdCd() {
		return this.mtyRtnYdCd;
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
	 * @param totQty
	 */
	public void setTotQty(String totQty) {
		this.totQty = totQty;
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
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
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
	 * @param trsSoNo
	 */
	public void setTrsSoNo(String trsSoNo) {
		this.trsSoNo = trsSoNo;
	}
	
	/**
	 * Column Info
	 * @param cfmUsrId
	 */
	public void setCfmUsrId(String cfmUsrId) {
		this.cfmUsrId = cfmUsrId;
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
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}
	
	/**
	 * Column Info
	 * @param cnmvDt
	 */
	public void setCnmvDt(String cnmvDt) {
		this.cnmvDt = cnmvDt;
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
	 * @param cfmQty
	 */
	public void setCfmQty(String cfmQty) {
		this.cfmQty = cfmQty;
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
	 * @param sndUsrId
	 */
	public void setSndUsrId(String sndUsrId) {
		this.sndUsrId = sndUsrId;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param offhCnfmDt
	 */
	public void setOffhCnfmDt(String offhCnfmDt) {
		this.offhCnfmDt = offhCnfmDt;
	}
	
	/**
	 * Column Info
	 * @param lseVndrUrl
	 */
	public void setLseVndrUrl(String lseVndrUrl) {
		this.lseVndrUrl = lseVndrUrl;
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
	 * @param onhDt
	 */
	public void setOnhDt(String onhDt) {
		this.onhDt = onhDt;
	}
	
	/**
	 * Column Info
	 * @param usedDays
	 */
	public void setUsedDays(String usedDays) {
		this.usedDays = usedDays;
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
	 * @param trsSpCd
	 */
	public void setTrsSpCd(String trsSpCd) {
		this.trsSpCd = trsSpCd;
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
	 * @param cntrQty
	 */
	public void setCntrQty(String cntrQty) {
		this.cntrQty = cntrQty;
	}
	
	/**
	 * Column Info
	 * @param complexPk
	 */
	public void setComplexPk(String complexPk) {
		this.complexPk = complexPk;
	}
	
	/**
	 * Column Info
	 * @param orgRtnYdCd
	 */
	public void setOrgRtnYdCd(String orgRtnYdCd) {
		this.orgRtnYdCd = orgRtnYdCd;
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
	 * @param offhRefNo
	 */
	public void setOffhRefNo(String offhRefNo) {
		this.offhRefNo = offhRefNo;
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
	 * @param mvmtStsCd
	 */
	public void setMvmtStsCd(String mvmtStsCd) {
		this.mvmtStsCd = mvmtStsCd;
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
	 * @param remQty
	 */
	public void setRemQty(String remQty) {
		this.remQty = remQty;
	}
	
	/**
	 * Column Info
	 * @param rqstOfcCd
	 */
	public void setRqstOfcCd(String rqstOfcCd) {
		this.rqstOfcCd = rqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @param refNo
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	
	/**
	 * Column Info
	 * @param mtyRtnYdCd
	 */
	public void setMtyRtnYdCd(String mtyRtnYdCd) {
		this.mtyRtnYdCd = mtyRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @param onhFreeDys
	 */
	public void setOnhFreeDys(String onhFreeDys) {
		this.onhFreeDys = onhFreeDys;
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
		setTrsSpNm(JSPUtil.getParameter(request, prefix + "trs_sp_nm", ""));
		setOnhYdCd(JSPUtil.getParameter(request, prefix + "onh_yd_cd", ""));
		setOffhYdCd(JSPUtil.getParameter(request, prefix + "offh_yd_cd", ""));
		setTotQty(JSPUtil.getParameter(request, prefix + "tot_qty", ""));
		setPolEtdDt(JSPUtil.getParameter(request, prefix + "pol_etd_dt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setTrsSoNo(JSPUtil.getParameter(request, prefix + "trs_so_no", ""));
		setCfmUsrId(JSPUtil.getParameter(request, prefix + "cfm_usr_id", ""));
		setLstmCd(JSPUtil.getParameter(request, prefix + "lstm_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setAgmtSeq(JSPUtil.getParameter(request, prefix + "agmt_seq", ""));
		setCnmvDt(JSPUtil.getParameter(request, prefix + "cnmv_dt", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setAgmtNo(JSPUtil.getParameter(request, prefix + "agmt_no", ""));
		setCfmQty(JSPUtil.getParameter(request, prefix + "cfm_qty", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setMinOnhDys(JSPUtil.getParameter(request, prefix + "min_onh_dys", ""));
		setSndUsrId(JSPUtil.getParameter(request, prefix + "snd_usr_id", ""));
		setOffhSeq(JSPUtil.getParameter(request, prefix + "offh_seq", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setFullFlg(JSPUtil.getParameter(request, prefix + "full_flg", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, prefix + "vndr_abbr_nm", ""));
		setOffhCnfmDt(JSPUtil.getParameter(request, prefix + "offh_cnfm_dt", ""));
		setLseVndrUrl(JSPUtil.getParameter(request, prefix + "lse_vndr_url", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setTrsInvNo(JSPUtil.getParameter(request, prefix + "trs_inv_no", ""));
		setCrntYdCd(JSPUtil.getParameter(request, prefix + "crnt_yd_cd", ""));
		setOnhDt(JSPUtil.getParameter(request, prefix + "onh_dt", ""));
		setUsedDays(JSPUtil.getParameter(request, prefix + "used_days", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTrsSpCd(JSPUtil.getParameter(request, prefix + "trs_sp_cd", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, prefix + "agmt_cty_cd", ""));
		setCntrQty(JSPUtil.getParameter(request, prefix + "cntr_qty", ""));
		setComplexPk(JSPUtil.getParameter(request, prefix + "complex_pk", ""));
		setOrgRtnYdCd(JSPUtil.getParameter(request, prefix + "org_rtn_yd_cd", ""));
		setEvntOfcCd(JSPUtil.getParameter(request, prefix + "evnt_ofc_cd", ""));
		setMnrCost(JSPUtil.getParameter(request, prefix + "mnr_cost", ""));
		setOffhRefNo(JSPUtil.getParameter(request, prefix + "offh_ref_no", ""));
		setOffhDueDt(JSPUtil.getParameter(request, prefix + "offh_due_dt", ""));
		setTrsWoNo(JSPUtil.getParameter(request, prefix + "trs_wo_no", ""));
		setPodEtaDt(JSPUtil.getParameter(request, prefix + "pod_eta_dt", ""));
		setMvmtStsCd(JSPUtil.getParameter(request, prefix + "mvmt_sts_cd", ""));
		setSccCd(JSPUtil.getParameter(request, prefix + "scc_cd", ""));
		setOffhStsCd(JSPUtil.getParameter(request, prefix + "offh_sts_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setRemQty(JSPUtil.getParameter(request, prefix + "rem_qty", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, prefix + "rqst_ofc_cd", ""));
		setRefNo(JSPUtil.getParameter(request, prefix + "ref_no", ""));
		setMtyRtnYdCd(JSPUtil.getParameter(request, prefix + "mty_rtn_yd_cd", ""));
		setOnhFreeDys(JSPUtil.getParameter(request, prefix + "onh_free_dys", ""));
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
			String[] trsSpNm = (JSPUtil.getParameter(request, prefix	+ "trs_sp_nm", length));
			String[] onhYdCd = (JSPUtil.getParameter(request, prefix	+ "onh_yd_cd", length));
			String[] offhYdCd = (JSPUtil.getParameter(request, prefix	+ "offh_yd_cd", length));
			String[] totQty = (JSPUtil.getParameter(request, prefix	+ "tot_qty", length));
			String[] polEtdDt = (JSPUtil.getParameter(request, prefix	+ "pol_etd_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] trsSoNo = (JSPUtil.getParameter(request, prefix	+ "trs_so_no", length));
			String[] cfmUsrId = (JSPUtil.getParameter(request, prefix	+ "cfm_usr_id", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] cnmvDt = (JSPUtil.getParameter(request, prefix	+ "cnmv_dt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] cfmQty = (JSPUtil.getParameter(request, prefix	+ "cfm_qty", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] minOnhDys = (JSPUtil.getParameter(request, prefix	+ "min_onh_dys", length));
			String[] sndUsrId = (JSPUtil.getParameter(request, prefix	+ "snd_usr_id", length));
			String[] offhSeq = (JSPUtil.getParameter(request, prefix	+ "offh_seq", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] fullFlg = (JSPUtil.getParameter(request, prefix	+ "full_flg", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm", length));
			String[] offhCnfmDt = (JSPUtil.getParameter(request, prefix	+ "offh_cnfm_dt", length));
			String[] lseVndrUrl = (JSPUtil.getParameter(request, prefix	+ "lse_vndr_url", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] trsInvNo = (JSPUtil.getParameter(request, prefix	+ "trs_inv_no", length));
			String[] crntYdCd = (JSPUtil.getParameter(request, prefix	+ "crnt_yd_cd", length));
			String[] onhDt = (JSPUtil.getParameter(request, prefix	+ "onh_dt", length));
			String[] usedDays = (JSPUtil.getParameter(request, prefix	+ "used_days", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] trsSpCd = (JSPUtil.getParameter(request, prefix	+ "trs_sp_cd", length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd", length));
			String[] cntrQty = (JSPUtil.getParameter(request, prefix	+ "cntr_qty", length));
			String[] complexPk = (JSPUtil.getParameter(request, prefix	+ "complex_pk", length));
			String[] orgRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "org_rtn_yd_cd", length));
			String[] evntOfcCd = (JSPUtil.getParameter(request, prefix	+ "evnt_ofc_cd", length));
			String[] mnrCost = (JSPUtil.getParameter(request, prefix	+ "mnr_cost", length));
			String[] offhRefNo = (JSPUtil.getParameter(request, prefix	+ "offh_ref_no", length));
			String[] offhDueDt = (JSPUtil.getParameter(request, prefix	+ "offh_due_dt", length));
			String[] trsWoNo = (JSPUtil.getParameter(request, prefix	+ "trs_wo_no", length));
			String[] podEtaDt = (JSPUtil.getParameter(request, prefix	+ "pod_eta_dt", length));
			String[] mvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd", length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd", length));
			String[] offhStsCd = (JSPUtil.getParameter(request, prefix	+ "offh_sts_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] remQty = (JSPUtil.getParameter(request, prefix	+ "rem_qty", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			String[] refNo = (JSPUtil.getParameter(request, prefix	+ "ref_no", length));
			String[] mtyRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "mty_rtn_yd_cd", length));
			String[] onhFreeDys = (JSPUtil.getParameter(request, prefix	+ "onh_free_dys", length));
			
			for (int i = 0; i < length; i++) {
				model = new AvailableOffHireConfirmVO();
				if (trsSpNm[i] != null)
					model.setTrsSpNm(trsSpNm[i]);
				if (onhYdCd[i] != null)
					model.setOnhYdCd(onhYdCd[i]);
				if (offhYdCd[i] != null)
					model.setOffhYdCd(offhYdCd[i]);
				if (totQty[i] != null)
					model.setTotQty(totQty[i]);
				if (polEtdDt[i] != null)
					model.setPolEtdDt(polEtdDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (trsSoNo[i] != null)
					model.setTrsSoNo(trsSoNo[i]);
				if (cfmUsrId[i] != null)
					model.setCfmUsrId(cfmUsrId[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (cnmvDt[i] != null)
					model.setCnmvDt(cnmvDt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (cfmQty[i] != null)
					model.setCfmQty(cfmQty[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (minOnhDys[i] != null)
					model.setMinOnhDys(minOnhDys[i]);
				if (sndUsrId[i] != null)
					model.setSndUsrId(sndUsrId[i]);
				if (offhSeq[i] != null)
					model.setOffhSeq(offhSeq[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (fullFlg[i] != null)
					model.setFullFlg(fullFlg[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (offhCnfmDt[i] != null)
					model.setOffhCnfmDt(offhCnfmDt[i]);
				if (lseVndrUrl[i] != null)
					model.setLseVndrUrl(lseVndrUrl[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (trsInvNo[i] != null)
					model.setTrsInvNo(trsInvNo[i]);
				if (crntYdCd[i] != null)
					model.setCrntYdCd(crntYdCd[i]);
				if (onhDt[i] != null)
					model.setOnhDt(onhDt[i]);
				if (usedDays[i] != null)
					model.setUsedDays(usedDays[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (trsSpCd[i] != null)
					model.setTrsSpCd(trsSpCd[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (cntrQty[i] != null)
					model.setCntrQty(cntrQty[i]);
				if (complexPk[i] != null)
					model.setComplexPk(complexPk[i]);
				if (orgRtnYdCd[i] != null)
					model.setOrgRtnYdCd(orgRtnYdCd[i]);
				if (evntOfcCd[i] != null)
					model.setEvntOfcCd(evntOfcCd[i]);
				if (mnrCost[i] != null)
					model.setMnrCost(mnrCost[i]);
				if (offhRefNo[i] != null)
					model.setOffhRefNo(offhRefNo[i]);
				if (offhDueDt[i] != null)
					model.setOffhDueDt(offhDueDt[i]);
				if (trsWoNo[i] != null)
					model.setTrsWoNo(trsWoNo[i]);
				if (podEtaDt[i] != null)
					model.setPodEtaDt(podEtaDt[i]);
				if (mvmtStsCd[i] != null)
					model.setMvmtStsCd(mvmtStsCd[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
				if (offhStsCd[i] != null)
					model.setOffhStsCd(offhStsCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (remQty[i] != null)
					model.setRemQty(remQty[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				if (mtyRtnYdCd[i] != null)
					model.setMtyRtnYdCd(mtyRtnYdCd[i]);
				if (onhFreeDys[i] != null)
					model.setOnhFreeDys(onhFreeDys[i]);
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
		this.trsSpNm = this.trsSpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhYdCd = this.onhYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhYdCd = this.offhYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totQty = this.totQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEtdDt = this.polEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsSoNo = this.trsSoNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmUsrId = this.cfmUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvDt = this.cnmvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmQty = this.cfmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minOnhDys = this.minOnhDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndUsrId = this.sndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhSeq = this.offhSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullFlg = this.fullFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhCnfmDt = this.offhCnfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseVndrUrl = this.lseVndrUrl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsInvNo = this.trsInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd = this.crntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhDt = this.onhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usedDays = this.usedDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsSpCd = this.trsSpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrQty = this.cntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.complexPk = this.complexPk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRtnYdCd = this.orgRtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntOfcCd = this.evntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrCost = this.mnrCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhRefNo = this.offhRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhDueDt = this.offhDueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsWoNo = this.trsWoNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podEtaDt = this.podEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd = this.mvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhStsCd = this.offhStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remQty = this.remQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo = this.refNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyRtnYdCd = this.mtyRtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhFreeDys = this.onhFreeDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
