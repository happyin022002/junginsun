/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0034Event.java
*@FileTitle      : QTA Edit
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.22
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.22 SQM USER
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.event;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SqmCfmQtaVO;

/**
 * ESM_SQM_0034 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_SQM_0034HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SQM USER
 * @see ESM_SQM_0034HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0034Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SqmCfmQtaVO sqmCfmQtaVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SqmCfmQtaVO[] sqmCfmQtaVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ConditionVO conditionVO = null;

	public EsmSqm0034Event(){}
	
	public void setSqmCfmQtaVO(SqmCfmQtaVO sqmCfmQtaVO){
		this. sqmCfmQtaVO = sqmCfmQtaVO;
	}

	public void setSqmCfmQtaVOS(SqmCfmQtaVO[] sqmCfmQtaVOs){
		this. sqmCfmQtaVOs = sqmCfmQtaVOs;
	}

	public SqmCfmQtaVO getSqmCfmQtaVO(){
		return sqmCfmQtaVO;
	}

	public SqmCfmQtaVO[] getSqmCfmQtaVOS(){
		return sqmCfmQtaVOs;
	}
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}

}