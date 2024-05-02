/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : InvoicePayScheduleListVO.java
*@FileTitle : InvoicePayScheduleListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.02  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvoicePayScheduleListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvoicePayScheduleListVO> models = new ArrayList<InvoicePayScheduleListVO>();
	
	/* Column Info */
	private String bankAcctNo = null;
	/* Column Info */
	private String payGrsAmt = null;
	/* Column Info */
	private String attrCtnt10 = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String attrCtnt14 = null;
	/* Column Info */
	private String paySkdNo = null;
	/* Column Info */
	private String attrCtnt9 = null;
	/* Column Info */
	private String attrCtnt8 = null;
	/* Column Info */
	private String attrCtnt13 = null;
	/* Column Info */
	private String invSeq = null;
	/* Column Info */
	private String attrCtnt12 = null;
	/* Column Info */
	private String payRmnAmt = null;
	/* Column Info */
	private String attrCtnt11 = null;
	/* Column Info */
	private String payBatRunSeq = null;
	/* Column Info */
	private String attrCtnt15 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String payPrioCd = null;
	/* Column Info */
	private String attrCtnt1 = null;
	/* Column Info */
	private String invHldFlg = null;
	/* Column Info */
	private String orgInvHldFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String attrCtnt2 = null;
	/* Column Info */
	private String attrCtnt3 = null;
	/* Column Info */
	private String attrCtnt4 = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String attrCtnt5 = null;
	/* Column Info */
	private String attrCtnt6 = null;
	/* Column Info */
	private String attrCtnt7 = null;
	/* Column Info */
	private String payStsFlg = null;
	/* Column Info */
	private String remitVndrNo = null;
	/* Column Info */
	private String dueDt = null;
	/* Column Info */
	private String attrCateNm = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String xterBankAcctSeq = null;
	/* Column Info */
	private String invCurrCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String invBatSeq = null;
	/* Column Info */
	private String payMzdLuCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public InvoicePayScheduleListVO() {}

	public InvoicePayScheduleListVO(String ibflag, String pagerows, String invSeq, String paySkdNo, String payRmnAmt, String dueDt, String payGrsAmt, String invHldFlg,  String orgInvHldFlg, String payMzdLuCd, String payPrioCd, String payStsFlg, String invBatSeq, String attrCtnt1, String attrCtnt2, String attrCtnt3, String attrCtnt4, String attrCtnt5, String attrCtnt6, String attrCtnt7, String attrCtnt8, String attrCtnt9, String attrCtnt10, String attrCtnt11, String attrCtnt12, String attrCtnt13, String attrCtnt14, String attrCtnt15, String attrCateNm, String xterBankAcctSeq, String payBatRunSeq, String remitVndrNo, String creUsrId, String creDt, String updUsrId, String updDt, String usrId, String vndrLglEngNm, String bankAcctNo, String invCurrCd) {
		this.bankAcctNo = bankAcctNo;
		this.payGrsAmt = payGrsAmt;
		this.attrCtnt10 = attrCtnt10;
		this.vndrLglEngNm = vndrLglEngNm;
		this.creDt = creDt;
		this.attrCtnt14 = attrCtnt14;
		this.paySkdNo = paySkdNo;
		this.attrCtnt9 = attrCtnt9;
		this.attrCtnt8 = attrCtnt8;
		this.attrCtnt13 = attrCtnt13;
		this.invSeq = invSeq;
		this.attrCtnt12 = attrCtnt12;
		this.payRmnAmt = payRmnAmt;
		this.attrCtnt11 = attrCtnt11;
		this.payBatRunSeq = payBatRunSeq;
		this.attrCtnt15 = attrCtnt15;
		this.pagerows = pagerows;
		this.payPrioCd = payPrioCd;
		this.attrCtnt1 = attrCtnt1;
		this.invHldFlg = invHldFlg;
		this.orgInvHldFlg = orgInvHldFlg;
		this.ibflag = ibflag;
		this.attrCtnt2 = attrCtnt2;
		this.attrCtnt3 = attrCtnt3;
		this.attrCtnt4 = attrCtnt4;
		this.usrId = usrId;
		this.attrCtnt5 = attrCtnt5;
		this.attrCtnt6 = attrCtnt6;
		this.attrCtnt7 = attrCtnt7;
		this.payStsFlg = payStsFlg;
		this.remitVndrNo = remitVndrNo;
		this.dueDt = dueDt;
		this.attrCateNm = attrCateNm;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.xterBankAcctSeq = xterBankAcctSeq;
		this.invCurrCd = invCurrCd;
		this.creUsrId = creUsrId;
		this.invBatSeq = invBatSeq;
		this.payMzdLuCd = payMzdLuCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bank_acct_no", getBankAcctNo());
		this.hashColumns.put("pay_grs_amt", getPayGrsAmt());
		this.hashColumns.put("attr_ctnt10", getAttrCtnt10());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("attr_ctnt14", getAttrCtnt14());
		this.hashColumns.put("pay_skd_no", getPaySkdNo());
		this.hashColumns.put("attr_ctnt9", getAttrCtnt9());
		this.hashColumns.put("attr_ctnt8", getAttrCtnt8());
		this.hashColumns.put("attr_ctnt13", getAttrCtnt13());
		this.hashColumns.put("inv_seq", getInvSeq());
		this.hashColumns.put("attr_ctnt12", getAttrCtnt12());
		this.hashColumns.put("pay_rmn_amt", getPayRmnAmt());
		this.hashColumns.put("attr_ctnt11", getAttrCtnt11());
		this.hashColumns.put("pay_bat_run_seq", getPayBatRunSeq());
		this.hashColumns.put("attr_ctnt15", getAttrCtnt15());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pay_prio_cd", getPayPrioCd());
		this.hashColumns.put("attr_ctnt1", getAttrCtnt1());
		this.hashColumns.put("inv_hld_flg", getInvHldFlg());
		this.hashColumns.put("org_inv_hld_flg", getOrgInvHldFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("attr_ctnt2", getAttrCtnt2());
		this.hashColumns.put("attr_ctnt3", getAttrCtnt3());
		this.hashColumns.put("attr_ctnt4", getAttrCtnt4());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("attr_ctnt5", getAttrCtnt5());
		this.hashColumns.put("attr_ctnt6", getAttrCtnt6());
		this.hashColumns.put("attr_ctnt7", getAttrCtnt7());
		this.hashColumns.put("pay_sts_flg", getPayStsFlg());
		this.hashColumns.put("remit_vndr_no", getRemitVndrNo());
		this.hashColumns.put("due_dt", getDueDt());
		this.hashColumns.put("attr_cate_nm", getAttrCateNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("xter_bank_acct_seq", getXterBankAcctSeq());
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("inv_bat_seq", getInvBatSeq());
		this.hashColumns.put("pay_mzd_lu_cd", getPayMzdLuCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bank_acct_no", "bankAcctNo");
		this.hashFields.put("pay_grs_amt", "payGrsAmt");
		this.hashFields.put("attr_ctnt10", "attrCtnt10");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("attr_ctnt14", "attrCtnt14");
		this.hashFields.put("pay_skd_no", "paySkdNo");
		this.hashFields.put("attr_ctnt9", "attrCtnt9");
		this.hashFields.put("attr_ctnt8", "attrCtnt8");
		this.hashFields.put("attr_ctnt13", "attrCtnt13");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("attr_ctnt12", "attrCtnt12");
		this.hashFields.put("pay_rmn_amt", "payRmnAmt");
		this.hashFields.put("attr_ctnt11", "attrCtnt11");
		this.hashFields.put("pay_bat_run_seq", "payBatRunSeq");
		this.hashFields.put("attr_ctnt15", "attrCtnt15");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pay_prio_cd", "payPrioCd");
		this.hashFields.put("attr_ctnt1", "attrCtnt1");
		this.hashFields.put("inv_hld_flg", "invHldFlg");
		this.hashFields.put("org_inv_hld_flg", "orgInvHldFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("attr_ctnt2", "attrCtnt2");
		this.hashFields.put("attr_ctnt3", "attrCtnt3");
		this.hashFields.put("attr_ctnt4", "attrCtnt4");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("attr_ctnt5", "attrCtnt5");
		this.hashFields.put("attr_ctnt6", "attrCtnt6");
		this.hashFields.put("attr_ctnt7", "attrCtnt7");
		this.hashFields.put("pay_sts_flg", "payStsFlg");
		this.hashFields.put("remit_vndr_no", "remitVndrNo");
		this.hashFields.put("due_dt", "dueDt");
		this.hashFields.put("attr_cate_nm", "attrCateNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("xter_bank_acct_seq", "xterBankAcctSeq");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("inv_bat_seq", "invBatSeq");
		this.hashFields.put("pay_mzd_lu_cd", "payMzdLuCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bankAcctNo
	 */
	public String getBankAcctNo() {
		return this.bankAcctNo;
	}
	
	/**
	 * Column Info
	 * @return payGrsAmt
	 */
	public String getPayGrsAmt() {
		return this.payGrsAmt;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt10
	 */
	public String getAttrCtnt10() {
		return this.attrCtnt10;
	}
	
	/**
	 * Column Info
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
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
	 * @return attrCtnt14
	 */
	public String getAttrCtnt14() {
		return this.attrCtnt14;
	}
	
	/**
	 * Column Info
	 * @return paySkdNo
	 */
	public String getPaySkdNo() {
		return this.paySkdNo;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt9
	 */
	public String getAttrCtnt9() {
		return this.attrCtnt9;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt8
	 */
	public String getAttrCtnt8() {
		return this.attrCtnt8;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt13
	 */
	public String getAttrCtnt13() {
		return this.attrCtnt13;
	}
	
	/**
	 * Column Info
	 * @return invSeq
	 */
	public String getInvSeq() {
		return this.invSeq;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt12
	 */
	public String getAttrCtnt12() {
		return this.attrCtnt12;
	}
	
	/**
	 * Column Info
	 * @return payRmnAmt
	 */
	public String getPayRmnAmt() {
		return this.payRmnAmt;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt11
	 */
	public String getAttrCtnt11() {
		return this.attrCtnt11;
	}
	
	/**
	 * Column Info
	 * @return payBatRunSeq
	 */
	public String getPayBatRunSeq() {
		return this.payBatRunSeq;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt15
	 */
	public String getAttrCtnt15() {
		return this.attrCtnt15;
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
	 * @return payPrioCd
	 */
	public String getPayPrioCd() {
		return this.payPrioCd;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt1
	 */
	public String getAttrCtnt1() {
		return this.attrCtnt1;
	}
	
	/**
	 * Column Info
	 * @return invHldFlg
	 */
	public String getInvHldFlg() {
		return this.invHldFlg;
	}
	
	/**
	 * Column Info
	 * @return orgInvHldFlg
	 */
	public String getOrgInvHldFlg() {
		return this.orgInvHldFlg;
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
	 * @return attrCtnt2
	 */
	public String getAttrCtnt2() {
		return this.attrCtnt2;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt3
	 */
	public String getAttrCtnt3() {
		return this.attrCtnt3;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt4
	 */
	public String getAttrCtnt4() {
		return this.attrCtnt4;
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
	 * @return attrCtnt5
	 */
	public String getAttrCtnt5() {
		return this.attrCtnt5;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt6
	 */
	public String getAttrCtnt6() {
		return this.attrCtnt6;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt7
	 */
	public String getAttrCtnt7() {
		return this.attrCtnt7;
	}
	
	/**
	 * Column Info
	 * @return payStsFlg
	 */
	public String getPayStsFlg() {
		return this.payStsFlg;
	}
	
	/**
	 * Column Info
	 * @return remitVndrNo
	 */
	public String getRemitVndrNo() {
		return this.remitVndrNo;
	}
	
	/**
	 * Column Info
	 * @return dueDt
	 */
	public String getDueDt() {
		return this.dueDt;
	}
	
	/**
	 * Column Info
	 * @return attrCateNm
	 */
	public String getAttrCateNm() {
		return this.attrCateNm;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return xterBankAcctSeq
	 */
	public String getXterBankAcctSeq() {
		return this.xterBankAcctSeq;
	}
	
	/**
	 * Column Info
	 * @return invCurrCd
	 */
	public String getInvCurrCd() {
		return this.invCurrCd;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return invBatSeq
	 */
	public String getInvBatSeq() {
		return this.invBatSeq;
	}
	
	/**
	 * Column Info
	 * @return payMzdLuCd
	 */
	public String getPayMzdLuCd() {
		return this.payMzdLuCd;
	}
	

	/**
	 * Column Info
	 * @param bankAcctNo
	 */
	public void setBankAcctNo(String bankAcctNo) {
		this.bankAcctNo = bankAcctNo;
	}
	
	/**
	 * Column Info
	 * @param payGrsAmt
	 */
	public void setPayGrsAmt(String payGrsAmt) {
		this.payGrsAmt = payGrsAmt;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt10
	 */
	public void setAttrCtnt10(String attrCtnt10) {
		this.attrCtnt10 = attrCtnt10;
	}
	
	/**
	 * Column Info
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
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
	 * @param attrCtnt14
	 */
	public void setAttrCtnt14(String attrCtnt14) {
		this.attrCtnt14 = attrCtnt14;
	}
	
	/**
	 * Column Info
	 * @param paySkdNo
	 */
	public void setPaySkdNo(String paySkdNo) {
		this.paySkdNo = paySkdNo;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt9
	 */
	public void setAttrCtnt9(String attrCtnt9) {
		this.attrCtnt9 = attrCtnt9;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt8
	 */
	public void setAttrCtnt8(String attrCtnt8) {
		this.attrCtnt8 = attrCtnt8;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt13
	 */
	public void setAttrCtnt13(String attrCtnt13) {
		this.attrCtnt13 = attrCtnt13;
	}
	
	/**
	 * Column Info
	 * @param invSeq
	 */
	public void setInvSeq(String invSeq) {
		this.invSeq = invSeq;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt12
	 */
	public void setAttrCtnt12(String attrCtnt12) {
		this.attrCtnt12 = attrCtnt12;
	}
	
	/**
	 * Column Info
	 * @param payRmnAmt
	 */
	public void setPayRmnAmt(String payRmnAmt) {
		this.payRmnAmt = payRmnAmt;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt11
	 */
	public void setAttrCtnt11(String attrCtnt11) {
		this.attrCtnt11 = attrCtnt11;
	}
	
	/**
	 * Column Info
	 * @param payBatRunSeq
	 */
	public void setPayBatRunSeq(String payBatRunSeq) {
		this.payBatRunSeq = payBatRunSeq;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt15
	 */
	public void setAttrCtnt15(String attrCtnt15) {
		this.attrCtnt15 = attrCtnt15;
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
	 * @param payPrioCd
	 */
	public void setPayPrioCd(String payPrioCd) {
		this.payPrioCd = payPrioCd;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt1
	 */
	public void setAttrCtnt1(String attrCtnt1) {
		this.attrCtnt1 = attrCtnt1;
	}
	
	/**
	 * Column Info
	 * @param invHldFlg
	 */
	public void setInvHldFlg(String invHldFlg) {
		this.invHldFlg = invHldFlg;
	}
	
	/**
	 * Column Info
	 * @param invHldFlg
	 */
	public void setOrgInvHldFlg(String orgInvHldFlg) {
		this.orgInvHldFlg = orgInvHldFlg;
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
	 * @param attrCtnt2
	 */
	public void setAttrCtnt2(String attrCtnt2) {
		this.attrCtnt2 = attrCtnt2;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt3
	 */
	public void setAttrCtnt3(String attrCtnt3) {
		this.attrCtnt3 = attrCtnt3;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt4
	 */
	public void setAttrCtnt4(String attrCtnt4) {
		this.attrCtnt4 = attrCtnt4;
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
	 * @param attrCtnt5
	 */
	public void setAttrCtnt5(String attrCtnt5) {
		this.attrCtnt5 = attrCtnt5;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt6
	 */
	public void setAttrCtnt6(String attrCtnt6) {
		this.attrCtnt6 = attrCtnt6;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt7
	 */
	public void setAttrCtnt7(String attrCtnt7) {
		this.attrCtnt7 = attrCtnt7;
	}
	
	/**
	 * Column Info
	 * @param payStsFlg
	 */
	public void setPayStsFlg(String payStsFlg) {
		this.payStsFlg = payStsFlg;
	}
	
	/**
	 * Column Info
	 * @param remitVndrNo
	 */
	public void setRemitVndrNo(String remitVndrNo) {
		this.remitVndrNo = remitVndrNo;
	}
	
	/**
	 * Column Info
	 * @param dueDt
	 */
	public void setDueDt(String dueDt) {
		this.dueDt = dueDt;
	}
	
	/**
	 * Column Info
	 * @param attrCateNm
	 */
	public void setAttrCateNm(String attrCateNm) {
		this.attrCateNm = attrCateNm;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param xterBankAcctSeq
	 */
	public void setXterBankAcctSeq(String xterBankAcctSeq) {
		this.xterBankAcctSeq = xterBankAcctSeq;
	}
	
	/**
	 * Column Info
	 * @param invCurrCd
	 */
	public void setInvCurrCd(String invCurrCd) {
		this.invCurrCd = invCurrCd;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param invBatSeq
	 */
	public void setInvBatSeq(String invBatSeq) {
		this.invBatSeq = invBatSeq;
	}
	
	/**
	 * Column Info
	 * @param payMzdLuCd
	 */
	public void setPayMzdLuCd(String payMzdLuCd) {
		this.payMzdLuCd = payMzdLuCd;
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
		setBankAcctNo(JSPUtil.getParameter(request, prefix + "bank_acct_no", ""));
		setPayGrsAmt(JSPUtil.getParameter(request, prefix + "pay_grs_amt", ""));
		setAttrCtnt10(JSPUtil.getParameter(request, prefix + "attr_ctnt10", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setAttrCtnt14(JSPUtil.getParameter(request, prefix + "attr_ctnt14", ""));
		setPaySkdNo(JSPUtil.getParameter(request, prefix + "pay_skd_no", ""));
		setAttrCtnt9(JSPUtil.getParameter(request, prefix + "attr_ctnt9", ""));
		setAttrCtnt8(JSPUtil.getParameter(request, prefix + "attr_ctnt8", ""));
		setAttrCtnt13(JSPUtil.getParameter(request, prefix + "attr_ctnt13", ""));
		setInvSeq(JSPUtil.getParameter(request, prefix + "inv_seq", ""));
		setAttrCtnt12(JSPUtil.getParameter(request, prefix + "attr_ctnt12", ""));
		setPayRmnAmt(JSPUtil.getParameter(request, prefix + "pay_rmn_amt", ""));
		setAttrCtnt11(JSPUtil.getParameter(request, prefix + "attr_ctnt11", ""));
		setPayBatRunSeq(JSPUtil.getParameter(request, prefix + "pay_bat_run_seq", ""));
		setAttrCtnt15(JSPUtil.getParameter(request, prefix + "attr_ctnt15", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPayPrioCd(JSPUtil.getParameter(request, prefix + "pay_prio_cd", ""));
		setAttrCtnt1(JSPUtil.getParameter(request, prefix + "attr_ctnt1", ""));
		setInvHldFlg(JSPUtil.getParameter(request, prefix + "inv_hld_flg", ""));
		setOrgInvHldFlg(JSPUtil.getParameter(request, prefix + "org_inv_hld_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAttrCtnt2(JSPUtil.getParameter(request, prefix + "attr_ctnt2", ""));
		setAttrCtnt3(JSPUtil.getParameter(request, prefix + "attr_ctnt3", ""));
		setAttrCtnt4(JSPUtil.getParameter(request, prefix + "attr_ctnt4", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setAttrCtnt5(JSPUtil.getParameter(request, prefix + "attr_ctnt5", ""));
		setAttrCtnt6(JSPUtil.getParameter(request, prefix + "attr_ctnt6", ""));
		setAttrCtnt7(JSPUtil.getParameter(request, prefix + "attr_ctnt7", ""));
		setPayStsFlg(JSPUtil.getParameter(request, prefix + "pay_sts_flg", ""));
		setRemitVndrNo(JSPUtil.getParameter(request, prefix + "remit_vndr_no", ""));
		setDueDt(JSPUtil.getParameter(request, prefix + "due_dt", ""));
		setAttrCateNm(JSPUtil.getParameter(request, prefix + "attr_cate_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setXterBankAcctSeq(JSPUtil.getParameter(request, prefix + "xter_bank_acct_seq", ""));
		setInvCurrCd(JSPUtil.getParameter(request, prefix + "inv_curr_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setInvBatSeq(JSPUtil.getParameter(request, prefix + "inv_bat_seq", ""));
		setPayMzdLuCd(JSPUtil.getParameter(request, prefix + "pay_mzd_lu_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoicePayScheduleListVO[]
	 */
	public InvoicePayScheduleListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvoicePayScheduleListVO[]
	 */
	public InvoicePayScheduleListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvoicePayScheduleListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bankAcctNo = (JSPUtil.getParameter(request, prefix	+ "bank_acct_no", length));
			String[] payGrsAmt = (JSPUtil.getParameter(request, prefix	+ "pay_grs_amt", length));
			String[] attrCtnt10 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt10", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] attrCtnt14 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt14", length));
			String[] paySkdNo = (JSPUtil.getParameter(request, prefix	+ "pay_skd_no", length));
			String[] attrCtnt9 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt9", length));
			String[] attrCtnt8 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt8", length));
			String[] attrCtnt13 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt13", length));
			String[] invSeq = (JSPUtil.getParameter(request, prefix	+ "inv_seq", length));
			String[] attrCtnt12 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt12", length));
			String[] payRmnAmt = (JSPUtil.getParameter(request, prefix	+ "pay_rmn_amt", length));
			String[] attrCtnt11 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt11", length));
			String[] payBatRunSeq = (JSPUtil.getParameter(request, prefix	+ "pay_bat_run_seq", length));
			String[] attrCtnt15 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt15", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] payPrioCd = (JSPUtil.getParameter(request, prefix	+ "pay_prio_cd", length));
			String[] attrCtnt1 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt1", length));
			String[] invHldFlg = (JSPUtil.getParameter(request, prefix	+ "inv_hld_flg", length));
			String[] orgInvHldFlg = (JSPUtil.getParameter(request, prefix	+ "org_inv_hld_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] attrCtnt2 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt2", length));
			String[] attrCtnt3 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt3", length));
			String[] attrCtnt4 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt4", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] attrCtnt5 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt5", length));
			String[] attrCtnt6 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt6", length));
			String[] attrCtnt7 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt7", length));
			String[] payStsFlg = (JSPUtil.getParameter(request, prefix	+ "pay_sts_flg", length));
			String[] remitVndrNo = (JSPUtil.getParameter(request, prefix	+ "remit_vndr_no", length));
			String[] dueDt = (JSPUtil.getParameter(request, prefix	+ "due_dt", length));
			String[] attrCateNm = (JSPUtil.getParameter(request, prefix	+ "attr_cate_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] xterBankAcctSeq = (JSPUtil.getParameter(request, prefix	+ "xter_bank_acct_seq", length));
			String[] invCurrCd = (JSPUtil.getParameter(request, prefix	+ "inv_curr_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] invBatSeq = (JSPUtil.getParameter(request, prefix	+ "inv_bat_seq", length));
			String[] payMzdLuCd = (JSPUtil.getParameter(request, prefix	+ "pay_mzd_lu_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvoicePayScheduleListVO();
				if (bankAcctNo[i] != null)
					model.setBankAcctNo(bankAcctNo[i]);
				if (payGrsAmt[i] != null)
					model.setPayGrsAmt(payGrsAmt[i]);
				if (attrCtnt10[i] != null)
					model.setAttrCtnt10(attrCtnt10[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (attrCtnt14[i] != null)
					model.setAttrCtnt14(attrCtnt14[i]);
				if (paySkdNo[i] != null)
					model.setPaySkdNo(paySkdNo[i]);
				if (attrCtnt9[i] != null)
					model.setAttrCtnt9(attrCtnt9[i]);
				if (attrCtnt8[i] != null)
					model.setAttrCtnt8(attrCtnt8[i]);
				if (attrCtnt13[i] != null)
					model.setAttrCtnt13(attrCtnt13[i]);
				if (invSeq[i] != null)
					model.setInvSeq(invSeq[i]);
				if (attrCtnt12[i] != null)
					model.setAttrCtnt12(attrCtnt12[i]);
				if (payRmnAmt[i] != null)
					model.setPayRmnAmt(payRmnAmt[i]);
				if (attrCtnt11[i] != null)
					model.setAttrCtnt11(attrCtnt11[i]);
				if (payBatRunSeq[i] != null)
					model.setPayBatRunSeq(payBatRunSeq[i]);
				if (attrCtnt15[i] != null)
					model.setAttrCtnt15(attrCtnt15[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (payPrioCd[i] != null)
					model.setPayPrioCd(payPrioCd[i]);
				if (attrCtnt1[i] != null)
					model.setAttrCtnt1(attrCtnt1[i]);
				if (invHldFlg[i] != null)
					model.setInvHldFlg(invHldFlg[i]);
				if (orgInvHldFlg[i] != null)
					model.setOrgInvHldFlg(orgInvHldFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (attrCtnt2[i] != null)
					model.setAttrCtnt2(attrCtnt2[i]);
				if (attrCtnt3[i] != null)
					model.setAttrCtnt3(attrCtnt3[i]);
				if (attrCtnt4[i] != null)
					model.setAttrCtnt4(attrCtnt4[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (attrCtnt5[i] != null)
					model.setAttrCtnt5(attrCtnt5[i]);
				if (attrCtnt6[i] != null)
					model.setAttrCtnt6(attrCtnt6[i]);
				if (attrCtnt7[i] != null)
					model.setAttrCtnt7(attrCtnt7[i]);
				if (payStsFlg[i] != null)
					model.setPayStsFlg(payStsFlg[i]);
				if (remitVndrNo[i] != null)
					model.setRemitVndrNo(remitVndrNo[i]);
				if (dueDt[i] != null)
					model.setDueDt(dueDt[i]);
				if (attrCateNm[i] != null)
					model.setAttrCateNm(attrCateNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (xterBankAcctSeq[i] != null)
					model.setXterBankAcctSeq(xterBankAcctSeq[i]);
				if (invCurrCd[i] != null)
					model.setInvCurrCd(invCurrCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (invBatSeq[i] != null)
					model.setInvBatSeq(invBatSeq[i]);
				if (payMzdLuCd[i] != null)
					model.setPayMzdLuCd(payMzdLuCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvoicePayScheduleListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvoicePayScheduleListVO[]
	 */
	public InvoicePayScheduleListVO[] getInvoicePayScheduleListVOs(){
		InvoicePayScheduleListVO[] vos = (InvoicePayScheduleListVO[])models.toArray(new InvoicePayScheduleListVO[models.size()]);
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
		this.bankAcctNo = this.bankAcctNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payGrsAmt = this.payGrsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt10 = this.attrCtnt10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt14 = this.attrCtnt14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paySkdNo = this.paySkdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt9 = this.attrCtnt9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt8 = this.attrCtnt8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt13 = this.attrCtnt13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq = this.invSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt12 = this.attrCtnt12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payRmnAmt = this.payRmnAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt11 = this.attrCtnt11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payBatRunSeq = this.payBatRunSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt15 = this.attrCtnt15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payPrioCd = this.payPrioCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt1 = this.attrCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invHldFlg = this.invHldFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgInvHldFlg = this.orgInvHldFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt2 = this.attrCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt3 = this.attrCtnt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt4 = this.attrCtnt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt5 = this.attrCtnt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt6 = this.attrCtnt6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt7 = this.attrCtnt7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payStsFlg = this.payStsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remitVndrNo = this.remitVndrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDt = this.dueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCateNm = this.attrCateNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterBankAcctSeq = this.xterBankAcctSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd = this.invCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invBatSeq = this.invBatSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payMzdLuCd = this.payMzdLuCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
