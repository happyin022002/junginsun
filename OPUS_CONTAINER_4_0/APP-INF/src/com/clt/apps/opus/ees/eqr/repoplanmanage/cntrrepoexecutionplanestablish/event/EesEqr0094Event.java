/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0094Event.java
*@FileTitle : Inventory Container List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.08.20 정은호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event;

import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0094ConditionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_0094 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0094HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author ChungEunHo
 * @see EES_EQR_0094HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0094Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr0094ConditionVO eesEqr0094ConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private EesEqr0094ConditionVO[] eesEqr0094ConditionVOs = null;

	public EesEqr0094Event(){}
	
	public void setEesEqr0094ConditionVO(EesEqr0094ConditionVO eesEqr0094ConditionVO){
		this. eesEqr0094ConditionVO = eesEqr0094ConditionVO;
	}

	public void setEesEqr0094ConditionVOS(EesEqr0094ConditionVO[] eesEqr0094ConditionVOs){
		if (eesEqr0094ConditionVOs != null) {
			EesEqr0094ConditionVO[] tmpVOs = new EesEqr0094ConditionVO[eesEqr0094ConditionVOs.length];
			System.arraycopy(eesEqr0094ConditionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eesEqr0094ConditionVOs = tmpVOs;
		}
	}

	public EesEqr0094ConditionVO getEesEqr0094ConditionVO(){
		return eesEqr0094ConditionVO;
	}

	public EesEqr0094ConditionVO[] getEesEqr0094ConditionVOS(){
		EesEqr0094ConditionVO[] tmpVOs = null;
		if (this.eesEqr0094ConditionVOs != null) {
			tmpVOs = new EesEqr0094ConditionVO[eesEqr0094ConditionVOs.length];
			System.arraycopy(eesEqr0094ConditionVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}