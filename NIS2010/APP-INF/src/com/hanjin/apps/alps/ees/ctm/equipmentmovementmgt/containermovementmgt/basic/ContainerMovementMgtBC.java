/** 
 * Copyright(c) 2009 CyberLogitec
 * @FileName : ContainerMovementMgtBC.java
 * @FileTitle : ContainerMovementMgtBC
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2009.05.08
 * @LastModifier : 우경민
 * @LastVersion : 1.0
 * 2009.05.08 우경민 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2011.07.21 나상보 [CHM-201111948] [CTM] TS화물 VL/VD 추가 Insert 예외처리
 * 2011.10.28 신자영 [CHM-201114074-01] [CTM] VL/VD시 Origin Yard code 입력오류 확인 기능 추가
 * 2013.11.21 최덕우 [CHM-201327563] Master 모듈에서 SCE를 호출하여 Data I/F 할 수 있도록 Return 처리
 * 2014.01.13 최덕우 [CHM-201327924-01] [CTM]  VL/VD Correction by VVD 수정가능 항목 추가
 * 2016.02.17 김상현 [CHM-201640053] 동일 CYC#의 mvmt는 최신 Bkg으로 Update
 * 2015.09.22 김상현 1.1 [CHM-201537939] Latest Bkg 항목 추가 및 Batch 건 data요청(Logic 추가)
 */
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.AutoCreStsListVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.BkgCNTRListVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.BookingQTYVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CorrectionVLVDListVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CrossItemVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CtmCntrMovInfoVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTBookingInfoVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTHistoryListVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchBkgCntrListVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchCLMInfoVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchEDIByContainerVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchEDIByResultRemarkVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchEDIMovementListVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchPreVLVDListVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.EventDateUpdateHistoryParmVO;
import com.hanjin.apps.alps.esd.sce.copdetailreceive.vo.SceActRcvIfVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-Equipmentmovementmgt Business Logic Command Interface<br>
 * - ALPS-Equipmentmovementmgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 우경민
 * @see Ees_ctm_0404EventResponse 참조
 * @see Ees_ctm_0406EventResponse 참조
 * @see Ees_ctm_0409EventResponse 참조
 * @see Ees_ctm_0422EventResponse 참조
 * @see Ees_ctm_0456EventResponse 참조
 * @since J2EE 1.5
 * 2009.4.24
 */
public interface ContainerMovementMgtBC  {

	/**
	 * Container Movement Histoy Retrive Button Event. <br>
	 * 컨테이너 이동정보 조회
	 *
	 * @param MVMTHistoryListVO mvmtHistoryListVO
	 * @return List<MVMTHistoryListVO>
	 * @throws EventException
	 */
	public List<MVMTHistoryListVO> searchMVMTHistoryList(MVMTHistoryListVO mvmtHistoryListVO) throws EventException;

	/**
	 * Container Movement Histoy Retrive Button Event. <br>
	 * Container 이동정보의 Booking 정보 조회
	 *
	 * @param MVMTHistoryListVO mvmtHistoryListVO
	 * @param String cntCd
	 * @return List<MVMTBookingInfoVO>
	 * @throws EventException
	 */
	public List<MVMTBookingInfoVO> searchBookingInfoList(MVMTBookingInfoVO mVMTHistoryListVO, String cntCd) throws EventException;

	/**
	 * Container Movement Histoy Save Button Event. <br>
	 * 컨테이너 이동정보 갱신
	 *
	 * @param CusCtmMovementVO[] ctmMovementVOs
	 * @param MVMTBookingInfoVO[] mvmtBookingInfoVOs
	 * @param SignOnUserAccount account
	 * @return CrossItemVO
	 * @throws EventException
	 */
	public CrossItemVO modifyMVMTHistory(CusCtmMovementVO[] ctmMovementVOs, MVMTBookingInfoVO[] mvmtBookingInfoVOs, SignOnUserAccount account) throws EventException;

