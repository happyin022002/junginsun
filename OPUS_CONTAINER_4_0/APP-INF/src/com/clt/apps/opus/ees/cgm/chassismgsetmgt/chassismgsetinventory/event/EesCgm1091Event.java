/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1091Event.java
*@FileTitle : Chassis Inventory List(Popup)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.09
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.07.09 김창식
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.event;

import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryDtlINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSOnOffhireDtlINVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_1091 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1091HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Eui-su Park
 * @see EES_CGM_1091HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesCgm1091Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSInventoryDtlINVO chsInventoryDtlINVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSOnOffhireDtlINVO cHSOnOffhireDtlINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CHSInventoryDtlINVO[] chsInventoryDtlINVOS = null;

	public EesCgm1091Event(){}

	public CHSInventoryDtlINVO getChsInventoryDtlINVO() {
		return chsInventoryDtlINVO;
	}

	/**
	 * @return the cHSOnOffhireDtlINVO
	 */
	public CHSOnOffhireDtlINVO getCHSOnOffhireDtlINVO() {
		return cHSOnOffhireDtlINVO;
	}

	/**
	 * @param onOffhireDtlINVO the cHSOnOffhireDtlINVO to set
	 */
	public void setCHSOnOffhireDtlINVO(CHSOnOffhireDtlINVO onOffhireDtlINVO) {
		cHSOnOffhireDtlINVO = onOffhireDtlINVO;
	}

	public void setChsInventoryDtlINVO(CHSInventoryDtlINVO chsInventoryDtlINVO) {
		this.chsInventoryDtlINVO = chsInventoryDtlINVO;
	}

	public CHSInventoryDtlINVO[] getChsInventoryDtlINVOS() {
		CHSInventoryDtlINVO[] rtnVOs = null;
		if (this.chsInventoryDtlINVOS != null) {
			rtnVOs = java.util.Arrays.copyOf(chsInventoryDtlINVOS, chsInventoryDtlINVOS.length);
		}
		return rtnVOs;
	}

	public void setChsInventoryDtlINVOS(CHSInventoryDtlINVO[] chsInventoryDtlINVOS){
		if(chsInventoryDtlINVOS != null){
			CHSInventoryDtlINVO[] tmpVOs = java.util.Arrays.copyOf(chsInventoryDtlINVOS, chsInventoryDtlINVOS.length);
			this.chsInventoryDtlINVOS = tmpVOs;
		}
	}

	
}
