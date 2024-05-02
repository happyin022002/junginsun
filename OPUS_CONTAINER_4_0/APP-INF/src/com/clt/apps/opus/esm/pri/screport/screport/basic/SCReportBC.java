/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCReportBC.java
*@FileTitle : Proposal Amendment Draft Print
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.screport.screport.basic;

import java.util.List;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.PriMotChgRtVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RptParaVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltMOTFileHeaderVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltPriMotChgRtVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltRptPropListVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSCPrnVwRDInfoVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSCRetRDInfoVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchMOTSSEFilingListVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchNoteCtntVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCBlListVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCInfromationVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCListVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCMOTFilingListVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCPerformanceBulletListVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCPerformanceDetailListVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCPerformanceDetailSumVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCPerfromanceVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCRateSearchBulletListVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCRateSearchDARListVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCRateSearchListVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCTradeSubTradeLaneListVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.SearchMOTFileVO;
//import com.clt.apps.opus.esm.pri.screport.screport.vo.MotFilingExclVO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSpHdrVO;
import com.clt.syscommon.common.table.PriSpMnVO;

/**
 * Screport Business Logic Command Interface<br>
 * - Handling a biz logic about Screport<br>
 *
 * @author PRI
 * @see Esm_pri_0039EventResponse 
 * @since J2EE 1.6
 */

