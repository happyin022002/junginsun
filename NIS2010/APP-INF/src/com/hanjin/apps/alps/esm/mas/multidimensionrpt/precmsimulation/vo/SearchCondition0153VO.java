/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SearchCondition0153VO.java
*@FileTitle : SearchCondition0153VO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.22
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.22  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.multidimensionrpt.precmsimulation.vo;

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

public class SearchCondition0153VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCondition0153VO> models = new ArrayList<SearchCondition0153VO>();
	
	/* Column Info */
	private String fRTerm = null;
	/* Column Info */
	private String fUserId = null;
	/* Column Info */
	private String errMsg = null;
	/* Column Info */
	private String fCostYrmon = null;
	/* Column Info */
	private String errorCode = null;
	/* Column Info */
	private String fMtyPkupYdCd = null;
	/* Column Info */
	private String fBkgOfcCd = null;
	/* Column Info */
	private String masRhq = null;
	/* Column Info */
	private String fOutParamNumber = null;
	/* Column Info */
	private String fLane1 = null;
	/* Column Info */
	private String fSpclDg = null;
	/* Column Info */
	private String fAgmtSgnOfcCd = null;
	/* Column Info */
	private String fPcCreation = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fSpclRevmt = null;
	/* Column Info */
	private String fPort2 = null;
	/* Column Info */
	private String fPort1 = null;
	/* Column Info */
	private String fPort3 = null;
	/* Column Info */
	private String cntrMtDys = null;
	/* Column Info */
	private String fNodeCd = null;
	/* Column Info */
	private String masEcc = null;
	/* Column Info */
	private String fOfcCd = null;
	/* Column Info */
	private String fMtyRtnLstCd = null;
	/* Column Info */
	private String fCobProfitLv2 = null;
	/* Column Info */
	private String fCntrTpszCd = null;
	/* Column Info */
	private String fDelNode = null;
	/* Column Info */
	private String fPctlNo = null;
	/* Column Info */
	private String fMtyPkupYdNode = null;
	/* Column Info */
	private String fCmdtCd = null;
	/* Column Info */
	private String fNPod = null;
	/* Column Info */
	private String fCobProfitVw = null;
	/* Column Info */
	private String fMtyRtnYdCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fCltOfcCd = null;
	/* Column Info */
	private String fNPol = null;
	/* Column Info */
	private String fOfcLvl = null;
	/* Column Info */
	private String fOutParamVarchar = null;
	/* Column Info */
	private String fMtyRtnYdNode = null;
	/* Column Info */
	private String fVoidQty = null;
	/* Column Info */
	private String fPorNode = null;
	/* Column Info */
	private String fEndPctlNo = null;
	/* Column Info */
	private String fSpclRf = null;
	/* Column Info */
	private String fSpclBb = null;
	/* Column Info */
	private String fOrgiNode = null;
	/* Column Info */
	private String fDTerm = null;
	/* Column Info */
	private String fQty = null;
	/* Column Info */
	private String fSpclAk = null;
	/* Column Info */
	private String fPolCd = null;
	/* Column Info */
	private String fStartPctlNo = null;
	/* Column Info */
	private String fChssTerm = null;
	/* Column Info */
	private String fDestNode = null;
	/* Column Info */
	private String fPpdOfcCd = null;
	/* Column Info */
	private String fPorCd = null;
	/* Column Info */
	private String fLane4 = null;
	/* Column Info */
	private String fPodCd = null;
	/* Column Info */
	private String fLane3 = null;
	/* Column Info */
	private String fLane2 = null;
	/* Column Info */
	private String fSlsOfcCd = null;
	/* Column Info */
	private String fCobProfitLv = null;
	/* Column Info */
	private String ttlDys = null;
	/* Column Info */
	private String fMtyRtnYdChk = null;
	/* Column Info */
	private String fSpclSoc = null;
	/* Column Info */
	private String fDelCd = null;
	/* Column Info */
	private String fGRev = null;
	/* Column Info */
	private String masRcc = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchCondition0153VO() {}

	public SearchCondition0153VO(String ibflag, String pagerows, String fSpclRf, String fMtyRtnYdChk, String fChssTerm, String fCobProfitLv2, String fCltOfcCd, String fSpclSoc, String fSpclBb, String fCmdtCd, String fPorCd, String fDelNode, String fSpclRevmt, String fNPod, String fOfcLvl, String fEndPctlNo, String fRTerm, String fCobProfitVw, String fSpclAk, String fOrgiNode, String fPcCreation, String fLane4, String fLane2, String fLane3, String fOutParamNumber, String errMsg, String fPctlNo, String fMtyRtnYdNode, String fPort2, String fPort1, String fMtyPkupYdNode, String fPort3, String fVoidQty, String fDelCd, String fOutParamVarchar, String fCntrTpszCd, String fLane1, String fNodeCd, String fDestNode, String fSlsOfcCd, String fNPol, String fUserId, String fSpclDg, String fPpdOfcCd, String fPodCd, String fQty, String fPorNode, String fCostYrmon, String fOfcCd, String fBkgOfcCd, String fCobProfitLv, String fDTerm, String fGRev, String fPolCd, String errorCode, String fStartPctlNo, String fAgmtSgnOfcCd, String fMtyRtnYdCd, String fMtyPkupYdCd, String cntrMtDys, String ttlDys, String masRhq, String masEcc, String fMtyRtnLstCd, String masRcc) {
		this.fRTerm = fRTerm;
		this.fUserId = fUserId;
		this.errMsg = errMsg;
		this.fCostYrmon = fCostYrmon;
		this.errorCode = errorCode;
		this.fMtyPkupYdCd = fMtyPkupYdCd;
		this.fBkgOfcCd = fBkgOfcCd;
		this.masRhq = masRhq;
		this.fOutParamNumber = fOutParamNumber;
		this.fLane1 = fLane1;
		this.fSpclDg = fSpclDg;
		this.fAgmtSgnOfcCd = fAgmtSgnOfcCd;
		this.fPcCreation = fPcCreation;
		this.pagerows = pagerows;
		this.fSpclRevmt = fSpclRevmt;
		this.fPort2 = fPort2;
		this.fPort1 = fPort1;
		this.fPort3 = fPort3;
		this.cntrMtDys = cntrMtDys;
		this.fNodeCd = fNodeCd;
		this.masEcc = masEcc;
		this.fOfcCd = fOfcCd;
		this.fMtyRtnLstCd = fMtyRtnLstCd;
		this.fCobProfitLv2 = fCobProfitLv2;
		this.fCntrTpszCd = fCntrTpszCd;
		this.fDelNode = fDelNode;
		this.fPctlNo = fPctlNo;
		this.fMtyPkupYdNode = fMtyPkupYdNode;
		this.fCmdtCd = fCmdtCd;
		this.fNPod = fNPod;
		this.fCobProfitVw = fCobProfitVw;
		this.fMtyRtnYdCd = fMtyRtnYdCd;
		this.ibflag = ibflag;
		this.fCltOfcCd = fCltOfcCd;
		this.fNPol = fNPol;
		this.fOfcLvl = fOfcLvl;
		this.fOutParamVarchar = fOutParamVarchar;
		this.fMtyRtnYdNode = fMtyRtnYdNode;
		this.fVoidQty = fVoidQty;
		this.fPorNode = fPorNode;
		this.fEndPctlNo = fEndPctlNo;
		this.fSpclRf = fSpclRf;
		this.fSpclBb = fSpclBb;
		this.fOrgiNode = fOrgiNode;
		this.fDTerm = fDTerm;
		this.fQty = fQty;
		this.fSpclAk = fSpclAk;
		this.fPolCd = fPolCd;
		this.fStartPctlNo = fStartPctlNo;
		this.fChssTerm = fChssTerm;
		this.fDestNode = fDestNode;
		this.fPpdOfcCd = fPpdOfcCd;
		this.fPorCd = fPorCd;
		this.fLane4 = fLane4;
		this.fPodCd = fPodCd;
		this.fLane3 = fLane3;
		this.fLane2 = fLane2;
		this.fSlsOfcCd = fSlsOfcCd;
		this.fCobProfitLv = fCobProfitLv;
		this.ttlDys = ttlDys;
		this.fMtyRtnYdChk = fMtyRtnYdChk;
		this.fSpclSoc = fSpclSoc;
		this.fDelCd = fDelCd;
		this.fGRev = fGRev;
		this.masRcc = masRcc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("f_r_term", getFRTerm());
		this.hashColumns.put("f_user_id", getFUserId());
		this.hashColumns.put("err_msg", getErrMsg());
		this.hashColumns.put("f_cost_yrmon", getFCostYrmon());
		this.hashColumns.put("error_code", getErrorCode());
		this.hashColumns.put("f_mty_pkup_yd_cd", getFMtyPkupYdCd());
		this.hashColumns.put("f_bkg_ofc_cd", getFBkgOfcCd());
		this.hashColumns.put("mas_rhq", getMasRhq());
		this.hashColumns.put("f_out_param_number", getFOutParamNumber());
		this.hashColumns.put("f_lane1", getFLane1());
		this.hashColumns.put("f_spcl_dg", getFSpclDg());
		this.hashColumns.put("f_agmt_sgn_ofc_cd", getFAgmtSgnOfcCd());
		this.hashColumns.put("f_pc_creation", getFPcCreation());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("f_spcl_revmt", getFSpclRevmt());
		this.hashColumns.put("f_port2", getFPort2());
		this.hashColumns.put("f_port1", getFPort1());
		this.hashColumns.put("f_port3", getFPort3());
		this.hashColumns.put("cntr_mt_dys", getCntrMtDys());
		this.hashColumns.put("f_node_cd", getFNodeCd());
		this.hashColumns.put("mas_ecc", getMasEcc());
		this.hashColumns.put("f_ofc_cd", getFOfcCd());
		this.hashColumns.put("f_mty_rtn_lst_cd", getFMtyRtnLstCd());
		this.hashColumns.put("f_cob_profit_lv2", getFCobProfitLv2());
		this.hashColumns.put("f_cntr_tpsz_cd", getFCntrTpszCd());
		this.hashColumns.put("f_del_node", getFDelNode());
		this.hashColumns.put("f_pctl_no", getFPctlNo());
		this.hashColumns.put("f_mty_pkup_yd_node", getFMtyPkupYdNode());
		this.hashColumns.put("f_cmdt_cd", getFCmdtCd());
		this.hashColumns.put("f_n_pod", getFNPod());
		this.hashColumns.put("f_cob_profit_vw", getFCobProfitVw());
		this.hashColumns.put("f_mty_rtn_yd_cd", getFMtyRtnYdCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("f_clt_ofc_cd", getFCltOfcCd());
		this.hashColumns.put("f_n_pol", getFNPol());
		this.hashColumns.put("f_ofc_lvl", getFOfcLvl());
		this.hashColumns.put("f_out_param_varchar", getFOutParamVarchar());
		this.hashColumns.put("f_mty_rtn_yd_node", getFMtyRtnYdNode());
		this.hashColumns.put("f_void_qty", getFVoidQty());
		this.hashColumns.put("f_por_node", getFPorNode());
		this.hashColumns.put("f_end_pctl_no", getFEndPctlNo());
		this.hashColumns.put("f_spcl_rf", getFSpclRf());
		this.hashColumns.put("f_spcl_bb", getFSpclBb());
		this.hashColumns.put("f_orgi_node", getFOrgiNode());
		this.hashColumns.put("f_d_term", getFDTerm());
		this.hashColumns.put("f_qty", getFQty());
		this.hashColumns.put("f_spcl_ak", getFSpclAk());
		this.hashColumns.put("f_pol_cd", getFPolCd());
		this.hashColumns.put("f_start_pctl_no", getFStartPctlNo());
		this.hashColumns.put("f_chss_term", getFChssTerm());
		this.hashColumns.put("f_dest_node", getFDestNode());
		this.hashColumns.put("f_ppd_ofc_cd", getFPpdOfcCd());
		this.hashColumns.put("f_por_cd", getFPorCd());
		this.hashColumns.put("f_lane4", getFLane4());
		this.hashColumns.put("f_pod_cd", getFPodCd());
		this.hashColumns.put("f_lane3", getFLane3());
		this.hashColumns.put("f_lane2", getFLane2());
		this.hashColumns.put("f_sls_ofc_cd", getFSlsOfcCd());
		this.hashColumns.put("f_cob_profit_lv", getFCobProfitLv());
		this.hashColumns.put("ttl_dys", getTtlDys());
		this.hashColumns.put("f_mty_rtn_yd_chk", getFMtyRtnYdChk());
		this.hashColumns.put("f_spcl_soc", getFSpclSoc());
		this.hashColumns.put("f_del_cd", getFDelCd());
		this.hashColumns.put("f_g_rev", getFGRev());
		this.hashColumns.put("mas_rcc", getMasRcc());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("f_r_term", "fRTerm");
		this.hashFields.put("f_user_id", "fUserId");
		this.hashFields.put("err_msg", "errMsg");
		this.hashFields.put("f_cost_yrmon", "fCostYrmon");
		this.hashFields.put("error_code", "errorCode");
		this.hashFields.put("f_mty_pkup_yd_cd", "fMtyPkupYdCd");
		this.hashFields.put("f_bkg_ofc_cd", "fBkgOfcCd");
		this.hashFields.put("mas_rhq", "masRhq");
		this.hashFields.put("f_out_param_number", "fOutParamNumber");
		this.hashFields.put("f_lane1", "fLane1");
		this.hashFields.put("f_spcl_dg", "fSpclDg");
		this.hashFields.put("f_agmt_sgn_ofc_cd", "fAgmtSgnOfcCd");
		this.hashFields.put("f_pc_creation", "fPcCreation");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("f_spcl_revmt", "fSpclRevmt");
		this.hashFields.put("f_port2", "fPort2");
		this.hashFields.put("f_port1", "fPort1");
		this.hashFields.put("f_port3", "fPort3");
		this.hashFields.put("cntr_mt_dys", "cntrMtDys");
		this.hashFields.put("f_node_cd", "fNodeCd");
		this.hashFields.put("mas_ecc", "masEcc");
		this.hashFields.put("f_ofc_cd", "fOfcCd");
		this.hashFields.put("f_mty_rtn_lst_cd", "fMtyRtnLstCd");
		this.hashFields.put("f_cob_profit_lv2", "fCobProfitLv2");
		this.hashFields.put("f_cntr_tpsz_cd", "fCntrTpszCd");
		this.hashFields.put("f_del_node", "fDelNode");
		this.hashFields.put("f_pctl_no", "fPctlNo");
		this.hashFields.put("f_mty_pkup_yd_node", "fMtyPkupYdNode");
		this.hashFields.put("f_cmdt_cd", "fCmdtCd");
		this.hashFields.put("f_n_pod", "fNPod");
		this.hashFields.put("f_cob_profit_vw", "fCobProfitVw");
		this.hashFields.put("f_mty_rtn_yd_cd", "fMtyRtnYdCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("f_clt_ofc_cd", "fCltOfcCd");
		this.hashFields.put("f_n_pol", "fNPol");
		this.hashFields.put("f_ofc_lvl", "fOfcLvl");
		this.hashFields.put("f_out_param_varchar", "fOutParamVarchar");
		this.hashFields.put("f_mty_rtn_yd_node", "fMtyRtnYdNode");
		this.hashFields.put("f_void_qty", "fVoidQty");
		this.hashFields.put("f_por_node", "fPorNode");
		this.hashFields.put("f_end_pctl_no", "fEndPctlNo");
		this.hashFields.put("f_spcl_rf", "fSpclRf");
		this.hashFields.put("f_spcl_bb", "fSpclBb");
		this.hashFields.put("f_orgi_node", "fOrgiNode");
		this.hashFields.put("f_d_term", "fDTerm");
		this.hashFields.put("f_qty", "fQty");
		this.hashFields.put("f_spcl_ak", "fSpclAk");
		this.hashFields.put("f_pol_cd", "fPolCd");
		this.hashFields.put("f_start_pctl_no", "fStartPctlNo");
		this.hashFields.put("f_chss_term", "fChssTerm");
		this.hashFields.put("f_dest_node", "fDestNode");
		this.hashFields.put("f_ppd_ofc_cd", "fPpdOfcCd");
		this.hashFields.put("f_por_cd", "fPorCd");
		this.hashFields.put("f_lane4", "fLane4");
		this.hashFields.put("f_pod_cd", "fPodCd");
		this.hashFields.put("f_lane3", "fLane3");
		this.hashFields.put("f_lane2", "fLane2");
		this.hashFields.put("f_sls_ofc_cd", "fSlsOfcCd");
		this.hashFields.put("f_cob_profit_lv", "fCobProfitLv");
		this.hashFields.put("ttl_dys", "ttlDys");
		this.hashFields.put("f_mty_rtn_yd_chk", "fMtyRtnYdChk");
		this.hashFields.put("f_spcl_soc", "fSpclSoc");
		this.hashFields.put("f_del_cd", "fDelCd");
		this.hashFields.put("f_g_rev", "fGRev");
		this.hashFields.put("mas_rcc", "masRcc");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fRTerm
	 */
	public String getFRTerm() {
		return this.fRTerm;
	}
	
	/**
	 * Column Info
	 * @return fUserId
	 */
	public String getFUserId() {
		return this.fUserId;
	}
	
	/**
	 * Column Info
	 * @return errMsg
	 */
	public String getErrMsg() {
		return this.errMsg;
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
	 * @return errorCode
	 */
	public String getErrorCode() {
		return this.errorCode;
	}
	
	/**
	 * Column Info
	 * @return fMtyPkupYdCd
	 */
	public String getFMtyPkupYdCd() {
		return this.fMtyPkupYdCd;
	}
	
	/**
	 * Column Info
	 * @return fBkgOfcCd
	 */
	public String getFBkgOfcCd() {
		return this.fBkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return masRhq
	 */
	public String getMasRhq() {
		return this.masRhq;
	}
	
	/**
	 * Column Info
	 * @return fOutParamNumber
	 */
	public String getFOutParamNumber() {
		return this.fOutParamNumber;
	}
	
	/**
	 * Column Info
	 * @return fLane1
	 */
	public String getFLane1() {
		return this.fLane1;
	}
	
	/**
	 * Column Info
	 * @return fSpclDg
	 */
	public String getFSpclDg() {
		return this.fSpclDg;
	}
	
	/**
	 * Column Info
	 * @return fAgmtSgnOfcCd
	 */
	public String getFAgmtSgnOfcCd() {
		return this.fAgmtSgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fPcCreation
	 */
	public String getFPcCreation() {
		return this.fPcCreation;
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
	 * @return fSpclRevmt
	 */
	public String getFSpclRevmt() {
		return this.fSpclRevmt;
	}
	
	/**
	 * Column Info
	 * @return fPort2
	 */
	public String getFPort2() {
		return this.fPort2;
	}
	
	/**
	 * Column Info
	 * @return fPort1
	 */
	public String getFPort1() {
		return this.fPort1;
	}
	
	/**
	 * Column Info
	 * @return fPort3
	 */
	public String getFPort3() {
		return this.fPort3;
	}
	
	/**
	 * Column Info
	 * @return cntrMtDys
	 */
	public String getCntrMtDys() {
		return this.cntrMtDys;
	}
	
	/**
	 * Column Info
	 * @return fNodeCd
	 */
	public String getFNodeCd() {
		return this.fNodeCd;
	}
	
	/**
	 * Column Info
	 * @return masEcc
	 */
	public String getMasEcc() {
		return this.masEcc;
	}
	
	/**
	 * Column Info
	 * @return fOfcCd
	 */
	public String getFOfcCd() {
		return this.fOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fMtyRtnLstCd
	 */
	public String getFMtyRtnLstCd() {
		return this.fMtyRtnLstCd;
	}
	
	/**
	 * Column Info
	 * @return fCobProfitLv2
	 */
	public String getFCobProfitLv2() {
		return this.fCobProfitLv2;
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
	 * @return fDelNode
	 */
	public String getFDelNode() {
		return this.fDelNode;
	}
	
	/**
	 * Column Info
	 * @return fPctlNo
	 */
	public String getFPctlNo() {
		return this.fPctlNo;
	}
	
	/**
	 * Column Info
	 * @return fMtyPkupYdNode
	 */
	public String getFMtyPkupYdNode() {
		return this.fMtyPkupYdNode;
	}
	
	/**
	 * Column Info
	 * @return fCmdtCd
	 */
	public String getFCmdtCd() {
		return this.fCmdtCd;
	}
	
	/**
	 * Column Info
	 * @return fNPod
	 */
	public String getFNPod() {
		return this.fNPod;
	}
	
	/**
	 * Column Info
	 * @return fCobProfitVw
	 */
	public String getFCobProfitVw() {
		return this.fCobProfitVw;
	}
	
	/**
	 * Column Info
	 * @return fMtyRtnYdCd
	 */
	public String getFMtyRtnYdCd() {
		return this.fMtyRtnYdCd;
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
	 * @return fCltOfcCd
	 */
	public String getFCltOfcCd() {
		return this.fCltOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fNPol
	 */
	public String getFNPol() {
		return this.fNPol;
	}
	
	/**
	 * Column Info
	 * @return fOfcLvl
	 */
	public String getFOfcLvl() {
		return this.fOfcLvl;
	}
	
	/**
	 * Column Info
	 * @return fOutParamVarchar
	 */
	public String getFOutParamVarchar() {
		return this.fOutParamVarchar;
	}
	
	/**
	 * Column Info
	 * @return fMtyRtnYdNode
	 */
	public String getFMtyRtnYdNode() {
		return this.fMtyRtnYdNode;
	}
	
	/**
	 * Column Info
	 * @return fVoidQty
	 */
	public String getFVoidQty() {
		return this.fVoidQty;
	}
	
	/**
	 * Column Info
	 * @return fPorNode
	 */
	public String getFPorNode() {
		return this.fPorNode;
	}
	
	/**
	 * Column Info
	 * @return fEndPctlNo
	 */
	public String getFEndPctlNo() {
		return this.fEndPctlNo;
	}
	
	/**
	 * Column Info
	 * @return fSpclRf
	 */
	public String getFSpclRf() {
		return this.fSpclRf;
	}
	
	/**
	 * Column Info
	 * @return fSpclBb
	 */
	public String getFSpclBb() {
		return this.fSpclBb;
	}
	
	/**
	 * Column Info
	 * @return fOrgiNode
	 */
	public String getFOrgiNode() {
		return this.fOrgiNode;
	}
	
	/**
	 * Column Info
	 * @return fDTerm
	 */
	public String getFDTerm() {
		return this.fDTerm;
	}
	
	/**
	 * Column Info
	 * @return fQty
	 */
	public String getFQty() {
		return this.fQty;
	}
	
	/**
	 * Column Info
	 * @return fSpclAk
	 */
	public String getFSpclAk() {
		return this.fSpclAk;
	}
	
	/**
	 * Column Info
	 * @return fPolCd
	 */
	public String getFPolCd() {
		return this.fPolCd;
	}
	
	/**
	 * Column Info
	 * @return fStartPctlNo
	 */
	public String getFStartPctlNo() {
		return this.fStartPctlNo;
	}
	
	/**
	 * Column Info
	 * @return fChssTerm
	 */
	public String getFChssTerm() {
		return this.fChssTerm;
	}
	
	/**
	 * Column Info
	 * @return fDestNode
	 */
	public String getFDestNode() {
		return this.fDestNode;
	}
	
	/**
	 * Column Info
	 * @return fPpdOfcCd
	 */
	public String getFPpdOfcCd() {
		return this.fPpdOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fPorCd
	 */
	public String getFPorCd() {
		return this.fPorCd;
	}
	
	/**
	 * Column Info
	 * @return fLane4
	 */
	public String getFLane4() {
		return this.fLane4;
	}
	
	/**
	 * Column Info
	 * @return fPodCd
	 */
	public String getFPodCd() {
		return this.fPodCd;
	}
	
	/**
	 * Column Info
	 * @return fLane3
	 */
	public String getFLane3() {
		return this.fLane3;
	}
	
	/**
	 * Column Info
	 * @return fLane2
	 */
	public String getFLane2() {
		return this.fLane2;
	}
	
	/**
	 * Column Info
	 * @return fSlsOfcCd
	 */
	public String getFSlsOfcCd() {
		return this.fSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fCobProfitLv
	 */
	public String getFCobProfitLv() {
		return this.fCobProfitLv;
	}
	
	/**
	 * Column Info
	 * @return ttlDys
	 */
	public String getTtlDys() {
		return this.ttlDys;
	}
	
	/**
	 * Column Info
	 * @return fMtyRtnYdChk
	 */
	public String getFMtyRtnYdChk() {
		return this.fMtyRtnYdChk;
	}
	
	/**
	 * Column Info
	 * @return fSpclSoc
	 */
	public String getFSpclSoc() {
		return this.fSpclSoc;
	}
	
	/**
	 * Column Info
	 * @return fDelCd
	 */
	public String getFDelCd() {
		return this.fDelCd;
	}
	
	/**
	 * Column Info
	 * @return fGRev
	 */
	public String getFGRev() {
		return this.fGRev;
	}
	
	/**
	 * Column Info
	 * @return masRcc
	 */
	public String getMasRcc() {
		return this.masRcc;
	}
	

	/**
	 * Column Info
	 * @param fRTerm
	 */
	public void setFRTerm(String fRTerm) {
		this.fRTerm = fRTerm;
	}
	
	/**
	 * Column Info
	 * @param fUserId
	 */
	public void setFUserId(String fUserId) {
		this.fUserId = fUserId;
	}
	
	/**
	 * Column Info
	 * @param errMsg
	 */
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
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
	 * @param errorCode
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	/**
	 * Column Info
	 * @param fMtyPkupYdCd
	 */
	public void setFMtyPkupYdCd(String fMtyPkupYdCd) {
		this.fMtyPkupYdCd = fMtyPkupYdCd;
	}
	
	/**
	 * Column Info
	 * @param fBkgOfcCd
	 */
	public void setFBkgOfcCd(String fBkgOfcCd) {
		this.fBkgOfcCd = fBkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param masRhq
	 */
	public void setMasRhq(String masRhq) {
		this.masRhq = masRhq;
	}
	
	/**
	 * Column Info
	 * @param fOutParamNumber
	 */
	public void setFOutParamNumber(String fOutParamNumber) {
		this.fOutParamNumber = fOutParamNumber;
	}
	
	/**
	 * Column Info
	 * @param fLane1
	 */
	public void setFLane1(String fLane1) {
		this.fLane1 = fLane1;
	}
	
	/**
	 * Column Info
	 * @param fSpclDg
	 */
	public void setFSpclDg(String fSpclDg) {
		this.fSpclDg = fSpclDg;
	}
	
	/**
	 * Column Info
	 * @param fAgmtSgnOfcCd
	 */
	public void setFAgmtSgnOfcCd(String fAgmtSgnOfcCd) {
		this.fAgmtSgnOfcCd = fAgmtSgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fPcCreation
	 */
	public void setFPcCreation(String fPcCreation) {
		this.fPcCreation = fPcCreation;
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
	 * @param fSpclRevmt
	 */
	public void setFSpclRevmt(String fSpclRevmt) {
		this.fSpclRevmt = fSpclRevmt;
	}
	
	/**
	 * Column Info
	 * @param fPort2
	 */
	public void setFPort2(String fPort2) {
		this.fPort2 = fPort2;
	}
	
	/**
	 * Column Info
	 * @param fPort1
	 */
	public void setFPort1(String fPort1) {
		this.fPort1 = fPort1;
	}
	
	/**
	 * Column Info
	 * @param fPort3
	 */
	public void setFPort3(String fPort3) {
		this.fPort3 = fPort3;
	}
	
	/**
	 * Column Info
	 * @param cntrMtDys
	 */
	public void setCntrMtDys(String cntrMtDys) {
		this.cntrMtDys = cntrMtDys;
	}
	
	/**
	 * Column Info
	 * @param fNodeCd
	 */
	public void setFNodeCd(String fNodeCd) {
		this.fNodeCd = fNodeCd;
	}
	
	/**
	 * Column Info
	 * @param masEcc
	 */
	public void setMasEcc(String masEcc) {
		this.masEcc = masEcc;
	}
	
	/**
	 * Column Info
	 * @param fOfcCd
	 */
	public void setFOfcCd(String fOfcCd) {
		this.fOfcCd = fOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fMtyRtnLstCd
	 */
	public void setFMtyRtnLstCd(String fMtyRtnLstCd) {
		this.fMtyRtnLstCd = fMtyRtnLstCd;
	}
	
	/**
	 * Column Info
	 * @param fCobProfitLv2
	 */
	public void setFCobProfitLv2(String fCobProfitLv2) {
		this.fCobProfitLv2 = fCobProfitLv2;
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
	 * @param fDelNode
	 */
	public void setFDelNode(String fDelNode) {
		this.fDelNode = fDelNode;
	}
	
	/**
	 * Column Info
	 * @param fPctlNo
	 */
	public void setFPctlNo(String fPctlNo) {
		this.fPctlNo = fPctlNo;
	}
	
	/**
	 * Column Info
	 * @param fMtyPkupYdNode
	 */
	public void setFMtyPkupYdNode(String fMtyPkupYdNode) {
		this.fMtyPkupYdNode = fMtyPkupYdNode;
	}
	
	/**
	 * Column Info
	 * @param fCmdtCd
	 */
	public void setFCmdtCd(String fCmdtCd) {
		this.fCmdtCd = fCmdtCd;
	}
	
	/**
	 * Column Info
	 * @param fNPod
	 */
	public void setFNPod(String fNPod) {
		this.fNPod = fNPod;
	}
	
	/**
	 * Column Info
	 * @param fCobProfitVw
	 */
	public void setFCobProfitVw(String fCobProfitVw) {
		this.fCobProfitVw = fCobProfitVw;
	}
	
	/**
	 * Column Info
	 * @param fMtyRtnYdCd
	 */
	public void setFMtyRtnYdCd(String fMtyRtnYdCd) {
		this.fMtyRtnYdCd = fMtyRtnYdCd;
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
	 * @param fCltOfcCd
	 */
	public void setFCltOfcCd(String fCltOfcCd) {
		this.fCltOfcCd = fCltOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fNPol
	 */
	public void setFNPol(String fNPol) {
		this.fNPol = fNPol;
	}
	
	/**
	 * Column Info
	 * @param fOfcLvl
	 */
	public void setFOfcLvl(String fOfcLvl) {
		this.fOfcLvl = fOfcLvl;
	}
	
	/**
	 * Column Info
	 * @param fOutParamVarchar
	 */
	public void setFOutParamVarchar(String fOutParamVarchar) {
		this.fOutParamVarchar = fOutParamVarchar;
	}
	
	/**
	 * Column Info
	 * @param fMtyRtnYdNode
	 */
	public void setFMtyRtnYdNode(String fMtyRtnYdNode) {
		this.fMtyRtnYdNode = fMtyRtnYdNode;
	}
	
	/**
	 * Column Info
	 * @param fVoidQty
	 */
	public void setFVoidQty(String fVoidQty) {
		this.fVoidQty = fVoidQty;
	}
	
	/**
	 * Column Info
	 * @param fPorNode
	 */
	public void setFPorNode(String fPorNode) {
		this.fPorNode = fPorNode;
	}
	
	/**
	 * Column Info
	 * @param fEndPctlNo
	 */
	public void setFEndPctlNo(String fEndPctlNo) {
		this.fEndPctlNo = fEndPctlNo;
	}
	
	/**
	 * Column Info
	 * @param fSpclRf
	 */
	public void setFSpclRf(String fSpclRf) {
		this.fSpclRf = fSpclRf;
	}
	
	/**
	 * Column Info
	 * @param fSpclBb
	 */
	public void setFSpclBb(String fSpclBb) {
		this.fSpclBb = fSpclBb;
	}
	
	/**
	 * Column Info
	 * @param fOrgiNode
	 */
	public void setFOrgiNode(String fOrgiNode) {
		this.fOrgiNode = fOrgiNode;
	}
	
	/**
	 * Column Info
	 * @param fDTerm
	 */
	public void setFDTerm(String fDTerm) {
		this.fDTerm = fDTerm;
	}
	
	/**
	 * Column Info
	 * @param fQty
	 */
	public void setFQty(String fQty) {
		this.fQty = fQty;
	}
	
	/**
	 * Column Info
	 * @param fSpclAk
	 */
	public void setFSpclAk(String fSpclAk) {
		this.fSpclAk = fSpclAk;
	}
	
	/**
	 * Column Info
	 * @param fPolCd
	 */
	public void setFPolCd(String fPolCd) {
		this.fPolCd = fPolCd;
	}
	
	/**
	 * Column Info
	 * @param fStartPctlNo
	 */
	public void setFStartPctlNo(String fStartPctlNo) {
		this.fStartPctlNo = fStartPctlNo;
	}
	
	/**
	 * Column Info
	 * @param fChssTerm
	 */
	public void setFChssTerm(String fChssTerm) {
		this.fChssTerm = fChssTerm;
	}
	
	/**
	 * Column Info
	 * @param fDestNode
	 */
	public void setFDestNode(String fDestNode) {
		this.fDestNode = fDestNode;
	}
	
	/**
	 * Column Info
	 * @param fPpdOfcCd
	 */
	public void setFPpdOfcCd(String fPpdOfcCd) {
		this.fPpdOfcCd = fPpdOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fPorCd
	 */
	public void setFPorCd(String fPorCd) {
		this.fPorCd = fPorCd;
	}
	
	/**
	 * Column Info
	 * @param fLane4
	 */
	public void setFLane4(String fLane4) {
		this.fLane4 = fLane4;
	}
	
	/**
	 * Column Info
	 * @param fPodCd
	 */
	public void setFPodCd(String fPodCd) {
		this.fPodCd = fPodCd;
	}
	
	/**
	 * Column Info
	 * @param fLane3
	 */
	public void setFLane3(String fLane3) {
		this.fLane3 = fLane3;
	}
	
	/**
	 * Column Info
	 * @param fLane2
	 */
	public void setFLane2(String fLane2) {
		this.fLane2 = fLane2;
	}
	
	/**
	 * Column Info
	 * @param fSlsOfcCd
	 */
	public void setFSlsOfcCd(String fSlsOfcCd) {
		this.fSlsOfcCd = fSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fCobProfitLv
	 */
	public void setFCobProfitLv(String fCobProfitLv) {
		this.fCobProfitLv = fCobProfitLv;
	}
	
	/**
	 * Column Info
	 * @param ttlDys
	 */
	public void setTtlDys(String ttlDys) {
		this.ttlDys = ttlDys;
	}
	
	/**
	 * Column Info
	 * @param fMtyRtnYdChk
	 */
	public void setFMtyRtnYdChk(String fMtyRtnYdChk) {
		this.fMtyRtnYdChk = fMtyRtnYdChk;
	}
	
	/**
	 * Column Info
	 * @param fSpclSoc
	 */
	public void setFSpclSoc(String fSpclSoc) {
		this.fSpclSoc = fSpclSoc;
	}
	
	/**
	 * Column Info
	 * @param fDelCd
	 */
	public void setFDelCd(String fDelCd) {
		this.fDelCd = fDelCd;
	}
	
	/**
	 * Column Info
	 * @param fGRev
	 */
	public void setFGRev(String fGRev) {
		this.fGRev = fGRev;
	}
	
	/**
	 * Column Info
	 * @param masRcc
	 */
	public void setMasRcc(String masRcc) {
		this.masRcc = masRcc;
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
		setFRTerm(JSPUtil.getParameter(request, prefix + "f_r_term", ""));
		setFUserId(JSPUtil.getParameter(request, prefix + "f_user_id", ""));
		setErrMsg(JSPUtil.getParameter(request, prefix + "err_msg", ""));
		setFCostYrmon(JSPUtil.getParameter(request, prefix + "f_cost_yrmon", ""));
		setErrorCode(JSPUtil.getParameter(request, prefix + "error_code", ""));
		setFMtyPkupYdCd(JSPUtil.getParameter(request, prefix + "f_mty_pkup_yd_cd", ""));
		setFBkgOfcCd(JSPUtil.getParameter(request, prefix + "f_bkg_ofc_cd", ""));
		setMasRhq(JSPUtil.getParameter(request, prefix + "mas_rhq", ""));
		setFOutParamNumber(JSPUtil.getParameter(request, prefix + "f_out_param_number", ""));
		setFLane1(JSPUtil.getParameter(request, prefix + "f_lane1", ""));
		setFSpclDg(JSPUtil.getParameter(request, prefix + "f_spcl_dg", ""));
		setFAgmtSgnOfcCd(JSPUtil.getParameter(request, prefix + "f_agmt_sgn_ofc_cd", ""));
		setFPcCreation(JSPUtil.getParameter(request, prefix + "f_pc_creation", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFSpclRevmt(JSPUtil.getParameter(request, prefix + "f_spcl_revmt", ""));
		setFPort2(JSPUtil.getParameter(request, prefix + "f_port2", ""));
		setFPort1(JSPUtil.getParameter(request, prefix + "f_port1", ""));
		setFPort3(JSPUtil.getParameter(request, prefix + "f_port3", ""));
		setCntrMtDys(JSPUtil.getParameter(request, prefix + "cntr_mt_dys", ""));
		setFNodeCd(JSPUtil.getParameter(request, prefix + "f_node_cd", ""));
		setMasEcc(JSPUtil.getParameter(request, prefix + "mas_ecc", ""));
		setFOfcCd(JSPUtil.getParameter(request, prefix + "f_ofc_cd", ""));
		setFMtyRtnLstCd(JSPUtil.getParameter(request, prefix + "f_mty_rtn_lst_cd", ""));
		setFCobProfitLv2(JSPUtil.getParameter(request, prefix + "f_cob_profit_lv2", ""));
		setFCntrTpszCd(JSPUtil.getParameter(request, prefix + "f_cntr_tpsz_cd", ""));
		setFDelNode(JSPUtil.getParameter(request, prefix + "f_del_node", ""));
		setFPctlNo(JSPUtil.getParameter(request, prefix + "f_pctl_no", ""));
		setFMtyPkupYdNode(JSPUtil.getParameter(request, prefix + "f_mty_pkup_yd_node", ""));
		setFCmdtCd(JSPUtil.getParameter(request, prefix + "f_cmdt_cd", ""));
		setFNPod(JSPUtil.getParameter(request, prefix + "f_n_pod", ""));
		setFCobProfitVw(JSPUtil.getParameter(request, prefix + "f_cob_profit_vw", ""));
		setFMtyRtnYdCd(JSPUtil.getParameter(request, prefix + "f_mty_rtn_yd_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFCltOfcCd(JSPUtil.getParameter(request, prefix + "f_clt_ofc_cd", ""));
		setFNPol(JSPUtil.getParameter(request, prefix + "f_n_pol", ""));
		setFOfcLvl(JSPUtil.getParameter(request, prefix + "f_ofc_lvl", ""));
		setFOutParamVarchar(JSPUtil.getParameter(request, prefix + "f_out_param_varchar", ""));
		setFMtyRtnYdNode(JSPUtil.getParameter(request, prefix + "f_mty_rtn_yd_node", ""));
		setFVoidQty(JSPUtil.getParameter(request, prefix + "f_void_qty", ""));
		setFPorNode(JSPUtil.getParameter(request, prefix + "f_por_node", ""));
		setFEndPctlNo(JSPUtil.getParameter(request, prefix + "f_end_pctl_no", ""));
		setFSpclRf(JSPUtil.getParameter(request, prefix + "f_spcl_rf", ""));
		setFSpclBb(JSPUtil.getParameter(request, prefix + "f_spcl_bb", ""));
		setFOrgiNode(JSPUtil.getParameter(request, prefix + "f_orgi_node", ""));
		setFDTerm(JSPUtil.getParameter(request, prefix + "f_d_term", ""));
		setFQty(JSPUtil.getParameter(request, prefix + "f_qty", ""));
		setFSpclAk(JSPUtil.getParameter(request, prefix + "f_spcl_ak", ""));
		setFPolCd(JSPUtil.getParameter(request, prefix + "f_pol_cd", ""));
		setFStartPctlNo(JSPUtil.getParameter(request, prefix + "f_start_pctl_no", ""));
		setFChssTerm(JSPUtil.getParameter(request, prefix + "f_chss_term", ""));
		setFDestNode(JSPUtil.getParameter(request, prefix + "f_dest_node", ""));
		setFPpdOfcCd(JSPUtil.getParameter(request, prefix + "f_ppd_ofc_cd", ""));
		setFPorCd(JSPUtil.getParameter(request, prefix + "f_por_cd", ""));
		setFLane4(JSPUtil.getParameter(request, prefix + "f_lane4", ""));
		setFPodCd(JSPUtil.getParameter(request, prefix + "f_pod_cd", ""));
		setFLane3(JSPUtil.getParameter(request, prefix + "f_lane3", ""));
		setFLane2(JSPUtil.getParameter(request, prefix + "f_lane2", ""));
		setFSlsOfcCd(JSPUtil.getParameter(request, prefix + "f_sls_ofc_cd", ""));
		setFCobProfitLv(JSPUtil.getParameter(request, prefix + "f_cob_profit_lv", ""));
		setTtlDys(JSPUtil.getParameter(request, prefix + "ttl_dys", ""));
		setFMtyRtnYdChk(JSPUtil.getParameter(request, prefix + "f_mty_rtn_yd_chk", ""));
		setFSpclSoc(JSPUtil.getParameter(request, prefix + "f_spcl_soc", ""));
		setFDelCd(JSPUtil.getParameter(request, prefix + "f_del_cd", ""));
		setFGRev(JSPUtil.getParameter(request, prefix + "f_g_rev", ""));
		setMasRcc(JSPUtil.getParameter(request, prefix + "mas_rcc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCondition0153VO[]
	 */
	public SearchCondition0153VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCondition0153VO[]
	 */
	public SearchCondition0153VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCondition0153VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fRTerm = (JSPUtil.getParameter(request, prefix	+ "f_r_term", length));
			String[] fUserId = (JSPUtil.getParameter(request, prefix	+ "f_user_id", length));
			String[] errMsg = (JSPUtil.getParameter(request, prefix	+ "err_msg", length));
			String[] fCostYrmon = (JSPUtil.getParameter(request, prefix	+ "f_cost_yrmon", length));
			String[] errorCode = (JSPUtil.getParameter(request, prefix	+ "error_code", length));
			String[] fMtyPkupYdCd = (JSPUtil.getParameter(request, prefix	+ "f_mty_pkup_yd_cd", length));
			String[] fBkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "f_bkg_ofc_cd", length));
			String[] masRhq = (JSPUtil.getParameter(request, prefix	+ "mas_rhq", length));
			String[] fOutParamNumber = (JSPUtil.getParameter(request, prefix	+ "f_out_param_number", length));
			String[] fLane1 = (JSPUtil.getParameter(request, prefix	+ "f_lane1", length));
			String[] fSpclDg = (JSPUtil.getParameter(request, prefix	+ "f_spcl_dg", length));
			String[] fAgmtSgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "f_agmt_sgn_ofc_cd", length));
			String[] fPcCreation = (JSPUtil.getParameter(request, prefix	+ "f_pc_creation", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fSpclRevmt = (JSPUtil.getParameter(request, prefix	+ "f_spcl_revmt", length));
			String[] fPort2 = (JSPUtil.getParameter(request, prefix	+ "f_port2", length));
			String[] fPort1 = (JSPUtil.getParameter(request, prefix	+ "f_port1", length));
			String[] fPort3 = (JSPUtil.getParameter(request, prefix	+ "f_port3", length));
			String[] cntrMtDys = (JSPUtil.getParameter(request, prefix	+ "cntr_mt_dys", length));
			String[] fNodeCd = (JSPUtil.getParameter(request, prefix	+ "f_node_cd", length));
			String[] masEcc = (JSPUtil.getParameter(request, prefix	+ "mas_ecc", length));
			String[] fOfcCd = (JSPUtil.getParameter(request, prefix	+ "f_ofc_cd", length));
			String[] fMtyRtnLstCd = (JSPUtil.getParameter(request, prefix	+ "f_mty_rtn_lst_cd", length));
			String[] fCobProfitLv2 = (JSPUtil.getParameter(request, prefix	+ "f_cob_profit_lv2", length));
			String[] fCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "f_cntr_tpsz_cd", length));
			String[] fDelNode = (JSPUtil.getParameter(request, prefix	+ "f_del_node", length));
			String[] fPctlNo = (JSPUtil.getParameter(request, prefix	+ "f_pctl_no", length));
			String[] fMtyPkupYdNode = (JSPUtil.getParameter(request, prefix	+ "f_mty_pkup_yd_node", length));
			String[] fCmdtCd = (JSPUtil.getParameter(request, prefix	+ "f_cmdt_cd", length));
			String[] fNPod = (JSPUtil.getParameter(request, prefix	+ "f_n_pod", length));
			String[] fCobProfitVw = (JSPUtil.getParameter(request, prefix	+ "f_cob_profit_vw", length));
			String[] fMtyRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "f_mty_rtn_yd_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fCltOfcCd = (JSPUtil.getParameter(request, prefix	+ "f_clt_ofc_cd", length));
			String[] fNPol = (JSPUtil.getParameter(request, prefix	+ "f_n_pol", length));
			String[] fOfcLvl = (JSPUtil.getParameter(request, prefix	+ "f_ofc_lvl", length));
			String[] fOutParamVarchar = (JSPUtil.getParameter(request, prefix	+ "f_out_param_varchar", length));
			String[] fMtyRtnYdNode = (JSPUtil.getParameter(request, prefix	+ "f_mty_rtn_yd_node", length));
			String[] fVoidQty = (JSPUtil.getParameter(request, prefix	+ "f_void_qty", length));
			String[] fPorNode = (JSPUtil.getParameter(request, prefix	+ "f_por_node", length));
			String[] fEndPctlNo = (JSPUtil.getParameter(request, prefix	+ "f_end_pctl_no", length));
			String[] fSpclRf = (JSPUtil.getParameter(request, prefix	+ "f_spcl_rf", length));
			String[] fSpclBb = (JSPUtil.getParameter(request, prefix	+ "f_spcl_bb", length));
			String[] fOrgiNode = (JSPUtil.getParameter(request, prefix	+ "f_orgi_node", length));
			String[] fDTerm = (JSPUtil.getParameter(request, prefix	+ "f_d_term", length));
			String[] fQty = (JSPUtil.getParameter(request, prefix	+ "f_qty", length));
			String[] fSpclAk = (JSPUtil.getParameter(request, prefix	+ "f_spcl_ak", length));
			String[] fPolCd = (JSPUtil.getParameter(request, prefix	+ "f_pol_cd", length));
			String[] fStartPctlNo = (JSPUtil.getParameter(request, prefix	+ "f_start_pctl_no", length));
			String[] fChssTerm = (JSPUtil.getParameter(request, prefix	+ "f_chss_term", length));
			String[] fDestNode = (JSPUtil.getParameter(request, prefix	+ "f_dest_node", length));
			String[] fPpdOfcCd = (JSPUtil.getParameter(request, prefix	+ "f_ppd_ofc_cd", length));
			String[] fPorCd = (JSPUtil.getParameter(request, prefix	+ "f_por_cd", length));
			String[] fLane4 = (JSPUtil.getParameter(request, prefix	+ "f_lane4", length));
			String[] fPodCd = (JSPUtil.getParameter(request, prefix	+ "f_pod_cd", length));
			String[] fLane3 = (JSPUtil.getParameter(request, prefix	+ "f_lane3", length));
			String[] fLane2 = (JSPUtil.getParameter(request, prefix	+ "f_lane2", length));
			String[] fSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "f_sls_ofc_cd", length));
			String[] fCobProfitLv = (JSPUtil.getParameter(request, prefix	+ "f_cob_profit_lv", length));
			String[] ttlDys = (JSPUtil.getParameter(request, prefix	+ "ttl_dys", length));
			String[] fMtyRtnYdChk = (JSPUtil.getParameter(request, prefix	+ "f_mty_rtn_yd_chk", length));
			String[] fSpclSoc = (JSPUtil.getParameter(request, prefix	+ "f_spcl_soc", length));
			String[] fDelCd = (JSPUtil.getParameter(request, prefix	+ "f_del_cd", length));
			String[] fGRev = (JSPUtil.getParameter(request, prefix	+ "f_g_rev", length));
			String[] masRcc = (JSPUtil.getParameter(request, prefix	+ "mas_rcc", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCondition0153VO();
				if (fRTerm[i] != null)
					model.setFRTerm(fRTerm[i]);
				if (fUserId[i] != null)
					model.setFUserId(fUserId[i]);
				if (errMsg[i] != null)
					model.setErrMsg(errMsg[i]);
				if (fCostYrmon[i] != null)
					model.setFCostYrmon(fCostYrmon[i]);
				if (errorCode[i] != null)
					model.setErrorCode(errorCode[i]);
				if (fMtyPkupYdCd[i] != null)
					model.setFMtyPkupYdCd(fMtyPkupYdCd[i]);
				if (fBkgOfcCd[i] != null)
					model.setFBkgOfcCd(fBkgOfcCd[i]);
				if (masRhq[i] != null)
					model.setMasRhq(masRhq[i]);
				if (fOutParamNumber[i] != null)
					model.setFOutParamNumber(fOutParamNumber[i]);
				if (fLane1[i] != null)
					model.setFLane1(fLane1[i]);
				if (fSpclDg[i] != null)
					model.setFSpclDg(fSpclDg[i]);
				if (fAgmtSgnOfcCd[i] != null)
					model.setFAgmtSgnOfcCd(fAgmtSgnOfcCd[i]);
				if (fPcCreation[i] != null)
					model.setFPcCreation(fPcCreation[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fSpclRevmt[i] != null)
					model.setFSpclRevmt(fSpclRevmt[i]);
				if (fPort2[i] != null)
					model.setFPort2(fPort2[i]);
				if (fPort1[i] != null)
					model.setFPort1(fPort1[i]);
				if (fPort3[i] != null)
					model.setFPort3(fPort3[i]);
				if (cntrMtDys[i] != null)
					model.setCntrMtDys(cntrMtDys[i]);
				if (fNodeCd[i] != null)
					model.setFNodeCd(fNodeCd[i]);
				if (masEcc[i] != null)
					model.setMasEcc(masEcc[i]);
				if (fOfcCd[i] != null)
					model.setFOfcCd(fOfcCd[i]);
				if (fMtyRtnLstCd[i] != null)
					model.setFMtyRtnLstCd(fMtyRtnLstCd[i]);
				if (fCobProfitLv2[i] != null)
					model.setFCobProfitLv2(fCobProfitLv2[i]);
				if (fCntrTpszCd[i] != null)
					model.setFCntrTpszCd(fCntrTpszCd[i]);
				if (fDelNode[i] != null)
					model.setFDelNode(fDelNode[i]);
				if (fPctlNo[i] != null)
					model.setFPctlNo(fPctlNo[i]);
				if (fMtyPkupYdNode[i] != null)
					model.setFMtyPkupYdNode(fMtyPkupYdNode[i]);
				if (fCmdtCd[i] != null)
					model.setFCmdtCd(fCmdtCd[i]);
				if (fNPod[i] != null)
					model.setFNPod(fNPod[i]);
				if (fCobProfitVw[i] != null)
					model.setFCobProfitVw(fCobProfitVw[i]);
				if (fMtyRtnYdCd[i] != null)
					model.setFMtyRtnYdCd(fMtyRtnYdCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fCltOfcCd[i] != null)
					model.setFCltOfcCd(fCltOfcCd[i]);
				if (fNPol[i] != null)
					model.setFNPol(fNPol[i]);
				if (fOfcLvl[i] != null)
					model.setFOfcLvl(fOfcLvl[i]);
				if (fOutParamVarchar[i] != null)
					model.setFOutParamVarchar(fOutParamVarchar[i]);
				if (fMtyRtnYdNode[i] != null)
					model.setFMtyRtnYdNode(fMtyRtnYdNode[i]);
				if (fVoidQty[i] != null)
					model.setFVoidQty(fVoidQty[i]);
				if (fPorNode[i] != null)
					model.setFPorNode(fPorNode[i]);
				if (fEndPctlNo[i] != null)
					model.setFEndPctlNo(fEndPctlNo[i]);
				if (fSpclRf[i] != null)
					model.setFSpclRf(fSpclRf[i]);
				if (fSpclBb[i] != null)
					model.setFSpclBb(fSpclBb[i]);
				if (fOrgiNode[i] != null)
					model.setFOrgiNode(fOrgiNode[i]);
				if (fDTerm[i] != null)
					model.setFDTerm(fDTerm[i]);
				if (fQty[i] != null)
					model.setFQty(fQty[i]);
				if (fSpclAk[i] != null)
					model.setFSpclAk(fSpclAk[i]);
				if (fPolCd[i] != null)
					model.setFPolCd(fPolCd[i]);
				if (fStartPctlNo[i] != null)
					model.setFStartPctlNo(fStartPctlNo[i]);
				if (fChssTerm[i] != null)
					model.setFChssTerm(fChssTerm[i]);
				if (fDestNode[i] != null)
					model.setFDestNode(fDestNode[i]);
				if (fPpdOfcCd[i] != null)
					model.setFPpdOfcCd(fPpdOfcCd[i]);
				if (fPorCd[i] != null)
					model.setFPorCd(fPorCd[i]);
				if (fLane4[i] != null)
					model.setFLane4(fLane4[i]);
				if (fPodCd[i] != null)
					model.setFPodCd(fPodCd[i]);
				if (fLane3[i] != null)
					model.setFLane3(fLane3[i]);
				if (fLane2[i] != null)
					model.setFLane2(fLane2[i]);
				if (fSlsOfcCd[i] != null)
					model.setFSlsOfcCd(fSlsOfcCd[i]);
				if (fCobProfitLv[i] != null)
					model.setFCobProfitLv(fCobProfitLv[i]);
				if (ttlDys[i] != null)
					model.setTtlDys(ttlDys[i]);
				if (fMtyRtnYdChk[i] != null)
					model.setFMtyRtnYdChk(fMtyRtnYdChk[i]);
				if (fSpclSoc[i] != null)
					model.setFSpclSoc(fSpclSoc[i]);
				if (fDelCd[i] != null)
					model.setFDelCd(fDelCd[i]);
				if (fGRev[i] != null)
					model.setFGRev(fGRev[i]);
				if (masRcc[i] != null)
					model.setMasRcc(masRcc[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCondition0153VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCondition0153VO[]
	 */
	public SearchCondition0153VO[] getSearchCondition0153VOs(){
		SearchCondition0153VO[] vos = (SearchCondition0153VO[])models.toArray(new SearchCondition0153VO[models.size()]);
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
		this.fRTerm = this.fRTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fUserId = this.fUserId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errMsg = this.errMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCostYrmon = this.fCostYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errorCode = this.errorCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fMtyPkupYdCd = this.fMtyPkupYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBkgOfcCd = this.fBkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masRhq = this.masRhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fOutParamNumber = this.fOutParamNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fLane1 = this.fLane1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSpclDg = this.fSpclDg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fAgmtSgnOfcCd = this.fAgmtSgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPcCreation = this.fPcCreation .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSpclRevmt = this.fSpclRevmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPort2 = this.fPort2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPort1 = this.fPort1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPort3 = this.fPort3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMtDys = this.cntrMtDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fNodeCd = this.fNodeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masEcc = this.masEcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fOfcCd = this.fOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fMtyRtnLstCd = this.fMtyRtnLstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCobProfitLv2 = this.fCobProfitLv2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCntrTpszCd = this.fCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDelNode = this.fDelNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPctlNo = this.fPctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fMtyPkupYdNode = this.fMtyPkupYdNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCmdtCd = this.fCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fNPod = this.fNPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCobProfitVw = this.fCobProfitVw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fMtyRtnYdCd = this.fMtyRtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCltOfcCd = this.fCltOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fNPol = this.fNPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fOfcLvl = this.fOfcLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fOutParamVarchar = this.fOutParamVarchar .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fMtyRtnYdNode = this.fMtyRtnYdNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fVoidQty = this.fVoidQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPorNode = this.fPorNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fEndPctlNo = this.fEndPctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSpclRf = this.fSpclRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSpclBb = this.fSpclBb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fOrgiNode = this.fOrgiNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDTerm = this.fDTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fQty = this.fQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSpclAk = this.fSpclAk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPolCd = this.fPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fStartPctlNo = this.fStartPctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fChssTerm = this.fChssTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDestNode = this.fDestNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPpdOfcCd = this.fPpdOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPorCd = this.fPorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fLane4 = this.fLane4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPodCd = this.fPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fLane3 = this.fLane3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fLane2 = this.fLane2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSlsOfcCd = this.fSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCobProfitLv = this.fCobProfitLv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlDys = this.ttlDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fMtyRtnYdChk = this.fMtyRtnYdChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSpclSoc = this.fSpclSoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDelCd = this.fDelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fGRev = this.fGRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masRcc = this.masRcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