	/**
	 * EES_CTM_0404 조회 이벤트<br>
	 * EDI Movement의 List를 조회한다<br>
	 *
	 * @param SearchEDIMovementListVO searchEDIMovementListVO
	 * @return List<SearchEDIMovementListVO>
	 * @throws EventException
	 */
	public List<SearchEDIMovementListVO> searchEDIMovementList(SearchEDIMovementListVO searchEDIMovementListVO) throws EventException;

	/**
	 * EES_CTM_0404 조회 이벤트<br>
	 * EDI Movement List의 Count를 조회한다.<br>
	 *
	 * @param SearchEDIMovementListVO searchEDIMovementListVO
	 * @return String
	 * @throws EventException
	 */
	public String searchEDIMovementCount(SearchEDIMovementListVO searchEDIMovementListVO) throws EventException;

	/**
	 * EES_CTM_0409 조회 이벤트 처리<br>
	 * EDI Container Message 리스트를 조회한다.<br>
	 *
	 * @param SearchEDIByContainerVO searchEDIByContainerVO
	 * @return List<SearchEDIByContainerVO>
	 * @throws EventException
	 */
	public List<SearchEDIByContainerVO> searchEDIByContainer(SearchEDIByContainerVO searchEDIByContainerVO) throws EventException;

	/**
	 * EES_CTM_0409 조회 이벤트 처리<br>
	 * EDI Result Remark 리스트를 조회한다.<br>
	 *
	 * @param SearchEDIByResultRemarkVO searchEDIByResultRemarkVO
	 * @return List<SearchEDIByResultRemarkVO>
	 * @throws EventException
	 */
	public List<SearchEDIByResultRemarkVO> searchEDIByResultRemark(SearchEDIByResultRemarkVO searchEDIByResultRemarkVO) throws EventException;

	/**
	 * EES_CTM_0406<br>
	 * Container번호 조회 후 해당 컨테이너에 예약되어있는 부킹 리스트를 조회한다<br>
	 *
	 * @param SearchBkgCntrListVO searchBkgCntrListVO
	 * @return List<SearchBkgCntrListVO>
	 * @throws EventException
	 */
	public List<SearchBkgCntrListVO> searchBkgCntrList(SearchBkgCntrListVO searchBkgCntrListVO) throws EventException;

	/**
	 * EES_CTM_0406 Retrive<br>
	 * International의 VL/VD 조회에 대한 이벤트 처리<br>
	 *
	 * @param SearchCLMInfoVO searchCLMInfoVo
	 * @return List<SearchCLMInfoVO>
	 * @throws EventException
	 */
	public List<SearchCLMInfoVO> searchVLVDList(SearchCLMInfoVO searchCLMInfoVo) throws EventException;

	/**
	 * 컨테이너 이동 정보 등록<br>
	 * Container Movement Status Insert<br>
	 * @param CusCtmMovementVO[] cusCtmMovementVOs
	 * @param String user_Id
	 * @param String user_Nm
	 * @param String ofc_Cd
	 * @param int endCount
	 * @param boolean nBkgNoFlg
	 * @return CrossItemVO
	 * @throws EventException
	 */
	public CrossItemVO manageStsOperation (CusCtmMovementVO[] cusCtmMovementVOs, String user_Id, String user_Nm, String ofc_Cd, int endCount, boolean nBkgNoFlg) throws EventException;

	/**
	 * EES_CTM_0406: ETA/ETD 조회<br>
	 * VSL/YARD가 입력되어있을 때 ETA/ETD Time을 조회한다<br>
	 *
	 * @param SearchCLMInfoVO searchCLMInfoVO
	 * @return String
	 * @throws EventException
	 */
	public String getEtaEtdTime (SearchCLMInfoVO searchCLMInfoVO) throws EventException;

	/**
	 * VL Pre Check에대한 유효성 검사<br>
	 * VL저장 전 Pre Check버튼에 대한 이벤트 처리<br>
	 *
	 * @param CtmCntrMovInfoVO[] ctmCntrMovInfoVOs
	 * @param SignOnUserAccount account
	 * @return String[][]
	 * @throws EventException
	 */
	public String[][] checkPREVLVD(CtmCntrMovInfoVO[] ctmCntrMovInfoVOs, SignOnUserAccount account) throws EventException;

