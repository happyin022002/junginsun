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

package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event;

import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtFaxEmlSndHisParmVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtFaxEmlSndHisVO;
import com.clt.framework.support.layer.event.EventSupport;

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
    	DmtFaxEmlSndHisVO[] tmpVOs = null;
		if (this.dmtFaxEmlSndHisVOs != null) {
			tmpVOs = new DmtFaxEmlSndHisVO[dmtFaxEmlSndHisVOs.length];
			System.arraycopy(dmtFaxEmlSndHisVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
    }

    /**
    * @param dmtFaxEmlSndHisVOs the dmtFaxEmlSndHisVOs to set
    */
    public void setDmtFaxEmlSndHisVOs(DmtFaxEmlSndHisVO[] dmtFaxEmlSndHisVOs) {
    	if (dmtFaxEmlSndHisVOs != null) {
    		DmtFaxEmlSndHisVO[] tmpVOs = new DmtFaxEmlSndHisVO[dmtFaxEmlSndHisVOs.length];
			System.arraycopy(dmtFaxEmlSndHisVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.dmtFaxEmlSndHisVOs = tmpVOs;
		}
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
    	DmtFaxEmlSndHisParmVO[] tmpVOs = null;
		if (this.dmtFaxEmlSndHisParmVOs != null) {
			tmpVOs = new DmtFaxEmlSndHisParmVO[dmtFaxEmlSndHisParmVOs.length];
			System.arraycopy(dmtFaxEmlSndHisParmVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
    }

    /**
    * @param dmtFaxEmlSndHisParmVOs the dmtFaxEmlSndHisParmVOs to set
    */
    public void setDmtFaxEmlSndHisParmVOs(
            DmtFaxEmlSndHisParmVO[] dmtFaxEmlSndHisParmVOs) {
    	if (dmtFaxEmlSndHisParmVOs != null) {
    		DmtFaxEmlSndHisParmVO[] tmpVOs = new DmtFaxEmlSndHisParmVO[dmtFaxEmlSndHisParmVOs.length];
			System.arraycopy(dmtFaxEmlSndHisParmVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.dmtFaxEmlSndHisParmVOs = tmpVOs;
		}
    }

}
