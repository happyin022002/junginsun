/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DisposalNVO.java
*@FileTitle : DisposalNVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.05
*@LastModifier : 
*@LastVersion : 1.0
* 2011.08.29  
* 1.0 Creation
* --------------------------------------------------------
* History
* 2012.06.04 신혜정 [CHM-201218271-01] 조회조건에 Regional HQ, Office 항목 추가  
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo;

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

public class DisposalNVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DisposalNVO> models = new ArrayList<DisposalNVO>();
	
	/* Column Info */
	private String selfOfcCd = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String inEqKndCd = null;
	/* Column Info */
	private String invNoList = null;
	/* Column Info */
	private String mnrGrpTpCd = null;
	/* Column Info */
	private String inDispStsCd = null;
	/* Column Info */
	private String arHdQtrOfcCd = null;
	/* Column Info */
	private String inDispTpCd = null;
	/* Column Info */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String inAproStDt = null;
	/* Column Info */
	private String inAproEndDt = null;
	/* Column Info */
	private String inputDateTypeCode = null;
	/* Column Info */
	private String dispNoList = null;
	/* Column Info */
	private String inputStatusTypeCode = null;
	/* Column Info */
	private String dispSearchType = null;
	/* Column Info */
	private String eqNoList = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DisposalNVO() {}

	public DisposalNVO(String ibflag, String pagerows, String selfOfcCd, String rhqCd, String inEqKndCd, String invNoList, String mnrGrpTpCd, String inDispStsCd, String inDispTpCd, String inAproStDt, String inAproEndDt, String inputDateTypeCode, String dispNoList, String inputStatusTypeCode, String dispSearchType, String eqNoList, String arHdQtrOfcCd, String ofcCd) {
		this.selfOfcCd = selfOfcCd;
		this.rhqCd = rhqCd;
		this.inEqKndCd = inEqKndCd;
		this.invNoList = invNoList;
		this.mnrGrpTpCd = mnrGrpTpCd;
		this.inDispStsCd = inDispStsCd;
		this.arHdQtrOfcCd = arHdQtrOfcCd;
		this.inDispTpCd = inDispTpCd;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.inAproStDt = inAproStDt;
		this.inAproEndDt = inAproEndDt;
		this.inputDateTypeCode = inputDateTypeCode;
		this.dispNoList = dispNoList;
		this.inputStatusTypeCode = inputStatusTypeCode;
		this.dispSearchType = dispSearchType;
		this.eqNoList = eqNoList;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("self_ofc_cd", getSelfOfcCd());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("in_eq_knd_cd", getInEqKndCd());
		this.hashColumns.put("inv_no_list", getInvNoList());
		this.hashColumns.put("mnr_grp_tp_cd", getMnrGrpTpCd());
		this.hashColumns.put("in_disp_sts_cd", getInDispStsCd());
		this.hashColumns.put("ar_hd_qtr_ofc_cd", getArHdQtrOfcCd());
		this.hashColumns.put("in_disp_tp_cd", getInDispTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("in_apro_st_dt", getInAproStDt());
		this.hashColumns.put("in_apro_end_dt", getInAproEndDt());
		this.hashColumns.put("input_date_type_code", getInputDateTypeCode());
		this.hashColumns.put("disp_no_list", getDispNoList());
		this.hashColumns.put("input_status_type_code", getInputStatusTypeCode());
		this.hashColumns.put("disp_search_type", getDispSearchType());
		this.hashColumns.put("eq_no_list", getEqNoList());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("self_ofc_cd", "selfOfcCd");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("in_eq_knd_cd", "inEqKndCd");
		this.hashFields.put("inv_no_list", "invNoList");
		this.hashFields.put("mnr_grp_tp_cd", "mnrGrpTpCd");
		this.hashFields.put("in_disp_sts_cd", "inDispStsCd");
		this.hashFields.put("ar_hd_qtr_ofc_cd", "arHdQtrOfcCd");
		this.hashFields.put("in_disp_tp_cd", "inDispTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("in_apro_st_dt", "inAproStDt");
		this.hashFields.put("in_apro_end_dt", "inAproEndDt");
		this.hashFields.put("input_date_type_code", "inputDateTypeCode");
		this.hashFields.put("disp_no_list", "dispNoList");
		this.hashFields.put("input_status_type_code", "inputStatusTypeCode");
		this.hashFields.put("disp_search_type", "dispSearchType");
		this.hashFields.put("eq_no_list", "eqNoList");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return selfOfcCd
	 */
	public String getSelfOfcCd() {
		return this.selfOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return inEqKndCd
	 */
	public String getInEqKndCd() {
		return this.inEqKndCd;
	}
	
	/**
	 * Column Info
	 * @return invNoList
	 */
	public String getInvNoList() {
		return this.invNoList;
	}
	
	/**
	 * Column Info
	 * @return mnrGrpTpCd
	 */
	public String getMnrGrpTpCd() {
		return this.mnrGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @return inDispStsCd
	 */
	public String getInDispStsCd() {
		return this.inDispStsCd;
	}
	
	/**
	 * Column Info
	 * @return arHdQtrOfcCd
	 */
	public String getArHdQtrOfcCd() {
		return this.arHdQtrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return inDispTpCd
	 */
	public String getInDispTpCd() {
		return this.inDispTpCd;
	}
	
	/**
	 * Column Info
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return inAproStDt
	 */
	public String getInAproStDt() {
		return this.inAproStDt;
	}
	
	/**
	 * Column Info
	 * @return inAproEndDt
	 */
	public String getInAproEndDt() {
		return this.inAproEndDt;
	}
	
	/**
	 * Column Info
	 * @return inputDateTypeCode
	 */
	public String getInputDateTypeCode() {
		return this.inputDateTypeCode;
	}
	
	/**
	 * Column Info
	 * @return dispNoList
	 */
	public String getDispNoList() {
		return this.dispNoList;
	}
	
	/**
	 * Column Info
	 * @return inputStatusTypeCode
	 */
	public String getInputStatusTypeCode() {
		return this.inputStatusTypeCode;
	}
	
	/**
	 * Column Info
	 * @return dispSearchType
	 */
	public String getDispSearchType() {
		return this.dispSearchType;
	}
	
	/**
	 * Column Info
	 * @return eqNoList
	 */
	public String getEqNoList() {
		return this.eqNoList;
	}
	

	/**
	 * Column Info
	 * @param selfOfcCd
	 */
	public void setSelfOfcCd(String selfOfcCd) {
		this.selfOfcCd = selfOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param inEqKndCd
	 */
	public void setInEqKndCd(String inEqKndCd) {
		this.inEqKndCd = inEqKndCd;
	}
	
	/**
	 * Column Info
	 * @param invNoList
	 */
	public void setInvNoList(String invNoList) {
		this.invNoList = invNoList;
	}
	
	/**
	 * Column Info
	 * @param mnrGrpTpCd
	 */
	public void setMnrGrpTpCd(String mnrGrpTpCd) {
		this.mnrGrpTpCd = mnrGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @param inDispStsCd
	 */
	public void setInDispStsCd(String inDispStsCd) {
		this.inDispStsCd = inDispStsCd;
	}
	
	/**
	 * Column Info
	 * @param arHdQtrOfcCd
	 */
	public void setArHdQtrOfcCd(String arHdQtrOfcCd) {
		this.arHdQtrOfcCd = arHdQtrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param inDispTpCd
	 */
	public void setInDispTpCd(String inDispTpCd) {
		this.inDispTpCd = inDispTpCd;
	}
	
	/**
	 * Column Info
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param inAproStDt
	 */
	public void setInAproStDt(String inAproStDt) {
		this.inAproStDt = inAproStDt;
	}
	
	/**
	 * Column Info
	 * @param inAproEndDt
	 */
	public void setInAproEndDt(String inAproEndDt) {
		this.inAproEndDt = inAproEndDt;
	}
	
	/**
	 * Column Info
	 * @param inputDateTypeCode
	 */
	public void setInputDateTypeCode(String inputDateTypeCode) {
		this.inputDateTypeCode = inputDateTypeCode;
	}
	
	/**
	 * Column Info
	 * @param dispNoList
	 */
	public void setDispNoList(String dispNoList) {
		this.dispNoList = dispNoList;
	}
	
	/**
	 * Column Info
	 * @param inputStatusTypeCode
	 */
	public void setInputStatusTypeCode(String inputStatusTypeCode) {
		this.inputStatusTypeCode = inputStatusTypeCode;
	}
	
	/**
	 * Column Info
	 * @param dispSearchType
	 */
	public void setDispSearchType(String dispSearchType) {
		this.dispSearchType = dispSearchType;
	}
	
	/**
	 * Column Info
	 * @param eqNoList
	 */
	public void setEqNoList(String eqNoList) {
		this.eqNoList = eqNoList;
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
		setSelfOfcCd(JSPUtil.getParameter(request, prefix + "self_ofc_cd", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setInEqKndCd(JSPUtil.getParameter(request, prefix + "in_eq_knd_cd", ""));
		setInvNoList(JSPUtil.getParameter(request, prefix + "inv_no_list", ""));
		setMnrGrpTpCd(JSPUtil.getParameter(request, prefix + "mnr_grp_tp_cd", ""));
		setInDispStsCd(JSPUtil.getParameter(request, prefix + "in_disp_sts_cd", ""));
		setArHdQtrOfcCd(JSPUtil.getParameter(request, prefix + "ar_hd_qtr_ofc_cd", ""));
		setInDispTpCd(JSPUtil.getParameter(request, prefix + "in_disp_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInAproStDt(JSPUtil.getParameter(request, prefix + "in_apro_st_dt", ""));
		setInAproEndDt(JSPUtil.getParameter(request, prefix + "in_apro_end_dt", ""));
		setInputDateTypeCode(JSPUtil.getParameter(request, prefix + "input_date_type_code", ""));
		setDispNoList(JSPUtil.getParameter(request, prefix + "disp_no_list", ""));
		setInputStatusTypeCode(JSPUtil.getParameter(request, prefix + "input_status_type_code", ""));
		setDispSearchType(JSPUtil.getParameter(request, prefix + "disp_search_type", ""));
		setEqNoList(JSPUtil.getParameter(request, prefix + "eq_no_list", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DisposalNVO[]
	 */
	public DisposalNVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DisposalNVO[]
	 */
	public DisposalNVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DisposalNVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] selfOfcCd = (JSPUtil.getParameter(request, prefix	+ "self_ofc_cd", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] inEqKndCd = (JSPUtil.getParameter(request, prefix	+ "in_eq_knd_cd", length));
			String[] invNoList = (JSPUtil.getParameter(request, prefix	+ "inv_no_list", length));
			String[] mnrGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_grp_tp_cd", length));
			String[] inDispStsCd = (JSPUtil.getParameter(request, prefix	+ "in_disp_sts_cd", length));
			String[] arHdQtrOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_hd_qtr_ofc_cd", length));
			String[] inDispTpCd = (JSPUtil.getParameter(request, prefix	+ "in_disp_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] inAproStDt = (JSPUtil.getParameter(request, prefix	+ "in_apro_st_dt", length));
			String[] inAproEndDt = (JSPUtil.getParameter(request, prefix	+ "in_apro_end_dt", length));
			String[] inputDateTypeCode = (JSPUtil.getParameter(request, prefix	+ "input_date_type_code", length));
			String[] dispNoList = (JSPUtil.getParameter(request, prefix	+ "disp_no_list", length));
			String[] inputStatusTypeCode = (JSPUtil.getParameter(request, prefix	+ "input_status_type_code", length));
			String[] dispSearchType = (JSPUtil.getParameter(request, prefix	+ "disp_search_type", length));
			String[] eqNoList = (JSPUtil.getParameter(request, prefix	+ "eq_no_list", length));
			
			for (int i = 0; i < length; i++) {
				model = new DisposalNVO();
				if (selfOfcCd[i] != null)
					model.setSelfOfcCd(selfOfcCd[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (inEqKndCd[i] != null)
					model.setInEqKndCd(inEqKndCd[i]);
				if (invNoList[i] != null)
					model.setInvNoList(invNoList[i]);
				if (mnrGrpTpCd[i] != null)
					model.setMnrGrpTpCd(mnrGrpTpCd[i]);
				if (inDispStsCd[i] != null)
					model.setInDispStsCd(inDispStsCd[i]);
				if (arHdQtrOfcCd[i] != null)
					model.setArHdQtrOfcCd(arHdQtrOfcCd[i]);
				if (inDispTpCd[i] != null)
					model.setInDispTpCd(inDispTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inAproStDt[i] != null)
					model.setInAproStDt(inAproStDt[i]);
				if (inAproEndDt[i] != null)
					model.setInAproEndDt(inAproEndDt[i]);
				if (inputDateTypeCode[i] != null)
					model.setInputDateTypeCode(inputDateTypeCode[i]);
				if (dispNoList[i] != null)
					model.setDispNoList(dispNoList[i]);
				if (inputStatusTypeCode[i] != null)
					model.setInputStatusTypeCode(inputStatusTypeCode[i]);
				if (dispSearchType[i] != null)
					model.setDispSearchType(dispSearchType[i]);
				if (eqNoList[i] != null)
					model.setEqNoList(eqNoList[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDisposalNVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DisposalNVO[]
	 */
	public DisposalNVO[] getDisposalNVOs(){
		DisposalNVO[] vos = (DisposalNVO[])models.toArray(new DisposalNVO[models.size()]);
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
		this.selfOfcCd = this.selfOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inEqKndCd = this.inEqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNoList = this.invNoList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrGrpTpCd = this.mnrGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inDispStsCd = this.inDispStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arHdQtrOfcCd = this.arHdQtrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inDispTpCd = this.inDispTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inAproStDt = this.inAproStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inAproEndDt = this.inAproEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputDateTypeCode = this.inputDateTypeCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispNoList = this.dispNoList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputStatusTypeCode = this.inputStatusTypeCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispSearchType = this.dispSearchType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNoList = this.eqNoList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
