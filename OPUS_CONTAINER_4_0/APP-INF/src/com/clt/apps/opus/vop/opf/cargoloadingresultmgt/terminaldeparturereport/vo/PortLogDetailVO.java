/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortLogDetailVO.java
*@FileTitle : PortLogDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.16  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo;

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

public class PortLogDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PortLogDetailVO> models = new ArrayList<PortLogDetailVO>();
	
	/* Column Info */
	private String work = null;
	/* Column Info */
	private String total = null;
	/* Column Info */
	private String workComm = null;
	/* Column Info */
	private String craneNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String other = null;
	/* Column Info */
	private String breakDown = null;
	/* Column Info */
	private String workComp = null;
	/* Column Info */
	private String weather = null;
	/* Column Info */
	private String meal = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PortLogDetailVO() {}

	public PortLogDetailVO(String ibflag, String pagerows, String craneNo, String workComm, String workComp, String breakDown, String meal, String weather, String other, String total, String work) {
		this.work = work;
		this.total = total;
		this.workComm = workComm;
		this.craneNo = craneNo;
		this.ibflag = ibflag;
		this.other = other;
		this.breakDown = breakDown;
		this.workComp = workComp;
		this.weather = weather;
		this.meal = meal;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("work", getWork());
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("work_comm", getWorkComm());
		this.hashColumns.put("crane_no", getCraneNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("other", getOther());
		this.hashColumns.put("break_down", getBreakDown());
		this.hashColumns.put("work_comp", getWorkComp());
		this.hashColumns.put("weather", getWeather());
		this.hashColumns.put("meal", getMeal());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("work", "work");
		this.hashFields.put("total", "total");
		this.hashFields.put("work_comm", "workComm");
		this.hashFields.put("crane_no", "craneNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("other", "other");
		this.hashFields.put("break_down", "breakDown");
		this.hashFields.put("work_comp", "workComp");
		this.hashFields.put("weather", "weather");
		this.hashFields.put("meal", "meal");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return work
	 */
	public String getWork() {
		return this.work;
	}
	
	/**
	 * Column Info
	 * @return total
	 */
	public String getTotal() {
		return this.total;
	}
	
	/**
	 * Column Info
	 * @return workComm
	 */
	public String getWorkComm() {
		return this.workComm;
	}
	
	/**
	 * Column Info
	 * @return craneNo
	 */
	public String getCraneNo() {
		return this.craneNo;
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
	 * @return other
	 */
	public String getOther() {
		return this.other;
	}
	
	/**
	 * Column Info
	 * @return breakDown
	 */
	public String getBreakDown() {
		return this.breakDown;
	}
	
	/**
	 * Column Info
	 * @return workComp
	 */
	public String getWorkComp() {
		return this.workComp;
	}
	
	/**
	 * Column Info
	 * @return weather
	 */
	public String getWeather() {
		return this.weather;
	}
	
	/**
	 * Column Info
	 * @return meal
	 */
	public String getMeal() {
		return this.meal;
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
	 * @param work
	 */
	public void setWork(String work) {
		this.work = work;
	}
	
	/**
	 * Column Info
	 * @param total
	 */
	public void setTotal(String total) {
		this.total = total;
	}
	
	/**
	 * Column Info
	 * @param workComm
	 */
	public void setWorkComm(String workComm) {
		this.workComm = workComm;
	}
	
	/**
	 * Column Info
	 * @param craneNo
	 */
	public void setCraneNo(String craneNo) {
		this.craneNo = craneNo;
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
	 * @param other
	 */
	public void setOther(String other) {
		this.other = other;
	}
	
	/**
	 * Column Info
	 * @param breakDown
	 */
	public void setBreakDown(String breakDown) {
		this.breakDown = breakDown;
	}
	
	/**
	 * Column Info
	 * @param workComp
	 */
	public void setWorkComp(String workComp) {
		this.workComp = workComp;
	}
	
	/**
	 * Column Info
	 * @param weather
	 */
	public void setWeather(String weather) {
		this.weather = weather;
	}
	
	/**
	 * Column Info
	 * @param meal
	 */
	public void setMeal(String meal) {
		this.meal = meal;
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
		setWork(JSPUtil.getParameter(request, "work", ""));
		setTotal(JSPUtil.getParameter(request, "total", ""));
		setWorkComm(JSPUtil.getParameter(request, "work_comm", ""));
		setCraneNo(JSPUtil.getParameter(request, "crane_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOther(JSPUtil.getParameter(request, "other", ""));
		setBreakDown(JSPUtil.getParameter(request, "break_down", ""));
		setWorkComp(JSPUtil.getParameter(request, "work_comp", ""));
		setWeather(JSPUtil.getParameter(request, "weather", ""));
		setMeal(JSPUtil.getParameter(request, "meal", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PortLogDetailVO[]
	 */
	public PortLogDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PortLogDetailVO[]
	 */
	public PortLogDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PortLogDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] work = (JSPUtil.getParameter(request, prefix	+ "work", length));
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] workComm = (JSPUtil.getParameter(request, prefix	+ "work_comm", length));
			String[] craneNo = (JSPUtil.getParameter(request, prefix	+ "crane_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] other = (JSPUtil.getParameter(request, prefix	+ "other", length));
			String[] breakDown = (JSPUtil.getParameter(request, prefix	+ "break_down", length));
			String[] workComp = (JSPUtil.getParameter(request, prefix	+ "work_comp", length));
			String[] weather = (JSPUtil.getParameter(request, prefix	+ "weather", length));
			String[] meal = (JSPUtil.getParameter(request, prefix	+ "meal", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new PortLogDetailVO();
				if (work[i] != null)
					model.setWork(work[i]);
				if (total[i] != null)
					model.setTotal(total[i]);
				if (workComm[i] != null)
					model.setWorkComm(workComm[i]);
				if (craneNo[i] != null)
					model.setCraneNo(craneNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (other[i] != null)
					model.setOther(other[i]);
				if (breakDown[i] != null)
					model.setBreakDown(breakDown[i]);
				if (workComp[i] != null)
					model.setWorkComp(workComp[i]);
				if (weather[i] != null)
					model.setWeather(weather[i]);
				if (meal[i] != null)
					model.setMeal(meal[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPortLogDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PortLogDetailVO[]
	 */
	public PortLogDetailVO[] getPortLogDetailVOs(){
		PortLogDetailVO[] vos = (PortLogDetailVO[])models.toArray(new PortLogDetailVO[models.size()]);
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
		this.work = this.work .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.total = this.total .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.workComm = this.workComm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.craneNo = this.craneNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.other = this.other .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.breakDown = this.breakDown .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.workComp = this.workComp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.weather = this.weather .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.meal = this.meal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
