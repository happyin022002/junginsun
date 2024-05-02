/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DmtTariffTypeVO.java
*@FileTitle : DmtTariffTypeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.10.21 김태균 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo;

import java.lang.reflect.Field;
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
 * @author 김태균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DmtTariffTypeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DmtTariffTypeVO> models = new ArrayList<DmtTariffTypeVO>();
	
	/* Column Info */
	private String cvrgYdCd = null;
	/* Column Info */
	private String dmdtCntrTpCd = null;
	/* Column Info */
	private String orgDestSteCd = null;
	/* Column Info */
	private String orgDestLocCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String svrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cvrgRgnCd = null;
	/* Column Info */
	private String orgDestContiCd = null;
	/* Column Info */
	private String cvrgSteCd = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String uiCode = null;
	/* Column Info */
	private String selDmdtTrfCd = null;
	/* Column Info */
	private String cvrgContiCd = null;
	/* Column Info */
	private String orgDestRgnCd = null;
	/* Column Info */
	private String cvrgCntCd = null;
	/* Column Info */
	private String orgDestCntCd = null;
	/* Column Info */
	private String dmdtCgoTpCd = null;
	/* Column Info */
	private String trfGrpSeq = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String cvrgLocCd = null;
	/* Column Info */
	private String allFlg = null;
	/* Column Info */
	private String trfSeq = null;
	/* Column Info */
	private String dmdtDeTermCd = null;
	/* Column Info */
	private String dmdtDeTermNm = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DmtTariffTypeVO() {}

	public DmtTariffTypeVO(String ibflag, String pagerows, String cntCd, String selDmdtTrfCd, String dmdtTrfCd, String cvrgCntCd, String cvrgContiCd, String cvrgLocCd, String cvrgRgnCd, String cvrgSteCd, String cvrgYdCd, String orgDestCntCd, String orgDestContiCd, String orgDestLocCd, String orgDestRgnCd, String orgDestSteCd, String svrId, String trfGrpSeq, String trfSeq, String dmdtDeTermCd, String dmdtDeTermNm, String uiCode, String allFlg, String dmdtCntrTpCd, String dmdtCgoTpCd) {
		this.cvrgYdCd = cvrgYdCd;
		this.dmdtCntrTpCd = dmdtCntrTpCd;
		this.orgDestSteCd = orgDestSteCd;
		this.orgDestLocCd = orgDestLocCd;
		this.pagerows = pagerows;
		this.svrId = svrId;
		this.ibflag = ibflag;
		this.cvrgRgnCd = cvrgRgnCd;
		this.orgDestContiCd = orgDestContiCd;
		this.cvrgSteCd = cvrgSteCd;
		this.cntCd = cntCd;
		this.uiCode = uiCode;
		this.selDmdtTrfCd = selDmdtTrfCd;
		this.cvrgContiCd = cvrgContiCd;
		this.orgDestRgnCd = orgDestRgnCd;
		this.cvrgCntCd = cvrgCntCd;
		this.orgDestCntCd = orgDestCntCd;
		this.dmdtCgoTpCd = dmdtCgoTpCd;
		this.trfGrpSeq = trfGrpSeq;
		this.dmdtTrfCd = dmdtTrfCd;
		this.cvrgLocCd = cvrgLocCd;
		this.allFlg = allFlg;
		this.trfSeq = trfSeq;
		this.dmdtDeTermCd = dmdtDeTermCd;
		this.dmdtDeTermNm = dmdtDeTermNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cvrg_yd_cd", getCvrgYdCd());
		this.hashColumns.put("dmdt_cntr_tp_cd", getDmdtCntrTpCd());
		this.hashColumns.put("org_dest_ste_cd", getOrgDestSteCd());
		this.hashColumns.put("org_dest_loc_cd", getOrgDestLocCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cvrg_rgn_cd", getCvrgRgnCd());
		this.hashColumns.put("org_dest_conti_cd", getOrgDestContiCd());
		this.hashColumns.put("cvrg_ste_cd", getCvrgSteCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("ui_code", getUiCode());
		this.hashColumns.put("sel_dmdt_trf_cd", getSelDmdtTrfCd());
		this.hashColumns.put("cvrg_conti_cd", getCvrgContiCd());
		this.hashColumns.put("org_dest_rgn_cd", getOrgDestRgnCd());
		this.hashColumns.put("cvrg_cnt_cd", getCvrgCntCd());
		this.hashColumns.put("org_dest_cnt_cd", getOrgDestCntCd());
		this.hashColumns.put("dmdt_cgo_tp_cd", getDmdtCgoTpCd());
		this.hashColumns.put("trf_grp_seq", getTrfGrpSeq());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("cvrg_loc_cd", getCvrgLocCd());
		this.hashColumns.put("all_flg", getAllFlg());
		this.hashColumns.put("trf_seq", getTrfSeq());
		this.hashColumns.put("dmdt_de_term_cd", getDmdtDeTermCd());
		this.hashColumns.put("dmdt_de_term_nm", getDmdtDeTermNm());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cvrg_yd_cd", "cvrgYdCd");
		this.hashFields.put("dmdt_cntr_tp_cd", "dmdtCntrTpCd");
		this.hashFields.put("org_dest_ste_cd", "orgDestSteCd");
		this.hashFields.put("org_dest_loc_cd", "orgDestLocCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cvrg_rgn_cd", "cvrgRgnCd");
		this.hashFields.put("org_dest_conti_cd", "orgDestContiCd");
		this.hashFields.put("cvrg_ste_cd", "cvrgSteCd");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("ui_code", "uiCode");
		this.hashFields.put("sel_dmdt_trf_cd", "selDmdtTrfCd");
		this.hashFields.put("cvrg_conti_cd", "cvrgContiCd");
		this.hashFields.put("org_dest_rgn_cd", "orgDestRgnCd");
		this.hashFields.put("cvrg_cnt_cd", "cvrgCntCd");
		this.hashFields.put("org_dest_cnt_cd", "orgDestCntCd");
		this.hashFields.put("dmdt_cgo_tp_cd", "dmdtCgoTpCd");
		this.hashFields.put("trf_grp_seq", "trfGrpSeq");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("cvrg_loc_cd", "cvrgLocCd");
		this.hashFields.put("all_flg", "allFlg");
		this.hashFields.put("trf_seq", "trfSeq");
		this.hashFields.put("dmdt_de_term_cd", "dmdtDeTermCd");
		this.hashFields.put("dmdt_de_term_nm", "dmdtDeTermNm");
		
		return this.hashFields;
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
	 * @return dmdtCntrTpCd
	 */
	public String getDmdtCntrTpCd() {
		return this.dmdtCntrTpCd;
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
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return svrId
	 */
	public String getSvrId() {
		return this.svrId;
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
	 * @return cvrgSteCd
	 */
	public String getCvrgSteCd() {
		return this.cvrgSteCd;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
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
	 * @return selDmdtTrfCd
	 */
	public String getSelDmdtTrfCd() {
		return this.selDmdtTrfCd;
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
	 * @return orgDestRgnCd
	 */
	public String getOrgDestRgnCd() {
		return this.orgDestRgnCd;
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
	 * @return dmdtCgoTpCd
	 */
	public String getDmdtCgoTpCd() {
		return this.dmdtCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return trfGrpSeq
	 */
	public String getTrfGrpSeq() {
		return this.trfGrpSeq;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return this.dmdtTrfCd;
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
	 * @return allFlg
	 */
	public String getAllFlg() {
		return this.allFlg;
	}
	
	/**
	 * Column Info
	 * @return trfSeq
	 */
	public String getTrfSeq() {
		return this.trfSeq;
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
	 * @param cvrgYdCd
	 */
	public void setCvrgYdCd(String cvrgYdCd) {
		this.cvrgYdCd = cvrgYdCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtCntrTpCd
	 */
	public void setDmdtCntrTpCd(String dmdtCntrTpCd) {
		this.dmdtCntrTpCd = dmdtCntrTpCd;
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
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param svrId
	 */
	public void setSvrId(String svrId) {
		this.svrId = svrId;
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
	 * @param cvrgSteCd
	 */
	public void setCvrgSteCd(String cvrgSteCd) {
		this.cvrgSteCd = cvrgSteCd;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
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
	 * @param selDmdtTrfCd
	 */
	public void setSelDmdtTrfCd(String selDmdtTrfCd) {
		this.selDmdtTrfCd = selDmdtTrfCd;
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
	 * @param orgDestRgnCd
	 */
	public void setOrgDestRgnCd(String orgDestRgnCd) {
		this.orgDestRgnCd = orgDestRgnCd;
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
	 * @param dmdtCgoTpCd
	 */
	public void setDmdtCgoTpCd(String dmdtCgoTpCd) {
		this.dmdtCgoTpCd = dmdtCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param trfGrpSeq
	 */
	public void setTrfGrpSeq(String trfGrpSeq) {
		this.trfGrpSeq = trfGrpSeq;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
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
	 * @param allFlg
	 */
	public void setAllFlg(String allFlg) {
		this.allFlg = allFlg;
	}
	
	/**
	 * Column Info
	 * @param trfSeq
	 */
	public void setTrfSeq(String trfSeq) {
		this.trfSeq = trfSeq;
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
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCvrgYdCd(JSPUtil.getParameter(request, "cvrg_yd_cd", ""));
		setDmdtCntrTpCd(JSPUtil.getParameter(request, "dmdt_cntr_tp_cd", ""));
		setOrgDestSteCd(JSPUtil.getParameter(request, "org_dest_ste_cd", ""));
		setOrgDestLocCd(JSPUtil.getParameter(request, "org_dest_loc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSvrId(JSPUtil.getParameter(request, "svr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCvrgRgnCd(JSPUtil.getParameter(request, "cvrg_rgn_cd", ""));
		setOrgDestContiCd(JSPUtil.getParameter(request, "org_dest_conti_cd", ""));
		setCvrgSteCd(JSPUtil.getParameter(request, "cvrg_ste_cd", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setUiCode(JSPUtil.getParameter(request, "ui_code", ""));
		setSelDmdtTrfCd(JSPUtil.getParameter(request, "sel_dmdt_trf_cd", ""));
		setCvrgContiCd(JSPUtil.getParameter(request, "cvrg_conti_cd", ""));
		setOrgDestRgnCd(JSPUtil.getParameter(request, "org_dest_rgn_cd", ""));
		setCvrgCntCd(JSPUtil.getParameter(request, "cvrg_cnt_cd", ""));
		setOrgDestCntCd(JSPUtil.getParameter(request, "org_dest_cnt_cd", ""));
		setDmdtCgoTpCd(JSPUtil.getParameter(request, "dmdt_cgo_tp_cd", ""));
		setTrfGrpSeq(JSPUtil.getParameter(request, "trf_grp_seq", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, "dmdt_trf_cd", ""));
		setCvrgLocCd(JSPUtil.getParameter(request, "cvrg_loc_cd", ""));
		setAllFlg(JSPUtil.getParameter(request, "all_flg", ""));
		setTrfSeq(JSPUtil.getParameter(request, "trf_seq", ""));
		setDmdtDeTermCd(JSPUtil.getParameter(request, "dmdt_de_term_cd", ""));
		setDmdtDeTermNm(JSPUtil.getParameter(request, "dmdt_de_term_cd", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DmtTariffTypeVO[]
	 */
	public DmtTariffTypeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DmtTariffTypeVO[]
	 */
	public DmtTariffTypeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DmtTariffTypeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cvrgYdCd = (JSPUtil.getParameter(request, prefix	+ "cvrg_yd_cd", length));
			String[] dmdtCntrTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_cntr_tp_cd", length));
			String[] orgDestSteCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_ste_cd", length));
			String[] orgDestLocCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_loc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cvrgRgnCd = (JSPUtil.getParameter(request, prefix	+ "cvrg_rgn_cd", length));
			String[] orgDestContiCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_conti_cd", length));
			String[] cvrgSteCd = (JSPUtil.getParameter(request, prefix	+ "cvrg_ste_cd", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] uiCode = (JSPUtil.getParameter(request, prefix	+ "ui_code", length));
			String[] selDmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "sel_dmdt_trf_cd", length));
			String[] cvrgContiCd = (JSPUtil.getParameter(request, prefix	+ "cvrg_conti_cd", length));
			String[] orgDestRgnCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_rgn_cd", length));
			String[] cvrgCntCd = (JSPUtil.getParameter(request, prefix	+ "cvrg_cnt_cd", length));
			String[] orgDestCntCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_cnt_cd", length));
			String[] dmdtCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_cgo_tp_cd", length));
			String[] trfGrpSeq = (JSPUtil.getParameter(request, prefix	+ "trf_grp_seq", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] cvrgLocCd = (JSPUtil.getParameter(request, prefix	+ "cvrg_loc_cd", length));
			String[] allFlg = (JSPUtil.getParameter(request, prefix	+ "all_flg", length));
			String[] trfSeq = (JSPUtil.getParameter(request, prefix	+ "trf_seq", length));
			String[] dmdtDeTermCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_de_term_cd", length));
			String[] dmdtDeTermNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_de_term_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new DmtTariffTypeVO();
				if (cvrgYdCd[i] != null)
					model.setCvrgYdCd(cvrgYdCd[i]);
				if (dmdtCntrTpCd[i] != null)
					model.setDmdtCntrTpCd(dmdtCntrTpCd[i]);
				if (orgDestSteCd[i] != null)
					model.setOrgDestSteCd(orgDestSteCd[i]);
				if (orgDestLocCd[i] != null)
					model.setOrgDestLocCd(orgDestLocCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cvrgRgnCd[i] != null)
					model.setCvrgRgnCd(cvrgRgnCd[i]);
				if (orgDestContiCd[i] != null)
					model.setOrgDestContiCd(orgDestContiCd[i]);
				if (cvrgSteCd[i] != null)
					model.setCvrgSteCd(cvrgSteCd[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (uiCode[i] != null)
					model.setUiCode(uiCode[i]);
				if (selDmdtTrfCd[i] != null)
					model.setSelDmdtTrfCd(selDmdtTrfCd[i]);
				if (cvrgContiCd[i] != null)
					model.setCvrgContiCd(cvrgContiCd[i]);
				if (orgDestRgnCd[i] != null)
					model.setOrgDestRgnCd(orgDestRgnCd[i]);
				if (cvrgCntCd[i] != null)
					model.setCvrgCntCd(cvrgCntCd[i]);
				if (orgDestCntCd[i] != null)
					model.setOrgDestCntCd(orgDestCntCd[i]);
				if (dmdtCgoTpCd[i] != null)
					model.setDmdtCgoTpCd(dmdtCgoTpCd[i]);
				if (trfGrpSeq[i] != null)
					model.setTrfGrpSeq(trfGrpSeq[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (cvrgLocCd[i] != null)
					model.setCvrgLocCd(cvrgLocCd[i]);
				if (allFlg[i] != null)
					model.setAllFlg(allFlg[i]);
				if (trfSeq[i] != null)
					model.setTrfSeq(trfSeq[i]);
				if (dmdtDeTermCd[i] != null)
					model.setDmdtDeTermCd(dmdtDeTermCd[i]);
				if (dmdtDeTermNm[i] != null)
					model.setDmdtDeTermNm(dmdtDeTermNm[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDmtTariffTypeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DmtTariffTypeVO[]
	 */
	public DmtTariffTypeVO[] getDmtTariffTypeVOs(){
		DmtTariffTypeVO[] vos = (DmtTariffTypeVO[])models.toArray(new DmtTariffTypeVO[models.size()]);
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
		this.cvrgYdCd = this.cvrgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCntrTpCd = this.dmdtCntrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestSteCd = this.orgDestSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestLocCd = this.orgDestLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgRgnCd = this.cvrgRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestContiCd = this.orgDestContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgSteCd = this.cvrgSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uiCode = this.uiCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selDmdtTrfCd = this.selDmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgContiCd = this.cvrgContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestRgnCd = this.orgDestRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgCntCd = this.cvrgCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestCntCd = this.orgDestCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCgoTpCd = this.dmdtCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfGrpSeq = this.trfGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgLocCd = this.cvrgLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allFlg = this.allFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfSeq = this.trfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtDeTermCd = this.dmdtDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtDeTermNm = this.dmdtDeTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}
