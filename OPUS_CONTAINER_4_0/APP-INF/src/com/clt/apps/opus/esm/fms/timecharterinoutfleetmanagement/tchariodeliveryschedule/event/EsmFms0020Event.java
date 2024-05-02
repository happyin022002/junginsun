/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0082Event.java
*@FileTitle : Ship Yard Select – Pop up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.20
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.04.20 최우석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.event;

import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.vo.CondDeliveryScheduleVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0020 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0020HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Woo-Seok
 * @see ESM_FMS_0020HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmFms0020Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CondDeliveryScheduleVO condDeliveryScheduleVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CondDeliveryScheduleVO[] condDeliveryScheduleVOs = null;
	
	public EsmFms0020Event(){}
	
	public void setCondDeliveryScheduleVO(CondDeliveryScheduleVO condDeliveryScheduleVO){
		this. condDeliveryScheduleVO = condDeliveryScheduleVO;
	}

	public void setCondDeliveryScheduleVOS(CondDeliveryScheduleVO[] condDeliveryScheduleVOs){
		if (condDeliveryScheduleVOs != null) {
			CondDeliveryScheduleVO[] tmpVOs = new CondDeliveryScheduleVO[condDeliveryScheduleVOs.length];
			System.arraycopy(condDeliveryScheduleVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.condDeliveryScheduleVOs = tmpVOs;
		}
	}

	public CondDeliveryScheduleVO getCondDeliveryScheduleVO(){
		return condDeliveryScheduleVO;
	}

	public CondDeliveryScheduleVO[] getCondDeliveryScheduleVOS(){
		CondDeliveryScheduleVO[] tmpVOs = null;
		if (this.condDeliveryScheduleVOs != null) {
			tmpVOs = new CondDeliveryScheduleVO[condDeliveryScheduleVOs.length];
			System.arraycopy(condDeliveryScheduleVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
}