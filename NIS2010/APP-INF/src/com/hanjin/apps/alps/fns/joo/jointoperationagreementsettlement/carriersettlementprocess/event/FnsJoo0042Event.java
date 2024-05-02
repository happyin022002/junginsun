/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0042Event.java
*@FileTitle : Slot Exchange Status by Lane & Partner->Finance &amp Lane
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.07.10 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.SlotXchLaneVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_JOO_0042 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0042HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see FNS_JOO_0042HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0042Event extends EventSupport {

	private static final long serialVersionUID = 1L;
 
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SlotXchLaneVO slotXchLaneVO = null;

    /**
     * @return the slotXchLaneVO
     */
    public SlotXchLaneVO getSlotXchLaneVO() {
        return slotXchLaneVO;
    }

    /**
     * @param slotXchLaneVO the slotXchLaneVO to set
     */
    public void setSlotXchLaneVO(SlotXchLaneVO slotXchLaneVO) {
        this.slotXchLaneVO = slotXchLaneVO;
    }
	
 
 
}