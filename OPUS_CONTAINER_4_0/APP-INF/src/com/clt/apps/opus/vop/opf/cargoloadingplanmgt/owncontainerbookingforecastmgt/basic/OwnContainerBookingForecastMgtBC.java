/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtBC.java
*@FileTitle : Weight Group (Creation)
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.basic;

import java.util.List;

import com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFListOptionVO;
import com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFSpecialStwgVO;
import com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFSummaryVO;
import com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CargoBookingForecastVO;
import com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.PodComboVO;
import com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.VskVslPortSkdCustVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.VskCarrierVO;



/**
 * OPUS-Cargoloadingplanmgt Business Logic Command Interface<br>
 *
 * @author 
 * @see Reference Vop_opf-3019EventResponse
 * @since J2EE 1.4
 */

public interface OwnContainerBookingForecastMgtBC {

	/**
	 * Retrieve WeightGRPList .<br>
	 * 
	 * @param CargoBookingForecastVO cargoBookingForecastVO
	 * @return List<CargoBookingForecastVO>
	 * @exception EventException
	 */
	public List<CargoBookingForecastVO> searchWeightGRPList(CargoBookingForecastVO cargoBookingForecastVO) throws EventException;

	/**
	 * Save Weight Group Info <br>
	 * 
	 * @param CargoBookingForecastVO[] cargoBookingForecastVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageWeightGRP(CargoBookingForecastVO[] cargoBookingForecastVO,SignOnUserAccount account) throws EventException;

	/**
	 * Retrieve CBFVolumeList .<br>
	 * 
	 * @param CBFListOptionVO cBFListOptionVO
	 * @return List<List<CBFListOptionVO>>
	 * @exception EventException
	 */
	public List<List<CBFListOptionVO>> searchCBFVolumeList(CBFListOptionVO cBFListOptionVO) throws EventException;
	
	/**
	 * Retrieve CBFBKGVolumeList .<br>
	 * 
	 * @param CBFListOptionVO cBFListOptionVO
	 * @return List<List<CBFListOptionVO>>
	 * @exception EventException
	 */
	public List<List<CBFListOptionVO>> searchCBFBKGVolumeList(CBFListOptionVO cBFListOptionVO) throws EventException;

	/**
	 * Retrieve CBFSpecialList .<br>
	 * 
	 * @param CBFListOptionVO cbfListOptionVO
	 * @return List<CBFListOptionVO>
	 * @exception EventException
	 */
	public List<CBFListOptionVO> searchCBFVolumeSpecialList(CBFListOptionVO cbfListOptionVO) throws EventException;

	/**
	 * Check BKGVVD Info.<br>
	 * 
	 * @param CBFListOptionVO cbfListOptionVO
	 * @return int
	 * @exception EventException
	 */
	public int checkBKGVVD(CBFListOptionVO cbfListOptionVO) throws EventException;
	/**
	 * Check TurningPortSkipCall Info.
	 * 
	 * @param CBFListOptionVO cbfListOptionVO
	 * @return VskVslPortSkdCustVO
	 * @exception EventException
	 */
	public VskVslPortSkdCustVO checkTurningPortSkipCall(CBFListOptionVO cbfListOptionVO) throws EventException;

	/**
	 *Retrieve  POL .<br>
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchPol(String vslCd, String skdVoyNo, String skdDirCd) throws EventException;

	/**
	 * Retrieve OPR .<br>
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String ydCd
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchOpr(String vslCd, String skdVoyNo, String skdDirCd, String ydCd) throws EventException;

	/**
	 * Retrieve PodbyVvd .<br>
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String ydCd
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchPodbyVvd(String vslCd, String skdVoyNo, String skdDirCd, String ydCd) throws EventException;

	/**
	 * Retrieve MLB .<br>
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String ydCd
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchMlb(String vslCd, String skdVoyNo, String skdDirCd, String ydCd) throws EventException;

	/**
	 * Retrieve LOC .<br>
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String ydCd
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchLocInfo(String vslCd, String skdVoyNo, String skdDirCd, String ydCd) throws EventException;

	/**
	 * Retrieve CBF Booking Status .<br>
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String ydCd
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchCBFBS(String vslCd, String skdVoyNo, String skdDirCd, String ydCd) throws EventException;

	/**
	 * Check CBF save Info<br>
	 * 
	 * @param CBFListOptionVO cBFListOptionVO
	 * @return int
	 * @exception EventException
	 */
	public int checkCBFSave(CBFListOptionVO cBFListOptionVO) throws EventException;
	
