/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1002Event.java
*@FileTitle : Chassis Specification Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 박의수
*@LastVersion : 1.0
* 2009.05.21 박의수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event;

import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSEqSpecINVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_1002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Eui-su Park
 * @see EES_CGM_1002HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1002Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSEqSpecINVO cHSEqSpecINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CHSEqSpecINVO[] cHSEqSpecINVOs = null;

	public EesCgm1002Event(){}
	
	public void setCHSEqSpecINVO(CHSEqSpecINVO cHSEqSpecINVO){
		this. cHSEqSpecINVO = cHSEqSpecINVO;
	}

	public void setCHSEqSpecINVOS(CHSEqSpecINVO[] cHSEqSpecINVOs){
		this. cHSEqSpecINVOs = cHSEqSpecINVOs;
	}

	public CHSEqSpecINVO getCHSEqSpecINVO(){
		return cHSEqSpecINVO;
	}

	public CHSEqSpecINVO[] getCHSEqSpecINVOS(){
		return cHSEqSpecINVOs;
	}

}