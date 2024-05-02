/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1001Event.java
*@FileTitle : Chassis Type/Size Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 박의수
*@LastVersion : 1.0
* 2009.05.19 박의수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSEqTpSzINVO;

/**
 * EES_CGM_1001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Eui-su Park
 * @see EES_CGM_1001HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesCgm1001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSEqTpSzINVO cHSCgmEqTpSzINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CHSEqTpSzINVO[] cHSCgmEqTpSzINVOs = null;

	public EesCgm1001Event(){}
	
	public void setCHSEqTpSzINVO(CHSEqTpSzINVO cHSCgmEqTpSzINVO){
		this. cHSCgmEqTpSzINVO = cHSCgmEqTpSzINVO;
	}

	public void setCHSEqTpSzINVOS(CHSEqTpSzINVO[] cHSCgmEqTpSzINVOs){
		this. cHSCgmEqTpSzINVOs = cHSCgmEqTpSzINVOs;
	}

	public CHSEqTpSzINVO getCHSEqTpSzINVO(){
		return cHSCgmEqTpSzINVO;
	}

	public CHSEqTpSzINVO[] getCHSEqTpSzINVOS(){
		return cHSCgmEqTpSzINVOs;
	}
}
