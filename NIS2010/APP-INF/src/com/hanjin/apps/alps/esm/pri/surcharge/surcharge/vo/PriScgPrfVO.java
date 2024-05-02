/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PriScgPrfVO.java
*@FileTitle : PriScgPrfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.07
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2012.03.07 서미진 
* 1.0 Creation
* 2013.03.07 전윤주 [CHM-201323465] rc_air_cond_tp_use_flg 추가
* 2013.04.17 전윤주 [CHM-201324203] ctrt_dt_use_flg 추가
* 2013.10.01 전윤주 [CHM-201326927] act_rat_use_flg 추가
* 2013.10.01 전윤주 [CHM-201326929] prn_hdn_use_flg 추가
* 2014.03.20 전윤주 [CHM-201429456] Food Grade 항목 추가
* 2014.04.10 전윤주 [CHM-201429656] State code 항목 추가   
* 2015.04.10 전지예 [CHM-201535041] Arrival Date 항목 추가
=========================================================*/

package com.hanjin.apps.alps.esm.pri.surcharge.surcharge.vo;

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
 * @author 서미진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PriScgPrfVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PriScgPrfVO> models = new ArrayList<PriScgPrfVO>();
	
	/* Column Info */
	private String tsPortCnt = null;
	/* Column Info */
	private String socUseFlg = null;
	/* Column Info */
	private String socCnt = null;
	/* Column Info */
	private String tmlCnt = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String crteDyKntUseFlg = null;
	/* Column Info */
	private String subTrdCnt = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dirCallCnt = null;
	/* Column Info */
	private String cmdtCnt = null;
	/* Column Info */
	private String rcvDeTermUseFlg = null;
	/* Column Info */
	private String tmlUseFlg = null;
	/* Column Info */
	private String porDefCnt = null;
	/* Column Info */
	private String polUseFlg = null;
	/* Column Info */
	private String prdCrteUseFlg = null;
	/* Column Info */
	private String vslSlanCnt = null;
	/* Column Info */
	private String rcvDeTermCnt = null;
	/* Column Info */
	private String hngrBarUseFlg = null;
	/* Column Info */
	private String prdCrteTpUseFlg = null;
	/* Column Info */
	private String hngrBarCnt = null;
	/* Column Info */
	private String scgCrteDyKntCnt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String delDefCnt = null;
	/* Column Info */
	private String fltPctTpCd = null;
	/* Column Info */
	private String cmdtUseFlg = null;
	/* Column Info */
	private String scgPrdCrteCdCnt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String scgPrdTpCdCnt = null;
	/* Column Info */
	private String dirCallUseFlg = null;
	/* Column Info */
	private String podDefCnt = null;
	/* Column Info */
	private String pctBseCd = null;
	/* Column Info */
	private String podUseFlg = null;
	/* Column Info */
	private String porUseFlg = null;
	/* Column Info */
	private String cgoWgtCnt = null;
	/* Column Info */
	private String ioGaUseFlg = null;
	/* Column Info */
	private String imdgClssUseFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String cnlTzFlg = null;
	/* Column Info */
	private String igGaCnt = null;
	/* Column Info */
	private String psaNoMngFlg = null;
	/* Column Info */
	private String rcAirCondTpUseFlg = null;
	/* Column Info */
	private String ctrtDtUseFlg = null;
	/* Column Info */
	private String actRatUseFlg = null;
	/* Column Info */
	private String prnHdnUseFlg = null;
	/* Column Info */
	private String steUseFlg = null;
	/* Column Info */
	private String fdGrdUseFlg = null;
	/* Column Info */
	private String fdGrdCnt = null;
	/* Column Info */
	private String arrDtUseFlg = null;
	/* Column Info */
	private String arrDtCnt = null;
	/* Column Info */
	private String usaSvcModUseFlg = null;
	/* Column Info */
	private String griCmdtUseFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String scgImdgClssCnt = null;
	/* Column Info */
	private String slanUseFlg = null;
	/* Column Info */
	private String polDefCnt = null;
	/* Column Info */
	private String cgoWgtUseFlg = null;
	/* Column Info */
	private String tsPortUseFlg = null;
	/* Column Info */
	private String usaSvcModCnt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String delUseFlg = null;
	/* Column Info */
	private String griCmdtCnt = null;
	/* Column Info */
	private String trnsModCnt = null;
	/* Column Info */
	private String trnsModUseFlg = null;
	/* Column Info */
	private String cnlTzCnt = null;
	/* Column Info */
	private String subTrdUseFlg = null;
	/* Column Info */
	private String psaNoCnt = null;
	/* Column Info */
	private String rcAirCondTpCnt  = null;
	/* Column Info */
	private String ctrtDtCnt  = null;
	/* Column Info */
	private String actRatCnt  = null;
	/* Column Info */
	private String prnHdnCnt  = null;
	/* Column Info */
	private String steCdCnt  = null;
	/* Column Info */
	private String trdCd  = null;


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PriScgPrfVO() {}

	public PriScgPrfVO(String ibflag, String pagerows, String svcScpCd, String chgCd, String fltPctTpCd, String pctBseCd, String subTrdUseFlg, String subTrdCnt, String slanUseFlg, String vslSlanCnt, String porUseFlg, String porDefCnt, String polUseFlg, String polDefCnt, String podUseFlg, String podDefCnt, String delUseFlg, String delDefCnt, String imdgClssUseFlg, String scgImdgClssCnt, String tsPortUseFlg, String tsPortCnt, String tmlUseFlg, String tmlCnt, String trnsModUseFlg, String trnsModCnt, String usaSvcModUseFlg, String usaSvcModCnt, String rcvDeTermUseFlg, String rcvDeTermCnt, String hngrBarUseFlg, String hngrBarCnt, String dirCallUseFlg, String dirCallCnt, String cgoWgtUseFlg, String cgoWgtCnt, String cmdtUseFlg, String cmdtCnt, String griCmdtUseFlg, String griCmdtCnt, String socUseFlg, String socCnt, String ioGaUseFlg, String igGaCnt, String cnlTzFlg, String cnlTzCnt, String crteDyKntUseFlg, String scgCrteDyKntCnt, String prdCrteTpUseFlg, String scgPrdTpCdCnt, String prdCrteUseFlg, String scgPrdCrteCdCnt, String psaNoMngFlg, String rcAirCondTpUseFlg, String ctrtDtUseFlg, String actRatUseFlg, String prnHdnUseFlg, String steUseFlg, String fdGrdUseFlg, String fdGrdCnt, String arrDtUseFlg, String arrDtCnt, String psaNoCnt, String rcAirCondTpCnt, String ctrtDtCnt, String actRatCnt, String prnHdnCnt, String steCdCnt, String creUsrId, String creDt, String updUsrId, String updDt, String trdCd) {
		this.tsPortCnt = tsPortCnt;
		this.socUseFlg = socUseFlg;
		this.socCnt = socCnt;
		this.tmlCnt = tmlCnt;
		this.svcScpCd = svcScpCd;
		this.crteDyKntUseFlg = crteDyKntUseFlg;
		this.subTrdCnt = subTrdCnt;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.dirCallCnt = dirCallCnt;
		this.cmdtCnt = cmdtCnt;
		this.rcvDeTermUseFlg = rcvDeTermUseFlg;
		this.tmlUseFlg = tmlUseFlg;
		this.porDefCnt = porDefCnt;
		this.polUseFlg = polUseFlg;
		this.prdCrteUseFlg = prdCrteUseFlg;
		this.vslSlanCnt = vslSlanCnt;
		this.rcvDeTermCnt = rcvDeTermCnt;
		this.hngrBarUseFlg = hngrBarUseFlg;
		this.prdCrteTpUseFlg = prdCrteTpUseFlg;
		this.hngrBarCnt = hngrBarCnt;
		this.scgCrteDyKntCnt = scgCrteDyKntCnt;
		this.updUsrId = updUsrId;
		this.delDefCnt = delDefCnt;
		this.fltPctTpCd = fltPctTpCd;
		this.cmdtUseFlg = cmdtUseFlg;
		this.scgPrdCrteCdCnt = scgPrdCrteCdCnt;
		this.creUsrId = creUsrId;
		this.scgPrdTpCdCnt = scgPrdTpCdCnt;
		this.dirCallUseFlg = dirCallUseFlg;
		this.podDefCnt = podDefCnt;
		this.pctBseCd = pctBseCd;
		this.podUseFlg = podUseFlg;
		this.porUseFlg = porUseFlg;
		this.cgoWgtCnt = cgoWgtCnt;
		this.ioGaUseFlg = ioGaUseFlg;
		this.imdgClssUseFlg = imdgClssUseFlg;
		this.creDt = creDt;
		this.cnlTzFlg = cnlTzFlg;
		this.igGaCnt = igGaCnt;
		this.psaNoMngFlg = psaNoMngFlg;
		this.rcAirCondTpUseFlg = rcAirCondTpUseFlg;
		this.ctrtDtUseFlg = ctrtDtUseFlg;
		this.actRatUseFlg = actRatUseFlg;
		this.prnHdnUseFlg = prnHdnUseFlg;
		this.steUseFlg = steUseFlg;
		this.fdGrdUseFlg = fdGrdUseFlg;
		this.fdGrdCnt = fdGrdCnt;
		this.arrDtUseFlg = arrDtUseFlg;
		this.arrDtCnt = arrDtCnt;
		this.usaSvcModUseFlg = usaSvcModUseFlg;
		this.griCmdtUseFlg = griCmdtUseFlg;
		this.ibflag = ibflag;
		this.scgImdgClssCnt = scgImdgClssCnt;
		this.slanUseFlg = slanUseFlg;
		this.polDefCnt = polDefCnt;
		this.cgoWgtUseFlg = cgoWgtUseFlg;
		this.tsPortUseFlg = tsPortUseFlg;
		this.usaSvcModCnt = usaSvcModCnt;
		this.updDt = updDt;
		this.delUseFlg = delUseFlg;
		this.griCmdtCnt = griCmdtCnt;
		this.trnsModCnt = trnsModCnt;
		this.trnsModUseFlg = trnsModUseFlg;
		this.cnlTzCnt = cnlTzCnt;
		this.subTrdUseFlg = subTrdUseFlg;
		this.psaNoCnt = psaNoCnt;
		this.rcAirCondTpCnt = rcAirCondTpCnt;
		this.ctrtDtCnt = ctrtDtCnt;
		this.actRatCnt = actRatCnt;
		this.prnHdnCnt = prnHdnCnt;
		this.steCdCnt = steCdCnt;
		this.trdCd = trdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ts_port_cnt", getTsPortCnt());
		this.hashColumns.put("soc_use_flg", getSocUseFlg());
		this.hashColumns.put("soc_cnt", getSocCnt());
		this.hashColumns.put("tml_cnt", getTmlCnt());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("crte_dy_knt_use_flg", getCrteDyKntUseFlg());
		this.hashColumns.put("sub_trd_cnt", getSubTrdCnt());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dir_call_cnt", getDirCallCnt());
		this.hashColumns.put("cmdt_cnt", getCmdtCnt());
		this.hashColumns.put("rcv_de_term_use_flg", getRcvDeTermUseFlg());
		this.hashColumns.put("tml_use_flg", getTmlUseFlg());
		this.hashColumns.put("por_def_cnt", getPorDefCnt());
		this.hashColumns.put("pol_use_flg", getPolUseFlg());
		this.hashColumns.put("prd_crte_use_flg", getPrdCrteUseFlg());
		this.hashColumns.put("vsl_slan_cnt", getVslSlanCnt());
		this.hashColumns.put("rcv_de_term_cnt", getRcvDeTermCnt());
		this.hashColumns.put("hngr_bar_use_flg", getHngrBarUseFlg());
		this.hashColumns.put("prd_crte_tp_use_flg", getPrdCrteTpUseFlg());
		this.hashColumns.put("hngr_bar_cnt", getHngrBarCnt());
		this.hashColumns.put("scg_crte_dy_knt_cnt", getScgCrteDyKntCnt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("del_def_cnt", getDelDefCnt());
		this.hashColumns.put("flt_pct_tp_cd", getFltPctTpCd());
		this.hashColumns.put("cmdt_use_flg", getCmdtUseFlg());
		this.hashColumns.put("scg_prd_crte_cd_cnt", getScgPrdCrteCdCnt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("scg_prd_tp_cd_cnt", getScgPrdTpCdCnt());
		this.hashColumns.put("dir_call_use_flg", getDirCallUseFlg());
		this.hashColumns.put("pod_def_cnt", getPodDefCnt());
		this.hashColumns.put("pct_bse_cd", getPctBseCd());
		this.hashColumns.put("pod_use_flg", getPodUseFlg());
		this.hashColumns.put("por_use_flg", getPorUseFlg());
		this.hashColumns.put("cgo_wgt_cnt", getCgoWgtCnt());
		this.hashColumns.put("io_ga_use_flg", getIoGaUseFlg());
		this.hashColumns.put("imdg_clss_use_flg", getImdgClssUseFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cnl_tz_flg", getCnlTzFlg());
		this.hashColumns.put("ig_ga_cnt", getIgGaCnt());
		this.hashColumns.put("psa_no_mng_flg", getPsaNoMngFlg());
		this.hashColumns.put("rc_air_cond_tp_use_flg", getRcAirCondTpUseFlg());
		this.hashColumns.put("ctrt_dt_use_flg", getCtrtDtUseFlg());
		this.hashColumns.put("act_rat_use_flg", getActRatUseFlg());
		this.hashColumns.put("prn_hdn_use_flg", getPrnHdnUseFlg());
		this.hashColumns.put("ste_use_flg", getSteUseFlg());
		this.hashColumns.put("fd_grd_use_flg", getFdGrdUseFlg());
		this.hashColumns.put("usa_svc_mod_use_flg", getUsaSvcModUseFlg());
		this.hashColumns.put("gri_cmdt_use_flg", getGriCmdtUseFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("scg_imdg_clss_cnt", getScgImdgClssCnt());
		this.hashColumns.put("slan_use_flg", getSlanUseFlg());
		this.hashColumns.put("pol_def_cnt", getPolDefCnt());
		this.hashColumns.put("cgo_wgt_use_flg", getCgoWgtUseFlg());
		this.hashColumns.put("ts_port_use_flg", getTsPortUseFlg());
		this.hashColumns.put("usa_svc_mod_cnt", getUsaSvcModCnt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("del_use_flg", getDelUseFlg());
		this.hashColumns.put("gri_cmdt_cnt", getGriCmdtCnt());
		this.hashColumns.put("trns_mod_cnt", getTrnsModCnt());
		this.hashColumns.put("trns_mod_use_flg", getTrnsModUseFlg());
		this.hashColumns.put("cnl_tz_cnt", getCnlTzCnt());
		this.hashColumns.put("sub_trd_use_flg", getSubTrdUseFlg());
		this.hashColumns.put("psa_no_cnt", getPsaNoCnt());
		this.hashColumns.put("rc_air_cond_tp_cnt", getRcAirCondTpCnt());
		this.hashColumns.put("ctrt_dt_cnt", getCtrtDtCnt());
		this.hashColumns.put("act_rat_cnt", getActRatCnt());
		this.hashColumns.put("prn_hdn_cnt", getPrnHdnCnt());
		this.hashColumns.put("ste_cd_cnt", getSteCdCnt());
		this.hashColumns.put("fd_grd_cnt", getFdGrdCnt());
		this.hashColumns.put("arr_dt_use_flg", getArrDtUseFlg());
		this.hashColumns.put("arr_dt_cnt", getArrDtCnt());
		this.hashColumns.put("trd_cd", getTrdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ts_port_cnt", "tsPortCnt");
		this.hashFields.put("soc_use_flg", "socUseFlg");
		this.hashFields.put("soc_cnt", "socCnt");
		this.hashFields.put("tml_cnt", "tmlCnt");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("crte_dy_knt_use_flg", "crteDyKntUseFlg");
		this.hashFields.put("sub_trd_cnt", "subTrdCnt");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dir_call_cnt", "dirCallCnt");
		this.hashFields.put("cmdt_cnt", "cmdtCnt");
		this.hashFields.put("rcv_de_term_use_flg", "rcvDeTermUseFlg");
		this.hashFields.put("tml_use_flg", "tmlUseFlg");
		this.hashFields.put("por_def_cnt", "porDefCnt");
		this.hashFields.put("pol_use_flg", "polUseFlg");
		this.hashFields.put("prd_crte_use_flg", "prdCrteUseFlg");
		this.hashFields.put("vsl_slan_cnt", "vslSlanCnt");
		this.hashFields.put("rcv_de_term_cnt", "rcvDeTermCnt");
		this.hashFields.put("hngr_bar_use_flg", "hngrBarUseFlg");
		this.hashFields.put("prd_crte_tp_use_flg", "prdCrteTpUseFlg");
		this.hashFields.put("hngr_bar_cnt", "hngrBarCnt");
		this.hashFields.put("scg_crte_dy_knt_cnt", "scgCrteDyKntCnt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("del_def_cnt", "delDefCnt");
		this.hashFields.put("flt_pct_tp_cd", "fltPctTpCd");
		this.hashFields.put("cmdt_use_flg", "cmdtUseFlg");
		this.hashFields.put("scg_prd_crte_cd_cnt", "scgPrdCrteCdCnt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("scg_prd_tp_cd_cnt", "scgPrdTpCdCnt");
		this.hashFields.put("dir_call_use_flg", "dirCallUseFlg");
		this.hashFields.put("pod_def_cnt", "podDefCnt");
		this.hashFields.put("pct_bse_cd", "pctBseCd");
		this.hashFields.put("pod_use_flg", "podUseFlg");
		this.hashFields.put("por_use_flg", "porUseFlg");
		this.hashFields.put("cgo_wgt_cnt", "cgoWgtCnt");
		this.hashFields.put("io_ga_use_flg", "ioGaUseFlg");
		this.hashFields.put("imdg_clss_use_flg", "imdgClssUseFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cnl_tz_flg", "cnlTzFlg");
		this.hashFields.put("ig_ga_cnt", "igGaCnt");
		this.hashFields.put("psa_no_mng_flg", "psaNoMngFlg");
		this.hashFields.put("rc_air_cond_tp_use_flg", "rcAirCondTpUseFlg");
		this.hashFields.put("ctrt_dt_use_flg", "ctrtDtUseFlg");
		this.hashFields.put("act_rat_use_flg", "actRatUseFlg");
		this.hashFields.put("prn_hdn_use_flg", "prnHdnUseFlg");
		this.hashFields.put("ste_use_flg", "steUseFlg");
		this.hashFields.put("fd_grd_use_flg", "fdGrdUseFlg");
		this.hashFields.put("usa_svc_mod_use_flg", "usaSvcModUseFlg");
		this.hashFields.put("gri_cmdt_use_flg", "griCmdtUseFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("scg_imdg_clss_cnt", "scgImdgClssCnt");
		this.hashFields.put("slan_use_flg", "slanUseFlg");
		this.hashFields.put("pol_def_cnt", "polDefCnt");
		this.hashFields.put("cgo_wgt_use_flg", "cgoWgtUseFlg");
		this.hashFields.put("ts_port_use_flg", "tsPortUseFlg");
		this.hashFields.put("usa_svc_mod_cnt", "usaSvcModCnt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("del_use_flg", "delUseFlg");
		this.hashFields.put("gri_cmdt_cnt", "griCmdtCnt");
		this.hashFields.put("trns_mod_cnt", "trnsModCnt");
		this.hashFields.put("trns_mod_use_flg", "trnsModUseFlg");
		this.hashFields.put("cnl_tz_cnt", "cnlTzCnt");
		this.hashFields.put("sub_trd_use_flg", "subTrdUseFlg");
		this.hashFields.put("psa_no_cnt", "psaNoCnt");
		this.hashFields.put("rc_air_cond_tp_cnt", "rcAirCondTpCnt");
		this.hashFields.put("ctrt_dt_cnt", "ctrtDtCnt");
		this.hashFields.put("act_rat_cnt", "actRatCnt");
		this.hashFields.put("prn_hdn_cnt", "prnHdnCnt");
		this.hashFields.put("ste_cd_cnt", "steCdCnt");
		this.hashFields.put("fd_grd_cnt", "fdGrdCnt");
		this.hashFields.put("arr_dt_cnt", "arrDtCnt");
		this.hashFields.put("arr_dt_use_flg", "arrDtUseFlg");
		this.hashFields.put("trd_cd", "trdCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return tsPortCnt
	 */
	public String getTsPortCnt() {
		return this.tsPortCnt;
	}
	
	/**
	 * Column Info
	 * @return socUseFlg
	 */
	public String getSocUseFlg() {
		return this.socUseFlg;
	}
	
	/**
	 * Column Info
	 * @return socCnt
	 */
	public String getSocCnt() {
		return this.socCnt;
	}
	
	/**
	 * Column Info
	 * @return tmlCnt
	 */
	public String getTmlCnt() {
		return this.tmlCnt;
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
	 * @return crteDyKntUseFlg
	 */
	public String getCrteDyKntUseFlg() {
		return this.crteDyKntUseFlg;
	}
	
	/**
	 * Column Info
	 * @return subTrdCnt
	 */
	public String getSubTrdCnt() {
		return this.subTrdCnt;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
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
	 * @return dirCallCnt
	 */
	public String getDirCallCnt() {
		return this.dirCallCnt;
	}
	
	/**
	 * Column Info
	 * @return cmdtCnt
	 */
	public String getCmdtCnt() {
		return this.cmdtCnt;
	}
	
	/**
	 * Column Info
	 * @return rcvDeTermUseFlg
	 */
	public String getRcvDeTermUseFlg() {
		return this.rcvDeTermUseFlg;
	}
	
	/**
	 * Column Info
	 * @return tmlUseFlg
	 */
	public String getTmlUseFlg() {
		return this.tmlUseFlg;
	}
	
	/**
	 * Column Info
	 * @return porDefCnt
	 */
	public String getPorDefCnt() {
		return this.porDefCnt;
	}
	
	/**
	 * Column Info
	 * @return polUseFlg
	 */
	public String getPolUseFlg() {
		return this.polUseFlg;
	}
	
	/**
	 * Column Info
	 * @return prdCrteUseFlg
	 */
	public String getPrdCrteUseFlg() {
		return this.prdCrteUseFlg;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCnt
	 */
	public String getVslSlanCnt() {
		return this.vslSlanCnt;
	}
	
	/**
	 * Column Info
	 * @return rcvDeTermCnt
	 */
	public String getRcvDeTermCnt() {
		return this.rcvDeTermCnt;
	}
	
	/**
	 * Column Info
	 * @return hngrBarUseFlg
	 */
	public String getHngrBarUseFlg() {
		return this.hngrBarUseFlg;
	}
	
	/**
	 * Column Info
	 * @return prdCrteTpUseFlg
	 */
	public String getPrdCrteTpUseFlg() {
		return this.prdCrteTpUseFlg;
	}
	
	/**
	 * Column Info
	 * @return hngrBarCnt
	 */
	public String getHngrBarCnt() {
		return this.hngrBarCnt;
	}
	
	/**
	 * Column Info
	 * @return scgCrteDyKntCnt
	 */
	public String getScgCrteDyKntCnt() {
		return this.scgCrteDyKntCnt;
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
	 * @return delDefCnt
	 */
	public String getDelDefCnt() {
		return this.delDefCnt;
	}
	
	/**
	 * Column Info
	 * @return fltPctTpCd
	 */
	public String getFltPctTpCd() {
		return this.fltPctTpCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtUseFlg
	 */
	public String getCmdtUseFlg() {
		return this.cmdtUseFlg;
	}
	
	/**
	 * Column Info
	 * @return scgPrdCrteCdCnt
	 */
	public String getScgPrdCrteCdCnt() {
		return this.scgPrdCrteCdCnt;
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
	 * @return scgPrdTpCdCnt
	 */
	public String getScgPrdTpCdCnt() {
		return this.scgPrdTpCdCnt;
	}
	
	/**
	 * Column Info
	 * @return dirCallUseFlg
	 */
	public String getDirCallUseFlg() {
		return this.dirCallUseFlg;
	}
	
	/**
	 * Column Info
	 * @return podDefCnt
	 */
	public String getPodDefCnt() {
		return this.podDefCnt;
	}
	
	/**
	 * Column Info
	 * @return pctBseCd
	 */
	public String getPctBseCd() {
		return this.pctBseCd;
	}
	
	/**
	 * Column Info
	 * @return podUseFlg
	 */
	public String getPodUseFlg() {
		return this.podUseFlg;
	}
	
	/**
	 * Column Info
	 * @return porUseFlg
	 */
	public String getPorUseFlg() {
		return this.porUseFlg;
	}
	
	/**
	 * Column Info
	 * @return cgoWgtCnt
	 */
	public String getCgoWgtCnt() {
		return this.cgoWgtCnt;
	}
	
	/**
	 * Column Info
	 * @return ioGaUseFlg
	 */
	public String getIoGaUseFlg() {
		return this.ioGaUseFlg;
	}
	
	/**
	 * Column Info
	 * @return imdgClssUseFlg
	 */
	public String getImdgClssUseFlg() {
		return this.imdgClssUseFlg;
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
	 * @return cnlTzFlg
	 */
	public String getCnlTzFlg() {
		return this.cnlTzFlg;
	}
	
	/**
	 * Column Info
	 * @return igGaCnt
	 */
	public String getIgGaCnt() {
		return this.igGaCnt;
	}
	
	/**
	 * Column Info
	 * @return psaNoMngFlg
	 */
	public String getPsaNoMngFlg() {
		return this.psaNoMngFlg;
	}
	
	/**
	 * Column Info
	 * @return rcAirCondTpUseFlg
	 */
	public String getRcAirCondTpUseFlg() {
		return this.rcAirCondTpUseFlg;
	}
	
	/**
	 * Column Info
	 * @return ctrtDtUseFlg
	 */
	public String getCtrtDtUseFlg() {
		return this.ctrtDtUseFlg;
	}
	
	/**
	 * Column Info
	 * @return actRatUseFlg
	 */
	public String getActRatUseFlg() {
		return this.actRatUseFlg;
	}
	
	/**
	 * Column Info
	 * @return prnHdnUseFlg
	 */
	public String getPrnHdnUseFlg() {
		return this.prnHdnUseFlg;
	}
	
	/**
	 * Column Info
	 * @return steUseFlg
	 */
	public String getSteUseFlg() {
		return this.steUseFlg;
	}
	
	/**
	 * Column Info
	 * @return fdGrdUseFlg
	 */
	public String getFdGrdUseFlg() {
		return this.fdGrdUseFlg;
	}
	
	/**
	 * Column Info
	 * @return usaSvcModUseFlg
	 */
	public String getUsaSvcModUseFlg() {
		return this.usaSvcModUseFlg;
	}
	
	/**
	 * Column Info
	 * @return griCmdtUseFlg
	 */
	public String getGriCmdtUseFlg() {
		return this.griCmdtUseFlg;
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
	 * @return scgImdgClssCnt
	 */
	public String getScgImdgClssCnt() {
		return this.scgImdgClssCnt;
	}
	
	/**
	 * Column Info
	 * @return slanUseFlg
	 */
	public String getSlanUseFlg() {
		return this.slanUseFlg;
	}
	
	/**
	 * Column Info
	 * @return polDefCnt
	 */
	public String getPolDefCnt() {
		return this.polDefCnt;
	}
	
	/**
	 * Column Info
	 * @return cgoWgtUseFlg
	 */
	public String getCgoWgtUseFlg() {
		return this.cgoWgtUseFlg;
	}
	
	/**
	 * Column Info
	 * @return tsPortUseFlg
	 */
	public String getTsPortUseFlg() {
		return this.tsPortUseFlg;
	}
	
	/**
	 * Column Info
	 * @return usaSvcModCnt
	 */
	public String getUsaSvcModCnt() {
		return this.usaSvcModCnt;
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
	 * @return delUseFlg
	 */
	public String getDelUseFlg() {
		return this.delUseFlg;
	}
	
	/**
	 * Column Info
	 * @return griCmdtCnt
	 */
	public String getGriCmdtCnt() {
		return this.griCmdtCnt;
	}
	
	/**
	 * Column Info
	 * @return trnsModCnt
	 */
	public String getTrnsModCnt() {
		return this.trnsModCnt;
	}
	
	/**
	 * Column Info
	 * @return trnsModUseFlg
	 */
	public String getTrnsModUseFlg() {
		return this.trnsModUseFlg;
	}
	
	/**
	 * Column Info
	 * @return cnlTzCnt
	 */
	public String getCnlTzCnt() {
		return this.cnlTzCnt;
	}
	
	/**
	 * Column Info
	 * @return subTrdUseFlg
	 */
	public String getSubTrdUseFlg() {
		return this.subTrdUseFlg;
	}
	
	/**
	 * Column Info
	 * @return psaNoCnt
	 */
	public String getPsaNoCnt() {
		return this.psaNoCnt;
	}
	
	/**
	 * Column Info
	 * @return rcAirCondTpCnt
	 */
	public String getRcAirCondTpCnt() {
		return this.rcAirCondTpCnt;
	}
	
	/**
	 * Column Info
	 * @return ctrtDtCnt
	 */
	public String getCtrtDtCnt() {
		return this.ctrtDtCnt;
	}
	
	/**
	 * Column Info
	 * @return actRatCnt
	 */
	public String getActRatCnt() {
		return this.actRatCnt;
	}
	
	/**
	 * Column Info
	 * @return prnHdnCnt
	 */
	public String getPrnHdnCnt() {
		return this.prnHdnCnt;
	}
	
	/**
	 * Column Info
	 * @return steCdCnt
	 */
	public String getSteCdCnt() {
		return this.steCdCnt;
	}
	
	/**
	 * Column Info
	 * @return fdGrdCnt
	 */
	public String getFdGrdCnt() {
		return this.fdGrdCnt;
	}	
	
	/**
	 * Column Info
	 * @return arrDtUseFlg
	 */
	public String getArrDtUseFlg() {
		return arrDtUseFlg;
	}

	/**
	 * Column Info
	 * @return arrDtCnt
	 */
	public String getArrDtCnt() {
		return arrDtCnt;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return trdCd;
	}

	/**
	 * Column Info
	 * @param tsPortCnt
	 */
	public void setTsPortCnt(String tsPortCnt) {
		this.tsPortCnt = tsPortCnt;
	}
	
	/**
	 * Column Info
	 * @param socUseFlg
	 */
	public void setSocUseFlg(String socUseFlg) {
		this.socUseFlg = socUseFlg;
	}
	
	/**
	 * Column Info
	 * @param socCnt
	 */
	public void setSocCnt(String socCnt) {
		this.socCnt = socCnt;
	}
	
	/**
	 * Column Info
	 * @param tmlCnt
	 */
	public void setTmlCnt(String tmlCnt) {
		this.tmlCnt = tmlCnt;
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
	 * @param crteDyKntUseFlg
	 */
	public void setCrteDyKntUseFlg(String crteDyKntUseFlg) {
		this.crteDyKntUseFlg = crteDyKntUseFlg;
	}
	
	/**
	 * Column Info
	 * @param subTrdCnt
	 */
	public void setSubTrdCnt(String subTrdCnt) {
		this.subTrdCnt = subTrdCnt;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
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
	 * @param dirCallCnt
	 */
	public void setDirCallCnt(String dirCallCnt) {
		this.dirCallCnt = dirCallCnt;
	}
	
	/**
	 * Column Info
	 * @param cmdtCnt
	 */
	public void setCmdtCnt(String cmdtCnt) {
		this.cmdtCnt = cmdtCnt;
	}
	
	/**
	 * Column Info
	 * @param rcvDeTermUseFlg
	 */
	public void setRcvDeTermUseFlg(String rcvDeTermUseFlg) {
		this.rcvDeTermUseFlg = rcvDeTermUseFlg;
	}
	
	/**
	 * Column Info
	 * @param tmlUseFlg
	 */
	public void setTmlUseFlg(String tmlUseFlg) {
		this.tmlUseFlg = tmlUseFlg;
	}
	
	/**
	 * Column Info
	 * @param porDefCnt
	 */
	public void setPorDefCnt(String porDefCnt) {
		this.porDefCnt = porDefCnt;
	}
	
	/**
	 * Column Info
	 * @param polUseFlg
	 */
	public void setPolUseFlg(String polUseFlg) {
		this.polUseFlg = polUseFlg;
	}
	
	/**
	 * Column Info
	 * @param prdCrteUseFlg
	 */
	public void setPrdCrteUseFlg(String prdCrteUseFlg) {
		this.prdCrteUseFlg = prdCrteUseFlg;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCnt
	 */
	public void setVslSlanCnt(String vslSlanCnt) {
		this.vslSlanCnt = vslSlanCnt;
	}
	
	/**
	 * Column Info
	 * @param rcvDeTermCnt
	 */
	public void setRcvDeTermCnt(String rcvDeTermCnt) {
		this.rcvDeTermCnt = rcvDeTermCnt;
	}
	
	/**
	 * Column Info
	 * @param hngrBarUseFlg
	 */
	public void setHngrBarUseFlg(String hngrBarUseFlg) {
		this.hngrBarUseFlg = hngrBarUseFlg;
	}
	
	/**
	 * Column Info
	 * @param prdCrteTpUseFlg
	 */
	public void setPrdCrteTpUseFlg(String prdCrteTpUseFlg) {
		this.prdCrteTpUseFlg = prdCrteTpUseFlg;
	}
	
	/**
	 * Column Info
	 * @param hngrBarCnt
	 */
	public void setHngrBarCnt(String hngrBarCnt) {
		this.hngrBarCnt = hngrBarCnt;
	}
	
	/**
	 * Column Info
	 * @param scgCrteDyKntCnt
	 */
	public void setScgCrteDyKntCnt(String scgCrteDyKntCnt) {
		this.scgCrteDyKntCnt = scgCrteDyKntCnt;
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
	 * @param delDefCnt
	 */
	public void setDelDefCnt(String delDefCnt) {
		this.delDefCnt = delDefCnt;
	}
	
	/**
	 * Column Info
	 * @param fltPctTpCd
	 */
	public void setFltPctTpCd(String fltPctTpCd) {
		this.fltPctTpCd = fltPctTpCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtUseFlg
	 */
	public void setCmdtUseFlg(String cmdtUseFlg) {
		this.cmdtUseFlg = cmdtUseFlg;
	}
	
	/**
	 * Column Info
	 * @param scgPrdCrteCdCnt
	 */
	public void setScgPrdCrteCdCnt(String scgPrdCrteCdCnt) {
		this.scgPrdCrteCdCnt = scgPrdCrteCdCnt;
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
	 * @param scgPrdTpCdCnt
	 */
	public void setScgPrdTpCdCnt(String scgPrdTpCdCnt) {
		this.scgPrdTpCdCnt = scgPrdTpCdCnt;
	}
	
	/**
	 * Column Info
	 * @param dirCallUseFlg
	 */
	public void setDirCallUseFlg(String dirCallUseFlg) {
		this.dirCallUseFlg = dirCallUseFlg;
	}
	
	/**
	 * Column Info
	 * @param podDefCnt
	 */
	public void setPodDefCnt(String podDefCnt) {
		this.podDefCnt = podDefCnt;
	}
	
	/**
	 * Column Info
	 * @param pctBseCd
	 */
	public void setPctBseCd(String pctBseCd) {
		this.pctBseCd = pctBseCd;
	}
	
	/**
	 * Column Info
	 * @param podUseFlg
	 */
	public void setPodUseFlg(String podUseFlg) {
		this.podUseFlg = podUseFlg;
	}
	
	/**
	 * Column Info
	 * @param porUseFlg
	 */
	public void setPorUseFlg(String porUseFlg) {
		this.porUseFlg = porUseFlg;
	}
	
	/**
	 * Column Info
	 * @param cgoWgtCnt
	 */
	public void setCgoWgtCnt(String cgoWgtCnt) {
		this.cgoWgtCnt = cgoWgtCnt;
	}
	
	/**
	 * Column Info
	 * @param ioGaUseFlg
	 */
	public void setIoGaUseFlg(String ioGaUseFlg) {
		this.ioGaUseFlg = ioGaUseFlg;
	}
	
	/**
	 * Column Info
	 * @param imdgClssUseFlg
	 */
	public void setImdgClssUseFlg(String imdgClssUseFlg) {
		this.imdgClssUseFlg = imdgClssUseFlg;
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
	 * @param cnlTzFlg
	 */
	public void setCnlTzFlg(String cnlTzFlg) {
		this.cnlTzFlg = cnlTzFlg;
	}
	
	/**
	 * Column Info
	 * @param igGaCnt
	 */
	public void setIgGaCnt(String igGaCnt) {
		this.igGaCnt = igGaCnt;
	}
	
	/**
	 * Column Info
	 * @param psaNoMngFlg
	 */
	public void setPsaNoMngFlg(String psaNoMngFlg) {
		this.psaNoMngFlg = psaNoMngFlg;
	}
	
	/**
	 * Column Info
	 * @param rcAirCondTpUseFlg
	 */
	public void setRcAirCondTpUseFlg(String rcAirCondTpUseFlg) {
		this.rcAirCondTpUseFlg = rcAirCondTpUseFlg;
	}
	
	/**
	 * Column Info
	 * @param ctrtDtUseFlg
	 */
	public void setCtrtDtUseFlg(String ctrtDtUseFlg) {
		this.ctrtDtUseFlg = ctrtDtUseFlg;
	}
	
	/**
	 * Column Info
	 * @param actRatUseFlg
	 */
	public void setActRatUseFlg(String actRatUseFlg) {
		this.actRatUseFlg = actRatUseFlg;
	}
	
	/**
	 * Column Info
	 * @param prnHdnUseFlg
	 */
	public void setPrnHdnUseFlg(String prnHdnUseFlg) {
		this.prnHdnUseFlg = prnHdnUseFlg;
	}
	
	/**
	 * Column Info
	 * @param steUseFlg
	 */
	public void setSteUseFlg(String steUseFlg) {
		this.steUseFlg = steUseFlg;
	}
	
	/**
	 * Column Info
	 * @param fdGrdUseFlg
	 */
	public void setFdGrdUseFlg(String fdGrdUseFlg) {
		this.fdGrdUseFlg = fdGrdUseFlg;
	}
	
	/**
	 * Column Info
	 * @param usaSvcModUseFlg
	 */
	public void setUsaSvcModUseFlg(String usaSvcModUseFlg) {
		this.usaSvcModUseFlg = usaSvcModUseFlg;
	}
	
	/**
	 * Column Info
	 * @param griCmdtUseFlg
	 */
	public void setGriCmdtUseFlg(String griCmdtUseFlg) {
		this.griCmdtUseFlg = griCmdtUseFlg;
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
	 * @param scgImdgClssCnt
	 */
	public void setScgImdgClssCnt(String scgImdgClssCnt) {
		this.scgImdgClssCnt = scgImdgClssCnt;
	}
	
	/**
	 * Column Info
	 * @param slanUseFlg
	 */
	public void setSlanUseFlg(String slanUseFlg) {
		this.slanUseFlg = slanUseFlg;
	}
	
	/**
	 * Column Info
	 * @param polDefCnt
	 */
	public void setPolDefCnt(String polDefCnt) {
		this.polDefCnt = polDefCnt;
	}
	
	/**
	 * Column Info
	 * @param cgoWgtUseFlg
	 */
	public void setCgoWgtUseFlg(String cgoWgtUseFlg) {
		this.cgoWgtUseFlg = cgoWgtUseFlg;
	}
	
	/**
	 * Column Info
	 * @param tsPortUseFlg
	 */
	public void setTsPortUseFlg(String tsPortUseFlg) {
		this.tsPortUseFlg = tsPortUseFlg;
	}
	
	/**
	 * Column Info
	 * @param usaSvcModCnt
	 */
	public void setUsaSvcModCnt(String usaSvcModCnt) {
		this.usaSvcModCnt = usaSvcModCnt;
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
	 * @param delUseFlg
	 */
	public void setDelUseFlg(String delUseFlg) {
		this.delUseFlg = delUseFlg;
	}
	
	/**
	 * Column Info
	 * @param griCmdtCnt
	 */
	public void setGriCmdtCnt(String griCmdtCnt) {
		this.griCmdtCnt = griCmdtCnt;
	}
	
	/**
	 * Column Info
	 * @param trnsModCnt
	 */
	public void setTrnsModCnt(String trnsModCnt) {
		this.trnsModCnt = trnsModCnt;
	}
	
	/**
	 * Column Info
	 * @param trnsModUseFlg
	 */
	public void setTrnsModUseFlg(String trnsModUseFlg) {
		this.trnsModUseFlg = trnsModUseFlg;
	}
	
	/**
	 * Column Info
	 * @param cnlTzCnt
	 */
	public void setCnlTzCnt(String cnlTzCnt) {
		this.cnlTzCnt = cnlTzCnt;
	}
	
	/**
	 * Column Info
	 * @param subTrdUseFlg
	 */
	public void setSubTrdUseFlg(String subTrdUseFlg) {
		this.subTrdUseFlg = subTrdUseFlg;
	}
	
	/**
	 * Column Info
	 * @param psaNoCnt
	 */
	public void setPsaNoCnt(String psaNoCnt) {
		this.psaNoCnt = psaNoCnt;
	}
	
	/**
	 * Column Info
	 * @param rcAirCondTpCnt
	 */
	public void setRcAirCondTpCnt(String rcAirCondTpCnt) {
		this.rcAirCondTpCnt = rcAirCondTpCnt;
	}
	
	/**
	 * Column Info
	 * @param ctrtDtCnt
	 */
	public void setCtrtDtCnt(String ctrtDtCnt) {
		this.ctrtDtCnt = ctrtDtCnt;
	}
	
	/**
	 * Column Info
	 * @param actRatCnt
	 */
	public void setActRatCnt(String actRatCnt) {
		this.actRatCnt = actRatCnt;
	}
	
	/**
	 * Column Info
	 * @param prnHdnCnt
	 */
	public void setPrnHdnCnt(String prnHdnCnt) {
		this.prnHdnCnt = prnHdnCnt;
	}
	
	/**
	 * Column Info
	 * @param steCdCnt
	 */
	public void setSteCdCnt(String steCdCnt) {
		this.steCdCnt = steCdCnt;
	}
	
	/**
	 * Column Info
	 * @param fdGrdCnt
	 */
	public void setFdGrdCnt(String fdGrdCnt) {
		this.fdGrdCnt = fdGrdCnt;
	}
	
	/**
	 * Column Info
	 * @param arrDtUseFlg
	 */
	public void setArrDtUseFlg(String arrDtUseFlg) {
			this.arrDtUseFlg = arrDtUseFlg;
	}

	/**
	 * Column Info
	 * @param arrDtCnt
	 */
	public void setArrDtCnt(String arrDtCnt) {
		this.arrDtCnt = arrDtCnt;
	}

	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
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
		setTsPortCnt(JSPUtil.getParameter(request, prefix + "ts_port_cnt", ""));
		setSocUseFlg(JSPUtil.getParameter(request, prefix + "soc_use_flg", ""));
		setSocCnt(JSPUtil.getParameter(request, prefix + "soc_cnt", ""));
		setTmlCnt(JSPUtil.getParameter(request, prefix + "tml_cnt", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setCrteDyKntUseFlg(JSPUtil.getParameter(request, prefix + "crte_dy_knt_use_flg", ""));
		setSubTrdCnt(JSPUtil.getParameter(request, prefix + "sub_trd_cnt", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDirCallCnt(JSPUtil.getParameter(request, prefix + "dir_call_cnt", ""));
		setCmdtCnt(JSPUtil.getParameter(request, prefix + "cmdt_cnt", ""));
		setRcvDeTermUseFlg(JSPUtil.getParameter(request, prefix + "rcv_de_term_use_flg", ""));
		setTmlUseFlg(JSPUtil.getParameter(request, prefix + "tml_use_flg", ""));
		setPorDefCnt(JSPUtil.getParameter(request, prefix + "por_def_cnt", ""));
		setPolUseFlg(JSPUtil.getParameter(request, prefix + "pol_use_flg", ""));
		setPrdCrteUseFlg(JSPUtil.getParameter(request, prefix + "prd_crte_use_flg", ""));
		setVslSlanCnt(JSPUtil.getParameter(request, prefix + "vsl_slan_cnt", ""));
		setRcvDeTermCnt(JSPUtil.getParameter(request, prefix + "rcv_de_term_cnt", ""));
		setHngrBarUseFlg(JSPUtil.getParameter(request, prefix + "hngr_bar_use_flg", ""));
		setPrdCrteTpUseFlg(JSPUtil.getParameter(request, prefix + "prd_crte_tp_use_flg", ""));
		setHngrBarCnt(JSPUtil.getParameter(request, prefix + "hngr_bar_cnt", ""));
		setScgCrteDyKntCnt(JSPUtil.getParameter(request, prefix + "scg_crte_dy_knt_cnt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setDelDefCnt(JSPUtil.getParameter(request, prefix + "del_def_cnt", ""));
		setFltPctTpCd(JSPUtil.getParameter(request, prefix + "flt_pct_tp_cd", ""));
		setCmdtUseFlg(JSPUtil.getParameter(request, prefix + "cmdt_use_flg", ""));
		setScgPrdCrteCdCnt(JSPUtil.getParameter(request, prefix + "scg_prd_crte_cd_cnt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setScgPrdTpCdCnt(JSPUtil.getParameter(request, prefix + "scg_prd_tp_cd_cnt", ""));
		setDirCallUseFlg(JSPUtil.getParameter(request, prefix + "dir_call_use_flg", ""));
		setPodDefCnt(JSPUtil.getParameter(request, prefix + "pod_def_cnt", ""));
		setPctBseCd(JSPUtil.getParameter(request, prefix + "pct_bse_cd", ""));
		setPodUseFlg(JSPUtil.getParameter(request, prefix + "pod_use_flg", ""));
		setPorUseFlg(JSPUtil.getParameter(request, prefix + "por_use_flg", ""));
		setCgoWgtCnt(JSPUtil.getParameter(request, prefix + "cgo_wgt_cnt", ""));
		setIoGaUseFlg(JSPUtil.getParameter(request, prefix + "io_ga_use_flg", ""));
		setImdgClssUseFlg(JSPUtil.getParameter(request, prefix + "imdg_clss_use_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCnlTzFlg(JSPUtil.getParameter(request, prefix + "cnl_tz_flg", ""));
		setIgGaCnt(JSPUtil.getParameter(request, prefix + "ig_ga_cnt", ""));
		setPsaNoMngFlg(JSPUtil.getParameter(request, prefix + "psa_no_mng_flg", ""));
		setRcAirCondTpUseFlg(JSPUtil.getParameter(request, prefix + "rc_air_cond_tp_use_flg", ""));
		setCtrtDtUseFlg(JSPUtil.getParameter(request, prefix + "ctrt_dt_use_flg", ""));
		setActRatUseFlg(JSPUtil.getParameter(request, prefix + "act_rat_use_flg", ""));
		setPrnHdnUseFlg(JSPUtil.getParameter(request, prefix + "prn_hdn_use_flg", ""));
		setSteUseFlg(JSPUtil.getParameter(request, prefix + "ste_use_flg", ""));
		setFdGrdUseFlg(JSPUtil.getParameter(request, prefix + "fd_grd_use_flg", ""));
		setUsaSvcModUseFlg(JSPUtil.getParameter(request, prefix + "usa_svc_mod_use_flg", ""));
		setGriCmdtUseFlg(JSPUtil.getParameter(request, prefix + "gri_cmdt_use_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setScgImdgClssCnt(JSPUtil.getParameter(request, prefix + "scg_imdg_clss_cnt", ""));
		setSlanUseFlg(JSPUtil.getParameter(request, prefix + "slan_use_flg", ""));
		setPolDefCnt(JSPUtil.getParameter(request, prefix + "pol_def_cnt", ""));
		setCgoWgtUseFlg(JSPUtil.getParameter(request, prefix + "cgo_wgt_use_flg", ""));
		setTsPortUseFlg(JSPUtil.getParameter(request, prefix + "ts_port_use_flg", ""));
		setUsaSvcModCnt(JSPUtil.getParameter(request, prefix + "usa_svc_mod_cnt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setDelUseFlg(JSPUtil.getParameter(request, prefix + "del_use_flg", ""));
		setGriCmdtCnt(JSPUtil.getParameter(request, prefix + "gri_cmdt_cnt", ""));
		setTrnsModCnt(JSPUtil.getParameter(request, prefix + "trns_mod_cnt", ""));
		setTrnsModUseFlg(JSPUtil.getParameter(request, prefix + "trns_mod_use_flg", ""));
		setCnlTzCnt(JSPUtil.getParameter(request, prefix + "cnl_tz_cnt", ""));
		setSubTrdUseFlg(JSPUtil.getParameter(request, prefix + "sub_trd_use_flg", ""));
		setPsaNoCnt(JSPUtil.getParameter(request, prefix + "psa_no_cnt", ""));
		setRcAirCondTpCnt(JSPUtil.getParameter(request, prefix + "rc_air_cond_tp_cnt", ""));
		setCtrtDtCnt(JSPUtil.getParameter(request, prefix + "ctrt_dt_cnt", ""));
		setActRatCnt(JSPUtil.getParameter(request, prefix + "act_rat_cnt", ""));
		setPrnHdnCnt(JSPUtil.getParameter(request, prefix + "prn_hdn_cnt", ""));
		setSteCdCnt(JSPUtil.getParameter(request, prefix + "ste_cd_cnt", ""));
		setFdGrdCnt(JSPUtil.getParameter(request, prefix + "fd_grd_cnt", ""));
		setArrDtCnt(JSPUtil.getParameter(request, prefix + "arr_dt_cnt", ""));
		setArrDtUseFlg(JSPUtil.getParameter(request, prefix + "arr_dt_use_flg", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriScgPrfVO[]
	 */
	public PriScgPrfVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PriScgPrfVO[]
	 */
	public PriScgPrfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PriScgPrfVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] tsPortCnt = (JSPUtil.getParameter(request, prefix	+ "ts_port_cnt", length));
			String[] socUseFlg = (JSPUtil.getParameter(request, prefix	+ "soc_use_flg", length));
			String[] socCnt = (JSPUtil.getParameter(request, prefix	+ "soc_cnt", length));
			String[] tmlCnt = (JSPUtil.getParameter(request, prefix	+ "tml_cnt", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] crteDyKntUseFlg = (JSPUtil.getParameter(request, prefix	+ "crte_dy_knt_use_flg", length));
			String[] subTrdCnt = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cnt", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dirCallCnt = (JSPUtil.getParameter(request, prefix	+ "dir_call_cnt", length));
			String[] cmdtCnt = (JSPUtil.getParameter(request, prefix	+ "cmdt_cnt", length));
			String[] rcvDeTermUseFlg = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_use_flg", length));
			String[] tmlUseFlg = (JSPUtil.getParameter(request, prefix	+ "tml_use_flg", length));
			String[] porDefCnt = (JSPUtil.getParameter(request, prefix	+ "por_def_cnt", length));
			String[] polUseFlg = (JSPUtil.getParameter(request, prefix	+ "pol_use_flg", length));
			String[] prdCrteUseFlg = (JSPUtil.getParameter(request, prefix	+ "prd_crte_use_flg", length));
			String[] vslSlanCnt = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cnt", length));
			String[] rcvDeTermCnt = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_cnt", length));
			String[] hngrBarUseFlg = (JSPUtil.getParameter(request, prefix	+ "hngr_bar_use_flg", length));
			String[] prdCrteTpUseFlg = (JSPUtil.getParameter(request, prefix	+ "prd_crte_tp_use_flg", length));
			String[] hngrBarCnt = (JSPUtil.getParameter(request, prefix	+ "hngr_bar_cnt", length));
			String[] scgCrteDyKntCnt = (JSPUtil.getParameter(request, prefix	+ "scg_crte_dy_knt_cnt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] delDefCnt = (JSPUtil.getParameter(request, prefix	+ "del_def_cnt", length));
			String[] fltPctTpCd = (JSPUtil.getParameter(request, prefix	+ "flt_pct_tp_cd", length));
			String[] cmdtUseFlg = (JSPUtil.getParameter(request, prefix	+ "cmdt_use_flg", length));
			String[] scgPrdCrteCdCnt = (JSPUtil.getParameter(request, prefix	+ "scg_prd_crte_cd_cnt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] scgPrdTpCdCnt = (JSPUtil.getParameter(request, prefix	+ "scg_prd_tp_cd_cnt", length));
			String[] dirCallUseFlg = (JSPUtil.getParameter(request, prefix	+ "dir_call_use_flg", length));
			String[] podDefCnt = (JSPUtil.getParameter(request, prefix	+ "pod_def_cnt", length));
			String[] pctBseCd = (JSPUtil.getParameter(request, prefix	+ "pct_bse_cd", length));
			String[] podUseFlg = (JSPUtil.getParameter(request, prefix	+ "pod_use_flg", length));
			String[] porUseFlg = (JSPUtil.getParameter(request, prefix	+ "por_use_flg", length));
			String[] cgoWgtCnt = (JSPUtil.getParameter(request, prefix	+ "cgo_wgt_cnt", length));
			String[] ioGaUseFlg = (JSPUtil.getParameter(request, prefix	+ "io_ga_use_flg", length));
			String[] imdgClssUseFlg = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_use_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] cnlTzFlg = (JSPUtil.getParameter(request, prefix	+ "cnl_tz_flg", length));
			String[] igGaCnt = (JSPUtil.getParameter(request, prefix	+ "ig_ga_cnt", length));
			String[] psaNoMngFlg = (JSPUtil.getParameter(request, prefix	+ "psa_no_mng_flg", length));
			String[] rcAirCondTpUseFlg = (JSPUtil.getParameter(request, prefix	+ "rc_air_cond_tp_use_flg", length));
			String[] ctrtDtUseFlg = (JSPUtil.getParameter(request, prefix	+ "ctrt_dt_use_flg", length));
			String[] actRatUseFlg = (JSPUtil.getParameter(request, prefix	+ "act_rat_use_flg", length));
			String[] prnHdnUseFlg = (JSPUtil.getParameter(request, prefix	+ "prn_hdn_use_flg", length));
			String[] steUseFlg = (JSPUtil.getParameter(request, prefix	+ "ste_use_flg", length));
			String[] fdGrdUseFlg = (JSPUtil.getParameter(request, prefix	+ "fd_grd_use_flg", length));
			String[] usaSvcModUseFlg = (JSPUtil.getParameter(request, prefix	+ "usa_svc_mod_use_flg", length));
			String[] griCmdtUseFlg = (JSPUtil.getParameter(request, prefix	+ "gri_cmdt_use_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] scgImdgClssCnt = (JSPUtil.getParameter(request, prefix	+ "scg_imdg_clss_cnt", length));
			String[] slanUseFlg = (JSPUtil.getParameter(request, prefix	+ "slan_use_flg", length));
			String[] polDefCnt = (JSPUtil.getParameter(request, prefix	+ "pol_def_cnt", length));
			String[] cgoWgtUseFlg = (JSPUtil.getParameter(request, prefix	+ "cgo_wgt_use_flg", length));
			String[] tsPortUseFlg = (JSPUtil.getParameter(request, prefix	+ "ts_port_use_flg", length));
			String[] usaSvcModCnt = (JSPUtil.getParameter(request, prefix	+ "usa_svc_mod_cnt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] delUseFlg = (JSPUtil.getParameter(request, prefix	+ "del_use_flg", length));
			String[] griCmdtCnt = (JSPUtil.getParameter(request, prefix	+ "gri_cmdt_cnt", length));
			String[] trnsModCnt = (JSPUtil.getParameter(request, prefix	+ "trns_mod_cnt", length));
			String[] trnsModUseFlg = (JSPUtil.getParameter(request, prefix	+ "trns_mod_use_flg", length));
			String[] cnlTzCnt = (JSPUtil.getParameter(request, prefix	+ "cnl_tz_cnt", length));
			String[] subTrdUseFlg = (JSPUtil.getParameter(request, prefix	+ "sub_trd_use_flg", length));
			String[] psaNoCnt = (JSPUtil.getParameter(request, prefix	+ "psa_no_cnt", length));
			String[] rcAirCondTpCnt = (JSPUtil.getParameter(request, prefix	+ "rc_air_cond_tp_cnt", length));
			String[] ctrtDtCnt = (JSPUtil.getParameter(request, prefix	+ "ctrt_dt_cnt", length));
			String[] actRatCnt = (JSPUtil.getParameter(request, prefix	+ "act_rat_cnt", length));
			String[] prnHdnCnt = (JSPUtil.getParameter(request, prefix	+ "prn_hdn_cnt", length));
			String[] steCdCnt = (JSPUtil.getParameter(request, prefix	+ "ste_cd_cnt", length));
			String[] fdGrdCnt = (JSPUtil.getParameter(request, prefix	+ "fd_grd_cnt", length));
			String[] arrDtCnt = (JSPUtil.getParameter(request, prefix	+ "arr_dt_cnt", length));
			String[] arrDtUseFlg = (JSPUtil.getParameter(request, prefix	+ "arr_dt_use_flg", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new PriScgPrfVO();
				if (tsPortCnt[i] != null)
					model.setTsPortCnt(tsPortCnt[i]);
				if (socUseFlg[i] != null)
					model.setSocUseFlg(socUseFlg[i]);
				if (socCnt[i] != null)
					model.setSocCnt(socCnt[i]);
				if (tmlCnt[i] != null)
					model.setTmlCnt(tmlCnt[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (crteDyKntUseFlg[i] != null)
					model.setCrteDyKntUseFlg(crteDyKntUseFlg[i]);
				if (subTrdCnt[i] != null)
					model.setSubTrdCnt(subTrdCnt[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dirCallCnt[i] != null)
					model.setDirCallCnt(dirCallCnt[i]);
				if (cmdtCnt[i] != null)
					model.setCmdtCnt(cmdtCnt[i]);
				if (rcvDeTermUseFlg[i] != null)
					model.setRcvDeTermUseFlg(rcvDeTermUseFlg[i]);
				if (tmlUseFlg[i] != null)
					model.setTmlUseFlg(tmlUseFlg[i]);
				if (porDefCnt[i] != null)
					model.setPorDefCnt(porDefCnt[i]);
				if (polUseFlg[i] != null)
					model.setPolUseFlg(polUseFlg[i]);
				if (prdCrteUseFlg[i] != null)
					model.setPrdCrteUseFlg(prdCrteUseFlg[i]);
				if (vslSlanCnt[i] != null)
					model.setVslSlanCnt(vslSlanCnt[i]);
				if (rcvDeTermCnt[i] != null)
					model.setRcvDeTermCnt(rcvDeTermCnt[i]);
				if (hngrBarUseFlg[i] != null)
					model.setHngrBarUseFlg(hngrBarUseFlg[i]);
				if (prdCrteTpUseFlg[i] != null)
					model.setPrdCrteTpUseFlg(prdCrteTpUseFlg[i]);
				if (hngrBarCnt[i] != null)
					model.setHngrBarCnt(hngrBarCnt[i]);
				if (scgCrteDyKntCnt[i] != null)
					model.setScgCrteDyKntCnt(scgCrteDyKntCnt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (delDefCnt[i] != null)
					model.setDelDefCnt(delDefCnt[i]);
				if (fltPctTpCd[i] != null)
					model.setFltPctTpCd(fltPctTpCd[i]);
				if (cmdtUseFlg[i] != null)
					model.setCmdtUseFlg(cmdtUseFlg[i]);
				if (scgPrdCrteCdCnt[i] != null)
					model.setScgPrdCrteCdCnt(scgPrdCrteCdCnt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (scgPrdTpCdCnt[i] != null)
					model.setScgPrdTpCdCnt(scgPrdTpCdCnt[i]);
				if (dirCallUseFlg[i] != null)
					model.setDirCallUseFlg(dirCallUseFlg[i]);
				if (podDefCnt[i] != null)
					model.setPodDefCnt(podDefCnt[i]);
				if (pctBseCd[i] != null)
					model.setPctBseCd(pctBseCd[i]);
				if (podUseFlg[i] != null)
					model.setPodUseFlg(podUseFlg[i]);
				if (porUseFlg[i] != null)
					model.setPorUseFlg(porUseFlg[i]);
				if (cgoWgtCnt[i] != null)
					model.setCgoWgtCnt(cgoWgtCnt[i]);
				if (ioGaUseFlg[i] != null)
					model.setIoGaUseFlg(ioGaUseFlg[i]);
				if (imdgClssUseFlg[i] != null)
					model.setImdgClssUseFlg(imdgClssUseFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (cnlTzFlg[i] != null)
					model.setCnlTzFlg(cnlTzFlg[i]);
				if (igGaCnt[i] != null)
					model.setIgGaCnt(igGaCnt[i]);
				if (psaNoMngFlg[i] != null)
					model.setPsaNoMngFlg(psaNoMngFlg[i]);
				if (rcAirCondTpUseFlg[i] != null)
					model.setRcAirCondTpUseFlg(rcAirCondTpUseFlg[i]);
				if (ctrtDtUseFlg[i] != null)
					model.setCtrtDtUseFlg(ctrtDtUseFlg[i]);
				if (actRatUseFlg[i] != null)
					model.setActRatUseFlg(actRatUseFlg[i]);
				if (prnHdnUseFlg[i] != null)
					model.setPrnHdnUseFlg(prnHdnUseFlg[i]);
				if (steUseFlg[i] != null)
					model.setSteUseFlg(steUseFlg[i]);
				if (fdGrdUseFlg[i] != null)
					model.setFdGrdUseFlg(fdGrdUseFlg[i]);
				if (arrDtUseFlg[i] != null)
					model.setArrDtUseFlg(arrDtUseFlg[i]);
				if (usaSvcModUseFlg[i] != null)
					model.setUsaSvcModUseFlg(usaSvcModUseFlg[i]);
				if (griCmdtUseFlg[i] != null)
					model.setGriCmdtUseFlg(griCmdtUseFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (scgImdgClssCnt[i] != null)
					model.setScgImdgClssCnt(scgImdgClssCnt[i]);
				if (slanUseFlg[i] != null)
					model.setSlanUseFlg(slanUseFlg[i]);
				if (polDefCnt[i] != null)
					model.setPolDefCnt(polDefCnt[i]);
				if (cgoWgtUseFlg[i] != null)
					model.setCgoWgtUseFlg(cgoWgtUseFlg[i]);
				if (tsPortUseFlg[i] != null)
					model.setTsPortUseFlg(tsPortUseFlg[i]);
				if (usaSvcModCnt[i] != null)
					model.setUsaSvcModCnt(usaSvcModCnt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (delUseFlg[i] != null)
					model.setDelUseFlg(delUseFlg[i]);
				if (griCmdtCnt[i] != null)
					model.setGriCmdtCnt(griCmdtCnt[i]);
				if (trnsModCnt[i] != null)
					model.setTrnsModCnt(trnsModCnt[i]);
				if (trnsModUseFlg[i] != null)
					model.setTrnsModUseFlg(trnsModUseFlg[i]);
				if (cnlTzCnt[i] != null)
					model.setCnlTzCnt(cnlTzCnt[i]);
				if (subTrdUseFlg[i] != null)
					model.setSubTrdUseFlg(subTrdUseFlg[i]);
				if (psaNoCnt[i] != null)
					model.setPsaNoCnt(psaNoCnt[i]);
				if (rcAirCondTpCnt[i] != null)
					model.setRcAirCondTpCnt(rcAirCondTpCnt[i]);
				if (ctrtDtCnt[i] != null)
					model.setCtrtDtCnt(ctrtDtCnt[i]);
				if (actRatCnt[i] != null)
					model.setActRatCnt(actRatCnt[i]);
				if (prnHdnCnt[i] != null)
					model.setPrnHdnCnt(prnHdnCnt[i]);
				if (steCdCnt[i] != null)
					model.setSteCdCnt(steCdCnt[i]);
				if (fdGrdCnt[i] != null)
					model.setFdGrdCnt(fdGrdCnt[i]);
				if (arrDtCnt[i] != null)
					model.setArrDtCnt(arrDtCnt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPriScgPrfVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PriScgPrfVO[]
	 */
	public PriScgPrfVO[] getPriScgPrfVOs(){
		PriScgPrfVO[] vos = (PriScgPrfVO[])models.toArray(new PriScgPrfVO[models.size()]);
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
		this.tsPortCnt = this.tsPortCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socUseFlg = this.socUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socCnt = this.socCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCnt = this.tmlCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crteDyKntUseFlg = this.crteDyKntUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCnt = this.subTrdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCallCnt = this.dirCallCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCnt = this.cmdtCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermUseFlg = this.rcvDeTermUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlUseFlg = this.tmlUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porDefCnt = this.porDefCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polUseFlg = this.polUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prdCrteUseFlg = this.prdCrteUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCnt = this.vslSlanCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermCnt = this.rcvDeTermCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hngrBarUseFlg = this.hngrBarUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prdCrteTpUseFlg = this.prdCrteTpUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hngrBarCnt = this.hngrBarCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgCrteDyKntCnt = this.scgCrteDyKntCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delDefCnt = this.delDefCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fltPctTpCd = this.fltPctTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtUseFlg = this.cmdtUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgPrdCrteCdCnt = this.scgPrdCrteCdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgPrdTpCdCnt = this.scgPrdTpCdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCallUseFlg = this.dirCallUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podDefCnt = this.podDefCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctBseCd = this.pctBseCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podUseFlg = this.podUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porUseFlg = this.porUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoWgtCnt = this.cgoWgtCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioGaUseFlg = this.ioGaUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssUseFlg = this.imdgClssUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnlTzFlg = this.cnlTzFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.igGaCnt = this.igGaCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaNoMngFlg = this.psaNoMngFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcAirCondTpUseFlg = this.rcAirCondTpUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtDtUseFlg = this.ctrtDtUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actRatUseFlg = this.actRatUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prnHdnUseFlg = this.prnHdnUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steUseFlg = this.steUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdGrdUseFlg = this.fdGrdUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrDtUseFlg = this.arrDtUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaSvcModUseFlg = this.usaSvcModUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.griCmdtUseFlg = this.griCmdtUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgImdgClssCnt = this.scgImdgClssCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanUseFlg = this.slanUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polDefCnt = this.polDefCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoWgtUseFlg = this.cgoWgtUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsPortUseFlg = this.tsPortUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaSvcModCnt = this.usaSvcModCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delUseFlg = this.delUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.griCmdtCnt = this.griCmdtCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsModCnt = this.trnsModCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsModUseFlg = this.trnsModUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnlTzCnt = this.cnlTzCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdUseFlg = this.subTrdUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaNoCnt = this.psaNoCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcAirCondTpCnt = this.rcAirCondTpCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtDtCnt = this.ctrtDtCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actRatCnt = this.actRatCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prnHdnCnt = this.prnHdnCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steCdCnt = this.steCdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdGrdCnt = this.fdGrdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrDtCnt = this.arrDtCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
