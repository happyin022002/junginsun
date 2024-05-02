/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchMonthNodeCostListVO1.java
*@FileTitle : SearchMonthNodeCostListVO1
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.24
*@LastModifier : 장영석
*@LastVersion : 1.0
* 2010.06.24 장영석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.coa.stdunitcost.fullcost.vo;

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
 * @author 장영석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMonthNodeCostListVO1 extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMonthNodeCostListVO1> models = new ArrayList<SearchMonthNodeCostListVO1>();
	
	/* Column Info */
	private String coaCostSrcCdNm = null;
	/* Column Info */
	private String costAssBseCd = null;
	/* Column Info */
	private String coaCostSrcCd = null;
	/* Column Info */
	private String costNm = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String locType = null;
	/* Column Info */
	private String stndCostNm = null;
	/* Column Info */
	private String cost = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costActGrpCd = null;
	/* Column Info */
	private String grp = null;
	/* Column Info */
	private String lvl = null;
	/* Column Info */
	private String spcl = null;
	/* Column Info */
	private String stndCostCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchMonthNodeCostListVO1() {}

	/**
	 * 
	 * @param String ibflag
	 * @param String pagerows
	 * @param String costActGrpCd
	 * @param String stndCostCd
	 * @param String coaCostSrcCd
	 * @param String grp
	 * @param String stndCostNm
	 * @param String coaCostSrcCdNm
	 * @param String loclCurrCd
	 * @param String cost
	 * @param String spcl
	 * @param String lvl
	 * @param String costAssBseCd
	 * @param String locType
	 * @param String costNm
	 */
	public SearchMonthNodeCostListVO1(String ibflag, String pagerows, String costActGrpCd, String stndCostCd, String coaCostSrcCd, String grp, String stndCostNm, String coaCostSrcCdNm, String loclCurrCd, String cost, String spcl, String lvl, String costAssBseCd, String locType, String costNm) {
		this.coaCostSrcCdNm = coaCostSrcCdNm;
		this.costAssBseCd = costAssBseCd;
		this.coaCostSrcCd = coaCostSrcCd;
		this.costNm = costNm;
		this.loclCurrCd = loclCurrCd;
		this.locType = locType;
		this.stndCostNm = stndCostNm;
		this.cost = cost;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.costActGrpCd = costActGrpCd;
		this.grp = grp;
		this.lvl = lvl;
		this.spcl = spcl;
		this.stndCostCd = stndCostCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("coa_cost_src_cd_nm", getCoaCostSrcCdNm());
		this.hashColumns.put("cost_ass_bse_cd", getCostAssBseCd());
		this.hashColumns.put("coa_cost_src_cd", getCoaCostSrcCd());
		this.hashColumns.put("cost_nm", getCostNm());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("loc_type", getLocType());
		this.hashColumns.put("stnd_cost_nm", getStndCostNm());
		this.hashColumns.put("cost", getCost());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_act_grp_cd", getCostActGrpCd());
		this.hashColumns.put("grp", getGrp());
		this.hashColumns.put("lvl", getLvl());
		this.hashColumns.put("spcl", getSpcl());
		this.hashColumns.put("stnd_cost_cd", getStndCostCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("coa_cost_src_cd_nm", "coaCostSrcCdNm");
		this.hashFields.put("cost_ass_bse_cd", "costAssBseCd");
		this.hashFields.put("coa_cost_src_cd", "coaCostSrcCd");
		this.hashFields.put("cost_nm", "costNm");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("loc_type", "locType");
		this.hashFields.put("stnd_cost_nm", "stndCostNm");
		this.hashFields.put("cost", "cost");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_act_grp_cd", "costActGrpCd");
		this.hashFields.put("grp", "grp");
		this.hashFields.put("lvl", "lvl");
		this.hashFields.put("spcl", "spcl");
		this.hashFields.put("stnd_cost_cd", "stndCostCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return coaCostSrcCdNm
	 */
	public String getCoaCostSrcCdNm() {
		return this.coaCostSrcCdNm;
	}
	
	/**
	 * Column Info
	 * @return costAssBseCd
	 */
	public String getCostAssBseCd() {
		return this.costAssBseCd;
	}
	
	/**
	 * Column Info
	 * @return coaCostSrcCd
	 */
	public String getCoaCostSrcCd() {
		return this.coaCostSrcCd;
	}
	
	/**
	 * Column Info
	 * @return costNm
	 */
	public String getCostNm() {
		return this.costNm;
	}
	
	/**
	 * Column Info
	 * @return loclCurrCd
	 */
	public String getLoclCurrCd() {
		return this.loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return locType
	 */
	public String getLocType() {
		return this.locType;
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
	 * @return cost
	 */
	public String getCost() {
		return this.cost;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return costActGrpCd
	 */
	public String getCostActGrpCd() {
		return this.costActGrpCd;
	}
	
	/**
	 * Column Info
	 * @return grp
	 */
	public String getGrp() {
		return this.grp;
	}
	
	/**
	 * Column Info
	 * @return lvl
	 */
	public String getLvl() {
		return this.lvl;
	}
	
	/**
	 * Column Info
	 * @return spcl
	 */
	public String getSpcl() {
		return this.spcl;
	}
	
	/**
	 * Column Info
	 * @return stndCostCd
	 */
	public String getStndCostCd() {
		return this.stndCostCd;
	}
	

	/**
	 * Column Info
	 * @param coaCostSrcCdNm
	 */
	public void setCoaCostSrcCdNm(String coaCostSrcCdNm) {
		this.coaCostSrcCdNm = coaCostSrcCdNm;
	}
	
	/**
	 * Column Info
	 * @param costAssBseCd
	 */
	public void setCostAssBseCd(String costAssBseCd) {
		this.costAssBseCd = costAssBseCd;
	}
	
	/**
	 * Column Info
	 * @param coaCostSrcCd
	 */
	public void setCoaCostSrcCd(String coaCostSrcCd) {
		this.coaCostSrcCd = coaCostSrcCd;
	}
	
	/**
	 * Column Info
	 * @param costNm
	 */
	public void setCostNm(String costNm) {
		this.costNm = costNm;
	}
	
	/**
	 * Column Info
	 * @param loclCurrCd
	 */
	public void setLoclCurrCd(String loclCurrCd) {
		this.loclCurrCd = loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param locType
	 */
	public void setLocType(String locType) {
		this.locType = locType;
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
	 * @param cost
	 */
	public void setCost(String cost) {
		this.cost = cost;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param costActGrpCd
	 */
	public void setCostActGrpCd(String costActGrpCd) {
		this.costActGrpCd = costActGrpCd;
	}
	
	/**
	 * Column Info
	 * @param grp
	 */
	public void setGrp(String grp) {
		this.grp = grp;
	}
	
	/**
	 * Column Info
	 * @param lvl
	 */
	public void setLvl(String lvl) {
		this.lvl = lvl;
	}
	
	/**
	 * Column Info
	 * @param spcl
	 */
	public void setSpcl(String spcl) {
		this.spcl = spcl;
	}
	
	/**
	 * Column Info
	 * @param stndCostCd
	 */
	public void setStndCostCd(String stndCostCd) {
		this.stndCostCd = stndCostCd;
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
	 * @param prefix
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setCoaCostSrcCdNm(JSPUtil.getParameter(request, prefix + "coa_cost_src_cd_nm", ""));
		setCostAssBseCd(JSPUtil.getParameter(request, prefix + "cost_ass_bse_cd", ""));
		setCoaCostSrcCd(JSPUtil.getParameter(request, prefix + "coa_cost_src_cd", ""));
		setCostNm(JSPUtil.getParameter(request, prefix + "cost_nm", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, prefix + "locl_curr_cd", ""));
		setLocType(JSPUtil.getParameter(request, prefix + "loc_type", ""));
		setStndCostNm(JSPUtil.getParameter(request, prefix + "stnd_cost_nm", ""));
		setCost(JSPUtil.getParameter(request, prefix + "cost", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCostActGrpCd(JSPUtil.getParameter(request, prefix + "cost_act_grp_cd", ""));
		setGrp(JSPUtil.getParameter(request, prefix + "grp", ""));
		setLvl(JSPUtil.getParameter(request, prefix + "lvl", ""));
		setSpcl(JSPUtil.getParameter(request, prefix + "spcl", ""));
		setStndCostCd(JSPUtil.getParameter(request, prefix + "stnd_cost_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMonthNodeCostListVO1[]
	 */
	public SearchMonthNodeCostListVO1[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMonthNodeCostListVO1[]
	 */
	public SearchMonthNodeCostListVO1[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMonthNodeCostListVO1 model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] s_coaCostSrcCdNm = (JSPUtil.getParameter(request, prefix	+ "coa_cost_src_cd_nm", length));
			String[] s_costAssBseCd = (JSPUtil.getParameter(request, prefix	+ "cost_ass_bse_cd", length));
			String[] s_coaCostSrcCd = (JSPUtil.getParameter(request, prefix	+ "coa_cost_src_cd", length));
			String[] s_costNm = (JSPUtil.getParameter(request, prefix	+ "cost_nm", length));
			String[] s_loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] s_locType = (JSPUtil.getParameter(request, prefix	+ "loc_type", length));
			String[] s_stndCostNm = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_nm", length));
			String[] s_cost = (JSPUtil.getParameter(request, prefix	+ "cost", length));
			String[] s_pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] s_ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] s_costActGrpCd = (JSPUtil.getParameter(request, prefix	+ "cost_act_grp_cd", length));
			String[] s_grp = (JSPUtil.getParameter(request, prefix	+ "grp", length));
			String[] s_lvl = (JSPUtil.getParameter(request, prefix	+ "lvl", length));
			String[] s_spcl = (JSPUtil.getParameter(request, prefix	+ "spcl", length));
			String[] s_stndCostCd = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMonthNodeCostListVO1();
				if (s_coaCostSrcCdNm[i] != null)
					model.setCoaCostSrcCdNm(s_coaCostSrcCdNm[i]);
				if (s_costAssBseCd[i] != null)
					model.setCostAssBseCd(s_costAssBseCd[i]);
				if (s_coaCostSrcCd[i] != null)
					model.setCoaCostSrcCd(s_coaCostSrcCd[i]);
				if (s_costNm[i] != null)
					model.setCostNm(s_costNm[i]);
				if (s_loclCurrCd[i] != null)
					model.setLoclCurrCd(s_loclCurrCd[i]);
				if (s_locType[i] != null)
					model.setLocType(s_locType[i]);
				if (s_stndCostNm[i] != null)
					model.setStndCostNm(s_stndCostNm[i]);
				if (s_cost[i] != null)
					model.setCost(s_cost[i]);
				if (s_pagerows[i] != null)
					model.setPagerows(s_pagerows[i]);
				if (s_ibflag[i] != null)
					model.setIbflag(s_ibflag[i]);
				if (s_costActGrpCd[i] != null)
					model.setCostActGrpCd(s_costActGrpCd[i]);
				if (s_grp[i] != null)
					model.setGrp(s_grp[i]);
				if (s_lvl[i] != null)
					model.setLvl(s_lvl[i]);
				if (s_spcl[i] != null)
					model.setSpcl(s_spcl[i]);
				if (s_stndCostCd[i] != null)
					model.setStndCostCd(s_stndCostCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMonthNodeCostListVO1s();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMonthNodeCostListVO1[]
	 */
	public SearchMonthNodeCostListVO1[] getSearchMonthNodeCostListVO1s(){
		SearchMonthNodeCostListVO1[] vos = (SearchMonthNodeCostListVO1[])models.toArray(new SearchMonthNodeCostListVO1[models.size()]);
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
		this.coaCostSrcCdNm = this.coaCostSrcCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costAssBseCd = this.costAssBseCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaCostSrcCd = this.coaCostSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costNm = this.costNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locType = this.locType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostNm = this.stndCostNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cost = this.cost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costActGrpCd = this.costActGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grp = this.grp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl = this.lvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spcl = this.spcl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostCd = this.stndCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
