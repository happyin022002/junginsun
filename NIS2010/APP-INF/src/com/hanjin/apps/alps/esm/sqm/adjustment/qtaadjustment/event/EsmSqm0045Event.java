/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0045Event.java
*@FileTitle      : QTA Edit_Office Add
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.12.10
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.12.10 SQM USER
* 1.0 Creation
* 2013.12.10 PEJ [CHM-201328059] QTA Edit_Office Add 팝업 추가
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.event;

import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.SearchLaneOfficeListVO;
import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SqmQtaLaneOfcVO;

/**
 * ESM_SQM_0045 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_SQM_0045HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SQM USER
 * @see ESM_SQM_0045HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0045Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ConditionVO conditionVO = null;

	public EsmSqm0045Event(){}

	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}

	public ConditionVO getConditionVO(){
		return conditionVO;
	}
	
	/** Table Value Object Multi Data 처리 */
	private SearchLaneOfficeListVO[] searchLaneOfficeListVOs = null;
	
	public void setSearchLaneOfficeListVOS(SearchLaneOfficeListVO[] searchLaneOfficeListVOs){
		this. searchLaneOfficeListVOs = searchLaneOfficeListVOs;
	}
	
	public SearchLaneOfficeListVO[] getSearchLaneOfficeListVOS(){
		return searchLaneOfficeListVOs;
	}
	
	/** Lane Office Relation setting 의 상태를 변경하기 위해서*/
	private SqmQtaLaneOfcVO[] sqmQtaLaneOfcVOs = null;
	
	public void setSqmQtaLaneOfcVOS(SqmQtaLaneOfcVO[] sqmQtaLaneOfcVOs){
		this. sqmQtaLaneOfcVOs = sqmQtaLaneOfcVOs;
	}
	
	public SqmQtaLaneOfcVO[] getSqmQtaLaneOfcVOS(){
		return sqmQtaLaneOfcVOs;
	}

	
//	SqmQtaLaneOfcVO
}