/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerMovementMgtBC.java
*@FileTitle : ContainerMovementMgtBC
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.basic;

import java.util.List;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.AutoCreStsListVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.BkgCNTRListVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.BookingQTYVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CorrectionVLVDListVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CrossItemVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CtmCntrMovInfoVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTBookingInfoVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTHistoryListVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchBkgCntrListVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchCLMInfoVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchEDIByContainerVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchEDIByResultRemarkVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchEDIMovementListVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchPreVLVDListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-Equipmentmovementmgt Business Logic Command Interface
 *
 * @author 
 * @see Ees_ctm_0404EventResponse reference
 * @see Ees_ctm_0406EventResponse reference
 * @see Ees_ctm_0409EventResponse reference
 * @see Ees_ctm_0422EventResponse reference
 * @see Ees_ctm_0456EventResponse reference
 * @since J2EE 1.5
 * 2009.4.24
 */
public interface ContainerMovementMgtBC {

	/**
	 * Container Movement History Retrieve Button Event. <br>
	 * retrieving container movement information
	 *
	 * @param MVMTHistoryListVO mvmtHistoryListVO
	 * @return List<MVMTHistoryListVO>
	 * @throws EventException
	 */
	public List<MVMTHistoryListVO> searchMVMTHistoryList(MVMTHistoryListVO mvmtHistoryListVO) throws EventException;

	/**
	 * Container Movement History Retrieve Button Event
	 * retrieving booking information of Container movement information
	 *
	 * @param MVMTHistoryListVO mvmtHistoryListVO
	 * @param String cntCd
	 * @return List<MVMTBookingInfoVO>
	 * @throws EventException
	 */
	public List<MVMTBookingInfoVO> searchBookingInfoList(MVMTBookingInfoVO mVMTHistoryListVO, String cntCd) throws EventException;

	/**
	 * Container Movement History Save Button Event
	 * updating container movement information
	 *
	 * @param CusCtmMovementVO[] ctmMovementVOs
	 * @param MVMTBookingInfoVO[] mvmtBookingInfoVOs
	 * @param SignOnUserAccount account
	 * @return CrossItemVO
	 * @throws EventException
	 */
	public CrossItemVO modifyMVMTHistory(CusCtmMovementVO[] ctmMovementVOs, MVMTBookingInfoVO[] mvmtBookingInfoVOs, SignOnUserAccount account) throws EventException;

	/**
	 * updating container status information
	 *
	 * @param CusCtmMovementVO[] ctmMovementVOs
	 * @param SignOnUserAccount account
	 * @return CrossItemVO
	 * @throws EventException
	 */
	public CrossItemVO modifyCNTRStatus(CusCtmMovementVO[] ctmMovementVOs, SignOnUserAccount account) throws EventException;

	/**
	 * DMG History Update
	 *
	 * @param CrossItemVO crossItemVO
	 * @param SignOnUserAccount account
	 * @return CrossItemVO
	 * @exception EventException
	 */
	public CrossItemVO modifyDMGHistory(CrossItemVO crossItemVO, SignOnUserAccount account) throws EventException;

	/**
	 * EES_CTM_0404 retrieve event
	 * retrieving EDI Movement List
	 *
	 * @param SearchEDIMovementListVO searchEDIMovementListVO
	 * @return List<SearchEDIMovementListVO>
	 * @throws EventException
	 */
	public List<SearchEDIMovementListVO> searchEDIMovementList(SearchEDIMovementListVO searchEDIMovementListVO) throws EventException;

	/**
	 * EES_CTM_0404 retrieve event
	 * retrieving EDI Movement List Count
	 *
	 * @param SearchEDIMovementListVO searchEDIMovementListVO
	 * @return String
	 * @throws EventException
	 */
	public String searchEDIMovementCount(SearchEDIMovementListVO searchEDIMovementListVO) throws EventException;

	/**
	 * handling EES_CTM_0409 retrieve event
	 * retrieving EDI Container Message List
	 *
	 * @param SearchEDIByContainerVO searchEDIByContainerVO
	 * @return List<SearchEDIByContainerVO>
	 * @throws EventException
	 */
	public List<SearchEDIByContainerVO> searchEDIByContainer(SearchEDIByContainerVO searchEDIByContainerVO) throws EventException;

	/**
	 * handling EES_CTM_0409 retrieve event
	 * retrieving EDI Result Remark List
	 *
	 * @param SearchEDIByResultRemarkVO searchEDIByResultRemarkVO
	 * @return List<SearchEDIByResultRemarkVO>
	 * @throws EventException
	 */
	public List<SearchEDIByResultRemarkVO> searchEDIByResultRemark(SearchEDIByResultRemarkVO searchEDIByResultRemarkVO) throws EventException;

