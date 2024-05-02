/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCExceptionTariffMgtBC.java
*@FileTitle : DEM/DET Exception - S/C Exception Terms Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.05.20 이성훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.vo.DualTypeCustomerVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionCommodityVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionCoverageVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionCustomerVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionFreeTimeVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionGRPVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionMasVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionPfmcVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionRateAdjustVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionVersionVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCRFAExceptionListVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCRFAExceptionParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.CalculationTypeParmVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * NIS2010-Dmtexceptionmgt Business Logic Command Interface<br>
 * - NIS2010-Dmtexceptionmgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SungHoon Lee
 * @see Ees_dmt_2001EventResponse 참조
 * @since J2EE 1.4
 */

public interface SCExceptionTariffMgtBC {
	/**
	 * S/C Exception Terms Entry를 조회 합니다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionVO>
	 * @exception EventException
	 */
	public List<SCExceptionVO> searchSCException(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * S/C Exception Tariff 의 Group Seq. 에 해당되는 Multi Coverage 정보를 조회 합니다.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionCoverageVO>
	 * @exception EventException
	 */
	public List<SCExceptionCoverageVO> searchMultiCoverageBySC(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * S/C Exception Tariff 의 Group Seq. 에 해당되는 Tiered Free Time 정보를 조회 합니다.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionFreeTimeVO>
	 * @exception EventException
	 */
	public List<SCExceptionFreeTimeVO> searchTieredFreeTimeBySC(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * S/C Exception Tariff 의 Group Seq. 에 해당되는 Rate Adjustment 정보를 조회 합니다.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionRateAdjustVO>
	 * @exception EventException
	 */
	public List<SCExceptionRateAdjustVO> searchRateAdjustmentBySC(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * S/C Exception Tariff 의 Group Seq. 에 해당되는 Actual Customer 정보를 조회 합니다.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionCustomerVO>
	 * @exception EventException
	 */
	public List<SCExceptionCustomerVO> searchCustomerBySC(SCExceptionParmVO sCExceptionParmVO) throws EventException;

	/**
	 * S/C Exception 에 해당하는 Commodity를 조회 합니다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionCommodityVO>
	 * @exception EventException
	 */
	public List<SCExceptionCommodityVO> searchCommodityBySC(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * S/C Exception 에 해당하는 Rate Adjustment이 필수선택 항목인지를 조회 합니다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return String
	 * @exception EventException
	 */
	public String checkRateAdjustment(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * Proposal No. 에 해당하는 Version 목록을 조회 합니다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionVersionVO>
	 * @exception EventException
	 */
	public List<SCExceptionVersionVO> searchVersionByProposalNo(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * Contract Party 에 해당하는 Actual Customer목록을 조회 합니다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionCustomerVO>
	 * @exception EventException
	 */
	public List<SCExceptionCustomerVO> searchCustomerListBySC(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * Contract Party 에 해당하는 Commodity목록을 조회 합니다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionCommodityVO>
	 * @exception EventException
	 */
	public List<SCExceptionCommodityVO> searchCommodityListBySC(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * S/C Exception 을 수정 합니다. <br>
	 * 
	 * @param SCExceptionGRPVO sCExceptionGRPVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String modifySCException(SCExceptionGRPVO sCExceptionGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * S/C Exception Version를 삭제상태로 수정 합니다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @exception EventException
	 */
	public void removeSCExceptionByVer(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * 선택한 Tariff Type 에 맞는 Calculation Type 이 존재하는지 조회 합니다. <br>
	 * 
	 * @param CalculationTypeParmVO calculationTypeParmVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkCalcType(CalculationTypeParmVO calculationTypeParmVO) throws EventException;
	
	/**
	 * 선택한 Tariff Type 에 맞는 Dual Type 이 존재하는지 조회 합니다. <br>
	 * 
	 * @param DualTypeCustomerVO dualTypeCustomerVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkDualTypeCoverage(DualTypeCustomerVO dualTypeCustomerVO) throws EventException;
	
	/**
	 * BKG POR(O) or DEL(I) 의 입력된 CN 의 Continent 와 Coverage CN 의 Continent 가 동일한지 조회 합니다.<br>
	 * 
	 * @param SCExceptionVO sCExceptionVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkContinentType(SCExceptionVO sCExceptionVO) throws EventException;
	
	/**
	 * S/C 가 Filed Status 인지를 조회 합니다.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkFiledBySC(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * S/C Exception Version 의 상태를 수정 합니다. <br>
	 * 
	 * @param SCExceptionVersionVO sCExceptionVersionVO
	 * @exception EventException
	 */
	public void modifyVersionSTS(SCExceptionVersionVO sCExceptionVersionVO) throws EventException;
	
	/**
	 * S/C, RFA Exception를 조회 합니다. <br>
	 * 
	 * @param SCRFAExceptionParamVO sCRFAExceptionParamVO
	 * @return List<SCRFAExceptionListVO>
	 * @exception EventException
	 */
	public List<SCRFAExceptionListVO> searchSCRFAExceptionList(SCRFAExceptionParamVO sCRFAExceptionParamVO) throws EventException;
	
	/**
	 * Proposal No. 에 해당되는 SC No.와 Customer Code, Customer Name을 조회 합니다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionCustomerVO>
	 * @exception EventException
	 */
	public List<SCExceptionCustomerVO> searchSCNoCustomerByProposalNo(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * Proposal No 의 S/C Duration 데이터를 조회한다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return SCExceptionParmVO
	 * @exception EventException
	 */
	public SCExceptionParmVO searchSCDuration(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * S/C Exception Tariff 를 Accept, Accept Cancel 할 수 있는 권한이 있는지를 조회한다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean hasAcceptAuth(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * Affiliate Customer 를 조회한다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionCustomerVO>
	 * @exception EventException
	 */
	public List<SCExceptionCustomerVO> searchAffiliateListBySC(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * Customer Type 이 'Affiliate' 인지를 조회 합니다.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkAffiliateCustomer(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * Customer 가 S/C Customer 인지 조회 합니다. <br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @return boolean
	 * @exception EventException
	 */
	public boolean isSCCustomer(String custCntCd, String custSeq) throws EventException;
	
	/**
	 * Prop No. 에 해당하는 S/C Exception를 조회 합니다. <br>
	 * 
	 * @param String propNo
	 * @return List<SCExceptionVO>
	 * @exception EventException
	 */
	public List<SCExceptionVO> searchSCExceptionListByPropNo(String propNo) throws EventException;
	
	/**
	 * Customer Code 에 해당하는 S/C Exception를 조회 합니다. <br>
	 * 
	 * @param String custNo
	 * @return List<SCExceptionVO>
	 * @exception EventException
	 */
	public List<SCExceptionVO> searchSCExceptionListByCustomer(String custNo) throws EventException;
	
	/**
	 * 선택한 S/C Exception Tariff 와 그 하위항목을 모두 삭제 합니다.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @exception EventException
	 */
	public void removeSCException(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * Update 버튼 클릭시 'Live'상태의 S/C Exception Tariff 정보를 새로운 버전으로 생성 합니다.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @exception EventException
	 */
	public void createSCExceptionByUpdate(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * 현재 버전에 있는 정보를 삭제하고 현재 버전에 S/C Exception Tariff History 에서 선택한 버전의 정보로 생성 합니다.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @exception EventException
	 */
	public void createSCExceptionByHistoryCopy(SCExceptionParmVO sCExceptionParmVO) throws EventException;	
	
	/**
	 * 화면에서 입력한 S/C 정보와 기등록된 S/C 정보중 중복된 데이터가 있는지 조회 합니다.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean isDuplicateSC(SCExceptionParmVO sCExceptionParmVO) throws EventException;		

	/**
	 * PRI_SP_CTRT_PTY에 동일한 Customer가 존재하는지 조회합니다.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean isCustomerByPriMn(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * SC Exception PFMC를 조회합니다.<br>
	 * 
	 * @param SCExceptionPfmcVO scExceptionPfmcVO
	 * @return List<SCExceptionPfmcVO>
	 * @exception EventException
	 */
	public List<SCExceptionPfmcVO> searchSCExceptionPFMC(SCExceptionPfmcVO scExceptionPfmcVO) throws EventException;
	
	/**
	 * SC Exception MAS를 조회합니다.<br>
	 * 
	 * @param SCExceptionMasVO scExceptionMasVO
	 * @return List<SCExceptionMasVO>
	 * @exception EventException
	 */
	public List<SCExceptionMasVO> searchSCExceptionMAS(SCExceptionMasVO scExceptionMasVO) throws EventException;

	/**
	 * Proposal No. 에 해당되는 Cust Type Code 조회 합니다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionCustomerVO>
	 * @exception EventException
	 */
	public List<SCExceptionCustomerVO> searchSCNoCustTpCdProposalNo(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
}
