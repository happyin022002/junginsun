/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VopPso0042Event.java
*@FileTitle : Yard Charge Remark 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.06
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2014.08.06 이성훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.event;

import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.PortTariffListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * VOP_PSO-0042 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_PSO-0042HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Sung Hoon
 * @see VOP_PSO-0042HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopPso0042Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public VopPso0042Event(){}

	/** Table Value Object 조회 조건 및 단건 처리  입력VO   */
	private PortTariffListVO portTariffListVO = null;
	
	/**
	 * @return the portTariffListVO
	 */
	public PortTariffListVO getPortTariffListVO() {
		return portTariffListVO;
	}
	/**
	 * @param portTariffListVO the portTariffListVO to set
	 */
	public void setPortTariffListVO(PortTariffListVO portTariffListVO) {
		this.portTariffListVO = portTariffListVO;
	}
	
}