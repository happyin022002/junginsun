/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchSalesRepInfoVO.java
*@FileTitle : SearchSalesRepInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.31
*@LastModifier : 
*@LastVersion : 1.0
* 2012.08.31  
* 1.0 Creation
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
=========================================================*/

package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

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

public class SearchSalesRepInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSalesRepInfoVO> models = new ArrayList<SearchSalesRepInfoVO>();
	
	/* Column Info */
	private String custLvl = null;
	/* Column Info */
	private String rvisCntrCustTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String custSts = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String srepNm = null;
	/* Column Info */
	private String slsOfcCd = null;
	/* Column Info */
	private String slsRepOfcTeamCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String srepCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String custIndivFlg = null;
	/* Column Info */
	private String existFlg = null;
	/* Column Info */
	private String trade = null;
	/* Column Info */
	private String custCtrlCd = null;
	/* Column Info */
	private String indivCust = null;
	/* Column Info */
	private SearchSalesRepInfoVO vo = null;
	/* Column Info */
	private List<SearchSalesRepInfoVO> voList = null;
	/* Page Number */
	private String pagerows = null;
	/* Page Number */
	private String ofcCd = null;
	/* Page Number */
	private String costYrwk = null;
	/* Page Number */
	private String subTrdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSalesRepInfoVO() {}

	public SearchSalesRepInfoVO(String ibflag, String pagerows, String srepCd, String srepNm, String slsOfcCd, String costYrwk, String custCntCd, String custSeq, String custSts, String custCd, String custNm, String custLvl, String rvisCntrCustTpCd, String custIndivFlg, String slsRepOfcTeamCd, String existFlg, String trade, String custCtrlCd, String indivCust, String ofcCd, String subTrdCd) {
		this.custLvl = custLvl;
		this.rvisCntrCustTpCd = rvisCntrCustTpCd;
		this.ibflag = ibflag;
		this.custNm = custNm;
		this.custSts = custSts;
		this.custCd = custCd;
		this.srepNm = srepNm;
		this.slsOfcCd = slsOfcCd;
		this.custSeq = custSeq;
		this.srepCd = srepCd;
		this.custCntCd = custCntCd;
		this.custIndivFlg = custIndivFlg;
		this.slsRepOfcTeamCd = slsRepOfcTeamCd;
		this.existFlg = existFlg;
		this.trade = trade;
		this.pagerows = pagerows;
		this.custCtrlCd = custCtrlCd;
		this.indivCust = indivCust;
		this.ofcCd = ofcCd;
		this.costYrwk = costYrwk;
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cust_lvl", getCustLvl());
		this.hashColumns.put("rvis_cntr_cust_tp_cd", getRvisCntrCustTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("cust_sts", getCustSts());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("srep_nm", getSrepNm());
		this.hashColumns.put("sls_ofc_cd", getSlsOfcCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("srep_cd", getSrepCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cust_indiv_flg", getCustIndivFlg());
		this.hashColumns.put("sls_rep_ofc_team_cd", getSlsRepOfcTeamCd());
		this.hashColumns.put("exist_flg", getExistFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("trade", getTrade());
		this.hashColumns.put("cust_ctrl_cd", getCustCtrlCd());
		this.hashColumns.put("indiv_cust", getIndivCust());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cost_yrwk", getCostYrwk());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cust_lvl", "custLvl");
		this.hashFields.put("rvis_cntr_cust_tp_cd", "rvisCntrCustTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("cust_sts", "custSts");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("srep_nm", "srepNm");
		this.hashFields.put("sls_ofc_cd", "slsOfcCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cust_indiv_flg", "custIndivFlg");
		this.hashFields.put("sls_rep_ofc_team_cd", "slsRepOfcTeamCd");
		this.hashFields.put("exist_flg", "existFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("trade", "trade");
		this.hashFields.put("cust_ctrl_cd", "custCtrlCd");
		this.hashFields.put("indiv_cust", "indivCust");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cost_yrwk", "costYrwk");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return custLvl
	 */
	public String getCustLvl() {
		return this.custLvl;
	}
	
	/**
	 * Column Info
	 * @return custTp
	 */
	public String getRvisCntrCustTpCd() {
		return this.rvisCntrCustTpCd;
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
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return custSts
	 */
	public String getCustSts() {
		return this.custSts;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return srepNm
	 */
	public String getSrepNm() {
		return this.srepNm;
	}
	
	/**
	 * Column Info
	 * @return slsOfcCd
	 */
	public String getSlsOfcCd() {
		return this.slsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return srepCd
	 */
	public String getSrepCd() {
		return this.srepCd;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return custGrpChk
	 */
	public String getCustIndivFlg() {
		return this.custIndivFlg;
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
	 * @param custLvl
	 */
	public void setCustLvl(String custLvl) {
		this.custLvl = custLvl;
	}
	
	/**
	 * @return the slsRepOfcTeamCd
	 */
	public String getSlsRepOfcTeamCd() {
		return slsRepOfcTeamCd;
	}

	/**
	 * @return the existFlg
	 */
	public String getExistFlg() {
		return existFlg;
	}
	
	/**
	 * @return the trade
	 */
	public String getTrade() {
		return trade;
	}
	
	/**
	 * @return the custCtrlCd
	 */
	public String getCustCtrlCd() {
		return custCtrlCd;
	}
	
	/**
	 * @return the indivCust
	 */
	public String getIndivCust() {
		return indivCust;
	}
	
	/**
	 * @return the ofcCd
	 */
	public String getOfcCd() {
		return ofcCd;
	}
	
	/**
	 * @return the costYrwk
	 */
	public String getCostYrwk() {
		return costYrwk;
	}
	/**
	 * @return the subTrdCd
	 */
	public String getSubTrdCd() {
		return subTrdCd;
	}

	/**
	 * @param existFlg the existFlg to set
	 */
	public void setExistFlg(String existFlg) {
		this.existFlg = existFlg;
	}

	/**
	 * @param slsRepOfcTeamCd the slsRepOfcTeamCd to set
	 */
	public void setSlsRepOfcTeamCd(String slsRepOfcTeamCd) {
		this.slsRepOfcTeamCd = slsRepOfcTeamCd;
	}

	/**
	 * Column Info
	 * @param custTp
	 */
	public void setRvisCntrCustTpCd(String rvisCntrCustTpCd) {
		this.rvisCntrCustTpCd = rvisCntrCustTpCd;
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
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param custSts
	 */
	public void setCustSts(String custSts) {
		this.custSts = custSts;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param srepNm
	 */
	public void setSrepNm(String srepNm) {
		this.srepNm = srepNm;
	}
	
	/**
	 * Column Info
	 * @param slsOfcCd
	 */
	public void setSlsOfcCd(String slsOfcCd) {
		this.slsOfcCd = slsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param srepCd
	 */
	public void setSrepCd(String srepCd) {
		this.srepCd = srepCd;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param custGrpChk
	 */
	public void setCustIndivFlg(String custIndivFlg) {
		this.custIndivFlg = custIndivFlg;
	}
	
	/**
	 * Column Info
	 * @param trade
	 */
	public void setTrade(String trade) {
		this.trade = trade;
	}
	
	/**
	 * Column Info
	 * @param custCtrlCd
	 */
	public void setCustCtrlCd(String custCtrlCd) {
		this.custCtrlCd = custCtrlCd;
	}
	
	/**
	 * Column Info
	 * @param indivCust
	 */
	public void setIndivCust(String indivCust) {
		this.indivCust = indivCust;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param costYrwk
	 */
	public void setCostYrwk(String costYrwk) {
		this.costYrwk = costYrwk;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
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
	
	public SearchSalesRepInfoVO getVo() {
		return vo;
	}


	public void setVo(SearchSalesRepInfoVO vo) {
		this.vo = vo;
	}


	public List<SearchSalesRepInfoVO> getVoList() {
		return voList;
	}


	public void setVoList(List<SearchSalesRepInfoVO> voList) {
		this.voList = voList;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setCustLvl(JSPUtil.getParameter(request, prefix + "cust_lvl", ""));
		setRvisCntrCustTpCd(JSPUtil.getParameter(request, prefix + "rvis_cntr_cust_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setCustSts(JSPUtil.getParameter(request, prefix + "cust_sts", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setSrepNm(JSPUtil.getParameter(request, prefix + "srep_nm", ""));
		setSlsOfcCd(JSPUtil.getParameter(request, prefix + "sls_ofc_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setCustIndivFlg(JSPUtil.getParameter(request, prefix + "cust_indiv_flg", ""));
		setSlsRepOfcTeamCd(JSPUtil.getParameter(request, prefix + "sls_rep_ofc_team_cd", ""));
		setExistFlg(JSPUtil.getParameter(request, prefix + "exist_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTrade(JSPUtil.getParameter(request, prefix + "trade", ""));
		setCustCtrlCd(JSPUtil.getParameter(request, prefix + "cust_ctrl_cd", ""));
		setIndivCust(JSPUtil.getParameter(request, prefix + "indiv_cust", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setCostYrwk(JSPUtil.getParameter(request, prefix + "cost_yrwk", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSalesRepInfoVO[]
	 */
	public SearchSalesRepInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSalesRepInfoVO[]
	 */
	public SearchSalesRepInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSalesRepInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] custLvl = (JSPUtil.getParameter(request, prefix	+ "cust_lvl", length));
			String[] rvisCntrCustTpCd = (JSPUtil.getParameter(request, prefix	+ "rvis_cntr_cust_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] custSts = (JSPUtil.getParameter(request, prefix	+ "cust_sts", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] srepNm = (JSPUtil.getParameter(request, prefix	+ "srep_nm", length));
			String[] slsOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] srepCd = (JSPUtil.getParameter(request, prefix	+ "srep_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] custIndivFlg = (JSPUtil.getParameter(request, prefix	+ "cust_indiv_flg", length));
			String[] slsRepOfcTeamCd = (JSPUtil.getParameter(request, prefix	+ "sls_rep_ofc_team_cd", length));
			String[] existFlg = (JSPUtil.getParameter(request, prefix	+ "exist_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] trade = (JSPUtil.getParameter(request, prefix	+ "trade", length));
			String[] custCtrlCd = (JSPUtil.getParameter(request, prefix	+ "cust_ctrl_cd", length));
			String[] indivCust = (JSPUtil.getParameter(request, prefix	+ "indiv_cust", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] costYrwk = (JSPUtil.getParameter(request, prefix	+ "cost_yrwk", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSalesRepInfoVO();
				if (custLvl[i] != null)
					model.setCustLvl(custLvl[i]);
				if (rvisCntrCustTpCd[i] != null)
					model.setRvisCntrCustTpCd(rvisCntrCustTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (custSts[i] != null)
					model.setCustSts(custSts[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (srepNm[i] != null)
					model.setSrepNm(srepNm[i]);
				if (slsOfcCd[i] != null)
					model.setSlsOfcCd(slsOfcCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (srepCd[i] != null)
					model.setSrepCd(srepCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (custIndivFlg[i] != null)
					model.setCustIndivFlg(custIndivFlg[i]);
				if (slsRepOfcTeamCd[i] != null)
					model.setSlsRepOfcTeamCd(slsRepOfcTeamCd[i]);
				if (existFlg[i] != null)
					model.setExistFlg(existFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (trade[i] != null)
					model.setTrade(trade[i]);
				if (custCtrlCd[i] != null)
					model.setCustCtrlCd(custCtrlCd[i]);
				if (indivCust[i] != null)
					model.setIndivCust(indivCust[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (costYrwk[i] != null)
					model.setCostYrwk(costYrwk[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSalesRepInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSalesRepInfoVO[]
	 */
	public SearchSalesRepInfoVO[] getSearchSalesRepInfoVOs(){
		SearchSalesRepInfoVO[] vos = (SearchSalesRepInfoVO[])models.toArray(new SearchSalesRepInfoVO[models.size()]);
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
		this.custLvl = this.custLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisCntrCustTpCd = this.rvisCntrCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSts = this.custSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepNm = this.srepNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcCd = this.slsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd = this.srepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custIndivFlg = this.custIndivFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRepOfcTeamCd = this.slsRepOfcTeamCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.existFlg = this.existFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trade = this.trade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCtrlCd = this.custCtrlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.indivCust = this.indivCust .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrwk = this.costYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
