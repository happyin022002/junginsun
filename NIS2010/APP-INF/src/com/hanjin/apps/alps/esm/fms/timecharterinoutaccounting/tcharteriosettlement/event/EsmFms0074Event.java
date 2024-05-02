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
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.event;

import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.CondSearchPrepaymentSettleVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.CondSearchPrepaymentSettleVvdVO;


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
			CondSearchPrepaymentSettleVO[] tmpVOs = Arrays.copyOf(condSearchPrepaymentSettleVOs, condSearchPrepaymentSettleVOs.length);
			this.condSearchPrepaymentSettleVOs = tmpVOs;
		}
	}

	public void setCondSearchPrepaymentSettleVvdVO(CondSearchPrepaymentSettleVvdVO condSearchPrepaymentSettleVvdVO){
		this. condSearchPrepaymentSettleVvdVO = condSearchPrepaymentSettleVvdVO;
	}

	public void setCondSearchPrepaymentSettleVvdVOS(CondSearchPrepaymentSettleVvdVO[] condSearchPrepaymentSettleVvdVOs){
		if (condSearchPrepaymentSettleVvdVOs != null) {
			CondSearchPrepaymentSettleVvdVO[] tmpVOs = Arrays.copyOf(condSearchPrepaymentSettleVvdVOs, condSearchPrepaymentSettleVvdVOs.length);
			this.condSearchPrepaymentSettleVvdVOs = tmpVOs;
		}
	}

	public CondSearchPrepaymentSettleVO getCondSearchPrepaymentSettleVO(){
		return condSearchPrepaymentSettleVO;
	}

	public CondSearchPrepaymentSettleVO[] getCondSearchPrepaymentSettleVOS(){
		CondSearchPrepaymentSettleVO[] rtnVOs = null;
		if (this.condSearchPrepaymentSettleVOs != null) {
			rtnVOs = Arrays.copyOf(condSearchPrepaymentSettleVOs, condSearchPrepaymentSettleVOs.length);
		}
		return rtnVOs;
	}

	public CondSearchPrepaymentSettleVvdVO getCondSearchPrepaymentSettleVvdVO(){
		return condSearchPrepaymentSettleVvdVO;
	}

	public CondSearchPrepaymentSettleVvdVO[] getCondSearchPrepaymentSettleVvdVOS(){
		CondSearchPrepaymentSettleVvdVO[] rtnVOs = null;
		if (this.condSearchPrepaymentSettleVvdVOs != null) {
			rtnVOs = Arrays.copyOf(condSearchPrepaymentSettleVvdVOs, condSearchPrepaymentSettleVvdVOs.length);
		}
		return rtnVOs;
	}

}