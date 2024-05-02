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

import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.vo.CustomShpYdVO;
import com.clt.framework.support.layer.event.EventSupport;


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
			CustomShpYdVO[] tmpVOs = new CustomShpYdVO[customShpYdVOs.length];
			System.arraycopy(customShpYdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.customShpYdVOs = tmpVOs;
		}
	}

	public CustomShpYdVO getCustomShpYdVO(){
		return customShpYdVO;
	}

	public CustomShpYdVO[] getCustomShpYdVOS(){
		CustomShpYdVO[] tmpVOs = null;
		if (this.customShpYdVOs != null) {
			tmpVOs = new CustomShpYdVO[customShpYdVOs.length];
			System.arraycopy(customShpYdVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
}