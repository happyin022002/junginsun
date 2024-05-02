/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchCntrRepoInOutPlanVVDVO.java
*@FileTitle : SearchCntrRepoInOutPlanVVDVO
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	Lee Byoung Hun	2009.08.26		1.0 최초 생성
*
*@LastModifyDate : 2009.08.26
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.08.26  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo;

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

public class SearchCntrRepoInOutPlanVVDVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCntrRepoInOutPlanVVDVO> models = new ArrayList<SearchCntrRepoInOutPlanVVDVO>();
	
	/* Column Info */
	private String rownum = null;
	/* Column Info */
	private String vslEtbDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslEtdDt = null;
	/* Column Info */
	private String vslLocCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchCntrRepoInOutPlanVVDVO() {}

	public SearchCntrRepoInOutPlanVVDVO(String ibflag, String pagerows, String vslLocCd, String vslEtdDt, String vslEtbDt, String rownum) {
		this.rownum = rownum;
		this.vslEtbDt = vslEtbDt;
		this.ibflag = ibflag;
		this.vslEtdDt = vslEtdDt;
		this.vslLocCd = vslLocCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rownum", getRownum());
		this.hashColumns.put("vsl_etb_dt", getVslEtbDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_etd_dt", getVslEtdDt());
		this.hashColumns.put("vsl_loc_cd", getVslLocCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rownum", "rownum");
		this.hashFields.put("vsl_etb_dt", "vslEtbDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_etd_dt", "vslEtdDt");
		this.hashFields.put("vsl_loc_cd", "vslLocCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rownum
	 */
	public String getRownum() {
		return this.rownum;
	}
	
	/**
	 * Column Info
	 * @return vslEtbDt
	 */
	public String getVslEtbDt() {
		return this.vslEtbDt;
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
	 * @return vslEtdDt
	 */
	public String getVslEtdDt() {
		return this.vslEtdDt;
	}
	
	/**
	 * Column Info
	 * @return vslLocCd
	 */
	public String getVslLocCd() {
		return this.vslLocCd;
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
	 * @param rownum
	 */
	public void setRownum(String rownum) {
		this.rownum = rownum;
	}
	
	/**
	 * Column Info
	 * @param vslEtbDt
	 */
	public void setVslEtbDt(String vslEtbDt) {
		this.vslEtbDt = vslEtbDt;
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
	 * @param vslEtdDt
	 */
	public void setVslEtdDt(String vslEtdDt) {
		this.vslEtdDt = vslEtdDt;
	}
	
	/**
	 * Column Info
	 * @param vslLocCd
	 */
	public void setVslLocCd(String vslLocCd) {
		this.vslLocCd = vslLocCd;
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
		setRownum(JSPUtil.getParameter(request, "rownum", ""));
		setVslEtbDt(JSPUtil.getParameter(request, "vsl_etb_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVslEtdDt(JSPUtil.getParameter(request, "vsl_etd_dt", ""));
		setVslLocCd(JSPUtil.getParameter(request, "vsl_loc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCntrRepoInOutPlanVVDVO[]
	 */
	public SearchCntrRepoInOutPlanVVDVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCntrRepoInOutPlanVVDVO[]
	 */
	public SearchCntrRepoInOutPlanVVDVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCntrRepoInOutPlanVVDVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rownum = (JSPUtil.getParameter(request, prefix	+ "rownum", length));
			String[] vslEtbDt = (JSPUtil.getParameter(request, prefix	+ "vsl_etb_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslEtdDt = (JSPUtil.getParameter(request, prefix	+ "vsl_etd_dt", length));
			String[] vslLocCd = (JSPUtil.getParameter(request, prefix	+ "vsl_loc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCntrRepoInOutPlanVVDVO();
				if (rownum[i] != null)
					model.setRownum(rownum[i]);
				if (vslEtbDt[i] != null)
					model.setVslEtbDt(vslEtbDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslEtdDt[i] != null)
					model.setVslEtdDt(vslEtdDt[i]);
				if (vslLocCd[i] != null)
					model.setVslLocCd(vslLocCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCntrRepoInOutPlanVVDVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCntrRepoInOutPlanVVDVO[]
	 */
	public SearchCntrRepoInOutPlanVVDVO[] getSearchCntrRepoInOutPlanVVDVOs(){
		SearchCntrRepoInOutPlanVVDVO[] vos = (SearchCntrRepoInOutPlanVVDVO[])models.toArray(new SearchCntrRepoInOutPlanVVDVO[models.size()]);
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
		this.rownum = this.rownum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEtbDt = this.vslEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEtdDt = this.vslEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLocCd = this.vslLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
