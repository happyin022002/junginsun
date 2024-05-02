/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InPrsProposalCmSummaryVO.java
*@FileTitle : InPrsProposalCmSummaryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.06
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.05.06 송민석 
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

public class InPrsProposalCmSummaryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InPrsProposalCmSummaryVO> models = new ArrayList<InPrsProposalCmSummaryVO>();
	
	/* Column Info */
	private String frmCrgTpAk = null;
	/* Column Info */
	private String rgnCd = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String frmCustomerSm = null;
	/* Column Info */
	private String frmDestLocTp = null;
	/* Column Info */
	private String rankOrder = null;
	/* Column Info */
	private String frmStatus = null;
	/* Column Info */
	private String frmContractTypeR = null;
	/* Column Info */
	private String frmProfitLevel = null;
	/* Column Info */
	private String frmContractTypeS = null;
	/* Column Info */
	private String frmContractTypeT = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String grpCode = null;
	/* Column Info */
	private String frmPropSrepCd = null;
	/* Column Info */
	private String frmPfmcUnit = null;
	/* Column Info */
	private String frmCustomerSmCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String frmProfitView = null;
	/* Column Info */
	private String frmCustomerType = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String frmCrgTpDry = null;
	/* Column Info */
	private String frmCrgTpRf = null;
	/* Column Info */
	private String rangeVal = null;
	/* Column Info */
	private String prevDataCol = null;
	/* Column Info */
	private String frmSlaneCd = null;
	/* Column Info */
	private String frmCrgTpDg = null;
	/* Column Info */
	private String frmPropSrepNm = null;
	/* Column Info */
	private String frmPropAproOfcCd = null;
	/* Column Info */
	private String frmOriRoutCd = null;
	/* Column Info */
	private String frmCustList = null;
	/* Column Info */
	private String frmRfaPropNoList = null;
	/* Column Info */
	private String frmCtrtEffDt = null;
	/* Column Info */
	private String frmCrgTpBb = null;
	/* Column Info */
	private String frmPropNoList = null;
	/* Column Info */
	private String frmContractType = null;
	/* Column Info */
	private String oriDestCd = null;
	/* Column Info */
	private String frmOriLocTp = null;
	/* Column Info */
	private String frmSvcScpCd = null;
	/* Column Info */
	private String frmCtrtExpDt = null;
	/* Column Info */
	private String frmDestRoutCd = null;
	/* Column Info */
	private String locTpCd = null;
	/* Column Info */
	private String frmPropOfcCd = null;
	/* Column Info */
	private String frmSummaryItems = null;
	/* Column Info */
	private String newDataCol = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InPrsProposalCmSummaryVO() {}

	public InPrsProposalCmSummaryVO(String ibflag, String pagerows, String frmContractType, String frmPfmcUnit, String frmStatus, String frmProfitView, String frmProfitLevel, String frmSummaryItems, String frmSvcScpCd, String frmCtrtEffDt, String frmCtrtExpDt, String frmPropAproOfcCd, String frmPropOfcCd, String frmPropSrepCd, String frmPropSrepNm, String frmCustomerType, String frmCustomerSm, String frmCustomerSmCd, String frmCrgTpDry, String frmCrgTpDg, String frmCrgTpRf, String frmCrgTpAk, String frmCrgTpBb, String frmCustList, String frmPropNoList, String frmRfaPropNoList, String newDataCol, String prevDataCol, String rankOrder, String grpCode, String rangeVal, String frmContractTypeS, String frmContractTypeR, String frmContractTypeT, String frmOriRoutCd, String frmDestRoutCd, String frmOriLocTp, String frmDestLocTp, String frmSlaneCd, String cntCd, String rgnCd, String locTpCd, String oriDestCd, String svcScpCd) {
		this.frmCrgTpAk = frmCrgTpAk;
		this.rgnCd = rgnCd;
		this.svcScpCd = svcScpCd;
		this.frmCustomerSm = frmCustomerSm;
		this.frmDestLocTp = frmDestLocTp;
		this.rankOrder = rankOrder;
		this.frmStatus = frmStatus;
		this.frmContractTypeR = frmContractTypeR;
		this.frmProfitLevel = frmProfitLevel;
		this.frmContractTypeS = frmContractTypeS;
		this.frmContractTypeT = frmContractTypeT;
		this.pagerows = pagerows;
		this.grpCode = grpCode;
		this.frmPropSrepCd = frmPropSrepCd;
		this.frmPfmcUnit = frmPfmcUnit;
		this.frmCustomerSmCd = frmCustomerSmCd;
		this.ibflag = ibflag;
		this.frmProfitView = frmProfitView;
		this.frmCustomerType = frmCustomerType;
		this.cntCd = cntCd;
		this.frmCrgTpDry = frmCrgTpDry;
		this.frmCrgTpRf = frmCrgTpRf;
		this.rangeVal = rangeVal;
		this.prevDataCol = prevDataCol;
		this.frmSlaneCd = frmSlaneCd;
		this.frmCrgTpDg = frmCrgTpDg;
		this.frmPropSrepNm = frmPropSrepNm;
		this.frmPropAproOfcCd = frmPropAproOfcCd;
		this.frmOriRoutCd = frmOriRoutCd;
		this.frmCustList = frmCustList;
		this.frmRfaPropNoList = frmRfaPropNoList;
		this.frmCtrtEffDt = frmCtrtEffDt;
		this.frmCrgTpBb = frmCrgTpBb;
		this.frmPropNoList = frmPropNoList;
		this.frmContractType = frmContractType;
		this.oriDestCd = oriDestCd;
		this.frmOriLocTp = frmOriLocTp;
		this.frmSvcScpCd = frmSvcScpCd;
		this.frmCtrtExpDt = frmCtrtExpDt;
		this.frmDestRoutCd = frmDestRoutCd;
		this.locTpCd = locTpCd;
		this.frmPropOfcCd = frmPropOfcCd;
		this.frmSummaryItems = frmSummaryItems;
		this.newDataCol = newDataCol;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("frm_crg_tp_ak", getFrmCrgTpAk());
		this.hashColumns.put("rgn_cd", getRgnCd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("frm_customer_sm", getFrmCustomerSm());
		this.hashColumns.put("frm_dest_loc_tp", getFrmDestLocTp());
		this.hashColumns.put("rank_order", getRankOrder());
		this.hashColumns.put("frm_status", getFrmStatus());
		this.hashColumns.put("frm_contract_type_r", getFrmContractTypeR());
		this.hashColumns.put("frm_profit_level", getFrmProfitLevel());
		this.hashColumns.put("frm_contract_type_s", getFrmContractTypeS());
		this.hashColumns.put("frm_contract_type_t", getFrmContractTypeT());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("grp_code", getGrpCode());
		this.hashColumns.put("frm_prop_srep_cd", getFrmPropSrepCd());
		this.hashColumns.put("frm_pfmc_unit", getFrmPfmcUnit());
		this.hashColumns.put("frm_customer_sm_cd", getFrmCustomerSmCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("frm_profit_view", getFrmProfitView());
		this.hashColumns.put("frm_customer_type", getFrmCustomerType());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("frm_crg_tp_dry", getFrmCrgTpDry());
		this.hashColumns.put("frm_crg_tp_rf", getFrmCrgTpRf());
		this.hashColumns.put("range_val", getRangeVal());
		this.hashColumns.put("prev_data_col", getPrevDataCol());
		this.hashColumns.put("frm_slane_cd", getFrmSlaneCd());
		this.hashColumns.put("frm_crg_tp_dg", getFrmCrgTpDg());
		this.hashColumns.put("frm_prop_srep_nm", getFrmPropSrepNm());
		this.hashColumns.put("frm_prop_apro_ofc_cd", getFrmPropAproOfcCd());
		this.hashColumns.put("frm_ori_rout_cd", getFrmOriRoutCd());
		this.hashColumns.put("frm_cust_list", getFrmCustList());
		this.hashColumns.put("frm_rfa_prop_no_list", getFrmRfaPropNoList());
		this.hashColumns.put("frm_ctrt_eff_dt", getFrmCtrtEffDt());
		this.hashColumns.put("frm_crg_tp_bb", getFrmCrgTpBb());
		this.hashColumns.put("frm_prop_no_list", getFrmPropNoList());
		this.hashColumns.put("frm_contract_type", getFrmContractType());
		this.hashColumns.put("ori_dest_cd", getOriDestCd());
		this.hashColumns.put("frm_ori_loc_tp", getFrmOriLocTp());
		this.hashColumns.put("frm_svc_scp_cd", getFrmSvcScpCd());
		this.hashColumns.put("frm_ctrt_exp_dt", getFrmCtrtExpDt());
		this.hashColumns.put("frm_dest_rout_cd", getFrmDestRoutCd());
		this.hashColumns.put("loc_tp_cd", getLocTpCd());
		this.hashColumns.put("frm_prop_ofc_cd", getFrmPropOfcCd());
		this.hashColumns.put("frm_summary_items", getFrmSummaryItems());
		this.hashColumns.put("new_data_col", getNewDataCol());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("frm_crg_tp_ak", "frmCrgTpAk");
		this.hashFields.put("rgn_cd", "rgnCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("frm_customer_sm", "frmCustomerSm");
		this.hashFields.put("frm_dest_loc_tp", "frmDestLocTp");
		this.hashFields.put("rank_order", "rankOrder");
		this.hashFields.put("frm_status", "frmStatus");
		this.hashFields.put("frm_contract_type_r", "frmContractTypeR");
		this.hashFields.put("frm_profit_level", "frmProfitLevel");
		this.hashFields.put("frm_contract_type_s", "frmContractTypeS");
		this.hashFields.put("frm_contract_type_t", "frmContractTypeT");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("grp_code", "grpCode");
		this.hashFields.put("frm_prop_srep_cd", "frmPropSrepCd");
		this.hashFields.put("frm_pfmc_unit", "frmPfmcUnit");
		this.hashFields.put("frm_customer_sm_cd", "frmCustomerSmCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("frm_profit_view", "frmProfitView");
		this.hashFields.put("frm_customer_type", "frmCustomerType");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("frm_crg_tp_dry", "frmCrgTpDry");
		this.hashFields.put("frm_crg_tp_rf", "frmCrgTpRf");
		this.hashFields.put("range_val", "rangeVal");
		this.hashFields.put("prev_data_col", "prevDataCol");
		this.hashFields.put("frm_slane_cd", "frmSlaneCd");
		this.hashFields.put("frm_crg_tp_dg", "frmCrgTpDg");
		this.hashFields.put("frm_prop_srep_nm", "frmPropSrepNm");
		this.hashFields.put("frm_prop_apro_ofc_cd", "frmPropAproOfcCd");
		this.hashFields.put("frm_ori_rout_cd", "frmOriRoutCd");
		this.hashFields.put("frm_cust_list", "frmCustList");
		this.hashFields.put("frm_rfa_prop_no_list", "frmRfaPropNoList");
		this.hashFields.put("frm_ctrt_eff_dt", "frmCtrtEffDt");
		this.hashFields.put("frm_crg_tp_bb", "frmCrgTpBb");
		this.hashFields.put("frm_prop_no_list", "frmPropNoList");
		this.hashFields.put("frm_contract_type", "frmContractType");
		this.hashFields.put("ori_dest_cd", "oriDestCd");
		this.hashFields.put("frm_ori_loc_tp", "frmOriLocTp");
		this.hashFields.put("frm_svc_scp_cd", "frmSvcScpCd");
		this.hashFields.put("frm_ctrt_exp_dt", "frmCtrtExpDt");
		this.hashFields.put("frm_dest_rout_cd", "frmDestRoutCd");
		this.hashFields.put("loc_tp_cd", "locTpCd");
		this.hashFields.put("frm_prop_ofc_cd", "frmPropOfcCd");
		this.hashFields.put("frm_summary_items", "frmSummaryItems");
		this.hashFields.put("new_data_col", "newDataCol");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return frmCrgTpAk
	 */
	public String getFrmCrgTpAk() {
		return this.frmCrgTpAk;
	}
	
	/**
	 * Column Info
	 * @return rgnCd
	 */
	public String getRgnCd() {
		return this.rgnCd;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return frmCustomerSm
	 */
	public String getFrmCustomerSm() {
		return this.frmCustomerSm;
	}
	
	/**
	 * Column Info
	 * @return frmDestLocTp
	 */
	public String getFrmDestLocTp() {
		return this.frmDestLocTp;
	}
	
	/**
	 * Column Info
	 * @return rankOrder
	 */
	public String getRankOrder() {
		return this.rankOrder;
	}
	
	/**
	 * Column Info
	 * @return frmStatus
	 */
	public String getFrmStatus() {
		return this.frmStatus;
	}
	
	/**
	 * Column Info
	 * @return frmContractTypeR
	 */
	public String getFrmContractTypeR() {
		return this.frmContractTypeR;
	}
	
	/**
	 * Column Info
	 * @return frmProfitLevel
	 */
	public String getFrmProfitLevel() {
		return this.frmProfitLevel;
	}
	
	/**
	 * Column Info
	 * @return frmContractTypeS
	 */
	public String getFrmContractTypeS() {
		return this.frmContractTypeS;
	}
	
	/**
	 * Column Info
	 * @return frmContractTypeT
	 */
	public String getFrmContractTypeT() {
		return this.frmContractTypeT;
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
	 * @return grpCode
	 */
	public String getGrpCode() {
		return this.grpCode;
	}
	
	/**
	 * Column Info
	 * @return frmPropSrepCd
	 */
	public String getFrmPropSrepCd() {
		return this.frmPropSrepCd;
	}
	
	/**
	 * Column Info
	 * @return frmPfmcUnit
	 */
	public String getFrmPfmcUnit() {
		return this.frmPfmcUnit;
	}
	
	/**
	 * Column Info
	 * @return frmCustomerSmCd
	 */
	public String getFrmCustomerSmCd() {
		return this.frmCustomerSmCd;
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
	 * @return frmProfitView
	 */
	public String getFrmProfitView() {
		return this.frmProfitView;
	}
	
	/**
	 * Column Info
	 * @return frmCustomerType
	 */
	public String getFrmCustomerType() {
		return this.frmCustomerType;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return frmCrgTpDry
	 */
	public String getFrmCrgTpDry() {
		return this.frmCrgTpDry;
	}
	
	/**
	 * Column Info
	 * @return frmCrgTpRf
	 */
	public String getFrmCrgTpRf() {
		return this.frmCrgTpRf;
	}
	
	/**
	 * Column Info
	 * @return rangeVal
	 */
	public String getRangeVal() {
		return this.rangeVal;
	}
	
	/**
	 * Column Info
	 * @return prevDataCol
	 */
	public String getPrevDataCol() {
		return this.prevDataCol;
	}
	
	/**
	 * Column Info
	 * @return frmSlaneCd
	 */
	public String getFrmSlaneCd() {
		return this.frmSlaneCd;
	}
	
	/**
	 * Column Info
	 * @return frmCrgTpDg
	 */
	public String getFrmCrgTpDg() {
		return this.frmCrgTpDg;
	}
	
	/**
	 * Column Info
	 * @return frmPropSrepNm
	 */
	public String getFrmPropSrepNm() {
		return this.frmPropSrepNm;
	}
	
	/**
	 * Column Info
	 * @return frmPropAproOfcCd
	 */
	public String getFrmPropAproOfcCd() {
		return this.frmPropAproOfcCd;
	}
	
	/**
	 * Column Info
	 * @return frmOriRoutCd
	 */
	public String getFrmOriRoutCd() {
		return this.frmOriRoutCd;
	}
	
	/**
	 * Column Info
	 * @return frmCustList
	 */
	public String getFrmCustList() {
		return this.frmCustList;
	}
	
	/**
	 * Column Info
	 * @return frmRfaPropNoList
	 */
	public String getFrmRfaPropNoList() {
		return this.frmRfaPropNoList;
	}
	
	/**
	 * Column Info
	 * @return frmCtrtEffDt
	 */
	public String getFrmCtrtEffDt() {
		return this.frmCtrtEffDt;
	}
	
	/**
	 * Column Info
	 * @return frmCrgTpBb
	 */
	public String getFrmCrgTpBb() {
		return this.frmCrgTpBb;
	}
	
	/**
	 * Column Info
	 * @return frmPropNoList
	 */
	public String getFrmPropNoList() {
		return this.frmPropNoList;
	}
	
	/**
	 * Column Info
	 * @return frmContractType
	 */
	public String getFrmContractType() {
		return this.frmContractType;
	}
	
	/**
	 * Column Info
	 * @return oriDestCd
	 */
	public String getOriDestCd() {
		return this.oriDestCd;
	}
	
	/**
	 * Column Info
	 * @return frmOriLocTp
	 */
	public String getFrmOriLocTp() {
		return this.frmOriLocTp;
	}
	
	/**
	 * Column Info
	 * @return frmSvcScpCd
	 */
	public String getFrmSvcScpCd() {
		return this.frmSvcScpCd;
	}
	
	/**
	 * Column Info
	 * @return frmCtrtExpDt
	 */
	public String getFrmCtrtExpDt() {
		return this.frmCtrtExpDt;
	}
	
	/**
	 * Column Info
	 * @return frmDestRoutCd
	 */
	public String getFrmDestRoutCd() {
		return this.frmDestRoutCd;
	}
	
	/**
	 * Column Info
	 * @return locTpCd
	 */
	public String getLocTpCd() {
		return this.locTpCd;
	}
	
	/**
	 * Column Info
	 * @return frmPropOfcCd
	 */
	public String getFrmPropOfcCd() {
		return this.frmPropOfcCd;
	}
	
	/**
	 * Column Info
	 * @return frmSummaryItems
	 */
	public String getFrmSummaryItems() {
		return this.frmSummaryItems;
	}
	
	/**
	 * Column Info
	 * @return newDataCol
	 */
	public String getNewDataCol() {
		return this.newDataCol;
	}
	

	/**
	 * Column Info
	 * @param frmCrgTpAk
	 */
	public void setFrmCrgTpAk(String frmCrgTpAk) {
		this.frmCrgTpAk = frmCrgTpAk;
	}
	
	/**
	 * Column Info
	 * @param rgnCd
	 */
	public void setRgnCd(String rgnCd) {
		this.rgnCd = rgnCd;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param frmCustomerSm
	 */
	public void setFrmCustomerSm(String frmCustomerSm) {
		this.frmCustomerSm = frmCustomerSm;
	}
	
	/**
	 * Column Info
	 * @param frmDestLocTp
	 */
	public void setFrmDestLocTp(String frmDestLocTp) {
		this.frmDestLocTp = frmDestLocTp;
	}
	
	/**
	 * Column Info
	 * @param rankOrder
	 */
	public void setRankOrder(String rankOrder) {
		this.rankOrder = rankOrder;
	}
	
	/**
	 * Column Info
	 * @param frmStatus
	 */
	public void setFrmStatus(String frmStatus) {
		this.frmStatus = frmStatus;
	}
	
	/**
	 * Column Info
	 * @param frmContractTypeR
	 */
	public void setFrmContractTypeR(String frmContractTypeR) {
		this.frmContractTypeR = frmContractTypeR;
	}
	
	/**
	 * Column Info
	 * @param frmProfitLevel
	 */
	public void setFrmProfitLevel(String frmProfitLevel) {
		this.frmProfitLevel = frmProfitLevel;
	}
	
	/**
	 * Column Info
	 * @param frmContractTypeS
	 */
	public void setFrmContractTypeS(String frmContractTypeS) {
		this.frmContractTypeS = frmContractTypeS;
	}
	
	/**
	 * Column Info
	 * @param frmContractTypeT
	 */
	public void setFrmContractTypeT(String frmContractTypeT) {
		this.frmContractTypeT = frmContractTypeT;
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
	 * @param grpCode
	 */
	public void setGrpCode(String grpCode) {
		this.grpCode = grpCode;
	}
	
	/**
	 * Column Info
	 * @param frmPropSrepCd
	 */
	public void setFrmPropSrepCd(String frmPropSrepCd) {
		this.frmPropSrepCd = frmPropSrepCd;
	}
	
	/**
	 * Column Info
	 * @param frmPfmcUnit
	 */
	public void setFrmPfmcUnit(String frmPfmcUnit) {
		this.frmPfmcUnit = frmPfmcUnit;
	}
	
	/**
	 * Column Info
	 * @param frmCustomerSmCd
	 */
	public void setFrmCustomerSmCd(String frmCustomerSmCd) {
		this.frmCustomerSmCd = frmCustomerSmCd;
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
	 * @param frmProfitView
	 */
	public void setFrmProfitView(String frmProfitView) {
		this.frmProfitView = frmProfitView;
	}
	
	/**
	 * Column Info
	 * @param frmCustomerType
	 */
	public void setFrmCustomerType(String frmCustomerType) {
		this.frmCustomerType = frmCustomerType;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param frmCrgTpDry
	 */
	public void setFrmCrgTpDry(String frmCrgTpDry) {
		this.frmCrgTpDry = frmCrgTpDry;
	}
	
	/**
	 * Column Info
	 * @param frmCrgTpRf
	 */
	public void setFrmCrgTpRf(String frmCrgTpRf) {
		this.frmCrgTpRf = frmCrgTpRf;
	}
	
	/**
	 * Column Info
	 * @param rangeVal
	 */
	public void setRangeVal(String rangeVal) {
		this.rangeVal = rangeVal;
	}
	
	/**
	 * Column Info
	 * @param prevDataCol
	 */
	public void setPrevDataCol(String prevDataCol) {
		this.prevDataCol = prevDataCol;
	}
	
	/**
	 * Column Info
	 * @param frmSlaneCd
	 */
	public void setFrmSlaneCd(String frmSlaneCd) {
		this.frmSlaneCd = frmSlaneCd;
	}
	
	/**
	 * Column Info
	 * @param frmCrgTpDg
	 */
	public void setFrmCrgTpDg(String frmCrgTpDg) {
		this.frmCrgTpDg = frmCrgTpDg;
	}
	
	/**
	 * Column Info
	 * @param frmPropSrepNm
	 */
	public void setFrmPropSrepNm(String frmPropSrepNm) {
		this.frmPropSrepNm = frmPropSrepNm;
	}
	
	/**
	 * Column Info
	 * @param frmPropAproOfcCd
	 */
	public void setFrmPropAproOfcCd(String frmPropAproOfcCd) {
		this.frmPropAproOfcCd = frmPropAproOfcCd;
	}
	
	/**
	 * Column Info
	 * @param frmOriRoutCd
	 */
	public void setFrmOriRoutCd(String frmOriRoutCd) {
		this.frmOriRoutCd = frmOriRoutCd;
	}
	
	/**
	 * Column Info
	 * @param frmCustList
	 */
	public void setFrmCustList(String frmCustList) {
		this.frmCustList = frmCustList;
	}
	
	/**
	 * Column Info
	 * @param frmRfaPropNoList
	 */
	public void setFrmRfaPropNoList(String frmRfaPropNoList) {
		this.frmRfaPropNoList = frmRfaPropNoList;
	}
	
	/**
	 * Column Info
	 * @param frmCtrtEffDt
	 */
	public void setFrmCtrtEffDt(String frmCtrtEffDt) {
		this.frmCtrtEffDt = frmCtrtEffDt;
	}
	
	/**
	 * Column Info
	 * @param frmCrgTpBb
	 */
	public void setFrmCrgTpBb(String frmCrgTpBb) {
		this.frmCrgTpBb = frmCrgTpBb;
	}
	
	/**
	 * Column Info
	 * @param frmPropNoList
	 */
	public void setFrmPropNoList(String frmPropNoList) {
		this.frmPropNoList = frmPropNoList;
	}
	
	/**
	 * Column Info
	 * @param frmContractType
	 */
	public void setFrmContractType(String frmContractType) {
		this.frmContractType = frmContractType;
	}
	
	/**
	 * Column Info
	 * @param oriDestCd
	 */
	public void setOriDestCd(String oriDestCd) {
		this.oriDestCd = oriDestCd;
	}
	
	/**
	 * Column Info
	 * @param frmOriLocTp
	 */
	public void setFrmOriLocTp(String frmOriLocTp) {
		this.frmOriLocTp = frmOriLocTp;
	}
	
	/**
	 * Column Info
	 * @param frmSvcScpCd
	 */
	public void setFrmSvcScpCd(String frmSvcScpCd) {
		this.frmSvcScpCd = frmSvcScpCd;
	}
	
	/**
	 * Column Info
	 * @param frmCtrtExpDt
	 */
	public void setFrmCtrtExpDt(String frmCtrtExpDt) {
		this.frmCtrtExpDt = frmCtrtExpDt;
	}
	
	/**
	 * Column Info
	 * @param frmDestRoutCd
	 */
	public void setFrmDestRoutCd(String frmDestRoutCd) {
		this.frmDestRoutCd = frmDestRoutCd;
	}
	
	/**
	 * Column Info
	 * @param locTpCd
	 */
	public void setLocTpCd(String locTpCd) {
		this.locTpCd = locTpCd;
	}
	
	/**
	 * Column Info
	 * @param frmPropOfcCd
	 */
	public void setFrmPropOfcCd(String frmPropOfcCd) {
		this.frmPropOfcCd = frmPropOfcCd;
	}
	
	/**
	 * Column Info
	 * @param frmSummaryItems
	 */
	public void setFrmSummaryItems(String frmSummaryItems) {
		this.frmSummaryItems = frmSummaryItems;
	}
	
	/**
	 * Column Info
	 * @param newDataCol
	 */
	public void setNewDataCol(String newDataCol) {
		this.newDataCol = newDataCol;
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
		setFrmCrgTpAk(JSPUtil.getParameter(request, prefix + "frm_crg_tp_ak", ""));
		setRgnCd(JSPUtil.getParameter(request, prefix + "rgn_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setFrmCustomerSm(JSPUtil.getParameter(request, prefix + "frm_customer_sm", ""));
		setFrmDestLocTp(JSPUtil.getParameter(request, prefix + "frm_dest_loc_tp", ""));
		setRankOrder(JSPUtil.getParameter(request, prefix + "rank_order", ""));
		setFrmStatus(JSPUtil.getParameter(request, prefix + "frm_status", ""));
		setFrmContractTypeR(JSPUtil.getParameter(request, prefix + "frm_contract_type_r", ""));
		setFrmProfitLevel(JSPUtil.getParameter(request, prefix + "frm_profit_level", ""));
		setFrmContractTypeS(JSPUtil.getParameter(request, prefix + "frm_contract_type_s", ""));
		setFrmContractTypeT(JSPUtil.getParameter(request, prefix + "frm_contract_type_t", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setGrpCode(JSPUtil.getParameter(request, prefix + "grp_code", ""));
		setFrmPropSrepCd(JSPUtil.getParameter(request, prefix + "frm_prop_srep_cd", ""));
		setFrmPfmcUnit(JSPUtil.getParameter(request, prefix + "frm_pfmc_unit", ""));
		setFrmCustomerSmCd(JSPUtil.getParameter(request, prefix + "frm_customer_sm_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFrmProfitView(JSPUtil.getParameter(request, prefix + "frm_profit_view", ""));
		setFrmCustomerType(JSPUtil.getParameter(request, prefix + "frm_customer_type", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setFrmCrgTpDry(JSPUtil.getParameter(request, prefix + "frm_crg_tp_dry", ""));
		setFrmCrgTpRf(JSPUtil.getParameter(request, prefix + "frm_crg_tp_rf", ""));
		setRangeVal(JSPUtil.getParameter(request, prefix + "range_val", ""));
		setPrevDataCol(JSPUtil.getParameter(request, prefix + "prev_data_col", ""));
		setFrmSlaneCd(JSPUtil.getParameter(request, prefix + "frm_slane_cd", ""));
		setFrmCrgTpDg(JSPUtil.getParameter(request, prefix + "frm_crg_tp_dg", ""));
		setFrmPropSrepNm(JSPUtil.getParameter(request, prefix + "frm_prop_srep_nm", ""));
		setFrmPropAproOfcCd(JSPUtil.getParameter(request, prefix + "frm_prop_apro_ofc_cd", ""));
		setFrmOriRoutCd(JSPUtil.getParameter(request, prefix + "frm_ori_rout_cd", ""));
		setFrmCustList(JSPUtil.getParameter(request, prefix + "frm_cust_list", ""));
		setFrmRfaPropNoList(JSPUtil.getParameter(request, prefix + "frm_rfa_prop_no_list", ""));
		setFrmCtrtEffDt(JSPUtil.getParameter(request, prefix + "frm_ctrt_eff_dt", ""));
		setFrmCrgTpBb(JSPUtil.getParameter(request, prefix + "frm_crg_tp_bb", ""));
		setFrmPropNoList(JSPUtil.getParameter(request, prefix + "frm_prop_no_list", ""));
		setFrmContractType(JSPUtil.getParameter(request, prefix + "frm_contract_type", ""));
		setOriDestCd(JSPUtil.getParameter(request, prefix + "ori_dest_cd", ""));
		setFrmOriLocTp(JSPUtil.getParameter(request, prefix + "frm_ori_loc_tp", ""));
		setFrmSvcScpCd(JSPUtil.getParameter(request, prefix + "frm_svc_scp_cd", ""));
		setFrmCtrtExpDt(JSPUtil.getParameter(request, prefix + "frm_ctrt_exp_dt", ""));
		setFrmDestRoutCd(JSPUtil.getParameter(request, prefix + "frm_dest_rout_cd", ""));
		setLocTpCd(JSPUtil.getParameter(request, prefix + "loc_tp_cd", ""));
		setFrmPropOfcCd(JSPUtil.getParameter(request, prefix + "frm_prop_ofc_cd", ""));
		setFrmSummaryItems(JSPUtil.getParameter(request, prefix + "frm_summary_items", ""));
		setNewDataCol(JSPUtil.getParameter(request, prefix + "new_data_col", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InPrsProposalCmSummaryVO[]
	 */
	public InPrsProposalCmSummaryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InPrsProposalCmSummaryVO[]
	 */
	public InPrsProposalCmSummaryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InPrsProposalCmSummaryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] frmCrgTpAk = (JSPUtil.getParameter(request, prefix	+ "frm_crg_tp_ak", length));
			String[] rgnCd = (JSPUtil.getParameter(request, prefix	+ "rgn_cd", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] frmCustomerSm = (JSPUtil.getParameter(request, prefix	+ "frm_customer_sm", length));
			String[] frmDestLocTp = (JSPUtil.getParameter(request, prefix	+ "frm_dest_loc_tp", length));
			String[] rankOrder = (JSPUtil.getParameter(request, prefix	+ "rank_order", length));
			String[] frmStatus = (JSPUtil.getParameter(request, prefix	+ "frm_status", length));
			String[] frmContractTypeR = (JSPUtil.getParameter(request, prefix	+ "frm_contract_type_r", length));
			String[] frmProfitLevel = (JSPUtil.getParameter(request, prefix	+ "frm_profit_level", length));
			String[] frmContractTypeS = (JSPUtil.getParameter(request, prefix	+ "frm_contract_type_s", length));
			String[] frmContractTypeT = (JSPUtil.getParameter(request, prefix	+ "frm_contract_type_t", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] grpCode = (JSPUtil.getParameter(request, prefix	+ "grp_code", length));
			String[] frmPropSrepCd = (JSPUtil.getParameter(request, prefix	+ "frm_prop_srep_cd", length));
			String[] frmPfmcUnit = (JSPUtil.getParameter(request, prefix	+ "frm_pfmc_unit", length));
			String[] frmCustomerSmCd = (JSPUtil.getParameter(request, prefix	+ "frm_customer_sm_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] frmProfitView = (JSPUtil.getParameter(request, prefix	+ "frm_profit_view", length));
			String[] frmCustomerType = (JSPUtil.getParameter(request, prefix	+ "frm_customer_type", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] frmCrgTpDry = (JSPUtil.getParameter(request, prefix	+ "frm_crg_tp_dry", length));
			String[] frmCrgTpRf = (JSPUtil.getParameter(request, prefix	+ "frm_crg_tp_rf", length));
			String[] rangeVal = (JSPUtil.getParameter(request, prefix	+ "range_val", length));
			String[] prevDataCol = (JSPUtil.getParameter(request, prefix	+ "prev_data_col", length));
			String[] frmSlaneCd = (JSPUtil.getParameter(request, prefix	+ "frm_slane_cd", length));
			String[] frmCrgTpDg = (JSPUtil.getParameter(request, prefix	+ "frm_crg_tp_dg", length));
			String[] frmPropSrepNm = (JSPUtil.getParameter(request, prefix	+ "frm_prop_srep_nm", length));
			String[] frmPropAproOfcCd = (JSPUtil.getParameter(request, prefix	+ "frm_prop_apro_ofc_cd", length));
			String[] frmOriRoutCd = (JSPUtil.getParameter(request, prefix	+ "frm_ori_rout_cd", length));
			String[] frmCustList = (JSPUtil.getParameter(request, prefix	+ "frm_cust_list", length));
			String[] frmRfaPropNoList = (JSPUtil.getParameter(request, prefix	+ "frm_rfa_prop_no_list", length));
			String[] frmCtrtEffDt = (JSPUtil.getParameter(request, prefix	+ "frm_ctrt_eff_dt", length));
			String[] frmCrgTpBb = (JSPUtil.getParameter(request, prefix	+ "frm_crg_tp_bb", length));
			String[] frmPropNoList = (JSPUtil.getParameter(request, prefix	+ "frm_prop_no_list", length));
			String[] frmContractType = (JSPUtil.getParameter(request, prefix	+ "frm_contract_type", length));
			String[] oriDestCd = (JSPUtil.getParameter(request, prefix	+ "ori_dest_cd", length));
			String[] frmOriLocTp = (JSPUtil.getParameter(request, prefix	+ "frm_ori_loc_tp", length));
			String[] frmSvcScpCd = (JSPUtil.getParameter(request, prefix	+ "frm_svc_scp_cd", length));
			String[] frmCtrtExpDt = (JSPUtil.getParameter(request, prefix	+ "frm_ctrt_exp_dt", length));
			String[] frmDestRoutCd = (JSPUtil.getParameter(request, prefix	+ "frm_dest_rout_cd", length));
			String[] locTpCd = (JSPUtil.getParameter(request, prefix	+ "loc_tp_cd", length));
			String[] frmPropOfcCd = (JSPUtil.getParameter(request, prefix	+ "frm_prop_ofc_cd", length));
			String[] frmSummaryItems = (JSPUtil.getParameter(request, prefix	+ "frm_summary_items", length));
			String[] newDataCol = (JSPUtil.getParameter(request, prefix	+ "new_data_col", length));
			
			for (int i = 0; i < length; i++) {
				model = new InPrsProposalCmSummaryVO();
				if (frmCrgTpAk[i] != null)
					model.setFrmCrgTpAk(frmCrgTpAk[i]);
				if (rgnCd[i] != null)
					model.setRgnCd(rgnCd[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (frmCustomerSm[i] != null)
					model.setFrmCustomerSm(frmCustomerSm[i]);
				if (frmDestLocTp[i] != null)
					model.setFrmDestLocTp(frmDestLocTp[i]);
				if (rankOrder[i] != null)
					model.setRankOrder(rankOrder[i]);
				if (frmStatus[i] != null)
					model.setFrmStatus(frmStatus[i]);
				if (frmContractTypeR[i] != null)
					model.setFrmContractTypeR(frmContractTypeR[i]);
				if (frmProfitLevel[i] != null)
					model.setFrmProfitLevel(frmProfitLevel[i]);
				if (frmContractTypeS[i] != null)
					model.setFrmContractTypeS(frmContractTypeS[i]);
				if (frmContractTypeT[i] != null)
					model.setFrmContractTypeT(frmContractTypeT[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (grpCode[i] != null)
					model.setGrpCode(grpCode[i]);
				if (frmPropSrepCd[i] != null)
					model.setFrmPropSrepCd(frmPropSrepCd[i]);
				if (frmPfmcUnit[i] != null)
					model.setFrmPfmcUnit(frmPfmcUnit[i]);
				if (frmCustomerSmCd[i] != null)
					model.setFrmCustomerSmCd(frmCustomerSmCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (frmProfitView[i] != null)
					model.setFrmProfitView(frmProfitView[i]);
				if (frmCustomerType[i] != null)
					model.setFrmCustomerType(frmCustomerType[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (frmCrgTpDry[i] != null)
					model.setFrmCrgTpDry(frmCrgTpDry[i]);
				if (frmCrgTpRf[i] != null)
					model.setFrmCrgTpRf(frmCrgTpRf[i]);
				if (rangeVal[i] != null)
					model.setRangeVal(rangeVal[i]);
				if (prevDataCol[i] != null)
					model.setPrevDataCol(prevDataCol[i]);
				if (frmSlaneCd[i] != null)
					model.setFrmSlaneCd(frmSlaneCd[i]);
				if (frmCrgTpDg[i] != null)
					model.setFrmCrgTpDg(frmCrgTpDg[i]);
				if (frmPropSrepNm[i] != null)
					model.setFrmPropSrepNm(frmPropSrepNm[i]);
				if (frmPropAproOfcCd[i] != null)
					model.setFrmPropAproOfcCd(frmPropAproOfcCd[i]);
				if (frmOriRoutCd[i] != null)
					model.setFrmOriRoutCd(frmOriRoutCd[i]);
				if (frmCustList[i] != null)
					model.setFrmCustList(frmCustList[i]);
				if (frmRfaPropNoList[i] != null)
					model.setFrmRfaPropNoList(frmRfaPropNoList[i]);
				if (frmCtrtEffDt[i] != null)
					model.setFrmCtrtEffDt(frmCtrtEffDt[i]);
				if (frmCrgTpBb[i] != null)
					model.setFrmCrgTpBb(frmCrgTpBb[i]);
				if (frmPropNoList[i] != null)
					model.setFrmPropNoList(frmPropNoList[i]);
				if (frmContractType[i] != null)
					model.setFrmContractType(frmContractType[i]);
				if (oriDestCd[i] != null)
					model.setOriDestCd(oriDestCd[i]);
				if (frmOriLocTp[i] != null)
					model.setFrmOriLocTp(frmOriLocTp[i]);
				if (frmSvcScpCd[i] != null)
					model.setFrmSvcScpCd(frmSvcScpCd[i]);
				if (frmCtrtExpDt[i] != null)
					model.setFrmCtrtExpDt(frmCtrtExpDt[i]);
				if (frmDestRoutCd[i] != null)
					model.setFrmDestRoutCd(frmDestRoutCd[i]);
				if (locTpCd[i] != null)
					model.setLocTpCd(locTpCd[i]);
				if (frmPropOfcCd[i] != null)
					model.setFrmPropOfcCd(frmPropOfcCd[i]);
				if (frmSummaryItems[i] != null)
					model.setFrmSummaryItems(frmSummaryItems[i]);
				if (newDataCol[i] != null)
					model.setNewDataCol(newDataCol[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInPrsProposalCmSummaryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InPrsProposalCmSummaryVO[]
	 */
	public InPrsProposalCmSummaryVO[] getInPrsProposalCmSummaryVOs(){
		InPrsProposalCmSummaryVO[] vos = (InPrsProposalCmSummaryVO[])models.toArray(new InPrsProposalCmSummaryVO[models.size()]);
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
		this.frmCrgTpAk = this.frmCrgTpAk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnCd = this.rgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmCustomerSm = this.frmCustomerSm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmDestLocTp = this.frmDestLocTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rankOrder = this.rankOrder .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmStatus = this.frmStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmContractTypeR = this.frmContractTypeR .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmProfitLevel = this.frmProfitLevel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmContractTypeS = this.frmContractTypeS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmContractTypeT = this.frmContractTypeT .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpCode = this.grpCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmPropSrepCd = this.frmPropSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmPfmcUnit = this.frmPfmcUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmCustomerSmCd = this.frmCustomerSmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmProfitView = this.frmProfitView .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmCustomerType = this.frmCustomerType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmCrgTpDry = this.frmCrgTpDry .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmCrgTpRf = this.frmCrgTpRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rangeVal = this.rangeVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prevDataCol = this.prevDataCol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmSlaneCd = this.frmSlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmCrgTpDg = this.frmCrgTpDg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmPropSrepNm = this.frmPropSrepNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmPropAproOfcCd = this.frmPropAproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmOriRoutCd = this.frmOriRoutCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmCustList = this.frmCustList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmRfaPropNoList = this.frmRfaPropNoList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmCtrtEffDt = this.frmCtrtEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmCrgTpBb = this.frmCrgTpBb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmPropNoList = this.frmPropNoList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmContractType = this.frmContractType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriDestCd = this.oriDestCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmOriLocTp = this.frmOriLocTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmSvcScpCd = this.frmSvcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmCtrtExpDt = this.frmCtrtExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmDestRoutCd = this.frmDestRoutCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTpCd = this.locTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmPropOfcCd = this.frmPropOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmSummaryItems = this.frmSummaryItems .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newDataCol = this.newDataCol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
