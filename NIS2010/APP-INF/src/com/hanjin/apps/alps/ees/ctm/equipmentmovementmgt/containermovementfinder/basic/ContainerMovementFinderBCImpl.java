/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerMovementFinderBCImpl.java
*@FileTitle : BKG container update Irr.
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.29
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.04.29 우경민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.integration.ContainerMovementFinderDBDAO;
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
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;


/**
 * ALPS-EquipmentMovementMgt Business Logic Basic Command implementation<br>
 * - ALPS-EquipmentMovementMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author KyungMin Woo
 * @see Ees_ctm_0412EventResponse, ContainerMovementFinderBC 각 DAO 클래스 참조
 * @see Ees_ctm_0415EventResponse, ContainerMovementFinderBC 각 DAO 클래스 참조
 * @see Ees_ctm_0405EventResponse, ContainerMovementFinderBC 각 DAO 클래스 참조
 * @see Ees_ctm_0408EventResponse, ContainerMovementFinderBC 각 DAO 클래스 참조
 * @see Ees_ctm_0409EventResponse, ContainerMovementFinderBC 각 DAO 클래스 참조
 * @see Ees_ctm_0443EventResponse, ContainerMovementFinderBC 각 DAO 클래스 참조
 * @see Ees_ctm_0413EventResponse, ContainerMovementFinderBC 각 DAO 클래스 참조
 * @see Ees_ctm_0419EventResponse, ContainerMovementFinderBC 각 DAO 클래스 참조
 * @see Ees_ctm_0436EventResponse, ContainerMovementFinderBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class ContainerMovementFinderBCImpl extends BasicCommandSupport implements ContainerMovementFinderBC {

	// Database Access Object
	private transient ContainerMovementFinderDBDAO dbDao = null;

	/**
	 * ContainerMovementFinderBCImpl 객체 생성<br>
	 * ContainerMovementFinderDBDAO를 생성한다.<br>
	 */
	public ContainerMovementFinderBCImpl() {
		dbDao = new ContainerMovementFinderDBDAO();
	}

	/**
	 * EES_CTM_0412 : btn_retrive<br>
	 * Container IRR Table List 조회.<br>
	 *
	 * @param CtmMvmtIrrVO ctmMvmtIrrVO
	 * @return List<CtmMvmtIrrVO>
	 * @exception EventException
	 */
	public List<CtmMvmtIrrVO> searchIrregularContainerList(CtmMvmtIrrVO ctmMvmtIrrVO) throws EventException {
		try {
			return dbDao.searchIrregularContainerList(ctmMvmtIrrVO);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchIrregularContainerList] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchIrregularContainerList] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0415 : btn_retrive<br>
	 * 삭제된 Movement List 조회<br>
	 *
	 * @param SearchDeletedMVMTListVO searchDeletedMVMTListVO
	 * @return List<SearchDeletedMVMTListVO>
	 * @exception EventException
	 */
	public List<SearchDeletedMVMTListVO> searchDeletedMVMTList(SearchDeletedMVMTListVO searchDeletedMVMTListVO) throws EventException {
		try {
			return dbDao.searchDeletedMVMTList(searchDeletedMVMTListVO);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchDeletedMVMTList] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchDeletedMVMTList] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0405 : btn_retrive<br>
	 * Empty Booking List 조회.<br>
	 *
	 * @param SearchEmptyBookingListVO searchEmptyBookingListVO
	 * @return List<SearchEmptyBookingListVO>
	 * @exception EventException
	 */
	public List<SearchEmptyBookingListVO> searchEmptyBookingList(SearchEmptyBookingListVO searchEmptyBookingListVO) throws EventException {
		try {
			return dbDao.searchEmptyBookingList(searchEmptyBookingListVO);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchEmptyBookingList] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchEmptyBookingList] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0408 : btn_retrive<br>
	 * 컨테이너 번호에 의한 Each Container LIST 조회.<br>
	 *
	 * @param SearchMovementListByContainerVO searchMovementListByContainerVO
	 * @return List<SearchMovementListByContainerVO>
	 * @exception EventException
	 */
	public List<SearchMovementListByContainerVO> searchMovementListByContainer(SearchMovementListByContainerVO searchMovementListByContainerVO) throws EventException {
		try {
			return dbDao.searchMovementListByContainer(searchMovementListByContainerVO);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchMovementListByContainer] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchMovementListByContainer] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0408 : btn_retrive<br>
	 * 컨테이너 번호에 의한 EDI Message List 조회.<br>
	 *
	 * @param SearchEdiMsgVO searchEdiMsgVO
	 * @return List<SearchEdiMsgVO>
	 * @exception EventException
	 */
	public List<SearchEdiMsgVO> searchEdiMsg(SearchEdiMsgVO searchEdiMsgVO) throws EventException {
		try {
			return dbDao.searchEdiMsg(searchEdiMsgVO);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchEdiMsg] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchEdiMsg] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0409 : btn_retrive<br>
	 * BL_NO로 BKG번호 조회<br>
	 *
	 * @param String blNo
	 * @return String
	 * @throws EventException
	 */
	public String searchMovementListByGetBkgNo(String blNo) throws EventException {
		try {
			return dbDao.searchMovementListByGetBkgNo(blNo);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchMovementListByGetBkgNo] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchMovementListByGetBkgNo] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0409 : btn_retrive<br>
	 * BKG_NO로 Booking Information 조회<br>
	 *
	 * @param String bkgNo
	 * @return List<SearchMovementListByBkgInfoVO>
	 * @throws EventException
	 */
	public List<SearchMovementListByBkgInfoVO> searchMovementListByBkgInfo(String bkgNo) throws EventException {
		try {
			return dbDao.searchMovementListByBkgInfo(bkgNo);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchMovementListByBkgInfo] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchMovementListByBkgInfo] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0409 : btn_retrive<br>
	 * BKG_NO로 Booking Information 조회<br>
	 *
	 * @param String vslPrePstCd
	 * @param String bkgNo
	 * @return List<SearchMovementListByVvdForMultiComboVO>
	 * @throws EventException
	 */
	public List<SearchMovementListByVvdForMultiComboVO> searchMovementListByVvdForMultiCombo(String vslPrePstCd, String bkgNo) throws EventException {
		try {
			return dbDao.searchMovementListByVvdForMultiCombo(vslPrePstCd, bkgNo);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchMovementListByVvdForMultiCombo] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchMovementListByVvdForMultiCombo] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0409 : btn_retrive<br>
	 * BKG_NO로 SPLIT_BKG_NO 조회<br>
	 *
	 * @param String bkgNo
	 * @return List<SearchMovementListBySplitBkgNoForMultiComboVO>
	 * @throws EventException
	 */
	public List<SearchMovementListBySplitBkgNoForMultiComboVO> searchMovementListBySplitBkgNoForMultiCombo(String bkgNo) throws EventException {
		try {
			return dbDao.searchMovementListBySplitBkgNoForMultiCombo(bkgNo);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchMovementListBySplitBkgNoForMultiCombo] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchMovementListBySplitBkgNoForMultiCombo] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0409 : btn_retrive<br>
	 * BKG_NO로 Container Type Size 조회
	 *
	 * @param String bkgNo
	 * @return List<SearchMovementListByCntrTpszCdVO>
	 * @throws EventException
	 */
	public List<SearchMovementListByCntrTpszCdVO> searchMovementListByCntrTpszCd(String bkgNo) throws EventException {
		try {
			return dbDao.searchMovementListByCntrTpszCd(bkgNo);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchMovementListByCntrTpszCd] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchMovementListByCntrTpszCd] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0409 : btn_retrive<br>
	 * BKG_NO로 SPLIT_BKG_NO 조회<br>
	 *
	 * @param String bkgNo
	 * @return List<SearchMovementListByCntrInfoVO>
	 * @throws EventException
	 */
	public List<SearchMovementListByCntrInfoVO> searchMovementListByCntrInfo(String bkgNo) throws EventException {
		try {
			return dbDao.searchMovementListByCntrInfo(bkgNo);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchMovementListByCntrInfo] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchMovementListByCntrInfo] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0411 : btn_retrive<br>
	 * Detail Form의 VVD History List 조회<br>
	 *
	 * @param CtmVvdHistoryVO   ctmVvdHistoryVO
	 * @return List<CtmVvdHistoryVO>
	 * @exception EventException
	 */
	public List<CtmVvdHistoryVO> searchVvdHistory(CtmVvdHistoryVO ctmVvdHistoryVO) throws EventException {
		try {
			return dbDao.searchVvdHistory(ctmVvdHistoryVO);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchVvdHistory] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchVvdHistory] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0411 : btn_retrive<br>
	 *   컨테이너의 이동정보 상세 내역을 얻어온다.<br>
	 *
	 * @param CtmVvdHistoryVO   ctmVvdHistoryVO
	 * @return List<searchMovementHistoryVO>
	 * @exception EventException
	 */
	public List<searchMovementHistoryVO> searchMvmtHistory(CtmVvdHistoryVO ctmVvdHistoryVO) throws EventException {
		try {
			return dbDao.searchMvmtHistory(ctmVvdHistoryVO);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchMvmtHistory] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchMvmtHistory] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0443 : btn_retrive<br>
	 * Cargo Location message 리스트 조회 <br>
	 *
	 * @param CtmCCLMVO ctmCCLMVO
	 * @return List<CtmCCLMVO>
	 * @exception EventException
	 */
	public List<CtmCCLMVO> searchCLMInfo(CtmCCLMVO ctmCCLMVO) throws EventException {
		try {
			return dbDao.searchCLMInfo(ctmCCLMVO);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchCLMInfo] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchCLMInfo] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 *  부킹과 Movement의 불일치 내역 조회<br>
	 *
	 * @param ConCBookingVO conCBookingVO
	 * @param String type
	 * @return List<ConCBookingVO>
	 * @exception EventException
	 */
	public List<ConCBookingVO> searchMVMTBKGUnmatchList(ConCBookingVO conCBookingVO, String type) throws EventException {
		try {
			return dbDao.searchMVMTBKGUnmatchList(conCBookingVO, type);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchMVMTBKGUnmatchList] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchMVMTBKGUnmatchList] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0413 : btn_retrive<br>
	 *  부킹과 Movement의 불일치 내역  총 갯수 조회<br>
	 *
	 * @param ConCBookingVO conCBookingVO
	 * @param String type
	 * @return String
	 * @exception EventException
	 */
	public String searchMVMTBKGUnmatchListCount(ConCBookingVO conCBookingVO, String type) throws EventException {
		try {
			return dbDao.searchMVMTBKGUnmatchListCount(conCBookingVO, type);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchMVMTBKGUnmatchListCount] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchMVMTBKGUnmatchListCount] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0419 : btn_retrive<br>
	 *  Booking Caontainet와 EDI 에서 넘어온 자료의 불 일치 내역 조회.<br><br>
	 *
	 * @param ConCBookingVO conCBookingVO
	 * @param String type
	 * @return List<ConCBookingVO>
	 * @exception EventException
	 */
	public List<ConCBookingVO> searchResultEDIList(ConCBookingVO conCBookingVO, String type) throws EventException {
		try {
			return dbDao.searchResultEDIList(conCBookingVO, type);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchResultEDIList] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchResultEDIList] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}
	
	/**
	 * EES_CTM_0456 : btn_retrive<br>
	 * 컨테이너 번호에 의한 Multi Container LIST 조회.<br>
	 *
	 * @param SearchMovementListByMultiContainerVO searchMovementListByMultiContainerVO
	 * @return List<SearchMovementListByMultiContainerVO>
	 * @exception EventException
	 */
	public List<SearchMovementListByMultiContainerVO> searchMovementListByMultiContainer(SearchMovementListByMultiContainerVO searchMovementListByMultiContainerVO) throws EventException {
		try {
			return dbDao.searchMovementListByMultiContainer(searchMovementListByMultiContainerVO);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchMovementListByMultiContainer] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchMovementListByMultiContainer] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * 컨테이너 번호에 의한 Multi Container 의 EDI Error List 조회.
	 * @param searchMovementListByMultiContainerVO
	 * @return List<SearchEDIMovementListVO>
	 * @throws EventException
	 */
	public List<SearchEDIMovementListVO> searchMovementErrorListByMultiContainer(SearchMovementListByMultiContainerVO searchMovementListByMultiContainerVO) throws EventException {
		try {
			return dbDao.searchMovementErrorListByMultiContainer(searchMovementListByMultiContainerVO);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchMovementListByMultiContainer] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchMovementListByMultiContainer] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * Movement Correction Monitoring 정보를 조회한다.<br>
	 *
	 * @param SearchMovementHistoryMonitorListVO searchMovementHistoryMonitorListVO
	 * @return List<SearchMovementHistoryMonitorListVO>
	 * @throws EventException
	 */
	public List<SearchMovementHistoryMonitorListVO> containerMovementHistoryMonitorList(SearchMovementHistoryMonitorListVO searchMovementHistoryMonitorListVO) throws EventException{
		try{
			return dbDao.containerMovementHistoryMonitorList(searchMovementHistoryMonitorListVO);
		} catch (DAOException ex) {
			log.error("\n\n [BCImpl - containerMovementHistoryMonitorList] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\n [BCImpl - containerMovementHistoryMonitorList] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}
	
	/**
	 * RHQ, Office정보를 조회한다.<br>
	 *
	 * @param SearchMovementHistoryMonitorListVO searchMovementHistoryMonitorListVO
	 * @return List<SearchMovementHistoryMonitorListVO>
	 * @throws EventException
	 */
	public List<SearchMovementHistoryMonitorListVO> getRhqOfficeList(SearchMovementHistoryMonitorListVO searchMovementHistoryMonitorListVO) throws EventException{
		try{
			return dbDao.getRhqOfficeList(searchMovementHistoryMonitorListVO);
		} catch (DAOException ex) {
			log.error("\n\n [BCImpl - getRhqOfficeList] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\n [BCImpl - getRhqOfficeList] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}
	
	/**
	 * RHQ Level에 따른 Office 목록을 조회.<br>
	 *
	 * @param SearchMovementHistoryMonitorListVO searchMovementHistoryMonitorListVO
	 * @return List<SearchMovementHistoryMonitorListVO>
	 * @throws EventException
	 */
	public List<SearchMovementHistoryMonitorListVO> getOfficeByRhqLevelList(SearchMovementHistoryMonitorListVO searchMovementHistoryMonitorListVO) throws EventException{
		try{
			return dbDao.getOfficeByRhqLevelList(searchMovementHistoryMonitorListVO);
		} catch (DAOException ex) {
			log.error("\n\n [BCImpl - getRhqOfficeList] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\n [BCImpl - getRhqOfficeList] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}
	
	
	/**
	 * EES_CTM_0437 : btn_retrive<br>
	 * 컨테이너 번호에 의한 Correction History LIST 조회.<br>
	 *
	 * @param SearchCorrectionHistoryVO searchCorrectionHistoryVO
	 * @return List<SearchCorrectionHistoryVO>
	 * @exception EventException
	 */
	public List<SearchCorrectionHistoryVO> searchCorrectionHistory(SearchCorrectionHistoryVO searchCorrectionHistoryVO) throws EventException {
		try {
			return dbDao.searchCorrectionHistory(searchCorrectionHistoryVO);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchCorrectionHistory] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchCorrectionHistory] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}
	
	/**
	 * Movement Correction Monitoring Summary 정보를 yard 단위로 조회한다.<br>
	 *
	 * @param SearchMovementHistoryMonitorListVO searchMovementHistoryMonitorListVO
	 * @return List<SearchMovementHistoryMonitorListVO>
	 * @throws EventException
	 */
	public List<SearchMovementHistoryMonitorListVO> movementCorrctionMonitorList(SearchMovementHistoryMonitorListVO searchMovementHistoryMonitorListVO) throws EventException{
		try{
			return dbDao.movementCorrctionMonitorList(searchMovementHistoryMonitorListVO);
		} catch (DAOException ex) {
			log.error("\n\n [BCImpl - movementCorrctionMonitorList] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\n [BCImpl - movementCorrctionMonitorList] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}
	
	/**
	 * Movement Correction Monitoring Summary 정보를 Lcc 단위로 조회한다.<br>
	 *
	 * @param SearchMovementHistoryMonitorListVO searchMovementHistoryMonitorListVO
	 * @return List<SearchMovementHistoryMonitorListVO>
	 * @throws EventException
	 */
	public List<SearchMovementHistoryMonitorListVO> movementCorrctionMonitorLccList(SearchMovementHistoryMonitorListVO searchMovementHistoryMonitorListVO) throws EventException{
		try{
			return dbDao.movementCorrctionMonitorLccList(searchMovementHistoryMonitorListVO);
		} catch (DAOException ex) {
			log.error("\n\n [BCImpl - movementCorrctionMonitorList] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\n [BCImpl - movementCorrctionMonitorList] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}
	
	/**
	 * Movement Correction Monitoring Summary 정보를 Rcc 단위로 조회한다.<br>
	 *
	 * @param SearchMovementHistoryMonitorListVO searchMovementHistoryMonitorListVO
	 * @return List<SearchMovementHistoryMonitorListVO>
	 * @throws EventException
	 */
	public List<SearchMovementHistoryMonitorListVO> movementCorrctionMonitorRccList(SearchMovementHistoryMonitorListVO searchMovementHistoryMonitorListVO) throws EventException{
		try{
			return dbDao.movementCorrctionMonitorRccList(searchMovementHistoryMonitorListVO);
		} catch (DAOException ex) {
			log.error("\n\n [BCImpl - movementCorrctionMonitorList] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\n [BCImpl - movementCorrctionMonitorList] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * Inbound vermas EDI 데이터 조회.
	 * @param searchVermasListVO
	 * @return List<SearchVermasListVO>
	 * @throws EventException
	 */
	public List<SearchVermasListVO> searchVermasList(SearchVermasListVO searchVermasListVO) throws EventException {
		List<SearchVermasListVO> list = null;

		try {
			list = dbDao.searchVermasList(searchVermasListVO);
		} catch (DAOException ex) {
			log.error("\n\n [BCImpl - movementCorrctionMonitorList] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\n [BCImpl - movementCorrctionMonitorList] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}

		return list;
	}
}
