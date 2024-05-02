/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchFixCostByVVDInterPrcListVO.java
*@FileTitle : SearchFixCostByVVDInterPrcListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.22
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2011.02.22 김상수 
* 1.0 Creation
 *=========================================================
 * History
 * 2011.02.21 김상수 [CHM-201108827-01] * R.month/Week 및 OPR/OPR2 정보 보여주는 칼럼 추가
 * 2012.05.04 전윤주  [CHM-201217586] CNTR_TEU_QTY 추가
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchFixCostByVVDInterPrcListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchFixCostByVVDInterPrcListVO> models = new ArrayList<SearchFixCostByVVDInterPrcListVO>();
	
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String slsYrmon = null;
	/* Column Info */
	private String interPrcUcAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String interPrcTtlExpnAmt = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String cntrLodQty = null;
	/* Column Info */
	private String cntrTeuQty = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchFixCostByVVDInterPrcListVO() {}

	public SearchFixCostByVVDInterPrcListVO(String ibflag, String pagerows, String cntrLodQty, String cntrTeuQty, String costWk, String costYrmon, String interPrcTtlExpnAmt, String interPrcUcAmt, String rlaneCd, String slsYrmon, String trdCd, String vvd) {
		this.vvd = vvd;
		this.slsYrmon = slsYrmon;
		this.interPrcUcAmt = interPrcUcAmt;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.interPrcTtlExpnAmt = interPrcTtlExpnAmt;
		this.costWk = costWk;
		this.cntrLodQty = cntrLodQty;
		this.cntrTeuQty = cntrTeuQty;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("sls_yrmon", getSlsYrmon());
		this.hashColumns.put("inter_prc_uc_amt", getInterPrcUcAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("inter_prc_ttl_expn_amt", getInterPrcTtlExpnAmt());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("cntr_lod_qty", getCntrLodQty());
		this.hashColumns.put("cntr_teu_qty", getCntrTeuQty());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("sls_yrmon", "slsYrmon");
		this.hashFields.put("inter_prc_uc_amt", "interPrcUcAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("inter_prc_ttl_expn_amt", "interPrcTtlExpnAmt");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("cntr_lod_qty", "cntrLodQty");
		this.hashFields.put("cntr_teu_qty", "cntrTeuQty");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return slsYrmon
	 */
	public String getSlsYrmon() {
		return this.slsYrmon;
	}
	
	/**
	 * Column Info
	 * @return interPrcUcAmt
	 */
	public String getInterPrcUcAmt() {
		return this.interPrcUcAmt;
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
	 * @return interPrcTtlExpnAmt
	 */
	public String getInterPrcTtlExpnAmt() {
		return this.interPrcTtlExpnAmt;
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
	 * @return cntrLodQty
	 */
	public String getCntrLodQty() {
		return this.cntrLodQty;
	}
	/**
	 * Column Info
	 * @return cntrTeuQty
	 */
	public String getCntrTeuQty() {
		return this.cntrTeuQty;
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
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	

	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param slsYrmon
	 */
	public void setSlsYrmon(String slsYrmon) {
		this.slsYrmon = slsYrmon;
	}
	
	/**
	 * Column Info
	 * @param interPrcUcAmt
	 */
	public void setInterPrcUcAmt(String interPrcUcAmt) {
		this.interPrcUcAmt = interPrcUcAmt;
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
	 * @param interPrcTtlExpnAmt
	 */
	public void setInterPrcTtlExpnAmt(String interPrcTtlExpnAmt) {
		this.interPrcTtlExpnAmt = interPrcTtlExpnAmt;
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
	 * @param cntrLodQty
	 */
	public void setCntrLodQty(String cntrLodQty) {
		this.cntrLodQty = cntrLodQty;
	}
	/**
	 * Column Info
	 * @param cntrTeuQty
	 */
	public void setCntrTeuQty(String cntrTeuQty) {
		this.cntrTeuQty = cntrTeuQty;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setSlsYrmon(JSPUtil.getParameter(request, prefix + "sls_yrmon", ""));
		setInterPrcUcAmt(JSPUtil.getParameter(request, prefix + "inter_prc_uc_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setInterPrcTtlExpnAmt(JSPUtil.getParameter(request, prefix + "inter_prc_ttl_expn_amt", ""));
		setCostWk(JSPUtil.getParameter(request, prefix + "cost_wk", ""));
		setCntrLodQty(JSPUtil.getParameter(request, prefix + "cntr_lod_qty", ""));
		setCntrTeuQty(JSPUtil.getParameter(request, prefix + "cntr_teu_qty", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchFixCostByVVDInterPrcListVO[]
	 */
	public SearchFixCostByVVDInterPrcListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchFixCostByVVDInterPrcListVO[]
	 */
	public SearchFixCostByVVDInterPrcListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchFixCostByVVDInterPrcListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] slsYrmon = (JSPUtil.getParameter(request, prefix	+ "sls_yrmon", length));
			String[] interPrcUcAmt = (JSPUtil.getParameter(request, prefix	+ "inter_prc_uc_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] interPrcTtlExpnAmt = (JSPUtil.getParameter(request, prefix	+ "inter_prc_ttl_expn_amt", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] cntrLodQty = (JSPUtil.getParameter(request, prefix	+ "cntr_lod_qty", length));
			String[] cntrTeuQty = (JSPUtil.getParameter(request, prefix	+ "cntr_teu_qty", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchFixCostByVVDInterPrcListVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (slsYrmon[i] != null)
					model.setSlsYrmon(slsYrmon[i]);
				if (interPrcUcAmt[i] != null)
					model.setInterPrcUcAmt(interPrcUcAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (interPrcTtlExpnAmt[i] != null)
					model.setInterPrcTtlExpnAmt(interPrcTtlExpnAmt[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (cntrLodQty[i] != null)
					model.setCntrLodQty(cntrLodQty[i]);
				if (cntrTeuQty[i] != null)
					model.setCntrTeuQty(cntrTeuQty[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchFixCostByVVDInterPrcListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchFixCostByVVDInterPrcListVO[]
	 */
	public SearchFixCostByVVDInterPrcListVO[] getSearchFixCostByVVDInterPrcListVOs(){
		SearchFixCostByVVDInterPrcListVO[] vos = (SearchFixCostByVVDInterPrcListVO[])models.toArray(new SearchFixCostByVVDInterPrcListVO[models.size()]);
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
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsYrmon = this.slsYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interPrcUcAmt = this.interPrcUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interPrcTtlExpnAmt = this.interPrcTtlExpnAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrLodQty = this.cntrLodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTeuQty = this.cntrTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
