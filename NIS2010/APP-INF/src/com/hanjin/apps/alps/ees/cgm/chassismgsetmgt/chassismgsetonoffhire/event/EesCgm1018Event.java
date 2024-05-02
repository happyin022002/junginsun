/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1018Event.java
*@FileTitle : Lost 되었던 Chassis 가 시스템상에 Movement가 EDI로 들어올 경우 Found 처리하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.06.22 최민회
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event;

import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSFoundAutoMGTVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_1018 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1018HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI MIN HOI
 * @see EES_CGM_1018HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1018Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSFoundAutoMGTVO cHSFoundAutoMGTVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CHSFoundAutoMGTVO[] cHSFoundAutoMGTVOS = null;

	public EesCgm1018Event(){}

	/**
	 * @return the cHSFoundAutoMGTVO
	 */
	public CHSFoundAutoMGTVO getCHSFoundAutoMGTVO() {
		return cHSFoundAutoMGTVO;
	}

	/**
	 * @param foundAutoMGTVO the cHSFoundAutoMGTVO to set
	 */
	public void setCHSFoundAutoMGTVO(CHSFoundAutoMGTVO foundAutoMGTVO) {
		cHSFoundAutoMGTVO = foundAutoMGTVO;
	}

	/**
	 * @return the cHSFoundAutoMGTVOS
	 */
	public CHSFoundAutoMGTVO[] getCHSFoundAutoMGTVOS() {
		return cHSFoundAutoMGTVOS;
	}

	/**
	 * @param foundAutoMGTVOS the cHSFoundAutoMGTVOS to set
	 */
	public void setCHSFoundAutoMGTVOS(CHSFoundAutoMGTVO[] foundAutoMGTVOS) {
		cHSFoundAutoMGTVOS = foundAutoMGTVOS;
	}
	


}