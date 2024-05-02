/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchAvgHireOwnVslDtrbListVO.java
*@FileTitle : SearchAvgHireOwnVslDtrbListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.05
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2014.12.05 김종옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo;

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
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchAvgHireOwnVslDtrbListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchAvgHireOwnVslDtrbListVO> models = new ArrayList<SearchAvgHireOwnVslDtrbListVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vslDtrbAmt = null;
	/* Column Info */
	private String ttlAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vslDtrbRt = null;
	/* Column Info */
	private String dhirAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYr = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String vslAmt = null;
	/* Column Info */
	private String yyyyWw = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String stndCostCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchAvgHireOwnVslDtrbListVO() {}

	public SearchAvgHireOwnVslDtrbListVO(String ibflag, String pagerows, String costYr, String costWk, String yyyyWw, String vslCd, String stndCostCd, String vslAmt, String vslDtrbRt, String vslDtrbAmt, String dhirAmt, String ttlAmt, String updUsrId) {
		this.vslCd = vslCd;
		this.vslDtrbAmt = vslDtrbAmt;
		this.ttlAmt = ttlAmt;
		this.pagerows = pagerows;
		this.vslDtrbRt = vslDtrbRt;
		this.dhirAmt = dhirAmt;
		this.ibflag = ibflag;
		this.costYr = costYr;
		this.costWk = costWk;
		this.vslAmt = vslAmt;
		this.yyyyWw = yyyyWw;
		this.updUsrId = updUsrId;
		this.stndCostCd = stndCostCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vsl_dtrb_amt", getVslDtrbAmt());
		this.hashColumns.put("ttl_amt", getTtlAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vsl_dtrb_rt", getVslDtrbRt());
		this.hashColumns.put("dhir_amt", getDhirAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yr", getCostYr());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("vsl_amt", getVslAmt());
		this.hashColumns.put("yyyy_ww", getYyyyWw());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("stnd_cost_cd", getStndCostCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vsl_dtrb_amt", "vslDtrbAmt");
		this.hashFields.put("ttl_amt", "ttlAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vsl_dtrb_rt", "vslDtrbRt");
		this.hashFields.put("dhir_amt", "dhirAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yr", "costYr");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("vsl_amt", "vslAmt");
		this.hashFields.put("yyyy_ww", "yyyyWw");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("stnd_cost_cd", "stndCostCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return vslDtrbAmt
	 */
	public String getVslDtrbAmt() {
		return this.vslDtrbAmt;
	}
	
	/**
	 * Column Info
	 * @return ttlAmt
	 */
	public String getTtlAmt() {
		return this.ttlAmt;
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
	 * @return vslDtrbRt
	 */
	public String getVslDtrbRt() {
		return this.vslDtrbRt;
	}
	
	/**
	 * Column Info
	 * @return dhirAmt
	 */
	public String getDhirAmt() {
		return this.dhirAmt;
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
	 * @return costYr
	 */
	public String getCostYr() {
		return this.costYr;
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
	 * @return vslAmt
	 */
	public String getVslAmt() {
		return this.vslAmt;
	}
	
	/**
	 * Column Info
	 * @return yyyyWw
	 */
	public String getYyyyWw() {
		return this.yyyyWw;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param vslDtrbAmt
	 */
	public void setVslDtrbAmt(String vslDtrbAmt) {
		this.vslDtrbAmt = vslDtrbAmt;
	}
	
	/**
	 * Column Info
	 * @param ttlAmt
	 */
	public void setTtlAmt(String ttlAmt) {
		this.ttlAmt = ttlAmt;
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
	 * @param vslDtrbRt
	 */
	public void setVslDtrbRt(String vslDtrbRt) {
		this.vslDtrbRt = vslDtrbRt;
	}
	
	/**
	 * Column Info
	 * @param dhirAmt
	 */
	public void setDhirAmt(String dhirAmt) {
		this.dhirAmt = dhirAmt;
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
	 * @param costYr
	 */
	public void setCostYr(String costYr) {
		this.costYr = costYr;
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
	 * @param vslAmt
	 */
	public void setVslAmt(String vslAmt) {
		this.vslAmt = vslAmt;
	}
	
	/**
	 * Column Info
	 * @param yyyyWw
	 */
	public void setYyyyWw(String yyyyWw) {
		this.yyyyWw = yyyyWw;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setVslDtrbAmt(JSPUtil.getParameter(request, prefix + "vsl_dtrb_amt", ""));
		setTtlAmt(JSPUtil.getParameter(request, prefix + "ttl_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVslDtrbRt(JSPUtil.getParameter(request, prefix + "vsl_dtrb_rt", ""));
		setDhirAmt(JSPUtil.getParameter(request, prefix + "dhir_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCostYr(JSPUtil.getParameter(request, prefix + "cost_yr", ""));
		setCostWk(JSPUtil.getParameter(request, prefix + "cost_wk", ""));
		setVslAmt(JSPUtil.getParameter(request, prefix + "vsl_amt", ""));
		setYyyyWw(JSPUtil.getParameter(request, prefix + "yyyy_ww", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setStndCostCd(JSPUtil.getParameter(request, prefix + "stnd_cost_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchAvgHireOwnVslDtrbListVO[]
	 */
	public SearchAvgHireOwnVslDtrbListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchAvgHireOwnVslDtrbListVO[]
	 */
	public SearchAvgHireOwnVslDtrbListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchAvgHireOwnVslDtrbListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vslDtrbAmt = (JSPUtil.getParameter(request, prefix	+ "vsl_dtrb_amt", length));
			String[] ttlAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vslDtrbRt = (JSPUtil.getParameter(request, prefix	+ "vsl_dtrb_rt", length));
			String[] dhirAmt = (JSPUtil.getParameter(request, prefix	+ "dhir_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYr = (JSPUtil.getParameter(request, prefix	+ "cost_yr", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] vslAmt = (JSPUtil.getParameter(request, prefix	+ "vsl_amt", length));
			String[] yyyyWw = (JSPUtil.getParameter(request, prefix	+ "yyyy_ww", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] stndCostCd = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchAvgHireOwnVslDtrbListVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vslDtrbAmt[i] != null)
					model.setVslDtrbAmt(vslDtrbAmt[i]);
				if (ttlAmt[i] != null)
					model.setTtlAmt(ttlAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vslDtrbRt[i] != null)
					model.setVslDtrbRt(vslDtrbRt[i]);
				if (dhirAmt[i] != null)
					model.setDhirAmt(dhirAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYr[i] != null)
					model.setCostYr(costYr[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (vslAmt[i] != null)
					model.setVslAmt(vslAmt[i]);
				if (yyyyWw[i] != null)
					model.setYyyyWw(yyyyWw[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (stndCostCd[i] != null)
					model.setStndCostCd(stndCostCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchAvgHireOwnVslDtrbListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchAvgHireOwnVslDtrbListVO[]
	 */
	public SearchAvgHireOwnVslDtrbListVO[] getSearchAvgHireOwnVslDtrbListVOs(){
		SearchAvgHireOwnVslDtrbListVO[] vos = (SearchAvgHireOwnVslDtrbListVO[])models.toArray(new SearchAvgHireOwnVslDtrbListVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDtrbAmt = this.vslDtrbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAmt = this.ttlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDtrbRt = this.vslDtrbRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dhirAmt = this.dhirAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYr = this.costYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslAmt = this.vslAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yyyyWw = this.yyyyWw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostCd = this.stndCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
