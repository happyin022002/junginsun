/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TariffRegionVO.java
*@FileTitle : TariffRegionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.08  
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TariffRegionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TariffRegionVO> models = new ArrayList<TariffRegionVO>();
	
	/* Column Info */
	private String cvrgYdCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String creDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String svrId = null;
	/* Column Info */
	private String cvrgRgnCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String orgDestContiCd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String cvrgSteCd = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String suthChnUseFlg = null;
	/* Column Info */
	private String uiCode = null;
	/* Column Info */
	private String cvrgCntCd = null;
	/* Column Info */
	private String orgDestRgnCd = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String orgDestSteCd = null;
	/* Column Info */
	private String orgDestLocCd = null;
	/* Column Info */
	private String cfmFlg = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cvrgContiCd = null;
	/* Column Info */
	private String orgDestCntCd = null;
	/* Column Info */
	private String cvrgLocCd = null;
	/* Column Info */
	private String trfSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TariffRegionVO() {}

	public TariffRegionVO(String ibflag, String pagerows, String svrId, String dmdtTrfCd, String trfSeq, String cvrgContiCd, String cvrgCntCd, String cvrgRgnCd, String cvrgSteCd, String cvrgLocCd, String cvrgYdCd, String orgDestContiCd, String orgDestCntCd, String orgDestRgnCd, String orgDestSteCd, String orgDestLocCd, String currCd, String suthChnUseFlg, String cfmFlg, String creUsrId, String creDt, String creOfcCd, String updUsrId, String updDt, String updOfcCd, String usrId, String ofcCd, String uiCode) {
		this.cvrgYdCd = cvrgYdCd;
		this.currCd = currCd;
		this.creDt = creDt;
		this.pagerows = pagerows;
		this.svrId = svrId;
		this.cvrgRgnCd = cvrgRgnCd;
		this.ibflag = ibflag;
		this.orgDestContiCd = orgDestContiCd;
		this.usrId = usrId;
		this.cvrgSteCd = cvrgSteCd;
		this.creOfcCd = creOfcCd;
		this.suthChnUseFlg = suthChnUseFlg;
		this.uiCode = uiCode;
		this.cvrgCntCd = cvrgCntCd;
		this.orgDestRgnCd = orgDestRgnCd;
		this.dmdtTrfCd = dmdtTrfCd;
		this.updUsrId = updUsrId;
		this.updOfcCd = updOfcCd;
		this.updDt = updDt;
		this.orgDestSteCd = orgDestSteCd;
		this.orgDestLocCd = orgDestLocCd;
		this.cfmFlg = cfmFlg;
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.cvrgContiCd = cvrgContiCd;
		this.orgDestCntCd = orgDestCntCd;
		this.cvrgLocCd = cvrgLocCd;
		this.trfSeq = trfSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cvrg_yd_cd", getCvrgYdCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("cvrg_rgn_cd", getCvrgRgnCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("org_dest_conti_cd", getOrgDestContiCd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("cvrg_ste_cd", getCvrgSteCd());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("suth_chn_use_flg", getSuthChnUseFlg());
		this.hashColumns.put("ui_code", getUiCode());
		this.hashColumns.put("cvrg_cnt_cd", getCvrgCntCd());
		this.hashColumns.put("org_dest_rgn_cd", getOrgDestRgnCd());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("org_dest_ste_cd", getOrgDestSteCd());
		this.hashColumns.put("org_dest_loc_cd", getOrgDestLocCd());
		this.hashColumns.put("cfm_flg", getCfmFlg());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cvrg_conti_cd", getCvrgContiCd());
		this.hashColumns.put("org_dest_cnt_cd", getOrgDestCntCd());
		this.hashColumns.put("cvrg_loc_cd", getCvrgLocCd());
		this.hashColumns.put("trf_seq", getTrfSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cvrg_yd_cd", "cvrgYdCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("cvrg_rgn_cd", "cvrgRgnCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("org_dest_conti_cd", "orgDestContiCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("cvrg_ste_cd", "cvrgSteCd");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("suth_chn_use_flg", "suthChnUseFlg");
		this.hashFields.put("ui_code", "uiCode");
		this.hashFields.put("cvrg_cnt_cd", "cvrgCntCd");
		this.hashFields.put("org_dest_rgn_cd", "orgDestRgnCd");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("org_dest_ste_cd", "orgDestSteCd");
		this.hashFields.put("org_dest_loc_cd", "orgDestLocCd");
		this.hashFields.put("cfm_flg", "cfmFlg");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cvrg_conti_cd", "cvrgContiCd");
		this.hashFields.put("org_dest_cnt_cd", "orgDestCntCd");
		this.hashFields.put("cvrg_loc_cd", "cvrgLocCd");
		this.hashFields.put("trf_seq", "trfSeq");
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
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
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return suthChnUseFlg
	 */
	public String getSuthChnUseFlg() {
		return this.suthChnUseFlg;
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
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return this.dmdtTrfCd;
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
	 * @return updOfcCd
	 */
	public String getUpdOfcCd() {
		return this.updOfcCd;
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
	 * @return cfmFlg
	 */
	public String getCfmFlg() {
		return this.cfmFlg;
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
	 * @return trfSeq
	 */
	public String getTrfSeq() {
		return this.trfSeq;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
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
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param suthChnUseFlg
	 */
	public void setSuthChnUseFlg(String suthChnUseFlg) {
		this.suthChnUseFlg = suthChnUseFlg;
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
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
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
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
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
	 * @param cfmFlg
	 */
	public void setCfmFlg(String cfmFlg) {
		this.cfmFlg = cfmFlg;
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
	 * Column Info
	 * @param trfSeq
	 */
	public void setTrfSeq(String trfSeq) {
		this.trfSeq = trfSeq;
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
		setCvrgYdCd(JSPUtil.getParameter(request, prefix + "cvrg_yd_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSvrId(JSPUtil.getParameter(request, prefix + "svr_id", ""));
		setCvrgRgnCd(JSPUtil.getParameter(request, prefix + "cvrg_rgn_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOrgDestContiCd(JSPUtil.getParameter(request, prefix + "org_dest_conti_cd", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setCvrgSteCd(JSPUtil.getParameter(request, prefix + "cvrg_ste_cd", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setSuthChnUseFlg(JSPUtil.getParameter(request, prefix + "suth_chn_use_flg", ""));
		setUiCode(JSPUtil.getParameter(request, prefix + "ui_code", ""));
		setCvrgCntCd(JSPUtil.getParameter(request, prefix + "cvrg_cnt_cd", ""));
		setOrgDestRgnCd(JSPUtil.getParameter(request, prefix + "org_dest_rgn_cd", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, prefix + "upd_ofc_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setOrgDestSteCd(JSPUtil.getParameter(request, prefix + "org_dest_ste_cd", ""));
		setOrgDestLocCd(JSPUtil.getParameter(request, prefix + "org_dest_loc_cd", ""));
		setCfmFlg(JSPUtil.getParameter(request, prefix + "cfm_flg", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCvrgContiCd(JSPUtil.getParameter(request, prefix + "cvrg_conti_cd", ""));
		setOrgDestCntCd(JSPUtil.getParameter(request, prefix + "org_dest_cnt_cd", ""));
		setCvrgLocCd(JSPUtil.getParameter(request, prefix + "cvrg_loc_cd", ""));
		setTrfSeq(JSPUtil.getParameter(request, prefix + "trf_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TariffRegionVO[]
	 */
	public TariffRegionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TariffRegionVO[]
	 */
	public TariffRegionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TariffRegionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cvrgYdCd = (JSPUtil.getParameter(request, prefix	+ "cvrg_yd_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] cvrgRgnCd = (JSPUtil.getParameter(request, prefix	+ "cvrg_rgn_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] orgDestContiCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_conti_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] cvrgSteCd = (JSPUtil.getParameter(request, prefix	+ "cvrg_ste_cd", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] suthChnUseFlg = (JSPUtil.getParameter(request, prefix	+ "suth_chn_use_flg", length));
			String[] uiCode = (JSPUtil.getParameter(request, prefix	+ "ui_code", length));
			String[] cvrgCntCd = (JSPUtil.getParameter(request, prefix	+ "cvrg_cnt_cd", length));
			String[] orgDestRgnCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_rgn_cd", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] orgDestSteCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_ste_cd", length));
			String[] orgDestLocCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_loc_cd", length));
			String[] cfmFlg = (JSPUtil.getParameter(request, prefix	+ "cfm_flg", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cvrgContiCd = (JSPUtil.getParameter(request, prefix	+ "cvrg_conti_cd", length));
			String[] orgDestCntCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_cnt_cd", length));
			String[] cvrgLocCd = (JSPUtil.getParameter(request, prefix	+ "cvrg_loc_cd", length));
			String[] trfSeq = (JSPUtil.getParameter(request, prefix	+ "trf_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new TariffRegionVO();
				if (cvrgYdCd[i] != null)
					model.setCvrgYdCd(cvrgYdCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (cvrgRgnCd[i] != null)
					model.setCvrgRgnCd(cvrgRgnCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (orgDestContiCd[i] != null)
					model.setOrgDestContiCd(orgDestContiCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (cvrgSteCd[i] != null)
					model.setCvrgSteCd(cvrgSteCd[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (suthChnUseFlg[i] != null)
					model.setSuthChnUseFlg(suthChnUseFlg[i]);
				if (uiCode[i] != null)
					model.setUiCode(uiCode[i]);
				if (cvrgCntCd[i] != null)
					model.setCvrgCntCd(cvrgCntCd[i]);
				if (orgDestRgnCd[i] != null)
					model.setOrgDestRgnCd(orgDestRgnCd[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (orgDestSteCd[i] != null)
					model.setOrgDestSteCd(orgDestSteCd[i]);
				if (orgDestLocCd[i] != null)
					model.setOrgDestLocCd(orgDestLocCd[i]);
				if (cfmFlg[i] != null)
					model.setCfmFlg(cfmFlg[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cvrgContiCd[i] != null)
					model.setCvrgContiCd(cvrgContiCd[i]);
				if (orgDestCntCd[i] != null)
					model.setOrgDestCntCd(orgDestCntCd[i]);
				if (cvrgLocCd[i] != null)
					model.setCvrgLocCd(cvrgLocCd[i]);
				if (trfSeq[i] != null)
					model.setTrfSeq(trfSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTariffRegionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TariffRegionVO[]
	 */
	public TariffRegionVO[] getTariffRegionVOs(){
		TariffRegionVO[] vos = (TariffRegionVO[])models.toArray(new TariffRegionVO[models.size()]);
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
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgRgnCd = this.cvrgRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestContiCd = this.orgDestContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgSteCd = this.cvrgSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.suthChnUseFlg = this.suthChnUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uiCode = this.uiCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgCntCd = this.cvrgCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestRgnCd = this.orgDestRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestSteCd = this.orgDestSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestLocCd = this.orgDestLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmFlg = this.cfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgContiCd = this.cvrgContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestCntCd = this.orgDestCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgLocCd = this.cvrgLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfSeq = this.trfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
