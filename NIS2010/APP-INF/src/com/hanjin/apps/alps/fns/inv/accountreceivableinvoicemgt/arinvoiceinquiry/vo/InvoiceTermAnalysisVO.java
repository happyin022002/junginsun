/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceTermAnalysisVO.java
*@FileTitle : InvoiceTermAnalysisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.15
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.07.15 박정진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo;

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
 * @author 박정진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvoiceTermAnalysisVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvoiceTermAnalysisVO> models = new ArrayList<InvoiceTermAnalysisVO>();
	
	/* Column Info */
	private String office = null;
	/* Column Info */
	private String average1020 = null;
	/* Column Info */
	private String average010 = null;
	/* Column Info */
	private String cnt3040 = null;
	/* Column Info */
	private String cnt010 = null;
	/* Column Info */
	private String average2030 = null;
	/* Column Info */
	private String overCnt = null;
	/* Column Info */
	private String cnt2030 = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cnt100 = null;
	/* Column Info */
	private String over = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String average3040 = null;
	/* Column Info */
	private String average100 = null;
	/* Column Info */
	private String month = null;
	/* Column Info */
	private String below = null;
	/* Column Info */
	private String average4050 = null;
	/* Column Info */
	private String belowCnt = null;
	/* Column Info */
	private String cnt4050 = null;
	/* Column Info */
	private String totalAverage = null;
	/* Column Info */
	private String cnt1020 = null;
	/* Column Info */
	private String totalCnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvoiceTermAnalysisVO() {}

	public InvoiceTermAnalysisVO(String ibflag, String pagerows, String office, String month, String ioBndCd, String totalAverage, String totalCnt, String below, String belowCnt, String average100, String cnt100, String average010, String cnt010, String average1020, String cnt1020, String average2030, String cnt2030, String average3040, String cnt3040, String average4050, String cnt4050, String over, String overCnt) {
		this.office = office;
		this.average1020 = average1020;
		this.average010 = average010;
		this.cnt3040 = cnt3040;
		this.cnt010 = cnt010;
		this.average2030 = average2030;
		this.overCnt = overCnt;
		this.cnt2030 = cnt2030;
		this.ioBndCd = ioBndCd;
		this.pagerows = pagerows;
		this.cnt100 = cnt100;
		this.over = over;
		this.ibflag = ibflag;
		this.average3040 = average3040;
		this.average100 = average100;
		this.month = month;
		this.below = below;
		this.average4050 = average4050;
		this.belowCnt = belowCnt;
		this.cnt4050 = cnt4050;
		this.totalAverage = totalAverage;
		this.cnt1020 = cnt1020;
		this.totalCnt = totalCnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("office", getOffice());
		this.hashColumns.put("average10_20", getAverage1020());
		this.hashColumns.put("average0_10", getAverage010());
		this.hashColumns.put("cnt30_40", getCnt3040());
		this.hashColumns.put("cnt0_10", getCnt010());
		this.hashColumns.put("average20_30", getAverage2030());
		this.hashColumns.put("over_cnt", getOverCnt());
		this.hashColumns.put("cnt20_30", getCnt2030());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cnt10_0", getCnt100());
		this.hashColumns.put("over", getOver());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("average30_40", getAverage3040());
		this.hashColumns.put("average10_0", getAverage100());
		this.hashColumns.put("month", getMonth());
		this.hashColumns.put("below", getBelow());
		this.hashColumns.put("average40_50", getAverage4050());
		this.hashColumns.put("below_cnt", getBelowCnt());
		this.hashColumns.put("cnt40_50", getCnt4050());
		this.hashColumns.put("total_average", getTotalAverage());
		this.hashColumns.put("cnt10_20", getCnt1020());
		this.hashColumns.put("total_cnt", getTotalCnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("office", "office");
		this.hashFields.put("average10_20", "average1020");
		this.hashFields.put("average0_10", "average010");
		this.hashFields.put("cnt30_40", "cnt3040");
		this.hashFields.put("cnt0_10", "cnt010");
		this.hashFields.put("average20_30", "average2030");
		this.hashFields.put("over_cnt", "overCnt");
		this.hashFields.put("cnt20_30", "cnt2030");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cnt10_0", "cnt100");
		this.hashFields.put("over", "over");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("average30_40", "average3040");
		this.hashFields.put("average10_0", "average100");
		this.hashFields.put("month", "month");
		this.hashFields.put("below", "below");
		this.hashFields.put("average40_50", "average4050");
		this.hashFields.put("below_cnt", "belowCnt");
		this.hashFields.put("cnt40_50", "cnt4050");
		this.hashFields.put("total_average", "totalAverage");
		this.hashFields.put("cnt10_20", "cnt1020");
		this.hashFields.put("total_cnt", "totalCnt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return office
	 */
	public String getOffice() {
		return this.office;
	}
	
	/**
	 * Column Info
	 * @return average1020
	 */
	public String getAverage1020() {
		return this.average1020;
	}
	
	/**
	 * Column Info
	 * @return average010
	 */
	public String getAverage010() {
		return this.average010;
	}
	
	/**
	 * Column Info
	 * @return cnt3040
	 */
	public String getCnt3040() {
		return this.cnt3040;
	}
	
	/**
	 * Column Info
	 * @return cnt010
	 */
	public String getCnt010() {
		return this.cnt010;
	}
	
	/**
	 * Column Info
	 * @return average2030
	 */
	public String getAverage2030() {
		return this.average2030;
	}
	
	/**
	 * Column Info
	 * @return overCnt
	 */
	public String getOverCnt() {
		return this.overCnt;
	}
	
	/**
	 * Column Info
	 * @return cnt2030
	 */
	public String getCnt2030() {
		return this.cnt2030;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
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
	 * @return cnt100
	 */
	public String getCnt100() {
		return this.cnt100;
	}
	
	/**
	 * Column Info
	 * @return over
	 */
	public String getOver() {
		return this.over;
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
	 * @return average3040
	 */
	public String getAverage3040() {
		return this.average3040;
	}
	
	/**
	 * Column Info
	 * @return average100
	 */
	public String getAverage100() {
		return this.average100;
	}
	
	/**
	 * Column Info
	 * @return month
	 */
	public String getMonth() {
		return this.month;
	}
	
	/**
	 * Column Info
	 * @return below
	 */
	public String getBelow() {
		return this.below;
	}
	
	/**
	 * Column Info
	 * @return average4050
	 */
	public String getAverage4050() {
		return this.average4050;
	}
	
	/**
	 * Column Info
	 * @return belowCnt
	 */
	public String getBelowCnt() {
		return this.belowCnt;
	}
	
	/**
	 * Column Info
	 * @return cnt4050
	 */
	public String getCnt4050() {
		return this.cnt4050;
	}
	
	/**
	 * Column Info
	 * @return totalAverage
	 */
	public String getTotalAverage() {
		return this.totalAverage;
	}
	
	/**
	 * Column Info
	 * @return cnt1020
	 */
	public String getCnt1020() {
		return this.cnt1020;
	}
	
	/**
	 * Column Info
	 * @return totalCnt
	 */
	public String getTotalCnt() {
		return this.totalCnt;
	}
	

	/**
	 * Column Info
	 * @param office
	 */
	public void setOffice(String office) {
		this.office = office;
	}
	
	/**
	 * Column Info
	 * @param average1020
	 */
	public void setAverage1020(String average1020) {
		this.average1020 = average1020;
	}
	
	/**
	 * Column Info
	 * @param average010
	 */
	public void setAverage010(String average010) {
		this.average010 = average010;
	}
	
	/**
	 * Column Info
	 * @param cnt3040
	 */
	public void setCnt3040(String cnt3040) {
		this.cnt3040 = cnt3040;
	}
	
	/**
	 * Column Info
	 * @param cnt010
	 */
	public void setCnt010(String cnt010) {
		this.cnt010 = cnt010;
	}
	
	/**
	 * Column Info
	 * @param average2030
	 */
	public void setAverage2030(String average2030) {
		this.average2030 = average2030;
	}
	
	/**
	 * Column Info
	 * @param overCnt
	 */
	public void setOverCnt(String overCnt) {
		this.overCnt = overCnt;
	}
	
	/**
	 * Column Info
	 * @param cnt2030
	 */
	public void setCnt2030(String cnt2030) {
		this.cnt2030 = cnt2030;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
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
	 * @param cnt100
	 */
	public void setCnt100(String cnt100) {
		this.cnt100 = cnt100;
	}
	
	/**
	 * Column Info
	 * @param over
	 */
	public void setOver(String over) {
		this.over = over;
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
	 * @param average3040
	 */
	public void setAverage3040(String average3040) {
		this.average3040 = average3040;
	}
	
	/**
	 * Column Info
	 * @param average100
	 */
	public void setAverage100(String average100) {
		this.average100 = average100;
	}
	
	/**
	 * Column Info
	 * @param month
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	
	/**
	 * Column Info
	 * @param below
	 */
	public void setBelow(String below) {
		this.below = below;
	}
	
	/**
	 * Column Info
	 * @param average4050
	 */
	public void setAverage4050(String average4050) {
		this.average4050 = average4050;
	}
	
	/**
	 * Column Info
	 * @param belowCnt
	 */
	public void setBelowCnt(String belowCnt) {
		this.belowCnt = belowCnt;
	}
	
	/**
	 * Column Info
	 * @param cnt4050
	 */
	public void setCnt4050(String cnt4050) {
		this.cnt4050 = cnt4050;
	}
	
	/**
	 * Column Info
	 * @param totalAverage
	 */
	public void setTotalAverage(String totalAverage) {
		this.totalAverage = totalAverage;
	}
	
	/**
	 * Column Info
	 * @param cnt1020
	 */
	public void setCnt1020(String cnt1020) {
		this.cnt1020 = cnt1020;
	}
	
	/**
	 * Column Info
	 * @param totalCnt
	 */
	public void setTotalCnt(String totalCnt) {
		this.totalCnt = totalCnt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOffice(JSPUtil.getParameter(request, "office", ""));
		setAverage1020(JSPUtil.getParameter(request, "average10_20", ""));
		setAverage010(JSPUtil.getParameter(request, "average0_10", ""));
		setCnt3040(JSPUtil.getParameter(request, "cnt30_40", ""));
		setCnt010(JSPUtil.getParameter(request, "cnt0_10", ""));
		setAverage2030(JSPUtil.getParameter(request, "average20_30", ""));
		setOverCnt(JSPUtil.getParameter(request, "over_cnt", ""));
		setCnt2030(JSPUtil.getParameter(request, "cnt20_30", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCnt100(JSPUtil.getParameter(request, "cnt10_0", ""));
		setOver(JSPUtil.getParameter(request, "over", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAverage3040(JSPUtil.getParameter(request, "average30_40", ""));
		setAverage100(JSPUtil.getParameter(request, "average10_0", ""));
		setMonth(JSPUtil.getParameter(request, "month", ""));
		setBelow(JSPUtil.getParameter(request, "below", ""));
		setAverage4050(JSPUtil.getParameter(request, "average40_50", ""));
		setBelowCnt(JSPUtil.getParameter(request, "below_cnt", ""));
		setCnt4050(JSPUtil.getParameter(request, "cnt40_50", ""));
		setTotalAverage(JSPUtil.getParameter(request, "total_average", ""));
		setCnt1020(JSPUtil.getParameter(request, "cnt10_20", ""));
		setTotalCnt(JSPUtil.getParameter(request, "total_cnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceTermAnalysisVO[]
	 */
	public InvoiceTermAnalysisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvoiceTermAnalysisVO[]
	 */
	public InvoiceTermAnalysisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvoiceTermAnalysisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] office = (JSPUtil.getParameter(request, prefix	+ "office", length));
			String[] average1020 = (JSPUtil.getParameter(request, prefix	+ "average10_20", length));
			String[] average010 = (JSPUtil.getParameter(request, prefix	+ "average0_10", length));
			String[] cnt3040 = (JSPUtil.getParameter(request, prefix	+ "cnt30_40", length));
			String[] cnt010 = (JSPUtil.getParameter(request, prefix	+ "cnt0_10", length));
			String[] average2030 = (JSPUtil.getParameter(request, prefix	+ "average20_30", length));
			String[] overCnt = (JSPUtil.getParameter(request, prefix	+ "over_cnt", length));
			String[] cnt2030 = (JSPUtil.getParameter(request, prefix	+ "cnt20_30", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cnt100 = (JSPUtil.getParameter(request, prefix	+ "cnt10_0", length));
			String[] over = (JSPUtil.getParameter(request, prefix	+ "over", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] average3040 = (JSPUtil.getParameter(request, prefix	+ "average30_40", length));
			String[] average100 = (JSPUtil.getParameter(request, prefix	+ "average10_0", length));
			String[] month = (JSPUtil.getParameter(request, prefix	+ "month", length));
			String[] below = (JSPUtil.getParameter(request, prefix	+ "below", length));
			String[] average4050 = (JSPUtil.getParameter(request, prefix	+ "average40_50", length));
			String[] belowCnt = (JSPUtil.getParameter(request, prefix	+ "below_cnt", length));
			String[] cnt4050 = (JSPUtil.getParameter(request, prefix	+ "cnt40_50", length));
			String[] totalAverage = (JSPUtil.getParameter(request, prefix	+ "total_average", length));
			String[] cnt1020 = (JSPUtil.getParameter(request, prefix	+ "cnt10_20", length));
			String[] totalCnt = (JSPUtil.getParameter(request, prefix	+ "total_cnt", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvoiceTermAnalysisVO();
				if (office[i] != null)
					model.setOffice(office[i]);
				if (average1020[i] != null)
					model.setAverage1020(average1020[i]);
				if (average010[i] != null)
					model.setAverage010(average010[i]);
				if (cnt3040[i] != null)
					model.setCnt3040(cnt3040[i]);
				if (cnt010[i] != null)
					model.setCnt010(cnt010[i]);
				if (average2030[i] != null)
					model.setAverage2030(average2030[i]);
				if (overCnt[i] != null)
					model.setOverCnt(overCnt[i]);
				if (cnt2030[i] != null)
					model.setCnt2030(cnt2030[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cnt100[i] != null)
					model.setCnt100(cnt100[i]);
				if (over[i] != null)
					model.setOver(over[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (average3040[i] != null)
					model.setAverage3040(average3040[i]);
				if (average100[i] != null)
					model.setAverage100(average100[i]);
				if (month[i] != null)
					model.setMonth(month[i]);
				if (below[i] != null)
					model.setBelow(below[i]);
				if (average4050[i] != null)
					model.setAverage4050(average4050[i]);
				if (belowCnt[i] != null)
					model.setBelowCnt(belowCnt[i]);
				if (cnt4050[i] != null)
					model.setCnt4050(cnt4050[i]);
				if (totalAverage[i] != null)
					model.setTotalAverage(totalAverage[i]);
				if (cnt1020[i] != null)
					model.setCnt1020(cnt1020[i]);
				if (totalCnt[i] != null)
					model.setTotalCnt(totalCnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvoiceTermAnalysisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvoiceTermAnalysisVO[]
	 */
	public InvoiceTermAnalysisVO[] getInvoiceTermAnalysisVOs(){
		InvoiceTermAnalysisVO[] vos = (InvoiceTermAnalysisVO[])models.toArray(new InvoiceTermAnalysisVO[models.size()]);
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
		this.office = this.office .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.average1020 = this.average1020 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.average010 = this.average010 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt3040 = this.cnt3040 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt010 = this.cnt010 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.average2030 = this.average2030 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overCnt = this.overCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt2030 = this.cnt2030 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt100 = this.cnt100 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.over = this.over .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.average3040 = this.average3040 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.average100 = this.average100 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.month = this.month .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.below = this.below .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.average4050 = this.average4050 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.belowCnt = this.belowCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt4050 = this.cnt4050 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalAverage = this.totalAverage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt1020 = this.cnt1020 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCnt = this.totalCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
