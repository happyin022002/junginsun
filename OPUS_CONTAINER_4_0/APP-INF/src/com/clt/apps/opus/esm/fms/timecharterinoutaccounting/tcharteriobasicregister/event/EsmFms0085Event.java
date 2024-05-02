/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0085Event.java
*@FileTitle : E-mail List Registration
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.09.08 최우석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.event;

import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.CustomEmailAddressVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0085 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0085HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author choi, wooseok
 * @see ESM_FMS_0085HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmFms0085Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomEmailAddressVO customEmailAddressVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomEmailAddressVO[] customEmailAddressVOs = null;

	public EsmFms0085Event(){}

	public void setCustomEmailAddressVO(CustomEmailAddressVO customEmailAddressVO){
		this. customEmailAddressVO = customEmailAddressVO;
	}

	public void setCustomEmailAddressVOS(CustomEmailAddressVO[] customEmailAddressVOs){
		if (customEmailAddressVOs != null) {
			CustomEmailAddressVO[] tmpVOs = new CustomEmailAddressVO[customEmailAddressVOs.length];
			System.arraycopy(customEmailAddressVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.customEmailAddressVOs = tmpVOs;
		}
	}

	public CustomEmailAddressVO getCustomEmailAddressVO(){
		return customEmailAddressVO;
	}

	public CustomEmailAddressVO[] getCustomEmailAddressVOS(){
		CustomEmailAddressVO[] tmpVOs = null;
		if (this.customEmailAddressVOs != null) {
			tmpVOs = new CustomEmailAddressVO[customEmailAddressVOs.length];
			System.arraycopy(customEmailAddressVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
}