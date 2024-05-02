/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FnsJoo0080Event.java
*@FileTitle : Combined Data Inquery
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.15
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.01.15 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.LostCombinedDataVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.SlipConditionVO;


/**
 * FNS_JOO_0080 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0080HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Hee Dong
 * @see FNS_JOO_0080HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0080Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SlipConditionVO slipConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private LostCombinedDataVO[] lostCombinedDataVOs = null;

	public FnsJoo0080Event(){}

	public SlipConditionVO getSlipConditionVO() {
		return slipConditionVO;
	}

	public void setSlipConditionVO(SlipConditionVO slipConditionVO) {
		this.slipConditionVO = slipConditionVO;
	}

	public LostCombinedDataVO[] getLostCombinedDataVOs() {
		LostCombinedDataVO[] rtnVOs = null;
		if (this.lostCombinedDataVOs != null) {
			rtnVOs = new LostCombinedDataVO[lostCombinedDataVOs.length];
			System.arraycopy(lostCombinedDataVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}

	public void setLostCombinedDataVOs(LostCombinedDataVO[] lostCombinedDataVOs) {
		if (lostCombinedDataVOs != null) {
			LostCombinedDataVO[] tmpVOs = new LostCombinedDataVO[lostCombinedDataVOs.length];
			System.arraycopy(lostCombinedDataVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.lostCombinedDataVOs = tmpVOs;
		}		
	}
}