/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGOHChargeGuidelineBC.java
*@FileTitle : S/C GOH Guideline Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0

=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scgohchargeguideline.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.scguideline.scgohchargeguideline.vo.RsltPriSgGohChgVO;
import com.clt.apps.opus.esm.pri.scguideline.scguidelinemain.vo.GlineMnCpVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSgGohChgVO;
import com.clt.syscommon.common.table.PriSgMnVO;

/**
 * Scguideline Business Logic Command Interface<br>
 * - handling a biz logic about Scguideline<br>
 *
 * @author 
 * @see Ui_pri_0001_005EventResponse 
 * @since J2EE 1.4
 */

public interface SCGOHChargeGuidelineBC {
	/**
	 * Retrieving S/C Guideline GOH Charge information<br>
	 * 
	 * @param PriSgGohChgVO priSgGohChgVO
	 * @return List<RsltPriSgGohChgVO>
	 * @exception EventException
	 */
	public List<RsltPriSgGohChgVO> searchGOHChargeGuidelineList(PriSgGohChgVO priSgGohChgVO) throws EventException;
	/**
	 * Saving GOHChargeGuideline.<br>
	 * 
	 * @param PriSgGohChgVO[] priSgGohChgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGOHChargeGuideline(PriSgGohChgVO[] priSgGohChgVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * Deleting GOHChargeGuideline.<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @exception EventException
	 */
	public void removeGuidelineMain(PriSgMnVO priSgMnVO) throws EventException;		
	
	/**
	 * Copying GOH Guideline <br>
	 * 
	 * @param GlineMnCpVO glineMnCpVO
	 * @exception EventException
	 */
	public void copyGuidelineMain(GlineMnCpVO glineMnCpVO) throws EventException;
}