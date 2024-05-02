/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm2077Event.java
*@FileTitle : Inventory by Lessor & Agreement
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.09.10 조재성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.event;

import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByLessorAgmtINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByLessorAgmtMGTVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_2077 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_2077HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Chae Shung Cho
 * @see EES_CGM_2077HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm2077Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MGSInventoryByLessorAgmtINVO mGSInventoryByLessorAgmtINVO = null;
	private MGSInventoryByLessorAgmtMGTVO mGSInventoryByLessorAgmtMGTVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MGSInventoryByLessorAgmtINVO[] mGSInventoryByLessorAgmtINVOs = null;
	private MGSInventoryByLessorAgmtMGTVO[] mGSInventoryByLessorAgmtMGTVOs = null;
	public EesCgm2077Event(){}
	public MGSInventoryByLessorAgmtINVO getMGSInventoryByLessorAgmtINVO() {
		return mGSInventoryByLessorAgmtINVO;
	}
	public void setMGSInventoryByLessorAgmtINVO(
			MGSInventoryByLessorAgmtINVO inventoryByLessorAgmtINVO) {
		mGSInventoryByLessorAgmtINVO = inventoryByLessorAgmtINVO;
	}
	public MGSInventoryByLessorAgmtMGTVO getMGSInventoryByLessorAgmtMGTVO() {
		return mGSInventoryByLessorAgmtMGTVO;
	}
	public void setMGSInventoryByLessorAgmtMGTVO(
			MGSInventoryByLessorAgmtMGTVO inventoryByLessorAgmtMGTVO) {
		mGSInventoryByLessorAgmtMGTVO = inventoryByLessorAgmtMGTVO;
	}
	public MGSInventoryByLessorAgmtINVO[] getMGSInventoryByLessorAgmtINVOs() {
		MGSInventoryByLessorAgmtINVO[] rtnVOs = null;
		if (this.mGSInventoryByLessorAgmtINVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(mGSInventoryByLessorAgmtINVOs, mGSInventoryByLessorAgmtINVOs.length);
		}
		return rtnVOs;
	}
	public void setMGSInventoryByLessorAgmtINVOs(MGSInventoryByLessorAgmtINVO[] inventoryByLessorAgmtINVOs){
		if(inventoryByLessorAgmtINVOs != null){
			MGSInventoryByLessorAgmtINVO[] tmpVOs = java.util.Arrays.copyOf(inventoryByLessorAgmtINVOs, inventoryByLessorAgmtINVOs.length);
			this.mGSInventoryByLessorAgmtINVOs = tmpVOs;
		}
	}
	public MGSInventoryByLessorAgmtMGTVO[] getMGSInventoryByLessorAgmtMGTVOs() {
		MGSInventoryByLessorAgmtMGTVO[] rtnVOs = null;
		if (this.mGSInventoryByLessorAgmtMGTVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(mGSInventoryByLessorAgmtMGTVOs, mGSInventoryByLessorAgmtMGTVOs.length);
		}
		return rtnVOs;
	}
	public void setMGSInventoryByLessorAgmtMGTVOs(MGSInventoryByLessorAgmtMGTVO[] inventoryByLessorAgmtMGTVOs){
		if(inventoryByLessorAgmtMGTVOs != null){
			MGSInventoryByLessorAgmtMGTVO[] tmpVOs = java.util.Arrays.copyOf(inventoryByLessorAgmtMGTVOs, inventoryByLessorAgmtMGTVOs.length);
			this.mGSInventoryByLessorAgmtMGTVOs = tmpVOs;
		}
	}
	
	

}