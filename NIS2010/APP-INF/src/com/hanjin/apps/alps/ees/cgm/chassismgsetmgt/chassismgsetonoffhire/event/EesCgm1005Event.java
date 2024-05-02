/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1005Event.java
*@FileTitle : Own Chassis Master Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.14
*@LastModifier : 박의수
*@LastVersion : 1.0
* 2009.06.14 박의수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event;

import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSSpecINVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES_CGM_1005 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1005HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Eui-su Park
 * @see EES_CGM_1005HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1005Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSSpecINVO cHSSpecINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CHSSpecINVO[] cHSSpecINVOs = null;

	public EesCgm1005Event(){}
	
	public void setCHSSpecINVO(CHSSpecINVO cHSSpecINVO){
		this. cHSSpecINVO = cHSSpecINVO;
	}

	public void setCHSSpecINVOS(CHSSpecINVO[] cHSSpecINVOs){
		this. cHSSpecINVOs = cHSSpecINVOs;
	}

	public CHSSpecINVO getCHSSpecINVO(){
		return cHSSpecINVO;
	}

	public CHSSpecINVO[] getCHSSpecINVOS(){
		return cHSSpecINVOs;
	}
}
