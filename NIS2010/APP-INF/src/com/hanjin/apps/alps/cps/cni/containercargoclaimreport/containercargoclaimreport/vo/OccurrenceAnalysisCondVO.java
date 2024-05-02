/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OccurrenceAnalysisCondVO.java
*@FileTitle : OccurrenceAnalysisCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.04
*@LastModifier : 박제성
*@LastVersion : 1.0
* 2010.02.04 박제성 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.cni.containercargoclaimreport.containercargoclaimreport.vo;

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
 * @author 박제성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OccurrenceAnalysisCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OccurrenceAnalysisCondVO> models = new ArrayList<OccurrenceAnalysisCondVO>();
	
	/* Column Info */
	private String fromPeriod = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pageNo = null;
	/* Column Info */
	private String reportBy = null;
	/* Column Info */
	private String toPeriod = null;
	/* Column Info */
	private String period = null;
	/* Column Info */
	private String rdbtn = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OccurrenceAnalysisCondVO() {}

	public OccurrenceAnalysisCondVO(String ibflag, String pagerows, String reportBy, String period, String fromPeriod, String toPeriod, String pageNo, String rdbtn) {
		this.fromPeriod = fromPeriod;
		this.ibflag = ibflag;
		this.pageNo = pageNo;
		this.reportBy = reportBy;
		this.toPeriod = toPeriod;
		this.period = period;
		this.rdbtn = rdbtn;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("from_period", getFromPeriod());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("page_no", getPageNo());
		this.hashColumns.put("report_by", getReportBy());
		this.hashColumns.put("to_period", getToPeriod());
		this.hashColumns.put("period", getPeriod());
		this.hashColumns.put("rdbtn", getRdbtn());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("from_period", "fromPeriod");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("page_no", "pageNo");
		this.hashFields.put("report_by", "reportBy");
		this.hashFields.put("to_period", "toPeriod");
		this.hashFields.put("period", "period");
		this.hashFields.put("rdbtn", "rdbtn");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fromPeriod
	 */
	public String getFromPeriod() {
		return this.fromPeriod;
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
	 * @return pageNo
	 */
	public String getPageNo() {
		return this.pageNo;
	}
	
	/**
	 * Column Info
	 * @return reportBy
	 */
	public String getReportBy() {
		return this.reportBy;
	}
	
	/**
	 * Column Info
	 * @return toPeriod
	 */
	public String getToPeriod() {
		return this.toPeriod;
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
	 * @return rdbtn
	 */
	public String getRdbtn() {
		return this.rdbtn;
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
	 * @param fromPeriod
	 */
	public void setFromPeriod(String fromPeriod) {
		this.fromPeriod = fromPeriod;
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
	 * @param pageNo
	 */
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	
	/**
	 * Column Info
	 * @param reportBy
	 */
	public void setReportBy(String reportBy) {
		this.reportBy = reportBy;
	}
	
	/**
	 * Column Info
	 * @param toPeriod
	 */
	public void setToPeriod(String toPeriod) {
		this.toPeriod = toPeriod;
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
	 * @param rdbtn
	 */
	public void setRdbtn(String rdbtn) {
		this.rdbtn = rdbtn;
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
		setFromPeriod(JSPUtil.getParameter(request, prefix + "from_period", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPageNo(JSPUtil.getParameter(request, prefix + "page_no", ""));
		setReportBy(JSPUtil.getParameter(request, prefix + "report_by", ""));
		setToPeriod(JSPUtil.getParameter(request, prefix + "to_period", ""));
		setPeriod(JSPUtil.getParameter(request, prefix + "period", ""));
		setRdbtn(JSPUtil.getParameter(request, prefix + "rdbtn", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OccurrenceAnalysisCondVO[]
	 */
	public OccurrenceAnalysisCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OccurrenceAnalysisCondVO[]
	 */
	public OccurrenceAnalysisCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OccurrenceAnalysisCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fromPeriod = (JSPUtil.getParameter(request, prefix	+ "from_period", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pageNo = (JSPUtil.getParameter(request, prefix	+ "page_no", length));
			String[] reportBy = (JSPUtil.getParameter(request, prefix	+ "report_by", length));
			String[] toPeriod = (JSPUtil.getParameter(request, prefix	+ "to_period", length));
			String[] period = (JSPUtil.getParameter(request, prefix	+ "period", length));
			String[] rdbtn = (JSPUtil.getParameter(request, prefix	+ "rdbtn", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new OccurrenceAnalysisCondVO();
				if (fromPeriod[i] != null)
					model.setFromPeriod(fromPeriod[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pageNo[i] != null)
					model.setPageNo(pageNo[i]);
				if (reportBy[i] != null)
					model.setReportBy(reportBy[i]);
				if (toPeriod[i] != null)
					model.setToPeriod(toPeriod[i]);
				if (period[i] != null)
					model.setPeriod(period[i]);
				if (rdbtn[i] != null)
					model.setRdbtn(rdbtn[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOccurrenceAnalysisCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OccurrenceAnalysisCondVO[]
	 */
	public OccurrenceAnalysisCondVO[] getOccurrenceAnalysisCondVOs(){
		OccurrenceAnalysisCondVO[] vos = (OccurrenceAnalysisCondVO[])models.toArray(new OccurrenceAnalysisCondVO[models.size()]);
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
		this.fromPeriod = this.fromPeriod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageNo = this.pageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reportBy = this.reportBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPeriod = this.toPeriod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.period = this.period .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdbtn = this.rdbtn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
