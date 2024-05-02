/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ComCsrInfoVO.java
*@FileTitle : ComCsrInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.08
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.08  
* 1.0 Creation
=========================================================*/

package com.hanjin.bizcommon.csr.csrapproval.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class ComCsrInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ComCsrInfoVO> models = new ArrayList<ComCsrInfoVO>();
	
	/* Column Info */
	private String aproUsrJbTitNm = null;
	/* Column Info */
	private String result = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String requestId = null;
	/* Column Info */
	private String xmlData = null;
	/* Column Info */
	private String sysDocId = null;
	/* Column Info */
	private String aproUsrNm = null;
	/* Column Info */
	private String userTp = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String resultMsg = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String agmtDocCfmCd = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String sysTp = null;
	/* Column Info */
	private String csrAproTpCd = null;
	/* Column Info */
	private String gwAgmtDocCfmCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ComCsrInfoVO() {}

	public ComCsrInfoVO(String ibflag, String pagerows, String aproUsrJbTitNm, String result, String csrNo, String requestId, String xmlData, String sysDocId, String aproUsrNm, String userTp, String resultMsg, String agmtDocCfmCd, String userId, String sysTp, String gwAgmtDocCfmCd, String ofcCd, String csrAproTpCd) {
		this.aproUsrJbTitNm = aproUsrJbTitNm;
		this.result = result;
		this.csrNo = csrNo;
		this.requestId = requestId;
		this.xmlData = xmlData;
		this.sysDocId = sysDocId;
		this.aproUsrNm = aproUsrNm;
		this.userTp = userTp;
		this.pagerows = pagerows;
		this.resultMsg = resultMsg;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.agmtDocCfmCd = agmtDocCfmCd;
		this.userId = userId;
		this.sysTp = sysTp;
		this.csrAproTpCd = csrAproTpCd;
		this.gwAgmtDocCfmCd = gwAgmtDocCfmCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("apro_usr_jb_tit_nm", getAproUsrJbTitNm());
		this.hashColumns.put("result", getResult());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("request_id", getRequestId());
		this.hashColumns.put("xml_data", getXmlData());
		this.hashColumns.put("sys_doc_id", getSysDocId());
		this.hashColumns.put("apro_usr_nm", getAproUsrNm());
		this.hashColumns.put("user_tp", getUserTp());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("result_msg", getResultMsg());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("agmt_doc_cfm_cd", getAgmtDocCfmCd());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("sys_tp", getSysTp());
		this.hashColumns.put("csr_apro_tp_cd", getCsrAproTpCd());
		this.hashColumns.put("gw_agmt_doc_cfm_cd", getGwAgmtDocCfmCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("apro_usr_jb_tit_nm", "aproUsrJbTitNm");
		this.hashFields.put("result", "result");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("request_id", "requestId");
		this.hashFields.put("xml_data", "xmlData");
		this.hashFields.put("sys_doc_id", "sysDocId");
		this.hashFields.put("apro_usr_nm", "aproUsrNm");
		this.hashFields.put("user_tp", "userTp");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("result_msg", "resultMsg");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("agmt_doc_cfm_cd", "agmtDocCfmCd");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("sys_tp", "sysTp");
		this.hashFields.put("csr_apro_tp_cd", "csrAproTpCd");
		this.hashFields.put("gw_agmt_doc_cfm_cd", "gwAgmtDocCfmCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return aproUsrJbTitNm
	 */
	public String getAproUsrJbTitNm() {
		return this.aproUsrJbTitNm;
	}
	
	/**
	 * Column Info
	 * @return result
	 */
	public String getResult() {
		return this.result;
	}
	
	/**
	 * Column Info
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
	}
	
	/**
	 * Column Info
	 * @return requestId
	 */
	public String getRequestId() {
		return this.requestId;
	}
	
	/**
	 * Column Info
	 * @return xmlData
	 */
	public String getXmlData() {
		return this.xmlData;
	}
	
	/**
	 * Column Info
	 * @return sysDocId
	 */
	public String getSysDocId() {
		return this.sysDocId;
	}
	
	/**
	 * Column Info
	 * @return aproUsrNm
	 */
	public String getAproUsrNm() {
		return this.aproUsrNm;
	}
	
	/**
	 * Column Info
	 * @return userTp
	 */
	public String getUserTp() {
		return this.userTp;
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
	 * @return resultMsg
	 */
	public String getResultMsg() {
		return this.resultMsg;
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
	 * @return agmtDocCfmCd
	 */
	public String getAgmtDocCfmCd() {
		return this.agmtDocCfmCd;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return sysTp
	 */
	public String getSysTp() {
		return this.sysTp;
	}
	
	/**
	 * Column Info
	 * @return csrAproTpCd
	 */
	public String getCsrAproTpCd() {
		return this.csrAproTpCd;
	}
	
	/**
	 * Column Info
	 * @return gwAgmtDocCfmCd
	 */
	public String getGwAgmtDocCfmCd() {
		return this.gwAgmtDocCfmCd;
	}
	

	/**
	 * Column Info
	 * @param aproUsrJbTitNm
	 */
	public void setAproUsrJbTitNm(String aproUsrJbTitNm) {
		this.aproUsrJbTitNm = aproUsrJbTitNm;
	}
	
	/**
	 * Column Info
	 * @param result
	 */
	public void setResult(String result) {
		this.result = result;
	}
	
	/**
	 * Column Info
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}
	
	/**
	 * Column Info
	 * @param requestId
	 */
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	
	/**
	 * Column Info
	 * @param xmlData
	 */
	public void setXmlData(String xmlData) {
		this.xmlData = xmlData;
	}
	
	/**
	 * Column Info
	 * @param sysDocId
	 */
	public void setSysDocId(String sysDocId) {
		this.sysDocId = sysDocId;
	}
	
	/**
	 * Column Info
	 * @param aproUsrNm
	 */
	public void setAproUsrNm(String aproUsrNm) {
		this.aproUsrNm = aproUsrNm;
	}
	
	/**
	 * Column Info
	 * @param userTp
	 */
	public void setUserTp(String userTp) {
		this.userTp = userTp;
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
	 * @param resultMsg
	 */
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
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
	 * @param agmtDocCfmCd
	 */
	public void setAgmtDocCfmCd(String agmtDocCfmCd) {
		this.agmtDocCfmCd = agmtDocCfmCd;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param sysTp
	 */
	public void setSysTp(String sysTp) {
		this.sysTp = sysTp;
	}
	
	/**
	 * Column Info
	 * @param csrAproTpCd
	 */
	public void setCsrAproTpCd(String csrAproTpCd) {
		this.csrAproTpCd = csrAproTpCd;
	}
	
	/**
	 * Column Info
	 * @param gwAgmtDocCfmCd
	 */
	public void setGwAgmtDocCfmCd(String gwAgmtDocCfmCd) {
		this.gwAgmtDocCfmCd = gwAgmtDocCfmCd;
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
		setAproUsrJbTitNm(JSPUtil.getParameter(request, prefix + "apro_usr_jb_tit_nm", ""));
		setResult(JSPUtil.getParameter(request, prefix + "result", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setRequestId(JSPUtil.getParameter(request, prefix + "request_id", ""));
		setXmlData(JSPUtil.getParameter(request, prefix + "xml_data", ""));
		setSysDocId(JSPUtil.getParameter(request, prefix + "sys_doc_id", ""));
		setAproUsrNm(JSPUtil.getParameter(request, prefix + "apro_usr_nm", ""));
		setUserTp(JSPUtil.getParameter(request, prefix + "user_tp", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setResultMsg(JSPUtil.getParameter(request, prefix + "result_msg", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAgmtDocCfmCd(JSPUtil.getParameter(request, prefix + "agmt_doc_cfm_cd", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setSysTp(JSPUtil.getParameter(request, prefix + "sys_tp", ""));
		setCsrAproTpCd(JSPUtil.getParameter(request, prefix + "csr_apro_tp_cd", ""));
		setGwAgmtDocCfmCd(JSPUtil.getParameter(request, prefix + "gw_agmt_doc_cfm_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ComCsrInfoVO[]
	 */
	public ComCsrInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ComCsrInfoVO[]
	 */
	public ComCsrInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ComCsrInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] aproUsrJbTitNm = (JSPUtil.getParameter(request, prefix	+ "apro_usr_jb_tit_nm", length));
			String[] result = (JSPUtil.getParameter(request, prefix	+ "result", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] requestId = (JSPUtil.getParameter(request, prefix	+ "request_id", length));
			String[] xmlData = (JSPUtil.getParameter(request, prefix	+ "xml_data", length));
			String[] sysDocId = (JSPUtil.getParameter(request, prefix	+ "sys_doc_id", length));
			String[] aproUsrNm = (JSPUtil.getParameter(request, prefix	+ "apro_usr_nm", length));
			String[] userTp = (JSPUtil.getParameter(request, prefix	+ "user_tp", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] resultMsg = (JSPUtil.getParameter(request, prefix	+ "result_msg", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] agmtDocCfmCd = (JSPUtil.getParameter(request, prefix	+ "agmt_doc_cfm_cd", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] sysTp = (JSPUtil.getParameter(request, prefix	+ "sys_tp", length));
			String[] csrAproTpCd = (JSPUtil.getParameter(request, prefix	+ "csr_apro_tp_cd", length));
			String[] gwAgmtDocCfmCd = (JSPUtil.getParameter(request, prefix	+ "gw_agmt_doc_cfm_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ComCsrInfoVO();
				if (aproUsrJbTitNm[i] != null)
					model.setAproUsrJbTitNm(aproUsrJbTitNm[i]);
				if (result[i] != null)
					model.setResult(result[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (requestId[i] != null)
					model.setRequestId(requestId[i]);
				if (xmlData[i] != null)
					model.setXmlData(xmlData[i]);
				if (sysDocId[i] != null)
					model.setSysDocId(sysDocId[i]);
				if (aproUsrNm[i] != null)
					model.setAproUsrNm(aproUsrNm[i]);
				if (userTp[i] != null)
					model.setUserTp(userTp[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (resultMsg[i] != null)
					model.setResultMsg(resultMsg[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (agmtDocCfmCd[i] != null)
					model.setAgmtDocCfmCd(agmtDocCfmCd[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (sysTp[i] != null)
					model.setSysTp(sysTp[i]);
				if (csrAproTpCd[i] != null)
					model.setCsrAproTpCd(csrAproTpCd[i]);
				if (gwAgmtDocCfmCd[i] != null)
					model.setGwAgmtDocCfmCd(gwAgmtDocCfmCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getComCsrInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ComCsrInfoVO[]
	 */
	public ComCsrInfoVO[] getComCsrInfoVOs(){
		ComCsrInfoVO[] vos = (ComCsrInfoVO[])models.toArray(new ComCsrInfoVO[models.size()]);
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
		this.aproUsrJbTitNm = this.aproUsrJbTitNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.result = this.result .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.requestId = this.requestId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xmlData = this.xmlData .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysDocId = this.sysDocId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrNm = this.aproUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userTp = this.userTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.resultMsg = this.resultMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtDocCfmCd = this.agmtDocCfmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysTp = this.sysTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrAproTpCd = this.csrAproTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gwAgmtDocCfmCd = this.gwAgmtDocCfmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
