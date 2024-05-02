/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchMonthlyAvgUC0057List2VO.java
*@FileTitle : SearchMonthlyAvgUC0057List2VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 김기식
*@LastVersion : 1.0
* 2009.10.13 김기식 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.vo;

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
 * @author 김기식
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMonthlyAvgUC0057List2VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMonthlyAvgUC0057List2VO> models = new ArrayList<SearchMonthlyAvgUC0057List2VO>();
	
	/* Column Info */
	private String n1stPodCd = null;
	/* Column Info */
	private String bkgPorCd = null;
	/* Column Info */
	private String rev = null;
	/* Column Info */
	private String op = null;
	/* Column Info */
	private String tpszCode = null;
	/* Column Info */
	private String n1stPolCd = null;
	/* Column Info */
	private String n2ndRlaneCd = null;
	/* Column Info */
	private String n4thRlaneCd = null;
	/* Column Info */
	private String n2ndPodCd = null;
	/* Column Info */
	private String n4thPolCd = null;
	/* Column Info */
	private String cmCost = null;
	/* Column Info */
	private String n4thPodCd = null;
	/* Column Info */
	private String opCost = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String n3rdPodCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String n3rdRlaneCd = null;
	/* Column Info */
	private String cm = null;
	/* Column Info */
	private String n2ndPolCd = null;
	/* Column Info */
	private String bkgDelCd = null;
	/* Column Info */
	private String n3rdPolCd = null;
	/* Column Info */
	private String load = null;
	/* Column Info */
	private String n1stRlaneCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchMonthlyAvgUC0057List2VO() {}

	public SearchMonthlyAvgUC0057List2VO(String ibflag, String pagerows, String bkgPorCd, String bkgDelCd, String n1stRlaneCd, String n1stPolCd, String n1stPodCd, String n2ndRlaneCd, String n2ndPolCd, String n2ndPodCd, String n3rdRlaneCd, String n3rdPolCd, String n3rdPodCd, String n4thRlaneCd, String n4thPolCd, String n4thPodCd, String tpszCode, String load, String rev, String cmCost, String cm, String opCost, String op) {
		this.n1stPodCd = n1stPodCd;
		this.bkgPorCd = bkgPorCd;
		this.rev = rev;
		this.op = op;
		this.tpszCode = tpszCode;
		this.n1stPolCd = n1stPolCd;
		this.n2ndRlaneCd = n2ndRlaneCd;
		this.n4thRlaneCd = n4thRlaneCd;
		this.n2ndPodCd = n2ndPodCd;
		this.n4thPolCd = n4thPolCd;
		this.cmCost = cmCost;
		this.n4thPodCd = n4thPodCd;
		this.opCost = opCost;
		this.pagerows = pagerows;
		this.n3rdPodCd = n3rdPodCd;
		this.ibflag = ibflag;
		this.n3rdRlaneCd = n3rdRlaneCd;
		this.cm = cm;
		this.n2ndPolCd = n2ndPolCd;
		this.bkgDelCd = bkgDelCd;
		this.n3rdPolCd = n3rdPolCd;
		this.load = load;
		this.n1stRlaneCd = n1stRlaneCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("n1st_pod_cd", getN1stPodCd());
		this.hashColumns.put("bkg_por_cd", getBkgPorCd());
		this.hashColumns.put("rev", getRev());
		this.hashColumns.put("op", getOp());
		this.hashColumns.put("tpsz_code", getTpszCode());
		this.hashColumns.put("n1st_pol_cd", getN1stPolCd());
		this.hashColumns.put("n2nd_rlane_cd", getN2ndRlaneCd());
		this.hashColumns.put("n4th_rlane_cd", getN4thRlaneCd());
		this.hashColumns.put("n2nd_pod_cd", getN2ndPodCd());
		this.hashColumns.put("n4th_pol_cd", getN4thPolCd());
		this.hashColumns.put("cm_cost", getCmCost());
		this.hashColumns.put("n4th_pod_cd", getN4thPodCd());
		this.hashColumns.put("op_cost", getOpCost());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("n3rd_pod_cd", getN3rdPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("n3rd_rlane_cd", getN3rdRlaneCd());
		this.hashColumns.put("cm", getCm());
		this.hashColumns.put("n2nd_pol_cd", getN2ndPolCd());
		this.hashColumns.put("bkg_del_cd", getBkgDelCd());
		this.hashColumns.put("n3rd_pol_cd", getN3rdPolCd());
		this.hashColumns.put("load", getLoad());
		this.hashColumns.put("n1st_rlane_cd", getN1stRlaneCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("n1st_pod_cd", "n1stPodCd");
		this.hashFields.put("bkg_por_cd", "bkgPorCd");
		this.hashFields.put("rev", "rev");
		this.hashFields.put("op", "op");
		this.hashFields.put("tpsz_code", "tpszCode");
		this.hashFields.put("n1st_pol_cd", "n1stPolCd");
		this.hashFields.put("n2nd_rlane_cd", "n2ndRlaneCd");
		this.hashFields.put("n4th_rlane_cd", "n4thRlaneCd");
		this.hashFields.put("n2nd_pod_cd", "n2ndPodCd");
		this.hashFields.put("n4th_pol_cd", "n4thPolCd");
		this.hashFields.put("cm_cost", "cmCost");
		this.hashFields.put("n4th_pod_cd", "n4thPodCd");
		this.hashFields.put("op_cost", "opCost");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("n3rd_pod_cd", "n3rdPodCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("n3rd_rlane_cd", "n3rdRlaneCd");
		this.hashFields.put("cm", "cm");
		this.hashFields.put("n2nd_pol_cd", "n2ndPolCd");
		this.hashFields.put("bkg_del_cd", "bkgDelCd");
		this.hashFields.put("n3rd_pol_cd", "n3rdPolCd");
		this.hashFields.put("load", "load");
		this.hashFields.put("n1st_rlane_cd", "n1stRlaneCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return n1stPodCd
	 */
	public String getN1stPodCd() {
		return this.n1stPodCd;
	}
	
	/**
	 * Column Info
	 * @return bkgPorCd
	 */
	public String getBkgPorCd() {
		return this.bkgPorCd;
	}
	
	/**
	 * Column Info
	 * @return rev
	 */
	public String getRev() {
		return this.rev;
	}
	
	/**
	 * Column Info
	 * @return op
	 */
	public String getOp() {
		return this.op;
	}
	
	/**
	 * Column Info
	 * @return tpszCode
	 */
	public String getTpszCode() {
		return this.tpszCode;
	}
	
	/**
	 * Column Info
	 * @return n1stPolCd
	 */
	public String getN1stPolCd() {
		return this.n1stPolCd;
	}
	
	/**
	 * Column Info
	 * @return n2ndRlaneCd
	 */
	public String getN2ndRlaneCd() {
		return this.n2ndRlaneCd;
	}
	
	/**
	 * Column Info
	 * @return n4thRlaneCd
	 */
	public String getN4thRlaneCd() {
		return this.n4thRlaneCd;
	}
	
	/**
	 * Column Info
	 * @return n2ndPodCd
	 */
	public String getN2ndPodCd() {
		return this.n2ndPodCd;
	}
	
	/**
	 * Column Info
	 * @return n4thPolCd
	 */
	public String getN4thPolCd() {
		return this.n4thPolCd;
	}
	
	/**
	 * Column Info
	 * @return cmCost
	 */
	public String getCmCost() {
		return this.cmCost;
	}
	
	/**
	 * Column Info
	 * @return n4thPodCd
	 */
	public String getN4thPodCd() {
		return this.n4thPodCd;
	}
	
	/**
	 * Column Info
	 * @return opCost
	 */
	public String getOpCost() {
		return this.opCost;
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
	 * @return n3rdPodCd
	 */
	public String getN3rdPodCd() {
		return this.n3rdPodCd;
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
	 * @return n3rdRlaneCd
	 */
	public String getN3rdRlaneCd() {
		return this.n3rdRlaneCd;
	}
	
	/**
	 * Column Info
	 * @return cm
	 */
	public String getCm() {
		return this.cm;
	}
	
	/**
	 * Column Info
	 * @return n2ndPolCd
	 */
	public String getN2ndPolCd() {
		return this.n2ndPolCd;
	}
	
	/**
	 * Column Info
	 * @return bkgDelCd
	 */
	public String getBkgDelCd() {
		return this.bkgDelCd;
	}
	
	/**
	 * Column Info
	 * @return n3rdPolCd
	 */
	public String getN3rdPolCd() {
		return this.n3rdPolCd;
	}
	
	/**
	 * Column Info
	 * @return load
	 */
	public String getLoad() {
		return this.load;
	}
	
	/**
	 * Column Info
	 * @return n1stRlaneCd
	 */
	public String getN1stRlaneCd() {
		return this.n1stRlaneCd;
	}
	

	/**
	 * Column Info
	 * @param n1stPodCd
	 */
	public void setN1stPodCd(String n1stPodCd) {
		this.n1stPodCd = n1stPodCd;
	}
	
	/**
	 * Column Info
	 * @param bkgPorCd
	 */
	public void setBkgPorCd(String bkgPorCd) {
		this.bkgPorCd = bkgPorCd;
	}
	
	/**
	 * Column Info
	 * @param rev
	 */
	public void setRev(String rev) {
		this.rev = rev;
	}
	
	/**
	 * Column Info
	 * @param op
	 */
	public void setOp(String op) {
		this.op = op;
	}
	
	/**
	 * Column Info
	 * @param tpszCode
	 */
	public void setTpszCode(String tpszCode) {
		this.tpszCode = tpszCode;
	}
	
	/**
	 * Column Info
	 * @param n1stPolCd
	 */
	public void setN1stPolCd(String n1stPolCd) {
		this.n1stPolCd = n1stPolCd;
	}
	
	/**
	 * Column Info
	 * @param n2ndRlaneCd
	 */
	public void setN2ndRlaneCd(String n2ndRlaneCd) {
		this.n2ndRlaneCd = n2ndRlaneCd;
	}
	
	/**
	 * Column Info
	 * @param n4thRlaneCd
	 */
	public void setN4thRlaneCd(String n4thRlaneCd) {
		this.n4thRlaneCd = n4thRlaneCd;
	}
	
	/**
	 * Column Info
	 * @param n2ndPodCd
	 */
	public void setN2ndPodCd(String n2ndPodCd) {
		this.n2ndPodCd = n2ndPodCd;
	}
	
	/**
	 * Column Info
	 * @param n4thPolCd
	 */
	public void setN4thPolCd(String n4thPolCd) {
		this.n4thPolCd = n4thPolCd;
	}
	
	/**
	 * Column Info
	 * @param cmCost
	 */
	public void setCmCost(String cmCost) {
		this.cmCost = cmCost;
	}
	
	/**
	 * Column Info
	 * @param n4thPodCd
	 */
	public void setN4thPodCd(String n4thPodCd) {
		this.n4thPodCd = n4thPodCd;
	}
	
	/**
	 * Column Info
	 * @param opCost
	 */
	public void setOpCost(String opCost) {
		this.opCost = opCost;
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
	 * @param n3rdPodCd
	 */
	public void setN3rdPodCd(String n3rdPodCd) {
		this.n3rdPodCd = n3rdPodCd;
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
	 * @param n3rdRlaneCd
	 */
	public void setN3rdRlaneCd(String n3rdRlaneCd) {
		this.n3rdRlaneCd = n3rdRlaneCd;
	}
	
	/**
	 * Column Info
	 * @param cm
	 */
	public void setCm(String cm) {
		this.cm = cm;
	}
	
	/**
	 * Column Info
	 * @param n2ndPolCd
	 */
	public void setN2ndPolCd(String n2ndPolCd) {
		this.n2ndPolCd = n2ndPolCd;
	}
	
	/**
	 * Column Info
	 * @param bkgDelCd
	 */
	public void setBkgDelCd(String bkgDelCd) {
		this.bkgDelCd = bkgDelCd;
	}
	
	/**
	 * Column Info
	 * @param n3rdPolCd
	 */
	public void setN3rdPolCd(String n3rdPolCd) {
		this.n3rdPolCd = n3rdPolCd;
	}
	
	/**
	 * Column Info
	 * @param load
	 */
	public void setLoad(String load) {
		this.load = load;
	}
	
	/**
	 * Column Info
	 * @param n1stRlaneCd
	 */
	public void setN1stRlaneCd(String n1stRlaneCd) {
		this.n1stRlaneCd = n1stRlaneCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setN1stPodCd(JSPUtil.getParameter(request, "n1st_pod_cd", ""));
		setBkgPorCd(JSPUtil.getParameter(request, "bkg_por_cd", ""));
		setRev(JSPUtil.getParameter(request, "rev", ""));
		setOp(JSPUtil.getParameter(request, "op", ""));
		setTpszCode(JSPUtil.getParameter(request, "tpsz_code", ""));
		setN1stPolCd(JSPUtil.getParameter(request, "n1st_pol_cd", ""));
		setN2ndRlaneCd(JSPUtil.getParameter(request, "n2nd_rlane_cd", ""));
		setN4thRlaneCd(JSPUtil.getParameter(request, "n4th_rlane_cd", ""));
		setN2ndPodCd(JSPUtil.getParameter(request, "n2nd_pod_cd", ""));
		setN4thPolCd(JSPUtil.getParameter(request, "n4th_pol_cd", ""));
		setCmCost(JSPUtil.getParameter(request, "cm_cost", ""));
		setN4thPodCd(JSPUtil.getParameter(request, "n4th_pod_cd", ""));
		setOpCost(JSPUtil.getParameter(request, "op_cost", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setN3rdPodCd(JSPUtil.getParameter(request, "n3rd_pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setN3rdRlaneCd(JSPUtil.getParameter(request, "n3rd_rlane_cd", ""));
		setCm(JSPUtil.getParameter(request, "cm", ""));
		setN2ndPolCd(JSPUtil.getParameter(request, "n2nd_pol_cd", ""));
		setBkgDelCd(JSPUtil.getParameter(request, "bkg_del_cd", ""));
		setN3rdPolCd(JSPUtil.getParameter(request, "n3rd_pol_cd", ""));
		setLoad(JSPUtil.getParameter(request, "load", ""));
		setN1stRlaneCd(JSPUtil.getParameter(request, "n1st_rlane_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMonthlyAvgUC0057List2VO[]
	 */
	public SearchMonthlyAvgUC0057List2VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMonthlyAvgUC0057List2VO[]
	 */
	public SearchMonthlyAvgUC0057List2VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMonthlyAvgUC0057List2VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] n1stPodCd = (JSPUtil.getParameter(request, prefix	+ "n1st_pod_cd", length));
			String[] bkgPorCd = (JSPUtil.getParameter(request, prefix	+ "bkg_por_cd", length));
			String[] rev = (JSPUtil.getParameter(request, prefix	+ "rev", length));
			String[] op = (JSPUtil.getParameter(request, prefix	+ "op", length));
			String[] tpszCode = (JSPUtil.getParameter(request, prefix	+ "tpsz_code", length));
			String[] n1stPolCd = (JSPUtil.getParameter(request, prefix	+ "n1st_pol_cd", length));
			String[] n2ndRlaneCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_rlane_cd", length));
			String[] n4thRlaneCd = (JSPUtil.getParameter(request, prefix	+ "n4th_rlane_cd", length));
			String[] n2ndPodCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_pod_cd", length));
			String[] n4thPolCd = (JSPUtil.getParameter(request, prefix	+ "n4th_pol_cd", length));
			String[] cmCost = (JSPUtil.getParameter(request, prefix	+ "cm_cost", length));
			String[] n4thPodCd = (JSPUtil.getParameter(request, prefix	+ "n4th_pod_cd", length));
			String[] opCost = (JSPUtil.getParameter(request, prefix	+ "op_cost", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] n3rdPodCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] n3rdRlaneCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_rlane_cd", length));
			String[] cm = (JSPUtil.getParameter(request, prefix	+ "cm", length));
			String[] n2ndPolCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_pol_cd", length));
			String[] bkgDelCd = (JSPUtil.getParameter(request, prefix	+ "bkg_del_cd", length));
			String[] n3rdPolCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_pol_cd", length));
			String[] load = (JSPUtil.getParameter(request, prefix	+ "load", length));
			String[] n1stRlaneCd = (JSPUtil.getParameter(request, prefix	+ "n1st_rlane_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMonthlyAvgUC0057List2VO();
				if (n1stPodCd[i] != null)
					model.setN1stPodCd(n1stPodCd[i]);
				if (bkgPorCd[i] != null)
					model.setBkgPorCd(bkgPorCd[i]);
				if (rev[i] != null)
					model.setRev(rev[i]);
				if (op[i] != null)
					model.setOp(op[i]);
				if (tpszCode[i] != null)
					model.setTpszCode(tpszCode[i]);
				if (n1stPolCd[i] != null)
					model.setN1stPolCd(n1stPolCd[i]);
				if (n2ndRlaneCd[i] != null)
					model.setN2ndRlaneCd(n2ndRlaneCd[i]);
				if (n4thRlaneCd[i] != null)
					model.setN4thRlaneCd(n4thRlaneCd[i]);
				if (n2ndPodCd[i] != null)
					model.setN2ndPodCd(n2ndPodCd[i]);
				if (n4thPolCd[i] != null)
					model.setN4thPolCd(n4thPolCd[i]);
				if (cmCost[i] != null)
					model.setCmCost(cmCost[i]);
				if (n4thPodCd[i] != null)
					model.setN4thPodCd(n4thPodCd[i]);
				if (opCost[i] != null)
					model.setOpCost(opCost[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (n3rdPodCd[i] != null)
					model.setN3rdPodCd(n3rdPodCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (n3rdRlaneCd[i] != null)
					model.setN3rdRlaneCd(n3rdRlaneCd[i]);
				if (cm[i] != null)
					model.setCm(cm[i]);
				if (n2ndPolCd[i] != null)
					model.setN2ndPolCd(n2ndPolCd[i]);
				if (bkgDelCd[i] != null)
					model.setBkgDelCd(bkgDelCd[i]);
				if (n3rdPolCd[i] != null)
					model.setN3rdPolCd(n3rdPolCd[i]);
				if (load[i] != null)
					model.setLoad(load[i]);
				if (n1stRlaneCd[i] != null)
					model.setN1stRlaneCd(n1stRlaneCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMonthlyAvgUC0057List2VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMonthlyAvgUC0057List2VO[]
	 */
	public SearchMonthlyAvgUC0057List2VO[] getSearchMonthlyAvgUC0057List2VOs(){
		SearchMonthlyAvgUC0057List2VO[] vos = (SearchMonthlyAvgUC0057List2VO[])models.toArray(new SearchMonthlyAvgUC0057List2VO[models.size()]);
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
		this.n1stPodCd = this.n1stPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPorCd = this.bkgPorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rev = this.rev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.op = this.op .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszCode = this.tpszCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPolCd = this.n1stPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndRlaneCd = this.n2ndRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thRlaneCd = this.n4thRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndPodCd = this.n2ndPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thPolCd = this.n4thPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmCost = this.cmCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thPodCd = this.n4thPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCost = this.opCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdPodCd = this.n3rdPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdRlaneCd = this.n3rdRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cm = this.cm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndPolCd = this.n2ndPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDelCd = this.bkgDelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdPolCd = this.n3rdPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.load = this.load .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stRlaneCd = this.n1stRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
