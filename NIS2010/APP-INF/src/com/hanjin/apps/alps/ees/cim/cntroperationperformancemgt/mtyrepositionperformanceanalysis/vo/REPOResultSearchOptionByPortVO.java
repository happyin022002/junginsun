/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : REPOResultSearchOptionByPortVO.java
*@FileTitle : REPOResultSearchOptionByPortVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.05.26 박광석 
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

public class REPOResultSearchOptionByPortVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<REPOResultSearchOptionByPortVO> models = new ArrayList<REPOResultSearchOptionByPortVO>();
	
	/* Column Info */
	private String to = null;
	/* Column Info */
	private String tscntr = null;
	/* Column Info */
	private String through = null;
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
	private String vvd02 = null;
	/* Column Info */
	private String vvd03 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvd01 = null;
	/* Column Info */
	private String tpsz = null;
	/* Column Info */
	private String inquirywise = null;
	/* Column Info */
	private String company = null;
	/* Column Info */
	private String rcc01 = null;
	/* Column Info */
	private String directionwise = null;
	/* Column Info */
	private String rdtype = null;
	/* Column Info */
	private String soc = null;
	/* Column Info */
	private String port01 = null;
	/* Column Info */
	private String rcc02 = null;
	/* Column Info */
	private String option = null;
	/* Column Info */
	private String vvd04 = null;
	/* Column Info */
	private String port02 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public REPOResultSearchOptionByPortVO() {}

	/**
	 * 
	 * @param ibflag
	 * @param pagerows
	 * @param option
	 * @param period
	 * @param from
	 * @param to
	 * @param lane
	 * @param vvd01
	 * @param vvd02
	 * @param vvd03
	 * @param vvd04
	 * @param tpsz
	 * @param rdtype
	 * @param tscntr
	 * @param through
	 * @param directionwise
	 * @param inquirywise
	 * @param rcc01
	 * @param rcc02
	 * @param port01
	 * @param port02
	 * @param cargotype
	 * @param soc
	 * @param company
	 */
	public REPOResultSearchOptionByPortVO(String ibflag, String pagerows, String option, String period, String from, String to, String lane, String vvd01, String vvd02, String vvd03, String vvd04, String tpsz, String rdtype, String tscntr, String through, String directionwise, String inquirywise, String rcc01, String rcc02, String port01, String port02, String cargotype, String soc, String company) {
		this.to = to;
		this.tscntr = tscntr;
		this.through = through;
		this.from = from;
		this.period = period;
		this.cargotype = cargotype;
		this.pagerows = pagerows;
		this.lane = lane;
		this.vvd02 = vvd02;
		this.vvd03 = vvd03;
		this.ibflag = ibflag;
		this.vvd01 = vvd01;
		this.tpsz = tpsz;
		this.inquirywise = inquirywise;
		this.company = company;
		this.rcc01 = rcc01;
		this.directionwise = directionwise;
		this.rdtype = rdtype;
		this.soc = soc;
		this.port01 = port01;
		this.rcc02 = rcc02;
		this.option = option;
		this.vvd04 = vvd04;
		this.port02 = port02;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to", getTo());
		this.hashColumns.put("tscntr", getTscntr());
		this.hashColumns.put("through", getThrough());
		this.hashColumns.put("from", getFrom());
		this.hashColumns.put("period", getPeriod());
		this.hashColumns.put("cargotype", getCargotype());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("vvd02", getVvd02());
		this.hashColumns.put("vvd03", getVvd03());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd01", getVvd01());
		this.hashColumns.put("tpsz", getTpsz());
		this.hashColumns.put("inquirywise", getInquirywise());
		this.hashColumns.put("company", getCompany());
		this.hashColumns.put("rcc01", getRcc01());
		this.hashColumns.put("directionwise", getDirectionwise());
		this.hashColumns.put("rdtype", getRdtype());
		this.hashColumns.put("soc", getSoc());
		this.hashColumns.put("port01", getPort01());
		this.hashColumns.put("rcc02", getRcc02());
		this.hashColumns.put("option", getOption());
		this.hashColumns.put("vvd04", getVvd04());
		this.hashColumns.put("port02", getPort02());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to", "to");
		this.hashFields.put("tscntr", "tscntr");
		this.hashFields.put("through", "through");
		this.hashFields.put("from", "from");
		this.hashFields.put("period", "period");
		this.hashFields.put("cargotype", "cargotype");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("vvd02", "vvd02");
		this.hashFields.put("vvd03", "vvd03");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd01", "vvd01");
		this.hashFields.put("tpsz", "tpsz");
		this.hashFields.put("inquirywise", "inquirywise");
		this.hashFields.put("company", "company");
		this.hashFields.put("rcc01", "rcc01");
		this.hashFields.put("directionwise", "directionwise");
		this.hashFields.put("rdtype", "rdtype");
		this.hashFields.put("soc", "soc");
		this.hashFields.put("port01", "port01");
		this.hashFields.put("rcc02", "rcc02");
		this.hashFields.put("option", "option");
		this.hashFields.put("vvd04", "vvd04");
		this.hashFields.put("port02", "port02");
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
	 * @return through
	 */
	public String getThrough() {
		return this.through;
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
	 * @return vvd02
	 */
	public String getVvd02() {
		return this.vvd02;
	}
	
	/**
	 * Column Info
	 * @return vvd03
	 */
	public String getVvd03() {
		return this.vvd03;
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
	 * @return vvd01
	 */
	public String getVvd01() {
		return this.vvd01;
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
	 * @return rcc01
	 */
	public String getRcc01() {
		return this.rcc01;
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
	 * @return soc
	 */
	public String getSoc() {
		return this.soc;
	}
	
	/**
	 * Column Info
	 * @return port01
	 */
	public String getPort01() {
		return this.port01;
	}
	
	/**
	 * Column Info
	 * @return rcc02
	 */
	public String getRcc02() {
		return this.rcc02;
	}
	
	/**
	 * Column Info
	 * @return option
	 */
	public String getOption() {
		return this.option;
	}
	
	/**
	 * Column Info
	 * @return vvd04
	 */
	public String getVvd04() {
		return this.vvd04;
	}
	
	/**
	 * Column Info
	 * @return port02
	 */
	public String getPort02() {
		return this.port02;
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
	 * @param through
	 */
	public void setThrough(String through) {
		this.through = through;
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
	 * @param vvd02
	 */
	public void setVvd02(String vvd02) {
		this.vvd02 = vvd02;
	}
	
	/**
	 * Column Info
	 * @param vvd03
	 */
	public void setVvd03(String vvd03) {
		this.vvd03 = vvd03;
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
	 * @param vvd01
	 */
	public void setVvd01(String vvd01) {
		this.vvd01 = vvd01;
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
	 * @param rcc01
	 */
	public void setRcc01(String rcc01) {
		this.rcc01 = rcc01;
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
	 * @param soc
	 */
	public void setSoc(String soc) {
		this.soc = soc;
	}
	
	/**
	 * Column Info
	 * @param port01
	 */
	public void setPort01(String port01) {
		this.port01 = port01;
	}
	
	/**
	 * Column Info
	 * @param rcc02
	 */
	public void setRcc02(String rcc02) {
		this.rcc02 = rcc02;
	}
	
	/**
	 * Column Info
	 * @param option
	 */
	public void setOption(String option) {
		this.option = option;
	}
	
	/**
	 * Column Info
	 * @param vvd04
	 */
	public void setVvd04(String vvd04) {
		this.vvd04 = vvd04;
	}
	
	/**
	 * Column Info
	 * @param port02
	 */
	public void setPort02(String port02) {
		this.port02 = port02;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTo(JSPUtil.getParameter(request, "to", ""));
		setTscntr(JSPUtil.getParameter(request, "tscntr", ""));
		setThrough(JSPUtil.getParameter(request, "through", ""));
		setFrom(JSPUtil.getParameter(request, "from", ""));
		setPeriod(JSPUtil.getParameter(request, "period", ""));
		setCargotype(JSPUtil.getParameter(request, "cargotype", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setVvd02(JSPUtil.getParameter(request, "vvd02", ""));
		setVvd03(JSPUtil.getParameter(request, "vvd03", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVvd01(JSPUtil.getParameter(request, "vvd01", ""));
		setTpsz(JSPUtil.getParameter(request, "tpsz", ""));
		setInquirywise(JSPUtil.getParameter(request, "inquirywise", ""));
		setCompany(JSPUtil.getParameter(request, "company", ""));
		setRcc01(JSPUtil.getParameter(request, "rcc01", ""));
		setDirectionwise(JSPUtil.getParameter(request, "directionwise", ""));
		setRdtype(JSPUtil.getParameter(request, "rdtype", ""));
		setSoc(JSPUtil.getParameter(request, "soc", ""));
		setPort01(JSPUtil.getParameter(request, "port01", ""));
		setRcc02(JSPUtil.getParameter(request, "rcc02", ""));
		setOption(JSPUtil.getParameter(request, "option", ""));
		setVvd04(JSPUtil.getParameter(request, "vvd04", ""));
		setPort02(JSPUtil.getParameter(request, "port02", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return REPOResultSearchOptionByPortVO[]
	 */
	public REPOResultSearchOptionByPortVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return REPOResultSearchOptionByPortVO[]
	 */
	public REPOResultSearchOptionByPortVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		REPOResultSearchOptionByPortVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] to = (JSPUtil.getParameter(request, prefix	+ "to".trim(), length));
			String[] tscntr = (JSPUtil.getParameter(request, prefix	+ "tscntr".trim(), length));
			String[] through = (JSPUtil.getParameter(request, prefix	+ "through".trim(), length));
			String[] from = (JSPUtil.getParameter(request, prefix	+ "from".trim(), length));
			String[] period = (JSPUtil.getParameter(request, prefix	+ "period".trim(), length));
			String[] cargotype = (JSPUtil.getParameter(request, prefix	+ "cargotype".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane".trim(), length));
			String[] vvd02 = (JSPUtil.getParameter(request, prefix	+ "vvd02".trim(), length));
			String[] vvd03 = (JSPUtil.getParameter(request, prefix	+ "vvd03".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] vvd01 = (JSPUtil.getParameter(request, prefix	+ "vvd01".trim(), length));
			String[] tpsz = (JSPUtil.getParameter(request, prefix	+ "tpsz".trim(), length));
			String[] inquirywise = (JSPUtil.getParameter(request, prefix	+ "inquirywise".trim(), length));
			String[] company = (JSPUtil.getParameter(request, prefix	+ "company".trim(), length));
			String[] rcc01 = (JSPUtil.getParameter(request, prefix	+ "rcc01".trim(), length));
			String[] directionwise = (JSPUtil.getParameter(request, prefix	+ "directionwise".trim(), length));
			String[] rdtype = (JSPUtil.getParameter(request, prefix	+ "rdtype".trim(), length));
			String[] soc = (JSPUtil.getParameter(request, prefix	+ "soc".trim(), length));
			String[] port01 = (JSPUtil.getParameter(request, prefix	+ "port01".trim(), length));
			String[] rcc02 = (JSPUtil.getParameter(request, prefix	+ "rcc02".trim(), length));
			String[] option = (JSPUtil.getParameter(request, prefix	+ "option".trim(), length));
			String[] vvd04 = (JSPUtil.getParameter(request, prefix	+ "vvd04".trim(), length));
			String[] port02 = (JSPUtil.getParameter(request, prefix	+ "port02".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new REPOResultSearchOptionByPortVO();
				if (to[i] != null)
					model.setTo(to[i]);
				if (tscntr[i] != null)
					model.setTscntr(tscntr[i]);
				if (through[i] != null)
					model.setThrough(through[i]);
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
				if (vvd02[i] != null)
					model.setVvd02(vvd02[i]);
				if (vvd03[i] != null)
					model.setVvd03(vvd03[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvd01[i] != null)
					model.setVvd01(vvd01[i]);
				if (tpsz[i] != null)
					model.setTpsz(tpsz[i]);
				if (inquirywise[i] != null)
					model.setInquirywise(inquirywise[i]);
				if (company[i] != null)
					model.setCompany(company[i]);
				if (rcc01[i] != null)
					model.setRcc01(rcc01[i]);
				if (directionwise[i] != null)
					model.setDirectionwise(directionwise[i]);
				if (rdtype[i] != null)
					model.setRdtype(rdtype[i]);
				if (soc[i] != null)
					model.setSoc(soc[i]);
				if (port01[i] != null)
					model.setPort01(port01[i]);
				if (rcc02[i] != null)
					model.setRcc02(rcc02[i]);
				if (option[i] != null)
					model.setOption(option[i]);
				if (vvd04[i] != null)
					model.setVvd04(vvd04[i]);
				if (port02[i] != null)
					model.setPort02(port02[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getREPOResultSearchOptionByPortVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return REPOResultSearchOptionByPortVO[]
	 */
	public REPOResultSearchOptionByPortVO[] getREPOResultSearchOptionByPortVOs(){
		REPOResultSearchOptionByPortVO[] vos = (REPOResultSearchOptionByPortVO[])models.toArray(new REPOResultSearchOptionByPortVO[models.size()]);
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
		this.through = this.through .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.from = this.from .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.period = this.period .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargotype = this.cargotype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd02 = this.vvd02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd03 = this.vvd03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd01 = this.vvd01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsz = this.tpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inquirywise = this.inquirywise .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.company = this.company .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcc01 = this.rcc01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.directionwise = this.directionwise .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdtype = this.rdtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soc = this.soc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port01 = this.port01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcc02 = this.rcc02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.option = this.option .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd04 = this.vvd04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port02 = this.port02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
