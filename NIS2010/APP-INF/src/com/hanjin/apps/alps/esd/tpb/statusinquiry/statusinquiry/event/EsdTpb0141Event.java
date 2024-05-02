/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb0141Event.java
*@FileTitle : Fax/E-mail Sending History Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2015-04-17
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2015-04-17 O KIM HYUN HWA  1.0	최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.event;

import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.vo.EmailFaxSentHistVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TPB_0141 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0141HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM HYUN HWA
 * @see ESD_TPB_0141HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0141Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EmailFaxSentHistVO emailFaxSentHistVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private EmailFaxSentHistVO[] emailFaxSentHistVOs = null;

	public EsdTpb0141Event(){}
	
	public void setEmailFaxSentHistVO(EmailFaxSentHistVO emailFaxSentHistVO){
		this. emailFaxSentHistVO = emailFaxSentHistVO;
	}

	public void setSearchTpbInvoiceListVOS(EmailFaxSentHistVO[] emailFaxSentHistVOs){
		if(emailFaxSentHistVOs != null){
			EmailFaxSentHistVO[] tmpVOs = new EmailFaxSentHistVO[emailFaxSentHistVOs.length];
			System.arraycopy(emailFaxSentHistVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.emailFaxSentHistVOs = tmpVOs;
		}
	}

	public EmailFaxSentHistVO getEmailFaxSentHistVO(){
		return emailFaxSentHistVO;
	}

	public EmailFaxSentHistVO[] getEmailFaxSentHistVOS(){
		EmailFaxSentHistVO[] rtnVOs = null;
		if (this.emailFaxSentHistVOs != null) {
			rtnVOs = new EmailFaxSentHistVO[emailFaxSentHistVOs.length];
			System.arraycopy(emailFaxSentHistVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}