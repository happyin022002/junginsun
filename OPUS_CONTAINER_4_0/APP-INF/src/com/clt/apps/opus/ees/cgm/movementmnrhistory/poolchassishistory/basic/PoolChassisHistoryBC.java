/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PoolChassisHistoryBC.java
*@FileTitle : Pool Chassis Comparison Summary
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.basic;

import java.util.List;

import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolCoChssUseHisMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolExpenseTrendMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolMaintRprHisMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolMnrHistoryINVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolMvmtCompareSmryMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolMvmtGroupVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolMvmtHistoryMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolMvmtINVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolUseddysINVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolUseddysMGTVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-Movementmnrhistory Business Logic Command Interface<br>
 * - OPUS-Movementmnrhistory Business Logic Interface<br>
 *
 * @author CHOI MIN HOI
 * @see Ees_cgm_1141EventResponse reference
 * @since J2EE 1.6
 */

public interface PoolChassisHistoryBC {

	/**
	 * Pool movement & Movement prepare, match/unmatch summary  information Retrieve. [EES_CGM_1142]<br>
	 * 
	 * @param poolMvmtINVO PoolMvmtINVO 
	 * @return List<PoolMvmtCompareSmryMGTVO>
	 * @throws EventException
	 */
	public List<PoolMvmtCompareSmryMGTVO> searchPoolMvmtCompareDtlBasic(PoolMvmtINVO poolMvmtINVO) throws EventException;
	
	/**
	 * Pool movement & Movement prepare, match/unmatch summary Retrieve. [EES_CGM_1141]<br>
	 * 
	 * @param poolMvmtINVO PoolMvmtINVO 
	 * @return PoolMvmtGroupVO
	 * @throws EventException
	 */
	public PoolMvmtGroupVO  searchPoolMvmtComparisonBasic(PoolMvmtINVO poolMvmtINVO) throws EventException;
	
	
	/**
	 *  (monthly, each Pool) Pool Invoice cost, cost Estimate  retrieve Retrieve. [EES_CGM_1143]<br>
	 * 
	 * @param poolMvmtINVO PoolMvmtINVO 
	 * @return List<PoolExpenseTrendMGTVO>
	 * @throws EventException
	 */
	public List<PoolExpenseTrendMGTVO> searchPoolMvmtExpenseListBasic(PoolMvmtINVO poolMvmtINVO) throws EventException;
	
	/**
	 *  Pool Chassis Mnr data retrieve Retrieve. [EES_CGM_1144]<br>
	 * 
	 * @param poolMnrHistoryINVO PoolMnrHistoryINVO 
	 * @return PoolMvmtGroupVO
	 * @exception EventException
	 */
	public PoolMvmtGroupVO  searchPoolMnrHistoryBasic(PoolMnrHistoryINVO poolMnrHistoryINVO) throws EventException;
	
	/**
	 * Pool Chassis Movement data save.
	 * 
	 * @param poolMvmtHistoryMGTVO PoolMvmtHistoryMGTVO
	 * @throws EventException
	 */
	public void managePoolMovementBasic(PoolMvmtHistoryMGTVO poolMvmtHistoryMGTVO) throws EventException;
	
	/**
	 * CGM POOL MNR REPAIR HISTORY details save
	 * 
	 * @param poolMaintRprHisMGTVO PoolMaintRprHisMGTVO
	 * @throws EventException
	 */
	public void managePoolMnrInvoiceImportBasic(PoolMaintRprHisMGTVO  poolMaintRprHisMGTVO ) throws EventException;
	
	
	/**
	 *  Pool Chassis USED DAYS File Import status Retrieve. [EES_CGM_1145]<br>
	 * 
	 * @param poolUseddysINVO PoolUseddysINVO 
	 * @return List<PoolUseddysMGTVO>
	 * @throws EventException
	 */
	public List<PoolUseddysMGTVO> searchPoolChsUseddaysFileStatusBasic(PoolUseddysINVO poolUseddysINVO) throws EventException;
	
	/**
	 * Pool Chassis Used days information Save. [EES_CGM_1145]<br>
	 * @param poolUseddysINVO PoolUseddysINVO
	 * @param poolUseddysMGTVOs PoolUseddysMGTVO[]
	 * @param account SignOnUserAccount
	 * @throws EventException
	 */
	public void addPoolChsFileImportBasic(PoolUseddysINVO poolUseddysINVO,PoolUseddysMGTVO[] poolUseddysMGTVOs, SignOnUserAccount account) throws EventException;

	/**
	 * batch call Save. [EES_CGM_1145]<br>
	 * @param poolUseddysINVO PoolUseddysINVO
	 * @param poolUseddysMGTVOs PoolUseddysMGTVO[]
	 * @param account SignOnUserAccount
	 * @throws EventException
	 */
	public String getPoolChsUseHistoryImport(PoolUseddysINVO poolUseddysINVO,PoolUseddysMGTVO[] poolUseddysMGTVOs, SignOnUserAccount account) throws EventException;
    
	/**
	 * CGM_POOL_CO_CHSS_USE_HIS excel data save
	 * @param poolCoChssUseHisMGTVO PoolCoChssUseHisMGTVO
	 * @param poolMgmtCd String
	 * @return String
	 * @throws EventException
	 */
	public String managePoolChsFileImportBasic(PoolCoChssUseHisMGTVO poolCoChssUseHisMGTVO,String poolMgmtCd) throws EventException;
	
	/**
	 *  Pool Chassis USED DAYS File Import status Retrieve. [EES_CGM_1149]<br>
	 * 
	 * @param poolUseddysMGTVO PoolUseddysMGTVO 
	 * @return List<PoolUseddysMGTVO>
	 * @throws EventException
	 */
	public List<PoolUseddysMGTVO> searchPoolChsFileImportErrorListBasic(PoolUseddysMGTVO poolUseddysMGTVO) throws EventException;

}