/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchContinentParamVO.java
*@FileTitle : SearchContinentParamVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.07.22 김태균 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김태균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchContinentParamVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchContinentParamVO> models = new ArrayList<SearchContinentParamVO>();
	
	/* Column Info */
	private String validity4 = null;
	/* Column Info */
	private String validity3 = null;
	/* Column Info */
	private String validity2 = null;
	/* Column Info */
	private String cvrgYdCd = null;
	/* Column Info */
	private String dmdtTrfCdIn = null;
	/* Column Info */
	private String dmdtCntrTpList = null;
	/* Column Info */
	private String dmdtCntrTpCdIn = null;
	/* Column Info */
	private String orgDestLocCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cvrgRgnCd = null;
	/* Column Info */
	private String orgDestContiCd = null;
	/* Column Info */
	private String dmdtTrfCdList = null;
	/* Column Info */
	private String uiCode = null;
	/* Column Info */
	private String validity1 = null;
	/* Column Info */
	private String dmdtCgoTpCdIn = null;
	/* Column Info */
	private String cvrgContiCd = null;
	/* Column Info */
	private String dmdtCntrCgoList = null;
	/* Column Info */
	private String cvrgCntCd = null;
	/* Column Info */
	private String orgDestCntCd = null;
	/* Column Info */
	private String orgDestRgnCd = null;
	/* Column Info */
	private String cvrgLocCd = null;
	/* Column Info */
	private String dmdtCgoTpList = null;
	/* Column Info */
	private String dmdtDeTermCd = null;
	/* Column Info */
	private String dmdtDeTermNm = null;
	/* Column Info */
	private String exist = null;
	/* Column Info */
	private String billExem = null;
	/* Column Info */
	private String expOfcCd = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchContinentParamVO() {}

	public SearchContinentParamVO(String ibflag, String pagerows, String cvrgContiCd, String cvrgCntCd, String cvrgRgnCd, String cvrgLocCd, String cvrgYdCd, String orgDestContiCd, String orgDestCntCd, String orgDestRgnCd, String orgDestLocCd, String dmdtTrfCdIn, String dmdtTrfCdList, String dmdtCntrCgoList, String dmdtCntrTpCdIn, String dmdtCntrTpList, String dmdtCgoTpCdIn, String dmdtCgoTpList, String dmdtDeTermCd, String validity1, String validity2, String validity3, String validity4, String uiCode, String dmdtDeTermNm, String exist, String billExem, String expOfcCd) {
		this.validity4 = validity4;
		this.validity3 = validity3;
		this.validity2 = validity2;
		this.cvrgYdCd = cvrgYdCd;
		this.dmdtTrfCdIn = dmdtTrfCdIn;
		this.dmdtCntrTpList = dmdtCntrTpList;
		this.dmdtCntrTpCdIn = dmdtCntrTpCdIn;
		this.orgDestLocCd = orgDestLocCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.cvrgRgnCd = cvrgRgnCd;
		this.orgDestContiCd = orgDestContiCd;
		this.dmdtTrfCdList = dmdtTrfCdList;
		this.uiCode = uiCode;
		this.validity1 = validity1;
		this.dmdtCgoTpCdIn = dmdtCgoTpCdIn;
		this.cvrgContiCd = cvrgContiCd;
		this.dmdtCntrCgoList = dmdtCntrCgoList;
		this.cvrgCntCd = cvrgCntCd;
		this.orgDestCntCd = orgDestCntCd;
		this.orgDestRgnCd = orgDestRgnCd;
		this.cvrgLocCd = cvrgLocCd;
		this.dmdtCgoTpList = dmdtCgoTpList;
		this.dmdtDeTermCd = dmdtDeTermCd;
		this.dmdtDeTermNm = dmdtDeTermNm;
		this.exist = exist;
		this.billExem = billExem;
		this.expOfcCd = expOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("validity4", getValidity4());
		this.hashColumns.put("validity3", getValidity3());
		this.hashColumns.put("validity2", getValidity2());
		this.hashColumns.put("cvrg_yd_cd", getCvrgYdCd());
		this.hashColumns.put("dmdt_trf_cd_in", getDmdtTrfCdIn());
		this.hashColumns.put("dmdt_cntr_tp_list", getDmdtCntrTpList());
		this.hashColumns.put("dmdt_cntr_tp_cd_in", getDmdtCntrTpCdIn());
		this.hashColumns.put("org_dest_loc_cd", getOrgDestLocCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cvrg_rgn_cd", getCvrgRgnCd());
		this.hashColumns.put("org_dest_conti_cd", getOrgDestContiCd());
		this.hashColumns.put("dmdt_trf_cd_list", getDmdtTrfCdList());
		this.hashColumns.put("ui_code", getUiCode());
		this.hashColumns.put("validity1", getValidity1());
		this.hashColumns.put("dmdt_cgo_tp_cd_in", getDmdtCgoTpCdIn());
		this.hashColumns.put("cvrg_conti_cd", getCvrgContiCd());
		this.hashColumns.put("dmdt_cntr_cgo_list", getDmdtCntrCgoList());
		this.hashColumns.put("cvrg_cnt_cd", getCvrgCntCd());
		this.hashColumns.put("org_dest_cnt_cd", getOrgDestCntCd());
		this.hashColumns.put("org_dest_rgn_cd", getOrgDestRgnCd());
		this.hashColumns.put("cvrg_loc_cd", getCvrgLocCd());
		this.hashColumns.put("dmdt_cgo_tp_list", getDmdtCgoTpList());
		this.hashColumns.put("dmdt_de_term_cd", getDmdtDeTermCd());
		this.hashColumns.put("dmdt_de_term_nm", getDmdtDeTermNm());
		this.hashColumns.put("exist", getExist());
		this.hashColumns.put("bill_exem", getBillExem());
		this.hashColumns.put("exp_ofc_cd", getExpOfcCd());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("validity4", "validity4");
		this.hashFields.put("validity3", "validity3");
		this.hashFields.put("validity2", "validity2");
		this.hashFields.put("cvrg_yd_cd", "cvrgYdCd");
		this.hashFields.put("dmdt_trf_cd_in", "dmdtTrfCdIn");
		this.hashFields.put("dmdt_cntr_tp_list", "dmdtCntrTpList");
		this.hashFields.put("dmdt_cntr_tp_cd_in", "dmdtCntrTpCdIn");
		this.hashFields.put("org_dest_loc_cd", "orgDestLocCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cvrg_rgn_cd", "cvrgRgnCd");
		this.hashFields.put("org_dest_conti_cd", "orgDestContiCd");
		this.hashFields.put("dmdt_trf_cd_list", "dmdtTrfCdList");
		this.hashFields.put("ui_code", "uiCode");
		this.hashFields.put("validity1", "validity1");
		this.hashFields.put("dmdt_cgo_tp_cd_in", "dmdtCgoTpCdIn");
		this.hashFields.put("cvrg_conti_cd", "cvrgContiCd");
		this.hashFields.put("dmdt_cntr_cgo_list", "dmdtCntrCgoList");
		this.hashFields.put("cvrg_cnt_cd", "cvrgCntCd");
		this.hashFields.put("org_dest_cnt_cd", "orgDestCntCd");
		this.hashFields.put("org_dest_rgn_cd", "orgDestRgnCd");
		this.hashFields.put("cvrg_loc_cd", "cvrgLocCd");
		this.hashFields.put("dmdt_cgo_tp_list", "dmdtCgoTpList");
		this.hashFields.put("dmdt_de_term_cd", "dmdtDeTermCd");
		this.hashFields.put("dmdt_de_term_nm", "dmdtDeTermNm");
		this.hashFields.put("exist", "exist");
		this.hashFields.put("bill_exem", "billExem");
		this.hashFields.put("exp_ofc_cd", "expOfcCd");

		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return validity4
	 */
	public String getValidity4() {
		return this.validity4;
	}
	
	/**
	 * Column Info
	 * @return validity3
	 */
	public String getValidity3() {
		return this.validity3;
	}
	
	/**
	 * Column Info
	 * @return validity2
	 */
	public String getValidity2() {
		return this.validity2;
	}
	
	/**
	 * Column Info
	 * @return cvrgYdCd
	 */
	public String getCvrgYdCd() {
		return this.cvrgYdCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfCdIn
	 */
	public String getDmdtTrfCdIn() {
		return this.dmdtTrfCdIn;
	}
	
	/**
	 * Column Info
	 * @return dmdtCntrTpList
	 */
	public String getDmdtCntrTpList() {
		return this.dmdtCntrTpList;
	}
	
	/**
	 * Column Info
	 * @return dmdtCntrTpCdIn
	 */
	public String getDmdtCntrTpCdIn() {
		return this.dmdtCntrTpCdIn;
	}
	
	/**
	 * Column Info
	 * @return orgDestLocCd
	 */
	public String getOrgDestLocCd() {
		return this.orgDestLocCd;
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
	 * @return cvrgRgnCd
	 */
	public String getCvrgRgnCd() {
		return this.cvrgRgnCd;
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
	 * @return dmdtTrfCdList
	 */
	public String getDmdtTrfCdList() {
		return this.dmdtTrfCdList;
	}
	
	/**
	 * Column Info
	 * @return uiCode
	 */
	public String getUiCode() {
		return this.uiCode;
	}
	
	/**
	 * Column Info
	 * @return validity1
	 */
	public String getValidity1() {
		return this.validity1;
	}
	
	/**
	 * Column Info
	 * @return dmdtCgoTpCdIn
	 */
	public String getDmdtCgoTpCdIn() {
		return this.dmdtCgoTpCdIn;
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
	 * @return dmdtCntrCgoList
	 */
	public String getDmdtCntrCgoList() {
		return this.dmdtCntrCgoList;
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
	 * @return orgDestCntCd
	 */
	public String getOrgDestCntCd() {
		return this.orgDestCntCd;
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
	 * @return cvrgLocCd
	 */
	public String getCvrgLocCd() {
		return this.cvrgLocCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtCgoTpList
	 */
	public String getDmdtCgoTpList() {
		return this.dmdtCgoTpList;
	}
	
	/**
	 * Column Info
	 * @return dmdtDeTermCd
	 */
	public String getDmdtDeTermCd() {
		return this.dmdtDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtDeTermNm
	 */
	public String getDmdtDeTermNm() {
		return this.dmdtDeTermNm;
	}
	
	/**
	 * Column Info
	 * @param validity4
	 */
	public void setValidity4(String validity4) {
		this.validity4 = validity4;
	}
	
	/**
	 * Column Info
	 * @param validity3
	 */
	public void setValidity3(String validity3) {
		this.validity3 = validity3;
	}
	
	/**
	 * Column Info
	 * @param validity2
	 */
	public void setValidity2(String validity2) {
		this.validity2 = validity2;
	}
	
	/**
	 * Column Info
	 * @param cvrgYdCd
	 */
	public void setCvrgYdCd(String cvrgYdCd) {
		this.cvrgYdCd = cvrgYdCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfCdIn
	 */
	public void setDmdtTrfCdIn(String dmdtTrfCdIn) {
		this.dmdtTrfCdIn = dmdtTrfCdIn;
	}
	
	/**
	 * Column Info
	 * @param dmdtCntrTpList
	 */
	public void setDmdtCntrTpList(String dmdtCntrTpList) {
		this.dmdtCntrTpList = dmdtCntrTpList;
	}
	
	/**
	 * Column Info
	 * @param dmdtCntrTpCdIn
	 */
	public void setDmdtCntrTpCdIn(String dmdtCntrTpCdIn) {
		this.dmdtCntrTpCdIn = dmdtCntrTpCdIn;
	}
	
	/**
	 * Column Info
	 * @param orgDestLocCd
	 */
	public void setOrgDestLocCd(String orgDestLocCd) {
		this.orgDestLocCd = orgDestLocCd;
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
	 * @param cvrgRgnCd
	 */
	public void setCvrgRgnCd(String cvrgRgnCd) {
		this.cvrgRgnCd = cvrgRgnCd;
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
	 * @param dmdtTrfCdList
	 */
	public void setDmdtTrfCdList(String dmdtTrfCdList) {
		this.dmdtTrfCdList = dmdtTrfCdList;
	}
	
	/**
	 * Column Info
	 * @param uiCode
	 */
	public void setUiCode(String uiCode) {
		this.uiCode = uiCode;
	}
	
	/**
	 * Column Info
	 * @param validity1
	 */
	public void setValidity1(String validity1) {
		this.validity1 = validity1;
	}
	
	/**
	 * Column Info
	 * @param dmdtCgoTpCdIn
	 */
	public void setDmdtCgoTpCdIn(String dmdtCgoTpCdIn) {
		this.dmdtCgoTpCdIn = dmdtCgoTpCdIn;
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
	 * @param dmdtCntrCgoList
	 */
	public void setDmdtCntrCgoList(String dmdtCntrCgoList) {
		this.dmdtCntrCgoList = dmdtCntrCgoList;
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
	 * @param orgDestCntCd
	 */
	public void setOrgDestCntCd(String orgDestCntCd) {
		this.orgDestCntCd = orgDestCntCd;
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
	 * @param cvrgLocCd
	 */
	public void setCvrgLocCd(String cvrgLocCd) {
		this.cvrgLocCd = cvrgLocCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtCgoTpList
	 */
	public void setDmdtCgoTpList(String dmdtCgoTpList) {
		this.dmdtCgoTpList = dmdtCgoTpList;
	}
	
	/**
	 * Column Info
	 * @param dmdtDeTermCd
	 */
	public void setDmdtDeTermCd(String dmdtDeTermCd) {
		this.dmdtDeTermCd = dmdtDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtDeTermNm
	 */
	public void setDmdtDeTermNm(String dmdtDeTermNm) {
		this.dmdtDeTermNm = dmdtDeTermNm;
	}
	
	public String getExist() {
		return exist;
	}

	public void setExist(String exist) {
		this.exist = exist;
	}

	public String getBillExem() {
		return billExem;
	}

	public void setBillExem(String billExem) {
		this.billExem = billExem;
	}

	public String getExpOfcCd() {
		return expOfcCd;
	}

	public void setExpOfcCd(String expOfcCd) {
		this.expOfcCd = expOfcCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setValidity4(JSPUtil.getParameter(request, "validity4", ""));
		setValidity3(JSPUtil.getParameter(request, "validity3", ""));
		setValidity2(JSPUtil.getParameter(request, "validity2", ""));
		setCvrgYdCd(JSPUtil.getParameter(request, "cvrg_yd_cd", ""));
		setDmdtTrfCdIn(JSPUtil.getParameter(request, "dmdt_trf_cd_in", ""));
		setDmdtCntrTpList(JSPUtil.getParameter(request, "dmdt_cntr_tp_list", ""));
		setDmdtCntrTpCdIn(JSPUtil.getParameter(request, "dmdt_cntr_tp_cd_in", ""));
		setOrgDestLocCd(JSPUtil.getParameter(request, "org_dest_loc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCvrgRgnCd(JSPUtil.getParameter(request, "cvrg_rgn_cd", ""));
		setOrgDestContiCd(JSPUtil.getParameter(request, "org_dest_conti_cd", ""));
		setDmdtTrfCdList(JSPUtil.getParameter(request, "dmdt_trf_cd_list", ""));
		setUiCode(JSPUtil.getParameter(request, "ui_code", ""));
		setValidity1(JSPUtil.getParameter(request, "validity1", ""));
		setDmdtCgoTpCdIn(JSPUtil.getParameter(request, "dmdt_cgo_tp_cd_in", ""));
		setCvrgContiCd(JSPUtil.getParameter(request, "cvrg_conti_cd", ""));
		setDmdtCntrCgoList(JSPUtil.getParameter(request, "dmdt_cntr_cgo_list", ""));
		setCvrgCntCd(JSPUtil.getParameter(request, "cvrg_cnt_cd", ""));
		setOrgDestCntCd(JSPUtil.getParameter(request, "org_dest_cnt_cd", ""));
		setOrgDestRgnCd(JSPUtil.getParameter(request, "org_dest_rgn_cd", ""));
		setCvrgLocCd(JSPUtil.getParameter(request, "cvrg_loc_cd", ""));
		setDmdtCgoTpList(JSPUtil.getParameter(request, "dmdt_cgo_tp_list", ""));
		setDmdtDeTermCd(JSPUtil.getParameter(request, "dmdt_de_term_cd", ""));
		setDmdtDeTermNm(JSPUtil.getParameter(request, "dmdt_de_term_nm", ""));
		setExist(JSPUtil.getParameter(request, "exist", ""));
		setBillExem(JSPUtil.getParameter(request, "bill_exem", ""));
		setExpOfcCd(JSPUtil.getParameter(request, "exp_ofc_cd", ""));

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchContinentParamVO[]
	 */
	public SearchContinentParamVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchContinentParamVO[]
	 */
	public SearchContinentParamVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchContinentParamVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] validity4 = (JSPUtil.getParameter(request, prefix	+ "validity4", length));
			String[] validity3 = (JSPUtil.getParameter(request, prefix	+ "validity3", length));
			String[] validity2 = (JSPUtil.getParameter(request, prefix	+ "validity2", length));
			String[] cvrgYdCd = (JSPUtil.getParameter(request, prefix	+ "cvrg_yd_cd", length));
			String[] dmdtTrfCdIn = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd_in", length));
			String[] dmdtCntrTpList = (JSPUtil.getParameter(request, prefix	+ "dmdt_cntr_tp_list", length));
			String[] dmdtCntrTpCdIn = (JSPUtil.getParameter(request, prefix	+ "dmdt_cntr_tp_cd_in", length));
			String[] orgDestLocCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_loc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cvrgRgnCd = (JSPUtil.getParameter(request, prefix	+ "cvrg_rgn_cd", length));
			String[] orgDestContiCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_conti_cd", length));
			String[] dmdtTrfCdList = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd_list", length));
			String[] uiCode = (JSPUtil.getParameter(request, prefix	+ "ui_code", length));
			String[] validity1 = (JSPUtil.getParameter(request, prefix	+ "validity1", length));
			String[] dmdtCgoTpCdIn = (JSPUtil.getParameter(request, prefix	+ "dmdt_cgo_tp_cd_in", length));
			String[] cvrgContiCd = (JSPUtil.getParameter(request, prefix	+ "cvrg_conti_cd", length));
			String[] dmdtCntrCgoList = (JSPUtil.getParameter(request, prefix	+ "dmdt_cntr_cgo_list", length));
			String[] cvrgCntCd = (JSPUtil.getParameter(request, prefix	+ "cvrg_cnt_cd", length));
			String[] orgDestCntCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_cnt_cd", length));
			String[] orgDestRgnCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_rgn_cd", length));
			String[] cvrgLocCd = (JSPUtil.getParameter(request, prefix	+ "cvrg_loc_cd", length));
			String[] dmdtCgoTpList = (JSPUtil.getParameter(request, prefix	+ "dmdt_cgo_tp_list", length));
			String[] dmdtDeTermCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_de_term_cd", length));
			String[] dmdtDeTermNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_de_term_nm", length));
			String[] exist = (JSPUtil.getParameter(request, prefix	+ "exist", length));
			String[] billExem = (JSPUtil.getParameter(request, prefix	+ "bill_exem", length));
			String[] expOfcCd = (JSPUtil.getParameter(request, prefix	+ "exp_ofc_cd", length));

			for (int i = 0; i < length; i++) {
				model = new SearchContinentParamVO();
				if (validity4[i] != null)
					model.setValidity4(validity4[i]);
				if (validity3[i] != null)
					model.setValidity3(validity3[i]);
				if (validity2[i] != null)
					model.setValidity2(validity2[i]);
				if (cvrgYdCd[i] != null)
					model.setCvrgYdCd(cvrgYdCd[i]);
				if (dmdtTrfCdIn[i] != null)
					model.setDmdtTrfCdIn(dmdtTrfCdIn[i]);
				if (dmdtCntrTpList[i] != null)
					model.setDmdtCntrTpList(dmdtCntrTpList[i]);
				if (dmdtCntrTpCdIn[i] != null)
					model.setDmdtCntrTpCdIn(dmdtCntrTpCdIn[i]);
				if (orgDestLocCd[i] != null)
					model.setOrgDestLocCd(orgDestLocCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cvrgRgnCd[i] != null)
					model.setCvrgRgnCd(cvrgRgnCd[i]);
				if (orgDestContiCd[i] != null)
					model.setOrgDestContiCd(orgDestContiCd[i]);
				if (dmdtTrfCdList[i] != null)
					model.setDmdtTrfCdList(dmdtTrfCdList[i]);
				if (uiCode[i] != null)
					model.setUiCode(uiCode[i]);
				if (validity1[i] != null)
					model.setValidity1(validity1[i]);
				if (dmdtCgoTpCdIn[i] != null)
					model.setDmdtCgoTpCdIn(dmdtCgoTpCdIn[i]);
				if (cvrgContiCd[i] != null)
					model.setCvrgContiCd(cvrgContiCd[i]);
				if (dmdtCntrCgoList[i] != null)
					model.setDmdtCntrCgoList(dmdtCntrCgoList[i]);
				if (cvrgCntCd[i] != null)
					model.setCvrgCntCd(cvrgCntCd[i]);
				if (orgDestCntCd[i] != null)
					model.setOrgDestCntCd(orgDestCntCd[i]);
				if (orgDestRgnCd[i] != null)
					model.setOrgDestRgnCd(orgDestRgnCd[i]);
				if (cvrgLocCd[i] != null)
					model.setCvrgLocCd(cvrgLocCd[i]);
				if (dmdtCgoTpList[i] != null)
					model.setDmdtCgoTpList(dmdtCgoTpList[i]);
				if (dmdtDeTermCd[i] != null)
					model.setDmdtDeTermCd(dmdtDeTermCd[i]);
				if (dmdtDeTermNm[i] != null)
					model.setDmdtDeTermNm(dmdtDeTermNm[i]);	
				if (exist[i] != null)
					model.setExist(exist[i]);	
				if (billExem[i] != null)
					model.setBillExem(billExem[i]);	
				if (expOfcCd[i] != null)
					model.setExpOfcCd(expOfcCd[i]);	
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchContinentParamVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchContinentParamVO[]
	 */
	public SearchContinentParamVO[] getSearchContinentParamVOs(){
		SearchContinentParamVO[] vos = (SearchContinentParamVO[])models.toArray(new SearchContinentParamVO[models.size()]);
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
		this.validity4 = this.validity4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.validity3 = this.validity3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.validity2 = this.validity2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgYdCd = this.cvrgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCdIn = this.dmdtTrfCdIn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCntrTpList = this.dmdtCntrTpList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCntrTpCdIn = this.dmdtCntrTpCdIn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestLocCd = this.orgDestLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgRgnCd = this.cvrgRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestContiCd = this.orgDestContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCdList = this.dmdtTrfCdList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uiCode = this.uiCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.validity1 = this.validity1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCgoTpCdIn = this.dmdtCgoTpCdIn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgContiCd = this.cvrgContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCntrCgoList = this.dmdtCntrCgoList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgCntCd = this.cvrgCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestCntCd = this.orgDestCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestRgnCd = this.orgDestRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgLocCd = this.cvrgLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCgoTpList = this.dmdtCgoTpList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtDeTermCd = this.dmdtDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtDeTermNm = this.dmdtDeTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exist = this.exist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.billExem = this.billExem .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expOfcCd = this.expOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
