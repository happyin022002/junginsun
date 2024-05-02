/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMst0001Event.java
*@FileTitle : Equipment Status Code Creation, Update & Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 김석준
*@LastVersion : 1.0
* 2009.05.06 김석준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MstCntrStsVO;
import com.hanjin.syscommon.common.table.MstCntrPreStsVO;

/**
 * EES_MST_0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MST_0001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Suk Jun Kim
 * @see EES_MST_0001HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesMst0001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MstCntrStsVO mstCntrStsVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public MstCntrStsVO[] mstCntrStsVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	public MstCntrPreStsVO[] mstCntrPreStsVOs = null;

	public EesMst0001Event(){}

	public MstCntrPreStsVO[] getMstCntrPreStsVOs() {
		return mstCntrPreStsVOs;
	}

	public void setMstCntrPreStsVOs(MstCntrPreStsVO[] mstCntrPreStsVOs) {
		this.mstCntrPreStsVOs = mstCntrPreStsVOs;
	}

	public void setMstCntrStsVO(MstCntrStsVO mstCntrStsVO){
		this. mstCntrStsVO = mstCntrStsVO;
	}

	public void setMstCntrStsVOS(MstCntrStsVO[] mstCntrStsVOs){
		this. mstCntrStsVOs = mstCntrStsVOs;
	}

	public MstCntrStsVO getMstCntrStsVO(){
		return mstCntrStsVO;
	}

	public MstCntrStsVO[] getMstCntrStsVOS(){
		return mstCntrStsVOs;
	}

}