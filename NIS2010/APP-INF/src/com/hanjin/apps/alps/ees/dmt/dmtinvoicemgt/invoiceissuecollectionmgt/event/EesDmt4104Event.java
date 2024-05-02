/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt4104Event.java
*@FileTitle : DEM/DET Payer Info & Fax/E-mail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.10.16 김태균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtPayrCntcPntVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtPayrInfoVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.PayerInfoParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.PayerInformationVO;


/**
 * EES_DMT_4104 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_4104HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Tae Kyun
 * @see EES_DMT_4104HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt4104Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DmtPayrInfoVO dmtPayrInfoVO 			= null;
	
	private PayerInfoParamVO payerInfoParamVO 		= null;
	
	private PayerInformationVO payerInformationVO 	= null;
	
	private DmtPayrCntcPntVO[] dmtPayrCntcPntVOs 	= null;
	
	public EesDmt4104Event(){}

	public DmtPayrInfoVO getDmtPayrInfoVO() {
		return dmtPayrInfoVO;
	}

	public void setDmtPayrInfoVO(DmtPayrInfoVO dmtPayrInfoVO) {
		this.dmtPayrInfoVO = dmtPayrInfoVO;
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

	public DmtPayrCntcPntVO[] getDmtPayrCntcPntVOs() {
		return dmtPayrCntcPntVOs;
	}

	public void setDmtPayrCntcPntVOs(DmtPayrCntcPntVO[] dmtPayrCntcPntVOs) {
		this.dmtPayrCntcPntVOs = dmtPayrCntcPntVOs;
	}
}