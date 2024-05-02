/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TerminalAgreementManageBC.java
*@FileTitle : Terminal Agreement Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.basic;

import java.util.List;

import com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.vo.ChinaFdCodVO;
import com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.BkgCodCostListVO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCodCostVO;

/**
 * ServiceProviderAgreementManage Business Logic Command Interface<br>
 *
 * @author yOng hO lEE
 * @see ESD_TES_0034EventResponse
 * @since J2EE 1.6
 */
public interface TerminalAgreementManageBC  {


	/**
	 * Throughput Cost Code List Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchThoroughputCC(Event e) throws EventException;

	/**
	 * Agreement Summary List Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalAgreeementSummaryList(Event e) throws EventException;

	/**
	 * Agreement Header Info List Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAgreementPopUpList(Event e) throws EventException;

	/**
	 * Agreement Header Info Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAgreementYardVendor(Event e) throws EventException;

	/**
	 * Agreement Header Info Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalAgreement(Event e) throws EventException;

	/**
	 * Agreement Storage Detail List Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchStorageAgreementDetail(Event e) throws EventException;
	
	/**
	 * Agreement EQ Storage Detail List Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchEqStorageAgreementDetail(Event e) throws EventException;
	

	/**
	 * Agreement Terminal Detail List Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalAgreementInfo(Event e) throws EventException;


	/**
	 * Cost Code Verify List Select.<br>
	 *
	 * @param e EsdTes0034Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCostCodeVerifyList(Event e) throws EventException;

	/**
	 * Throughput Cost Code List Select.<br>
	 *
	 * @param e EsdTes0034Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchThorougputCostCode(Event e) throws EventException;

	/**
	 * Agreement Terminal Detail List Select.<br>
	 *
	 * @param e EsdTes0034Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalAgreementDetail(Event e) throws EventException;

	/**
	 * Agreement Terminal Detail Verify List Select.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse verifySheetTerminalAgreement(Event e) throws EventException;


	/**
	 * Agreement Terminal Detail Verify Flag List Select.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse verifyExcelTerminalAgreement(Event e) throws EventException;

	/**
	 * Agreement Storage Detail Verify Flag List Select.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse verifyExcelStorageAgreement(Event e) throws EventException;

	/**
	 * Throughput Cost Code Delete.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse deleteThoroughputCC(Event e) throws EventException;

	/**
	 * Throughput Cost Code Insert.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createThoroughputCC(Event e) throws EventException;

	/**
	 * Checked Agreement Before Insert.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse regBeforeCheck(Event e) throws EventException;

	/**
	 * Agreement Info register Confirm.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse registerAgreementConfirm(Event e) throws EventException;

	/**
	 * Agreement Basic(Header) Info Insert.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createTerminalAgreementBasicInfo(Event e) throws EventException;

	/**
	 * Agreement No Insert.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createTerminalAgreementNo(Event e) throws EventException;


	/**
	 * Agreement No Update.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyTerminalAgreementInfo(Event e) throws EventException;

	/**
	 * Agreement No Delete.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyTerminalAgreementDelete(Event e) throws EventException;

	/**
	 * Agreement Info Insert, Update.<br>
	 *
	 * @param e
	 * @param invoiceUseFlg
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse mutilAgreement(Event e, String invoiceUseFlg) throws EventException;

	/**
	 * Agreement Info Delete.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse removeAgreement(Event e) throws EventException;


	/**
	 * Volume Accumulate Method  retrieve event process
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchVolumeAccumulatedMethod(Event e) throws EventException;

	/**
	 * Volume Accumulate Method Delete.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse removeVolumeAccumulate(Event e) throws EventException;


	/**
	 * Volume Accumulate Method Delete.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse removeVolumeAccumulatedMethod(Event e) throws EventException;

	/**
	 * Volume Accumulate Method Insert, Update, Delete.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiVolumeAccumulatedMethod(Event e) throws EventException;

	/**
	 * Volume Accumulate CostCode List Delete.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse removeListVolumeAccumulatedCostCode(Event e) throws EventException;

	/**
	 * Volume Accumulate CostCode List Insert.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiVolumeAccumulatedCostCode(Event e) throws EventException;

	/**
	 * Volume Accumulate Yard List Insert, Update, Delete.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiVolumeAccumulatedYard(Event e) throws EventException;

	/**
	 * Agreement No (Header) Info Select.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalAgreementManage(Event e) throws EventException;


	/**
	 * Agreement No (Terminal Rate List, Storage Rate List) Info Select.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalAgreementTerminalRateDetail(Event e) throws EventException;


	/**
	 * Invoice Header Info Select.<br>
	 * @param e
	 * @return String
	 * @exception EventException
	 */
	public String searchInvoiceHDR(Event e) throws EventException;

	
	/**
	 * Interface Event Process<br>
	 * Rehandling Cost Info Select.<br>
	 *
	 * @param BkgCodCostListVO bkgCodCostListVO
	 * @return List<BkgCodCostVO>
	 * @exception EventException
	 */
	public List<BkgCodCostVO> searchRehandlingCost(BkgCodCostListVO bkgCodCostListVO) throws EventException;

	
	/**
	 * Interface Event Process<br>
	 * Rehandling Cost Info Select.<br>
	 *
	 * @param List<BkgCodCostListVO> searchList
	 * @return List
	 * @exception EventException
	 */
	public List<List<BkgCodCostVO>> searchRehandlingCost(List<BkgCodCostListVO> searchList) throws EventException;
	
	
	/**China special feeder List select<br>
	 * @param chinaFdCodVO
	 * @return List<ChinaFdCodVO>
	 * @throws EventException
	 */
	public List<ChinaFdCodVO> searchSpecialFeederList(ChinaFdCodVO chinaFdCodVO) throws EventException;
	
	/**
	 * China special feeder List Insert, Update, Delete.<br>
	 * @param chinaFdCodVOs
	 * @param account
	 * @throws EventException
	 */
	public void manageSpecialFeeder(ChinaFdCodVO[] chinaFdCodVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * POL,POD full name select<br>
	 * @param searchCd
	 * @return void
	 * @throws EventException
	 */
	public String searchMdmLocation(String searchCd) throws EventException;
	
	/**
	 * check POL,POD incase it in DB
	 * @param chkPolCd
	 * @param chkPodCd
	 * @return void
	 * @throws EventException
	 */
	public String checkSpecialFeeder(String chkPolCd,String chkPodCd) throws EventException;
	
	/**
	 * check POL,POD incase cont_cd is CN
	 * @param searchCd
	 * @return void
	 * @throws EventException
	 */
	public String checkCntCd(String searchCd) throws EventException;


}