/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DashboardReportFormVO.java
*@FileTitle : DashboardReportFormVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.06
*@LastModifier : 
*@LastVersion : 1.0
* 2013.11.06  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.vo;


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

public class DashboardReportFormVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DashboardReportFormVO> models = new ArrayList<DashboardReportFormVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String rptFomNm = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String rptFomDesc = null;
	/* Column Info */
	private String rptFomNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DashboardReportFormVO() {}

	public DashboardReportFormVO(String ibflag, String pagerows, String rptFomNo, String rptFomNm, String rptFomDesc, String creDt, String creUsrId, String updDt, String updUsrId) {
		this.updDt = updDt;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.creDt = creDt;
		this.rptFomNm = rptFomNm;
		this.updUsrId = updUsrId;
		this.rptFomDesc = rptFomDesc;
		this.rptFomNo = rptFomNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("rpt_fom_nm", getRptFomNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("rpt_fom_desc", getRptFomDesc());
		this.hashColumns.put("rpt_fom_no", getRptFomNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("rpt_fom_nm", "rptFomNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("rpt_fom_desc", "rptFomDesc");
		this.hashFields.put("rpt_fom_no", "rptFomNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return rptFomNm
	 */
	public String getRptFomNm() {
		return this.rptFomNm;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return rptFomDesc
	 */
	public String getRptFomDesc() {
		return this.rptFomDesc;
	}
	
	/**
	 * Column Info
	 * @return rptFomNo
	 */
	public String getRptFomNo() {
		return this.rptFomNo;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param rptFomNm
	 */
	public void setRptFomNm(String rptFomNm) {
		this.rptFomNm = rptFomNm;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param rptFomDesc
	 */
	public void setRptFomDesc(String rptFomDesc) {
		this.rptFomDesc = rptFomDesc;
	}
	
	/**
	 * Column Info
	 * @param rptFomNo
	 */
	public void setRptFomNo(String rptFomNo) {
		this.rptFomNo = rptFomNo;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setRptFomNm(JSPUtil.getParameter(request, prefix + "rpt_fom_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setRptFomDesc(JSPUtil.getParameter(request, prefix + "rpt_fom_desc", ""));
		setRptFomNo(JSPUtil.getParameter(request, prefix + "rpt_fom_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DashboardReportFormVO[]
	 */
	public DashboardReportFormVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DashboardReportFormVO[]
	 */
	public DashboardReportFormVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DashboardReportFormVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] rptFomNm = (JSPUtil.getParameter(request, prefix	+ "rpt_fom_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] rptFomDesc = (JSPUtil.getParameter(request, prefix	+ "rpt_fom_desc", length));
			String[] rptFomNo = (JSPUtil.getParameter(request, prefix	+ "rpt_fom_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new DashboardReportFormVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (rptFomNm[i] != null)
					model.setRptFomNm(rptFomNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (rptFomDesc[i] != null)
					model.setRptFomDesc(rptFomDesc[i]);
				if (rptFomNo[i] != null)
					model.setRptFomNo(rptFomNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDashboardReportFormVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DashboardReportFormVO[]
	 */
	public DashboardReportFormVO[] getDashboardReportFormVOs(){
		DashboardReportFormVO[] vos = (DashboardReportFormVO[])models.toArray(new DashboardReportFormVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptFomNm = this.rptFomNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptFomDesc = this.rptFomDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptFomNo = this.rptFomNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
