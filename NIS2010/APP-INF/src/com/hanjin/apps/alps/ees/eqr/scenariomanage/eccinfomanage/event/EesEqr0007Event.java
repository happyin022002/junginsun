/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr007Event.java
*@FileTitle : SCNR ECC 정보 조회/수정
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	yongchan shin		2006-09-28		1.0 최초 생성
* 2      	1.0      	Lee Byoung Hun	2009.07.20		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.07.20
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.07.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.eccinfomanage.event;

import com.hanjin.apps.alps.ees.eqr.scenariomanage.eccinfomanage.vo.EesEqr0007ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.EqrScnrEccVO;
import com.hanjin.syscommon.common.table.EqrScnrTsTmlVO;


/**
 * EES_EQR_007 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_007HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_EQR_0007HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0007Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr0007ConditionVO eesEqr007ConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EqrScnrEccVO[] eqrScnrEccVOS = null;
	
	/** Table Value Object Multi Data 처리 */
	public EqrScnrTsTmlVO[] eqrScnrTsTmlVOS = null;

	public EesEqr0007Event(){}
	
	public void setEesEqr007ConditionVO(EesEqr0007ConditionVO eesEqr007ConditionVO){
		this. eesEqr007ConditionVO = eesEqr007ConditionVO;
	}

	public EesEqr0007ConditionVO getEesEqr007ConditionVO(){
		return eesEqr007ConditionVO;
	}

	/**
	 * @return the eqrScnrEccVOS
	 */
	public EqrScnrEccVO[] getEqrScnrEccVOS() {
		return eqrScnrEccVOS;
	}

	/**
	 * @param eqrScnrEccVOS the eqrScnrEccVOS to set
	 */
	public void setEqrScnrEccVOS(EqrScnrEccVO[] eqrScnrEccVOS) {
		this.eqrScnrEccVOS = eqrScnrEccVOS;
	}

	/**
	 * @return the eqrScnrTsTmlVOS
	 */
	public EqrScnrTsTmlVO[] getEqrScnrTsTmlVOS() {
		return eqrScnrTsTmlVOS;
	}

	/**
	 * @param eqrScnrTsTmlVOS the eqrScnrTsTmlVOS to set
	 */
	public void setEqrScnrTsTmlVOS(EqrScnrTsTmlVO[] eqrScnrTsTmlVOS) {
		this.eqrScnrTsTmlVOS = eqrScnrTsTmlVOS;
	}

}