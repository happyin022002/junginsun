/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchLogisticsRPT0081ListVO2.java
*@FileTitle : SearchLogisticsRPT0081ListVO2
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.21  
* 1.0 Creation
*  2010.02.04 임옥영 :품질검토결과 반영
=========================================================*/

package com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchLogisticsRPT0081ListVO2 extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchLogisticsRPT0081ListVO2> models = new ArrayList<SearchLogisticsRPT0081ListVO2>();
	
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
	
	/**
	  * Logistics Exp. by Office SHEET2 생성자
	  */
	public SearchLogisticsRPT0081ListVO2() {}

	/**
	  * Logistics Exp. by Office SHEET2 생성자
	  * 
	  * @param String ibflag
	  * @param String pagerows
	  * @param String pReport
	  * @param String rhqCd
	  * @param String ctrlOfcCd
	  * @param String lgsKpiCostGrpNm
	  * @param String kpiNm
	  * @param String inOut
	  * @param String vol
	  * @param String stndCostNm
	  * @param String totalCost
	  * @param String unitCost
	  */
	public SearchLogisticsRPT0081ListVO2(String ibflag, String pagerows, String pReport, String rhqCd, String ctrlOfcCd, String lgsKpiCostGrpNm, String kpiNm, String inOut, String vol, String stndCostNm, String totalCost, String unitCost) {
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
		setPReport(JSPUtil.getParameter(request, "p_report", ""));
		setVol(JSPUtil.getParameter(request, "vol", ""));
		setInOut(JSPUtil.getParameter(request, "in_out", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTotalCost(JSPUtil.getParameter(request, "total_cost", ""));
		setKpiNm(JSPUtil.getParameter(request, "kpi_nm", ""));
		setUnitCost(JSPUtil.getParameter(request, "unit_cost", ""));
		setRhqCd(JSPUtil.getParameter(request, "rhq_cd", ""));
		setLgsKpiCostGrpNm(JSPUtil.getParameter(request, "lgs_kpi_cost_grp_nm", ""));
		setStndCostNm(JSPUtil.getParameter(request, "stnd_cost_nm", ""));
		setCtrlOfcCd(JSPUtil.getParameter(request, "ctrl_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchLogisticsRPT0081ListVO2[]
	 */
	public SearchLogisticsRPT0081ListVO2[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchLogisticsRPT0081ListVO2[]
	 */
	public SearchLogisticsRPT0081ListVO2[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchLogisticsRPT0081ListVO2 model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] s_pReport = (JSPUtil.getParameter(request, prefix	+ "p_report", length));
			String[] s_vol = (JSPUtil.getParameter(request, prefix	+ "vol", length));
			String[] s_inOut = (JSPUtil.getParameter(request, prefix	+ "in_out", length));
			String[] s_ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] s_totalCost = (JSPUtil.getParameter(request, prefix	+ "total_cost", length));
			String[] s_kpiNm = (JSPUtil.getParameter(request, prefix	+ "kpi_nm", length));
			String[] s_unitCost = (JSPUtil.getParameter(request, prefix	+ "unit_cost", length));
			String[] s_rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] s_lgsKpiCostGrpNm = (JSPUtil.getParameter(request, prefix	+ "lgs_kpi_cost_grp_nm", length));
			String[] s_stndCostNm = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_nm", length));
			String[] s_ctrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd", length));
			String[] s_pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchLogisticsRPT0081ListVO2();
				if (s_pReport[i] != null)
					model.setPReport(s_pReport[i]);
				if (s_vol[i] != null)
					model.setVol(s_vol[i]);
				if (s_inOut[i] != null)
					model.setInOut(s_inOut[i]);
				if (s_ibflag[i] != null)
					model.setIbflag(s_ibflag[i]);
				if (s_totalCost[i] != null)
					model.setTotalCost(s_totalCost[i]);
				if (s_kpiNm[i] != null)
					model.setKpiNm(s_kpiNm[i]);
				if (s_unitCost[i] != null)
					model.setUnitCost(s_unitCost[i]);
				if (s_rhqCd[i] != null)
					model.setRhqCd(s_rhqCd[i]);
				if (s_lgsKpiCostGrpNm[i] != null)
					model.setLgsKpiCostGrpNm(s_lgsKpiCostGrpNm[i]);
				if (s_stndCostNm[i] != null)
					model.setStndCostNm(s_stndCostNm[i]);
				if (s_ctrlOfcCd[i] != null)
					model.setCtrlOfcCd(s_ctrlOfcCd[i]);
				if (s_pagerows[i] != null)
					model.setPagerows(s_pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchLogisticsRPT0081ListVO2s();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchLogisticsRPT0081ListVO2[]
	 */
	public SearchLogisticsRPT0081ListVO2[] getSearchLogisticsRPT0081ListVO2s(){
		SearchLogisticsRPT0081ListVO2[] vos = (SearchLogisticsRPT0081ListVO2[])models.toArray(new SearchLogisticsRPT0081ListVO2[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
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
