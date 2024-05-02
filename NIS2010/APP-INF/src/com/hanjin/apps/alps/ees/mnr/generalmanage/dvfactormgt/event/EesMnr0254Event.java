/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EesMnr0254Event.java
 *@FileTitle : Container Seal Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.08.17
 *@LastModifier : 김상수
 *@LastVersion : 1.0
 * 2011.08.17 김상수
 * --------------------------------------------------------
 * History
 * 2011.08.17 김상수 [CHM-201112813-01] ALPS MNR-Seal management-Inquiry (신규화면 개발)
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.event;

import com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.vo.ContainerSealInquiryVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_MNR_0254 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_02540HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김경섭
 * @see EES_MNR_0254HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0254Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ContainerSealInquiryVO containerSealInquiryVO = null;


	public EesMnr0254Event(){}


	public ContainerSealInquiryVO getContainerSealInquiryVO() {
		return containerSealInquiryVO;
	}

	public void setContainerSealInquiryVO(ContainerSealInquiryVO containerSealInquiryVO) {
		this.containerSealInquiryVO = containerSealInquiryVO;
	}

}