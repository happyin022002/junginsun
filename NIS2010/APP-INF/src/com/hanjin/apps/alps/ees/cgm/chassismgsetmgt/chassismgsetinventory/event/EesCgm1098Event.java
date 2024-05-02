/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1098Event.java
*@FileTitle : Inventory by Agreement
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.07.29 조재성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.event;

import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByAgmtINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByAgmtMGTVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_1098 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1098HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author ChaeShung Cho
 * @see EES_CGM_1098HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1098Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSInventoryByAgmtINVO cHSInventoryByAgmtINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CHSInventoryByAgmtMGTVO[] cHSInventoryByAgmtMGTVOs = null;

	public EesCgm1098Event(){}

	public CHSInventoryByAgmtINVO getCHSInventoryByAgmtINVO() {
		return cHSInventoryByAgmtINVO;
	}

	public void setCHSInventoryByAgmtINVO(CHSInventoryByAgmtINVO inventoryByAgmtINVO) {
		cHSInventoryByAgmtINVO = inventoryByAgmtINVO;
	}

	public CHSInventoryByAgmtMGTVO[] getCHSInventoryByAgmtMGTVOs() {
		return cHSInventoryByAgmtMGTVOs;
	}

	public void setCHSInventoryByAgmtMGTVOs(
			CHSInventoryByAgmtMGTVO[] inventoryByAgmtMGTVOs) {
		cHSInventoryByAgmtMGTVOs = inventoryByAgmtMGTVOs;
	}
	
	

}