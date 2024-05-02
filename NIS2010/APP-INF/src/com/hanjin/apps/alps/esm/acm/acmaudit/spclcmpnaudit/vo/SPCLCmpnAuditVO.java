/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SPCLCmpnAuditVO.java
*@FileTitle : SPCLCmpnAuditVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.05
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.06.05 김영오 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.acm.acmaudit.spclcmpnaudit.vo;

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

public class SPCLCmpnAuditVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SPCLCmpnAuditVO> models = new ArrayList<SPCLCmpnAuditVO>();
	
	/* Column Info */
	private String dateFm = null;
	/* Column Info */
	private String ifDt = null;
	/* Column Info */
	private String spclRfTeuAmt = null;
	/* Column Info */
	private String hidPayChk = null;
	/* Column Info */
	private String ifOpt = null;
	/* Column Info */
	private String spclTeuAmt = null;
	/* Column Info */
	private String spclCmpnRmk = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String spclCmpnSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String actCommAble = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String stsCd = null;
	/* Column Info */
	private String bkgFeuQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String multiVvd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String spclFeuAmt = null;
	/* Column Info */
	private String actCommAmt = null;
	/* Column Info */
	private String spclCmpnStsCd = null;
	/* Column Info */
	private String dateDiv = null;
	/* Column Info */
	private String bkgBxQty = null;
	/* Column Info */
	private String vslDepDt = null;
	/* Column Info */
	private String vndrCntSeq = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String spclCntCustSeq = null;
	/* Column Info */
	private String spclOfcCd = null;
	/* Column Info */
	private String spclAgmtSeq = null;
	/* Column Info */
	private String spclRfFeuAmt = null;
	/* Column Info */
	private String dateTo = null;
	/* Column Info */
	private String cntrCommAmt = null;
	/* Column Info */
	private String ppdAmt = null;
	/* Column Info */
	private String payChk = null;
	/* Column Info */
	private String spclBxAmt = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String custCntCdSeq = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String bkgTeuQty = null;
	/* Column Info */
	private String ifAmt = null;
	/* Column Info */
	private String vvdDiv = null;
	/* Column Info */
	private String spclBkgRt = null;
	/* Column Info */
	private String bkgRfFeuQty = null;
	/* Column Info */
	private String bkgRfTeuQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SPCLCmpnAuditVO() {}

	public SPCLCmpnAuditVO(String ibflag, String pagerows, String ifOpt, String vvdCd, String vvdDiv, String spclCntCustSeq, String hidPayChk, String spclAgmtSeq, String custCntCd, String spclOfcCd, String usrId, String arOfcCd, String dateFm, String dateTo, String dateDiv, String blNo, String multiVvd, String stsCd, String ifDt, String bkgStsCd, String spclRfTeuAmt, String spclTeuAmt, String spclCmpnRmk, String spclCmpnSeq, String creDt, String actCommAble, String bkgFeuQty, String spclFeuAmt, String spclCmpnStsCd, String actCommAmt, String bkgBxQty, String vslDepDt, String vndrCntSeq, String spclRfFeuAmt, String cntrCommAmt, String ppdAmt, String payChk, String spclBxAmt, String custLglEngNm, String vvd, String custCntCdSeq, String bkgNo, String ifAmt, String bkgTeuQty, String spclBkgRt, String bkgRfTeuQty, String bkgRfFeuQty) {
		this.dateFm = dateFm;
		this.ifDt = ifDt;
		this.spclRfTeuAmt = spclRfTeuAmt;
		this.hidPayChk = hidPayChk;
		this.ifOpt = ifOpt;
		this.spclTeuAmt = spclTeuAmt;
		this.spclCmpnRmk = spclCmpnRmk;
		this.bkgStsCd = bkgStsCd;
		this.spclCmpnSeq = spclCmpnSeq;
		this.creDt = creDt;
		this.actCommAble = actCommAble;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.stsCd = stsCd;
		this.bkgFeuQty = bkgFeuQty;
		this.ibflag = ibflag;
		this.vvdCd = vvdCd;
		this.multiVvd = multiVvd;
		this.usrId = usrId;
		this.spclFeuAmt = spclFeuAmt;
		this.actCommAmt = actCommAmt;
		this.spclCmpnStsCd = spclCmpnStsCd;
		this.dateDiv = dateDiv;
		this.bkgBxQty = bkgBxQty;
		this.vslDepDt = vslDepDt;
		this.vndrCntSeq = vndrCntSeq;
		this.custCntCd = custCntCd;
		this.spclCntCustSeq = spclCntCustSeq;
		this.spclOfcCd = spclOfcCd;
		this.spclAgmtSeq = spclAgmtSeq;
		this.spclRfFeuAmt = spclRfFeuAmt;
		this.dateTo = dateTo;
		this.cntrCommAmt = cntrCommAmt;
		this.ppdAmt = ppdAmt;
		this.payChk = payChk;
		this.spclBxAmt = spclBxAmt;
		this.arOfcCd = arOfcCd;
		this.custLglEngNm = custLglEngNm;
		this.vvd = vvd;
		this.custCntCdSeq = custCntCdSeq;
		this.bkgNo = bkgNo;
		this.bkgTeuQty = bkgTeuQty;
		this.ifAmt = ifAmt;
		this.vvdDiv = vvdDiv;
		this.spclBkgRt = spclBkgRt;
		this.bkgRfFeuQty = bkgRfFeuQty;
		this.bkgRfTeuQty = bkgRfTeuQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("date_fm", getDateFm());
		this.hashColumns.put("if_dt", getIfDt());
		this.hashColumns.put("spcl_rf_teu_amt", getSpclRfTeuAmt());
		this.hashColumns.put("hid_pay_chk", getHidPayChk());
		this.hashColumns.put("if_opt", getIfOpt());
		this.hashColumns.put("spcl_teu_amt", getSpclTeuAmt());
		this.hashColumns.put("spcl_cmpn_rmk", getSpclCmpnRmk());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("spcl_cmpn_seq", getSpclCmpnSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("act_comm_able", getActCommAble());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sts_cd", getStsCd());
		this.hashColumns.put("bkg_feu_qty", getBkgFeuQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("multi_vvd", getMultiVvd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("spcl_feu_amt", getSpclFeuAmt());
		this.hashColumns.put("act_comm_amt", getActCommAmt());
		this.hashColumns.put("spcl_cmpn_sts_cd", getSpclCmpnStsCd());
		this.hashColumns.put("date_div", getDateDiv());
		this.hashColumns.put("bkg_bx_qty", getBkgBxQty());
		this.hashColumns.put("vsl_dep_dt", getVslDepDt());
		this.hashColumns.put("vndr_cnt_seq", getVndrCntSeq());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("spcl_cnt_cust_seq", getSpclCntCustSeq());
		this.hashColumns.put("spcl_ofc_cd", getSpclOfcCd());
		this.hashColumns.put("spcl_agmt_seq", getSpclAgmtSeq());
		this.hashColumns.put("spcl_rf_feu_amt", getSpclRfFeuAmt());
		this.hashColumns.put("date_to", getDateTo());
		this.hashColumns.put("cntr_comm_amt", getCntrCommAmt());
		this.hashColumns.put("ppd_amt", getPpdAmt());
		this.hashColumns.put("pay_chk", getPayChk());
		this.hashColumns.put("spcl_bx_amt", getSpclBxAmt());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("cust_cnt_cd_seq", getCustCntCdSeq());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("bkg_teu_qty", getBkgTeuQty());
		this.hashColumns.put("if_amt", getIfAmt());
		this.hashColumns.put("vvd_div", getVvdDiv());
		this.hashColumns.put("spcl_bkg_rt", getSpclBkgRt());
		this.hashColumns.put("bkg_rf_feu_qty", getBkgRfFeuQty());
		this.hashColumns.put("bkg_rf_teu_qty", getBkgRfTeuQty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("date_fm", "dateFm");
		this.hashFields.put("if_dt", "ifDt");
		this.hashFields.put("spcl_rf_teu_amt", "spclRfTeuAmt");
		this.hashFields.put("hid_pay_chk", "hidPayChk");
		this.hashFields.put("if_opt", "ifOpt");
		this.hashFields.put("spcl_teu_amt", "spclTeuAmt");
		this.hashFields.put("spcl_cmpn_rmk", "spclCmpnRmk");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("spcl_cmpn_seq", "spclCmpnSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("act_comm_able", "actCommAble");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sts_cd", "stsCd");
		this.hashFields.put("bkg_feu_qty", "bkgFeuQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("multi_vvd", "multiVvd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("spcl_feu_amt", "spclFeuAmt");
		this.hashFields.put("act_comm_amt", "actCommAmt");
		this.hashFields.put("spcl_cmpn_sts_cd", "spclCmpnStsCd");
		this.hashFields.put("date_div", "dateDiv");
		this.hashFields.put("bkg_bx_qty", "bkgBxQty");
		this.hashFields.put("vsl_dep_dt", "vslDepDt");
		this.hashFields.put("vndr_cnt_seq", "vndrCntSeq");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("spcl_cnt_cust_seq", "spclCntCustSeq");
		this.hashFields.put("spcl_ofc_cd", "spclOfcCd");
		this.hashFields.put("spcl_agmt_seq", "spclAgmtSeq");
		this.hashFields.put("spcl_rf_feu_amt", "spclRfFeuAmt");
		this.hashFields.put("date_to", "dateTo");
		this.hashFields.put("cntr_comm_amt", "cntrCommAmt");
		this.hashFields.put("ppd_amt", "ppdAmt");
		this.hashFields.put("pay_chk", "payChk");
		this.hashFields.put("spcl_bx_amt", "spclBxAmt");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("cust_cnt_cd_seq", "custCntCdSeq");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("bkg_teu_qty", "bkgTeuQty");
		this.hashFields.put("if_amt", "ifAmt");
		this.hashFields.put("vvd_div", "vvdDiv");
		this.hashFields.put("spcl_bkg_rt", "spclBkgRt");
		this.hashFields.put("bkg_rf_feu_qty", "bkgRfFeuQty");
		this.hashFields.put("bkg_rf_teu_qty", "bkgRfTeuQty");
		return this.hashFields;
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
	 * @return ifDt
	 */
	public String getIfDt() {
		return this.ifDt;
	}
	
	/**
	 * Column Info
	 * @return spclRfTeuAmt
	 */
	public String getSpclRfTeuAmt() {
		return this.spclRfTeuAmt;
	}
	
	/**
	 * Column Info
	 * @return hidPayChk
	 */
	public String getHidPayChk() {
		return this.hidPayChk;
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
	 * @return spclTeuAmt
	 */
	public String getSpclTeuAmt() {
		return this.spclTeuAmt;
	}
	
	/**
	 * Column Info
	 * @return spclCmpnRmk
	 */
	public String getSpclCmpnRmk() {
		return this.spclCmpnRmk;
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
	 * @return spclCmpnSeq
	 */
	public String getSpclCmpnSeq() {
		return this.spclCmpnSeq;
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
	 * @return bkgFeuQty
	 */
	public String getBkgFeuQty() {
		return this.bkgFeuQty;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return spclFeuAmt
	 */
	public String getSpclFeuAmt() {
		return this.spclFeuAmt;
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
	 * @return spclCmpnStsCd
	 */
	public String getSpclCmpnStsCd() {
		return this.spclCmpnStsCd;
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
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return spclCntCustSeq
	 */
	public String getSpclCntCustSeq() {
		return this.spclCntCustSeq;
	}
	
	/**
	 * Column Info
	 * @return spclOfcCd
	 */
	public String getSpclOfcCd() {
		return this.spclOfcCd;
	}
	
	/**
	 * Column Info
	 * @return spclAgmtSeq
	 */
	public String getSpclAgmtSeq() {
		return this.spclAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @return spclRfFeuAmt
	 */
	public String getSpclRfFeuAmt() {
		return this.spclRfFeuAmt;
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
	 * @return cntrCommAmt
	 */
	public String getCntrCommAmt() {
		return this.cntrCommAmt;
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
	 * @return payChk
	 */
	public String getPayChk() {
		return this.payChk;
	}
	
	/**
	 * Column Info
	 * @return spclBxAmt
	 */
	public String getSpclBxAmt() {
		return this.spclBxAmt;
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
	 * @return custCntCdSeq
	 */
	public String getCustCntCdSeq() {
		return this.custCntCdSeq;
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
	 * @return ifAmt
	 */
	public String getIfAmt() {
		return this.ifAmt;
	}
	
	/**
	 * Column Info
	 * @return vvdDiv
	 */
	public String getVvdDiv() {
		return this.vvdDiv;
	}
	
	/**
	 * Column Info
	 * @return spclBkgRt
	 */
	public String getSpclBkgRt() {
		return this.spclBkgRt;
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
	 * @return bkgRfTeuQty
	 */
	public String getBkgRfTeuQty() {
		return this.bkgRfTeuQty;
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
	 * @param ifDt
	 */
	public void setIfDt(String ifDt) {
		this.ifDt = ifDt;
	}
	
	/**
	 * Column Info
	 * @param spclRfTeuAmt
	 */
	public void setSpclRfTeuAmt(String spclRfTeuAmt) {
		this.spclRfTeuAmt = spclRfTeuAmt;
	}
	
	/**
	 * Column Info
	 * @param hidPayChk
	 */
	public void setHidPayChk(String hidPayChk) {
		this.hidPayChk = hidPayChk;
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
	 * @param spclTeuAmt
	 */
	public void setSpclTeuAmt(String spclTeuAmt) {
		this.spclTeuAmt = spclTeuAmt;
	}
	
	/**
	 * Column Info
	 * @param spclCmpnRmk
	 */
	public void setSpclCmpnRmk(String spclCmpnRmk) {
		this.spclCmpnRmk = spclCmpnRmk;
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
	 * @param spclCmpnSeq
	 */
	public void setSpclCmpnSeq(String spclCmpnSeq) {
		this.spclCmpnSeq = spclCmpnSeq;
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
	 * @param bkgFeuQty
	 */
	public void setBkgFeuQty(String bkgFeuQty) {
		this.bkgFeuQty = bkgFeuQty;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param multiVvd
	 */
	public void setMultiVvd(String multiVvd) {
		this.multiVvd = multiVvd;
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
	 * @param spclFeuAmt
	 */
	public void setSpclFeuAmt(String spclFeuAmt) {
		this.spclFeuAmt = spclFeuAmt;
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
	 * @param spclCmpnStsCd
	 */
	public void setSpclCmpnStsCd(String spclCmpnStsCd) {
		this.spclCmpnStsCd = spclCmpnStsCd;
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
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param spclCntCustSeq
	 */
	public void setSpclCntCustSeq(String spclCntCustSeq) {
		this.spclCntCustSeq = spclCntCustSeq;
	}
	
	/**
	 * Column Info
	 * @param spclOfcCd
	 */
	public void setSpclOfcCd(String spclOfcCd) {
		this.spclOfcCd = spclOfcCd;
	}
	
	/**
	 * Column Info
	 * @param spclAgmtSeq
	 */
	public void setSpclAgmtSeq(String spclAgmtSeq) {
		this.spclAgmtSeq = spclAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @param spclRfFeuAmt
	 */
	public void setSpclRfFeuAmt(String spclRfFeuAmt) {
		this.spclRfFeuAmt = spclRfFeuAmt;
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
	 * @param cntrCommAmt
	 */
	public void setCntrCommAmt(String cntrCommAmt) {
		this.cntrCommAmt = cntrCommAmt;
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
	 * @param payChk
	 */
	public void setPayChk(String payChk) {
		this.payChk = payChk;
	}
	
	/**
	 * Column Info
	 * @param spclBxAmt
	 */
	public void setSpclBxAmt(String spclBxAmt) {
		this.spclBxAmt = spclBxAmt;
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
	 * @param custCntCdSeq
	 */
	public void setCustCntCdSeq(String custCntCdSeq) {
		this.custCntCdSeq = custCntCdSeq;
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
	 * @param ifAmt
	 */
	public void setIfAmt(String ifAmt) {
		this.ifAmt = ifAmt;
	}
	
	/**
	 * Column Info
	 * @param vvdDiv
	 */
	public void setVvdDiv(String vvdDiv) {
		this.vvdDiv = vvdDiv;
	}
	
	/**
	 * Column Info
	 * @param spclBkgRt
	 */
	public void setSpclBkgRt(String spclBkgRt) {
		this.spclBkgRt = spclBkgRt;
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
	 * @param bkgRfTeuQty
	 */
	public void setBkgRfTeuQty(String bkgRfTeuQty) {
		this.bkgRfTeuQty = bkgRfTeuQty;
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
		setDateFm(JSPUtil.getParameter(request, prefix + "date_fm", ""));
		setIfDt(JSPUtil.getParameter(request, prefix + "if_dt", ""));
		setSpclRfTeuAmt(JSPUtil.getParameter(request, prefix + "spcl_rf_teu_amt", ""));
		setHidPayChk(JSPUtil.getParameter(request, prefix + "hid_pay_chk", ""));
		setIfOpt(JSPUtil.getParameter(request, prefix + "if_opt", ""));
		setSpclTeuAmt(JSPUtil.getParameter(request, prefix + "spcl_teu_amt", ""));
		setSpclCmpnRmk(JSPUtil.getParameter(request, prefix + "spcl_cmpn_rmk", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setSpclCmpnSeq(JSPUtil.getParameter(request, prefix + "spcl_cmpn_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setActCommAble(JSPUtil.getParameter(request, prefix + "act_comm_able", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setStsCd(JSPUtil.getParameter(request, prefix + "sts_cd", ""));
		setBkgFeuQty(JSPUtil.getParameter(request, prefix + "bkg_feu_qty", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setMultiVvd(JSPUtil.getParameter(request, prefix + "multi_vvd", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setSpclFeuAmt(JSPUtil.getParameter(request, prefix + "spcl_feu_amt", ""));
		setActCommAmt(JSPUtil.getParameter(request, prefix + "act_comm_amt", ""));
		setSpclCmpnStsCd(JSPUtil.getParameter(request, prefix + "spcl_cmpn_sts_cd", ""));
		setDateDiv(JSPUtil.getParameter(request, prefix + "date_div", ""));
		setBkgBxQty(JSPUtil.getParameter(request, prefix + "bkg_bx_qty", ""));
		setVslDepDt(JSPUtil.getParameter(request, prefix + "vsl_dep_dt", ""));
		setVndrCntSeq(JSPUtil.getParameter(request, prefix + "vndr_cnt_seq", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setSpclCntCustSeq(JSPUtil.getParameter(request, prefix + "spcl_cnt_cust_seq", ""));
		setSpclOfcCd(JSPUtil.getParameter(request, prefix + "spcl_ofc_cd", ""));
		setSpclAgmtSeq(JSPUtil.getParameter(request, prefix + "spcl_agmt_seq", ""));
		setSpclRfFeuAmt(JSPUtil.getParameter(request, prefix + "spcl_rf_feu_amt", ""));
		setDateTo(JSPUtil.getParameter(request, prefix + "date_to", ""));
		setCntrCommAmt(JSPUtil.getParameter(request, prefix + "cntr_comm_amt", ""));
		setPpdAmt(JSPUtil.getParameter(request, prefix + "ppd_amt", ""));
		setPayChk(JSPUtil.getParameter(request, prefix + "pay_chk", ""));
		setSpclBxAmt(JSPUtil.getParameter(request, prefix + "spcl_bx_amt", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setCustCntCdSeq(JSPUtil.getParameter(request, prefix + "cust_cnt_cd_seq", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setBkgTeuQty(JSPUtil.getParameter(request, prefix + "bkg_teu_qty", ""));
		setIfAmt(JSPUtil.getParameter(request, prefix + "if_amt", ""));
		setVvdDiv(JSPUtil.getParameter(request, prefix + "vvd_div", ""));
		setSpclBkgRt(JSPUtil.getParameter(request, prefix + "spcl_bkg_rt", ""));
		setBkgRfFeuQty(JSPUtil.getParameter(request, prefix + "bkg_rf_feu_qty", ""));
		setBkgRfTeuQty(JSPUtil.getParameter(request, prefix + "bkg_rf_teu_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SPCLCmpnAuditVO[]
	 */
	public SPCLCmpnAuditVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SPCLCmpnAuditVO[]
	 */
	public SPCLCmpnAuditVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SPCLCmpnAuditVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dateFm = (JSPUtil.getParameter(request, prefix	+ "date_fm", length));
			String[] ifDt = (JSPUtil.getParameter(request, prefix	+ "if_dt", length));
			String[] spclRfTeuAmt = (JSPUtil.getParameter(request, prefix	+ "spcl_rf_teu_amt", length));
			String[] hidPayChk = (JSPUtil.getParameter(request, prefix	+ "hid_pay_chk", length));
			String[] ifOpt = (JSPUtil.getParameter(request, prefix	+ "if_opt", length));
			String[] spclTeuAmt = (JSPUtil.getParameter(request, prefix	+ "spcl_teu_amt", length));
			String[] spclCmpnRmk = (JSPUtil.getParameter(request, prefix	+ "spcl_cmpn_rmk", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] spclCmpnSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_cmpn_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] actCommAble = (JSPUtil.getParameter(request, prefix	+ "act_comm_able", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] stsCd = (JSPUtil.getParameter(request, prefix	+ "sts_cd", length));
			String[] bkgFeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_feu_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] multiVvd = (JSPUtil.getParameter(request, prefix	+ "multi_vvd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] spclFeuAmt = (JSPUtil.getParameter(request, prefix	+ "spcl_feu_amt", length));
			String[] actCommAmt = (JSPUtil.getParameter(request, prefix	+ "act_comm_amt", length));
			String[] spclCmpnStsCd = (JSPUtil.getParameter(request, prefix	+ "spcl_cmpn_sts_cd", length));
			String[] dateDiv = (JSPUtil.getParameter(request, prefix	+ "date_div", length));
			String[] bkgBxQty = (JSPUtil.getParameter(request, prefix	+ "bkg_bx_qty", length));
			String[] vslDepDt = (JSPUtil.getParameter(request, prefix	+ "vsl_dep_dt", length));
			String[] vndrCntSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_cnt_seq", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] spclCntCustSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_cnt_cust_seq", length));
			String[] spclOfcCd = (JSPUtil.getParameter(request, prefix	+ "spcl_ofc_cd", length));
			String[] spclAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_agmt_seq", length));
			String[] spclRfFeuAmt = (JSPUtil.getParameter(request, prefix	+ "spcl_rf_feu_amt", length));
			String[] dateTo = (JSPUtil.getParameter(request, prefix	+ "date_to", length));
			String[] cntrCommAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_comm_amt", length));
			String[] ppdAmt = (JSPUtil.getParameter(request, prefix	+ "ppd_amt", length));
			String[] payChk = (JSPUtil.getParameter(request, prefix	+ "pay_chk", length));
			String[] spclBxAmt = (JSPUtil.getParameter(request, prefix	+ "spcl_bx_amt", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] custCntCdSeq = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd_seq", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] bkgTeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_teu_qty", length));
			String[] ifAmt = (JSPUtil.getParameter(request, prefix	+ "if_amt", length));
			String[] vvdDiv = (JSPUtil.getParameter(request, prefix	+ "vvd_div", length));
			String[] spclBkgRt = (JSPUtil.getParameter(request, prefix	+ "spcl_bkg_rt", length));
			String[] bkgRfFeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_rf_feu_qty", length));
			String[] bkgRfTeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_rf_teu_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new SPCLCmpnAuditVO();
				if (dateFm[i] != null)
					model.setDateFm(dateFm[i]);
				if (ifDt[i] != null)
					model.setIfDt(ifDt[i]);
				if (spclRfTeuAmt[i] != null)
					model.setSpclRfTeuAmt(spclRfTeuAmt[i]);
				if (hidPayChk[i] != null)
					model.setHidPayChk(hidPayChk[i]);
				if (ifOpt[i] != null)
					model.setIfOpt(ifOpt[i]);
				if (spclTeuAmt[i] != null)
					model.setSpclTeuAmt(spclTeuAmt[i]);
				if (spclCmpnRmk[i] != null)
					model.setSpclCmpnRmk(spclCmpnRmk[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (spclCmpnSeq[i] != null)
					model.setSpclCmpnSeq(spclCmpnSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (actCommAble[i] != null)
					model.setActCommAble(actCommAble[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (stsCd[i] != null)
					model.setStsCd(stsCd[i]);
				if (bkgFeuQty[i] != null)
					model.setBkgFeuQty(bkgFeuQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (multiVvd[i] != null)
					model.setMultiVvd(multiVvd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (spclFeuAmt[i] != null)
					model.setSpclFeuAmt(spclFeuAmt[i]);
				if (actCommAmt[i] != null)
					model.setActCommAmt(actCommAmt[i]);
				if (spclCmpnStsCd[i] != null)
					model.setSpclCmpnStsCd(spclCmpnStsCd[i]);
				if (dateDiv[i] != null)
					model.setDateDiv(dateDiv[i]);
				if (bkgBxQty[i] != null)
					model.setBkgBxQty(bkgBxQty[i]);
				if (vslDepDt[i] != null)
					model.setVslDepDt(vslDepDt[i]);
				if (vndrCntSeq[i] != null)
					model.setVndrCntSeq(vndrCntSeq[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (spclCntCustSeq[i] != null)
					model.setSpclCntCustSeq(spclCntCustSeq[i]);
				if (spclOfcCd[i] != null)
					model.setSpclOfcCd(spclOfcCd[i]);
				if (spclAgmtSeq[i] != null)
					model.setSpclAgmtSeq(spclAgmtSeq[i]);
				if (spclRfFeuAmt[i] != null)
					model.setSpclRfFeuAmt(spclRfFeuAmt[i]);
				if (dateTo[i] != null)
					model.setDateTo(dateTo[i]);
				if (cntrCommAmt[i] != null)
					model.setCntrCommAmt(cntrCommAmt[i]);
				if (ppdAmt[i] != null)
					model.setPpdAmt(ppdAmt[i]);
				if (payChk[i] != null)
					model.setPayChk(payChk[i]);
				if (spclBxAmt[i] != null)
					model.setSpclBxAmt(spclBxAmt[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (custCntCdSeq[i] != null)
					model.setCustCntCdSeq(custCntCdSeq[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (bkgTeuQty[i] != null)
					model.setBkgTeuQty(bkgTeuQty[i]);
				if (ifAmt[i] != null)
					model.setIfAmt(ifAmt[i]);
				if (vvdDiv[i] != null)
					model.setVvdDiv(vvdDiv[i]);
				if (spclBkgRt[i] != null)
					model.setSpclBkgRt(spclBkgRt[i]);
				if (bkgRfFeuQty[i] != null)
					model.setBkgRfFeuQty(bkgRfFeuQty[i]);
				if (bkgRfTeuQty[i] != null)
					model.setBkgRfTeuQty(bkgRfTeuQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSPCLCmpnAuditVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SPCLCmpnAuditVO[]
	 */
	public SPCLCmpnAuditVO[] getSPCLCmpnAuditVOs(){
		SPCLCmpnAuditVO[] vos = (SPCLCmpnAuditVO[])models.toArray(new SPCLCmpnAuditVO[models.size()]);
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
		this.dateFm = this.dateFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifDt = this.ifDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclRfTeuAmt = this.spclRfTeuAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidPayChk = this.hidPayChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifOpt = this.ifOpt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclTeuAmt = this.spclTeuAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCmpnRmk = this.spclCmpnRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCmpnSeq = this.spclCmpnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCommAble = this.actCommAble .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsCd = this.stsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFeuQty = this.bkgFeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.multiVvd = this.multiVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclFeuAmt = this.spclFeuAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCommAmt = this.actCommAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCmpnStsCd = this.spclCmpnStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateDiv = this.dateDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgBxQty = this.bkgBxQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDepDt = this.vslDepDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCntSeq = this.vndrCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCntCustSeq = this.spclCntCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclOfcCd = this.spclOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclAgmtSeq = this.spclAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclRfFeuAmt = this.spclRfFeuAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateTo = this.dateTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCommAmt = this.cntrCommAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdAmt = this.ppdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payChk = this.payChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclBxAmt = this.spclBxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCdSeq = this.custCntCdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTeuQty = this.bkgTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifAmt = this.ifAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdDiv = this.vvdDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclBkgRt = this.spclBkgRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRfFeuQty = this.bkgRfFeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRfTeuQty = this.bkgRfTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
