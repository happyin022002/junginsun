/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCExceptionTariffMgtBC.java
*@FileTitle : DEM/DET Exception - S/C Exception Terms Entry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.basic;

import java.util.List;

import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.vo.DualTypeCustomerVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionCommodityVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionCoverageVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionCustomerVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionFreeTimeVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionGRPVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionParmVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionRateAdjustVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionVersionVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCRFAExceptionListVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCRFAExceptionParamVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.CalculationTypeParmVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-Dmtexceptionmgt Business Logic Command Interface<br>
 *
 * @author
 * @see Ees_dmt_2001EventResponse reference
 * @since J2EE 1.4
 */

public interface SCExceptionTariffMgtBC {
	/**
	 * Search S/C Exception Terms Entry . <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionVO>
	 * @exception EventException
	 */
	public List<SCExceptionVO> searchSCException(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * Search Multi Coverage information of S/C Exception Tariff  Group Seq.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionCoverageVO>
	 * @exception EventException
	 */
	public List<SCExceptionCoverageVO> searchMultiCoverageBySC(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * Search Tiered Free Time of S/C Exception Tariff  Group Seq.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionFreeTimeVO>
	 * @exception EventException
	 */
	public List<SCExceptionFreeTimeVO> searchTieredFreeTimeBySC(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * Search Rate Adjustment information of S/C Exception Tariff  Group Seq. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionRateAdjustVO>
	 * @exception EventException
	 */
	public List<SCExceptionRateAdjustVO> searchRateAdjustmentBySC(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * Search Actual Customer of S/C Exception Tariff  Group Seq.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionCustomerVO>
	 * @exception EventException
	 */
	public List<SCExceptionCustomerVO> searchCustomerBySC(SCExceptionParmVO sCExceptionParmVO) throws EventException;

	/**
	 *  Search Commodity of S/C Exception. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionCommodityVO>
	 * @exception EventException
	 */
	public List<SCExceptionCommodityVO> searchCommodityBySC(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * checking that Rate Adjustment of S/C Exception is mandatory. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return String
	 * @exception EventException
	 */
	public String checkRateAdjustment(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * Search Version list of Proposal No. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionVersionVO>
	 * @exception EventException
	 */
	public List<SCExceptionVersionVO> searchVersionByProposalNo(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * Search Actual Customer / Affiliate information of Proposal No. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionCustomerVO>
	 * @exception EventException
	 */
	public List<SCExceptionCustomerVO> searchCustomerListBySC(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * Search Commodity information of Proposal No. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionCommodityVO>
	 * @exception EventException
	 */
	public List<SCExceptionCommodityVO> searchCommodityListBySC(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * Modify S/C Exception. <br>
	 * 
	 * @param SCExceptionGRPVO sCExceptionGRPVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String modifySCException(SCExceptionGRPVO sCExceptionGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 *  Change status of S/C Exception Version to "Delete" <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @exception EventException
	 */
	public void removeSCExceptionByVer(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * Check Calculation Type is selected Tariff Type. <br>
	 * 
	 * @param CalculationTypeParmVO calculationTypeParmVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkCalcType(CalculationTypeParmVO calculationTypeParmVO) throws EventException;
	
	/**
	 * Check Dual Type is selected Tariff Type. <br>
	 * 
	 * @param DualTypeCustomerVO dualTypeCustomerVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkDualTypeCoverage(DualTypeCustomerVO dualTypeCustomerVO) throws EventException;
	
	/**
	 *  Comparing Continent of cnt_cd and Continent of  Coverage cnt_cd in inputting  BKG POR(O) or DEL(I) .<br>
	 * 
	 * @param SCExceptionVO sCExceptionVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkContinentType(SCExceptionVO sCExceptionVO) throws EventException;
	
	/**
	 * Check S/C ' status is Filed.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkFiledBySC(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/** 
	 * Modify status of S/C Exception Version <br>
	 * 
	 * @param SCExceptionVersionVO sCExceptionVersionVO
	 * @exception EventException
	 */
	public void modifyVersionSTS(SCExceptionVersionVO sCExceptionVersionVO) throws EventException;
	
	/**
	 * Search S/C, RFA Exception. <br>
	 * 
	 * @param SCRFAExceptionParamVO sCRFAExceptionParamVO
	 * @return List<SCRFAExceptionListVO>
	 * @exception EventException
	 */
	public List<SCRFAExceptionListVO> searchSCRFAExceptionList(SCRFAExceptionParamVO sCRFAExceptionParamVO) throws EventException;
	
	/**
	 *  Search SC No, Customer Code and Customer Name of Proposal No. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionCustomerVO>
	 * @exception EventException
	 */
	public List<SCExceptionCustomerVO> searchSCNoCustomerByProposalNo(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 *  Search S/C Duration of Proposal No <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return SCExceptionParmVO
	 * @exception EventException
	 */
	public SCExceptionParmVO searchSCDuration(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * check authority that S/C Exception Tariff  Accept, Accept Cancel. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean hasAcceptAuth(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * Search Affiliate Customer <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionCustomerVO>
	 * @exception EventException
	 */
	public List<SCExceptionCustomerVO> searchAffiliateListBySC(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * check that Customer Type is 'Affiliate'.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkAffiliateCustomer(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * Check that Customer Type is S/C Customer. <br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @return boolean
	 * @exception EventException
	 */
	public boolean isSCCustomer(String custCntCd, String custSeq) throws EventException;
	
	/**
	 * Search S/C Exception of Prop No. <br>
	 * 
	 * @param String propNo
	 * @return List<SCExceptionVO>
	 * @exception EventException
	 */
	public List<SCExceptionVO> searchSCExceptionListByPropNo(String propNo) throws EventException;
	
	/**
	 * Search S/C Exception of Customer Code. <br>
	 * 
	 * @param String custNo
	 * @return List<SCExceptionVO>
	 * @exception EventException
	 */
	public List<SCExceptionVO> searchSCExceptionListByCustomer(String custNo) throws EventException;
	
	/**
	 * Delete all selected S/C Exception Tariff and that's belongs.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @exception EventException
	 */
	public void removeSCException(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * when Update button click, if status of S/C Exception Tariff informatio is "Live" , then Create new version.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @exception EventException
	 */
	public void createSCExceptionByUpdate(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * Delete currenct information,  Create information of S/C Exception Tariff History selected version.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @exception EventException
	 */
	public void createSCExceptionByHistoryCopy(SCExceptionParmVO sCExceptionParmVO) throws EventException;	
	
	/**
	 * Check Duplication inputted S/C information and created S/C information<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean isDuplicateSC(SCExceptionParmVO sCExceptionParmVO) throws EventException;		

	/**
	 * Search same customer existing in PRI_SP_CTRT_PTY.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean isCustomerByPriMn(SCExceptionParmVO sCExceptionParmVO) throws EventException;		
}
