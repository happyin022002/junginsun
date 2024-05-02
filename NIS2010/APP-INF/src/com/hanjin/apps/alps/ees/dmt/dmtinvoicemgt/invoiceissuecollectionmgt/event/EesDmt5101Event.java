/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt5101Event.java
*@FileTitle : Hold Reason Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : mun jung cheol
*@LastVersion : 1.0
* 2009.10.12 mun jung cheol
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES_DMT_5101에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_5101HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Mun Jung Cheol
 * @see EES_DMT_5101HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesDmt5101Event extends EventSupport {

    private static final long serialVersionUID = 1L;
    
    private String invoiceNo = "";
    
    private String holdReasn = "";
    
    private String holdRemrk = "";

    public EesDmt5101Event(){}

    /**
    * @return the invoiceNo
    */
    public String getInvoiceNo() {
        return invoiceNo;
    }

    /**
    * @param invoiceNo the invoiceNo to set
    */
    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    /**
    * @return the holdReasn
    */
    public String getHoldReasn() {
        return holdReasn;
    }

    /**
    * @param holdReasn the holdReasn to set
    */
    public void setHoldReasn(String holdReasn) {
        this.holdReasn = holdReasn;
    }

    /**
    * @return the holdRemrk
    */
    public String getHoldRemrk() {
        return holdRemrk;
    }

    /**
    * @param holdRemrk the holdRemrk to set
    */
    public void setHoldRemrk(String holdRemrk) {
        this.holdRemrk = holdRemrk;
    }

}