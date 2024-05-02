/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScgCondVO.java
*@FileTitle : ScgCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.11
*@LastModifier : 
*@LastVersion : 1.0
* 2013.11.11  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.report.scgreport.vo;

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

public class ScgCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ScgCondVO> models = new ArrayList<ScgCondVO>();
	
	/* Column Info */
	private String scgType = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fromDate = null;
	/* Column Info */
	private String month = null;
	/* Column Info */
	private String selOpTp = null;
	/* Column Info */
	private String toDate = null;
	/* Column Info */
	private String inputOffice = null;
	/* Column Info */
	private String woOfcCd = null;
	/* Column Info */
	private String invOfcCd = null;
	/* Column Info */
	private String selDate = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ScgCondVO() {}

	public ScgCondVO(String ibflag, String pagerows, String inputOffice, String selOpTp, String fromDate, String toDate, String woOfcCd, String invOfcCd, String scgType, String month, String selDate) {
		this.scgType = scgType;
		this.ibflag = ibflag;
		this.fromDate = fromDate;
		this.month = month;
		this.selOpTp = selOpTp;
		this.toDate = toDate;
		this.inputOffice = inputOffice;
		this.woOfcCd = woOfcCd;
		this.invOfcCd = invOfcCd;
		this.selDate = selDate;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("scg_type", getScgType());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("from_date", getFromDate());
		this.hashColumns.put("month", getMonth());
		this.hashColumns.put("sel_op_tp", getSelOpTp());
		this.hashColumns.put("to_date", getToDate());
		this.hashColumns.put("input_office", getInputOffice());
		this.hashColumns.put("wo_ofc_cd", getWoOfcCd());
		this.hashColumns.put("inv_ofc_cd", getInvOfcCd());
		this.hashColumns.put("sel_date", getSelDate());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("scg_type", "scgType");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("from_date", "fromDate");
		this.hashFields.put("month", "month");
		this.hashFields.put("sel_op_tp", "selOpTp");
		this.hashFields.put("to_date", "toDate");
		this.hashFields.put("input_office", "inputOffice");
		this.hashFields.put("wo_ofc_cd", "woOfcCd");
		this.hashFields.put("inv_ofc_cd", "invOfcCd");
		this.hashFields.put("sel_date", "selDate");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return scgType
	 */
	public String getScgType() {
		return this.scgType;
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
	 * @return fromDate
	 */
	public String getFromDate() {
		return this.fromDate;
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
	 * @return selOpTp
	 */
	public String getSelOpTp() {
		return this.selOpTp;
	}
	
	/**
	 * Column Info
	 * @return toDate
	 */
	public String getToDate() {
		return this.toDate;
	}
	
	/**
	 * Column Info
	 * @return inputOffice
	 */
	public String getInputOffice() {
		return this.inputOffice;
	}
	
	/**
	 * Column Info
	 * @return woOfcCd
	 */
	public String getWoOfcCd() {
		return this.woOfcCd;
	}
	
	/**
	 * Column Info
	 * @return invOfcCd
	 */
	public String getInvOfcCd() {
		return this.invOfcCd;
	}
	
	/**
	 * Column Info
	 * @return selDate
	 */
	public String getSelDate() {
		return this.selDate;
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
	 * @param scgType
	 */
	public void setScgType(String scgType) {
		this.scgType = scgType;
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
	 * @param fromDate
	 */
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
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
	 * @param selOpTp
	 */
	public void setSelOpTp(String selOpTp) {
		this.selOpTp = selOpTp;
	}
	
	/**
	 * Column Info
	 * @param toDate
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	
	/**
	 * Column Info
	 * @param inputOffice
	 */
	public void setInputOffice(String inputOffice) {
		this.inputOffice = inputOffice;
	}
	
	/**
	 * Column Info
	 * @param woOfcCd
	 */
	public void setWoOfcCd(String woOfcCd) {
		this.woOfcCd = woOfcCd;
	}
	
	/**
	 * Column Info
	 * @param invOfcCd
	 */
	public void setInvOfcCd(String invOfcCd) {
		this.invOfcCd = invOfcCd;
	}
	
	/**
	 * Column Info
	 * @param selDate
	 */
	public void setSelDate(String selDate) {
		this.selDate = selDate;
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
		setScgType(JSPUtil.getParameter(request, prefix + "scg_type", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFromDate(JSPUtil.getParameter(request, prefix + "from_date", ""));
		setMonth(JSPUtil.getParameter(request, prefix + "month", ""));
		setSelOpTp(JSPUtil.getParameter(request, prefix + "sel_op_tp", ""));
		setToDate(JSPUtil.getParameter(request, prefix + "to_date", ""));
		setInputOffice(JSPUtil.getParameter(request, prefix + "input_office", ""));
		setWoOfcCd(JSPUtil.getParameter(request, prefix + "wo_ofc_cd", ""));
		setInvOfcCd(JSPUtil.getParameter(request, prefix + "inv_ofc_cd", ""));
		setSelDate(JSPUtil.getParameter(request, prefix + "sel_date", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgCondVO[]
	 */
	public ScgCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ScgCondVO[]
	 */
	public ScgCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ScgCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] scgType = (JSPUtil.getParameter(request, prefix	+ "scg_type", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fromDate = (JSPUtil.getParameter(request, prefix	+ "from_date", length));
			String[] month = (JSPUtil.getParameter(request, prefix	+ "month", length));
			String[] selOpTp = (JSPUtil.getParameter(request, prefix	+ "sel_op_tp", length));
			String[] toDate = (JSPUtil.getParameter(request, prefix	+ "to_date", length));
			String[] inputOffice = (JSPUtil.getParameter(request, prefix	+ "input_office", length));
			String[] woOfcCd = (JSPUtil.getParameter(request, prefix	+ "wo_ofc_cd", length));
			String[] invOfcCd = (JSPUtil.getParameter(request, prefix	+ "inv_ofc_cd", length));
			String[] selDate = (JSPUtil.getParameter(request, prefix	+ "sel_date", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ScgCondVO();
				if (scgType[i] != null)
					model.setScgType(scgType[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fromDate[i] != null)
					model.setFromDate(fromDate[i]);
				if (month[i] != null)
					model.setMonth(month[i]);
				if (selOpTp[i] != null)
					model.setSelOpTp(selOpTp[i]);
				if (toDate[i] != null)
					model.setToDate(toDate[i]);
				if (inputOffice[i] != null)
					model.setInputOffice(inputOffice[i]);
				if (woOfcCd[i] != null)
					model.setWoOfcCd(woOfcCd[i]);
				if (invOfcCd[i] != null)
					model.setInvOfcCd(invOfcCd[i]);
				if (selDate[i] != null)
					model.setSelDate(selDate[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getScgCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ScgCondVO[]
	 */
	public ScgCondVO[] getScgCondVOs(){
		ScgCondVO[] vos = (ScgCondVO[])models.toArray(new ScgCondVO[models.size()]);
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
		this.scgType = this.scgType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDate = this.fromDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.month = this.month .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selOpTp = this.selOpTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDate = this.toDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputOffice = this.inputOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woOfcCd = this.woOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOfcCd = this.invOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selDate = this.selDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
