/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EvaluationGroupBC.java
*@FileTitle : Evaluation Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.egmaster.evaluationgroup.basic;

import java.util.List;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.esd.spe.egmaster.evaluationgroup.vo.SpeEGCreVO;

/**
 * ALPS-Egmaster Business Logic Command Interface<br>
 * - ALPS-Egmaster에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author HI
 * @see
 * @since J2EE 1.6
 */

public interface EvaluationGroupBC {

	/**
	 * EG 데이터를 입력/수정/삭제 한다.<br>
	 * 
	 * @param SpeEGCreVO[] speEGCreVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiEGCre(SpeEGCreVO[] speEGCreVOs,SignOnUserAccount account) throws EventException;
	

	/**
	 * EG 데이터를 조회한다.<br>
	 * 
	 * @param SpeEGCreVO speEGCreVO
	 * @return List<SpeEGCreVO>
	 * @exception EventException
	 */
	public List<SpeEGCreVO> searchEGData(SpeEGCreVO speEGCreVO) throws EventException;	
	
	
	/**
	 * 저장전 저장할수 있는 데이터 인지 확인한다..<br>
	 * 
	 * @param SpeEGCreVO speEGCreVO
	 * @return List<SpeEGCreVO>
	 * @exception EventException
	 */
	public List<SpeEGCreVO> searchEGDataChk(SpeEGCreVO speEGCreVO) throws EventException;	
}