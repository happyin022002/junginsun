/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0009Event.java
*@FileTitle : SCNR Link 정보 조회/수정
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	yongchan shin		2006-10-17		1.0 최초 생성
* 2      	1.0      	Lee Byoung Hun	2009.07.24		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.07.24
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.07.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.ecclinkinfomanage.event;

import com.hanjin.apps.alps.ees.eqr.scenariomanage.ecclinkinfomanage.vo.EesEqr0009ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.EqrScnrEccLnkVO;


/**
 * EES_EQR_009 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_009HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_EQR_0009HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0009Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr0009ConditionVO eesEqr009ConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EqrScnrEccLnkVO[] eqrScnrEccLnkVOS = null;

	public EesEqr0009Event(){}
	
	public void setEesEqr009ConditionVO(EesEqr0009ConditionVO eesEqr009ConditionVO){
		this. eesEqr009ConditionVO = eesEqr009ConditionVO;
	}

	public EesEqr0009ConditionVO getEesEqr009ConditionVO(){
		return eesEqr009ConditionVO;
	}

	/**
	 * @return the eqrScnrEccLnkVOS
	 */
	public EqrScnrEccLnkVO[] getEqrScnrEccLnkVOS() {
		return eqrScnrEccLnkVOS;
	}

	/**
	 * @param eqrScnrEccLnkVOS the eqrScnrEccLnkVOS to set
	 */
	public void setEqrScnrEccLnkVOS(EqrScnrEccLnkVO[] eqrScnrEccLnkVOS) {
		this.eqrScnrEccLnkVOS = eqrScnrEccLnkVOS;
	}

}