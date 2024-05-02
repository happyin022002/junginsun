/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EsdSce0126Event.java
 *@FileTitle : Ocean Route Information
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013-09-17
 *@LastModifier : 
 *@LastVersion : 1.0
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.event;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SaveOceanRouteVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchConditionVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanRouteListVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.vo.PortPairRouteConditionVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.vo.PortPairRouteDetailVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_PRD_014 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_014HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kimyoungchul
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdSce0126Event extends EventSupport{

private static final long serialVersionUID = 1L;
	
	private String partnerId = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PortPairRouteConditionVO portPairRouteConditionVO = null;
	
	/** Table Value Object 멀티건 처리  */
	private PortPairRouteDetailVO[] portPairRouteDetailVOs = null;
	/** Table Value Object 단일건 처리  */
	private PortPairRouteDetailVO portPairRouteDetailVO = null;
	
	public EsdSce0126Event(){}

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

	public PortPairRouteDetailVO getPortPairRouteDetailVO() {
		return portPairRouteDetailVO;
	}

	public void setPortPairRouteDetailVO(PortPairRouteDetailVO portPairRouteDetailVO) {
		this.portPairRouteDetailVO = portPairRouteDetailVO;
	}

	/**
	 * @param partnerId the partnerId to set
	 */
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}
	
}
