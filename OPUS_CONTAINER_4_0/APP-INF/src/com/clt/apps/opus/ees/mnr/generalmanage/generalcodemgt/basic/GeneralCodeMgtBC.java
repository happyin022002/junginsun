/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CEDEXCodeMgtBC.java
*@FileTitle : EQ Component
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.generalcodemgt.basic;

import java.util.List;

import com.clt.apps.opus.ees.mnr.generalmanage.generalcodemgt.vo.GeneralCodeMgtGRPVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.management.opus.codemanagement.vo.CodeMgmtDtlVO;
import com.clt.syscommon.management.opus.codemanagement.vo.CodeMgmtMstVO;
  
/**
 * COM-General manage Business Logic Command Interface<br>
 * - COM-General manage interface of business logic<br>
 *
 * @author 
 * @see Ees_mnr_0009EventResponse
 * @since J2EE 1.4
 */

public interface GeneralCodeMgtBC {
	
	/**
	 * [EES_MNR_0009]Retrieving "M&R Other Code" data<br>
	 *
	 * @param GeneralCodeMgtGRPVO generalCodeMgtGRPVO
	 * @return GeneralCodeMgtGRPVO
	 * @exception EventException
	 */
	public GeneralCodeMgtGRPVO searchGeneralCodeListBasic(GeneralCodeMgtGRPVO generalCodeMgtGRPVO) throws EventException;

	/**
	 * [EES_MNR_0009]Adding, modifying, deleting "M&R Other Code" data<br>
	 *
	 * @param GeneralCodeMgtGRPVO generalCodeMgtGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGeneralCodeBasic(GeneralCodeMgtGRPVO generalCodeMgtGRPVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0009]Retrieving "M&R Other Code" data<br>
	 *
	 * @param GeneralCodeMgtGRPVO generalCodeMgtGRPVO
	 * @return GeneralCodeMgtGRPVO
	 * @exception EventException
	 */
	public GeneralCodeMgtGRPVO searchGeneralCodeBasic(GeneralCodeMgtGRPVO generalCodeMgtGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0009]Adding, modifying, deleting "M&R Manage Code" data<br>
	 *
	 * @param List<CodeMgmtMstVO> codeMgmtMstVOs
	 * @exception EventException
	 */
	public void manageIntgCdToMnrBasic(List<CodeMgmtMstVO> codeMgmtMstVOs) throws EventException;
	
	/**
	 * [EES_MNR_0009]Adding, modifying, deleting "M&R Manage Code" data<br>
	 *
	 * @param List<CodeMgmtDtlVO> codeMgmtDtlVOs
	 * @exception EventException
	 */
	public void manageIntgDtlCdToMnrBasic(List<CodeMgmtDtlVO> codeMgmtDtlVOs) throws EventException;
} 