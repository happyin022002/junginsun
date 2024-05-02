/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt4017Event.java
*@FileTitle : Outstanding Inquiry by Customer N Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : mun jung cheol
*@LastVersion : 1.0
* 2009.09.02 mun jung cheol
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event;

import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OTSCleanListVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryBySummaryVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryParmVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES_DMT_4017 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_4017HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Mun Jung Cheol
 * @see EES_DMT_4017HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt4017Event extends EventSupport {

    private static final long serialVersionUID = 1L;
    
    private OtsInquiryParmVO otsInquiryParmVO  = null;
    
    private OtsInquiryParmVO[] otsInquiryParmVOs  = null;
    
    private OTSCleanListVO[] oTSCleanListVOs = null;
    
    private String key = "";

    public EesDmt4017Event(){}

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

	public OTSCleanListVO[] getoTSCleanListVOs() {
		return oTSCleanListVOs;
	}

	public void setoTSCleanListVOs(OTSCleanListVO[] oTSCleanListVOs) {
		this.oTSCleanListVOs = oTSCleanListVOs;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
    
}
