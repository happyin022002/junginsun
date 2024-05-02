/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PoolChassisHistoryBCImpl.java
*@FileTitle : Pool Chassis Comparison Summary
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.basic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.integration.PoolChassisHistoryDBDAO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolCoChssUseHisMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolExpenseTrendMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolMaintRprHisMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolMnrHistoryINVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolMnrHistoryMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolMvmtCompareSmryMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolMvmtGroupVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolMvmtHistoryMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolMvmtINVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolUseddysINVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolUseddysMGTVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.util.ScheduleUtil;

/**
 * OPUS-MovementMnrHistory Business Logic Basic Command implementation<br>
 * - OPUS-MovementMnrHistory biz logic handling.<br>
 *
 * @author CHOI MIN HOI
 * @see EES_CGM_1141EventResponse,PoolChassisHistoryBC each DAO class reference
 * @since J2EE 1.6
 */
public class PoolChassisHistoryBCImpl extends BasicCommandSupport implements PoolChassisHistoryBC {

	// Database Access Object
	private transient PoolChassisHistoryDBDAO dbDao = null;

	/**
	 * PoolChassisHistoryBCImpl objects creation<br>
	 * PoolChassisHistoryDBDAO creation.<br>
	 */
	public PoolChassisHistoryBCImpl() {
		dbDao = new PoolChassisHistoryDBDAO();
	}
	/**
	 * Pool movement & Movement prepare, match/unmatch summary  information Retrieve. [EES_CGM_1142]<br>
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
	 * Pool movement & Movement prepare, match/unmatch summary Retrieve. [EES_CGM_1141]<br>
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
	 *  (monthly, each Pool) Pool Invoice cost, cost Estimate  retrieve Retrieve. [EES_CGM_1143]<br>
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
	 *  Pool Chassis Mnr data retrieve Retrieve. [EES_CGM_1144]<br>
	 * 
	 * @param poolMnrHistoryINVO PoolMnrHistoryINVO 
	 * @return PoolMvmtGroupVO
	 * @exception EventException
	 */
	public PoolMvmtGroupVO  searchPoolMnrHistoryBasic(PoolMnrHistoryINVO poolMnrHistoryINVO) throws EventException {
		PoolMvmtGroupVO  poolmvmtgroupvo = new PoolMvmtGroupVO();
		try {
			
			List<PoolMnrHistoryMGTVO> agreementList = dbDao.searchPoolMnrHistorySummaryData (poolMnrHistoryINVO);
			
			poolmvmtgroupvo.setPoolmnrhistorymgtvo(agreementList);
			
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
	 * Pool Chassis Movement data save.
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
	 * CGM POOL MNR REPAIR HISTORY details save
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
	 *  Pool Chassis USED DAYS File Import status Retrieve. [EES_CGM_1145]<br>
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
	 * Pool Chassis Used days information Save. [EES_CGM_1145]<br>
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
	 * batch call save. [EES_CGM_1145]<br>
	 * @param poolUseddysINVO PoolUseddysINVO
	 * @param poolUseddysMGTVOs PoolUseddysMGTVO[]
	 * @param account SignOnUserAccount
	 * @throws EventException
	 */
	public String getPoolChsUseHistoryImport(PoolUseddysINVO poolUseddysINVO,PoolUseddysMGTVO[] poolUseddysMGTVOs, SignOnUserAccount account) throws EventException{
		ScheduleUtil su = new ScheduleUtil();

		boolean bIsRunning = false;
		boolean chkRunning = false;
		try {
			bIsRunning = su.isRunning("EES_CGM_B005");
		} catch (DAOException e) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),e);
		}
		catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
	 	}
		
		if(bIsRunning)
			return "6";//
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
			return "4";//
		}
	}
	
	/**
	 * CGM_POOL_CO_CHSS_USE_HIS excel data save
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
				// 
				if(result.equals("0")){
					log.debug("poolCoChssUseHisMGTVO.getPoolChssUsdDys()==================="+poolCoChssUseHisMGTVO.getPoolChssUsdDys());
					 dbDao.addPoolChsUseHisFlexiData(poolCoChssUseHisMGTVO);
				} else {
				// modification 
					log.debug("poolCoChssUseHisMGTVO.getPoolChssUsdDys()==================="+poolCoChssUseHisMGTVO.getPoolChssUsdDys());
					 dbDao.modifyPoolChsUseHisFlexiData(poolCoChssUseHisMGTVO);
				}
			} else {
				result = dbDao.searchPoolChsUseHisSeacasData(poolCoChssUseHisMGTVO);
				// 
				if(result.equals("0")){
					log.debug("poolCoChssUseHisMGTVO.getPoolChssUsdDys()==================="+poolCoChssUseHisMGTVO.getPoolChssUsdDys());
					 dbDao.addPoolChsUseHisSeacasData(poolCoChssUseHisMGTVO);
				} else {
				// modification 
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
	 *  Pool Chassis USED DAYS File Import status Retrieve. [EES_CGM_1149]<br>
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