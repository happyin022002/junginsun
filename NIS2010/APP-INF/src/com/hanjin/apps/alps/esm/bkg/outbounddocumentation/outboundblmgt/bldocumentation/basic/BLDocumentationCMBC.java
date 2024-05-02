/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BLDocumentationCMBC.java
 *@FileTitle : Container No Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.24
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.04.24 김영출
 * 1.0 Creation
----------------------------------------------------------
 * 2010.12.21 최도순 [CHM-201007310] BKG C/M 화면에 DG SEQ 선택 필드 (구주 24 HR)
 * 2011.01.25 이일민 [CHM-201108410-01] [CSR] Container OC History Table 항목 추가
 * 2011.05.16 이일민 [CHM-201110332] ALPS Transshipment 메뉴 오류 수정요청
 * 2012.07.09 전성진 [] booking re-activate 기능 보완, Container cancel 원복처리 추가
=========================================================*/


package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic;

import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CrossItemVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgBookingInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SelectCntrVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.RfCgoApplVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgBlActWgtVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgCopyCntrCmByBkgVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgCustShpRqstVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgListForGeneralTmlVermasEdiVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgListForTmlVermasEdiInputVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmByCntrVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmCopyVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrAdjVolVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrCopyVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrDetailInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrEtcInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrInfoOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrKrWhfExptVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.ContainerVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CreateBkgBlDocBkgVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.EdiNotUpdCntrVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.RataBkgQtyVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCntrMfDescVO;
import com.hanjin.syscommon.common.table.BkgCntrSealNoVO;
import com.hanjin.syscommon.common.table.BkgContainerVO;
import com.hanjin.syscommon.common.table.BkgDgCgoVO;
import com.hanjin.syscommon.common.table.MstContainerVO;

/**
 * ALPS-Outboundblmgt Business Logic Command Interface<br>
 * - ALPS-Outboundblmgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim Youngchul
 * @see Ui_bkg-0892EventResponse 참조
 * @since J2EE 1.4
 */
  
public interface BLDocumentationCMBC {

    /**
     * T.VVD 및 BKG Offce, POL, POD 를 기준으로 C/M을 Copy 하기 위해 Container 별로 조회한다.<br>
     * 
     * @param vvd
     * @param ofcCd
     * @param pol
     * @param pod
     * @param cfmYn
     * @return List<CmCopyVO>
     * @exception EventException
     */
    public List<CmCopyVO> searchCntrListByVvd(String vvd, String ofcCd, String pol, String pod, String cfmYn) throws EventException;

    /**
     * container seal number 정보를 조회한다.
     * @param bkgBlNoVO
     * @return List<BkgBlNoVO>
     * @exception EventException
     */
    public List<BkgBlNoVO> searchMultiSeal(BkgBlNoVO bkgBlNoVO) throws EventException;

    /**
     * 조회 이벤트 처리<br>
     * BLDocumentation화면에 대한 조회 이벤트 처리<br>
     * 
     * @param bkgNo String
     * @return List<EdiNotUpdCntrVO>
     * @exception EventException
     */
    public List<EdiNotUpdCntrVO> searchNotUpdCntr(String bkgNo) throws EventException;

    /**
     * 조회 이벤트 처리<br>
     * BLDocumentation화면에 대한 조회 이벤트 처리<br>
     * 
     * @param cntrNo String
     * @return CntrDetailInfoVO
     * @exception EventException
     */
    public CntrDetailInfoVO searchCntrDtlInfo(String cntrNo) throws EventException;

    /**
     * VVD 및 Container No가 같은 Partial Container Booking중에 Container Confirm 상태가 된 BKG가 있는지 확인한다. -- UI_BKG-0079-04
     * @param bkgNo
     * @param cntrNo
     * @return String
     * @exception EventException
     */
    public String searchPartialConfirm(String bkgNo, String cntrNo) throws EventException;
    
