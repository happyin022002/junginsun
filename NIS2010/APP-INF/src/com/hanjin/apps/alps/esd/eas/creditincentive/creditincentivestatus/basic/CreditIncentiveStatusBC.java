/*============================================
*Copyright(c) 2016 CyberLogitec
*@FileName :CreditIncentiveStatusBC.java
*@FileTitle : 
*@LastModifyDate : 2016.04.26.
*@LastModifier : 
*@LastVersion : 
* 2016.04.26. SHIN DONG IL
*============================================*/
package com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.vo.BnfStatusMlgVO;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.vo.MnrStatusCrIssVO;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.vo.MnrStatusCrUsdVO;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.vo.TesStatusIncntVO;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.vo.TrsStatusIncntVO;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.vo.VslStatusIncntVO;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.vo.TotStatusMkrVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * Credit & Incentive Status Business Logic Command Interface<br> 
 * @author SHIN DONG IL
 * @see  ESD_EAS_0501EventResponse 참조
 * @since J2EE 1.6
 */
public interface CreditIncentiveStatusBC {
	
	/**
	 * EsdEas0501Event  <br>
	 * Credti & Invcentive Status Terminal 조회한다. <br>
	 * @param e 
	 * @return List<TesStatusIncntVO>
	 * @exception EventException
	 */
	public List<TesStatusIncntVO> searchTesIncentiveList(Event e) throws EventException;
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status TES Incentive Save 기능
	 * @param tesStatusIncntVOs
	 * @param e 
	 * @throws EventException
	 */
	public void multiTesIncentive(TesStatusIncntVO[] tesStatusIncntVOs,Event e) throws EventException;
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status TES Incentive Delete 기능
	 * @param tesStatusIncntVOs
	 * @param e 
	 * @throws EventException
	 */
	public void removeTesIncentive(TesStatusIncntVO[] tesStatusIncntVOs,Event e) throws EventException;
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status TES Incentive File Attach 기능
	 * @param e 
	 * @throws EventException
	 */
	public void modifyTesFileAttach(Event e) throws EventException;
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status TES Incentive File Attach 기능
	 * @param e 
	 * @throws EventException
	 */
	public void modifyTesFileAttach2(Event e) throws EventException;
	
	/**
	 * EsdEas0501Event  <br>
	 * Credti & Invcentive Status Transportation 조회한다. <br>
	 * @param e 
	 * @return List<TrsStatusIncntVO>
	 * @exception EventException
	 */
	public List<TrsStatusIncntVO> searchTrsIncentiveList(Event e) throws EventException;
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status TRS Incentive Save 기능
	 * @param trsStatusIncntVOs
	 * @param e 
	 * @throws EventException
	 */
	public void multiTrsIncentive(TrsStatusIncntVO[] trsStatusIncntVOs,Event e) throws EventException;
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status TRS Incentive Delete 기능
	 * @param trsStatusIncntVOs
	 * @param e 
	 * @throws EventException
	 */
	public void removeTrsIncentive(TrsStatusIncntVO[] trsStatusIncntVOs,Event e) throws EventException;
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status TRS Incentive File Attach 기능
	 * @param e 
	 * @throws EventException
	 */
	public void modifyTrsFileAttach(Event e) throws EventException;
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status TRS Incentive File Attach 기능
	 * @param e 
	 * @throws EventException
	 */
	public void modifyTrsFileAttach2(Event e) throws EventException;
	/**
	 * EsdEas0501Event  <br>
	 * Credti & Invcentive Status VSL 운항 조회한다. <br>
	 * @param e 
	 * @return List<VslStatusIncntVO>
	 * @exception EventException
	 */
	public List<VslStatusIncntVO> searchVslIncentiveList(Event e) throws EventException;
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status VSL Incentive Save 기능
	 * @param vslStatusIncntVOs
	 * @param e 
	 * @throws EventException
	 */
	public void multiVslIncentive(VslStatusIncntVO[] vslStatusIncntVOs,Event e) throws EventException;
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status VSL Incentive Delete 기능
	 * @param vslStatusIncntVOs
	 * @param e 
	 * @throws EventException
	 */
	public void removeVslIncentive(VslStatusIncntVO[] vslStatusIncntVOs,Event e) throws EventException;
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status VSL Incentive File Attach 기능
	 * @param e 
	 * @throws EventException
	 */
	public void modifyVslFileAttach(Event e) throws EventException;
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status VSL Incentive File Attach 기능
	 * @param e 
	 * @throws EventException
	 */
	public void modifyVslFileAttach2(Event e) throws EventException;
	
