/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0065MultiVO.java
*@FileTitle : EesEqr0065MultiVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.21 채창호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.vo;

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
 * @author 채창호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0065MultiVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0065MultiVO> models = new ArrayList<EesEqr0065MultiVO>();
	
	/* Column Info */
	private String sensity = null;
	/* Column Info */
	private String toLoc = null;
	/* Column Info */
	private String fmLoc = null;
	/* Column Info */
	private String costRanage = null;
	/* Column Info */
	private String lane = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vol = null;
	/* Column Info */
	private String costRanage1 = null;
	/* Column Info */
	private String tsType = null;
	/* Column Info */
	private String obj = null;
	/* Column Info */
	private String currCost = null;
	/* Column Info */
	private String currLimit = null;
	/* Column Info */
	private String week = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0065MultiVO() {}

	public EesEqr0065MultiVO(String ibflag, String pagerows, String week, String sensity, String obj, String fmLoc, String toLoc, String tsType, String vol, String currCost, String currLimit, String costRanage, String costRanage1, String lane, String vvd) {
		this.sensity = sensity;
		this.toLoc = toLoc;
		this.fmLoc = fmLoc;
		this.costRanage = costRanage;
		this.lane = lane;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.vol = vol;
		this.costRanage1 = costRanage1;
		this.tsType = tsType;
		this.obj = obj;
		this.currCost = currCost;
		this.currLimit = currLimit;
		this.week = week;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sensity", getSensity());
		this.hashColumns.put("to_loc", getToLoc());
		this.hashColumns.put("fm_loc", getFmLoc());
		this.hashColumns.put("cost_ranage", getCostRanage());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vol", getVol());
		this.hashColumns.put("cost_ranage1", getCostRanage1());
		this.hashColumns.put("ts_type", getTsType());
		this.hashColumns.put("obj", getObj());
		this.hashColumns.put("curr_cost", getCurrCost());
		this.hashColumns.put("curr_limit", getCurrLimit());
		this.hashColumns.put("week", getWeek());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sensity", "sensity");
		this.hashFields.put("to_loc", "toLoc");
		this.hashFields.put("fm_loc", "fmLoc");
		this.hashFields.put("cost_ranage", "costRanage");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vol", "vol");
		this.hashFields.put("cost_ranage1", "costRanage1");
		this.hashFields.put("ts_type", "tsType");
		this.hashFields.put("obj", "obj");
		this.hashFields.put("curr_cost", "currCost");
		this.hashFields.put("curr_limit", "currLimit");
		this.hashFields.put("week", "week");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sensity
	 */
	public String getSensity() {
		return this.sensity;
	}
	
	/**
	 * Column Info
	 * @return toLoc
	 */
	public String getToLoc() {
		return this.toLoc;
	}
	
	/**
	 * Column Info
	 * @return fmLoc
	 */
	public String getFmLoc() {
		return this.fmLoc;
	}
	
	/**
	 * Column Info
	 * @return costRanage
	 */
	public String getCostRanage() {
		return this.costRanage;
	}
	
	/**
	 * Column Info
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return vol
	 */
	public String getVol() {
		return this.vol;
	}
	
	/**
	 * Column Info
	 * @return costRanage1
	 */
	public String getCostRanage1() {
		return this.costRanage1;
	}
	
	/**
	 * Column Info
	 * @return tsType
	 */
	public String getTsType() {
		return this.tsType;
	}
	
	/**
	 * Column Info
	 * @return obj
	 */
	public String getObj() {
		return this.obj;
	}
	
	/**
	 * Column Info
	 * @return currCost
	 */
	public String getCurrCost() {
		return this.currCost;
	}
	
	/**
	 * Column Info
	 * @return currLimit
	 */
	public String getCurrLimit() {
		return this.currLimit;
	}
	
	/**
	 * Column Info
	 * @return week
	 */
	public String getWeek() {
		return this.week;
	}
	

	/**
	 * Column Info
	 * @param sensity
	 */
	public void setSensity(String sensity) {
		this.sensity = sensity;
	}
	
	/**
	 * Column Info
	 * @param toLoc
	 */
	public void setToLoc(String toLoc) {
		this.toLoc = toLoc;
	}
	
	/**
	 * Column Info
	 * @param fmLoc
	 */
	public void setFmLoc(String fmLoc) {
		this.fmLoc = fmLoc;
	}
	
	/**
	 * Column Info
	 * @param costRanage
	 */
	public void setCostRanage(String costRanage) {
		this.costRanage = costRanage;
	}
	
	/**
	 * Column Info
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param vol
	 */
	public void setVol(String vol) {
		this.vol = vol;
	}
	
	/**
	 * Column Info
	 * @param costRanage1
	 */
	public void setCostRanage1(String costRanage1) {
		this.costRanage1 = costRanage1;
	}
	
	/**
	 * Column Info
	 * @param tsType
	 */
	public void setTsType(String tsType) {
		this.tsType = tsType;
	}
	
	/**
	 * Column Info
	 * @param obj
	 */
	public void setObj(String obj) {
		this.obj = obj;
	}
	
	/**
	 * Column Info
	 * @param currCost
	 */
	public void setCurrCost(String currCost) {
		this.currCost = currCost;
	}
	
	/**
	 * Column Info
	 * @param currLimit
	 */
	public void setCurrLimit(String currLimit) {
		this.currLimit = currLimit;
	}
	
	/**
	 * Column Info
	 * @param week
	 */
	public void setWeek(String week) {
		this.week = week;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSensity(JSPUtil.getParameter(request, "sensity", ""));
		setToLoc(JSPUtil.getParameter(request, "to_loc", ""));
		setFmLoc(JSPUtil.getParameter(request, "fm_loc", ""));
		setCostRanage(JSPUtil.getParameter(request, "cost_ranage", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVol(JSPUtil.getParameter(request, "vol", ""));
		setCostRanage1(JSPUtil.getParameter(request, "cost_ranage1", ""));
		setTsType(JSPUtil.getParameter(request, "ts_type", ""));
		setObj(JSPUtil.getParameter(request, "obj", ""));
		setCurrCost(JSPUtil.getParameter(request, "curr_cost", ""));
		setCurrLimit(JSPUtil.getParameter(request, "curr_limit", ""));
		setWeek(JSPUtil.getParameter(request, "week", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0065MultiVO[]
	 */
	public EesEqr0065MultiVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0065MultiVO[]
	 */
	public EesEqr0065MultiVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0065MultiVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sensity = (JSPUtil.getParameter(request, prefix	+ "sensity", length));
			String[] toLoc = (JSPUtil.getParameter(request, prefix	+ "to_loc", length));
			String[] fmLoc = (JSPUtil.getParameter(request, prefix	+ "fm_loc", length));
			String[] costRanage = (JSPUtil.getParameter(request, prefix	+ "cost_ranage", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vol = (JSPUtil.getParameter(request, prefix	+ "vol", length));
			String[] costRanage1 = (JSPUtil.getParameter(request, prefix	+ "cost_ranage1", length));
			String[] tsType = (JSPUtil.getParameter(request, prefix	+ "ts_type", length));
			String[] obj = (JSPUtil.getParameter(request, prefix	+ "obj", length));
			String[] currCost = (JSPUtil.getParameter(request, prefix	+ "curr_cost", length));
			String[] currLimit = (JSPUtil.getParameter(request, prefix	+ "curr_limit", length));
			String[] week = (JSPUtil.getParameter(request, prefix	+ "week", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0065MultiVO();
				if (sensity[i] != null)
					model.setSensity(sensity[i]);
				if (toLoc[i] != null)
					model.setToLoc(toLoc[i]);
				if (fmLoc[i] != null)
					model.setFmLoc(fmLoc[i]);
				if (costRanage[i] != null)
					model.setCostRanage(costRanage[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vol[i] != null)
					model.setVol(vol[i]);
				if (costRanage1[i] != null)
					model.setCostRanage1(costRanage1[i]);
				if (tsType[i] != null)
					model.setTsType(tsType[i]);
				if (obj[i] != null)
					model.setObj(obj[i]);
				if (currCost[i] != null)
					model.setCurrCost(currCost[i]);
				if (currLimit[i] != null)
					model.setCurrLimit(currLimit[i]);
				if (week[i] != null)
					model.setWeek(week[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0065MultiVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0065MultiVO[]
	 */
	public EesEqr0065MultiVO[] getEesEqr0065MultiVOs(){
		EesEqr0065MultiVO[] vos = (EesEqr0065MultiVO[])models.toArray(new EesEqr0065MultiVO[models.size()]);
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
		this.sensity = this.sensity .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toLoc = this.toLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmLoc = this.fmLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costRanage = this.costRanage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vol = this.vol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costRanage1 = this.costRanage1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsType = this.tsType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obj = this.obj .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCost = this.currCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currLimit = this.currLimit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.week = this.week .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