    /**
     * container 정보를 조회한다. -- UI_BKG-0172, 
     * BKG CONTAINER, BKG CONTAINER SEAL NUMBER, BKG BOOKING, BKG DOCUMENT PROCESS SCHEDULE, BKG RATE 등
     * @param bkgNo
     * @param caFlg 
     * @return CntrInfoOutVO
     * @exception EventException
     */
    public CntrInfoOutVO searchContainer(String bkgNo, String caFlg) throws EventException;

    /**
     * container 정보를 생성/수정 한다.
     * 
     * @param updateVoList
     * @param caFlg 
     * @exception EventException
     */
    public void manageContainer(List<ContainerVO> updateVoList, String caFlg) throws EventException;

    /**
     * container 정보를 생성/수정 한다.
     * 
     * @param updateVoList
     * @param caFlg 
     * @exception EventException
     */
    public void manageContainerByXter(List<ContainerVO> updateVoList, String caFlg) throws EventException;

    /**
     * Container를 다른 booking으로 복사한다. -- UI_BKG-0170, BKG CONTAINER
     * @param cntrCopyVO
     * @exception EventException
     */
    public void copyContainer(CntrCopyVO cntrCopyVO) throws EventException;

    /**
     * container 정보를 다른 booking으로 옮긴다. -- UI_BKG-0170, BKG CONTAINER
     * @param bkgNo
     * @param cntrNo
     * @param caFlg
     * @exception EventException
     */
    public void moveContainer(String bkgNo, String cntrNo, String caFlg) throws EventException;

    /**
     * container 정보를 저장가능한지 확인한다.
     * BC 내부 메소드
     * @param bkgEtcInfoVO
     * @param containerVOs
     * @param fnlCfmFlg
     * @return List<Map<String,Object>>
     * @exception EventException
     */
    public List<Map<String,Object>> validateContainer(CntrEtcInfoVO bkgEtcInfoVO, ContainerVO[] containerVOs, String fnlCfmFlg) throws EventException;

    /**
     * container confirm이 가능한지 확인한다.
     * BC 내부 메소드
     * @param bkgEtcInfoVO
     * @param containerVOs
     * @param fnlCfmFlg
     * @exception EventException
     */
    public void validateContainerConfirm(CntrEtcInfoVO bkgEtcInfoVO, ContainerVO[] containerVOs, String fnlCfmFlg) throws EventException;

    /**
     * Container의 Vol 및 Partial Flag를 업데이트 한다.. UI_BKG-0170
     * @param cntrCopyVO
     * @exception EventException
     */
    public void modifyCntrVol(CntrCopyVO cntrCopyVO) throws EventException;

    /**
     * container manifest 정보를 조회한다.-- UI_BKG-0079-07
     * @param bkgNo
     * @param caFlg 
     * @return CmVO
     * @exception EventException
     */
    public CmVO searchCm(String bkgNo, String caFlg) throws EventException;

    /**
     * container manifest 정보를 저장가능한지 확인한다.
     * @param cmVO
     * @exception EventException
     */
    public void validateCm(CmVO cmVO) throws EventException;

    /**
     * container manifest 정보를 생성한다. -- UI_BKG-0079-07, UI_BKG-0178, BKG CONTAINER MANIFEST DESCRIPTION
     * @param cmVO
     * @param account
     * @param caFlg 
     * @exception EventException
     */
    public void manageCm(CmVO cmVO, SignOnUserAccount account, String caFlg) throws EventException;

    /**
     *  Container의 Term을 Bkg에 맞춰서 변경한다..(ESM_BKG_0079_01) -> modifyBooking<br>
     * @author  KimByungKyu
     * @param   BkgContainerVO bkgContainerVO
	 * @param 		BkgBlNoVO bkgBlNoVO
     * @exception   EventException
     */
    public void modifyCntrRDTerm(BkgContainerVO bkgContainerVO, BkgBlNoVO bkgBlNoVO) throws EventException;

    /**
     * Container Seal No 정보를 업데이트 한다.
     * 
     * @param updateSealVoList
     * @param caFlg
     * @exception EventException
     */
    public void manageCntrSealNo(List<BkgCntrSealNoVO> updateSealVoList, String caFlg) throws EventException;