	/**
	 * EES_CTM_0406<br>
	 * retrieving booking list booked for inputed container after retrieving container no
	 *
	 * @param SearchBkgCntrListVO searchBkgCntrListVO
	 * @return List<SearchBkgCntrListVO>
	 * @throws EventException
	 */
	public List<SearchBkgCntrListVO> searchBkgCntrList(SearchBkgCntrListVO searchBkgCntrListVO) throws EventException;

	/**
	 * EES_CTM_0406 Retrieve
	 * handling event about retrieving International VL/VD 
	 *
	 * @param SearchCLMInfoVO searchCLMInfoVo
	 * @param String oscaBkgFlg
	 * @return List<SearchCLMInfoVO>
	 * @throws EventException
	 */
	public List<SearchCLMInfoVO> searchVLVDList(SearchCLMInfoVO searchCLMInfoVo, String oscaBkgFlg) throws EventException;

	/**
	 * registering container movement information
	 * Container Movement Status Insert
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
	 * EES_CTM_0406: retrieving ETA/ETD 
	 * retrieving ETA/ETD in case VSL/YARD entered
	 *
	 * @param SearchCLMInfoVO searchCLMInfoVO
	 * @return String
	 * @throws EventException
	 */
	public String getEtaEtdTime (SearchCLMInfoVO searchCLMInfoVO) throws EventException;

	/** getVvd
	 * 
	 * @param searchCLMInfoVO
	 * @return
	 * @throws EventException
	 */
	public String getVvd (SearchCLMInfoVO searchCLMInfoVO) throws EventException;

	/**
	 * validating VL Pre Check
	 * handling event for Pre Check button before saving VL
	 *
	 * @param CtmCntrMovInfoVO[] ctmCntrMovInfoVOs
	 * @param SignOnUserAccount account
	 * @param String oscaBkgFlg
	 * @return String[][]
	 * @throws EventException
	 */
	public String[][] checkPREVLVD(CtmCntrMovInfoVO[] ctmCntrMovInfoVOs, SignOnUserAccount account, String oscaBkgFlg) throws EventException;

	/**
	 * EES_CTM_0406 : returning booking container's count for type/size
	 *
	 * @param BookingQTYVO bookingQTYVO
	 * @return List<BookingQTYVO>
	 * @throws EventException
	 */
	public List<BookingQTYVO> searchBookingQTY(BookingQTYVO bookingQTYVO) throws EventException;

	/**
	 * returning booking container's count for type/size
	 *
	 * @param BkgCNTRListVO bkgCNTRListVO
	 * @return List<BkgCNTRListVO>
	 * @throws EventException
	 */
	public List<BkgCNTRListVO> searchCNTRList(BkgCNTRListVO bkgCNTRListVO) throws EventException;

	/**
	 * handling event for VL/VD 
	 * registering booking information in CTM_MVMT_RSV table
	 *
	 * @param CtmCntrMovInfoVO[] ctmCntrMovInfoVOs
	 * @param account SignOnUserAccount
	 * @throws EventException
	 */
	public void resMovement(CtmCntrMovInfoVO[] ctmCntrMovInfoVOs, SignOnUserAccount account) throws EventException;

	/**
	 * validating VL Pre Check
	 * auto retrieving in case of changing containers
	 *
	 * @param CtmCntrMovInfoVO ctmCntrMovInfoVO
	 * @param String oscaBkgFlg
	 * @return String
	 * @throws EventException
	 */
	public String checkVLVDPreChk(CtmCntrMovInfoVO ctmCntrMovInfoVO, String oscaBkgFlg) throws EventException ;

	/**
	 * validating VL Pre Check
	 * auto retrieving in case of changing containers
	 *
	 * @param SearchCLMInfoVO searchCLMInfoVO
	 * @return String
	 * @throws EventException
	 */
	public String checkVVDPreChkOnVslSkd(SearchCLMInfoVO searchCLMInfoVO) throws EventException ;
	
	/**
	 * CTM common for calling other modules
	 *
	 * @param CrossItemVO crossItemVO
	 * @param boolean modifyCntrOpResult
	 * @return String
	 * @throws EventException
	 */
	public String updateEtcModule (CrossItemVO crossItemVO, boolean modifyCntrOpResult) throws EventException;

	/**
	 * updating movement information form 0422 
	 * updating movement information. modifying container's history<br>
	 *
	 * @param CusCtmMovementVO cusCtmMovementVO
	 * @throws EventException
	 */
	public void updateUpdateMvmt (CusCtmMovementVO cusCtmMovementVO) throws EventException;

	/**
	 * updating movement information form 0422 
	 * registering container's movement information
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
	 * @return CusCtmMovementVO
	 * @throws EventException
	 */
	public CusCtmMovementVO manageCntrInfoFromMst(CusCtmMovementVO cusCtmMovementVO, SignOnUserAccount account) throws EventException;

