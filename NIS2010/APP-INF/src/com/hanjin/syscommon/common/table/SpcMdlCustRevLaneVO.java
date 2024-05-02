/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpcMdlCustRevLaneVO.java
*@FileTitle : SpcMdlCustRevLaneVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.27
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.02.27 진마리아 
* 1.0 Creation
* 2013.02.27 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진 
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

public class SpcMdlCustRevLaneVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SpcMdlCustRevLaneVO> models = new ArrayList<SpcMdlCustRevLaneVO>();
	
	/* Column Info */
	private String subTrdBkgQty = null;
	/* Column Info */
	private String spcCtrlMdlMnlRmk = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String custAdjQty = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String spcCtrlMdlMnlCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
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
	private String rlaneBkgQty = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String custBkgQty = null;
	/* Column Info */
	private String dtlSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String slsAqCd = null;
	/* Column Info */
	private String spcCtrlMdlRmk = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String slsRhqCd = null;
	/* Column Info */
	private String verSeq = null;
	/* Column Info */
	private String rlaneCmpbAmt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String subTrdAdjQty = null;
	/* Column Info */
	private String subTrdCmpbAmt = null;
	/* Column Info */
	private String slsRgnOfcCd = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String costYrwk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SpcMdlCustRevLaneVO() {}

	public SpcMdlCustRevLaneVO(String ibflag, String pagerows, String costYrwk, String verSeq, String trdCd, String subTrdCd, String rlaneCd, String slsRgnOfcCd, String custCntCd, String custSeq, String dtlSeq, String scNo, String rfaNo, String custCtrlCd, String slsRhqCd, String slsAqCd, String ctrtOfcCd, String custBkgQty, String subTrdBkgQty, String rlaneBkgQty, String custAdjQty, String subTrdAdjQty, String rlaneAdjQty, String subTrdCmpbAmt, String rlaneCmpbAmt, String spcCtrlMdlRmk, String spcCtrlMdlMnlCd, String spcCtrlMdlMnlRmk, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.subTrdBkgQty = subTrdBkgQty;
		this.spcCtrlMdlMnlRmk = spcCtrlMdlMnlRmk;
		this.deltFlg = deltFlg;
		this.custAdjQty = custAdjQty;
		this.creDt = creDt;
		this.spcCtrlMdlMnlCd = spcCtrlMdlMnlCd;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.custCtrlCd = custCtrlCd;
		this.pagerows = pagerows;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.rlaneAdjQty = rlaneAdjQty;
		this.rlaneBkgQty = rlaneBkgQty;
		this.scNo = scNo;
		this.ctrtOfcCd = ctrtOfcCd;
		this.custBkgQty = custBkgQty;
		this.dtlSeq = dtlSeq;
		this.updUsrId = updUsrId;
		this.custCntCd = custCntCd;
		this.updDt = updDt;
		this.slsAqCd = slsAqCd;
		this.spcCtrlMdlRmk = spcCtrlMdlRmk;
		this.custSeq = custSeq;
		this.slsRhqCd = slsRhqCd;
		this.verSeq = verSeq;
		this.rlaneCmpbAmt = rlaneCmpbAmt;
		this.creUsrId = creUsrId;
		this.subTrdAdjQty = subTrdAdjQty;
		this.subTrdCmpbAmt = subTrdCmpbAmt;
		this.slsRgnOfcCd = slsRgnOfcCd;
		this.subTrdCd = subTrdCd;
		this.costYrwk = costYrwk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sub_trd_bkg_qty", getSubTrdBkgQty());
		this.hashColumns.put("spc_ctrl_mdl_mnl_rmk", getSpcCtrlMdlMnlRmk());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cust_adj_qty", getCustAdjQty());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("spc_ctrl_mdl_mnl_cd", getSpcCtrlMdlMnlCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("cust_ctrl_cd", getCustCtrlCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rlane_adj_qty", getRlaneAdjQty());
		this.hashColumns.put("rlane_bkg_qty", getRlaneBkgQty());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("cust_bkg_qty", getCustBkgQty());
		this.hashColumns.put("dtl_seq", getDtlSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("sls_aq_cd", getSlsAqCd());
		this.hashColumns.put("spc_ctrl_mdl_rmk", getSpcCtrlMdlRmk());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("sls_rhq_cd", getSlsRhqCd());
		this.hashColumns.put("ver_seq", getVerSeq());
		this.hashColumns.put("rlane_cmpb_amt", getRlaneCmpbAmt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("sub_trd_adj_qty", getSubTrdAdjQty());
		this.hashColumns.put("sub_trd_cmpb_amt", getSubTrdCmpbAmt());
		this.hashColumns.put("sls_rgn_ofc_cd", getSlsRgnOfcCd());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("cost_yrwk", getCostYrwk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sub_trd_bkg_qty", "subTrdBkgQty");
		this.hashFields.put("spc_ctrl_mdl_mnl_rmk", "spcCtrlMdlMnlRmk");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cust_adj_qty", "custAdjQty");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("spc_ctrl_mdl_mnl_cd", "spcCtrlMdlMnlCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("cust_ctrl_cd", "custCtrlCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rlane_adj_qty", "rlaneAdjQty");
		this.hashFields.put("rlane_bkg_qty", "rlaneBkgQty");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("cust_bkg_qty", "custBkgQty");
		this.hashFields.put("dtl_seq", "dtlSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("sls_aq_cd", "slsAqCd");
		this.hashFields.put("spc_ctrl_mdl_rmk", "spcCtrlMdlRmk");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("sls_rhq_cd", "slsRhqCd");
		this.hashFields.put("ver_seq", "verSeq");
		this.hashFields.put("rlane_cmpb_amt", "rlaneCmpbAmt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("sub_trd_adj_qty", "subTrdAdjQty");
		this.hashFields.put("sub_trd_cmpb_amt", "subTrdCmpbAmt");
		this.hashFields.put("sls_rgn_ofc_cd", "slsRgnOfcCd");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("cost_yrwk", "costYrwk");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return subTrdBkgQty
	 */
	public String getSubTrdBkgQty() {
		return this.subTrdBkgQty;
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
	 * @return spcCtrlMdlMnlCd
	 */
	public String getSpcCtrlMdlMnlCd() {
		return this.spcCtrlMdlMnlCd;
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
	 * @return rlaneBkgQty
	 */
	public String getRlaneBkgQty() {
		return this.rlaneBkgQty;
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
	 * @return custBkgQty
	 */
	public String getCustBkgQty() {
		return this.custBkgQty;
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
	 * @return slsAqCd
	 */
	public String getSlsAqCd() {
		return this.slsAqCd;
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
	 * @return slsRhqCd
	 */
	public String getSlsRhqCd() {
		return this.slsRhqCd;
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
	 * @return rlaneCmpbAmt
	 */
	public String getRlaneCmpbAmt() {
		return this.rlaneCmpbAmt;
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
	 * @return subTrdCmpbAmt
	 */
	public String getSubTrdCmpbAmt() {
		return this.subTrdCmpbAmt;
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
	 * @param subTrdBkgQty
	 */
	public void setSubTrdBkgQty(String subTrdBkgQty) {
		this.subTrdBkgQty = subTrdBkgQty;
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
	 * @param spcCtrlMdlMnlCd
	 */
	public void setSpcCtrlMdlMnlCd(String spcCtrlMdlMnlCd) {
		this.spcCtrlMdlMnlCd = spcCtrlMdlMnlCd;
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
	 * @param rlaneBkgQty
	 */
	public void setRlaneBkgQty(String rlaneBkgQty) {
		this.rlaneBkgQty = rlaneBkgQty;
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
	 * @param custBkgQty
	 */
	public void setCustBkgQty(String custBkgQty) {
		this.custBkgQty = custBkgQty;
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
	 * @param slsAqCd
	 */
	public void setSlsAqCd(String slsAqCd) {
		this.slsAqCd = slsAqCd;
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
	 * @param slsRhqCd
	 */
	public void setSlsRhqCd(String slsRhqCd) {
		this.slsRhqCd = slsRhqCd;
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
	 * @param rlaneCmpbAmt
	 */
	public void setRlaneCmpbAmt(String rlaneCmpbAmt) {
		this.rlaneCmpbAmt = rlaneCmpbAmt;
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
	 * @param subTrdCmpbAmt
	 */
	public void setSubTrdCmpbAmt(String subTrdCmpbAmt) {
		this.subTrdCmpbAmt = subTrdCmpbAmt;
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
		setSubTrdBkgQty(JSPUtil.getParameter(request, prefix + "sub_trd_bkg_qty", ""));
		setSpcCtrlMdlMnlRmk(JSPUtil.getParameter(request, prefix + "spc_ctrl_mdl_mnl_rmk", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCustAdjQty(JSPUtil.getParameter(request, prefix + "cust_adj_qty", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSpcCtrlMdlMnlCd(JSPUtil.getParameter(request, prefix + "spc_ctrl_mdl_mnl_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setCustCtrlCd(JSPUtil.getParameter(request, prefix + "cust_ctrl_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRlaneAdjQty(JSPUtil.getParameter(request, prefix + "rlane_adj_qty", ""));
		setRlaneBkgQty(JSPUtil.getParameter(request, prefix + "rlane_bkg_qty", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setCustBkgQty(JSPUtil.getParameter(request, prefix + "cust_bkg_qty", ""));
		setDtlSeq(JSPUtil.getParameter(request, prefix + "dtl_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setSlsAqCd(JSPUtil.getParameter(request, prefix + "sls_aq_cd", ""));
		setSpcCtrlMdlRmk(JSPUtil.getParameter(request, prefix + "spc_ctrl_mdl_rmk", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setSlsRhqCd(JSPUtil.getParameter(request, prefix + "sls_rhq_cd", ""));
		setVerSeq(JSPUtil.getParameter(request, prefix + "ver_seq", ""));
		setRlaneCmpbAmt(JSPUtil.getParameter(request, prefix + "rlane_cmpb_amt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSubTrdAdjQty(JSPUtil.getParameter(request, prefix + "sub_trd_adj_qty", ""));
		setSubTrdCmpbAmt(JSPUtil.getParameter(request, prefix + "sub_trd_cmpb_amt", ""));
		setSlsRgnOfcCd(JSPUtil.getParameter(request, prefix + "sls_rgn_ofc_cd", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setCostYrwk(JSPUtil.getParameter(request, prefix + "cost_yrwk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SpcMdlCustRevLaneVO[]
	 */
	public SpcMdlCustRevLaneVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SpcMdlCustRevLaneVO[]
	 */
	public SpcMdlCustRevLaneVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SpcMdlCustRevLaneVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] subTrdBkgQty = (JSPUtil.getParameter(request, prefix	+ "sub_trd_bkg_qty", length));
			String[] spcCtrlMdlMnlRmk = (JSPUtil.getParameter(request, prefix	+ "spc_ctrl_mdl_mnl_rmk", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] custAdjQty = (JSPUtil.getParameter(request, prefix	+ "cust_adj_qty", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] spcCtrlMdlMnlCd = (JSPUtil.getParameter(request, prefix	+ "spc_ctrl_mdl_mnl_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] custCtrlCd = (JSPUtil.getParameter(request, prefix	+ "cust_ctrl_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rlaneAdjQty = (JSPUtil.getParameter(request, prefix	+ "rlane_adj_qty", length));
			String[] rlaneBkgQty = (JSPUtil.getParameter(request, prefix	+ "rlane_bkg_qty", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] custBkgQty = (JSPUtil.getParameter(request, prefix	+ "cust_bkg_qty", length));
			String[] dtlSeq = (JSPUtil.getParameter(request, prefix	+ "dtl_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] slsAqCd = (JSPUtil.getParameter(request, prefix	+ "sls_aq_cd", length));
			String[] spcCtrlMdlRmk = (JSPUtil.getParameter(request, prefix	+ "spc_ctrl_mdl_rmk", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] slsRhqCd = (JSPUtil.getParameter(request, prefix	+ "sls_rhq_cd", length));
			String[] verSeq = (JSPUtil.getParameter(request, prefix	+ "ver_seq", length));
			String[] rlaneCmpbAmt = (JSPUtil.getParameter(request, prefix	+ "rlane_cmpb_amt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] subTrdAdjQty = (JSPUtil.getParameter(request, prefix	+ "sub_trd_adj_qty", length));
			String[] subTrdCmpbAmt = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cmpb_amt", length));
			String[] slsRgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_rgn_ofc_cd", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] costYrwk = (JSPUtil.getParameter(request, prefix	+ "cost_yrwk", length));
			
			for (int i = 0; i < length; i++) {
				model = new SpcMdlCustRevLaneVO();
				if (subTrdBkgQty[i] != null)
					model.setSubTrdBkgQty(subTrdBkgQty[i]);
				if (spcCtrlMdlMnlRmk[i] != null)
					model.setSpcCtrlMdlMnlRmk(spcCtrlMdlMnlRmk[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (custAdjQty[i] != null)
					model.setCustAdjQty(custAdjQty[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (spcCtrlMdlMnlCd[i] != null)
					model.setSpcCtrlMdlMnlCd(spcCtrlMdlMnlCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
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
				if (rlaneBkgQty[i] != null)
					model.setRlaneBkgQty(rlaneBkgQty[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (custBkgQty[i] != null)
					model.setCustBkgQty(custBkgQty[i]);
				if (dtlSeq[i] != null)
					model.setDtlSeq(dtlSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (slsAqCd[i] != null)
					model.setSlsAqCd(slsAqCd[i]);
				if (spcCtrlMdlRmk[i] != null)
					model.setSpcCtrlMdlRmk(spcCtrlMdlRmk[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (slsRhqCd[i] != null)
					model.setSlsRhqCd(slsRhqCd[i]);
				if (verSeq[i] != null)
					model.setVerSeq(verSeq[i]);
				if (rlaneCmpbAmt[i] != null)
					model.setRlaneCmpbAmt(rlaneCmpbAmt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (subTrdAdjQty[i] != null)
					model.setSubTrdAdjQty(subTrdAdjQty[i]);
				if (subTrdCmpbAmt[i] != null)
					model.setSubTrdCmpbAmt(subTrdCmpbAmt[i]);
				if (slsRgnOfcCd[i] != null)
					model.setSlsRgnOfcCd(slsRgnOfcCd[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (costYrwk[i] != null)
					model.setCostYrwk(costYrwk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSpcMdlCustRevLaneVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SpcMdlCustRevLaneVO[]
	 */
	public SpcMdlCustRevLaneVO[] getSpcMdlCustRevLaneVOs(){
		SpcMdlCustRevLaneVO[] vos = (SpcMdlCustRevLaneVO[])models.toArray(new SpcMdlCustRevLaneVO[models.size()]);
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
		this.subTrdBkgQty = this.subTrdBkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spcCtrlMdlMnlRmk = this.spcCtrlMdlMnlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAdjQty = this.custAdjQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spcCtrlMdlMnlCd = this.spcCtrlMdlMnlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCtrlCd = this.custCtrlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneAdjQty = this.rlaneAdjQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneBkgQty = this.rlaneBkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custBkgQty = this.custBkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlSeq = this.dtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsAqCd = this.slsAqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spcCtrlMdlRmk = this.spcCtrlMdlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRhqCd = this.slsRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.verSeq = this.verSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCmpbAmt = this.rlaneCmpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdAdjQty = this.subTrdAdjQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCmpbAmt = this.subTrdCmpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRgnOfcCd = this.slsRgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrwk = this.costYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
