/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerMovementFinderBC.java
*@FileTitle : VL/VD EDI Test Result
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.basic;

import java.util.List;

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
import com.clt.framework.core.layer.event.EventException;


/**
 * OPUS-Equipmentmovementmgt Business Logic Command Interface
 *
 * @author 
 * @see Ees_ctm_0412EventResponse reference
 * @see Ees_ctm_0415EventResponse reference
 * @see Ees_ctm_0405EventResponse reference
 * @see Ees_ctm_0408EventResponse reference
 * @see Ees_ctm_0409EventResponse reference
 * @see Ees_ctm_0443EventResponse reference
 * @see Ees_ctm_0413EventResponse reference
 * @see Ees_ctm_0419EventResponse reference
 * @since J2EE 1.4
 */
public interface ContainerMovementFinderBC {

	/**
	 * handling retrieve event for EES_CTM_0412 
	 * retrieving BKG container update Irr 
	 *
	 * @param CtmMvmtIrrVO ctmMvmtIrrVO
	 * @return List<CtmMvmtIrrVO>
	 * @exception EventException
	 */
	public List<CtmMvmtIrrVO> searchIrregularContainerList(CtmMvmtIrrVO ctmMvmtIrrVO) throws EventException;

	/**
	 * handling retrieve event for EES_CTM_0415 
	 * retrieving deleted Movement List 
	 *
	 * @param SearchDeletedMVMTListVO searchDeletedMVMTListVO
	 * @return List<SearchDeletedMVMTListVO>
	 * @exception EventException
	 */
	public List<SearchDeletedMVMTListVO> searchDeletedMVMTList(SearchDeletedMVMTListVO searchDeletedMVMTListVO) throws EventException;

	/**
	 * handling retrieve event for EES_CTM_0405 
	 * retrieving Empty VL List without BKG List
	 *
	 * @param SearchEmptyBookingListVO searchEmptyBookingListVO
	 * @return List<SearchEmptyBookingListVO>
	 * @exception EventException
	 */
	public List<SearchEmptyBookingListVO> searchEmptyBookingList(SearchEmptyBookingListVO searchEmptyBookingListVO) throws EventException;

	/**
	 * handling retrieve event for EES_CTM_0408
	 * retrieving MOvement History by container no
	 *
	 * @param SearchMovementListByContainerVO searchMovementListByContainerVO
	 * @return List<SearchMovementListByContainerVO>
	 * @exception EventException
	 */
	public List<SearchMovementListByContainerVO> searchMovementListByContainer(SearchMovementListByContainerVO searchMovementListByContainerVO) throws EventException;

	/**
	 * 
	 * @param SearchDeletedMVMTListVO searchDeletedMVMTListVO
	 * @return List<SearchDeletedMVMTListVO>
	 * @throws EventException
	 */
	public List<SearchDeletedMVMTListVO> searchOSCARCtmCycNo(SearchDeletedMVMTListVO searchDeletedMVMTListVO) throws EventException;

	/**
	 * 
	 * @param SearchDeletedMVMTListVO searchDeletedMVMTListVO
	 * @return String
	 * @throws EventException
	 */
	public String searchOPUSBKGwithCycNo(SearchDeletedMVMTListVO searchDeletedMVMTListVO) throws EventException;

	/**
	 * 
	 * @param SearchAllVVDByBKGVO searchAllVVDByBKGVO
	 * @return List<SearchAllVVDByBKGVO>
	 * @throws EventException
	 */
	public List<SearchAllVVDByBKGVO> searchAllVVDByBKG(SearchAllVVDByBKGVO searchAllVVDByBKGVO) throws EventException;

	/**
	 * handling retrieve event for EES_CTM_0408
	 * retrieving MOvement History by container no
	 *
	 * @param SearchEdiMsgVO searchEdiMsgVO
	 * @return List<SearchEdiMsgVO>
	 * @exception EventException
	 */
	public List<SearchEdiMsgVO> searchEdiMsg(SearchEdiMsgVO searchEdiMsgVO) throws EventException;

	/**
	 * handling retrieve event for EES_CTM_0409 
	 * retrieving BKG no by BL no
	 *
	 * @param String blNo
	 * @return String
	 * @throws EventException
	 */
	public String searchMovementListByGetBkgNo(String blNo) throws EventException;

	/**
	 * handling retrieve event for EES_CTM_0409 
	 * retrieving Booking Information by BKG_NO
	 *
	 * @param String bkgNo
	 * @return List<SearchMovementListByBkgInfoVO>
	 * @throws EventException
	 */
	public List<SearchMovementListByBkgInfoVO> searchMovementListByBkgInfo(String bkgNo) throws EventException;

	/**
	 * handling retrieve event for EES_CTM_0409 
	 * retrieving EQR Ref No Information by MTY_PLN_NO
	 *
	 * @param String mtyPlnNo
	 * @return List<SearchMovementListByEqrRefInfoVO>
	 * @throws EventException
	 */
	public List<SearchMovementListByEqrRefInfoVO> searchMovementListByEqrRefInfo(String mtyPlnNo) throws EventException;

	/**
	 * handling retrieve event for EES_CTM_0409 
	 * retrieving Wo No by MTY_PLN_NO
	 *
	 * @param String mtyPlnNo
	 * @return List<SearchWoNoByEqrRefInfoVO>
	 * @throws EventException
	 */
	public List<SearchWoNoByEqrRefInfoVO> searchWoNoByEqrRefInfo(String mtyPlnNo) throws EventException;

