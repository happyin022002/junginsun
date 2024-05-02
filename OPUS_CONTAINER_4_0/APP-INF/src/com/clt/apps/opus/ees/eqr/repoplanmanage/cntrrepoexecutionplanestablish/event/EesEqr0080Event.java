/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0080Event.java
*@FileTitle : 컨테이너 이송 실행 계획 조회/수정 Truck/Rail/Barge
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.08.24 정은호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event;

import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0059ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0080MultiVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_0080 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0080HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author ChungEunHo
 * @see EES_EQR_0080HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0080Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr0059ConditionVO eesEqr0059ConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private EesEqr0059ConditionVO[] eesEqr0059ConditionVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private EesEqr0080MultiVO[] eesEqr0080MultiVOS = null;
	

	public EesEqr0080Event(){}
	
	public void setEesEqr0059ConditionVO(EesEqr0059ConditionVO eesEqr0059ConditionVO){
		this. eesEqr0059ConditionVO = eesEqr0059ConditionVO;
	}

	public void setEesEqr0059ConditionVOS(EesEqr0059ConditionVO[] eesEqr0059ConditionVOs){
		if (eesEqr0059ConditionVOs != null) {
			EesEqr0059ConditionVO[] tmpVOs = new EesEqr0059ConditionVO[eesEqr0059ConditionVOs.length];
			System.arraycopy(eesEqr0059ConditionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eesEqr0059ConditionVOs = tmpVOs;
		}
	}

	public EesEqr0059ConditionVO getEesEqr0059ConditionVO(){
		return eesEqr0059ConditionVO;
	}

	public EesEqr0059ConditionVO[] getEesEqr0059ConditionVOS(){
		EesEqr0059ConditionVO[] tmpVOs = null;
		if (this.eesEqr0059ConditionVOs != null) {
			tmpVOs = new EesEqr0059ConditionVO[eesEqr0059ConditionVOs.length];
			System.arraycopy(eesEqr0059ConditionVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public EesEqr0080MultiVO[] getEesEqr0080MultiVOS() {
		EesEqr0080MultiVO[] tmpVOs = null;
		if (this.eesEqr0080MultiVOS != null) {
			tmpVOs = new EesEqr0080MultiVO[eesEqr0080MultiVOS.length];
			System.arraycopy(eesEqr0080MultiVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setEesEqr0080MultiVOS(EesEqr0080MultiVO[] eesEqr0080MultiVOS) {
		if (eesEqr0080MultiVOS != null) {
			EesEqr0080MultiVO[] tmpVOs = new EesEqr0080MultiVO[eesEqr0080MultiVOS.length];
			System.arraycopy(eesEqr0080MultiVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.eesEqr0080MultiVOS = tmpVOs;
		}
	}
	

}