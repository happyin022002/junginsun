/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SearchUSDomesticVO.java
*@FileTitle : SearchUSDomesticVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.29
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2013.05.29 최성민 
* 1.0 Creation
* 2013.05.31 김수정 [CHM-201324859] COA Domestic Saving Credit 보완
=========================================================*/

package com.hanjin.apps.alps.esm.coa.stdunitcost.usdomestic.vo;

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
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchUSDomesticVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchUSDomesticVO> models = new ArrayList<SearchUSDomesticVO>();
	
	/* Column Info */
	private String simMtyCostAmt = null;
	/* Column Info */
	private String railUcAmt = null;
	/* Column Info */
	private String eqOffhSavUcInitAmt = null;
	/* Column Info */
	private String trpSavAmt = null;
	/* Column Info */
	private String domRevUcAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fCreEndDt = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String eqOffhFnlUcAmt = null;
	/* Column Info */
	private String railHub = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String hzdMtrlScgAmt = null;
	/* Column Info */
	private String usaDmstUcAmt = null;
	/* Column Info */
	private String trpUcAmt = null;
	/* Column Info */
	private String usaDmstCostAmt = null;
	/* Column Info */
	private String trpCrUcAmt = null;
	/* Column Info */
	private String fCreStartDt = null;
	/* Column Info */
	private String eqOffhSavUcAmt = null;
	/* Column Info */
	private String simMtyUcAmt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String trpAmt = null;
	/* Column Info */
	private String initSimMtyUcAmt = null;
	/* Column Info */
	private String usaDmstSavCostAmt = null;
	/* Column Info */
	private String usaDmstSavUtAmt = null;
	/* Column Info */
	private String fEccCd = null;
	/* Column Info */
	private String fDomRevDet = null;
	/* Column Info */
	private String rowNum = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String eqOffhQty = null;
	/* Column Info */
	private String offhSimMtyCostAmt = null;
	/* Column Info */
	private String dispQty = null;
	/* Column Info */
	private String fCntrTpszCd = null;
	/* Column Info */
	private String cndDmstQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dmstRailInvAmt = null;
	/* Column Info */
	private String offhTtlQty = null;
	/* Column Info */
	private String eqRntlScgAmt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String fCostLocGrpCd = null;
	/* Column Info */
	private String fCostYrmon = null;
	/* Column Info */
	private String railAgmtAmt = null;
	/* Column Info */
	private String eqOffhSavAmt = null;
	/* Column Info */
	private String railSoVolQty = null;
	/* Column Info */
	private String railgAmt = null;
	/* Column Info */
	private String dmstTtlFrtRevAmt = null;
	/* Column Info */
	private String initUsaDmstSavUtAmt = null;
	/* Column Info */
	private String fuelScgAmt = null;
	/* Column Info */
	private String trpQty = null;
	/* Column Info */
	private String trpCrUcInitAmt = null;
	/* Column Info */
	private String fcntrIbVolQty = null;
	/* Column Info */
	private String orgRailLocCd = null;
	/* Column Info */
	private String dmstVolQty = null;
	/* Column Info */
	private String subLseOutQty = null;
	/* Column Info */
	private String trpSimMtyCostAmt = null;
	/* Column Info */
	private String costLocGrpCd = null;
	/* Column Info */
	private String eqOffhFnlUcInitAmt = null;
	/* Column Info */
	private String eqOffhUcAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchUSDomesticVO() {}

	public SearchUSDomesticVO(String ibflag, String pagerows, String fCostYrmon, String fCostLocGrpCd, String fEccCd, String fCntrTpszCd, String fDomRevDet, String fCreStartDt, String fCreEndDt, String costYrmon, String orgRailLocCd, String railHub, String costLocGrpCd, String cntrTpszCd, String dmstVolQty, String railgAmt, String eqRntlScgAmt, String fuelScgAmt, String hzdMtrlScgAmt, String dmstTtlFrtRevAmt, String domRevUcAmt, String railSoVolQty, String railAgmtAmt, String railUcAmt, String usaDmstCostAmt, String usaDmstUcAmt, String simMtyCostAmt, String initSimMtyUcAmt, String simMtyUcAmt, String fcntrIbVolQty, String usaDmstSavCostAmt, String initUsaDmstSavUtAmt, String usaDmstSavUtAmt, String creUsrId, String creDt, String updUsrId, String updDt, String eqOffhQty, String subLseOutQty, String dispQty, String cndDmstQty, String offhTtlQty, String offhSimMtyCostAmt, String eqOffhSavAmt, String eqOffhSavUcAmt, String eqOffhSavUcInitAmt, String trpQty, String trpAmt, String trpUcAmt, String trpSimMtyCostAmt, String trpSavAmt, String trpCrUcAmt, String trpCrUcInitAmt, String rowNum, String eqOffhFnlUcAmt, String eqOffhFnlUcInitAmt, String dmstRailInvAmt, String eqOffhUcAmt) {
		this.simMtyCostAmt = simMtyCostAmt;
		this.railUcAmt = railUcAmt;
		this.eqOffhSavUcInitAmt = eqOffhSavUcInitAmt;
		this.trpSavAmt = trpSavAmt;
		this.domRevUcAmt = domRevUcAmt;
		this.pagerows = pagerows;
		this.fCreEndDt = fCreEndDt;
		this.costYrmon = costYrmon;
		this.cntrTpszCd = cntrTpszCd;
		this.eqOffhFnlUcAmt = eqOffhFnlUcAmt;
		this.railHub = railHub;
		this.updUsrId = updUsrId;
		this.hzdMtrlScgAmt = hzdMtrlScgAmt;
		this.usaDmstUcAmt = usaDmstUcAmt;
		this.trpUcAmt = trpUcAmt;
		this.usaDmstCostAmt = usaDmstCostAmt;
		this.trpCrUcAmt = trpCrUcAmt;
		this.fCreStartDt = fCreStartDt;
		this.eqOffhSavUcAmt = eqOffhSavUcAmt;
		this.simMtyUcAmt = simMtyUcAmt;
		this.creUsrId = creUsrId;
		this.trpAmt = trpAmt;
		this.initSimMtyUcAmt = initSimMtyUcAmt;
		this.usaDmstSavCostAmt = usaDmstSavCostAmt;
		this.usaDmstSavUtAmt = usaDmstSavUtAmt;
		this.fEccCd = fEccCd;
		this.fDomRevDet = fDomRevDet;
		this.rowNum = rowNum;
		this.creDt = creDt;
		this.eqOffhQty = eqOffhQty;
		this.offhSimMtyCostAmt = offhSimMtyCostAmt;
		this.dispQty = dispQty;
		this.fCntrTpszCd = fCntrTpszCd;
		this.cndDmstQty = cndDmstQty;
		this.ibflag = ibflag;
		this.dmstRailInvAmt = dmstRailInvAmt;
		this.offhTtlQty = offhTtlQty;
		this.eqRntlScgAmt = eqRntlScgAmt;
		this.updDt = updDt;
		this.fCostLocGrpCd = fCostLocGrpCd;
		this.fCostYrmon = fCostYrmon;
		this.railAgmtAmt = railAgmtAmt;
		this.eqOffhSavAmt = eqOffhSavAmt;
		this.railSoVolQty = railSoVolQty;
		this.railgAmt = railgAmt;
		this.dmstTtlFrtRevAmt = dmstTtlFrtRevAmt;
		this.initUsaDmstSavUtAmt = initUsaDmstSavUtAmt;
		this.fuelScgAmt = fuelScgAmt;
		this.trpQty = trpQty;
		this.trpCrUcInitAmt = trpCrUcInitAmt;
		this.fcntrIbVolQty = fcntrIbVolQty;
		this.orgRailLocCd = orgRailLocCd;
		this.dmstVolQty = dmstVolQty;
		this.subLseOutQty = subLseOutQty;
		this.trpSimMtyCostAmt = trpSimMtyCostAmt;
		this.costLocGrpCd = costLocGrpCd;
		this.eqOffhFnlUcInitAmt = eqOffhFnlUcInitAmt;
		this.eqOffhUcAmt = eqOffhUcAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sim_mty_cost_amt", getSimMtyCostAmt());
		this.hashColumns.put("rail_uc_amt", getRailUcAmt());
		this.hashColumns.put("eq_offh_sav_uc_init_amt", getEqOffhSavUcInitAmt());
		this.hashColumns.put("trp_sav_amt", getTrpSavAmt());
		this.hashColumns.put("dom_rev_uc_amt", getDomRevUcAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("f_cre_end_dt", getFCreEndDt());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("eq_offh_fnl_uc_amt", getEqOffhFnlUcAmt());
		this.hashColumns.put("rail_hub", getRailHub());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("hzd_mtrl_scg_amt", getHzdMtrlScgAmt());
		this.hashColumns.put("usa_dmst_uc_amt", getUsaDmstUcAmt());
		this.hashColumns.put("trp_uc_amt", getTrpUcAmt());
		this.hashColumns.put("usa_dmst_cost_amt", getUsaDmstCostAmt());
		this.hashColumns.put("trp_cr_uc_amt", getTrpCrUcAmt());
		this.hashColumns.put("f_cre_start_dt", getFCreStartDt());
		this.hashColumns.put("eq_offh_sav_uc_amt", getEqOffhSavUcAmt());
		this.hashColumns.put("sim_mty_uc_amt", getSimMtyUcAmt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("trp_amt", getTrpAmt());
		this.hashColumns.put("init_sim_mty_uc_amt", getInitSimMtyUcAmt());
		this.hashColumns.put("usa_dmst_sav_cost_amt", getUsaDmstSavCostAmt());
		this.hashColumns.put("usa_dmst_sav_ut_amt", getUsaDmstSavUtAmt());
		this.hashColumns.put("f_ecc_cd", getFEccCd());
		this.hashColumns.put("f_dom_rev_det", getFDomRevDet());
		this.hashColumns.put("row_num", getRowNum());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("eq_offh_qty", getEqOffhQty());
		this.hashColumns.put("offh_sim_mty_cost_amt", getOffhSimMtyCostAmt());
		this.hashColumns.put("disp_qty", getDispQty());
		this.hashColumns.put("f_cntr_tpsz_cd", getFCntrTpszCd());
		this.hashColumns.put("cnd_dmst_qty", getCndDmstQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dmst_rail_inv_amt", getDmstRailInvAmt());
		this.hashColumns.put("offh_ttl_qty", getOffhTtlQty());
		this.hashColumns.put("eq_rntl_scg_amt", getEqRntlScgAmt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("f_cost_loc_grp_cd", getFCostLocGrpCd());
		this.hashColumns.put("f_cost_yrmon", getFCostYrmon());
		this.hashColumns.put("rail_agmt_amt", getRailAgmtAmt());
		this.hashColumns.put("eq_offh_sav_amt", getEqOffhSavAmt());
		this.hashColumns.put("rail_so_vol_qty", getRailSoVolQty());
		this.hashColumns.put("railg_amt", getRailgAmt());
		this.hashColumns.put("dmst_ttl_frt_rev_amt", getDmstTtlFrtRevAmt());
		this.hashColumns.put("init_usa_dmst_sav_ut_amt", getInitUsaDmstSavUtAmt());
		this.hashColumns.put("fuel_scg_amt", getFuelScgAmt());
		this.hashColumns.put("trp_qty", getTrpQty());
		this.hashColumns.put("trp_cr_uc_init_amt", getTrpCrUcInitAmt());
		this.hashColumns.put("fcntr_ib_vol_qty", getFcntrIbVolQty());
		this.hashColumns.put("org_rail_loc_cd", getOrgRailLocCd());
		this.hashColumns.put("dmst_vol_qty", getDmstVolQty());
		this.hashColumns.put("sub_lse_out_qty", getSubLseOutQty());
		this.hashColumns.put("trp_sim_mty_cost_amt", getTrpSimMtyCostAmt());
		this.hashColumns.put("cost_loc_grp_cd", getCostLocGrpCd());
		this.hashColumns.put("eq_offh_fnl_uc_init_amt", getEqOffhFnlUcInitAmt());
		this.hashColumns.put("eq_offh_uc_amt", getEqOffhUcAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sim_mty_cost_amt", "simMtyCostAmt");
		this.hashFields.put("rail_uc_amt", "railUcAmt");
		this.hashFields.put("eq_offh_sav_uc_init_amt", "eqOffhSavUcInitAmt");
		this.hashFields.put("trp_sav_amt", "trpSavAmt");
		this.hashFields.put("dom_rev_uc_amt", "domRevUcAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("f_cre_end_dt", "fCreEndDt");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("eq_offh_fnl_uc_amt", "eqOffhFnlUcAmt");
		this.hashFields.put("rail_hub", "railHub");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("hzd_mtrl_scg_amt", "hzdMtrlScgAmt");
		this.hashFields.put("usa_dmst_uc_amt", "usaDmstUcAmt");
		this.hashFields.put("trp_uc_amt", "trpUcAmt");
		this.hashFields.put("usa_dmst_cost_amt", "usaDmstCostAmt");
		this.hashFields.put("trp_cr_uc_amt", "trpCrUcAmt");
		this.hashFields.put("f_cre_start_dt", "fCreStartDt");
		this.hashFields.put("eq_offh_sav_uc_amt", "eqOffhSavUcAmt");
		this.hashFields.put("sim_mty_uc_amt", "simMtyUcAmt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("trp_amt", "trpAmt");
		this.hashFields.put("init_sim_mty_uc_amt", "initSimMtyUcAmt");
		this.hashFields.put("usa_dmst_sav_cost_amt", "usaDmstSavCostAmt");
		this.hashFields.put("usa_dmst_sav_ut_amt", "usaDmstSavUtAmt");
		this.hashFields.put("f_ecc_cd", "fEccCd");
		this.hashFields.put("f_dom_rev_det", "fDomRevDet");
		this.hashFields.put("row_num", "rowNum");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("eq_offh_qty", "eqOffhQty");
		this.hashFields.put("offh_sim_mty_cost_amt", "offhSimMtyCostAmt");
		this.hashFields.put("disp_qty", "dispQty");
		this.hashFields.put("f_cntr_tpsz_cd", "fCntrTpszCd");
		this.hashFields.put("cnd_dmst_qty", "cndDmstQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dmst_rail_inv_amt", "dmstRailInvAmt");
		this.hashFields.put("offh_ttl_qty", "offhTtlQty");
		this.hashFields.put("eq_rntl_scg_amt", "eqRntlScgAmt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("f_cost_loc_grp_cd", "fCostLocGrpCd");
		this.hashFields.put("f_cost_yrmon", "fCostYrmon");
		this.hashFields.put("rail_agmt_amt", "railAgmtAmt");
		this.hashFields.put("eq_offh_sav_amt", "eqOffhSavAmt");
		this.hashFields.put("rail_so_vol_qty", "railSoVolQty");
		this.hashFields.put("railg_amt", "railgAmt");
		this.hashFields.put("dmst_ttl_frt_rev_amt", "dmstTtlFrtRevAmt");
		this.hashFields.put("init_usa_dmst_sav_ut_amt", "initUsaDmstSavUtAmt");
		this.hashFields.put("fuel_scg_amt", "fuelScgAmt");
		this.hashFields.put("trp_qty", "trpQty");
		this.hashFields.put("trp_cr_uc_init_amt", "trpCrUcInitAmt");
		this.hashFields.put("fcntr_ib_vol_qty", "fcntrIbVolQty");
		this.hashFields.put("org_rail_loc_cd", "orgRailLocCd");
		this.hashFields.put("dmst_vol_qty", "dmstVolQty");
		this.hashFields.put("sub_lse_out_qty", "subLseOutQty");
		this.hashFields.put("trp_sim_mty_cost_amt", "trpSimMtyCostAmt");
		this.hashFields.put("cost_loc_grp_cd", "costLocGrpCd");
		this.hashFields.put("eq_offh_fnl_uc_init_amt", "eqOffhFnlUcInitAmt");
		this.hashFields.put("eq_offh_uc_amt", "eqOffhUcAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return simMtyCostAmt
	 */
	public String getSimMtyCostAmt() {
		return this.simMtyCostAmt;
	}
	
	/**
	 * Column Info
	 * @return railUcAmt
	 */
	public String getRailUcAmt() {
		return this.railUcAmt;
	}
	
	/**
	 * Column Info
	 * @return eqOffhSavUcInitAmt
	 */
	public String getEqOffhSavUcInitAmt() {
		return this.eqOffhSavUcInitAmt;
	}
	
	/**
	 * Column Info
	 * @return trpSavAmt
	 */
	public String getTrpSavAmt() {
		return this.trpSavAmt;
	}
	
	/**
	 * Column Info
	 * @return domRevUcAmt
	 */
	public String getDomRevUcAmt() {
		return this.domRevUcAmt;
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
	 * @return fCreEndDt
	 */
	public String getFCreEndDt() {
		return this.fCreEndDt;
	}
	
	/**
	 * Column Info
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return eqOffhFnlUcAmt
	 */
	public String getEqOffhFnlUcAmt() {
		return this.eqOffhFnlUcAmt;
	}
	
	/**
	 * Column Info
	 * @return railHub
	 */
	public String getRailHub() {
		return this.railHub;
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
	 * @return hzdMtrlScgAmt
	 */
	public String getHzdMtrlScgAmt() {
		return this.hzdMtrlScgAmt;
	}
	
	/**
	 * Column Info
	 * @return usaDmstUcAmt
	 */
	public String getUsaDmstUcAmt() {
		return this.usaDmstUcAmt;
	}
	
	/**
	 * Column Info
	 * @return trpUcAmt
	 */
	public String getTrpUcAmt() {
		return this.trpUcAmt;
	}
	
	/**
	 * Column Info
	 * @return usaDmstCostAmt
	 */
	public String getUsaDmstCostAmt() {
		return this.usaDmstCostAmt;
	}
	
	/**
	 * Column Info
	 * @return trpCrUcAmt
	 */
	public String getTrpCrUcAmt() {
		return this.trpCrUcAmt;
	}
	
	/**
	 * Column Info
	 * @return fCreStartDt
	 */
	public String getFCreStartDt() {
		return this.fCreStartDt;
	}
	
	/**
	 * Column Info
	 * @return eqOffhSavUcAmt
	 */
	public String getEqOffhSavUcAmt() {
		return this.eqOffhSavUcAmt;
	}
	
	/**
	 * Column Info
	 * @return simMtyUcAmt
	 */
	public String getSimMtyUcAmt() {
		return this.simMtyUcAmt;
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
	 * @return trpAmt
	 */
	public String getTrpAmt() {
		return this.trpAmt;
	}
	
	/**
	 * Column Info
	 * @return initSimMtyUcAmt
	 */
	public String getInitSimMtyUcAmt() {
		return this.initSimMtyUcAmt;
	}
	
	/**
	 * Column Info
	 * @return usaDmstSavCostAmt
	 */
	public String getUsaDmstSavCostAmt() {
		return this.usaDmstSavCostAmt;
	}
	
	/**
	 * Column Info
	 * @return usaDmstSavUtAmt
	 */
	public String getUsaDmstSavUtAmt() {
		return this.usaDmstSavUtAmt;
	}
	
	/**
	 * Column Info
	 * @return fEccCd
	 */
	public String getFEccCd() {
		return this.fEccCd;
	}
	
	/**
	 * Column Info
	 * @return fDomRevDet
	 */
	public String getFDomRevDet() {
		return this.fDomRevDet;
	}
	
	/**
	 * Column Info
	 * @return rowNum
	 */
	public String getRowNum() {
		return this.rowNum;
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
	 * @return eqOffhQty
	 */
	public String getEqOffhQty() {
		return this.eqOffhQty;
	}
	
	/**
	 * Column Info
	 * @return offhSimMtyCostAmt
	 */
	public String getOffhSimMtyCostAmt() {
		return this.offhSimMtyCostAmt;
	}
	
	/**
	 * Column Info
	 * @return dispQty
	 */
	public String getDispQty() {
		return this.dispQty;
	}
	
	/**
	 * Column Info
	 * @return fCntrTpszCd
	 */
	public String getFCntrTpszCd() {
		return this.fCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return cndDmstQty
	 */
	public String getCndDmstQty() {
		return this.cndDmstQty;
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
	 * @return dmstRailInvAmt
	 */
	public String getDmstRailInvAmt() {
		return this.dmstRailInvAmt;
	}
	
	/**
	 * Column Info
	 * @return offhTtlQty
	 */
	public String getOffhTtlQty() {
		return this.offhTtlQty;
	}
	
	/**
	 * Column Info
	 * @return eqRntlScgAmt
	 */
	public String getEqRntlScgAmt() {
		return this.eqRntlScgAmt;
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
	 * @return fCostLocGrpCd
	 */
	public String getFCostLocGrpCd() {
		return this.fCostLocGrpCd;
	}
	
	/**
	 * Column Info
	 * @return fCostYrmon
	 */
	public String getFCostYrmon() {
		return this.fCostYrmon;
	}
	
	/**
	 * Column Info
	 * @return railAgmtAmt
	 */
	public String getRailAgmtAmt() {
		return this.railAgmtAmt;
	}
	
	/**
	 * Column Info
	 * @return eqOffhSavAmt
	 */
	public String getEqOffhSavAmt() {
		return this.eqOffhSavAmt;
	}
	
	/**
	 * Column Info
	 * @return railSoVolQty
	 */
	public String getRailSoVolQty() {
		return this.railSoVolQty;
	}
	
	/**
	 * Column Info
	 * @return railgAmt
	 */
	public String getRailgAmt() {
		return this.railgAmt;
	}
	
	/**
	 * Column Info
	 * @return dmstTtlFrtRevAmt
	 */
	public String getDmstTtlFrtRevAmt() {
		return this.dmstTtlFrtRevAmt;
	}
	
	/**
	 * Column Info
	 * @return initUsaDmstSavUtAmt
	 */
	public String getInitUsaDmstSavUtAmt() {
		return this.initUsaDmstSavUtAmt;
	}
	
	/**
	 * Column Info
	 * @return fuelScgAmt
	 */
	public String getFuelScgAmt() {
		return this.fuelScgAmt;
	}
	
	/**
	 * Column Info
	 * @return trpQty
	 */
	public String getTrpQty() {
		return this.trpQty;
	}
	
	/**
	 * Column Info
	 * @return trpCrUcInitAmt
	 */
	public String getTrpCrUcInitAmt() {
		return this.trpCrUcInitAmt;
	}
	
	/**
	 * Column Info
	 * @return fcntrIbVolQty
	 */
	public String getFcntrIbVolQty() {
		return this.fcntrIbVolQty;
	}
	
	/**
	 * Column Info
	 * @return orgRailLocCd
	 */
	public String getOrgRailLocCd() {
		return this.orgRailLocCd;
	}
	
	/**
	 * Column Info
	 * @return dmstVolQty
	 */
	public String getDmstVolQty() {
		return this.dmstVolQty;
	}
	
	/**
	 * Column Info
	 * @return subLseOutQty
	 */
	public String getSubLseOutQty() {
		return this.subLseOutQty;
	}
	
	/**
	 * Column Info
	 * @return trpSimMtyCostAmt
	 */
	public String getTrpSimMtyCostAmt() {
		return this.trpSimMtyCostAmt;
	}
	
	/**
	 * Column Info
	 * @return costLocGrpCd
	 */
	public String getCostLocGrpCd() {
		return this.costLocGrpCd;
	}
	
	/**
	 * Column Info
	 * @return eqOffhFnlUcInitAmt
	 */
	public String getEqOffhFnlUcInitAmt() {
		return this.eqOffhFnlUcInitAmt;
	}
	
	/**
	 * Column Info
	 * @return eqOffhUcAmt
	 */
	public String getEqOffhUcAmt() {
		return this.eqOffhUcAmt;
	}
	

	/**
	 * Column Info
	 * @param simMtyCostAmt
	 */
	public void setSimMtyCostAmt(String simMtyCostAmt) {
		this.simMtyCostAmt = simMtyCostAmt;
	}
	
	/**
	 * Column Info
	 * @param railUcAmt
	 */
	public void setRailUcAmt(String railUcAmt) {
		this.railUcAmt = railUcAmt;
	}
	
	/**
	 * Column Info
	 * @param eqOffhSavUcInitAmt
	 */
	public void setEqOffhSavUcInitAmt(String eqOffhSavUcInitAmt) {
		this.eqOffhSavUcInitAmt = eqOffhSavUcInitAmt;
	}
	
	/**
	 * Column Info
	 * @param trpSavAmt
	 */
	public void setTrpSavAmt(String trpSavAmt) {
		this.trpSavAmt = trpSavAmt;
	}
	
	/**
	 * Column Info
	 * @param domRevUcAmt
	 */
	public void setDomRevUcAmt(String domRevUcAmt) {
		this.domRevUcAmt = domRevUcAmt;
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
	 * @param fCreEndDt
	 */
	public void setFCreEndDt(String fCreEndDt) {
		this.fCreEndDt = fCreEndDt;
	}
	
	/**
	 * Column Info
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param eqOffhFnlUcAmt
	 */
	public void setEqOffhFnlUcAmt(String eqOffhFnlUcAmt) {
		this.eqOffhFnlUcAmt = eqOffhFnlUcAmt;
	}
	
	/**
	 * Column Info
	 * @param railHub
	 */
	public void setRailHub(String railHub) {
		this.railHub = railHub;
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
	 * @param hzdMtrlScgAmt
	 */
	public void setHzdMtrlScgAmt(String hzdMtrlScgAmt) {
		this.hzdMtrlScgAmt = hzdMtrlScgAmt;
	}
	
	/**
	 * Column Info
	 * @param usaDmstUcAmt
	 */
	public void setUsaDmstUcAmt(String usaDmstUcAmt) {
		this.usaDmstUcAmt = usaDmstUcAmt;
	}
	
	/**
	 * Column Info
	 * @param trpUcAmt
	 */
	public void setTrpUcAmt(String trpUcAmt) {
		this.trpUcAmt = trpUcAmt;
	}
	
	/**
	 * Column Info
	 * @param usaDmstCostAmt
	 */
	public void setUsaDmstCostAmt(String usaDmstCostAmt) {
		this.usaDmstCostAmt = usaDmstCostAmt;
	}
	
	/**
	 * Column Info
	 * @param trpCrUcAmt
	 */
	public void setTrpCrUcAmt(String trpCrUcAmt) {
		this.trpCrUcAmt = trpCrUcAmt;
	}
	
	/**
	 * Column Info
	 * @param fCreStartDt
	 */
	public void setFCreStartDt(String fCreStartDt) {
		this.fCreStartDt = fCreStartDt;
	}
	
	/**
	 * Column Info
	 * @param eqOffhSavUcAmt
	 */
	public void setEqOffhSavUcAmt(String eqOffhSavUcAmt) {
		this.eqOffhSavUcAmt = eqOffhSavUcAmt;
	}
	
	/**
	 * Column Info
	 * @param simMtyUcAmt
	 */
	public void setSimMtyUcAmt(String simMtyUcAmt) {
		this.simMtyUcAmt = simMtyUcAmt;
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
	 * @param trpAmt
	 */
	public void setTrpAmt(String trpAmt) {
		this.trpAmt = trpAmt;
	}
	
	/**
	 * Column Info
	 * @param initSimMtyUcAmt
	 */
	public void setInitSimMtyUcAmt(String initSimMtyUcAmt) {
		this.initSimMtyUcAmt = initSimMtyUcAmt;
	}
	
	/**
	 * Column Info
	 * @param usaDmstSavCostAmt
	 */
	public void setUsaDmstSavCostAmt(String usaDmstSavCostAmt) {
		this.usaDmstSavCostAmt = usaDmstSavCostAmt;
	}
	
	/**
	 * Column Info
	 * @param usaDmstSavUtAmt
	 */
	public void setUsaDmstSavUtAmt(String usaDmstSavUtAmt) {
		this.usaDmstSavUtAmt = usaDmstSavUtAmt;
	}
	
	/**
	 * Column Info
	 * @param fEccCd
	 */
	public void setFEccCd(String fEccCd) {
		this.fEccCd = fEccCd;
	}
	
	/**
	 * Column Info
	 * @param fDomRevDet
	 */
	public void setFDomRevDet(String fDomRevDet) {
		this.fDomRevDet = fDomRevDet;
	}
	
	/**
	 * Column Info
	 * @param rowNum
	 */
	public void setRowNum(String rowNum) {
		this.rowNum = rowNum;
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
	 * @param eqOffhQty
	 */
	public void setEqOffhQty(String eqOffhQty) {
		this.eqOffhQty = eqOffhQty;
	}
	
	/**
	 * Column Info
	 * @param offhSimMtyCostAmt
	 */
	public void setOffhSimMtyCostAmt(String offhSimMtyCostAmt) {
		this.offhSimMtyCostAmt = offhSimMtyCostAmt;
	}
	
	/**
	 * Column Info
	 * @param dispQty
	 */
	public void setDispQty(String dispQty) {
		this.dispQty = dispQty;
	}
	
	/**
	 * Column Info
	 * @param fCntrTpszCd
	 */
	public void setFCntrTpszCd(String fCntrTpszCd) {
		this.fCntrTpszCd = fCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param cndDmstQty
	 */
	public void setCndDmstQty(String cndDmstQty) {
		this.cndDmstQty = cndDmstQty;
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
	 * @param dmstRailInvAmt
	 */
	public void setDmstRailInvAmt(String dmstRailInvAmt) {
		this.dmstRailInvAmt = dmstRailInvAmt;
	}
	
	/**
	 * Column Info
	 * @param offhTtlQty
	 */
	public void setOffhTtlQty(String offhTtlQty) {
		this.offhTtlQty = offhTtlQty;
	}
	
	/**
	 * Column Info
	 * @param eqRntlScgAmt
	 */
	public void setEqRntlScgAmt(String eqRntlScgAmt) {
		this.eqRntlScgAmt = eqRntlScgAmt;
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
	 * @param fCostLocGrpCd
	 */
	public void setFCostLocGrpCd(String fCostLocGrpCd) {
		this.fCostLocGrpCd = fCostLocGrpCd;
	}
	
	/**
	 * Column Info
	 * @param fCostYrmon
	 */
	public void setFCostYrmon(String fCostYrmon) {
		this.fCostYrmon = fCostYrmon;
	}
	
	/**
	 * Column Info
	 * @param railAgmtAmt
	 */
	public void setRailAgmtAmt(String railAgmtAmt) {
		this.railAgmtAmt = railAgmtAmt;
	}
	
	/**
	 * Column Info
	 * @param eqOffhSavAmt
	 */
	public void setEqOffhSavAmt(String eqOffhSavAmt) {
		this.eqOffhSavAmt = eqOffhSavAmt;
	}
	
	/**
	 * Column Info
	 * @param railSoVolQty
	 */
	public void setRailSoVolQty(String railSoVolQty) {
		this.railSoVolQty = railSoVolQty;
	}
	
	/**
	 * Column Info
	 * @param railgAmt
	 */
	public void setRailgAmt(String railgAmt) {
		this.railgAmt = railgAmt;
	}
	
	/**
	 * Column Info
	 * @param dmstTtlFrtRevAmt
	 */
	public void setDmstTtlFrtRevAmt(String dmstTtlFrtRevAmt) {
		this.dmstTtlFrtRevAmt = dmstTtlFrtRevAmt;
	}
	
	/**
	 * Column Info
	 * @param initUsaDmstSavUtAmt
	 */
	public void setInitUsaDmstSavUtAmt(String initUsaDmstSavUtAmt) {
		this.initUsaDmstSavUtAmt = initUsaDmstSavUtAmt;
	}
	
	/**
	 * Column Info
	 * @param fuelScgAmt
	 */
	public void setFuelScgAmt(String fuelScgAmt) {
		this.fuelScgAmt = fuelScgAmt;
	}
	
	/**
	 * Column Info
	 * @param trpQty
	 */
	public void setTrpQty(String trpQty) {
		this.trpQty = trpQty;
	}
	
	/**
	 * Column Info
	 * @param trpCrUcInitAmt
	 */
	public void setTrpCrUcInitAmt(String trpCrUcInitAmt) {
		this.trpCrUcInitAmt = trpCrUcInitAmt;
	}
	
	/**
	 * Column Info
	 * @param fcntrIbVolQty
	 */
	public void setFcntrIbVolQty(String fcntrIbVolQty) {
		this.fcntrIbVolQty = fcntrIbVolQty;
	}
	
	/**
	 * Column Info
	 * @param orgRailLocCd
	 */
	public void setOrgRailLocCd(String orgRailLocCd) {
		this.orgRailLocCd = orgRailLocCd;
	}
	
	/**
	 * Column Info
	 * @param dmstVolQty
	 */
	public void setDmstVolQty(String dmstVolQty) {
		this.dmstVolQty = dmstVolQty;
	}
	
	/**
	 * Column Info
	 * @param subLseOutQty
	 */
	public void setSubLseOutQty(String subLseOutQty) {
		this.subLseOutQty = subLseOutQty;
	}
	
	/**
	 * Column Info
	 * @param trpSimMtyCostAmt
	 */
	public void setTrpSimMtyCostAmt(String trpSimMtyCostAmt) {
		this.trpSimMtyCostAmt = trpSimMtyCostAmt;
	}
	
	/**
	 * Column Info
	 * @param costLocGrpCd
	 */
	public void setCostLocGrpCd(String costLocGrpCd) {
		this.costLocGrpCd = costLocGrpCd;
	}
	
	/**
	 * Column Info
	 * @param eqOffhFnlUcInitAmt
	 */
	public void setEqOffhFnlUcInitAmt(String eqOffhFnlUcInitAmt) {
		this.eqOffhFnlUcInitAmt = eqOffhFnlUcInitAmt;
	}
	
	/**
	 * Column Info
	 * @param eqOffhUcAmt
	 */
	public void setEqOffhUcAmt(String eqOffhUcAmt) {
		this.eqOffhUcAmt = eqOffhUcAmt;
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
		setSimMtyCostAmt(JSPUtil.getParameter(request, prefix + "sim_mty_cost_amt", ""));
		setRailUcAmt(JSPUtil.getParameter(request, prefix + "rail_uc_amt", ""));
		setEqOffhSavUcInitAmt(JSPUtil.getParameter(request, prefix + "eq_offh_sav_uc_init_amt", ""));
		setTrpSavAmt(JSPUtil.getParameter(request, prefix + "trp_sav_amt", ""));
		setDomRevUcAmt(JSPUtil.getParameter(request, prefix + "dom_rev_uc_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFCreEndDt(JSPUtil.getParameter(request, prefix + "f_cre_end_dt", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setEqOffhFnlUcAmt(JSPUtil.getParameter(request, prefix + "eq_offh_fnl_uc_amt", ""));
		setRailHub(JSPUtil.getParameter(request, prefix + "rail_hub", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setHzdMtrlScgAmt(JSPUtil.getParameter(request, prefix + "hzd_mtrl_scg_amt", ""));
		setUsaDmstUcAmt(JSPUtil.getParameter(request, prefix + "usa_dmst_uc_amt", ""));
		setTrpUcAmt(JSPUtil.getParameter(request, prefix + "trp_uc_amt", ""));
		setUsaDmstCostAmt(JSPUtil.getParameter(request, prefix + "usa_dmst_cost_amt", ""));
		setTrpCrUcAmt(JSPUtil.getParameter(request, prefix + "trp_cr_uc_amt", ""));
		setFCreStartDt(JSPUtil.getParameter(request, prefix + "f_cre_start_dt", ""));
		setEqOffhSavUcAmt(JSPUtil.getParameter(request, prefix + "eq_offh_sav_uc_amt", ""));
		setSimMtyUcAmt(JSPUtil.getParameter(request, prefix + "sim_mty_uc_amt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setTrpAmt(JSPUtil.getParameter(request, prefix + "trp_amt", ""));
		setInitSimMtyUcAmt(JSPUtil.getParameter(request, prefix + "init_sim_mty_uc_amt", ""));
		setUsaDmstSavCostAmt(JSPUtil.getParameter(request, prefix + "usa_dmst_sav_cost_amt", ""));
		setUsaDmstSavUtAmt(JSPUtil.getParameter(request, prefix + "usa_dmst_sav_ut_amt", ""));
		setFEccCd(JSPUtil.getParameter(request, prefix + "f_ecc_cd", ""));
		setFDomRevDet(JSPUtil.getParameter(request, prefix + "f_dom_rev_det", ""));
		setRowNum(JSPUtil.getParameter(request, prefix + "row_num", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setEqOffhQty(JSPUtil.getParameter(request, prefix + "eq_offh_qty", ""));
		setOffhSimMtyCostAmt(JSPUtil.getParameter(request, prefix + "offh_sim_mty_cost_amt", ""));
		setDispQty(JSPUtil.getParameter(request, prefix + "disp_qty", ""));
		setFCntrTpszCd(JSPUtil.getParameter(request, prefix + "f_cntr_tpsz_cd", ""));
		setCndDmstQty(JSPUtil.getParameter(request, prefix + "cnd_dmst_qty", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDmstRailInvAmt(JSPUtil.getParameter(request, prefix + "dmst_rail_inv_amt", ""));
		setOffhTtlQty(JSPUtil.getParameter(request, prefix + "offh_ttl_qty", ""));
		setEqRntlScgAmt(JSPUtil.getParameter(request, prefix + "eq_rntl_scg_amt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setFCostLocGrpCd(JSPUtil.getParameter(request, prefix + "f_cost_loc_grp_cd", ""));
		setFCostYrmon(JSPUtil.getParameter(request, prefix + "f_cost_yrmon", ""));
		setRailAgmtAmt(JSPUtil.getParameter(request, prefix + "rail_agmt_amt", ""));
		setEqOffhSavAmt(JSPUtil.getParameter(request, prefix + "eq_offh_sav_amt", ""));
		setRailSoVolQty(JSPUtil.getParameter(request, prefix + "rail_so_vol_qty", ""));
		setRailgAmt(JSPUtil.getParameter(request, prefix + "railg_amt", ""));
		setDmstTtlFrtRevAmt(JSPUtil.getParameter(request, prefix + "dmst_ttl_frt_rev_amt", ""));
		setInitUsaDmstSavUtAmt(JSPUtil.getParameter(request, prefix + "init_usa_dmst_sav_ut_amt", ""));
		setFuelScgAmt(JSPUtil.getParameter(request, prefix + "fuel_scg_amt", ""));
		setTrpQty(JSPUtil.getParameter(request, prefix + "trp_qty", ""));
		setTrpCrUcInitAmt(JSPUtil.getParameter(request, prefix + "trp_cr_uc_init_amt", ""));
		setFcntrIbVolQty(JSPUtil.getParameter(request, prefix + "fcntr_ib_vol_qty", ""));
		setOrgRailLocCd(JSPUtil.getParameter(request, prefix + "org_rail_loc_cd", ""));
		setDmstVolQty(JSPUtil.getParameter(request, prefix + "dmst_vol_qty", ""));
		setSubLseOutQty(JSPUtil.getParameter(request, prefix + "sub_lse_out_qty", ""));
		setTrpSimMtyCostAmt(JSPUtil.getParameter(request, prefix + "trp_sim_mty_cost_amt", ""));
		setCostLocGrpCd(JSPUtil.getParameter(request, prefix + "cost_loc_grp_cd", ""));
		setEqOffhFnlUcInitAmt(JSPUtil.getParameter(request, prefix + "eq_offh_fnl_uc_init_amt", ""));
		setEqOffhUcAmt(JSPUtil.getParameter(request, prefix + "eq_offh_uc_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchUSDomesticVO[]
	 */
	public SearchUSDomesticVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchUSDomesticVO[]
	 */
	public SearchUSDomesticVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchUSDomesticVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] simMtyCostAmt = (JSPUtil.getParameter(request, prefix	+ "sim_mty_cost_amt", length));
			String[] railUcAmt = (JSPUtil.getParameter(request, prefix	+ "rail_uc_amt", length));
			String[] eqOffhSavUcInitAmt = (JSPUtil.getParameter(request, prefix	+ "eq_offh_sav_uc_init_amt", length));
			String[] trpSavAmt = (JSPUtil.getParameter(request, prefix	+ "trp_sav_amt", length));
			String[] domRevUcAmt = (JSPUtil.getParameter(request, prefix	+ "dom_rev_uc_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fCreEndDt = (JSPUtil.getParameter(request, prefix	+ "f_cre_end_dt", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] eqOffhFnlUcAmt = (JSPUtil.getParameter(request, prefix	+ "eq_offh_fnl_uc_amt", length));
			String[] railHub = (JSPUtil.getParameter(request, prefix	+ "rail_hub", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] hzdMtrlScgAmt = (JSPUtil.getParameter(request, prefix	+ "hzd_mtrl_scg_amt", length));
			String[] usaDmstUcAmt = (JSPUtil.getParameter(request, prefix	+ "usa_dmst_uc_amt", length));
			String[] trpUcAmt = (JSPUtil.getParameter(request, prefix	+ "trp_uc_amt", length));
			String[] usaDmstCostAmt = (JSPUtil.getParameter(request, prefix	+ "usa_dmst_cost_amt", length));
			String[] trpCrUcAmt = (JSPUtil.getParameter(request, prefix	+ "trp_cr_uc_amt", length));
			String[] fCreStartDt = (JSPUtil.getParameter(request, prefix	+ "f_cre_start_dt", length));
			String[] eqOffhSavUcAmt = (JSPUtil.getParameter(request, prefix	+ "eq_offh_sav_uc_amt", length));
			String[] simMtyUcAmt = (JSPUtil.getParameter(request, prefix	+ "sim_mty_uc_amt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] trpAmt = (JSPUtil.getParameter(request, prefix	+ "trp_amt", length));
			String[] initSimMtyUcAmt = (JSPUtil.getParameter(request, prefix	+ "init_sim_mty_uc_amt", length));
			String[] usaDmstSavCostAmt = (JSPUtil.getParameter(request, prefix	+ "usa_dmst_sav_cost_amt", length));
			String[] usaDmstSavUtAmt = (JSPUtil.getParameter(request, prefix	+ "usa_dmst_sav_ut_amt", length));
			String[] fEccCd = (JSPUtil.getParameter(request, prefix	+ "f_ecc_cd", length));
			String[] fDomRevDet = (JSPUtil.getParameter(request, prefix	+ "f_dom_rev_det", length));
			String[] rowNum = (JSPUtil.getParameter(request, prefix	+ "row_num", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] eqOffhQty = (JSPUtil.getParameter(request, prefix	+ "eq_offh_qty", length));
			String[] offhSimMtyCostAmt = (JSPUtil.getParameter(request, prefix	+ "offh_sim_mty_cost_amt", length));
			String[] dispQty = (JSPUtil.getParameter(request, prefix	+ "disp_qty", length));
			String[] fCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "f_cntr_tpsz_cd", length));
			String[] cndDmstQty = (JSPUtil.getParameter(request, prefix	+ "cnd_dmst_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dmstRailInvAmt = (JSPUtil.getParameter(request, prefix	+ "dmst_rail_inv_amt", length));
			String[] offhTtlQty = (JSPUtil.getParameter(request, prefix	+ "offh_ttl_qty", length));
			String[] eqRntlScgAmt = (JSPUtil.getParameter(request, prefix	+ "eq_rntl_scg_amt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] fCostLocGrpCd = (JSPUtil.getParameter(request, prefix	+ "f_cost_loc_grp_cd", length));
			String[] fCostYrmon = (JSPUtil.getParameter(request, prefix	+ "f_cost_yrmon", length));
			String[] railAgmtAmt = (JSPUtil.getParameter(request, prefix	+ "rail_agmt_amt", length));
			String[] eqOffhSavAmt = (JSPUtil.getParameter(request, prefix	+ "eq_offh_sav_amt", length));
			String[] railSoVolQty = (JSPUtil.getParameter(request, prefix	+ "rail_so_vol_qty", length));
			String[] railgAmt = (JSPUtil.getParameter(request, prefix	+ "railg_amt", length));
			String[] dmstTtlFrtRevAmt = (JSPUtil.getParameter(request, prefix	+ "dmst_ttl_frt_rev_amt", length));
			String[] initUsaDmstSavUtAmt = (JSPUtil.getParameter(request, prefix	+ "init_usa_dmst_sav_ut_amt", length));
			String[] fuelScgAmt = (JSPUtil.getParameter(request, prefix	+ "fuel_scg_amt", length));
			String[] trpQty = (JSPUtil.getParameter(request, prefix	+ "trp_qty", length));
			String[] trpCrUcInitAmt = (JSPUtil.getParameter(request, prefix	+ "trp_cr_uc_init_amt", length));
			String[] fcntrIbVolQty = (JSPUtil.getParameter(request, prefix	+ "fcntr_ib_vol_qty", length));
			String[] orgRailLocCd = (JSPUtil.getParameter(request, prefix	+ "org_rail_loc_cd", length));
			String[] dmstVolQty = (JSPUtil.getParameter(request, prefix	+ "dmst_vol_qty", length));
			String[] subLseOutQty = (JSPUtil.getParameter(request, prefix	+ "sub_lse_out_qty", length));
			String[] trpSimMtyCostAmt = (JSPUtil.getParameter(request, prefix	+ "trp_sim_mty_cost_amt", length));
			String[] costLocGrpCd = (JSPUtil.getParameter(request, prefix	+ "cost_loc_grp_cd", length));
			String[] eqOffhFnlUcInitAmt = (JSPUtil.getParameter(request, prefix	+ "eq_offh_fnl_uc_init_amt", length));
			String[] eqOffhUcAmt = (JSPUtil.getParameter(request, prefix	+ "eq_offh_uc_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchUSDomesticVO();
				if (simMtyCostAmt[i] != null)
					model.setSimMtyCostAmt(simMtyCostAmt[i]);
				if (railUcAmt[i] != null)
					model.setRailUcAmt(railUcAmt[i]);
				if (eqOffhSavUcInitAmt[i] != null)
					model.setEqOffhSavUcInitAmt(eqOffhSavUcInitAmt[i]);
				if (trpSavAmt[i] != null)
					model.setTrpSavAmt(trpSavAmt[i]);
				if (domRevUcAmt[i] != null)
					model.setDomRevUcAmt(domRevUcAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fCreEndDt[i] != null)
					model.setFCreEndDt(fCreEndDt[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (eqOffhFnlUcAmt[i] != null)
					model.setEqOffhFnlUcAmt(eqOffhFnlUcAmt[i]);
				if (railHub[i] != null)
					model.setRailHub(railHub[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (hzdMtrlScgAmt[i] != null)
					model.setHzdMtrlScgAmt(hzdMtrlScgAmt[i]);
				if (usaDmstUcAmt[i] != null)
					model.setUsaDmstUcAmt(usaDmstUcAmt[i]);
				if (trpUcAmt[i] != null)
					model.setTrpUcAmt(trpUcAmt[i]);
				if (usaDmstCostAmt[i] != null)
					model.setUsaDmstCostAmt(usaDmstCostAmt[i]);
				if (trpCrUcAmt[i] != null)
					model.setTrpCrUcAmt(trpCrUcAmt[i]);
				if (fCreStartDt[i] != null)
					model.setFCreStartDt(fCreStartDt[i]);
				if (eqOffhSavUcAmt[i] != null)
					model.setEqOffhSavUcAmt(eqOffhSavUcAmt[i]);
				if (simMtyUcAmt[i] != null)
					model.setSimMtyUcAmt(simMtyUcAmt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (trpAmt[i] != null)
					model.setTrpAmt(trpAmt[i]);
				if (initSimMtyUcAmt[i] != null)
					model.setInitSimMtyUcAmt(initSimMtyUcAmt[i]);
				if (usaDmstSavCostAmt[i] != null)
					model.setUsaDmstSavCostAmt(usaDmstSavCostAmt[i]);
				if (usaDmstSavUtAmt[i] != null)
					model.setUsaDmstSavUtAmt(usaDmstSavUtAmt[i]);
				if (fEccCd[i] != null)
					model.setFEccCd(fEccCd[i]);
				if (fDomRevDet[i] != null)
					model.setFDomRevDet(fDomRevDet[i]);
				if (rowNum[i] != null)
					model.setRowNum(rowNum[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (eqOffhQty[i] != null)
					model.setEqOffhQty(eqOffhQty[i]);
				if (offhSimMtyCostAmt[i] != null)
					model.setOffhSimMtyCostAmt(offhSimMtyCostAmt[i]);
				if (dispQty[i] != null)
					model.setDispQty(dispQty[i]);
				if (fCntrTpszCd[i] != null)
					model.setFCntrTpszCd(fCntrTpszCd[i]);
				if (cndDmstQty[i] != null)
					model.setCndDmstQty(cndDmstQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dmstRailInvAmt[i] != null)
					model.setDmstRailInvAmt(dmstRailInvAmt[i]);
				if (offhTtlQty[i] != null)
					model.setOffhTtlQty(offhTtlQty[i]);
				if (eqRntlScgAmt[i] != null)
					model.setEqRntlScgAmt(eqRntlScgAmt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (fCostLocGrpCd[i] != null)
					model.setFCostLocGrpCd(fCostLocGrpCd[i]);
				if (fCostYrmon[i] != null)
					model.setFCostYrmon(fCostYrmon[i]);
				if (railAgmtAmt[i] != null)
					model.setRailAgmtAmt(railAgmtAmt[i]);
				if (eqOffhSavAmt[i] != null)
					model.setEqOffhSavAmt(eqOffhSavAmt[i]);
				if (railSoVolQty[i] != null)
					model.setRailSoVolQty(railSoVolQty[i]);
				if (railgAmt[i] != null)
					model.setRailgAmt(railgAmt[i]);
				if (dmstTtlFrtRevAmt[i] != null)
					model.setDmstTtlFrtRevAmt(dmstTtlFrtRevAmt[i]);
				if (initUsaDmstSavUtAmt[i] != null)
					model.setInitUsaDmstSavUtAmt(initUsaDmstSavUtAmt[i]);
				if (fuelScgAmt[i] != null)
					model.setFuelScgAmt(fuelScgAmt[i]);
				if (trpQty[i] != null)
					model.setTrpQty(trpQty[i]);
				if (trpCrUcInitAmt[i] != null)
					model.setTrpCrUcInitAmt(trpCrUcInitAmt[i]);
				if (fcntrIbVolQty[i] != null)
					model.setFcntrIbVolQty(fcntrIbVolQty[i]);
				if (orgRailLocCd[i] != null)
					model.setOrgRailLocCd(orgRailLocCd[i]);
				if (dmstVolQty[i] != null)
					model.setDmstVolQty(dmstVolQty[i]);
				if (subLseOutQty[i] != null)
					model.setSubLseOutQty(subLseOutQty[i]);
				if (trpSimMtyCostAmt[i] != null)
					model.setTrpSimMtyCostAmt(trpSimMtyCostAmt[i]);
				if (costLocGrpCd[i] != null)
					model.setCostLocGrpCd(costLocGrpCd[i]);
				if (eqOffhFnlUcInitAmt[i] != null)
					model.setEqOffhFnlUcInitAmt(eqOffhFnlUcInitAmt[i]);
				if (eqOffhUcAmt[i] != null)
					model.setEqOffhUcAmt(eqOffhUcAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchUSDomesticVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchUSDomesticVO[]
	 */
	public SearchUSDomesticVO[] getSearchUSDomesticVOs(){
		SearchUSDomesticVO[] vos = (SearchUSDomesticVO[])models.toArray(new SearchUSDomesticVO[models.size()]);
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
		this.simMtyCostAmt = this.simMtyCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railUcAmt = this.railUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqOffhSavUcInitAmt = this.eqOffhSavUcInitAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trpSavAmt = this.trpSavAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.domRevUcAmt = this.domRevUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCreEndDt = this.fCreEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqOffhFnlUcAmt = this.eqOffhFnlUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railHub = this.railHub .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hzdMtrlScgAmt = this.hzdMtrlScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaDmstUcAmt = this.usaDmstUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trpUcAmt = this.trpUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaDmstCostAmt = this.usaDmstCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trpCrUcAmt = this.trpCrUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCreStartDt = this.fCreStartDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqOffhSavUcAmt = this.eqOffhSavUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simMtyUcAmt = this.simMtyUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trpAmt = this.trpAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initSimMtyUcAmt = this.initSimMtyUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaDmstSavCostAmt = this.usaDmstSavCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaDmstSavUtAmt = this.usaDmstSavUtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fEccCd = this.fEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDomRevDet = this.fDomRevDet .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowNum = this.rowNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqOffhQty = this.eqOffhQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhSimMtyCostAmt = this.offhSimMtyCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispQty = this.dispQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCntrTpszCd = this.fCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cndDmstQty = this.cndDmstQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmstRailInvAmt = this.dmstRailInvAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhTtlQty = this.offhTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqRntlScgAmt = this.eqRntlScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCostLocGrpCd = this.fCostLocGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCostYrmon = this.fCostYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railAgmtAmt = this.railAgmtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqOffhSavAmt = this.eqOffhSavAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railSoVolQty = this.railSoVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railgAmt = this.railgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmstTtlFrtRevAmt = this.dmstTtlFrtRevAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initUsaDmstSavUtAmt = this.initUsaDmstSavUtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fuelScgAmt = this.fuelScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trpQty = this.trpQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trpCrUcInitAmt = this.trpCrUcInitAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcntrIbVolQty = this.fcntrIbVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRailLocCd = this.orgRailLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmstVolQty = this.dmstVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subLseOutQty = this.subLseOutQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trpSimMtyCostAmt = this.trpSimMtyCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costLocGrpCd = this.costLocGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqOffhFnlUcInitAmt = this.eqOffhFnlUcInitAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqOffhUcAmt = this.eqOffhUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
