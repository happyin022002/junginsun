/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1102Event.java
*@FileTitle : Chassis Variation Status Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.07.31 조재성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.event;

import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByVariationINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByVariationMGTVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_1102 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1102HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author ChaeShung Cho
 * @see EES_CGM_1102HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1102Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSInventoryByVariationINVO cHSInventoryByVariationINVO = null;
	private CHSInventoryByVariationMGTVO cHSInventoryByVariationMGTVO = null;
	/** Table Value Object Multi Data 처리 */
	private CHSInventoryByVariationMGTVO[] cHSInventoryByVariationMGTVOs = null;

	public EesCgm1102Event(){}

	public CHSInventoryByVariationINVO getCHSInventoryByVariationINVO() {
		return cHSInventoryByVariationINVO;
	}

	public void setCHSInventoryByVariationINVO(
			CHSInventoryByVariationINVO inventoryByVariationINVO) {
		cHSInventoryByVariationINVO = inventoryByVariationINVO;
	}

	public CHSInventoryByVariationMGTVO getCHSInventoryByVariationMGTVO() {
		return cHSInventoryByVariationMGTVO;
	}

	public void setCHSInventoryByVariationMGTVO(
			CHSInventoryByVariationMGTVO inventoryByVariationMGTVO) {
		cHSInventoryByVariationMGTVO = inventoryByVariationMGTVO;
	}

	public CHSInventoryByVariationMGTVO[] getCHSInventoryByVariationMGTVOs() {
		CHSInventoryByVariationMGTVO[] rtnVOs = null;
		if (this.cHSInventoryByVariationMGTVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(cHSInventoryByVariationMGTVOs, cHSInventoryByVariationMGTVOs.length);
		}
		return rtnVOs;
	}

	public void setCHSInventoryByVariationMGTVOs(CHSInventoryByVariationMGTVO[] inventoryByVariationMGTVOs){
		if(inventoryByVariationMGTVOs != null){
			CHSInventoryByVariationMGTVO[] tmpVOs = java.util.Arrays.copyOf(inventoryByVariationMGTVOs, inventoryByVariationMGTVOs.length);
			this.cHSInventoryByVariationMGTVOs = tmpVOs;
		}
	}
	


}