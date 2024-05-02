/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0135Event.java
*@FileTitle : 이송계획 및 비용 상세 비교 조회
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.10.12 정은호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplancompare.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplancompare.vo.EesEqr0135ConditionVO;


/**
 * EES_EQR_0135 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0135HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author ChungEunHo
 * @see EES_EQR_0135HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0135Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr0135ConditionVO eesEqr0135ConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EesEqr0135ConditionVO[] eesEqr0135ConditionVOs = null;

	public EesEqr0135Event(){}
	
	public void setEesEqr0135ConditionVO(EesEqr0135ConditionVO eesEqr0135ConditionVO){
		this. eesEqr0135ConditionVO = eesEqr0135ConditionVO;
	}

	public void setEesEqr0135ConditionVOS(EesEqr0135ConditionVO[] eesEqr0135ConditionVOs){
		this. eesEqr0135ConditionVOs = eesEqr0135ConditionVOs;
	}

	public EesEqr0135ConditionVO getEesEqr0135ConditionVO(){
		return eesEqr0135ConditionVO;
	}

	public EesEqr0135ConditionVO[] getEesEqr0135ConditionVOS(){
		return eesEqr0135ConditionVOs;
	}

}