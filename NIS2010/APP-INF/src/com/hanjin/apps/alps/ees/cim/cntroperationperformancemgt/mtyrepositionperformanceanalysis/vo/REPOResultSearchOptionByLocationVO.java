/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : REPOResultSearchOptionByLocationVO.java
*@FileTitle : REPOResultSearchOptionByLocationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.05.28 박광석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo;

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
 * @author 박광석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class REPOResultSearchOptionByLocationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<REPOResultSearchOptionByLocationVO> models = new ArrayList<REPOResultSearchOptionByLocationVO>();
	
	/* Column Info */
	private String to = null;
	/* Column Info */
	private String from = null;
	/* Column Info */
	private String period = null;
	/* Column Info */
	private String cargotype = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String inquirylevel = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tpsz = null;
	/* Column Info */
	private String inquirywise = null;
	/* Column Info */
	private String company = null;
	/* Column Info */
	private String directionwise = null;
	/* Column Info */
	private String rdtype = null;
	/* Column Info */
	private String loccode2 = null;
	/* Column Info */
	private String rcc = null;
	/* Column Info */
	private String loccode1 = null;
	/* Column Info */
	private String soc = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public REPOResultSearchOptionByLocationVO() {}

	/**
	 * 
	 * @param ibflag
	 * @param pagerows
	 * @param period
	 * @param from
	 * @param to
	 * @param tpsz
	 * @param rdtype
	 * @param directionwise
	 * @param inquirywise
	 * @param rcc
	 * @param loccode1
	 * @param loccode2
	 * @param inquirylevel
	 * @param cargotype
	 * @param soc
	 * @param company
	 */
	public REPOResultSearchOptionByLocationVO(String ibflag, String pagerows, String period, String from, String to, String tpsz, String rdtype, String directionwise, String inquirywise, String rcc, String loccode1, String loccode2, String inquirylevel, String cargotype, String soc, String company) {
		this.to = to;
		this.from = from;
		this.period = period;
		this.cargotype = cargotype;
		this.pagerows = pagerows;
		this.inquirylevel = inquirylevel;
		this.ibflag = ibflag;
		this.tpsz = tpsz;
		this.inquirywise = inquirywise;
		this.company = company;
		this.directionwise = directionwise;
		this.rdtype = rdtype;
		this.loccode2 = loccode2;
		this.rcc = rcc;
		this.loccode1 = loccode1;
		this.soc = soc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to", getTo());
		this.hashColumns.put("from", getFrom());
		this.hashColumns.put("period", getPeriod());
		this.hashColumns.put("cargotype", getCargotype());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inquirylevel", getInquirylevel());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tpsz", getTpsz());
		this.hashColumns.put("inquirywise", getInquirywise());
		this.hashColumns.put("company", getCompany());
		this.hashColumns.put("directionwise", getDirectionwise());
		this.hashColumns.put("rdtype", getRdtype());
		this.hashColumns.put("loccode2", getLoccode2());
		this.hashColumns.put("rcc", getRcc());
		this.hashColumns.put("loccode1", getLoccode1());
		this.hashColumns.put("soc", getSoc());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to", "to");
		this.hashFields.put("from", "from");
		this.hashFields.put("period", "period");
		this.hashFields.put("cargotype", "cargotype");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inquirylevel", "inquirylevel");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tpsz", "tpsz");
		this.hashFields.put("inquirywise", "inquirywise");
		this.hashFields.put("company", "company");
		this.hashFields.put("directionwise", "directionwise");
		this.hashFields.put("rdtype", "rdtype");
		this.hashFields.put("loccode2", "loccode2");
		this.hashFields.put("rcc", "rcc");
		this.hashFields.put("loccode1", "loccode1");
		this.hashFields.put("soc", "soc");
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
	 * @return inquirylevel
	 */
	public String getInquirylevel() {
		return this.inquirylevel;
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
	 * @return inquirywise
	 */
	public String getInquirywise() {
		return this.inquirywise;
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
	 * @return directionwise
	 */
	public String getDirectionwise() {
		return this.directionwise;
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
	 * @return loccode2
	 */
	public String getLoccode2() {
		return this.loccode2;
	}
	
	/**
	 * Column Info
	 * @return rcc
	 */
	public String getRcc() {
		return this.rcc;
	}
	
	/**
	 * Column Info
	 * @return loccode1
	 */
	public String getLoccode1() {
		return this.loccode1;
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
	 * @param inquirylevel
	 */
	public void setInquirylevel(String inquirylevel) {
		this.inquirylevel = inquirylevel;
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
	 * @param inquirywise
	 */
	public void setInquirywise(String inquirywise) {
		this.inquirywise = inquirywise;
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
	 * @param directionwise
	 */
	public void setDirectionwise(String directionwise) {
		this.directionwise = directionwise;
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
	 * @param loccode2
	 */
	public void setLoccode2(String loccode2) {
		this.loccode2 = loccode2;
	}
	
	/**
	 * Column Info
	 * @param rcc
	 */
	public void setRcc(String rcc) {
		this.rcc = rcc;
	}
	
	/**
	 * Column Info
	 * @param loccode1
	 */
	public void setLoccode1(String loccode1) {
		this.loccode1 = loccode1;
	}
	
	/**
	 * Column Info
	 * @param soc
	 */
	public void setSoc(String soc) {
		this.soc = soc;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTo(JSPUtil.getParameter(request, "to", ""));
		setFrom(JSPUtil.getParameter(request, "from", ""));
		setPeriod(JSPUtil.getParameter(request, "period", ""));
		setCargotype(JSPUtil.getParameter(request, "cargotype", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setInquirylevel(JSPUtil.getParameter(request, "inquirylevel", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTpsz(JSPUtil.getParameter(request, "tpsz", ""));
		setInquirywise(JSPUtil.getParameter(request, "inquirywise", ""));
		setCompany(JSPUtil.getParameter(request, "company", ""));
		setDirectionwise(JSPUtil.getParameter(request, "directionwise", ""));
		setRdtype(JSPUtil.getParameter(request, "rdtype", ""));
		setLoccode2(JSPUtil.getParameter(request, "loccode2", ""));
		setRcc(JSPUtil.getParameter(request, "rcc", ""));
		setLoccode1(JSPUtil.getParameter(request, "loccode1", ""));
		setSoc(JSPUtil.getParameter(request, "soc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return REPOResultSearchOptionByLocationVO[]
	 */
	public REPOResultSearchOptionByLocationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return REPOResultSearchOptionByLocationVO[]
	 */
	public REPOResultSearchOptionByLocationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		REPOResultSearchOptionByLocationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] to = (JSPUtil.getParameter(request, prefix	+ "to".trim(), length));
			String[] from = (JSPUtil.getParameter(request, prefix	+ "from".trim(), length));
			String[] period = (JSPUtil.getParameter(request, prefix	+ "period".trim(), length));
			String[] cargotype = (JSPUtil.getParameter(request, prefix	+ "cargotype".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] inquirylevel = (JSPUtil.getParameter(request, prefix	+ "inquirylevel".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] tpsz = (JSPUtil.getParameter(request, prefix	+ "tpsz".trim(), length));
			String[] inquirywise = (JSPUtil.getParameter(request, prefix	+ "inquirywise".trim(), length));
			String[] company = (JSPUtil.getParameter(request, prefix	+ "company".trim(), length));
			String[] directionwise = (JSPUtil.getParameter(request, prefix	+ "directionwise".trim(), length));
			String[] rdtype = (JSPUtil.getParameter(request, prefix	+ "rdtype".trim(), length));
			String[] loccode2 = (JSPUtil.getParameter(request, prefix	+ "loccode2".trim(), length));
			String[] rcc = (JSPUtil.getParameter(request, prefix	+ "rcc".trim(), length));
			String[] loccode1 = (JSPUtil.getParameter(request, prefix	+ "loccode1".trim(), length));
			String[] soc = (JSPUtil.getParameter(request, prefix	+ "soc".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new REPOResultSearchOptionByLocationVO();
				if (to[i] != null)
					model.setTo(to[i]);
				if (from[i] != null)
					model.setFrom(from[i]);
				if (period[i] != null)
					model.setPeriod(period[i]);
				if (cargotype[i] != null)
					model.setCargotype(cargotype[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (inquirylevel[i] != null)
					model.setInquirylevel(inquirylevel[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tpsz[i] != null)
					model.setTpsz(tpsz[i]);
				if (inquirywise[i] != null)
					model.setInquirywise(inquirywise[i]);
				if (company[i] != null)
					model.setCompany(company[i]);
				if (directionwise[i] != null)
					model.setDirectionwise(directionwise[i]);
				if (rdtype[i] != null)
					model.setRdtype(rdtype[i]);
				if (loccode2[i] != null)
					model.setLoccode2(loccode2[i]);
				if (rcc[i] != null)
					model.setRcc(rcc[i]);
				if (loccode1[i] != null)
					model.setLoccode1(loccode1[i]);
				if (soc[i] != null)
					model.setSoc(soc[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getREPOResultSearchOptionByLocations();
	}

	/**
	 * VO 배열을 반환
	 * @return REPOResultSearchOptionByLocationVO[]
	 */
	public REPOResultSearchOptionByLocationVO[] getREPOResultSearchOptionByLocations(){
		REPOResultSearchOptionByLocationVO[] vos = (REPOResultSearchOptionByLocationVO[])models.toArray(new REPOResultSearchOptionByLocationVO[models.size()]);
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
		this.from = this.from .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.period = this.period .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargotype = this.cargotype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inquirylevel = this.inquirylevel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsz = this.tpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inquirywise = this.inquirywise .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.company = this.company .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.directionwise = this.directionwise .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdtype = this.rdtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loccode2 = this.loccode2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcc = this.rcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loccode1 = this.loccode1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soc = this.soc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
