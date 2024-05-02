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
package com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.vo.ExceptionalRouteVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.vo.PortPairRouteConditionVO;

/**
 * UI_SCE_001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_SCE_001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Shin Han Sung
 * @see UI_SCE_011HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdSce0125Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String partnerId = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ExceptionalRouteVO exceptionalRouteVO = null;
	
	private PortPairRouteConditionVO portPairRouteConditionVO = null;
	
	/** Table Value Object 멀티건 처리  */
	private ExceptionalRouteVO[] exceptionalRouteVOs = null;
	
	public EsdSce0125Event(){}

	/**
	 * @return the exceptionalRouteVO
	 */
	public ExceptionalRouteVO getExceptionalRouteVO() {
		return exceptionalRouteVO;
	}

	/**
	 * @return the exceptionalRouteVOs
	 */
	public ExceptionalRouteVO[] getExceptionalRouteVOs() {
		return exceptionalRouteVOs;
	}

	/**
	 * @param exceptionalRouteVOs the exceptionalRouteVOs to set
	 */
	public void setExceptionalRouteVOs(ExceptionalRouteVO[] exceptionalRouteVOs) {
		this.exceptionalRouteVOs = exceptionalRouteVOs;
	}

	/**
	 * @param exceptionalRouteVO the exceptionalRouteVO to set
	 */
	public void setExceptionalRouteVO(
			ExceptionalRouteVO exceptionalRouteVO) {
		this.exceptionalRouteVO = exceptionalRouteVO;
	}
	
	/**
	 * @return the portPairRouteConditionVO
	 */
	public PortPairRouteConditionVO getPortPairRouteConditionVO() {
		return portPairRouteConditionVO;
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