/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LoadingConfirmationinVO.java
*@FileTitle : LoadingConfirmationinVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.05
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2010.04.05 김기종 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo;

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
 * @author 김기종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class LoadingConfirmationinVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<LoadingConfirmationinVO> models = new ArrayList<LoadingConfirmationinVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String ofcEngNm = null;
	/* Column Info */
	private String mphnNo = null;
	/* Column Info */
	private String sndDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cntcPsonFaxNo = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String rnum = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String ofcPhnNo = null;
	/* Column Info */
	private String ofcAddr = null;
	/* Column Info */
	private String bkgCustTpCd = null;
	/* Column Info */
	private String podLocCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String rdParam = null;
	/* Column Info */
	private String cntcPsonEml = null;
	/* Column Info */
	private String rcheck = null;
	/* Column Info */
	private String subgroupTitle = null;
	/* Column Info */
	private String bkgCntcPsonTpCd = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String arCurrCd = null;
	/* Column Info */
	private String delLocCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String faxIp = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgRefNo = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String bkgCPerson = null;
	/* Column Info */
	private String polLocCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String skdVoyDir = null;
	/* Column Info */
	private String custFullNm = null;
	/* Column Info */
	private String language = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public LoadingConfirmationinVO() {}

	public LoadingConfirmationinVO(String ibflag, String pagerows, String rnum, String custNm, String bkgCPerson, String skdVoyDir, String vpsEtdDt, String bkgRefNo, String bkgNo, String porCd, String polCd, String podCd, String delCd, String cntrNo, String polLocCd, String podLocCd, String delLocCd, String cnmvStsCd, String custFullNm, String bkgOfcCd, String vslCd, String skdVoyNo, String skdDirCd, String scNo, String cntcPsonFaxNo, String cntcPsonEml, String bkgCustTpCd, String vvdCd, String sndDt, String bkgCntcPsonTpCd, String language, String custCntCd, String custSeq, String ofcEngNm, String ofcAddr, String ofcPhnNo, String faxIp, String arCurrCd, String rdParam, String mphnNo, String faxNo, String subgroupTitle, String rcheck) {
		this.porCd = porCd;
		this.vslCd = vslCd;
		this.custNm = custNm;
		this.ofcEngNm = ofcEngNm;
		this.mphnNo = mphnNo;
		this.sndDt = sndDt;
		this.pagerows = pagerows;
		this.cntcPsonFaxNo = cntcPsonFaxNo;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.cnmvStsCd = cnmvStsCd;
		this.vvdCd = vvdCd;
		this.rnum = rnum;
		this.scNo = scNo;
		this.ofcPhnNo = ofcPhnNo;
		this.ofcAddr = ofcAddr;
		this.bkgCustTpCd = bkgCustTpCd;
		this.podLocCd = podLocCd;
		this.custCntCd = custCntCd;
		this.bkgOfcCd = bkgOfcCd;
		this.rdParam = rdParam;
		this.cntcPsonEml = cntcPsonEml;
		this.rcheck = rcheck;
		this.subgroupTitle = subgroupTitle;
		this.bkgCntcPsonTpCd = bkgCntcPsonTpCd;
		this.vpsEtdDt = vpsEtdDt;
		this.arCurrCd = arCurrCd;
		this.delLocCd = delLocCd;
		this.delCd = delCd;
		this.skdVoyNo = skdVoyNo;
		this.faxIp = faxIp;
		this.custSeq = custSeq;
		this.skdDirCd = skdDirCd;
		this.podCd = podCd;
		this.bkgRefNo = bkgRefNo;
		this.bkgNo = bkgNo;
		this.bkgCPerson = bkgCPerson;
		this.polLocCd = polLocCd;
		this.cntrNo = cntrNo;
		this.faxNo = faxNo;
		this.skdVoyDir = skdVoyDir;
		this.custFullNm = custFullNm;
		this.language = language;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("ofc_eng_nm", getOfcEngNm());
		this.hashColumns.put("mphn_no", getMphnNo());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cntc_pson_fax_no", getCntcPsonFaxNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("rnum", getRnum());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("ofc_phn_no", getOfcPhnNo());
		this.hashColumns.put("ofc_addr", getOfcAddr());
		this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
		this.hashColumns.put("pod_loc_cd", getPodLocCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("rd_param", getRdParam());
		this.hashColumns.put("cntc_pson_eml", getCntcPsonEml());
		this.hashColumns.put("rcheck", getRcheck());
		this.hashColumns.put("subgroup_title", getSubgroupTitle());
		this.hashColumns.put("bkg_cntc_pson_tp_cd", getBkgCntcPsonTpCd());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("ar_curr_cd", getArCurrCd());
		this.hashColumns.put("del_loc_cd", getDelLocCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("fax_ip", getFaxIp());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_ref_no", getBkgRefNo());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("bkg_c_person", getBkgCPerson());
		this.hashColumns.put("pol_loc_cd", getPolLocCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("skd_voy_dir", getSkdVoyDir());
		this.hashColumns.put("cust_full_nm", getCustFullNm());
		this.hashColumns.put("language", getLanguage());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("ofc_eng_nm", "ofcEngNm");
		this.hashFields.put("mphn_no", "mphnNo");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cntc_pson_fax_no", "cntcPsonFaxNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("rnum", "rnum");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("ofc_phn_no", "ofcPhnNo");
		this.hashFields.put("ofc_addr", "ofcAddr");
		this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
		this.hashFields.put("pod_loc_cd", "podLocCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("rd_param", "rdParam");
		this.hashFields.put("cntc_pson_eml", "cntcPsonEml");
		this.hashFields.put("rcheck", "rcheck");
		this.hashFields.put("subgroup_title", "subgroupTitle");
		this.hashFields.put("bkg_cntc_pson_tp_cd", "bkgCntcPsonTpCd");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("ar_curr_cd", "arCurrCd");
		this.hashFields.put("del_loc_cd", "delLocCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("fax_ip", "faxIp");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_ref_no", "bkgRefNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("bkg_c_person", "bkgCPerson");
		this.hashFields.put("pol_loc_cd", "polLocCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("skd_voy_dir", "skdVoyDir");
		this.hashFields.put("cust_full_nm", "custFullNm");
		this.hashFields.put("language", "language");
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
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
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
	 * @return ofcEngNm
	 */
	public String getOfcEngNm() {
		return this.ofcEngNm;
	}
	
	/**
	 * Column Info
	 * @return mphnNo
	 */
	public String getMphnNo() {
		return this.mphnNo;
	}
	
	/**
	 * Column Info
	 * @return sndDt
	 */
	public String getSndDt() {
		return this.sndDt;
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
	 * @return cntcPsonFaxNo
	 */
	public String getCntcPsonFaxNo() {
		return this.cntcPsonFaxNo;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return cnmvStsCd
	 */
	public String getCnmvStsCd() {
		return this.cnmvStsCd;
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
	 * @return rnum
	 */
	public String getRnum() {
		return this.rnum;
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
	 * @return ofcPhnNo
	 */
	public String getOfcPhnNo() {
		return this.ofcPhnNo;
	}
	
	/**
	 * Column Info
	 * @return ofcAddr
	 */
	public String getOfcAddr() {
		return this.ofcAddr;
	}
	
	/**
	 * Column Info
	 * @return bkgCustTpCd
	 */
	public String getBkgCustTpCd() {
		return this.bkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return podLocCd
	 */
	public String getPodLocCd() {
		return this.podLocCd;
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
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rdParam
	 */
	public String getRdParam() {
		return this.rdParam;
	}
	
	/**
	 * Column Info
	 * @return cntcPsonEml
	 */
	public String getCntcPsonEml() {
		return this.cntcPsonEml;
	}
	
	/**
	 * Column Info
	 * @return rcheck
	 */
	public String getRcheck() {
		return this.rcheck;
	}
	
	/**
	 * Column Info
	 * @return subgroupTitle
	 */
	public String getSubgroupTitle() {
		return this.subgroupTitle;
	}
	
	/**
	 * Column Info
	 * @return bkgCntcPsonTpCd
	 */
	public String getBkgCntcPsonTpCd() {
		return this.bkgCntcPsonTpCd;
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
	 * @return arCurrCd
	 */
	public String getArCurrCd() {
		return this.arCurrCd;
	}
	
	/**
	 * Column Info
	 * @return delLocCd
	 */
	public String getDelLocCd() {
		return this.delLocCd;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return faxIp
	 */
	public String getFaxIp() {
		return this.faxIp;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return bkgRefNo
	 */
	public String getBkgRefNo() {
		return this.bkgRefNo;
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
	 * @return bkgCPerson
	 */
	public String getBkgCPerson() {
		return this.bkgCPerson;
	}
	
	/**
	 * Column Info
	 * @return polLocCd
	 */
	public String getPolLocCd() {
		return this.polLocCd;
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
	 * @return faxNo
	 */
	public String getFaxNo() {
		return this.faxNo;
	}
	
	/**
	 * Column Info
	 * @return skdVoyDir
	 */
	public String getSkdVoyDir() {
		return this.skdVoyDir;
	}
	
	/**
	 * Column Info
	 * @return custFullNm
	 */
	public String getCustFullNm() {
		return this.custFullNm;
	}
	
	/**
	 * Column Info
	 * @return language
	 */
	public String getLanguage() {
		return this.language;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
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
	 * @param ofcEngNm
	 */
	public void setOfcEngNm(String ofcEngNm) {
		this.ofcEngNm = ofcEngNm;
	}
	
	/**
	 * Column Info
	 * @param mphnNo
	 */
	public void setMphnNo(String mphnNo) {
		this.mphnNo = mphnNo;
	}
	
	/**
	 * Column Info
	 * @param sndDt
	 */
	public void setSndDt(String sndDt) {
		this.sndDt = sndDt;
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
	 * @param cntcPsonFaxNo
	 */
	public void setCntcPsonFaxNo(String cntcPsonFaxNo) {
		this.cntcPsonFaxNo = cntcPsonFaxNo;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param cnmvStsCd
	 */
	public void setCnmvStsCd(String cnmvStsCd) {
		this.cnmvStsCd = cnmvStsCd;
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
	 * @param rnum
	 */
	public void setRnum(String rnum) {
		this.rnum = rnum;
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
	 * @param ofcPhnNo
	 */
	public void setOfcPhnNo(String ofcPhnNo) {
		this.ofcPhnNo = ofcPhnNo;
	}
	
	/**
	 * Column Info
	 * @param ofcAddr
	 */
	public void setOfcAddr(String ofcAddr) {
		this.ofcAddr = ofcAddr;
	}
	
	/**
	 * Column Info
	 * @param bkgCustTpCd
	 */
	public void setBkgCustTpCd(String bkgCustTpCd) {
		this.bkgCustTpCd = bkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param podLocCd
	 */
	public void setPodLocCd(String podLocCd) {
		this.podLocCd = podLocCd;
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
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rdParam
	 */
	public void setRdParam(String rdParam) {
		this.rdParam = rdParam;
	}
	
	/**
	 * Column Info
	 * @param cntcPsonEml
	 */
	public void setCntcPsonEml(String cntcPsonEml) {
		this.cntcPsonEml = cntcPsonEml;
	}
	
	/**
	 * Column Info
	 * @param rcheck
	 */
	public void setRcheck(String rcheck) {
		this.rcheck = rcheck;
	}
	
	/**
	 * Column Info
	 * @param subgroupTitle
	 */
	public void setSubgroupTitle(String subgroupTitle) {
		this.subgroupTitle = subgroupTitle;
	}
	
	/**
	 * Column Info
	 * @param bkgCntcPsonTpCd
	 */
	public void setBkgCntcPsonTpCd(String bkgCntcPsonTpCd) {
		this.bkgCntcPsonTpCd = bkgCntcPsonTpCd;
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
	 * @param arCurrCd
	 */
	public void setArCurrCd(String arCurrCd) {
		this.arCurrCd = arCurrCd;
	}
	
	/**
	 * Column Info
	 * @param delLocCd
	 */
	public void setDelLocCd(String delLocCd) {
		this.delLocCd = delLocCd;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param faxIp
	 */
	public void setFaxIp(String faxIp) {
		this.faxIp = faxIp;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param bkgRefNo
	 */
	public void setBkgRefNo(String bkgRefNo) {
		this.bkgRefNo = bkgRefNo;
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
	 * @param bkgCPerson
	 */
	public void setBkgCPerson(String bkgCPerson) {
		this.bkgCPerson = bkgCPerson;
	}
	
	/**
	 * Column Info
	 * @param polLocCd
	 */
	public void setPolLocCd(String polLocCd) {
		this.polLocCd = polLocCd;
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
	 * @param faxNo
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	
	/**
	 * Column Info
	 * @param skdVoyDir
	 */
	public void setSkdVoyDir(String skdVoyDir) {
		this.skdVoyDir = skdVoyDir;
	}
	
	/**
	 * Column Info
	 * @param custFullNm
	 */
	public void setCustFullNm(String custFullNm) {
		this.custFullNm = custFullNm;
	}
	
	/**
	 * Column Info
	 * @param language
	 */
	public void setLanguage(String language) {
		this.language = language;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setOfcEngNm(JSPUtil.getParameter(request, prefix + "ofc_eng_nm", ""));
		setMphnNo(JSPUtil.getParameter(request, prefix + "mphn_no", ""));
		setSndDt(JSPUtil.getParameter(request, prefix + "snd_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCntcPsonFaxNo(JSPUtil.getParameter(request, prefix + "cntc_pson_fax_no", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, prefix + "cnmv_sts_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setRnum(JSPUtil.getParameter(request, prefix + "rnum", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setOfcPhnNo(JSPUtil.getParameter(request, prefix + "ofc_phn_no", ""));
		setOfcAddr(JSPUtil.getParameter(request, prefix + "ofc_addr", ""));
		setBkgCustTpCd(JSPUtil.getParameter(request, prefix + "bkg_cust_tp_cd", ""));
		setPodLocCd(JSPUtil.getParameter(request, prefix + "pod_loc_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setRdParam(JSPUtil.getParameter(request, prefix + "rd_param", ""));
		setCntcPsonEml(JSPUtil.getParameter(request, prefix + "cntc_pson_eml", ""));
		setRcheck(JSPUtil.getParameter(request, prefix + "rcheck", ""));
		setSubgroupTitle(JSPUtil.getParameter(request, prefix + "subgroup_title", ""));
		setBkgCntcPsonTpCd(JSPUtil.getParameter(request, prefix + "bkg_cntc_pson_tp_cd", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setArCurrCd(JSPUtil.getParameter(request, prefix + "ar_curr_cd", ""));
		setDelLocCd(JSPUtil.getParameter(request, prefix + "del_loc_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setFaxIp(JSPUtil.getParameter(request, prefix + "fax_ip", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgRefNo(JSPUtil.getParameter(request, prefix + "bkg_ref_no", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setBkgCPerson(JSPUtil.getParameter(request, prefix + "bkg_c_person", ""));
		setPolLocCd(JSPUtil.getParameter(request, prefix + "pol_loc_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setFaxNo(JSPUtil.getParameter(request, prefix + "fax_no", ""));
		setSkdVoyDir(JSPUtil.getParameter(request, prefix + "skd_voy_dir", ""));
		setCustFullNm(JSPUtil.getParameter(request, prefix + "cust_full_nm", ""));
		setLanguage(JSPUtil.getParameter(request, prefix + "language", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return LoadingConfirmationinVO[]
	 */
	public LoadingConfirmationinVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return LoadingConfirmationinVO[]
	 */
	public LoadingConfirmationinVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		LoadingConfirmationinVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] ofcEngNm = (JSPUtil.getParameter(request, prefix	+ "ofc_eng_nm", length));
			String[] mphnNo = (JSPUtil.getParameter(request, prefix	+ "mphn_no", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cntcPsonFaxNo = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_fax_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] rnum = (JSPUtil.getParameter(request, prefix	+ "rnum", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] ofcPhnNo = (JSPUtil.getParameter(request, prefix	+ "ofc_phn_no", length));
			String[] ofcAddr = (JSPUtil.getParameter(request, prefix	+ "ofc_addr", length));
			String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_tp_cd", length));
			String[] podLocCd = (JSPUtil.getParameter(request, prefix	+ "pod_loc_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] rdParam = (JSPUtil.getParameter(request, prefix	+ "rd_param", length));
			String[] cntcPsonEml = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_eml", length));
			String[] rcheck = (JSPUtil.getParameter(request, prefix	+ "rcheck", length));
			String[] subgroupTitle = (JSPUtil.getParameter(request, prefix	+ "subgroup_title", length));
			String[] bkgCntcPsonTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cntc_pson_tp_cd", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] arCurrCd = (JSPUtil.getParameter(request, prefix	+ "ar_curr_cd", length));
			String[] delLocCd = (JSPUtil.getParameter(request, prefix	+ "del_loc_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] faxIp = (JSPUtil.getParameter(request, prefix	+ "fax_ip", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgRefNo = (JSPUtil.getParameter(request, prefix	+ "bkg_ref_no", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] bkgCPerson = (JSPUtil.getParameter(request, prefix	+ "bkg_c_person", length));
			String[] polLocCd = (JSPUtil.getParameter(request, prefix	+ "pol_loc_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] skdVoyDir = (JSPUtil.getParameter(request, prefix	+ "skd_voy_dir", length));
			String[] custFullNm = (JSPUtil.getParameter(request, prefix	+ "cust_full_nm", length));
			String[] language = (JSPUtil.getParameter(request, prefix	+ "language", length));
			
			for (int i = 0; i < length; i++) {
				model = new LoadingConfirmationinVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (ofcEngNm[i] != null)
					model.setOfcEngNm(ofcEngNm[i]);
				if (mphnNo[i] != null)
					model.setMphnNo(mphnNo[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntcPsonFaxNo[i] != null)
					model.setCntcPsonFaxNo(cntcPsonFaxNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (rnum[i] != null)
					model.setRnum(rnum[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (ofcPhnNo[i] != null)
					model.setOfcPhnNo(ofcPhnNo[i]);
				if (ofcAddr[i] != null)
					model.setOfcAddr(ofcAddr[i]);
				if (bkgCustTpCd[i] != null)
					model.setBkgCustTpCd(bkgCustTpCd[i]);
				if (podLocCd[i] != null)
					model.setPodLocCd(podLocCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (rdParam[i] != null)
					model.setRdParam(rdParam[i]);
				if (cntcPsonEml[i] != null)
					model.setCntcPsonEml(cntcPsonEml[i]);
				if (rcheck[i] != null)
					model.setRcheck(rcheck[i]);
				if (subgroupTitle[i] != null)
					model.setSubgroupTitle(subgroupTitle[i]);
				if (bkgCntcPsonTpCd[i] != null)
					model.setBkgCntcPsonTpCd(bkgCntcPsonTpCd[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (arCurrCd[i] != null)
					model.setArCurrCd(arCurrCd[i]);
				if (delLocCd[i] != null)
					model.setDelLocCd(delLocCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (faxIp[i] != null)
					model.setFaxIp(faxIp[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgRefNo[i] != null)
					model.setBkgRefNo(bkgRefNo[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (bkgCPerson[i] != null)
					model.setBkgCPerson(bkgCPerson[i]);
				if (polLocCd[i] != null)
					model.setPolLocCd(polLocCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (skdVoyDir[i] != null)
					model.setSkdVoyDir(skdVoyDir[i]);
				if (custFullNm[i] != null)
					model.setCustFullNm(custFullNm[i]);
				if (language[i] != null)
					model.setLanguage(language[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getLoadingConfirmationinVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return LoadingConfirmationinVO[]
	 */
	public LoadingConfirmationinVO[] getLoadingConfirmationinVOs(){
		LoadingConfirmationinVO[] vos = (LoadingConfirmationinVO[])models.toArray(new LoadingConfirmationinVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcEngNm = this.ofcEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mphnNo = this.mphnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonFaxNo = this.cntcPsonFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rnum = this.rnum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcPhnNo = this.ofcPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcAddr = this.ofcAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCd = this.bkgCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podLocCd = this.podLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdParam = this.rdParam .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonEml = this.cntcPsonEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcheck = this.rcheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subgroupTitle = this.subgroupTitle .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCntcPsonTpCd = this.bkgCntcPsonTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arCurrCd = this.arCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delLocCd = this.delLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxIp = this.faxIp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRefNo = this.bkgRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCPerson = this.bkgCPerson .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polLocCd = this.polLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyDir = this.skdVoyDir .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custFullNm = this.custFullNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.language = this.language .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
