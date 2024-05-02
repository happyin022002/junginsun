/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CHSInventoryByVariationDtlMGTVO.java
*@FileTitle : CHSInventoryByVariationDtlMGTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.10.16 조재성 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 조재성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CHSInventoryByVariationDtlMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CHSInventoryByVariationDtlMGTVO> models = new ArrayList<CHSInventoryByVariationDtlMGTVO>();
	
	/* Column Info */
	private String eqAsetStsCdTotal = null;
	/* Column Info */
	private String inqToDys = null;
	/* Column Info */
	private String location = null;
	/* Column Info */
	private String includeNp = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String stsEvntYdCd = null;
	/* Column Info */
	private String preCreDt = null;
	/* Column Info */
	private String includeEn = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String stsEventLocCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String preStsEvntYdCd = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String eqAsetStsCd = null;
	/* Column Info */
	private String preEqAsetStsCd = null;
	/* Column Info */
	private String eqTpszCdSize = null;
	/* Column Info */
	private String onhOfcCd = null;
	/* Column Info */
	private String stsEventDt = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String preStsEventLocCd = null;
	/* Column Info */
	private String backEndJobKey = null;
	/* Column Info */
	private String inqFmDys = null;
	/* Column Info */
	private String eqTpSz45 = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String eqTpSz40 = null;
	/* Column Info */
	private String eqTpSz20 = null;
	/* Column Info */
	private String preStsEventDt = null;
	/* Column Info */
	private String crntLocCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CHSInventoryByVariationDtlMGTVO() {}

	public CHSInventoryByVariationDtlMGTVO(String ibflag, String pagerows, String eqKndCd, String location, String crntLocCd, String includeNp, String includeEn, String inqFmDys, String inqToDys, String eqAsetStsCd, String eqAsetStsCdTotal, String eqTpSz20, String eqTpSz40, String eqTpSz45, String eqNo, String eqTpszCd, String onhOfcCd, String preEqAsetStsCd, String preStsEventDt, String preCreDt, String preStsEventLocCd, String preStsEvntYdCd, String stsEventDt, String creDt, String stsEventLocCd, String stsEvntYdCd, String eqTpszCdSize, String userId, String backEndJobKey) {
		this.eqAsetStsCdTotal = eqAsetStsCdTotal;
		this.inqToDys = inqToDys;
		this.location = location;
		this.includeNp = includeNp;
		this.creDt = creDt;
		this.stsEvntYdCd = stsEvntYdCd;
		this.preCreDt = preCreDt;
		this.includeEn = includeEn;
		this.pagerows = pagerows;
		this.stsEventLocCd = stsEventLocCd;
		this.ibflag = ibflag;
		this.preStsEvntYdCd = preStsEvntYdCd;
		this.eqNo = eqNo;
		this.eqAsetStsCd = eqAsetStsCd;
		this.preEqAsetStsCd = preEqAsetStsCd;
		this.eqTpszCdSize = eqTpszCdSize;
		this.onhOfcCd = onhOfcCd;
		this.stsEventDt = stsEventDt;
		this.userId = userId;
		this.preStsEventLocCd = preStsEventLocCd;
		this.backEndJobKey = backEndJobKey;
		this.inqFmDys = inqFmDys;
		this.eqTpSz45 = eqTpSz45;
		this.eqKndCd = eqKndCd;
		this.eqTpszCd = eqTpszCd;
		this.eqTpSz40 = eqTpSz40;
		this.eqTpSz20 = eqTpSz20;
		this.preStsEventDt = preStsEventDt;
		this.crntLocCd = crntLocCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eq_aset_sts_cd_total", getEqAsetStsCdTotal());
		this.hashColumns.put("inq_to_dys", getInqToDys());
		this.hashColumns.put("location", getLocation());
		this.hashColumns.put("include_np", getIncludeNp());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("sts_evnt_yd_cd", getStsEvntYdCd());
		this.hashColumns.put("pre_cre_dt", getPreCreDt());
		this.hashColumns.put("include_en", getIncludeEn());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sts_event_loc_cd", getStsEventLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pre_sts_evnt_yd_cd", getPreStsEvntYdCd());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("eq_aset_sts_cd", getEqAsetStsCd());
		this.hashColumns.put("pre_eq_aset_sts_cd", getPreEqAsetStsCd());
		this.hashColumns.put("eq_tpsz_cd_size", getEqTpszCdSize());
		this.hashColumns.put("onh_ofc_cd", getOnhOfcCd());
		this.hashColumns.put("sts_event_dt", getStsEventDt());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("pre_sts_event_loc_cd", getPreStsEventLocCd());
		this.hashColumns.put("back_end_job_key", getBackEndJobKey());
		this.hashColumns.put("inq_fm_dys", getInqFmDys());
		this.hashColumns.put("eq_tp_sz_45", getEqTpSz45());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("eq_tp_sz_40", getEqTpSz40());
		this.hashColumns.put("eq_tp_sz_20", getEqTpSz20());
		this.hashColumns.put("pre_sts_event_dt", getPreStsEventDt());
		this.hashColumns.put("crnt_loc_cd", getCrntLocCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eq_aset_sts_cd_total", "eqAsetStsCdTotal");
		this.hashFields.put("inq_to_dys", "inqToDys");
		this.hashFields.put("location", "location");
		this.hashFields.put("include_np", "includeNp");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("sts_evnt_yd_cd", "stsEvntYdCd");
		this.hashFields.put("pre_cre_dt", "preCreDt");
		this.hashFields.put("include_en", "includeEn");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sts_event_loc_cd", "stsEventLocCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pre_sts_evnt_yd_cd", "preStsEvntYdCd");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("eq_aset_sts_cd", "eqAsetStsCd");
		this.hashFields.put("pre_eq_aset_sts_cd", "preEqAsetStsCd");
		this.hashFields.put("eq_tpsz_cd_size", "eqTpszCdSize");
		this.hashFields.put("onh_ofc_cd", "onhOfcCd");
		this.hashFields.put("sts_event_dt", "stsEventDt");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("pre_sts_event_loc_cd", "preStsEventLocCd");
		this.hashFields.put("back_end_job_key", "backEndJobKey");
		this.hashFields.put("inq_fm_dys", "inqFmDys");
		this.hashFields.put("eq_tp_sz_45", "eqTpSz45");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("eq_tp_sz_40", "eqTpSz40");
		this.hashFields.put("eq_tp_sz_20", "eqTpSz20");
		this.hashFields.put("pre_sts_event_dt", "preStsEventDt");
		this.hashFields.put("crnt_loc_cd", "crntLocCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return eqAsetStsCdTotal
	 */
	public String getEqAsetStsCdTotal() {
		return this.eqAsetStsCdTotal;
	}
	
	/**
	 * Column Info
	 * @return inqToDys
	 */
	public String getInqToDys() {
		return this.inqToDys;
	}
	
	/**
	 * Column Info
	 * @return location
	 */
	public String getLocation() {
		return this.location;
	}
	
	/**
	 * Column Info
	 * @return includeNp
	 */
	public String getIncludeNp() {
		return this.includeNp;
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
	 * @return stsEvntYdCd
	 */
	public String getStsEvntYdCd() {
		return this.stsEvntYdCd;
	}
	
	/**
	 * Column Info
	 * @return preCreDt
	 */
	public String getPreCreDt() {
		return this.preCreDt;
	}
	
	/**
	 * Column Info
	 * @return includeEn
	 */
	public String getIncludeEn() {
		return this.includeEn;
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
	 * @return stsEventLocCd
	 */
	public String getStsEventLocCd() {
		return this.stsEventLocCd;
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
	 * @return preStsEvntYdCd
	 */
	public String getPreStsEvntYdCd() {
		return this.preStsEvntYdCd;
	}
	
	/**
	 * Column Info
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return eqAsetStsCd
	 */
	public String getEqAsetStsCd() {
		return this.eqAsetStsCd;
	}
	
	/**
	 * Column Info
	 * @return preEqAsetStsCd
	 */
	public String getPreEqAsetStsCd() {
		return this.preEqAsetStsCd;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCdSize
	 */
	public String getEqTpszCdSize() {
		return this.eqTpszCdSize;
	}
	
	/**
	 * Column Info
	 * @return onhOfcCd
	 */
	public String getOnhOfcCd() {
		return this.onhOfcCd;
	}
	
	/**
	 * Column Info
	 * @return stsEventDt
	 */
	public String getStsEventDt() {
		return this.stsEventDt;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return preStsEventLocCd
	 */
	public String getPreStsEventLocCd() {
		return this.preStsEventLocCd;
	}
	
	/**
	 * Column Info
	 * @return backEndJobKey
	 */
	public String getBackEndJobKey() {
		return this.backEndJobKey;
	}
	
	/**
	 * Column Info
	 * @return inqFmDys
	 */
	public String getInqFmDys() {
		return this.inqFmDys;
	}
	
	/**
	 * Column Info
	 * @return eqTpSz45
	 */
	public String getEqTpSz45() {
		return this.eqTpSz45;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @return eqTpSz40
	 */
	public String getEqTpSz40() {
		return this.eqTpSz40;
	}
	
	/**
	 * Column Info
	 * @return eqTpSz20
	 */
	public String getEqTpSz20() {
		return this.eqTpSz20;
	}
	
	/**
	 * Column Info
	 * @return preStsEventDt
	 */
	public String getPreStsEventDt() {
		return this.preStsEventDt;
	}
	
	/**
	 * Column Info
	 * @return crntLocCd
	 */
	public String getCrntLocCd() {
		return this.crntLocCd;
	}
	

	/**
	 * Column Info
	 * @param eqAsetStsCdTotal
	 */
	public void setEqAsetStsCdTotal(String eqAsetStsCdTotal) {
		this.eqAsetStsCdTotal = eqAsetStsCdTotal;
	}
	
	/**
	 * Column Info
	 * @param inqToDys
	 */
	public void setInqToDys(String inqToDys) {
		this.inqToDys = inqToDys;
	}
	
	/**
	 * Column Info
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * Column Info
	 * @param includeNp
	 */
	public void setIncludeNp(String includeNp) {
		this.includeNp = includeNp;
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
	 * @param stsEvntYdCd
	 */
	public void setStsEvntYdCd(String stsEvntYdCd) {
		this.stsEvntYdCd = stsEvntYdCd;
	}
	
	/**
	 * Column Info
	 * @param preCreDt
	 */
	public void setPreCreDt(String preCreDt) {
		this.preCreDt = preCreDt;
	}
	
	/**
	 * Column Info
	 * @param includeEn
	 */
	public void setIncludeEn(String includeEn) {
		this.includeEn = includeEn;
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
	 * @param stsEventLocCd
	 */
	public void setStsEventLocCd(String stsEventLocCd) {
		this.stsEventLocCd = stsEventLocCd;
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
	 * @param preStsEvntYdCd
	 */
	public void setPreStsEvntYdCd(String preStsEvntYdCd) {
		this.preStsEvntYdCd = preStsEvntYdCd;
	}
	
	/**
	 * Column Info
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param eqAsetStsCd
	 */
	public void setEqAsetStsCd(String eqAsetStsCd) {
		this.eqAsetStsCd = eqAsetStsCd;
	}
	
	/**
	 * Column Info
	 * @param preEqAsetStsCd
	 */
	public void setPreEqAsetStsCd(String preEqAsetStsCd) {
		this.preEqAsetStsCd = preEqAsetStsCd;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCdSize
	 */
	public void setEqTpszCdSize(String eqTpszCdSize) {
		this.eqTpszCdSize = eqTpszCdSize;
	}
	
	/**
	 * Column Info
	 * @param onhOfcCd
	 */
	public void setOnhOfcCd(String onhOfcCd) {
		this.onhOfcCd = onhOfcCd;
	}
	
	/**
	 * Column Info
	 * @param stsEventDt
	 */
	public void setStsEventDt(String stsEventDt) {
		this.stsEventDt = stsEventDt;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param preStsEventLocCd
	 */
	public void setPreStsEventLocCd(String preStsEventLocCd) {
		this.preStsEventLocCd = preStsEventLocCd;
	}
	
	/**
	 * Column Info
	 * @param backEndJobKey
	 */
	public void setBackEndJobKey(String backEndJobKey) {
		this.backEndJobKey = backEndJobKey;
	}
	
	/**
	 * Column Info
	 * @param inqFmDys
	 */
	public void setInqFmDys(String inqFmDys) {
		this.inqFmDys = inqFmDys;
	}
	
	/**
	 * Column Info
	 * @param eqTpSz45
	 */
	public void setEqTpSz45(String eqTpSz45) {
		this.eqTpSz45 = eqTpSz45;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @param eqTpSz40
	 */
	public void setEqTpSz40(String eqTpSz40) {
		this.eqTpSz40 = eqTpSz40;
	}
	
	/**
	 * Column Info
	 * @param eqTpSz20
	 */
	public void setEqTpSz20(String eqTpSz20) {
		this.eqTpSz20 = eqTpSz20;
	}
	
	/**
	 * Column Info
	 * @param preStsEventDt
	 */
	public void setPreStsEventDt(String preStsEventDt) {
		this.preStsEventDt = preStsEventDt;
	}
	
	/**
	 * Column Info
	 * @param crntLocCd
	 */
	public void setCrntLocCd(String crntLocCd) {
		this.crntLocCd = crntLocCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setEqAsetStsCdTotal(JSPUtil.getParameter(request, "eq_aset_sts_cd_total", ""));
		setInqToDys(JSPUtil.getParameter(request, "inq_to_dys", ""));
		setLocation(JSPUtil.getParameter(request, "location", ""));
		setIncludeNp(JSPUtil.getParameter(request, "include_np", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setStsEvntYdCd(JSPUtil.getParameter(request, "sts_evnt_yd_cd", ""));
		setPreCreDt(JSPUtil.getParameter(request, "pre_cre_dt", ""));
		setIncludeEn(JSPUtil.getParameter(request, "include_en", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setStsEventLocCd(JSPUtil.getParameter(request, "sts_event_loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPreStsEvntYdCd(JSPUtil.getParameter(request, "pre_sts_evnt_yd_cd", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setEqAsetStsCd(JSPUtil.getParameter(request, "eq_aset_sts_cd", ""));
		setPreEqAsetStsCd(JSPUtil.getParameter(request, "pre_eq_aset_sts_cd", ""));
		setEqTpszCdSize(JSPUtil.getParameter(request, "eq_tpsz_cd_size", ""));
		setOnhOfcCd(JSPUtil.getParameter(request, "onh_ofc_cd", ""));
		setStsEventDt(JSPUtil.getParameter(request, "sts_event_dt", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setPreStsEventLocCd(JSPUtil.getParameter(request, "pre_sts_event_loc_cd", ""));
		setBackEndJobKey(JSPUtil.getParameter(request, "back_end_job_key", ""));
		setInqFmDys(JSPUtil.getParameter(request, "inq_fm_dys", ""));
		setEqTpSz45(JSPUtil.getParameter(request, "eq_tp_sz_45", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setEqTpSz40(JSPUtil.getParameter(request, "eq_tp_sz_40", ""));
		setEqTpSz20(JSPUtil.getParameter(request, "eq_tp_sz_20", ""));
		setPreStsEventDt(JSPUtil.getParameter(request, "pre_sts_event_dt", ""));
		setCrntLocCd(JSPUtil.getParameter(request, "crnt_loc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CHSInventoryByVariationDtlMGTVO[]
	 */
	public CHSInventoryByVariationDtlMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CHSInventoryByVariationDtlMGTVO[]
	 */
	public CHSInventoryByVariationDtlMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CHSInventoryByVariationDtlMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] eqAsetStsCdTotal = (JSPUtil.getParameter(request, prefix	+ "eq_aset_sts_cd_total", length));
			String[] inqToDys = (JSPUtil.getParameter(request, prefix	+ "inq_to_dys", length));
			String[] location = (JSPUtil.getParameter(request, prefix	+ "location", length));
			String[] includeNp = (JSPUtil.getParameter(request, prefix	+ "include_np", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] stsEvntYdCd = (JSPUtil.getParameter(request, prefix	+ "sts_evnt_yd_cd", length));
			String[] preCreDt = (JSPUtil.getParameter(request, prefix	+ "pre_cre_dt", length));
			String[] includeEn = (JSPUtil.getParameter(request, prefix	+ "include_en", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] stsEventLocCd = (JSPUtil.getParameter(request, prefix	+ "sts_event_loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] preStsEvntYdCd = (JSPUtil.getParameter(request, prefix	+ "pre_sts_evnt_yd_cd", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] eqAsetStsCd = (JSPUtil.getParameter(request, prefix	+ "eq_aset_sts_cd", length));
			String[] preEqAsetStsCd = (JSPUtil.getParameter(request, prefix	+ "pre_eq_aset_sts_cd", length));
			String[] eqTpszCdSize = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd_size", length));
			String[] onhOfcCd = (JSPUtil.getParameter(request, prefix	+ "onh_ofc_cd", length));
			String[] stsEventDt = (JSPUtil.getParameter(request, prefix	+ "sts_event_dt", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] preStsEventLocCd = (JSPUtil.getParameter(request, prefix	+ "pre_sts_event_loc_cd", length));
			String[] backEndJobKey = (JSPUtil.getParameter(request, prefix	+ "back_end_job_key", length));
			String[] inqFmDys = (JSPUtil.getParameter(request, prefix	+ "inq_fm_dys", length));
			String[] eqTpSz45 = (JSPUtil.getParameter(request, prefix	+ "eq_tp_sz_45", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] eqTpSz40 = (JSPUtil.getParameter(request, prefix	+ "eq_tp_sz_40", length));
			String[] eqTpSz20 = (JSPUtil.getParameter(request, prefix	+ "eq_tp_sz_20", length));
			String[] preStsEventDt = (JSPUtil.getParameter(request, prefix	+ "pre_sts_event_dt", length));
			String[] crntLocCd = (JSPUtil.getParameter(request, prefix	+ "crnt_loc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CHSInventoryByVariationDtlMGTVO();
				if (eqAsetStsCdTotal[i] != null)
					model.setEqAsetStsCdTotal(eqAsetStsCdTotal[i]);
				if (inqToDys[i] != null)
					model.setInqToDys(inqToDys[i]);
				if (location[i] != null)
					model.setLocation(location[i]);
				if (includeNp[i] != null)
					model.setIncludeNp(includeNp[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (stsEvntYdCd[i] != null)
					model.setStsEvntYdCd(stsEvntYdCd[i]);
				if (preCreDt[i] != null)
					model.setPreCreDt(preCreDt[i]);
				if (includeEn[i] != null)
					model.setIncludeEn(includeEn[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (stsEventLocCd[i] != null)
					model.setStsEventLocCd(stsEventLocCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (preStsEvntYdCd[i] != null)
					model.setPreStsEvntYdCd(preStsEvntYdCd[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (eqAsetStsCd[i] != null)
					model.setEqAsetStsCd(eqAsetStsCd[i]);
				if (preEqAsetStsCd[i] != null)
					model.setPreEqAsetStsCd(preEqAsetStsCd[i]);
				if (eqTpszCdSize[i] != null)
					model.setEqTpszCdSize(eqTpszCdSize[i]);
				if (onhOfcCd[i] != null)
					model.setOnhOfcCd(onhOfcCd[i]);
				if (stsEventDt[i] != null)
					model.setStsEventDt(stsEventDt[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (preStsEventLocCd[i] != null)
					model.setPreStsEventLocCd(preStsEventLocCd[i]);
				if (backEndJobKey[i] != null)
					model.setBackEndJobKey(backEndJobKey[i]);
				if (inqFmDys[i] != null)
					model.setInqFmDys(inqFmDys[i]);
				if (eqTpSz45[i] != null)
					model.setEqTpSz45(eqTpSz45[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (eqTpSz40[i] != null)
					model.setEqTpSz40(eqTpSz40[i]);
				if (eqTpSz20[i] != null)
					model.setEqTpSz20(eqTpSz20[i]);
				if (preStsEventDt[i] != null)
					model.setPreStsEventDt(preStsEventDt[i]);
				if (crntLocCd[i] != null)
					model.setCrntLocCd(crntLocCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCHSInventoryByVariationDtlMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CHSInventoryByVariationDtlMGTVO[]
	 */
	public CHSInventoryByVariationDtlMGTVO[] getCHSInventoryByVariationDtlMGTVOs(){
		CHSInventoryByVariationDtlMGTVO[] vos = (CHSInventoryByVariationDtlMGTVO[])models.toArray(new CHSInventoryByVariationDtlMGTVO[models.size()]);
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
		this.eqAsetStsCdTotal = this.eqAsetStsCdTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inqToDys = this.inqToDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.location = this.location .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.includeNp = this.includeNp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsEvntYdCd = this.stsEvntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preCreDt = this.preCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.includeEn = this.includeEn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsEventLocCd = this.stsEventLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preStsEvntYdCd = this.preStsEvntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqAsetStsCd = this.eqAsetStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preEqAsetStsCd = this.preEqAsetStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdSize = this.eqTpszCdSize .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhOfcCd = this.onhOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsEventDt = this.stsEventDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preStsEventLocCd = this.preStsEventLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.backEndJobKey = this.backEndJobKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inqFmDys = this.inqFmDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpSz45 = this.eqTpSz45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpSz40 = this.eqTpSz40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpSz20 = this.eqTpSz20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preStsEventDt = this.preStsEventDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntLocCd = this.crntLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
