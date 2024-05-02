/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt4011Event.java
*@FileTitle : Outstanding Inquiry by Customer N Issue - Detail(s)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : mun jung cheol
*@LastVersion : 1.0
* 2009.09.02 mun jung cheol
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event;

import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryByDetial3VO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryByDetialVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryParmVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EES_DMT_4011 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_4011HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Mun Jung Cheol
 * @see EES_DMT_4011HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt4011Event extends EventSupport {

    private static final long serialVersionUID = 1L;
    
    private OtsInquiryParmVO otsInquiryParmVO  = null;
    
    private OtsInquiryParmVO[] otsInquiryParmVOs  = null;
    
    private OtsInquiryByDetialVO otsInquiryByDetialVO = null;
    
    private OtsInquiryByDetialVO[] otsInquiryByDetialVOs = null;
    
    private OtsInquiryByDetial3VO otsInquiryByDetialVO3 = null;
    
    private OtsInquiryByDetial3VO[] otsInquiryByDetialVO3s = null;    

    public EesDmt4011Event(){}

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
    	OtsInquiryByDetialVO[] tmpVOs = null;
		if (this.otsInquiryByDetialVOs != null) {
			tmpVOs = new OtsInquiryByDetialVO[otsInquiryByDetialVOs.length];
			System.arraycopy(otsInquiryByDetialVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
    }

    /**
    * @param otsInquiryByDetialVOs the otsInquiryByDetialVOs to set
    */
    public void setOtsInquiryByDetialVOs(
            OtsInquiryByDetialVO[] otsInquiryByDetialVOs) {
    	if (otsInquiryByDetialVOs != null) {
    		OtsInquiryByDetialVO[] tmpVOs = new OtsInquiryByDetialVO[otsInquiryByDetialVOs.length];
			System.arraycopy(otsInquiryByDetialVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.otsInquiryByDetialVOs = tmpVOs;
		}
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
    	OtsInquiryByDetial3VO[] tmpVOs = null;
		if (this.otsInquiryByDetialVO3s != null) {
			tmpVOs = new OtsInquiryByDetial3VO[otsInquiryByDetialVO3s.length];
			System.arraycopy(otsInquiryByDetialVO3s, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
    }

    /**
    * @param otsInquiryByDetialVO3s the otsInquiryByDetialVO3s to set
    */
    public void setOtsInquiryByDetialVO3s(
            OtsInquiryByDetial3VO[] otsInquiryByDetialVO3s) {
    	if (otsInquiryByDetialVO3s != null) {
    		OtsInquiryByDetial3VO[] tmpVOs = new OtsInquiryByDetial3VO[otsInquiryByDetialVO3s.length];
			System.arraycopy(otsInquiryByDetialVO3s, 0, tmpVOs, 0, tmpVOs.length);
			this.otsInquiryByDetialVO3s = tmpVOs;
		}
    }


}
