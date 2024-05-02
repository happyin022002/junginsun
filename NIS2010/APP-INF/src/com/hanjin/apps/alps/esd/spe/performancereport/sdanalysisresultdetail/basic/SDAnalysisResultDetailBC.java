/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SDAnalysisResultDetailBC.java
*@FileTitle : SD Analysis Result Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.03.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancereport.sdanalysisresultdetail.basic;

import java.util.List;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.esd.spe.performancereport.sdanalysisreport.vo.SpeSDAnalysisVO;
import com.hanjin.apps.alps.esd.spe.performancereport.sdanalysisresultdetail.vo.SpeSDAnalysisDtlVO;

/**
 * ALPS-Performancereport Business Logic Command Interface<br>
 * - ALPS-Performancereport에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author HI
 * @see
 * @since J2EE 1.6
 */

public interface SDAnalysisResultDetailBC {

	/**
	 * SD Analysis Result Detail 데이터를 조회한다.<br>
	 * 
	 * @param SpeSDAnalysisDtlVO speSDAnalysisDtlVO
	 * @return List<SpeSDAnalysisDtlVO>
	 * @exception EventException
	 */
	public List<SpeSDAnalysisDtlVO> searchSDAnalysisDtl(SpeSDAnalysisDtlVO speSDAnalysisDtlVO) throws EventException;	
}