    /**
     * Container Seal No.를 삭제한다. -- UI_BKG-0170, UI_BKG-0079-04
     * 
     * @param bkgNo
     * @param cntrNo
     * @param cntr_seal_seq
     * @param caFlg
     * @exception EventException
     */
    public void removeCntrSealNo(String bkgNo, String cntrNo, String cntr_seal_seq, String caFlg) throws EventException;

    /**
     * ContainerSeal No.를 삭제한다. -- UI_BKG-0170, UI_BKG-0079-04
     * @param deleteSealVoList
     * @param caFlg 
     * @exception EventException
     */
    public void removeCntrSealNo(List<BkgCntrSealNoVO> deleteSealVoList, String caFlg) throws EventException;

    /**
     * Container Manifest Desc. 를 삭제한다. -- UI_BKG-0170, UI_BKG-0079-04
     * 
     * @param bkgNo
     * @param cntrNo
     * @param caFlg
     * @exception EventException
     */
    public void removeCntrMfDesc(String bkgNo, String cntrNo, String caFlg) throws EventException;

    /**
     * Container Manifest Desc. 를 변경한다.
     * @param bkgNo
     * @param cntrNo
     * @param cntrNoOld
     * @param caFlg 
     * @exception EventException
     */
    public void changeCntrMfDesc(String bkgNo, String cntrNo, String cntrNoOld, String caFlg) throws EventException;

    
    /**
     * Container Seal No. 를 변경한다.
     * @param bkgNo
     * @param cntrNo
     * @param cntrNoOld
     * @param caFlg 
     * @exception EventException
     */
    public void changeCntrSealNo(String bkgNo, String cntrNo, String cntrNoOld, String caFlg) throws EventException;

    
    /**
     * Container를 추가한다.
     * @param containerVO
     * @param caFlg 
     * @exception EventException
     */
    public void insertContainer(ContainerVO containerVO, String caFlg) throws EventException;

    /**
     * container 정보를 수정한다.
     * 
     * @param containerVO
     * @param caFlg
     * @exception EventException
     */
    public void modifyContainer(ContainerVO containerVO, String caFlg) throws EventException;

    /**
     * container Confirm 정보를 수정 한다.
     * 
     * @param String bkgNo
     * @param String cfmFlg
     * @param String caFlg
     * @exception EventException
     */
    public void modifyCntrCfmFlg(String bkgNo, String cfmFlg, String caFlg) throws EventException;
    
    /**
     * Container를 삭제한다
     * @param bkgNo
     * @param cntrNo
     * @param caFlg 
     * @exception EventException
     */
    public void removeContainer(String bkgNo, String cntrNo, String caFlg) throws EventException;

//    /**
//     * act_wgt와 wgt_ut_cd를 update한다.(ESM_BKG_0079_01) -> modifyBooking<br>
//     * 
//     * @author      KimByungKyu
//     * @param       BkgBlNoVO bkgBlNoVO
//     * @param       String actWgt
//     * @param       String wgtUtCd
//     * @param       String oldPodNodCd
//     * @param       String oldDelNodCd
//     * @param       SignOnUserAccount account
//     * @exception   EventException
//     */
//    public void modifyBlActWgt(BkgBlNoVO bkgBlNoVO, String actWgt, String wgtUtCd, String oldPodNodCd, String oldDelNodCd, SignOnUserAccount account) throws EventException;

