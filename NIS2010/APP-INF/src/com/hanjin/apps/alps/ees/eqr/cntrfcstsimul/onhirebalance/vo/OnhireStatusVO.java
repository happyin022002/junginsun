/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : OnhireStatusVO.java
*@FileTitle : OnhireStatusVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.12
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.08.12 문동선 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.onhirebalance.vo;

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
 * @author 문동선
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OnhireStatusVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OnhireStatusVO> models = new ArrayList<OnhireStatusVO>();
	
	/* Column Info */
	private String rsltO2Qty = null;
	/* Column Info */
	private String orderR9Qty = null;
	/* Column Info */
	private String xMergeFlag = null;
	/* Column Info */
	private String orderO4Qty = null;
	/* Column Info */
	private String orderO5Qty = null;	
	/* Column Info */
	private String apprD5Qty = null;
	/* Column Info */
	private String rsltA4Qty = null;
	/* Column Info */
	private String rsltA5Qty = null;	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String apprD4Qty = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String apprR2Qty = null;
	/* Column Info */
	private String apprF4Qty = null;
	/* Column Info */
	private String orderR5Qty = null;
	/* Column Info */
	private String apprR9Qty = null;
	/* Column Info */
	private String period = null;
	/* Column Info */
	private String orderD7Qty = null;
	/* Column Info */
	private String apprR5Qty = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String rsltD5Qty = null;
	/* Column Info */
	private String years = null;
	/* Column Info */
	private String orderF4Qty = null;
	/* Column Info */
	private String rsltR2Qty = null;
	/* Column Info */
	private String rsltF4Qty = null;
	/* Column Info */
	private String onhOrdYr = null;
	/* Column Info */
	private String orderD5Qty = null;
	/* Column Info */
	private String orderD4Qty = null;
	/* Column Info */
	private String rsltR9Qty = null;
	/* Column Info */
	private String apprD2Qty = null;
	/* Column Info */
	private String mergeFlag = null;
	/* Column Info */
	private String rsltF5Qty = null;
	/* Column Info */
	private String onhOrdRmk = null;
	/* Column Info */
	private String orderD2Qty = null;
	/* Column Info */
	private String orderA2Qty = null;
	/* Column Info */
	private String rsltD7Qty = null;
	/* Column Info */
	private String lsePrdSeq = null;
	/* Column Info */
	private String rsltD2Qty = null;
	/* Column Info */
	private String orderS2Qty = null;
	/* Column Info */
	private String apprF2Qty = null;
	/* Column Info */
	private String rsltS2Qty = null;
	/* Column Info */
	private String apprD7Qty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rsltF2Qty = null;
	/* Column Info */
	private String rsltD4Qty = null;
	/* Column Info */
	private String orderF2Qty = null;
	/* Column Info */
	private String rsltR5Qty = null;
	/* Column Info */
	private String orderR2Qty = null;
	/* Column Info */
	private String rsltA2Qty = null;
	/* Column Info */
	private String apprS4Qty = null;
	/* Column Info */
	private String orderO2Qty = null;
	/* Column Info */
	private String apprS2Qty = null;
	/* Column Info */
	private String rccCd = null;
	/* Column Info */
	private String apprF5Qty = null;
	/* Column Info */
	private String rsltO4Qty = null;
	/* Column Info */
	private String rsltO5Qty = null;	
	/* Column Info */
	private String orderS4Qty = null;
	/* Column Info */
	private String apprA2Qty = null;
	/* Column Info */
	private String eqLstmCd = null;
	/* Column Info */
	private String lccCd = null;
	/* Column Info */
	private String apprO2Qty = null;
	/* Column Info */
	private String orderA4Qty = null;
	/* Column Info */
	private String orderA5Qty = null;	
	/* Column Info */
	private String orderF5Qty = null;
	/* Column Info */
	private String apprA4Qty = null;
	/* Column Info */
	private String apprA5Qty = null;	
	/* Column Info */
	private String rsltS4Qty = null;
	/* Column Info */
	private String apprO4Qty = null;
	/* Column Info */
	private String apprO5Qty = null;	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OnhireStatusVO() {}

	public OnhireStatusVO(String ibflag, String pagerows, String rccCd, String lccCd, String onhOrdYr, String eqLstmCd, String lsePrdSeq, String period, String orderD2Qty, String orderD4Qty, String orderD5Qty, String orderD7Qty, String orderR2Qty, String orderR5Qty, String orderR9Qty, String orderO2Qty, String orderO4Qty, String orderO5Qty, String orderS2Qty, String orderS4Qty, String orderF2Qty, String orderF4Qty, String orderF5Qty, String orderA2Qty, String orderA4Qty, String orderA5Qty, String apprD2Qty, String apprD4Qty, String apprD5Qty, String apprD7Qty, String apprR2Qty, String apprR5Qty, String apprR9Qty, String apprO2Qty, String apprO4Qty, String apprO5Qty, String apprS2Qty, String apprS4Qty, String apprF2Qty, String apprF4Qty, String apprF5Qty, String apprA2Qty, String apprA4Qty, String apprA5Qty, String rsltD2Qty, String rsltD4Qty, String rsltD5Qty, String rsltD7Qty, String rsltR2Qty, String rsltR5Qty, String rsltR9Qty, String rsltO2Qty, String rsltO4Qty, String rsltO5Qty, String rsltS2Qty, String rsltS4Qty, String rsltF2Qty, String rsltF4Qty, String rsltF5Qty, String rsltA2Qty, String rsltA4Qty, String rsltA5Qty, String onhOrdRmk, String mergeFlag, String xMergeFlag, String years, String updUsrId, String creUsrId) {
		this.rsltO2Qty = rsltO2Qty;
		this.orderR9Qty = orderR9Qty;
		this.xMergeFlag = xMergeFlag;
		this.orderO4Qty = orderO4Qty;
		this.orderO5Qty = orderO5Qty;		
		this.apprD5Qty = apprD5Qty;
		this.rsltA4Qty = rsltA4Qty;
		this.rsltA5Qty = rsltA5Qty;		
		this.pagerows = pagerows;
		this.apprD4Qty = apprD4Qty;
		this.updUsrId = updUsrId;
		this.apprR2Qty = apprR2Qty;
		this.apprF4Qty = apprF4Qty;
		this.orderR5Qty = orderR5Qty;
		this.apprR9Qty = apprR9Qty;
		this.period = period;
		this.orderD7Qty = orderD7Qty;
		this.apprR5Qty = apprR5Qty;
		this.creUsrId = creUsrId;
		this.rsltD5Qty = rsltD5Qty;
		this.years = years;
		this.orderF4Qty = orderF4Qty;
		this.rsltR2Qty = rsltR2Qty;
		this.rsltF4Qty = rsltF4Qty;
		this.onhOrdYr = onhOrdYr;
		this.orderD5Qty = orderD5Qty;
		this.orderD4Qty = orderD4Qty;
		this.rsltR9Qty = rsltR9Qty;
		this.apprD2Qty = apprD2Qty;
		this.mergeFlag = mergeFlag;
		this.rsltF5Qty = rsltF5Qty;
		this.onhOrdRmk = onhOrdRmk;
		this.orderD2Qty = orderD2Qty;
		this.orderA2Qty = orderA2Qty;
		this.rsltD7Qty = rsltD7Qty;
		this.lsePrdSeq = lsePrdSeq;
		this.rsltD2Qty = rsltD2Qty;
		this.orderS2Qty = orderS2Qty;
		this.apprF2Qty = apprF2Qty;
		this.rsltS2Qty = rsltS2Qty;
		this.apprD7Qty = apprD7Qty;
		this.ibflag = ibflag;
		this.rsltF2Qty = rsltF2Qty;
		this.rsltD4Qty = rsltD4Qty;
		this.orderF2Qty = orderF2Qty;
		this.rsltR5Qty = rsltR5Qty;
		this.orderR2Qty = orderR2Qty;
		this.rsltA2Qty = rsltA2Qty;
		this.apprS4Qty = apprS4Qty;
		this.orderO2Qty = orderO2Qty;
		this.apprS2Qty = apprS2Qty;
		this.rccCd = rccCd;
		this.apprF5Qty = apprF5Qty;
		this.rsltO4Qty = rsltO4Qty;
		this.rsltO5Qty = rsltO5Qty;		
		this.orderS4Qty = orderS4Qty;
		this.apprA2Qty = apprA2Qty;
		this.eqLstmCd = eqLstmCd;
		this.lccCd = lccCd;
		this.apprO2Qty = apprO2Qty;
		this.orderA4Qty = orderA4Qty;
		this.orderA5Qty = orderA5Qty;		
		this.orderF5Qty = orderF5Qty;
		this.apprA4Qty = apprA4Qty;
		this.apprA5Qty = apprA5Qty;		
		this.rsltS4Qty = rsltS4Qty;
		this.apprO4Qty = apprO4Qty;
		this.apprO5Qty = apprO5Qty;		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rslt_o2_qty", getRsltO2Qty());
		this.hashColumns.put("order_r9_qty", getOrderR9Qty());
		this.hashColumns.put("x_merge_flag", getXMergeFlag());
		this.hashColumns.put("order_o4_qty", getOrderO4Qty());
		this.hashColumns.put("order_o5_qty", getOrderO5Qty());		
		this.hashColumns.put("appr_d5_qty", getApprD5Qty());
		this.hashColumns.put("rslt_a4_qty", getRsltA4Qty());
		this.hashColumns.put("rslt_a5_qty", getRsltA5Qty());		
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("appr_d4_qty", getApprD4Qty());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("appr_r2_qty", getApprR2Qty());
		this.hashColumns.put("appr_f4_qty", getApprF4Qty());
		this.hashColumns.put("order_r5_qty", getOrderR5Qty());
		this.hashColumns.put("appr_r9_qty", getApprR9Qty());
		this.hashColumns.put("period", getPeriod());
		this.hashColumns.put("order_d7_qty", getOrderD7Qty());
		this.hashColumns.put("appr_r5_qty", getApprR5Qty());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("rslt_d5_qty", getRsltD5Qty());
		this.hashColumns.put("years", getYears());
		this.hashColumns.put("order_f4_qty", getOrderF4Qty());
		this.hashColumns.put("rslt_r2_qty", getRsltR2Qty());
		this.hashColumns.put("rslt_f4_qty", getRsltF4Qty());
		this.hashColumns.put("onh_ord_yr", getOnhOrdYr());
		this.hashColumns.put("order_d5_qty", getOrderD5Qty());
		this.hashColumns.put("order_d4_qty", getOrderD4Qty());
		this.hashColumns.put("rslt_r9_qty", getRsltR9Qty());
		this.hashColumns.put("appr_d2_qty", getApprD2Qty());
		this.hashColumns.put("merge_flag", getMergeFlag());
		this.hashColumns.put("rslt_f5_qty", getRsltF5Qty());
		this.hashColumns.put("onh_ord_rmk", getOnhOrdRmk());
		this.hashColumns.put("order_d2_qty", getOrderD2Qty());
		this.hashColumns.put("order_a2_qty", getOrderA2Qty());
		this.hashColumns.put("rslt_d7_qty", getRsltD7Qty());
		this.hashColumns.put("lse_prd_seq", getLsePrdSeq());
		this.hashColumns.put("rslt_d2_qty", getRsltD2Qty());
		this.hashColumns.put("order_s2_qty", getOrderS2Qty());
		this.hashColumns.put("appr_f2_qty", getApprF2Qty());
		this.hashColumns.put("rslt_s2_qty", getRsltS2Qty());
		this.hashColumns.put("appr_d7_qty", getApprD7Qty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rslt_f2_qty", getRsltF2Qty());
		this.hashColumns.put("rslt_d4_qty", getRsltD4Qty());
		this.hashColumns.put("order_f2_qty", getOrderF2Qty());
		this.hashColumns.put("rslt_r5_qty", getRsltR5Qty());
		this.hashColumns.put("order_r2_qty", getOrderR2Qty());
		this.hashColumns.put("rslt_a2_qty", getRsltA2Qty());
		this.hashColumns.put("appr_s4_qty", getApprS4Qty());
		this.hashColumns.put("order_o2_qty", getOrderO2Qty());
		this.hashColumns.put("appr_s2_qty", getApprS2Qty());
		this.hashColumns.put("rcc_cd", getRccCd());
		this.hashColumns.put("appr_f5_qty", getApprF5Qty());
		this.hashColumns.put("rslt_o4_qty", getRsltO4Qty());
		this.hashColumns.put("rslt_o5_qty", getRsltO5Qty());		
		this.hashColumns.put("order_s4_qty", getOrderS4Qty());
		this.hashColumns.put("appr_a2_qty", getApprA2Qty());
		this.hashColumns.put("eq_lstm_cd", getEqLstmCd());
		this.hashColumns.put("lcc_cd", getLccCd());
		this.hashColumns.put("appr_o2_qty", getApprO2Qty());
		this.hashColumns.put("order_a4_qty", getOrderA4Qty());
		this.hashColumns.put("order_a5_qty", getOrderA5Qty());		
		this.hashColumns.put("order_f5_qty", getOrderF5Qty());
		this.hashColumns.put("appr_a4_qty", getApprA4Qty());
		this.hashColumns.put("appr_a5_qty", getApprA5Qty());		
		this.hashColumns.put("rslt_s4_qty", getRsltS4Qty());
		this.hashColumns.put("appr_o4_qty", getApprO4Qty());
		this.hashColumns.put("appr_o5_qty", getApprO5Qty());		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rslt_o2_qty", "rsltO2Qty");
		this.hashFields.put("order_r9_qty", "orderR9Qty");
		this.hashFields.put("x_merge_flag", "xMergeFlag");
		this.hashFields.put("order_o4_qty", "orderO4Qty");
		this.hashFields.put("order_o5_qty", "orderO5Qty");		
		this.hashFields.put("appr_d5_qty", "apprD5Qty");
		this.hashFields.put("rslt_a4_qty", "rsltA4Qty");
		this.hashFields.put("rslt_a5_qty", "rsltA5Qty");		
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("appr_d4_qty", "apprD4Qty");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("appr_r2_qty", "apprR2Qty");
		this.hashFields.put("appr_f4_qty", "apprF4Qty");
		this.hashFields.put("order_r5_qty", "orderR5Qty");
		this.hashFields.put("appr_r9_qty", "apprR9Qty");
		this.hashFields.put("period", "period");
		this.hashFields.put("order_d7_qty", "orderD7Qty");
		this.hashFields.put("appr_r5_qty", "apprR5Qty");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("rslt_d5_qty", "rsltD5Qty");
		this.hashFields.put("years", "years");
		this.hashFields.put("order_f4_qty", "orderF4Qty");
		this.hashFields.put("rslt_r2_qty", "rsltR2Qty");
		this.hashFields.put("rslt_f4_qty", "rsltF4Qty");
		this.hashFields.put("onh_ord_yr", "onhOrdYr");
		this.hashFields.put("order_d5_qty", "orderD5Qty");
		this.hashFields.put("order_d4_qty", "orderD4Qty");
		this.hashFields.put("rslt_r9_qty", "rsltR9Qty");
		this.hashFields.put("appr_d2_qty", "apprD2Qty");
		this.hashFields.put("merge_flag", "mergeFlag");
		this.hashFields.put("rslt_f5_qty", "rsltF5Qty");
		this.hashFields.put("onh_ord_rmk", "onhOrdRmk");
		this.hashFields.put("order_d2_qty", "orderD2Qty");
		this.hashFields.put("order_a2_qty", "orderA2Qty");
		this.hashFields.put("rslt_d7_qty", "rsltD7Qty");
		this.hashFields.put("lse_prd_seq", "lsePrdSeq");
		this.hashFields.put("rslt_d2_qty", "rsltD2Qty");
		this.hashFields.put("order_s2_qty", "orderS2Qty");
		this.hashFields.put("appr_f2_qty", "apprF2Qty");
		this.hashFields.put("rslt_s2_qty", "rsltS2Qty");
		this.hashFields.put("appr_d7_qty", "apprD7Qty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rslt_f2_qty", "rsltF2Qty");
		this.hashFields.put("rslt_d4_qty", "rsltD4Qty");
		this.hashFields.put("order_f2_qty", "orderF2Qty");
		this.hashFields.put("rslt_r5_qty", "rsltR5Qty");
		this.hashFields.put("order_r2_qty", "orderR2Qty");
		this.hashFields.put("rslt_a2_qty", "rsltA2Qty");
		this.hashFields.put("appr_s4_qty", "apprS4Qty");
		this.hashFields.put("order_o2_qty", "orderO2Qty");
		this.hashFields.put("appr_s2_qty", "apprS2Qty");
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("appr_f5_qty", "apprF5Qty");
		this.hashFields.put("rslt_o4_qty", "rsltO4Qty");
		this.hashFields.put("rslt_o5_qty", "rsltO5Qty");		
		this.hashFields.put("order_s4_qty", "orderS4Qty");
		this.hashFields.put("appr_a2_qty", "apprA2Qty");
		this.hashFields.put("eq_lstm_cd", "eqLstmCd");
		this.hashFields.put("lcc_cd", "lccCd");
		this.hashFields.put("appr_o2_qty", "apprO2Qty");
		this.hashFields.put("order_a4_qty", "orderA4Qty");
		this.hashFields.put("order_a5_qty", "orderA5Qty");		
		this.hashFields.put("order_f5_qty", "orderF5Qty");
		this.hashFields.put("appr_a4_qty", "apprA4Qty");
		this.hashFields.put("appr_a5_qty", "apprA5Qty");		
		this.hashFields.put("rslt_s4_qty", "rsltS4Qty");
		this.hashFields.put("appr_o4_qty", "apprO4Qty");
		this.hashFields.put("appr_o5_qty", "apprO5Qty");		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rsltO2Qty
	 */
	public String getRsltO2Qty() {
		return this.rsltO2Qty;
	}
	
	/**
	 * Column Info
	 * @return orderR9Qty
	 */
	public String getOrderR9Qty() {
		return this.orderR9Qty;
	}
	
	/**
	 * Column Info
	 * @return xMergeFlag
	 */
	public String getXMergeFlag() {
		return this.xMergeFlag;
	}
	
	/**
	 * Column Info
	 * @return orderO4Qty
	 */
	public String getOrderO4Qty() {
		return this.orderO4Qty;
	}
	
	/**
	 * Column Info
	 * @return orderO5Qty
	 */
	public String getOrderO5Qty() {
		return this.orderO5Qty;
	}	
	
	/**
	 * Column Info
	 * @return apprD5Qty
	 */
	public String getApprD5Qty() {
		return this.apprD5Qty;
	}
	
	/**
	 * Column Info
	 * @return rsltA4Qty
	 */
	public String getRsltA4Qty() {
		return this.rsltA4Qty;
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
	 * @return apprD4Qty
	 */
	public String getApprD4Qty() {
		return this.apprD4Qty;
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
	 * @return apprR2Qty
	 */
	public String getApprR2Qty() {
		return this.apprR2Qty;
	}
	
	/**
	 * Column Info
	 * @return apprF4Qty
	 */
	public String getApprF4Qty() {
		return this.apprF4Qty;
	}
	
	/**
	 * Column Info
	 * @return orderR5Qty
	 */
	public String getOrderR5Qty() {
		return this.orderR5Qty;
	}
	
	/**
	 * Column Info
	 * @return apprR9Qty
	 */
	public String getApprR9Qty() {
		return this.apprR9Qty;
	}
	
	/**
	 * Column Info
	 * @return period
	 */
	public String getPeriod() {
		return this.period;
	}
	
	/**
	 * Column Info
	 * @return orderD7Qty
	 */
	public String getOrderD7Qty() {
		return this.orderD7Qty;
	}
	
	/**
	 * Column Info
	 * @return apprR5Qty
	 */
	public String getApprR5Qty() {
		return this.apprR5Qty;
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
	 * @return rsltD5Qty
	 */
	public String getRsltD5Qty() {
		return this.rsltD5Qty;
	}
	
	/**
	 * Column Info
	 * @return years
	 */
	public String getYears() {
		return this.years;
	}
	
	/**
	 * Column Info
	 * @return orderF4Qty
	 */
	public String getOrderF4Qty() {
		return this.orderF4Qty;
	}
	
	/**
	 * Column Info
	 * @return rsltR2Qty
	 */
	public String getRsltR2Qty() {
		return this.rsltR2Qty;
	}
	
	/**
	 * Column Info
	 * @return rsltF4Qty
	 */
	public String getRsltF4Qty() {
		return this.rsltF4Qty;
	}
	
	/**
	 * Column Info
	 * @return onhOrdYr
	 */
	public String getOnhOrdYr() {
		return this.onhOrdYr;
	}
	
	/**
	 * Column Info
	 * @return orderD5Qty
	 */
	public String getOrderD5Qty() {
		return this.orderD5Qty;
	}
	
	/**
	 * Column Info
	 * @return orderD4Qty
	 */
	public String getOrderD4Qty() {
		return this.orderD4Qty;
	}
	
	/**
	 * Column Info
	 * @return rsltR9Qty
	 */
	public String getRsltR9Qty() {
		return this.rsltR9Qty;
	}
	
	/**
	 * Column Info
	 * @return apprD2Qty
	 */
	public String getApprD2Qty() {
		return this.apprD2Qty;
	}
	
	/**
	 * Column Info
	 * @return mergeFlag
	 */
	public String getMergeFlag() {
		return this.mergeFlag;
	}
	
	/**
	 * Column Info
	 * @return rsltF5Qty
	 */
	public String getRsltF5Qty() {
		return this.rsltF5Qty;
	}
	
	/**
	 * Column Info
	 * @return onhOrdRmk
	 */
	public String getOnhOrdRmk() {
		return this.onhOrdRmk;
	}
	
	/**
	 * Column Info
	 * @return orderD2Qty
	 */
	public String getOrderD2Qty() {
		return this.orderD2Qty;
	}
	
	/**
	 * Column Info
	 * @return orderA2Qty
	 */
	public String getOrderA2Qty() {
		return this.orderA2Qty;
	}
	
	/**
	 * Column Info
	 * @return rsltD7Qty
	 */
	public String getRsltD7Qty() {
		return this.rsltD7Qty;
	}
	
	/**
	 * Column Info
	 * @return lsePrdSeq
	 */
	public String getLsePrdSeq() {
		return this.lsePrdSeq;
	}
	
	/**
	 * Column Info
	 * @return rsltD2Qty
	 */
	public String getRsltD2Qty() {
		return this.rsltD2Qty;
	}
	
	/**
	 * Column Info
	 * @return orderS2Qty
	 */
	public String getOrderS2Qty() {
		return this.orderS2Qty;
	}
	
	/**
	 * Column Info
	 * @return apprF2Qty
	 */
	public String getApprF2Qty() {
		return this.apprF2Qty;
	}
	
	/**
	 * Column Info
	 * @return rsltS2Qty
	 */
	public String getRsltS2Qty() {
		return this.rsltS2Qty;
	}
	
	/**
	 * Column Info
	 * @return apprD7Qty
	 */
	public String getApprD7Qty() {
		return this.apprD7Qty;
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
	 * @return rsltF2Qty
	 */
	public String getRsltF2Qty() {
		return this.rsltF2Qty;
	}
	
	/**
	 * Column Info
	 * @return rsltD4Qty
	 */
	public String getRsltD4Qty() {
		return this.rsltD4Qty;
	}
	
	/**
	 * Column Info
	 * @return orderF2Qty
	 */
	public String getOrderF2Qty() {
		return this.orderF2Qty;
	}
	
	/**
	 * Column Info
	 * @return rsltR5Qty
	 */
	public String getRsltR5Qty() {
		return this.rsltR5Qty;
	}
	
	/**
	 * Column Info
	 * @return orderR2Qty
	 */
	public String getOrderR2Qty() {
		return this.orderR2Qty;
	}
	
	/**
	 * Column Info
	 * @return rsltA2Qty
	 */
	public String getRsltA2Qty() {
		return this.rsltA2Qty;
	}
	
	/**
	 * Column Info
	 * @return apprS4Qty
	 */
	public String getApprS4Qty() {
		return this.apprS4Qty;
	}
	
	/**
	 * Column Info
	 * @return orderO2Qty
	 */
	public String getOrderO2Qty() {
		return this.orderO2Qty;
	}
	
	/**
	 * Column Info
	 * @return apprS2Qty
	 */
	public String getApprS2Qty() {
		return this.apprS2Qty;
	}
	
	/**
	 * Column Info
	 * @return rccCd
	 */
	public String getRccCd() {
		return this.rccCd;
	}
	
	/**
	 * Column Info
	 * @return apprF5Qty
	 */
	public String getApprF5Qty() {
		return this.apprF5Qty;
	}
	
	/**
	 * Column Info
	 * @return rsltO4Qty
	 */
	public String getRsltO4Qty() {
		return this.rsltO4Qty;
	}
	
	/**
	 * Column Info
	 * @return rsltO5Qty
	 */
	public String getRsltO5Qty() {
		return this.rsltO5Qty;
	}	
	
	/**
	 * Column Info
	 * @return orderS4Qty
	 */
	public String getOrderS4Qty() {
		return this.orderS4Qty;
	}
	
	/**
	 * Column Info
	 * @return apprA2Qty
	 */
	public String getApprA2Qty() {
		return this.apprA2Qty;
	}
	
	/**
	 * Column Info
	 * @return eqLstmCd
	 */
	public String getEqLstmCd() {
		return this.eqLstmCd;
	}
	
	/**
	 * Column Info
	 * @return lccCd
	 */
	public String getLccCd() {
		return this.lccCd;
	}
	
	/**
	 * Column Info
	 * @return apprO2Qty
	 */
	public String getApprO2Qty() {
		return this.apprO2Qty;
	}
	
	/**
	 * Column Info
	 * @return orderA4Qty
	 */
	public String getOrderA4Qty() {
		return this.orderA4Qty;
	}
	
	/**
	 * Column Info
	 * @return orderF5Qty
	 */
	public String getOrderF5Qty() {
		return this.orderF5Qty;
	}
	
	/**
	 * Column Info
	 * @return apprA4Qty
	 */
	public String getApprA4Qty() {
		return this.apprA4Qty;
	}
	
	/**
	 * Column Info
	 * @return rsltS4Qty
	 */
	public String getRsltS4Qty() {
		return this.rsltS4Qty;
	}
	
	/**
	 * Column Info
	 * @return apprO4Qty
	 */
	public String getApprO4Qty() {
		return this.apprO4Qty;
	}
	
	/**
	 * Column Info
	 * @return apprO5Qty
	 */
	public String getApprO5Qty() {
		return this.apprO5Qty;
	}	
	

	/**
	 * Column Info
	 * @param rsltO2Qty
	 */
	public void setRsltO2Qty(String rsltO2Qty) {
		this.rsltO2Qty = rsltO2Qty;
	}
	
	/**
	 * Column Info
	 * @param orderR9Qty
	 */
	public void setOrderR9Qty(String orderR9Qty) {
		this.orderR9Qty = orderR9Qty;
	}
	
	/**
	 * Column Info
	 * @param xMergeFlag
	 */
	public void setXMergeFlag(String xMergeFlag) {
		this.xMergeFlag = xMergeFlag;
	}
	
	/**
	 * Column Info
	 * @param orderO4Qty
	 */
	public void setOrderO4Qty(String orderO4Qty) {
		this.orderO4Qty = orderO4Qty;
	}
	
	/**
	 * Column Info
	 * @param orderO5Qty
	 */
	public void setOrderO5Qty(String orderO5Qty) {
		this.orderO5Qty = orderO5Qty;
	}	
	
	/**
	 * Column Info
	 * @param apprD5Qty
	 */
	public void setApprD5Qty(String apprD5Qty) {
		this.apprD5Qty = apprD5Qty;
	}
	
	/**
	 * Column Info
	 * @param rsltA4Qty
	 */
	public void setRsltA4Qty(String rsltA4Qty) {
		this.rsltA4Qty = rsltA4Qty;
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
	 * @param apprD4Qty
	 */
	public void setApprD4Qty(String apprD4Qty) {
		this.apprD4Qty = apprD4Qty;
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
	 * @param apprR2Qty
	 */
	public void setApprR2Qty(String apprR2Qty) {
		this.apprR2Qty = apprR2Qty;
	}
	
	/**
	 * Column Info
	 * @param apprF4Qty
	 */
	public void setApprF4Qty(String apprF4Qty) {
		this.apprF4Qty = apprF4Qty;
	}
	
	/**
	 * Column Info
	 * @param orderR5Qty
	 */
	public void setOrderR5Qty(String orderR5Qty) {
		this.orderR5Qty = orderR5Qty;
	}
	
	/**
	 * Column Info
	 * @param apprR9Qty
	 */
	public void setApprR9Qty(String apprR9Qty) {
		this.apprR9Qty = apprR9Qty;
	}
	
	/**
	 * Column Info
	 * @param period
	 */
	public void setPeriod(String period) {
		this.period = period;
	}
	
	/**
	 * Column Info
	 * @param orderD7Qty
	 */
	public void setOrderD7Qty(String orderD7Qty) {
		this.orderD7Qty = orderD7Qty;
	}
	
	/**
	 * Column Info
	 * @param apprR5Qty
	 */
	public void setApprR5Qty(String apprR5Qty) {
		this.apprR5Qty = apprR5Qty;
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
	 * @param rsltD5Qty
	 */
	public void setRsltD5Qty(String rsltD5Qty) {
		this.rsltD5Qty = rsltD5Qty;
	}
	
	/**
	 * Column Info
	 * @param years
	 */
	public void setYears(String years) {
		this.years = years;
	}
	
	/**
	 * Column Info
	 * @param orderF4Qty
	 */
	public void setOrderF4Qty(String orderF4Qty) {
		this.orderF4Qty = orderF4Qty;
	}
	
	/**
	 * Column Info
	 * @param rsltR2Qty
	 */
	public void setRsltR2Qty(String rsltR2Qty) {
		this.rsltR2Qty = rsltR2Qty;
	}
	
	/**
	 * Column Info
	 * @param rsltF4Qty
	 */
	public void setRsltF4Qty(String rsltF4Qty) {
		this.rsltF4Qty = rsltF4Qty;
	}
	
	/**
	 * Column Info
	 * @param onhOrdYr
	 */
	public void setOnhOrdYr(String onhOrdYr) {
		this.onhOrdYr = onhOrdYr;
	}
	
	/**
	 * Column Info
	 * @param orderD5Qty
	 */
	public void setOrderD5Qty(String orderD5Qty) {
		this.orderD5Qty = orderD5Qty;
	}
	
	/**
	 * Column Info
	 * @param orderD4Qty
	 */
	public void setOrderD4Qty(String orderD4Qty) {
		this.orderD4Qty = orderD4Qty;
	}
	
	/**
	 * Column Info
	 * @param rsltR9Qty
	 */
	public void setRsltR9Qty(String rsltR9Qty) {
		this.rsltR9Qty = rsltR9Qty;
	}
	
	/**
	 * Column Info
	 * @param apprD2Qty
	 */
	public void setApprD2Qty(String apprD2Qty) {
		this.apprD2Qty = apprD2Qty;
	}
	
	/**
	 * Column Info
	 * @param mergeFlag
	 */
	public void setMergeFlag(String mergeFlag) {
		this.mergeFlag = mergeFlag;
	}
	
	/**
	 * Column Info
	 * @param rsltF5Qty
	 */
	public void setRsltF5Qty(String rsltF5Qty) {
		this.rsltF5Qty = rsltF5Qty;
	}
	
	/**
	 * Column Info
	 * @param onhOrdRmk
	 */
	public void setOnhOrdRmk(String onhOrdRmk) {
		this.onhOrdRmk = onhOrdRmk;
	}
	
	/**
	 * Column Info
	 * @param orderD2Qty
	 */
	public void setOrderD2Qty(String orderD2Qty) {
		this.orderD2Qty = orderD2Qty;
	}
	
	/**
	 * Column Info
	 * @param orderA2Qty
	 */
	public void setOrderA2Qty(String orderA2Qty) {
		this.orderA2Qty = orderA2Qty;
	}
	
	/**
	 * Column Info
	 * @param rsltD7Qty
	 */
	public void setRsltD7Qty(String rsltD7Qty) {
		this.rsltD7Qty = rsltD7Qty;
	}
	
	/**
	 * Column Info
	 * @param lsePrdSeq
	 */
	public void setLsePrdSeq(String lsePrdSeq) {
		this.lsePrdSeq = lsePrdSeq;
	}
	
	/**
	 * Column Info
	 * @param rsltD2Qty
	 */
	public void setRsltD2Qty(String rsltD2Qty) {
		this.rsltD2Qty = rsltD2Qty;
	}
	
	/**
	 * Column Info
	 * @param orderS2Qty
	 */
	public void setOrderS2Qty(String orderS2Qty) {
		this.orderS2Qty = orderS2Qty;
	}
	
	/**
	 * Column Info
	 * @param apprF2Qty
	 */
	public void setApprF2Qty(String apprF2Qty) {
		this.apprF2Qty = apprF2Qty;
	}
	
	/**
	 * Column Info
	 * @param rsltS2Qty
	 */
	public void setRsltS2Qty(String rsltS2Qty) {
		this.rsltS2Qty = rsltS2Qty;
	}
	
	/**
	 * Column Info
	 * @param apprD7Qty
	 */
	public void setApprD7Qty(String apprD7Qty) {
		this.apprD7Qty = apprD7Qty;
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
	 * @param rsltF2Qty
	 */
	public void setRsltF2Qty(String rsltF2Qty) {
		this.rsltF2Qty = rsltF2Qty;
	}
	
	/**
	 * Column Info
	 * @param rsltD4Qty
	 */
	public void setRsltD4Qty(String rsltD4Qty) {
		this.rsltD4Qty = rsltD4Qty;
	}
	
	/**
	 * Column Info
	 * @param orderF2Qty
	 */
	public void setOrderF2Qty(String orderF2Qty) {
		this.orderF2Qty = orderF2Qty;
	}
	
	/**
	 * Column Info
	 * @param rsltR5Qty
	 */
	public void setRsltR5Qty(String rsltR5Qty) {
		this.rsltR5Qty = rsltR5Qty;
	}
	
	/**
	 * Column Info
	 * @param orderR2Qty
	 */
	public void setOrderR2Qty(String orderR2Qty) {
		this.orderR2Qty = orderR2Qty;
	}
	
	/**
	 * Column Info
	 * @param rsltA2Qty
	 */
	public void setRsltA2Qty(String rsltA2Qty) {
		this.rsltA2Qty = rsltA2Qty;
	}
	
	/**
	 * Column Info
	 * @param apprS4Qty
	 */
	public void setApprS4Qty(String apprS4Qty) {
		this.apprS4Qty = apprS4Qty;
	}
	
	/**
	 * Column Info
	 * @param orderO2Qty
	 */
	public void setOrderO2Qty(String orderO2Qty) {
		this.orderO2Qty = orderO2Qty;
	}
	
	/**
	 * Column Info
	 * @param apprS2Qty
	 */
	public void setApprS2Qty(String apprS2Qty) {
		this.apprS2Qty = apprS2Qty;
	}
	
	/**
	 * Column Info
	 * @param rccCd
	 */
	public void setRccCd(String rccCd) {
		this.rccCd = rccCd;
	}
	
	/**
	 * Column Info
	 * @param apprF5Qty
	 */
	public void setApprF5Qty(String apprF5Qty) {
		this.apprF5Qty = apprF5Qty;
	}
	
	/**
	 * Column Info
	 * @param rsltO4Qty
	 */
	public void setRsltO4Qty(String rsltO4Qty) {
		this.rsltO4Qty = rsltO4Qty;
	}
	
	/**
	 * Column Info
	 * @param rsltO5Qty
	 */
	public void setRsltO5Qty(String rsltO5Qty) {
		this.rsltO5Qty = rsltO5Qty;
	}	
	
	/**
	 * Column Info
	 * @param orderS4Qty
	 */
	public void setOrderS4Qty(String orderS4Qty) {
		this.orderS4Qty = orderS4Qty;
	}
	
	/**
	 * Column Info
	 * @param apprA2Qty
	 */
	public void setApprA2Qty(String apprA2Qty) {
		this.apprA2Qty = apprA2Qty;
	}
	
	/**
	 * Column Info
	 * @param eqLstmCd
	 */
	public void setEqLstmCd(String eqLstmCd) {
		this.eqLstmCd = eqLstmCd;
	}
	
	/**
	 * Column Info
	 * @param lccCd
	 */
	public void setLccCd(String lccCd) {
		this.lccCd = lccCd;
	}
	
	/**
	 * Column Info
	 * @param apprO2Qty
	 */
	public void setApprO2Qty(String apprO2Qty) {
		this.apprO2Qty = apprO2Qty;
	}
	
	/**
	 * Column Info
	 * @param orderA4Qty
	 */
	public void setOrderA4Qty(String orderA4Qty) {
		this.orderA4Qty = orderA4Qty;
	}
	
	/**
	 * Column Info
	 * @param orderF5Qty
	 */
	public void setOrderF5Qty(String orderF5Qty) {
		this.orderF5Qty = orderF5Qty;
	}
	
	/**
	 * Column Info
	 * @param apprA4Qty
	 */
	public void setApprA4Qty(String apprA4Qty) {
		this.apprA4Qty = apprA4Qty;
	}
	
	/**
	 * Column Info
	 * @param rsltS4Qty
	 */
	public void setRsltS4Qty(String rsltS4Qty) {
		this.rsltS4Qty = rsltS4Qty;
	}
	
	/**
	 * Column Info
	 * @param apprO4Qty
	 */
	public void setApprO4Qty(String apprO4Qty) {
		this.apprO4Qty = apprO4Qty;
	}
	
	/**
	 * Column Info
	 * @param apprO5Qty
	 */
	public void setApprO5Qty(String apprO5Qty) {
		this.apprO5Qty = apprO5Qty;
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
		setRsltO2Qty(JSPUtil.getParameter(request, prefix + "rslt_o2_qty", ""));
		setOrderR9Qty(JSPUtil.getParameter(request, prefix + "order_r9_qty", ""));
		setXMergeFlag(JSPUtil.getParameter(request, prefix + "x_merge_flag", ""));
		setOrderO4Qty(JSPUtil.getParameter(request, prefix + "order_o4_qty", ""));
		setOrderO5Qty(JSPUtil.getParameter(request, prefix + "order_o5_qty", ""));		
		setApprD5Qty(JSPUtil.getParameter(request, prefix + "appr_d5_qty", ""));
		setRsltA4Qty(JSPUtil.getParameter(request, prefix + "rslt_a4_qty", ""));
		setRsltA5Qty(JSPUtil.getParameter(request, prefix + "rslt_a5_qty", ""));		
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setApprD4Qty(JSPUtil.getParameter(request, prefix + "appr_d4_qty", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setApprR2Qty(JSPUtil.getParameter(request, prefix + "appr_r2_qty", ""));
		setApprF4Qty(JSPUtil.getParameter(request, prefix + "appr_f4_qty", ""));
		setOrderR5Qty(JSPUtil.getParameter(request, prefix + "order_r5_qty", ""));
		setApprR9Qty(JSPUtil.getParameter(request, prefix + "appr_r9_qty", ""));
		setPeriod(JSPUtil.getParameter(request, prefix + "period", ""));
		setOrderD7Qty(JSPUtil.getParameter(request, prefix + "order_d7_qty", ""));
		setApprR5Qty(JSPUtil.getParameter(request, prefix + "appr_r5_qty", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setRsltD5Qty(JSPUtil.getParameter(request, prefix + "rslt_d5_qty", ""));
		setYears(JSPUtil.getParameter(request, prefix + "years", ""));
		setOrderF4Qty(JSPUtil.getParameter(request, prefix + "order_f4_qty", ""));
		setRsltR2Qty(JSPUtil.getParameter(request, prefix + "rslt_r2_qty", ""));
		setRsltF4Qty(JSPUtil.getParameter(request, prefix + "rslt_f4_qty", ""));
		setOnhOrdYr(JSPUtil.getParameter(request, prefix + "onh_ord_yr", ""));
		setOrderD5Qty(JSPUtil.getParameter(request, prefix + "order_d5_qty", ""));
		setOrderD4Qty(JSPUtil.getParameter(request, prefix + "order_d4_qty", ""));
		setRsltR9Qty(JSPUtil.getParameter(request, prefix + "rslt_r9_qty", ""));
		setApprD2Qty(JSPUtil.getParameter(request, prefix + "appr_d2_qty", ""));
		setMergeFlag(JSPUtil.getParameter(request, prefix + "merge_flag", ""));
		setRsltF5Qty(JSPUtil.getParameter(request, prefix + "rslt_f5_qty", ""));
		setOnhOrdRmk(JSPUtil.getParameter(request, prefix + "onh_ord_rmk", ""));
		setOrderD2Qty(JSPUtil.getParameter(request, prefix + "order_d2_qty", ""));
		setOrderA2Qty(JSPUtil.getParameter(request, prefix + "order_a2_qty", ""));
		setRsltD7Qty(JSPUtil.getParameter(request, prefix + "rslt_d7_qty", ""));
		setLsePrdSeq(JSPUtil.getParameter(request, prefix + "lse_prd_seq", ""));
		setRsltD2Qty(JSPUtil.getParameter(request, prefix + "rslt_d2_qty", ""));
		setOrderS2Qty(JSPUtil.getParameter(request, prefix + "order_s2_qty", ""));
		setApprF2Qty(JSPUtil.getParameter(request, prefix + "appr_f2_qty", ""));
		setRsltS2Qty(JSPUtil.getParameter(request, prefix + "rslt_s2_qty", ""));
		setApprD7Qty(JSPUtil.getParameter(request, prefix + "appr_d7_qty", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRsltF2Qty(JSPUtil.getParameter(request, prefix + "rslt_f2_qty", ""));
		setRsltD4Qty(JSPUtil.getParameter(request, prefix + "rslt_d4_qty", ""));
		setOrderF2Qty(JSPUtil.getParameter(request, prefix + "order_f2_qty", ""));
		setRsltR5Qty(JSPUtil.getParameter(request, prefix + "rslt_r5_qty", ""));
		setOrderR2Qty(JSPUtil.getParameter(request, prefix + "order_r2_qty", ""));
		setRsltA2Qty(JSPUtil.getParameter(request, prefix + "rslt_a2_qty", ""));
		setApprS4Qty(JSPUtil.getParameter(request, prefix + "appr_s4_qty", ""));
		setOrderO2Qty(JSPUtil.getParameter(request, prefix + "order_o2_qty", ""));
		setApprS2Qty(JSPUtil.getParameter(request, prefix + "appr_s2_qty", ""));
		setRccCd(JSPUtil.getParameter(request, prefix + "rcc_cd", ""));
		setApprF5Qty(JSPUtil.getParameter(request, prefix + "appr_f5_qty", ""));
		setRsltO4Qty(JSPUtil.getParameter(request, prefix + "rslt_o4_qty", ""));
		setRsltO5Qty(JSPUtil.getParameter(request, prefix + "rslt_o5_qty", ""));		
		setOrderS4Qty(JSPUtil.getParameter(request, prefix + "order_s4_qty", ""));
		setApprA2Qty(JSPUtil.getParameter(request, prefix + "appr_a2_qty", ""));
		setEqLstmCd(JSPUtil.getParameter(request, prefix + "eq_lstm_cd", ""));
		setLccCd(JSPUtil.getParameter(request, prefix + "lcc_cd", ""));
		setApprO2Qty(JSPUtil.getParameter(request, prefix + "appr_o2_qty", ""));
		setOrderA4Qty(JSPUtil.getParameter(request, prefix + "order_a4_qty", ""));
		setOrderA5Qty(JSPUtil.getParameter(request, prefix + "order_a5_qty", ""));		
		setOrderF5Qty(JSPUtil.getParameter(request, prefix + "order_f5_qty", ""));
		setApprA4Qty(JSPUtil.getParameter(request, prefix + "appr_a4_qty", ""));
		setApprA5Qty(JSPUtil.getParameter(request, prefix + "appr_a5_qty", ""));		
		setRsltS4Qty(JSPUtil.getParameter(request, prefix + "rslt_s4_qty", ""));
		setApprO4Qty(JSPUtil.getParameter(request, prefix + "appr_o4_qty", ""));
		setApprO5Qty(JSPUtil.getParameter(request, prefix + "appr_o5_qty", ""));		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OnhireStatusVO[]
	 */
	public OnhireStatusVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OnhireStatusVO[]
	 */
	public OnhireStatusVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OnhireStatusVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rsltO2Qty = (JSPUtil.getParameter(request, prefix	+ "rslt_o2_qty", length));
			String[] orderR9Qty = (JSPUtil.getParameter(request, prefix	+ "order_r9_qty", length));
			String[] xMergeFlag = (JSPUtil.getParameter(request, prefix	+ "x_merge_flag", length));
			String[] orderO4Qty = (JSPUtil.getParameter(request, prefix	+ "order_o4_qty", length));
			String[] orderO5Qty = (JSPUtil.getParameter(request, prefix	+ "order_o5_qty", length));
			String[] apprD5Qty = (JSPUtil.getParameter(request, prefix	+ "appr_d5_qty", length));
			String[] rsltA4Qty = (JSPUtil.getParameter(request, prefix	+ "rslt_a4_qty", length));
			String[] rsltA5Qty = (JSPUtil.getParameter(request, prefix	+ "rslt_a5_qty", length));			
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] apprD4Qty = (JSPUtil.getParameter(request, prefix	+ "appr_d4_qty", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] apprR2Qty = (JSPUtil.getParameter(request, prefix	+ "appr_r2_qty", length));
			String[] apprF4Qty = (JSPUtil.getParameter(request, prefix	+ "appr_f4_qty", length));
			String[] orderR5Qty = (JSPUtil.getParameter(request, prefix	+ "order_r5_qty", length));
			String[] apprR9Qty = (JSPUtil.getParameter(request, prefix	+ "appr_r9_qty", length));
			String[] period = (JSPUtil.getParameter(request, prefix	+ "period", length));
			String[] orderD7Qty = (JSPUtil.getParameter(request, prefix	+ "order_d7_qty", length));
			String[] apprR5Qty = (JSPUtil.getParameter(request, prefix	+ "appr_r5_qty", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] rsltD5Qty = (JSPUtil.getParameter(request, prefix	+ "rslt_d5_qty", length));
			String[] years = (JSPUtil.getParameter(request, prefix	+ "years", length));
			String[] orderF4Qty = (JSPUtil.getParameter(request, prefix	+ "order_f4_qty", length));
			String[] rsltR2Qty = (JSPUtil.getParameter(request, prefix	+ "rslt_r2_qty", length));
			String[] rsltF4Qty = (JSPUtil.getParameter(request, prefix	+ "rslt_f4_qty", length));
			String[] onhOrdYr = (JSPUtil.getParameter(request, prefix	+ "onh_ord_yr", length));
			String[] orderD5Qty = (JSPUtil.getParameter(request, prefix	+ "order_d5_qty", length));
			String[] orderD4Qty = (JSPUtil.getParameter(request, prefix	+ "order_d4_qty", length));
			String[] rsltR9Qty = (JSPUtil.getParameter(request, prefix	+ "rslt_r9_qty", length));
			String[] apprD2Qty = (JSPUtil.getParameter(request, prefix	+ "appr_d2_qty", length));
			String[] mergeFlag = (JSPUtil.getParameter(request, prefix	+ "merge_flag", length));
			String[] rsltF5Qty = (JSPUtil.getParameter(request, prefix	+ "rslt_f5_qty", length));
			String[] onhOrdRmk = (JSPUtil.getParameter(request, prefix	+ "onh_ord_rmk", length));
			String[] orderD2Qty = (JSPUtil.getParameter(request, prefix	+ "order_d2_qty", length));
			String[] orderA2Qty = (JSPUtil.getParameter(request, prefix	+ "order_a2_qty", length));
			String[] rsltD7Qty = (JSPUtil.getParameter(request, prefix	+ "rslt_d7_qty", length));
			String[] lsePrdSeq = (JSPUtil.getParameter(request, prefix	+ "lse_prd_seq", length));
			String[] rsltD2Qty = (JSPUtil.getParameter(request, prefix	+ "rslt_d2_qty", length));
			String[] orderS2Qty = (JSPUtil.getParameter(request, prefix	+ "order_s2_qty", length));
			String[] apprF2Qty = (JSPUtil.getParameter(request, prefix	+ "appr_f2_qty", length));
			String[] rsltS2Qty = (JSPUtil.getParameter(request, prefix	+ "rslt_s2_qty", length));
			String[] apprD7Qty = (JSPUtil.getParameter(request, prefix	+ "appr_d7_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rsltF2Qty = (JSPUtil.getParameter(request, prefix	+ "rslt_f2_qty", length));
			String[] rsltD4Qty = (JSPUtil.getParameter(request, prefix	+ "rslt_d4_qty", length));
			String[] orderF2Qty = (JSPUtil.getParameter(request, prefix	+ "order_f2_qty", length));
			String[] rsltR5Qty = (JSPUtil.getParameter(request, prefix	+ "rslt_r5_qty", length));
			String[] orderR2Qty = (JSPUtil.getParameter(request, prefix	+ "order_r2_qty", length));
			String[] rsltA2Qty = (JSPUtil.getParameter(request, prefix	+ "rslt_a2_qty", length));
			String[] apprS4Qty = (JSPUtil.getParameter(request, prefix	+ "appr_s4_qty", length));
			String[] orderO2Qty = (JSPUtil.getParameter(request, prefix	+ "order_o2_qty", length));
			String[] apprS2Qty = (JSPUtil.getParameter(request, prefix	+ "appr_s2_qty", length));
			String[] rccCd = (JSPUtil.getParameter(request, prefix	+ "rcc_cd", length));
			String[] apprF5Qty = (JSPUtil.getParameter(request, prefix	+ "appr_f5_qty", length));
			String[] rsltO4Qty = (JSPUtil.getParameter(request, prefix	+ "rslt_o4_qty", length));
			String[] rsltO5Qty = (JSPUtil.getParameter(request, prefix	+ "rslt_o5_qty", length));
			String[] orderS4Qty = (JSPUtil.getParameter(request, prefix	+ "order_s4_qty", length));
			String[] apprA2Qty = (JSPUtil.getParameter(request, prefix	+ "appr_a2_qty", length));
			String[] eqLstmCd = (JSPUtil.getParameter(request, prefix	+ "eq_lstm_cd", length));
			String[] lccCd = (JSPUtil.getParameter(request, prefix	+ "lcc_cd", length));
			String[] apprO2Qty = (JSPUtil.getParameter(request, prefix	+ "appr_o2_qty", length));
			String[] orderA4Qty = (JSPUtil.getParameter(request, prefix	+ "order_a4_qty", length));
			String[] orderA5Qty = (JSPUtil.getParameter(request, prefix	+ "order_a5_qty", length));			
			String[] orderF5Qty = (JSPUtil.getParameter(request, prefix	+ "order_f5_qty", length));
			String[] apprA4Qty = (JSPUtil.getParameter(request, prefix	+ "appr_a4_qty", length));
			String[] apprA5Qty = (JSPUtil.getParameter(request, prefix	+ "appr_a5_qty", length));			
			String[] rsltS4Qty = (JSPUtil.getParameter(request, prefix	+ "rslt_s4_qty", length));
			String[] apprO4Qty = (JSPUtil.getParameter(request, prefix	+ "appr_o4_qty", length));
			String[] apprO5Qty = (JSPUtil.getParameter(request, prefix	+ "appr_o5_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new OnhireStatusVO();
				if (rsltO2Qty[i] != null)
					model.setRsltO2Qty(rsltO2Qty[i]);
				if (orderR9Qty[i] != null)
					model.setOrderR9Qty(orderR9Qty[i]);
				if (xMergeFlag[i] != null)
					model.setXMergeFlag(xMergeFlag[i]);
				if (orderO4Qty[i] != null)
					model.setOrderO4Qty(orderO4Qty[i]);
				if (orderO5Qty[i] != null)
					model.setOrderO5Qty(orderO5Qty[i]);
				if (apprD5Qty[i] != null)
					model.setApprD5Qty(apprD5Qty[i]);
				if (rsltA4Qty[i] != null)
					model.setRsltA4Qty(rsltA4Qty[i]);
				if (rsltA5Qty[i] != null)
					model.setRsltA5Qty(rsltA5Qty[i]);				
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (apprD4Qty[i] != null)
					model.setApprD4Qty(apprD4Qty[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (apprR2Qty[i] != null)
					model.setApprR2Qty(apprR2Qty[i]);
				if (apprF4Qty[i] != null)
					model.setApprF4Qty(apprF4Qty[i]);
				if (orderR5Qty[i] != null)
					model.setOrderR5Qty(orderR5Qty[i]);
				if (apprR9Qty[i] != null)
					model.setApprR9Qty(apprR9Qty[i]);
				if (period[i] != null)
					model.setPeriod(period[i]);
				if (orderD7Qty[i] != null)
					model.setOrderD7Qty(orderD7Qty[i]);
				if (apprR5Qty[i] != null)
					model.setApprR5Qty(apprR5Qty[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (rsltD5Qty[i] != null)
					model.setRsltD5Qty(rsltD5Qty[i]);
				if (years[i] != null)
					model.setYears(years[i]);
				if (orderF4Qty[i] != null)
					model.setOrderF4Qty(orderF4Qty[i]);
				if (rsltR2Qty[i] != null)
					model.setRsltR2Qty(rsltR2Qty[i]);
				if (rsltF4Qty[i] != null)
					model.setRsltF4Qty(rsltF4Qty[i]);
				if (onhOrdYr[i] != null)
					model.setOnhOrdYr(onhOrdYr[i]);
				if (orderD5Qty[i] != null)
					model.setOrderD5Qty(orderD5Qty[i]);
				if (orderD4Qty[i] != null)
					model.setOrderD4Qty(orderD4Qty[i]);
				if (rsltR9Qty[i] != null)
					model.setRsltR9Qty(rsltR9Qty[i]);
				if (apprD2Qty[i] != null)
					model.setApprD2Qty(apprD2Qty[i]);
				if (mergeFlag[i] != null)
					model.setMergeFlag(mergeFlag[i]);
				if (rsltF5Qty[i] != null)
					model.setRsltF5Qty(rsltF5Qty[i]);
				if (onhOrdRmk[i] != null)
					model.setOnhOrdRmk(onhOrdRmk[i]);
				if (orderD2Qty[i] != null)
					model.setOrderD2Qty(orderD2Qty[i]);
				if (orderA2Qty[i] != null)
					model.setOrderA2Qty(orderA2Qty[i]);
				if (rsltD7Qty[i] != null)
					model.setRsltD7Qty(rsltD7Qty[i]);
				if (lsePrdSeq[i] != null)
					model.setLsePrdSeq(lsePrdSeq[i]);
				if (rsltD2Qty[i] != null)
					model.setRsltD2Qty(rsltD2Qty[i]);
				if (orderS2Qty[i] != null)
					model.setOrderS2Qty(orderS2Qty[i]);
				if (apprF2Qty[i] != null)
					model.setApprF2Qty(apprF2Qty[i]);
				if (rsltS2Qty[i] != null)
					model.setRsltS2Qty(rsltS2Qty[i]);
				if (apprD7Qty[i] != null)
					model.setApprD7Qty(apprD7Qty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rsltF2Qty[i] != null)
					model.setRsltF2Qty(rsltF2Qty[i]);
				if (rsltD4Qty[i] != null)
					model.setRsltD4Qty(rsltD4Qty[i]);
				if (orderF2Qty[i] != null)
					model.setOrderF2Qty(orderF2Qty[i]);
				if (rsltR5Qty[i] != null)
					model.setRsltR5Qty(rsltR5Qty[i]);
				if (orderR2Qty[i] != null)
					model.setOrderR2Qty(orderR2Qty[i]);
				if (rsltA2Qty[i] != null)
					model.setRsltA2Qty(rsltA2Qty[i]);
				if (apprS4Qty[i] != null)
					model.setApprS4Qty(apprS4Qty[i]);
				if (orderO2Qty[i] != null)
					model.setOrderO2Qty(orderO2Qty[i]);
				if (apprS2Qty[i] != null)
					model.setApprS2Qty(apprS2Qty[i]);
				if (rccCd[i] != null)
					model.setRccCd(rccCd[i]);
				if (apprF5Qty[i] != null)
					model.setApprF5Qty(apprF5Qty[i]);
				if (rsltO4Qty[i] != null)
					model.setRsltO4Qty(rsltO4Qty[i]);
				if (rsltO5Qty[i] != null)
					model.setRsltO5Qty(rsltO5Qty[i]);
				if (orderS4Qty[i] != null)
					model.setOrderS4Qty(orderS4Qty[i]);
				if (apprA2Qty[i] != null)
					model.setApprA2Qty(apprA2Qty[i]);
				if (eqLstmCd[i] != null)
					model.setEqLstmCd(eqLstmCd[i]);
				if (lccCd[i] != null)
					model.setLccCd(lccCd[i]);
				if (apprO2Qty[i] != null)
					model.setApprO2Qty(apprO2Qty[i]);
				if (orderA4Qty[i] != null)
					model.setOrderA4Qty(orderA4Qty[i]);
				if (orderA5Qty[i] != null)
					model.setOrderA5Qty(orderA5Qty[i]);				
				if (orderF5Qty[i] != null)
					model.setOrderF5Qty(orderF5Qty[i]);
				if (apprA4Qty[i] != null)
					model.setApprA4Qty(apprA4Qty[i]);
				if (apprA5Qty[i] != null)
					model.setApprA5Qty(apprA5Qty[i]);				
				if (rsltS4Qty[i] != null)
					model.setRsltS4Qty(rsltS4Qty[i]);
				if (apprO4Qty[i] != null)
					model.setApprO4Qty(apprO4Qty[i]);
				if (apprO5Qty[i] != null)
					model.setApprO5Qty(apprO5Qty[i]);				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOnhireStatusVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OnhireStatusVO[]
	 */
	public OnhireStatusVO[] getOnhireStatusVOs(){
		OnhireStatusVO[] vos = (OnhireStatusVO[])models.toArray(new OnhireStatusVO[models.size()]);
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
		this.rsltO2Qty = this.rsltO2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orderR9Qty = this.orderR9Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xMergeFlag = this.xMergeFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orderO4Qty = this.orderO4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orderO5Qty = this.orderO5Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apprD5Qty = this.apprD5Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltA4Qty = this.rsltA4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltA5Qty = this.rsltA5Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apprD4Qty = this.apprD4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apprR2Qty = this.apprR2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apprF4Qty = this.apprF4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orderR5Qty = this.orderR5Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apprR9Qty = this.apprR9Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.period = this.period .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orderD7Qty = this.orderD7Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apprR5Qty = this.apprR5Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltD5Qty = this.rsltD5Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.years = this.years .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orderF4Qty = this.orderF4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltR2Qty = this.rsltR2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltF4Qty = this.rsltF4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhOrdYr = this.onhOrdYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orderD5Qty = this.orderD5Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orderD4Qty = this.orderD4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltR9Qty = this.rsltR9Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apprD2Qty = this.apprD2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mergeFlag = this.mergeFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltF5Qty = this.rsltF5Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhOrdRmk = this.onhOrdRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orderD2Qty = this.orderD2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orderA2Qty = this.orderA2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltD7Qty = this.rsltD7Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsePrdSeq = this.lsePrdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltD2Qty = this.rsltD2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orderS2Qty = this.orderS2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apprF2Qty = this.apprF2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltS2Qty = this.rsltS2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apprD7Qty = this.apprD7Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltF2Qty = this.rsltF2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltD4Qty = this.rsltD4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orderF2Qty = this.orderF2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltR5Qty = this.rsltR5Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orderR2Qty = this.orderR2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltA2Qty = this.rsltA2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apprS4Qty = this.apprS4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orderO2Qty = this.orderO2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apprS2Qty = this.apprS2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd = this.rccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apprF5Qty = this.apprF5Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltO4Qty = this.rsltO4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltO5Qty = this.rsltO5Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orderS4Qty = this.orderS4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apprA2Qty = this.apprA2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqLstmCd = this.eqLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lccCd = this.lccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apprO2Qty = this.apprO2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orderA4Qty = this.orderA4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orderA5Qty = this.orderA5Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.orderF5Qty = this.orderF5Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apprA4Qty = this.apprA4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apprA5Qty = this.apprA5Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltS4Qty = this.rsltS4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apprO4Qty = this.apprO4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apprO5Qty = this.apprO5Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	public String getRsltA5Qty() {
		return rsltA5Qty;
	}

	public void setRsltA5Qty(String rsltA5Qty) {
		this.rsltA5Qty = rsltA5Qty;
	}

	public String getOrderA5Qty() {
		return orderA5Qty;
	}

	public void setOrderA5Qty(String orderA5Qty) {
		this.orderA5Qty = orderA5Qty;
	}

	public String getApprA5Qty() {
		return apprA5Qty;
	}

	public void setApprA5Qty(String apprA5Qty) {
		this.apprA5Qty = apprA5Qty;
	}
}
