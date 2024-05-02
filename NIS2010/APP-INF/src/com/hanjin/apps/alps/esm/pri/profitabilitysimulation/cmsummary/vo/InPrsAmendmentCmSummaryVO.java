/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InPrsAmendmentCmSummaryVO.java
*@FileTitle : InPrsAmendmentCmSummaryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.03
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.05.03 송민석 
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

public class InPrsAmendmentCmSummaryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InPrsAmendmentCmSummaryVO> models = new ArrayList<InPrsAmendmentCmSummaryVO>();
	
	/* Column Info */
	private String rgnCd = null;
	/* Column Info */
	private String frmSubTrdCd = null;
	/* Column Info */
	private String frmCustomerSm = null;
	/* Column Info */
	private String frmSmrEffYr = null;
	/* Column Info */
	private String frmSmrExpWk = null;
	/* Column Info */
	private String rankOrder = null;
	/* Column Info */
	private String frmProfitLevel = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String frmPropSrepCd = null;
	/* Column Info */
	private String grpCode = null;
	/* Column Info */
	private String frmCustomerSmCd = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String frmCtrtEffYr = null;
	/* Column Info */
	private String prevDataCol = null;
	/* Column Info */
	private String frmCrgTpDg = null;
	/* Column Info */
	private String frmRfrcEffWk = null;
	/* Column Info */
	private String frmRlaneCd = null;
	/* Column Info */
	private String frmPropAproOfcCd = null;
	/* Column Info */
	private String frmCustList = null;
	/* Column Info */
	private String frmTrdCd = null;
	/* Column Info */
	private String frmRfrcExpWk = null;
	/* Column Info */
	private String frmContractType = null;
	/* Column Info */
	private String frmOriLocTp = null;
	/* Column Info */
	private String frmCrgTpAk = null;
	/* Column Info */
	private String frmSmrEffWk = null;
	/* Column Info */
	private String frmDirCd = null;
	/* Column Info */
	private String frmDestLocTp = null;
	/* Column Info */
	private String frmSmrExpYr = null;
	/* Column Info */
	private String frmContractTypeR = null;
	/* Column Info */
	private String frmContractTypeS = null;
	/* Column Info */
	private String frmCtrtEffWk = null;
	/* Column Info */
	private String frmContractTypeT = null;
	/* Column Info */
	private String frmPfmcUnit = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String frmProfitView = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String frmCustomerType = null;
	/* Column Info */
	private String frmCtrtExpWk = null;
	/* Column Info */
	private String frmCrgTpDry = null;
	/* Column Info */
	private String frmCrgTpRf = null;
	/* Column Info */
	private String rangeVal = null;
	/* Column Info */
	private String frmRfrcExpYr = null;
	/* Column Info */
	private String simulTpCd = null;
	/* Column Info */
	private String frmPropSrepNm = null;
	/* Column Info */
	private String frmOriRoutCd = null;
	/* Column Info */
	private String frmRfaPropNoList = null;
	/* Column Info */
	private String frmRfrcEffYr = null;
	/* Column Info */
	private String frmPropNoList = null;
	/* Column Info */
	private String frmCrgTpBb = null;
	/* Column Info */
	private String frmSvcScpCd = null;
	/* Column Info */
	private String frmDestRoutCd = null;
	/* Column Info */
	private String frmSummaryItems = null;
	/* Column Info */
	private String frmPropOfcCd = null;
	/* Column Info */
	private String frmCtrtExpYr = null;
	/* Column Info */
	private String newDataCol = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InPrsAmendmentCmSummaryVO() {}

	public InPrsAmendmentCmSummaryVO(String ibflag, String pagerows, String frmContractType, String frmPfmcUnit, String frmProfitView, String frmProfitLevel, String frmSummaryItems, String frmSvcScpCd, String frmPropAproOfcCd, String frmPropOfcCd, String frmPropSrepCd, String frmPropSrepNm, String frmCustomerType, String frmCustomerSm, String frmCustomerSmCd, String frmCrgTpDry, String frmCrgTpDg, String frmCrgTpRf, String frmCrgTpAk, String frmCrgTpBb, String frmCustList, String frmPropNoList, String frmTrdCd, String frmDirCd, String frmSubTrdCd, String frmRlaneCd, String frmRfrcEffYr, String frmRfrcEffWk, String frmRfrcExpYr, String frmRfrcExpWk, String frmCtrtEffYr, String frmCtrtEffWk, String frmCtrtExpYr, String frmCtrtExpWk, String frmSmrEffYr, String frmSmrEffWk, String frmSmrExpYr, String frmSmrExpWk, String newDataCol, String prevDataCol, String rankOrder, String grpCode, String rangeVal, String usrId, String simulTpCd, String frmContractTypeS, String frmContractTypeR, String frmContractTypeT, String frmRfaPropNoList, String cntCd, String rgnCd, String frmOriRoutCd, String frmDestRoutCd, String frmOriLocTp, String frmDestLocTp) {
		this.rgnCd = rgnCd;
		this.frmSubTrdCd = frmSubTrdCd;
		this.frmCustomerSm = frmCustomerSm;
		this.frmSmrEffYr = frmSmrEffYr;
		this.frmSmrExpWk = frmSmrExpWk;
		this.rankOrder = rankOrder;
		this.frmProfitLevel = frmProfitLevel;
		this.pagerows = pagerows;
		this.frmPropSrepCd = frmPropSrepCd;
		this.grpCode = grpCode;
		this.frmCustomerSmCd = frmCustomerSmCd;
		this.cntCd = cntCd;
		this.frmCtrtEffYr = frmCtrtEffYr;
		this.prevDataCol = prevDataCol;
		this.frmCrgTpDg = frmCrgTpDg;
		this.frmRfrcEffWk = frmRfrcEffWk;
		this.frmRlaneCd = frmRlaneCd;
		this.frmPropAproOfcCd = frmPropAproOfcCd;
		this.frmCustList = frmCustList;
		this.frmTrdCd = frmTrdCd;
		this.frmRfrcExpWk = frmRfrcExpWk;
		this.frmContractType = frmContractType;
		this.frmOriLocTp = frmOriLocTp;
		this.frmCrgTpAk = frmCrgTpAk;
		this.frmSmrEffWk = frmSmrEffWk;
		this.frmDirCd = frmDirCd;
		this.frmDestLocTp = frmDestLocTp;
		this.frmSmrExpYr = frmSmrExpYr;
		this.frmContractTypeR = frmContractTypeR;
		this.frmContractTypeS = frmContractTypeS;
		this.frmCtrtEffWk = frmCtrtEffWk;
		this.frmContractTypeT = frmContractTypeT;
		this.frmPfmcUnit = frmPfmcUnit;
		this.ibflag = ibflag;
		this.frmProfitView = frmProfitView;
		this.usrId = usrId;
		this.frmCustomerType = frmCustomerType;
		this.frmCtrtExpWk = frmCtrtExpWk;
		this.frmCrgTpDry = frmCrgTpDry;
		this.frmCrgTpRf = frmCrgTpRf;
		this.rangeVal = rangeVal;
		this.frmRfrcExpYr = frmRfrcExpYr;
		this.simulTpCd = simulTpCd;
		this.frmPropSrepNm = frmPropSrepNm;
		this.frmOriRoutCd = frmOriRoutCd;
		this.frmRfaPropNoList = frmRfaPropNoList;
		this.frmRfrcEffYr = frmRfrcEffYr;
		this.frmPropNoList = frmPropNoList;
		this.frmCrgTpBb = frmCrgTpBb;
		this.frmSvcScpCd = frmSvcScpCd;
		this.frmDestRoutCd = frmDestRoutCd;
		this.frmSummaryItems = frmSummaryItems;
		this.frmPropOfcCd = frmPropOfcCd;
		this.frmCtrtExpYr = frmCtrtExpYr;
		this.newDataCol = newDataCol;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rgn_cd", getRgnCd());
		this.hashColumns.put("frm_sub_trd_cd", getFrmSubTrdCd());
		this.hashColumns.put("frm_customer_sm", getFrmCustomerSm());
		this.hashColumns.put("frm_smr_eff_yr", getFrmSmrEffYr());
		this.hashColumns.put("frm_smr_exp_wk", getFrmSmrExpWk());
		this.hashColumns.put("rank_order", getRankOrder());
		this.hashColumns.put("frm_profit_level", getFrmProfitLevel());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("frm_prop_srep_cd", getFrmPropSrepCd());
		this.hashColumns.put("grp_code", getGrpCode());
		this.hashColumns.put("frm_customer_sm_cd", getFrmCustomerSmCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("frm_ctrt_eff_yr", getFrmCtrtEffYr());
		this.hashColumns.put("prev_data_col", getPrevDataCol());
		this.hashColumns.put("frm_crg_tp_dg", getFrmCrgTpDg());
		this.hashColumns.put("frm_rfrc_eff_wk", getFrmRfrcEffWk());
		this.hashColumns.put("frm_rlane_cd", getFrmRlaneCd());
		this.hashColumns.put("frm_prop_apro_ofc_cd", getFrmPropAproOfcCd());
		this.hashColumns.put("frm_cust_list", getFrmCustList());
		this.hashColumns.put("frm_trd_cd", getFrmTrdCd());
		this.hashColumns.put("frm_rfrc_exp_wk", getFrmRfrcExpWk());
		this.hashColumns.put("frm_contract_type", getFrmContractType());
		this.hashColumns.put("frm_ori_loc_tp", getFrmOriLocTp());
		this.hashColumns.put("frm_crg_tp_ak", getFrmCrgTpAk());
		this.hashColumns.put("frm_smr_eff_wk", getFrmSmrEffWk());
		this.hashColumns.put("frm_dir_cd", getFrmDirCd());
		this.hashColumns.put("frm_dest_loc_tp", getFrmDestLocTp());
		this.hashColumns.put("frm_smr_exp_yr", getFrmSmrExpYr());
		this.hashColumns.put("frm_contract_type_r", getFrmContractTypeR());
		this.hashColumns.put("frm_contract_type_s", getFrmContractTypeS());
		this.hashColumns.put("frm_ctrt_eff_wk", getFrmCtrtEffWk());
		this.hashColumns.put("frm_contract_type_t", getFrmContractTypeT());
		this.hashColumns.put("frm_pfmc_unit", getFrmPfmcUnit());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("frm_profit_view", getFrmProfitView());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("frm_customer_type", getFrmCustomerType());
		this.hashColumns.put("frm_ctrt_exp_wk", getFrmCtrtExpWk());
		this.hashColumns.put("frm_crg_tp_dry", getFrmCrgTpDry());
		this.hashColumns.put("frm_crg_tp_rf", getFrmCrgTpRf());
		this.hashColumns.put("range_val", getRangeVal());
		this.hashColumns.put("frm_rfrc_exp_yr", getFrmRfrcExpYr());
		this.hashColumns.put("simul_tp_cd", getSimulTpCd());
		this.hashColumns.put("frm_prop_srep_nm", getFrmPropSrepNm());
		this.hashColumns.put("frm_ori_rout_cd", getFrmOriRoutCd());
		this.hashColumns.put("frm_rfa_prop_no_list", getFrmRfaPropNoList());
		this.hashColumns.put("frm_rfrc_eff_yr", getFrmRfrcEffYr());
		this.hashColumns.put("frm_prop_no_list", getFrmPropNoList());
		this.hashColumns.put("frm_crg_tp_bb", getFrmCrgTpBb());
		this.hashColumns.put("frm_svc_scp_cd", getFrmSvcScpCd());
		this.hashColumns.put("frm_dest_rout_cd", getFrmDestRoutCd());
		this.hashColumns.put("frm_summary_items", getFrmSummaryItems());
		this.hashColumns.put("frm_prop_ofc_cd", getFrmPropOfcCd());
		this.hashColumns.put("frm_ctrt_exp_yr", getFrmCtrtExpYr());
		this.hashColumns.put("new_data_col", getNewDataCol());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rgn_cd", "rgnCd");
		this.hashFields.put("frm_sub_trd_cd", "frmSubTrdCd");
		this.hashFields.put("frm_customer_sm", "frmCustomerSm");
		this.hashFields.put("frm_smr_eff_yr", "frmSmrEffYr");
		this.hashFields.put("frm_smr_exp_wk", "frmSmrExpWk");
		this.hashFields.put("rank_order", "rankOrder");
		this.hashFields.put("frm_profit_level", "frmProfitLevel");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("frm_prop_srep_cd", "frmPropSrepCd");
		this.hashFields.put("grp_code", "grpCode");
		this.hashFields.put("frm_customer_sm_cd", "frmCustomerSmCd");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("frm_ctrt_eff_yr", "frmCtrtEffYr");
		this.hashFields.put("prev_data_col", "prevDataCol");
		this.hashFields.put("frm_crg_tp_dg", "frmCrgTpDg");
		this.hashFields.put("frm_rfrc_eff_wk", "frmRfrcEffWk");
		this.hashFields.put("frm_rlane_cd", "frmRlaneCd");
		this.hashFields.put("frm_prop_apro_ofc_cd", "frmPropAproOfcCd");
		this.hashFields.put("frm_cust_list", "frmCustList");
		this.hashFields.put("frm_trd_cd", "frmTrdCd");
		this.hashFields.put("frm_rfrc_exp_wk", "frmRfrcExpWk");
		this.hashFields.put("frm_contract_type", "frmContractType");
		this.hashFields.put("frm_ori_loc_tp", "frmOriLocTp");
		this.hashFields.put("frm_crg_tp_ak", "frmCrgTpAk");
		this.hashFields.put("frm_smr_eff_wk", "frmSmrEffWk");
		this.hashFields.put("frm_dir_cd", "frmDirCd");
		this.hashFields.put("frm_dest_loc_tp", "frmDestLocTp");
		this.hashFields.put("frm_smr_exp_yr", "frmSmrExpYr");
		this.hashFields.put("frm_contract_type_r", "frmContractTypeR");
		this.hashFields.put("frm_contract_type_s", "frmContractTypeS");
		this.hashFields.put("frm_ctrt_eff_wk", "frmCtrtEffWk");
		this.hashFields.put("frm_contract_type_t", "frmContractTypeT");
		this.hashFields.put("frm_pfmc_unit", "frmPfmcUnit");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("frm_profit_view", "frmProfitView");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("frm_customer_type", "frmCustomerType");
		this.hashFields.put("frm_ctrt_exp_wk", "frmCtrtExpWk");
		this.hashFields.put("frm_crg_tp_dry", "frmCrgTpDry");
		this.hashFields.put("frm_crg_tp_rf", "frmCrgTpRf");
		this.hashFields.put("range_val", "rangeVal");
		this.hashFields.put("frm_rfrc_exp_yr", "frmRfrcExpYr");
		this.hashFields.put("simul_tp_cd", "simulTpCd");
		this.hashFields.put("frm_prop_srep_nm", "frmPropSrepNm");
		this.hashFields.put("frm_ori_rout_cd", "frmOriRoutCd");
		this.hashFields.put("frm_rfa_prop_no_list", "frmRfaPropNoList");
		this.hashFields.put("frm_rfrc_eff_yr", "frmRfrcEffYr");
		this.hashFields.put("frm_prop_no_list", "frmPropNoList");
		this.hashFields.put("frm_crg_tp_bb", "frmCrgTpBb");
		this.hashFields.put("frm_svc_scp_cd", "frmSvcScpCd");
		this.hashFields.put("frm_dest_rout_cd", "frmDestRoutCd");
		this.hashFields.put("frm_summary_items", "frmSummaryItems");
		this.hashFields.put("frm_prop_ofc_cd", "frmPropOfcCd");
		this.hashFields.put("frm_ctrt_exp_yr", "frmCtrtExpYr");
		this.hashFields.put("new_data_col", "newDataCol");
		return this.hashFields;
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
	 * @return frmSubTrdCd
	 */
	public String getFrmSubTrdCd() {
		return this.frmSubTrdCd;
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
	 * @return frmSmrEffYr
	 */
	public String getFrmSmrEffYr() {
		return this.frmSmrEffYr;
	}
	
	/**
	 * Column Info
	 * @return frmSmrExpWk
	 */
	public String getFrmSmrExpWk() {
		return this.frmSmrExpWk;
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
	 * @return frmProfitLevel
	 */
	public String getFrmProfitLevel() {
		return this.frmProfitLevel;
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
	 * @return frmPropSrepCd
	 */
	public String getFrmPropSrepCd() {
		return this.frmPropSrepCd;
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
	 * @return frmCustomerSmCd
	 */
	public String getFrmCustomerSmCd() {
		return this.frmCustomerSmCd;
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
	 * @return frmCtrtEffYr
	 */
	public String getFrmCtrtEffYr() {
		return this.frmCtrtEffYr;
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
	 * @return frmCrgTpDg
	 */
	public String getFrmCrgTpDg() {
		return this.frmCrgTpDg;
	}
	
	/**
	 * Column Info
	 * @return frmRfrcEffWk
	 */
	public String getFrmRfrcEffWk() {
		return this.frmRfrcEffWk;
	}
	
	/**
	 * Column Info
	 * @return frmRlaneCd
	 */
	public String getFrmRlaneCd() {
		return this.frmRlaneCd;
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
	 * @return frmCustList
	 */
	public String getFrmCustList() {
		return this.frmCustList;
	}
	
	/**
	 * Column Info
	 * @return frmTrdCd
	 */
	public String getFrmTrdCd() {
		return this.frmTrdCd;
	}
	
	/**
	 * Column Info
	 * @return frmRfrcExpWk
	 */
	public String getFrmRfrcExpWk() {
		return this.frmRfrcExpWk;
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
	 * @return frmOriLocTp
	 */
	public String getFrmOriLocTp() {
		return this.frmOriLocTp;
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
	 * @return frmSmrEffWk
	 */
	public String getFrmSmrEffWk() {
		return this.frmSmrEffWk;
	}
	
	/**
	 * Column Info
	 * @return frmDirCd
	 */
	public String getFrmDirCd() {
		return this.frmDirCd;
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
	 * @return frmSmrExpYr
	 */
	public String getFrmSmrExpYr() {
		return this.frmSmrExpYr;
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
	 * @return frmContractTypeS
	 */
	public String getFrmContractTypeS() {
		return this.frmContractTypeS;
	}
	
	/**
	 * Column Info
	 * @return frmCtrtEffWk
	 */
	public String getFrmCtrtEffWk() {
		return this.frmCtrtEffWk;
	}
	
	/**
	 * Column Info
	 * @return frmContractTypeT
	 */
	public String getFrmContractTypeT() {
		return this.frmContractTypeT;
	}
	
	/**
	 * Column Info
	 * @return frmPfmcUnit
	 */
	public String getFrmPfmcUnit() {
		return this.frmPfmcUnit;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
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
	 * @return frmCtrtExpWk
	 */
	public String getFrmCtrtExpWk() {
		return this.frmCtrtExpWk;
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
	 * @return frmRfrcExpYr
	 */
	public String getFrmRfrcExpYr() {
		return this.frmRfrcExpYr;
	}
	
	/**
	 * Column Info
	 * @return simulTpCd
	 */
	public String getSimulTpCd() {
		return this.simulTpCd;
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
	 * @return frmOriRoutCd
	 */
	public String getFrmOriRoutCd() {
		return this.frmOriRoutCd;
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
	 * @return frmRfrcEffYr
	 */
	public String getFrmRfrcEffYr() {
		return this.frmRfrcEffYr;
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
	 * @return frmCrgTpBb
	 */
	public String getFrmCrgTpBb() {
		return this.frmCrgTpBb;
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
	 * @return frmDestRoutCd
	 */
	public String getFrmDestRoutCd() {
		return this.frmDestRoutCd;
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
	 * @return frmPropOfcCd
	 */
	public String getFrmPropOfcCd() {
		return this.frmPropOfcCd;
	}
	
	/**
	 * Column Info
	 * @return frmCtrtExpYr
	 */
	public String getFrmCtrtExpYr() {
		return this.frmCtrtExpYr;
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
	 * @param rgnCd
	 */
	public void setRgnCd(String rgnCd) {
		this.rgnCd = rgnCd;
	}
	
	/**
	 * Column Info
	 * @param frmSubTrdCd
	 */
	public void setFrmSubTrdCd(String frmSubTrdCd) {
		this.frmSubTrdCd = frmSubTrdCd;
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
	 * @param frmSmrEffYr
	 */
	public void setFrmSmrEffYr(String frmSmrEffYr) {
		this.frmSmrEffYr = frmSmrEffYr;
	}
	
	/**
	 * Column Info
	 * @param frmSmrExpWk
	 */
	public void setFrmSmrExpWk(String frmSmrExpWk) {
		this.frmSmrExpWk = frmSmrExpWk;
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
	 * @param frmProfitLevel
	 */
	public void setFrmProfitLevel(String frmProfitLevel) {
		this.frmProfitLevel = frmProfitLevel;
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
	 * @param frmPropSrepCd
	 */
	public void setFrmPropSrepCd(String frmPropSrepCd) {
		this.frmPropSrepCd = frmPropSrepCd;
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
	 * @param frmCustomerSmCd
	 */
	public void setFrmCustomerSmCd(String frmCustomerSmCd) {
		this.frmCustomerSmCd = frmCustomerSmCd;
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
	 * @param frmCtrtEffYr
	 */
	public void setFrmCtrtEffYr(String frmCtrtEffYr) {
		this.frmCtrtEffYr = frmCtrtEffYr;
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
	 * @param frmCrgTpDg
	 */
	public void setFrmCrgTpDg(String frmCrgTpDg) {
		this.frmCrgTpDg = frmCrgTpDg;
	}
	
	/**
	 * Column Info
	 * @param frmRfrcEffWk
	 */
	public void setFrmRfrcEffWk(String frmRfrcEffWk) {
		this.frmRfrcEffWk = frmRfrcEffWk;
	}
	
	/**
	 * Column Info
	 * @param frmRlaneCd
	 */
	public void setFrmRlaneCd(String frmRlaneCd) {
		this.frmRlaneCd = frmRlaneCd;
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
	 * @param frmCustList
	 */
	public void setFrmCustList(String frmCustList) {
		this.frmCustList = frmCustList;
	}
	
	/**
	 * Column Info
	 * @param frmTrdCd
	 */
	public void setFrmTrdCd(String frmTrdCd) {
		this.frmTrdCd = frmTrdCd;
	}
	
	/**
	 * Column Info
	 * @param frmRfrcExpWk
	 */
	public void setFrmRfrcExpWk(String frmRfrcExpWk) {
		this.frmRfrcExpWk = frmRfrcExpWk;
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
	 * @param frmOriLocTp
	 */
	public void setFrmOriLocTp(String frmOriLocTp) {
		this.frmOriLocTp = frmOriLocTp;
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
	 * @param frmSmrEffWk
	 */
	public void setFrmSmrEffWk(String frmSmrEffWk) {
		this.frmSmrEffWk = frmSmrEffWk;
	}
	
	/**
	 * Column Info
	 * @param frmDirCd
	 */
	public void setFrmDirCd(String frmDirCd) {
		this.frmDirCd = frmDirCd;
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
	 * @param frmSmrExpYr
	 */
	public void setFrmSmrExpYr(String frmSmrExpYr) {
		this.frmSmrExpYr = frmSmrExpYr;
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
	 * @param frmContractTypeS
	 */
	public void setFrmContractTypeS(String frmContractTypeS) {
		this.frmContractTypeS = frmContractTypeS;
	}
	
	/**
	 * Column Info
	 * @param frmCtrtEffWk
	 */
	public void setFrmCtrtEffWk(String frmCtrtEffWk) {
		this.frmCtrtEffWk = frmCtrtEffWk;
	}
	
	/**
	 * Column Info
	 * @param frmContractTypeT
	 */
	public void setFrmContractTypeT(String frmContractTypeT) {
		this.frmContractTypeT = frmContractTypeT;
	}
	
	/**
	 * Column Info
	 * @param frmPfmcUnit
	 */
	public void setFrmPfmcUnit(String frmPfmcUnit) {
		this.frmPfmcUnit = frmPfmcUnit;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
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
	 * @param frmCtrtExpWk
	 */
	public void setFrmCtrtExpWk(String frmCtrtExpWk) {
		this.frmCtrtExpWk = frmCtrtExpWk;
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
	 * @param frmRfrcExpYr
	 */
	public void setFrmRfrcExpYr(String frmRfrcExpYr) {
		this.frmRfrcExpYr = frmRfrcExpYr;
	}
	
	/**
	 * Column Info
	 * @param simulTpCd
	 */
	public void setSimulTpCd(String simulTpCd) {
		this.simulTpCd = simulTpCd;
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
	 * @param frmOriRoutCd
	 */
	public void setFrmOriRoutCd(String frmOriRoutCd) {
		this.frmOriRoutCd = frmOriRoutCd;
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
	 * @param frmRfrcEffYr
	 */
	public void setFrmRfrcEffYr(String frmRfrcEffYr) {
		this.frmRfrcEffYr = frmRfrcEffYr;
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
	 * @param frmCrgTpBb
	 */
	public void setFrmCrgTpBb(String frmCrgTpBb) {
		this.frmCrgTpBb = frmCrgTpBb;
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
	 * @param frmDestRoutCd
	 */
	public void setFrmDestRoutCd(String frmDestRoutCd) {
		this.frmDestRoutCd = frmDestRoutCd;
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
	 * @param frmPropOfcCd
	 */
	public void setFrmPropOfcCd(String frmPropOfcCd) {
		this.frmPropOfcCd = frmPropOfcCd;
	}
	
	/**
	 * Column Info
	 * @param frmCtrtExpYr
	 */
	public void setFrmCtrtExpYr(String frmCtrtExpYr) {
		this.frmCtrtExpYr = frmCtrtExpYr;
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
		setRgnCd(JSPUtil.getParameter(request, prefix + "rgn_cd", ""));
		setFrmSubTrdCd(JSPUtil.getParameter(request, prefix + "frm_sub_trd_cd", ""));
		setFrmCustomerSm(JSPUtil.getParameter(request, prefix + "frm_customer_sm", ""));
		setFrmSmrEffYr(JSPUtil.getParameter(request, prefix + "frm_smr_eff_yr", ""));
		setFrmSmrExpWk(JSPUtil.getParameter(request, prefix + "frm_smr_exp_wk", ""));
		setRankOrder(JSPUtil.getParameter(request, prefix + "rank_order", ""));
		setFrmProfitLevel(JSPUtil.getParameter(request, prefix + "frm_profit_level", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFrmPropSrepCd(JSPUtil.getParameter(request, prefix + "frm_prop_srep_cd", ""));
		setGrpCode(JSPUtil.getParameter(request, prefix + "grp_code", ""));
		setFrmCustomerSmCd(JSPUtil.getParameter(request, prefix + "frm_customer_sm_cd", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setFrmCtrtEffYr(JSPUtil.getParameter(request, prefix + "frm_ctrt_eff_yr", ""));
		setPrevDataCol(JSPUtil.getParameter(request, prefix + "prev_data_col", ""));
		setFrmCrgTpDg(JSPUtil.getParameter(request, prefix + "frm_crg_tp_dg", ""));
		setFrmRfrcEffWk(JSPUtil.getParameter(request, prefix + "frm_rfrc_eff_wk", ""));
		setFrmRlaneCd(JSPUtil.getParameter(request, prefix + "frm_rlane_cd", ""));
		setFrmPropAproOfcCd(JSPUtil.getParameter(request, prefix + "frm_prop_apro_ofc_cd", ""));
		setFrmCustList(JSPUtil.getParameter(request, prefix + "frm_cust_list", ""));
		setFrmTrdCd(JSPUtil.getParameter(request, prefix + "frm_trd_cd", ""));
		setFrmRfrcExpWk(JSPUtil.getParameter(request, prefix + "frm_rfrc_exp_wk", ""));
		setFrmContractType(JSPUtil.getParameter(request, prefix + "frm_contract_type", ""));
		setFrmOriLocTp(JSPUtil.getParameter(request, prefix + "frm_ori_loc_tp", ""));
		setFrmCrgTpAk(JSPUtil.getParameter(request, prefix + "frm_crg_tp_ak", ""));
		setFrmSmrEffWk(JSPUtil.getParameter(request, prefix + "frm_smr_eff_wk", ""));
		setFrmDirCd(JSPUtil.getParameter(request, prefix + "frm_dir_cd", ""));
		setFrmDestLocTp(JSPUtil.getParameter(request, prefix + "frm_dest_loc_tp", ""));
		setFrmSmrExpYr(JSPUtil.getParameter(request, prefix + "frm_smr_exp_yr", ""));
		setFrmContractTypeR(JSPUtil.getParameter(request, prefix + "frm_contract_type_r", ""));
		setFrmContractTypeS(JSPUtil.getParameter(request, prefix + "frm_contract_type_s", ""));
		setFrmCtrtEffWk(JSPUtil.getParameter(request, prefix + "frm_ctrt_eff_wk", ""));
		setFrmContractTypeT(JSPUtil.getParameter(request, prefix + "frm_contract_type_t", ""));
		setFrmPfmcUnit(JSPUtil.getParameter(request, prefix + "frm_pfmc_unit", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFrmProfitView(JSPUtil.getParameter(request, prefix + "frm_profit_view", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setFrmCustomerType(JSPUtil.getParameter(request, prefix + "frm_customer_type", ""));
		setFrmCtrtExpWk(JSPUtil.getParameter(request, prefix + "frm_ctrt_exp_wk", ""));
		setFrmCrgTpDry(JSPUtil.getParameter(request, prefix + "frm_crg_tp_dry", ""));
		setFrmCrgTpRf(JSPUtil.getParameter(request, prefix + "frm_crg_tp_rf", ""));
		setRangeVal(JSPUtil.getParameter(request, prefix + "range_val", ""));
		setFrmRfrcExpYr(JSPUtil.getParameter(request, prefix + "frm_rfrc_exp_yr", ""));
		setSimulTpCd(JSPUtil.getParameter(request, prefix + "simul_tp_cd", ""));
		setFrmPropSrepNm(JSPUtil.getParameter(request, prefix + "frm_prop_srep_nm", ""));
		setFrmOriRoutCd(JSPUtil.getParameter(request, prefix + "frm_ori_rout_cd", ""));
		setFrmRfaPropNoList(JSPUtil.getParameter(request, prefix + "frm_rfa_prop_no_list", ""));
		setFrmRfrcEffYr(JSPUtil.getParameter(request, prefix + "frm_rfrc_eff_yr", ""));
		setFrmPropNoList(JSPUtil.getParameter(request, prefix + "frm_prop_no_list", ""));
		setFrmCrgTpBb(JSPUtil.getParameter(request, prefix + "frm_crg_tp_bb", ""));
		setFrmSvcScpCd(JSPUtil.getParameter(request, prefix + "frm_svc_scp_cd", ""));
		setFrmDestRoutCd(JSPUtil.getParameter(request, prefix + "frm_dest_rout_cd", ""));
		setFrmSummaryItems(JSPUtil.getParameter(request, prefix + "frm_summary_items", ""));
		setFrmPropOfcCd(JSPUtil.getParameter(request, prefix + "frm_prop_ofc_cd", ""));
		setFrmCtrtExpYr(JSPUtil.getParameter(request, prefix + "frm_ctrt_exp_yr", ""));
		setNewDataCol(JSPUtil.getParameter(request, prefix + "new_data_col", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InPrsAmendmentCmSummaryVO[]
	 */
	public InPrsAmendmentCmSummaryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InPrsAmendmentCmSummaryVO[]
	 */
	public InPrsAmendmentCmSummaryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InPrsAmendmentCmSummaryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rgnCd = (JSPUtil.getParameter(request, prefix	+ "rgn_cd", length));
			String[] frmSubTrdCd = (JSPUtil.getParameter(request, prefix	+ "frm_sub_trd_cd", length));
			String[] frmCustomerSm = (JSPUtil.getParameter(request, prefix	+ "frm_customer_sm", length));
			String[] frmSmrEffYr = (JSPUtil.getParameter(request, prefix	+ "frm_smr_eff_yr", length));
			String[] frmSmrExpWk = (JSPUtil.getParameter(request, prefix	+ "frm_smr_exp_wk", length));
			String[] rankOrder = (JSPUtil.getParameter(request, prefix	+ "rank_order", length));
			String[] frmProfitLevel = (JSPUtil.getParameter(request, prefix	+ "frm_profit_level", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] frmPropSrepCd = (JSPUtil.getParameter(request, prefix	+ "frm_prop_srep_cd", length));
			String[] grpCode = (JSPUtil.getParameter(request, prefix	+ "grp_code", length));
			String[] frmCustomerSmCd = (JSPUtil.getParameter(request, prefix	+ "frm_customer_sm_cd", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] frmCtrtEffYr = (JSPUtil.getParameter(request, prefix	+ "frm_ctrt_eff_yr", length));
			String[] prevDataCol = (JSPUtil.getParameter(request, prefix	+ "prev_data_col", length));
			String[] frmCrgTpDg = (JSPUtil.getParameter(request, prefix	+ "frm_crg_tp_dg", length));
			String[] frmRfrcEffWk = (JSPUtil.getParameter(request, prefix	+ "frm_rfrc_eff_wk", length));
			String[] frmRlaneCd = (JSPUtil.getParameter(request, prefix	+ "frm_rlane_cd", length));
			String[] frmPropAproOfcCd = (JSPUtil.getParameter(request, prefix	+ "frm_prop_apro_ofc_cd", length));
			String[] frmCustList = (JSPUtil.getParameter(request, prefix	+ "frm_cust_list", length));
			String[] frmTrdCd = (JSPUtil.getParameter(request, prefix	+ "frm_trd_cd", length));
			String[] frmRfrcExpWk = (JSPUtil.getParameter(request, prefix	+ "frm_rfrc_exp_wk", length));
			String[] frmContractType = (JSPUtil.getParameter(request, prefix	+ "frm_contract_type", length));
			String[] frmOriLocTp = (JSPUtil.getParameter(request, prefix	+ "frm_ori_loc_tp", length));
			String[] frmCrgTpAk = (JSPUtil.getParameter(request, prefix	+ "frm_crg_tp_ak", length));
			String[] frmSmrEffWk = (JSPUtil.getParameter(request, prefix	+ "frm_smr_eff_wk", length));
			String[] frmDirCd = (JSPUtil.getParameter(request, prefix	+ "frm_dir_cd", length));
			String[] frmDestLocTp = (JSPUtil.getParameter(request, prefix	+ "frm_dest_loc_tp", length));
			String[] frmSmrExpYr = (JSPUtil.getParameter(request, prefix	+ "frm_smr_exp_yr", length));
			String[] frmContractTypeR = (JSPUtil.getParameter(request, prefix	+ "frm_contract_type_r", length));
			String[] frmContractTypeS = (JSPUtil.getParameter(request, prefix	+ "frm_contract_type_s", length));
			String[] frmCtrtEffWk = (JSPUtil.getParameter(request, prefix	+ "frm_ctrt_eff_wk", length));
			String[] frmContractTypeT = (JSPUtil.getParameter(request, prefix	+ "frm_contract_type_t", length));
			String[] frmPfmcUnit = (JSPUtil.getParameter(request, prefix	+ "frm_pfmc_unit", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] frmProfitView = (JSPUtil.getParameter(request, prefix	+ "frm_profit_view", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] frmCustomerType = (JSPUtil.getParameter(request, prefix	+ "frm_customer_type", length));
			String[] frmCtrtExpWk = (JSPUtil.getParameter(request, prefix	+ "frm_ctrt_exp_wk", length));
			String[] frmCrgTpDry = (JSPUtil.getParameter(request, prefix	+ "frm_crg_tp_dry", length));
			String[] frmCrgTpRf = (JSPUtil.getParameter(request, prefix	+ "frm_crg_tp_rf", length));
			String[] rangeVal = (JSPUtil.getParameter(request, prefix	+ "range_val", length));
			String[] frmRfrcExpYr = (JSPUtil.getParameter(request, prefix	+ "frm_rfrc_exp_yr", length));
			String[] simulTpCd = (JSPUtil.getParameter(request, prefix	+ "simul_tp_cd", length));
			String[] frmPropSrepNm = (JSPUtil.getParameter(request, prefix	+ "frm_prop_srep_nm", length));
			String[] frmOriRoutCd = (JSPUtil.getParameter(request, prefix	+ "frm_ori_rout_cd", length));
			String[] frmRfaPropNoList = (JSPUtil.getParameter(request, prefix	+ "frm_rfa_prop_no_list", length));
			String[] frmRfrcEffYr = (JSPUtil.getParameter(request, prefix	+ "frm_rfrc_eff_yr", length));
			String[] frmPropNoList = (JSPUtil.getParameter(request, prefix	+ "frm_prop_no_list", length));
			String[] frmCrgTpBb = (JSPUtil.getParameter(request, prefix	+ "frm_crg_tp_bb", length));
			String[] frmSvcScpCd = (JSPUtil.getParameter(request, prefix	+ "frm_svc_scp_cd", length));
			String[] frmDestRoutCd = (JSPUtil.getParameter(request, prefix	+ "frm_dest_rout_cd", length));
			String[] frmSummaryItems = (JSPUtil.getParameter(request, prefix	+ "frm_summary_items", length));
			String[] frmPropOfcCd = (JSPUtil.getParameter(request, prefix	+ "frm_prop_ofc_cd", length));
			String[] frmCtrtExpYr = (JSPUtil.getParameter(request, prefix	+ "frm_ctrt_exp_yr", length));
			String[] newDataCol = (JSPUtil.getParameter(request, prefix	+ "new_data_col", length));
			
			for (int i = 0; i < length; i++) {
				model = new InPrsAmendmentCmSummaryVO();
				if (rgnCd[i] != null)
					model.setRgnCd(rgnCd[i]);
				if (frmSubTrdCd[i] != null)
					model.setFrmSubTrdCd(frmSubTrdCd[i]);
				if (frmCustomerSm[i] != null)
					model.setFrmCustomerSm(frmCustomerSm[i]);
				if (frmSmrEffYr[i] != null)
					model.setFrmSmrEffYr(frmSmrEffYr[i]);
				if (frmSmrExpWk[i] != null)
					model.setFrmSmrExpWk(frmSmrExpWk[i]);
				if (rankOrder[i] != null)
					model.setRankOrder(rankOrder[i]);
				if (frmProfitLevel[i] != null)
					model.setFrmProfitLevel(frmProfitLevel[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (frmPropSrepCd[i] != null)
					model.setFrmPropSrepCd(frmPropSrepCd[i]);
				if (grpCode[i] != null)
					model.setGrpCode(grpCode[i]);
				if (frmCustomerSmCd[i] != null)
					model.setFrmCustomerSmCd(frmCustomerSmCd[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (frmCtrtEffYr[i] != null)
					model.setFrmCtrtEffYr(frmCtrtEffYr[i]);
				if (prevDataCol[i] != null)
					model.setPrevDataCol(prevDataCol[i]);
				if (frmCrgTpDg[i] != null)
					model.setFrmCrgTpDg(frmCrgTpDg[i]);
				if (frmRfrcEffWk[i] != null)
					model.setFrmRfrcEffWk(frmRfrcEffWk[i]);
				if (frmRlaneCd[i] != null)
					model.setFrmRlaneCd(frmRlaneCd[i]);
				if (frmPropAproOfcCd[i] != null)
					model.setFrmPropAproOfcCd(frmPropAproOfcCd[i]);
				if (frmCustList[i] != null)
					model.setFrmCustList(frmCustList[i]);
				if (frmTrdCd[i] != null)
					model.setFrmTrdCd(frmTrdCd[i]);
				if (frmRfrcExpWk[i] != null)
					model.setFrmRfrcExpWk(frmRfrcExpWk[i]);
				if (frmContractType[i] != null)
					model.setFrmContractType(frmContractType[i]);
				if (frmOriLocTp[i] != null)
					model.setFrmOriLocTp(frmOriLocTp[i]);
				if (frmCrgTpAk[i] != null)
					model.setFrmCrgTpAk(frmCrgTpAk[i]);
				if (frmSmrEffWk[i] != null)
					model.setFrmSmrEffWk(frmSmrEffWk[i]);
				if (frmDirCd[i] != null)
					model.setFrmDirCd(frmDirCd[i]);
				if (frmDestLocTp[i] != null)
					model.setFrmDestLocTp(frmDestLocTp[i]);
				if (frmSmrExpYr[i] != null)
					model.setFrmSmrExpYr(frmSmrExpYr[i]);
				if (frmContractTypeR[i] != null)
					model.setFrmContractTypeR(frmContractTypeR[i]);
				if (frmContractTypeS[i] != null)
					model.setFrmContractTypeS(frmContractTypeS[i]);
				if (frmCtrtEffWk[i] != null)
					model.setFrmCtrtEffWk(frmCtrtEffWk[i]);
				if (frmContractTypeT[i] != null)
					model.setFrmContractTypeT(frmContractTypeT[i]);
				if (frmPfmcUnit[i] != null)
					model.setFrmPfmcUnit(frmPfmcUnit[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (frmProfitView[i] != null)
					model.setFrmProfitView(frmProfitView[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (frmCustomerType[i] != null)
					model.setFrmCustomerType(frmCustomerType[i]);
				if (frmCtrtExpWk[i] != null)
					model.setFrmCtrtExpWk(frmCtrtExpWk[i]);
				if (frmCrgTpDry[i] != null)
					model.setFrmCrgTpDry(frmCrgTpDry[i]);
				if (frmCrgTpRf[i] != null)
					model.setFrmCrgTpRf(frmCrgTpRf[i]);
				if (rangeVal[i] != null)
					model.setRangeVal(rangeVal[i]);
				if (frmRfrcExpYr[i] != null)
					model.setFrmRfrcExpYr(frmRfrcExpYr[i]);
				if (simulTpCd[i] != null)
					model.setSimulTpCd(simulTpCd[i]);
				if (frmPropSrepNm[i] != null)
					model.setFrmPropSrepNm(frmPropSrepNm[i]);
				if (frmOriRoutCd[i] != null)
					model.setFrmOriRoutCd(frmOriRoutCd[i]);
				if (frmRfaPropNoList[i] != null)
					model.setFrmRfaPropNoList(frmRfaPropNoList[i]);
				if (frmRfrcEffYr[i] != null)
					model.setFrmRfrcEffYr(frmRfrcEffYr[i]);
				if (frmPropNoList[i] != null)
					model.setFrmPropNoList(frmPropNoList[i]);
				if (frmCrgTpBb[i] != null)
					model.setFrmCrgTpBb(frmCrgTpBb[i]);
				if (frmSvcScpCd[i] != null)
					model.setFrmSvcScpCd(frmSvcScpCd[i]);
				if (frmDestRoutCd[i] != null)
					model.setFrmDestRoutCd(frmDestRoutCd[i]);
				if (frmSummaryItems[i] != null)
					model.setFrmSummaryItems(frmSummaryItems[i]);
				if (frmPropOfcCd[i] != null)
					model.setFrmPropOfcCd(frmPropOfcCd[i]);
				if (frmCtrtExpYr[i] != null)
					model.setFrmCtrtExpYr(frmCtrtExpYr[i]);
				if (newDataCol[i] != null)
					model.setNewDataCol(newDataCol[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInPrsAmendmentCmSummaryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InPrsAmendmentCmSummaryVO[]
	 */
	public InPrsAmendmentCmSummaryVO[] getInPrsAmendmentCmSummaryVOs(){
		InPrsAmendmentCmSummaryVO[] vos = (InPrsAmendmentCmSummaryVO[])models.toArray(new InPrsAmendmentCmSummaryVO[models.size()]);
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
		this.rgnCd = this.rgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmSubTrdCd = this.frmSubTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmCustomerSm = this.frmCustomerSm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmSmrEffYr = this.frmSmrEffYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmSmrExpWk = this.frmSmrExpWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rankOrder = this.rankOrder .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmProfitLevel = this.frmProfitLevel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmPropSrepCd = this.frmPropSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpCode = this.grpCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmCustomerSmCd = this.frmCustomerSmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmCtrtEffYr = this.frmCtrtEffYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prevDataCol = this.prevDataCol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmCrgTpDg = this.frmCrgTpDg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmRfrcEffWk = this.frmRfrcEffWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmRlaneCd = this.frmRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmPropAproOfcCd = this.frmPropAproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmCustList = this.frmCustList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmTrdCd = this.frmTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmRfrcExpWk = this.frmRfrcExpWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmContractType = this.frmContractType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmOriLocTp = this.frmOriLocTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmCrgTpAk = this.frmCrgTpAk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmSmrEffWk = this.frmSmrEffWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmDirCd = this.frmDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmDestLocTp = this.frmDestLocTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmSmrExpYr = this.frmSmrExpYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmContractTypeR = this.frmContractTypeR .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmContractTypeS = this.frmContractTypeS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmCtrtEffWk = this.frmCtrtEffWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmContractTypeT = this.frmContractTypeT .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmPfmcUnit = this.frmPfmcUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmProfitView = this.frmProfitView .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmCustomerType = this.frmCustomerType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmCtrtExpWk = this.frmCtrtExpWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmCrgTpDry = this.frmCrgTpDry .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmCrgTpRf = this.frmCrgTpRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rangeVal = this.rangeVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmRfrcExpYr = this.frmRfrcExpYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simulTpCd = this.simulTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmPropSrepNm = this.frmPropSrepNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmOriRoutCd = this.frmOriRoutCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmRfaPropNoList = this.frmRfaPropNoList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmRfrcEffYr = this.frmRfrcEffYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmPropNoList = this.frmPropNoList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmCrgTpBb = this.frmCrgTpBb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmSvcScpCd = this.frmSvcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmDestRoutCd = this.frmDestRoutCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmSummaryItems = this.frmSummaryItems .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmPropOfcCd = this.frmPropOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmCtrtExpYr = this.frmCtrtExpYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newDataCol = this.newDataCol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
