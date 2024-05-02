/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DemDetTariffMgtBC.java
*@FileTitle : Basic Tariff Summary Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.05.20 김태균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.BasicTariffVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.CommodityTariffRegionParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.CommodityTariffRegionVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.CommodityTariffVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.DmtTariffTypeVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchBasicTariffMonitorVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchBasicTariffNotiListVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchBasicTariffSummaryListVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchBasicTariffSummaryParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchContinentParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchContinentVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchUserRoleInfoListVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffFreeTimeVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffGroupVO; 
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffMgtVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffRateVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.ToDmtTariffTypeVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.DmtUsrRoleMtchVO;

/**
 * alps-Dmtmasterdatamgt Business Logic Command Interface<br>
 * - alps-Dmtmasterdatamgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim Tae Kyun
 * @see Ui-dmt-1003EventResponse 참조
 * @since J2EE 1.4
 */

public interface DemDetTariffMgtBC {
	/** 
	 * [BasicTariffSummryList]를 [search]합니다.<br>
	 * 
	 * @param SearchBasicTariffSummaryParamVO searchBasicTariffSummaryParamVO
	 * @return List<SearchBasicTariffSummaryListVO>
	 * @exception EventException
	 */
	public List<SearchBasicTariffSummaryListVO> searchBasicTariffSummuryList(SearchBasicTariffSummaryParamVO searchBasicTariffSummaryParamVO) throws EventException;
	
	/**
	 * [Basic Tariff Detail(s)]를 [search]합니다.<br>
	 * 
	 * @param SearchContinentParamVO searchContinentParamVO
	 * @return List<SearchContinentVO>
	 * @exception EventException
	 */
	public List<SearchContinentVO> searchBasicTariffDetailList(SearchContinentParamVO searchContinentParamVO) throws EventException;
	
    /**
     * [Basic Tariff Detail(s)]를 [search]합니다.<br>
     * 
     * @param SearchContinentParamVO searchContinentParamVO
     * @return List<SearchContinentVO>
     * @exception EventException
     */
    public List<SearchContinentVO> searchBasicTariffDetailList02(SearchContinentParamVO searchContinentParamVO) throws EventException;	
	
	/**
	 * [BasicTariff]를 [search]합니다.<br>
	 * 
	 * @param DmtTariffTypeVO dmtTariffTypeVO
	 * @return List<BasicTariffVO>
	 * @exception EventException
	 */
	public List<BasicTariffVO> searchBasicTariff(DmtTariffTypeVO dmtTariffTypeVO) throws EventException;
	
    /**
     * [BasicTariff]를 [search]합니다.<br>
     * 
     * @param DmtTariffTypeVO dmtTariffTypeVO
     * @return List<BasicTariffVO>
     * @exception EventException
     */
    public List<SearchContinentVO> searchBasicTariffXSL(DmtTariffTypeVO dmtTariffTypeVO) throws EventException;
	
	/**
	 * [BasicTariffFreeTime]를 [search]합니다.<br>
	 * 
	 * @param DmtTariffTypeVO dmtTariffTypeVO
	 * @return List<TariffFreeTimeVO>
	 * @exception EventException
	 */
	public List<TariffFreeTimeVO> searchBasicTariffFreeTime(DmtTariffTypeVO dmtTariffTypeVO) throws EventException;
	
	/**
	 * [BasicTariffRate]를 [search]합니다.<br>
	 * 
	 * @param DmtTariffTypeVO dmtTariffTypeVO
	 * @return List<TariffRateVO>
	 * @exception EventException
	 */
	public List<TariffRateVO> searchBasicTariffRate(DmtTariffTypeVO dmtTariffTypeVO) throws EventException;
	
	/**
	 * [BasicTariff]를 [confirm]합니다.<br>
	 * @param BasicTariffVO basicTariffVO
	 * @throws EventException
	 */
	public void confirmBasicTariff(BasicTariffVO basicTariffVO) throws EventException;

	/**
	 * [BasicTariff]를 [confirmCancel]합니다.<br>
	 * @param BasicTariffVO basicTariffVO
	 * @throws EventException
	 */
	public void confirmCancelBasicTariff(BasicTariffVO basicTariffVO) throws EventException;
	