	/**
	 * EES_CTM_0456 : searching PreVLVD List
	 *
	 * @param SearchPreVLVDListVO searchPreVLVDListVO
	 * @return List<SearchPreVLVDListVO>
	 * @throws EventException
	 */
	public List<SearchPreVLVDListVO> searchPreVLVDList(SearchPreVLVDListVO searchPreVLVDListVO) throws EventException;

	/**
	 * EES_CTM_0456 : updating/deleting PreVLVD List
	 *
	 * @param SearchPreVLVDListVO[] searchPreVLVDListVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void managePreVLVD(SearchPreVLVDListVO[] searchPreVLVDListVOs, SignOnUserAccount account) throws EventException;

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
	 * handling MT status for new EQ
	 * Container Movement  MT Status Creation
	 *
	 * @param CusCtmMovementVO cusCtmMovementVO
	 * @param SignOnUserAccount account
	 * @return CusCtmMovementVO
	 * @throws EventException
	 */
	public CusCtmMovementVO insCntrInfoFromMtSts(CusCtmMovementVO cusCtmMovementVO, SignOnUserAccount account) throws EventException;

	/**
	 * EES_CTM_0404<br>
	 * getting BKG list with Container No and  EDI Key value
	 *
	 * @param SearchEDIMovementListVO searchEDIMovementListVO
	 * @return String[]
	 * @throws EventException
	 */
	public String[] getBkgNoByEDICntrInfo(SearchEDIMovementListVO searchEDIMovementListVO) throws EventException;

	/**
	 * retrieving VL/VD Correction information
	 *
	 * @param CorrectionVLVDListVO correctionVLVDListVO
	 * @return List<CorrectionVLVDListVO>
	 * @throws EventException
	 */
	public List<CorrectionVLVDListVO> searchCorrectionVLVDListByVVD(CorrectionVLVDListVO correctionVLVDListVO) throws EventException;

	/**
	 * BKG
	 * PRE VL UPDATE
	 *
	 * @param CusCtmMovementVO ctmMovementVO
	 * @throws EventException
	 */
	public void modifyMovementFromBkgForPreVL(CusCtmMovementVO ctmMovementVO) throws EventException;

	/**
	 * returning booking list having same Container No, CycNo
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
	 * saving Movement history that Event Date changed
	 *
	 * @param AutoCreStsListVO[] autoCreStsListVOs
	 * @param account SignOnUserAccount
	 * @return List<AutoCreStsListVO>
	 * @throws EventException
	 */
	public List<AutoCreStsListVO> manageAutoCreSts(AutoCreStsListVO[] autoCreStsListVOs,SignOnUserAccount account) throws EventException;
	
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
	 * Save(Deleted) from Update of EDI Message(EES_CTM_0404)<br>
	 * UPDATE CTM_MVMT_EDI_MSG & INSERT CTM_EDI_RSLT_RMK<br>
	 *
	 * @param SearchEDIMovementListVO searchEDIMovementListVO
	 * @throws EventException
	 */
	public void updateResultAsDelForMvmtEdiMsg(SearchEDIMovementListVO searchEDIMovementListVO) throws EventException;
	
	/**
	 * Oscar Bkg No Update.
	 *
	 * @param CusCtmMovementVO cusCtmMovementVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void updateOscarContainerMove(CusCtmMovementVO cusCtmMovementVO, SignOnUserAccount account) throws EventException;

	/** searchContiCode
	 * 
	 * @param locCd
	 * @return
	 * @throws EventException
	 */
	public String searchContiCode(String locCd) throws EventException;

	/** searchDgCargo
	 * 
	 * @param bkgNo
	 * @return
	 * @throws EventException
	 */
	public String searchDgCargo(String bkgNo) throws EventException;
	
	/** searchRcvSnd
	 * 
	 * @param orgYdCd
	 * @return String[]
	 * @throws EventException
	 */
	public String[] searchRcvSnd(String orgYdCd) throws EventException;
	
	/**
	 * EES_CTM_0406 Retrieve
	 * handling event about retrieving International VL/VD 
	 *
	 * @param SearchCLMInfoVO searchCLMInfoVo
	 * @return String
	 * @throws EventException
	 */
	public String checkCtmBkgVvd(SearchCLMInfoVO searchCLMInfoVO) throws EventException;
	
	/**
	 * EES_CTM_0406 checkPPreMVMTSts
	 *
	 * @param SearchCLMInfoVO searchCLMInfoVo
	 * @return String
	 * @throws EventException
	 */
	public String checkPPreMVMTSts(SearchCLMInfoVO searchCLMInfoVO) throws EventException;

}