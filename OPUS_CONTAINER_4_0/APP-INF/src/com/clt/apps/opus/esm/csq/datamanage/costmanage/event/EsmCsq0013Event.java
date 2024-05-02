/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmCsq0013Event.java
*@FileTitle      : Basic CMCB (CM Cost Per Box)
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.03
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2013.05.03 CSQ USER
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.costmanage.event;

import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.CsqQtaLaneOfcCostVO;

/**
 * ESM_CSQ_0013 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_CSQ_0013HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CSQ USER
 * @see ESM_CSQ_0013HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCsq0013Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmCsq0013Event(){}
	
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CsqQtaLaneOfcCostVO csqQtaLaneOfcCostVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CsqQtaLaneOfcCostVO[] csqQtaLaneOfcCostVOs = null;
	
	public void setCsqQtaLaneOfcCostVO(CsqQtaLaneOfcCostVO csqQtaLaneOfcCostVO){
		this. csqQtaLaneOfcCostVO = csqQtaLaneOfcCostVO;
	}

	public void setCsqQtaLaneOfcCostVOS(CsqQtaLaneOfcCostVO[] csqQtaLaneOfcCostVOs){
		this. csqQtaLaneOfcCostVOs = csqQtaLaneOfcCostVOs;
	}

	public CsqQtaLaneOfcCostVO getCsqQtaLaneOfcCostVO(){
		return csqQtaLaneOfcCostVO;
	}

	public CsqQtaLaneOfcCostVO[] getCsqQtaLaneOfcCostVOS(){
		return csqQtaLaneOfcCostVOs;
	}
}