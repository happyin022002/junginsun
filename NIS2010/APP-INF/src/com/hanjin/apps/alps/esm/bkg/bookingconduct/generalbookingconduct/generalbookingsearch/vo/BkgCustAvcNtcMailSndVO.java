/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BkgCustAvcNtcMailSndVO.java
 *@FileTitle : BkgCustAvcNtcMailSndVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.07.12
 *@LastModifier : 이인영
 *@LastVersion : 1.0
 * 2011.07.12 이인영
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.vo.ReportDesignerExportVO;
import com.hanjin.framework.table.ComRptDsgnXptInfoVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박미옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgCustAvcNtcMailSndVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private String blNo = null;

	private String cntrNo = null;

	private String sndDt = null;

	private String rmk = null;

	/* BCC로 받는 사람 메일 주소 */
	private String bccRcvrEml = null;

	/* CC로 받는 사람 메일 주소 */
	private String ccRcvrEml = null;

	/* 보내는 사람 메일 주소 */
	private String sndrEml = null;

	/* 보내는 사람명 */
	private String sndrNm = null;

	/* 받는 사람 메일 주소 */
	private String rcvrEml = null;

	// private List<String> rcvrEmls = null;

	/* 받는 사람 이름 */
	private String rcvrNm = null;

	// private List<String> rcvrNms = null;

	/* Mail 제목 */
	private String emlTitNm = null;

	/* Text로 된 본문 내용 */
	private String textContent = null;

	/* HTML로 된 본문 내용 */
	private String htmlContent = null;

	/* 템플릿 */
	private String template = null;

	/* Arguments */
	private Map<String, String> arguments = null;

	/* 첨부 파일 */
	private String fileKey = null;

	/* USER ID */
	private String userId = null;

	private String cntrNoViewFlg = null;

	/* RD 정보 */
	List<ReportDesignerExportVO> rdExportVOs = null;

	/* RD 정보 */
	List<ComRptDsgnXptInfoVO> comRptDsgnXptInfoVOs;

	public BkgCustAvcNtcMailSndVO() {
	}

	@Override
	public HashMap<String, String> getColumnValues() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, String> getFieldNames() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getBlNo() {
		return blNo;
	}

	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	public String getCntrNo() {
		return cntrNo;
	}

	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	public String getSndDt() {
		return sndDt;
	}

	public void setSndDt(String sndDt) {
		this.sndDt = sndDt;
	}

	public String getRmk() {
		return rmk;
	}

	public void setRmk(String rmk) {
		this.rmk = rmk;
	}

	/**
	 * @param bccRcvrEml
	 *            the bccRcvrEml to set
	 */
	public void setBccRcvrEml(String bccRcvrEml) {
		this.bccRcvrEml = bccRcvrEml;
	}

	/**
	 * @return the bccRcvrEml
	 */
	public String getBccRcvrEml() {
		return bccRcvrEml;
	}

	/**
	 * @param ccRcvrEml
	 *            the ccRcvrEml to set
	 */
	public void setCcRcvrEml(String ccRcvrEml) {
		this.ccRcvrEml = ccRcvrEml;
	}

	/**
	 * @return the ccRcvrEml
	 */
	public String getCcRcvrEml() {
		return ccRcvrEml;
	}

	/**
	 * @param sndrEml
	 *            the sndrEml to set
	 */
	public void setSndrEml(String sndrEml) {
		this.sndrEml = sndrEml;
	}

	/**
	 * @return the sndrEml
	 */
	public String getSndrEml() {
		return sndrEml;
	}

	/**
	 * @param sndrNm
	 *            the sndrNm to set
	 */
	public void setSndrNm(String sndrNm) {
		this.sndrNm = sndrNm;
	}

	/**
	 * @return the sndrNm
	 */
	public String getSndrNm() {
		return sndrNm;
	}

	/**
	 * @param rcvrEml
	 *            the rcvrEml to set
	 */
	public void setRcvrEml(String rcvrEml) {
		this.rcvrEml = rcvrEml;
	}

	/**
	 * @return the rcvrEml
	 */
	public String getRcvrEml() {
		return rcvrEml;
	}

	/**
	 * @param rcvrNm
	 *            the rcvrNm to set
	 */
	public void setRcvrNm(String rcvrNm) {
		this.rcvrNm = rcvrNm;
	}

	/**
	 * @return the rcvrNm
	 */
	public String getRcvrNm() {
		return rcvrNm;
	}

	/**
	 * @param emlTitNm
	 *            the emlTitNm to set
	 */
	public void setEmlTitNm(String emlTitNm) {
		this.emlTitNm = emlTitNm;
	}

	/**
	 * @return the emlTitNm
	 */
	public String getEmlTitNm() {
		return emlTitNm;
	}

	/**
	 * @param textContent
	 *            the textContent to set
	 */
	public void setTextContent(String textContent) {
		this.textContent = textContent;
	}

	/**
	 * @return the textContent
	 */
	public String getTextContent() {
		return textContent;
	}

	/**
	 * @param htmlContent
	 *            the htmlContent to set
	 */
	public void setHtmlContent(String htmlContent) {
		this.htmlContent = htmlContent;
	}

	/**
	 * @return the htmlContent
	 */
	public String getHtmlContent() {
		return htmlContent;
	}

	/**
	 * @param template
	 *            the template to set
	 */
	public void setTemplate(String template) {
		this.template = template;
	}

	/**
	 * @return the template
	 */
	public String getTemplate() {
		return template;
	}

	/**
	 * @param arguments
	 *            the arguments to set
	 */
	public void setArguments(Map<String, String> arguments) {
		this.arguments = arguments;
	}

	/**
	 * @return the arguments
	 */
	public Map<String, String> getArguments() {
		return arguments;
	}

	/**
	 * @param fileKey
	 *            the fileKey to set
	 */
	public void setFileKey(String fileKey) {
		this.fileKey = fileKey;
	}

	/**
	 * @return the fileKey
	 */
	public String getFileKey() {
		return fileKey;
	}

	/**
	 * @param rdExportVOs
	 *            the rdExportVOs to set
	 */
	public void setRdExportVOs(List<ReportDesignerExportVO> rdExportVOs) {
		this.rdExportVOs = rdExportVOs;
	}

	/**
	 * @return the rdExportVOs
	 */
	public List<ReportDesignerExportVO> getRdExportVOs() {
		return rdExportVOs;
	}

	public List<ComRptDsgnXptInfoVO> getComRptDsgnXptInfoVOs() {
		return comRptDsgnXptInfoVOs;
	}

	public void setComRptDsgnXptInfoVOs(List<ComRptDsgnXptInfoVO> comRptDsgnXptInfoVOs) {
		this.comRptDsgnXptInfoVOs = comRptDsgnXptInfoVOs;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCntrNoViewFlg() {
		return cntrNoViewFlg;
	}

	public void setCntrNoViewFlg(String cntrNoViewFlg) {
		this.cntrNoViewFlg = cntrNoViewFlg;
	}

}
