/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt4007Event.java
*@FileTitle : Manual Invoice Report by Office - Detail(s)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : mun jung cheol
*@LastVersion : 1.0
* 2009.10.06 mun jung cheol
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event;

import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ManualInvoiceIssueParmVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ManualInvoiceIssuedListVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EES_DMT_4007 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_4007HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Mun Jung Cheol
 * @see EES_DMT_4007HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt4007Event extends EventSupport {

    private static final long serialVersionUID = 1L;
    
    private ManualInvoiceIssueParmVO manualInvoiceIssueParmVO  = null;
    
    private ManualInvoiceIssueParmVO[] manualInvoiceIssueParmVOs  = null;
    
    private ManualInvoiceIssuedListVO manualInvoiceIssuedListVO = null;
    
    private ManualInvoiceIssuedListVO[] manualInvoiceIssuedListVOs = null;

    public EesDmt4007Event(){}

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
    * @return the manualInvoiceIssuedListVO
    */
    public ManualInvoiceIssuedListVO getManualInvoiceIssuedListVO() {
        return manualInvoiceIssuedListVO;
    }

    /**
    * @param manualInvoiceIssuedListVO the manualInvoiceIssuedListVO to set
    */
    public void setManualInvoiceIssuedListVO(
            ManualInvoiceIssuedListVO manualInvoiceIssuedListVO) {
        this.manualInvoiceIssuedListVO = manualInvoiceIssuedListVO;
    }

    /**
    * @return the manualInvoiceIssuedListVOs
    */
    public ManualInvoiceIssuedListVO[] getManualInvoiceIssuedListVOs() {
    	ManualInvoiceIssuedListVO[] tmpVOs = null;
		if (this.manualInvoiceIssuedListVOs != null) {
			tmpVOs = new ManualInvoiceIssuedListVO[manualInvoiceIssuedListVOs.length];
			System.arraycopy(manualInvoiceIssuedListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
    }

    /**
    * @param manualInvoiceIssuedListVOs the manualInvoiceIssuedListVOs to set
    */
    public void setManualInvoiceIssuedListVOs(
            ManualInvoiceIssuedListVO[] manualInvoiceIssuedListVOs) {
    	if (manualInvoiceIssuedListVOs != null) {
    		ManualInvoiceIssuedListVO[] tmpVOs = new ManualInvoiceIssuedListVO[manualInvoiceIssuedListVOs.length];
			System.arraycopy(manualInvoiceIssuedListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.manualInvoiceIssuedListVOs = tmpVOs;
		}
    }
}
