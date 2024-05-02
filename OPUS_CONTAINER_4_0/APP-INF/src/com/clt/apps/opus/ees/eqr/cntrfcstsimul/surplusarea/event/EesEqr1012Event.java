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
package com.clt.apps.opus.ees.eqr.cntrfcstsimul.surplusarea.event;

import com.clt.apps.opus.ees.eqr.cntrfcstsimul.surplusarea.vo.SurplusAreaVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.surplusarea.vo.PortSurplusAreaConditionVO;
import com.clt.framework.support.layer.event.EventSupport;


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
	private PortSurplusAreaConditionVO[] portSurplusAreaConditionVOs = null;

	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SurplusAreaVO surplusAreaVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SurplusAreaVO[] surplusAreaVOs = null;

	public EesEqr1012Event(){}
	
	public void setPortSurplusAreaConditionVO(PortSurplusAreaConditionVO portSurplusAreaConditionVO){
		this. portSurplusAreaConditionVO = portSurplusAreaConditionVO;
	}

	public void setPortSurplusAreaConditionVOS(PortSurplusAreaConditionVO[] portSurplusAreaConditionVOs){
		if (portSurplusAreaConditionVOs != null) {
			PortSurplusAreaConditionVO[] tmpVOs = new PortSurplusAreaConditionVO[portSurplusAreaConditionVOs.length];
			System.arraycopy(portSurplusAreaConditionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.portSurplusAreaConditionVOs = tmpVOs;
		}
	}
	public PortSurplusAreaConditionVO getPortSurplusAreaConditionVO(){
		return portSurplusAreaConditionVO;
	}

	public PortSurplusAreaConditionVO[] getPortSurplusAreaConditionVOS(){
		PortSurplusAreaConditionVO[] tmpVOs = null;
		if (this.portSurplusAreaConditionVOs != null) {
			tmpVOs = new PortSurplusAreaConditionVO[portSurplusAreaConditionVOs.length];
			System.arraycopy(portSurplusAreaConditionVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	
	public void setSurplusAreaVO(SurplusAreaVO surplusAreaVO){
		this. surplusAreaVO = surplusAreaVO;
	}

	public void setSurplusAreaVOS(SurplusAreaVO[] surplusAreaVOs){
		if (surplusAreaVOs != null) {
			SurplusAreaVO[] tmpVOs = new SurplusAreaVO[surplusAreaVOs.length];
			System.arraycopy(surplusAreaVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.surplusAreaVOs = tmpVOs;
		}
	}
	public SurplusAreaVO getSurplusAreaVO(){
		return surplusAreaVO;
	}

	public SurplusAreaVO[] getSurplusAreaVOS(){
		SurplusAreaVO[] tmpVOs = null;
		if (this.surplusAreaVOs != null) {
			tmpVOs = new SurplusAreaVO[surplusAreaVOs.length];
			System.arraycopy(surplusAreaVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
}