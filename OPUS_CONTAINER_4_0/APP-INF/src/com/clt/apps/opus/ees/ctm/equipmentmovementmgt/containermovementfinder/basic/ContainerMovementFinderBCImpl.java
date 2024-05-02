/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerMovementFinderBCImpl.java
*@FileTitle : BKG container update Irr.
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.basic;

import java.util.List;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.integration.ContainerMovementFinderDBDAO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.ConCBookingVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.CtmCCLMVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.CtmMvmtIrrVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.CtmVvdHistoryVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchAllBKGVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchAllEQRRefVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchAllVVDByBKGVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchDeletedMVMTListVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchEdiMsgVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchEmptyBookingListVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByBkgInfoVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByCntrInfoVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByCntrTpszCdVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByContainerVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByEqrRefInfoVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListBySplitBkgNoForMultiComboVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByVvdForMultiComboVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchWoNoByEqrRefInfoVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.searchMovementHistoryVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;


/**
 * OPUS-EquipmentMovementMgt Business Logic Basic Command implementation
 * handling business logic about OPUS-EquipmentMovementMgt
 *
 * @author
 * @see Ees_ctm_0412EventResponse, ContainerMovementFinderBC DAO class reference
 * @see Ees_ctm_0415EventResponse, ContainerMovementFinderBC DAO class reference
 * @see Ees_ctm_0405EventResponse, ContainerMovementFinderBC DAO class reference
 * @see Ees_ctm_0408EventResponse, ContainerMovementFinderBC DAO class reference
 * @see Ees_ctm_0409EventResponse, ContainerMovementFinderBC DAO class reference
 * @see Ees_ctm_0443EventResponse, ContainerMovementFinderBC DAO class reference
 * @see Ees_ctm_0413EventResponse, ContainerMovementFinderBC DAO class reference
 * @see Ees_ctm_0419EventResponse, ContainerMovementFinderBC DAO class reference
 * @since J2EE 1.4
 */
public class ContainerMovementFinderBCImpl extends BasicCommandSupport implements ContainerMovementFinderBC {

	// Database Access Object
	private transient ContainerMovementFinderDBDAO dbDao = null;

	/**
	 * creating ContainerMovementFinderBCImpl Object
	 * creating ContainerMovementFinderDBDAO
	 */
	public ContainerMovementFinderBCImpl() {
		dbDao = new ContainerMovementFinderDBDAO();
	}

