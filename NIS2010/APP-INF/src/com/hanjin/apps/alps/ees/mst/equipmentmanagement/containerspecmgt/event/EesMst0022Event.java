/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMst0022Event.java
*@FileTitle : Container Specification Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 김석준
*@LastVersion : 1.0
* 2009.05.11 김석준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.vo.CntrSpecListBrieflyVO;


/**
 * EES_MST_0022 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MST_0022HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Suk Jun Kim
 * @see EES_MST_0022HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesMst0022Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CntrSpecListBrieflyVO mstCntrSpecVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public CntrSpecListBrieflyVO[] mstCntrSpecVOs = null;

	public EesMst0022Event(){}
	
	public void setMstCntrSpecVO(CntrSpecListBrieflyVO mstCntrSpecVO){
		this. mstCntrSpecVO = mstCntrSpecVO;
	}

	public void setMstCntrSpecVOS(CntrSpecListBrieflyVO[] mstCntrSpecVOs){
		this. mstCntrSpecVOs = mstCntrSpecVOs;
	}

	public CntrSpecListBrieflyVO getMstCntrSpecVO(){
		return mstCntrSpecVO;
	}

	public CntrSpecListBrieflyVO[] getMstCntrSpecVOS(){
		return mstCntrSpecVOs;
	}

}