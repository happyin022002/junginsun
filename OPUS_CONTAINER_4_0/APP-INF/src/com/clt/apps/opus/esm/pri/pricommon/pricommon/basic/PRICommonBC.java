/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PRICommonBC.java
*@FileTitle : PRICommon
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommon.pricommon.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.CheckUpdateDateVO;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.ComOrganizationVO;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.PriParaCdDtlVO;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.PriParaCdVO;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCompensationChargeComboListVO;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltPriAuthorizationVO;
import com.clt.apps.opus.esm.pri.primasterdata.authorizationassignment.vo.OrganizationVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.ComUpldFileVO;
import com.clt.syscommon.common.table.ComUserVO;
import com.clt.syscommon.common.table.MdmChargeVO;
import com.clt.syscommon.common.table.MdmSlsRepVO;
import com.clt.syscommon.common.table.PriAuthorizationVO;
import com.clt.syscommon.common.table.PriTariffVO;

/**
 * Pricommon Business Logic Command Interface<br>
 * - interface about  Pricommon biz logic<br>
 *
 * @author  
 * @see PricommonEventResponse  
 * @since J2EE 1.4
 */

public interface PRICommonBC {
	/**
	 * Service Scope Code list retrieving<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchServiceScopeCodeList(RsltCdListVO rsltcdlistvo) throws EventException;
	
	/**
	 * Currency Code list retrieving<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchCurrencyCodeList(RsltCdListVO rsltcdlistvo) throws EventException;	

	/**
	 * Per Code List retrieving<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO> 
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchPerCodeList(RsltCdListVO rsltcdlistvo) throws EventException;		

	/**
	 * Sub-continent Code List retrieving<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchSubcontinentCodeList(RsltCdListVO rsltcdlistvo) throws EventException;		

	/**
	 * Service Scope Detail Name retrieving<br>
	 * 
	 * @param String svcScpCd
	 * @return String
	 * @exception EventException
	 */
	public String searchServiceScopeCodeDetailName(String svcScpCd) throws EventException;	
	
	/**
	 * Location Name retrieving<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchLocationName(RsltCdListVO rsltcdlistvo) throws EventException;		

	/**
	 * Country Name retrieving<br>
	 * 
	 * @param String cntCd
	 * @return String
	 * @exception EventException
	 */
	public String searchCountryName(String cntCd) throws EventException;	

	/**
	 * Commodity Name retrieving<br>
	 * 
	 * @param String cmdtCd
	 * @return String
	 * @exception EventException
	 */
	public String searchCommodityName(String cmdtCd) throws EventException;	

	/**
	 * Rep Commodity Name retrieving<br>
	 * 
	 * @param String repCmdtCd
	 * @return String
	 * @exception EventException
	 */
	public String searchRepCommodityName(String repCmdtCd) throws EventException;

	/**
	 * Surcharge Code List retrieving<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchSurchargeCodeList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * Commodity Group Name retrieving<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return String
	 * @exception EventException
	 */
	public String searchCommodityGroupName(RsltCdListVO rsltcdlistvo) throws EventException;	

	/**
	 * Location Group Name retrieving<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return String
	 * @exception EventException
	 */
	public String searchLocationGroupName(RsltCdListVO rsltcdlistvo) throws EventException;		

	/**
	 *  MDM Container Size Code List retrieving<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchMdmCntrSzCodeList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * S/C Proposal Service Scope Code List retrieving<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchSpScpServiceScopeCodeList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * Office Code List retrieving<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchOfficeCodeList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * Sales Rep Code retrieving about Office Code <br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchSalesRepByOfficeList(RsltCdListVO rsltcdlistvo) throws EventException;	

	/**
	 * Service Scope List retrieving about MQC<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchSpScpMqcServiceScopeCodeList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * organization chart(RAS) retrieving<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRasOrganizationList(RsltCdListVO rsltcdlistvo) throws EventException;
	
	/**
	 * returning current AMOUNT * US exchange rate by CUR <br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return String
	 * @exception EventException
	 */
	public String searchUsExangeAmount(RsltCdListVO rsltcdlistvo) throws EventException;
	
