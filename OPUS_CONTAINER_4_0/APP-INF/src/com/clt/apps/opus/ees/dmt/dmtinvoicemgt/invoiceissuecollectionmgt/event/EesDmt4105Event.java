/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt4105Event.java
*@FileTitle : Remark(s)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : mun jung cheol
*@LastVersion : 1.0
* 2009.09.25 mun jung cheol
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event;

import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryParmVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EES_DMT_4105 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_4105HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Mun Jung Cheol
 * @see EES_DMT_4105HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt4105Event extends EventSupport {
    
    private static final long serialVersionUID = 1L;
    
    private OtsInquiryParmVO otsInquiryParmVO  = null;
    
    private OtsInquiryParmVO[] otsInquiryParmVOs  = null;
    
    public EesDmt4105Event(){}

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
    	OtsInquiryParmVO[] tmpVOs = null;
		if (this.otsInquiryParmVOs != null) {
			tmpVOs = new OtsInquiryParmVO[otsInquiryParmVOs.length];
			System.arraycopy(otsInquiryParmVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
    }

    /**
    * @param otsInquiryParmVOs the otsInquiryParmVOs to set
    */
    public void setOtsInquiryParmVOs(OtsInquiryParmVO[] otsInquiryParmVOs) {
    	if (otsInquiryParmVOs != null) {
    		OtsInquiryParmVO[] tmpVOs = new OtsInquiryParmVO[otsInquiryParmVOs.length];
			System.arraycopy(otsInquiryParmVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.otsInquiryParmVOs = tmpVOs;
		}
    }    

}
