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

package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event;

import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryBySummaryVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryParm2VO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryParmVO;
import com.hanjin.framework.support.layer.event.EventSupport;

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
    
    private OtsInquiryParm2VO otsInquiryParm2VO  = null;
    
    private OtsInquiryParm2VO[] otsInquiryParm2VOs  = null;
    
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
    	OtsInquiryParmVO[] ret = null;
		
		if (this.otsInquiryParmVOs != null) {
			ret = new OtsInquiryParmVO[otsInquiryParmVOs.length];
			
			for (int i=0; i<otsInquiryParmVOs.length; i++) {
				ret[i] = this.otsInquiryParmVOs[i];
			}
		}
		return ret;	    	
    }
    /**
    * @param otsInquiryParmVOs the otsInquiryParmVOs to set
    */
    public void setOtsInquiryParmVOs(OtsInquiryParmVO[] otsInquiryParmVOs) {
    	if (otsInquiryParmVOs != null) {
			this.otsInquiryParmVOs = new OtsInquiryParmVO[otsInquiryParmVOs.length];
			
			for (int i=0; i<otsInquiryParmVOs.length; i++) {
				this.otsInquiryParmVOs[i] = otsInquiryParmVOs[i];
			}
    	}
    }
    /**
     * @return the otsInquiryParm2VO
     */
     public OtsInquiryParm2VO getOtsInquiryParm2VO() {
         return otsInquiryParm2VO;
     }
     /**
     * @param otsInquiryParm2VO the otsInquiryParm2VO to set
     */
     public void setOtsInquiryParm2VO(OtsInquiryParm2VO otsInquiryParm2VO) {
         this.otsInquiryParm2VO = otsInquiryParm2VO;
     }
     /**
     * @return the otsInquiryParm2VOs
     */
     public OtsInquiryParm2VO[] getOtsInquiryParm2VOs() {
     	OtsInquiryParm2VO[] ret = null;
 		
 		if (this.otsInquiryParm2VOs != null) {
 			ret = new OtsInquiryParm2VO[otsInquiryParm2VOs.length];
 			
 			for (int i=0; i<otsInquiryParm2VOs.length; i++) {
 				ret[i] = this.otsInquiryParm2VOs[i];
 			}
 		}
 		return ret;	    	
     }
     /**
     * @param otsInquiryParm2VOs the otsInquiryParm2VOs to set
     */
     public void setOtsInquiryParm2VOs(OtsInquiryParm2VO[] otsInquiryParm2VOs) {
     	if (otsInquiryParm2VOs != null) {
 			this.otsInquiryParm2VOs = new OtsInquiryParm2VO[otsInquiryParm2VOs.length];
 			
 			for (int i=0; i<otsInquiryParm2VOs.length; i++) {
 				this.otsInquiryParm2VOs[i] = otsInquiryParm2VOs[i];
 			}
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
    	OtsInquiryBySummaryVO[] ret = null;
		
		if (this.otsInquiryBySummaryVOs != null) {
			ret = new OtsInquiryBySummaryVO[otsInquiryBySummaryVOs.length];
			
			for (int i=0; i<otsInquiryBySummaryVOs.length; i++) {
				ret[i] = this.otsInquiryBySummaryVOs[i];
			}
		}
		return ret;	    	
    }
    /**
    * @param otsInquiryBySummaryVOs the otsInquiryBySummaryVOs to set
    */
    public void setOtsInquiryBySummaryVOs(
            OtsInquiryBySummaryVO[] otsInquiryBySummaryVOs) {
    	if (otsInquiryBySummaryVOs != null) {
			this.otsInquiryBySummaryVOs = new OtsInquiryBySummaryVO[otsInquiryBySummaryVOs.length];
			
			for (int i=0; i<otsInquiryBySummaryVOs.length; i++) {
				this.otsInquiryBySummaryVOs[i] = otsInquiryBySummaryVOs[i];
			}
    	}
    }
}
