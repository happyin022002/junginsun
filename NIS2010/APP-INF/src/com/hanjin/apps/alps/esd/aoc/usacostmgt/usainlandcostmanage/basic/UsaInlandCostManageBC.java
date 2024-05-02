/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : UsaInlandCostManageBC.java
*@FileTitle : Inland Cost Manage(EUR)
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2013.09.24 서미진 [CHM-201326830] Batch RF tab 관련 화면로직 보완
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaInlandCostAccountVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaInlandCostConditionVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaInlandCostDetailVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaInlandCostSpecialCargoVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaInlandCostTariffInfoVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaInlandCostTariffNoVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaInlandCostVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaInlnadCostInquiryVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaInlnadCostSpeInquiryVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaIpiPortVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaStatusMonitorVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-CostManage Business Logic Command Interface<br>
 * - ALPS-CostManage 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 
 * @see EventResponse 참조
 * @since J2EE 1.6
 */
public interface UsaInlandCostManageBC  {

	/**
	 * Inland Cost Management tab Dry - Retrieve<br>
	 * 
	 * @param inlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<UsaInlandCostVO> searchInlandCost(UsaInlandCostConditionVO inlandCostConditionVO) throws EventException;
	
	/**
	 * Inland Cost Management tab Special - Retrieve<br>
	 * 
	 * @param inlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<UsaInlandCostSpecialCargoVO> searchInlandCostSpecialCargo(UsaInlandCostConditionVO inlandCostConditionVO) throws EventException;
	
	/**
	 * Inland Cost Management tab Reefer - Retrieve<br>
	 * 
	 * @param inlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<UsaInlandCostVO> searchInlandCostReefer(UsaInlandCostConditionVO inlandCostConditionVO) throws EventException;

	/**
	 * Inland Cost Management - Cost Tariff No<br>
	 * 
	 * @param inCntCd
	 * @return
	 * @throws EventException
	 */
	public List<UsaInlandCostTariffNoVO> searchInlandCostTariffNo(String inCntCd) throws EventException;

	/**
	 * Inland Cost Management - Cost Tariff No Info<br>
	 * 
	 * @param inCostTrfNo
	 * @return
	 * @throws EventException
	 */
	public UsaInlandCostTariffInfoVO searchInlandCostTariffInfo(String inCostTrfNo) throws EventException;
	
	/**
	 * @param inCostTrfNo
	 * @return
	 * @throws EventException
	 */
	public List<UsaIpiPortVO> searchUsaIpiPort(String inCostTrfNo) throws EventException;
	
