/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FACCommVO.java
*@FileTitle : FACCommVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.02
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2010.07.02 박성진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.agt.agtaudit.facaudit.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박성진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FACCommVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FACCommVO> models = new ArrayList<FACCommVO>();
	
	/* Column Info */
	private String commProcStsCd = null;
	/* Column Info */
	private String facOfcCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String facBxRt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String facIfUsrId = null;
	/* Column Info */
	private String actIfCommAmt = null;
	/* Column Info */
	private String blNos = null;
	/* Column Info */
	private String dateOption = null;
	/* Column Info */
	private String oldActCommAmt = null;
	/* Column Info */
	private String actCommAmt = null;
	/* Column Info */
	private String slsOfcCd = null;
	/* Column Info */
	private String vslDepDt = null;
	/* Column Info */
	private String searchDtFr = null;
	/* Column Info */
	private String frtFwrdCntSeq = null;
	/* Column Info */
	private String agmtRtSeq = null;
	/* Column Info */
	private String facIfDt = null;
	/* Column Info */
	private String facSpclTeuRt = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String bkgTeuQty = null;
	/* Column Info */
	private String facIfDt1 = null;
	/* Column Info */
	private String ofcOption = null;
	/* Column Info */
	private String bkgRfTeuQty = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String facSeq = null;
	/* Column Info */
	private String facRmk = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String facFeuRt = null;
	/* Column Info */
	private String searchDtTo = null;
	/* Column Info */
	private String agmtCustSeq = null;
	/* Column Info */
	private String bkgSpclFeuQty = null;
	/* Column Info */
	private String agnCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgFeuQty = null;
	/* Column Info */
	private String bkgBxQty = null;
	/* Column Info */
	private String facTeuRt = null;
	/* Column Info */
	private String facDivCd = null;
	/* Column Info */
	private String commProcRsltRsn = null;
	/* Column Info */
	private String facRfTeuRt = null;
	/* Column Info */
	private String cntrCommAmt = null;
	/* Column Info */
	private String blCommAmt = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String facDivCd1 = null;
	/* Column Info */
	private String agmtCntCd = null;
	/* Column Info */
	private String ffCntCd = null;
	/* Column Info */
	private String facSpclFeuRt = null;
	/* Column Info */
	private String bkgRfFeuQty = null;
	/* Column Info */
	private String actPreCommAmt = null;
	/* Column Info */
	private String facRfFeuRt = null;
	/* Column Info */
	private String bkgSpclTeuQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FACCommVO() {}

	public FACCommVO(String ibflag, String pagerows, String commProcStsCd, String facOfcCd, String blNo, String facBxRt, String facIfUsrId, String actIfCommAmt, String blNos, String dateOption, String oldActCommAmt, String actCommAmt, String slsOfcCd, String vslDepDt, String searchDtFr, String frtFwrdCntSeq, String agmtRtSeq, String facIfDt, String facSpclTeuRt, String custLglEngNm, String vvd, String bkgNo, String bkgTeuQty, String ofcOption, String facIfDt1, String bkgRfTeuQty, String currCd, String facSeq, String facRmk, String bkgStsCd, String facFeuRt, String searchDtTo, String agmtCustSeq, String bkgSpclFeuQty, String agnCd, String bkgFeuQty, String bkgBxQty, String facTeuRt, String facDivCd, String commProcRsltRsn, String facRfTeuRt, String cntrCommAmt, String blCommAmt, String arOfcCd, String facDivCd1, String agmtCntCd, String ffCntCd, String facSpclFeuRt, String actPreCommAmt, String bkgRfFeuQty, String facRfFeuRt, String bkgSpclTeuQty) {
		this.commProcStsCd = commProcStsCd;
		this.facOfcCd = facOfcCd;
		this.blNo = blNo;
		this.facBxRt = facBxRt;
		this.pagerows = pagerows;
		this.facIfUsrId = facIfUsrId;
		this.actIfCommAmt = actIfCommAmt;
		this.blNos = blNos;
		this.dateOption = dateOption;
		this.oldActCommAmt = oldActCommAmt;
		this.actCommAmt = actCommAmt;
		this.slsOfcCd = slsOfcCd;
		this.vslDepDt = vslDepDt;
		this.searchDtFr = searchDtFr;
		this.frtFwrdCntSeq = frtFwrdCntSeq;
		this.agmtRtSeq = agmtRtSeq;
		this.facIfDt = facIfDt;
		this.facSpclTeuRt = facSpclTeuRt;
		this.custLglEngNm = custLglEngNm;
		this.vvd = vvd;
		this.bkgNo = bkgNo;
		this.bkgTeuQty = bkgTeuQty;
		this.facIfDt1 = facIfDt1;
		this.ofcOption = ofcOption;
		this.bkgRfTeuQty = bkgRfTeuQty;
		this.currCd = currCd;
		this.facSeq = facSeq;
		this.facRmk = facRmk;
		this.bkgStsCd = bkgStsCd;
		this.facFeuRt = facFeuRt;
		this.searchDtTo = searchDtTo;
		this.agmtCustSeq = agmtCustSeq;
		this.bkgSpclFeuQty = bkgSpclFeuQty;
		this.agnCd = agnCd;
		this.ibflag = ibflag;
		this.bkgFeuQty = bkgFeuQty;
		this.bkgBxQty = bkgBxQty;
		this.facTeuRt = facTeuRt;
		this.facDivCd = facDivCd;
		this.commProcRsltRsn = commProcRsltRsn;
		this.facRfTeuRt = facRfTeuRt;
		this.cntrCommAmt = cntrCommAmt;
		this.blCommAmt = blCommAmt;
		this.arOfcCd = arOfcCd;
		this.facDivCd1 = facDivCd1;
		this.agmtCntCd = agmtCntCd;
		this.ffCntCd = ffCntCd;
		this.facSpclFeuRt = facSpclFeuRt;
		this.bkgRfFeuQty = bkgRfFeuQty;
		this.actPreCommAmt = actPreCommAmt;
		this.facRfFeuRt = facRfFeuRt;
		this.bkgSpclTeuQty = bkgSpclTeuQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("comm_proc_sts_cd", getCommProcStsCd());
		this.hashColumns.put("fac_ofc_cd", getFacOfcCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("fac_bx_rt", getFacBxRt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fac_if_usr_id", getFacIfUsrId());
		this.hashColumns.put("act_if_comm_amt", getActIfCommAmt());
		this.hashColumns.put("bl_nos", getBlNos());
		this.hashColumns.put("date_option", getDateOption());
		this.hashColumns.put("old_act_comm_amt", getOldActCommAmt());
		this.hashColumns.put("act_comm_amt", getActCommAmt());
		this.hashColumns.put("sls_ofc_cd", getSlsOfcCd());
		this.hashColumns.put("vsl_dep_dt", getVslDepDt());
		this.hashColumns.put("search_dt_fr", getSearchDtFr());
		this.hashColumns.put("frt_fwrd_cnt_seq", getFrtFwrdCntSeq());
		this.hashColumns.put("agmt_rt_seq", getAgmtRtSeq());
		this.hashColumns.put("fac_if_dt", getFacIfDt());
		this.hashColumns.put("fac_spcl_teu_rt", getFacSpclTeuRt());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("bkg_teu_qty", getBkgTeuQty());
		this.hashColumns.put("fac_if_dt_1", getFacIfDt1());
		this.hashColumns.put("ofc_option", getOfcOption());
		this.hashColumns.put("bkg_rf_teu_qty", getBkgRfTeuQty());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("fac_seq", getFacSeq());
		this.hashColumns.put("fac_rmk", getFacRmk());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("fac_feu_rt", getFacFeuRt());
		this.hashColumns.put("search_dt_to", getSearchDtTo());
		this.hashColumns.put("agmt_cust_seq", getAgmtCustSeq());
		this.hashColumns.put("bkg_spcl_feu_qty", getBkgSpclFeuQty());
		this.hashColumns.put("agn_cd", getAgnCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_feu_qty", getBkgFeuQty());
		this.hashColumns.put("bkg_bx_qty", getBkgBxQty());
		this.hashColumns.put("fac_teu_rt", getFacTeuRt());
		this.hashColumns.put("fac_div_cd", getFacDivCd());
		this.hashColumns.put("comm_proc_rslt_rsn", getCommProcRsltRsn());
		this.hashColumns.put("fac_rf_teu_rt", getFacRfTeuRt());
		this.hashColumns.put("cntr_comm_amt", getCntrCommAmt());
		this.hashColumns.put("bl_comm_amt", getBlCommAmt());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("fac_div_cd_1", getFacDivCd1());
		this.hashColumns.put("agmt_cnt_cd", getAgmtCntCd());
		this.hashColumns.put("ff_cnt_cd", getFfCntCd());
		this.hashColumns.put("fac_spcl_feu_rt", getFacSpclFeuRt());
		this.hashColumns.put("bkg_rf_feu_qty", getBkgRfFeuQty());
		this.hashColumns.put("act_pre_comm_amt", getActPreCommAmt());
		this.hashColumns.put("fac_rf_feu_rt", getFacRfFeuRt());
		this.hashColumns.put("bkg_spcl_teu_qty", getBkgSpclTeuQty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("comm_proc_sts_cd", "commProcStsCd");
		this.hashFields.put("fac_ofc_cd", "facOfcCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("fac_bx_rt", "facBxRt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fac_if_usr_id", "facIfUsrId");
		this.hashFields.put("act_if_comm_amt", "actIfCommAmt");
		this.hashFields.put("bl_nos", "blNos");
		this.hashFields.put("date_option", "dateOption");
		this.hashFields.put("old_act_comm_amt", "oldActCommAmt");
		this.hashFields.put("act_comm_amt", "actCommAmt");
		this.hashFields.put("sls_ofc_cd", "slsOfcCd");
		this.hashFields.put("vsl_dep_dt", "vslDepDt");
		this.hashFields.put("search_dt_fr", "searchDtFr");
		this.hashFields.put("frt_fwrd_cnt_seq", "frtFwrdCntSeq");
		this.hashFields.put("agmt_rt_seq", "agmtRtSeq");
		this.hashFields.put("fac_if_dt", "facIfDt");
		this.hashFields.put("fac_spcl_teu_rt", "facSpclTeuRt");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("bkg_teu_qty", "bkgTeuQty");
		this.hashFields.put("fac_if_dt_1", "facIfDt1");
		this.hashFields.put("ofc_option", "ofcOption");
		this.hashFields.put("bkg_rf_teu_qty", "bkgRfTeuQty");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("fac_seq", "facSeq");
		this.hashFields.put("fac_rmk", "facRmk");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("fac_feu_rt", "facFeuRt");
		this.hashFields.put("search_dt_to", "searchDtTo");
		this.hashFields.put("agmt_cust_seq", "agmtCustSeq");
		this.hashFields.put("bkg_spcl_feu_qty", "bkgSpclFeuQty");
		this.hashFields.put("agn_cd", "agnCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_feu_qty", "bkgFeuQty");
		this.hashFields.put("bkg_bx_qty", "bkgBxQty");
		this.hashFields.put("fac_teu_rt", "facTeuRt");
		this.hashFields.put("fac_div_cd", "facDivCd");
		this.hashFields.put("comm_proc_rslt_rsn", "commProcRsltRsn");
		this.hashFields.put("fac_rf_teu_rt", "facRfTeuRt");
		this.hashFields.put("cntr_comm_amt", "cntrCommAmt");
		this.hashFields.put("bl_comm_amt", "blCommAmt");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("fac_div_cd_1", "facDivCd1");
		this.hashFields.put("agmt_cnt_cd", "agmtCntCd");
		this.hashFields.put("ff_cnt_cd", "ffCntCd");
		this.hashFields.put("fac_spcl_feu_rt", "facSpclFeuRt");
		this.hashFields.put("bkg_rf_feu_qty", "bkgRfFeuQty");
		this.hashFields.put("act_pre_comm_amt", "actPreCommAmt");
		this.hashFields.put("fac_rf_feu_rt", "facRfFeuRt");
		this.hashFields.put("bkg_spcl_teu_qty", "bkgSpclTeuQty");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return commProcStsCd
	 */
	public String getCommProcStsCd() {
		return this.commProcStsCd;
	}
	
	/**
	 * Column Info
	 * @return facOfcCd
	 */
	public String getFacOfcCd() {
		return this.facOfcCd;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return facBxRt
	 */
	public String getFacBxRt() {
		return this.facBxRt;
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
	 * @return facIfUsrId
	 */
	public String getFacIfUsrId() {
		return this.facIfUsrId;
	}
	
	/**
	 * Column Info
	 * @return actIfCommAmt
	 */
	public String getActIfCommAmt() {
		return this.actIfCommAmt;
	}
	
	/**
	 * Column Info
	 * @return blNos
	 */
	public String getBlNos() {
		return this.blNos;
	}
	
	/**
	 * Column Info
	 * @return dateOption
	 */
	public String getDateOption() {
		return this.dateOption;
	}
	
	/**
	 * Column Info
	 * @return oldActCommAmt
	 */
	public String getOldActCommAmt() {
		return this.oldActCommAmt;
	}
	
	/**
	 * Column Info
	 * @return actCommAmt
	 */
	public String getActCommAmt() {
		return this.actCommAmt;
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
	 * @return vslDepDt
	 */
	public String getVslDepDt() {
		return this.vslDepDt;
	}
	
	/**
	 * Column Info
	 * @return searchDtFr
	 */
	public String getSearchDtFr() {
		return this.searchDtFr;
	}
	
	/**
	 * Column Info
	 * @return frtFwrdCntSeq
	 */
	public String getFrtFwrdCntSeq() {
		return this.frtFwrdCntSeq;
	}
	
	/**
	 * Column Info
	 * @return agmtRtSeq
	 */
	public String getAgmtRtSeq() {
		return this.agmtRtSeq;
	}
	
	/**
	 * Column Info
	 * @return facIfDt
	 */
	public String getFacIfDt() {
		return this.facIfDt;
	}
	
	/**
	 * Column Info
	 * @return facSpclTeuRt
	 */
	public String getFacSpclTeuRt() {
		return this.facSpclTeuRt;
	}
	
	/**
	 * Column Info
	 * @return custLglEngNm
	 */
	public String getCustLglEngNm() {
		return this.custLglEngNm;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return bkgTeuQty
	 */
	public String getBkgTeuQty() {
		return this.bkgTeuQty;
	}
	
	/**
	 * Column Info
	 * @return facIfDt1
	 */
	public String getFacIfDt1() {
		return this.facIfDt1;
	}
	
	/**
	 * Column Info
	 * @return ofcOption
	 */
	public String getOfcOption() {
		return this.ofcOption;
	}
	
	/**
	 * Column Info
	 * @return bkgRfTeuQty
	 */
	public String getBkgRfTeuQty() {
		return this.bkgRfTeuQty;
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
	 * @return facSeq
	 */
	public String getFacSeq() {
		return this.facSeq;
	}
	
	/**
	 * Column Info
	 * @return facRmk
	 */
	public String getFacRmk() {
		return this.facRmk;
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
	 * @return facFeuRt
	 */
	public String getFacFeuRt() {
		return this.facFeuRt;
	}
	
	/**
	 * Column Info
	 * @return searchDtTo
	 */
	public String getSearchDtTo() {
		return this.searchDtTo;
	}
	
	/**
	 * Column Info
	 * @return agmtCustSeq
	 */
	public String getAgmtCustSeq() {
		return this.agmtCustSeq;
	}
	
	/**
	 * Column Info
	 * @return bkgSpclFeuQty
	 */
	public String getBkgSpclFeuQty() {
		return this.bkgSpclFeuQty;
	}
	
	/**
	 * Column Info
	 * @return agnCd
	 */
	public String getAgnCd() {
		return this.agnCd;
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
	 * @return bkgFeuQty
	 */
	public String getBkgFeuQty() {
		return this.bkgFeuQty;
	}
	
	/**
	 * Column Info
	 * @return bkgBxQty
	 */
	public String getBkgBxQty() {
		return this.bkgBxQty;
	}
	
	/**
	 * Column Info
	 * @return facTeuRt
	 */
	public String getFacTeuRt() {
		return this.facTeuRt;
	}
	
	/**
	 * Column Info
	 * @return facDivCd
	 */
	public String getFacDivCd() {
		return this.facDivCd;
	}
	
	/**
	 * Column Info
	 * @return commProcRsltRsn
	 */
	public String getCommProcRsltRsn() {
		return this.commProcRsltRsn;
	}
	
	/**
	 * Column Info
	 * @return facRfTeuRt
	 */
	public String getFacRfTeuRt() {
		return this.facRfTeuRt;
	}
	
	/**
	 * Column Info
	 * @return cntrCommAmt
	 */
	public String getCntrCommAmt() {
		return this.cntrCommAmt;
	}
	
	/**
	 * Column Info
	 * @return blCommAmt
	 */
	public String getBlCommAmt() {
		return this.blCommAmt;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
	}
	
	/**
	 * Column Info
	 * @return facDivCd1
	 */
	public String getFacDivCd1() {
		return this.facDivCd1;
	}
	
	/**
	 * Column Info
	 * @return agmtCntCd
	 */
	public String getAgmtCntCd() {
		return this.agmtCntCd;
	}
	
	/**
	 * Column Info
	 * @return ffCntCd
	 */
	public String getFfCntCd() {
		return this.ffCntCd;
	}
	
	/**
	 * Column Info
	 * @return facSpclFeuRt
	 */
	public String getFacSpclFeuRt() {
		return this.facSpclFeuRt;
	}
	
	/**
	 * Column Info
	 * @return bkgRfFeuQty
	 */
	public String getBkgRfFeuQty() {
		return this.bkgRfFeuQty;
	}
	
	/**
	 * Column Info
	 * @return actPreCommAmt
	 */
	public String getActPreCommAmt() {
		return this.actPreCommAmt;
	}
	
	/**
	 * Column Info
	 * @return facRfFeuRt
	 */
	public String getFacRfFeuRt() {
		return this.facRfFeuRt;
	}
	
	/**
	 * Column Info
	 * @return bkgSpclTeuQty
	 */
	public String getBkgSpclTeuQty() {
		return this.bkgSpclTeuQty;
	}
	

	/**
	 * Column Info
	 * @param commProcStsCd
	 */
	public void setCommProcStsCd(String commProcStsCd) {
		this.commProcStsCd = commProcStsCd;
	}
	
	/**
	 * Column Info
	 * @param facOfcCd
	 */
	public void setFacOfcCd(String facOfcCd) {
		this.facOfcCd = facOfcCd;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param facBxRt
	 */
	public void setFacBxRt(String facBxRt) {
		this.facBxRt = facBxRt;
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
	 * @param facIfUsrId
	 */
	public void setFacIfUsrId(String facIfUsrId) {
		this.facIfUsrId = facIfUsrId;
	}
	
	/**
	 * Column Info
	 * @param actIfCommAmt
	 */
	public void setActIfCommAmt(String actIfCommAmt) {
		this.actIfCommAmt = actIfCommAmt;
	}
	
	/**
	 * Column Info
	 * @param blNos
	 */
	public void setBlNos(String blNos) {
		this.blNos = blNos;
	}
	
	/**
	 * Column Info
	 * @param dateOption
	 */
	public void setDateOption(String dateOption) {
		this.dateOption = dateOption;
	}
	
	/**
	 * Column Info
	 * @param oldActCommAmt
	 */
	public void setOldActCommAmt(String oldActCommAmt) {
		this.oldActCommAmt = oldActCommAmt;
	}
	
	/**
	 * Column Info
	 * @param actCommAmt
	 */
	public void setActCommAmt(String actCommAmt) {
		this.actCommAmt = actCommAmt;
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
	 * @param vslDepDt
	 */
	public void setVslDepDt(String vslDepDt) {
		this.vslDepDt = vslDepDt;
	}
	
	/**
	 * Column Info
	 * @param searchDtFr
	 */
	public void setSearchDtFr(String searchDtFr) {
		this.searchDtFr = searchDtFr;
	}
	
	/**
	 * Column Info
	 * @param frtFwrdCntSeq
	 */
	public void setFrtFwrdCntSeq(String frtFwrdCntSeq) {
		this.frtFwrdCntSeq = frtFwrdCntSeq;
	}
	
	/**
	 * Column Info
	 * @param agmtRtSeq
	 */
	public void setAgmtRtSeq(String agmtRtSeq) {
		this.agmtRtSeq = agmtRtSeq;
	}
	
	/**
	 * Column Info
	 * @param facIfDt
	 */
	public void setFacIfDt(String facIfDt) {
		this.facIfDt = facIfDt;
	}
	
	/**
	 * Column Info
	 * @param facSpclTeuRt
	 */
	public void setFacSpclTeuRt(String facSpclTeuRt) {
		this.facSpclTeuRt = facSpclTeuRt;
	}
	
	/**
	 * Column Info
	 * @param custLglEngNm
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param bkgTeuQty
	 */
	public void setBkgTeuQty(String bkgTeuQty) {
		this.bkgTeuQty = bkgTeuQty;
	}
	
	/**
	 * Column Info
	 * @param facIfDt1
	 */
	public void setFacIfDt1(String facIfDt1) {
		this.facIfDt1 = facIfDt1;
	}
	
	/**
	 * Column Info
	 * @param ofcOption
	 */
	public void setOfcOption(String ofcOption) {
		this.ofcOption = ofcOption;
	}
	
	/**
	 * Column Info
	 * @param bkgRfTeuQty
	 */
	public void setBkgRfTeuQty(String bkgRfTeuQty) {
		this.bkgRfTeuQty = bkgRfTeuQty;
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
	 * @param facSeq
	 */
	public void setFacSeq(String facSeq) {
		this.facSeq = facSeq;
	}
	
	/**
	 * Column Info
	 * @param facRmk
	 */
	public void setFacRmk(String facRmk) {
		this.facRmk = facRmk;
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
	 * @param facFeuRt
	 */
	public void setFacFeuRt(String facFeuRt) {
		this.facFeuRt = facFeuRt;
	}
	
	/**
	 * Column Info
	 * @param searchDtTo
	 */
	public void setSearchDtTo(String searchDtTo) {
		this.searchDtTo = searchDtTo;
	}
	
	/**
	 * Column Info
	 * @param agmtCustSeq
	 */
	public void setAgmtCustSeq(String agmtCustSeq) {
		this.agmtCustSeq = agmtCustSeq;
	}
	
	/**
	 * Column Info
	 * @param bkgSpclFeuQty
	 */
	public void setBkgSpclFeuQty(String bkgSpclFeuQty) {
		this.bkgSpclFeuQty = bkgSpclFeuQty;
	}
	
	/**
	 * Column Info
	 * @param agnCd
	 */
	public void setAgnCd(String agnCd) {
		this.agnCd = agnCd;
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
	 * @param bkgFeuQty
	 */
	public void setBkgFeuQty(String bkgFeuQty) {
		this.bkgFeuQty = bkgFeuQty;
	}
	
	/**
	 * Column Info
	 * @param bkgBxQty
	 */
	public void setBkgBxQty(String bkgBxQty) {
		this.bkgBxQty = bkgBxQty;
	}
	
	/**
	 * Column Info
	 * @param facTeuRt
	 */
	public void setFacTeuRt(String facTeuRt) {
		this.facTeuRt = facTeuRt;
	}
	
	/**
	 * Column Info
	 * @param facDivCd
	 */
	public void setFacDivCd(String facDivCd) {
		this.facDivCd = facDivCd;
	}
	
	/**
	 * Column Info
	 * @param commProcRsltRsn
	 */
	public void setCommProcRsltRsn(String commProcRsltRsn) {
		this.commProcRsltRsn = commProcRsltRsn;
	}
	
	/**
	 * Column Info
	 * @param facRfTeuRt
	 */
	public void setFacRfTeuRt(String facRfTeuRt) {
		this.facRfTeuRt = facRfTeuRt;
	}
	
	/**
	 * Column Info
	 * @param cntrCommAmt
	 */
	public void setCntrCommAmt(String cntrCommAmt) {
		this.cntrCommAmt = cntrCommAmt;
	}
	
	/**
	 * Column Info
	 * @param blCommAmt
	 */
	public void setBlCommAmt(String blCommAmt) {
		this.blCommAmt = blCommAmt;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}
	
	/**
	 * Column Info
	 * @param facDivCd1
	 */
	public void setFacDivCd1(String facDivCd1) {
		this.facDivCd1 = facDivCd1;
	}
	
	/**
	 * Column Info
	 * @param agmtCntCd
	 */
	public void setAgmtCntCd(String agmtCntCd) {
		this.agmtCntCd = agmtCntCd;
	}
	
	/**
	 * Column Info
	 * @param ffCntCd
	 */
	public void setFfCntCd(String ffCntCd) {
		this.ffCntCd = ffCntCd;
	}
	
	/**
	 * Column Info
	 * @param facSpclFeuRt
	 */
	public void setFacSpclFeuRt(String facSpclFeuRt) {
		this.facSpclFeuRt = facSpclFeuRt;
	}
	
	/**
	 * Column Info
	 * @param bkgRfFeuQty
	 */
	public void setBkgRfFeuQty(String bkgRfFeuQty) {
		this.bkgRfFeuQty = bkgRfFeuQty;
	}
	
	/**
	 * Column Info
	 * @param actPreCommAmt
	 */
	public void setActPreCommAmt(String actPreCommAmt) {
		this.actPreCommAmt = actPreCommAmt;
	}
	
	/**
	 * Column Info
	 * @param facRfFeuRt
	 */
	public void setFacRfFeuRt(String facRfFeuRt) {
		this.facRfFeuRt = facRfFeuRt;
	}
	
	/**
	 * Column Info
	 * @param bkgSpclTeuQty
	 */
	public void setBkgSpclTeuQty(String bkgSpclTeuQty) {
		this.bkgSpclTeuQty = bkgSpclTeuQty;
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
		setCommProcStsCd(JSPUtil.getParameter(request, prefix + "comm_proc_sts_cd", ""));
		setFacOfcCd(JSPUtil.getParameter(request, prefix + "fac_ofc_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setFacBxRt(JSPUtil.getParameter(request, prefix + "fac_bx_rt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFacIfUsrId(JSPUtil.getParameter(request, prefix + "fac_if_usr_id", ""));
		setActIfCommAmt(JSPUtil.getParameter(request, prefix + "act_if_comm_amt", ""));
		setBlNos(JSPUtil.getParameter(request, prefix + "bl_nos", ""));
		setDateOption(JSPUtil.getParameter(request, prefix + "date_option", ""));
		setOldActCommAmt(JSPUtil.getParameter(request, prefix + "old_act_comm_amt", ""));
		setActCommAmt(JSPUtil.getParameter(request, prefix + "act_comm_amt", ""));
		setSlsOfcCd(JSPUtil.getParameter(request, prefix + "sls_ofc_cd", ""));
		setVslDepDt(JSPUtil.getParameter(request, prefix + "vsl_dep_dt", ""));
		setSearchDtFr(JSPUtil.getParameter(request, prefix + "search_dt_fr", ""));
		setFrtFwrdCntSeq(JSPUtil.getParameter(request, prefix + "frt_fwrd_cnt_seq", ""));
		setAgmtRtSeq(JSPUtil.getParameter(request, prefix + "agmt_rt_seq", ""));
		setFacIfDt(JSPUtil.getParameter(request, prefix + "fac_if_dt", ""));
		setFacSpclTeuRt(JSPUtil.getParameter(request, prefix + "fac_spcl_teu_rt", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setBkgTeuQty(JSPUtil.getParameter(request, prefix + "bkg_teu_qty", ""));
		setFacIfDt1(JSPUtil.getParameter(request, prefix + "fac_if_dt_1", ""));
		setOfcOption(JSPUtil.getParameter(request, prefix + "ofc_option", ""));
		setBkgRfTeuQty(JSPUtil.getParameter(request, prefix + "bkg_rf_teu_qty", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setFacSeq(JSPUtil.getParameter(request, prefix + "fac_seq", ""));
		setFacRmk(JSPUtil.getParameter(request, prefix + "fac_rmk", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setFacFeuRt(JSPUtil.getParameter(request, prefix + "fac_feu_rt", ""));
		setSearchDtTo(JSPUtil.getParameter(request, prefix + "search_dt_to", ""));
		setAgmtCustSeq(JSPUtil.getParameter(request, prefix + "agmt_cust_seq", ""));
		setBkgSpclFeuQty(JSPUtil.getParameter(request, prefix + "bkg_spcl_feu_qty", ""));
		setAgnCd(JSPUtil.getParameter(request, prefix + "agn_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgFeuQty(JSPUtil.getParameter(request, prefix + "bkg_feu_qty", ""));
		setBkgBxQty(JSPUtil.getParameter(request, prefix + "bkg_bx_qty", ""));
		setFacTeuRt(JSPUtil.getParameter(request, prefix + "fac_teu_rt", ""));
		setFacDivCd(JSPUtil.getParameter(request, prefix + "fac_div_cd", ""));
		setCommProcRsltRsn(JSPUtil.getParameter(request, prefix + "comm_proc_rslt_rsn", ""));
		setFacRfTeuRt(JSPUtil.getParameter(request, prefix + "fac_rf_teu_rt", ""));
		setCntrCommAmt(JSPUtil.getParameter(request, prefix + "cntr_comm_amt", ""));
		setBlCommAmt(JSPUtil.getParameter(request, prefix + "bl_comm_amt", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setFacDivCd1(JSPUtil.getParameter(request, prefix + "fac_div_cd_1", ""));
		setAgmtCntCd(JSPUtil.getParameter(request, prefix + "agmt_cnt_cd", ""));
		setFfCntCd(JSPUtil.getParameter(request, prefix + "ff_cnt_cd", ""));
		setFacSpclFeuRt(JSPUtil.getParameter(request, prefix + "fac_spcl_feu_rt", ""));
		setBkgRfFeuQty(JSPUtil.getParameter(request, prefix + "bkg_rf_feu_qty", ""));
		setActPreCommAmt(JSPUtil.getParameter(request, prefix + "act_pre_comm_amt", ""));
		setFacRfFeuRt(JSPUtil.getParameter(request, prefix + "fac_rf_feu_rt", ""));
		setBkgSpclTeuQty(JSPUtil.getParameter(request, prefix + "bkg_spcl_teu_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FACCommVO[]
	 */
	public FACCommVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FACCommVO[]
	 */
	public FACCommVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FACCommVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] commProcStsCd = (JSPUtil.getParameter(request, prefix	+ "comm_proc_sts_cd", length));
			String[] facOfcCd = (JSPUtil.getParameter(request, prefix	+ "fac_ofc_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] facBxRt = (JSPUtil.getParameter(request, prefix	+ "fac_bx_rt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] facIfUsrId = (JSPUtil.getParameter(request, prefix	+ "fac_if_usr_id", length));
			String[] actIfCommAmt = (JSPUtil.getParameter(request, prefix	+ "act_if_comm_amt", length));
			String[] blNos = (JSPUtil.getParameter(request, prefix	+ "bl_nos", length));
			String[] dateOption = (JSPUtil.getParameter(request, prefix	+ "date_option", length));
			String[] oldActCommAmt = (JSPUtil.getParameter(request, prefix	+ "old_act_comm_amt", length));
			String[] actCommAmt = (JSPUtil.getParameter(request, prefix	+ "act_comm_amt", length));
			String[] slsOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_cd", length));
			String[] vslDepDt = (JSPUtil.getParameter(request, prefix	+ "vsl_dep_dt", length));
			String[] searchDtFr = (JSPUtil.getParameter(request, prefix	+ "search_dt_fr", length));
			String[] frtFwrdCntSeq = (JSPUtil.getParameter(request, prefix	+ "frt_fwrd_cnt_seq", length));
			String[] agmtRtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_rt_seq", length));
			String[] facIfDt = (JSPUtil.getParameter(request, prefix	+ "fac_if_dt", length));
			String[] facSpclTeuRt = (JSPUtil.getParameter(request, prefix	+ "fac_spcl_teu_rt", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] bkgTeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_teu_qty", length));
			String[] facIfDt1 = (JSPUtil.getParameter(request, prefix	+ "fac_if_dt_1", length));
			String[] ofcOption = (JSPUtil.getParameter(request, prefix	+ "ofc_option", length));
			String[] bkgRfTeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_rf_teu_qty", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] facSeq = (JSPUtil.getParameter(request, prefix	+ "fac_seq", length));
			String[] facRmk = (JSPUtil.getParameter(request, prefix	+ "fac_rmk", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] facFeuRt = (JSPUtil.getParameter(request, prefix	+ "fac_feu_rt", length));
			String[] searchDtTo = (JSPUtil.getParameter(request, prefix	+ "search_dt_to", length));
			String[] agmtCustSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_cust_seq", length));
			String[] bkgSpclFeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_spcl_feu_qty", length));
			String[] agnCd = (JSPUtil.getParameter(request, prefix	+ "agn_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgFeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_feu_qty", length));
			String[] bkgBxQty = (JSPUtil.getParameter(request, prefix	+ "bkg_bx_qty", length));
			String[] facTeuRt = (JSPUtil.getParameter(request, prefix	+ "fac_teu_rt", length));
			String[] facDivCd = (JSPUtil.getParameter(request, prefix	+ "fac_div_cd", length));
			String[] commProcRsltRsn = (JSPUtil.getParameter(request, prefix	+ "comm_proc_rslt_rsn", length));
			String[] facRfTeuRt = (JSPUtil.getParameter(request, prefix	+ "fac_rf_teu_rt", length));
			String[] cntrCommAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_comm_amt", length));
			String[] blCommAmt = (JSPUtil.getParameter(request, prefix	+ "bl_comm_amt", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] facDivCd1 = (JSPUtil.getParameter(request, prefix	+ "fac_div_cd_1", length));
			String[] agmtCntCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cnt_cd", length));
			String[] ffCntCd = (JSPUtil.getParameter(request, prefix	+ "ff_cnt_cd", length));
			String[] facSpclFeuRt = (JSPUtil.getParameter(request, prefix	+ "fac_spcl_feu_rt", length));
			String[] bkgRfFeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_rf_feu_qty", length));
			String[] actPreCommAmt = (JSPUtil.getParameter(request, prefix	+ "act_pre_comm_amt", length));
			String[] facRfFeuRt = (JSPUtil.getParameter(request, prefix	+ "fac_rf_feu_rt", length));
			String[] bkgSpclTeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_spcl_teu_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new FACCommVO();
				if (commProcStsCd[i] != null)
					model.setCommProcStsCd(commProcStsCd[i]);
				if (facOfcCd[i] != null)
					model.setFacOfcCd(facOfcCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (facBxRt[i] != null)
					model.setFacBxRt(facBxRt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (facIfUsrId[i] != null)
					model.setFacIfUsrId(facIfUsrId[i]);
				if (actIfCommAmt[i] != null)
					model.setActIfCommAmt(actIfCommAmt[i]);
				if (blNos[i] != null)
					model.setBlNos(blNos[i]);
				if (dateOption[i] != null)
					model.setDateOption(dateOption[i]);
				if (oldActCommAmt[i] != null)
					model.setOldActCommAmt(oldActCommAmt[i]);
				if (actCommAmt[i] != null)
					model.setActCommAmt(actCommAmt[i]);
				if (slsOfcCd[i] != null)
					model.setSlsOfcCd(slsOfcCd[i]);
				if (vslDepDt[i] != null)
					model.setVslDepDt(vslDepDt[i]);
				if (searchDtFr[i] != null)
					model.setSearchDtFr(searchDtFr[i]);
				if (frtFwrdCntSeq[i] != null)
					model.setFrtFwrdCntSeq(frtFwrdCntSeq[i]);
				if (agmtRtSeq[i] != null)
					model.setAgmtRtSeq(agmtRtSeq[i]);
				if (facIfDt[i] != null)
					model.setFacIfDt(facIfDt[i]);
				if (facSpclTeuRt[i] != null)
					model.setFacSpclTeuRt(facSpclTeuRt[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (bkgTeuQty[i] != null)
					model.setBkgTeuQty(bkgTeuQty[i]);
				if (facIfDt1[i] != null)
					model.setFacIfDt1(facIfDt1[i]);
				if (ofcOption[i] != null)
					model.setOfcOption(ofcOption[i]);
				if (bkgRfTeuQty[i] != null)
					model.setBkgRfTeuQty(bkgRfTeuQty[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (facSeq[i] != null)
					model.setFacSeq(facSeq[i]);
				if (facRmk[i] != null)
					model.setFacRmk(facRmk[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (facFeuRt[i] != null)
					model.setFacFeuRt(facFeuRt[i]);
				if (searchDtTo[i] != null)
					model.setSearchDtTo(searchDtTo[i]);
				if (agmtCustSeq[i] != null)
					model.setAgmtCustSeq(agmtCustSeq[i]);
				if (bkgSpclFeuQty[i] != null)
					model.setBkgSpclFeuQty(bkgSpclFeuQty[i]);
				if (agnCd[i] != null)
					model.setAgnCd(agnCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgFeuQty[i] != null)
					model.setBkgFeuQty(bkgFeuQty[i]);
				if (bkgBxQty[i] != null)
					model.setBkgBxQty(bkgBxQty[i]);
				if (facTeuRt[i] != null)
					model.setFacTeuRt(facTeuRt[i]);
				if (facDivCd[i] != null)
					model.setFacDivCd(facDivCd[i]);
				if (commProcRsltRsn[i] != null)
					model.setCommProcRsltRsn(commProcRsltRsn[i]);
				if (facRfTeuRt[i] != null)
					model.setFacRfTeuRt(facRfTeuRt[i]);
				if (cntrCommAmt[i] != null)
					model.setCntrCommAmt(cntrCommAmt[i]);
				if (blCommAmt[i] != null)
					model.setBlCommAmt(blCommAmt[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (facDivCd1[i] != null)
					model.setFacDivCd1(facDivCd1[i]);
				if (agmtCntCd[i] != null)
					model.setAgmtCntCd(agmtCntCd[i]);
				if (ffCntCd[i] != null)
					model.setFfCntCd(ffCntCd[i]);
				if (facSpclFeuRt[i] != null)
					model.setFacSpclFeuRt(facSpclFeuRt[i]);
				if (bkgRfFeuQty[i] != null)
					model.setBkgRfFeuQty(bkgRfFeuQty[i]);
				if (actPreCommAmt[i] != null)
					model.setActPreCommAmt(actPreCommAmt[i]);
				if (facRfFeuRt[i] != null)
					model.setFacRfFeuRt(facRfFeuRt[i]);
				if (bkgSpclTeuQty[i] != null)
					model.setBkgSpclTeuQty(bkgSpclTeuQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFACCommVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FACCommVO[]
	 */
	public FACCommVO[] getFACCommVOs(){
		FACCommVO[] vos = (FACCommVO[])models.toArray(new FACCommVO[models.size()]);
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
		this.commProcStsCd = this.commProcStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facOfcCd = this.facOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facBxRt = this.facBxRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facIfUsrId = this.facIfUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actIfCommAmt = this.actIfCommAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNos = this.blNos .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateOption = this.dateOption .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldActCommAmt = this.oldActCommAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCommAmt = this.actCommAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcCd = this.slsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDepDt = this.vslDepDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchDtFr = this.searchDtFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtFwrdCntSeq = this.frtFwrdCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtRtSeq = this.agmtRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facIfDt = this.facIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facSpclTeuRt = this.facSpclTeuRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTeuQty = this.bkgTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facIfDt1 = this.facIfDt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcOption = this.ofcOption .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRfTeuQty = this.bkgRfTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facSeq = this.facSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facRmk = this.facRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facFeuRt = this.facFeuRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchDtTo = this.searchDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCustSeq = this.agmtCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSpclFeuQty = this.bkgSpclFeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCd = this.agnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFeuQty = this.bkgFeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgBxQty = this.bkgBxQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facTeuRt = this.facTeuRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facDivCd = this.facDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commProcRsltRsn = this.commProcRsltRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facRfTeuRt = this.facRfTeuRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCommAmt = this.cntrCommAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCommAmt = this.blCommAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facDivCd1 = this.facDivCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCntCd = this.agmtCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCntCd = this.ffCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facSpclFeuRt = this.facSpclFeuRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRfFeuQty = this.bkgRfFeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actPreCommAmt = this.actPreCommAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facRfFeuRt = this.facRfFeuRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSpclTeuQty = this.bkgSpclTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
