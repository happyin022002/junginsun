/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt4019Event.java
*@FileTitle : Remark(s)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : mun jung cheol
*@LastVersion : 1.0
* 2009.09.25 mun jung cheol
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event;

import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryParmVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES_DMT_4019 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_4019HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Mun Jung Cheol
 * @see EES_DMT_4019HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt4019Event extends EventSupport {
    
    private static final long serialVersionUID = 1L;
    
    private OtsInquiryParmVO otsInquiryParmVO  = null;
    
    private OtsInquiryParmVO[] otsInquiryParmVOs  = null;
    
    public EesDmt4019Event(){}

    /**
    * @return the otsInquiryParmVO
    */
    public OtsInquiryParmVO getOtsInquiryParmVO() {
        return otsInquiryParmVO;
    }

    /**
    * @param otsInquiryParmVO the otsInquiryParmVO to set
    */
    public void setOtsInquiryParmVO(OtsInquiryParmVO otsInquiryParmVO) {
        this.otsInquiryParmVO = otsInquiryParmVO;
    }

    /**
    * @return the otsInquiryParmVOs
    */
    public OtsInquiryParmVO[] getOtsInquiryParmVOs() {
        return otsInquiryParmVOs;
    }

    /**
    * @param otsInquiryParmVOs the otsInquiryParmVOs to set
    */
    public void setOtsInquiryParmVOs(OtsInquiryParmVO[] otsInquiryParmVOs) {
        this.otsInquiryParmVOs = otsInquiryParmVOs;
    }    

}
