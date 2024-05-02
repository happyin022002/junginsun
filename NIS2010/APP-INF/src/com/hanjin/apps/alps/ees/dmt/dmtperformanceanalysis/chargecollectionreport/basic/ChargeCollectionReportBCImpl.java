/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeCollectionReportBCImpl.java
*@FileTitle : Current Collection Status by Office
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.10
*@LastModifier : 정운
*@LastVersion : 1.0
* 2013.12.10 정운
* 1.0 Creation
* 2011.05.12. 김태균 [] 소스원복요청으로 인하여 원복 - [CHM-201110406-01][DMT] Monthly invoiced & collection by office 의 생성결과물 Local 통화 통일 요청
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.integration.ChargeCollectionReportDBDAO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.CollectionDetailReportByOfficeVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.CollectionReportParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.CollectionSummaryReportByOfficeVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.MonthlyCollectionByOfficeVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.TmnlContainerExceptionVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.TmnlVvdLfdVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.UnissuedInvoiceByAgingParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.UnissuedInvoiceDetailByAgingVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.YearlyCollectionByRHQVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-DMTPerformanceAnalysis Business Logic Command Interface<br>
 * - ALPS-DMTPerformanceAnalysis에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Hwang HyoKeun
 * @see ChargeCollectionReportDBDAO Class 참조
 * @since J2EE 1.6
 */
public class ChargeCollectionReportBCImpl extends BasicCommandSupport implements ChargeCollectionReportBC {

	// Database Access Object
	private transient ChargeCollectionReportDBDAO dbDao = null;

	/**
	 * ChargeCollectionReportBCImpl 객체 생성<br>
	 * ChargeCollectionReportDBDAO를 생성한다.<br>
	 */
	public ChargeCollectionReportBCImpl() {
		dbDao = new ChargeCollectionReportDBDAO();
	}
	
	/**
	 * Collection Status Report by Office의 상세 내역을 조회한다.
	 * 
	 * @param CollectionReportParmVO collectionReportParmVO
	 * @return List<CollectionSummaryReportByOfficeVO>
	 * @exception EventException
	 */
	public List<CollectionSummaryReportByOfficeVO> searchCollectionSummaryReportByOffice(CollectionReportParmVO collectionReportParmVO) throws EventException {
		try {
			return dbDao.searchCollectionSummaryReportByOffice(collectionReportParmVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	
	/**
	 * 해당기간에 발생한 Charge를 기준으로 하여 조회시점까지 관련 Charge Detail 정보를 조회한다.<br>
	 * 
	 * @param CollectionReportParmVO collectionReportParmVO
	 * @return List<CollectionDetailReportByOfficeVO>
	 * @exception EventException
	 */
	public List<CollectionDetailReportByOfficeVO> searchCollectionDetailReportByOffice(CollectionReportParmVO collectionReportParmVO) throws EventException {
		try {
			return dbDao.searchCollectionDetailReportByOffice(collectionReportParmVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	
	/**
	 * 월별 Billable/Invoiced/Collection 된 금액 정보를 조회한다.<br>
	 * 
	 * @param CollectionReportParmVO collectionReportParmVO
	 * @return List<MonthlyCollectionByOfficeVO>
	 * @exception EventException
	 */
	public List<MonthlyCollectionByOfficeVO> searchMonthlyCollectionByOffice(CollectionReportParmVO collectionReportParmVO) throws EventException {
		try {
			return dbDao.searchMonthlyCollectionByOffice(collectionReportParmVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * 년도별, RHQ OFFICE CODE 별, AGING 정보를 조회한다.<br>
	 * 
	 * @param YearlyCollectionByRHQVO yearlyCollectionByRHQVO
	 * @return List<YearlyCollectionByRHQVO>
	 * @exception EventException
	 */
	public List<YearlyCollectionByRHQVO> searchYearlyCollectionByRHQOffice(YearlyCollectionByRHQVO yearlyCollectionByRHQVO) throws EventException {
		try {
			return dbDao.searchYearlyCollectionByRHQOffice(yearlyCollectionByRHQVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * 해당 Back End Job의 상태를 리턴한다.
	 *
	 * @param String key
	 * @return String[]
	 * @exception EventException
	 */
	public String[] checkBackEndJob(String key) throws EventException {
		DBRowSet rowSet;
		try {
			String[] result = new String[2];
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			
			if(rowSet.next()) {
				//Thread.sleep(1000);
				result[0] = rowSet.getString("jb_sts_flg");
				result[1] = rowSet.getString("jb_usr_err_msg");
			}
			return result;
		} catch(Exception ex){
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT0006", new String[]{"BackEndJob Status"}).getUserMessage(),ex);
		}
	}
	
	
	/**
	 * 해당 Back End Job을 실행시킨다.
	 * 
	 * @param YearlyCollectionByRHQVO yearlyCollectionByRHQVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String doBackEndJob(YearlyCollectionByRHQVO yearlyCollectionByRHQVO, SignOnUserAccount account) throws EventException {
		try {
				ChargeCollectionReportBackEndJob	backEndJob	= new ChargeCollectionReportBackEndJob();
				BackEndJobManager			backEndJobManager 	= new BackEndJobManager();
				
				String backendjobId = yearlyCollectionByRHQVO.getBackendjobId();
				
				//BackEndJob 처리를 위해서 필요한 정보를 매개변수로 설정해준다.
				backEndJob.setJobCommand(backendjobId);
				backEndJob.setYearlyCollectionByRHQVO(yearlyCollectionByRHQVO);
				backEndJob.setSignOnUserAccount(account);
				
				String jobMessage = "DMT " + backendjobId + " Back End";
				
				//BackEndJob 모듈을 호출한다.
				return backEndJobManager.execute(backEndJob, account.getUsr_id(), jobMessage);
			} catch (Exception ex) {
				log.error("[Exception]"+ex.getMessage());
				throw new EventException(new ErrorHandler("DMT00008", new String[]{"execute charge calculation backend job"}).getMessage());
			}
	}
	
	/**
	 * [Terminal LFD Report]을 [SEARCH]합니다.<br>
	 * 
	 * @param TmnlVvdLfdVO tmnlVvdLfdVO
	 * @return List<TmnlVvdLfdVO>
	 * @exception EventException
	 */
	public List<TmnlVvdLfdVO> searchTmnlVvdLfd(TmnlVvdLfdVO tmnlVvdLfdVO) throws EventException {
		try {
			return dbDao.searchTmnlVvdLfd(tmnlVvdLfdVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	

	/**
	 * [Terminal LFD Report]을 [SEARCH]합니다.<br>
	 * 
	 * @param TmnlVvdLfdVO tmnlVvdLfdVO
	 * @return List<TmnlContainerExceptionVO>
	 * @exception EventException
	 */
	public List<TmnlContainerExceptionVO> searchTmnlContainerException(TmnlVvdLfdVO tmnlVvdLfdVO) throws EventException {
		try {
			return dbDao.searchTmnlContainerException(tmnlVvdLfdVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [UnissuedInvoiceDetailByAging]을 [SEARCH]합니다.<br>
	 * 
	 * @param UnissuedInvoiceByAgingParmVO unissuedInvoiceByAgingParmVO
	 * @return List<UnissuedInvoiceDetailByAgingVO>
	 * @exception EventException
	 */
	public List<UnissuedInvoiceDetailByAgingVO> searchUnissuedInvoiceDetailByAging(UnissuedInvoiceByAgingParmVO unissuedInvoiceByAgingParmVO)  throws EventException {
		try {
			return dbDao.searchUnissuedInvoiceDetailByAging(unissuedInvoiceByAgingParmVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
}