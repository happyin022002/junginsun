/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchMTCostListVO14.java
*@FileTitle : SearchMTCostListVO14
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 박수훈
*@LastVersion : 1.0
* 2009.08.24 박수훈 
* 1.0 Creation
* 2010.02.05 임옥영 품질검토 결과 반영 - 생성자 주석 추가
=========================================================*/

package com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo;

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
 * @author 박수훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMTCostListVO14 extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMTCostListVO14> models = new ArrayList<SearchMTCostListVO14>();
	
	/* Column Info */
	private String fcntrEccCd = null;
	/* Column Info */
	private String eqStatus = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String cntrImbalRto = null;
	/* Column Info */
	private String cntrIbQty = null;
	/* Column Info */
	private String cntrObQty = null;
	/* Column Info */
	private String cntrImbalQty = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	 * SearchMTCostListVO14 생성자
	 */
	public SearchMTCostListVO14() {}

	/**
	 * SearchMTCostListVO14 생성자
	 * 
	 * @param String ibflag
	 * @param String pagerows
	 * @param String costYrmon
	 * @param String fcntrEccCd
	 * @param String cntrTpszCd
	 * @param String eqStatus
	 * @param String cntrImbalRto
	 * @param String cntrImbalQty
	 * @param String cntrIbQty
	 * @param String cntrObQty
	 */
	public SearchMTCostListVO14(String ibflag, String pagerows, String costYrmon, String fcntrEccCd, String cntrTpszCd, String eqStatus, String cntrImbalRto, String cntrImbalQty, String cntrIbQty, String cntrObQty) {
		this.fcntrEccCd = fcntrEccCd;
		this.eqStatus = eqStatus;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.cntrTpszCd = cntrTpszCd;
		this.cntrImbalRto = cntrImbalRto;
		this.cntrIbQty = cntrIbQty;
		this.cntrObQty = cntrObQty;
		this.cntrImbalQty = cntrImbalQty;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fcntr_ecc_cd", getFcntrEccCd());
		this.hashColumns.put("eq_status", getEqStatus());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cntr_imbal_rto", getCntrImbalRto());
		this.hashColumns.put("cntr_ib_qty", getCntrIbQty());
		this.hashColumns.put("cntr_ob_qty", getCntrObQty());
		this.hashColumns.put("cntr_imbal_qty", getCntrImbalQty());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fcntr_ecc_cd", "fcntrEccCd");
		this.hashFields.put("eq_status", "eqStatus");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cntr_imbal_rto", "cntrImbalRto");
		this.hashFields.put("cntr_ib_qty", "cntrIbQty");
		this.hashFields.put("cntr_ob_qty", "cntrObQty");
		this.hashFields.put("cntr_imbal_qty", "cntrImbalQty");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fcntrEccCd
	 */
	public String getFcntrEccCd() {
		return this.fcntrEccCd;
	}
	
	/**
	 * Column Info
	 * @return eqStatus
	 */
	public String getEqStatus() {
		return this.eqStatus;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return cntrImbalRto
	 */
	public String getCntrImbalRto() {
		return this.cntrImbalRto;
	}
	
	/**
	 * Column Info
	 * @return cntrIbQty
	 */
	public String getCntrIbQty() {
		return this.cntrIbQty;
	}
	
	/**
	 * Column Info
	 * @return cntrObQty
	 */
	public String getCntrObQty() {
		return this.cntrObQty;
	}
	
	/**
	 * Column Info
	 * @return cntrImbalQty
	 */
	public String getCntrImbalQty() {
		return this.cntrImbalQty;
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
	 * @param fcntrEccCd
	 */
	public void setFcntrEccCd(String fcntrEccCd) {
		this.fcntrEccCd = fcntrEccCd;
	}
	
	/**
	 * Column Info
	 * @param eqStatus
	 */
	public void setEqStatus(String eqStatus) {
		this.eqStatus = eqStatus;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param cntrImbalRto
	 */
	public void setCntrImbalRto(String cntrImbalRto) {
		this.cntrImbalRto = cntrImbalRto;
	}
	
	/**
	 * Column Info
	 * @param cntrIbQty
	 */
	public void setCntrIbQty(String cntrIbQty) {
		this.cntrIbQty = cntrIbQty;
	}
	
	/**
	 * Column Info
	 * @param cntrObQty
	 */
	public void setCntrObQty(String cntrObQty) {
		this.cntrObQty = cntrObQty;
	}
	
	/**
	 * Column Info
	 * @param cntrImbalQty
	 */
	public void setCntrImbalQty(String cntrImbalQty) {
		this.cntrImbalQty = cntrImbalQty;
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
		setFcntrEccCd(JSPUtil.getParameter(request, "fcntr_ecc_cd", ""));
		setEqStatus(JSPUtil.getParameter(request, "eq_status", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, "cost_yrmon", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setCntrImbalRto(JSPUtil.getParameter(request, "cntr_imbal_rto", ""));
		setCntrIbQty(JSPUtil.getParameter(request, "cntr_ib_qty", ""));
		setCntrObQty(JSPUtil.getParameter(request, "cntr_ob_qty", ""));
		setCntrImbalQty(JSPUtil.getParameter(request, "cntr_imbal_qty", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMTCostListVO14[]
	 */
	public SearchMTCostListVO14[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMTCostListVO14[]
	 */
	public SearchMTCostListVO14[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMTCostListVO14 model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] s_fcntrEccCd = (JSPUtil.getParameter(request, prefix	+ "fcntr_ecc_cd", length));
			String[] s_eqStatus = (JSPUtil.getParameter(request, prefix	+ "eq_status", length));
			String[] s_ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] s_costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] s_cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] s_cntrImbalRto = (JSPUtil.getParameter(request, prefix	+ "cntr_imbal_rto", length));
			String[] s_cntrIbQty = (JSPUtil.getParameter(request, prefix	+ "cntr_ib_qty", length));
			String[] s_cntrObQty = (JSPUtil.getParameter(request, prefix	+ "cntr_ob_qty", length));
			String[] s_cntrImbalQty = (JSPUtil.getParameter(request, prefix	+ "cntr_imbal_qty", length));
			String[] s_pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMTCostListVO14();
				if (s_fcntrEccCd[i] != null)
					model.setFcntrEccCd(s_fcntrEccCd[i]);
				if (s_eqStatus[i] != null)
					model.setEqStatus(s_eqStatus[i]);
				if (s_ibflag[i] != null)
					model.setIbflag(s_ibflag[i]);
				if (s_costYrmon[i] != null)
					model.setCostYrmon(s_costYrmon[i]);
				if (s_cntrTpszCd[i] != null)
					model.setCntrTpszCd(s_cntrTpszCd[i]);
				if (s_cntrImbalRto[i] != null)
					model.setCntrImbalRto(s_cntrImbalRto[i]);
				if (s_cntrIbQty[i] != null)
					model.setCntrIbQty(s_cntrIbQty[i]);
				if (s_cntrObQty[i] != null)
					model.setCntrObQty(s_cntrObQty[i]);
				if (s_cntrImbalQty[i] != null)
					model.setCntrImbalQty(s_cntrImbalQty[i]);
				if (s_pagerows[i] != null)
					model.setPagerows(s_pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMTCostListVO14s();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMTCostListVO14[]
	 */
	public SearchMTCostListVO14[] getSearchMTCostListVO14s(){
		SearchMTCostListVO14[] vos = (SearchMTCostListVO14[])models.toArray(new SearchMTCostListVO14[models.size()]);
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
		this.fcntrEccCd = this.fcntrEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqStatus = this.eqStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrImbalRto = this.cntrImbalRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrIbQty = this.cntrIbQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrObQty = this.cntrObQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrImbalQty = this.cntrImbalQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
