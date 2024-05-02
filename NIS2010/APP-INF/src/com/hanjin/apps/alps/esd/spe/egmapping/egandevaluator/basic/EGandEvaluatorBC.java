/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EGandEvaluatorBC.java
*@FileTitle : EG vs Evaluator Mapping
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.egmapping.egandevaluator.basic;

import java.util.List;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.esd.spe.egmapping.egandevaluator.vo.SpeEGEVMappingVO;

/**
 * ALPS-Egmapping Business Logic Command Interface<br>
 * ALPS-Egmapping에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author HI
 * @see
 * @since J2EE 1.6
 */

public interface EGandEvaluatorBC {

	/**
	 * EG vs Evalulator Mapping 데이터를 조회한다.<br>
	 * 
	 * @param SpeEGEVMappingVO speEGEVMappingVO
	 * @return List<SpeEGEVMappingVO>
	 * @exception EventException
	 */
	public List<SpeEGEVMappingVO> searchEGEVBasic(SpeEGEVMappingVO speEGEVMappingVO) throws EventException;	
	
	/**
	 * EG vs Evalulator Mapping 데이터를 조회한다.<br>
	 * 
	 * @param SpeEGEVMappingVO speEGEVMappingVO
	 * @return List<SpeEGEVMappingVO>
	 * @exception EventException
	 */
	public List<SpeEGEVMappingVO> searchEGEVPerformance(SpeEGEVMappingVO speEGEVMappingVO) throws EventException;	
	
	/**
	 * EG vs Evalulator Mapping 데이터를 입력/수정/삭제 한다.<br>
	 * 
	 * @param SpeEGEVMappingVO[] speEGEVMappingVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiEGEVMapping(SpeEGEVMappingVO[] speEGEVMappingVOs,SignOnUserAccount account) throws EventException;	
	
}