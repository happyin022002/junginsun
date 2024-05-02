/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CheckWeekEndParmVO.java
*@FileTitle : CheckWeekEndParmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.14
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2012.02.14 KIM HYUN HWA 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo;

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
 * @author KIM HYUN HWA
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CheckWeekEndParmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CheckWeekEndParmVO> models = new ArrayList<CheckWeekEndParmVO>();
	
	/* Column Info */
	private String weekOfDay = null;
	/* Column Info */
	private String exclSat = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String termCd = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String exclSun = null;
	/* Column Info */
	private String trfCd = null;
	/* Column Info */
	private String expType = null;
	/* Page Number */
	private String pagerows = null; 

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CheckWeekEndParmVO() {}

	public CheckWeekEndParmVO(String ibflag, String pagerows, String cntCd, String weekOfDay, String exclSat, String exclSun, String locCd, String termCd, String trfCd, String expType) {
		this.weekOfDay = weekOfDay;
		this.exclSat = exclSat;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.termCd = termCd;
		this.cntCd = cntCd;
		this.exclSun = exclSun;
		this.trfCd = trfCd;
		this.expType = expType;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("week_of_day", getWeekOfDay());
		this.hashColumns.put("excl_sat", getExclSat());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("term_cd", getTermCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("excl_sun", getExclSun());
		this.hashColumns.put("trf_cd", getTrfCd());
		this.hashColumns.put("exp_type", getExpType());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("week_of_day", "weekOfDay");
		this.hashFields.put("excl_sat", "exclSat");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("term_cd", "termCd");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("excl_sun", "exclSun");
		this.hashFields.put("trf_cd", "trfCd");
		this.hashFields.put("exp_type", "expType");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return weekOfDay
	 */
	public String getWeekOfDay() {
		return this.weekOfDay;
	}
	
	/**
	 * Column Info
	 * @return exclSat
	 */
	public String getExclSat() {
		return this.exclSat;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return termCd
	 */
	public String getTermCd() {
		return this.termCd;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return exclSun
	 */
	public String getExclSun() {
		return this.exclSun;
	}
	
	/**
	 * Column Info
	 * @return trfCd
	 */
	public String getTrfCd() {
		return this.trfCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
    
	public String getExpType() {
		return expType;
	}

	public void setExpType(String expType) {
		this.expType = expType;
	}

	/**
	 * Column Info
	 * @param weekOfDay
	 */
	public void setWeekOfDay(String weekOfDay) {
		this.weekOfDay = weekOfDay;
	}
	
	/**
	 * Column Info
	 * @param exclSat
	 */
	public void setExclSat(String exclSat) {
		this.exclSat = exclSat;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param termCd
	 */
	public void setTermCd(String termCd) {
		this.termCd = termCd;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param exclSun
	 */
	public void setExclSun(String exclSun) {
		this.exclSun = exclSun;
	}
	
	/**
	 * Column Info
	 * @param trfCd
	 */
	public void setTrfCd(String trfCd) {
		this.trfCd = trfCd;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setWeekOfDay(JSPUtil.getParameter(request, prefix + "week_of_day", ""));
		setExclSat(JSPUtil.getParameter(request, prefix + "excl_sat", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTermCd(JSPUtil.getParameter(request, prefix + "term_cd", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setExclSun(JSPUtil.getParameter(request, prefix + "excl_sun", ""));
		setTrfCd(JSPUtil.getParameter(request, prefix + "trf_cd", ""));
		setExpType(JSPUtil.getParameter(request, prefix + "exp_type", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CheckWeekEndParmVO[]
	 */
	public CheckWeekEndParmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CheckWeekEndParmVO[]
	 */
	public CheckWeekEndParmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CheckWeekEndParmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] weekOfDay = (JSPUtil.getParameter(request, prefix	+ "week_of_day", length));
			String[] exclSat = (JSPUtil.getParameter(request, prefix	+ "excl_sat", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] termCd = (JSPUtil.getParameter(request, prefix	+ "term_cd", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] exclSun = (JSPUtil.getParameter(request, prefix	+ "excl_sun", length));
			String[] trfCd = (JSPUtil.getParameter(request, prefix	+ "trf_cd", length));
			String[] expType = (JSPUtil.getParameter(request, prefix	+ "exp_type", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CheckWeekEndParmVO();
				if (weekOfDay[i] != null)
					model.setWeekOfDay(weekOfDay[i]);
				if (exclSat[i] != null)
					model.setExclSat(exclSat[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (termCd[i] != null)
					model.setTermCd(termCd[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (exclSun[i] != null)
					model.setExclSun(exclSun[i]);
				if (trfCd[i] != null)
					model.setTrfCd(trfCd[i]);
				if (expType[i] != null)
					model.setExpType(expType[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCheckWeekEndParmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CheckWeekEndParmVO[]
	 */
	public CheckWeekEndParmVO[] getCheckWeekEndParmVOs(){
		CheckWeekEndParmVO[] vos = (CheckWeekEndParmVO[])models.toArray(new CheckWeekEndParmVO[models.size()]);
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
		this.weekOfDay = this.weekOfDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exclSat = this.exclSat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.termCd = this.termCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exclSun = this.exclSun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfCd = this.trfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expType = this.expType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