public interface SCReportBC {
	/**
	 * Retrieving target SC List<br>
	 * 
	 * @param RptParaVO rptParaVO
	 * @return List<RsltRptPropListVO>
	 * @exception EventException
	 */
	public List<RsltRptPropListVO> searchReportProposalList(RptParaVO rptParaVO) throws EventException;
	/**
	 * Retrieving SC basic information<br>
	 * 
	 * @param PriSpHdrVO priSpHdrVO
	 * @return List<RsltRptPropListVO>
	 * @exception EventException
	 */
	public List<RsltRptPropListVO> searchReportProposalInfo(PriSpHdrVO priSpHdrVO) throws EventException;
	/**
	 * Retrieving Report related information<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @return List<RsltSCRetRDInfoVO>
	 * @exception EventException
	 */
	public List<RsltSCRetRDInfoVO> searchSCRetrievalRDInfo(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException;
	/**
	 * Retrieving Report related information<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @return List<RsltSCPrnVwRDInfoVO>
	 * @exception EventException
	 */
	public List<RsltSCPrnVwRDInfoVO> searchSCPrintViewRDInfo(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException;

	/**
	 * Retrieving MOT Filing List<br>
	 * 
	 * @param RsltSearchSCMOTFilingListVO rsltSearchSCMOTFilingListVO
	 * @param SignOnUserAccount account
	 * @return List<RsltSearchSCMOTFilingListVO>
	 * @exception EventException
	 */
	public List<RsltSearchSCMOTFilingListVO> searchSCMOTFilingList(RsltSearchSCMOTFilingListVO rsltSearchSCMOTFilingListVO, SignOnUserAccount account) throws EventException;

	/**
	 * Retrieving S/C List Inquiry list.<br>
	 * 
	 * @param RsltSearchSCListVO rsltSearchSCListVO
	 * @return List<RsltSearchSCListVO>
	 * @exception EventException
	 */
	public List<RsltSearchSCListVO> searchSCList(RsltSearchSCListVO rsltSearchSCListVO) throws EventException;
	
	/**
	 * retrieving sum of S/C List Inquiry and count of sc no<br>
	 * 
	 * @param RsltSearchSCListVO rsltSearchSCListVO
	 * @return List<RsltSearchSCListVO>
	 * @exception EventException
	 */
	public List<RsltSearchSCListVO> searchSCSumList(RsltSearchSCListVO rsltSearchSCListVO) throws EventException;	

	/**
	 * Putting in action BackEndJob to retrieve SC Performance Summary - View BL list<br>
	 * 
	 * @param SignOnUserAccount account
	 * @param RsltSearchSCPerfromanceVO rsltSearchSCPerfromanceVO
	 * @return String
	 * @exception EventException
	 */
	public String searchSCPerformanceSummaryListDoStart(SignOnUserAccount account, RsltSearchSCPerfromanceVO rsltSearchSCPerfromanceVO) throws EventException;

	/**
	 * Retrieving Single scope S/C's count to retrieve S/C Performance Summary list.<br>
   *
	 * @param RsltSearchSCPerfromanceVO rsltSearchSCPerfromanceVO
	 * @return List<RsltSearchSCPerfromanceVO>
	 * @exception EventException
	 */
	public List<RsltSearchSCPerfromanceVO> searchSCPerformanceSummaryListScopeCnt(RsltSearchSCPerfromanceVO rsltSearchSCPerfromanceVO) throws EventException;	
	
	/**
	 * Putting in action BackEndJob to retrieve SC Performance Summary - View BL list<br>
     *
	 * @param SignOnUserAccount account
	 * @param RsltSearchSCBlListVO rsltSearchSCBlListVO
	 * @return String
	 * @exception EventException
	 */
	public String searchSCBlListDoStart(SignOnUserAccount account, RsltSearchSCBlListVO rsltSearchSCBlListVO) throws EventException;
	
	/**
	 * Putting in action BackEndJob to retrieve S/C Performance Summary list  <br>
     *
	 * @param SignOnUserAccount account
	 * @param RsltSearchSCPerformanceDetailListVO rsltSearchSCPerformanceDetailListVO
	 * @return String
	 * @exception EventException
	 */
	public String searchSCPerformanceDetailListDoStart(SignOnUserAccount account, RsltSearchSCPerformanceDetailListVO rsltSearchSCPerformanceDetailListVO) throws EventException;	
	
	/**
	 * Retrieving combo of trade,sub trade, lane of S/C Performance Summary - Detail <br>
     *
	 * @param RsltSearchSCTradeSubTradeLaneListVO rsltSearchSCTradeSubTradeLaneListVO
	 * @return List<RsltSearchSCTradeSubTradeLaneListVO>
	 * @exception EventException
	 */
	public List<RsltSearchSCTradeSubTradeLaneListVO> searchSCTradeSubTradeLaneList(RsltSearchSCTradeSubTradeLaneListVO rsltSearchSCTradeSubTradeLaneListVO) throws EventException;	
	/**
	 * Retrieving basic information about related sc no<br>
     *
	 * @param RsltSearchSCInfromationVO rsltSearchSCInfromationVO
	 * @return List<RsltSearchSCInfromationVO>
	 * @exception EventException
	 */
	public List<RsltSearchSCInfromationVO> searchSCInfromation(RsltSearchSCInfromationVO rsltSearchSCInfromationVO) throws EventException;	
	
	/**
	 * Retrieving Commodity, actual combo data <br>
   *
	 * @param RsltSearchSCPerformanceBulletListVO rsltSearchSCPerformanceBulletListVO
	 * @return List<RsltSearchSCPerformanceBulletListVO>
	 * @exception EventException
	 */
	public List<RsltSearchSCPerformanceBulletListVO> searchSCPerformanceBulletList(RsltSearchSCPerformanceBulletListVO rsltSearchSCPerformanceBulletListVO) throws EventException;	
	/**
	 * Retrieving S/C Performance Summary - S/C TOTAL sum <br>
   *
	 * @param RsltSearchSCPerformanceDetailSumVO rsltSearchSCPerformanceDetailSumVO
	 * @return List<RsltSearchSCPerformanceDetailSumVO>
	 * @exception EventException
	 */
	public List<RsltSearchSCPerformanceDetailSumVO> searchSCPerformanceDetailSum(RsltSearchSCPerformanceDetailSumVO rsltSearchSCPerformanceDetailSumVO) throws EventException;	
	/**
	 * Putting in action BackEndJob to retrieve Rate Search list<br>
     *
	 * @param SignOnUserAccount account
	 * @param RsltSearchSCRateSearchListVO rsltSearchSCRateSearchListVO
	 * @return String
	 * @exception EventException
	 */
	public String searchSCRateSearchListDoStart(SignOnUserAccount account, RsltSearchSCRateSearchListVO rsltSearchSCRateSearchListVO) throws EventException;
	/**
	 * Retrieving Commodity, actual combo data <br>
     *
	 * @param RsltSearchSCRateSearchBulletListVO rsltSearchSCRateSearchBulletListVO
	 * @return List<RsltSearchSCRateSearchBulletListVO>
	 * @exception EventException
	 */
	public List<RsltSearchSCRateSearchBulletListVO> searchSCRateSearchBulletList(RsltSearchSCRateSearchBulletListVO rsltSearchSCRateSearchBulletListVO) throws EventException;	
	/**
	 * Retrieving Destination Arbitrary Guideline Inquiry list <br>
   *
	 * @param RsltSearchSCRateSearchDARListVO rsltSearchSCRateSearchDARListVO
	 * @return List<RsltSearchSCRateSearchDARListVO>
	 * @exception EventException
	 */
	public List<RsltSearchSCRateSearchDARListVO> searchSCRateSearchDARList(RsltSearchSCRateSearchDARListVO rsltSearchSCRateSearchDARListVO) throws EventException;	
	
	/**
	 * retrieving status value for BackEndJob result<br>
	 * 
	 * @param String object
	 * @return String
	 * @exception EventException
	 */
	public String comBakEndJbVOs(String object) throws EventException;
	
    /**
     * Write the log about daily target booking for MOT/SSE Filing ( Batch Job Call ) 
     * -  Before delete duplication <br>
     * 
     * @param RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO
     * @exception EventException
     */
    public void createPriMotFileLogData(RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO ) throws EventException ;

	/**
	 * MOT/SSE Filing 을 위한 일별 데이터 중 OFT 가 Null 이거나 Zero 인 경우에 대해 생성된 Surcharge Detail 삭제
	 * MOT Tariff Matching 을 위한 준비 과정.<br>
	 * 
	 * @param RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO
	 * @exception EventException
	 */
	public void removePriMotFileRtLogDtlZeroOft(RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO) throws EventException;
	
    /**
     * MOT/SSE Filing 을 위한 일별 데이터중에서 이전 Filing 되었던 것과 같은 건을 제거한 금일 Filing 대상 데이터 생성 한다.<br>
     * 
     * @param RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO
     * @exception EventException
     */
    public void createPriMotFileRtData(RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO ) throws EventException ;

	/**
	 * Delete exist MOT/SSE Filing List <br>
	 * PRI_MOT_FILE_RT
	 * 
	 * @param RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO
	 * @exception EventException
	 */
	public void removePriMotFileRt(RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO) throws EventException;
	
	/**
	 * Delete exist MOT/SSE Filing List<br>
	 * PRI_MOT_FILE_RT_SCG_DTL
	 * 
	 * @param RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO
	 * @exception EventException
	 */
	public void removePriMotFileRtScgDtl(RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO) throws EventException;
	
	/**
	 * Delete exist MOT/SSE Filing List <br>
	 * PRI_MOT_FILE_RT_LOG
	 * 
	 * @param RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO
	 * @exception EventException
	 */
	public void removePriMotFileRtLog(RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO) throws EventException;
	
	/**
	 * Delete exist MOT/SSE Filing List <br>
	 * PRI_MOT_FILE_RT_LOG_DTL
	 * 
	 * @param RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO
	 * @exception EventException
	 */
	public void removePriMotFileRtLogDtl(RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO) throws EventException;

	/**
	 *  MOT CHARGE retrieving<br>
	 *  mdm_charge mot charge code, description retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchMotChargeCdList(RsltCdListVO rsltCdlistVo) throws EventException;
	
	/**
	 * MOT Surcharge Creation정보를 조회한다.<br>
	 * 
     * @param RsltPriMotChgRtVO rsltPriMotChgRtVO
	 * @return List<PriMotChgRtVO>
	 * @exception EventException
	 */
	public List<PriMotChgRtVO> searchPriMotChgRt(RsltPriMotChgRtVO rsltPriMotChgRtVO) throws EventException;
	
	
	/**
	 * PRI_MOT_CHG_RT 을 생성 합니다 .<br>
	 * 
	 * @param PriMotChgRtVO[] priMotChgRtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePriMotChgInfo(PriMotChgRtVO[] priMotChgRtVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Charges를 조회(Header용).<br>
	 * 
	 * @param SearchMOTFileVO searchMOTFileVO
	 * @return List<RsltMOTFileHeaderVO>
	 * @exception EventException
	 */
	public List<RsltMOTFileHeaderVO> searchChargesForHead(SearchMOTFileVO searchMOTFileVO) throws EventException;
	
	/**
	 * Filing List를 조회한다.<br>
	 * 
	 * @param SearchMOTFileVO searchMOTFileVO
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchPriMotFilingList(SearchMOTFileVO searchMOTFileVO) throws EventException;
	
	
	/**
	 * Filing List를 조회한다.<br>
	 * 
	 * @param SearchMOTFileVO searchMOTFileVO
	 * @return List<MotFilingExclVO>
	 * @exception EventException
	 */
//	public List<MotFilingExclVO> searchPriMotFilingListForExcel(SearchMOTFileVO searchMOTFileVO) throws EventException;

	/**
	 * retrieve RFA/SC 's Commodity Note/Rate Note/Special Note.<br>
	 * 
	 * @param RsltSearchNoteCtntVO vo
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchNoteCtnt(RsltSearchNoteCtntVO vo)  throws EventException;
	
}