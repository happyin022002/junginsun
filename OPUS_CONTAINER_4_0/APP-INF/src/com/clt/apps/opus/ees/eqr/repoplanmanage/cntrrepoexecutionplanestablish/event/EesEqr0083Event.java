/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0083Event.java
*@FileTitle : 컨테이너 이송 실행 계획 조회/수정 ECC Internal
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.09.23 정은호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event;

import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0059ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0083MultiVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_0083 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0083HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author ChungEunHo
 * @see EES_EQR_0083HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0083Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr0059ConditionVO eesEqr0059ConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private EesEqr0083MultiVO[] eesEqr0083MultiVOS = null;

	public EesEqr0083Event(){}

	public EesEqr0059ConditionVO getEesEqr0059ConditionVO() {
		return eesEqr0059ConditionVO;
	}

	public void setEesEqr0059ConditionVO(EesEqr0059ConditionVO eesEqr0059ConditionVO) {
		this.eesEqr0059ConditionVO = eesEqr0059ConditionVO;
	}

	public EesEqr0083MultiVO[] getEesEqr0083MultiVOS() {
		EesEqr0083MultiVO[] tmpVOs = null;
		if (this.eesEqr0083MultiVOS != null) {
			tmpVOs = new EesEqr0083MultiVO[eesEqr0083MultiVOS.length];
			System.arraycopy(eesEqr0083MultiVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setEesEqr0083MultiVOS(EesEqr0083MultiVO[] eesEqr0083MultiVOS) {
		if (eesEqr0083MultiVOS != null) {
			EesEqr0083MultiVO[] tmpVOs = new EesEqr0083MultiVO[eesEqr0083MultiVOS.length];
			System.arraycopy(eesEqr0083MultiVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.eesEqr0083MultiVOS = tmpVOs;
		}
	}
	

}