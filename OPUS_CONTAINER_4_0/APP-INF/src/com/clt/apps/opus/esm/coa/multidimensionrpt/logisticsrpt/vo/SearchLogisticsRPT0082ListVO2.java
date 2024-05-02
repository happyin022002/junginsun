/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchLogisticsRPT0082ListVO2.java
*@FileTitle : SearchLogisticsRPT0082ListVO2
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.02
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.02  
* 1.0 Creation
*  2010.02.04 임옥영 :품질검토결과 반영
* 2010.02.16 임옥영 소스품질검토 결과 반영 Line No. 119 :  : shall be matched with size of parameter
=========================================================*/

package com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchLogisticsRPT0082ListVO2 extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchLogisticsRPT0082ListVO2> models = new ArrayList<SearchLogisticsRPT0082ListVO2>();
	
	/* Column Info */
	private String totalCost = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String n2ndNodCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String inout = null;
	/* Column Info */
	private String stndCostNm = null;
	/* Column Info */
	private String ctrlOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vol = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String kpiNm = null;
	/* Column Info */
	private String n4thNodCd = null;
	/* Column Info */
	private String unitCost = null;
	/* Column Info */
	private String n1stNodCd = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String n3rdNodCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	/**
	  * Logistics Exp. by Node&Link SHEET2 VO 생성자
	  * 	  
	  */
	public SearchLogisticsRPT0082ListVO2() {}

	/**
	  * Logistics Exp. by Node&Link SHEET2 VO 생성자
	  * 
	  *@param String ibflag
	  *@param String pagerows
	  *@param String costYrmon
	  *@param String costWk
	  *@param String rhqCd
	  *@param String ctrlOfcCd
	  *@param String kpiNm
	  *@param String inout
	  *@param String n1stNodCd
	  *@param String n2ndNodCd
	  *@param String n3rdNodCd
	  *@param String n4thNodCd
	  *@param String trdCd
	  *@param String rlaneCd
	  *@param String dirCd
	  *@param String cntrTpszCd
	  *@param String vol
	  *@param String stndCostNm
	  *@param String totalCost
	  *@param String unitCost
	  */
	public SearchLogisticsRPT0082ListVO2(String ibflag, String pagerows, String costYrmon, String costWk, String rhqCd, String ctrlOfcCd, String kpiNm, String inout, String n1stNodCd, String n2ndNodCd, String n3rdNodCd, String n4thNodCd, String trdCd, String rlaneCd, String dirCd, String cntrTpszCd, String vol, String stndCostNm, String totalCost, String unitCost) {
		this.totalCost = totalCost;
		this.rhqCd = rhqCd;
		this.n2ndNodCd = n2ndNodCd;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.inout = inout;
		this.stndCostNm = stndCostNm;
		this.ctrlOfcCd = ctrlOfcCd;
		this.pagerows = pagerows;
		this.vol = vol;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.kpiNm = kpiNm;
		this.n4thNodCd = n4thNodCd;
		this.unitCost = unitCost;
		this.n1stNodCd = n1stNodCd;
		this.costWk = costWk;
		this.cntrTpszCd = cntrTpszCd;
		this.dirCd = dirCd;
		this.n3rdNodCd = n3rdNodCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("total_cost", getTotalCost());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("n2nd_nod_cd", getN2ndNodCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("inout", getInout());
		this.hashColumns.put("stnd_cost_nm", getStndCostNm());
		this.hashColumns.put("ctrl_ofc_cd", getCtrlOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vol", getVol());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("kpi_nm", getKpiNm());
		this.hashColumns.put("n4th_nod_cd", getN4thNodCd());
		this.hashColumns.put("unit_cost", getUnitCost());
		this.hashColumns.put("n1st_nod_cd", getN1stNodCd());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("n3rd_nod_cd", getN3rdNodCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("total_cost", "totalCost");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("n2nd_nod_cd", "n2ndNodCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("inout", "inout");
		this.hashFields.put("stnd_cost_nm", "stndCostNm");
		this.hashFields.put("ctrl_ofc_cd", "ctrlOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vol", "vol");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("kpi_nm", "kpiNm");
		this.hashFields.put("n4th_nod_cd", "n4thNodCd");
		this.hashFields.put("unit_cost", "unitCost");
		this.hashFields.put("n1st_nod_cd", "n1stNodCd");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("n3rd_nod_cd", "n3rdNodCd");
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
	 * @return n2ndNodCd
	 */
	public String getN2ndNodCd() {
		return this.n2ndNodCd;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return inout
	 */
	public String getInout() {
		return this.inout;
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
	 * @return vol
	 */
	public String getVol() {
		return this.vol;
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
	 * @return n4thNodCd
	 */
	public String getN4thNodCd() {
		return this.n4thNodCd;
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
	 * @return n1stNodCd
	 */
	public String getN1stNodCd() {
		return this.n1stNodCd;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return n3rdNodCd
	 */
	public String getN3rdNodCd() {
		return this.n3rdNodCd;
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
	 * @param n2ndNodCd
	 */
	public void setN2ndNodCd(String n2ndNodCd) {
		this.n2ndNodCd = n2ndNodCd;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param inout
	 */
	public void setInout(String inout) {
		this.inout = inout;
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
	 * Column Info
	 * @param vol
	 */
	public void setVol(String vol) {
		this.vol = vol;
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
	 * @param n4thNodCd
	 */
	public void setN4thNodCd(String n4thNodCd) {
		this.n4thNodCd = n4thNodCd;
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
	 * @param n1stNodCd
	 */
	public void setN1stNodCd(String n1stNodCd) {
		this.n1stNodCd = n1stNodCd;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param n3rdNodCd
	 */
	public void setN3rdNodCd(String n3rdNodCd) {
		this.n3rdNodCd = n3rdNodCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTotalCost(JSPUtil.getParameter(request, "total_cost", ""));
		setRhqCd(JSPUtil.getParameter(request, "rhq_cd", ""));
		setN2ndNodCd(JSPUtil.getParameter(request, "n2nd_nod_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setInout(JSPUtil.getParameter(request, "inout", ""));
		setStndCostNm(JSPUtil.getParameter(request, "stnd_cost_nm", ""));
		setCtrlOfcCd(JSPUtil.getParameter(request, "ctrl_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVol(JSPUtil.getParameter(request, "vol", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, "cost_yrmon", ""));
		setKpiNm(JSPUtil.getParameter(request, "kpi_nm", ""));
		setN4thNodCd(JSPUtil.getParameter(request, "n4th_nod_cd", ""));
		setUnitCost(JSPUtil.getParameter(request, "unit_cost", ""));
		setN1stNodCd(JSPUtil.getParameter(request, "n1st_nod_cd", ""));
		setCostWk(JSPUtil.getParameter(request, "cost_wk", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setN3rdNodCd(JSPUtil.getParameter(request, "n3rd_nod_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchLogisticsRPT0082ListVO2[]
	 */
	public SearchLogisticsRPT0082ListVO2[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchLogisticsRPT0082ListVO2[]
	 */
	public SearchLogisticsRPT0082ListVO2[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchLogisticsRPT0082ListVO2 model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] s_totalCost = (JSPUtil.getParameter(request, prefix	+ "total_cost", length));
			String[] s_rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] s_n2ndNodCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_nod_cd", length));
			String[] s_trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] s_rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] s_inout = (JSPUtil.getParameter(request, prefix	+ "inout", length));
			String[] s_stndCostNm = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_nm", length));
			String[] s_ctrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd", length));
			String[] s_pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] s_vol = (JSPUtil.getParameter(request, prefix	+ "vol", length));
			String[] s_ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] s_costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] s_kpiNm = (JSPUtil.getParameter(request, prefix	+ "kpi_nm", length));
			String[] s_n4thNodCd = (JSPUtil.getParameter(request, prefix	+ "n4th_nod_cd", length));
			String[] s_unitCost = (JSPUtil.getParameter(request, prefix	+ "unit_cost", length));
			String[] s_n1stNodCd = (JSPUtil.getParameter(request, prefix	+ "n1st_nod_cd", length));
			String[] s_costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] s_cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] s_dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] s_n3rdNodCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_nod_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchLogisticsRPT0082ListVO2();
				if (s_totalCost[i] != null)
					model.setTotalCost(s_totalCost[i]);
				if (s_rhqCd[i] != null)
					model.setRhqCd(s_rhqCd[i]);
				if (s_n2ndNodCd[i] != null)
					model.setN2ndNodCd(s_n2ndNodCd[i]);
				if (s_trdCd[i] != null)
					model.setTrdCd(s_trdCd[i]);
				if (s_rlaneCd[i] != null)
					model.setRlaneCd(s_rlaneCd[i]);
				if (s_inout[i] != null)
					model.setInout(s_inout[i]);
				if (s_stndCostNm[i] != null)
					model.setStndCostNm(s_stndCostNm[i]);
				if (s_ctrlOfcCd[i] != null)
					model.setCtrlOfcCd(s_ctrlOfcCd[i]);
				if (s_pagerows[i] != null)
					model.setPagerows(s_pagerows[i]);
				if (s_vol[i] != null)
					model.setVol(s_vol[i]);
				if (s_ibflag[i] != null)
					model.setIbflag(s_ibflag[i]);
				if (s_costYrmon[i] != null)
					model.setCostYrmon(s_costYrmon[i]);
				if (s_kpiNm[i] != null)
					model.setKpiNm(s_kpiNm[i]);
				if (s_n4thNodCd[i] != null)
					model.setN4thNodCd(s_n4thNodCd[i]);
				if (s_unitCost[i] != null)
					model.setUnitCost(s_unitCost[i]);
				if (s_n1stNodCd[i] != null)
					model.setN1stNodCd(s_n1stNodCd[i]);
				if (s_costWk[i] != null)
					model.setCostWk(s_costWk[i]);
				if (s_cntrTpszCd[i] != null)
					model.setCntrTpszCd(s_cntrTpszCd[i]);
				if (s_dirCd[i] != null)
					model.setDirCd(s_dirCd[i]);
				if (s_n3rdNodCd[i] != null)
					model.setN3rdNodCd(s_n3rdNodCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchLogisticsRPT0082ListVO2s();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchLogisticsRPT0082ListVO2[]
	 */
	public SearchLogisticsRPT0082ListVO2[] getSearchLogisticsRPT0082ListVO2s(){
		SearchLogisticsRPT0082ListVO2[] vos = (SearchLogisticsRPT0082ListVO2[])models.toArray(new SearchLogisticsRPT0082ListVO2[models.size()]);
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
		this.totalCost = this.totalCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndNodCd = this.n2ndNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inout = this.inout .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostNm = this.stndCostNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd = this.ctrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vol = this.vol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kpiNm = this.kpiNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thNodCd = this.n4thNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unitCost = this.unitCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stNodCd = this.n1stNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdNodCd = this.n3rdNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