	/**
	 * Delete CBFList Info<br>
	 * 
	 * @param CBFListOptionVO cBFListOptionVO
	 * @exception EventException
	 */
	public void removeCBFList(CBFListOptionVO cBFListOptionVO) throws EventException;

	/**
	 * Save OwnCBF Info.<br>
	 * 	 
	 * @param CBFListOptionVO cbfListOptionVO
	 * @param CBFListOptionVO[] cbfListVolumnVOs
	 * @param CBFListOptionVO[] cbfListSpecialVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageOwnCBF(CBFListOptionVO cbfListOptionVO, CBFListOptionVO[] cbfListVolumnVOs, CBFListOptionVO[] cbfListSpecialVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Retrieve CBF Summary .<br>
	 * 
	 * @param CBFSummaryVO cbfSummaryVO
	 * @return List<CBFSummaryVO>
	 * @exception EventException
	 */
	public List<CBFSummaryVO> calCBFSummary(CBFSummaryVO cbfSummaryVO) throws EventException;
	
	/**
	 * Retrieve CBF SpecialList .<br>
	 * 
	 * @param CBFSummaryVO cbfSummaryVO
	 * @return List<CBFSummaryVO>
	 * @exception EventException
	 */
	public List<CBFSummaryVO> searchCBFSpecialList(CBFSummaryVO cbfSummaryVO) throws EventException;
	
	/**
	 * Retrieve CBF Special Stwg .<br>
	 * 
	 * @param CBFSpecialStwgVO cbfSpecialStwgVO
	 * @return List<CBFSpecialStwgVO>
	 * @exception EventException
	 */
	public List<CBFSpecialStwgVO> searchCBFSpecialStwg(CBFSpecialStwgVO cbfSpecialStwgVO) throws EventException;

	/**
	 * Retrieve CBF Summary .<br>
	 *  
	 * @param CBFSummaryVO cbfSummaryVO
	 * @return List<CBFSummaryVO>
	 * @exception EventException
	 */
	public List<CBFSummaryVO> calCBFInquirySummary(CBFSummaryVO cbfSummaryVO) throws EventException;		
	
	/**
	 * Retrieve CBF Special Stwg .<br>
	 * 
	 * @param CBFSpecialStwgVO cbfSpecialStwgVO
	 * @return List<CBFSpecialStwgVO>
	 * @exception EventException
	 */
	public List<CBFSpecialStwgVO> searchCBFSpecialStwgPreview(CBFSpecialStwgVO cbfSpecialStwgVO) throws EventException;

	/**
	 * Retrieve CBF SpecialList .<br>
	 * 
	 * @param CBFSummaryVO cbfSummaryVO
	 * @return List<CBFSummaryVO>
	 * @exception EventException
	 */
	public List<CBFSummaryVO> searchCBFInquirySpecialList(CBFSummaryVO cbfSummaryVO) throws EventException;
	
	/**
	 * Retrieve CBF SpecialList .<br>
	 * 
	 * @param CBFListOptionVO cBFListOptionVO
	 * @return CBFListOptionVO
	 * @exception EventException
	 */
	public CBFListOptionVO searchCBFOwnSpecialList(CBFListOptionVO cBFListOptionVO) throws EventException;

	/**
	 * Retrieve OprPodMlbComboList .<br>
	 * 
	 * @return List<VskCarrierVO>
	 * @exception EventException
	 */	
	public List<VskCarrierVO> searchOprPodMlbComboList() throws EventException;

