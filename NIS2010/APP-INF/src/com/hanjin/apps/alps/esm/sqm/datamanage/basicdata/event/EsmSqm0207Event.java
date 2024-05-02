/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0207Event.java
*@FileTitle      : Basic Data Creation for IAS Sector
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.01.07
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2014.01.07 SQM USER
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.event;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SqmSctrPerfIfVO;

/**
 * ESM_SQM_0207 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_SQM_0207HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SQM USER
 * @see ESM_SQM_0207HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0207Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmSqm0207Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SqmSctrPerfIfVO sqmSctrPerfIfVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SqmSctrPerfIfVO[] sqmSctrPerfIfVOs = null;

	private ConditionVO conditionVO = null;
	
	
	/**
	 * @return the sqmSctrPerfIfVO
	 */
	public SqmSctrPerfIfVO getSqmSctrPerfIfVO() {
		return sqmSctrPerfIfVO;
	}

	/**
	 * @param sqmSctrPerfIfVO the sqmSctrPerfIfVO to set
	 */
	public void setSqmSctrPerfIfVO(SqmSctrPerfIfVO sqmSctrPerfIfVO) {
		this.sqmSctrPerfIfVO = sqmSctrPerfIfVO;
	}

	/**
	 * @return the sqmSctrPerfIfVOs
	 */
	public SqmSctrPerfIfVO[] getSqmSctrPerfIfVOs() {
		return sqmSctrPerfIfVOs;
	}

	/**
	 * @param sqmSctrPerfIfVOs the sqmSctrPerfIfVOs to set
	 */
	public void setSqmSctrPerfIfVOs(SqmSctrPerfIfVO[] sqmSctrPerfIfVOs) {
		this.sqmSctrPerfIfVOs = sqmSctrPerfIfVOs;
	}

	/**
	 * @param conditionVO
	 */
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	/**
	 * @return ConditionVO
	 */
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
}