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
package com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.MstCntrPreStsVO;
import com.clt.syscommon.common.table.MstCntrStsVO;

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
	private MstCntrStsVO[] mstCntrStsVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private MstCntrPreStsVO[] mstCntrPreStsVOs = null;

	public EesMst0001Event(){}

	public MstCntrPreStsVO[] getMstCntrPreStsVOs() {
		MstCntrPreStsVO[] tmpVOs = null;
		  if (this.mstCntrPreStsVOs != null) {
		   tmpVOs = new MstCntrPreStsVO[mstCntrPreStsVOs.length];
		   System.arraycopy(mstCntrPreStsVOs, 0, tmpVOs, 0, tmpVOs.length);
		  }
		  return tmpVOs;

	}

	public void setMstCntrPreStsVOs(MstCntrPreStsVO[] mstCntrPreStsVOs) {
		  if (mstCntrPreStsVOs != null) {
			  MstCntrPreStsVO[] tmpVOs = new MstCntrPreStsVO[mstCntrPreStsVOs.length];
			   System.arraycopy(mstCntrPreStsVOs, 0, tmpVOs, 0, tmpVOs.length);
			   this.mstCntrPreStsVOs = tmpVOs;
			  }

	}

	public void setMstCntrStsVO(MstCntrStsVO mstCntrStsVO){
		this. mstCntrStsVO = mstCntrStsVO;
	}

	public void setMstCntrStsVOS(MstCntrStsVO[] mstCntrStsVOs){
		  if (mstCntrStsVOs != null) {
			  MstCntrStsVO[] tmpVOs = new MstCntrStsVO[mstCntrStsVOs.length];
			   System.arraycopy(mstCntrStsVOs, 0, tmpVOs, 0, tmpVOs.length);
			   this.mstCntrStsVOs = tmpVOs;
			  }

	}

	public MstCntrStsVO getMstCntrStsVO(){
		return mstCntrStsVO;
	}

	public MstCntrStsVO[] getMstCntrStsVOS(){
		MstCntrStsVO[] tmpVOs = null;
		  if (this.mstCntrStsVOs != null) {
		   tmpVOs = new MstCntrStsVO[mstCntrStsVOs.length];
		   System.arraycopy(mstCntrStsVOs, 0, tmpVOs, 0, tmpVOs.length);
		  }
		  return tmpVOs;

	}

}