	/**
	 * BKG_REV_UMCH_TP table retrieving<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchBkgRevUmchTpList(RsltCdListVO rsltcdlistvo) throws EventException;
	
	/**
	 * BKG_REV_UMCH_SUB_TP table retrieving<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchBkgRevUmchSubTpList(RsltCdListVO rsltcdlistvo) throws EventException;
	
	/**
	 * Sales Rep Code List retrieving<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchSalesRepCodeList(RsltCdListVO rsltcdlistvo) throws EventException;
	
	/**
	 * S/C Proposal Scope Group Location Name retrieving<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return String
	 * @exception EventException
	 */
	public String searchSpScopeGroupLocationName(RsltCdListVO rsltcdlistvo) throws EventException;
	
	/**
	 * Sub Trade Code List retrieving<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchSubTrdCdList(RsltCdListVO rsltcdlistvo) throws EventException;
	
	/**
	 * Service Scope Lane Code List retrieving<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchSvcScpLaneCdList(RsltCdListVO rsltcdlistvo) throws EventException;
	
	/**
	 *  Customer Name retrieving<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchCustomerName(RsltCdListVO rsltcdlistvo) throws EventException;
	
	/**
	 * Charge Code List retrieving<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchChargeCdList(RsltCdListVO rsltcdlistvo) throws EventException;
	
	/**
	 * Surcharge Group Commodity Code List retrieving<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchScgGrpCmdtCdList(RsltCdListVO rsltcdlistvo) throws EventException;
	
	/**
	 * Surcharge Group Location Name retrieving<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public String searchSurchargeGroupLocationName(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * Region Name retrieving<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRegionName(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * Scope 별 Charge Code List retrieving<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchScopeChargeCodeList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * Charge Code List retrieving by PRS Scope<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
//	public List<RsltCdListVO> searchPRSScopeChargeCodeList(RsltCdListVO rsltcdlistvo) throws EventException;
	
	/**
	 * Authorization retrieving<br>
	 * 
	 * @param PriAuthorizationVO vo
	 * @return List<PriAuthorizationVO>
	 * @exception EventException
	 */
	public List<PriAuthorizationVO> searchAuthorization(PriAuthorizationVO vo) throws EventException;
	
	/**
	 * PRI_AUTHORIZATION table retrieving by Tariff Code<br>
	 * 
	 * @param RsltCdListVO vo
	 * @return List<PriAuthorizationVO>
	 * @exception EventException
	 */
	public List<PriAuthorizationVO> searchAuthByTariff(RsltCdListVO vo) throws EventException;
	
