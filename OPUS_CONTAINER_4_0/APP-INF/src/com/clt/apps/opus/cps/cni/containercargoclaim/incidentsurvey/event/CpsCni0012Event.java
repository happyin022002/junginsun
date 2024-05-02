/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsCni0012Event.java
 *@FileTitle : Survey
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.05
 *@LastModifier : 양정란
 *@LastVersion : 1.0
 * 2009.10.05 양정란 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.incidentsurvey.event;


import com.clt.apps.opus.cps.cni.containercargoclaim.incidentsurvey.vo.CniCgoClmSveyVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.incidentsurvey.vo.SurveyVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * [CPS_CNI_0012] Survey
 * @author 양정란 
 * @see CPS_CNI_0012HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsCni0012Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
    /* CGO_CLM_NO */
    private String cgoClmNo;

    /* VO */
    private SurveyVO surveyVO;
    private CniCgoClmSveyVO cniCgoClmSveyVO;
    

	public CniCgoClmSveyVO getCniCgoClmSveyVO() {
		return cniCgoClmSveyVO;
	}

	public void setCniCgoClmSveyVO(CniCgoClmSveyVO cniCgoClmSveyVO) {
		this.cniCgoClmSveyVO = cniCgoClmSveyVO;
	}

	public SurveyVO getSurveyVO() {
		return surveyVO;
	}

	public void setSurveyVO(SurveyVO surveyVO) {
		this.surveyVO = surveyVO;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getCgoClmNo() {
		return cgoClmNo;
	}

	public void setCgoClmNo(String cgoClmNo) {
		this.cgoClmNo = cgoClmNo;
	}
    


}