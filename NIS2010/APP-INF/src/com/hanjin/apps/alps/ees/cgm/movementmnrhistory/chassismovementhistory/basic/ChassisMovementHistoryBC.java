/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMovementHistoryBC.java
*@FileTitle : test
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.06.03 최민회
* 1.0 Creation
* --------------------------------------------------------
* History
* 2012.01.13 김상수 [CHM-201215565-01] ALPS MNR-Disposal-SLD Management-> SLD Cancellation 보완 요청
*                                      - Disposal Sold Cancelation 화면에서 M.G.Set과 Chassis도 SLD Cancel 가능하도록 CGM연계로직 추가
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSMovementMGTVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSMvmtBareMGTVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSMvmtGroupVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSMvmtINVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSMvmtMGTVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSmgstChkINVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.vo.ShipCHSMvmtMGTVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.FlatFileForGateNewVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTBookingInfoVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTHistoryListVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.IFMnrFlagVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Movementmnrhistory Business Logic Command Interface<br>
 * - ALPS-Movementmnrhistory에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author CHOI MIN HOI
 * @see TestEventResponse 참조
 * @since J2EE 1.6
 */

public interface ChassisMovementHistoryBC {

	/**
	 *  장비 Lost 관련 'XX' movement 를 입력한다.   [EES_CGM_1017,EES_CGM_1009] <br>
	 *
	 * @param cHSMovementMGTVOs List<CHSMovementMGTVO>
	 * @exception EventException
	 */
	public void createCHSXXMvmtBasic(List<CHSMovementMGTVO> cHSMovementMGTVOs) throws EventException;

	/**
	 *  장비 Found 관련된 'BI' movement 를 입력한다   [EES_CGM_1017,EES_CGM_1018] <br>
	 *
	 * @param cHSMovementMGTVOs List<CHSMovementMGTVO>
	 * @exception EventException
	 */
	public void createCHSFoundMvmtBasic(List<CHSMovementMGTVO> cHSMovementMGTVOs) throws EventException;

	/**
	 *  장비 movement 정보를 수정 한다   [EES_CGM_1016] <br>
	 *
	 * @param cHSMovementMGTVOs List<CHSMovementMGTVO>
	 * @exception EventException
	 */
	 public void  modifyChsMoveByStatusBasic(List<CHSMovementMGTVO> cHSMovementMGTVOs) throws EventException;

	/**
	 *  장비 movement 정보를 삭제한다   [EES_CGM_1016] <br>
	 *
	 * @param cHSMovementMGTVOs List<CHSMovementMGTVO>
	 * @exception EventException
	 */
    public void removeChsMoveByStatusBasic(List<CHSMovementMGTVO> cHSMovementMGTVOs) throws EventException;

	/**
	 *  장비 movement 정보를 삭제한다   [EES_CGM_1018] <br>
	 *
	 * @param cHSMovementMGTVOs List<CHSMovementMGTVO>
	 * @exception EventException
	 */
    public void removeChsMvmtFoundAutoBasic(List<CHSMovementMGTVO> cHSMovementMGTVOs) throws EventException;

	/**
	 *  개별 Chassis 별 Movement History 정보 조회   [EES_CGM_1104] <br>
	 *
	 * @param chsMvmtINVO CHSMvmtINVO
	 * @return  List<CHSMvmtMGTVO>
	 * @exception EventException
	 */
	public List<CHSMvmtMGTVO> searchCHSMovementListBasic(CHSMvmtINVO chsMvmtINVO) throws EventException;

	/**
	 *  chassismovementhistory 대한 조회  [EES_CGM_1105] <br>
	 *
	 * @param cHSMvmtINVO CHSMvmtINVO
	 * @return  CHSMvmtGroupVO
	 * @exception EventException
	 */
	public CHSMvmtGroupVO searchCHSMovementHistoryBasic(CHSMvmtINVO cHSMvmtINVO) throws EventException;

	/**
	 *  chassismovementhistory 대한 조회  [EES_CGM_1108] <br>
	 *
	 * @param cHSMvmtINVO CHSMvmtINVO
	 * @return  List<CHSMvmtBareMGTVO>
	 * @exception EventException
	 */
	public List<CHSMvmtBareMGTVO> searchCHSBareMvmtBasic(CHSMvmtINVO cHSMvmtINVO) throws EventException;


	/**
	 *  chassismovementhistory 대한 verify  [EES_CGM_1108] <br>
	 *
	 * @param cHSMvmtBareMGTVOs CHSMvmtBareMGTVO[]
	 * @return  List<CHSMvmtBareMGTVO>
	 * @exception EventException
	 */
	public List<CHSMvmtBareMGTVO> verifyCHSBareMvmtBasic(CHSMvmtBareMGTVO[] cHSMvmtBareMGTVOs) throws EventException;

