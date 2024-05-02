/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BkgCustBlPprMgmtVO.java
*@FileTitle : BkgCustBlPprMgmtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.16  
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgCustBlPprMgmtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgCustBlPprMgmtVO> models = new ArrayList<BkgCustBlPprMgmtVO>();
	
	/* Column Info */
	private String creFromDt = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String rhqWdrKnt = null;
	/* Column Info */
	private String custToSerNo = null;
	/* Column Info */
	private String creDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String custFmSerNo = null;
	/* Column Info */
	private String ofcToSerNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rhqToSerNo = null;
	/* Column Info */
	private String custDtrbKnt = null;
	/* Column Info */
	private String ofcWdrKnt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String rhqDtrbKnt = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creToDt = null;
	/* Column Info */
	private String dtrbYr = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String ofcFmSerNo = null;
	/* Column Info */
	private String custWdrKnt = null;
	/* Column Info */
	private String dtrbCycNo = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String ofcDtrbKnt = null;
	/* Column Info */
	private String rhqFmSerNo = null;
	/* Column Info */
	private String fChkCd = null;
	/* Column Info */
	private String custDtrbSeq = null;
	/* Column Info */
	private String chgFlg = null;
	/* Column Info */
	private String rocDiv = null;
	/* Column Info */
	private String custAccmWdrKnt = null;

	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BkgCustBlPprMgmtVO() {}

	public BkgCustBlPprMgmtVO(String ibflag, String pagerows, String dtrbYr, String dtrbCycNo, String rhqCd, String rhqDtrbKnt, String ofcDtrbKnt, String custDtrbKnt, String rhqFmSerNo, String rhqToSerNo, String ofcFmSerNo, String ofcToSerNo, String custFmSerNo, String custToSerNo, String ofcCd, String custCntCd, String custSeq, String custNm, String rhqWdrKnt, String ofcWdrKnt, String custWdrKnt, String fChkCd, String creFromDt, String creToDt, String creUsrId, String creDt, String updUsrId, String updDt, String custDtrbSeq, String chgFlg, String rocDiv, String custAccmWdrKnt) {
		this.creFromDt = creFromDt;
		this.custNm = custNm;
		this.rhqWdrKnt = rhqWdrKnt;
		this.custToSerNo = custToSerNo;
		this.creDt = creDt;
		this.pagerows = pagerows;
		this.custFmSerNo = custFmSerNo;
		this.ofcToSerNo = ofcToSerNo;
		this.ibflag = ibflag;
		this.rhqToSerNo = rhqToSerNo;
		this.custDtrbKnt = custDtrbKnt;
		this.ofcWdrKnt = ofcWdrKnt;
		this.updUsrId = updUsrId;
		this.rhqDtrbKnt = rhqDtrbKnt;
		this.custCntCd = custCntCd;
		this.updDt = updDt;
		this.creToDt = creToDt;
		this.dtrbYr = dtrbYr;
		this.rhqCd = rhqCd;
		this.ofcFmSerNo = ofcFmSerNo;
		this.custWdrKnt = custWdrKnt;
		this.dtrbCycNo = dtrbCycNo;
		this.custSeq = custSeq;
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.ofcDtrbKnt = ofcDtrbKnt;
		this.rhqFmSerNo = rhqFmSerNo;
		this.fChkCd = fChkCd;
		this.custDtrbSeq = custDtrbSeq;
		this.chgFlg = chgFlg;
		this.rocDiv = rocDiv;
		this.custAccmWdrKnt = custAccmWdrKnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cre_from_dt", getCreFromDt());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("rhq_wdr_knt", getRhqWdrKnt());
		this.hashColumns.put("cust_to_ser_no", getCustToSerNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cust_fm_ser_no", getCustFmSerNo());
		this.hashColumns.put("ofc_to_ser_no", getOfcToSerNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rhq_to_ser_no", getRhqToSerNo());
		this.hashColumns.put("cust_dtrb_knt", getCustDtrbKnt());
		this.hashColumns.put("ofc_wdr_knt", getOfcWdrKnt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("rhq_dtrb_knt", getRhqDtrbKnt());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_to_dt", getCreToDt());
		this.hashColumns.put("dtrb_yr", getDtrbYr());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("ofc_fm_ser_no", getOfcFmSerNo());
		this.hashColumns.put("cust_wdr_knt", getCustWdrKnt());
		this.hashColumns.put("dtrb_cyc_no", getDtrbCycNo());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ofc_dtrb_knt", getOfcDtrbKnt());
		this.hashColumns.put("rhq_fm_ser_no", getRhqFmSerNo());
		this.hashColumns.put("f_chk_cd", getFChkCd());
		this.hashColumns.put("cust_dtrb_seq", getCustDtrbSeq());
		this.hashColumns.put("chg_flg", getChgFlg());
		this.hashColumns.put("roc_div", getRocDiv());
		this.hashColumns.put("cust_accm_wdr_knt", getCustAccmWdrKnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cre_from_dt", "creFromDt");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("rhq_wdr_knt", "rhqWdrKnt");
		this.hashFields.put("cust_to_ser_no", "custToSerNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cust_fm_ser_no", "custFmSerNo");
		this.hashFields.put("ofc_to_ser_no", "ofcToSerNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rhq_to_ser_no", "rhqToSerNo");
		this.hashFields.put("cust_dtrb_knt", "custDtrbKnt");
		this.hashFields.put("ofc_wdr_knt", "ofcWdrKnt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("rhq_dtrb_knt", "rhqDtrbKnt");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_to_dt", "creToDt");
		this.hashFields.put("dtrb_yr", "dtrbYr");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("ofc_fm_ser_no", "ofcFmSerNo");
		this.hashFields.put("cust_wdr_knt", "custWdrKnt");
		this.hashFields.put("dtrb_cyc_no", "dtrbCycNo");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ofc_dtrb_knt", "ofcDtrbKnt");
		this.hashFields.put("rhq_fm_ser_no", "rhqFmSerNo");
		this.hashFields.put("f_chk_cd", "fChkCd");
		this.hashFields.put("chg_flg", "chgFlg");
		this.hashFields.put("cust_dtrb_seq", "custDtrbSeq");
		this.hashFields.put("roc_div", "rocDiv");
		this.hashFields.put("cust_accm_wdr_knt", "custAccmWdrKnt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return creFromDt
	 */
	public String getCreFromDt() {
		return this.creFromDt;
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
	 * @return rhqWdrKnt
	 */
	public String getRhqWdrKnt() {
		return this.rhqWdrKnt;
	}
	
	/**
	 * Column Info
	 * @return custToSerNo
	 */
	public String getCustToSerNo() {
		return this.custToSerNo;
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
	 * @return custAccmWdrKnt
	 */
	public String getCustAccmWdrKnt() {
		return this.custAccmWdrKnt;
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
	 * @return custFmSerNo
	 */
	public String getCustFmSerNo() {
		return this.custFmSerNo;
	}
	
	/**
	 * Column Info
	 * @return rocDiv
	 */
	public String getRocDiv() {
		return this.rocDiv;
	}
	
	/**
	 * Column Info
	 * @return ofcToSerNo
	 */
	public String getOfcToSerNo() {
		return this.ofcToSerNo;
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
	 * @return rhqToSerNo
	 */
	public String getRhqToSerNo() {
		return this.rhqToSerNo;
	}
	
	/**
	 * Column Info
	 * @return custDtrbKnt
	 */
	public String getCustDtrbKnt() {
		return this.custDtrbKnt;
	}
	
	/**
	 * Column Info
	 * @return ofcWdrKnt
	 */
	public String getOfcWdrKnt() {
		return this.ofcWdrKnt;
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
	 * @return rhqDtrbKnt
	 */
	public String getRhqDtrbKnt() {
		return this.rhqDtrbKnt;
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
	 * @return creToDt
	 */
	public String getCreToDt() {
		return this.creToDt;
	}
	
	/**
	 * Column Info
	 * @return dtrbYr
	 */
	public String getDtrbYr() {
		return this.dtrbYr;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return ofcFmSerNo
	 */
	public String getOfcFmSerNo() {
		return this.ofcFmSerNo;
	}
	
	/**
	 * Column Info
	 * @return custWdrKnt
	 */
	public String getCustWdrKnt() {
		return this.custWdrKnt;
	}
	
	/**
	 * Column Info
	 * @return dtrbCycNo
	 */
	public String getDtrbCycNo() {
		return this.dtrbCycNo;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return ofcDtrbKnt
	 */
	public String getOfcDtrbKnt() {
		return this.ofcDtrbKnt;
	}
	
	/**
	 * Column Info
	 * @return rhqFmSerNo
	 */
	public String getRhqFmSerNo() {
		return this.rhqFmSerNo;
	}
	
	/**
	 * Column Info
	 * @return fChkCd
	 */
	public String getFChkCd() {
		return this.fChkCd;
	}
	
	/**
	 * Column Info
	 * @return custDtrbSeq
	 */
	public String getCustDtrbSeq() {
		return this.custDtrbSeq;
	}
	
	
	/**
	 * Column Info
	 * @return chgFlg
	 */
	public String getChgFlg() {
		return this.chgFlg;
	}
	

	/**
	 * Column Info
	 * @param creFromDt
	 */
	public void setCreFromDt(String creFromDt) {
		this.creFromDt = creFromDt;
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
	 * @param rhqWdrKnt
	 */
	public void setRhqWdrKnt(String rhqWdrKnt) {
		this.rhqWdrKnt = rhqWdrKnt;
	}
	
	/**
	 * Column Info
	 * @param custToSerNo
	 */
	public void setCustToSerNo(String custToSerNo) {
		this.custToSerNo = custToSerNo;
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
	 * @param custAccmWdrKnt
	 */
	public void setCustAccmWdrKnt(String custAccmWdrKnt) {
		this.custAccmWdrKnt = custAccmWdrKnt;
	}
	
	/**
	 * Column Info
	 * @param rocDiv
	 */
	public void setRocDiv(String rocDiv) {
		this.rocDiv = rocDiv;
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
	 * @param custFmSerNo
	 */
	public void setCustFmSerNo(String custFmSerNo) {
		this.custFmSerNo = custFmSerNo;
	}
	
	/**
	 * Column Info
	 * @param ofcToSerNo
	 */
	public void setOfcToSerNo(String ofcToSerNo) {
		this.ofcToSerNo = ofcToSerNo;
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
	 * @param rhqToSerNo
	 */
	public void setRhqToSerNo(String rhqToSerNo) {
		this.rhqToSerNo = rhqToSerNo;
	}
	
	/**
	 * Column Info
	 * @param custDtrbKnt
	 */
	public void setCustDtrbKnt(String custDtrbKnt) {
		this.custDtrbKnt = custDtrbKnt;
	}
	
	/**
	 * Column Info
	 * @param ofcWdrKnt
	 */
	public void setOfcWdrKnt(String ofcWdrKnt) {
		this.ofcWdrKnt = ofcWdrKnt;
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
	 * @param rhqDtrbKnt
	 */
	public void setRhqDtrbKnt(String rhqDtrbKnt) {
		this.rhqDtrbKnt = rhqDtrbKnt;
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
	 * @param creToDt
	 */
	public void setCreToDt(String creToDt) {
		this.creToDt = creToDt;
	}
	
	/**
	 * Column Info
	 * @param dtrbYr
	 */
	public void setDtrbYr(String dtrbYr) {
		this.dtrbYr = dtrbYr;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param ofcFmSerNo
	 */
	public void setOfcFmSerNo(String ofcFmSerNo) {
		this.ofcFmSerNo = ofcFmSerNo;
	}
	
	/**
	 * Column Info
	 * @param custWdrKnt
	 */
	public void setCustWdrKnt(String custWdrKnt) {
		this.custWdrKnt = custWdrKnt;
	}
	
	/**
	 * Column Info
	 * @param dtrbCycNo
	 */
	public void setDtrbCycNo(String dtrbCycNo) {
		this.dtrbCycNo = dtrbCycNo;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param ofcDtrbKnt
	 */
	public void setOfcDtrbKnt(String ofcDtrbKnt) {
		this.ofcDtrbKnt = ofcDtrbKnt;
	}
	
	/**
	 * Column Info
	 * @param rhqFmSerNo
	 */
	public void setRhqFmSerNo(String rhqFmSerNo) {
		this.rhqFmSerNo = rhqFmSerNo;
	}
	
	/**
	 * Column Info
	 * @param fChkCd
	 */
	public void setFChkCd(String fChkCd) {
		this.fChkCd = fChkCd;
	}
	
	/**
	 * Column Info
	 * @param custDtrbSeq
	 */
	public void setCustDtrbSeq(String custDtrbSeq) {
		this.custDtrbSeq = custDtrbSeq;
	}
	
	/**
	 * Column Info
	 * @param chgFlg
	 */
	public void setChgFlg(String chgFlg) {
		this.chgFlg = chgFlg;
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
		setCreFromDt(JSPUtil.getParameter(request, prefix + "cre_from_dt", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setRhqWdrKnt(JSPUtil.getParameter(request, prefix + "rhq_wdr_knt", ""));
		setCustToSerNo(JSPUtil.getParameter(request, prefix + "cust_to_ser_no", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCustFmSerNo(JSPUtil.getParameter(request, prefix + "cust_fm_ser_no", ""));
		setOfcToSerNo(JSPUtil.getParameter(request, prefix + "ofc_to_ser_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRhqToSerNo(JSPUtil.getParameter(request, prefix + "rhq_to_ser_no", ""));
		setCustDtrbKnt(JSPUtil.getParameter(request, prefix + "cust_dtrb_knt", ""));
		setOfcWdrKnt(JSPUtil.getParameter(request, prefix + "ofc_wdr_knt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setRhqDtrbKnt(JSPUtil.getParameter(request, prefix + "rhq_dtrb_knt", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCreToDt(JSPUtil.getParameter(request, prefix + "cre_to_dt", ""));
		setDtrbYr(JSPUtil.getParameter(request, prefix + "dtrb_yr", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setOfcFmSerNo(JSPUtil.getParameter(request, prefix + "ofc_fm_ser_no", ""));
		setCustWdrKnt(JSPUtil.getParameter(request, prefix + "cust_wdr_knt", ""));
		setDtrbCycNo(JSPUtil.getParameter(request, prefix + "dtrb_cyc_no", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setOfcDtrbKnt(JSPUtil.getParameter(request, prefix + "ofc_dtrb_knt", ""));
		setRhqFmSerNo(JSPUtil.getParameter(request, prefix + "rhq_fm_ser_no", ""));
		setFChkCd(JSPUtil.getParameter(request, prefix + "f_chk_cd", ""));
		setCustDtrbSeq(JSPUtil.getParameter(request, prefix + "cust_dtrb_seq", ""));
		setChgFlg(JSPUtil.getParameter(request, prefix + "chg_flg", ""));
		setRocDiv(JSPUtil.getParameter(request, prefix + "roc_div", ""));
		setCustAccmWdrKnt(JSPUtil.getParameter(request, prefix + "cust_accm_wdr_knt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCustBlPprMgmtVO[]
	 */
	public BkgCustBlPprMgmtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCustBlPprMgmtVO[]
	 */
	public BkgCustBlPprMgmtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCustBlPprMgmtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] creFromDt = (JSPUtil.getParameter(request, prefix	+ "cre_from_dt", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] rhqWdrKnt = (JSPUtil.getParameter(request, prefix	+ "rhq_wdr_knt", length));
			String[] custToSerNo = (JSPUtil.getParameter(request, prefix	+ "cust_to_ser_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] custFmSerNo = (JSPUtil.getParameter(request, prefix	+ "cust_fm_ser_no", length));
			String[] ofcToSerNo = (JSPUtil.getParameter(request, prefix	+ "ofc_to_ser_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rhqToSerNo = (JSPUtil.getParameter(request, prefix	+ "rhq_to_ser_no", length));
			String[] custDtrbKnt = (JSPUtil.getParameter(request, prefix	+ "cust_dtrb_knt", length));
			String[] ofcWdrKnt = (JSPUtil.getParameter(request, prefix	+ "ofc_wdr_knt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] rhqDtrbKnt = (JSPUtil.getParameter(request, prefix	+ "rhq_dtrb_knt", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] creToDt = (JSPUtil.getParameter(request, prefix	+ "cre_to_dt", length));
			String[] dtrbYr = (JSPUtil.getParameter(request, prefix	+ "dtrb_yr", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] ofcFmSerNo = (JSPUtil.getParameter(request, prefix	+ "ofc_fm_ser_no", length));
			String[] custWdrKnt = (JSPUtil.getParameter(request, prefix	+ "cust_wdr_knt", length));
			String[] dtrbCycNo = (JSPUtil.getParameter(request, prefix	+ "dtrb_cyc_no", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ofcDtrbKnt = (JSPUtil.getParameter(request, prefix	+ "ofc_dtrb_knt", length));
			String[] rhqFmSerNo = (JSPUtil.getParameter(request, prefix	+ "rhq_fm_ser_no", length));
			String[] fChkCd = (JSPUtil.getParameter(request, prefix	+ "f_chk_cd", length));
			String[] custDtrbSeq = (JSPUtil.getParameter(request, prefix + "cust_dtrb_seq", length));
			String[] chgFlg = (JSPUtil.getParameter(request, prefix	+ "chg_flg", length));
			String[] rocDiv = (JSPUtil.getParameter(request, prefix	+ "roc_div", length));
			String[] custAccmWdrKnt = (JSPUtil.getParameter(request, prefix	+ "cust_accm_wdr_knt", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgCustBlPprMgmtVO();
				if (creFromDt[i] != null)
					model.setCreFromDt(creFromDt[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (rhqWdrKnt[i] != null)
					model.setRhqWdrKnt(rhqWdrKnt[i]);
				if (custToSerNo[i] != null)
					model.setCustToSerNo(custToSerNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (custFmSerNo[i] != null)
					model.setCustFmSerNo(custFmSerNo[i]);
				if (ofcToSerNo[i] != null)
					model.setOfcToSerNo(ofcToSerNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rhqToSerNo[i] != null)
					model.setRhqToSerNo(rhqToSerNo[i]);
				if (custDtrbKnt[i] != null)
					model.setCustDtrbKnt(custDtrbKnt[i]);
				if (ofcWdrKnt[i] != null)
					model.setOfcWdrKnt(ofcWdrKnt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (rhqDtrbKnt[i] != null)
					model.setRhqDtrbKnt(rhqDtrbKnt[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creToDt[i] != null)
					model.setCreToDt(creToDt[i]);
				if (dtrbYr[i] != null)
					model.setDtrbYr(dtrbYr[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (ofcFmSerNo[i] != null)
					model.setOfcFmSerNo(ofcFmSerNo[i]);
				if (custWdrKnt[i] != null)
					model.setCustWdrKnt(custWdrKnt[i]);
				if (dtrbCycNo[i] != null)
					model.setDtrbCycNo(dtrbCycNo[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ofcDtrbKnt[i] != null)
					model.setOfcDtrbKnt(ofcDtrbKnt[i]);
				if (rhqFmSerNo[i] != null)
					model.setRhqFmSerNo(rhqFmSerNo[i]);
				if (fChkCd[i] != null)
					model.setFChkCd(fChkCd[i]);
				if (custDtrbSeq[i] != null)
					model.setCustDtrbSeq(custDtrbSeq[i]);
				if (chgFlg[i] != null)
					model.setChgFlg(chgFlg[i]);
				if (rocDiv[i] != null)
					model.setRocDiv(rocDiv[i]);
				if (custAccmWdrKnt[i] != null)
					model.setCustAccmWdrKnt(custAccmWdrKnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgCustBlPprMgmtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgCustBlPprMgmtVO[]
	 */
	public BkgCustBlPprMgmtVO[] getBkgCustBlPprMgmtVOs(){
		BkgCustBlPprMgmtVO[] vos = (BkgCustBlPprMgmtVO[])models.toArray(new BkgCustBlPprMgmtVO[models.size()]);
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
		this.creFromDt = this.creFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqWdrKnt = this.rhqWdrKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custToSerNo = this.custToSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custFmSerNo = this.custFmSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcToSerNo = this.ofcToSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqToSerNo = this.rhqToSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custDtrbKnt = this.custDtrbKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcWdrKnt = this.ofcWdrKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqDtrbKnt = this.rhqDtrbKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creToDt = this.creToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbYr = this.dtrbYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcFmSerNo = this.ofcFmSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custWdrKnt = this.custWdrKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbCycNo = this.dtrbCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcDtrbKnt = this.ofcDtrbKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqFmSerNo = this.rhqFmSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fChkCd = this.fChkCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custDtrbSeq = this.custDtrbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgFlg = this.chgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rocDiv = this.rocDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAccmWdrKnt = this.custAccmWdrKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
