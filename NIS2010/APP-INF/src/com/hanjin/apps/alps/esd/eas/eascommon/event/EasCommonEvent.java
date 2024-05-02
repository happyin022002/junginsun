/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EasCommonEvent.java
*@FileTitle : EAS_Common
*Open Issues :
*Change history :
*@LastModifyDate : 2015-05-13
*@LastModifier : Jong-Ock Kim
*@LastVersion : 1.0
* 2015-05-13 Jong-Ock Kim
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eascommon.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esd.eas.eascommon.vo.EasCommonVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EAS_Common 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EAS_CommonHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jong-Ock Kim
 * @see EAS_COMMON_HTMLAction 참조
 * @since J2EE 1.6
 */
public class EasCommonEvent extends EventSupport {
 
	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private EasCommonVO easCommonVO = null;
	/** Table Value Object Multi Data 처리 */		
	private EasCommonVO[] EasCommonVOs = null;

	public EasCommonEvent() {}
	
	public EasCommonVO getEasCommonVO() {
		return easCommonVO;
	}

	public void setEasCommonVO(EasCommonVO easCommonVO) {
		this.easCommonVO = easCommonVO;
	}
	
	public EasCommonVO[] getEasCommonVOs() {
		EasCommonVO[] rtnVOs = null;
		if (this.EasCommonVOs != null) {
			rtnVOs = new EasCommonVO[EasCommonVOs.length];
			System.arraycopy(EasCommonVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setEasCommonVOs(EasCommonVO[] EasCommonVOs) {
		if(EasCommonVOs != null){
			EasCommonVO[] tmpVOs = Arrays.copyOf(EasCommonVOs, EasCommonVOs.length);
			this.EasCommonVOs = tmpVOs;
		}
	}
}