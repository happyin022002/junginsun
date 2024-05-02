/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ETCVO.java
*@FileTitle : ETCVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.08.12 한상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo;

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
 * @author 한상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ETCVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ETCVO> models = new ArrayList<ETCVO>();
	
	/* Column Info */
	private String costWk1 = null;
	/* Column Info */
	private String num = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String slsFmDt = null;
	/* Column Info */
	private String costYr = null;
	/* Column Info */
	private String slsToDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ETCVO() {}

	public ETCVO(String ibflag, String pagerows, String num, String costYr, String costWk1, String slsFmDt, String slsToDt) {
		this.costWk1 = costWk1;
		this.num = num;
		this.ibflag = ibflag;
		this.slsFmDt = slsFmDt;
		this.costYr = costYr;
		this.slsToDt = slsToDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cost_wk1", getCostWk1());
		this.hashColumns.put("num", getNum());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sls_fm_dt", getSlsFmDt());
		this.hashColumns.put("cost_yr", getCostYr());
		this.hashColumns.put("sls_to_dt", getSlsToDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cost_wk1", "costWk1");
		this.hashFields.put("num", "num");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sls_fm_dt", "slsFmDt");
		this.hashFields.put("cost_yr", "costYr");
		this.hashFields.put("sls_to_dt", "slsToDt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return costWk1
	 */
	public String getCostWk1() {
		return this.costWk1;
	}
	
	/**
	 * Column Info
	 * @return num
	 */
	public String getNum() {
		return this.num;
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
	 * @return slsFmDt
	 */
	public String getSlsFmDt() {
		return this.slsFmDt;
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
	 * @return slsToDt
	 */
	public String getSlsToDt() {
		return this.slsToDt;
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
	 * @param costWk1
	 */
	public void setCostWk1(String costWk1) {
		this.costWk1 = costWk1;
	}
	
	/**
	 * Column Info
	 * @param num
	 */
	public void setNum(String num) {
		this.num = num;
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
	 * @param slsFmDt
	 */
	public void setSlsFmDt(String slsFmDt) {
		this.slsFmDt = slsFmDt;
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
	 * @param slsToDt
	 */
	public void setSlsToDt(String slsToDt) {
		this.slsToDt = slsToDt;
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
		setCostWk1(JSPUtil.getParameter(request, "cost_wk1", ""));
		setNum(JSPUtil.getParameter(request, "num", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSlsFmDt(JSPUtil.getParameter(request, "sls_fm_dt", ""));
		setCostYr(JSPUtil.getParameter(request, "cost_yr", ""));
		setSlsToDt(JSPUtil.getParameter(request, "sls_to_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ETCVO[]
	 */
	public ETCVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ETCVO[]
	 */
	public ETCVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ETCVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] costWk1 = (JSPUtil.getParameter(request, prefix	+ "cost_wk1", length));
			String[] num = (JSPUtil.getParameter(request, prefix	+ "num", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] slsFmDt = (JSPUtil.getParameter(request, prefix	+ "sls_fm_dt", length));
			String[] costYr = (JSPUtil.getParameter(request, prefix	+ "cost_yr", length));
			String[] slsToDt = (JSPUtil.getParameter(request, prefix	+ "sls_to_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ETCVO();
				if (costWk1[i] != null)
					model.setCostWk1(costWk1[i]);
				if (num[i] != null)
					model.setNum(num[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (slsFmDt[i] != null)
					model.setSlsFmDt(slsFmDt[i]);
				if (costYr[i] != null)
					model.setCostYr(costYr[i]);
				if (slsToDt[i] != null)
					model.setSlsToDt(slsToDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getETCVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ETCVO[]
	 */
	public ETCVO[] getETCVOs(){
		ETCVO[] vos = (ETCVO[])models.toArray(new ETCVO[models.size()]);
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
		this.costWk1 = this.costWk1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.num = this.num .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsFmDt = this.slsFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYr = this.costYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsToDt = this.slsToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
