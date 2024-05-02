/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VopScg5922Event.java 
*@FileTitle :  Port Limits DG Total Weight Check
*Open Issues :
*Change history : 2014.11.21
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.vo.PortLimitsBkgVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * VOP_SCG_5922 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG_5922HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see VOP_SCG_5922HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg5922Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PortLimitsBkgVO portLimitsBkgVO= null;
	
	
	/** Table Value Object 조회 조건 및 다건 처리  */
	private PortLimitsBkgVO[] portLimitsBkgVOs = null;


	public PortLimitsBkgVO getPortLimitsBkgVO() {
		return portLimitsBkgVO;
	}


	public void setPortLimitsBkgVO(PortLimitsBkgVO portLimitsBkgVO) {
		this.portLimitsBkgVO = portLimitsBkgVO;
	}


	public PortLimitsBkgVO[] getPortLimitsBkgVOs() {
		PortLimitsBkgVO[] rtnVOs = null;
		if (this.portLimitsBkgVOs != null) {
			rtnVOs = Arrays.copyOf(portLimitsBkgVOs, portLimitsBkgVOs.length);
		}
		return rtnVOs;
	}


	public void setPortLimitsBkgVOs(PortLimitsBkgVO[] portLimitsBkgVOs) {
		if(portLimitsBkgVOs != null){
			PortLimitsBkgVO[] tmpVOs = Arrays.copyOf(portLimitsBkgVOs, portLimitsBkgVOs.length);
			this.portLimitsBkgVOs = tmpVOs;
		}
	}

}