	/**
	 * handling retrieve event for EES_CTM_0409 
	 * retrieving Booking Information by BKG_NO
	 *
	 * @param String vslPrePstCd
	 * @param String bkgNo
	 * @return List<SearchMovementListByVvdForMultiComboVO>
	 * @throws EventException
	 */
	public List<SearchMovementListByVvdForMultiComboVO> searchMovementListByVvdForMultiCombo(String vslPrePstCd, String bkgNo) throws EventException;

	/**
	 * handling retrieve event for EES_CTM_0409
	 * retrieving SPLIT_BKG_NO by BKG_NO
	 *
	 * @param String bkgNo
	 * @return List<SearchMovementListBySplitBkgNoForMultiComboVO>
	 * @throws EventException
	 */
	public List<SearchMovementListBySplitBkgNoForMultiComboVO> searchMovementListBySplitBkgNoForMultiCombo(String bkgNo) throws EventException;

	/**
	 * handling retrieve event for EES_CTM_0409 
	 * retrieving SPLIT_BKG_NO by BKG_NO
	 *
	 * @param String bkgNo
	 * @return List<SearchMovementListByCntrTpszCdVO>
	 * @throws EventException
	 */
	public List<SearchMovementListByCntrTpszCdVO> searchMovementListByCntrTpszCd(String bkgNo) throws EventException;

	/**
	 * handling retrieve event for EES_CTM_0409 
	 * retrieving CNTR_TPSZ_CD by MTY_PLN_NO
	 *
	 * @param String mtyPlnNo
	 * @return List<SearchMovementListByCntrTpszCdVO>
	 * @throws EventException
	 */
	public List<SearchMovementListByCntrTpszCdVO> searchCntrTpszCdByEqrRef(String mtyPlnNo) throws EventException;

	/**
	 * handling retrieve event for EES_CTM_0409
	 * retrieving SPLIT_BKG_NO by BKG_NO
	 *
	 * @param String bkgNo
	 * @return List<SearchMovementListByCntrInfoVO>
	 * @throws EventException
	 */
	public List<SearchMovementListByCntrInfoVO> searchMovementListByCntrInfo(String bkgNo) throws EventException;

	/**
	 * handling retrieve event for EES_CTM_0409
	 * retrieving Container Information by MTY_PLN_NO
	 *
	 * @param String mtyPlnNo
	 * @return List<SearchMovementListByCntrInfoVO>
	 * @throws EventException
	 */
	public List<SearchMovementListByCntrInfoVO> searchCntrInfoByEqrRef(String mtyPlnNo) throws EventException;

	/**
	 * handling retrieve event for EES_CTM_0472
	 * retrieving All Booking
	 *
	 * @param SearchAllBKGVO searchAllBKGVO
	 * @return List<SearchAllBKGVO>
	 * @throws EventException
	 */
	public List<SearchAllBKGVO> searchAllBKG(SearchAllBKGVO searchAllBKGVO) throws EventException;

	/**
	 * handling retrieve event for EES_CTM_0473
	 * retrieving All EQR Reference
	 *
	 * @param SearchAllEQRRefVO searchAllEQRRefVO
	 * @return List<SearchAllEQRRefVO>
	 * @throws EventException
	 */
	public List<SearchAllEQRRefVO> searchAllEQRRef(SearchAllEQRRefVO searchAllEQRRefVO) throws EventException;

	/**
	 * EES_CTM_0411 : btn_retrive
	 * retrieving VVD History List in Detail Form
	 *
	 * @param CtmVvdHistoryVO ctmVvdHistoryVO
	 * @return List<CtmVvdHistoryVO>
	 * @exception EventException
	 */
	public List<CtmVvdHistoryVO> searchVvdHistory(CtmVvdHistoryVO ctmVvdHistoryVO) throws EventException;

	/**
	 * handling retrieve event for EES_CTM_0411
	 * getting container movement detail information
	 *
	 * @param CtmVvdHistoryVO ctmVvdHistoryVO
	 * @return List<searchMovementHistoryVO>
	 * @exception EventException
	 */
	public List<searchMovementHistoryVO> searchMvmtHistory(CtmVvdHistoryVO ctmVvdHistoryVO) throws EventException;

	/**
	 * EES_CTM_0443 : btn_retrive
	 * retrieving Cargo Location message list
	 *
	 * @param CtmCCLMVO ctmCCLMVO
	 * @return List<CtmCCLMVO>
	 * @exception EventException
	 */
	 public List<CtmCCLMVO> searchCLMInfo(CtmCCLMVO ctmCCLMVO) throws EventException;

	/**
	 * EES_CTM_0413 : btn_retrive
	 * retrieving BKG/MVMT VL/VD Unmatch List 
	 *
	 * @param ConCBookingVO conCBookingVO
	 * @param String type
	 * @return List<ConCBookingVO>
	 * @exception EventException
	 */
	 public List<ConCBookingVO> searchMVMTBKGUnmatchList(ConCBookingVO conCBookingVO, String type) throws EventException;

	/**
	 * handling retrieve event for EES_CTM_0413
	 * retrievingBKG/MVMT VL/VD Unmatch List Count
	 *
	 * @param ConCBookingVO conCBookingVO
	 * @param String type
	 * @return String
	 * @exception EventException
	 */
	 public String searchMVMTBKGUnmatchListCount(ConCBookingVO conCBookingVO, String type) throws EventException;

	/**
	 * EES_CTM_0419 : btn_retrive
	 * retrieving VL/VD EDI Test Result List
	 *
	 * @param ConCBookingVO conCBookingVO
	 * @param String type
	 * @return List<ConCBookingVO>
	 * @exception EventException
	 */
	 public List<ConCBookingVO> searchResultEDIList(ConCBookingVO conCBookingVO, String type) throws EventException;

}