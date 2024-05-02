/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : OceanFeederCostManageBC.java
*@FileTitle : Ocean Feeder Cost Management
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2012.07.03 변종건 [CHM-201217633] Ocean Feeder Cost Management 수정 및 신규 탭 추가
=========================================================*/
package com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.FeederCostDGVO;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.FeederCostInquiryVO;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.FeederCostTariffInfoVO;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.FeederCostTariffNoVO;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.FeederCostVO;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.OceanFeederCostCondVO;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.SearchFeederDgCostVO;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.SearchFeederReeferCostVO;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.SearchOceanFeederCostAccountVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-CostManage Business Logic Command Interface<br>
 * - ALPS-CostManage 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim Jong Ock
 * @see ESD_TRS_3009EventResponse 참조
 * @since J2EE 1.6
 */
public interface OceanFeederCostManageBC  {

	/**
	 * Ocean Feeder Cost Management tab Dry - Retrieve<br>
	 * 
	 * @param inCostTrfNo
	 * @return
	 * @throws EventException
	 */
	public List<FeederCostVO> searchFeederCost(String inCostTrfNo) throws EventException;
	
	/**
	 * Ocean Feeder Cost Management tab Dangerous - Retrieve<br>
	 * 
	 * @param inCostTrfNo
	 * @return
	 * @throws EventException
	 */
	public List<SearchFeederDgCostVO> searchFeederDgCost(String inCostTrfNo) throws EventException;
	
	/**
	 * Ocean Feeder Cost Management tab Reefer - Retrieve<br>
	 * 
	 * @param inCostTrfNo
	 * @return
	 * @throws EventException
	 */
	public List<SearchFeederReeferCostVO> searchFeederRfCost(String inCostTrfNo) throws EventException;

	/**
	 * Ocean Feeder Cost Management - Cost Tariff No<br>
	 * 
	 * @param inOfcCd
	 * @return
	 * @throws EventException
	 */
	public List<FeederCostTariffNoVO> searchFeederCostTariffNo(String inOfcCd) throws EventException;

	/**
	 * Ocean Feeder Cost Management - Cost Tariff No Info<br>
	 * 
	 * @param inCostTrfNo
	 * @param inOfcCd
	 * @return
	 * @throws EventException
	 */
	public FeederCostTariffInfoVO searchFeederCostTariffInfo(String inCostTrfNo, String inOfcCd) throws EventException;
	
	/**
	 * Ocean Feeder Cost Management tab Dry - Save<br>
	 * 
	 * @param inlandCostVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiFeederCost(FeederCostVO[] inlandCostVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Ocean Feeder Cost Management tab Dangerous - Save<br>
	 * 
	 * @param searchFeederDgCostVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiFeederDgCost(SearchFeederDgCostVO[] searchFeederDgCostVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Ocean Feeder Cost Management tab Reefer - Save<br>
	 * 
	 * @param searchFeederReeferCostVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiFeederRfCost(SearchFeederReeferCostVO[] searchFeederReeferCostVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Ocean Feeder Cost Management tab Dry - Save - State 변경<br>
	 * 
	 * @param inCostTrfNo
	 * @param account
	 * @throws EventException
	 */
	public void multiFeederCostHdr(String inCostTrfNo, SignOnUserAccount account) throws EventException;
	
	/**
	 * Ocean Feeder Cost Management - verifyFeederCostConfirm<br>
	 * 
	 * @param inCostTrfNo
	 * @return
	 * @throws EventException
	 */
	public String verifyFeederCostConfirm(String inCostTrfNo) throws EventException;	
	
	/**
	 * Ocean Feeder Cost Management - confirmFeederCostPreVer<br>
	 * 
	 * @param inCostTrfNo
	 * @param account
	 * @throws EventException
	 */
	public void confirmFeederCostPreVer(String inCostTrfNo, SignOnUserAccount account) throws EventException;
	
	/**
	 * Ocean Feeder Cost Management - confirmFeederCost<br>
	 * 
	 * @param inCostTrfNo
	 * @param account
	 * @throws EventException
	 */
	public void confirmFeederCost(String inCostTrfNo, SignOnUserAccount account) throws EventException;
	
	/**
	 * Ocean Feeder Cost Management - verifyFeederCostConfirm<br>
	 * 
	 * @param inCostTrfNo
	 * @param inRhqCd
	 * @return
	 * @throws EventException
	 */
	public String searchFeederCostGuidelineExist(String inCostTrfNo, String inRhqCd) throws EventException;	

	/**
	 * Ocean Feeder Cost Management - modifyFeederCostMgtCfmCxl<br>
	 * 
	 * @param inCostTrfNo
	 * @param account
	 * @throws EventException
	 */
	public void modifyFeederCostMgtCfmCxl(String inCostTrfNo, SignOnUserAccount account) throws EventException;

	/**
	 * Ocean Feeder Cost Management - modifyFeederCostMgtCfmCxlPreVer<br>
	 * 
	 * @param inCostTrfNo
	 * @param inRhqCd
	 * @param account
	 * @throws EventException
	 */
	public void modifyFeederCostMgtCfmCxlPreVer(String inCostTrfNo, String inRhqCd, SignOnUserAccount account) throws EventException;
	
	/**
	 * @param inputVo
	 * @return
	 * @throws EventException
	 */
	public List<SearchOceanFeederCostAccountVO> searchOceanFeederCostAccount(SearchOceanFeederCostAccountVO inputVo) throws EventException;
	
	/**
	 * Ocean Feeder Cost Inquiry tab Dry - Retrieve<br>
	 * 
	 * @param oceanFeederCostCondVO
	 * @return
	 * @throws EventException
	 */
	public List<FeederCostInquiryVO> searchFeederCostInquiry(OceanFeederCostCondVO oceanFeederCostCondVO) throws EventException;
	
	/**
	 * Ocean Feeder Cost DG - Retrieve<br>
	 * 
	 * @param oceanFeederCostCondVO
	 * @return
	 * @throws EventException
	 */
	public List<FeederCostDGVO> searchFeederCostDG(OceanFeederCostCondVO oceanFeederCostCondVO) throws EventException;
	
	/**
	 * Ocean Feeder Cost RF - Retrieve<br>
	 * 
	 * @param oceanFeederCostCondVO
	 * @return
	 * @throws EventException
	 */
	public List<FeederCostInquiryVO> searchFeederCostRF(OceanFeederCostCondVO oceanFeederCostCondVO) throws EventException;

	/**
	 * Ocean Feeder Cost Inquiry tab Dry - Down Excel without Displaying - Down Excel<br>
	 * 
	 * @param oceanFeederCostCondVO
	 * @return
	 * @throws EventException
	 */
	public DBRowSet getDryRowSet(OceanFeederCostCondVO oceanFeederCostCondVO) throws EventException;
	
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
     * @param oceanFeederCostCondVO
     * @return
     * @throws EventException
     */
	public DBRowSet getDGRowSet(OceanFeederCostCondVO oceanFeederCostCondVO) throws EventException;
	
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
	 * @param oceanFeederCostCondVO
	 * @return
	 * @throws EventException
	 */
	public DBRowSet getRFRowSet(OceanFeederCostCondVO oceanFeederCostCondVO) throws EventException;
	
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