	/**
	 * EES_CTM_0406 : 부킹번호에 딸려있는 부킹 컨테이너의 타입 사이즈별 갯수 리턴<br>
	 * 부킹번호에 대한 POPUP 조회 이벤트  <br>
	 *
	 * @param BookingQTYVO bookingQTYVO
	 * @return List<BookingQTYVO>
	 * @throws EventException
	 */
	public List<BookingQTYVO> searchBookingQTY(BookingQTYVO bookingQTYVO) throws EventException;

	/**
	 * 부킹번호에 딸려있는 부킹 컨테이너의 타입 사이즈별 갯수 리턴<br>
	 *
	 * @param BkgCNTRListVO bkgCNTRListVO
	 * @return List<BkgCNTRListVO>
	 * @throws EventException
	 */
	public List<BkgCNTRListVO> searchCNTRList(BkgCNTRListVO bkgCNTRListVO) throws EventException;

	/**
	 * VL/VD 예약이벤트 처리<br>
	 * CTM_MVMT_RSV 테이블에 예약 정보를 등록한다<br>
	 *
	 * @param CtmCntrMovInfoVO[] ctmCntrMovInfoVOs
	 * @param account SignOnUserAccount
	 * @throws EventException
	 */
	public void resMovement(CtmCntrMovInfoVO[] ctmCntrMovInfoVOs, SignOnUserAccount account) throws EventException;

	/**
	 * VL Pre Check에대한 유효성 검사<br>
	 * 컨테이너 변경시 (VL/VD) 자동 조회<br>
	 *
	 * @param CtmCntrMovInfoVO ctmCntrMovInfoVO
	 * @return String
	 * @throws EventException
	 */
	public String checkVLVDPreChk(CtmCntrMovInfoVO ctmCntrMovInfoVO) throws EventException ;
	
	/**
	 * VVD, YARD 변경시 해당 yard와 VVD간의 적합성 여부 자동조회<br>
	 *
	 * @param CtmCntrMovInfoVO ctmCntrMovInfoVO
	 * @return int
	 * @throws EventException
	 */
	public int checkVVDYardCd(CtmCntrMovInfoVO ctmCntrMovInfoVO) throws EventException ;


	/**
	 * Domestic Movement 에서 신규 입력되는 Movement 정보 입력<br>
	 *
	 * @param CusCtmMovementVO cusCtmMovementVO
	 * @param String cntCd
	 * @return CrossItemVO
	 * @throws EventException
	 */
	public CrossItemVO manageDomesticMVMT(CusCtmMovementVO cusCtmMovementVO, String cntCd) throws EventException;

	/**
	 * CTM 공통.. 외부 모듈 호출 및 테스트<br>
	 *
	 * @param CrossItemVO crossItemVO
	 * @param boolean modifyCntrOpResult
	 * @return String
	 * @throws EventException
	 */
	public String updateEtcModule (CrossItemVO crossItemVO, boolean modifyCntrOpResult) throws EventException;

	/**
	 * 0422 에서 넘겨받은 Movement Update<br>
	 * 컨테이너 이동정보 수정. 대상 컨테이너에 대한 이력 수정<br>
	 *
	 * @param CusCtmMovementVO cusCtmMovementVO
	 * @throws EventException
	 */
	public void updateUpdateMvmt (CusCtmMovementVO cusCtmMovementVO) throws EventException;

	/**
	 * 0422 에서 넘겨받은 Movement Update<br>
	 * 컨테이너이동 정보 등록<br>
	 *
	 * @param CusCtmMovementVO[] cusCtmMovementVOs
	 * @throws EventException
	 */
	public void updateAddMvmt (CusCtmMovementVO[] cusCtmMovementVOs) throws EventException;

