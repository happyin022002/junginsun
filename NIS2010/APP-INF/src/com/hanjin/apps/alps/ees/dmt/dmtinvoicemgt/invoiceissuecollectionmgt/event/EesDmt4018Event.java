/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt4018Event.java
*@FileTitle : Outstanding Inquiry by Customer N Issue - Detail(s)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : mun jung cheol
*@LastVersion : 1.0
* 2009.09.02 mun jung cheol
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event;

import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OTSCleanDetailExcelListVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryByDetialVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryByDetial3VO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryParmVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES_DMT_4018 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_4018HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Mun Jung Cheol
 * @see EES_DMT_4018HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt4018Event extends EventSupport {

    private static final long serialVersionUID = 1L;
    
    private OtsInquiryParmVO otsInquiryParmVO  = null;
    
    private OtsInquiryParmVO[] otsInquiryParmVOs  = null;
    
    private OtsInquiryByDetialVO otsInquiryByDetialVO = null;
    
    private OtsInquiryByDetialVO[] otsInquiryByDetialVOs = null;
    
    private OtsInquiryByDetial3VO otsInquiryByDetialVO3 = null;
    
    private OtsInquiryByDetial3VO[] otsInquiryByDetialVO3s = null;    

    private OTSCleanDetailExcelListVO oTSCleanDetailExcelListVO = null;

    private OTSCleanDetailExcelListVO[] oTSCleanDetailExcelListVOs = null;
    
    public EesDmt4018Event(){}

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

    /**
    * @return the otsInquiryByDetialVO
    */
    public OtsInquiryByDetialVO getOtsInquiryByDetialVO() {
        return otsInquiryByDetialVO;
    }

    /**
    * @param otsInquiryByDetialVO the otsInquiryByDetialVO to set
    */
    public void setOtsInquiryByDetialVO(OtsInquiryByDetialVO otsInquiryByDetialVO) {
        this.otsInquiryByDetialVO = otsInquiryByDetialVO;
    }

    /**
    * @return the otsInquiryByDetialVOs
    */
    public OtsInquiryByDetialVO[] getOtsInquiryByDetialVOs() {
        return otsInquiryByDetialVOs;
    }

    /**
    * @param otsInquiryByDetialVOs the otsInquiryByDetialVOs to set
    */
    public void setOtsInquiryByDetialVOs(
            OtsInquiryByDetialVO[] otsInquiryByDetialVOs) {
        this.otsInquiryByDetialVOs = otsInquiryByDetialVOs;
    }

    /**
    * @return the otsInquiryByDetialVO3
    */
    public OtsInquiryByDetial3VO getOtsInquiryByDetialVO3() {
        return otsInquiryByDetialVO3;
    }

    /**
    * @param otsInquiryByDetialVO3 the otsInquiryByDetialVO3 to set
    */
    public void setOtsInquiryByDetialVO3(OtsInquiryByDetial3VO otsInquiryByDetialVO3) {
        this.otsInquiryByDetialVO3 = otsInquiryByDetialVO3;
    }

    /**
    * @return the otsInquiryByDetialVO3s
    */
    public OtsInquiryByDetial3VO[] getOtsInquiryByDetialVO3s() {
        return otsInquiryByDetialVO3s;
    }

    /**
    * @param otsInquiryByDetialVO3s the otsInquiryByDetialVO3s to set
    */
    public void setOtsInquiryByDetialVO3s(
            OtsInquiryByDetial3VO[] otsInquiryByDetialVO3s) {
        this.otsInquiryByDetialVO3s = otsInquiryByDetialVO3s;
    }

	public OTSCleanDetailExcelListVO getoTSCleanDetailExcelListVO() {
		return oTSCleanDetailExcelListVO;
	}

	public void setoTSCleanDetailExcelListVO(
			OTSCleanDetailExcelListVO oTSCleanDetailExcelListVO) {
		this.oTSCleanDetailExcelListVO = oTSCleanDetailExcelListVO;
	}

	public OTSCleanDetailExcelListVO[] getoTSCleanDetailExcelListVOs() {
		return oTSCleanDetailExcelListVOs;
	}

	public void setoTSCleanDetailExcelListVOs(
			OTSCleanDetailExcelListVO[] oTSCleanDetailExcelListVOs) {
		this.oTSCleanDetailExcelListVOs = oTSCleanDetailExcelListVOs;
	}

}
