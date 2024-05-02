/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchPerfOfcListVO.java
*@FileTitle : SearchPerfOfcListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.11  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.expnaud.audperf.vo;

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

public class SearchPerfOfcListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchPerfOfcListVO> models = new ArrayList<SearchPerfOfcListVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String invTrsAmt = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String invPsoQty = null;
	/* Column Info */
	private String sRhqOfcCd = null;
	/* Column Info */
	private String invTesQty = null;
	/* Column Info */
	private String sLgsCostCd = null;
	/* Column Info */
	private String sMdlCd = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String invMnrQty = null;
	/* Column Info */
	private String sRhqYn = null;
	/* Column Info */
	private String sCompareMon = null;
	/* Column Info */
	private String invPsoAmt = null;
	/* Column Info */
	private String invMnrAmt = null;
	/* Column Info */
	private String ymTpCd = null;
	/* Column Info */
	private String invTrsQty = null;
	/* Column Info */
	private String stndYm = null;
	/* Column Info */
	private String sFmYm = null;
	/* Column Info */
	private String glMon = null;
	/* Column Info */
	private String invTesAmt = null;
	/* Column Info */
	private String sCgoTpCd = null;
	/* Column Info */
	private String sOfcCd = null;
	/* Column Info */
	private String sToYm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchPerfOfcListVO() {}

	public SearchPerfOfcListVO(String ibflag, String pagerows, String rhqCd, String ofcCd, String stndYm, String glMon, String ymTpCd, String invTesQty, String invTesAmt, String invTrsQty, String invTrsAmt, String invMnrQty, String invMnrAmt, String invPsoQty, String invPsoAmt, String sRhqYn, String sFmYm, String sToYm, String sRhqOfcCd, String sCompareMon, String sOfcCd, String sMdlCd, String sLgsCostCd, String sCgoTpCd) {
		this.pagerows = pagerows;
		this.invTrsAmt = invTrsAmt;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.invPsoQty = invPsoQty;
		this.sRhqOfcCd = sRhqOfcCd;
		this.invTesQty = invTesQty;
		this.sLgsCostCd = sLgsCostCd;
		this.sMdlCd = sMdlCd;
		this.rhqCd = rhqCd;
		this.invMnrQty = invMnrQty;
		this.sRhqYn = sRhqYn;
		this.sCompareMon = sCompareMon;
		this.invPsoAmt = invPsoAmt;
		this.invMnrAmt = invMnrAmt;
		this.ymTpCd = ymTpCd;
		this.invTrsQty = invTrsQty;
		this.stndYm = stndYm;
		this.sFmYm = sFmYm;
		this.glMon = glMon;
		this.invTesAmt = invTesAmt;
		this.sCgoTpCd = sCgoTpCd;
		this.sOfcCd = sOfcCd;
		this.sToYm = sToYm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inv_trs_amt", getInvTrsAmt());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inv_pso_qty", getInvPsoQty());
		this.hashColumns.put("s_rhq_ofc_cd", getSRhqOfcCd());
		this.hashColumns.put("inv_tes_qty", getInvTesQty());
		this.hashColumns.put("s_lgs_cost_cd", getSLgsCostCd());
		this.hashColumns.put("s_mdl_cd", getSMdlCd());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("inv_mnr_qty", getInvMnrQty());
		this.hashColumns.put("s_rhq_yn", getSRhqYn());
		this.hashColumns.put("s_compare_mon", getSCompareMon());
		this.hashColumns.put("inv_pso_amt", getInvPsoAmt());
		this.hashColumns.put("inv_mnr_amt", getInvMnrAmt());
		this.hashColumns.put("ym_tp_cd", getYmTpCd());
		this.hashColumns.put("inv_trs_qty", getInvTrsQty());
		this.hashColumns.put("stnd_ym", getStndYm());
		this.hashColumns.put("s_fm_ym", getSFmYm());
		this.hashColumns.put("gl_mon", getGlMon());
		this.hashColumns.put("inv_tes_amt", getInvTesAmt());
		this.hashColumns.put("s_cgo_tp_cd", getSCgoTpCd());
		this.hashColumns.put("s_ofc_cd", getSOfcCd());
		this.hashColumns.put("s_to_ym", getSToYm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_trs_amt", "invTrsAmt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inv_pso_qty", "invPsoQty");
		this.hashFields.put("s_rhq_ofc_cd", "sRhqOfcCd");
		this.hashFields.put("inv_tes_qty", "invTesQty");
		this.hashFields.put("s_lgs_cost_cd", "sLgsCostCd");
		this.hashFields.put("s_mdl_cd", "sMdlCd");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("inv_mnr_qty", "invMnrQty");
		this.hashFields.put("s_rhq_yn", "sRhqYn");
		this.hashFields.put("s_compare_mon", "sCompareMon");
		this.hashFields.put("inv_pso_amt", "invPsoAmt");
		this.hashFields.put("inv_mnr_amt", "invMnrAmt");
		this.hashFields.put("ym_tp_cd", "ymTpCd");
		this.hashFields.put("inv_trs_qty", "invTrsQty");
		this.hashFields.put("stnd_ym", "stndYm");
		this.hashFields.put("s_fm_ym", "sFmYm");
		this.hashFields.put("gl_mon", "glMon");
		this.hashFields.put("inv_tes_amt", "invTesAmt");
		this.hashFields.put("s_cgo_tp_cd", "sCgoTpCd");
		this.hashFields.put("s_ofc_cd", "sOfcCd");
		this.hashFields.put("s_to_ym", "sToYm");
		return this.hashFields;
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
	 * @return invTrsAmt
	 */
	public String getInvTrsAmt() {
		return this.invTrsAmt;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return invPsoQty
	 */
	public String getInvPsoQty() {
		return this.invPsoQty;
	}
	
	/**
	 * Column Info
	 * @return sRhqOfcCd
	 */
	public String getSRhqOfcCd() {
		return this.sRhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @return invTesQty
	 */
	public String getInvTesQty() {
		return this.invTesQty;
	}
	
	/**
	 * Column Info
	 * @return sLgsCostCd
	 */
	public String getSLgsCostCd() {
		return this.sLgsCostCd;
	}
	
	/**
	 * Column Info
	 * @return sMdlCd
	 */
	public String getSMdlCd() {
		return this.sMdlCd;
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
	 * @return invMnrQty
	 */
	public String getInvMnrQty() {
		return this.invMnrQty;
	}
	
	/**
	 * Column Info
	 * @return sRhqYn
	 */
	public String getSRhqYn() {
		return this.sRhqYn;
	}
	
	/**
	 * Column Info
	 * @return sCompareMon
	 */
	public String getSCompareMon() {
		return this.sCompareMon;
	}
	
	/**
	 * Column Info
	 * @return invPsoAmt
	 */
	public String getInvPsoAmt() {
		return this.invPsoAmt;
	}
	
	/**
	 * Column Info
	 * @return invMnrAmt
	 */
	public String getInvMnrAmt() {
		return this.invMnrAmt;
	}
	
	/**
	 * Column Info
	 * @return ymTpCd
	 */
	public String getYmTpCd() {
		return this.ymTpCd;
	}
	
	/**
	 * Column Info
	 * @return invTrsQty
	 */
	public String getInvTrsQty() {
		return this.invTrsQty;
	}
	
	/**
	 * Column Info
	 * @return stndYm
	 */
	public String getStndYm() {
		return this.stndYm;
	}
	
	/**
	 * Column Info
	 * @return sFmYm
	 */
	public String getSFmYm() {
		return this.sFmYm;
	}
	
	/**
	 * Column Info
	 * @return glMon
	 */
	public String getGlMon() {
		return this.glMon;
	}
	
	/**
	 * Column Info
	 * @return invTesAmt
	 */
	public String getInvTesAmt() {
		return this.invTesAmt;
	}
	
	/**
	 * Column Info
	 * @return sCgoTpCd
	 */
	public String getSCgoTpCd() {
		return this.sCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return sOfcCd
	 */
	public String getSOfcCd() {
		return this.sOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sToYm
	 */
	public String getSToYm() {
		return this.sToYm;
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
	 * @param invTrsAmt
	 */
	public void setInvTrsAmt(String invTrsAmt) {
		this.invTrsAmt = invTrsAmt;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param invPsoQty
	 */
	public void setInvPsoQty(String invPsoQty) {
		this.invPsoQty = invPsoQty;
	}
	
	/**
	 * Column Info
	 * @param sRhqOfcCd
	 */
	public void setSRhqOfcCd(String sRhqOfcCd) {
		this.sRhqOfcCd = sRhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @param invTesQty
	 */
	public void setInvTesQty(String invTesQty) {
		this.invTesQty = invTesQty;
	}
	
	/**
	 * Column Info
	 * @param sLgsCostCd
	 */
	public void setSLgsCostCd(String sLgsCostCd) {
		this.sLgsCostCd = sLgsCostCd;
	}
	
	/**
	 * Column Info
	 * @param sMdlCd
	 */
	public void setSMdlCd(String sMdlCd) {
		this.sMdlCd = sMdlCd;
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
	 * @param invMnrQty
	 */
	public void setInvMnrQty(String invMnrQty) {
		this.invMnrQty = invMnrQty;
	}
	
	/**
	 * Column Info
	 * @param sRhqYn
	 */
	public void setSRhqYn(String sRhqYn) {
		this.sRhqYn = sRhqYn;
	}
	
	/**
	 * Column Info
	 * @param sCompareMon
	 */
	public void setSCompareMon(String sCompareMon) {
		this.sCompareMon = sCompareMon;
	}
	
	/**
	 * Column Info
	 * @param invPsoAmt
	 */
	public void setInvPsoAmt(String invPsoAmt) {
		this.invPsoAmt = invPsoAmt;
	}
	
	/**
	 * Column Info
	 * @param invMnrAmt
	 */
	public void setInvMnrAmt(String invMnrAmt) {
		this.invMnrAmt = invMnrAmt;
	}
	
	/**
	 * Column Info
	 * @param ymTpCd
	 */
	public void setYmTpCd(String ymTpCd) {
		this.ymTpCd = ymTpCd;
	}
	
	/**
	 * Column Info
	 * @param invTrsQty
	 */
	public void setInvTrsQty(String invTrsQty) {
		this.invTrsQty = invTrsQty;
	}
	
	/**
	 * Column Info
	 * @param stndYm
	 */
	public void setStndYm(String stndYm) {
		this.stndYm = stndYm;
	}
	
	/**
	 * Column Info
	 * @param sFmYm
	 */
	public void setSFmYm(String sFmYm) {
		this.sFmYm = sFmYm;
	}
	
	/**
	 * Column Info
	 * @param glMon
	 */
	public void setGlMon(String glMon) {
		this.glMon = glMon;
	}
	
	/**
	 * Column Info
	 * @param invTesAmt
	 */
	public void setInvTesAmt(String invTesAmt) {
		this.invTesAmt = invTesAmt;
	}
	
	/**
	 * Column Info
	 * @param sCgoTpCd
	 */
	public void setSCgoTpCd(String sCgoTpCd) {
		this.sCgoTpCd = sCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param sOfcCd
	 */
	public void setSOfcCd(String sOfcCd) {
		this.sOfcCd = sOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sToYm
	 */
	public void setSToYm(String sToYm) {
		this.sToYm = sToYm;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setInvTrsAmt(JSPUtil.getParameter(request, prefix + "inv_trs_amt", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInvPsoQty(JSPUtil.getParameter(request, prefix + "inv_pso_qty", ""));
		setSRhqOfcCd(JSPUtil.getParameter(request, prefix + "s_rhq_ofc_cd", ""));
		setInvTesQty(JSPUtil.getParameter(request, prefix + "inv_tes_qty", ""));
		setSLgsCostCd(JSPUtil.getParameter(request, prefix + "s_lgs_cost_cd", ""));
		setSMdlCd(JSPUtil.getParameter(request, prefix + "s_mdl_cd", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setInvMnrQty(JSPUtil.getParameter(request, prefix + "inv_mnr_qty", ""));
		setSRhqYn(JSPUtil.getParameter(request, prefix + "s_rhq_yn", ""));
		setSCompareMon(JSPUtil.getParameter(request, prefix + "s_compare_mon", ""));
		setInvPsoAmt(JSPUtil.getParameter(request, prefix + "inv_pso_amt", ""));
		setInvMnrAmt(JSPUtil.getParameter(request, prefix + "inv_mnr_amt", ""));
		setYmTpCd(JSPUtil.getParameter(request, prefix + "ym_tp_cd", ""));
		setInvTrsQty(JSPUtil.getParameter(request, prefix + "inv_trs_qty", ""));
		setStndYm(JSPUtil.getParameter(request, prefix + "stnd_ym", ""));
		setSFmYm(JSPUtil.getParameter(request, prefix + "s_fm_ym", ""));
		setGlMon(JSPUtil.getParameter(request, prefix + "gl_mon", ""));
		setInvTesAmt(JSPUtil.getParameter(request, prefix + "inv_tes_amt", ""));
		setSCgoTpCd(JSPUtil.getParameter(request, prefix + "s_cgo_tp_cd", ""));
		setSOfcCd(JSPUtil.getParameter(request, prefix + "s_ofc_cd", ""));
		setSToYm(JSPUtil.getParameter(request, prefix + "s_to_ym", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchPerfOfcListVO[]
	 */
	public SearchPerfOfcListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchPerfOfcListVO[]
	 */
	public SearchPerfOfcListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchPerfOfcListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] invTrsAmt = (JSPUtil.getParameter(request, prefix	+ "inv_trs_amt", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] invPsoQty = (JSPUtil.getParameter(request, prefix	+ "inv_pso_qty", length));
			String[] sRhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_rhq_ofc_cd", length));
			String[] invTesQty = (JSPUtil.getParameter(request, prefix	+ "inv_tes_qty", length));
			String[] sLgsCostCd = (JSPUtil.getParameter(request, prefix	+ "s_lgs_cost_cd", length));
			String[] sMdlCd = (JSPUtil.getParameter(request, prefix	+ "s_mdl_cd", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] invMnrQty = (JSPUtil.getParameter(request, prefix	+ "inv_mnr_qty", length));
			String[] sRhqYn = (JSPUtil.getParameter(request, prefix	+ "s_rhq_yn", length));
			String[] sCompareMon = (JSPUtil.getParameter(request, prefix	+ "s_compare_mon", length));
			String[] invPsoAmt = (JSPUtil.getParameter(request, prefix	+ "inv_pso_amt", length));
			String[] invMnrAmt = (JSPUtil.getParameter(request, prefix	+ "inv_mnr_amt", length));
			String[] ymTpCd = (JSPUtil.getParameter(request, prefix	+ "ym_tp_cd", length));
			String[] invTrsQty = (JSPUtil.getParameter(request, prefix	+ "inv_trs_qty", length));
			String[] stndYm = (JSPUtil.getParameter(request, prefix	+ "stnd_ym", length));
			String[] sFmYm = (JSPUtil.getParameter(request, prefix	+ "s_fm_ym", length));
			String[] glMon = (JSPUtil.getParameter(request, prefix	+ "gl_mon", length));
			String[] invTesAmt = (JSPUtil.getParameter(request, prefix	+ "inv_tes_amt", length));
			String[] sCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "s_cgo_tp_cd", length));
			String[] sOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_ofc_cd", length));
			String[] sToYm = (JSPUtil.getParameter(request, prefix	+ "s_to_ym", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchPerfOfcListVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (invTrsAmt[i] != null)
					model.setInvTrsAmt(invTrsAmt[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (invPsoQty[i] != null)
					model.setInvPsoQty(invPsoQty[i]);
				if (sRhqOfcCd[i] != null)
					model.setSRhqOfcCd(sRhqOfcCd[i]);
				if (invTesQty[i] != null)
					model.setInvTesQty(invTesQty[i]);
				if (sLgsCostCd[i] != null)
					model.setSLgsCostCd(sLgsCostCd[i]);
				if (sMdlCd[i] != null)
					model.setSMdlCd(sMdlCd[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (invMnrQty[i] != null)
					model.setInvMnrQty(invMnrQty[i]);
				if (sRhqYn[i] != null)
					model.setSRhqYn(sRhqYn[i]);
				if (sCompareMon[i] != null)
					model.setSCompareMon(sCompareMon[i]);
				if (invPsoAmt[i] != null)
					model.setInvPsoAmt(invPsoAmt[i]);
				if (invMnrAmt[i] != null)
					model.setInvMnrAmt(invMnrAmt[i]);
				if (ymTpCd[i] != null)
					model.setYmTpCd(ymTpCd[i]);
				if (invTrsQty[i] != null)
					model.setInvTrsQty(invTrsQty[i]);
				if (stndYm[i] != null)
					model.setStndYm(stndYm[i]);
				if (sFmYm[i] != null)
					model.setSFmYm(sFmYm[i]);
				if (glMon[i] != null)
					model.setGlMon(glMon[i]);
				if (invTesAmt[i] != null)
					model.setInvTesAmt(invTesAmt[i]);
				if (sCgoTpCd[i] != null)
					model.setSCgoTpCd(sCgoTpCd[i]);
				if (sOfcCd[i] != null)
					model.setSOfcCd(sOfcCd[i]);
				if (sToYm[i] != null)
					model.setSToYm(sToYm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchPerfOfcListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchPerfOfcListVO[]
	 */
	public SearchPerfOfcListVO[] getSearchPerfOfcListVOs(){
		SearchPerfOfcListVO[] vos = (SearchPerfOfcListVO[])models.toArray(new SearchPerfOfcListVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTrsAmt = this.invTrsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invPsoQty = this.invPsoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRhqOfcCd = this.sRhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTesQty = this.invTesQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sLgsCostCd = this.sLgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sMdlCd = this.sMdlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invMnrQty = this.invMnrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRhqYn = this.sRhqYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCompareMon = this.sCompareMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invPsoAmt = this.invPsoAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invMnrAmt = this.invMnrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ymTpCd = this.ymTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTrsQty = this.invTrsQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndYm = this.stndYm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFmYm = this.sFmYm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glMon = this.glMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTesAmt = this.invTesAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCgoTpCd = this.sCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOfcCd = this.sOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sToYm = this.sToYm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
