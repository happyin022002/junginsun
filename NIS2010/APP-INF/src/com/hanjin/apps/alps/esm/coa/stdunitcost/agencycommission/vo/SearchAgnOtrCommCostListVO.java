/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchAgnOtrCommCostListVO.java
*@FileTitle : SearchAgnOtrCommCostListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 장영석
*@LastVersion : 1.0
* 2009.10.14 장영석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.coa.stdunitcost.agencycommission.vo;

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
 * @author 장영석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchAgnOtrCommCostListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchAgnOtrCommCostListVO> models = new ArrayList<SearchAgnOtrCommCostListVO>();
	
	/* Column Info */
	private String otrCommTtlAmt = null;
	/* Column Info */
	private String coaCostSrcCdNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String coaCostSrcCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String bkgTtlQty = null;
	/* Column Info */
	private String commLocCd = null;
	/* Column Info */
	private String stndCostUsdAmt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchAgnOtrCommCostListVO() {}

	public SearchAgnOtrCommCostListVO(String ibflag, String pagerows, String costYrmon, String commLocCd, String coaCostSrcCdNm, String coaCostSrcCd, String cntrTpszCd, String otrCommTtlAmt, String bkgTtlQty, String stndCostUsdAmt) {
		this.otrCommTtlAmt = otrCommTtlAmt;
		this.coaCostSrcCdNm = coaCostSrcCdNm;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.coaCostSrcCd = coaCostSrcCd;
		this.cntrTpszCd = cntrTpszCd;
		this.bkgTtlQty = bkgTtlQty;
		this.commLocCd = commLocCd;
		this.stndCostUsdAmt = stndCostUsdAmt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("otr_comm_ttl_amt", getOtrCommTtlAmt());
		this.hashColumns.put("coa_cost_src_cd_nm", getCoaCostSrcCdNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("coa_cost_src_cd", getCoaCostSrcCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("bkg_ttl_qty", getBkgTtlQty());
		this.hashColumns.put("comm_loc_cd", getCommLocCd());
		this.hashColumns.put("stnd_cost_usd_amt", getStndCostUsdAmt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("otr_comm_ttl_amt", "otrCommTtlAmt");
		this.hashFields.put("coa_cost_src_cd_nm", "coaCostSrcCdNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("coa_cost_src_cd", "coaCostSrcCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("bkg_ttl_qty", "bkgTtlQty");
		this.hashFields.put("comm_loc_cd", "commLocCd");
		this.hashFields.put("stnd_cost_usd_amt", "stndCostUsdAmt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return coaCostSrcCdNm
	 */
	public String getCoaCostSrcCdNm() {
		return this.coaCostSrcCdNm;
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
	 * @return coaCostSrcCd
	 */
	public String getCoaCostSrcCd() {
		return this.coaCostSrcCd;
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
	 * @return bkgTtlQty
	 */
	public String getBkgTtlQty() {
		return this.bkgTtlQty;
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
	 * @return stndCostUsdAmt
	 */
	public String getStndCostUsdAmt() {
		return this.stndCostUsdAmt;
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
	 * @param otrCommTtlAmt
	 */
	public void setOtrCommTtlAmt(String otrCommTtlAmt) {
		this.otrCommTtlAmt = otrCommTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param coaCostSrcCdNm
	 */
	public void setCoaCostSrcCdNm(String coaCostSrcCdNm) {
		this.coaCostSrcCdNm = coaCostSrcCdNm;
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
	 * @param coaCostSrcCd
	 */
	public void setCoaCostSrcCd(String coaCostSrcCd) {
		this.coaCostSrcCd = coaCostSrcCd;
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
	 * @param bkgTtlQty
	 */
	public void setBkgTtlQty(String bkgTtlQty) {
		this.bkgTtlQty = bkgTtlQty;
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
	 * @param stndCostUsdAmt
	 */
	public void setStndCostUsdAmt(String stndCostUsdAmt) {
		this.stndCostUsdAmt = stndCostUsdAmt;
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
		setOtrCommTtlAmt(JSPUtil.getParameter(request, "otr_comm_ttl_amt", ""));
		setCoaCostSrcCdNm(JSPUtil.getParameter(request, "coa_cost_src_cd_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, "cost_yrmon", ""));
		setCoaCostSrcCd(JSPUtil.getParameter(request, "coa_cost_src_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setBkgTtlQty(JSPUtil.getParameter(request, "bkg_ttl_qty", ""));
		setCommLocCd(JSPUtil.getParameter(request, "comm_loc_cd", ""));
		setStndCostUsdAmt(JSPUtil.getParameter(request, "stnd_cost_usd_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
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
			String[] otrCommTtlAmt = (JSPUtil.getParameter(request, prefix	+ "otr_comm_ttl_amt", length));
			String[] coaCostSrcCdNm = (JSPUtil.getParameter(request, prefix	+ "coa_cost_src_cd_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] coaCostSrcCd = (JSPUtil.getParameter(request, prefix	+ "coa_cost_src_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] bkgTtlQty = (JSPUtil.getParameter(request, prefix	+ "bkg_ttl_qty", length));
			String[] commLocCd = (JSPUtil.getParameter(request, prefix	+ "comm_loc_cd", length));
			String[] stndCostUsdAmt = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_usd_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchAgnOtrCommCostListVO();
				if (otrCommTtlAmt[i] != null)
					model.setOtrCommTtlAmt(otrCommTtlAmt[i]);
				if (coaCostSrcCdNm[i] != null)
					model.setCoaCostSrcCdNm(coaCostSrcCdNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (coaCostSrcCd[i] != null)
					model.setCoaCostSrcCd(coaCostSrcCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (bkgTtlQty[i] != null)
					model.setBkgTtlQty(bkgTtlQty[i]);
				if (commLocCd[i] != null)
					model.setCommLocCd(commLocCd[i]);
				if (stndCostUsdAmt[i] != null)
					model.setStndCostUsdAmt(stndCostUsdAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
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
		this.otrCommTtlAmt = this.otrCommTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaCostSrcCdNm = this.coaCostSrcCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaCostSrcCd = this.coaCostSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTtlQty = this.bkgTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commLocCd = this.commLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostUsdAmt = this.stndCostUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
