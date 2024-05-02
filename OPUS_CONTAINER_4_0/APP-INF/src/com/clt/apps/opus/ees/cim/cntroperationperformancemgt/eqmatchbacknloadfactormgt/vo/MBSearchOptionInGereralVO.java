/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MBSearchOptionInGereralVO.java
*@FileTitle : MBSearchOptionInGereralVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.06.01 박광석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo;

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
 * @author 박광석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MBSearchOptionInGereralVO extends AbstractValueObject {
 
	private static final long serialVersionUID = 1L;
	
	private Collection<MBSearchOptionInGereralVO> models = new ArrayList<MBSearchOptionInGereralVO>();
	
	/* Column Info */
	private String to = null;
	/* Column Info */
	private String tscntr = null;
	/* Column Info */
	private String location = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String from = null;
	/* Column Info */
	private String period = null;
	/* Column Info */
	private String cargotype = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lane = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tpsz = null;
	/* Column Info */
	private String company = null;
	/* Column Info */
	private String rdtype = null;
	/* Column Info */
	private String soc = null;
	/* Column Info */
	private String inquiryLevel = null;
	/* Column Info */
	private String locationBy = null;
	/* Column Info */
	private String cargoType = null;
	/* Column Info */
	private String enRoute = null;

	public String getInquiryLevel() {
		return inquiryLevel;
	}

	public void setInquiryLevel(String inquiryLevel) {
		this.inquiryLevel = inquiryLevel;
	}

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MBSearchOptionInGereralVO() {}

	public MBSearchOptionInGereralVO(String ibflag, String pagerows, String period, String from, String to, String location, String lane, String vvd, String cargotype, String tpsz, String rdtype, String tscntr, String soc, String company,String inquiryLevel, String locationBy, String cargoType, String enRoute,String pol) {
		this.to = to;
		this.tscntr = tscntr;
		this.location = location;
		this.from = from;
		this.period = period;
		this.cargotype = cargotype;
		this.pagerows = pagerows;
		this.lane = lane;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.tpsz = tpsz;
		this.company = company;
		this.rdtype = rdtype;
		this.soc = soc;
		this.inquiryLevel = inquiryLevel;
		this.locationBy = cargoType;
		this.enRoute = enRoute;
		this.pol = pol;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to", getTo());
		this.hashColumns.put("tscntr", getTscntr());
		this.hashColumns.put("location", getLocation());
		this.hashColumns.put("from", getFrom());
		this.hashColumns.put("period", getPeriod());
		this.hashColumns.put("cargotype", getCargotype());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tpsz", getTpsz());
		this.hashColumns.put("company", getCompany());
		this.hashColumns.put("rdtype", getRdtype());
		this.hashColumns.put("soc", getSoc());
		this.hashColumns.put("inquiryLevel", getInquiryLevel());
		this.hashColumns.put("locationBy", getLocationBy());
		this.hashColumns.put("cargoType", getCargoType());
		this.hashColumns.put("enRoute", getEnRoute());
		this.hashColumns.put("pol", getPol());
		return this.hashColumns;
	}
	
	public String getPol() {
		return pol;
	}

	public void setPol(String pol) {
		this.pol = pol;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to", "to");
		this.hashFields.put("tscntr", "tscntr");
		this.hashFields.put("location", "location");
		this.hashFields.put("from", "from");
		this.hashFields.put("period", "period");
		this.hashFields.put("cargotype", "cargotype");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tpsz", "tpsz");
		this.hashFields.put("company", "company");
		this.hashFields.put("rdtype", "rdtype");
		this.hashFields.put("soc", "soc");
		this.hashFields.put("inquiryLevel", "inquiryLevel");
		this.hashFields.put("locationBy", "locationBy");
		this.hashFields.put("cargoType", "cargoType");
		this.hashFields.put("enRoute", "enRoute");
		this.hashFields.put("pol", "pol");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return to
	 */
	public String getTo() {
		return this.to;
	}
	
	/**
	 * Column Info
	 * @return tscntr
	 */
	public String getTscntr() {
		return this.tscntr;
	}
	
	/**
	 * Column Info
	 * @return location
	 */
	public String getLocation() {
		return this.location;
	}
	
	/**
	 * Column Info
	 * @return from
	 */
	public String getFrom() {
		return this.from;
	}
	
	/**
	 * Column Info
	 * @return period
	 */
	public String getPeriod() {
		return this.period;
	}
	
	/**
	 * Column Info
	 * @return cargotype
	 */
	public String getCargotype() {
		return this.cargotype;
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
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
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
	 * @return tpsz
	 */
	public String getTpsz() {
		return this.tpsz;
	}
	
	/**
	 * Column Info
	 * @return company
	 */
	public String getCompany() {
		return this.company;
	}
	
	/**
	 * Column Info
	 * @return rdtype
	 */
	public String getRdtype() {
		return this.rdtype;
	}
	
	/**
	 * Column Info
	 * @return soc
	 */
	public String getSoc() {
		return this.soc;
	}
	

	/**
	 * Column Info
	 * @param to
	 */
	public void setTo(String to) {
		this.to = to;
	}
	
	/**
	 * Column Info
	 * @param tscntr
	 */
	public void setTscntr(String tscntr) {
		this.tscntr = tscntr;
	}
	
	/**
	 * Column Info
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * Column Info
	 * @param from
	 */
	public void setFrom(String from) {
		this.from = from;
	}
	
	/**
	 * Column Info
	 * @param period
	 */
	public void setPeriod(String period) {
		this.period = period;
	}
	
	/**
	 * Column Info
	 * @param cargotype
	 */
	public void setCargotype(String cargotype) {
		this.cargotype = cargotype;
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
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
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
	 * @param tpsz
	 */
	public void setTpsz(String tpsz) {
		this.tpsz = tpsz;
	}
	
	/**
	 * Column Info
	 * @param company
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	
	/**
	 * Column Info
	 * @param rdtype
	 */
	public void setRdtype(String rdtype) {
		this.rdtype = rdtype;
	}
	
	/**
	 * Column Info
	 * @param soc
	 */
	public void setSoc(String soc) {
		this.soc = soc;
	}
	
	/**
	 * @return the locationBy
	 */
	public String getLocationBy() {
		return locationBy;
	}

	/**
	 * @param locationBy the locationBy to set
	 */
	public void setLocationBy(String locationBy) {
		this.locationBy = locationBy;
	}

	/**
	 * @return the cargoType
	 */
	public String getCargoType() {
		return cargoType;
	}

	/**
	 * @param cargoType the cargoType to set
	 */
	public void setCargoType(String cargoType) {
		this.cargoType = cargoType;
	}

	/**
	 * @return the enRoute
	 */
	public String getEnRoute() {
		return enRoute;
	}

	/**
	 * @param enRoute the enRoute to set
	 */
	public void setEnRoute(String enRoute) {
		this.enRoute = enRoute;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTo(JSPUtil.getParameter(request, "to", ""));
		setTscntr(JSPUtil.getParameter(request, "tscntr", ""));
		setLocation(JSPUtil.getParameter(request, "location", ""));
		setFrom(JSPUtil.getParameter(request, "from", ""));
		setPeriod(JSPUtil.getParameter(request, "period", ""));
		setCargotype(JSPUtil.getParameter(request, "cargotype", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTpsz(JSPUtil.getParameter(request, "tpsz", ""));
		setCompany(JSPUtil.getParameter(request, "company", ""));
		setRdtype(JSPUtil.getParameter(request, "rdtype", ""));
		setSoc(JSPUtil.getParameter(request, "soc", ""));
		setInquiryLevel(JSPUtil.getParameter(request, "inquiryLevel", ""));
		setLocationBy(JSPUtil.getParameter(request, "locationBy", ""));
		setCargoType(JSPUtil.getParameter(request, "cargoType", ""));
		setEnRoute(JSPUtil.getParameter(request, "enRoute", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MBSearchOptionInGereralVO[]
	 */
	public MBSearchOptionInGereralVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MBSearchOptionInGereralVO[]
	 */
	public MBSearchOptionInGereralVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MBSearchOptionInGereralVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] to = (JSPUtil.getParameter(request, prefix	+ "to".trim(), length));
			String[] tscntr = (JSPUtil.getParameter(request, prefix	+ "tscntr".trim(), length));
			String[] location = (JSPUtil.getParameter(request, prefix	+ "location".trim(), length));
			String[] from = (JSPUtil.getParameter(request, prefix	+ "from".trim(), length));
			String[] period = (JSPUtil.getParameter(request, prefix	+ "period".trim(), length));
			String[] cargotype = (JSPUtil.getParameter(request, prefix	+ "cargotype".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane".trim(), length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] tpsz = (JSPUtil.getParameter(request, prefix	+ "tpsz".trim(), length));
			String[] company = (JSPUtil.getParameter(request, prefix	+ "company".trim(), length));
			String[] rdtype = (JSPUtil.getParameter(request, prefix	+ "rdtype".trim(), length));
			String[] soc = (JSPUtil.getParameter(request, prefix	+ "soc".trim(), length));
			String[] inquiryLevel = (JSPUtil.getParameter(request, prefix	+ "inquiryLevel".trim(), length));
			String[] locationBy = (JSPUtil.getParameter(request, prefix	+ "locationBy".trim(), length));
			String[] cargoType = (JSPUtil.getParameter(request, prefix	+ "cargoType".trim(), length));
			String[] enRoute = (JSPUtil.getParameter(request, prefix	+ "enRoute".trim(), length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol".trim(), length));
						
			for (int i = 0; i < length; i++) {
				model = new MBSearchOptionInGereralVO();
				if (to[i] != null)
					model.setTo(to[i]);
				if (tscntr[i] != null)
					model.setTscntr(tscntr[i]);
				if (location[i] != null)
					model.setLocation(location[i]);
				if (from[i] != null)
					model.setFrom(from[i]);
				if (period[i] != null)
					model.setPeriod(period[i]);
				if (cargotype[i] != null)
					model.setCargotype(cargotype[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tpsz[i] != null)
					model.setTpsz(tpsz[i]);
				if (company[i] != null)
					model.setCompany(company[i]);
				if (rdtype[i] != null)
					model.setRdtype(rdtype[i]);
				if (soc[i] != null)
					model.setSoc(soc[i]);
				if (inquiryLevel[i] != null)
					model.setInquiryLevel(inquiryLevel[i]);
				if (locationBy[i] != null)
					model.setLocationBy(locationBy[i]);
				if (cargoType[i] != null)
					model.setCargoType(cargoType[i]);
				if (enRoute[i] != null)
					model.setEnRoute(enRoute[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				models.add(model);
			}
			
		} catch (Exception e) {
			return null;
		}
		return getMBSearchOptionInGereralVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MBSearchOptionInGereralVO[]
	 */
	public MBSearchOptionInGereralVO[] getMBSearchOptionInGereralVOs(){
		MBSearchOptionInGereralVO[] vos = (MBSearchOptionInGereralVO[])models.toArray(new MBSearchOptionInGereralVO[models.size()]);
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
		this.to = this.to .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tscntr = this.tscntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.location = this.location .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.from = this.from .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.period = this.period .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargotype = this.cargotype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsz = this.tpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.company = this.company .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdtype = this.rdtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soc = this.soc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inquiryLevel = this.inquiryLevel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locationBy = this.locationBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoType = this.cargoType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.enRoute = this.enRoute .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
