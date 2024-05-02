/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DropOffChargeInquiryVO.java
*@FileTitle : DropOffChargeInquiryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.02  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.expnaud.trsaud.vo;

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

public class DropOffChargeInquiryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DropOffChargeInquiryVO> models = new ArrayList<DropOffChargeInquiryVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String sCntrTpsz = null;
	/* Column Info */
	private String bkgScgCd = null;
	/* Column Info */
	private String sBkgNo = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String delYdCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String tpbNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String sToDt = null;
	/* Column Info */
	private String sEacIf = null;
	/* Column Info */
	private String sLoc = null;
	/* Column Info */
	private String eacIfFlg = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String sCustCd = null;
	/* Column Info */
	private String tpbAmt = null;
	/* Column Info */
	private String bkgScgTermNm = null;
	/* Column Info */
	private String sFmDt = null;
	/* Column Info */
	private String bkgScgAmt = null;
	/* Column Info */
	private String bkgScgCurCd = null;
	/* Column Info */
	private String sCustNm = null;
	/* Column Info */
	private String eccCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String sCntrNo = null;
	/* Column Info */
	private String bkgScgRatUtCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String sDeTermCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String chk = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String sEcc = null;
	/* Column Info */
	private String cneCd = null;
	/* Column Info */
	private String shpCd = null;
	/* Column Info */
	private String actRtnYdCd = null;
	/* Column Info */
	private String sCustTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public DropOffChargeInquiryVO() {}

	public DropOffChargeInquiryVO(String ibflag, String pagerows, String sEcc, String sLoc, String sBkgNo, String sCntrTpsz, String sCntrNo, String sFmDt, String sToDt, String sDeTermCd, String sEacIf, String sCustTpCd, String sCustCd, String sCustNm, String chk, String eccCd, String bkgStsCd, String cntrNo, String cntrTpszCd, String bkgNo, String porCd, String polCd, String podCd, String delCd, String deTermCd, String shpCd, String cneCd, String delYdCd, String actRtnYdCd, String scNo, String rfaNo, String bkgScgCd, String bkgScgCurCd, String bkgScgRatUtCd, String bkgScgAmt, String bkgScgTermNm, String tpbNo, String tpbAmt, String eacIfFlg) {
		this.porCd = porCd;
		this.sCntrTpsz = sCntrTpsz;
		this.bkgScgCd = bkgScgCd;
		this.sBkgNo = sBkgNo;
		this.bkgStsCd = bkgStsCd;
		this.delYdCd = delYdCd;
		this.pagerows = pagerows;
		this.rfaNo = rfaNo;
		this.tpbNo = tpbNo;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.sToDt = sToDt;
		this.sEacIf = sEacIf;
		this.sLoc = sLoc;
		this.eacIfFlg = eacIfFlg;
		this.scNo = scNo;
		this.cntrTpszCd = cntrTpszCd;
		this.sCustCd = sCustCd;
		this.tpbAmt = tpbAmt;
		this.bkgScgTermNm = bkgScgTermNm;
		this.sFmDt = sFmDt;
		this.bkgScgAmt = bkgScgAmt;
		this.bkgScgCurCd = bkgScgCurCd;
		this.sCustNm = sCustNm;
		this.eccCd = eccCd;
		this.delCd = delCd;
		this.sCntrNo = sCntrNo;
		this.bkgScgRatUtCd = bkgScgRatUtCd;
		this.podCd = podCd;
		this.deTermCd = deTermCd;
		this.sDeTermCd = sDeTermCd;
		this.bkgNo = bkgNo;
		this.chk = chk;
		this.cntrNo = cntrNo;
		this.sEcc = sEcc;
		this.cneCd = cneCd;
		this.shpCd = shpCd;
		this.actRtnYdCd = actRtnYdCd;
		this.sCustTpCd = sCustTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("s_cntr_tpsz", getSCntrTpsz());
		this.hashColumns.put("bkg_scg_cd", getBkgScgCd());
		this.hashColumns.put("s_bkg_no", getSBkgNo());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("del_yd_cd", getDelYdCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("tpb_no", getTpbNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("s_to_dt", getSToDt());
		this.hashColumns.put("s_eac_if", getSEacIf());
		this.hashColumns.put("s_loc", getSLoc());
		this.hashColumns.put("eac_if_flg", getEacIfFlg());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("s_cust_cd", getSCustCd());
		this.hashColumns.put("tpb_amt", getTpbAmt());
		this.hashColumns.put("bkg_scg_term_nm", getBkgScgTermNm());
		this.hashColumns.put("s_fm_dt", getSFmDt());
		this.hashColumns.put("bkg_scg_amt", getBkgScgAmt());
		this.hashColumns.put("bkg_scg_cur_cd", getBkgScgCurCd());
		this.hashColumns.put("s_cust_nm", getSCustNm());
		this.hashColumns.put("ecc_cd", getEccCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("s_cntr_no", getSCntrNo());
		this.hashColumns.put("bkg_scg_rat_ut_cd", getBkgScgRatUtCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("s_de_term_cd", getSDeTermCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("chk", getChk());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("s_ecc", getSEcc());
		this.hashColumns.put("cne_cd", getCneCd());
		this.hashColumns.put("shp_cd", getShpCd());
		this.hashColumns.put("act_rtn_yd_cd", getActRtnYdCd());
		this.hashColumns.put("s_cust_tp_cd", getSCustTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("s_cntr_tpsz", "sCntrTpsz");
		this.hashFields.put("bkg_scg_cd", "bkgScgCd");
		this.hashFields.put("s_bkg_no", "sBkgNo");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("del_yd_cd", "delYdCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("tpb_no", "tpbNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("s_to_dt", "sToDt");
		this.hashFields.put("s_eac_if", "sEacIf");
		this.hashFields.put("s_loc", "sLoc");
		this.hashFields.put("eac_if_flg", "eacIfFlg");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("s_cust_cd", "sCustCd");
		this.hashFields.put("tpb_amt", "tpbAmt");
		this.hashFields.put("bkg_scg_term_nm", "bkgScgTermNm");
		this.hashFields.put("s_fm_dt", "sFmDt");
		this.hashFields.put("bkg_scg_amt", "bkgScgAmt");
		this.hashFields.put("bkg_scg_cur_cd", "bkgScgCurCd");
		this.hashFields.put("s_cust_nm", "sCustNm");
		this.hashFields.put("ecc_cd", "eccCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("s_cntr_no", "sCntrNo");
		this.hashFields.put("bkg_scg_rat_ut_cd", "bkgScgRatUtCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("s_de_term_cd", "sDeTermCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("chk", "chk");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("s_ecc", "sEcc");
		this.hashFields.put("cne_cd", "cneCd");
		this.hashFields.put("shp_cd", "shpCd");
		this.hashFields.put("act_rtn_yd_cd", "actRtnYdCd");
		this.hashFields.put("s_cust_tp_cd", "sCustTpCd");
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
	 * @return sCntrTpsz
	 */
	public String getSCntrTpsz() {
		return this.sCntrTpsz;
	}
	
	/**
	 * Column Info
	 * @return bkgScgCd
	 */
	public String getBkgScgCd() {
		return this.bkgScgCd;
	}
	
	/**
	 * Column Info
	 * @return sBkgNo
	 */
	public String getSBkgNo() {
		return this.sBkgNo;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return delYdCd
	 */
	public String getDelYdCd() {
		return this.delYdCd;
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
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
	}
	
	/**
	 * Column Info
	 * @return tpbNo
	 */
	public String getTpbNo() {
		return this.tpbNo;
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
	 * @return sToDt
	 */
	public String getSToDt() {
		return this.sToDt;
	}
	
	/**
	 * Column Info
	 * @return sEacIf
	 */
	public String getSEacIf() {
		return this.sEacIf;
	}
	
	/**
	 * Column Info
	 * @return sLoc
	 */
	public String getSLoc() {
		return this.sLoc;
	}
	
	/**
	 * Column Info
	 * @return eacIfFlg
	 */
	public String getEacIfFlg() {
		return this.eacIfFlg;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return sCustCd
	 */
	public String getSCustCd() {
		return this.sCustCd;
	}
	
	/**
	 * Column Info
	 * @return tpbAmt
	 */
	public String getTpbAmt() {
		return this.tpbAmt;
	}
	
	/**
	 * Column Info
	 * @return bkgScgTermNm
	 */
	public String getBkgScgTermNm() {
		return this.bkgScgTermNm;
	}
	
	/**
	 * Column Info
	 * @return sFmDt
	 */
	public String getSFmDt() {
		return this.sFmDt;
	}
	
	/**
	 * Column Info
	 * @return bkgScgAmt
	 */
	public String getBkgScgAmt() {
		return this.bkgScgAmt;
	}
	
	/**
	 * Column Info
	 * @return bkgScgCurCd
	 */
	public String getBkgScgCurCd() {
		return this.bkgScgCurCd;
	}
	
	/**
	 * Column Info
	 * @return sCustNm
	 */
	public String getSCustNm() {
		return this.sCustNm;
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
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return sCntrNo
	 */
	public String getSCntrNo() {
		return this.sCntrNo;
	}
	
	/**
	 * Column Info
	 * @return bkgScgRatUtCd
	 */
	public String getBkgScgRatUtCd() {
		return this.bkgScgRatUtCd;
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
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
	}
	
	/**
	 * Column Info
	 * @return sDeTermCd
	 */
	public String getSDeTermCd() {
		return this.sDeTermCd;
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
	 * @return chk
	 */
	public String getChk() {
		return this.chk;
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
	 * @return sEcc
	 */
	public String getSEcc() {
		return this.sEcc;
	}
	
	/**
	 * Column Info
	 * @return cneCd
	 */
	public String getCneCd() {
		return this.cneCd;
	}
	
	/**
	 * Column Info
	 * @return shpCd
	 */
	public String getShpCd() {
		return this.shpCd;
	}
	
	/**
	 * Column Info
	 * @return actRtnYdCd
	 */
	public String getActRtnYdCd() {
		return this.actRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @return sCustTpCd
	 */
	public String getSCustTpCd() {
		return this.sCustTpCd;
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
	 * @param sCntrTpsz
	 */
	public void setSCntrTpsz(String sCntrTpsz) {
		this.sCntrTpsz = sCntrTpsz;
	}
	
	/**
	 * Column Info
	 * @param bkgScgCd
	 */
	public void setBkgScgCd(String bkgScgCd) {
		this.bkgScgCd = bkgScgCd;
	}
	
	/**
	 * Column Info
	 * @param sBkgNo
	 */
	public void setSBkgNo(String sBkgNo) {
		this.sBkgNo = sBkgNo;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param delYdCd
	 */
	public void setDelYdCd(String delYdCd) {
		this.delYdCd = delYdCd;
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
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}
	
	/**
	 * Column Info
	 * @param tpbNo
	 */
	public void setTpbNo(String tpbNo) {
		this.tpbNo = tpbNo;
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
	 * @param sToDt
	 */
	public void setSToDt(String sToDt) {
		this.sToDt = sToDt;
	}
	
	/**
	 * Column Info
	 * @param sEacIf
	 */
	public void setSEacIf(String sEacIf) {
		this.sEacIf = sEacIf;
	}
	
	/**
	 * Column Info
	 * @param sLoc
	 */
	public void setSLoc(String sLoc) {
		this.sLoc = sLoc;
	}
	
	/**
	 * Column Info
	 * @param eacIfFlg
	 */
	public void setEacIfFlg(String eacIfFlg) {
		this.eacIfFlg = eacIfFlg;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param sCustCd
	 */
	public void setSCustCd(String sCustCd) {
		this.sCustCd = sCustCd;
	}
	
	/**
	 * Column Info
	 * @param tpbAmt
	 */
	public void setTpbAmt(String tpbAmt) {
		this.tpbAmt = tpbAmt;
	}
	
	/**
	 * Column Info
	 * @param bkgScgTermNm
	 */
	public void setBkgScgTermNm(String bkgScgTermNm) {
		this.bkgScgTermNm = bkgScgTermNm;
	}
	
	/**
	 * Column Info
	 * @param sFmDt
	 */
	public void setSFmDt(String sFmDt) {
		this.sFmDt = sFmDt;
	}
	
	/**
	 * Column Info
	 * @param bkgScgAmt
	 */
	public void setBkgScgAmt(String bkgScgAmt) {
		this.bkgScgAmt = bkgScgAmt;
	}
	
	/**
	 * Column Info
	 * @param bkgScgCurCd
	 */
	public void setBkgScgCurCd(String bkgScgCurCd) {
		this.bkgScgCurCd = bkgScgCurCd;
	}
	
	/**
	 * Column Info
	 * @param sCustNm
	 */
	public void setSCustNm(String sCustNm) {
		this.sCustNm = sCustNm;
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
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param sCntrNo
	 */
	public void setSCntrNo(String sCntrNo) {
		this.sCntrNo = sCntrNo;
	}
	
	/**
	 * Column Info
	 * @param bkgScgRatUtCd
	 */
	public void setBkgScgRatUtCd(String bkgScgRatUtCd) {
		this.bkgScgRatUtCd = bkgScgRatUtCd;
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
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
	}
	
	/**
	 * Column Info
	 * @param sDeTermCd
	 */
	public void setSDeTermCd(String sDeTermCd) {
		this.sDeTermCd = sDeTermCd;
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
	 * @param chk
	 */
	public void setChk(String chk) {
		this.chk = chk;
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
	 * @param sEcc
	 */
	public void setSEcc(String sEcc) {
		this.sEcc = sEcc;
	}
	
	/**
	 * Column Info
	 * @param cneCd
	 */
	public void setCneCd(String cneCd) {
		this.cneCd = cneCd;
	}
	
	/**
	 * Column Info
	 * @param shpCd
	 */
	public void setShpCd(String shpCd) {
		this.shpCd = shpCd;
	}
	
	/**
	 * Column Info
	 * @param actRtnYdCd
	 */
	public void setActRtnYdCd(String actRtnYdCd) {
		this.actRtnYdCd = actRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @param sCustTpCd
	 */
	public void setSCustTpCd(String sCustTpCd) {
		this.sCustTpCd = sCustTpCd;
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
		setSCntrTpsz(JSPUtil.getParameter(request, prefix + "s_cntr_tpsz", ""));
		setBkgScgCd(JSPUtil.getParameter(request, prefix + "bkg_scg_cd", ""));
		setSBkgNo(JSPUtil.getParameter(request, prefix + "s_bkg_no", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setDelYdCd(JSPUtil.getParameter(request, prefix + "del_yd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setTpbNo(JSPUtil.getParameter(request, prefix + "tpb_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setSToDt(JSPUtil.getParameter(request, prefix + "s_to_dt", ""));
		setSEacIf(JSPUtil.getParameter(request, prefix + "s_eac_if", ""));
		setSLoc(JSPUtil.getParameter(request, prefix + "s_loc", ""));
		setEacIfFlg(JSPUtil.getParameter(request, prefix + "eac_if_flg", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setSCustCd(JSPUtil.getParameter(request, prefix + "s_cust_cd", ""));
		setTpbAmt(JSPUtil.getParameter(request, prefix + "tpb_amt", ""));
		setBkgScgTermNm(JSPUtil.getParameter(request, prefix + "bkg_scg_term_nm", ""));
		setSFmDt(JSPUtil.getParameter(request, prefix + "s_fm_dt", ""));
		setBkgScgAmt(JSPUtil.getParameter(request, prefix + "bkg_scg_amt", ""));
		setBkgScgCurCd(JSPUtil.getParameter(request, prefix + "bkg_scg_cur_cd", ""));
		setSCustNm(JSPUtil.getParameter(request, prefix + "s_cust_nm", ""));
		setEccCd(JSPUtil.getParameter(request, prefix + "ecc_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setSCntrNo(JSPUtil.getParameter(request, prefix + "s_cntr_no", ""));
		setBkgScgRatUtCd(JSPUtil.getParameter(request, prefix + "bkg_scg_rat_ut_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setSDeTermCd(JSPUtil.getParameter(request, prefix + "s_de_term_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setChk(JSPUtil.getParameter(request, prefix + "chk", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setSEcc(JSPUtil.getParameter(request, prefix + "s_ecc", ""));
		setCneCd(JSPUtil.getParameter(request, prefix + "cne_cd", ""));
		setShpCd(JSPUtil.getParameter(request, prefix + "shp_cd", ""));
		setActRtnYdCd(JSPUtil.getParameter(request, prefix + "act_rtn_yd_cd", ""));
		setSCustTpCd(JSPUtil.getParameter(request, prefix + "s_cust_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DropOffChargeInquiryVO[]
	 */
	public DropOffChargeInquiryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DropOffChargeInquiryVO[]
	 */
	public DropOffChargeInquiryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DropOffChargeInquiryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] sCntrTpsz = (JSPUtil.getParameter(request, prefix	+ "s_cntr_tpsz", length));
			String[] bkgScgCd = (JSPUtil.getParameter(request, prefix	+ "bkg_scg_cd", length));
			String[] sBkgNo = (JSPUtil.getParameter(request, prefix	+ "s_bkg_no", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] delYdCd = (JSPUtil.getParameter(request, prefix	+ "del_yd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] tpbNo = (JSPUtil.getParameter(request, prefix	+ "tpb_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] sToDt = (JSPUtil.getParameter(request, prefix	+ "s_to_dt", length));
			String[] sEacIf = (JSPUtil.getParameter(request, prefix	+ "s_eac_if", length));
			String[] sLoc = (JSPUtil.getParameter(request, prefix	+ "s_loc", length));
			String[] eacIfFlg = (JSPUtil.getParameter(request, prefix	+ "eac_if_flg", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] sCustCd = (JSPUtil.getParameter(request, prefix	+ "s_cust_cd", length));
			String[] tpbAmt = (JSPUtil.getParameter(request, prefix	+ "tpb_amt", length));
			String[] bkgScgTermNm = (JSPUtil.getParameter(request, prefix	+ "bkg_scg_term_nm", length));
			String[] sFmDt = (JSPUtil.getParameter(request, prefix	+ "s_fm_dt", length));
			String[] bkgScgAmt = (JSPUtil.getParameter(request, prefix	+ "bkg_scg_amt", length));
			String[] bkgScgCurCd = (JSPUtil.getParameter(request, prefix	+ "bkg_scg_cur_cd", length));
			String[] sCustNm = (JSPUtil.getParameter(request, prefix	+ "s_cust_nm", length));
			String[] eccCd = (JSPUtil.getParameter(request, prefix	+ "ecc_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] sCntrNo = (JSPUtil.getParameter(request, prefix	+ "s_cntr_no", length));
			String[] bkgScgRatUtCd = (JSPUtil.getParameter(request, prefix	+ "bkg_scg_rat_ut_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] sDeTermCd = (JSPUtil.getParameter(request, prefix	+ "s_de_term_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] chk = (JSPUtil.getParameter(request, prefix	+ "chk", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] sEcc = (JSPUtil.getParameter(request, prefix	+ "s_ecc", length));
			String[] cneCd = (JSPUtil.getParameter(request, prefix	+ "cne_cd", length));
			String[] shpCd = (JSPUtil.getParameter(request, prefix	+ "shp_cd", length));
			String[] actRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "act_rtn_yd_cd", length));
			String[] sCustTpCd = (JSPUtil.getParameter(request, prefix	+ "s_cust_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new DropOffChargeInquiryVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (sCntrTpsz[i] != null)
					model.setSCntrTpsz(sCntrTpsz[i]);
				if (bkgScgCd[i] != null)
					model.setBkgScgCd(bkgScgCd[i]);
				if (sBkgNo[i] != null)
					model.setSBkgNo(sBkgNo[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (delYdCd[i] != null)
					model.setDelYdCd(delYdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (tpbNo[i] != null)
					model.setTpbNo(tpbNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (sToDt[i] != null)
					model.setSToDt(sToDt[i]);
				if (sEacIf[i] != null)
					model.setSEacIf(sEacIf[i]);
				if (sLoc[i] != null)
					model.setSLoc(sLoc[i]);
				if (eacIfFlg[i] != null)
					model.setEacIfFlg(eacIfFlg[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (sCustCd[i] != null)
					model.setSCustCd(sCustCd[i]);
				if (tpbAmt[i] != null)
					model.setTpbAmt(tpbAmt[i]);
				if (bkgScgTermNm[i] != null)
					model.setBkgScgTermNm(bkgScgTermNm[i]);
				if (sFmDt[i] != null)
					model.setSFmDt(sFmDt[i]);
				if (bkgScgAmt[i] != null)
					model.setBkgScgAmt(bkgScgAmt[i]);
				if (bkgScgCurCd[i] != null)
					model.setBkgScgCurCd(bkgScgCurCd[i]);
				if (sCustNm[i] != null)
					model.setSCustNm(sCustNm[i]);
				if (eccCd[i] != null)
					model.setEccCd(eccCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (sCntrNo[i] != null)
					model.setSCntrNo(sCntrNo[i]);
				if (bkgScgRatUtCd[i] != null)
					model.setBkgScgRatUtCd(bkgScgRatUtCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (sDeTermCd[i] != null)
					model.setSDeTermCd(sDeTermCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (chk[i] != null)
					model.setChk(chk[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (sEcc[i] != null)
					model.setSEcc(sEcc[i]);
				if (cneCd[i] != null)
					model.setCneCd(cneCd[i]);
				if (shpCd[i] != null)
					model.setShpCd(shpCd[i]);
				if (actRtnYdCd[i] != null)
					model.setActRtnYdCd(actRtnYdCd[i]);
				if (sCustTpCd[i] != null)
					model.setSCustTpCd(sCustTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDropOffChargeInquiryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DropOffChargeInquiryVO[]
	 */
	public DropOffChargeInquiryVO[] getDropOffChargeInquiryVOs(){
		DropOffChargeInquiryVO[] vos = (DropOffChargeInquiryVO[])models.toArray(new DropOffChargeInquiryVO[models.size()]);
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
		this.sCntrTpsz = this.sCntrTpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgScgCd = this.bkgScgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBkgNo = this.sBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delYdCd = this.delYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpbNo = this.tpbNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sToDt = this.sToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEacIf = this.sEacIf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sLoc = this.sLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacIfFlg = this.eacIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustCd = this.sCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpbAmt = this.tpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgScgTermNm = this.bkgScgTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFmDt = this.sFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgScgAmt = this.bkgScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgScgCurCd = this.bkgScgCurCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustNm = this.sCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eccCd = this.eccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCntrNo = this.sCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgScgRatUtCd = this.bkgScgRatUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDeTermCd = this.sDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk = this.chk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEcc = this.sEcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneCd = this.cneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpCd = this.shpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actRtnYdCd = this.actRtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustTpCd = this.sCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