    /**
     * act_wgt와 wgt_ut_cd를 update한다.(ESM_BKG_0079_01) -> modifyBooking<br>
     * 
     * @author      KimByungKyu
     * @param       BkgBlNoVO bkgBlNoVO
     * @param       BkgBlActWgtVO bkgBlActWgtVO
     * @param       SignOnUserAccount account
     * @exception   EventException
     */
    public void modifyBlActWgt(BkgBlNoVO bkgBlNoVO, BkgBlActWgtVO bkgBlActWgtVO, SignOnUserAccount account) throws EventException;
	/**
	 *  Container를 Cancel한다.(ESM_BKG_0079_01) -> modifyBooking<br>
	 *  
	 * @author 		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
    public void cancelBkgCntr(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException;

	/**
	 *  Container를 Activate한다.(ESM_BKG_0000_1) -> reactivateBooking<br>
	 *  
	 * @author 		Jeon Sung Jin
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
    public void activateBkgCntr(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException;
    
    /**
     * combine/split시에 sourceBkg에서 bkg_cntr, bkg_cntr_seal_no를 읽어서 targetBkg에 insert한다.<br>
     * 
     * @param String copyModeCd
     * @param BkgBlNoVO sourceBkg
     * @param BkgBlNoVO[] targetBkg
     * @param List<SelectCntrVO> selectCntrVO
     * @param SignOnUserAccount account
     * @param String hitchmentYn
     * @exception EventException
     */
   // public void copyCntrCmByBkg(String copyModeCd, BkgBlNoVO sourceBkg, BkgBlNoVO[] targetBkg, List<SelectCntrVO>selectCntrVO, SignOnUserAccount account, String hitchmentYn) throws EventException;
    
    /**
     * combine/split시에 sourceBkg에서 bkg_cntr, bkg_cntr_seal_no를 읽어서 targetBkg에 insert한다.<br>
     * 
     * @param BkgBlNoVO sourceBkg
     * @param BkgBlNoVO[] targetBkg
     * @param List<SelectCntrVO> selectCntrVO
     * @param BkgCopyCntrCmByBkgVO bkgCopyCntrCmByBkgVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyCntrCmByBkg(BkgBlNoVO sourceBkg, BkgBlNoVO[] targetBkg, List<SelectCntrVO> selectCntrVO, BkgCopyCntrCmByBkgVO bkgCopyCntrCmByBkgVO ,SignOnUserAccount account) throws EventException;

    /**
     * multi split시에 sourceBkg에서 bkg_cntr, bkg_cntr_seal_no를 읽어서 targetBkg에 insert한다.<br>
     * 
     * @param BkgBlNoVO sourceBkg
     * @param BkgBlNoVO[] targetBkg
     * @param List<SelectCntrVO> orgSelectCntrVO
     * @param List<SelectCntrVO> selectCntrVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
	public void copyCntrCmByBkgMulti(BkgBlNoVO sourceBkg, BkgBlNoVO[] targetBkg,
			List<SelectCntrVO> orgSelectCntrVO, List<SelectCntrVO> selectCntrVO,
			SignOnUserAccount account) throws EventException;
	
    /**
	 *  Container의 Bkg_no에 따라 awk_cgo_flg 값을 변경한다..(ESM_BKG_0055) 	 
	 * @param 	bkgNo 
	 * @param 	spclTp 
	 * @param   cntrNo
	 * @param   caFlg
	 * @return	int
	 * @exception 	EventException
	 */        
    public int modifyCntrFlgBySpcl(String bkgNo, String spclTp, String cntrNo, String caFlg) throws EventException;
    
    /**
	 *  Container의 Bkg_no에 따라 awk_cgo_flg 값을 변경한다..(ESM_BKG_0055) 	 
	 * @param 	bkgNo 
	 * @param 	spclTp 
	 * @param   cntrNo
	 * @param   caFlg
	 * @exception 	EventException
	 */        
    public void modifyCntrFlgBySpcl2(String bkgNo, String spclTp, String cntrNo, String caFlg) throws EventException;
    
    /**
	 *  Container의 Bkg_no에 따라 awk_cgo_flg 값을 변경한다..(ESM_BKG_0055) 	 
	 * @param 	bkgNo 
	 * @param 	caFlg 
	 * @exception 	EventException
	 */        
    public void modifyCntrFlgBySpcl3(String bkgNo, String caFlg) throws EventException;

