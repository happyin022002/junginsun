/*=========================================================
*Copyright(c) 2013 CyberLogitec

*@FileName : SpcMdlCustRevLaneHisVO.java
*@FileTitle : SpcMdlCustRevLaneHisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.26
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.03.26 진마리아 
* 1.0 Creation
* 2013.03.26 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진 
* 2014.02.04 [CHM-201428383-01] RFA 로직 추가
=========================================================*/

package com.hanjin.syscommon.common.table;

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
 * @author 진마리아
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SpcMdlCustRevLaneHisVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SpcMdlCustRevLaneHisVO> models = new ArrayList<SpcMdlCustRevLaneHisVO>();
	
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String custAdjQty = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String oldRlaneCd = null;
	/* Column Info */
	private String oldCustAdjQty = null;
	/* Column Info */
	private String modiUsrId = null;
	/* Column Info */
	private String custCtrlCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rlaneAdjQty = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String modiSeq = null;
	/* Column Info */
	private String modiGdt = null;
	/* Column Info */
	private String spcCtrlMdlRmk = null;
	/* Column Info */
	private String cngItmNm = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String slsRhqCd = null;
	/* Column Info */
	private String mdlAddFlg = null;
	/* Column Info */
	private String verSeq = null;
	/* Column Info */
	private String oldSlsRgnOfcCd = null;
	/* Column Info */
	private String oldSubTrdAdjQty = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String subTrdAdjQty = null;
	/* Column Info */
	private String oldSpcCtrlMdlRmk = null;
	/* Column Info */
	private String oldRlaneAdjQty = null;
	/* Column Info */
	private String slsRgnOfcCd = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String costYrwk = null;
	/* Column Info */
	private String g1CngUsr = null;
	/* Column Info */
	private String g2CngUsr = null;
	/* Column Info */
	private String g3CngUsr = null;
	/* Column Info */
	private String flg = null;
	/* Column Info */
	private String dtlSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SpcMdlCustRevLaneHisVO() {}

	public SpcMdlCustRevLaneHisVO(String ibflag, String pagerows, String trdCd, String costYrwk, String verSeq, String modiSeq, String custCntCd, String custSeq, String scNo, String subTrdCd, String rlaneCd, String slsRgnOfcCd, String rfaNo, String slsRhqCd, String ctrtOfcCd, String custCtrlCd, String custAdjQty, String subTrdAdjQty, String rlaneAdjQty, String spcCtrlMdlRmk, String cngItmNm, String oldSlsRgnOfcCd, String oldRlaneCd, String oldCustAdjQty, String oldSubTrdAdjQty, String oldRlaneAdjQty, String oldSpcCtrlMdlRmk, String modiUsrId, String modiGdt, String mdlAddFlg, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt, String g1CngUsr, String g2CngUsr, String g3CngUsr, String flg, String dtlSeq) {
		this.deltFlg = deltFlg;
		this.custAdjQty = custAdjQty;
		this.creDt = creDt;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.oldRlaneCd = oldRlaneCd;
		this.oldCustAdjQty = oldCustAdjQty;
		this.modiUsrId = modiUsrId;
		this.custCtrlCd = custCtrlCd;
		this.pagerows = pagerows;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.rlaneAdjQty = rlaneAdjQty;
		this.scNo = scNo;
		this.ctrtOfcCd = ctrtOfcCd;
		this.updUsrId = updUsrId;
		this.custCntCd = custCntCd;
		this.updDt = updDt;
		this.modiSeq = modiSeq;
		this.modiGdt = modiGdt;
		this.spcCtrlMdlRmk = spcCtrlMdlRmk;
		this.cngItmNm = cngItmNm;
		this.custSeq = custSeq;
		this.slsRhqCd = slsRhqCd;
		this.mdlAddFlg = mdlAddFlg;
		this.verSeq = verSeq;
		this.oldSlsRgnOfcCd = oldSlsRgnOfcCd;
		this.oldSubTrdAdjQty = oldSubTrdAdjQty;
		this.creUsrId = creUsrId;
		this.subTrdAdjQty = subTrdAdjQty;
		this.oldSpcCtrlMdlRmk = oldSpcCtrlMdlRmk;
		this.oldRlaneAdjQty = oldRlaneAdjQty;
		this.slsRgnOfcCd = slsRgnOfcCd;
		this.subTrdCd = subTrdCd;
		this.costYrwk = costYrwk;
		this.g1CngUsr = g1CngUsr;
		this.g2CngUsr = g2CngUsr;
		this.g3CngUsr = g3CngUsr;
		this.flg = flg;
		this.dtlSeq = dtlSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cust_adj_qty", getCustAdjQty());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("old_rlane_cd", getOldRlaneCd());
		this.hashColumns.put("old_cust_adj_qty", getOldCustAdjQty());
		this.hashColumns.put("modi_usr_id", getModiUsrId());
		this.hashColumns.put("cust_ctrl_cd", getCustCtrlCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rlane_adj_qty", getRlaneAdjQty());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("modi_seq", getModiSeq());
		this.hashColumns.put("modi_gdt", getModiGdt());
		this.hashColumns.put("spc_ctrl_mdl_rmk", getSpcCtrlMdlRmk());
		this.hashColumns.put("cng_itm_nm", getCngItmNm());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("sls_rhq_cd", getSlsRhqCd());
		this.hashColumns.put("mdl_add_flg", getMdlAddFlg());
		this.hashColumns.put("ver_seq", getVerSeq());
		this.hashColumns.put("old_sls_rgn_ofc_cd", getOldSlsRgnOfcCd());
		this.hashColumns.put("old_sub_trd_adj_qty", getOldSubTrdAdjQty());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("sub_trd_adj_qty", getSubTrdAdjQty());
		this.hashColumns.put("old_spc_ctrl_mdl_rmk", getOldSpcCtrlMdlRmk());
		this.hashColumns.put("old_rlane_adj_qty", getOldRlaneAdjQty());
		this.hashColumns.put("sls_rgn_ofc_cd", getSlsRgnOfcCd());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("cost_yrwk", getCostYrwk());
		this.hashColumns.put("g1_cng_usr", getG1CngUsr());
		this.hashColumns.put("g2_cng_usr", getG2CngUsr());
		this.hashColumns.put("g3_cng_usr", getG3CngUsr());
		this.hashColumns.put("flg", getFlg());
		this.hashColumns.put("dtl_seq", getDtlSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cust_adj_qty", "custAdjQty");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("old_rlane_cd", "oldRlaneCd");
		this.hashFields.put("old_cust_adj_qty", "oldCustAdjQty");
		this.hashFields.put("modi_usr_id", "modiUsrId");
		this.hashFields.put("cust_ctrl_cd", "custCtrlCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rlane_adj_qty", "rlaneAdjQty");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("modi_seq", "modiSeq");
		this.hashFields.put("modi_gdt", "modiGdt");
		this.hashFields.put("spc_ctrl_mdl_rmk", "spcCtrlMdlRmk");
		this.hashFields.put("cng_itm_nm", "cngItmNm");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("sls_rhq_cd", "slsRhqCd");
		this.hashFields.put("mdl_add_flg", "mdlAddFlg");
		this.hashFields.put("ver_seq", "verSeq");
		this.hashFields.put("old_sls_rgn_ofc_cd", "oldSlsRgnOfcCd");
		this.hashFields.put("old_sub_trd_adj_qty", "oldSubTrdAdjQty");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("sub_trd_adj_qty", "subTrdAdjQty");
		this.hashFields.put("old_spc_ctrl_mdl_rmk", "oldSpcCtrlMdlRmk");
		this.hashFields.put("old_rlane_adj_qty", "oldRlaneAdjQty");
		this.hashFields.put("sls_rgn_ofc_cd", "slsRgnOfcCd");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("cost_yrwk", "costYrwk");
		this.hashFields.put("g1_cng_usr", "g1CngUsr");
		this.hashFields.put("g2_cng_usr", "g2CngUsr");
		this.hashFields.put("g3_cng_usr", "g3CngUsr");
		this.hashFields.put("flg", "flg");
		this.hashFields.put("dtl_seq", "dtlSeq");
		return this.hashFields;
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
	 * @return custAdjQty
	 */
	public String getCustAdjQty() {
		return this.custAdjQty;
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
	 * @return oldRlaneCd
	 */
	public String getOldRlaneCd() {
		return this.oldRlaneCd;
	}
	
	/**
	 * Column Info
	 * @return oldCustAdjQty
	 */
	public String getOldCustAdjQty() {
		return this.oldCustAdjQty;
	}
	
	/**
	 * Column Info
	 * @return modiUsrId
	 */
	public String getModiUsrId() {
		return this.modiUsrId;
	}
	
	/**
	 * Column Info
	 * @return custCtrlCd
	 */
	public String getCustCtrlCd() {
		return this.custCtrlCd;
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
	 * @return rlaneAdjQty
	 */
	public String getRlaneAdjQty() {
		return this.rlaneAdjQty;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return modiSeq
	 */
	public String getModiSeq() {
		return this.modiSeq;
	}
	
	/**
	 * Column Info
	 * @return modiGdt
	 */
	public String getModiGdt() {
		return this.modiGdt;
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
	 * @return cngItmNm
	 */
	public String getCngItmNm() {
		return this.cngItmNm;
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
	 * @return slsRhqCd
	 */
	public String getSlsRhqCd() {
		return this.slsRhqCd;
	}
	
	/**
	 * Column Info
	 * @return mdlAddFlg
	 */
	public String getMdlAddFlg() {
		return this.mdlAddFlg;
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
	 * @return oldSlsRgnOfcCd
	 */
	public String getOldSlsRgnOfcCd() {
		return this.oldSlsRgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @return oldSubTrdAdjQty
	 */
	public String getOldSubTrdAdjQty() {
		return this.oldSubTrdAdjQty;
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
	 * @return subTrdAdjQty
	 */
	public String getSubTrdAdjQty() {
		return this.subTrdAdjQty;
	}
	
	/**
	 * Column Info
	 * @return oldSpcCtrlMdlRmk
	 */
	public String getOldSpcCtrlMdlRmk() {
		return this.oldSpcCtrlMdlRmk;
	}
	
	/**
	 * Column Info
	 * @return oldRlaneAdjQty
	 */
	public String getOldRlaneAdjQty() {
		return this.oldRlaneAdjQty;
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
	 * @return g1CngUsr
	 */
	public String getG1CngUsr() {
		return this.g1CngUsr;
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
	 * @return g3CngUsr
	 */
	public String getG3CngUsr() {
		return this.g3CngUsr;
	}
	
	/**
	 * Column Info
	 * @return flg
	 */
	public String getFlg() {
		return this.flg;
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
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param oldRlaneCd
	 */
	public void setOldRlaneCd(String oldRlaneCd) {
		this.oldRlaneCd = oldRlaneCd;
	}
	
	/**
	 * Column Info
	 * @param oldCustAdjQty
	 */
	public void setOldCustAdjQty(String oldCustAdjQty) {
		this.oldCustAdjQty = oldCustAdjQty;
	}
	
	/**
	 * Column Info
	 * @param modiUsrId
	 */
	public void setModiUsrId(String modiUsrId) {
		this.modiUsrId = modiUsrId;
	}
	
	/**
	 * Column Info
	 * @param custCtrlCd
	 */
	public void setCustCtrlCd(String custCtrlCd) {
		this.custCtrlCd = custCtrlCd;
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
	 * @param rlaneAdjQty
	 */
	public void setRlaneAdjQty(String rlaneAdjQty) {
		this.rlaneAdjQty = rlaneAdjQty;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param modiSeq
	 */
	public void setModiSeq(String modiSeq) {
		this.modiSeq = modiSeq;
	}
	
	/**
	 * Column Info
	 * @param modiGdt
	 */
	public void setModiGdt(String modiGdt) {
		this.modiGdt = modiGdt;
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
	 * @param cngItmNm
	 */
	public void setCngItmNm(String cngItmNm) {
		this.cngItmNm = cngItmNm;
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
	 * @param slsRhqCd
	 */
	public void setSlsRhqCd(String slsRhqCd) {
		this.slsRhqCd = slsRhqCd;
	}
	
	/**
	 * Column Info
	 * @param mdlAddFlg
	 */
	public void setMdlAddFlg(String mdlAddFlg) {
		this.mdlAddFlg = mdlAddFlg;
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
	 * @param oldSlsRgnOfcCd
	 */
	public void setOldSlsRgnOfcCd(String oldSlsRgnOfcCd) {
		this.oldSlsRgnOfcCd = oldSlsRgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @param oldSubTrdAdjQty
	 */
	public void setOldSubTrdAdjQty(String oldSubTrdAdjQty) {
		this.oldSubTrdAdjQty = oldSubTrdAdjQty;
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
	 * @param subTrdAdjQty
	 */
	public void setSubTrdAdjQty(String subTrdAdjQty) {
		this.subTrdAdjQty = subTrdAdjQty;
	}
	
	/**
	 * Column Info
	 * @param oldSpcCtrlMdlRmk
	 */
	public void setOldSpcCtrlMdlRmk(String oldSpcCtrlMdlRmk) {
		this.oldSpcCtrlMdlRmk = oldSpcCtrlMdlRmk;
	}
	
	/**
	 * Column Info
	 * @param oldRlaneAdjQty
	 */
	public void setOldRlaneAdjQty(String oldRlaneAdjQty) {
		this.oldRlaneAdjQty = oldRlaneAdjQty;
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
	 * @param g1CngUsr
	 */
	public void setG1CngUsr(String g1CngUsr) {
		this.g1CngUsr = g1CngUsr;
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
	 * @param g3CngUsr
	 */
	public void setG3CngUsr(String g3CngUsr) {
		this.g3CngUsr = g3CngUsr;
	}
	
	/**
	 * Column Info
	 * @param flg
	 */
	public void setFlg(String flg) {
		this.flg = flg;
	}
	
	/**
	 * Column Info
	 * @param dtlSeq
	 */
	public void setDtlSeq(String dtlSeq) {
		this.dtlSeq = dtlSeq;
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
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCustAdjQty(JSPUtil.getParameter(request, prefix + "cust_adj_qty", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setOldRlaneCd(JSPUtil.getParameter(request, prefix + "old_rlane_cd", ""));
		setOldCustAdjQty(JSPUtil.getParameter(request, prefix + "old_cust_adj_qty", ""));
		setModiUsrId(JSPUtil.getParameter(request, prefix + "modi_usr_id", ""));
		setCustCtrlCd(JSPUtil.getParameter(request, prefix + "cust_ctrl_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRlaneAdjQty(JSPUtil.getParameter(request, prefix + "rlane_adj_qty", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setModiSeq(JSPUtil.getParameter(request, prefix + "modi_seq", ""));
		setModiGdt(JSPUtil.getParameter(request, prefix + "modi_gdt", ""));
		setSpcCtrlMdlRmk(JSPUtil.getParameter(request, prefix + "spc_ctrl_mdl_rmk", ""));
		setCngItmNm(JSPUtil.getParameter(request, prefix + "cng_itm_nm", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setSlsRhqCd(JSPUtil.getParameter(request, prefix + "sls_rhq_cd", ""));
		setMdlAddFlg(JSPUtil.getParameter(request, prefix + "mdl_add_flg", ""));
		setVerSeq(JSPUtil.getParameter(request, prefix + "ver_seq", ""));
		setOldSlsRgnOfcCd(JSPUtil.getParameter(request, prefix + "old_sls_rgn_ofc_cd", ""));
		setOldSubTrdAdjQty(JSPUtil.getParameter(request, prefix + "old_sub_trd_adj_qty", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSubTrdAdjQty(JSPUtil.getParameter(request, prefix + "sub_trd_adj_qty", ""));
		setOldSpcCtrlMdlRmk(JSPUtil.getParameter(request, prefix + "old_spc_ctrl_mdl_rmk", ""));
		setOldRlaneAdjQty(JSPUtil.getParameter(request, prefix + "old_rlane_adj_qty", ""));
		setSlsRgnOfcCd(JSPUtil.getParameter(request, prefix + "sls_rgn_ofc_cd", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setCostYrwk(JSPUtil.getParameter(request, prefix + "cost_yrwk", ""));
		setG1CngUsr(JSPUtil.getParameter(request, prefix + "g1_cng_usr", ""));
		setG2CngUsr(JSPUtil.getParameter(request, prefix + "g2_cng_usr", ""));
		setG3CngUsr(JSPUtil.getParameter(request, prefix + "g3_cng_usr", ""));
		setFlg(JSPUtil.getParameter(request, prefix + "flg", ""));
		setDtlSeq(JSPUtil.getParameter(request, prefix + "dtl_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SpcMdlCustRevLaneHisVO[]
	 */
	public SpcMdlCustRevLaneHisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SpcMdlCustRevLaneHisVO[]
	 */
	public SpcMdlCustRevLaneHisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SpcMdlCustRevLaneHisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] custAdjQty = (JSPUtil.getParameter(request, prefix	+ "cust_adj_qty", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] oldRlaneCd = (JSPUtil.getParameter(request, prefix	+ "old_rlane_cd", length));
			String[] oldCustAdjQty = (JSPUtil.getParameter(request, prefix	+ "old_cust_adj_qty", length));
			String[] modiUsrId = (JSPUtil.getParameter(request, prefix	+ "modi_usr_id", length));
			String[] custCtrlCd = (JSPUtil.getParameter(request, prefix	+ "cust_ctrl_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rlaneAdjQty = (JSPUtil.getParameter(request, prefix	+ "rlane_adj_qty", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] modiSeq = (JSPUtil.getParameter(request, prefix	+ "modi_seq", length));
			String[] modiGdt = (JSPUtil.getParameter(request, prefix	+ "modi_gdt", length));
			String[] spcCtrlMdlRmk = (JSPUtil.getParameter(request, prefix	+ "spc_ctrl_mdl_rmk", length));
			String[] cngItmNm = (JSPUtil.getParameter(request, prefix	+ "cng_itm_nm", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] slsRhqCd = (JSPUtil.getParameter(request, prefix	+ "sls_rhq_cd", length));
			String[] mdlAddFlg = (JSPUtil.getParameter(request, prefix	+ "mdl_add_flg", length));
			String[] verSeq = (JSPUtil.getParameter(request, prefix	+ "ver_seq", length));
			String[] oldSlsRgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "old_sls_rgn_ofc_cd", length));
			String[] oldSubTrdAdjQty = (JSPUtil.getParameter(request, prefix	+ "old_sub_trd_adj_qty", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] subTrdAdjQty = (JSPUtil.getParameter(request, prefix	+ "sub_trd_adj_qty", length));
			String[] oldSpcCtrlMdlRmk = (JSPUtil.getParameter(request, prefix	+ "old_spc_ctrl_mdl_rmk", length));
			String[] oldRlaneAdjQty = (JSPUtil.getParameter(request, prefix	+ "old_rlane_adj_qty", length));
			String[] slsRgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_rgn_ofc_cd", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] costYrwk = (JSPUtil.getParameter(request, prefix	+ "cost_yrwk", length));
			String[] g1CngUsr = (JSPUtil.getParameter(request, prefix	+ "g1_cng_usr", length));
			String[] g2CngUsr = (JSPUtil.getParameter(request, prefix	+ "g2_cng_usr", length));
			String[] g3CngUsr = (JSPUtil.getParameter(request, prefix	+ "g3_cng_usr", length));
			String[] flg = (JSPUtil.getParameter(request, prefix	+ "flg", length));
			String[] dtlSeq = (JSPUtil.getParameter(request, prefix	+ "dtl_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new SpcMdlCustRevLaneHisVO();
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (custAdjQty[i] != null)
					model.setCustAdjQty(custAdjQty[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (oldRlaneCd[i] != null)
					model.setOldRlaneCd(oldRlaneCd[i]);
				if (oldCustAdjQty[i] != null)
					model.setOldCustAdjQty(oldCustAdjQty[i]);
				if (modiUsrId[i] != null)
					model.setModiUsrId(modiUsrId[i]);
				if (custCtrlCd[i] != null)
					model.setCustCtrlCd(custCtrlCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rlaneAdjQty[i] != null)
					model.setRlaneAdjQty(rlaneAdjQty[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (modiSeq[i] != null)
					model.setModiSeq(modiSeq[i]);
				if (modiGdt[i] != null)
					model.setModiGdt(modiGdt[i]);
				if (spcCtrlMdlRmk[i] != null)
					model.setSpcCtrlMdlRmk(spcCtrlMdlRmk[i]);
				if (cngItmNm[i] != null)
					model.setCngItmNm(cngItmNm[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (slsRhqCd[i] != null)
					model.setSlsRhqCd(slsRhqCd[i]);
				if (mdlAddFlg[i] != null)
					model.setMdlAddFlg(mdlAddFlg[i]);
				if (verSeq[i] != null)
					model.setVerSeq(verSeq[i]);
				if (oldSlsRgnOfcCd[i] != null)
					model.setOldSlsRgnOfcCd(oldSlsRgnOfcCd[i]);
				if (oldSubTrdAdjQty[i] != null)
					model.setOldSubTrdAdjQty(oldSubTrdAdjQty[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (subTrdAdjQty[i] != null)
					model.setSubTrdAdjQty(subTrdAdjQty[i]);
				if (oldSpcCtrlMdlRmk[i] != null)
					model.setOldSpcCtrlMdlRmk(oldSpcCtrlMdlRmk[i]);
				if (oldRlaneAdjQty[i] != null)
					model.setOldRlaneAdjQty(oldRlaneAdjQty[i]);
				if (slsRgnOfcCd[i] != null)
					model.setSlsRgnOfcCd(slsRgnOfcCd[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (costYrwk[i] != null)
					model.setCostYrwk(costYrwk[i]);
				if (g1CngUsr[i] != null)
					model.setG1CngUsr(g1CngUsr[i]);
				if (g2CngUsr[i] != null)
					model.setG2CngUsr(g2CngUsr[i]);
				if (g3CngUsr[i] != null)
					model.setG3CngUsr(g3CngUsr[i]);
				if (flg[i] != null)
					model.setFlg(flg[i]);
				if (dtlSeq[i] != null)
					model.setDtlSeq(dtlSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSpcMdlCustRevLaneHisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SpcMdlCustRevLaneHisVO[]
	 */
	public SpcMdlCustRevLaneHisVO[] getSpcMdlCustRevLaneHisVOs(){
		SpcMdlCustRevLaneHisVO[] vos = (SpcMdlCustRevLaneHisVO[])models.toArray(new SpcMdlCustRevLaneHisVO[models.size()]);
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
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAdjQty = this.custAdjQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldRlaneCd = this.oldRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldCustAdjQty = this.oldCustAdjQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiUsrId = this.modiUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCtrlCd = this.custCtrlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneAdjQty = this.rlaneAdjQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiSeq = this.modiSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiGdt = this.modiGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spcCtrlMdlRmk = this.spcCtrlMdlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cngItmNm = this.cngItmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRhqCd = this.slsRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdlAddFlg = this.mdlAddFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.verSeq = this.verSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldSlsRgnOfcCd = this.oldSlsRgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldSubTrdAdjQty = this.oldSubTrdAdjQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdAdjQty = this.subTrdAdjQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldSpcCtrlMdlRmk = this.oldSpcCtrlMdlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldRlaneAdjQty = this.oldRlaneAdjQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRgnOfcCd = this.slsRgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrwk = this.costYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g1CngUsr = this.g1CngUsr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g2CngUsr = this.g2CngUsr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g3CngUsr = this.g3CngUsr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flg = this.flg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlSeq = this.dtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
