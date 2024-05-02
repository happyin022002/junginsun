/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm2006Event.java
*@FileTitle : M.G Set Master Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 박의수
*@LastVersion : 1.0
* 2009.06.09 박의수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event;

import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSEquipmentINVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.vo.MGSAtdtHistoryINVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EES_CGM_2006 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_2006HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Eui-su Park
 * @see EES_CGM_2006HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm2006Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MGSEquipmentINVO mGSEquipmentINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MGSEquipmentINVO[] mGSEquipmentINVOs = null;
	private MGSAtdtHistoryINVO[] mGSAtdtHistoryINVOs = null;
	
	public EesCgm2006Event(){}

	public MGSEquipmentINVO getMGSEquipmentINVO() {
		return mGSEquipmentINVO;
	}

	public void setMGSEquipmentINVO(MGSEquipmentINVO equipmentINVO) {
		mGSEquipmentINVO = equipmentINVO;
	}

	public MGSEquipmentINVO[] getMGSEquipmentINVOs() {
		MGSEquipmentINVO[] rtnVOs = null;
		if (this.mGSEquipmentINVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(mGSEquipmentINVOs, mGSEquipmentINVOs.length);
		}
		return rtnVOs;
	}

	public void setMGSEquipmentINVOs(MGSEquipmentINVO[] equipmentINVOs){
		if(equipmentINVOs != null){
			MGSEquipmentINVO[] tmpVOs = java.util.Arrays.copyOf(equipmentINVOs, equipmentINVOs.length);
			this.mGSEquipmentINVOs = tmpVOs;
		}
	}

	public MGSAtdtHistoryINVO[] getMGSAtdtHistoryINVOs() {
		MGSAtdtHistoryINVO[] rtnVOs = null;
		if (this.mGSAtdtHistoryINVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(mGSAtdtHistoryINVOs, mGSAtdtHistoryINVOs.length);
		}
		return rtnVOs;
	}

	public void setMGSAtdtHistoryINVOs(MGSAtdtHistoryINVO[] atdtHistoryINVOs){
		if(atdtHistoryINVOs != null){
			MGSAtdtHistoryINVO[] tmpVOs = java.util.Arrays.copyOf(atdtHistoryINVOs, atdtHistoryINVOs.length);
			this.mGSAtdtHistoryINVOs = tmpVOs;
		}
	}

	

}
