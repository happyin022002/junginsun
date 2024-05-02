/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VopScg5923Event.java 
*@FileTitle :  Port Limits DG Total Weight Check
*Open Issues :
*Change history : 2014.11.21
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.vo.PortLimitsDataVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.vo.PortLimitsDgTotalWeightVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.vo.PortLimitsUnNoVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.vo.PortLmtSubsRskVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * VOP_SCG_5923 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG_5923HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see VOP_SCG_5923HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg5923Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PortLimitsDataVO portLimitsDataVO= null;
	
	private PortLimitsDgTotalWeightVO portLimitsDgTotalWeightVO= null;
	
	private PortLimitsUnNoVO portLimitsUnNoVO= null;
	
	private PortLmtSubsRskVO portLmtSubsRskVO= null;
	
	
	/** Table Value Object 조회 조건 및 다건 처리  */
	private PortLimitsDataVO[] portLimitsDataVOs = null;

	private PortLimitsDataVO[] portLimitsDataVOMsts = null;	
	
	private PortLimitsDgTotalWeightVO[] portLimitsDgTotalWeightVOs = null;	
	
	private PortLimitsUnNoVO[] portLimitsUnNoVOs = null;
	
	private PortLmtSubsRskVO[] portLmtSubsRskVOs= null;

	
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
	
	public PortLimitsDataVO[] getPortLimitsDataVOMsts() {
		PortLimitsDataVO[] rtnVOs = null;
		if (this.portLimitsDataVOMsts != null) {
			rtnVOs = Arrays.copyOf(portLimitsDataVOMsts, portLimitsDataVOMsts.length);
		}
		return rtnVOs;
	}

	public void setPortLimitsDataVOMsts(PortLimitsDataVO[] portLimitsDataVOMsts) {
		if(portLimitsDataVOMsts != null){
			PortLimitsDataVO[] tmpVOs = Arrays.copyOf(portLimitsDataVOMsts, portLimitsDataVOMsts.length);
			this.portLimitsDataVOMsts = tmpVOs;
		}
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
	
	/**
	 * @return the portLimitsDgTotalWeightVO
	 */
	public PortLimitsDgTotalWeightVO getPortLimitsDgTotalWeightVO() {
		return portLimitsDgTotalWeightVO;
	}

	/**
	 * @param PortLimitsDgTotalWeightVO the portLimitsDgTotalWeightVO to set
	 */
	public void setPortLimitsDgTotalWeightVO(PortLimitsDgTotalWeightVO portLimitsDgTotalWeightVO) {
		this.portLimitsDgTotalWeightVO = portLimitsDgTotalWeightVO;
	}
	
	/**
	 * @return the portLimitsDgTotalWeightVOs
	 */
	public PortLimitsDgTotalWeightVO[] getPortLimitsDgTotalWeightVOs() {
		PortLimitsDgTotalWeightVO[] rtnVOs = null;
		if (this.portLimitsDgTotalWeightVOs != null) {
			rtnVOs = Arrays.copyOf(portLimitsDgTotalWeightVOs, portLimitsDgTotalWeightVOs.length);
		}
		return rtnVOs;
	}
	
	/**
	 * @param portLimitsDgTotalWeightVOs the portLimitsDgTotalWeightVOs to set
	 */
	public void setPortLimitsDgTotalWeightVOs(PortLimitsDgTotalWeightVO[] portLimitsDgTotalWeightVOs) {
		if(portLimitsDgTotalWeightVOs != null){
			PortLimitsDgTotalWeightVO[] tmpVOs = Arrays.copyOf(portLimitsDgTotalWeightVOs, portLimitsDgTotalWeightVOs.length);
			this.portLimitsDgTotalWeightVOs = tmpVOs;
		}
	}

	public PortLimitsUnNoVO getPortLimitsUnNoVO() {
		return portLimitsUnNoVO;
	}

	public void setPortLimitsUnNoVO(PortLimitsUnNoVO portLimitsUnNoVO) {
		this.portLimitsUnNoVO = portLimitsUnNoVO;
	}

	public PortLimitsUnNoVO[] getPortLimitsUnNoVOs() {
		PortLimitsUnNoVO[] rtnVOs = null;
		if (this.portLimitsUnNoVOs != null) {
			rtnVOs = Arrays.copyOf(portLimitsUnNoVOs, portLimitsUnNoVOs.length);
		}
		return rtnVOs;
	}

	public void setPortLimitsUnNoVOs(PortLimitsUnNoVO[] portLimitsUnNoVOs) {
		if(portLimitsUnNoVOs != null){
			PortLimitsUnNoVO[] tmpVOs = Arrays.copyOf(portLimitsUnNoVOs, portLimitsUnNoVOs.length);
			this.portLimitsUnNoVOs = tmpVOs;
		}
	}

	public PortLmtSubsRskVO getPortLmtSubsRskVO() {
		return portLmtSubsRskVO;
	}

	public void setPortLmtSubsRskVO(PortLmtSubsRskVO portLmtSubsRskVO) {
		this.portLmtSubsRskVO = portLmtSubsRskVO;
	}

	public PortLmtSubsRskVO[] getPortLmtSubsRskVOs() {
		PortLmtSubsRskVO[] rtnVOs = null;
		if (this.portLmtSubsRskVOs != null) {
			rtnVOs = Arrays.copyOf(portLmtSubsRskVOs, portLmtSubsRskVOs.length);
		}
		return rtnVOs;
	}

	public void setPortLmtSubsRskVOs(PortLmtSubsRskVO[] portLmtSubsRskVOs) {
		if(portLmtSubsRskVOs != null){
			PortLmtSubsRskVO[] tmpVOs = Arrays.copyOf(portLmtSubsRskVOs, portLmtSubsRskVOs.length);
			this.portLmtSubsRskVOs = tmpVOs;
		}
	}
	
}