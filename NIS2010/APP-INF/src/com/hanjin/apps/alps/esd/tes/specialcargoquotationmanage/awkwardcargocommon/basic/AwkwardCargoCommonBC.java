/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : AwkwardCargoCommonBC.java
*@FileTitle : TES의 Awkward Cargo 공용 작업
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2013-03-21
=========================================================*/
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargocommon.basic;

import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

import com.hanjin.syscommon.common.table.TesActCostHdrVO;
import com.hanjin.syscommon.common.table.TesAwkCgoErrLogVO;


/**
 * ALPS-ESD Business Logic Command Interface<br>
 * - ALPS-ESD에 대한 비지니스 로직에 대한 인터페이스<br> 
 *
 * @author 
 * @see ApprovalStepSendBCImpl 참조
 * @since J2EE 1.4
 */
public interface AwkwardCargoCommonBC  {
	
	/* AWK COMM ERR TP */
	static final String AWK_CGO_ERR_TP_BATCH	= "BA";
	static final String AWK_CGO_ERR_TP_CALC		= "AC";
	static final String AWK_CGO_ERR_TP_COND		= "CP";
	static final String AWK_CGO_ERR_TP_ETC		= "EC";

	/**
	 * Awk Cargo 공통 Error 남기기
	 * @param actCostErrLogVO
	 * @throws EventException
	 */
	public void logAwkCgoCommErrMsg(TesAwkCgoErrLogVO actCostErrLogVO) throws EventException; 
	
}