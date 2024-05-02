/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DmtComFaxEmailEvent.java
*@FileTitle : DmtComFaxEmailEvent
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.18
*@LastModifier : MUN JUNG CHEOL
*@LastVersion : 1.0
* 2009.11.18 MUN JUNG CHEOL
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfaxemail.event;

import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfaxemail.vo.DmtComFaxSndInfoVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfaxemail.vo.DmtComRDFaxEmailSendInfoVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.event.DMT_COM_HTMLAction;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.FAXEmailByPayerVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryParmVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * DmtComFaxEmailEvent 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  DMT_COM_FAXEMAIL_HTMLAction 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author MUN JUNG CHEOL
 * @see DMT_COM_HTMLAction 참조
 * @since J2EE 1.4
 */

public class DmtComFaxEmailEvent extends EventSupport {

    private static final long serialVersionUID = 1L;
    
    /** Table Value Object 조회 조건 및 단건 처리  */
    private DmtComFaxSndInfoVO dmtComFaxSndInfoVO = null;
    
    /** Table Value Object Multi Data 처리 */
    private DmtComFaxSndInfoVO[] dmtComFaxSndInfoVOs = null;

    private DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO  = null;
    
    private DmtComRDFaxEmailSendInfoVO[] dmtComRDFaxEmailSendInfoVOs  = null;
    
    private OtsInquiryParmVO otsInquiryParmVO  = null;
    
    private OtsInquiryParmVO[] otsInquiryParmVOs  = null;
    
    private FAXEmailByPayerVO fAXEmailByPayerVO = null;
    
    /**
    * @return the fAXEmailByPayerVO
    */
    public FAXEmailByPayerVO getFAXEmailByPayerVO() {
        return fAXEmailByPayerVO;
    }

    /**
    * @param emailByPayerVO the fAXEmailByPayerVO to set
    */
    public void setFAXEmailByPayerVO(FAXEmailByPayerVO emailByPayerVO) {
        fAXEmailByPayerVO = emailByPayerVO;
    }

    public DmtComFaxEmailEvent(){}

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
    * @return the dmtComFaxSndInfoVO
    */
    public DmtComFaxSndInfoVO getDmtComFaxSndInfoVO() {
        return dmtComFaxSndInfoVO;
    }

    /**
    * @param dmtComFaxSndInfoVO the dmtComFaxSndInfoVO to set
    */
    public void setDmtComFaxSndInfoVO(DmtComFaxSndInfoVO dmtComFaxSndInfoVO) {
        this.dmtComFaxSndInfoVO = dmtComFaxSndInfoVO;
    }

    /**
    * @return the dmtComFaxSndInfoVOs
    */
    public DmtComFaxSndInfoVO[] getDmtComFaxSndInfoVOs() {
        return dmtComFaxSndInfoVOs;
    }

    /**
    * @param dmtComFaxSndInfoVOs the dmtComFaxSndInfoVOs to set
    */
    public void setDmtComFaxSndInfoVOs(DmtComFaxSndInfoVO[] dmtComFaxSndInfoVOs) {
        this.dmtComFaxSndInfoVOs = dmtComFaxSndInfoVOs;
    }

    /**
    * @return the dmtComRDFaxEmailSendInfoVO
    */
    public DmtComRDFaxEmailSendInfoVO getDmtComRDFaxEmailSendInfoVO() {
        return dmtComRDFaxEmailSendInfoVO;
    }

    /**
    * @param dmtComRDFaxEmailSendInfoVO the dmtComRDFaxEmailSendInfoVO to set
    */
    public void setDmtComRDFaxEmailSendInfoVO(
            DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO) {
        this.dmtComRDFaxEmailSendInfoVO = dmtComRDFaxEmailSendInfoVO;
    }

    /**
    * @return the dmtComRDFaxEmailSendInfoVOs
    */
    public DmtComRDFaxEmailSendInfoVO[] getDmtComRDFaxEmailSendInfoVOs() {
        return dmtComRDFaxEmailSendInfoVOs;
    }

    /**
    * @param dmtComRDFaxEmailSendInfoVOs the dmtComRDFaxEmailSendInfoVOs to set
    */
    public void setDmtComRDFaxEmailSendInfoVOs(
            DmtComRDFaxEmailSendInfoVO[] dmtComRDFaxEmailSendInfoVOs) {
        this.dmtComRDFaxEmailSendInfoVOs = dmtComRDFaxEmailSendInfoVOs;
    }
    
}
