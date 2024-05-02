/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SmpHisVO.java
*@FileTitle : SmpHisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.26
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.26  
* 1.0 Creation
* 2013.03.26 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2014.02.04 [CHM-201428383-01] RFA 로직 추가
=========================================================*/

package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo;

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

public class SmpHisVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SmpHisVO> models = new ArrayList<SmpHisVO>();
	
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String custAdjQty = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String oldCustAdjQty = null;
	/* Column Info */
	private String oldRlaneCd = null;
	/* Column Info */
	private String modiUsrId = null;
	/* Column Info */
	private String modiUsrNm = null;
	/* Column Info */
	private String custCtrlCd = null;
	/* Column Info */
	private String acctClss = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rlaneAdjQty = null;
	/* Column Info */
	private String custGrpNm = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String modiGdt = null;
	/* Column Info */
	private String cngItmNm = null;
	/* Column Info */
	private String spcCtrlMdlRmk = null;
	/* Column Info */
	private String oldSlsRhq = null;
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
	private String rfaNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SmpHisVO() {}

	public SmpHisVO(String ibflag, String pagerows, String modiGdt, String modiUsrId, String modiUsrNm, String verSeq, String cngItmNm, String mdlAddFlg, String acctClss, String custGrpNm, String custNm, String custCtrlCd, String scNo, String subTrdCd, String slsRhqCd, String custAdjQty, String slsRgnOfcCd, String subTrdAdjQty, String rlaneCd, String rlaneAdjQty, String spcCtrlMdlRmk, String oldSlsRhq, String oldCustAdjQty, String oldSlsRgnOfcCd, String oldSubTrdAdjQty, String oldRlaneCd, String oldRlaneAdjQty, String oldSpcCtrlMdlRmk, String rfaNo) {
		this.custNm = custNm;
		this.custAdjQty = custAdjQty;
		this.rlaneCd = rlaneCd;
		this.oldCustAdjQty = oldCustAdjQty;
		this.oldRlaneCd = oldRlaneCd;
		this.modiUsrId = modiUsrId;
		this.modiUsrNm = modiUsrNm;
		this.custCtrlCd = custCtrlCd;
		this.acctClss = acctClss;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.rlaneAdjQty = rlaneAdjQty;
		this.custGrpNm = custGrpNm;
		this.scNo = scNo;
		this.modiGdt = modiGdt;
		this.cngItmNm = cngItmNm;
		this.spcCtrlMdlRmk = spcCtrlMdlRmk;
		this.oldSlsRhq = oldSlsRhq;
		this.slsRhqCd = slsRhqCd;
		this.mdlAddFlg = mdlAddFlg;
		this.verSeq = verSeq;
		this.oldSlsRgnOfcCd = oldSlsRgnOfcCd;
		this.oldSubTrdAdjQty = oldSubTrdAdjQty;
		this.subTrdAdjQty = subTrdAdjQty;
		this.oldSpcCtrlMdlRmk = oldSpcCtrlMdlRmk;
		this.oldRlaneAdjQty = oldRlaneAdjQty;
		this.slsRgnOfcCd = slsRgnOfcCd;
		this.subTrdCd = subTrdCd;
		this.rfaNo = rfaNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("cust_adj_qty", getCustAdjQty());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("old_cust_adj_qty", getOldCustAdjQty());
		this.hashColumns.put("old_rlane_cd", getOldRlaneCd());
		this.hashColumns.put("modi_usr_id", getModiUsrId());
		this.hashColumns.put("modi_usr_nm", getModiUsrNm());
		this.hashColumns.put("cust_ctrl_cd", getCustCtrlCd());
		this.hashColumns.put("acct_clss", getAcctClss());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rlane_adj_qty", getRlaneAdjQty());
		this.hashColumns.put("cust_grp_nm", getCustGrpNm());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("modi_gdt", getModiGdt());
		this.hashColumns.put("cng_itm_nm", getCngItmNm());
		this.hashColumns.put("spc_ctrl_mdl_rmk", getSpcCtrlMdlRmk());
		this.hashColumns.put("old_sls_rhq", getOldSlsRhq());
		this.hashColumns.put("sls_rhq_cd", getSlsRhqCd());
		this.hashColumns.put("mdl_add_flg", getMdlAddFlg());
		this.hashColumns.put("ver_seq", getVerSeq());
		this.hashColumns.put("old_sls_rgn_ofc_cd", getOldSlsRgnOfcCd());
		this.hashColumns.put("old_sub_trd_adj_qty", getOldSubTrdAdjQty());
		this.hashColumns.put("sub_trd_adj_qty", getSubTrdAdjQty());
		this.hashColumns.put("old_spc_ctrl_mdl_rmk", getOldSpcCtrlMdlRmk());
		this.hashColumns.put("old_rlane_adj_qty", getOldRlaneAdjQty());
		this.hashColumns.put("sls_rgn_ofc_cd", getSlsRgnOfcCd());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("rfa_no", getRfaNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("cust_adj_qty", "custAdjQty");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("old_cust_adj_qty", "oldCustAdjQty");
		this.hashFields.put("old_rlane_cd", "oldRlaneCd");
		this.hashFields.put("modi_usr_id", "modiUsrId");
		this.hashFields.put("modi_usr_nm", "modiUsrNm");
		this.hashFields.put("cust_ctrl_cd", "custCtrlCd");
		this.hashFields.put("acct_clss", "acctClss");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rlane_adj_qty", "rlaneAdjQty");
		this.hashFields.put("cust_grp_nm", "custGrpNm");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("modi_gdt", "modiGdt");
		this.hashFields.put("cng_itm_nm", "cngItmNm");
		this.hashFields.put("spc_ctrl_mdl_rmk", "spcCtrlMdlRmk");
		this.hashFields.put("old_sls_rhq", "oldSlsRhq");
		this.hashFields.put("sls_rhq_cd", "slsRhqCd");
		this.hashFields.put("mdl_add_flg", "mdlAddFlg");
		this.hashFields.put("ver_seq", "verSeq");
		this.hashFields.put("old_sls_rgn_ofc_cd", "oldSlsRgnOfcCd");
		this.hashFields.put("old_sub_trd_adj_qty", "oldSubTrdAdjQty");
		this.hashFields.put("sub_trd_adj_qty", "subTrdAdjQty");
		this.hashFields.put("old_spc_ctrl_mdl_rmk", "oldSpcCtrlMdlRmk");
		this.hashFields.put("old_rlane_adj_qty", "oldRlaneAdjQty");
		this.hashFields.put("sls_rgn_ofc_cd", "slsRgnOfcCd");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("rfa_no", "rfaNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
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
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
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
	 * @return oldRlaneCd
	 */
	public String getOldRlaneCd() {
		return this.oldRlaneCd;
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
	 * @return modiUsrNm
	 */
	public String getModiUsrNm() {
		return this.modiUsrNm;
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
	 * @return acctClss
	 */
	public String getAcctClss() {
		return this.acctClss;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return modiGdt
	 */
	public String getModiGdt() {
		return this.modiGdt;
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
	 * @return spcCtrlMdlRmk
	 */
	public String getSpcCtrlMdlRmk() {
		return this.spcCtrlMdlRmk;
	}
	
	/**
	 * Column Info
	 * @return oldSlsRhq
	 */
	public String getOldSlsRhq() {
		return this.oldSlsRhq;
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
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
	}
	

	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
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
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
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
	 * @param oldRlaneCd
	 */
	public void setOldRlaneCd(String oldRlaneCd) {
		this.oldRlaneCd = oldRlaneCd;
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
	 * @param modiUsrNm
	 */
	public void setModiUsrNm(String modiUsrNm) {
		this.modiUsrNm = modiUsrNm;
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
	 * @param acctClss
	 */
	public void setAcctClss(String acctClss) {
		this.acctClss = acctClss;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param modiGdt
	 */
	public void setModiGdt(String modiGdt) {
		this.modiGdt = modiGdt;
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
	 * @param spcCtrlMdlRmk
	 */
	public void setSpcCtrlMdlRmk(String spcCtrlMdlRmk) {
		this.spcCtrlMdlRmk = spcCtrlMdlRmk;
	}
	
	/**
	 * Column Info
	 * @param oldSlsRhq
	 */
	public void setOldSlsRhq(String oldSlsRhq) {
		this.oldSlsRhq = oldSlsRhq;
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
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
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
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setCustAdjQty(JSPUtil.getParameter(request, prefix + "cust_adj_qty", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setOldCustAdjQty(JSPUtil.getParameter(request, prefix + "old_cust_adj_qty", ""));
		setOldRlaneCd(JSPUtil.getParameter(request, prefix + "old_rlane_cd", ""));
		setModiUsrId(JSPUtil.getParameter(request, prefix + "modi_usr_id", ""));
		setModiUsrNm(JSPUtil.getParameter(request, prefix + "modi_usr_nm", ""));
		setCustCtrlCd(JSPUtil.getParameter(request, prefix + "cust_ctrl_cd", ""));
		setAcctClss(JSPUtil.getParameter(request, prefix + "acct_clss", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRlaneAdjQty(JSPUtil.getParameter(request, prefix + "rlane_adj_qty", ""));
		setCustGrpNm(JSPUtil.getParameter(request, prefix + "cust_grp_nm", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setModiGdt(JSPUtil.getParameter(request, prefix + "modi_gdt", ""));
		setCngItmNm(JSPUtil.getParameter(request, prefix + "cng_itm_nm", ""));
		setSpcCtrlMdlRmk(JSPUtil.getParameter(request, prefix + "spc_ctrl_mdl_rmk", ""));
		setOldSlsRhq(JSPUtil.getParameter(request, prefix + "old_sls_rhq", ""));
		setSlsRhqCd(JSPUtil.getParameter(request, prefix + "sls_rhq_cd", ""));
		setMdlAddFlg(JSPUtil.getParameter(request, prefix + "mdl_add_flg", ""));
		setVerSeq(JSPUtil.getParameter(request, prefix + "ver_seq", ""));
		setOldSlsRgnOfcCd(JSPUtil.getParameter(request, prefix + "old_sls_rgn_ofc_cd", ""));
		setOldSubTrdAdjQty(JSPUtil.getParameter(request, prefix + "old_sub_trd_adj_qty", ""));
		setSubTrdAdjQty(JSPUtil.getParameter(request, prefix + "sub_trd_adj_qty", ""));
		setOldSpcCtrlMdlRmk(JSPUtil.getParameter(request, prefix + "old_spc_ctrl_mdl_rmk", ""));
		setOldRlaneAdjQty(JSPUtil.getParameter(request, prefix + "old_rlane_adj_qty", ""));
		setSlsRgnOfcCd(JSPUtil.getParameter(request, prefix + "sls_rgn_ofc_cd", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SmpHisVO[]
	 */
	public SmpHisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SmpHisVO[]
	 */
	public SmpHisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SmpHisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] custAdjQty = (JSPUtil.getParameter(request, prefix	+ "cust_adj_qty", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] oldCustAdjQty = (JSPUtil.getParameter(request, prefix	+ "old_cust_adj_qty", length));
			String[] oldRlaneCd = (JSPUtil.getParameter(request, prefix	+ "old_rlane_cd", length));
			String[] modiUsrId = (JSPUtil.getParameter(request, prefix	+ "modi_usr_id", length));
			String[] modiUsrNm = (JSPUtil.getParameter(request, prefix	+ "modi_usr_nm", length));
			String[] custCtrlCd = (JSPUtil.getParameter(request, prefix	+ "cust_ctrl_cd", length));
			String[] acctClss = (JSPUtil.getParameter(request, prefix	+ "acct_clss", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rlaneAdjQty = (JSPUtil.getParameter(request, prefix	+ "rlane_adj_qty", length));
			String[] custGrpNm = (JSPUtil.getParameter(request, prefix	+ "cust_grp_nm", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] modiGdt = (JSPUtil.getParameter(request, prefix	+ "modi_gdt", length));
			String[] cngItmNm = (JSPUtil.getParameter(request, prefix	+ "cng_itm_nm", length));
			String[] spcCtrlMdlRmk = (JSPUtil.getParameter(request, prefix	+ "spc_ctrl_mdl_rmk", length));
			String[] oldSlsRhq = (JSPUtil.getParameter(request, prefix	+ "old_sls_rhq", length));
			String[] slsRhqCd = (JSPUtil.getParameter(request, prefix	+ "sls_rhq_cd", length));
			String[] mdlAddFlg = (JSPUtil.getParameter(request, prefix	+ "mdl_add_flg", length));
			String[] verSeq = (JSPUtil.getParameter(request, prefix	+ "ver_seq", length));
			String[] oldSlsRgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "old_sls_rgn_ofc_cd", length));
			String[] oldSubTrdAdjQty = (JSPUtil.getParameter(request, prefix	+ "old_sub_trd_adj_qty", length));
			String[] subTrdAdjQty = (JSPUtil.getParameter(request, prefix	+ "sub_trd_adj_qty", length));
			String[] oldSpcCtrlMdlRmk = (JSPUtil.getParameter(request, prefix	+ "old_spc_ctrl_mdl_rmk", length));
			String[] oldRlaneAdjQty = (JSPUtil.getParameter(request, prefix	+ "old_rlane_adj_qty", length));
			String[] slsRgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_rgn_ofc_cd", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SmpHisVO();
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (custAdjQty[i] != null)
					model.setCustAdjQty(custAdjQty[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (oldCustAdjQty[i] != null)
					model.setOldCustAdjQty(oldCustAdjQty[i]);
				if (oldRlaneCd[i] != null)
					model.setOldRlaneCd(oldRlaneCd[i]);
				if (modiUsrId[i] != null)
					model.setModiUsrId(modiUsrId[i]);
				if (modiUsrNm[i] != null)
					model.setModiUsrNm(modiUsrNm[i]);
				if (custCtrlCd[i] != null)
					model.setCustCtrlCd(custCtrlCd[i]);
				if (acctClss[i] != null)
					model.setAcctClss(acctClss[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rlaneAdjQty[i] != null)
					model.setRlaneAdjQty(rlaneAdjQty[i]);
				if (custGrpNm[i] != null)
					model.setCustGrpNm(custGrpNm[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (modiGdt[i] != null)
					model.setModiGdt(modiGdt[i]);
				if (cngItmNm[i] != null)
					model.setCngItmNm(cngItmNm[i]);
				if (spcCtrlMdlRmk[i] != null)
					model.setSpcCtrlMdlRmk(spcCtrlMdlRmk[i]);
				if (oldSlsRhq[i] != null)
					model.setOldSlsRhq(oldSlsRhq[i]);
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
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSmpHisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SmpHisVO[]
	 */
	public SmpHisVO[] getSmpHisVOs(){
		SmpHisVO[] vos = (SmpHisVO[])models.toArray(new SmpHisVO[models.size()]);
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
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAdjQty = this.custAdjQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldCustAdjQty = this.oldCustAdjQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldRlaneCd = this.oldRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiUsrId = this.modiUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiUsrNm = this.modiUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCtrlCd = this.custCtrlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctClss = this.acctClss .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneAdjQty = this.rlaneAdjQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custGrpNm = this.custGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiGdt = this.modiGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cngItmNm = this.cngItmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spcCtrlMdlRmk = this.spcCtrlMdlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldSlsRhq = this.oldSlsRhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRhqCd = this.slsRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdlAddFlg = this.mdlAddFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.verSeq = this.verSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldSlsRgnOfcCd = this.oldSlsRgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldSubTrdAdjQty = this.oldSubTrdAdjQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdAdjQty = this.subTrdAdjQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldSpcCtrlMdlRmk = this.oldSpcCtrlMdlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldRlaneAdjQty = this.oldRlaneAdjQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRgnOfcCd = this.slsRgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
