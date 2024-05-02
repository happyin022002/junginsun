/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchBLCntrInfoList1VO.java
*@FileTitle : SearchBLCntrInfoList1VO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.13  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo;

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

public class BlCntrInfoReportInVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BlCntrInfoReportInVO> models = new ArrayList<BlCntrInfoReportInVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rdoInOut = null;
	/* Column Info */
	private String sailFromDt = null;
	/* Column Info */
	private String sailToDt = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String polYardCd = null;
	/* Column Info */
	private String arrFromDt = null;
	/* Column Info */
	private String arrToDt = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String podYardCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String rTerm = null;
	/* Column Info */
	private String dTerm = null;
	/* Column Info */
	private String blPrnFromDt = null;
	/* Column Info */
	private String blPrnToDt = null;
	/* Column Info */
	private String blSrndFromDt = null;
	/* Column Info */
	private String blSrndToDt = null;
	/* Column Info */
	private String trfCd = null;
	/* Column Info */
	private String cgoRlseStsCd = null;
	/* Column Info */
	private String crrCd = null;
	/* Column Info */
	private String oblIssUsrId = null;
	/* Column Info */
	private String blStsCd = null;
	/* Column Info */
	private String bcPorCd = null;
	/* Column Info */
	private String blTpCd = null;
	/* Column Info */
	private String bcPodCd = null;
	/* Column Info */
	private String internetBl = null;
	/* Column Info */
	private String bcVvdCd = null;
	/* Column Info */
	private String blRlseOfcCd = null;
	/* Column Info */
	private String blSrndOfcCd = null;
	/* Column Info */
	private String cptrOfcCd = null;
	/* Column Info */
	private String custTpCdS = null;
	/* Column Info */
	private String custTpCdC = null;
	/* Column Info */
	private String custTpCdN = null;
	/* Column Info */
	private String custTpCdF = null;
	/* Column Info */
	private String custTpCdA = null;
	/* Column Info */
	private String custTpCdG = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String custTpCd = null;	
	/* Column Info */
	private String orderby = null;
	/* Column Info */
	private String custGrpId = null;		//SJH.20150128.ADD

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BlCntrInfoReportInVO() {}

	public BlCntrInfoReportInVO(String rdoInOut,
								String sailFromDt,
								String sailToDt,
								String polCd,
								String polYardCd,
								String arrFromDt,
								String arrToDt,
								String podCd,
								String podYardCd,
								String vvdCd,
								String dirCd,
								String porCd,
								String delCd,
								String rTerm,
								String dTerm,
								String blPrnFromDt,
								String blPrnToDt,
								String blSrndFromDt,
								String blSrndToDt,
								String trfCd,
								String cgoRlseStsCd,
								String crrCd,
								String oblIssUsrId,
								String blStsCd,
								String bcPorCd,
								String blTpCd,
								String bcPodCd,
								String internetBl,
								String bcVvdCd,
								String blRlseOfcCd,
								String blSrndOfcCd,
								String cptrOfcCd,
								String custTpCdS,
								String custTpCdC,
								String custTpCdN,
								String custTpCdF,
								String custTpCdA,
								String custTpCdG,
								String custCntCd,
								String custSeq,
								String custNm,
								String custTpCd,
								String custGrpId,
								String orderby) {
		this.rdoInOut = rdoInOut;	 
		this.sailFromDt = sailFromDt; 
		this.sailToDt = sailToDt; 
		this.polCd = polCd; 
		this.polYardCd = polYardCd; 
		this.arrFromDt = arrFromDt; 
		this.arrToDt = arrToDt; 
		this.podCd = podCd; 
		this.podYardCd = podYardCd; 
		this.vvdCd = vvdCd; 
		this.dirCd = dirCd;
		this.porCd = porCd; 
		this.delCd = delCd; 
		this.rTerm = rTerm; 
		this.dTerm = dTerm; 
		this.blPrnFromDt = blPrnFromDt; 
		this.blPrnToDt = blPrnToDt; 
		this.blSrndFromDt = blSrndFromDt; 
		this.blSrndToDt = blSrndToDt; 
		this.trfCd = trfCd; 
		this.cgoRlseStsCd = cgoRlseStsCd; 
		this.crrCd = crrCd; 
		this.oblIssUsrId = oblIssUsrId; 
		this.blStsCd = blStsCd; 
		this.bcPorCd = bcPorCd; 
		this.blTpCd = blTpCd; 
		this.bcPodCd = bcPodCd; 
		this.internetBl = internetBl; 
		this.bcVvdCd = bcVvdCd; 
		this.blRlseOfcCd = blRlseOfcCd;
		this.blSrndOfcCd = blSrndOfcCd; 
		this.cptrOfcCd = cptrOfcCd; 
		this.custTpCdS = custTpCdS; 
		this.custTpCdC = custTpCdC; 
		this.custTpCdN = custTpCdN; 
		this.custTpCdF = custTpCdF; 
		this.custTpCdA = custTpCdA; 
		this.custTpCdG = custTpCdG; 
		this.custCntCd = custCntCd; 
		this.custSeq = custSeq; 
		this.custNm = custNm; 
		this.custTpCd = custTpCd; 
		this.custGrpId = custGrpId;
		this.orderby = orderby;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rdo_in_out", getRdoInOut());
		this.hashColumns.put("sail_from_dt", getSailFromDt());
		this.hashColumns.put("sail_to_dt", getSailToDt());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("pol_yard_cd", getPolYardCd());		
		this.hashColumns.put("arr_from_dt", getArrFromDt());
		this.hashColumns.put("arr_to_dt", getArrToDt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("pod_yard_cd", getPodYardCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("r_term", getRTerm());
		this.hashColumns.put("d_term", getDTerm());		
		this.hashColumns.put("bl_prn_from_dt", getBlPrnFromDt());
		this.hashColumns.put("bl_prn_to_dt", getBlPrnToDt());
		this.hashColumns.put("bl_srnd_from_dt", getBlSrndFromDt());
		this.hashColumns.put("bl_srnd_to_dt", getBlSrndToDt());
		this.hashColumns.put("trf_cd", getTrfCd());
		this.hashColumns.put("cgo_rlse_sts_cd", getCgoRlseStsCd());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("obl_iss_usr_id", getOblIssUsrId());
		this.hashColumns.put("bl_sts_cd", getBlStsCd());
		this.hashColumns.put("bc_por_cd", getBcPorCd());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("bc_pod_cd", getBcPodCd());
		this.hashColumns.put("internet_bl", getInternetBl());
		this.hashColumns.put("bc_vvd_cd", getBcVvdCd());		
		this.hashColumns.put("bl_rlse_ofc_cd", getBlRlseOfcCd());
		this.hashColumns.put("bl_srnd_ofc_cd", getBlSrndOfcCd());
		this.hashColumns.put("cptr_ofc_cd", getCptrOfcCd());	
		this.hashColumns.put("cust_tp_cd_s", getCustTpCdS());
		this.hashColumns.put("cust_tp_cd_c", getCustTpCdC());
		this.hashColumns.put("cust_tp_cd_n", getCustTpCdN());
		this.hashColumns.put("cust_tp_cd_f", getCustTpCdF());
		this.hashColumns.put("cust_tp_cd_a", getCustTpCdA());
		this.hashColumns.put("cust_tp_cd_g", getCustTpCdG());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());	
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("cust_tp_cd", getCustTpCd());
		this.hashColumns.put("cust_grp_id", getCustGrpId());
		this.hashColumns.put("orderby", getOrderby());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rdo_in_out", "rdoInOut");
		this.hashFields.put("sail_from_dt", "sailFromDt");
		this.hashFields.put("sail_to_dt", "sailToDt");
		this.hashFields.put("arr_from_dt", "arrFromDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("arr_to_dt", "arrToDt");
		this.hashFields.put("bl_prn_from_dt", "blPrnFromDt");
		this.hashFields.put("trf_cd", "trfCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("bl_prn_to_dt", "blPrnToDt");
		this.hashFields.put("bl_srnd_from_dt", "blSrndFromDt");
		this.hashFields.put("bl_srnd_to_dt", "blSrndToDt");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cgo_rlse_sts_cd", "cgoRlseStsCd");
		this.hashFields.put("obl_iss_usr_id", "oblIssUsrId");
		this.hashFields.put("bl_sts_cd", "blStsCd");
		this.hashFields.put("orderby_title_sql", "orderbyTitleSql");
		this.hashFields.put("bc_por_cd", "bcPorCd");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("bc_pod_cd", "bcPodCd");
		this.hashFields.put("internet_bl", "internetBl");
		this.hashFields.put("bc_vvd_cd", "bcVvdCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bl_rlse_ofc_cd", "blRlseOfcCd");
		this.hashFields.put("bl_srnd_ofc_cd", "blSrndOfcCd");
		this.hashFields.put("cptr_ofc_cd", "cptrOfcCd");
		this.hashFields.put("b_staff_id", "bStaffId");
		this.hashFields.put("caed_y", "caedY");
		this.hashFields.put("caed_n", "caedN");
		this.hashFields.put("dept_cd", "deptCd");
		this.hashFields.put("lane_cd", "laneCd");
		this.hashFields.put("rev", "rev");
		this.hashFields.put("ro_n", "roN");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("crn_no_flag", "crnNoFlag");
		this.hashFields.put("s_route_dest", "sRouteDest");
		this.hashFields.put("wgt_from", "wgtFrom");
		this.hashFields.put("sp_cargo_rb", "spCargoRb");
		this.hashFields.put("ro_y", "roY");
		this.hashFields.put("sp_cargo_rf", "spCargoRf");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("bkg_to_dt", "bkgToDt");
		this.hashFields.put("pol_local", "polLocal");
		this.hashFields.put("sp_cargo_rd", "spCargoRd");
		this.hashFields.put("c_rep_id", "cRepId");
		this.hashFields.put("ctr_rfa_no", "ctrRfaNo");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("c_ofc_cd_sub", "cOfcCdSub");
		this.hashFields.put("deli_mode", "deliMode");
		this.hashFields.put("l_ofc_cd_sub", "lOfcCdSub");
		this.hashFields.put("certi_checks", "certiChecks");
		this.hashFields.put("rd_yn", "rdYn");
		this.hashFields.put("orderby_select", "orderbySelect");
		this.hashFields.put("sp_cargo_soc", "spCargoSoc");
		this.hashFields.put("p_bkg_rpt_knd_cd", "pBkgRptKndCd");
		this.hashFields.put("fv_pol_local", "fvPolLocal");
		this.hashFields.put("fv_pod_cd", "fvPodCd");
		this.hashFields.put("pod_local", "podLocal");
		this.hashFields.put("l_rep_id", "lRepId");
		this.hashFields.put("last_orderby", "lastOrderby");
		this.hashFields.put("r_term", "rTerm");
		this.hashFields.put("certi_g", "certiG");
		this.hashFields.put("s_mode_dest", "sModeDest");
		this.hashFields.put("certi_n", "certiN");
		this.hashFields.put("fv_pol_yard_cd", "fvPolYardCd");
		this.hashFields.put("certi_y", "certiY");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("curr_page", "currPage");
		this.hashFields.put("pol_yard_cd", "polYardCd");
		this.hashFields.put("bkg_sts_cd_w", "bkgStsCdW");
		this.hashFields.put("d_term", "dTerm");
		this.hashFields.put("bkg_sts_cd_x", "bkgStsCdX");
		this.hashFields.put("so_no", "soNo");
		this.hashFields.put("sp_cargo_bb", "spCargoBb");
		this.hashFields.put("pod_yard_cd", "podYardCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("ctr_rfa_cd", "ctrRfaCd");
		this.hashFields.put("l_ofc_cd", "lOfcCd");
		this.hashFields.put("cargo_tp_f", "cargoTpF");
		this.hashFields.put("bkg_sts_cd_f", "bkgStsCdF");
		this.hashFields.put("fv_pre_pst_cd", "fvPrePstCd");
		this.hashFields.put("trunk_flag", "trunkFlag");
		this.hashFields.put("s_route_ori", "sRouteOri");
		this.hashFields.put("bkg_sts_cd_a", "bkgStsCdA");
		this.hashFields.put("sp_cargo_ak", "spCargoAk");
		this.hashFields.put("certi_c", "certiC");
		this.hashFields.put("c_ofc_cd", "cOfcCd");
		this.hashFields.put("certi_d", "certiD");
		this.hashFields.put("agent_cd", "agentCd");
		this.hashFields.put("cargo_tp_r", "cargoTpR");
		this.hashFields.put("certi_a", "certiA");
		this.hashFields.put("orderby", "orderby");
		this.hashFields.put("certi_b", "certiB");
		this.hashFields.put("cargo_tp_p", "cargoTpP");
		this.hashFields.put("non_sp_cargo", "nonSpCargo");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("fv_pod_local", "fvPodLocal");
		this.hashFields.put("bl_type_s", "blTypeS");
		this.hashFields.put("wgt_to", "wgtTo");
		this.hashFields.put("p_report_type", "pReportType");
		this.hashFields.put("aes_y", "aesY");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sp_cargo_eq", "spCargoEq");
		this.hashFields.put("cust_tp_cd", "custTpCd");
		this.hashFields.put("orderby_title", "orderbyTitle");
		this.hashFields.put("pol_ts", "polTs");
		this.hashFields.put("cust_tp_cd_s", "custTpCdS");
		this.hashFields.put("cust_tp_cd_n", "custTpCdN");
		this.hashFields.put("cust_tp_cd_f", "custTpCdF");
		this.hashFields.put("cust_tp_cd_g", "custTpCdG");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cust_tp_cd_c", "custTpCdC");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("eq_type", "eqType");
		this.hashFields.put("cust_tp_cd_a", "custTpCdA");
		this.hashFields.put("bl_type_a", "blTypeA");
		this.hashFields.put("aes_n", "aesN");
		this.hashFields.put("bkg_from_dt", "bkgFromDt");
		this.hashFields.put("sp_cargo_dg", "spCargoDg");
		this.hashFields.put("cust_grp_id", "custGrpId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rdoInOut
	 */
	public String getRdoInOut() {
		return this.rdoInOut;
	}
	
	/**
	 * Column Info
	 * @return sailFromDt
	 */
	public String getSailFromDt() {
		return this.sailFromDt;
	}
	
	/**
	 * Column Info
	 * @return sailToDt
	 */
	public String getSailToDt() {
		return this.sailToDt;
	}
	
	/**
	 * Column Info
	 * @return arrFromDt
	 */
	public String getArrFromDt() {
		return this.arrFromDt;
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
	 * @return arrToDt
	 */
	public String getArrToDt() {
		return this.arrToDt;
	}
	
	/**
	 * Column Info
	 * @return blPrnFromDt
	 */
	public String getBlPrnFromDt() {
		return this.blPrnFromDt;
	}
	
	/**
	 * Column Info
	 * @return trfCd
	 */
	public String getTrfCd() {
		return this.trfCd;
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
	 * @return blPrnToDt
	 */
	public String getBlPrnToDt() {
		return this.blPrnToDt;
	}
	
	/**
	 * Column Info
	 * @return blSrndFromDt
	 */
	public String getBlSrndFromDt() {
		return this.blSrndFromDt;
	}
	
	/**
	 * Column Info
	 * @return blSrndToDt
	 */
	public String getBlSrndToDt() {
		return this.blSrndToDt;
	}
	
	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return cgoRlseStsCd
	 */
	public String getCgoRlseStsCd() {
		return this.cgoRlseStsCd;
	}
	
	/**
	 * Column Info
	 * @return oblIssUsrId
	 */
	public String getOblIssUsrId() {
		return this.oblIssUsrId;
	}
	
	/**
	 * Column Info
	 * @return blStsCd
	 */
	public String getBlStsCd() {
		return this.blStsCd;
	}
	
	/**
	 * Column Info
	 * @return bcPorCd
	 */
	public String getBcPorCd() {
		return this.bcPorCd;
	}
	
	/**
	 * Column Info
	 * @return blTpCd
	 */
	public String getBlTpCd() {
		return this.blTpCd;
	}
	
	/**
	 * Column Info
	 * @return bcPodCd
	 */
	public String getBcPodCd() {
		return this.bcPodCd;
	}
	
	/**
	 * Column Info
	 * @return internetBl
	 */
	public String getInternetBl() {
		return this.internetBl;
	}
	
	/**
	 * Column Info
	 * @return bcVvdCd
	 */
	public String getBcVvdCd() {
		return this.bcVvdCd;
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
	 * @return blRlseOfcCd
	 */
	public String getBlRlseOfcCd() {
		return this.blRlseOfcCd;
	}
	
	/**
	 * Column Info
	 * @return blSrndOfcCd
	 */
	public String getBlSrndOfcCd() {
		return this.blSrndOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cptrOfcCd
	 */
	public String getCptrOfcCd() {
		return this.cptrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}	
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return rTerm
	 */
	public String getRTerm() {
		return this.rTerm;
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
	 * @return polYardCd
	 */
	public String getPolYardCd() {
		return this.polYardCd;
	}
	
	/**
	 * Column Info
	 * @return dTerm
	 */
	public String getDTerm() {
		return this.dTerm;
	}
	
	/**
	 * Column Info
	 * @return podYardCd
	 */
	public String getPodYardCd() {
		return this.podYardCd;
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
	 * @return orderby
	 */
	public String getOrderby() {
		return this.orderby;
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
	 * @return custTpCd
	 */
	public String getCustTpCd() {
		return this.custTpCd;
	}
	
	/**
	 * Column Info
	 * @return custTpCdS
	 */
	public String getCustTpCdS() {
		return this.custTpCdS;
	}	

	/**
	 * Column Info
	 * @return custTpCdN
	 */
	public String getCustTpCdN() {
		return this.custTpCdN;
	}
	
	/**
	 * Column Info
	 * @return custTpCdF
	 */
	public String getCustTpCdF() {
		return this.custTpCdF;
	}
	
	/**
	 * Column Info
	 * @return custTpCdG
	 */
	public String getCustTpCdG() {
		return this.custTpCdG;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return custTpCdC
	 */
	public String getCustTpCdC() {
		return this.custTpCdC;
	}
	
	/**
	 * Column Info
	 * @return custTpCdA
	 */
	public String getCustTpCdA() {
		return this.custTpCdA;
	}
	
	/**
	 * Column Info
	 * @return custGrpId
	 */
	public String getCustGrpId() {
		return this.custGrpId;
	}	
	
	/**
	 * Column Info
	 * @param rdoInOut
	 */
	public void setRdoInOut(String rdoInOut) {
		this.rdoInOut = rdoInOut;
	}
	
	/**
	 * Column Info
	 * @param sailFromDt
	 */
	public void setSailFromDt(String sailFromDt) {
		this.sailFromDt = sailFromDt;
	}
	
	/**
	 * Column Info
	 * @param sailToDt
	 */
	public void setSailToDt(String sailToDt) {
		this.sailToDt = sailToDt;
	}
	
	/**
	 * Column Info
	 * @param arrFromDt
	 */
	public void setArrFromDt(String arrFromDt) {
		this.arrFromDt = arrFromDt;
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
	 * @param arrToDt
	 */
	public void setArrToDt(String arrToDt) {
		this.arrToDt = arrToDt;
	}
	
	/**
	 * Column Info
	 * @param blPrnFromDt
	 */
	public void setBlPrnFromDt(String blPrnFromDt) {
		this.blPrnFromDt = blPrnFromDt;
	}
	
	/**
	 * Column Info
	 * @param trfCd
	 */
	public void setTrfCd(String trfCd) {
		this.trfCd = trfCd;
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
	 * @param blPrnToDt
	 */
	public void setBlPrnToDt(String blPrnToDt) {
		this.blPrnToDt = blPrnToDt;
	}
	
	/**
	 * Column Info
	 * @param blSrndFromDt
	 */
	public void setBlSrndFromDt(String blSrndFromDt) {
		this.blSrndFromDt = blSrndFromDt;
	}
	
	/**
	 * Column Info
	 * @param blSrndToDt
	 */
	public void setBlSrndToDt(String blSrndToDt) {
		this.blSrndToDt = blSrndToDt;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param cgoRlseStsCd
	 */
	public void setCgoRlseStsCd(String cgoRlseStsCd) {
		this.cgoRlseStsCd = cgoRlseStsCd;
	}
	
	/**
	 * Column Info
	 * @param oblIssUsrId
	 */
	public void setOblIssUsrId(String oblIssUsrId) {
		this.oblIssUsrId = oblIssUsrId;
	}
	
	/**
	 * Column Info
	 * @param blStsCd
	 */
	public void setBlStsCd(String blStsCd) {
		this.blStsCd = blStsCd;
	}
	
	/**
	 * Column Info
	 * @param bcPorCd
	 */
	public void setBcPorCd(String bcPorCd) {
		this.bcPorCd = bcPorCd;
	}
	
	/**
	 * Column Info
	 * @param blTpCd
	 */
	public void setBlTpCd(String blTpCd) {
		this.blTpCd = blTpCd;
	}
	
	/**
	 * Column Info
	 * @param bcPodCd
	 */
	public void setBcPodCd(String bcPodCd) {
		this.bcPodCd = bcPodCd;
	}
	
	/**
	 * Column Info
	 * @param internetBl
	 */
	public void setInternetBl(String internetBl) {
		this.internetBl = internetBl;
	}
	
	/**
	 * Column Info
	 * @param bcVvdCd
	 */
	public void setBcVvdCd(String bcVvdCd) {
		this.bcVvdCd = bcVvdCd;
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
	 * @param blRlseOfcCd
	 */
	public void setBlRlseOfcCd(String blRlseOfcCd) {
		this.blRlseOfcCd = blRlseOfcCd;
	}
	
	/**
	 * Column Info
	 * @param blSrndOfcCd
	 */
	public void setBlSrndOfcCd(String blSrndOfcCd) {
		this.blSrndOfcCd = blSrndOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cptrOfcCd
	 */
	public void setCptrOfcCd(String cptrOfcCd) {
		this.cptrOfcCd = cptrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param rTerm
	 */
	public void setRTerm(String rTerm) {
		this.rTerm = rTerm;
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
	 * @param polYardCd
	 */
	public void setPolYardCd(String polYardCd) {
		this.polYardCd = polYardCd;
	}
	
	/**
	 * Column Info
	 * @param dTerm
	 */
	public void setDTerm(String dTerm) {
		this.dTerm = dTerm;
	}
	
	/**
	 * Column Info
	 * @param podYardCd
	 */
	public void setPodYardCd(String podYardCd) {
		this.podYardCd = podYardCd;
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
	 * @param orderby
	 */
	public void setOrderby(String orderby) {
		this.orderby = orderby;
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
	 * @param custTpCd
	 */
	public void setCustTpCd(String custTpCd) {
		this.custTpCd = custTpCd;
	}
	
	/**
	 * Column Info
	 * @param custTpCdS
	 */
	public void setCustTpCdS(String custTpCdS) {
		this.custTpCdS = custTpCdS;
	}
	
	/**
	 * Column Info
	 * @param custTpCdN
	 */
	public void setCustTpCdN(String custTpCdN) {
		this.custTpCdN = custTpCdN;
	}
	
	/**
	 * Column Info
	 * @param custTpCdF
	 */
	public void setCustTpCdF(String custTpCdF) {
		this.custTpCdF = custTpCdF;
	}
	
	/**
	 * Column Info
	 * @param custTpCdG
	 */
	public void setCustTpCdG(String custTpCdG) {
		this.custTpCdG = custTpCdG;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param custTpCdC
	 */
	public void setCustTpCdC(String custTpCdC) {
		this.custTpCdC = custTpCdC;
	}
	
	/**
	 * Column Info
	 * @param custTpCdA
	 */
	public void setCustTpCdA(String custTpCdA) {
		this.custTpCdA = custTpCdA;
	}
	
	/**
	 * Column Info
	 * @param custGrpId
	 */
	public void setCustGrpId(String custGrpId) {
		this.custGrpId = custGrpId;
	}	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRdoInOut(JSPUtil.getParameter(request, "rdo_in_out", ""));
		setSailFromDt(JSPUtil.getParameter(request, "sail_from_dt", ""));
		setSailToDt(JSPUtil.getParameter(request, "sail_to_dt", ""));
		setArrFromDt(JSPUtil.getParameter(request, "arr_from_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setArrToDt(JSPUtil.getParameter(request, "arr_to_dt", ""));
		setBlPrnFromDt(JSPUtil.getParameter(request, "bl_prn_from_dt", ""));
		setTrfCd(JSPUtil.getParameter(request, "trf_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setBlPrnToDt(JSPUtil.getParameter(request, "bl_prn_to_dt", ""));
		setBlSrndFromDt(JSPUtil.getParameter(request, "bl_srnd_from_dt", ""));
		setBlSrndToDt(JSPUtil.getParameter(request, "bl_srnd_to_dt", ""));
		setCrrCd(JSPUtil.getParameter(request, "crr_cd", ""));		
		setCgoRlseStsCd(JSPUtil.getParameter(request, "cgo_rlse_sts_cd", ""));
		setOblIssUsrId(JSPUtil.getParameter(request, "obl_iss_usr_id", ""));
		setBlStsCd(JSPUtil.getParameter(request, "bl_sts_cd", ""));
		setBcPorCd(JSPUtil.getParameter(request, "bc_por_cd", ""));
		setBlTpCd(JSPUtil.getParameter(request, "bl_tp_cd", ""));
		setBcPodCd(JSPUtil.getParameter(request, "bc_pod_cd", ""));
		setInternetBl(JSPUtil.getParameter(request, "internet_bl", ""));
		setBcVvdCd(JSPUtil.getParameter(request, "bc_vvd_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setBlRlseOfcCd(JSPUtil.getParameter(request, "bl_rlse_ofc_cd", ""));
		setBlSrndOfcCd(JSPUtil.getParameter(request, "bl_srnd_ofc_cd", ""));
		setCptrOfcCd(JSPUtil.getParameter(request, "cptr_ofc_cd", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setRTerm(JSPUtil.getParameter(request, "r_term", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setPolYardCd(JSPUtil.getParameter(request, "pol_yard_cd", ""));
		setDTerm(JSPUtil.getParameter(request, "d_term", ""));
		setPodYardCd(JSPUtil.getParameter(request, "pod_yard_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setOrderby(JSPUtil.getParameter(request, "orderby", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));		
		setCustTpCdS(JSPUtil.getParameter(request, "cust_tp_cd_s", ""));
		setCustTpCdC(JSPUtil.getParameter(request, "cust_tp_cd_c", ""));
		setCustTpCdN(JSPUtil.getParameter(request, "cust_tp_cd_n", ""));
		setCustTpCdF(JSPUtil.getParameter(request, "cust_tp_cd_f", ""));
		setCustTpCdA(JSPUtil.getParameter(request, "cust_tp_cd_a", ""));
		setCustTpCdG(JSPUtil.getParameter(request, "cust_tp_cd_g", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setCustTpCd(JSPUtil.getParameter(request, "cust_tp_cd", ""));		
		setCustGrpId(JSPUtil.getParameter(request, "cust_grp_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BlCntrInfoReportInVO[]
	 */
	public BlCntrInfoReportInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BlCntrInfoReportInVO[]
	 */
	public BlCntrInfoReportInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BlCntrInfoReportInVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rdoInOut = (JSPUtil.getParameter(request, prefix	+ "rdo_in_out", length));
			String[] sailFromDt = (JSPUtil.getParameter(request, prefix	+ "sail_from_dt", length));
			String[] sailToDt = (JSPUtil.getParameter(request, prefix	+ "sail_to_dt", length));
			String[] arrFromDt = (JSPUtil.getParameter(request, prefix	+ "arr_from_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] arrToDt = (JSPUtil.getParameter(request, prefix	+ "arr_to_dt", length));
			String[] blPrnFromDt = (JSPUtil.getParameter(request, prefix	+ "bl_prn_from_dt", length));
			String[] trfCd = (JSPUtil.getParameter(request, prefix	+ "trf_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] blPrnToDt = (JSPUtil.getParameter(request, prefix	+ "bl_prn_to_dt", length));
			String[] blSrndFromDt = (JSPUtil.getParameter(request, prefix	+ "bl_srnd_from_dt", length));
			String[] blSrndToDt = (JSPUtil.getParameter(request, prefix	+ "bl_srnd_to_dt", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] cgoRlseStsCd = (JSPUtil.getParameter(request, prefix	+ "cgo_rlse_sts_cd", length));
			String[] oblIssUsrId = (JSPUtil.getParameter(request, prefix	+ "obl_iss_usr_id", length));
			String[] blStsCd = (JSPUtil.getParameter(request, prefix	+ "bl_sts_cd", length));
			String[] bcPorCd = (JSPUtil.getParameter(request, prefix	+ "bc_por_cd", length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd", length));
			String[] bcPodCd = (JSPUtil.getParameter(request, prefix	+ "bc_pod_cd", length));
			String[] internetBl = (JSPUtil.getParameter(request, prefix	+ "internet_bl", length));
			String[] bcVvdCd = (JSPUtil.getParameter(request, prefix	+ "bc_vvd_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] blRlseOfcCd = (JSPUtil.getParameter(request, prefix	+ "bl_rlse_ofc_cd", length));
			String[] blSrndOfcCd = (JSPUtil.getParameter(request, prefix	+ "bl_srnd_ofc_cd", length));
			String[] cptrOfcCd = (JSPUtil.getParameter(request, prefix	+ "cptr_ofc_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] rTerm = (JSPUtil.getParameter(request, prefix	+ "r_term", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] polYardCd = (JSPUtil.getParameter(request, prefix	+ "pol_yard_cd", length));
			String[] dTerm = (JSPUtil.getParameter(request, prefix	+ "d_term", length));
			String[] podYardCd = (JSPUtil.getParameter(request, prefix	+ "pod_yard_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] orderby = (JSPUtil.getParameter(request, prefix	+ "orderby", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] custTpCd = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd", length));
			String[] custTpCdS = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd_s", length));
			String[] custTpCdN = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd_n", length));
			String[] custTpCdF = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd_f", length));
			String[] custTpCdG = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd_g", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] custTpCdC = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd_c", length));
			String[] custTpCdA = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd_a", length));
			String[] custGrpId = (JSPUtil.getParameter(request, prefix	+ "cust_grp_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new BlCntrInfoReportInVO();
				if (rdoInOut[i] != null)
					model.setRdoInOut(rdoInOut[i]);
				if (sailFromDt[i] != null)
					model.setSailFromDt(sailFromDt[i]);
				if (sailToDt[i] != null)
					model.setSailToDt(sailToDt[i]);
				if (arrFromDt[i] != null)
					model.setArrFromDt(arrFromDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (arrToDt[i] != null)
					model.setArrToDt(arrToDt[i]);
				if (blPrnFromDt[i] != null)
					model.setBlPrnFromDt(blPrnFromDt[i]);
				if (trfCd[i] != null)
					model.setTrfCd(trfCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (blPrnToDt[i] != null)
					model.setBlPrnToDt(blPrnToDt[i]);
				if (blSrndFromDt[i] != null)
					model.setBlSrndFromDt(blSrndFromDt[i]);
				if (blSrndToDt[i] != null)
					model.setBlSrndToDt(blSrndToDt[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (cgoRlseStsCd[i] != null)
					model.setCgoRlseStsCd(cgoRlseStsCd[i]);
				if (oblIssUsrId[i] != null)
					model.setOblIssUsrId(oblIssUsrId[i]);
				if (blStsCd[i] != null)
					model.setBlStsCd(blStsCd[i]);
				if (bcPorCd[i] != null)
					model.setBcPorCd(bcPorCd[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (bcPodCd[i] != null)
					model.setBcPodCd(bcPodCd[i]);
				if (internetBl[i] != null)
					model.setInternetBl(internetBl[i]);
				if (bcVvdCd[i] != null)
					model.setBcVvdCd(bcVvdCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (blRlseOfcCd[i] != null)
					model.setBlRlseOfcCd(blRlseOfcCd[i]);
				if (blSrndOfcCd[i] != null)
					model.setBlSrndOfcCd(blSrndOfcCd[i]);
				if (cptrOfcCd[i] != null)
					model.setCptrOfcCd(cptrOfcCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (rTerm[i] != null)
					model.setRTerm(rTerm[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (polYardCd[i] != null)
					model.setPolYardCd(polYardCd[i]);
				if (dTerm[i] != null)
					model.setDTerm(dTerm[i]);
				if (podYardCd[i] != null)
					model.setPodYardCd(podYardCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (orderby[i] != null)
					model.setOrderby(orderby[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (custTpCd[i] != null)
					model.setCustTpCd(custTpCd[i]);
				if (custTpCdS[i] != null)
					model.setCustTpCdS(custTpCdS[i]);
				if (custTpCdN[i] != null)
					model.setCustTpCdN(custTpCdN[i]);
				if (custTpCdF[i] != null)
					model.setCustTpCdF(custTpCdF[i]);
				if (custTpCdG[i] != null)
					model.setCustTpCdG(custTpCdG[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (custTpCdC[i] != null)
					model.setCustTpCdC(custTpCdC[i]);
				if (custTpCdA[i] != null)
					model.setCustTpCdA(custTpCdA[i]);
				if (custGrpId[i] != null)
					model.setCustGrpId(custGrpId[i]);				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBlCntrInfoReportInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BlCntrInfoReportInVO[]
	 */
	public BlCntrInfoReportInVO[] getBlCntrInfoReportInVOs(){
		BlCntrInfoReportInVO[] vos = (BlCntrInfoReportInVO[])models.toArray(new BlCntrInfoReportInVO[models.size()]);
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
		this.rdoInOut = this.rdoInOut .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailFromDt = this.sailFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailToDt = this.sailToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrFromDt = this.arrFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrToDt = this.arrToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blPrnFromDt = this.blPrnFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfCd = this.trfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blPrnToDt = this.blPrnToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrndFromDt = this.blSrndFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrndToDt = this.blSrndToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoRlseStsCd = this.cgoRlseStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssUsrId = this.oblIssUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blStsCd = this.blStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bcPorCd = this.bcPorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bcPodCd = this.bcPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.internetBl = this.internetBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bcVvdCd = this.bcVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blRlseOfcCd = this.blRlseOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrndOfcCd = this.blSrndOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cptrOfcCd = this.cptrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rTerm = this.rTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYardCd = this.polYardCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dTerm = this.dTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYardCd = this.podYardCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orderby = this.orderby .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCd = this.custTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCdS = this.custTpCdS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCdN = this.custTpCdN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCdF = this.custTpCdF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCdG = this.custTpCdG .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCdC = this.custTpCdC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCdA = this.custTpCdA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custGrpId = this.custGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
