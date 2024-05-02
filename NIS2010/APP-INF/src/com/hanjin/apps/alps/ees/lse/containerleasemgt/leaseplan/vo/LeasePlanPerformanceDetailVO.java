/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SqlNameVO.java
*@FileTitle : SqlNameVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.05.21 노정용 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo;

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
 * @author 노정용
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class LeasePlanPerformanceDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<LeasePlanPerformanceDetailVO> models = new ArrayList<LeasePlanPerformanceDetailVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String freeDys = null;
	/* Column Info */
	private String onhireLocCd = null;
	/* Column Info */
	private String onhireDt = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String minOnhireDys = null;
	/* Column Info */
	private String usedDys = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String offhireDt = null;
	/* Column Info */
	private String offhireLocCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	/**
	 * 생성자
	 */
	public LeasePlanPerformanceDetailVO() {}

	/**
	 * 생성자
	 */
	public LeasePlanPerformanceDetailVO(String ibflag, String pagerows, String cntrNo, String cntrTpszCd, String lstmCd, String onhireDt, String onhireLocCd, String offhireDt, String offhireLocCd, String usedDys, String freeDys, String minOnhireDys) {
		this.ibflag = ibflag;
		this.freeDys = freeDys;
		this.onhireLocCd = onhireLocCd;
		this.onhireDt = onhireDt;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.minOnhireDys = minOnhireDys;
		this.usedDys = usedDys;
		this.lstmCd = lstmCd;
		this.offhireDt = offhireDt;
		this.offhireLocCd = offhireLocCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("free_dys", getFreeDys());
		this.hashColumns.put("onhire_loc_cd", getOnhireLocCd());
		this.hashColumns.put("onhire_dt", getOnhireDt());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("min_onhire_dys", getMinOnhireDys());
		this.hashColumns.put("used_dys", getUsedDys());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("offhire_dt", getOffhireDt());
		this.hashColumns.put("offhire_loc_cd", getOffhireLocCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("free_dys", "freeDys");
		this.hashFields.put("onhire_loc_cd", "onhireLocCd");
		this.hashFields.put("onhire_dt", "onhireDt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("min_onhire_dys", "minOnhireDys");
		this.hashFields.put("used_dys", "usedDys");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("offhire_dt", "offhireDt");
		this.hashFields.put("offhire_loc_cd", "offhireLocCd");
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
	 * @return freeDys
	 */
	public String getFreeDys() {
		return this.freeDys;
	}
	
	/**
	 * Column Info
	 * @return onhireLocCd
	 */
	public String getOnhireLocCd() {
		return this.onhireLocCd;
	}
	
	/**
	 * Column Info
	 * @return onhireDt
	 */
	public String getOnhireDt() {
		return this.onhireDt;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
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
	 * @return minOnhireDys
	 */
	public String getMinOnhireDys() {
		return this.minOnhireDys;
	}
	
	/**
	 * Column Info
	 * @return usedDys
	 */
	public String getUsedDys() {
		return this.usedDys;
	}
	
	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
	}
	
	/**
	 * Column Info
	 * @return offhireDt
	 */
	public String getOffhireDt() {
		return this.offhireDt;
	}
	
	/**
	 * Column Info
	 * @return offhireLocCd
	 */
	public String getOffhireLocCd() {
		return this.offhireLocCd;
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
	 * @param freeDys
	 */
	public void setFreeDys(String freeDys) {
		this.freeDys = freeDys;
	}
	
	/**
	 * Column Info
	 * @param onhireLocCd
	 */
	public void setOnhireLocCd(String onhireLocCd) {
		this.onhireLocCd = onhireLocCd;
	}
	
	/**
	 * Column Info
	 * @param onhireDt
	 */
	public void setOnhireDt(String onhireDt) {
		this.onhireDt = onhireDt;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
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
	 * @param minOnhireDys
	 */
	public void setMinOnhireDys(String minOnhireDys) {
		this.minOnhireDys = minOnhireDys;
	}
	
	/**
	 * Column Info
	 * @param usedDys
	 */
	public void setUsedDys(String usedDys) {
		this.usedDys = usedDys;
	}
	
	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}
	
	/**
	 * Column Info
	 * @param offhireDt
	 */
	public void setOffhireDt(String offhireDt) {
		this.offhireDt = offhireDt;
	}
	
	/**
	 * Column Info
	 * @param offhireLocCd
	 */
	public void setOffhireLocCd(String offhireLocCd) {
		this.offhireLocCd = offhireLocCd;
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
		setFreeDys(JSPUtil.getParameter(request, "free_dys", ""));
		setOnhireLocCd(JSPUtil.getParameter(request, "onhire_loc_cd", ""));
		setOnhireDt(JSPUtil.getParameter(request, "onhire_dt", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setMinOnhireDys(JSPUtil.getParameter(request, "min_onhire_dys", ""));
		setUsedDys(JSPUtil.getParameter(request, "used_dys", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setOffhireDt(JSPUtil.getParameter(request, "offhire_dt", ""));
		setOffhireLocCd(JSPUtil.getParameter(request, "offhire_loc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SqlNameVO[]
	 */
	public LeasePlanPerformanceDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SqlNameVO[]
	 */
	public LeasePlanPerformanceDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		LeasePlanPerformanceDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] freeDys = (JSPUtil.getParameter(request, prefix	+ "free_dys".trim(), length));
			String[] onhireLocCd = (JSPUtil.getParameter(request, prefix	+ "onhire_loc_cd".trim(), length));
			String[] onhireDt = (JSPUtil.getParameter(request, prefix	+ "onhire_dt".trim(), length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no".trim(), length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd".trim(), length));
			String[] minOnhireDys = (JSPUtil.getParameter(request, prefix	+ "min_onhire_dys".trim(), length));
			String[] usedDys = (JSPUtil.getParameter(request, prefix	+ "used_dys".trim(), length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd".trim(), length));
			String[] offhireDt = (JSPUtil.getParameter(request, prefix	+ "offhire_dt".trim(), length));
			String[] offhireLocCd = (JSPUtil.getParameter(request, prefix	+ "offhire_loc_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new LeasePlanPerformanceDetailVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (freeDys[i] != null)
					model.setFreeDys(freeDys[i]);
				if (onhireLocCd[i] != null)
					model.setOnhireLocCd(onhireLocCd[i]);
				if (onhireDt[i] != null)
					model.setOnhireDt(onhireDt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (minOnhireDys[i] != null)
					model.setMinOnhireDys(minOnhireDys[i]);
				if (usedDys[i] != null)
					model.setUsedDys(usedDys[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (offhireDt[i] != null)
					model.setOffhireDt(offhireDt[i]);
				if (offhireLocCd[i] != null)
					model.setOffhireLocCd(offhireLocCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSqlNameVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SqlNameVO[]
	 */
	public LeasePlanPerformanceDetailVO[] getSqlNameVOs(){
		LeasePlanPerformanceDetailVO[] vos = (LeasePlanPerformanceDetailVO[])models.toArray(new LeasePlanPerformanceDetailVO[models.size()]);
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
		this.freeDys = this.freeDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhireLocCd = this.onhireLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhireDt = this.onhireDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minOnhireDys = this.minOnhireDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usedDys = this.usedDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhireDt = this.offhireDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhireLocCd = this.offhireLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
