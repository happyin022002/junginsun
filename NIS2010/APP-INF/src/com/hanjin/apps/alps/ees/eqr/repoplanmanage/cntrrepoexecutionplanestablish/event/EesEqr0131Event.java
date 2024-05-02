/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0131Event.java
*@FileTitle : Send Fax or e-mail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.09.21 정은호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0131ConditionVO;


/**
 * EES_EQR_0131 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0131HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author ChungEunHo
 * @see EES_EQR_0131HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0131Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr0131ConditionVO eesEqr0131ConditionVO = null;
	

	public EesEqr0131Event(){}
	
	public void setEesEqr0131ConditionVO(EesEqr0131ConditionVO eesEqr0131ConditionVO){
		this. eesEqr0131ConditionVO = eesEqr0131ConditionVO;
	}


	public EesEqr0131ConditionVO getEesEqr0131ConditionVO(){
		return eesEqr0131ConditionVO;
	}

}