/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0040Event.java
*@FileTitle : Slot Exchange Status by Lane &amp; Partner->Space Lane
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.08.18 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.SlotXchLaneVO;


/**
 * FNS_JOO_0040 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0040HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see FNS_JOO_0040HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0040Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SlotXchLaneVO slotXchLaneVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SlotXchLaneVO[] slotXchLaneVOs = null;

	public FnsJoo0040Event(){}
	
	public void setSlotXchLaneVO(SlotXchLaneVO slotXchLaneVO){
		this. slotXchLaneVO = slotXchLaneVO;
	}

	public void setSlotXchLaneVOS(SlotXchLaneVO[] slotXchLaneVOs){
		if (slotXchLaneVOs != null) {
			SlotXchLaneVO[] tmpVOs = new SlotXchLaneVO[slotXchLaneVOs.length];
			System.arraycopy(slotXchLaneVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.slotXchLaneVOs = tmpVOs;
		}		
	}

	public SlotXchLaneVO getSlotXchLaneVO(){
		return slotXchLaneVO;
	}

	public SlotXchLaneVO[] getSlotXchLaneVOS(){
		SlotXchLaneVO[] rtnVOs = null;
		if (this.slotXchLaneVOs != null) {
			rtnVOs = new SlotXchLaneVO[slotXchLaneVOs.length];
			System.arraycopy(slotXchLaneVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}

}