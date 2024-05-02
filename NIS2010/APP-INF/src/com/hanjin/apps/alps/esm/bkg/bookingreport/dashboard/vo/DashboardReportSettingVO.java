/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DashboardReportSettingVO.java
*@FileTitle : DashboardReportSettingVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.19
*@LastModifier : 
*@LastVersion : 1.0
* 2013.11.19  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DashboardReportSettingVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DashboardReportSettingVO> models = new ArrayList<DashboardReportSettingVO>();
	
	/* Column Info */
	private String greenTo = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String yellowTo = null;
	/* Column Info */
	private String greenFr = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String redTo = null;
	/* Column Info */
	private String dbdIrrTpCd = null;
	/* Column Info */
	private String redFr = null;
	/* Column Info */
	private String yellowFr = null;
	/* Column Info */
	private String rptItmNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DashboardReportSettingVO() {}

	public DashboardReportSettingVO(String ibflag, String pagerows, String dbdIrrTpCd, String bkgOfcCd, String rptItmNm, String greenFr, String greenTo, String yellowFr, String yellowTo, String redFr, String redTo) {
		this.greenTo = greenTo;
		this.bkgOfcCd = bkgOfcCd;
		this.yellowTo = yellowTo;
		this.greenFr = greenFr;
		this.ibflag = ibflag;
		this.redTo = redTo;
		this.dbdIrrTpCd = dbdIrrTpCd;
		this.redFr = redFr;
		this.yellowFr = yellowFr;
		this.rptItmNm = rptItmNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("green_to", getGreenTo());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("yellow_to", getYellowTo());
		this.hashColumns.put("green_fr", getGreenFr());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("red_to", getRedTo());
		this.hashColumns.put("dbd_irr_tp_cd", getDbdIrrTpCd());
		this.hashColumns.put("red_fr", getRedFr());
		this.hashColumns.put("yellow_fr", getYellowFr());
		this.hashColumns.put("rpt_itm_nm", getRptItmNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("green_to", "greenTo");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("yellow_to", "yellowTo");
		this.hashFields.put("green_fr", "greenFr");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("red_to", "redTo");
		this.hashFields.put("dbd_irr_tp_cd", "dbdIrrTpCd");
		this.hashFields.put("red_fr", "redFr");
		this.hashFields.put("yellow_fr", "yellowFr");
		this.hashFields.put("rpt_itm_nm", "rptItmNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return greenTo
	 */
	public String getGreenTo() {
		return this.greenTo;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return yellowTo
	 */
	public String getYellowTo() {
		return this.yellowTo;
	}
	
	/**
	 * Column Info
	 * @return greenFr
	 */
	public String getGreenFr() {
		return this.greenFr;
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
	 * @return redTo
	 */
	public String getRedTo() {
		return this.redTo;
	}
	
	/**
	 * Column Info
	 * @return dbdIrrTpCd
	 */
	public String getDbdIrrTpCd() {
		return this.dbdIrrTpCd;
	}
	
	/**
	 * Column Info
	 * @return redFr
	 */
	public String getRedFr() {
		return this.redFr;
	}
	
	/**
	 * Column Info
	 * @return yellowFr
	 */
	public String getYellowFr() {
		return this.yellowFr;
	}
	
	/**
	 * Column Info
	 * @return rptItmNm
	 */
	public String getRptItmNm() {
		return this.rptItmNm;
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
	 * @param greenTo
	 */
	public void setGreenTo(String greenTo) {
		this.greenTo = greenTo;
	}
	
	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param yellowTo
	 */
	public void setYellowTo(String yellowTo) {
		this.yellowTo = yellowTo;
	}
	
	/**
	 * Column Info
	 * @param greenFr
	 */
	public void setGreenFr(String greenFr) {
		this.greenFr = greenFr;
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
	 * @param redTo
	 */
	public void setRedTo(String redTo) {
		this.redTo = redTo;
	}
	
	/**
	 * Column Info
	 * @param dbdIrrTpCd
	 */
	public void setDbdIrrTpCd(String dbdIrrTpCd) {
		this.dbdIrrTpCd = dbdIrrTpCd;
	}
	
	/**
	 * Column Info
	 * @param redFr
	 */
	public void setRedFr(String redFr) {
		this.redFr = redFr;
	}
	
	/**
	 * Column Info
	 * @param yellowFr
	 */
	public void setYellowFr(String yellowFr) {
		this.yellowFr = yellowFr;
	}
	
	/**
	 * Column Info
	 * @param rptItmNm
	 */
	public void setRptItmNm(String rptItmNm) {
		this.rptItmNm = rptItmNm;
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
		setGreenTo(JSPUtil.getParameter(request, prefix + "green_to", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setYellowTo(JSPUtil.getParameter(request, prefix + "yellow_to", ""));
		setGreenFr(JSPUtil.getParameter(request, prefix + "green_fr", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRedTo(JSPUtil.getParameter(request, prefix + "red_to", ""));
		setDbdIrrTpCd(JSPUtil.getParameter(request, prefix + "dbd_irr_tp_cd", ""));
		setRedFr(JSPUtil.getParameter(request, prefix + "red_fr", ""));
		setYellowFr(JSPUtil.getParameter(request, prefix + "yellow_fr", ""));
		setRptItmNm(JSPUtil.getParameter(request, prefix + "rpt_itm_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DashboardReportSettingVO[]
	 */
	public DashboardReportSettingVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DashboardReportSettingVO[]
	 */
	public DashboardReportSettingVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DashboardReportSettingVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] greenTo = (JSPUtil.getParameter(request, prefix	+ "green_to", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] yellowTo = (JSPUtil.getParameter(request, prefix	+ "yellow_to", length));
			String[] greenFr = (JSPUtil.getParameter(request, prefix	+ "green_fr", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] redTo = (JSPUtil.getParameter(request, prefix	+ "red_to", length));
			String[] dbdIrrTpCd = (JSPUtil.getParameter(request, prefix	+ "dbd_irr_tp_cd", length));
			String[] redFr = (JSPUtil.getParameter(request, prefix	+ "red_fr", length));
			String[] yellowFr = (JSPUtil.getParameter(request, prefix	+ "yellow_fr", length));
			String[] rptItmNm = (JSPUtil.getParameter(request, prefix	+ "rpt_itm_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new DashboardReportSettingVO();
				if (greenTo[i] != null)
					model.setGreenTo(greenTo[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (yellowTo[i] != null)
					model.setYellowTo(yellowTo[i]);
				if (greenFr[i] != null)
					model.setGreenFr(greenFr[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (redTo[i] != null)
					model.setRedTo(redTo[i]);
				if (dbdIrrTpCd[i] != null)
					model.setDbdIrrTpCd(dbdIrrTpCd[i]);
				if (redFr[i] != null)
					model.setRedFr(redFr[i]);
				if (yellowFr[i] != null)
					model.setYellowFr(yellowFr[i]);
				if (rptItmNm[i] != null)
					model.setRptItmNm(rptItmNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDashboardReportSettingVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DashboardReportSettingVO[]
	 */
	public DashboardReportSettingVO[] getDashboardReportSettingVOs(){
		DashboardReportSettingVO[] vos = (DashboardReportSettingVO[])models.toArray(new DashboardReportSettingVO[models.size()]);
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
		this.greenTo = this.greenTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yellowTo = this.yellowTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.greenFr = this.greenFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.redTo = this.redTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dbdIrrTpCd = this.dbdIrrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.redFr = this.redFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yellowFr = this.yellowFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptItmNm = this.rptItmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
