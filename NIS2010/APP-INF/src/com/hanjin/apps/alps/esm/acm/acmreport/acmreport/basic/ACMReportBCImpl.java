/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMReportBCImpl.java
*@FileTitle : ACMReportBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.16
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.05.16 김봉균
* 1.0 Creation
* 
* 2014.06.11 박다은 [CHM-201428456] Comm 모듈의 ACM 발행 CSR Detail 기능 로직 변경
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmreport.acmreport.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.acm.acmreport.acmreport.integration.ACMReportDBDAO;
import com.hanjin.apps.alps.esm.acm.acmreport.acmreport.vo.CSRDetailVO;
import com.hanjin.apps.alps.esm.acm.acmreport.acmreport.vo.CSRInquiryVO;
import com.hanjin.apps.alps.esm.acm.acmreport.acmreport.vo.CommReportVO;
import com.hanjin.apps.alps.esm.acm.acmreport.acmreport.vo.EstimatedPerformanceVO;
import com.hanjin.apps.alps.esm.acm.acmreport.acmreport.vo.ReportItemVO;
import com.hanjin.apps.alps.esm.acm.acmreport.acmreport.vo.CSRDetailforCommissionVO;
import com.hanjin.apps.alps.esm.acm.acmreport.acmreport.vo.CSRDetailforCommissionHdVO;
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


