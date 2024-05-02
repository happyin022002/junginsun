/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SCGuidelineMainBC.java
 *@FileTitle : Guideline Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scsalesguideline.basic;

import java.util.List;

import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSgMnVO;
import com.clt.syscommon.common.table.PriSgSlsRefVO;

/**
 * Scguideline Business Logic Command Interface<br>
 * - Handling a biz logic about Scguideline<br>
 * 
 * @author 
 * @see Ui_pri_0001EventResponse
 * @since J2EE 1.4
 */

public interface SCSalesGuidelineBC {
	/**
	 * Retrieving Sales Guideline <br>
	 * 
	 * @param PriSgSlsRefVO priSgSlsRefVO
	 * @return List<PriSgSlsRefVO>
	 * @exception EventException
	 */
	public List<PriSgSlsRefVO> searchSalesGuidelineList(PriSgSlsRefVO priSgSlsRefVO) throws EventException;

	/**
	 * Handling CUD Multi-event of Sales Guideline data <br>
	 * 
	 * @param PriSgSlsRefVO[] priSgSlsRefVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSalesGuideline(PriSgSlsRefVO[] priSgSlsRefVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Deleting from guideline from Guideline Main<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @exception EventException
	 */
	public void removeGuidelineMain(PriSgMnVO priSgMnVO) throws EventException;

}