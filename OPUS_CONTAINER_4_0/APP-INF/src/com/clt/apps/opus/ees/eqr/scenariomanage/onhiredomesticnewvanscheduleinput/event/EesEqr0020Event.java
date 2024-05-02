/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0020Event.java
*@FileTitle : 연간신조 및 L/T 계획 조회 / 수정
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	ChangHoChae		2006-09-15		1.0 최초 생성
* 2      	1.0      	Lee Byoung Hun	2009.07.29		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.07.29
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.07.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.event;

import com.clt.apps.opus.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.vo.EesEqr0020ConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.EqrScnrNewVanLongTermVO;


/**
 * EES_EQR_0020 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0020HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_EQR_0020HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0020Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr0020ConditionVO eesEqr0020ConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private EqrScnrNewVanLongTermVO[] eqrScnrNewVanLongTermVOS = null;

	public EesEqr0020Event(){}

	/**
	 * @return the eesEqr0020ConditionVO
	 */
	public EesEqr0020ConditionVO getEesEqr0020ConditionVO() {
		return eesEqr0020ConditionVO;
	}

	/**
	 * @param eesEqr0020ConditionVO the eesEqr0020ConditionVO to set
	 */
	public void setEesEqr0020ConditionVO(EesEqr0020ConditionVO eesEqr0020ConditionVO) {
		this.eesEqr0020ConditionVO = eesEqr0020ConditionVO;
	}

	/**
	 * @return the eqrScnrNewVanLongTermVOS
	 */
	public EqrScnrNewVanLongTermVO[] getEqrScnrNewVanLongTermVOS() {
		EqrScnrNewVanLongTermVO[] tmpVOs = null;
		if (this.eqrScnrNewVanLongTermVOS != null) {
			tmpVOs = new EqrScnrNewVanLongTermVO[eqrScnrNewVanLongTermVOS.length];
			System.arraycopy(eqrScnrNewVanLongTermVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param eqrScnrNewVanLongTermVOS the eqrScnrNewVanLongTermVOS to set
	 */
	public void setEqrScnrNewVanLongTermVOS(
			EqrScnrNewVanLongTermVO[] eqrScnrNewVanLongTermVOS) {
		if (eqrScnrNewVanLongTermVOS != null) {
			EqrScnrNewVanLongTermVO[] tmpVOs = new EqrScnrNewVanLongTermVO[eqrScnrNewVanLongTermVOS.length];
			System.arraycopy(eqrScnrNewVanLongTermVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.eqrScnrNewVanLongTermVOS = tmpVOs;
		}
	}

}