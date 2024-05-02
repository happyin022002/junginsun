/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm2078Event.java
*@FileTitle : Inventory by Lessor & Lease Term
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.09.11 조재성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.event;

import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByLessorTermINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByLessorTermMGTVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_2078 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_2078HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Chae Shung Cho
 * @see EES_CGM_2078HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm2078Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MGSInventoryByLessorTermINVO mGSInventoryByLessorTermINVO = null;
	private MGSInventoryByLessorTermMGTVO mGSInventoryByLessorTermMGTVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MGSInventoryByLessorTermINVO[] mGSInventoryByLessorTermINVOs = null;
	private MGSInventoryByLessorTermMGTVO[] mGSInventoryByLessorTermMGTVOs = null;

	public EesCgm2078Event(){}

	public MGSInventoryByLessorTermINVO getMGSInventoryByLessorTermINVO() {
		return mGSInventoryByLessorTermINVO;
	}

	public void setMGSInventoryByLessorTermINVO(
			MGSInventoryByLessorTermINVO inventoryByLessorTermINVO) {
		mGSInventoryByLessorTermINVO = inventoryByLessorTermINVO;
	}

	public MGSInventoryByLessorTermMGTVO getMGSInventoryByLessorTermMGTVO() {
		return mGSInventoryByLessorTermMGTVO;
	}

	public void setMGSInventoryByLessorTermMGTVO(
			MGSInventoryByLessorTermMGTVO inventoryByLessorTermMGTVO) {
		mGSInventoryByLessorTermMGTVO = inventoryByLessorTermMGTVO;
	}

	public MGSInventoryByLessorTermINVO[] getMGSInventoryByLessorTermINVOs() {
		MGSInventoryByLessorTermINVO[] rtnVOs = null;
		if (this.mGSInventoryByLessorTermINVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(mGSInventoryByLessorTermINVOs, mGSInventoryByLessorTermINVOs.length);
		}
		return rtnVOs;
	}

	public void setMGSInventoryByLessorTermINVOs(MGSInventoryByLessorTermINVO[] inventoryByLessorTermINVOs){
		if(inventoryByLessorTermINVOs != null){
			MGSInventoryByLessorTermINVO[] tmpVOs = java.util.Arrays.copyOf(inventoryByLessorTermINVOs, inventoryByLessorTermINVOs.length);
			this.mGSInventoryByLessorTermINVOs = tmpVOs;
		}
	}

	public MGSInventoryByLessorTermMGTVO[] getMGSInventoryByLessorTermMGTVOs() {
		MGSInventoryByLessorTermMGTVO[] rtnVOs = null;
		if (this.mGSInventoryByLessorTermMGTVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(mGSInventoryByLessorTermMGTVOs, mGSInventoryByLessorTermMGTVOs.length);
		}
		return rtnVOs;
	}

	public void setMGSInventoryByLessorTermMGTVOs(MGSInventoryByLessorTermMGTVO[] inventoryByLessorTermMGTVOs){
		if(inventoryByLessorTermMGTVOs != null){
			MGSInventoryByLessorTermMGTVO[] tmpVOs = java.util.Arrays.copyOf(inventoryByLessorTermMGTVOs, inventoryByLessorTermMGTVOs.length);
			this.mGSInventoryByLessorTermMGTVOs = tmpVOs;
		}
	}
	


}