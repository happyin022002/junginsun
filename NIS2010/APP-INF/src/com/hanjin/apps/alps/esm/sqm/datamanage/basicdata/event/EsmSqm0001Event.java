/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0001Event.java
*@FileTitle      : Basic Data Relation Setting
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.03
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.03 SQM USER
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.event;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SqmDatRltVO;

/**
 * ESM_SQM_0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_SQM_0001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SQM USER
 * @see ESM_SQM_0001HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmSqm0001Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SqmDatRltVO sqmDatRltVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SqmDatRltVO[] sqmDatRltVOs = null;
	
	public void setSqmDatRltVO(SqmDatRltVO sqmDatRltVO){
		this. sqmDatRltVO = sqmDatRltVO;
	}

	public void setSqmDatRltVOS(SqmDatRltVO[] sqmDatRltVOs){
		this. sqmDatRltVOs = sqmDatRltVOs;
	}

	public SqmDatRltVO getSqmDatRltVO(){
		return sqmDatRltVO;
	}

	public SqmDatRltVO[] getSqmDatRltVOS(){
		return sqmDatRltVOs;
	}
	
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
}