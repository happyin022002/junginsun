/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0045Event.java
*@FileTitle : Adjustment Slot Hire
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.07.20 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.AdjustConditionVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.AdjustSettlementVO;


/**
 * FNS_JOO_0045 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0045HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Hee Dong
 * @see FNS_JOO_0045HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0045Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private AdjustConditionVO adjustConditionVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AdjustSettlementVO adjustSettlementVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private AdjustSettlementVO[] adjustSettlementVOs = null;

	public FnsJoo0045Event(){}
	
	public AdjustConditionVO getAdjustConditionVO() {
		return adjustConditionVO;
	}

	public void setAdjustConditionVO(AdjustConditionVO adjustConditionVO) {
		this.adjustConditionVO = adjustConditionVO;
	}

	public void setAdjustSettlementVO(AdjustSettlementVO adjustSettlementVO){
		this. adjustSettlementVO = adjustSettlementVO;				
	}

	public void setAdjustSettlementVOS(AdjustSettlementVO[] adjustSettlementVOs){
		if (adjustSettlementVOs != null) {
			AdjustSettlementVO[] tmpVOs = new AdjustSettlementVO[adjustSettlementVOs.length];
			System.arraycopy(adjustSettlementVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.adjustSettlementVOs = tmpVOs;
		}		
	}

	public AdjustSettlementVO getAdjustSettlementVO(){
		return adjustSettlementVO;
	}

	public AdjustSettlementVO[] getAdjustSettlementVOS(){
		AdjustSettlementVO[] rtnVOs = null;
		if (this.adjustSettlementVOs != null) {
			rtnVOs = new AdjustSettlementVO[adjustSettlementVOs.length];
			System.arraycopy(adjustSettlementVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}

}