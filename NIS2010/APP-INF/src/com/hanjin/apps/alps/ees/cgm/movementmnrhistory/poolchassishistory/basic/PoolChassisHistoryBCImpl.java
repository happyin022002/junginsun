/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PoolChassisHistoryBCImpl.java
*@FileTitle : Pool Chassis Comparison Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.08.04 최민회
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.basic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.integration.PoolChassisHistoryDBDAO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolCoChssUseHisMGTVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolExpenseTrendMGTVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolMaintRprHisMGTVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolMnrHistoryINVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolMnrHistoryMGTVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolMvmtCompareSmryMGTVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolMvmtGroupVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolMvmtHistoryMGTVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolMvmtINVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolUseddysINVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolUseddysMGTVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.util.ScheduleUtil;

/**
 * ALPS-MovementMnrHistory Business Logic Basic Command implementation<br>
 * - ALPS-MovementMnrHistory에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author CHOI MIN HOI
 * @see EES_CGM_1141EventResponse,PoolChassisHistoryBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class PoolChassisHistoryBCImpl extends BasicCommandSupport implements PoolChassisHistoryBC {

	// Database Access Object
	private transient PoolChassisHistoryDBDAO dbDao = null;

	/**
	 * PoolChassisHistoryBCImpl 객체 생성<br>
	 * PoolChassisHistoryDBDAO를 생성한다.<br>
	 */
	public PoolChassisHistoryBCImpl() {
		dbDao = new PoolChassisHistoryDBDAO();
	}
	/**
	 * Pool movement & SML Movement 비교, match/unmatch summary  정보 Retrieve. [EES_CGM_1142]<br>
	 * 
	 * @param poolMvmtINVO PoolMvmtINVO 
	 * @return List<PoolMvmtCompareSmryMGTVO>
	 * @exception EventException
	 */
	public List<PoolMvmtCompareSmryMGTVO> searchPoolMvmtCompareDtlBasic(PoolMvmtINVO poolMvmtINVO) throws EventException {
		try {
			return dbDao.searchPoolMvmtCompareDtlData(poolMvmtINVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
		
	}
	
	/**
	 * Pool movement & SML Movement 비교, match/unmatch summary 조회 Retrieve. [EES_CGM_1141]<br>
	 * 
	 * @param poolMvmtINVO PoolMvmtINVO 
	 * @return PoolMvmtGroupVO
	 * @exception EventException
	 */
	public PoolMvmtGroupVO  searchPoolMvmtComparisonBasic(PoolMvmtINVO poolMvmtINVO) throws EventException {
		PoolMvmtGroupVO  poolmvmtgroupvo = new PoolMvmtGroupVO();
		try {
			List<PoolMvmtCompareSmryMGTVO> agreementList = dbDao.searchPoolMvmtCompareSmryData(poolMvmtINVO);
			
			poolmvmtgroupvo.setPoolmvmtcomparesmrymgtvo(agreementList);
			
			List<PoolMvmtCompareSmryMGTVO> agreementList2 = dbDao.searchPoolMvmtCompareMatchingSmryData(poolMvmtINVO);
			
			poolmvmtgroupvo.setPoolmvmtcomparesmrymgtvo2(agreementList2);
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
		return poolmvmtgroupvo;
	}
	
	/**
	 *  월별, Pool별 Pool Invoice 비용, 비용 Estimate 를 조회한다 Retrieve. [EES_CGM_1143]<br>
	 * 
	 * @param poolMvmtINVO PoolMvmtINVO 
	 * @return List<PoolExpenseTrendMGTVO>
	 * @exception EventException
	 */
	public List<PoolExpenseTrendMGTVO> searchPoolMvmtExpenseListBasic(PoolMvmtINVO poolMvmtINVO) throws EventException{
		try {
			String tmp ="";
			if(!poolMvmtINVO.getChssPoolCd().equals("")){
				tmp = poolMvmtINVO.getChssPoolCd();
				tmp = "'" + tmp.replaceAll(",", "','") + "'";
				poolMvmtINVO.setChssPoolCd(tmp);
			}
			log.debug("poolMvmtINVO.getChssPoolCd()================"+poolMvmtINVO.getChssPoolCd());
			return dbDao.searchPoolMvmtExpenseListData(poolMvmtINVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
		
	}
	
	/**
	 *  Pool Chassis Mnr 데이터를 조회한다 Retrieve. [EES_CGM_1144]<br>
	 * 
	 * @param poolMnrHistoryINVO PoolMnrHistoryINVO 
	 * @return PoolMvmtGroupVO
	 * @exception EventException
	 */
	public PoolMvmtGroupVO  searchPoolMnrHistoryBasic(PoolMnrHistoryINVO poolMnrHistoryINVO) throws EventException {
		PoolMvmtGroupVO  poolmvmtgroupvo = new PoolMvmtGroupVO();
		try {
			
			// 상단 Summary
			List<PoolMnrHistoryMGTVO> agreementList = dbDao.searchPoolMnrHistorySummaryData (poolMnrHistoryINVO);
			
			poolmvmtgroupvo.setPoolmnrhistorymgtvo(agreementList);
			
			// 하단 그리드의 디테일
			List<PoolMnrHistoryMGTVO> agreementList2 = dbDao.searchPoolMnrHistoryData(poolMnrHistoryINVO);
			
			poolmvmtgroupvo.setPoolmnrhistorymgtvo2(agreementList2);
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
		return poolmvmtgroupvo;
	}
	
	/**
	 * Pool Chassis Movement 데이터를 DB 에 저장한다.EDI 로부터 InterfaceBC 를 통해 호출된다.
	 * 
	 * @param poolMvmtHistoryMGTVO PoolMvmtHistoryMGTVO
	 * @throws EventException
	 */
	public void managePoolMovementBasic(PoolMvmtHistoryMGTVO poolMvmtHistoryMGTVO) throws EventException{
		try {
			PoolMvmtHistoryMGTVO stmp = new PoolMvmtHistoryMGTVO();
			
			stmp = dbDao.searchPoolMovementData(poolMvmtHistoryMGTVO);
		    if(stmp == null || stmp.getChssNo()==null || stmp.getChssNo().equals("")){
		    	dbDao.addPoolMovementData(poolMvmtHistoryMGTVO);
		    } else {
		    	dbDao.modifyPoolMovementData(poolMvmtHistoryMGTVO);
		    }
		
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * CGM POOL MNR REPAIR HISTORY 엔티티로 세부 건들을 저장하였다. DB 에 저장한다.EDI 로부터 InterfaceBC 를 통해 호출된다.
	 * 
	 * @param poolMaintRprHisMGTVO PoolMaintRprHisMGTVO
	 * @throws EventException
	 */
	public void managePoolMnrInvoiceImportBasic(PoolMaintRprHisMGTVO  poolMaintRprHisMGTVO ) throws EventException{
		try {
//			PoolMaintRprHisMGTVO stmp = new PoolMaintRprHisMGTVO();
			log.debug("managePoolMnrInvoiceImportBasic===============");
//			stmp = dbDao.searchPoolMovementImportData(poolMaintRprHisMGTVO);
//		    if(stmp == null || stmp.getChssNo()==null || stmp.getChssNo().equals("")){
			if(poolMaintRprHisMGTVO.getCreUsrId().equals("FLEXIVAN")){
				dbDao.addPoolMnrInvoiceImportData(poolMaintRprHisMGTVO);
			} else {
				dbDao.addPoolMnrInvoiceImportSeacasData(poolMaintRprHisMGTVO);
			}
				
		    	
//		    } else {
//		    	dbDao.modifyPoolMnrInvoiceImportData(poolMaintRprHisMGTVO);
//		    }
		
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 *  Pool Chassis USED DAYS File Import 상태 조회 Retrieve. [EES_CGM_1145]<br>
	 * 
	 * @param poolUseddysINVO PoolUseddysINVO 
	 * @return List<PoolUseddysMGTVO>
	 * @exception EventException
	 */
	public List<PoolUseddysMGTVO> searchPoolChsUseddaysFileStatusBasic(PoolUseddysINVO poolUseddysINVO) throws EventException{
		try {
			String costYrmon = poolUseddysINVO.getCostYrmon();
			poolUseddysINVO.setCostYrmon(costYrmon.replaceAll("-", ""));
 			return dbDao.searchPoolChsUseddaysFileStatusData(poolUseddysINVO);
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Pool Chassis Used days 정보를 db 에 저장한다 Save. [EES_CGM_1145]<br>
	 * @param poolUseddysINVO PoolUseddysINVO
	 * @param poolUseddysMGTVOs PoolUseddysMGTVO[]
	 * @param account SignOnUserAccount
	 * @throws EventException
	 */
	public void addPoolChsFileImportBasic(PoolUseddysINVO poolUseddysINVO,PoolUseddysMGTVO[] poolUseddysMGTVOs, SignOnUserAccount account) throws EventException{
		try {
			List<PoolUseddysMGTVO> insertVoList = new ArrayList<PoolUseddysMGTVO>();
			List<PoolUseddysMGTVO> deleteVoList = new ArrayList<PoolUseddysMGTVO>();
			log.debug("poolUseddysMGTVOs ===length======= " + poolUseddysMGTVOs.length);
			
			for ( int i=0; i<poolUseddysMGTVOs.length; i++ ) {

				log.debug("poolUseddysMGTVOs ===getIbflag======= " + poolUseddysMGTVOs[i].getIbflag());
				if ( poolUseddysMGTVOs[i].getIbflag().equals("I")){
					poolUseddysMGTVOs[i].setCreUsrId(account.getUsr_id());
					poolUseddysMGTVOs[i].setChssPoolCd(poolUseddysINVO.getChssPoolCd());
					poolUseddysMGTVOs[i].setCostYrmon(poolUseddysINVO.getCostYrmon().replaceAll("-", ""));
					poolUseddysMGTVOs[i].setSaveChk(poolUseddysINVO.getSaveChk());
					poolUseddysMGTVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(poolUseddysMGTVOs[i]);
				} else if ( poolUseddysMGTVOs[i].getIbflag().equals("D")){
					deleteVoList.add(poolUseddysMGTVOs[i]);
				}
			}
			
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addPoolChsFileImportData(insertVoList);
				
			}
			
 
			if ( deleteVoList.size() > 0 ) {
				dbDao.removePoolChsUseImpErrData(deleteVoList);
				dbDao.removePoolChsPoolCoUseData(deleteVoList);
				dbDao.removePoolChsFileImportData(deleteVoList);
			}
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * 배치 호출   Save. [EES_CGM_1145]<br>
	 * @param poolUseddysINVO PoolUseddysINVO
	 * @param poolUseddysMGTVOs PoolUseddysMGTVO[]
	 * @param account SignOnUserAccount
	 * @throws EventException
	 */
	public String getPoolChsUseHistoryImport(PoolUseddysINVO poolUseddysINVO,PoolUseddysMGTVO[] poolUseddysMGTVOs, SignOnUserAccount account) throws EventException{
		ScheduleUtil su = new ScheduleUtil();
		//실행 전 해당 Batch 모듈이 실행 중인지 확인한다. 
		boolean bIsRunning = false;
		boolean chkRunning = false;
		try {
			bIsRunning = su.isRunning("EES_CGM_B005");
		} catch (DAOException e) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),e);
		}//004에서 002로 대체 2009.08.27 
		catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
	 	}
		
		if(bIsRunning)
			return "6";//진행 중
		else{
			try {
				//VOP_PSO_B002 no-use-data#2010-01#2010-01#PSOTEST#C
				String stmp="";
				for ( int i=0; i<poolUseddysMGTVOs.length; i++ ) {

//					log.debug("poolUseddysMGTVOs ===getIbflag======= " + poolUseddysMGTVOs[i].getIbflag());
					if ( poolUseddysMGTVOs[i].getIbflag().equals("I")){
						stmp = stmp+"#" + poolUseddysMGTVOs[i].getSavFileNm();
						chkRunning = true;
					}  
				}
				if(chkRunning == true){
					log.debug("poolUseddysMGTVOs  EES_CGM_B005" );
					su.directExecuteJob("EES_CGM_B005",account.getCre_usr_id()+stmp);
				}
			} catch (IOException e) {
				throw new EventException(new ErrorHandler("CGM20032").getMessage(),e);
			} catch (InterruptedException e) {
				throw new EventException(new ErrorHandler("CGM20032").getMessage(),e);
			} catch (DAOException e) {
				throw new EventException(new ErrorHandler("CGM20031").getMessage(),e);
			} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		 	}
			return "4";//실행 성공
		}
	}
	
	/**
	 * 배치에서 CGM_POOL_CO_CHSS_USE_HIS 엑셀 데이터를 저장 
	 * @param poolCoChssUseHisMGTVO PoolCoChssUseHisMGTVO
	 * @param poolMgmtCd String
	 * @return String
	 * @throws EventException
	 */
	public String managePoolChsFileImportBasic(PoolCoChssUseHisMGTVO poolCoChssUseHisMGTVO,String poolMgmtCd) throws EventException{
		String    sReust = "1";
		String result = "";
		try {
			//
			if(poolMgmtCd.equals("F")){ 
				result = dbDao.searchPoolChsUseHisFlexiData(poolCoChssUseHisMGTVO);
				// 입력 
				if(result.equals("0")){
					log.debug("poolCoChssUseHisMGTVO.getPoolChssUsdDys()==================="+poolCoChssUseHisMGTVO.getPoolChssUsdDys());
					 dbDao.addPoolChsUseHisFlexiData(poolCoChssUseHisMGTVO);
				} else {
				// 수정 
					log.debug("poolCoChssUseHisMGTVO.getPoolChssUsdDys()==================="+poolCoChssUseHisMGTVO.getPoolChssUsdDys());
					 dbDao.modifyPoolChsUseHisFlexiData(poolCoChssUseHisMGTVO);
				}
			} else {
				result = dbDao.searchPoolChsUseHisSeacasData(poolCoChssUseHisMGTVO);
				// 입력 
				if(result.equals("0")){
					log.debug("poolCoChssUseHisMGTVO.getPoolChssUsdDys()==================="+poolCoChssUseHisMGTVO.getPoolChssUsdDys());
					 dbDao.addPoolChsUseHisSeacasData(poolCoChssUseHisMGTVO);
				} else {
				// 수정 
					log.debug("poolCoChssUseHisMGTVO.getPoolChssUsdDys()==================="+poolCoChssUseHisMGTVO.getPoolChssUsdDys());
					 dbDao.modifyPoolChsUseHisSeacasData(poolCoChssUseHisMGTVO);
				}
			} 
		
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
		return sReust;
	}
	
	
	/**
	 *  Pool Chassis USED DAYS File Import 상태 조회 Retrieve. [EES_CGM_1149]<br>
	 * 
	 * @param poolUseddysMGTVO PoolUseddysMGTVO 
	 * @return List<PoolUseddysMGTVO>
	 * @throws EventException
	 */
	public List<PoolUseddysMGTVO> searchPoolChsFileImportErrorListBasic(PoolUseddysMGTVO poolUseddysMGTVO) throws EventException{
		try {
 			return dbDao.searchPoolChsFileImportErrorListData(poolUseddysMGTVO);
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

}