/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TimeClockStopParmVO.java
*@FileTitle : TimeClockStopParmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.22
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2010.11.22 김태균 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.timeclockstopmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김태균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TimeClockStopParmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TimeClockStopParmVO> models = new ArrayList<TimeClockStopParmVO>();
	
	/* Column Info */
	private String office = null;
	/* Column Info */
	private String toDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String clkStopOfcCd = null;
	/* Column Info */
	private String cxlFlg = null;
	/* Column Info */
	private String clkStopYdCd = null;
	/* Column Info */
	private String datePeriod = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String clkStopNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TimeClockStopParmVO() {}

	public TimeClockStopParmVO(String ibflag, String pagerows, String fmDt, String toDt, String clkStopNo, String dmdtTrfCd, String office, String cxlFlg, String clkStopOfcCd, String datePeriod, String clkStopYdCd) {
		this.office = office;
		this.toDt = toDt;
		this.ibflag = ibflag;
		this.fmDt = fmDt;
		this.clkStopOfcCd = clkStopOfcCd;
		this.cxlFlg = cxlFlg;
		this.clkStopYdCd = clkStopYdCd;
		this.datePeriod = datePeriod;
		this.dmdtTrfCd = dmdtTrfCd;
		this.clkStopNo = clkStopNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("office", getOffice());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("clk_stop_ofc_cd", getClkStopOfcCd());
		this.hashColumns.put("cxl_flg", getCxlFlg());
		this.hashColumns.put("clk_stop_yd_cd", getClkStopYdCd());
		this.hashColumns.put("date_period", getDatePeriod());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("clk_stop_no", getClkStopNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("office", "office");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("clk_stop_ofc_cd", "clkStopOfcCd");
		this.hashFields.put("cxl_flg", "cxlFlg");
		this.hashFields.put("clk_stop_yd_cd", "clkStopYdCd");
		this.hashFields.put("date_period", "datePeriod");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("clk_stop_no", "clkStopNo");
		this.hashFields.put("pagerows", "pagerows");
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
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
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
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return clkStopOfcCd
	 */
	public String getClkStopOfcCd() {
		return this.clkStopOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cxlFlg
	 */
	public String getCxlFlg() {
		return this.cxlFlg;
	}
	
	/**
	 * Column Info
	 * @return clkStopYdCd
	 */
	public String getClkStopYdCd() {
		return this.clkStopYdCd;
	}
	
	/**
	 * Column Info
	 * @return datePeriod
	 */
	public String getDatePeriod() {
		return this.datePeriod;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return this.dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @return clkStopNo
	 */
	public String getClkStopNo() {
		return this.clkStopNo;
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
	 * @param office
	 */
	public void setOffice(String office) {
		this.office = office;
	}
	
	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
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
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param clkStopOfcCd
	 */
	public void setClkStopOfcCd(String clkStopOfcCd) {
		this.clkStopOfcCd = clkStopOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cxlFlg
	 */
	public void setCxlFlg(String cxlFlg) {
		this.cxlFlg = cxlFlg;
	}
	
	/**
	 * Column Info
	 * @param clkStopYdCd
	 */
	public void setClkStopYdCd(String clkStopYdCd) {
		this.clkStopYdCd = clkStopYdCd;
	}
	
	/**
	 * Column Info
	 * @param datePeriod
	 */
	public void setDatePeriod(String datePeriod) {
		this.datePeriod = datePeriod;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @param clkStopNo
	 */
	public void setClkStopNo(String clkStopNo) {
		this.clkStopNo = clkStopNo;
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
		setOffice(JSPUtil.getParameter(request, prefix + "office", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFmDt(JSPUtil.getParameter(request, prefix + "fm_dt", ""));
		setClkStopOfcCd(JSPUtil.getParameter(request, prefix + "clk_stop_ofc_cd", ""));
		setCxlFlg(JSPUtil.getParameter(request, prefix + "cxl_flg", ""));
		setClkStopYdCd(JSPUtil.getParameter(request, prefix + "clk_stop_yd_cd", ""));
		setDatePeriod(JSPUtil.getParameter(request, prefix + "date_period", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", ""));
		setClkStopNo(JSPUtil.getParameter(request, prefix + "clk_stop_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TimeClockStopParmVO[]
	 */
	public TimeClockStopParmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TimeClockStopParmVO[]
	 */
	public TimeClockStopParmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TimeClockStopParmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] office = (JSPUtil.getParameter(request, prefix	+ "office", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] clkStopOfcCd = (JSPUtil.getParameter(request, prefix	+ "clk_stop_ofc_cd", length));
			String[] cxlFlg = (JSPUtil.getParameter(request, prefix	+ "cxl_flg", length));
			String[] clkStopYdCd = (JSPUtil.getParameter(request, prefix	+ "clk_stop_yd_cd", length));
			String[] datePeriod = (JSPUtil.getParameter(request, prefix	+ "date_period", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] clkStopNo = (JSPUtil.getParameter(request, prefix	+ "clk_stop_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new TimeClockStopParmVO();
				if (office[i] != null)
					model.setOffice(office[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (clkStopOfcCd[i] != null)
					model.setClkStopOfcCd(clkStopOfcCd[i]);
				if (cxlFlg[i] != null)
					model.setCxlFlg(cxlFlg[i]);
				if (clkStopYdCd[i] != null)
					model.setClkStopYdCd(clkStopYdCd[i]);
				if (datePeriod[i] != null)
					model.setDatePeriod(datePeriod[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (clkStopNo[i] != null)
					model.setClkStopNo(clkStopNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTimeClockStopParmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TimeClockStopParmVO[]
	 */
	public TimeClockStopParmVO[] getTimeClockStopParmVOs(){
		TimeClockStopParmVO[] vos = (TimeClockStopParmVO[])models.toArray(new TimeClockStopParmVO[models.size()]);
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
		this.office = this.office .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clkStopOfcCd = this.clkStopOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlFlg = this.cxlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clkStopYdCd = this.clkStopYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.datePeriod = this.datePeriod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clkStopNo = this.clkStopNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