	/**
	 * [BasicTariff]를 [confirmRgn]합니다.<br>
	 * @param BasicTariffVO basicTariffVO
	 * @throws EventException
	 */
	public void confirmRgnBasicTariff(BasicTariffVO basicTariffVO) throws EventException;
	
	/**
	 * [BasicTariff]를 [confirmCancelRgn]합니다.<br>
	 * @param BasicTariffVO basicTariffVO
	 * @throws EventException
	 */
	public void confirmCancelRgnBasicTariff(BasicTariffVO basicTariffVO) throws EventException;	
	
	/**
	 * [BasicTariff]를 [remove]합니다.<br>
	 * @param BasicTariffVO[] basicTariffVOs
	 * @throws EventException
	 */
	public void removeBasicTariff(BasicTariffVO[] basicTariffVOs) throws EventException;

//	/**
//	 * [TariffRegion]를 [remove]합니다.<br>
//	 * @param BasicTariffVO basicTariffVO
//	 * @throws EventException
//	 */
//	public void removeTariffRegion(BasicTariffVO basicTariffVO) throws EventException;
//	/**
//	 * [TariffGroup]를 [remove]합니다.<br>
//	 * @param BasicTariffVO basicTariffVO
//	 * @throws EventException
//	 */
//	public void removeTariffGroup(BasicTariffVO basicTariffVO) throws EventException;	
//	
//	/**
//	 * [TariffCombinations]를 [remove]합니다.<br>
//	 * @param BasicTariffVO basicTariffVO
//	 * @throws EventException
//	 */
//	public void removeTariffCombinations(BasicTariffVO basicTariffVO) throws EventException;	
//
//	/**
//	 * [TariffFreeTimes]를 [remove]합니다.<br>
//	 * @param BasicTariffVO basicTariffVO
//	 * @throws EventException
//	 */
//	public void removeTariffFreeTimes(BasicTariffVO basicTariffVO) throws EventException;	
//	
//	/**
//	 * [TariffRates]를 [remove]합니다.<br>
//	 * @param BasicTariffVO basicTariffVO
//	 * @throws EventException
//	 */
//	public void removeTariffRates(BasicTariffVO basicTariffVO) throws EventException;	
	
	
	/**
	 * [TrfRgnCfmHis]를 [add]합니다.<br>
	 * @param BasicTariffVO basicTariffVO
	 * @throws EventException
	 */
	public void addTrfRgnCfmHis(BasicTariffVO basicTariffVO) throws EventException;	
	
	/**
	 * [TrfGrpCfmHis]를 [add]합니다.<br>
	 * @param BasicTariffVO basicTariffVO
	 * @throws EventException
	 */
	public void addTrfGrpCfmHis(BasicTariffVO basicTariffVO) throws EventException;	
	
	/**
	 * [DMT_TRF_RGN_CFM_HIS의 RGN_CFM_SEQ의 max값]를 [search]합니다.<br>
	 * @param BasicTariffVO basicTariffVO
	 * @return int
	 * @throws EventException
	 */
	public int searchTrfRgnCfmSeq(BasicTariffVO basicTariffVO) throws EventException;
	
	/**
	 * [국가별 WeekEnd]를 [search]합니다.<br>
	 * @param DmtTariffTypeVO dmtTariffTypeVO
	 * @return List<BasicTariffVO>
	 * @throws EventException
	 */
	public List<BasicTariffVO> searchWeekEnd(DmtTariffTypeVO dmtTariffTypeVO) throws EventException;
	
	/**
	 * [CombinationSet]를 [search]합니다.<br>
	 * @param DmtTariffTypeVO dmtTariffTypeVO
	 * @return List<BasicTariffVO>
	 * @throws EventException
	 */
	public List<BasicTariffVO> searchCombinationSet(DmtTariffTypeVO dmtTariffTypeVO) throws EventException;
	
