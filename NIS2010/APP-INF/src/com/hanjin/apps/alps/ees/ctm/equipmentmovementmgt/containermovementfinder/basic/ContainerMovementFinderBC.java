/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerMovementFinderBC.java
*@FileTitle : VL/VD EDI Test Result
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.05.11 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.ConCBookingVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.CtmCCLMVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.CtmMvmtIrrVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.CtmVvdHistoryVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchCorrectionHistoryVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchDeletedMVMTListVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchEdiMsgVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchEmptyBookingListVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementHistoryMonitorListVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByBkgInfoVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByCntrInfoVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByCntrTpszCdVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByContainerVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByMultiContainerVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListBySplitBkgNoForMultiComboVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByVvdForMultiComboVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchVermasListVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.searchMovementHistoryVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchEDIMovementListVO;
import com.hanjin.framework.core.layer.event.EventException;


/**
 * ALPS-Equipmentmovementmgt Business Logic Command Interface<br>
 * - ALPS-Equipmentmovementmgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM, Sang-Soo
 * @see Ees_ctm_0412EventResponse 참조
 * @see Ees_ctm_0415EventResponse 참조
 * @see Ees_ctm_0405EventResponse 참조
 * @see Ees_ctm_0408EventResponse 참조
 * @see Ees_ctm_0409EventResponse 참조
 * @see Ees_ctm_0443EventResponse 참조
 * @see Ees_ctm_0413EventResponse 참조
 * @see Ees_ctm_0419EventResponse 참조
 * @see Ees_ctm_0436EventResponse 참조
 * @since J2EE 1.4
 */
public interface ContainerMovementFinderBC {

	/**
	 * EES_CTM_0412 조회 이벤트 처리<br>
	 * BKG container update Irr 리스트 조회<br>
	 *
	 * @param CtmMvmtIrrVO ctmMvmtIrrVO
	 * @return List<CtmMvmtIrrVO>
	 * @exception EventException
	 */
	public List<CtmMvmtIrrVO> searchIrregularContainerList(CtmMvmtIrrVO ctmMvmtIrrVO) throws EventException;

	/**
	 * EES_CTM_0415 조회 이벤트 처리<br>
	 * 삭제된 Movement List 조회<br>
	 *
	 * @param SearchDeletedMVMTListVO searchDeletedMVMTListVO
	 * @return List<SearchDeletedMVMTListVO>
	 * @exception EventException
	 */
	public List<SearchDeletedMVMTListVO> searchDeletedMVMTList(SearchDeletedMVMTListVO searchDeletedMVMTListVO) throws EventException;

	/**
	 * EES_CTM_0405 조회 이벤트 처리<br>
	 * Empty VL List without BKG 리스트 조회<br>
	 *
	 * @param SearchEmptyBookingListVO searchEmptyBookingListVO
	 * @return List<SearchEmptyBookingListVO>
	 * @exception EventException
	 */
	public List<SearchEmptyBookingListVO> searchEmptyBookingList(SearchEmptyBookingListVO searchEmptyBookingListVO) throws EventException;

	/**
	 * EES_CTM_0408 조회 이벤트 처리<br>
	 * 컨테이너 번호에 의한 MOvement History 조회.<br>
	 *
	 * @param SearchMovementListByContainerVO searchMovementListByContainerVO
	 * @return List<SearchMovementListByContainerVO>
	 * @exception EventException
	 */
	public List<SearchMovementListByContainerVO> searchMovementListByContainer(SearchMovementListByContainerVO searchMovementListByContainerVO) throws EventException;

	/**
	 * EES_CTM_0408 조회 이벤트 처리<br>
	 * 컨테이너 번호에 의한 MOvement History 조회.<br>
	 *
	 * @param SearchEdiMsgVO searchEdiMsgVO
	 * @return List<SearchEdiMsgVO>
	 * @exception EventException
	 */
	public List<SearchEdiMsgVO> searchEdiMsg(SearchEdiMsgVO searchEdiMsgVO) throws EventException;

	/**
	 * EES_CTM_0409 조회 이벤트 처리<br>
	 * BL_NO로 BKG번호 조회<br>
	 *
	 * @param String blNo
	 * @return String
	 * @throws EventException
	 */
	public String searchMovementListByGetBkgNo(String blNo) throws EventException;

	/**
	 * EES_CTM_0409 조회 이벤트 처리<br>
	 * BKG_NO로 Booking Information 조회<br>
	 *
	 * @param String bkgNo
	 * @return List<SearchMovementListByBkgInfoVO>
	 * @throws EventException
	 */
	public List<SearchMovementListByBkgInfoVO> searchMovementListByBkgInfo(String bkgNo) throws EventException;

