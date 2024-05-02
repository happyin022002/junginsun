/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0054Event.java
*@FileTitle : 컨테이너 수급 예측실적 및 정확도 조회
*Open Issues :
*Change history :
* No.	Ver.		Modifier           					modifier date    explanation
* 1		1.0		jungran yang					2006-10-25		1.0 최초 생성
* 2		1.0		Lee Byoung Hun				2009.09.09		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.09.09
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.09.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.event;

import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0053MultiVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0054ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_0054 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0054HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_EQR_0054HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0054Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr0054ConditionVO eesEqr0054ConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EesEqr0053MultiVO[] eesEqr0053MultiVOS = null;

	public EesEqr0054Event(){}

	/**
	 * @return the eesEqr0054ConditionVO
	 */
	public EesEqr0054ConditionVO getEesEqr0054ConditionVO() {
		return eesEqr0054ConditionVO;
	}

	/**
	 * @param eesEqr0054ConditionVO the eesEqr0054ConditionVO to set
	 */
	public void setEesEqr0054ConditionVO(EesEqr0054ConditionVO eesEqr0054ConditionVO) {
		this.eesEqr0054ConditionVO = eesEqr0054ConditionVO;
	}

	/**
	 * @return the eesEqr0053MultiVOS
	 */
	public EesEqr0053MultiVO[] getEesEqr0053MultiVOS() {
		return eesEqr0053MultiVOS;
	}

	/**
	 * @param eesEqr0053MultiVOS the eesEqr0053MultiVOS to set
	 */
	public void setEesEqr0053MultiVOS(EesEqr0053MultiVO[] eesEqr0053MultiVOS) {
		this.eesEqr0053MultiVOS = eesEqr0053MultiVOS;
	}

}