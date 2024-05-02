/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AsiaInlandCostManageBC.java
*@FileTitle : Inland Cost Manage(EUR)
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.vo.AsiaInlandCostAccountVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.vo.AsiaInlandCostConditionVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.vo.AsiaInlandCostDetailVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.vo.AsiaInlandCostSpecialCargoVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.vo.AsiaInlandCostTariffInfoVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.vo.AsiaInlandCostTariffNoVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.vo.AsiaInlandCostVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.vo.AsiaInlnadCostInquiryVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.vo.AsiaInlnadCostSpeInquiryVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.vo.AsiaStatusMonitorVO;
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
public interface AsiaInlandCostManageBC  {

	/**
	 * Inland Cost Management tab Dry - Retrieve<br>
	 * 
	 * @param inlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<AsiaInlandCostVO> searchInlandCost(AsiaInlandCostConditionVO inlandCostConditionVO) throws EventException;
	
	/**
	 * Inland Cost Management tab Special - Retrieve<br>
	 * 
	 * @param inlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<AsiaInlandCostSpecialCargoVO> searchInlandCostSpecialCargo(AsiaInlandCostConditionVO inlandCostConditionVO) throws EventException;
	
	/**
	 * Inland Cost Management tab Reefer - Retrieve<br>
	 * 
	 * @param inlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<AsiaInlandCostVO> searchInlandCostReefer(AsiaInlandCostConditionVO inlandCostConditionVO) throws EventException;

	/**
	 * Inland Cost Management - Cost Tariff No<br>
	 * 
	 * @param inCntCd
	 * @return
	 * @throws EventException
	 */
	public List<AsiaInlandCostTariffNoVO> searchInlandCostTariffNo(String inCntCd) throws EventException;

	/**
	 * Inland Cost Management - Cost Tariff No Info<br>
	 * 
	 * @param inCostTrfNo
	 * @return
	 * @throws EventException
	 */
	public AsiaInlandCostTariffInfoVO searchInlandCostTariffInfo(String inCostTrfNo) throws EventException;
	
	/**
	 * Inland Cost Management tab Dry - Save<br>
	 * 
	 * @param inlandCostVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiInlandCost(AsiaInlandCostVO[] inlandCostVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Inland Cost Management tab Dry - Save - State 변경<br>
	 * 
	 * @param inlandCostConditionVO
	 * @param account
	 * @throws EventException
	 */
	public void multiInlandCostHdr(AsiaInlandCostConditionVO inlandCostConditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Inland Cost Management tab Dry - Save<br>
	 * 
	 * @param inlandCostVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiInlandCostReefer(AsiaInlandCostVO[] inlandCostVOs, SignOnUserAccount account) throws EventException;
	
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
	 * Inland Cost Management - Location Group 에 대한 Verify <br>
	 * 
	 * @param inCostTrfNo
	 * @return
	 * @throws EventException
	 */
	public String verifyInlandCostLocGrpCnt(String inCostTrfNo) throws EventException;
	
	/**
	 * Inland Cost Management - confirmInlandCostPreVer<br>
	 * 
	 * @param inlandCostConditionVO
	 * @param account
	 * @throws EventException
	 */
	public void confirmInlandCostPreVer(AsiaInlandCostConditionVO inlandCostConditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Inland Cost Management - confirmInlandCost<br>
	 * 
	 * @param inlandCostConditionVO
	 * @param account
	 * @throws EventException
	 */
	public void confirmInlandCost(AsiaInlandCostConditionVO inlandCostConditionVO, SignOnUserAccount account) throws EventException;
	
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
	public void modifyInlandCostMgtCfmCxl(AsiaInlandCostConditionVO inlandCostConditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * Inland Cost Management - modifyInlandCostMgtCfmCxlPreVer<br>
	 * 
	 * @param inlandCostConditionVO
	 * @param account
	 * @throws EventException
	 */
	public void modifyInlandCostMgtCfmCxlPreVer(AsiaInlandCostConditionVO inlandCostConditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Inland Cost Management tab Special - Save<br>
	 * 
	 * @param inlandCostSpecialCargoVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiInlandCostSpecialCargo(AsiaInlandCostSpecialCargoVO[] inlandCostSpecialCargoVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Inland Cost Management – Route Detail - Retrieve<br>
	 * 
	 * @param inlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<AsiaInlandCostDetailVO> searchInlandCostDetail(AsiaInlandCostConditionVO inlandCostConditionVO) throws EventException;	

	/**
	 * Inland Cost Management – Route Detail - Apply Select<br>
	 * 
	 * @param inlandCostDetailVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiInlandCostDetailSelect(AsiaInlandCostDetailVO[] inlandCostDetailVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Inland Cost Management – Route Detail - Delete Check<br>
	 * 
	 * @param inlandCostDetailVOs
	 * @return
	 * @throws EventException
	 */
	public String searchInlandCostDetailDeleteCheck(AsiaInlandCostDetailVO[] inlandCostDetailVOs) throws EventException;
	
	/**
	 * Inland Cost Management – Route Detail - Delete<br>
	 * 
	 * @param inlandCostDetailVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiInlandCostDetailDelete(AsiaInlandCostDetailVO[] inlandCostDetailVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Inland Cost Management – Route Detail - Apply Rest<br>
	 * 
	 * @param inlandCostDetailVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiInlandCostDetailRest(AsiaInlandCostDetailVO[] inlandCostDetailVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * @param inputVo
	 * @return
	 * @throws EventException
	 */
	public List<AsiaInlandCostAccountVO> searchInlandCostAccount(AsiaInlandCostAccountVO inputVo) throws EventException;

	/**
	 * @param inputVo
	 * @return
	 * @throws EventException
	 */
	public List<AsiaStatusMonitorVO> searchStatusMonitor(AsiaStatusMonitorVO inputVo) throws EventException;
	
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
	public List<AsiaInlnadCostInquiryVO> searchInlnadCostInquiry(AsiaInlandCostConditionVO inlandCostConditionVO) throws EventException;
	
	/**
	 * Inland Cost Inquiry tab Special - Retrieve<br>
	 * 
	 * @param inlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<AsiaInlnadCostSpeInquiryVO> searchInlnadCostSpeInquiry(AsiaInlandCostConditionVO inlandCostConditionVO) throws EventException;

	/**
	 * Inland Cost Inquiry tab Reefer - Retrieve<br>
	 * 
	 * @param inlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<AsiaInlnadCostInquiryVO> searchInlnadCostRefInquiry(AsiaInlandCostConditionVO inlandCostConditionVO) throws EventException;
	
	/**
	 * Inland Cost Inquiry tab Dry - Down Excel without Displaying - Down Excel<br>
	 * 
	 * @param inlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public DBRowSet getDryRowSet(AsiaInlandCostConditionVO inlandCostConditionVO) throws EventException;
	
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
	public DBRowSet getRefRowSet(AsiaInlandCostConditionVO inlandCostConditionVO) throws EventException;
	
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
	public DBRowSet getSpeRowSet(AsiaInlandCostConditionVO inlandCostConditionVO) throws EventException;
	
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
