/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : YearlyCollectionByRHQVO.java
*@FileTitle : YearlyCollectionByRHQVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.10
*@LastModifier : 
*@LastVersion : 1.0
* 2013.12.10  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class YearlyCollectionByRHQVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<YearlyCollectionByRHQVO> models = new ArrayList<YearlyCollectionByRHQVO>();
	
	/* Column Info */
	private String g030ExptAmt = null;
	/* Column Info */
	private String g181BillQty = null;
	/* Column Info */
	private String g180ExptQty = null;
	/* Column Info */
	private String g181IncrQty = null;
	/* Column Info */
	private String g180BillAmt = null;
	/* Column Info */
	private String g090IncrAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String g090DcntQty = null;
	/* Column Info */
	private String g060BillQty = null;
	/* Column Info */
	private String g090DcntAmt = null;
	/* Column Info */
	private String g181DcntQty = null;
	/* Column Info */
	private String dmdtTrfCd = null;

	/* Column Info */
	private String bzcTrfCurrCd = null;

	/* Column Info */
	private String trfCdList = null;
	/* Column Info */
	private String g060IncrAmt = null;
	/* Column Info */
	private String g030IncrAmt = null;
	/* Column Info */
	private String g060DcntQty = null;
	/* Column Info */
	private String g090ExptAmt = null;
	/* Column Info */
	private String g090IncrQty = null;
	/* Column Info */
	private String g180IncrAmt = null;
	/* Column Info */
	private String g090BillQty = null;
	/* Column Info */
	private String ofcCdList = null;
	/* Column Info */
	private String g180ExptAmt = null;
	/* Column Info */
	private String grpFlg = null;
	/* Column Info */
	private String g060ExptAmt = null;
	/* Column Info */
	private String cntrTpList = null;
	/* Column Info */
	private String fYear = null;
	/* Column Info */
	private String g030BillAmt = null;
	/* Column Info */
	private String g180DcntQty = null;
	/* Column Info */
	private String g030DcntQty = null;
	/* Column Info */
	private String backendjobKey = null;
	/* Column Info */
	private String currFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String g180IncrQty = null;
	/* Column Info */
	private String g060DcntAmt = null;
	/* Column Info */
	private String g090BillAmt = null;
	/* Column Info */
	private String g180BillQty = null;
	/* Column Info */
	private String g060IncrQty = null;
	/* Column Info */
	private String g180DcntAmt = null;
	/* Column Info */
	private String g030ExptQty = null;
	/* Column Info */
	private String uclmFlg = null;
	/* Column Info */
	private String g030DcntAmt = null;
	/* Column Info */
	private String g181ExptQty = null;
	/* Column Info */
	private String ofcRhqCd = null;
	/* Column Info */
	private String g060BillAmt = null;
	/* Column Info */
	private String g181DcntAmt = null;
	/* Column Info */
	private String g030BillQty = null;
	/* Column Info */
	private String dmdtCntrTpCd = null;
	/* Column Info */
	private String g030IncrQty = null;
	/* Column Info */
	private String g181BillAmt = null;
	/* Column Info */
	private String ofcFlg = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String g181ExptAmt = null;
	/* Column Info */
	private String g090ExptQty = null;
	/* Column Info */
	private String backendjobId = null;
	/* Column Info */
	private String g060ExptQty = null;
	/* Column Info */
	private String g181IncrAmt = null;
	/* Column Info */
	private String g015IncrQty = null;
	/* Column Info */
	private String g015IncrAmt = null;
	/* Column Info */
	private String g015ExptQty = null;
	/* Column Info */
	private String g015ExptAmt = null;
	/* Column Info */
	private String g015DcntQty = null;
	/* Column Info */
	private String g015DcntAmt = null;
	/* Column Info */
	private String g015BillQty = null;
	/* Column Info */
	private String g015BillAmt = null;
	/* Column Info */
	private String status = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public YearlyCollectionByRHQVO() {}

	public YearlyCollectionByRHQVO(String ibflag, String pagerows, String backendjobKey, String backendjobId, String ofcCd, String ofcRhqCd, String ofcCdList, String ofcFlg, String fYear, String grpFlg, String currFlg, String uclmFlg, String dmdtTrfCd, String trfCdList, String dmdtCntrTpCd, String cntrTpList, String g030IncrQty, String g030IncrAmt, String g030ExptQty, String g030ExptAmt, String g030DcntQty, String g030DcntAmt, String g030BillQty, String g030BillAmt, String g060IncrQty, String g060IncrAmt, String g060ExptQty, String g060ExptAmt, String g060DcntQty, String g060DcntAmt, String g060BillQty, String g060BillAmt, String g090IncrQty, String g090IncrAmt, String g090ExptQty, String g090ExptAmt, String g090DcntQty, String g090DcntAmt, String g090BillQty, String g090BillAmt, String g180IncrQty, String g180IncrAmt, String g180ExptQty, String g180ExptAmt, String g180DcntQty, String g180DcntAmt, String g180BillQty, String g180BillAmt, String g181IncrQty, String g181IncrAmt, String g181ExptQty, String g181ExptAmt, String g181DcntQty, String g181DcntAmt, String g181BillQty, String g181BillAmt, String g015IncrQty, String g015IncrAmt, String g015ExptQty, String g015ExptAmt, String g015DcntQty, String g015DcntAmt, String g015BillQty, String g015BillAmt, String status, String bzcTrfCurrCd) {
		this.g030ExptAmt = g030ExptAmt;
		this.g181BillQty = g181BillQty;
		this.g180ExptQty = g180ExptQty;
		this.g181IncrQty = g181IncrQty;
		this.g180BillAmt = g180BillAmt;
		this.g090IncrAmt = g090IncrAmt;
		this.pagerows = pagerows;
		this.g090DcntQty = g090DcntQty;
		this.g060BillQty = g060BillQty;
		this.g090DcntAmt = g090DcntAmt;
		this.g181DcntQty = g181DcntQty;
		this.dmdtTrfCd = dmdtTrfCd;
		this.bzcTrfCurrCd = bzcTrfCurrCd;
		this.trfCdList = trfCdList;
		this.g060IncrAmt = g060IncrAmt;
		this.g030IncrAmt = g030IncrAmt;
		this.g060DcntQty = g060DcntQty;
		this.g090ExptAmt = g090ExptAmt;
		this.g090IncrQty = g090IncrQty;
		this.g180IncrAmt = g180IncrAmt;
		this.g090BillQty = g090BillQty;
		this.ofcCdList = ofcCdList;
		this.g180ExptAmt = g180ExptAmt;
		this.grpFlg = grpFlg;
		this.g060ExptAmt = g060ExptAmt;
		this.cntrTpList = cntrTpList;
		this.fYear = fYear;
		this.g030BillAmt = g030BillAmt;
		this.g180DcntQty = g180DcntQty;
		this.g030DcntQty = g030DcntQty;
		this.backendjobKey = backendjobKey;
		this.currFlg = currFlg;
		this.ibflag = ibflag;
		this.g180IncrQty = g180IncrQty;
		this.g060DcntAmt = g060DcntAmt;
		this.g090BillAmt = g090BillAmt;
		this.g180BillQty = g180BillQty;
		this.g060IncrQty = g060IncrQty;
		this.g180DcntAmt = g180DcntAmt;
		this.g030ExptQty = g030ExptQty;
		this.uclmFlg = uclmFlg;
		this.g030DcntAmt = g030DcntAmt;
		this.g181ExptQty = g181ExptQty;
		this.ofcRhqCd = ofcRhqCd;
		this.g060BillAmt = g060BillAmt;
		this.g181DcntAmt = g181DcntAmt;
		this.g030BillQty = g030BillQty;
		this.dmdtCntrTpCd = dmdtCntrTpCd;
		this.g030IncrQty = g030IncrQty;
		this.g181BillAmt = g181BillAmt;
		this.ofcFlg = ofcFlg;
		this.ofcCd = ofcCd;
		this.g181ExptAmt = g181ExptAmt;
		this.g090ExptQty = g090ExptQty;
		this.backendjobId = backendjobId;
		this.g060ExptQty = g060ExptQty;
		this.g181IncrAmt = g181IncrAmt;
		this.g015IncrQty = g015IncrQty;
		this.g015IncrAmt = g015IncrAmt;
		this.g015ExptQty = g015ExptQty;
		this.g015ExptAmt = g015ExptAmt;
		this.g015DcntQty = g015DcntQty;
		this.g015DcntAmt = g015DcntAmt;
		this.g015BillQty = g015BillQty;
		this.g015BillAmt = g015BillAmt;
		this.status = status;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("g030_expt_amt", getG030ExptAmt());
		this.hashColumns.put("g181_bill_qty", getG181BillQty());
		this.hashColumns.put("g180_expt_qty", getG180ExptQty());
		this.hashColumns.put("g181_incr_qty", getG181IncrQty());
		this.hashColumns.put("g180_bill_amt", getG180BillAmt());
		this.hashColumns.put("g090_incr_amt", getG090IncrAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("g090_dcnt_qty", getG090DcntQty());
		this.hashColumns.put("g060_bill_qty", getG060BillQty());
		this.hashColumns.put("g090_dcnt_amt", getG090DcntAmt());
		this.hashColumns.put("g181_dcnt_qty", getG181DcntQty());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("trf_cd_list", getTrfCdList());
		
		this.hashColumns.put("bzc_trf_curr_cd", getBzcTrfCurrCd());
		
		this.hashColumns.put("g060_incr_amt", getG060IncrAmt());
		this.hashColumns.put("g030_incr_amt", getG030IncrAmt());
		this.hashColumns.put("g060_dcnt_qty", getG060DcntQty());
		this.hashColumns.put("g090_expt_amt", getG090ExptAmt());
		this.hashColumns.put("g090_incr_qty", getG090IncrQty());
		this.hashColumns.put("g180_incr_amt", getG180IncrAmt());
		this.hashColumns.put("g090_bill_qty", getG090BillQty());
		this.hashColumns.put("ofc_cd_list", getOfcCdList());
		this.hashColumns.put("g180_expt_amt", getG180ExptAmt());
		this.hashColumns.put("grp_flg", getGrpFlg());
		this.hashColumns.put("g060_expt_amt", getG060ExptAmt());
		this.hashColumns.put("cntr_tp_list", getCntrTpList());
		this.hashColumns.put("f_year", getFYear());
		this.hashColumns.put("g030_bill_amt", getG030BillAmt());
		this.hashColumns.put("g180_dcnt_qty", getG180DcntQty());
		this.hashColumns.put("g030_dcnt_qty", getG030DcntQty());
		this.hashColumns.put("backendjob_key", getBackendjobKey());
		this.hashColumns.put("curr_flg", getCurrFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("g180_incr_qty", getG180IncrQty());
		this.hashColumns.put("g060_dcnt_amt", getG060DcntAmt());
		this.hashColumns.put("g090_bill_amt", getG090BillAmt());
		this.hashColumns.put("g180_bill_qty", getG180BillQty());
		this.hashColumns.put("g060_incr_qty", getG060IncrQty());
		this.hashColumns.put("g180_dcnt_amt", getG180DcntAmt());
		this.hashColumns.put("g030_expt_qty", getG030ExptQty());
		this.hashColumns.put("uclm_flg", getUclmFlg());
		this.hashColumns.put("g030_dcnt_amt", getG030DcntAmt());
		this.hashColumns.put("g181_expt_qty", getG181ExptQty());
		this.hashColumns.put("ofc_rhq_cd", getOfcRhqCd());
		this.hashColumns.put("g060_bill_amt", getG060BillAmt());
		this.hashColumns.put("g181_dcnt_amt", getG181DcntAmt());
		this.hashColumns.put("g030_bill_qty", getG030BillQty());
		this.hashColumns.put("dmdt_cntr_tp_cd", getDmdtCntrTpCd());
		this.hashColumns.put("g030_incr_qty", getG030IncrQty());
		this.hashColumns.put("g181_bill_amt", getG181BillAmt());
		this.hashColumns.put("ofc_flg", getOfcFlg());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("g181_expt_amt", getG181ExptAmt());
		this.hashColumns.put("g090_expt_qty", getG090ExptQty());
		this.hashColumns.put("backendjob_id", getBackendjobId());
		this.hashColumns.put("g060_expt_qty", getG060ExptQty());
		this.hashColumns.put("g181_incr_amt", getG181IncrAmt());

		this.hashColumns.put("g015_incr_qty", getG015IncrQty());
		this.hashColumns.put("g015_incr_amt", getG015IncrAmt());
		this.hashColumns.put("g015_expt_qty", getG015ExptQty());
		this.hashColumns.put("g015_expt_amt", getG015ExptAmt());
		this.hashColumns.put("g015_dcnt_qty", getG015DcntQty());
		this.hashColumns.put("g015_dcnt_amt", getG015DcntAmt());
		this.hashColumns.put("g015_bill_qty", getG015BillQty());
		this.hashColumns.put("g015_bill_amt", getG015BillAmt());
		this.hashColumns.put("status", getStatus());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("g030_expt_amt", "g030ExptAmt");
		this.hashFields.put("g181_bill_qty", "g181BillQty");
		this.hashFields.put("g180_expt_qty", "g180ExptQty");
		this.hashFields.put("g181_incr_qty", "g181IncrQty");
		this.hashFields.put("g180_bill_amt", "g180BillAmt");
		this.hashFields.put("g090_incr_amt", "g090IncrAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("g090_dcnt_qty", "g090DcntQty");
		this.hashFields.put("g060_bill_qty", "g060BillQty");
		this.hashFields.put("g090_dcnt_amt", "g090DcntAmt");
		this.hashFields.put("g181_dcnt_qty", "g181DcntQty");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		
		this.hashFields.put("bzc_trf_curr_cd", "bzcTrfCurrCd");
		
		this.hashFields.put("trf_cd_list", "trfCdList");
		this.hashFields.put("g060_incr_amt", "g060IncrAmt");
		this.hashFields.put("g030_incr_amt", "g030IncrAmt");
		this.hashFields.put("g060_dcnt_qty", "g060DcntQty");
		this.hashFields.put("g090_expt_amt", "g090ExptAmt");
		this.hashFields.put("g090_incr_qty", "g090IncrQty");
		this.hashFields.put("g180_incr_amt", "g180IncrAmt");
		this.hashFields.put("g090_bill_qty", "g090BillQty");
		this.hashFields.put("ofc_cd_list", "ofcCdList");
		this.hashFields.put("g180_expt_amt", "g180ExptAmt");
		this.hashFields.put("grp_flg", "grpFlg");
		this.hashFields.put("g060_expt_amt", "g060ExptAmt");
		this.hashFields.put("cntr_tp_list", "cntrTpList");
		this.hashFields.put("f_year", "fYear");
		this.hashFields.put("g030_bill_amt", "g030BillAmt");
		this.hashFields.put("g180_dcnt_qty", "g180DcntQty");
		this.hashFields.put("g030_dcnt_qty", "g030DcntQty");
		this.hashFields.put("backendjob_key", "backendjobKey");
		this.hashFields.put("curr_flg", "currFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("g180_incr_qty", "g180IncrQty");
		this.hashFields.put("g060_dcnt_amt", "g060DcntAmt");
		this.hashFields.put("g090_bill_amt", "g090BillAmt");
		this.hashFields.put("g180_bill_qty", "g180BillQty");
		this.hashFields.put("g060_incr_qty", "g060IncrQty");
		this.hashFields.put("g180_dcnt_amt", "g180DcntAmt");
		this.hashFields.put("g030_expt_qty", "g030ExptQty");
		this.hashFields.put("uclm_flg", "uclmFlg");
		this.hashFields.put("g030_dcnt_amt", "g030DcntAmt");
		this.hashFields.put("g181_expt_qty", "g181ExptQty");
		this.hashFields.put("ofc_rhq_cd", "ofcRhqCd");
		this.hashFields.put("g060_bill_amt", "g060BillAmt");
		this.hashFields.put("g181_dcnt_amt", "g181DcntAmt");
		this.hashFields.put("g030_bill_qty", "g030BillQty");
		this.hashFields.put("dmdt_cntr_tp_cd", "dmdtCntrTpCd");
		this.hashFields.put("g030_incr_qty", "g030IncrQty");
		this.hashFields.put("g181_bill_amt", "g181BillAmt");
		this.hashFields.put("ofc_flg", "ofcFlg");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("g181_expt_amt", "g181ExptAmt");
		this.hashFields.put("g090_expt_qty", "g090ExptQty");
		this.hashFields.put("backendjob_id", "backendjobId");
		this.hashFields.put("g060_expt_qty", "g060ExptQty");
		this.hashFields.put("g181_incr_amt", "g181IncrAmt");

		this.hashFields.put("g015_incr_qty", "g015IncrQty");
		this.hashFields.put("g015_incr_amt", "g015IncrAmt");
		this.hashFields.put("g015_expt_qty", "g015ExptQty");
		this.hashFields.put("g015_expt_amt", "g015ExptAmt");
		this.hashFields.put("g015_dcnt_qty", "g015DcntQty");
		this.hashFields.put("g015_dcnt_amt", "g015DcntAmt");
		this.hashFields.put("g015_bill_qty", "g015BillQty");
		this.hashFields.put("g015_bill_amt", "g015BillAmt");
		this.hashFields.put("status", "status");
		return this.hashFields;
	}
	
	/**
	 * @return the bzcTrfCurrCd
	 */
	public String getBzcTrfCurrCd() {
		return bzcTrfCurrCd;
	}

	/**
	 * @param bzcTrfCurrCd the bzcTrfCurrCd to set
	 */
	public void setBzcTrfCurrCd(String bzcTrfCurrCd) {
		this.bzcTrfCurrCd = bzcTrfCurrCd;
	}

	/**
	 * Column Info
	 * @return g030ExptAmt
	 */
	public String getG030ExptAmt() {
		return this.g030ExptAmt;
	}
	
	/**
	 * Column Info
	 * @return g181BillQty
	 */
	public String getG181BillQty() {
		return this.g181BillQty;
	}
	
	/**
	 * Column Info
	 * @return g180ExptQty
	 */
	public String getG180ExptQty() {
		return this.g180ExptQty;
	}
	
	/**
	 * Column Info
	 * @return g181IncrQty
	 */
	public String getG181IncrQty() {
		return this.g181IncrQty;
	}
	
	/**
	 * Column Info
	 * @return g180BillAmt
	 */
	public String getG180BillAmt() {
		return this.g180BillAmt;
	}
	
	/**
	 * Column Info
	 * @return g090IncrAmt
	 */
	public String getG090IncrAmt() {
		return this.g090IncrAmt;
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
	 * @return g090DcntQty
	 */
	public String getG090DcntQty() {
		return this.g090DcntQty;
	}
	
	/**
	 * Column Info
	 * @return g060BillQty
	 */
	public String getG060BillQty() {
		return this.g060BillQty;
	}
	
	/**
	 * Column Info
	 * @return g090DcntAmt
	 */
	public String getG090DcntAmt() {
		return this.g090DcntAmt;
	}
	
	/**
	 * Column Info
	 * @return g181DcntQty
	 */
	public String getG181DcntQty() {
		return this.g181DcntQty;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return this.dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @return trfCdList
	 */
	public String getTrfCdList() {
		return this.trfCdList;
	}
	
	/**
	 * Column Info
	 * @return g060IncrAmt
	 */
	public String getG060IncrAmt() {
		return this.g060IncrAmt;
	}
	
	/**
	 * Column Info
	 * @return g030IncrAmt
	 */
	public String getG030IncrAmt() {
		return this.g030IncrAmt;
	}
	
	/**
	 * Column Info
	 * @return g060DcntQty
	 */
	public String getG060DcntQty() {
		return this.g060DcntQty;
	}
	
	/**
	 * Column Info
	 * @return g090ExptAmt
	 */
	public String getG090ExptAmt() {
		return this.g090ExptAmt;
	}
	
	/**
	 * Column Info
	 * @return g090IncrQty
	 */
	public String getG090IncrQty() {
		return this.g090IncrQty;
	}
	
	/**
	 * Column Info
	 * @return g180IncrAmt
	 */
	public String getG180IncrAmt() {
		return this.g180IncrAmt;
	}
	
	/**
	 * Column Info
	 * @return g090BillQty
	 */
	public String getG090BillQty() {
		return this.g090BillQty;
	}
	
	/**
	 * Column Info
	 * @return ofcCdList
	 */
	public String getOfcCdList() {
		return this.ofcCdList;
	}
	
	/**
	 * Column Info
	 * @return g180ExptAmt
	 */
	public String getG180ExptAmt() {
		return this.g180ExptAmt;
	}
	
	/**
	 * Column Info
	 * @return grpFlg
	 */
	public String getGrpFlg() {
		return this.grpFlg;
	}
	
	/**
	 * Column Info
	 * @return g060ExptAmt
	 */
	public String getG060ExptAmt() {
		return this.g060ExptAmt;
	}
	
	/**
	 * Column Info
	 * @return cntrTpList
	 */
	public String getCntrTpList() {
		return this.cntrTpList;
	}
	
	/**
	 * Column Info
	 * @return fYear
	 */
	public String getFYear() {
		return this.fYear;
	}
	
	/**
	 * Column Info
	 * @return g030BillAmt
	 */
	public String getG030BillAmt() {
		return this.g030BillAmt;
	}
	
	/**
	 * Column Info
	 * @return g180DcntQty
	 */
	public String getG180DcntQty() {
		return this.g180DcntQty;
	}
	
	/**
	 * Column Info
	 * @return g030DcntQty
	 */
	public String getG030DcntQty() {
		return this.g030DcntQty;
	}
	
	/**
	 * Column Info
	 * @return backendjobKey
	 */
	public String getBackendjobKey() {
		return this.backendjobKey;
	}
	
	/**
	 * Column Info
	 * @return currFlg
	 */
	public String getCurrFlg() {
		return this.currFlg;
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
	 * @return g180IncrQty
	 */
	public String getG180IncrQty() {
		return this.g180IncrQty;
	}
	
	/**
	 * Column Info
	 * @return g060DcntAmt
	 */
	public String getG060DcntAmt() {
		return this.g060DcntAmt;
	}
	
	/**
	 * Column Info
	 * @return g090BillAmt
	 */
	public String getG090BillAmt() {
		return this.g090BillAmt;
	}
	
	/**
	 * Column Info
	 * @return g180BillQty
	 */
	public String getG180BillQty() {
		return this.g180BillQty;
	}
	
	/**
	 * Column Info
	 * @return g060IncrQty
	 */
	public String getG060IncrQty() {
		return this.g060IncrQty;
	}
	
	/**
	 * Column Info
	 * @return g180DcntAmt
	 */
	public String getG180DcntAmt() {
		return this.g180DcntAmt;
	}
	
	/**
	 * Column Info
	 * @return g030ExptQty
	 */
	public String getG030ExptQty() {
		return this.g030ExptQty;
	}
	
	/**
	 * Column Info
	 * @return uclmFlg
	 */
	public String getUclmFlg() {
		return this.uclmFlg;
	}
	
	/**
	 * Column Info
	 * @return g030DcntAmt
	 */
	public String getG030DcntAmt() {
		return this.g030DcntAmt;
	}
	
	/**
	 * Column Info
	 * @return g181ExptQty
	 */
	public String getG181ExptQty() {
		return this.g181ExptQty;
	}
	
	/**
	 * Column Info
	 * @return ofcRhqCd
	 */
	public String getOfcRhqCd() {
		return this.ofcRhqCd;
	}
	
	/**
	 * Column Info
	 * @return g060BillAmt
	 */
	public String getG060BillAmt() {
		return this.g060BillAmt;
	}
	
	/**
	 * Column Info
	 * @return g181DcntAmt
	 */
	public String getG181DcntAmt() {
		return this.g181DcntAmt;
	}
	
	/**
	 * Column Info
	 * @return g030BillQty
	 */
	public String getG030BillQty() {
		return this.g030BillQty;
	}
	
	/**
	 * Column Info
	 * @return dmdtCntrTpCd
	 */
	public String getDmdtCntrTpCd() {
		return this.dmdtCntrTpCd;
	}
	
	/**
	 * Column Info
	 * @return g030IncrQty
	 */
	public String getG030IncrQty() {
		return this.g030IncrQty;
	}
	
	/**
	 * Column Info
	 * @return g181BillAmt
	 */
	public String getG181BillAmt() {
		return this.g181BillAmt;
	}
	
	/**
	 * Column Info
	 * @return ofcFlg
	 */
	public String getOfcFlg() {
		return this.ofcFlg;
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
	 * @return g181ExptAmt
	 */
	public String getG181ExptAmt() {
		return this.g181ExptAmt;
	}
	
	/**
	 * Column Info
	 * @return g090ExptQty
	 */
	public String getG090ExptQty() {
		return this.g090ExptQty;
	}
	
	/**
	 * Column Info
	 * @return backendjobId
	 */
	public String getBackendjobId() {
		return this.backendjobId;
	}
	
	/**
	 * Column Info
	 * @return g060ExptQty
	 */
	public String getG060ExptQty() {
		return this.g060ExptQty;
	}
	
	/**
	 * Column Info
	 * @return g181IncrAmt
	 */
	public String getG181IncrAmt() {
		return this.g181IncrAmt;
	}
	

	/**
	 * Column Info
	 * @param g030ExptAmt
	 */
	public void setG030ExptAmt(String g030ExptAmt) {
		this.g030ExptAmt = g030ExptAmt;
	}
	
	/**
	 * Column Info
	 * @param g181BillQty
	 */
	public void setG181BillQty(String g181BillQty) {
		this.g181BillQty = g181BillQty;
	}
	
	/**
	 * Column Info
	 * @param g180ExptQty
	 */
	public void setG180ExptQty(String g180ExptQty) {
		this.g180ExptQty = g180ExptQty;
	}
	
	/**
	 * Column Info
	 * @param g181IncrQty
	 */
	public void setG181IncrQty(String g181IncrQty) {
		this.g181IncrQty = g181IncrQty;
	}
	
	/**
	 * Column Info
	 * @param g180BillAmt
	 */
	public void setG180BillAmt(String g180BillAmt) {
		this.g180BillAmt = g180BillAmt;
	}
	
	/**
	 * Column Info
	 * @param g090IncrAmt
	 */
	public void setG090IncrAmt(String g090IncrAmt) {
		this.g090IncrAmt = g090IncrAmt;
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
	 * @param g090DcntQty
	 */
	public void setG090DcntQty(String g090DcntQty) {
		this.g090DcntQty = g090DcntQty;
	}
	
	/**
	 * Column Info
	 * @param g060BillQty
	 */
	public void setG060BillQty(String g060BillQty) {
		this.g060BillQty = g060BillQty;
	}
	
	/**
	 * Column Info
	 * @param g090DcntAmt
	 */
	public void setG090DcntAmt(String g090DcntAmt) {
		this.g090DcntAmt = g090DcntAmt;
	}
	
	/**
	 * Column Info
	 * @param g181DcntQty
	 */
	public void setG181DcntQty(String g181DcntQty) {
		this.g181DcntQty = g181DcntQty;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @param trfCdList
	 */
	public void setTrfCdList(String trfCdList) {
		this.trfCdList = trfCdList;
	}
	
	/**
	 * Column Info
	 * @param g060IncrAmt
	 */
	public void setG060IncrAmt(String g060IncrAmt) {
		this.g060IncrAmt = g060IncrAmt;
	}
	
	/**
	 * Column Info
	 * @param g030IncrAmt
	 */
	public void setG030IncrAmt(String g030IncrAmt) {
		this.g030IncrAmt = g030IncrAmt;
	}
	
	/**
	 * Column Info
	 * @param g060DcntQty
	 */
	public void setG060DcntQty(String g060DcntQty) {
		this.g060DcntQty = g060DcntQty;
	}
	
	/**
	 * Column Info
	 * @param g090ExptAmt
	 */
	public void setG090ExptAmt(String g090ExptAmt) {
		this.g090ExptAmt = g090ExptAmt;
	}
	
	/**
	 * Column Info
	 * @param g090IncrQty
	 */
	public void setG090IncrQty(String g090IncrQty) {
		this.g090IncrQty = g090IncrQty;
	}
	
	/**
	 * Column Info
	 * @param g180IncrAmt
	 */
	public void setG180IncrAmt(String g180IncrAmt) {
		this.g180IncrAmt = g180IncrAmt;
	}
	
	/**
	 * Column Info
	 * @param g090BillQty
	 */
	public void setG090BillQty(String g090BillQty) {
		this.g090BillQty = g090BillQty;
	}
	
	/**
	 * Column Info
	 * @param ofcCdList
	 */
	public void setOfcCdList(String ofcCdList) {
		this.ofcCdList = ofcCdList;
	}
	
	/**
	 * Column Info
	 * @param g180ExptAmt
	 */
	public void setG180ExptAmt(String g180ExptAmt) {
		this.g180ExptAmt = g180ExptAmt;
	}
	
	/**
	 * Column Info
	 * @param grpFlg
	 */
	public void setGrpFlg(String grpFlg) {
		this.grpFlg = grpFlg;
	}
	
	/**
	 * Column Info
	 * @param g060ExptAmt
	 */
	public void setG060ExptAmt(String g060ExptAmt) {
		this.g060ExptAmt = g060ExptAmt;
	}
	
	/**
	 * Column Info
	 * @param cntrTpList
	 */
	public void setCntrTpList(String cntrTpList) {
		this.cntrTpList = cntrTpList;
	}
	
	/**
	 * Column Info
	 * @param fYear
	 */
	public void setFYear(String fYear) {
		this.fYear = fYear;
	}
	
	/**
	 * Column Info
	 * @param g030BillAmt
	 */
	public void setG030BillAmt(String g030BillAmt) {
		this.g030BillAmt = g030BillAmt;
	}
	
	/**
	 * Column Info
	 * @param g180DcntQty
	 */
	public void setG180DcntQty(String g180DcntQty) {
		this.g180DcntQty = g180DcntQty;
	}
	
	/**
	 * Column Info
	 * @param g030DcntQty
	 */
	public void setG030DcntQty(String g030DcntQty) {
		this.g030DcntQty = g030DcntQty;
	}
	
	/**
	 * Column Info
	 * @param backendjobKey
	 */
	public void setBackendjobKey(String backendjobKey) {
		this.backendjobKey = backendjobKey;
	}
	
	/**
	 * Column Info
	 * @param currFlg
	 */
	public void setCurrFlg(String currFlg) {
		this.currFlg = currFlg;
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
	 * @param g180IncrQty
	 */
	public void setG180IncrQty(String g180IncrQty) {
		this.g180IncrQty = g180IncrQty;
	}
	
	/**
	 * Column Info
	 * @param g060DcntAmt
	 */
	public void setG060DcntAmt(String g060DcntAmt) {
		this.g060DcntAmt = g060DcntAmt;
	}
	
	/**
	 * Column Info
	 * @param g090BillAmt
	 */
	public void setG090BillAmt(String g090BillAmt) {
		this.g090BillAmt = g090BillAmt;
	}
	
	/**
	 * Column Info
	 * @param g180BillQty
	 */
	public void setG180BillQty(String g180BillQty) {
		this.g180BillQty = g180BillQty;
	}
	
	/**
	 * Column Info
	 * @param g060IncrQty
	 */
	public void setG060IncrQty(String g060IncrQty) {
		this.g060IncrQty = g060IncrQty;
	}
	
	/**
	 * Column Info
	 * @param g180DcntAmt
	 */
	public void setG180DcntAmt(String g180DcntAmt) {
		this.g180DcntAmt = g180DcntAmt;
	}
	
	/**
	 * Column Info
	 * @param g030ExptQty
	 */
	public void setG030ExptQty(String g030ExptQty) {
		this.g030ExptQty = g030ExptQty;
	}
	
	/**
	 * Column Info
	 * @param uclmFlg
	 */
	public void setUclmFlg(String uclmFlg) {
		this.uclmFlg = uclmFlg;
	}
	
	/**
	 * Column Info
	 * @param g030DcntAmt
	 */
	public void setG030DcntAmt(String g030DcntAmt) {
		this.g030DcntAmt = g030DcntAmt;
	}
	
	/**
	 * Column Info
	 * @param g181ExptQty
	 */
	public void setG181ExptQty(String g181ExptQty) {
		this.g181ExptQty = g181ExptQty;
	}
	
	/**
	 * Column Info
	 * @param ofcRhqCd
	 */
	public void setOfcRhqCd(String ofcRhqCd) {
		this.ofcRhqCd = ofcRhqCd;
	}
	
	/**
	 * Column Info
	 * @param g060BillAmt
	 */
	public void setG060BillAmt(String g060BillAmt) {
		this.g060BillAmt = g060BillAmt;
	}
	
	/**
	 * Column Info
	 * @param g181DcntAmt
	 */
	public void setG181DcntAmt(String g181DcntAmt) {
		this.g181DcntAmt = g181DcntAmt;
	}
	
	/**
	 * Column Info
	 * @param g030BillQty
	 */
	public void setG030BillQty(String g030BillQty) {
		this.g030BillQty = g030BillQty;
	}
	
	/**
	 * Column Info
	 * @param dmdtCntrTpCd
	 */
	public void setDmdtCntrTpCd(String dmdtCntrTpCd) {
		this.dmdtCntrTpCd = dmdtCntrTpCd;
	}
	
	/**
	 * Column Info
	 * @param g030IncrQty
	 */
	public void setG030IncrQty(String g030IncrQty) {
		this.g030IncrQty = g030IncrQty;
	}
	
	/**
	 * Column Info
	 * @param g181BillAmt
	 */
	public void setG181BillAmt(String g181BillAmt) {
		this.g181BillAmt = g181BillAmt;
	}
	
	/**
	 * Column Info
	 * @param ofcFlg
	 */
	public void setOfcFlg(String ofcFlg) {
		this.ofcFlg = ofcFlg;
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
	 * @param g181ExptAmt
	 */
	public void setG181ExptAmt(String g181ExptAmt) {
		this.g181ExptAmt = g181ExptAmt;
	}
	
	/**
	 * Column Info
	 * @param g090ExptQty
	 */
	public void setG090ExptQty(String g090ExptQty) {
		this.g090ExptQty = g090ExptQty;
	}
	
	/**
	 * Column Info
	 * @param backendjobId
	 */
	public void setBackendjobId(String backendjobId) {
		this.backendjobId = backendjobId;
	}
	
	/**
	 * Column Info
	 * @param g060ExptQty
	 */
	public void setG060ExptQty(String g060ExptQty) {
		this.g060ExptQty = g060ExptQty;
	}
	
	/**
	 * Column Info
	 * @param g181IncrAmt
	 */
	public void setG181IncrAmt(String g181IncrAmt) {
		this.g181IncrAmt = g181IncrAmt;
	}
	
	public String getG015IncrQty() {
		return g015IncrQty;
	}

	public void setG015IncrQty(String g015IncrQty) {
		this.g015IncrQty = g015IncrQty;
	}

	public String getG015IncrAmt() {
		return g015IncrAmt;
	}

	public void setG015IncrAmt(String g015IncrAmt) {
		this.g015IncrAmt = g015IncrAmt;
	}

	public String getG015ExptQty() {
		return g015ExptQty;
	}

	public void setG015ExptQty(String g015ExptQty) {
		this.g015ExptQty = g015ExptQty;
	}

	public String getG015ExptAmt() {
		return g015ExptAmt;
	}

	public void setG015ExptAmt(String g015ExptAmt) {
		this.g015ExptAmt = g015ExptAmt;
	}

	public String getG015DcntQty() {
		return g015DcntQty;
	}

	public void setG015DcntQty(String g015DcntQty) {
		this.g015DcntQty = g015DcntQty;
	}

	public String getG015DcntAmt() {
		return g015DcntAmt;
	}

	public void setG015DcntAmt(String g015DcntAmt) {
		this.g015DcntAmt = g015DcntAmt;
	}

	public String getG015BillQty() {
		return g015BillQty;
	}

	public void setG015BillQty(String g015BillQty) {
		this.g015BillQty = g015BillQty;
	}

	public String getG015BillAmt() {
		return g015BillAmt;
	}

	public void setG015BillAmt(String g015BillAmt) {
		this.g015BillAmt = g015BillAmt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
		setG030ExptAmt(JSPUtil.getParameter(request, prefix + "g030_expt_amt", ""));
		setG181BillQty(JSPUtil.getParameter(request, prefix + "g181_bill_qty", ""));
		setG180ExptQty(JSPUtil.getParameter(request, prefix + "g180_expt_qty", ""));
		setG181IncrQty(JSPUtil.getParameter(request, prefix + "g181_incr_qty", ""));
		setG180BillAmt(JSPUtil.getParameter(request, prefix + "g180_bill_amt", ""));
		setG090IncrAmt(JSPUtil.getParameter(request, prefix + "g090_incr_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setG090DcntQty(JSPUtil.getParameter(request, prefix + "g090_dcnt_qty", ""));
		setG060BillQty(JSPUtil.getParameter(request, prefix + "g060_bill_qty", ""));
		setG090DcntAmt(JSPUtil.getParameter(request, prefix + "g090_dcnt_amt", ""));
		setG181DcntQty(JSPUtil.getParameter(request, prefix + "g181_dcnt_qty", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", ""));
		
		setBzcTrfCurrCd(JSPUtil.getParameter(request, prefix + "bzc_trf_curr_cd", ""));
		
		setTrfCdList(JSPUtil.getParameter(request, prefix + "trf_cd_list", ""));
		setG060IncrAmt(JSPUtil.getParameter(request, prefix + "g060_incr_amt", ""));
		setG030IncrAmt(JSPUtil.getParameter(request, prefix + "g030_incr_amt", ""));
		setG060DcntQty(JSPUtil.getParameter(request, prefix + "g060_dcnt_qty", ""));
		setG090ExptAmt(JSPUtil.getParameter(request, prefix + "g090_expt_amt", ""));
		setG090IncrQty(JSPUtil.getParameter(request, prefix + "g090_incr_qty", ""));
		setG180IncrAmt(JSPUtil.getParameter(request, prefix + "g180_incr_amt", ""));
		setG090BillQty(JSPUtil.getParameter(request, prefix + "g090_bill_qty", ""));
		setOfcCdList(JSPUtil.getParameter(request, prefix + "ofc_cd_list", ""));
		setG180ExptAmt(JSPUtil.getParameter(request, prefix + "g180_expt_amt", ""));
		setGrpFlg(JSPUtil.getParameter(request, prefix + "grp_flg", ""));
		setG060ExptAmt(JSPUtil.getParameter(request, prefix + "g060_expt_amt", ""));
		setCntrTpList(JSPUtil.getParameter(request, prefix + "cntr_tp_list", ""));
		setFYear(JSPUtil.getParameter(request, prefix + "f_year", ""));
		setG030BillAmt(JSPUtil.getParameter(request, prefix + "g030_bill_amt", ""));
		setG180DcntQty(JSPUtil.getParameter(request, prefix + "g180_dcnt_qty", ""));
		setG030DcntQty(JSPUtil.getParameter(request, prefix + "g030_dcnt_qty", ""));
		setBackendjobKey(JSPUtil.getParameter(request, prefix + "backendjob_key", ""));
		setCurrFlg(JSPUtil.getParameter(request, prefix + "curr_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setG180IncrQty(JSPUtil.getParameter(request, prefix + "g180_incr_qty", ""));
		setG060DcntAmt(JSPUtil.getParameter(request, prefix + "g060_dcnt_amt", ""));
		setG090BillAmt(JSPUtil.getParameter(request, prefix + "g090_bill_amt", ""));
		setG180BillQty(JSPUtil.getParameter(request, prefix + "g180_bill_qty", ""));
		setG060IncrQty(JSPUtil.getParameter(request, prefix + "g060_incr_qty", ""));
		setG180DcntAmt(JSPUtil.getParameter(request, prefix + "g180_dcnt_amt", ""));
		setG030ExptQty(JSPUtil.getParameter(request, prefix + "g030_expt_qty", ""));
		setUclmFlg(JSPUtil.getParameter(request, prefix + "uclm_flg", ""));
		setG030DcntAmt(JSPUtil.getParameter(request, prefix + "g030_dcnt_amt", ""));
		setG181ExptQty(JSPUtil.getParameter(request, prefix + "g181_expt_qty", ""));
		setOfcRhqCd(JSPUtil.getParameter(request, prefix + "ofc_rhq_cd", ""));
		setG060BillAmt(JSPUtil.getParameter(request, prefix + "g060_bill_amt", ""));
		setG181DcntAmt(JSPUtil.getParameter(request, prefix + "g181_dcnt_amt", ""));
		setG030BillQty(JSPUtil.getParameter(request, prefix + "g030_bill_qty", ""));
		setDmdtCntrTpCd(JSPUtil.getParameter(request, prefix + "dmdt_cntr_tp_cd", ""));
		setG030IncrQty(JSPUtil.getParameter(request, prefix + "g030_incr_qty", ""));
		setG181BillAmt(JSPUtil.getParameter(request, prefix + "g181_bill_amt", ""));
		setOfcFlg(JSPUtil.getParameter(request, prefix + "ofc_flg", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setG181ExptAmt(JSPUtil.getParameter(request, prefix + "g181_expt_amt", ""));
		setG090ExptQty(JSPUtil.getParameter(request, prefix + "g090_expt_qty", ""));
		setBackendjobId(JSPUtil.getParameter(request, prefix + "backendjob_id", ""));
		setG060ExptQty(JSPUtil.getParameter(request, prefix + "g060_expt_qty", ""));
		setG181IncrAmt(JSPUtil.getParameter(request, prefix + "g181_incr_amt", ""));

		setG015IncrQty(JSPUtil.getParameter(request, prefix + "g015_incr_qty", ""));
		setG015IncrAmt(JSPUtil.getParameter(request, prefix + "g015_incr_amt", ""));
		setG015ExptQty(JSPUtil.getParameter(request, prefix + "g015_expt_qty", ""));
		setG015ExptAmt(JSPUtil.getParameter(request, prefix + "g015_expt_amt", ""));
		setG015DcntQty(JSPUtil.getParameter(request, prefix + "g015_dcnt_qty", ""));
		setG015DcntAmt(JSPUtil.getParameter(request, prefix + "g015_dcnt_amt", ""));
		setG015BillQty(JSPUtil.getParameter(request, prefix + "g015_bill_qty", ""));
		setG015BillAmt(JSPUtil.getParameter(request, prefix + "g015_bill_amt", ""));
		setStatus(JSPUtil.getParameter(request, prefix + "status", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return YearlyCollectionByRHQVO[]
	 */
	public YearlyCollectionByRHQVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return YearlyCollectionByRHQVO[]
	 */
	public YearlyCollectionByRHQVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		YearlyCollectionByRHQVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] g030ExptAmt = (JSPUtil.getParameter(request, prefix	+ "g030_expt_amt", length));
			String[] g181BillQty = (JSPUtil.getParameter(request, prefix	+ "g181_bill_qty", length));
			String[] g180ExptQty = (JSPUtil.getParameter(request, prefix	+ "g180_expt_qty", length));
			String[] g181IncrQty = (JSPUtil.getParameter(request, prefix	+ "g181_incr_qty", length));
			String[] g180BillAmt = (JSPUtil.getParameter(request, prefix	+ "g180_bill_amt", length));
			String[] g090IncrAmt = (JSPUtil.getParameter(request, prefix	+ "g090_incr_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] g090DcntQty = (JSPUtil.getParameter(request, prefix	+ "g090_dcnt_qty", length));
			String[] g060BillQty = (JSPUtil.getParameter(request, prefix	+ "g060_bill_qty", length));
			String[] g090DcntAmt = (JSPUtil.getParameter(request, prefix	+ "g090_dcnt_amt", length));
			String[] g181DcntQty = (JSPUtil.getParameter(request, prefix	+ "g181_dcnt_qty", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			
			String[] bzcTrfCurrCd = (JSPUtil.getParameter(request, prefix	+ "bzc_trf_curr_cd", length));
			
			String[] trfCdList = (JSPUtil.getParameter(request, prefix	+ "trf_cd_list", length));
			String[] g060IncrAmt = (JSPUtil.getParameter(request, prefix	+ "g060_incr_amt", length));
			String[] g030IncrAmt = (JSPUtil.getParameter(request, prefix	+ "g030_incr_amt", length));
			String[] g060DcntQty = (JSPUtil.getParameter(request, prefix	+ "g060_dcnt_qty", length));
			String[] g090ExptAmt = (JSPUtil.getParameter(request, prefix	+ "g090_expt_amt", length));
			String[] g090IncrQty = (JSPUtil.getParameter(request, prefix	+ "g090_incr_qty", length));
			String[] g180IncrAmt = (JSPUtil.getParameter(request, prefix	+ "g180_incr_amt", length));
			String[] g090BillQty = (JSPUtil.getParameter(request, prefix	+ "g090_bill_qty", length));
			String[] ofcCdList = (JSPUtil.getParameter(request, prefix	+ "ofc_cd_list", length));
			String[] g180ExptAmt = (JSPUtil.getParameter(request, prefix	+ "g180_expt_amt", length));
			String[] grpFlg = (JSPUtil.getParameter(request, prefix	+ "grp_flg", length));
			String[] g060ExptAmt = (JSPUtil.getParameter(request, prefix	+ "g060_expt_amt", length));
			String[] cntrTpList = (JSPUtil.getParameter(request, prefix	+ "cntr_tp_list", length));
			String[] fYear = (JSPUtil.getParameter(request, prefix	+ "f_year", length));
			String[] g030BillAmt = (JSPUtil.getParameter(request, prefix	+ "g030_bill_amt", length));
			String[] g180DcntQty = (JSPUtil.getParameter(request, prefix	+ "g180_dcnt_qty", length));
			String[] g030DcntQty = (JSPUtil.getParameter(request, prefix	+ "g030_dcnt_qty", length));
			String[] backendjobKey = (JSPUtil.getParameter(request, prefix	+ "backendjob_key", length));
			String[] currFlg = (JSPUtil.getParameter(request, prefix	+ "curr_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] g180IncrQty = (JSPUtil.getParameter(request, prefix	+ "g180_incr_qty", length));
			String[] g060DcntAmt = (JSPUtil.getParameter(request, prefix	+ "g060_dcnt_amt", length));
			String[] g090BillAmt = (JSPUtil.getParameter(request, prefix	+ "g090_bill_amt", length));
			String[] g180BillQty = (JSPUtil.getParameter(request, prefix	+ "g180_bill_qty", length));
			String[] g060IncrQty = (JSPUtil.getParameter(request, prefix	+ "g060_incr_qty", length));
			String[] g180DcntAmt = (JSPUtil.getParameter(request, prefix	+ "g180_dcnt_amt", length));
			String[] g030ExptQty = (JSPUtil.getParameter(request, prefix	+ "g030_expt_qty", length));
			String[] uclmFlg = (JSPUtil.getParameter(request, prefix	+ "uclm_flg", length));
			String[] g030DcntAmt = (JSPUtil.getParameter(request, prefix	+ "g030_dcnt_amt", length));
			String[] g181ExptQty = (JSPUtil.getParameter(request, prefix	+ "g181_expt_qty", length));
			String[] ofcRhqCd = (JSPUtil.getParameter(request, prefix	+ "ofc_rhq_cd", length));
			String[] g060BillAmt = (JSPUtil.getParameter(request, prefix	+ "g060_bill_amt", length));
			String[] g181DcntAmt = (JSPUtil.getParameter(request, prefix	+ "g181_dcnt_amt", length));
			String[] g030BillQty = (JSPUtil.getParameter(request, prefix	+ "g030_bill_qty", length));
			String[] dmdtCntrTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_cntr_tp_cd", length));
			String[] g030IncrQty = (JSPUtil.getParameter(request, prefix	+ "g030_incr_qty", length));
			String[] g181BillAmt = (JSPUtil.getParameter(request, prefix	+ "g181_bill_amt", length));
			String[] ofcFlg = (JSPUtil.getParameter(request, prefix	+ "ofc_flg", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] g181ExptAmt = (JSPUtil.getParameter(request, prefix	+ "g181_expt_amt", length));
			String[] g090ExptQty = (JSPUtil.getParameter(request, prefix	+ "g090_expt_qty", length));
			String[] backendjobId = (JSPUtil.getParameter(request, prefix	+ "backendjob_id", length));
			String[] g060ExptQty = (JSPUtil.getParameter(request, prefix	+ "g060_expt_qty", length));
			String[] g181IncrAmt = (JSPUtil.getParameter(request, prefix	+ "g181_incr_amt", length));

			String[] g015IncrQty = (JSPUtil.getParameter(request, prefix	+ "g015_incr_qty", length));
			String[] g015IncrAmt = (JSPUtil.getParameter(request, prefix	+ "g015_incr_amt", length));
			String[] g015ExptQty = (JSPUtil.getParameter(request, prefix	+ "g015_expt_qty", length));
			String[] g015ExptAmt = (JSPUtil.getParameter(request, prefix	+ "g015_expt_amt", length));
			String[] g015DcntQty = (JSPUtil.getParameter(request, prefix	+ "g015_dcnt_qty", length));
			String[] g015DcntAmt = (JSPUtil.getParameter(request, prefix	+ "g015_dcnt_amt", length));
			String[] g015BillQty = (JSPUtil.getParameter(request, prefix	+ "g015_bill_qty", length));
			String[] g015BillAmt = (JSPUtil.getParameter(request, prefix	+ "g015_bill_amt", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			
			for (int i = 0; i < length; i++) {
				model = new YearlyCollectionByRHQVO();
				if (g030ExptAmt[i] != null)
					model.setG030ExptAmt(g030ExptAmt[i]);
				if (g181BillQty[i] != null)
					model.setG181BillQty(g181BillQty[i]);
				if (g180ExptQty[i] != null)
					model.setG180ExptQty(g180ExptQty[i]);
				if (g181IncrQty[i] != null)
					model.setG181IncrQty(g181IncrQty[i]);
				if (g180BillAmt[i] != null)
					model.setG180BillAmt(g180BillAmt[i]);
				if (g090IncrAmt[i] != null)
					model.setG090IncrAmt(g090IncrAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (g090DcntQty[i] != null)
					model.setG090DcntQty(g090DcntQty[i]);
				if (g060BillQty[i] != null)
					model.setG060BillQty(g060BillQty[i]);
				if (g090DcntAmt[i] != null)
					model.setG090DcntAmt(g090DcntAmt[i]);
				if (g181DcntQty[i] != null)
					model.setG181DcntQty(g181DcntQty[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				
				if (bzcTrfCurrCd[i] != null)
					model.setBzcTrfCurrCd(bzcTrfCurrCd[i]);
				
				if (trfCdList[i] != null)
					model.setTrfCdList(trfCdList[i]);
				if (g060IncrAmt[i] != null)
					model.setG060IncrAmt(g060IncrAmt[i]);
				if (g030IncrAmt[i] != null)
					model.setG030IncrAmt(g030IncrAmt[i]);
				if (g060DcntQty[i] != null)
					model.setG060DcntQty(g060DcntQty[i]);
				if (g090ExptAmt[i] != null)
					model.setG090ExptAmt(g090ExptAmt[i]);
				if (g090IncrQty[i] != null)
					model.setG090IncrQty(g090IncrQty[i]);
				if (g180IncrAmt[i] != null)
					model.setG180IncrAmt(g180IncrAmt[i]);
				if (g090BillQty[i] != null)
					model.setG090BillQty(g090BillQty[i]);
				if (ofcCdList[i] != null)
					model.setOfcCdList(ofcCdList[i]);
				if (g180ExptAmt[i] != null)
					model.setG180ExptAmt(g180ExptAmt[i]);
				if (grpFlg[i] != null)
					model.setGrpFlg(grpFlg[i]);
				if (g060ExptAmt[i] != null)
					model.setG060ExptAmt(g060ExptAmt[i]);
				if (cntrTpList[i] != null)
					model.setCntrTpList(cntrTpList[i]);
				if (fYear[i] != null)
					model.setFYear(fYear[i]);
				if (g030BillAmt[i] != null)
					model.setG030BillAmt(g030BillAmt[i]);
				if (g180DcntQty[i] != null)
					model.setG180DcntQty(g180DcntQty[i]);
				if (g030DcntQty[i] != null)
					model.setG030DcntQty(g030DcntQty[i]);
				if (backendjobKey[i] != null)
					model.setBackendjobKey(backendjobKey[i]);
				if (currFlg[i] != null)
					model.setCurrFlg(currFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (g180IncrQty[i] != null)
					model.setG180IncrQty(g180IncrQty[i]);
				if (g060DcntAmt[i] != null)
					model.setG060DcntAmt(g060DcntAmt[i]);
				if (g090BillAmt[i] != null)
					model.setG090BillAmt(g090BillAmt[i]);
				if (g180BillQty[i] != null)
					model.setG180BillQty(g180BillQty[i]);
				if (g060IncrQty[i] != null)
					model.setG060IncrQty(g060IncrQty[i]);
				if (g180DcntAmt[i] != null)
					model.setG180DcntAmt(g180DcntAmt[i]);
				if (g030ExptQty[i] != null)
					model.setG030ExptQty(g030ExptQty[i]);
				if (uclmFlg[i] != null)
					model.setUclmFlg(uclmFlg[i]);
				if (g030DcntAmt[i] != null)
					model.setG030DcntAmt(g030DcntAmt[i]);
				if (g181ExptQty[i] != null)
					model.setG181ExptQty(g181ExptQty[i]);
				if (ofcRhqCd[i] != null)
					model.setOfcRhqCd(ofcRhqCd[i]);
				if (g060BillAmt[i] != null)
					model.setG060BillAmt(g060BillAmt[i]);
				if (g181DcntAmt[i] != null)
					model.setG181DcntAmt(g181DcntAmt[i]);
				if (g030BillQty[i] != null)
					model.setG030BillQty(g030BillQty[i]);
				if (dmdtCntrTpCd[i] != null)
					model.setDmdtCntrTpCd(dmdtCntrTpCd[i]);
				if (g030IncrQty[i] != null)
					model.setG030IncrQty(g030IncrQty[i]);
				if (g181BillAmt[i] != null)
					model.setG181BillAmt(g181BillAmt[i]);
				if (ofcFlg[i] != null)
					model.setOfcFlg(ofcFlg[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (g181ExptAmt[i] != null)
					model.setG181ExptAmt(g181ExptAmt[i]);
				if (g090ExptQty[i] != null)
					model.setG090ExptQty(g090ExptQty[i]);
				if (backendjobId[i] != null)
					model.setBackendjobId(backendjobId[i]);
				if (g060ExptQty[i] != null)
					model.setG060ExptQty(g060ExptQty[i]);
				if (g181IncrAmt[i] != null)
					model.setG181IncrAmt(g181IncrAmt[i]);
				

				if (g015IncrQty[i] != null)
					model.setG015IncrQty(g015IncrQty[i]);
				if (g015IncrAmt[i] != null)
					model.setG015IncrAmt(g015IncrAmt[i]);
				
				if (g015ExptQty[i] != null)
					model.setG015ExptQty(g015ExptQty[i]);				
				if (g015ExptAmt[i] != null)
					model.setG015ExptAmt(g015ExptAmt[i]);
				
				if (g015DcntQty[i] != null)
					model.setG015DcntQty(g015DcntQty[i]);
				if (g015DcntAmt[i] != null)
					model.setG015DcntAmt(g015DcntAmt[i]);
				
				if (g015BillQty[i] != null)
					model.setG015BillQty(g015BillQty[i]);
				if (g015BillAmt[i] != null)
					model.setG015BillAmt(g015BillAmt[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getYearlyCollectionByRHQVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return YearlyCollectionByRHQVO[]
	 */
	public YearlyCollectionByRHQVO[] getYearlyCollectionByRHQVOs(){
		YearlyCollectionByRHQVO[] vos = (YearlyCollectionByRHQVO[])models.toArray(new YearlyCollectionByRHQVO[models.size()]);
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
		this.g030ExptAmt = this.g030ExptAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g181BillQty = this.g181BillQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g180ExptQty = this.g180ExptQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g181IncrQty = this.g181IncrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g180BillAmt = this.g180BillAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g090IncrAmt = this.g090IncrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g090DcntQty = this.g090DcntQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g060BillQty = this.g060BillQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g090DcntAmt = this.g090DcntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g181DcntQty = this.g181DcntQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.bzcTrfCurrCd = this.bzcTrfCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.trfCdList = this.trfCdList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g060IncrAmt = this.g060IncrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g030IncrAmt = this.g030IncrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g060DcntQty = this.g060DcntQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g090ExptAmt = this.g090ExptAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g090IncrQty = this.g090IncrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g180IncrAmt = this.g180IncrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g090BillQty = this.g090BillQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCdList = this.ofcCdList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g180ExptAmt = this.g180ExptAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpFlg = this.grpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g060ExptAmt = this.g060ExptAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpList = this.cntrTpList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fYear = this.fYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g030BillAmt = this.g030BillAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g180DcntQty = this.g180DcntQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g030DcntQty = this.g030DcntQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.backendjobKey = this.backendjobKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currFlg = this.currFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g180IncrQty = this.g180IncrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g060DcntAmt = this.g060DcntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g090BillAmt = this.g090BillAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g180BillQty = this.g180BillQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g060IncrQty = this.g060IncrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g180DcntAmt = this.g180DcntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g030ExptQty = this.g030ExptQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uclmFlg = this.uclmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g030DcntAmt = this.g030DcntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g181ExptQty = this.g181ExptQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcRhqCd = this.ofcRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g060BillAmt = this.g060BillAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g181DcntAmt = this.g181DcntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g030BillQty = this.g030BillQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCntrTpCd = this.dmdtCntrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g030IncrQty = this.g030IncrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g181BillAmt = this.g181BillAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcFlg = this.ofcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g181ExptAmt = this.g181ExptAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g090ExptQty = this.g090ExptQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.backendjobId = this.backendjobId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g060ExptQty = this.g060ExptQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g181IncrAmt = this.g181IncrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.g015IncrQty = this.g015IncrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g015IncrAmt = this.g015IncrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g015ExptQty = this.g015ExptQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g015ExptAmt = this.g015ExptAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g015DcntQty = this.g015DcntQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g015DcntAmt = this.g015DcntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g015BillQty = this.g015BillQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g015BillAmt = this.g015BillAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