    /**
     * container에 해당하는 manifest 정보를 조회한다.-- UI_BKG-0178
     * @param cntrNo
     * @param vvd
     * @return CmByCntrVO
     * @exception EventException
     */
    public CmByCntrVO searchCmByCntr(String cntrNo, String vvd) throws EventException;

    /**
     * 컨테이너별로 C/M을 입력/수정/삭제한다 -- UI_BKG-0178
     * @param cmVO
     * @param account
     * @param caFlg 
     * @exception EventException
     */
    public void manageCmByCntr(CmByCntrVO cmVO, SignOnUserAccount account, String caFlg) throws EventException;

    /**
     * container manifest 정보를 조회한다.-- UI_BKG-0079-07, UI_BKG-0178, BKG CONTAINER MANIFEST DESCRIPTION
     * 
     * @param bkgNo
     * @param caFlg
     * @return List<BkgCntrMfDescVO>
     * @exception EventException
     */
    public List<BkgCntrMfDescVO> searchCntrMfDesc(String bkgNo, String caFlg) throws EventException;

    /**
     * container 정보를 생성한다. 
     * -- UI_BKG-0172, BKG CONTAINER, BKG CONTAINER SEAL NUMBER, BKG BOOKING, BKG DOCUMENT PROCESS SCHEDULE, BKG RATE 등
     * @param containerVOs
     * @param bkgCntrSealNoVOs
     * @param usrId
     * @exception EventException
     */
    public void manageCntrByXter(ContainerVO[] containerVOs, BkgCntrSealNoVO[] bkgCntrSealNoVOs, String usrId) throws EventException;

    /**
     * Total Package in Word 업데이트 전에, O.B/L Issue 여부를 검색한다.
     *
     * @author KimYoungchul
     * @param bkgNo
     * @param caFlg
     * @return String
     * @exception EventException
     */
    public String searchBlIssFlg(String bkgNo, String caFlg) throws EventException;
    
    /**
     * Doc Process의 상태를 조회한다.
     * 
     * @param tgtBkgNo
     * @param caFlg
     * @return String
     * @exception EventException
     */
    public String searchDocProcessByCntr(String tgtBkgNo, String caFlg) throws EventException;

    /**
     * BKG Qty와 CNTR의 Qty가 다른 경우 Container Final Confirm을 하면 M&D의 Total Package in Word를 업데이트 한다.(BKG_BL_DOC.TTL_PCK_DESC)
     * 
     * @param bkgNo
     * @param caFlg 
     * @exception EventException
     */
    public void modifyBlByFinalCfm(String bkgNo, String caFlg) throws EventException;

    /**
     * Partial Container Volume 조정시 관련 같은 VVD에서 같은 Container를 사용하는 BKG No. 및 Vol을 조회한다. -- UI_BKG-1050
     * @param bkgNo
     * @param cntrNo
     * @return List<CntrAdjVolVO>
     * @exception EventException
     */
    public List<CntrAdjVolVO> searchCntrAdjVol(String bkgNo, String cntrNo) throws EventException;
    
    /**
     * Search Container Count.
     *
     * @author KimYoungchul
     * @param bkgNo
     * @param caFlg
     * @return String
     * @exception EventException
     */
    public String searchCntrKnt(String bkgNo, String caFlg) throws EventException;
    
    /**
     * Partial Container Volume 조정시 관련 같은 VVD에서 같은 Container를 사용하는 BKG No. 및 Vol을 조회한다. -- UI_BKG-1050
     * @param bkgNo
     * @param caFlg
     * @return List<RataBkgQtyVO>
     * @exception EventException
     */
    public List<RataBkgQtyVO> searchBkgCntrVol(String bkgNo, String caFlg) throws EventException;

    /**
     * Container의 Vol 및 Partial Flag를 업데이트 한다.. UI_BKG-0170
     * 
     * @param cntrAdjVolVO 
     * @param caFlg
     * @exception EventException
     */
    public void modifyCntrVol(CntrAdjVolVO cntrAdjVolVO, String caFlg) throws EventException;
    
