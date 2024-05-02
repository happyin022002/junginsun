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

package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event;

import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ManualInvoiceSummaryVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ManualInvoiceIssueParmVO;
import com.hanjin.framework.support.layer.event.EventSupport;

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
        return manualInvoiceIssueParmVOs;
    }

    /**
    * @param manualInvoiceIssueParmVOs the manualInvoiceIssueParmVOs to set
    */
    public void setManualInvoiceIssueParmVOs(
            ManualInvoiceIssueParmVO[] manualInvoiceIssueParmVOs) {
        this.manualInvoiceIssueParmVOs = manualInvoiceIssueParmVOs;
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
        return manualInvoiceSummaryVOs;
    }

    /**
    * @param manualInvoiceSummaryVOs the manualInvoiceSummaryVOs to set
    */
    public void setManualInvoiceSummaryVOs(
            ManualInvoiceSummaryVO[] manualInvoiceSummaryVOs) {
        this.manualInvoiceSummaryVOs = manualInvoiceSummaryVOs;
    }

}
