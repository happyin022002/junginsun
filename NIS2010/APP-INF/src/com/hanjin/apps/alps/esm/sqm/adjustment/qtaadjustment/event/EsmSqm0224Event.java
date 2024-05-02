/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName       : EsmSqm0224Event.java
*@FileTitle      : RBCCO PFMC = QTA Setting for IAS Sector
*@Open Issues    :
*@Change history :
*@LastModifyDate : 2014.01.23
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2014.01.23 SQM USER
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.event;

import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.SearchQtaEditListVO;
import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_SQM_0224 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_SQM_0224HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SQM USER
 * @see ESM_SQM_0224HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0224Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public EsmSqm0224Event(){}

	private ConditionVO conditionVO = null;

	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}

	public ConditionVO getConditionVO(){
		return conditionVO;
	}

	/** Table Value Object Multi Data 처리 */
	private SearchQtaEditListVO[] searchQtaEditListVOs = null;

	public void setSearchQtaEditListVOS(SearchQtaEditListVO[] searchQtaEditListVOs){
		this. searchQtaEditListVOs = searchQtaEditListVOs;
	}

	public SearchQtaEditListVO[] getSearchQtaEditListVOS(){
		return searchQtaEditListVOs;
	}

}