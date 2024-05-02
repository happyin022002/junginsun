/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0051Event.java
*@FileTitle : 컨테이너 이송계획 관리
*Open Issues :
*Change history :
* No.	Ver.		Modifier           					modifier date    explanation
* 1		1.0		jungran yang					2006-10-19		1.0 최초 생성
* 2      	1.0      	Lee Byoung Hun				2009.08.17		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.08.17
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.08.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.event;

import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0051ConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.EqrAddPlnVO;


/**
 * EES_EQR_0051 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0051HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_EQR_0051HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0051Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr0051ConditionVO eesEqr0051ConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private EqrAddPlnVO[] eqrAddPlnVOS = null;

	public EesEqr0051Event(){}

	/**
	 * @return the eesEqr0051ConditionVO
	 */
	public EesEqr0051ConditionVO getEesEqr0051ConditionVO() {
		return eesEqr0051ConditionVO;
	}

	/**
	 * @param eesEqr0051ConditionVO the eesEqr0051ConditionVO to set
	 */
	public void setEesEqr0051ConditionVO(EesEqr0051ConditionVO eesEqr0051ConditionVO) {
		this.eesEqr0051ConditionVO = eesEqr0051ConditionVO;
	}

	/**
	 * @return the eqrAddPlnVOS
	 */
	public EqrAddPlnVO[] getEqrAddPlnVOS() {
		EqrAddPlnVO[] tmpVOs = null;
		if (this.eqrAddPlnVOS != null) {
			tmpVOs = new EqrAddPlnVO[eqrAddPlnVOS.length];
			System.arraycopy(eqrAddPlnVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param eqrAddPlnVOS the eqrAddPlnVOS to set
	 */
	public void setEqrAddPlnVOS(EqrAddPlnVO[] eqrAddPlnVOS) {
		if (eqrAddPlnVOS != null) {
			EqrAddPlnVO[] tmpVOs = new EqrAddPlnVO[eqrAddPlnVOS.length];
			System.arraycopy(eqrAddPlnVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.eqrAddPlnVOS = tmpVOs;
		}
	}

}