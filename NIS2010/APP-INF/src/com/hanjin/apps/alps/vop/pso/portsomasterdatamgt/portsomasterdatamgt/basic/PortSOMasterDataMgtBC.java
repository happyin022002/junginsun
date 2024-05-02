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
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.AuditDataCheckListVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.CurrencyVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.DefaultCostVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.DefaultVendorVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.PortSOMasterDataMgtVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.PsoInvOfcYdVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.SearchYardsVO;
import com.hanjin.framework.core.layer.event.EventException;


/**
 * ALPS-Portsomasterdatamgt Business Logic Command Interface<br>
 * - ALPS-Portsomasterdatamgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim Jin Ihl
 * @see vop_pso-0203EventResponse 참조
 * @since J2EE 1.4
 */

public interface PortSOMasterDataMgtBC {
	/**
	 * Bank Information (Pop-Up)화면
	 * 운하 대리점으로 전도금을 보내기 위한 계좌 정보를 조회한다. <br>
	 * @param int vndrSeq
	 * @return String
	 */
	public String searchAgentBankInfo (int vndrSeq) throws EventException;

	/**
	 * VOP_PSO_0203에서 vendor_seq를 이용하여 해당 vendor의 BankInfo를 Setting한다.
	 * @param vndrSeq
	 * @return String
	 * @throws EventException 
	 */
	public String searchVendorInfo(String vndrSeq) throws EventException;

	/**
	 * VOP_PSO_0001에서 ofc_cd를 이용하여 해당 yard를 조회한다.
	 * @param ofcCd
	 * @param ydCd
	 * @return List<SearchYardsVO>
	 * @throws EventException 
	 */
	public List<SearchYardsVO> searchYardList(String ofcCd, String ydCd) throws EventException;

	/**
	 *  ofc_cd를 이용하여 해당 Termianl정보를 조회한다.
	 * @param String ofcCd
	 * @param String ydCd
	 * @return List<SearchYardsVO>
	 * @throws EventException
	 */
	public List<SearchYardsVO> searchPsoYardList(String ofcCd, String ydCd) throws EventException;

	/**Yard/Vendor/Cost를 저장합니다.
	 * @param PortSOMasterDataMgtVO portSOMasterDataMgtVO
	 * @param String chargeType
	 * @throws EventException
	 */
	public void manageUserDefault(PortSOMasterDataMgtVO portSOMasterDataMgtVO, String chargeType) throws EventException;

	/**선박  vessle 정보를 조회한다.
	 * @param String fromDate
	 * @param String toDate
	 * @param String srhCnd
	 * @return List<AuditDataCheckListVO>
	 */
	public List<AuditDataCheckListVO> searchAuditDataCheckList(String fromDate,
			String toDate, String srhCnd) throws EventException;

	/**
	 * @param ofcCd
	 * @param chargeType
	 * @return
	 */
//	public PortSOMasterDataMgtVO searchUserDefault(String ofcCd,
//			String chargeType) throws EventException;

	/**yard 정보를 조회한다.
	 * @param String ofcCd
	 * @return List<PsoInvOfcYdVO>
	 */
	public List<PsoInvOfcYdVO> searchYardListByUserOffice(String ofcCd) throws EventException;

	/**cost 정보를 조회한다.
	 * @param String ofcCd
	 * @param String chargeType
	 * @return List<DefaultCostVO>
	 */
	public List<DefaultCostVO> searchCostListByUserOffice(String ofcCd,
			String chargeType) throws EventException;

	/**Vendor 정보를 조회한다.
	 * @param String ofcCd
	 * @return List<DefaultVendorVO>
	 */
	public List<DefaultVendorVO> searchVendorListByUserOffice(String ofcCd) throws EventException;

	/**
	 * 로긴 유저의 관련 CostCode리스트를 조회한다.
	 * @param String ofcCd
	 * @param String chargeType
	 * @return List<DefaultCostVO>
	 * @throws EventException
	 */
	public List<DefaultCostVO> searchOfficeCosts(
			String ofcCd, String chargeType) throws EventException;

	/**
	 * 로긴 유저의 office Yard 를 조회 한다.
	 * @param ofcCd
	 * @return List<PsoInvOfcYdVO>
	 * @throws EventException
	 */
	public List<PsoInvOfcYdVO> searchOfficeYards(String ofcCd) throws EventException;

	/**
	 * Currency 정보를 조회한다. 
	 * @return List<CurrencyVO>
	 * @throws EventException
	 */
	public List<CurrencyVO> searchCurrency() throws EventException;

	/**
	 *  VOP_PSO_0014 : Window Open <br/>
	 * Invoice Creation & Audit 화면의 초기 데이터 쿼리
	 * @category VOP_PSO_0014_WndowsOpen
	 * @param String ofcCd
	 * @return List<DefaultVendorVO>
	 */
	public List<DefaultVendorVO> searchOfficeVendors(String ofcCd) throws EventException;
}