	/**
	 * Inland Cost Management tab Dry - Save<br>
	 * 
	 * @param inlandCostVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiInlandCost(UsaInlandCostVO[] inlandCostVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Inland Cost Management tab Dry - Save - State 변경<br>
	 * 
	 * @param inlandCostConditionVO
	 * @param account
	 * @throws EventException
	 */
	public void multiInlandCostHdr(UsaInlandCostConditionVO inlandCostConditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Inland Cost Management tab Dry - Save<br>
	 * 
	 * @param inlandCostVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiInlandCostReefer(UsaInlandCostVO[] inlandCostVOs, SignOnUserAccount account) throws EventException;
	
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
	public void confirmInlandCostPreVer(UsaInlandCostConditionVO inlandCostConditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Inland Cost Management - confirmInlandCost<br>
	 * 
	 * @param inlandCostConditionVO
	 * @param account
	 * @throws EventException
	 */
	public void confirmInlandCost(UsaInlandCostConditionVO inlandCostConditionVO, SignOnUserAccount account) throws EventException;
	
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
	public void modifyInlandCostMgtCfmCxl(UsaInlandCostConditionVO inlandCostConditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * Inland Cost Management - modifyInlandCostMgtCfmCxlPreVer<br>
	 * 
	 * @param inlandCostConditionVO
	 * @param account
	 * @throws EventException
	 */
	public void modifyInlandCostMgtCfmCxlPreVer(UsaInlandCostConditionVO inlandCostConditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Inland Cost Management tab Special - Save<br>
	 * 
	 * @param inlandCostSpecialCargoVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiInlandCostSpecialCargo(UsaInlandCostSpecialCargoVO[] inlandCostSpecialCargoVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Inland Cost Management – Route Detail - Retrieve<br>
	 * 
	 * @param inlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<UsaInlandCostDetailVO> searchInlandCostDetail(UsaInlandCostConditionVO inlandCostConditionVO) throws EventException;	

	/**
	 * Inland Cost Management – Route Detail - Apply Select<br>
	 * 
	 * @param inlandCostDetailVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiInlandCostDetailSelect(UsaInlandCostDetailVO[] inlandCostDetailVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Inland Cost Management – Route Detail - Delete Check<br>
	 * 
	 * @param inlandCostDetailVOs
	 * @return
	 * @throws EventException
	 */
	public String searchInlandCostDetailDeleteCheck(UsaInlandCostDetailVO[] inlandCostDetailVOs) throws EventException;
	
	/**
	 * Inland Cost Management – Route Detail - Delete<br>
	 * 
	 * @param inlandCostDetailVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiInlandCostDetailDelete(UsaInlandCostDetailVO[] inlandCostDetailVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Inland Cost Management – Route Detail - Apply Rest<br>
	 * 
	 * @param inlandCostDetailVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiInlandCostDetailRest(UsaInlandCostDetailVO[] inlandCostDetailVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * @param inputVo
	 * @return
	 * @throws EventException
	 */
	public List<UsaInlandCostAccountVO> searchInlandCostAccount(UsaInlandCostAccountVO inputVo) throws EventException;

	/**
	 * @param inputVo
	 * @return
	 * @throws EventException
	 */
	public List<UsaStatusMonitorVO> searchStatusMonitor(UsaStatusMonitorVO inputVo) throws EventException;
	
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
	public List<UsaInlnadCostInquiryVO> searchInlnadCostInquiry(UsaInlandCostConditionVO inlandCostConditionVO) throws EventException;
	
	/**
	 * Inland Cost Inquiry tab Special - Retrieve<br>
	 * 
	 * @param inlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<UsaInlnadCostSpeInquiryVO> searchInlnadCostSpeInquiry(UsaInlandCostConditionVO inlandCostConditionVO) throws EventException;

	/**
	 * Inland Cost Inquiry tab Reefer - Retrieve<br>
	 * 
	 * @param inlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<UsaInlnadCostInquiryVO> searchInlnadCostRefInquiry(UsaInlandCostConditionVO inlandCostConditionVO) throws EventException;
	
	/**
	 * Inland Cost Inquiry tab Dry - Down Excel without Displaying - Down Excel<br>
	 * 
	 * @param inlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public DBRowSet getDryRowSet(UsaInlandCostConditionVO inlandCostConditionVO) throws EventException;
	
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
	 * Inland Cost Inquiry tab Reefer - Down Excel without Displaying - Down Excel<br>
	 * 
	 * @param inlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public DBRowSet getRefRowSet(UsaInlandCostConditionVO inlandCostConditionVO) throws EventException;
	
	/**
	 * Inland Cost Inquiry tab Reefer - Down Excel without Displaying - Down Excel<br>
	 * 
	 * @param headCnt
	 * @return
	 */
	public String[] getRefTitle(int headCnt);

	/**
	 * Inland Cost Inquiry tab Reefer - Down Excel without Displaying - Down Excel<br>
	 * 
	 * @return
	 */
	public String[] getRefColumns();

	/**
	 * Inland Cost Inquiry tab Special - Down Excel without Displaying - Down Excel<br>
	 * 
	 * @param inlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public DBRowSet getSpeRowSet(UsaInlandCostConditionVO inlandCostConditionVO) throws EventException;
	
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

	/**
	 * Confirm : verify service mode (0 or minus value)<br>
	 * 
	 * @param UsaInlandCostConditionVO inlandCostConditionVO
	 * @return String
	 * @throws EventException
	 */
	public String verifyServiceMode(UsaInlandCostConditionVO inlandCostConditionVO) throws EventException;
}