	/**
	 * sourceBkg의 bkg_bl_doc을 targetBkg로 복사한다.
	 * 
	 * @author 		KimByungKyu
	 * @param  		String trnkVslCd
	 * @param 		String preVslCd
	 * @param 		BkgBlNoVO sourceBkg
	 * @param 		BkgBlNoVO targetBkg
	 * @param 		SignOnUserAccount account
     * @exception 	EventException
     */    
    public void copyBkgBlDoc( String trnkVslCd , String preVslCd , BkgBlNoVO sourceBkg , BkgBlNoVO targetBkg, SignOnUserAccount account) throws EventException;
    
	/**
	 *  BKG_BL_DOC 저장.(ESM_BKG_0079_01) -> createBooking<br>
	 *  
	 * @author 		KimByungKyu
	 * @param 		String bkgNo
	 * @param 		String blMvTpNm
	 * @param       String fnlDestNm 
	 * @param 		String actWgt
	 * @param 		String wgtUtCd
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
    //public void createBkgBlDocByBKG(String bkgNo, String blMvTpNm, String fnlDestNm, String actWgt, String wgtUtCd, SignOnUserAccount account) throws EventException;
    
    /**
	 *  BKG_BL_DOC 저장.(ESM_BKG_0079_01) -> createBooking<br>
	 *  
	 * @author 		WonJooCho
	 * @param 		CreateBkgBlDocBkgVO createBkgBlDocBkgVO
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
    public void createBkgBlDocByBKG(CreateBkgBlDocBkgVO createBkgBlDocBkgVO, SignOnUserAccount account) throws EventException;
    
    /**
     * Movement에서 MT Repo. Booking의 경우 VL 상태일 때 Contanier를 삭제하면 Movement Cycle을 9999로 업데이트 한다..
     *  
     * @param bkgNo
     * @param cntrNo
     * @param cnmvCycNo
     * @param cnmvDtTm
     * @exception EventException
     */
    public void modifyCycleByCtm(String bkgNo, String cntrNo, String cnmvCycNo, String cnmvDtTm) throws EventException;

    /**
     * CTM 에서 호출하는 ContainerMovementMgt 처리<br>
     * Exception 처리를 하면 안된다고 함.<br>
     * - 담당자 : 우경민[EO]
     * @param item
     * @return boolean
     * @exception EventException
     */
    public boolean modifyCntrOp(CrossItemVO item) throws EventException;
    
    /**
     * CTM 에서 호출하는 Container History Update를 위한 메소드.<br>
     * - 담당자 : 우경민[EO]
     *
     * @param vo CusCtmMovementVO 
     * @param delFlg String 
     * @exception EventException
     */
    public void modifyCntrHistoryUpdate(CusCtmMovementVO vo, String delFlg) throws EventException;

    /**
     * manage CmByHbl
     * 
     * @param hblVO
     * @param account
     * @param caFlg
     */
    public void manageCmByHbl(HblVO hblVO, SignOnUserAccount account, String caFlg) throws EventException;

	/**
	 * bkg_container 테이블에 한국 WHF CNTR별 Exception 정보를  update한다.<br>
	 * 
	 * @param List<CntrKrWhfExptVO> cntrKrWhfExptVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyCntrKrWhfExpt (List<CntrKrWhfExptVO> cntrKrWhfExptVOs, SignOnUserAccount account)throws EventException;
	
    /**
     * MstContainer정보 조회
     * 
     * @author KimByungKyu
     * @param cntrNo
     * @return MstContainerVO
     * @exception EventException
     */
    public MstContainerVO searchMstCntrForMst(String cntrNo) throws EventException;

    /**
     * Update C/M by container wgt./meas. unit
     * 
     * @author KimYoungchul
     * @param bkgNo
     * @param bkgWgtUtCd
     * @param bkgMeasUtCd
     * @param account
     * @param caFlg
     * @exception EventException
     */
    public void modiftyCmUnitByCntr(String bkgNo, String bkgWgtUtCd, String bkgMeasUtCd, SignOnUserAccount account, String caFlg) throws EventException;
    
