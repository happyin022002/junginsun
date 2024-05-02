/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SpcMdlCustCtrlHisVO.java
*@FileTitle : SpcMdlCustCtrlHisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.28
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2014.03.28 최윤성 
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

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
 * @author 최윤성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SpcMdlCustCtrlHisVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SpcMdlCustCtrlHisVO> models = new ArrayList<SpcMdlCustCtrlHisVO>();
	
	/* Column Info */
	private String oldCustCntCd = null;
	/* Column Info */
	private String oldCustSeq = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
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
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String oldWkMqcQty = null;
	/* Column Info */
	private String preRfaNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String oldRfaNo = null;
	/* Column Info */
	private String updDt = null;
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
	private String creUsrId = null;
	/* Column Info */
	private String preScNo = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String costYrwk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SpcMdlCustCtrlHisVO() {}

	public SpcMdlCustCtrlHisVO(String ibflag, String pagerows, String trdCd, String costYrwk, String verSeq, String modiSeq, String custCntCd, String custSeq, String custGrpId, String scNo, String rfaNo, String custCtrlCd, String wkMqcQty, String cngItmNm, String oldCustGrpId, String oldCustCntCd, String oldCustSeq, String oldScNo, String oldRfaNo, String oldWkMqcQty, String oldCustCtrlCd, String deltFlg, String modiUsrId, String modiGdt, String creUsrId, String creDt, String updUsrId, String updDt, String subTrdCd, String preScNo, String preRfaNo) {
		this.oldCustCntCd = oldCustCntCd;
		this.oldCustSeq = oldCustSeq;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.trdCd = trdCd;
		this.modiUsrId = modiUsrId;
		this.custCtrlCd = custCtrlCd;
		this.oldScNo = oldScNo;
		this.pagerows = pagerows;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.scNo = scNo;
		this.oldWkMqcQty = oldWkMqcQty;
		this.preRfaNo = preRfaNo;
		this.updUsrId = updUsrId;
		this.custCntCd = custCntCd;
		this.oldRfaNo = oldRfaNo;
		this.updDt = updDt;
		this.modiSeq = modiSeq;
		this.wkMqcQty = wkMqcQty;
		this.custGrpId = custGrpId;
		this.modiGdt = modiGdt;
		this.cngItmNm = cngItmNm;
		this.oldCustCtrlCd = oldCustCtrlCd;
		this.custSeq = custSeq;
		this.verSeq = verSeq;
		this.oldCustGrpId = oldCustGrpId;
		this.creUsrId = creUsrId;
		this.preScNo = preScNo;
		this.subTrdCd = subTrdCd;
		this.costYrwk = costYrwk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("old_cust_cnt_cd", getOldCustCntCd());
		this.hashColumns.put("old_cust_seq", getOldCustSeq());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("modi_usr_id", getModiUsrId());
		this.hashColumns.put("cust_ctrl_cd", getCustCtrlCd());
		this.hashColumns.put("old_sc_no", getOldScNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("old_wk_mqc_qty", getOldWkMqcQty());
		this.hashColumns.put("pre_rfa_no", getPreRfaNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("old_rfa_no", getOldRfaNo());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("modi_seq", getModiSeq());
		this.hashColumns.put("wk_mqc_qty", getWkMqcQty());
		this.hashColumns.put("cust_grp_id", getCustGrpId());
		this.hashColumns.put("modi_gdt", getModiGdt());
		this.hashColumns.put("cng_itm_nm", getCngItmNm());
		this.hashColumns.put("old_cust_ctrl_cd", getOldCustCtrlCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("ver_seq", getVerSeq());
		this.hashColumns.put("old_cust_grp_id", getOldCustGrpId());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("pre_sc_no", getPreScNo());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("cost_yrwk", getCostYrwk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("old_cust_cnt_cd", "oldCustCntCd");
		this.hashFields.put("old_cust_seq", "oldCustSeq");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("modi_usr_id", "modiUsrId");
		this.hashFields.put("cust_ctrl_cd", "custCtrlCd");
		this.hashFields.put("old_sc_no", "oldScNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("old_wk_mqc_qty", "oldWkMqcQty");
		this.hashFields.put("pre_rfa_no", "preRfaNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("old_rfa_no", "oldRfaNo");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("modi_seq", "modiSeq");
		this.hashFields.put("wk_mqc_qty", "wkMqcQty");
		this.hashFields.put("cust_grp_id", "custGrpId");
		this.hashFields.put("modi_gdt", "modiGdt");
		this.hashFields.put("cng_itm_nm", "cngItmNm");
		this.hashFields.put("old_cust_ctrl_cd", "oldCustCtrlCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("ver_seq", "verSeq");
		this.hashFields.put("old_cust_grp_id", "oldCustGrpId");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("pre_sc_no", "preScNo");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("cost_yrwk", "costYrwk");
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
	 * @return oldCustSeq
	 */
	public String getOldCustSeq() {
		return this.oldCustSeq;
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
	 * @return preRfaNo
	 */
	public String getPreRfaNo() {
		return this.preRfaNo;
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
	 * @return oldRfaNo
	 */
	public String getOldRfaNo() {
		return this.oldRfaNo;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return preScNo
	 */
	public String getPreScNo() {
		return this.preScNo;
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
	 * @param oldCustCntCd
	 */
	public void setOldCustCntCd(String oldCustCntCd) {
		this.oldCustCntCd = oldCustCntCd;
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
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
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
	 * @param preRfaNo
	 */
	public void setPreRfaNo(String preRfaNo) {
		this.preRfaNo = preRfaNo;
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
	 * @param oldRfaNo
	 */
	public void setOldRfaNo(String oldRfaNo) {
		this.oldRfaNo = oldRfaNo;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param preScNo
	 */
	public void setPreScNo(String preScNo) {
		this.preScNo = preScNo;
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
		setOldCustCntCd(JSPUtil.getParameter(request, prefix + "old_cust_cnt_cd", ""));
		setOldCustSeq(JSPUtil.getParameter(request, prefix + "old_cust_seq", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setModiUsrId(JSPUtil.getParameter(request, prefix + "modi_usr_id", ""));
		setCustCtrlCd(JSPUtil.getParameter(request, prefix + "cust_ctrl_cd", ""));
		setOldScNo(JSPUtil.getParameter(request, prefix + "old_sc_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setOldWkMqcQty(JSPUtil.getParameter(request, prefix + "old_wk_mqc_qty", ""));
		setPreRfaNo(JSPUtil.getParameter(request, prefix + "pre_rfa_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setOldRfaNo(JSPUtil.getParameter(request, prefix + "old_rfa_no", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setModiSeq(JSPUtil.getParameter(request, prefix + "modi_seq", ""));
		setWkMqcQty(JSPUtil.getParameter(request, prefix + "wk_mqc_qty", ""));
		setCustGrpId(JSPUtil.getParameter(request, prefix + "cust_grp_id", ""));
		setModiGdt(JSPUtil.getParameter(request, prefix + "modi_gdt", ""));
		setCngItmNm(JSPUtil.getParameter(request, prefix + "cng_itm_nm", ""));
		setOldCustCtrlCd(JSPUtil.getParameter(request, prefix + "old_cust_ctrl_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setVerSeq(JSPUtil.getParameter(request, prefix + "ver_seq", ""));
		setOldCustGrpId(JSPUtil.getParameter(request, prefix + "old_cust_grp_id", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setPreScNo(JSPUtil.getParameter(request, prefix + "pre_sc_no", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setCostYrwk(JSPUtil.getParameter(request, prefix + "cost_yrwk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SpcMdlCustCtrlHisVO[]
	 */
	public SpcMdlCustCtrlHisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SpcMdlCustCtrlHisVO[]
	 */
	public SpcMdlCustCtrlHisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SpcMdlCustCtrlHisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] oldCustCntCd = (JSPUtil.getParameter(request, prefix	+ "old_cust_cnt_cd", length));
			String[] oldCustSeq = (JSPUtil.getParameter(request, prefix	+ "old_cust_seq", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] modiUsrId = (JSPUtil.getParameter(request, prefix	+ "modi_usr_id", length));
			String[] custCtrlCd = (JSPUtil.getParameter(request, prefix	+ "cust_ctrl_cd", length));
			String[] oldScNo = (JSPUtil.getParameter(request, prefix	+ "old_sc_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] oldWkMqcQty = (JSPUtil.getParameter(request, prefix	+ "old_wk_mqc_qty", length));
			String[] preRfaNo = (JSPUtil.getParameter(request, prefix	+ "pre_rfa_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] oldRfaNo = (JSPUtil.getParameter(request, prefix	+ "old_rfa_no", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] modiSeq = (JSPUtil.getParameter(request, prefix	+ "modi_seq", length));
			String[] wkMqcQty = (JSPUtil.getParameter(request, prefix	+ "wk_mqc_qty", length));
			String[] custGrpId = (JSPUtil.getParameter(request, prefix	+ "cust_grp_id", length));
			String[] modiGdt = (JSPUtil.getParameter(request, prefix	+ "modi_gdt", length));
			String[] cngItmNm = (JSPUtil.getParameter(request, prefix	+ "cng_itm_nm", length));
			String[] oldCustCtrlCd = (JSPUtil.getParameter(request, prefix	+ "old_cust_ctrl_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] verSeq = (JSPUtil.getParameter(request, prefix	+ "ver_seq", length));
			String[] oldCustGrpId = (JSPUtil.getParameter(request, prefix	+ "old_cust_grp_id", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] preScNo = (JSPUtil.getParameter(request, prefix	+ "pre_sc_no", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] costYrwk = (JSPUtil.getParameter(request, prefix	+ "cost_yrwk", length));
			
			for (int i = 0; i < length; i++) {
				model = new SpcMdlCustCtrlHisVO();
				if (oldCustCntCd[i] != null)
					model.setOldCustCntCd(oldCustCntCd[i]);
				if (oldCustSeq[i] != null)
					model.setOldCustSeq(oldCustSeq[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
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
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (oldWkMqcQty[i] != null)
					model.setOldWkMqcQty(oldWkMqcQty[i]);
				if (preRfaNo[i] != null)
					model.setPreRfaNo(preRfaNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (oldRfaNo[i] != null)
					model.setOldRfaNo(oldRfaNo[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
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
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (preScNo[i] != null)
					model.setPreScNo(preScNo[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (costYrwk[i] != null)
					model.setCostYrwk(costYrwk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSpcMdlCustCtrlHisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SpcMdlCustCtrlHisVO[]
	 */
	public SpcMdlCustCtrlHisVO[] getSpcMdlCustCtrlHisVOs(){
		SpcMdlCustCtrlHisVO[] vos = (SpcMdlCustCtrlHisVO[])models.toArray(new SpcMdlCustCtrlHisVO[models.size()]);
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
		this.oldCustSeq = this.oldCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiUsrId = this.modiUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCtrlCd = this.custCtrlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldScNo = this.oldScNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldWkMqcQty = this.oldWkMqcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preRfaNo = this.preRfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldRfaNo = this.oldRfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiSeq = this.modiSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wkMqcQty = this.wkMqcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custGrpId = this.custGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiGdt = this.modiGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cngItmNm = this.cngItmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldCustCtrlCd = this.oldCustCtrlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.verSeq = this.verSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldCustGrpId = this.oldCustGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preScNo = this.preScNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrwk = this.costYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
