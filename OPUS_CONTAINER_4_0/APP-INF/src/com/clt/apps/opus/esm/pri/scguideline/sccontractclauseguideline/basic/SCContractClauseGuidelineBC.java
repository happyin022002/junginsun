/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCContractClauseGuidelineBC.java
*@FileTitle : SC Guideline Contract Clause
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.sccontractclauseguideline.basic;

import com.clt.apps.opus.esm.pri.scguideline.sccontractclauseguideline.vo.CtrtCluzGlineVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSgCtrtCluzVO;
import com.clt.syscommon.common.table.PriSgMnVO;

/**
 * Scguideline Business Logic Command Interface<br>
 * - interface about Scguideline biz logic<br>
 *
 * @author 
 * @see Esm_pri_0001_07EventResponse 
 * @since J2EE 1.4
 */

public interface SCContractClauseGuidelineBC {
	/**
	 * handling retrieving event<br>
	 *  handling retrieving event about SCBasicStandardNoteGuideline <br>
	 * 
	 * @param PriSgCtrtCluzVO priSgCtrtCluzVO
	 * @param String searchGubun
	 * @return CtrtCluzGlineVO
	 * @exception EventException
	 */
	public CtrtCluzGlineVO searchContractClauseGuidelineList(PriSgCtrtCluzVO priSgCtrtCluzVO, String searchGubun) throws EventException;
	
	
	/**
	 * handling multiple event<br>
	 * saving contract clause <br>
	 * 
	 * @param CtrtCluzGlineVO ctrtCluzGlineVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageContractClauseGuideline(CtrtCluzGlineVO ctrtCluzGlineVO, SignOnUserAccount account) throws EventException;
	
	
	
	/**
	 * handling multiple event<br>
	 * deleting contract clause title, body<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @exception EventException
	 */
	public void removeGuidelineMain(PriSgMnVO priSgMnVO) throws EventException;
}