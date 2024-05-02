/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCalculationTypeMgtBC.java
*@FileTitle : Tariff Type Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.basic;

import java.util.List;

import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.CalculationTypeParmVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.DmtCmbSetVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.DmtOfcUsrTrfOptVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.DmtSkpLocVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.DmtTrfTpVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.WeekendVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * Dmtperformanceanalysis Business Logic Command Interface<br>
 * 
 * @author
 * @see Ees_dmt_7001EventResponse reference
 * @since J2EE 1.4
 */

public interface DMTCalculationTypeMgtBC {
	
	
	/**
	 * Search Tariff Type List information.
	 * 
	 * @param DmtTrfTpVO dmtTrfTpVO
	 * @return List<DmtTrfTpVO>
	 * @exception EventException
	 */
	public List<DmtTrfTpVO> searchTariffTypeList(DmtTrfTpVO dmtTrfTpVO) throws EventException;
	
	/**
	 * Search WeekendList information .
	 * 
	 * @param weekendVO
	 * @return List<WeekendVO>
	 * @throws EventException
	 */
	public List<WeekendVO> searchWeekendList(WeekendVO weekendVO) throws EventException;

	
	/**
	 * Create, Modify and  Delete Weekend information. <br>
	 * 
	 * @param WeekendVO[] weekendVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageWeekend(WeekendVO[] weekendVOs, SignOnUserAccount account) throws EventException;
	
	
	/**
	 *  Search Calculation Type List information.
	 *  
	 * @param CalculationTypeParmVO calculationTypeParmVO
	 * @return List<CalculationTypeParmVO>
	 * @throws EventException
	 */
	public List<CalculationTypeParmVO> searchCalculationTypeList(CalculationTypeParmVO calculationTypeParmVO) throws EventException;

	/**
	 * Modify Tariff Type Setup information.
	 * 
	 * @param DmtOfcUsrTrfOptVO dmtOfcUsrTrfOptVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyTariffTypeSetup(DmtOfcUsrTrfOptVO dmtOfcUsrTrfOptVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Modifying Calculation Type Entry <br>
	 * 
	 * @param CalculationTypeParmVO[] CalculationTypeParmVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCalculationTypeEntry(CalculationTypeParmVO[] CalculationTypeParmVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Checking The Duplicate Calculation Type Entry.<br>
	 * 
	 * @param CalculationTypeParmVO calculationTypeParmVO
	 * @return CalculationTypeParmVO
	 * @exception EventException
	 */
	public CalculationTypeParmVO checkDuplicateCalculationTypeEntry(CalculationTypeParmVO calculationTypeParmVO) throws EventException;

	/**
	 * Search Combination Set information 
	 * 
	 * @return List<DmtCmbSetVO>
	 * @throws EventException
	 */
	
	public List<DmtCmbSetVO> searchCombinationSet() throws EventException;
	/**
	 *  Save Combination Set information <br>
	 * 
	 * @param DmtCmbSetVO[] dmtCmbSetVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCombinationSet(DmtCmbSetVO[] dmtCmbSetVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Skip Location information Search.
	 * 
	 * @return List<DmtSkpLocVO>
	 * @throws EventException
	 */
	public List<DmtSkpLocVO> searchSkipLocation() throws EventException;
	
	/**
	 * Save  Skip Location information. <br>
	 * 
	 * @param DmtSkpLocVO[] dmtSkcLocVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSkipLocation(DmtSkpLocVO[] dmtSkcLocVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Modifying Tariff Type Information<br>
	 * 
	 * @param DmtTrfTpVO[] dmtSkcLocVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTariffType(DmtTrfTpVO[] dmtSkcLocVOs, SignOnUserAccount account) throws EventException;
}
