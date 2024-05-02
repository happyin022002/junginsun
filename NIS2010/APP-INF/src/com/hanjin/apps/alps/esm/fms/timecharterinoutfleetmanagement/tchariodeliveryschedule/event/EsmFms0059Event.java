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
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.vo.CustomShpYdVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0059 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0059HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Woo-Seok
 * @see ESM_FMS_0059HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmFms0059Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomShpYdVO customShpYdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomShpYdVO[] customShpYdVOs = null;
	
	public EsmFms0059Event(){}
	
	public void setCustomShpYdVO(CustomShpYdVO customShpYdVO){
		this. customShpYdVO = customShpYdVO;
	}

	public void setCustomShpYdVOS(CustomShpYdVO[] customShpYdVOs){
		if (customShpYdVOs != null) {
			CustomShpYdVO[] tmpVOs = Arrays.copyOf(customShpYdVOs, customShpYdVOs.length);
			this.customShpYdVOs = tmpVOs;
		}
	}

	public CustomShpYdVO getCustomShpYdVO(){
		return customShpYdVO;
	}

	public CustomShpYdVO[] getCustomShpYdVOS(){
		CustomShpYdVO[] rtnVOs = null;
		if (this.customShpYdVOs != null) {
			rtnVOs = Arrays.copyOf(customShpYdVOs, customShpYdVOs.length);
		}
		return rtnVOs;
	}
}