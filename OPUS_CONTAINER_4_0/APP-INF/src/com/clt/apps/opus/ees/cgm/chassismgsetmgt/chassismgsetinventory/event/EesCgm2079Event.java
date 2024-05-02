/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm2079Event.java
*@FileTitle : Inventory by Creation Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.09.11 조재성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.event;

import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByOfficeINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByOfficeMGTVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_2079 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_2079HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Chae Shung Cho
 * @see EES_CGM_2079HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm2079Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MGSInventoryByOfficeINVO mGSInventoryByOfficeINVO = null;
	private MGSInventoryByOfficeMGTVO mGSInventoryByOfficeMGTVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MGSInventoryByOfficeINVO[] mGSInventoryByOfficeINVOs = null;
	private MGSInventoryByOfficeMGTVO[] mGSInventoryByOfficeMGTVOs = null;

	public EesCgm2079Event(){}

	public MGSInventoryByOfficeINVO getMGSInventoryByOfficeINVO() {
		return mGSInventoryByOfficeINVO;
	}

	public void setMGSInventoryByOfficeINVO(
			MGSInventoryByOfficeINVO inventoryByOfficeINVO) {
		mGSInventoryByOfficeINVO = inventoryByOfficeINVO;
	}

	public MGSInventoryByOfficeMGTVO getMGSInventoryByOfficeMGTVO() {
		return mGSInventoryByOfficeMGTVO;
	}

	public void setMGSInventoryByOfficeMGTVO(
			MGSInventoryByOfficeMGTVO inventoryByOfficeMGTVO) {
		mGSInventoryByOfficeMGTVO = inventoryByOfficeMGTVO;
	}

	public MGSInventoryByOfficeINVO[] getMGSInventoryByOfficeINVOs() {
		MGSInventoryByOfficeINVO[] rtnVOs = null;
		if (this.mGSInventoryByOfficeINVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(mGSInventoryByOfficeINVOs, mGSInventoryByOfficeINVOs.length);
		}
		return rtnVOs;
	}

	public void setMGSInventoryByOfficeINVOs(MGSInventoryByOfficeINVO[] inventoryByOfficeINVOs){
		if(inventoryByOfficeINVOs != null){
			MGSInventoryByOfficeINVO[] tmpVOs = java.util.Arrays.copyOf(inventoryByOfficeINVOs, inventoryByOfficeINVOs.length);
			this.mGSInventoryByOfficeINVOs = tmpVOs;
		}
	}

	public MGSInventoryByOfficeMGTVO[] getMGSInventoryByOfficeMGTVOs() {
		MGSInventoryByOfficeMGTVO[] rtnVOs = null;
		if (this.mGSInventoryByOfficeMGTVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(mGSInventoryByOfficeMGTVOs, mGSInventoryByOfficeMGTVOs.length);
		}
		return rtnVOs;
	}

	public void setMGSInventoryByOfficeMGTVOs(MGSInventoryByOfficeMGTVO[] inventoryByOfficeMGTVOs){
		if(inventoryByOfficeMGTVOs != null){
			MGSInventoryByOfficeMGTVO[] tmpVOs = java.util.Arrays.copyOf(inventoryByOfficeMGTVOs, inventoryByOfficeMGTVOs.length);
			this.mGSInventoryByOfficeMGTVOs = tmpVOs;
		}
	}
	

}