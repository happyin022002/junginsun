/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : QualitativeEvaluationBC.java
*@FileTitle : Qualitative Evaluation Sheet Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.basic;

import java.util.List;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.vo.SpeSpQualEvVO;
import com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.vo.SpeQECreVO;

/**
 * ALPS-Performancemanagement Business Logic Command Interface<br>
 * ALPS-Performancemanagement에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author HI
 * @see
 * @since J2EE 1.6
 */

public interface QualitativeEvaluationBC {
	
	/**
	 * QE 데이터를 입력/수정/삭제 한다.<br>
	 * 
	 * @param SpeQECreVO[] speQECreVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiQualitativeEvaluationCreation(SpeQECreVO[] speQECreVOs,SignOnUserAccount account) throws EventException;

	/**
	 * QE 데이터를 조회한다.<br>
	 * 
	 * @param SpeQECreVO speQECreVO
	 * @return List<SpeEGCreVO>
	 * @exception EventException
	 */
	public List<SpeQECreVO> searchQualitativeEvaluationCreation(SpeQECreVO speQECreVO) throws EventException;



	/**
	 * S/P Qualitative Evaulation Inquiry 조회
	 * @param SpeSpQualEvVO speSpQualEvVO
	 * @param SignOnUserAccount account
	 * @return List<SpeSpQualEvVO>
	 * @throws EventException
	 */
	public List<SpeSpQualEvVO> searchSPQualitativeEv(SpeSpQualEvVO speSpQualEvVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Qualitative Evaluation 목록 조회
	 * @param SpeSpQualEvVO speSpQualEvVO
	 * @param SignOnUserAccount account
	 * @return List<SpeSpQualEvVO>
	 * @throws EventException 
	 */
	public List<SpeSpQualEvVO> searchQualitativeEvaluation(SpeSpQualEvVO speSpQualEvVO,SignOnUserAccount account) throws EventException;

	/**
	 * Qualitative Evaluation 을 입력/수정한다.<br>
	 * @param speSpQualEvVOs
	 * @param account
	 * @return String 
	 */
	public String multiQualitativeEvaluation(SpeSpQualEvVO[] speSpQualEvVOs, SignOnUserAccount account) throws EventException;
	
}