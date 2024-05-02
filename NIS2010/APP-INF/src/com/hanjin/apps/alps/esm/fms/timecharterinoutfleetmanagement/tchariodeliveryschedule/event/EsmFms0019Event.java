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
package com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.vo.CondDeliveryScheduleVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.vo.CustomNewBldSkdVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0019 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0019HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Woo-Seok
 * @see ESM_FMS_0019HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmFms0019Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CondDeliveryScheduleVO condDeliveryScheduleVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CondDeliveryScheduleVO[] condDeliveryScheduleVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomNewBldSkdVO customNewBldSkdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomNewBldSkdVO[] customNewBldSkdVOs = null;
	
	public EsmFms0019Event(){}
	
	public void setCondDeliveryScheduleVO(CondDeliveryScheduleVO condDeliveryScheduleVO){
		this. condDeliveryScheduleVO = condDeliveryScheduleVO;
	}

	public void setCondDeliveryScheduleVOS(CondDeliveryScheduleVO[] condDeliveryScheduleVOs){
		if (condDeliveryScheduleVOs != null) {
			CondDeliveryScheduleVO[] tmpVOs = Arrays.copyOf(condDeliveryScheduleVOs, condDeliveryScheduleVOs.length);
			this.condDeliveryScheduleVOs = tmpVOs;
		}
	}

	public CondDeliveryScheduleVO getCondDeliveryScheduleVO(){
		return condDeliveryScheduleVO;
	}

	public CondDeliveryScheduleVO[] getCondDeliveryScheduleVOS(){
		CondDeliveryScheduleVO[] rtnVOs = null;
		if (this.condDeliveryScheduleVOs != null) {
			rtnVOs = Arrays.copyOf(condDeliveryScheduleVOs, condDeliveryScheduleVOs.length);
		}
		return rtnVOs;
	}
	
	public void setCustomNewBldSkdVO(CustomNewBldSkdVO customNewBldSkdVO){
		this. customNewBldSkdVO = customNewBldSkdVO;
	}

	public void setCustomNewBldSkdVOS(CustomNewBldSkdVO[] customNewBldSkdVOs){
		if (customNewBldSkdVOs != null) {
			CustomNewBldSkdVO[] tmpVOs = Arrays.copyOf(customNewBldSkdVOs, customNewBldSkdVOs.length);
			this.customNewBldSkdVOs = tmpVOs;
		}
	}

	public CustomNewBldSkdVO getCustomNewBldSkdVO(){
		return customNewBldSkdVO;
	}

	public CustomNewBldSkdVO[] getCustomNewBldSkdVOS(){
		CustomNewBldSkdVO[] rtnVOs = null;
		if (this.customNewBldSkdVOs != null) {
			rtnVOs = Arrays.copyOf(customNewBldSkdVOs, customNewBldSkdVOs.length);
		}
		return rtnVOs;
	}
}