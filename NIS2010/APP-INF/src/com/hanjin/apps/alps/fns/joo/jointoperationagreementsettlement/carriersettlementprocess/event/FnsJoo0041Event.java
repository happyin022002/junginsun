/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0041Event.java
*@FileTitle : Slot Exchange Status by Lane & Partner->Space On Partner
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.19
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.08.19 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.SlotXchPartnerVO;


/**
 * FNS_JOO_0041 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0041HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see FNS_JOO_0041HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0041Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SlotXchPartnerVO slotXchPartnerVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SlotXchPartnerVO[] slotXchPartnerVOs = null;

	public FnsJoo0041Event(){}
	
	public void setSlotXchPartnerVO(SlotXchPartnerVO slotXchPartnerVO){
		this. slotXchPartnerVO = slotXchPartnerVO;
	}

	public void setSlotXchPartnerVOS(SlotXchPartnerVO[] slotXchPartnerVOs){
		if (slotXchPartnerVOs != null) {
			SlotXchPartnerVO[] tmpVOs = new SlotXchPartnerVO[slotXchPartnerVOs.length];
			System.arraycopy(slotXchPartnerVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.slotXchPartnerVOs = tmpVOs;
		}		
	}

	public SlotXchPartnerVO getSlotXchPartnerVO(){
		return slotXchPartnerVO;
	}

	public SlotXchPartnerVO[] getSlotXchPartnerVOS(){
		SlotXchPartnerVO[] rtnVOs = null;
		if (this.slotXchPartnerVOs != null) {
			rtnVOs = new SlotXchPartnerVO[slotXchPartnerVOs.length];
			System.arraycopy(slotXchPartnerVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}

}