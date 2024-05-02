/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SearchYardDwellHistoryVO.javaVO.java
*@FileTitle : SearchYardDwellHistoryVO.javaVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.19
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.19  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.vo;

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

public class SearchYardDwellHistoryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchYardDwellHistoryVO> models = new ArrayList<SearchYardDwellHistoryVO>();
	
	/* Column Info */
	private String ibRfAvgDwllHrs = null;
	/* Column Info */
	private String obDryAvgDwllHrs = null;
	/* Column Info */
	private String copIbDryAvgDwllHrs = null;
	/* Column Info */
	private String obRfMinDwllHrs = null;
	/* Column Info */
	private String obDryMinDwllHrs = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String copIbRfAvgDwllHrs = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ibDryMinDwllHrs = null;
	/* Column Info */
	private String obRfAvgDwllHrs = null;
	/* Column Info */
	private String copObRfAvgDwllHrs = null;
	/* Column Info */
	private String nodCd = null;
	/* Column Info */
	private String copObDryAvgDwllHrs = null;
	/* Column Info */
	private String hisMonth = null;
	/* Column Info */
	private String ibDryAvgDwllHrs = null;
	/* Column Info */
	private String ibRfMinDwllHrs = null;
	private String searchNodCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchYardDwellHistoryVO() {}

	public SearchYardDwellHistoryVO(String ibflag, String pagerows, String nodCd, String hisMonth, String ibDryAvgDwllHrs, String ibRfAvgDwllHrs, String obDryAvgDwllHrs, String obRfAvgDwllHrs, String copIbDryAvgDwllHrs, String copIbRfAvgDwllHrs, String copObDryAvgDwllHrs, String copObRfAvgDwllHrs, String ibDryMinDwllHrs, String ibRfMinDwllHrs, String obDryMinDwllHrs, String obRfMinDwllHrs, String searchNodCd) {
		this.ibRfAvgDwllHrs = ibRfAvgDwllHrs;
		this.obDryAvgDwllHrs = obDryAvgDwllHrs;
		this.copIbDryAvgDwllHrs = copIbDryAvgDwllHrs;
		this.obRfMinDwllHrs = obRfMinDwllHrs;
		this.obDryMinDwllHrs = obDryMinDwllHrs;
		this.pagerows = pagerows;
		this.copIbRfAvgDwllHrs = copIbRfAvgDwllHrs;
		this.ibflag = ibflag;
		this.ibDryMinDwllHrs = ibDryMinDwllHrs;
		this.obRfAvgDwllHrs = obRfAvgDwllHrs;
		this.copObRfAvgDwllHrs = copObRfAvgDwllHrs;
		this.nodCd = nodCd;
		this.copObDryAvgDwllHrs = copObDryAvgDwllHrs;
		this.hisMonth = hisMonth;
		this.ibDryAvgDwllHrs = ibDryAvgDwllHrs;
		this.ibRfMinDwllHrs = ibRfMinDwllHrs;
		this.searchNodCd = searchNodCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ib_rf_avg_dwll_hrs", getIbRfAvgDwllHrs());
		this.hashColumns.put("ob_dry_avg_dwll_hrs", getObDryAvgDwllHrs());
		this.hashColumns.put("cop_ib_dry_avg_dwll_hrs", getCopIbDryAvgDwllHrs());
		this.hashColumns.put("ob_rf_min_dwll_hrs", getObRfMinDwllHrs());
		this.hashColumns.put("ob_dry_min_dwll_hrs", getObDryMinDwllHrs());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cop_ib_rf_avg_dwll_hrs", getCopIbRfAvgDwllHrs());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ib_dry_min_dwll_hrs", getIbDryMinDwllHrs());
		this.hashColumns.put("ob_rf_avg_dwll_hrs", getObRfAvgDwllHrs());
		this.hashColumns.put("cop_ob_rf_avg_dwll_hrs", getCopObRfAvgDwllHrs());
		this.hashColumns.put("nod_cd", getNodCd());
		this.hashColumns.put("cop_ob_dry_avg_dwll_hrs", getCopObDryAvgDwllHrs());
		this.hashColumns.put("his_month", getHisMonth());
		this.hashColumns.put("ib_dry_avg_dwll_hrs", getIbDryAvgDwllHrs());
		this.hashColumns.put("ib_rf_min_dwll_hrs", getIbRfMinDwllHrs());
		this.hashColumns.put("search_nod_cd", getSearchNodCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ib_rf_avg_dwll_hrs", "ibRfAvgDwllHrs");
		this.hashFields.put("ob_dry_avg_dwll_hrs", "obDryAvgDwllHrs");
		this.hashFields.put("cop_ib_dry_avg_dwll_hrs", "copIbDryAvgDwllHrs");
		this.hashFields.put("ob_rf_min_dwll_hrs", "obRfMinDwllHrs");
		this.hashFields.put("ob_dry_min_dwll_hrs", "obDryMinDwllHrs");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cop_ib_rf_avg_dwll_hrs", "copIbRfAvgDwllHrs");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ib_dry_min_dwll_hrs", "ibDryMinDwllHrs");
		this.hashFields.put("ob_rf_avg_dwll_hrs", "obRfAvgDwllHrs");
		this.hashFields.put("cop_ob_rf_avg_dwll_hrs", "copObRfAvgDwllHrs");
		this.hashFields.put("nod_cd", "nodCd");
		this.hashFields.put("cop_ob_dry_avg_dwll_hrs", "copObDryAvgDwllHrs");
		this.hashFields.put("his_month", "hisMonth");
		this.hashFields.put("ib_dry_avg_dwll_hrs", "ibDryAvgDwllHrs");
		this.hashFields.put("ib_rf_min_dwll_hrs", "ibRfMinDwllHrs");
		this.hashFields.put("search_nod_cd", "searchNodCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ibRfAvgDwllHrs
	 */
	public String getIbRfAvgDwllHrs() {
		return this.ibRfAvgDwllHrs;
	}
	
	/**
	 * Column Info
	 * @return obDryAvgDwllHrs
	 */
	public String getObDryAvgDwllHrs() {
		return this.obDryAvgDwllHrs;
	}
	
	/**
	 * Column Info
	 * @return copIbDryAvgDwllHrs
	 */
	public String getCopIbDryAvgDwllHrs() {
		return this.copIbDryAvgDwllHrs;
	}
	
	/**
	 * Column Info
	 * @return obRfMinDwllHrs
	 */
	public String getObRfMinDwllHrs() {
		return this.obRfMinDwllHrs;
	}
	
	/**
	 * Column Info
	 * @return obDryMinDwllHrs
	 */
	public String getObDryMinDwllHrs() {
		return this.obDryMinDwllHrs;
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
	 * @return copIbRfAvgDwllHrs
	 */
	public String getCopIbRfAvgDwllHrs() {
		return this.copIbRfAvgDwllHrs;
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
	 * @return ibDryMinDwllHrs
	 */
	public String getIbDryMinDwllHrs() {
		return this.ibDryMinDwllHrs;
	}
	
	/**
	 * Column Info
	 * @return obRfAvgDwllHrs
	 */
	public String getObRfAvgDwllHrs() {
		return this.obRfAvgDwllHrs;
	}
	
	/**
	 * Column Info
	 * @return copObRfAvgDwllHrs
	 */
	public String getCopObRfAvgDwllHrs() {
		return this.copObRfAvgDwllHrs;
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
	 * @return copObDryAvgDwllHrs
	 */
	public String getCopObDryAvgDwllHrs() {
		return this.copObDryAvgDwllHrs;
	}
	
	/**
	 * Column Info
	 * @return hisMonth
	 */
	public String getHisMonth() {
		return this.hisMonth;
	}
	
	/**
	 * Column Info
	 * @return ibDryAvgDwllHrs
	 */
	public String getIbDryAvgDwllHrs() {
		return this.ibDryAvgDwllHrs;
	}
	
	/**
	 * Column Info
	 * @return ibRfMinDwllHrs
	 */
	public String getIbRfMinDwllHrs() {
		return this.ibRfMinDwllHrs;
	}
	

	public String getSearchNodCd() {
		return searchNodCd;
	}

	public void setSearchNodCd(String searchNodCd) {
		this.searchNodCd = searchNodCd;
	}

	/**
	 * Column Info
	 * @param ibRfAvgDwllHrs
	 */
	public void setIbRfAvgDwllHrs(String ibRfAvgDwllHrs) {
		this.ibRfAvgDwllHrs = ibRfAvgDwllHrs;
	}
	
	/**
	 * Column Info
	 * @param obDryAvgDwllHrs
	 */
	public void setObDryAvgDwllHrs(String obDryAvgDwllHrs) {
		this.obDryAvgDwllHrs = obDryAvgDwllHrs;
	}
	
	/**
	 * Column Info
	 * @param copIbDryAvgDwllHrs
	 */
	public void setCopIbDryAvgDwllHrs(String copIbDryAvgDwllHrs) {
		this.copIbDryAvgDwllHrs = copIbDryAvgDwllHrs;
	}
	
	/**
	 * Column Info
	 * @param obRfMinDwllHrs
	 */
	public void setObRfMinDwllHrs(String obRfMinDwllHrs) {
		this.obRfMinDwllHrs = obRfMinDwllHrs;
	}
	
	/**
	 * Column Info
	 * @param obDryMinDwllHrs
	 */
	public void setObDryMinDwllHrs(String obDryMinDwllHrs) {
		this.obDryMinDwllHrs = obDryMinDwllHrs;
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
	 * @param copIbRfAvgDwllHrs
	 */
	public void setCopIbRfAvgDwllHrs(String copIbRfAvgDwllHrs) {
		this.copIbRfAvgDwllHrs = copIbRfAvgDwllHrs;
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
	 * @param ibDryMinDwllHrs
	 */
	public void setIbDryMinDwllHrs(String ibDryMinDwllHrs) {
		this.ibDryMinDwllHrs = ibDryMinDwllHrs;
	}
	
	/**
	 * Column Info
	 * @param obRfAvgDwllHrs
	 */
	public void setObRfAvgDwllHrs(String obRfAvgDwllHrs) {
		this.obRfAvgDwllHrs = obRfAvgDwllHrs;
	}
	
	/**
	 * Column Info
	 * @param copObRfAvgDwllHrs
	 */
	public void setCopObRfAvgDwllHrs(String copObRfAvgDwllHrs) {
		this.copObRfAvgDwllHrs = copObRfAvgDwllHrs;
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
	 * @param copObDryAvgDwllHrs
	 */
	public void setCopObDryAvgDwllHrs(String copObDryAvgDwllHrs) {
		this.copObDryAvgDwllHrs = copObDryAvgDwllHrs;
	}
	
	/**
	 * Column Info
	 * @param hisMonth
	 */
	public void setHisMonth(String hisMonth) {
		this.hisMonth = hisMonth;
	}
	
	/**
	 * Column Info
	 * @param ibDryAvgDwllHrs
	 */
	public void setIbDryAvgDwllHrs(String ibDryAvgDwllHrs) {
		this.ibDryAvgDwllHrs = ibDryAvgDwllHrs;
	}
	
	/**
	 * Column Info
	 * @param ibRfMinDwllHrs
	 */
	public void setIbRfMinDwllHrs(String ibRfMinDwllHrs) {
		this.ibRfMinDwllHrs = ibRfMinDwllHrs;
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
		setIbRfAvgDwllHrs(JSPUtil.getParameter(request, prefix + "ib_rf_avg_dwll_hrs", ""));
		setObDryAvgDwllHrs(JSPUtil.getParameter(request, prefix + "ob_dry_avg_dwll_hrs", ""));
		setCopIbDryAvgDwllHrs(JSPUtil.getParameter(request, prefix + "cop_ib_dry_avg_dwll_hrs", ""));
		setObRfMinDwllHrs(JSPUtil.getParameter(request, prefix + "ob_rf_min_dwll_hrs", ""));
		setObDryMinDwllHrs(JSPUtil.getParameter(request, prefix + "ob_dry_min_dwll_hrs", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCopIbRfAvgDwllHrs(JSPUtil.getParameter(request, prefix + "cop_ib_rf_avg_dwll_hrs", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setIbDryMinDwllHrs(JSPUtil.getParameter(request, prefix + "ib_dry_min_dwll_hrs", ""));
		setObRfAvgDwllHrs(JSPUtil.getParameter(request, prefix + "ob_rf_avg_dwll_hrs", ""));
		setCopObRfAvgDwllHrs(JSPUtil.getParameter(request, prefix + "cop_ob_rf_avg_dwll_hrs", ""));
		setNodCd(JSPUtil.getParameter(request, prefix + "nod_cd", ""));
		setCopObDryAvgDwllHrs(JSPUtil.getParameter(request, prefix + "cop_ob_dry_avg_dwll_hrs", ""));
		setHisMonth(JSPUtil.getParameter(request, prefix + "his_month", ""));
		setIbDryAvgDwllHrs(JSPUtil.getParameter(request, prefix + "ib_dry_avg_dwll_hrs", ""));
		setIbRfMinDwllHrs(JSPUtil.getParameter(request, prefix + "ib_rf_min_dwll_hrs", ""));
		setSearchNodCd(JSPUtil.getParameter(request, prefix + "search_nod_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchYardDwellHistoryVO.javaVO[]
	 */
	public SearchYardDwellHistoryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchYardDwellHistoryVO.javaVO[]
	 */
	public SearchYardDwellHistoryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchYardDwellHistoryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibRfAvgDwllHrs = (JSPUtil.getParameter(request, prefix	+ "ib_rf_avg_dwll_hrs", length));
			String[] obDryAvgDwllHrs = (JSPUtil.getParameter(request, prefix	+ "ob_dry_avg_dwll_hrs", length));
			String[] copIbDryAvgDwllHrs = (JSPUtil.getParameter(request, prefix	+ "cop_ib_dry_avg_dwll_hrs", length));
			String[] obRfMinDwllHrs = (JSPUtil.getParameter(request, prefix	+ "ob_rf_min_dwll_hrs", length));
			String[] obDryMinDwllHrs = (JSPUtil.getParameter(request, prefix	+ "ob_dry_min_dwll_hrs", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] copIbRfAvgDwllHrs = (JSPUtil.getParameter(request, prefix	+ "cop_ib_rf_avg_dwll_hrs", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ibDryMinDwllHrs = (JSPUtil.getParameter(request, prefix	+ "ib_dry_min_dwll_hrs", length));
			String[] obRfAvgDwllHrs = (JSPUtil.getParameter(request, prefix	+ "ob_rf_avg_dwll_hrs", length));
			String[] copObRfAvgDwllHrs = (JSPUtil.getParameter(request, prefix	+ "cop_ob_rf_avg_dwll_hrs", length));
			String[] nodCd = (JSPUtil.getParameter(request, prefix	+ "nod_cd", length));
			String[] copObDryAvgDwllHrs = (JSPUtil.getParameter(request, prefix	+ "cop_ob_dry_avg_dwll_hrs", length));
			String[] hisMonth = (JSPUtil.getParameter(request, prefix	+ "his_month", length));
			String[] ibDryAvgDwllHrs = (JSPUtil.getParameter(request, prefix	+ "ib_dry_avg_dwll_hrs", length));
			String[] ibRfMinDwllHrs = (JSPUtil.getParameter(request, prefix	+ "ib_rf_min_dwll_hrs", length));
			String[] searchNodCd = (JSPUtil.getParameter(request, prefix	+ "search_nod_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchYardDwellHistoryVO();
				if (ibRfAvgDwllHrs[i] != null)
					model.setIbRfAvgDwllHrs(ibRfAvgDwllHrs[i]);
				if (obDryAvgDwllHrs[i] != null)
					model.setObDryAvgDwllHrs(obDryAvgDwllHrs[i]);
				if (copIbDryAvgDwllHrs[i] != null)
					model.setCopIbDryAvgDwllHrs(copIbDryAvgDwllHrs[i]);
				if (obRfMinDwllHrs[i] != null)
					model.setObRfMinDwllHrs(obRfMinDwllHrs[i]);
				if (obDryMinDwllHrs[i] != null)
					model.setObDryMinDwllHrs(obDryMinDwllHrs[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (copIbRfAvgDwllHrs[i] != null)
					model.setCopIbRfAvgDwllHrs(copIbRfAvgDwllHrs[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ibDryMinDwllHrs[i] != null)
					model.setIbDryMinDwllHrs(ibDryMinDwllHrs[i]);
				if (obRfAvgDwllHrs[i] != null)
					model.setObRfAvgDwllHrs(obRfAvgDwllHrs[i]);
				if (copObRfAvgDwllHrs[i] != null)
					model.setCopObRfAvgDwllHrs(copObRfAvgDwllHrs[i]);
				if (nodCd[i] != null)
					model.setNodCd(nodCd[i]);
				if (copObDryAvgDwllHrs[i] != null)
					model.setCopObDryAvgDwllHrs(copObDryAvgDwllHrs[i]);
				if (hisMonth[i] != null)
					model.setHisMonth(hisMonth[i]);
				if (ibDryAvgDwllHrs[i] != null)
					model.setIbDryAvgDwllHrs(ibDryAvgDwllHrs[i]);
				if (ibRfMinDwllHrs[i] != null)
					model.setIbRfMinDwllHrs(ibRfMinDwllHrs[i]);
				if (searchNodCd[i] != null)
					model.setSearchNodCd(searchNodCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchYardDwellHistoryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchYardDwellHistoryVO.javaVO[]
	 */
	public SearchYardDwellHistoryVO[] getSearchYardDwellHistoryVOs(){
		SearchYardDwellHistoryVO[] vos = (SearchYardDwellHistoryVO[])models.toArray(new SearchYardDwellHistoryVO[models.size()]);
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
		this.ibRfAvgDwllHrs = this.ibRfAvgDwllHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obDryAvgDwllHrs = this.obDryAvgDwllHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copIbDryAvgDwllHrs = this.copIbDryAvgDwllHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obRfMinDwllHrs = this.obRfMinDwllHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obDryMinDwllHrs = this.obDryMinDwllHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copIbRfAvgDwllHrs = this.copIbRfAvgDwllHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibDryMinDwllHrs = this.ibDryMinDwllHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obRfAvgDwllHrs = this.obRfAvgDwllHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copObRfAvgDwllHrs = this.copObRfAvgDwllHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCd = this.nodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copObDryAvgDwllHrs = this.copObDryAvgDwllHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisMonth = this.hisMonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibDryAvgDwllHrs = this.ibDryAvgDwllHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibRfMinDwllHrs = this.ibRfMinDwllHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchNodCd = this.searchNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
