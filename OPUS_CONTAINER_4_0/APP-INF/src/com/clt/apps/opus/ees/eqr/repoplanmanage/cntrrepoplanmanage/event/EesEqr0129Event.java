/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0129Event.java
*@FileTitle : TS Guideline Popup
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	jungran yang		2007-01-23		1.0 최초 생성
* 2      	1.0      	Lee Byoung Hun	2009.09.03		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.09.02
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.09.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.event;

import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0129ConditionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_0129 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0129HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_EQR_0129HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0129Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr0129ConditionVO eesEqr0129ConditionVO = null;

	public EesEqr0129Event(){}

	/**
	 * @return the eesEqr0129ConditionVO
	 */
	public EesEqr0129ConditionVO getEesEqr0129ConditionVO() {
		return eesEqr0129ConditionVO;
	}

	/**
	 * @param eesEqr0129ConditionVO the eesEqr0129ConditionVO to set
	 */
	public void setEesEqr0129ConditionVO(EesEqr0129ConditionVO eesEqr0129ConditionVO) {
		this.eesEqr0129ConditionVO = eesEqr0129ConditionVO;
	}

}