/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAExceptionCoverageVO.java
*@FileTitle : RFAExceptionCoverageVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.06.19 이성훈 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이성훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RFAExceptionCoverageVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RFAExceptionCoverageVO> models = new ArrayList<RFAExceptionCoverageVO>();
	
	/* Column Info */
	private String cvrgCmbSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String n1stCmncVerSeq = null;
	/* Column Info */
	private String orgDestRgnAllNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cvrgRgnCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String orgDestContiCd = null;
	/* Column Info */
	private String cvrgSteCd = null;
	/* Column Info */
	private String rfaExptMapgSeq = null;
	/* Column Info */
	private String rfaExptDarNo = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String rfaRqstDtlSeq = null;
	/* Column Info */
	private String rfaExptVerSeq = null;
	/* Column Info */
	private String cvrgCntCd = null;
	/* Column Info */
	private String orgDestRgnCd = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String orgDestCntAllCd = null;
	/* Column Info */
	private String orgDestCntAllNm = null;
	/* Column Info */
	private String orgDestSteCd = null;
	/* Column Info */
	private String orgDestLocCd = null;
	/* Column Info */
	private String orgDestRgnAllCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cvrgContiCd = null;
	/* Column Info */
	private String orgDestCntCd = null;
	/* Column Info */
	private String cvrgLocCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RFAExceptionCoverageVO() {}

	public RFAExceptionCoverageVO(String ibflag, String pagerows, String rfaExptDarNo, String rfaExptMapgSeq, String rfaExptVerSeq, String rfaRqstDtlSeq, String cvrgCmbSeq, String cvrgContiCd, String cvrgCntCd, String cvrgRgnCd, String cvrgSteCd, String cvrgLocCd, String orgDestContiCd, String orgDestCntCd, String orgDestCntAllCd, String orgDestCntAllNm, String orgDestRgnCd, String orgDestRgnAllCd, String orgDestRgnAllNm, String orgDestSteCd, String orgDestLocCd, String n1stCmncVerSeq, String creUsrId, String creDt, String creOfcCd, String updUsrId, String updDt, String updOfcCd) {
		this.cvrgCmbSeq = cvrgCmbSeq;
		this.creDt = creDt;
		this.n1stCmncVerSeq = n1stCmncVerSeq;
		this.orgDestRgnAllNm = orgDestRgnAllNm;
		this.pagerows = pagerows;
		this.cvrgRgnCd = cvrgRgnCd;
		this.ibflag = ibflag;
		this.orgDestContiCd = orgDestContiCd;
		this.cvrgSteCd = cvrgSteCd;
		this.rfaExptMapgSeq = rfaExptMapgSeq;
		this.rfaExptDarNo = rfaExptDarNo;
		this.creOfcCd = creOfcCd;
		this.rfaRqstDtlSeq = rfaRqstDtlSeq;
		this.rfaExptVerSeq = rfaExptVerSeq;
		this.cvrgCntCd = cvrgCntCd;
		this.orgDestRgnCd = orgDestRgnCd;
		this.updOfcCd = updOfcCd;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.orgDestCntAllCd = orgDestCntAllCd;
		this.orgDestCntAllNm = orgDestCntAllNm;
		this.orgDestSteCd = orgDestSteCd;
		this.orgDestLocCd = orgDestLocCd;
		this.orgDestRgnAllCd = orgDestRgnAllCd;
		this.creUsrId = creUsrId;
		this.cvrgContiCd = cvrgContiCd;
		this.orgDestCntCd = orgDestCntCd;
		this.cvrgLocCd = cvrgLocCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cvrg_cmb_seq", getCvrgCmbSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("n1st_cmnc_ver_seq", getN1stCmncVerSeq());
		this.hashColumns.put("org_dest_rgn_all_nm", getOrgDestRgnAllNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cvrg_rgn_cd", getCvrgRgnCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("org_dest_conti_cd", getOrgDestContiCd());
		this.hashColumns.put("cvrg_ste_cd", getCvrgSteCd());
		this.hashColumns.put("rfa_expt_mapg_seq", getRfaExptMapgSeq());
		this.hashColumns.put("rfa_expt_dar_no", getRfaExptDarNo());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("rfa_rqst_dtl_seq", getRfaRqstDtlSeq());
		this.hashColumns.put("rfa_expt_ver_seq", getRfaExptVerSeq());
		this.hashColumns.put("cvrg_cnt_cd", getCvrgCntCd());
		this.hashColumns.put("org_dest_rgn_cd", getOrgDestRgnCd());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("org_dest_cnt_all_cd", getOrgDestCntAllCd());
		this.hashColumns.put("org_dest_cnt_all_nm", getOrgDestCntAllNm());
		this.hashColumns.put("org_dest_ste_cd", getOrgDestSteCd());
		this.hashColumns.put("org_dest_loc_cd", getOrgDestLocCd());
		this.hashColumns.put("org_dest_rgn_all_cd", getOrgDestRgnAllCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cvrg_conti_cd", getCvrgContiCd());
		this.hashColumns.put("org_dest_cnt_cd", getOrgDestCntCd());
		this.hashColumns.put("cvrg_loc_cd", getCvrgLocCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cvrg_cmb_seq", "cvrgCmbSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("n1st_cmnc_ver_seq", "n1stCmncVerSeq");
		this.hashFields.put("org_dest_rgn_all_nm", "orgDestRgnAllNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cvrg_rgn_cd", "cvrgRgnCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("org_dest_conti_cd", "orgDestContiCd");
		this.hashFields.put("cvrg_ste_cd", "cvrgSteCd");
		this.hashFields.put("rfa_expt_mapg_seq", "rfaExptMapgSeq");
		this.hashFields.put("rfa_expt_dar_no", "rfaExptDarNo");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("rfa_rqst_dtl_seq", "rfaRqstDtlSeq");
		this.hashFields.put("rfa_expt_ver_seq", "rfaExptVerSeq");
		this.hashFields.put("cvrg_cnt_cd", "cvrgCntCd");
		this.hashFields.put("org_dest_rgn_cd", "orgDestRgnCd");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("org_dest_cnt_all_cd", "orgDestCntAllCd");
		this.hashFields.put("org_dest_cnt_all_nm", "orgDestCntAllNm");
		this.hashFields.put("org_dest_ste_cd", "orgDestSteCd");
		this.hashFields.put("org_dest_loc_cd", "orgDestLocCd");
		this.hashFields.put("org_dest_rgn_all_cd", "orgDestRgnAllCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cvrg_conti_cd", "cvrgContiCd");
		this.hashFields.put("org_dest_cnt_cd", "orgDestCntCd");
		this.hashFields.put("cvrg_loc_cd", "cvrgLocCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cvrgCmbSeq
	 */
	public String getCvrgCmbSeq() {
		return this.cvrgCmbSeq;
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
	 * @return n1stCmncVerSeq
	 */
	public String getN1stCmncVerSeq() {
		return this.n1stCmncVerSeq;
	}
	
	/**
	 * Column Info
	 * @return orgDestRgnAllNm
	 */
	public String getOrgDestRgnAllNm() {
		return this.orgDestRgnAllNm;
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
	 * @return cvrgRgnCd
	 */
	public String getCvrgRgnCd() {
		return this.cvrgRgnCd;
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
	 * @return orgDestContiCd
	 */
	public String getOrgDestContiCd() {
		return this.orgDestContiCd;
	}
	
	/**
	 * Column Info
	 * @return cvrgSteCd
	 */
	public String getCvrgSteCd() {
		return this.cvrgSteCd;
	}
	
	/**
	 * Column Info
	 * @return rfaExptMapgSeq
	 */
	public String getRfaExptMapgSeq() {
		return this.rfaExptMapgSeq;
	}
	
	/**
	 * Column Info
	 * @return rfaExptDarNo
	 */
	public String getRfaExptDarNo() {
		return this.rfaExptDarNo;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rfaRqstDtlSeq
	 */
	public String getRfaRqstDtlSeq() {
		return this.rfaRqstDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return rfaExptVerSeq
	 */
	public String getRfaExptVerSeq() {
		return this.rfaExptVerSeq;
	}
	
	/**
	 * Column Info
	 * @return cvrgCntCd
	 */
	public String getCvrgCntCd() {
		return this.cvrgCntCd;
	}
	
	/**
	 * Column Info
	 * @return orgDestRgnCd
	 */
	public String getOrgDestRgnCd() {
		return this.orgDestRgnCd;
	}
	
	/**
	 * Column Info
	 * @return updOfcCd
	 */
	public String getUpdOfcCd() {
		return this.updOfcCd;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return orgDestCntAllCd
	 */
	public String getOrgDestCntAllCd() {
		return this.orgDestCntAllCd;
	}
	
	/**
	 * Column Info
	 * @return orgDestCntAllNm
	 */
	public String getOrgDestCntAllNm() {
		return this.orgDestCntAllNm;
	}
	
	/**
	 * Column Info
	 * @return orgDestSteCd
	 */
	public String getOrgDestSteCd() {
		return this.orgDestSteCd;
	}
	
	/**
	 * Column Info
	 * @return orgDestLocCd
	 */
	public String getOrgDestLocCd() {
		return this.orgDestLocCd;
	}
	
	/**
	 * Column Info
	 * @return orgDestRgnAllCd
	 */
	public String getOrgDestRgnAllCd() {
		return this.orgDestRgnAllCd;
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
	 * @return cvrgContiCd
	 */
	public String getCvrgContiCd() {
		return this.cvrgContiCd;
	}
	
	/**
	 * Column Info
	 * @return orgDestCntCd
	 */
	public String getOrgDestCntCd() {
		return this.orgDestCntCd;
	}
	
	/**
	 * Column Info
	 * @return cvrgLocCd
	 */
	public String getCvrgLocCd() {
		return this.cvrgLocCd;
	}
	

	/**
	 * Column Info
	 * @param cvrgCmbSeq
	 */
	public void setCvrgCmbSeq(String cvrgCmbSeq) {
		this.cvrgCmbSeq = cvrgCmbSeq;
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
	 * @param n1stCmncVerSeq
	 */
	public void setN1stCmncVerSeq(String n1stCmncVerSeq) {
		this.n1stCmncVerSeq = n1stCmncVerSeq;
	}
	
	/**
	 * Column Info
	 * @param orgDestRgnAllNm
	 */
	public void setOrgDestRgnAllNm(String orgDestRgnAllNm) {
		this.orgDestRgnAllNm = orgDestRgnAllNm;
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
	 * @param cvrgRgnCd
	 */
	public void setCvrgRgnCd(String cvrgRgnCd) {
		this.cvrgRgnCd = cvrgRgnCd;
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
	 * @param orgDestContiCd
	 */
	public void setOrgDestContiCd(String orgDestContiCd) {
		this.orgDestContiCd = orgDestContiCd;
	}
	
	/**
	 * Column Info
	 * @param cvrgSteCd
	 */
	public void setCvrgSteCd(String cvrgSteCd) {
		this.cvrgSteCd = cvrgSteCd;
	}
	
	/**
	 * Column Info
	 * @param rfaExptMapgSeq
	 */
	public void setRfaExptMapgSeq(String rfaExptMapgSeq) {
		this.rfaExptMapgSeq = rfaExptMapgSeq;
	}
	
	/**
	 * Column Info
	 * @param rfaExptDarNo
	 */
	public void setRfaExptDarNo(String rfaExptDarNo) {
		this.rfaExptDarNo = rfaExptDarNo;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rfaRqstDtlSeq
	 */
	public void setRfaRqstDtlSeq(String rfaRqstDtlSeq) {
		this.rfaRqstDtlSeq = rfaRqstDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param rfaExptVerSeq
	 */
	public void setRfaExptVerSeq(String rfaExptVerSeq) {
		this.rfaExptVerSeq = rfaExptVerSeq;
	}
	
	/**
	 * Column Info
	 * @param cvrgCntCd
	 */
	public void setCvrgCntCd(String cvrgCntCd) {
		this.cvrgCntCd = cvrgCntCd;
	}
	
	/**
	 * Column Info
	 * @param orgDestRgnCd
	 */
	public void setOrgDestRgnCd(String orgDestRgnCd) {
		this.orgDestRgnCd = orgDestRgnCd;
	}
	
	/**
	 * Column Info
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param orgDestCntAllCd
	 */
	public void setOrgDestCntAllCd(String orgDestCntAllCd) {
		this.orgDestCntAllCd = orgDestCntAllCd;
	}
	
	/**
	 * Column Info
	 * @param orgDestCntAllNm
	 */
	public void setOrgDestCntAllNm(String orgDestCntAllNm) {
		this.orgDestCntAllNm = orgDestCntAllNm;
	}
	
	/**
	 * Column Info
	 * @param orgDestSteCd
	 */
	public void setOrgDestSteCd(String orgDestSteCd) {
		this.orgDestSteCd = orgDestSteCd;
	}
	
	/**
	 * Column Info
	 * @param orgDestLocCd
	 */
	public void setOrgDestLocCd(String orgDestLocCd) {
		this.orgDestLocCd = orgDestLocCd;
	}
	
	/**
	 * Column Info
	 * @param orgDestRgnAllCd
	 */
	public void setOrgDestRgnAllCd(String orgDestRgnAllCd) {
		this.orgDestRgnAllCd = orgDestRgnAllCd;
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
	 * @param cvrgContiCd
	 */
	public void setCvrgContiCd(String cvrgContiCd) {
		this.cvrgContiCd = cvrgContiCd;
	}
	
	/**
	 * Column Info
	 * @param orgDestCntCd
	 */
	public void setOrgDestCntCd(String orgDestCntCd) {
		this.orgDestCntCd = orgDestCntCd;
	}
	
	/**
	 * Column Info
	 * @param cvrgLocCd
	 */
	public void setCvrgLocCd(String cvrgLocCd) {
		this.cvrgLocCd = cvrgLocCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCvrgCmbSeq(JSPUtil.getParameter(request, "cvrg_cmb_seq", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setN1stCmncVerSeq(JSPUtil.getParameter(request, "n1st_cmnc_ver_seq", ""));
		setOrgDestRgnAllNm(JSPUtil.getParameter(request, "org_dest_rgn_all_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCvrgRgnCd(JSPUtil.getParameter(request, "cvrg_rgn_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOrgDestContiCd(JSPUtil.getParameter(request, "org_dest_conti_cd", ""));
		setCvrgSteCd(JSPUtil.getParameter(request, "cvrg_ste_cd", ""));
		setRfaExptMapgSeq(JSPUtil.getParameter(request, "rfa_expt_mapg_seq", ""));
		setRfaExptDarNo(JSPUtil.getParameter(request, "rfa_expt_dar_no", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setRfaRqstDtlSeq(JSPUtil.getParameter(request, "rfa_rqst_dtl_seq", ""));
		setRfaExptVerSeq(JSPUtil.getParameter(request, "rfa_expt_ver_seq", ""));
		setCvrgCntCd(JSPUtil.getParameter(request, "cvrg_cnt_cd", ""));
		setOrgDestRgnCd(JSPUtil.getParameter(request, "org_dest_rgn_cd", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, "upd_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setOrgDestCntAllCd(JSPUtil.getParameter(request, "org_dest_cnt_all_cd", ""));
		setOrgDestCntAllNm(JSPUtil.getParameter(request, "org_dest_cnt_all_nm", ""));
		setOrgDestSteCd(JSPUtil.getParameter(request, "org_dest_ste_cd", ""));
		setOrgDestLocCd(JSPUtil.getParameter(request, "org_dest_loc_cd", ""));
		setOrgDestRgnAllCd(JSPUtil.getParameter(request, "org_dest_rgn_all_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCvrgContiCd(JSPUtil.getParameter(request, "cvrg_conti_cd", ""));
		setOrgDestCntCd(JSPUtil.getParameter(request, "org_dest_cnt_cd", ""));
		setCvrgLocCd(JSPUtil.getParameter(request, "cvrg_loc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RFAExceptionCoverageVO[]
	 */
	public RFAExceptionCoverageVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RFAExceptionCoverageVO[]
	 */
	public RFAExceptionCoverageVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RFAExceptionCoverageVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cvrgCmbSeq = (JSPUtil.getParameter(request, prefix	+ "cvrg_cmb_seq".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] n1stCmncVerSeq = (JSPUtil.getParameter(request, prefix	+ "n1st_cmnc_ver_seq".trim(), length));
			String[] orgDestRgnAllNm = (JSPUtil.getParameter(request, prefix	+ "org_dest_rgn_all_nm".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] cvrgRgnCd = (JSPUtil.getParameter(request, prefix	+ "cvrg_rgn_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] orgDestContiCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_conti_cd".trim(), length));
			String[] cvrgSteCd = (JSPUtil.getParameter(request, prefix	+ "cvrg_ste_cd".trim(), length));
			String[] rfaExptMapgSeq = (JSPUtil.getParameter(request, prefix	+ "rfa_expt_mapg_seq".trim(), length));
			String[] rfaExptDarNo = (JSPUtil.getParameter(request, prefix	+ "rfa_expt_dar_no".trim(), length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd".trim(), length));
			String[] rfaRqstDtlSeq = (JSPUtil.getParameter(request, prefix	+ "rfa_rqst_dtl_seq".trim(), length));
			String[] rfaExptVerSeq = (JSPUtil.getParameter(request, prefix	+ "rfa_expt_ver_seq".trim(), length));
			String[] cvrgCntCd = (JSPUtil.getParameter(request, prefix	+ "cvrg_cnt_cd".trim(), length));
			String[] orgDestRgnCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_rgn_cd".trim(), length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] orgDestCntAllCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_cnt_all_cd".trim(), length));
			String[] orgDestCntAllNm = (JSPUtil.getParameter(request, prefix	+ "org_dest_cnt_all_nm".trim(), length));
			String[] orgDestSteCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_ste_cd".trim(), length));
			String[] orgDestLocCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_loc_cd".trim(), length));
			String[] orgDestRgnAllCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_rgn_all_cd".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] cvrgContiCd = (JSPUtil.getParameter(request, prefix	+ "cvrg_conti_cd".trim(), length));
			String[] orgDestCntCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_cnt_cd".trim(), length));
			String[] cvrgLocCd = (JSPUtil.getParameter(request, prefix	+ "cvrg_loc_cd".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new RFAExceptionCoverageVO();
				if (cvrgCmbSeq[i] != null)
					model.setCvrgCmbSeq(cvrgCmbSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (n1stCmncVerSeq[i] != null)
					model.setN1stCmncVerSeq(n1stCmncVerSeq[i]);
				if (orgDestRgnAllNm[i] != null)
					model.setOrgDestRgnAllNm(orgDestRgnAllNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cvrgRgnCd[i] != null)
					model.setCvrgRgnCd(cvrgRgnCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (orgDestContiCd[i] != null)
					model.setOrgDestContiCd(orgDestContiCd[i]);
				if (cvrgSteCd[i] != null)
					model.setCvrgSteCd(cvrgSteCd[i]);
				if (rfaExptMapgSeq[i] != null)
					model.setRfaExptMapgSeq(rfaExptMapgSeq[i]);
				if (rfaExptDarNo[i] != null)
					model.setRfaExptDarNo(rfaExptDarNo[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (rfaRqstDtlSeq[i] != null)
					model.setRfaRqstDtlSeq(rfaRqstDtlSeq[i]);
				if (rfaExptVerSeq[i] != null)
					model.setRfaExptVerSeq(rfaExptVerSeq[i]);
				if (cvrgCntCd[i] != null)
					model.setCvrgCntCd(cvrgCntCd[i]);
				if (orgDestRgnCd[i] != null)
					model.setOrgDestRgnCd(orgDestRgnCd[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (orgDestCntAllCd[i] != null)
					model.setOrgDestCntAllCd(orgDestCntAllCd[i]);
				if (orgDestCntAllNm[i] != null)
					model.setOrgDestCntAllNm(orgDestCntAllNm[i]);
				if (orgDestSteCd[i] != null)
					model.setOrgDestSteCd(orgDestSteCd[i]);
				if (orgDestLocCd[i] != null)
					model.setOrgDestLocCd(orgDestLocCd[i]);
				if (orgDestRgnAllCd[i] != null)
					model.setOrgDestRgnAllCd(orgDestRgnAllCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cvrgContiCd[i] != null)
					model.setCvrgContiCd(cvrgContiCd[i]);
				if (orgDestCntCd[i] != null)
					model.setOrgDestCntCd(orgDestCntCd[i]);
				if (cvrgLocCd[i] != null)
					model.setCvrgLocCd(cvrgLocCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRFAExceptionCoverageVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RFAExceptionCoverageVO[]
	 */
	public RFAExceptionCoverageVO[] getRFAExceptionCoverageVOs(){
		RFAExceptionCoverageVO[] vos = (RFAExceptionCoverageVO[])models.toArray(new RFAExceptionCoverageVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.cvrgCmbSeq = this.cvrgCmbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stCmncVerSeq = this.n1stCmncVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestRgnAllNm = this.orgDestRgnAllNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgRgnCd = this.cvrgRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestContiCd = this.orgDestContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgSteCd = this.cvrgSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaExptMapgSeq = this.rfaExptMapgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaExptDarNo = this.rfaExptDarNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaRqstDtlSeq = this.rfaRqstDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaExptVerSeq = this.rfaExptVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgCntCd = this.cvrgCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestRgnCd = this.orgDestRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestCntAllCd = this.orgDestCntAllCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestCntAllNm = this.orgDestCntAllNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestSteCd = this.orgDestSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestLocCd = this.orgDestLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestRgnAllCd = this.orgDestRgnAllCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgContiCd = this.cvrgContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestCntCd = this.orgDestCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgLocCd = this.cvrgLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
