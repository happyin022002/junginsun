/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : OceanFeederCostManageBC.java
*@FileTitle : Ocean Feeder Cost Management
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederCostAccountVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederCostCondVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederCostDGVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederCostInquiryVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederCostTariffInfoVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederCostTariffNoVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederCostVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederDgCostVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederMgtCondVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederReeferCostVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-CostManage Business Logic Command Interface<br>
 * - ALPS-CostManage 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 
 * @see EventResponse 참조
 * @since J2EE 1.6
 */
public interface EurOceanFeederCostManageBC  {

	/**
	 * Ocean Feeder Cost Management tab Dry - Retrieve<br>
	 * 
	 * @param inputVO
	 * @return
	 * @throws EventException
	 */
	public List<EurFeederCostVO> searchFeederCost(EurFeederMgtCondVO inputVO) throws EventException;
	
	/**
	 * Ocean Feeder Cost Management tab Dangerous - Retrieve<br>
	 * 
	 * @param inputVO
	 * @return
	 * @throws EventException
	 */
	public List<EurFeederDgCostVO> searchFeederDgCost(EurFeederMgtCondVO inputVO) throws EventException;
	
	/**
	 * Ocean Feeder Cost Management tab Reefer - Retrieve<br>
	 * 
	 * @param inputVO
	 * @return
	 * @throws EventException
	 */
	public List<EurFeederReeferCostVO> searchFeederRfCost(EurFeederMgtCondVO inputVO) throws EventException;

	/**
	 * Ocean Feeder Cost Management - Cost Tariff No<br>
	 * 
	 * @param inputVO
	 * @return
	 * @throws EventException
	 */
	public List<EurFeederCostTariffNoVO> searchFeederCostTariffNo(EurFeederMgtCondVO inputVO) throws EventException;

	/**
	 * Ocean Feeder Cost Management - Cost Tariff No Info<br>
	 * 
	 * @param inputVO
	 * @return
	 * @throws EventException
	 */
	public EurFeederCostTariffInfoVO searchFeederCostTariffInfo(EurFeederMgtCondVO inputVO) throws EventException;
	
