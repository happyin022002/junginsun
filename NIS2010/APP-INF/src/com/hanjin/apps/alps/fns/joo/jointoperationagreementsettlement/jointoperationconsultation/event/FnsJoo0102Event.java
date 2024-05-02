/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0099Event.java
*@FileTitle : GW Contract Link
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.08
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2014.12.08 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.JooSettlementVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CmbConditionVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CombinedVO;


/**
 * FNS_JOO_0102 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0102HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Young Du
 * @see FNS_JOO_0102HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0102Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private CmbConditionVO cmbConditionVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CombinedVO combinedVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CombinedVO[] combinedVOs = null;
	
	public FnsJoo0102Event(){}
	
	public void setCombinedVO(CombinedVO combinedVO){
		this. combinedVO = combinedVO;
	}

	public void setCombinedVOS(CombinedVO[] combinedVOs){
		if (combinedVOs != null) {
			CombinedVO[] tmpVOs = new CombinedVO[combinedVOs.length];
			System.arraycopy(combinedVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.combinedVOs = tmpVOs;
		}		
	}

	public CombinedVO getCombinedVO(){
		return combinedVO;
	}

	public CombinedVO[] getCombinedVOS(){
		CombinedVO[] rtnVOs = null;
		if (this.combinedVOs != null) {
			rtnVOs = new CombinedVO[combinedVOs.length];
			System.arraycopy(combinedVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}

	public CmbConditionVO getCmbConditionVO() {
		return cmbConditionVO;
	}

	public void setCmbConditionVO(CmbConditionVO cmbConditionVO) {
		this.cmbConditionVO = cmbConditionVO;
	}
}