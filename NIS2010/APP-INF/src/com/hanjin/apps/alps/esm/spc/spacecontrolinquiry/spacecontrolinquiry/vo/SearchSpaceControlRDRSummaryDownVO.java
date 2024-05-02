/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchSpaceControlRDRSummaryDownVO.java
*@FileTitle : SearchSpaceControlRDRSummaryDownVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.05
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2011.07.05 최윤성 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo;

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
 * @author 최윤성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSpaceControlRDRSummaryDownVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSpaceControlRDRSummaryDownVO> models = new ArrayList<SearchSpaceControlRDRSummaryDownVO>();
	
	/* Column Info */
	private String trade = null;
	/* Column Info */
	private String operator = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lane = null;
	/* Column Info */
	private String ttlLoad = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ttlWgt = null;
	/* Column Info */
	private String fullLf = null;
	/* Column Info */
	private String full = null;
	/* Column Info */
	private String bsa = null;
	/* Column Info */
	private String ttlLf = null;
	/* Column Info */
	private String subTrade = null;
	/* Column Info */
	private String mty = null;
	/* Column Info */
	private String bound = null;
	/* Column Info */
	private String week = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSpaceControlRDRSummaryDownVO() {}

	public SearchSpaceControlRDRSummaryDownVO(String ibflag, String pagerows, String operator, String week, String trade, String subTrade, String lane, String vvd, String bound, String bsa, String full, String mty, String ttlLoad, String ttlWgt, String fullLf, String ttlLf) {
		this.trade = trade;
		this.operator = operator;
		this.pagerows = pagerows;
		this.lane = lane;
		this.ttlLoad = ttlLoad;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.ttlWgt = ttlWgt;
		this.fullLf = fullLf;
		this.full = full;
		this.bsa = bsa;
		this.ttlLf = ttlLf;
		this.subTrade = subTrade;
		this.mty = mty;
		this.bound = bound;
		this.week = week;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("trade", getTrade());
		this.hashColumns.put("operator", getOperator());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("ttl_load", getTtlLoad());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ttl_wgt", getTtlWgt());
		this.hashColumns.put("full_lf", getFullLf());
		this.hashColumns.put("full", getFull());
		this.hashColumns.put("bsa", getBsa());
		this.hashColumns.put("ttl_lf", getTtlLf());
		this.hashColumns.put("sub_trade", getSubTrade());
		this.hashColumns.put("mty", getMty());
		this.hashColumns.put("bound", getBound());
		this.hashColumns.put("week", getWeek());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("trade", "trade");
		this.hashFields.put("operator", "operator");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("ttl_load", "ttlLoad");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ttl_wgt", "ttlWgt");
		this.hashFields.put("full_lf", "fullLf");
		this.hashFields.put("full", "full");
		this.hashFields.put("bsa", "bsa");
		this.hashFields.put("ttl_lf", "ttlLf");
		this.hashFields.put("sub_trade", "subTrade");
		this.hashFields.put("mty", "mty");
		this.hashFields.put("bound", "bound");
		this.hashFields.put("week", "week");
		return this.hashFields;
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
	 * @return operator
	 */
	public String getOperator() {
		return this.operator;
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
	 * @return ttlLoad
	 */
	public String getTtlLoad() {
		return this.ttlLoad;
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
	 * @return ttlWgt
	 */
	public String getTtlWgt() {
		return this.ttlWgt;
	}
	
	/**
	 * Column Info
	 * @return fullLf
	 */
	public String getFullLf() {
		return this.fullLf;
	}
	
	/**
	 * Column Info
	 * @return full
	 */
	public String getFull() {
		return this.full;
	}
	
	/**
	 * Column Info
	 * @return bsa
	 */
	public String getBsa() {
		return this.bsa;
	}
	
	/**
	 * Column Info
	 * @return ttlLf
	 */
	public String getTtlLf() {
		return this.ttlLf;
	}
	
	/**
	 * Column Info
	 * @return subTrade
	 */
	public String getSubTrade() {
		return this.subTrade;
	}
	
	/**
	 * Column Info
	 * @return mty
	 */
	public String getMty() {
		return this.mty;
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
	 * @return week
	 */
	public String getWeek() {
		return this.week;
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
	 * @param operator
	 */
	public void setOperator(String operator) {
		this.operator = operator;
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
	 * @param ttlLoad
	 */
	public void setTtlLoad(String ttlLoad) {
		this.ttlLoad = ttlLoad;
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
	 * @param ttlWgt
	 */
	public void setTtlWgt(String ttlWgt) {
		this.ttlWgt = ttlWgt;
	}
	
	/**
	 * Column Info
	 * @param fullLf
	 */
	public void setFullLf(String fullLf) {
		this.fullLf = fullLf;
	}
	
	/**
	 * Column Info
	 * @param full
	 */
	public void setFull(String full) {
		this.full = full;
	}
	
	/**
	 * Column Info
	 * @param bsa
	 */
	public void setBsa(String bsa) {
		this.bsa = bsa;
	}
	
	/**
	 * Column Info
	 * @param ttlLf
	 */
	public void setTtlLf(String ttlLf) {
		this.ttlLf = ttlLf;
	}
	
	/**
	 * Column Info
	 * @param subTrade
	 */
	public void setSubTrade(String subTrade) {
		this.subTrade = subTrade;
	}
	
	/**
	 * Column Info
	 * @param mty
	 */
	public void setMty(String mty) {
		this.mty = mty;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setTrade(JSPUtil.getParameter(request, prefix + "trade", ""));
		setOperator(JSPUtil.getParameter(request, prefix + "operator", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setLane(JSPUtil.getParameter(request, prefix + "lane", ""));
		setTtlLoad(JSPUtil.getParameter(request, prefix + "ttl_load", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTtlWgt(JSPUtil.getParameter(request, prefix + "ttl_wgt", ""));
		setFullLf(JSPUtil.getParameter(request, prefix + "full_lf", ""));
		setFull(JSPUtil.getParameter(request, prefix + "full", ""));
		setBsa(JSPUtil.getParameter(request, prefix + "bsa", ""));
		setTtlLf(JSPUtil.getParameter(request, prefix + "ttl_lf", ""));
		setSubTrade(JSPUtil.getParameter(request, prefix + "sub_trade", ""));
		setMty(JSPUtil.getParameter(request, prefix + "mty", ""));
		setBound(JSPUtil.getParameter(request, prefix + "bound", ""));
		setWeek(JSPUtil.getParameter(request, prefix + "week", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSpaceControlRDRSummaryDownVO[]
	 */
	public SearchSpaceControlRDRSummaryDownVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSpaceControlRDRSummaryDownVO[]
	 */
	public SearchSpaceControlRDRSummaryDownVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSpaceControlRDRSummaryDownVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] trade = (JSPUtil.getParameter(request, prefix	+ "trade", length));
			String[] operator = (JSPUtil.getParameter(request, prefix	+ "operator", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] ttlLoad = (JSPUtil.getParameter(request, prefix	+ "ttl_load", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ttlWgt = (JSPUtil.getParameter(request, prefix	+ "ttl_wgt", length));
			String[] fullLf = (JSPUtil.getParameter(request, prefix	+ "full_lf", length));
			String[] full = (JSPUtil.getParameter(request, prefix	+ "full", length));
			String[] bsa = (JSPUtil.getParameter(request, prefix	+ "bsa", length));
			String[] ttlLf = (JSPUtil.getParameter(request, prefix	+ "ttl_lf", length));
			String[] subTrade = (JSPUtil.getParameter(request, prefix	+ "sub_trade", length));
			String[] mty = (JSPUtil.getParameter(request, prefix	+ "mty", length));
			String[] bound = (JSPUtil.getParameter(request, prefix	+ "bound", length));
			String[] week = (JSPUtil.getParameter(request, prefix	+ "week", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSpaceControlRDRSummaryDownVO();
				if (trade[i] != null)
					model.setTrade(trade[i]);
				if (operator[i] != null)
					model.setOperator(operator[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (ttlLoad[i] != null)
					model.setTtlLoad(ttlLoad[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ttlWgt[i] != null)
					model.setTtlWgt(ttlWgt[i]);
				if (fullLf[i] != null)
					model.setFullLf(fullLf[i]);
				if (full[i] != null)
					model.setFull(full[i]);
				if (bsa[i] != null)
					model.setBsa(bsa[i]);
				if (ttlLf[i] != null)
					model.setTtlLf(ttlLf[i]);
				if (subTrade[i] != null)
					model.setSubTrade(subTrade[i]);
				if (mty[i] != null)
					model.setMty(mty[i]);
				if (bound[i] != null)
					model.setBound(bound[i]);
				if (week[i] != null)
					model.setWeek(week[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSpaceControlRDRSummaryDownVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSpaceControlRDRSummaryDownVO[]
	 */
	public SearchSpaceControlRDRSummaryDownVO[] getSearchSpaceControlRDRSummaryDownVOs(){
		SearchSpaceControlRDRSummaryDownVO[] vos = (SearchSpaceControlRDRSummaryDownVO[])models.toArray(new SearchSpaceControlRDRSummaryDownVO[models.size()]);
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
		this.trade = this.trade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.operator = this.operator .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLoad = this.ttlLoad .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlWgt = this.ttlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullLf = this.fullLf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.full = this.full .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa = this.bsa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLf = this.ttlLf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrade = this.subTrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mty = this.mty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bound = this.bound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.week = this.week .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