	/**
	 * EES_CTM_0412 : btn_retrive
	 * retrieving Container IRR Table List 
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
	 * EES_CTM_0415 : btn_retrive
	 * retrieving deleted Movement List 
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
	 * EES_CTM_0405 : btn_retrive
	 * retrieving Empty Booking List
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
	 * EES_CTM_0408 : btn_retrive
	 * retrieving Each Container LIST by container no
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

	/** searchOSCARCtmCycNo
	 * 
	 * @param searchDeletedMVMTListVO
	 * @return List<SearchDeletedMVMTListVO>
	 * @throws EventException
	 */
	public List<SearchDeletedMVMTListVO> searchOSCARCtmCycNo(SearchDeletedMVMTListVO searchDeletedMVMTListVO) throws EventException {
		try {
			return dbDao.searchOSCARCtmCycNo(searchDeletedMVMTListVO);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchOSCARCtmCycNo] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchOSCARCtmCycNo] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/** searchOPUSBKGwithCycNo
	 * 
	 * @param searchDeletedMVMTListVO
	 * @return String
	 * @throws EventException
	 */
	public String searchOPUSBKGwithCycNo(SearchDeletedMVMTListVO searchDeletedMVMTListVO) throws EventException {
		try {
			return dbDao.searchOPUSBKGwithCycNo(searchDeletedMVMTListVO);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchOSCARCtmCycNo] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchOSCARCtmCycNo] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/** searchAllVVDByBKG
	 * 
	 * @param searchAllVVDByBKGVO
	 * @return List<SearchAllVVDByBKGVO>
	 * @throws EventException
	 */
	public List<SearchAllVVDByBKGVO> searchAllVVDByBKG(SearchAllVVDByBKGVO searchAllVVDByBKGVO) throws EventException {
		try {
			return dbDao.searchAllVVDByBKG(searchAllVVDByBKGVO);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchAllVVDByBKG] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchAllVVDByBKG] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}
	
	/**
	 * EES_CTM_0408 : btn_retrive
	 * retrieving EDI Message List by container no
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
	 * EES_CTM_0409 : btn_retrive
	 * retrieving BKG no by BL no
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
	 * EES_CTM_0409 : btn_retrive
	 * retrieving Booking Information by BKG_NO
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
	 * EES_CTM_0409 : btn_retrive
	 * retrieving EQR Ref No Information by MTY_PLN_NO
	 *
	 * @param String mtyPlnNo
	 * @return List<SearchMovementListByBkgInfoVO>
	 * @throws EventException
	 */
	public List<SearchMovementListByEqrRefInfoVO> searchMovementListByEqrRefInfo(String mtyPlnNo) throws EventException {
		try {
			return dbDao.searchMovementListByEqrRefInfo(mtyPlnNo);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchMovementListByEqrRefInfo] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchMovementListByEqrRefInfo] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0409 : btn_retrive
	 * retrieving Wo No by MTY_PLN_NO
	 *
	 * @param String mtyPlnNo
	 * @return List<SearchWoNoByEqrRefInfoVO>
	 * @throws EventException
	 */
	public List<SearchWoNoByEqrRefInfoVO> searchWoNoByEqrRefInfo(String mtyPlnNo) throws EventException {
		try {
			return dbDao.searchWoNoByEqrRefInfo(mtyPlnNo);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchWoNoByEqrRefInfo] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchWoNoByEqrRefInfo] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0409 : btn_retrive
	 * retrieving Booking Information by BKG_NO
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
	 * EES_CTM_0409 : btn_retrive
	 * retrieving SPLIT_BKG_NO by BKG_NO
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
	 * EES_CTM_0409 : btn_retrive
	 * retrieving Container Type Size by BKG_NO
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
	 * EES_CTM_0409 : btn_retrive
	 * retrieving Container Type Size by MTY_PLN_NO
	 *
	 * @param String mtyPlnNo
	 * @return List<SearchMovementListByCntrTpszCdVO>
	 * @throws EventException
	 */
	public List<SearchMovementListByCntrTpszCdVO> searchCntrTpszCdByEqrRef(String mtyPlnNo) throws EventException {
		try {
			return dbDao.searchCntrTpszCdByEqrRef(mtyPlnNo);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchCntrTpszCdByEqrRef] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchCntrTpszCdByEqrRef] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0409 : btn_retrive
	 * retrieving SPLIT_BKG_NO by BKG_NO
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
	 * EES_CTM_0409 : btn_retrive
	 * retrieving Container Info by MTY_PLN_NO
	 *
	 * @param String mtyPlnNo
	 * @return List<SearchMovementListByCntrInfoVO>
	 * @throws EventException
	 */
	public List<SearchMovementListByCntrInfoVO> searchCntrInfoByEqrRef(String mtyPlnNo) throws EventException {
		try {
			return dbDao.searchCntrInfoByEqrRef(mtyPlnNo);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchCntrInfoByEqrRef] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchCntrInfoByEqrRef] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0472 : btn_retrive
	 * retrieving All Booking
	 *
	 * @param SearchAllBKGVO searchAllBKGVO
	 * @return List<SearchAllBKGVO>
	 * @throws EventException
	 */
	public List<SearchAllBKGVO> searchAllBKG(SearchAllBKGVO searchAllBKGVO) throws EventException {
		try {
			return dbDao.searchAllBKG(searchAllBKGVO);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchAllBKG] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchAllBKG] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0473 : btn_retrive
	 * retrieving All EQR Reference
	 *
	 * @param SearchAllEQRRefVO searchAllEQRRefVO
	 * @return List<SearchAllEQRRefVO>
	 * @throws EventException
	 */
	public List<SearchAllEQRRefVO> searchAllEQRRef(SearchAllEQRRefVO searchAllEQRRefVO) throws EventException {
		try {
			return dbDao.searchAllEQRRef(searchAllEQRRefVO);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchAllEQRRef] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchAllEQRRef] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0411 : btn_retrive
	 * retrieving VVD History List in Detail Form
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
	 * EES_CTM_0411 : btn_retrive
	 * getting container movement detail information
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
	 * EES_CTM_0443 : btn_retrive
	 * retrieving Cargo Location message list
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
	 *  retrieving BKG/Movement Unmatch List 
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
	 * EES_CTM_0413 : btn_retrive
	 * retrieving BKG/Movement Unmatch count
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
	 * EES_CTM_0419 : btn_retrive
	 * retrieving Booking/EDI Unmatch List 
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

}