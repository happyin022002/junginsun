/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0085Event.java
*@FileTitle : dailyforecastmanage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.08.21 한상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.event.ESM_SPC_0103HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SpcTeamQtaRtoVO;


/**
 * ESM_SPC_0103 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0103HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Sang Hoon
 * @see ESM_SPC_0103HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0085Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SpcTeamQtaRtoVO spcTeamQtaRtoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SpcTeamQtaRtoVO[] spcTeamQtaRtoVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ConditionVO conditionVO = null;
	
	public EsmSpc0085Event(){}

	/**
	 * @return the spcTeamQtaRtoVO
	 */
	public SpcTeamQtaRtoVO getSpcTeamQtaRtoVO() {
		return spcTeamQtaRtoVO;
	}

	/**
	 * @param spcTeamQtaRtoVO the spcTeamQtaRtoVO to set
	 */
	public void setSpcTeamQtaRtoVO(SpcTeamQtaRtoVO spcTeamQtaRtoVO) {
		this.spcTeamQtaRtoVO = spcTeamQtaRtoVO;
	}

	/**
	 * @return the spcTeamQtaRtoVOs
	 */
	public SpcTeamQtaRtoVO[] getSpcTeamQtaRtoVOs() {
		SpcTeamQtaRtoVO[] rtnVOs = null;
		if (this.spcTeamQtaRtoVOs != null) {
			rtnVOs = new SpcTeamQtaRtoVO[spcTeamQtaRtoVOs.length];
			System.arraycopy(spcTeamQtaRtoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}

	/**
	 * @param spcTeamQtaRtoVOs the spcTeamQtaRtoVOs to set
	 */
	public void setSpcTeamQtaRtoVOs(SpcTeamQtaRtoVO[] spcTeamQtaRtoVOs) {
		if (spcTeamQtaRtoVOs != null) {
			SpcTeamQtaRtoVO[] tmpVOs = new SpcTeamQtaRtoVO[spcTeamQtaRtoVOs.length];
			System.arraycopy(spcTeamQtaRtoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.spcTeamQtaRtoVOs = tmpVOs;
		}
	}

	/**
	 * @return the conditionVO
	 */
	public ConditionVO getConditionVO() {
		return conditionVO;
	}

	/**
	 * @param conditionVO the conditionVO to set
	 */
	public void setConditionVO(ConditionVO conditionVO) {
		this.conditionVO = conditionVO;
	}
	

	
}