/**
 * ALPS-ACMReport Business Logic Command Interface<br>
 * - ALPS-ACMReport에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM, Bong-Gyoon
 * @see Esm_Acm_0034Event,ACMReportBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class ACMReportBCImpl extends BasicCommandSupport implements ACMReportBC {

	// Database Access Object
	private transient ACMReportDBDAO dbDao = null;

	/**
	 * ACMReportBCImpl 객체 생성<br>
	 * ACMReportDBDAO를 생성한다.<br>
	 */
	public ACMReportBCImpl() {
		dbDao = new ACMReportDBDAO();
	}

	/**
	 * BackEndJob공통 - BackEndJob status를 return<br>
	 *
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String getBackEndJobStatus(String key) throws EventException {
		try {
			DBRowSet rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			return (String) rowSet.getObject("jb_sts_flg");
		} catch (BackEndJobException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (SQLException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (InterruptedException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0034]
	 * CSR Inquiry 목록을 조회<br>
	 *
	 * @param CSRInquiryVO csrInquiryVO
	 * @return List<CSRInquiryVO>
	 * @exception EventException
	 */
	public List<CSRInquiryVO> searchCSRInquiry(CSRInquiryVO csrInquiryVO) throws EventException {
		try {
			return dbDao.searchCSRInquiry(csrInquiryVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0034]
	 * CSR Inquiry 목록을 조회(CURR_CD에 따른 Total 값 구하기)<br>
	 *
	 * @param CSRInquiryVO csrInquiryVO
	 * @return List<CSRInquiryVO>
	 * @exception EventException
	 */
	public List<CSRInquiryVO> searchCSRInquiryCurrAMT(CSRInquiryVO csrInquiryVO) throws EventException {
		try {
			return dbDao.searchCSRInquiryCurrAMT(csrInquiryVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0111] Retrieve<br>
	 * CSR Detail 목록을 조회<br>
	 *
	 * @param CSRDetailVO csrDetailVO
	 * @return List<CSRDetailVO>
	 * @exception EventException
	 */
	public List<CSRDetailVO> searchCSRDetail(CSRDetailVO csrDetailVO) throws EventException {
		try {
			return dbDao.searchCSRDetail(csrDetailVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0037], [ESM_ACM_0118] 
	 * Customized RPT Form 콤보 그룹명을 조회<br>
	 *
	 * @param SignOnUserAccount account
	 * @return List<ReportItemVO>
	 * @exception EventException
	 */
	public List<ReportItemVO> getReportGroup(SignOnUserAccount account) throws EventException {
		ReportItemVO reportItemVO = new ReportItemVO();
		reportItemVO.setUsrId(account.getUsr_id());
		try {
			return dbDao.getReportGroup(reportItemVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0037], [ESM_ACM_0118]
	 * Customized RPT Form 컬럼 Item 목록을 조회
	 *
	 * @param ReportItemVO reportItemVO
	 * @param SignOnUserAccount account
	 * @return List<ReportItemVO>
	 * @exception EventException
	 */
	public List<ReportItemVO> getReportItem(ReportItemVO reportItemVO, SignOnUserAccount account) throws EventException {
		reportItemVO.setUsrId(account.getUsr_id());
		try {
			return dbDao.getReportItem(reportItemVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0037] BackEndJob 시작<br>
	 *
	 * @param CommReportVO commReportVO
	 * @param SignOnUserAccount account
	 * @return String
	 */
	public String startBackEndJobSearchCommReport(CommReportVO commReportVO, SignOnUserAccount account) {
		ACMReportBackEndJobSearchCommReport acmReportBackEndJobSearchCommReport = new ACMReportBackEndJobSearchCommReport();
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		acmReportBackEndJobSearchCommReport.setCommReportVO(commReportVO);
		return backEndJobManager.execute(acmReportBackEndJobSearchCommReport, account.getUsr_id(), "ESM_ACM_0037 Back End");
	}

	/**
	 * [ESM_ACM_0037] BackEndJob 결과
	 * Commission Report 목록을 조회<br>
	 *
	 * @param String key
	 * @return List<CommReportVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<CommReportVO> resultBackEndJobSearchCommReport(String key) throws EventException {
		try {
			return (List<CommReportVO>)BackEndJobResult.loadFromFile(key);
		} catch (BackEndJobException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
	    } catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0118]
	 * Customized RPT Form 콤보 그룹명과 컬럼 Item 목록을 저장
	 *
	 * @param ReportItemVO reportItemVO
	 * @param ReportItemVO[] reportItemVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageReportItem(ReportItemVO reportItemVO, ReportItemVO[] reportItemVOs, SignOnUserAccount account) throws EventException {
		reportItemVO.setUsrId(account.getUsr_id());
		try {
			if ("I".equals(reportItemVO.getSaveFlag())) {
				String maxSlctItmFomSeq = dbDao.getMaxSlctItmFomSeq(reportItemVO).get(0).getSlctItmFomSeq();
				reportItemVO.setSlctItmFomSeq(maxSlctItmFomSeq);
				dbDao.addReportGroup(reportItemVO);
				List<ReportItemVO> insertVoList = new ArrayList<ReportItemVO>();
				for (int i=0; i<reportItemVOs.length; i++) {
					reportItemVOs[i].setUsrId(account.getUsr_id());
					reportItemVOs[i].setSlctItmFomSeq(maxSlctItmFomSeq);
					insertVoList.add(reportItemVOs[i]);
				}
				dbDao.addReportItem(insertVoList);
			} else {
				dbDao.removeReportGroup(reportItemVO);
				dbDao.removeReportItem(reportItemVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * [ESM_ACM_9991]
	 * Estimated Performance 목록을 조회<br>
	 *
	 * @param EstimatedPerformanceVO estimatedPerformanceVO
	 * @return List<EstimatedPerformanceVO>
	 * @exception EventException
	 */
	
	public List<EstimatedPerformanceVO> searchEstimatedPerformance(EstimatedPerformanceVO estimatedPerformanceVO) throws EventException{
		try {
			return dbDao.searchEstimatedPerformance(estimatedPerformanceVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * [ESM_ACM_9991]
	 * Estimated Performance 목록을 저장<br>
	 *
	 * @param EstimatedPerformanceVO[] estimatedPerformanceVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageEstimatedPerformance(EstimatedPerformanceVO[] estimatedPerformanceVOs, SignOnUserAccount account) throws EventException {
		try {
			List<EstimatedPerformanceVO> insertVoList = new ArrayList<EstimatedPerformanceVO>();
			List<EstimatedPerformanceVO> updateVoList = new ArrayList<EstimatedPerformanceVO>();
			
			for (int i=0; i<estimatedPerformanceVOs.length; i++) {
				
					estimatedPerformanceVOs[i].setUsrId(account.getUsr_id());
					if (estimatedPerformanceVOs[i].getIbflag().equals("I")) {
						insertVoList.add(estimatedPerformanceVOs[i]);
					} else if ( estimatedPerformanceVOs[i].getIbflag().equals("U")){
						updateVoList.add(estimatedPerformanceVOs[i]);
					}
				}

			if (insertVoList.size() > 0) {
				dbDao.addEstimatedPerformance(insertVoList);
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyEstimatedPerformance(updateVoList);
			}

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * [ESM_ACM_0119] CSR Detail 팝업
	 * 
	 * @param csrDetailforCommissionHdrVO
	 * @return
	 * @throws EventException
	 */
    public List<CSRDetailforCommissionHdVO> searchCSRDetailforCommissionHdr(CSRDetailforCommissionHdVO csrDetailforCommissionHdVO) throws EventException {
		try
		{
			return dbDao.searchCSRDetailforCommissionHdr(csrDetailforCommissionHdVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
    }
    
	/**
	 * [ESM_ACM_0119] CSR Detail 팝업
	 * 
	 * @param csrDetailforCommissionVO
	 * @return
	 * @throws EventException
	 */
    public List<CSRDetailforCommissionVO> searchCSRDetailforCommissionDtrb(CSRDetailforCommissionVO csrDetailforCommissionVO) throws EventException {
		try
		{
			return dbDao.searchCSRDetailforCommissionDtrb(csrDetailforCommissionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
    }

    
}