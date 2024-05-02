/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : SearchCostManagement0170ListVO.java
*@FileTitle      : SearchCostManagement0170ListVO
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 최초 생성
=========================================================*/

package com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.vo;

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
 * @author 김종호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchCostManagement0170ListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCostManagement0170ListVO> models = new ArrayList<SearchCostManagement0170ListVO>();
	
	/* Column Info */
	private String costDivDesc = null;
	/* Column Info */
	private String bseQtrCd = null;
	/* Column Info */
	private String applYr = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String applMon = null;
	/* Column Info */
	private String bseYr = null;
	/* Column Info */
	private String costDivCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchCostManagement0170ListVO() {}

	public SearchCostManagement0170ListVO(String ibflag, String pagerows, String bseYr, String bseQtrCd, String costDivCd, String costDivDesc, String applYr, String applMon) {
		this.costDivDesc = costDivDesc;
		this.bseQtrCd = bseQtrCd;
		this.applYr = applYr;
		this.ibflag = ibflag;
		this.applMon = applMon;
		this.bseYr = bseYr;
		this.costDivCd = costDivCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cost_div_desc", getCostDivDesc());
		this.hashColumns.put("bse_qtr_cd", getBseQtrCd());
		this.hashColumns.put("appl_yr", getApplYr());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("appl_mon", getApplMon());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("cost_div_cd", getCostDivCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cost_div_desc", "costDivDesc");
		this.hashFields.put("bse_qtr_cd", "bseQtrCd");
		this.hashFields.put("appl_yr", "applYr");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("appl_mon", "applMon");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("cost_div_cd", "costDivCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return costDivDesc
	 */
	public String getCostDivDesc() {
		return this.costDivDesc;
	}
	
	/**
	 * Column Info
	 * @return bseQtrCd
	 */
	public String getBseQtrCd() {
		return this.bseQtrCd;
	}
	
	/**
	 * Column Info
	 * @return applYr
	 */
	public String getApplYr() {
		return this.applYr;
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
	 * @return applMon
	 */
	public String getApplMon() {
		return this.applMon;
	}
	
	/**
	 * Column Info
	 * @return bseYr
	 */
	public String getBseYr() {
		return this.bseYr;
	}
	
	/**
	 * Column Info
	 * @return costDivCd
	 */
	public String getCostDivCd() {
		return this.costDivCd;
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
	 * @param costDivDesc
	 */
	public void setCostDivDesc(String costDivDesc) {
		this.costDivDesc = costDivDesc;
	}
	
	/**
	 * Column Info
	 * @param bseQtrCd
	 */
	public void setBseQtrCd(String bseQtrCd) {
		this.bseQtrCd = bseQtrCd;
	}
	
	/**
	 * Column Info
	 * @param applYr
	 */
	public void setApplYr(String applYr) {
		this.applYr = applYr;
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
	 * @param applMon
	 */
	public void setApplMon(String applMon) {
		this.applMon = applMon;
	}
	
	/**
	 * Column Info
	 * @param bseYr
	 */
	public void setBseYr(String bseYr) {
		this.bseYr = bseYr;
	}
	
	/**
	 * Column Info
	 * @param costDivCd
	 */
	public void setCostDivCd(String costDivCd) {
		this.costDivCd = costDivCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCostDivDesc(JSPUtil.getParameter(request, "cost_div_desc", ""));
		setBseQtrCd(JSPUtil.getParameter(request, "bse_qtr_cd", ""));
		setApplYr(JSPUtil.getParameter(request, "appl_yr", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setApplMon(JSPUtil.getParameter(request, "appl_mon", ""));
		setBseYr(JSPUtil.getParameter(request, "bse_yr", ""));
		setCostDivCd(JSPUtil.getParameter(request, "cost_div_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCostManagement0170ListVO[]
	 */
	public SearchCostManagement0170ListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCostManagement0170ListVO[]
	 */
	public SearchCostManagement0170ListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCostManagement0170ListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] costDivDesc = (JSPUtil.getParameter(request, prefix	+ "cost_div_desc", length));
			String[] bseQtrCd = (JSPUtil.getParameter(request, prefix	+ "bse_qtr_cd", length));
			String[] applYr = (JSPUtil.getParameter(request, prefix	+ "appl_yr", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] applMon = (JSPUtil.getParameter(request, prefix	+ "appl_mon", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] costDivCd = (JSPUtil.getParameter(request, prefix	+ "cost_div_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCostManagement0170ListVO();
				if (costDivDesc[i] != null)
					model.setCostDivDesc(costDivDesc[i]);
				if (bseQtrCd[i] != null)
					model.setBseQtrCd(bseQtrCd[i]);
				if (applYr[i] != null)
					model.setApplYr(applYr[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (applMon[i] != null)
					model.setApplMon(applMon[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (costDivCd[i] != null)
					model.setCostDivCd(costDivCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCostManagement0170ListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCostManagement0170ListVO[]
	 */
	public SearchCostManagement0170ListVO[] getSearchCostManagement0170ListVOs(){
		SearchCostManagement0170ListVO[] vos = (SearchCostManagement0170ListVO[])models.toArray(new SearchCostManagement0170ListVO[models.size()]);
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
		this.costDivDesc = this.costDivDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseQtrCd = this.bseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.applYr = this.applYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.applMon = this.applMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costDivCd = this.costDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
