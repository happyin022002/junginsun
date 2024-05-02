/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchModelManageListVO.java
*@FileTitle : SearchModelManageListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.27  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class SearchModelManageListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchModelManageListVO> models = new ArrayList<SearchModelManageListVO>();
	
	/* Column Info */
	private String custTtlQty = null;
	/* Column Info */
	private String spcCtrlMdlMnlRmk = null;
	/* Column Info */
	private String strdFlag2 = null;
	/* Column Info */
	private String oAdd = null;
	/* Column Info */
	private String acctClssCd = null;
	/* Column Info */
	private String raplyCfmFlg = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String custCtrlCd = null;
	/* Column Info */
	private String rlaneTtlQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String acctClss = null;
	/* Column Info */
	private String rlaneAdjQty = null;
	/* Column Info */
	private String custAdjQtyUpdFlg = null;
	/* Column Info */
	private String custGrpNm = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String smplRlaneQty = null;
	/* Column Info */
	private String ofcHo = null;
	/* Column Info */
	private String loadTtlQta = null;
	/* Column Info */
	private String dtlSeq = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String realIbflag = null;
	/* Column Info */
	private String g2CngUsr = null;
	/* Column Info */
	private String revLaneCustCnt = null;
	/* Column Info */
	private String wkMqcQty = null;
	/* Column Info */
	private String strdAdjTtlQty = null;
	/* Column Info */
	private String strdFlag = null;
	/* Column Info */
	private String strdPfmcRatio = null;
	/* Column Info */
	private String smplStrdQty = null;
	/* Column Info */
	private String slsRhqCd = null;
	/* Column Info */
	private String rlaneCmpb = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String custQty = null;
	/* Column Info */
	private String cngOfcList = null;
	/* Column Info */
	private String season = null;
	/* Column Info */
	private String strdAdjQty = null;
	/* Column Info */
	private String rlanePfmcRatio = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String costYrwk = null;
	/* Column Info */
	private String orgRlaneCd = null;
	/* Column Info */
	private String smplCustQty = null;
	/* Column Info */
	private String rRmk = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String g1CngUsr = null;
	/* Column Info */
	private String strdTtlQty = null;
	/* Column Info */
	private String custAdjQty = null;
	/* Column Info */
	private String spcCtrlMdlMnlCd = null;
	/* Column Info */
	private String version = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String scRfaFlg = null;
	/* Column Info */
	private String strdCmpb = null;
	/* Column Info */
	private String strdQty = null;
	/* Column Info */
	private String rhqHo = null;
	/* Column Info */
	private String loadQta = null;
	/* Column Info */
	private String spcCtrlMdlRmk = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String viewType = null;
	/* Column Info */
	private String g3CngUsr = null;
	/* Column Info */
	private String rlaneAdjTtlQty = null;
	/* Column Info */
	private String verSeq = null;
	/* Column Info */
	private String unit = null;
	/* Column Info */
	private String custAdjTtlQty = null;
	/* Column Info */
	private String t = null;
	/* Column Info */
	private String hoFlg = null;
	/* Column Info */
	private String laneHo = null;
	/* Column Info */
	private String slsRgnOfcCd = null;
	/* Column Info */
	private String rlaneQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchModelManageListVO() {}

	public SearchModelManageListVO(String ibflag, String pagerows, String custAdjQty, String trdCd, String rlaneCd, String custCtrlCd, String rfaNo, String custAdjQtyUpdFlg, String rlaneAdjQty, String custGrpNm, String scNo, String ctrtOfcCd, String custCntCd, String strdCmpb, String strdQty, String wkMqcQty, String strdPfmcRatio, String custSeq, String slsRhqCd, String rlaneCmpb, String custLglEngNm, String verSeq, String custQty, String strdAdjQty, String slsRgnOfcCd, String rlanePfmcRatio, String subTrdCd, String costYrwk, String rlaneQty, String custTtlQty, String strdTtlQty, String t, String acctClssCd, String acctClss, String acctCd, String viewType, String usrId, String unit, String season, String version, String custAdjTtlQty, String strdAdjTtlQty, String rlaneTtlQty, String rlaneAdjTtlQty, String strdFlag, String strdFlag2, String realIbflag, String deltFlg, String spcCtrlMdlRmk, String spcCtrlMdlMnlCd, String spcCtrlMdlMnlRmk, String oAdd, String rRmk, String orgRlaneCd, String loadQta, String loadTtlQta, String revLaneCustCnt, String g1CngUsr, String g2CngUsr, String g3CngUsr, String cngOfcList, String rhqHo, String ofcHo, String laneHo, String hoFlg, String smplCustQty, String smplStrdQty, String smplRlaneQty, String dtlSeq, String scRfaFlg, String raplyCfmFlg) {
		this.custTtlQty = custTtlQty;
		this.spcCtrlMdlMnlRmk = spcCtrlMdlMnlRmk;
		this.strdFlag2 = strdFlag2;
		this.oAdd = oAdd;
		this.acctClssCd = acctClssCd;
		this.raplyCfmFlg = raplyCfmFlg;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.custCtrlCd = custCtrlCd;
		this.rlaneTtlQty = rlaneTtlQty;
		this.pagerows = pagerows;
		this.acctClss = acctClss;
		this.rlaneAdjQty = rlaneAdjQty;
		this.custAdjQtyUpdFlg = custAdjQtyUpdFlg;
		this.custGrpNm = custGrpNm;
		this.scNo = scNo;
		this.ctrtOfcCd = ctrtOfcCd;
		this.smplRlaneQty = smplRlaneQty;
		this.ofcHo = ofcHo;
		this.loadTtlQta = loadTtlQta;
		this.dtlSeq = dtlSeq;
		this.custCntCd = custCntCd;
		this.realIbflag = realIbflag;
		this.g2CngUsr = g2CngUsr;
		this.revLaneCustCnt = revLaneCustCnt;
		this.wkMqcQty = wkMqcQty;
		this.strdAdjTtlQty = strdAdjTtlQty;
		this.strdFlag = strdFlag;
		this.strdPfmcRatio = strdPfmcRatio;
		this.smplStrdQty = smplStrdQty;
		this.slsRhqCd = slsRhqCd;
		this.rlaneCmpb = rlaneCmpb;
		this.custLglEngNm = custLglEngNm;
		this.custQty = custQty;
		this.cngOfcList = cngOfcList;
		this.season = season;
		this.strdAdjQty = strdAdjQty;
		this.rlanePfmcRatio = rlanePfmcRatio;
		this.subTrdCd = subTrdCd;
		this.costYrwk = costYrwk;
		this.orgRlaneCd = orgRlaneCd;
		this.smplCustQty = smplCustQty;
		this.rRmk = rRmk;
		this.deltFlg = deltFlg;
		this.g1CngUsr = g1CngUsr;
		this.strdTtlQty = strdTtlQty;
		this.custAdjQty = custAdjQty;
		this.spcCtrlMdlMnlCd = spcCtrlMdlMnlCd;
		this.version = version;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.usrId = usrId;
		this.acctCd = acctCd;
		this.scRfaFlg = scRfaFlg;
		this.strdCmpb = strdCmpb;
		this.strdQty = strdQty;
		this.rhqHo = rhqHo;
		this.loadQta = loadQta;
		this.spcCtrlMdlRmk = spcCtrlMdlRmk;
		this.custSeq = custSeq;
		this.viewType = viewType;
		this.g3CngUsr = g3CngUsr;
		this.rlaneAdjTtlQty = rlaneAdjTtlQty;
		this.verSeq = verSeq;
		this.unit = unit;
		this.custAdjTtlQty = custAdjTtlQty;
		this.t = t;
		this.hoFlg = hoFlg;
		this.laneHo = laneHo;
		this.slsRgnOfcCd = slsRgnOfcCd;
		this.rlaneQty = rlaneQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cust_ttl_qty", getCustTtlQty());
		this.hashColumns.put("spc_ctrl_mdl_mnl_rmk", getSpcCtrlMdlMnlRmk());
		this.hashColumns.put("strd_flag2", getStrdFlag2());
		this.hashColumns.put("o_add", getOAdd());
		this.hashColumns.put("acct_clss_cd", getAcctClssCd());
		this.hashColumns.put("raply_cfm_flg", getRaplyCfmFlg());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("cust_ctrl_cd", getCustCtrlCd());
		this.hashColumns.put("rlane_ttl_qty", getRlaneTtlQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("acct_clss", getAcctClss());
		this.hashColumns.put("rlane_adj_qty", getRlaneAdjQty());
		this.hashColumns.put("cust_adj_qty_upd_flg", getCustAdjQtyUpdFlg());
		this.hashColumns.put("cust_grp_nm", getCustGrpNm());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("smpl_rlane_qty", getSmplRlaneQty());
		this.hashColumns.put("ofc_ho", getOfcHo());
		this.hashColumns.put("load_ttl_qta", getLoadTtlQta());
		this.hashColumns.put("dtl_seq", getDtlSeq());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("real_ibflag", getRealIbflag());
		this.hashColumns.put("g2_cng_usr", getG2CngUsr());
		this.hashColumns.put("rev_lane_cust_cnt", getRevLaneCustCnt());
		this.hashColumns.put("wk_mqc_qty", getWkMqcQty());
		this.hashColumns.put("strd_adj_ttl_qty", getStrdAdjTtlQty());
		this.hashColumns.put("strd_flag", getStrdFlag());
		this.hashColumns.put("strd_pfmc_ratio", getStrdPfmcRatio());
		this.hashColumns.put("smpl_strd_qty", getSmplStrdQty());
		this.hashColumns.put("sls_rhq_cd", getSlsRhqCd());
		this.hashColumns.put("rlane_cmpb", getRlaneCmpb());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("cust_qty", getCustQty());
		this.hashColumns.put("cng_ofc_list", getCngOfcList());
		this.hashColumns.put("season", getSeason());
		this.hashColumns.put("strd_adj_qty", getStrdAdjQty());
		this.hashColumns.put("rlane_pfmc_ratio", getRlanePfmcRatio());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("cost_yrwk", getCostYrwk());
		this.hashColumns.put("org_rlane_cd", getOrgRlaneCd());
		this.hashColumns.put("smpl_cust_qty", getSmplCustQty());
		this.hashColumns.put("r_rmk", getRRmk());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("g1_cng_usr", getG1CngUsr());
		this.hashColumns.put("strd_ttl_qty", getStrdTtlQty());
		this.hashColumns.put("cust_adj_qty", getCustAdjQty());
		this.hashColumns.put("spc_ctrl_mdl_mnl_cd", getSpcCtrlMdlMnlCd());
		this.hashColumns.put("version", getVersion());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("sc_rfa_flg", getScRfaFlg());
		this.hashColumns.put("strd_cmpb", getStrdCmpb());
		this.hashColumns.put("strd_qty", getStrdQty());
		this.hashColumns.put("rhq_ho", getRhqHo());
		this.hashColumns.put("load_qta", getLoadQta());
		this.hashColumns.put("spc_ctrl_mdl_rmk", getSpcCtrlMdlRmk());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("view_type", getViewType());
		this.hashColumns.put("g3_cng_usr", getG3CngUsr());
		this.hashColumns.put("rlane_adj_ttl_qty", getRlaneAdjTtlQty());
		this.hashColumns.put("ver_seq", getVerSeq());
		this.hashColumns.put("unit", getUnit());
		this.hashColumns.put("cust_adj_ttl_qty", getCustAdjTtlQty());
		this.hashColumns.put("t", getT());
		this.hashColumns.put("ho_flg", getHoFlg());
		this.hashColumns.put("lane_ho", getLaneHo());
		this.hashColumns.put("sls_rgn_ofc_cd", getSlsRgnOfcCd());
		this.hashColumns.put("rlane_qty", getRlaneQty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cust_ttl_qty", "custTtlQty");
		this.hashFields.put("spc_ctrl_mdl_mnl_rmk", "spcCtrlMdlMnlRmk");
		this.hashFields.put("strd_flag2", "strdFlag2");
		this.hashFields.put("o_add", "oAdd");
		this.hashFields.put("acct_clss_cd", "acctClssCd");
		this.hashFields.put("raply_cfm_flg", "raplyCfmFlg");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("cust_ctrl_cd", "custCtrlCd");
		this.hashFields.put("rlane_ttl_qty", "rlaneTtlQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("acct_clss", "acctClss");
		this.hashFields.put("rlane_adj_qty", "rlaneAdjQty");
		this.hashFields.put("cust_adj_qty_upd_flg", "custAdjQtyUpdFlg");
		this.hashFields.put("cust_grp_nm", "custGrpNm");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("smpl_rlane_qty", "smplRlaneQty");
		this.hashFields.put("ofc_ho", "ofcHo");
		this.hashFields.put("load_ttl_qta", "loadTtlQta");
		this.hashFields.put("dtl_seq", "dtlSeq");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("real_ibflag", "realIbflag");
		this.hashFields.put("g2_cng_usr", "g2CngUsr");
		this.hashFields.put("rev_lane_cust_cnt", "revLaneCustCnt");
		this.hashFields.put("wk_mqc_qty", "wkMqcQty");
		this.hashFields.put("strd_adj_ttl_qty", "strdAdjTtlQty");
		this.hashFields.put("strd_flag", "strdFlag");
		this.hashFields.put("strd_pfmc_ratio", "strdPfmcRatio");
		this.hashFields.put("smpl_strd_qty", "smplStrdQty");
		this.hashFields.put("sls_rhq_cd", "slsRhqCd");
		this.hashFields.put("rlane_cmpb", "rlaneCmpb");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("cust_qty", "custQty");
		this.hashFields.put("cng_ofc_list", "cngOfcList");
		this.hashFields.put("season", "season");
		this.hashFields.put("strd_adj_qty", "strdAdjQty");
		this.hashFields.put("rlane_pfmc_ratio", "rlanePfmcRatio");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("cost_yrwk", "costYrwk");
		this.hashFields.put("org_rlane_cd", "orgRlaneCd");
		this.hashFields.put("smpl_cust_qty", "smplCustQty");
		this.hashFields.put("r_rmk", "rRmk");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("g1_cng_usr", "g1CngUsr");
		this.hashFields.put("strd_ttl_qty", "strdTtlQty");
		this.hashFields.put("cust_adj_qty", "custAdjQty");
		this.hashFields.put("spc_ctrl_mdl_mnl_cd", "spcCtrlMdlMnlCd");
		this.hashFields.put("version", "version");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("sc_rfa_flg", "scRfaFlg");
		this.hashFields.put("strd_cmpb", "strdCmpb");
		this.hashFields.put("strd_qty", "strdQty");
		this.hashFields.put("rhq_ho", "rhqHo");
		this.hashFields.put("load_qta", "loadQta");
		this.hashFields.put("spc_ctrl_mdl_rmk", "spcCtrlMdlRmk");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("view_type", "viewType");
		this.hashFields.put("g3_cng_usr", "g3CngUsr");
		this.hashFields.put("rlane_adj_ttl_qty", "rlaneAdjTtlQty");
		this.hashFields.put("ver_seq", "verSeq");
		this.hashFields.put("unit", "unit");
		this.hashFields.put("cust_adj_ttl_qty", "custAdjTtlQty");
		this.hashFields.put("t", "t");
		this.hashFields.put("ho_flg", "hoFlg");
		this.hashFields.put("lane_ho", "laneHo");
		this.hashFields.put("sls_rgn_ofc_cd", "slsRgnOfcCd");
		this.hashFields.put("rlane_qty", "rlaneQty");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return custTtlQty
	 */
	public String getCustTtlQty() {
		return this.custTtlQty;
	}
	
	/**
	 * Column Info
	 * @return spcCtrlMdlMnlRmk
	 */
	public String getSpcCtrlMdlMnlRmk() {
		return this.spcCtrlMdlMnlRmk;
	}
	
	/**
	 * Column Info
	 * @return strdFlag2
	 */
	public String getStrdFlag2() {
		return this.strdFlag2;
	}
	
	/**
	 * Column Info
	 * @return oAdd
	 */
	public String getOAdd() {
		return this.oAdd;
	}
	
	/**
	 * Column Info
	 * @return acctClssCd
	 */
	public String getAcctClssCd() {
		return this.acctClssCd;
	}
	
	/**
	 * Column Info
	 * @return raplyCfmFlg
	 */
	public String getRaplyCfmFlg() {
		return this.raplyCfmFlg;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return custCtrlCd
	 */
	public String getCustCtrlCd() {
		return this.custCtrlCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneTtlQty
	 */
	public String getRlaneTtlQty() {
		return this.rlaneTtlQty;
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
	 * @return acctClss
	 */
	public String getAcctClss() {
		return this.acctClss;
	}
	
	/**
	 * Column Info
	 * @return rlaneAdjQty
	 */
	public String getRlaneAdjQty() {
		return this.rlaneAdjQty;
	}
	
	/**
	 * Column Info
	 * @return custAdjQtyUpdFlg
	 */
	public String getCustAdjQtyUpdFlg() {
		return this.custAdjQtyUpdFlg;
	}
	
	/**
	 * Column Info
	 * @return custGrpNm
	 */
	public String getCustGrpNm() {
		return this.custGrpNm;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return ctrtOfcCd
	 */
	public String getCtrtOfcCd() {
		return this.ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @return smplRlaneQty
	 */
	public String getSmplRlaneQty() {
		return this.smplRlaneQty;
	}
	
	/**
	 * Column Info
	 * @return ofcHo
	 */
	public String getOfcHo() {
		return this.ofcHo;
	}
	
	/**
	 * Column Info
	 * @return loadTtlQta
	 */
	public String getLoadTtlQta() {
		return this.loadTtlQta;
	}
	
	/**
	 * Column Info
	 * @return dtlSeq
	 */
	public String getDtlSeq() {
		return this.dtlSeq;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return realIbflag
	 */
	public String getRealIbflag() {
		return this.realIbflag;
	}
	
	/**
	 * Column Info
	 * @return g2CngUsr
	 */
	public String getG2CngUsr() {
		return this.g2CngUsr;
	}
	
	/**
	 * Column Info
	 * @return revLaneCustCnt
	 */
	public String getRevLaneCustCnt() {
		return this.revLaneCustCnt;
	}
	
	/**
	 * Column Info
	 * @return wkMqcQty
	 */
	public String getWkMqcQty() {
		return this.wkMqcQty;
	}
	
	/**
	 * Column Info
	 * @return strdAdjTtlQty
	 */
	public String getStrdAdjTtlQty() {
		return this.strdAdjTtlQty;
	}
	
	/**
	 * Column Info
	 * @return strdFlag
	 */
	public String getStrdFlag() {
		return this.strdFlag;
	}
	
	/**
	 * Column Info
	 * @return strdPfmcRatio
	 */
	public String getStrdPfmcRatio() {
		return this.strdPfmcRatio;
	}
	
	/**
	 * Column Info
	 * @return smplStrdQty
	 */
	public String getSmplStrdQty() {
		return this.smplStrdQty;
	}
	
	/**
	 * Column Info
	 * @return slsRhqCd
	 */
	public String getSlsRhqCd() {
		return this.slsRhqCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCmpb
	 */
	public String getRlaneCmpb() {
		return this.rlaneCmpb;
	}
	
	/**
	 * Column Info
	 * @return custLglEngNm
	 */
	public String getCustLglEngNm() {
		return this.custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return custQty
	 */
	public String getCustQty() {
		return this.custQty;
	}
	
	/**
	 * Column Info
	 * @return cngOfcList
	 */
	public String getCngOfcList() {
		return this.cngOfcList;
	}
	
	/**
	 * Column Info
	 * @return season
	 */
	public String getSeason() {
		return this.season;
	}
	
	/**
	 * Column Info
	 * @return strdAdjQty
	 */
	public String getStrdAdjQty() {
		return this.strdAdjQty;
	}
	
	/**
	 * Column Info
	 * @return rlanePfmcRatio
	 */
	public String getRlanePfmcRatio() {
		return this.rlanePfmcRatio;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	
	/**
	 * Column Info
	 * @return costYrwk
	 */
	public String getCostYrwk() {
		return this.costYrwk;
	}
	
	/**
	 * Column Info
	 * @return orgRlaneCd
	 */
	public String getOrgRlaneCd() {
		return this.orgRlaneCd;
	}
	
	/**
	 * Column Info
	 * @return smplCustQty
	 */
	public String getSmplCustQty() {
		return this.smplCustQty;
	}
	
	/**
	 * Column Info
	 * @return rRmk
	 */
	public String getRRmk() {
		return this.rRmk;
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
	 * @return g1CngUsr
	 */
	public String getG1CngUsr() {
		return this.g1CngUsr;
	}
	
	/**
	 * Column Info
	 * @return strdTtlQty
	 */
	public String getStrdTtlQty() {
		return this.strdTtlQty;
	}
	
	/**
	 * Column Info
	 * @return custAdjQty
	 */
	public String getCustAdjQty() {
		return this.custAdjQty;
	}
	
	/**
	 * Column Info
	 * @return spcCtrlMdlMnlCd
	 */
	public String getSpcCtrlMdlMnlCd() {
		return this.spcCtrlMdlMnlCd;
	}
	
	/**
	 * Column Info
	 * @return version
	 */
	public String getVersion() {
		return this.version;
	}
	
	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
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
	 * @return scRfaFlg
	 */
	public String getScRfaFlg() {
		return this.scRfaFlg;
	}
	
	/**
	 * Column Info
	 * @return strdCmpb
	 */
	public String getStrdCmpb() {
		return this.strdCmpb;
	}
	
	/**
	 * Column Info
	 * @return strdQty
	 */
	public String getStrdQty() {
		return this.strdQty;
	}
	
	/**
	 * Column Info
	 * @return rhqHo
	 */
	public String getRhqHo() {
		return this.rhqHo;
	}
	
	/**
	 * Column Info
	 * @return loadQta
	 */
	public String getLoadQta() {
		return this.loadQta;
	}
	
	/**
	 * Column Info
	 * @return spcCtrlMdlRmk
	 */
	public String getSpcCtrlMdlRmk() {
		return this.spcCtrlMdlRmk;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return viewType
	 */
	public String getViewType() {
		return this.viewType;
	}
	
	/**
	 * Column Info
	 * @return g3CngUsr
	 */
	public String getG3CngUsr() {
		return this.g3CngUsr;
	}
	
	/**
	 * Column Info
	 * @return rlaneAdjTtlQty
	 */
	public String getRlaneAdjTtlQty() {
		return this.rlaneAdjTtlQty;
	}
	
	/**
	 * Column Info
	 * @return verSeq
	 */
	public String getVerSeq() {
		return this.verSeq;
	}
	
	/**
	 * Column Info
	 * @return unit
	 */
	public String getUnit() {
		return this.unit;
	}
	
	/**
	 * Column Info
	 * @return custAdjTtlQty
	 */
	public String getCustAdjTtlQty() {
		return this.custAdjTtlQty;
	}
	
	/**
	 * Column Info
	 * @return t
	 */
	public String getT() {
		return this.t;
	}
	
	/**
	 * Column Info
	 * @return hoFlg
	 */
	public String getHoFlg() {
		return this.hoFlg;
	}
	
	/**
	 * Column Info
	 * @return laneHo
	 */
	public String getLaneHo() {
		return this.laneHo;
	}
	
	/**
	 * Column Info
	 * @return slsRgnOfcCd
	 */
	public String getSlsRgnOfcCd() {
		return this.slsRgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneQty
	 */
	public String getRlaneQty() {
		return this.rlaneQty;
	}
	

	/**
	 * Column Info
	 * @param custTtlQty
	 */
	public void setCustTtlQty(String custTtlQty) {
		this.custTtlQty = custTtlQty;
	}
	
	/**
	 * Column Info
	 * @param spcCtrlMdlMnlRmk
	 */
	public void setSpcCtrlMdlMnlRmk(String spcCtrlMdlMnlRmk) {
		this.spcCtrlMdlMnlRmk = spcCtrlMdlMnlRmk;
	}
	
	/**
	 * Column Info
	 * @param strdFlag2
	 */
	public void setStrdFlag2(String strdFlag2) {
		this.strdFlag2 = strdFlag2;
	}
	
	/**
	 * Column Info
	 * @param oAdd
	 */
	public void setOAdd(String oAdd) {
		this.oAdd = oAdd;
	}
	
	/**
	 * Column Info
	 * @param acctClssCd
	 */
	public void setAcctClssCd(String acctClssCd) {
		this.acctClssCd = acctClssCd;
	}
	
	/**
	 * Column Info
	 * @param raplyCfmFlg
	 */
	public void setRaplyCfmFlg(String raplyCfmFlg) {
		this.raplyCfmFlg = raplyCfmFlg;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param custCtrlCd
	 */
	public void setCustCtrlCd(String custCtrlCd) {
		this.custCtrlCd = custCtrlCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneTtlQty
	 */
	public void setRlaneTtlQty(String rlaneTtlQty) {
		this.rlaneTtlQty = rlaneTtlQty;
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
	 * @param acctClss
	 */
	public void setAcctClss(String acctClss) {
		this.acctClss = acctClss;
	}
	
	/**
	 * Column Info
	 * @param rlaneAdjQty
	 */
	public void setRlaneAdjQty(String rlaneAdjQty) {
		this.rlaneAdjQty = rlaneAdjQty;
	}
	
	/**
	 * Column Info
	 * @param custAdjQtyUpdFlg
	 */
	public void setCustAdjQtyUpdFlg(String custAdjQtyUpdFlg) {
		this.custAdjQtyUpdFlg = custAdjQtyUpdFlg;
	}
	
	/**
	 * Column Info
	 * @param custGrpNm
	 */
	public void setCustGrpNm(String custGrpNm) {
		this.custGrpNm = custGrpNm;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param ctrtOfcCd
	 */
	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @param smplRlaneQty
	 */
	public void setSmplRlaneQty(String smplRlaneQty) {
		this.smplRlaneQty = smplRlaneQty;
	}
	
	/**
	 * Column Info
	 * @param ofcHo
	 */
	public void setOfcHo(String ofcHo) {
		this.ofcHo = ofcHo;
	}
	
	/**
	 * Column Info
	 * @param loadTtlQta
	 */
	public void setLoadTtlQta(String loadTtlQta) {
		this.loadTtlQta = loadTtlQta;
	}
	
	/**
	 * Column Info
	 * @param dtlSeq
	 */
	public void setDtlSeq(String dtlSeq) {
		this.dtlSeq = dtlSeq;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param realIbflag
	 */
	public void setRealIbflag(String realIbflag) {
		this.realIbflag = realIbflag;
	}
	
	/**
	 * Column Info
	 * @param g2CngUsr
	 */
	public void setG2CngUsr(String g2CngUsr) {
		this.g2CngUsr = g2CngUsr;
	}
	
	/**
	 * Column Info
	 * @param revLaneCustCnt
	 */
	public void setRevLaneCustCnt(String revLaneCustCnt) {
		this.revLaneCustCnt = revLaneCustCnt;
	}
	
	/**
	 * Column Info
	 * @param wkMqcQty
	 */
	public void setWkMqcQty(String wkMqcQty) {
		this.wkMqcQty = wkMqcQty;
	}
	
	/**
	 * Column Info
	 * @param strdAdjTtlQty
	 */
	public void setStrdAdjTtlQty(String strdAdjTtlQty) {
		this.strdAdjTtlQty = strdAdjTtlQty;
	}
	
	/**
	 * Column Info
	 * @param strdFlag
	 */
	public void setStrdFlag(String strdFlag) {
		this.strdFlag = strdFlag;
	}
	
	/**
	 * Column Info
	 * @param strdPfmcRatio
	 */
	public void setStrdPfmcRatio(String strdPfmcRatio) {
		this.strdPfmcRatio = strdPfmcRatio;
	}
	
	/**
	 * Column Info
	 * @param smplStrdQty
	 */
	public void setSmplStrdQty(String smplStrdQty) {
		this.smplStrdQty = smplStrdQty;
	}
	
	/**
	 * Column Info
	 * @param slsRhqCd
	 */
	public void setSlsRhqCd(String slsRhqCd) {
		this.slsRhqCd = slsRhqCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCmpb
	 */
	public void setRlaneCmpb(String rlaneCmpb) {
		this.rlaneCmpb = rlaneCmpb;
	}
	
	/**
	 * Column Info
	 * @param custLglEngNm
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param custQty
	 */
	public void setCustQty(String custQty) {
		this.custQty = custQty;
	}
	
	/**
	 * Column Info
	 * @param cngOfcList
	 */
	public void setCngOfcList(String cngOfcList) {
		this.cngOfcList = cngOfcList;
	}
	
	/**
	 * Column Info
	 * @param season
	 */
	public void setSeason(String season) {
		this.season = season;
	}
	
	/**
	 * Column Info
	 * @param strdAdjQty
	 */
	public void setStrdAdjQty(String strdAdjQty) {
		this.strdAdjQty = strdAdjQty;
	}
	
	/**
	 * Column Info
	 * @param rlanePfmcRatio
	 */
	public void setRlanePfmcRatio(String rlanePfmcRatio) {
		this.rlanePfmcRatio = rlanePfmcRatio;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Column Info
	 * @param costYrwk
	 */
	public void setCostYrwk(String costYrwk) {
		this.costYrwk = costYrwk;
	}
	
	/**
	 * Column Info
	 * @param orgRlaneCd
	 */
	public void setOrgRlaneCd(String orgRlaneCd) {
		this.orgRlaneCd = orgRlaneCd;
	}
	
	/**
	 * Column Info
	 * @param smplCustQty
	 */
	public void setSmplCustQty(String smplCustQty) {
		this.smplCustQty = smplCustQty;
	}
	
	/**
	 * Column Info
	 * @param rRmk
	 */
	public void setRRmk(String rRmk) {
		this.rRmk = rRmk;
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
	 * @param g1CngUsr
	 */
	public void setG1CngUsr(String g1CngUsr) {
		this.g1CngUsr = g1CngUsr;
	}
	
	/**
	 * Column Info
	 * @param strdTtlQty
	 */
	public void setStrdTtlQty(String strdTtlQty) {
		this.strdTtlQty = strdTtlQty;
	}
	
	/**
	 * Column Info
	 * @param custAdjQty
	 */
	public void setCustAdjQty(String custAdjQty) {
		this.custAdjQty = custAdjQty;
	}
	
	/**
	 * Column Info
	 * @param spcCtrlMdlMnlCd
	 */
	public void setSpcCtrlMdlMnlCd(String spcCtrlMdlMnlCd) {
		this.spcCtrlMdlMnlCd = spcCtrlMdlMnlCd;
	}
	
	/**
	 * Column Info
	 * @param version
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	
	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
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
	 * @param scRfaFlg
	 */
	public void setScRfaFlg(String scRfaFlg) {
		this.scRfaFlg = scRfaFlg;
	}
	
	/**
	 * Column Info
	 * @param strdCmpb
	 */
	public void setStrdCmpb(String strdCmpb) {
		this.strdCmpb = strdCmpb;
	}
	
	/**
	 * Column Info
	 * @param strdQty
	 */
	public void setStrdQty(String strdQty) {
		this.strdQty = strdQty;
	}
	
	/**
	 * Column Info
	 * @param rhqHo
	 */
	public void setRhqHo(String rhqHo) {
		this.rhqHo = rhqHo;
	}
	
	/**
	 * Column Info
	 * @param loadQta
	 */
	public void setLoadQta(String loadQta) {
		this.loadQta = loadQta;
	}
	
	/**
	 * Column Info
	 * @param spcCtrlMdlRmk
	 */
	public void setSpcCtrlMdlRmk(String spcCtrlMdlRmk) {
		this.spcCtrlMdlRmk = spcCtrlMdlRmk;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param viewType
	 */
	public void setViewType(String viewType) {
		this.viewType = viewType;
	}
	
	/**
	 * Column Info
	 * @param g3CngUsr
	 */
	public void setG3CngUsr(String g3CngUsr) {
		this.g3CngUsr = g3CngUsr;
	}
	
	/**
	 * Column Info
	 * @param rlaneAdjTtlQty
	 */
	public void setRlaneAdjTtlQty(String rlaneAdjTtlQty) {
		this.rlaneAdjTtlQty = rlaneAdjTtlQty;
	}
	
	/**
	 * Column Info
	 * @param verSeq
	 */
	public void setVerSeq(String verSeq) {
		this.verSeq = verSeq;
	}
	
	/**
	 * Column Info
	 * @param unit
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	/**
	 * Column Info
	 * @param custAdjTtlQty
	 */
	public void setCustAdjTtlQty(String custAdjTtlQty) {
		this.custAdjTtlQty = custAdjTtlQty;
	}
	
	/**
	 * Column Info
	 * @param t
	 */
	public void setT(String t) {
		this.t = t;
	}
	
	/**
	 * Column Info
	 * @param hoFlg
	 */
	public void setHoFlg(String hoFlg) {
		this.hoFlg = hoFlg;
	}
	
	/**
	 * Column Info
	 * @param laneHo
	 */
	public void setLaneHo(String laneHo) {
		this.laneHo = laneHo;
	}
	
	/**
	 * Column Info
	 * @param slsRgnOfcCd
	 */
	public void setSlsRgnOfcCd(String slsRgnOfcCd) {
		this.slsRgnOfcCd = slsRgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneQty
	 */
	public void setRlaneQty(String rlaneQty) {
		this.rlaneQty = rlaneQty;
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
		setCustTtlQty(JSPUtil.getParameter(request, prefix + "cust_ttl_qty", ""));
		setSpcCtrlMdlMnlRmk(JSPUtil.getParameter(request, prefix + "spc_ctrl_mdl_mnl_rmk", ""));
		setStrdFlag2(JSPUtil.getParameter(request, prefix + "strd_flag2", ""));
		setOAdd(JSPUtil.getParameter(request, prefix + "o_add", ""));
		setAcctClssCd(JSPUtil.getParameter(request, prefix + "acct_clss_cd", ""));
		setRaplyCfmFlg(JSPUtil.getParameter(request, prefix + "raply_cfm_flg", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setCustCtrlCd(JSPUtil.getParameter(request, prefix + "cust_ctrl_cd", ""));
		setRlaneTtlQty(JSPUtil.getParameter(request, prefix + "rlane_ttl_qty", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAcctClss(JSPUtil.getParameter(request, prefix + "acct_clss", ""));
		setRlaneAdjQty(JSPUtil.getParameter(request, prefix + "rlane_adj_qty", ""));
		setCustAdjQtyUpdFlg(JSPUtil.getParameter(request, prefix + "cust_adj_qty_upd_flg", ""));
		setCustGrpNm(JSPUtil.getParameter(request, prefix + "cust_grp_nm", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setSmplRlaneQty(JSPUtil.getParameter(request, prefix + "smpl_rlane_qty", ""));
		setOfcHo(JSPUtil.getParameter(request, prefix + "ofc_ho", ""));
		setLoadTtlQta(JSPUtil.getParameter(request, prefix + "load_ttl_qta", ""));
		setDtlSeq(JSPUtil.getParameter(request, prefix + "dtl_seq", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setRealIbflag(JSPUtil.getParameter(request, prefix + "real_ibflag", ""));
		setG2CngUsr(JSPUtil.getParameter(request, prefix + "g2_cng_usr", ""));
		setRevLaneCustCnt(JSPUtil.getParameter(request, prefix + "rev_lane_cust_cnt", ""));
		setWkMqcQty(JSPUtil.getParameter(request, prefix + "wk_mqc_qty", ""));
		setStrdAdjTtlQty(JSPUtil.getParameter(request, prefix + "strd_adj_ttl_qty", ""));
		setStrdFlag(JSPUtil.getParameter(request, prefix + "strd_flag", ""));
		setStrdPfmcRatio(JSPUtil.getParameter(request, prefix + "strd_pfmc_ratio", ""));
		setSmplStrdQty(JSPUtil.getParameter(request, prefix + "smpl_strd_qty", ""));
		setSlsRhqCd(JSPUtil.getParameter(request, prefix + "sls_rhq_cd", ""));
		setRlaneCmpb(JSPUtil.getParameter(request, prefix + "rlane_cmpb", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setCustQty(JSPUtil.getParameter(request, prefix + "cust_qty", ""));
		setCngOfcList(JSPUtil.getParameter(request, prefix + "cng_ofc_list", ""));
		setSeason(JSPUtil.getParameter(request, prefix + "season", ""));
		setStrdAdjQty(JSPUtil.getParameter(request, prefix + "strd_adj_qty", ""));
		setRlanePfmcRatio(JSPUtil.getParameter(request, prefix + "rlane_pfmc_ratio", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setCostYrwk(JSPUtil.getParameter(request, prefix + "cost_yrwk", ""));
		setOrgRlaneCd(JSPUtil.getParameter(request, prefix + "org_rlane_cd", ""));
		setSmplCustQty(JSPUtil.getParameter(request, prefix + "smpl_cust_qty", ""));
		setRRmk(JSPUtil.getParameter(request, prefix + "r_rmk", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setG1CngUsr(JSPUtil.getParameter(request, prefix + "g1_cng_usr", ""));
		setStrdTtlQty(JSPUtil.getParameter(request, prefix + "strd_ttl_qty", ""));
		setCustAdjQty(JSPUtil.getParameter(request, prefix + "cust_adj_qty", ""));
		setSpcCtrlMdlMnlCd(JSPUtil.getParameter(request, prefix + "spc_ctrl_mdl_mnl_cd", ""));
		setVersion(JSPUtil.getParameter(request, prefix + "version", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setScRfaFlg(JSPUtil.getParameter(request, prefix + "sc_rfa_flg", ""));
		setStrdCmpb(JSPUtil.getParameter(request, prefix + "strd_cmpb", ""));
		setStrdQty(JSPUtil.getParameter(request, prefix + "strd_qty", ""));
		setRhqHo(JSPUtil.getParameter(request, prefix + "rhq_ho", ""));
		setLoadQta(JSPUtil.getParameter(request, prefix + "load_qta", ""));
		setSpcCtrlMdlRmk(JSPUtil.getParameter(request, prefix + "spc_ctrl_mdl_rmk", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setViewType(JSPUtil.getParameter(request, prefix + "view_type", ""));
		setG3CngUsr(JSPUtil.getParameter(request, prefix + "g3_cng_usr", ""));
		setRlaneAdjTtlQty(JSPUtil.getParameter(request, prefix + "rlane_adj_ttl_qty", ""));
		setVerSeq(JSPUtil.getParameter(request, prefix + "ver_seq", ""));
		setUnit(JSPUtil.getParameter(request, prefix + "unit", ""));
		setCustAdjTtlQty(JSPUtil.getParameter(request, prefix + "cust_adj_ttl_qty", ""));
		setT(JSPUtil.getParameter(request, prefix + "t", ""));
		setHoFlg(JSPUtil.getParameter(request, prefix + "ho_flg", ""));
		setLaneHo(JSPUtil.getParameter(request, prefix + "lane_ho", ""));
		setSlsRgnOfcCd(JSPUtil.getParameter(request, prefix + "sls_rgn_ofc_cd", ""));
		setRlaneQty(JSPUtil.getParameter(request, prefix + "rlane_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchModelManageListVO[]
	 */
	public SearchModelManageListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchModelManageListVO[]
	 */
	public SearchModelManageListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchModelManageListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] custTtlQty = (JSPUtil.getParameter(request, prefix	+ "cust_ttl_qty", length));
			String[] spcCtrlMdlMnlRmk = (JSPUtil.getParameter(request, prefix	+ "spc_ctrl_mdl_mnl_rmk", length));
			String[] strdFlag2 = (JSPUtil.getParameter(request, prefix	+ "strd_flag2", length));
			String[] oAdd = (JSPUtil.getParameter(request, prefix	+ "o_add", length));
			String[] acctClssCd = (JSPUtil.getParameter(request, prefix	+ "acct_clss_cd", length));
			String[] raplyCfmFlg = (JSPUtil.getParameter(request, prefix	+ "raply_cfm_flg", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] custCtrlCd = (JSPUtil.getParameter(request, prefix	+ "cust_ctrl_cd", length));
			String[] rlaneTtlQty = (JSPUtil.getParameter(request, prefix	+ "rlane_ttl_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] acctClss = (JSPUtil.getParameter(request, prefix	+ "acct_clss", length));
			String[] rlaneAdjQty = (JSPUtil.getParameter(request, prefix	+ "rlane_adj_qty", length));
			String[] custAdjQtyUpdFlg = (JSPUtil.getParameter(request, prefix	+ "cust_adj_qty_upd_flg", length));
			String[] custGrpNm = (JSPUtil.getParameter(request, prefix	+ "cust_grp_nm", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] smplRlaneQty = (JSPUtil.getParameter(request, prefix	+ "smpl_rlane_qty", length));
			String[] ofcHo = (JSPUtil.getParameter(request, prefix	+ "ofc_ho", length));
			String[] loadTtlQta = (JSPUtil.getParameter(request, prefix	+ "load_ttl_qta", length));
			String[] dtlSeq = (JSPUtil.getParameter(request, prefix	+ "dtl_seq", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] realIbflag = (JSPUtil.getParameter(request, prefix	+ "real_ibflag", length));
			String[] g2CngUsr = (JSPUtil.getParameter(request, prefix	+ "g2_cng_usr", length));
			String[] revLaneCustCnt = (JSPUtil.getParameter(request, prefix	+ "rev_lane_cust_cnt", length));
			String[] wkMqcQty = (JSPUtil.getParameter(request, prefix	+ "wk_mqc_qty", length));
			String[] strdAdjTtlQty = (JSPUtil.getParameter(request, prefix	+ "strd_adj_ttl_qty", length));
			String[] strdFlag = (JSPUtil.getParameter(request, prefix	+ "strd_flag", length));
			String[] strdPfmcRatio = (JSPUtil.getParameter(request, prefix	+ "strd_pfmc_ratio", length));
			String[] smplStrdQty = (JSPUtil.getParameter(request, prefix	+ "smpl_strd_qty", length));
			String[] slsRhqCd = (JSPUtil.getParameter(request, prefix	+ "sls_rhq_cd", length));
			String[] rlaneCmpb = (JSPUtil.getParameter(request, prefix	+ "rlane_cmpb", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] custQty = (JSPUtil.getParameter(request, prefix	+ "cust_qty", length));
			String[] cngOfcList = (JSPUtil.getParameter(request, prefix	+ "cng_ofc_list", length));
			String[] season = (JSPUtil.getParameter(request, prefix	+ "season", length));
			String[] strdAdjQty = (JSPUtil.getParameter(request, prefix	+ "strd_adj_qty", length));
			String[] rlanePfmcRatio = (JSPUtil.getParameter(request, prefix	+ "rlane_pfmc_ratio", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] costYrwk = (JSPUtil.getParameter(request, prefix	+ "cost_yrwk", length));
			String[] orgRlaneCd = (JSPUtil.getParameter(request, prefix	+ "org_rlane_cd", length));
			String[] smplCustQty = (JSPUtil.getParameter(request, prefix	+ "smpl_cust_qty", length));
			String[] rRmk = (JSPUtil.getParameter(request, prefix	+ "r_rmk", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] g1CngUsr = (JSPUtil.getParameter(request, prefix	+ "g1_cng_usr", length));
			String[] strdTtlQty = (JSPUtil.getParameter(request, prefix	+ "strd_ttl_qty", length));
			String[] custAdjQty = (JSPUtil.getParameter(request, prefix	+ "cust_adj_qty", length));
			String[] spcCtrlMdlMnlCd = (JSPUtil.getParameter(request, prefix	+ "spc_ctrl_mdl_mnl_cd", length));
			String[] version = (JSPUtil.getParameter(request, prefix	+ "version", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] scRfaFlg = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_flg", length));
			String[] strdCmpb = (JSPUtil.getParameter(request, prefix	+ "strd_cmpb", length));
			String[] strdQty = (JSPUtil.getParameter(request, prefix	+ "strd_qty", length));
			String[] rhqHo = (JSPUtil.getParameter(request, prefix	+ "rhq_ho", length));
			String[] loadQta = (JSPUtil.getParameter(request, prefix	+ "load_qta", length));
			String[] spcCtrlMdlRmk = (JSPUtil.getParameter(request, prefix	+ "spc_ctrl_mdl_rmk", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] viewType = (JSPUtil.getParameter(request, prefix	+ "view_type", length));
			String[] g3CngUsr = (JSPUtil.getParameter(request, prefix	+ "g3_cng_usr", length));
			String[] rlaneAdjTtlQty = (JSPUtil.getParameter(request, prefix	+ "rlane_adj_ttl_qty", length));
			String[] verSeq = (JSPUtil.getParameter(request, prefix	+ "ver_seq", length));
			String[] unit = (JSPUtil.getParameter(request, prefix	+ "unit", length));
			String[] custAdjTtlQty = (JSPUtil.getParameter(request, prefix	+ "cust_adj_ttl_qty", length));
			String[] t = (JSPUtil.getParameter(request, prefix	+ "t", length));
			String[] hoFlg = (JSPUtil.getParameter(request, prefix	+ "ho_flg", length));
			String[] laneHo = (JSPUtil.getParameter(request, prefix	+ "lane_ho", length));
			String[] slsRgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_rgn_ofc_cd", length));
			String[] rlaneQty = (JSPUtil.getParameter(request, prefix	+ "rlane_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchModelManageListVO();
				if (custTtlQty[i] != null)
					model.setCustTtlQty(custTtlQty[i]);
				if (spcCtrlMdlMnlRmk[i] != null)
					model.setSpcCtrlMdlMnlRmk(spcCtrlMdlMnlRmk[i]);
				if (strdFlag2[i] != null)
					model.setStrdFlag2(strdFlag2[i]);
				if (oAdd[i] != null)
					model.setOAdd(oAdd[i]);
				if (acctClssCd[i] != null)
					model.setAcctClssCd(acctClssCd[i]);
				if (raplyCfmFlg[i] != null)
					model.setRaplyCfmFlg(raplyCfmFlg[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (custCtrlCd[i] != null)
					model.setCustCtrlCd(custCtrlCd[i]);
				if (rlaneTtlQty[i] != null)
					model.setRlaneTtlQty(rlaneTtlQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (acctClss[i] != null)
					model.setAcctClss(acctClss[i]);
				if (rlaneAdjQty[i] != null)
					model.setRlaneAdjQty(rlaneAdjQty[i]);
				if (custAdjQtyUpdFlg[i] != null)
					model.setCustAdjQtyUpdFlg(custAdjQtyUpdFlg[i]);
				if (custGrpNm[i] != null)
					model.setCustGrpNm(custGrpNm[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (smplRlaneQty[i] != null)
					model.setSmplRlaneQty(smplRlaneQty[i]);
				if (ofcHo[i] != null)
					model.setOfcHo(ofcHo[i]);
				if (loadTtlQta[i] != null)
					model.setLoadTtlQta(loadTtlQta[i]);
				if (dtlSeq[i] != null)
					model.setDtlSeq(dtlSeq[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (realIbflag[i] != null)
					model.setRealIbflag(realIbflag[i]);
				if (g2CngUsr[i] != null)
					model.setG2CngUsr(g2CngUsr[i]);
				if (revLaneCustCnt[i] != null)
					model.setRevLaneCustCnt(revLaneCustCnt[i]);
				if (wkMqcQty[i] != null)
					model.setWkMqcQty(wkMqcQty[i]);
				if (strdAdjTtlQty[i] != null)
					model.setStrdAdjTtlQty(strdAdjTtlQty[i]);
				if (strdFlag[i] != null)
					model.setStrdFlag(strdFlag[i]);
				if (strdPfmcRatio[i] != null)
					model.setStrdPfmcRatio(strdPfmcRatio[i]);
				if (smplStrdQty[i] != null)
					model.setSmplStrdQty(smplStrdQty[i]);
				if (slsRhqCd[i] != null)
					model.setSlsRhqCd(slsRhqCd[i]);
				if (rlaneCmpb[i] != null)
					model.setRlaneCmpb(rlaneCmpb[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (custQty[i] != null)
					model.setCustQty(custQty[i]);
				if (cngOfcList[i] != null)
					model.setCngOfcList(cngOfcList[i]);
				if (season[i] != null)
					model.setSeason(season[i]);
				if (strdAdjQty[i] != null)
					model.setStrdAdjQty(strdAdjQty[i]);
				if (rlanePfmcRatio[i] != null)
					model.setRlanePfmcRatio(rlanePfmcRatio[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (costYrwk[i] != null)
					model.setCostYrwk(costYrwk[i]);
				if (orgRlaneCd[i] != null)
					model.setOrgRlaneCd(orgRlaneCd[i]);
				if (smplCustQty[i] != null)
					model.setSmplCustQty(smplCustQty[i]);
				if (rRmk[i] != null)
					model.setRRmk(rRmk[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (g1CngUsr[i] != null)
					model.setG1CngUsr(g1CngUsr[i]);
				if (strdTtlQty[i] != null)
					model.setStrdTtlQty(strdTtlQty[i]);
				if (custAdjQty[i] != null)
					model.setCustAdjQty(custAdjQty[i]);
				if (spcCtrlMdlMnlCd[i] != null)
					model.setSpcCtrlMdlMnlCd(spcCtrlMdlMnlCd[i]);
				if (version[i] != null)
					model.setVersion(version[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (scRfaFlg[i] != null)
					model.setScRfaFlg(scRfaFlg[i]);
				if (strdCmpb[i] != null)
					model.setStrdCmpb(strdCmpb[i]);
				if (strdQty[i] != null)
					model.setStrdQty(strdQty[i]);
				if (rhqHo[i] != null)
					model.setRhqHo(rhqHo[i]);
				if (loadQta[i] != null)
					model.setLoadQta(loadQta[i]);
				if (spcCtrlMdlRmk[i] != null)
					model.setSpcCtrlMdlRmk(spcCtrlMdlRmk[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (viewType[i] != null)
					model.setViewType(viewType[i]);
				if (g3CngUsr[i] != null)
					model.setG3CngUsr(g3CngUsr[i]);
				if (rlaneAdjTtlQty[i] != null)
					model.setRlaneAdjTtlQty(rlaneAdjTtlQty[i]);
				if (verSeq[i] != null)
					model.setVerSeq(verSeq[i]);
				if (unit[i] != null)
					model.setUnit(unit[i]);
				if (custAdjTtlQty[i] != null)
					model.setCustAdjTtlQty(custAdjTtlQty[i]);
				if (t[i] != null)
					model.setT(t[i]);
				if (hoFlg[i] != null)
					model.setHoFlg(hoFlg[i]);
				if (laneHo[i] != null)
					model.setLaneHo(laneHo[i]);
				if (slsRgnOfcCd[i] != null)
					model.setSlsRgnOfcCd(slsRgnOfcCd[i]);
				if (rlaneQty[i] != null)
					model.setRlaneQty(rlaneQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchModelManageListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchModelManageListVO[]
	 */
	public SearchModelManageListVO[] getSearchModelManageListVOs(){
		SearchModelManageListVO[] vos = (SearchModelManageListVO[])models.toArray(new SearchModelManageListVO[models.size()]);
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
		this.custTtlQty = this.custTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spcCtrlMdlMnlRmk = this.spcCtrlMdlMnlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.strdFlag2 = this.strdFlag2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oAdd = this.oAdd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctClssCd = this.acctClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raplyCfmFlg = this.raplyCfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCtrlCd = this.custCtrlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneTtlQty = this.rlaneTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctClss = this.acctClss .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneAdjQty = this.rlaneAdjQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAdjQtyUpdFlg = this.custAdjQtyUpdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custGrpNm = this.custGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smplRlaneQty = this.smplRlaneQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcHo = this.ofcHo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loadTtlQta = this.loadTtlQta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlSeq = this.dtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.realIbflag = this.realIbflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g2CngUsr = this.g2CngUsr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revLaneCustCnt = this.revLaneCustCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wkMqcQty = this.wkMqcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.strdAdjTtlQty = this.strdAdjTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.strdFlag = this.strdFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.strdPfmcRatio = this.strdPfmcRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smplStrdQty = this.smplStrdQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRhqCd = this.slsRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCmpb = this.rlaneCmpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custQty = this.custQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cngOfcList = this.cngOfcList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.season = this.season .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.strdAdjQty = this.strdAdjQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlanePfmcRatio = this.rlanePfmcRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrwk = this.costYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRlaneCd = this.orgRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smplCustQty = this.smplCustQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rRmk = this.rRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g1CngUsr = this.g1CngUsr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.strdTtlQty = this.strdTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAdjQty = this.custAdjQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spcCtrlMdlMnlCd = this.spcCtrlMdlMnlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.version = this.version .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaFlg = this.scRfaFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.strdCmpb = this.strdCmpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.strdQty = this.strdQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqHo = this.rhqHo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loadQta = this.loadQta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spcCtrlMdlRmk = this.spcCtrlMdlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viewType = this.viewType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g3CngUsr = this.g3CngUsr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneAdjTtlQty = this.rlaneAdjTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.verSeq = this.verSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unit = this.unit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAdjTtlQty = this.custAdjTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t = this.t .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hoFlg = this.hoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneHo = this.laneHo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRgnOfcCd = this.slsRgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneQty = this.rlaneQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
