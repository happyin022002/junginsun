/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopPso0002Event.java
*@FileTitle : Service Provider Help
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 박명종
*@LastVersion : 1.0
* 2009.06.03 박명종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.event;

import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.UseStatusConForVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VOP_PSO-0002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_PSO-0002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park MyoungJong
 * @see VOP_PSO-0002HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopPso0209Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private UseStatusConForVO useStatusConForVO = null;
	/**
	 * @param useStatusConForVO the useStatusConForVO to set
	 */
	public void setUseStatusConForVO(UseStatusConForVO useStatusConForVO) {
		this.useStatusConForVO = useStatusConForVO;
	}
	/**
	 * @return the useStatusConForVO
	 */
	public UseStatusConForVO getUseStatusConForVO() {
		return useStatusConForVO;
	}
	
	
	
}