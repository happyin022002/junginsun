/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchMAS0012ListVO.java
*@FileTitle : SearchMAS0012ListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 전윤주
*@LastVersion : 1.0
* 2009.10.13 전윤주 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.coa.stdunitcost.mas.vo;

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
 * @author 전윤주
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMAS0012ListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMAS0012ListVO> models = new ArrayList<SearchMAS0012ListVO>();
	
	/* Column Info */
	private String stpMgnRto = null;
	/* Column Info */
	private String ofcActCd = null;
	/* Column Info */
	private String actOfcTtlAmt = null;
	/* Column Info */
	private String actCostUtAmt = null;
	/* Column Info */
	private String svcTrnsPrcUtAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String svcTrnsPrcFlg = null;
	/* Column Info */
	private String actOfcTtlQty = null;
	/* Column Info */
	private String svcTrnsPrcCntCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String divMeasNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String ofcActNm = null;
	/* Column Info */
	private String cntAvgUcAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchMAS0012ListVO() {}

	public SearchMAS0012ListVO(String ibflag, String pagerows, String costYrmon, String ofcCd, String ofcActCd, String ofcActNm, String svcTrnsPrcFlg, String divMeasNm, String actOfcTtlQty, String actOfcTtlAmt, String actCostUtAmt, String svcTrnsPrcCntCd, String cntAvgUcAmt, String stpMgnRto, String svcTrnsPrcUtAmt) {
		this.stpMgnRto = stpMgnRto;
		this.ofcActCd = ofcActCd;
		this.actOfcTtlAmt = actOfcTtlAmt;
		this.actCostUtAmt = actCostUtAmt;
		this.svcTrnsPrcUtAmt = svcTrnsPrcUtAmt;
		this.pagerows = pagerows;
		this.svcTrnsPrcFlg = svcTrnsPrcFlg;
		this.actOfcTtlQty = actOfcTtlQty;
		this.svcTrnsPrcCntCd = svcTrnsPrcCntCd;
		this.ofcCd = ofcCd;
		this.divMeasNm = divMeasNm;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.ofcActNm = ofcActNm;
		this.cntAvgUcAmt = cntAvgUcAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("stp_mgn_rto", getStpMgnRto());
		this.hashColumns.put("ofc_act_cd", getOfcActCd());
		this.hashColumns.put("act_ofc_ttl_amt", getActOfcTtlAmt());
		this.hashColumns.put("act_cost_ut_amt", getActCostUtAmt());
		this.hashColumns.put("svc_trns_prc_ut_amt", getSvcTrnsPrcUtAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("svc_trns_prc_flg", getSvcTrnsPrcFlg());
		this.hashColumns.put("act_ofc_ttl_qty", getActOfcTtlQty());
		this.hashColumns.put("svc_trns_prc_cnt_cd", getSvcTrnsPrcCntCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("div_meas_nm", getDivMeasNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("ofc_act_nm", getOfcActNm());
		this.hashColumns.put("cnt_avg_uc_amt", getCntAvgUcAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("stp_mgn_rto", "stpMgnRto");
		this.hashFields.put("ofc_act_cd", "ofcActCd");
		this.hashFields.put("act_ofc_ttl_amt", "actOfcTtlAmt");
		this.hashFields.put("act_cost_ut_amt", "actCostUtAmt");
		this.hashFields.put("svc_trns_prc_ut_amt", "svcTrnsPrcUtAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("svc_trns_prc_flg", "svcTrnsPrcFlg");
		this.hashFields.put("act_ofc_ttl_qty", "actOfcTtlQty");
		this.hashFields.put("svc_trns_prc_cnt_cd", "svcTrnsPrcCntCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("div_meas_nm", "divMeasNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("ofc_act_nm", "ofcActNm");
		this.hashFields.put("cnt_avg_uc_amt", "cntAvgUcAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return stpMgnRto
	 */
	public String getStpMgnRto() {
		return this.stpMgnRto;
	}
	
	/**
	 * Column Info
	 * @return ofcActCd
	 */
	public String getOfcActCd() {
		return this.ofcActCd;
	}
	
	/**
	 * Column Info
	 * @return actOfcTtlAmt
	 */
	public String getActOfcTtlAmt() {
		return this.actOfcTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return actCostUtAmt
	 */
	public String getActCostUtAmt() {
		return this.actCostUtAmt;
	}
	
	/**
	 * Column Info
	 * @return svcTrnsPrcUtAmt
	 */
	public String getSvcTrnsPrcUtAmt() {
		return this.svcTrnsPrcUtAmt;
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
	 * @return svcTrnsPrcFlg
	 */
	public String getSvcTrnsPrcFlg() {
		return this.svcTrnsPrcFlg;
	}
	
	/**
	 * Column Info
	 * @return actOfcTtlQty
	 */
	public String getActOfcTtlQty() {
		return this.actOfcTtlQty;
	}
	
	/**
	 * Column Info
	 * @return svcTrnsPrcCntCd
	 */
	public String getSvcTrnsPrcCntCd() {
		return this.svcTrnsPrcCntCd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return divMeasNm
	 */
	public String getDivMeasNm() {
		return this.divMeasNm;
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
	 * @return ofcActNm
	 */
	public String getOfcActNm() {
		return this.ofcActNm;
	}
	
	/**
	 * Column Info
	 * @return cntAvgUcAmt
	 */
	public String getCntAvgUcAmt() {
		return this.cntAvgUcAmt;
	}
	

	/**
	 * Column Info
	 * @param stpMgnRto
	 */
	public void setStpMgnRto(String stpMgnRto) {
		this.stpMgnRto = stpMgnRto;
	}
	
	/**
	 * Column Info
	 * @param ofcActCd
	 */
	public void setOfcActCd(String ofcActCd) {
		this.ofcActCd = ofcActCd;
	}
	
	/**
	 * Column Info
	 * @param actOfcTtlAmt
	 */
	public void setActOfcTtlAmt(String actOfcTtlAmt) {
		this.actOfcTtlAmt = actOfcTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param actCostUtAmt
	 */
	public void setActCostUtAmt(String actCostUtAmt) {
		this.actCostUtAmt = actCostUtAmt;
	}
	
	/**
	 * Column Info
	 * @param svcTrnsPrcUtAmt
	 */
	public void setSvcTrnsPrcUtAmt(String svcTrnsPrcUtAmt) {
		this.svcTrnsPrcUtAmt = svcTrnsPrcUtAmt;
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
	 * @param svcTrnsPrcFlg
	 */
	public void setSvcTrnsPrcFlg(String svcTrnsPrcFlg) {
		this.svcTrnsPrcFlg = svcTrnsPrcFlg;
	}
	
	/**
	 * Column Info
	 * @param actOfcTtlQty
	 */
	public void setActOfcTtlQty(String actOfcTtlQty) {
		this.actOfcTtlQty = actOfcTtlQty;
	}
	
	/**
	 * Column Info
	 * @param svcTrnsPrcCntCd
	 */
	public void setSvcTrnsPrcCntCd(String svcTrnsPrcCntCd) {
		this.svcTrnsPrcCntCd = svcTrnsPrcCntCd;
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
	 * @param divMeasNm
	 */
	public void setDivMeasNm(String divMeasNm) {
		this.divMeasNm = divMeasNm;
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
	 * @param ofcActNm
	 */
	public void setOfcActNm(String ofcActNm) {
		this.ofcActNm = ofcActNm;
	}
	
	/**
	 * Column Info
	 * @param cntAvgUcAmt
	 */
	public void setCntAvgUcAmt(String cntAvgUcAmt) {
		this.cntAvgUcAmt = cntAvgUcAmt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setStpMgnRto(JSPUtil.getParameter(request, "stp_mgn_rto", ""));
		setOfcActCd(JSPUtil.getParameter(request, "ofc_act_cd", ""));
		setActOfcTtlAmt(JSPUtil.getParameter(request, "act_ofc_ttl_amt", ""));
		setActCostUtAmt(JSPUtil.getParameter(request, "act_cost_ut_amt", ""));
		setSvcTrnsPrcUtAmt(JSPUtil.getParameter(request, "svc_trns_prc_ut_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSvcTrnsPrcFlg(JSPUtil.getParameter(request, "svc_trns_prc_flg", ""));
		setActOfcTtlQty(JSPUtil.getParameter(request, "act_ofc_ttl_qty", ""));
		setSvcTrnsPrcCntCd(JSPUtil.getParameter(request, "svc_trns_prc_cnt_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setDivMeasNm(JSPUtil.getParameter(request, "div_meas_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, "cost_yrmon", ""));
		setOfcActNm(JSPUtil.getParameter(request, "ofc_act_nm", ""));
		setCntAvgUcAmt(JSPUtil.getParameter(request, "cnt_avg_uc_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMAS0012ListVO[]
	 */
	public SearchMAS0012ListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMAS0012ListVO[]
	 */
	public SearchMAS0012ListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMAS0012ListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] stpMgnRto = (JSPUtil.getParameter(request, prefix	+ "stp_mgn_rto", length));
			String[] ofcActCd = (JSPUtil.getParameter(request, prefix	+ "ofc_act_cd", length));
			String[] actOfcTtlAmt = (JSPUtil.getParameter(request, prefix	+ "act_ofc_ttl_amt", length));
			String[] actCostUtAmt = (JSPUtil.getParameter(request, prefix	+ "act_cost_ut_amt", length));
			String[] svcTrnsPrcUtAmt = (JSPUtil.getParameter(request, prefix	+ "svc_trns_prc_ut_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] svcTrnsPrcFlg = (JSPUtil.getParameter(request, prefix	+ "svc_trns_prc_flg", length));
			String[] actOfcTtlQty = (JSPUtil.getParameter(request, prefix	+ "act_ofc_ttl_qty", length));
			String[] svcTrnsPrcCntCd = (JSPUtil.getParameter(request, prefix	+ "svc_trns_prc_cnt_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] divMeasNm = (JSPUtil.getParameter(request, prefix	+ "div_meas_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] ofcActNm = (JSPUtil.getParameter(request, prefix	+ "ofc_act_nm", length));
			String[] cntAvgUcAmt = (JSPUtil.getParameter(request, prefix	+ "cnt_avg_uc_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMAS0012ListVO();
				if (stpMgnRto[i] != null)
					model.setStpMgnRto(stpMgnRto[i]);
				if (ofcActCd[i] != null)
					model.setOfcActCd(ofcActCd[i]);
				if (actOfcTtlAmt[i] != null)
					model.setActOfcTtlAmt(actOfcTtlAmt[i]);
				if (actCostUtAmt[i] != null)
					model.setActCostUtAmt(actCostUtAmt[i]);
				if (svcTrnsPrcUtAmt[i] != null)
					model.setSvcTrnsPrcUtAmt(svcTrnsPrcUtAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (svcTrnsPrcFlg[i] != null)
					model.setSvcTrnsPrcFlg(svcTrnsPrcFlg[i]);
				if (actOfcTtlQty[i] != null)
					model.setActOfcTtlQty(actOfcTtlQty[i]);
				if (svcTrnsPrcCntCd[i] != null)
					model.setSvcTrnsPrcCntCd(svcTrnsPrcCntCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (divMeasNm[i] != null)
					model.setDivMeasNm(divMeasNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (ofcActNm[i] != null)
					model.setOfcActNm(ofcActNm[i]);
				if (cntAvgUcAmt[i] != null)
					model.setCntAvgUcAmt(cntAvgUcAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMAS0012ListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMAS0012ListVO[]
	 */
	public SearchMAS0012ListVO[] getSearchMAS0012ListVOs(){
		SearchMAS0012ListVO[] vos = (SearchMAS0012ListVO[])models.toArray(new SearchMAS0012ListVO[models.size()]);
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
		this.stpMgnRto = this.stpMgnRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcActCd = this.ofcActCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actOfcTtlAmt = this.actOfcTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCostUtAmt = this.actCostUtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcTrnsPrcUtAmt = this.svcTrnsPrcUtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcTrnsPrcFlg = this.svcTrnsPrcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actOfcTtlQty = this.actOfcTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcTrnsPrcCntCd = this.svcTrnsPrcCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divMeasNm = this.divMeasNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcActNm = this.ofcActNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntAvgUcAmt = this.cntAvgUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
