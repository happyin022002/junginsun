/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CstPriScgRtVO.java
*@FileTitle : CstPriScgRtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.07
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2012.03.07 서미진 
* 1.0 Creation
* 2013.03.07 전윤주 [CHM-201323465] rc_air_cond_tp_cd 추가
* 2013.04.17 전윤주 [CHM-201324203] ctrt_dt 추가
* 2013.10.01 전윤주 [CHM-201326927] act_rat_flg 추가
* 2013.10.01 전윤주 [CHM-201326929] prn_hdn_flg 추가
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

public class CstPriScgRtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CstPriScgRtVO> models = new ArrayList<CstPriScgRtVO>();
	
	/* Column Info */
	private String scgRmk = null;
	/* Column Info */
	private String scgPrdTpCd = null;
	/* Column Info */
	private String scgImdgClssCd = null;
	/* Column Info */
	private String orgTrspModCd = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String payTermCd = null;
	/* Column Info */
	private String psaNo = null;
	/* Column Info */
	private String rcAirCondTpCd = null;
	/* Column Info */
	private String ctrtDt = null;
	/* Column Info */
	private String actRatFlg = null;
	/* Column Info */
	private String prnHdnFlg = null;
	/* Column Info */
	private String steCd = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String fdGrdFlg = null;
	/* Column Info */
	private String arrDt = null;
	/* Column Info */
	private String lvl2 = null;
	/* Column Info */
	private String tmlCd = null;
	/* Column Info */
	private String lvl3 = null;
	/* Column Info */
	private String lvl4 = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String delDefCd = null;
	/* Column Info */
	private String lvl1 = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String destTrspModCd = null;
	/* Column Info */
	private String scgCrteDyKnt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String delTpCd = null;
	/* Column Info */
	private String dirCallFlg = null;
	/* Column Info */
	private String prcDeTermCd = null;
	/* Column Info */
	private String scgPrdCrteCd = null;
	/* Column Info */
	private String ioGaCd = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String podDefCd = null;
	/* Column Info */
	private String porTpCd = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String polTpCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String prcCgoTpCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String wdrFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String polDefCd = null;
	/* Column Info */
	private String usaSvcModCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String cnlTzCd = null;
	/* Column Info */
	private String maxCgoWgt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String tsPortCd = null;
	/* Column Info */
	private String podTpCd = null;
	/* Column Info */
	private String scgSeq = null;
	/* Column Info */
	private String porDefCd = null;
	/* Column Info */
	private String scgGrpCmdtCd = null;
	/* Column Info */
	private String prcRcvTermCd = null;
	/* Column Info */
	private String socFlg = null;
	/* Column Info */
	private String prcHngrBarTpCd = null;
	/* Column Info */
	private String minCgoWgt = null;
	/* Column Info */
	private String scgAmt = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String updUsrNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CstPriScgRtVO() {}

	public CstPriScgRtVO(String ibflag, String pagerows, String scgRmk, String scgImdgClssCd, String orgTrspModCd, String svcScpCd, String payTermCd, String lvl2, String tmlCd, String lvl3, String lvl4, String chgCd, String delDefCd, String effDt, String lvl1, String destTrspModCd, String delTpCd, String updUsrId, String dirCallFlg, String prcDeTermCd, String ioGaCd, String ratUtCd, String creUsrId, String podDefCd, String porTpCd, String subTrdCd, String polTpCd, String currCd, String prcCgoTpCd, String deltFlg, String wdrFlg, String creDt, String vslSlanCd, String polDefCd, String usaSvcModCd, String cmdtCd, String expDt, String cnlTzCd, String maxCgoWgt, String updDt, String tsPortCd, String podTpCd, String scgSeq, String porDefCd, String scgGrpCmdtCd, String prcRcvTermCd, String socFlg, String prcHngrBarTpCd, String minCgoWgt, String scgAmt, String seq, String updUsrNm, String scgCrteDyKnt, String scgPrdTpCd, String scgPrdCrteCd, String psaNo, String rcAirCondTpCd, String ctrtDt, String actRatFlg, String prnHdnFlg, String steCd, String cntCd, String fdGrdFlg, String arrDt) {
		this.scgRmk = scgRmk;
		this.scgPrdTpCd = scgPrdTpCd;
		this.scgImdgClssCd = scgImdgClssCd;
		this.orgTrspModCd = orgTrspModCd;
		this.svcScpCd = svcScpCd;
		this.payTermCd = payTermCd;
		this.psaNo = psaNo;
		this.rcAirCondTpCd = rcAirCondTpCd;
		this.ctrtDt = ctrtDt;
		this.actRatFlg = actRatFlg;
		this.prnHdnFlg = prnHdnFlg;
		this.steCd = steCd;
		this.cntCd = cntCd;
		this.fdGrdFlg = fdGrdFlg;
		this.arrDt = arrDt;
		this.lvl2 = lvl2;
		this.tmlCd = tmlCd;
		this.lvl3 = lvl3;
		this.lvl4 = lvl4;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.delDefCd = delDefCd;
		this.lvl1 = lvl1;
		this.effDt = effDt;
		this.destTrspModCd = destTrspModCd;
		this.scgCrteDyKnt = scgCrteDyKnt;
		this.updUsrId = updUsrId;
		this.delTpCd = delTpCd;
		this.dirCallFlg = dirCallFlg;
		this.prcDeTermCd = prcDeTermCd;
		this.scgPrdCrteCd = scgPrdCrteCd;
		this.ioGaCd = ioGaCd;
		this.ratUtCd = ratUtCd;
		this.creUsrId = creUsrId;
		this.podDefCd = podDefCd;
		this.porTpCd = porTpCd;
		this.subTrdCd = subTrdCd;
		this.polTpCd = polTpCd;
		this.currCd = currCd;
		this.prcCgoTpCd = prcCgoTpCd;
		this.deltFlg = deltFlg;
		this.wdrFlg = wdrFlg;
		this.creDt = creDt;
		this.vslSlanCd = vslSlanCd;
		this.polDefCd = polDefCd;
		this.usaSvcModCd = usaSvcModCd;
		this.ibflag = ibflag;
		this.cmdtCd = cmdtCd;
		this.expDt = expDt;
		this.cnlTzCd = cnlTzCd;
		this.maxCgoWgt = maxCgoWgt;
		this.updDt = updDt;
		this.tsPortCd = tsPortCd;
		this.podTpCd = podTpCd;
		this.scgSeq = scgSeq;
		this.porDefCd = porDefCd;
		this.scgGrpCmdtCd = scgGrpCmdtCd;
		this.prcRcvTermCd = prcRcvTermCd;
		this.socFlg = socFlg;
		this.prcHngrBarTpCd = prcHngrBarTpCd;
		this.minCgoWgt = minCgoWgt;
		this.scgAmt = scgAmt;
		this.seq = seq;
		this.updUsrNm = updUsrNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("scg_rmk", getScgRmk());
		this.hashColumns.put("scg_prd_tp_cd", getScgPrdTpCd());
		this.hashColumns.put("scg_imdg_clss_cd", getScgImdgClssCd());
		this.hashColumns.put("org_trsp_mod_cd", getOrgTrspModCd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("pay_term_cd", getPayTermCd());
		this.hashColumns.put("psa_no", getPsaNo());
		this.hashColumns.put("rc_air_cond_tp_cd", getRcAirCondTpCd());
		this.hashColumns.put("ctrt_dt", getCtrtDt());
		this.hashColumns.put("act_rat_flg", getActRatFlg());
		this.hashColumns.put("prn_hdn_flg", getPrnHdnFlg());
		this.hashColumns.put("ste_cd", getSteCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("fd_grd_flg", getFdGrdFlg());
		this.hashColumns.put("arr_dt", getArrDt());
		this.hashColumns.put("lvl2", getLvl2());
		this.hashColumns.put("tml_cd", getTmlCd());
		this.hashColumns.put("lvl3", getLvl3());
		this.hashColumns.put("lvl4", getLvl4());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("del_def_cd", getDelDefCd());
		this.hashColumns.put("lvl1", getLvl1());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("dest_trsp_mod_cd", getDestTrspModCd());
		this.hashColumns.put("scg_crte_dy_knt", getScgCrteDyKnt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("del_tp_cd", getDelTpCd());
		this.hashColumns.put("dir_call_flg", getDirCallFlg());
		this.hashColumns.put("prc_de_term_cd", getPrcDeTermCd());
		this.hashColumns.put("scg_prd_crte_cd", getScgPrdCrteCd());
		this.hashColumns.put("io_ga_cd", getIoGaCd());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("pod_def_cd", getPodDefCd());
		this.hashColumns.put("por_tp_cd", getPorTpCd());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("pol_tp_cd", getPolTpCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("prc_cgo_tp_cd", getPrcCgoTpCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("wdr_flg", getWdrFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("pol_def_cd", getPolDefCd());
		this.hashColumns.put("usa_svc_mod_cd", getUsaSvcModCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("cnl_tz_cd", getCnlTzCd());
		this.hashColumns.put("max_cgo_wgt", getMaxCgoWgt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ts_port_cd", getTsPortCd());
		this.hashColumns.put("pod_tp_cd", getPodTpCd());
		this.hashColumns.put("scg_seq", getScgSeq());
		this.hashColumns.put("por_def_cd", getPorDefCd());
		this.hashColumns.put("scg_grp_cmdt_cd", getScgGrpCmdtCd());
		this.hashColumns.put("prc_rcv_term_cd", getPrcRcvTermCd());
		this.hashColumns.put("soc_flg", getSocFlg());
		this.hashColumns.put("prc_hngr_bar_tp_cd", getPrcHngrBarTpCd());
		this.hashColumns.put("min_cgo_wgt", getMinCgoWgt());
		this.hashColumns.put("scg_amt", getScgAmt());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("upd_usr_nm", getUpdUsrNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("scg_rmk", "scgRmk");
		this.hashFields.put("scg_prd_tp_cd", "scgPrdTpCd");
		this.hashFields.put("scg_imdg_clss_cd", "scgImdgClssCd");
		this.hashFields.put("org_trsp_mod_cd", "orgTrspModCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("pay_term_cd", "payTermCd");
		this.hashFields.put("psa_no", "psaNo");
		this.hashFields.put("rc_air_cond_tp_cd", "rcAirCondTpCd");
		this.hashFields.put("ctrt_dt", "ctrtDt");
		this.hashFields.put("act_rat_flg", "actRatFlg");
		this.hashFields.put("prn_hdn_flg", "prnHdnFlg");
		this.hashFields.put("ste_cd", "steCd");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("fd_grd_flg", "fdGrdFlg");
		this.hashFields.put("arr_dt", "arrDt");
		this.hashFields.put("lvl2", "lvl2");
		this.hashFields.put("tml_cd", "tmlCd");
		this.hashFields.put("lvl3", "lvl3");
		this.hashFields.put("lvl4", "lvl4");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("del_def_cd", "delDefCd");
		this.hashFields.put("lvl1", "lvl1");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("dest_trsp_mod_cd", "destTrspModCd");
		this.hashFields.put("scg_crte_dy_knt", "scgCrteDyKnt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("del_tp_cd", "delTpCd");
		this.hashFields.put("dir_call_flg", "dirCallFlg");
		this.hashFields.put("prc_de_term_cd", "prcDeTermCd");
		this.hashFields.put("scg_prd_crte_cd", "scgPrdCrteCd");
		this.hashFields.put("io_ga_cd", "ioGaCd");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("pod_def_cd", "podDefCd");
		this.hashFields.put("por_tp_cd", "porTpCd");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("pol_tp_cd", "polTpCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("prc_cgo_tp_cd", "prcCgoTpCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("wdr_flg", "wdrFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("pol_def_cd", "polDefCd");
		this.hashFields.put("usa_svc_mod_cd", "usaSvcModCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("cnl_tz_cd", "cnlTzCd");
		this.hashFields.put("max_cgo_wgt", "maxCgoWgt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ts_port_cd", "tsPortCd");
		this.hashFields.put("pod_tp_cd", "podTpCd");
		this.hashFields.put("scg_seq", "scgSeq");
		this.hashFields.put("por_def_cd", "porDefCd");
		this.hashFields.put("scg_grp_cmdt_cd", "scgGrpCmdtCd");
		this.hashFields.put("prc_rcv_term_cd", "prcRcvTermCd");
		this.hashFields.put("soc_flg", "socFlg");
		this.hashFields.put("prc_hngr_bar_tp_cd", "prcHngrBarTpCd");
		this.hashFields.put("min_cgo_wgt", "minCgoWgt");
		this.hashFields.put("scg_amt", "scgAmt");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("upd_usr_nm", "updUsrNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return scgRmk
	 */
	public String getScgRmk() {
		return this.scgRmk;
	}
	
	/**
	 * Column Info
	 * @return scgPrdTpCd
	 */
	public String getScgPrdTpCd() {
		return this.scgPrdTpCd;
	}
	
	/**
	 * Column Info
	 * @return scgImdgClssCd
	 */
	public String getScgImdgClssCd() {
		return this.scgImdgClssCd;
	}
	
	/**
	 * Column Info
	 * @return orgTrspModCd
	 */
	public String getOrgTrspModCd() {
		return this.orgTrspModCd;
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
	 * @return payTermCd
	 */
	public String getPayTermCd() {
		return this.payTermCd;
	}
	
	/**
	 * Column Info
	 * @return psaNo
	 */
	public String getPsaNo() {
		return this.psaNo;
	}
	
	/**
	 * Column Info
	 * @return rcAirCondTpCd
	 */
	public String getRcAirCondTpCd() {
		return this.rcAirCondTpCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtDt
	 */
	public String getCtrtDt() {
		return this.ctrtDt;
	}
	
	/**
	 * Column Info
	 * @return actRatFlg
	 */
	public String getActRatFlg() {
		return this.actRatFlg;
	}
	
	/**
	 * Column Info
	 * @return prnHdnFlg
	 */
	public String getPrnHdnFlg() {
		return this.prnHdnFlg;
	}
	
	/**
	 * Column Info
	 * @return steCd
	 */
	public String getSteCd() {
		return this.steCd;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return fdGrdFlg
	 */
	public String getFdGrdFlg() {
		return this.fdGrdFlg;
	}
	
	public String getArrDt() {
		return arrDt;
	}

	/**
	 * Column Info
	 * @return lvl2
	 */
	public String getLvl2() {
		return this.lvl2;
	}
	
	/**
	 * Column Info
	 * @return tmlCd
	 */
	public String getTmlCd() {
		return this.tmlCd;
	}
	
	/**
	 * Column Info
	 * @return lvl3
	 */
	public String getLvl3() {
		return this.lvl3;
	}
	
	/**
	 * Column Info
	 * @return lvl4
	 */
	public String getLvl4() {
		return this.lvl4;
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
	 * @return delDefCd
	 */
	public String getDelDefCd() {
		return this.delDefCd;
	}
	
	/**
	 * Column Info
	 * @return lvl1
	 */
	public String getLvl1() {
		return this.lvl1;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return destTrspModCd
	 */
	public String getDestTrspModCd() {
		return this.destTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return scgCrteDyKnt
	 */
	public String getScgCrteDyKnt() {
		return this.scgCrteDyKnt;
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
	 * @return delTpCd
	 */
	public String getDelTpCd() {
		return this.delTpCd;
	}
	
	/**
	 * Column Info
	 * @return dirCallFlg
	 */
	public String getDirCallFlg() {
		return this.dirCallFlg;
	}
	
	/**
	 * Column Info
	 * @return prcDeTermCd
	 */
	public String getPrcDeTermCd() {
		return this.prcDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return scgPrdCrteCd
	 */
	public String getScgPrdCrteCd() {
		return this.scgPrdCrteCd;
	}
	
	/**
	 * Column Info
	 * @return ioGaCd
	 */
	public String getIoGaCd() {
		return this.ioGaCd;
	}
	
	/**
	 * Column Info
	 * @return ratUtCd
	 */
	public String getRatUtCd() {
		return this.ratUtCd;
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
	 * @return podDefCd
	 */
	public String getPodDefCd() {
		return this.podDefCd;
	}
	
	/**
	 * Column Info
	 * @return porTpCd
	 */
	public String getPorTpCd() {
		return this.porTpCd;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	
	/**
	 * Column Info
	 * @return polTpCd
	 */
	public String getPolTpCd() {
		return this.polTpCd;
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
	 * @return prcCgoTpCd
	 */
	public String getPrcCgoTpCd() {
		return this.prcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return wdrFlg
	 */
	public String getWdrFlg() {
		return this.wdrFlg;
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
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return polDefCd
	 */
	public String getPolDefCd() {
		return this.polDefCd;
	}
	
	/**
	 * Column Info
	 * @return usaSvcModCd
	 */
	public String getUsaSvcModCd() {
		return this.usaSvcModCd;
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
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return cnlTzCd
	 */
	public String getCnlTzCd() {
		return this.cnlTzCd;
	}
	
	/**
	 * Column Info
	 * @return maxCgoWgt
	 */
	public String getMaxCgoWgt() {
		return this.maxCgoWgt;
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
	 * @return tsPortCd
	 */
	public String getTsPortCd() {
		return this.tsPortCd;
	}
	
	/**
	 * Column Info
	 * @return podTpCd
	 */
	public String getPodTpCd() {
		return this.podTpCd;
	}
	
	/**
	 * Column Info
	 * @return scgSeq
	 */
	public String getScgSeq() {
		return this.scgSeq;
	}
	
	/**
	 * Column Info
	 * @return porDefCd
	 */
	public String getPorDefCd() {
		return this.porDefCd;
	}
	
	/**
	 * Column Info
	 * @return scgGrpCmdtCd
	 */
	public String getScgGrpCmdtCd() {
		return this.scgGrpCmdtCd;
	}
	
	/**
	 * Column Info
	 * @return prcRcvTermCd
	 */
	public String getPrcRcvTermCd() {
		return this.prcRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return socFlg
	 */
	public String getSocFlg() {
		return this.socFlg;
	}
	
	/**
	 * Column Info
	 * @return prcHngrBarTpCd
	 */
	public String getPrcHngrBarTpCd() {
		return this.prcHngrBarTpCd;
	}
	
	/**
	 * Column Info
	 * @return minCgoWgt
	 */
	public String getMinCgoWgt() {
		return this.minCgoWgt;
	}
	
	/**
	 * Column Info
	 * @return scgAmt
	 */
	public String getScgAmt() {
		return this.scgAmt;
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
	 * @return updUsrNm
	 */
	public String getUpdUsrNm() {
		return this.updUsrNm;
	}
	

	/**
	 * Column Info
	 * @param scgRmk
	 */
	public void setScgRmk(String scgRmk) {
		this.scgRmk = scgRmk;
	}
	
	/**
	 * Column Info
	 * @param scgPrdTpCd
	 */
	public void setScgPrdTpCd(String scgPrdTpCd) {
		this.scgPrdTpCd = scgPrdTpCd;
	}
	
	/**
	 * Column Info
	 * @param scgImdgClssCd
	 */
	public void setScgImdgClssCd(String scgImdgClssCd) {
		this.scgImdgClssCd = scgImdgClssCd;
	}
	
	/**
	 * Column Info
	 * @param orgTrspModCd
	 */
	public void setOrgTrspModCd(String orgTrspModCd) {
		this.orgTrspModCd = orgTrspModCd;
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
	 * @param payTermCd
	 */
	public void setPayTermCd(String payTermCd) {
		this.payTermCd = payTermCd;
	}
	
	/**
	 * Column Info
	 * @param psaNo
	 */
	public void setPsaNo(String psaNo) {
		this.psaNo = psaNo;
	}
	
	/**
	 * Column Info
	 * @param rcAirCondTpCd
	 */
	public void setRcAirCondTpCd(String rcAirCondTpCd) {
		this.rcAirCondTpCd = rcAirCondTpCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtDt
	 */
	public void setCtrtDt(String ctrtDt) {
		this.ctrtDt = ctrtDt;
	}
	
	/**
	 * Column Info
	 * @param actRatFlg
	 */
	public void setActRatFlg(String actRatFlg) {
		this.actRatFlg = actRatFlg;
	}
	
	/**
	 * Column Info
	 * @param prnHdnFlg
	 */
	public void setPrnHdnFlg(String prnHdnFlg) {
		this.prnHdnFlg = prnHdnFlg;
	}
	
	/**
	 * Column Info
	 * @param steCd
	 */
	public void setSteCd(String steCd) {
		this.steCd = steCd;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param fdGrdFlg
	 */
	public void setFdGrdFlg(String fdGrdFlg) {
		this.fdGrdFlg = fdGrdFlg;
	}
	
	public void setArrDt(String arrDt) {
		this.arrDt = arrDt;
	}

	/**
	 * Column Info
	 * @param lvl2
	 */
	public void setLvl2(String lvl2) {
		this.lvl2 = lvl2;
	}
	
	/**
	 * Column Info
	 * @param tmlCd
	 */
	public void setTmlCd(String tmlCd) {
		this.tmlCd = tmlCd;
	}
	
	/**
	 * Column Info
	 * @param lvl3
	 */
	public void setLvl3(String lvl3) {
		this.lvl3 = lvl3;
	}
	
	/**
	 * Column Info
	 * @param lvl4
	 */
	public void setLvl4(String lvl4) {
		this.lvl4 = lvl4;
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
	 * @param delDefCd
	 */
	public void setDelDefCd(String delDefCd) {
		this.delDefCd = delDefCd;
	}
	
	/**
	 * Column Info
	 * @param lvl1
	 */
	public void setLvl1(String lvl1) {
		this.lvl1 = lvl1;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param destTrspModCd
	 */
	public void setDestTrspModCd(String destTrspModCd) {
		this.destTrspModCd = destTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param scgCrteDyKnt
	 */
	public void setScgCrteDyKnt(String scgCrteDyKnt) {
		this.scgCrteDyKnt = scgCrteDyKnt;
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
	 * @param delTpCd
	 */
	public void setDelTpCd(String delTpCd) {
		this.delTpCd = delTpCd;
	}
	
	/**
	 * Column Info
	 * @param dirCallFlg
	 */
	public void setDirCallFlg(String dirCallFlg) {
		this.dirCallFlg = dirCallFlg;
	}
	
	/**
	 * Column Info
	 * @param prcDeTermCd
	 */
	public void setPrcDeTermCd(String prcDeTermCd) {
		this.prcDeTermCd = prcDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param scgPrdCrteCd
	 */
	public void setScgPrdCrteCd(String scgPrdCrteCd) {
		this.scgPrdCrteCd = scgPrdCrteCd;
	}
	
	/**
	 * Column Info
	 * @param ioGaCd
	 */
	public void setIoGaCd(String ioGaCd) {
		this.ioGaCd = ioGaCd;
	}
	
	/**
	 * Column Info
	 * @param ratUtCd
	 */
	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
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
	 * @param podDefCd
	 */
	public void setPodDefCd(String podDefCd) {
		this.podDefCd = podDefCd;
	}
	
	/**
	 * Column Info
	 * @param porTpCd
	 */
	public void setPorTpCd(String porTpCd) {
		this.porTpCd = porTpCd;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Column Info
	 * @param polTpCd
	 */
	public void setPolTpCd(String polTpCd) {
		this.polTpCd = polTpCd;
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
	 * @param prcCgoTpCd
	 */
	public void setPrcCgoTpCd(String prcCgoTpCd) {
		this.prcCgoTpCd = prcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param wdrFlg
	 */
	public void setWdrFlg(String wdrFlg) {
		this.wdrFlg = wdrFlg;
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
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param polDefCd
	 */
	public void setPolDefCd(String polDefCd) {
		this.polDefCd = polDefCd;
	}
	
	/**
	 * Column Info
	 * @param usaSvcModCd
	 */
	public void setUsaSvcModCd(String usaSvcModCd) {
		this.usaSvcModCd = usaSvcModCd;
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
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param cnlTzCd
	 */
	public void setCnlTzCd(String cnlTzCd) {
		this.cnlTzCd = cnlTzCd;
	}
	
	/**
	 * Column Info
	 * @param maxCgoWgt
	 */
	public void setMaxCgoWgt(String maxCgoWgt) {
		this.maxCgoWgt = maxCgoWgt;
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
	 * @param tsPortCd
	 */
	public void setTsPortCd(String tsPortCd) {
		this.tsPortCd = tsPortCd;
	}
	
	/**
	 * Column Info
	 * @param podTpCd
	 */
	public void setPodTpCd(String podTpCd) {
		this.podTpCd = podTpCd;
	}
	
	/**
	 * Column Info
	 * @param scgSeq
	 */
	public void setScgSeq(String scgSeq) {
		this.scgSeq = scgSeq;
	}
	
	/**
	 * Column Info
	 * @param porDefCd
	 */
	public void setPorDefCd(String porDefCd) {
		this.porDefCd = porDefCd;
	}
	
	/**
	 * Column Info
	 * @param scgGrpCmdtCd
	 */
	public void setScgGrpCmdtCd(String scgGrpCmdtCd) {
		this.scgGrpCmdtCd = scgGrpCmdtCd;
	}
	
	/**
	 * Column Info
	 * @param prcRcvTermCd
	 */
	public void setPrcRcvTermCd(String prcRcvTermCd) {
		this.prcRcvTermCd = prcRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param socFlg
	 */
	public void setSocFlg(String socFlg) {
		this.socFlg = socFlg;
	}
	
	/**
	 * Column Info
	 * @param prcHngrBarTpCd
	 */
	public void setPrcHngrBarTpCd(String prcHngrBarTpCd) {
		this.prcHngrBarTpCd = prcHngrBarTpCd;
	}
	
	/**
	 * Column Info
	 * @param minCgoWgt
	 */
	public void setMinCgoWgt(String minCgoWgt) {
		this.minCgoWgt = minCgoWgt;
	}
	
	/**
	 * Column Info
	 * @param scgAmt
	 */
	public void setScgAmt(String scgAmt) {
		this.scgAmt = scgAmt;
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
	 * @param updUsrNm
	 */
	public void setUpdUsrNm(String updUsrNm) {
		this.updUsrNm = updUsrNm;
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
		setScgRmk(JSPUtil.getParameter(request, prefix + "scg_rmk", ""));
		setScgPrdTpCd(JSPUtil.getParameter(request, prefix + "scg_prd_tp_cd", ""));
		setScgImdgClssCd(JSPUtil.getParameter(request, prefix + "scg_imdg_clss_cd", ""));
		setOrgTrspModCd(JSPUtil.getParameter(request, prefix + "org_trsp_mod_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setPayTermCd(JSPUtil.getParameter(request, prefix + "pay_term_cd", ""));
		setPsaNo(JSPUtil.getParameter(request, prefix + "psa_no", ""));
		setRcAirCondTpCd(JSPUtil.getParameter(request, prefix + "rc_air_cond_tp_cd", ""));
		setCtrtDt(JSPUtil.getParameter(request, prefix + "ctrt_dt", ""));
		setActRatFlg(JSPUtil.getParameter(request, prefix + "act_rat_flg", ""));
		setPrnHdnFlg(JSPUtil.getParameter(request, prefix + "prn_hdn_flg", ""));
		setSteCd(JSPUtil.getParameter(request, prefix + "ste_cd", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setFdGrdFlg(JSPUtil.getParameter(request, prefix + "fd_grd_flg", ""));
		setArrDt(JSPUtil.getParameter(request, prefix + "arr_dt", ""));
		setLvl2(JSPUtil.getParameter(request, prefix + "lvl2", ""));
		setTmlCd(JSPUtil.getParameter(request, prefix + "tml_cd", ""));
		setLvl3(JSPUtil.getParameter(request, prefix + "lvl3", ""));
		setLvl4(JSPUtil.getParameter(request, prefix + "lvl4", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDelDefCd(JSPUtil.getParameter(request, prefix + "del_def_cd", ""));
		setLvl1(JSPUtil.getParameter(request, prefix + "lvl1", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setDestTrspModCd(JSPUtil.getParameter(request, prefix + "dest_trsp_mod_cd", ""));
		setScgCrteDyKnt(JSPUtil.getParameter(request, prefix + "scg_crte_dy_knt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setDelTpCd(JSPUtil.getParameter(request, prefix + "del_tp_cd", ""));
		setDirCallFlg(JSPUtil.getParameter(request, prefix + "dir_call_flg", ""));
		setPrcDeTermCd(JSPUtil.getParameter(request, prefix + "prc_de_term_cd", ""));
		setScgPrdCrteCd(JSPUtil.getParameter(request, prefix + "scg_prd_crte_cd", ""));
		setIoGaCd(JSPUtil.getParameter(request, prefix + "io_ga_cd", ""));
		setRatUtCd(JSPUtil.getParameter(request, prefix + "rat_ut_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setPodDefCd(JSPUtil.getParameter(request, prefix + "pod_def_cd", ""));
		setPorTpCd(JSPUtil.getParameter(request, prefix + "por_tp_cd", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setPolTpCd(JSPUtil.getParameter(request, prefix + "pol_tp_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setPrcCgoTpCd(JSPUtil.getParameter(request, prefix + "prc_cgo_tp_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setWdrFlg(JSPUtil.getParameter(request, prefix + "wdr_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setPolDefCd(JSPUtil.getParameter(request, prefix + "pol_def_cd", ""));
		setUsaSvcModCd(JSPUtil.getParameter(request, prefix + "usa_svc_mod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setCnlTzCd(JSPUtil.getParameter(request, prefix + "cnl_tz_cd", ""));
		setMaxCgoWgt(JSPUtil.getParameter(request, prefix + "max_cgo_wgt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setTsPortCd(JSPUtil.getParameter(request, prefix + "ts_port_cd", ""));
		setPodTpCd(JSPUtil.getParameter(request, prefix + "pod_tp_cd", ""));
		setScgSeq(JSPUtil.getParameter(request, prefix + "scg_seq", ""));
		setPorDefCd(JSPUtil.getParameter(request, prefix + "por_def_cd", ""));
		setScgGrpCmdtCd(JSPUtil.getParameter(request, prefix + "scg_grp_cmdt_cd", ""));
		setPrcRcvTermCd(JSPUtil.getParameter(request, prefix + "prc_rcv_term_cd", ""));
		setSocFlg(JSPUtil.getParameter(request, prefix + "soc_flg", ""));
		setPrcHngrBarTpCd(JSPUtil.getParameter(request, prefix + "prc_hngr_bar_tp_cd", ""));
		setMinCgoWgt(JSPUtil.getParameter(request, prefix + "min_cgo_wgt", ""));
		setScgAmt(JSPUtil.getParameter(request, prefix + "scg_amt", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setUpdUsrNm(JSPUtil.getParameter(request, prefix + "upd_usr_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CstPriScgRtVO[]
	 */
	public CstPriScgRtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CstPriScgRtVO[]
	 */
	public CstPriScgRtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CstPriScgRtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] scgRmk = (JSPUtil.getParameter(request, prefix	+ "scg_rmk", length));
			String[] scgPrdTpCd = (JSPUtil.getParameter(request, prefix	+ "scg_prd_tp_cd", length));
			String[] scgImdgClssCd = (JSPUtil.getParameter(request, prefix	+ "scg_imdg_clss_cd", length));
			String[] orgTrspModCd = (JSPUtil.getParameter(request, prefix	+ "org_trsp_mod_cd", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] payTermCd = (JSPUtil.getParameter(request, prefix	+ "pay_term_cd", length));
			String[] psaNo = (JSPUtil.getParameter(request, prefix	+ "psa_no", length));
			String[] rcAirCondTpCd = (JSPUtil.getParameter(request, prefix	+ "rc_air_cond_tp_cd", length));
			String[] ctrtDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_dt", length));
			String[] actRatFlg = (JSPUtil.getParameter(request, prefix	+ "act_rat_flg", length));
			String[] prnHdnFlg = (JSPUtil.getParameter(request, prefix	+ "prn_hdn_flg", length));
			String[] steCd = (JSPUtil.getParameter(request, prefix	+ "ste_cd", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] fdGrdFlg = (JSPUtil.getParameter(request, prefix	+ "fd_grd_flg", length));
			String[] arrDt = (JSPUtil.getParameter(request, prefix	+ "arr_dt", length));
			String[] lvl2 = (JSPUtil.getParameter(request, prefix	+ "lvl2", length));
			String[] tmlCd = (JSPUtil.getParameter(request, prefix	+ "tml_cd", length));
			String[] lvl3 = (JSPUtil.getParameter(request, prefix	+ "lvl3", length));
			String[] lvl4 = (JSPUtil.getParameter(request, prefix	+ "lvl4", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] delDefCd = (JSPUtil.getParameter(request, prefix	+ "del_def_cd", length));
			String[] lvl1 = (JSPUtil.getParameter(request, prefix	+ "lvl1", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] destTrspModCd = (JSPUtil.getParameter(request, prefix	+ "dest_trsp_mod_cd", length));
			String[] scgCrteDyKnt = (JSPUtil.getParameter(request, prefix	+ "scg_crte_dy_knt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] delTpCd = (JSPUtil.getParameter(request, prefix	+ "del_tp_cd", length));
			String[] dirCallFlg = (JSPUtil.getParameter(request, prefix	+ "dir_call_flg", length));
			String[] prcDeTermCd = (JSPUtil.getParameter(request, prefix	+ "prc_de_term_cd", length));
			String[] scgPrdCrteCd = (JSPUtil.getParameter(request, prefix	+ "scg_prd_crte_cd", length));
			String[] ioGaCd = (JSPUtil.getParameter(request, prefix	+ "io_ga_cd", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] podDefCd = (JSPUtil.getParameter(request, prefix	+ "pod_def_cd", length));
			String[] porTpCd = (JSPUtil.getParameter(request, prefix	+ "por_tp_cd", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] polTpCd = (JSPUtil.getParameter(request, prefix	+ "pol_tp_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] prcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cgo_tp_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] wdrFlg = (JSPUtil.getParameter(request, prefix	+ "wdr_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] polDefCd = (JSPUtil.getParameter(request, prefix	+ "pol_def_cd", length));
			String[] usaSvcModCd = (JSPUtil.getParameter(request, prefix	+ "usa_svc_mod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] cnlTzCd = (JSPUtil.getParameter(request, prefix	+ "cnl_tz_cd", length));
			String[] maxCgoWgt = (JSPUtil.getParameter(request, prefix	+ "max_cgo_wgt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] tsPortCd = (JSPUtil.getParameter(request, prefix	+ "ts_port_cd", length));
			String[] podTpCd = (JSPUtil.getParameter(request, prefix	+ "pod_tp_cd", length));
			String[] scgSeq = (JSPUtil.getParameter(request, prefix	+ "scg_seq", length));
			String[] porDefCd = (JSPUtil.getParameter(request, prefix	+ "por_def_cd", length));
			String[] scgGrpCmdtCd = (JSPUtil.getParameter(request, prefix	+ "scg_grp_cmdt_cd", length));
			String[] prcRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "prc_rcv_term_cd", length));
			String[] socFlg = (JSPUtil.getParameter(request, prefix	+ "soc_flg", length));
			String[] prcHngrBarTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_hngr_bar_tp_cd", length));
			String[] minCgoWgt = (JSPUtil.getParameter(request, prefix	+ "min_cgo_wgt", length));
			String[] scgAmt = (JSPUtil.getParameter(request, prefix	+ "scg_amt", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] updUsrNm = (JSPUtil.getParameter(request, prefix	+ "upd_usr_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new CstPriScgRtVO();
				if (scgRmk[i] != null)
					model.setScgRmk(scgRmk[i]);
				if (scgPrdTpCd[i] != null)
					model.setScgPrdTpCd(scgPrdTpCd[i]);
				if (scgImdgClssCd[i] != null)
					model.setScgImdgClssCd(scgImdgClssCd[i]);
				if (orgTrspModCd[i] != null)
					model.setOrgTrspModCd(orgTrspModCd[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (payTermCd[i] != null)
					model.setPayTermCd(payTermCd[i]);
				if (psaNo[i] != null)
					model.setPsaNo(psaNo[i]);
				if (rcAirCondTpCd[i] != null)
					model.setRcAirCondTpCd(rcAirCondTpCd[i]);
				if (ctrtDt[i] != null)
					model.setCtrtDt(ctrtDt[i]);
				if (actRatFlg[i] != null)
					model.setActRatFlg(actRatFlg[i]);
				if (prnHdnFlg[i] != null)
					model.setPrnHdnFlg(prnHdnFlg[i]);
				if (steCd[i] != null)
					model.setSteCd(steCd[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (fdGrdFlg[i] != null)
					model.setFdGrdFlg(fdGrdFlg[i]);
				if (arrDt[i] != null)
					model.setArrDt(arrDt[i]);
				if (lvl2[i] != null)
					model.setLvl2(lvl2[i]);
				if (tmlCd[i] != null)
					model.setTmlCd(tmlCd[i]);
				if (lvl3[i] != null)
					model.setLvl3(lvl3[i]);
				if (lvl4[i] != null)
					model.setLvl4(lvl4[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (delDefCd[i] != null)
					model.setDelDefCd(delDefCd[i]);
				if (lvl1[i] != null)
					model.setLvl1(lvl1[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (destTrspModCd[i] != null)
					model.setDestTrspModCd(destTrspModCd[i]);
				if (scgCrteDyKnt[i] != null)
					model.setScgCrteDyKnt(scgCrteDyKnt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (delTpCd[i] != null)
					model.setDelTpCd(delTpCd[i]);
				if (dirCallFlg[i] != null)
					model.setDirCallFlg(dirCallFlg[i]);
				if (prcDeTermCd[i] != null)
					model.setPrcDeTermCd(prcDeTermCd[i]);
				if (scgPrdCrteCd[i] != null)
					model.setScgPrdCrteCd(scgPrdCrteCd[i]);
				if (ioGaCd[i] != null)
					model.setIoGaCd(ioGaCd[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (podDefCd[i] != null)
					model.setPodDefCd(podDefCd[i]);
				if (porTpCd[i] != null)
					model.setPorTpCd(porTpCd[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (polTpCd[i] != null)
					model.setPolTpCd(polTpCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (prcCgoTpCd[i] != null)
					model.setPrcCgoTpCd(prcCgoTpCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (wdrFlg[i] != null)
					model.setWdrFlg(wdrFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (polDefCd[i] != null)
					model.setPolDefCd(polDefCd[i]);
				if (usaSvcModCd[i] != null)
					model.setUsaSvcModCd(usaSvcModCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (cnlTzCd[i] != null)
					model.setCnlTzCd(cnlTzCd[i]);
				if (maxCgoWgt[i] != null)
					model.setMaxCgoWgt(maxCgoWgt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (tsPortCd[i] != null)
					model.setTsPortCd(tsPortCd[i]);
				if (podTpCd[i] != null)
					model.setPodTpCd(podTpCd[i]);
				if (scgSeq[i] != null)
					model.setScgSeq(scgSeq[i]);
				if (porDefCd[i] != null)
					model.setPorDefCd(porDefCd[i]);
				if (scgGrpCmdtCd[i] != null)
					model.setScgGrpCmdtCd(scgGrpCmdtCd[i]);
				if (prcRcvTermCd[i] != null)
					model.setPrcRcvTermCd(prcRcvTermCd[i]);
				if (socFlg[i] != null)
					model.setSocFlg(socFlg[i]);
				if (prcHngrBarTpCd[i] != null)
					model.setPrcHngrBarTpCd(prcHngrBarTpCd[i]);
				if (minCgoWgt[i] != null)
					model.setMinCgoWgt(minCgoWgt[i]);
				if (scgAmt[i] != null)
					model.setScgAmt(scgAmt[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (updUsrNm[i] != null)
					model.setUpdUsrNm(updUsrNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCstPriScgRtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CstPriScgRtVO[]
	 */
	public CstPriScgRtVO[] getCstPriScgRtVOs(){
		CstPriScgRtVO[] vos = (CstPriScgRtVO[])models.toArray(new CstPriScgRtVO[models.size()]);
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
		this.scgRmk = this.scgRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgPrdTpCd = this.scgPrdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgImdgClssCd = this.scgImdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgTrspModCd = this.orgTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payTermCd = this.payTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaNo = this.psaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcAirCondTpCd = this.rcAirCondTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtDt = this.ctrtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actRatFlg = this.actRatFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prnHdnFlg = this.prnHdnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steCd = this.steCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdGrdFlg = this.fdGrdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrDt = this.arrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl2 = this.lvl2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCd = this.tmlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl3 = this.lvl3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl4 = this.lvl4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delDefCd = this.delDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl1 = this.lvl1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destTrspModCd = this.destTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgCrteDyKnt = this.scgCrteDyKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delTpCd = this.delTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCallFlg = this.dirCallFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcDeTermCd = this.prcDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgPrdCrteCd = this.scgPrdCrteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioGaCd = this.ioGaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podDefCd = this.podDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porTpCd = this.porTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polTpCd = this.polTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCgoTpCd = this.prcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wdrFlg = this.wdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polDefCd = this.polDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaSvcModCd = this.usaSvcModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnlTzCd = this.cnlTzCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxCgoWgt = this.maxCgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsPortCd = this.tsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podTpCd = this.podTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgSeq = this.scgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porDefCd = this.porDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgGrpCmdtCd = this.scgGrpCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcRcvTermCd = this.prcRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socFlg = this.socFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcHngrBarTpCd = this.prcHngrBarTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minCgoWgt = this.minCgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgAmt = this.scgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrNm = this.updUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
