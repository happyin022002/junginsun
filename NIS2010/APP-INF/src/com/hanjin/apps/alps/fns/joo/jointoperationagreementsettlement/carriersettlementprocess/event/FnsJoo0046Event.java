/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0046Event.java
*@FileTitle : Adjustment Over Used Slot Hire for RDR
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.10.16 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.AdjustConditionVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.AdjustOusRDRVO;


/**
 * FNS_JOO_0046 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0046HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Hee Dong
 * @see FNS_JOO_0046HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0046Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private AdjustConditionVO adjustConditionVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AdjustOusRDRVO adjustOusRDRVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private AdjustOusRDRVO[] adjustOusRDRVOs = null;

	public FnsJoo0046Event(){}
	
	public AdjustConditionVO getAdjustConditionVO() {
		return adjustConditionVO;
	}

	public void setAdjustConditionVO(AdjustConditionVO adjustConditionVO) {
		this.adjustConditionVO = adjustConditionVO;
	}

	public void setAdjustOusRDRVO(AdjustOusRDRVO adjustOusRDRVO){
		this. adjustOusRDRVO = adjustOusRDRVO;
	}

	public void setAdjustOusRDRVOS(AdjustOusRDRVO[] adjustOusRDRVOs){
		if (adjustOusRDRVOs != null) {
			AdjustOusRDRVO[] tmpVOs = new AdjustOusRDRVO[adjustOusRDRVOs.length];
			System.arraycopy(adjustOusRDRVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.adjustOusRDRVOs = tmpVOs;
		}		
	}

	public AdjustOusRDRVO getAdjustOusRDRVO(){
		return adjustOusRDRVO;
	}

	public AdjustOusRDRVO[] getAdjustOusRDRVOS(){
		AdjustOusRDRVO[] rtnVOs = null;
		if (this.adjustOusRDRVOs != null) {
			rtnVOs = new AdjustOusRDRVO[adjustOusRDRVOs.length];
			System.arraycopy(adjustOusRDRVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}

}