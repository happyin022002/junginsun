/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCArbitraryChargeGuidelineBC.java
*@FileTitle : Origin/Destination Arbitrary Charge Guideline Creation
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaguideline.rfaarbitrarychargeguideline.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.rfaguideline.rfaarbitrarychargeguideline.vo.RsltPriRgArbTypeVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfaarbitrarychargeguideline.vo.RsltPriRgArbVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfaguidelinemain.vo.RsltRfaGlineCopyVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriRgArbVO;
import com.clt.syscommon.common.table.PriRgMnVO;

/**
 * RFAguideline Business Logic Command Interface<br>
 * - Handling a biz logic about RFAguideline<br>
 *
 * @author 
 * @see Ui_pri_0002_03EventResponse 
 * @since J2EE 1.4
 */

public interface RFAArbitraryChargeGuidelineBC {
	
	/**
	 * Retrieving count of Arbitrary List and font type <br>
	 * 
	 * @param PriRgArbVO priRgArbVO
	 * @return List<RsltPriRgArbTypeVO>
	 * @exception EventException
	 */
	public List<RsltPriRgArbTypeVO> searchArbitraryChargeTypeCountList(PriRgArbVO priRgArbVO) throws EventException;	

	/**
	 * Retrieving Guideline Arbitrary <br>
	 * 
	 * @param PriRgArbVO priRgArbVO
	 * @return List<RsltPriRgArbVO>
	 * @exception EventException
	 */
	public List<RsltPriRgArbVO> searchArbitraryChargeGuidelineList(PriRgArbVO priRgArbVO) throws EventException;
	
	/**
	 * Modifying Guideline Arbitrary <br>
	 * 
	 * @param PriRgArbVO[] priRgArbVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageArbitraryChargeGuideline(PriRgArbVO[] priRgArbVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Deleting total guideline from Guideline main <br>
	 * 
	 * @param PriRgMnVO priRgMnVO
	 * @exception EventException
	 */
	public void removeGuidelineMain(PriRgMnVO priRgMnVO) throws EventException;		
	
	/**
	 * Uplading excel file<br>
	 * 
	 * @param PriRgArbVO[] priRgArbVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadArbitraryChargeGuideline(PriRgArbVO[] priRgArbVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Checking excel file<br>
	 * 
	 * @param PriRgArbVO[] priRgArbVO
	 * @return List<PriRgArbVO>
	 * @exception EventException
	 */
	public List<PriRgArbVO> searchCodeCheckResult(PriRgArbVO[] priRgArbVO) throws EventException;

    /**
     *Copying RFA Guideline Arbitrary Charge information<br>
     * 
     * @param RsltRfaGlineCopyVO rsltRfaGlineCopyVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyGuidelineMain(RsltRfaGlineCopyVO rsltRfaGlineCopyVO, SignOnUserAccount account) throws EventException;
}