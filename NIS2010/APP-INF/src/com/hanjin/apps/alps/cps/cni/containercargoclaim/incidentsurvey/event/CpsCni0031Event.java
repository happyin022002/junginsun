/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsCni0031Event.java
 *@FileTitle : Incident-Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.05
 *@LastModifier : 양정란
 *@LastVersion : 1.0
 * 2009.10.05 양정란 
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.event;


import com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.vo.IncidentInquiryCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * [CPS_CNI_0031] Incident-Inquiry
 * @author 양정란 
 * @see CPS_CNI_0031HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsCni0031Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
    /* CGO_CLM_INCI_NO */
//    private String cgoClmInciNo;

    /* VO */
    private IncidentInquiryCondVO incidentInquiryCondVO;

	public IncidentInquiryCondVO getIncidentInquiryCondVO() {
		return incidentInquiryCondVO;
	}

	public void setIncidentInquiryCondVO(IncidentInquiryCondVO incidentInquiryCondVO) {
		this.incidentInquiryCondVO = incidentInquiryCondVO;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
    
    
}