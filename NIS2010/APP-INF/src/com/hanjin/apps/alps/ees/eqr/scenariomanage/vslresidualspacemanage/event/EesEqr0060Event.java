/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0060Event.java
*@FileTitle : Vessel R.Capa.
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.08.06 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.event;

import com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.vo.EesEqr0060ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.EqrScnrVslRsdlCapaVO;


/**
 * EES_EQR_0060 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0060HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Haeng-ji,Lee
 * @see EES_EQR_0060HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0060Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EqrScnrVslRsdlCapaVO eqrScnrVslRsdlCapaVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EqrScnrVslRsdlCapaVO[] eqrScnrVslRsdlCapaVOs = null;
	
	/** 검색조건 VO **/
	private EesEqr0060ConditionVO eesEqr0060ConditionVO = null;
	public EesEqr0060ConditionVO[] eesEqr0060ConditionVOs = null;

	public EesEqr0060Event(){}
	
	public void setEqrScnrVslRsdlCapaVO(EqrScnrVslRsdlCapaVO eqrScnrVslRsdlCapaVO){
		this. eqrScnrVslRsdlCapaVO = eqrScnrVslRsdlCapaVO;
	}

	public void setEqrScnrVslRsdlCapaVOS(EqrScnrVslRsdlCapaVO[] eqrScnrVslRsdlCapaVOs){
		this. eqrScnrVslRsdlCapaVOs = eqrScnrVslRsdlCapaVOs;
	}

	public EqrScnrVslRsdlCapaVO getEqrScnrVslRsdlCapaVO(){
		return eqrScnrVslRsdlCapaVO;
	}

	public EqrScnrVslRsdlCapaVO[] getEqrScnrVslRsdlCapaVOS(){
		return eqrScnrVslRsdlCapaVOs;
	}
	

	public EesEqr0060ConditionVO getEesEqr0060ConditionVO() {
		return eesEqr0060ConditionVO;
	}

	public void setEesEqr0060ConditionVO(EesEqr0060ConditionVO eesEqr0060ConditionVO) {
		this.eesEqr0060ConditionVO = eesEqr0060ConditionVO;
	}

	public EesEqr0060ConditionVO[] getEesEqr0060ConditionVOs() {
		return eesEqr0060ConditionVOs;
	}

	public void setEesEqr0060ConditionVOs(EesEqr0060ConditionVO[] eesEqr0060ConditionVOs) {
		this.eesEqr0060ConditionVOs = eesEqr0060ConditionVOs;
	}

}