/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EsdSpe1018Event.java
*@FileTitle : SD Analysis Report
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.03.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancereport.sdanalysisreport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.spe.performancereport.sdanalysisreport.vo.SpeSDAnalysisVO;


/**
 * ESD_SPE_1018 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_SPE_1018HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_SPE_1018HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdSpe1018Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	SpeSDAnalysisVO speSDAnalysisVO = null;
	
	/** Table Value Object Multi Data 처리 */
	SpeSDAnalysisVO[] speSDAnalysisVOs = null;

	public EsdSpe1018Event(){}

	public SpeSDAnalysisVO getSpeSDAnalysisVO() {
		return speSDAnalysisVO;
	}

	public void setSpeSDAnalysisVO(SpeSDAnalysisVO speSDAnalysisVO) {
		this.speSDAnalysisVO = speSDAnalysisVO;
	}

	public SpeSDAnalysisVO[] getSpeSDAnalysisVOs() {
		return speSDAnalysisVOs;
	}

	public void setSpeSDAnalysisVOs(SpeSDAnalysisVO[] speSDAnalysisVOs) {
		this.speSDAnalysisVOs = speSDAnalysisVOs;
	}
	


}