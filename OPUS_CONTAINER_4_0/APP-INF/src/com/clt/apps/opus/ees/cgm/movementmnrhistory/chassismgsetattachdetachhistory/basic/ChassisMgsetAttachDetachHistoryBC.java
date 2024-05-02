/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetAttachDetachHistoryBC.java
*@FileTitle : sdfds
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.basic;

import java.util.List;

import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSEquipmentINVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.vo.CHSAtdtHistoryMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.vo.CHSMovementHistoryMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.vo.MGSAtdtHistoryINVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.vo.MGSAtdtHistoryMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CNTRMvmtMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.vo.MGSCNTRMvmtMGTVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-Movementmnrhistory Business Logic Command Interface<br>
 * - OPUS-Movementmnrhistory Business Logic Interface<br>
 *
 * @author 
 * @see SfdsEventResponse reference
 * @since J2EE 1.6
 */

public interface ChassisMgsetAttachDetachHistoryBC {

	/**
	 *  Called in case of CHS Bare mvmt creation, Detach SAVE Chassis that attach status <br>
	 *
	 * @param cHSMovementHistoryMGTVOs List<CHSMovementHistoryMGTVO>
	 * @exception EventException
	 */
	public void detachCHSByBareMvmtBasic(List<CHSMovementHistoryMGTVO> cHSMovementHistoryMGTVOs) throws EventException;

	/**
	 * Retrieve Eq attach/detach Status  [EES_CGM_1015]<br>
	 *
	 * @param cHSAtdtHistoryMGTVO CHSAtdtHistoryMGTVO
	 * @return List<CHSAtdtHistoryMGTVO>
	 * @exception EventException
	 */
	public List<CHSAtdtHistoryMGTVO> searchCHSAtdtStsBasic(CHSAtdtHistoryMGTVO cHSAtdtHistoryMGTVO) throws EventException;

	/**
	 * Chassis Attatch/Detach information save(History save)  [EES_CGM_1015]<br>
	 *
	 * @param cHSAtdtHistoryMGTVOs CHSAtdtHistoryMGTVO[]
     * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageCHSAtdtManualBasic(CHSAtdtHistoryMGTVO[] cHSAtdtHistoryMGTVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Retrieve Eq attach/detach Status. Retrieve.  [EES_CGM_2016]<br>
	 *
	 * @param mGSAtdtHistoryMGTVO MGSAtdtHistoryMGTVO
	 * @return List<MGSAtdtHistoryMGTVO>
	 * @exception EventException
	 */
	public List<MGSAtdtHistoryMGTVO> searchMGSAtdtStsBasic(MGSAtdtHistoryMGTVO mGSAtdtHistoryMGTVO) throws EventException;

	/**
	 * Save Eq bare movement modificaton/deleting.  [EES_CGM_2016]<br>
	 *
	 * @param  mGSAtdtHistoryMGTVOs MGSAtdtHistoryMGTVO[]
	 * @param  account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageMGSAtdtManualBasic(MGSAtdtHistoryMGTVO[] mGSAtdtHistoryMGTVOs, SignOnUserAccount account) throws EventException;

	/**
	 * INVENTORY apply for MGS Current Location apply in case of MGS AT/DT History event.  [EES_CGM_2016]<br>
	 *
	 * @param  mGSAtdtHistoryMGTVOs MGSAtdtHistoryMGTVO[]
	 * @param  account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyMGSCurrentLocationBasic(MGSAtdtHistoryMGTVO[] mGSAtdtHistoryMGTVOs, SignOnUserAccount account) throws EventException;

	/**
	 * INVENTORY apply for MGS Current History apply in case of MGS AT/DT History event.  [EES_CGM_2016]<br>
	 *
	 * @param  mGSAtdtHistoryMGTVOs MGSAtdtHistoryMGTVO[]
	 * @param  account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyMGSCurrentChassisBasic(MGSAtdtHistoryMGTVO[] mGSAtdtHistoryMGTVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Action DT by CHS in case of MVMT create   [EES_CGM_1109]<br>
	 *
	 * @param cNTRMvmtMGTVO CNTRMvmtMGTVO
	 * @exception EventException
	 */
	public void manageCHSDetachByChssBasic(CNTRMvmtMGTVO  cNTRMvmtMGTVO) throws EventException;


