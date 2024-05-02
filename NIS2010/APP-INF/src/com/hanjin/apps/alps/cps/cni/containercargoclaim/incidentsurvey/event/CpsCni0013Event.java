/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsCni0013Event.java
 *@FileTitle : Salvage
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.05
 *@LastModifier : 양정란
 *@LastVersion : 1.0
 * 2009.10.05 양정란 
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.event;


import com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.vo.CniCgoClmSlvVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.vo.SalvageVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * [CPS_CNI_0013] Salvage
 * @author 양정란 
 * @see CPS_CNI_0013HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsCni0013Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
    /* CGO_CLM_NO */
    private String cgoClmNo;

    /* VO */
    private SalvageVO salvage;
    private CniCgoClmSlvVO cniCgoClmSlvVO;
	public String getCgoClmNo() {
		return cgoClmNo;
	}
	public void setCgoClmNo(String cgoClmNo) {
		this.cgoClmNo = cgoClmNo;
	}
	public SalvageVO getSalvage() {
		return salvage;
	}
	public void setSalvage(SalvageVO salvage) {
		this.salvage = salvage;
	}
	public CniCgoClmSlvVO getCniCgoClmSlvVO() {
		return cniCgoClmSlvVO;
	}
	public void setCniCgoClmSlvVO(CniCgoClmSlvVO cniCgoClmSlvVO) {
		this.cniCgoClmSlvVO = cniCgoClmSlvVO;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
    
   


}