/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ExcelDownSpaceUtilizationPortListVO.java
*@FileTitle : ExcelDownSpaceUtilizationPortListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.08
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2013.11.08 최윤성 
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

public class ExcelDownSpaceUtilizationPortListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ExcelDownSpaceUtilizationPortListVO> models = new ArrayList<ExcelDownSpaceUtilizationPortListVO>();
	
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String forecastWgt = null;
	/* Column Info */
	private String bookingTotalTeu = null;
	/* Column Info */
	private String qtaLoad = null;
	/* Column Info */
	private String allocationTotalTeu = null;
	/* Column Info */
	private String cmbTeu = null;
	/* Column Info */
	private String allocationWgt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String forecastTotalTeu = null;
	/* Column Info */
	private String bookingWgt = null;
	/* Column Info */
	private String cmbWgt = null;
	/* Column Info */
	private String areaCd = null;
	/* Column Info */
	private String qtaCmb = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ExcelDownSpaceUtilizationPortListVO() {}

	public ExcelDownSpaceUtilizationPortListVO(String ibflag, String pagerows, String vvd, String iocCd, String areaCd, String ofcCd, String polCd, String podCd, String qtaLoad, String qtaCmb, String cmbTeu, String cmbWgt, String forecastTotalTeu, String forecastWgt, String allocationTotalTeu, String allocationWgt, String bookingTotalTeu, String bookingWgt) {
		this.iocCd = iocCd;
		this.forecastWgt = forecastWgt;
		this.bookingTotalTeu = bookingTotalTeu;
		this.qtaLoad = qtaLoad;
		this.allocationTotalTeu = allocationTotalTeu;
		this.cmbTeu = cmbTeu;
		this.allocationWgt = allocationWgt;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.podCd = podCd;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.forecastTotalTeu = forecastTotalTeu;
		this.bookingWgt = bookingWgt;
		this.cmbWgt = cmbWgt;
		this.areaCd = areaCd;
		this.qtaCmb = qtaCmb;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("forecast_wgt", getForecastWgt());
		this.hashColumns.put("booking_total_teu", getBookingTotalTeu());
		this.hashColumns.put("qta_load", getQtaLoad());
		this.hashColumns.put("allocation_total_teu", getAllocationTotalTeu());
		this.hashColumns.put("cmb_teu", getCmbTeu());
		this.hashColumns.put("allocation_wgt", getAllocationWgt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("forecast_total_teu", getForecastTotalTeu());
		this.hashColumns.put("booking_wgt", getBookingWgt());
		this.hashColumns.put("cmb_wgt", getCmbWgt());
		this.hashColumns.put("area_cd", getAreaCd());
		this.hashColumns.put("qta_cmb", getQtaCmb());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("forecast_wgt", "forecastWgt");
		this.hashFields.put("booking_total_teu", "bookingTotalTeu");
		this.hashFields.put("qta_load", "qtaLoad");
		this.hashFields.put("allocation_total_teu", "allocationTotalTeu");
		this.hashFields.put("cmb_teu", "cmbTeu");
		this.hashFields.put("allocation_wgt", "allocationWgt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("forecast_total_teu", "forecastTotalTeu");
		this.hashFields.put("booking_wgt", "bookingWgt");
		this.hashFields.put("cmb_wgt", "cmbWgt");
		this.hashFields.put("area_cd", "areaCd");
		this.hashFields.put("qta_cmb", "qtaCmb");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return iocCd
	 */
	public String getIocCd() {
		return this.iocCd;
	}
	
	/**
	 * Column Info
	 * @return forecastWgt
	 */
	public String getForecastWgt() {
		return this.forecastWgt;
	}
	
	/**
	 * Column Info
	 * @return bookingTotalTeu
	 */
	public String getBookingTotalTeu() {
		return this.bookingTotalTeu;
	}
	
	/**
	 * Column Info
	 * @return qtaLoad
	 */
	public String getQtaLoad() {
		return this.qtaLoad;
	}
	
	/**
	 * Column Info
	 * @return allocationTotalTeu
	 */
	public String getAllocationTotalTeu() {
		return this.allocationTotalTeu;
	}
	
	/**
	 * Column Info
	 * @return cmbTeu
	 */
	public String getCmbTeu() {
		return this.cmbTeu;
	}
	
	/**
	 * Column Info
	 * @return allocationWgt
	 */
	public String getAllocationWgt() {
		return this.allocationWgt;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return forecastTotalTeu
	 */
	public String getForecastTotalTeu() {
		return this.forecastTotalTeu;
	}
	
	/**
	 * Column Info
	 * @return bookingWgt
	 */
	public String getBookingWgt() {
		return this.bookingWgt;
	}
	
	/**
	 * Column Info
	 * @return cmbWgt
	 */
	public String getCmbWgt() {
		return this.cmbWgt;
	}
	
	/**
	 * Column Info
	 * @return areaCd
	 */
	public String getAreaCd() {
		return this.areaCd;
	}
	
	/**
	 * Column Info
	 * @return qtaCmb
	 */
	public String getQtaCmb() {
		return this.qtaCmb;
	}
	

	/**
	 * Column Info
	 * @param iocCd
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
	}
	
	/**
	 * Column Info
	 * @param forecastWgt
	 */
	public void setForecastWgt(String forecastWgt) {
		this.forecastWgt = forecastWgt;
	}
	
	/**
	 * Column Info
	 * @param bookingTotalTeu
	 */
	public void setBookingTotalTeu(String bookingTotalTeu) {
		this.bookingTotalTeu = bookingTotalTeu;
	}
	
	/**
	 * Column Info
	 * @param qtaLoad
	 */
	public void setQtaLoad(String qtaLoad) {
		this.qtaLoad = qtaLoad;
	}
	
	/**
	 * Column Info
	 * @param allocationTotalTeu
	 */
	public void setAllocationTotalTeu(String allocationTotalTeu) {
		this.allocationTotalTeu = allocationTotalTeu;
	}
	
	/**
	 * Column Info
	 * @param cmbTeu
	 */
	public void setCmbTeu(String cmbTeu) {
		this.cmbTeu = cmbTeu;
	}
	
	/**
	 * Column Info
	 * @param allocationWgt
	 */
	public void setAllocationWgt(String allocationWgt) {
		this.allocationWgt = allocationWgt;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param forecastTotalTeu
	 */
	public void setForecastTotalTeu(String forecastTotalTeu) {
		this.forecastTotalTeu = forecastTotalTeu;
	}
	
	/**
	 * Column Info
	 * @param bookingWgt
	 */
	public void setBookingWgt(String bookingWgt) {
		this.bookingWgt = bookingWgt;
	}
	
	/**
	 * Column Info
	 * @param cmbWgt
	 */
	public void setCmbWgt(String cmbWgt) {
		this.cmbWgt = cmbWgt;
	}
	
	/**
	 * Column Info
	 * @param areaCd
	 */
	public void setAreaCd(String areaCd) {
		this.areaCd = areaCd;
	}
	
	/**
	 * Column Info
	 * @param qtaCmb
	 */
	public void setQtaCmb(String qtaCmb) {
		this.qtaCmb = qtaCmb;
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
		setIocCd(JSPUtil.getParameter(request, prefix + "ioc_cd", ""));
		setForecastWgt(JSPUtil.getParameter(request, prefix + "forecast_wgt", ""));
		setBookingTotalTeu(JSPUtil.getParameter(request, prefix + "booking_total_teu", ""));
		setQtaLoad(JSPUtil.getParameter(request, prefix + "qta_load", ""));
		setAllocationTotalTeu(JSPUtil.getParameter(request, prefix + "allocation_total_teu", ""));
		setCmbTeu(JSPUtil.getParameter(request, prefix + "cmb_teu", ""));
		setAllocationWgt(JSPUtil.getParameter(request, prefix + "allocation_wgt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setForecastTotalTeu(JSPUtil.getParameter(request, prefix + "forecast_total_teu", ""));
		setBookingWgt(JSPUtil.getParameter(request, prefix + "booking_wgt", ""));
		setCmbWgt(JSPUtil.getParameter(request, prefix + "cmb_wgt", ""));
		setAreaCd(JSPUtil.getParameter(request, prefix + "area_cd", ""));
		setQtaCmb(JSPUtil.getParameter(request, prefix + "qta_cmb", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ExcelDownSpaceUtilizationPortListVO[]
	 */
	public ExcelDownSpaceUtilizationPortListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ExcelDownSpaceUtilizationPortListVO[]
	 */
	public ExcelDownSpaceUtilizationPortListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ExcelDownSpaceUtilizationPortListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] forecastWgt = (JSPUtil.getParameter(request, prefix	+ "forecast_wgt", length));
			String[] bookingTotalTeu = (JSPUtil.getParameter(request, prefix	+ "booking_total_teu", length));
			String[] qtaLoad = (JSPUtil.getParameter(request, prefix	+ "qta_load", length));
			String[] allocationTotalTeu = (JSPUtil.getParameter(request, prefix	+ "allocation_total_teu", length));
			String[] cmbTeu = (JSPUtil.getParameter(request, prefix	+ "cmb_teu", length));
			String[] allocationWgt = (JSPUtil.getParameter(request, prefix	+ "allocation_wgt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] forecastTotalTeu = (JSPUtil.getParameter(request, prefix	+ "forecast_total_teu", length));
			String[] bookingWgt = (JSPUtil.getParameter(request, prefix	+ "booking_wgt", length));
			String[] cmbWgt = (JSPUtil.getParameter(request, prefix	+ "cmb_wgt", length));
			String[] areaCd = (JSPUtil.getParameter(request, prefix	+ "area_cd", length));
			String[] qtaCmb = (JSPUtil.getParameter(request, prefix	+ "qta_cmb", length));
			
			for (int i = 0; i < length; i++) {
				model = new ExcelDownSpaceUtilizationPortListVO();
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (forecastWgt[i] != null)
					model.setForecastWgt(forecastWgt[i]);
				if (bookingTotalTeu[i] != null)
					model.setBookingTotalTeu(bookingTotalTeu[i]);
				if (qtaLoad[i] != null)
					model.setQtaLoad(qtaLoad[i]);
				if (allocationTotalTeu[i] != null)
					model.setAllocationTotalTeu(allocationTotalTeu[i]);
				if (cmbTeu[i] != null)
					model.setCmbTeu(cmbTeu[i]);
				if (allocationWgt[i] != null)
					model.setAllocationWgt(allocationWgt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (forecastTotalTeu[i] != null)
					model.setForecastTotalTeu(forecastTotalTeu[i]);
				if (bookingWgt[i] != null)
					model.setBookingWgt(bookingWgt[i]);
				if (cmbWgt[i] != null)
					model.setCmbWgt(cmbWgt[i]);
				if (areaCd[i] != null)
					model.setAreaCd(areaCd[i]);
				if (qtaCmb[i] != null)
					model.setQtaCmb(qtaCmb[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getExcelDownSpaceUtilizationPortListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ExcelDownSpaceUtilizationPortListVO[]
	 */
	public ExcelDownSpaceUtilizationPortListVO[] getExcelDownSpaceUtilizationPortListVOs(){
		ExcelDownSpaceUtilizationPortListVO[] vos = (ExcelDownSpaceUtilizationPortListVO[])models.toArray(new ExcelDownSpaceUtilizationPortListVO[models.size()]);
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
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.forecastWgt = this.forecastWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bookingTotalTeu = this.bookingTotalTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtaLoad = this.qtaLoad .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allocationTotalTeu = this.allocationTotalTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmbTeu = this.cmbTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allocationWgt = this.allocationWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.forecastTotalTeu = this.forecastTotalTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bookingWgt = this.bookingWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmbWgt = this.cmbWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.areaCd = this.areaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtaCmb = this.qtaCmb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
