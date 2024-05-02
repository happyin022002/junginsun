/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SearchAgnOtrCommCostListVO.java
*@FileTitle : SearchAgnOtrCommCostListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.05.16
*@LastModifier : 
*@LastVersion : 1.0
* 2017.05.16  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.stdunitcost.agencycommission.vo;

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

public class SearchAgnOtrCommCostListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchAgnOtrCommCostListVO> models = new ArrayList<SearchAgnOtrCommCostListVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String commLocNm = null;
	/* Column Info */
	private String masCostSrcCdNm = null;
	/* Column Info */
	private String masCostSrcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String commLocCd = null;
	/* Column Info */
	private String bkgTtlQty = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String divStnd = null;
	/* Column Info */
	private String otrCommTtlAmt = null;
	/* Column Info */
	private String stndCostUsdAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchAgnOtrCommCostListVO() {}

	public SearchAgnOtrCommCostListVO(String ibflag, String pagerows, String costYrmon, String commLocCd, String commLocNm, String divStnd, String masCostSrcCdNm, String masCostSrcCd, String cntrTpszCd, String otrCommTtlAmt, String bkgTtlQty, String stndCostUsdAmt) {
		this.pagerows = pagerows;
		this.commLocNm = commLocNm;
		this.masCostSrcCdNm = masCostSrcCdNm;
		this.masCostSrcCd = masCostSrcCd;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.commLocCd = commLocCd;
		this.bkgTtlQty = bkgTtlQty;
		this.cntrTpszCd = cntrTpszCd;
		this.divStnd = divStnd;
		this.otrCommTtlAmt = otrCommTtlAmt;
		this.stndCostUsdAmt = stndCostUsdAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("comm_loc_nm", getCommLocNm());
		this.hashColumns.put("mas_cost_src_cd_nm", getMasCostSrcCdNm());
		this.hashColumns.put("mas_cost_src_cd", getMasCostSrcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("comm_loc_cd", getCommLocCd());
		this.hashColumns.put("bkg_ttl_qty", getBkgTtlQty());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("div_stnd", getDivStnd());
		this.hashColumns.put("otr_comm_ttl_amt", getOtrCommTtlAmt());
		this.hashColumns.put("stnd_cost_usd_amt", getStndCostUsdAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("comm_loc_nm", "commLocNm");
		this.hashFields.put("mas_cost_src_cd_nm", "masCostSrcCdNm");
		this.hashFields.put("mas_cost_src_cd", "masCostSrcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("comm_loc_cd", "commLocCd");
		this.hashFields.put("bkg_ttl_qty", "bkgTtlQty");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("div_stnd", "divStnd");
		this.hashFields.put("otr_comm_ttl_amt", "otrCommTtlAmt");
		this.hashFields.put("stnd_cost_usd_amt", "stndCostUsdAmt");
		return this.hashFields;
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
	 * @return commLocNm
	 */
	public String getCommLocNm() {
		return this.commLocNm;
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
	 * @return masCostSrcCd
	 */
	public String getMasCostSrcCd() {
		return this.masCostSrcCd;
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
	 * @return commLocCd
	 */
	public String getCommLocCd() {
		return this.commLocCd;
	}
	
	/**
	 * Column Info
	 * @return bkgTtlQty
	 */
	public String getBkgTtlQty() {
		return this.bkgTtlQty;
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
	 * @return divStnd
	 */
	public String getDivStnd() {
		return this.divStnd;
	}
	
	/**
	 * Column Info
	 * @return otrCommTtlAmt
	 */
	public String getOtrCommTtlAmt() {
		return this.otrCommTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return stndCostUsdAmt
	 */
	public String getStndCostUsdAmt() {
		return this.stndCostUsdAmt;
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
	 * @param commLocNm
	 */
	public void setCommLocNm(String commLocNm) {
		this.commLocNm = commLocNm;
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
	 * @param masCostSrcCd
	 */
	public void setMasCostSrcCd(String masCostSrcCd) {
		this.masCostSrcCd = masCostSrcCd;
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
	 * @param commLocCd
	 */
	public void setCommLocCd(String commLocCd) {
		this.commLocCd = commLocCd;
	}
	
	/**
	 * Column Info
	 * @param bkgTtlQty
	 */
	public void setBkgTtlQty(String bkgTtlQty) {
		this.bkgTtlQty = bkgTtlQty;
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
	 * @param divStnd
	 */
	public void setDivStnd(String divStnd) {
		this.divStnd = divStnd;
	}
	
	/**
	 * Column Info
	 * @param otrCommTtlAmt
	 */
	public void setOtrCommTtlAmt(String otrCommTtlAmt) {
		this.otrCommTtlAmt = otrCommTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param stndCostUsdAmt
	 */
	public void setStndCostUsdAmt(String stndCostUsdAmt) {
		this.stndCostUsdAmt = stndCostUsdAmt;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCommLocNm(JSPUtil.getParameter(request, prefix + "comm_loc_nm", ""));
		setMasCostSrcCdNm(JSPUtil.getParameter(request, prefix + "mas_cost_src_cd_nm", ""));
		setMasCostSrcCd(JSPUtil.getParameter(request, prefix + "mas_cost_src_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setCommLocCd(JSPUtil.getParameter(request, prefix + "comm_loc_cd", ""));
		setBkgTtlQty(JSPUtil.getParameter(request, prefix + "bkg_ttl_qty", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setDivStnd(JSPUtil.getParameter(request, prefix + "div_stnd", ""));
		setOtrCommTtlAmt(JSPUtil.getParameter(request, prefix + "otr_comm_ttl_amt", ""));
		setStndCostUsdAmt(JSPUtil.getParameter(request, prefix + "stnd_cost_usd_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchAgnOtrCommCostListVO[]
	 */
	public SearchAgnOtrCommCostListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchAgnOtrCommCostListVO[]
	 */
	public SearchAgnOtrCommCostListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchAgnOtrCommCostListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] commLocNm = (JSPUtil.getParameter(request, prefix	+ "comm_loc_nm", length));
			String[] masCostSrcCdNm = (JSPUtil.getParameter(request, prefix	+ "mas_cost_src_cd_nm", length));
			String[] masCostSrcCd = (JSPUtil.getParameter(request, prefix	+ "mas_cost_src_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] commLocCd = (JSPUtil.getParameter(request, prefix	+ "comm_loc_cd", length));
			String[] bkgTtlQty = (JSPUtil.getParameter(request, prefix	+ "bkg_ttl_qty", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] divStnd = (JSPUtil.getParameter(request, prefix	+ "div_stnd", length));
			String[] otrCommTtlAmt = (JSPUtil.getParameter(request, prefix	+ "otr_comm_ttl_amt", length));
			String[] stndCostUsdAmt = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_usd_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchAgnOtrCommCostListVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (commLocNm[i] != null)
					model.setCommLocNm(commLocNm[i]);
				if (masCostSrcCdNm[i] != null)
					model.setMasCostSrcCdNm(masCostSrcCdNm[i]);
				if (masCostSrcCd[i] != null)
					model.setMasCostSrcCd(masCostSrcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (commLocCd[i] != null)
					model.setCommLocCd(commLocCd[i]);
				if (bkgTtlQty[i] != null)
					model.setBkgTtlQty(bkgTtlQty[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (divStnd[i] != null)
					model.setDivStnd(divStnd[i]);
				if (otrCommTtlAmt[i] != null)
					model.setOtrCommTtlAmt(otrCommTtlAmt[i]);
				if (stndCostUsdAmt[i] != null)
					model.setStndCostUsdAmt(stndCostUsdAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchAgnOtrCommCostListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchAgnOtrCommCostListVO[]
	 */
	public SearchAgnOtrCommCostListVO[] getSearchAgnOtrCommCostListVOs(){
		SearchAgnOtrCommCostListVO[] vos = (SearchAgnOtrCommCostListVO[])models.toArray(new SearchAgnOtrCommCostListVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commLocNm = this.commLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masCostSrcCdNm = this.masCostSrcCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masCostSrcCd = this.masCostSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commLocCd = this.commLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTtlQty = this.bkgTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divStnd = this.divStnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrCommTtlAmt = this.otrCommTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostUsdAmt = this.stndCostUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
