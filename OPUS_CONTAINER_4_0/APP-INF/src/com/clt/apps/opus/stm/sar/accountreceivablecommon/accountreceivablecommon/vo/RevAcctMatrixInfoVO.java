/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RevAcctMatrixInfoVO.java
*@FileTitle : RevAcctMatrixInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.15  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo;

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

public class RevAcctMatrixInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RevAcctMatrixInfoVO> models = new ArrayList<RevAcctMatrixInfoVO>();
	
	/* Column Info */
	private String repChgCd = null;
	/* Column Info */
	private String arAcctCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String bankChgAcctCd = null;
	/* Column Info */
	private String acctEndDt = null;
	/* Column Info */
	private String amtSgnCd = null;
	/* Column Info */
	private String creDt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String acctStDt = null;
	/* Column Info */
	private String drCrTpCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String acctMtxSeq = null;
	/* Column Info */
	private String acctCtnt1 = null;
	/* Column Info */
	private String acctTpNm = null;
	/* Column Info */
	private String acctCtnt2 = null;
	/* Column Info */
	private String acctCtnt3 = null;
	/* Column Info */
	private String acctCtnt4 = null;
	/* Column Info */
	private String acctCtnt5 = null;
	/* Column Info */
	private String acctCtnt6 = null;
	/* Column Info */
	private String searchFlg = null;
	/* Column Info */
	private String acctCtnt7 = null;
	/* Column Info */
	private String legrXchDiffLssAcctCd = null;
	/* Column Info */
	private String acctCtnt8 = null;
	/* Column Info */
	private String legrXchDiffIncmAcctCd = null;
	/* Column Info */
	private String revAcctDivCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String clrAcctCd = null;
	/* Column Info */
	private String payCurrXchAcctCd = null;
	/* Column Info */
	private String payAcctCd = null;
	/* Column Info */
	private String acctTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RevAcctMatrixInfoVO() {}

	public RevAcctMatrixInfoVO(String ibflag, String pagerows, String repChgCd, String deltFlg, String arAcctCd, String bankChgAcctCd, String creDt, String amtSgnCd, String acctEndDt, String acctStDt, String drCrTpCd, String updUsrId, String updDt, String acctMtxSeq, String acctCtnt1, String acctTpNm, String acctCtnt2, String acctCtnt3, String acctCtnt4, String acctCtnt5, String acctCtnt6, String acctCtnt7, String legrXchDiffLssAcctCd, String acctCtnt8, String legrXchDiffIncmAcctCd, String revAcctDivCd, String creUsrId, String clrAcctCd, String payCurrXchAcctCd, String payAcctCd, String acctTpCd, String searchFlg) {
		this.repChgCd = repChgCd;
		this.arAcctCd = arAcctCd;
		this.deltFlg = deltFlg;
		this.bankChgAcctCd = bankChgAcctCd;
		this.acctEndDt = acctEndDt;
		this.amtSgnCd = amtSgnCd;
		this.creDt = creDt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.acctStDt = acctStDt;
		this.drCrTpCd = drCrTpCd;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.acctMtxSeq = acctMtxSeq;
		this.acctCtnt1 = acctCtnt1;
		this.acctTpNm = acctTpNm;
		this.acctCtnt2 = acctCtnt2;
		this.acctCtnt3 = acctCtnt3;
		this.acctCtnt4 = acctCtnt4;
		this.acctCtnt5 = acctCtnt5;
		this.acctCtnt6 = acctCtnt6;
		this.searchFlg = searchFlg;
		this.acctCtnt7 = acctCtnt7;
		this.legrXchDiffLssAcctCd = legrXchDiffLssAcctCd;
		this.acctCtnt8 = acctCtnt8;
		this.legrXchDiffIncmAcctCd = legrXchDiffIncmAcctCd;
		this.revAcctDivCd = revAcctDivCd;
		this.creUsrId = creUsrId;
		this.clrAcctCd = clrAcctCd;
		this.payCurrXchAcctCd = payCurrXchAcctCd;
		this.payAcctCd = payAcctCd;
		this.acctTpCd = acctTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rep_chg_cd", getRepChgCd());
		this.hashColumns.put("ar_acct_cd", getArAcctCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("bank_chg_acct_cd", getBankChgAcctCd());
		this.hashColumns.put("acct_end_dt", getAcctEndDt());
		this.hashColumns.put("amt_sgn_cd", getAmtSgnCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("acct_st_dt", getAcctStDt());
		this.hashColumns.put("dr_cr_tp_cd", getDrCrTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("acct_mtx_seq", getAcctMtxSeq());
		this.hashColumns.put("acct_ctnt1", getAcctCtnt1());
		this.hashColumns.put("acct_tp_nm", getAcctTpNm());
		this.hashColumns.put("acct_ctnt2", getAcctCtnt2());
		this.hashColumns.put("acct_ctnt3", getAcctCtnt3());
		this.hashColumns.put("acct_ctnt4", getAcctCtnt4());
		this.hashColumns.put("acct_ctnt5", getAcctCtnt5());
		this.hashColumns.put("acct_ctnt6", getAcctCtnt6());
		this.hashColumns.put("search_flg", getSearchFlg());
		this.hashColumns.put("acct_ctnt7", getAcctCtnt7());
		this.hashColumns.put("legr_xch_diff_lss_acct_cd", getLegrXchDiffLssAcctCd());
		this.hashColumns.put("acct_ctnt8", getAcctCtnt8());
		this.hashColumns.put("legr_xch_diff_incm_acct_cd", getLegrXchDiffIncmAcctCd());
		this.hashColumns.put("rev_acct_div_cd", getRevAcctDivCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("clr_acct_cd", getClrAcctCd());
		this.hashColumns.put("pay_curr_xch_acct_cd", getPayCurrXchAcctCd());
		this.hashColumns.put("pay_acct_cd", getPayAcctCd());
		this.hashColumns.put("acct_tp_cd", getAcctTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rep_chg_cd", "repChgCd");
		this.hashFields.put("ar_acct_cd", "arAcctCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("bank_chg_acct_cd", "bankChgAcctCd");
		this.hashFields.put("acct_end_dt", "acctEndDt");
		this.hashFields.put("amt_sgn_cd", "amtSgnCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("acct_st_dt", "acctStDt");
		this.hashFields.put("dr_cr_tp_cd", "drCrTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("acct_mtx_seq", "acctMtxSeq");
		this.hashFields.put("acct_ctnt1", "acctCtnt1");
		this.hashFields.put("acct_tp_nm", "acctTpNm");
		this.hashFields.put("acct_ctnt2", "acctCtnt2");
		this.hashFields.put("acct_ctnt3", "acctCtnt3");
		this.hashFields.put("acct_ctnt4", "acctCtnt4");
		this.hashFields.put("acct_ctnt5", "acctCtnt5");
		this.hashFields.put("acct_ctnt6", "acctCtnt6");
		this.hashFields.put("search_flg", "searchFlg");
		this.hashFields.put("acct_ctnt7", "acctCtnt7");
		this.hashFields.put("legr_xch_diff_lss_acct_cd", "legrXchDiffLssAcctCd");
		this.hashFields.put("acct_ctnt8", "acctCtnt8");
		this.hashFields.put("legr_xch_diff_incm_acct_cd", "legrXchDiffIncmAcctCd");
		this.hashFields.put("rev_acct_div_cd", "revAcctDivCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("clr_acct_cd", "clrAcctCd");
		this.hashFields.put("pay_curr_xch_acct_cd", "payCurrXchAcctCd");
		this.hashFields.put("pay_acct_cd", "payAcctCd");
		this.hashFields.put("acct_tp_cd", "acctTpCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return repChgCd
	 */
	public String getRepChgCd() {
		return this.repChgCd;
	}
	
	/**
	 * Column Info
	 * @return arAcctCd
	 */
	public String getArAcctCd() {
		return this.arAcctCd;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return bankChgAcctCd
	 */
	public String getBankChgAcctCd() {
		return this.bankChgAcctCd;
	}
	
	/**
	 * Column Info
	 * @return acctEndDt
	 */
	public String getAcctEndDt() {
		return this.acctEndDt;
	}
	
	/**
	 * Column Info
	 * @return amtSgnCd
	 */
	public String getAmtSgnCd() {
		return this.amtSgnCd;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return acctStDt
	 */
	public String getAcctStDt() {
		return this.acctStDt;
	}
	
	/**
	 * Column Info
	 * @return drCrTpCd
	 */
	public String getDrCrTpCd() {
		return this.drCrTpCd;
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
	 * @return acctMtxSeq
	 */
	public String getAcctMtxSeq() {
		return this.acctMtxSeq;
	}
	
	/**
	 * Column Info
	 * @return acctCtnt1
	 */
	public String getAcctCtnt1() {
		return this.acctCtnt1;
	}
	
	/**
	 * Column Info
	 * @return acctTpNm
	 */
	public String getAcctTpNm() {
		return this.acctTpNm;
	}
	
	/**
	 * Column Info
	 * @return acctCtnt2
	 */
	public String getAcctCtnt2() {
		return this.acctCtnt2;
	}
	
	/**
	 * Column Info
	 * @return acctCtnt3
	 */
	public String getAcctCtnt3() {
		return this.acctCtnt3;
	}
	
	/**
	 * Column Info
	 * @return acctCtnt4
	 */
	public String getAcctCtnt4() {
		return this.acctCtnt4;
	}
	
	/**
	 * Column Info
	 * @return acctCtnt5
	 */
	public String getAcctCtnt5() {
		return this.acctCtnt5;
	}
	
	/**
	 * Column Info
	 * @return acctCtnt6
	 */
	public String getAcctCtnt6() {
		return this.acctCtnt6;
	}
	
	/**
	 * Column Info
	 * @return searchFlg
	 */
	public String getSearchFlg() {
		return this.searchFlg;
	}
	
	/**
	 * Column Info
	 * @return acctCtnt7
	 */
	public String getAcctCtnt7() {
		return this.acctCtnt7;
	}
	
	/**
	 * Column Info
	 * @return legrXchDiffLssAcctCd
	 */
	public String getLegrXchDiffLssAcctCd() {
		return this.legrXchDiffLssAcctCd;
	}
	
	/**
	 * Column Info
	 * @return acctCtnt8
	 */
	public String getAcctCtnt8() {
		return this.acctCtnt8;
	}
	
	/**
	 * Column Info
	 * @return legrXchDiffIncmAcctCd
	 */
	public String getLegrXchDiffIncmAcctCd() {
		return this.legrXchDiffIncmAcctCd;
	}
	
	/**
	 * Column Info
	 * @return revAcctDivCd
	 */
	public String getRevAcctDivCd() {
		return this.revAcctDivCd;
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
	 * @return clrAcctCd
	 */
	public String getClrAcctCd() {
		return this.clrAcctCd;
	}
	
	/**
	 * Column Info
	 * @return payCurrXchAcctCd
	 */
	public String getPayCurrXchAcctCd() {
		return this.payCurrXchAcctCd;
	}
	
	/**
	 * Column Info
	 * @return payAcctCd
	 */
	public String getPayAcctCd() {
		return this.payAcctCd;
	}
	
	/**
	 * Column Info
	 * @return acctTpCd
	 */
	public String getAcctTpCd() {
		return this.acctTpCd;
	}
	

	/**
	 * Column Info
	 * @param repChgCd
	 */
	public void setRepChgCd(String repChgCd) {
		this.repChgCd = repChgCd;
	}
	
	/**
	 * Column Info
	 * @param arAcctCd
	 */
	public void setArAcctCd(String arAcctCd) {
		this.arAcctCd = arAcctCd;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param bankChgAcctCd
	 */
	public void setBankChgAcctCd(String bankChgAcctCd) {
		this.bankChgAcctCd = bankChgAcctCd;
	}
	
	/**
	 * Column Info
	 * @param acctEndDt
	 */
	public void setAcctEndDt(String acctEndDt) {
		this.acctEndDt = acctEndDt;
	}
	
	/**
	 * Column Info
	 * @param amtSgnCd
	 */
	public void setAmtSgnCd(String amtSgnCd) {
		this.amtSgnCd = amtSgnCd;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param acctStDt
	 */
	public void setAcctStDt(String acctStDt) {
		this.acctStDt = acctStDt;
	}
	
	/**
	 * Column Info
	 * @param drCrTpCd
	 */
	public void setDrCrTpCd(String drCrTpCd) {
		this.drCrTpCd = drCrTpCd;
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
	 * @param acctMtxSeq
	 */
	public void setAcctMtxSeq(String acctMtxSeq) {
		this.acctMtxSeq = acctMtxSeq;
	}
	
	/**
	 * Column Info
	 * @param acctCtnt1
	 */
	public void setAcctCtnt1(String acctCtnt1) {
		this.acctCtnt1 = acctCtnt1;
	}
	
	/**
	 * Column Info
	 * @param acctTpNm
	 */
	public void setAcctTpNm(String acctTpNm) {
		this.acctTpNm = acctTpNm;
	}
	
	/**
	 * Column Info
	 * @param acctCtnt2
	 */
	public void setAcctCtnt2(String acctCtnt2) {
		this.acctCtnt2 = acctCtnt2;
	}
	
	/**
	 * Column Info
	 * @param acctCtnt3
	 */
	public void setAcctCtnt3(String acctCtnt3) {
		this.acctCtnt3 = acctCtnt3;
	}
	
	/**
	 * Column Info
	 * @param acctCtnt4
	 */
	public void setAcctCtnt4(String acctCtnt4) {
		this.acctCtnt4 = acctCtnt4;
	}
	
	/**
	 * Column Info
	 * @param acctCtnt5
	 */
	public void setAcctCtnt5(String acctCtnt5) {
		this.acctCtnt5 = acctCtnt5;
	}
	
	/**
	 * Column Info
	 * @param acctCtnt6
	 */
	public void setAcctCtnt6(String acctCtnt6) {
		this.acctCtnt6 = acctCtnt6;
	}
	
	/**
	 * Column Info
	 * @param searchFlg
	 */
	public void setSearchFlg(String searchFlg) {
		this.searchFlg = searchFlg;
	}
	
	/**
	 * Column Info
	 * @param acctCtnt7
	 */
	public void setAcctCtnt7(String acctCtnt7) {
		this.acctCtnt7 = acctCtnt7;
	}
	
	/**
	 * Column Info
	 * @param legrXchDiffLssAcctCd
	 */
	public void setLegrXchDiffLssAcctCd(String legrXchDiffLssAcctCd) {
		this.legrXchDiffLssAcctCd = legrXchDiffLssAcctCd;
	}
	
	/**
	 * Column Info
	 * @param acctCtnt8
	 */
	public void setAcctCtnt8(String acctCtnt8) {
		this.acctCtnt8 = acctCtnt8;
	}
	
	/**
	 * Column Info
	 * @param legrXchDiffIncmAcctCd
	 */
	public void setLegrXchDiffIncmAcctCd(String legrXchDiffIncmAcctCd) {
		this.legrXchDiffIncmAcctCd = legrXchDiffIncmAcctCd;
	}
	
	/**
	 * Column Info
	 * @param revAcctDivCd
	 */
	public void setRevAcctDivCd(String revAcctDivCd) {
		this.revAcctDivCd = revAcctDivCd;
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
	 * @param clrAcctCd
	 */
	public void setClrAcctCd(String clrAcctCd) {
		this.clrAcctCd = clrAcctCd;
	}
	
	/**
	 * Column Info
	 * @param payCurrXchAcctCd
	 */
	public void setPayCurrXchAcctCd(String payCurrXchAcctCd) {
		this.payCurrXchAcctCd = payCurrXchAcctCd;
	}
	
	/**
	 * Column Info
	 * @param payAcctCd
	 */
	public void setPayAcctCd(String payAcctCd) {
		this.payAcctCd = payAcctCd;
	}
	
	/**
	 * Column Info
	 * @param acctTpCd
	 */
	public void setAcctTpCd(String acctTpCd) {
		this.acctTpCd = acctTpCd;
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
		setRepChgCd(JSPUtil.getParameter(request, prefix + "rep_chg_cd", ""));
		setArAcctCd(JSPUtil.getParameter(request, prefix + "ar_acct_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setBankChgAcctCd(JSPUtil.getParameter(request, prefix + "bank_chg_acct_cd", ""));
		setAcctEndDt(JSPUtil.getParameter(request, prefix + "acct_end_dt", ""));
		setAmtSgnCd(JSPUtil.getParameter(request, prefix + "amt_sgn_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAcctStDt(JSPUtil.getParameter(request, prefix + "acct_st_dt", ""));
		setDrCrTpCd(JSPUtil.getParameter(request, prefix + "dr_cr_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setAcctMtxSeq(JSPUtil.getParameter(request, prefix + "acct_mtx_seq", ""));
		setAcctCtnt1(JSPUtil.getParameter(request, prefix + "acct_ctnt1", ""));
		setAcctTpNm(JSPUtil.getParameter(request, prefix + "acct_tp_nm", ""));
		setAcctCtnt2(JSPUtil.getParameter(request, prefix + "acct_ctnt2", ""));
		setAcctCtnt3(JSPUtil.getParameter(request, prefix + "acct_ctnt3", ""));
		setAcctCtnt4(JSPUtil.getParameter(request, prefix + "acct_ctnt4", ""));
		setAcctCtnt5(JSPUtil.getParameter(request, prefix + "acct_ctnt5", ""));
		setAcctCtnt6(JSPUtil.getParameter(request, prefix + "acct_ctnt6", ""));
		setSearchFlg(JSPUtil.getParameter(request, prefix + "search_flg", ""));
		setAcctCtnt7(JSPUtil.getParameter(request, prefix + "acct_ctnt7", ""));
		setLegrXchDiffLssAcctCd(JSPUtil.getParameter(request, prefix + "legr_xch_diff_lss_acct_cd", ""));
		setAcctCtnt8(JSPUtil.getParameter(request, prefix + "acct_ctnt8", ""));
		setLegrXchDiffIncmAcctCd(JSPUtil.getParameter(request, prefix + "legr_xch_diff_incm_acct_cd", ""));
		setRevAcctDivCd(JSPUtil.getParameter(request, prefix + "rev_acct_div_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setClrAcctCd(JSPUtil.getParameter(request, prefix + "clr_acct_cd", ""));
		setPayCurrXchAcctCd(JSPUtil.getParameter(request, prefix + "pay_curr_xch_acct_cd", ""));
		setPayAcctCd(JSPUtil.getParameter(request, prefix + "pay_acct_cd", ""));
		setAcctTpCd(JSPUtil.getParameter(request, prefix + "acct_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RevAcctMatrixInfoVO[]
	 */
	public RevAcctMatrixInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RevAcctMatrixInfoVO[]
	 */
	public RevAcctMatrixInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RevAcctMatrixInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] repChgCd = (JSPUtil.getParameter(request, prefix	+ "rep_chg_cd", length));
			String[] arAcctCd = (JSPUtil.getParameter(request, prefix	+ "ar_acct_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] bankChgAcctCd = (JSPUtil.getParameter(request, prefix	+ "bank_chg_acct_cd", length));
			String[] acctEndDt = (JSPUtil.getParameter(request, prefix	+ "acct_end_dt", length));
			String[] amtSgnCd = (JSPUtil.getParameter(request, prefix	+ "amt_sgn_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] acctStDt = (JSPUtil.getParameter(request, prefix	+ "acct_st_dt", length));
			String[] drCrTpCd = (JSPUtil.getParameter(request, prefix	+ "dr_cr_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] acctMtxSeq = (JSPUtil.getParameter(request, prefix	+ "acct_mtx_seq", length));
			String[] acctCtnt1 = (JSPUtil.getParameter(request, prefix	+ "acct_ctnt1", length));
			String[] acctTpNm = (JSPUtil.getParameter(request, prefix	+ "acct_tp_nm", length));
			String[] acctCtnt2 = (JSPUtil.getParameter(request, prefix	+ "acct_ctnt2", length));
			String[] acctCtnt3 = (JSPUtil.getParameter(request, prefix	+ "acct_ctnt3", length));
			String[] acctCtnt4 = (JSPUtil.getParameter(request, prefix	+ "acct_ctnt4", length));
			String[] acctCtnt5 = (JSPUtil.getParameter(request, prefix	+ "acct_ctnt5", length));
			String[] acctCtnt6 = (JSPUtil.getParameter(request, prefix	+ "acct_ctnt6", length));
			String[] searchFlg = (JSPUtil.getParameter(request, prefix	+ "search_flg", length));
			String[] acctCtnt7 = (JSPUtil.getParameter(request, prefix	+ "acct_ctnt7", length));
			String[] legrXchDiffLssAcctCd = (JSPUtil.getParameter(request, prefix	+ "legr_xch_diff_lss_acct_cd", length));
			String[] acctCtnt8 = (JSPUtil.getParameter(request, prefix	+ "acct_ctnt8", length));
			String[] legrXchDiffIncmAcctCd = (JSPUtil.getParameter(request, prefix	+ "legr_xch_diff_incm_acct_cd", length));
			String[] revAcctDivCd = (JSPUtil.getParameter(request, prefix	+ "rev_acct_div_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] clrAcctCd = (JSPUtil.getParameter(request, prefix	+ "clr_acct_cd", length));
			String[] payCurrXchAcctCd = (JSPUtil.getParameter(request, prefix	+ "pay_curr_xch_acct_cd", length));
			String[] payAcctCd = (JSPUtil.getParameter(request, prefix	+ "pay_acct_cd", length));
			String[] acctTpCd = (JSPUtil.getParameter(request, prefix	+ "acct_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new RevAcctMatrixInfoVO();
				if (repChgCd[i] != null)
					model.setRepChgCd(repChgCd[i]);
				if (arAcctCd[i] != null)
					model.setArAcctCd(arAcctCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (bankChgAcctCd[i] != null)
					model.setBankChgAcctCd(bankChgAcctCd[i]);
				if (acctEndDt[i] != null)
					model.setAcctEndDt(acctEndDt[i]);
				if (amtSgnCd[i] != null)
					model.setAmtSgnCd(amtSgnCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (acctStDt[i] != null)
					model.setAcctStDt(acctStDt[i]);
				if (drCrTpCd[i] != null)
					model.setDrCrTpCd(drCrTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (acctMtxSeq[i] != null)
					model.setAcctMtxSeq(acctMtxSeq[i]);
				if (acctCtnt1[i] != null)
					model.setAcctCtnt1(acctCtnt1[i]);
				if (acctTpNm[i] != null)
					model.setAcctTpNm(acctTpNm[i]);
				if (acctCtnt2[i] != null)
					model.setAcctCtnt2(acctCtnt2[i]);
				if (acctCtnt3[i] != null)
					model.setAcctCtnt3(acctCtnt3[i]);
				if (acctCtnt4[i] != null)
					model.setAcctCtnt4(acctCtnt4[i]);
				if (acctCtnt5[i] != null)
					model.setAcctCtnt5(acctCtnt5[i]);
				if (acctCtnt6[i] != null)
					model.setAcctCtnt6(acctCtnt6[i]);
				if (searchFlg[i] != null)
					model.setSearchFlg(searchFlg[i]);
				if (acctCtnt7[i] != null)
					model.setAcctCtnt7(acctCtnt7[i]);
				if (legrXchDiffLssAcctCd[i] != null)
					model.setLegrXchDiffLssAcctCd(legrXchDiffLssAcctCd[i]);
				if (acctCtnt8[i] != null)
					model.setAcctCtnt8(acctCtnt8[i]);
				if (legrXchDiffIncmAcctCd[i] != null)
					model.setLegrXchDiffIncmAcctCd(legrXchDiffIncmAcctCd[i]);
				if (revAcctDivCd[i] != null)
					model.setRevAcctDivCd(revAcctDivCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (clrAcctCd[i] != null)
					model.setClrAcctCd(clrAcctCd[i]);
				if (payCurrXchAcctCd[i] != null)
					model.setPayCurrXchAcctCd(payCurrXchAcctCd[i]);
				if (payAcctCd[i] != null)
					model.setPayAcctCd(payAcctCd[i]);
				if (acctTpCd[i] != null)
					model.setAcctTpCd(acctTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRevAcctMatrixInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RevAcctMatrixInfoVO[]
	 */
	public RevAcctMatrixInfoVO[] getRevAcctMatrixInfoVOs(){
		RevAcctMatrixInfoVO[] vos = (RevAcctMatrixInfoVO[])models.toArray(new RevAcctMatrixInfoVO[models.size()]);
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
		this.repChgCd = this.repChgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arAcctCd = this.arAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankChgAcctCd = this.bankChgAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctEndDt = this.acctEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amtSgnCd = this.amtSgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctStDt = this.acctStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drCrTpCd = this.drCrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctMtxSeq = this.acctMtxSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCtnt1 = this.acctCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctTpNm = this.acctTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCtnt2 = this.acctCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCtnt3 = this.acctCtnt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCtnt4 = this.acctCtnt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCtnt5 = this.acctCtnt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCtnt6 = this.acctCtnt6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchFlg = this.searchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCtnt7 = this.acctCtnt7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.legrXchDiffLssAcctCd = this.legrXchDiffLssAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCtnt8 = this.acctCtnt8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.legrXchDiffIncmAcctCd = this.legrXchDiffIncmAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revAcctDivCd = this.revAcctDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clrAcctCd = this.clrAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payCurrXchAcctCd = this.payCurrXchAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payAcctCd = this.payAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctTpCd = this.acctTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
