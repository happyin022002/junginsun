/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MTYCNTRPERFSearchOptionVO.java
*@FileTitle : MTYCNTRPERFSearchOptionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.06.02 박광석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo;

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

public class MTYCNTRPERFSearchOptionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MTYCNTRPERFSearchOptionVO> models = new ArrayList<MTYCNTRPERFSearchOptionVO>();
	
	/* Column Info */
	private String inquiryLevel = null;
	/* Column Info */
	private String to = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tpsz = null;
	/* Column Info */
	private String location = null;
	/* Column Info */
	private String company = null;
	/* Column Info */
	private String from = null;
	/* Column Info */
	private String soc = null;
	/* Column Info */
	private String mtymvmt = null;
	/* Column Info */
	private String period = null;
	/* Column Info */
	private String bound = null;

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MTYCNTRPERFSearchOptionVO() {}

	/**
	 * 
	 * @param ibflag
	 * @param pagerows
	 * @param from
	 * @param to
	 * @param inquiryLevel
	 * @param location
	 * @param tpsz
	 * @param mtymvmt
	 * @param soc
	 * @param company
	 * @param period
	 */
	public MTYCNTRPERFSearchOptionVO(String ibflag, String pagerows, String from, String to, String inquiryLevel, String location, String tpsz, String mtymvmt, String soc, String company,String period,String bound) {
		this.inquiryLevel = inquiryLevel;
		this.to = to;
		this.ibflag = ibflag;
		this.tpsz = tpsz;
		this.location = location;
		this.company = company;
		this.from = from;
		this.soc = soc;
		this.mtymvmt = mtymvmt;
		this.period = period;
		this.bound = bound;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inquiryLevel", getInquiryLevel());
		this.hashColumns.put("to", getTo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tpsz", getTpsz());
		this.hashColumns.put("location", getLocation());
		this.hashColumns.put("company", getCompany());
		this.hashColumns.put("from", getFrom());
		this.hashColumns.put("soc", getSoc());
		this.hashColumns.put("mtymvmt", getMtymvmt());
		this.hashColumns.put("period", getPeriod());
		this.hashColumns.put("bound", getBound());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("inquiryLevel", "inquiryLevel");
		this.hashFields.put("to", "to");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tpsz", "tpsz");
		this.hashFields.put("location", "location");
		this.hashFields.put("company", "company");
		this.hashFields.put("from", "from");
		this.hashFields.put("soc", "soc");
		this.hashFields.put("mtymvmt", "mtymvmt");
		this.hashFields.put("period", "period");
		this.hashFields.put("bound", "bound");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	
	public String getBound() {
		return bound;
	}

	public void setBound(String bound) {
		this.bound = bound;
	}

	/**
	 * Column Info
	 * @return inquirylevel
	 */
	public String getInquiryLevel() {
		return this.inquiryLevel;
	}
	
	/**
	 * Column Info
	 * @return to
	 */
	public String getTo() {
		return this.to;
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
	 * @return location
	 */
	public String getLocation() {
		return this.location;
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
	 * @return from
	 */
	public String getFrom() {
		return this.from;
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
	 * @return mtymvmt
	 */
	public String getMtymvmt() {
		return this.mtymvmt;
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
	 * @param inquirylevel
	 */
	public void setInquiryLevel(String inquiryLevel) {
		this.inquiryLevel = inquiryLevel;
	}
	
	/**
	 * Column Info
	 * @param to
	 */
	public void setTo(String to) {
		this.to = to;
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
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
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
	 * @param from
	 */
	public void setFrom(String from) {
		this.from = from;
	}
	
	/**
	 * Column Info
	 * @param soc
	 */
	public void setSoc(String soc) {
		this.soc = soc;
	}
	
	/**
	 * Column Info
	 * @param mtymvmt
	 */
	public void setMtymvmt(String mtymvmt) {
		this.mtymvmt = mtymvmt;
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
		setInquiryLevel(JSPUtil.getParameter(request, "inquiryLevel", ""));
		setTo(JSPUtil.getParameter(request, "to", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTpsz(JSPUtil.getParameter(request, "tpsz", ""));
		setLocation(JSPUtil.getParameter(request, "location", ""));
		setCompany(JSPUtil.getParameter(request, "company", ""));
		setFrom(JSPUtil.getParameter(request, "from", ""));
		setSoc(JSPUtil.getParameter(request, "soc", ""));
		setMtymvmt(JSPUtil.getParameter(request, "mtymvmt", ""));
		setPeriod(JSPUtil.getParameter(request, "period", ""));
		setBound(JSPUtil.getParameter(request, "bound", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MTYCNTRPERFSearchOptionVO[]
	 */
	public MTYCNTRPERFSearchOptionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MTYCNTRPERFSearchOptionVO[]
	 */
	public MTYCNTRPERFSearchOptionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MTYCNTRPERFSearchOptionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] inquiryLevel = (JSPUtil.getParameter(request, prefix	+ "inquiryLevel".trim(), length));
			String[] to = (JSPUtil.getParameter(request, prefix	+ "to".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] tpsz = (JSPUtil.getParameter(request, prefix	+ "tpsz".trim(), length));
			String[] location = (JSPUtil.getParameter(request, prefix	+ "location".trim(), length));
			String[] company = (JSPUtil.getParameter(request, prefix	+ "company".trim(), length));
			String[] from = (JSPUtil.getParameter(request, prefix	+ "from".trim(), length));
			String[] soc = (JSPUtil.getParameter(request, prefix	+ "soc".trim(), length));
			String[] mtymvmt = (JSPUtil.getParameter(request, prefix	+ "mtymvmt".trim(), length));
			String[] period = (JSPUtil.getParameter(request, prefix	+ "period".trim(), length));
			String[] bound = (JSPUtil.getParameter(request, prefix	+ "bound".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new MTYCNTRPERFSearchOptionVO();
				if (inquiryLevel[i] != null)
					model.setInquiryLevel(inquiryLevel[i]);
				if (to[i] != null)
					model.setTo(to[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tpsz[i] != null)
					model.setTpsz(tpsz[i]);
				if (location[i] != null)
					model.setLocation(location[i]);
				if (company[i] != null)
					model.setCompany(company[i]);
				if (from[i] != null)
					model.setFrom(from[i]);
				if (soc[i] != null)
					model.setSoc(soc[i]);
				if (mtymvmt[i] != null)
					model.setMtymvmt(mtymvmt[i]);
				if (period[i] != null)
					model.setPeriod(period[i]);
				if (bound[i] != null)
					model.setBound(bound[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMTYCNTRPERFSearchOptionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MTYCNTRPERFSearchOptionVO[]
	 */
	public MTYCNTRPERFSearchOptionVO[] getMTYCNTRPERFSearchOptionVOs(){
		MTYCNTRPERFSearchOptionVO[] vos = (MTYCNTRPERFSearchOptionVO[])models.toArray(new MTYCNTRPERFSearchOptionVO[models.size()]);
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
		this.inquiryLevel = this.inquiryLevel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.to = this.to .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsz = this.tpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.location = this.location .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.company = this.company .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.from = this.from .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soc = this.soc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtymvmt = this.mtymvmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.period = this.period .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bound = this.bound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
