/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm2084Event.java
*@FileTitle : MGSet Inventory List(Popup)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.07.13 김창식
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.event;

import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryDtlINVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_2084 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_2084HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM CHANG SIK
 * @see EES_CGM_2084HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesCgm2084Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MGSInventoryDtlINVO mgsInventoryDtlINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MGSInventoryDtlINVO[] mgsInventoryDtlINVOS = null;

	public EesCgm2084Event(){}

	public MGSInventoryDtlINVO getMgsInventoryDtlINVO() {
		return mgsInventoryDtlINVO;
	}

	public void setMgsInventoryDtlINVO(MGSInventoryDtlINVO mgsInventoryDtlINVO) {
		this.mgsInventoryDtlINVO = mgsInventoryDtlINVO;
	}

	public MGSInventoryDtlINVO[] getMgsInventoryDtlINVOS() {
		MGSInventoryDtlINVO[] rtnVOs = null;
		if (this.mgsInventoryDtlINVOS != null) {
			rtnVOs = java.util.Arrays.copyOf(mgsInventoryDtlINVOS, mgsInventoryDtlINVOS.length);
		}
		return rtnVOs;
	}

	public void setMgsInventoryDtlINVOS(MGSInventoryDtlINVO[] mgsInventoryDtlINVOS){
		if(mgsInventoryDtlINVOS != null){
			MGSInventoryDtlINVO[] tmpVOs = java.util.Arrays.copyOf(mgsInventoryDtlINVOS, mgsInventoryDtlINVOS.length);
			this.mgsInventoryDtlINVOS = tmpVOs;
		}
	}

	
}
