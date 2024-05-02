/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EmptyReleaseRedeliveryOrderMgtBC.java
*@FileTitle : EmptyReleaseRedeliveryOrderMgtBC
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.basic;

import java.util.List;

import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.CimCStockVO;
import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.CimTerritoryVO;
import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.MdmCountryVO;
import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.MdmOrganizationVO;
import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.RDFaxMailEAIVO;
import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.SearchTerritoryForMultiComboVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CrossItemVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-Emptyreleaseredeliveryordermgt Business Logic Command Interface<br>
 *
 * @author 
 * @see Ees_ctm_0428EventResponse reference
 * @see Ees_ctm_0426EventResponse reference
 * @see Ees_ctm_0451EventResponse reference
 * @see Ees_ctm_0429EventResponse reference
 * @since J2EE 1.6
 */
public interface EmptyReleaseRedeliveryOrderMgtBC {

	/**
	 * EES_CTM_0428 : retrieving Territory List
	 *
	 * @param CimTerritoryVO cimTerritoryVO
	 * @return List<CimTerritoryVO>
	 * @exception EventException
	 */
	public List<CimTerritoryVO> searchTerritoryList(CimTerritoryVO cimTerritoryVO) throws EventException;

	/**
	 * EES_CTM_0428 : retrieving Country List
	 *
	 * @param MdmCountryVO mdmCountryVO
	 * @return List<MdmCountryVO>
	 * @exception EventException
	 */
	public List<MdmCountryVO> selectComboCountry(MdmCountryVO mdmCountryVO) throws EventException;

	/**
	 * EES_CTM_0428 : retrieving Organization List
	 *
	 * @param MdmOrganizationVO mdmOrganizationVO
	 * @return List<MdmOrganizationVO>
	 * @exception EventException
	 */
	public List<MdmOrganizationVO> selectComboOrganization(MdmOrganizationVO mdmOrganizationVO) throws EventException;

	/**
	 * EES_CTM_0428 : handling multiple event for CimTerritory
	 *
	 * @param CimTerritoryVO[] cimTerritoryVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTerritory(CimTerritoryVO[] cimTerritoryVOs, SignOnUserAccount account) throws EventException;

	/**
	 * EES_CTM_0426 : retrieving TerritoryList according to user's office code for Multicombo
	 *
	 * @param String ofcCd
	 * @return List<SearchTerritoryForMultiComboVO>
	 * @throws EventException
	 */
    public List<SearchTerritoryForMultiComboVO> searchTerritoryForMultiCombo(String ofcCd) throws EventException;

	/**
	 * EES_CTM_0426 : retrieving CimCStock IssueList
	 *
	 * @param CimCStockVO cimCStockVO
	 * @return List<CimCStockVO>
	 * @exception EventException
	 */
	public List<CimCStockVO> searchIssueList(CimCStockVO cimCStockVO) throws EventException;

	/**
	 * EES_CTM_0426 : settling CimCStock IssuedOrder
	 *
	 * @param CimCStockVO[] cimCStockVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void settleIssuedOrder(CimCStockVO[] cimCStockVOs, SignOnUserAccount account) throws EventException;

	/**
	 * EES_CTM_0426 : retrieving fax information for RD
	 *
	 * @param CimCStockVO[] cimCStockVOs
	 * @return String
	 * @exception EventException
	 */
	public String searchRDContent(CimCStockVO[] cimCStockVOs) throws EventException;

	/**
	 * EES_CTM_0426 : retrieving related data to be saved after sending fax
	 *
	 * @param CimCStockVO cimCStockVO
	 * @return List<CimCStockVO>
	 * @exception EventException
	 */
	public List<CimCStockVO> searchForSendFaxEmail(CimCStockVO cimCStockVO) throws EventException;

	/**
	 * EES_CTM_0426 : handling multiple event about fax result(STOCK table)
	 *
	 * @param List<CimCStockVO> cimCStockVOs
	 * @exception EventException
	 */
	public void manageSTKsendFaxEmail(List<CimCStockVO> cimCStockVOs) throws EventException;

	/**
	 * EES_CTM_0426 : retrieving loc_cd for user ID 
	 *
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */
	public String getUserLocCd(String userId) throws EventException;

	/**
	 * EES_CTM_0426 : retrieving So_Ofc and NextVAL for Redelivery-M-Issued
	 *
	 * @param String userOfcCd
	 * @return String[]
	 * @exception EventException
	 */
	public String[] getSoOfcNextVal(String userOfcCd) throws EventException;

	/**
	 * EES_CTM_0426 : getting FAX No and  Email for Yard Code
	 *
	 * @param String yardCd
	 * @return String[]
	 * @throws EventException
	 */
	public String[] getYardFaxEmailInfo(String yardCd) throws EventException;

	/**
	 * BackEndJob - returning BackEndJob status
	 *
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String comBackEndJob(String key) throws EventException;

	/**
	 * EES_CTM_0429 : starting BackEndJob
	 *
	 * @param SignOnUserAccount account
	 * @param CimCStockVO cimCStockVO
	 * @return String
	 * @exception EventException, BackEndJobException
	 */
	public String doBackEndJobSettledOrderList(SignOnUserAccount account, CimCStockVO cimCStockVO);

	/**
	 * EES_CTM_0429 : retrieving CimCStock SettledOrderList
	 *
	 * @param String key
	 * @return List<CimCStockVO>
	 * @exception EventException
	 */
	public List<CimCStockVO> searchSettledOrderList(String key) throws EventException;

	/**
	 * EES_CTM_0429 : handling multiple event for SettledOrderList (STOCK table)
	 *
	 * @param CimCStockVO[] cimCStockVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSTKRecovery(CimCStockVO[] cimCStockVOs, SignOnUserAccount account) throws EventException;

	/**
	 * EES_CTM_0426 : RD Fax/Mail Send (btn_confirm in EES_CTM_0451)
	 *
	 * @param String issueType
	 * @param RDFaxMailEAIVO rdFaxMailEAIVO
	 * @return String
	 * @exception EventException
	 */
	public String rdFaxMailSend(String issueType, RDFaxMailEAIVO rdFaxMailEAIVO) throws EventException;

	/**
	 *  EES_CTM_0426 : retrieving RD Content
	 *
	 * @param String stkFaxSndNo
	 * @return String
	 * @exception EventException
	 */
	public String searchCimFaxSndInfo(String stkFaxSndNo) throws EventException;

	/**
	 * CTM Common : updating STOCK in case server is EUR when registering CTM MOVEMENT
	 *
	 * @param CrossItemVO crossItemVO
	 */
	public void updateCimCntrStk(CrossItemVO crossItemVO);
	
	/**
	 * EES_CTM_0426 : EDI Send (EES_CTM_0451의 btn_confirm)
	 *
	 * @param CimCStockVO[] cimCStockVOs
	 * @return String
	 * @exception EventException
	 */
	public String sendEdi(CimCStockVO[] cimCStockVOs) throws EventException;	
	
	/**
	 * EES_CTM_0426 : send<br>
	 * EDI Yard Setup이 되어있는지 확인합니다.<br>
	 *
	 * @param String yardCd
	 * @return String
	 * @exception EventException
	 */
	public String checkEdiYardSetup(String yardCd) throws EventException;	
}