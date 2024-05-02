/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SearchCntApprovalVO.java
*@FileTitle : SearchCntApprovalVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.20
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.01.20 신동일 
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
 * @author 신동일
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchCntApprovalVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCntApprovalVO> models = new ArrayList<SearchCntApprovalVO>();
	
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String custNomiTrkrFuelDivCd = null;
	/* Column Info */
	private String aproOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String custNomiTrkrSavDt = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String slsOfcCd = null;
	/* Column Info */
	private String ctrtCustSrepNm = null;
	/* Column Info */
	private String fnlMqcDesc = null;
	/* Column Info */
	private String hjsTrkrFuelAmt = null;
	/* Column Info */
	private String hjsCustNomiTrkrAgmtNoYn = null;
	/* Column Info */
	private String ctrtCustSeq = null;
	/* Column Info */
	private String dorNodYard = null;
	/* Column Info */
	private String rgstUsrId = null;
	/* Column Info */
	private String hjsTrkrBzcAmt = null;
	/* Column Info */
	private String aproNo2 = null;
	/* Column Info */
	private String prcCtrtNo = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String usaEdiCd = null;
	/* Column Info */
	private String custNomiTrkrAproDt = null;
	/* Column Info */
	private String custNomiTrkrRqstDt = null;
	/* Column Info */
	private String custNomiTrkrFuelAmt = null;
	/* Column Info */
	private String aproHisDesc = null;
	/* Column Info */
	private String ctrtCustCntCd = null;
	/* Column Info */
	private String ctrtEffDt = null;
	/* Column Info */
	private String toNodYard = null;
	/* Column Info */
	private String custNomiTrkrBzcAmt = null;
	/* Column Info */
	private String aproUsrNm = null;
	/* Column Info */
	private String costDesc = null;
	/* Column Info */
	private String fmNodYard = null;
	/* Column Info */
	private String mtyPkupRtnYdNm = null;
	/* Column Info */
	private String custNomiTrkrIndCd = null;
	/* Column Info */
	private String custNomiTrkrFuelRto = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String hjsTrkrAgmtNo = null;
	/* Column Info */
	private String rgstOfcCd = null;
	/* Column Info */
	private String ctrtCustNm = null;
	/* Column Info */
	private String hjsCustNomiTrkrAgmtNo = null;
	/* Column Info */
	private String dorNodCd = null;
	/* Column Info */
	private String prcCtrtTpCd = null;
	/* Column Info */
	private String custNomiTrkrRjctDt = null;
	/* Column Info */
	private String ctrtExpDt = null;
	/* Column Info */
	private String aproNo = null;
	/* Column Info */
	private String dispStsCd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String fmNodCd = null;
	/* Column Info */
	private String aproUsrId = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String ctrtCustSrepCd = null;
	/* Column Info */
	private String sel = null;
	
	private String expnAudRsltRmk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchCntApprovalVO() {}

	public SearchCntApprovalVO(String ibflag, String pagerows, String toNodCd, String custNomiTrkrFuelDivCd, String aproOfcCd, String vndrNm, String custNomiTrkrSavDt, String cntrTpszCd, String slsOfcCd, String ctrtCustSrepNm, String fnlMqcDesc, String hjsTrkrFuelAmt, String hjsCustNomiTrkrAgmtNoYn, String ctrtCustSeq, String rgstUsrId, String dorNodYard, String aproNo2, String hjsTrkrBzcAmt, String usaEdiCd, String vndrSeq, String prcCtrtNo, String custNomiTrkrAproDt, String custNomiTrkrRqstDt, String custNomiTrkrFuelAmt, String aproHisDesc, String ctrtCustCntCd, String ctrtEffDt, String toNodYard, String custNomiTrkrBzcAmt, String aproUsrNm, String costDesc, String fmNodYard, String mtyPkupRtnYdNm, String custNomiTrkrFuelRto, String hjsTrkrAgmtNo, String rgstOfcCd, String ctrtCustNm, String hjsCustNomiTrkrAgmtNo, String dorNodCd, String prcCtrtTpCd, String custNomiTrkrRjctDt, String ctrtExpDt, String aproNo, String dispStsCd, String ioBndCd, String fmNodCd, String aproUsrId, String seq, String ctrtCustSrepCd, String sel, String custNomiTrkrIndCd) {
		this.toNodCd = toNodCd;
		this.custNomiTrkrFuelDivCd = custNomiTrkrFuelDivCd;
		this.aproOfcCd = aproOfcCd;
		this.pagerows = pagerows;
		this.vndrNm = vndrNm;
		this.custNomiTrkrSavDt = custNomiTrkrSavDt;
		this.cntrTpszCd = cntrTpszCd;
		this.slsOfcCd = slsOfcCd;
		this.ctrtCustSrepNm = ctrtCustSrepNm;
		this.fnlMqcDesc = fnlMqcDesc;
		this.hjsTrkrFuelAmt = hjsTrkrFuelAmt;
		this.hjsCustNomiTrkrAgmtNoYn = hjsCustNomiTrkrAgmtNoYn;
		this.ctrtCustSeq = ctrtCustSeq;
		this.dorNodYard = dorNodYard;
		this.rgstUsrId = rgstUsrId;
		this.hjsTrkrBzcAmt = hjsTrkrBzcAmt;
		this.aproNo2 = aproNo2;
		this.prcCtrtNo = prcCtrtNo;
		this.vndrSeq = vndrSeq;
		this.usaEdiCd = usaEdiCd;
		this.custNomiTrkrAproDt = custNomiTrkrAproDt;
		this.custNomiTrkrRqstDt = custNomiTrkrRqstDt;
		this.custNomiTrkrFuelAmt = custNomiTrkrFuelAmt;
		this.aproHisDesc = aproHisDesc;
		this.ctrtCustCntCd = ctrtCustCntCd;
		this.ctrtEffDt = ctrtEffDt;
		this.toNodYard = toNodYard;
		this.custNomiTrkrBzcAmt = custNomiTrkrBzcAmt;
		this.aproUsrNm = aproUsrNm;
		this.costDesc = costDesc;
		this.fmNodYard = fmNodYard;
		this.mtyPkupRtnYdNm = mtyPkupRtnYdNm;
		this.custNomiTrkrIndCd = custNomiTrkrIndCd;
		this.custNomiTrkrFuelRto = custNomiTrkrFuelRto;
		this.ibflag = ibflag;
		this.hjsTrkrAgmtNo = hjsTrkrAgmtNo;
		this.rgstOfcCd = rgstOfcCd;
		this.ctrtCustNm = ctrtCustNm;
		this.hjsCustNomiTrkrAgmtNo = hjsCustNomiTrkrAgmtNo;
		this.dorNodCd = dorNodCd;
		this.prcCtrtTpCd = prcCtrtTpCd;
		this.custNomiTrkrRjctDt = custNomiTrkrRjctDt;
		this.ctrtExpDt = ctrtExpDt;
		this.aproNo = aproNo;
		this.dispStsCd = dispStsCd;
		this.ioBndCd = ioBndCd;
		this.fmNodCd = fmNodCd;
		this.aproUsrId = aproUsrId;
		this.seq = seq;
		this.ctrtCustSrepCd = ctrtCustSrepCd;
		this.sel = sel;
		this.expnAudRsltRmk = expnAudRsltRmk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("cust_nomi_trkr_fuel_div_cd", getCustNomiTrkrFuelDivCd());
		this.hashColumns.put("apro_ofc_cd", getAproOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("cust_nomi_trkr_sav_dt", getCustNomiTrkrSavDt());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("sls_ofc_cd", getSlsOfcCd());
		this.hashColumns.put("ctrt_cust_srep_nm", getCtrtCustSrepNm());
		this.hashColumns.put("fnl_mqc_desc", getFnlMqcDesc());
		this.hashColumns.put("hjs_trkr_fuel_amt", getHjsTrkrFuelAmt());
		this.hashColumns.put("hjs_cust_nomi_trkr_agmt_no_yn", getHjsCustNomiTrkrAgmtNoYn());
		this.hashColumns.put("ctrt_cust_seq", getCtrtCustSeq());
		this.hashColumns.put("dor_nod_yard", getDorNodYard());
		this.hashColumns.put("rgst_usr_id", getRgstUsrId());
		this.hashColumns.put("hjs_trkr_bzc_amt", getHjsTrkrBzcAmt());
		this.hashColumns.put("apro_no2", getAproNo2());
		this.hashColumns.put("prc_ctrt_no", getPrcCtrtNo());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("usa_edi_cd", getUsaEdiCd());
		this.hashColumns.put("cust_nomi_trkr_apro_dt", getCustNomiTrkrAproDt());
		this.hashColumns.put("cust_nomi_trkr_rqst_dt", getCustNomiTrkrRqstDt());
		this.hashColumns.put("cust_nomi_trkr_fuel_amt", getCustNomiTrkrFuelAmt());
		this.hashColumns.put("apro_his_desc", getAproHisDesc());
		this.hashColumns.put("ctrt_cust_cnt_cd", getCtrtCustCntCd());
		this.hashColumns.put("ctrt_eff_dt", getCtrtEffDt());
		this.hashColumns.put("to_nod_yard", getToNodYard());
		this.hashColumns.put("cust_nomi_trkr_bzc_amt", getCustNomiTrkrBzcAmt());
		this.hashColumns.put("apro_usr_nm", getAproUsrNm());
		this.hashColumns.put("cost_desc", getCostDesc());
		this.hashColumns.put("fm_nod_yard", getFmNodYard());
		this.hashColumns.put("mty_pkup_rtn_yd_nm", getMtyPkupRtnYdNm());
		this.hashColumns.put("cust_nomi_trkr_ind_cd", getCustNomiTrkrIndCd());
		this.hashColumns.put("cust_nomi_trkr_fuel_rto", getCustNomiTrkrFuelRto());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("hjs_trkr_agmt_no", getHjsTrkrAgmtNo());
		this.hashColumns.put("rgst_ofc_cd", getRgstOfcCd());
		this.hashColumns.put("ctrt_cust_nm", getCtrtCustNm());
		this.hashColumns.put("hjs_cust_nomi_trkr_agmt_no", getHjsCustNomiTrkrAgmtNo());
		this.hashColumns.put("dor_nod_cd", getDorNodCd());
		this.hashColumns.put("prc_ctrt_tp_cd", getPrcCtrtTpCd());
		this.hashColumns.put("cust_nomi_trkr_rjct_dt", getCustNomiTrkrRjctDt());
		this.hashColumns.put("ctrt_exp_dt", getCtrtExpDt());
		this.hashColumns.put("apro_no", getAproNo());
		this.hashColumns.put("disp_sts_cd", getDispStsCd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("apro_usr_id", getAproUsrId());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("ctrt_cust_srep_cd", getCtrtCustSrepCd());
		this.hashColumns.put("sel", getSel());
		this.hashColumns.put("expn_aud_rslt_rmk", getExpnAudRsltRmk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("cust_nomi_trkr_fuel_div_cd", "custNomiTrkrFuelDivCd");
		this.hashFields.put("apro_ofc_cd", "aproOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("cust_nomi_trkr_sav_dt", "custNomiTrkrSavDt");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("sls_ofc_cd", "slsOfcCd");
		this.hashFields.put("ctrt_cust_srep_nm", "ctrtCustSrepNm");
		this.hashFields.put("fnl_mqc_desc", "fnlMqcDesc");
		this.hashFields.put("hjs_trkr_fuel_amt", "hjsTrkrFuelAmt");
		this.hashFields.put("hjs_cust_nomi_trkr_agmt_no_yn", "hjsCustNomiTrkrAgmtNoYn");
		this.hashFields.put("ctrt_cust_seq", "ctrtCustSeq");
		this.hashFields.put("dor_nod_yard", "dorNodYard");
		this.hashFields.put("rgst_usr_id", "rgstUsrId");
		this.hashFields.put("hjs_trkr_bzc_amt", "hjsTrkrBzcAmt");
		this.hashFields.put("apro_no2", "aproNo2");
		this.hashFields.put("prc_ctrt_no", "prcCtrtNo");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("usa_edi_cd", "usaEdiCd");
		this.hashFields.put("cust_nomi_trkr_apro_dt", "custNomiTrkrAproDt");
		this.hashFields.put("cust_nomi_trkr_rqst_dt", "custNomiTrkrRqstDt");
		this.hashFields.put("cust_nomi_trkr_fuel_amt", "custNomiTrkrFuelAmt");
		this.hashFields.put("apro_his_desc", "aproHisDesc");
		this.hashFields.put("ctrt_cust_cnt_cd", "ctrtCustCntCd");
		this.hashFields.put("ctrt_eff_dt", "ctrtEffDt");
		this.hashFields.put("to_nod_yard", "toNodYard");
		this.hashFields.put("cust_nomi_trkr_bzc_amt", "custNomiTrkrBzcAmt");
		this.hashFields.put("apro_usr_nm", "aproUsrNm");
		this.hashFields.put("cost_desc", "costDesc");
		this.hashFields.put("fm_nod_yard", "fmNodYard");
		this.hashFields.put("mty_pkup_rtn_yd_nm", "mtyPkupRtnYdNm");
		this.hashFields.put("cust_nomi_trkr_ind_cd", "custNomiTrkrIndCd");
		this.hashFields.put("cust_nomi_trkr_fuel_rto", "custNomiTrkrFuelRto");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("hjs_trkr_agmt_no", "hjsTrkrAgmtNo");
		this.hashFields.put("rgst_ofc_cd", "rgstOfcCd");
		this.hashFields.put("ctrt_cust_nm", "ctrtCustNm");
		this.hashFields.put("hjs_cust_nomi_trkr_agmt_no", "hjsCustNomiTrkrAgmtNo");
		this.hashFields.put("dor_nod_cd", "dorNodCd");
		this.hashFields.put("prc_ctrt_tp_cd", "prcCtrtTpCd");
		this.hashFields.put("cust_nomi_trkr_rjct_dt", "custNomiTrkrRjctDt");
		this.hashFields.put("ctrt_exp_dt", "ctrtExpDt");
		this.hashFields.put("apro_no", "aproNo");
		this.hashFields.put("disp_sts_cd", "dispStsCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("apro_usr_id", "aproUsrId");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("ctrt_cust_srep_cd", "ctrtCustSrepCd");
		this.hashFields.put("sel", "sel");
		this.hashFields.put("expn_aud_rslt_rmk", "expnAudRsltRmk");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toNodCd
	 */
	public String getToNodCd() {
		return this.toNodCd;
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
	 * @return aproOfcCd
	 */
	public String getAproOfcCd() {
		return this.aproOfcCd;
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
	 * @return fnlMqcDesc
	 */
	public String getFnlMqcDesc() {
		return this.fnlMqcDesc;
	}
	
	/**
	 * Column Info
	 * @return hjsTrkrFuelAmt
	 */
	public String getHjsTrkrFuelAmt() {
		return this.hjsTrkrFuelAmt;
	}
	
	/**
	 * Column Info
	 * @return hjsCustNomiTrkrAgmtNoYn
	 */
	public String getHjsCustNomiTrkrAgmtNoYn() {
		return this.hjsCustNomiTrkrAgmtNoYn;
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
	 * @return dorNodYard
	 */
	public String getDorNodYard() {
		return this.dorNodYard;
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
	 * @return hjsTrkrBzcAmt
	 */
	public String getHjsTrkrBzcAmt() {
		return this.hjsTrkrBzcAmt;
	}
	
	/**
	 * Column Info
	 * @return aproNo2
	 */
	public String getAproNo2() {
		return this.aproNo2;
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
	 * @return custNomiTrkrAproDt
	 */
	public String getCustNomiTrkrAproDt() {
		return this.custNomiTrkrAproDt;
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
	 * @return aproHisDesc
	 */
	public String getAproHisDesc() {
		return this.aproHisDesc;
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
	 * @return toNodYard
	 */
	public String getToNodYard() {
		return this.toNodYard;
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
	 * @return aproUsrNm
	 */
	public String getAproUsrNm() {
		return this.aproUsrNm;
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
	 * @return fmNodYard
	 */
	public String getFmNodYard() {
		return this.fmNodYard;
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
	 * @return custNomiTrkrIndCd
	 */
	public String getCustNomiTrkrIndCd() {
		return this.custNomiTrkrIndCd;
	}
	
	/**
	 * Column Info
	 * @return custNomiTrkrFuelRto
	 */
	public String getCustNomiTrkrFuelRto() {
		return this.custNomiTrkrFuelRto;
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
	 * @return hjsTrkrAgmtNo
	 */
	public String getHjsTrkrAgmtNo() {
		return this.hjsTrkrAgmtNo;
	}
	
	/**
	 * Column Info
	 * @return rgstOfcCd
	 */
	public String getRgstOfcCd() {
		return this.rgstOfcCd;
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
	 * @return hjsCustNomiTrkrAgmtNo
	 */
	public String getHjsCustNomiTrkrAgmtNo() {
		return this.hjsCustNomiTrkrAgmtNo;
	}
	
	/**
	 * Column Info
	 * @return dorNodCd
	 */
	public String getDorNodCd() {
		return this.dorNodCd;
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
	 * @return custNomiTrkrRjctDt
	 */
	public String getCustNomiTrkrRjctDt() {
		return this.custNomiTrkrRjctDt;
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
	 * @return dispStsCd
	 */
	public String getDispStsCd() {
		return this.dispStsCd;
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
	 * @return fmNodCd
	 */
	public String getFmNodCd() {
		return this.fmNodCd;
	}
	
	/**
	 * Column Info
	 * @return aproUsrId
	 */
	public String getAproUsrId() {
		return this.aproUsrId;
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
	 * @return ctrtCustSrepCd
	 */
	public String getCtrtCustSrepCd() {
		return this.ctrtCustSrepCd;
	}
	
	/**
	 * Column Info
	 * @return sel
	 */
	public String getSel() {
		return this.sel;
	}
	
	public String getExpnAudRsltRmk() {
		return expnAudRsltRmk;
	}
	

	/**
	 * Column Info
	 * @param toNodCd
	 */
	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
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
	 * @param aproOfcCd
	 */
	public void setAproOfcCd(String aproOfcCd) {
		this.aproOfcCd = aproOfcCd;
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
	 * @param fnlMqcDesc
	 */
	public void setFnlMqcDesc(String fnlMqcDesc) {
		this.fnlMqcDesc = fnlMqcDesc;
	}
	
	/**
	 * Column Info
	 * @param hjsTrkrFuelAmt
	 */
	public void setHjsTrkrFuelAmt(String hjsTrkrFuelAmt) {
		this.hjsTrkrFuelAmt = hjsTrkrFuelAmt;
	}
	
	/**
	 * Column Info
	 * @param hjsCustNomiTrkrAgmtNoYn
	 */
	public void setHjsCustNomiTrkrAgmtNoYn(String hjsCustNomiTrkrAgmtNoYn) {
		this.hjsCustNomiTrkrAgmtNoYn = hjsCustNomiTrkrAgmtNoYn;
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
	 * @param dorNodYard
	 */
	public void setDorNodYard(String dorNodYard) {
		this.dorNodYard = dorNodYard;
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
	 * @param hjsTrkrBzcAmt
	 */
	public void setHjsTrkrBzcAmt(String hjsTrkrBzcAmt) {
		this.hjsTrkrBzcAmt = hjsTrkrBzcAmt;
	}
	
	/**
	 * Column Info
	 * @param aproNo2
	 */
	public void setAproNo2(String aproNo2) {
		this.aproNo2 = aproNo2;
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
	 * @param custNomiTrkrAproDt
	 */
	public void setCustNomiTrkrAproDt(String custNomiTrkrAproDt) {
		this.custNomiTrkrAproDt = custNomiTrkrAproDt;
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
	 * Column Info
	 * @param aproHisDesc
	 */
	public void setAproHisDesc(String aproHisDesc) {
		this.aproHisDesc = aproHisDesc;
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
	 * @param toNodYard
	 */
	public void setToNodYard(String toNodYard) {
		this.toNodYard = toNodYard;
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
	 * @param aproUsrNm
	 */
	public void setAproUsrNm(String aproUsrNm) {
		this.aproUsrNm = aproUsrNm;
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
	 * @param fmNodYard
	 */
	public void setFmNodYard(String fmNodYard) {
		this.fmNodYard = fmNodYard;
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
	 * @param custNomiTrkrIndCd
	 */
	public void setCustNomiTrkrIndCd(String custNomiTrkrIndCd) {
		this.custNomiTrkrIndCd = custNomiTrkrIndCd;
	}
	
	/**
	 * Column Info
	 * @param custNomiTrkrFuelRto
	 */
	public void setCustNomiTrkrFuelRto(String custNomiTrkrFuelRto) {
		this.custNomiTrkrFuelRto = custNomiTrkrFuelRto;
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
	 * @param hjsTrkrAgmtNo
	 */
	public void setHjsTrkrAgmtNo(String hjsTrkrAgmtNo) {
		this.hjsTrkrAgmtNo = hjsTrkrAgmtNo;
	}
	
	/**
	 * Column Info
	 * @param rgstOfcCd
	 */
	public void setRgstOfcCd(String rgstOfcCd) {
		this.rgstOfcCd = rgstOfcCd;
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
	 * @param hjsCustNomiTrkrAgmtNo
	 */
	public void setHjsCustNomiTrkrAgmtNo(String hjsCustNomiTrkrAgmtNo) {
		this.hjsCustNomiTrkrAgmtNo = hjsCustNomiTrkrAgmtNo;
	}
	
	/**
	 * Column Info
	 * @param dorNodCd
	 */
	public void setDorNodCd(String dorNodCd) {
		this.dorNodCd = dorNodCd;
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
	 * @param custNomiTrkrRjctDt
	 */
	public void setCustNomiTrkrRjctDt(String custNomiTrkrRjctDt) {
		this.custNomiTrkrRjctDt = custNomiTrkrRjctDt;
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
	 * @param dispStsCd
	 */
	public void setDispStsCd(String dispStsCd) {
		this.dispStsCd = dispStsCd;
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
	 * @param fmNodCd
	 */
	public void setFmNodCd(String fmNodCd) {
		this.fmNodCd = fmNodCd;
	}
	
	/**
	 * Column Info
	 * @param aproUsrId
	 */
	public void setAproUsrId(String aproUsrId) {
		this.aproUsrId = aproUsrId;
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
	 * @param ctrtCustSrepCd
	 */
	public void setCtrtCustSrepCd(String ctrtCustSrepCd) {
		this.ctrtCustSrepCd = ctrtCustSrepCd;
	}
	
	/**
	 * Column Info
	 * @param sel
	 */
	public void setSel(String sel) {
		this.sel = sel;
	}
	
	public void setExpnAudRsltRmk(String expnAudRsltRmk) {
		this.expnAudRsltRmk = expnAudRsltRmk;
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
		setToNodCd(JSPUtil.getParameter(request, prefix + "to_nod_cd", ""));
		setCustNomiTrkrFuelDivCd(JSPUtil.getParameter(request, prefix + "cust_nomi_trkr_fuel_div_cd", ""));
		setAproOfcCd(JSPUtil.getParameter(request, prefix + "apro_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setCustNomiTrkrSavDt(JSPUtil.getParameter(request, prefix + "cust_nomi_trkr_sav_dt", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setSlsOfcCd(JSPUtil.getParameter(request, prefix + "sls_ofc_cd", ""));
		setCtrtCustSrepNm(JSPUtil.getParameter(request, prefix + "ctrt_cust_srep_nm", ""));
		setFnlMqcDesc(JSPUtil.getParameter(request, prefix + "fnl_mqc_desc", ""));
		setHjsTrkrFuelAmt(JSPUtil.getParameter(request, prefix + "hjs_trkr_fuel_amt", ""));
		setHjsCustNomiTrkrAgmtNoYn(JSPUtil.getParameter(request, prefix + "hjs_cust_nomi_trkr_agmt_no_yn", ""));
		setCtrtCustSeq(JSPUtil.getParameter(request, prefix + "ctrt_cust_seq", ""));
		setDorNodYard(JSPUtil.getParameter(request, prefix + "dor_nod_yard", ""));
		setRgstUsrId(JSPUtil.getParameter(request, prefix + "rgst_usr_id", ""));
		setHjsTrkrBzcAmt(JSPUtil.getParameter(request, prefix + "hjs_trkr_bzc_amt", ""));
		setAproNo2(JSPUtil.getParameter(request, prefix + "apro_no2", ""));
		setPrcCtrtNo(JSPUtil.getParameter(request, prefix + "prc_ctrt_no", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setUsaEdiCd(JSPUtil.getParameter(request, prefix + "usa_edi_cd", ""));
		setCustNomiTrkrAproDt(JSPUtil.getParameter(request, prefix + "cust_nomi_trkr_apro_dt", ""));
		setCustNomiTrkrRqstDt(JSPUtil.getParameter(request, prefix + "cust_nomi_trkr_rqst_dt", ""));
		setCustNomiTrkrFuelAmt(JSPUtil.getParameter(request, prefix + "cust_nomi_trkr_fuel_amt", ""));
		setAproHisDesc(JSPUtil.getParameter(request, prefix + "apro_his_desc", ""));
		setCtrtCustCntCd(JSPUtil.getParameter(request, prefix + "ctrt_cust_cnt_cd", ""));
		setCtrtEffDt(JSPUtil.getParameter(request, prefix + "ctrt_eff_dt", ""));
		setToNodYard(JSPUtil.getParameter(request, prefix + "to_nod_yard", ""));
		setCustNomiTrkrBzcAmt(JSPUtil.getParameter(request, prefix + "cust_nomi_trkr_bzc_amt", ""));
		setAproUsrNm(JSPUtil.getParameter(request, prefix + "apro_usr_nm", ""));
		setCostDesc(JSPUtil.getParameter(request, prefix + "cost_desc", ""));
		setFmNodYard(JSPUtil.getParameter(request, prefix + "fm_nod_yard", ""));
		setMtyPkupRtnYdNm(JSPUtil.getParameter(request, prefix + "mty_pkup_rtn_yd_nm", ""));
		setCustNomiTrkrIndCd(JSPUtil.getParameter(request, prefix + "cust_nomi_trkr_ind_cd", ""));
		setCustNomiTrkrFuelRto(JSPUtil.getParameter(request, prefix + "cust_nomi_trkr_fuel_rto", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setHjsTrkrAgmtNo(JSPUtil.getParameter(request, prefix + "hjs_trkr_agmt_no", ""));
		setRgstOfcCd(JSPUtil.getParameter(request, prefix + "rgst_ofc_cd", ""));
		setCtrtCustNm(JSPUtil.getParameter(request, prefix + "ctrt_cust_nm", ""));
		setHjsCustNomiTrkrAgmtNo(JSPUtil.getParameter(request, prefix + "hjs_cust_nomi_trkr_agmt_no", ""));
		setDorNodCd(JSPUtil.getParameter(request, prefix + "dor_nod_cd", ""));
		setPrcCtrtTpCd(JSPUtil.getParameter(request, prefix + "prc_ctrt_tp_cd", ""));
		setCustNomiTrkrRjctDt(JSPUtil.getParameter(request, prefix + "cust_nomi_trkr_rjct_dt", ""));
		setCtrtExpDt(JSPUtil.getParameter(request, prefix + "ctrt_exp_dt", ""));
		setAproNo(JSPUtil.getParameter(request, prefix + "apro_no", ""));
		setDispStsCd(JSPUtil.getParameter(request, prefix + "disp_sts_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setFmNodCd(JSPUtil.getParameter(request, prefix + "fm_nod_cd", ""));
		setAproUsrId(JSPUtil.getParameter(request, prefix + "apro_usr_id", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setCtrtCustSrepCd(JSPUtil.getParameter(request, prefix + "ctrt_cust_srep_cd", ""));
		setSel(JSPUtil.getParameter(request, prefix + "sel", ""));
		setExpnAudRsltRmk(JSPUtil.getParameter(request, prefix + "expn_aud_rslt_rmk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCntApprovalVO[]
	 */
	public SearchCntApprovalVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCntApprovalVO[]
	 */
	public SearchCntApprovalVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCntApprovalVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] custNomiTrkrFuelDivCd = (JSPUtil.getParameter(request, prefix	+ "cust_nomi_trkr_fuel_div_cd", length));
			String[] aproOfcCd = (JSPUtil.getParameter(request, prefix	+ "apro_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] custNomiTrkrSavDt = (JSPUtil.getParameter(request, prefix	+ "cust_nomi_trkr_sav_dt", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] slsOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_cd", length));
			String[] ctrtCustSrepNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_srep_nm", length));
			String[] fnlMqcDesc = (JSPUtil.getParameter(request, prefix	+ "fnl_mqc_desc", length));
			String[] hjsTrkrFuelAmt = (JSPUtil.getParameter(request, prefix	+ "hjs_trkr_fuel_amt", length));
			String[] hjsCustNomiTrkrAgmtNoYn = (JSPUtil.getParameter(request, prefix	+ "hjs_cust_nomi_trkr_agmt_no_yn", length));
			String[] ctrtCustSeq = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_seq", length));
			String[] dorNodYard = (JSPUtil.getParameter(request, prefix	+ "dor_nod_yard", length));
			String[] rgstUsrId = (JSPUtil.getParameter(request, prefix	+ "rgst_usr_id", length));
			String[] hjsTrkrBzcAmt = (JSPUtil.getParameter(request, prefix	+ "hjs_trkr_bzc_amt", length));
			String[] aproNo2 = (JSPUtil.getParameter(request, prefix	+ "apro_no2", length));
			String[] prcCtrtNo = (JSPUtil.getParameter(request, prefix	+ "prc_ctrt_no", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] usaEdiCd = (JSPUtil.getParameter(request, prefix	+ "usa_edi_cd", length));
			String[] custNomiTrkrAproDt = (JSPUtil.getParameter(request, prefix	+ "cust_nomi_trkr_apro_dt", length));
			String[] custNomiTrkrRqstDt = (JSPUtil.getParameter(request, prefix	+ "cust_nomi_trkr_rqst_dt", length));
			String[] custNomiTrkrFuelAmt = (JSPUtil.getParameter(request, prefix	+ "cust_nomi_trkr_fuel_amt", length));
			String[] aproHisDesc = (JSPUtil.getParameter(request, prefix	+ "apro_his_desc", length));
			String[] ctrtCustCntCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_cnt_cd", length));
			String[] ctrtEffDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_eff_dt", length));
			String[] toNodYard = (JSPUtil.getParameter(request, prefix	+ "to_nod_yard", length));
			String[] custNomiTrkrBzcAmt = (JSPUtil.getParameter(request, prefix	+ "cust_nomi_trkr_bzc_amt", length));
			String[] aproUsrNm = (JSPUtil.getParameter(request, prefix	+ "apro_usr_nm", length));
			String[] costDesc = (JSPUtil.getParameter(request, prefix	+ "cost_desc", length));
			String[] fmNodYard = (JSPUtil.getParameter(request, prefix	+ "fm_nod_yard", length));
			String[] mtyPkupRtnYdNm = (JSPUtil.getParameter(request, prefix	+ "mty_pkup_rtn_yd_nm", length));
			String[] custNomiTrkrIndCd = (JSPUtil.getParameter(request, prefix	+ "cust_nomi_trkr_ind_cd", length));
			String[] custNomiTrkrFuelRto = (JSPUtil.getParameter(request, prefix	+ "cust_nomi_trkr_fuel_rto", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] hjsTrkrAgmtNo = (JSPUtil.getParameter(request, prefix	+ "hjs_trkr_agmt_no", length));
			String[] rgstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rgst_ofc_cd", length));
			String[] ctrtCustNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_nm", length));
			String[] hjsCustNomiTrkrAgmtNo = (JSPUtil.getParameter(request, prefix	+ "hjs_cust_nomi_trkr_agmt_no", length));
			String[] dorNodCd = (JSPUtil.getParameter(request, prefix	+ "dor_nod_cd", length));
			String[] prcCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_ctrt_tp_cd", length));
			String[] custNomiTrkrRjctDt = (JSPUtil.getParameter(request, prefix	+ "cust_nomi_trkr_rjct_dt", length));
			String[] ctrtExpDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_exp_dt", length));
			String[] aproNo = (JSPUtil.getParameter(request, prefix	+ "apro_no", length));
			String[] dispStsCd = (JSPUtil.getParameter(request, prefix	+ "disp_sts_cd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] aproUsrId = (JSPUtil.getParameter(request, prefix	+ "apro_usr_id", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] ctrtCustSrepCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_srep_cd", length));
			String[] sel = (JSPUtil.getParameter(request, prefix	+ "sel", length));
			String[] expnAudRsltRmk = (JSPUtil.getParameter(request, prefix	+ "expn_aud_rslt_rmk", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCntApprovalVO();
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (custNomiTrkrFuelDivCd[i] != null)
					model.setCustNomiTrkrFuelDivCd(custNomiTrkrFuelDivCd[i]);
				if (aproOfcCd[i] != null)
					model.setAproOfcCd(aproOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (custNomiTrkrSavDt[i] != null)
					model.setCustNomiTrkrSavDt(custNomiTrkrSavDt[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (slsOfcCd[i] != null)
					model.setSlsOfcCd(slsOfcCd[i]);
				if (ctrtCustSrepNm[i] != null)
					model.setCtrtCustSrepNm(ctrtCustSrepNm[i]);
				if (fnlMqcDesc[i] != null)
					model.setFnlMqcDesc(fnlMqcDesc[i]);
				if (hjsTrkrFuelAmt[i] != null)
					model.setHjsTrkrFuelAmt(hjsTrkrFuelAmt[i]);
				if (hjsCustNomiTrkrAgmtNoYn[i] != null)
					model.setHjsCustNomiTrkrAgmtNoYn(hjsCustNomiTrkrAgmtNoYn[i]);
				if (ctrtCustSeq[i] != null)
					model.setCtrtCustSeq(ctrtCustSeq[i]);
				if (dorNodYard[i] != null)
					model.setDorNodYard(dorNodYard[i]);
				if (rgstUsrId[i] != null)
					model.setRgstUsrId(rgstUsrId[i]);
				if (hjsTrkrBzcAmt[i] != null)
					model.setHjsTrkrBzcAmt(hjsTrkrBzcAmt[i]);
				if (aproNo2[i] != null)
					model.setAproNo2(aproNo2[i]);
				if (prcCtrtNo[i] != null)
					model.setPrcCtrtNo(prcCtrtNo[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (usaEdiCd[i] != null)
					model.setUsaEdiCd(usaEdiCd[i]);
				if (custNomiTrkrAproDt[i] != null)
					model.setCustNomiTrkrAproDt(custNomiTrkrAproDt[i]);
				if (custNomiTrkrRqstDt[i] != null)
					model.setCustNomiTrkrRqstDt(custNomiTrkrRqstDt[i]);
				if (custNomiTrkrFuelAmt[i] != null)
					model.setCustNomiTrkrFuelAmt(custNomiTrkrFuelAmt[i]);
				if (aproHisDesc[i] != null)
					model.setAproHisDesc(aproHisDesc[i]);
				if (ctrtCustCntCd[i] != null)
					model.setCtrtCustCntCd(ctrtCustCntCd[i]);
				if (ctrtEffDt[i] != null)
					model.setCtrtEffDt(ctrtEffDt[i]);
				if (toNodYard[i] != null)
					model.setToNodYard(toNodYard[i]);
				if (custNomiTrkrBzcAmt[i] != null)
					model.setCustNomiTrkrBzcAmt(custNomiTrkrBzcAmt[i]);
				if (aproUsrNm[i] != null)
					model.setAproUsrNm(aproUsrNm[i]);
				if (costDesc[i] != null)
					model.setCostDesc(costDesc[i]);
				if (fmNodYard[i] != null)
					model.setFmNodYard(fmNodYard[i]);
				if (mtyPkupRtnYdNm[i] != null)
					model.setMtyPkupRtnYdNm(mtyPkupRtnYdNm[i]);
				if (custNomiTrkrIndCd[i] != null)
					model.setCustNomiTrkrIndCd(custNomiTrkrIndCd[i]);
				if (custNomiTrkrFuelRto[i] != null)
					model.setCustNomiTrkrFuelRto(custNomiTrkrFuelRto[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (hjsTrkrAgmtNo[i] != null)
					model.setHjsTrkrAgmtNo(hjsTrkrAgmtNo[i]);
				if (rgstOfcCd[i] != null)
					model.setRgstOfcCd(rgstOfcCd[i]);
				if (ctrtCustNm[i] != null)
					model.setCtrtCustNm(ctrtCustNm[i]);
				if (hjsCustNomiTrkrAgmtNo[i] != null)
					model.setHjsCustNomiTrkrAgmtNo(hjsCustNomiTrkrAgmtNo[i]);
				if (dorNodCd[i] != null)
					model.setDorNodCd(dorNodCd[i]);
				if (prcCtrtTpCd[i] != null)
					model.setPrcCtrtTpCd(prcCtrtTpCd[i]);
				if (custNomiTrkrRjctDt[i] != null)
					model.setCustNomiTrkrRjctDt(custNomiTrkrRjctDt[i]);
				if (ctrtExpDt[i] != null)
					model.setCtrtExpDt(ctrtExpDt[i]);
				if (aproNo[i] != null)
					model.setAproNo(aproNo[i]);
				if (dispStsCd[i] != null)
					model.setDispStsCd(dispStsCd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (aproUsrId[i] != null)
					model.setAproUsrId(aproUsrId[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (ctrtCustSrepCd[i] != null)
					model.setCtrtCustSrepCd(ctrtCustSrepCd[i]);
				if (sel[i] != null)
					model.setSel(sel[i]);
				if (expnAudRsltRmk[i] != null)
					model.setExpnAudRsltRmk(expnAudRsltRmk[i]);					
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCntApprovalVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCntApprovalVO[]
	 */
	public SearchCntApprovalVO[] getSearchCntApprovalVOs(){
		SearchCntApprovalVO[] vos = (SearchCntApprovalVO[])models.toArray(new SearchCntApprovalVO[models.size()]);
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
		this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNomiTrkrFuelDivCd = this.custNomiTrkrFuelDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproOfcCd = this.aproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNomiTrkrSavDt = this.custNomiTrkrSavDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcCd = this.slsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustSrepNm = this.ctrtCustSrepNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlMqcDesc = this.fnlMqcDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjsTrkrFuelAmt = this.hjsTrkrFuelAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjsCustNomiTrkrAgmtNoYn = this.hjsCustNomiTrkrAgmtNoYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustSeq = this.ctrtCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodYard = this.dorNodYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstUsrId = this.rgstUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjsTrkrBzcAmt = this.hjsTrkrBzcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproNo2 = this.aproNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCtrtNo = this.prcCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaEdiCd = this.usaEdiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNomiTrkrAproDt = this.custNomiTrkrAproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNomiTrkrRqstDt = this.custNomiTrkrRqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNomiTrkrFuelAmt = this.custNomiTrkrFuelAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproHisDesc = this.aproHisDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustCntCd = this.ctrtCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtEffDt = this.ctrtEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toNodYard = this.toNodYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNomiTrkrBzcAmt = this.custNomiTrkrBzcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrNm = this.aproUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costDesc = this.costDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodYard = this.fmNodYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPkupRtnYdNm = this.mtyPkupRtnYdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNomiTrkrIndCd = this.custNomiTrkrIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNomiTrkrFuelRto = this.custNomiTrkrFuelRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjsTrkrAgmtNo = this.hjsTrkrAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstOfcCd = this.rgstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustNm = this.ctrtCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjsCustNomiTrkrAgmtNo = this.hjsCustNomiTrkrAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodCd = this.dorNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCtrtTpCd = this.prcCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNomiTrkrRjctDt = this.custNomiTrkrRjctDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtExpDt = this.ctrtExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproNo = this.aproNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispStsCd = this.dispStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrId = this.aproUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustSrepCd = this.ctrtCustSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sel = this.sel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