	/**
	 * Currency retrieving<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchAllCurrencyCodeList(RsltCdListVO rsltcdlistvo) throws EventException;
	
	/**
	 * Service Scope Property Mapping Rule List retrieving<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchSvcScpPptMapgList(RsltCdListVO rsltcdlistvo) throws EventException;
	
	/**
	 *  Per Type code, name retrieving<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchAllPerCodeList(RsltCdListVO rsltcdlistvo) throws EventException;
	
	/**
	 * retrieving Note Conversion Rule code, description by CONVERSION TYPE <br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchNoteConvRuleMapgList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * Request Office Name retrieving<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRequestOfficeName(RsltCdListVO rsltcdlistvo) throws EventException;		
	
	/**
	 * sale rep retrieving by Customer<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchCustBySaleRepList(RsltCdListVO rsltcdlistvo) throws EventException;	
	
	/**
	 * Office Code and Sales Rep Name retrieving by Sales Rep Code <br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchCustByReqOffice(RsltCdListVO rsltcdlistvo) throws EventException;		
	
	/**
	 * Approval Office retrieving<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchApprovalOfficeList(RsltCdListVO rsltcdlistvo) throws EventException;
	/**
	 * office code andApproval Office retrieving<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchApprovalOfficeAllList(RsltCdListVO rsltcdlistvo) throws EventException;
	
	/**
	 * Location, Group Location, Country, Region Name retrieving<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchTotalLocationName(RsltCdListVO rsltcdlistvo) throws EventException;		
	
	/**
	 * VESSEL SERVICE LANE's code retrieving<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchVesselServiceLaneName(RsltCdListVO rsltcdlistvo) throws EventException;	
	
	/**
	 * VSK VESSEL SCHEDULE code retrieving<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchVskVesselScheduleCode(RsltCdListVO rsltcdlistvo) throws EventException;
	
	/**
	 * Actual Customer list retrieving<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchActualCustomerList(RsltCdListVO rsltcdlistvo) throws EventException;
	
	/**
	 * IMDG Class list retrieving<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchImdgClassCode(RsltCdListVO rsltcdlistvo) throws EventException;
	
	/**
	 * Location Code retrieving<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchServiceScopeLocationCode(RsltCdListVO rsltcdlistvo) throws EventException;
	
 

	/**
	 * RFA Proposal Service Scope Code List retrieving<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRpScpServiceScopeCodeList(RsltCdListVO rsltcdlistvo) throws EventException;	
	
	/**
	 * retrieving SYS_GUID()<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchSysGuid() throws EventException;
	
	/**
	 *  common code, description retrieving<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchComCodeList(RsltCdListVO rsltcdlistvo) throws EventException;	
		
	/**
	 * retrieving existence of PROP_NO in DMT S/C EXCEPTION GROUP<br>
	 * 
	 * @param rsltcdlistvo RsltCdListVO
	 * @return String 
	 * @exception EventException
	 */
	public String searchDmtScExptGrpCount(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * retrieving common code, description <br>
	 * 
	 * @param RsltCdListVO paramCdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchComCodeDescList(RsltCdListVO paramCdlistvo) throws EventException ;
	
	/**
	 * Rep Charge Code List retrieving<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRepChargeCodeList(RsltCdListVO rsltcdlistvo) throws EventException;
	
	/**
	 * SC Prefix List retrieving<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchScPrefixList(RsltCdListVO rsltcdlistvo) throws EventException;
	
	/**
	 * RHQ List retrieving<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRHQList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * after Batch Job, retrieving jobid by program no(etc1)and  parameter(etc2)<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return RsltCdListVO
	 * @exception EventException
	 */
	public RsltCdListVO searchBatchScheduleJobIdAndStatus(RsltCdListVO rsltcdlistvo) throws EventException ;
	
	/**
	 * retrieving S/C Term Type <br>
	 * 
	 * @param  RsltCdListVO rsltCdlistVo 
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchTermTypeList(RsltCdListVO rsltCdlistVo) throws EventException;	
	
	/**
	 * retrieving RFA Term Type<br>
	 * 
	 * @param  rsltCdlistVo RsltCdListVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRfaTermTypeList(RsltCdListVO rsltCdlistVo) throws EventException;

	/**
	 * retrieving CHARGE code list by SCOPE <br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchTradeCodeList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * retrieving CHARGE code list by SCOPE <br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRLaneCodeList(RsltCdListVO rsltcdlistvo) throws EventException;

    /**
     * organization chart retrieving<br>
     * 
     * @param  ComOrganizationVO comOrganizationVO
     * @param List<OrganizationVO> orgList
     * @return List<ComOrganizationVO>
     * @exception EventException
     */
    public List<ComOrganizationVO> searchOrganizationList(ComOrganizationVO comOrganizationVO, List<OrganizationVO> orgList) throws EventException;

    /**
     * charge list retrieving<br>
     * 
     * @param  MdmChargeVO mdmChargeVO
     * @return List<MdmChargeVO>
     * @exception EventException
     */
    public List<MdmChargeVO> searchChargeList(MdmChargeVO mdmChargeVO) throws EventException;
    
    
    /**
     * retrieving login user's SELECT authority and REQUEST OFFICE[PRS]<br>
     * 
	 * @param RsltPriAuthorizationVO priAuthorizationVO
	 * @param SignOnUserAccount account
	 * @return RsltCdListVO
	 * @exception EventException
	 */
	public  RsltCdListVO  searchAuthorizationOffice (RsltPriAuthorizationVO priAuthorizationVO,SignOnUserAccount account) throws EventException;

    /**
     * User information retrieving by Sales Rep Code <br>
     * 
     * @param MdmSlsRepVO mdmSlsRepVO
     * @return List<ComUserVO>
     * @exception EventException
     */
    public List<ComUserVO> searchSalesRepInfo (MdmSlsRepVO mdmSlsRepVO) throws EventException;
   
	/**
	 * Tariff Code List retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchTariffCodeList(RsltCdListVO rsltCdlistVo) throws EventException;

    /**
     * Tariff Code retrieving by Service Scope Code <br>
     * 
     * @param RsltCdListVO rsltCdlistVo
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> searchTariffCodeByServiceScopeCode(RsltCdListVO rsltCdlistVo) throws EventException;
    
    /**
	 * RFA Actual Customer list retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRFAActualCustomerList(RsltCdListVO rsltCdlistVo) throws EventException;

    /**
     * in case of existence of Tariff Code, Service Scope Code List retrieving<br>
     * 
     * @param RsltCdListVO rsltCdlistVo
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> searchTariffServiceScopeCodeList(RsltCdListVO rsltCdlistVo) throws EventException;
    
	/**
	 * BackEndJob's state retrieving<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String getBackEndJobStatus(String key) throws EventException;

    /**
     * Uploaded Excel Template File Key retrieving<br>
     * 
     * @param ComUpldFileVO comUpldFileVO
     * @return String
     * @exception EventException
     */
    public String searchExcelTemplateFileKey (ComUpldFileVO comUpldFileVO) throws EventException;
    
    /**
	 * Compensation Charge Combo list retrieving<br>
	 * DHF, CMS, NMS, ODF retrieving<br>
     * 
     * @param  RsltCompensationChargeComboListVO pVo
     * @return List<RsltCompensationChargeComboListVO>
     * @exception EventException
     */
    public List<RsltCompensationChargeComboListVO> searchCompensationChargeComboList(RsltCompensationChargeComboListVO pVo) throws EventException;

    /**
     * Customer List retrieving about Sales Rep<br>
     * 
     * @param RsltCdListVO rsltCdlistVo
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> searchSalesRepListByCustOnly(RsltCdListVO rsltCdlistVo) throws EventException;
    
     
    /**
     * checking Region Code, Contry Code correction in  MDM_SVC_SCP_LMT's Origin, Dest<br>
     * 
     * @param RsltCdListVO rsltCdlistVo
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> searchCheckServiceScopeOriginDestRegionList(RsltCdListVO rsltCdlistVo) throws EventException; 
    
    /**
     * after loading, checking upd_dt change<br>
     * 
     * @param CheckUpdateDateVO checkUpdateDate
     * @return CheckUpdateDateVO
     * @exception DAOException
     */
    public CheckUpdateDateVO searchCheckUpdateDate(CheckUpdateDateVO checkUpdateDate) throws EventException ;
    
	/**
	 * retrieving Tariff Name by inputed Tariff Code
	 * 
	 * @param PriTariffVO priTariffVO
	 * @return List<PriTariffVO>
	 * @exception EventException
	 */
	public List<PriTariffVO> searchTariffCodeName(PriTariffVO priTariffVO) throws EventException;
	
	/**
	 * retrieving SYSDATE YYYYMMDD type<br>
	 * 
     * @param RsltCdListVO rsltCdlistVo
	 * @return String
	 * @exception EventException
	 */
	public String searchSystemDate(RsltCdListVO rsltCdlistVo) throws EventException;	
	
	/**
	 * retrieving Rep Service Scoop Code List<br>
	 * 
	 * 
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRepSvcScpCd() throws EventException;

	/**
	 * Percent Base CHG Creation 화면에서 사용할 ChargeList 를 조회합니다.<br>
	 * mdm_charge 코드,명칭을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchChargeListForPctBse (RsltCdListVO rsltCdlistVo) throws EventException ;
	
	/**
	 * search the code and code name from PRI_PARA_CD Table<br>
	 * 
	 * @param PriParaCdVO priParaCdVo
	 * @return List<PriParaCdVO>
	 * @exception EventException
	 * @LastModifyDate : 2014.10.13
	 */
	public List<PriParaCdVO> searchPriParaCd (PriParaCdVO priParaCdVo) throws EventException ;
	
	/**
	 * search the detail info from PRI_PARA_CD_DTL Table<br>
	 * 
	 * @param PriParaCdDtlVO priParaCdDtlVo
	 * @return List<PriParaCdDtlVO>
	 * @exception EventException
	 * @LastModifyDate : 2014.10.13
	 */
	public List<PriParaCdDtlVO> searchPriParaCdDtl (PriParaCdDtlVO priParaCdDtlVo) throws EventException ;
	
	/**
     * check to User Role(COM_USR_ROLE_MTCH) in use about PRI <br>
     *
     * @param ComUserVO comUserVo
     * @return String
     * @exception EventException
     * @LastModifyDate : 2014.10.13
     */
	public String checkPriUserRole(ComUserVO comUserVo) throws EventException;	

	/**
	 * CNTR Type retrieving<br>
	 * 
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchCntrTpCodeList() throws EventException;
	

}