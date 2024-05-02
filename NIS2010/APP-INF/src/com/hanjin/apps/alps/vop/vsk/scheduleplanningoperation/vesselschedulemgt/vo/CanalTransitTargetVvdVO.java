/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CanalTransitTargetVvdVO.java
*@FileTitle : CanalTransitTargetVvdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.06
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2010.01.06 유혁 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo;

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
 * @author 유혁 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */ 

public class CanalTransitTargetVvdVO extends AbstractValueObject { 

	private static final long serialVersionUID = 1L;
	
	private Collection<CanalTransitTargetVvdVO> models = new ArrayList<CanalTransitTargetVvdVO>();
	
	/* Column Info */
	private String startDate = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String detail = null;
	/* Column Info */
	private String vpsEtbDt = null;
	/* Column Info */
	private String bayCal = null;
	/* Column Info */
	private String bkgSts = null;
	/* Column Info */
	private String scgCarRatio = null;
	/* Column Info */
	private String scgLmtOptSpd = null;
	/* Column Info */
	private String endDate = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String bayLoc = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String clptSeq = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String scgCarTeu = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String svcProvider = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String scgLmtOptRatio = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String scgCarPortCd = null;
	/* Column Info */
	private String surcharge = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String scgLmtActRatio = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String scgCarTier = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String scgLmtActSpd = null;
	/* Column Info */
	private String bound = null;
	// 2014.09.29 Canal Transit List 고도화 
	/* Column Info */
	private String scgCarBox = null;
	/* Column Info */
	private String scgCarEstiScg = null;
	/* Column Info */
	private String scgCarDiffScg = null;
	/* Column Info */
	private String avrGrosPrd = null;
	/* Column Info */
	private String rhdQty = null;
	/* Column Info */
	private String scdRate = null;
	/* Column Info */
	private String exhRate = null;
	/* Column Info */
	private String rhdCharge = null;
	/* Column Info */
	private String svCost = null;
	/* Column Info */
	private String allowance = null;
	/* Column Info */
	private String loadTeu = null;
	/* Column Info */
	private String visiRange = null;
	/* Column Info */
	private String undAcpQty = null;
	/* Column Info */
	private String exdAcpEsti = null;
	/* Column Info */
	private String exdAcpActual = null;
	/* Column Info */
	private String crrCd = null;
	
	/* Column Info */
	private String calc = null;
	private String rhdPort = null;
	
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String cnlTzBkgPrdCd = null;
	/* Column Info */
	private String cnlPortCd = null;
	/* Column Info */
	private String cnlBkgTzDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String cnlTzBkgYrmon = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cnlTzBkgProcStsCd = null;
	/* Column Info */
	private String cnlOtSvcAproFlg = null;
	/* Column Info */
	private String svcScpBndCd = null;
	/* Column Info */
	private String startMonth = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String usrId = null;
	
	/* Column Info */
	private String cnlOtSvcArrDt = null;
	/* Column Info */
	private String cnlBkgAmt = null;
	
	
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	

	public CanalTransitTargetVvdVO() {}

