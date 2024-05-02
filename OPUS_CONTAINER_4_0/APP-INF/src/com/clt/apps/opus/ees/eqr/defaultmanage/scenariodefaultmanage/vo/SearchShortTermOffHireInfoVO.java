/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchShortTermOffHireInfoVO.java
*@FileTitle : SearchShortTermOffHireInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.07.10 이행지 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이행지
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchShortTermOffHireInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchShortTermOffHireInfoVO> models = new ArrayList<SearchShortTermOffHireInfoVO>();
	
	/* Column Info */
	private String r2drygAmt = null;
	/* Column Info */
	private String d7drygAmt = null;
	/* Column Info */
	private String f2lftChgAmt = null;
	/* Column Info */
	private String f4dfltUsdDys = null;
	/* Column Info */
	private String o2dfltUsdDys = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String d4lftChgAmt = null;
	/* Column Info */
	private String f2drygAmt = null;
	/* Column Info */
	private String d4drffChgCrAmt = null;
	/* Column Info */
	private String d5drygAmt = null;
	/* Column Info */
	private String d7lftChgAmt = null;
	/* Column Info */
	private String d2lftChgAmt = null;
	/* Column Info */
	private String d5dfltUsdDys = null;
	/* Column Info */
	private String r2lftChgAmt = null;
	/* Column Info */
	private String o4lftChgAmt = null;
	/* Column Info */
	private String o4drffChgCrAmt = null;
	/* Column Info */
	private String f4avalCntrQty = null;
	/* Column Info */
	private String f2drffChgCrAmt = null;
	/* Column Info */
	private String d7drffChgCrAmt = null;
	/* Column Info */
	private String d5avalCntrQty = null;
	/* Column Info */
	private String r2drffChgCrAmt = null;
	/* Column Info */
	private String o4drygAmt = null;
	/* Column Info */
	private String d4dfltUsdDys = null;
	/* Column Info */
	private String o4dfltUsdDys = null;
	/* Column Info */
	private String f4drygAmt = null;
	/* Column Info */
	private String r5drffChgCrAmt = null;
	/* Column Info */
	private String r5drygAmt = null;
	/* Column Info */
	private String o2lftChgAmt = null;
	/* Column Info */
	private String r2avalCntrQty = null;
	/* Column Info */
	private String d4avalCntrQty = null;
	/* Column Info */
	private String d7avalCntrQty = null;
	/* Column Info */
	private String o2avalCntrQty = null;
	/* Column Info */
	private String d2drygAmt = null;
	/* Column Info */
	private String d4drygAmt = null;
	/* Column Info */
	private String f4drffChgCrAmt = null;
	/* Column Info */
	private String o2drygAmt = null;
	/* Column Info */
	private String r5lftChgAmt = null;
	/* Column Info */
	private String d2avalCntrQty = null;
	/* Column Info */
	private String d2drffChgCrAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String r2dfltUsdDys = null;
	/* Column Info */
	private String o2drffChgCrAmt = null;
	/* Column Info */
	private String f2dfltUsdDys = null;
	/* Column Info */
	private String o4avalCntrQty = null;
	/* Column Info */
	private String d2dfltUsdDys = null;
	/* Column Info */
	private String eccCd = null;
	/* Column Info */
	private String f4lftChgAmt = null;
	/* Column Info */
	private String d5drffChgCrAmt = null;
	/* Column Info */
	private String f2avalCntrQty = null;
	/* Column Info */
	private String r5avalCntrQty = null;
	/* Column Info */
	private String d7dfltUsdDys = null;
	/* Column Info */
	private String d5lftChgAmt = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String r5dfltUsdDys = null;
	/* Column Info */
	private String tpsztype = null;
	/* Column Info */
	private String location = null;
	/* Column Info */
	private String loctype = null;
	/* Column Info */
	private ArrayList<String> arrtpsz = null;
	/* Column Info */
	private ArrayList<String> arrlocation = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchShortTermOffHireInfoVO() {}

	public SearchShortTermOffHireInfoVO(String ibflag, String pagerows, String eccCd, String seq, String d2avalCntrQty, String d4avalCntrQty, String d5avalCntrQty, String d7avalCntrQty, String r2avalCntrQty, String r5avalCntrQty, String o2avalCntrQty, String o4avalCntrQty, String f2avalCntrQty, String f4avalCntrQty, String d2lftChgAmt, String d4lftChgAmt, String d5lftChgAmt, String d7lftChgAmt, String r2lftChgAmt, String r5lftChgAmt, String o2lftChgAmt, String o4lftChgAmt, String f2lftChgAmt, String f4lftChgAmt, String d2drffChgCrAmt, String d4drffChgCrAmt, String d5drffChgCrAmt, String d7drffChgCrAmt, String r2drffChgCrAmt, String r5drffChgCrAmt, String o2drffChgCrAmt, String o4drffChgCrAmt, String f2drffChgCrAmt, String f4drffChgCrAmt, String d2drygAmt, String d4drygAmt, String d5drygAmt, String d7drygAmt, String r2drygAmt, String r5drygAmt, String o2drygAmt, String o4drygAmt, String f2drygAmt, String f4drygAmt, String d2dfltUsdDys, String d4dfltUsdDys, String d5dfltUsdDys, String d7dfltUsdDys, String r2dfltUsdDys, String r5dfltUsdDys, String o2dfltUsdDys, String o4dfltUsdDys, String f2dfltUsdDys, String f4dfltUsdDys) {
		this.r2drygAmt = r2drygAmt;
		this.d7drygAmt = d7drygAmt;
		this.f2lftChgAmt = f2lftChgAmt;
		this.f4dfltUsdDys = f4dfltUsdDys;
		this.o2dfltUsdDys = o2dfltUsdDys;
		this.pagerows = pagerows;
		this.d4lftChgAmt = d4lftChgAmt;
		this.f2drygAmt = f2drygAmt;
		this.d4drffChgCrAmt = d4drffChgCrAmt;
		this.d5drygAmt = d5drygAmt;
		this.d7lftChgAmt = d7lftChgAmt;
		this.d2lftChgAmt = d2lftChgAmt;
		this.d5dfltUsdDys = d5dfltUsdDys;
		this.r2lftChgAmt = r2lftChgAmt;
		this.o4lftChgAmt = o4lftChgAmt;
		this.o4drffChgCrAmt = o4drffChgCrAmt;
		this.f4avalCntrQty = f4avalCntrQty;
		this.f2drffChgCrAmt = f2drffChgCrAmt;
		this.d7drffChgCrAmt = d7drffChgCrAmt;
		this.d5avalCntrQty = d5avalCntrQty;
		this.r2drffChgCrAmt = r2drffChgCrAmt;
		this.o4drygAmt = o4drygAmt;
		this.d4dfltUsdDys = d4dfltUsdDys;
		this.o4dfltUsdDys = o4dfltUsdDys;
		this.f4drygAmt = f4drygAmt;
		this.r5drffChgCrAmt = r5drffChgCrAmt;
		this.r5drygAmt = r5drygAmt;
		this.o2lftChgAmt = o2lftChgAmt;
		this.r2avalCntrQty = r2avalCntrQty;
		this.d4avalCntrQty = d4avalCntrQty;
		this.d7avalCntrQty = d7avalCntrQty;
		this.o2avalCntrQty = o2avalCntrQty;
		this.d2drygAmt = d2drygAmt;
		this.d4drygAmt = d4drygAmt;
		this.f4drffChgCrAmt = f4drffChgCrAmt;
		this.o2drygAmt = o2drygAmt;
		this.r5lftChgAmt = r5lftChgAmt;
		this.d2avalCntrQty = d2avalCntrQty;
		this.d2drffChgCrAmt = d2drffChgCrAmt;
		this.ibflag = ibflag;
		this.r2dfltUsdDys = r2dfltUsdDys;
		this.o2drffChgCrAmt = o2drffChgCrAmt;
		this.f2dfltUsdDys = f2dfltUsdDys;
		this.o4avalCntrQty = o4avalCntrQty;
		this.d2dfltUsdDys = d2dfltUsdDys;
		this.eccCd = eccCd;
		this.f4lftChgAmt = f4lftChgAmt;
		this.d5drffChgCrAmt = d5drffChgCrAmt;
		this.f2avalCntrQty = f2avalCntrQty;
		this.r5avalCntrQty = r5avalCntrQty;
		this.d7dfltUsdDys = d7dfltUsdDys;
		this.d5lftChgAmt = d5lftChgAmt;
		this.seq = seq;
		this.r5dfltUsdDys = r5dfltUsdDys;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("r2dryg_amt", getR2drygAmt());
		this.hashColumns.put("d7dryg_amt", getD7drygAmt());
		this.hashColumns.put("f2lft_chg_amt", getF2lftChgAmt());
		this.hashColumns.put("f4dflt_usd_dys", getF4dfltUsdDys());
		this.hashColumns.put("o2dflt_usd_dys", getO2dfltUsdDys());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("d4lft_chg_amt", getD4lftChgAmt());
		this.hashColumns.put("f2dryg_amt", getF2drygAmt());
		this.hashColumns.put("d4drff_chg_cr_amt", getD4drffChgCrAmt());
		this.hashColumns.put("d5dryg_amt", getD5drygAmt());
		this.hashColumns.put("d7lft_chg_amt", getD7lftChgAmt());
		this.hashColumns.put("d2lft_chg_amt", getD2lftChgAmt());
		this.hashColumns.put("d5dflt_usd_dys", getD5dfltUsdDys());
		this.hashColumns.put("r2lft_chg_amt", getR2lftChgAmt());
		this.hashColumns.put("o4lft_chg_amt", getO4lftChgAmt());
		this.hashColumns.put("o4drff_chg_cr_amt", getO4drffChgCrAmt());
		this.hashColumns.put("f4aval_cntr_qty", getF4avalCntrQty());
		this.hashColumns.put("f2drff_chg_cr_amt", getF2drffChgCrAmt());
		this.hashColumns.put("d7drff_chg_cr_amt", getD7drffChgCrAmt());
		this.hashColumns.put("d5aval_cntr_qty", getD5avalCntrQty());
		this.hashColumns.put("r2drff_chg_cr_amt", getR2drffChgCrAmt());
		this.hashColumns.put("o4dryg_amt", getO4drygAmt());
		this.hashColumns.put("d4dflt_usd_dys", getD4dfltUsdDys());
		this.hashColumns.put("o4dflt_usd_dys", getO4dfltUsdDys());
		this.hashColumns.put("f4dryg_amt", getF4drygAmt());
		this.hashColumns.put("r5drff_chg_cr_amt", getR5drffChgCrAmt());
		this.hashColumns.put("r5dryg_amt", getR5drygAmt());
		this.hashColumns.put("o2lft_chg_amt", getO2lftChgAmt());
		this.hashColumns.put("r2aval_cntr_qty", getR2avalCntrQty());
		this.hashColumns.put("d4aval_cntr_qty", getD4avalCntrQty());
		this.hashColumns.put("d7aval_cntr_qty", getD7avalCntrQty());
		this.hashColumns.put("o2aval_cntr_qty", getO2avalCntrQty());
		this.hashColumns.put("d2dryg_amt", getD2drygAmt());
		this.hashColumns.put("d4dryg_amt", getD4drygAmt());
		this.hashColumns.put("f4drff_chg_cr_amt", getF4drffChgCrAmt());
		this.hashColumns.put("o2dryg_amt", getO2drygAmt());
		this.hashColumns.put("r5lft_chg_amt", getR5lftChgAmt());
		this.hashColumns.put("d2aval_cntr_qty", getD2avalCntrQty());
		this.hashColumns.put("d2drff_chg_cr_amt", getD2drffChgCrAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("r2dflt_usd_dys", getR2dfltUsdDys());
		this.hashColumns.put("o2drff_chg_cr_amt", getO2drffChgCrAmt());
		this.hashColumns.put("f2dflt_usd_dys", getF2dfltUsdDys());
		this.hashColumns.put("o4aval_cntr_qty", getO4avalCntrQty());
		this.hashColumns.put("d2dflt_usd_dys", getD2dfltUsdDys());
		this.hashColumns.put("ecc_cd", getEccCd());
		this.hashColumns.put("f4lft_chg_amt", getF4lftChgAmt());
		this.hashColumns.put("d5drff_chg_cr_amt", getD5drffChgCrAmt());
		this.hashColumns.put("f2aval_cntr_qty", getF2avalCntrQty());
		this.hashColumns.put("r5aval_cntr_qty", getR5avalCntrQty());
		this.hashColumns.put("d7dflt_usd_dys", getD7dfltUsdDys());
		this.hashColumns.put("d5lft_chg_amt", getD5lftChgAmt());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("r5dflt_usd_dys", getR5dfltUsdDys());
		this.hashColumns.put("tpsztype", getTpsztype());
		this.hashColumns.put("location", getLocation());
		this.hashColumns.put("loctype", getLoctype());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("r2dryg_amt", "r2drygAmt");
		this.hashFields.put("d7dryg_amt", "d7drygAmt");
		this.hashFields.put("f2lft_chg_amt", "f2lftChgAmt");
		this.hashFields.put("f4dflt_usd_dys", "f4dfltUsdDys");
		this.hashFields.put("o2dflt_usd_dys", "o2dfltUsdDys");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("d4lft_chg_amt", "d4lftChgAmt");
		this.hashFields.put("f2dryg_amt", "f2drygAmt");
		this.hashFields.put("d4drff_chg_cr_amt", "d4drffChgCrAmt");
		this.hashFields.put("d5dryg_amt", "d5drygAmt");
		this.hashFields.put("d7lft_chg_amt", "d7lftChgAmt");
		this.hashFields.put("d2lft_chg_amt", "d2lftChgAmt");
		this.hashFields.put("d5dflt_usd_dys", "d5dfltUsdDys");
		this.hashFields.put("r2lft_chg_amt", "r2lftChgAmt");
		this.hashFields.put("o4lft_chg_amt", "o4lftChgAmt");
		this.hashFields.put("o4drff_chg_cr_amt", "o4drffChgCrAmt");
		this.hashFields.put("f4aval_cntr_qty", "f4avalCntrQty");
		this.hashFields.put("f2drff_chg_cr_amt", "f2drffChgCrAmt");
		this.hashFields.put("d7drff_chg_cr_amt", "d7drffChgCrAmt");
		this.hashFields.put("d5aval_cntr_qty", "d5avalCntrQty");
		this.hashFields.put("r2drff_chg_cr_amt", "r2drffChgCrAmt");
		this.hashFields.put("o4dryg_amt", "o4drygAmt");
		this.hashFields.put("d4dflt_usd_dys", "d4dfltUsdDys");
		this.hashFields.put("o4dflt_usd_dys", "o4dfltUsdDys");
		this.hashFields.put("f4dryg_amt", "f4drygAmt");
		this.hashFields.put("r5drff_chg_cr_amt", "r5drffChgCrAmt");
		this.hashFields.put("r5dryg_amt", "r5drygAmt");
		this.hashFields.put("o2lft_chg_amt", "o2lftChgAmt");
		this.hashFields.put("r2aval_cntr_qty", "r2avalCntrQty");
		this.hashFields.put("d4aval_cntr_qty", "d4avalCntrQty");
		this.hashFields.put("d7aval_cntr_qty", "d7avalCntrQty");
		this.hashFields.put("o2aval_cntr_qty", "o2avalCntrQty");
		this.hashFields.put("d2dryg_amt", "d2drygAmt");
		this.hashFields.put("d4dryg_amt", "d4drygAmt");
		this.hashFields.put("f4drff_chg_cr_amt", "f4drffChgCrAmt");
		this.hashFields.put("o2dryg_amt", "o2drygAmt");
		this.hashFields.put("r5lft_chg_amt", "r5lftChgAmt");
		this.hashFields.put("d2aval_cntr_qty", "d2avalCntrQty");
		this.hashFields.put("d2drff_chg_cr_amt", "d2drffChgCrAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("r2dflt_usd_dys", "r2dfltUsdDys");
		this.hashFields.put("o2drff_chg_cr_amt", "o2drffChgCrAmt");
		this.hashFields.put("f2dflt_usd_dys", "f2dfltUsdDys");
		this.hashFields.put("o4aval_cntr_qty", "o4avalCntrQty");
		this.hashFields.put("d2dflt_usd_dys", "d2dfltUsdDys");
		this.hashFields.put("ecc_cd", "eccCd");
		this.hashFields.put("f4lft_chg_amt", "f4lftChgAmt");
		this.hashFields.put("d5drff_chg_cr_amt", "d5drffChgCrAmt");
		this.hashFields.put("f2aval_cntr_qty", "f2avalCntrQty");
		this.hashFields.put("r5aval_cntr_qty", "r5avalCntrQty");
		this.hashFields.put("d7dflt_usd_dys", "d7dfltUsdDys");
		this.hashFields.put("d5lft_chg_amt", "d5lftChgAmt");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("r5dflt_usd_dys", "r5dfltUsdDys");
		this.hashFields.put("tpsztype", "tpsztype");
		this.hashFields.put("location", "location");
		this.hashFields.put("loctype", "loctype");
		this.hashFields.put("arrtpsz", "arrtpsz");
		this.hashFields.put("arrlocation", "arrlocation");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return r2drygAmt
	 */
	public String getR2drygAmt() {
		return this.r2drygAmt;
	}
	
	/**
	 * Column Info
	 * @return d7drygAmt
	 */
	public String getD7drygAmt() {
		return this.d7drygAmt;
	}
	
	/**
	 * Column Info
	 * @return f2lftChgAmt
	 */
	public String getF2lftChgAmt() {
		return this.f2lftChgAmt;
	}
	
	/**
	 * Column Info
	 * @return f4dfltUsdDys
	 */
	public String getF4dfltUsdDys() {
		return this.f4dfltUsdDys;
	}
	
	/**
	 * Column Info
	 * @return o2dfltUsdDys
	 */
	public String getO2dfltUsdDys() {
		return this.o2dfltUsdDys;
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
	 * @return d4lftChgAmt
	 */
	public String getD4lftChgAmt() {
		return this.d4lftChgAmt;
	}
	
	/**
	 * Column Info
	 * @return f2drygAmt
	 */
	public String getF2drygAmt() {
		return this.f2drygAmt;
	}
	
	/**
	 * Column Info
	 * @return d4drffChgCrAmt
	 */
	public String getD4drffChgCrAmt() {
		return this.d4drffChgCrAmt;
	}
	
	/**
	 * Column Info
	 * @return d5drygAmt
	 */
	public String getD5drygAmt() {
		return this.d5drygAmt;
	}
	
	/**
	 * Column Info
	 * @return d7lftChgAmt
	 */
	public String getD7lftChgAmt() {
		return this.d7lftChgAmt;
	}
	
	/**
	 * Column Info
	 * @return d2lftChgAmt
	 */
	public String getD2lftChgAmt() {
		return this.d2lftChgAmt;
	}
	
	/**
	 * Column Info
	 * @return d5dfltUsdDys
	 */
	public String getD5dfltUsdDys() {
		return this.d5dfltUsdDys;
	}
	
	/**
	 * Column Info
	 * @return r2lftChgAmt
	 */
	public String getR2lftChgAmt() {
		return this.r2lftChgAmt;
	}
	
	/**
	 * Column Info
	 * @return o4lftChgAmt
	 */
	public String getO4lftChgAmt() {
		return this.o4lftChgAmt;
	}
	
	/**
	 * Column Info
	 * @return o4drffChgCrAmt
	 */
	public String getO4drffChgCrAmt() {
		return this.o4drffChgCrAmt;
	}
	
	/**
	 * Column Info
	 * @return f4avalCntrQty
	 */
	public String getF4avalCntrQty() {
		return this.f4avalCntrQty;
	}
	
	/**
	 * Column Info
	 * @return f2drffChgCrAmt
	 */
	public String getF2drffChgCrAmt() {
		return this.f2drffChgCrAmt;
	}
	
	/**
	 * Column Info
	 * @return d7drffChgCrAmt
	 */
	public String getD7drffChgCrAmt() {
		return this.d7drffChgCrAmt;
	}
	
	/**
	 * Column Info
	 * @return d5avalCntrQty
	 */
	public String getD5avalCntrQty() {
		return this.d5avalCntrQty;
	}
	
	/**
	 * Column Info
	 * @return r2drffChgCrAmt
	 */
	public String getR2drffChgCrAmt() {
		return this.r2drffChgCrAmt;
	}
	
	/**
	 * Column Info
	 * @return o4drygAmt
	 */
	public String getO4drygAmt() {
		return this.o4drygAmt;
	}
	
	/**
	 * Column Info
	 * @return d4dfltUsdDys
	 */
	public String getD4dfltUsdDys() {
		return this.d4dfltUsdDys;
	}
	
	/**
	 * Column Info
	 * @return o4dfltUsdDys
	 */
	public String getO4dfltUsdDys() {
		return this.o4dfltUsdDys;
	}
	
	/**
	 * Column Info
	 * @return f4drygAmt
	 */
	public String getF4drygAmt() {
		return this.f4drygAmt;
	}
	
	/**
	 * Column Info
	 * @return r5drffChgCrAmt
	 */
	public String getR5drffChgCrAmt() {
		return this.r5drffChgCrAmt;
	}
	
	/**
	 * Column Info
	 * @return r5drygAmt
	 */
	public String getR5drygAmt() {
		return this.r5drygAmt;
	}
	
	/**
	 * Column Info
	 * @return o2lftChgAmt
	 */
	public String getO2lftChgAmt() {
		return this.o2lftChgAmt;
	}
	
	/**
	 * Column Info
	 * @return r2avalCntrQty
	 */
	public String getR2avalCntrQty() {
		return this.r2avalCntrQty;
	}
	
	/**
	 * Column Info
	 * @return d4avalCntrQty
	 */
	public String getD4avalCntrQty() {
		return this.d4avalCntrQty;
	}
	
	/**
	 * Column Info
	 * @return d7avalCntrQty
	 */
	public String getD7avalCntrQty() {
		return this.d7avalCntrQty;
	}
	
	/**
	 * Column Info
	 * @return o2avalCntrQty
	 */
	public String getO2avalCntrQty() {
		return this.o2avalCntrQty;
	}
	
	/**
	 * Column Info
	 * @return d2drygAmt
	 */
	public String getD2drygAmt() {
		return this.d2drygAmt;
	}
	
	/**
	 * Column Info
	 * @return d4drygAmt
	 */
	public String getD4drygAmt() {
		return this.d4drygAmt;
	}
	
	/**
	 * Column Info
	 * @return f4drffChgCrAmt
	 */
	public String getF4drffChgCrAmt() {
		return this.f4drffChgCrAmt;
	}
	
	/**
	 * Column Info
	 * @return o2drygAmt
	 */
	public String getO2drygAmt() {
		return this.o2drygAmt;
	}
	
	/**
	 * Column Info
	 * @return r5lftChgAmt
	 */
	public String getR5lftChgAmt() {
		return this.r5lftChgAmt;
	}
	
	/**
	 * Column Info
	 * @return d2avalCntrQty
	 */
	public String getD2avalCntrQty() {
		return this.d2avalCntrQty;
	}
	
	/**
	 * Column Info
	 * @return d2drffChgCrAmt
	 */
	public String getD2drffChgCrAmt() {
		return this.d2drffChgCrAmt;
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
	 * @return r2dfltUsdDys
	 */
	public String getR2dfltUsdDys() {
		return this.r2dfltUsdDys;
	}
	
	/**
	 * Column Info
	 * @return o2drffChgCrAmt
	 */
	public String getO2drffChgCrAmt() {
		return this.o2drffChgCrAmt;
	}
	
	/**
	 * Column Info
	 * @return f2dfltUsdDys
	 */
	public String getF2dfltUsdDys() {
		return this.f2dfltUsdDys;
	}
	
	/**
	 * Column Info
	 * @return o4avalCntrQty
	 */
	public String getO4avalCntrQty() {
		return this.o4avalCntrQty;
	}
	
	/**
	 * Column Info
	 * @return d2dfltUsdDys
	 */
	public String getD2dfltUsdDys() {
		return this.d2dfltUsdDys;
	}
	
	/**
	 * Column Info
	 * @return eccCd
	 */
	public String getEccCd() {
		return this.eccCd;
	}
	
	/**
	 * Column Info
	 * @return f4lftChgAmt
	 */
	public String getF4lftChgAmt() {
		return this.f4lftChgAmt;
	}
	
	/**
	 * Column Info
	 * @return d5drffChgCrAmt
	 */
	public String getD5drffChgCrAmt() {
		return this.d5drffChgCrAmt;
	}
	
	/**
	 * Column Info
	 * @return f2avalCntrQty
	 */
	public String getF2avalCntrQty() {
		return this.f2avalCntrQty;
	}
	
	/**
	 * Column Info
	 * @return r5avalCntrQty
	 */
	public String getR5avalCntrQty() {
		return this.r5avalCntrQty;
	}
	
	/**
	 * Column Info
	 * @return d7dfltUsdDys
	 */
	public String getD7dfltUsdDys() {
		return this.d7dfltUsdDys;
	}
	
	/**
	 * Column Info
	 * @return d5lftChgAmt
	 */
	public String getD5lftChgAmt() {
		return this.d5lftChgAmt;
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
	 * @return r5dfltUsdDys
	 */
	public String getR5dfltUsdDys() {
		return this.r5dfltUsdDys;
	}
	
	/**
	 * Column Info
	 * @return tpsztype
	 */
	public String getTpsztype() {
		return this.tpsztype;
	}
	
	/**
	 * Column Info
	 * @return location
	 */
	public String getLocation() {
		return this.location;
	}
	
	/**
	 * Column Info
	 * @return loctype
	 */
	public String getLoctype() {
		return this.loctype;
	}
	
	/**
	 * Column Info
	 * @return arrtpsz
	 */
	public ArrayList<String> getArrtpsz() {
		return this.arrtpsz;
	}
	
	/**
	 * Column Info
	 * @return arrlocation
	 */
	public ArrayList<String> getArrlocation() {
		return this.arrlocation;
	}

	/**
	 * Column Info
	 * @param r2drygAmt
	 */
	public void setR2drygAmt(String r2drygAmt) {
		this.r2drygAmt = r2drygAmt;
	}
	
	/**
	 * Column Info
	 * @param d7drygAmt
	 */
	public void setD7drygAmt(String d7drygAmt) {
		this.d7drygAmt = d7drygAmt;
	}
	
	/**
	 * Column Info
	 * @param f2lftChgAmt
	 */
	public void setF2lftChgAmt(String f2lftChgAmt) {
		this.f2lftChgAmt = f2lftChgAmt;
	}
	
	/**
	 * Column Info
	 * @param f4dfltUsdDys
	 */
	public void setF4dfltUsdDys(String f4dfltUsdDys) {
		this.f4dfltUsdDys = f4dfltUsdDys;
	}
	
	/**
	 * Column Info
	 * @param o2dfltUsdDys
	 */
	public void setO2dfltUsdDys(String o2dfltUsdDys) {
		this.o2dfltUsdDys = o2dfltUsdDys;
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
	 * @param d4lftChgAmt
	 */
	public void setD4lftChgAmt(String d4lftChgAmt) {
		this.d4lftChgAmt = d4lftChgAmt;
	}
	
	/**
	 * Column Info
	 * @param f2drygAmt
	 */
	public void setF2drygAmt(String f2drygAmt) {
		this.f2drygAmt = f2drygAmt;
	}
	
	/**
	 * Column Info
	 * @param d4drffChgCrAmt
	 */
	public void setD4drffChgCrAmt(String d4drffChgCrAmt) {
		this.d4drffChgCrAmt = d4drffChgCrAmt;
	}
	
	/**
	 * Column Info
	 * @param d5drygAmt
	 */
	public void setD5drygAmt(String d5drygAmt) {
		this.d5drygAmt = d5drygAmt;
	}
	
	/**
	 * Column Info
	 * @param d7lftChgAmt
	 */
	public void setD7lftChgAmt(String d7lftChgAmt) {
		this.d7lftChgAmt = d7lftChgAmt;
	}
	
	/**
	 * Column Info
	 * @param d2lftChgAmt
	 */
	public void setD2lftChgAmt(String d2lftChgAmt) {
		this.d2lftChgAmt = d2lftChgAmt;
	}
	
	/**
	 * Column Info
	 * @param d5dfltUsdDys
	 */
	public void setD5dfltUsdDys(String d5dfltUsdDys) {
		this.d5dfltUsdDys = d5dfltUsdDys;
	}
	
	/**
	 * Column Info
	 * @param r2lftChgAmt
	 */
	public void setR2lftChgAmt(String r2lftChgAmt) {
		this.r2lftChgAmt = r2lftChgAmt;
	}
	
	/**
	 * Column Info
	 * @param o4lftChgAmt
	 */
	public void setO4lftChgAmt(String o4lftChgAmt) {
		this.o4lftChgAmt = o4lftChgAmt;
	}
	
	/**
	 * Column Info
	 * @param o4drffChgCrAmt
	 */
	public void setO4drffChgCrAmt(String o4drffChgCrAmt) {
		this.o4drffChgCrAmt = o4drffChgCrAmt;
	}
	
	/**
	 * Column Info
	 * @param f4avalCntrQty
	 */
	public void setF4avalCntrQty(String f4avalCntrQty) {
		this.f4avalCntrQty = f4avalCntrQty;
	}
	
	/**
	 * Column Info
	 * @param f2drffChgCrAmt
	 */
	public void setF2drffChgCrAmt(String f2drffChgCrAmt) {
		this.f2drffChgCrAmt = f2drffChgCrAmt;
	}
	
	/**
	 * Column Info
	 * @param d7drffChgCrAmt
	 */
	public void setD7drffChgCrAmt(String d7drffChgCrAmt) {
		this.d7drffChgCrAmt = d7drffChgCrAmt;
	}
	
	/**
	 * Column Info
	 * @param d5avalCntrQty
	 */
	public void setD5avalCntrQty(String d5avalCntrQty) {
		this.d5avalCntrQty = d5avalCntrQty;
	}
	
	/**
	 * Column Info
	 * @param r2drffChgCrAmt
	 */
	public void setR2drffChgCrAmt(String r2drffChgCrAmt) {
		this.r2drffChgCrAmt = r2drffChgCrAmt;
	}
	
	/**
	 * Column Info
	 * @param o4drygAmt
	 */
	public void setO4drygAmt(String o4drygAmt) {
		this.o4drygAmt = o4drygAmt;
	}
	
	/**
	 * Column Info
	 * @param d4dfltUsdDys
	 */
	public void setD4dfltUsdDys(String d4dfltUsdDys) {
		this.d4dfltUsdDys = d4dfltUsdDys;
	}
	
	/**
	 * Column Info
	 * @param o4dfltUsdDys
	 */
	public void setO4dfltUsdDys(String o4dfltUsdDys) {
		this.o4dfltUsdDys = o4dfltUsdDys;
	}
	
	/**
	 * Column Info
	 * @param f4drygAmt
	 */
	public void setF4drygAmt(String f4drygAmt) {
		this.f4drygAmt = f4drygAmt;
	}
	
	/**
	 * Column Info
	 * @param r5drffChgCrAmt
	 */
	public void setR5drffChgCrAmt(String r5drffChgCrAmt) {
		this.r5drffChgCrAmt = r5drffChgCrAmt;
	}
	
	/**
	 * Column Info
	 * @param r5drygAmt
	 */
	public void setR5drygAmt(String r5drygAmt) {
		this.r5drygAmt = r5drygAmt;
	}
	
	/**
	 * Column Info
	 * @param o2lftChgAmt
	 */
	public void setO2lftChgAmt(String o2lftChgAmt) {
		this.o2lftChgAmt = o2lftChgAmt;
	}
	
	/**
	 * Column Info
	 * @param r2avalCntrQty
	 */
	public void setR2avalCntrQty(String r2avalCntrQty) {
		this.r2avalCntrQty = r2avalCntrQty;
	}
	
	/**
	 * Column Info
	 * @param d4avalCntrQty
	 */
	public void setD4avalCntrQty(String d4avalCntrQty) {
		this.d4avalCntrQty = d4avalCntrQty;
	}
	
	/**
	 * Column Info
	 * @param d7avalCntrQty
	 */
	public void setD7avalCntrQty(String d7avalCntrQty) {
		this.d7avalCntrQty = d7avalCntrQty;
	}
	
	/**
	 * Column Info
	 * @param o2avalCntrQty
	 */
	public void setO2avalCntrQty(String o2avalCntrQty) {
		this.o2avalCntrQty = o2avalCntrQty;
	}
	
	/**
	 * Column Info
	 * @param d2drygAmt
	 */
	public void setD2drygAmt(String d2drygAmt) {
		this.d2drygAmt = d2drygAmt;
	}
	
	/**
	 * Column Info
	 * @param d4drygAmt
	 */
	public void setD4drygAmt(String d4drygAmt) {
		this.d4drygAmt = d4drygAmt;
	}
	
	/**
	 * Column Info
	 * @param f4drffChgCrAmt
	 */
	public void setF4drffChgCrAmt(String f4drffChgCrAmt) {
		this.f4drffChgCrAmt = f4drffChgCrAmt;
	}
	
	/**
	 * Column Info
	 * @param o2drygAmt
	 */
	public void setO2drygAmt(String o2drygAmt) {
		this.o2drygAmt = o2drygAmt;
	}
	
	/**
	 * Column Info
	 * @param r5lftChgAmt
	 */
	public void setR5lftChgAmt(String r5lftChgAmt) {
		this.r5lftChgAmt = r5lftChgAmt;
	}
	
	/**
	 * Column Info
	 * @param d2avalCntrQty
	 */
	public void setD2avalCntrQty(String d2avalCntrQty) {
		this.d2avalCntrQty = d2avalCntrQty;
	}
	
	/**
	 * Column Info
	 * @param d2drffChgCrAmt
	 */
	public void setD2drffChgCrAmt(String d2drffChgCrAmt) {
		this.d2drffChgCrAmt = d2drffChgCrAmt;
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
	 * @param r2dfltUsdDys
	 */
	public void setR2dfltUsdDys(String r2dfltUsdDys) {
		this.r2dfltUsdDys = r2dfltUsdDys;
	}
	
	/**
	 * Column Info
	 * @param o2drffChgCrAmt
	 */
	public void setO2drffChgCrAmt(String o2drffChgCrAmt) {
		this.o2drffChgCrAmt = o2drffChgCrAmt;
	}
	
	/**
	 * Column Info
	 * @param f2dfltUsdDys
	 */
	public void setF2dfltUsdDys(String f2dfltUsdDys) {
		this.f2dfltUsdDys = f2dfltUsdDys;
	}
	
	/**
	 * Column Info
	 * @param o4avalCntrQty
	 */
	public void setO4avalCntrQty(String o4avalCntrQty) {
		this.o4avalCntrQty = o4avalCntrQty;
	}
	
	/**
	 * Column Info
	 * @param d2dfltUsdDys
	 */
	public void setD2dfltUsdDys(String d2dfltUsdDys) {
		this.d2dfltUsdDys = d2dfltUsdDys;
	}
	
	/**
	 * Column Info
	 * @param eccCd
	 */
	public void setEccCd(String eccCd) {
		this.eccCd = eccCd;
	}
	
	/**
	 * Column Info
	 * @param f4lftChgAmt
	 */
	public void setF4lftChgAmt(String f4lftChgAmt) {
		this.f4lftChgAmt = f4lftChgAmt;
	}
	
	/**
	 * Column Info
	 * @param d5drffChgCrAmt
	 */
	public void setD5drffChgCrAmt(String d5drffChgCrAmt) {
		this.d5drffChgCrAmt = d5drffChgCrAmt;
	}
	
	/**
	 * Column Info
	 * @param f2avalCntrQty
	 */
	public void setF2avalCntrQty(String f2avalCntrQty) {
		this.f2avalCntrQty = f2avalCntrQty;
	}
	
	/**
	 * Column Info
	 * @param r5avalCntrQty
	 */
	public void setR5avalCntrQty(String r5avalCntrQty) {
		this.r5avalCntrQty = r5avalCntrQty;
	}
	
	/**
	 * Column Info
	 * @param d7dfltUsdDys
	 */
	public void setD7dfltUsdDys(String d7dfltUsdDys) {
		this.d7dfltUsdDys = d7dfltUsdDys;
	}
	
	/**
	 * Column Info
	 * @param d5lftChgAmt
	 */
	public void setD5lftChgAmt(String d5lftChgAmt) {
		this.d5lftChgAmt = d5lftChgAmt;
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
	 * @param r5dfltUsdDys
	 */
	public void setR5dfltUsdDys(String r5dfltUsdDys) {
		this.r5dfltUsdDys = r5dfltUsdDys;
	}
	
	/**
	 * Column Info
	 * @param tpsztype
	 */
	public void setTpsztype(String tpsztype) {
		this.tpsztype = tpsztype;
	}
	
	/**
	 * Column Info
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * Column Info
	 * @param loctype
	 */
	public void setLoctype(String loctype) {
		this.loctype = loctype;
	}
	
	/**
	 * Column Info
	 * @param arrtpsz
	 */
	public void setArrtpsz(ArrayList<String> arrtpsz) {
		this.arrtpsz = arrtpsz;
	}
	
	/**
	 * Column Info
	 * @param arrlocation
	 */
	public void setArrlocation(ArrayList<String> arrlocation) {
		this.arrlocation = arrlocation;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setR2drygAmt(JSPUtil.getParameter(request, "r2dryg_amt", ""));
		setD7drygAmt(JSPUtil.getParameter(request, "d7dryg_amt", ""));
		setF2lftChgAmt(JSPUtil.getParameter(request, "f2lft_chg_amt", ""));
		setF4dfltUsdDys(JSPUtil.getParameter(request, "f4dflt_usd_dys", ""));
		setO2dfltUsdDys(JSPUtil.getParameter(request, "o2dflt_usd_dys", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setD4lftChgAmt(JSPUtil.getParameter(request, "d4lft_chg_amt", ""));
		setF2drygAmt(JSPUtil.getParameter(request, "f2dryg_amt", ""));
		setD4drffChgCrAmt(JSPUtil.getParameter(request, "d4drff_chg_cr_amt", ""));
		setD5drygAmt(JSPUtil.getParameter(request, "d5dryg_amt", ""));
		setD7lftChgAmt(JSPUtil.getParameter(request, "d7lft_chg_amt", ""));
		setD2lftChgAmt(JSPUtil.getParameter(request, "d2lft_chg_amt", ""));
		setD5dfltUsdDys(JSPUtil.getParameter(request, "d5dflt_usd_dys", ""));
		setR2lftChgAmt(JSPUtil.getParameter(request, "r2lft_chg_amt", ""));
		setO4lftChgAmt(JSPUtil.getParameter(request, "o4lft_chg_amt", ""));
		setO4drffChgCrAmt(JSPUtil.getParameter(request, "o4drff_chg_cr_amt", ""));
		setF4avalCntrQty(JSPUtil.getParameter(request, "f4aval_cntr_qty", ""));
		setF2drffChgCrAmt(JSPUtil.getParameter(request, "f2drff_chg_cr_amt", ""));
		setD7drffChgCrAmt(JSPUtil.getParameter(request, "d7drff_chg_cr_amt", ""));
		setD5avalCntrQty(JSPUtil.getParameter(request, "d5aval_cntr_qty", ""));
		setR2drffChgCrAmt(JSPUtil.getParameter(request, "r2drff_chg_cr_amt", ""));
		setO4drygAmt(JSPUtil.getParameter(request, "o4dryg_amt", ""));
		setD4dfltUsdDys(JSPUtil.getParameter(request, "d4dflt_usd_dys", ""));
		setO4dfltUsdDys(JSPUtil.getParameter(request, "o4dflt_usd_dys", ""));
		setF4drygAmt(JSPUtil.getParameter(request, "f4dryg_amt", ""));
		setR5drffChgCrAmt(JSPUtil.getParameter(request, "r5drff_chg_cr_amt", ""));
		setR5drygAmt(JSPUtil.getParameter(request, "r5dryg_amt", ""));
		setO2lftChgAmt(JSPUtil.getParameter(request, "o2lft_chg_amt", ""));
		setR2avalCntrQty(JSPUtil.getParameter(request, "r2aval_cntr_qty", ""));
		setD4avalCntrQty(JSPUtil.getParameter(request, "d4aval_cntr_qty", ""));
		setD7avalCntrQty(JSPUtil.getParameter(request, "d7aval_cntr_qty", ""));
		setO2avalCntrQty(JSPUtil.getParameter(request, "o2aval_cntr_qty", ""));
		setD2drygAmt(JSPUtil.getParameter(request, "d2dryg_amt", ""));
		setD4drygAmt(JSPUtil.getParameter(request, "d4dryg_amt", ""));
		setF4drffChgCrAmt(JSPUtil.getParameter(request, "f4drff_chg_cr_amt", ""));
		setO2drygAmt(JSPUtil.getParameter(request, "o2dryg_amt", ""));
		setR5lftChgAmt(JSPUtil.getParameter(request, "r5lft_chg_amt", ""));
		setD2avalCntrQty(JSPUtil.getParameter(request, "d2aval_cntr_qty", ""));
		setD2drffChgCrAmt(JSPUtil.getParameter(request, "d2drff_chg_cr_amt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setR2dfltUsdDys(JSPUtil.getParameter(request, "r2dflt_usd_dys", ""));
		setO2drffChgCrAmt(JSPUtil.getParameter(request, "o2drff_chg_cr_amt", ""));
		setF2dfltUsdDys(JSPUtil.getParameter(request, "f2dflt_usd_dys", ""));
		setO4avalCntrQty(JSPUtil.getParameter(request, "o4aval_cntr_qty", ""));
		setD2dfltUsdDys(JSPUtil.getParameter(request, "d2dflt_usd_dys", ""));
		setEccCd(JSPUtil.getParameter(request, "ecc_cd", ""));
		setF4lftChgAmt(JSPUtil.getParameter(request, "f4lft_chg_amt", ""));
		setD5drffChgCrAmt(JSPUtil.getParameter(request, "d5drff_chg_cr_amt", ""));
		setF2avalCntrQty(JSPUtil.getParameter(request, "f2aval_cntr_qty", ""));
		setR5avalCntrQty(JSPUtil.getParameter(request, "r5aval_cntr_qty", ""));
		setD7dfltUsdDys(JSPUtil.getParameter(request, "d7dflt_usd_dys", ""));
		setD5lftChgAmt(JSPUtil.getParameter(request, "d5lft_chg_amt", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setR5dfltUsdDys(JSPUtil.getParameter(request, "r5dflt_usd_dys", ""));
		setTpsztype(JSPUtil.getParameter(request, "tpsztype", ""));
		setLocation(JSPUtil.getParameter(request, "location", ""));
		setLoctype(JSPUtil.getParameter(request, "loctype", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchShortTermOffHireInfoVO[]
	 */
	public SearchShortTermOffHireInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchShortTermOffHireInfoVO[]
	 */
	public SearchShortTermOffHireInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchShortTermOffHireInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] r2drygAmt = (JSPUtil.getParameter(request, prefix	+ "r2dryg_amt", length));
			String[] d7drygAmt = (JSPUtil.getParameter(request, prefix	+ "d7dryg_amt", length));
			String[] f2lftChgAmt = (JSPUtil.getParameter(request, prefix	+ "f2lft_chg_amt", length));
			String[] f4dfltUsdDys = (JSPUtil.getParameter(request, prefix	+ "f4dflt_usd_dys", length));
			String[] o2dfltUsdDys = (JSPUtil.getParameter(request, prefix	+ "o2dflt_usd_dys", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] d4lftChgAmt = (JSPUtil.getParameter(request, prefix	+ "d4lft_chg_amt", length));
			String[] f2drygAmt = (JSPUtil.getParameter(request, prefix	+ "f2dryg_amt", length));
			String[] d4drffChgCrAmt = (JSPUtil.getParameter(request, prefix	+ "d4drff_chg_cr_amt", length));
			String[] d5drygAmt = (JSPUtil.getParameter(request, prefix	+ "d5dryg_amt", length));
			String[] d7lftChgAmt = (JSPUtil.getParameter(request, prefix	+ "d7lft_chg_amt", length));
			String[] d2lftChgAmt = (JSPUtil.getParameter(request, prefix	+ "d2lft_chg_amt", length));
			String[] d5dfltUsdDys = (JSPUtil.getParameter(request, prefix	+ "d5dflt_usd_dys", length));
			String[] r2lftChgAmt = (JSPUtil.getParameter(request, prefix	+ "r2lft_chg_amt", length));
			String[] o4lftChgAmt = (JSPUtil.getParameter(request, prefix	+ "o4lft_chg_amt", length));
			String[] o4drffChgCrAmt = (JSPUtil.getParameter(request, prefix	+ "o4drff_chg_cr_amt", length));
			String[] f4avalCntrQty = (JSPUtil.getParameter(request, prefix	+ "f4aval_cntr_qty", length));
			String[] f2drffChgCrAmt = (JSPUtil.getParameter(request, prefix	+ "f2drff_chg_cr_amt", length));
			String[] d7drffChgCrAmt = (JSPUtil.getParameter(request, prefix	+ "d7drff_chg_cr_amt", length));
			String[] d5avalCntrQty = (JSPUtil.getParameter(request, prefix	+ "d5aval_cntr_qty", length));
			String[] r2drffChgCrAmt = (JSPUtil.getParameter(request, prefix	+ "r2drff_chg_cr_amt", length));
			String[] o4drygAmt = (JSPUtil.getParameter(request, prefix	+ "o4dryg_amt", length));
			String[] d4dfltUsdDys = (JSPUtil.getParameter(request, prefix	+ "d4dflt_usd_dys", length));
			String[] o4dfltUsdDys = (JSPUtil.getParameter(request, prefix	+ "o4dflt_usd_dys", length));
			String[] f4drygAmt = (JSPUtil.getParameter(request, prefix	+ "f4dryg_amt", length));
			String[] r5drffChgCrAmt = (JSPUtil.getParameter(request, prefix	+ "r5drff_chg_cr_amt", length));
			String[] r5drygAmt = (JSPUtil.getParameter(request, prefix	+ "r5dryg_amt", length));
			String[] o2lftChgAmt = (JSPUtil.getParameter(request, prefix	+ "o2lft_chg_amt", length));
			String[] r2avalCntrQty = (JSPUtil.getParameter(request, prefix	+ "r2aval_cntr_qty", length));
			String[] d4avalCntrQty = (JSPUtil.getParameter(request, prefix	+ "d4aval_cntr_qty", length));
			String[] d7avalCntrQty = (JSPUtil.getParameter(request, prefix	+ "d7aval_cntr_qty", length));
			String[] o2avalCntrQty = (JSPUtil.getParameter(request, prefix	+ "o2aval_cntr_qty", length));
			String[] d2drygAmt = (JSPUtil.getParameter(request, prefix	+ "d2dryg_amt", length));
			String[] d4drygAmt = (JSPUtil.getParameter(request, prefix	+ "d4dryg_amt", length));
			String[] f4drffChgCrAmt = (JSPUtil.getParameter(request, prefix	+ "f4drff_chg_cr_amt", length));
			String[] o2drygAmt = (JSPUtil.getParameter(request, prefix	+ "o2dryg_amt", length));
			String[] r5lftChgAmt = (JSPUtil.getParameter(request, prefix	+ "r5lft_chg_amt", length));
			String[] d2avalCntrQty = (JSPUtil.getParameter(request, prefix	+ "d2aval_cntr_qty", length));
			String[] d2drffChgCrAmt = (JSPUtil.getParameter(request, prefix	+ "d2drff_chg_cr_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] r2dfltUsdDys = (JSPUtil.getParameter(request, prefix	+ "r2dflt_usd_dys", length));
			String[] o2drffChgCrAmt = (JSPUtil.getParameter(request, prefix	+ "o2drff_chg_cr_amt", length));
			String[] f2dfltUsdDys = (JSPUtil.getParameter(request, prefix	+ "f2dflt_usd_dys", length));
			String[] o4avalCntrQty = (JSPUtil.getParameter(request, prefix	+ "o4aval_cntr_qty", length));
			String[] d2dfltUsdDys = (JSPUtil.getParameter(request, prefix	+ "d2dflt_usd_dys", length));
			String[] eccCd = (JSPUtil.getParameter(request, prefix	+ "ecc_cd", length));
			String[] f4lftChgAmt = (JSPUtil.getParameter(request, prefix	+ "f4lft_chg_amt", length));
			String[] d5drffChgCrAmt = (JSPUtil.getParameter(request, prefix	+ "d5drff_chg_cr_amt", length));
			String[] f2avalCntrQty = (JSPUtil.getParameter(request, prefix	+ "f2aval_cntr_qty", length));
			String[] r5avalCntrQty = (JSPUtil.getParameter(request, prefix	+ "r5aval_cntr_qty", length));
			String[] d7dfltUsdDys = (JSPUtil.getParameter(request, prefix	+ "d7dflt_usd_dys", length));
			String[] d5lftChgAmt = (JSPUtil.getParameter(request, prefix	+ "d5lft_chg_amt", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] r5dfltUsdDys = (JSPUtil.getParameter(request, prefix	+ "r5dflt_usd_dys", length));
			String[] tpsz = (JSPUtil.getParameter(request, prefix	+ "tpsz", length));
			String[] location = (JSPUtil.getParameter(request, prefix	+ "location", length));
			//String[] company = (JSPUtil.getParameter(request, prefix	+ "company", length));
			String[] loctype = (JSPUtil.getParameter(request, prefix	+ "loctype", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchShortTermOffHireInfoVO();
				if (r2drygAmt[i] != null)
					model.setR2drygAmt(r2drygAmt[i]);
				if (d7drygAmt[i] != null)
					model.setD7drygAmt(d7drygAmt[i]);
				if (f2lftChgAmt[i] != null)
					model.setF2lftChgAmt(f2lftChgAmt[i]);
				if (f4dfltUsdDys[i] != null)
					model.setF4dfltUsdDys(f4dfltUsdDys[i]);
				if (o2dfltUsdDys[i] != null)
					model.setO2dfltUsdDys(o2dfltUsdDys[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (d4lftChgAmt[i] != null)
					model.setD4lftChgAmt(d4lftChgAmt[i]);
				if (f2drygAmt[i] != null)
					model.setF2drygAmt(f2drygAmt[i]);
				if (d4drffChgCrAmt[i] != null)
					model.setD4drffChgCrAmt(d4drffChgCrAmt[i]);
				if (d5drygAmt[i] != null)
					model.setD5drygAmt(d5drygAmt[i]);
				if (d7lftChgAmt[i] != null)
					model.setD7lftChgAmt(d7lftChgAmt[i]);
				if (d2lftChgAmt[i] != null)
					model.setD2lftChgAmt(d2lftChgAmt[i]);
				if (d5dfltUsdDys[i] != null)
					model.setD5dfltUsdDys(d5dfltUsdDys[i]);
				if (r2lftChgAmt[i] != null)
					model.setR2lftChgAmt(r2lftChgAmt[i]);
				if (o4lftChgAmt[i] != null)
					model.setO4lftChgAmt(o4lftChgAmt[i]);
				if (o4drffChgCrAmt[i] != null)
					model.setO4drffChgCrAmt(o4drffChgCrAmt[i]);
				if (f4avalCntrQty[i] != null)
					model.setF4avalCntrQty(f4avalCntrQty[i]);
				if (f2drffChgCrAmt[i] != null)
					model.setF2drffChgCrAmt(f2drffChgCrAmt[i]);
				if (d7drffChgCrAmt[i] != null)
					model.setD7drffChgCrAmt(d7drffChgCrAmt[i]);
				if (d5avalCntrQty[i] != null)
					model.setD5avalCntrQty(d5avalCntrQty[i]);
				if (r2drffChgCrAmt[i] != null)
					model.setR2drffChgCrAmt(r2drffChgCrAmt[i]);
				if (o4drygAmt[i] != null)
					model.setO4drygAmt(o4drygAmt[i]);
				if (d4dfltUsdDys[i] != null)
					model.setD4dfltUsdDys(d4dfltUsdDys[i]);
				if (o4dfltUsdDys[i] != null)
					model.setO4dfltUsdDys(o4dfltUsdDys[i]);
				if (f4drygAmt[i] != null)
					model.setF4drygAmt(f4drygAmt[i]);
				if (r5drffChgCrAmt[i] != null)
					model.setR5drffChgCrAmt(r5drffChgCrAmt[i]);
				if (r5drygAmt[i] != null)
					model.setR5drygAmt(r5drygAmt[i]);
				if (o2lftChgAmt[i] != null)
					model.setO2lftChgAmt(o2lftChgAmt[i]);
				if (r2avalCntrQty[i] != null)
					model.setR2avalCntrQty(r2avalCntrQty[i]);
				if (d4avalCntrQty[i] != null)
					model.setD4avalCntrQty(d4avalCntrQty[i]);
				if (d7avalCntrQty[i] != null)
					model.setD7avalCntrQty(d7avalCntrQty[i]);
				if (o2avalCntrQty[i] != null)
					model.setO2avalCntrQty(o2avalCntrQty[i]);
				if (d2drygAmt[i] != null)
					model.setD2drygAmt(d2drygAmt[i]);
				if (d4drygAmt[i] != null)
					model.setD4drygAmt(d4drygAmt[i]);
				if (f4drffChgCrAmt[i] != null)
					model.setF4drffChgCrAmt(f4drffChgCrAmt[i]);
				if (o2drygAmt[i] != null)
					model.setO2drygAmt(o2drygAmt[i]);
				if (r5lftChgAmt[i] != null)
					model.setR5lftChgAmt(r5lftChgAmt[i]);
				if (d2avalCntrQty[i] != null)
					model.setD2avalCntrQty(d2avalCntrQty[i]);
				if (d2drffChgCrAmt[i] != null)
					model.setD2drffChgCrAmt(d2drffChgCrAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (r2dfltUsdDys[i] != null)
					model.setR2dfltUsdDys(r2dfltUsdDys[i]);
				if (o2drffChgCrAmt[i] != null)
					model.setO2drffChgCrAmt(o2drffChgCrAmt[i]);
				if (f2dfltUsdDys[i] != null)
					model.setF2dfltUsdDys(f2dfltUsdDys[i]);
				if (o4avalCntrQty[i] != null)
					model.setO4avalCntrQty(o4avalCntrQty[i]);
				if (d2dfltUsdDys[i] != null)
					model.setD2dfltUsdDys(d2dfltUsdDys[i]);
				if (eccCd[i] != null)
					model.setEccCd(eccCd[i]);
				if (f4lftChgAmt[i] != null)
					model.setF4lftChgAmt(f4lftChgAmt[i]);
				if (d5drffChgCrAmt[i] != null)
					model.setD5drffChgCrAmt(d5drffChgCrAmt[i]);
				if (f2avalCntrQty[i] != null)
					model.setF2avalCntrQty(f2avalCntrQty[i]);
				if (r5avalCntrQty[i] != null)
					model.setR5avalCntrQty(r5avalCntrQty[i]);
				if (d7dfltUsdDys[i] != null)
					model.setD7dfltUsdDys(d7dfltUsdDys[i]);
				if (d5lftChgAmt[i] != null)
					model.setD5lftChgAmt(d5lftChgAmt[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (r5dfltUsdDys[i] != null)
					model.setR5dfltUsdDys(r5dfltUsdDys[i]);
				if (tpsz[i] != null)
					model.setTpsztype(tpsz[i]);
				if (location[i] != null)
					model.setLocation(location[i]);
				if (loctype[i] != null)
					model.setLoctype(loctype[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchShortTermOffHireInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchShortTermOffHireInfoVO[]
	 */
	public SearchShortTermOffHireInfoVO[] getSearchShortTermOffHireInfoVOs(){
		SearchShortTermOffHireInfoVO[] vos = (SearchShortTermOffHireInfoVO[])models.toArray(new SearchShortTermOffHireInfoVO[models.size()]);
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
		this.r2drygAmt = this.r2drygAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7drygAmt = this.d7drygAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f2lftChgAmt = this.f2lftChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4dfltUsdDys = this.f4dfltUsdDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o2dfltUsdDys = this.o2dfltUsdDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4lftChgAmt = this.d4lftChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f2drygAmt = this.f2drygAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4drffChgCrAmt = this.d4drffChgCrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5drygAmt = this.d5drygAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7lftChgAmt = this.d7lftChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2lftChgAmt = this.d2lftChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5dfltUsdDys = this.d5dfltUsdDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2lftChgAmt = this.r2lftChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o4lftChgAmt = this.o4lftChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o4drffChgCrAmt = this.o4drffChgCrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4avalCntrQty = this.f4avalCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f2drffChgCrAmt = this.f2drffChgCrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7drffChgCrAmt = this.d7drffChgCrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5avalCntrQty = this.d5avalCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2drffChgCrAmt = this.r2drffChgCrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o4drygAmt = this.o4drygAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4dfltUsdDys = this.d4dfltUsdDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o4dfltUsdDys = this.o4dfltUsdDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4drygAmt = this.f4drygAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5drffChgCrAmt = this.r5drffChgCrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5drygAmt = this.r5drygAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o2lftChgAmt = this.o2lftChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2avalCntrQty = this.r2avalCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4avalCntrQty = this.d4avalCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7avalCntrQty = this.d7avalCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o2avalCntrQty = this.o2avalCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2drygAmt = this.d2drygAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4drygAmt = this.d4drygAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4drffChgCrAmt = this.f4drffChgCrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o2drygAmt = this.o2drygAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5lftChgAmt = this.r5lftChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2avalCntrQty = this.d2avalCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2drffChgCrAmt = this.d2drffChgCrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2dfltUsdDys = this.r2dfltUsdDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o2drffChgCrAmt = this.o2drffChgCrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f2dfltUsdDys = this.f2dfltUsdDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o4avalCntrQty = this.o4avalCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2dfltUsdDys = this.d2dfltUsdDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eccCd = this.eccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4lftChgAmt = this.f4lftChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5drffChgCrAmt = this.d5drffChgCrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f2avalCntrQty = this.f2avalCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5avalCntrQty = this.r5avalCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7dfltUsdDys = this.d7dfltUsdDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5lftChgAmt = this.d5lftChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5dfltUsdDys = this.r5dfltUsdDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsztype = this.tpsztype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.location = this.location .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loctype = this.loctype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
