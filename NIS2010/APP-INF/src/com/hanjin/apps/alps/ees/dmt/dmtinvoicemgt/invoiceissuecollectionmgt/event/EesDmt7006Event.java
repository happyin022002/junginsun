/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt7006Event.java
*@FileTitle : Fax/E-mail Sending History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : mun jung cheol
*@LastVersion : 1.0
* 2009.10.14 mun jung cheol
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event;

import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtFaxEmlSndHisVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtFaxEmlSndHisParmVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES_DMT_7006 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_7006HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Mun Jung Cheol
 * @see EES_DMT_7006HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt7006Event extends EventSupport {
    
    private static final long serialVersionUID = 1L;
    
    private DmtFaxEmlSndHisVO dmtFaxEmlSndHisVO  = null;
    
    private DmtFaxEmlSndHisVO[] dmtFaxEmlSndHisVOs  = null;

    private DmtFaxEmlSndHisParmVO dmtFaxEmlSndHisParmVO  = null;
    
    private DmtFaxEmlSndHisParmVO[] dmtFaxEmlSndHisParmVOs  = null;
    
    public EesDmt7006Event(){}

    /**
    * @return the dmtFaxEmlSndHisVO
    */
    public DmtFaxEmlSndHisVO getDmtFaxEmlSndHisVO() {
        return dmtFaxEmlSndHisVO;
    }

    /**
    * @param dmtFaxEmlSndHisVO the dmtFaxEmlSndHisVO to set
    */
    public void setDmtFaxEmlSndHisVO(DmtFaxEmlSndHisVO dmtFaxEmlSndHisVO) {
        this.dmtFaxEmlSndHisVO = dmtFaxEmlSndHisVO;
    }

    /**
    * @return the dmtFaxEmlSndHisVOs
    */
    public DmtFaxEmlSndHisVO[] getDmtFaxEmlSndHisVOs() {
        return dmtFaxEmlSndHisVOs;
    }

    /**
    * @param dmtFaxEmlSndHisVOs the dmtFaxEmlSndHisVOs to set
    */
    public void setDmtFaxEmlSndHisVOs(DmtFaxEmlSndHisVO[] dmtFaxEmlSndHisVOs) {
        this.dmtFaxEmlSndHisVOs = dmtFaxEmlSndHisVOs;
    }

    /**
    * @return the dmtFaxEmlSndHisParmVO
    */
    public DmtFaxEmlSndHisParmVO getDmtFaxEmlSndHisParmVO() {
        return dmtFaxEmlSndHisParmVO;
    }

    /**
    * @param dmtFaxEmlSndHisParmVO the dmtFaxEmlSndHisParmVO to set
    */
    public void setDmtFaxEmlSndHisParmVO(DmtFaxEmlSndHisParmVO dmtFaxEmlSndHisParmVO) {
        this.dmtFaxEmlSndHisParmVO = dmtFaxEmlSndHisParmVO;
    }

    /**
    * @return the dmtFaxEmlSndHisParmVOs
    */
    public DmtFaxEmlSndHisParmVO[] getDmtFaxEmlSndHisParmVOs() {
        return dmtFaxEmlSndHisParmVOs;
    }

    /**
    * @param dmtFaxEmlSndHisParmVOs the dmtFaxEmlSndHisParmVOs to set
    */
    public void setDmtFaxEmlSndHisParmVOs(
            DmtFaxEmlSndHisParmVO[] dmtFaxEmlSndHisParmVOs) {
        this.dmtFaxEmlSndHisParmVOs = dmtFaxEmlSndHisParmVOs;
    }

}
