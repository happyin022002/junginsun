/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CHSHistoricalRptMGTVO.java
*@FileTitle : CHSHistoricalRptMGTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.08.26 조재성 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo;

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
 * @author 조재성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CHSHistoricalRptMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CHSHistoricalRptMGTVO> models = new ArrayList<CHSHistoricalRptMGTVO>();
	
	/* Column Info */
	private String reportType = null;
	/* Column Info */
	private String inqToDys = null;
	/* Column Info */
	private String crntLccCd = null;
	/* Column Info */
	private String inqFmDys = null;
	/* Column Info */
	private String crntYdCd = null;
	/* Column Info */
	private String period = null;
	/* Column Info */
	private String cntrPsnStsCd = null;
	/* Column Info */
	private String chss45ftQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String chss40ftQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* Column Info */
	private String periodType = null;
	/* Column Info */
	private String crntSccCd = null;
	/* Column Info */
	private String chss20ftQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CHSHistoricalRptMGTVO() {}

	public CHSHistoricalRptMGTVO(String ibflag, String pagerows, String crntLccCd, String crntSccCd, String crntYdCd, String inqFmDys, String inqToDys, String period, String periodType, String cnmvStsCd, String cntrPsnStsCd, String reportType, String chss20ftQty, String chss40ftQty, String chss45ftQty) {
		this.reportType = reportType;
		this.inqToDys = inqToDys;
		this.crntLccCd = crntLccCd;
		this.inqFmDys = inqFmDys;
		this.crntYdCd = crntYdCd;
		this.period = period;
		this.cntrPsnStsCd = cntrPsnStsCd;
		this.chss45ftQty = chss45ftQty;
		this.pagerows = pagerows;
		this.chss40ftQty = chss40ftQty;
		this.ibflag = ibflag;
		this.cnmvStsCd = cnmvStsCd;
		this.periodType = periodType;
		this.crntSccCd = crntSccCd;
		this.chss20ftQty = chss20ftQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("report_type", getReportType());
		this.hashColumns.put("inq_to_dys", getInqToDys());
		this.hashColumns.put("crnt_lcc_cd", getCrntLccCd());
		this.hashColumns.put("inq_fm_dys", getInqFmDys());
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());
		this.hashColumns.put("period", getPeriod());
		this.hashColumns.put("cntr_psn_sts_cd", getCntrPsnStsCd());
		this.hashColumns.put("chss_45ft_qty", getChss45ftQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("chss_40ft_qty", getChss40ftQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("period_type", getPeriodType());
		this.hashColumns.put("crnt_scc_cd", getCrntSccCd());
		this.hashColumns.put("chss_20ft_qty", getChss20ftQty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("report_type", "reportType");
		this.hashFields.put("inq_to_dys", "inqToDys");
		this.hashFields.put("crnt_lcc_cd", "crntLccCd");
		this.hashFields.put("inq_fm_dys", "inqFmDys");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("period", "period");
		this.hashFields.put("cntr_psn_sts_cd", "cntrPsnStsCd");
		this.hashFields.put("chss_45ft_qty", "chss45ftQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("chss_40ft_qty", "chss40ftQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("period_type", "periodType");
		this.hashFields.put("crnt_scc_cd", "crntSccCd");
		this.hashFields.put("chss_20ft_qty", "chss20ftQty");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return reportType
	 */
	public String getReportType() {
		return this.reportType;
	}
	
	/**
	 * Column Info
	 * @return inqToDys
	 */
	public String getInqToDys() {
		return this.inqToDys;
	}
	
	/**
	 * Column Info
	 * @return crntLccCd
	 */
	public String getCrntLccCd() {
		return this.crntLccCd;
	}
	
	/**
	 * Column Info
	 * @return inqFmDys
	 */
	public String getInqFmDys() {
		return this.inqFmDys;
	}
	
	/**
	 * Column Info
	 * @return crntYdCd
	 */
	public String getCrntYdCd() {
		return this.crntYdCd;
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
	 * @return cntrPsnStsCd
	 */
	public String getCntrPsnStsCd() {
		return this.cntrPsnStsCd;
	}
	
	/**
	 * Column Info
	 * @return chss45ftQty
	 */
	public String getChss45ftQty() {
		return this.chss45ftQty;
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
	 * @return chss40ftQty
	 */
	public String getChss40ftQty() {
		return this.chss40ftQty;
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
	 * @return cnmvStsCd
	 */
	public String getCnmvStsCd() {
		return this.cnmvStsCd;
	}
	
	/**
	 * Column Info
	 * @return periodType
	 */
	public String getPeriodType() {
		return this.periodType;
	}
	
	/**
	 * Column Info
	 * @return crntSccCd
	 */
	public String getCrntSccCd() {
		return this.crntSccCd;
	}
	
	/**
	 * Column Info
	 * @return chss20ftQty
	 */
	public String getChss20ftQty() {
		return this.chss20ftQty;
	}
	

	/**
	 * Column Info
	 * @param reportType
	 */
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	
	/**
	 * Column Info
	 * @param inqToDys
	 */
	public void setInqToDys(String inqToDys) {
		this.inqToDys = inqToDys;
	}
	
	/**
	 * Column Info
	 * @param crntLccCd
	 */
	public void setCrntLccCd(String crntLccCd) {
		this.crntLccCd = crntLccCd;
	}
	
	/**
	 * Column Info
	 * @param inqFmDys
	 */
	public void setInqFmDys(String inqFmDys) {
		this.inqFmDys = inqFmDys;
	}
	
	/**
	 * Column Info
	 * @param crntYdCd
	 */
	public void setCrntYdCd(String crntYdCd) {
		this.crntYdCd = crntYdCd;
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
	 * @param cntrPsnStsCd
	 */
	public void setCntrPsnStsCd(String cntrPsnStsCd) {
		this.cntrPsnStsCd = cntrPsnStsCd;
	}
	
	/**
	 * Column Info
	 * @param chss45ftQty
	 */
	public void setChss45ftQty(String chss45ftQty) {
		this.chss45ftQty = chss45ftQty;
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
	 * @param chss40ftQty
	 */
	public void setChss40ftQty(String chss40ftQty) {
		this.chss40ftQty = chss40ftQty;
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
	 * @param cnmvStsCd
	 */
	public void setCnmvStsCd(String cnmvStsCd) {
		this.cnmvStsCd = cnmvStsCd;
	}
	
	/**
	 * Column Info
	 * @param periodType
	 */
	public void setPeriodType(String periodType) {
		this.periodType = periodType;
	}
	
	/**
	 * Column Info
	 * @param crntSccCd
	 */
	public void setCrntSccCd(String crntSccCd) {
		this.crntSccCd = crntSccCd;
	}
	
	/**
	 * Column Info
	 * @param chss20ftQty
	 */
	public void setChss20ftQty(String chss20ftQty) {
		this.chss20ftQty = chss20ftQty;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setReportType(JSPUtil.getParameter(request, "report_type", ""));
		setInqToDys(JSPUtil.getParameter(request, "inq_to_dys", ""));
		setCrntLccCd(JSPUtil.getParameter(request, "crnt_lcc_cd", ""));
		setInqFmDys(JSPUtil.getParameter(request, "inq_fm_dys", ""));
		setCrntYdCd(JSPUtil.getParameter(request, "crnt_yd_cd", ""));
		setPeriod(JSPUtil.getParameter(request, "period", ""));
		setCntrPsnStsCd(JSPUtil.getParameter(request, "cntr_psn_sts_cd", ""));
		setChss45ftQty(JSPUtil.getParameter(request, "chss_45ft_qty", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setChss40ftQty(JSPUtil.getParameter(request, "chss_40ft_qty", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, "cnmv_sts_cd", ""));
		setPeriodType(JSPUtil.getParameter(request, "period_type", ""));
		setCrntSccCd(JSPUtil.getParameter(request, "crnt_scc_cd", ""));
		setChss20ftQty(JSPUtil.getParameter(request, "chss_20ft_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CHSHistoricalRptMGTVO[]
	 */
	public CHSHistoricalRptMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CHSHistoricalRptMGTVO[]
	 */
	public CHSHistoricalRptMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CHSHistoricalRptMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] reportType = (JSPUtil.getParameter(request, prefix	+ "report_type", length));
			String[] inqToDys = (JSPUtil.getParameter(request, prefix	+ "inq_to_dys", length));
			String[] crntLccCd = (JSPUtil.getParameter(request, prefix	+ "crnt_lcc_cd", length));
			String[] inqFmDys = (JSPUtil.getParameter(request, prefix	+ "inq_fm_dys", length));
			String[] crntYdCd = (JSPUtil.getParameter(request, prefix	+ "crnt_yd_cd", length));
			String[] period = (JSPUtil.getParameter(request, prefix	+ "period", length));
			String[] cntrPsnStsCd = (JSPUtil.getParameter(request, prefix	+ "cntr_psn_sts_cd", length));
			String[] chss45ftQty = (JSPUtil.getParameter(request, prefix	+ "chss_45ft_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] chss40ftQty = (JSPUtil.getParameter(request, prefix	+ "chss_40ft_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd", length));
			String[] periodType = (JSPUtil.getParameter(request, prefix	+ "period_type", length));
			String[] crntSccCd = (JSPUtil.getParameter(request, prefix	+ "crnt_scc_cd", length));
			String[] chss20ftQty = (JSPUtil.getParameter(request, prefix	+ "chss_20ft_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new CHSHistoricalRptMGTVO();
				if (reportType[i] != null)
					model.setReportType(reportType[i]);
				if (inqToDys[i] != null)
					model.setInqToDys(inqToDys[i]);
				if (crntLccCd[i] != null)
					model.setCrntLccCd(crntLccCd[i]);
				if (inqFmDys[i] != null)
					model.setInqFmDys(inqFmDys[i]);
				if (crntYdCd[i] != null)
					model.setCrntYdCd(crntYdCd[i]);
				if (period[i] != null)
					model.setPeriod(period[i]);
				if (cntrPsnStsCd[i] != null)
					model.setCntrPsnStsCd(cntrPsnStsCd[i]);
				if (chss45ftQty[i] != null)
					model.setChss45ftQty(chss45ftQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (chss40ftQty[i] != null)
					model.setChss40ftQty(chss40ftQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (periodType[i] != null)
					model.setPeriodType(periodType[i]);
				if (crntSccCd[i] != null)
					model.setCrntSccCd(crntSccCd[i]);
				if (chss20ftQty[i] != null)
					model.setChss20ftQty(chss20ftQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCHSHistoricalRptMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CHSHistoricalRptMGTVO[]
	 */
	public CHSHistoricalRptMGTVO[] getCHSHistoricalRptMGTVOs(){
		CHSHistoricalRptMGTVO[] vos = (CHSHistoricalRptMGTVO[])models.toArray(new CHSHistoricalRptMGTVO[models.size()]);
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
		this.reportType = this.reportType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inqToDys = this.inqToDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntLccCd = this.crntLccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inqFmDys = this.inqFmDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd = this.crntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.period = this.period .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPsnStsCd = this.cntrPsnStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chss45ftQty = this.chss45ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chss40ftQty = this.chss40ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.periodType = this.periodType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntSccCd = this.crntSccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chss20ftQty = this.chss20ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
