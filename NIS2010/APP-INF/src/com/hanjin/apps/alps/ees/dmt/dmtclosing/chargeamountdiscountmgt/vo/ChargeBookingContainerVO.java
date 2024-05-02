/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChargeBookingContainerVO.java
*@FileTitle : ChargeBookingContainerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.08
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2010.06.08 황효근 
* 1.0 Creation
* 2012.02.20 권   민 [CHM-201216115] [DMT] After-BKG-DAR Request 화면 기능 추가 및 개선
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo;

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
 * @author 황효근
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ChargeBookingContainerVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ChargeBookingContainerVO> models = new ArrayList<ChargeBookingContainerVO>();
	
	/* Column Info */
	private String xcldSunFlg = null;
	/* Column Info */
	private String xcldSatFlg = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String bzcTrfCurrCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String ftAdjFlg = null;
	/* Column Info */
	private String cntrCycNo = null;
	/* Column Info */
	private String ofcTrnsFlg = null;
	/* Column Info */
	private String aftExptDcAmt = null;
	/* Column Info */
	private String chgSeqDesc = null;
	/* Column Info */
	private String aftExptAdjSeq = null;
	/* Column Info */
	private String chgSeq = null;
	/* Column Info */
	private String cntrChgDcFlg = null;
	/* Column Info */
	private String cntrChgDcRto2 = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String bilAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fxFtOvrDys = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String dmdtChgStsCd = null;
	/* Column Info */
	private String aftExptDarNo = null;
	/* Column Info */
	private String cntrChgDcRto = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String orgBilAmt = null;
	/* Column Info */
	private String ftEndDt = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String dmdtChgLocDivCd = null;
	/* Column Info */
	private String fmMvmtYdCd = null;
	/* Column Info */
	private String allCurrCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String ofcTrnsRhqCngFlg = null;
	/* Column Info */
	private String sysAreaGrpId = null;
	/* Column Info */
	private String cntrChgDcAmt = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ftTtlDys = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String ftDys = null;
	/* Column Info */
	private String prntOfcCd = null;
	/* Column Info */
	private String allCurrNm = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String xcldHolFlg = null;
	/* Column Info */
	private String ftAddDys = null;
	/* Column Info */
	private String aftExptCntrSeq = null;
	/* Column Info */
	private String dmdtArIfCd = null;
	/* Column Info */
	private String bkgCntrQty = null;
	/* Column Info */
	private String bilAftDcAmt = null;
	/* Column Info */
	private String ofcRhqCd = null;
	/* Column Info */
	private String rqstDcAmt = null;
	/* Column Info */
	private String rqstBilAmt = null;
	/* Column Info */
	private String rqstBilAftDcAmt = null;
	/* Column Info */
	private String aproBilAmt = null;
	/* Column Info */
	private String aproDcAmt = null;
	/* Column Info */
	private String aproBilAftDcAmt = null;
	/* Column Info */
	private String rqstCurrCd = null;
	/* Column Info */
	private String aproCurrCd = null;
	/* Column Info */
	private String fmMvmtStsCd = null;
	/* Column Info */
	private String toMvmtStsCd = null;
	/* Column Info */
	private String fmMvmtDt = null;
	/* Column Info */
	private String fmMvmtDtTime = null;
	/* Column Info */
	private String toMvmtDt = null;
	/* Column Info */
	private String toMvmtDtTime = null;


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ChargeBookingContainerVO() {}

	public ChargeBookingContainerVO(String ibflag, String pagerows, String aftExptDarNo, String aftExptAdjSeq, String aftExptCntrSeq, String dmdtChgStsCd, String cntrNo, String cntrTpszCd, String ofcCd, String bkgNo, String blNo, String dmdtTrfCd, String porCd, String polCd, String podCd, String delCd, String fmMvmtYdCd, String ftDys, String fxFtOvrDys, String bzcTrfCurrCd, String aftExptDcAmt, String bilAmt, String orgBilAmt, String dmdtArIfCd, String bkgCntrQty, String chgSeqDesc, String sysAreaGrpId, String cntrCycNo, String dmdtChgLocDivCd, String chgSeq, String ftAdjFlg, String ftAddDys, String ftTtlDys, String xcldSatFlg, String xcldSunFlg, String xcldHolFlg, String cntrChgDcFlg, String currCd, String allCurrCd, String allCurrNm, String cntrChgDcAmt, String cntrChgDcRto, String cntrChgDcRto2, String ftEndDt, String ofcTrnsFlg, String ofcTrnsRhqCngFlg, String prntOfcCd, String bilAftDcAmt, String ofcRhqCd, String rqstDcAmt, String rqstBilAmt, String aproBilAmt, String aproDcAmt, String aproBilAftDcAmt, String rqstBilAftDcAmt, String aproCurrCd, String rqstCurrCd, String fmMvmtStsCd, String toMvmtStsCd, String fmMvmtDt, String fmMvmtDtTime, String toMvmtDt, String toMvmtDtTime ) {
		this.xcldSunFlg = xcldSunFlg;
		this.xcldSatFlg = xcldSatFlg;
		this.porCd = porCd;
		this.bzcTrfCurrCd = bzcTrfCurrCd;
		this.currCd = currCd;
		this.ftAdjFlg = ftAdjFlg;
		this.cntrCycNo = cntrCycNo;
		this.ofcTrnsFlg = ofcTrnsFlg;
		this.aftExptDcAmt = aftExptDcAmt;
		this.chgSeqDesc = chgSeqDesc;
		this.aftExptAdjSeq = aftExptAdjSeq;
		this.chgSeq = chgSeq;
		this.cntrChgDcFlg = cntrChgDcFlg;
		this.cntrChgDcRto2 = cntrChgDcRto2;
		this.blNo = blNo;
		this.bilAmt = bilAmt;
		this.pagerows = pagerows;
		this.fxFtOvrDys = fxFtOvrDys;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.dmdtChgStsCd = dmdtChgStsCd;
		this.aftExptDarNo = aftExptDarNo;
		this.cntrChgDcRto = cntrChgDcRto;
		this.cntrTpszCd = cntrTpszCd;
		this.orgBilAmt = orgBilAmt;
		this.ftEndDt = ftEndDt;
		this.dmdtTrfCd = dmdtTrfCd;
		this.dmdtChgLocDivCd = dmdtChgLocDivCd;
		this.fmMvmtYdCd = fmMvmtYdCd;
		this.allCurrCd = allCurrCd;
		this.delCd = delCd;
		this.ofcTrnsRhqCngFlg = ofcTrnsRhqCngFlg;
		this.sysAreaGrpId = sysAreaGrpId;
		this.cntrChgDcAmt = cntrChgDcAmt;
		this.podCd = podCd;
		this.ftTtlDys = ftTtlDys;
		this.ofcCd = ofcCd;
		this.bkgNo = bkgNo;
		this.ftDys = ftDys;
		this.prntOfcCd = prntOfcCd;
		this.allCurrNm = allCurrNm;
		this.cntrNo = cntrNo;
		this.xcldHolFlg = xcldHolFlg;
		this.ftAddDys = ftAddDys;
		this.aftExptCntrSeq = aftExptCntrSeq;
		this.dmdtArIfCd = dmdtArIfCd;
		this.bkgCntrQty = bkgCntrQty;
		this.bilAftDcAmt = bilAftDcAmt;
		this.ofcRhqCd = ofcRhqCd;
		this.rqstDcAmt = rqstDcAmt;
		this.rqstBilAmt = rqstBilAmt;
		this.aproBilAmt = aproBilAmt;
		this.aproDcAmt = aproDcAmt;
		this.aproBilAftDcAmt = aproBilAftDcAmt;
		this.rqstBilAftDcAmt = rqstBilAftDcAmt;
		this.aproCurrCd = aproCurrCd;
		this.rqstCurrCd = rqstCurrCd;
		this.fmMvmtStsCd = fmMvmtStsCd;
		this.toMvmtStsCd = toMvmtStsCd;
		this.fmMvmtDt = fmMvmtDt;
		this.fmMvmtDtTime = fmMvmtDtTime;
		this.toMvmtDt = toMvmtDt;
		this.toMvmtDtTime = toMvmtDtTime;

	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("xcld_sun_flg", getXcldSunFlg());
		this.hashColumns.put("xcld_sat_flg", getXcldSatFlg());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("bzc_trf_curr_cd", getBzcTrfCurrCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("ft_adj_flg", getFtAdjFlg());
		this.hashColumns.put("cntr_cyc_no", getCntrCycNo());
		this.hashColumns.put("ofc_trns_flg", getOfcTrnsFlg());
		this.hashColumns.put("aft_expt_dc_amt", getAftExptDcAmt());
		this.hashColumns.put("chg_seq_desc", getChgSeqDesc());
		this.hashColumns.put("aft_expt_adj_seq", getAftExptAdjSeq());
		this.hashColumns.put("chg_seq", getChgSeq());
		this.hashColumns.put("cntr_chg_dc_flg", getCntrChgDcFlg());
		this.hashColumns.put("cntr_chg_dc_rto2", getCntrChgDcRto2());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("bil_amt", getBilAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fx_ft_ovr_dys", getFxFtOvrDys());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("dmdt_chg_sts_cd", getDmdtChgStsCd());
		this.hashColumns.put("aft_expt_dar_no", getAftExptDarNo());
		this.hashColumns.put("cntr_chg_dc_rto", getCntrChgDcRto());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("org_bil_amt", getOrgBilAmt());
		this.hashColumns.put("ft_end_dt", getFtEndDt());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("dmdt_chg_loc_div_cd", getDmdtChgLocDivCd());
		this.hashColumns.put("fm_mvmt_yd_cd", getFmMvmtYdCd());
		this.hashColumns.put("all_curr_cd", getAllCurrCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("ofc_trns_rhq_cng_flg", getOfcTrnsRhqCngFlg());
		this.hashColumns.put("sys_area_grp_id", getSysAreaGrpId());
		this.hashColumns.put("cntr_chg_dc_amt", getCntrChgDcAmt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ft_ttl_dys", getFtTtlDys());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ft_dys", getFtDys());
		this.hashColumns.put("prnt_ofc_cd", getPrntOfcCd());
		this.hashColumns.put("all_curr_nm", getAllCurrNm());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("xcld_hol_flg", getXcldHolFlg());
		this.hashColumns.put("ft_add_dys", getFtAddDys());
		this.hashColumns.put("aft_expt_cntr_seq", getAftExptCntrSeq());
		this.hashColumns.put("dmdt_ar_if_cd", getDmdtArIfCd());
		this.hashColumns.put("bkg_cntr_qty", getBkgCntrQty());
		this.hashColumns.put("bil_aft_dc_amt", getBilAftDcAmt());
		this.hashColumns.put("ofc_rhq_cd", getOfcRhqCd());
		this.hashColumns.put("rqst_dc_amt", getRqstDcAmt());
		this.hashColumns.put("rqst_bil_amt", getRqstBilAmt());
		this.hashColumns.put("apro_bil_amt", getAproBilAmt());
		this.hashColumns.put("apro_dc_amt", getAproDcAmt());
		this.hashColumns.put("apro_bil_aft_dc_amt", getAproBilAftDcAmt());
		this.hashColumns.put("rqst_bil_aft_dc_amt", getRqstBilAftDcAmt());
		this.hashColumns.put("rqst_curr_cd", getRqstCurrCd());
		this.hashColumns.put("apro_curr_cd", getAproCurrCd());

		this.hashColumns.put("fm_mvmt_sts_cd", getFmMvmtStsCd());
		this.hashColumns.put("to_mvmt_sts_cd", getToMvmtStsCd());
		this.hashColumns.put("fm_mvmt_dt", getFmMvmtDt());
		this.hashColumns.put("fm_mvmt_dt_time", getFmMvmtDtTime());
		this.hashColumns.put("to_mvmt_dt", getToMvmtDt());
		this.hashColumns.put("to_mvmt_dt_time", getToMvmtDtTime());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("xcld_sun_flg", "xcldSunFlg");
		this.hashFields.put("xcld_sat_flg", "xcldSatFlg");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("bzc_trf_curr_cd", "bzcTrfCurrCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("ft_adj_flg", "ftAdjFlg");
		this.hashFields.put("cntr_cyc_no", "cntrCycNo");
		this.hashFields.put("ofc_trns_flg", "ofcTrnsFlg");
		this.hashFields.put("aft_expt_dc_amt", "aftExptDcAmt");
		this.hashFields.put("chg_seq_desc", "chgSeqDesc");
		this.hashFields.put("aft_expt_adj_seq", "aftExptAdjSeq");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("cntr_chg_dc_flg", "cntrChgDcFlg");
		this.hashFields.put("cntr_chg_dc_rto2", "cntrChgDcRto2");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("bil_amt", "bilAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fx_ft_ovr_dys", "fxFtOvrDys");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("dmdt_chg_sts_cd", "dmdtChgStsCd");
		this.hashFields.put("aft_expt_dar_no", "aftExptDarNo");
		this.hashFields.put("cntr_chg_dc_rto", "cntrChgDcRto");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("org_bil_amt", "orgBilAmt");
		this.hashFields.put("ft_end_dt", "ftEndDt");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("dmdt_chg_loc_div_cd", "dmdtChgLocDivCd");
		this.hashFields.put("fm_mvmt_yd_cd", "fmMvmtYdCd");
		this.hashFields.put("all_curr_cd", "allCurrCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("ofc_trns_rhq_cng_flg", "ofcTrnsRhqCngFlg");
		this.hashFields.put("sys_area_grp_id", "sysAreaGrpId");
		this.hashFields.put("cntr_chg_dc_amt", "cntrChgDcAmt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ft_ttl_dys", "ftTtlDys");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ft_dys", "ftDys");
		this.hashFields.put("prnt_ofc_cd", "prntOfcCd");
		this.hashFields.put("all_curr_nm", "allCurrNm");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("xcld_hol_flg", "xcldHolFlg");
		this.hashFields.put("ft_add_dys", "ftAddDys");
		this.hashFields.put("aft_expt_cntr_seq", "aftExptCntrSeq");
		this.hashFields.put("dmdt_ar_if_cd", "dmdtArIfCd");
		this.hashFields.put("bkg_cntr_qty", "bkgCntrQty");
		this.hashFields.put("bil_aft_dc_amt", "bilAftDcAmt");
		this.hashFields.put("ofc_rhq_cd", "ofcRhqCd");
		this.hashFields.put("rqst_dc_amt", "rqstDcAmt");
		this.hashFields.put("rqst_bil_amt", "rqstBilAmt");
		this.hashFields.put("apro_bil_amt", "aproBilAmt");
		this.hashFields.put("apro_dc_amt", "aproDcAmt");
		this.hashFields.put("apro_bil_aft_dc_amt", "aproBilAftDcAmt");
		this.hashFields.put("rqst_bil_aft_dc_amt", "rqstBilAftDcAmt");
		this.hashFields.put("rqst_curr_cd", "rqstCurrCd");
		this.hashFields.put("apro_curr_cd", "aproCurrCd");

		this.hashFields.put("fm_mvmt_sts_cd", "fmMvmtStsCd");
		this.hashFields.put("to_mvmt_sts_cd", "toMvmtStsCd");
		this.hashFields.put("fm_mvmt_dt", "fmMvmtDt");
		this.hashFields.put("fm_mvmt_dt_time", "fmMvmtDtTime");
		this.hashFields.put("to_mvmt_dt", "toMvmtDt");
		this.hashFields.put("to_mvmt_dt_time", "toMvmtDtTime");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return xcldSunFlg
	 */
	public String getXcldSunFlg() {
		return this.xcldSunFlg;
	}
	
	/**
	 * Column Info
	 * @return xcldSatFlg
	 */
	public String getXcldSatFlg() {
		return this.xcldSatFlg;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return bzcTrfCurrCd
	 */
	public String getBzcTrfCurrCd() {
		return this.bzcTrfCurrCd;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return ftAdjFlg
	 */
	public String getFtAdjFlg() {
		return this.ftAdjFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrCycNo
	 */
	public String getCntrCycNo() {
		return this.cntrCycNo;
	}
	
	/**
	 * Column Info
	 * @return ofcTrnsFlg
	 */
	public String getOfcTrnsFlg() {
		return this.ofcTrnsFlg;
	}
	
	/**
	 * Column Info
	 * @return aftExptDcAmt
	 */
	public String getAftExptDcAmt() {
		return this.aftExptDcAmt;
	}
	
	/**
	 * Column Info
	 * @return chgSeqDesc
	 */
	public String getChgSeqDesc() {
		return this.chgSeqDesc;
	}
	
	/**
	 * Column Info
	 * @return aftExptAdjSeq
	 */
	public String getAftExptAdjSeq() {
		return this.aftExptAdjSeq;
	}
	
	/**
	 * Column Info
	 * @return chgSeq
	 */
	public String getChgSeq() {
		return this.chgSeq;
	}
	
	/**
	 * Column Info
	 * @return cntrChgDcFlg
	 */
	public String getCntrChgDcFlg() {
		return this.cntrChgDcFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrChgDcRto2
	 */
	public String getCntrChgDcRto2() {
		return this.cntrChgDcRto2;
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
	 * @return bilAmt
	 */
	public String getBilAmt() {
		return this.bilAmt;
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
	 * @return fxFtOvrDys
	 */
	public String getFxFtOvrDys() {
		return this.fxFtOvrDys;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtChgStsCd
	 */
	public String getDmdtChgStsCd() {
		return this.dmdtChgStsCd;
	}
	
	/**
	 * Column Info
	 * @return aftExptDarNo
	 */
	public String getAftExptDarNo() {
		return this.aftExptDarNo;
	}
	
	/**
	 * Column Info
	 * @return cntrChgDcRto
	 */
	public String getCntrChgDcRto() {
		return this.cntrChgDcRto;
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
	 * @return orgBilAmt
	 */
	public String getOrgBilAmt() {
		return this.orgBilAmt;
	}
	
	/**
	 * Column Info
	 * @return ftEndDt
	 */
	public String getFtEndDt() {
		return this.ftEndDt;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return this.dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtChgLocDivCd
	 */
	public String getDmdtChgLocDivCd() {
		return this.dmdtChgLocDivCd;
	}
	
	/**
	 * Column Info
	 * @return fmMvmtYdCd
	 */
	public String getFmMvmtYdCd() {
		return this.fmMvmtYdCd;
	}
	
	/**
	 * Column Info
	 * @return allCurrCd
	 */
	public String getAllCurrCd() {
		return this.allCurrCd;
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
	 * @return ofcTrnsRhqCngFlg
	 */
	public String getOfcTrnsRhqCngFlg() {
		return this.ofcTrnsRhqCngFlg;
	}
	
	/**
	 * Column Info
	 * @return sysAreaGrpId
	 */
	public String getSysAreaGrpId() {
		return this.sysAreaGrpId;
	}
	
	/**
	 * Column Info
	 * @return cntrChgDcAmt
	 */
	public String getCntrChgDcAmt() {
		return this.cntrChgDcAmt;
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
	 * @return ftTtlDys
	 */
	public String getFtTtlDys() {
		return this.ftTtlDys;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return ftDys
	 */
	public String getFtDys() {
		return this.ftDys;
	}
	
	/**
	 * Column Info
	 * @return prntOfcCd
	 */
	public String getPrntOfcCd() {
		return this.prntOfcCd;
	}
	
	/**
	 * Column Info
	 * @return allCurrNm
	 */
	public String getAllCurrNm() {
		return this.allCurrNm;
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
	 * @return xcldHolFlg
	 */
	public String getXcldHolFlg() {
		return this.xcldHolFlg;
	}
	
	/**
	 * Column Info
	 * @return ftAddDys
	 */
	public String getFtAddDys() {
		return this.ftAddDys;
	}
	
	/**
	 * Column Info
	 * @return aftExptCntrSeq
	 */
	public String getAftExptCntrSeq() {
		return this.aftExptCntrSeq;
	}
	
	/**
	 * Column Info
	 * @return dmdtArIfCd
	 */
	public String getDmdtArIfCd() {
		return this.dmdtArIfCd;
	}
	
	/**
	 * Column Info
	 * @return bkgCntrQty
	 */
	public String getBkgCntrQty() {
		return this.bkgCntrQty;
	}

	/**
	 * Column Info
	 * @return bilAftDcAmt
	 */
	public String getBilAftDcAmt() {
		return bilAftDcAmt;
	}
	
	/**
	 * Column Info
	 * @return ofcRhqCd
	 */
	public String getOfcRhqCd() {
		return ofcRhqCd;
	}
	
	public Collection<ChargeBookingContainerVO> getModels() {
		return models;
	}

	public void setModels(Collection<ChargeBookingContainerVO> models) {
		this.models = models;
	}



	public HashMap<String, String> getHashColumns() {
		return hashColumns;
	}

	public void setHashColumns(HashMap<String, String> hashColumns) {
		this.hashColumns = hashColumns;
	}

	public HashMap<String, String> getHashFields() {
		return hashFields;
	}

	public void setHashFields(HashMap<String, String> hashFields) {
		this.hashFields = hashFields;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	/**
	 * Column Info
	 * @param xcldSunFlg
	 */
	public void setXcldSunFlg(String xcldSunFlg) {
		this.xcldSunFlg = xcldSunFlg;
	}
	
	/**
	 * Column Info
	 * @param xcldSatFlg
	 */
	public void setXcldSatFlg(String xcldSatFlg) {
		this.xcldSatFlg = xcldSatFlg;
	}
	
	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param bzcTrfCurrCd
	 */
	public void setBzcTrfCurrCd(String bzcTrfCurrCd) {
		this.bzcTrfCurrCd = bzcTrfCurrCd;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param ftAdjFlg
	 */
	public void setFtAdjFlg(String ftAdjFlg) {
		this.ftAdjFlg = ftAdjFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrCycNo
	 */
	public void setCntrCycNo(String cntrCycNo) {
		this.cntrCycNo = cntrCycNo;
	}
	
	/**
	 * Column Info
	 * @param ofcTrnsFlg
	 */
	public void setOfcTrnsFlg(String ofcTrnsFlg) {
		this.ofcTrnsFlg = ofcTrnsFlg;
	}
	
	/**
	 * Column Info
	 * @param aftExptDcAmt
	 */
	public void setAftExptDcAmt(String aftExptDcAmt) {
		this.aftExptDcAmt = aftExptDcAmt;
	}
	
	/**
	 * Column Info
	 * @param chgSeqDesc
	 */
	public void setChgSeqDesc(String chgSeqDesc) {
		this.chgSeqDesc = chgSeqDesc;
	}
	
	/**
	 * Column Info
	 * @param aftExptAdjSeq
	 */
	public void setAftExptAdjSeq(String aftExptAdjSeq) {
		this.aftExptAdjSeq = aftExptAdjSeq;
	}
	
	/**
	 * Column Info
	 * @param chgSeq
	 */
	public void setChgSeq(String chgSeq) {
		this.chgSeq = chgSeq;
	}
	
	/**
	 * Column Info
	 * @param cntrChgDcFlg
	 */
	public void setCntrChgDcFlg(String cntrChgDcFlg) {
		this.cntrChgDcFlg = cntrChgDcFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrChgDcRto2
	 */
	public void setCntrChgDcRto2(String cntrChgDcRto2) {
		this.cntrChgDcRto2 = cntrChgDcRto2;
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
	 * @param bilAmt
	 */
	public void setBilAmt(String bilAmt) {
		this.bilAmt = bilAmt;
	}
	
	/**
	 * Column Info
	 * @param ofcRhqCd
	 */
	public void setOfcRhqCd(String ofcRhqCd) {
		this.ofcRhqCd = ofcRhqCd;
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
	 * @param fxFtOvrDys
	 */
	public void setFxFtOvrDys(String fxFtOvrDys) {
		this.fxFtOvrDys = fxFtOvrDys;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtChgStsCd
	 */
	public void setDmdtChgStsCd(String dmdtChgStsCd) {
		this.dmdtChgStsCd = dmdtChgStsCd;
	}
	
	/**
	 * Column Info
	 * @param aftExptDarNo
	 */
	public void setAftExptDarNo(String aftExptDarNo) {
		this.aftExptDarNo = aftExptDarNo;
	}
	
	/**
	 * Column Info
	 * @param cntrChgDcRto
	 */
	public void setCntrChgDcRto(String cntrChgDcRto) {
		this.cntrChgDcRto = cntrChgDcRto;
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
	 * @param orgBilAmt
	 */
	public void setOrgBilAmt(String orgBilAmt) {
		this.orgBilAmt = orgBilAmt;
	}
	
	/**
	 * Column Info
	 * @param ftEndDt
	 */
	public void setFtEndDt(String ftEndDt) {
		this.ftEndDt = ftEndDt;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtChgLocDivCd
	 */
	public void setDmdtChgLocDivCd(String dmdtChgLocDivCd) {
		this.dmdtChgLocDivCd = dmdtChgLocDivCd;
	}
	
	/**
	 * Column Info
	 * @param fmMvmtYdCd
	 */
	public void setFmMvmtYdCd(String fmMvmtYdCd) {
		this.fmMvmtYdCd = fmMvmtYdCd;
	}
	
	/**
	 * Column Info
	 * @param allCurrCd
	 */
	public void setAllCurrCd(String allCurrCd) {
		this.allCurrCd = allCurrCd;
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
	 * @param ofcTrnsRhqCngFlg
	 */
	public void setOfcTrnsRhqCngFlg(String ofcTrnsRhqCngFlg) {
		this.ofcTrnsRhqCngFlg = ofcTrnsRhqCngFlg;
	}
	
	/**
	 * Column Info
	 * @param sysAreaGrpId
	 */
	public void setSysAreaGrpId(String sysAreaGrpId) {
		this.sysAreaGrpId = sysAreaGrpId;
	}
	
	/**
	 * Column Info
	 * @param cntrChgDcAmt
	 */
	public void setCntrChgDcAmt(String cntrChgDcAmt) {
		this.cntrChgDcAmt = cntrChgDcAmt;
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
	 * @param ftTtlDys
	 */
	public void setFtTtlDys(String ftTtlDys) {
		this.ftTtlDys = ftTtlDys;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param ftDys
	 */
	public void setFtDys(String ftDys) {
		this.ftDys = ftDys;
	}
	
	/**
	 * Column Info
	 * @param prntOfcCd
	 */
	public void setPrntOfcCd(String prntOfcCd) {
		this.prntOfcCd = prntOfcCd;
	}
	
	/**
	 * Column Info
	 * @param allCurrNm
	 */
	public void setAllCurrNm(String allCurrNm) {
		this.allCurrNm = allCurrNm;
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
	 * @param xcldHolFlg
	 */
	public void setXcldHolFlg(String xcldHolFlg) {
		this.xcldHolFlg = xcldHolFlg;
	}
	
	/**
	 * Column Info
	 * @param ftAddDys
	 */
	public void setFtAddDys(String ftAddDys) {
		this.ftAddDys = ftAddDys;
	}
	
	/**
	 * Column Info
	 * @param aftExptCntrSeq
	 */
	public void setAftExptCntrSeq(String aftExptCntrSeq) {
		this.aftExptCntrSeq = aftExptCntrSeq;
	}
	
	/**
	 * Column Info
	 * @param dmdtArIfCd
	 */
	public void setDmdtArIfCd(String dmdtArIfCd) {
		this.dmdtArIfCd = dmdtArIfCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCntrQty
	 */
	public void setBkgCntrQty(String bkgCntrQty) {
		this.bkgCntrQty = bkgCntrQty;
	}
	
	/**
	 * Column Info
	 * @return bilAftDcAmt
	 */
	public void setBilAftDcAmt(String bilAftDcAmt) {
		this.bilAftDcAmt = bilAftDcAmt;
	}
	
	public String getRqstDcAmt() {
		return rqstDcAmt;
	}

	public void setRqstDcAmt(String rqstDcAmt) {
		this.rqstDcAmt = rqstDcAmt;
	}

	public String getRqstBilAmt() {
		return rqstBilAmt;
	}

	public void setRqstBilAmt(String rqstBilAmt) {
		this.rqstBilAmt = rqstBilAmt;
	}

	public String getAproBilAmt() {
		return aproBilAmt;
	}

	public void setAproBilAmt(String aproBilAmt) {
		this.aproBilAmt = aproBilAmt;
	}

	public String getAproDcAmt() {
		return aproDcAmt;
	}

	public void setAproDcAmt(String aproDcAmt) {
		this.aproDcAmt = aproDcAmt;
	}

	public String getAproBilAftDcAmt() {
		return aproBilAftDcAmt;
	}

	public void setAproBilAftDcAmt(String aproBilAftDcAmt) {
		this.aproBilAftDcAmt = aproBilAftDcAmt;
	}

	public String getRqstBilAftDcAmt() {
		return rqstBilAftDcAmt;
	}

	public void setRqstBilAftDcAmt(String rqstBilAftDcAmt) {
		this.rqstBilAftDcAmt = rqstBilAftDcAmt;
	}

	public String getRqstCurrCd() {
		return rqstCurrCd;
	}

	public void setRqstCurrCd(String rqstCurrCd) {
		this.rqstCurrCd = rqstCurrCd;
	}

	public String getAproCurrCd() {
		return aproCurrCd;
	}

	public void setAproCurrCd(String aproCurrCd) {
		this.aproCurrCd = aproCurrCd;
	}

	public String getFmMvmtStsCd() {
		return fmMvmtStsCd;
	}

	public void setFmMvmtStsCd(String fmMvmtStsCd) {
		this.fmMvmtStsCd = fmMvmtStsCd;
	}

	public String getToMvmtStsCd() {
		return toMvmtStsCd;
	}

	public void setToMvmtStsCd(String toMvmtStsCd) {
		this.toMvmtStsCd = toMvmtStsCd;
	}

	public String getFmMvmtDt() {
		return fmMvmtDt;
	}

	public void setFmMvmtDt(String fmMvmtDt) {
		this.fmMvmtDt = fmMvmtDt;
	}

	public String getFmMvmtDtTime() {
		return fmMvmtDtTime;
	}

	public void setFmMvmtDtTime(String fmMvmtDtTime) {
		this.fmMvmtDtTime = fmMvmtDtTime;
	}

	public String getToMvmtDt() {
		return toMvmtDt;
	}

	public void setToMvmtDt(String toMvmtDt) {
		this.toMvmtDt = toMvmtDt;
	}

	public String getToMvmtDtTime() {
		return toMvmtDtTime;
	}

	public void setToMvmtDtTime(String toMvmtDtTime) {
		this.toMvmtDtTime = toMvmtDtTime;
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
		setXcldSunFlg(JSPUtil.getParameter(request, prefix + "xcld_sun_flg", ""));
		setXcldSatFlg(JSPUtil.getParameter(request, prefix + "xcld_sat_flg", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setBzcTrfCurrCd(JSPUtil.getParameter(request, prefix + "bzc_trf_curr_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setFtAdjFlg(JSPUtil.getParameter(request, prefix + "ft_adj_flg", ""));
		setCntrCycNo(JSPUtil.getParameter(request, prefix + "cntr_cyc_no", ""));
		setOfcTrnsFlg(JSPUtil.getParameter(request, prefix + "ofc_trns_flg", ""));
		setAftExptDcAmt(JSPUtil.getParameter(request, prefix + "aft_expt_dc_amt", ""));
		setChgSeqDesc(JSPUtil.getParameter(request, prefix + "chg_seq_desc", ""));
		setAftExptAdjSeq(JSPUtil.getParameter(request, prefix + "aft_expt_adj_seq", ""));
		setChgSeq(JSPUtil.getParameter(request, prefix + "chg_seq", ""));
		setCntrChgDcFlg(JSPUtil.getParameter(request, prefix + "cntr_chg_dc_flg", ""));
		setCntrChgDcRto2(JSPUtil.getParameter(request, prefix + "cntr_chg_dc_rto2", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setBilAmt(JSPUtil.getParameter(request, prefix + "bil_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFxFtOvrDys(JSPUtil.getParameter(request, prefix + "fx_ft_ovr_dys", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setDmdtChgStsCd(JSPUtil.getParameter(request, prefix + "dmdt_chg_sts_cd", ""));
		setAftExptDarNo(JSPUtil.getParameter(request, prefix + "aft_expt_dar_no", ""));
		setCntrChgDcRto(JSPUtil.getParameter(request, prefix + "cntr_chg_dc_rto", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setOrgBilAmt(JSPUtil.getParameter(request, prefix + "org_bil_amt", ""));
		setFtEndDt(JSPUtil.getParameter(request, prefix + "ft_end_dt", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", ""));
		setDmdtChgLocDivCd(JSPUtil.getParameter(request, prefix + "dmdt_chg_loc_div_cd", ""));
		setFmMvmtYdCd(JSPUtil.getParameter(request, prefix + "fm_mvmt_yd_cd", ""));
		setAllCurrCd(JSPUtil.getParameter(request, prefix + "all_curr_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setOfcTrnsRhqCngFlg(JSPUtil.getParameter(request, prefix + "ofc_trns_rhq_cng_flg", ""));
		setSysAreaGrpId(JSPUtil.getParameter(request, prefix + "sys_area_grp_id", ""));
		setCntrChgDcAmt(JSPUtil.getParameter(request, prefix + "cntr_chg_dc_amt", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setFtTtlDys(JSPUtil.getParameter(request, prefix + "ft_ttl_dys", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setFtDys(JSPUtil.getParameter(request, prefix + "ft_dys", ""));
		setPrntOfcCd(JSPUtil.getParameter(request, prefix + "prnt_ofc_cd", ""));
		setAllCurrNm(JSPUtil.getParameter(request, prefix + "all_curr_nm", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setXcldHolFlg(JSPUtil.getParameter(request, prefix + "xcld_hol_flg", ""));
		setFtAddDys(JSPUtil.getParameter(request, prefix + "ft_add_dys", ""));
		setAftExptCntrSeq(JSPUtil.getParameter(request, prefix + "aft_expt_cntr_seq", ""));
		setDmdtArIfCd(JSPUtil.getParameter(request, prefix + "dmdt_ar_if_cd", ""));
		setBkgCntrQty(JSPUtil.getParameter(request, prefix + "bkg_cntr_qty", ""));
		setBilAftDcAmt(JSPUtil.getParameter(request, prefix + "bil_aft_dc_amt", ""));
		setOfcRhqCd(JSPUtil.getParameter(request, prefix + "ofc_rhq_cd", ""));
		setRqstDcAmt(JSPUtil.getParameter(request, prefix + "rqst_dc_amt", ""));
		setRqstBilAmt(JSPUtil.getParameter(request, prefix + "rqst_bil_amt", ""));
		setAproBilAmt(JSPUtil.getParameter(request, prefix + "apro_bil_amt", ""));
		setAproDcAmt(JSPUtil.getParameter(request, prefix + "apro_dc_amt", ""));
		setAproBilAftDcAmt(JSPUtil.getParameter(request, prefix + "apro_bil_aft_dc_amt", ""));
		setRqstBilAftDcAmt(JSPUtil.getParameter(request, prefix + "rqst_bil_aft_dc_amt", ""));
		setRqstBilAftDcAmt(JSPUtil.getParameter(request, prefix + "rqst_bil_aft_dc_amt", ""));
		setAproCurrCd(JSPUtil.getParameter(request, prefix + "apro_curr_cd", ""));
		setRqstCurrCd(JSPUtil.getParameter(request, prefix + "rqst_curr_cd", ""));

		setFmMvmtStsCd(JSPUtil.getParameter(request, prefix + "fm_mvmt_sts_cd", ""));
		setToMvmtStsCd(JSPUtil.getParameter(request, prefix + "rqst_curr_cd", ""));
		setFmMvmtDt(JSPUtil.getParameter(request, prefix + "fm_mvmt_dt", ""));
		setFmMvmtDtTime(JSPUtil.getParameter(request, prefix + "fm_mvmt_dt_time", ""));
		setToMvmtDt(JSPUtil.getParameter(request, prefix + "to_mvmt_dt", ""));
		setToMvmtDtTime(JSPUtil.getParameter(request, prefix + "to_mvmt_dt_time", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChargeBookingContainerVO[]
	 */
	public ChargeBookingContainerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChargeBookingContainerVO[]
	 */
	public ChargeBookingContainerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChargeBookingContainerVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] xcldSunFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_sun_flg", length));
			String[] xcldSatFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_sat_flg", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] bzcTrfCurrCd = (JSPUtil.getParameter(request, prefix	+ "bzc_trf_curr_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] ftAdjFlg = (JSPUtil.getParameter(request, prefix	+ "ft_adj_flg", length));
			String[] cntrCycNo = (JSPUtil.getParameter(request, prefix	+ "cntr_cyc_no", length));
			String[] ofcTrnsFlg = (JSPUtil.getParameter(request, prefix	+ "ofc_trns_flg", length));
			String[] aftExptDcAmt = (JSPUtil.getParameter(request, prefix	+ "aft_expt_dc_amt", length));
			String[] chgSeqDesc = (JSPUtil.getParameter(request, prefix	+ "chg_seq_desc", length));
			String[] aftExptAdjSeq = (JSPUtil.getParameter(request, prefix	+ "aft_expt_adj_seq", length));
			String[] chgSeq = (JSPUtil.getParameter(request, prefix	+ "chg_seq", length));
			String[] cntrChgDcFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_chg_dc_flg", length));
			String[] cntrChgDcRto2 = (JSPUtil.getParameter(request, prefix	+ "cntr_chg_dc_rto2", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] bilAmt = (JSPUtil.getParameter(request, prefix	+ "bil_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fxFtOvrDys = (JSPUtil.getParameter(request, prefix	+ "fx_ft_ovr_dys", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] dmdtChgStsCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_sts_cd", length));
			String[] aftExptDarNo = (JSPUtil.getParameter(request, prefix	+ "aft_expt_dar_no", length));
			String[] cntrChgDcRto = (JSPUtil.getParameter(request, prefix	+ "cntr_chg_dc_rto", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] orgBilAmt = (JSPUtil.getParameter(request, prefix	+ "org_bil_amt", length));
			String[] ftEndDt = (JSPUtil.getParameter(request, prefix	+ "ft_end_dt", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] dmdtChgLocDivCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_loc_div_cd", length));
			String[] fmMvmtYdCd = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_yd_cd", length));
			String[] allCurrCd = (JSPUtil.getParameter(request, prefix	+ "all_curr_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] ofcTrnsRhqCngFlg = (JSPUtil.getParameter(request, prefix	+ "ofc_trns_rhq_cng_flg", length));
			String[] sysAreaGrpId = (JSPUtil.getParameter(request, prefix	+ "sys_area_grp_id", length));
			String[] cntrChgDcAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_chg_dc_amt", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ftTtlDys = (JSPUtil.getParameter(request, prefix	+ "ft_ttl_dys", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ftDys = (JSPUtil.getParameter(request, prefix	+ "ft_dys", length));
			String[] prntOfcCd = (JSPUtil.getParameter(request, prefix	+ "prnt_ofc_cd", length));
			String[] allCurrNm = (JSPUtil.getParameter(request, prefix	+ "all_curr_nm", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] xcldHolFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_hol_flg", length));
			String[] ftAddDys = (JSPUtil.getParameter(request, prefix	+ "ft_add_dys", length));
			String[] aftExptCntrSeq = (JSPUtil.getParameter(request, prefix	+ "aft_expt_cntr_seq", length));
			String[] dmdtArIfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_ar_if_cd", length));
			String[] bkgCntrQty = (JSPUtil.getParameter(request, prefix	+ "bkg_cntr_qty", length));
			String[] bilAftDcAmt = (JSPUtil.getParameter(request, prefix	+ "bil_aft_dc_amt", length));
			String[] ofcRhqCd = (JSPUtil.getParameter(request, prefix	+ "ofc_rhq_cd", length));
			String[] rqstDcAmt = (JSPUtil.getParameter(request, prefix	+ "rqst_dc_amt", length));
			String[] rqstBilAmt = (JSPUtil.getParameter(request, prefix	+ "rqst_bil_amt", length));
			String[] aproBilAmt = (JSPUtil.getParameter(request, prefix	+ "apro_bil_amt", length));
			String[] aproDcAmt = (JSPUtil.getParameter(request, prefix	+ "apro_dc_amt", length));
			String[] aproBilAftDcAmt = (JSPUtil.getParameter(request, prefix	+ "apro_bil_aft_dc_amt", length));
			String[] rqstBilAftDcAmt = (JSPUtil.getParameter(request, prefix	+ "rqst_bil_aft_dc_amt", length));
			String[] rqstCurrCd = (JSPUtil.getParameter(request, prefix	+ "rqst_curr_cd", length));
			String[] aproCurrCd = (JSPUtil.getParameter(request, prefix	+ "apro_curr_cd", length));
			
			String[] fmMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_sts_cd", length));
			String[] toMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_sts_cd", length));
			String[] fmMvmtDt = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_dt", length));
			String[] fmMvmtDtTime = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_dt_time", length));
			String[] toMvmtDt = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_dt", length));
			String[] toMvmtDtTime = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_dt_time", length));
			
			for (int i = 0; i < length; i++) {
				model = new ChargeBookingContainerVO();
				if (xcldSunFlg[i] != null)
					model.setXcldSunFlg(xcldSunFlg[i]);
				if (xcldSatFlg[i] != null)
					model.setXcldSatFlg(xcldSatFlg[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (bzcTrfCurrCd[i] != null)
					model.setBzcTrfCurrCd(bzcTrfCurrCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (ftAdjFlg[i] != null)
					model.setFtAdjFlg(ftAdjFlg[i]);
				if (cntrCycNo[i] != null)
					model.setCntrCycNo(cntrCycNo[i]);
				if (ofcTrnsFlg[i] != null)
					model.setOfcTrnsFlg(ofcTrnsFlg[i]);
				if (aftExptDcAmt[i] != null)
					model.setAftExptDcAmt(aftExptDcAmt[i]);
				if (chgSeqDesc[i] != null)
					model.setChgSeqDesc(chgSeqDesc[i]);
				if (aftExptAdjSeq[i] != null)
					model.setAftExptAdjSeq(aftExptAdjSeq[i]);
				if (chgSeq[i] != null)
					model.setChgSeq(chgSeq[i]);
				if (cntrChgDcFlg[i] != null)
					model.setCntrChgDcFlg(cntrChgDcFlg[i]);
				if (cntrChgDcRto2[i] != null)
					model.setCntrChgDcRto2(cntrChgDcRto2[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (bilAmt[i] != null)
					model.setBilAmt(bilAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fxFtOvrDys[i] != null)
					model.setFxFtOvrDys(fxFtOvrDys[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (dmdtChgStsCd[i] != null)
					model.setDmdtChgStsCd(dmdtChgStsCd[i]);
				if (aftExptDarNo[i] != null)
					model.setAftExptDarNo(aftExptDarNo[i]);
				if (cntrChgDcRto[i] != null)
					model.setCntrChgDcRto(cntrChgDcRto[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (orgBilAmt[i] != null)
					model.setOrgBilAmt(orgBilAmt[i]);
				if (ftEndDt[i] != null)
					model.setFtEndDt(ftEndDt[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (dmdtChgLocDivCd[i] != null)
					model.setDmdtChgLocDivCd(dmdtChgLocDivCd[i]);
				if (fmMvmtYdCd[i] != null)
					model.setFmMvmtYdCd(fmMvmtYdCd[i]);
				if (allCurrCd[i] != null)
					model.setAllCurrCd(allCurrCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (ofcTrnsRhqCngFlg[i] != null)
					model.setOfcTrnsRhqCngFlg(ofcTrnsRhqCngFlg[i]);
				if (sysAreaGrpId[i] != null)
					model.setSysAreaGrpId(sysAreaGrpId[i]);
				if (cntrChgDcAmt[i] != null)
					model.setCntrChgDcAmt(cntrChgDcAmt[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ftTtlDys[i] != null)
					model.setFtTtlDys(ftTtlDys[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ftDys[i] != null)
					model.setFtDys(ftDys[i]);
				if (prntOfcCd[i] != null)
					model.setPrntOfcCd(prntOfcCd[i]);
				if (allCurrNm[i] != null)
					model.setAllCurrNm(allCurrNm[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (xcldHolFlg[i] != null)
					model.setXcldHolFlg(xcldHolFlg[i]);
				if (ftAddDys[i] != null)
					model.setFtAddDys(ftAddDys[i]);
				if (aftExptCntrSeq[i] != null)
					model.setAftExptCntrSeq(aftExptCntrSeq[i]);
				if (dmdtArIfCd[i] != null)
					model.setDmdtArIfCd(dmdtArIfCd[i]);
				if (bkgCntrQty[i] != null)
					model.setBkgCntrQty(bkgCntrQty[i]);
				if (bilAftDcAmt[i] != null)
					model.setBilAftDcAmt(bilAftDcAmt[i]);
				if (ofcRhqCd[i] != null)
					model.setOfcRhqCd(ofcRhqCd[i]);
				if (rqstDcAmt[i] != null)
					model.setRqstDcAmt(rqstDcAmt[i]);
				if (rqstBilAmt[i] != null)
					model.setRqstBilAmt(rqstBilAmt[i]);
				if (aproBilAmt[i] != null)
					model.setAproBilAmt(aproBilAmt[i]);
				if (aproDcAmt[i] != null)
					model.setAproDcAmt(aproDcAmt[i]);
				if (aproBilAftDcAmt[i] != null)
					model.setAproBilAftDcAmt(aproBilAftDcAmt[i]);
				if (rqstBilAftDcAmt[i] != null)
					model.setRqstBilAftDcAmt(rqstBilAftDcAmt[i]);
				if (rqstCurrCd[i] != null)
					model.setRqstCurrCd(rqstCurrCd[i]);
				if (aproCurrCd[i] != null)
					model.setAproCurrCd(aproCurrCd[i]);				

				if (fmMvmtStsCd[i] != null)
					model.setFmMvmtStsCd(fmMvmtStsCd[i]);
				if (toMvmtStsCd[i] != null)
					model.setToMvmtStsCd(toMvmtStsCd[i]);
				if (fmMvmtDt[i] != null)
					model.setFmMvmtDt(fmMvmtDt[i]);
				if (fmMvmtDtTime[i] != null)
					model.setFmMvmtDtTime(fmMvmtDtTime[i]);
				if (toMvmtDt[i] != null)
					model.setToMvmtDt(toMvmtDt[i]);
				if (toMvmtDtTime[i] != null)
					model.setToMvmtDtTime(toMvmtDtTime[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChargeBookingContainerVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChargeBookingContainerVO[]
	 */
	public ChargeBookingContainerVO[] getChargeBookingContainerVOs(){
		ChargeBookingContainerVO[] vos = (ChargeBookingContainerVO[])models.toArray(new ChargeBookingContainerVO[models.size()]);
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
		this.xcldSunFlg = this.xcldSunFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xcldSatFlg = this.xcldSatFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcTrfCurrCd = this.bzcTrfCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftAdjFlg = this.ftAdjFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCycNo = this.cntrCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTrnsFlg = this.ofcTrnsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptDcAmt = this.aftExptDcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeqDesc = this.chgSeqDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptAdjSeq = this.aftExptAdjSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq = this.chgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrChgDcFlg = this.cntrChgDcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrChgDcRto2 = this.cntrChgDcRto2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilAmt = this.bilAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fxFtOvrDys = this.fxFtOvrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgStsCd = this.dmdtChgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptDarNo = this.aftExptDarNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrChgDcRto = this.cntrChgDcRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgBilAmt = this.orgBilAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftEndDt = this.ftEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgLocDivCd = this.dmdtChgLocDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtYdCd = this.fmMvmtYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allCurrCd = this.allCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTrnsRhqCngFlg = this.ofcTrnsRhqCngFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysAreaGrpId = this.sysAreaGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrChgDcAmt = this.cntrChgDcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftTtlDys = this.ftTtlDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftDys = this.ftDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prntOfcCd = this.prntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allCurrNm = this.allCurrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xcldHolFlg = this.xcldHolFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftAddDys = this.ftAddDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptCntrSeq = this.aftExptCntrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtArIfCd = this.dmdtArIfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCntrQty = this.bkgCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilAftDcAmt = this.bilAftDcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcRhqCd = this.ofcRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDcAmt = this.rqstDcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstBilAmt = this.rqstBilAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproBilAmt = this.aproBilAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproDcAmt = this.aproDcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproBilAftDcAmt = this.aproBilAftDcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstBilAftDcAmt = this.rqstBilAftDcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstCurrCd = this.rqstCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproCurrCd = this.aproCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.fmMvmtStsCd = this.fmMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtStsCd = this.toMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtDt = this.fmMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtDtTime = this.fmMvmtDtTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtDt = this.toMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtDtTime = this.toMvmtDtTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
