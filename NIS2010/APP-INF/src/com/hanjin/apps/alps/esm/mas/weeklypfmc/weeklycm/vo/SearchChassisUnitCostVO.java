/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchChassisUnitCostVO.java
*@FileTitle : Chassis Unit Cost
*Open Issues :
*Change history :
*@LastModifyDate : 2014-11-20
*@LastModifier : Je Ryang Yoo
*@LastVersion : 
*  2014-11-18 Je Ryang Yoo
*  1.0 최초 생성
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo;

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

public class SearchChassisUnitCostVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchChassisUnitCostVO> models = new ArrayList<SearchChassisUnitCostVO>();
		
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;	
	/* Column Info */
	private String cntCd = null;
	
	/* Column Info */
	private String costYr = null;
	/* Column Info */
	private String costQtrcd = null;
	/* Column Info */
	private String costTpcd = null;
	/* Column Info */
	private String effFmyrmon = null;
	/* Column Info */
	private String effToyrmon = null;
	/* Column Info */
	private String bkgBxqty = null;
	/* Column Info */
	private String costTpbxrate = null;
	/* Column Info */
	private String estmAmt = null;
	/* Column Info */
	private String onStutcost = null;
	/* Column Info */
	private String comSubttl = null;
	/* Column Info */
	private String comUtcost = null;
	/* Column Info */
	private String stndUtcost = null;
	/* Column Info */
	private String costYrqtr = null;
	/* Column Info */
	private String updUsrid = null;
	/* Column Info */
	private String frYear = null;
	/* Column Info */
	private String toYear = null;
	/* Column Info */
	private String frQtr = null;
	/* Column Info */
	private String toQtr = null;
		
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchChassisUnitCostVO() {}

	public SearchChassisUnitCostVO(String ibflag, String pagerows, String cntCd,
		String costYr, String costQtrcd, String costTpcd, String effFmyrmon, String effToyrmon,
		String bkgBxqty, String costTpbxrate, String estmAmt, String onStutcost, String comSubttl,
		String comUtcost, String stndUtcost, String costYrqtr, String updUsrid
		, String frYear, String toYear, String frQtr, String toQtr) {		
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.cntCd = cntCd;			
		this.costYr = costYr;
		this.costQtrcd = costQtrcd;
		this.costTpcd = costTpcd;
		this.effFmyrmon = effFmyrmon;
		this.effToyrmon = effToyrmon;
		this.bkgBxqty = bkgBxqty;
		this.costTpbxrate = costTpbxrate;
		this.estmAmt = estmAmt;
		this.onStutcost = onStutcost;
		this.comSubttl = comSubttl;
		this.comUtcost = comUtcost;
		this.stndUtcost = stndUtcost;		
		this.costYrqtr = costYrqtr;		
		this.updUsrid = updUsrid;
		this.frYear = frYear;
		this.toYear = toYear;
		this.frQtr = frQtr;
		this.toQtr = toQtr;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){	
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cnt_cd", getCntCd());		
		this.hashColumns.put("cost_yr", getCostYr());
		this.hashColumns.put("cost_qtr_cd", getCostQtrcd());
		this.hashColumns.put("cost_tp_cd", getCostTpcd());
		this.hashColumns.put("eff_fm_yrmon", getEffFmyrmon());
		this.hashColumns.put("eff_to_yrmon", getEffToyrmon());
		this.hashColumns.put("bkg_bx_qty", getBkgBxqty());
		this.hashColumns.put("cost_tp_bx_rate", getCostTpbxrate());
		this.hashColumns.put("estm_amt", getEstmAmt());
		this.hashColumns.put("on_st_ut_cost", getOnStutcost());
		this.hashColumns.put("com_sub_ttl", getComSubttl());
		this.hashColumns.put("com_ut_cost", getComUtcost());
		this.hashColumns.put("stnd_ut_cost", getStndUtcost());		
		this.hashColumns.put("cost_yr_qtr", getCostYrqtr());
		this.hashColumns.put("upd_usr_id", getUpdUsrid());
		this.hashColumns.put("fr_year", getFrYear());
		this.hashColumns.put("to_year", getToYear());
		this.hashColumns.put("fr_qtr", getFrQtr());
		this.hashColumns.put("to_qtr", getToQtr());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){		
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cnt_cd", "cntCd");		
		this.hashFields.put("cost_yr", "costYr");
		this.hashFields.put("cost_qtr_cd", "costQtrcd");
		this.hashFields.put("cost_tp_cd", "costTpcd");
		this.hashFields.put("eff_fm_yrmon", "effFmyrmon");
		this.hashFields.put("eff_to_yrmon", "effToyrmon");
		this.hashFields.put("bkg_bx_qty", "bkgBxqty");
		this.hashFields.put("cost_tp_bx_rate", "costTpbxrate");
		this.hashFields.put("estm_amt", "estmAmt");
		this.hashFields.put("on_st_ut_cost", "onStutcost");
		this.hashFields.put("com_sub_ttl", "comSubttl");
		this.hashFields.put("com_ut_cost", "comUtcost");
		this.hashFields.put("stnd_ut_cost", "stndUtcost");		
		this.hashFields.put("cost_yr_qtr", "costYrqtr");
		this.hashFields.put("upd_usr_id", "updUsrid");
		this.hashFields.put("fr_year", "frYear");
		this.hashFields.put("to_year", "toYear");
		this.hashFields.put("fr_qtr", "frQtr");
		this.hashFields.put("to_qtr", "toQtr");
		
		return this.hashFields;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
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
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}	
	
	/**
	 * Column Info
	 * @return costYr
	 */
	public String getCostYr() {
		return costYr;
	}
	
	/**
	 * Column Info
	 * @return costQtrcd
	 */
	public String getCostQtrcd() {
		return costQtrcd;
	}
	
	/**
	 * Column Info
	 * @return costTpcd
	 */
	public String getCostTpcd() {
		return costTpcd;
	}
	
	/**
	 * Column Info
	 * @return effFmyrmon
	 */
	public String getEffFmyrmon() {
		return effFmyrmon;
	}
	
	/**
	 * Column Info
	 * @return effToyrmon
	 */
	public String getEffToyrmon() {
		return effToyrmon;
	}
	
	/**
	 * Column Info
	 * @return bkgBxqty
	 */
	public String getBkgBxqty() {
		return bkgBxqty;
	}
	
	/**
	 * Column Info
	 * @return costTpbxrate
	 */
	public String getCostTpbxrate() {
		return costTpbxrate;
	}
	
	/**
	 * Column Info
	 * @return estmAmt
	 */
	public String getEstmAmt() {
		return estmAmt;
	}
	
	/**
	 * Column Info
	 * @return onStutcost
	 */
	public String getOnStutcost() {
		return onStutcost;
	}
	
	/**
	 * Column Info
	 * @return comSubttl
	 */
	public String getComSubttl() {
		return comSubttl;
	}
	
	/**
	 * Column Info
	 * @return comUtcost
	 */
	public String getComUtcost() {
		return comUtcost;
	}
	
	/**
	 * Column Info
	 * @return stndUtcost
	 */
	public String getStndUtcost() {
		return stndUtcost;
	}	
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param costYr
	 */
	public void setCostYr(String costYr) {
		this.costYr = costYr;
	}
	
	/**
	 * Column Info
	 * @param costQtrcd
	 */
	public void setCostQtrcd(String costQtrcd) {
		this.costQtrcd = costQtrcd;
	}
	
	/**
	 * Column Info
	 * @param costTpcd
	 */
	public void setCostTpcd(String costTpcd) {
		this.costTpcd = costTpcd;
	}
	
	/**
	 * Column Info
	 * @param effFmyrmon
	 */
	public void setEffFmyrmon(String effFmyrmon) {
		this.effFmyrmon = effFmyrmon;
	}
	
	/**
	 * Column Info
	 * @param effToyrmon
	 */
	public void setEffToyrmon(String effToyrmon) {
		this.effToyrmon = effToyrmon;
	}
	
	/**
	 * Column Info
	 * @param bkgBxqty
	 */
	public void setBkgBxqty(String bkgBxqty) {
		this.bkgBxqty = bkgBxqty;
	}
	
	/**
	 * Column Info
	 * @param costTpbxrate
	 */
	public void setCostTpbxrate(String costTpbxrate) {
		this.costTpbxrate = costTpbxrate;
	}
	
	/**
	 * Column Info
	 * @param estmAmt
	 */
	public void setEstmAmt(String estmAmt) {
		this.estmAmt = estmAmt;
	}
	
	/**
	 * Column Info
	 * @param onStutcost
	 */
	public void setOnStutcost(String onStutcost) {
		this.onStutcost = onStutcost;
	}
	
	/**
	 * Column Info
	 * @param comSubttl
	 */
	public void setComSubttl(String comSubttl) {
		this.comSubttl = comSubttl;
	}
	
	/**
	 * Column Info
	 * @param comUtcost
	 */
	public void setComUtcost(String comUtcost) {
		this.comUtcost = comUtcost;
	}
	
	/**
	 * Column Info
	 * @param stndUtcost
	 */
	public void setStndUtcost(String stndUtcost) {
		this.stndUtcost = stndUtcost;
	}	
			
	public String getCostYrqtr() {
		return costYrqtr;
	}

	public void setCostYrqtr(String costYrqtr) {
		this.costYrqtr = costYrqtr;
	}

	public String getUpdUsrid() {
		return updUsrid;
	}

	public void setUpdUsrid(String updUsrid) {
		this.updUsrid = updUsrid;
	}

	public String getFrYear() {
		return frYear;
	}

	public void setFrYear(String frYear) {
		this.frYear = frYear;
	}

	public String getToYear() {
		return toYear;
	}

	public void setToYear(String toYear) {
		this.toYear = toYear;
	}

	public String getFrQtr() {
		return frQtr;
	}

	public void setFrQtr(String frQtr) {
		this.frQtr = frQtr;
	}

	public String getToQtr() {
		return toQtr;
	}

	public void setToQtr(String toQtr) {
		this.toQtr = toQtr;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));		
		setCostYr(JSPUtil.getParameter(request, prefix + "cost_yr", ""));
		setCostQtrcd(JSPUtil.getParameter(request, prefix + "cost_qtr_cd", ""));
		setCostTpcd(JSPUtil.getParameter(request, prefix + "cost_tp_cd", ""));
		setEffFmyrmon(JSPUtil.getParameter(request, prefix + "eff_fm_yrmon", ""));
		setEffToyrmon(JSPUtil.getParameter(request, prefix + "eff_to_yrmon", ""));
		setBkgBxqty(JSPUtil.getParameter(request, prefix + "bkg_bx_qty", ""));
		setCostTpbxrate(JSPUtil.getParameter(request, prefix + "cost_tp_bx_rate", ""));
		setEstmAmt(JSPUtil.getParameter(request, prefix + "estm_amt", ""));
		setOnStutcost(JSPUtil.getParameter(request, prefix + "on_st_ut_cost", ""));
		setComSubttl(JSPUtil.getParameter(request, prefix + "com_sub_ttl", ""));
		setComUtcost(JSPUtil.getParameter(request, prefix + "com_ut_cost", ""));
		setStndUtcost(JSPUtil.getParameter(request, prefix + "stnd_ut_cost", ""));		
		setCostYrqtr(JSPUtil.getParameter(request, prefix + "cost_yr_qtr", ""));
		setUpdUsrid(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setFrYear(JSPUtil.getParameter(request, prefix + "fr_year", ""));
		setToYear(JSPUtil.getParameter(request, prefix + "to_year", ""));
		setFrQtr(JSPUtil.getParameter(request, prefix + "fr_qtr", ""));
		setToQtr(JSPUtil.getParameter(request, prefix + "to_qtr", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchChassisUnitCostVO[]
	 */
	public SearchChassisUnitCostVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchChassisUnitCostVO[]
	 */
	public SearchChassisUnitCostVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchChassisUnitCostVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {			
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));			
			String[] costYr = (JSPUtil.getParameter(request, prefix	+ "cost_yr", length));
			String[] costQtrcd = (JSPUtil.getParameter(request, prefix	+ "cost_qtr_cd", length));
			String[] costTpcd = (JSPUtil.getParameter(request, prefix	+ "cost_tp_cd", length));
			String[] effFmyrmon = (JSPUtil.getParameter(request, prefix	+ "eff_fm_yrmon", length));
			String[] effToyrmon = (JSPUtil.getParameter(request, prefix	+ "eff_to_yrmon", length));
			String[] bkgBxqty = (JSPUtil.getParameter(request, prefix	+ "bkg_bx_qty", length));
			String[] costTpbxrate = (JSPUtil.getParameter(request, prefix	+ "cost_tp_bx_rate", length));
			String[] estmAmt = (JSPUtil.getParameter(request, prefix	+ "estm_amt", length));
			String[] onStutcost = (JSPUtil.getParameter(request, prefix	+ "on_st_ut_cost", length));
			String[] comSubttl = (JSPUtil.getParameter(request, prefix	+ "com_sub_ttl", length));
			String[] comUtcost = (JSPUtil.getParameter(request, prefix	+ "com_ut_cost", length));
			String[] stndUtcost = (JSPUtil.getParameter(request, prefix	+ "stnd_ut_cost", length));			
			String[] costYrqtr = (JSPUtil.getParameter(request, prefix	+ "cost_yr_qtr", length));
			String[] updUsrid  = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id ", length));
			String[] frYear    = (JSPUtil.getParameter(request, prefix	+ "fr_year    ", length));
			String[] toYear    = (JSPUtil.getParameter(request, prefix	+ "to_year    ", length));
			String[] frQtr     = (JSPUtil.getParameter(request, prefix	+ "fr_qtr     ", length));
			String[] toQtr     = (JSPUtil.getParameter(request, prefix	+ "to_qtr     ", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchChassisUnitCostVO();
				
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);				
				if (costYr[i] != null)
					model.setCostYr(costYr[i]);
				if (costQtrcd[i] != null)
					model.setCostQtrcd(costQtrcd[i]);
				if (costTpcd[i] != null)
					model.setCostTpcd(costTpcd[i]);
				if (effFmyrmon[i] != null)
					model.setEffFmyrmon(effFmyrmon[i]);
				if (effToyrmon[i] != null)
					model.setEffToyrmon(effToyrmon[i]);
				if (bkgBxqty[i] != null)
					model.setBkgBxqty(bkgBxqty[i]);
				if (costTpbxrate[i] != null)
					model.setCostTpbxrate(costTpbxrate[i]);
				if (estmAmt[i] != null)
					model.setEstmAmt(estmAmt[i]);
				if (onStutcost[i] != null)
					model.setOnStutcost(onStutcost[i]);
				if (comSubttl[i] != null)
					model.setComSubttl(comSubttl[i]);
				if (comUtcost[i] != null)
					model.setComUtcost(comUtcost[i]);
				if (stndUtcost[i] != null)
					model.setStndUtcost(stndUtcost[i]);				
				if (costYrqtr[i] != null)
					model.setCostYrqtr(costYrqtr[i]);
				if (updUsrid[i] != null)
					model.setUpdUsrid(updUsrid[i]);
				if (frYear[i] != null)
					model.setFrYear(frYear[i]);
				if (toYear[i] != null)
					model.setToYear(toYear[i]);
				if (frQtr[i] != null)
					model.setFrQtr(frQtr[i]);
				if (toQtr[i] != null)
					model.setToQtr(toQtr[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchChassisUnitCostVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchChassisUnitCostVO[]
	 */
	public SearchChassisUnitCostVO[] getSearchChassisUnitCostVOs(){
		SearchChassisUnitCostVO[] vos = (SearchChassisUnitCostVO[])models.toArray(new SearchChassisUnitCostVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.costYr = this.costYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costQtrcd = this.costQtrcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTpcd = this.costTpcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effFmyrmon = this.effFmyrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effToyrmon = this.effToyrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgBxqty = this.bkgBxqty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTpbxrate = this.costTpbxrate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmAmt = this.estmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onStutcost = this.onStutcost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comSubttl = this.comSubttl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comUtcost = this.comUtcost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndUtcost = this.stndUtcost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.costYrqtr = this.costYrqtr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrid  = this.updUsrid.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frYear    = this.frYear.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toYear    = this.toYear.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frQtr     = this.frQtr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toQtr      = this.toQtr      .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
