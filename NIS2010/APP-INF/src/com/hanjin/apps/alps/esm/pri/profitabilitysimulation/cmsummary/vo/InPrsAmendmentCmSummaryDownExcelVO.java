/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InPrsAmendmentCmSummaryDownExcelVO.java
*@FileTitle : InPrsAmendmentCmSummaryDownExcelVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.04
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.11.04 송민석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo;

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
 * @author 송민석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InPrsAmendmentCmSummaryDownExcelVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InPrsAmendmentCmSummaryDownExcelVO> models = new ArrayList<InPrsAmendmentCmSummaryDownExcelVO>();
	
	/* Column Info */
	private String searchedContractType = null;
	/* Column Info */
	private String searchedCrgTpAk = null;
	/* Column Info */
	private String searchedCtrtEffWk = null;
	/* Column Info */
	private String searchedCtrtExpYr = null;
	/* Column Info */
	private String excelTp = null;
	/* Column Info */
	private String searchedCtrtExpWk = null;
	/* Column Info */
	private String searchedRfrcExpYr = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String searchedPfmcUnit = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String searchedCrgTpRf = null;
	/* Column Info */
	private String searchedRfrcExpWk = null;
	/* Column Info */
	private String searchedPropSrepCd = null;
	/* Column Info */
	private String searchedSmrExpYr = null;
	/* Column Info */
	private String searchedSmrEffYr = null;
	/* Column Info */
	private String searchedPropSrepNm = null;
	/* Column Info */
	private String searchedRlaneCd = null;
	/* Column Info */
	private String searchedSmrEffWk = null;
	/* Column Info */
	private String searchedCustList = null;
	/* Column Info */
	private String searchedSubTrdCd = null;
	/* Column Info */
	private String searchedCrgTpDg = null;
	/* Column Info */
	private String searchedPropAproOfcCd = null;
	/* Column Info */
	private String searchedRfrcEffYr = null;
	/* Column Info */
	private String searchedCrgTpBb = null;
	/* Column Info */
	private String searchedRfrcEffWk = null;
	/* Column Info */
	private String searchedTrdCd = null;
	/* Column Info */
	private String searchedCustomerType = null;
	/* Column Info */
	private String searchedCtrtEffYr = null;
	/* Column Info */
	private String searchedCrgTpDry = null;
	/* Column Info */
	private String searchedDirCd = null;
	/* Column Info */
	private String searchedSmrExpWk = null;
	/* Column Info */
	private String searchedSvcScpCd = null;
	/* Column Info */
	private String searchedPropOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InPrsAmendmentCmSummaryDownExcelVO() {}

	public InPrsAmendmentCmSummaryDownExcelVO(String ibflag, String pagerows, String searchedSvcScpCd, String searchedCustomerType, String searchedPropAproOfcCd, String searchedContractType, String searchedPfmcUnit, String searchedCtrtEffYr, String searchedCtrtEffWk, String searchedCtrtExpYr, String searchedCtrtExpWk, String searchedSmrEffYr, String searchedSmrEffWk, String searchedSmrExpYr, String searchedSmrExpWk, String searchedRfrcEffYr, String searchedRfrcEffWk, String searchedRfrcExpYr, String searchedRfrcExpWk, String searchedPropOfcCd, String searchedPropSrepCd, String searchedPropSrepNm, String searchedCustList, String searchedTrdCd, String searchedDirCd, String searchedSubTrdCd, String searchedRlaneCd, String searchedCrgTpDry, String searchedCrgTpDg, String searchedCrgTpRf, String searchedCrgTpAk, String searchedCrgTpBb, String excelTp) {
		this.searchedContractType = searchedContractType;
		this.searchedCrgTpAk = searchedCrgTpAk;
		this.searchedCtrtEffWk = searchedCtrtEffWk;
		this.searchedCtrtExpYr = searchedCtrtExpYr;
		this.excelTp = excelTp;
		this.searchedCtrtExpWk = searchedCtrtExpWk;
		this.searchedRfrcExpYr = searchedRfrcExpYr;
		this.pagerows = pagerows;
		this.searchedPfmcUnit = searchedPfmcUnit;
		this.ibflag = ibflag;
		this.searchedCrgTpRf = searchedCrgTpRf;
		this.searchedRfrcExpWk = searchedRfrcExpWk;
		this.searchedPropSrepCd = searchedPropSrepCd;
		this.searchedSmrExpYr = searchedSmrExpYr;
		this.searchedSmrEffYr = searchedSmrEffYr;
		this.searchedPropSrepNm = searchedPropSrepNm;
		this.searchedRlaneCd = searchedRlaneCd;
		this.searchedSmrEffWk = searchedSmrEffWk;
		this.searchedCustList = searchedCustList;
		this.searchedSubTrdCd = searchedSubTrdCd;
		this.searchedCrgTpDg = searchedCrgTpDg;
		this.searchedPropAproOfcCd = searchedPropAproOfcCd;
		this.searchedRfrcEffYr = searchedRfrcEffYr;
		this.searchedCrgTpBb = searchedCrgTpBb;
		this.searchedRfrcEffWk = searchedRfrcEffWk;
		this.searchedTrdCd = searchedTrdCd;
		this.searchedCustomerType = searchedCustomerType;
		this.searchedCtrtEffYr = searchedCtrtEffYr;
		this.searchedCrgTpDry = searchedCrgTpDry;
		this.searchedDirCd = searchedDirCd;
		this.searchedSmrExpWk = searchedSmrExpWk;
		this.searchedSvcScpCd = searchedSvcScpCd;
		this.searchedPropOfcCd = searchedPropOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("searched_contract_type", getSearchedContractType());
		this.hashColumns.put("searched_crg_tp_ak", getSearchedCrgTpAk());
		this.hashColumns.put("searched_ctrt_eff_wk", getSearchedCtrtEffWk());
		this.hashColumns.put("searched_ctrt_exp_yr", getSearchedCtrtExpYr());
		this.hashColumns.put("excel_tp", getExcelTp());
		this.hashColumns.put("searched_ctrt_exp_wk", getSearchedCtrtExpWk());
		this.hashColumns.put("searched_rfrc_exp_yr", getSearchedRfrcExpYr());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("searched_pfmc_unit", getSearchedPfmcUnit());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("searched_crg_tp_rf", getSearchedCrgTpRf());
		this.hashColumns.put("searched_rfrc_exp_wk", getSearchedRfrcExpWk());
		this.hashColumns.put("searched_prop_srep_cd", getSearchedPropSrepCd());
		this.hashColumns.put("searched_smr_exp_yr", getSearchedSmrExpYr());
		this.hashColumns.put("searched_smr_eff_yr", getSearchedSmrEffYr());
		this.hashColumns.put("searched_prop_srep_nm", getSearchedPropSrepNm());
		this.hashColumns.put("searched_rlane_cd", getSearchedRlaneCd());
		this.hashColumns.put("searched_smr_eff_wk", getSearchedSmrEffWk());
		this.hashColumns.put("searched_cust_list", getSearchedCustList());
		this.hashColumns.put("searched_sub_trd_cd", getSearchedSubTrdCd());
		this.hashColumns.put("searched_crg_tp_dg", getSearchedCrgTpDg());
		this.hashColumns.put("searched_prop_apro_ofc_cd", getSearchedPropAproOfcCd());
		this.hashColumns.put("searched_rfrc_eff_yr", getSearchedRfrcEffYr());
		this.hashColumns.put("searched_crg_tp_bb", getSearchedCrgTpBb());
		this.hashColumns.put("searched_rfrc_eff_wk", getSearchedRfrcEffWk());
		this.hashColumns.put("searched_trd_cd", getSearchedTrdCd());
		this.hashColumns.put("searched_customer_type", getSearchedCustomerType());
		this.hashColumns.put("searched_ctrt_eff_yr", getSearchedCtrtEffYr());
		this.hashColumns.put("searched_crg_tp_dry", getSearchedCrgTpDry());
		this.hashColumns.put("searched_dir_cd", getSearchedDirCd());
		this.hashColumns.put("searched_smr_exp_wk", getSearchedSmrExpWk());
		this.hashColumns.put("searched_svc_scp_cd", getSearchedSvcScpCd());
		this.hashColumns.put("searched_prop_ofc_cd", getSearchedPropOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("searched_contract_type", "searchedContractType");
		this.hashFields.put("searched_crg_tp_ak", "searchedCrgTpAk");
		this.hashFields.put("searched_ctrt_eff_wk", "searchedCtrtEffWk");
		this.hashFields.put("searched_ctrt_exp_yr", "searchedCtrtExpYr");
		this.hashFields.put("excel_tp", "excelTp");
		this.hashFields.put("searched_ctrt_exp_wk", "searchedCtrtExpWk");
		this.hashFields.put("searched_rfrc_exp_yr", "searchedRfrcExpYr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("searched_pfmc_unit", "searchedPfmcUnit");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("searched_crg_tp_rf", "searchedCrgTpRf");
		this.hashFields.put("searched_rfrc_exp_wk", "searchedRfrcExpWk");
		this.hashFields.put("searched_prop_srep_cd", "searchedPropSrepCd");
		this.hashFields.put("searched_smr_exp_yr", "searchedSmrExpYr");
		this.hashFields.put("searched_smr_eff_yr", "searchedSmrEffYr");
		this.hashFields.put("searched_prop_srep_nm", "searchedPropSrepNm");
		this.hashFields.put("searched_rlane_cd", "searchedRlaneCd");
		this.hashFields.put("searched_smr_eff_wk", "searchedSmrEffWk");
		this.hashFields.put("searched_cust_list", "searchedCustList");
		this.hashFields.put("searched_sub_trd_cd", "searchedSubTrdCd");
		this.hashFields.put("searched_crg_tp_dg", "searchedCrgTpDg");
		this.hashFields.put("searched_prop_apro_ofc_cd", "searchedPropAproOfcCd");
		this.hashFields.put("searched_rfrc_eff_yr", "searchedRfrcEffYr");
		this.hashFields.put("searched_crg_tp_bb", "searchedCrgTpBb");
		this.hashFields.put("searched_rfrc_eff_wk", "searchedRfrcEffWk");
		this.hashFields.put("searched_trd_cd", "searchedTrdCd");
		this.hashFields.put("searched_customer_type", "searchedCustomerType");
		this.hashFields.put("searched_ctrt_eff_yr", "searchedCtrtEffYr");
		this.hashFields.put("searched_crg_tp_dry", "searchedCrgTpDry");
		this.hashFields.put("searched_dir_cd", "searchedDirCd");
		this.hashFields.put("searched_smr_exp_wk", "searchedSmrExpWk");
		this.hashFields.put("searched_svc_scp_cd", "searchedSvcScpCd");
		this.hashFields.put("searched_prop_ofc_cd", "searchedPropOfcCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return searchedContractType
	 */
	public String getSearchedContractType() {
		return this.searchedContractType;
	}
	
	/**
	 * Column Info
	 * @return searchedCrgTpAk
	 */
	public String getSearchedCrgTpAk() {
		return this.searchedCrgTpAk;
	}
	
	/**
	 * Column Info
	 * @return searchedCtrtEffWk
	 */
	public String getSearchedCtrtEffWk() {
		return this.searchedCtrtEffWk;
	}
	
	/**
	 * Column Info
	 * @return searchedCtrtExpYr
	 */
	public String getSearchedCtrtExpYr() {
		return this.searchedCtrtExpYr;
	}
	
	/**
	 * Column Info
	 * @return excelTp
	 */
	public String getExcelTp() {
		return this.excelTp;
	}
	
	/**
	 * Column Info
	 * @return searchedCtrtExpWk
	 */
	public String getSearchedCtrtExpWk() {
		return this.searchedCtrtExpWk;
	}
	
	/**
	 * Column Info
	 * @return searchedRfrcExpYr
	 */
	public String getSearchedRfrcExpYr() {
		return this.searchedRfrcExpYr;
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
	 * @return searchedPfmcUnit
	 */
	public String getSearchedPfmcUnit() {
		return this.searchedPfmcUnit;
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
	 * @return searchedCrgTpRf
	 */
	public String getSearchedCrgTpRf() {
		return this.searchedCrgTpRf;
	}
	
	/**
	 * Column Info
	 * @return searchedRfrcExpWk
	 */
	public String getSearchedRfrcExpWk() {
		return this.searchedRfrcExpWk;
	}
	
	/**
	 * Column Info
	 * @return searchedPropSrepCd
	 */
	public String getSearchedPropSrepCd() {
		return this.searchedPropSrepCd;
	}
	
	/**
	 * Column Info
	 * @return searchedSmrExpYr
	 */
	public String getSearchedSmrExpYr() {
		return this.searchedSmrExpYr;
	}
	
	/**
	 * Column Info
	 * @return searchedSmrEffYr
	 */
	public String getSearchedSmrEffYr() {
		return this.searchedSmrEffYr;
	}
	
	/**
	 * Column Info
	 * @return searchedPropSrepNm
	 */
	public String getSearchedPropSrepNm() {
		return this.searchedPropSrepNm;
	}
	
	/**
	 * Column Info
	 * @return searchedRlaneCd
	 */
	public String getSearchedRlaneCd() {
		return this.searchedRlaneCd;
	}
	
	/**
	 * Column Info
	 * @return searchedSmrEffWk
	 */
	public String getSearchedSmrEffWk() {
		return this.searchedSmrEffWk;
	}
	
	/**
	 * Column Info
	 * @return searchedCustList
	 */
	public String getSearchedCustList() {
		return this.searchedCustList;
	}
	
	/**
	 * Column Info
	 * @return searchedSubTrdCd
	 */
	public String getSearchedSubTrdCd() {
		return this.searchedSubTrdCd;
	}
	
	/**
	 * Column Info
	 * @return searchedCrgTpDg
	 */
	public String getSearchedCrgTpDg() {
		return this.searchedCrgTpDg;
	}
	
	/**
	 * Column Info
	 * @return searchedPropAproOfcCd
	 */
	public String getSearchedPropAproOfcCd() {
		return this.searchedPropAproOfcCd;
	}
	
	/**
	 * Column Info
	 * @return searchedRfrcEffYr
	 */
	public String getSearchedRfrcEffYr() {
		return this.searchedRfrcEffYr;
	}
	
	/**
	 * Column Info
	 * @return searchedCrgTpBb
	 */
	public String getSearchedCrgTpBb() {
		return this.searchedCrgTpBb;
	}
	
	/**
	 * Column Info
	 * @return searchedRfrcEffWk
	 */
	public String getSearchedRfrcEffWk() {
		return this.searchedRfrcEffWk;
	}
	
	/**
	 * Column Info
	 * @return searchedTrdCd
	 */
	public String getSearchedTrdCd() {
		return this.searchedTrdCd;
	}
	
	/**
	 * Column Info
	 * @return searchedCustomerType
	 */
	public String getSearchedCustomerType() {
		return this.searchedCustomerType;
	}
	
	/**
	 * Column Info
	 * @return searchedCtrtEffYr
	 */
	public String getSearchedCtrtEffYr() {
		return this.searchedCtrtEffYr;
	}
	
	/**
	 * Column Info
	 * @return searchedCrgTpDry
	 */
	public String getSearchedCrgTpDry() {
		return this.searchedCrgTpDry;
	}
	
	/**
	 * Column Info
	 * @return searchedDirCd
	 */
	public String getSearchedDirCd() {
		return this.searchedDirCd;
	}
	
	/**
	 * Column Info
	 * @return searchedSmrExpWk
	 */
	public String getSearchedSmrExpWk() {
		return this.searchedSmrExpWk;
	}
	
	/**
	 * Column Info
	 * @return searchedSvcScpCd
	 */
	public String getSearchedSvcScpCd() {
		return this.searchedSvcScpCd;
	}
	
	/**
	 * Column Info
	 * @return searchedPropOfcCd
	 */
	public String getSearchedPropOfcCd() {
		return this.searchedPropOfcCd;
	}
	

	/**
	 * Column Info
	 * @param searchedContractType
	 */
	public void setSearchedContractType(String searchedContractType) {
		this.searchedContractType = searchedContractType;
	}
	
	/**
	 * Column Info
	 * @param searchedCrgTpAk
	 */
	public void setSearchedCrgTpAk(String searchedCrgTpAk) {
		this.searchedCrgTpAk = searchedCrgTpAk;
	}
	
	/**
	 * Column Info
	 * @param searchedCtrtEffWk
	 */
	public void setSearchedCtrtEffWk(String searchedCtrtEffWk) {
		this.searchedCtrtEffWk = searchedCtrtEffWk;
	}
	
	/**
	 * Column Info
	 * @param searchedCtrtExpYr
	 */
	public void setSearchedCtrtExpYr(String searchedCtrtExpYr) {
		this.searchedCtrtExpYr = searchedCtrtExpYr;
	}
	
	/**
	 * Column Info
	 * @param excelTp
	 */
	public void setExcelTp(String excelTp) {
		this.excelTp = excelTp;
	}
	
	/**
	 * Column Info
	 * @param searchedCtrtExpWk
	 */
	public void setSearchedCtrtExpWk(String searchedCtrtExpWk) {
		this.searchedCtrtExpWk = searchedCtrtExpWk;
	}
	
	/**
	 * Column Info
	 * @param searchedRfrcExpYr
	 */
	public void setSearchedRfrcExpYr(String searchedRfrcExpYr) {
		this.searchedRfrcExpYr = searchedRfrcExpYr;
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
	 * @param searchedPfmcUnit
	 */
	public void setSearchedPfmcUnit(String searchedPfmcUnit) {
		this.searchedPfmcUnit = searchedPfmcUnit;
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
	 * @param searchedCrgTpRf
	 */
	public void setSearchedCrgTpRf(String searchedCrgTpRf) {
		this.searchedCrgTpRf = searchedCrgTpRf;
	}
	
	/**
	 * Column Info
	 * @param searchedRfrcExpWk
	 */
	public void setSearchedRfrcExpWk(String searchedRfrcExpWk) {
		this.searchedRfrcExpWk = searchedRfrcExpWk;
	}
	
	/**
	 * Column Info
	 * @param searchedPropSrepCd
	 */
	public void setSearchedPropSrepCd(String searchedPropSrepCd) {
		this.searchedPropSrepCd = searchedPropSrepCd;
	}
	
	/**
	 * Column Info
	 * @param searchedSmrExpYr
	 */
	public void setSearchedSmrExpYr(String searchedSmrExpYr) {
		this.searchedSmrExpYr = searchedSmrExpYr;
	}
	
	/**
	 * Column Info
	 * @param searchedSmrEffYr
	 */
	public void setSearchedSmrEffYr(String searchedSmrEffYr) {
		this.searchedSmrEffYr = searchedSmrEffYr;
	}
	
	/**
	 * Column Info
	 * @param searchedPropSrepNm
	 */
	public void setSearchedPropSrepNm(String searchedPropSrepNm) {
		this.searchedPropSrepNm = searchedPropSrepNm;
	}
	
	/**
	 * Column Info
	 * @param searchedRlaneCd
	 */
	public void setSearchedRlaneCd(String searchedRlaneCd) {
		this.searchedRlaneCd = searchedRlaneCd;
	}
	
	/**
	 * Column Info
	 * @param searchedSmrEffWk
	 */
	public void setSearchedSmrEffWk(String searchedSmrEffWk) {
		this.searchedSmrEffWk = searchedSmrEffWk;
	}
	
	/**
	 * Column Info
	 * @param searchedCustList
	 */
	public void setSearchedCustList(String searchedCustList) {
		this.searchedCustList = searchedCustList;
	}
	
	/**
	 * Column Info
	 * @param searchedSubTrdCd
	 */
	public void setSearchedSubTrdCd(String searchedSubTrdCd) {
		this.searchedSubTrdCd = searchedSubTrdCd;
	}
	
	/**
	 * Column Info
	 * @param searchedCrgTpDg
	 */
	public void setSearchedCrgTpDg(String searchedCrgTpDg) {
		this.searchedCrgTpDg = searchedCrgTpDg;
	}
	
	/**
	 * Column Info
	 * @param searchedPropAproOfcCd
	 */
	public void setSearchedPropAproOfcCd(String searchedPropAproOfcCd) {
		this.searchedPropAproOfcCd = searchedPropAproOfcCd;
	}
	
	/**
	 * Column Info
	 * @param searchedRfrcEffYr
	 */
	public void setSearchedRfrcEffYr(String searchedRfrcEffYr) {
		this.searchedRfrcEffYr = searchedRfrcEffYr;
	}
	
	/**
	 * Column Info
	 * @param searchedCrgTpBb
	 */
	public void setSearchedCrgTpBb(String searchedCrgTpBb) {
		this.searchedCrgTpBb = searchedCrgTpBb;
	}
	
	/**
	 * Column Info
	 * @param searchedRfrcEffWk
	 */
	public void setSearchedRfrcEffWk(String searchedRfrcEffWk) {
		this.searchedRfrcEffWk = searchedRfrcEffWk;
	}
	
	/**
	 * Column Info
	 * @param searchedTrdCd
	 */
	public void setSearchedTrdCd(String searchedTrdCd) {
		this.searchedTrdCd = searchedTrdCd;
	}
	
	/**
	 * Column Info
	 * @param searchedCustomerType
	 */
	public void setSearchedCustomerType(String searchedCustomerType) {
		this.searchedCustomerType = searchedCustomerType;
	}
	
	/**
	 * Column Info
	 * @param searchedCtrtEffYr
	 */
	public void setSearchedCtrtEffYr(String searchedCtrtEffYr) {
		this.searchedCtrtEffYr = searchedCtrtEffYr;
	}
	
	/**
	 * Column Info
	 * @param searchedCrgTpDry
	 */
	public void setSearchedCrgTpDry(String searchedCrgTpDry) {
		this.searchedCrgTpDry = searchedCrgTpDry;
	}
	
	/**
	 * Column Info
	 * @param searchedDirCd
	 */
	public void setSearchedDirCd(String searchedDirCd) {
		this.searchedDirCd = searchedDirCd;
	}
	
	/**
	 * Column Info
	 * @param searchedSmrExpWk
	 */
	public void setSearchedSmrExpWk(String searchedSmrExpWk) {
		this.searchedSmrExpWk = searchedSmrExpWk;
	}
	
	/**
	 * Column Info
	 * @param searchedSvcScpCd
	 */
	public void setSearchedSvcScpCd(String searchedSvcScpCd) {
		this.searchedSvcScpCd = searchedSvcScpCd;
	}
	
	/**
	 * Column Info
	 * @param searchedPropOfcCd
	 */
	public void setSearchedPropOfcCd(String searchedPropOfcCd) {
		this.searchedPropOfcCd = searchedPropOfcCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSearchedContractType(JSPUtil.getParameter(request, "searched_contract_type", ""));
		setSearchedCrgTpAk(JSPUtil.getParameter(request, "searched_crg_tp_ak", ""));
		setSearchedCtrtEffWk(JSPUtil.getParameter(request, "searched_ctrt_eff_wk", ""));
		setSearchedCtrtExpYr(JSPUtil.getParameter(request, "searched_ctrt_exp_yr", ""));
		setExcelTp(JSPUtil.getParameter(request, "excel_tp", ""));
		setSearchedCtrtExpWk(JSPUtil.getParameter(request, "searched_ctrt_exp_wk", ""));
		setSearchedRfrcExpYr(JSPUtil.getParameter(request, "searched_rfrc_exp_yr", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSearchedPfmcUnit(JSPUtil.getParameter(request, "searched_pfmc_unit", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSearchedCrgTpRf(JSPUtil.getParameter(request, "searched_crg_tp_rf", ""));
		setSearchedRfrcExpWk(JSPUtil.getParameter(request, "searched_rfrc_exp_wk", ""));
		setSearchedPropSrepCd(JSPUtil.getParameter(request, "searched_prop_srep_cd", ""));
		setSearchedSmrExpYr(JSPUtil.getParameter(request, "searched_smr_exp_yr", ""));
		setSearchedSmrEffYr(JSPUtil.getParameter(request, "searched_smr_eff_yr", ""));
		setSearchedPropSrepNm(JSPUtil.getParameter(request, "searched_prop_srep_nm", ""));
		setSearchedRlaneCd(JSPUtil.getParameter(request, "searched_rlane_cd", ""));
		setSearchedSmrEffWk(JSPUtil.getParameter(request, "searched_smr_eff_wk", ""));
		setSearchedCustList(JSPUtil.getParameter(request, "searched_cust_list", ""));
		setSearchedSubTrdCd(JSPUtil.getParameter(request, "searched_sub_trd_cd", ""));
		setSearchedCrgTpDg(JSPUtil.getParameter(request, "searched_crg_tp_dg", ""));
		setSearchedPropAproOfcCd(JSPUtil.getParameter(request, "searched_prop_apro_ofc_cd", ""));
		setSearchedRfrcEffYr(JSPUtil.getParameter(request, "searched_rfrc_eff_yr", ""));
		setSearchedCrgTpBb(JSPUtil.getParameter(request, "searched_crg_tp_bb", ""));
		setSearchedRfrcEffWk(JSPUtil.getParameter(request, "searched_rfrc_eff_wk", ""));
		setSearchedTrdCd(JSPUtil.getParameter(request, "searched_trd_cd", ""));
		setSearchedCustomerType(JSPUtil.getParameter(request, "searched_customer_type", ""));
		setSearchedCtrtEffYr(JSPUtil.getParameter(request, "searched_ctrt_eff_yr", ""));
		setSearchedCrgTpDry(JSPUtil.getParameter(request, "searched_crg_tp_dry", ""));
		setSearchedDirCd(JSPUtil.getParameter(request, "searched_dir_cd", ""));
		setSearchedSmrExpWk(JSPUtil.getParameter(request, "searched_smr_exp_wk", ""));
		setSearchedSvcScpCd(JSPUtil.getParameter(request, "searched_svc_scp_cd", ""));
		setSearchedPropOfcCd(JSPUtil.getParameter(request, "searched_prop_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InPrsAmendmentCmSummaryDownExcelVO[]
	 */
	public InPrsAmendmentCmSummaryDownExcelVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InPrsAmendmentCmSummaryDownExcelVO[]
	 */
	public InPrsAmendmentCmSummaryDownExcelVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InPrsAmendmentCmSummaryDownExcelVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] searchedContractType = (JSPUtil.getParameter(request, prefix	+ "searched_contract_type", length));
			String[] searchedCrgTpAk = (JSPUtil.getParameter(request, prefix	+ "searched_crg_tp_ak", length));
			String[] searchedCtrtEffWk = (JSPUtil.getParameter(request, prefix	+ "searched_ctrt_eff_wk", length));
			String[] searchedCtrtExpYr = (JSPUtil.getParameter(request, prefix	+ "searched_ctrt_exp_yr", length));
			String[] excelTp = (JSPUtil.getParameter(request, prefix	+ "excel_tp", length));
			String[] searchedCtrtExpWk = (JSPUtil.getParameter(request, prefix	+ "searched_ctrt_exp_wk", length));
			String[] searchedRfrcExpYr = (JSPUtil.getParameter(request, prefix	+ "searched_rfrc_exp_yr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] searchedPfmcUnit = (JSPUtil.getParameter(request, prefix	+ "searched_pfmc_unit", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] searchedCrgTpRf = (JSPUtil.getParameter(request, prefix	+ "searched_crg_tp_rf", length));
			String[] searchedRfrcExpWk = (JSPUtil.getParameter(request, prefix	+ "searched_rfrc_exp_wk", length));
			String[] searchedPropSrepCd = (JSPUtil.getParameter(request, prefix	+ "searched_prop_srep_cd", length));
			String[] searchedSmrExpYr = (JSPUtil.getParameter(request, prefix	+ "searched_smr_exp_yr", length));
			String[] searchedSmrEffYr = (JSPUtil.getParameter(request, prefix	+ "searched_smr_eff_yr", length));
			String[] searchedPropSrepNm = (JSPUtil.getParameter(request, prefix	+ "searched_prop_srep_nm", length));
			String[] searchedRlaneCd = (JSPUtil.getParameter(request, prefix	+ "searched_rlane_cd", length));
			String[] searchedSmrEffWk = (JSPUtil.getParameter(request, prefix	+ "searched_smr_eff_wk", length));
			String[] searchedCustList = (JSPUtil.getParameter(request, prefix	+ "searched_cust_list", length));
			String[] searchedSubTrdCd = (JSPUtil.getParameter(request, prefix	+ "searched_sub_trd_cd", length));
			String[] searchedCrgTpDg = (JSPUtil.getParameter(request, prefix	+ "searched_crg_tp_dg", length));
			String[] searchedPropAproOfcCd = (JSPUtil.getParameter(request, prefix	+ "searched_prop_apro_ofc_cd", length));
			String[] searchedRfrcEffYr = (JSPUtil.getParameter(request, prefix	+ "searched_rfrc_eff_yr", length));
			String[] searchedCrgTpBb = (JSPUtil.getParameter(request, prefix	+ "searched_crg_tp_bb", length));
			String[] searchedRfrcEffWk = (JSPUtil.getParameter(request, prefix	+ "searched_rfrc_eff_wk", length));
			String[] searchedTrdCd = (JSPUtil.getParameter(request, prefix	+ "searched_trd_cd", length));
			String[] searchedCustomerType = (JSPUtil.getParameter(request, prefix	+ "searched_customer_type", length));
			String[] searchedCtrtEffYr = (JSPUtil.getParameter(request, prefix	+ "searched_ctrt_eff_yr", length));
			String[] searchedCrgTpDry = (JSPUtil.getParameter(request, prefix	+ "searched_crg_tp_dry", length));
			String[] searchedDirCd = (JSPUtil.getParameter(request, prefix	+ "searched_dir_cd", length));
			String[] searchedSmrExpWk = (JSPUtil.getParameter(request, prefix	+ "searched_smr_exp_wk", length));
			String[] searchedSvcScpCd = (JSPUtil.getParameter(request, prefix	+ "searched_svc_scp_cd", length));
			String[] searchedPropOfcCd = (JSPUtil.getParameter(request, prefix	+ "searched_prop_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new InPrsAmendmentCmSummaryDownExcelVO();
				if (searchedContractType[i] != null)
					model.setSearchedContractType(searchedContractType[i]);
				if (searchedCrgTpAk[i] != null)
					model.setSearchedCrgTpAk(searchedCrgTpAk[i]);
				if (searchedCtrtEffWk[i] != null)
					model.setSearchedCtrtEffWk(searchedCtrtEffWk[i]);
				if (searchedCtrtExpYr[i] != null)
					model.setSearchedCtrtExpYr(searchedCtrtExpYr[i]);
				if (excelTp[i] != null)
					model.setExcelTp(excelTp[i]);
				if (searchedCtrtExpWk[i] != null)
					model.setSearchedCtrtExpWk(searchedCtrtExpWk[i]);
				if (searchedRfrcExpYr[i] != null)
					model.setSearchedRfrcExpYr(searchedRfrcExpYr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (searchedPfmcUnit[i] != null)
					model.setSearchedPfmcUnit(searchedPfmcUnit[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (searchedCrgTpRf[i] != null)
					model.setSearchedCrgTpRf(searchedCrgTpRf[i]);
				if (searchedRfrcExpWk[i] != null)
					model.setSearchedRfrcExpWk(searchedRfrcExpWk[i]);
				if (searchedPropSrepCd[i] != null)
					model.setSearchedPropSrepCd(searchedPropSrepCd[i]);
				if (searchedSmrExpYr[i] != null)
					model.setSearchedSmrExpYr(searchedSmrExpYr[i]);
				if (searchedSmrEffYr[i] != null)
					model.setSearchedSmrEffYr(searchedSmrEffYr[i]);
				if (searchedPropSrepNm[i] != null)
					model.setSearchedPropSrepNm(searchedPropSrepNm[i]);
				if (searchedRlaneCd[i] != null)
					model.setSearchedRlaneCd(searchedRlaneCd[i]);
				if (searchedSmrEffWk[i] != null)
					model.setSearchedSmrEffWk(searchedSmrEffWk[i]);
				if (searchedCustList[i] != null)
					model.setSearchedCustList(searchedCustList[i]);
				if (searchedSubTrdCd[i] != null)
					model.setSearchedSubTrdCd(searchedSubTrdCd[i]);
				if (searchedCrgTpDg[i] != null)
					model.setSearchedCrgTpDg(searchedCrgTpDg[i]);
				if (searchedPropAproOfcCd[i] != null)
					model.setSearchedPropAproOfcCd(searchedPropAproOfcCd[i]);
				if (searchedRfrcEffYr[i] != null)
					model.setSearchedRfrcEffYr(searchedRfrcEffYr[i]);
				if (searchedCrgTpBb[i] != null)
					model.setSearchedCrgTpBb(searchedCrgTpBb[i]);
				if (searchedRfrcEffWk[i] != null)
					model.setSearchedRfrcEffWk(searchedRfrcEffWk[i]);
				if (searchedTrdCd[i] != null)
					model.setSearchedTrdCd(searchedTrdCd[i]);
				if (searchedCustomerType[i] != null)
					model.setSearchedCustomerType(searchedCustomerType[i]);
				if (searchedCtrtEffYr[i] != null)
					model.setSearchedCtrtEffYr(searchedCtrtEffYr[i]);
				if (searchedCrgTpDry[i] != null)
					model.setSearchedCrgTpDry(searchedCrgTpDry[i]);
				if (searchedDirCd[i] != null)
					model.setSearchedDirCd(searchedDirCd[i]);
				if (searchedSmrExpWk[i] != null)
					model.setSearchedSmrExpWk(searchedSmrExpWk[i]);
				if (searchedSvcScpCd[i] != null)
					model.setSearchedSvcScpCd(searchedSvcScpCd[i]);
				if (searchedPropOfcCd[i] != null)
					model.setSearchedPropOfcCd(searchedPropOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInPrsAmendmentCmSummaryDownExcelVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InPrsAmendmentCmSummaryDownExcelVO[]
	 */
	public InPrsAmendmentCmSummaryDownExcelVO[] getInPrsAmendmentCmSummaryDownExcelVOs(){
		InPrsAmendmentCmSummaryDownExcelVO[] vos = (InPrsAmendmentCmSummaryDownExcelVO[])models.toArray(new InPrsAmendmentCmSummaryDownExcelVO[models.size()]);
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
		this.searchedContractType = this.searchedContractType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchedCrgTpAk = this.searchedCrgTpAk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchedCtrtEffWk = this.searchedCtrtEffWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchedCtrtExpYr = this.searchedCtrtExpYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.excelTp = this.excelTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchedCtrtExpWk = this.searchedCtrtExpWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchedRfrcExpYr = this.searchedRfrcExpYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchedPfmcUnit = this.searchedPfmcUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchedCrgTpRf = this.searchedCrgTpRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchedRfrcExpWk = this.searchedRfrcExpWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchedPropSrepCd = this.searchedPropSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchedSmrExpYr = this.searchedSmrExpYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchedSmrEffYr = this.searchedSmrEffYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchedPropSrepNm = this.searchedPropSrepNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchedRlaneCd = this.searchedRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchedSmrEffWk = this.searchedSmrEffWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchedCustList = this.searchedCustList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchedSubTrdCd = this.searchedSubTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchedCrgTpDg = this.searchedCrgTpDg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchedPropAproOfcCd = this.searchedPropAproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchedRfrcEffYr = this.searchedRfrcEffYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchedCrgTpBb = this.searchedCrgTpBb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchedRfrcEffWk = this.searchedRfrcEffWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchedTrdCd = this.searchedTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchedCustomerType = this.searchedCustomerType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchedCtrtEffYr = this.searchedCtrtEffYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchedCrgTpDry = this.searchedCrgTpDry .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchedDirCd = this.searchedDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchedSmrExpWk = this.searchedSmrExpWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchedSvcScpCd = this.searchedSvcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchedPropOfcCd = this.searchedPropOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
