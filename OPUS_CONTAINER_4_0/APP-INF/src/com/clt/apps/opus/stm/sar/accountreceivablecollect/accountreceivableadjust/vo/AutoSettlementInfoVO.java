/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AutoSettlementInfoVO.java
*@FileTitle : AutoSettlementInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.09  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo;

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

public class AutoSettlementInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AutoSettlementInfoVO> models = new ArrayList<AutoSettlementInfoVO>();
	
	/* Column Info */
	private String otsAdjSeq = null;
	/* Column Info */
	private String chgTpCd = null;
	/* Column Info */
	private String bilToCustCntCd = null;
	/* Column Info */
	private String adjKeyNo = null;
	/* Column Info */
	private String otsTpCd = null;
	/* Column Info */
	private String otsBalUsdAmt = null;
	/* Column Info */
	private String otsBalLoclAmt = null;
	/* Column Info */
	private String cltOfcCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String miscIncmLmtAmt = null;
	/* Column Info */
	private String sailArrDt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String otsBalAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fmtOtsBalUsdAmt = null;
	/* Column Info */
	private String adjNoKey = null;
	/* Column Info */
	private String adjNo = null;
	/* Column Info */
	private String otsSrcCd = null;
	/* Column Info */
	private String adjTpCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String blCurrCd = null;
	/* Column Info */
	private String fmtOtsBalAmt = null;
	/* Column Info */
	private String loclVvdCd = null;
	/* Column Info */
	private String bilToCustSeq = null;
	/* Column Info */
	private String fmtOtsBalLoclAmt = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String otsRmk = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String otsOfcCd = null;
	/* Column Info */
	private String batSeq = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String checkbox = null;
	/* Column Info */
	private String miscLssLmtAmt = null;
	/* Column Info */
	private String adjDt = null;
	/* Column Info */
	private String delFlag = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AutoSettlementInfoVO() {}

	public AutoSettlementInfoVO(String ibflag, String pagerows, String otsAdjSeq, String chgTpCd, String adjKeyNo, String bilToCustCntCd, String otsTpCd, String otsBalLoclAmt, String otsBalUsdAmt, String creDt, String cltOfcCd, String miscIncmLmtAmt, String sailArrDt, String blNo, String otsBalAmt, String adjNoKey, String adjNo, String otsSrcCd, String adjTpCd, String updUsrId, String updDt, String rhqCd, String blCurrCd, String loclVvdCd, String bilToCustSeq, String invNo, String creUsrId, String otsRmk, String otsOfcCd, String custCd, String checkbox, String miscLssLmtAmt, String adjDt, String delFlag, String fmtOtsBalAmt, String fmtOtsBalLoclAmt, String fmtOtsBalUsdAmt, String batSeq) {
		this.otsAdjSeq = otsAdjSeq;
		this.chgTpCd = chgTpCd;
		this.bilToCustCntCd = bilToCustCntCd;
		this.adjKeyNo = adjKeyNo;
		this.otsTpCd = otsTpCd;
		this.otsBalUsdAmt = otsBalUsdAmt;
		this.otsBalLoclAmt = otsBalLoclAmt;
		this.cltOfcCd = cltOfcCd;
		this.creDt = creDt;
		this.miscIncmLmtAmt = miscIncmLmtAmt;
		this.sailArrDt = sailArrDt;
		this.blNo = blNo;
		this.otsBalAmt = otsBalAmt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.fmtOtsBalUsdAmt = fmtOtsBalUsdAmt;
		this.adjNoKey = adjNoKey;
		this.adjNo = adjNo;
		this.otsSrcCd = otsSrcCd;
		this.adjTpCd = adjTpCd;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.rhqCd = rhqCd;
		this.blCurrCd = blCurrCd;
		this.fmtOtsBalAmt = fmtOtsBalAmt;
		this.loclVvdCd = loclVvdCd;
		this.bilToCustSeq = bilToCustSeq;
		this.fmtOtsBalLoclAmt = fmtOtsBalLoclAmt;
		this.invNo = invNo;
		this.otsRmk = otsRmk;
		this.creUsrId = creUsrId;
		this.otsOfcCd = otsOfcCd;
		this.batSeq = batSeq;
		this.custCd = custCd;
		this.checkbox = checkbox;
		this.miscLssLmtAmt = miscLssLmtAmt;
		this.adjDt = adjDt;
		this.delFlag = delFlag;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ots_adj_seq", getOtsAdjSeq());
		this.hashColumns.put("chg_tp_cd", getChgTpCd());
		this.hashColumns.put("bil_to_cust_cnt_cd", getBilToCustCntCd());
		this.hashColumns.put("adj_key_no", getAdjKeyNo());
		this.hashColumns.put("ots_tp_cd", getOtsTpCd());
		this.hashColumns.put("ots_bal_usd_amt", getOtsBalUsdAmt());
		this.hashColumns.put("ots_bal_locl_amt", getOtsBalLoclAmt());
		this.hashColumns.put("clt_ofc_cd", getCltOfcCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("misc_incm_lmt_amt", getMiscIncmLmtAmt());
		this.hashColumns.put("sail_arr_dt", getSailArrDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("ots_bal_amt", getOtsBalAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fmt_ots_bal_usd_amt", getFmtOtsBalUsdAmt());
		this.hashColumns.put("adj_no_key", getAdjNoKey());
		this.hashColumns.put("adj_no", getAdjNo());
		this.hashColumns.put("ots_src_cd", getOtsSrcCd());
		this.hashColumns.put("adj_tp_cd", getAdjTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("bl_curr_cd", getBlCurrCd());
		this.hashColumns.put("fmt_ots_bal_amt", getFmtOtsBalAmt());
		this.hashColumns.put("locl_vvd_cd", getLoclVvdCd());
		this.hashColumns.put("bil_to_cust_seq", getBilToCustSeq());
		this.hashColumns.put("fmt_ots_bal_locl_amt", getFmtOtsBalLoclAmt());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("ots_rmk", getOtsRmk());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ots_ofc_cd", getOtsOfcCd());
		this.hashColumns.put("bat_seq", getBatSeq());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("checkbox", getCheckbox());
		this.hashColumns.put("misc_lss_lmt_amt", getMiscLssLmtAmt());
		this.hashColumns.put("adj_dt", getAdjDt());
		this.hashColumns.put("del_flag", getDelFlag());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ots_adj_seq", "otsAdjSeq");
		this.hashFields.put("chg_tp_cd", "chgTpCd");
		this.hashFields.put("bil_to_cust_cnt_cd", "bilToCustCntCd");
		this.hashFields.put("adj_key_no", "adjKeyNo");
		this.hashFields.put("ots_tp_cd", "otsTpCd");
		this.hashFields.put("ots_bal_usd_amt", "otsBalUsdAmt");
		this.hashFields.put("ots_bal_locl_amt", "otsBalLoclAmt");
		this.hashFields.put("clt_ofc_cd", "cltOfcCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("misc_incm_lmt_amt", "miscIncmLmtAmt");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("ots_bal_amt", "otsBalAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fmt_ots_bal_usd_amt", "fmtOtsBalUsdAmt");
		this.hashFields.put("adj_no_key", "adjNoKey");
		this.hashFields.put("adj_no", "adjNo");
		this.hashFields.put("ots_src_cd", "otsSrcCd");
		this.hashFields.put("adj_tp_cd", "adjTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("bl_curr_cd", "blCurrCd");
		this.hashFields.put("fmt_ots_bal_amt", "fmtOtsBalAmt");
		this.hashFields.put("locl_vvd_cd", "loclVvdCd");
		this.hashFields.put("bil_to_cust_seq", "bilToCustSeq");
		this.hashFields.put("fmt_ots_bal_locl_amt", "fmtOtsBalLoclAmt");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("ots_rmk", "otsRmk");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ots_ofc_cd", "otsOfcCd");
		this.hashFields.put("bat_seq", "batSeq");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("checkbox", "checkbox");
		this.hashFields.put("misc_lss_lmt_amt", "miscLssLmtAmt");
		this.hashFields.put("adj_dt", "adjDt");
		this.hashFields.put("del_flag", "delFlag");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return otsAdjSeq
	 */
	public String getOtsAdjSeq() {
		return this.otsAdjSeq;
	}
	
	/**
	 * Column Info
	 * @return chgTpCd
	 */
	public String getChgTpCd() {
		return this.chgTpCd;
	}
	
	/**
	 * Column Info
	 * @return bilToCustCntCd
	 */
	public String getBilToCustCntCd() {
		return this.bilToCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return adjKeyNo
	 */
	public String getAdjKeyNo() {
		return this.adjKeyNo;
	}
	
	/**
	 * Column Info
	 * @return otsTpCd
	 */
	public String getOtsTpCd() {
		return this.otsTpCd;
	}
	
	/**
	 * Column Info
	 * @return otsBalUsdAmt
	 */
	public String getOtsBalUsdAmt() {
		return this.otsBalUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return otsBalLoclAmt
	 */
	public String getOtsBalLoclAmt() {
		return this.otsBalLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return cltOfcCd
	 */
	public String getCltOfcCd() {
		return this.cltOfcCd;
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
	 * @return miscIncmLmtAmt
	 */
	public String getMiscIncmLmtAmt() {
		return this.miscIncmLmtAmt;
	}
	
	/**
	 * Column Info
	 * @return sailArrDt
	 */
	public String getSailArrDt() {
		return this.sailArrDt;
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
	 * @return otsBalAmt
	 */
	public String getOtsBalAmt() {
		return this.otsBalAmt;
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
	 * @return fmtOtsBalUsdAmt
	 */
	public String getFmtOtsBalUsdAmt() {
		return this.fmtOtsBalUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return adjNoKey
	 */
	public String getAdjNoKey() {
		return this.adjNoKey;
	}
	
	/**
	 * Column Info
	 * @return adjNo
	 */
	public String getAdjNo() {
		return this.adjNo;
	}
	
	/**
	 * Column Info
	 * @return otsSrcCd
	 */
	public String getOtsSrcCd() {
		return this.otsSrcCd;
	}
	
	/**
	 * Column Info
	 * @return adjTpCd
	 */
	public String getAdjTpCd() {
		return this.adjTpCd;
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
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return blCurrCd
	 */
	public String getBlCurrCd() {
		return this.blCurrCd;
	}
	
	/**
	 * Column Info
	 * @return fmtOtsBalAmt
	 */
	public String getFmtOtsBalAmt() {
		return this.fmtOtsBalAmt;
	}
	
	/**
	 * Column Info
	 * @return loclVvdCd
	 */
	public String getLoclVvdCd() {
		return this.loclVvdCd;
	}
	
	/**
	 * Column Info
	 * @return bilToCustSeq
	 */
	public String getBilToCustSeq() {
		return this.bilToCustSeq;
	}
	
	/**
	 * Column Info
	 * @return fmtOtsBalLoclAmt
	 */
	public String getFmtOtsBalLoclAmt() {
		return this.fmtOtsBalLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 * Column Info
	 * @return otsRmk
	 */
	public String getOtsRmk() {
		return this.otsRmk;
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
	 * @return otsOfcCd
	 */
	public String getOtsOfcCd() {
		return this.otsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return batSeq
	 */
	public String getBatSeq() {
		return this.batSeq;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return checkbox
	 */
	public String getCheckbox() {
		return this.checkbox;
	}
	
	/**
	 * Column Info
	 * @return miscLssLmtAmt
	 */
	public String getMiscLssLmtAmt() {
		return this.miscLssLmtAmt;
	}
	
	/**
	 * Column Info
	 * @return adjDt
	 */
	public String getAdjDt() {
		return this.adjDt;
	}
	
	/**
	 * Column Info
	 * @return delFlag
	 */
	public String getDelFlag() {
		return this.delFlag;
	}
	

	/**
	 * Column Info
	 * @param otsAdjSeq
	 */
	public void setOtsAdjSeq(String otsAdjSeq) {
		this.otsAdjSeq = otsAdjSeq;
	}
	
	/**
	 * Column Info
	 * @param chgTpCd
	 */
	public void setChgTpCd(String chgTpCd) {
		this.chgTpCd = chgTpCd;
	}
	
	/**
	 * Column Info
	 * @param bilToCustCntCd
	 */
	public void setBilToCustCntCd(String bilToCustCntCd) {
		this.bilToCustCntCd = bilToCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param adjKeyNo
	 */
	public void setAdjKeyNo(String adjKeyNo) {
		this.adjKeyNo = adjKeyNo;
	}
	
	/**
	 * Column Info
	 * @param otsTpCd
	 */
	public void setOtsTpCd(String otsTpCd) {
		this.otsTpCd = otsTpCd;
	}
	
	/**
	 * Column Info
	 * @param otsBalUsdAmt
	 */
	public void setOtsBalUsdAmt(String otsBalUsdAmt) {
		this.otsBalUsdAmt = otsBalUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param otsBalLoclAmt
	 */
	public void setOtsBalLoclAmt(String otsBalLoclAmt) {
		this.otsBalLoclAmt = otsBalLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param cltOfcCd
	 */
	public void setCltOfcCd(String cltOfcCd) {
		this.cltOfcCd = cltOfcCd;
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
	 * @param miscIncmLmtAmt
	 */
	public void setMiscIncmLmtAmt(String miscIncmLmtAmt) {
		this.miscIncmLmtAmt = miscIncmLmtAmt;
	}
	
	/**
	 * Column Info
	 * @param sailArrDt
	 */
	public void setSailArrDt(String sailArrDt) {
		this.sailArrDt = sailArrDt;
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
	 * @param otsBalAmt
	 */
	public void setOtsBalAmt(String otsBalAmt) {
		this.otsBalAmt = otsBalAmt;
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
	 * @param fmtOtsBalUsdAmt
	 */
	public void setFmtOtsBalUsdAmt(String fmtOtsBalUsdAmt) {
		this.fmtOtsBalUsdAmt = fmtOtsBalUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param adjNoKey
	 */
	public void setAdjNoKey(String adjNoKey) {
		this.adjNoKey = adjNoKey;
	}
	
	/**
	 * Column Info
	 * @param adjNo
	 */
	public void setAdjNo(String adjNo) {
		this.adjNo = adjNo;
	}
	
	/**
	 * Column Info
	 * @param otsSrcCd
	 */
	public void setOtsSrcCd(String otsSrcCd) {
		this.otsSrcCd = otsSrcCd;
	}
	
	/**
	 * Column Info
	 * @param adjTpCd
	 */
	public void setAdjTpCd(String adjTpCd) {
		this.adjTpCd = adjTpCd;
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
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param blCurrCd
	 */
	public void setBlCurrCd(String blCurrCd) {
		this.blCurrCd = blCurrCd;
	}
	
	/**
	 * Column Info
	 * @param fmtOtsBalAmt
	 */
	public void setFmtOtsBalAmt(String fmtOtsBalAmt) {
		this.fmtOtsBalAmt = fmtOtsBalAmt;
	}
	
	/**
	 * Column Info
	 * @param loclVvdCd
	 */
	public void setLoclVvdCd(String loclVvdCd) {
		this.loclVvdCd = loclVvdCd;
	}
	
	/**
	 * Column Info
	 * @param bilToCustSeq
	 */
	public void setBilToCustSeq(String bilToCustSeq) {
		this.bilToCustSeq = bilToCustSeq;
	}
	
	/**
	 * Column Info
	 * @param fmtOtsBalLoclAmt
	 */
	public void setFmtOtsBalLoclAmt(String fmtOtsBalLoclAmt) {
		this.fmtOtsBalLoclAmt = fmtOtsBalLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @param otsRmk
	 */
	public void setOtsRmk(String otsRmk) {
		this.otsRmk = otsRmk;
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
	 * @param otsOfcCd
	 */
	public void setOtsOfcCd(String otsOfcCd) {
		this.otsOfcCd = otsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param batSeq
	 */
	public void setBatSeq(String batSeq) {
		this.batSeq = batSeq;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param checkbox
	 */
	public void setCheckbox(String checkbox) {
		this.checkbox = checkbox;
	}
	
	/**
	 * Column Info
	 * @param miscLssLmtAmt
	 */
	public void setMiscLssLmtAmt(String miscLssLmtAmt) {
		this.miscLssLmtAmt = miscLssLmtAmt;
	}
	
	/**
	 * Column Info
	 * @param adjDt
	 */
	public void setAdjDt(String adjDt) {
		this.adjDt = adjDt;
	}
	
	/**
	 * Column Info
	 * @param delFlag
	 */
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
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
		setOtsAdjSeq(JSPUtil.getParameter(request, prefix + "ots_adj_seq", ""));
		setChgTpCd(JSPUtil.getParameter(request, prefix + "chg_tp_cd", ""));
		setBilToCustCntCd(JSPUtil.getParameter(request, prefix + "bil_to_cust_cnt_cd", ""));
		setAdjKeyNo(JSPUtil.getParameter(request, prefix + "adj_key_no", ""));
		setOtsTpCd(JSPUtil.getParameter(request, prefix + "ots_tp_cd", ""));
		setOtsBalUsdAmt(JSPUtil.getParameter(request, prefix + "ots_bal_usd_amt", ""));
		setOtsBalLoclAmt(JSPUtil.getParameter(request, prefix + "ots_bal_locl_amt", ""));
		setCltOfcCd(JSPUtil.getParameter(request, prefix + "clt_ofc_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setMiscIncmLmtAmt(JSPUtil.getParameter(request, prefix + "misc_incm_lmt_amt", ""));
		setSailArrDt(JSPUtil.getParameter(request, prefix + "sail_arr_dt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setOtsBalAmt(JSPUtil.getParameter(request, prefix + "ots_bal_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFmtOtsBalUsdAmt(JSPUtil.getParameter(request, prefix + "fmt_ots_bal_usd_amt", ""));
		setAdjNoKey(JSPUtil.getParameter(request, prefix + "adj_no_key", ""));
		setAdjNo(JSPUtil.getParameter(request, prefix + "adj_no", ""));
		setOtsSrcCd(JSPUtil.getParameter(request, prefix + "ots_src_cd", ""));
		setAdjTpCd(JSPUtil.getParameter(request, prefix + "adj_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setBlCurrCd(JSPUtil.getParameter(request, prefix + "bl_curr_cd", ""));
		setFmtOtsBalAmt(JSPUtil.getParameter(request, prefix + "fmt_ots_bal_amt", ""));
		setLoclVvdCd(JSPUtil.getParameter(request, prefix + "locl_vvd_cd", ""));
		setBilToCustSeq(JSPUtil.getParameter(request, prefix + "bil_to_cust_seq", ""));
		setFmtOtsBalLoclAmt(JSPUtil.getParameter(request, prefix + "fmt_ots_bal_locl_amt", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setOtsRmk(JSPUtil.getParameter(request, prefix + "ots_rmk", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setOtsOfcCd(JSPUtil.getParameter(request, prefix + "ots_ofc_cd", ""));
		setBatSeq(JSPUtil.getParameter(request, prefix + "bat_seq", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setCheckbox(JSPUtil.getParameter(request, prefix + "checkbox", ""));
		setMiscLssLmtAmt(JSPUtil.getParameter(request, prefix + "misc_lss_lmt_amt", ""));
		setAdjDt(JSPUtil.getParameter(request, prefix + "adj_dt", ""));
		setDelFlag(JSPUtil.getParameter(request, prefix + "del_flag", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AutoSettlementInfoVO[]
	 */
	public AutoSettlementInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AutoSettlementInfoVO[]
	 */
	public AutoSettlementInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AutoSettlementInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] otsAdjSeq = (JSPUtil.getParameter(request, prefix	+ "ots_adj_seq", length));
			String[] chgTpCd = (JSPUtil.getParameter(request, prefix	+ "chg_tp_cd", length));
			String[] bilToCustCntCd = (JSPUtil.getParameter(request, prefix	+ "bil_to_cust_cnt_cd", length));
			String[] adjKeyNo = (JSPUtil.getParameter(request, prefix	+ "adj_key_no", length));
			String[] otsTpCd = (JSPUtil.getParameter(request, prefix	+ "ots_tp_cd", length));
			String[] otsBalUsdAmt = (JSPUtil.getParameter(request, prefix	+ "ots_bal_usd_amt", length));
			String[] otsBalLoclAmt = (JSPUtil.getParameter(request, prefix	+ "ots_bal_locl_amt", length));
			String[] cltOfcCd = (JSPUtil.getParameter(request, prefix	+ "clt_ofc_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] miscIncmLmtAmt = (JSPUtil.getParameter(request, prefix	+ "misc_incm_lmt_amt", length));
			String[] sailArrDt = (JSPUtil.getParameter(request, prefix	+ "sail_arr_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] otsBalAmt = (JSPUtil.getParameter(request, prefix	+ "ots_bal_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fmtOtsBalUsdAmt = (JSPUtil.getParameter(request, prefix	+ "fmt_ots_bal_usd_amt", length));
			String[] adjNoKey = (JSPUtil.getParameter(request, prefix	+ "adj_no_key", length));
			String[] adjNo = (JSPUtil.getParameter(request, prefix	+ "adj_no", length));
			String[] otsSrcCd = (JSPUtil.getParameter(request, prefix	+ "ots_src_cd", length));
			String[] adjTpCd = (JSPUtil.getParameter(request, prefix	+ "adj_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] blCurrCd = (JSPUtil.getParameter(request, prefix	+ "bl_curr_cd", length));
			String[] fmtOtsBalAmt = (JSPUtil.getParameter(request, prefix	+ "fmt_ots_bal_amt", length));
			String[] loclVvdCd = (JSPUtil.getParameter(request, prefix	+ "locl_vvd_cd", length));
			String[] bilToCustSeq = (JSPUtil.getParameter(request, prefix	+ "bil_to_cust_seq", length));
			String[] fmtOtsBalLoclAmt = (JSPUtil.getParameter(request, prefix	+ "fmt_ots_bal_locl_amt", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] otsRmk = (JSPUtil.getParameter(request, prefix	+ "ots_rmk", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] otsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ots_ofc_cd", length));
			String[] batSeq = (JSPUtil.getParameter(request, prefix	+ "bat_seq", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] checkbox = (JSPUtil.getParameter(request, prefix	+ "checkbox", length));
			String[] miscLssLmtAmt = (JSPUtil.getParameter(request, prefix	+ "misc_lss_lmt_amt", length));
			String[] adjDt = (JSPUtil.getParameter(request, prefix	+ "adj_dt", length));
			String[] delFlag = (JSPUtil.getParameter(request, prefix	+ "del_flag", length));
			
			for (int i = 0; i < length; i++) {
				model = new AutoSettlementInfoVO();
				if (otsAdjSeq[i] != null)
					model.setOtsAdjSeq(otsAdjSeq[i]);
				if (chgTpCd[i] != null)
					model.setChgTpCd(chgTpCd[i]);
				if (bilToCustCntCd[i] != null)
					model.setBilToCustCntCd(bilToCustCntCd[i]);
				if (adjKeyNo[i] != null)
					model.setAdjKeyNo(adjKeyNo[i]);
				if (otsTpCd[i] != null)
					model.setOtsTpCd(otsTpCd[i]);
				if (otsBalUsdAmt[i] != null)
					model.setOtsBalUsdAmt(otsBalUsdAmt[i]);
				if (otsBalLoclAmt[i] != null)
					model.setOtsBalLoclAmt(otsBalLoclAmt[i]);
				if (cltOfcCd[i] != null)
					model.setCltOfcCd(cltOfcCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (miscIncmLmtAmt[i] != null)
					model.setMiscIncmLmtAmt(miscIncmLmtAmt[i]);
				if (sailArrDt[i] != null)
					model.setSailArrDt(sailArrDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (otsBalAmt[i] != null)
					model.setOtsBalAmt(otsBalAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fmtOtsBalUsdAmt[i] != null)
					model.setFmtOtsBalUsdAmt(fmtOtsBalUsdAmt[i]);
				if (adjNoKey[i] != null)
					model.setAdjNoKey(adjNoKey[i]);
				if (adjNo[i] != null)
					model.setAdjNo(adjNo[i]);
				if (otsSrcCd[i] != null)
					model.setOtsSrcCd(otsSrcCd[i]);
				if (adjTpCd[i] != null)
					model.setAdjTpCd(adjTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (blCurrCd[i] != null)
					model.setBlCurrCd(blCurrCd[i]);
				if (fmtOtsBalAmt[i] != null)
					model.setFmtOtsBalAmt(fmtOtsBalAmt[i]);
				if (loclVvdCd[i] != null)
					model.setLoclVvdCd(loclVvdCd[i]);
				if (bilToCustSeq[i] != null)
					model.setBilToCustSeq(bilToCustSeq[i]);
				if (fmtOtsBalLoclAmt[i] != null)
					model.setFmtOtsBalLoclAmt(fmtOtsBalLoclAmt[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (otsRmk[i] != null)
					model.setOtsRmk(otsRmk[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (otsOfcCd[i] != null)
					model.setOtsOfcCd(otsOfcCd[i]);
				if (batSeq[i] != null)
					model.setBatSeq(batSeq[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (checkbox[i] != null)
					model.setCheckbox(checkbox[i]);
				if (miscLssLmtAmt[i] != null)
					model.setMiscLssLmtAmt(miscLssLmtAmt[i]);
				if (adjDt[i] != null)
					model.setAdjDt(adjDt[i]);
				if (delFlag[i] != null)
					model.setDelFlag(delFlag[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAutoSettlementInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AutoSettlementInfoVO[]
	 */
	public AutoSettlementInfoVO[] getAutoSettlementInfoVOs(){
		AutoSettlementInfoVO[] vos = (AutoSettlementInfoVO[])models.toArray(new AutoSettlementInfoVO[models.size()]);
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
		this.otsAdjSeq = this.otsAdjSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgTpCd = this.chgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilToCustCntCd = this.bilToCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjKeyNo = this.adjKeyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsTpCd = this.otsTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsBalUsdAmt = this.otsBalUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsBalLoclAmt = this.otsBalLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltOfcCd = this.cltOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.miscIncmLmtAmt = this.miscIncmLmtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt = this.sailArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsBalAmt = this.otsBalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtOtsBalUsdAmt = this.fmtOtsBalUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjNoKey = this.adjNoKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjNo = this.adjNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsSrcCd = this.otsSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjTpCd = this.adjTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCurrCd = this.blCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtOtsBalAmt = this.fmtOtsBalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclVvdCd = this.loclVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilToCustSeq = this.bilToCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtOtsBalLoclAmt = this.fmtOtsBalLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsRmk = this.otsRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsOfcCd = this.otsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batSeq = this.batSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkbox = this.checkbox .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.miscLssLmtAmt = this.miscLssLmtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjDt = this.adjDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delFlag = this.delFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