    /**
     * container manifest 정보를 생성한다. -- UI_BKG_0229_05, BKG CONTAINER MANIFEST DESCRIPTION
     * 
     * @param cmVO
     * @param account
     * @param caFlg 
     * @exception EventException
     */
	public void manageCmByXter(CmVO cmVO, SignOnUserAccount account, String caFlg) throws EventException;
	
    /**
     * bkg의 route name을 update한다.
     * 
     * @param BkgBlNoVO bkgBlNoVO
     * @param BkgBookingInfoVO bkgBookingInfoVO 
     * @param account
     * @exception EventException
     */
	public void modifyBkgRouteNm(BkgBlNoVO bkgBlNoVO, BkgBookingInfoVO bkgBookingInfoVO, SignOnUserAccount account) throws EventException;

	/**
     * split 후 cntr별 special cargo flag를 재 계산한다.
     * 
     * @param BkgBlNoVO[] targetBkg
     * @param SignOnUserAccount account
     * @exception EventException
     */
	public void modifyCntrSpclFlag(BkgBlNoVO[] targetBkg, SignOnUserAccount account) throws EventException;	

	/**
     * cntr의 cgo_rcv_dt를 update
     * 
     * @param ContainerVO[] containerVOs
     * @param String caFlg
     * @param SignOnUserAccount account
     * @exception EventException
     */
	public void modifyCrdDt(ContainerVO[] containerVOs, String caFlg, SignOnUserAccount account) throws EventException;
	
	/**
     * BkgDgCgoVO 모델에 대한 데이타 조회.
     * 
     * @param String bkgNo
     * @return List<BkgDgCgoVO>
     * @exception EventException
     */
	public List<BkgDgCgoVO> searchBkgDgCgo( String bkgNo ) throws EventException ;

	/**
	 * Cntr Mvmt OC History 저장
	 * 
	 * @param CusCtmMovementVO cusCtmMovementVO
	 * @param String fndBkgCntr
	 * @exception EventException
	 */
	public void addCntrMvmtOcHistory(CusCtmMovementVO cusCtmMovementVO, String fndBkgCntr) throws EventException;


	/**
	 * modifyCntrFlgByRfCgo<br>
	 *  
	 * @param RfCgoApplVO rfCgoApplVO
	 * @param String caFlg
	 * @exception EventException
	 */
	public void modifyCntrFlgByRfCgo(RfCgoApplVO rfCgoApplVO, String caFlg) throws EventException;
	
	/**
	 * Bangladesh Shipment Detail 에 대한 데이타 조회 (ESM_BKG_1133)<br>
	 * 
	 * @param  BkgCustShpRqstVO bkgCustShpRqstVO
	 * @return List<BkgCustShpRqstVO>
	 * @throws EventException
	 */	
	public List<BkgCustShpRqstVO> searchBkgCustShpRqstList(BkgCustShpRqstVO bkgCustShpRqstVO) throws EventException;
	
	
	/**
	    * 방글라데시 ODCY로부터의 파일을 일정 형식으로 저장  (ESM_BKG_1133)<br>
	    * 
	    * @param BkgCustShpRqstVO[] bkgCustShpRqstVOs
	    * @param SignOnUserAccount account
	    * @exception DAOException
	    */
	public void manageBkgCustShpRqst(BkgCustShpRqstVO[] bkgCustShpRqstVOs, SignOnUserAccount account) throws EventException, DAOException;  
	
	/**
	 * Bangladesh Shipment Detail 에 대한 데이타 조회 (ESM_BKG_1134)<br>
	 * 
	 * @param  BkgCustShpRqstVO bkgCustShpRqstVO
	 * @return List<BkgCustShpRqstVO>
	 * @throws EventException
	 */	
	public List<BkgCustShpRqstVO> searchBkgCntrShpRqst(BkgCustShpRqstVO bkgCustShpRqstVO) throws EventException;
	
