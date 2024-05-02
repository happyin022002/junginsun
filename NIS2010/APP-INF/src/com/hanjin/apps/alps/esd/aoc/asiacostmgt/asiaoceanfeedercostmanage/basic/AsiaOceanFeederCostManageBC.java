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
package com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.vo.AsiaFeederCostAccountVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.vo.AsiaFeederCostCondVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.vo.AsiaFeederCostDGVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.vo.AsiaFeederCostInquiryVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.vo.AsiaFeederCostTariffInfoVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.vo.AsiaFeederCostTariffNoVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.vo.AsiaFeederCostVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.vo.AsiaFeederDgCostVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.vo.AsiaFeederMgtCondVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.vo.AsiaFeederReeferCostVO;
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
public interface AsiaOceanFeederCostManageBC  {

	/**
	 * Ocean Feeder Cost Management tab Dry - Retrieve<br>
	 * 
	 * @param inputVO
	 * @return
	 * @throws EventException
	 */
	public List<AsiaFeederCostVO> searchFeederCost(AsiaFeederMgtCondVO inputVO) throws EventException;
	
	/**
	 * Ocean Feeder Cost Management tab Dangerous - Retrieve<br>
	 * 
	 * @param inputVO
	 * @return
	 * @throws EventException
	 */
	public List<AsiaFeederDgCostVO> searchFeederDgCost(AsiaFeederMgtCondVO inputVO) throws EventException;
	
	/**
	 * Ocean Feeder Cost Management tab Reefer - Retrieve<br>
	 * 
	 * @param inputVO
	 * @return
	 * @throws EventException
	 */
	public List<AsiaFeederReeferCostVO> searchFeederRfCost(AsiaFeederMgtCondVO inputVO) throws EventException;

	/**
	 * Ocean Feeder Cost Management - Cost Tariff No<br>
	 * 
	 * @param inputVO
	 * @return
	 * @throws EventException
	 */
	public List<AsiaFeederCostTariffNoVO> searchFeederCostTariffNo(AsiaFeederMgtCondVO inputVO) throws EventException;

	/**
	 * Ocean Feeder Cost Management - Cost Tariff No Info<br>
	 * 
	 * @param inputVO
	 * @return
	 * @throws EventException
	 */
	public AsiaFeederCostTariffInfoVO searchFeederCostTariffInfo(AsiaFeederMgtCondVO inputVO) throws EventException;
	
	/**
	 * Ocean Feeder Cost Management tab Dry - Save<br>
	 * 
	 * @param inlandCostVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiFeederCost(AsiaFeederCostVO[] inlandCostVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Ocean Feeder Cost Management tab Dangerous - Save<br>
	 * 
	 * @param searchFeederDgCostVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiFeederDgCost(AsiaFeederDgCostVO[] searchFeederDgCostVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Ocean Feeder Cost Management tab Reefer - Save<br>
	 * 
	 * @param searchFeederReeferCostVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiFeederRfCost(AsiaFeederReeferCostVO[] searchFeederReeferCostVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Ocean Feeder Cost Detail - Delete<br>
	 * 
	 * @param inputVOs
	 * @param account
	 * @throws EventException
	 */
	public void removeFdrTrfDtl(AsiaFeederCostVO[] inputVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Ocean Feeder Cost Management tab Dry - Save - State 변경<br>
	 * 
	 * @param inputVO
	 * @param account
	 * @throws EventException
	 */
	public void multiFeederCostHdr(AsiaFeederMgtCondVO inputVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Ocean Feeder Cost Management - verifyFeederCostConfirm<br>
	 * 
	 * @param inputVO
	 * @return
	 * @throws EventException
	 */
	public String verifyFeederCostConfirm(AsiaFeederMgtCondVO inputVO) throws EventException;	
	
	/**
	 * Ocean Feeder Cost Management - confirmFeederCostPreVer<br>
	 * 
	 * @param inputVO
	 * @param account
	 * @throws EventException
	 */
	public void confirmFeederCostPreVer(AsiaFeederMgtCondVO inputVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Ocean Feeder Cost Management - confirmFeederCost<br>
	 * 
	 * @param inputVO
	 * @param account
	 * @throws EventException
	 */
	public void confirmFeederCost(AsiaFeederMgtCondVO inputVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Ocean Feeder Cost Management - verifyFeederCostConfirm<br>
	 * 
	 * @param inputVO
	 * @return
	 * @throws EventException
	 */
	public String searchFeederCostGuidelineExist(AsiaFeederMgtCondVO inputVO) throws EventException;	

	/**
	 * Ocean Feeder Cost Management - modifyFeederCostMgtCfmCxl<br>
	 * 
	 * @param inputVO
	 * @param account
	 * @throws EventException
	 */
	public void modifyFeederCostMgtCfmCxl(AsiaFeederMgtCondVO inputVO, SignOnUserAccount account) throws EventException;

	/**
	 * Ocean Feeder Cost Management - modifyFeederCostMgtCfmCxlPreVer<br>
	 * 
	 * @param inputVO
	 * @param account
	 * @throws EventException
	 */
	public void modifyFeederCostMgtCfmCxlPreVer(AsiaFeederMgtCondVO inputVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * @param inputVo
	 * @return
	 * @throws EventException
	 */
	public List<AsiaFeederCostAccountVO> searchOceanFeederCostAccount(AsiaFeederCostAccountVO inputVo) throws EventException;
	
	/**
	 * Ocean Feeder Cost Inquiry tab Dry - Retrieve<br>
	 * 
	 * @param asiaFeederCostCondVO
	 * @return
	 * @throws EventException
	 */
	public List<AsiaFeederCostInquiryVO> searchFeederCostInquiry(AsiaFeederCostCondVO asiaFeederCostCondVO) throws EventException;
	
	/**
	 * Ocean Feeder Cost DG - Retrieve<br>
	 * 
	 * @param asiaFeederCostCondVO
	 * @return
	 * @throws EventException
	 */
	public List<AsiaFeederCostDGVO> searchFeederCostDG(AsiaFeederCostCondVO asiaFeederCostCondVO) throws EventException;
	
	/**
	 * Ocean Feeder Cost RF - Retrieve<br>
	 * 
	 * @param asiaFeederCostCondVO
	 * @return
	 * @throws EventException
	 */
	public List<AsiaFeederCostInquiryVO> searchFeederCostRF(AsiaFeederCostCondVO asiaFeederCostCondVO) throws EventException;

	/**
	 * Ocean Feeder Cost Inquiry tab Dry - Down Excel without Displaying - Down Excel<br>
	 * 
	 * @param asiaFeederCostCondVO
	 * @return
	 * @throws EventException
	 */
	public DBRowSet getDryRowSet(AsiaFeederCostCondVO asiaFeederCostCondVO) throws EventException;
	
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
     * @param asiaFeederCostCondVO
     * @return
     * @throws EventException
     */
	public DBRowSet getDGRowSet(AsiaFeederCostCondVO asiaFeederCostCondVO) throws EventException;
	
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
	 * @param asiaFeederCostCondVO
	 * @return
	 * @throws EventException
	 */
	public DBRowSet getRFRowSet(AsiaFeederCostCondVO asiaFeederCostCondVO) throws EventException;
	
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
