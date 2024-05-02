/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmCsq0056Event.java
*@FileTitle      : QTA Edit_Office Add
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.12.10
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2013.12.10 CSQ USER
* 1.0 Creation
* 2013.12.10 PEJ [CHM-201328059] QTA Edit_Office Add 팝업 추가
=========================================================*/
package com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.event;

import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.vo.SearchLaneOfficeListVO;
import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.CsqQtaLaneOfcVO;

/**
 * ESM_CSQ_0056 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_CSQ_0056HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CSQ USER
 * @see ESM_CSQ_0056HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCsq0056Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ConditionVO conditionVO = null;

	public EsmCsq0056Event(){}

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
	private CsqQtaLaneOfcVO[] csqQtaLaneOfcVOs = null;
	
	public void setCsqQtaLaneOfcVOS(CsqQtaLaneOfcVO[] csqQtaLaneOfcVOs){
		this. csqQtaLaneOfcVOs = csqQtaLaneOfcVOs;
	}
	
	public CsqQtaLaneOfcVO[] getCsqQtaLaneOfcVOS(){
		return csqQtaLaneOfcVOs;
	}

	
//	CsqQtaLaneOfcVO
}