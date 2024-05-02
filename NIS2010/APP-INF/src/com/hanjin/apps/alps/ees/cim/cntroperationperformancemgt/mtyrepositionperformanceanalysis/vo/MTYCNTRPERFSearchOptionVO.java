/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : MTYCNTRPERFSearchOptionVO.java
 *@FileTitle : MTYCNTRPERFSearchOptionVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.04.29
 *@LastModifier : Chang Young Kim
 *@LastVersion : 1.01
 * 2009.06.02 박광석 
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2014.04.29 Chang Young Kim [CHM-201429600] 
 * 			Movement performance by CY Tab별 조회조건 추가
 * 			vvdTp, vvdNm 추가
=========================================================*/

package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo;

import java.lang.reflect.Field;
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
 * @author 박광석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MTYCNTRPERFSearchOptionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MTYCNTRPERFSearchOptionVO> models = new ArrayList<MTYCNTRPERFSearchOptionVO>();
	
	/* Column Info */
	private String radioTpsz = null;
	/* Column Info */
	private String dtlTpsz = null;
	/* Column Info */
	private String location = null;
	/* Column Info */
	private String period = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String inquiryLevel = null;
	/* Column Info */
	private String to = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tpsz = null;
	/* Column Info */
	private String from = null;
	/* Column Info */
	private String company = null;
	/* Column Info */
	private String day = null;
	/* Column Info */
	private String mtymvmt = null;
	/* Column Info */
	private String bound = null;
	/* Column Info */
	private String soc = null;
	/* Column Info */
	private String vvdTp = null;
	/* Column Info */
	private String vvdNm = null;
	/* Column Info */
	private String lstmcd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MTYCNTRPERFSearchOptionVO() {}

	public MTYCNTRPERFSearchOptionVO(String ibflag, String pagerows, String radioTpsz, String dtlTpsz, String location, String period, String inquiryLevel, String to, String tpsz, String from, String company, String bound, String soc, String mtymvmt, String day, String vvdTp, String vvdNm, String lstmcd) {
		this.radioTpsz = radioTpsz;
		this.dtlTpsz = dtlTpsz;
		this.location = location;
		this.period = period;
		this.pagerows = pagerows;
		this.inquiryLevel = inquiryLevel;
		this.to = to;
		this.ibflag = ibflag;
		this.tpsz = tpsz;
		this.from = from;
		this.company = company;
		this.day = day;
		this.mtymvmt = mtymvmt;
		this.bound = bound;
		this.soc = soc;
		this.vvdTp  = vvdTp ;
		this.vvdNm  = vvdNm ;
		this.lstmcd  = lstmcd ;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("radioTpsz", getRadioTpsz());
		this.hashColumns.put("dtlTpsz", getDtlTpsz());
		this.hashColumns.put("location", getLocation());
		this.hashColumns.put("period", getPeriod());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inquiryLevel", getInquiryLevel());
		this.hashColumns.put("to", getTo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tpsz", getTpsz());
		this.hashColumns.put("from", getFrom());
		this.hashColumns.put("company", getCompany());
		this.hashColumns.put("day", getDay());
		this.hashColumns.put("mtymvmt", getMtymvmt());
		this.hashColumns.put("bound", getBound());
		this.hashColumns.put("soc", getSoc());
		this.hashColumns.put("vvd_tp", getVvdTp());
		this.hashColumns.put("vvd_nm", getVvdNm());
		this.hashColumns.put("lstmcd", getLstmcd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("radioTpsz", "radioTpsz");
		this.hashFields.put("dtlTpsz", "dtlTpsz");
		this.hashFields.put("location", "location");
		this.hashFields.put("period", "period");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inquiryLevel", "inquiryLevel");
		this.hashFields.put("to", "to");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tpsz", "tpsz");
		this.hashFields.put("from", "from");
		this.hashFields.put("company", "company");
		this.hashFields.put("day", "day");
		this.hashFields.put("mtymvmt", "mtymvmt");
		this.hashFields.put("bound", "bound");
		this.hashFields.put("soc", "soc");
		this.hashFields.put("vvd_tp", "vvdTp");
		this.hashFields.put("vvd_nm", "vvdNm");
		this.hashFields.put("lstmcd", "lstmcd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return radioTpsz
	 */
	public String getRadioTpsz() {
		return this.radioTpsz;
	}
	
	/**
	 * Column Info
	 * @return dtlTpsz
	 */
	public String getDtlTpsz() {
		return this.dtlTpsz;
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
	 * @return period
	 */
	public String getPeriod() {
		return this.period;
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
	 * @return inquiryLevel
	 */
	public String getInquiryLevel() {
		return this.inquiryLevel;
	}
	
	/**
	 * Column Info
	 * @return to9
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
	 * @return from9
	 */
	public String getFrom() {
		return this.from;
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
	 * @return day
	 */
	public String getDay() {
		return this.day;
	}
	
	/**
	 * Column Info
	 * @return mtymvmt
	 */
	public String getMtymvmt() {
		return this.mtymvmt;
	}
	
	/**
	 * Column Info
	 * @return bound
	 */
	public String getBound() {
		return this.bound;
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
	 * @return lstmcd
	 */
	public String getLstmcd() {
		return this.lstmcd;
	}
	
	
	/**
	 * Column Info
	 * @param radiotpsz
	 */
	public void setRadioTpsz(String radioTpsz) {
		this.radioTpsz = radioTpsz;
	}
	
	/**
	 * Column Info
	 * @param dtltpsz
	 */
	public void setDtlTpsz(String dtlTpsz) {
		this.dtlTpsz = dtlTpsz;
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
	 * @param period
	 */
	public void setPeriod(String period) {
		this.period = period;
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
	 * @param inquirylevel
	 */
	public void setInquiryLevel(String inquiryLevel) {
		this.inquiryLevel = inquiryLevel;
	}
	
	/**
	 * Column Info
	 * @param to9
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
	 * @param from9
	 */
	public void setFrom(String from) {
		this.from = from;
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
	 * @param day
	 */
	public void setDay(String day) {
		this.day = day;
	}
	
	/**
	 * Column Info
	 * @param mtymvmt
	 */
	public void setMtymvmt(String mtymvmt) {
		this.mtymvmt = mtymvmt;
	}
	
	/**
	 * Column Info
	 * @param bound
	 */
	public void setBound(String bound) {
		this.bound = bound;
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
	* @param vvdTp
	*/
	public void setVvdTp( String vvdTp ) {
		this.vvdTp = vvdTp;
	}
 
	/**
	 * Column Info
	 * @return vvdTp
	 */
	 public	String getVvdTp() {
		 return	this.vvdTp;
	 } 
	 
 	/**
	* Column Info
	* @param  vvdNm
	*/
	public void	setVvdNm( String	vvdNm ) {
		this.vvdNm =	vvdNm;
	}
 
	/**
	 * Column Info
	 * @return	vvdNm
	 */
	 public	String	getVvdNm() {
		 return	this.vvdNm;
	 } 

	 	/**
		* Column Info
		* @param  lstmcd
		*/
		public void	setLstmcd( String	lstmcd ) {
			this.lstmcd =	lstmcd;
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
		setRadioTpsz(JSPUtil.getParameter(request, prefix + "radioTpsz", ""));
		setDtlTpsz(JSPUtil.getParameter(request, prefix + "dtlTpsz", ""));
		setLocation(JSPUtil.getParameter(request, prefix + "location", ""));
		setPeriod(JSPUtil.getParameter(request, prefix + "period", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setInquiryLevel(JSPUtil.getParameter(request, prefix + "inquiryLevel", ""));
		setTo(JSPUtil.getParameter(request, prefix + "to", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTpsz(JSPUtil.getParameter(request, prefix + "tpsz", ""));
		setFrom(JSPUtil.getParameter(request, prefix + "from", ""));
		setCompany(JSPUtil.getParameter(request, prefix + "company", ""));
		setDay(JSPUtil.getParameter(request, prefix + "day", ""));
		setMtymvmt(JSPUtil.getParameter(request, prefix + "mtymvmt", ""));
		setBound(JSPUtil.getParameter(request, prefix + "bound", ""));
		setSoc(JSPUtil.getParameter(request, prefix + "soc", ""));
		setVvdTp(JSPUtil.getParameter(request,	prefix + "vvd_tp", ""));
		setVvdNm(JSPUtil.getParameter(request,	prefix + "vvd_nm", ""));
		setLstmcd(JSPUtil.getParameter(request,	prefix + "lstmcd", ""));
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
			String[] radioTpsz = (JSPUtil.getParameter(request, prefix	+ "radioTpsz", length));
			String[] dtlTpsz = (JSPUtil.getParameter(request, prefix	+ "dtlTpsz", length));
			String[] location = (JSPUtil.getParameter(request, prefix	+ "location", length));
			String[] period = (JSPUtil.getParameter(request, prefix	+ "period", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] inquiryLevel = (JSPUtil.getParameter(request, prefix	+ "inquiryLevel", length));
			String[] to = (JSPUtil.getParameter(request, prefix	+ "to", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tpsz = (JSPUtil.getParameter(request, prefix	+ "tpsz", length));
			String[] from = (JSPUtil.getParameter(request, prefix	+ "from", length));
			String[] company = (JSPUtil.getParameter(request, prefix	+ "company", length));
			String[] day = (JSPUtil.getParameter(request, prefix	+ "day", length));
			String[] mtymvmt = (JSPUtil.getParameter(request, prefix	+ "mtymvmt", length));
			String[] bound = (JSPUtil.getParameter(request, prefix	+ "bound", length));
			String[] soc = (JSPUtil.getParameter(request, prefix	+ "soc", length));
			String[] vvdTp = (JSPUtil.getParameter(request, prefix + "vvd_tp",	length));
			String[] vvdNm = (JSPUtil.getParameter(request, prefix + "vvd_nm",	length));	
			String[] lstmcd = (JSPUtil.getParameter(request, prefix + "lstmcd",	length));	
			
			for (int i = 0; i < length; i++) {
				model = new MTYCNTRPERFSearchOptionVO();
				if (radioTpsz[i] != null)
					model.setRadioTpsz(radioTpsz[i]);
				if (dtlTpsz[i] != null)
					model.setDtlTpsz(dtlTpsz[i]);
				if (location[i] != null)
					model.setLocation(location[i]);
				if (period[i] != null)
					model.setPeriod(period[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (inquiryLevel[i] != null)
					model.setInquiryLevel(inquiryLevel[i]);
				if (to[i] != null)
					model.setTo(to[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tpsz[i] != null)
					model.setTpsz(tpsz[i]);
				if (from[i] != null)
					model.setFrom(from[i]);
				if (company[i] != null)
					model.setCompany(company[i]);
				if (day[i] != null)
					model.setDay(day[i]);
				if (mtymvmt[i] != null)
					model.setMtymvmt(mtymvmt[i]);
				if (bound[i] != null)
					model.setBound(bound[i]);
				if (soc[i] != null)
					model.setSoc(soc[i]);
				if ( vvdTp[i] !=	null)
					model.setVvdTp( vvdTp[i]);
				if ( vvdNm[i] !=	null)
					model.setVvdNm( vvdNm[i]);
				if ( lstmcd[i] !=	null)
					model.setLstmcd( lstmcd[i]);
				
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
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.radioTpsz = this.radioTpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlTpsz = this.dtlTpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.location = this.location .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.period = this.period .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inquiryLevel = this.inquiryLevel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.to = this.to .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsz = this.tpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.from = this.from .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.company = this.company .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.day = this.day .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtymvmt = this.mtymvmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bound = this.bound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soc = this.soc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdTp =	this.vvdTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdNm =	this.vvdNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmcd =	this.lstmcd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
