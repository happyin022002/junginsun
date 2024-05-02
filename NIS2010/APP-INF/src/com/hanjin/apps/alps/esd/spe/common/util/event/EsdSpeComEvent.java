/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EsdSpeComEvent.java
*@FileTitle : ESD_SPE_COM
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.common.util.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.spe.common.util.vo.UtillVO;


/**
 * ESD_SPE_COM 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_SPE_COMHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_SPE_COMHTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdSpeComEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	UtillVO utillVO = null;
	
	/** Table Value Object Multi Data 처리 */
	UtillVO[] utillVOs = null;

	public EsdSpeComEvent(){}

	public UtillVO getUtillVO() {
		return utillVO;
	}

	public void setUtillVO(UtillVO utillVO) {
		this.utillVO = utillVO;
	}

	public UtillVO[] getUtillVOs() {
		return utillVOs;
	}

	public void setUtillVOs(UtillVO[] utillVOs) {
		this.utillVOs = utillVOs;
	}
	


}