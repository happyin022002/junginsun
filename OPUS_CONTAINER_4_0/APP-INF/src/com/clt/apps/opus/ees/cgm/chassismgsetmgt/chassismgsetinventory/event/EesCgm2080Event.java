/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm2080Event.java
*@FileTitle : Inventory by Location & Lessor 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.09.15 조재성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.event;

import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByLocationLessorINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByLocationLessorMGTVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_2080 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_2080HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Chae Shung Cho
 * @see EES_CGM_2080HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm2080Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MGSInventoryByLocationLessorINVO mGSInventoryByLocationLessorINVO = null;
	private MGSInventoryByLocationLessorMGTVO mGSInventoryByLocationLessorMGTVO = null;	
	/** Table Value Object Multi Data 처리 */
	private MGSInventoryByLocationLessorINVO[] mGSInventoryByLocationLessorINVOs = null;
	private MGSInventoryByLocationLessorMGTVO[] mGSInventoryByLocationLessorMGTVOs = null;	

	public EesCgm2080Event(){}

	public MGSInventoryByLocationLessorINVO getMGSInventoryByLocationLessorINVO() {
		return mGSInventoryByLocationLessorINVO;
	}

	public void setMGSInventoryByLocationLessorINVO(
			MGSInventoryByLocationLessorINVO inventoryByLocationLessorINVO) {
		mGSInventoryByLocationLessorINVO = inventoryByLocationLessorINVO;
	}

	public MGSInventoryByLocationLessorMGTVO getMGSInventoryByLocationLessorMGTVO() {
		return mGSInventoryByLocationLessorMGTVO;
	}

	public void setMGSInventoryByLocationLessorMGTVO(
			MGSInventoryByLocationLessorMGTVO inventoryByLocationLessorMGTVO) {
		mGSInventoryByLocationLessorMGTVO = inventoryByLocationLessorMGTVO;
	}

	public MGSInventoryByLocationLessorINVO[] getMGSInventoryByLocationLessorINVOs() {
		MGSInventoryByLocationLessorINVO[] rtnVOs = null;
		if (this.mGSInventoryByLocationLessorINVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(mGSInventoryByLocationLessorINVOs, mGSInventoryByLocationLessorINVOs.length);
		}
		return rtnVOs;
	}

	public void setMGSInventoryByLocationLessorINVOs(MGSInventoryByLocationLessorINVO[] inventoryByLocationLessorINVOs){
		if(inventoryByLocationLessorINVOs != null){
			MGSInventoryByLocationLessorINVO[] tmpVOs = java.util.Arrays.copyOf(inventoryByLocationLessorINVOs, inventoryByLocationLessorINVOs.length);
			this.mGSInventoryByLocationLessorINVOs = tmpVOs;
		}
	}

	public MGSInventoryByLocationLessorMGTVO[] getMGSInventoryByLocationLessorMGTVOs() {
		MGSInventoryByLocationLessorMGTVO[] rtnVOs = null;
		if (this.mGSInventoryByLocationLessorMGTVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(mGSInventoryByLocationLessorMGTVOs, mGSInventoryByLocationLessorMGTVOs.length);
		}
		return rtnVOs;
	}

	public void setMGSInventoryByLocationLessorMGTVOs(MGSInventoryByLocationLessorMGTVO[] inventoryByLocationLessorMGTVOs){
		if(inventoryByLocationLessorMGTVOs != null){
			MGSInventoryByLocationLessorMGTVO[] tmpVOs = java.util.Arrays.copyOf(inventoryByLocationLessorMGTVOs, inventoryByLocationLessorMGTVOs.length);
			this.mGSInventoryByLocationLessorMGTVOs = tmpVOs;
		}
	}
	
	
	

}