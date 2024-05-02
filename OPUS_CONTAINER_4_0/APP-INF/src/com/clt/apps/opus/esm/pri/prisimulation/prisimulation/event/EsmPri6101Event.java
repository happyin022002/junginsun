/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri6101Event.java
*@FileTitle : Contract Info Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.05.27 문동규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.prisimulation.prisimulation.event;

import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.vo.PriCntrInfoVO;
import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.vo.PriCntrSrhCondVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_PRI_6001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dong-Sun Moon
 * @see ESM_PRI_6001HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmPri6101Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 */
	private PriCntrSrhCondVO priCntrSrhCondVO = null;
	
	private PriCntrInfoVO priCntrInfoVO = null;
	
	public EsmPri6101Event(){}

	
	public PriCntrSrhCondVO getPriCntrSrhCondVO() {
		return priCntrSrhCondVO;
	}

	public void setPriCustSrhCondVO(PriCntrSrhCondVO priCntrSrhCondVO) {
		this.priCntrSrhCondVO = priCntrSrhCondVO;
	}


	public PriCntrInfoVO getPriCntrInfoVO() {
		return priCntrInfoVO;
	}


	public void setPriCntrInfoVO(PriCntrInfoVO priCntrInfoVO) {
		this.priCntrInfoVO = priCntrInfoVO;
	}

}
