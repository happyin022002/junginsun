/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AgreementNoticeBC.java
*@FileTitle : AgreementNoticeBC.java
*Open Issues :
*Change history :
*@LastModifyDate : 2014-01-24
*@LastModifier : 
*@LastVersion : 1.0
* 2014-01-24
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.agreementnotice.basic;

import java.util.List;

import com.hanjin.bizcommon.agreementnotice.vo.CodeNameVO;
import com.hanjin.bizcommon.agreementnotice.vo.SearchAgreementListVO;
import com.hanjin.bizcommon.agreementnotice.vo.SearchContractCreationUserVO;
import com.hanjin.bizcommon.agreementnotice.vo.SearchMailingListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.framework.component.rowset.DBRowSet;


/**
 * ENIS-BIZCOMMON Business Logic Command Interface<br>
 * - ENIS-BIZCOMMON에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author yj jeon
 * @see ComNtc0001EventResponse 참조
 * @since J2EE 1.4
 */
public interface AgreementNoticeBC  {
	
	/**
	 *  Pop-up Notice User 조회 
	 * 
	 * @param String user_id
	 * @param String pgm_no
	 * @return String
	 * @exception EventException 
	 */
	public String searchNoticeUser(String user_id, String pgm_no) throws EventException;

	/**
	 *  Notice Agreement List 조회 
	 * 
	 * @param String user_id
	 * @param String pgm_no
	 * @return List<SearchAgreementListVO>
	 * @exception EventException 
	 */
	public List<SearchAgreementListVO> searchAgreementList(String user_id, String pgm_no) throws EventException;
	
	/**
     * COM_NTC_0001 : System Name Combo
	 * 
	 * @return List<CodeNameVO>
	 * @exception EventException 
	 */
	public List<CodeNameVO> searchSystemName() throws EventException;    
	
	/**
     * COM_NTC_0001 : Office Level Combo
	 * @param CodeNameVO codeNameVO
	 * @return List<CodeNameVO>
	 * @exception EventException 
	 */
	public List<CodeNameVO> searchOfficeLevel(CodeNameVO codeNameVO) throws EventException; 
	
	/**
     * COM_NTC_0001 : Search User Name
	 * 
	 * @param CodeNameVO codeNameVO
	 * @return String
	 * @exception EventException 
	 */
	public String searchUserName(CodeNameVO codeNameVO) throws EventException; 
	
	/**
     * COM_NTC_0001 : Search Office valid
	 * 
	 * @param String cd
	 * @param String nm
	 * @return String
	 * @exception EventException 
	 */
	public String searchOfficeValid(String cd, String nm) throws EventException;
	
	/**
     * COM_NTC_0001 : Retrieve
	 * 
	 * @param SearchMailingListVO searchMailingListVO
	 * @return DBRowSet
	 * @exception EventException 
	 */
	public DBRowSet searchMailingList(SearchMailingListVO searchMailingListVO) throws EventException; 
	
	/**
     * COM_NTC_0001 : Save
	 * 
	 * @param SearchMailingListVO[] searchMailingListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException 
	 */
	public void manageMailingList(SearchMailingListVO[] searchMailingListVOs, SignOnUserAccount account) throws EventException;    

	/**
     * COM_NTC_0002 : Retrieve
	 * 
	 * @param SearchContractCreationUserVO searchContractCreationUserVO
	 * @return List<SearchContractCreationUserVO>
	 * @exception EventException 
	 */
	public List<SearchContractCreationUserVO> searchContractCreationUser(SearchContractCreationUserVO searchContractCreationUserVO) throws EventException;
}