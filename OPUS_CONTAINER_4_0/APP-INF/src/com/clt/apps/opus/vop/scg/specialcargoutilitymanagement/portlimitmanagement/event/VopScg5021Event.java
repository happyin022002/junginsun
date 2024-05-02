/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VopScg5021Event.java 
*@FileTitle :  Port Limits Creation
*Open Issues :
*Change history : 2014.11.21
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.vo.PortLimitsDataVO;
import com.clt.framework.support.layer.event.EventSupport;
/**
 * VOP_SCG_5021 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG_5021HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see VOP_SCG_5021HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg5021Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PortLimitsDataVO portLimitsDataVO= null;
	
	/** Table Value Object 조회 조건 및 다건 처리  */
	private PortLimitsDataVO[] portLimitsDataVOs = null;	
	
	/**
	 * @return the portLimitsDataVO
	 */
	public PortLimitsDataVO getPortLimitsDataVO() {
		return portLimitsDataVO;
	}

	/**
	 * @param PortLimitsDataVO the portLimitsDataVO to set
	 */
	public void setPortLimitsDataVO(PortLimitsDataVO portLimitsDataVO) {
		this.portLimitsDataVO = portLimitsDataVO;
	}
	
	/**
	 * @return the portLimitsDataVOs
	 */
	public PortLimitsDataVO[] getPortLimitsDataVOs() {
		PortLimitsDataVO[] rtnVOs = null;
		if (this.portLimitsDataVOs != null) {
			rtnVOs = Arrays.copyOf(portLimitsDataVOs, portLimitsDataVOs.length);
		}
		return rtnVOs;
	}
	
	/**
	 * @param portLimitsDataVOs the portLimitsDataVOs to set
	 */
	public void setPortLimitsDataVOs(PortLimitsDataVO[] portLimitsDataVOs) {
		if(portLimitsDataVOs != null){
			PortLimitsDataVO[] tmpVOs = Arrays.copyOf(portLimitsDataVOs, portLimitsDataVOs.length);
			this.portLimitsDataVOs = tmpVOs;
		}
	}

}