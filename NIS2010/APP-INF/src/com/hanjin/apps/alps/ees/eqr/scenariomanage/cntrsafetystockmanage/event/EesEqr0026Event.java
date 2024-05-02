/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0026Event.java
*@FileTitle : Safty Stock
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.08.11 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrsafetystockmanage.event;

import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrsafetystockmanage.vo.EesEqr0026ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.EqrScnrEccSftStkVO;


/**
 * EES_EQR_0026 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0026HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Haeng-ji,Lee
 * @see EES_EQR_0026HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0026Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EqrScnrEccSftStkVO eqrScnrEccSftStkVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EqrScnrEccSftStkVO[] eqrScnrEccSftStkVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr0026ConditionVO eesEqr0026ConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EesEqr0026ConditionVO[] eesEqr0026ConditionVOs = null;

	public EesEqr0026Event(){}
	
	public void setEqrScnrEccSftStkVO(EqrScnrEccSftStkVO eqrScnrEccSftStkVO){
		this. eqrScnrEccSftStkVO = eqrScnrEccSftStkVO;
	}

	public void setEqrScnrEccSftStkVOS(EqrScnrEccSftStkVO[] eqrScnrEccSftStkVOs){
		this. eqrScnrEccSftStkVOs = eqrScnrEccSftStkVOs;
	}

	public void setEesEqr0026ConditionVO(EesEqr0026ConditionVO eesEqr0026ConditionVO){
		this. eesEqr0026ConditionVO = eesEqr0026ConditionVO;
	}

	public void setEesEqr0026ConditionVOS(EesEqr0026ConditionVO[] eesEqr0026ConditionVOs){
		this. eesEqr0026ConditionVOs = eesEqr0026ConditionVOs;
	}

	public EqrScnrEccSftStkVO getEqrScnrEccSftStkVO(){
		return eqrScnrEccSftStkVO;
	}

	public EqrScnrEccSftStkVO[] getEqrScnrEccSftStkVOS(){
		return eqrScnrEccSftStkVOs;
	}

	public EesEqr0026ConditionVO getEesEqr0026ConditionVO(){
		return eesEqr0026ConditionVO;
	}

	public EesEqr0026ConditionVO[] getEesEqr0026ConditionVOS(){
		return eesEqr0026ConditionVOs;
	}

}