	public CanalTransitTargetVvdVO(String ibflag, String pagerows, String startDate, String endDate, String portCd, String svcProvider, String surcharge, String vndrSeq, String vpsPortCd,
			String clptSeq, String ydCd, String bayLoc, String bayCal, String bound, String vvd, String vslCd, String skdVoyNo, String skdDirCd, String vslSlanCd, String vpsEtaDt, String vpsEtbDt, 
			String vpsEtdDt, String bkgSts, String scgLmtOptSpd, String scgLmtOptRatio, String scgLmtActSpd, String scgLmtActRatio, String scgCarPortCd, String scgCarRatio, String scgCarTier, 
			String scgCarTeu, String detail,String scgCarBox ,String scgCarEstiScg ,String scgCarDiffScg ,String avrGrosPrd ,String rhdQty ,String scdRate ,String exhRate ,String rhdCharge ,
			String svCost ,String allowance ,String loadTeu ,String visiRange ,String undAcpQty ,String exdAcpEsti ,String exdAcpActual,String crrCd , String calc, String rhdPort ,
			String startMonth, String cnlTzBkgYrmon, String cnlPortCd, String svcScpBndCd, String cnlTzBkgPrdCd, String cnlTzBkgProcStsCd, String cnlBkgTzDt, String cnlOtSvcAproFlg,
			String creUsrId, String creDt, String updUsrId, String updDt, String usrId, String cnlOtSvcArrDt, String cnlBkgAmt) {
		this.startDate = startDate;
		this.vslCd = vslCd;
		this.detail = detail;
		this.vpsEtbDt = vpsEtbDt;
		this.bayCal = bayCal;
		this.bkgSts = bkgSts;
		this.scgCarRatio = scgCarRatio;
		this.scgLmtOptSpd = scgLmtOptSpd;
		this.endDate = endDate;
		this.vslSlanCd = vslSlanCd;
		this.bayLoc = bayLoc;
		this.vpsEtaDt = vpsEtaDt;
		this.pagerows = pagerows;
		this.clptSeq = clptSeq;
		this.vpsPortCd = vpsPortCd;
		this.ibflag = ibflag;
		this.scgCarTeu = scgCarTeu;
		this.portCd = portCd;
		this.svcProvider = svcProvider;
		this.vpsEtdDt = vpsEtdDt;
		this.scgLmtOptRatio = scgLmtOptRatio;
		this.skdVoyNo = skdVoyNo;
		this.scgCarPortCd = scgCarPortCd;
		this.surcharge = surcharge;
		this.skdDirCd = skdDirCd;
		this.scgLmtActRatio = scgLmtActRatio;
		this.vvd = vvd;
		this.scgCarTier = scgCarTier;
		this.ydCd = ydCd;
		this.vndrSeq = vndrSeq;
		this.scgLmtActSpd = scgLmtActSpd;
		this.bound = bound;
		//2014.09.29 Canal Transit List고도화
		this.scgCarBox= scgCarBox;
		this.scgCarEstiScg= scgCarEstiScg;
		this.scgCarDiffScg= scgCarDiffScg;
		this.avrGrosPrd= avrGrosPrd;
		this.rhdQty= rhdQty;
		this.scdRate= scdRate;
		this.exhRate= exhRate;
		this.rhdCharge= rhdCharge;
		this.svCost= svCost;
		this.allowance= allowance;
		this.loadTeu= loadTeu;
		this.visiRange= visiRange;
		this.undAcpQty= undAcpQty;
		this.exdAcpEsti= exdAcpEsti;
		this.exdAcpActual= exdAcpActual;
		this.crrCd = crrCd;
		this.calc = calc;
		this.rhdPort = rhdPort;
		
		this.updDt = updDt;
		this.cnlTzBkgPrdCd = cnlTzBkgPrdCd; 
		this.cnlPortCd = cnlPortCd;
		this.cnlBkgTzDt = cnlBkgTzDt;
		this.creDt = creDt;
		this.cnlTzBkgYrmon = cnlTzBkgYrmon;
		this.creUsrId = creUsrId;
		this.cnlTzBkgProcStsCd = cnlTzBkgProcStsCd;
		this.cnlOtSvcAproFlg = cnlOtSvcAproFlg;
		this.svcScpBndCd = svcScpBndCd;
		this.startMonth = startMonth;
		this.updUsrId = updUsrId;
		this.usrId = usrId; 
		
		this.cnlOtSvcArrDt = cnlOtSvcArrDt;
		this.cnlBkgAmt = cnlBkgAmt; 

	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("start_date", getStartDate());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("detail", getDetail());
		this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
		this.hashColumns.put("bay_cal", getBayCal());
		this.hashColumns.put("bkg_sts", getBkgSts());
		this.hashColumns.put("scg_car_ratio", getScgCarRatio());
		this.hashColumns.put("scg_lmt_opt_spd", getScgLmtOptSpd());
		this.hashColumns.put("end_date", getEndDate());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("bay_loc", getBayLoc());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("clpt_seq", getClptSeq());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("scg_car_teu", getScgCarTeu());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("svc_provider", getSvcProvider());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("scg_lmt_opt_ratio", getScgLmtOptRatio());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("scg_car_port_cd", getScgCarPortCd());
		this.hashColumns.put("surcharge", getSurcharge());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("scg_lmt_act_ratio", getScgLmtActRatio());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("scg_car_tier", getScgCarTier());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("scg_lmt_act_spd", getScgLmtActSpd());
		this.hashColumns.put("bound", getBound());
		//2014.09.29 Canal Transit List 고도화
		this.hashColumns.put("scg_car_box", getScgCarBox());
		this.hashColumns.put("scg_car_esti_scg", getScgCarEstiScg());
		this.hashColumns.put("scg_car_diff_scg", getScgCarDiffScg());
		this.hashColumns.put("avr_gros_prd", getAvrGrosPrd());
		this.hashColumns.put("rhd_qty", getRhdQty());
		this.hashColumns.put("scd_rate", getScdRate());
		this.hashColumns.put("exh_rate", getExhRate());
		this.hashColumns.put("rhd_charge", getRhdCharge());
		this.hashColumns.put("sv_cost", getSvCost());
		this.hashColumns.put("allowance", getAllowance());
		this.hashColumns.put("load_teu", getLoadTeu());
		this.hashColumns.put("visi_range", getVisiRange());
		this.hashColumns.put("und_acp_qty", getUndAcpQty());
		this.hashColumns.put("exd_acp_esti", getExdAcpEsti());
		this.hashColumns.put("exd_acp_actual", getExdAcpActual());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("calc", getCalc());
		this.hashColumns.put("rhd_port", getRhdPort());
		
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cnl_tz_bkg_prd_cd", getCnlTzBkgPrdCd());
		this.hashColumns.put("cnl_port_cd", getCnlPortCd());
		this.hashColumns.put("cnl_bkg_tz_dt", getCnlBkgTzDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cnl_tz_bkg_yrmon", getCnlTzBkgYrmon());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cnl_tz_bkg_proc_sts_cd", getCnlTzBkgProcStsCd());
		this.hashColumns.put("cnl_ot_svc_apro_flg", getCnlOtSvcAproFlg());
		this.hashColumns.put("svc_scp_bnd_cd", getSvcScpBndCd());
		this.hashColumns.put("start_month", getStartMonth());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("usr_id", getUsrId());
		
		this.hashColumns.put("cnl_ot_svc_arr_dt", getCnlOtSvcArrDt());
		this.hashColumns.put("cnl_bkg_amt", getCnlBkgAmt());

		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("start_date", "startDate");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("detail", "detail");
		this.hashFields.put("vps_etb_dt", "vpsEtbDt");
		this.hashFields.put("bay_cal", "bayCal");
		this.hashFields.put("bkg_sts", "bkgSts");
		this.hashFields.put("scg_car_ratio", "scgCarRatio");
		this.hashFields.put("scg_lmt_opt_spd", "scgLmtOptSpd");
		this.hashFields.put("end_date", "endDate");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("bay_loc", "bayLoc");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("clpt_seq", "clptSeq");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("scg_car_teu", "scgCarTeu");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("svc_provider", "svcProvider");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("scg_lmt_opt_ratio", "scgLmtOptRatio");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("scg_car_port_cd", "scgCarPortCd");
		this.hashFields.put("surcharge", "surcharge");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("scg_lmt_act_ratio", "scgLmtActRatio");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("scg_car_tier", "scgCarTier");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("scg_lmt_act_spd", "scgLmtActSpd");
		this.hashFields.put("bound", "bound");
		//2014.09.29 Canal Transit List 고도화
		this.hashFields.put("scg_car_box", "scgCarBox");
		this.hashFields.put("scg_car_esti_scg", "scgCarEstiScg");
		this.hashFields.put("scg_car_diff_scg", "scgCarDiffScg");
		this.hashFields.put("avr_gros_prd", "avrGrosPrd");
		this.hashFields.put("rhd_qty", "rhdQty");
		this.hashFields.put("scd_rate", "scdRate");
		this.hashFields.put("exh_rate", "exhRate");
		this.hashFields.put("rhd_charge", "rhdCharge");
		this.hashFields.put("sv_cost", "svCost");
		this.hashFields.put("allowance", "allowance");
		this.hashFields.put("load_teu", "loadTeu");
		this.hashFields.put("visi_range", "visiRange");
		this.hashFields.put("und_acp_qty", "undAcpQty");
		this.hashFields.put("exd_acp_esti", "exdAcpEsti");
		this.hashFields.put("exd_acp_actual", "exdAcpActual");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("calc", "calc");
		this.hashFields.put("rhd_port", "rhdPort");
		 
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cnl_tz_bkg_prd_cd", "cnlTzBkgPrdCd");
		this.hashFields.put("cnl_port_cd", "cnlPortCd");
		this.hashFields.put("cnl_bkg_tz_dt", "cnlBkgTzDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cnl_tz_bkg_yrmon", "cnlTzBkgYrmon");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cnl_tz_bkg_proc_sts_cd", "cnlTzBkgProcStsCd");
		this.hashFields.put("cnl_ot_svc_apro_flg", "cnlOtSvcAproFlg");
		this.hashFields.put("svc_scp_bnd_cd", "svcScpBndCd");
		this.hashFields.put("start_month", "startMonth");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("usr_id", "usrId");
		
		this.hashFields.put("cnl_ot_svc_arr_dt", "cnlOtSvcArrDt");
		this.hashFields.put("cnl_bkg_amt", "cnlBkgAmt");


		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return startDate
	 */
	public String getStartDate() {
		return this.startDate;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return detail
	 */
	public String getDetail() {
		return this.detail;
	}
	
	/**
	 * Column Info
	 * @return vpsEtbDt
	 */
	public String getVpsEtbDt() {
		return this.vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @return bayCal
	 */
	public String getBayCal() {
		return this.bayCal;
	}
	
	/**
	 * Column Info
	 * @return bkgSts
	 */
	public String getBkgSts() {
		return this.bkgSts;
	}
	
	/**
	 * Column Info
	 * @return scgCarRatio
	 */
	public String getScgCarRatio() {
		return this.scgCarRatio;
	}
	
	/**
	 * Column Info
	 * @return scgLmtOptSpd
	 */
	public String getScgLmtOptSpd() {
		return this.scgLmtOptSpd;
	}
	
	/**
	 * Column Info
	 * @return endDate
	 */
	public String getEndDate() {
		return this.endDate;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return bayLoc
	 */
	public String getBayLoc() {
		return this.bayLoc;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
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
	 * @return clptSeq
	 */
	public String getClptSeq() {
		return this.clptSeq;
	}
	
	/**
	 * Column Info
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
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
	 * @return scgCarTeu
	 */
	public String getScgCarTeu() {
		return this.scgCarTeu;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return svcProvider
	 */
	public String getSvcProvider() {
		return this.svcProvider;
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
	 * @return scgLmtOptRatio
	 */
	public String getScgLmtOptRatio() {
		return this.scgLmtOptRatio;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return scgCarPortCd
	 */
	public String getScgCarPortCd() {
		return this.scgCarPortCd;
	}
	
	/**
	 * Column Info
	 * @return surcharge
	 */
	public String getSurcharge() {
		return this.surcharge;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return scgLmtActRatio
	 */
	public String getScgLmtActRatio() {
		return this.scgLmtActRatio;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return scgCarTier
	 */
	public String getScgCarTier() {
		return this.scgCarTier;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
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
	 * @return scgLmtActSpd
	 */
	public String getScgLmtActSpd() {
		return this.scgLmtActSpd;
	}
	
	/**
	 * Column Info
	 * @return bound
	 */
	public String getBound() {
		return this.bound;
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
	 * @return cnlTzBkgPrdCd
	 */
	public String getCnlTzBkgPrdCd() {
		return this.cnlTzBkgPrdCd;
	}
	
	/**
	 * Column Info
	 * @return cnlPortCd
	 */
	public String getCnlPortCd() {
		return this.cnlPortCd;
	}
	
	/**
	 * Column Info
	 * @return cnlBkgTzDt
	 */
	public String getCnlBkgTzDt() {
		return this.cnlBkgTzDt;
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
	 * @return cnlTzBkgYrmon
	 */
	public String getCnlTzBkgYrmon() {
		return this.cnlTzBkgYrmon;
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
	 * @return cnlTzBkgProcStsCd
	 */
	public String getCnlTzBkgProcStsCd() {
		return this.cnlTzBkgProcStsCd;
	}
	
	/**
	 * Column Info
	 * @return cnlOtSvcAproFlg
	 */
	public String getCnlOtSvcAproFlg() {
		return this.cnlOtSvcAproFlg;
	}
	
	/**
	 * Column Info
	 * @return svcScpBndCd
	 */
	public String getSvcScpBndCd() {
		return this.svcScpBndCd;
	}
	
	/**
	 * Column Info
	 * @return startMonth
	 */
	public String getStartMonth() {
		return this.startMonth;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return cnlOtSvcArrDt
	 */
	public String getCnlOtSvcArrDt() {
		return this.cnlOtSvcArrDt;
	}
	
	/**
	 * Column Info
	 * @return cnlBkgAmt
	 */
	public String getCnlBkgAmt() {
		return this.cnlBkgAmt;
	}
	
	
	/**
	 * Column Info
	 * @param startDate
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param detail
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	/**
	 * Column Info
	 * @param vpsEtbDt
	 */
	public void setVpsEtbDt(String vpsEtbDt) {
		this.vpsEtbDt = vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @param bayCal
	 */
	public void setBayCal(String bayCal) {
		this.bayCal = bayCal;
	}
	
	/**
	 * Column Info
	 * @param bkgSts
	 */
	public void setBkgSts(String bkgSts) {
		this.bkgSts = bkgSts;
	}
	
	/**
	 * Column Info
	 * @param scgCarRatio
	 */
	public void setScgCarRatio(String scgCarRatio) {
		this.scgCarRatio = scgCarRatio;
	}
	
	/**
	 * Column Info
	 * @param scgLmtOptSpd
	 */
	public void setScgLmtOptSpd(String scgLmtOptSpd) {
		this.scgLmtOptSpd = scgLmtOptSpd;
	}
	
	/**
	 * Column Info
	 * @param endDate
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param bayLoc
	 */
	public void setBayLoc(String bayLoc) {
		this.bayLoc = bayLoc;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
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
	 * @param clptSeq
	 */
	public void setClptSeq(String clptSeq) {
		this.clptSeq = clptSeq;
	}
	
	/**
	 * Column Info
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
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
	 * @param scgCarTeu
	 */
	public void setScgCarTeu(String scgCarTeu) {
		this.scgCarTeu = scgCarTeu;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param svcProvider
	 */
	public void setSvcProvider(String svcProvider) {
		this.svcProvider = svcProvider;
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
	 * @param scgLmtOptRatio
	 */
	public void setScgLmtOptRatio(String scgLmtOptRatio) {
		this.scgLmtOptRatio = scgLmtOptRatio;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param scgCarPortCd
	 */
	public void setScgCarPortCd(String scgCarPortCd) {
		this.scgCarPortCd = scgCarPortCd;
	}
	
	/**
	 * Column Info
	 * @param surcharge
	 */
	public void setSurcharge(String surcharge) {
		this.surcharge = surcharge;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param scgLmtActRatio
	 */
	public void setScgLmtActRatio(String scgLmtActRatio) {
		this.scgLmtActRatio = scgLmtActRatio;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param scgCarTier
	 */
	public void setScgCarTier(String scgCarTier) {
		this.scgCarTier = scgCarTier;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
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
	 * @param scgLmtActSpd
	 */
	public void setScgLmtActSpd(String scgLmtActSpd) {
		this.scgLmtActSpd = scgLmtActSpd;
	}
	
	/**
	 * Column Info
	 * @param bound
	 */
	public void setBound(String bound) {
		this.bound = bound;
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
	 * @param cnlTzBkgPrdCd
	 */
	public void setCnlTzBkgPrdCd(String cnlTzBkgPrdCd) {
		this.cnlTzBkgPrdCd = cnlTzBkgPrdCd;
	}
	
	/**
	 * Column Info
	 * @param cnlPortCd
	 */
	public void setCnlPortCd(String cnlPortCd) {
		this.cnlPortCd = cnlPortCd;
	}
	
	/**
	 * Column Info
	 * @param cnlBkgTzDt
	 */
	public void setCnlBkgTzDt(String cnlBkgTzDt) {
		this.cnlBkgTzDt = cnlBkgTzDt;
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
	 * @param cnlTzBkgYrmon
	 */
	public void setCnlTzBkgYrmon(String cnlTzBkgYrmon) {
		this.cnlTzBkgYrmon = cnlTzBkgYrmon;
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
	 * @param cnlTzBkgProcStsCd
	 */
	public void setCnlTzBkgProcStsCd(String cnlTzBkgProcStsCd) {
		this.cnlTzBkgProcStsCd = cnlTzBkgProcStsCd;
	}
	
	/**
	 * Column Info
	 * @param cnlOtSvcAproFlg
	 */
	public void setCnlOtSvcAproFlg(String cnlOtSvcAproFlg) {
		this.cnlOtSvcAproFlg = cnlOtSvcAproFlg;
	}
	
	/**
	 * Column Info
	 * @param svcScpBndCd
	 */
	public void setSvcScpBndCd(String svcScpBndCd) {
		this.svcScpBndCd = svcScpBndCd;
	}
	
	/**
	 * Column Info
	 * @param startMonth
	 */
	public void setStartMonth(String startMonth) {
		this.startMonth = startMonth;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param cnlOtSvcArrDt
	 */
	public void setCnlOtSvcArrDt(String cnlOtSvcArrDt) {
		this.cnlOtSvcArrDt = cnlOtSvcArrDt;
	}
	
	/**
	 * Column Info
	 * @param cnlBkgAmt
	 */
	public void setCnlBkgAmt(String cnlBkgAmt) {
		this.cnlBkgAmt = cnlBkgAmt;
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
		setStartDate(JSPUtil.getParameter(request, prefix + "start_date", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setDetail(JSPUtil.getParameter(request, prefix + "detail", ""));
		setVpsEtbDt(JSPUtil.getParameter(request, prefix + "vps_etb_dt", ""));
		setBayCal(JSPUtil.getParameter(request, prefix + "bay_cal", ""));
		setBkgSts(JSPUtil.getParameter(request, prefix + "bkg_sts", ""));
		setScgCarRatio(JSPUtil.getParameter(request, prefix + "scg_car_ratio", ""));
		setScgLmtOptSpd(JSPUtil.getParameter(request, prefix + "scg_lmt_opt_spd", ""));
		setEndDate(JSPUtil.getParameter(request, prefix + "end_date", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setBayLoc(JSPUtil.getParameter(request, prefix + "bay_loc", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setClptSeq(JSPUtil.getParameter(request, prefix + "clpt_seq", ""));
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setScgCarTeu(JSPUtil.getParameter(request, prefix + "scg_car_teu", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setSvcProvider(JSPUtil.getParameter(request, prefix + "svc_provider", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setScgLmtOptRatio(JSPUtil.getParameter(request, prefix + "scg_lmt_opt_ratio", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setScgCarPortCd(JSPUtil.getParameter(request, prefix + "scg_car_port_cd", ""));
		setSurcharge(JSPUtil.getParameter(request, prefix + "surcharge", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setScgLmtActRatio(JSPUtil.getParameter(request, prefix + "scg_lmt_act_ratio", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setScgCarTier(JSPUtil.getParameter(request, prefix + "scg_car_tier", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setScgLmtActSpd(JSPUtil.getParameter(request, prefix + "scg_lmt_act_spd", ""));
		setBound(JSPUtil.getParameter(request, prefix + "bound", ""));
		
		//2014.09.29 Canal Transit List 고도화 
		setScgCarBox(JSPUtil.getParameter(request, prefix + "scg_car_box", ""));
		setScgCarEstiScg(JSPUtil.getParameter(request, prefix + "scg_car_esti_scg", ""));
		setScgCarDiffScg(JSPUtil.getParameter(request, prefix + "scg_car_diff_scg", ""));
		setAvrGrosPrd(JSPUtil.getParameter(request, prefix + "avr_gros_prd", ""));
		setRhdQty(JSPUtil.getParameter(request, prefix + "rhd_qty", ""));
		setScdRate(JSPUtil.getParameter(request, prefix + "scd_rate", ""));
		setExhRate(JSPUtil.getParameter(request, prefix + "exh_rate", ""));
		setRhdCharge(JSPUtil.getParameter(request, prefix + "rhd_charge", ""));
		setSvCost(JSPUtil.getParameter(request, prefix + "sv_cost", ""));
		setAllowance(JSPUtil.getParameter(request, prefix + "allowance", ""));
		setLoadTeu(JSPUtil.getParameter(request, prefix + "load_teu", ""));
		setVisiRange(JSPUtil.getParameter(request, prefix + "visi_range", ""));
		setUndAcpQty(JSPUtil.getParameter(request, prefix + "und_acp_qty", ""));
		setExdAcpEsti(JSPUtil.getParameter(request, prefix + "exd_acp_esti", ""));
		setExdAcpActual(JSPUtil.getParameter(request, prefix + "exd_acp_actual", ""));
		setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
		setCalc(JSPUtil.getParameter(request, prefix + "calc", ""));
			
		setRhdPort(JSPUtil.getParameter(request, prefix + "rhd_port", ""));
		
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCnlTzBkgPrdCd(JSPUtil.getParameter(request, prefix + "cnl_tz_bkg_prd_cd", ""));
		setCnlPortCd(JSPUtil.getParameter(request, prefix + "cnl_port_cd", ""));
		setCnlBkgTzDt(JSPUtil.getParameter(request, prefix + "cnl_bkg_tz_dt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCnlTzBkgYrmon(JSPUtil.getParameter(request, prefix + "cnl_tz_bkg_yrmon", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCnlTzBkgProcStsCd(JSPUtil.getParameter(request, prefix + "cnl_tz_bkg_proc_sts_cd", ""));
		setCnlOtSvcAproFlg(JSPUtil.getParameter(request, prefix + "cnl_ot_svc_apro_flg", ""));
		setSvcScpBndCd(JSPUtil.getParameter(request, prefix + "svc_scp_bnd_cd", ""));
		setStartMonth(JSPUtil.getParameter(request, prefix + "start_month", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));

		setCnlOtSvcArrDt(JSPUtil.getParameter(request, prefix + "cnl_ot_svc_arr_dt", ""));
		setCnlBkgAmt(JSPUtil.getParameter(request, prefix + "cnl_bkg_amt", ""));

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CanalTransitTargetVvdVO[]
	 */
	public CanalTransitTargetVvdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CanalTransitTargetVvdVO[]
	 */
	public CanalTransitTargetVvdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CanalTransitTargetVvdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] startDate = (JSPUtil.getParameter(request, prefix	+ "start_date", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] detail = (JSPUtil.getParameter(request, prefix	+ "detail", length));
			String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt", length));
			String[] bayCal = (JSPUtil.getParameter(request, prefix	+ "bay_cal", length));
			String[] bkgSts = (JSPUtil.getParameter(request, prefix	+ "bkg_sts", length));
			String[] scgCarRatio = (JSPUtil.getParameter(request, prefix	+ "scg_car_ratio", length));
			String[] scgLmtOptSpd = (JSPUtil.getParameter(request, prefix	+ "scg_lmt_opt_spd", length));
			String[] endDate = (JSPUtil.getParameter(request, prefix	+ "end_date", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] bayLoc = (JSPUtil.getParameter(request, prefix	+ "bay_loc", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] clptSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_seq", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] scgCarTeu = (JSPUtil.getParameter(request, prefix	+ "scg_car_teu", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] svcProvider = (JSPUtil.getParameter(request, prefix	+ "svc_provider", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] scgLmtOptRatio = (JSPUtil.getParameter(request, prefix	+ "scg_lmt_opt_ratio", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] scgCarPortCd = (JSPUtil.getParameter(request, prefix	+ "scg_car_port_cd", length));
			String[] surcharge = (JSPUtil.getParameter(request, prefix	+ "surcharge", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] scgLmtActRatio = (JSPUtil.getParameter(request, prefix	+ "scg_lmt_act_ratio", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] scgCarTier = (JSPUtil.getParameter(request, prefix	+ "scg_car_tier", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] scgLmtActSpd = (JSPUtil.getParameter(request, prefix	+ "scg_lmt_act_spd", length));
			String[] bound = (JSPUtil.getParameter(request, prefix	+ "bound", length));
			
			String[] scgCarBox  = (JSPUtil.getParameter(request, prefix + "scg_car_box", length));
			String[] scgCarEstiScg  = (JSPUtil.getParameter(request, prefix + "scg_car_esti_scg", length));
			String[] scgCarDiffScg  = (JSPUtil.getParameter(request, prefix + "scg_car_diff_scg", length));
			String[] avrGrosPrd  = (JSPUtil.getParameter(request, prefix + "avr_gros_prd", length));
			String[] rhdQty  = (JSPUtil.getParameter(request, prefix + "rhd_qty", length));
			String[] scdRate  = (JSPUtil.getParameter(request, prefix + "scd_rate", length));
			String[] exhRate  = (JSPUtil.getParameter(request, prefix + "exh_rate", length));
			String[] rhdCharge  = (JSPUtil.getParameter(request, prefix + "rhd_charge", length));
			String[] svCost  = (JSPUtil.getParameter(request, prefix + "sv_cost", length));
			String[] allowance  = (JSPUtil.getParameter(request, prefix + "allowance", length));
			String[] loadTeu  = (JSPUtil.getParameter(request, prefix + "load_teu", length));
			String[] visiRange  = (JSPUtil.getParameter(request, prefix + "visi_range", length));
			String[] undAcpQty  = (JSPUtil.getParameter(request, prefix + "und_acp_qty", length));
			String[] exdAcpEsti  = (JSPUtil.getParameter(request, prefix + "exd_acp_esti", length));
			String[] exdAcpActual  = (JSPUtil.getParameter(request, prefix + "exd_acp_actual", length));
			String[] crrCd  = (JSPUtil.getParameter(request, prefix + "crr_cd", length));
			String[] calc  = (JSPUtil.getParameter(request, prefix + "calc", length));
			String[] rhdPort  = (JSPUtil.getParameter(request, prefix + "rhd_port", length));
			
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] cnlTzBkgPrdCd = (JSPUtil.getParameter(request, prefix	+ "cnl_tz_bkg_prd_cd", length));
			String[] cnlPortCd = (JSPUtil.getParameter(request, prefix	+ "cnl_port_cd", length));
			String[] cnlBkgTzDt = (JSPUtil.getParameter(request, prefix	+ "cnl_bkg_tz_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] cnlTzBkgYrmon = (JSPUtil.getParameter(request, prefix	+ "cnl_tz_bkg_yrmon", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cnlTzBkgProcStsCd = (JSPUtil.getParameter(request, prefix	+ "cnl_tz_bkg_proc_sts_cd", length));
			String[] cnlOtSvcAproFlg = (JSPUtil.getParameter(request, prefix	+ "cnl_ot_svc_apro_flg", length));
			String[] svcScpBndCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_bnd_cd", length));
			String[] startMonth = (JSPUtil.getParameter(request, prefix	+ "start_month", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));

			String[] cnlOtSvcArrDt = (JSPUtil.getParameter(request, prefix	+ "cnl_ot_svc_arr_dt", length));
			String[] cnlBkgAmt = (JSPUtil.getParameter(request, prefix	+ "cnl_bkg_amt", length));
			
			
			for (int i = 0; i < length; i++) {
				model = new CanalTransitTargetVvdVO();
				if (startDate[i] != null)
					model.setStartDate(startDate[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (detail[i] != null)
					model.setDetail(detail[i]);
				if (vpsEtbDt[i] != null)
					model.setVpsEtbDt(vpsEtbDt[i]);
				if (bayCal[i] != null)
					model.setBayCal(bayCal[i]);
				if (bkgSts[i] != null)
					model.setBkgSts(bkgSts[i]);
				if (scgCarRatio[i] != null)
					model.setScgCarRatio(scgCarRatio[i]);
				if (scgLmtOptSpd[i] != null)
					model.setScgLmtOptSpd(scgLmtOptSpd[i]);
				if (endDate[i] != null)
					model.setEndDate(endDate[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (bayLoc[i] != null)
					model.setBayLoc(bayLoc[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (clptSeq[i] != null)
					model.setClptSeq(clptSeq[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (scgCarTeu[i] != null)
					model.setScgCarTeu(scgCarTeu[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (svcProvider[i] != null)
					model.setSvcProvider(svcProvider[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (scgLmtOptRatio[i] != null)
					model.setScgLmtOptRatio(scgLmtOptRatio[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (scgCarPortCd[i] != null)
					model.setScgCarPortCd(scgCarPortCd[i]);
				if (surcharge[i] != null)
					model.setSurcharge(surcharge[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (scgLmtActRatio[i] != null)
					model.setScgLmtActRatio(scgLmtActRatio[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (scgCarTier[i] != null)
					model.setScgCarTier(scgCarTier[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (scgLmtActSpd[i] != null)
					model.setScgLmtActSpd(scgLmtActSpd[i]);
				if (bound[i] != null)
					model.setBound(bound[i]);
				if (scgCarBox[i] != null)
					model.setScgCarBox(scgCarBox[i]);
				if (scgCarEstiScg[i] != null)
					model.setScgCarEstiScg(scgCarEstiScg[i]);
				if (scgCarDiffScg[i] != null)
					model.setScgCarDiffScg(scgCarDiffScg[i]);
				if (avrGrosPrd[i] != null)
					model.setAvrGrosPrd(avrGrosPrd[i]);
				if (rhdQty[i] != null)
					model.setRhdQty(rhdQty[i]);
				if (scdRate[i] != null)
					model.setScdRate(scdRate[i]);
				if (exhRate[i] != null)
					model.setExhRate(exhRate[i]);
				if (rhdCharge[i] != null)
					model.setRhdCharge(rhdCharge[i]);
				if (svCost[i] != null)
					model.setSvCost(svCost[i]);
				if (allowance[i] != null)
					model.setAllowance(allowance[i]);
				if (loadTeu[i] != null)
					model.setLoadTeu(loadTeu[i]);
				if (visiRange[i] != null)
					model.setVisiRange(visiRange[i]);
				if (undAcpQty[i] != null)
					model.setUndAcpQty(undAcpQty[i]);
				if (exdAcpEsti[i] != null)
					model.setExdAcpEsti(exdAcpEsti[i]);
				if (exdAcpActual[i] != null)
					model.setExdAcpActual(exdAcpActual[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (calc[i] != null)
					model.setCalc(calc[i]);
				if (rhdPort[i] != null)
					model.setRhdPort(rhdPort[i]);
				
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (cnlTzBkgPrdCd[i] != null)
					model.setCnlTzBkgPrdCd(cnlTzBkgPrdCd[i]);
				if (cnlPortCd[i] != null)
					model.setCnlPortCd(cnlPortCd[i]);
				if (cnlBkgTzDt[i] != null)
					model.setCnlBkgTzDt(cnlBkgTzDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (cnlTzBkgYrmon[i] != null)
					model.setCnlTzBkgYrmon(cnlTzBkgYrmon[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cnlTzBkgProcStsCd[i] != null)
					model.setCnlTzBkgProcStsCd(cnlTzBkgProcStsCd[i]);
				if (cnlOtSvcAproFlg[i] != null)
					model.setCnlOtSvcAproFlg(cnlOtSvcAproFlg[i]);
				if (svcScpBndCd[i] != null)
					model.setSvcScpBndCd(svcScpBndCd[i]);
				if (startMonth[i] != null)
					model.setStartMonth(startMonth[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (cnlOtSvcArrDt[i] != null)
					model.setCnlOtSvcArrDt(cnlOtSvcArrDt[i]);
				if (cnlBkgAmt[i] != null)
					model.setCnlBkgAmt(cnlBkgAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCanalTransitTargetVvdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CanalTransitTargetVvdVO[]
	 */
	public CanalTransitTargetVvdVO[] getCanalTransitTargetVvdVOs(){
		CanalTransitTargetVvdVO[] vos = (CanalTransitTargetVvdVO[])models.toArray(new CanalTransitTargetVvdVO[models.size()]);
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
		this.startDate = this.startDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detail = this.detail .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtbDt = this.vpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bayCal = this.bayCal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSts = this.bkgSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgCarRatio = this.scgCarRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgLmtOptSpd = this.scgLmtOptSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endDate = this.endDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bayLoc = this.bayLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptSeq = this.clptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgCarTeu = this.scgCarTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcProvider = this.svcProvider .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgLmtOptRatio = this.scgLmtOptRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgCarPortCd = this.scgCarPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.surcharge = this.surcharge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgLmtActRatio = this.scgLmtActRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgCarTier = this.scgCarTier .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgLmtActSpd = this.scgLmtActSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bound = this.bound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgCarBox = this.scgCarBox .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgCarEstiScg = this.scgCarEstiScg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgCarDiffScg = this.scgCarDiffScg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avrGrosPrd = this.avrGrosPrd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhdQty = this.rhdQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scdRate = this.scdRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exhRate = this.exhRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhdCharge = this.rhdCharge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svCost = this.svCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allowance = this.allowance .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loadTeu = this.loadTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.visiRange = this.visiRange .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.undAcpQty = this.undAcpQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exdAcpEsti = this.exdAcpEsti .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exdAcpActual = this.exdAcpActual .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calc = this.calc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhdPort = this.rhdPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnlTzBkgPrdCd = this.cnlTzBkgPrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnlPortCd = this.cnlPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnlBkgTzDt = this.cnlBkgTzDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnlTzBkgYrmon = this.cnlTzBkgYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnlTzBkgProcStsCd = this.cnlTzBkgProcStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnlOtSvcAproFlg = this.cnlOtSvcAproFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpBndCd = this.svcScpBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.startMonth = this.startMonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.cnlOtSvcArrDt = this.cnlOtSvcArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnlBkgAmt = this.cnlBkgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		
	}

	/**
	 * @return the scgCarBox
	 */
	public String getScgCarBox() {
		return scgCarBox;
	}

	/**
	 * @param scgCarBox the scgCarBox to set
	 */
	public void setScgCarBox(String scgCarBox) {
		this.scgCarBox = scgCarBox;
	}

	/**
	 * @return the scgCarEstiScg
	 */
	public String getScgCarEstiScg() {
		return scgCarEstiScg;
	}

	/**
	 * @param scgCarEstiScg the scgCarEstiScg to set
	 */
	public void setScgCarEstiScg(String scgCarEstiScg) {
		this.scgCarEstiScg = scgCarEstiScg;
	}

	/**
	 * @return the scgCarDiffScg
	 */
	public String getScgCarDiffScg() {
		return scgCarDiffScg;
	}

	/**
	 * @param scgCarDiffScg the scgCarDiffScg to set
	 */
	public void setScgCarDiffScg(String scgCarDiffScg) {
		this.scgCarDiffScg = scgCarDiffScg;
	}

	/**
	 * @return the avrGrosPrd
	 */
	public String getAvrGrosPrd() {
		return avrGrosPrd;
	}

	/**
	 * @param avrGrosPrd the avrGrosPrd to set
	 */
	public void setAvrGrosPrd(String avrGrosPrd) {
		this.avrGrosPrd = avrGrosPrd;
	}

	/**
	 * @return the rhdQty
	 */
	public String getRhdQty() {
		return rhdQty;
	}

	/**
	 * @param rhdQty the rhdQty to set
	 */
	public void setRhdQty(String rhdQty) {
		this.rhdQty = rhdQty;
	}

	/**
	 * @return the scdRate
	 */
	public String getScdRate() {
		return scdRate;
	}

	/**
	 * @param scdRate the scdRate to set
	 */
	public void setScdRate(String scdRate) {
		this.scdRate = scdRate;
	}

	/**
	 * @return the exhRate
	 */
	public String getExhRate() {
		return exhRate;
	}

	/**
	 * @param exhRate the exhRate to set
	 */
	public void setExhRate(String exhRate) {
		this.exhRate = exhRate;
	}

	/**
	 * @return the rhdCharge
	 */
	public String getRhdCharge() {
		return rhdCharge;
	}

	/**
	 * @param rhdCharge the rhdCharge to set
	 */
	public void setRhdCharge(String rhdCharge) {
		this.rhdCharge = rhdCharge;
	}

	/**
	 * @return the svCost
	 */
	public String getSvCost() {
		return svCost;
	}

	/**
	 * @param svCost the svCost to set
	 */
	public void setSvCost(String svCost) {
		this.svCost = svCost;
	}

	/**
	 * @return the allowance
	 */
	public String getAllowance() {
		return allowance;
	}

	/**
	 * @param allowance the allowance to set
	 */
	public void setAllowance(String allowance) {
		this.allowance = allowance;
	}

	/**
	 * @return the loadTeu
	 */
	public String getLoadTeu() {
		return loadTeu;
	}

	/**
	 * @param loadTeu the loadTeu to set
	 */
	public void setLoadTeu(String loadTeu) {
		this.loadTeu = loadTeu;
	}

	/**
	 * @return the visiRange
	 */
	public String getVisiRange() {
		return visiRange;
	}

	/**
	 * @param visiRange the visiRange to set
	 */
	public void setVisiRange(String visiRange) {
		this.visiRange = visiRange;
	}

	/**
	 * @return the undAcpQty
	 */
	public String getUndAcpQty() {
		return undAcpQty;
	}

	/**
	 * @param undAcpQty the undAcpQty to set
	 */
	public void setUndAcpQty(String undAcpQty) {
		this.undAcpQty = undAcpQty;
	}

	/**
	 * @return the exdAcpEsti
	 */
	public String getExdAcpEsti() {
		return exdAcpEsti;
	}

	/**
	 * @param exdAcpEsti the exdAcpEsti to set
	 */
	public void setExdAcpEsti(String exdAcpEsti) {
		this.exdAcpEsti = exdAcpEsti;
	}

	/**
	 * @return the exdAcpActual
	 */
	public String getExdAcpActual() {
		return exdAcpActual;
	}

	/**
	 * @param exdAcpActual the exdAcpActual to set
	 */
	public void setExdAcpActual(String exdAcpActual) {
		this.exdAcpActual = exdAcpActual;
	}

	/**
	 * @return the crrCd
	 */
	public String getCrrCd() {
		return crrCd;
	}

	/**
	 * @param crrCd the crrCd to set
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
	}

	/**
	 * @return the calc
	 */
	public String getCalc() {
		return calc;
	}

	/**
	 * @param calc the calc to set
	 */
	public void setCalc(String calc) {
		this.calc = calc;
	}
	
	/**
	 * @return the rhdPort
	 */
	public String getRhdPort() {
		return rhdPort;
	}

	/**
	 * @param rhdPort the rhdPort to set
	 */
	public void setRhdPort(String rhdPort) {
		this.rhdPort = rhdPort;
	}
	
}
