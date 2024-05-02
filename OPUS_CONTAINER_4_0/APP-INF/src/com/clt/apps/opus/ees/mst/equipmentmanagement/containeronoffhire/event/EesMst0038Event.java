/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMst0038Event.java
*@FileTitle : Lot No Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.17
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.06.17 민정호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.event;

import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.MstEtcVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EES_MST_0038 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MST_0038HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Ho Min
 * @see EES_MST_0038HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMst0038Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MstEtcVO mstEtcVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MstEtcVO[] mstEtcVOs = null;

	public EesMst0038Event(){}
	
	public void setMstEtcVO(MstEtcVO mstEtcVO){
		this. mstEtcVO = mstEtcVO;
	}

	public void setMstEtcVOS(MstEtcVO[] mstEtcVOs){
		  if (mstEtcVOs != null) {
			  MstEtcVO[] tmpVOs = new MstEtcVO[mstEtcVOs.length];
			   System.arraycopy(mstEtcVOs, 0, tmpVOs, 0, tmpVOs.length);
			   this.mstEtcVOs = tmpVOs;
			  }

	}

	public MstEtcVO getMstEtcVO(){
		return mstEtcVO;
	}

	public MstEtcVO[] getMstEtcVOS(){
		MstEtcVO[] tmpVOs = null;
		  if (this.mstEtcVOs != null) {
		   tmpVOs = new MstEtcVO[mstEtcVOs.length];
		   System.arraycopy(mstEtcVOs, 0, tmpVOs, 0, tmpVOs.length);
		  }
		  return tmpVOs;

	}

}