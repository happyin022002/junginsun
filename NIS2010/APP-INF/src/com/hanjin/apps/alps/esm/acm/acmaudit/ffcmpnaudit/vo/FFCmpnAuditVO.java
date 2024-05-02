/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FFCmpnAuditVO.java
*@FileTitle : FFCmpnAuditVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.12
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.07.12 김영오 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.acm.acmaudit.ffcmpnaudit.vo;

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
 * @author 김영오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FFCmpnAuditVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FFCmpnAuditVO> models = new ArrayList<FFCmpnAuditVO>();
	
	/* Column Info */
	private String ifDt = null;
	/* Column Info */
	private String ffBxAmt = null;
	/* Column Info */
	private String vndrCntCd = null;
	/* Column Info */
	private String actCommAble = null;
	/* Column Info */
	private String brogTeuRt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ffAgmtSeq = null;
	/* Column Info */
	private String cntrCrntAmt = null;
	/* Column Info */
	private String ffRefNo = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String dateOption = null;
	/* Column Info */
	private String bkgFfCntCd = null;
	/* Column Info */
	private String bkgRfQty = null;
	/* Column Info */
	private String vslDepDt = null;
	/* Column Info */
	private String vndrCntSeq = null;
	/* Column Info */
	private String brogRfRt = null;
	/* Column Info */
	private String frtFwrdCntSeq = null;
	/* Column Info */
	private String commVvd = null;
	/* Column Info */
	private String dateTo = null;
	/* Column Info */
	private String ppdAmt = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String ifAmt = null;
	/* Column Info */
	private String bkgTeuQty = null;
	/* Column Info */
	private String dateFm = null;
	/* Column Info */
	private String ifOpt = null;
	/* Column Info */
	private String ffFeuAmt = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String ffCmpnStsCd = null;
	/* Column Info */
	private String creDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fmcNo = null;
	/* Column Info */
	private String bkgFeuQty = null;
	/* Column Info */
	private String ffTeuAmt = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String ffRfAmt = null;
	/* Column Info */
	private String crntAmt = null;
	/* Column Info */
	private String dateDiv = null;
	/* Column Info */
	private String bkgBxQty = null;
	/* Column Info */
	private String brogFeuRt = null;
	/* Column Info */
	private String ffBkgRt = null;
	/* Column Info */
	private String bkgCrntAmt = null;
	/* Column Info */
	private String acProcDesc = null;
	/* Column Info */
	private String ffCmpnSeq = null;
	/* Column Info */
	private String bkgFfSeq = null;
	/* Column Info */
	private String brogBxRt = null;
	/* Column Info */
	private String searchBrogCntCustSeq = null;
	/* Column Info */
	private String ffCmpnRmk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FFCmpnAuditVO() {}

	public FFCmpnAuditVO(String ibflag, String pagerows, String ifDt, String bkgStsCd, String ffCmpnStsCd, String creDt, String actCommAble, String brogTeuRt, String blNo, String ffAgmtSeq, String fmcNo, String bkgFeuQty, String ffRefNo, String crntAmt, String bkgBxQty, String bkgRfQty, String vslDepDt, String vndrCntSeq, String brogRfRt, String frtFwrdCntSeq, String commVvd, String brogFeuRt, String ffBkgRt, String ppdAmt, String custLglEngNm, String bkgNo, String acProcDesc, String ffCmpnSeq, String brogBxRt, String ifAmt, String bkgTeuQty, String ffBxAmt, String ffTeuAmt, String ffFeuAmt, String ffRfAmt, String cntrCrntAmt, String bkgCrntAmt, String ifOpt, String dateOption, String dateFm, String dateTo, String dateDiv, String vvdCd, String searchBrogCntCustSeq, String usrId, String bkgFfCntCd, String bkgFfSeq, String vndrCntCd, String vndrSeq, String ffCmpnRmk) {
		this.ifDt = ifDt;
		this.ffBxAmt = ffBxAmt;
		this.vndrCntCd = vndrCntCd;
		this.actCommAble = actCommAble;
		this.brogTeuRt = brogTeuRt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.ffAgmtSeq = ffAgmtSeq;
		this.cntrCrntAmt = cntrCrntAmt;
		this.ffRefNo = ffRefNo;
		this.vvdCd = vvdCd;
		this.dateOption = dateOption;
		this.bkgFfCntCd = bkgFfCntCd;
		this.bkgRfQty = bkgRfQty;
		this.vslDepDt = vslDepDt;
		this.vndrCntSeq = vndrCntSeq;
		this.brogRfRt = brogRfRt;
		this.frtFwrdCntSeq = frtFwrdCntSeq;
		this.commVvd = commVvd;
		this.dateTo = dateTo;
		this.ppdAmt = ppdAmt;
		this.custLglEngNm = custLglEngNm;
		this.bkgNo = bkgNo;
		this.vndrSeq = vndrSeq;
		this.ifAmt = ifAmt;
		this.bkgTeuQty = bkgTeuQty;
		this.dateFm = dateFm;
		this.ifOpt = ifOpt;
		this.ffFeuAmt = ffFeuAmt;
		this.bkgStsCd = bkgStsCd;
		this.ffCmpnStsCd = ffCmpnStsCd;
		this.creDt = creDt;
		this.ibflag = ibflag;
		this.fmcNo = fmcNo;
		this.bkgFeuQty = bkgFeuQty;
		this.ffTeuAmt = ffTeuAmt;
		this.usrId = usrId;
		this.ffRfAmt = ffRfAmt;
		this.crntAmt = crntAmt;
		this.dateDiv = dateDiv;
		this.bkgBxQty = bkgBxQty;
		this.brogFeuRt = brogFeuRt;
		this.ffBkgRt = ffBkgRt;
		this.bkgCrntAmt = bkgCrntAmt;
		this.acProcDesc = acProcDesc;
		this.ffCmpnSeq = ffCmpnSeq;
		this.bkgFfSeq = bkgFfSeq;
		this.brogBxRt = brogBxRt;
		this.searchBrogCntCustSeq = searchBrogCntCustSeq;
		this.ffCmpnRmk = ffCmpnRmk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("if_dt", getIfDt());
		this.hashColumns.put("ff_bx_amt", getFfBxAmt());
		this.hashColumns.put("vndr_cnt_cd", getVndrCntCd());
		this.hashColumns.put("act_comm_able", getActCommAble());
		this.hashColumns.put("brog_teu_rt", getBrogTeuRt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ff_agmt_seq", getFfAgmtSeq());
		this.hashColumns.put("cntr_crnt_amt", getCntrCrntAmt());
		this.hashColumns.put("ff_ref_no", getFfRefNo());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("date_option", getDateOption());
		this.hashColumns.put("bkg_ff_cnt_cd", getBkgFfCntCd());
		this.hashColumns.put("bkg_rf_qty", getBkgRfQty());
		this.hashColumns.put("vsl_dep_dt", getVslDepDt());
		this.hashColumns.put("vndr_cnt_seq", getVndrCntSeq());
		this.hashColumns.put("brog_rf_rt", getBrogRfRt());
		this.hashColumns.put("frt_fwrd_cnt_seq", getFrtFwrdCntSeq());
		this.hashColumns.put("comm_vvd", getCommVvd());
		this.hashColumns.put("date_to", getDateTo());
		this.hashColumns.put("ppd_amt", getPpdAmt());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("if_amt", getIfAmt());
		this.hashColumns.put("bkg_teu_qty", getBkgTeuQty());
		this.hashColumns.put("date_fm", getDateFm());
		this.hashColumns.put("if_opt", getIfOpt());
		this.hashColumns.put("ff_feu_amt", getFfFeuAmt());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("ff_cmpn_sts_cd", getFfCmpnStsCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fmc_no", getFmcNo());
		this.hashColumns.put("bkg_feu_qty", getBkgFeuQty());
		this.hashColumns.put("ff_teu_amt", getFfTeuAmt());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("ff_rf_amt", getFfRfAmt());
		this.hashColumns.put("crnt_amt", getCrntAmt());
		this.hashColumns.put("date_div", getDateDiv());
		this.hashColumns.put("bkg_bx_qty", getBkgBxQty());
		this.hashColumns.put("brog_feu_rt", getBrogFeuRt());
		this.hashColumns.put("ff_bkg_rt", getFfBkgRt());
		this.hashColumns.put("bkg_crnt_amt", getBkgCrntAmt());
		this.hashColumns.put("ac_proc_desc", getAcProcDesc());
		this.hashColumns.put("ff_cmpn_seq", getFfCmpnSeq());
		this.hashColumns.put("bkg_ff_seq", getBkgFfSeq());
		this.hashColumns.put("brog_bx_rt", getBrogBxRt());
		this.hashColumns.put("search_brog_cnt_cust_seq", getSearchBrogCntCustSeq());
		this.hashColumns.put("ff_cmpn_rmk", getFfCmpnRmk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("if_dt", "ifDt");
		this.hashFields.put("ff_bx_amt", "ffBxAmt");
		this.hashFields.put("vndr_cnt_cd", "vndrCntCd");
		this.hashFields.put("act_comm_able", "actCommAble");
		this.hashFields.put("brog_teu_rt", "brogTeuRt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ff_agmt_seq", "ffAgmtSeq");
		this.hashFields.put("cntr_crnt_amt", "cntrCrntAmt");
		this.hashFields.put("ff_ref_no", "ffRefNo");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("date_option", "dateOption");
		this.hashFields.put("bkg_ff_cnt_cd", "bkgFfCntCd");
		this.hashFields.put("bkg_rf_qty", "bkgRfQty");
		this.hashFields.put("vsl_dep_dt", "vslDepDt");
		this.hashFields.put("vndr_cnt_seq", "vndrCntSeq");
		this.hashFields.put("brog_rf_rt", "brogRfRt");
		this.hashFields.put("frt_fwrd_cnt_seq", "frtFwrdCntSeq");
		this.hashFields.put("comm_vvd", "commVvd");
		this.hashFields.put("date_to", "dateTo");
		this.hashFields.put("ppd_amt", "ppdAmt");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("if_amt", "ifAmt");
		this.hashFields.put("bkg_teu_qty", "bkgTeuQty");
		this.hashFields.put("date_fm", "dateFm");
		this.hashFields.put("if_opt", "ifOpt");
		this.hashFields.put("ff_feu_amt", "ffFeuAmt");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("ff_cmpn_sts_cd", "ffCmpnStsCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fmc_no", "fmcNo");
		this.hashFields.put("bkg_feu_qty", "bkgFeuQty");
		this.hashFields.put("ff_teu_amt", "ffTeuAmt");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("ff_rf_amt", "ffRfAmt");
		this.hashFields.put("crnt_amt", "crntAmt");
		this.hashFields.put("date_div", "dateDiv");
		this.hashFields.put("bkg_bx_qty", "bkgBxQty");
		this.hashFields.put("brog_feu_rt", "brogFeuRt");
		this.hashFields.put("ff_bkg_rt", "ffBkgRt");
		this.hashFields.put("bkg_crnt_amt", "bkgCrntAmt");
		this.hashFields.put("ac_proc_desc", "acProcDesc");
		this.hashFields.put("ff_cmpn_seq", "ffCmpnSeq");
		this.hashFields.put("bkg_ff_seq", "bkgFfSeq");
		this.hashFields.put("brog_bx_rt", "brogBxRt");
		this.hashFields.put("search_brog_cnt_cust_seq", "searchBrogCntCustSeq");
		this.hashFields.put("ff_cmpn_rmk", "ffCmpnRmk");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ifDt
	 */
	public String getIfDt() {
		return this.ifDt;
	}
	
	/**
	 * Column Info
	 * @return ffBxAmt
	 */
	public String getFfBxAmt() {
		return this.ffBxAmt;
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
	 * @return ffAgmtSeq
	 */
	public String getFfAgmtSeq() {
		return this.ffAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @return cntrCrntAmt
	 */
	public String getCntrCrntAmt() {
		return this.cntrCrntAmt;
	}
	
	/**
	 * Column Info
	 * @return ffRefNo
	 */
	public String getFfRefNo() {
		return this.ffRefNo;
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
	 * @return dateOption
	 */
	public String getDateOption() {
		return this.dateOption;
	}
	
	/**
	 * Column Info
	 * @return bkgFfCntCd
	 */
	public String getBkgFfCntCd() {
		return this.bkgFfCntCd;
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
	 * @return vndrCntSeq
	 */
	public String getVndrCntSeq() {
		return this.vndrCntSeq;
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
	 * @return frtFwrdCntSeq
	 */
	public String getFrtFwrdCntSeq() {
		return this.frtFwrdCntSeq;
	}
	
	/**
	 * Column Info
	 * @return commVvd
	 */
	public String getCommVvd() {
		return this.commVvd;
	}
	
	/**
	 * Column Info
	 * @return dateTo
	 */
	public String getDateTo() {
		return this.dateTo;
	}
	
	/**
	 * Column Info
	 * @return ppdAmt
	 */
	public String getPpdAmt() {
		return this.ppdAmt;
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
	 * @return ifAmt
	 */
	public String getIfAmt() {
		return this.ifAmt;
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
	 * @return dateFm
	 */
	public String getDateFm() {
		return this.dateFm;
	}
	
	/**
	 * Column Info
	 * @return ifOpt
	 */
	public String getIfOpt() {
		return this.ifOpt;
	}
	
	/**
	 * Column Info
	 * @return ffFeuAmt
	 */
	public String getFfFeuAmt() {
		return this.ffFeuAmt;
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
	 * @return ffCmpnStsCd
	 */
	public String getFfCmpnStsCd() {
		return this.ffCmpnStsCd;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return fmcNo
	 */
	public String getFmcNo() {
		return this.fmcNo;
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
	 * @return ffTeuAmt
	 */
	public String getFfTeuAmt() {
		return this.ffTeuAmt;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return ffRfAmt
	 */
	public String getFfRfAmt() {
		return this.ffRfAmt;
	}
	
	/**
	 * Column Info
	 * @return crntAmt
	 */
	public String getCrntAmt() {
		return this.crntAmt;
	}
	
	/**
	 * Column Info
	 * @return dateDiv
	 */
	public String getDateDiv() {
		return this.dateDiv;
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
	 * @return brogFeuRt
	 */
	public String getBrogFeuRt() {
		return this.brogFeuRt;
	}
	
	/**
	 * Column Info
	 * @return ffBkgRt
	 */
	public String getFfBkgRt() {
		return this.ffBkgRt;
	}
	
	/**
	 * Column Info
	 * @return bkgCrntAmt
	 */
	public String getBkgCrntAmt() {
		return this.bkgCrntAmt;
	}
	
	/**
	 * Column Info
	 * @return acProcDesc
	 */
	public String getAcProcDesc() {
		return this.acProcDesc;
	}
	
	/**
	 * Column Info
	 * @return ffCmpnSeq
	 */
	public String getFfCmpnSeq() {
		return this.ffCmpnSeq;
	}
	
	/**
	 * Column Info
	 * @return bkgFfSeq
	 */
	public String getBkgFfSeq() {
		return this.bkgFfSeq;
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
	 * @return searchBrogCntCustSeq
	 */
	public String getSearchBrogCntCustSeq() {
		return this.searchBrogCntCustSeq;
	}
	
	/**
	 * Column Info
	 * @return ffCmpnRmk
	 */
	public String getFfCmpnRmk() {
		return this.ffCmpnRmk;
	}
	

	/**
	 * Column Info
	 * @param ifDt
	 */
	public void setIfDt(String ifDt) {
		this.ifDt = ifDt;
	}
	
	/**
	 * Column Info
	 * @param ffBxAmt
	 */
	public void setFfBxAmt(String ffBxAmt) {
		this.ffBxAmt = ffBxAmt;
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
	 * @param ffAgmtSeq
	 */
	public void setFfAgmtSeq(String ffAgmtSeq) {
		this.ffAgmtSeq = ffAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @param cntrCrntAmt
	 */
	public void setCntrCrntAmt(String cntrCrntAmt) {
		this.cntrCrntAmt = cntrCrntAmt;
	}
	
	/**
	 * Column Info
	 * @param ffRefNo
	 */
	public void setFfRefNo(String ffRefNo) {
		this.ffRefNo = ffRefNo;
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
	 * @param dateOption
	 */
	public void setDateOption(String dateOption) {
		this.dateOption = dateOption;
	}
	
	/**
	 * Column Info
	 * @param bkgFfCntCd
	 */
	public void setBkgFfCntCd(String bkgFfCntCd) {
		this.bkgFfCntCd = bkgFfCntCd;
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
	 * @param vndrCntSeq
	 */
	public void setVndrCntSeq(String vndrCntSeq) {
		this.vndrCntSeq = vndrCntSeq;
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
	 * @param frtFwrdCntSeq
	 */
	public void setFrtFwrdCntSeq(String frtFwrdCntSeq) {
		this.frtFwrdCntSeq = frtFwrdCntSeq;
	}
	
	/**
	 * Column Info
	 * @param commVvd
	 */
	public void setCommVvd(String commVvd) {
		this.commVvd = commVvd;
	}
	
	/**
	 * Column Info
	 * @param dateTo
	 */
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
	
	/**
	 * Column Info
	 * @param ppdAmt
	 */
	public void setPpdAmt(String ppdAmt) {
		this.ppdAmt = ppdAmt;
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
	 * @param ifAmt
	 */
	public void setIfAmt(String ifAmt) {
		this.ifAmt = ifAmt;
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
	 * @param dateFm
	 */
	public void setDateFm(String dateFm) {
		this.dateFm = dateFm;
	}
	
	/**
	 * Column Info
	 * @param ifOpt
	 */
	public void setIfOpt(String ifOpt) {
		this.ifOpt = ifOpt;
	}
	
	/**
	 * Column Info
	 * @param ffFeuAmt
	 */
	public void setFfFeuAmt(String ffFeuAmt) {
		this.ffFeuAmt = ffFeuAmt;
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
	 * @param ffCmpnStsCd
	 */
	public void setFfCmpnStsCd(String ffCmpnStsCd) {
		this.ffCmpnStsCd = ffCmpnStsCd;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param fmcNo
	 */
	public void setFmcNo(String fmcNo) {
		this.fmcNo = fmcNo;
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
	 * @param ffTeuAmt
	 */
	public void setFfTeuAmt(String ffTeuAmt) {
		this.ffTeuAmt = ffTeuAmt;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param ffRfAmt
	 */
	public void setFfRfAmt(String ffRfAmt) {
		this.ffRfAmt = ffRfAmt;
	}
	
	/**
	 * Column Info
	 * @param crntAmt
	 */
	public void setCrntAmt(String crntAmt) {
		this.crntAmt = crntAmt;
	}
	
	/**
	 * Column Info
	 * @param dateDiv
	 */
	public void setDateDiv(String dateDiv) {
		this.dateDiv = dateDiv;
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
	 * @param brogFeuRt
	 */
	public void setBrogFeuRt(String brogFeuRt) {
		this.brogFeuRt = brogFeuRt;
	}
	
	/**
	 * Column Info
	 * @param ffBkgRt
	 */
	public void setFfBkgRt(String ffBkgRt) {
		this.ffBkgRt = ffBkgRt;
	}
	
	/**
	 * Column Info
	 * @param bkgCrntAmt
	 */
	public void setBkgCrntAmt(String bkgCrntAmt) {
		this.bkgCrntAmt = bkgCrntAmt;
	}
	
	/**
	 * Column Info
	 * @param acProcDesc
	 */
	public void setAcProcDesc(String acProcDesc) {
		this.acProcDesc = acProcDesc;
	}
	
	/**
	 * Column Info
	 * @param ffCmpnSeq
	 */
	public void setFfCmpnSeq(String ffCmpnSeq) {
		this.ffCmpnSeq = ffCmpnSeq;
	}
	
	/**
	 * Column Info
	 * @param bkgFfSeq
	 */
	public void setBkgFfSeq(String bkgFfSeq) {
		this.bkgFfSeq = bkgFfSeq;
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
	 * @param searchBrogCntCustSeq
	 */
	public void setSearchBrogCntCustSeq(String searchBrogCntCustSeq) {
		this.searchBrogCntCustSeq = searchBrogCntCustSeq;
	}
	
	/**
	 * Column Info
	 * @param ffCmpnRmk
	 */
	public void setFfCmpnRmk(String ffCmpnRmk) {
		this.ffCmpnRmk = ffCmpnRmk;
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
		setIfDt(JSPUtil.getParameter(request, prefix + "if_dt", ""));
		setFfBxAmt(JSPUtil.getParameter(request, prefix + "ff_bx_amt", ""));
		setVndrCntCd(JSPUtil.getParameter(request, prefix + "vndr_cnt_cd", ""));
		setActCommAble(JSPUtil.getParameter(request, prefix + "act_comm_able", ""));
		setBrogTeuRt(JSPUtil.getParameter(request, prefix + "brog_teu_rt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFfAgmtSeq(JSPUtil.getParameter(request, prefix + "ff_agmt_seq", ""));
		setCntrCrntAmt(JSPUtil.getParameter(request, prefix + "cntr_crnt_amt", ""));
		setFfRefNo(JSPUtil.getParameter(request, prefix + "ff_ref_no", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setDateOption(JSPUtil.getParameter(request, prefix + "date_option", ""));
		setBkgFfCntCd(JSPUtil.getParameter(request, prefix + "bkg_ff_cnt_cd", ""));
		setBkgRfQty(JSPUtil.getParameter(request, prefix + "bkg_rf_qty", ""));
		setVslDepDt(JSPUtil.getParameter(request, prefix + "vsl_dep_dt", ""));
		setVndrCntSeq(JSPUtil.getParameter(request, prefix + "vndr_cnt_seq", ""));
		setBrogRfRt(JSPUtil.getParameter(request, prefix + "brog_rf_rt", ""));
		setFrtFwrdCntSeq(JSPUtil.getParameter(request, prefix + "frt_fwrd_cnt_seq", ""));
		setCommVvd(JSPUtil.getParameter(request, prefix + "comm_vvd", ""));
		setDateTo(JSPUtil.getParameter(request, prefix + "date_to", ""));
		setPpdAmt(JSPUtil.getParameter(request, prefix + "ppd_amt", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setIfAmt(JSPUtil.getParameter(request, prefix + "if_amt", ""));
		setBkgTeuQty(JSPUtil.getParameter(request, prefix + "bkg_teu_qty", ""));
		setDateFm(JSPUtil.getParameter(request, prefix + "date_fm", ""));
		setIfOpt(JSPUtil.getParameter(request, prefix + "if_opt", ""));
		setFfFeuAmt(JSPUtil.getParameter(request, prefix + "ff_feu_amt", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setFfCmpnStsCd(JSPUtil.getParameter(request, prefix + "ff_cmpn_sts_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFmcNo(JSPUtil.getParameter(request, prefix + "fmc_no", ""));
		setBkgFeuQty(JSPUtil.getParameter(request, prefix + "bkg_feu_qty", ""));
		setFfTeuAmt(JSPUtil.getParameter(request, prefix + "ff_teu_amt", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setFfRfAmt(JSPUtil.getParameter(request, prefix + "ff_rf_amt", ""));
		setCrntAmt(JSPUtil.getParameter(request, prefix + "crnt_amt", ""));
		setDateDiv(JSPUtil.getParameter(request, prefix + "date_div", ""));
		setBkgBxQty(JSPUtil.getParameter(request, prefix + "bkg_bx_qty", ""));
		setBrogFeuRt(JSPUtil.getParameter(request, prefix + "brog_feu_rt", ""));
		setFfBkgRt(JSPUtil.getParameter(request, prefix + "ff_bkg_rt", ""));
		setBkgCrntAmt(JSPUtil.getParameter(request, prefix + "bkg_crnt_amt", ""));
		setAcProcDesc(JSPUtil.getParameter(request, prefix + "ac_proc_desc", ""));
		setFfCmpnSeq(JSPUtil.getParameter(request, prefix + "ff_cmpn_seq", ""));
		setBkgFfSeq(JSPUtil.getParameter(request, prefix + "bkg_ff_seq", ""));
		setBrogBxRt(JSPUtil.getParameter(request, prefix + "brog_bx_rt", ""));
		setSearchBrogCntCustSeq(JSPUtil.getParameter(request, prefix + "search_brog_cnt_cust_seq", ""));
		setFfCmpnRmk(JSPUtil.getParameter(request, prefix + "ff_cmpn_rmk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FFCmpnAuditVO[]
	 */
	public FFCmpnAuditVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FFCmpnAuditVO[]
	 */
	public FFCmpnAuditVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FFCmpnAuditVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ifDt = (JSPUtil.getParameter(request, prefix	+ "if_dt", length));
			String[] ffBxAmt = (JSPUtil.getParameter(request, prefix	+ "ff_bx_amt", length));
			String[] vndrCntCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cnt_cd", length));
			String[] actCommAble = (JSPUtil.getParameter(request, prefix	+ "act_comm_able", length));
			String[] brogTeuRt = (JSPUtil.getParameter(request, prefix	+ "brog_teu_rt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ffAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "ff_agmt_seq", length));
			String[] cntrCrntAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_crnt_amt", length));
			String[] ffRefNo = (JSPUtil.getParameter(request, prefix	+ "ff_ref_no", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] dateOption = (JSPUtil.getParameter(request, prefix	+ "date_option", length));
			String[] bkgFfCntCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ff_cnt_cd", length));
			String[] bkgRfQty = (JSPUtil.getParameter(request, prefix	+ "bkg_rf_qty", length));
			String[] vslDepDt = (JSPUtil.getParameter(request, prefix	+ "vsl_dep_dt", length));
			String[] vndrCntSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_cnt_seq", length));
			String[] brogRfRt = (JSPUtil.getParameter(request, prefix	+ "brog_rf_rt", length));
			String[] frtFwrdCntSeq = (JSPUtil.getParameter(request, prefix	+ "frt_fwrd_cnt_seq", length));
			String[] commVvd = (JSPUtil.getParameter(request, prefix	+ "comm_vvd", length));
			String[] dateTo = (JSPUtil.getParameter(request, prefix	+ "date_to", length));
			String[] ppdAmt = (JSPUtil.getParameter(request, prefix	+ "ppd_amt", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] ifAmt = (JSPUtil.getParameter(request, prefix	+ "if_amt", length));
			String[] bkgTeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_teu_qty", length));
			String[] dateFm = (JSPUtil.getParameter(request, prefix	+ "date_fm", length));
			String[] ifOpt = (JSPUtil.getParameter(request, prefix	+ "if_opt", length));
			String[] ffFeuAmt = (JSPUtil.getParameter(request, prefix	+ "ff_feu_amt", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] ffCmpnStsCd = (JSPUtil.getParameter(request, prefix	+ "ff_cmpn_sts_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fmcNo = (JSPUtil.getParameter(request, prefix	+ "fmc_no", length));
			String[] bkgFeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_feu_qty", length));
			String[] ffTeuAmt = (JSPUtil.getParameter(request, prefix	+ "ff_teu_amt", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] ffRfAmt = (JSPUtil.getParameter(request, prefix	+ "ff_rf_amt", length));
			String[] crntAmt = (JSPUtil.getParameter(request, prefix	+ "crnt_amt", length));
			String[] dateDiv = (JSPUtil.getParameter(request, prefix	+ "date_div", length));
			String[] bkgBxQty = (JSPUtil.getParameter(request, prefix	+ "bkg_bx_qty", length));
			String[] brogFeuRt = (JSPUtil.getParameter(request, prefix	+ "brog_feu_rt", length));
			String[] ffBkgRt = (JSPUtil.getParameter(request, prefix	+ "ff_bkg_rt", length));
			String[] bkgCrntAmt = (JSPUtil.getParameter(request, prefix	+ "bkg_crnt_amt", length));
			String[] acProcDesc = (JSPUtil.getParameter(request, prefix	+ "ac_proc_desc", length));
			String[] ffCmpnSeq = (JSPUtil.getParameter(request, prefix	+ "ff_cmpn_seq", length));
			String[] bkgFfSeq = (JSPUtil.getParameter(request, prefix	+ "bkg_ff_seq", length));
			String[] brogBxRt = (JSPUtil.getParameter(request, prefix	+ "brog_bx_rt", length));
			String[] searchBrogCntCustSeq = (JSPUtil.getParameter(request, prefix	+ "search_brog_cnt_cust_seq", length));
			String[] ffCmpnRmk = (JSPUtil.getParameter(request, prefix	+ "ff_cmpn_rmk", length));
			
			for (int i = 0; i < length; i++) {
				model = new FFCmpnAuditVO();
				if (ifDt[i] != null)
					model.setIfDt(ifDt[i]);
				if (ffBxAmt[i] != null)
					model.setFfBxAmt(ffBxAmt[i]);
				if (vndrCntCd[i] != null)
					model.setVndrCntCd(vndrCntCd[i]);
				if (actCommAble[i] != null)
					model.setActCommAble(actCommAble[i]);
				if (brogTeuRt[i] != null)
					model.setBrogTeuRt(brogTeuRt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ffAgmtSeq[i] != null)
					model.setFfAgmtSeq(ffAgmtSeq[i]);
				if (cntrCrntAmt[i] != null)
					model.setCntrCrntAmt(cntrCrntAmt[i]);
				if (ffRefNo[i] != null)
					model.setFfRefNo(ffRefNo[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (dateOption[i] != null)
					model.setDateOption(dateOption[i]);
				if (bkgFfCntCd[i] != null)
					model.setBkgFfCntCd(bkgFfCntCd[i]);
				if (bkgRfQty[i] != null)
					model.setBkgRfQty(bkgRfQty[i]);
				if (vslDepDt[i] != null)
					model.setVslDepDt(vslDepDt[i]);
				if (vndrCntSeq[i] != null)
					model.setVndrCntSeq(vndrCntSeq[i]);
				if (brogRfRt[i] != null)
					model.setBrogRfRt(brogRfRt[i]);
				if (frtFwrdCntSeq[i] != null)
					model.setFrtFwrdCntSeq(frtFwrdCntSeq[i]);
				if (commVvd[i] != null)
					model.setCommVvd(commVvd[i]);
				if (dateTo[i] != null)
					model.setDateTo(dateTo[i]);
				if (ppdAmt[i] != null)
					model.setPpdAmt(ppdAmt[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (ifAmt[i] != null)
					model.setIfAmt(ifAmt[i]);
				if (bkgTeuQty[i] != null)
					model.setBkgTeuQty(bkgTeuQty[i]);
				if (dateFm[i] != null)
					model.setDateFm(dateFm[i]);
				if (ifOpt[i] != null)
					model.setIfOpt(ifOpt[i]);
				if (ffFeuAmt[i] != null)
					model.setFfFeuAmt(ffFeuAmt[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (ffCmpnStsCd[i] != null)
					model.setFfCmpnStsCd(ffCmpnStsCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fmcNo[i] != null)
					model.setFmcNo(fmcNo[i]);
				if (bkgFeuQty[i] != null)
					model.setBkgFeuQty(bkgFeuQty[i]);
				if (ffTeuAmt[i] != null)
					model.setFfTeuAmt(ffTeuAmt[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (ffRfAmt[i] != null)
					model.setFfRfAmt(ffRfAmt[i]);
				if (crntAmt[i] != null)
					model.setCrntAmt(crntAmt[i]);
				if (dateDiv[i] != null)
					model.setDateDiv(dateDiv[i]);
				if (bkgBxQty[i] != null)
					model.setBkgBxQty(bkgBxQty[i]);
				if (brogFeuRt[i] != null)
					model.setBrogFeuRt(brogFeuRt[i]);
				if (ffBkgRt[i] != null)
					model.setFfBkgRt(ffBkgRt[i]);
				if (bkgCrntAmt[i] != null)
					model.setBkgCrntAmt(bkgCrntAmt[i]);
				if (acProcDesc[i] != null)
					model.setAcProcDesc(acProcDesc[i]);
				if (ffCmpnSeq[i] != null)
					model.setFfCmpnSeq(ffCmpnSeq[i]);
				if (bkgFfSeq[i] != null)
					model.setBkgFfSeq(bkgFfSeq[i]);
				if (brogBxRt[i] != null)
					model.setBrogBxRt(brogBxRt[i]);
				if (searchBrogCntCustSeq[i] != null)
					model.setSearchBrogCntCustSeq(searchBrogCntCustSeq[i]);
				if (ffCmpnRmk[i] != null)
					model.setFfCmpnRmk(ffCmpnRmk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFFCmpnAuditVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FFCmpnAuditVO[]
	 */
	public FFCmpnAuditVO[] getFFCmpnAuditVOs(){
		FFCmpnAuditVO[] vos = (FFCmpnAuditVO[])models.toArray(new FFCmpnAuditVO[models.size()]);
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
		this.ifDt = this.ifDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffBxAmt = this.ffBxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCntCd = this.vndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCommAble = this.actCommAble .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brogTeuRt = this.brogTeuRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffAgmtSeq = this.ffAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCrntAmt = this.cntrCrntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffRefNo = this.ffRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateOption = this.dateOption .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFfCntCd = this.bkgFfCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRfQty = this.bkgRfQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDepDt = this.vslDepDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCntSeq = this.vndrCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brogRfRt = this.brogRfRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtFwrdCntSeq = this.frtFwrdCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commVvd = this.commVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateTo = this.dateTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdAmt = this.ppdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifAmt = this.ifAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTeuQty = this.bkgTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateFm = this.dateFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifOpt = this.ifOpt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffFeuAmt = this.ffFeuAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCmpnStsCd = this.ffCmpnStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmcNo = this.fmcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFeuQty = this.bkgFeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffTeuAmt = this.ffTeuAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffRfAmt = this.ffRfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntAmt = this.crntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateDiv = this.dateDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgBxQty = this.bkgBxQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brogFeuRt = this.brogFeuRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffBkgRt = this.ffBkgRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCrntAmt = this.bkgCrntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acProcDesc = this.acProcDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCmpnSeq = this.ffCmpnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFfSeq = this.bkgFfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brogBxRt = this.brogBxRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchBrogCntCustSeq = this.searchBrogCntCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCmpnRmk = this.ffCmpnRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
