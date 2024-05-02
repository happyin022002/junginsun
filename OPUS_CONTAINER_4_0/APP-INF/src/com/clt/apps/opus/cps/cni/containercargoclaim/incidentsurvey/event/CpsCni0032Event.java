/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsCni0032Event.java
 *@FileTitle : Incident-Claim Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.05
 *@LastModifier : 양정란
 *@LastVersion : 1.0
 * 2009.10.05 양정란 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.incidentsurvey.event;


import com.clt.apps.opus.cps.cni.containercargoclaim.incidentsurvey.vo.IncidentClaimInquiryVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * [CPS_CNI_0032] Incident-Claim Inquiry
 * @author 양정란 
 * @see CPS_CNI_0032HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsCni0032Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
    /* CGO_CLM_INCI_NO */
    private String cgoClmInciNo;
    
    private String pageNo;

    public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	/* VO */
    private IncidentClaimInquiryVO incidentClaimInquiryVO;

	public String getCgoClmInciNo() {
		return cgoClmInciNo;
	}

	public void setCgoClmInciNo(String cgoClmInciNo) {
		this.cgoClmInciNo = cgoClmInciNo;
	}

	public IncidentClaimInquiryVO getIncidentClaimInquiryVO() {
		return incidentClaimInquiryVO;
	}

	public void setIncidentClaimInquiryVO(
			IncidentClaimInquiryVO incidentClaimInquiryVO) {
		this.incidentClaimInquiryVO = incidentClaimInquiryVO;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
    
    
}