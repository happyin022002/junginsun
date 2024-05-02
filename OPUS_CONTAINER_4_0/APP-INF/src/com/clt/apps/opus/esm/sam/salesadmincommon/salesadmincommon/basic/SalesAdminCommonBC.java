/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SalesAdminCommonBC.java
*@FileTitle : Sales Activity Item
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.11
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2011.05.11 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.salesadmincommon.salesadmincommon.basic;

import java.util.List;

import com.clt.apps.opus.esm.sam.salesadmincommon.salesadmincommon.vo.SamActTpMstVO;
import com.clt.apps.opus.esm.sam.salesadmincommon.salesadmincommon.vo.SearchActItemMstVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SamSlsActTpDtlVO;
import com.clt.syscommon.common.table.SamSlsActVO;

/**
 * ALPS-Salesadmincommon Business Logic Command Interface<br>
 * - ALPS-Salesadmincommon에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author NAMKOONGJINHO
 * @see SalesAdminCommonBC
 * @since J2EE 1.6
 */

public interface SalesAdminCommonBC { 

	/**
	 * [Sheet1]을 [조회] 합니다.<br>
	 * 
	 * @param SearchActItemMstVO	searchActItemMstVO
	 * @return List<SearchActItemMstVO>
	 * @exception EventException
	 */
	public List<SearchActItemMstVO> searchActItemMstList(SearchActItemMstVO searchActItemMstVO) throws EventException;
	
	/**
	 * [Sheet2]을 [조회] 합니다.<br>
	 * 
	 * @param SearchActItemMstVO	searchActItemMstVO
	 * @return List<SearchActItemMstVO>
	 * @exception EventException
	 */
	public List<SearchActItemMstVO> searchActItemDtlList(SearchActItemMstVO searchActItemMstVO) throws EventException;
	
	/**
	 * [Sheet1]을 [저장] 합니다.<br>
	 * @param SamActTpMstVO[] samActTpMstVOs
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 * @exception DAOException
	 */
	public EventResponse manageActItemMstList(SamActTpMstVO[] samActTpMstVOs, SignOnUserAccount account) throws EventException, DAOException;	
	
	
	/**
	 * [Sheet2]를 [저장] 합니다.<br>
	 * @param SamSlsActTpDtlVO[] samSlsActTpDtlVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 * @exception DAOException
	 */
	public void manageActDtlList(SamSlsActTpDtlVO[] samSlsActTpDtlVOS, SignOnUserAccount account) throws EventException, DAOException;
	
	
	/**
	 * Customer Code 를 체크합니다.<br>
	 * 
	 * @param String custCd
	 * @return String
	 * @exception EventException
	 */
	public String checkCustomerCode(String custCd) throws EventException;
	
	
	/**
	 * CR Customer Code 를 체크합니다.<br>
	 * 
	 * @param String custCd
	 * @return String
	 * @exception EventException
	 */
	public String checkCrCustomerCode(String custCd) throws EventException;
	
	/**
	 * Cntc Customer Code 를 체크합니다.<br>
	 * 
	 * @param String custCd
	 * @return String
	 * @exception EventException
	 */
	public String checkCntcCustomerCode(String custCd) throws EventException;
	
	
	/**
	 * Customer Code와 Name 을 체크합니다.<br>
	 * 
	 * @param String custCdNm
	 * @return String
	 * @exception EventException
	 */
	public String checkCustCodeName(String custCdNm) throws EventException;
	
	
	/**
	 * Group Customer Name 을 가져옵니다.<br>
	 * 
	 * @param String grpCustCd
	 * @return String
	 * @exception EventException
	 */
	public String getGroupCustName(String grpCustCd) throws EventException;

	
	/**
	 * Office Code 를 체크합니다.<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String checkOfficeCd(String ofcCd) throws EventException;
	
	
	/**
	 * Sales Repository Code 를 체크합니다.<br>
	 * 
	 * @param String sRepCd
	 * @return String
	 * @exception EventException
	 */
	public String checkSalesRepCode(String sRepCd) throws EventException;

	
	/**
	 * User Authority 를 가져옵니다.<br>
	 * 
	 * @param String usrAuth
	 * @return String
	 * @exception EventException
	 */
	public String getUserAuth(SignOnUserAccount account) throws EventException;
	
	
	/**
	 * Location Code 를 가져옵니다.<br>
	 * 
	 * @param String locCd
	 * @return String
	 * @exception EventException
	 */
	public String checkLocCode(String locCd) throws EventException;
	
	
	/**
	 * Office Team Code 를 가져옵니다.<br>
	 * 
	 * @param String ofcTeamCd
	 * @return String
	 * @exception EventException
	 */
	public String checkOfcTeamCode(String ofcTeamCd) throws EventException;
	
	
	/**
     * 기능 : default combo,ibsheet codelist를 return <p>
     * 
     * @param GeneralEventResponse eventResponse
     * @param String[][] array
     * @return GeneralEventResponse
     * @throws EventException
     */
	public GeneralEventResponse searchCommonCodeList(GeneralEventResponse eventResponse,String[][] array) throws EventException ;
	
	
	/**
	 * Customer의 Activity를 실행한 Sales Rep을 조회합니다.<br>
	 * 
	 * @param SamSlsActVO samSlsActVO
	 * @return String
	 * @exception EventException
	 */
	public String checkSrepByActivity(SamSlsActVO samSlsActVO) throws EventException;
	
}