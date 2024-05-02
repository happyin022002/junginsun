/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EurInlandCostManageBC.java
*@FileTitle : Inland Cost Manage(EUR)
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.vo.EurInlandCostAccountVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.vo.EurInlandCostConditionVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.vo.EurInlandCostDetailVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.vo.EurInlandCostSpecialCargoVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.vo.EurInlandCostTariffInfoVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.vo.EurInlandCostTariffNoVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.vo.EurInlandCostVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.vo.EurInlnadCostInquiryVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.vo.EurInlnadCostSpeInquiryVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.vo.EurStatusMonitorVO;
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
public interface EurInlandCostManageBC  {

	/**
	 * Inland Cost Management tab Dry - Retrieve<br>
	 * 
	 * @param inlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<EurInlandCostVO> searchInlandCost(EurInlandCostConditionVO inlandCostConditionVO) throws EventException;
	
	/**
	 * Inland Cost Management tab Special - Retrieve<br>
	 * 
	 * @param inlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<EurInlandCostSpecialCargoVO> searchInlandCostSpecialCargo(EurInlandCostConditionVO inlandCostConditionVO) throws EventException;
	
	/**
	 * Inland Cost Management tab Reefer - Retrieve<br>
	 * 
	 * @param inlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<EurInlandCostVO> searchInlandCostReefer(EurInlandCostConditionVO inlandCostConditionVO) throws EventException;

	/**
	 * Inland Cost Management - Cost Tariff No<br>
	 * 
	 * @param inCntCd
	 * @return
	 * @throws EventException
	 */
	public List<EurInlandCostTariffNoVO> searchInlandCostTariffNo(String inCntCd) throws EventException;

	/**
	 * Inland Cost Management - Cost Tariff No Info<br>
	 * 
	 * @param inCostTrfNo
	 * @return
	 * @throws EventException
	 */
	public EurInlandCostTariffInfoVO searchInlandCostTariffInfo(String inCostTrfNo) throws EventException;
	
	/**
	 * Inland Cost Management tab Dry - Save<br>
	 * 
	 * @param inlandCostVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiInlandCost(EurInlandCostVO[] inlandCostVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Inland Cost Management tab Dry - Save - State 변경<br>
	 * 
	 * @param inlandCostConditionVO
	 * @param account
	 * @throws EventException
	 */
	public void multiInlandCostHdr(EurInlandCostConditionVO inlandCostConditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Inland Cost Management tab Dry - Save<br>
	 * 
	 * @param inlandCostVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiInlandCostReefer(EurInlandCostVO[] inlandCostVOs, SignOnUserAccount account) throws EventException;
	
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
	public void confirmInlandCostPreVer(EurInlandCostConditionVO inlandCostConditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Inland Cost Management - confirmInlandCost<br>
	 * 
	 * @param inlandCostConditionVO
	 * @param account
	 * @throws EventException
	 */
	public void confirmInlandCost(EurInlandCostConditionVO inlandCostConditionVO, SignOnUserAccount account) throws EventException;
	
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
	public void modifyInlandCostMgtCfmCxl(EurInlandCostConditionVO inlandCostConditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * Inland Cost Management - modifyInlandCostMgtCfmCxlPreVer<br>
	 * 
	 * @param inlandCostConditionVO
	 * @param account
	 * @throws EventException
	 */
	public void modifyInlandCostMgtCfmCxlPreVer(EurInlandCostConditionVO inlandCostConditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Inland Cost Management tab Special - Save<br>
	 * 
	 * @param inlandCostSpecialCargoVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiInlandCostSpecialCargo(EurInlandCostSpecialCargoVO[] inlandCostSpecialCargoVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Inland Cost Management – Route Detail - Retrieve<br>
	 * 
	 * @param inlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<EurInlandCostDetailVO> searchInlandCostDetail(EurInlandCostConditionVO inlandCostConditionVO) throws EventException;	

	/**
	 * Inland Cost Management – Route Detail - Apply Select<br>
	 * 
	 * @param inlandCostDetailVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiInlandCostDetailSelect(EurInlandCostDetailVO[] inlandCostDetailVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Inland Cost Management – Route Detail - Delete Check<br>
	 * 
	 * @param inlandCostDetailVOs
	 * @return
	 * @throws EventException
	 */
	public String searchInlandCostDetailDeleteCheck(EurInlandCostDetailVO[] inlandCostDetailVOs) throws EventException;
	
	/**
	 * Inland Cost Management – Route Detail - Delete<br>
	 * 
	 * @param inlandCostDetailVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiInlandCostDetailDelete(EurInlandCostDetailVO[] inlandCostDetailVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Inland Cost Management – Route Detail - Apply Rest<br>
	 * 
	 * @param inlandCostDetailVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiInlandCostDetailRest(EurInlandCostDetailVO[] inlandCostDetailVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * @param inputVo
	 * @return
	 * @throws EventException
	 */
	public List<EurInlandCostAccountVO> searchInlandCostAccount(EurInlandCostAccountVO inputVo) throws EventException;

	/**
	 * @param inputVo
	 * @return
	 * @throws EventException
	 */
	public List<EurStatusMonitorVO> searchStatusMonitor(EurStatusMonitorVO inputVo) throws EventException;
	
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
	public List<EurInlnadCostInquiryVO> searchInlnadCostInquiry(EurInlandCostConditionVO inlandCostConditionVO) throws EventException;
	
	/**
	 * Inland Cost Inquiry tab Special - Retrieve<br>
	 * 
	 * @param inlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<EurInlnadCostSpeInquiryVO> searchInlnadCostSpeInquiry(EurInlandCostConditionVO inlandCostConditionVO) throws EventException;
	
	/**
	 * Inland Cost Inquiry tab Reefer - Retrieve<br>
	 * 
	 * @param inlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<EurInlnadCostInquiryVO> searchInlnadCostRefInquiry(EurInlandCostConditionVO inlandCostConditionVO) throws EventException;

	/**
	 * Inland Cost Inquiry tab Dry - Down Excel without Displaying - Down Excel<br>
	 * 
	 * @param inlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public DBRowSet getDryRowSet(EurInlandCostConditionVO inlandCostConditionVO) throws EventException;
	
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
	public DBRowSet getRefRowSet(EurInlandCostConditionVO inlandCostConditionVO) throws EventException;
	
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
	public DBRowSet getSpeRowSet(EurInlandCostConditionVO inlandCostConditionVO) throws EventException;
	
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
