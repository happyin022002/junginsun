/*=========================================================
*@FileName : EesCgm1003Event.java
*@FileTitle : Chassis Master Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 박의수
*@LastVersion : 1.0
* 2009.06.08 박의수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event;

import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSMasterInfoINVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_1003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Eui-su Park
 * @see EES_CGM_1003HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1003Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSMasterInfoINVO cHSMasterInfoINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CHSMasterInfoINVO[] cHSMasterInfoINVOs = null;

	public EesCgm1003Event(){}
	
	public void setCHSMasterInfoINVO(CHSMasterInfoINVO cHSMasterInfoINVO){
		this. cHSMasterInfoINVO = cHSMasterInfoINVO;
	}

	public void setCHSMasterInfoINVOS(CHSMasterInfoINVO[] cHSMasterInfoINVOs){
		this. cHSMasterInfoINVOs = cHSMasterInfoINVOs;
	}

	public CHSMasterInfoINVO getCHSMasterInfoINVO(){
		return cHSMasterInfoINVO;
	}

	public CHSMasterInfoINVO[] getCHSMasterInfoINVOS(){
		return cHSMasterInfoINVOs;
	}
}
