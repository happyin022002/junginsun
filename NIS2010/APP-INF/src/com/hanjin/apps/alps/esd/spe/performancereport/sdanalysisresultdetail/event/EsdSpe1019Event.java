/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EsdSpe1019Event.java
*@FileTitle : SD Analysis Result Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.03.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancereport.sdanalysisresultdetail.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.spe.performancereport.sdanalysisresultdetail.vo.SpeSDAnalysisDtlVO;


/**
 * ESD_SPE_1019 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_SPE_1019HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_SPE_1019HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdSpe1019Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	SpeSDAnalysisDtlVO speSDAnalysisDtlVO = null;
	
	/** Table Value Object Multi Data 처리 */
	SpeSDAnalysisDtlVO[] speSDAnalysisDtlVOs = null;

	public EsdSpe1019Event(){}

	public SpeSDAnalysisDtlVO getSpeSDAnalysisDtlVO() {
		return speSDAnalysisDtlVO;
	}

	public void setSpeSDAnalysisDtlVO(SpeSDAnalysisDtlVO speSDAnalysisDtlVO) {
		this.speSDAnalysisDtlVO = speSDAnalysisDtlVO;
	}

	public SpeSDAnalysisDtlVO[] getSpeSDAnalysisDtlVOs() {
		return speSDAnalysisDtlVOs;
	}

	public void setSpeSDAnalysisDtlVOs(SpeSDAnalysisDtlVO[] speSDAnalysisDtlVOs) {
		this.speSDAnalysisDtlVOs = speSDAnalysisDtlVOs;
	}
	


}