	/**
	 * EES_CTM_0409 조회 이벤트 처리<br>
	 * BKG_NO로 Booking Information 조회<br>
	 *
	 * @param String vslPrePstCd
	 * @param String bkgNo
	 * @return List<SearchMovementListByVvdForMultiComboVO>
	 * @throws EventException
	 */
	public List<SearchMovementListByVvdForMultiComboVO> searchMovementListByVvdForMultiCombo(String vslPrePstCd, String bkgNo) throws EventException;

	/**
	 * EES_CTM_0409 조회 이벤트 처리<br>
	 * BKG_NO로 SPLIT_BKG_NO 조회<br>
	 *
	 * @param String bkgNo
	 * @return List<SearchMovementListBySplitBkgNoForMultiComboVO>
	 * @throws EventException
	 */
	public List<SearchMovementListBySplitBkgNoForMultiComboVO> searchMovementListBySplitBkgNoForMultiCombo(String bkgNo) throws EventException;

	/**
	 * EES_CTM_0409 조회 이벤트 처리<br>
	 * BKG_NO로 SPLIT_BKG_NO 조회<br>
	 *
	 * @param String bkgNo
	 * @return List<SearchMovementListByCntrTpszCdVO>
	 * @throws EventException
	 */
	public List<SearchMovementListByCntrTpszCdVO> searchMovementListByCntrTpszCd(String bkgNo) throws EventException;
	
	/**
	 * EES_CTM_0409 조회 이벤트 처리<br>
	 * BKG_NO로 SPLIT_BKG_NO 조회<br>
	 *
	 * @param String bkgNo
	 * @return List<SearchMovementListByCntrInfoVO>
	 * @throws EventException
	 */
	public List<SearchMovementListByCntrInfoVO> searchMovementListByCntrInfo(String bkgNo) throws EventException;

	/**
	 * EES_CTM_0411 : btn_retrive<br>
	 * Detail Form의 VVD History List 조회<br>
	 *
	 * @param CtmVvdHistoryVO ctmVvdHistoryVO
	 * @return List<CtmVvdHistoryVO>
	 * @exception EventException
	 */
	public List<CtmVvdHistoryVO> searchVvdHistory(CtmVvdHistoryVO ctmVvdHistoryVO) throws EventException;

	/**
	 * EES_CTM_0411 조회 이벤트 처리<br>
	 * 컨테이너의 이동정보 상세 내역을 얻어온다.<br>
	 *
	 * @param CtmVvdHistoryVO ctmVvdHistoryVO
	 * @return List<searchMovementHistoryVO>
	 * @exception EventException
	 */
	public List<searchMovementHistoryVO> searchMvmtHistory(CtmVvdHistoryVO ctmVvdHistoryVO) throws EventException;

	/**
	 * EES_CTM_0443 : btn_retrive<br>
	 * Cargo Location message 리스트 조회 <br>
	 *
	 * @param CtmCCLMVO ctmCCLMVO
	 * @return List<CtmCCLMVO>
	 * @exception EventException
	 */
	 public List<CtmCCLMVO> searchCLMInfo(CtmCCLMVO ctmCCLMVO) throws EventException;
	 
	/**
	 * EES_CTM_0413 : btn_retrive<br>
	 * BKG/MVMT VL/VD Unmatch List 조회<br>
	 *
	 * @param ConCBookingVO conCBookingVO
	 * @param String type
	 * @return List<ConCBookingVO>
	 * @exception EventException
	 */
	 public List<ConCBookingVO> searchMVMTBKGUnmatchList(ConCBookingVO conCBookingVO, String type) throws EventException;

	/**
	 * EES_CTM_0413 조회 이벤트 처리<br>
	 * BKG/MVMT VL/VD Unmatch List Count 조회<br>
	 *
	 * @param ConCBookingVO conCBookingVO
	 * @param String type
	 * @return String
	 * @exception EventException
	 */
	 public String searchMVMTBKGUnmatchListCount(ConCBookingVO conCBookingVO, String type) throws EventException;

	/**
	 * EES_CTM_0419 : btn_retrive<br>
	 * VL/VD EDI Test Result의 리스트 조회<br>
	 *
	 * @param ConCBookingVO conCBookingVO
	 * @param String type
	 * @return List<ConCBookingVO>
	 * @exception EventException
	 */
	 public List<ConCBookingVO> searchResultEDIList(ConCBookingVO conCBookingVO, String type) throws EventException;

