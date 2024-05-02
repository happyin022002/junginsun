/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CostManageBC.java
*@FileTitle : Cost Manage
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.CntDefaultCurrVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.CntInfoVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.InlandCostConditionVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.InlandCostDetailVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.InlandCostSpecialCargoVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.InlandCostTariffInfoVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.InlandCostTariffNoVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.InlandCostVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.InlnadCostInquiryVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.InlnadCostSpeInquiryVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.RHQComboVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.SearchInlandCostAccountVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.SearchStatusMonitorVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-CostManage Business Logic Command Interface<br>
 * - ALPS-CostManage 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim Jong Ock
 * @see ESD_TRS_3001EventResponse 참조
 * @since J2EE 1.6
 */
public interface InlandCostManageBC  {

	/**
	 * Inland Cost Management tab Dry - Retrieve<br>
	 * 
	 * @param inlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<InlandCostVO> searchInlandCost(InlandCostConditionVO inlandCostConditionVO) throws EventException;
	
	/**
	 * Inland Cost Management tab Special - Retrieve<br>
	 * 
	 * @param inlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<InlandCostSpecialCargoVO> searchInlandCostSpecialCargo(InlandCostConditionVO inlandCostConditionVO) throws EventException;	

	/**
	 * Inland Cost Management - Cost Tariff No<br>
	 * 
	 * @param inCntCd
	 * @return
	 * @throws EventException
	 */
	public List<InlandCostTariffNoVO> searchInlandCostTariffNo(String inCntCd) throws EventException;

	/**
	 * Inland Cost Management - Cost Tariff No Info<br>
	 * 
	 * @param inCostTrfNo
	 * @return
	 * @throws EventException
	 */
	public InlandCostTariffInfoVO searchInlandCostTariffInfo(String inCostTrfNo) throws EventException;
	
