/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EesEqr0090Event.java
*@FileTitle : US Domestic 물량 조회/수정
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-10
*@LastModifier : ChungEunHo
*@LastVersion : 1.0
* 2009-08-10 ChungEunHo
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.event;

import com.clt.apps.opus.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.vo.EesEqr0090ConditionVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.EqrScnrSlseVO;


/**
 * EES_EQR_0090 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_EQR_0090HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author ChungEunHo
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesEqr0090Event extends EventSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EesEqr0090ConditionVO conditionVO = null;
	private EesEqr0090ConditionVO[] conditionVOS = null;

	private EqrScnrSlseVO eqrScnrSlseVO = null;
	private EqrScnrSlseVO[] eqrScnrSlseVOS = null;
	public EesEqr0090ConditionVO getConditionVO() {
		return conditionVO;
	}
	public void setConditionVO(EesEqr0090ConditionVO conditionVO) {
		this.conditionVO = conditionVO;
	}
	public EesEqr0090ConditionVO[] getConditionVOS() {
		EesEqr0090ConditionVO[] tmpVOs = null;
		if (this.conditionVOS != null) {
			tmpVOs = new EesEqr0090ConditionVO[conditionVOS.length];
			System.arraycopy(conditionVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	public void setConditionVOS(EesEqr0090ConditionVO[] conditionVOS) {
		if (conditionVOS != null) {
			EesEqr0090ConditionVO[] tmpVOs = new EesEqr0090ConditionVO[conditionVOS.length];
			System.arraycopy(conditionVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.conditionVOS = tmpVOs;
		}
	}
	public EqrScnrSlseVO getEqrScnrSlseVO() {
		return eqrScnrSlseVO;
	}
	public void setEqrScnrSlseVO(EqrScnrSlseVO eqrScnrSlseVO) {
		this.eqrScnrSlseVO = eqrScnrSlseVO;
	}
	public EqrScnrSlseVO[] getEqrScnrSlseVOS() {
		EqrScnrSlseVO[] tmpVOs = null;
		if (this.eqrScnrSlseVOS != null) {
			tmpVOs = new EqrScnrSlseVO[eqrScnrSlseVOS.length];
			System.arraycopy(eqrScnrSlseVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	public void setEqrScnrSlseVOS(EqrScnrSlseVO[] eqrScnrSlseVOS) {
		if (eqrScnrSlseVOS != null) {
			EqrScnrSlseVO[] tmpVOs = new EqrScnrSlseVO[eqrScnrSlseVOS.length];
			System.arraycopy(eqrScnrSlseVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.eqrScnrSlseVOS = tmpVOs;
		}
	}
	
	
	
}
