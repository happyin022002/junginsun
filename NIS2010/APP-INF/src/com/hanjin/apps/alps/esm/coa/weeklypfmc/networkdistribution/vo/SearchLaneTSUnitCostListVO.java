/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchLaneTSUnitCostListVO.java
*@FileTitle : SearchLaneTSUnitCostListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.10.15 김기대 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo;

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
 * @author 김기대
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchLaneTSUnitCostListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchLaneTSUnitCostListVO> models = new ArrayList<SearchLaneTSUnitCostListVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fmSkdDirCd = null;
	/* Column Info */
	private String costYr = null;
	/* Column Info */
	private String fmRlaneCd = null;
	/* Column Info */
	private String fmIocCd = null;
	/* Column Info */
	private String tsUcAmt = null;
	/* Column Info */
	private String fmTrdCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchLaneTSUnitCostListVO() {}

	public SearchLaneTSUnitCostListVO(String ibflag, String pagerows, String costYr, String fmTrdCd, String fmRlaneCd, String fmIocCd, String fmSkdDirCd, String tsUcAmt) {
		this.ibflag = ibflag;
		this.fmSkdDirCd = fmSkdDirCd;
		this.costYr = costYr;
		this.fmRlaneCd = fmRlaneCd;
		this.fmIocCd = fmIocCd;
		this.tsUcAmt = tsUcAmt;
		this.fmTrdCd = fmTrdCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fm_skd_dir_cd", getFmSkdDirCd());
		this.hashColumns.put("cost_yr", getCostYr());
		this.hashColumns.put("fm_rlane_cd", getFmRlaneCd());
		this.hashColumns.put("fm_ioc_cd", getFmIocCd());
		this.hashColumns.put("ts_uc_amt", getTsUcAmt());
		this.hashColumns.put("fm_trd_cd", getFmTrdCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fm_skd_dir_cd", "fmSkdDirCd");
		this.hashFields.put("cost_yr", "costYr");
		this.hashFields.put("fm_rlane_cd", "fmRlaneCd");
		this.hashFields.put("fm_ioc_cd", "fmIocCd");
		this.hashFields.put("ts_uc_amt", "tsUcAmt");
		this.hashFields.put("fm_trd_cd", "fmTrdCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return fmSkdDirCd
	 */
	public String getFmSkdDirCd() {
		return this.fmSkdDirCd;
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
	 * @return fmRlaneCd
	 */
	public String getFmRlaneCd() {
		return this.fmRlaneCd;
	}
	
	/**
	 * Column Info
	 * @return fmIocCd
	 */
	public String getFmIocCd() {
		return this.fmIocCd;
	}
	
	/**
	 * Column Info
	 * @return tsUcAmt
	 */
	public String getTsUcAmt() {
		return this.tsUcAmt;
	}
	
	/**
	 * Column Info
	 * @return fmTrdCd
	 */
	public String getFmTrdCd() {
		return this.fmTrdCd;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param fmSkdDirCd
	 */
	public void setFmSkdDirCd(String fmSkdDirCd) {
		this.fmSkdDirCd = fmSkdDirCd;
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
	 * @param fmRlaneCd
	 */
	public void setFmRlaneCd(String fmRlaneCd) {
		this.fmRlaneCd = fmRlaneCd;
	}
	
	/**
	 * Column Info
	 * @param fmIocCd
	 */
	public void setFmIocCd(String fmIocCd) {
		this.fmIocCd = fmIocCd;
	}
	
	/**
	 * Column Info
	 * @param tsUcAmt
	 */
	public void setTsUcAmt(String tsUcAmt) {
		this.tsUcAmt = tsUcAmt;
	}
	
	/**
	 * Column Info
	 * @param fmTrdCd
	 */
	public void setFmTrdCd(String fmTrdCd) {
		this.fmTrdCd = fmTrdCd;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFmSkdDirCd(JSPUtil.getParameter(request, "fm_skd_dir_cd", ""));
		setCostYr(JSPUtil.getParameter(request, "cost_yr", ""));
		setFmRlaneCd(JSPUtil.getParameter(request, "fm_rlane_cd", ""));
		setFmIocCd(JSPUtil.getParameter(request, "fm_ioc_cd", ""));
		setTsUcAmt(JSPUtil.getParameter(request, "ts_uc_amt", ""));
		setFmTrdCd(JSPUtil.getParameter(request, "fm_trd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchLaneTSUnitCostListVO[]
	 */
	public SearchLaneTSUnitCostListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchLaneTSUnitCostListVO[]
	 */
	public SearchLaneTSUnitCostListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchLaneTSUnitCostListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fmSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "fm_skd_dir_cd", length));
			String[] costYr = (JSPUtil.getParameter(request, prefix	+ "cost_yr", length));
			String[] fmRlaneCd = (JSPUtil.getParameter(request, prefix	+ "fm_rlane_cd", length));
			String[] fmIocCd = (JSPUtil.getParameter(request, prefix	+ "fm_ioc_cd", length));
			String[] tsUcAmt = (JSPUtil.getParameter(request, prefix	+ "ts_uc_amt", length));
			String[] fmTrdCd = (JSPUtil.getParameter(request, prefix	+ "fm_trd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchLaneTSUnitCostListVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fmSkdDirCd[i] != null)
					model.setFmSkdDirCd(fmSkdDirCd[i]);
				if (costYr[i] != null)
					model.setCostYr(costYr[i]);
				if (fmRlaneCd[i] != null)
					model.setFmRlaneCd(fmRlaneCd[i]);
				if (fmIocCd[i] != null)
					model.setFmIocCd(fmIocCd[i]);
				if (tsUcAmt[i] != null)
					model.setTsUcAmt(tsUcAmt[i]);
				if (fmTrdCd[i] != null)
					model.setFmTrdCd(fmTrdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchLaneTSUnitCostListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchLaneTSUnitCostListVO[]
	 */
	public SearchLaneTSUnitCostListVO[] getSearchLaneTSUnitCostListVOs(){
		SearchLaneTSUnitCostListVO[] vos = (SearchLaneTSUnitCostListVO[])models.toArray(new SearchLaneTSUnitCostListVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmSkdDirCd = this.fmSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYr = this.costYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmRlaneCd = this.fmRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmIocCd = this.fmIocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsUcAmt = this.tsUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmTrdCd = this.fmTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
