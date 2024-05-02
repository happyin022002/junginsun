/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetAttachDetachHistoryBC.java
*@FileTitle : sdfds
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.07.06 최민회
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSEquipmentINVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.vo.CHSAtdtHistoryMGTVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.vo.MGSAtdtHistoryINVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.vo.MGSAtdtHistoryMGTVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.vo.CHSMovementHistoryMGTVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CNTRMvmtMGTVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Movementmnrhistory Business Logic Command Interface<br>
 * - ALPS-Movementmnrhistory에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author CHOI MIN HOI
 * @see SfdsEventResponse 참조
 * @since J2EE 1.6
 */

public interface ChassisMgsetAttachDetachHistoryBC {

	/**
	 *  CHS Bare mvmt 발생시 호출되며,Attach 상태의 Chassis 를 Detach SAVE. <br>
	 *
	 * @param cHSMovementHistoryMGTVOs List<CHSMovementHistoryMGTVO>
	 * @exception EventException
	 */
	public void detachCHSByBareMvmtBasic(List<CHSMovementHistoryMGTVO> cHSMovementHistoryMGTVOs) throws EventException;

	/**
	 * Eq attach/detach Status 를 Retrieve 한다.  [EES_CGM_1015]<br>
	 *
	 * @param cHSAtdtHistoryMGTVO CHSAtdtHistoryMGTVO
	 * @return List<CHSAtdtHistoryMGTVO>
	 * @exception EventException
	 */
	public List<CHSAtdtHistoryMGTVO> searchCHSAtdtStsBasic(CHSAtdtHistoryMGTVO cHSAtdtHistoryMGTVO) throws EventException;

	/**
	 * Chassis Attatch/Detach 정보 저장(History 저장) 를 Save 한다.  [EES_CGM_1015]<br>
	 *
	 * @param cHSAtdtHistoryMGTVOs CHSAtdtHistoryMGTVO[]
     * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageCHSAtdtManualBasic(CHSAtdtHistoryMGTVO[] cHSAtdtHistoryMGTVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Eq attach/detach Status 를 조회한다. Retrieve 한다.  [EES_CGM_2016]<br>
	 *
	 * @param mGSAtdtHistoryMGTVO MGSAtdtHistoryMGTVO
	 * @return List<MGSAtdtHistoryMGTVO>
	 * @exception EventException
	 */
	public List<MGSAtdtHistoryMGTVO> searchMGSAtdtStsBasic(MGSAtdtHistoryMGTVO mGSAtdtHistoryMGTVO) throws EventException;

	/**
	 * Eq bare movement 를 수정/삭제한다 를 Save 한다.  [EES_CGM_2016]<br>
	 *
	 * @param  mGSAtdtHistoryMGTVOs MGSAtdtHistoryMGTVO[]
	 * @param  account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageMGSAtdtManualBasic(MGSAtdtHistoryMGTVO[] mGSAtdtHistoryMGTVOs, SignOnUserAccount account) throws EventException;

	/**
	 * MGS Current Location반영을 위해 MGS AT/DT History 이벤트시 INVENTORY 반영.  [EES_CGM_2016]<br>
	 *
	 * @param  mGSAtdtHistoryMGTVOs MGSAtdtHistoryMGTVO[]
	 * @param  account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyMGSCurrentLocationBasic(MGSAtdtHistoryMGTVO[] mGSAtdtHistoryMGTVOs, SignOnUserAccount account) throws EventException;

	/**
	 * MGS Current Chassis반영을 위해 MGS AT/DT History 이벤트시 INVENTORY 반영.  [EES_CGM_2016]<br>
	 *
	 * @param  mGSAtdtHistoryMGTVOs MGSAtdtHistoryMGTVO[]
	 * @param  account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyMGSCurrentChassisBasic(MGSAtdtHistoryMGTVO[] mGSAtdtHistoryMGTVOs, SignOnUserAccount account) throws EventException;

	/**
	 * MVMT생성시 관련 CHS로 DT를 수행   [EES_CGM_1109]<br>
	 *
	 * @param cNTRMvmtMGTVO CNTRMvmtMGTVO
	 * @exception EventException
	 */
	public void manageCHSDetachByChssBasic(CNTRMvmtMGTVO  cNTRMvmtMGTVO) throws EventException;


	/**
	 * EQ Attatch/Detach 정보 저장(History 저장)  [EES_CGM_1109]<br>
	 *
	 * @param cHSAtdtHistoryMGTVOs List<CHSAtdtHistoryMGTVO>
	 * @exception EventException
	 */
	public void manageCHSAtdtByMvmtBasic(List<CHSAtdtHistoryMGTVO>  cHSAtdtHistoryMGTVOs) throws EventException;

	/**
	 * CTM 으로부터 322 Movement 데이터를 받아 Chassis, M.G.Set Attach/Detach 내역을 처리 한다.  [ChassisMovementHistoryBCImpl 호출]<br>
	 *
	 * @param cHSAtdtHistoryMGTVO CHSAtdtHistoryMGTVO
	 * @exception EventException
	 */
	public void manageCHSAtdtByCtmBasic(CHSAtdtHistoryMGTVO cHSAtdtHistoryMGTVO) throws EventException;

	/**
	 * ctm 으로 부터  atdt 업데이트
	 *
	 * @param cHSAtdtHistoryMGTVO CHSAtdtHistoryMGTVO
	 * @throws EventException
	 */
	public void  manageCHSAtdtHistoryBasic(CHSAtdtHistoryMGTVO cHSAtdtHistoryMGTVO) throws EventException;

	/**
	 * ctm 으로 부터  date,yard 변경시 또는 삭제시 바로 전 detach 정보, 후의 attach 정보를 수정한다
	 *
	 * @param cHSAtdtHistoryMGTVO CHSAtdtHistoryMGTVO
	 * @throws EventException
	 */
	public void  manageCHSAtdtPrePostHistoryBasic(CHSAtdtHistoryMGTVO cHSAtdtHistoryMGTVO) throws EventException;

	/**
	 * 1108 삭제시 정보, 후의 attach 정보를 수정한다
	 *
	 * @param List<CHSMovementHistoryMGTVO> cHSMovementHistoryMGTVOs
	 * @throws EventException
	 */
	public void modifyCHSAtdtByRemoveBareMvmtBasic(List<CHSMovementHistoryMGTVO> cHSMovementHistoryMGTVOs) throws EventException;


	/**
	 * M.G.Set Eq Master AT/DT 정보를 수정한다. Manage [EES_CGM_2006]<br>
	 *
	 * @param mGSEquipmentINVO MGSEquipmentINVO
	 * @param mGSAtdtHistoryINVOs MGSAtdtHistoryINVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void manageMGSAtdtHistoryBasic(MGSEquipmentINVO mGSEquipmentINVO,MGSAtdtHistoryINVO[] mGSAtdtHistoryINVOs, SignOnUserAccount account)throws EventException;

}