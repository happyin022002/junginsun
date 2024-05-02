/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EesDmt7020Event.java
*@FileTitle : Payer Info & Fax/E-mail
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.23
*@LastModifier : 김기태
*@LastVersion : 1.0
* 2016.03.23 김기태
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event;

import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.PayerInfoListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES_DMT_7006 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_7006HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김기태
 * @see EES_DMT_7006HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt7020Event extends EventSupport {
    
    private static final long serialVersionUID = 1L;
    
    /** Table Value Object 조회 조건 및 단건 처리  */
    private String programNo = null;
    
	private PayerInfoListVO payerInfoListVO 			= null;
	
	private PayerInfoListVO[] payerInfoListVOs = null;
	
	
	
	public EesDmt7020Event(){}	

	public String getProgramNo() {
		return programNo;
	}

	public void setProgramNo(String programNo) {
		this.programNo = programNo;
	}

	public PayerInfoListVO getPayerInfoListVO() {
		return payerInfoListVO;
	}
	public void setPayerInfoListVO(PayerInfoListVO payerInfoListVO) {
		this.payerInfoListVO = payerInfoListVO;
	}

	public PayerInfoListVO[] getPayerInfoListVOs() {
		PayerInfoListVO[] ret = null;
		
		if (this.payerInfoListVOs != null) {
			ret = new PayerInfoListVO[payerInfoListVOs.length];
			
			for (int i=0; i<payerInfoListVOs.length; i++) {
				ret[i] = this.payerInfoListVOs[i];
			}
		}
		return ret;		
	}
	
	public void setPayerInfoListVOs(PayerInfoListVO[] payerInfoListVOs) {
		if (payerInfoListVOs != null) {
			this.payerInfoListVOs = new PayerInfoListVO[payerInfoListVOs.length];
			
			for (int i=0; i<payerInfoListVOs.length; i++) {
				this.payerInfoListVOs[i] = payerInfoListVOs[i];
			}
		}
	}
	
}