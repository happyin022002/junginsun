/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeAmountDiscountMgtBC.java
*@FileTitle : DEM/DET Adjustment Request - After Booking Request
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.basic;

import java.util.List;

import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGDetailInputVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGDetailVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGGRPVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGListInputVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGListVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterProgressVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.BackEndJobResultVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.ChargeBookingContainerParmVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.ChargeBookingContainerVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.CommentHistoryVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.DmtResultVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-Dmtclosing Business Logic Command Interface<br>
 * @author
 * @see reference Ees_dmt_2008EventResponse 
 * @since J2EE 1.6
 */

public interface ChargeAmountDiscountMgtBC {
	/**
	 * search After Booking list. <br>
	 * 
	 * @param AfterBKGListInputVO afterBKGListInputVO
	 * @return List<AfterBKGListVO>
	 * @exception EventException
	 */
	public List<AfterBKGListVO> searchAfterBookingList(AfterBKGListInputVO afterBKGListInputVO) throws EventException;
	
	/**
	 * etc. info of After Booking  <br>
	 * 
	 * @param AfterBKGListInputVO afterBKGListInputVO
	 * @return List<AfterBKGListInputVO>
	 * @exception EventException
	 */
	public List<AfterBKGListInputVO> searchAfterBookingDAR(AfterBKGListInputVO afterBKGListInputVO) throws EventException;
	
	/**
	 * search CNTR. info of Booking No<br>
	 * 
	 * @param ChargeBookingContainerParmVO chargeBookingContainerParmVO
	 * @return List<ChargeBookingContainerVO>
	 * @exception EventException
	 */
	public List<ChargeBookingContainerVO> searchContainerChargeByBooking(ChargeBookingContainerParmVO chargeBookingContainerParmVO) throws EventException;
	
	/**
	 * search Quantity of CNTR. <br>
	 * 
	 * @param ChargeBookingContainerParmVO chargeBookingContainerParmVO
	 * @return List<ChargeBookingContainerVO>
	 * @exception EventException
	 */
	public List<ChargeBookingContainerVO> searchContainerQuantity(ChargeBookingContainerParmVO chargeBookingContainerParmVO) throws EventException;
	
	/**
	 * search Currency of CNTR. <br>
	 * 
	 * @param ChargeBookingContainerParmVO chargeBookingContainerParmVO
	 * @return List<ChargeBookingContainerVO>
	 * @exception EventException
	 */
	public List<ChargeBookingContainerVO> searchContainerCurrency(ChargeBookingContainerParmVO chargeBookingContainerParmVO) throws EventException;
	
	/**
	 * search Comment History  <br>
	 * 
	 * @param AfterBKGListInputVO afterBKGListInputVO
	 * @return List<CommentHistoryVO>
	 * @exception EventException
	 */
	public List<CommentHistoryVO> searchCommentHistory(AfterBKGListInputVO afterBKGListInputVO) throws EventException;
	
	/**
	 * search Booking Data  <br>
	 * 
	 * @param AfterBKGDetailInputVO afterBKGDetailInputVO
	 * @return List<AfterBKGDetailVO>
	 * @exception EventException
	 */
	public List<AfterBKGDetailVO> searchBookingData(AfterBKGDetailInputVO afterBKGDetailInputVO) throws EventException;
	
	/**
	 * search Tariff Type of BKG/B/L No <br>
	 * 
	 * @param AfterBKGListInputVO afterBKGListInputVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkCalcuationType(AfterBKGListInputVO afterBKGListInputVO) throws EventException;
	
	/**
	 * search Location Code of BKG/B/L No Tariff Type <br>
	 * 
	 * @param AfterBKGListInputVO afterBKGListInputVO
	 * @return String
	 * @exception EventException
	 */
	public String searchLocationByBKGBLNo(AfterBKGListInputVO afterBKGListInputVO) throws EventException;
	
	/**
	 * Check duplication Tariff Type and  BKG or B/L No. <br>
	 * 
	 * @param AfterBKGListInputVO afterBKGListInputVO
	 * @return String
	 * @exception EventException
	 */
	public String checkDupTariffBKGBLNo(AfterBKGListInputVO afterBKGListInputVO) throws EventException;
	
	/**
	 * check existing Balance Charge of CNTR <br>
	 * 
	 * @param AfterBKGListInputVO afterBKGListInputVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkBalanceCharge(AfterBKGListInputVO afterBKGListInputVO) throws EventException;
	
	/**
	 * Cancel  After Booking DAR <br>
	 * 
	 * @param AfterProgressVO afterProgressVO
	 * @exception EventException
	 */
	public void cancelAfterBookingDAR(AfterProgressVO afterProgressVO) throws EventException;
	
	/**
	 * Approved After Booking DAR <br>
	 * 
	 * @param AfterProgressVO afterProgressVO
	 * @exception EventException
	 */
	public void approveAfterBookingDAR(AfterProgressVO afterProgressVO) throws EventException;
	
	/**
	 * do Calculate of approval After Booking <br>
	 * 
	 * @param AfterProgressVO afterProgressVO
	 * @param SignOnUserAccount account
	 * @param DmtResultVO dmtResultVO
	 * @return List<ChargeCalculationContainerVO>
	 * @exception EventException
	 */
	public List<ChargeCalculationContainerVO> processCalculation(AfterProgressVO afterProgressVO, SignOnUserAccount account, DmtResultVO dmtResultVO) throws EventException;
	
	/**
	 * Counter Offered modify After Booking DAR <br>
	 * 
	 * @param AfterProgressVO afterProgressVO
	 * @exception EventException
	 */
	public void counterofferAfterBookingDAR(AfterProgressVO afterProgressVO) throws EventException;
	
	/**
	 * After Booking DAR Change to Reject <br>
	 * 
	 * @param AfterProgressVO afterProgressVO
	 * @exception EventException
	 */
	public void rejectAfterBookingDAR(AfterProgressVO afterProgressVO) throws EventException;
	
	/**
	 * After Booking DAR creation, modify, delete. <br>
	 * 
	 * @param AfterBKGGRPVO afterBKGGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */		
	public void requestAfterBookingDAR(AfterBKGGRPVO afterBKGGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * search Calcuation Type of Location Code and I/O Bound Code  <br>
	 * 
	 * @param String locCd
	 * @param String ioBndCd
	 * @return String
	 * @exception EventException
	 */
	public String searchCalcTypeCode(String locCd, String ioBndCd) throws EventException;	
	
	/**
	 * Approval to BackEndJob <br>
	 * 
	 * @param AfterBKGGRPVO afterBKGGRPVO
	 * @param SignOnUserAccount account
	 * @return String
	 */
	public String doBackEndJobApproval(AfterBKGGRPVO afterBKGGRPVO, SignOnUserAccount account);
	
	/**
	 * Back End Job common. return staus <br>
	 * 
	 * @param String jobKey
	 * @return String[]
	 * @exception EventException
	 */
	public String[] checkBackEndJobApproval(String jobKey) throws EventException;	
	
	/**
	 * result Return Back End Job <br>
	 * 
	 * @param String jobKey
	 * @return BackEndJobResultVO
	 * @exception EventException
	 */
	public BackEndJobResultVO completeBackEndJobApproval(String jobKey) throws EventException;
	
	/**
	 * Update Date info. of After Booking Request<br>
	 * 
	 * @param AfterProgressVO afterProgressVO
	 * @return String
	 * @exception EventException
	 */
	public String searchUpdateDate(AfterProgressVO afterProgressVO) throws EventException;
}
