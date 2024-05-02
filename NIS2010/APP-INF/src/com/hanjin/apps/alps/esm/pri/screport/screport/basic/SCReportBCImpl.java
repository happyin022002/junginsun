/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCReportBCImpl.java
*@FileTitle : Proposal Amendment Draft Print
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.28
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2009.06.25 변영주
* 1.0 Creation
* * =========================================================
* History
* 2010.10.04 송호진 [CHM-201006291-01] [긴급 요청사항] Session 정보 관련 getCre_usr_id - getUsr_id 로 교체
* 2013.05.28 이혜민 [CHM-201324516-01] Surcharge 종합체계 구축 T/F - Surcharge Summary Report 화면 신규개발 
* 2016.05.26 [CHM-201641700] [해수부 운임공표 및 신고제] 운임신고 관련 시스템 개발
* 2016.09.07 [CHM-201642825] [해수부 운임공표 및 신고제] 운임신고 관련 시스템 개발 (정식방식)
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.integration.SCReportDBDAO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.PriMofMapgHisVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.PriMofMapgVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RptParaVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RptSearchChargeSummaryReportBlInquiryVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RptSearchChargeSummaryReportSummaryViewVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltRptPropListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSCPrnVwRDInfoVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSCRetRDInfoVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchKoreaMOTListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchMOFLaneListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchMOTSSEFilingListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCBlListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCInfromationVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCMOTFilingListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCOutOfDateBkgListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCPerformanceBulletListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCPerformanceDetailListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCPerformanceDetailSumVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCPerfromanceVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCRateSearchBulletListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCRateSearchDARListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCRateSearchDoorListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCRateSearchListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCTimelyRateListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCTradeSubTradeLaneListVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.backend.support.BackEndJobException;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MdmChargeVO;
import com.hanjin.syscommon.common.table.PriMotTrfMnVO;
import com.hanjin.syscommon.common.table.PriSpHdrVO;
import com.hanjin.syscommon.common.table.PriSpMnVO;

