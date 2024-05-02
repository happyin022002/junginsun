/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchLogisticsRPT00812ListVO.java
*@FileTitle : SearchLogisticsRPT00812ListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.12
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2011.07.12 최성민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.coa.multidimensionrpt.logisticsrpt.vo;

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
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchLogisticsRPT00812ListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchLogisticsRPT00812ListVO> models = new ArrayList<SearchLogisticsRPT00812ListVO>();
	
	/* Column Info */
	private String pReport = null;
	/* Column Info */
	private String vol = null;
	/* Column Info */
	private String inOut = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String totalCost = null;
	/* Column Info */
	private String kpiNm = null;
	/* Column Info */
	private String unitCost = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String lgsKpiCostGrpNm = null;
	/* Column Info */
	private String stndCostNm = null;
	/* Column Info */
	private String ctrlOfcCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchLogisticsRPT00812ListVO() {}

	public SearchLogisticsRPT00812ListVO(String ibflag, String pagerows, String pReport, String rhqCd, String ctrlOfcCd, String lgsKpiCostGrpNm, String kpiNm, String inOut, String vol, String stndCostNm, String totalCost, String unitCost) {
		this.pReport = pReport;
		this.vol = vol;
		this.inOut = inOut;
		this.ibflag = ibflag;
		this.totalCost = totalCost;
		this.kpiNm = kpiNm;
		this.unitCost = unitCost;
		this.rhqCd = rhqCd;
		this.lgsKpiCostGrpNm = lgsKpiCostGrpNm;
		this.stndCostNm = stndCostNm;
		this.ctrlOfcCd = ctrlOfcCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("p_report", getPReport());
		this.hashColumns.put("vol", getVol());
		this.hashColumns.put("in_out", getInOut());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("total_cost", getTotalCost());
		this.hashColumns.put("kpi_nm", getKpiNm());
		this.hashColumns.put("unit_cost", getUnitCost());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("lgs_kpi_cost_grp_nm", getLgsKpiCostGrpNm());
		this.hashColumns.put("stnd_cost_nm", getStndCostNm());
		this.hashColumns.put("ctrl_ofc_cd", getCtrlOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("p_report", "pReport");
		this.hashFields.put("vol", "vol");
		this.hashFields.put("in_out", "inOut");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("total_cost", "totalCost");
		this.hashFields.put("kpi_nm", "kpiNm");
		this.hashFields.put("unit_cost", "unitCost");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("lgs_kpi_cost_grp_nm", "lgsKpiCostGrpNm");
		this.hashFields.put("stnd_cost_nm", "stndCostNm");
		this.hashFields.put("ctrl_ofc_cd", "ctrlOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return pReport
	 */
	public String getPReport() {
		return this.pReport;
	}
	
	/**
	 * Column Info
	 * @return vol
	 */
	public String getVol() {
		return this.vol;
	}
	
	/**
	 * Column Info
	 * @return inOut
	 */
	public String getInOut() {
		return this.inOut;
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
	 * @return totalCost
	 */
	public String getTotalCost() {
		return this.totalCost;
	}
	
	/**
	 * Column Info
	 * @return kpiNm
	 */
	public String getKpiNm() {
		return this.kpiNm;
	}
	
	/**
	 * Column Info
	 * @return unitCost
	 */
	public String getUnitCost() {
		return this.unitCost;
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
	 * @return lgsKpiCostGrpNm
	 */
	public String getLgsKpiCostGrpNm() {
		return this.lgsKpiCostGrpNm;
	}
	
	/**
	 * Column Info
	 * @return stndCostNm
	 */
	public String getStndCostNm() {
		return this.stndCostNm;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd
	 */
	public String getCtrlOfcCd() {
		return this.ctrlOfcCd;
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
	 * @param pReport
	 */
	public void setPReport(String pReport) {
		this.pReport = pReport;
	}
	
	/**
	 * Column Info
	 * @param vol
	 */
	public void setVol(String vol) {
		this.vol = vol;
	}
	
	/**
	 * Column Info
	 * @param inOut
	 */
	public void setInOut(String inOut) {
		this.inOut = inOut;
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
	 * @param totalCost
	 */
	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
	}
	
	/**
	 * Column Info
	 * @param kpiNm
	 */
	public void setKpiNm(String kpiNm) {
		this.kpiNm = kpiNm;
	}
	
	/**
	 * Column Info
	 * @param unitCost
	 */
	public void setUnitCost(String unitCost) {
		this.unitCost = unitCost;
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
	 * @param lgsKpiCostGrpNm
	 */
	public void setLgsKpiCostGrpNm(String lgsKpiCostGrpNm) {
		this.lgsKpiCostGrpNm = lgsKpiCostGrpNm;
	}
	
	/**
	 * Column Info
	 * @param stndCostNm
	 */
	public void setStndCostNm(String stndCostNm) {
		this.stndCostNm = stndCostNm;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd
	 */
	public void setCtrlOfcCd(String ctrlOfcCd) {
		this.ctrlOfcCd = ctrlOfcCd;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setPReport(JSPUtil.getParameter(request, prefix + "p_report", ""));
		setVol(JSPUtil.getParameter(request, prefix + "vol", ""));
		setInOut(JSPUtil.getParameter(request, prefix + "in_out", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTotalCost(JSPUtil.getParameter(request, prefix + "total_cost", ""));
		setKpiNm(JSPUtil.getParameter(request, prefix + "kpi_nm", ""));
		setUnitCost(JSPUtil.getParameter(request, prefix + "unit_cost", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setLgsKpiCostGrpNm(JSPUtil.getParameter(request, prefix + "lgs_kpi_cost_grp_nm", ""));
		setStndCostNm(JSPUtil.getParameter(request, prefix + "stnd_cost_nm", ""));
		setCtrlOfcCd(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchLogisticsRPT00812ListVO[]
	 */
	public SearchLogisticsRPT00812ListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchLogisticsRPT00812ListVO[]
	 */
	public SearchLogisticsRPT00812ListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchLogisticsRPT00812ListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pReport = (JSPUtil.getParameter(request, prefix	+ "p_report", length));
			String[] vol = (JSPUtil.getParameter(request, prefix	+ "vol", length));
			String[] inOut = (JSPUtil.getParameter(request, prefix	+ "in_out", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] totalCost = (JSPUtil.getParameter(request, prefix	+ "total_cost", length));
			String[] kpiNm = (JSPUtil.getParameter(request, prefix	+ "kpi_nm", length));
			String[] unitCost = (JSPUtil.getParameter(request, prefix	+ "unit_cost", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] lgsKpiCostGrpNm = (JSPUtil.getParameter(request, prefix	+ "lgs_kpi_cost_grp_nm", length));
			String[] stndCostNm = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_nm", length));
			String[] ctrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchLogisticsRPT00812ListVO();
				if (pReport[i] != null)
					model.setPReport(pReport[i]);
				if (vol[i] != null)
					model.setVol(vol[i]);
				if (inOut[i] != null)
					model.setInOut(inOut[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (totalCost[i] != null)
					model.setTotalCost(totalCost[i]);
				if (kpiNm[i] != null)
					model.setKpiNm(kpiNm[i]);
				if (unitCost[i] != null)
					model.setUnitCost(unitCost[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (lgsKpiCostGrpNm[i] != null)
					model.setLgsKpiCostGrpNm(lgsKpiCostGrpNm[i]);
				if (stndCostNm[i] != null)
					model.setStndCostNm(stndCostNm[i]);
				if (ctrlOfcCd[i] != null)
					model.setCtrlOfcCd(ctrlOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchLogisticsRPT00812ListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchLogisticsRPT00812ListVO[]
	 */
	public SearchLogisticsRPT00812ListVO[] getSearchLogisticsRPT00812ListVOs(){
		SearchLogisticsRPT00812ListVO[] vos = (SearchLogisticsRPT00812ListVO[])models.toArray(new SearchLogisticsRPT00812ListVO[models.size()]);
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
		this.pReport = this.pReport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vol = this.vol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inOut = this.inOut .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCost = this.totalCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kpiNm = this.kpiNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unitCost = this.unitCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsKpiCostGrpNm = this.lgsKpiCostGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostNm = this.stndCostNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd = this.ctrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
