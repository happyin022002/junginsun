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
package com.hanjin.apps.alps.esm.pri.rfaguideline.rfaarbitrarychargeguideline.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.rfaguideline.rfaarbitrarychargeguideline.vo.RsltPriRgArbTypeVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfaarbitrarychargeguideline.vo.RsltPriRgArbVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfaguidelinemain.vo.RsltRfaGlineCopyVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRgArbVO;
import com.hanjin.syscommon.common.table.PriRgMnVO;

/**
 * NIS2010-RFAguideline Business Logic Command Interface<br>
 * - NIS2010-RFAguideline에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author JaeYeon Kim
 * @see Ui_pri_0002_03EventResponse 참조
 * @since J2EE 1.4
 */

public interface RFAArbitraryChargeGuidelineBC {
	
	/**
	 * Arbitrary List 갯수와 font type을 조회한다. <br>
	 * 
	 * @param PriRgArbVO priRgArbVO
	 * @return List<RsltPriRgArbTypeVO>
	 * @exception EventException
	 */
	public List<RsltPriRgArbTypeVO> searchArbitraryChargeTypeCountList(PriRgArbVO priRgArbVO) throws EventException;	

	/**
	 * Guideline Arbitrary를 조회합니다. <br>
	 * 
	 * @param PriRgArbVO priRgArbVO
	 * @return List<RsltPriRgArbVO>
	 * @exception EventException
	 */
	public List<RsltPriRgArbVO> searchArbitraryChargeGuidelineList(PriRgArbVO priRgArbVO) throws EventException;
	
	/**
	 * Guideline Arbitrary를 수정합니다. <br>
	 * 
	 * @param PriRgArbVO[] priRgArbVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageArbitraryChargeGuideline(PriRgArbVO[] priRgArbVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Guideline main에서 전체 Guideline를 삭제합니다. <br>
	 * 
	 * @param PriRgMnVO priRgMnVO
	 * @exception EventException
	 */
	public void removeGuidelineMain(PriRgMnVO priRgMnVO) throws EventException;		
	
	/**
	 * 엑셀파일을 업로드합니다.<br>
	 * 
	 * @param PriRgArbVO[] priRgArbVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadArbitraryChargeGuideline(PriRgArbVO[] priRgArbVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * 엑셀파일을 체크합니다.
	 * 
	 * @param PriRgArbVO[] priRgArbVO
	 * @return List<PriRgArbVO>
	 * @exception EventException
	 */
	public List<PriRgArbVO> searchCodeCheckResult(PriRgArbVO[] priRgArbVO) throws EventException;

    /**
     * RFA Guideline Arbitrary Charge 정보를 Copy 합니다.<br>
     * 
     * @param RsltRfaGlineCopyVO rsltRfaGlineCopyVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyGuidelineMain(RsltRfaGlineCopyVO rsltRfaGlineCopyVO, SignOnUserAccount account) throws EventException;
}