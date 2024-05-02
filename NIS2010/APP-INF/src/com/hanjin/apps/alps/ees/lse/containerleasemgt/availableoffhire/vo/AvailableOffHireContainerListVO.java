/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AvailableOffHireContainerListVO.java
*@FileTitle : AvailableOffHireContainerListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.13
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.13  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.vo;

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

public class AvailableOffHireContainerListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AvailableOffHireContainerListVO> models = new ArrayList<AvailableOffHireContainerListVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String strEstmDt = null;
	/* Column Info */
	private String sccList = null;
	/* Column Info */
	private String endEstmDt = null;
	/* Column Info */
	private String crntYdCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polEtd = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String mvmtSts = null;
	/* Column Info */
	private String locTp = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String cnmvDt = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String targetScc = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String refNo = null;
	/* Column Info */
	private String fullFlg = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String podEta = null;
	/* Column Info */
	private String radTp = null;
	/* Column Info */
	private String lccCd = null;
	/* Column Info */
	private String dol0 = null;
	private String dol1 = null;
	private String dol2 = null;
	private String dol3 = null;
	private String dol4 = null;
	private String dol5 = null;
	private String dol6 = null;
	private String dol7 = null;
	private String dol8 = null;
	private String dol9 = null;
	private String dol10 = null;
	/* Column Info */
	private String mtRtnYd = null;
	private String delScc = null;
	private String mtRtnScc = null;
	private String delDol = null;
	private String mtRtnDol = null;
	private String currYdDol = null;
	private String soNo = null;
	private String woNo = null;
	private String vndrTp = null;
	private String vndrCd = null;
	private String vndrNm = null;
	private String deTerm = null;
	private String dolTp = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AvailableOffHireContainerListVO() {}

	public AvailableOffHireContainerListVO(String ibflag, String pagerows, String cntrNo, String cntrTpszCd, String lstmCd, String agmtCtyCd, String agmtSeq, String agmtNo, String refNo, String vndrAbbrNm, String crntYdCd, String cnmvStsCd, String mvmtSts, String cnmvDt, String bkgNo, String polCd, String porCd, String podCd, String delCd, String polEtd, String podEta, String vvdCd, String locTp, String locCd, String targetScc, String sccList, String strEstmDt, String endEstmDt, String vndrSeq, String fullFlg, String radTp, String dol0, String dol1, String dol2, String dol3, String dol4, String dol5, String dol6, String dol7, String dol8, String dol9, String lccCd, String dol10, String mtRtnYd, String dolTp, String delScc, String mtRtnScc, String delDol, String mtRtnDol, String currYdDol, String soNo, String woNo, String vndrTp, String vndrCd, String vndrNm, String deTerm) {
		this.porCd = porCd;
		this.strEstmDt = strEstmDt;
		this.sccList = sccList;
		this.endEstmDt = endEstmDt;
		this.crntYdCd = crntYdCd;
		this.pagerows = pagerows;
		this.polEtd = polEtd;
		this.cnmvStsCd = cnmvStsCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.locCd = locCd;
		this.vvdCd = vvdCd;
		this.agmtCtyCd = agmtCtyCd;
		this.cntrTpszCd = cntrTpszCd;
		this.lstmCd = lstmCd;
		this.mvmtSts = mvmtSts;
		this.locTp = locTp;
		this.agmtSeq = agmtSeq;
		this.cnmvDt = cnmvDt;
		this.agmtNo = agmtNo;
		this.delCd = delCd;
		this.targetScc = targetScc;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.vndrSeq = vndrSeq;
		this.cntrNo = cntrNo;
		this.refNo = refNo;
		this.fullFlg = fullFlg;
		this.vndrAbbrNm = vndrAbbrNm;
		this.podEta = podEta;
		this.radTp = radTp;
		this.dol0 = dol0;
		this.dol1 = dol1;
		this.dol2 = dol2;
		this.dol3 = dol3;
		this.dol4 = dol4;
		this.dol5 = dol5;
		this.dol6 = dol6;
		this.dol7 = dol7;
		this.dol8 = dol8;
		this.dol9 = dol9;
		this.dol10 = dol10;
		this.lccCd = lccCd;
		this.mtRtnYd = mtRtnYd;
		this.delScc = delScc;
		this.mtRtnScc = mtRtnScc;
		this.delDol = delDol;
		this.mtRtnDol = mtRtnDol;
		this.currYdDol = currYdDol;
		this.soNo = soNo;
		this.woNo = woNo;
		this.vndrTp = vndrTp;
		this.vndrCd = vndrCd;
		this.vndrNm = vndrNm;
		this.deTerm = deTerm;
		this.dolTp = dolTp;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("str_estm_dt", getStrEstmDt());
		this.hashColumns.put("scc_list", getSccList());
		this.hashColumns.put("end_estm_dt", getEndEstmDt());
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_etd", getPolEtd());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("mvmt_sts", getMvmtSts());
		this.hashColumns.put("loc_tp", getLocTp());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("cnmv_dt", getCnmvDt());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("target_scc", getTargetScc());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("ref_no", getRefNo());
		this.hashColumns.put("full_flg", getFullFlg());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("pod_eta", getPodEta());
		this.hashColumns.put("rad_tp", getRadTp());
		this.hashColumns.put("dol0", getDol0());
		this.hashColumns.put("dol1", getDol1());
		this.hashColumns.put("dol2", getDol2());
		this.hashColumns.put("dol3", getDol3());
		this.hashColumns.put("dol4", getDol4());
		this.hashColumns.put("dol5", getDol5());
		this.hashColumns.put("dol6", getDol6());
		this.hashColumns.put("dol7", getDol7());
		this.hashColumns.put("dol8", getDol8());
		this.hashColumns.put("dol9", getDol9());
		this.hashColumns.put("dol10", getDol10());
		this.hashColumns.put("lcc_cd", getLccCd());
		this.hashColumns.put("mt_rtn_yd", getMtRtnYd());
		this.hashColumns.put("del_scc", getDelScc());
		this.hashColumns.put("mt_rtn_scc", getMtRtnScc());
		this.hashColumns.put("del_dol", getDelDol());
		this.hashColumns.put("mt_rtn_dol", getMtRtnDol());
		this.hashColumns.put("curr_yd_dol", getCurrYdDol());
		this.hashColumns.put("so_no", getSoNo());
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("vndr_tp", getVndrTp());
		this.hashColumns.put("vndr_cd", getVndrCd());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("de_term", getDeTerm());
		this.hashColumns.put("dol_tp", getDolTp());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("str_estm_dt", "strEstmDt");
		this.hashFields.put("scc_list", "sccList");
		this.hashFields.put("end_estm_dt", "endEstmDt");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_etd", "polEtd");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("mvmt_sts", "mvmtSts");
		this.hashFields.put("loc_tp", "locTp");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("cnmv_dt", "cnmvDt");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("target_scc", "targetScc");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("full_flg", "fullFlg");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("pod_eta", "podEta");
		this.hashFields.put("rad_tp", "radTp");
		this.hashFields.put("dol0", "dol0");
		this.hashFields.put("dol1", "dol1");
		this.hashFields.put("dol2", "dol2");
		this.hashFields.put("dol3", "dol3");
		this.hashFields.put("dol4", "dol4");
		this.hashFields.put("dol5", "dol5");
		this.hashFields.put("dol6", "dol6");
		this.hashFields.put("dol7", "dol7");
		this.hashFields.put("dol8", "dol8");
		this.hashFields.put("dol9", "dol9");
		this.hashFields.put("dol10", "dol10");
		this.hashFields.put("lcc_cd", "lccCd");
		this.hashFields.put("mt_rtn_yd", "mtRtnYd");
		this.hashFields.put("del_scc", "delScc");
		this.hashFields.put("mt_rtn_scc", "mtRtnScc");
		this.hashFields.put("del_dol", "delDol");
		this.hashFields.put("mt_rtn_dol", "mtRtnDol");
		this.hashFields.put("curr_yd_dol", "currYdDol");
		this.hashFields.put("so_no", "soNo");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("vndr_tp", "vndrTp");
		this.hashFields.put("vndr_cd", "vndrCd");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("de_term", "deTerm");
		this.hashFields.put("dol_tp", "dolTp");
		return this.hashFields;
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
	 * @return strEstmDt
	 */
	public String getStrEstmDt() {
		return this.strEstmDt;
	}
	
	/**
	 * Column Info
	 * @return sccList
	 */
	public String getSccList() {
		return this.sccList;
	}
	
	/**
	 * Column Info
	 * @return endEstmDt
	 */
	public String getEndEstmDt() {
		return this.endEstmDt;
	}
	
	/**
	 * Column Info
	 * @return crntYdCd
	 */
	public String getCrntYdCd() {
		return this.crntYdCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
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
	 * @return mvmtSts
	 */
	public String getMvmtSts() {
		return this.mvmtSts;
	}
	
	/**
	 * Column Info
	 * @return locTp
	 */
	public String getLocTp() {
		return this.locTp;
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
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
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
	 * @return targetScc
	 */
	public String getTargetScc() {
		return this.targetScc;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
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
	 * @return podEta
	 */
	public String getPodEta() {
		return this.podEta;
	}
	
	/**
	 * Column Info
	 * @return radTp
	 */
	public String getRadTp() {
		return this.radTp;
	}
	
	/**
	 * Column Info
	 * @return dol0
	 */
	public String getDol0() {
		return this.dol0;
	}
	
	/**
	 * Column Info
	 * @return dol1
	 */
	public String getDol1() {
		return this.dol1;
	}
	
	/**
	 * Column Info
	 * @return dol2
	 */
	public String getDol2() {
		return this.dol2;
	}
	
	/**
	 * Column Info
	 * @return dol3
	 */
	public String getDol3() {
		return this.dol3;
	}
	
	/**
	 * Column Info
	 * @return dol4
	 */
	public String getDol4() {
		return this.dol4;
	}
	
	/**
	 * Column Info
	 * @return dol5
	 */
	public String getDol5() {
		return this.dol5;
	}
	
	/**
	 * Column Info
	 * @return dol6
	 */
	public String getDol6() {
		return this.dol6;
	}
	
	/**
	 * Column Info
	 * @return dol7
	 */
	public String getDol7() {
		return this.dol7;
	}
	
	/**
	 * Column Info
	 * @return dol8
	 */
	public String getDol8() {
		return this.dol8;
	}
	
	/**
	 * Column Info
	 * @return dol9
	 */
	public String getDol9() {
		return this.dol9;
	}
	
	/**
	 * Column Info
	 * @return dol10
	 */
	public String getDol10() {
		return this.dol10;
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
	 * @return mtRtnYd
	 */
	public String getMtRtnYd() {
		return this.mtRtnYd;
	}
	
	/**
	 * Column Info
	 * @return delScc
	 */
	public String getDelScc() {
		return this.delScc;
	}
	
	/**
	 * Column Info
	 * @return mtRtnScc
	 */
	public String getMtRtnScc() {
		return this.mtRtnScc;
	}
	
	/**
	 * Column Info
	 * @return delDol
	 */
	public String getDelDol() {
		return this.delDol;
	}
	
	/**
	 * Column Info
	 * @return mtRtnDol
	 */
	public String getMtRtnDol() {
		return this.mtRtnDol;
	}
	
	/**
	 * Column Info
	 * @return currYdDol
	 */
	public String getCurrYdDol() {
		return this.currYdDol;
	}
	
	/**
	 * Column Info
	 * @return soNo
	 */
	public String getSoNo() {
		return this.soNo;
	}
	
	/**
	 * Column Info
	 * @return woNo
	 */
	public String getWoNo() {
		return this.woNo;
	}
	
	/**
	 * Column Info
	 * @return vndrTp
	 */
	public String getVndrTp() {
		return this.vndrTp;
	}
	
	/**
	 * Column Info
	 * @return vndrCd
	 */
	public String getVndrCd() {
		return this.vndrCd;
	}
	
	/**
	 * Column Info
	 * @return vndrNm
	 */
	public String getVndrNm() {
		return this.vndrNm;
	}
	
	/**
	 * Column Info
	 * @return deTerm
	 */
	public String getDeTerm() {
		return this.deTerm;
	}
	
	/**
	 * Column Info
	 * @return dolTp
	 */
	public String getDolTp() {
		return this.dolTp;
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
	 * @param strEstmDt
	 */
	public void setStrEstmDt(String strEstmDt) {
		this.strEstmDt = strEstmDt;
	}
	
	/**
	 * Column Info
	 * @param sccList
	 */
	public void setSccList(String sccList) {
		this.sccList = sccList;
	}
	
	/**
	 * Column Info
	 * @param endEstmDt
	 */
	public void setEndEstmDt(String endEstmDt) {
		this.endEstmDt = endEstmDt;
	}
	
	/**
	 * Column Info
	 * @param crntYdCd
	 */
	public void setCrntYdCd(String crntYdCd) {
		this.crntYdCd = crntYdCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
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
	 * @param mvmtSts
	 */
	public void setMvmtSts(String mvmtSts) {
		this.mvmtSts = mvmtSts;
	}
	
	/**
	 * Column Info
	 * @param locTp
	 */
	public void setLocTp(String locTp) {
		this.locTp = locTp;
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
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
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
	 * @param targetScc
	 */
	public void setTargetScc(String targetScc) {
		this.targetScc = targetScc;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
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
	 * @param podEta
	 */
	public void setPodEta(String podEta) {
		this.podEta = podEta;
	}
	
	/**
	 * Column Info
	 * @param radTp
	 */
	public void setRadTp(String radTp) {
		this.radTp = radTp;
	}

	/**
	 * Column Info
	 * @param dol0
	 */
	public void setDol0(String dol0) {
		this.dol0 = dol0;
	}
	
	/**
	 * Column Info
	 * @param dol1
	 */
	public void setDol1(String dol1) {
		this.dol1 = dol1;
	}
	
	/**
	 * Column Info
	 * @param dol2
	 */
	public void setDol2(String dol2) {
		this.dol2 = dol2;
	}
	
	/**
	 * Column Info
	 * @param dol3
	 */
	public void setDol3(String dol3) {
		this.dol3 = dol3;
	}
	
	/**
	 * Column Info
	 * @param dol4
	 */
	public void setDol4(String dol4) {
		this.dol4 = dol4;
	}
	
	/**
	 * Column Info
	 * @param dol5
	 */
	public void setDol5(String dol5) {
		this.dol5 = dol5;
	}
	
	/**
	 * Column Info
	 * @param dol6
	 */
	public void setDol6(String dol6) {
		this.dol6 = dol6;
	}
	
	/**
	 * Column Info
	 * @param dol7
	 */
	public void setDol7(String dol7) {
		this.dol7 = dol7;
	}
	
	/**
	 * Column Info
	 * @param dol8
	 */
	public void setDol8(String dol8) {
		this.dol8 = dol8;
	}
	
	/**
	 * Column Info
	 * @param dol9
	 */
	public void setDol9(String dol9) {
		this.dol9 = dol9;
	}
	
	/**
	 * Column Info
	 * @param dol10
	 */
	public void setDol10(String dol10) {
		this.dol10 = dol10;
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
	 * @param mtRtnYd
	 */
	public void setMtRtnYd(String mtRtnYd) {
		this.mtRtnYd = mtRtnYd;
	}

	/**
	 * Column Info
	 * @param delScc
	 */
	public void setDelScc(String delScc) {
		this.delScc = delScc;
	}

	/**
	 * Column Info
	 * @param mtRtnScc
	 */
	public void setMtRtnScc(String mtRtnScc) {
		this.mtRtnScc = mtRtnScc;
	}

	/**
	 * Column Info
	 * @param delDol
	 */
	public void setDelDol(String delDol) {
		this.delDol = delDol;
	}

	/**
	 * Column Info
	 * @param mtRtnDol
	 */
	public void setMtRtnDol(String mtRtnDol) {
		this.mtRtnDol = mtRtnDol;
	}

	/**
	 * Column Info
	 * @param currYdDol
	 */
	public void setCurrYdDol(String currYdDol) {
		this.currYdDol = currYdDol;
	}

	/**
	 * Column Info
	 * @param soNo
	 */
	public void setSoNo(String soNo) {
		this.soNo = soNo;
	}

	/**
	 * Column Info
	 * @param woNo
	 */
	public void setWoNo(String woNo) {
		this.woNo = woNo;
	}

	/**
	 * Column Info
	 * @param vndrTp
	 */
	public void setVndrTp(String vndrTp) {
		this.vndrTp = vndrTp;
	}

	/**
	 * Column Info
	 * @param vndrCd
	 */
	public void setVndrCd(String vndrCd) {
		this.vndrCd = vndrCd;
	}

	/**
	 * Column Info
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
	}

	/**
	 * Column Info
	 * @param deTerm
	 */
	public void setDeTerm(String deTerm) {
		this.deTerm = deTerm;
	}

	/**
	 * Column Info
	 * @param dolTp
	 */
	public void setDolTp(String dolTp) {
		this.dolTp = dolTp;
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
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setStrEstmDt(JSPUtil.getParameter(request, prefix + "str_estm_dt", ""));
		setSccList(JSPUtil.getParameter(request, prefix + "scc_list", ""));
		setEndEstmDt(JSPUtil.getParameter(request, prefix + "end_estm_dt", ""));
		setCrntYdCd(JSPUtil.getParameter(request, prefix + "crnt_yd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolEtd(JSPUtil.getParameter(request, prefix + "pol_etd", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, prefix + "cnmv_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, prefix + "agmt_cty_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setLstmCd(JSPUtil.getParameter(request, prefix + "lstm_cd", ""));
		setMvmtSts(JSPUtil.getParameter(request, prefix + "mvmt_sts", ""));
		setLocTp(JSPUtil.getParameter(request, prefix + "loc_tp", ""));
		setAgmtSeq(JSPUtil.getParameter(request, prefix + "agmt_seq", ""));
		setCnmvDt(JSPUtil.getParameter(request, prefix + "cnmv_dt", ""));
		setAgmtNo(JSPUtil.getParameter(request, prefix + "agmt_no", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setTargetScc(JSPUtil.getParameter(request, prefix + "target_scc", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setRefNo(JSPUtil.getParameter(request, prefix + "ref_no", ""));
		setFullFlg(JSPUtil.getParameter(request, prefix + "full_flg", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, prefix + "vndr_abbr_nm", ""));
		setPodEta(JSPUtil.getParameter(request, prefix + "pod_eta", ""));
		setRadTp(JSPUtil.getParameter(request, prefix + "rad_tp", ""));
		setDol0(JSPUtil.getParameter(request, prefix + "dol0", ""));
		setDol1(JSPUtil.getParameter(request, prefix + "dol1", ""));
		setDol2(JSPUtil.getParameter(request, prefix + "dol2", ""));
		setDol3(JSPUtil.getParameter(request, prefix + "dol3", ""));
		setDol4(JSPUtil.getParameter(request, prefix + "dol4", ""));
		setDol5(JSPUtil.getParameter(request, prefix + "dol5", ""));
		setDol6(JSPUtil.getParameter(request, prefix + "dol6", ""));
		setDol7(JSPUtil.getParameter(request, prefix + "dol7", ""));
		setDol8(JSPUtil.getParameter(request, prefix + "dol8", ""));
		setDol9(JSPUtil.getParameter(request, prefix + "dol9", ""));
		setDol10(JSPUtil.getParameter(request, prefix + "dol10", ""));
		setLccCd(JSPUtil.getParameter(request, prefix + "lcc_cd", ""));
		setMtRtnYd(JSPUtil.getParameter(request, prefix + "mt_rtn_yd", ""));
		setDelScc(JSPUtil.getParameter(request, prefix + "del_scc", ""));
		setMtRtnScc(JSPUtil.getParameter(request, prefix + "mt_rtn_scc", ""));
		setDelDol(JSPUtil.getParameter(request, prefix + "del_dol", ""));
		setMtRtnDol(JSPUtil.getParameter(request, prefix + "mt_rtn_dol", ""));
		setCurrYdDol(JSPUtil.getParameter(request, prefix + "curr_yd_dol", ""));
		setSoNo(JSPUtil.getParameter(request, prefix + "so_no", ""));
		setWoNo(JSPUtil.getParameter(request, prefix + "wo_no", ""));
		setVndrTp(JSPUtil.getParameter(request, prefix + "vndr_tp", ""));
		setVndrCd(JSPUtil.getParameter(request, prefix + "vndr_cd", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setDeTerm(JSPUtil.getParameter(request, prefix + "de_term", ""));
		setDolTp(JSPUtil.getParameter(request, prefix + "dol_tp", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AvailableOffHireContainerListVO[]
	 */
	public AvailableOffHireContainerListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AvailableOffHireContainerListVO[]
	 */
	public AvailableOffHireContainerListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AvailableOffHireContainerListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] strEstmDt = (JSPUtil.getParameter(request, prefix	+ "str_estm_dt", length));
			String[] sccList = (JSPUtil.getParameter(request, prefix	+ "scc_list", length));
			String[] endEstmDt = (JSPUtil.getParameter(request, prefix	+ "end_estm_dt", length));
			String[] crntYdCd = (JSPUtil.getParameter(request, prefix	+ "crnt_yd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polEtd = (JSPUtil.getParameter(request, prefix	+ "pol_etd", length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] mvmtSts = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts", length));
			String[] locTp = (JSPUtil.getParameter(request, prefix	+ "loc_tp", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] cnmvDt = (JSPUtil.getParameter(request, prefix	+ "cnmv_dt", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] targetScc = (JSPUtil.getParameter(request, prefix	+ "target_scc", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] refNo = (JSPUtil.getParameter(request, prefix	+ "ref_no", length));
			String[] fullFlg = (JSPUtil.getParameter(request, prefix	+ "full_flg", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm", length));
			String[] podEta = (JSPUtil.getParameter(request, prefix	+ "pod_eta", length));
			String[] radTp = (JSPUtil.getParameter(request, prefix	+ "rad_tp", length));
			String[] dol0 = (JSPUtil.getParameter(request, prefix	+ "dol0", length));
			String[] dol1 = (JSPUtil.getParameter(request, prefix	+ "dol1", length));
			String[] dol2 = (JSPUtil.getParameter(request, prefix	+ "dol2", length));
			String[] dol3 = (JSPUtil.getParameter(request, prefix	+ "dol3", length));
			String[] dol4 = (JSPUtil.getParameter(request, prefix	+ "dol4", length));
			String[] dol5 = (JSPUtil.getParameter(request, prefix	+ "dol5", length));
			String[] dol6 = (JSPUtil.getParameter(request, prefix	+ "dol6", length));
			String[] dol7 = (JSPUtil.getParameter(request, prefix	+ "dol7", length));
			String[] dol8 = (JSPUtil.getParameter(request, prefix	+ "dol8", length));
			String[] dol9 = (JSPUtil.getParameter(request, prefix	+ "dol9", length));
			String[] dol10 = (JSPUtil.getParameter(request, prefix	+ "dol10", length));
			String[] lccCd = (JSPUtil.getParameter(request, prefix	+ "lcc_cd", length));
			String[] mtRtnYd = (JSPUtil.getParameter(request, prefix	+ "mt_rtn_yd", length));
			String[] delScc = (JSPUtil.getParameter(request, prefix	+ "del_scc", length));
			String[] mtRtnScc = (JSPUtil.getParameter(request, prefix	+ "mt_rtn_scc", length));
			String[] delDol = (JSPUtil.getParameter(request, prefix	+ "del_dol", length));
			String[] mtRtnDol = (JSPUtil.getParameter(request, prefix	+ "mt_rtn_dol", length));
			String[] currYdDol = (JSPUtil.getParameter(request, prefix	+ "curr_yd_dol", length));
			String[] soNo = (JSPUtil.getParameter(request, prefix	+ "so_no", length));
			String[] woNo = (JSPUtil.getParameter(request, prefix	+ "wo_no", length));
			String[] vndrTp = (JSPUtil.getParameter(request, prefix	+ "vndr_tp", length));
			String[] vndrCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cd", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] deTerm = (JSPUtil.getParameter(request, prefix	+ "de_term", length));
			String[] dolTp = (JSPUtil.getParameter(request, prefix	+ "dol_tp", length));
			
			for (int i = 0; i < length; i++) {
				model = new AvailableOffHireContainerListVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (strEstmDt[i] != null)
					model.setStrEstmDt(strEstmDt[i]);
				if (sccList[i] != null)
					model.setSccList(sccList[i]);
				if (endEstmDt[i] != null)
					model.setEndEstmDt(endEstmDt[i]);
				if (crntYdCd[i] != null)
					model.setCrntYdCd(crntYdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polEtd[i] != null)
					model.setPolEtd(polEtd[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (mvmtSts[i] != null)
					model.setMvmtSts(mvmtSts[i]);
				if (locTp[i] != null)
					model.setLocTp(locTp[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (cnmvDt[i] != null)
					model.setCnmvDt(cnmvDt[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (targetScc[i] != null)
					model.setTargetScc(targetScc[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				if (fullFlg[i] != null)
					model.setFullFlg(fullFlg[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (podEta[i] != null)
					model.setPodEta(podEta[i]);
				if (radTp[i] != null)
					model.setRadTp(radTp[i]);
				if (dol0[i] != null)
					model.setDol0(dol0[i]);
				if (dol1[i] != null)
					model.setDol1(dol1[i]);
				if (dol2[i] != null)
					model.setDol2(dol2[i]);
				if (dol3[i] != null)
					model.setDol3(dol3[i]);
				if (dol4[i] != null)
					model.setDol4(dol4[i]);
				if (dol5[i] != null)
					model.setDol5(dol5[i]);
				if (dol6[i] != null)
					model.setDol6(dol6[i]);
				if (dol7[i] != null)
					model.setDol7(dol7[i]);
				if (dol8[i] != null)
					model.setDol8(dol8[i]);
				if (dol9[i] != null)
					model.setDol9(dol9[i]);
				if (dol10[i] != null)
					model.setDol10(dol10[i]);
				if (lccCd[i] != null)
					model.setLccCd(lccCd[i]);
				if (mtRtnYd[i] != null)
					model.setMtRtnYd(mtRtnYd[i]);
				if (delScc[i] != null)
					model.setDelScc(delScc[i]);
				if (mtRtnScc[i] != null)
					model.setMtRtnScc(mtRtnScc[i]);
				if (delDol[i] != null)
					model.setDelDol(delDol[i]);
				if (mtRtnDol[i] != null)
					model.setMtRtnDol(mtRtnDol[i]);
				if (currYdDol[i] != null)
					model.setCurrYdDol(currYdDol[i]);
				if (soNo[i] != null)
					model.setSoNo(soNo[i]);
				if (woNo[i] != null)
					model.setWoNo(woNo[i]);
				if (vndrTp[i] != null)
					model.setVndrTp(vndrTp[i]);
				if (vndrCd[i] != null)
					model.setVndrCd(vndrCd[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (deTerm[i] != null)
					model.setDeTerm(deTerm[i]);
				if (dolTp[i] != null)
					model.setDolTp(dolTp[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAvailableOffHireContainerListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AvailableOffHireContainerListVO[]
	 */
	public AvailableOffHireContainerListVO[] getAvailableOffHireContainerListVOs(){
		AvailableOffHireContainerListVO[] vos = (AvailableOffHireContainerListVO[])models.toArray(new AvailableOffHireContainerListVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.strEstmDt = this.strEstmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccList = this.sccList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endEstmDt = this.endEstmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd = this.crntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEtd = this.polEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtSts = this.mvmtSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTp = this.locTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvDt = this.cnmvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.targetScc = this.targetScc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo = this.refNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullFlg = this.fullFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podEta = this.podEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.radTp = this.radTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dol0 = this.dol0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dol1 = this.dol1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dol2 = this.dol2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dol3 = this.dol3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dol4 = this.dol4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dol5 = this.dol5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dol6 = this.dol6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dol7 = this.dol7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dol8 = this.dol8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dol9 = this.dol9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dol10 = this.dol10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lccCd = this.lccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtRtnYd = this.mtRtnYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delScc = this.delScc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtRtnScc = this.mtRtnScc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delDol = this.delDol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtRtnDol = this.mtRtnDol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currYdDol = this.currYdDol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soNo = this.soNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrTp = this.vndrTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCd = this.vndrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTerm = this.deTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dolTp = this.dolTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
