/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TrendListVO.java
*@FileTitle : TrendListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.08.18 김종준 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo;

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
 * @author 김종준
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TrendListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TrendListVO> models = new ArrayList<TrendListVO>();
	
	/* Column Info */
	private String year10 = null;
	/* Column Info */
	private String year11 = null;
	/* Column Info */
	private String year12 = null;
	/* Column Info */
	private String coCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String year6 = null;
	/* Column Info */
	private String toBseDt = null;
	/* Column Info */
	private String bseDt = null;
	/* Column Info */
	private String year5 = null;
	/* Column Info */
	private String year8 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String year7 = null;
	/* Column Info */
	private String division = null;
	/* Column Info */
	private String year9 = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String fromBseDt = null;
	/* Column Info */
	private String year2 = null;
	/* Column Info */
	private String year1 = null;
	/* Column Info */
	private String year4 = null;
	/* Column Info */
	private String average = null;
	/* Column Info */
	private String year3 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TrendListVO() {}

	public TrendListVO(String ibflag, String pagerows, String fromBseDt, String coCd, String division, String toBseDt, String locCd, String average, String cntrTpszCd, String bseDt, String year1, String year2, String year3, String year4, String year5, String year6, String year7, String year8, String year9, String year10, String year11, String year12) {
		this.year10 = year10;
		this.year11 = year11;
		this.year12 = year12;
		this.coCd = coCd;
		this.pagerows = pagerows;
		this.year6 = year6;
		this.toBseDt = toBseDt;
		this.bseDt = bseDt;
		this.year5 = year5;
		this.year8 = year8;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.year7 = year7;
		this.division = division;
		this.year9 = year9;
		this.cntrTpszCd = cntrTpszCd;
		this.fromBseDt = fromBseDt;
		this.year2 = year2;
		this.year1 = year1;
		this.year4 = year4;
		this.average = average;
		this.year3 = year3;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("year10", getYear10());
		this.hashColumns.put("year11", getYear11());
		this.hashColumns.put("year12", getYear12());
		this.hashColumns.put("co_cd", getCoCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("year6", getYear6());
		this.hashColumns.put("to_bse_dt", getToBseDt());
		this.hashColumns.put("bse_dt", getBseDt());
		this.hashColumns.put("year5", getYear5());
		this.hashColumns.put("year8", getYear8());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("year7", getYear7());
		this.hashColumns.put("division", getDivision());
		this.hashColumns.put("year9", getYear9());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("from_bse_dt", getFromBseDt());
		this.hashColumns.put("year2", getYear2());
		this.hashColumns.put("year1", getYear1());
		this.hashColumns.put("year4", getYear4());
		this.hashColumns.put("average", getAverage());
		this.hashColumns.put("year3", getYear3());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("year10", "year10");
		this.hashFields.put("year11", "year11");
		this.hashFields.put("year12", "year12");
		this.hashFields.put("co_cd", "coCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("year6", "year6");
		this.hashFields.put("to_bse_dt", "toBseDt");
		this.hashFields.put("bse_dt", "bseDt");
		this.hashFields.put("year5", "year5");
		this.hashFields.put("year8", "year8");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("year7", "year7");
		this.hashFields.put("division", "division");
		this.hashFields.put("year9", "year9");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("from_bse_dt", "fromBseDt");
		this.hashFields.put("year2", "year2");
		this.hashFields.put("year1", "year1");
		this.hashFields.put("year4", "year4");
		this.hashFields.put("average", "average");
		this.hashFields.put("year3", "year3");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return year10
	 */
	public String getYear10() {
		return this.year10;
	}
	
	/**
	 * Column Info
	 * @return year11
	 */
	public String getYear11() {
		return this.year11;
	}
	
	/**
	 * Column Info
	 * @return year12
	 */
	public String getYear12() {
		return this.year12;
	}
	
	/**
	 * Column Info
	 * @return coCd
	 */
	public String getCoCd() {
		return this.coCd;
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
	 * @return year6
	 */
	public String getYear6() {
		return this.year6;
	}
	
	/**
	 * Column Info
	 * @return toBseDt
	 */
	public String getToBseDt() {
		return this.toBseDt;
	}
	
	/**
	 * Column Info
	 * @return bseDt
	 */
	public String getBseDt() {
		return this.bseDt;
	}
	
	/**
	 * Column Info
	 * @return year5
	 */
	public String getYear5() {
		return this.year5;
	}
	
	/**
	 * Column Info
	 * @return year8
	 */
	public String getYear8() {
		return this.year8;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return year7
	 */
	public String getYear7() {
		return this.year7;
	}
	
	/**
	 * Column Info
	 * @return division
	 */
	public String getDivision() {
		return this.division;
	}
	
	/**
	 * Column Info
	 * @return year9
	 */
	public String getYear9() {
		return this.year9;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return fromBseDt
	 */
	public String getFromBseDt() {
		return this.fromBseDt;
	}
	
	/**
	 * Column Info
	 * @return year2
	 */
	public String getYear2() {
		return this.year2;
	}
	
	/**
	 * Column Info
	 * @return year1
	 */
	public String getYear1() {
		return this.year1;
	}
	
	/**
	 * Column Info
	 * @return year4
	 */
	public String getYear4() {
		return this.year4;
	}
	
	/**
	 * Column Info
	 * @return average
	 */
	public String getAverage() {
		return this.average;
	}
	
	/**
	 * Column Info
	 * @return year3
	 */
	public String getYear3() {
		return this.year3;
	}
	

	/**
	 * Column Info
	 * @param year10
	 */
	public void setYear10(String year10) {
		this.year10 = year10;
	}
	
	/**
	 * Column Info
	 * @param year11
	 */
	public void setYear11(String year11) {
		this.year11 = year11;
	}
	
	/**
	 * Column Info
	 * @param year12
	 */
	public void setYear12(String year12) {
		this.year12 = year12;
	}
	
	/**
	 * Column Info
	 * @param coCd
	 */
	public void setCoCd(String coCd) {
		this.coCd = coCd;
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
	 * @param year6
	 */
	public void setYear6(String year6) {
		this.year6 = year6;
	}
	
	/**
	 * Column Info
	 * @param toBseDt
	 */
	public void setToBseDt(String toBseDt) {
		this.toBseDt = toBseDt;
	}
	
	/**
	 * Column Info
	 * @param bseDt
	 */
	public void setBseDt(String bseDt) {
		this.bseDt = bseDt;
	}
	
	/**
	 * Column Info
	 * @param year5
	 */
	public void setYear5(String year5) {
		this.year5 = year5;
	}
	
	/**
	 * Column Info
	 * @param year8
	 */
	public void setYear8(String year8) {
		this.year8 = year8;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param year7
	 */
	public void setYear7(String year7) {
		this.year7 = year7;
	}
	
	/**
	 * Column Info
	 * @param division
	 */
	public void setDivision(String division) {
		this.division = division;
	}
	
	/**
	 * Column Info
	 * @param year9
	 */
	public void setYear9(String year9) {
		this.year9 = year9;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param fromBseDt
	 */
	public void setFromBseDt(String fromBseDt) {
		this.fromBseDt = fromBseDt;
	}
	
	/**
	 * Column Info
	 * @param year2
	 */
	public void setYear2(String year2) {
		this.year2 = year2;
	}
	
	/**
	 * Column Info
	 * @param year1
	 */
	public void setYear1(String year1) {
		this.year1 = year1;
	}
	
	/**
	 * Column Info
	 * @param year4
	 */
	public void setYear4(String year4) {
		this.year4 = year4;
	}
	
	/**
	 * Column Info
	 * @param average
	 */
	public void setAverage(String average) {
		this.average = average;
	}
	
	/**
	 * Column Info
	 * @param year3
	 */
	public void setYear3(String year3) {
		this.year3 = year3;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setYear10(JSPUtil.getParameter(request, "year10", ""));
		setYear11(JSPUtil.getParameter(request, "year11", ""));
		setYear12(JSPUtil.getParameter(request, "year12", ""));
		setCoCd(JSPUtil.getParameter(request, "co_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setYear6(JSPUtil.getParameter(request, "year6", ""));
		setToBseDt(JSPUtil.getParameter(request, "to_bse_dt", ""));
		setBseDt(JSPUtil.getParameter(request, "bse_dt", ""));
		setYear5(JSPUtil.getParameter(request, "year5", ""));
		setYear8(JSPUtil.getParameter(request, "year8", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setYear7(JSPUtil.getParameter(request, "year7", ""));
		setDivision(JSPUtil.getParameter(request, "division", ""));
		setYear9(JSPUtil.getParameter(request, "year9", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setFromBseDt(JSPUtil.getParameter(request, "from_bse_dt", ""));
		setYear2(JSPUtil.getParameter(request, "year2", ""));
		setYear1(JSPUtil.getParameter(request, "year1", ""));
		setYear4(JSPUtil.getParameter(request, "year4", ""));
		setAverage(JSPUtil.getParameter(request, "average", ""));
		setYear3(JSPUtil.getParameter(request, "year3", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TrendListVO[]
	 */
	public TrendListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TrendListVO[]
	 */
	public TrendListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TrendListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] year10 = (JSPUtil.getParameter(request, prefix	+ "year10", length));
			String[] year11 = (JSPUtil.getParameter(request, prefix	+ "year11", length));
			String[] year12 = (JSPUtil.getParameter(request, prefix	+ "year12", length));
			String[] coCd = (JSPUtil.getParameter(request, prefix	+ "co_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] year6 = (JSPUtil.getParameter(request, prefix	+ "year6", length));
			String[] toBseDt = (JSPUtil.getParameter(request, prefix	+ "to_bse_dt", length));
			String[] bseDt = (JSPUtil.getParameter(request, prefix	+ "bse_dt", length));
			String[] year5 = (JSPUtil.getParameter(request, prefix	+ "year5", length));
			String[] year8 = (JSPUtil.getParameter(request, prefix	+ "year8", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] year7 = (JSPUtil.getParameter(request, prefix	+ "year7", length));
			String[] division = (JSPUtil.getParameter(request, prefix	+ "division", length));
			String[] year9 = (JSPUtil.getParameter(request, prefix	+ "year9", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] fromBseDt = (JSPUtil.getParameter(request, prefix	+ "from_bse_dt", length));
			String[] year2 = (JSPUtil.getParameter(request, prefix	+ "year2", length));
			String[] year1 = (JSPUtil.getParameter(request, prefix	+ "year1", length));
			String[] year4 = (JSPUtil.getParameter(request, prefix	+ "year4", length));
			String[] average = (JSPUtil.getParameter(request, prefix	+ "average", length));
			String[] year3 = (JSPUtil.getParameter(request, prefix	+ "year3", length));
			
			for (int i = 0; i < length; i++) {
				model = new TrendListVO();
				if (year10[i] != null)
					model.setYear10(year10[i]);
				if (year11[i] != null)
					model.setYear11(year11[i]);
				if (year12[i] != null)
					model.setYear12(year12[i]);
				if (coCd[i] != null)
					model.setCoCd(coCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (year6[i] != null)
					model.setYear6(year6[i]);
				if (toBseDt[i] != null)
					model.setToBseDt(toBseDt[i]);
				if (bseDt[i] != null)
					model.setBseDt(bseDt[i]);
				if (year5[i] != null)
					model.setYear5(year5[i]);
				if (year8[i] != null)
					model.setYear8(year8[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (year7[i] != null)
					model.setYear7(year7[i]);
				if (division[i] != null)
					model.setDivision(division[i]);
				if (year9[i] != null)
					model.setYear9(year9[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (fromBseDt[i] != null)
					model.setFromBseDt(fromBseDt[i]);
				if (year2[i] != null)
					model.setYear2(year2[i]);
				if (year1[i] != null)
					model.setYear1(year1[i]);
				if (year4[i] != null)
					model.setYear4(year4[i]);
				if (average[i] != null)
					model.setAverage(average[i]);
				if (year3[i] != null)
					model.setYear3(year3[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTrendListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TrendListVO[]
	 */
	public TrendListVO[] getTrendListVOs(){
		TrendListVO[] vos = (TrendListVO[])models.toArray(new TrendListVO[models.size()]);
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
		this.year10 = this.year10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year11 = this.year11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year12 = this.year12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coCd = this.coCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year6 = this.year6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toBseDt = this.toBseDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseDt = this.bseDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year5 = this.year5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year8 = this.year8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year7 = this.year7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.division = this.division .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year9 = this.year9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromBseDt = this.fromBseDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year2 = this.year2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year1 = this.year1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year4 = this.year4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.average = this.average .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year3 = this.year3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
