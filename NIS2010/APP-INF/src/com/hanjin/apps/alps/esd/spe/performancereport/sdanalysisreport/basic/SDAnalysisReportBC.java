/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SDAnalysisReportBC.java
*@FileTitle : SD Analysis Report
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.03.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancereport.sdanalysisreport.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.spe.egmapping.egandevaluator.vo.SpeEGEVMappingVO;
import com.hanjin.apps.alps.esd.spe.performancereport.sdanalysisreport.vo.SpeSDAnalysisVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Performancereport Business Logic Command Interface<br>
 * - ALPS-Performancereport에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author HI
 * @see
 * @since J2EE 1.6
 */

public interface SDAnalysisReportBC {


	/**
	 * SD Analysis Report 데이터를 조회한다.<br>
	 * 
	 * @param SpeSDAnalysisVO speSDAnalysisVO
	 * @return List<SpeSDAnalysisVO>
	 * @exception EventException
	 */
	public List<SpeSDAnalysisVO> searchSDAnalysis(SpeSDAnalysisVO speSDAnalysisVO) throws EventException;	
	
}