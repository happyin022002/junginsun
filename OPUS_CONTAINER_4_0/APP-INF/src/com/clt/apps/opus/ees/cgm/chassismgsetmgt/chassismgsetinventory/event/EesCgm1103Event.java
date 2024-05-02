/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1103Event.java
*@FileTitle : Chassis Variation Status Detail Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.08.10 조재성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.event;

import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByVariationDtlINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByVariationDtlMGTVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_1103 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1103HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author ChaeShung Cho
 * @see EES_CGM_1103HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1103Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSInventoryByVariationDtlINVO cHSInventoryByVariationDtlINVO = null;
	private CHSInventoryByVariationDtlMGTVO cHSInventoryByVariationDtlMGTVO = null;
	/** Table Value Object Multi Data 처리 */
	private CHSInventoryByVariationDtlMGTVO[] cHSInventoryByVariationDtlMGTVOs = null;
	
	public EesCgm1103Event(){}

	public CHSInventoryByVariationDtlINVO getCHSInventoryByVariationDtlINVO() {
		return cHSInventoryByVariationDtlINVO;
	}

	public void setCHSInventoryByVariationDtlINVO(
			CHSInventoryByVariationDtlINVO inventoryByVariationDtlINVO) {
		cHSInventoryByVariationDtlINVO = inventoryByVariationDtlINVO;
	}

	public CHSInventoryByVariationDtlMGTVO getCHSInventoryByVariationDtlMGTVO() {
		return cHSInventoryByVariationDtlMGTVO;
	}

	public void setCHSInventoryByVariationDtlMGTVO(
			CHSInventoryByVariationDtlMGTVO inventoryByVariationDtlMGTVO) {
		cHSInventoryByVariationDtlMGTVO = inventoryByVariationDtlMGTVO;
	}

	public CHSInventoryByVariationDtlMGTVO[] getCHSInventoryByVariationDtlMGTVOs() {
		CHSInventoryByVariationDtlMGTVO[] rtnVOs = null;
		if (this.cHSInventoryByVariationDtlMGTVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(cHSInventoryByVariationDtlMGTVOs, cHSInventoryByVariationDtlMGTVOs.length);
		}
		return rtnVOs;
	}

	public void setCHSInventoryByVariationDtlMGTVOs(CHSInventoryByVariationDtlMGTVO[] inventoryByVariationDtlMGTVOs){
		if(inventoryByVariationDtlMGTVOs != null){
			CHSInventoryByVariationDtlMGTVO[] tmpVOs = java.util.Arrays.copyOf(inventoryByVariationDtlMGTVOs, inventoryByVariationDtlMGTVOs.length);
			this.cHSInventoryByVariationDtlMGTVOs = tmpVOs;
		}
	}



}