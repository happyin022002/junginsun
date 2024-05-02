/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMovementHistoryBC.java
*@FileTitle : test
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.basic;

import java.util.List;

import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSMovementMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSMvmtBareMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSMvmtGroupVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSMvmtINVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSMvmtMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSmgstChkINVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.vo.ShipCHSMvmtMGTVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.FlatFileForGateNewVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTBookingInfoVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTHistoryListVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.IFMnrFlagVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-Movementmnrhistory Business Logic Command Interface<br>
 * - OPUS-Movementmnrhistory Business Logic Interface<br>
 *
 * @author 
 * @see TestEventResponse reference
 * @since J2EE 1.6
 */

public interface ChassisMovementHistoryBC {

	/**
	 *  Eq Lost  'XX' movement inserting   [EES_CGM_1017,EES_CGM_1009] <br>
	 *
	 * @param cHSMovementMGTVOs List<CHSMovementMGTVO>
	 * @exception EventException
	 */
	public void createCHSXXMvmtBasic(List<CHSMovementMGTVO> cHSMovementMGTVOs) throws EventException;

	/**
	 *  Eq Found 'BI' movement inserting   [EES_CGM_1017,EES_CGM_1018] <br>
	 *
	 * @param cHSMovementMGTVOs List<CHSMovementMGTVO>
	 * @exception EventException
	 */
	public void createCHSFoundMvmtBasic(List<CHSMovementMGTVO> cHSMovementMGTVOs) throws EventException;

	/**
	 *  Eq movement information editing [EES_CGM_1016] <br>
	 *
	 * @param cHSMovementMGTVOs List<CHSMovementMGTVO>
	 * @exception EventException
	 */
	 public void  modifyChsMoveByStatusBasic(List<CHSMovementMGTVO> cHSMovementMGTVOs) throws EventException;

	/**
	 *  Eq movement information deleting   [EES_CGM_1016] <br>
	 *
	 * @param cHSMovementMGTVOs List<CHSMovementMGTVO>
	 * @exception EventException
	 */
    public void removeChsMoveByStatusBasic(List<CHSMovementMGTVO> cHSMovementMGTVOs) throws EventException;

	/**
	 *  Eq movement information deleting   [EES_CGM_1018] <br>
	 *
	 * @param cHSMovementMGTVOs List<CHSMovementMGTVO>
	 * @exception EventException
	 */
    public void removeChsMvmtFoundAutoBasic(List<CHSMovementMGTVO> cHSMovementMGTVOs) throws EventException;

	/**
	 *  (each Chassis) Movement History information retrieve   [EES_CGM_1104] <br>
	 *
	 * @param chsMvmtINVO CHSMvmtINVO
	 * @return  List<CHSMvmtMGTVO>
	 * @exception EventException
	 */
	public List<CHSMvmtMGTVO> searchCHSMovementListBasic(CHSMvmtINVO chsMvmtINVO) throws EventException;

	/**
	 *  chassismovementhistoryretrieve  [EES_CGM_1105] <br>
	 *
	 * @param cHSMvmtINVO CHSMvmtINVO
	 * @return  CHSMvmtGroupVO
	 * @exception EventException
	 */
	public CHSMvmtGroupVO searchCHSMovementHistoryBasic(CHSMvmtINVO cHSMvmtINVO) throws EventException;

	/**
	 *  chassismovementhistoryretrieve  [EES_CGM_1108] <br>
	 *
	 * @param cHSMvmtINVO CHSMvmtINVO
	 * @return  List<CHSMvmtBareMGTVO>
	 * @exception EventException
	 */
	public List<CHSMvmtBareMGTVO> searchCHSBareMvmtBasic(CHSMvmtINVO cHSMvmtINVO) throws EventException;


	/**
	 *  chassismovementhistoryverify  [EES_CGM_1108] <br>
	 *
	 * @param cHSMvmtBareMGTVOs CHSMvmtBareMGTVO[]
	 * @return  List<CHSMvmtBareMGTVO>
	 * @exception EventException
	 */
	public List<CHSMvmtBareMGTVO> verifyCHSBareMvmtBasic(CHSMvmtBareMGTVO[] cHSMvmtBareMGTVOs) throws EventException;

