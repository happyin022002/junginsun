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
package com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.basic;

import java.util.List;

import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.vo.MGSMovementMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.vo.MGSMvmtBareMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.vo.MGSMvmtGroupVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.vo.MGSMvmtINVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.vo.MGSMvmtMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.vo.MGSmgstChkINVO;
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

public interface MgsetMovementHistoryBC {

	/**
	 *  Eq Lost  'XX' movement inserting   [EES_CGM_1017,EES_CGM_1009] <br>
	 *
	 * @param List<MGSMovementMGTVO> mGSMovementMGTVOs
	 * @exception EventException
	 */
	public void createMGSXXMvmtBasic(List<MGSMovementMGTVO> mGSMovementMGTVOs) throws EventException;

	/**
	 *  Eq Found 'BI' movement inserting   [EES_CGM_1017,EES_CGM_1018] <br>
	 *
	 * @param List<MGSMovementMGTVO> mGSMovementMGTVOs
	 * @exception EventException
	 */
	public void createMGSFoundMvmtBasic(List<MGSMovementMGTVO> mGSMovementMGTVOs) throws EventException;

	/**
	 *  Eq movement information editing [EES_CGM_1016] <br>
	 *
	 * @param List<MGSMovementMGTVO> mGSMovementMGTVOs
	 * @exception EventException
	 */
	 public void  modifyMgsMoveByStatusBasic(List<MGSMovementMGTVO> mGSMovementMGTVOs) throws EventException;

	/**
	 *  Eq movement information deleting   [EES_CGM_1016] <br>
	 *
	 * @param List<MGSMovementMGTVO> mGSMovementMGTVOs
	 * @exception EventException
	 */
    public void removeMgsMoveByStatusBasic(List<MGSMovementMGTVO> mGSMovementMGTVOs) throws EventException;

	/**
	 *  Eq movement information deleting   [EES_CGM_1018] <br>
	 *
	 * @param List<MGSMovementMGTVO> mGSMovementMGTVOs
	 * @exception EventException
	 */
    public void removeMgsMvmtFoundAutoBasic(List<MGSMovementMGTVO> mGSMovementMGTVOs) throws EventException;

	/**
	 *  (each Chassis) Movement History information retrieve   [EES_CGM_1104] <br>
	 *
	 * @param MGSMvmtINVO mgsMvmtINVO
	 * @return  List<MGSMvmtMGTVO>
	 * @exception EventException
	 */
	public List<MGSMvmtMGTVO> searchMGSMovementListBasic(MGSMvmtINVO mgsMvmtINVO) throws EventException;

	/**
	 *  chassismovementhistoryretrieve  [EES_CGM_1105] <br>
	 *
	 * @param MGSMvmtINVO mGSMvmtINVO
	 * @return  MGSMvmtGroupVO
	 * @exception EventException
	 */
	public MGSMvmtGroupVO searchMGSMovementHistoryBasic(MGSMvmtINVO mGSMvmtINVO) throws EventException;

	/**
	 *  chassismovementhistoryretrieve  [EES_CGM_1108] <br>
	 *
	 * @param MGSMvmtINVO mGSMvmtINVO
	 * @return  List<MGSMvmtBareMGTVO>
	 * @exception EventException
	 */
	public List<MGSMvmtBareMGTVO> searchMGSBareMvmtBasic(MGSMvmtINVO mGSMvmtINVO) throws EventException;


	/**
	 *  chassismovementhistoryverify  [EES_CGM_1108] <br>
	 *
	 * @param MGSMvmtBareMGTVO[] mGSMvmtBareMGTVOs
	 * @return  List<MGSMvmtBareMGTVO>
	 * @exception EventException
	 */
	public List<MGSMvmtBareMGTVO> verifyMGSBareMvmtBasic(MGSMvmtBareMGTVO[] mGSMvmtBareMGTVOs) throws EventException;

	/**
	 *  Eq bare movement editing/deleting.  [EES_CGM_1108] <br>
	 *
	 * @param MGSMvmtBareMGTVO[] mGSMvmtBareMGTVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageMGSBareMvmtBasic(MGSMvmtBareMGTVO[] mGSMvmtBareMGTVOs, SignOnUserAccount account) throws EventException;

	/**
	 *  EEq bare movement inserting.  [EES_CGM_1108] <br>
	 *
	 * @param MGSMvmtBareMGTVO[] mGSMvmtBareMGTVOs
     * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createMGSBareMvmtBasic(MGSMvmtBareMGTVO[] mGSMvmtBareMGTVOs, SignOnUserAccount account) throws EventException;

	/**
	 *  Eq ON-hire 'MT' movement  <br>
	 *
	 * @param List<MGSMovementMGTVO> mGSMvmtBareMGTVOs
	 * @exception EventException
	 */
	public void createMGSOnhireMvmtBasic(List<MGSMovementMGTVO> mGSMvmtBareMGTVOs ) throws EventException;


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
	public String  manageMGSMovementByCtmBasic(List<CusCtmMovementVO> cusCtmMovementVOs);

	/**
	 *  Chassis Movement editing operation SAVE  [CTM call]<br>
	 *
	 * @param cusCtmMovementVOs List<CusCtmMovementVO>
	 *
	 */
	public void manageMGSMovementByCtmBatchBasic(List<CusCtmMovementVO> cusCtmMovementVOs) ;

	/**
	 *  Bare Movement handling operation SAVE  [CTM call]<br>
	 *
	 * @param flatFileForGateNewVO FlatFileForGateNewVO
	 * @return String[]
	 */
	public String[]  manageMGSMovementBareByGatenewBasic(FlatFileForGateNewVO flatFileForGateNewVO) throws EventException;

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
	 * @param MGSmgstChkINVO mGSmgstChkINVO
	 * @return List<MGSmgstChkINVO>
	 * @throws EventException
	 */
	public List<MGSmgstChkINVO>  searchmgstAtdtVerifyBasic(MGSmgstChkINVO mGSmgstChkINVO) throws EventException;

	/**
	 * Movement History retrieve [EES_CGM_1109] <br>
	 * @param MGSmgstChkINVO mGSmgstChkINVO
	 * @return List<MGSmgstChkINVO>
	 * @throws EventException
	 */
	public List<MGSmgstChkINVO>  searchmgstTpszOnCntrCHkBasic(MGSmgstChkINVO mGSmgstChkINVO) throws EventException;

}