	/**
	 * EsdEas0501Event  <br>
	 * Credti & Invcentive Status M&R Credit Issue 조회한다. <br>
	 * @param e 
	 * @return List<MnrStatusCrIssVO>
	 * @exception EventException
	 */
	public List<MnrStatusCrIssVO> searchMnrCreditIssueList(Event e) throws EventException;
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status M&R Credit Issue Save 기능
	 * @param mnrStatusCrIssVOs
	 * @param e 
	 * @throws EventException
	 */
	public void multiMnrCreditIssue(MnrStatusCrIssVO[] mnrStatusCrIssVOs,Event e) throws EventException;
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status M&R Credit Issue Delete 기능
	 * @param mnrStatusCrIssVOs
	 * @param e 
	 * @throws EventException
	 */
	public void removeMnrCreditIssue(MnrStatusCrIssVO[] mnrStatusCrIssVOs,Event e) throws EventException;
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status M&R Credit File Attach 기능
	 * @param e 
	 * @throws EventException
	 */
	public void modifyMnrFileAttach(Event e) throws EventException;
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status M&R Credit File Attach 기능
	 * @param e 
	 * @throws EventException
	 */
	public void modifyMnrFileAttach2(Event e) throws EventException;
	
	/**
	 * EsdEas0501Event  <br>
	 * Credti & Invcentive Status M&R Credit Used 조회한다. <br>
	 * @param e 
	 * @return List<MnrStatusCrUsdVO>
	 * @exception EventException
	 */
	public List<MnrStatusCrUsdVO> searchMnrCreditUsedList(Event e) throws EventException;
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status M&R Credit Used Save 기능
	 * @param mnrStatusCrUsdVOs
	 * @param e 
	 * @throws EventException
	 */
	public void multiMnrCreditUsed(MnrStatusCrUsdVO[] mnrStatusCrUsdVOs,Event e) throws EventException;
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status M&R Credit Used Delete 기능
	 * @param mnrStatusCrUsdVOs
	 * @param e 
	 * @throws EventException
	 */
	public void removeMnrCreditUsed(MnrStatusCrUsdVO[] mnrStatusCrUsdVOs,Event e) throws EventException;
	
	/**
	 * EsdEas0501Event  <br>
	 * Credti & Invcentive Status  Mileage Credit 조회한다. <br>
	 * @param e 
	 * @return List<BnfStatusMlgVO>
	 * @exception EventException
	 */
	public List<BnfStatusMlgVO> searchMileageList(Event e) throws EventException;
	
	/**
	 * EsdEas0502Event  <br>
	 * Credti & Invcentive Status Mileage Save. <br>
	 * @param bnfStatusMlgVOs
	 * @param e 
	 * @throws EventException
	 */
	public void multiMileage(BnfStatusMlgVO[] bnfStatusMlgVOs,Event e) throws EventException;
	
	/**
	 * EsdEas0502Event  <br>
	 * Credti & Invcentive Status Mileage Delete. <br>
	 * @param bnfStatusMlgVOs
	 * @param e 
	 * @throws EventException
	 */
	public void removeMileage(BnfStatusMlgVO[] bnfStatusMlgVOs,Event e) throws EventException;
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status MileagFile Attach 기능
	 * @param e 
	 * @throws EventException
	 */
	public void modifyMileageFileAttach(Event e) throws EventException;
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status MileagFile Attach 기능
	 * @param e 
	 * @throws EventException
	 */
	public void modifyMileageFileAttach2(Event e) throws EventException;
	
	/**
	 * EsdEas0501Event  <br>
	 * Part Credit Total by Maker 조회한다. <br>
	 * @param e 
	 * @return List<TotStatusMkrVO>
	 * @exception EventException
	 */
	public List<TotStatusMkrVO> searchTotalStatusByMakerList(Event e) throws EventException;
	
	
	/**
	 * EsdEas0501Event  <br>
	 * 유효한 RHQ CODE 조회한다. <br>
	 * 
	 * @param  e
	 * @return String
	 * @exception EventException
	 */
	public String searchCheckRhqOfficeCode(Event e) throws EventException;
	
	/**
	 * EsdEas0501Event  <br>
	 * 유효한 Office CODE 조회한다. <br>
	 * 
	 * @param  e
	 * @return String
	 * @exception EventException
	 */
	public String searchCheckOfficeCode(Event e) throws EventException;
	
	/**
	 * EsdEas0501Event  <br>
	 * 유효한 Port CODE 조회한다. <br>
	 * 
	 * @param  e
	 * @return String
	 * @exception EventException
	 */
	public String searchCheckPortCode(Event e) throws EventException;
	
	/**
	 * EsdEas0501Event  <br>
	 * TERMINAL의 유효한 YARD CODE CHECK한다. <br>
	 * 
	 * @param  e
	 * @return String
	 * @exception EventException
	 */
	public String searchCheckTesYardCode(Event e) throws EventException;
	
	/**
	 * EsdEas0501Event  <br>
	 * TERMINAL의 유효한 COST CODE CHECK한다. <br>
	 * 
	 * @param  e
	 * @return String
	 * @exception EventException
	 */
	public String searchCheckTesCostCode(Event e) throws EventException;
	/**
	 * EsdEas0501Event  <br>
	 * TRANSPORTATION의 유효한 COST CODE CHECK한다. <br>
	 * 
	 * @param  e
	 * @return String
	 * @exception EventException
	 */
	public String searchCheckTrsCostCode(Event e) throws EventException;
}