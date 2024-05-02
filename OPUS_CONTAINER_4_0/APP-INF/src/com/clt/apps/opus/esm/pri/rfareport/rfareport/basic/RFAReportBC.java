/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAReportBC.java
*@FileTitle : RFA Proposal Creation ? Draft
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.rfareport.rfareport.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.rfareport.rfareport.vo.RsltRFARetRDInfoVO;
import com.clt.apps.opus.esm.pri.rfareport.rfareport.vo.RsltSearchRFAListVO;
import com.clt.apps.opus.esm.pri.rfareport.rfareport.vo.RsltSearchRFARateSearchListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriRpMnVO;

/**
 * Rfareport Business Logic Command Interface<br>
 * - Handling a biz logic about Rfareport<br>
 *
 * @author 
 * @see UI_PRI_2039, 2052 EventReponse 
 * @since J2EE 1.6
 */

public interface RFAReportBC {

	/**
	 * Retrieving information for RFAReport<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltRFARetRDInfoVO>
	 * @exception EventException
	 */
	public List<RsltRFARetRDInfoVO> searchRFARetrievalRDInfo(PriRpMnVO priRpMnVO) throws EventException;
	
	/**
	 * Retrieving RFA Search - RFA Retrieval List <br>
	 * @param RsltSearchRFAListVO rsltSearchRFAListVO
	 * @return List<RsltSearchRFAListVO>
	 * @exception EventException
	 */
	public List<RsltSearchRFAListVO> searchRFAList(RsltSearchRFAListVO rsltSearchRFAListVO) throws EventException;
	
	/**
	 * running backEndJob to Retrieve RFA Search - Rate Retrieval List<br>
     *
	 * @param SignOnUserAccount account
	 * @param RsltSearchRFARateSearchListVO rsltSearchRFARateSearchListVO
	 * @return String
	 * @exception EventException
	 */
	public String searchRFARateSearchListDoStart(SignOnUserAccount account, RsltSearchRFARateSearchListVO rsltSearchRFARateSearchListVO) throws EventException;

	/**
	 * Retrieving BackEndJob's status value<br>
	 * 
	 * @param String object
	 * @return String
	 * @exception EventException
	 */
	public String comBakEndJbVOs(String object) throws EventException;
	
}