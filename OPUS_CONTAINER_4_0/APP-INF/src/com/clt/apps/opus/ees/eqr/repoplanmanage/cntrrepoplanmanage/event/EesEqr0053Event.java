/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0053Event.java
*@FileTitle : 컨테이너 수급 예측실적 및 정확도 조회
*Open Issues :
*Change history :
* No.	Ver.		Modifier           					modifier date    explanation
* 1		1.0		jungran yang					2006-10-24		1.0 최초 생성
* 2		1.0		Lee Byoung Hun				2009.09.03		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.09.03
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.09.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.event;

import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0053ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0053MultiVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_0053 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0053HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_EQR_0053HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0053Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr0053ConditionVO eesEqr0053ConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private EesEqr0053MultiVO[] eesEqr0053MultiVOS = null;

	public EesEqr0053Event(){}

	/**
	 * @return the eesEqr0053ConditionVO
	 */
	public EesEqr0053ConditionVO getEesEqr0053ConditionVO() {
		return eesEqr0053ConditionVO;
	}

	/**
	 * @param eesEqr0053ConditionVO the eesEqr0053ConditionVO to set
	 */
	public void setEesEqr0053ConditionVO(EesEqr0053ConditionVO eesEqr0053ConditionVO) {
		this.eesEqr0053ConditionVO = eesEqr0053ConditionVO;
	}

	/**
	 * @return the eesEqr0053MultiVOS
	 */
	public EesEqr0053MultiVO[] getEesEqr0053MultiVOS() {
		EesEqr0053MultiVO[] tmpVOs = null;
		if (this.eesEqr0053MultiVOS != null) {
			tmpVOs = new EesEqr0053MultiVO[eesEqr0053MultiVOS.length];
			System.arraycopy(eesEqr0053MultiVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param eesEqr0053MultiVOS the eesEqr0053MultiVOS to set
	 */
	public void setEesEqr0053MultiVOS(EesEqr0053MultiVO[] eesEqr0053MultiVOS) {
		if (eesEqr0053MultiVOS != null) {
			EesEqr0053MultiVO[] tmpVOs = new EesEqr0053MultiVO[eesEqr0053MultiVOS.length];
			System.arraycopy(eesEqr0053MultiVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.eesEqr0053MultiVOS = tmpVOs;
		}
	}

}