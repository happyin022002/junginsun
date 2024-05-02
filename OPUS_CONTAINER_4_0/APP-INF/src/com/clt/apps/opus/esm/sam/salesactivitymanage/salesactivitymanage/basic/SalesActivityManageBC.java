/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SalesActivityManageBC.java
*@FileTitle : Sales Activity Report
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.09
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2011.05.09 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.basic;

import java.util.List;
import com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.vo.SRepInfoVO;
import com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.vo.SamActivityInfoVO;
import com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.vo.SamActivityInputVO;
import com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.vo.SamPFMCbyCustInputVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-Salesactivitymanage Business Logic Command Interface<br>
 * - OPUS-Salesactivitymanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author LEEKUANSIAN
 * @see SalesActivityManageBC
 * @since J2EE 1.6
 */

public interface SalesActivityManageBC {
	
	/**
	 * EMS_SAM_0008
	 * [Sheet1]을 [조회] 합니다.<br>
	 * 
	 * @param SRepInfoVO	sRepInfoVO
	 * @return List<SRepInfoVO>
	 * @exception EventException
	 * @throws DAOException 
	 */
	public List<SRepInfoVO> searchSalesReportInfo(SRepInfoVO sRepInfoVO) throws EventException, DAOException;
	
	/**
	 * ESM_SAM_0008
	 * [Sheet1]을 [저장] 합니다.<br>
	 * @param SRepInfoVO[] sRepInfoVOs
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse manageSalesReportInfo(SRepInfoVO[] sRepInfoVOs, SignOnUserAccount account) throws EventException, DAOException;
	
	/**
	 * EMS_SAM_0008
	 * [Sheet2]을 [조회] 합니다.<br>
	 * 
	 * @param SRepInfoVO	sRepInfoVO
	 * @return List<SRepInfoVO>
	 * @exception EventException
	 * @throws DAOException 
	 */
	public List<SRepInfoVO> searchCustSatisFaction(SRepInfoVO sRepInfoVO) throws EventException, DAOException;
	
	/**
	 * ESM_SAM_0008
	 * [Sheet2]을 [저장] 합니다.<br>
	 * @param SRepInfoVO[] sRepInfoVOs
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse manageCustSatisFaction(SRepInfoVO[] sRepInfoVOs, SignOnUserAccount account) throws EventException, DAOException;

	/**
	 * ESM_SAM_0901 : Retrieve<br>
	 * ESM_SAM_0007 : Retrieve<br>
	 * 
	 * @param SamActivityInputVO samActivityInputVO
	 * @return List<SamActivityInputVO>
	 * @exception EventException
	 */
	public List<SamActivityInputVO> searchSalesActivityList(SamActivityInputVO samActivityInputVO) throws EventException;
	
	/**
	 * ESM_SAM_0009 : Retrieve<br>
	 * 
	 * @param SamPFMCbyCustInputVO	samPFMCbyCustInputVO
	 * @return List<SamPFMCbyCustInputVO>
	 * @exception EventException
	 */
	public List<SamPFMCbyCustInputVO> searchPFMCbyCustList(SamPFMCbyCustInputVO samPFMCbyCustInputVO) throws EventException;

	/**
	 * ESM_SAM_0007 : Save<br>
	 * 
	 * @param SamActivityInfoVO[] samActivityInfoVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSalesActivityInfo(SamActivityInfoVO[] samActivityInfoVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SAM_0007 : CUS_NAME<br>
	 * CUS_NAME 확인  <br>
	 * 
	 * @param SamActivityInfoVO samActivityInfoVO
	 * @return String
	 * @exception EventException
	 */
	public String searchCustName(SamActivityInfoVO samActivityInfoVO) throws EventException;
	
	/**
	 * ESM_SAM_0007 : CUS_NAME<br>
	 * CUS_NAME 확인  <br>
	 * 
	 * @param SamActivityInfoVO samActivityInfoVO
	 * @return String
	 * @exception EventException
	 */
	public String searchSrepsManageCustList(SamActivityInfoVO samActivityInfoVO) throws EventException;
	
	
	/**
	 * ESM_SAM_0008 : srep_cd On_change<br>
	 * @param SRepInfoVO  sRepInfoVO 
	 * @return void
	 * @exception EventException
	 * 
	 */
	public String searchSalesRepName(SRepInfoVO sRepInfoVO)throws EventException;
	
}