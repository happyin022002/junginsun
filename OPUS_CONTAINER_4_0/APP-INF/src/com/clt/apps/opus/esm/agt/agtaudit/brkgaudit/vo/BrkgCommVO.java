/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BrkgCommVO.java
*@FileTitle : BrkgCommVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.02
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2010.07.02 박성진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo;

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

public class BrkgCommVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BrkgCommVO> models = new ArrayList<BrkgCommVO>();
	
	/* Column Info */
	private String vndrCntCd = null;
	/* Column Info */
	private String brogSeq = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String commProcStsCd = null;
	/* Column Info */
	private String searchDtTo = null;
	/* Column Info */
	private String agmtCustSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String actCommAble = null;
	/* Column Info */
	private String brogTeuRt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String stsCd = null;
	/* Column Info */
	private String fmcNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgFeuQty = null;
	/* Column Info */
	private String blNos = null;
	/* Column Info */
	private String actIfCommAmt = null;
	/* Column Info */
	private String brogIfDt = null;
	/* Column Info */
	private String dateOption = null;
	/* Column Info */
	private String actCommAmt = null;
	/* Column Info */
	private String bkgRfQty = null;
	/* Column Info */
	private String bkgBxQty = null;
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
	private String brogRfRt = null;
	/* Column Info */
	private String commProcRsltRsn = null;
	/* Column Info */
	private String frtFwrdCntSeq = null;
	/* Column Info */
	private String brogFeuRt = null;
	/* Column Info */
	private String agmtRtSeq = null;
	/* Column Info */
	private String cntrCommAmt = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String agmtCntCd = null;
	/* Column Info */
	private String brogBxRt = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String bkgTeuQty = null;
	/* Column Info */
	private String ffCntCd = null;
	/* Column Info */
	private String brogBkgRt = null;
	/* Column Info */
	private String actPreCommAmt = null;
	/* Column Info */
	private String frtFwrdCntCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BrkgCommVO() {}

	public BrkgCommVO(String ibflag, String pagerows, String vndrCntCd, String brogSeq, String commProcStsCd, String creDt, String agmtCustSeq, String searchDtTo, String actCommAble, String brogTeuRt, String blNo, String stsCd, String fmcNo, String bkgFeuQty, String blNos, String actIfCommAmt, String brogIfDt, String dateOption, String actCommAmt, String bkgRfQty, String bkgBxQty, String vslDepDt, String searchDtFr, String frtFwrdSeq, String vndrCntSeq, String updUsrId, String brogRfRt, String frtFwrdCntSeq, String commProcRsltRsn, String brogFeuRt, String agmtRtSeq, String cntrCommAmt, String custLglEngNm, String vvd, String bkgNo, String vndrSeq, String brogBxRt, String agmtCntCd, String ffCntCd, String bkgTeuQty, String actPreCommAmt, String brogBkgRt, String frtFwrdCntCd, String bkgStsCd) {
		this.vndrCntCd = vndrCntCd;
		this.brogSeq = brogSeq;
		this.bkgStsCd = bkgStsCd;
		this.commProcStsCd = commProcStsCd;
		this.searchDtTo = searchDtTo;
		this.agmtCustSeq = agmtCustSeq;
		this.creDt = creDt;
		this.actCommAble = actCommAble;
		this.brogTeuRt = brogTeuRt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.stsCd = stsCd;
		this.fmcNo = fmcNo;
		this.ibflag = ibflag;
		this.bkgFeuQty = bkgFeuQty;
		this.blNos = blNos;
		this.actIfCommAmt = actIfCommAmt;
		this.brogIfDt = brogIfDt;
		this.dateOption = dateOption;
		this.actCommAmt = actCommAmt;
		this.bkgRfQty = bkgRfQty;
		this.bkgBxQty = bkgBxQty;
		this.vslDepDt = vslDepDt;
		this.searchDtFr = searchDtFr;
		this.frtFwrdSeq = frtFwrdSeq;
		this.vndrCntSeq = vndrCntSeq;
		this.updUsrId = updUsrId;
		this.brogRfRt = brogRfRt;
		this.commProcRsltRsn = commProcRsltRsn;
		this.frtFwrdCntSeq = frtFwrdCntSeq;
		this.brogFeuRt = brogFeuRt;
		this.agmtRtSeq = agmtRtSeq;
		this.cntrCommAmt = cntrCommAmt;
		this.custLglEngNm = custLglEngNm;
		this.vvd = vvd;
		this.bkgNo = bkgNo;
		this.agmtCntCd = agmtCntCd;
		this.brogBxRt = brogBxRt;
		this.vndrSeq = vndrSeq;
		this.bkgTeuQty = bkgTeuQty;
		this.ffCntCd = ffCntCd;
		this.brogBkgRt = brogBkgRt;
		this.actPreCommAmt = actPreCommAmt;
		this.frtFwrdCntCd = frtFwrdCntCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vndr_cnt_cd", getVndrCntCd());
		this.hashColumns.put("brog_seq", getBrogSeq());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("comm_proc_sts_cd", getCommProcStsCd());
		this.hashColumns.put("search_dt_to", getSearchDtTo());
		this.hashColumns.put("agmt_cust_seq", getAgmtCustSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("act_comm_able", getActCommAble());
		this.hashColumns.put("brog_teu_rt", getBrogTeuRt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sts_cd", getStsCd());
		this.hashColumns.put("fmc_no", getFmcNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_feu_qty", getBkgFeuQty());
		this.hashColumns.put("bl_nos", getBlNos());
		this.hashColumns.put("act_if_comm_amt", getActIfCommAmt());
		this.hashColumns.put("brog_if_dt", getBrogIfDt());
		this.hashColumns.put("date_option", getDateOption());
		this.hashColumns.put("act_comm_amt", getActCommAmt());
		this.hashColumns.put("bkg_rf_qty", getBkgRfQty());
		this.hashColumns.put("bkg_bx_qty", getBkgBxQty());
		this.hashColumns.put("vsl_dep_dt", getVslDepDt());
		this.hashColumns.put("search_dt_fr", getSearchDtFr());
		this.hashColumns.put("frt_fwrd_seq", getFrtFwrdSeq());
		this.hashColumns.put("vndr_cnt_seq", getVndrCntSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("brog_rf_rt", getBrogRfRt());
		this.hashColumns.put("comm_proc_rslt_rsn", getCommProcRsltRsn());
		this.hashColumns.put("frt_fwrd_cnt_seq", getFrtFwrdCntSeq());
		this.hashColumns.put("brog_feu_rt", getBrogFeuRt());
		this.hashColumns.put("agmt_rt_seq", getAgmtRtSeq());
		this.hashColumns.put("cntr_comm_amt", getCntrCommAmt());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("agmt_cnt_cd", getAgmtCntCd());
		this.hashColumns.put("brog_bx_rt", getBrogBxRt());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("bkg_teu_qty", getBkgTeuQty());
		this.hashColumns.put("ff_cnt_cd", getFfCntCd());
		this.hashColumns.put("brog_bkg_rt", getBrogBkgRt());
		this.hashColumns.put("act_pre_comm_amt", getActPreCommAmt());
		this.hashColumns.put("frt_fwrd_cnt_cd", getFrtFwrdCntCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vndr_cnt_cd", "vndrCntCd");
		this.hashFields.put("brog_seq", "brogSeq");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("comm_proc_sts_cd", "commProcStsCd");
		this.hashFields.put("search_dt_to", "searchDtTo");
		this.hashFields.put("agmt_cust_seq", "agmtCustSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("act_comm_able", "actCommAble");
		this.hashFields.put("brog_teu_rt", "brogTeuRt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sts_cd", "stsCd");
		this.hashFields.put("fmc_no", "fmcNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_feu_qty", "bkgFeuQty");
		this.hashFields.put("bl_nos", "blNos");
		this.hashFields.put("act_if_comm_amt", "actIfCommAmt");
		this.hashFields.put("brog_if_dt", "brogIfDt");
		this.hashFields.put("date_option", "dateOption");
		this.hashFields.put("act_comm_amt", "actCommAmt");
		this.hashFields.put("bkg_rf_qty", "bkgRfQty");
		this.hashFields.put("bkg_bx_qty", "bkgBxQty");
		this.hashFields.put("vsl_dep_dt", "vslDepDt");
		this.hashFields.put("search_dt_fr", "searchDtFr");
		this.hashFields.put("frt_fwrd_seq", "frtFwrdSeq");
		this.hashFields.put("vndr_cnt_seq", "vndrCntSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("brog_rf_rt", "brogRfRt");
		this.hashFields.put("comm_proc_rslt_rsn", "commProcRsltRsn");
		this.hashFields.put("frt_fwrd_cnt_seq", "frtFwrdCntSeq");
		this.hashFields.put("brog_feu_rt", "brogFeuRt");
		this.hashFields.put("agmt_rt_seq", "agmtRtSeq");
		this.hashFields.put("cntr_comm_amt", "cntrCommAmt");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("agmt_cnt_cd", "agmtCntCd");
		this.hashFields.put("brog_bx_rt", "brogBxRt");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("bkg_teu_qty", "bkgTeuQty");
		this.hashFields.put("ff_cnt_cd", "ffCntCd");
		this.hashFields.put("brog_bkg_rt", "brogBkgRt");
		this.hashFields.put("act_pre_comm_amt", "actPreCommAmt");
		this.hashFields.put("frt_fwrd_cnt_cd", "frtFwrdCntCd");
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
	 * @return brogSeq
	 */
	public String getBrogSeq() {
		return this.brogSeq;
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
	 * @return commProcStsCd
	 */
	public String getCommProcStsCd() {
		return this.commProcStsCd;
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
	 * @return actCommAble
	 */
	public String getActCommAble() {
		return this.actCommAble;
	}
	
	/**
	 * Column Info
	 * @return brogTeuRt
	 */
	public String getBrogTeuRt() {
		return this.brogTeuRt;
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
	 * @return bkgFeuQty
	 */
	public String getBkgFeuQty() {
		return this.bkgFeuQty;
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
	 * @return actIfCommAmt
	 */
	public String getActIfCommAmt() {
		return this.actIfCommAmt;
	}
	
	/**
	 * Column Info
	 * @return brogIfDt
	 */
	public String getBrogIfDt() {
		return this.brogIfDt;
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
	 * @return bkgBxQty
	 */
	public String getBkgBxQty() {
		return this.bkgBxQty;
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
	 * @return brogRfRt
	 */
	public String getBrogRfRt() {
		return this.brogRfRt;
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
	 * @return frtFwrdCntSeq
	 */
	public String getFrtFwrdCntSeq() {
		return this.frtFwrdCntSeq;
	}
	
	/**
	 * Column Info
	 * @return brogFeuRt
	 */
	public String getBrogFeuRt() {
		return this.brogFeuRt;
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
	 * @return cntrCommAmt
	 */
	public String getCntrCommAmt() {
		return this.cntrCommAmt;
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
	 * @return agmtCntCd
	 */
	public String getAgmtCntCd() {
		return this.agmtCntCd;
	}
	
	/**
	 * Column Info
	 * @return brogBxRt
	 */
	public String getBrogBxRt() {
		return this.brogBxRt;
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
	 * @return ffCntCd
	 */
	public String getFfCntCd() {
		return this.ffCntCd;
	}
	
	/**
	 * Column Info
	 * @return brogBkgRt
	 */
	public String getBrogBkgRt() {
		return this.brogBkgRt;
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
	 * @return frtFwrdCntCd
	 */
	public String getFrtFwrdCntCd() {
		return this.frtFwrdCntCd;
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
	 * @param brogSeq
	 */
	public void setBrogSeq(String brogSeq) {
		this.brogSeq = brogSeq;
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
	 * @param commProcStsCd
	 */
	public void setCommProcStsCd(String commProcStsCd) {
		this.commProcStsCd = commProcStsCd;
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
	 * @param actCommAble
	 */
	public void setActCommAble(String actCommAble) {
		this.actCommAble = actCommAble;
	}
	
	/**
	 * Column Info
	 * @param brogTeuRt
	 */
	public void setBrogTeuRt(String brogTeuRt) {
		this.brogTeuRt = brogTeuRt;
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
	 * @param bkgFeuQty
	 */
	public void setBkgFeuQty(String bkgFeuQty) {
		this.bkgFeuQty = bkgFeuQty;
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
	 * @param actIfCommAmt
	 */
	public void setActIfCommAmt(String actIfCommAmt) {
		this.actIfCommAmt = actIfCommAmt;
	}
	
	/**
	 * Column Info
	 * @param brogIfDt
	 */
	public void setBrogIfDt(String brogIfDt) {
		this.brogIfDt = brogIfDt;
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
	 * @param bkgBxQty
	 */
	public void setBkgBxQty(String bkgBxQty) {
		this.bkgBxQty = bkgBxQty;
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
	 * @param brogRfRt
	 */
	public void setBrogRfRt(String brogRfRt) {
		this.brogRfRt = brogRfRt;
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
	 * @param frtFwrdCntSeq
	 */
	public void setFrtFwrdCntSeq(String frtFwrdCntSeq) {
		this.frtFwrdCntSeq = frtFwrdCntSeq;
	}
	
	/**
	 * Column Info
	 * @param brogFeuRt
	 */
	public void setBrogFeuRt(String brogFeuRt) {
		this.brogFeuRt = brogFeuRt;
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
	 * @param cntrCommAmt
	 */
	public void setCntrCommAmt(String cntrCommAmt) {
		this.cntrCommAmt = cntrCommAmt;
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
	 * @param agmtCntCd
	 */
	public void setAgmtCntCd(String agmtCntCd) {
		this.agmtCntCd = agmtCntCd;
	}
	
	/**
	 * Column Info
	 * @param brogBxRt
	 */
	public void setBrogBxRt(String brogBxRt) {
		this.brogBxRt = brogBxRt;
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
	 * @param ffCntCd
	 */
	public void setFfCntCd(String ffCntCd) {
		this.ffCntCd = ffCntCd;
	}
	
	/**
	 * Column Info
	 * @param brogBkgRt
	 */
	public void setBrogBkgRt(String brogBkgRt) {
		this.brogBkgRt = brogBkgRt;
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
	 * @param frtFwrdCntCd
	 */
	public void setFrtFwrdCntCd(String frtFwrdCntCd) {
		this.frtFwrdCntCd = frtFwrdCntCd;
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
		setBrogSeq(JSPUtil.getParameter(request, prefix + "brog_seq", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setCommProcStsCd(JSPUtil.getParameter(request, prefix + "comm_proc_sts_cd", ""));
		setSearchDtTo(JSPUtil.getParameter(request, prefix + "search_dt_to", ""));
		setAgmtCustSeq(JSPUtil.getParameter(request, prefix + "agmt_cust_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setActCommAble(JSPUtil.getParameter(request, prefix + "act_comm_able", ""));
		setBrogTeuRt(JSPUtil.getParameter(request, prefix + "brog_teu_rt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setStsCd(JSPUtil.getParameter(request, prefix + "sts_cd", ""));
		setFmcNo(JSPUtil.getParameter(request, prefix + "fmc_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgFeuQty(JSPUtil.getParameter(request, prefix + "bkg_feu_qty", ""));
		setBlNos(JSPUtil.getParameter(request, prefix + "bl_nos", ""));
		setActIfCommAmt(JSPUtil.getParameter(request, prefix + "act_if_comm_amt", ""));
		setBrogIfDt(JSPUtil.getParameter(request, prefix + "brog_if_dt", ""));
		setDateOption(JSPUtil.getParameter(request, prefix + "date_option", ""));
		setActCommAmt(JSPUtil.getParameter(request, prefix + "act_comm_amt", ""));
		setBkgRfQty(JSPUtil.getParameter(request, prefix + "bkg_rf_qty", ""));
		setBkgBxQty(JSPUtil.getParameter(request, prefix + "bkg_bx_qty", ""));
		setVslDepDt(JSPUtil.getParameter(request, prefix + "vsl_dep_dt", ""));
		setSearchDtFr(JSPUtil.getParameter(request, prefix + "search_dt_fr", ""));
		setFrtFwrdSeq(JSPUtil.getParameter(request, prefix + "frt_fwrd_seq", ""));
		setVndrCntSeq(JSPUtil.getParameter(request, prefix + "vndr_cnt_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setBrogRfRt(JSPUtil.getParameter(request, prefix + "brog_rf_rt", ""));
		setCommProcRsltRsn(JSPUtil.getParameter(request, prefix + "comm_proc_rslt_rsn", ""));
		setFrtFwrdCntSeq(JSPUtil.getParameter(request, prefix + "frt_fwrd_cnt_seq", ""));
		setBrogFeuRt(JSPUtil.getParameter(request, prefix + "brog_feu_rt", ""));
		setAgmtRtSeq(JSPUtil.getParameter(request, prefix + "agmt_rt_seq", ""));
		setCntrCommAmt(JSPUtil.getParameter(request, prefix + "cntr_comm_amt", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setAgmtCntCd(JSPUtil.getParameter(request, prefix + "agmt_cnt_cd", ""));
		setBrogBxRt(JSPUtil.getParameter(request, prefix + "brog_bx_rt", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setBkgTeuQty(JSPUtil.getParameter(request, prefix + "bkg_teu_qty", ""));
		setFfCntCd(JSPUtil.getParameter(request, prefix + "ff_cnt_cd", ""));
		setBrogBkgRt(JSPUtil.getParameter(request, prefix + "brog_bkg_rt", ""));
		setActPreCommAmt(JSPUtil.getParameter(request, prefix + "act_pre_comm_amt", ""));
		setFrtFwrdCntCd(JSPUtil.getParameter(request, prefix + "frt_fwrd_cnt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BrkgCommVO[]
	 */
	public BrkgCommVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BrkgCommVO[]
	 */
	public BrkgCommVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BrkgCommVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vndrCntCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cnt_cd", length));
			String[] brogSeq = (JSPUtil.getParameter(request, prefix	+ "brog_seq", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] commProcStsCd = (JSPUtil.getParameter(request, prefix	+ "comm_proc_sts_cd", length));
			String[] searchDtTo = (JSPUtil.getParameter(request, prefix	+ "search_dt_to", length));
			String[] agmtCustSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_cust_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] actCommAble = (JSPUtil.getParameter(request, prefix	+ "act_comm_able", length));
			String[] brogTeuRt = (JSPUtil.getParameter(request, prefix	+ "brog_teu_rt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] stsCd = (JSPUtil.getParameter(request, prefix	+ "sts_cd", length));
			String[] fmcNo = (JSPUtil.getParameter(request, prefix	+ "fmc_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgFeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_feu_qty", length));
			String[] blNos = (JSPUtil.getParameter(request, prefix	+ "bl_nos", length));
			String[] actIfCommAmt = (JSPUtil.getParameter(request, prefix	+ "act_if_comm_amt", length));
			String[] brogIfDt = (JSPUtil.getParameter(request, prefix	+ "brog_if_dt", length));
			String[] dateOption = (JSPUtil.getParameter(request, prefix	+ "date_option", length));
			String[] actCommAmt = (JSPUtil.getParameter(request, prefix	+ "act_comm_amt", length));
			String[] bkgRfQty = (JSPUtil.getParameter(request, prefix	+ "bkg_rf_qty", length));
			String[] bkgBxQty = (JSPUtil.getParameter(request, prefix	+ "bkg_bx_qty", length));
			String[] vslDepDt = (JSPUtil.getParameter(request, prefix	+ "vsl_dep_dt", length));
			String[] searchDtFr = (JSPUtil.getParameter(request, prefix	+ "search_dt_fr", length));
			String[] frtFwrdSeq = (JSPUtil.getParameter(request, prefix	+ "frt_fwrd_seq", length));
			String[] vndrCntSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_cnt_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] brogRfRt = (JSPUtil.getParameter(request, prefix	+ "brog_rf_rt", length));
			String[] commProcRsltRsn = (JSPUtil.getParameter(request, prefix	+ "comm_proc_rslt_rsn", length));
			String[] frtFwrdCntSeq = (JSPUtil.getParameter(request, prefix	+ "frt_fwrd_cnt_seq", length));
			String[] brogFeuRt = (JSPUtil.getParameter(request, prefix	+ "brog_feu_rt", length));
			String[] agmtRtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_rt_seq", length));
			String[] cntrCommAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_comm_amt", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] agmtCntCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cnt_cd", length));
			String[] brogBxRt = (JSPUtil.getParameter(request, prefix	+ "brog_bx_rt", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] bkgTeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_teu_qty", length));
			String[] ffCntCd = (JSPUtil.getParameter(request, prefix	+ "ff_cnt_cd", length));
			String[] brogBkgRt = (JSPUtil.getParameter(request, prefix	+ "brog_bkg_rt", length));
			String[] actPreCommAmt = (JSPUtil.getParameter(request, prefix	+ "act_pre_comm_amt", length));
			String[] frtFwrdCntCd = (JSPUtil.getParameter(request, prefix	+ "frt_fwrd_cnt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new BrkgCommVO();
				if (vndrCntCd[i] != null)
					model.setVndrCntCd(vndrCntCd[i]);
				if (brogSeq[i] != null)
					model.setBrogSeq(brogSeq[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (commProcStsCd[i] != null)
					model.setCommProcStsCd(commProcStsCd[i]);
				if (searchDtTo[i] != null)
					model.setSearchDtTo(searchDtTo[i]);
				if (agmtCustSeq[i] != null)
					model.setAgmtCustSeq(agmtCustSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (actCommAble[i] != null)
					model.setActCommAble(actCommAble[i]);
				if (brogTeuRt[i] != null)
					model.setBrogTeuRt(brogTeuRt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (stsCd[i] != null)
					model.setStsCd(stsCd[i]);
				if (fmcNo[i] != null)
					model.setFmcNo(fmcNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgFeuQty[i] != null)
					model.setBkgFeuQty(bkgFeuQty[i]);
				if (blNos[i] != null)
					model.setBlNos(blNos[i]);
				if (actIfCommAmt[i] != null)
					model.setActIfCommAmt(actIfCommAmt[i]);
				if (brogIfDt[i] != null)
					model.setBrogIfDt(brogIfDt[i]);
				if (dateOption[i] != null)
					model.setDateOption(dateOption[i]);
				if (actCommAmt[i] != null)
					model.setActCommAmt(actCommAmt[i]);
				if (bkgRfQty[i] != null)
					model.setBkgRfQty(bkgRfQty[i]);
				if (bkgBxQty[i] != null)
					model.setBkgBxQty(bkgBxQty[i]);
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
				if (brogRfRt[i] != null)
					model.setBrogRfRt(brogRfRt[i]);
				if (commProcRsltRsn[i] != null)
					model.setCommProcRsltRsn(commProcRsltRsn[i]);
				if (frtFwrdCntSeq[i] != null)
					model.setFrtFwrdCntSeq(frtFwrdCntSeq[i]);
				if (brogFeuRt[i] != null)
					model.setBrogFeuRt(brogFeuRt[i]);
				if (agmtRtSeq[i] != null)
					model.setAgmtRtSeq(agmtRtSeq[i]);
				if (cntrCommAmt[i] != null)
					model.setCntrCommAmt(cntrCommAmt[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (agmtCntCd[i] != null)
					model.setAgmtCntCd(agmtCntCd[i]);
				if (brogBxRt[i] != null)
					model.setBrogBxRt(brogBxRt[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (bkgTeuQty[i] != null)
					model.setBkgTeuQty(bkgTeuQty[i]);
				if (ffCntCd[i] != null)
					model.setFfCntCd(ffCntCd[i]);
				if (brogBkgRt[i] != null)
					model.setBrogBkgRt(brogBkgRt[i]);
				if (actPreCommAmt[i] != null)
					model.setActPreCommAmt(actPreCommAmt[i]);
				if (frtFwrdCntCd[i] != null)
					model.setFrtFwrdCntCd(frtFwrdCntCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBrkgCommVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BrkgCommVO[]
	 */
	public BrkgCommVO[] getBrkgCommVOs(){
		BrkgCommVO[] vos = (BrkgCommVO[])models.toArray(new BrkgCommVO[models.size()]);
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
		this.brogSeq = this.brogSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commProcStsCd = this.commProcStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchDtTo = this.searchDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCustSeq = this.agmtCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCommAble = this.actCommAble .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brogTeuRt = this.brogTeuRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsCd = this.stsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmcNo = this.fmcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFeuQty = this.bkgFeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNos = this.blNos .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actIfCommAmt = this.actIfCommAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brogIfDt = this.brogIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateOption = this.dateOption .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCommAmt = this.actCommAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRfQty = this.bkgRfQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgBxQty = this.bkgBxQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDepDt = this.vslDepDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchDtFr = this.searchDtFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtFwrdSeq = this.frtFwrdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCntSeq = this.vndrCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brogRfRt = this.brogRfRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commProcRsltRsn = this.commProcRsltRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtFwrdCntSeq = this.frtFwrdCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brogFeuRt = this.brogFeuRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtRtSeq = this.agmtRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCommAmt = this.cntrCommAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCntCd = this.agmtCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brogBxRt = this.brogBxRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTeuQty = this.bkgTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCntCd = this.ffCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brogBkgRt = this.brogBkgRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actPreCommAmt = this.actPreCommAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtFwrdCntCd = this.frtFwrdCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