	/**
	 * [MST에서 호출] Container Movement Creation / Delete<br>
	 * Container Movement Creation / Deletebr>
	 * 
	 * @param CusCtmMovementVO cusCtmMovementVO
	 * @param SignOnUserAccount account
	 * @return CrossItemVO
	 * @throws EventException
	 */
	public CrossItemVO manageCntrInfoFromMst(CusCtmMovementVO cusCtmMovementVO, SignOnUserAccount account) throws EventException;

	/**
	 * EES_CTM_0456 : PreVLVD List를 Search합니다.<br>
	 *
	 * @param SearchPreVLVDListVO searchPreVLVDListVO
	 * @return List<SearchPreVLVDListVO>
	 * @throws EventException
	 */
	public List<SearchPreVLVDListVO> searchPreVLVDList(SearchPreVLVDListVO searchPreVLVDListVO) throws EventException;

	/**
	 * EES_CTM_0456 : PreVLVD List를 updade/delete합니다.<br>
	 *
	 * @param SearchPreVLVDListVO[] searchPreVLVDListVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void managePreVLVD(SearchPreVLVDListVO[] searchPreVLVDListVOs, SignOnUserAccount account) throws EventException;

	/**
	 * EAI 전송
	 *
	 * @param CusCtmMovementVO cusCtmMovementVO
	 * @param String ediSts
	 * @param String lstrmCd
	 * @return String
	 * @throws EventException
	 */
	public String sendEdiToKor(CusCtmMovementVO cusCtmMovementVO, String ediSts, String lstrmCd) throws EventException;

	/**
	 * BKG
	 * CTM_MVMT_IRR의 STL FLG Update.<br>
	 *
	 * @param String cntrNo
	 * @param String bkgNo
	 * @throws EventException
	 */
	public void updateCtmMvmtIrrFromBkg(String cntrNo, String bkgNo) throws EventException;

	/**
	 * 신조장비의 MT상태 처리<br>
	 * Container Movement  MT Status Creation<br>
	 *
	 * @param CusCtmMovementVO cusCtmMovementVO
	 * @param SignOnUserAccount account
	 * @return CusCtmMovementVO
	 * @throws EventException
	 */
	public CusCtmMovementVO insCntrInfoFromMtSts(CusCtmMovementVO cusCtmMovementVO, SignOnUserAccount account) throws EventException;

	/**
	 * EES_CTM_0404<br>
	 * Container No와 EDI키값으로 Bkg list를 가져오기<br>
	 *
	 * @param SearchEDIMovementListVO searchEDIMovementListVO
	 * @return String[]
	 * @throws EventException
	 */
	public String[] getBkgNoByEDICntrInfo(SearchEDIMovementListVO searchEDIMovementListVO) throws EventException;

	/**
	 * VL/VD Correction 정보를 조회한다.<br>
	 *
	 * @param CorrectionVLVDListVO correctionVLVDListVO
	 * @return List<CorrectionVLVDListVO>
	 * @throws EventException
	 */
	public List<CorrectionVLVDListVO> searchCorrectionVLVDListByVVD(CorrectionVLVDListVO correctionVLVDListVO) throws EventException;

	/**
	 * BKG
	 * PRE VL UPDATE.<br>
	 *
	 * @param CusCtmMovementVO ctmMovementVO
	 * @throws EventException
	 */
	public void modifyMovementFromBkgForPreVL(CusCtmMovementVO ctmMovementVO) throws EventException;

	/**
	 * 동일한 Container No, CycNo를 가지는 모든 Booking List를 반환한다.
	 *
	 * @param String cntrNo
	 * @param String cycNo
	 * @param String cnmvYr
	 * @return String[]
	 * @throws EventException
	 */
	public String[] getBookingListByCycle(String cntrNo, String cycNo, String cnmvYr) throws EventException;

	/**
	 * CGM
	 * XX Create.<br>
	 *
	 * @param CusCtmMovementVO ctmMovementVO
	 * @return int
	 * @throws EventException
	 */
	public int modifyMovementFromCgmForCreXX(CusCtmMovementVO ctmMovementVO) throws EventException;

