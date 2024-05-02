/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMst0005Event.java
*@FileTitle : ISO Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 김석준
*@LastVersion : 1.0
* 2009.04.30 김석준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MstIsoCntrTpSzVO;


/**
 * EES_MST_0005 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MST_0005HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Suk Jun Kim
 * @see EES_MST_0005HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesMst0005Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MstIsoCntrTpSzVO mstIsoCntrTpSzVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public MstIsoCntrTpSzVO[] mstIsoCntrTpSzVOs = null;

	public EesMst0005Event(){}
	
	public void setMstIsoCntrTpSzVO(MstIsoCntrTpSzVO mstIsoCntrTpSzVO){
		this. mstIsoCntrTpSzVO = mstIsoCntrTpSzVO;
	}

	public void setMstIsoCntrTpSzVOS(MstIsoCntrTpSzVO[] mstIsoCntrTpSzVOs){
		this. mstIsoCntrTpSzVOs = mstIsoCntrTpSzVOs;
	}

	public MstIsoCntrTpSzVO getMstIsoCntrTpSzVO(){
		return mstIsoCntrTpSzVO;
	}

	public MstIsoCntrTpSzVO[] getMstIsoCntrTpSzVOS(){
		return mstIsoCntrTpSzVOs;
	}

}