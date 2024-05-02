/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchLogisticsRPT0080ListVO.java
*@FileTitle : SearchLogisticsRPT0080ListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.16  
* 1.0 Creation
*  2010.02.04 임옥영 :품질검토결과 반영
=========================================================*/

package com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchLogisticsRPT0080ListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchLogisticsRPT0080ListVO> models = new ArrayList<SearchLogisticsRPT0080ListVO>();
	
	/* Column Info */
	private String unitTtl = null;
	/* Column Info */
	private String trAmt = null;
	/* Column Info */
	private String voidVol = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String totalAmt = null;
	/* Column Info */
	private String unitTr = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pReport = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String unitTm = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String tmAmt = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String costYrmonwk = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String load = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	/**
	  * ESM_COA_0080 화면용 VO 생성자
	  */
	public SearchLogisticsRPT0080ListVO() {}
	
	/**
	  * ESM_COA_0080 화면용 VO 생성자
	  */
	public SearchLogisticsRPT0080ListVO(String ibflag, String pagerows, String pReport, String costYrmonwk, String costYrmon, String costWk, String trdCd, String rlaneCd, String dirCd, String load, String voidVol, String tmAmt, String trAmt, String totalAmt, String unitTm, String unitTr, String unitTtl) {
		this.unitTtl = unitTtl;
		this.trAmt = trAmt;
		this.voidVol = voidVol;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.totalAmt = totalAmt;
		this.unitTr = unitTr;
		this.pagerows = pagerows;
		this.pReport = pReport;
		this.ibflag = ibflag;
		this.unitTm = unitTm;
		this.costYrmon = costYrmon;
		this.tmAmt = tmAmt;
		this.costWk = costWk;
		this.costYrmonwk = costYrmonwk;
		this.dirCd = dirCd;
		this.load = load;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("unit_ttl", getUnitTtl());
		this.hashColumns.put("tr_amt", getTrAmt());
		this.hashColumns.put("void_vol", getVoidVol());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("total_amt", getTotalAmt());
		this.hashColumns.put("unit_tr", getUnitTr());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("p_report", getPReport());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("unit_tm", getUnitTm());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("tm_amt", getTmAmt());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("cost_yrmonwk", getCostYrmonwk());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("load", getLoad());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("unit_ttl", "unitTtl");
		this.hashFields.put("tr_amt", "trAmt");
		this.hashFields.put("void_vol", "voidVol");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("total_amt", "totalAmt");
		this.hashFields.put("unit_tr", "unitTr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("p_report", "pReport");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("unit_tm", "unitTm");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("tm_amt", "tmAmt");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("cost_yrmonwk", "costYrmonwk");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("load", "load");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return unitTtl
	 */
	public String getUnitTtl() {
		return this.unitTtl;
	}
	
	/**
	 * Column Info
	 * @return trAmt
	 */
	public String getTrAmt() {
		return this.trAmt;
	}
	
	/**
	 * Column Info
	 * @return voidVol
	 */
	public String getVoidVol() {
		return this.voidVol;
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
	 * @return totalAmt
	 */
	public String getTotalAmt() {
		return this.totalAmt;
	}
	
	/**
	 * Column Info
	 * @return unitTr
	 */
	public String getUnitTr() {
		return this.unitTr;
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
	 * @return pReport
	 */
	public String getPReport() {
		return this.pReport;
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
	 * @return unitTm
	 */
	public String getUnitTm() {
		return this.unitTm;
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
	 * @return tmAmt
	 */
	public String getTmAmt() {
		return this.tmAmt;
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
	 * @return costYrmonwk
	 */
	public String getCostYrmonwk() {
		return this.costYrmonwk;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
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
	 * @param unitTtl
	 */
	public void setUnitTtl(String unitTtl) {
		this.unitTtl = unitTtl;
	}
	
	/**
	 * Column Info
	 * @param trAmt
	 */
	public void setTrAmt(String trAmt) {
		this.trAmt = trAmt;
	}
	
	/**
	 * Column Info
	 * @param voidVol
	 */
	public void setVoidVol(String voidVol) {
		this.voidVol = voidVol;
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
	 * @param totalAmt
	 */
	public void setTotalAmt(String totalAmt) {
		this.totalAmt = totalAmt;
	}
	
	/**
	 * Column Info
	 * @param unitTr
	 */
	public void setUnitTr(String unitTr) {
		this.unitTr = unitTr;
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
	 * @param pReport
	 */
	public void setPReport(String pReport) {
		this.pReport = pReport;
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
	 * @param unitTm
	 */
	public void setUnitTm(String unitTm) {
		this.unitTm = unitTm;
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
	 * @param tmAmt
	 */
	public void setTmAmt(String tmAmt) {
		this.tmAmt = tmAmt;
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
	 * @param costYrmonwk
	 */
	public void setCostYrmonwk(String costYrmonwk) {
		this.costYrmonwk = costYrmonwk;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param load
	 */
	public void setLoad(String load) {
		this.load = load;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUnitTtl(JSPUtil.getParameter(request, "unit_ttl", ""));
		setTrAmt(JSPUtil.getParameter(request, "tr_amt", ""));
		setVoidVol(JSPUtil.getParameter(request, "void_vol", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setTotalAmt(JSPUtil.getParameter(request, "total_amt", ""));
		setUnitTr(JSPUtil.getParameter(request, "unit_tr", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPReport(JSPUtil.getParameter(request, "p_report", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUnitTm(JSPUtil.getParameter(request, "unit_tm", ""));
		setCostYrmon(JSPUtil.getParameter(request, "cost_yrmon", ""));
		setTmAmt(JSPUtil.getParameter(request, "tm_amt", ""));
		setCostWk(JSPUtil.getParameter(request, "cost_wk", ""));
		setCostYrmonwk(JSPUtil.getParameter(request, "cost_yrmonwk", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setLoad(JSPUtil.getParameter(request, "load", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchLogisticsRPT0080ListVO[]
	 */
	public SearchLogisticsRPT0080ListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchLogisticsRPT0080ListVO[]
	 */
	public SearchLogisticsRPT0080ListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchLogisticsRPT0080ListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] unitTtl = (JSPUtil.getParameter(request, prefix	+ "unit_ttl", length));
			String[] trAmt = (JSPUtil.getParameter(request, prefix	+ "tr_amt", length));
			String[] voidVol = (JSPUtil.getParameter(request, prefix	+ "void_vol", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] totalAmt = (JSPUtil.getParameter(request, prefix	+ "total_amt", length));
			String[] unitTr = (JSPUtil.getParameter(request, prefix	+ "unit_tr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pReport = (JSPUtil.getParameter(request, prefix	+ "p_report", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] unitTm = (JSPUtil.getParameter(request, prefix	+ "unit_tm", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] tmAmt = (JSPUtil.getParameter(request, prefix	+ "tm_amt", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] costYrmonwk = (JSPUtil.getParameter(request, prefix	+ "cost_yrmonwk", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] load = (JSPUtil.getParameter(request, prefix	+ "load", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchLogisticsRPT0080ListVO();
				if (unitTtl[i] != null)
					model.setUnitTtl(unitTtl[i]);
				if (trAmt[i] != null)
					model.setTrAmt(trAmt[i]);
				if (voidVol[i] != null)
					model.setVoidVol(voidVol[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (totalAmt[i] != null)
					model.setTotalAmt(totalAmt[i]);
				if (unitTr[i] != null)
					model.setUnitTr(unitTr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pReport[i] != null)
					model.setPReport(pReport[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (unitTm[i] != null)
					model.setUnitTm(unitTm[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (tmAmt[i] != null)
					model.setTmAmt(tmAmt[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (costYrmonwk[i] != null)
					model.setCostYrmonwk(costYrmonwk[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (load[i] != null)
					model.setLoad(load[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchLogisticsRPT0080ListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchLogisticsRPT0080ListVO[]
	 */
	public SearchLogisticsRPT0080ListVO[] getSearchLogisticsRPT0080ListVOs(){
		SearchLogisticsRPT0080ListVO[] vos = (SearchLogisticsRPT0080ListVO[])models.toArray(new SearchLogisticsRPT0080ListVO[models.size()]);
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
		this.unitTtl = this.unitTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trAmt = this.trAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voidVol = this.voidVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalAmt = this.totalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unitTr = this.unitTr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pReport = this.pReport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unitTm = this.unitTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmAmt = this.tmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmonwk = this.costYrmonwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.load = this.load .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
