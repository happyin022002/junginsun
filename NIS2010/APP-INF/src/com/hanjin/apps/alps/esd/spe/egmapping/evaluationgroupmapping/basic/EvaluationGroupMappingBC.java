/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EvaluationGroupMappingBC.java
*@FileTitle : Evaluation Group Mapping & Basic Evaluation
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.egmapping.evaluationgroupmapping.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.spe.egmapping.evaluationgroupmapping.vo.EGAndBEMappingVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Egmapping Business Logic Command Interface<br>
 * - ALPS-Egmapping에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author HI
 * @see
 * @since J2EE 1.6
 */

public interface EvaluationGroupMappingBC {

	/**
	 * Basic Evaluation 데이터가 저장가능 한지 확인한다.<br>
	 * 
	 * @param EGAndBEMappingVO	egAndBEMappingVO
	 * @return List<EGAndBEMappingVO>
	 * @exception EventException
	 */
	public List<EGAndBEMappingVO> searchEGBEMappingChk(EGAndBEMappingVO egAndBEMappingVO) throws EventException;
	
	/**
	 * Evaluation Group Mapping & Basic Evaluation 화면을 조회한다.<br>
	 * 
	 * @param EGAndBEMappingVO	egAndBEMappingVO
	 * @return List<EGAndBEMappingVO>
	 * @exception EventException
	 */
	public List<EGAndBEMappingVO> searchEGBEMapping(EGAndBEMappingVO egAndBEMappingVO) throws EventException;
	
	/**
	 * Basic Evaluation 데이터를 조회한다.<br>
	 * 
	 * @param EGAndBEMappingVO	egAndBEMappingVO
	 * @return List<EGAndBEMappingVO>
	 * @exception EventException
	 */
	public List<EGAndBEMappingVO> searchBECode(EGAndBEMappingVO egAndBEMappingVO) throws EventException;
	
	/**
	 * Basic Evaluation 데이터를 입력/수정/삭제 한다.<br>
	 * 
	 * @param EGAndBEMappingVO[] egAndBEMappingVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiEGBEMapping(EGAndBEMappingVO[] egAndBEMappingVOs,SignOnUserAccount account) throws EventException;	
}