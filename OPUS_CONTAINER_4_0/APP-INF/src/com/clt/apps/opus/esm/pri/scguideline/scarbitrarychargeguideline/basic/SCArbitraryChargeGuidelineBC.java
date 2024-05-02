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
package com.clt.apps.opus.esm.pri.scguideline.scarbitrarychargeguideline.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.scguideline.scarbitrarychargeguideline.vo.RsltPriSgArbTypeVO;
import com.clt.apps.opus.esm.pri.scguideline.scarbitrarychargeguideline.vo.RsltPriSgArbVO;
import com.clt.apps.opus.esm.pri.scguideline.scguidelinemain.vo.GlineMnCpVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSgArbVO;
import com.clt.syscommon.common.table.PriSgMnVO;

/**
 * Scguideline Business Logic Command Interface<br>
 * - Handling a biz logic about Scguideline<br>
 *
 * @author 
 * @see Ui_pri_0001_04EventResponse 
 * @since J2EE 1.4
 */

public interface SCArbitraryChargeGuidelineBC {
	/**
	 * Retrieving Arbitrary Charge Type의 Count.<br>
	 * 
	 * @param PriSgArbVO priSgArbVO
	 * @return List<RsltPriSgArbTypeVO>
	 * @exception EventException
	 */
	public List<RsltPriSgArbTypeVO> searchArbitraryChargeTypeCountList(PriSgArbVO priSgArbVO) throws EventException;	
	/**
	 * Retrieving Arbitrary Charge Guide Line List.<br>
	 * 
	 * @param PriSgArbVO priSgArbVO
	 * @return List<RsltPriSgArbVO>
	 * @exception EventException
	 */
	public List<RsltPriSgArbVO> searchArbitraryChargeGuidelineList(PriSgArbVO priSgArbVO) throws EventException;
	/**
	 * Saving Arbitrary Charge.<br>
	 * 
	 * @param PriSgArbVO[] priSgArbVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageArbitraryChargeGuideline(PriSgArbVO[] priSgArbVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * Deleting Arbitrary Charge.<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @exception EventException
	 */
	public void removeGuidelineMain(PriSgMnVO priSgMnVO) throws EventException;		
	
	/**
	 * Uploading excep datas<br>
	 * 
	 * @param PriSgArbVO[] priSgArbVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadArbitraryChargeGuideline(PriSgArbVO[] priSgArbVOs,SignOnUserAccount account) throws EventException;
		
	/**
	 * Copying Arbitray Guideline <br>
	 * 
	 * @param GlineMnCpVO glineMnCpVO
	 * @exception EventException
	 */
	public void copyGuidelineMain(GlineMnCpVO glineMnCpVO) throws EventException;
	
	/**
	 * Checking validation for excel file datas<br>
	 * 
	 * @param PriSgArbVO[] priSgArbVOs
	 * @return List<PriSgArbVO>
	 * @exception EventException
	 */
	public List<PriSgArbVO> searchCodeCheckResult(PriSgArbVO[] priSgArbVOs) throws EventException;
}