/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PortLogDetailVO.java
*@FileTitle : PortLogDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.26
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2013.12.26 원종규 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 원종규
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
	private String other = null;
	/* Column Info */
	private String grossWorkHrs = null;
	/* Column Info */
	private String breakDown = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String craneNo = null;
	/* Column Info */
	private String workComp = null;
	/* Column Info */
	private String weather = null;
	/* Column Info */
	private String netWorkHrs = null;
	/* Column Info */
	private String meal = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PortLogDetailVO() {}

	public PortLogDetailVO(String ibflag, String pagerows, String work, String total, String workComm, String craneNo, String other, String breakDown, String workComp, String weather, String meal, String netWorkHrs, String grossWorkHrs) {
		this.work = work;
		this.total = total;
		this.workComm = workComm;
		this.other = other;
		this.grossWorkHrs = grossWorkHrs;
		this.breakDown = breakDown;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.craneNo = craneNo;
		this.workComp = workComp;
		this.weather = weather;
		this.netWorkHrs = netWorkHrs;
		this.meal = meal;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("work", getWork());
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("work_comm", getWorkComm());
		this.hashColumns.put("other", getOther());
		this.hashColumns.put("gross_work_hrs", getGrossWorkHrs());
		this.hashColumns.put("break_down", getBreakDown());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("crane_no", getCraneNo());
		this.hashColumns.put("work_comp", getWorkComp());
		this.hashColumns.put("weather", getWeather());
		this.hashColumns.put("net_work_hrs", getNetWorkHrs());
		this.hashColumns.put("meal", getMeal());
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
		this.hashFields.put("other", "other");
		this.hashFields.put("gross_work_hrs", "grossWorkHrs");
		this.hashFields.put("break_down", "breakDown");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("crane_no", "craneNo");
		this.hashFields.put("work_comp", "workComp");
		this.hashFields.put("weather", "weather");
		this.hashFields.put("net_work_hrs", "netWorkHrs");
		this.hashFields.put("meal", "meal");
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
	 * @return other
	 */
	public String getOther() {
		return this.other;
	}
	
	/**
	 * Column Info
	 * @return grossWorkHrs
	 */
	public String getGrossWorkHrs() {
		return this.grossWorkHrs;
	}
	
	/**
	 * Column Info
	 * @return breakDown
	 */
	public String getBreakDown() {
		return this.breakDown;
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
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return craneNo
	 */
	public String getCraneNo() {
		return this.craneNo;
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
	 * @return netWorkHrs
	 */
	public String getNetWorkHrs() {
		return this.netWorkHrs;
	}
	
	/**
	 * Column Info
	 * @return meal
	 */
	public String getMeal() {
		return this.meal;
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
	 * @param other
	 */
	public void setOther(String other) {
		this.other = other;
	}
	
	/**
	 * Column Info
	 * @param grossWorkHrs
	 */
	public void setGrossWorkHrs(String grossWorkHrs) {
		this.grossWorkHrs = grossWorkHrs;
	}
	
	/**
	 * Column Info
	 * @param breakDown
	 */
	public void setBreakDown(String breakDown) {
		this.breakDown = breakDown;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param craneNo
	 */
	public void setCraneNo(String craneNo) {
		this.craneNo = craneNo;
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
	 * @param netWorkHrs
	 */
	public void setNetWorkHrs(String netWorkHrs) {
		this.netWorkHrs = netWorkHrs;
	}
	
	/**
	 * Column Info
	 * @param meal
	 */
	public void setMeal(String meal) {
		this.meal = meal;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setWork(JSPUtil.getParameter(request, prefix + "work", ""));
		setTotal(JSPUtil.getParameter(request, prefix + "total", ""));
		setWorkComm(JSPUtil.getParameter(request, prefix + "work_comm", ""));
		setOther(JSPUtil.getParameter(request, prefix + "other", ""));
		setGrossWorkHrs(JSPUtil.getParameter(request, prefix + "gross_work_hrs", ""));
		setBreakDown(JSPUtil.getParameter(request, prefix + "break_down", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCraneNo(JSPUtil.getParameter(request, prefix + "crane_no", ""));
		setWorkComp(JSPUtil.getParameter(request, prefix + "work_comp", ""));
		setWeather(JSPUtil.getParameter(request, prefix + "weather", ""));
		setNetWorkHrs(JSPUtil.getParameter(request, prefix + "net_work_hrs", ""));
		setMeal(JSPUtil.getParameter(request, prefix + "meal", ""));
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
			String[] other = (JSPUtil.getParameter(request, prefix	+ "other", length));
			String[] grossWorkHrs = (JSPUtil.getParameter(request, prefix	+ "gross_work_hrs", length));
			String[] breakDown = (JSPUtil.getParameter(request, prefix	+ "break_down", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] craneNo = (JSPUtil.getParameter(request, prefix	+ "crane_no", length));
			String[] workComp = (JSPUtil.getParameter(request, prefix	+ "work_comp", length));
			String[] weather = (JSPUtil.getParameter(request, prefix	+ "weather", length));
			String[] netWorkHrs = (JSPUtil.getParameter(request, prefix	+ "net_work_hrs", length));
			String[] meal = (JSPUtil.getParameter(request, prefix	+ "meal", length));
			
			for (int i = 0; i < length; i++) {
				model = new PortLogDetailVO();
				if (work[i] != null)
					model.setWork(work[i]);
				if (total[i] != null)
					model.setTotal(total[i]);
				if (workComm[i] != null)
					model.setWorkComm(workComm[i]);
				if (other[i] != null)
					model.setOther(other[i]);
				if (grossWorkHrs[i] != null)
					model.setGrossWorkHrs(grossWorkHrs[i]);
				if (breakDown[i] != null)
					model.setBreakDown(breakDown[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (craneNo[i] != null)
					model.setCraneNo(craneNo[i]);
				if (workComp[i] != null)
					model.setWorkComp(workComp[i]);
				if (weather[i] != null)
					model.setWeather(weather[i]);
				if (netWorkHrs[i] != null)
					model.setNetWorkHrs(netWorkHrs[i]);
				if (meal[i] != null)
					model.setMeal(meal[i]);
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
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.work = this.work .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.total = this.total .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.workComm = this.workComm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.other = this.other .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grossWorkHrs = this.grossWorkHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.breakDown = this.breakDown .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.craneNo = this.craneNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.workComp = this.workComp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.weather = this.weather .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netWorkHrs = this.netWorkHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.meal = this.meal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
