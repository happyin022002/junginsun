/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TermChangeBC.java
*@FileTitle : Term Change Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.termchange.basic;

import java.util.List;

import com.clt.apps.opus.ees.lse.containerleasemgt.termchange.vo.SearchParamVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.termchange.vo.TermChangeCreationVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.termchange.vo.TermChangeInquiryVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * Containerleasemgt Business Logic Command Interface<br>
 * Containerleasemgt Biz Logic Interface<br>
 *
 * @author 
 * @see Ees_lse_0005EventResponse 
 * @since J2EE 1.6
 */

public interface TermChangeBC {

	/**
	 * Verifying Effectiveness about inserted Activity Date<br>
	 *
	 * @param searchParamVO searchParamVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean searchAvailParamActivityDateBasic(SearchParamVO searchParamVO) throws EventException;

	/**
	 * Retrieving Equipment List targeting to Term Change Creation<br>
	 *
	 * @param searchParamVO SearchParamVO
	 * @return List<TermChangeCreationVO>
	 * @exception EventException
	 */
	public List<TermChangeCreationVO> searchTermChangeCreationListBasic(SearchParamVO searchParamVO) throws EventException;

	/**
	 * Retrieving Term Change Creation Equipment handling record<br>
	 *
	 * @param searchParamVO SearchParamVO
	 * @return List<TermChangeInquiryVO>
	 * @exception EventException
	 */
	public List<TermChangeInquiryVO> searchTermChangeInquiryListBasic(SearchParamVO searchParamVO) throws EventException;
	
	/**
	 *
	 * @param SearchParamVO[] searchParamVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */ 
	public String createLseTempBasic(SearchParamVO[] searchParamVOs,SignOnUserAccount account) throws EventException;
	

	/**
	 *
	 * @param searchParamVO SearchParamVO
	 * @return List<TermChangeCreationVO>
	 * @exception EventException
	 */
	public List<TermChangeCreationVO> searchBigDataTermChangeCreationListBasic(SearchParamVO searchParamVO) throws EventException;
}