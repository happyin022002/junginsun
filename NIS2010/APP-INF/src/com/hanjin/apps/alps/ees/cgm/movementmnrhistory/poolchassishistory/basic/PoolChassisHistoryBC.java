/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PoolChassisHistoryBC.java
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

import java.util.List;

import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolCoChssUseHisMGTVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolExpenseTrendMGTVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolMaintRprHisMGTVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolMnrHistoryINVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolMvmtCompareSmryMGTVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolMvmtGroupVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolMvmtHistoryMGTVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolMvmtINVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolUseddysINVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolUseddysMGTVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Movementmnrhistory Business Logic Command Interface<br>
 * - ALPS-Movementmnrhistory에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author CHOI MIN HOI
 * @see Ees_cgm_1141EventResponse 참조
 * @since J2EE 1.6
 */

public interface PoolChassisHistoryBC {

	/**
	 * Pool movement & SML Movement 비교, match/unmatch summary  정보 Retrieve. [EES_CGM_1142]<br>
	 * 
	 * @param poolMvmtINVO PoolMvmtINVO 
	 * @return List<PoolMvmtCompareSmryMGTVO>
	 * @throws EventException
	 */
	public List<PoolMvmtCompareSmryMGTVO> searchPoolMvmtCompareDtlBasic(PoolMvmtINVO poolMvmtINVO) throws EventException;
	
	/**
	 * Pool movement & SML Movement 비교, match/unmatch summary 조회 Retrieve. [EES_CGM_1141]<br>
	 * 
	 * @param poolMvmtINVO PoolMvmtINVO 
	 * @return PoolMvmtGroupVO
	 * @throws EventException
	 */
	public PoolMvmtGroupVO  searchPoolMvmtComparisonBasic(PoolMvmtINVO poolMvmtINVO) throws EventException;
	
	
	/**
	 *  월별, Pool별 Pool Invoice 비용, 비용 Estimate 를 조회한다 Retrieve. [EES_CGM_1143]<br>
	 * 
	 * @param poolMvmtINVO PoolMvmtINVO 
	 * @return List<PoolExpenseTrendMGTVO>
	 * @throws EventException
	 */
	public List<PoolExpenseTrendMGTVO> searchPoolMvmtExpenseListBasic(PoolMvmtINVO poolMvmtINVO) throws EventException;
	
	/**
	 *  Pool Chassis Mnr 데이터를 조회한다 Retrieve. [EES_CGM_1144]<br>
	 * 
	 * @param poolMnrHistoryINVO PoolMnrHistoryINVO 
	 * @return PoolMvmtGroupVO
	 * @exception EventException
	 */
	public PoolMvmtGroupVO  searchPoolMnrHistoryBasic(PoolMnrHistoryINVO poolMnrHistoryINVO) throws EventException;
	
	/**
	 * Pool Chassis Movement 데이터를 DB 에 저장한다.EDI 로부터 InterfaceBC 를 통해 호출된다.
	 * 
	 * @param poolMvmtHistoryMGTVO PoolMvmtHistoryMGTVO
	 * @throws EventException
	 */
	public void managePoolMovementBasic(PoolMvmtHistoryMGTVO poolMvmtHistoryMGTVO) throws EventException;
	
	/**
	 * CGM POOL MNR REPAIR HISTORY 엔티티로 세부 건들을 저장하였다. DB 에 저장한다.EDI 로부터 InterfaceBC 를 통해 호출된다.
	 * 
	 * @param poolMaintRprHisMGTVO PoolMaintRprHisMGTVO
	 * @throws EventException
	 */
	public void managePoolMnrInvoiceImportBasic(PoolMaintRprHisMGTVO  poolMaintRprHisMGTVO ) throws EventException;
	
	
	/**
	 *  Pool Chassis USED DAYS File Import 상태 조회 Retrieve. [EES_CGM_1145]<br>
	 * 
	 * @param poolUseddysINVO PoolUseddysINVO 
	 * @return List<PoolUseddysMGTVO>
	 * @throws EventException
	 */
	public List<PoolUseddysMGTVO> searchPoolChsUseddaysFileStatusBasic(PoolUseddysINVO poolUseddysINVO) throws EventException;
	
	/**
	 * Pool Chassis Used days 정보를 db 에 저장한다 Save. [EES_CGM_1145]<br>
	 * @param poolUseddysINVO PoolUseddysINVO
	 * @param poolUseddysMGTVOs PoolUseddysMGTVO[]
	 * @param account SignOnUserAccount
	 * @throws EventException
	 */
	public void addPoolChsFileImportBasic(PoolUseddysINVO poolUseddysINVO,PoolUseddysMGTVO[] poolUseddysMGTVOs, SignOnUserAccount account) throws EventException;

	/**
	 * 배치 호출 Save. [EES_CGM_1145]<br>
	 * @param poolUseddysINVO PoolUseddysINVO
	 * @param poolUseddysMGTVOs PoolUseddysMGTVO[]
	 * @param account SignOnUserAccount
	 * @throws EventException
	 */
	public String getPoolChsUseHistoryImport(PoolUseddysINVO poolUseddysINVO,PoolUseddysMGTVO[] poolUseddysMGTVOs, SignOnUserAccount account) throws EventException;
    
	/**
	 * 배치에서 CGM_POOL_CO_CHSS_USE_HIS 엑셀 데이터를 저장 
	 * @param poolCoChssUseHisMGTVO PoolCoChssUseHisMGTVO
	 * @param poolMgmtCd String
	 * @return String
	 * @throws EventException
	 */
	public String managePoolChsFileImportBasic(PoolCoChssUseHisMGTVO poolCoChssUseHisMGTVO,String poolMgmtCd) throws EventException;
	
	/**
	 *  Pool Chassis USED DAYS File Import 상태 조회 Retrieve. [EES_CGM_1149]<br>
	 * 
	 * @param poolUseddysMGTVO PoolUseddysMGTVO 
	 * @return List<PoolUseddysMGTVO>
	 * @throws EventException
	 */
	public List<PoolUseddysMGTVO> searchPoolChsFileImportErrorListBasic(PoolUseddysMGTVO poolUseddysMGTVO) throws EventException;

}