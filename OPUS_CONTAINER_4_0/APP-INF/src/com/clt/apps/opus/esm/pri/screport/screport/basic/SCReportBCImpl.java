/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCReportBCImpl.java
*@FileTitle : Proposal Amendment Draft Print
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.screport.screport.basic;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.screport.screport.integration.SCReportDBDAO;
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
import com.clt.apps.opus.esm.pri.screport.screport.vo.PriMotChgRtVO;
//import com.clt.apps.opus.esm.pri.screport.screport.vo.MotFilingExclVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.backend.support.BackEndJobException;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSpHdrVO;
import com.clt.syscommon.common.table.PriSpMnVO;


/**
 * SCReport Business Logic Basic Command implementation<br>
 * - Handling a biz logic about SCReport<br>
 *
 * @author SHKIM
 * @see ESM_PRI_0039EventResponse,SCReportBC - refer to each DAO class
 * @since J2EE 1.6
 */
public class SCReportBCImpl extends BasicCommandSupport implements SCReportBC {

	// Database Access Object
	private transient SCReportDBDAO dbDao = null;

	/**
	 * Creating SCReportBCImpl object<br>
	 * Creating SCReportDBDAO<br>
	 */
	public SCReportBCImpl() {
		dbDao = new SCReportDBDAO();
	}
	/**
	 * Retrieving target SC List<br>
	 * 
	 * @param RptParaVO rptParaVO
	 * @return List<RsltRptPropListVO>
	 * @exception EventException
	 */
	public List<RsltRptPropListVO> searchReportProposalList(RptParaVO rptParaVO) throws EventException {
		try {
			return dbDao.searchReportProposalList(rptParaVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Retrieving SC basic information<br>
	 * 
	 * @param PriSpHdrVO priSpHdrVO
	 * @return List<RsltRptPropListVO>
	 * @exception EventException
	 */
	public List<RsltRptPropListVO> searchReportProposalInfo(PriSpHdrVO priSpHdrVO) throws EventException {
		try {
			return dbDao.searchReportProposalInfo(priSpHdrVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}	
	
	/**
	 * Retrieving Report related information<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @return List<RsltSCRetRDInfoVO>
	 * @exception EventException
	 */
	public List<RsltSCRetRDInfoVO> searchSCRetrievalRDInfo(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException {
		try {
			return dbDao.searchSCRetrievalRDInfo(priSpMnVO, account);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}	
	
	/**
	 * Retrieving Report related information<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @return List<RsltSCPrnVwRDInfoVO>
	 * @exception EventException
	 */
	public List<RsltSCPrnVwRDInfoVO> searchSCPrintViewRDInfo(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException {
		try {
			return dbDao.searchSCPrintViewRDInfo(priSpMnVO, account);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Retrieving MOT Filing List<br>
	 * 
	 * @param RsltSearchSCMOTFilingListVO RsltSearchSCMOTFilingListVO
	 * @param SignOnUserAccount account
	 * @return List<RsltSearchSCMOTFilingListVO>
	 * @exception EventException
	 */
	public List<RsltSearchSCMOTFilingListVO> searchSCMOTFilingList(RsltSearchSCMOTFilingListVO rsltSearchSCMOTFilingListVO, SignOnUserAccount account) throws EventException {
		try {
			return dbDao.searchSCMOTFilingList(rsltSearchSCMOTFilingListVO, account);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Retrieving S/C List Inquiry list.<br>
	 * 
	 * @param RsltSearchSCListVO rsltSearchSCListVO
	 * @return List<RsltSearchSCListVO>
	 * @exception EventException
	 */
	public List<RsltSearchSCListVO> searchSCList(RsltSearchSCListVO rsltSearchSCListVO) throws EventException {
		try {
			return dbDao.searchSCList(rsltSearchSCListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}		

	/**
	 * retrieving sum of S/C List Inquiry and count of sc no<br>
	 * 
	 * @param RsltSearchSCListVO rsltSearchSCListVO
	 * @return List<RsltSearchSCListVO>
	 * @exception EventException
	 */
	public List<RsltSearchSCListVO> searchSCSumList(RsltSearchSCListVO rsltSearchSCListVO) throws EventException {
		try {
			return dbDao.searchSCSumList(rsltSearchSCListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}		

	/**
	 * Putting in action BackEndJob to retrieve SC Performance Summary - View BL list<br>
	 * 
	 * @param SignOnUserAccount account
	 * @param RsltSearchSCBlListVO rsltSearchSCBlListVO
	 * @return String
	 * @exception EventException
	 */
	public String searchSCBlListDoStart(SignOnUserAccount account, RsltSearchSCBlListVO rsltSearchSCBlListVO) throws EventException {
		SearchSCBlListBackEndJob searchSCBlListBackEndJob = new SearchSCBlListBackEndJob();
		searchSCBlListBackEndJob.setRsltSearchSCBlListVO(rsltSearchSCBlListVO);
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		try {
			return backEndJobManager.execute(searchSCBlListBackEndJob, account.getUsr_id(), "ESM_PRI_0111 - Search");
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Putting in action BackEndJob to retrieve S/C Performance Summary list  <br>
	 * 
	 * @param SignOnUserAccount account
	 * @param RsltSearchSCPerfromanceVO rsltSearchSCPerfromanceVO
	 * @return String
	 * @exception EventException
	 */
	public String searchSCPerformanceSummaryListDoStart(SignOnUserAccount account, RsltSearchSCPerfromanceVO rsltSearchSCPerfromanceVO) throws EventException {
		SearchSCPerformanceSummaryListBackEndJob searchSCPerformanceSummaryListBackEndJob = new SearchSCPerformanceSummaryListBackEndJob();
		searchSCPerformanceSummaryListBackEndJob.setRsltSearchSCPerfromanceVO(rsltSearchSCPerfromanceVO);
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		try {
			return backEndJobManager.execute(searchSCPerformanceSummaryListBackEndJob, account.getUsr_id(), "ESM_PRI_0108_01 - Search");
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Retrieving Single scope S/C's count to retrieve S/C Performance Summary list.<br>
	 * 
	 * @param RsltSearchSCPerfromanceVO rsltSearchSCPerfromanceVO
	 * @return List<RsltSearchSCPerfromanceVO>
	 * @exception EventException
	 */
	public List<RsltSearchSCPerfromanceVO> searchSCPerformanceSummaryListScopeCnt(RsltSearchSCPerfromanceVO rsltSearchSCPerfromanceVO) throws EventException {
		try {
			return dbDao.searchSCPerformanceSummaryListScopeCnt(rsltSearchSCPerfromanceVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}		
	
	/**
	 * Putting in action BackEndJob to retrieve S/C Performance Summary - Detail list<br>
	 * 
	 * @param SignOnUserAccount account
	 * @param RsltSearchSCPerformanceDetailListVO rsltSearchSCPerformanceDetailListVO
	 * @return String
	 * @exception EventException
	 */
	public String searchSCPerformanceDetailListDoStart(SignOnUserAccount account, RsltSearchSCPerformanceDetailListVO rsltSearchSCPerformanceDetailListVO) throws EventException {
		SearchSCPerformanceDetailListBackEndJob searchSCPerformanceDetailListBackEndJob = new SearchSCPerformanceDetailListBackEndJob();
		searchSCPerformanceDetailListBackEndJob.setRsltSCPerformanceDetailListVO(rsltSearchSCPerformanceDetailListVO);
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		try {
			return backEndJobManager.execute(searchSCPerformanceDetailListBackEndJob, account.getUsr_id(), "ESM_PRI_0108_02 - Search");
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Retrieving combo of trade,sub trade, lane of S/C Performance Summary - Detail <br>
	 * 
	 * @param RsltSearchSCTradeSubTradeLaneListVO rsltSearchSCTradeSubTradeLaneListVO
	 * @return List<RsltSearchSCTradeSubTradeLaneListVO>
	 * @exception EventException
	 */
	public List<RsltSearchSCTradeSubTradeLaneListVO> searchSCTradeSubTradeLaneList(RsltSearchSCTradeSubTradeLaneListVO rsltSearchSCTradeSubTradeLaneListVO) throws EventException {
		try {
			return dbDao.searchSCTradeSubTradeLaneList(rsltSearchSCTradeSubTradeLaneListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}		

	/**
	 * Retrieving basic information about related sc no<br>
	 * 
	 * @param RsltSearchSCInfromationVO rsltSearchSCInfromationVO
	 * @return List<RsltSearchSCInfromationVO>
	 * @exception EventException
	 */
	public List<RsltSearchSCInfromationVO> searchSCInfromation(RsltSearchSCInfromationVO rsltSearchSCInfromationVO) throws EventException {
		try {
			return dbDao.searchSCInfromation(rsltSearchSCInfromationVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}		
	
	/**
	 * Retrieving Commodity, actual combo data <br>
	 * 
	 * @param RsltSearchSCPerformanceBulletListVO rsltSearchSCPerformanceBulletListVO
	 * @return List<RsltSearchSCPerformanceBulletListVO>
	 * @exception EventException
	 */
	public List<RsltSearchSCPerformanceBulletListVO> searchSCPerformanceBulletList(RsltSearchSCPerformanceBulletListVO rsltSearchSCPerformanceBulletListVO) throws EventException {
		try {
			return dbDao.searchSCPerformanceBulletList(rsltSearchSCPerformanceBulletListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}		

	
	/**
	 * Retrieving S/C Performance Summary - S/C TOTAL sum <br>
	 * 
	 * @param RsltSearchSCPerformanceDetailSumVO rsltSearchSCPerformanceDetailSumVO
	 * @return List<RsltSearchSCPerformanceDetailSumVO>
	 * @exception EventException
	 */
	public List<RsltSearchSCPerformanceDetailSumVO> searchSCPerformanceDetailSum(RsltSearchSCPerformanceDetailSumVO rsltSearchSCPerformanceDetailSumVO) throws EventException {
		try {
			return dbDao.searchSCPerformanceDetailSum(rsltSearchSCPerformanceDetailSumVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}		
	
	/**
	 * Putting in action BackEndJob to retrieve Rate Search list<br>
	 * 
	 * @param SignOnUserAccount account
	 * @param RsltSearchSCRateSearchListVO rsltSearchSCRateSearchListVO
	 * @return String
	 * @exception EventException
	 */	
	public String searchSCRateSearchListDoStart(SignOnUserAccount account, RsltSearchSCRateSearchListVO rsltSearchSCRateSearchListVO) throws EventException {
		SearchSCRateSearchListBackEndJob searchSCRateSearchListBackEndJob = new SearchSCRateSearchListBackEndJob();
		searchSCRateSearchListBackEndJob.setRsltSearchSCRateSearchListVO(rsltSearchSCRateSearchListVO);
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		try {
			return backEndJobManager.execute(searchSCRateSearchListBackEndJob, account.getUsr_id(), "ESM_PRI_0060 - Search");
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Retrieving Commodity, actual combo data <br>
	 * 
	 * @param RsltSearchSCRateSearchBulletListVO rsltSearchSCRateSearcheBulletListVO
	 * @return List<RsltSearchSCRateSearchBulletListVO>
	 * @exception EventException
	 */	
	public List<RsltSearchSCRateSearchBulletListVO> searchSCRateSearchBulletList(RsltSearchSCRateSearchBulletListVO rsltSearchSCRateSearcheBulletListVO) throws EventException {
		try {
			return dbDao.searchSCRateSearchBulletList(rsltSearchSCRateSearcheBulletListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}		
	
	/**
	 * Retrieving Destinatnion Arbitrary Guideline Inquiry list <br>
	 * 
	 * @param RsltSearchSCRateSearchDARListVO rsltSearchSCRateSearchDARListVO
	 * @return List<RsltSearchSCRateSearchDARListVO>
	 * @exception EventException
	 */	
	public List<RsltSearchSCRateSearchDARListVO> searchSCRateSearchDARList(RsltSearchSCRateSearchDARListVO rsltSearchSCRateSearchDARListVO) throws EventException {
		try {
			return dbDao.searchSCRateSearchDARList(rsltSearchSCRateSearchDARListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}	

	/**
	 * retrieving status value for BackEndJob result<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String comBakEndJbVOs(String key) throws EventException {
		DBRowSet rowSet;
		try {
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			return (String) rowSet.getObject("jb_sts_flg");
		} catch (BackEndJobException e) {
			throw new EventException(e.getMessage());
		} catch (SQLException e) {
			throw new EventException(e.getMessage());
		} catch (InterruptedException e) {
			throw new EventException(e.getMessage());
		} catch(Exception e){
			throw new EventException(e.getMessage());
		}
	}
	
    /**
     * MOT/SSE Filing 을 위한 일자별 대상 BKG 을 가져와 해당 일자의 Log 데이터를 생성한다.( Batch Job 호출 대상 ) 
     * -  중복 제거 이전.<br>
     * 
     * @param RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO
     * @exception EventException
     */
    public void createPriMotFileLogData(RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO ) throws EventException {
        try {
            if (rsltSearchMOTSSEFilingListVO != null) {
    			dbDao.createPriMotFileLogData(rsltSearchMOTSSEFilingListVO);
            }
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

	/**
	 * MOT/SSE Filing 을 위한 일별 데이터 중 OFT 가 Null 이거나 Zero 인 경우에 대해 생성된 Surcharge Detail 삭제
	 * MOT Tariff Matching 을 위한 준비 과정.<br>
	 * 
	 * @param RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO
	 * @exception EventException
	 */
	public void removePriMotFileRtLogDtlZeroOft(RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO) throws EventException{
		try {			
			dbDao.removePriMotFileRtLogDtlZeroOft(rsltSearchMOTSSEFilingListVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}


    /**
     * MOT/SSE Filing 을 위한 일별 데이터중에서 이전 Filing 되었던 것과 같은 건을 제거한 금일 Filing 대상 데이터 생성 한다.<br>
     * 
     * @param RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO
     * @exception EventException
     */
    public void createPriMotFileRtData(RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO ) throws EventException {
        try {
            if (rsltSearchMOTSSEFilingListVO != null) {
    			dbDao.createPriMotFileRtData(rsltSearchMOTSSEFilingListVO);
            }
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

	/**
	 * 기 실행된 MOT/SSE Filing List 삭제.<br>
	 * PRI_MOT_FILE_RT
	 * 
	 * @param RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO
	 * @exception EventException
	 */
	public void removePriMotFileRt(RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO) throws EventException{
		try {			
			dbDao.removePriMotFileRt(rsltSearchMOTSSEFilingListVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 기 실행된 MOT/SSE Filing List 삭제.<br>
	 * PRI_MOT_FILE_RT_SCG_DTL
	 * 
	 * @param RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO
	 * @exception EventException
	 */
	public void removePriMotFileRtScgDtl(RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO) throws EventException{
		try {			
			dbDao.removePriMotFileRtScgDtl(rsltSearchMOTSSEFilingListVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 기 실행된 MOT/SSE Filing List 삭제.<br>
	 * PRI_MOT_FILE_RT_LOG
	 * 
	 * @param RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO
	 * @exception EventException
	 */
	public void removePriMotFileRtLog(RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO) throws EventException{
		try {			
			dbDao.removePriMotFileRtLog(rsltSearchMOTSSEFilingListVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 기 실행된 MOT/SSE Filing List 삭제.<br>
	 * PRI_MOT_FILE_RT_LOG_DTL
	 * 
	 * @param RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO
	 * @exception EventException
	 */
	public void removePriMotFileRtLogDtl(RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO) throws EventException{
		try {			
			dbDao.removePriMotFileRtLogDtl(rsltSearchMOTSSEFilingListVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	


	//------------------------------------------
	// MOT Surcharge Creation START
	//------------------------------------------

	
	/**
	 *  MOT CHARGE retrieving<br>
	 *  mdm_charge mot charge code, description retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchMotChargeCdList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchMotChargeCdList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
	

	/**
	 * MOT Surcharge Creation정보를 조회한다.<br>
	 * 
     * @param RsltPriMotChgRtVO rsltPriMotChgRtVO
	 * @return List<PriMotChgRtVO>
	 * @exception EventException
	 */
	public List<PriMotChgRtVO> searchPriMotChgRt(RsltPriMotChgRtVO rsltPriMotChgRtVO) throws EventException {
		try {
			return dbDao.searchPriMotChgRt(rsltPriMotChgRtVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	
	/**
	 * PRI_MOT_CHG_RT 을 생성 합니다 .<br>
	 * 
	 * @param PriMotChgRtVO[] priMotChgRtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePriMotChgInfo(PriMotChgRtVO[] priMotChgRtVOs, SignOnUserAccount account) throws EventException {
		
		PriMotChgRtVO[] pVOs = priMotChgRtVOs;
		List<PriMotChgRtVO> iVOs = new ArrayList<PriMotChgRtVO>();
		List<PriMotChgRtVO> uVOs = new ArrayList<PriMotChgRtVO>();
		List<PriMotChgRtVO> dVOs = new ArrayList<PriMotChgRtVO>();
		
		try {
			
			int maxChgRtSeq = 0;
			for (int i = 0; pVOs != null && i < pVOs.length; i++) {
				if (pVOs[i].getIbflag().equals("I")) {
					
					maxChgRtSeq++;
					
					RsltPriMotChgRtVO rsltPriMotChgRtVO = new RsltPriMotChgRtVO();
					rsltPriMotChgRtVO.setChgCd(pVOs[i].getChgCd());
					rsltPriMotChgRtVO.setPolCd(pVOs[i].getPolCd());
					String sMaxChgRtSeq = dbDao.searchMaxChgRtSeqForPriMotChgRt(rsltPriMotChgRtVO);
					
					pVOs[i].setChgRtSeq(Integer.toString( Integer.parseInt(sMaxChgRtSeq)+maxChgRtSeq) );
					pVOs[i].setCreUsrId(account.getUsr_id());
					pVOs[i].setUpdUsrId(account.getUsr_id());
					iVOs.add(pVOs[i]);
				} else if (pVOs[i].getIbflag().equals("U")) {
					pVOs[i].setUpdUsrId(account.getUsr_id());
					uVOs.add(pVOs[i]);
				} else if (pVOs[i].getIbflag().equals("D")) {
					dVOs.add(pVOs[i]);
				}
			}
			
			if(dVOs.size() > 0) {
				dbDao.removePriMotChgRt(dVOs);
			}
			if(uVOs.size() > 0) {
				dbDao.updatePriMotChgRt(uVOs);
			}
			if(iVOs.size() > 0) {
				dbDao.addPriMotChgRt(iVOs);
			}
			
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	//------------------------------------------
	// MOT Surcharge Creation END
	//------------------------------------------
	
	
	//------------------------------------------
	// Filing List Inquiry(2015) START
	//------------------------------------------
	
	/**
	 * Charges를 조회(Header용).<br>
	 * 
	 * @param SearchMOTFileVO searchMOTFileVO
	 * @return List<RsltMOTFileHeaderVO>
	 * @exception EventException
	 */
	public List<RsltMOTFileHeaderVO> searchChargesForHead(SearchMOTFileVO searchMOTFileVO) throws EventException{
		try {
			return dbDao.searchMOTChargesForHead();			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	
	/**
	 * Filing List를 조회한다.<br>
	 * 
	 * @param SearchMOTFileVO searchMOTFileVO
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchPriMotFilingList(SearchMOTFileVO searchMOTFileVO) throws EventException {
		try {
			//(1) GET CHARGES FOR FILING
			String charges = dbDao.searchMOTCharges();
			DBRowSet result = null;
			//(2) GET FILING LIST
			if(searchMOTFileVO.getInqTpCd().equals("1")) {
				result=  dbDao.searchMOTFilingLogList(searchMOTFileVO, charges);
			} else if(searchMOTFileVO.getInqTpCd().equals("2")) {
				result = dbDao.searchMOTFilingLogWithBkgList(searchMOTFileVO, charges);
			} else if(searchMOTFileVO.getInqTpCd().equals("3")) {
				result = dbDao.searchMOTFilingList(searchMOTFileVO, charges);
			}
			return result;
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	
	/**
	 * Filing List를 조회한다.<br>
	 * 
	 * @param SearchMOTFileVO searchMOTFileVO
	 * @return List<MotFilingExclVO>
	 * @exception EventException
	 */
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	public List<MotFilingExclVO> searchPriMotFilingListForExcel(SearchMOTFileVO searchMOTFileVO) throws EventException {
//
//		try {
//			
//			//(1) retrieve Data
//			//(1-1) GET CHARGES FOR FILING
//			String charges = dbDao.searchMOTCharges();
//			DBRowSet result = null;
//			//(1-2) GET FILING LIST
//			if(searchMOTFileVO.getInqTpCd().equals("1")) {
//				result=  dbDao.searchMOTFilingLogList(searchMOTFileVO, charges);
//			} else if(searchMOTFileVO.getInqTpCd().equals("2")) {
//				result = dbDao.searchMOTFilingLogWithBkgList(searchMOTFileVO, charges);
//			} else if(searchMOTFileVO.getInqTpCd().equals("3")) {
//				result = dbDao.searchMOTFilingList(searchMOTFileVO, charges);
//			}
//			
//			List<MotFilingExclVO> rtnList = (List)rowSetToVOsForPri(result, MotFilingExclVO.class, charges);
//
//			return rtnList;
//			
//		} catch(DAOException ex) {
//			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
//		} catch (Exception ex) {
//			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
//		}
//	}	
	
	/**
	 * make the filing result data to the downloadable data. <br>
	 * change the framework's RowSetUtil.rowSetToVOs Method.
	 * there is two big issues 
	 * - include the single quote in the field name of the result data because of the pivot function
	 * - include the new-line character in some columns
	 * this re-created rowSetToVOsForPri method is maded to deal with these issues
	 * 
	 * @param DBRowSet rowSet	: the filing result data
	 * @param Class<?> clazz 	: vo class
	 * @param String charge  	: the value of Charges (ex : 'COV','COV_CUR','COV_EXE'.....)
	 * @return List<Object>
	 */
//	@SuppressWarnings({ "unused", "rawtypes" })
//	private List<Object> rowSetToVOsForPri(DBRowSet rowSet, Class<?> clazz, String charges) throws SQLException, NoSuchMethodException {
//		@SuppressWarnings("unchecked")
//		List<Object> voList = new ArrayList();
//		try
//		{
//			Object source = clazz.newInstance();
//			Method method = clazz.getDeclaredMethod("getFieldNames", new Class[0]);
//			HashMap<?, ?> map = (HashMap)method.invoke(source, new Object[0]);
//
//			ResultSetMetaData meta = rowSet.getMetaData();
//			int colCount = meta.getColumnCount() + 1;
//			while (rowSet.next()) {
//				Object target = clazz.newInstance();
//				for (int i = 1; i < colCount; i++) {
//					//remove single quote
//					String columnName = rowSet.getMetaData().getColumnName(i).toLowerCase().replace("'", "");
//					Object columnValue = null;
//					if (rowSet.getMetaData().getColumnType(i) == 2005) {
//						  columnValue = rowSet.getString(i);
//					} else {
//						//the charges are number filed
//						//the blank of the number filed must be zero
//						if (rowSet.getObject(i) == null && isNumberField(columnName, charges)) {
//							//the end of the number filed is ended as cur, it is not number filed
//							String strCol = columnName.toLowerCase().replace("'", "");
//							if(strCol.length() > 3 && strCol.substring(strCol.length() - 3, strCol.length()).equals("cur")){
//								columnValue = rowSet.getObject(i);
//							}  else {
//								columnValue = 0;
//							}
//							  
//						} else {
//							columnValue = rowSet.getObject(i);
//						}
//						 
//					}
//				  
//					//remove the new-line character in all fields
//					if( columnValue != null ){
//						columnValue = String.valueOf(columnValue).replace("\n"," ");
//					}
//	
//					String fieldName = (String)map.get(columnName);
//				  
//					if ((fieldName != null) && (!"".equals(fieldName))) {
//						String strFieldValue = "";
//						if (columnValue != null) {
//							strFieldValue = columnValue.toString();
//						}
//				    
//					    Field fld = getVoField(clazz, fieldName, columnName);
//				    	fld.setAccessible(true);
//				    	fld.set(target, strFieldValue);
//				    	
//					} else {
//						log.error("No definition in getFieldNames()  for DB Column[" + columnName + "]");
//					}
//				}
//				voList.add(target);
//			}
//		}
//		catch (InstantiationException e) {
//			log.error("InstantiationException [" + e.getMessage() + "]");
//			throw new RuntimeException("InstantiationException [" + e.getMessage() + "]");
//		} catch (IllegalAccessException e) {
//			log.error("IllegalAccessException [" + e.getMessage() + "]");
//			throw new RuntimeException("IllegalAccessException [" + e.getMessage() + "]");
//		} catch (SecurityException e) {
//			log.error("SecurityException [" + e.getMessage() + "]");
//			throw new RuntimeException("SecurityException [" + e.getMessage() + "]");
//		} catch (IllegalArgumentException e) {
//			log.error("IllegalArgumentException [" + e.getMessage() + "]");
//			throw new RuntimeException("IllegalArgumentException [" + e.getMessage() + "]");
//		} catch (InvocationTargetException e) {
//			log.error("InvocationTargetException [" + e.getMessage() + "]");
//			throw new RuntimeException("InvocationTargetException [" + e.getMessage() + "]");
//		} catch (Exception e){
//			log.error("Exception to be Occurred in IsNumberField [" + e.getMessage() + "]");
//			throw new RuntimeException("Exception to be Occurred in IsNumberField [" + e.getMessage() + "]");
//		}
//		return voList;
//	}
	
	/**
	 * get vo's filed name. <br>
	 * 
	 * @param Class<?> clazz 	: vo class
	 * @param String fieldName  	: vo's field name
	 * @param String columnName  	: database table's column name
	 * @return Field
	 * @exception Exception
	 */
	private Field getVoField(Class<?> clazz, String fieldName, String columnName) throws Exception{
		Field fld = null;
		try {
			fld = clazz.getDeclaredField(fieldName);
	    } catch (NoSuchFieldException e) {
	    	String errMsg = "No VO member variable[" + fieldName + "] for DB Column[" + columnName + "]";
	    	log.error(errMsg);
	    	throw new Exception("NoSuchFieldException["+errMsg+"] : " + e.getMessage());
	    }
		return fld;
	}
	
	/**
	 * check that the charge for compare is included in the charge list
	 * @param {String} starget : the value of compare
	 * @param {String} charges : the value of Charges (ex : 'COV','COV_CUR','COV_EXE'.....)
	 * @return {boolean} true/false 
	 */
	private boolean isNumberField(String starget, String charges) throws Exception{
		boolean result = false;
		
		try{
			if(charges != null && !StringUtils.isEmpty(charges)){
				String[] strArr = charges.split("\\,");
				if(strArr != null && strArr.length > 0){
					for(int i = 0; i < strArr.length; i++){
						if(strArr[i].toLowerCase().replace("'", "").equals(starget)){
							result = true;
							break;
						}
					}
				}
			}
		} catch (Exception e){
			log.error(this.getClass().getName()+".IsNumberField Method"+" - Check the null in the charges [" + e.getMessage() + "]");
			throw new Exception("Check the null in the charges [" + e.getMessage() + "]");
		}
		
		
		return result;
	}
	
	//------------------------------------------
	// Filing List Inquiry(2015) END
	//------------------------------------------
	
	/**
	 * retrive RFA/SC 's Commodity Note/Rate Note/Special Note.<br>
	 * 
	 * @param RsltSearchNoteCtntVO vo
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchNoteCtnt(RsltSearchNoteCtntVO vo)  throws EventException{
		try {
			return dbDao.searchNoteCtnt(vo);			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
}