	 /**
	 * EES_CTM_0465 조회 이벤트 처리<br>
	 * 컨테이너 번호에 의한 Multi Container 의 Movement History 조회.<br>
	 *
	 * @param SearchMovementListByMultiContainerVO searchMovementListByMultiContainerVO
	 * @return List<SearchMovementListByMultiContainerVO>
	 * @exception EventException
	 */
	public List<SearchMovementListByMultiContainerVO> searchMovementListByMultiContainer(SearchMovementListByMultiContainerVO searchMovementListByMultiContainerVO) throws EventException;

	/**
	 * 컨테이너 번호에 의한 Multi Container 의 EDI Error List 조회.
	 * @param searchMovementListByMultiContainerVO
	 * @return List<SearchEDIMovementListVO>
	 * @throws EventException
	 */
	public List<SearchEDIMovementListVO> searchMovementErrorListByMultiContainer(SearchMovementListByMultiContainerVO searchMovementListByMultiContainerVO) throws EventException;

	/**
	 * Movement Correction Monitoring 정보를 조회한다.<br>
	 *
	 * @param SearchMovementHistoryMonitorListVO searchMovementHistoryMonitorListVO
	 * @return List<SearchMovementHistoryMonitorListVO>
	 * @throws EventException
	 */
	public List<SearchMovementHistoryMonitorListVO> containerMovementHistoryMonitorList(SearchMovementHistoryMonitorListVO searchMovementHistoryMonitorListVO) throws EventException;
	/**
	 * RHQ Office정보를 조회한다.<br>
	 *
	 * @param SearchMovementHistoryMonitorListVO searchMovementHistoryMonitorListVO
	 * @return List<SearchMovementHistoryMonitorListVO>
	 * @throws EventException
	 */
	public List<SearchMovementHistoryMonitorListVO> getRhqOfficeList(SearchMovementHistoryMonitorListVO searchMovementHistoryMonitorListVO) throws EventException;
	
	/**
	 * RHQ Level에 따른 Office 목록을 조회.<br>
	 *
	 * @param SearchMovementHistoryMonitorListVO searchMovementHistoryMonitorListVO
	 * @return List<SearchMovementHistoryMonitorListVO>
	 * @throws EventException
	 */
	public List<SearchMovementHistoryMonitorListVO> getOfficeByRhqLevelList(SearchMovementHistoryMonitorListVO searchMovementHistoryMonitorListVO) throws EventException;
	
	 /**
	 * EES_CTM_0437 조회 이벤트 처리<br>
	 * 컨테이너 번호에 의한 Correction History 조회.<br>
	 *
	 * @param SearchCorrectionHistoryVO searchCorrectionHistoryVO
	 * @return List<SearchCorrectionHistoryVO>
	 * @exception EventException
	 */
	public List<SearchCorrectionHistoryVO> searchCorrectionHistory(SearchCorrectionHistoryVO searchCorrectionHistoryVO) throws EventException;
	
	/**
	 * Movement Correction Monitoring Summary 정보를 yard 단위로 조회한다.<br>
	 *
	 * @param SearchMovementHistoryMonitorListVO searchMovementHistoryMonitorListVO
	 * @return List<SearchMovementHistoryMonitorListVO>
	 * @throws EventException
	 */
	public List<SearchMovementHistoryMonitorListVO> movementCorrctionMonitorList(SearchMovementHistoryMonitorListVO searchMovementHistoryMonitorListVO) throws EventException;
	
	/**
	 * Movement Correction Monitoring Summary 정보를 Lcc 단위로 조회한다.<br>
	 *
	 * @param SearchMovementHistoryMonitorListVO searchMovementHistoryMonitorListVO
	 * @return List<SearchMovementHistoryMonitorListVO>
	 * @throws EventException
	 */
	public List<SearchMovementHistoryMonitorListVO> movementCorrctionMonitorLccList(SearchMovementHistoryMonitorListVO searchMovementHistoryMonitorListVO) throws EventException;
	
	/**
	 * Movement Correction Monitoring Summary 정보를 Rcc 단위로 조회한다.<br>
	 *
	 * @param SearchMovementHistoryMonitorListVO searchMovementHistoryMonitorListVO
	 * @return List<SearchMovementHistoryMonitorListVO>
	 * @throws EventException
	 */
	public List<SearchMovementHistoryMonitorListVO> movementCorrctionMonitorRccList(SearchMovementHistoryMonitorListVO searchMovementHistoryMonitorListVO) throws EventException;

	/**
	 * Inbound vermas EDI 데이터 조회.
	 * @param searchVermasListVO
	 * @return List<SearchVermasListVO>
	 * @throws EventException
	 */
	public List<SearchVermasListVO> searchVermasList(SearchVermasListVO searchVermasListVO) throws EventException;
}