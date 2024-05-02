/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ReportItemVO.java
*@FileTitle : ReportItemVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.04
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.10.04 김상수 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.acm.acmreport.acmreport.vo;

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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ReportItemVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ReportItemVO> models = new ArrayList<ReportItemVO>();
	
	/* Column Info */
	private String slctItmFomDesc = null;
	/* Column Info */
	private String slctItmFomSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rptItmColNm = null;
	/* Column Info */
	private String saveFlag = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String acRptItmCd = null;
	/* Column Info */
	private String rptItmDesc = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ReportItemVO() {}

	public ReportItemVO(String ibflag, String pagerows, String saveFlag, String slctItmFomSeq, String slctItmFomDesc, String acRptItmCd, String rptItmColNm, String rptItmDesc, String usrId) {
		this.slctItmFomDesc = slctItmFomDesc;
		this.slctItmFomSeq = slctItmFomSeq;
		this.ibflag = ibflag;
		this.rptItmColNm = rptItmColNm;
		this.saveFlag = saveFlag;
		this.usrId = usrId;
		this.acRptItmCd = acRptItmCd;
		this.rptItmDesc = rptItmDesc;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("slct_itm_fom_desc", getSlctItmFomDesc());
		this.hashColumns.put("slct_itm_fom_seq", getSlctItmFomSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rpt_itm_col_nm", getRptItmColNm());
		this.hashColumns.put("save_flag", getSaveFlag());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("ac_rpt_itm_cd", getAcRptItmCd());
		this.hashColumns.put("rpt_itm_desc", getRptItmDesc());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("slct_itm_fom_desc", "slctItmFomDesc");
		this.hashFields.put("slct_itm_fom_seq", "slctItmFomSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rpt_itm_col_nm", "rptItmColNm");
		this.hashFields.put("save_flag", "saveFlag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("ac_rpt_itm_cd", "acRptItmCd");
		this.hashFields.put("rpt_itm_desc", "rptItmDesc");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return slctItmFomDesc
	 */
	public String getSlctItmFomDesc() {
		return this.slctItmFomDesc;
	}
	
	/**
	 * Column Info
	 * @return slctItmFomSeq
	 */
	public String getSlctItmFomSeq() {
		return this.slctItmFomSeq;
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
	 * @return rptItmColNm
	 */
	public String getRptItmColNm() {
		return this.rptItmColNm;
	}
	
	/**
	 * Column Info
	 * @return saveFlag
	 */
	public String getSaveFlag() {
		return this.saveFlag;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return acRptItmCd
	 */
	public String getAcRptItmCd() {
		return this.acRptItmCd;
	}
	
	/**
	 * Column Info
	 * @return rptItmDesc
	 */
	public String getRptItmDesc() {
		return this.rptItmDesc;
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
	 * @param slctItmFomDesc
	 */
	public void setSlctItmFomDesc(String slctItmFomDesc) {
		this.slctItmFomDesc = slctItmFomDesc;
	}
	
	/**
	 * Column Info
	 * @param slctItmFomSeq
	 */
	public void setSlctItmFomSeq(String slctItmFomSeq) {
		this.slctItmFomSeq = slctItmFomSeq;
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
	 * @param rptItmColNm
	 */
	public void setRptItmColNm(String rptItmColNm) {
		this.rptItmColNm = rptItmColNm;
	}
	
	/**
	 * Column Info
	 * @param saveFlag
	 */
	public void setSaveFlag(String saveFlag) {
		this.saveFlag = saveFlag;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param acRptItmCd
	 */
	public void setAcRptItmCd(String acRptItmCd) {
		this.acRptItmCd = acRptItmCd;
	}
	
	/**
	 * Column Info
	 * @param rptItmDesc
	 */
	public void setRptItmDesc(String rptItmDesc) {
		this.rptItmDesc = rptItmDesc;
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
		setSlctItmFomDesc(JSPUtil.getParameter(request, prefix + "slct_itm_fom_desc", ""));
		setSlctItmFomSeq(JSPUtil.getParameter(request, prefix + "slct_itm_fom_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRptItmColNm(JSPUtil.getParameter(request, prefix + "rpt_itm_col_nm", ""));
		setSaveFlag(JSPUtil.getParameter(request, prefix + "save_flag", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setAcRptItmCd(JSPUtil.getParameter(request, prefix + "ac_rpt_itm_cd", ""));
		setRptItmDesc(JSPUtil.getParameter(request, prefix + "rpt_itm_desc", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ReportItemVO[]
	 */
	public ReportItemVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ReportItemVO[]
	 */
	public ReportItemVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ReportItemVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] slctItmFomDesc = (JSPUtil.getParameter(request, prefix	+ "slct_itm_fom_desc", length));
			String[] slctItmFomSeq = (JSPUtil.getParameter(request, prefix	+ "slct_itm_fom_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rptItmColNm = (JSPUtil.getParameter(request, prefix	+ "rpt_itm_col_nm", length));
			String[] saveFlag = (JSPUtil.getParameter(request, prefix	+ "save_flag", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] acRptItmCd = (JSPUtil.getParameter(request, prefix	+ "ac_rpt_itm_cd", length));
			String[] rptItmDesc = (JSPUtil.getParameter(request, prefix	+ "rpt_itm_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ReportItemVO();
				if (slctItmFomDesc[i] != null)
					model.setSlctItmFomDesc(slctItmFomDesc[i]);
				if (slctItmFomSeq[i] != null)
					model.setSlctItmFomSeq(slctItmFomSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rptItmColNm[i] != null)
					model.setRptItmColNm(rptItmColNm[i]);
				if (saveFlag[i] != null)
					model.setSaveFlag(saveFlag[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (acRptItmCd[i] != null)
					model.setAcRptItmCd(acRptItmCd[i]);
				if (rptItmDesc[i] != null)
					model.setRptItmDesc(rptItmDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getReportItemVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ReportItemVO[]
	 */
	public ReportItemVO[] getReportItemVOs(){
		ReportItemVO[] vos = (ReportItemVO[])models.toArray(new ReportItemVO[models.size()]);
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
		this.slctItmFomDesc = this.slctItmFomDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slctItmFomSeq = this.slctItmFomSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptItmColNm = this.rptItmColNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saveFlag = this.saveFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acRptItmCd = this.acRptItmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptItmDesc = this.rptItmDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
