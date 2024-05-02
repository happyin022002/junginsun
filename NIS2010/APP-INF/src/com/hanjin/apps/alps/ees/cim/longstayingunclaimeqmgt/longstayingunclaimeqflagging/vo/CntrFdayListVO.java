/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CntrFdayList.java
*@FileTitle : CntrFdayList
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.25
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2010.03.25 김종준 
* 1.0 Creation
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

public class CntrFdayListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CntrFdayListVO> models = new ArrayList<CntrFdayListVO>();
	
	/* Column Info */
	private String ntfy = null;
	/* Column Info */
	private String actDys = null;
	/* Column Info */
	private String rccDate = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String obSlsOfcCd = null;
	/* Column Info */
	private String obSrepCd = null;
	/* Column Info */
	private String uclmLsFlg = null;
	/* Column Info */
	private String repCmdtNm = null;
	/* Column Info */
	private String cnmvDt = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String loadVvd = null;
	/* Column Info */
	private String discVvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String dispFlg = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String uclmLsDivCd = null;
	/* Column Info */
	private String fullFlg = null;
	/* Column Info */
	private String stayDays = null;
	/* Column Info */
	private String freeDays = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String crntYdCd = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String dmgFlg = null;
	/* Column Info */
	private String polEtd = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ftEndDt = null;
	/* Column Info */
	private String subLocCd = null;
	/* Column Info */
	private String rccCd = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String ftDys = null;
	/* Column Info */
	private String scRfaNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String cnee = null;
	/* Column Info */
	private String shpr = null;
	/* Column Info */
	private String rfTpCd = null;
	/* Column Info */
	private String bkgCgoTpCd = null;


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CntrFdayListVO() {}

	public CntrFdayListVO(String ibflag, String pagerows, String vvd, String loadVvd, String discVvd, String polCd, String podCd, String delCd, String stayDays, String freeDays, String cntrNo, String cntrTpszCd, String fullFlg, String cnmvDt, String bkgNo, String blNo, String dmgFlg, String dispFlg, String seq, String crntYdCd, String lstmCd, String cnmvStsCd, String porCd, String polEtd, String shpr, String cnee, String ntfy, String scRfaNo, String uclmLsDivCd, String uclmLsFlg, String deTermCd, String rfTpCd, String cmdtNm, String obSlsOfcCd, String obSrepCd, String subLocCd, String repCmdtNm, String rccCd, String rccDate, String ftDys, String ftEndDt, String actDys, String bkgCgoTpCd) {
		this.ntfy = ntfy;
		this.actDys = actDys;
		this.rccDate = rccDate;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.cntrTpszCd = cntrTpszCd;
		this.obSlsOfcCd = obSlsOfcCd;
		this.obSrepCd = obSrepCd;
		this.uclmLsFlg = uclmLsFlg;
		this.repCmdtNm = repCmdtNm;
		this.cnmvDt = cnmvDt;
		this.delCd = delCd;
		this.vvd = vvd;
		this.loadVvd = loadVvd;
		this.discVvd = discVvd;
		this.podCd = podCd;
		this.dispFlg = dispFlg;
		this.bkgNo = bkgNo;
		this.uclmLsDivCd = uclmLsDivCd;
		this.fullFlg = fullFlg;
		this.stayDays = stayDays;
		this.freeDays = freeDays;
		this.porCd = porCd;
		this.crntYdCd = crntYdCd;
		this.lstmCd = lstmCd;
		this.dmgFlg = dmgFlg;
		this.polEtd = polEtd;
		this.cnmvStsCd = cnmvStsCd;
		this.ibflag = ibflag;
		this.ftEndDt = ftEndDt;
		this.subLocCd = subLocCd;
		this.rccCd = rccCd;
		this.cmdtNm = cmdtNm;
		this.deTermCd = deTermCd;
		this.ftDys = ftDys;
		this.scRfaNo = scRfaNo;
		this.cntrNo = cntrNo;
		this.seq = seq;
		this.cnee = cnee;
		this.shpr = shpr;
		this.rfTpCd = rfTpCd;
		this.bkgCgoTpCd = bkgCgoTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ntfy", getNtfy());
		this.hashColumns.put("act_dys", getActDys());
		this.hashColumns.put("rcc_date", getRccDate());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
		this.hashColumns.put("ob_srep_cd", getObSrepCd());
		this.hashColumns.put("uclm_ls_flg", getUclmLsFlg());
		this.hashColumns.put("rep_cmdt_nm", getRepCmdtNm());
		this.hashColumns.put("cnmv_dt", getCnmvDt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("load_vvd", getLoadVvd());
		this.hashColumns.put("disc_vvd", getDiscVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("disp_flg", getDispFlg());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("uclm_ls_div_cd", getUclmLsDivCd());
		this.hashColumns.put("full_flg", getFullFlg());
		this.hashColumns.put("stay_days", getStayDays());
		this.hashColumns.put("free_days", getFreeDays());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("dmg_flg", getDmgFlg());
		this.hashColumns.put("pol_etd", getPolEtd());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ft_end_dt", getFtEndDt());
		this.hashColumns.put("sub_loc_cd", getSubLocCd());
		this.hashColumns.put("rcc_cd", getRccCd());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("ft_dys", getFtDys());
		this.hashColumns.put("sc_rfa_no", getScRfaNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("cnee", getCnee());
		this.hashColumns.put("shpr", getShpr());
		this.hashColumns.put("rf_tp_cd", getRfTpCd());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ntfy", "ntfy");
		this.hashFields.put("act_dys", "actDys");
		this.hashFields.put("rcc_date", "rccDate");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
		this.hashFields.put("ob_srep_cd", "obSrepCd");
		this.hashFields.put("uclm_ls_flg", "uclmLsFlg");
		this.hashFields.put("rep_cmdt_nm", "repCmdtNm");
		this.hashFields.put("cnmv_dt", "cnmvDt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("load_vvd", "loadVvd");
		this.hashFields.put("disc_vvd", "discVvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("disp_flg", "dispFlg");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("uclm_ls_div_cd", "uclmLsDivCd");
		this.hashFields.put("full_flg", "fullFlg");
		this.hashFields.put("stay_days", "stayDays");
		this.hashFields.put("free_days", "freeDays");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("dmg_flg", "dmgFlg");
		this.hashFields.put("pol_etd", "polEtd");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ft_end_dt", "ftEndDt");
		this.hashFields.put("sub_loc_cd", "subLocCd");
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("ft_dys", "ftDys");
		this.hashFields.put("sc_rfa_no", "scRfaNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("cnee", "cnee");
		this.hashFields.put("shpr", "shpr");
		this.hashFields.put("rf_tp_cd", "rfTpCd");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
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
	 * @return rccDate
	 */
	public String getRccDate() {
		return this.rccDate;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return loadVvd
	 */
	public String getLoadVvd() {
		return this.loadVvd;
	}
	/**
	 * Column Info
	 * @return discVvd
	 */
	public String getDiscVvd() {
		return this.discVvd;
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
	 * @return dispFlg
	 */
	public String getDispFlg() {
		return this.dispFlg;
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
	 * @return fullFlg
	 */
	public String getFullFlg() {
		return this.fullFlg;
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
	 * @return freeDays
	 */
	public String getFreeDays() {
		return this.freeDays;
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
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
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
	 * @return polEtd
	 */
	public String getPolEtd() {
		return this.polEtd;
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
	 * @return rccCd
	 */
	public String getRccCd() {
		return this.rccCd;
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
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
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
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
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
	 * @param rccDate
	 */
	public void setRccDate(String rccDate) {
		this.rccDate = rccDate;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
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
	 * @param obSrepCd
	 */
	public void setObSrepCd(String obSrepCd) {
		this.obSrepCd = obSrepCd;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param loadVvd
	 */
	public void setLoadVvd(String loadVvd) {
		this.loadVvd = loadVvd;
	}
	
	/**
	 * Column Info
	 * @param discVvd
	 */
	public void setDiscVvd(String discVvd) {
		this.discVvd = discVvd;
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
	 * @param dispFlg
	 */
	public void setDispFlg(String dispFlg) {
		this.dispFlg = dispFlg;
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
	 * @param fullFlg
	 */
	public void setFullFlg(String fullFlg) {
		this.fullFlg = fullFlg;
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
	 * @param freeDays
	 */
	public void setFreeDays(String freeDays) {
		this.freeDays = freeDays;
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
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
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
	 * @param polEtd
	 */
	public void setPolEtd(String polEtd) {
		this.polEtd = polEtd;
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
	 * @param rccCd
	 */
	public void setRccCd(String rccCd) {
		this.rccCd = rccCd;
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
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
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
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setNtfy(JSPUtil.getParameter(request, "ntfy", ""));
		setActDys(JSPUtil.getParameter(request, "act_dys", ""));
		setRccDate(JSPUtil.getParameter(request, "rcc_date", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setObSlsOfcCd(JSPUtil.getParameter(request, "ob_sls_ofc_cd", ""));
		setObSrepCd(JSPUtil.getParameter(request, "ob_srep_cd", ""));
		setUclmLsFlg(JSPUtil.getParameter(request, "uclm_ls_flg", ""));
		setRepCmdtNm(JSPUtil.getParameter(request, "rep_cmdt_nm", ""));
		setCnmvDt(JSPUtil.getParameter(request, "cnmv_dt", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setLoadVvd(JSPUtil.getParameter(request, "load_vvd", ""));
		setDiscVvd(JSPUtil.getParameter(request, "disc_vvd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setDispFlg(JSPUtil.getParameter(request, "disp_flg", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setUclmLsDivCd(JSPUtil.getParameter(request, "uclm_ls_div_cd", ""));
		setFullFlg(JSPUtil.getParameter(request, "full_flg", ""));
		setStayDays(JSPUtil.getParameter(request, "stay_days", ""));
		setFreeDays(JSPUtil.getParameter(request, "free_days", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setCrntYdCd(JSPUtil.getParameter(request, "crnt_yd_cd", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setDmgFlg(JSPUtil.getParameter(request, "dmg_flg", ""));
		setPolEtd(JSPUtil.getParameter(request, "pol_etd", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, "cnmv_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFtEndDt(JSPUtil.getParameter(request, "ft_end_dt", ""));
		setSubLocCd(JSPUtil.getParameter(request, "sub_loc_cd", ""));
		setRccCd(JSPUtil.getParameter(request, "rcc_cd", ""));
		setCmdtNm(JSPUtil.getParameter(request, "cmdt_nm", ""));
		setDeTermCd(JSPUtil.getParameter(request, "de_term_cd", ""));
		setFtDys(JSPUtil.getParameter(request, "ft_dys", ""));
		setScRfaNo(JSPUtil.getParameter(request, "sc_rfa_no", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setCnee(JSPUtil.getParameter(request, "cnee", ""));
		setShpr(JSPUtil.getParameter(request, "shpr", ""));
		setRfTpCd(JSPUtil.getParameter(request, "rf_tp_cd", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, "bkg_cgo_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CntrFdayList[]
	 */
	public CntrFdayListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CntrFdayList[]
	 */
	public CntrFdayListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CntrFdayListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ntfy = (JSPUtil.getParameter(request, prefix	+ "ntfy", length));
			String[] actDys = (JSPUtil.getParameter(request, prefix	+ "act_dys", length));
			String[] rccDate = (JSPUtil.getParameter(request, prefix	+ "rcc_date", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ob_sls_ofc_cd", length));
			String[] obSrepCd = (JSPUtil.getParameter(request, prefix	+ "ob_srep_cd", length));
			String[] uclmLsFlg = (JSPUtil.getParameter(request, prefix	+ "uclm_ls_flg", length));
			String[] repCmdtNm = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_nm", length));
			String[] cnmvDt = (JSPUtil.getParameter(request, prefix	+ "cnmv_dt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] loadVvd = (JSPUtil.getParameter(request, prefix	+ "load_vvd", length));
			String[] discVvd = (JSPUtil.getParameter(request, prefix	+ "disc_vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] dispFlg = (JSPUtil.getParameter(request, prefix	+ "disp_flg", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] uclmLsDivCd = (JSPUtil.getParameter(request, prefix	+ "uclm_ls_div_cd", length));
			String[] fullFlg = (JSPUtil.getParameter(request, prefix	+ "full_flg", length));
			String[] stayDays = (JSPUtil.getParameter(request, prefix	+ "stay_days", length));
			String[] freeDays = (JSPUtil.getParameter(request, prefix	+ "free_days", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] crntYdCd = (JSPUtil.getParameter(request, prefix	+ "crnt_yd_cd", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] dmgFlg = (JSPUtil.getParameter(request, prefix	+ "dmg_flg", length));
			String[] polEtd = (JSPUtil.getParameter(request, prefix	+ "pol_etd", length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ftEndDt = (JSPUtil.getParameter(request, prefix	+ "ft_end_dt", length));
			String[] subLocCd = (JSPUtil.getParameter(request, prefix	+ "sub_loc_cd", length));
			String[] rccCd = (JSPUtil.getParameter(request, prefix	+ "rcc_cd", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] ftDys = (JSPUtil.getParameter(request, prefix	+ "ft_dys", length));
			String[] scRfaNo = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] cnee = (JSPUtil.getParameter(request, prefix	+ "cnee", length));
			String[] shpr = (JSPUtil.getParameter(request, prefix	+ "shpr", length));
			String[] rfTpCd = (JSPUtil.getParameter(request, prefix	+ "rf_tp_cd", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CntrFdayListVO();
				if (ntfy[i] != null)
					model.setNtfy(ntfy[i]);
				if (actDys[i] != null)
					model.setActDys(actDys[i]);
				if (rccDate[i] != null)
					model.setRccDate(rccDate[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (obSlsOfcCd[i] != null)
					model.setObSlsOfcCd(obSlsOfcCd[i]);
				if (obSrepCd[i] != null)
					model.setObSrepCd(obSrepCd[i]);
				if (uclmLsFlg[i] != null)
					model.setUclmLsFlg(uclmLsFlg[i]);
				if (repCmdtNm[i] != null)
					model.setRepCmdtNm(repCmdtNm[i]);
				if (cnmvDt[i] != null)
					model.setCnmvDt(cnmvDt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (loadVvd[i] != null)
					model.setLoadVvd(loadVvd[i]);
				if (discVvd[i] != null)
					model.setDiscVvd(discVvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (dispFlg[i] != null)
					model.setDispFlg(dispFlg[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (uclmLsDivCd[i] != null)
					model.setUclmLsDivCd(uclmLsDivCd[i]);
				if (fullFlg[i] != null)
					model.setFullFlg(fullFlg[i]);
				if (stayDays[i] != null)
					model.setStayDays(stayDays[i]);
				if (freeDays[i] != null)
					model.setFreeDays(freeDays[i]);
				if (freeDays[i] != null)
					model.setFreeDays(freeDays[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (crntYdCd[i] != null)
					model.setCrntYdCd(crntYdCd[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (dmgFlg[i] != null)
					model.setDmgFlg(dmgFlg[i]);
				if (polEtd[i] != null)
					model.setPolEtd(polEtd[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ftEndDt[i] != null)
					model.setFtEndDt(ftEndDt[i]);
				if (subLocCd[i] != null)
					model.setSubLocCd(subLocCd[i]);
				if (rccCd[i] != null)
					model.setRccCd(rccCd[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (ftDys[i] != null)
					model.setFtDys(ftDys[i]);
				if (scRfaNo[i] != null)
					model.setScRfaNo(scRfaNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (cnee[i] != null)
					model.setCnee(cnee[i]);
				if (shpr[i] != null)
					model.setShpr(shpr[i]);
				if (rfTpCd[i] != null)
					model.setRfTpCd(rfTpCd[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCntrFdayListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CntrFdayList[]
	 */
	public CntrFdayListVO[] getCntrFdayListVOs(){
		CntrFdayListVO[] vos = (CntrFdayListVO[])models.toArray(new CntrFdayListVO[models.size()]);
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
		this.rccDate = this.rccDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcCd = this.obSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSrepCd = this.obSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uclmLsFlg = this.uclmLsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtNm = this.repCmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvDt = this.cnmvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loadVvd = this.loadVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.discVvd = this.discVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispFlg = this.dispFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uclmLsDivCd = this.uclmLsDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullFlg = this.fullFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays = this.stayDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freeDays = this.freeDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd = this.crntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgFlg = this.dmgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEtd = this.polEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftEndDt = this.ftEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subLocCd = this.subLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd = this.rccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftDys = this.ftDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaNo = this.scRfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee = this.cnee .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr = this.shpr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfTpCd = this.rfTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
