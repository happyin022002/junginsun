/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ClockStopVO.java
*@FileTitle : ClockStopVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.14 황효근 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo;

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
 * @author 황효근
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ClockStopVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ClockStopVO> models = new ArrayList<ClockStopVO>();
	
	/* Column Info */
	private String stopDay = null;
	/* Column Info */
	private String clkStopRmk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String clkStopFmDt = null;
	/* Column Info */
	private String clkStopToDt = null;
	/* Column Info */
	private String clkStopNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ClockStopVO() {}

	public ClockStopVO(String ibflag, String pagerows, String clkStopNo, String clkStopFmDt, String clkStopToDt, String stopDay, String clkStopRmk) {
		this.stopDay = stopDay;
		this.clkStopRmk = clkStopRmk;
		this.ibflag = ibflag;
		this.clkStopFmDt = clkStopFmDt;
		this.clkStopToDt = clkStopToDt;
		this.clkStopNo = clkStopNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("stop_day", getStopDay());
		this.hashColumns.put("clk_stop_rmk", getClkStopRmk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("clk_stop_fm_dt", getClkStopFmDt());
		this.hashColumns.put("clk_stop_to_dt", getClkStopToDt());
		this.hashColumns.put("clk_stop_no", getClkStopNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("stop_day", "stopDay");
		this.hashFields.put("clk_stop_rmk", "clkStopRmk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("clk_stop_fm_dt", "clkStopFmDt");
		this.hashFields.put("clk_stop_to_dt", "clkStopToDt");
		this.hashFields.put("clk_stop_no", "clkStopNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return stopDay
	 */
	public String getStopDay() {
		return this.stopDay;
	}
	
	/**
	 * Column Info
	 * @return clkStopRmk
	 */
	public String getClkStopRmk() {
		return this.clkStopRmk;
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
	 * @return clkStopFmDt
	 */
	public String getClkStopFmDt() {
		return this.clkStopFmDt;
	}
	
	/**
	 * Column Info
	 * @return clkStopToDt
	 */
	public String getClkStopToDt() {
		return this.clkStopToDt;
	}
	
	/**
	 * Column Info
	 * @return clkStopNo
	 */
	public String getClkStopNo() {
		return this.clkStopNo;
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
	 * @param stopDay
	 */
	public void setStopDay(String stopDay) {
		this.stopDay = stopDay;
	}
	
	/**
	 * Column Info
	 * @param clkStopRmk
	 */
	public void setClkStopRmk(String clkStopRmk) {
		this.clkStopRmk = clkStopRmk;
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
	 * @param clkStopFmDt
	 */
	public void setClkStopFmDt(String clkStopFmDt) {
		this.clkStopFmDt = clkStopFmDt;
	}
	
	/**
	 * Column Info
	 * @param clkStopToDt
	 */
	public void setClkStopToDt(String clkStopToDt) {
		this.clkStopToDt = clkStopToDt;
	}
	
	/**
	 * Column Info
	 * @param clkStopNo
	 */
	public void setClkStopNo(String clkStopNo) {
		this.clkStopNo = clkStopNo;
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
		setStopDay(JSPUtil.getParameter(request, "stop_day", ""));
		setClkStopRmk(JSPUtil.getParameter(request, "clk_stop_rmk", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setClkStopFmDt(JSPUtil.getParameter(request, "clk_stop_fm_dt", ""));
		setClkStopToDt(JSPUtil.getParameter(request, "clk_stop_to_dt", ""));
		setClkStopNo(JSPUtil.getParameter(request, "clk_stop_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ClockStopVO[]
	 */
	public ClockStopVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ClockStopVO[]
	 */
	public ClockStopVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ClockStopVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] stopDay = (JSPUtil.getParameter(request, prefix	+ "stop_day", length));
			String[] clkStopRmk = (JSPUtil.getParameter(request, prefix	+ "clk_stop_rmk", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] clkStopFmDt = (JSPUtil.getParameter(request, prefix	+ "clk_stop_fm_dt", length));
			String[] clkStopToDt = (JSPUtil.getParameter(request, prefix	+ "clk_stop_to_dt", length));
			String[] clkStopNo = (JSPUtil.getParameter(request, prefix	+ "clk_stop_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ClockStopVO();
				if (stopDay[i] != null)
					model.setStopDay(stopDay[i]);
				if (clkStopRmk[i] != null)
					model.setClkStopRmk(clkStopRmk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (clkStopFmDt[i] != null)
					model.setClkStopFmDt(clkStopFmDt[i]);
				if (clkStopToDt[i] != null)
					model.setClkStopToDt(clkStopToDt[i]);
				if (clkStopNo[i] != null)
					model.setClkStopNo(clkStopNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getClockStopVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ClockStopVO[]
	 */
	public ClockStopVO[] getClockStopVOs(){
		ClockStopVO[] vos = (ClockStopVO[])models.toArray(new ClockStopVO[models.size()]);
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
		this.stopDay = this.stopDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clkStopRmk = this.clkStopRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clkStopFmDt = this.clkStopFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clkStopToDt = this.clkStopToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clkStopNo = this.clkStopNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
