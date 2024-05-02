/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : USDomesticBCImpl.java
*@FileTitle : US domestic cost/credit 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.16
*@LastModifier : 김보배
*@LastVersion : 1.0 
* 2012.10.16 김보배
* 1.0 Creation
=========================================================
* History
* 2012.11.19 송호진 [CHM-201221090-01] [COA] US DOMESTIC 반영 - 컬럼 추가에 의한 Creation Logic 및 변경 저장 로직 수정 
* 2012.11.20 송호진 [CHM-201221090-01] [COA] US DOMESTIC 반영 - CNTR_SZ_CD -> CNTR_TPSZ_CD 컬럼명 변경에 따른 수정
* 2013.05.10 최성민 [CHM-201324573-01] [COA] Domestic Saving Credit 화면 버튼 추가 
=========================================================*/

package com.clt.apps.opus.esm.coa.stdunitcost.averagerpb.basic;

import java.io.IOException;
import java.util.List;

import com.clt.apps.opus.esm.coa.stdunitcost.averagerpb.integration.AverageRPBDBDAO;
import com.clt.apps.opus.esm.coa.stdunitcost.averagerpb.vo.AverageRPBVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CoaUtCostCreStsVO;
import com.clt.syscommon.common.util.ScheduleUtil;



/**
 * ALPS-STDUnitCost Business Logic Basic Command implementation<br>
 * - ALPS-STDUnitCost에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author BOBAE KIM
 * @see USDomesticBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class AverageRPBBCImpl extends BasicCommandSupport implements AverageRPBBC {

	// Database Access Object
	private transient AverageRPBDBDAO dbDao = null;

	/**
	 * MTCostBCImpl 객체 생성<br>
	 * MTCostDBDAO를 생성한다.<br>
	 */
	public AverageRPBBCImpl() {
		dbDao = new AverageRPBDBDAO();
	}

	/**
	 * searchRouteRPBList 조회
	 * 
	 * @param AverageRPBVO averageRPBVO
	 * @return List<AverageRPBVO>
	 * @throws EventException
	 */
	public List<AverageRPBVO> searchRouteRPBList(AverageRPBVO averageRPBVO) throws EventException {
		try {
			return dbDao.searchRouteRPBList(averageRPBVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * searchCustomerRPBList 조회
	 * 
	 * @param AverageRPBVO averageRPBVO
	 * @return List<AverageRPBVO>
	 * @throws EventException
	 */
	public List<AverageRPBVO> searchCustomerRPBList(AverageRPBVO averageRPBVO) throws EventException {
		try {
			return dbDao.searchCustomerRPBList(averageRPBVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * searchSCCRPBList 조회
	 * 
	 * @param AverageRPBVO averageRPBVO
	 * @return List<AverageRPBVO>
	 * @throws EventException
	 */
	public List<AverageRPBVO> searchSCCRPBList(AverageRPBVO averageRPBVO) throws EventException {
		try {
			return dbDao.searchSCCRPBList(averageRPBVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * searchLaneRPBList 조회
	 * 
	 * @param AverageRPBVO averageRPBVO
	 * @return List<AverageRPBVO>
	 * @throws EventException
	 */
	public List<AverageRPBVO> searchLaneRPBList(AverageRPBVO averageRPBVO) throws EventException {
		try {
			return dbDao.searchLaneRPBList(averageRPBVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * searchTradeRPBList 조회
	 * 
	 * @param AverageRPBVO averageRPBVO
	 * @return List<AverageRPBVO>
	 * @throws EventException
	 */
	public List<AverageRPBVO> searchTradeRPBList(AverageRPBVO averageRPBVO) throws EventException {
		try {
			return dbDao.searchTradeRPBList(averageRPBVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_COA_0183 : CREATE 된 기간 조회
	 *
	 * @param String fRpbYrmon
	 * @return String retVal
	 * @throws EventException
	 */
	public String searchAverageRPBCreationStatus(String fRpbYrmon) throws EventException {
		
		String retVal = "";
		
		try {
			retVal = dbDao.searchAverageRPBCreationStatus(fRpbYrmon);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);    			
			throw new EventException(ex.getMessage(),ex);
		}
		return retVal;
	}
	
	/**
	 * Target YRMON 에 대해 AverageRPB 배치가 실행 되었는지 확인한다.
	 * 
	 * @param String fTargetYrMon
	 * @return String
	 * @throws EventException
	 */
	public String searchRPBStatus(String fTargetYrMon) throws EventException {
		String tagetYrMonStatus ="N";
		try {
			List<CoaUtCostCreStsVO> list = dbDao.searchRPBStatus(fTargetYrMon);			
			// 돌고 있는 batch 가 있다
			if (list.size() > 0) { 
				tagetYrMonStatus = "Y";
			}		
		} catch (DAOException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"Average RPB BATCH STATUS CHECK ABOUT TARGET YRMON"}).getMessage(),e);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return tagetYrMonStatus;
	}
	
	/**
	 * Average RPB BATCH 가 실행중인지를 check 한다.
	 * 
	 * @param String fTargetYrMon
	 * @return String
	 * @throws EventException
	 * @author 20150817.ADD
	 */
	public String checkAverageRPBCreateBatchStatus(String fTargetYrMon) throws EventException {
		String batchRunning ="C";
		try {
			List<CoaUtCostCreStsVO> list = dbDao.checkAverageRPBCreateBatchStatus(fTargetYrMon);			
			// 돌고 있는 batch 가 있다
			if (list.size() > 0) { 
//				batchRunning = "P";
				batchRunning = list.get(0).getCostCreStsCd();		//20150817.MOD
			}		
		} catch (DAOException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"Average RPB BATCH STATUS CHECK"}).getMessage(),e);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return batchRunning;
	}
	
	/**
	 * Average RPB BATCH status 를 생성한다. <br>
	 * 
	 * @param AverageRPBVO averageRPBVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyAverageRPBStatus(AverageRPBVO averageRPBVO, SignOnUserAccount account) throws EventException{
		try{
			// shipper 를 user id 담기 위해 사용
			averageRPBVO.setUsrId(account.getUsr_id());
			dbDao.modifyAverageRPBStatus(averageRPBVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
    
	/**
	 * Week 단위로 Average RPB BATCH 를 수행한다. <br>
	 * 
	 * @param AverageRPBVO averageRPBVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createAverageRPB(AverageRPBVO averageRPBVO, SignOnUserAccount account) throws EventException {	
		ScheduleUtil su = new ScheduleUtil();
        String params = "";
		
		try {
			averageRPBVO.setUsrId(account.getUsr_id());					//20150605.ADD
			params = dbDao.searchAverageRPBParam(averageRPBVO);
			log.debug("params=========== : "+params);
			su.directExecuteJob("ESM_COA_B009",params);

		} catch (IOException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"Average RPB Creation"}).getMessage(),e);
		} catch (InterruptedException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"Average RPB Creation"}).getMessage(),e);
		} catch (DAOException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"Average RPB Creation"}).getMessage(),e);
		} catch (Exception e){
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"Average RPB Creation"}).getMessage(),e);
		}
		return "R";//실행 성공
	}
}