	/**
	 * [Tariff Combination]를 [search]합니다.<br>
	 * @param BasicTariffVO basicTariffVO
	 * @return List<BasicTariffVO>
	 * @throws EventException
	 */
	public List<BasicTariffVO> searchTariffCombination(BasicTariffVO basicTariffVO) throws EventException;
	
	/**
	 * [Update CombinationSet]를 [search]합니다.<br>
	 * @param DmtTariffTypeVO dmtTariffTypeVO
	 * @return List<BasicTariffVO>
	 * @throws EventException
	 */
	public List<BasicTariffVO> searchUpdateCombinationSet(DmtTariffTypeVO dmtTariffTypeVO) throws EventException;
	
	/**
	 * [DmtTrfGrp]를 [search]합니다.<br>
	 * @param BasicTariffVO basicTariffVO
	 * @return List<TariffGroupVO>
	 * @throws EventException
	 */
	public List<TariffGroupVO> searchDmtTrfGrp(BasicTariffVO basicTariffVO) throws EventException;
	
	/**
	 * [BasicTariff]를 [create]합니다.<br>
	 * @param TariffMgtVO tariffMgtVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String createBasicTariff(TariffMgtVO tariffMgtVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [BasicTariff]를 [modify]합니다.<br>
	 * @param TariffMgtVO tariffMgtVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String modifyBasicTariff(TariffMgtVO tariffMgtVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [BasicTariff]를 [Expire]합니다.<br>
	 * @param TariffMgtVO tariffMgtVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyBasicTariffExpire(TariffMgtVO tariffMgtVO, SignOnUserAccount account) throws EventException;
	

	/**
	 * [BasicTariff]를 [copy]합니다.<br>
	 * @param DmtTariffTypeVO dmtTariffTypeVO
	 * @param ToDmtTariffTypeVO toDmtTariffTypeVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String copyBasicTariff(DmtTariffTypeVO dmtTariffTypeVO, ToDmtTariffTypeVO toDmtTariffTypeVO, SignOnUserAccount account) throws EventException;
	

	/**
	 * [CommodityTariffList]를 [search]합니다.<br>
	 * @param DmtTariffTypeVO dmtTariffTypeVO
	 * @return List<CommodityTariffVO>
	 * @throws EventException
	 */
	public List<CommodityTariffVO> searchCommodityTariffList(DmtTariffTypeVO dmtTariffTypeVO) throws EventException;
	
	
	/**
	 * [CommodityTariff]를 [생성]합니다.<br>
	 * @param CommodityTariffVO[] CommodityTariffVOs
	 * @param DmtTariffTypeVO dmtTariffTypeVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyCommodityTariff(CommodityTariffVO[] CommodityTariffVOs, DmtTariffTypeVO dmtTariffTypeVO, SignOnUserAccount account) throws EventException;


	/**
	 * [CommodityTariffRegionList]를 [search]합니다.<br>
	 * @param CommodityTariffRegionParamVO commodityTariffRegionParamVO
	 * @return List<CommodityTariffRegionVO>
	 * @throws EventException
	 */
	public List<CommodityTariffRegionVO> searchCommodityTariffRegionList(CommodityTariffRegionParamVO commodityTariffRegionParamVO) throws EventException;
	
	/**
	 * 사용자의 Role정보를 조회 합니다.<br>
	 * @param SearchUserRoleInfoListVO searchUserRoleInfoListVO
	 * @return List<SearchUserRoleInfoListVO>
	 * @throws EventException
	 */
	public List<SearchUserRoleInfoListVO> searchDMTUserRoleInfoList(SearchUserRoleInfoListVO searchUserRoleInfoListVO) throws EventException;
	
