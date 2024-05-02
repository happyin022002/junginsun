/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FnsJoo0096Event.java
*@FileTitle : Additional Slot Sales / Purchase History
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.13
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2010.12.13 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event;

import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.AdditionalSlotManageVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_JOO_0096 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0096HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIL JeongKwon
 * @see FNS_JOO_0096HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0096Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AdditionalSlotManageVO additionalSlotManageVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private AdditionalSlotManageVO[] additionalSlotManageVOs = null;

	public FnsJoo0096Event(){}

	public AdditionalSlotManageVO getAdditionalSlotManageVO() {
		return additionalSlotManageVO;
	}

	public void setAdditionalSlotManageVO(AdditionalSlotManageVO additionalSlotManageVO) {
		this.additionalSlotManageVO = additionalSlotManageVO;
	}

	public AdditionalSlotManageVO[] getAdditionalSlotManageVOs() {
		AdditionalSlotManageVO[] rtnVOs = null;
		if (this.additionalSlotManageVOs != null) {
			rtnVOs = new AdditionalSlotManageVO[additionalSlotManageVOs.length];
			System.arraycopy(additionalSlotManageVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;						
	}

	public void setAdditionalSlotManageVOs(
			AdditionalSlotManageVO[] additionalSlotManageVOs) {		
		if (additionalSlotManageVOs != null) {
			AdditionalSlotManageVO[] tmpVOs = new AdditionalSlotManageVO[additionalSlotManageVOs.length];
			System.arraycopy(additionalSlotManageVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.additionalSlotManageVOs = tmpVOs;
		}						
	}
}