    /**
     *   B/L 수정.<br>
     * @author  LaSangbo
     * @param   CmBkgInfoVO cmBkgInfoVO
     * @exception   EventException
     */
    public void modifyBlByCntrInfo(CmBkgInfoVO cmBkgInfoVO) throws EventException;

	/**
	 * BKG No.로 BDR이 걸렸는지 check
	 * @param String bkgNo
	 * @return String
     * @throws EventException
     */
    public String searchBdrFlgForNewRoute(String bkgNo) throws EventException;
    
    /**
     * Container Weight Maximum Payload 내 입력 유도 및 오입력 방지 ESM_BKG_0079_04 
	 * 
	 * @param ContainerVO[] containerVOs
	 * @return String
     * @exception EventException
     */
    public String validateContainerWgt(ContainerVO[] containerVOs) throws EventException;
    
    /**
     * Container Risk 해당 하는 장비이면 Validation 처리 한다. <br>
     * 
     * @param ContainerVO[] containerVOs
     * @param String caFlg
     * @param String rcFlg
     * @return String
     * @exception EventException
     */
    public String validateCntrRsk(ContainerVO[] containerVOs, String caFlg, String rcFlg) throws EventException;
    
    /**
	 * bkg_container 테이블에 한국 WHF BKG별 Exception 정보를  update한다.<br>
	 * 
	 * @param CntrKrWhfExptVO cntrKrWhfExptVO
	 * @exception EventException
	 */
	public void modifyBkgKrWhfExpt(CntrKrWhfExptVO cntrKrWhfExptVO)throws EventException;

	
    /**
     * BL body에 찍힐 WPM관련 문구를 생성한다.
     * @param BkgBlNoVO bkgBlNoVO
     * @param String xterFlg
     * @return
     * @throws EventException
     */

    public String searchWpmDescForBl(BkgBlNoVO bkgBlNoVO, String xterFlg) throws EventException;
    
    /**
	 * 처음 받은 EDI에 VGM이 없고 다음에 받은 EDI에 VGM이 있을 경우
	 * bkg_container 테이블에 CTM으로 받은 VGM 업데이트 한다.
	 * 단, bkg container에 vgm값이 이미 있으면 업데이트 안함<br>
	 * @param CrossItemVO item
	 * @exception EventException
	 */

    public void updateVGMForOnlyMVMT(CrossItemVO item) throws EventException;
    
    /**
     * VGM update from TRS only<br>
     * 
     * @param ContainerVO containerVO
     * @throws EventException
     */
    public void updateVGMFromTrs(ContainerVO containerVO) throws EventException;
    
    /**
     * 같은 Partial Container 를 가진 Booking 조회.
     * 
     * @param String bkgNo
     * @param String cntrNo
     * @return List<BkgContainerVO>
     * @exception EventException
     */
	public List<BkgContainerVO> searchPtlCntrBkg(String bkgNo, String cntrNo) throws EventException;
	
	/**
	 * 같은 Partial Container 를 가진 Booking 의 VGM 정보를 update 한다.<br>
	 * 
	 * @author 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @param String targetBkgNo
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int modifyPtlCntrVgmCopy(String bkgNo, String cntrNo, String targetBkgNo, SignOnUserAccount account) throws EventException;

    
    
    /**
     * VGM을 변경한 이력이잇는지 확인
     * @param List<BkgContainerVO> bkgContainerVOs
     * @return String
     * @throws EventException
     */
    public String searchVgmChgHis(List<BkgContainerVO> bkgContainerVOs) throws EventException;
    
    /**
	 * VERMAS 멀티 전송을 위한 리스트 조회 (ESM_BKG_1187)<br>
	 * 
	 * @author 
	 * @param BkgListForTmlVermasEdiInputVO bkgListForTmlVermasEdiInputVO
	 * @return List<BkgListForGeneralTmlVermasEdiVO>
	 * @throws EventException
	 */
	public List<BkgListForGeneralTmlVermasEdiVO> searchBkgListForGeneralTmlVermasEdi(BkgListForTmlVermasEdiInputVO bkgListForTmlVermasEdiInputVO) throws EventException;

}
