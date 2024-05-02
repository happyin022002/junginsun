/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm2076Event.java
*@FileTitle : General Inventory
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.09.09 조재성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.event;

import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryGeneralINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryGeneralMGTVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_2076 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_2076HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Chae Shung Cho
 * @see EES_CGM_2076HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm2076Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MGSInventoryGeneralINVO mGSInventoryGeneralINVO = null;
	private MGSInventoryGeneralMGTVO mGSInventoryGeneralMGTVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MGSInventoryGeneralINVO[] mGSInventoryGeneralINVOs = null;
	private MGSInventoryGeneralMGTVO[] mGSInventoryGeneralMGTVOs = null;
	
	public EesCgm2076Event(){}

	public MGSInventoryGeneralINVO getMGSInventoryGeneralINVO() {
		return mGSInventoryGeneralINVO;
	}

	public void setMGSInventoryGeneralINVO(
			MGSInventoryGeneralINVO inventoryGeneralINVO) {
		mGSInventoryGeneralINVO = inventoryGeneralINVO;
	}

	public MGSInventoryGeneralMGTVO getMGSInventoryGeneralMGTVO() {
		return mGSInventoryGeneralMGTVO;
	}

	public void setMGSInventoryGeneralMGTVO(
			MGSInventoryGeneralMGTVO inventoryGeneralMGTVO) {
		mGSInventoryGeneralMGTVO = inventoryGeneralMGTVO;
	}

	public MGSInventoryGeneralINVO[] getMGSInventoryGeneralINVOs() {
		MGSInventoryGeneralINVO[] rtnVOs = null;
		if (this.mGSInventoryGeneralINVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(mGSInventoryGeneralINVOs, mGSInventoryGeneralINVOs.length);
		}
		return rtnVOs;
	}

	public void setMGSInventoryGeneralINVOs(MGSInventoryGeneralINVO[] inventoryGeneralINVOs){
		if(inventoryGeneralINVOs != null){
			MGSInventoryGeneralINVO[] tmpVOs = java.util.Arrays.copyOf(inventoryGeneralINVOs, inventoryGeneralINVOs.length);
			this.mGSInventoryGeneralINVOs = tmpVOs;
		}
	}

	public MGSInventoryGeneralMGTVO[] getMGSInventoryGeneralMGTVOs() {
		MGSInventoryGeneralMGTVO[] rtnVOs = null;
		if (this.mGSInventoryGeneralMGTVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(mGSInventoryGeneralMGTVOs, mGSInventoryGeneralMGTVOs.length);
		}
		return rtnVOs;
	}

	public void setMGSInventoryGeneralMGTVOs(MGSInventoryGeneralMGTVO[] inventoryGeneralMGTVOs){
		if(inventoryGeneralMGTVOs != null){
			MGSInventoryGeneralMGTVO[] tmpVOs = java.util.Arrays.copyOf(inventoryGeneralMGTVOs, inventoryGeneralMGTVOs.length);
			this.mGSInventoryGeneralMGTVOs = tmpVOs;
		}
	}
	

}