	/**
	 *  Eq bare movement 를 수정/삭제한다.  [EES_CGM_1108] <br>
	 *
	 * @param cHSMvmtBareMGTVOs CHSMvmtBareMGTVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageCHSBareMvmtBasic(CHSMvmtBareMGTVO[] cHSMvmtBareMGTVOs, SignOnUserAccount account) throws EventException;

	/**
	 *  EEq bare movement 를 입력.  [EES_CGM_1108] <br>
	 *
	 * @param cHSMvmtBareMGTVOs CHSMvmtBareMGTVO[]
     * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createCHSBareMvmtBasic(CHSMvmtBareMGTVO[] cHSMvmtBareMGTVOs, SignOnUserAccount account) throws EventException;

	/**
	 *  장비 ON-hire 관련된 'MT' movement  <br>
	 *
	 * @param cHSMvmtBareMGTVOs List<CHSMovementMGTVO>
	 * @exception EventException
	 */
	public void createCHSOnhireMvmtBasic(List<CHSMovementMGTVO> cHSMvmtBareMGTVOs ) throws EventException;


	/**
	 *  MNR 으로부터 호출받아 장비의 Retirement 관련 처리. SAVE  [MNR 호출]<br>
	 *
	 * @param IFMnrFlagVOs List<IFMnrFlagVO>
	 * @exception EventException
	 */
	public void createMNRStatusBasic(List<IFMnrFlagVO> IFMnrFlagVOs) throws EventException;

	/**
	 *  Chassis Movement 를 수정하는 오퍼레이션 SAVE  [CTM 호출]<br>
	 *
	 * @param cusCtmMovementVOs List<CusCtmMovementVO>
	 * @return int
	 */
	public String  manageCHSMovementByCtmBasic(List<CusCtmMovementVO> cusCtmMovementVOs);

	/**
	 *  Chassis Movement 를 수정하는 오퍼레이션 SAVE  [CTM 호출]<br>
	 *
	 * @param cusCtmMovementVOs List<CusCtmMovementVO>
	 *
	 */
	public void manageCHSMovementByCtmBatchBasic(List<CusCtmMovementVO> cusCtmMovementVOs) ;

	/**
	 *  Bare Movement 처리 오퍼레이션 SAVE  [CTM 호출]<br>
	 *
	 * @param flatFileForGateNewVO FlatFileForGateNewVO
	 * @return String[]
	 */
	public String[]  manageCHSMovementBareByGatenewBasic(FlatFileForGateNewVO flatFileForGateNewVO) throws EventException;

	/**
	 *  배치에서 ctm 모둘내 호출 데이터 가져오기
	 *
	 * @return List<CusCtmMovementVO>
	 */
	public List<CusCtmMovementVO> searchCtmMvmtSourceBasic() throws EventException;

	/**
	 *  VVD History 가져오기 조회  [EES_CGM_1109] <br>
	 * @param mVMTBookingInfoVO MVMTBookingInfoVO
	 * @param account SignOnUserAccount
	 * @return List<MVMTBookingInfoVO>
	 * @throws EventException
	 */
	public List<MVMTBookingInfoVO> searchBookingInfoList(MVMTBookingInfoVO mVMTBookingInfoVO, SignOnUserAccount account) throws EventException;

	/**
	 * Movement History 조회 [EES_CGM_1109] <br>
	 * @param mVMTHistoryListVO MVMTHistoryListVO
	 * @return List<MVMTHistoryListVO>
	 * @throws EventException
	 */
	public List<MVMTHistoryListVO>  searchMVMTHistoryList(MVMTHistoryListVO mVMTHistoryListVO) throws EventException;

	/**
	 * Movement History 조회 [EES_CGM_1109] <br>
	 * @param cHSmgstChkINVO CHSmgstChkINVO
	 * @return List<CHSmgstChkINVO>
	 * @throws EventException
	 */
	public List<CHSmgstChkINVO>  searchchssAtdtVerifyBasic(CHSmgstChkINVO cHSmgstChkINVO) throws EventException;

	/**
	 * Movement History 조회 [EES_CGM_1109] <br>
	 * @param cHSmgstChkINVO CHSmgstChkINVO
	 * @return List<CHSmgstChkINVO>
	 * @throws EventException
	 */
	public List<CHSmgstChkINVO>  searchchssTpszOnCntrCHkBasic(CHSmgstChkINVO cHSmgstChkINVO) throws EventException;

	/**
	 * Shipper's Chassis의 Movement 관리현황을 조회합니다. [EES_CGM_1150] <br>
	 *
	 * @param ShipCHSMvmtMGTVO shipCHSMvmtMGTVO
	 * @return  List<ShipCHSMvmtMGTVO>
	 * @exception EventException
	 */
	public List<ShipCHSMvmtMGTVO> searchShipChsMovementListBasic(ShipCHSMvmtMGTVO shipCHSMvmtMGTVO) throws EventException;

}