	/**
	 * Retrieve CBFSummaryPreviewHeader .<br>
	 * 
	 * @param  CBFSummaryVO cbfSummaryVO
	 * @return List<CBFSummaryVO>
	 * @exception EventException
	 */	
	public List<CBFSummaryVO> searchCBFSummaryPreviewHeaderList(CBFSummaryVO cbfSummaryVO) throws EventException;

	/**
	 * Retrieve CBFSummaryPreviewStwgCd .<br>
	 * 
	 * @param  CBFSummaryVO cbfSummaryVO
	 * @return List<CBFSummaryVO>
	 * @exception EventException
	 */	
	public List<CBFSummaryVO> searchCBFSummaryPreviewStwgCdList(CBFSummaryVO cbfSummaryVO) throws EventException;
	
	/**
	 *  Retrieve PartnerCBFList .<br>
	 * 
	 * @param CBFListOptionVO cBFListOptionVO
	 * @return List<CBFListOptionVO>
	 * @exception EventException
	 */
	public List<CBFListOptionVO> searchPartnerCBFList(CBFListOptionVO cBFListOptionVO) throws EventException;

	/**
	 *  Retrieve PartnerCBFSpecialList .<br>
	 * 
	 * @param CBFListOptionVO cBFListOptionVO
	 * @return List<CBFListOptionVO>
	 * @exception EventException
	 */
	public List<CBFListOptionVO> searchPartnerCBFSpecialList(CBFListOptionVO cBFListOptionVO) throws EventException;
	
	/**
	 * Save PartnerCBF Info.<br>
	 * 
	 * @param CBFListOptionVO[] cbfListOptionVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePartnerCBF(CBFListOptionVO[] cbfListOptionVOs,SignOnUserAccount account) throws EventException;	

	/**
	 *  Retrieve TP .<br>
	 * 
	 * @param PodComboVO podComboVO
	 * @return List<PodComboVO>
	 * @exception EventException
	 */
	public List<PodComboVO> searchTp(PodComboVO podComboVO) throws EventException;

	/**
	 *  Retrieve Weight Group .<br>
	 * 
	 * @param PodComboVO podComboVO
	 * @return String
	 * @exception EventException
	 */
	public String searchSingleWgp(PodComboVO podComboVO) throws EventException;

	/**
	 *  Retrieve Full Empty .<br>
	 * 
	 * @param PodComboVO podComboVO
	 * @return List<PodComboVO>
	 * @exception EventException
	 */
	public List<PodComboVO> searchFm(PodComboVO podComboVO) throws EventException;
	
	/**
	 *  Retrieve CGO .<br>
	 * 
	 * @param PodComboVO podComboVO
	 * @return List<PodComboVO>
	 * @exception EventException
	 */
	public List<PodComboVO> searchCgo(PodComboVO podComboVO) throws EventException;
	
	/**
	 *  Retrieve IMO .<br>
	 * 
	 * @param PodComboVO podComboVO
	 * @return List<PodComboVO>
	 * @exception EventException
	 */
	public List<PodComboVO> searchImo(PodComboVO podComboVO) throws EventException;

	/**
	 *  Retrieve PostExtd .<br>
	 * 
	 * @param PodComboVO podComboVO
	 * @return List<PodComboVO>
	 * @exception EventException
	 */
	public List<PodComboVO> searchPostExtd(PodComboVO podComboVO) throws EventException;

	/**
	 *  Retrieve STWG .<br>
	 * 
	 * @param PodComboVO podComboVO
	 * @return List<PodComboVO>
	 * @exception EventException
	 */
	public List<PodComboVO> searchStwg(PodComboVO podComboVO) throws EventException;

	/**
	 *  Check Partner Line CBF save Info<br>
	 * 
	 * @param CBFListOptionVO cBFListOptionVO
	 * @return int
	 * @exception EventException
	 */
	public int checkPCBFSave(CBFListOptionVO cBFListOptionVO) throws EventException;
	
	/**
	 *  Check Partner Line CBF save Info<br>
	 * 
	 * @param CBFListOptionVO cBFListOptionVO
	 * @return int
	 * @exception EventException
	 */
	public int checkPCBFSpecialSave(CBFListOptionVO cBFListOptionVO) throws EventException;
	
}