	/**
	 * Inland Cost Management tab Dry - Save<br>
	 * 
	 * @param inlandCostVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiInlandCost(InlandCostVO[] inlandCostVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Inland Cost Management tab Dry - Save - State 변경<br>
	 * 
	 * @param inlandCostConditionVO
	 * @param account
	 * @throws EventException
	 */
	public void multiInlandCostHdr(InlandCostConditionVO inlandCostConditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Inland Cost Management - Country Code 확인<br>
	 * 
	 * @param String inCntCd
	 * @return String
	 * @throws DAOException
	 */
	public String verifyCountryCode(String inCntCd) throws EventException;	

	/**
	 * Inland Cost Management - verifyInlandCostConfirm<br>
	 * 
	 * @param inCostTrfNo
	 * @return
	 * @throws EventException
	 */
	public String verifyInlandCostConfirm(String inCostTrfNo) throws EventException;	
	
	/**
	 * Inland Cost Management - confirmInlandCostPreVer<br>
	 * 
	 * @param inlandCostConditionVO
	 * @param account
	 * @throws EventException
	 */
	public void confirmInlandCostPreVer(InlandCostConditionVO inlandCostConditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Inland Cost Management - confirmInlandCost<br>
	 * 
	 * @param inlandCostConditionVO
	 * @param account
	 * @throws EventException
	 */
	public void confirmInlandCost(InlandCostConditionVO inlandCostConditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Inland Cost Management - searchInlandCostGuidelineExist<br>
	 * 
	 * @param inCostTrfNo
	 * @return
	 * @throws EventException
	 */
	public String searchInlandCostGuidelineExist(String inCostTrfNo) throws EventException;
	
	/**
	 * Inland Cost Management - modifyInlandCostMgtCfmCxl<br>
	 * 
	 * @param inlandCostConditionVO
	 * @param account
	 * @throws EventException
	 */
	public void modifyInlandCostMgtCfmCxl(InlandCostConditionVO inlandCostConditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * Inland Cost Management - modifyInlandCostMgtCfmCxlPreVer<br>
	 * 
	 * @param inlandCostConditionVO
	 * @param account
	 * @throws EventException
	 */
	public void modifyInlandCostMgtCfmCxlPreVer(InlandCostConditionVO inlandCostConditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Inland Cost Management tab Special - Save<br>
	 * 
	 * @param inlandCostSpecialCargoVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiInlandCostSpecialCargo(InlandCostSpecialCargoVO[] inlandCostSpecialCargoVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Inland Cost Management – Route Detail - Retrieve<br>
	 * 
	 * @param inlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<InlandCostDetailVO> searchInlandCostDetail(InlandCostConditionVO inlandCostConditionVO) throws EventException;	

	/**
	 * Inland Cost Management – Route Detail - Apply Select<br>
	 * 
	 * @param inlandCostDetailVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiInlandCostDetailSelect(InlandCostDetailVO[] inlandCostDetailVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Inland Cost Management – Route Detail - Delete Check<br>
	 * 
	 * @param inlandCostDetailVOs
	 * @return
	 * @throws EventException
	 */
	public String searchInlandCostDetailDeleteCheck(InlandCostDetailVO[] inlandCostDetailVOs) throws EventException;
	
	/**
	 * Inland Cost Management – Route Detail - Delete<br>
	 * 
	 * @param inlandCostDetailVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiInlandCostDetailDelete(InlandCostDetailVO[] inlandCostDetailVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Inland Cost Management – Route Detail - Apply Rest<br>
	 * 
	 * @param inlandCostDetailVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiInlandCostDetailRest(InlandCostDetailVO[] inlandCostDetailVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * @param inputVo
	 * @return
	 * @throws EventException
	 */
	public List<SearchInlandCostAccountVO> searchInlandCostAccount(SearchInlandCostAccountVO inputVo) throws EventException;
	
	/**
	 * Default Currency Creation - RHQ<br>
	 * 
	 * @return
	 * @throws EventException
	 */
	public List<RHQComboVO> searchRHQCombo() throws EventException;

	/**
	 * Default Currency Creation - Retrieve<br>
	 * 
	 * @param inlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<CntDefaultCurrVO> searchCntDefaultCurr(InlandCostConditionVO inlandCostConditionVO) throws EventException;
	
	/**
	 * Default Currency Creation - Country Info<br>
	 * 
	 * @param inCntCd
	 * @return
	 * @throws EventException
	 */
	public CntInfoVO searchCntInfo(String inCntCd) throws EventException;

	/**
	 * Default Currency Creation - Currency Name<br>
	 * 
	 * @param currCd
	 * @return
	 * @throws EventException
	 */
	public String searchCurrNm(String currCd) throws EventException;
	
	/**
	 * @param cntDefaultCurrVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiCntDefaultCurr(CntDefaultCurrVO[] cntDefaultCurrVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Default Currency Creation - Delete<br>
	 * 
	 * @param cntDefaultCurrVOs
	 * @param account
	 * @throws EventException
	 */
	public void removeCntDefaultCurr(CntDefaultCurrVO[] cntDefaultCurrVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Default Currency Creation - Currency Code 확인<br>
	 * 
	 * @param String currCd
	 * @return String
	 * @throws DAOException
	 */
	public String verifyCurrencyCode(String currCd) throws EventException;	
	
	/**
	 * @param inputVo
	 * @return
	 * @throws EventException
	 */
	public List<SearchStatusMonitorVO> searchStatusMonitor(SearchStatusMonitorVO inputVo) throws EventException;
	
	/**
	 * SHQ Office 판단 조회<br>
	 * 
	 * @param usrOfcCd
	 * @return
	 * @throws EventException
	 */
	public String searchShqOfcFlg(String usrOfcCd) throws EventException;
	
	/**
	 * Inland Cost Inquiry tab Dry - Retrieve<br>
	 * 
	 * @param inlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<InlnadCostInquiryVO> searchInlnadCostInquiry(InlandCostConditionVO inlandCostConditionVO) throws EventException;
	
	/**
	 * Inland Cost Inquiry tab Special - Retrieve<br>
	 * 
	 * @param inlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<InlnadCostSpeInquiryVO> searchInlnadCostSpeInquiry(InlandCostConditionVO inlandCostConditionVO) throws EventException;

	/**
	 * Inland Cost Inquiry tab Dry - Down Excel without Displaying - Down Excel<br>
	 * 
	 * @param inlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public DBRowSet getDryRowSet(InlandCostConditionVO inlandCostConditionVO) throws EventException;
	
	/**
	 * Inland Cost Inquiry tab Dry - Down Excel without Displaying - Down Excel<br>
	 * 
	 * @param headCnt
	 * @return
	 */
	public String[] getDryTitle(int headCnt);

	/**
	 * Inland Cost Inquiry tab Dry - Down Excel without Displaying - Down Excel<br>
	 * 
	 * @return
	 */
	public String[] getDryColumns();

	/**
	 * Inland Cost Inquiry tab Special - Down Excel without Displaying - Down Excel<br>
	 * 
	 * @param inlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public DBRowSet getSpeRowSet(InlandCostConditionVO inlandCostConditionVO) throws EventException;
	
	/**
	 * Inland Cost Inquiry tab Special - Down Excel without Displaying - Down Excel<br>
	 * 
	 * @param headCnt
	 * @return
	 */
	public String[] getSpeTitle(int headCnt);

	/**
	 * Inland Cost Inquiry tab Special - Down Excel without Displaying - Down Excel<br>
	 * 
	 * @return
	 */
	public String[] getSpeColumns();
	
	/**
	 * @param trfNo
	 * @return
	 * @throws EventException
	 */
	public String verifyInlndCostTrfNo(String trfNo) throws EventException;

}
