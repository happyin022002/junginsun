/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1100Event.java
*@FileTitle : Inventory by On-Hire Year
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.07.30 조재성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.event;

import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByOnhireYearINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByOnhireYearMGTVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_1100 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1100HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author ChaeShung Cho
 * @see EES_CGM_1100HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1100Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSInventoryByOnhireYearINVO cHSInventoryByOnhireYearINVO = null;
	private CHSInventoryByOnhireYearMGTVO cHSInventoryByOnhireYearMGTVO = null;
	private CHSInventoryByOnhireYearMGTVO[] cHSInventoryByOnhireYearMGTVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	public EesCgm1100Event(){}

	public CHSInventoryByOnhireYearINVO getCHSInventoryByOnhireYearINVO() {
		return cHSInventoryByOnhireYearINVO;
	}

	public void setCHSInventoryByOnhireYearINVO(
			CHSInventoryByOnhireYearINVO inventoryByOnhireYearINVO) {
		cHSInventoryByOnhireYearINVO = inventoryByOnhireYearINVO;
	}

	public CHSInventoryByOnhireYearMGTVO getCHSInventoryByOnhireYearMGTVO() {
		return cHSInventoryByOnhireYearMGTVO;
	}

	public void setCHSInventoryByOnhireYearMGTVO(
			CHSInventoryByOnhireYearMGTVO inventoryByOnhireYearMGTVO) {
		cHSInventoryByOnhireYearMGTVO = inventoryByOnhireYearMGTVO;
	}

	public CHSInventoryByOnhireYearMGTVO[] getCHSInventoryByOnhireYearMGTVOs() {
		return cHSInventoryByOnhireYearMGTVOs;
	}

	public void setCHSInventoryByOnhireYearMGTVOs(
			CHSInventoryByOnhireYearMGTVO[] inventoryByOnhireYearMGTVOs) {
		cHSInventoryByOnhireYearMGTVOs = inventoryByOnhireYearMGTVOs;
	}
	


}