/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CtmMvmtIrrVO.java
*@FileTitle : CtmMvmtIrrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.06.01 우경민
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo;

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
 * @author 우경민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CtmMvmtIrrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<CtmMvmtIrrVO> models = new ArrayList<CtmMvmtIrrVO>();

	/* Column Info */
	private String preCnmvEvntDt = null;
	/* Column Info */
	private String preCnmvStsCd = null;
	/* Column Info */
	private String preOrgYdCd = null;
	/* Column Info */
	private String cnmvEvntDt = null;
	/* Column Info */
	private String orgYdCd = null;
	/* Column Info */
	private String pIrrtype = null;
	/* Column Info */
	private String cnmvIrrStlFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pDate1 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* Column Info */
	private String pDate2 = null;
	/* Column Info */
	private String pYard2 = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String pYard1 = null;
	/* Column Info */
	private String pOffice = null;
	/* Column Info */
	private String bkgNo1 = null;
	/* Column Info */
	private String bkgNo2 = null;
	/* Column Info */
	private String bkgSplit1 = null;
	/* Column Info */
	private String pSettled = null;
	/* Column Info */
	private String cntrBkgAtchCd = null;
	/* Column Info */
	private String bkgSplit2 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public CtmMvmtIrrVO() {}

	public CtmMvmtIrrVO(String ibflag, String pagerows, String locCd, String orgYdCd, String cntrBkgAtchCd, String cnmvIrrStlFlg, String cntrNo, String cntrTpszCd, String cnmvStsCd, String bkgNo1, String bkgSplit1, String cnmvEvntDt, String preCnmvStsCd, String preOrgYdCd, String bkgNo2, String bkgSplit2, String preCnmvEvntDt, String pOffice, String pYard1, String pYard2, String pDate1, String pDate2, String pIrrtype, String pSettled) {
		this.preCnmvEvntDt = preCnmvEvntDt;
		this.preCnmvStsCd = preCnmvStsCd;
		this.preOrgYdCd = preOrgYdCd;
		this.cnmvEvntDt = cnmvEvntDt;
		this.orgYdCd = orgYdCd;
		this.pIrrtype = pIrrtype;
		this.cnmvIrrStlFlg = cnmvIrrStlFlg;
		this.pagerows = pagerows;
		this.pDate1 = pDate1;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.cnmvStsCd = cnmvStsCd;
		this.pDate2 = pDate2;
		this.pYard2 = pYard2;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.pYard1 = pYard1;
		this.pOffice = pOffice;
		this.bkgNo1 = bkgNo1;
		this.bkgNo2 = bkgNo2;
		this.bkgSplit1 = bkgSplit1;
		this.pSettled = pSettled;
		this.cntrBkgAtchCd = cntrBkgAtchCd;
		this.bkgSplit2 = bkgSplit2;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pre_cnmv_evnt_dt", getPreCnmvEvntDt());
		this.hashColumns.put("pre_cnmv_sts_cd", getPreCnmvStsCd());
		this.hashColumns.put("pre_org_yd_cd", getPreOrgYdCd());
		this.hashColumns.put("cnmv_evnt_dt", getCnmvEvntDt());
		this.hashColumns.put("org_yd_cd", getOrgYdCd());
		this.hashColumns.put("p_irrtype", getPIrrtype());
		this.hashColumns.put("cnmv_irr_stl_flg", getCnmvIrrStlFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("p_date1", getPDate1());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("p_date2", getPDate2());
		this.hashColumns.put("p_yard2", getPYard2());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("p_yard1", getPYard1());
		this.hashColumns.put("p_office", getPOffice());
		this.hashColumns.put("bkg_no1", getBkgNo1());
		this.hashColumns.put("bkg_no2", getBkgNo2());
		this.hashColumns.put("bkg_split1", getBkgSplit1());
		this.hashColumns.put("p_settled", getPSettled());
		this.hashColumns.put("cntr_bkg_atch_cd", getCntrBkgAtchCd());
		this.hashColumns.put("bkg_split2", getBkgSplit2());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pre_cnmv_evnt_dt", "preCnmvEvntDt");
		this.hashFields.put("pre_cnmv_sts_cd", "preCnmvStsCd");
		this.hashFields.put("pre_org_yd_cd", "preOrgYdCd");
		this.hashFields.put("cnmv_evnt_dt", "cnmvEvntDt");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("p_irrtype", "pIrrtype");
		this.hashFields.put("cnmv_irr_stl_flg", "cnmvIrrStlFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("p_date1", "pDate1");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("p_date2", "pDate2");
		this.hashFields.put("p_yard2", "pYard2");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("p_yard1", "pYard1");
		this.hashFields.put("p_office", "pOffice");
		this.hashFields.put("bkg_no1", "bkgNo1");
		this.hashFields.put("bkg_no2", "bkgNo2");
		this.hashFields.put("bkg_split1", "bkgSplit1");
		this.hashFields.put("p_settled", "pSettled");
		this.hashFields.put("cntr_bkg_atch_cd", "cntrBkgAtchCd");
		this.hashFields.put("bkg_split2", "bkgSplit2");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return preCnmvEvntDt
	 */
	public String getPreCnmvEvntDt() {
		return this.preCnmvEvntDt;
	}

	/**
	 * Column Info
	 * @return preCnmvStsCd
	 */
	public String getPreCnmvStsCd() {
		return this.preCnmvStsCd;
	}

	/**
	 * Column Info
	 * @return preOrgYdCd
	 */
	public String getPreOrgYdCd() {
		return this.preOrgYdCd;
	}

	/**
	 * Column Info
	 * @return cnmvEvntDt
	 */
	public String getCnmvEvntDt() {
		return this.cnmvEvntDt;
	}

	/**
	 * Column Info
	 * @return orgYdCd
	 */
	public String getOrgYdCd() {
		return this.orgYdCd;
	}

	/**
	 * Column Info
	 * @return pIrrtype
	 */
	public String getPIrrtype() {
		return this.pIrrtype;
	}

	/**
	 * Column Info
	 * @return cnmvIrrStlFlg
	 */
	public String getCnmvIrrStlFlg() {
		return this.cnmvIrrStlFlg;
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
	 * @return pDate1
	 */
	public String getPDate1() {
		return this.pDate1;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}

	/**
	 * Column Info
	 * @return cnmvStsCd
	 */
	public String getCnmvStsCd() {
		return this.cnmvStsCd;
	}

	/**
	 * Column Info
	 * @return pDate2
	 */
	public String getPDate2() {
		return this.pDate2;
	}

	/**
	 * Column Info
	 * @return pYard2
	 */
	public String getPYard2() {
		return this.pYard2;
	}

	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}

	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}

	/**
	 * Column Info
	 * @return pYard1
	 */
	public String getPYard1() {
		return this.pYard1;
	}

	/**
	 * Column Info
	 * @return pOffice
	 */
	public String getPOffice() {
		return this.pOffice;
	}

	/**
	 * Column Info
	 * @return bkgNo1
	 */
	public String getBkgNo1() {
		return this.bkgNo1;
	}

	/**
	 * Column Info
	 * @return bkgNo2
	 */
	public String getBkgNo2() {
		return this.bkgNo2;
	}

	/**
	 * Column Info
	 * @return bkgSplit1
	 */
	public String getBkgSplit1() {
		return this.bkgSplit1;
	}

	/**
	 * Column Info
	 * @return pSettled
	 */
	public String getPSettled() {
		return this.pSettled;
	}

	/**
	 * Column Info
	 * @return cntrBkgAtchCd
	 */
	public String getCntrBkgAtchCd() {
		return this.cntrBkgAtchCd;
	}

	/**
	 * Column Info
	 * @return bkgSplit2
	 */
	public String getBkgSplit2() {
		return this.bkgSplit2;
	}


	/**
	 * Column Info
	 * @param preCnmvEvntDt
	 */
	public void setPreCnmvEvntDt(String preCnmvEvntDt) {
		this.preCnmvEvntDt = preCnmvEvntDt;
	}

	/**
	 * Column Info
	 * @param preCnmvStsCd
	 */
	public void setPreCnmvStsCd(String preCnmvStsCd) {
		this.preCnmvStsCd = preCnmvStsCd;
	}

	/**
	 * Column Info
	 * @param preOrgYdCd
	 */
	public void setPreOrgYdCd(String preOrgYdCd) {
		this.preOrgYdCd = preOrgYdCd;
	}

	/**
	 * Column Info
	 * @param cnmvEvntDt
	 */
	public void setCnmvEvntDt(String cnmvEvntDt) {
		this.cnmvEvntDt = cnmvEvntDt;
	}

	/**
	 * Column Info
	 * @param orgYdCd
	 */
	public void setOrgYdCd(String orgYdCd) {
		this.orgYdCd = orgYdCd;
	}

	/**
	 * Column Info
	 * @param pIrrtype
	 */
	public void setPIrrtype(String pIrrtype) {
		this.pIrrtype = pIrrtype;
	}

	/**
	 * Column Info
	 * @param cnmvIrrStlFlg
	 */
	public void setCnmvIrrStlFlg(String cnmvIrrStlFlg) {
		this.cnmvIrrStlFlg = cnmvIrrStlFlg;
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
	 * @param pDate1
	 */
	public void setPDate1(String pDate1) {
		this.pDate1 = pDate1;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}

	/**
	 * Column Info
	 * @param cnmvStsCd
	 */
	public void setCnmvStsCd(String cnmvStsCd) {
		this.cnmvStsCd = cnmvStsCd;
	}

	/**
	 * Column Info
	 * @param pDate2
	 */
	public void setPDate2(String pDate2) {
		this.pDate2 = pDate2;
	}

	/**
	 * Column Info
	 * @param pYard2
	 */
	public void setPYard2(String pYard2) {
		this.pYard2 = pYard2;
	}

	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}

	/**
	 * Column Info
	 * @param pYard1
	 */
	public void setPYard1(String pYard1) {
		this.pYard1 = pYard1;
	}

	/**
	 * Column Info
	 * @param pOffice
	 */
	public void setPOffice(String pOffice) {
		this.pOffice = pOffice;
	}

	/**
	 * Column Info
	 * @param bkgNo1
	 */
	public void setBkgNo1(String bkgNo1) {
		this.bkgNo1 = bkgNo1;
	}

	/**
	 * Column Info
	 * @param bkgNo2
	 */
	public void setBkgNo2(String bkgNo2) {
		this.bkgNo2 = bkgNo2;
	}

	/**
	 * Column Info
	 * @param bkgSplit1
	 */
	public void setBkgSplit1(String bkgSplit1) {
		this.bkgSplit1 = bkgSplit1;
	}

	/**
	 * Column Info
	 * @param pSettled
	 */
	public void setPSettled(String pSettled) {
		this.pSettled = pSettled;
	}

	/**
	 * Column Info
	 * @param cntrBkgAtchCd
	 */
	public void setCntrBkgAtchCd(String cntrBkgAtchCd) {
		this.cntrBkgAtchCd = cntrBkgAtchCd;
	}

	/**
	 * Column Info
	 * @param bkgSplit2
	 */
	public void setBkgSplit2(String bkgSplit2) {
		this.bkgSplit2 = bkgSplit2;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPreCnmvEvntDt(JSPUtil.getParameter(request, "pre_cnmv_evnt_dt", ""));
		setPreCnmvStsCd(JSPUtil.getParameter(request, "pre_cnmv_sts_cd", ""));
		setPreOrgYdCd(JSPUtil.getParameter(request, "pre_org_yd_cd", ""));
		setCnmvEvntDt(JSPUtil.getParameter(request, "cnmv_evnt_dt", ""));
		setOrgYdCd(JSPUtil.getParameter(request, "org_yd_cd", ""));
		setPIrrtype(JSPUtil.getParameter(request, "p_irrtype", ""));
		setCnmvIrrStlFlg(JSPUtil.getParameter(request, "cnmv_irr_stl_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPDate1(JSPUtil.getParameter(request, "p_date1", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, "cnmv_sts_cd", ""));
		setPDate2(JSPUtil.getParameter(request, "p_date2", ""));
		setPYard2(JSPUtil.getParameter(request, "p_yard2", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setPYard1(JSPUtil.getParameter(request, "p_yard1", ""));
		setPOffice(JSPUtil.getParameter(request, "p_office", ""));
		setBkgNo1(JSPUtil.getParameter(request, "bkg_no1", ""));
		setBkgNo2(JSPUtil.getParameter(request, "bkg_no2", ""));
		setBkgSplit1(JSPUtil.getParameter(request, "bkg_split1", ""));
		setPSettled(JSPUtil.getParameter(request, "p_settled", ""));
		setCntrBkgAtchCd(JSPUtil.getParameter(request, "cntr_bkg_atch_cd", ""));
		setBkgSplit2(JSPUtil.getParameter(request, "bkg_split2", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CtmMvmtIrrVO[]
	 */
	public CtmMvmtIrrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return CtmMvmtIrrVO[]
	 */
	public CtmMvmtIrrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CtmMvmtIrrVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] preCnmvEvntDt = (JSPUtil.getParameter(request, prefix	+ "pre_cnmv_evnt_dt".trim(), length));
			String[] preCnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "pre_cnmv_sts_cd".trim(), length));
			String[] preOrgYdCd = (JSPUtil.getParameter(request, prefix	+ "pre_org_yd_cd".trim(), length));
			String[] cnmvEvntDt = (JSPUtil.getParameter(request, prefix	+ "cnmv_evnt_dt".trim(), length));
			String[] orgYdCd = (JSPUtil.getParameter(request, prefix	+ "org_yd_cd".trim(), length));
			String[] pIrrtype = (JSPUtil.getParameter(request, prefix	+ "p_irrtype".trim(), length));
			String[] cnmvIrrStlFlg = (JSPUtil.getParameter(request, prefix	+ "cnmv_irr_stl_flg".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] pDate1 = (JSPUtil.getParameter(request, prefix	+ "p_date1".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd".trim(), length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd".trim(), length));
			String[] pDate2 = (JSPUtil.getParameter(request, prefix	+ "p_date2".trim(), length));
			String[] pYard2 = (JSPUtil.getParameter(request, prefix	+ "p_yard2".trim(), length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no".trim(), length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd".trim(), length));
			String[] pYard1 = (JSPUtil.getParameter(request, prefix	+ "p_yard1".trim(), length));
			String[] pOffice = (JSPUtil.getParameter(request, prefix	+ "p_office".trim(), length));
			String[] bkgNo1 = (JSPUtil.getParameter(request, prefix	+ "bkg_no1".trim(), length));
			String[] bkgNo2 = (JSPUtil.getParameter(request, prefix	+ "bkg_no2".trim(), length));
			String[] bkgSplit1 = (JSPUtil.getParameter(request, prefix	+ "bkg_split1".trim(), length));
			String[] pSettled = (JSPUtil.getParameter(request, prefix	+ "p_settled".trim(), length));
			String[] cntrBkgAtchCd = (JSPUtil.getParameter(request, prefix	+ "cntr_bkg_atch_cd".trim(), length));
			String[] bkgSplit2 = (JSPUtil.getParameter(request, prefix	+ "bkg_split2".trim(), length));

			for (int i = 0; i < length; i++) {
				model = new CtmMvmtIrrVO();
				if (preCnmvEvntDt[i] != null)
					model.setPreCnmvEvntDt(preCnmvEvntDt[i]);
				if (preCnmvStsCd[i] != null)
					model.setPreCnmvStsCd(preCnmvStsCd[i]);
				if (preOrgYdCd[i] != null)
					model.setPreOrgYdCd(preOrgYdCd[i]);
				if (cnmvEvntDt[i] != null)
					model.setCnmvEvntDt(cnmvEvntDt[i]);
				if (orgYdCd[i] != null)
					model.setOrgYdCd(orgYdCd[i]);
				if (pIrrtype[i] != null)
					model.setPIrrtype(pIrrtype[i]);
				if (cnmvIrrStlFlg[i] != null)
					model.setCnmvIrrStlFlg(cnmvIrrStlFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pDate1[i] != null)
					model.setPDate1(pDate1[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (pDate2[i] != null)
					model.setPDate2(pDate2[i]);
				if (pYard2[i] != null)
					model.setPYard2(pYard2[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (pYard1[i] != null)
					model.setPYard1(pYard1[i]);
				if (pOffice[i] != null)
					model.setPOffice(pOffice[i]);
				if (bkgNo1[i] != null)
					model.setBkgNo1(bkgNo1[i]);
				if (bkgNo2[i] != null)
					model.setBkgNo2(bkgNo2[i]);
				if (bkgSplit1[i] != null)
					model.setBkgSplit1(bkgSplit1[i]);
				if (pSettled[i] != null)
					model.setPSettled(pSettled[i]);
				if (cntrBkgAtchCd[i] != null)
					model.setCntrBkgAtchCd(cntrBkgAtchCd[i]);
				if (bkgSplit2[i] != null)
					model.setBkgSplit2(bkgSplit2[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCtmMvmtIrrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CtmMvmtIrrVO[]
	 */
	public CtmMvmtIrrVO[] getCtmMvmtIrrVOs(){
		CtmMvmtIrrVO[] vos = (CtmMvmtIrrVO[])models.toArray(new CtmMvmtIrrVO[models.size()]);
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
		this.preCnmvEvntDt = this.preCnmvEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preCnmvStsCd = this.preCnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preOrgYdCd = this.preOrgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvEvntDt = this.cnmvEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd = this.orgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pIrrtype = this.pIrrtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvIrrStlFlg = this.cnmvIrrStlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate1 = this.pDate1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate2 = this.pDate2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pYard2 = this.pYard2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pYard1 = this.pYard1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pOffice = this.pOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo1 = this.bkgNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo2 = this.bkgNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSplit1 = this.bkgSplit1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pSettled = this.pSettled .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrBkgAtchCd = this.cntrBkgAtchCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSplit2 = this.bkgSplit2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
