/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdSce0120Event.java
*@FileTitle : Exception Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 신한성
*@LastVersion : 1.0
* 2009.07.02 신한성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.event;

import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.vo.PortPairRouteConditionVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.vo.PortPairRouteDetailVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.vo.PortPairRouteMstVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * UI_SCE_001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_SCE_001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Shin Han Sung
 * @see UI_SCE_011HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdSce0121Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String partnerId = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PortPairRouteConditionVO portPairRouteConditionVO = null;
	
	/** Table Value Object 멀티건 처리  */
	private PortPairRouteDetailVO[] portPairRouteDetailVOs = null;
	
	public EsdSce0121Event(){}

	/**
	 * @return the portPairRouteConditionVO
	 */
	public PortPairRouteConditionVO getPortPairRouteConditionVO() {
		return portPairRouteConditionVO;
	}

	/**
	 * @return the portPairRouteDetailVOs
	 */
	public PortPairRouteDetailVO[] getPortPairRouteDetailVOs() {
		return portPairRouteDetailVOs;
	}

	/**
	 * @param portPairRouteDetailVOs the portPairRouteDetailVOs to set
	 */
	public void setPortPairRouteDetailVOs(PortPairRouteDetailVO[] portPairRouteDetailVOs) {
		this.portPairRouteDetailVOs = portPairRouteDetailVOs;
	}

	/**
	 * @param portPairRouteConditionVO the portPairRouteConditionVO to set
	 */
	public void setPortPairRouteConditionVO(
			PortPairRouteConditionVO portPairRouteConditionVO) {
		this.portPairRouteConditionVO = portPairRouteConditionVO;
	}

	/**
	 * @return the partnerId
	 */
	public String getPartnerId() {
		return partnerId;
	}

	/**
	 * @param partnerId the partnerId to set
	 */
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}
	
	
}