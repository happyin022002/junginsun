/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCArbitraryChargeGuidelineBC.java
*@FileTitle : Origin/Destination Arbitrary Charge Guideline Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.17
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.04.17 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scarbitrarychargeguideline.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.scguideline.scarbitrarychargeguideline.vo.RsltPriSgArbTypeVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scarbitrarychargeguideline.vo.RsltPriSgArbVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.vo.GlineMnCpVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSgArbVO;
import com.hanjin.syscommon.common.table.PriSgMnVO;

/**
 * NIS2010-Scguideline Business Logic Command Interface<br>
 * - NIS2010-Scguideline에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kong Back Jin
 * @see Ui_pri_0001_04EventResponse 참조
 * @since J2EE 1.4
 */

public interface SCArbitraryChargeGuidelineBC {
	/**
	 * Arbitrary Charge Type의 Count를 조회합니다.<br>
	 * 
	 * @param PriSgArbVO priSgArbVO
	 * @return List<RsltPriSgArbTypeVO>
	 * @exception EventException
	 */
	public List<RsltPriSgArbTypeVO> searchArbitraryChargeTypeCountList(PriSgArbVO priSgArbVO) throws EventException;	
	/**
	 * Arbitrary Charge Guide Line List를 조회합니다.<br>
	 * 
	 * @param PriSgArbVO priSgArbVO
	 * @return List<RsltPriSgArbVO>
	 * @exception EventException
	 */
	public List<RsltPriSgArbVO> searchArbitraryChargeGuidelineList(PriSgArbVO priSgArbVO) throws EventException;
	/**
	 * Arbitrary Charge를 저장합니다.<br>
	 * 
	 * @param PriSgArbVO[] priSgArbVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageArbitraryChargeGuideline(PriSgArbVO[] priSgArbVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * Arbitrary Charge를 삭제합니다.<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @exception EventException
	 */
	public void removeGuidelineMain(PriSgMnVO priSgMnVO) throws EventException;		
	
	/**
	 * 엑셀로드 팝업에 대한 엑셀로드 처리<br>
	 * 
	 * @param PriSgArbVO[] priSgArbVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadArbitraryChargeGuideline(PriSgArbVO[] priSgArbVOs,SignOnUserAccount account) throws EventException;
		
	/**
	 * Arbitray Guideline Copy를 처리합니다. <br>
	 * 
	 * @param GlineMnCpVO glineMnCpVO
	 * @exception EventException
	 */
	public void copyGuidelineMain(GlineMnCpVO glineMnCpVO) throws EventException;
	
	/**
	 * 엑셀파일 데이터를 VALIDATION 체크한다.<br>
	 * 
	 * @param PriSgArbVO[] priSgArbVOs
	 * @return List<PriSgArbVO>
	 * @exception EventException
	 */
	public List<PriSgArbVO> searchCodeCheckResult(PriSgArbVO[] priSgArbVOs) throws EventException;
}