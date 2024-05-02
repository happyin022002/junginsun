/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchLogisticsRPT0081ListVO.java
*@FileTitle : SearchLogisticsRPT0081ListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.21  
* 1.0 Creation
* 
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

public class SearchLogisticsRPT0081ListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchLogisticsRPT0081ListVO> models = new ArrayList<SearchLogisticsRPT0081ListVO>();
	
	/* Column Info */
	private String totalCost = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String ctrlOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String kpiOrder = null;
	/* Column Info */
	private String pReport = null;
	/* Column Info */
	private String kpiCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vol = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String kpiNm = null;
	/* Column Info */
	private String unitCost = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String costActGrpTpCd = null;
	/* Column Info */
	private String costYrmonwk = null;
	/* Column Info */
	private String lgsKpiCostGrpNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	  * ESM_COA_0081화면용 VO 생성자
	  */
	public SearchLogisticsRPT0081ListVO() {}
	
	/**
	  * ESM_COA_0081화면용 VO 생성자
	  */
	public SearchLogisticsRPT0081ListVO(String ibflag, String pagerows, String pReport, String costYrmonwk, String costYrmon, String costWk, String rhqCd, String ctrlOfcCd, String costActGrpTpCd, String lgsKpiCostGrpNm, String kpiCd, String kpiNm, String vol, String totalCost, String unitCost, String kpiOrder) {
		this.totalCost = totalCost;
		this.rhqCd = rhqCd;
		this.ctrlOfcCd = ctrlOfcCd;
		this.pagerows = pagerows;
		this.kpiOrder = kpiOrder;
		this.pReport = pReport;
		this.kpiCd = kpiCd;
		this.ibflag = ibflag;
		this.vol = vol;
		this.costYrmon = costYrmon;
		this.kpiNm = kpiNm;
		this.unitCost = unitCost;
		this.costWk = costWk;
		this.costActGrpTpCd = costActGrpTpCd;
		this.costYrmonwk = costYrmonwk;
		this.lgsKpiCostGrpNm = lgsKpiCostGrpNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("total_cost", getTotalCost());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("ctrl_ofc_cd", getCtrlOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("kpi_order", getKpiOrder());
		this.hashColumns.put("p_report", getPReport());
		this.hashColumns.put("kpi_cd", getKpiCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vol", getVol());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("kpi_nm", getKpiNm());
		this.hashColumns.put("unit_cost", getUnitCost());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("cost_act_grp_tp_cd", getCostActGrpTpCd());
		this.hashColumns.put("cost_yrmonwk", getCostYrmonwk());
		this.hashColumns.put("lgs_kpi_cost_grp_nm", getLgsKpiCostGrpNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("total_cost", "totalCost");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("ctrl_ofc_cd", "ctrlOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("kpi_order", "kpiOrder");
		this.hashFields.put("p_report", "pReport");
		this.hashFields.put("kpi_cd", "kpiCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vol", "vol");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("kpi_nm", "kpiNm");
		this.hashFields.put("unit_cost", "unitCost");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("cost_act_grp_tp_cd", "costActGrpTpCd");
		this.hashFields.put("cost_yrmonwk", "costYrmonwk");
		this.hashFields.put("lgs_kpi_cost_grp_nm", "lgsKpiCostGrpNm");
		return this.hashFields;
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
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
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
	 * @return kpiOrder
	 */
	public String getKpiOrder() {
		return this.kpiOrder;
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
	 * @return kpiCd
	 */
	public String getKpiCd() {
		return this.kpiCd;
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
	 * @return vol
	 */
	public String getVol() {
		return this.vol;
	}
	
	/**
	 * Column Info
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
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
	 * @return costWk
	 */
	public String getCostWk() {
		return this.costWk;
	}
	
	/**
	 * Column Info
	 * @return costActGrpTpCd
	 */
	public String getCostActGrpTpCd() {
		return this.costActGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @return costYrmonwk
	 */
	public String getCostYrmonwk() {
		return this.costYrmonwk;
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
	 * @param totalCost
	 */
	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
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
	 * Column Info
	 * @param kpiOrder
	 */
	public void setKpiOrder(String kpiOrder) {
		this.kpiOrder = kpiOrder;
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
	 * @param kpiCd
	 */
	public void setKpiCd(String kpiCd) {
		this.kpiCd = kpiCd;
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
	 * @param vol
	 */
	public void setVol(String vol) {
		this.vol = vol;
	}
	
	/**
	 * Column Info
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
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
	 * @param costWk
	 */
	public void setCostWk(String costWk) {
		this.costWk = costWk;
	}
	
	/**
	 * Column Info
	 * @param costActGrpTpCd
	 */
	public void setCostActGrpTpCd(String costActGrpTpCd) {
		this.costActGrpTpCd = costActGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @param costYrmonwk
	 */
	public void setCostYrmonwk(String costYrmonwk) {
		this.costYrmonwk = costYrmonwk;
	}
	
	/**
	 * Column Info
	 * @param lgsKpiCostGrpNm
	 */
	public void setLgsKpiCostGrpNm(String lgsKpiCostGrpNm) {
		this.lgsKpiCostGrpNm = lgsKpiCostGrpNm;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTotalCost(JSPUtil.getParameter(request, "total_cost", ""));
		setRhqCd(JSPUtil.getParameter(request, "rhq_cd", ""));
		setCtrlOfcCd(JSPUtil.getParameter(request, "ctrl_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setKpiOrder(JSPUtil.getParameter(request, "kpi_order", ""));
		setPReport(JSPUtil.getParameter(request, "p_report", ""));
		setKpiCd(JSPUtil.getParameter(request, "kpi_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVol(JSPUtil.getParameter(request, "vol", ""));
		setCostYrmon(JSPUtil.getParameter(request, "cost_yrmon", ""));
		setKpiNm(JSPUtil.getParameter(request, "kpi_nm", ""));
		setUnitCost(JSPUtil.getParameter(request, "unit_cost", ""));
		setCostWk(JSPUtil.getParameter(request, "cost_wk", ""));
		setCostActGrpTpCd(JSPUtil.getParameter(request, "cost_act_grp_tp_cd", ""));
		setCostYrmonwk(JSPUtil.getParameter(request, "cost_yrmonwk", ""));
		setLgsKpiCostGrpNm(JSPUtil.getParameter(request, "lgs_kpi_cost_grp_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchLogisticsRPT0081ListVO[]
	 */
	public SearchLogisticsRPT0081ListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchLogisticsRPT0081ListVO[]
	 */
	public SearchLogisticsRPT0081ListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchLogisticsRPT0081ListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] totalCost = (JSPUtil.getParameter(request, prefix	+ "total_cost", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] ctrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] kpiOrder = (JSPUtil.getParameter(request, prefix	+ "kpi_order", length));
			String[] pReport = (JSPUtil.getParameter(request, prefix	+ "p_report", length));
			String[] kpiCd = (JSPUtil.getParameter(request, prefix	+ "kpi_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vol = (JSPUtil.getParameter(request, prefix	+ "vol", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] kpiNm = (JSPUtil.getParameter(request, prefix	+ "kpi_nm", length));
			String[] unitCost = (JSPUtil.getParameter(request, prefix	+ "unit_cost", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] costActGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "cost_act_grp_tp_cd", length));
			String[] costYrmonwk = (JSPUtil.getParameter(request, prefix	+ "cost_yrmonwk", length));
			String[] lgsKpiCostGrpNm = (JSPUtil.getParameter(request, prefix	+ "lgs_kpi_cost_grp_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchLogisticsRPT0081ListVO();
				if (totalCost[i] != null)
					model.setTotalCost(totalCost[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (ctrlOfcCd[i] != null)
					model.setCtrlOfcCd(ctrlOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (kpiOrder[i] != null)
					model.setKpiOrder(kpiOrder[i]);
				if (pReport[i] != null)
					model.setPReport(pReport[i]);
				if (kpiCd[i] != null)
					model.setKpiCd(kpiCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vol[i] != null)
					model.setVol(vol[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (kpiNm[i] != null)
					model.setKpiNm(kpiNm[i]);
				if (unitCost[i] != null)
					model.setUnitCost(unitCost[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (costActGrpTpCd[i] != null)
					model.setCostActGrpTpCd(costActGrpTpCd[i]);
				if (costYrmonwk[i] != null)
					model.setCostYrmonwk(costYrmonwk[i]);
				if (lgsKpiCostGrpNm[i] != null)
					model.setLgsKpiCostGrpNm(lgsKpiCostGrpNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchLogisticsRPT0081ListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchLogisticsRPT0081ListVO[]
	 */
	public SearchLogisticsRPT0081ListVO[] getSearchLogisticsRPT0081ListVOs(){
		SearchLogisticsRPT0081ListVO[] vos = (SearchLogisticsRPT0081ListVO[])models.toArray(new SearchLogisticsRPT0081ListVO[models.size()]);
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
		this.totalCost = this.totalCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd = this.ctrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kpiOrder = this.kpiOrder .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pReport = this.pReport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kpiCd = this.kpiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vol = this.vol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kpiNm = this.kpiNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unitCost = this.unitCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costActGrpTpCd = this.costActGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmonwk = this.costYrmonwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsKpiCostGrpNm = this.lgsKpiCostGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
