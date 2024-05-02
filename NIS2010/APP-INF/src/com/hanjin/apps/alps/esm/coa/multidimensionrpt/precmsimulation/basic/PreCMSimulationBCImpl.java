/*=========================================================
*Copyright(c) 2009 CyberLogitec

*@FileName : PreCMSimulationBCImpl.java
*@FileTitle : Pre CM/OP Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.09.15 송호진
* 1.0 Creation
* History
* 2008-05-16 Ari
* 1.0 최초 생성 CSR No.N200804140004, N200804146015, N200804146018
* 2009.06.10 박상희 CSR No. N200905110270 COA_Pre CM/OP Simulation : Temp T/S Route 입력기능[153]
* 2010.09.28 박은주 OPMS 결함 복구작업 [메소드명 변경]
*                  createCoaCostPkgPreCMAbc => createCoaCostPkgPreCMAbcStp
* 2012.02.20 김종준 [CHM-201216268-01] [COA] Pre CM/OP 화면 Backandjob로 조회로  로직 변경     
* 2013.12.04 김수정 [CHM-201327857] [COA] Pre CM 조회시 에러 메세지 관련 - Backend Job으로 변경             
=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.precmsimulation.basic;

import java.sql.SQLException;
import java.util.List;

import com.hanjin.apps.alps.esm.coa.common.vo.CommonCoaRsVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.precmsimulation.integration.PreCMSimulationDBDAO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.precmsimulation.vo.PreCMRemarkVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.precmsimulation.vo.SearchCondition0153VO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.backend.support.BackEndJobException;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-MultiDimensionRPT Business Logic Command Interface<br>
 * - ALPS-MultiDimensionRPT에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Song Ho Jin
 * @see PreCMSimulationBC 참조
 * @since J2EE 1.6
 */
public class PreCMSimulationBCImpl extends BasicCommandSupport implements PreCMSimulationBC {

	// Database Access Object
	private transient PreCMSimulationDBDAO dbDao = null;

	/**
	 * PreCMSimulationBCImpl 객체 생성<br>
	 * PreCMSimulationDBDAO를 생성한다.<br>
	 */
	public PreCMSimulationBCImpl() {
		dbDao = new PreCMSimulationDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_0153 sheet2 COST 조회 이벤트 처리<br>
	 * 
	 * @param SearchCondition0153VO searchCondition0153VO
	 * @return CommonCoaRsVO
	 * @exception EventException
	 */
	public CommonCoaRsVO searchPreCMSimulationCostList(SearchCondition0153VO searchCondition0153VO) throws EventException {
		try {
			return dbDao.searchPreCMSimulationCostList(searchCondition0153VO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * 기본정보(PARA DATA) 생성
	 * 
	 * @param  searchCondition0153VO SearchCondition0153VO
	 * @return String
	 * @throws EventException
	 */
	public String createCostAssignPreCM(SearchCondition0153VO searchCondition0153VO) throws EventException{
		try {
			return dbDao.createCostAssignPreCM(searchCondition0153VO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 기준년월 조회
	 * 
	 * @return String
	 * @throws EventException
	 */
	public String searchBzcCostYrmon() throws EventException{
		try {
			return dbDao.searchBzcCostYrmon();
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * TRS 비용 생성
	 * 
	 * @param  searchCondition0153VO SearchCondition0153VO
	 * @return String
	 * @throws EventException
	 */
	public String createTrsAgmtApplyToCoa(SearchCondition0153VO searchCondition0153VO) throws EventException{
		try {
			return dbDao.createTrsAgmtApplyToCoa(searchCondition0153VO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}


	/**
	 * TES 비용 생성
	 * 
	 * @param  searchCondition0153VO SearchCondition0153VO
	 * @return String
	 * @throws EventException
	 */
	public String createTesCoaRate(SearchCondition0153VO searchCondition0153VO) throws EventException{
		try {
			return dbDao.createTesCoaRate(searchCondition0153VO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}


	/**
	 * COA 평균단가를 이용한 비용 생성
	 * 
	 * @param  searchCondition0153VO SearchCondition0153VO
	 * @return String
	 * @throws EventException
	 */
	public String createCoaCostPkgMainPreCMAvg(SearchCondition0153VO searchCondition0153VO) throws EventException{
		try {
			return dbDao.createCoaCostPkgMainPreCMAvg(searchCondition0153VO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}


	/**
	 * COA ABC 비용 생성
	 * 
	 * @param  searchCondition0153VO SearchCondition0153VO
	 * @return String
	 * @throws EventException
	 */
	public String createCoaCostPkgPreCMAbcStp(SearchCondition0153VO searchCondition0153VO) throws EventException{
		try {
			return dbDao.createCoaCostPkgPreCMAbcStp(searchCondition0153VO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Total 비용 계산 및 USD환산
	 * 
	 * @param  searchCondition0153VO SearchCondition0153VO
	 * @return String
	 * @throws EventException
	 */
	public String createCoaCostPkgMainComTtl(SearchCondition0153VO searchCondition0153VO) throws EventException{
		try {
			return dbDao.createCoaCostPkgMainComTtl(searchCondition0153VO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * 비용 RMK 상세조회
	 * 
	 * @param SearchCondition0153VO searchCondition0153VO
	 * @return List<PreCMRemarkVO>
	 * @exception EventException
	 */
	public List<PreCMRemarkVO> searchPreCMRemarkList(SearchCondition0153VO searchCondition0153VO) throws EventException {
		try {
			return dbDao.searchPreCMRemarkList(searchCondition0153VO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
     * ESM_COA_0153 비용 생성<br>
     * 
     * @param SearchCondition0153VO searchCondition0153VO
     * @param SignOnUserAccount account
     * @return String
     * @exception EventException
     */
	public String createPreCMSimulation(SearchCondition0153VO searchCondition0153VO, SignOnUserAccount account) throws EventException{
		PreCMSimulationCreate0153BackEndJob backEndJob = new PreCMSimulationCreate0153BackEndJob();
		backEndJob.setCoaCreate0153Vo(searchCondition0153VO,account);
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		try {
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), "Pre CM/OP Simulation - Create Pre CM/OP Simulation Message");		
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
	public String searchBackEndJobStatus(String key) throws EventException {
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
	 * PRD Route BackEndJob의 상태값을 조회한다.<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String searchPrdBackEndJobStatus(String key) throws EventException {
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
	 * PRD Route 정보 조회 에러 메시지를 조회한다.
	 * 
	 * @param String key
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchPrdBackEndJob(String key) throws EventException {
		DBRowSet rowSet;
		try {
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			return rowSet;
		} catch (BackEndJobException e) {
			throw new EventException(e.getMessage());
		} catch(Exception e){
			throw new EventException(e.getMessage());
		}
	}
}