	/**
	 *  Eq bare movement editing/deleting.  [EES_CGM_1108] <br>
	 *
	 * @param cHSMvmtBareMGTVOs CHSMvmtBareMGTVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageCHSBareMvmtBasic(CHSMvmtBareMGTVO[] cHSMvmtBareMGTVOs, SignOnUserAccount account) throws EventException;

	/**
	 *  EEq bare movement inserting.  [EES_CGM_1108] <br>
	 *
	 * @param cHSMvmtBareMGTVOs CHSMvmtBareMGTVO[]
     * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createCHSBareMvmtBasic(CHSMvmtBareMGTVO[] cHSMvmtBareMGTVOs, SignOnUserAccount account) throws EventException;

	/**
	 *  Eq ON-hire 'MT' movement  <br>
	 *
	 * @param cHSMvmtBareMGTVOs List<CHSMovementMGTVO>
	 * @exception EventException
	 */
	public void createCHSOnhireMvmtBasic(List<CHSMovementMGTVO> cHSMvmtBareMGTVOs ) throws EventException;


	/**
	 *  Eq Retirement handling. SAVE  [MNR call]<br>
	 *
	 * @param IFMnrFlagVO iFMnrFlagVO
	 * @exception EventException
	 */
	public void createMNRStatusBasic(IFMnrFlagVO iFMnrFlagVO) throws EventException;

	/**
	 *  Chassis Movement editing operation SAVE  [CTM call]<br>
	 *
	 * @param cusCtmMovementVOs List<CusCtmMovementVO>
	 * @return int
	 */
	public String  manageCHSMovementByCtmBasic(List<CusCtmMovementVO> cusCtmMovementVOs);

	/**
	 *  Chassis Movement editing operation SAVE  [CTM call]<br>
	 *
	 * @param cusCtmMovementVOs List<CusCtmMovementVO>
	 *
	 */
	public void manageCHSMovementByCtmBatchBasic(List<CusCtmMovementVO> cusCtmMovementVOs) ;

	/**
	 *  Bare Movement handling operation SAVE  [CTM call]<br>
	 *
	 * @param flatFileForGateNewVO FlatFileForGateNewVO
	 * @return String[]
	 */
	public String[]  manageCHSMovementBareByGatenewBasic(FlatFileForGateNewVO flatFileForGateNewVO) throws EventException;

	/**
	 *  get call data
	 *
	 * @return List<CusCtmMovementVO>
	 */
	public List<CusCtmMovementVO> searchCtmMvmtSourceBasic() throws EventException;

	/**
	 *  VVD History get retrieve  [EES_CGM_1109] <br>
	 * @param mVMTBookingInfoVO MVMTBookingInfoVO
	 * @param account SignOnUserAccount
	 * @return List<MVMTBookingInfoVO>
	 * @throws EventException
	 */
	public List<MVMTBookingInfoVO> searchBookingInfoList(MVMTBookingInfoVO mVMTBookingInfoVO, SignOnUserAccount account) throws EventException;

	/**
	 * Movement History retrieve [EES_CGM_1109] <br>
	 * @param mVMTHistoryListVO MVMTHistoryListVO
	 * @return List<MVMTHistoryListVO>
	 * @throws EventException
	 */
	public List<MVMTHistoryListVO>  searchMVMTHistoryList(MVMTHistoryListVO mVMTHistoryListVO) throws EventException;

	/**
	 * Movement History retrieve [EES_CGM_1109] <br>
	 * @param cHSmgstChkINVO CHSmgstChkINVO
	 * @return List<CHSmgstChkINVO>
	 * @throws EventException
	 */
	public List<CHSmgstChkINVO>  searchchssAtdtVerifyBasic(CHSmgstChkINVO cHSmgstChkINVO) throws EventException;

	/**
	 * Movement History retrieve [EES_CGM_1109] <br>
	 * @param cHSmgstChkINVO CHSmgstChkINVO
	 * @return List<CHSmgstChkINVO>
	 * @throws EventException
	 */
	public List<CHSmgstChkINVO>  searchchssTpszOnCntrCHkBasic(CHSmgstChkINVO cHSmgstChkINVO) throws EventException;

	/**
	 * Shipper's Chassis Movement manage status retrieve. [EES_CGM_1150] <br>
	 *
	 * @param ShipCHSMvmtMGTVO shipCHSMvmtMGTVO
	 * @return  List<ShipCHSMvmtMGTVO>
	 * @exception EventException
	 */
	public List<ShipCHSMvmtMGTVO> searchShipChsMovementListBasic(ShipCHSMvmtMGTVO shipCHSMvmtMGTVO) throws EventException;

}