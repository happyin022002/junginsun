/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0002Event.java
*@FileTitle : Inquire Scenario ID List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.07.22 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.event;

import com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.vo.EesEqr0002ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.EqrScnrMstVO;


/**
 * EES_EQR_0002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Haeng-ji,Lee
 * @see EES_EQR_0002HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0002Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EqrScnrMstVO eqrScnrMstVO = null;
	private EesEqr0002ConditionVO eesEqr0002ConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EqrScnrMstVO[] eqrScnrMstVOs = null;
	private String scnrid =  null;

	public EesEqr0002Event(){}
	
	public void setEqrScnrMstVO(EqrScnrMstVO eqrScnrMstVO){
		this. eqrScnrMstVO = eqrScnrMstVO;
	}

	public void setEqrScnrMstVOS(EqrScnrMstVO[] eqrScnrMstVOs){
		this. eqrScnrMstVOs = eqrScnrMstVOs;
	}

	public EqrScnrMstVO getEqrScnrMstVO(){
		return eqrScnrMstVO;
	}

	public EqrScnrMstVO[] getEqrScnrMstVOS(){
		return eqrScnrMstVOs;
	}
	
	public EesEqr0002ConditionVO getEesEqr0002ConditionVO() {
		return eesEqr0002ConditionVO;
	}

	public void setEesEqr0002ConditionVO(EesEqr0002ConditionVO eesEqr0002ConditionVO) {
		this.eesEqr0002ConditionVO = eesEqr0002ConditionVO;
	}
	
	public String getScnrid() {
		return scnrid;
	}

	public void setScnrid(String scnrid) {
		this.scnrid = scnrid;
	}
}