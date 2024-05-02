/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsCni0007Event.java
 *@FileTitle : Office Code Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.05
 *@LastModifier : 양정란
 *@LastVersion : 1.0
 * 2009.10.05 양정란 
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.codemgt.codemgt.event;


import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.MdmOrganizationVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * [CPS_CNI_0007] Office Code Creation
 * @author 양정란 
 * @see CPS_CNI_0007HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsCni0007Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
    /* CLAIM PARTY NUMBER */
    private String ofcCd;

    /* Mdm Organization VO */
    private MdmOrganizationVO mdmOrganizationVO;

	public String getOfcCd() {
		return ofcCd;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	public MdmOrganizationVO getMdmOrganizationVO() {
		return mdmOrganizationVO;
	}

	public void setMdmOrganizationVO(MdmOrganizationVO mdmOrganizationVO) {
		this.mdmOrganizationVO = mdmOrganizationVO;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
    


}