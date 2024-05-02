/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt6014Event.java
*@FileTitle : Guarantee Letter Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.21
*@LastModifier : Kim YC
*@LastVersion : 1.0
* 2016.06.21 Kim YC
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.waivereport.event;

import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.waivereport.vo.AfterBookingFileLetterVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES_DMT_6014 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_6014HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hwang HyoKeun
 * @see EES_DMT_6014HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt6014Event extends EventSupport {

    private static final long serialVersionUID = 1L;
    
    private AfterBookingFileLetterVO  afterBookingFileLetterVO  = null;

    private AfterBookingFileLetterVO [] afterBookingFileLetterVOs  = null;

    
    public EesDmt6014Event(){}

    /**
    * @return the afterBookingFileLetterVO
    */
    public AfterBookingFileLetterVO getAfterBookingFileLetterVO() {
        return afterBookingFileLetterVO;
    }
    /**
    * @param afterBookingFileLetterVO the afterBookingFileLetterVO to set
    */
    public void setAfterBookingFileLetterVO(AfterBookingFileLetterVO afterBookingFileLetterVO) {
        this.afterBookingFileLetterVO = afterBookingFileLetterVO;
    }
    /**
    * @return the waiveReportParmVOs
    */
    public AfterBookingFileLetterVO[] getAfterBookingFileLetterVOs() {
    	AfterBookingFileLetterVO[] ret = null;
		
		if (this.afterBookingFileLetterVOs != null) {
			ret = new AfterBookingFileLetterVO[afterBookingFileLetterVOs.length];
			
			for (int i=0; i<afterBookingFileLetterVOs.length; i++) {
				ret[i] = this.afterBookingFileLetterVOs[i];
			}
		}
		return ret;    	
    }
    /**
    * @param waiveReportParmVOs the waiveReportParmVOs to set
    */
    public void setAfterBookingFileLetterVOs(AfterBookingFileLetterVO[] afterBookingFileLetterVOs) {
    	if (afterBookingFileLetterVOs != null) {
			this.afterBookingFileLetterVOs = new AfterBookingFileLetterVO[afterBookingFileLetterVOs.length];
			
			for (int i=0; i<afterBookingFileLetterVOs.length; i++) {
				this.afterBookingFileLetterVOs[i] = afterBookingFileLetterVOs[i];
			}
    	}
    }
}