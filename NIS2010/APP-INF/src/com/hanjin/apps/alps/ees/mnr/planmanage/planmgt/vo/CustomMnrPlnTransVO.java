/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomMnrPlnTransVO.java
*@FileTitle : CustomMnrPlnTransVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.08.25 김완규 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김완규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomMnrPlnTransVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomMnrPlnTransVO> models = new ArrayList<CustomMnrPlnTransVO>();
	
	/* Column Info */
	private String total = null;
	/* Column Info */
	private String cntr2ChgVal = null;
	/* Column Info */
	private String cntr13ChgVal = null;
	/* Column Info */
	private String mnrGrpTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cntr14ChgVal = null;
	/* Column Info */
	private String eqQty = null;
	/* Column Info */
	private String mnrPlnGrpNo = null;
	/* Column Info */
	private String cntr6ChgVal = null;
	/* Column Info */
	private String cntr25ChgVal = null;
	/* Column Info */
	private String cntr7ChgVal = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String cntr22ChgVal = null;
	/* Column Info */
	private String cntr30ChgVal = null;
	/* Column Info */
	private String cntr4ChgVal = null;
	/* Column Info */
	private String mnrPlnDtlSeq = null;
	/* Column Info */
	private String cntr27ChgVal = null;
	/* Column Info */
	private String cntr29ChgVal = null;
	/* Column Info */
	private String ctrlOfcCd = null;
	/* Column Info */
	private String cntr16ChgVal = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cntr1ChgVal = null;
	/* Column Info */
	private String cntr5ChgVal = null;
	/* Column Info */
	private String cntr11ChgVal = null;
	/* Column Info */
	private String cntr18ChgVal = null;
	/* Column Info */
	private String mnrPlnRmk = null;
	/* Column Info */
	private String cntr9ChgVal = null;
	/* Column Info */
	private String cntr10ChgVal = null;
	/* Column Info */
	private String cntr26ChgVal = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String cntr23ChgVal = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String mnrPlnFlg = null;
	/* Column Info */
	private String cntr19ChgVal = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mnrPlnSeq = null;
	/* Column Info */
	private String cntr17ChgVal = null;
	/* Column Info */
	private String cntr15ChgVal = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String cntr20ChgVal = null;
	/* Column Info */
	private String cntr3ChgVal = null;
	/* Column Info */
	private String cntr8ChgVal = null;
	/* Column Info */
	private String cntr28ChgVal = null;
	/* Column Info */
	private String office = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String mnrPlnOfcCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String mnrPlnYr = null;
	/* Column Info */
	private String mnrPlnAmt = null;
	/* Column Info */
	private String sheetGubn = null;
	/* Column Info */
	private String mnrPlnDtlRmk = null;
	/* Column Info */
	private String cntr21ChgVal = null;
	/* Column Info */
	private String cntr12ChgVal = null;
	/* Column Info */
	private String cntr24ChgVal = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomMnrPlnTransVO() {}

	public CustomMnrPlnTransVO(String ibflag, String pagerows, String mnrPlnSeq, String eqKndCd, String mnrPlnYr, String mnrGrpTpCd, String mnrPlnGrpNo, String mnrPlnRmk, String mnrPlnOfcCd, String mnrPlnFlg, String mnrPlnDtlSeq, String ctrlOfcCd, String eqTpszCd, String eqQty, String acctCd, String mnrPlnAmt, String mnrPlnDtlRmk, String creUsrId, String creDt, String updUsrId, String updDt, String currCd, String cntr1ChgVal, String cntr2ChgVal, String cntr3ChgVal, String cntr4ChgVal, String cntr5ChgVal, String cntr6ChgVal, String cntr7ChgVal, String cntr8ChgVal, String cntr9ChgVal, String cntr10ChgVal, String cntr11ChgVal, String cntr12ChgVal, String cntr13ChgVal, String cntr14ChgVal, String cntr15ChgVal, String cntr16ChgVal, String cntr17ChgVal, String cntr18ChgVal, String cntr19ChgVal, String cntr20ChgVal, String cntr21ChgVal, String cntr22ChgVal, String cntr23ChgVal, String cntr24ChgVal, String cntr25ChgVal, String cntr26ChgVal, String cntr27ChgVal, String cntr28ChgVal, String cntr29ChgVal, String cntr30ChgVal, String total, String office, String sheetGubn) {
		this.total = total;
		this.cntr2ChgVal = cntr2ChgVal;
		this.cntr13ChgVal = cntr13ChgVal;
		this.mnrGrpTpCd = mnrGrpTpCd;
		this.pagerows = pagerows;
		this.cntr14ChgVal = cntr14ChgVal;
		this.eqQty = eqQty;
		this.mnrPlnGrpNo = mnrPlnGrpNo;
		this.cntr6ChgVal = cntr6ChgVal;
		this.cntr25ChgVal = cntr25ChgVal;
		this.cntr7ChgVal = cntr7ChgVal;
		this.updUsrId = updUsrId;
		this.cntr22ChgVal = cntr22ChgVal;
		this.cntr30ChgVal = cntr30ChgVal;
		this.cntr4ChgVal = cntr4ChgVal;
		this.mnrPlnDtlSeq = mnrPlnDtlSeq;
		this.cntr27ChgVal = cntr27ChgVal;
		this.cntr29ChgVal = cntr29ChgVal;
		this.ctrlOfcCd = ctrlOfcCd;
		this.cntr16ChgVal = cntr16ChgVal;
		this.eqTpszCd = eqTpszCd;
		this.creUsrId = creUsrId;
		this.cntr1ChgVal = cntr1ChgVal;
		this.cntr5ChgVal = cntr5ChgVal;
		this.cntr11ChgVal = cntr11ChgVal;
		this.cntr18ChgVal = cntr18ChgVal;
		this.mnrPlnRmk = mnrPlnRmk;
		this.cntr9ChgVal = cntr9ChgVal;
		this.cntr10ChgVal = cntr10ChgVal;
		this.cntr26ChgVal = cntr26ChgVal;
		this.currCd = currCd;
		this.cntr23ChgVal = cntr23ChgVal;
		this.creDt = creDt;
		this.mnrPlnFlg = mnrPlnFlg;
		this.cntr19ChgVal = cntr19ChgVal;
		this.ibflag = ibflag;
		this.mnrPlnSeq = mnrPlnSeq;
		this.cntr17ChgVal = cntr17ChgVal;
		this.cntr15ChgVal = cntr15ChgVal;
		this.acctCd = acctCd;
		this.cntr20ChgVal = cntr20ChgVal;
		this.cntr3ChgVal = cntr3ChgVal;
		this.cntr8ChgVal = cntr8ChgVal;
		this.cntr28ChgVal = cntr28ChgVal;
		this.office = office;
		this.updDt = updDt;
		this.mnrPlnOfcCd = mnrPlnOfcCd;
		this.eqKndCd = eqKndCd;
		this.mnrPlnYr = mnrPlnYr;
		this.mnrPlnAmt = mnrPlnAmt;
		this.sheetGubn = sheetGubn;
		this.mnrPlnDtlRmk = mnrPlnDtlRmk;
		this.cntr21ChgVal = cntr21ChgVal;
		this.cntr12ChgVal = cntr12ChgVal;
		this.cntr24ChgVal = cntr24ChgVal;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("cntr2_chg_val", getCntr2ChgVal());
		this.hashColumns.put("cntr13_chg_val", getCntr13ChgVal());
		this.hashColumns.put("mnr_grp_tp_cd", getMnrGrpTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cntr14_chg_val", getCntr14ChgVal());
		this.hashColumns.put("eq_qty", getEqQty());
		this.hashColumns.put("mnr_pln_grp_no", getMnrPlnGrpNo());
		this.hashColumns.put("cntr6_chg_val", getCntr6ChgVal());
		this.hashColumns.put("cntr25_chg_val", getCntr25ChgVal());
		this.hashColumns.put("cntr7_chg_val", getCntr7ChgVal());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cntr22_chg_val", getCntr22ChgVal());
		this.hashColumns.put("cntr30_chg_val", getCntr30ChgVal());
		this.hashColumns.put("cntr4_chg_val", getCntr4ChgVal());
		this.hashColumns.put("mnr_pln_dtl_seq", getMnrPlnDtlSeq());
		this.hashColumns.put("cntr27_chg_val", getCntr27ChgVal());
		this.hashColumns.put("cntr29_chg_val", getCntr29ChgVal());
		this.hashColumns.put("ctrl_ofc_cd", getCtrlOfcCd());
		this.hashColumns.put("cntr16_chg_val", getCntr16ChgVal());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cntr1_chg_val", getCntr1ChgVal());
		this.hashColumns.put("cntr5_chg_val", getCntr5ChgVal());
		this.hashColumns.put("cntr11_chg_val", getCntr11ChgVal());
		this.hashColumns.put("cntr18_chg_val", getCntr18ChgVal());
		this.hashColumns.put("mnr_pln_rmk", getMnrPlnRmk());
		this.hashColumns.put("cntr9_chg_val", getCntr9ChgVal());
		this.hashColumns.put("cntr10_chg_val", getCntr10ChgVal());
		this.hashColumns.put("cntr26_chg_val", getCntr26ChgVal());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cntr23_chg_val", getCntr23ChgVal());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("mnr_pln_flg", getMnrPlnFlg());
		this.hashColumns.put("cntr19_chg_val", getCntr19ChgVal());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mnr_pln_seq", getMnrPlnSeq());
		this.hashColumns.put("cntr17_chg_val", getCntr17ChgVal());
		this.hashColumns.put("cntr15_chg_val", getCntr15ChgVal());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("cntr20_chg_val", getCntr20ChgVal());
		this.hashColumns.put("cntr3_chg_val", getCntr3ChgVal());
		this.hashColumns.put("cntr8_chg_val", getCntr8ChgVal());
		this.hashColumns.put("cntr28_chg_val", getCntr28ChgVal());
		this.hashColumns.put("office", getOffice());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("mnr_pln_ofc_cd", getMnrPlnOfcCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("mnr_pln_yr", getMnrPlnYr());
		this.hashColumns.put("mnr_pln_amt", getMnrPlnAmt());
		this.hashColumns.put("sheet_gubn", getSheetGubn());
		this.hashColumns.put("mnr_pln_dtl_rmk", getMnrPlnDtlRmk());
		this.hashColumns.put("cntr21_chg_val", getCntr21ChgVal());
		this.hashColumns.put("cntr12_chg_val", getCntr12ChgVal());
		this.hashColumns.put("cntr24_chg_val", getCntr24ChgVal());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("total", "total");
		this.hashFields.put("cntr2_chg_val", "cntr2ChgVal");
		this.hashFields.put("cntr13_chg_val", "cntr13ChgVal");
		this.hashFields.put("mnr_grp_tp_cd", "mnrGrpTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cntr14_chg_val", "cntr14ChgVal");
		this.hashFields.put("eq_qty", "eqQty");
		this.hashFields.put("mnr_pln_grp_no", "mnrPlnGrpNo");
		this.hashFields.put("cntr6_chg_val", "cntr6ChgVal");
		this.hashFields.put("cntr25_chg_val", "cntr25ChgVal");
		this.hashFields.put("cntr7_chg_val", "cntr7ChgVal");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cntr22_chg_val", "cntr22ChgVal");
		this.hashFields.put("cntr30_chg_val", "cntr30ChgVal");
		this.hashFields.put("cntr4_chg_val", "cntr4ChgVal");
		this.hashFields.put("mnr_pln_dtl_seq", "mnrPlnDtlSeq");
		this.hashFields.put("cntr27_chg_val", "cntr27ChgVal");
		this.hashFields.put("cntr29_chg_val", "cntr29ChgVal");
		this.hashFields.put("ctrl_ofc_cd", "ctrlOfcCd");
		this.hashFields.put("cntr16_chg_val", "cntr16ChgVal");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cntr1_chg_val", "cntr1ChgVal");
		this.hashFields.put("cntr5_chg_val", "cntr5ChgVal");
		this.hashFields.put("cntr11_chg_val", "cntr11ChgVal");
		this.hashFields.put("cntr18_chg_val", "cntr18ChgVal");
		this.hashFields.put("mnr_pln_rmk", "mnrPlnRmk");
		this.hashFields.put("cntr9_chg_val", "cntr9ChgVal");
		this.hashFields.put("cntr10_chg_val", "cntr10ChgVal");
		this.hashFields.put("cntr26_chg_val", "cntr26ChgVal");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cntr23_chg_val", "cntr23ChgVal");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("mnr_pln_flg", "mnrPlnFlg");
		this.hashFields.put("cntr19_chg_val", "cntr19ChgVal");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mnr_pln_seq", "mnrPlnSeq");
		this.hashFields.put("cntr17_chg_val", "cntr17ChgVal");
		this.hashFields.put("cntr15_chg_val", "cntr15ChgVal");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("cntr20_chg_val", "cntr20ChgVal");
		this.hashFields.put("cntr3_chg_val", "cntr3ChgVal");
		this.hashFields.put("cntr8_chg_val", "cntr8ChgVal");
		this.hashFields.put("cntr28_chg_val", "cntr28ChgVal");
		this.hashFields.put("office", "office");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("mnr_pln_ofc_cd", "mnrPlnOfcCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("mnr_pln_yr", "mnrPlnYr");
		this.hashFields.put("mnr_pln_amt", "mnrPlnAmt");
		this.hashFields.put("sheet_gubn", "sheetGubn");
		this.hashFields.put("mnr_pln_dtl_rmk", "mnrPlnDtlRmk");
		this.hashFields.put("cntr21_chg_val", "cntr21ChgVal");
		this.hashFields.put("cntr12_chg_val", "cntr12ChgVal");
		this.hashFields.put("cntr24_chg_val", "cntr24ChgVal");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return total
	 */
	public String getTotal() {
		return this.total;
	}
	
	/**
	 * Column Info
	 * @return cntr2ChgVal
	 */
	public String getCntr2ChgVal() {
		return this.cntr2ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr13ChgVal
	 */
	public String getCntr13ChgVal() {
		return this.cntr13ChgVal;
	}
	
	/**
	 * Column Info
	 * @return mnrGrpTpCd
	 */
	public String getMnrGrpTpCd() {
		return this.mnrGrpTpCd;
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
	 * @return cntr14ChgVal
	 */
	public String getCntr14ChgVal() {
		return this.cntr14ChgVal;
	}
	
	/**
	 * Column Info
	 * @return eqQty
	 */
	public String getEqQty() {
		return this.eqQty;
	}
	
	/**
	 * Column Info
	 * @return mnrPlnGrpNo
	 */
	public String getMnrPlnGrpNo() {
		return this.mnrPlnGrpNo;
	}
	
	/**
	 * Column Info
	 * @return cntr6ChgVal
	 */
	public String getCntr6ChgVal() {
		return this.cntr6ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr25ChgVal
	 */
	public String getCntr25ChgVal() {
		return this.cntr25ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr7ChgVal
	 */
	public String getCntr7ChgVal() {
		return this.cntr7ChgVal;
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
	 * @return cntr22ChgVal
	 */
	public String getCntr22ChgVal() {
		return this.cntr22ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr30ChgVal
	 */
	public String getCntr30ChgVal() {
		return this.cntr30ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr4ChgVal
	 */
	public String getCntr4ChgVal() {
		return this.cntr4ChgVal;
	}
	
	/**
	 * Column Info
	 * @return mnrPlnDtlSeq
	 */
	public String getMnrPlnDtlSeq() {
		return this.mnrPlnDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return cntr27ChgVal
	 */
	public String getCntr27ChgVal() {
		return this.cntr27ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr29ChgVal
	 */
	public String getCntr29ChgVal() {
		return this.cntr29ChgVal;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd
	 */
	public String getCtrlOfcCd() {
		return this.ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cntr16ChgVal
	 */
	public String getCntr16ChgVal() {
		return this.cntr16ChgVal;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
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
	 * @return cntr1ChgVal
	 */
	public String getCntr1ChgVal() {
		return this.cntr1ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr5ChgVal
	 */
	public String getCntr5ChgVal() {
		return this.cntr5ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr11ChgVal
	 */
	public String getCntr11ChgVal() {
		return this.cntr11ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr18ChgVal
	 */
	public String getCntr18ChgVal() {
		return this.cntr18ChgVal;
	}
	
	/**
	 * Column Info
	 * @return mnrPlnRmk
	 */
	public String getMnrPlnRmk() {
		return this.mnrPlnRmk;
	}
	
	/**
	 * Column Info
	 * @return cntr9ChgVal
	 */
	public String getCntr9ChgVal() {
		return this.cntr9ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr10ChgVal
	 */
	public String getCntr10ChgVal() {
		return this.cntr10ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr26ChgVal
	 */
	public String getCntr26ChgVal() {
		return this.cntr26ChgVal;
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
	 * @return cntr23ChgVal
	 */
	public String getCntr23ChgVal() {
		return this.cntr23ChgVal;
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
	 * @return mnrPlnFlg
	 */
	public String getMnrPlnFlg() {
		return this.mnrPlnFlg;
	}
	
	/**
	 * Column Info
	 * @return cntr19ChgVal
	 */
	public String getCntr19ChgVal() {
		return this.cntr19ChgVal;
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
	 * @return mnrPlnSeq
	 */
	public String getMnrPlnSeq() {
		return this.mnrPlnSeq;
	}
	
	/**
	 * Column Info
	 * @return cntr17ChgVal
	 */
	public String getCntr17ChgVal() {
		return this.cntr17ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr15ChgVal
	 */
	public String getCntr15ChgVal() {
		return this.cntr15ChgVal;
	}
	
	/**
	 * Column Info
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
	}
	
	/**
	 * Column Info
	 * @return cntr20ChgVal
	 */
	public String getCntr20ChgVal() {
		return this.cntr20ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr3ChgVal
	 */
	public String getCntr3ChgVal() {
		return this.cntr3ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr8ChgVal
	 */
	public String getCntr8ChgVal() {
		return this.cntr8ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr28ChgVal
	 */
	public String getCntr28ChgVal() {
		return this.cntr28ChgVal;
	}
	
	/**
	 * Column Info
	 * @return office
	 */
	public String getOffice() {
		return this.office;
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
	 * @return mnrPlnOfcCd
	 */
	public String getMnrPlnOfcCd() {
		return this.mnrPlnOfcCd;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return mnrPlnYr
	 */
	public String getMnrPlnYr() {
		return this.mnrPlnYr;
	}
	
	/**
	 * Column Info
	 * @return mnrPlnAmt
	 */
	public String getMnrPlnAmt() {
		return this.mnrPlnAmt;
	}
	
	/**
	 * Column Info
	 * @return sheetGubn
	 */
	public String getSheetGubn() {
		return this.sheetGubn;
	}
	
	/**
	 * Column Info
	 * @return mnrPlnDtlRmk
	 */
	public String getMnrPlnDtlRmk() {
		return this.mnrPlnDtlRmk;
	}
	
	/**
	 * Column Info
	 * @return cntr21ChgVal
	 */
	public String getCntr21ChgVal() {
		return this.cntr21ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr12ChgVal
	 */
	public String getCntr12ChgVal() {
		return this.cntr12ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr24ChgVal
	 */
	public String getCntr24ChgVal() {
		return this.cntr24ChgVal;
	}
	

	/**
	 * Column Info
	 * @param total
	 */
	public void setTotal(String total) {
		this.total = total;
	}
	
	/**
	 * Column Info
	 * @param cntr2ChgVal
	 */
	public void setCntr2ChgVal(String cntr2ChgVal) {
		this.cntr2ChgVal = cntr2ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr13ChgVal
	 */
	public void setCntr13ChgVal(String cntr13ChgVal) {
		this.cntr13ChgVal = cntr13ChgVal;
	}
	
	/**
	 * Column Info
	 * @param mnrGrpTpCd
	 */
	public void setMnrGrpTpCd(String mnrGrpTpCd) {
		this.mnrGrpTpCd = mnrGrpTpCd;
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
	 * @param cntr14ChgVal
	 */
	public void setCntr14ChgVal(String cntr14ChgVal) {
		this.cntr14ChgVal = cntr14ChgVal;
	}
	
	/**
	 * Column Info
	 * @param eqQty
	 */
	public void setEqQty(String eqQty) {
		this.eqQty = eqQty;
	}
	
	/**
	 * Column Info
	 * @param mnrPlnGrpNo
	 */
	public void setMnrPlnGrpNo(String mnrPlnGrpNo) {
		this.mnrPlnGrpNo = mnrPlnGrpNo;
	}
	
	/**
	 * Column Info
	 * @param cntr6ChgVal
	 */
	public void setCntr6ChgVal(String cntr6ChgVal) {
		this.cntr6ChgVal = cntr6ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr25ChgVal
	 */
	public void setCntr25ChgVal(String cntr25ChgVal) {
		this.cntr25ChgVal = cntr25ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr7ChgVal
	 */
	public void setCntr7ChgVal(String cntr7ChgVal) {
		this.cntr7ChgVal = cntr7ChgVal;
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
	 * @param cntr22ChgVal
	 */
	public void setCntr22ChgVal(String cntr22ChgVal) {
		this.cntr22ChgVal = cntr22ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr30ChgVal
	 */
	public void setCntr30ChgVal(String cntr30ChgVal) {
		this.cntr30ChgVal = cntr30ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr4ChgVal
	 */
	public void setCntr4ChgVal(String cntr4ChgVal) {
		this.cntr4ChgVal = cntr4ChgVal;
	}
	
	/**
	 * Column Info
	 * @param mnrPlnDtlSeq
	 */
	public void setMnrPlnDtlSeq(String mnrPlnDtlSeq) {
		this.mnrPlnDtlSeq = mnrPlnDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param cntr27ChgVal
	 */
	public void setCntr27ChgVal(String cntr27ChgVal) {
		this.cntr27ChgVal = cntr27ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr29ChgVal
	 */
	public void setCntr29ChgVal(String cntr29ChgVal) {
		this.cntr29ChgVal = cntr29ChgVal;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd
	 */
	public void setCtrlOfcCd(String ctrlOfcCd) {
		this.ctrlOfcCd = ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cntr16ChgVal
	 */
	public void setCntr16ChgVal(String cntr16ChgVal) {
		this.cntr16ChgVal = cntr16ChgVal;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
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
	 * @param cntr1ChgVal
	 */
	public void setCntr1ChgVal(String cntr1ChgVal) {
		this.cntr1ChgVal = cntr1ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr5ChgVal
	 */
	public void setCntr5ChgVal(String cntr5ChgVal) {
		this.cntr5ChgVal = cntr5ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr11ChgVal
	 */
	public void setCntr11ChgVal(String cntr11ChgVal) {
		this.cntr11ChgVal = cntr11ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr18ChgVal
	 */
	public void setCntr18ChgVal(String cntr18ChgVal) {
		this.cntr18ChgVal = cntr18ChgVal;
	}
	
	/**
	 * Column Info
	 * @param mnrPlnRmk
	 */
	public void setMnrPlnRmk(String mnrPlnRmk) {
		this.mnrPlnRmk = mnrPlnRmk;
	}
	
	/**
	 * Column Info
	 * @param cntr9ChgVal
	 */
	public void setCntr9ChgVal(String cntr9ChgVal) {
		this.cntr9ChgVal = cntr9ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr10ChgVal
	 */
	public void setCntr10ChgVal(String cntr10ChgVal) {
		this.cntr10ChgVal = cntr10ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr26ChgVal
	 */
	public void setCntr26ChgVal(String cntr26ChgVal) {
		this.cntr26ChgVal = cntr26ChgVal;
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
	 * @param cntr23ChgVal
	 */
	public void setCntr23ChgVal(String cntr23ChgVal) {
		this.cntr23ChgVal = cntr23ChgVal;
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
	 * @param mnrPlnFlg
	 */
	public void setMnrPlnFlg(String mnrPlnFlg) {
		this.mnrPlnFlg = mnrPlnFlg;
	}
	
	/**
	 * Column Info
	 * @param cntr19ChgVal
	 */
	public void setCntr19ChgVal(String cntr19ChgVal) {
		this.cntr19ChgVal = cntr19ChgVal;
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
	 * @param mnrPlnSeq
	 */
	public void setMnrPlnSeq(String mnrPlnSeq) {
		this.mnrPlnSeq = mnrPlnSeq;
	}
	
	/**
	 * Column Info
	 * @param cntr17ChgVal
	 */
	public void setCntr17ChgVal(String cntr17ChgVal) {
		this.cntr17ChgVal = cntr17ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr15ChgVal
	 */
	public void setCntr15ChgVal(String cntr15ChgVal) {
		this.cntr15ChgVal = cntr15ChgVal;
	}
	
	/**
	 * Column Info
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param cntr20ChgVal
	 */
	public void setCntr20ChgVal(String cntr20ChgVal) {
		this.cntr20ChgVal = cntr20ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr3ChgVal
	 */
	public void setCntr3ChgVal(String cntr3ChgVal) {
		this.cntr3ChgVal = cntr3ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr8ChgVal
	 */
	public void setCntr8ChgVal(String cntr8ChgVal) {
		this.cntr8ChgVal = cntr8ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr28ChgVal
	 */
	public void setCntr28ChgVal(String cntr28ChgVal) {
		this.cntr28ChgVal = cntr28ChgVal;
	}
	
	/**
	 * Column Info
	 * @param office
	 */
	public void setOffice(String office) {
		this.office = office;
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
	 * @param mnrPlnOfcCd
	 */
	public void setMnrPlnOfcCd(String mnrPlnOfcCd) {
		this.mnrPlnOfcCd = mnrPlnOfcCd;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param mnrPlnYr
	 */
	public void setMnrPlnYr(String mnrPlnYr) {
		this.mnrPlnYr = mnrPlnYr;
	}
	
	/**
	 * Column Info
	 * @param mnrPlnAmt
	 */
	public void setMnrPlnAmt(String mnrPlnAmt) {
		this.mnrPlnAmt = mnrPlnAmt;
	}
	
	/**
	 * Column Info
	 * @param sheetGubn
	 */
	public void setSheetGubn(String sheetGubn) {
		this.sheetGubn = sheetGubn;
	}
	
	/**
	 * Column Info
	 * @param mnrPlnDtlRmk
	 */
	public void setMnrPlnDtlRmk(String mnrPlnDtlRmk) {
		this.mnrPlnDtlRmk = mnrPlnDtlRmk;
	}
	
	/**
	 * Column Info
	 * @param cntr21ChgVal
	 */
	public void setCntr21ChgVal(String cntr21ChgVal) {
		this.cntr21ChgVal = cntr21ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr12ChgVal
	 */
	public void setCntr12ChgVal(String cntr12ChgVal) {
		this.cntr12ChgVal = cntr12ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr24ChgVal
	 */
	public void setCntr24ChgVal(String cntr24ChgVal) {
		this.cntr24ChgVal = cntr24ChgVal;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTotal(JSPUtil.getParameter(request, "total", ""));
		setCntr2ChgVal(JSPUtil.getParameter(request, "cntr2_chg_val", ""));
		setCntr13ChgVal(JSPUtil.getParameter(request, "cntr13_chg_val", ""));
		setMnrGrpTpCd(JSPUtil.getParameter(request, "mnr_grp_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCntr14ChgVal(JSPUtil.getParameter(request, "cntr14_chg_val", ""));
		setEqQty(JSPUtil.getParameter(request, "eq_qty", ""));
		setMnrPlnGrpNo(JSPUtil.getParameter(request, "mnr_pln_grp_no", ""));
		setCntr6ChgVal(JSPUtil.getParameter(request, "cntr6_chg_val", ""));
		setCntr25ChgVal(JSPUtil.getParameter(request, "cntr25_chg_val", ""));
		setCntr7ChgVal(JSPUtil.getParameter(request, "cntr7_chg_val", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setCntr22ChgVal(JSPUtil.getParameter(request, "cntr22_chg_val", ""));
		setCntr30ChgVal(JSPUtil.getParameter(request, "cntr30_chg_val", ""));
		setCntr4ChgVal(JSPUtil.getParameter(request, "cntr4_chg_val", ""));
		setMnrPlnDtlSeq(JSPUtil.getParameter(request, "mnr_pln_dtl_seq", ""));
		setCntr27ChgVal(JSPUtil.getParameter(request, "cntr27_chg_val", ""));
		setCntr29ChgVal(JSPUtil.getParameter(request, "cntr29_chg_val", ""));
		setCtrlOfcCd(JSPUtil.getParameter(request, "ctrl_ofc_cd", ""));
		setCntr16ChgVal(JSPUtil.getParameter(request, "cntr16_chg_val", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCntr1ChgVal(JSPUtil.getParameter(request, "cntr1_chg_val", ""));
		setCntr5ChgVal(JSPUtil.getParameter(request, "cntr5_chg_val", ""));
		setCntr11ChgVal(JSPUtil.getParameter(request, "cntr11_chg_val", ""));
		setCntr18ChgVal(JSPUtil.getParameter(request, "cntr18_chg_val", ""));
		setMnrPlnRmk(JSPUtil.getParameter(request, "mnr_pln_rmk", ""));
		setCntr9ChgVal(JSPUtil.getParameter(request, "cntr9_chg_val", ""));
		setCntr10ChgVal(JSPUtil.getParameter(request, "cntr10_chg_val", ""));
		setCntr26ChgVal(JSPUtil.getParameter(request, "cntr26_chg_val", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setCntr23ChgVal(JSPUtil.getParameter(request, "cntr23_chg_val", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setMnrPlnFlg(JSPUtil.getParameter(request, "mnr_pln_flg", ""));
		setCntr19ChgVal(JSPUtil.getParameter(request, "cntr19_chg_val", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMnrPlnSeq(JSPUtil.getParameter(request, "mnr_pln_seq", ""));
		setCntr17ChgVal(JSPUtil.getParameter(request, "cntr17_chg_val", ""));
		setCntr15ChgVal(JSPUtil.getParameter(request, "cntr15_chg_val", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setCntr20ChgVal(JSPUtil.getParameter(request, "cntr20_chg_val", ""));
		setCntr3ChgVal(JSPUtil.getParameter(request, "cntr3_chg_val", ""));
		setCntr8ChgVal(JSPUtil.getParameter(request, "cntr8_chg_val", ""));
		setCntr28ChgVal(JSPUtil.getParameter(request, "cntr28_chg_val", ""));
		setOffice(JSPUtil.getParameter(request, "office", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setMnrPlnOfcCd(JSPUtil.getParameter(request, "mnr_pln_ofc_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setMnrPlnYr(JSPUtil.getParameter(request, "mnr_pln_yr", ""));
		setMnrPlnAmt(JSPUtil.getParameter(request, "mnr_pln_amt", ""));
		setSheetGubn(JSPUtil.getParameter(request, "sheet_gubn", ""));
		setMnrPlnDtlRmk(JSPUtil.getParameter(request, "mnr_pln_dtl_rmk", ""));
		setCntr21ChgVal(JSPUtil.getParameter(request, "cntr21_chg_val", ""));
		setCntr12ChgVal(JSPUtil.getParameter(request, "cntr12_chg_val", ""));
		setCntr24ChgVal(JSPUtil.getParameter(request, "cntr24_chg_val", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomMnrPlnTransVO[]
	 */
	public CustomMnrPlnTransVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomMnrPlnTransVO[]
	 */
	public CustomMnrPlnTransVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMnrPlnTransVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] cntr2ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr2_chg_val", length));
			String[] cntr13ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr13_chg_val", length));
			String[] mnrGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_grp_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cntr14ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr14_chg_val", length));
			String[] eqQty = (JSPUtil.getParameter(request, prefix	+ "eq_qty", length));
			String[] mnrPlnGrpNo = (JSPUtil.getParameter(request, prefix	+ "mnr_pln_grp_no", length));
			String[] cntr6ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr6_chg_val", length));
			String[] cntr25ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr25_chg_val", length));
			String[] cntr7ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr7_chg_val", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] cntr22ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr22_chg_val", length));
			String[] cntr30ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr30_chg_val", length));
			String[] cntr4ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr4_chg_val", length));
			String[] mnrPlnDtlSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_pln_dtl_seq", length));
			String[] cntr27ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr27_chg_val", length));
			String[] cntr29ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr29_chg_val", length));
			String[] ctrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd", length));
			String[] cntr16ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr16_chg_val", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cntr1ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr1_chg_val", length));
			String[] cntr5ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr5_chg_val", length));
			String[] cntr11ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr11_chg_val", length));
			String[] cntr18ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr18_chg_val", length));
			String[] mnrPlnRmk = (JSPUtil.getParameter(request, prefix	+ "mnr_pln_rmk", length));
			String[] cntr9ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr9_chg_val", length));
			String[] cntr10ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr10_chg_val", length));
			String[] cntr26ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr26_chg_val", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] cntr23ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr23_chg_val", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] mnrPlnFlg = (JSPUtil.getParameter(request, prefix	+ "mnr_pln_flg", length));
			String[] cntr19ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr19_chg_val", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mnrPlnSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_pln_seq", length));
			String[] cntr17ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr17_chg_val", length));
			String[] cntr15ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr15_chg_val", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] cntr20ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr20_chg_val", length));
			String[] cntr3ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr3_chg_val", length));
			String[] cntr8ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr8_chg_val", length));
			String[] cntr28ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr28_chg_val", length));
			String[] office = (JSPUtil.getParameter(request, prefix	+ "office", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] mnrPlnOfcCd = (JSPUtil.getParameter(request, prefix	+ "mnr_pln_ofc_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] mnrPlnYr = (JSPUtil.getParameter(request, prefix	+ "mnr_pln_yr", length));
			String[] mnrPlnAmt = (JSPUtil.getParameter(request, prefix	+ "mnr_pln_amt", length));
			String[] sheetGubn = (JSPUtil.getParameter(request, prefix	+ "sheet_gubn", length));
			String[] mnrPlnDtlRmk = (JSPUtil.getParameter(request, prefix	+ "mnr_pln_dtl_rmk", length));
			String[] cntr21ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr21_chg_val", length));
			String[] cntr12ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr12_chg_val", length));
			String[] cntr24ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr24_chg_val", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomMnrPlnTransVO();
				if (total[i] != null)
					model.setTotal(total[i]);
				if (cntr2ChgVal[i] != null)
					model.setCntr2ChgVal(cntr2ChgVal[i]);
				if (cntr13ChgVal[i] != null)
					model.setCntr13ChgVal(cntr13ChgVal[i]);
				if (mnrGrpTpCd[i] != null)
					model.setMnrGrpTpCd(mnrGrpTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntr14ChgVal[i] != null)
					model.setCntr14ChgVal(cntr14ChgVal[i]);
				if (eqQty[i] != null)
					model.setEqQty(eqQty[i]);
				if (mnrPlnGrpNo[i] != null)
					model.setMnrPlnGrpNo(mnrPlnGrpNo[i]);
				if (cntr6ChgVal[i] != null)
					model.setCntr6ChgVal(cntr6ChgVal[i]);
				if (cntr25ChgVal[i] != null)
					model.setCntr25ChgVal(cntr25ChgVal[i]);
				if (cntr7ChgVal[i] != null)
					model.setCntr7ChgVal(cntr7ChgVal[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (cntr22ChgVal[i] != null)
					model.setCntr22ChgVal(cntr22ChgVal[i]);
				if (cntr30ChgVal[i] != null)
					model.setCntr30ChgVal(cntr30ChgVal[i]);
				if (cntr4ChgVal[i] != null)
					model.setCntr4ChgVal(cntr4ChgVal[i]);
				if (mnrPlnDtlSeq[i] != null)
					model.setMnrPlnDtlSeq(mnrPlnDtlSeq[i]);
				if (cntr27ChgVal[i] != null)
					model.setCntr27ChgVal(cntr27ChgVal[i]);
				if (cntr29ChgVal[i] != null)
					model.setCntr29ChgVal(cntr29ChgVal[i]);
				if (ctrlOfcCd[i] != null)
					model.setCtrlOfcCd(ctrlOfcCd[i]);
				if (cntr16ChgVal[i] != null)
					model.setCntr16ChgVal(cntr16ChgVal[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cntr1ChgVal[i] != null)
					model.setCntr1ChgVal(cntr1ChgVal[i]);
				if (cntr5ChgVal[i] != null)
					model.setCntr5ChgVal(cntr5ChgVal[i]);
				if (cntr11ChgVal[i] != null)
					model.setCntr11ChgVal(cntr11ChgVal[i]);
				if (cntr18ChgVal[i] != null)
					model.setCntr18ChgVal(cntr18ChgVal[i]);
				if (mnrPlnRmk[i] != null)
					model.setMnrPlnRmk(mnrPlnRmk[i]);
				if (cntr9ChgVal[i] != null)
					model.setCntr9ChgVal(cntr9ChgVal[i]);
				if (cntr10ChgVal[i] != null)
					model.setCntr10ChgVal(cntr10ChgVal[i]);
				if (cntr26ChgVal[i] != null)
					model.setCntr26ChgVal(cntr26ChgVal[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (cntr23ChgVal[i] != null)
					model.setCntr23ChgVal(cntr23ChgVal[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (mnrPlnFlg[i] != null)
					model.setMnrPlnFlg(mnrPlnFlg[i]);
				if (cntr19ChgVal[i] != null)
					model.setCntr19ChgVal(cntr19ChgVal[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mnrPlnSeq[i] != null)
					model.setMnrPlnSeq(mnrPlnSeq[i]);
				if (cntr17ChgVal[i] != null)
					model.setCntr17ChgVal(cntr17ChgVal[i]);
				if (cntr15ChgVal[i] != null)
					model.setCntr15ChgVal(cntr15ChgVal[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (cntr20ChgVal[i] != null)
					model.setCntr20ChgVal(cntr20ChgVal[i]);
				if (cntr3ChgVal[i] != null)
					model.setCntr3ChgVal(cntr3ChgVal[i]);
				if (cntr8ChgVal[i] != null)
					model.setCntr8ChgVal(cntr8ChgVal[i]);
				if (cntr28ChgVal[i] != null)
					model.setCntr28ChgVal(cntr28ChgVal[i]);
				if (office[i] != null)
					model.setOffice(office[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (mnrPlnOfcCd[i] != null)
					model.setMnrPlnOfcCd(mnrPlnOfcCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (mnrPlnYr[i] != null)
					model.setMnrPlnYr(mnrPlnYr[i]);
				if (mnrPlnAmt[i] != null)
					model.setMnrPlnAmt(mnrPlnAmt[i]);
				if (sheetGubn[i] != null)
					model.setSheetGubn(sheetGubn[i]);
				if (mnrPlnDtlRmk[i] != null)
					model.setMnrPlnDtlRmk(mnrPlnDtlRmk[i]);
				if (cntr21ChgVal[i] != null)
					model.setCntr21ChgVal(cntr21ChgVal[i]);
				if (cntr12ChgVal[i] != null)
					model.setCntr12ChgVal(cntr12ChgVal[i]);
				if (cntr24ChgVal[i] != null)
					model.setCntr24ChgVal(cntr24ChgVal[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomMnrPlnTransVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomMnrPlnTransVO[]
	 */
	public CustomMnrPlnTransVO[] getCustomMnrPlnTransVOs(){
		CustomMnrPlnTransVO[] vos = (CustomMnrPlnTransVO[])models.toArray(new CustomMnrPlnTransVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.total = this.total .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr2ChgVal = this.cntr2ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr13ChgVal = this.cntr13ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrGrpTpCd = this.mnrGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr14ChgVal = this.cntr14ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqQty = this.eqQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPlnGrpNo = this.mnrPlnGrpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr6ChgVal = this.cntr6ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr25ChgVal = this.cntr25ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr7ChgVal = this.cntr7ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr22ChgVal = this.cntr22ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr30ChgVal = this.cntr30ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr4ChgVal = this.cntr4ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPlnDtlSeq = this.mnrPlnDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr27ChgVal = this.cntr27ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr29ChgVal = this.cntr29ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd = this.ctrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr16ChgVal = this.cntr16ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr1ChgVal = this.cntr1ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr5ChgVal = this.cntr5ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr11ChgVal = this.cntr11ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr18ChgVal = this.cntr18ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPlnRmk = this.mnrPlnRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr9ChgVal = this.cntr9ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr10ChgVal = this.cntr10ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr26ChgVal = this.cntr26ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr23ChgVal = this.cntr23ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPlnFlg = this.mnrPlnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr19ChgVal = this.cntr19ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPlnSeq = this.mnrPlnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr17ChgVal = this.cntr17ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr15ChgVal = this.cntr15ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr20ChgVal = this.cntr20ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr3ChgVal = this.cntr3ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr8ChgVal = this.cntr8ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr28ChgVal = this.cntr28ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.office = this.office .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPlnOfcCd = this.mnrPlnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPlnYr = this.mnrPlnYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPlnAmt = this.mnrPlnAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheetGubn = this.sheetGubn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPlnDtlRmk = this.mnrPlnDtlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr21ChgVal = this.cntr21ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr12ChgVal = this.cntr12ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr24ChgVal = this.cntr24ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
