/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmCsq0011Event.java
*@FileTitle      : Target VVD Fix_Disable Pop up
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.08
*@LastModifier   : JEONGMIN CHO
*@LastVersion    : 1.0
* 2013.05.08 JEONGMIN CHO
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.basicdata.event;

import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.apps.opus.esm.csq.datamanage.basicdata.vo.SearchTargerVvdFixListVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_CSQ_0011 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_CSQ_0011HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JEONGMIN CHO
 * @see ESM_CSQ_0011HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCsq0011Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchTargerVvdFixListVO searchTargerVvdFixListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchTargerVvdFixListVO[] searchTargerVvdFixListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ConditionVO conditionVO = null;
	
	public EsmCsq0011Event(){}
	
	public void setSearchTargerVvdFixListVO(SearchTargerVvdFixListVO searchTargerVvdFixListVO){
		this. searchTargerVvdFixListVO = searchTargerVvdFixListVO;
	}

	public void setSearchTargerVvdFixListVOS(SearchTargerVvdFixListVO[] searchTargerVvdFixListVOs){
		this. searchTargerVvdFixListVOs = searchTargerVvdFixListVOs;
	}

	public SearchTargerVvdFixListVO getSearchTargerVvdFixListVO(){
		return searchTargerVvdFixListVO;
	}

	public SearchTargerVvdFixListVO[] getSearchTargerVvdFixListVOS(){
		return searchTargerVvdFixListVOs;
	}
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
	

}