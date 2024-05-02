/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1089Event.java
*@FileTitle : General Inventory
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.09
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.07.09 김창식
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.event;

import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryGeneralINVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_1089 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1089HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Eui-su Park
 * @see EES_CGM_1089HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesCgm1089Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSInventoryGeneralINVO chsInventoryGeneralINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CHSInventoryGeneralINVO[] chsInventoryGeneralINVOS = null;

	public EesCgm1089Event(){}

	public CHSInventoryGeneralINVO getChsInventoryGeneralINVO() {
		return chsInventoryGeneralINVO;
	}

	public void setChsInventoryGeneralINVO(
			CHSInventoryGeneralINVO chsInventoryGeneralINVO) {
		this.chsInventoryGeneralINVO = chsInventoryGeneralINVO;
	}

	public CHSInventoryGeneralINVO[] getChsInventoryGeneralINVOS() {
		CHSInventoryGeneralINVO[] rtnVOs = null;
		if (this.chsInventoryGeneralINVOS != null) {
			rtnVOs = java.util.Arrays.copyOf(chsInventoryGeneralINVOS, chsInventoryGeneralINVOS.length);
		}
		return rtnVOs;
	}

	public void setChsInventoryGeneralINVOS(CHSInventoryGeneralINVO[] chsInventoryGeneralINVOS){
		if(chsInventoryGeneralINVOS != null){
			CHSInventoryGeneralINVO[] tmpVOs = java.util.Arrays.copyOf(chsInventoryGeneralINVOS, chsInventoryGeneralINVOS.length);
			this.chsInventoryGeneralINVOS = tmpVOs;
		}
	}

	
}
