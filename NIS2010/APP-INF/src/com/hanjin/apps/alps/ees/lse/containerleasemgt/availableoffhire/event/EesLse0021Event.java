/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0020Event.java
*@FileTitle : Off-Hire CNTR List - Send to Lessor
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.10.05 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.event;

import java.io.IOException;

import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.event.EES_LSE_0020HTMLAction;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireDetailVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.vo.EmailSendInfoVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.vo.SearchParamVO;
import com.hanjin.framework.component.util.io.FileUtils;
import com.hanjin.framework.core.config.SiteConfigFactory;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * UI_LSE_0021 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0021HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Jun-Woo
 * @see EES_LSE_0020HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesLse0021Event extends EventSupport {
	/*
	 * 객체직렬화 버젼 UID
	 */
	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchParamVO searchParamVO = null;

	private EmailSendInfoVO emailSendInfoVO = null;

	/** Table Value Object Multi Data 처리 */
	public AvailableOffHireDetailVO[] availableOffHireDetailVOs = null;

	/**
	 * Default Constructor.
	 */
	public EesLse0021Event(){}

	public void setSearchParamVO(SearchParamVO searchParamVO){
		this. searchParamVO = searchParamVO;
	}

	public void setEmailSendInfoVO(EmailSendInfoVO emailSendInfoVO){
		this. emailSendInfoVO = emailSendInfoVO;
	}

	public void setAvailableOffHireDetailVOs(AvailableOffHireDetailVO[] availableOffHireDetailVOs){
		this. availableOffHireDetailVOs = availableOffHireDetailVOs;
	}

	public SearchParamVO getSearchParamVO(){
		return searchParamVO;
	}

	public EmailSendInfoVO getEmailSendInfoVO(){
		return emailSendInfoVO;
	}

	public AvailableOffHireDetailVO[] getAvailableOffHireDetailVOs(){
		return availableOffHireDetailVOs;
	}

	/**
	 * template을 이용하여 지정된 파일로부터 Contents를 가져온다.
	 *
	 * @param template String
	 * @param argument String
	 * @return String
	 * @throws IOException
	 */
	public static String getTemplateContent(String template, String argument) throws IOException {
		String templateFile = FileUtils.fileReader(SiteConfigFactory.get("COM.HANJIN.JAF.MAIL.TEMPLATE.DIR"), template, argument.split(","));
		return templateFile;
	}
}
