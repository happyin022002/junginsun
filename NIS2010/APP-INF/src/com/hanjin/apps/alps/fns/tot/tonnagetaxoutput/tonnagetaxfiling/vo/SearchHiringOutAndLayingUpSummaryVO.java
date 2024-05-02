/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchHiringOutAndLayingUpSummaryVO.java
*@FileTitle : SearchHiringOutAndLayingUpSummaryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.23
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2010.12.23  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchHiringOutAndLayingUpSummaryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchHiringOutAndLayingUpSummaryVO> models = new ArrayList<SearchHiringOutAndLayingUpSummaryVO>();
	
	/* Column Info */
	private String nextEtdStart = null;
	/* Column Info */
	private String netRgstTongWgt = null;
	/* Column Info */
	private String etdEndNextDay = null;
	/* Column Info */
	private String laneCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String nextVslCd = null;
	/* Column Info */
	private String trade = null;
	/* Column Info */
	private String etdEnd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String amount = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String etdStart = null;
	/* Column Info */
	private String usage = null;
	/* Column Info */
	private String day = null;
	/* Column Info */
	private String perTonRev = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchHiringOutAndLayingUpSummaryVO() {}

	public SearchHiringOutAndLayingUpSummaryVO(String ibflag, String pagerows, String trade, String laneCd, String vslCd, String vslEngNm, String netRgstTongWgt, String etdStart, String etdEnd, String usage, String day, String amount, String perTonRev, String nextVslCd, String nextEtdStart, String etdEndNextDay) {
		this.nextEtdStart = nextEtdStart;
		this.netRgstTongWgt = netRgstTongWgt;
		this.etdEndNextDay = etdEndNextDay;
		this.laneCd = laneCd;
		this.vslCd = vslCd;
		this.nextVslCd = nextVslCd;
		this.trade = trade;
		this.etdEnd = etdEnd;
		this.pagerows = pagerows;
		this.amount = amount;
		this.ibflag = ibflag;
		this.vslEngNm = vslEngNm;
		this.etdStart = etdStart;
		this.usage = usage;
		this.day = day;
		this.perTonRev = perTonRev;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("next_etd_start", getNextEtdStart());
		this.hashColumns.put("net_rgst_tong_wgt", getNetRgstTongWgt());
		this.hashColumns.put("etd_end_next_day", getEtdEndNextDay());
		this.hashColumns.put("lane_cd", getLaneCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("next_vsl_cd", getNextVslCd());
		this.hashColumns.put("trade", getTrade());
		this.hashColumns.put("etd_end", getEtdEnd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("amount", getAmount());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("etd_start", getEtdStart());
		this.hashColumns.put("usage", getUsage());
		this.hashColumns.put("day", getDay());
		this.hashColumns.put("per_ton_rev", getPerTonRev());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("next_etd_start", "nextEtdStart");
		this.hashFields.put("net_rgst_tong_wgt", "netRgstTongWgt");
		this.hashFields.put("etd_end_next_day", "etdEndNextDay");
		this.hashFields.put("lane_cd", "laneCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("next_vsl_cd", "nextVslCd");
		this.hashFields.put("trade", "trade");
		this.hashFields.put("etd_end", "etdEnd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("amount", "amount");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("etd_start", "etdStart");
		this.hashFields.put("usage", "usage");
		this.hashFields.put("day", "day");
		this.hashFields.put("per_ton_rev", "perTonRev");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return nextEtdStart
	 */
	public String getNextEtdStart() {
		return this.nextEtdStart;
	}
	
	/**
	 * Column Info
	 * @return netRgstTongWgt
	 */
	public String getNetRgstTongWgt() {
		return this.netRgstTongWgt;
	}
	
	/**
	 * Column Info
	 * @return etdEndNextDay
	 */
	public String getEtdEndNextDay() {
		return this.etdEndNextDay;
	}
	
	/**
	 * Column Info
	 * @return laneCd
	 */
	public String getLaneCd() {
		return this.laneCd;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return nextVslCd
	 */
	public String getNextVslCd() {
		return this.nextVslCd;
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
	 * @return etdEnd
	 */
	public String getEtdEnd() {
		return this.etdEnd;
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
	 * @return amount
	 */
	public String getAmount() {
		return this.amount;
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
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return etdStart
	 */
	public String getEtdStart() {
		return this.etdStart;
	}
	
	/**
	 * Column Info
	 * @return usage
	 */
	public String getUsage() {
		return this.usage;
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
	 * @return perTonRev
	 */
	public String getPerTonRev() {
		return this.perTonRev;
	}
	

	/**
	 * Column Info
	 * @param nextEtdStart
	 */
	public void setNextEtdStart(String nextEtdStart) {
		this.nextEtdStart = nextEtdStart;
	}
	
	/**
	 * Column Info
	 * @param netRgstTongWgt
	 */
	public void setNetRgstTongWgt(String netRgstTongWgt) {
		this.netRgstTongWgt = netRgstTongWgt;
	}
	
	/**
	 * Column Info
	 * @param etdEndNextDay
	 */
	public void setEtdEndNextDay(String etdEndNextDay) {
		this.etdEndNextDay = etdEndNextDay;
	}
	
	/**
	 * Column Info
	 * @param laneCd
	 */
	public void setLaneCd(String laneCd) {
		this.laneCd = laneCd;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param nextVslCd
	 */
	public void setNextVslCd(String nextVslCd) {
		this.nextVslCd = nextVslCd;
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
	 * @param etdEnd
	 */
	public void setEtdEnd(String etdEnd) {
		this.etdEnd = etdEnd;
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
	 * @param amount
	 */
	public void setAmount(String amount) {
		this.amount = amount;
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
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param etdStart
	 */
	public void setEtdStart(String etdStart) {
		this.etdStart = etdStart;
	}
	
	/**
	 * Column Info
	 * @param usage
	 */
	public void setUsage(String usage) {
		this.usage = usage;
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
	 * @param perTonRev
	 */
	public void setPerTonRev(String perTonRev) {
		this.perTonRev = perTonRev;
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
		setNextEtdStart(JSPUtil.getParameter(request, prefix + "next_etd_start", ""));
		setNetRgstTongWgt(JSPUtil.getParameter(request, prefix + "net_rgst_tong_wgt", ""));
		setEtdEndNextDay(JSPUtil.getParameter(request, prefix + "etd_end_next_day", ""));
		setLaneCd(JSPUtil.getParameter(request, prefix + "lane_cd", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setNextVslCd(JSPUtil.getParameter(request, prefix + "next_vsl_cd", ""));
		setTrade(JSPUtil.getParameter(request, prefix + "trade", ""));
		setEtdEnd(JSPUtil.getParameter(request, prefix + "etd_end", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAmount(JSPUtil.getParameter(request, prefix + "amount", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
		setEtdStart(JSPUtil.getParameter(request, prefix + "etd_start", ""));
		setUsage(JSPUtil.getParameter(request, prefix + "usage", ""));
		setDay(JSPUtil.getParameter(request, prefix + "day", ""));
		setPerTonRev(JSPUtil.getParameter(request, prefix + "per_ton_rev", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchHiringOutAndLayingUpSummaryVO[]
	 */
	public SearchHiringOutAndLayingUpSummaryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchHiringOutAndLayingUpSummaryVO[]
	 */
	public SearchHiringOutAndLayingUpSummaryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchHiringOutAndLayingUpSummaryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] nextEtdStart = (JSPUtil.getParameter(request, prefix	+ "next_etd_start", length));
			String[] netRgstTongWgt = (JSPUtil.getParameter(request, prefix	+ "net_rgst_tong_wgt", length));
			String[] etdEndNextDay = (JSPUtil.getParameter(request, prefix	+ "etd_end_next_day", length));
			String[] laneCd = (JSPUtil.getParameter(request, prefix	+ "lane_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] nextVslCd = (JSPUtil.getParameter(request, prefix	+ "next_vsl_cd", length));
			String[] trade = (JSPUtil.getParameter(request, prefix	+ "trade", length));
			String[] etdEnd = (JSPUtil.getParameter(request, prefix	+ "etd_end", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] amount = (JSPUtil.getParameter(request, prefix	+ "amount", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] etdStart = (JSPUtil.getParameter(request, prefix	+ "etd_start", length));
			String[] usage = (JSPUtil.getParameter(request, prefix	+ "usage", length));
			String[] day = (JSPUtil.getParameter(request, prefix	+ "day", length));
			String[] perTonRev = (JSPUtil.getParameter(request, prefix	+ "per_ton_rev", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchHiringOutAndLayingUpSummaryVO();
				if (nextEtdStart[i] != null)
					model.setNextEtdStart(nextEtdStart[i]);
				if (netRgstTongWgt[i] != null)
					model.setNetRgstTongWgt(netRgstTongWgt[i]);
				if (etdEndNextDay[i] != null)
					model.setEtdEndNextDay(etdEndNextDay[i]);
				if (laneCd[i] != null)
					model.setLaneCd(laneCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (nextVslCd[i] != null)
					model.setNextVslCd(nextVslCd[i]);
				if (trade[i] != null)
					model.setTrade(trade[i]);
				if (etdEnd[i] != null)
					model.setEtdEnd(etdEnd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (amount[i] != null)
					model.setAmount(amount[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (etdStart[i] != null)
					model.setEtdStart(etdStart[i]);
				if (usage[i] != null)
					model.setUsage(usage[i]);
				if (day[i] != null)
					model.setDay(day[i]);
				if (perTonRev[i] != null)
					model.setPerTonRev(perTonRev[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchHiringOutAndLayingUpSummaryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchHiringOutAndLayingUpSummaryVO[]
	 */
	public SearchHiringOutAndLayingUpSummaryVO[] getSearchHiringOutAndLayingUpSummaryVOs(){
		SearchHiringOutAndLayingUpSummaryVO[] vos = (SearchHiringOutAndLayingUpSummaryVO[])models.toArray(new SearchHiringOutAndLayingUpSummaryVO[models.size()]);
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
		this.nextEtdStart = this.nextEtdStart .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netRgstTongWgt = this.netRgstTongWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdEndNextDay = this.etdEndNextDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneCd = this.laneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextVslCd = this.nextVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trade = this.trade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdEnd = this.etdEnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amount = this.amount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdStart = this.etdStart .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usage = this.usage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.day = this.day .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perTonRev = this.perTonRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
