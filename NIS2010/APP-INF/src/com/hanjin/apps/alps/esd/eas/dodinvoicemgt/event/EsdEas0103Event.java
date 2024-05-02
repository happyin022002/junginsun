/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdEas0103Event.java
*@FileTitle : EAS DOD Payer Info & Fax/E-mail
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.11
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2013.09.11 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.dodinvoicemgt.event;

import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.EasPayrCntcPntVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.EasPayrInfoVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.PayerInfoParamVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.PayerInformationVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_EAS_0103 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_EAS_0103HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM HYUN HWA
 * @see ESD_EAS_0103HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdEas0103Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EasPayrInfoVO easPayrInfoVO 			= null;

	private PayerInfoParamVO payerInfoParamVO 		= null;
	
	private PayerInformationVO payerInformationVO 	= null;
	
	private EasPayrCntcPntVO[] easPayrCntcPntVOs 	= null;
	
	public EsdEas0103Event(){}

	public EasPayrInfoVO getEasPayrInfoVO() {
		return easPayrInfoVO;
	}

	public void setEasPayrInfoVO(EasPayrInfoVO easPayrInfoVO) {
		this.easPayrInfoVO = easPayrInfoVO;
	}

	public PayerInfoParamVO getPayerInfoParamVO() {
		return payerInfoParamVO;
	}

	public void setPayerInfoParamVO(PayerInfoParamVO payerInfoParamVO) {
		this.payerInfoParamVO = payerInfoParamVO;
	}
	
	public PayerInformationVO getPayerInformationVO() {
		return payerInformationVO;
	}
	
	public void setPayerInformationVO(PayerInformationVO payerInformationVO) {
		this.payerInformationVO = payerInformationVO;
	}

	public EasPayrCntcPntVO[] getEasPayrCntcPntVOs() {
		return easPayrCntcPntVOs;
	}

	public void setEasPayrCntcPntVOs(EasPayrCntcPntVO[] easPayrCntcPntVOs) {
		this.easPayrCntcPntVOs = easPayrCntcPntVOs;
	}
}