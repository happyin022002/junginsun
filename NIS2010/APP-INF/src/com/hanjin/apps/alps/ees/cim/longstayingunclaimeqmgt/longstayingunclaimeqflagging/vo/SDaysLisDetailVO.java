/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SDaysLisDetailVO.java
*@FileTitle : SDaysLisDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.12
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2010.04.12 김종준 
* 1.0 Creation
* -------------------------------------------------------
* History
* 2012.01.25 신자영 [CHM-201215785-01] CNTR STAYING DAYS 추가 개발 - Booking SalesRep code추가
=========================================================*/

package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김종준
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SDaysLisDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SDaysLisDetailVO> models = new ArrayList<SDaysLisDetailVO>();
	
	/* Column Info */
	private String ntfy = null;
	/* Column Info */
	private String actDys = null;
	/* Column Info */
	private String gwgt = null;
	/* Column Info */
	private String twgt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String frtCltFlg = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String mnrHngrBarTpCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String cntrHngrBarAtchKnt = null;
	/* Column Info */
	private String obSlsOfcCd = null;
	/* Column Info */
	private String obSrepCd = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String uclmLsFlg = null;
	/* Column Info */
	private String repCmdtNm = null;
	/* Column Info */
	private String lessor = null;
	/* Column Info */
	private String cnmvDt = null;
	/* Column Info */
	private String stayDays11 = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String stayDays12 = null;
	/* Column Info */
	private String cnmvEvntDt = null;
	/* Column Info */
	private String oblRdemFlg = null;
	/* Column Info */
	private String stayDays13 = null;
	/* Column Info */
	private String stayDays14 = null;
	/* Column Info */
	private String stayDays15 = null;
	/* Column Info */
	private String stayDays3 = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String stayDays2 = null;
	/* Column Info */
	private String dispFlg = null;
	/* Column Info */
	private String stayDays1 = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String uclmLsDivCd = null;
	/* Column Info */
	private String stayDays7 = null;
	/* Column Info */
	private String stayDays6 = null;
	/* Column Info */
	private String stayDays10 = null;
	/* Column Info */
	private String stayDays5 = null;
	/* Column Info */
	private String stayDays4 = null;
	/* Column Info */
	private String nextVvd = null;
	/* Column Info */
	private String fullFlg = null;
	/* Column Info */
	private String stayDays9 = null;
	/* Column Info */
	private String stayDays8 = null;
	/* Column Info */
	private String stayDays = null;
	/* Column Info */
	private String cntrHngrRckCd = null;
	/* Column Info */
	private String pkupNo = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String crntYdCd = null;
	/* Column Info */
	private String totDays = null;
	/* Column Info */
	private String dtyFreeDt = null;
	/* Column Info */
	private String dmgFlg = null;
	/* Column Info */
	private String mkDesc = null;
	/* Column Info */
	private String polEtd = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ftEndDt = null;
	/* Column Info */
	private String subLocCd = null;
	/* Column Info */
	private String orgYdCd = null;
	/* Column Info */
	private String plstFlrFlg = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String mftDt = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String mvmtStsCd = null;
	/* Column Info */
	private String ftDys = null;
	/* Column Info */
	private String scRfaNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String pwgt = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String cnee = null;
	/* Column Info */
	private String imdtExtFlg = null;
	/* Column Info */
	private String shpr = null;
	/* Column Info */
	private String rfTpCd = null;
	/* Column Info */
	private String cstmsClrFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SDaysLisDetailVO() {}

	public SDaysLisDetailVO(String ibflag, String pagerows, String vvd, String polCd, String podCd, String delCd, String stayDays, String cntrNo, String cntrTpszCd, String fullFlg, String lstmCd, String cnmvDt, String bkgNo, String blNo, String dmgFlg, String cntrHngrRckCd, String mnrHngrBarTpCd, String cntrHngrBarAtchKnt, String dispFlg, String imdtExtFlg, String seq, String crntYdCd, String cnmvStsCd, String porCd, String nextVvd, String polEtd, String shpr, String cnee, String ntfy, String scNo, String rfaNo, String scRfaNo, String uclmLsDivCd, String uclmLsFlg, String plstFlrFlg, String deTermCd, String rfTpCd, String cmdtNm, String mkDesc, String obSlsOfcCd, String obSrepCd, String lessor, String mftDt, String pkupNo, String frtCltFlg, String oblRdemFlg, String cstmsClrFlg, String dtyFreeDt, String gwgt, String pwgt, String twgt, String subLocCd, String repCmdtNm, String ftDys, String ftEndDt, String actDys, String orgYdCd, String mvmtStsCd, String cnmvEvntDt, String totDays, String stayDays1, String stayDays2, String stayDays3, String stayDays4, String stayDays5, String stayDays6, String stayDays7, String stayDays8, String stayDays9, String stayDays10, String stayDays11, String stayDays12, String stayDays13, String stayDays14, String stayDays15) {
		this.ntfy = ntfy;
		this.actDys = actDys;
		this.gwgt = gwgt;
		this.twgt = twgt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.frtCltFlg = frtCltFlg;
		this.scNo = scNo;
		this.mnrHngrBarTpCd = mnrHngrBarTpCd;
		this.cntrTpszCd = cntrTpszCd;
		this.cntrHngrBarAtchKnt = cntrHngrBarAtchKnt;
		this.obSlsOfcCd = obSlsOfcCd;
		this.obSrepCd = obSrepCd;
		this.lstmCd = lstmCd;
		this.uclmLsFlg = uclmLsFlg;
		this.repCmdtNm = repCmdtNm;
		this.lessor = lessor;
		this.cnmvDt = cnmvDt;
		this.stayDays11 = stayDays11;
		this.delCd = delCd;
		this.stayDays12 = stayDays12;
		this.cnmvEvntDt = cnmvEvntDt;
		this.oblRdemFlg = oblRdemFlg;
		this.stayDays13 = stayDays13;
		this.stayDays14 = stayDays14;
		this.stayDays15 = stayDays15;
		this.stayDays3 = stayDays3;
		this.vvd = vvd;
		this.podCd = podCd;
		this.stayDays2 = stayDays2;
		this.dispFlg = dispFlg;
		this.stayDays1 = stayDays1;
		this.bkgNo = bkgNo;
		this.uclmLsDivCd = uclmLsDivCd;
		this.stayDays7 = stayDays7;
		this.stayDays6 = stayDays6;
		this.stayDays10 = stayDays10;
		this.stayDays5 = stayDays5;
		this.stayDays4 = stayDays4;
		this.nextVvd = nextVvd;
		this.fullFlg = fullFlg;
		this.stayDays9 = stayDays9;
		this.stayDays8 = stayDays8;
		this.stayDays = stayDays;
		this.cntrHngrRckCd = cntrHngrRckCd;
		this.pkupNo = pkupNo;
		this.porCd = porCd;
		this.crntYdCd = crntYdCd;
		this.totDays = totDays;
		this.dtyFreeDt = dtyFreeDt;
		this.dmgFlg = dmgFlg;
		this.mkDesc = mkDesc;
		this.polEtd = polEtd;
		this.rfaNo = rfaNo;
		this.cnmvStsCd = cnmvStsCd;
		this.ibflag = ibflag;
		this.ftEndDt = ftEndDt;
		this.subLocCd = subLocCd;
		this.orgYdCd = orgYdCd;
		this.plstFlrFlg = plstFlrFlg;
		this.cmdtNm = cmdtNm;
		this.mftDt = mftDt;
		this.deTermCd = deTermCd;
		this.mvmtStsCd = mvmtStsCd;
		this.ftDys = ftDys;
		this.scRfaNo = scRfaNo;
		this.cntrNo = cntrNo;
		this.pwgt = pwgt;
		this.seq = seq;
		this.cnee = cnee;
		this.imdtExtFlg = imdtExtFlg;
		this.shpr = shpr;
		this.rfTpCd = rfTpCd;
		this.cstmsClrFlg = cstmsClrFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ntfy", getNtfy());
		this.hashColumns.put("act_dys", getActDys());
		this.hashColumns.put("gwgt", getGwgt());
		this.hashColumns.put("twgt", getTwgt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("frt_clt_flg", getFrtCltFlg());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("mnr_hngr_bar_tp_cd", getMnrHngrBarTpCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cntr_hngr_bar_atch_knt", getCntrHngrBarAtchKnt());
		this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
		this.hashColumns.put("ob_srep_cd", getObSrepCd());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("uclm_ls_flg", getUclmLsFlg());
		this.hashColumns.put("rep_cmdt_nm", getRepCmdtNm());
		this.hashColumns.put("lessor", getLessor());
		this.hashColumns.put("cnmv_dt", getCnmvDt());
		this.hashColumns.put("stay_days11", getStayDays11());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("stay_days12", getStayDays12());
		this.hashColumns.put("cnmv_evnt_dt", getCnmvEvntDt());
		this.hashColumns.put("obl_rdem_flg", getOblRdemFlg());
		this.hashColumns.put("stay_days13", getStayDays13());
		this.hashColumns.put("stay_days14", getStayDays14());
		this.hashColumns.put("stay_days15", getStayDays15());
		this.hashColumns.put("stay_days3", getStayDays3());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("stay_days2", getStayDays2());
		this.hashColumns.put("disp_flg", getDispFlg());
		this.hashColumns.put("stay_days1", getStayDays1());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("uclm_ls_div_cd", getUclmLsDivCd());
		this.hashColumns.put("stay_days7", getStayDays7());
		this.hashColumns.put("stay_days6", getStayDays6());
		this.hashColumns.put("stay_days10", getStayDays10());
		this.hashColumns.put("stay_days5", getStayDays5());
		this.hashColumns.put("stay_days4", getStayDays4());
		this.hashColumns.put("next_vvd", getNextVvd());
		this.hashColumns.put("full_flg", getFullFlg());
		this.hashColumns.put("stay_days9", getStayDays9());
		this.hashColumns.put("stay_days8", getStayDays8());
		this.hashColumns.put("stay_days", getStayDays());
		this.hashColumns.put("cntr_hngr_rck_cd", getCntrHngrRckCd());
		this.hashColumns.put("pkup_no", getPkupNo());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());
		this.hashColumns.put("tot_days", getTotDays());
		this.hashColumns.put("dty_free_dt", getDtyFreeDt());
		this.hashColumns.put("dmg_flg", getDmgFlg());
		this.hashColumns.put("mk_desc", getMkDesc());
		this.hashColumns.put("pol_etd", getPolEtd());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ft_end_dt", getFtEndDt());
		this.hashColumns.put("sub_loc_cd", getSubLocCd());
		this.hashColumns.put("org_yd_cd", getOrgYdCd());
		this.hashColumns.put("plst_flr_flg", getPlstFlrFlg());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("mft_dt", getMftDt());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());
		this.hashColumns.put("ft_dys", getFtDys());
		this.hashColumns.put("sc_rfa_no", getScRfaNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("pwgt", getPwgt());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("cnee", getCnee());
		this.hashColumns.put("imdt_ext_flg", getImdtExtFlg());
		this.hashColumns.put("shpr", getShpr());
		this.hashColumns.put("rf_tp_cd", getRfTpCd());
		this.hashColumns.put("cstms_clr_flg", getCstmsClrFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ntfy", "ntfy");
		this.hashFields.put("act_dys", "actDys");
		this.hashFields.put("gwgt", "gwgt");
		this.hashFields.put("twgt", "twgt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("frt_clt_flg", "frtCltFlg");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("mnr_hngr_bar_tp_cd", "mnrHngrBarTpCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cntr_hngr_bar_atch_knt", "cntrHngrBarAtchKnt");
		this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
		this.hashFields.put("ob_srep_cd", "obSrepCd");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("uclm_ls_flg", "uclmLsFlg");
		this.hashFields.put("rep_cmdt_nm", "repCmdtNm");
		this.hashFields.put("lessor", "lessor");
		this.hashFields.put("cnmv_dt", "cnmvDt");
		this.hashFields.put("stay_days11", "stayDays11");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("stay_days12", "stayDays12");
		this.hashFields.put("cnmv_evnt_dt", "cnmvEvntDt");
		this.hashFields.put("obl_rdem_flg", "oblRdemFlg");
		this.hashFields.put("stay_days13", "stayDays13");
		this.hashFields.put("stay_days14", "stayDays14");
		this.hashFields.put("stay_days15", "stayDays15");
		this.hashFields.put("stay_days3", "stayDays3");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("stay_days2", "stayDays2");
		this.hashFields.put("disp_flg", "dispFlg");
		this.hashFields.put("stay_days1", "stayDays1");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("uclm_ls_div_cd", "uclmLsDivCd");
		this.hashFields.put("stay_days7", "stayDays7");
		this.hashFields.put("stay_days6", "stayDays6");
		this.hashFields.put("stay_days10", "stayDays10");
		this.hashFields.put("stay_days5", "stayDays5");
		this.hashFields.put("stay_days4", "stayDays4");
		this.hashFields.put("next_vvd", "nextVvd");
		this.hashFields.put("full_flg", "fullFlg");
		this.hashFields.put("stay_days9", "stayDays9");
		this.hashFields.put("stay_days8", "stayDays8");
		this.hashFields.put("stay_days", "stayDays");
		this.hashFields.put("cntr_hngr_rck_cd", "cntrHngrRckCd");
		this.hashFields.put("pkup_no", "pkupNo");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("tot_days", "totDays");
		this.hashFields.put("dty_free_dt", "dtyFreeDt");
		this.hashFields.put("dmg_flg", "dmgFlg");
		this.hashFields.put("mk_desc", "mkDesc");
		this.hashFields.put("pol_etd", "polEtd");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ft_end_dt", "ftEndDt");
		this.hashFields.put("sub_loc_cd", "subLocCd");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("plst_flr_flg", "plstFlrFlg");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("mft_dt", "mftDt");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("ft_dys", "ftDys");
		this.hashFields.put("sc_rfa_no", "scRfaNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("pwgt", "pwgt");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("cnee", "cnee");
		this.hashFields.put("imdt_ext_flg", "imdtExtFlg");
		this.hashFields.put("shpr", "shpr");
		this.hashFields.put("rf_tp_cd", "rfTpCd");
		this.hashFields.put("cstms_clr_flg", "cstmsClrFlg");
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
	 * @return actDys
	 */
	public String getActDys() {
		return this.actDys;
	}
	
	/**
	 * Column Info
	 * @return gwgt
	 */
	public String getGwgt() {
		return this.gwgt;
	}
	
	/**
	 * Column Info
	 * @return twgt
	 */
	public String getTwgt() {
		return this.twgt;
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
	 * @return frtCltFlg
	 */
	public String getFrtCltFlg() {
		return this.frtCltFlg;
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
	 * @return mnrHngrBarTpCd
	 */
	public String getMnrHngrBarTpCd() {
		return this.mnrHngrBarTpCd;
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
	 * @return cntrHngrBarAtchKnt
	 */
	public String getCntrHngrBarAtchKnt() {
		return this.cntrHngrBarAtchKnt;
	}
	
	/**
	 * Column Info
	 * @return obSlsOfcCd
	 */
	public String getObSlsOfcCd() {
		return this.obSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return obSrepCd
	 */
	public String getObSrepCd() {
		return this.obSrepCd;
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
	 * @return uclmLsFlg
	 */
	public String getUclmLsFlg() {
		return this.uclmLsFlg;
	}
	
	/**
	 * Column Info
	 * @return repCmdtNm
	 */
	public String getRepCmdtNm() {
		return this.repCmdtNm;
	}
	
	/**
	 * Column Info
	 * @return lessor
	 */
	public String getLessor() {
		return this.lessor;
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
	 * @return stayDays11
	 */
	public String getStayDays11() {
		return this.stayDays11;
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
	 * @return stayDays12
	 */
	public String getStayDays12() {
		return this.stayDays12;
	}
	
	/**
	 * Column Info
	 * @return cnmvEvntDt
	 */
	public String getCnmvEvntDt() {
		return this.cnmvEvntDt;
	}
	
	/**
	 * Column Info
	 * @return oblRdemFlg
	 */
	public String getOblRdemFlg() {
		return this.oblRdemFlg;
	}
	
	/**
	 * Column Info
	 * @return stayDays13
	 */
	public String getStayDays13() {
		return this.stayDays13;
	}
	
	/**
	 * Column Info
	 * @return stayDays14
	 */
	public String getStayDays14() {
		return this.stayDays14;
	}
	
	/**
	 * Column Info
	 * @return stayDays15
	 */
	public String getStayDays15() {
		return this.stayDays15;
	}
	
	/**
	 * Column Info
	 * @return stayDays3
	 */
	public String getStayDays3() {
		return this.stayDays3;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return stayDays2
	 */
	public String getStayDays2() {
		return this.stayDays2;
	}
	
	/**
	 * Column Info
	 * @return dispFlg
	 */
	public String getDispFlg() {
		return this.dispFlg;
	}
	
	/**
	 * Column Info
	 * @return stayDays1
	 */
	public String getStayDays1() {
		return this.stayDays1;
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
	 * @return uclmLsDivCd
	 */
	public String getUclmLsDivCd() {
		return this.uclmLsDivCd;
	}
	
	/**
	 * Column Info
	 * @return stayDays7
	 */
	public String getStayDays7() {
		return this.stayDays7;
	}
	
	/**
	 * Column Info
	 * @return stayDays6
	 */
	public String getStayDays6() {
		return this.stayDays6;
	}
	
	/**
	 * Column Info
	 * @return stayDays10
	 */
	public String getStayDays10() {
		return this.stayDays10;
	}
	
	/**
	 * Column Info
	 * @return stayDays5
	 */
	public String getStayDays5() {
		return this.stayDays5;
	}
	
	/**
	 * Column Info
	 * @return stayDays4
	 */
	public String getStayDays4() {
		return this.stayDays4;
	}
	
	/**
	 * Column Info
	 * @return nextVvd
	 */
	public String getNextVvd() {
		return this.nextVvd;
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
	 * @return stayDays9
	 */
	public String getStayDays9() {
		return this.stayDays9;
	}
	
	/**
	 * Column Info
	 * @return stayDays8
	 */
	public String getStayDays8() {
		return this.stayDays8;
	}
	
	/**
	 * Column Info
	 * @return stayDays
	 */
	public String getStayDays() {
		return this.stayDays;
	}
	
	/**
	 * Column Info
	 * @return cntrHngrRckCd
	 */
	public String getCntrHngrRckCd() {
		return this.cntrHngrRckCd;
	}
	
	/**
	 * Column Info
	 * @return pkupNo
	 */
	public String getPkupNo() {
		return this.pkupNo;
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
	 * @return crntYdCd
	 */
	public String getCrntYdCd() {
		return this.crntYdCd;
	}
	
	/**
	 * Column Info
	 * @return totDays
	 */
	public String getTotDays() {
		return this.totDays;
	}
	
	/**
	 * Column Info
	 * @return dtyFreeDt
	 */
	public String getDtyFreeDt() {
		return this.dtyFreeDt;
	}
	
	/**
	 * Column Info
	 * @return dmgFlg
	 */
	public String getDmgFlg() {
		return this.dmgFlg;
	}
	
	/**
	 * Column Info
	 * @return mkDesc
	 */
	public String getMkDesc() {
		return this.mkDesc;
	}
	
	/**
	 * Column Info
	 * @return polEtd
	 */
	public String getPolEtd() {
		return this.polEtd;
	}
	
	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
	}
	
	/**
	 * Column Info
	 * @return cnmvStsCd
	 */
	public String getCnmvStsCd() {
		return this.cnmvStsCd;
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
	 * @return ftEndDt
	 */
	public String getFtEndDt() {
		return this.ftEndDt;
	}
	
	/**
	 * Column Info
	 * @return subLocCd
	 */
	public String getSubLocCd() {
		return this.subLocCd;
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
	 * @return plstFlrFlg
	 */
	public String getPlstFlrFlg() {
		return this.plstFlrFlg;
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
	 * @return mftDt
	 */
	public String getMftDt() {
		return this.mftDt;
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
	 * @return mvmtStsCd
	 */
	public String getMvmtStsCd() {
		return this.mvmtStsCd;
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
	 * @return scRfaNo
	 */
	public String getScRfaNo() {
		return this.scRfaNo;
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
	 * @return pwgt
	 */
	public String getPwgt() {
		return this.pwgt;
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
	 * @return cnee
	 */
	public String getCnee() {
		return this.cnee;
	}
	
	/**
	 * Column Info
	 * @return imdtExtFlg
	 */
	public String getImdtExtFlg() {
		return this.imdtExtFlg;
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
	 * @return rfTpCd
	 */
	public String getRfTpCd() {
		return this.rfTpCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsClrFlg
	 */
	public String getCstmsClrFlg() {
		return this.cstmsClrFlg;
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
	 * @param actDys
	 */
	public void setActDys(String actDys) {
		this.actDys = actDys;
	}
	
	/**
	 * Column Info
	 * @param gwgt
	 */
	public void setGwgt(String gwgt) {
		this.gwgt = gwgt;
	}
	
	/**
	 * Column Info
	 * @param twgt
	 */
	public void setTwgt(String twgt) {
		this.twgt = twgt;
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
	 * @param frtCltFlg
	 */
	public void setFrtCltFlg(String frtCltFlg) {
		this.frtCltFlg = frtCltFlg;
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
	 * @param mnrHngrBarTpCd
	 */
	public void setMnrHngrBarTpCd(String mnrHngrBarTpCd) {
		this.mnrHngrBarTpCd = mnrHngrBarTpCd;
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
	 * @param cntrHngrBarAtchKnt
	 */
	public void setCntrHngrBarAtchKnt(String cntrHngrBarAtchKnt) {
		this.cntrHngrBarAtchKnt = cntrHngrBarAtchKnt;
	}
	
	/**
	 * Column Info
	 * @param obSlsOfcCd
	 */
	public void setObSlsOfcCd(String obSlsOfcCd) {
		this.obSlsOfcCd = obSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param obSrepcCd
	 */
	public void setObSrepCd(String obSrepCd) {
		this.obSrepCd = obSrepCd;
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
	 * @param uclmLsFlg
	 */
	public void setUclmLsFlg(String uclmLsFlg) {
		this.uclmLsFlg = uclmLsFlg;
	}
	
	/**
	 * Column Info
	 * @param repCmdtNm
	 */
	public void setRepCmdtNm(String repCmdtNm) {
		this.repCmdtNm = repCmdtNm;
	}
	
	/**
	 * Column Info
	 * @param lessor
	 */
	public void setLessor(String lessor) {
		this.lessor = lessor;
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
	 * @param stayDays11
	 */
	public void setStayDays11(String stayDays11) {
		this.stayDays11 = stayDays11;
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
	 * @param stayDays12
	 */
	public void setStayDays12(String stayDays12) {
		this.stayDays12 = stayDays12;
	}
	
	/**
	 * Column Info
	 * @param cnmvEvntDt
	 */
	public void setCnmvEvntDt(String cnmvEvntDt) {
		this.cnmvEvntDt = cnmvEvntDt;
	}
	
	/**
	 * Column Info
	 * @param oblRdemFlg
	 */
	public void setOblRdemFlg(String oblRdemFlg) {
		this.oblRdemFlg = oblRdemFlg;
	}
	
	/**
	 * Column Info
	 * @param stayDays13
	 */
	public void setStayDays13(String stayDays13) {
		this.stayDays13 = stayDays13;
	}
	
	/**
	 * Column Info
	 * @param stayDays14
	 */
	public void setStayDays14(String stayDays14) {
		this.stayDays14 = stayDays14;
	}
	
	/**
	 * Column Info
	 * @param stayDays15
	 */
	public void setStayDays15(String stayDays15) {
		this.stayDays15 = stayDays15;
	}
	
	/**
	 * Column Info
	 * @param stayDays3
	 */
	public void setStayDays3(String stayDays3) {
		this.stayDays3 = stayDays3;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param stayDays2
	 */
	public void setStayDays2(String stayDays2) {
		this.stayDays2 = stayDays2;
	}
	
	/**
	 * Column Info
	 * @param dispFlg
	 */
	public void setDispFlg(String dispFlg) {
		this.dispFlg = dispFlg;
	}
	
	/**
	 * Column Info
	 * @param stayDays1
	 */
	public void setStayDays1(String stayDays1) {
		this.stayDays1 = stayDays1;
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
	 * @param uclmLsDivCd
	 */
	public void setUclmLsDivCd(String uclmLsDivCd) {
		this.uclmLsDivCd = uclmLsDivCd;
	}
	
	/**
	 * Column Info
	 * @param stayDays7
	 */
	public void setStayDays7(String stayDays7) {
		this.stayDays7 = stayDays7;
	}
	
	/**
	 * Column Info
	 * @param stayDays6
	 */
	public void setStayDays6(String stayDays6) {
		this.stayDays6 = stayDays6;
	}
	
	/**
	 * Column Info
	 * @param stayDays10
	 */
	public void setStayDays10(String stayDays10) {
		this.stayDays10 = stayDays10;
	}
	
	/**
	 * Column Info
	 * @param stayDays5
	 */
	public void setStayDays5(String stayDays5) {
		this.stayDays5 = stayDays5;
	}
	
	/**
	 * Column Info
	 * @param stayDays4
	 */
	public void setStayDays4(String stayDays4) {
		this.stayDays4 = stayDays4;
	}
	
	/**
	 * Column Info
	 * @param nextVvd
	 */
	public void setNextVvd(String nextVvd) {
		this.nextVvd = nextVvd;
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
	 * @param stayDays9
	 */
	public void setStayDays9(String stayDays9) {
		this.stayDays9 = stayDays9;
	}
	
	/**
	 * Column Info
	 * @param stayDays8
	 */
	public void setStayDays8(String stayDays8) {
		this.stayDays8 = stayDays8;
	}
	
	/**
	 * Column Info
	 * @param stayDays
	 */
	public void setStayDays(String stayDays) {
		this.stayDays = stayDays;
	}
	
	/**
	 * Column Info
	 * @param cntrHngrRckCd
	 */
	public void setCntrHngrRckCd(String cntrHngrRckCd) {
		this.cntrHngrRckCd = cntrHngrRckCd;
	}
	
	/**
	 * Column Info
	 * @param pkupNo
	 */
	public void setPkupNo(String pkupNo) {
		this.pkupNo = pkupNo;
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
	 * @param crntYdCd
	 */
	public void setCrntYdCd(String crntYdCd) {
		this.crntYdCd = crntYdCd;
	}
	
	/**
	 * Column Info
	 * @param totDays
	 */
	public void setTotDays(String totDays) {
		this.totDays = totDays;
	}
	
	/**
	 * Column Info
	 * @param dtyFreeDt
	 */
	public void setDtyFreeDt(String dtyFreeDt) {
		this.dtyFreeDt = dtyFreeDt;
	}
	
	/**
	 * Column Info
	 * @param dmgFlg
	 */
	public void setDmgFlg(String dmgFlg) {
		this.dmgFlg = dmgFlg;
	}
	
	/**
	 * Column Info
	 * @param mkDesc
	 */
	public void setMkDesc(String mkDesc) {
		this.mkDesc = mkDesc;
	}
	
	/**
	 * Column Info
	 * @param polEtd
	 */
	public void setPolEtd(String polEtd) {
		this.polEtd = polEtd;
	}
	
	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}
	
	/**
	 * Column Info
	 * @param cnmvStsCd
	 */
	public void setCnmvStsCd(String cnmvStsCd) {
		this.cnmvStsCd = cnmvStsCd;
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
	 * @param ftEndDt
	 */
	public void setFtEndDt(String ftEndDt) {
		this.ftEndDt = ftEndDt;
	}
	
	/**
	 * Column Info
	 * @param subLocCd
	 */
	public void setSubLocCd(String subLocCd) {
		this.subLocCd = subLocCd;
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
	 * @param plstFlrFlg
	 */
	public void setPlstFlrFlg(String plstFlrFlg) {
		this.plstFlrFlg = plstFlrFlg;
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
	 * @param mftDt
	 */
	public void setMftDt(String mftDt) {
		this.mftDt = mftDt;
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
	 * @param mvmtStsCd
	 */
	public void setMvmtStsCd(String mvmtStsCd) {
		this.mvmtStsCd = mvmtStsCd;
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
	 * @param scRfaNo
	 */
	public void setScRfaNo(String scRfaNo) {
		this.scRfaNo = scRfaNo;
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
	 * @param pwgt
	 */
	public void setPwgt(String pwgt) {
		this.pwgt = pwgt;
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
	 * @param cnee
	 */
	public void setCnee(String cnee) {
		this.cnee = cnee;
	}
	
	/**
	 * Column Info
	 * @param imdtExtFlg
	 */
	public void setImdtExtFlg(String imdtExtFlg) {
		this.imdtExtFlg = imdtExtFlg;
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
	 * @param rfTpCd
	 */
	public void setRfTpCd(String rfTpCd) {
		this.rfTpCd = rfTpCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsClrFlg
	 */
	public void setCstmsClrFlg(String cstmsClrFlg) {
		this.cstmsClrFlg = cstmsClrFlg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setNtfy(JSPUtil.getParameter(request, "ntfy", ""));
		setActDys(JSPUtil.getParameter(request, "act_dys", ""));
		setGwgt(JSPUtil.getParameter(request, "gwgt", ""));
		setTwgt(JSPUtil.getParameter(request, "twgt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setFrtCltFlg(JSPUtil.getParameter(request, "frt_clt_flg", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setMnrHngrBarTpCd(JSPUtil.getParameter(request, "mnr_hngr_bar_tp_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setCntrHngrBarAtchKnt(JSPUtil.getParameter(request, "cntr_hngr_bar_atch_knt", ""));
		setObSlsOfcCd(JSPUtil.getParameter(request, "ob_sls_ofc_cd", ""));
		setObSrepCd(JSPUtil.getParameter(request, "ob_srep_cd", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setUclmLsFlg(JSPUtil.getParameter(request, "uclm_ls_flg", ""));
		setRepCmdtNm(JSPUtil.getParameter(request, "rep_cmdt_nm", ""));
		setLessor(JSPUtil.getParameter(request, "lessor", ""));
		setCnmvDt(JSPUtil.getParameter(request, "cnmv_dt", ""));
		setStayDays11(JSPUtil.getParameter(request, "stay_days11", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setStayDays12(JSPUtil.getParameter(request, "stay_days12", ""));
		setCnmvEvntDt(JSPUtil.getParameter(request, "cnmv_evnt_dt", ""));
		setOblRdemFlg(JSPUtil.getParameter(request, "obl_rdem_flg", ""));
		setStayDays13(JSPUtil.getParameter(request, "stay_days13", ""));
		setStayDays14(JSPUtil.getParameter(request, "stay_days14", ""));
		setStayDays15(JSPUtil.getParameter(request, "stay_days15", ""));
		setStayDays3(JSPUtil.getParameter(request, "stay_days3", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setStayDays2(JSPUtil.getParameter(request, "stay_days2", ""));
		setDispFlg(JSPUtil.getParameter(request, "disp_flg", ""));
		setStayDays1(JSPUtil.getParameter(request, "stay_days1", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setUclmLsDivCd(JSPUtil.getParameter(request, "uclm_ls_div_cd", ""));
		setStayDays7(JSPUtil.getParameter(request, "stay_days7", ""));
		setStayDays6(JSPUtil.getParameter(request, "stay_days6", ""));
		setStayDays10(JSPUtil.getParameter(request, "stay_days10", ""));
		setStayDays5(JSPUtil.getParameter(request, "stay_days5", ""));
		setStayDays4(JSPUtil.getParameter(request, "stay_days4", ""));
		setNextVvd(JSPUtil.getParameter(request, "next_vvd", ""));
		setFullFlg(JSPUtil.getParameter(request, "full_flg", ""));
		setStayDays9(JSPUtil.getParameter(request, "stay_days9", ""));
		setStayDays8(JSPUtil.getParameter(request, "stay_days8", ""));
		setStayDays(JSPUtil.getParameter(request, "stay_days", ""));
		setCntrHngrRckCd(JSPUtil.getParameter(request, "cntr_hngr_rck_cd", ""));
		setPkupNo(JSPUtil.getParameter(request, "pkup_no", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setCrntYdCd(JSPUtil.getParameter(request, "crnt_yd_cd", ""));
		setTotDays(JSPUtil.getParameter(request, "tot_days", ""));
		setDtyFreeDt(JSPUtil.getParameter(request, "dty_free_dt", ""));
		setDmgFlg(JSPUtil.getParameter(request, "dmg_flg", ""));
		setMkDesc(JSPUtil.getParameter(request, "mk_desc", ""));
		setPolEtd(JSPUtil.getParameter(request, "pol_etd", ""));
		setRfaNo(JSPUtil.getParameter(request, "rfa_no", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, "cnmv_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFtEndDt(JSPUtil.getParameter(request, "ft_end_dt", ""));
		setSubLocCd(JSPUtil.getParameter(request, "sub_loc_cd", ""));
		setOrgYdCd(JSPUtil.getParameter(request, "org_yd_cd", ""));
		setPlstFlrFlg(JSPUtil.getParameter(request, "plst_flr_flg", ""));
		setCmdtNm(JSPUtil.getParameter(request, "cmdt_nm", ""));
		setMftDt(JSPUtil.getParameter(request, "mft_dt", ""));
		setDeTermCd(JSPUtil.getParameter(request, "de_term_cd", ""));
		setMvmtStsCd(JSPUtil.getParameter(request, "mvmt_sts_cd", ""));
		setFtDys(JSPUtil.getParameter(request, "ft_dys", ""));
		setScRfaNo(JSPUtil.getParameter(request, "sc_rfa_no", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setPwgt(JSPUtil.getParameter(request, "pwgt", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setCnee(JSPUtil.getParameter(request, "cnee", ""));
		setImdtExtFlg(JSPUtil.getParameter(request, "imdt_ext_flg", ""));
		setShpr(JSPUtil.getParameter(request, "shpr", ""));
		setRfTpCd(JSPUtil.getParameter(request, "rf_tp_cd", ""));
		setCstmsClrFlg(JSPUtil.getParameter(request, "cstms_clr_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SDaysLisDetailVO[]
	 */
	public SDaysLisDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SDaysLisDetailVO[]
	 */
	public SDaysLisDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SDaysLisDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ntfy = (JSPUtil.getParameter(request, prefix	+ "ntfy", length));
			String[] actDys = (JSPUtil.getParameter(request, prefix	+ "act_dys", length));
			String[] gwgt = (JSPUtil.getParameter(request, prefix	+ "gwgt", length));
			String[] twgt = (JSPUtil.getParameter(request, prefix	+ "twgt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] frtCltFlg = (JSPUtil.getParameter(request, prefix	+ "frt_clt_flg", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] mnrHngrBarTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_hngr_bar_tp_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] cntrHngrBarAtchKnt = (JSPUtil.getParameter(request, prefix	+ "cntr_hngr_bar_atch_knt", length));
			String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ob_sls_ofc_cd", length));
			String[] obSrepCd = (JSPUtil.getParameter(request, prefix	+ "ob_srep_cd", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] uclmLsFlg = (JSPUtil.getParameter(request, prefix	+ "uclm_ls_flg", length));
			String[] repCmdtNm = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_nm", length));
			String[] lessor = (JSPUtil.getParameter(request, prefix	+ "lessor", length));
			String[] cnmvDt = (JSPUtil.getParameter(request, prefix	+ "cnmv_dt", length));
			String[] stayDays11 = (JSPUtil.getParameter(request, prefix	+ "stay_days11", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] stayDays12 = (JSPUtil.getParameter(request, prefix	+ "stay_days12", length));
			String[] cnmvEvntDt = (JSPUtil.getParameter(request, prefix	+ "cnmv_evnt_dt", length));
			String[] oblRdemFlg = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_flg", length));
			String[] stayDays13 = (JSPUtil.getParameter(request, prefix	+ "stay_days13", length));
			String[] stayDays14 = (JSPUtil.getParameter(request, prefix	+ "stay_days14", length));
			String[] stayDays15 = (JSPUtil.getParameter(request, prefix	+ "stay_days15", length));
			String[] stayDays3 = (JSPUtil.getParameter(request, prefix	+ "stay_days3", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] stayDays2 = (JSPUtil.getParameter(request, prefix	+ "stay_days2", length));
			String[] dispFlg = (JSPUtil.getParameter(request, prefix	+ "disp_flg", length));
			String[] stayDays1 = (JSPUtil.getParameter(request, prefix	+ "stay_days1", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] uclmLsDivCd = (JSPUtil.getParameter(request, prefix	+ "uclm_ls_div_cd", length));
			String[] stayDays7 = (JSPUtil.getParameter(request, prefix	+ "stay_days7", length));
			String[] stayDays6 = (JSPUtil.getParameter(request, prefix	+ "stay_days6", length));
			String[] stayDays10 = (JSPUtil.getParameter(request, prefix	+ "stay_days10", length));
			String[] stayDays5 = (JSPUtil.getParameter(request, prefix	+ "stay_days5", length));
			String[] stayDays4 = (JSPUtil.getParameter(request, prefix	+ "stay_days4", length));
			String[] nextVvd = (JSPUtil.getParameter(request, prefix	+ "next_vvd", length));
			String[] fullFlg = (JSPUtil.getParameter(request, prefix	+ "full_flg", length));
			String[] stayDays9 = (JSPUtil.getParameter(request, prefix	+ "stay_days9", length));
			String[] stayDays8 = (JSPUtil.getParameter(request, prefix	+ "stay_days8", length));
			String[] stayDays = (JSPUtil.getParameter(request, prefix	+ "stay_days", length));
			String[] cntrHngrRckCd = (JSPUtil.getParameter(request, prefix	+ "cntr_hngr_rck_cd", length));
			String[] pkupNo = (JSPUtil.getParameter(request, prefix	+ "pkup_no", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] crntYdCd = (JSPUtil.getParameter(request, prefix	+ "crnt_yd_cd", length));
			String[] totDays = (JSPUtil.getParameter(request, prefix	+ "tot_days", length));
			String[] dtyFreeDt = (JSPUtil.getParameter(request, prefix	+ "dty_free_dt", length));
			String[] dmgFlg = (JSPUtil.getParameter(request, prefix	+ "dmg_flg", length));
			String[] mkDesc = (JSPUtil.getParameter(request, prefix	+ "mk_desc", length));
			String[] polEtd = (JSPUtil.getParameter(request, prefix	+ "pol_etd", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ftEndDt = (JSPUtil.getParameter(request, prefix	+ "ft_end_dt", length));
			String[] subLocCd = (JSPUtil.getParameter(request, prefix	+ "sub_loc_cd", length));
			String[] orgYdCd = (JSPUtil.getParameter(request, prefix	+ "org_yd_cd", length));
			String[] plstFlrFlg = (JSPUtil.getParameter(request, prefix	+ "plst_flr_flg", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] mftDt = (JSPUtil.getParameter(request, prefix	+ "mft_dt", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] mvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd", length));
			String[] ftDys = (JSPUtil.getParameter(request, prefix	+ "ft_dys", length));
			String[] scRfaNo = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] pwgt = (JSPUtil.getParameter(request, prefix	+ "pwgt", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] cnee = (JSPUtil.getParameter(request, prefix	+ "cnee", length));
			String[] imdtExtFlg = (JSPUtil.getParameter(request, prefix	+ "imdt_ext_flg", length));
			String[] shpr = (JSPUtil.getParameter(request, prefix	+ "shpr", length));
			String[] rfTpCd = (JSPUtil.getParameter(request, prefix	+ "rf_tp_cd", length));
			String[] cstmsClrFlg = (JSPUtil.getParameter(request, prefix	+ "cstms_clr_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new SDaysLisDetailVO();
				if (ntfy[i] != null)
					model.setNtfy(ntfy[i]);
				if (actDys[i] != null)
					model.setActDys(actDys[i]);
				if (gwgt[i] != null)
					model.setGwgt(gwgt[i]);
				if (twgt[i] != null)
					model.setTwgt(twgt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (frtCltFlg[i] != null)
					model.setFrtCltFlg(frtCltFlg[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (mnrHngrBarTpCd[i] != null)
					model.setMnrHngrBarTpCd(mnrHngrBarTpCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (cntrHngrBarAtchKnt[i] != null)
					model.setCntrHngrBarAtchKnt(cntrHngrBarAtchKnt[i]);
				if (obSlsOfcCd[i] != null)
					model.setObSlsOfcCd(obSlsOfcCd[i]);
				if (obSrepCd[i] != null)
					model.setObSrepCd(obSrepCd[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (uclmLsFlg[i] != null)
					model.setUclmLsFlg(uclmLsFlg[i]);
				if (repCmdtNm[i] != null)
					model.setRepCmdtNm(repCmdtNm[i]);
				if (lessor[i] != null)
					model.setLessor(lessor[i]);
				if (cnmvDt[i] != null)
					model.setCnmvDt(cnmvDt[i]);
				if (stayDays11[i] != null)
					model.setStayDays11(stayDays11[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (stayDays12[i] != null)
					model.setStayDays12(stayDays12[i]);
				if (cnmvEvntDt[i] != null)
					model.setCnmvEvntDt(cnmvEvntDt[i]);
				if (oblRdemFlg[i] != null)
					model.setOblRdemFlg(oblRdemFlg[i]);
				if (stayDays13[i] != null)
					model.setStayDays13(stayDays13[i]);
				if (stayDays14[i] != null)
					model.setStayDays14(stayDays14[i]);
				if (stayDays15[i] != null)
					model.setStayDays15(stayDays15[i]);
				if (stayDays3[i] != null)
					model.setStayDays3(stayDays3[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (stayDays2[i] != null)
					model.setStayDays2(stayDays2[i]);
				if (dispFlg[i] != null)
					model.setDispFlg(dispFlg[i]);
				if (stayDays1[i] != null)
					model.setStayDays1(stayDays1[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (uclmLsDivCd[i] != null)
					model.setUclmLsDivCd(uclmLsDivCd[i]);
				if (stayDays7[i] != null)
					model.setStayDays7(stayDays7[i]);
				if (stayDays6[i] != null)
					model.setStayDays6(stayDays6[i]);
				if (stayDays10[i] != null)
					model.setStayDays10(stayDays10[i]);
				if (stayDays5[i] != null)
					model.setStayDays5(stayDays5[i]);
				if (stayDays4[i] != null)
					model.setStayDays4(stayDays4[i]);
				if (nextVvd[i] != null)
					model.setNextVvd(nextVvd[i]);
				if (fullFlg[i] != null)
					model.setFullFlg(fullFlg[i]);
				if (stayDays9[i] != null)
					model.setStayDays9(stayDays9[i]);
				if (stayDays8[i] != null)
					model.setStayDays8(stayDays8[i]);
				if (stayDays[i] != null)
					model.setStayDays(stayDays[i]);
				if (cntrHngrRckCd[i] != null)
					model.setCntrHngrRckCd(cntrHngrRckCd[i]);
				if (pkupNo[i] != null)
					model.setPkupNo(pkupNo[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (crntYdCd[i] != null)
					model.setCrntYdCd(crntYdCd[i]);
				if (totDays[i] != null)
					model.setTotDays(totDays[i]);
				if (dtyFreeDt[i] != null)
					model.setDtyFreeDt(dtyFreeDt[i]);
				if (dmgFlg[i] != null)
					model.setDmgFlg(dmgFlg[i]);
				if (mkDesc[i] != null)
					model.setMkDesc(mkDesc[i]);
				if (polEtd[i] != null)
					model.setPolEtd(polEtd[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ftEndDt[i] != null)
					model.setFtEndDt(ftEndDt[i]);
				if (subLocCd[i] != null)
					model.setSubLocCd(subLocCd[i]);
				if (orgYdCd[i] != null)
					model.setOrgYdCd(orgYdCd[i]);
				if (plstFlrFlg[i] != null)
					model.setPlstFlrFlg(plstFlrFlg[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (mftDt[i] != null)
					model.setMftDt(mftDt[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (mvmtStsCd[i] != null)
					model.setMvmtStsCd(mvmtStsCd[i]);
				if (ftDys[i] != null)
					model.setFtDys(ftDys[i]);
				if (scRfaNo[i] != null)
					model.setScRfaNo(scRfaNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (pwgt[i] != null)
					model.setPwgt(pwgt[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (cnee[i] != null)
					model.setCnee(cnee[i]);
				if (imdtExtFlg[i] != null)
					model.setImdtExtFlg(imdtExtFlg[i]);
				if (shpr[i] != null)
					model.setShpr(shpr[i]);
				if (rfTpCd[i] != null)
					model.setRfTpCd(rfTpCd[i]);
				if (cstmsClrFlg[i] != null)
					model.setCstmsClrFlg(cstmsClrFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSDaysLisDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SDaysLisDetailVO[]
	 */
	public SDaysLisDetailVO[] getSDaysLisDetailVOs(){
		SDaysLisDetailVO[] vos = (SDaysLisDetailVO[])models.toArray(new SDaysLisDetailVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.ntfy = this.ntfy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDys = this.actDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gwgt = this.gwgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.twgt = this.twgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtCltFlg = this.frtCltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrHngrBarTpCd = this.mnrHngrBarTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrBarAtchKnt = this.cntrHngrBarAtchKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcCd = this.obSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSrepCd = this.obSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uclmLsFlg = this.uclmLsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtNm = this.repCmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lessor = this.lessor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvDt = this.cnmvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays11 = this.stayDays11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays12 = this.stayDays12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvEvntDt = this.cnmvEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemFlg = this.oblRdemFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays13 = this.stayDays13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays14 = this.stayDays14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays15 = this.stayDays15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays3 = this.stayDays3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays2 = this.stayDays2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispFlg = this.dispFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays1 = this.stayDays1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uclmLsDivCd = this.uclmLsDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays7 = this.stayDays7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays6 = this.stayDays6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays10 = this.stayDays10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays5 = this.stayDays5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays4 = this.stayDays4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextVvd = this.nextVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullFlg = this.fullFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays9 = this.stayDays9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays8 = this.stayDays8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays = this.stayDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrRckCd = this.cntrHngrRckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNo = this.pkupNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd = this.crntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totDays = this.totDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtyFreeDt = this.dtyFreeDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgFlg = this.dmgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mkDesc = this.mkDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEtd = this.polEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftEndDt = this.ftEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subLocCd = this.subLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd = this.orgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plstFlrFlg = this.plstFlrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mftDt = this.mftDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd = this.mvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftDys = this.ftDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaNo = this.scRfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pwgt = this.pwgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee = this.cnee .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdtExtFlg = this.imdtExtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr = this.shpr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfTpCd = this.rfTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsClrFlg = this.cstmsClrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