/**
 * NIS2010-SCReport Business Logic Basic Command implementation<br>
 * - NIS2010-SCReport에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Byeon Young Joo
 * @see ESM_PRI_0039EventResponse,SCReportBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class SCReportBCImpl extends BasicCommandSupport implements SCReportBC {

	// Database Access Object
	private transient SCReportDBDAO dbDao = null;

	/**
	 * SCReportBCImpl 객체 생성<br>
	 * SCReportDBDAO를 생성한다.<br>
	 */
	public SCReportBCImpl() {
		dbDao = new SCReportDBDAO();
	}
	/**
	 * 대상 SC List 를 조회<br>
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
	 * SC 기본 정보를 조회<br>
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
	 * Report 관련 정보를 조회<br>
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
	 * Report 관련 정보를 조회<br>
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
	 * MOT Filing List를 조회<br>
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
	 * S/C List Inquiry 리스트를 조회.<br>
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
	 * S/C List Inquiry sum 과 sc no 갯수를 조회한다.<br>
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
	 * SC Performance Summary - View BL 리스트를 조회하기 위해 BackEndJob 을 실행한다.<br>
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
	 * S/C Performance Summary 리스트 조회를 위해 BackEndJob을 실행한다. <br>
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
	 * S/C Performance Summary 리스트 조회를 위해 Single scope S/C의 count를 조회한다.<br>
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
	 * S/C Performance Summary - Detail 리스트 조회를 위해 BackEndJob을 실행한다. <br>
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
	 * S/C Performance Summary - Detail 의 trade, sub trade, lane 콤보를 조회한다. <br>
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
	 * 해당 SC NO 에 대한 기본 내용을 조회한다. <br>
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
	 * Commodity, actual 콤보 데이터를 조회한다. <br>
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
	 * S/C Performance Summary - S/C TOTAL 합계내용을 조회한다. <br>
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
	 * Rate Search 리스트 조회를 위해 BackEndJob을 실행한다. <br>
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
	 *  Commodity, actual 콤보 데이터를 조회한다.  <br>
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
	 * Destinatnion Arbitrary Guideline Inquiry 리스트를 조회한다. <br>
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
	 *  US Route Cost Inquiry 리스트를 조회한다. <br>
	 * 
	 * @param RsltSearchSCRateSearchDoorListVO rsltSearchSCRateSearchDoorListVO
	 * @return List<RsltSearchSCRateSearchDoorListVO>
	 * @exception EventException
	 */	
	public List<RsltSearchSCRateSearchDoorListVO> searchSCRateSearchDoorList(RsltSearchSCRateSearchDoorListVO rsltSearchSCRateSearchDoorListVO) throws EventException {
		try {
			return dbDao.searchSCRateSearchDoorList(rsltSearchSCRateSearchDoorListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}		

	/**
	 * BackEndJob의 상태값을 조회한다.<br>
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
	 * Office /  S’rep 별로  적기 계약  생성에 대한  결과 값을 조회<br>
	 * 
	 * @param RsltSearchSCTimelyRateListVO rsltSearchSCTimelyRateListVO
	 * @return List<RsltSearchSCTimelyRateListVO>
	 * @throws EventException
	 */
	public List<RsltSearchSCTimelyRateListVO> searchTimelyRateCreationReport(RsltSearchSCTimelyRateListVO rsltSearchSCTimelyRateListVO) throws EventException{
		try {
			return dbDao.searchTimelyRateCreationReport(rsltSearchSCTimelyRateListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * 전체 대상 BKG 중 Batch Result 가 E (Error) 인 목록조회 <br>
	 * 
	 * @param RsltSearchSCOutOfDateBkgListVO rsltSearchSCOutOfDateBkgListVO
	 * @return List<RsltSearchSCOutOfDateBkgListVO>
	 * @throws EventException
	 */
	public List<RsltSearchSCOutOfDateBkgListVO> searchTimelyOutOfDateBookingList(RsltSearchSCOutOfDateBkgListVO rsltSearchSCOutOfDateBkgListVO) throws EventException{
		try {
			return dbDao.searchTimelyOutOfDateBookingList(rsltSearchSCOutOfDateBkgListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Charge Summary Report - Summary View Tab을 조회 위해 BackEndJob을 실행한다. <br>
	 * 
	 * @param RptSearchChargeSummaryReportSummaryViewVO rptSearchChargeSummaryReportSummaryViewVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String searchChargeSummaryReportSummaryViewDoStart(RptSearchChargeSummaryReportSummaryViewVO rptSearchChargeSummaryReportSummaryViewVO, SignOnUserAccount account) throws EventException {
		SearchChargeSummaryReportSummaryViewBackEndJob searchChargeSummaryReportSummaryViewBackEndJob = new SearchChargeSummaryReportSummaryViewBackEndJob();
		searchChargeSummaryReportSummaryViewBackEndJob.setRptSearchChargeSummaryReportSummaryViewVO(rptSearchChargeSummaryReportSummaryViewVO);
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		try {
			return backEndJobManager.execute(searchChargeSummaryReportSummaryViewBackEndJob, account.getUsr_id(), "ESM_PRI_0130 - Search");
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 입력한 OFC 유효성을 검증한다.<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 */
	public String searchOfcValid(String ofcCd) throws EventException{
		String[] ofcList = null;
		String rtnStr = null;
		String rtnList = null;
		try {
			ofcList = ofcCd.split(",");
			for(int i=0; i<ofcList.length; i++){
				rtnStr = dbDao.searchOfcValid(ofcList[i]);
				if(rtnStr.equals("0")){
					if(rtnList == null){
						rtnList = ofcList[i];
					}else{
						rtnList = rtnList + ", " + ofcList[i] ;
					}
				}
			}
			return rtnList;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Charge Summary Report - Detail View Tab을 조회 위해 BackEndJob을 실행한다. <br>
	 * 
	 * @param RptSearchChargeSummaryReportSummaryViewVO rptSearchChargeSummaryReportSummaryViewVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String searchChargeSummaryReportDetailViewDoStart(RptSearchChargeSummaryReportSummaryViewVO rptSearchChargeSummaryReportSummaryViewVO, SignOnUserAccount account) throws EventException {
		SearchChargeSummaryReportDetailViewBackEndJob searchChargeSummaryReportDetailViewBackEndJob = new SearchChargeSummaryReportDetailViewBackEndJob();
		searchChargeSummaryReportDetailViewBackEndJob.setRptSearchChargeSummaryReportSummaryViewVO(rptSearchChargeSummaryReportSummaryViewVO);
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		try {
			return backEndJobManager.execute(searchChargeSummaryReportDetailViewBackEndJob, account.getUsr_id(), "ESM_PRI_0130 - Search");
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Charge Summary Report - BL Inquiry 조회 위해 BackEndJob을 실행한다. <br>
	 * 
	 * @param RptSearchChargeSummaryReportBlInquiryVO rptSearchChargeSummaryReportBlInquiryVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String searchChargeSummaryBlInquiryDoStart(RptSearchChargeSummaryReportBlInquiryVO rptSearchChargeSummaryReportBlInquiryVO, SignOnUserAccount account) throws EventException {
		SearchChargeSummaryBlInquiryBackEndJob searchChargeSummaryBlInquiryBackEndJob = new SearchChargeSummaryBlInquiryBackEndJob();
		searchChargeSummaryBlInquiryBackEndJob.setRptSearchChargeSummaryReportBlInquiryVO(rptSearchChargeSummaryReportBlInquiryVO);
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		try {
			return backEndJobManager.execute(searchChargeSummaryBlInquiryBackEndJob, account.getUsr_id(), "ESM_PRI_0131 - Search");
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_0131 : BackEndJob 결과 - Account별 조회 이벤트 처리<br>
	 *
	 * @param String key
	 * @return List<Object>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<Object> excelDownChargeSummaryBlInquiry(String key) throws EventException {
		try {
			return (List<Object>)BackEndJobResult.loadFromFile(key);
		} catch (BackEndJobException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
	    } catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * charge 리스트를 조회합니다.<br>
	 * 
	 * @param MdmChargeVO mdmChargeVO
	 * @return List<MdmChargeVO>
	 * @exception EventException
	 */
	public List<MdmChargeVO> searchChargeList(MdmChargeVO mdmChargeVO) throws EventException {
		try {
			return dbDao.searchChargeList(mdmChargeVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * MOT/SSE Filing List Inquiry 리스트 조회를  실행한다. <br>
	 * 
	 * @param RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO
	 * @return List<RsltSearchMOTSSEFilingListVO>
	 * @exception EventException
	 */	
	public List<RsltSearchMOTSSEFilingListVO> searchMOTSSEFilingList(RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO) throws EventException {
		List<RsltSearchMOTSSEFilingListVO> list = null;
		try {
			if ( rsltSearchMOTSSEFilingListVO.getInqTpCd().equals("1")) {
				list = dbDao.searchMOTSSEFilingDailyLogList(rsltSearchMOTSSEFilingListVO);
			} else if ( rsltSearchMOTSSEFilingListVO.getInqTpCd().equals("2")) {
				list = dbDao.searchMOTSSEFilingDailyLogWithBkgList(rsltSearchMOTSSEFilingListVO);
			} else if ( rsltSearchMOTSSEFilingListVO.getInqTpCd().equals("3")) {
				list = dbDao.searchMOTSSEFilingDailyList(rsltSearchMOTSSEFilingListVO);
			}
			return list;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
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
     * MOT/SSE Filing 을 위한 일별 데이터 중에서 OFT 가 Null or Zero 인 경우에 대해 MOT Tariff 정보를 Matching 시켜 해당 Surcharge Data 를 복제 생성  한다.<br>
     * 
     * @param RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO
     * @exception EventException
     */
    public void createPriMotFileRtLogDtlMatchingTariff(RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO ) throws EventException {
        try {
            if (rsltSearchMOTSSEFilingListVO != null) {
    			dbDao.createPriMotFileRtLogDtlMatchingTariff(rsltSearchMOTSSEFilingListVO);
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
     * MOT/SSE Filing 을 위한 일별 데이터 중에서 OFT 가 Null or Zero 인 경우들에 대해 MOT Tariff 를 Matching 하여 OFT 와 Remark 를 Update 한다.<br>
     * 
     * @param RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO
     * @exception EventException
     */
    public void mergePriMotFileRtLogOFT(RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO ) throws EventException {
        try {
            if (rsltSearchMOTSSEFilingListVO != null) {
    			dbDao.mergePriMotFileRtLogOFT(rsltSearchMOTSSEFilingListVO);
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
	
	/**
	 * MOT Tariff List 를  조회 합니다.<br>
	 * 
	 * @param RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO
	 * @return List<RsltSearchMOTSSEFilingListVO>
	 * @exception EventException
	 */
	public List<RsltSearchMOTSSEFilingListVO> searchMOTSSETariffList(RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO) throws EventException {
		try {
			return dbDao.searchMOTSSETariffList(rsltSearchMOTSSEFilingListVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * MOT Tariff List 를  관리 합니다.<br>
	 * 
	 * @param PriMotTrfMnVO priMotTrfMnVO
	 * @param RsltSearchMOTSSEFilingListVO[] rsltSearchMOTSSEFilingListVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageMOTSSETariffList(PriMotTrfMnVO priMotTrfMnVO, RsltSearchMOTSSEFilingListVO[] rsltSearchMOTSSEFilingListVO, SignOnUserAccount account) throws EventException{
		int newRtSeq = -1;
		try {

			boolean ibNew = (priMotTrfMnVO.getMotTrfSeq() == null || "X".equals(priMotTrfMnVO.getMotTrfSeq())) ? true : false;
			if ("X".equals(priMotTrfMnVO.getMotTrfSeq())) {
				priMotTrfMnVO.setMotTrfSeq("-1");
			}
			boolean ibDateExist = dbDao.chkPriMotTrfMnEffDtExist(priMotTrfMnVO);

			if (ibNew && ibDateExist) {
				throw new EventException(new ErrorHandler("PRI08018").getMessage());
			}

			priMotTrfMnVO.setCreUsrId(account.getUsr_id());
			priMotTrfMnVO.setUpdUsrId(account.getUsr_id());

			if (ibNew) {
				int newMotTrfSeq = dbDao.searchPriMotTrfMnNewSeq(priMotTrfMnVO);
				priMotTrfMnVO.setMotTrfSeq(newMotTrfSeq+"");
				dbDao.addPriMotTrfMn(priMotTrfMnVO);
			} else {
				dbDao.modifyPriMotTrfMn(priMotTrfMnVO );
			}

			List<RsltSearchMOTSSEFilingListVO> insertRtVoList = new ArrayList<RsltSearchMOTSSEFilingListVO>();
			List<RsltSearchMOTSSEFilingListVO> updateRtVoList = new ArrayList<RsltSearchMOTSSEFilingListVO>();
			List<RsltSearchMOTSSEFilingListVO> deleteRtVoList = new ArrayList<RsltSearchMOTSSEFilingListVO>();

			List<RsltSearchMOTSSEFilingListVO> insertScgVoList = new ArrayList<RsltSearchMOTSSEFilingListVO>();
			List<RsltSearchMOTSSEFilingListVO> deleteScgVoList = new ArrayList<RsltSearchMOTSSEFilingListVO>();
			
			if ( rsltSearchMOTSSEFilingListVO != null && rsltSearchMOTSSEFilingListVO .length > 0  ) {
				for ( int i=0; i<rsltSearchMOTSSEFilingListVO .length; i++ ) {
					rsltSearchMOTSSEFilingListVO[i].setCreUsrId(account.getUsr_id());
					rsltSearchMOTSSEFilingListVO[i].setUpdUsrId(account.getUsr_id());					
					if ( rsltSearchMOTSSEFilingListVO[i].getIbflag().equals("I")){
						
						rsltSearchMOTSSEFilingListVO[i].setSvcScpCd(priMotTrfMnVO.getSvcScpCd());
						rsltSearchMOTSSEFilingListVO[i].setMotTrfSeq(priMotTrfMnVO.getMotTrfSeq());
						if ( newRtSeq == -1 ) newRtSeq = dbDao.searchPriMotTrfRtMaxSeq(priMotTrfMnVO);
						newRtSeq++;
						rsltSearchMOTSSEFilingListVO[i].setRtSeq(newRtSeq+"");
						insertRtVoList. add(rsltSearchMOTSSEFilingListVO[i]);
						insertScgVoList.add(rsltSearchMOTSSEFilingListVO[i]);
					} else if ( rsltSearchMOTSSEFilingListVO[i].getIbflag().equals("U")){
						updateRtVoList. add(rsltSearchMOTSSEFilingListVO[i]);
						deleteScgVoList.add(rsltSearchMOTSSEFilingListVO[i]);
						insertScgVoList.add(rsltSearchMOTSSEFilingListVO[i]);
					} else if ( rsltSearchMOTSSEFilingListVO[i].getIbflag().equals("D")){
						deleteRtVoList. add(rsltSearchMOTSSEFilingListVO[i]);
						deleteScgVoList.add(rsltSearchMOTSSEFilingListVO[i]);
					}
				}
				
				if ( insertRtVoList.size() > 0 ) {
					dbDao.addPriMotTrfRtList(insertRtVoList);
				}
				
				if ( updateRtVoList.size() > 0 ) {
					dbDao.modifyPriMotTrfRtList(updateRtVoList);
				}
				
				if ( deleteRtVoList.size() > 0 ) {
					dbDao.removePriMotTrfRtList(deleteRtVoList);
				}
	
				if ( deleteScgVoList.size() > 0 ) {
					dbDao.removePriMotTrfRtScgDtlList(deleteScgVoList);
				}
				
				if ( insertScgVoList.size() > 0 ) {
					dbDao.addPriMotTrfRtScgDtlList(insertScgVoList);
				}
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * 선택된 Service Scope에 등록된 MOT Tariff 리스트를 조회한다.<br>
	 * 
	 * @param RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO
	 * @return List<RsltGlineScpEffDtListVO>
	 * @exception EventException
	 */
	public List<RsltSearchMOTSSEFilingListVO> searchMotTrfScopeEffectiveDateList(RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO) throws EventException {
		try {
			return dbDao.searchMotTrfScopeEffectiveDateList(rsltSearchMOTSSEFilingListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}


	/**
	 * MOT Base Port List 를 조회합니다.<br>
	 * 
	 * @param String svcScpCd
	 * @param String orgDestTpCd
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchMotBsePortList(String svcScpCd, String orgDestTpCd) throws EventException {
		try {
			return dbDao.searchMotBsePortList(svcScpCd, orgDestTpCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * PRI Mot Tariff 내용 전체를 삭제한다. <br>
	 * 
	 * @param PriMotTrfMnVO priMotTrfMnVO
	 * @exception EventException
	 */
	public void removeMOTSSETariff(PriMotTrfMnVO priMotTrfMnVO) throws EventException{
		try {
			
			//헤더 별 모든 데이터를 삭제한다
			if(priMotTrfMnVO != null) {
				
				dbDao.removePriMotTrfRtScgDtlAll(priMotTrfMnVO);
				dbDao.removePriMotTrfRtAll(priMotTrfMnVO);
				dbDao.removePriMotTrfMn(priMotTrfMnVO);
				
			}	
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * MOT Tariff 화면을 위한 Service Scope Code List 를 조회합니다.<br>
	 * 
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchMotTrfSvcScpCdList() throws EventException {
		try {
			return dbDao.searchMotTrfSvcScpCdList();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	
	/**
	 * MOT Tariff 화면을 위한 Service Scope Code 별 Lane Code List 를 조회합니다.<br>
	 * 
	 * @param String svc_scp_cd
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchMotTrfLaneCdList(String svc_scp_cd) throws EventException {
		try {
			return dbDao.searchMotTrfLaneCdList(svc_scp_cd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Korea MOF Filing (by Upload) 리스트 조회를  실행한다. <br>
	 * 
	 * @param RsltSearchKoreaMOTListVO rsltSearchKoreaMOTListVO
	 * @return List<RsltSearchKoreaMOTListVO>
	 * @exception EventException
	 */
	public List<RsltSearchKoreaMOTListVO> searchKoreaMOTFilingList(RsltSearchKoreaMOTListVO rsltSearchKoreaMOTListVO) throws EventException {
		try {
			return dbDao.searchKoreaMOTFilingList(rsltSearchKoreaMOTListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Korea MOF Filing (by Upload) Send Email <br>
	 * 
	 * @param RsltSearchKoreaMOTListVO rsltSearchKoreaMOTListVO
	 * @param RsltSearchKoreaMOTListVO[] rsltSearchKoreaMOTListVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String multiKoreaMOTFilingList(RsltSearchKoreaMOTListVO rsltSearchKoreaMOTListVO, RsltSearchKoreaMOTListVO[] rsltSearchKoreaMOTListVOs, SignOnUserAccount account) throws EventException {
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		SearchKoreaMOTFilingEmailBackEndJob jobImpl = new SearchKoreaMOTFilingEmailBackEndJob();
		
		try {
			jobImpl.setRsltSearchKoreaMOTListVO(rsltSearchKoreaMOTListVO);
			jobImpl.setRsltSearchKoreaMOTListVOs(rsltSearchKoreaMOTListVOs);
			jobImpl.setAccount(account);
			
			return backEndJobManager.execute(jobImpl, account.getUsr_id(), "ESM_PRI_0150 - Send Email");
			
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Korea MOF Filing (Formatted) 리스트 조회를  실행한다. <br>
	 * 
	 * @param RsltSearchKoreaMOTListVO rsltSearchKoreaMOTListVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String searchMOFFilingList(RsltSearchKoreaMOTListVO rsltSearchKoreaMOTListVO, SignOnUserAccount account) throws EventException {
		SearchMOFFilingBackEndJob jobImpl = new SearchMOFFilingBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		
		try {
			jobImpl.setRsltSearchKoreaMOTListVO(rsltSearchKoreaMOTListVO);
			return backEndJobManager.execute(jobImpl, account.getUsr_id(), "ESM_PRI_0151 - Search");
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Korea MOF Filing (Base Table) - Scope & Location 리스트 조회를  실행한다. <br>
	 * 
	 * @param RsltSearchMOFLaneListVO rsltSearchMOFLaneListVO
	 * @return List<RsltSearchMOFLaneListVO>
	 * @exception EventException
	 */
	public List<RsltSearchMOFLaneListVO> searchPriMofLaneList(RsltSearchMOFLaneListVO rsltSearchMOFLaneListVO) throws EventException {
		try {
			return dbDao.searchPriMofLaneList(rsltSearchMOFLaneListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Korea MOF Filing (Base Table) - Scope & Location 정보를  관리  합니다.<br>
	 * 
	 * @param RsltSearchMOFLaneListVO[] rsltSearchMOFLaneListVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void managePriMofLaneList(RsltSearchMOFLaneListVO[] rsltSearchMOFLaneListVO, SignOnUserAccount account) throws EventException {
		try {
			List<RsltSearchMOFLaneListVO> insertVoList = new ArrayList<RsltSearchMOFLaneListVO>();
			List<RsltSearchMOFLaneListVO> updateVoList = new ArrayList<RsltSearchMOFLaneListVO>();
			List<RsltSearchMOFLaneListVO> deleteVoList = new ArrayList<RsltSearchMOFLaneListVO>();
			for ( int i=0; i<rsltSearchMOFLaneListVO .length; i++ ) {
				if ( rsltSearchMOFLaneListVO[i].getIbflag().equals("I")){
					rsltSearchMOFLaneListVO[i].setCreUsrId(account.getUsr_id());
					rsltSearchMOFLaneListVO[i].setCreOfcCd(account.getOfc_cd());
					rsltSearchMOFLaneListVO[i].setUpdUsrId(account.getUsr_id());
					rsltSearchMOFLaneListVO[i].setUpdOfcCd(account.getOfc_cd());
					insertVoList.add(rsltSearchMOFLaneListVO[i]);
				} else if ( rsltSearchMOFLaneListVO[i].getIbflag().equals("U")){
					rsltSearchMOFLaneListVO[i].setUpdUsrId(account.getUsr_id());
					rsltSearchMOFLaneListVO[i].setUpdOfcCd(account.getOfc_cd());
					updateVoList.add(rsltSearchMOFLaneListVO[i]);
				} else if ( rsltSearchMOFLaneListVO[i].getIbflag().equals("D")){
					rsltSearchMOFLaneListVO[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(rsltSearchMOFLaneListVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addPriMOFLane(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyMOFLane(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeMOFLane(deleteVoList);
			}
			
			// history
			List<RsltSearchMOFLaneListVO> historyVoList = new ArrayList<RsltSearchMOFLaneListVO>();
			for ( int i=0; i<rsltSearchMOFLaneListVO .length; i++ ) {
				rsltSearchMOFLaneListVO[i].setCreUsrId(account.getUsr_id());
				rsltSearchMOFLaneListVO[i].setCreOfcCd(account.getOfc_cd());
				rsltSearchMOFLaneListVO[i].setUpdUsrId(account.getUsr_id());
				rsltSearchMOFLaneListVO[i].setUpdOfcCd(account.getOfc_cd());
				historyVoList.add(rsltSearchMOFLaneListVO[i]);
			}
			
			if ( historyVoList.size() > 0 ) {
				dbDao.addPriMOFLaneHistory(historyVoList);
			}
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Korea MOF Filing Mapping 리스트 조회를  실행한다. <br>
	 * 
	 * @param PriMofMapgVO priMofMapgVO
	 * @return List<PriMofMapgVO>
	 * @exception EventException
	 */
	public List<PriMofMapgVO> searchPriMofMapgList(PriMofMapgVO priMofMapgVO) throws EventException{
		try {
			return dbDao.searchPriMofMapg(priMofMapgVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Korea MOF Filing Mapping 리스트를 저장/변경/삭제한다. <br>
	 * 
	 * @param PriMofMapgVO[] priMofMapgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePriMofMapg(PriMofMapgVO[] priMofMapgVOs, PriMofMapgHisVO[] priMofMapgHisVOs, SignOnUserAccount account) throws EventException{
		try {
			List<PriMofMapgVO> insertVoList = new ArrayList<PriMofMapgVO>();
			List<PriMofMapgVO> updateVoList = new ArrayList<PriMofMapgVO>();
			List<PriMofMapgVO> deleteVoList = new ArrayList<PriMofMapgVO>();
			List<PriMofMapgHisVO> historyVoList = new ArrayList<PriMofMapgHisVO>();
			
			for (int i = 0; i < priMofMapgVOs.length; i++) {
				priMofMapgVOs[i].setCreOfcCd(account.getOfc_cd());
				priMofMapgVOs[i].setUpdOfcCd(account.getOfc_cd());
				priMofMapgVOs[i].setUpdUsrId(account.getUsr_id());
				priMofMapgVOs[i].setCreUsrId(account.getUsr_id());
				priMofMapgHisVOs[i].setCreOfcCd(account.getOfc_cd());
				priMofMapgHisVOs[i].setUpdOfcCd(account.getOfc_cd());
				priMofMapgHisVOs[i].setUpdUsrId(account.getUsr_id());
				priMofMapgHisVOs[i].setCreUsrId(account.getUsr_id());
				if ( priMofMapgVOs[i].getIbflag().equals("I")){
					priMofMapgHisVOs[i].setUpdTpNm("INSERT");
//					List<PriMofMapgVO> list = dbDao.searchPriMofMapgSeq(priMofMapgVOs[i]);
//					String seq = null;
//					seq = list.get(0).getMapgSeq();
//					priMofMapgVOs[i].setMapgSeq(seq);
//					priMofMapgHisVOs[i].setMapgSeq(seq);
					
					insertVoList.add(priMofMapgVOs[i]);
					historyVoList.add(priMofMapgHisVOs[i]);
//					dbDao.addPriMofMapg(priMofMapgVOs[i]);
//					dbDao.addPriMofMapgHis(priMofMapgHisVOs[i]);
				} else if ( priMofMapgVOs[i].getIbflag().equals("U")){
					priMofMapgHisVOs[i].setUpdTpNm("UPDATE");
					updateVoList.add(priMofMapgVOs[i]);
					historyVoList.add(priMofMapgHisVOs[i]);
//					dbDao.modifyPriMofMapg(priMofMapgVOs[i]);
//					dbDao.addPriMofMapgHis(priMofMapgHisVOs[i]);
				} else if ( priMofMapgVOs[i].getIbflag().equals("D")){
					priMofMapgHisVOs[i].setUpdTpNm("DELETE");
					deleteVoList.add(priMofMapgVOs[i]);
					historyVoList.add(priMofMapgHisVOs[i]);
//					dbDao.removePriMofMapg(priMofMapgVOs[i]);
//					dbDao.addPriMofMapgHis(priMofMapgHisVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addPriMofMapg(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyPriMofMapg(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removePriMofMapg(deleteVoList);
			}

			if ( historyVoList.size() > 0 ) {
				dbDao.addPriMofMapgHis(historyVoList);
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	
	
}