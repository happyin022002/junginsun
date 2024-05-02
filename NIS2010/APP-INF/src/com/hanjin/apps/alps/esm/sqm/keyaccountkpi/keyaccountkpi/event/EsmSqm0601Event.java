/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0601Event.java
*@FileTitle      :  KPI Upload
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.07.30
*@LastModifier   : 이혜민
*@LastVersion    : 1.0
* 2013.07.30 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.keyaccountkpi.keyaccountkpi.event;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SqmKeyAcctCfmQtaVO;

/**
 * ESM_SQM_0601 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SQM_0601HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 이혜민
 * @see ESM_SQM_0601HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0601Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmSqm0601Event(){}
	
	
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SqmKeyAcctCfmQtaVO sqmKeyAcctCfmQtaVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SqmKeyAcctCfmQtaVO[] sqmKeyAcctCfmQtaVOs = null;
	
	public void setSqmKeyAcctCfmQtaVO(SqmKeyAcctCfmQtaVO sqmKeyAcctCfmQtaVO){
		this. sqmKeyAcctCfmQtaVO = sqmKeyAcctCfmQtaVO;
	}
	
	public void setSqmKeyAcctCfmQtaVOS(SqmKeyAcctCfmQtaVO[] sqmKeyAcctCfmQtaVOs){
		this. sqmKeyAcctCfmQtaVOs = sqmKeyAcctCfmQtaVOs;
	}
	
	public SqmKeyAcctCfmQtaVO getSqmKeyAcctCfmQtaVO(){
		return sqmKeyAcctCfmQtaVO;
	}
	
	public SqmKeyAcctCfmQtaVO[] getSqmKeyAcctCfmQtaVOS(){
		return sqmKeyAcctCfmQtaVOs;
	}
	
	
	
}