	/**
	 * Ocean Feeder Cost Management tab Dry - Save<br>
	 * 
	 * @param inlandCostVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiFeederCost(EurFeederCostVO[] inlandCostVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Ocean Feeder Cost Management tab Dangerous - Save<br>
	 * 
	 * @param searchFeederDgCostVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiFeederDgCost(EurFeederDgCostVO[] searchFeederDgCostVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Ocean Feeder Cost Management tab Reefer - Save<br>
	 * 
	 * @param searchFeederReeferCostVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiFeederRfCost(EurFeederReeferCostVO[] searchFeederReeferCostVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Ocean Feeder Cost Detail - Delete<br>
	 * 
	 * @param inputVOs
	 * @param account
	 * @throws EventException
	 */
	public void removeFdrTrfDtl(EurFeederCostVO[] inputVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Ocean Feeder Cost Management tab Dry - Save - State 변경<br>
	 * 
	 * @param inputVO
	 * @param account
	 * @throws EventException
	 */
	public void multiFeederCostHdr(EurFeederMgtCondVO inputVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Ocean Feeder Cost Management - verifyFeederCostConfirm<br>
	 * 
	 * @param inputVO
	 * @return
	 * @throws EventException
	 */
	public String verifyFeederCostConfirm(EurFeederMgtCondVO inputVO) throws EventException;	
	
	/**
	 * Ocean Feeder Cost Management - confirmFeederCostPreVer<br>
	 * 
	 * @param inputVO
	 * @param account
	 * @throws EventException
	 */
	public void confirmFeederCostPreVer(EurFeederMgtCondVO inputVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Ocean Feeder Cost Management - confirmFeederCost<br>
	 * 
	 * @param inputVO
	 * @param account
	 * @throws EventException
	 */
	public void confirmFeederCost(EurFeederMgtCondVO inputVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Ocean Feeder Cost Management - verifyFeederCostConfirm<br>
	 * 
	 * @param inputVO
	 * @return
	 * @throws EventException
	 */
	public String searchFeederCostGuidelineExist(EurFeederMgtCondVO inputVO) throws EventException;	

	/**
	 * Ocean Feeder Cost Management - modifyFeederCostMgtCfmCxl<br>
	 * 
	 * @param inputVO
	 * @param account
	 * @throws EventException
	 */
	public void modifyFeederCostMgtCfmCxl(EurFeederMgtCondVO inputVO, SignOnUserAccount account) throws EventException;

	/**
	 * Ocean Feeder Cost Management - modifyFeederCostMgtCfmCxlPreVer<br>
	 * 
	 * @param inputVO
	 * @param account
	 * @throws EventException
	 */
	public void modifyFeederCostMgtCfmCxlPreVer(EurFeederMgtCondVO inputVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * @param inputVo
	 * @return
	 * @throws EventException
	 */
	public List<EurFeederCostAccountVO> searchOceanFeederCostAccount(EurFeederCostAccountVO inputVo) throws EventException;
	
	/**
	 * Ocean Feeder Cost Inquiry tab Dry - Retrieve<br>
	 * 
	 * @param eurFeederCostCondVO
	 * @return
	 * @throws EventException
	 */
	public List<EurFeederCostInquiryVO> searchFeederCostInquiry(EurFeederCostCondVO eurFeederCostCondVO) throws EventException;
	
	/**
	 * Ocean Feeder Cost DG - Retrieve<br>
	 * 
	 * @param eurFeederCostCondVO
	 * @return
	 * @throws EventException
	 */
	public List<EurFeederCostDGVO> searchFeederCostDG(EurFeederCostCondVO eurFeederCostCondVO) throws EventException;
	
	/**
	 * Ocean Feeder Cost RF - Retrieve<br>
	 * 
	 * @param eurFeederCostCondVO
	 * @return
	 * @throws EventException
	 */
	public List<EurFeederCostInquiryVO> searchFeederCostRF(EurFeederCostCondVO eurFeederCostCondVO) throws EventException;

	/**
	 * Ocean Feeder Cost Inquiry tab Dry - Down Excel without Displaying - Down Excel<br>
	 * 
	 * @param eurFeederCostCondVO
	 * @return
	 * @throws EventException
	 */
	public DBRowSet getDryRowSet(EurFeederCostCondVO eurFeederCostCondVO) throws EventException;
	
	/**
	 * Ocean Feeder Cost Inquiry tab Dry - Down Excel without Displaying - Down Excel<br>
	 * 
	 * @param headCnt
	 * @return
	 */
	public String[] getDryTitle(int headCnt);

	/**
	 * Ocean Feeder Cost Inquiry tab Dry - Down Excel without Displaying - Down Excel<br>
	 * 
	 * @return
	 */
	public String[] getDryColumns();

	/**
     * Ocean Feeder Cost Inquiry tab Dangerous - Down Excel without Displaying<br>
     * 
     * @param eurFeederCostCondVO
     * @return
     * @throws EventException
     */
	public DBRowSet getDGRowSet(EurFeederCostCondVO eurFeederCostCondVO) throws EventException;
	
	/**
	 * @return
	 */
	public String[] getDGColumns();
	
	/**
	 * @param headCnt
	 * @return
	 */
	public String[] getDGTitle(int headCnt);
	
	/**
	 * Ocean Feeder Cost Inquiry tab Special - Down Excel without Displaying - Down Excel<br>
	 * 
	 * @param eurFeederCostCondVO
	 * @return
	 * @throws EventException
	 */
	public DBRowSet getRFRowSet(EurFeederCostCondVO eurFeederCostCondVO) throws EventException;
	
	/**
	 * Ocean Feeder Cost Inquiry tab Reefer - Down Excel without Displaying - Down Excel<br>
	 * 
	 * @param headCnt
	 * @return
	 */
	public String[] getRFTitle(int headCnt);

	/**
	 * Ocean Feeder Cost Inquiry tab Reefer - Down Excel without Displaying - Down Excel<br>
	 * 
	 * @return
	 */
	public String[] getRFColumns();
	
	/**
	 * @param trfNo
	 * @return
	 * @throws EventException
	 */
	public String verifyFeederCostTrfNo(String trfNo) throws EventException;

}
