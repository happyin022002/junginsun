/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : LandInvMonitoringVO.java
*@FileTitle : LandInvMonitoringVO
*Open Issues :
*Change history : 
*                 2015-03-17 CHM-201534671, 신용찬, 1. COP_HDR 에서 MASTER='Y' 인 MST_BKG_NO 로 TRS 정보를 조회(TRS는 MASTER BKG 으로 W/O 생성)
                                                   2. FACTORY NAME 정보 추가
                                                   3. NTFY 조회 되던 내용 CNEE 로 수정
                                                   4. VVD 검색조건 추가, (EVENT DATE 는 OPTINAL)
                  2015-07-22 CHM-201537162, 신용찬, TRS W/O FM ND 추가, TRS W/O 연결조건 변경                                 
*@LastModifyDate : 2014.04.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.25  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.chassisreport.chassisreportinventory.vo;

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

public class LandInvMonitoringVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<LandInvMonitoringVO> models = new ArrayList<LandInvMonitoringVO>();
	
	/* Column Info */
	private String ntfy = null;
	/* Column Info */
	private String csDt = null;
	/* Column Info */
	private String chssNo = null;
	/* Column Info */
	private String chzTot = null;
	/* Column Info */
	private String cdId = null;
	/* Column Info */
	private String fmTm = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String boundCd = null;
	/* Column Info */
	private String porDelNod = null;
	/* Column Info */
	private String chzVndrNm = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String dmtChgStsCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String trsApptDt = null;
	/* Column Info */
	private String dmtMtDt = null;
	/* Column Info */
	private String trsVndrSeq = null;
	/* Column Info */
	private String locList = null;
	/* Column Info */
	private String poletdPodeta = null;
	/* Column Info */
	private String trsApptTm = null;
	/* Column Info */
	private String chzRt = null;
	/* Column Info */
	private String rcvDelTerm = null;
	/* Column Info */
	private String trsDeDt = null;
	/* Column Info */
	private String scCustNm = null;
	/* Column Info */
	private String freeDays = null;
	/* Column Info */
	private String dmtCurrCd = null;
	/* Column Info */
	private String trkVndrSeq = null;
	/* Column Info */
	private String dmtFmStsCd = null;
	/* Column Info */
	private String dmtUcFlg = null;
	/* Column Info */
	private String chzAgmtNo = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String chzExcept = null;
	/* Column Info */
	private String trsVndrNm = null;
	/* Column Info */
	private String dmtToDt = null;
	/* Column Info */
	private String rdCgoFlg = null;
	/* Column Info */
	private String trkVndrNm = null;
	/* Column Info */
	private String ltDt = null;
	/* Column Info */
	private String dmtBillDys = null;
	/* Column Info */
	private String fcntrFlg = null;
	/* Column Info */
	private String cntrDmgFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String stayDys = null;
	/* Column Info */
	private String srepNm = null;
	/* Column Info */
	private String ltStsCd = null;
	/* Column Info */
	private String cargoType = null;
	/* Column Info */
	private String dmtToStsCd = null;
	/* Column Info */
	private String dmtFtCmncDt = null;
	/* Column Info */
	private String ltYdCd = null;
	/* Column Info */
	private String chzVndrSeq = null;
	/* Column Info */
	private String byndFdys = null;
	/* Column Info */
	private String dmtTrfCd = null;
	/* Column Info */
	private String trsDeTm = null;
	/* Column Info */
	private String dmtFtEndDt = null;
	/* Column Info */
	private String trsInvCfmDt = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String beyondFdays = null;
	/* Column Info */
	private String chzPayFlg = null;
	/* Column Info */
	private String locLis = null;
	/* Column Info */
	private String bndCd = null;
	/* Column Info */
	private String eccCd = null;
	/* Column Info */
	private String fmStsCd = null;
	/* Column Info */
	private String dmtFmDt = null;
	/* Column Info */
	private String mvmtCd = null;
	/* Column Info */
	private String csFlg = null;
	/* Column Info */
	private String finished = null;
	/* Column Info */
	private String chzPoolCd = null;
	/* Column Info */
	private String orgYdCd = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String finishCd = null;
	/* Column Info */
	private String dmtBilAmt = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String lccCd = null;
	/* Column Info */
	private String mvmtStsCd = null;
	/* Column Info */
	private String sccCd = null;
	/* Column Info */
	private String scRfaNo = null;
	/* Column Info */
	private String ltTm = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String stayingDays = null;
	/* Column Info */
	private String ltCreTp = null;
	/* Column Info */
	private String polPodNod = null;
	/* Column Info */
	private String trsInvStsCd = null;
	/* Column Info */
	private String shpr = null;
	/* Column Info */
	private String dmtFtDys = null;
	/* Column Info */
	private String trnkVvd = null;
	/* Column Info */
	private String trsWoIssUsrNm  = null;
	/* Column Info */
	private String box = null;
	/* Column Info */
	private String avgStayDys = null;
	/* Column Info */
	private String avgByndFdys = null;
	/* Column Info */
	private String hdnPopYn = null;
	/* Column Info */
	private String hdnOrgYdCd = null;
	/* Column Info */
	private String hdnFcntrFlg = null;
	/* Column Info */
	private String hdnFinished = null;
	/* Column Info */
	private String hdnFmStsCd = null;
	/* Column Info */
	private String hdnLtStsCd = null;
	/* Column Info */
	private String hdnCntrTpszCd = null;
	/* Column Info */
	private String hdnMvmtStsCd = null;
	/* Column Info */
	private String vvdNo = null;
	/* Column Info */
	private String trsFactNm = null;  // TRS FACTORY NAME	
	/* Column Info */
	private String cnee = null;  // CONSIGNEE
	/* Column Info */
	private String trsWoFmYd = null;  // TRS W/O From Yard	
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public LandInvMonitoringVO() {}

	public LandInvMonitoringVO(String ibflag, String pagerows, String lccCd, String eccCd, String sccCd, String locCd, String orgYdCd, String cntrNo, String cntrTpszCd, String mvmtCd, String fcntrFlg, String finished, String fmStsCd, String fmDt, String ltYdCd, String ltStsCd, String ltDt, String ltCreTp, String stayDys, String freeDays, String byndFdys, String deTermCd, String scRfaNo, String scCustNm, String csFlg, String csDt, String chzExcept, String chzPayFlg, String chzRt, String chzAgmtNo, String chzPoolCd, String chzVndrSeq, String chzVndrNm, String chzTot, String trkVndrSeq, String trkVndrNm, String chssNo, String dmtChgStsCd, String dmtFmStsCd, String dmtToStsCd, String dmtTrfCd, String dmtFtDys, String dmtBillDys, String dmtFmDt, String dmtToDt, String dmtMtDt, String dmtFtCmncDt, String dmtFtEndDt, String dmtCurrCd, String dmtBilAmt, String trsVndrSeq, String trsVndrNm, String trsApptDt, String trsDeDt, String trsInvStsCd, String trsInvCfmDt, String bkgNo, String bndCd, String polPodNod, String porDelNod, String trnkVvd, String poletdPodeta, String shpr, String ntfy, String cmdtNm, String rdCgoFlg, String cntrDmgFlg, String dmtUcFlg, String ctrtOfcCd, String srepNm, String locLis, String finishCd, String cargoType, String boundCd, String rcvDelTerm, String stayingDays, String beyondFdays, String mvmtStsCd, String scNo, String fmTm, String ltTm, String trsApptTm, String trsDeTm, String locList, String blNo, String cdId, String trsWoIssUsrNm, String box, String avgStayDys, String avgByndFdys, String hdnPopYn, String hdnOrgYdCd, String hdnFcntrFlg, String hdnFinished, String hdnFmStsCd, String hdnLtStsCd, String hdnCntrTpszCd, String hdnMvmtStsCd, String vvdNo, String trsFactNm, String cnee, String trsWoFmYd) {
		this.ntfy = ntfy;
		this.csDt = csDt;
		this.chssNo = chssNo;
		this.chzTot = chzTot;
		this.cdId = cdId;
		this.fmTm = fmTm;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.boundCd = boundCd;
		this.porDelNod = porDelNod;
		this.chzVndrNm = chzVndrNm;
		this.locCd = locCd;
		this.dmtChgStsCd = dmtChgStsCd;
		this.scNo = scNo;
		this.ctrtOfcCd = ctrtOfcCd;
		this.cntrTpszCd = cntrTpszCd;
		this.trsApptDt = trsApptDt;
		this.dmtMtDt = dmtMtDt;
		this.trsVndrSeq = trsVndrSeq;
		this.locList = locList;
		this.poletdPodeta = poletdPodeta;
		this.trsApptTm = trsApptTm;
		this.chzRt = chzRt;
		this.rcvDelTerm = rcvDelTerm;
		this.trsDeDt = trsDeDt;
		this.scCustNm = scCustNm;
		this.freeDays = freeDays;
		this.dmtCurrCd = dmtCurrCd;
		this.trkVndrSeq = trkVndrSeq;
		this.dmtFmStsCd = dmtFmStsCd;
		this.dmtUcFlg = dmtUcFlg;
		this.chzAgmtNo = chzAgmtNo;
		this.bkgNo = bkgNo;
		this.chzExcept = chzExcept;
		this.trsVndrNm = trsVndrNm;
		this.dmtToDt = dmtToDt;
		this.rdCgoFlg = rdCgoFlg;
		this.trkVndrNm = trkVndrNm;
		this.ltDt = ltDt;
		this.dmtBillDys = dmtBillDys;
		this.fcntrFlg = fcntrFlg;
		this.cntrDmgFlg = cntrDmgFlg;
		this.ibflag = ibflag;
		this.stayDys = stayDys;
		this.srepNm = srepNm;
		this.ltStsCd = ltStsCd;
		this.cargoType = cargoType;
		this.dmtToStsCd = dmtToStsCd;
		this.dmtFtCmncDt = dmtFtCmncDt;
		this.ltYdCd = ltYdCd;
		this.chzVndrSeq = chzVndrSeq;
		this.byndFdys = byndFdys;
		this.dmtTrfCd = dmtTrfCd;
		this.trsDeTm = trsDeTm;
		this.dmtFtEndDt = dmtFtEndDt;
		this.trsInvCfmDt = trsInvCfmDt;
		this.fmDt = fmDt;
		this.beyondFdays = beyondFdays;
		this.chzPayFlg = chzPayFlg;
		this.locLis = locLis;
		this.bndCd = bndCd;
		this.eccCd = eccCd;
		this.fmStsCd = fmStsCd;
		this.dmtFmDt = dmtFmDt;
		this.mvmtCd = mvmtCd;
		this.csFlg = csFlg;
		this.finished = finished;
		this.chzPoolCd = chzPoolCd;
		this.orgYdCd = orgYdCd;
		this.cmdtNm = cmdtNm;
		this.finishCd = finishCd;
		this.dmtBilAmt = dmtBilAmt;
		this.deTermCd = deTermCd;
		this.lccCd = lccCd;
		this.mvmtStsCd = mvmtStsCd;
		this.sccCd = sccCd;
		this.scRfaNo = scRfaNo;
		this.ltTm = ltTm;
		this.cntrNo = cntrNo;
		this.stayingDays = stayingDays;
		this.ltCreTp = ltCreTp;
		this.polPodNod = polPodNod;
		this.trsInvStsCd = trsInvStsCd;
		this.shpr = shpr;
		this.dmtFtDys = dmtFtDys;
		this.trnkVvd = trnkVvd;
		this.trsWoIssUsrNm = trsWoIssUsrNm;
		this.box = box;
		this.avgStayDys = avgStayDys;
		this.avgByndFdys = avgByndFdys;
		this.hdnPopYn = hdnPopYn;
		this.hdnOrgYdCd = hdnOrgYdCd;
		this.hdnFcntrFlg = hdnFcntrFlg;
		this.hdnFinished = hdnFinished;
		this.hdnFmStsCd = hdnFmStsCd;
		this.hdnLtStsCd = hdnLtStsCd;
		this.hdnCntrTpszCd = hdnCntrTpszCd;
		this.hdnMvmtStsCd = hdnMvmtStsCd;
		this.vvdNo = vvdNo;
		this.trsFactNm = trsFactNm;
		this.cnee = cnee;
		this.trsWoFmYd = trsWoFmYd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ntfy", getNtfy());
		this.hashColumns.put("cs_dt", getCsDt());
		this.hashColumns.put("chss_no", getChssNo());
		this.hashColumns.put("chz_tot", getChzTot());
		this.hashColumns.put("cd_id", getCdId());
		this.hashColumns.put("fm_tm", getFmTm());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bound_cd", getBoundCd());
		this.hashColumns.put("por_del_nod", getPorDelNod());
		this.hashColumns.put("chz_vndr_nm", getChzVndrNm());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("dmt_chg_sts_cd", getDmtChgStsCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("trs_appt_dt", getTrsApptDt());
		this.hashColumns.put("dmt_mt_dt", getDmtMtDt());
		this.hashColumns.put("trs_vndr_seq", getTrsVndrSeq());
		this.hashColumns.put("loc_list", getLocList());
		this.hashColumns.put("poletd_podeta", getPoletdPodeta());
		this.hashColumns.put("trs_appt_tm", getTrsApptTm());
		this.hashColumns.put("chz_rt", getChzRt());
		this.hashColumns.put("rcv_del_term", getRcvDelTerm());
		this.hashColumns.put("trs_de_dt", getTrsDeDt());
		this.hashColumns.put("sc_cust_nm", getScCustNm());
		this.hashColumns.put("free_days", getFreeDays());
		this.hashColumns.put("dmt_curr_cd", getDmtCurrCd());
		this.hashColumns.put("trk_vndr_seq", getTrkVndrSeq());
		this.hashColumns.put("dmt_fm_sts_cd", getDmtFmStsCd());
		this.hashColumns.put("dmt_uc_flg", getDmtUcFlg());
		this.hashColumns.put("chz_agmt_no", getChzAgmtNo());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("chz_except", getChzExcept());
		this.hashColumns.put("trs_vndr_nm", getTrsVndrNm());
		this.hashColumns.put("dmt_to_dt", getDmtToDt());
		this.hashColumns.put("rd_cgo_flg", getRdCgoFlg());
		this.hashColumns.put("trk_vndr_nm", getTrkVndrNm());
		this.hashColumns.put("lt_dt", getLtDt());
		this.hashColumns.put("dmt_bill_dys", getDmtBillDys());
		this.hashColumns.put("fcntr_flg", getFcntrFlg());
		this.hashColumns.put("cntr_dmg_flg", getCntrDmgFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("stay_dys", getStayDys());
		this.hashColumns.put("srep_nm", getSrepNm());
		this.hashColumns.put("lt_sts_cd", getLtStsCd());
		this.hashColumns.put("cargo_type", getCargoType());
		this.hashColumns.put("dmt_to_sts_cd", getDmtToStsCd());
		this.hashColumns.put("dmt_ft_cmnc_dt", getDmtFtCmncDt());
		this.hashColumns.put("lt_yd_cd", getLtYdCd());
		this.hashColumns.put("chz_vndr_seq", getChzVndrSeq());
		this.hashColumns.put("bynd_fdys", getByndFdys());
		this.hashColumns.put("dmt_trf_cd", getDmtTrfCd());
		this.hashColumns.put("trs_de_tm", getTrsDeTm());
		this.hashColumns.put("dmt_ft_end_dt", getDmtFtEndDt());
		this.hashColumns.put("trs_inv_cfm_dt", getTrsInvCfmDt());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("beyond_fdays", getBeyondFdays());
		this.hashColumns.put("chz_pay_flg", getChzPayFlg());
		this.hashColumns.put("loc_lis", getLocLis());
		this.hashColumns.put("bnd_cd", getBndCd());
		this.hashColumns.put("ecc_cd", getEccCd());
		this.hashColumns.put("fm_sts_cd", getFmStsCd());
		this.hashColumns.put("dmt_fm_dt", getDmtFmDt());
		this.hashColumns.put("mvmt_cd", getMvmtCd());
		this.hashColumns.put("cs_flg", getCsFlg());
		this.hashColumns.put("finished", getFinished());
		this.hashColumns.put("chz_pool_cd", getChzPoolCd());
		this.hashColumns.put("org_yd_cd", getOrgYdCd());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("finish_cd", getFinishCd());
		this.hashColumns.put("dmt_bil_amt", getDmtBilAmt());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("lcc_cd", getLccCd());
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("sc_rfa_no", getScRfaNo());
		this.hashColumns.put("lt_tm", getLtTm());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("staying_days", getStayingDays());
		this.hashColumns.put("lt_cre_tp", getLtCreTp());
		this.hashColumns.put("pol_pod_nod", getPolPodNod());
		this.hashColumns.put("trs_inv_sts_cd", getTrsInvStsCd());
		this.hashColumns.put("shpr", getShpr());
		this.hashColumns.put("dmt_ft_dys", getDmtFtDys());
		this.hashColumns.put("trnk_vvd", getTrnkVvd());
		this.hashColumns.put("trs_wo_iss_usr_nm", getTrsWoIssUsrNm());
		this.hashColumns.put("box", getBox());
		this.hashColumns.put("avg_stay_dys", getAvgStayDys());
		this.hashColumns.put("avg_bynd_fdys", getAvgByndFdys());
		this.hashColumns.put("hdn_pop_yn", getBox());
		this.hashColumns.put("hdn_org_yd_cd", getAvgStayDys());
		this.hashColumns.put("hdn_fcntr_flg", getAvgByndFdys());
		this.hashColumns.put("hdn_pop_yn", getHdnPopYn());
		this.hashColumns.put("hdn_org_yd_cd", getHdnOrgYdCd());
		this.hashColumns.put("hdn_fcntr_flg", getHdnFcntrFlg());
		this.hashColumns.put("hdn_finished", getHdnFinished());
		this.hashColumns.put("hdn_fm_sts_cd", getHdnFmStsCd());
		this.hashColumns.put("hdn_lt_sts_cd", getHdnLtStsCd());
		this.hashColumns.put("hdn_cntr_tpsz_cd", getHdnCntrTpszCd());
		this.hashColumns.put("hdn_mvmt_sts_cd", getHdnMvmtStsCd());
		this.hashColumns.put("vvd_no", getVvdNo());	
		this.hashColumns.put("trs_fact_nm", getTrsFactNm());
		this.hashColumns.put("cnee", getCnee());
		this.hashColumns.put("trs_wo_fm_yd", getTrsWoFmYd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ntfy", "ntfy");
		this.hashFields.put("cs_dt", "csDt");
		this.hashFields.put("chss_no", "chssNo");
		this.hashFields.put("chz_tot", "chzTot");
		this.hashFields.put("cd_id", "cdId");
		this.hashFields.put("fm_tm", "fmTm");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bound_cd", "boundCd");
		this.hashFields.put("por_del_nod", "porDelNod");
		this.hashFields.put("chz_vndr_nm", "chzVndrNm");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("dmt_chg_sts_cd", "dmtChgStsCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("trs_appt_dt", "trsApptDt");
		this.hashFields.put("dmt_mt_dt", "dmtMtDt");
		this.hashFields.put("trs_vndr_seq", "trsVndrSeq");
		this.hashFields.put("loc_list", "locList");
		this.hashFields.put("poletd_podeta", "poletdPodeta");
		this.hashFields.put("trs_appt_tm", "trsApptTm");
		this.hashFields.put("chz_rt", "chzRt");
		this.hashFields.put("rcv_del_term", "rcvDelTerm");
		this.hashFields.put("trs_de_dt", "trsDeDt");
		this.hashFields.put("sc_cust_nm", "scCustNm");
		this.hashFields.put("free_days", "freeDays");
		this.hashFields.put("dmt_curr_cd", "dmtCurrCd");
		this.hashFields.put("trk_vndr_seq", "trkVndrSeq");
		this.hashFields.put("dmt_fm_sts_cd", "dmtFmStsCd");
		this.hashFields.put("dmt_uc_flg", "dmtUcFlg");
		this.hashFields.put("chz_agmt_no", "chzAgmtNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("chz_except", "chzExcept");
		this.hashFields.put("trs_vndr_nm", "trsVndrNm");
		this.hashFields.put("dmt_to_dt", "dmtToDt");
		this.hashFields.put("rd_cgo_flg", "rdCgoFlg");
		this.hashFields.put("trk_vndr_nm", "trkVndrNm");
		this.hashFields.put("lt_dt", "ltDt");
		this.hashFields.put("dmt_bill_dys", "dmtBillDys");
		this.hashFields.put("fcntr_flg", "fcntrFlg");
		this.hashFields.put("cntr_dmg_flg", "cntrDmgFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("stay_dys", "stayDys");
		this.hashFields.put("srep_nm", "srepNm");
		this.hashFields.put("lt_sts_cd", "ltStsCd");
		this.hashFields.put("cargo_type", "cargoType");
		this.hashFields.put("dmt_to_sts_cd", "dmtToStsCd");
		this.hashFields.put("dmt_ft_cmnc_dt", "dmtFtCmncDt");
		this.hashFields.put("lt_yd_cd", "ltYdCd");
		this.hashFields.put("chz_vndr_seq", "chzVndrSeq");
		this.hashFields.put("bynd_fdys", "byndFdys");
		this.hashFields.put("dmt_trf_cd", "dmtTrfCd");
		this.hashFields.put("trs_de_tm", "trsDeTm");
		this.hashFields.put("dmt_ft_end_dt", "dmtFtEndDt");
		this.hashFields.put("trs_inv_cfm_dt", "trsInvCfmDt");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("beyond_fdays", "beyondFdays");
		this.hashFields.put("chz_pay_flg", "chzPayFlg");
		this.hashFields.put("loc_lis", "locLis");
		this.hashFields.put("bnd_cd", "bndCd");
		this.hashFields.put("ecc_cd", "eccCd");
		this.hashFields.put("fm_sts_cd", "fmStsCd");
		this.hashFields.put("dmt_fm_dt", "dmtFmDt");
		this.hashFields.put("mvmt_cd", "mvmtCd");
		this.hashFields.put("cs_flg", "csFlg");
		this.hashFields.put("finished", "finished");
		this.hashFields.put("chz_pool_cd", "chzPoolCd");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("finish_cd", "finishCd");
		this.hashFields.put("dmt_bil_amt", "dmtBilAmt");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("lcc_cd", "lccCd");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("sc_rfa_no", "scRfaNo");
		this.hashFields.put("lt_tm", "ltTm");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("staying_days", "stayingDays");
		this.hashFields.put("lt_cre_tp", "ltCreTp");
		this.hashFields.put("pol_pod_nod", "polPodNod");
		this.hashFields.put("trs_inv_sts_cd", "trsInvStsCd");
		this.hashFields.put("shpr", "shpr");
		this.hashFields.put("dmt_ft_dys", "dmtFtDys");
		this.hashFields.put("trnk_vvd", "trnkVvd");
		this.hashFields.put("trs_wo_iss_usr_nm", "trsWoIssUsrNm");
		this.hashFields.put("box", "box");
		this.hashFields.put("avg_stay_dys", "avgStayDys");
		this.hashFields.put("avg_bynd_fdys", "avgByndFdys");
		this.hashFields.put("hdn_pop_yn", "hdnPopYn");
		this.hashFields.put("hdn_org_yd_cd", "hdnOrgYdCd");
		this.hashFields.put("hdn_fcntr_flg", "hdnFcntrFlg");
		this.hashFields.put("hdn_finished", "hdnFinished");
		this.hashFields.put("hdn_fm_sts_cd", "hdnFmStsCd");
		this.hashFields.put("hdn_lt_sts_cd", "hdnLtStsCd");
		this.hashFields.put("hdn_cntr_tpsz_cd", "hdnCntrTpszCd");
		this.hashFields.put("hdn_mvmt_sts_cd", "hdnMvmtStsCd");
		this.hashFields.put("vvd_no", "vvdNo");
		this.hashFields.put("trs_fact_nm", "trsFactNm");
		this.hashFields.put("cnee", "cnee");
		this.hashFields.put("trs_wo_fm_yd", "trsWoFmYd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ntfy
	 */
	public String getNtfy() {
		return this.ntfy;
	}
	
	/**
	 * Column Info
	 * @return csDt
	 */
	public String getCsDt() {
		return this.csDt;
	}
	
	/**
	 * Column Info
	 * @return chssNo
	 */
	public String getChssNo() {
		return this.chssNo;
	}
	
	/**
	 * Column Info
	 * @return chzTot
	 */
	public String getChzTot() {
		return this.chzTot;
	}
	
	/**
	 * Column Info
	 * @return cdId
	 */
	public String getCdId() {
		return this.cdId;
	}
	
	/**
	 * Column Info
	 * @return fmTm
	 */
	public String getFmTm() {
		return this.fmTm;
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
	 * @return boundCd
	 */
	public String getBoundCd() {
		return this.boundCd;
	}
	
	/**
	 * Column Info
	 * @return porDelNod
	 */
	public String getPorDelNod() {
		return this.porDelNod;
	}
	
	/**
	 * Column Info
	 * @return chzVndrNm
	 */
	public String getChzVndrNm() {
		return this.chzVndrNm;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return dmtChgStsCd
	 */
	public String getDmtChgStsCd() {
		return this.dmtChgStsCd;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return ctrtOfcCd
	 */
	public String getCtrtOfcCd() {
		return this.ctrtOfcCd;
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
	 * @return trsApptDt
	 */
	public String getTrsApptDt() {
		return this.trsApptDt;
	}
	
	/**
	 * Column Info
	 * @return dmtMtDt
	 */
	public String getDmtMtDt() {
		return this.dmtMtDt;
	}
	
	/**
	 * Column Info
	 * @return trsVndrSeq
	 */
	public String getTrsVndrSeq() {
		return this.trsVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return locList
	 */
	public String getLocList() {
		return this.locList;
	}
	
	/**
	 * Column Info
	 * @return poletdPodeta
	 */
	public String getPoletdPodeta() {
		return this.poletdPodeta;
	}
	
	/**
	 * Column Info
	 * @return trsApptTm
	 */
	public String getTrsApptTm() {
		return this.trsApptTm;
	}
	
	/**
	 * Column Info
	 * @return chzRt
	 */
	public String getChzRt() {
		return this.chzRt;
	}
	
	/**
	 * Column Info
	 * @return rcvDelTerm
	 */
	public String getRcvDelTerm() {
		return this.rcvDelTerm;
	}
	
	/**
	 * Column Info
	 * @return trsDeDt
	 */
	public String getTrsDeDt() {
		return this.trsDeDt;
	}
	
	/**
	 * Column Info
	 * @return scCustNm
	 */
	public String getScCustNm() {
		return this.scCustNm;
	}
	
	/**
	 * Column Info
	 * @return freeDays
	 */
	public String getFreeDays() {
		return this.freeDays;
	}
	
	/**
	 * Column Info
	 * @return dmtCurrCd
	 */
	public String getDmtCurrCd() {
		return this.dmtCurrCd;
	}
	
	/**
	 * Column Info
	 * @return trkVndrSeq
	 */
	public String getTrkVndrSeq() {
		return this.trkVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return dmtFmStsCd
	 */
	public String getDmtFmStsCd() {
		return this.dmtFmStsCd;
	}
	
	/**
	 * Column Info
	 * @return dmtUcFlg
	 */
	public String getDmtUcFlg() {
		return this.dmtUcFlg;
	}
	
	/**
	 * Column Info
	 * @return chzAgmtNo
	 */
	public String getChzAgmtNo() {
		return this.chzAgmtNo;
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
	 * @return chzExcept
	 */
	public String getChzExcept() {
		return this.chzExcept;
	}
	
	/**
	 * Column Info
	 * @return trsVndrNm
	 */
	public String getTrsVndrNm() {
		return this.trsVndrNm;
	}
	
	/**
	 * Column Info
	 * @return dmtToDt
	 */
	public String getDmtToDt() {
		return this.dmtToDt;
	}
	
	/**
	 * Column Info
	 * @return rdCgoFlg
	 */
	public String getRdCgoFlg() {
		return this.rdCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return trkVndrNm
	 */
	public String getTrkVndrNm() {
		return this.trkVndrNm;
	}
	
	/**
	 * Column Info
	 * @return ltDt
	 */
	public String getLtDt() {
		return this.ltDt;
	}
	
	/**
	 * Column Info
	 * @return dmtBillDys
	 */
	public String getDmtBillDys() {
		return this.dmtBillDys;
	}
	
	/**
	 * Column Info
	 * @return fcntrFlg
	 */
	public String getFcntrFlg() {
		return this.fcntrFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrDmgFlg
	 */
	public String getCntrDmgFlg() {
		return this.cntrDmgFlg;
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
	 * @return stayDys
	 */
	public String getStayDys() {
		return this.stayDys;
	}
	
	/**
	 * Column Info
	 * @return srepNm
	 */
	public String getSrepNm() {
		return this.srepNm;
	}
	
	/**
	 * Column Info
	 * @return ltStsCd
	 */
	public String getLtStsCd() {
		return this.ltStsCd;
	}
	
	/**
	 * Column Info
	 * @return cargoType
	 */
	public String getCargoType() {
		return this.cargoType;
	}
	
	/**
	 * Column Info
	 * @return dmtToStsCd
	 */
	public String getDmtToStsCd() {
		return this.dmtToStsCd;
	}
	
	/**
	 * Column Info
	 * @return dmtFtCmncDt
	 */
	public String getDmtFtCmncDt() {
		return this.dmtFtCmncDt;
	}
	
	/**
	 * Column Info
	 * @return ltYdCd
	 */
	public String getLtYdCd() {
		return this.ltYdCd;
	}
	
	/**
	 * Column Info
	 * @return chzVndrSeq
	 */
	public String getChzVndrSeq() {
		return this.chzVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return byndFdys
	 */
	public String getByndFdys() {
		return this.byndFdys;
	}
	
	/**
	 * Column Info
	 * @return dmtTrfCd
	 */
	public String getDmtTrfCd() {
		return this.dmtTrfCd;
	}
	
	/**
	 * Column Info
	 * @return trsDeTm
	 */
	public String getTrsDeTm() {
		return this.trsDeTm;
	}
	
	/**
	 * Column Info
	 * @return dmtFtEndDt
	 */
	public String getDmtFtEndDt() {
		return this.dmtFtEndDt;
	}
	
	/**
	 * Column Info
	 * @return trsInvCfmDt
	 */
	public String getTrsInvCfmDt() {
		return this.trsInvCfmDt;
	}
	
	/**
	 * Column Info
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return beyondFdays
	 */
	public String getBeyondFdays() {
		return this.beyondFdays;
	}
	
	/**
	 * Column Info
	 * @return chzPayFlg
	 */
	public String getChzPayFlg() {
		return this.chzPayFlg;
	}
	
	/**
	 * Column Info
	 * @return locLis
	 */
	public String getLocLis() {
		return this.locLis;
	}
	
	/**
	 * Column Info
	 * @return bndCd
	 */
	public String getBndCd() {
		return this.bndCd;
	}
	
	/**
	 * Column Info
	 * @return eccCd
	 */
	public String getEccCd() {
		return this.eccCd;
	}
	
	/**
	 * Column Info
	 * @return fmStsCd
	 */
	public String getFmStsCd() {
		return this.fmStsCd;
	}
	
	/**
	 * Column Info
	 * @return dmtFmDt
	 */
	public String getDmtFmDt() {
		return this.dmtFmDt;
	}
	
	/**
	 * Column Info
	 * @return mvmtCd
	 */
	public String getMvmtCd() {
		return this.mvmtCd;
	}
	
	/**
	 * Column Info
	 * @return csFlg
	 */
	public String getCsFlg() {
		return this.csFlg;
	}
	
	/**
	 * Column Info
	 * @return finished
	 */
	public String getFinished() {
		return this.finished;
	}
	
	/**
	 * Column Info
	 * @return chzPoolCd
	 */
	public String getChzPoolCd() {
		return this.chzPoolCd;
	}
	
	/**
	 * Column Info
	 * @return orgYdCd
	 */
	public String getOrgYdCd() {
		return this.orgYdCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
	}
	
	/**
	 * Column Info
	 * @return finishCd
	 */
	public String getFinishCd() {
		return this.finishCd;
	}
	
	/**
	 * Column Info
	 * @return dmtBilAmt
	 */
	public String getDmtBilAmt() {
		return this.dmtBilAmt;
	}
	
	/**
	 * Column Info
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
	}
	
	/**
	 * Column Info
	 * @return lccCd
	 */
	public String getLccCd() {
		return this.lccCd;
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
	 * @return scRfaNo
	 */
	public String getScRfaNo() {
		return this.scRfaNo;
	}
	
	/**
	 * Column Info
	 * @return ltTm
	 */
	public String getLtTm() {
		return this.ltTm;
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
	 * @return stayingDays
	 */
	public String getStayingDays() {
		return this.stayingDays;
	}
	
	/**
	 * Column Info
	 * @return ltCreTp
	 */
	public String getLtCreTp() {
		return this.ltCreTp;
	}
	
	/**
	 * Column Info
	 * @return polPodNod
	 */
	public String getPolPodNod() {
		return this.polPodNod;
	}
	
	/**
	 * Column Info
	 * @return trsInvStsCd
	 */
	public String getTrsInvStsCd() {
		return this.trsInvStsCd;
	}
	
	/**
	 * Column Info
	 * @return shpr
	 */
	public String getShpr() {
		return this.shpr;
	}
	
	/**
	 * Column Info
	 * @return dmtFtDys
	 */
	public String getDmtFtDys() {
		return this.dmtFtDys;
	}
	
	/**
	 * Column Info
	 * @return trnkVvd
	 */
	public String getTrnkVvd() {
		return this.trnkVvd;
	}
	

	/**
	 * Column Info
	 * @param ntfy
	 */
	public void setNtfy(String ntfy) {
		this.ntfy = ntfy;
	}
	
	/**
	 * Column Info
	 * @param csDt
	 */
	public void setCsDt(String csDt) {
		this.csDt = csDt;
	}
	
	/**
	 * Column Info
	 * @param chssNo
	 */
	public void setChssNo(String chssNo) {
		this.chssNo = chssNo;
	}
	
	/**
	 * Column Info
	 * @param chzTot
	 */
	public void setChzTot(String chzTot) {
		this.chzTot = chzTot;
	}
	
	/**
	 * Column Info
	 * @param cdId
	 */
	public void setCdId(String cdId) {
		this.cdId = cdId;
	}
	
	/**
	 * Column Info
	 * @param fmTm
	 */
	public void setFmTm(String fmTm) {
		this.fmTm = fmTm;
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
	 * @param boundCd
	 */
	public void setBoundCd(String boundCd) {
		this.boundCd = boundCd;
	}
	
	/**
	 * Column Info
	 * @param porDelNod
	 */
	public void setPorDelNod(String porDelNod) {
		this.porDelNod = porDelNod;
	}
	
	/**
	 * Column Info
	 * @param chzVndrNm
	 */
	public void setChzVndrNm(String chzVndrNm) {
		this.chzVndrNm = chzVndrNm;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param dmtChgStsCd
	 */
	public void setDmtChgStsCd(String dmtChgStsCd) {
		this.dmtChgStsCd = dmtChgStsCd;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param ctrtOfcCd
	 */
	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
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
	 * @param trsApptDt
	 */
	public void setTrsApptDt(String trsApptDt) {
		this.trsApptDt = trsApptDt;
	}
	
	/**
	 * Column Info
	 * @param dmtMtDt
	 */
	public void setDmtMtDt(String dmtMtDt) {
		this.dmtMtDt = dmtMtDt;
	}
	
	/**
	 * Column Info
	 * @param trsVndrSeq
	 */
	public void setTrsVndrSeq(String trsVndrSeq) {
		this.trsVndrSeq = trsVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param locList
	 */
	public void setLocList(String locList) {
		this.locList = locList;
	}
	
	/**
	 * Column Info
	 * @param poletdPodeta
	 */
	public void setPoletdPodeta(String poletdPodeta) {
		this.poletdPodeta = poletdPodeta;
	}
	
	/**
	 * Column Info
	 * @param trsApptTm
	 */
	public void setTrsApptTm(String trsApptTm) {
		this.trsApptTm = trsApptTm;
	}
	
	/**
	 * Column Info
	 * @param chzRt
	 */
	public void setChzRt(String chzRt) {
		this.chzRt = chzRt;
	}
	
	/**
	 * Column Info
	 * @param rcvDelTerm
	 */
	public void setRcvDelTerm(String rcvDelTerm) {
		this.rcvDelTerm = rcvDelTerm;
	}
	
	/**
	 * Column Info
	 * @param trsDeDt
	 */
	public void setTrsDeDt(String trsDeDt) {
		this.trsDeDt = trsDeDt;
	}
	
	/**
	 * Column Info
	 * @param scCustNm
	 */
	public void setScCustNm(String scCustNm) {
		this.scCustNm = scCustNm;
	}
	
	/**
	 * Column Info
	 * @param freeDays
	 */
	public void setFreeDays(String freeDays) {
		this.freeDays = freeDays;
	}
	
	/**
	 * Column Info
	 * @param dmtCurrCd
	 */
	public void setDmtCurrCd(String dmtCurrCd) {
		this.dmtCurrCd = dmtCurrCd;
	}
	
	/**
	 * Column Info
	 * @param trkVndrSeq
	 */
	public void setTrkVndrSeq(String trkVndrSeq) {
		this.trkVndrSeq = trkVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param dmtFmStsCd
	 */
	public void setDmtFmStsCd(String dmtFmStsCd) {
		this.dmtFmStsCd = dmtFmStsCd;
	}
	
	/**
	 * Column Info
	 * @param dmtUcFlg
	 */
	public void setDmtUcFlg(String dmtUcFlg) {
		this.dmtUcFlg = dmtUcFlg;
	}
	
	/**
	 * Column Info
	 * @param chzAgmtNo
	 */
	public void setChzAgmtNo(String chzAgmtNo) {
		this.chzAgmtNo = chzAgmtNo;
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
	 * @param chzExcept
	 */
	public void setChzExcept(String chzExcept) {
		this.chzExcept = chzExcept;
	}
	
	/**
	 * Column Info
	 * @param trsVndrNm
	 */
	public void setTrsVndrNm(String trsVndrNm) {
		this.trsVndrNm = trsVndrNm;
	}
	
	/**
	 * Column Info
	 * @param dmtToDt
	 */
	public void setDmtToDt(String dmtToDt) {
		this.dmtToDt = dmtToDt;
	}
	
	/**
	 * Column Info
	 * @param rdCgoFlg
	 */
	public void setRdCgoFlg(String rdCgoFlg) {
		this.rdCgoFlg = rdCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param trkVndrNm
	 */
	public void setTrkVndrNm(String trkVndrNm) {
		this.trkVndrNm = trkVndrNm;
	}
	
	/**
	 * Column Info
	 * @param ltDt
	 */
	public void setLtDt(String ltDt) {
		this.ltDt = ltDt;
	}
	
	/**
	 * Column Info
	 * @param dmtBillDys
	 */
	public void setDmtBillDys(String dmtBillDys) {
		this.dmtBillDys = dmtBillDys;
	}
	
	/**
	 * Column Info
	 * @param fcntrFlg
	 */
	public void setFcntrFlg(String fcntrFlg) {
		this.fcntrFlg = fcntrFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrDmgFlg
	 */
	public void setCntrDmgFlg(String cntrDmgFlg) {
		this.cntrDmgFlg = cntrDmgFlg;
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
	 * @param stayDys
	 */
	public void setStayDys(String stayDys) {
		this.stayDys = stayDys;
	}
	
	/**
	 * Column Info
	 * @param srepNm
	 */
	public void setSrepNm(String srepNm) {
		this.srepNm = srepNm;
	}
	
	/**
	 * Column Info
	 * @param ltStsCd
	 */
	public void setLtStsCd(String ltStsCd) {
		this.ltStsCd = ltStsCd;
	}
	
	/**
	 * Column Info
	 * @param cargoType
	 */
	public void setCargoType(String cargoType) {
		this.cargoType = cargoType;
	}
	
	/**
	 * Column Info
	 * @param dmtToStsCd
	 */
	public void setDmtToStsCd(String dmtToStsCd) {
		this.dmtToStsCd = dmtToStsCd;
	}
	
	/**
	 * Column Info
	 * @param dmtFtCmncDt
	 */
	public void setDmtFtCmncDt(String dmtFtCmncDt) {
		this.dmtFtCmncDt = dmtFtCmncDt;
	}
	
	/**
	 * Column Info
	 * @param ltYdCd
	 */
	public void setLtYdCd(String ltYdCd) {
		this.ltYdCd = ltYdCd;
	}
	
	/**
	 * Column Info
	 * @param chzVndrSeq
	 */
	public void setChzVndrSeq(String chzVndrSeq) {
		this.chzVndrSeq = chzVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param byndFdys
	 */
	public void setByndFdys(String byndFdys) {
		this.byndFdys = byndFdys;
	}
	
	/**
	 * Column Info
	 * @param dmtTrfCd
	 */
	public void setDmtTrfCd(String dmtTrfCd) {
		this.dmtTrfCd = dmtTrfCd;
	}
	
	/**
	 * Column Info
	 * @param trsDeTm
	 */
	public void setTrsDeTm(String trsDeTm) {
		this.trsDeTm = trsDeTm;
	}
	
	/**
	 * Column Info
	 * @param dmtFtEndDt
	 */
	public void setDmtFtEndDt(String dmtFtEndDt) {
		this.dmtFtEndDt = dmtFtEndDt;
	}
	
	/**
	 * Column Info
	 * @param trsInvCfmDt
	 */
	public void setTrsInvCfmDt(String trsInvCfmDt) {
		this.trsInvCfmDt = trsInvCfmDt;
	}
	
	/**
	 * Column Info
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param beyondFdays
	 */
	public void setBeyondFdays(String beyondFdays) {
		this.beyondFdays = beyondFdays;
	}
	
	/**
	 * Column Info
	 * @param chzPayFlg
	 */
	public void setChzPayFlg(String chzPayFlg) {
		this.chzPayFlg = chzPayFlg;
	}
	
	/**
	 * Column Info
	 * @param locLis
	 */
	public void setLocLis(String locLis) {
		this.locLis = locLis;
	}
	
	/**
	 * Column Info
	 * @param bndCd
	 */
	public void setBndCd(String bndCd) {
		this.bndCd = bndCd;
	}
	
	/**
	 * Column Info
	 * @param eccCd
	 */
	public void setEccCd(String eccCd) {
		this.eccCd = eccCd;
	}
	
	/**
	 * Column Info
	 * @param fmStsCd
	 */
	public void setFmStsCd(String fmStsCd) {
		this.fmStsCd = fmStsCd;
	}
	
	/**
	 * Column Info
	 * @param dmtFmDt
	 */
	public void setDmtFmDt(String dmtFmDt) {
		this.dmtFmDt = dmtFmDt;
	}
	
	/**
	 * Column Info
	 * @param mvmtCd
	 */
	public void setMvmtCd(String mvmtCd) {
		this.mvmtCd = mvmtCd;
	}
	
	/**
	 * Column Info
	 * @param csFlg
	 */
	public void setCsFlg(String csFlg) {
		this.csFlg = csFlg;
	}
	
	/**
	 * Column Info
	 * @param finished
	 */
	public void setFinished(String finished) {
		this.finished = finished;
	}
	
	/**
	 * Column Info
	 * @param chzPoolCd
	 */
	public void setChzPoolCd(String chzPoolCd) {
		this.chzPoolCd = chzPoolCd;
	}
	
	/**
	 * Column Info
	 * @param orgYdCd
	 */
	public void setOrgYdCd(String orgYdCd) {
		this.orgYdCd = orgYdCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
	}
	
	/**
	 * Column Info
	 * @param finishCd
	 */
	public void setFinishCd(String finishCd) {
		this.finishCd = finishCd;
	}
	
	/**
	 * Column Info
	 * @param dmtBilAmt
	 */
	public void setDmtBilAmt(String dmtBilAmt) {
		this.dmtBilAmt = dmtBilAmt;
	}
	
	/**
	 * Column Info
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
	}
	
	/**
	 * Column Info
	 * @param lccCd
	 */
	public void setLccCd(String lccCd) {
		this.lccCd = lccCd;
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
	 * @param scRfaNo
	 */
	public void setScRfaNo(String scRfaNo) {
		this.scRfaNo = scRfaNo;
	}
	
	/**
	 * Column Info
	 * @param ltTm
	 */
	public void setLtTm(String ltTm) {
		this.ltTm = ltTm;
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
	 * @param stayingDays
	 */
	public void setStayingDays(String stayingDays) {
		this.stayingDays = stayingDays;
	}
	
	/**
	 * Column Info
	 * @param ltCreTp
	 */
	public void setLtCreTp(String ltCreTp) {
		this.ltCreTp = ltCreTp;
	}
	
	/**
	 * Column Info
	 * @param polPodNod
	 */
	public void setPolPodNod(String polPodNod) {
		this.polPodNod = polPodNod;
	}
	
	/**
	 * Column Info
	 * @param trsInvStsCd
	 */
	public void setTrsInvStsCd(String trsInvStsCd) {
		this.trsInvStsCd = trsInvStsCd;
	}
	
	/**
	 * Column Info
	 * @param shpr
	 */
	public void setShpr(String shpr) {
		this.shpr = shpr;
	}
	
	/**
	 * Column Info
	 * @param dmtFtDys
	 */
	public void setDmtFtDys(String dmtFtDys) {
		this.dmtFtDys = dmtFtDys;
	}
	
	/**
	 * Column Info
	 * @param trnkVvd
	 */
	public void setTrnkVvd(String trnkVvd) {
		this.trnkVvd = trnkVvd;
	}
	
	/**
	 * Column Info
	 * @param trsWoIssUsrNm
	 */
	public void setTrsWoIssUsrNm(String trsWoIssUsrNm) {
		this.trsWoIssUsrNm = trsWoIssUsrNm;
	}
 
	/**
	 * Column Info
	 * @return trsWoIssUsrNm
	 */
	public String getTrsWoIssUsrNm() {
		 return this.trsWoIssUsrNm;
	}
	
	/**
	 * Column Info
	 * @return box
	 */
	public String getBox() {
		return this.box;
	}

	/**
	 * Column Info
	 * @return avgStayDys
	 */
	public String getAvgStayDys() {
		return this.avgStayDys;
	}

	/**
	 * Column Info
	 * @return avgByndFdys
	 */
	public String getAvgByndFdys() {
		return this.avgByndFdys;
	}
	
	/**
	 * Column Info
	 * @return box
	 */
	public void setBox(String box) {
		this.box = box;
	}

	/**
	 * Column Info
	 * @return avgStayDys
	 */
	public void setAvgStayDys(String avgStayDys) {
		this.avgStayDys = avgStayDys;
	}

	/**
	 * Column Info
	 * @return avgByndFdys
	 */
	public void setAvgByndFdys(String avgByndFdys) {
		this.avgByndFdys = avgByndFdys;
	}
	
	/**
	 * Column Info
	 * @return hdnPopYn
	 */
	public String getHdnPopYn() {
		return this.hdnPopYn;
	}

	/**
	 * Column Info
	 * @return hdnOrgYdCd
	 */
	public String getHdnOrgYdCd() {
		return this.hdnOrgYdCd;
	}

	/**
	 * Column Info
	 * @return hdnFcntrFlg
	 */
	public String getHdnFcntrFlg() {
		return this.hdnFcntrFlg;
	}

	/**
	 * Column Info
	 * @return hdnFinished
	 */
	public String getHdnFinished() {
		return this.hdnFinished;
	}

	/**
	 * Column Info
	 * @return hdnFmStsCd
	 */
	public String getHdnFmStsCd() {
		return this.hdnFmStsCd;
	}

	/**
	 * Column Info
	 * @return hdnLtStsCd
	 */
	public String getHdnLtStsCd() {
		return this.hdnLtStsCd;
	}

	/**
	 * Column Info
	 * @return hdnCntrTpszCd
	 */
	public String getHdnCntrTpszCd() {
		return this.hdnCntrTpszCd;
	}

	/**
	 * Column Info
	 * @return hdnMvmtStsCd
	 */
	public String getHdnMvmtStsCd() {
		return this.hdnMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @return hdnPopYn
	 */
	public void setHdnPopYn(String hdnPopYn) {
		this.hdnPopYn = hdnPopYn;
	}

	/**
	 * Column Info
	 * @return hdnOrgYdCd
	 */
	public void setHdnOrgYdCd(String hdnOrgYdCd) {
		this.hdnOrgYdCd = hdnOrgYdCd;
	}

	/**
	 * Column Info
	 * @return hdnFcntrFlg
	 */
	public void setHdnFcntrFlg(String hdnFcntrFlg) {
		this.hdnFcntrFlg = hdnFcntrFlg;
	}

	/**
	 * Column Info
	 * @return hdnFinished
	 */
	public void setHdnFinished(String hdnFinished) {
		this.hdnFinished = hdnFinished;
	}

	/**
	 * Column Info
	 * @return hdnFmStsCd
	 */
	public void setHdnFmStsCd(String hdnFmStsCd) {
		this.hdnFmStsCd = hdnFmStsCd;
	}

	/**
	 * Column Info
	 * @return hdnLtStsCd
	 */
	public void setHdnLtStsCd(String hdnLtStsCd) {
		this.hdnLtStsCd = hdnLtStsCd;
	}

	/**
	 * Column Info
	 * @return hdnCntrTpszCd
	 */
	public void setHdnCntrTpszCd(String hdnCntrTpszCd) {
		this.hdnCntrTpszCd = hdnCntrTpszCd;
	}

	/**
	 * Column Info
	 * @return hdnMvmtStsCd
	 */
	public void setHdnMvmtStsCd(String hdnMvmtStsCd) {
		this.hdnMvmtStsCd = hdnMvmtStsCd;
	}

	/**
	 * Column Info
	 * @return vvdNo
	 */
	public String getVvdNo() {
		return vvdNo;
	}

	/**
	 * Column Info
	 * @return hdnMvmtStsCd
	 */
	public void setVvdNo(String vvdNo) {
		this.vvdNo = vvdNo;
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
		setNtfy(JSPUtil.getParameter(request, prefix + "ntfy", ""));
		setCsDt(JSPUtil.getParameter(request, prefix + "cs_dt", ""));
		setChssNo(JSPUtil.getParameter(request, prefix + "chss_no", ""));
		setChzTot(JSPUtil.getParameter(request, prefix + "chz_tot", ""));
		setCdId(JSPUtil.getParameter(request, prefix + "cd_id", ""));
		setFmTm(JSPUtil.getParameter(request, prefix + "fm_tm", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBoundCd(JSPUtil.getParameter(request, prefix + "bound_cd", ""));
		setPorDelNod(JSPUtil.getParameter(request, prefix + "por_del_nod", ""));
		setChzVndrNm(JSPUtil.getParameter(request, prefix + "chz_vndr_nm", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setDmtChgStsCd(JSPUtil.getParameter(request, prefix + "dmt_chg_sts_cd", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setTrsApptDt(JSPUtil.getParameter(request, prefix + "trs_appt_dt", ""));
		setDmtMtDt(JSPUtil.getParameter(request, prefix + "dmt_mt_dt", ""));
		setTrsVndrSeq(JSPUtil.getParameter(request, prefix + "trs_vndr_seq", ""));
		setLocList(JSPUtil.getParameter(request, prefix + "loc_list", ""));
		setPoletdPodeta(JSPUtil.getParameter(request, prefix + "poletd_podeta", ""));
		setTrsApptTm(JSPUtil.getParameter(request, prefix + "trs_appt_tm", ""));
		setChzRt(JSPUtil.getParameter(request, prefix + "chz_rt", ""));
		setRcvDelTerm(JSPUtil.getParameter(request, prefix + "rcv_del_term", ""));
		setTrsDeDt(JSPUtil.getParameter(request, prefix + "trs_de_dt", ""));
		setScCustNm(JSPUtil.getParameter(request, prefix + "sc_cust_nm", ""));
		setFreeDays(JSPUtil.getParameter(request, prefix + "free_days", ""));
		setDmtCurrCd(JSPUtil.getParameter(request, prefix + "dmt_curr_cd", ""));
		setTrkVndrSeq(JSPUtil.getParameter(request, prefix + "trk_vndr_seq", ""));
		setDmtFmStsCd(JSPUtil.getParameter(request, prefix + "dmt_fm_sts_cd", ""));
		setDmtUcFlg(JSPUtil.getParameter(request, prefix + "dmt_uc_flg", ""));
		setChzAgmtNo(JSPUtil.getParameter(request, prefix + "chz_agmt_no", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setChzExcept(JSPUtil.getParameter(request, prefix + "chz_except", ""));
		setTrsVndrNm(JSPUtil.getParameter(request, prefix + "trs_vndr_nm", ""));
		setDmtToDt(JSPUtil.getParameter(request, prefix + "dmt_to_dt", ""));
		setRdCgoFlg(JSPUtil.getParameter(request, prefix + "rd_cgo_flg", ""));
		setTrkVndrNm(JSPUtil.getParameter(request, prefix + "trk_vndr_nm", ""));
		setLtDt(JSPUtil.getParameter(request, prefix + "lt_dt", ""));
		setDmtBillDys(JSPUtil.getParameter(request, prefix + "dmt_bill_dys", ""));
		setFcntrFlg(JSPUtil.getParameter(request, prefix + "fcntr_flg", ""));
		setCntrDmgFlg(JSPUtil.getParameter(request, prefix + "cntr_dmg_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setStayDys(JSPUtil.getParameter(request, prefix + "stay_dys", ""));
		setSrepNm(JSPUtil.getParameter(request, prefix + "srep_nm", ""));
		setLtStsCd(JSPUtil.getParameter(request, prefix + "lt_sts_cd", ""));
		setCargoType(JSPUtil.getParameter(request, prefix + "cargo_type", ""));
		setDmtToStsCd(JSPUtil.getParameter(request, prefix + "dmt_to_sts_cd", ""));
		setDmtFtCmncDt(JSPUtil.getParameter(request, prefix + "dmt_ft_cmnc_dt", ""));
		setLtYdCd(JSPUtil.getParameter(request, prefix + "lt_yd_cd", ""));
		setChzVndrSeq(JSPUtil.getParameter(request, prefix + "chz_vndr_seq", ""));
		setByndFdys(JSPUtil.getParameter(request, prefix + "bynd_fdys", ""));
		setDmtTrfCd(JSPUtil.getParameter(request, prefix + "dmt_trf_cd", ""));
		setTrsDeTm(JSPUtil.getParameter(request, prefix + "trs_de_tm", ""));
		setDmtFtEndDt(JSPUtil.getParameter(request, prefix + "dmt_ft_end_dt", ""));
		setTrsInvCfmDt(JSPUtil.getParameter(request, prefix + "trs_inv_cfm_dt", ""));
		setFmDt(JSPUtil.getParameter(request, prefix + "fm_dt", ""));
		setBeyondFdays(JSPUtil.getParameter(request, prefix + "beyond_fdays", ""));
		setChzPayFlg(JSPUtil.getParameter(request, prefix + "chz_pay_flg", ""));
		setLocLis(JSPUtil.getParameter(request, prefix + "loc_lis", ""));
		setBndCd(JSPUtil.getParameter(request, prefix + "bnd_cd", ""));
		setEccCd(JSPUtil.getParameter(request, prefix + "ecc_cd", ""));
		setFmStsCd(JSPUtil.getParameter(request, prefix + "fm_sts_cd", ""));
		setDmtFmDt(JSPUtil.getParameter(request, prefix + "dmt_fm_dt", ""));
		setMvmtCd(JSPUtil.getParameter(request, prefix + "mvmt_cd", ""));
		setCsFlg(JSPUtil.getParameter(request, prefix + "cs_flg", ""));
		setFinished(JSPUtil.getParameter(request, prefix + "finished", ""));
		setChzPoolCd(JSPUtil.getParameter(request, prefix + "chz_pool_cd", ""));
		setOrgYdCd(JSPUtil.getParameter(request, prefix + "org_yd_cd", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setFinishCd(JSPUtil.getParameter(request, prefix + "finish_cd", ""));
		setDmtBilAmt(JSPUtil.getParameter(request, prefix + "dmt_bil_amt", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setLccCd(JSPUtil.getParameter(request, prefix + "lcc_cd", ""));
		setMvmtStsCd(JSPUtil.getParameter(request, prefix + "mvmt_sts_cd", ""));
		setSccCd(JSPUtil.getParameter(request, prefix + "scc_cd", ""));
		setScRfaNo(JSPUtil.getParameter(request, prefix + "sc_rfa_no", ""));
		setLtTm(JSPUtil.getParameter(request, prefix + "lt_tm", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setStayingDays(JSPUtil.getParameter(request, prefix + "staying_days", ""));
		setLtCreTp(JSPUtil.getParameter(request, prefix + "lt_cre_tp", ""));
		setPolPodNod(JSPUtil.getParameter(request, prefix + "pol_pod_nod", ""));
		setTrsInvStsCd(JSPUtil.getParameter(request, prefix + "trs_inv_sts_cd", ""));
		setShpr(JSPUtil.getParameter(request, prefix + "shpr", ""));
		setDmtFtDys(JSPUtil.getParameter(request, prefix + "dmt_ft_dys", ""));
		setTrnkVvd(JSPUtil.getParameter(request, prefix + "trnk_vvd", ""));
		setTrsWoIssUsrNm(JSPUtil.getParameter(request, prefix + "trs_wo_iss_usr_nm", ""));
		setBox(JSPUtil.getParameter(request, prefix + "box", ""));
		setAvgStayDys(JSPUtil.getParameter(request, prefix + "avg_stay_dys", ""));
		setAvgByndFdys(JSPUtil.getParameter(request, prefix + "avg_bynd_fdys", ""));
		setHdnPopYn(JSPUtil.getParameter(request, prefix + "hdn_pop_yn", ""));
		setHdnOrgYdCd(JSPUtil.getParameter(request, prefix + "hdn_org_yd_cd", ""));
		setHdnFcntrFlg(JSPUtil.getParameter(request, prefix + "hdn_fcntr_flg", ""));
		setHdnFinished(JSPUtil.getParameter(request, prefix + "hdn_finished", ""));
		setHdnFmStsCd(JSPUtil.getParameter(request, prefix + "hdn_fm_sts_cd", ""));
		setHdnLtStsCd(JSPUtil.getParameter(request, prefix + "hdn_lt_sts_cd", ""));
		setHdnCntrTpszCd(JSPUtil.getParameter(request, prefix + "hdn_cntr_tpsz_cd", ""));
		setHdnMvmtStsCd(JSPUtil.getParameter(request, prefix + "hdn_mvmt_sts_cd", ""));
		setVvdNo(JSPUtil.getParameter(request, prefix + "vvd_no", ""));
		setTrsFactNm(JSPUtil.getParameter(request, prefix + "trs_fact_nm", ""));
		setCnee(JSPUtil.getParameter(request, prefix + "cnee", ""));
		setTrsWoFmYd(JSPUtil.getParameter(request, prefix + "trs_wo_fm_yd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return LandInvMonitoringVO[]
	 */
	public LandInvMonitoringVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return LandInvMonitoringVO[]
	 */
	public LandInvMonitoringVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		LandInvMonitoringVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ntfy = (JSPUtil.getParameter(request, prefix	+ "ntfy", length));
			String[] csDt = (JSPUtil.getParameter(request, prefix	+ "cs_dt", length));
			String[] chssNo = (JSPUtil.getParameter(request, prefix	+ "chss_no", length));
			String[] chzTot = (JSPUtil.getParameter(request, prefix	+ "chz_tot", length));
			String[] cdId = (JSPUtil.getParameter(request, prefix	+ "cd_id", length));
			String[] fmTm = (JSPUtil.getParameter(request, prefix	+ "fm_tm", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] boundCd = (JSPUtil.getParameter(request, prefix	+ "bound_cd", length));
			String[] porDelNod = (JSPUtil.getParameter(request, prefix	+ "por_del_nod", length));
			String[] chzVndrNm = (JSPUtil.getParameter(request, prefix	+ "chz_vndr_nm", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] dmtChgStsCd = (JSPUtil.getParameter(request, prefix	+ "dmt_chg_sts_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] trsApptDt = (JSPUtil.getParameter(request, prefix	+ "trs_appt_dt", length));
			String[] dmtMtDt = (JSPUtil.getParameter(request, prefix	+ "dmt_mt_dt", length));
			String[] trsVndrSeq = (JSPUtil.getParameter(request, prefix	+ "trs_vndr_seq", length));
			String[] locList = (JSPUtil.getParameter(request, prefix	+ "loc_list", length));
			String[] poletdPodeta = (JSPUtil.getParameter(request, prefix	+ "poletd_podeta", length));
			String[] trsApptTm = (JSPUtil.getParameter(request, prefix	+ "trs_appt_tm", length));
			String[] chzRt = (JSPUtil.getParameter(request, prefix	+ "chz_rt", length));
			String[] rcvDelTerm = (JSPUtil.getParameter(request, prefix	+ "rcv_del_term", length));
			String[] trsDeDt = (JSPUtil.getParameter(request, prefix	+ "trs_de_dt", length));
			String[] scCustNm = (JSPUtil.getParameter(request, prefix	+ "sc_cust_nm", length));
			String[] freeDays = (JSPUtil.getParameter(request, prefix	+ "free_days", length));
			String[] dmtCurrCd = (JSPUtil.getParameter(request, prefix	+ "dmt_curr_cd", length));
			String[] trkVndrSeq = (JSPUtil.getParameter(request, prefix	+ "trk_vndr_seq", length));
			String[] dmtFmStsCd = (JSPUtil.getParameter(request, prefix	+ "dmt_fm_sts_cd", length));
			String[] dmtUcFlg = (JSPUtil.getParameter(request, prefix	+ "dmt_uc_flg", length));
			String[] chzAgmtNo = (JSPUtil.getParameter(request, prefix	+ "chz_agmt_no", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] chzExcept = (JSPUtil.getParameter(request, prefix	+ "chz_except", length));
			String[] trsVndrNm = (JSPUtil.getParameter(request, prefix	+ "trs_vndr_nm", length));
			String[] dmtToDt = (JSPUtil.getParameter(request, prefix	+ "dmt_to_dt", length));
			String[] rdCgoFlg = (JSPUtil.getParameter(request, prefix	+ "rd_cgo_flg", length));
			String[] trkVndrNm = (JSPUtil.getParameter(request, prefix	+ "trk_vndr_nm", length));
			String[] ltDt = (JSPUtil.getParameter(request, prefix	+ "lt_dt", length));
			String[] dmtBillDys = (JSPUtil.getParameter(request, prefix	+ "dmt_bill_dys", length));
			String[] fcntrFlg = (JSPUtil.getParameter(request, prefix	+ "fcntr_flg", length));
			String[] cntrDmgFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_dmg_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] stayDys = (JSPUtil.getParameter(request, prefix	+ "stay_dys", length));
			String[] srepNm = (JSPUtil.getParameter(request, prefix	+ "srep_nm", length));
			String[] ltStsCd = (JSPUtil.getParameter(request, prefix	+ "lt_sts_cd", length));
			String[] cargoType = (JSPUtil.getParameter(request, prefix	+ "cargo_type", length));
			String[] dmtToStsCd = (JSPUtil.getParameter(request, prefix	+ "dmt_to_sts_cd", length));
			String[] dmtFtCmncDt = (JSPUtil.getParameter(request, prefix	+ "dmt_ft_cmnc_dt", length));
			String[] ltYdCd = (JSPUtil.getParameter(request, prefix	+ "lt_yd_cd", length));
			String[] chzVndrSeq = (JSPUtil.getParameter(request, prefix	+ "chz_vndr_seq", length));
			String[] byndFdys = (JSPUtil.getParameter(request, prefix	+ "bynd_fdys", length));
			String[] dmtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmt_trf_cd", length));
			String[] trsDeTm = (JSPUtil.getParameter(request, prefix	+ "trs_de_tm", length));
			String[] dmtFtEndDt = (JSPUtil.getParameter(request, prefix	+ "dmt_ft_end_dt", length));
			String[] trsInvCfmDt = (JSPUtil.getParameter(request, prefix	+ "trs_inv_cfm_dt", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] beyondFdays = (JSPUtil.getParameter(request, prefix	+ "beyond_fdays", length));
			String[] chzPayFlg = (JSPUtil.getParameter(request, prefix	+ "chz_pay_flg", length));
			String[] locLis = (JSPUtil.getParameter(request, prefix	+ "loc_lis", length));
			String[] bndCd = (JSPUtil.getParameter(request, prefix	+ "bnd_cd", length));
			String[] eccCd = (JSPUtil.getParameter(request, prefix	+ "ecc_cd", length));
			String[] fmStsCd = (JSPUtil.getParameter(request, prefix	+ "fm_sts_cd", length));
			String[] dmtFmDt = (JSPUtil.getParameter(request, prefix	+ "dmt_fm_dt", length));
			String[] mvmtCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_cd", length));
			String[] csFlg = (JSPUtil.getParameter(request, prefix	+ "cs_flg", length));
			String[] finished = (JSPUtil.getParameter(request, prefix	+ "finished", length));
			String[] chzPoolCd = (JSPUtil.getParameter(request, prefix	+ "chz_pool_cd", length));
			String[] orgYdCd = (JSPUtil.getParameter(request, prefix	+ "org_yd_cd", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] finishCd = (JSPUtil.getParameter(request, prefix	+ "finish_cd", length));
			String[] dmtBilAmt = (JSPUtil.getParameter(request, prefix	+ "dmt_bil_amt", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] lccCd = (JSPUtil.getParameter(request, prefix	+ "lcc_cd", length));
			String[] mvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd", length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd", length));
			String[] scRfaNo = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_no", length));
			String[] ltTm = (JSPUtil.getParameter(request, prefix	+ "lt_tm", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] stayingDays = (JSPUtil.getParameter(request, prefix	+ "staying_days", length));
			String[] ltCreTp = (JSPUtil.getParameter(request, prefix	+ "lt_cre_tp", length));
			String[] polPodNod = (JSPUtil.getParameter(request, prefix	+ "pol_pod_nod", length));
			String[] trsInvStsCd = (JSPUtil.getParameter(request, prefix	+ "trs_inv_sts_cd", length));
			String[] shpr = (JSPUtil.getParameter(request, prefix	+ "shpr", length));
			String[] dmtFtDys = (JSPUtil.getParameter(request, prefix	+ "dmt_ft_dys", length));
			String[] trnkVvd = (JSPUtil.getParameter(request, prefix	+ "trnk_vvd", length));
			String[] trsWoIssUsrNm = (JSPUtil.getParameter(request, prefix	+ "trs_wo_iss_usr_nm", length));
			String[] box = (JSPUtil.getParameter(request, prefix + "box", length));
			String[] avgStayDys = (JSPUtil.getParameter(request, prefix + "avg_stay_dys", length));
			String[] avgByndFdys = (JSPUtil.getParameter(request, prefix + "avg_bynd_fdys", length));
			String[] hdnPopYn = (JSPUtil.getParameter(request, prefix + "hdn_pop_yn", length));
			String[] hdnOrgYdCd = (JSPUtil.getParameter(request, prefix + "hdn_org_yd_cd", length));
			String[] hdnFcntrFlg = (JSPUtil.getParameter(request, prefix + "hdn_fcntr_flg", length));
			String[] hdnFinished = (JSPUtil.getParameter(request, prefix + "hdn_finished", length));
			String[] hdnFmStsCd = (JSPUtil.getParameter(request, prefix + "hdn_fm_sts_cd", length));
			String[] hdnLtStsCd = (JSPUtil.getParameter(request, prefix + "hdn_lt_sts_cd", length));
			String[] hdnCntrTpszCd = (JSPUtil.getParameter(request, prefix + "hdn_cntr_tpsz_cd", length));
			String[] hdnMvmtStsCd = (JSPUtil.getParameter(request, prefix + "hdn_mvmt_sts_cd", length));
			String[] vvdNo = (JSPUtil.getParameter(request, prefix + "vvd_no", length));
			String[] trsFactNm = (JSPUtil.getParameter(request, prefix + "trs_fact_nm", length));
			String[] cnee = (JSPUtil.getParameter(request, prefix + "cnee", length));
			String[] trsWoFmYd = (JSPUtil.getParameter(request, prefix + "trs_wo_fm_yd", length));
			
			for (int i = 0; i < length; i++) {
				model = new LandInvMonitoringVO();
				if (ntfy[i] != null)
					model.setNtfy(ntfy[i]);
				if (csDt[i] != null)
					model.setCsDt(csDt[i]);
				if (chssNo[i] != null)
					model.setChssNo(chssNo[i]);
				if (chzTot[i] != null)
					model.setChzTot(chzTot[i]);
				if (cdId[i] != null)
					model.setCdId(cdId[i]);
				if (fmTm[i] != null)
					model.setFmTm(fmTm[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (boundCd[i] != null)
					model.setBoundCd(boundCd[i]);
				if (porDelNod[i] != null)
					model.setPorDelNod(porDelNod[i]);
				if (chzVndrNm[i] != null)
					model.setChzVndrNm(chzVndrNm[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (dmtChgStsCd[i] != null)
					model.setDmtChgStsCd(dmtChgStsCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (trsApptDt[i] != null)
					model.setTrsApptDt(trsApptDt[i]);
				if (dmtMtDt[i] != null)
					model.setDmtMtDt(dmtMtDt[i]);
				if (trsVndrSeq[i] != null)
					model.setTrsVndrSeq(trsVndrSeq[i]);
				if (locList[i] != null)
					model.setLocList(locList[i]);
				if (poletdPodeta[i] != null)
					model.setPoletdPodeta(poletdPodeta[i]);
				if (trsApptTm[i] != null)
					model.setTrsApptTm(trsApptTm[i]);
				if (chzRt[i] != null)
					model.setChzRt(chzRt[i]);
				if (rcvDelTerm[i] != null)
					model.setRcvDelTerm(rcvDelTerm[i]);
				if (trsDeDt[i] != null)
					model.setTrsDeDt(trsDeDt[i]);
				if (scCustNm[i] != null)
					model.setScCustNm(scCustNm[i]);
				if (freeDays[i] != null)
					model.setFreeDays(freeDays[i]);
				if (dmtCurrCd[i] != null)
					model.setDmtCurrCd(dmtCurrCd[i]);
				if (trkVndrSeq[i] != null)
					model.setTrkVndrSeq(trkVndrSeq[i]);
				if (dmtFmStsCd[i] != null)
					model.setDmtFmStsCd(dmtFmStsCd[i]);
				if (dmtUcFlg[i] != null)
					model.setDmtUcFlg(dmtUcFlg[i]);
				if (chzAgmtNo[i] != null)
					model.setChzAgmtNo(chzAgmtNo[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (chzExcept[i] != null)
					model.setChzExcept(chzExcept[i]);
				if (trsVndrNm[i] != null)
					model.setTrsVndrNm(trsVndrNm[i]);
				if (dmtToDt[i] != null)
					model.setDmtToDt(dmtToDt[i]);
				if (rdCgoFlg[i] != null)
					model.setRdCgoFlg(rdCgoFlg[i]);
				if (trkVndrNm[i] != null)
					model.setTrkVndrNm(trkVndrNm[i]);
				if (ltDt[i] != null)
					model.setLtDt(ltDt[i]);
				if (dmtBillDys[i] != null)
					model.setDmtBillDys(dmtBillDys[i]);
				if (fcntrFlg[i] != null)
					model.setFcntrFlg(fcntrFlg[i]);
				if (cntrDmgFlg[i] != null)
					model.setCntrDmgFlg(cntrDmgFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (stayDys[i] != null)
					model.setStayDys(stayDys[i]);
				if (srepNm[i] != null)
					model.setSrepNm(srepNm[i]);
				if (ltStsCd[i] != null)
					model.setLtStsCd(ltStsCd[i]);
				if (cargoType[i] != null)
					model.setCargoType(cargoType[i]);
				if (dmtToStsCd[i] != null)
					model.setDmtToStsCd(dmtToStsCd[i]);
				if (dmtFtCmncDt[i] != null)
					model.setDmtFtCmncDt(dmtFtCmncDt[i]);
				if (ltYdCd[i] != null)
					model.setLtYdCd(ltYdCd[i]);
				if (chzVndrSeq[i] != null)
					model.setChzVndrSeq(chzVndrSeq[i]);
				if (byndFdys[i] != null)
					model.setByndFdys(byndFdys[i]);
				if (dmtTrfCd[i] != null)
					model.setDmtTrfCd(dmtTrfCd[i]);
				if (trsDeTm[i] != null)
					model.setTrsDeTm(trsDeTm[i]);
				if (dmtFtEndDt[i] != null)
					model.setDmtFtEndDt(dmtFtEndDt[i]);
				if (trsInvCfmDt[i] != null)
					model.setTrsInvCfmDt(trsInvCfmDt[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (beyondFdays[i] != null)
					model.setBeyondFdays(beyondFdays[i]);
				if (chzPayFlg[i] != null)
					model.setChzPayFlg(chzPayFlg[i]);
				if (locLis[i] != null)
					model.setLocLis(locLis[i]);
				if (bndCd[i] != null)
					model.setBndCd(bndCd[i]);
				if (eccCd[i] != null)
					model.setEccCd(eccCd[i]);
				if (fmStsCd[i] != null)
					model.setFmStsCd(fmStsCd[i]);
				if (dmtFmDt[i] != null)
					model.setDmtFmDt(dmtFmDt[i]);
				if (mvmtCd[i] != null)
					model.setMvmtCd(mvmtCd[i]);
				if (csFlg[i] != null)
					model.setCsFlg(csFlg[i]);
				if (finished[i] != null)
					model.setFinished(finished[i]);
				if (chzPoolCd[i] != null)
					model.setChzPoolCd(chzPoolCd[i]);
				if (orgYdCd[i] != null)
					model.setOrgYdCd(orgYdCd[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (finishCd[i] != null)
					model.setFinishCd(finishCd[i]);
				if (dmtBilAmt[i] != null)
					model.setDmtBilAmt(dmtBilAmt[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (lccCd[i] != null)
					model.setLccCd(lccCd[i]);
				if (mvmtStsCd[i] != null)
					model.setMvmtStsCd(mvmtStsCd[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
				if (scRfaNo[i] != null)
					model.setScRfaNo(scRfaNo[i]);
				if (ltTm[i] != null)
					model.setLtTm(ltTm[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (stayingDays[i] != null)
					model.setStayingDays(stayingDays[i]);
				if (ltCreTp[i] != null)
					model.setLtCreTp(ltCreTp[i]);
				if (polPodNod[i] != null)
					model.setPolPodNod(polPodNod[i]);
				if (trsInvStsCd[i] != null)
					model.setTrsInvStsCd(trsInvStsCd[i]);
				if (shpr[i] != null)
					model.setShpr(shpr[i]);
				if (dmtFtDys[i] != null)
					model.setDmtFtDys(dmtFtDys[i]);
				if (trnkVvd[i] != null)
					model.setTrnkVvd(trnkVvd[i]);
				if (trsWoIssUsrNm[i] != null)
					model.setTrsWoIssUsrNm(trsWoIssUsrNm[i]);
				if (box[i] != null)
					model.setBox(box[i]);
				if (avgStayDys[i] != null)
					model.setAvgStayDys(avgStayDys[i]);
				if (avgByndFdys[i] != null)
					model.setAvgByndFdys(avgByndFdys[i]);
				if (hdnPopYn[i] != null)
					model.setHdnPopYn(hdnPopYn[i]);
				if (hdnOrgYdCd[i] != null)
					model.setHdnOrgYdCd(hdnOrgYdCd[i]);
				if (hdnFcntrFlg[i] != null)
					model.setHdnFcntrFlg(hdnFcntrFlg[i]);
				if (hdnFinished[i] != null)
					model.setHdnFinished(hdnFinished[i]);
				if (hdnFmStsCd[i] != null)
					model.setHdnFmStsCd(hdnFmStsCd[i]);
				if (hdnLtStsCd[i] != null)
					model.setHdnLtStsCd(hdnLtStsCd[i]);
				if (hdnCntrTpszCd[i] != null)
					model.setHdnCntrTpszCd(hdnCntrTpszCd[i]);
				if (hdnMvmtStsCd[i] != null)
					model.setHdnMvmtStsCd(hdnMvmtStsCd[i]);
				if (vvdNo[i] != null)
					model.setVvdNo(vvdNo[i]);
				if (trsFactNm[i] != null)
					model.setTrsFactNm(trsFactNm[i]);		
				if (cnee[i] != null)
					model.setCnee(cnee[i]);	
				if (trsWoFmYd[i] != null)
					model.setTrsWoFmYd(trsWoFmYd[i]);					
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getLandInvMonitoringVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return LandInvMonitoringVO[]
	 */
	public LandInvMonitoringVO[] getLandInvMonitoringVOs(){
		LandInvMonitoringVO[] vos = (LandInvMonitoringVO[])models.toArray(new LandInvMonitoringVO[models.size()]);
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
		this.ntfy = this.ntfy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csDt = this.csDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssNo = this.chssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chzTot = this.chzTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdId = this.cdId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmTm = this.fmTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.boundCd = this.boundCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porDelNod = this.porDelNod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chzVndrNm = this.chzVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmtChgStsCd = this.dmtChgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsApptDt = this.trsApptDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmtMtDt = this.dmtMtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsVndrSeq = this.trsVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locList = this.locList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poletdPodeta = this.poletdPodeta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsApptTm = this.trsApptTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chzRt = this.chzRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDelTerm = this.rcvDelTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsDeDt = this.trsDeDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scCustNm = this.scCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freeDays = this.freeDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmtCurrCd = this.dmtCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trkVndrSeq = this.trkVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmtFmStsCd = this.dmtFmStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmtUcFlg = this.dmtUcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chzAgmtNo = this.chzAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chzExcept = this.chzExcept .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsVndrNm = this.trsVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmtToDt = this.dmtToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCgoFlg = this.rdCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trkVndrNm = this.trkVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ltDt = this.ltDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmtBillDys = this.dmtBillDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcntrFlg = this.fcntrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDmgFlg = this.cntrDmgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDys = this.stayDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepNm = this.srepNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ltStsCd = this.ltStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoType = this.cargoType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmtToStsCd = this.dmtToStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmtFtCmncDt = this.dmtFtCmncDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ltYdCd = this.ltYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chzVndrSeq = this.chzVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.byndFdys = this.byndFdys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmtTrfCd = this.dmtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsDeTm = this.trsDeTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmtFtEndDt = this.dmtFtEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsInvCfmDt = this.trsInvCfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.beyondFdays = this.beyondFdays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chzPayFlg = this.chzPayFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locLis = this.locLis .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bndCd = this.bndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eccCd = this.eccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmStsCd = this.fmStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmtFmDt = this.dmtFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtCd = this.mvmtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csFlg = this.csFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.finished = this.finished .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chzPoolCd = this.chzPoolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd = this.orgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.finishCd = this.finishCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmtBilAmt = this.dmtBilAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lccCd = this.lccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd = this.mvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaNo = this.scRfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ltTm = this.ltTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayingDays = this.stayingDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ltCreTp = this.ltCreTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polPodNod = this.polPodNod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsInvStsCd = this.trsInvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr = this.shpr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmtFtDys = this.dmtFtDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkVvd = this.trnkVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsWoIssUsrNm = this.trsWoIssUsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.box = this.box.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgStayDys = this.avgStayDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgByndFdys = this.avgByndFdys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdnPopYn = this.hdnPopYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdnOrgYdCd = this.hdnOrgYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdnFcntrFlg = this.hdnFcntrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdnFinished = this.hdnFinished.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdnFmStsCd = this.hdnFmStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdnLtStsCd = this.hdnLtStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdnCntrTpszCd = this.hdnCntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdnMvmtStsCd = this.hdnMvmtStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdNo = this.vvdNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsFactNm = this.trsFactNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee = this.cnee.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsWoFmYd = this.trsWoFmYd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	public String getTrsFactNm() {
		return trsFactNm; 
	}

	public void setTrsFactNm(String trsFactNm) {
		this.trsFactNm = trsFactNm;
	}

	public String getCnee() {
		return cnee;
	}

	public void setCnee(String cnee) {
		this.cnee = cnee;
	}

	public String getTrsWoFmYd() {
		return trsWoFmYd;
	}

	public void setTrsWoFmYd(String trsWoFmYd) {
		this.trsWoFmYd = trsWoFmYd;
	}


}
