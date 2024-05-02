/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SmpCustHisVO.java
*@FileTitle : SmpCustHisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.01
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.04.01 진마리아 
* 1.0 Creation
* 2013.04.01 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
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
 * @author 진마리아
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SmpCustHisVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SmpCustHisVO> models = new ArrayList<SmpCustHisVO>();
	
	/* Column Info */
	private String oldCustCntCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String oldCustSeq = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String modiUsrId = null;
	/* Column Info */
	private String custCtrlCd = null;
	/* Column Info */
	private String oldScNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String oldCustNm = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String custGrpNm = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String oldWkMqcQty = null;
	/* Column Info */
	private String oldCustCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String modiSeq = null;
	/* Column Info */
	private String wkMqcQty = null;
	/* Column Info */
	private String custGrpId = null;
	/* Column Info */
	private String modiGdt = null;
	/* Column Info */
	private String cngItmNm = null;
	/* Column Info */
	private String oldCustCtrlCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String verSeq = null;
	/* Column Info */
	private String oldCustGrpId = null;
	/* Column Info */
	private String oldCustGrpNm = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String modiUsrNm = null;
	/* Column Info */
	private String costYrwk = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String oldRfaNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SmpCustHisVO() {}

	public SmpCustHisVO(String ibflag, String pagerows, String modiGdt, String modiUsrId, String modiUsrNm, String verSeq, String cngItmNm, String custGrpId, String custGrpNm, String custCd, String custNm, String scNo, String wkMqcQty, String custCtrlCd, String oldCustGrpId, String oldCustGrpNm, String oldCustCd, String oldCustNm, String oldScNo, String oldWkMqcQty, String oldCustCtrlCd, String custCntCd, String custSeq, String oldCustCntCd, String oldCustSeq, String modiSeq, String trdCd, String costYrwk, String usrId, String subTrdCd, String rfaNo, String oldRfaNo) {
		this.oldCustCntCd = oldCustCntCd;
		this.custNm = custNm;
		this.oldCustSeq = oldCustSeq;
		this.trdCd = trdCd;
		this.modiUsrId = modiUsrId;
		this.custCtrlCd = custCtrlCd;
		this.oldScNo = oldScNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.oldCustNm = oldCustNm;
		this.usrId = usrId;
		this.custGrpNm = custGrpNm;
		this.scNo = scNo;
		this.oldWkMqcQty = oldWkMqcQty;
		this.oldCustCd = oldCustCd;
		this.custCntCd = custCntCd;
		this.modiSeq = modiSeq;
		this.wkMqcQty = wkMqcQty;
		this.custGrpId = custGrpId;
		this.modiGdt = modiGdt;
		this.cngItmNm = cngItmNm;
		this.oldCustCtrlCd = oldCustCtrlCd;
		this.custSeq = custSeq;
		this.verSeq = verSeq;
		this.oldCustGrpId = oldCustGrpId;
		this.oldCustGrpNm = oldCustGrpNm;
		this.custCd = custCd;
		this.modiUsrNm = modiUsrNm;
		this.costYrwk = costYrwk;
		this.subTrdCd = subTrdCd;
		this.rfaNo = rfaNo;
		this.oldRfaNo = oldRfaNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("old_cust_cnt_cd", getOldCustCntCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("old_cust_seq", getOldCustSeq());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("modi_usr_id", getModiUsrId());
		this.hashColumns.put("cust_ctrl_cd", getCustCtrlCd());
		this.hashColumns.put("old_sc_no", getOldScNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("old_cust_nm", getOldCustNm());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("cust_grp_nm", getCustGrpNm());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("old_wk_mqc_qty", getOldWkMqcQty());
		this.hashColumns.put("old_cust_cd", getOldCustCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("modi_seq", getModiSeq());
		this.hashColumns.put("wk_mqc_qty", getWkMqcQty());
		this.hashColumns.put("cust_grp_id", getCustGrpId());
		this.hashColumns.put("modi_gdt", getModiGdt());
		this.hashColumns.put("cng_itm_nm", getCngItmNm());
		this.hashColumns.put("old_cust_ctrl_cd", getOldCustCtrlCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("ver_seq", getVerSeq());
		this.hashColumns.put("old_cust_grp_id", getOldCustGrpId());
		this.hashColumns.put("old_cust_grp_nm", getOldCustGrpNm());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("modi_usr_nm", getModiUsrNm());
		this.hashColumns.put("cost_yrwk", getCostYrwk());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("old_rfa_no", getOldRfaNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("old_cust_cnt_cd", "oldCustCntCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("old_cust_seq", "oldCustSeq");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("modi_usr_id", "modiUsrId");
		this.hashFields.put("cust_ctrl_cd", "custCtrlCd");
		this.hashFields.put("old_sc_no", "oldScNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("old_cust_nm", "oldCustNm");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("cust_grp_nm", "custGrpNm");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("old_wk_mqc_qty", "oldWkMqcQty");
		this.hashFields.put("old_cust_cd", "oldCustCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("modi_seq", "modiSeq");
		this.hashFields.put("wk_mqc_qty", "wkMqcQty");
		this.hashFields.put("cust_grp_id", "custGrpId");
		this.hashFields.put("modi_gdt", "modiGdt");
		this.hashFields.put("cng_itm_nm", "cngItmNm");
		this.hashFields.put("old_cust_ctrl_cd", "oldCustCtrlCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("ver_seq", "verSeq");
		this.hashFields.put("old_cust_grp_id", "oldCustGrpId");
		this.hashFields.put("old_cust_grp_nm", "oldCustGrpNm");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("modi_usr_nm", "modiUsrNm");
		this.hashFields.put("cost_yrwk", "costYrwk");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("old_rfa_no", "oldRfaNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return oldCustCntCd
	 */
	public String getOldCustCntCd() {
		return this.oldCustCntCd;
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
	 * @return oldCustSeq
	 */
	public String getOldCustSeq() {
		return this.oldCustSeq;
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
	 * Column Info
	 * @return oldScNo
	 */
	public String getOldScNo() {
		return this.oldScNo;
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
	 * @return oldCustNm
	 */
	public String getOldCustNm() {
		return this.oldCustNm;
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
	 * @return oldWkMqcQty
	 */
	public String getOldWkMqcQty() {
		return this.oldWkMqcQty;
	}
	
	/**
	 * Column Info
	 * @return oldCustCd
	 */
	public String getOldCustCd() {
		return this.oldCustCd;
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
	 * @return modiSeq
	 */
	public String getModiSeq() {
		return this.modiSeq;
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
	 * @return custGrpId
	 */
	public String getCustGrpId() {
		return this.custGrpId;
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
	 * @return oldCustCtrlCd
	 */
	public String getOldCustCtrlCd() {
		return this.oldCustCtrlCd;
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
	 * @return verSeq
	 */
	public String getVerSeq() {
		return this.verSeq;
	}
	
	/**
	 * Column Info
	 * @return oldCustGrpId
	 */
	public String getOldCustGrpId() {
		return this.oldCustGrpId;
	}
	
	/**
	 * Column Info
	 * @return oldCustGrpNm
	 */
	public String getOldCustGrpNm() {
		return this.oldCustGrpNm;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
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
	 * @return costYrwk
	 */
	public String getCostYrwk() {
		return this.costYrwk;
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
	 * @return oldRfaNo
	 */
	public String getOldRfaNo() {
		return this.oldRfaNo;
	}
	

	/**
	 * Column Info
	 * @param oldCustCntCd
	 */
	public void setOldCustCntCd(String oldCustCntCd) {
		this.oldCustCntCd = oldCustCntCd;
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
	 * @param oldCustSeq
	 */
	public void setOldCustSeq(String oldCustSeq) {
		this.oldCustSeq = oldCustSeq;
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
	 * Column Info
	 * @param oldScNo
	 */
	public void setOldScNo(String oldScNo) {
		this.oldScNo = oldScNo;
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
	 * @param oldCustNm
	 */
	public void setOldCustNm(String oldCustNm) {
		this.oldCustNm = oldCustNm;
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
	 * @param oldWkMqcQty
	 */
	public void setOldWkMqcQty(String oldWkMqcQty) {
		this.oldWkMqcQty = oldWkMqcQty;
	}
	
	/**
	 * Column Info
	 * @param oldCustCd
	 */
	public void setOldCustCd(String oldCustCd) {
		this.oldCustCd = oldCustCd;
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
	 * @param modiSeq
	 */
	public void setModiSeq(String modiSeq) {
		this.modiSeq = modiSeq;
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
	 * @param custGrpId
	 */
	public void setCustGrpId(String custGrpId) {
		this.custGrpId = custGrpId;
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
	 * @param oldCustCtrlCd
	 */
	public void setOldCustCtrlCd(String oldCustCtrlCd) {
		this.oldCustCtrlCd = oldCustCtrlCd;
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
	 * @param verSeq
	 */
	public void setVerSeq(String verSeq) {
		this.verSeq = verSeq;
	}
	
	/**
	 * Column Info
	 * @param oldCustGrpId
	 */
	public void setOldCustGrpId(String oldCustGrpId) {
		this.oldCustGrpId = oldCustGrpId;
	}
	
	/**
	 * Column Info
	 * @param oldCustGrpNm
	 */
	public void setOldCustGrpNm(String oldCustGrpNm) {
		this.oldCustGrpNm = oldCustGrpNm;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
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
	 * @param costYrwk
	 */
	public void setCostYrwk(String costYrwk) {
		this.costYrwk = costYrwk;
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
	 * Column Info
	 * @param oldRfaNo
	 */
	public void setOldRfaNo(String oldRfaNo) {
		this.oldRfaNo = oldRfaNo;
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
		setOldCustCntCd(JSPUtil.getParameter(request, prefix + "old_cust_cnt_cd", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setOldCustSeq(JSPUtil.getParameter(request, prefix + "old_cust_seq", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setModiUsrId(JSPUtil.getParameter(request, prefix + "modi_usr_id", ""));
		setCustCtrlCd(JSPUtil.getParameter(request, prefix + "cust_ctrl_cd", ""));
		setOldScNo(JSPUtil.getParameter(request, prefix + "old_sc_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOldCustNm(JSPUtil.getParameter(request, prefix + "old_cust_nm", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setCustGrpNm(JSPUtil.getParameter(request, prefix + "cust_grp_nm", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setOldWkMqcQty(JSPUtil.getParameter(request, prefix + "old_wk_mqc_qty", ""));
		setOldCustCd(JSPUtil.getParameter(request, prefix + "old_cust_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setModiSeq(JSPUtil.getParameter(request, prefix + "modi_seq", ""));
		setWkMqcQty(JSPUtil.getParameter(request, prefix + "wk_mqc_qty", ""));
		setCustGrpId(JSPUtil.getParameter(request, prefix + "cust_grp_id", ""));
		setModiGdt(JSPUtil.getParameter(request, prefix + "modi_gdt", ""));
		setCngItmNm(JSPUtil.getParameter(request, prefix + "cng_itm_nm", ""));
		setOldCustCtrlCd(JSPUtil.getParameter(request, prefix + "old_cust_ctrl_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setVerSeq(JSPUtil.getParameter(request, prefix + "ver_seq", ""));
		setOldCustGrpId(JSPUtil.getParameter(request, prefix + "old_cust_grp_id", ""));
		setOldCustGrpNm(JSPUtil.getParameter(request, prefix + "old_cust_grp_nm", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setModiUsrNm(JSPUtil.getParameter(request, prefix + "modi_usr_nm", ""));
		setCostYrwk(JSPUtil.getParameter(request, prefix + "cost_yrwk", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setOldRfaNo(JSPUtil.getParameter(request, prefix + "old_rfa_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SmpCustHisVO[]
	 */
	public SmpCustHisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SmpCustHisVO[]
	 */
	public SmpCustHisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SmpCustHisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] oldCustCntCd = (JSPUtil.getParameter(request, prefix	+ "old_cust_cnt_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] oldCustSeq = (JSPUtil.getParameter(request, prefix	+ "old_cust_seq", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] modiUsrId = (JSPUtil.getParameter(request, prefix	+ "modi_usr_id", length));
			String[] custCtrlCd = (JSPUtil.getParameter(request, prefix	+ "cust_ctrl_cd", length));
			String[] oldScNo = (JSPUtil.getParameter(request, prefix	+ "old_sc_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] oldCustNm = (JSPUtil.getParameter(request, prefix	+ "old_cust_nm", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] custGrpNm = (JSPUtil.getParameter(request, prefix	+ "cust_grp_nm", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] oldWkMqcQty = (JSPUtil.getParameter(request, prefix	+ "old_wk_mqc_qty", length));
			String[] oldCustCd = (JSPUtil.getParameter(request, prefix	+ "old_cust_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] modiSeq = (JSPUtil.getParameter(request, prefix	+ "modi_seq", length));
			String[] wkMqcQty = (JSPUtil.getParameter(request, prefix	+ "wk_mqc_qty", length));
			String[] custGrpId = (JSPUtil.getParameter(request, prefix	+ "cust_grp_id", length));
			String[] modiGdt = (JSPUtil.getParameter(request, prefix	+ "modi_gdt", length));
			String[] cngItmNm = (JSPUtil.getParameter(request, prefix	+ "cng_itm_nm", length));
			String[] oldCustCtrlCd = (JSPUtil.getParameter(request, prefix	+ "old_cust_ctrl_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] verSeq = (JSPUtil.getParameter(request, prefix	+ "ver_seq", length));
			String[] oldCustGrpId = (JSPUtil.getParameter(request, prefix	+ "old_cust_grp_id", length));
			String[] oldCustGrpNm = (JSPUtil.getParameter(request, prefix	+ "old_cust_grp_nm", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] modiUsrNm = (JSPUtil.getParameter(request, prefix	+ "modi_usr_nm", length));
			String[] costYrwk = (JSPUtil.getParameter(request, prefix	+ "cost_yrwk", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] oldRfaNo = (JSPUtil.getParameter(request, prefix	+ "old_rfa_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SmpCustHisVO();
				if (oldCustCntCd[i] != null)
					model.setOldCustCntCd(oldCustCntCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (oldCustSeq[i] != null)
					model.setOldCustSeq(oldCustSeq[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (modiUsrId[i] != null)
					model.setModiUsrId(modiUsrId[i]);
				if (custCtrlCd[i] != null)
					model.setCustCtrlCd(custCtrlCd[i]);
				if (oldScNo[i] != null)
					model.setOldScNo(oldScNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (oldCustNm[i] != null)
					model.setOldCustNm(oldCustNm[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (custGrpNm[i] != null)
					model.setCustGrpNm(custGrpNm[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (oldWkMqcQty[i] != null)
					model.setOldWkMqcQty(oldWkMqcQty[i]);
				if (oldCustCd[i] != null)
					model.setOldCustCd(oldCustCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (modiSeq[i] != null)
					model.setModiSeq(modiSeq[i]);
				if (wkMqcQty[i] != null)
					model.setWkMqcQty(wkMqcQty[i]);
				if (custGrpId[i] != null)
					model.setCustGrpId(custGrpId[i]);
				if (modiGdt[i] != null)
					model.setModiGdt(modiGdt[i]);
				if (cngItmNm[i] != null)
					model.setCngItmNm(cngItmNm[i]);
				if (oldCustCtrlCd[i] != null)
					model.setOldCustCtrlCd(oldCustCtrlCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (verSeq[i] != null)
					model.setVerSeq(verSeq[i]);
				if (oldCustGrpId[i] != null)
					model.setOldCustGrpId(oldCustGrpId[i]);
				if (oldCustGrpNm[i] != null)
					model.setOldCustGrpNm(oldCustGrpNm[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (modiUsrNm[i] != null)
					model.setModiUsrNm(modiUsrNm[i]);
				if (costYrwk[i] != null)
					model.setCostYrwk(costYrwk[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (oldRfaNo[i] != null)
					model.setOldRfaNo(oldRfaNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSmpCustHisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SmpCustHisVO[]
	 */
	public SmpCustHisVO[] getSmpCustHisVOs(){
		SmpCustHisVO[] vos = (SmpCustHisVO[])models.toArray(new SmpCustHisVO[models.size()]);
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
		this.oldCustCntCd = this.oldCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldCustSeq = this.oldCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiUsrId = this.modiUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCtrlCd = this.custCtrlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldScNo = this.oldScNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldCustNm = this.oldCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custGrpNm = this.custGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldWkMqcQty = this.oldWkMqcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldCustCd = this.oldCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiSeq = this.modiSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wkMqcQty = this.wkMqcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custGrpId = this.custGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiGdt = this.modiGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cngItmNm = this.cngItmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldCustCtrlCd = this.oldCustCtrlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.verSeq = this.verSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldCustGrpId = this.oldCustGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldCustGrpNm = this.oldCustGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiUsrNm = this.modiUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrwk = this.costYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldRfaNo = this.oldRfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
