/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DailyforecastmanageConditionVO.java
*@FileTitle : DailyforecastmanageConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.08.24 한상훈 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo;

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
 * @author 한상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DailyforecastmanageConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DailyforecastmanageConditionVO> models = new ArrayList<DailyforecastmanageConditionVO>();
	
	/* Column Info */
	private String subtrade = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ioc = null;
	/* Column Info */
	private String trade = null;
	/* Column Info */
	private String salesrep = null;
	/* Column Info */
	private String bound = null;
	/* Column Info */
	private String lane = null;
	/* Page Number */
	private String pagerows = null;
	
	private String vslcd = null;
	private String skdvoyno = null;
	private String skddircd = null;
	private String salesOffice = null;
	private String ofckndcd = null;
	private String year = null;
	private String week = null;
	private String duration = null;
	private String vvd = null;
	private String subOffice = null;
	
	private String customer = null;
	private String custcntcd = null;
	private String custseq = null;
	
	private String fcastCustTpCd = null;	
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DailyforecastmanageConditionVO() {}

	public DailyforecastmanageConditionVO(String customer, String custcntcd, String custseq, String subOffice, String vvd, String vslcd, String skdvoyno, String skddircd, String salesOffice, String ofckndcd, String year, String week, String duration, String ibflag, String pagerows, String salesrep, String trade, String subtrade, String lane, String bound, String ioc, String fcastCustTpCd) {
		this.customer = customer;
		this.custcntcd = custcntcd;
		this.custseq = custseq;
		this.subOffice = subOffice;
		this.vvd = vvd;
		this.vslcd = vslcd;
		this.skdvoyno = skdvoyno;
		this.skddircd = skddircd;
		this.salesOffice = salesOffice;
		this.ofckndcd = ofckndcd;
		this.year = year;
		this.week = week;
		this.duration = duration;
		
		this.subtrade = subtrade;
		this.ibflag = ibflag;
		this.ioc = ioc;
		this.trade = trade;
		this.salesrep = salesrep;
		this.bound = bound;
		this.lane = lane;
		this.pagerows = pagerows;
		this.fcastCustTpCd = fcastCustTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("customer", getCustomer());
		this.hashColumns.put("custcntcd", getCustcntcd());
		this.hashColumns.put("custseq", getCustseq());
		
		this.hashColumns.put("subOffice", getSubOffice());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("vslcd", getVslcd());
		this.hashColumns.put("skdvoyno", getSkdvoyno());
		this.hashColumns.put("skddircd", getSkddircd());
		this.hashColumns.put("salesOffice", getSalesOffice());
		this.hashColumns.put("ofckndcd", getOfckndcd());
		this.hashColumns.put("year", getYear());
		this.hashColumns.put("week", getWeek());
		this.hashColumns.put("duration", getDuration());
		
		this.hashColumns.put("subTrade", getSubtrade());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ioc", getIoc());
		this.hashColumns.put("trade", getTrade());
		this.hashColumns.put("salesRep", getSalesrep());
		this.hashColumns.put("bound", getBound());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("pagerows", getPagerows());
		
		this.hashColumns.put("fcastCustTpCd", getFcastCustTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("customer", "customer");
		this.hashFields.put("custcntcd", "custcntcd");
		this.hashFields.put("custseq", "custseq");
		
		this.hashFields.put("subOffice", "subOffice");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("vslcd", "vslcd");
		this.hashFields.put("skdvoyno", "skdvoyno");
		this.hashFields.put("skddircd", "skddircd");
		this.hashFields.put("salesOffice", "salesOffice");
		this.hashFields.put("ofckndcd", "ofckndcd");
		this.hashFields.put("year", "year");
		this.hashFields.put("week", "week");
		this.hashFields.put("duration", "duration");
		
		this.hashFields.put("subTrade", "subTrade");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ioc", "ioc");
		this.hashFields.put("trade", "trade");
		this.hashFields.put("salesRep", "salesRep");
		this.hashFields.put("bound", "bound");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("pagerows", "pagerows");
		
		this.hashFields.put("fcastCustTpCd", "fcastCustTpCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return subtrade
	 */
	public String getSubtrade() {
		return this.subtrade;
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
	 * @return ioc
	 */
	public String getIoc() {
		return this.ioc;
	}
	
	/**
	 * Column Info
	 * @return trade
	 */
	public String getTrade() {
		return this.trade;
	}
	
	/**
	 * Column Info
	 * @return salesrep
	 */
	public String getSalesrep() {
		return this.salesrep;
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
	 * @return fcastCustTpCd
	 */
	public String getFcastCustTpCd() {
		return this.fcastCustTpCd;
	}
	

	/**
	 * Column Info
	 * @param subtrade
	 */
	public void setSubtrade(String subtrade) {
		this.subtrade = subtrade;
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
	 * @param ioc
	 */
	public void setIoc(String ioc) {
		this.ioc = ioc;
	}
	
	/**
	 * Column Info
	 * @param trade
	 */
	public void setTrade(String trade) {
		this.trade = trade;
	}
	
	/**
	 * Column Info
	 * @param salesrep
	 */
	public void setSalesrep(String salesrep) {
		this.salesrep = salesrep;
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
	
	public String getVslcd() {
		return vslcd;
	}

	public void setVslcd(String vslcd) {
		this.vslcd = vslcd;
	}

	public String getSkdvoyno() {
		return skdvoyno;
	}

	public void setSkdvoyno(String skdvoyno) {
		this.skdvoyno = skdvoyno;
	}

	public String getSkddircd() {
		return skddircd;
	}

	public void setSkddircd(String skddircd) {
		this.skddircd = skddircd;
	}

	public String getSalesOffice() {
		return salesOffice;
	}

	public void setSalesOffice(String salesOffice) {
		this.salesOffice = salesOffice;
	}

	public String getOfckndcd() {
		return ofckndcd;
	}

	public void setOfckndcd(String ofckndcd) {
		this.ofckndcd = ofckndcd;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getVvd() {
		return vvd;
	}

	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	public String getSubOffice() {
		return subOffice;
	}

	public void setSubOffice(String subOffice) {
		this.subOffice = subOffice;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getCustcntcd() {
		return custcntcd;
	}

	public void setCustcntcd(String custcntcd) {
		this.custcntcd = custcntcd;
	}

	public String getCustseq() {
		return custseq;
	}

	public void setCustseq(String custseq) {
		this.custseq = custseq;
	}
	
	/**
	 * Column Info
	 * @param fcastCustTpCd
	 */
	public void setFcastCustTpCd(String fcastCustTpCd) {
		this.fcastCustTpCd = fcastCustTpCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCustomer(JSPUtil.getParameter(request, "customer", ""));
		setCustcntcd(JSPUtil.getParameter(request, "custcntcd", ""));
		setCustseq(JSPUtil.getParameter(request, "custseq", ""));
		
		setSubOffice(JSPUtil.getParameter(request, "subOffice", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setVslcd(JSPUtil.getParameter(request, "vslcd", ""));
		setSkdvoyno(JSPUtil.getParameter(request, "skdvoyno", ""));
		setSkddircd(JSPUtil.getParameter(request, "skddircd", ""));
		setSalesOffice(JSPUtil.getParameter(request, "salesOffice", ""));
		setOfckndcd(JSPUtil.getParameter(request, "ofckndcd", ""));
		setYear(JSPUtil.getParameter(request, "year", ""));
		setWeek(JSPUtil.getParameter(request, "week", ""));
		setDuration(JSPUtil.getParameter(request, "duration", ""));
		
		setSubtrade(JSPUtil.getParameter(request, "subTrade", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setIoc(JSPUtil.getParameter(request, "ioc", ""));
		setTrade(JSPUtil.getParameter(request, "trade", ""));
		setSalesrep(JSPUtil.getParameter(request, "salesRep", ""));
		setBound(JSPUtil.getParameter(request, "bound", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		
		setFcastCustTpCd(JSPUtil.getParameter(request, "fcast_cust_tp_cd", ""));		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DailyforecastmanageConditionVO[]
	 */
	public DailyforecastmanageConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DailyforecastmanageConditionVO[]
	 */
	public DailyforecastmanageConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DailyforecastmanageConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] customer = (JSPUtil.getParameter(request, prefix	+ "customer", length));
			String[] custcntcd = (JSPUtil.getParameter(request, prefix	+ "custcntcd", length));
			String[] custseq = (JSPUtil.getParameter(request, prefix	+ "custseq", length));
			
			String[] subOffice = (JSPUtil.getParameter(request, prefix	+ "subOffice", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] vslcd = (JSPUtil.getParameter(request, prefix	+ "vslcd", length));
			String[] skdvoyno = (JSPUtil.getParameter(request, prefix	+ "skdvoyno", length));
			String[] skddircd = (JSPUtil.getParameter(request, prefix	+ "skddircd", length));
			String[] salesOffice = (JSPUtil.getParameter(request, prefix	+ "salesOffice", length));
			String[] ofckndcd = (JSPUtil.getParameter(request, prefix	+ "ofckndcd", length));
			String[] year = (JSPUtil.getParameter(request, prefix	+ "year", length));
			String[] week = (JSPUtil.getParameter(request, prefix	+ "week", length));
			String[] duration = (JSPUtil.getParameter(request, prefix	+ "duration", length));
						
			String[] subtrade = (JSPUtil.getParameter(request, prefix	+ "subtrade", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ioc = (JSPUtil.getParameter(request, prefix	+ "ioc", length));
			String[] trade = (JSPUtil.getParameter(request, prefix	+ "trade", length));
			String[] salesrep = (JSPUtil.getParameter(request, prefix	+ "salesrep", length));
			String[] bound = (JSPUtil.getParameter(request, prefix	+ "bound", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			String[] fcastCustTpCd = (JSPUtil.getParameter(request, prefix	+ "fcast_cust_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new DailyforecastmanageConditionVO();
				if (customer[i] != null)
					model.setCustomer(customer[i]);
				if (custcntcd[i] != null)
					model.setCustcntcd(custcntcd[i]);
				if (custseq[i] != null)
					model.setCustseq(custseq[i]);
				
				if (subOffice[i] != null)
					model.setSubOffice(subOffice[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (vslcd[i] != null)
					model.setVslcd(vslcd[i]);
				if (skdvoyno[i] != null)
					model.setSkdvoyno(skdvoyno[i]);
				if (skddircd[i] != null)
					model.setSkddircd(skddircd[i]);
				if (salesOffice[i] != null)
					model.setSalesOffice(salesOffice[i]);
				if (ofckndcd[i] != null)
					model.setOfckndcd(ofckndcd[i]);
				if (year[i] != null)
					model.setYear(year[i]);
				if (week[i] != null)
					model.setWeek(week[i]);
				if (duration[i] != null)
					model.setDuration(duration[i]);
				
				if (subtrade[i] != null)
					model.setSubtrade(subtrade[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ioc[i] != null)
					model.setIoc(ioc[i]);
				if (trade[i] != null)
					model.setTrade(trade[i]);
				if (salesrep[i] != null)
					model.setSalesrep(salesrep[i]);
				if (bound[i] != null)
					model.setBound(bound[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				
				if (fcastCustTpCd[i] != null)
					model.setFcastCustTpCd(fcastCustTpCd[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDailyforecastmanageConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DailyforecastmanageConditionVO[]
	 */
	public DailyforecastmanageConditionVO[] getDailyforecastmanageConditionVOs(){
		DailyforecastmanageConditionVO[] vos = (DailyforecastmanageConditionVO[])models.toArray(new DailyforecastmanageConditionVO[models.size()]);
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
		this.customer = this.customer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custcntcd = this.custcntcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custseq = this.custseq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.subOffice = this.subOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslcd = this.vslcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdvoyno = this.skdvoyno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skddircd = this.skddircd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.salesOffice = this.salesOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofckndcd = this.ofckndcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year = this.year .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.week = this.week .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duration = this.duration .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.subtrade = this.subtrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioc = this.ioc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trade = this.trade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.salesrep = this.salesrep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bound = this.bound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastCustTpCd = this.fcastCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
