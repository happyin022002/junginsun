/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CMSummaryBCImpl.java
*@FileTitle : Revenue Lane Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.06.29 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.integration.CMSummaryDBDAO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InPrsAmendmentCmSummaryDownExcelVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InPrsAmendmentCmSummaryVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InPrsAmendmentSummarySimulationSetVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InPrsProposalCmSummaryVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InPrsProposalSummarySimulationSetVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InRevenueLaneVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.RsltCoaWkPrdVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.RsltPriAuthorizationVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.RsltPriCMSummaryCustomerListVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.RsltPriMdmSlsRepVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.RsltPrsCheckRegionCodeVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.RsltPrsCmSummaryHistoryVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.RsltPrsProposalCmSummaryVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.RsltPrsProposalSummaryChartTargetListVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.RsltPrsProposalSummarySimulationListVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.backend.support.BackEndJobException;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriPrsBatVO;
import com.hanjin.syscommon.common.util.ScheduleUtil;

/**
 * NIS2010-ProfitabilitySimulation Business Logic Basic Command implementation<br>
 * - NIS2010-ProfitabilitySimulation에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Seung-Jun,Lee
 * @see ESM_PRI_6055EventResponse,CMSummaryBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class CMSummaryBCImpl extends BasicCommandSupport implements CMSummaryBC {

	// Database Access Object
	private transient CMSummaryDBDAO dbDao = null;

	/**
	 * CMSummaryBCImpl 객체 생성<br>
	 * CMSummaryDBDAO를 생성한다.<br>
	 */
	public CMSummaryBCImpl() {
		dbDao = new CMSummaryDBDAO();
	}
	/**
	 * REV_LANE 의 코드, destription list를 조회한다.<br>
	 * 
	 * @param inRevenueLaneVO   InRevenueLaneVO
	 * @return List<InRevenueLaneVO>
	 * @exception EventException
	 */
	public List<InRevenueLaneVO> searchRevenueLaneList(InRevenueLaneVO inRevenueLaneVO) throws EventException {
		try {
			return dbDao.searchRevenueLaneList(inRevenueLaneVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
	
	
	
	/**
	 * 
	 * ESM_PRI_6024 :  Retrieve <BR>
	 * CM/OP Summary & Simulation , Contract Proposal 리스트 를 조회 합니다.<br>
	 *  
	 * @param InPrsProposalCmSummaryVO    inPrsProposalCmSummaryVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public  String searchProposalCmSummaryList(InPrsProposalCmSummaryVO inPrsProposalCmSummaryVO, SignOnUserAccount account) throws EventException {
		try {
			SearchProposalCMSummaryListBackEndJob searchProposalCMSummaryListBackEndJob = new SearchProposalCMSummaryListBackEndJob();
			searchProposalCMSummaryListBackEndJob.setSearchParameterVOs(inPrsProposalCmSummaryVO); 
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			return backEndJobManager.execute(searchProposalCMSummaryListBackEndJob, account.getUsr_id(), "ESM_PRI_6024 - Search");
		 
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
		
	
	
	
	
	/**
     * ESM_PRI_6026 :  Retrieve <BR>
	 * CM/OP Summary & Simulation , Contract Approval 리스트 를 조회 합니다.<br>
	 *  
	 * @param InPrsAmendmentCmSummaryVO    inPrsAmendmentCmSummaryVO
	 * @param account SignOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public  String searchAmendmentCmSummaryList(InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO, SignOnUserAccount account) throws EventException {
		try {
			
			SearchAmendmentCMSummaryListBackEndJob searchAmendmentCMSummaryListBackEndJob = new SearchAmendmentCMSummaryListBackEndJob();
			searchAmendmentCMSummaryListBackEndJob.setSearchParameterVOs(inPrsAmendmentCmSummaryVO); 
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			return backEndJobManager.execute(searchAmendmentCMSummaryListBackEndJob, account.getUsr_id(), "ESM_PRI_6026 - Search");
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
	
	
	/**
     * ESM_PRI_6026 :  Down Excel  <BR>
	 * CM/OP Summary & Simulation , Contract Approval 엑셀 리스트 를 조회 합니다.<br>
	 *  
	 * @param InPrsAmendmentCmSummaryDownExcelVO    inPrsAmendmentCmSummaryDownExcelVO
	 * @param SignOnUserAccount account
	 * @return List<RsltPrsAmendmentCmSummaryDownExcelVO>
	 * @exception EventException
	 */
	public  String searchAmendmentCmSummaryExcelList(InPrsAmendmentCmSummaryDownExcelVO inPrsAmendmentCmSummaryDownExcelVO,SignOnUserAccount account) throws EventException {
		try {
			SearchAmendmentCmSummaryExcelListBackEndJob searchAmendmentCmSummaryExcelListBackEndJob = new SearchAmendmentCmSummaryExcelListBackEndJob();
			searchAmendmentCmSummaryExcelListBackEndJob.setSearchParameterVOs(inPrsAmendmentCmSummaryDownExcelVO); 
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			return backEndJobManager.execute(searchAmendmentCmSummaryExcelListBackEndJob, account.getUsr_id(), "ESM_PRI_6026 - Excel");
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}		
		
	
	/**
	 * ESM_PRI_6026 :  OnLoad <BR>
	 * 
	 * 화면에서 사용할 주차와 그 날짜를 조회 합니다..<br>
	 *  
	 * @param InPrsAmendmentCmSummaryVO    inPrsAmendmentCmSummaryVO
	 * @return List<RsltCoaWkPrdVO>
	 * @exception EventException
	 */
	public  List<RsltCoaWkPrdVO> searchCoaWkPrdList(InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO) throws EventException {
		try {
			return dbDao.searchCoaWkPrdList(inPrsAmendmentCmSummaryVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
			
	
	
	
	
	
	
	/**
	 * ESM_PRI_6029 : Retrieve
	 * CM/OP Summary & Simulation Multi Customer 를 조회 합니다.<br>
	 *  
	 * @param RsltPriCMSummaryCustomerListVO    rsltPriCMSummaryCustomerListVO
	 * @return List<RsltPriCMSummaryCustomerListVO>
	 * @exception EventException
	 */
	public  List<RsltPriCMSummaryCustomerListVO> searchCustomerList(RsltPriCMSummaryCustomerListVO rsltPriCMSummaryCustomerListVO) throws EventException {
		try {
			return dbDao.searchCustomerList(rsltPriCMSummaryCustomerListVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
	
	
	/**
	 * ESM_PRI_6029 : Select Grid1
	 * 
	 * CM/OP Summary & Simulation Multi Customer에서 하나의 customer 선택시 그 group에 포함된 데이터 를 조회 합니다.<br>
	 *  
	 * @param RsltPriCMSummaryCustomerListVO    rsltPriCMSummaryCustomerListVO
	 * @return List<RsltPriCMSummaryCustomerListVO>
	 * @exception EventException
	 */
	public  List<RsltPriCMSummaryCustomerListVO> searchCustomerSelectedList(RsltPriCMSummaryCustomerListVO rsltPriCMSummaryCustomerListVO) throws EventException {
		try {
			return dbDao.searchCustomerSelectedList(rsltPriCMSummaryCustomerListVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
	
	
	
	
	
	
	/**
     * ESM_PRI_6032 :  Retrieve <BR>
     * CM/OP Summary & Simulation Proposal의 CM 값을 Simulation해 조회 합니다.<br>
     * 
	 * @param InPrsProposalCmSummaryVO inPrsProposalCmSummaryVO
	 * @param InPrsProposalSummarySimulationSetVO inPrsProposalSummarySimulationSetVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public  String  searchProposalSummarySimulationList (InPrsProposalCmSummaryVO inPrsProposalCmSummaryVO , InPrsProposalSummarySimulationSetVO inPrsProposalSummarySimulationSetVO,SignOnUserAccount account) throws EventException {
		
		
		try {
			SearchProposalSummarySimulationListBackEndJob searchProposalSummarySimulationListBackEndJob = new SearchProposalSummarySimulationListBackEndJob();
			searchProposalSummarySimulationListBackEndJob.setSearchParameterVOs(inPrsProposalCmSummaryVO,inPrsProposalSummarySimulationSetVO, account); 
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			return backEndJobManager.execute(searchProposalSummarySimulationListBackEndJob, account.getUsr_id(), "ESM_PRI_6032 - Search");
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
		
		
		
	}	
	
 
	/**
	 * ESM_PRI_6031 :  sheet 내용변경 <BR>
	 * 
	 * sheet의 route값이 변경 됐을때 정확한 값인지 체크 한다.<br>
	 *  
	 * @param InPrsAmendmentCmSummaryVO    inPrsAmendmentCmSummaryVO
	 * @return List<RsltPrsCheckRegionCodeVO>
	 * @exception EventException
	 */
	public  List<RsltPrsCheckRegionCodeVO> searchSummaryResionCode(InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO) throws EventException {
		try {
			return dbDao.searchSummaryResionCode(inPrsAmendmentCmSummaryVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
			
	
	
	
	/**
     * ESM_PRI_6031 :  Retrieve <BR>
     *  CM/OP Summary & Simulation 를 조회를 위해 BackEndJob을 실행 합니다.<br>
     * 
	 * @param inPrsAmendmentCmSummaryVO InPrsAmendmentCmSummaryVO 
	 * @param inPrsAmendmentSummarySimulationSetVO InPrsAmendmentSummarySimulationSetVO 
	 * @param account SignOnUserAccount
	 * 
	 * @return String
	 * @exception EventException
	 */
	public  String  searchAmendmentSummarySimulationStart (InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO , InPrsAmendmentSummarySimulationSetVO inPrsAmendmentSummarySimulationSetVO,SignOnUserAccount account) throws EventException {
		try {
			SearchAmendmentSummarySimulationListBackEndJob searchAmendmentSummarySimulationListBackEndJob = new SearchAmendmentSummarySimulationListBackEndJob();
			searchAmendmentSummarySimulationListBackEndJob.setSearchParameterVOs(inPrsAmendmentCmSummaryVO, inPrsAmendmentSummarySimulationSetVO, account); 
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			return backEndJobManager.execute(searchAmendmentSummarySimulationListBackEndJob, account.getUsr_id(), "ESM_PRI_6031 - Search");
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
	
	
	
	/**
	 * BackEndJob의 상태값을 조회한다.<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String comBackEndJobVOs(String key) throws EventException {
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
     * ESM_PRI_6025 :  OnLoad <BR>
     *  CM/OP Summary & Simulation의 Chart 정보 를 조회 합니다.<br>
     * 
	 * @param InPrsProposalCmSummaryVO inPrsProposalCmSummaryVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public  String  searchProposalChartList (InPrsProposalCmSummaryVO inPrsProposalCmSummaryVO,SignOnUserAccount account) throws EventException {
		try {
			
			SearchProposalChartListBackEndJob searchProposalChartListBackEndJob = new SearchProposalChartListBackEndJob();
			searchProposalChartListBackEndJob.setSearchParameterVOs(inPrsProposalCmSummaryVO); 
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			return backEndJobManager.execute(searchProposalChartListBackEndJob, account.getUsr_id(), "ESM_PRI_6025 - Search");
		 
			 
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
	
	
	/**
     * ESM_PRI_6027 :  OnLoad,Retrieve <BR>
     *  CM/OP Summary & Simulation의 Chart 정보 를 조회 합니다.<br>
     * 
	 * @param InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public  String  searchAmendmentChartList (InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO,SignOnUserAccount account) throws EventException {
		try {
			
			SearchAmendmentChartListBackEndJob searchAmendmentChartListBackEndJob = new SearchAmendmentChartListBackEndJob();
			searchAmendmentChartListBackEndJob.setSearchParameterVOs(inPrsAmendmentCmSummaryVO); 
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			return backEndJobManager.execute(searchAmendmentChartListBackEndJob, account.getUsr_id(), "ESM_PRI_6027 - Search");
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
	
	
	/**
     * ESM_PRI_6052 :  OnLoad <BR>
     * CM/OP Summary & Simulation의 Revenue값의 Detail 정보 를 조회 합니다.<br>
     * 
	 * @param InPrsProposalCmSummaryVO inPrsProposalCmSummaryVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public  String  searchProposalRevenueDetailList (InPrsProposalCmSummaryVO inPrsProposalCmSummaryVO,SignOnUserAccount account) throws EventException {
		try {
			
			SearchProposalRevenueDetailListBackEndJob searchProposalRevenueDetailListBackEndJob = new SearchProposalRevenueDetailListBackEndJob();
			searchProposalRevenueDetailListBackEndJob.setSearchParameterVOs(inPrsProposalCmSummaryVO); 
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			return backEndJobManager.execute(searchProposalRevenueDetailListBackEndJob, account.getUsr_id(), "ESM_PRI_6052 - Search");
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
	
	
	/**
     * ESM_PRI_6053 :  OnLoad <BR>
     * CM/OP Summary & Simulation의 Revenue값의 Detail 정보 를 조회 합니다.<br>
     * 
	 * @param InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public  String  searchAmendmentRevenueDetailList (InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO,SignOnUserAccount account) throws EventException {
		try {
			SearchAmendmentRevenueDetailListBackEndJob searchAmendmentRevenueDetailListBackEndJob = new SearchAmendmentRevenueDetailListBackEndJob();
			searchAmendmentRevenueDetailListBackEndJob.setSearchParameterVOs(inPrsAmendmentCmSummaryVO); 
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			return backEndJobManager.execute(searchAmendmentRevenueDetailListBackEndJob, account.getUsr_id(), "ESM_PRI_6053 - Search");
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
	
	
	/**
     * ESM_PRI_6024,ESM_PRI_6026 :  OnLoad <BR>
     * 로그인 사용자의 SELECT 권한 정보와 REQUEST OFFICE를 조회합니다.<br>
     * 
	 * @param SignOnUserAccount account
	 * @return RsltCdListVO
	 * @exception EventException
	 */
	public  RsltCdListVO  searchAuthorizationOffice (SignOnUserAccount account) throws EventException {
		try {
			RsltCdListVO returnVO = new RsltCdListVO();
			returnVO.setCd("X");//일반사용자.
			List<RsltPriAuthorizationVO> authVO = dbDao.searchPriAuthorization(account.getUsr_id());
			if( authVO == null || authVO.size() <= 0 ){
				List<RsltPriMdmSlsRepVO> mdmSlsRepVO = dbDao.searchMdmSlsRep(account.getSrep_cd());
				if( mdmSlsRepVO.size() > 0 && mdmSlsRepVO.get(0).getOfcCd() != null && mdmSlsRepVO.get(0).getOfcCd().length() != 0){
					returnVO.setCd("S");//Sales Rep 사용자
					returnVO.setNm(mdmSlsRepVO.get(0).getOfcCd());// request office
				}
			}else{
				returnVO.setCd("A");//승인권자.
			}
			return returnVO;
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
	
	
	
	/**
	 * ESM_PRI_6054 :  Retrieve <BR>
	 * CM/OP Summary & Simulation 의 Quotation, Proposal, Amendment의 CM값 History 를 조회 합니다..<br>
	 *  
	 * @param InPrsProposalCmSummaryVO    inPrsProposalCmSummaryVO
	 * @return List<RsltPrsCmSummaryHistoryVO>
	 * @exception EventException
	 */
	public  List<RsltPrsCmSummaryHistoryVO> searchCmSummaryHistoryList(InPrsProposalCmSummaryVO inPrsProposalCmSummaryVO) throws EventException {
		try {
			return dbDao.searchCmSummaryHistoryList(inPrsProposalCmSummaryVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}		
	
	
	 
	
	
}