/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchCntRgstVO.java
*@FileTitle : SearchCntRgstVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.07
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2014.07.07 최종혁 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.codemanage.cnt.vo;

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
 * @author 최종혁
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchCntRgstVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCntRgstVO> models = new ArrayList<SearchCntRgstVO>();
	
	/* Column Info */
	private String custNomiTrkrFuelDivCd = null;
	/* Column Info */
	private String ctrtCustCntCd = null;
	/* Column Info */
	private String ctrtEffDt = null;
	/* Column Info */
	private String rgstUsrNm = null;
	/* Column Info */
	private String custNomiTrkrBzcAmt = null;
	/* Column Info */
	private String costDesc = null;
	/* Column Info */
	private String mtyPkupRtnYdNm = null;
	/* Column Info */
	private String custNomiTrkrFuelRto = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String destNodYard2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String destNodYard = null;
	/* Column Info */
	private String custNomiTrkrSavDt = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String ctrtCustNm = null;
	/* Column Info */
	private String slsOfcCd = null;
	/* Column Info */
	private String ctrtCustSrepNm = null;
	/* Column Info */
	private String destNodCd = null;
	/* Column Info */
	private String mtyPkupRtnYdCd = null;
	/* Column Info */
	private String orgNodYard2 = null;
	/* Column Info */
	private String custNomiTrkrRjctDt = null;
	/* Column Info */
	private String prcCtrtTpCd = null;
	/* Column Info */
	private String fnlMqcDesc = null;
	/* Column Info */
	private String ctrtExpDt = null;
	/* Column Info */
	private String aproNo = null;
	/* Column Info */
	private String ctrtCustSeq = null;
	/* Column Info */
	private String rgstUsrId = null;
	/* Column Info */
	private String dispStsCd = null;
	/* Column Info */
	private String ctrtCustCd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String orgNodYard = null;
	/* Column Info */
	private String prcCtrtNo = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String usaEdiCd = null;
	/* Column Info */
	private String orgNodCd = null;
	/* Column Info */
	private String custNomiTrkrAproDt = null;
	/* Column Info */
	private String ctrtCustSrepCd = null;
	/* Column Info */
	private String custNomiTrkrRqstDt = null;
	/* Column Info */
	private String custNomiTrkrFuelAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchCntRgstVO() {}

	public SearchCntRgstVO(String ibflag, String pagerows, String prcCtrtTpCd, String prcCtrtNo, String slsOfcCd, String ctrtCustSrepCd, String ctrtCustSrepNm, String ctrtCustCntCd, String ctrtCustCd, String ctrtCustSeq, String ctrtCustNm, String ctrtEffDt, String ctrtExpDt, String fnlMqcDesc, String vndrSeq, String vndrNm, String usaEdiCd, String ioBndCd, String orgNodCd, String orgNodYard, String orgNodYard2, String destNodCd, String destNodYard, String destNodYard2, String mtyPkupRtnYdCd, String mtyPkupRtnYdNm, String cntrTpszCd, String custNomiTrkrBzcAmt, String custNomiTrkrFuelDivCd, String custNomiTrkrFuelRto, String custNomiTrkrFuelAmt, String costDesc, String dispStsCd, String custNomiTrkrSavDt, String custNomiTrkrRqstDt, String custNomiTrkrRjctDt, String custNomiTrkrAproDt, String rgstUsrId, String rgstUsrNm, String aproNo) {
		this.custNomiTrkrFuelDivCd = custNomiTrkrFuelDivCd;
		this.ctrtCustCntCd = ctrtCustCntCd;
		this.ctrtEffDt = ctrtEffDt;
		this.rgstUsrNm = rgstUsrNm;
		this.custNomiTrkrBzcAmt = custNomiTrkrBzcAmt;
		this.costDesc = costDesc;
		this.mtyPkupRtnYdNm = mtyPkupRtnYdNm;
		this.custNomiTrkrFuelRto = custNomiTrkrFuelRto;
		this.pagerows = pagerows;
		this.vndrNm = vndrNm;
		this.destNodYard2 = destNodYard2;
		this.ibflag = ibflag;
		this.destNodYard = destNodYard;
		this.custNomiTrkrSavDt = custNomiTrkrSavDt;
		this.cntrTpszCd = cntrTpszCd;
		this.ctrtCustNm = ctrtCustNm;
		this.slsOfcCd = slsOfcCd;
		this.ctrtCustSrepNm = ctrtCustSrepNm;
		this.destNodCd = destNodCd;
		this.mtyPkupRtnYdCd = mtyPkupRtnYdCd;
		this.orgNodYard2 = orgNodYard2;
		this.custNomiTrkrRjctDt = custNomiTrkrRjctDt;
		this.prcCtrtTpCd = prcCtrtTpCd;
		this.fnlMqcDesc = fnlMqcDesc;
		this.ctrtExpDt = ctrtExpDt;
		this.aproNo = aproNo;
		this.ctrtCustSeq = ctrtCustSeq;
		this.rgstUsrId = rgstUsrId;
		this.dispStsCd = dispStsCd;
		this.ctrtCustCd = ctrtCustCd;
		this.ioBndCd = ioBndCd;
		this.orgNodYard = orgNodYard;
		this.prcCtrtNo = prcCtrtNo;
		this.vndrSeq = vndrSeq;
		this.usaEdiCd = usaEdiCd;
		this.orgNodCd = orgNodCd;
		this.custNomiTrkrAproDt = custNomiTrkrAproDt;
		this.ctrtCustSrepCd = ctrtCustSrepCd;
		this.custNomiTrkrRqstDt = custNomiTrkrRqstDt;
		this.custNomiTrkrFuelAmt = custNomiTrkrFuelAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cust_nomi_trkr_fuel_div_cd", getCustNomiTrkrFuelDivCd());
		this.hashColumns.put("ctrt_cust_cnt_cd", getCtrtCustCntCd());
		this.hashColumns.put("ctrt_eff_dt", getCtrtEffDt());
		this.hashColumns.put("rgst_usr_nm", getRgstUsrNm());
		this.hashColumns.put("cust_nomi_trkr_bzc_amt", getCustNomiTrkrBzcAmt());
		this.hashColumns.put("cost_desc", getCostDesc());
		this.hashColumns.put("mty_pkup_rtn_yd_nm", getMtyPkupRtnYdNm());
		this.hashColumns.put("cust_nomi_trkr_fuel_rto", getCustNomiTrkrFuelRto());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("dest_nod_yard2", getDestNodYard2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dest_nod_yard", getDestNodYard());
		this.hashColumns.put("cust_nomi_trkr_sav_dt", getCustNomiTrkrSavDt());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("ctrt_cust_nm", getCtrtCustNm());
		this.hashColumns.put("sls_ofc_cd", getSlsOfcCd());
		this.hashColumns.put("ctrt_cust_srep_nm", getCtrtCustSrepNm());
		this.hashColumns.put("dest_nod_cd", getDestNodCd());
		this.hashColumns.put("mty_pkup_rtn_yd_cd", getMtyPkupRtnYdCd());
		this.hashColumns.put("org_nod_yard2", getOrgNodYard2());
		this.hashColumns.put("cust_nomi_trkr_rjct_dt", getCustNomiTrkrRjctDt());
		this.hashColumns.put("prc_ctrt_tp_cd", getPrcCtrtTpCd());
		this.hashColumns.put("fnl_mqc_desc", getFnlMqcDesc());
		this.hashColumns.put("ctrt_exp_dt", getCtrtExpDt());
		this.hashColumns.put("apro_no", getAproNo());
		this.hashColumns.put("ctrt_cust_seq", getCtrtCustSeq());
		this.hashColumns.put("rgst_usr_id", getRgstUsrId());
		this.hashColumns.put("disp_sts_cd", getDispStsCd());
		this.hashColumns.put("ctrt_cust_cd", getCtrtCustCd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("org_nod_yard", getOrgNodYard());
		this.hashColumns.put("prc_ctrt_no", getPrcCtrtNo());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("usa_edi_cd", getUsaEdiCd());
		this.hashColumns.put("org_nod_cd", getOrgNodCd());
		this.hashColumns.put("cust_nomi_trkr_apro_dt", getCustNomiTrkrAproDt());
		this.hashColumns.put("ctrt_cust_srep_cd", getCtrtCustSrepCd());
		this.hashColumns.put("cust_nomi_trkr_rqst_dt", getCustNomiTrkrRqstDt());
		this.hashColumns.put("cust_nomi_trkr_fuel_amt", getCustNomiTrkrFuelAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cust_nomi_trkr_fuel_div_cd", "custNomiTrkrFuelDivCd");
		this.hashFields.put("ctrt_cust_cnt_cd", "ctrtCustCntCd");
		this.hashFields.put("ctrt_eff_dt", "ctrtEffDt");
		this.hashFields.put("rgst_usr_nm", "rgstUsrNm");
		this.hashFields.put("cust_nomi_trkr_bzc_amt", "custNomiTrkrBzcAmt");
		this.hashFields.put("cost_desc", "costDesc");
		this.hashFields.put("mty_pkup_rtn_yd_nm", "mtyPkupRtnYdNm");
		this.hashFields.put("cust_nomi_trkr_fuel_rto", "custNomiTrkrFuelRto");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("dest_nod_yard2", "destNodYard2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dest_nod_yard", "destNodYard");
		this.hashFields.put("cust_nomi_trkr_sav_dt", "custNomiTrkrSavDt");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("ctrt_cust_nm", "ctrtCustNm");
		this.hashFields.put("sls_ofc_cd", "slsOfcCd");
		this.hashFields.put("ctrt_cust_srep_nm", "ctrtCustSrepNm");
		this.hashFields.put("dest_nod_cd", "destNodCd");
		this.hashFields.put("mty_pkup_rtn_yd_cd", "mtyPkupRtnYdCd");
		this.hashFields.put("org_nod_yard2", "orgNodYard2");
		this.hashFields.put("cust_nomi_trkr_rjct_dt", "custNomiTrkrRjctDt");
		this.hashFields.put("prc_ctrt_tp_cd", "prcCtrtTpCd");
		this.hashFields.put("fnl_mqc_desc", "fnlMqcDesc");
		this.hashFields.put("ctrt_exp_dt", "ctrtExpDt");
		this.hashFields.put("apro_no", "aproNo");
		this.hashFields.put("ctrt_cust_seq", "ctrtCustSeq");
		this.hashFields.put("rgst_usr_id", "rgstUsrId");
		this.hashFields.put("disp_sts_cd", "dispStsCd");
		this.hashFields.put("ctrt_cust_cd", "ctrtCustCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("org_nod_yard", "orgNodYard");
		this.hashFields.put("prc_ctrt_no", "prcCtrtNo");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("usa_edi_cd", "usaEdiCd");
		this.hashFields.put("org_nod_cd", "orgNodCd");
		this.hashFields.put("cust_nomi_trkr_apro_dt", "custNomiTrkrAproDt");
		this.hashFields.put("ctrt_cust_srep_cd", "ctrtCustSrepCd");
		this.hashFields.put("cust_nomi_trkr_rqst_dt", "custNomiTrkrRqstDt");
		this.hashFields.put("cust_nomi_trkr_fuel_amt", "custNomiTrkrFuelAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return custNomiTrkrFuelDivCd
	 */
	public String getCustNomiTrkrFuelDivCd() {
		return this.custNomiTrkrFuelDivCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustCntCd
	 */
	public String getCtrtCustCntCd() {
		return this.ctrtCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtEffDt
	 */
	public String getCtrtEffDt() {
		return this.ctrtEffDt;
	}
	
	/**
	 * Column Info
	 * @return rgstUsrNm
	 */
	public String getRgstUsrNm() {
		return this.rgstUsrNm;
	}
	
	/**
	 * Column Info
	 * @return custNomiTrkrBzcAmt
	 */
	public String getCustNomiTrkrBzcAmt() {
		return this.custNomiTrkrBzcAmt;
	}
	
	/**
	 * Column Info
	 * @return costDesc
	 */
	public String getCostDesc() {
		return this.costDesc;
	}
	
	/**
	 * Column Info
	 * @return mtyPkupRtnYdNm
	 */
	public String getMtyPkupRtnYdNm() {
		return this.mtyPkupRtnYdNm;
	}
	
	/**
	 * Column Info
	 * @return custNomiTrkrFuelRto
	 */
	public String getCustNomiTrkrFuelRto() {
		return this.custNomiTrkrFuelRto;
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
	 * @return vndrNm
	 */
	public String getVndrNm() {
		return this.vndrNm;
	}
	
	/**
	 * Column Info
	 * @return destNodYard2
	 */
	public String getDestNodYard2() {
		return this.destNodYard2;
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
	 * @return destNodYard
	 */
	public String getDestNodYard() {
		return this.destNodYard;
	}
	
	/**
	 * Column Info
	 * @return custNomiTrkrSavDt
	 */
	public String getCustNomiTrkrSavDt() {
		return this.custNomiTrkrSavDt;
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
	 * @return ctrtCustNm
	 */
	public String getCtrtCustNm() {
		return this.ctrtCustNm;
	}
	
	/**
	 * Column Info
	 * @return slsOfcCd
	 */
	public String getSlsOfcCd() {
		return this.slsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustSrepNm
	 */
	public String getCtrtCustSrepNm() {
		return this.ctrtCustSrepNm;
	}
	
	/**
	 * Column Info
	 * @return destNodCd
	 */
	public String getDestNodCd() {
		return this.destNodCd;
	}
	
	/**
	 * Column Info
	 * @return mtyPkupRtnYdCd
	 */
	public String getMtyPkupRtnYdCd() {
		return this.mtyPkupRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @return orgNodYard2
	 */
	public String getOrgNodYard2() {
		return this.orgNodYard2;
	}
	
	/**
	 * Column Info
	 * @return custNomiTrkrRjctDt
	 */
	public String getCustNomiTrkrRjctDt() {
		return this.custNomiTrkrRjctDt;
	}
	
	/**
	 * Column Info
	 * @return prcCtrtTpCd
	 */
	public String getPrcCtrtTpCd() {
		return this.prcCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @return fnlMqcDesc
	 */
	public String getFnlMqcDesc() {
		return this.fnlMqcDesc;
	}
	
	/**
	 * Column Info
	 * @return ctrtExpDt
	 */
	public String getCtrtExpDt() {
		return this.ctrtExpDt;
	}
	
	/**
	 * Column Info
	 * @return aproNo
	 */
	public String getAproNo() {
		return this.aproNo;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustSeq
	 */
	public String getCtrtCustSeq() {
		return this.ctrtCustSeq;
	}
	
	/**
	 * Column Info
	 * @return rgstUsrId
	 */
	public String getRgstUsrId() {
		return this.rgstUsrId;
	}
	
	/**
	 * Column Info
	 * @return dispStsCd
	 */
	public String getDispStsCd() {
		return this.dispStsCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustCd
	 */
	public String getCtrtCustCd() {
		return this.ctrtCustCd;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return orgNodYard
	 */
	public String getOrgNodYard() {
		return this.orgNodYard;
	}
	
	/**
	 * Column Info
	 * @return prcCtrtNo
	 */
	public String getPrcCtrtNo() {
		return this.prcCtrtNo;
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
	 * @return usaEdiCd
	 */
	public String getUsaEdiCd() {
		return this.usaEdiCd;
	}
	
	/**
	 * Column Info
	 * @return orgNodCd
	 */
	public String getOrgNodCd() {
		return this.orgNodCd;
	}
	
	/**
	 * Column Info
	 * @return custNomiTrkrAproDt
	 */
	public String getCustNomiTrkrAproDt() {
		return this.custNomiTrkrAproDt;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustSrepCd
	 */
	public String getCtrtCustSrepCd() {
		return this.ctrtCustSrepCd;
	}
	
	/**
	 * Column Info
	 * @return custNomiTrkrRqstDt
	 */
	public String getCustNomiTrkrRqstDt() {
		return this.custNomiTrkrRqstDt;
	}
	
	/**
	 * Column Info
	 * @return custNomiTrkrFuelAmt
	 */
	public String getCustNomiTrkrFuelAmt() {
		return this.custNomiTrkrFuelAmt;
	}
	

	/**
	 * Column Info
	 * @param custNomiTrkrFuelDivCd
	 */
	public void setCustNomiTrkrFuelDivCd(String custNomiTrkrFuelDivCd) {
		this.custNomiTrkrFuelDivCd = custNomiTrkrFuelDivCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtCustCntCd
	 */
	public void setCtrtCustCntCd(String ctrtCustCntCd) {
		this.ctrtCustCntCd = ctrtCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtEffDt
	 */
	public void setCtrtEffDt(String ctrtEffDt) {
		this.ctrtEffDt = ctrtEffDt;
	}
	
	/**
	 * Column Info
	 * @param rgstUsrNm
	 */
	public void setRgstUsrNm(String rgstUsrNm) {
		this.rgstUsrNm = rgstUsrNm;
	}
	
	/**
	 * Column Info
	 * @param custNomiTrkrBzcAmt
	 */
	public void setCustNomiTrkrBzcAmt(String custNomiTrkrBzcAmt) {
		this.custNomiTrkrBzcAmt = custNomiTrkrBzcAmt;
	}
	
	/**
	 * Column Info
	 * @param costDesc
	 */
	public void setCostDesc(String costDesc) {
		this.costDesc = costDesc;
	}
	
	/**
	 * Column Info
	 * @param mtyPkupRtnYdNm
	 */
	public void setMtyPkupRtnYdNm(String mtyPkupRtnYdNm) {
		this.mtyPkupRtnYdNm = mtyPkupRtnYdNm;
	}
	
	/**
	 * Column Info
	 * @param custNomiTrkrFuelRto
	 */
	public void setCustNomiTrkrFuelRto(String custNomiTrkrFuelRto) {
		this.custNomiTrkrFuelRto = custNomiTrkrFuelRto;
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
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
	}
	
	/**
	 * Column Info
	 * @param destNodYard2
	 */
	public void setDestNodYard2(String destNodYard2) {
		this.destNodYard2 = destNodYard2;
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
	 * @param destNodYard
	 */
	public void setDestNodYard(String destNodYard) {
		this.destNodYard = destNodYard;
	}
	
	/**
	 * Column Info
	 * @param custNomiTrkrSavDt
	 */
	public void setCustNomiTrkrSavDt(String custNomiTrkrSavDt) {
		this.custNomiTrkrSavDt = custNomiTrkrSavDt;
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
	 * @param ctrtCustNm
	 */
	public void setCtrtCustNm(String ctrtCustNm) {
		this.ctrtCustNm = ctrtCustNm;
	}
	
	/**
	 * Column Info
	 * @param slsOfcCd
	 */
	public void setSlsOfcCd(String slsOfcCd) {
		this.slsOfcCd = slsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtCustSrepNm
	 */
	public void setCtrtCustSrepNm(String ctrtCustSrepNm) {
		this.ctrtCustSrepNm = ctrtCustSrepNm;
	}
	
	/**
	 * Column Info
	 * @param destNodCd
	 */
	public void setDestNodCd(String destNodCd) {
		this.destNodCd = destNodCd;
	}
	
	/**
	 * Column Info
	 * @param mtyPkupRtnYdCd
	 */
	public void setMtyPkupRtnYdCd(String mtyPkupRtnYdCd) {
		this.mtyPkupRtnYdCd = mtyPkupRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @param orgNodYard2
	 */
	public void setOrgNodYard2(String orgNodYard2) {
		this.orgNodYard2 = orgNodYard2;
	}
	
	/**
	 * Column Info
	 * @param custNomiTrkrRjctDt
	 */
	public void setCustNomiTrkrRjctDt(String custNomiTrkrRjctDt) {
		this.custNomiTrkrRjctDt = custNomiTrkrRjctDt;
	}
	
	/**
	 * Column Info
	 * @param prcCtrtTpCd
	 */
	public void setPrcCtrtTpCd(String prcCtrtTpCd) {
		this.prcCtrtTpCd = prcCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @param fnlMqcDesc
	 */
	public void setFnlMqcDesc(String fnlMqcDesc) {
		this.fnlMqcDesc = fnlMqcDesc;
	}
	
	/**
	 * Column Info
	 * @param ctrtExpDt
	 */
	public void setCtrtExpDt(String ctrtExpDt) {
		this.ctrtExpDt = ctrtExpDt;
	}
	
	/**
	 * Column Info
	 * @param aproNo
	 */
	public void setAproNo(String aproNo) {
		this.aproNo = aproNo;
	}
	
	/**
	 * Column Info
	 * @param ctrtCustSeq
	 */
	public void setCtrtCustSeq(String ctrtCustSeq) {
		this.ctrtCustSeq = ctrtCustSeq;
	}
	
	/**
	 * Column Info
	 * @param rgstUsrId
	 */
	public void setRgstUsrId(String rgstUsrId) {
		this.rgstUsrId = rgstUsrId;
	}
	
	/**
	 * Column Info
	 * @param dispStsCd
	 */
	public void setDispStsCd(String dispStsCd) {
		this.dispStsCd = dispStsCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtCustCd
	 */
	public void setCtrtCustCd(String ctrtCustCd) {
		this.ctrtCustCd = ctrtCustCd;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param orgNodYard
	 */
	public void setOrgNodYard(String orgNodYard) {
		this.orgNodYard = orgNodYard;
	}
	
	/**
	 * Column Info
	 * @param prcCtrtNo
	 */
	public void setPrcCtrtNo(String prcCtrtNo) {
		this.prcCtrtNo = prcCtrtNo;
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
	 * @param usaEdiCd
	 */
	public void setUsaEdiCd(String usaEdiCd) {
		this.usaEdiCd = usaEdiCd;
	}
	
	/**
	 * Column Info
	 * @param orgNodCd
	 */
	public void setOrgNodCd(String orgNodCd) {
		this.orgNodCd = orgNodCd;
	}
	
	/**
	 * Column Info
	 * @param custNomiTrkrAproDt
	 */
	public void setCustNomiTrkrAproDt(String custNomiTrkrAproDt) {
		this.custNomiTrkrAproDt = custNomiTrkrAproDt;
	}
	
	/**
	 * Column Info
	 * @param ctrtCustSrepCd
	 */
	public void setCtrtCustSrepCd(String ctrtCustSrepCd) {
		this.ctrtCustSrepCd = ctrtCustSrepCd;
	}
	
	/**
	 * Column Info
	 * @param custNomiTrkrRqstDt
	 */
	public void setCustNomiTrkrRqstDt(String custNomiTrkrRqstDt) {
		this.custNomiTrkrRqstDt = custNomiTrkrRqstDt;
	}
	
	/**
	 * Column Info
	 * @param custNomiTrkrFuelAmt
	 */
	public void setCustNomiTrkrFuelAmt(String custNomiTrkrFuelAmt) {
		this.custNomiTrkrFuelAmt = custNomiTrkrFuelAmt;
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
		setCustNomiTrkrFuelDivCd(JSPUtil.getParameter(request, prefix + "cust_nomi_trkr_fuel_div_cd", ""));
		setCtrtCustCntCd(JSPUtil.getParameter(request, prefix + "ctrt_cust_cnt_cd", ""));
		setCtrtEffDt(JSPUtil.getParameter(request, prefix + "ctrt_eff_dt", ""));
		setRgstUsrNm(JSPUtil.getParameter(request, prefix + "rgst_usr_nm", ""));
		setCustNomiTrkrBzcAmt(JSPUtil.getParameter(request, prefix + "cust_nomi_trkr_bzc_amt", ""));
		setCostDesc(JSPUtil.getParameter(request, prefix + "cost_desc", ""));
		setMtyPkupRtnYdNm(JSPUtil.getParameter(request, prefix + "mty_pkup_rtn_yd_nm", ""));
		setCustNomiTrkrFuelRto(JSPUtil.getParameter(request, prefix + "cust_nomi_trkr_fuel_rto", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setDestNodYard2(JSPUtil.getParameter(request, prefix + "dest_nod_yard2", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDestNodYard(JSPUtil.getParameter(request, prefix + "dest_nod_yard", ""));
		setCustNomiTrkrSavDt(JSPUtil.getParameter(request, prefix + "cust_nomi_trkr_sav_dt", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setCtrtCustNm(JSPUtil.getParameter(request, prefix + "ctrt_cust_nm", ""));
		setSlsOfcCd(JSPUtil.getParameter(request, prefix + "sls_ofc_cd", ""));
		setCtrtCustSrepNm(JSPUtil.getParameter(request, prefix + "ctrt_cust_srep_nm", ""));
		setDestNodCd(JSPUtil.getParameter(request, prefix + "dest_nod_cd", ""));
		setMtyPkupRtnYdCd(JSPUtil.getParameter(request, prefix + "mty_pkup_rtn_yd_cd", ""));
		setOrgNodYard2(JSPUtil.getParameter(request, prefix + "org_nod_yard2", ""));
		setCustNomiTrkrRjctDt(JSPUtil.getParameter(request, prefix + "cust_nomi_trkr_rjct_dt", ""));
		setPrcCtrtTpCd(JSPUtil.getParameter(request, prefix + "prc_ctrt_tp_cd", ""));
		setFnlMqcDesc(JSPUtil.getParameter(request, prefix + "fnl_mqc_desc", ""));
		setCtrtExpDt(JSPUtil.getParameter(request, prefix + "ctrt_exp_dt", ""));
		setAproNo(JSPUtil.getParameter(request, prefix + "apro_no", ""));
		setCtrtCustSeq(JSPUtil.getParameter(request, prefix + "ctrt_cust_seq", ""));
		setRgstUsrId(JSPUtil.getParameter(request, prefix + "rgst_usr_id", ""));
		setDispStsCd(JSPUtil.getParameter(request, prefix + "disp_sts_cd", ""));
		setCtrtCustCd(JSPUtil.getParameter(request, prefix + "ctrt_cust_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setOrgNodYard(JSPUtil.getParameter(request, prefix + "org_nod_yard", ""));
		setPrcCtrtNo(JSPUtil.getParameter(request, prefix + "prc_ctrt_no", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setUsaEdiCd(JSPUtil.getParameter(request, prefix + "usa_edi_cd", ""));
		setOrgNodCd(JSPUtil.getParameter(request, prefix + "org_nod_cd", ""));
		setCustNomiTrkrAproDt(JSPUtil.getParameter(request, prefix + "cust_nomi_trkr_apro_dt", ""));
		setCtrtCustSrepCd(JSPUtil.getParameter(request, prefix + "ctrt_cust_srep_cd", ""));
		setCustNomiTrkrRqstDt(JSPUtil.getParameter(request, prefix + "cust_nomi_trkr_rqst_dt", ""));
		setCustNomiTrkrFuelAmt(JSPUtil.getParameter(request, prefix + "cust_nomi_trkr_fuel_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCntRgstVO[]
	 */
	public SearchCntRgstVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCntRgstVO[]
	 */
	public SearchCntRgstVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCntRgstVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] custNomiTrkrFuelDivCd = (JSPUtil.getParameter(request, prefix	+ "cust_nomi_trkr_fuel_div_cd", length));
			String[] ctrtCustCntCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_cnt_cd", length));
			String[] ctrtEffDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_eff_dt", length));
			String[] rgstUsrNm = (JSPUtil.getParameter(request, prefix	+ "rgst_usr_nm", length));
			String[] custNomiTrkrBzcAmt = (JSPUtil.getParameter(request, prefix	+ "cust_nomi_trkr_bzc_amt", length));
			String[] costDesc = (JSPUtil.getParameter(request, prefix	+ "cost_desc", length));
			String[] mtyPkupRtnYdNm = (JSPUtil.getParameter(request, prefix	+ "mty_pkup_rtn_yd_nm", length));
			String[] custNomiTrkrFuelRto = (JSPUtil.getParameter(request, prefix	+ "cust_nomi_trkr_fuel_rto", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] destNodYard2 = (JSPUtil.getParameter(request, prefix	+ "dest_nod_yard2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] destNodYard = (JSPUtil.getParameter(request, prefix	+ "dest_nod_yard", length));
			String[] custNomiTrkrSavDt = (JSPUtil.getParameter(request, prefix	+ "cust_nomi_trkr_sav_dt", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] ctrtCustNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_nm", length));
			String[] slsOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_cd", length));
			String[] ctrtCustSrepNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_srep_nm", length));
			String[] destNodCd = (JSPUtil.getParameter(request, prefix	+ "dest_nod_cd", length));
			String[] mtyPkupRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "mty_pkup_rtn_yd_cd", length));
			String[] orgNodYard2 = (JSPUtil.getParameter(request, prefix	+ "org_nod_yard2", length));
			String[] custNomiTrkrRjctDt = (JSPUtil.getParameter(request, prefix	+ "cust_nomi_trkr_rjct_dt", length));
			String[] prcCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_ctrt_tp_cd", length));
			String[] fnlMqcDesc = (JSPUtil.getParameter(request, prefix	+ "fnl_mqc_desc", length));
			String[] ctrtExpDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_exp_dt", length));
			String[] aproNo = (JSPUtil.getParameter(request, prefix	+ "apro_no", length));
			String[] ctrtCustSeq = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_seq", length));
			String[] rgstUsrId = (JSPUtil.getParameter(request, prefix	+ "rgst_usr_id", length));
			String[] dispStsCd = (JSPUtil.getParameter(request, prefix	+ "disp_sts_cd", length));
			String[] ctrtCustCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_cd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] orgNodYard = (JSPUtil.getParameter(request, prefix	+ "org_nod_yard", length));
			String[] prcCtrtNo = (JSPUtil.getParameter(request, prefix	+ "prc_ctrt_no", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] usaEdiCd = (JSPUtil.getParameter(request, prefix	+ "usa_edi_cd", length));
			String[] orgNodCd = (JSPUtil.getParameter(request, prefix	+ "org_nod_cd", length));
			String[] custNomiTrkrAproDt = (JSPUtil.getParameter(request, prefix	+ "cust_nomi_trkr_apro_dt", length));
			String[] ctrtCustSrepCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_srep_cd", length));
			String[] custNomiTrkrRqstDt = (JSPUtil.getParameter(request, prefix	+ "cust_nomi_trkr_rqst_dt", length));
			String[] custNomiTrkrFuelAmt = (JSPUtil.getParameter(request, prefix	+ "cust_nomi_trkr_fuel_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCntRgstVO();
				if (custNomiTrkrFuelDivCd[i] != null)
					model.setCustNomiTrkrFuelDivCd(custNomiTrkrFuelDivCd[i]);
				if (ctrtCustCntCd[i] != null)
					model.setCtrtCustCntCd(ctrtCustCntCd[i]);
				if (ctrtEffDt[i] != null)
					model.setCtrtEffDt(ctrtEffDt[i]);
				if (rgstUsrNm[i] != null)
					model.setRgstUsrNm(rgstUsrNm[i]);
				if (custNomiTrkrBzcAmt[i] != null)
					model.setCustNomiTrkrBzcAmt(custNomiTrkrBzcAmt[i]);
				if (costDesc[i] != null)
					model.setCostDesc(costDesc[i]);
				if (mtyPkupRtnYdNm[i] != null)
					model.setMtyPkupRtnYdNm(mtyPkupRtnYdNm[i]);
				if (custNomiTrkrFuelRto[i] != null)
					model.setCustNomiTrkrFuelRto(custNomiTrkrFuelRto[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (destNodYard2[i] != null)
					model.setDestNodYard2(destNodYard2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (destNodYard[i] != null)
					model.setDestNodYard(destNodYard[i]);
				if (custNomiTrkrSavDt[i] != null)
					model.setCustNomiTrkrSavDt(custNomiTrkrSavDt[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (ctrtCustNm[i] != null)
					model.setCtrtCustNm(ctrtCustNm[i]);
				if (slsOfcCd[i] != null)
					model.setSlsOfcCd(slsOfcCd[i]);
				if (ctrtCustSrepNm[i] != null)
					model.setCtrtCustSrepNm(ctrtCustSrepNm[i]);
				if (destNodCd[i] != null)
					model.setDestNodCd(destNodCd[i]);
				if (mtyPkupRtnYdCd[i] != null)
					model.setMtyPkupRtnYdCd(mtyPkupRtnYdCd[i]);
				if (orgNodYard2[i] != null)
					model.setOrgNodYard2(orgNodYard2[i]);
				if (custNomiTrkrRjctDt[i] != null)
					model.setCustNomiTrkrRjctDt(custNomiTrkrRjctDt[i]);
				if (prcCtrtTpCd[i] != null)
					model.setPrcCtrtTpCd(prcCtrtTpCd[i]);
				if (fnlMqcDesc[i] != null)
					model.setFnlMqcDesc(fnlMqcDesc[i]);
				if (ctrtExpDt[i] != null)
					model.setCtrtExpDt(ctrtExpDt[i]);
				if (aproNo[i] != null)
					model.setAproNo(aproNo[i]);
				if (ctrtCustSeq[i] != null)
					model.setCtrtCustSeq(ctrtCustSeq[i]);
				if (rgstUsrId[i] != null)
					model.setRgstUsrId(rgstUsrId[i]);
				if (dispStsCd[i] != null)
					model.setDispStsCd(dispStsCd[i]);
				if (ctrtCustCd[i] != null)
					model.setCtrtCustCd(ctrtCustCd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (orgNodYard[i] != null)
					model.setOrgNodYard(orgNodYard[i]);
				if (prcCtrtNo[i] != null)
					model.setPrcCtrtNo(prcCtrtNo[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (usaEdiCd[i] != null)
					model.setUsaEdiCd(usaEdiCd[i]);
				if (orgNodCd[i] != null)
					model.setOrgNodCd(orgNodCd[i]);
				if (custNomiTrkrAproDt[i] != null)
					model.setCustNomiTrkrAproDt(custNomiTrkrAproDt[i]);
				if (ctrtCustSrepCd[i] != null)
					model.setCtrtCustSrepCd(ctrtCustSrepCd[i]);
				if (custNomiTrkrRqstDt[i] != null)
					model.setCustNomiTrkrRqstDt(custNomiTrkrRqstDt[i]);
				if (custNomiTrkrFuelAmt[i] != null)
					model.setCustNomiTrkrFuelAmt(custNomiTrkrFuelAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCntRgstVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCntRgstVO[]
	 */
	public SearchCntRgstVO[] getSearchCntRgstVOs(){
		SearchCntRgstVO[] vos = (SearchCntRgstVO[])models.toArray(new SearchCntRgstVO[models.size()]);
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
		this.custNomiTrkrFuelDivCd = this.custNomiTrkrFuelDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustCntCd = this.ctrtCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtEffDt = this.ctrtEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstUsrNm = this.rgstUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNomiTrkrBzcAmt = this.custNomiTrkrBzcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costDesc = this.costDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPkupRtnYdNm = this.mtyPkupRtnYdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNomiTrkrFuelRto = this.custNomiTrkrFuelRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destNodYard2 = this.destNodYard2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destNodYard = this.destNodYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNomiTrkrSavDt = this.custNomiTrkrSavDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustNm = this.ctrtCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcCd = this.slsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustSrepNm = this.ctrtCustSrepNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destNodCd = this.destNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPkupRtnYdCd = this.mtyPkupRtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgNodYard2 = this.orgNodYard2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNomiTrkrRjctDt = this.custNomiTrkrRjctDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCtrtTpCd = this.prcCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlMqcDesc = this.fnlMqcDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtExpDt = this.ctrtExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproNo = this.aproNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustSeq = this.ctrtCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstUsrId = this.rgstUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispStsCd = this.dispStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustCd = this.ctrtCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgNodYard = this.orgNodYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCtrtNo = this.prcCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaEdiCd = this.usaEdiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgNodCd = this.orgNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNomiTrkrAproDt = this.custNomiTrkrAproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustSrepCd = this.ctrtCustSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNomiTrkrRqstDt = this.custNomiTrkrRqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNomiTrkrFuelAmt = this.custNomiTrkrFuelAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

