/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0074Event.java
*@FileTitle : Prepayments Settlement / Window
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.07.22 윤세영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriosettlement.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.CondSearchPrepaymentSettleVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.CondSearchPrepaymentSettleVvdVO;


/**
 * ESM_FMS_0074 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0074HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yoon, Seyeong
 * @see ESM_FMS_0074HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmFms0074Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CondSearchPrepaymentSettleVO condSearchPrepaymentSettleVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CondSearchPrepaymentSettleVO[] condSearchPrepaymentSettleVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CondSearchPrepaymentSettleVvdVO condSearchPrepaymentSettleVvdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CondSearchPrepaymentSettleVvdVO[] condSearchPrepaymentSettleVvdVOs = null;

	public EsmFms0074Event(){}
	
	public void setCondSearchPrepaymentSettleVO(CondSearchPrepaymentSettleVO condSearchPrepaymentSettleVO){
		this. condSearchPrepaymentSettleVO = condSearchPrepaymentSettleVO;
	}

	public void setCondSearchPrepaymentSettleVOS(CondSearchPrepaymentSettleVO[] condSearchPrepaymentSettleVOs){
		if (condSearchPrepaymentSettleVOs != null) {
			CondSearchPrepaymentSettleVO[] tmpVOs = new CondSearchPrepaymentSettleVO[condSearchPrepaymentSettleVOs.length];
			System.arraycopy(condSearchPrepaymentSettleVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.condSearchPrepaymentSettleVOs = tmpVOs;
		}
	}

	public void setCondSearchPrepaymentSettleVvdVO(CondSearchPrepaymentSettleVvdVO condSearchPrepaymentSettleVvdVO){
		this. condSearchPrepaymentSettleVvdVO = condSearchPrepaymentSettleVvdVO;
	}

	public void setCondSearchPrepaymentSettleVvdVOS(CondSearchPrepaymentSettleVvdVO[] condSearchPrepaymentSettleVvdVOs){
		if (condSearchPrepaymentSettleVvdVOs != null) {
			CondSearchPrepaymentSettleVvdVO[] tmpVOs = new CondSearchPrepaymentSettleVvdVO[condSearchPrepaymentSettleVvdVOs.length];
			System.arraycopy(condSearchPrepaymentSettleVvdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.condSearchPrepaymentSettleVvdVOs = tmpVOs;
		}
	}

	public CondSearchPrepaymentSettleVO getCondSearchPrepaymentSettleVO(){
		return condSearchPrepaymentSettleVO;
	}

	public CondSearchPrepaymentSettleVO[] getCondSearchPrepaymentSettleVOS(){
		CondSearchPrepaymentSettleVO[] tmpVOs = null;
		if (this.condSearchPrepaymentSettleVOs != null) {
			tmpVOs = new CondSearchPrepaymentSettleVO[condSearchPrepaymentSettleVOs.length];
			System.arraycopy(condSearchPrepaymentSettleVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public CondSearchPrepaymentSettleVvdVO getCondSearchPrepaymentSettleVvdVO(){
		return condSearchPrepaymentSettleVvdVO;
	}

	public CondSearchPrepaymentSettleVvdVO[] getCondSearchPrepaymentSettleVvdVOS(){
		CondSearchPrepaymentSettleVvdVO[] tmpVOs = null;
		if (this.condSearchPrepaymentSettleVvdVOs != null) {
			tmpVOs = new CondSearchPrepaymentSettleVvdVO[condSearchPrepaymentSettleVvdVOs.length];
			System.arraycopy(condSearchPrepaymentSettleVvdVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}