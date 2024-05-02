/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1006Event.java
*@FileTitle : Chassis Registration Inquiry/Update
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.29
*@LastModifier : 박의수
*@LastVersion : 1.0
* 2009.05.29 박의수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event;

import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSEquipmentINVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_1006 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1006HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Eui-su Park
 * @see EES_CGM_1006HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1006Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSEquipmentINVO cHSEquipmentINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CHSEquipmentINVO[] cHSEquipmentINVOs = null;

	public EesCgm1006Event(){}
	
	public void setCHSEquipmentINVO(CHSEquipmentINVO cHSEquipmentINVO){
		this. cHSEquipmentINVO = cHSEquipmentINVO;
	}

	public void setCHSEquipmentINVOS(CHSEquipmentINVO[] cHSEquipmentINVOs){
		if(cHSEquipmentINVOs != null){
			CHSEquipmentINVO[] tmpVOs = java.util.Arrays.copyOf(cHSEquipmentINVOs, cHSEquipmentINVOs.length);
			this.cHSEquipmentINVOs = tmpVOs;
		}
	}

	public CHSEquipmentINVO getCHSEquipmentINVO(){
		return cHSEquipmentINVO;
	}

	public CHSEquipmentINVO[] getCHSEquipmentINVOS(){
		CHSEquipmentINVO[] rtnVOs = null;
		if (this.cHSEquipmentINVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(cHSEquipmentINVOs, cHSEquipmentINVOs.length);
		}
		return rtnVOs;
	}

}