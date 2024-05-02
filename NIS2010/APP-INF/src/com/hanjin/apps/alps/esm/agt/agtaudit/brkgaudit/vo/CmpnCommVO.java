/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CmpnCommVO.java
*@FileTitle : CmpnCommVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.28
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.04.28 박성진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.vo;

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
 * @author 박성진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CmpnCommVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CmpnCommVO> models = new ArrayList<CmpnCommVO>();
	
	/* Column Info */
	private String vndrCntCd = null;
	/* Column Info */
	private String commProcStsCd = null;
	/* Column Info */
	private String actCommAble = null;
	/* Column Info */
	private String cmpnTeuRt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String stsCd = null;
	/* Column Info */
	private String actIfCommAmt = null;
	/* Column Info */
	private String blNos = null;
	/* Column Info */
	private String dateOption = null;
	/* Column Info */
	private String actCommAmt = null;
	/* Column Info */
	private String bkgRfQty = null;
	/* Column Info */
	private String vslDepDt = null;
	/* Column Info */
	private String searchDtFr = null;
	/* Column Info */
	private String frtFwrdSeq = null;
	/* Column Info */
	private String vndrCntSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String frtFwrdCntSeq = null;
	/* Column Info */
	private String agmtRtSeq = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cmpnBkgRt = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String bkgTeuQty = null;
	/* Column Info */
	private String bkgRfTeuQty = null;
	/* Column Info */
	private String cmpnSeq = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String searchDtTo = null;
	/* Column Info */
	private String agmtCustSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String cmpnRfTeuRt = null;
	/* Column Info */
	private String cmpnIfDt = null;
	/* Column Info */
	private String bkgFeuQty = null;
	/* Column Info */
	private String fmcNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cmpnBxRt = null;
	/* Column Info */
	private String bkgBxQty = null;
	/* Column Info */
	private String cmpnRfRt = null;
	/* Column Info */
	private String commProcRsltRsn = null;
	/* Column Info */
	private String cmpnRfFeuRt = null;
	/* Column Info */
	private String cntrCommAmt = null;
	/* Column Info */
	private String cmpnFeuRt = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String agmtCntCd = null;
	/* Column Info */
	private String ffCntCd = null;
	/* Column Info */
	private String actPreCommAmt = null;
	/* Column Info */
	private String bkgRfFeuQty = null;
	/* Column Info */
	private String frtFwrdCntCd = null;
	/* Column Info */
	private String payChk = null;
	/* Column Info */
	private String multiVvd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CmpnCommVO() {}

	public CmpnCommVO(String ibflag, String pagerows, String vndrCntCd, String cmpnSeq, String bkgStsCd, String commProcStsCd, String searchDtTo, String agmtCustSeq, String creDt, String actCommAble, String cmpnTeuRt, String blNo, String stsCd, String fmcNo, String bkgFeuQty, String blNos, String actIfCommAmt, String cmpnIfDt, String dateOption, String actCommAmt, String bkgRfQty, String bkgBxQty, String vslDepDt, String searchDtFr, String frtFwrdSeq, String vndrCntSeq, String updUsrId, String cmpnRfRt, String commProcRsltRsn, String frtFwrdCntSeq, String cmpnFeuRt, String agmtRtSeq, String cntrCommAmt, String custLglEngNm, String vvd, String bkgNo, String agmtCntCd, String cmpnBxRt, String vndrSeq, String bkgTeuQty, String ffCntCd, String cmpnBkgRt, String actPreCommAmt, String frtFwrdCntCd, String ofcCd, String bkgRfTeuQty, String cmpnRfTeuRt, String bkgRfFeuQty, String cmpnRfFeuRt, String payChk, String multiVvd) {
		this.vndrCntCd = vndrCntCd;
		this.commProcStsCd = commProcStsCd;
		this.actCommAble = actCommAble;
		this.cmpnTeuRt = cmpnTeuRt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.stsCd = stsCd;
		this.actIfCommAmt = actIfCommAmt;
		this.blNos = blNos;
		this.dateOption = dateOption;
		this.actCommAmt = actCommAmt;
		this.bkgRfQty = bkgRfQty;
		this.vslDepDt = vslDepDt;
		this.searchDtFr = searchDtFr;
		this.frtFwrdSeq = frtFwrdSeq;
		this.vndrCntSeq = vndrCntSeq;
		this.updUsrId = updUsrId;
		this.frtFwrdCntSeq = frtFwrdCntSeq;
		this.agmtRtSeq = agmtRtSeq;
		this.custLglEngNm = custLglEngNm;
		this.vvd = vvd;
		this.bkgNo = bkgNo;
		this.cmpnBkgRt = cmpnBkgRt;
		this.vndrSeq = vndrSeq;
		this.bkgTeuQty = bkgTeuQty;
		this.bkgRfTeuQty = bkgRfTeuQty;
		this.cmpnSeq = cmpnSeq;
		this.bkgStsCd = bkgStsCd;
		this.searchDtTo = searchDtTo;
		this.agmtCustSeq = agmtCustSeq;
		this.creDt = creDt;
		this.cmpnRfTeuRt = cmpnRfTeuRt;
		this.cmpnIfDt = cmpnIfDt;
		this.bkgFeuQty = bkgFeuQty;
		this.fmcNo = fmcNo;
		this.ibflag = ibflag;
		this.cmpnBxRt = cmpnBxRt;
		this.bkgBxQty = bkgBxQty;
		this.cmpnRfRt = cmpnRfRt;
		this.commProcRsltRsn = commProcRsltRsn;
		this.cmpnRfFeuRt = cmpnRfFeuRt;
		this.cntrCommAmt = cntrCommAmt;
		this.cmpnFeuRt = cmpnFeuRt;
		this.ofcCd = ofcCd;
		this.agmtCntCd = agmtCntCd;
		this.ffCntCd = ffCntCd;
		this.actPreCommAmt = actPreCommAmt;
		this.bkgRfFeuQty = bkgRfFeuQty;
		this.frtFwrdCntCd = frtFwrdCntCd;
		this.payChk = payChk;
		this.multiVvd = multiVvd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vndr_cnt_cd", getVndrCntCd());
		this.hashColumns.put("comm_proc_sts_cd", getCommProcStsCd());
		this.hashColumns.put("act_comm_able", getActCommAble());
		this.hashColumns.put("cmpn_teu_rt", getCmpnTeuRt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sts_cd", getStsCd());
		this.hashColumns.put("act_if_comm_amt", getActIfCommAmt());
		this.hashColumns.put("bl_nos", getBlNos());
		this.hashColumns.put("date_option", getDateOption());
		this.hashColumns.put("act_comm_amt", getActCommAmt());
		this.hashColumns.put("bkg_rf_qty", getBkgRfQty());
		this.hashColumns.put("vsl_dep_dt", getVslDepDt());
		this.hashColumns.put("search_dt_fr", getSearchDtFr());
		this.hashColumns.put("frt_fwrd_seq", getFrtFwrdSeq());
		this.hashColumns.put("vndr_cnt_seq", getVndrCntSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("frt_fwrd_cnt_seq", getFrtFwrdCntSeq());
		this.hashColumns.put("agmt_rt_seq", getAgmtRtSeq());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cmpn_bkg_rt", getCmpnBkgRt());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("bkg_teu_qty", getBkgTeuQty());
		this.hashColumns.put("bkg_rf_teu_qty", getBkgRfTeuQty());
		this.hashColumns.put("cmpn_seq", getCmpnSeq());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("search_dt_to", getSearchDtTo());
		this.hashColumns.put("agmt_cust_seq", getAgmtCustSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cmpn_rf_teu_rt", getCmpnRfTeuRt());
		this.hashColumns.put("cmpn_if_dt", getCmpnIfDt());
		this.hashColumns.put("bkg_feu_qty", getBkgFeuQty());
		this.hashColumns.put("fmc_no", getFmcNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cmpn_bx_rt", getCmpnBxRt());
		this.hashColumns.put("bkg_bx_qty", getBkgBxQty());
		this.hashColumns.put("cmpn_rf_rt", getCmpnRfRt());
		this.hashColumns.put("comm_proc_rslt_rsn", getCommProcRsltRsn());
		this.hashColumns.put("cmpn_rf_feu_rt", getCmpnRfFeuRt());
		this.hashColumns.put("cntr_comm_amt", getCntrCommAmt());
		this.hashColumns.put("cmpn_feu_rt", getCmpnFeuRt());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("agmt_cnt_cd", getAgmtCntCd());
		this.hashColumns.put("ff_cnt_cd", getFfCntCd());
		this.hashColumns.put("act_pre_comm_amt", getActPreCommAmt());
		this.hashColumns.put("bkg_rf_feu_qty", getBkgRfFeuQty());
		this.hashColumns.put("frt_fwrd_cnt_cd", getFrtFwrdCntCd());
		this.hashColumns.put("pay_chk", getPayChk());
		this.hashColumns.put("multi_vvd", getMultiVvd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vndr_cnt_cd", "vndrCntCd");
		this.hashFields.put("comm_proc_sts_cd", "commProcStsCd");
		this.hashFields.put("act_comm_able", "actCommAble");
		this.hashFields.put("cmpn_teu_rt", "cmpnTeuRt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sts_cd", "stsCd");
		this.hashFields.put("act_if_comm_amt", "actIfCommAmt");
		this.hashFields.put("bl_nos", "blNos");
		this.hashFields.put("date_option", "dateOption");
		this.hashFields.put("act_comm_amt", "actCommAmt");
		this.hashFields.put("bkg_rf_qty", "bkgRfQty");
		this.hashFields.put("vsl_dep_dt", "vslDepDt");
		this.hashFields.put("search_dt_fr", "searchDtFr");
		this.hashFields.put("frt_fwrd_seq", "frtFwrdSeq");
		this.hashFields.put("vndr_cnt_seq", "vndrCntSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("frt_fwrd_cnt_seq", "frtFwrdCntSeq");
		this.hashFields.put("agmt_rt_seq", "agmtRtSeq");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cmpn_bkg_rt", "cmpnBkgRt");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("bkg_teu_qty", "bkgTeuQty");
		this.hashFields.put("bkg_rf_teu_qty", "bkgRfTeuQty");
		this.hashFields.put("cmpn_seq", "cmpnSeq");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("search_dt_to", "searchDtTo");
		this.hashFields.put("agmt_cust_seq", "agmtCustSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cmpn_rf_teu_rt", "cmpnRfTeuRt");
		this.hashFields.put("cmpn_if_dt", "cmpnIfDt");
		this.hashFields.put("bkg_feu_qty", "bkgFeuQty");
		this.hashFields.put("fmc_no", "fmcNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cmpn_bx_rt", "cmpnBxRt");
		this.hashFields.put("bkg_bx_qty", "bkgBxQty");
		this.hashFields.put("cmpn_rf_rt", "cmpnRfRt");
		this.hashFields.put("comm_proc_rslt_rsn", "commProcRsltRsn");
		this.hashFields.put("cmpn_rf_feu_rt", "cmpnRfFeuRt");
		this.hashFields.put("cntr_comm_amt", "cntrCommAmt");
		this.hashFields.put("cmpn_feu_rt", "cmpnFeuRt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("agmt_cnt_cd", "agmtCntCd");
		this.hashFields.put("ff_cnt_cd", "ffCntCd");
		this.hashFields.put("act_pre_comm_amt", "actPreCommAmt");
		this.hashFields.put("bkg_rf_feu_qty", "bkgRfFeuQty");
		this.hashFields.put("frt_fwrd_cnt_cd", "frtFwrdCntCd");
		this.hashFields.put("pay_chk", "payChk");
		this.hashFields.put("multi_vvd", "multiVvd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vndrCntCd
	 */
	public String getVndrCntCd() {
		return this.vndrCntCd;
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
	 * @return actCommAble
	 */
	public String getActCommAble() {
		return this.actCommAble;
	}
	
	/**
	 * Column Info
	 * @return cmpnTeuRt
	 */
	public String getCmpnTeuRt() {
		return this.cmpnTeuRt;
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
	 * @return stsCd
	 */
	public String getStsCd() {
		return this.stsCd;
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
	 * @return actCommAmt
	 */
	public String getActCommAmt() {
		return this.actCommAmt;
	}
	
	/**
	 * Column Info
	 * @return bkgRfQty
	 */
	public String getBkgRfQty() {
		return this.bkgRfQty;
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
	 * @return frtFwrdSeq
	 */
	public String getFrtFwrdSeq() {
		return this.frtFwrdSeq;
	}
	
	/**
	 * Column Info
	 * @return vndrCntSeq
	 */
	public String getVndrCntSeq() {
		return this.vndrCntSeq;
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
	 * @return cmpnBkgRt
	 */
	public String getCmpnBkgRt() {
		return this.cmpnBkgRt;
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
	 * @return bkgTeuQty
	 */
	public String getBkgTeuQty() {
		return this.bkgTeuQty;
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
	 * @return cmpnSeq
	 */
	public String getCmpnSeq() {
		return this.cmpnSeq;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return cmpnRfTeuRt
	 */
	public String getCmpnRfTeuRt() {
		return this.cmpnRfTeuRt;
	}
	
	/**
	 * Column Info
	 * @return cmpnIfDt
	 */
	public String getCmpnIfDt() {
		return this.cmpnIfDt;
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
	 * @return fmcNo
	 */
	public String getFmcNo() {
		return this.fmcNo;
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
	 * @return cmpnBxRt
	 */
	public String getCmpnBxRt() {
		return this.cmpnBxRt;
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
	 * @return cmpnRfRt
	 */
	public String getCmpnRfRt() {
		return this.cmpnRfRt;
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
	 * @return cmpnRfFeuRt
	 */
	public String getCmpnRfFeuRt() {
		return this.cmpnRfFeuRt;
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
	 * @return cmpnFeuRt
	 */
	public String getCmpnFeuRt() {
		return this.cmpnFeuRt;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return actPreCommAmt
	 */
	public String getActPreCommAmt() {
		return this.actPreCommAmt;
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
	 * @return frtFwrdCntCd
	 */
	public String getFrtFwrdCntCd() {
		return this.frtFwrdCntCd;
	}
	
	/**
	 * Column Info
	 * @return payChk
	 */
	public String getPayChk() {
		return this.payChk;
	}	

	/**
	 * Column Info
	 * @return multiVvd
	 */
	public String getMultiVvd() {
		return this.multiVvd;
	}	
	
	/**
	 * Column Info
	 * @param vndrCntCd
	 */
	public void setVndrCntCd(String vndrCntCd) {
		this.vndrCntCd = vndrCntCd;
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
	 * @param actCommAble
	 */
	public void setActCommAble(String actCommAble) {
		this.actCommAble = actCommAble;
	}
	
	/**
	 * Column Info
	 * @param cmpnTeuRt
	 */
	public void setCmpnTeuRt(String cmpnTeuRt) {
		this.cmpnTeuRt = cmpnTeuRt;
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
	 * @param stsCd
	 */
	public void setStsCd(String stsCd) {
		this.stsCd = stsCd;
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
	 * @param actCommAmt
	 */
	public void setActCommAmt(String actCommAmt) {
		this.actCommAmt = actCommAmt;
	}
	
	/**
	 * Column Info
	 * @param bkgRfQty
	 */
	public void setBkgRfQty(String bkgRfQty) {
		this.bkgRfQty = bkgRfQty;
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
	 * @param frtFwrdSeq
	 */
	public void setFrtFwrdSeq(String frtFwrdSeq) {
		this.frtFwrdSeq = frtFwrdSeq;
	}
	
	/**
	 * Column Info
	 * @param vndrCntSeq
	 */
	public void setVndrCntSeq(String vndrCntSeq) {
		this.vndrCntSeq = vndrCntSeq;
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
	 * @param cmpnBkgRt
	 */
	public void setCmpnBkgRt(String cmpnBkgRt) {
		this.cmpnBkgRt = cmpnBkgRt;
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
	 * @param bkgTeuQty
	 */
	public void setBkgTeuQty(String bkgTeuQty) {
		this.bkgTeuQty = bkgTeuQty;
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
	 * @param cmpnSeq
	 */
	public void setCmpnSeq(String cmpnSeq) {
		this.cmpnSeq = cmpnSeq;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param cmpnRfTeuRt
	 */
	public void setCmpnRfTeuRt(String cmpnRfTeuRt) {
		this.cmpnRfTeuRt = cmpnRfTeuRt;
	}
	
	/**
	 * Column Info
	 * @param cmpnIfDt
	 */
	public void setCmpnIfDt(String cmpnIfDt) {
		this.cmpnIfDt = cmpnIfDt;
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
	 * @param fmcNo
	 */
	public void setFmcNo(String fmcNo) {
		this.fmcNo = fmcNo;
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
	 * @param cmpnBxRt
	 */
	public void setCmpnBxRt(String cmpnBxRt) {
		this.cmpnBxRt = cmpnBxRt;
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
	 * @param cmpnRfRt
	 */
	public void setCmpnRfRt(String cmpnRfRt) {
		this.cmpnRfRt = cmpnRfRt;
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
	 * @param cmpnRfFeuRt
	 */
	public void setCmpnRfFeuRt(String cmpnRfFeuRt) {
		this.cmpnRfFeuRt = cmpnRfFeuRt;
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
	 * @param cmpnFeuRt
	 */
	public void setCmpnFeuRt(String cmpnFeuRt) {
		this.cmpnFeuRt = cmpnFeuRt;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param actPreCommAmt
	 */
	public void setActPreCommAmt(String actPreCommAmt) {
		this.actPreCommAmt = actPreCommAmt;
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
	 * @param frtFwrdCntCd
	 */
	public void setFrtFwrdCntCd(String frtFwrdCntCd) {
		this.frtFwrdCntCd = frtFwrdCntCd;
	}
	
	/**
	 * Column Info
	 * @param payChk
	 */
	public void setPayChk(String payChk) {
		this.payChk = payChk;
	}

	/**
	 * Column Info
	 * @param multiVvd
	 */
	public void setMultiVvd(String multiVvd) {
		this.multiVvd = multiVvd;
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
		setVndrCntCd(JSPUtil.getParameter(request, prefix + "vndr_cnt_cd", ""));
		setCommProcStsCd(JSPUtil.getParameter(request, prefix + "comm_proc_sts_cd", ""));
		setActCommAble(JSPUtil.getParameter(request, prefix + "act_comm_able", ""));
		setCmpnTeuRt(JSPUtil.getParameter(request, prefix + "cmpn_teu_rt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setStsCd(JSPUtil.getParameter(request, prefix + "sts_cd", ""));
		setActIfCommAmt(JSPUtil.getParameter(request, prefix + "act_if_comm_amt", ""));
		setBlNos(JSPUtil.getParameter(request, prefix + "bl_nos", ""));
		setDateOption(JSPUtil.getParameter(request, prefix + "date_option", ""));
		setActCommAmt(JSPUtil.getParameter(request, prefix + "act_comm_amt", ""));
		setBkgRfQty(JSPUtil.getParameter(request, prefix + "bkg_rf_qty", ""));
		setVslDepDt(JSPUtil.getParameter(request, prefix + "vsl_dep_dt", ""));
		setSearchDtFr(JSPUtil.getParameter(request, prefix + "search_dt_fr", ""));
		setFrtFwrdSeq(JSPUtil.getParameter(request, prefix + "frt_fwrd_seq", ""));
		setVndrCntSeq(JSPUtil.getParameter(request, prefix + "vndr_cnt_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setFrtFwrdCntSeq(JSPUtil.getParameter(request, prefix + "frt_fwrd_cnt_seq", ""));
		setAgmtRtSeq(JSPUtil.getParameter(request, prefix + "agmt_rt_seq", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCmpnBkgRt(JSPUtil.getParameter(request, prefix + "cmpn_bkg_rt", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setBkgTeuQty(JSPUtil.getParameter(request, prefix + "bkg_teu_qty", ""));
		setBkgRfTeuQty(JSPUtil.getParameter(request, prefix + "bkg_rf_teu_qty", ""));
		setCmpnSeq(JSPUtil.getParameter(request, prefix + "cmpn_seq", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setSearchDtTo(JSPUtil.getParameter(request, prefix + "search_dt_to", ""));
		setAgmtCustSeq(JSPUtil.getParameter(request, prefix + "agmt_cust_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCmpnRfTeuRt(JSPUtil.getParameter(request, prefix + "cmpn_rf_teu_rt", ""));
		setCmpnIfDt(JSPUtil.getParameter(request, prefix + "cmpn_if_dt", ""));
		setBkgFeuQty(JSPUtil.getParameter(request, prefix + "bkg_feu_qty", ""));
		setFmcNo(JSPUtil.getParameter(request, prefix + "fmc_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCmpnBxRt(JSPUtil.getParameter(request, prefix + "cmpn_bx_rt", ""));
		setBkgBxQty(JSPUtil.getParameter(request, prefix + "bkg_bx_qty", ""));
		setCmpnRfRt(JSPUtil.getParameter(request, prefix + "cmpn_rf_rt", ""));
		setCommProcRsltRsn(JSPUtil.getParameter(request, prefix + "comm_proc_rslt_rsn", ""));
		setCmpnRfFeuRt(JSPUtil.getParameter(request, prefix + "cmpn_rf_feu_rt", ""));
		setCntrCommAmt(JSPUtil.getParameter(request, prefix + "cntr_comm_amt", ""));
		setCmpnFeuRt(JSPUtil.getParameter(request, prefix + "cmpn_feu_rt", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setAgmtCntCd(JSPUtil.getParameter(request, prefix + "agmt_cnt_cd", ""));
		setFfCntCd(JSPUtil.getParameter(request, prefix + "ff_cnt_cd", ""));
		setActPreCommAmt(JSPUtil.getParameter(request, prefix + "act_pre_comm_amt", ""));
		setBkgRfFeuQty(JSPUtil.getParameter(request, prefix + "bkg_rf_feu_qty", ""));
		setFrtFwrdCntCd(JSPUtil.getParameter(request, prefix + "frt_fwrd_cnt_cd", ""));
		setPayChk(JSPUtil.getParameter(request, prefix + "pay_chk", ""));
		setMultiVvd(JSPUtil.getParameter(request, prefix + "multi_vvd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CmpnCommVO[]
	 */
	public CmpnCommVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CmpnCommVO[]
	 */
	public CmpnCommVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CmpnCommVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vndrCntCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cnt_cd", length));
			String[] commProcStsCd = (JSPUtil.getParameter(request, prefix	+ "comm_proc_sts_cd", length));
			String[] actCommAble = (JSPUtil.getParameter(request, prefix	+ "act_comm_able", length));
			String[] cmpnTeuRt = (JSPUtil.getParameter(request, prefix	+ "cmpn_teu_rt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] stsCd = (JSPUtil.getParameter(request, prefix	+ "sts_cd", length));
			String[] actIfCommAmt = (JSPUtil.getParameter(request, prefix	+ "act_if_comm_amt", length));
			String[] blNos = (JSPUtil.getParameter(request, prefix	+ "bl_nos", length));
			String[] dateOption = (JSPUtil.getParameter(request, prefix	+ "date_option", length));
			String[] actCommAmt = (JSPUtil.getParameter(request, prefix	+ "act_comm_amt", length));
			String[] bkgRfQty = (JSPUtil.getParameter(request, prefix	+ "bkg_rf_qty", length));
			String[] vslDepDt = (JSPUtil.getParameter(request, prefix	+ "vsl_dep_dt", length));
			String[] searchDtFr = (JSPUtil.getParameter(request, prefix	+ "search_dt_fr", length));
			String[] frtFwrdSeq = (JSPUtil.getParameter(request, prefix	+ "frt_fwrd_seq", length));
			String[] vndrCntSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_cnt_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] frtFwrdCntSeq = (JSPUtil.getParameter(request, prefix	+ "frt_fwrd_cnt_seq", length));
			String[] agmtRtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_rt_seq", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cmpnBkgRt = (JSPUtil.getParameter(request, prefix	+ "cmpn_bkg_rt", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] bkgTeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_teu_qty", length));
			String[] bkgRfTeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_rf_teu_qty", length));
			String[] cmpnSeq = (JSPUtil.getParameter(request, prefix	+ "cmpn_seq", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] searchDtTo = (JSPUtil.getParameter(request, prefix	+ "search_dt_to", length));
			String[] agmtCustSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_cust_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] cmpnRfTeuRt = (JSPUtil.getParameter(request, prefix	+ "cmpn_rf_teu_rt", length));
			String[] cmpnIfDt = (JSPUtil.getParameter(request, prefix	+ "cmpn_if_dt", length));
			String[] bkgFeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_feu_qty", length));
			String[] fmcNo = (JSPUtil.getParameter(request, prefix	+ "fmc_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cmpnBxRt = (JSPUtil.getParameter(request, prefix	+ "cmpn_bx_rt", length));
			String[] bkgBxQty = (JSPUtil.getParameter(request, prefix	+ "bkg_bx_qty", length));
			String[] cmpnRfRt = (JSPUtil.getParameter(request, prefix	+ "cmpn_rf_rt", length));
			String[] commProcRsltRsn = (JSPUtil.getParameter(request, prefix	+ "comm_proc_rslt_rsn", length));
			String[] cmpnRfFeuRt = (JSPUtil.getParameter(request, prefix	+ "cmpn_rf_feu_rt", length));
			String[] cntrCommAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_comm_amt", length));
			String[] cmpnFeuRt = (JSPUtil.getParameter(request, prefix	+ "cmpn_feu_rt", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] agmtCntCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cnt_cd", length));
			String[] ffCntCd = (JSPUtil.getParameter(request, prefix	+ "ff_cnt_cd", length));
			String[] actPreCommAmt = (JSPUtil.getParameter(request, prefix	+ "act_pre_comm_amt", length));
			String[] bkgRfFeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_rf_feu_qty", length));
			String[] frtFwrdCntCd = (JSPUtil.getParameter(request, prefix	+ "frt_fwrd_cnt_cd", length));
			String[] payChk = (JSPUtil.getParameter(request, prefix	+ "pay_chk", length));
			String[] multiVvd = (JSPUtil.getParameter(request, prefix	+ "multi_vvd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CmpnCommVO();
				if (vndrCntCd[i] != null)
					model.setVndrCntCd(vndrCntCd[i]);
				if (commProcStsCd[i] != null)
					model.setCommProcStsCd(commProcStsCd[i]);
				if (actCommAble[i] != null)
					model.setActCommAble(actCommAble[i]);
				if (cmpnTeuRt[i] != null)
					model.setCmpnTeuRt(cmpnTeuRt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (stsCd[i] != null)
					model.setStsCd(stsCd[i]);
				if (actIfCommAmt[i] != null)
					model.setActIfCommAmt(actIfCommAmt[i]);
				if (blNos[i] != null)
					model.setBlNos(blNos[i]);
				if (dateOption[i] != null)
					model.setDateOption(dateOption[i]);
				if (actCommAmt[i] != null)
					model.setActCommAmt(actCommAmt[i]);
				if (bkgRfQty[i] != null)
					model.setBkgRfQty(bkgRfQty[i]);
				if (vslDepDt[i] != null)
					model.setVslDepDt(vslDepDt[i]);
				if (searchDtFr[i] != null)
					model.setSearchDtFr(searchDtFr[i]);
				if (frtFwrdSeq[i] != null)
					model.setFrtFwrdSeq(frtFwrdSeq[i]);
				if (vndrCntSeq[i] != null)
					model.setVndrCntSeq(vndrCntSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (frtFwrdCntSeq[i] != null)
					model.setFrtFwrdCntSeq(frtFwrdCntSeq[i]);
				if (agmtRtSeq[i] != null)
					model.setAgmtRtSeq(agmtRtSeq[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cmpnBkgRt[i] != null)
					model.setCmpnBkgRt(cmpnBkgRt[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (bkgTeuQty[i] != null)
					model.setBkgTeuQty(bkgTeuQty[i]);
				if (bkgRfTeuQty[i] != null)
					model.setBkgRfTeuQty(bkgRfTeuQty[i]);
				if (cmpnSeq[i] != null)
					model.setCmpnSeq(cmpnSeq[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (searchDtTo[i] != null)
					model.setSearchDtTo(searchDtTo[i]);
				if (agmtCustSeq[i] != null)
					model.setAgmtCustSeq(agmtCustSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (cmpnRfTeuRt[i] != null)
					model.setCmpnRfTeuRt(cmpnRfTeuRt[i]);
				if (cmpnIfDt[i] != null)
					model.setCmpnIfDt(cmpnIfDt[i]);
				if (bkgFeuQty[i] != null)
					model.setBkgFeuQty(bkgFeuQty[i]);
				if (fmcNo[i] != null)
					model.setFmcNo(fmcNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cmpnBxRt[i] != null)
					model.setCmpnBxRt(cmpnBxRt[i]);
				if (bkgBxQty[i] != null)
					model.setBkgBxQty(bkgBxQty[i]);
				if (cmpnRfRt[i] != null)
					model.setCmpnRfRt(cmpnRfRt[i]);
				if (commProcRsltRsn[i] != null)
					model.setCommProcRsltRsn(commProcRsltRsn[i]);
				if (cmpnRfFeuRt[i] != null)
					model.setCmpnRfFeuRt(cmpnRfFeuRt[i]);
				if (cntrCommAmt[i] != null)
					model.setCntrCommAmt(cntrCommAmt[i]);
				if (cmpnFeuRt[i] != null)
					model.setCmpnFeuRt(cmpnFeuRt[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (agmtCntCd[i] != null)
					model.setAgmtCntCd(agmtCntCd[i]);
				if (ffCntCd[i] != null)
					model.setFfCntCd(ffCntCd[i]);
				if (actPreCommAmt[i] != null)
					model.setActPreCommAmt(actPreCommAmt[i]);
				if (bkgRfFeuQty[i] != null)
					model.setBkgRfFeuQty(bkgRfFeuQty[i]);
				if (frtFwrdCntCd[i] != null)
					model.setFrtFwrdCntCd(frtFwrdCntCd[i]);
				if (payChk[i] != null)
					model.setPayChk(payChk[i]);
				if (multiVvd[i] != null)
					model.setMultiVvd(multiVvd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCmpnCommVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CmpnCommVO[]
	 */
	public CmpnCommVO[] getCmpnCommVOs(){
		CmpnCommVO[] vos = (CmpnCommVO[])models.toArray(new CmpnCommVO[models.size()]);
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
		this.vndrCntCd = this.vndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commProcStsCd = this.commProcStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCommAble = this.actCommAble .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpnTeuRt = this.cmpnTeuRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsCd = this.stsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actIfCommAmt = this.actIfCommAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNos = this.blNos .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateOption = this.dateOption .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCommAmt = this.actCommAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRfQty = this.bkgRfQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDepDt = this.vslDepDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchDtFr = this.searchDtFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtFwrdSeq = this.frtFwrdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCntSeq = this.vndrCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtFwrdCntSeq = this.frtFwrdCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtRtSeq = this.agmtRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpnBkgRt = this.cmpnBkgRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTeuQty = this.bkgTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRfTeuQty = this.bkgRfTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpnSeq = this.cmpnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchDtTo = this.searchDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCustSeq = this.agmtCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpnRfTeuRt = this.cmpnRfTeuRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpnIfDt = this.cmpnIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFeuQty = this.bkgFeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmcNo = this.fmcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpnBxRt = this.cmpnBxRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgBxQty = this.bkgBxQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpnRfRt = this.cmpnRfRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commProcRsltRsn = this.commProcRsltRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpnRfFeuRt = this.cmpnRfFeuRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCommAmt = this.cntrCommAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpnFeuRt = this.cmpnFeuRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCntCd = this.agmtCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCntCd = this.ffCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actPreCommAmt = this.actPreCommAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRfFeuQty = this.bkgRfFeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtFwrdCntCd = this.frtFwrdCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payChk = this.payChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.multiVvd = this.multiVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