	/**
	 * 사용자의 Role정보를 생성, 삭제 합니다. <br> 
	 * 
	 * @param DmtUsrRoleMtchVO[] dmtUsrRoleMtchVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDMTUserRoleInfoList(DmtUsrRoleMtchVO[] dmtUsrRoleMtchVOs, SignOnUserAccount account) throws EventException;
	
//	/**
//	 * Approval Information List 조회
//	 * @param ApproSetupVO sproSetupVO
//	 * @return List<SearchApproSetupInfoListVO>
//	 * @throws EventException
//	 */
//	public List<SearchApproSetupInfoListVO> searchApproSetupInfoList(ApproSetupVO sproSetupVO) throws EventException;
//
//	/**
//	 * Aproval Setup Validation 조회
//	 * @param SearchApproSetupInfoListVO searchApproSetupInfoListVO
//	 * @return String
//	 * @throws EventException
//	 */
//	public String searchApproSetupValidation(SearchApproSetupInfoListVO searchApproSetupInfoListVO) throws EventException;
//	
//	/**
//	 * 사용자의 Role정보를 생성, 삭제 합니다. <br> 
//	 * 
//	 * @param SearchApproSetupInfoListVO[] searchApproSetupInfoListVOs
//	 * @param SignOnUserAccount account
//	 * @exception EventException
//	 */
//	public void manageApproSetupInfoList(SearchApproSetupInfoListVO[] searchApproSetupInfoListVOs, SignOnUserAccount account) throws EventException;
//	
//	/**
//	 * 승인 기준정보별로 설정된 승인 경로를 조회합니다. <br> 
//	 * 
//	 * @param SearchApprovalPathSetupVO searchApprovalPathSetupVO
//	 * @return List<ApprovalPathSetupVO>
//	 * @exception EventException
//	 */
//	public List<SearchApprovalPathSetupVO> searchApprovalPathSetupList(SearchApprovalPathSetupVO searchApprovalPathSetupVO) throws EventException;
//	
//	/**
//	 * 승인 기준정보별로 설정된 승인 경로를 생성, 수정, 삭제 합니다. <br> 
//	 * 
//	 * @param SearchApprovalPathSetupVO[] searchApprovalPathSetupVO
//	 * @param SignOnUserAccount account
//	 * @exception EventException
//	 */
//	public void manageApprovalPathSetup(SearchApprovalPathSetupVO[] searchApprovalPathSetupVO, SignOnUserAccount account) throws EventException;	
//	
//	/**
//	 * 승인 경로별로 설정된 승인 대행자를 조회합니다. <br> 
//	 * 
//	 * @param SearchApprovalPathAgentSetupVO searchApprovalPathAgentSetupVO
//	 * @return List<ApprovalPathAgentSetupVO>
//	 * @exception EventException
//	 */
//	public List<SearchApprovalPathAgentSetupVO> searchApprovalPathAgentSetupList(SearchApprovalPathAgentSetupVO searchApprovalPathAgentSetupVO) throws EventException;
//
//	/**
//	 * 고객별로 설정된 승인자 및 승인 대행자를 조회합니다. <br> 
//	 * 
//	 * @param SearchCustApprovalSetupVO searchCustApprovalSetupVO
//	 * @return List<CustApprovalSetupVO>
//	 * @exception EventException
//	 */
//	public List<SearchCustApprovalSetupVO> searchCustApprovalSetupList(SearchCustApprovalSetupVO searchCustApprovalSetupVO) throws EventException;
//	
//	/**
//	 * 승인 경로별로 설정된 승인 대행자를 생성, 수정, 삭제 합니다. <br> 
//	 * 
//	 * @param SearchApprovalPathAgentSetupVO[] searchApprovalPathAgentSetupVOs
//	 * @param SignOnUserAccount account
//	 * @exception EventException
//	 */
//	public void manageApprovalPathAgentSetup(SearchApprovalPathAgentSetupVO[] searchApprovalPathAgentSetupVOs, SignOnUserAccount account) throws EventException;	
//	
//	/**
//	 * 고객별로 설정된 승인자 및 승인 대행자를 생성, 수정, 삭제 합니다. <br> 
//	 * 
//	 * @param SearchCustApprovalSetupVO[] custApprovalSetupVOs
//	 * @param SignOnUserAccount account
//	 * @exception EventException
//	 */
//	public void manageCustApprovalSetup(SearchCustApprovalSetupVO[] custApprovalSetupVOs, SignOnUserAccount account) throws EventException;	
//	
//	/**
//	 * Office 에 소속되어 있는 사용자인지 조회한다. <br> 
//	 * 
//	 * @param SearchApprovalPathAgentSetupVO searchApprovalPathAgentSetupVO
//	 * @return String
//	 * @exception EventException
//	 */
//	public String searchOfcCustCheck(SearchApprovalPathAgentSetupVO searchApprovalPathAgentSetupVO) throws EventException;
//	
//	/**
//	 * S/C Exception 승인처리를 위해 등록된 승인경로정보를 조회한다. <br> 
//	 * 
//	 * @param SCExceptionApprovalPathVO sCExceptionApprovalPathVO
//	 * @return List<SCExceptionApprovalPathVO>
//	 * @exception EventException
//	 */	
//	public List<SCExceptionApprovalPathVO> searchSCExptAproPathList(SCExceptionApprovalPathVO sCExceptionApprovalPathVO) throws EventException;
//	
//	/**
//	 * RFA Exception 승인처리를 위해 등록된 승인경로정보를 조회한다. <br> 
//	 * 
//	 * @param RFAExceptionApprovalPathVO rFAExceptionApprovalPathVO
//	 * @return List<RFAExceptionApprovalPathVO>
//	 * @exception EventException
//	 */	
//	public List<RFAExceptionApprovalPathVO> searchRFAExptAproPathList(RFAExceptionApprovalPathVO rFAExceptionApprovalPathVO) throws EventException;
//	
//	/**
//	 * S/C Exception 승인처리를 위해 등록된 승인자 및 승인대행자를 조회한다. <br> 
//	 * 
//	 * @param SCExceptionApprovalPathVO sCExceptionApprovalPathVO
//	 * @return List<SCExceptionApprovalPathUserVO>
//	 * @exception EventException
//	 */	
//	public List<SCExceptionApprovalPathUserVO> searchSCExptAproUserListByAproPath(SCExceptionApprovalPathVO sCExceptionApprovalPathVO) throws EventException;
//	
//	/**
//	 * RFA Exception 승인처리를 위해 등록된 승인자 및 승인대행자를 조회한다. <br> 
//	 * 
//	 * @param RFAExceptionApprovalPathVO rFAExceptionApprovalPathVO
//	 * @return List<RFAExceptionApprovalPathUserVO>
//	 * @exception EventException
//	 */	
//	public List<RFAExceptionApprovalPathUserVO> searchRFAExptAproUserListByAproPath(RFAExceptionApprovalPathVO rFAExceptionApprovalPathVO) throws EventException;	
//	
//	/**
//	 * Approval Path 에 해당되는 유효한 Office 인지 조회
//	 * @param SearchApprovalPathAgentSetupVO searchApprovalPathAgentSetupVO
//	 * @return String
//	 * @throws EventException
//	 */
//	public String searchValidOfficeForAproPath(SearchApprovalPathAgentSetupVO searchApprovalPathAgentSetupVO) throws EventException;	

