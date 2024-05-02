/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt4006Event.java
*@FileTitle : Manual Invoice Report by Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : mun jung cheol
*@LastVersion : 1.0
* 2009.10.05 mun jung cheol
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event;

import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ManualInvoiceIssueParmVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ManualInvoiceSummaryVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EES_DMT_4006 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_4006HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Mun Jung Cheol
 * @see EES_DMT_4006HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt4006Event extends EventSupport {

    private static final long serialVersionUID = 1L;
    
    private ManualInvoiceIssueParmVO manualInvoiceIssueParmVO  = null;
    
    private ManualInvoiceIssueParmVO[] manualInvoiceIssueParmVOs  = null;
    
    private ManualInvoiceSummaryVO manualInvoiceSummaryVO = null;
    
    private ManualInvoiceSummaryVO[] manualInvoiceSummaryVOs = null;

    public EesDmt4006Event(){}

    /**
    * @return the manualInvoiceIssueParmVO
    */
    public ManualInvoiceIssueParmVO getManualInvoiceIssueParmVO() {
        return manualInvoiceIssueParmVO;
    }

    /**
    * @param manualInvoiceIssueParmVO the manualInvoiceIssueParmVO to set
    */
    public void setManualInvoiceIssueParmVO(
            ManualInvoiceIssueParmVO manualInvoiceIssueParmVO) {
        this.manualInvoiceIssueParmVO = manualInvoiceIssueParmVO;
    }

    /**
    * @return the manualInvoiceIssueParmVOs
    */
    public ManualInvoiceIssueParmVO[] getManualInvoiceIssueParmVOs() {
    	ManualInvoiceIssueParmVO[] tmpVOs = null;
		if (this.manualInvoiceIssueParmVOs != null) {
			tmpVOs = new ManualInvoiceIssueParmVO[manualInvoiceIssueParmVOs.length];
			System.arraycopy(manualInvoiceIssueParmVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
    }

    /**
    * @param manualInvoiceIssueParmVOs the manualInvoiceIssueParmVOs to set
    */
    public void setManualInvoiceIssueParmVOs(
            ManualInvoiceIssueParmVO[] manualInvoiceIssueParmVOs) {
    	if (manualInvoiceIssueParmVOs != null) {
    		ManualInvoiceIssueParmVO[] tmpVOs = new ManualInvoiceIssueParmVO[manualInvoiceIssueParmVOs.length];
			System.arraycopy(manualInvoiceIssueParmVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.manualInvoiceIssueParmVOs = tmpVOs;
		}
    }

    /**
    * @return the manualInvoiceSummaryVO
    */
    public ManualInvoiceSummaryVO getManualInvoiceSummaryVO() {
        return manualInvoiceSummaryVO;
    }

    /**
    * @param manualInvoiceSummaryVO the manualInvoiceSummaryVO to set
    */
    public void setManualInvoiceSummaryVO(
            ManualInvoiceSummaryVO manualInvoiceSummaryVO) {
        this.manualInvoiceSummaryVO = manualInvoiceSummaryVO;
    }

    /**
    * @return the manualInvoiceSummaryVOs
    */
    public ManualInvoiceSummaryVO[] getManualInvoiceSummaryVOs() {
    	ManualInvoiceSummaryVO[] tmpVOs = null;
		if (this.manualInvoiceSummaryVOs != null) {
			tmpVOs = new ManualInvoiceSummaryVO[manualInvoiceSummaryVOs.length];
			System.arraycopy(manualInvoiceSummaryVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
    }

    /**
    * @param manualInvoiceSummaryVOs the manualInvoiceSummaryVOs to set
    */
    public void setManualInvoiceSummaryVOs(
            ManualInvoiceSummaryVO[] manualInvoiceSummaryVOs) {
    	if (manualInvoiceSummaryVOs != null) {
    		ManualInvoiceSummaryVO[] tmpVOs = new ManualInvoiceSummaryVO[manualInvoiceSummaryVOs.length];
			System.arraycopy(manualInvoiceSummaryVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.manualInvoiceSummaryVOs = tmpVOs;
		}
    }

}