	/**
	 * EQ Attatch/Detach information save(History save)  [EES_CGM_1109]<br>
	 *
	 * @param cHSAtdtHistoryMGTVOs List<CHSAtdtHistoryMGTVO>
	 * @exception EventException
	 */
	public void manageCHSAtdtByMvmtBasic(List<CHSAtdtHistoryMGTVO>  cHSAtdtHistoryMGTVOs) throws EventException;

	/**
	 * Handling Chassis, M.G.Set Attach/Detach list by recieve  322 Movement data from CTM  [ChassisMovementHistoryBCImpl call]<br>
	 *
	 * @param cHSAtdtHistoryMGTVO CHSAtdtHistoryMGTVO
	 * @exception EventException
	 */
	public void manageCHSAtdtByCtmBasic(CHSAtdtHistoryMGTVO cHSAtdtHistoryMGTVO) throws EventException;

	/**
	 * atdt update from ctm
	 *
	 * @param cHSAtdtHistoryMGTVO CHSAtdtHistoryMGTVO
	 * @throws EventException
	 */
	public void  manageCHSAtdtHistoryBasic(CHSAtdtHistoryMGTVO cHSAtdtHistoryMGTVO) throws EventException;

	/**
	 * Modify before/after attach information in case of date/yard modification/deleting from CTM
	 *
	 * @param cHSAtdtHistoryMGTVO CHSAtdtHistoryMGTVO
	 * @throws EventException
	 */
	public void  manageCHSAtdtPrePostHistoryBasic(CHSAtdtHistoryMGTVO cHSAtdtHistoryMGTVO) throws EventException;

	/**
	 * Modify after attach information in case of 1108 deleting
	 *
	 * @param List<CHSMovementHistoryMGTVO> cHSMovementHistoryMGTVOs
	 * @throws EventException
	 */
	public void modifyCHSAtdtByRemoveBareMvmtBasic(List<CHSMovementHistoryMGTVO> cHSMovementHistoryMGTVOs) throws EventException;


	/**
	 * M.G.Set Eq Master AT/DT information modification. Manage [EES_CGM_2006]<br>
	 *
	 * @param mGSEquipmentINVO MGSEquipmentINVO
	 * @param mGSAtdtHistoryINVOs MGSAtdtHistoryINVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void manageMGSAtdtHistoryBasic(MGSEquipmentINVO mGSEquipmentINVO,MGSAtdtHistoryINVO[] mGSAtdtHistoryINVOs, SignOnUserAccount account)throws EventException;

	/**
	 * Action DT by CHS in case of MVMT create   [EES_CGM_1109]<br>
	 *
	 * @param MGSCNTRMvmtMGTVO  cNTRMvmtMGTVO
	 * @exception EventException
	 */
	public void manageMGSDetachByMgstBasic(MGSCNTRMvmtMGTVO  cNTRMvmtMGTVO) throws EventException;
	
	/**
	 * Handling Chassis, M.G.Set Attach/Detach list by recieve  322 Movement data from CTM  [ChassisMovementHistoryBCImpl call]<br>
	 *
	 * @param MGSAtdtHistoryMGTVO mGSAtdtHistoryMGTVO
	 * @exception EventException
	 */
	public void manageMGSAtdtByCtmBasic(MGSAtdtHistoryMGTVO mGSAtdtHistoryMGTVO) throws EventException;
	
	/**
	 * EQ Attatch/Detach information save(History save)  [EES_CGM_1109]<br>
	 *
	 * @param List<MGSAtdtHistoryMGTVO>  mGSAtdtHistoryMGTVOs
	 * @exception EventException
	 */
	public void manageMGSAtdtByMvmtBasic(List<MGSAtdtHistoryMGTVO>  mGSAtdtHistoryMGTVOs) throws EventException;
	
	/**
	 * atdt update from ctm
	 *
	 * @param MGSAtdtHistoryMGTVO mGSAtdtHistoryMGTVO
	 * @throws EventException
	 */
	public void  manageMGSAtdtHistoryBasic(MGSAtdtHistoryMGTVO mGSAtdtHistoryMGTVO) throws EventException;
	
	/**
	 * Modify before/after attach information in case of date/yard modification/deleting from CTM
	 *
	 * @param MGSAtdtHistoryMGTVO mGSAtdtHistoryMGTVO
	 * @throws EventException
	 */
	public void  manageMGSAtdtPrePostHistoryBasic(MGSAtdtHistoryMGTVO mGSAtdtHistoryMGTVO) throws EventException;
}