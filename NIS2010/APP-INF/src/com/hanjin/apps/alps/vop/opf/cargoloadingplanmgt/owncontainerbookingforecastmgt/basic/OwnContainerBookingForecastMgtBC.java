/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtBC.java
*@FileTitle : Weight Group (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 우지석
*@LastVersion : 1.0
* 2009.05.11 우지석
* 1.0 Creation
* 2016.05.20 CBF PARTNER EDI 추가
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFListOptionVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFIFSummaryListVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFAllSummaryPreviewVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFSpecialStwgVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFSummaryVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFIFSummaryDiffListVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFWgtGroupSummaryVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CargoBookingForecastVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.VskVslPortSkdCustVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.PodComboVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFPartnerEDIVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFPartnerConditionVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.SearchYardCodeVO;

import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.OpfPrnrEdiCgoBkgFcastVO;
import com.hanjin.syscommon.common.table.OpfPrnrEdiLogVO;
import com.hanjin.syscommon.common.table.VskCarrierVO;

/**
 * NIS2010-Cargoloadingplanmgt Business Logic Command Interface<br>
 * - NIS2010-Cargoloadingplanmgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Ji Seok Woo
 * @see Vop_opf-3019EventResponse 참조
 * @since J2EE 1.4
 */

public interface OwnContainerBookingForecastMgtBC {

	/**
	 * WeightGRPList 정보를 조회합니다.<br>
	 * 
	 * @param CargoBookingForecastVO cargoBookingForecastVO
	 * @return List<CargoBookingForecastVO>
	 * @exception EventException
	 */
	public List<CargoBookingForecastVO> searchWeightGRPList(CargoBookingForecastVO cargoBookingForecastVO) throws EventException;

	/**
	 * Weight Group 정보를 저장합니다. <br>
	 * 
	 * @param CargoBookingForecastVO[] cargoBookingForecastVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageWeightGRP(CargoBookingForecastVO[] cargoBookingForecastVO,SignOnUserAccount account) throws EventException;

	/**
	 * CBFVolumeList 정보를 조회합니다.<br>
	 * 
	 * @param CBFListOptionVO cBFListOptionVO
	 * @return List<List<CBFListOptionVO>>
	 * @exception EventException
	 */
	public List<List<CBFListOptionVO>> searchCBFVolumeList(CBFListOptionVO cBFListOptionVO) throws EventException;
	
	/**
	 * CBFBKGVolumeList 정보를 조회합니다.<br>
	 * 
	 * @param CBFListOptionVO cBFListOptionVO
	 * @return List<List<CBFListOptionVO>>
	 * @exception EventException
	 */
	public List<List<CBFListOptionVO>> searchCBFBKGVolumeList(CBFListOptionVO cBFListOptionVO) throws EventException;

	/**
	 * CBFSpecialList 정보를 조회합니다.<br>
	 * 
	 * @param CBFListOptionVO cbfListOptionVO
	 * @return List<CBFListOptionVO>
	 * @exception EventException
	 */
	public List<CBFListOptionVO> searchCBFVolumeSpecialList(CBFListOptionVO cbfListOptionVO) throws EventException;

	/**
	 * BKGVVD 정보를 확인합니다.<br>
	 * 
	 * @param CBFListOptionVO cbfListOptionVO
	 * @return int
	 * @exception EventException
	 */
	public int checkBKGVVD(CBFListOptionVO cbfListOptionVO) throws EventException;
	/**
	 * TurningPortSkipCall 정보를 확인합니다.
	 * 
	 * @param CBFListOptionVO cbfListOptionVO
	 * @return VskVslPortSkdCustVO
	 * @exception EventException
	 */
	public VskVslPortSkdCustVO checkTurningPortSkipCall(CBFListOptionVO cbfListOptionVO) throws EventException;

	/**
	 * POL 정보를 조회합니다.<br>
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchPol(String vslCd, String skdVoyNo, String skdDirCd) throws EventException;

	/**
	 * OPR 정보를 조회합니다.<br>
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
	 * PodbyVvd 정보를 조회합니다.<br>
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
	 * MLB 정보를 조회합니다.<br>
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
	 * LOC 정보를 조회합니다.<br>
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
	 * CBF Booking Status 정보를 조회합니다.<br>
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
	 * CBF Booking Status 정보를 조회합니다.<br>
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String ydCd
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchCBFHeaderInfo(String vslCd, String skdVoyNo, String skdDirCd, String ydCd) throws EventException;

	/**
	 * CBF 저장정보를 확인합니다.<br>
	 * 
	 * @param CBFListOptionVO cBFListOptionVO
	 * @return int
	 * @exception EventException
	 */
	public int checkCBFSave(CBFListOptionVO cBFListOptionVO) throws EventException;

	/**
	 * CBF Header 저장정보를 확인합니다.<br>
	 * 
	 * @param CBFListOptionVO cBFListOptionVO
	 * @return int
	 * @exception EventException
	 */
	public int checkCBFHeaderSave(CBFListOptionVO cBFListOptionVO) throws EventException;
	
	/**
	 * CBFList 정보를 삭제합니다.<br>
	 * 
	 * @param CBFListOptionVO cBFListOptionVO
	 * @exception EventException
	 */
	public void removeCBFList(CBFListOptionVO cBFListOptionVO) throws EventException;

	/**
	 * OwnCBF 정보를 저장합니다.<br>
	 * 	 
	 * @param CBFListOptionVO cbfListOptionVO
	 * @param CBFListOptionVO[] cbfListVolumnVOs
	 * @param CBFListOptionVO[] cbfListSpecialVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageOwnCBF(CBFListOptionVO cbfListOptionVO, CBFListOptionVO[] cbfListVolumnVOs, CBFListOptionVO[] cbfListSpecialVOs, SignOnUserAccount account) throws EventException;

	/**
	 * CBF Summary 정보를 조회합니다.<br>
	 * 
	 * @param CBFSummaryVO cbfSummaryVO
	 * @return List<CBFSummaryVO>
	 * @exception EventException
	 */
	public List<CBFSummaryVO> calCBFSummary(CBFSummaryVO cbfSummaryVO) throws EventException;
	
	/**
	 * CBF SpecialList 정보를 조회합니다.<br>
	 * 
	 * @param CBFSummaryVO cbfSummaryVO
	 * @return List<CBFSummaryVO>
	 * @exception EventException
	 */
	public List<CBFSummaryVO> searchCBFSpecialList(CBFSummaryVO cbfSummaryVO) throws EventException;
	
	/**
	 * CBF Special Stwg 정보를 조회합니다.<br>
	 * 
	 * @param CBFSpecialStwgVO cbfSpecialStwgVO
	 * @return List<CBFSpecialStwgVO>
	 * @exception EventException
	 */
	public List<CBFSpecialStwgVO> searchCBFSpecialStwg(CBFSpecialStwgVO cbfSpecialStwgVO) throws EventException;

	/**
	 * CBF Summary 정보를 조회합니다.<br>
	 *  
	 * @param CBFSummaryVO cbfSummaryVO
	 * @return List<CBFSummaryVO>
	 * @exception EventException
	 */
	public List<CBFSummaryVO> calCBFInquirySummary(CBFSummaryVO cbfSummaryVO) throws EventException;		
	
	/**
	 * CBF Special Stwg 정보를 조회합니다.<br>
	 * 
	 * @param CBFSpecialStwgVO cbfSpecialStwgVO
	 * @return List<CBFSpecialStwgVO>
	 * @exception EventException
	 */
	public List<CBFSpecialStwgVO> searchCBFSpecialStwgPreview(CBFSpecialStwgVO cbfSpecialStwgVO) throws EventException;

	/**
	 * CBF SpecialList 정보를 조회합니다.<br>
	 * 
	 * @param CBFSummaryVO cbfSummaryVO
	 * @return List<CBFSummaryVO>
	 * @exception EventException
	 */
	public List<CBFSummaryVO> searchCBFInquirySpecialList(CBFSummaryVO cbfSummaryVO) throws EventException;
	
	/**
	 * CBF SpecialList 정보를 조회합니다.<br>
	 * 
	 * @param CBFListOptionVO cBFListOptionVO
	 * @return CBFListOptionVO
	 * @exception EventException
	 */
	public CBFListOptionVO searchCBFOwnSpecialList(CBFListOptionVO cBFListOptionVO) throws EventException;

	/**
	 * OprPodMlbComboList 정보를 조회합니다.<br>
	 * 
	 * @return List<VskCarrierVO>
	 * @exception EventException
	 */	
	public List<VskCarrierVO> searchOprPodMlbComboList() throws EventException;

	/**
	 * CBFSummaryPreviewHeader 정보를 조회합니다.<br>
	 * 
	 * @param  CBFSummaryVO cbfSummaryVO
	 * @return List<CBFSummaryVO>
	 * @exception EventException
	 */	
	public List<CBFSummaryVO> searchCBFSummaryPreviewHeaderList(CBFSummaryVO cbfSummaryVO) throws EventException;

	/**
	 * CBFSummaryPreviewStwgCd 정보를 조회합니다.<br>
	 * 
	 * @param  CBFSummaryVO cbfSummaryVO
	 * @return List<CBFSummaryVO>
	 * @exception EventException
	 */	
	public List<CBFSummaryVO> searchCBFSummaryPreviewStwgCdList(CBFSummaryVO cbfSummaryVO) throws EventException;
	
	/**
	 *  PartnerCBFList 정보를 조회합니다.<br>
	 * 
	 * @param CBFListOptionVO cBFListOptionVO
	 * @return List<CBFListOptionVO>
	 * @exception EventException
	 */
	public List<CBFListOptionVO> searchPartnerCBFList(CBFListOptionVO cBFListOptionVO) throws EventException;

	/**
	 *  PartnerCBFSpecialList 정보를 조회합니다.<br>
	 * 
	 * @param CBFListOptionVO cBFListOptionVO
	 * @return List<CBFListOptionVO>
	 * @exception EventException
	 */
	public List<CBFListOptionVO> searchPartnerCBFSpecialList(CBFListOptionVO cBFListOptionVO) throws EventException;
	
	/**
	 * PartnerCBF 정보를 저장합니다.<br>
	 * 
	 * @param CBFListOptionVO[] cbfListOptionVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePartnerCBF(CBFListOptionVO[] cbfListOptionVOs,SignOnUserAccount account) throws EventException;	

	/**
	 *  TP 정보를 조회합니다.<br>
	 * 
	 * @param PodComboVO podComboVO
	 * @return List<PodComboVO>
	 * @exception EventException
	 */
	public List<PodComboVO> searchTp(PodComboVO podComboVO) throws EventException;

	/**
	 *  Weight Group 정보를 조회합니다.<br>
	 * 
	 * @param PodComboVO podComboVO
	 * @return String
	 * @exception EventException
	 */
	public String searchSingleWgp(PodComboVO podComboVO) throws EventException;

	/**
	 *  Full Empty 정보를 조회합니다.<br>
	 * 
	 * @param PodComboVO podComboVO
	 * @return List<PodComboVO>
	 * @exception EventException
	 */
	public List<PodComboVO> searchFm(PodComboVO podComboVO) throws EventException;
	
	/**
	 *  CGO 정보를 조회합니다.<br>
	 * 
	 * @param PodComboVO podComboVO
	 * @return List<PodComboVO>
	 * @exception EventException
	 */
	public List<PodComboVO> searchCgo(PodComboVO podComboVO) throws EventException;
	
	/**
	 *  IMO 정보를 조회합니다.<br>
	 * 
	 * @param PodComboVO podComboVO
	 * @return List<PodComboVO>
	 * @exception EventException
	 */
	public List<PodComboVO> searchImo(PodComboVO podComboVO) throws EventException;

	/**
	 *  PostExtd 정보를 조회합니다.<br>
	 * 
	 * @param PodComboVO podComboVO
	 * @return List<PodComboVO>
	 * @exception EventException
	 */
	public List<PodComboVO> searchPostExtd(PodComboVO podComboVO) throws EventException;

	/**
	 *  STWG 정보를 조회합니다.<br>
	 * 
	 * @param PodComboVO podComboVO
	 * @return List<PodComboVO>
	 * @exception EventException
	 */
	public List<PodComboVO> searchStwg(PodComboVO podComboVO) throws EventException;

	/**
	 *  Partner Line CBF 저장정보를 확인합니다.<br>
	 * 
	 * @param CBFListOptionVO cBFListOptionVO
	 * @return int
	 * @exception EventException
	 */
	public int checkPCBFSave(CBFListOptionVO cBFListOptionVO) throws EventException;
	
	/**
	 *  Partner Line CBF 저장정보를 확인합니다.<br>
	 * 
	 * @param CBFListOptionVO cBFListOptionVO
	 * @return int
	 * @exception EventException
	 */
	public int checkPCBFSpecialSave(CBFListOptionVO cBFListOptionVO) throws EventException;

	/**
	 * 조회조건 Carrier Combo 정보를 조회합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @return List<List<CBFIFSummaryListVO>>
	 * @exception EventException
	 */
	public List<CBFIFSummaryListVO> searchCBFIFCarrierList(CBFIFSummaryListVO cBFIFSummaryListVO) throws EventException;
	
	/**
	 * Carrier Type/Size 정보를 체크합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @return String
	 * @exception EventException
	 */
	public String checkTypeSize(CBFIFSummaryListVO cBFIFSummaryListVO) throws EventException;
	
	/**
	 * VVD 정보를 체크합니다.<br>
	 * 
	 * @param CBFPartnerEDIVO cBFPartnerEDIVO
	 * @return String
	 * @exception EventException
	 */
	public String checkVvdExist(CBFPartnerEDIVO cBFPartnerEDIVO) throws EventException ;
	
	/**
	 * Carrier Type/Size 정보를 체크합니다.<br>
	 * 
	 * @param CBFPartnerEDIVO cBFPartnerEDIVO
	 * @return String
	 * @exception EventException
	 */
	public String checkTypeSizeCd(CBFPartnerEDIVO cBFPartnerEDIVO) throws EventException ;
	
	/**
	 * YARD CODE 정보를 가져온다.<br>
	 * 
	 * @param CBFPartnerEDIVO cBFPartnerEDIVO
	 * @return List<SearchYardCodeVO>
	 * @exception EventException
	 */
	public List<SearchYardCodeVO> checkYardCd(CBFPartnerEDIVO cBFPartnerEDIVO) throws EventException ;
	
	
	/**
	 * Pod Code 정보를 체크합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @return String
	 * @exception EventException
	 */
	public String checkTypePodCd(CBFIFSummaryListVO cBFIFSummaryListVO) throws EventException;
	
	/**
	 * KOREA 세관신고CLL과 BOOKING 데이터 비교<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @return String
	 * @exception EventException
	 */
	public String checkCllDiff(CBFIFSummaryListVO cBFIFSummaryListVO) throws EventException;

	/**
	 * 조회조건 POD Combo 정보를 조회합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @return List<List<CBFIFSummaryListVO>>
	 * @exception EventException
	 */
	public List<CBFIFSummaryListVO> searchCBFIFPodList(CBFIFSummaryListVO cBFIFSummaryListVO) throws EventException;

	/**
	 * Dg, Awk, Stwg, Rf, Bb, Mty, Bn POD Combo 정보를 조회합니다.<br>  
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @return List<List<CBFIFSummaryListVO>>
	 * @exception EventException
	 */
	public List<CBFIFSummaryListVO> searchCBFIFOprPodList(CBFIFSummaryListVO cBFIFSummaryListVO) throws EventException;

	/**
	 * Dg - UN NO. Combo 정보를 조회합니다.<br>  
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @return List<List<CBFIFSummaryListVO>>
	 * @exception EventException
	 */
	public List<CBFIFSummaryListVO> searchCBFIFDgUnNoList(CBFIFSummaryListVO cBFIFSummaryListVO) throws EventException;

	/**
	 * Special STWG Combo 정보를 조회합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @return List<List<CBFIFSummaryListVO>>
	 * @exception EventException
	 */
	public List<CBFIFSummaryListVO> searchCBFIFSTWGList(CBFIFSummaryListVO cBFIFSummaryListVO) throws EventException;

	/**
	 *  Weight 정보를 조회합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @return String
	 * @exception EventException
	 */
	public String searchCgoGrsWgt(CBFIFSummaryListVO cBFIFSummaryListVO) throws EventException;

	/**
	 *  OPR HJS의 등록여부 정보를 조회합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @return String
	 * @exception EventException
	 */
	public String searchOprHJSExist(CBFIFSummaryListVO cBFIFSummaryListVO) throws EventException;
	
	/**
	 * CBF - Creation 정보를 조회합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @return List<List<CBFIFSummaryListVO>>
	 * @exception EventException
	 */
	public List<List<CBFIFSummaryListVO>> searchCBFIFSummaryList(CBFIFSummaryListVO cBFIFSummaryListVO) throws EventException;

	/**
	 * CBF - Creation 정보를 저장합니다.<br>
	 * 	 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @param CBFIFSummaryListVO[] cBFIFSummaryListVOs
	 * @param CBFIFSummaryListVO[] cbfIFSummarySpecialListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCBFIFSummary(CBFIFSummaryListVO cBFIFSummaryListVO, CBFIFSummaryListVO[] cBFIFSummaryListVOs, CBFIFSummaryListVO[] cbfIFSummarySpecialListVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * CBF - Creation 정보를 삭제합니다.<br>
	 * 	 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @exception EventException
	 */
	public void manageCBFDelete(CBFIFSummaryListVO cBFIFSummaryListVO) throws EventException;
	
	
	/**
	 * CBF - Creation : Over Dimension 정보를 조회합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @return List<List<CBFIFSummaryListVO>>
	 * @exception EventException
	 */
	public List<List<CBFIFSummaryListVO>> searchCBFIFSummaryOverDmsList(CBFIFSummaryListVO cBFIFSummaryListVO) throws EventException;
	
	/**
	 * CBF - Creation : Carrier 정보를 조회합니다. <br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @return List<List<CBFIFSummaryListVO>>
	 * @exception EventException
	 */
	public List<List<CBFIFSummaryListVO>> searchCBFIFSummaryCarrierAllList(CBFIFSummaryListVO cBFIFSummaryListVO) throws EventException;
	
	/**
	 * CBF ALLSummary 정보를 조회합니다.<br>
	 * 
	 * @param  String vvd  
	 * @param  String ydCd
	 * @param  String polclptindseq
	 * @return List<CBFAllSummaryPreviewVO>
	 * @exception EventException
	 */
	public List<CBFAllSummaryPreviewVO> searchCBFAllSummary(String vvd,  String ydCd, String polclptindseq) throws EventException;
	
	/**
	 * CBF: CLL과 BOOKING DATA 비교 LIST<br>
	 * 
	 * @param  String vvd  
	 * @param  String ydCd
	 * @param  String polclptindseq
	 * @return List<CBFIFSummaryDiffListVO>
	 * @exception EventException
	 */
	public List<CBFIFSummaryDiffListVO> searchCBFIFSummaryDiffCntrList(String vvd,  String ydCd, String polclptindseq) throws EventException;
	
	/**
	 * CBF: Partner CLL EDI LIST<br>
	 * 
	 * @param  CBFPartnerConditionVO cBFPartnerConditionVO
	 * @return List<CBFPartnerEDIVO>
	 * @exception EventException
	 */
	public List<CBFPartnerEDIVO> searchCBFPartnerEDIList(CBFPartnerConditionVO cBFPartnerConditionVO) throws EventException;
	
	/**
	 *   PARTNER EDI 수신 전 MANUAL 입력 데이터 존재 여부<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @return String
	 * @exception EventException
	 */
	public String checkPartnerEdiExist(CBFIFSummaryListVO cBFIFSummaryListVO) throws EventException ;	

	
	/**
	 * CBF: Partner CLL EDI LIST를 저장함.<br>
	 * 
	 * @param CBFPartnerEDIVO[] cBFPartnerEDIVOS 
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCBFPartnerEDI(CBFPartnerEDIVO[] cBFPartnerEDIVOS , SignOnUserAccount account) throws EventException;
	
	/**
	 * OPF EDIT 전문 List 정렬 후 저장
	 * @param ediFlatFile
	 * @param opfPrnrEdiLogVO
	 * @throws EventException
	 */
	public void addOpfPartnerEdiCgoBkgFcast(String ediFlatFile, OpfPrnrEdiLogVO opfPrnrEdiLogVO) throws EventException;
	
	/**
	 * OPF EDI 전문 최초 진입 로그 저장
	 * @return OpfPrnrEdiLogVO
	 * @throws EventException
	 */
	public OpfPrnrEdiLogVO addOpfPartnerEdiCBFLog() throws EventException;
	
	/**
	 * CBF - POD 삭제시 해당 POD의 SPECIAL 데이터가 있는지 확인하기 위함 <br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @return String
	 * @exception EventException
	 */
	public String searchCBFIFSpecialExist(CBFIFSummaryListVO cBFIFSummaryListVO) throws EventException;
	
	/**
	 * CBF: WGT GROUP SUMMARY 조회 <br>
	 * 
	 * @param  CBFWgtGroupSummaryVO cBFWgtGroupSummaryVO
	 * @return List<CBFWgtGroupSummaryVO>
	 * @exception EventException
	 */
	public List<CBFWgtGroupSummaryVO> searchCBFWgtGroupSummary(CBFWgtGroupSummaryVO cBFWgtGroupSummaryVO) throws EventException;
	
	/**
	 * OPF EDI 데이터 수정
	 * @param CBFWgtGroupSummaryVO[] cBFWgtGroupSummaryVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageCBFWgtGroupSummary(CBFWgtGroupSummaryVO[] cBFWgtGroupSummaryVOS, SignOnUserAccount account) throws EventException;
	
}