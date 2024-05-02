/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr1070Event.java
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
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.surplusarea.vo.SurplusAreaConditionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_1070 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_EQR_1070HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_EQR_1070HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr1070Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SurplusAreaConditionVO surplusAreaConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SurplusAreaConditionVO[] surplusAreaConditionVOs = null;

	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SurplusAreaVO surplusAreaVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SurplusAreaVO[] surplusAreaVOs = null;

	public EesEqr1070Event(){}
	
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