/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0016Event.java
*@FileTitle : Combined Monthly Clearance Creation & Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.07.23 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.JooSettlementVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CmbConditionVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CombinedVO;


/**
 * FNS_JOO_0016 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0016HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Hee Dong
 * @see FNS_JOO_0016HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0016Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private CmbConditionVO cmbConditionVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CombinedVO combinedVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CombinedVO[] combinedVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private JooSettlementVO jooSettlementVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private JooSettlementVO[] jooSettlementVOs = null;

	public FnsJoo0016Event(){}
	
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

	public JooSettlementVO getJooSettlementVO() {
		return jooSettlementVO;
	}

	public void setJooSettlementVO(JooSettlementVO jooSettlementVO) {
		this.jooSettlementVO = jooSettlementVO;
	}

	public JooSettlementVO[] getjooSettlementVOs() {
		JooSettlementVO[] rtnVOs = null;
		if (this.jooSettlementVOs != null) {
			rtnVOs = new JooSettlementVO[jooSettlementVOs.length];
			System.arraycopy(jooSettlementVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}

	public void setjooSettlementVOs(JooSettlementVO[] jooSettlementVOs) {
		if (jooSettlementVOs != null) {
			JooSettlementVO[] tmpVOs = new JooSettlementVO[jooSettlementVOs.length];
			System.arraycopy(jooSettlementVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.jooSettlementVOs = tmpVOs;
		}		
	}

	public CmbConditionVO getCmbConditionVO() {
		return cmbConditionVO;
	}

	public void setCmbConditionVO(CmbConditionVO cmbConditionVO) {
		this.cmbConditionVO = cmbConditionVO;
	}
}