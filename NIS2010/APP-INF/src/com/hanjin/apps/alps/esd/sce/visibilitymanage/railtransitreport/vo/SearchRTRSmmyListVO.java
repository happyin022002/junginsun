/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SearchRTRSmmyListVO.java
*@FileTitle : SearchRTRSmmyListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.20
*@LastModifier : 
*@LastVersion : 1.0
* 2013.06.20  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo;

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

public class SearchRTRSmmyListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchRTRSmmyListVO> models = new ArrayList<SearchRTRSmmyListVO>();
	
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String itchgN2ndDwllTmHrs = null;
	/* Column Info */
	private String mnth = null;
	/* Column Info */
	private String railTztmHrs = null;
	/* Column Info */
	private String slsFmDt = null;
	/* Column Info */
	private String trspBndCd = null;
	/* Column Info */
	private String destN2ndDwllTmHrs = null;
	/* Column Info */
	private String railRunTmHrs = null;
	/* Column Info */
	private String tmlDwllTmHrs = null;
	/* Column Info */
	private String cgoTpCd = null;
	/* Column Info */
	private String itchgN1stDwllTmHrs = null;
	/* Column Info */
	private String rankCd = null;
	/* Column Info */
	private String orgDwllTmHrs = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String destN1stDwllTmHrs = null;
	/* Column Info */
	private String fmNodCd = null;
	/* Column Info */
	private String ttlTztmHrs = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String boxCnt = null;
	/* Column Info */
	private String slsToDt = null;
	/* Column Info */
	private String week = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchRTRSmmyListVO() {}

	public SearchRTRSmmyListVO(String ibflag, String pagerows, String rankCd, String mnth, String week, String slsFmDt, String slsToDt, String cgoTpCd, String trspBndCd, String fmNodCd, String toNodCd, String boxCnt, String tmlDwllTmHrs, String orgDwllTmHrs, String railRunTmHrs, String itchgN1stDwllTmHrs, String itchgN2ndDwllTmHrs, String destN1stDwllTmHrs, String destN2ndDwllTmHrs, String railTztmHrs, String ttlTztmHrs) {
		this.toNodCd = toNodCd;
		this.itchgN2ndDwllTmHrs = itchgN2ndDwllTmHrs;
		this.mnth = mnth;
		this.railTztmHrs = railTztmHrs;
		this.slsFmDt = slsFmDt;
		this.trspBndCd = trspBndCd;
		this.destN2ndDwllTmHrs = destN2ndDwllTmHrs;
		this.railRunTmHrs = railRunTmHrs;
		this.tmlDwllTmHrs = tmlDwllTmHrs;
		this.cgoTpCd = cgoTpCd;
		this.itchgN1stDwllTmHrs = itchgN1stDwllTmHrs;
		this.rankCd = rankCd;
		this.orgDwllTmHrs = orgDwllTmHrs;
		this.pagerows = pagerows;
		this.destN1stDwllTmHrs = destN1stDwllTmHrs;
		this.fmNodCd = fmNodCd;
		this.ttlTztmHrs = ttlTztmHrs;
		this.ibflag = ibflag;
		this.boxCnt = boxCnt;
		this.slsToDt = slsToDt;
		this.week = week;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("itchg_n2nd_dwll_tm_hrs", getItchgN2ndDwllTmHrs());
		this.hashColumns.put("mnth", getMnth());
		this.hashColumns.put("rail_tztm_hrs", getRailTztmHrs());
		this.hashColumns.put("sls_fm_dt", getSlsFmDt());
		this.hashColumns.put("trsp_bnd_cd", getTrspBndCd());
		this.hashColumns.put("dest_n2nd_dwll_tm_hrs", getDestN2ndDwllTmHrs());
		this.hashColumns.put("rail_run_tm_hrs", getRailRunTmHrs());
		this.hashColumns.put("tml_dwll_tm_hrs", getTmlDwllTmHrs());
		this.hashColumns.put("cgo_tp_cd", getCgoTpCd());
		this.hashColumns.put("itchg_n1st_dwll_tm_hrs", getItchgN1stDwllTmHrs());
		this.hashColumns.put("rank_cd", getRankCd());
		this.hashColumns.put("org_dwll_tm_hrs", getOrgDwllTmHrs());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dest_n1st_dwll_tm_hrs", getDestN1stDwllTmHrs());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("ttl_tztm_hrs", getTtlTztmHrs());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("box_cnt", getBoxCnt());
		this.hashColumns.put("sls_to_dt", getSlsToDt());
		this.hashColumns.put("week", getWeek());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("itchg_n2nd_dwll_tm_hrs", "itchgN2ndDwllTmHrs");
		this.hashFields.put("mnth", "mnth");
		this.hashFields.put("rail_tztm_hrs", "railTztmHrs");
		this.hashFields.put("sls_fm_dt", "slsFmDt");
		this.hashFields.put("trsp_bnd_cd", "trspBndCd");
		this.hashFields.put("dest_n2nd_dwll_tm_hrs", "destN2ndDwllTmHrs");
		this.hashFields.put("rail_run_tm_hrs", "railRunTmHrs");
		this.hashFields.put("tml_dwll_tm_hrs", "tmlDwllTmHrs");
		this.hashFields.put("cgo_tp_cd", "cgoTpCd");
		this.hashFields.put("itchg_n1st_dwll_tm_hrs", "itchgN1stDwllTmHrs");
		this.hashFields.put("rank_cd", "rankCd");
		this.hashFields.put("org_dwll_tm_hrs", "orgDwllTmHrs");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dest_n1st_dwll_tm_hrs", "destN1stDwllTmHrs");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("ttl_tztm_hrs", "ttlTztmHrs");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("box_cnt", "boxCnt");
		this.hashFields.put("sls_to_dt", "slsToDt");
		this.hashFields.put("week", "week");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toNodCd
	 */
	public String getToNodCd() {
		return this.toNodCd;
	}
	
	/**
	 * Column Info
	 * @return itchgN2ndDwllTmHrs
	 */
	public String getItchgN2ndDwllTmHrs() {
		return this.itchgN2ndDwllTmHrs;
	}
	
	/**
	 * Column Info
	 * @return mnth
	 */
	public String getMnth() {
		return this.mnth;
	}
	
	/**
	 * Column Info
	 * @return railTztmHrs
	 */
	public String getRailTztmHrs() {
		return this.railTztmHrs;
	}
	
	/**
	 * Column Info
	 * @return slsFmDt
	 */
	public String getSlsFmDt() {
		return this.slsFmDt;
	}
	
	/**
	 * Column Info
	 * @return trspBndCd
	 */
	public String getTrspBndCd() {
		return this.trspBndCd;
	}
	
	/**
	 * Column Info
	 * @return destN2ndDwllTmHrs
	 */
	public String getDestN2ndDwllTmHrs() {
		return this.destN2ndDwllTmHrs;
	}
	
	/**
	 * Column Info
	 * @return railRunTmHrs
	 */
	public String getRailRunTmHrs() {
		return this.railRunTmHrs;
	}
	
	/**
	 * Column Info
	 * @return tmlDwllTmHrs
	 */
	public String getTmlDwllTmHrs() {
		return this.tmlDwllTmHrs;
	}
	
	/**
	 * Column Info
	 * @return cgoTpCd
	 */
	public String getCgoTpCd() {
		return this.cgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return itchgN1stDwllTmHrs
	 */
	public String getItchgN1stDwllTmHrs() {
		return this.itchgN1stDwllTmHrs;
	}
	
	/**
	 * Column Info
	 * @return rankCd
	 */
	public String getRankCd() {
		return this.rankCd;
	}
	
	/**
	 * Column Info
	 * @return orgDwllTmHrs
	 */
	public String getOrgDwllTmHrs() {
		return this.orgDwllTmHrs;
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
	 * @return destN1stDwllTmHrs
	 */
	public String getDestN1stDwllTmHrs() {
		return this.destN1stDwllTmHrs;
	}
	
	/**
	 * Column Info
	 * @return fmNodCd
	 */
	public String getFmNodCd() {
		return this.fmNodCd;
	}
	
	/**
	 * Column Info
	 * @return ttlTztmHrs
	 */
	public String getTtlTztmHrs() {
		return this.ttlTztmHrs;
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
	 * @return boxCnt
	 */
	public String getBoxCnt() {
		return this.boxCnt;
	}
	
	/**
	 * Column Info
	 * @return slsToDt
	 */
	public String getSlsToDt() {
		return this.slsToDt;
	}
	
	/**
	 * Column Info
	 * @return week
	 */
	public String getWeek() {
		return this.week;
	}
	

	/**
	 * Column Info
	 * @param toNodCd
	 */
	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
	}
	
	/**
	 * Column Info
	 * @param itchgN2ndDwllTmHrs
	 */
	public void setItchgN2ndDwllTmHrs(String itchgN2ndDwllTmHrs) {
		this.itchgN2ndDwllTmHrs = itchgN2ndDwllTmHrs;
	}
	
	/**
	 * Column Info
	 * @param mnth
	 */
	public void setMnth(String mnth) {
		this.mnth = mnth;
	}
	
	/**
	 * Column Info
	 * @param railTztmHrs
	 */
	public void setRailTztmHrs(String railTztmHrs) {
		this.railTztmHrs = railTztmHrs;
	}
	
	/**
	 * Column Info
	 * @param slsFmDt
	 */
	public void setSlsFmDt(String slsFmDt) {
		this.slsFmDt = slsFmDt;
	}
	
	/**
	 * Column Info
	 * @param trspBndCd
	 */
	public void setTrspBndCd(String trspBndCd) {
		this.trspBndCd = trspBndCd;
	}
	
	/**
	 * Column Info
	 * @param destN2ndDwllTmHrs
	 */
	public void setDestN2ndDwllTmHrs(String destN2ndDwllTmHrs) {
		this.destN2ndDwllTmHrs = destN2ndDwllTmHrs;
	}
	
	/**
	 * Column Info
	 * @param railRunTmHrs
	 */
	public void setRailRunTmHrs(String railRunTmHrs) {
		this.railRunTmHrs = railRunTmHrs;
	}
	
	/**
	 * Column Info
	 * @param tmlDwllTmHrs
	 */
	public void setTmlDwllTmHrs(String tmlDwllTmHrs) {
		this.tmlDwllTmHrs = tmlDwllTmHrs;
	}
	
	/**
	 * Column Info
	 * @param cgoTpCd
	 */
	public void setCgoTpCd(String cgoTpCd) {
		this.cgoTpCd = cgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param itchgN1stDwllTmHrs
	 */
	public void setItchgN1stDwllTmHrs(String itchgN1stDwllTmHrs) {
		this.itchgN1stDwllTmHrs = itchgN1stDwllTmHrs;
	}
	
	/**
	 * Column Info
	 * @param rankCd
	 */
	public void setRankCd(String rankCd) {
		this.rankCd = rankCd;
	}
	
	/**
	 * Column Info
	 * @param orgDwllTmHrs
	 */
	public void setOrgDwllTmHrs(String orgDwllTmHrs) {
		this.orgDwllTmHrs = orgDwllTmHrs;
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
	 * @param destN1stDwllTmHrs
	 */
	public void setDestN1stDwllTmHrs(String destN1stDwllTmHrs) {
		this.destN1stDwllTmHrs = destN1stDwllTmHrs;
	}
	
	/**
	 * Column Info
	 * @param fmNodCd
	 */
	public void setFmNodCd(String fmNodCd) {
		this.fmNodCd = fmNodCd;
	}
	
	/**
	 * Column Info
	 * @param ttlTztmHrs
	 */
	public void setTtlTztmHrs(String ttlTztmHrs) {
		this.ttlTztmHrs = ttlTztmHrs;
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
	 * @param boxCnt
	 */
	public void setBoxCnt(String boxCnt) {
		this.boxCnt = boxCnt;
	}
	
	/**
	 * Column Info
	 * @param slsToDt
	 */
	public void setSlsToDt(String slsToDt) {
		this.slsToDt = slsToDt;
	}
	
	/**
	 * Column Info
	 * @param week
	 */
	public void setWeek(String week) {
		this.week = week;
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
		setToNodCd(JSPUtil.getParameter(request, prefix + "to_nod_cd", ""));
		setItchgN2ndDwllTmHrs(JSPUtil.getParameter(request, prefix + "itchg_n2nd_dwll_tm_hrs", ""));
		setMnth(JSPUtil.getParameter(request, prefix + "mnth", ""));
		setRailTztmHrs(JSPUtil.getParameter(request, prefix + "rail_tztm_hrs", ""));
		setSlsFmDt(JSPUtil.getParameter(request, prefix + "sls_fm_dt", ""));
		setTrspBndCd(JSPUtil.getParameter(request, prefix + "trsp_bnd_cd", ""));
		setDestN2ndDwllTmHrs(JSPUtil.getParameter(request, prefix + "dest_n2nd_dwll_tm_hrs", ""));
		setRailRunTmHrs(JSPUtil.getParameter(request, prefix + "rail_run_tm_hrs", ""));
		setTmlDwllTmHrs(JSPUtil.getParameter(request, prefix + "tml_dwll_tm_hrs", ""));
		setCgoTpCd(JSPUtil.getParameter(request, prefix + "cgo_tp_cd", ""));
		setItchgN1stDwllTmHrs(JSPUtil.getParameter(request, prefix + "itchg_n1st_dwll_tm_hrs", ""));
		setRankCd(JSPUtil.getParameter(request, prefix + "rank_cd", ""));
		setOrgDwllTmHrs(JSPUtil.getParameter(request, prefix + "org_dwll_tm_hrs", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDestN1stDwllTmHrs(JSPUtil.getParameter(request, prefix + "dest_n1st_dwll_tm_hrs", ""));
		setFmNodCd(JSPUtil.getParameter(request, prefix + "fm_nod_cd", ""));
		setTtlTztmHrs(JSPUtil.getParameter(request, prefix + "ttl_tztm_hrs", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBoxCnt(JSPUtil.getParameter(request, prefix + "box_cnt", ""));
		setSlsToDt(JSPUtil.getParameter(request, prefix + "sls_to_dt", ""));
		setWeek(JSPUtil.getParameter(request, prefix + "week", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchRTRSmmyListVO[]
	 */
	public SearchRTRSmmyListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchRTRSmmyListVO[]
	 */
	public SearchRTRSmmyListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchRTRSmmyListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] itchgN2ndDwllTmHrs = (JSPUtil.getParameter(request, prefix	+ "itchg_n2nd_dwll_tm_hrs", length));
			String[] mnth = (JSPUtil.getParameter(request, prefix	+ "mnth", length));
			String[] railTztmHrs = (JSPUtil.getParameter(request, prefix	+ "rail_tztm_hrs", length));
			String[] slsFmDt = (JSPUtil.getParameter(request, prefix	+ "sls_fm_dt", length));
			String[] trspBndCd = (JSPUtil.getParameter(request, prefix	+ "trsp_bnd_cd", length));
			String[] destN2ndDwllTmHrs = (JSPUtil.getParameter(request, prefix	+ "dest_n2nd_dwll_tm_hrs", length));
			String[] railRunTmHrs = (JSPUtil.getParameter(request, prefix	+ "rail_run_tm_hrs", length));
			String[] tmlDwllTmHrs = (JSPUtil.getParameter(request, prefix	+ "tml_dwll_tm_hrs", length));
			String[] cgoTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_tp_cd", length));
			String[] itchgN1stDwllTmHrs = (JSPUtil.getParameter(request, prefix	+ "itchg_n1st_dwll_tm_hrs", length));
			String[] rankCd = (JSPUtil.getParameter(request, prefix	+ "rank_cd", length));
			String[] orgDwllTmHrs = (JSPUtil.getParameter(request, prefix	+ "org_dwll_tm_hrs", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] destN1stDwllTmHrs = (JSPUtil.getParameter(request, prefix	+ "dest_n1st_dwll_tm_hrs", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] ttlTztmHrs = (JSPUtil.getParameter(request, prefix	+ "ttl_tztm_hrs", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] boxCnt = (JSPUtil.getParameter(request, prefix	+ "box_cnt", length));
			String[] slsToDt = (JSPUtil.getParameter(request, prefix	+ "sls_to_dt", length));
			String[] week = (JSPUtil.getParameter(request, prefix	+ "week", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchRTRSmmyListVO();
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (itchgN2ndDwllTmHrs[i] != null)
					model.setItchgN2ndDwllTmHrs(itchgN2ndDwllTmHrs[i]);
				if (mnth[i] != null)
					model.setMnth(mnth[i]);
				if (railTztmHrs[i] != null)
					model.setRailTztmHrs(railTztmHrs[i]);
				if (slsFmDt[i] != null)
					model.setSlsFmDt(slsFmDt[i]);
				if (trspBndCd[i] != null)
					model.setTrspBndCd(trspBndCd[i]);
				if (destN2ndDwllTmHrs[i] != null)
					model.setDestN2ndDwllTmHrs(destN2ndDwllTmHrs[i]);
				if (railRunTmHrs[i] != null)
					model.setRailRunTmHrs(railRunTmHrs[i]);
				if (tmlDwllTmHrs[i] != null)
					model.setTmlDwllTmHrs(tmlDwllTmHrs[i]);
				if (cgoTpCd[i] != null)
					model.setCgoTpCd(cgoTpCd[i]);
				if (itchgN1stDwllTmHrs[i] != null)
					model.setItchgN1stDwllTmHrs(itchgN1stDwllTmHrs[i]);
				if (rankCd[i] != null)
					model.setRankCd(rankCd[i]);
				if (orgDwllTmHrs[i] != null)
					model.setOrgDwllTmHrs(orgDwllTmHrs[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (destN1stDwllTmHrs[i] != null)
					model.setDestN1stDwllTmHrs(destN1stDwllTmHrs[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (ttlTztmHrs[i] != null)
					model.setTtlTztmHrs(ttlTztmHrs[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (boxCnt[i] != null)
					model.setBoxCnt(boxCnt[i]);
				if (slsToDt[i] != null)
					model.setSlsToDt(slsToDt[i]);
				if (week[i] != null)
					model.setWeek(week[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchRTRSmmyListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchRTRSmmyListVO[]
	 */
	public SearchRTRSmmyListVO[] getSearchRTRSmmyListVOs(){
		SearchRTRSmmyListVO[] vos = (SearchRTRSmmyListVO[])models.toArray(new SearchRTRSmmyListVO[models.size()]);
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
		this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itchgN2ndDwllTmHrs = this.itchgN2ndDwllTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth = this.mnth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railTztmHrs = this.railTztmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsFmDt = this.slsFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspBndCd = this.trspBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destN2ndDwllTmHrs = this.destN2ndDwllTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railRunTmHrs = this.railRunTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlDwllTmHrs = this.tmlDwllTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTpCd = this.cgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itchgN1stDwllTmHrs = this.itchgN1stDwllTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rankCd = this.rankCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDwllTmHrs = this.orgDwllTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destN1stDwllTmHrs = this.destN1stDwllTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlTztmHrs = this.ttlTztmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.boxCnt = this.boxCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsToDt = this.slsToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.week = this.week .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
