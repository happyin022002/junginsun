/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchToleranceListVO.java
*@FileTitle : SearchToleranceListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.10.16 이중환 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo;

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
 * @author 이중환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchToleranceListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchToleranceListVO> models = new ArrayList<SearchToleranceListVO>();
	
	/* Column Info */
	private String fmActNm = null;
	/* Column Info */
	private String taActNm = null;
	/* Column Info */
	private String exptDtlTpDesc = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fomlPctNo = null;
	/* Column Info */
	private String exptDtlTpNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String exptLocCd = null;
	/* Column Info */
	private String toActNm = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String actFlg = null;
	/* Column Info */
	private String fmActDesc = null;
	/* Column Info */
	private String fomlTmMin = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String fomlTmHrs = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String exptTpDesc = null;
	/* Column Info */
	private String toAct = null;
	/* Column Info */
	private String exptTpDtl = null;
	/* Column Info */
	private String fmAct = null;
	/* Column Info */
	private String exptTp = null;
	/* Column Info */
	private String fomlTmDys = null;
	/* Column Info */
	private String toActDesc = null;
	/* Column Info */
	private String nodCd = null;
	/* Column Info */
	private String faActNm = null;
	/* Column Info */
	private String exptTpNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchToleranceListVO() {}

	public SearchToleranceListVO(String ibflag, String pagerows, String exptTp, String exptTpNm, String exptTpDesc, String exptTpDtl, String exptDtlTpNm, String exptDtlTpDesc, String fmAct, String fmActNm, String fmActDesc, String toAct, String toActNm, String toActDesc, String locCd, String nodCd, String fomlPctNo, String fomlTmDys, String fomlTmHrs, String fomlTmMin, String exptLocCd, String usrId, String updUsrId, String updDt, String actFlg, String faActNm, String taActNm) {
		this.fmActNm = fmActNm;
		this.taActNm = taActNm;
		this.exptDtlTpDesc = exptDtlTpDesc;
		this.pagerows = pagerows;
		this.fomlPctNo = fomlPctNo;
		this.exptDtlTpNm = exptDtlTpNm;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.exptLocCd = exptLocCd;
		this.toActNm = toActNm;
		this.usrId = usrId;
		this.actFlg = actFlg;
		this.fmActDesc = fmActDesc;
		this.fomlTmMin = fomlTmMin;
		this.updUsrId = updUsrId;
		this.fomlTmHrs = fomlTmHrs;
		this.updDt = updDt;
		this.exptTpDesc = exptTpDesc;
		this.toAct = toAct;
		this.exptTpDtl = exptTpDtl;
		this.fmAct = fmAct;
		this.exptTp = exptTp;
		this.fomlTmDys = fomlTmDys;
		this.toActDesc = toActDesc;
		this.nodCd = nodCd;
		this.faActNm = faActNm;
		this.exptTpNm = exptTpNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fm_act_nm", getFmActNm());
		this.hashColumns.put("ta_act_nm", getTaActNm());
		this.hashColumns.put("expt_dtl_tp_desc", getExptDtlTpDesc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("foml_pct_no", getFomlPctNo());
		this.hashColumns.put("expt_dtl_tp_nm", getExptDtlTpNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("expt_loc_cd", getExptLocCd());
		this.hashColumns.put("to_act_nm", getToActNm());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("act_flg", getActFlg());
		this.hashColumns.put("fm_act_desc", getFmActDesc());
		this.hashColumns.put("foml_tm_min", getFomlTmMin());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("foml_tm_hrs", getFomlTmHrs());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("expt_tp_desc", getExptTpDesc());
		this.hashColumns.put("to_act", getToAct());
		this.hashColumns.put("expt_tp_dtl", getExptTpDtl());
		this.hashColumns.put("fm_act", getFmAct());
		this.hashColumns.put("expt_tp", getExptTp());
		this.hashColumns.put("foml_tm_dys", getFomlTmDys());
		this.hashColumns.put("to_act_desc", getToActDesc());
		this.hashColumns.put("nod_cd", getNodCd());
		this.hashColumns.put("fa_act_nm", getFaActNm());
		this.hashColumns.put("expt_tp_nm", getExptTpNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fm_act_nm", "fmActNm");
		this.hashFields.put("ta_act_nm", "taActNm");
		this.hashFields.put("expt_dtl_tp_desc", "exptDtlTpDesc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("foml_pct_no", "fomlPctNo");
		this.hashFields.put("expt_dtl_tp_nm", "exptDtlTpNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("expt_loc_cd", "exptLocCd");
		this.hashFields.put("to_act_nm", "toActNm");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("act_flg", "actFlg");
		this.hashFields.put("fm_act_desc", "fmActDesc");
		this.hashFields.put("foml_tm_min", "fomlTmMin");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("foml_tm_hrs", "fomlTmHrs");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("expt_tp_desc", "exptTpDesc");
		this.hashFields.put("to_act", "toAct");
		this.hashFields.put("expt_tp_dtl", "exptTpDtl");
		this.hashFields.put("fm_act", "fmAct");
		this.hashFields.put("expt_tp", "exptTp");
		this.hashFields.put("foml_tm_dys", "fomlTmDys");
		this.hashFields.put("to_act_desc", "toActDesc");
		this.hashFields.put("nod_cd", "nodCd");
		this.hashFields.put("fa_act_nm", "faActNm");
		this.hashFields.put("expt_tp_nm", "exptTpNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fmActNm
	 */
	public String getFmActNm() {
		return this.fmActNm;
	}
	
	/**
	 * Column Info
	 * @return taActNm
	 */
	public String getTaActNm() {
		return this.taActNm;
	}
	
	/**
	 * Column Info
	 * @return exptDtlTpDesc
	 */
	public String getExptDtlTpDesc() {
		return this.exptDtlTpDesc;
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
	 * @return fomlPctNo
	 */
	public String getFomlPctNo() {
		return this.fomlPctNo;
	}
	
	/**
	 * Column Info
	 * @return exptDtlTpNm
	 */
	public String getExptDtlTpNm() {
		return this.exptDtlTpNm;
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
	 * @return exptLocCd
	 */
	public String getExptLocCd() {
		return this.exptLocCd;
	}
	
	/**
	 * Column Info
	 * @return toActNm
	 */
	public String getToActNm() {
		return this.toActNm;
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
	 * @return actFlg
	 */
	public String getActFlg() {
		return this.actFlg;
	}
	
	/**
	 * Column Info
	 * @return fmActDesc
	 */
	public String getFmActDesc() {
		return this.fmActDesc;
	}
	
	/**
	 * Column Info
	 * @return fomlTmMin
	 */
	public String getFomlTmMin() {
		return this.fomlTmMin;
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
	 * @return fomlTmHrs
	 */
	public String getFomlTmHrs() {
		return this.fomlTmHrs;
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
	 * @return exptTpDesc
	 */
	public String getExptTpDesc() {
		return this.exptTpDesc;
	}
	
	/**
	 * Column Info
	 * @return toAct
	 */
	public String getToAct() {
		return this.toAct;
	}
	
	/**
	 * Column Info
	 * @return exptTpDtl
	 */
	public String getExptTpDtl() {
		return this.exptTpDtl;
	}
	
	/**
	 * Column Info
	 * @return fmAct
	 */
	public String getFmAct() {
		return this.fmAct;
	}
	
	/**
	 * Column Info
	 * @return exptTp
	 */
	public String getExptTp() {
		return this.exptTp;
	}
	
	/**
	 * Column Info
	 * @return fomlTmDys
	 */
	public String getFomlTmDys() {
		return this.fomlTmDys;
	}
	
	/**
	 * Column Info
	 * @return toActDesc
	 */
	public String getToActDesc() {
		return this.toActDesc;
	}
	
	/**
	 * Column Info
	 * @return nodCd
	 */
	public String getNodCd() {
		return this.nodCd;
	}
	
	/**
	 * Column Info
	 * @return faActNm
	 */
	public String getFaActNm() {
		return this.faActNm;
	}
	
	/**
	 * Column Info
	 * @return exptTpNm
	 */
	public String getExptTpNm() {
		return this.exptTpNm;
	}
	

	/**
	 * Column Info
	 * @param fmActNm
	 */
	public void setFmActNm(String fmActNm) {
		this.fmActNm = fmActNm;
	}
	
	/**
	 * Column Info
	 * @param taActNm
	 */
	public void setTaActNm(String taActNm) {
		this.taActNm = taActNm;
	}
	
	/**
	 * Column Info
	 * @param exptDtlTpDesc
	 */
	public void setExptDtlTpDesc(String exptDtlTpDesc) {
		this.exptDtlTpDesc = exptDtlTpDesc;
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
	 * @param fomlPctNo
	 */
	public void setFomlPctNo(String fomlPctNo) {
		this.fomlPctNo = fomlPctNo;
	}
	
	/**
	 * Column Info
	 * @param exptDtlTpNm
	 */
	public void setExptDtlTpNm(String exptDtlTpNm) {
		this.exptDtlTpNm = exptDtlTpNm;
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
	 * @param exptLocCd
	 */
	public void setExptLocCd(String exptLocCd) {
		this.exptLocCd = exptLocCd;
	}
	
	/**
	 * Column Info
	 * @param toActNm
	 */
	public void setToActNm(String toActNm) {
		this.toActNm = toActNm;
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
	 * @param actFlg
	 */
	public void setActFlg(String actFlg) {
		this.actFlg = actFlg;
	}
	
	/**
	 * Column Info
	 * @param fmActDesc
	 */
	public void setFmActDesc(String fmActDesc) {
		this.fmActDesc = fmActDesc;
	}
	
	/**
	 * Column Info
	 * @param fomlTmMin
	 */
	public void setFomlTmMin(String fomlTmMin) {
		this.fomlTmMin = fomlTmMin;
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
	 * @param fomlTmHrs
	 */
	public void setFomlTmHrs(String fomlTmHrs) {
		this.fomlTmHrs = fomlTmHrs;
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
	 * @param exptTpDesc
	 */
	public void setExptTpDesc(String exptTpDesc) {
		this.exptTpDesc = exptTpDesc;
	}
	
	/**
	 * Column Info
	 * @param toAct
	 */
	public void setToAct(String toAct) {
		this.toAct = toAct;
	}
	
	/**
	 * Column Info
	 * @param exptTpDtl
	 */
	public void setExptTpDtl(String exptTpDtl) {
		this.exptTpDtl = exptTpDtl;
	}
	
	/**
	 * Column Info
	 * @param fmAct
	 */
	public void setFmAct(String fmAct) {
		this.fmAct = fmAct;
	}
	
	/**
	 * Column Info
	 * @param exptTp
	 */
	public void setExptTp(String exptTp) {
		this.exptTp = exptTp;
	}
	
	/**
	 * Column Info
	 * @param fomlTmDys
	 */
	public void setFomlTmDys(String fomlTmDys) {
		this.fomlTmDys = fomlTmDys;
	}
	
	/**
	 * Column Info
	 * @param toActDesc
	 */
	public void setToActDesc(String toActDesc) {
		this.toActDesc = toActDesc;
	}
	
	/**
	 * Column Info
	 * @param nodCd
	 */
	public void setNodCd(String nodCd) {
		this.nodCd = nodCd;
	}
	
	/**
	 * Column Info
	 * @param faActNm
	 */
	public void setFaActNm(String faActNm) {
		this.faActNm = faActNm;
	}
	
	/**
	 * Column Info
	 * @param exptTpNm
	 */
	public void setExptTpNm(String exptTpNm) {
		this.exptTpNm = exptTpNm;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFmActNm(JSPUtil.getParameter(request, "fm_act_nm", ""));
		setTaActNm(JSPUtil.getParameter(request, "ta_act_nm", ""));
		setExptDtlTpDesc(JSPUtil.getParameter(request, "expt_dtl_tp_desc", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFomlPctNo(JSPUtil.getParameter(request, "foml_pct_no", ""));
		setExptDtlTpNm(JSPUtil.getParameter(request, "expt_dtl_tp_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setExptLocCd(JSPUtil.getParameter(request, "expt_loc_cd", ""));
		setToActNm(JSPUtil.getParameter(request, "to_act_nm", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setActFlg(JSPUtil.getParameter(request, "act_flg", ""));
		setFmActDesc(JSPUtil.getParameter(request, "fm_act_desc", ""));
		setFomlTmMin(JSPUtil.getParameter(request, "foml_tm_min", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setFomlTmHrs(JSPUtil.getParameter(request, "foml_tm_hrs", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setExptTpDesc(JSPUtil.getParameter(request, "expt_tp_desc", ""));
		setToAct(JSPUtil.getParameter(request, "to_act", ""));
		setExptTpDtl(JSPUtil.getParameter(request, "expt_tp_dtl", ""));
		setFmAct(JSPUtil.getParameter(request, "fm_act", ""));
		setExptTp(JSPUtil.getParameter(request, "expt_tp", ""));
		setFomlTmDys(JSPUtil.getParameter(request, "foml_tm_dys", ""));
		setToActDesc(JSPUtil.getParameter(request, "to_act_desc", ""));
		setNodCd(JSPUtil.getParameter(request, "nod_cd", ""));
		setFaActNm(JSPUtil.getParameter(request, "fa_act_nm", ""));
		setExptTpNm(JSPUtil.getParameter(request, "expt_tp_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchToleranceListVO[]
	 */
	public SearchToleranceListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchToleranceListVO[]
	 */
	public SearchToleranceListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchToleranceListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "expt_tp");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "expt_tp").length;
  
		try {
			String[] fmActNm = (JSPUtil.getParameter(request, prefix	+ "fm_act_nm", length));
			String[] taActNm = (JSPUtil.getParameter(request, prefix	+ "ta_act_nm", length));
			String[] exptDtlTpDesc = (JSPUtil.getParameter(request, prefix	+ "expt_dtl_tp_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fomlPctNo = (JSPUtil.getParameter(request, prefix	+ "foml_pct_no", length));
			String[] exptDtlTpNm = (JSPUtil.getParameter(request, prefix	+ "expt_dtl_tp_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] exptLocCd = (JSPUtil.getParameter(request, prefix	+ "expt_loc_cd", length));
			String[] toActNm = (JSPUtil.getParameter(request, prefix	+ "to_act_nm", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] actFlg = (JSPUtil.getParameter(request, prefix	+ "act_flg", length));
			String[] fmActDesc = (JSPUtil.getParameter(request, prefix	+ "fm_act_desc", length));
			String[] fomlTmMin = (JSPUtil.getParameter(request, prefix	+ "foml_tm_min", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] fomlTmHrs = (JSPUtil.getParameter(request, prefix	+ "foml_tm_hrs", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] exptTpDesc = (JSPUtil.getParameter(request, prefix	+ "expt_tp_desc", length));
			String[] toAct = (JSPUtil.getParameter(request, prefix	+ "to_act", length));
			String[] exptTpDtl = (JSPUtil.getParameter(request, prefix	+ "expt_tp_dtl", length));
			String[] fmAct = (JSPUtil.getParameter(request, prefix	+ "fm_act", length));
			String[] exptTp = (JSPUtil.getParameter(request, prefix	+ "expt_tp", length));
			String[] fomlTmDys = (JSPUtil.getParameter(request, prefix	+ "foml_tm_dys", length));
			String[] toActDesc = (JSPUtil.getParameter(request, prefix	+ "to_act_desc", length));
			String[] nodCd = (JSPUtil.getParameter(request, prefix	+ "nod_cd", length));
			String[] faActNm = (JSPUtil.getParameter(request, prefix	+ "fa_act_nm", length));
			String[] exptTpNm = (JSPUtil.getParameter(request, prefix	+ "expt_tp_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchToleranceListVO();
				if (fmActNm[i] != null)
					model.setFmActNm(fmActNm[i]);
				if (taActNm[i] != null)
					model.setTaActNm(taActNm[i]);
				if (exptDtlTpDesc[i] != null)
					model.setExptDtlTpDesc(exptDtlTpDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fomlPctNo[i] != null)
					model.setFomlPctNo(fomlPctNo[i]);
				if (exptDtlTpNm[i] != null)
					model.setExptDtlTpNm(exptDtlTpNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (exptLocCd[i] != null)
					model.setExptLocCd(exptLocCd[i]);
				if (toActNm[i] != null)
					model.setToActNm(toActNm[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (actFlg[i] != null)
					model.setActFlg(actFlg[i]);
				if (fmActDesc[i] != null)
					model.setFmActDesc(fmActDesc[i]);
				if (fomlTmMin[i] != null)
					model.setFomlTmMin(fomlTmMin[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (fomlTmHrs[i] != null)
					model.setFomlTmHrs(fomlTmHrs[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (exptTpDesc[i] != null)
					model.setExptTpDesc(exptTpDesc[i]);
				if (toAct[i] != null)
					model.setToAct(toAct[i]);
				if (exptTpDtl[i] != null)
					model.setExptTpDtl(exptTpDtl[i]);
				if (fmAct[i] != null)
					model.setFmAct(fmAct[i]);
				if (exptTp[i] != null)
					model.setExptTp(exptTp[i]);
				if (fomlTmDys[i] != null)
					model.setFomlTmDys(fomlTmDys[i]);
				if (toActDesc[i] != null)
					model.setToActDesc(toActDesc[i]);
				if (nodCd[i] != null)
					model.setNodCd(nodCd[i]);
				if (faActNm[i] != null)
					model.setFaActNm(faActNm[i]);
				if (exptTpNm[i] != null)
					model.setExptTpNm(exptTpNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchToleranceListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchToleranceListVO[]
	 */
	public SearchToleranceListVO[] getSearchToleranceListVOs(){
		SearchToleranceListVO[] vos = (SearchToleranceListVO[])models.toArray(new SearchToleranceListVO[models.size()]);
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
		this.fmActNm = this.fmActNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taActNm = this.taActNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptDtlTpDesc = this.exptDtlTpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fomlPctNo = this.fomlPctNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptDtlTpNm = this.exptDtlTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptLocCd = this.exptLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toActNm = this.toActNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actFlg = this.actFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmActDesc = this.fmActDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fomlTmMin = this.fomlTmMin .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fomlTmHrs = this.fomlTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptTpDesc = this.exptTpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toAct = this.toAct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptTpDtl = this.exptTpDtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmAct = this.fmAct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptTp = this.exptTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fomlTmDys = this.fomlTmDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toActDesc = this.toActDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCd = this.nodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faActNm = this.faActNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptTpNm = this.exptTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
