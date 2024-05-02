/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchMonthNodeCostListVO.java
*@FileTitle : SearchMonthNodeCostListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 박수훈
*@LastVersion : 1.0
* 2009.10.13 박수훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.stdunitcost.fullcost.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박수훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMonthNodeCostListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMonthNodeCostListVO> models = new ArrayList<SearchMonthNodeCostListVO>();
	
	/* Column Info */
	private String masCostSrcCdNm = null;
	/* Column Info */
	private String costAssBseCd = null;
	/* Column Info */
	private String masCostSrcCd = null;
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
	
	public SearchMonthNodeCostListVO() {}

	public SearchMonthNodeCostListVO(String ibflag, String pagerows, String costActGrpCd, String stndCostCd, String masCostSrcCd, String grp, String stndCostNm, String masCostSrcCdNm, String loclCurrCd, String cost, String spcl, String lvl, String costAssBseCd, String locType, String costNm) {
		this.masCostSrcCdNm = masCostSrcCdNm;
		this.costAssBseCd = costAssBseCd;
		this.masCostSrcCd = masCostSrcCd;
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
		this.hashColumns.put("mas_cost_src_cd_nm", getMasCostSrcCdNm());
		this.hashColumns.put("cost_ass_bse_cd", getCostAssBseCd());
		this.hashColumns.put("mas_cost_src_cd", getMasCostSrcCd());
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
		this.hashFields.put("mas_cost_src_cd_nm", "masCostSrcCdNm");
		this.hashFields.put("cost_ass_bse_cd", "costAssBseCd");
		this.hashFields.put("mas_cost_src_cd", "masCostSrcCd");
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
	 * @return masCostSrcCdNm
	 */
	public String getMasCostSrcCdNm() {
		return this.masCostSrcCdNm;
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
	 * @return masCostSrcCd
	 */
	public String getMasCostSrcCd() {
		return this.masCostSrcCd;
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
	 * @param masCostSrcCdNm
	 */
	public void setMasCostSrcCdNm(String masCostSrcCdNm) {
		this.masCostSrcCdNm = masCostSrcCdNm;
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
	 * @param masCostSrcCd
	 */
	public void setMasCostSrcCd(String masCostSrcCd) {
		this.masCostSrcCd = masCostSrcCd;
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
		setMasCostSrcCdNm(JSPUtil.getParameter(request, "mas_cost_src_cd_nm", ""));
		setCostAssBseCd(JSPUtil.getParameter(request, "cost_ass_bse_cd", ""));
		setMasCostSrcCd(JSPUtil.getParameter(request, "mas_cost_src_cd", ""));
		setCostNm(JSPUtil.getParameter(request, "cost_nm", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, "locl_curr_cd", ""));
		setLocType(JSPUtil.getParameter(request, "loc_type", ""));
		setStndCostNm(JSPUtil.getParameter(request, "stnd_cost_nm", ""));
		setCost(JSPUtil.getParameter(request, "cost", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCostActGrpCd(JSPUtil.getParameter(request, "cost_act_grp_cd", ""));
		setGrp(JSPUtil.getParameter(request, "grp", ""));
		setLvl(JSPUtil.getParameter(request, "lvl", ""));
		setSpcl(JSPUtil.getParameter(request, "spcl", ""));
		setStndCostCd(JSPUtil.getParameter(request, "stnd_cost_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMonthNodeCostListVO[]
	 */
	public SearchMonthNodeCostListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMonthNodeCostListVO[]
	 */
	public SearchMonthNodeCostListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMonthNodeCostListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] masCostSrcCdNm = (JSPUtil.getParameter(request, prefix	+ "mas_cost_src_cd_nm", length));
			String[] costAssBseCd = (JSPUtil.getParameter(request, prefix	+ "cost_ass_bse_cd", length));
			String[] masCostSrcCd = (JSPUtil.getParameter(request, prefix	+ "mas_cost_src_cd", length));
			String[] costNm = (JSPUtil.getParameter(request, prefix	+ "cost_nm", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] locType = (JSPUtil.getParameter(request, prefix	+ "loc_type", length));
			String[] stndCostNm = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_nm", length));
			String[] cost = (JSPUtil.getParameter(request, prefix	+ "cost", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costActGrpCd = (JSPUtil.getParameter(request, prefix	+ "cost_act_grp_cd", length));
			String[] grp = (JSPUtil.getParameter(request, prefix	+ "grp", length));
			String[] lvl = (JSPUtil.getParameter(request, prefix	+ "lvl", length));
			String[] spcl = (JSPUtil.getParameter(request, prefix	+ "spcl", length));
			String[] stndCostCd = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMonthNodeCostListVO();
				if (masCostSrcCdNm[i] != null)
					model.setMasCostSrcCdNm(masCostSrcCdNm[i]);
				if (costAssBseCd[i] != null)
					model.setCostAssBseCd(costAssBseCd[i]);
				if (masCostSrcCd[i] != null)
					model.setMasCostSrcCd(masCostSrcCd[i]);
				if (costNm[i] != null)
					model.setCostNm(costNm[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (locType[i] != null)
					model.setLocType(locType[i]);
				if (stndCostNm[i] != null)
					model.setStndCostNm(stndCostNm[i]);
				if (cost[i] != null)
					model.setCost(cost[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costActGrpCd[i] != null)
					model.setCostActGrpCd(costActGrpCd[i]);
				if (grp[i] != null)
					model.setGrp(grp[i]);
				if (lvl[i] != null)
					model.setLvl(lvl[i]);
				if (spcl[i] != null)
					model.setSpcl(spcl[i]);
				if (stndCostCd[i] != null)
					model.setStndCostCd(stndCostCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMonthNodeCostListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMonthNodeCostListVO[]
	 */
	public SearchMonthNodeCostListVO[] getSearchMonthNodeCostListVOs(){
		SearchMonthNodeCostListVO[] vos = (SearchMonthNodeCostListVO[])models.toArray(new SearchMonthNodeCostListVO[models.size()]);
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
		this.masCostSrcCdNm = this.masCostSrcCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costAssBseCd = this.costAssBseCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masCostSrcCd = this.masCostSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
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
