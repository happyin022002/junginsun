/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortSOMasterDataMgtBC.java
*@FileTitle : Bank Information 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.04.30 김진일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.basic;

import java.util.List;

import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.AuditDataCheckListVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.CurrencyVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.DefaultCostVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.DefaultVendorVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.PortSOMasterDataMgtVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.PsoInvOfcYdVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.SearchYardsVO;
import com.clt.framework.core.layer.event.EventException;


/**
 * ALPS-Portsomasterdatamgt Business Logic Command Interface<br>
 *
 * @author
 * @see Reference vop_pso-0203EventResponse 
 * @since J2EE 1.4
 */

public interface PortSOMasterDataMgtBC {
	/**
	 * Bank Information (Pop-Up) 
	 * Retrieve account info to send advanced payment to canal agency <br>
	 * @param int vndrSeq
	 * @return String
	 */
	public String searchAgentBankInfo (int vndrSeq) throws EventException;

	/**
	 * Setting BankInfo of vendor by using vendor_seq in VOP_PSO_0203
	 * @param vndrSeq
	 * @return String
	 * @throws EventException 
	 */
	public String searchVendorInfo(String vndrSeq) throws EventException;

	/**
	 * Retrieve yard applicable by using ofc_cd in VOP_PSO_0001
	 * @param ofcCd
	 * @param ydCd
	 * @return List<SearchYardsVO>
	 * @throws EventException 
	 */
	public List<SearchYardsVO> searchYardList(String ofcCd, String ydCd) throws EventException;

	/**
	 * Retrieve Terminal by using ofc_cd
	 * @param String ofcCd
	 * @param String ydCd
	 * @return List<SearchYardsVO>
	 * @throws EventException
	 */
	public List<SearchYardsVO> searchPsoYardList(String ofcCd, String ydCd) throws EventException;

	/** 
	 * save Yard/Vendor/Cost
	 * @param PortSOMasterDataMgtVO portSOMasterDataMgtVO
	 * @param String chargeType
	 * @throws EventException
	 */
	public void manageUserDefault(PortSOMasterDataMgtVO portSOMasterDataMgtVO, String chargeType) throws EventException;

	/**
	 * Retrieve vessel info
	 * @param String fromDate
	 * @param String toDate
	 * @param String srhCnd
	 * @return List<AuditDataCheckListVO>
	 */
	public List<AuditDataCheckListVO> searchAuditDataCheckList(String fromDate,
			String toDate, String srhCnd) throws EventException;

	/** 
	 * Retrieve Vessel Default Setting Info
	 * @param ofcCd
	 * @param chargeType
	 * @return
	 */
//	public PortSOMasterDataMgtVO searchUserDefault(String ofcCd,
//			String chargeType) throws EventException;

	/**
	 * Retrieve yard Info
	 * @param String ofcCd
	 * @return List<PsoInvOfcYdVO>
	 */
	public List<PsoInvOfcYdVO> searchYardListByUserOffice(String ofcCd) throws EventException;

	/**
	 * Retrieve cost Info
	 * @param String ofcCd
	 * @param String chargeType
	 * @return List<DefaultCostVO>
	 */
	public List<DefaultCostVO> searchCostListByUserOffice(String ofcCd,
			String chargeType) throws EventException;

	/**
	 * Retrieve Vendor Info
	 * @param String ofcCd
	 * @return List<DefaultVendorVO>
	 */
	public List<DefaultVendorVO> searchVendorListByUserOffice(String ofcCd) throws EventException;

	/**
	 * retrieve CostCode list related login user 
	 * @param String ofcCd
	 * @param String chargeType
	 * @param String cnlAgnFlg
	 * @return List<DefaultCostVO>
	 * @throws EventException
	 */
	public List<DefaultCostVO> searchOfficeCosts(String ofcCd, String chargeType, String cnlAgnFlg) throws EventException;

	/**
	 * Retrieve  office Yard of login user 
	 * @param ofcCd
	 * @return List<PsoInvOfcYdVO>
	 * @throws EventException
	 */
	public List<PsoInvOfcYdVO> searchOfficeYards(String ofcCd) throws EventException;

	/**
	 * Retrieve Currency Info
	 * @return List<CurrencyVO>
	 * @throws EventException
	 */
	public List<CurrencyVO> searchCurrency() throws EventException;

	/**
	 *  VOP_PSO_0014 : Window Open <br/>
	 * initial data query of Invoice Creation & Audit page
	 * @category VOP_PSO_0014_WndowsOpen
	 * @param String ofcCd
	 * @return List<DefaultVendorVO>
	 */
	public List<DefaultVendorVO> searchOfficeVendors(String ofcCd) throws EventException;
	
	/**
	 * retrieve ExchageRate Flag 
	 * @param String currCd
     * @param String issDt
     * @return List<DefaultCostVO>
	 * @exception EventException
	 */
	public String searchExistExchageRate(String currCd, String issDt) throws  EventException;
}