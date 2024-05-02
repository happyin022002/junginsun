/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr1012Event.java
*@FileTitle : Forecast Report
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.surplusarea.event;

import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.surplusarea.vo.SurplusAreaVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.surplusarea.vo.PortSurplusAreaConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_1012 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_EQR_1012HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_EQR_1012HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr1012Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PortSurplusAreaConditionVO portSurplusAreaConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public PortSurplusAreaConditionVO[] portSurplusAreaConditionVOs = null;

	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SurplusAreaVO surplusAreaVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public SurplusAreaVO[] surplusAreaVOs = null;

	public EesEqr1012Event(){}
	
	public void setPortSurplusAreaConditionVO(PortSurplusAreaConditionVO portSurplusAreaConditionVO){
		this. portSurplusAreaConditionVO = portSurplusAreaConditionVO;
	}

	public void setPortSurplusAreaConditionVOS(PortSurplusAreaConditionVO[] portSurplusAreaConditionVOs){
		this. portSurplusAreaConditionVOs = portSurplusAreaConditionVOs;
	}
	public PortSurplusAreaConditionVO getPortSurplusAreaConditionVO(){
		return portSurplusAreaConditionVO;
	}

	public PortSurplusAreaConditionVO[] getPortSurplusAreaConditionVOS(){
		return portSurplusAreaConditionVOs;
	}
	
	
	public void setSurplusAreaVO(SurplusAreaVO surplusAreaVO){
		this. surplusAreaVO = surplusAreaVO;
	}

	public void setSurplusAreaVOS(SurplusAreaVO[] surplusAreaVOs){
		this. surplusAreaVOs = surplusAreaVOs;
	}
	public SurplusAreaVO getSurplusAreaVO(){
		return surplusAreaVO;
	}

	public SurplusAreaVO[] getSurplusAreaVOS(){
		return surplusAreaVOs;
	}
}