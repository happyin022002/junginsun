/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TotalLossINVO.java
*@FileTitle : TotalLossINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.31
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.05.31 박명신
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.vo;

import java.util.ArrayList;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박명신
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TotalLossINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<TotalLossINVO> models = new ArrayList<TotalLossINVO>();

	/* Column Info */
	private String rqstDt = null;
	/* Column Info */
	private String inOfcCdTp = null;
	/* Column Info */
	private String inTtlLssNo = null;
	/* Column Info */
	private String inStatusTp = null;
	/* Column Info */
	private String ttlLssNo = null;
	/* Column Info */
	private String workType = null;
	/* Column Info */
	private String aproOfcCd = null;
	/* Column Info */
	private String inStDt = null;
	/* Column Info */
	private String inRqstEqNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rhqOfcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inSearchDtTp = null;
	/* Column Info */
	private String inEndDt = null;
	/* Column Info */
	private String inRqstOfcCd = null;
	/* Column Info */
	private String ttlLssDt = null;
	/* Column Info */
	private String rqstOfcCd = null;
	/* Column Info */
	private String ttlLssDtlRsnCd = null;
	/* Column Info */
	private String mnrInvTpCd = null;
	/* Column Info */
	private String ttlLssRsnCd = null;
	/* Column Info */
	private String respbOfcCd = null;
	/* Column Info */
	private String ttlLssStsCd = null;
	/* Column Info */
	private String searchTtlLssNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

	public TotalLossINVO() {}

	public TotalLossINVO(String ibflag, String pagerows, String rqstDt, String inOfcCdTp, String inTtlLssNo, String inStatusTp, String ttlLssNo, String workType, String aproOfcCd, String inStDt, String inRqstEqNo, String inSearchDtTp, String ttlLssDt, String inRqstOfcCd, String inEndDt, String ttlLssDtlRsnCd, String rqstOfcCd, String mnrInvTpCd, String respbOfcCd, String ttlLssRsnCd, String ttlLssStsCd, String searchTtlLssNo, String rhqOfcCd) {
		this.rqstDt = rqstDt;
		this.inOfcCdTp = inOfcCdTp;
		this.inTtlLssNo = inTtlLssNo;
		this.inStatusTp = inStatusTp;
		this.ttlLssNo = ttlLssNo;
		this.workType = workType;
		this.aproOfcCd = aproOfcCd;
		this.inStDt = inStDt;
		this.inRqstEqNo = inRqstEqNo;
		this.pagerows = pagerows;
		this.rhqOfcCd = rhqOfcCd;
		this.ibflag = ibflag;
		this.inSearchDtTp = inSearchDtTp;
		this.inEndDt = inEndDt;
		this.inRqstOfcCd = inRqstOfcCd;
		this.ttlLssDt = ttlLssDt;
		this.rqstOfcCd = rqstOfcCd;
		this.ttlLssDtlRsnCd = ttlLssDtlRsnCd;
		this.mnrInvTpCd = mnrInvTpCd;
		this.ttlLssRsnCd = ttlLssRsnCd;
		this.respbOfcCd = respbOfcCd;
		this.ttlLssStsCd = ttlLssStsCd;
		this.searchTtlLssNo = searchTtlLssNo;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("in_ofc_cd_tp", getInOfcCdTp());
		this.hashColumns.put("in_ttl_lss_no", getInTtlLssNo());
		this.hashColumns.put("in_status_tp", getInStatusTp());
		this.hashColumns.put("ttl_lss_no", getTtlLssNo());
		this.hashColumns.put("work_type", getWorkType());
		this.hashColumns.put("apro_ofc_cd", getAproOfcCd());
		this.hashColumns.put("in_st_dt", getInStDt());
		this.hashColumns.put("in_rqst_eq_no", getInRqstEqNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rhq_ofc_cd", getRhqOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("in_search_dt_tp", getInSearchDtTp());
		this.hashColumns.put("in_end_dt", getInEndDt());
		this.hashColumns.put("in_rqst_ofc_cd", getInRqstOfcCd());
		this.hashColumns.put("ttl_lss_dt", getTtlLssDt());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("ttl_lss_dtl_rsn_cd", getTtlLssDtlRsnCd());
		this.hashColumns.put("mnr_inv_tp_cd", getMnrInvTpCd());
		this.hashColumns.put("ttl_lss_rsn_cd", getTtlLssRsnCd());
		this.hashColumns.put("respb_ofc_cd", getRespbOfcCd());
		this.hashColumns.put("ttl_lss_sts_cd", getTtlLssStsCd());
		this.hashColumns.put("search_ttl_lss_no", getSearchTtlLssNo());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("in_ofc_cd_tp", "inOfcCdTp");
		this.hashFields.put("in_ttl_lss_no", "inTtlLssNo");
		this.hashFields.put("in_status_tp", "inStatusTp");
		this.hashFields.put("ttl_lss_no", "ttlLssNo");
		this.hashFields.put("work_type", "workType");
		this.hashFields.put("apro_ofc_cd", "aproOfcCd");
		this.hashFields.put("in_st_dt", "inStDt");
		this.hashFields.put("in_rqst_eq_no", "inRqstEqNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rhq_ofc_cd", "rhqOfcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("in_search_dt_tp", "inSearchDtTp");
		this.hashFields.put("in_end_dt", "inEndDt");
		this.hashFields.put("in_rqst_ofc_cd", "inRqstOfcCd");
		this.hashFields.put("ttl_lss_dt", "ttlLssDt");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("ttl_lss_dtl_rsn_cd", "ttlLssDtlRsnCd");
		this.hashFields.put("mnr_inv_tp_cd", "mnrInvTpCd");
		this.hashFields.put("ttl_lss_rsn_cd", "ttlLssRsnCd");
		this.hashFields.put("respb_ofc_cd", "respbOfcCd");
		this.hashFields.put("ttl_lss_sts_cd", "ttlLssStsCd");
		this.hashFields.put("search_ttl_lss_no", "searchTtlLssNo");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return rqstDt
	 */
	public String getRqstDt() {
		return this.rqstDt;
	}

	/**
	 * Column Info
	 * @return inOfcCdTp
	 */
	public String getInOfcCdTp() {
		return this.inOfcCdTp;
	}

	/**
	 * Column Info
	 * @return inTtlLssNo
	 */
	public String getInTtlLssNo() {
		return this.inTtlLssNo;
	}

	/**
	 * Column Info
	 * @return inStatusTp
	 */
	public String getInStatusTp() {
		return this.inStatusTp;
	}

	/**
	 * Column Info
	 * @return ttlLssNo
	 */
	public String getTtlLssNo() {
		return this.ttlLssNo;
	}

	/**
	 * Column Info
	 * @return workType
	 */
	public String getWorkType() {
		return this.workType;
	}

	/**
	 * Column Info
	 * @return aproOfcCd
	 */
	public String getAproOfcCd() {
		return this.aproOfcCd;
	}

	/**
	 * Column Info
	 * @return inStDt
	 */
	public String getInStDt() {
		return this.inStDt;
	}

	/**
	 * Column Info
	 * @return inRqstEqNo
	 */
	public String getInRqstEqNo() {
		return this.inRqstEqNo;
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
	 * @return rhqOfcCd
	 */
	public String getRhqOfcCd() {
		return this.rhqOfcCd;
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
	 * @return inSearchDtTp
	 */
	public String getInSearchDtTp() {
		return this.inSearchDtTp;
	}

	/**
	 * Column Info
	 * @return inEndDt
	 */
	public String getInEndDt() {
		return this.inEndDt;
	}

	/**
	 * Column Info
	 * @return inRqstOfcCd
	 */
	public String getInRqstOfcCd() {
		return this.inRqstOfcCd;
	}

	/**
	 * Column Info
	 * @return ttlLssDt
	 */
	public String getTtlLssDt() {
		return this.ttlLssDt;
	}

	/**
	 * Column Info
	 * @return rqstOfcCd
	 */
	public String getRqstOfcCd() {
		return this.rqstOfcCd;
	}

	/**
	 * Column Info
	 * @return ttlLssDtlRsnCd
	 */
	public String getTtlLssDtlRsnCd() {
		return this.ttlLssDtlRsnCd;
	}

	/**
	 * Column Info
	 * @return mnrInvTpCd
	 */
	public String getMnrInvTpCd() {
		return this.mnrInvTpCd;
	}

	/**
	 * Column Info
	 * @return ttlLssRsnCd
	 */
	public String getTtlLssRsnCd() {
		return this.ttlLssRsnCd;
	}

	/**
	 * Column Info
	 * @return respbOfcCd
	 */
	public String getRespbOfcCd() {
		return this.respbOfcCd;
	}

	/**
	 * Column Info
	 * @return ttlLssStsCd
	 */
	public String getTtlLssStsCd() {
		return this.ttlLssStsCd;
	}

	/**
	 * Column Info
	 * @return searchTtlLssNo
	 */
	public String getSearchTtlLssNo() {
		return this.searchTtlLssNo;
	}


	/**
	 * Column Info
	 * @param rqstDt
	 */
	public void setRqstDt(String rqstDt) {
		this.rqstDt = rqstDt;
	}

	/**
	 * Column Info
	 * @param inOfcCdTp
	 */
	public void setInOfcCdTp(String inOfcCdTp) {
		this.inOfcCdTp = inOfcCdTp;
	}

	/**
	 * Column Info
	 * @param inTtlLssNo
	 */
	public void setInTtlLssNo(String inTtlLssNo) {
		this.inTtlLssNo = inTtlLssNo;
	}

	/**
	 * Column Info
	 * @param inStatusTp
	 */
	public void setInStatusTp(String inStatusTp) {
		this.inStatusTp = inStatusTp;
	}

	/**
	 * Column Info
	 * @param ttlLssNo
	 */
	public void setTtlLssNo(String ttlLssNo) {
		this.ttlLssNo = ttlLssNo;
	}

	/**
	 * Column Info
	 * @param workType
	 */
	public void setWorkType(String workType) {
		this.workType = workType;
	}

	/**
	 * Column Info
	 * @param aproOfcCd
	 */
	public void setAproOfcCd(String aproOfcCd) {
		this.aproOfcCd = aproOfcCd;
	}

	/**
	 * Column Info
	 * @param inStDt
	 */
	public void setInStDt(String inStDt) {
		this.inStDt = inStDt;
	}

	/**
	 * Column Info
	 * @param inRqstEqNo
	 */
	public void setInRqstEqNo(String inRqstEqNo) {
		this.inRqstEqNo = inRqstEqNo;
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
	 * @param rhqOfcCd
	 */
	public void setRhqOfcCd(String rhqOfcCd) {
		this.rhqOfcCd = rhqOfcCd;
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
	 * @param inSearchDtTp
	 */
	public void setInSearchDtTp(String inSearchDtTp) {
		this.inSearchDtTp = inSearchDtTp;
	}

	/**
	 * Column Info
	 * @param inEndDt
	 */
	public void setInEndDt(String inEndDt) {
		this.inEndDt = inEndDt;
	}

	/**
	 * Column Info
	 * @param inRqstOfcCd
	 */
	public void setInRqstOfcCd(String inRqstOfcCd) {
		this.inRqstOfcCd = inRqstOfcCd;
	}

	/**
	 * Column Info
	 * @param ttlLssDt
	 */
	public void setTtlLssDt(String ttlLssDt) {
		this.ttlLssDt = ttlLssDt;
	}

	/**
	 * Column Info
	 * @param rqstOfcCd
	 */
	public void setRqstOfcCd(String rqstOfcCd) {
		this.rqstOfcCd = rqstOfcCd;
	}

	/**
	 * Column Info
	 * @param ttlLssDtlRsnCd
	 */
	public void setTtlLssDtlRsnCd(String ttlLssDtlRsnCd) {
		this.ttlLssDtlRsnCd = ttlLssDtlRsnCd;
	}

	/**
	 * Column Info
	 * @param mnrInvTpCd
	 */
	public void setMnrInvTpCd(String mnrInvTpCd) {
		this.mnrInvTpCd = mnrInvTpCd;
	}

	/**
	 * Column Info
	 * @param ttlLssRsnCd
	 */
	public void setTtlLssRsnCd(String ttlLssRsnCd) {
		this.ttlLssRsnCd = ttlLssRsnCd;
	}

	/**
	 * Column Info
	 * @param respbOfcCd
	 */
	public void setRespbOfcCd(String respbOfcCd) {
		this.respbOfcCd = respbOfcCd;
	}

	/**
	 * Column Info
	 * @param ttlLssStsCd
	 */
	public void setTtlLssStsCd(String ttlLssStsCd) {
		this.ttlLssStsCd = ttlLssStsCd;
	}

	/**
	 * Column Info
	 * @param searchTtlLssNo
	 */
	public void setSearchTtlLssNo(String searchTtlLssNo) {
		this.searchTtlLssNo = searchTtlLssNo;
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
		setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
		setInOfcCdTp(JSPUtil.getParameter(request, prefix + "in_ofc_cd_tp", ""));
		setInTtlLssNo(JSPUtil.getParameter(request, prefix + "in_ttl_lss_no", ""));
		setInStatusTp(JSPUtil.getParameter(request, prefix + "in_status_tp", ""));
		setTtlLssNo(JSPUtil.getParameter(request, prefix + "ttl_lss_no", ""));
		setWorkType(JSPUtil.getParameter(request, prefix + "work_type", ""));
		setAproOfcCd(JSPUtil.getParameter(request, prefix + "apro_ofc_cd", ""));
		setInStDt(JSPUtil.getParameter(request, prefix + "in_st_dt", ""));
		setInRqstEqNo(JSPUtil.getParameter(request, prefix + "in_rqst_eq_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRhqOfcCd(JSPUtil.getParameter(request, prefix + "rhq_ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInSearchDtTp(JSPUtil.getParameter(request, prefix + "in_search_dt_tp", ""));
		setInEndDt(JSPUtil.getParameter(request, prefix + "in_end_dt", ""));
		setInRqstOfcCd(JSPUtil.getParameter(request, prefix + "in_rqst_ofc_cd", ""));
		setTtlLssDt(JSPUtil.getParameter(request, prefix + "ttl_lss_dt", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, prefix + "rqst_ofc_cd", ""));
		setTtlLssDtlRsnCd(JSPUtil.getParameter(request, prefix + "ttl_lss_dtl_rsn_cd", ""));
		setMnrInvTpCd(JSPUtil.getParameter(request, prefix + "mnr_inv_tp_cd", ""));
		setTtlLssRsnCd(JSPUtil.getParameter(request, prefix + "ttl_lss_rsn_cd", ""));
		setRespbOfcCd(JSPUtil.getParameter(request, prefix + "respb_ofc_cd", ""));
		setTtlLssStsCd(JSPUtil.getParameter(request, prefix + "ttl_lss_sts_cd", ""));
		setSearchTtlLssNo(JSPUtil.getParameter(request, prefix + "search_ttl_lss_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TotalLossINVO[]
	 */
	public TotalLossINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return TotalLossINVO[]
	 */
	public TotalLossINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TotalLossINVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] inOfcCdTp = (JSPUtil.getParameter(request, prefix	+ "in_ofc_cd_tp", length));
			String[] inTtlLssNo = (JSPUtil.getParameter(request, prefix	+ "in_ttl_lss_no", length));
			String[] inStatusTp = (JSPUtil.getParameter(request, prefix	+ "in_status_tp", length));
			String[] ttlLssNo = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_no", length));
			String[] workType = (JSPUtil.getParameter(request, prefix	+ "work_type", length));
			String[] aproOfcCd = (JSPUtil.getParameter(request, prefix	+ "apro_ofc_cd", length));
			String[] inStDt = (JSPUtil.getParameter(request, prefix	+ "in_st_dt", length));
			String[] inRqstEqNo = (JSPUtil.getParameter(request, prefix	+ "in_rqst_eq_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "rhq_ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] inSearchDtTp = (JSPUtil.getParameter(request, prefix	+ "in_search_dt_tp", length));
			String[] inEndDt = (JSPUtil.getParameter(request, prefix	+ "in_end_dt", length));
			String[] inRqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "in_rqst_ofc_cd", length));
			String[] ttlLssDt = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_dt", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			String[] ttlLssDtlRsnCd = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_dtl_rsn_cd", length));
			String[] mnrInvTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_inv_tp_cd", length));
			String[] ttlLssRsnCd = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_rsn_cd", length));
			String[] respbOfcCd = (JSPUtil.getParameter(request, prefix	+ "respb_ofc_cd", length));
			String[] ttlLssStsCd = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_sts_cd", length));
			String[] searchTtlLssNo = (JSPUtil.getParameter(request, prefix	+ "search_ttl_lss_no", length));

			for (int i = 0; i < length; i++) {
				model = new TotalLossINVO();
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (inOfcCdTp[i] != null)
					model.setInOfcCdTp(inOfcCdTp[i]);
				if (inTtlLssNo[i] != null)
					model.setInTtlLssNo(inTtlLssNo[i]);
				if (inStatusTp[i] != null)
					model.setInStatusTp(inStatusTp[i]);
				if (ttlLssNo[i] != null)
					model.setTtlLssNo(ttlLssNo[i]);
				if (workType[i] != null)
					model.setWorkType(workType[i]);
				if (aproOfcCd[i] != null)
					model.setAproOfcCd(aproOfcCd[i]);
				if (inStDt[i] != null)
					model.setInStDt(inStDt[i]);
				if (inRqstEqNo[i] != null)
					model.setInRqstEqNo(inRqstEqNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rhqOfcCd[i] != null)
					model.setRhqOfcCd(rhqOfcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inSearchDtTp[i] != null)
					model.setInSearchDtTp(inSearchDtTp[i]);
				if (inEndDt[i] != null)
					model.setInEndDt(inEndDt[i]);
				if (inRqstOfcCd[i] != null)
					model.setInRqstOfcCd(inRqstOfcCd[i]);
				if (ttlLssDt[i] != null)
					model.setTtlLssDt(ttlLssDt[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				if (ttlLssDtlRsnCd[i] != null)
					model.setTtlLssDtlRsnCd(ttlLssDtlRsnCd[i]);
				if (mnrInvTpCd[i] != null)
					model.setMnrInvTpCd(mnrInvTpCd[i]);
				if (ttlLssRsnCd[i] != null)
					model.setTtlLssRsnCd(ttlLssRsnCd[i]);
				if (respbOfcCd[i] != null)
					model.setRespbOfcCd(respbOfcCd[i]);
				if (ttlLssStsCd[i] != null)
					model.setTtlLssStsCd(ttlLssStsCd[i]);
				if (searchTtlLssNo[i] != null)
					model.setSearchTtlLssNo(searchTtlLssNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTotalLossINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TotalLossINVO[]
	 */
	public TotalLossINVO[] getTotalLossINVOs(){
		TotalLossINVO[] vos = (TotalLossINVO[])models.toArray(new TotalLossINVO[models.size()]);
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
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inOfcCdTp = this.inOfcCdTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inTtlLssNo = this.inTtlLssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inStatusTp = this.inStatusTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssNo = this.ttlLssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.workType = this.workType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproOfcCd = this.aproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inStDt = this.inStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inRqstEqNo = this.inRqstEqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqOfcCd = this.rhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inSearchDtTp = this.inSearchDtTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inEndDt = this.inEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inRqstOfcCd = this.inRqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssDt = this.ttlLssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssDtlRsnCd = this.ttlLssDtlRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrInvTpCd = this.mnrInvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssRsnCd = this.ttlLssRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.respbOfcCd = this.respbOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssStsCd = this.ttlLssStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchTtlLssNo = this.searchTtlLssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
