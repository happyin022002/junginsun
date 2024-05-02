/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt4009Event.java
*@FileTitle : Outstanding Inquiry by Customer N Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : mun jung cheol
*@LastVersion : 1.0
* 2009.09.02 mun jung cheol
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event;

import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryBySummaryVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryParmVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EES_DMT_4009 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_4009HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Mun Jung Cheol
 * @see EES_DMT_4009HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt4009Event extends EventSupport {

    private static final long serialVersionUID = 1L;
    
    private OtsInquiryParmVO otsInquiryParmVO  = null;
    
    private OtsInquiryParmVO[] otsInquiryParmVOs  = null;
    
    private OtsInquiryBySummaryVO otsInquiryBySummaryVO = null;
    
    private OtsInquiryBySummaryVO[] otsInquiryBySummaryVOs = null;

    public EesDmt4009Event(){}

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

    /**
    * @return the otsInquiryBySummaryVO
    */
    public OtsInquiryBySummaryVO getOtsInquiryBySummaryVO() {
        return otsInquiryBySummaryVO;
    }

    /**
    * @param otsInquiryBySummaryVO the otsInquiryBySummaryVO to set
    */
    public void setOtsInquiryBySummaryVO(OtsInquiryBySummaryVO otsInquiryBySummaryVO) {
        this.otsInquiryBySummaryVO = otsInquiryBySummaryVO;
    }

    /**
    * @return the otsInquiryBySummaryVOs
    */
    public OtsInquiryBySummaryVO[] getOtsInquiryBySummaryVOs() {
    	OtsInquiryBySummaryVO[] tmpVOs = null;
		if (this.otsInquiryBySummaryVOs != null) {
			tmpVOs = new OtsInquiryBySummaryVO[otsInquiryBySummaryVOs.length];
			System.arraycopy(otsInquiryBySummaryVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
    }

    /**
    * @param otsInquiryBySummaryVOs the otsInquiryBySummaryVOs to set
    */
    public void setOtsInquiryBySummaryVOs(
            OtsInquiryBySummaryVO[] otsInquiryBySummaryVOs) {
    	if (otsInquiryBySummaryVOs != null) {
    		OtsInquiryBySummaryVO[] tmpVOs = new OtsInquiryBySummaryVO[otsInquiryBySummaryVOs.length];
			System.arraycopy(otsInquiryBySummaryVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.otsInquiryBySummaryVOs = tmpVOs;
		}
    }
    
    
}