	/**
	 * [Basic Tariff Monitor]를 [search]합니다.<br>
	 * 
	 * @param SearchContinentParamVO searchContinentParamVO
	 * @return List<SearchBasicTariffMonitorVO>
	 * @exception EventException
	 */
	public List<SearchBasicTariffMonitorVO> searchBasicTariffMonitor(SearchContinentParamVO searchContinentParamVO) throws EventException;

	/**
	 * [Basic Tariff Monitor]를 [search]합니다.<br>
	 * 
	 * @param SearchContinentParamVO searchContinentParamVO
	 * @return List<SearchBasicTariffNotiListVO>
	 * @exception EventException
	 */
	public List<SearchBasicTariffNotiListVO> searchBasicTariffNotiList(SearchContinentParamVO searchContinentParamVO) throws EventException;
	
	/**
	 * PIC 입력 [EES_DMT_1202] <br> 
	 * 
	 * @param SearchBasicTariffNotiListVO[] searchBasicTariffNotiListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBasicTariffNotiList(SearchBasicTariffNotiListVO[] searchBasicTariffNotiListVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * [trf_rule_no]를 [search]합니다.<br>
	 * @return List<CommodityTariffVO>
	 * @throws EventException
	 */
	public List<CommodityTariffVO> searchCommodityTrfRuleNo() throws EventException;
	
	
}