	/**
	 * Event Date가 변경된 Movement 내역을 저장.<br>
	 *
	 * @param AutoCreStsListVO[] autoCreStsListVOs
	 * @param account SignOnUserAccount
	 * @return List<SceActRcvIfVO>
	 * @throws EventException
	 */
	public List<SceActRcvIfVO> manageAutoCreSts(AutoCreStsListVO[] autoCreStsListVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * VVD의 POL / POD LCC를 조회한다<br>
	 *
	 * @param String bkgNo
	 * @param String cntrId
	 * @return String[]
	 */
	public String[] searchPolPodLccCd(String bkgNo, String cntrId) throws EventException; 
	
	/**
	 * Modified event date history Inquiry 리스트 조회<br>
	 *
	 * @param EventDateUpdateHistoryParmVO eventDateUpdateHistoryParmVO
	 * @return List<EventDateUpdateHistoryParmVO>
	 * @throws EventException
	 */
	public List<EventDateUpdateHistoryParmVO> searchEventDateUpdateHistory(EventDateUpdateHistoryParmVO eventDateUpdateHistoryParmVO) throws EventException;
	
	/**
	 * VL/VD Yard Cd 정보를 조회한다.<br>
	 *
	 * @param CorrectionVLVDListVO correctionVLVDListVO
	 * @return List<CorrectionVLVDListVO>
	 * @throws EventException
	 */
	public List<CorrectionVLVDListVO> searchVLVDYardCode(CorrectionVLVDListVO correctionVLVDListVO) throws EventException;

	/**
	 * Last BKG_NO update 처리
	 * @param lastBkgNo
	 * @param lastBlNo
	 * @param cusCtmMovementVO
	 * @throws EventException
	 */
	public void modifyLastBkgNo(String lastBkgNo, String lastBlNo, CusCtmMovementVO cusCtmMovementVO) throws EventException;

	/**
	 * VGM data를 업데이트 해야 하는지 아닌지 check.
	 * @param cusCtmMovementVO
	 * @return String
	 * @throws EventException
	 */
	public String checkVgmData(CusCtmMovementVO cusCtmMovementVO) throws EventException;

	/**
	 * VGM data update 처리 로직
	 * @param cusCtmMovementVOs
	 * @throws EventException
	 */
	public void updateVgmData(CusCtmMovementVO cusCtmMovementVOs[]) throws EventException;

	/**
	 * 조회된 마지막 시간을 저장해 놓기 위해 system date 조회.
	 * @return String
	 * @throws EventException
	 */
	public String searchSystemDate() throws EventException;

	/**
	 * 마지막 retrieve 이후에 수정된 데이터가 있는데 확인
	 * @param cntrNo
	 * @param lastRetrieveDate
	 * @return int
	 * @throws EventException
	 */
	public int searchModifiedDataCount(String cntrNo, String lastRetrieveDate) throws EventException;
	
	/**
	 * OP, VL이 삭제로 booking 정보를 초기화 시 해당 BKG_NO가 정상적으로 입력된 이전 movement가 존재하는지 조회
	 * @param bkgNo
	 * @param cntrNo
	 * @return int
	 * @throws EventException
	 */
	public int searchSamBkgPriorMvmtKnt(String bkgNo, String cntrNo) throws EventException;
	
	/**
	 * BKG 에 CNTR 이 Attach 안 된 상태에서 OP 가 들어온 경우 MVMT 상태는 TN 이 됩니다.
	 * 이때, BKG 에 CNTR 가 Attach 될 경우, TN 상태를 OP 로 변경해 줌 ( BKG 에서만 사용하는 메소드임 )
	 * @param String bkgNo
	 * @param String cntrNo
	 * @param String usrId
	 * @return CrossItemVO
	 * @throws EventException
	 */	
	public CrossItemVO modifyMvmtStsByAtchCntrToBkg(String bkgNo, String cntrNo, String usrId) throws EventException;
	
}
