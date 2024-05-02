/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr1074Event.java
*@FileTitle : Forecast Report
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrfcstsimul.surplusarea.event;

import com.clt.apps.opus.ees.eqr.cntrfcstsimul.surplusarea.vo.SurplusAreaConditionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_1074 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_EQR_1074HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_EQR_1074HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr1074Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SurplusAreaConditionVO surplusAreaConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SurplusAreaConditionVO[] surplusAreaConditionVOs = null;

	public EesEqr1074Event(){}
	
	public void setSurplusAreaConditionVO(SurplusAreaConditionVO surplusAreaConditionVO){
		this. surplusAreaConditionVO = surplusAreaConditionVO;
	}

	public void setSurplusAreaConditionVOS(SurplusAreaConditionVO[] surplusAreaConditionVOs){
		if (surplusAreaConditionVOs != null) {
			SurplusAreaConditionVO[] tmpVOs = new SurplusAreaConditionVO[surplusAreaConditionVOs.length];
			System.arraycopy(surplusAreaConditionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.surplusAreaConditionVOs = tmpVOs;
		}
	}
	public SurplusAreaConditionVO getSurplusAreaConditionVO(){
		return surplusAreaConditionVO;
	}

	public SurplusAreaConditionVO[] getSurplusAreaConditionVOS(){
		SurplusAreaConditionVO[] tmpVOs = null;
		if (this.surplusAreaConditionVOs != null) {
			tmpVOs = new SurplusAreaConditionVO[surplusAreaConditionVOs.length];
			System.arraycopy(surplusAreaConditionVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
}