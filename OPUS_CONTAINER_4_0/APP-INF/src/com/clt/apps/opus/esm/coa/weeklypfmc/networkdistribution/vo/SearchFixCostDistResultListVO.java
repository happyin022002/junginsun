/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchFixCostDistResultListVO.java
*@FileTitle : SearchFixCostDistResultListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.22
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2011.02.22 최성민 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.vo;

import java.lang.reflect.Field;
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
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchFixCostDistResultListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchFixCostDistResultListVO> models = new ArrayList<SearchFixCostDistResultListVO>();
	
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String coSlsAmt = null;
	/* Column Info */
	private String n1stAsgnAmt = null;
	/* Column Info */
	private String totalNetworkCost = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String n2stAsgnAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String iptAsgnAmt = null;
	/* Column Info */
	private String coSalesFinal = null;
	/* Column Info */
	private String coAmt = null;
	//SJH.20141104.ADD
	/* Column Info */
	private String sltInterAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchFixCostDistResultListVO() {}

	public SearchFixCostDistResultListVO(String ibflag, String pagerows, String costYrmon, String costWk, String trdCd, String rlaneCd, String iocCd, String vvdCd, String coAmt, String coSlsAmt, String n1stAsgnAmt, String n2stAsgnAmt, String iptAsgnAmt, String coSalesFinal, String totalNetworkCost, String sltInterAmt) {
		this.iocCd = iocCd;
		this.coSlsAmt = coSlsAmt;
		this.n1stAsgnAmt = n1stAsgnAmt;
		this.totalNetworkCost = totalNetworkCost;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.n2stAsgnAmt = n2stAsgnAmt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.vvdCd = vvdCd;
		this.costWk = costWk;
		this.iptAsgnAmt = iptAsgnAmt;
		this.coSalesFinal = coSalesFinal;
		this.coAmt = coAmt;
		//SJH.20141104.ADD
		this.sltInterAmt = sltInterAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("co_sls_amt", getCoSlsAmt());
		this.hashColumns.put("n1st_asgn_amt", getN1stAsgnAmt());
		this.hashColumns.put("total_network_cost", getTotalNetworkCost());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("n2st_asgn_amt", getN2stAsgnAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("ipt_asgn_amt", getIptAsgnAmt());
		this.hashColumns.put("co_sales_final", getCoSalesFinal());
		this.hashColumns.put("co_amt", getCoAmt());
		//SJH.20141104.ADD
		this.hashColumns.put("slt_inter_amt", getSltInterAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("co_sls_amt", "coSlsAmt");
		this.hashFields.put("n1st_asgn_amt", "n1stAsgnAmt");
		this.hashFields.put("total_network_cost", "totalNetworkCost");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("n2st_asgn_amt", "n2stAsgnAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("ipt_asgn_amt", "iptAsgnAmt");
		this.hashFields.put("co_sales_final", "coSalesFinal");
		this.hashFields.put("co_amt", "coAmt");
		//SJH.20141104.ADD
		this.hashFields.put("slt_inter_amt", "sltInterAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return iocCd
	 */
	public String getIocCd() {
		return this.iocCd;
	}
	
	/**
	 * Column Info
	 * @return coSlsAmt
	 */
	public String getCoSlsAmt() {
		return this.coSlsAmt;
	}
	
	/**
	 * Column Info
	 * @return n1stAsgnAmt
	 */
	public String getN1stAsgnAmt() {
		return this.n1stAsgnAmt;
	}
	
	/**
	 * Column Info
	 * @return totalNetworkCost
	 */
	public String getTotalNetworkCost() {
		return this.totalNetworkCost;
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
	 * @return n2stAsgnAmt
	 */
	public String getN2stAsgnAmt() {
		return this.n2stAsgnAmt;
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
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
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
	 * @return iptAsgnAmt
	 */
	public String getIptAsgnAmt() {
		return this.iptAsgnAmt;
	}
	
	/**
	 * Column Info
	 * @return coSalesFinal
	 */
	public String getCoSalesFinal() {
		return this.coSalesFinal;
	}
	
	/**
	 * Column Info
	 * @return coAmt
	 */
	public String getCoAmt() {
		return this.coAmt;
	}
	
	/**
	 * Column Info
	 * @return sltInterAmt
	 * @author SJH.20141104.ADD
	 */
	public String getSltInterAmt() {
		return this.sltInterAmt;
	}	
	

	/**
	 * Column Info
	 * @param iocCd
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
	}
	
	/**
	 * Column Info
	 * @param coSlsAmt
	 */
	public void setCoSlsAmt(String coSlsAmt) {
		this.coSlsAmt = coSlsAmt;
	}
	
	/**
	 * Column Info
	 * @param n1stAsgnAmt
	 */
	public void setN1stAsgnAmt(String n1stAsgnAmt) {
		this.n1stAsgnAmt = n1stAsgnAmt;
	}
	
	/**
	 * Column Info
	 * @param totalNetworkCost
	 */
	public void setTotalNetworkCost(String totalNetworkCost) {
		this.totalNetworkCost = totalNetworkCost;
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
	 * @param n2stAsgnAmt
	 */
	public void setN2stAsgnAmt(String n2stAsgnAmt) {
		this.n2stAsgnAmt = n2stAsgnAmt;
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
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
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
	 * @param iptAsgnAmt
	 */
	public void setIptAsgnAmt(String iptAsgnAmt) {
		this.iptAsgnAmt = iptAsgnAmt;
	}
	
	/**
	 * Column Info
	 * @param coSalesFinal
	 */
	public void setCoSalesFinal(String coSalesFinal) {
		this.coSalesFinal = coSalesFinal;
	}
	
	/**
	 * Column Info
	 * @param coAmt
	 */
	public void setCoAmt(String coAmt) {
		this.coAmt = coAmt;
	}
	
	/**
	 * Column Info
	 * @param sltInterAmt
	 * @author SJH.20141104.ADD
	 */
	public void setSltInterAmt(String sltInterAmt) {
		this.coAmt = sltInterAmt;
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
		setIocCd(JSPUtil.getParameter(request, prefix + "ioc_cd", ""));
		setCoSlsAmt(JSPUtil.getParameter(request, prefix + "co_sls_amt", ""));
		setN1stAsgnAmt(JSPUtil.getParameter(request, prefix + "n1st_asgn_amt", ""));
		setTotalNetworkCost(JSPUtil.getParameter(request, prefix + "total_network_cost", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setN2stAsgnAmt(JSPUtil.getParameter(request, prefix + "n2st_asgn_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setCostWk(JSPUtil.getParameter(request, prefix + "cost_wk", ""));
		setIptAsgnAmt(JSPUtil.getParameter(request, prefix + "ipt_asgn_amt", ""));
		setCoSalesFinal(JSPUtil.getParameter(request, prefix + "co_sales_final", ""));
		setCoAmt(JSPUtil.getParameter(request, prefix + "co_amt", ""));
		//SJH.20141104.ADD
		setSltInterAmt(JSPUtil.getParameter(request, prefix + "slt_inter_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchFixCostDistResultListVO[]
	 */
	public SearchFixCostDistResultListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchFixCostDistResultListVO[]
	 */
	public SearchFixCostDistResultListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchFixCostDistResultListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] coSlsAmt = (JSPUtil.getParameter(request, prefix	+ "co_sls_amt", length));
			String[] n1stAsgnAmt = (JSPUtil.getParameter(request, prefix	+ "n1st_asgn_amt", length));
			String[] totalNetworkCost = (JSPUtil.getParameter(request, prefix	+ "total_network_cost", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] n2stAsgnAmt = (JSPUtil.getParameter(request, prefix	+ "n2st_asgn_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] iptAsgnAmt = (JSPUtil.getParameter(request, prefix	+ "ipt_asgn_amt", length));
			String[] coSalesFinal = (JSPUtil.getParameter(request, prefix	+ "co_sales_final", length));
			String[] coAmt = (JSPUtil.getParameter(request, prefix	+ "co_amt", length));
			//SJH.20141104.ADD
			String[] sltInterAmt = (JSPUtil.getParameter(request, prefix	+ "slt_inter_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchFixCostDistResultListVO();
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (coSlsAmt[i] != null)
					model.setCoSlsAmt(coSlsAmt[i]);
				if (n1stAsgnAmt[i] != null)
					model.setN1stAsgnAmt(n1stAsgnAmt[i]);
				if (totalNetworkCost[i] != null)
					model.setTotalNetworkCost(totalNetworkCost[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (n2stAsgnAmt[i] != null)
					model.setN2stAsgnAmt(n2stAsgnAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (iptAsgnAmt[i] != null)
					model.setIptAsgnAmt(iptAsgnAmt[i]);
				if (coSalesFinal[i] != null)
					model.setCoSalesFinal(coSalesFinal[i]);
				if (coAmt[i] != null)
					model.setCoAmt(coAmt[i]);
				//SJH.20141104.ADD
				if (sltInterAmt[i] != null)
					model.setSltInterAmt(sltInterAmt[i]);				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchFixCostDistResultListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchFixCostDistResultListVO[]
	 */
	public SearchFixCostDistResultListVO[] getSearchFixCostDistResultListVOs(){
		SearchFixCostDistResultListVO[] vos = (SearchFixCostDistResultListVO[])models.toArray(new SearchFixCostDistResultListVO[models.size()]);
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
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coSlsAmt = this.coSlsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stAsgnAmt = this.n1stAsgnAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalNetworkCost = this.totalNetworkCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2stAsgnAmt = this.n2stAsgnAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iptAsgnAmt = this.iptAsgnAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coSalesFinal = this.coSalesFinal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coAmt = this.coAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		//SJH.20141104.ADD
		this.sltInterAmt = this.sltInterAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
