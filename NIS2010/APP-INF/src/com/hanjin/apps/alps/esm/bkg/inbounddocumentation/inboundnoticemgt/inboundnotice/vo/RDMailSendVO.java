/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MailSendVO.java
*@FileTitle : MailSendVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.07.28 박미옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo;

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

public class RDMailSendVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	/*  BCC로 받는 사람 메일 주소 */
	private String bccRcvrEml = null;
	
	/* CC로 받는 사람 메일 주소 */
	private String ccRcvrEml = null;
	
	/* 보내는 사람 메일 주소  */
	private String sndrEml = null;
	
	/* 보내는 사람명  */
	private String sndrNm = null;
	
	/* 받는 사람 메일 주소  */
	private String rcvrEml = null;
	
	//private List<String> rcvrEmls = null;
	
	/* 받는 사람 이름  */
	private String rcvrNm = null;
	
	//private List<String> rcvrNms = null;
	
	/* Mail 제목  */
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
	
	/* RD 정보 */
	List<ReportDesignerExportVO> rdExportVOs = null;
	
	/* RD 정보 */
	List<ComRptDsgnXptInfoVO> comRptDsgnXptInfoVOs;
	

	public RDMailSendVO() {}


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


	/**
	 * @param bccRcvrEml the bccRcvrEml to set
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
	 * @param ccRcvrEml the ccRcvrEml to set
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
	 * @param sndrEml the sndrEml to set
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
	 * @param sndrNm the sndrNm to set
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
	 * @param rcvrEml the rcvrEml to set
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


//	/**
//	 * @param rcvrEmls the rcvrEmls to set
//	 */
//	public void setRcvrEmls(List<String> rcvrEmls) {
//		this.rcvrEmls = rcvrEmls;
//	}
//
//
//	/**
//	 * @return the rcvrEmls
//	 */
//	public List<String> getRcvrEmls() {
//		return rcvrEmls;
//	}


	/**
	 * @param rcvrNm the rcvrNm to set
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


//	/**
//	 * @param rcvrNms the rcvrNms to set
//	 */
//	public void setRcvrNms(List<String> rcvrNms) {
//		this.rcvrNms = rcvrNms;
//	}
//
//
//	/**
//	 * @return the rcvrNms
//	 */
//	public List<String> getRcvrNms() {
//		return rcvrNms;
//	}


	/**
	 * @param emlTitNm the emlTitNm to set
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
	 * @param textContent the textContent to set
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
	 * @param htmlContent the htmlContent to set
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
	 * @param template the template to set
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
	 * @param arguments the arguments to set
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
	 * @param fileKey the fileKey to set
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
	 * @param rdExportVOs the rdExportVOs to set
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


	public void setComRptDsgnXptInfoVOs(
			List<ComRptDsgnXptInfoVO> comRptDsgnXptInfoVOs) {
		this.comRptDsgnXptInfoVOs = comRptDsgnXptInfoVOs;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
