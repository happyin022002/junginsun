/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TerminalAgreementManageBC.java
*@FileTitle : Terminal Agreement Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-08
*@LastModifier : jongbaemoon
*@LastVersion : 1.0
* 2006-09-08 jongbaemoon
* 1.0 최초 생성
* 
*@LastModifyDate : 2009.08.10
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.08.10 yOng hO lEE
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.BkgCodCostListVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.syscommon.common.table.BkgCodCostVO;

/**
 * ALPS-ServiceProviderAgreementManage Business Logic Command Interface<br>
 * - ALPS-ServiceProviderAgreementManage 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author yOng hO lEE
 * @see ESD_TES_0034EventResponse 참조
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
	 * Agreement GW Link Update.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyTerminalAgreementContractInfo(Event e) throws EventException;
	
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


//	===== Vol. Accumulate Method ========================================================
	//----- Method ------------------------------------------------------------------------
	/**
	 * Volume Accumulate Method 조회 이벤트 처리<br>
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

	//----- Cost Code ---------------------------------------------------------------------

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

	//----- Yard ---------------------------------------------------------------------

	/**
	 * Volume Accumulate Yard List Insert, Update, Delete.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiVolumeAccumulatedYard(Event e) throws EventException;

	/**************************************************************************************
	 * kimjinjoo부분 시작
	 *************************************************************************************/


	/*******	  TerminalAgreement 조회화면 -Detail(Terminal Rate) 시작		*********/
	/**
	 * Agreement No (Header) Info Select.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalAgreementManage(Event e) throws EventException;


	/*******	  TerminalAgreement 조회화면 -Detail(Terminal Rate - Detail) 시작		*********/
	/**
	 * Agreement No (Terminal Rate List, Storage Rate List) Info Select.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalAgreementTerminalRateDetail(Event e) throws EventException;



	/**************************************************************************************
	 * kimjinjoo부분 끝
	 *************************************************************************************/
	
	/**
	 * Invoice Header 조회.<br>
	 * @param e
	 * @return String
	 * @exception EventException
	 */
	public String searchInvoiceHDR(Event e) throws EventException;

	
	/**
	 * 인터페이스 이벤트 처리<br>
	 * 요청된 Port에서 Re-handling될 화물의 Cost를 산출조회.<br>
	 *
	 * @param BkgCodCostListVO bkgCodCostListVO
	 * @return List<BkgCodCostVO>
	 * @exception EventException
	 */
	public List<BkgCodCostVO> searchRehandlingCost(BkgCodCostListVO bkgCodCostListVO) throws EventException;

	
	/**
	 * 인터페이스 이벤트 처리<br>
	 * 요청된 Port에서 Re-handling될 화물의 Cost를 산출조회.<br>
	 *
	 * @param List<BkgCodCostListVO> searchList
	 * @return List
	 * @exception EventException
	 */
	public List<List<BkgCodCostVO>> searchRehandlingCost(List<BkgCodCostListVO> searchList) throws EventException;

}