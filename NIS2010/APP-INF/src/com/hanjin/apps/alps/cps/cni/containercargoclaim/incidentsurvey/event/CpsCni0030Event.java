/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsCni0030Event.java
 *@FileTitle : Incident-Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.05
 *@LastModifier : 양정란
 *@LastVersion : 1.0
 * 2009.10.05 양정란 
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.event;


import com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.vo.CniCgoClmInciVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.vo.IncidentCreationVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * [CPS_CNI_0030] Incident-Creation
 * @author 양정란 
 * @see CPS_CNI_0030HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsCni0030Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
    /* CGO_CLM_ INCI_NO */
    private String cgoClmInciNo;
    
    /* Search Text */
	private String searchText = "";

    /* VO */
    private IncidentCreationVO incidentCreationVO;
    private CniCgoClmInciVO cniCgoClmInciVO;
	public IncidentCreationVO getIncidentCreationVO() {
		return incidentCreationVO;
	}
	public void setIncidentCreationVO(IncidentCreationVO incidentCreationVO) {
		this.incidentCreationVO = incidentCreationVO;
	}
	public String getCgoClmInciNo() {
		return cgoClmInciNo;
	}
	public void setCgoClmInciNo(String cgoClmInciNo) {
		this.cgoClmInciNo = cgoClmInciNo;
	}

	public CniCgoClmInciVO getCniCgoClmInciVO() {
		return cniCgoClmInciVO;
	}
	public void setCniCgoClmInciVO(CniCgoClmInciVO cniCgoClmInciVO) {
		this.cniCgoClmInciVO = cniCgoClmInciVO;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	
	
}