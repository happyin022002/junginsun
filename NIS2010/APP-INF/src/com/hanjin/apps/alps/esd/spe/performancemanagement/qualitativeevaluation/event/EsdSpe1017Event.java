/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EsdSpe1017Event.java
*@FileTitle : S/P Qualitative Evaulation
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.event;

import com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.vo.SpeSpQualEvVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_SPE_1017 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_SPE_1017HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_SPE_1017HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdSpe1017Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	SpeSpQualEvVO speSpQualEvVO = null;
	
	/** Table Value Object Multi Data 처리 */
	SpeSpQualEvVO[] speSpQualEvVOs = null;

	public EsdSpe1017Event(){}

	public SpeSpQualEvVO getSpeSpQualEvVO() {
		return speSpQualEvVO;
	}

	public void setSpeSpQualEvVO(SpeSpQualEvVO speSpQualEvVO) {
		this.speSpQualEvVO = speSpQualEvVO;
	}

	public SpeSpQualEvVO[] getSpeSpQualEvVOs() {
		return speSpQualEvVOs;
	}

	public void setSpeSpQualEvVOs(SpeSpQualEvVO[] speSpQualEvVOs) {
		this.speSpQualEvVOs = speSpQualEvVOs;
	}
	
	
}