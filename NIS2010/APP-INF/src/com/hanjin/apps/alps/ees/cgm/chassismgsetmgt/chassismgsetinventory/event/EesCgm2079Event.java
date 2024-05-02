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
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByOfficeINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByOfficeMGTVO;


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
		return mGSInventoryByOfficeINVOs;
	}

	public void setMGSInventoryByOfficeINVOs(
			MGSInventoryByOfficeINVO[] inventoryByOfficeINVOs) {
		mGSInventoryByOfficeINVOs = inventoryByOfficeINVOs;
	}

	public MGSInventoryByOfficeMGTVO[] getMGSInventoryByOfficeMGTVOs() {
		return mGSInventoryByOfficeMGTVOs;
	}

	public void setMGSInventoryByOfficeMGTVOs(
			MGSInventoryByOfficeMGTVO[] inventoryByOfficeMGTVOs) {
		mGSInventoryByOfficeMGTVOs = inventoryByOfficeMGTVOs;
	}
	

}