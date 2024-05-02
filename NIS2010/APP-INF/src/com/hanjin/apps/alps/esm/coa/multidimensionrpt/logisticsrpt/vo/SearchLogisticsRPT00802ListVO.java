/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchLogisticsRPT00802ListVO.java
*@FileTitle : SearchLogisticsRPT00802ListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.15
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.15  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.coa.multidimensionrpt.logisticsrpt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class SearchLogisticsRPT00802ListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchLogisticsRPT00802ListVO> models = new ArrayList<SearchLogisticsRPT00802ListVO>();
	
	/* Column Info */
	private String totalCost = null;
	/* Column Info */
	private String hulBndCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String pLoad = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pReport = null;
	/* Column Info */
	private String vol = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inOut = null;
	/* Column Info */
	private String kpiNm = null;
	/* Column Info */
	private String unitCost = null;
	/* Column Info */
	private String costActGrpTpCd = null;
	/* Column Info */
	private String pKpitype = null;
	/* Column Info */
	private String lgsKpiCostGrpNm = null;
	/* Column Info */
	private String dirCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchLogisticsRPT00802ListVO() {}

	public SearchLogisticsRPT00802ListVO(String ibflag, String pagerows, String pReport, String trdCd, String rlaneCd, String dirCd, String hulBndCd, String pLoad, String costActGrpTpCd, String lgsKpiCostGrpNm, String inOut, String pKpitype, String kpiNm, String vol, String totalCost, String unitCost) {
		this.totalCost = totalCost;
		this.hulBndCd = hulBndCd;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.pLoad = pLoad;
		this.pagerows = pagerows;
		this.pReport = pReport;
		this.vol = vol;
		this.ibflag = ibflag;
		this.inOut = inOut;
		this.kpiNm = kpiNm;
		this.unitCost = unitCost;
		this.costActGrpTpCd = costActGrpTpCd;
		this.pKpitype = pKpitype;
		this.lgsKpiCostGrpNm = lgsKpiCostGrpNm;
		this.dirCd = dirCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("total_cost", getTotalCost());
		this.hashColumns.put("hul_bnd_cd", getHulBndCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("p_load", getPLoad());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("p_report", getPReport());
		this.hashColumns.put("vol", getVol());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("in_out", getInOut());
		this.hashColumns.put("kpi_nm", getKpiNm());
		this.hashColumns.put("unit_cost", getUnitCost());
		this.hashColumns.put("cost_act_grp_tp_cd", getCostActGrpTpCd());
		this.hashColumns.put("p_kpitype", getPKpitype());
		this.hashColumns.put("lgs_kpi_cost_grp_nm", getLgsKpiCostGrpNm());
		this.hashColumns.put("dir_cd", getDirCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("total_cost", "totalCost");
		this.hashFields.put("hul_bnd_cd", "hulBndCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("p_load", "pLoad");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("p_report", "pReport");
		this.hashFields.put("vol", "vol");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("in_out", "inOut");
		this.hashFields.put("kpi_nm", "kpiNm");
		this.hashFields.put("unit_cost", "unitCost");
		this.hashFields.put("cost_act_grp_tp_cd", "costActGrpTpCd");
		this.hashFields.put("p_kpitype", "pKpitype");
		this.hashFields.put("lgs_kpi_cost_grp_nm", "lgsKpiCostGrpNm");
		this.hashFields.put("dir_cd", "dirCd");
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
	 * @return hulBndCd
	 */
	public String getHulBndCd() {
		return this.hulBndCd;
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
	 * @return pLoad
	 */
	public String getPLoad() {
		return this.pLoad;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return inOut
	 */
	public String getInOut() {
		return this.inOut;
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
	 * @return costActGrpTpCd
	 */
	public String getCostActGrpTpCd() {
		return this.costActGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @return pKpitype
	 */
	public String getPKpitype() {
		return this.pKpitype;
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
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
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
	 * @param hulBndCd
	 */
	public void setHulBndCd(String hulBndCd) {
		this.hulBndCd = hulBndCd;
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
	 * @param pLoad
	 */
	public void setPLoad(String pLoad) {
		this.pLoad = pLoad;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param inOut
	 */
	public void setInOut(String inOut) {
		this.inOut = inOut;
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
	 * @param costActGrpTpCd
	 */
	public void setCostActGrpTpCd(String costActGrpTpCd) {
		this.costActGrpTpCd = costActGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @param pKpitype
	 */
	public void setPKpitype(String pKpitype) {
		this.pKpitype = pKpitype;
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
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
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
		setTotalCost(JSPUtil.getParameter(request, prefix + "total_cost", ""));
		setHulBndCd(JSPUtil.getParameter(request, prefix + "hul_bnd_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setPLoad(JSPUtil.getParameter(request, prefix + "p_load", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPReport(JSPUtil.getParameter(request, prefix + "p_report", ""));
		setVol(JSPUtil.getParameter(request, prefix + "vol", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInOut(JSPUtil.getParameter(request, prefix + "in_out", ""));
		setKpiNm(JSPUtil.getParameter(request, prefix + "kpi_nm", ""));
		setUnitCost(JSPUtil.getParameter(request, prefix + "unit_cost", ""));
		setCostActGrpTpCd(JSPUtil.getParameter(request, prefix + "cost_act_grp_tp_cd", ""));
		setPKpitype(JSPUtil.getParameter(request, prefix + "p_kpitype", ""));
		setLgsKpiCostGrpNm(JSPUtil.getParameter(request, prefix + "lgs_kpi_cost_grp_nm", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchLogisticsRPT00802ListVO[]
	 */
	public SearchLogisticsRPT00802ListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchLogisticsRPT00802ListVO[]
	 */
	public SearchLogisticsRPT00802ListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchLogisticsRPT00802ListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] totalCost = (JSPUtil.getParameter(request, prefix	+ "total_cost", length));
			String[] hulBndCd = (JSPUtil.getParameter(request, prefix	+ "hul_bnd_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] pLoad = (JSPUtil.getParameter(request, prefix	+ "p_load", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pReport = (JSPUtil.getParameter(request, prefix	+ "p_report", length));
			String[] vol = (JSPUtil.getParameter(request, prefix	+ "vol", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] inOut = (JSPUtil.getParameter(request, prefix	+ "in_out", length));
			String[] kpiNm = (JSPUtil.getParameter(request, prefix	+ "kpi_nm", length));
			String[] unitCost = (JSPUtil.getParameter(request, prefix	+ "unit_cost", length));
			String[] costActGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "cost_act_grp_tp_cd", length));
			String[] pKpitype = (JSPUtil.getParameter(request, prefix	+ "p_kpitype", length));
			String[] lgsKpiCostGrpNm = (JSPUtil.getParameter(request, prefix	+ "lgs_kpi_cost_grp_nm", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchLogisticsRPT00802ListVO();
				if (totalCost[i] != null)
					model.setTotalCost(totalCost[i]);
				if (hulBndCd[i] != null)
					model.setHulBndCd(hulBndCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (pLoad[i] != null)
					model.setPLoad(pLoad[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pReport[i] != null)
					model.setPReport(pReport[i]);
				if (vol[i] != null)
					model.setVol(vol[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inOut[i] != null)
					model.setInOut(inOut[i]);
				if (kpiNm[i] != null)
					model.setKpiNm(kpiNm[i]);
				if (unitCost[i] != null)
					model.setUnitCost(unitCost[i]);
				if (costActGrpTpCd[i] != null)
					model.setCostActGrpTpCd(costActGrpTpCd[i]);
				if (pKpitype[i] != null)
					model.setPKpitype(pKpitype[i]);
				if (lgsKpiCostGrpNm[i] != null)
					model.setLgsKpiCostGrpNm(lgsKpiCostGrpNm[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchLogisticsRPT00802ListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchLogisticsRPT00802ListVO[]
	 */
	public SearchLogisticsRPT00802ListVO[] getSearchLogisticsRPT00802ListVOs(){
		SearchLogisticsRPT00802ListVO[] vos = (SearchLogisticsRPT00802ListVO[])models.toArray(new SearchLogisticsRPT00802ListVO[models.size()]);
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
		this.hulBndCd = this.hulBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pLoad = this.pLoad .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pReport = this.pReport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vol = this.vol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inOut = this.inOut .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kpiNm = this.kpiNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unitCost = this.unitCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costActGrpTpCd = this.costActGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pKpitype = this.pKpitype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsKpiCostGrpNm = this.lgsKpiCostGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
