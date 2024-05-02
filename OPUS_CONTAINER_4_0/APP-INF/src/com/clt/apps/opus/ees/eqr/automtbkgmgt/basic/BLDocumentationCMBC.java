/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BLDocumentationCMBC.java
 *@FileTitle : Container No Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/


package com.clt.apps.opus.ees.eqr.automtbkgmgt.basic;

import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CrossItemVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgBookingInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SelectCntrVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgCntrMvmtRtnVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmByCntrVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmCopyVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrAdjVolVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrCopyVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrDetailInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrEtcInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrInfoOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrKrWhfExptVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.ContainerVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.EdiNotUpdCntrVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.RataBkgQtyVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.RfCgoApplVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCntrMfDescVO;
import com.clt.syscommon.common.table.BkgCntrSealNoVO;
import com.clt.syscommon.common.table.BkgContainerVO;
import com.clt.syscommon.common.table.BkgDgCgoVO;
import com.clt.syscommon.common.table.MstContainerVO;

/**
 * OPUS-Outboundblmgt Business Logic Command Interface<br>
 * - OPUS-Outboundblmgt business logic Interface<br>
 *
 * @author
 * @see Ui_bkg-0892EventResponse reference
 * @since J2EE 1.4
 */

public interface BLDocumentationCMBC {

	/**
     * retrieve each Container in order to copy C/M based on T.VVD, BKG Office, POL, POD<br>
     * 
     * @param String vvd
     * @param String ofcCd
     * @param String pol
     * @param String pod
     * @param String cfmYn
     * @return List<CmCopyVO>
     * @exception EventException
     */
    public List<CmCopyVO> searchCntrListByVvd(String vvd, String ofcCd, String pol, String pod, String cfmYn) throws EventException; 

    /**
     * container seal number information retrieve
     * @param BkgBlNoVO bkgBlNoVO
     * @return List<BkgBlNoVO>
     * @exception EventException
     */
    public List<BkgBlNoVO> searchMultiSeal(BkgBlNoVO bkgBlNoVO) throws EventException;

    /**
     * retrieve event handling<br>
     * BLDocumentation screen retrieve event handling<br>
     * 
     * @param String bkgNo
     * @return List<EdiNotUpdCntrVO>
     * @exception EventException
     */
    public List<EdiNotUpdCntrVO> searchNotUpdCntr(String bkgNo) throws EventException;

    /**
     * retrieve event handling<br>
     * BLDocumentation screen retrieve event handling<br>
     * 
     * @param String cntrNo
     * @return CntrDetailInfoVO
     * @exception EventException
     */
    public CntrDetailInfoVO searchCntrDtlInfo(String cntrNo) throws EventException;

    /**
     * confirm BKG of Container Confirm status among Partial Container Booking as same VVD and Container No -- UI_BKG-0079-04
     * 
     * @param String bkgNo
     * @param String cntrNo
     * @return String
     * @exception EventException
     */
    public String searchPartialConfirm(String bkgNo, String cntrNo) throws EventException;
    
    /**
     * container information retrieve -- UI_BKG-0172, 
     * BKG CONTAINER, BKG CONTAINER SEAL NUMBER, BKG BOOKING, BKG DOCUMENT PROCESS SCHEDULE, BKG RATE etc.
     * @param String bkgNo
     * @param String caFlg
     * @return CntrInfoOutVO
     * @exception EventException
     */
    public CntrInfoOutVO searchContainer(String bkgNo, String caFlg) throws EventException;

    /**
     * create/modify container information
     * @param List<ContainerVO> updateVoList
     * @param String caFlg
     * @exception EventException
     */
    public void manageContainer(List<ContainerVO> updateVoList, String caFlg) throws EventException;

    /**
     * create/modify container information
     * @param List<ContainerVO> updateVoList
     * @exception EventException
     */
    public void manageContainerByXter(List<ContainerVO> updateVoList) throws EventException;

    /**
     * Container is copied to another booking. -- UI_BKG-0170, BKG CONTAINER
     * 
     * @param CntrCopyVO cntrCopyVO
     * @exception EventException
     */
    public void copyContainer(CntrCopyVO cntrCopyVO) throws EventException;

    /**
     * Container information is moved to another booking. -- UI_BKG-0170, BKG CONTAINER
     * 
     * @param String bkgNo
     * @param String cntrNo
     * @param String caFlg
     * @exception EventException
     */
    public void moveContainer(String bkgNo, String cntrNo, String caFlg) throws EventException;

    /**
     * Make sure your container information can save
     * method in BC
     * @param CntrEtcInfoVO bkgEtcInfoVO
     * @param ContainerVO[] containerVOs
     * @param String fnlCfmFlg
     * @return List<Map<String,Object>>
     * @exception EventException
     */
    public List<Map<String,Object>> validateContainer(CntrEtcInfoVO bkgEtcInfoVO, ContainerVO[] containerVOs, String fnlCfmFlg) throws EventException;

    /**
     * Make sure your container confrim possible.
     * method in BC 
     * @param CntrEtcInfoVO bkgEtcInfoVO
     * @param ContainerVO[] containerVOs
     * @param String fnlCfmFlg
     * @exception EventException
     */
    public void validateContainerConfirm(CntrEtcInfoVO bkgEtcInfoVO, ContainerVO[] containerVOs, String fnlCfmFlg) throws EventException;

    /**
     * update Vol of Container and Partial Flag. UI_BKG-0170
     * @param CntrCopyVO cntrCopyVO
     * @exception EventException
     */
    public void modifyCntrVol(CntrCopyVO cntrCopyVO) throws EventException;

    /**
     * container manifest information retrieve.-- UI_BKG-0079-07
     * @param String bkgNo
     * @param String caFlg 
     * @return CmVO
     * @exception EventException
     */
    public CmVO searchCm(String bkgNo, String caFlg) throws EventException;

    /**
     * Make sure your container manifest information can save
     * @param CmVO cmVO
     * @exception EventException
     */
    public void validateCm(CmVO cmVO) throws EventException;

    /**
     * container manifest information creation -- UI_BKG-0079-07, UI_BKG-0178, BKG CONTAINER MANIFEST DESCRIPTION
     * @param CmVO cmVO
     * @param SignOnUserAccount account
     * @param String caFlg 
     * @exception EventException
     */
    public void manageCm(CmVO cmVO, SignOnUserAccount account, String caFlg) throws EventException;

    /**
     *  change Term of Container according to Bkg(ESM_BKG_0079_01) -> modifyBooking<br>
     * @param   BkgContainerVO bkgContainerVO
	 * @param 		BkgBlNoVO bkgBlNoVO
     * @exception   EventException
     */
    public void modifyCntrRDTerm(BkgContainerVO bkgContainerVO, BkgBlNoVO bkgBlNoVO) throws EventException;

    /**
     * update Container Seal No information
     * 
     * @param List<BkgCntrSealNoVO> updateSealVoList
     * @param String caFlg
     * @exception EventException
     */
    public void manageCntrSealNo(List<BkgCntrSealNoVO> updateSealVoList, String caFlg) throws EventException;

    /**
     * delete Container Seal No.-- UI_BKG-0170, UI_BKG-0079-04
     * @param String bkgNo
     * @param String cntrNo
     * @param String cntr_seal_seq
     * @param String caFlg
     * @exception EventException
     */
    public void removeCntrSealNo(String bkgNo, String cntrNo, String cntr_seal_seq, String caFlg) throws EventException;

    /**
     * delete Container Seal No. -- UI_BKG-0170, UI_BKG-0079-04
     * 
     * @param List<BkgCntrSealNoVO> deleteSealVoList
     * @param String caFlg 
     * @exception EventException
     */    
    public void removeCntrSealNo(List<BkgCntrSealNoVO> deleteSealVoList, String caFlg) throws EventException;

    /**
     * delete Container Manifest Desc. -- UI_BKG-0170, UI_BKG-0079-04
     * 
     * @param String bkgNo
     * @param String cntrNo
     * @param String caFlg
     * @exception EventException
     */
    public void removeCntrMfDesc(String bkgNo, String cntrNo, String caFlg) throws EventException;

    /**
     * change Container Manifest Desc.
     * @param String bkgNo
     * @param String cntrNo
     * @param String cntrNoOld
     * @param String caFlg 
     * @exception EventException
     */
    public void changeCntrMfDesc(String bkgNo, String cntrNo, String cntrNoOld, String caFlg) throws EventException;

    /**
     * insert Container
     * @param ContainerVO containerVO
     * @param String caFlg 
     * @exception EventException
     */
    public void insertContainer(ContainerVO containerVO, String caFlg) throws EventException;

    /**
     * modify container information
     * 
     * @param ContainerVO containerVO
     * @param String caFlg
     * @exception EventException
     */
    public void modifyContainer(ContainerVO containerVO, String caFlg) throws EventException;

    /**
     * modify container confirm information
     * 
     * @param String bkgNo
     * @param String cfmFlg
     * @param String caFlg
     * @exception EventException
     */
    public void modifyCntrCfmFlg(String bkgNo, String cfmFlg, String caFlg) throws EventException;
    
    /**
     * delete Container
     * @param String bkgNo
     * @param String cntrNo
     * @param String caFlg 
     * @exception EventException
     */
    public void removeContainer(String bkgNo, String cntrNo, String caFlg) throws EventException;

    /**
     * update act_wgt and wgt_ut_cd.(ESM_BKG_0079_01) -> modifyBooking<br>
     * @param       BkgBlNoVO bkgBlNoVO
     * @param       String actWgt
     * @param       String wgtUtCd
     * @param       SignOnUserAccount account
     * @exception   EventException
     */
    public void modifyBlActWgt(BkgBlNoVO bkgBlNoVO, String actWgt, String wgtUtCd, SignOnUserAccount account) throws EventException;

    /**
     *  Cancel Container.(ESM_BKG_0079_01) -> modifyBooking<br>
     *  
     * @param       BkgBlNoVO bkgBlNoVO
     * @param       SignOnUserAccount account
     * @exception   EventException
     */
    public void cancelBkgCntr(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException;

    /**
     * insert to targetBkg after reading at bkg_cntr, bkg_cntr_seal_no of sourceBkg when combine/split
     * @param String[] copyMdHcmtArr
     * @param BkgBlNoVO sourceBkg
     * @param BkgBlNoVO[] targetBkg
     * @param List<SelectCntrVO> selectCntrVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyCntrCmByBkg(String[] copyMdHcmtArr, BkgBlNoVO sourceBkg, BkgBlNoVO[] targetBkg, List<SelectCntrVO>selectCntrVO, SignOnUserAccount account) throws EventException;
    
    /**
     *  change awk_cgo_flg value according to Bkg_no of Container(ESM_BKG_0055)
     *  
     * @param   String bkgNo 
     * @param   String spclTp 
     * @param   String cntrNo
     * @param   String caFlg
     * @return	int
     * @exception   EventException
     */         
    public int modifyCntrFlgBySpcl(String bkgNo, String spclTp, String cntrNo, String caFlg) throws EventException;
    
    /**
     *  change awk_cgo_flg value according to Bkg_no of Container(ESM_BKG_0055)
     * @param   String bkgNo 
     * @param   String spclTp 
     * @param   String cntrNo
     * @param   String caFlg
     * @exception   EventException
     */        
    public void modifyCntrFlgBySpcl2(String bkgNo, String spclTp, String cntrNo, String caFlg) throws EventException;
    
    /**
     *  change awk_cgo_flg value according to Bkg_no of Container(ESM_BKG_0055)    
     * @param   String bkgNo 
     * @param   String caFlg 
     * @exception   EventException
     */        
    public void modifyCntrFlgBySpcl3(String bkgNo, String caFlg) throws EventException;

    /**
     * retrieve manifest information corresponding to container-- UI_BKG-0178
     * @param String cntrNo
     * @param String vvd
     * @return CmByCntrVO
     * @exception EventException
     */
    public CmByCntrVO searchCmByCntr(String cntrNo, String vvd) throws EventException;

    /**
     * insert/modify/delete C/M by Container -- UI_BKG-0178
     * 
     * @param CmByCntrVO cmVO
     * @param SignOnUserAccount account
     * @param String caFlg 
     * @exception EventException
     */
    public void manageCmByCntr(CmByCntrVO cmVO, SignOnUserAccount account, String caFlg) throws EventException;

    /**
     * container manifest information retrieve -- UI_BKG-0079-07, UI_BKG-0178, BKG CONTAINER MANIFEST DESCRIPTION
     * 
     * @param String bkgNo
     * @param String caFlg
     * @return List<BkgCntrMfDescVO>
     * @exception EventException
     */
    public List<BkgCntrMfDescVO> searchCntrMfDesc(String bkgNo, String caFlg) throws EventException;

    /**
     * container information creation
     * -- UI_BKG-0172, BKG CONTAINER, BKG CONTAINER SEAL NUMBER, BKG BOOKING, BKG DOCUMENT PROCESS SCHEDULE, BKG RATE etc.
     * @param ContainerVO[] containerVOs
     * @param BkgCntrSealNoVO[] bkgCntrSealNoVOs
     * @param String usrId
     * @exception EventException
     */
    public void manageCntrByXter(ContainerVO[] containerVOs, BkgCntrSealNoVO[] bkgCntrSealNoVOs, String usrId) throws EventException;

    /**
     * retrieve OB / L Issue before Total Package in Word update
     *
     * @author KimYoungchul
     * @param bkgNo
     * @param caFlg
     * @return String
     * @exception EventException
     */
    public String searchBlIssFlg(String bkgNo, String caFlg) throws EventException;
    
    /**
     * retrieve status of Doc Process
     * 
     * @param String tgtBkgNo
     * @param String caFlg
     * @return String
     * @exception EventException
     */
    public String searchDocProcessByCntr(String tgtBkgNo, String caFlg) throws EventException;

    /**
     * if BKG Qty and CNTR Qty is the other cases, Total Package in Word of the M&D will update when you have Container Final Confirm.(BKG_BL_DOC.TTL_PCK_DESC)
     * 
     * @param String bkgNo
     * @param String caFlg 
     * @exception EventException
     */
    public void modifyBlByFinalCfm(String bkgNo, String caFlg) throws EventException;

    /**
     * retrieve BKG No. and Vol that is using same VVD and Container when Partial Container Volume adjusts -- UI_BKG-1050
     * @param String bkgNo
     * @param String cntrNo
     * @return List<CntrAdjVolVO>
     * @exception EventException
     */
    public List<CntrAdjVolVO> searchCntrAdjVol(String bkgNo, String cntrNo) throws EventException;
    
    /**
     * Search Container Count.
     *
     * @param bkgNo
     * @param caFlg
     * @return String
     * @exception EventException
     */
    public String searchCntrKnt(String bkgNo, String caFlg) throws EventException;
    
    /**
     * retrieve BKG No. and Vol that is using same VVD and Container when Partial Container Volume adjusts -- UI_BKG-1050
     * 
     * @param bkgNo
     * @param caFlg
     * @return List<RataBkgQtyVO>
     * @exception EventException
     */
    public List<RataBkgQtyVO> searchBkgCntrVol(String bkgNo, String caFlg) throws EventException;

    /**
     * update Vol of Container and Partial Flag. UI_BKG-0170
     * 
     * @param CntrAdjVolVO cntrAdjVolVO 
     * @param String caFlg
     * @exception EventException
     */
    public void modifyCntrVol(CntrAdjVolVO cntrAdjVolVO, String caFlg) throws EventException;
    
    /**
     * copy from bkg_bl_doc of sourceBkg to targetBkg
     * @param       String trnkVslCd
     * @param       String preVslCd
     * @param       BkgBlNoVO sourceBkg
     * @param       BkgBlNoVO targetBkg
     * @param       SignOnUserAccount account
     * @exception   EventException
     */    
    public void copyBkgBlDoc( String trnkVslCd , String preVslCd , BkgBlNoVO sourceBkg , BkgBlNoVO targetBkg, SignOnUserAccount account) throws EventException;
    
    /**
     *  save BKG_BL_DOC.(ESM_BKG_0079_01) -> createBooking<br>
     * @param       String bkgNo
     * @param       String blMvTpNm
	 * @param       BkgBookingInfoVO bkgBookingInfoVO
     * @param       SignOnUserAccount account
     * @exception   EventException
     */
    public void createBkgBlDocByBKG(String bkgNo, String blMvTpNm, BkgBookingInfoVO bkgBookingInfoVO, SignOnUserAccount account) throws EventException;
    
    /**
     * Movement Cycle is updated as 9999, if you delete Container when MT Repo. Booking at Movement is VL status.
     *  
     * @param String bkgNo
     * @param String cntrNo
     * @param String cnmvCycNo
     * @param String cnmvDtTm
     * @exception EventException
     */
    public void modifyCycleByCtm(String bkgNo, String cntrNo, String cnmvCycNo, String cnmvDtTm) throws EventException;

    /**
     * handling ContainerMovementMgt at calling from CTM
     * @param CrossItemVO item
     * @return BkgCntrMvmtRtnVO
     * @exception EventException
     */
    public BkgCntrMvmtRtnVO modifyCntrOp(CrossItemVO item) throws EventException;
    
    /**
     * method for Container History Update at calling from CTM
     * @param CusCtmMovementVO vo 
     * @param String delFlg
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
	 * update Exception information by KOREA WHF CNTR at bkg_container table
	 * @param List<CntrKrWhfExptVO> cntrKrWhfExptVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyCntrKrWhfExpt (List<CntrKrWhfExptVO> cntrKrWhfExptVOs, SignOnUserAccount account)throws EventException;
	
	/**
     * MstContainer information retrieve
     * 
     * @param cntrNo
     * @return MstContainerVO
     * @exception EventException
     */
    public MstContainerVO searchMstCntrForMst(String cntrNo) throws EventException;

    /**
     * Update C/M by container wgt./meas. unit
     * 
     * @param bkgNo
     * @param bkgWgtUtCd
     * @param bkgMeasUtCd
     * @param account
     * @param caFlg
     * @exception EventException
     */
    public void modiftyCmUnitByCntr(String bkgNo, String bkgWgtUtCd, String bkgMeasUtCd, SignOnUserAccount account, String caFlg) throws EventException;
    
    /**
     * container manifest information creation. -- UI_BKG_0229_05, BKG CONTAINER MANIFEST DESCRIPTION
     * 
     * @param cmVO
     * @param account
     * @param caFlg 
     * @exception EventException
     */
	public void manageCmByXter(CmVO cmVO, SignOnUserAccount account, String caFlg) throws EventException;
	
	/**
     * update route name of bkg
     * 
     * @param BkgBlNoVO bkgBlNoVO
     * @param BkgBookingInfoVO bkgBookingInfoVO 
     * @param account
     * @exception EventException
     */
	public void modifyBkgRouteNm(BkgBlNoVO bkgBlNoVO, BkgBookingInfoVO bkgBookingInfoVO, SignOnUserAccount account) throws EventException;

	/**
     * Re-calculate special cargo flag by cntr after split
     * @param BkgBlNoVO[] targetBkg
     * @param SignOnUserAccount account
     * @exception EventException
     */
	public void modifyCntrSpclFlag(BkgBlNoVO[] targetBkg, SignOnUserAccount account) throws EventException;	

	/**
     * update cgo_rcv_dt of cntr
     * 
     * @param ContainerVO[] containerVOs
     * @param String caFlg
     * @param SignOnUserAccount account
     * @exception EventException
     */
	public void modifyCrdDt(ContainerVO[] containerVOs, String caFlg, SignOnUserAccount account) throws EventException;
	
	/**
     * retrieve data about BkgDgCgoVO model
     * 
     * @param String bkgNo
     * @return List<BkgDgCgoVO>
     * @exception EventException
     */
	public List<BkgDgCgoVO> searchBkgDgCgo( String bkgNo ) throws EventException ;
	/**
	 * modifyCntrFlgByRfCgo<br>
	 *  
	 * @param RfCgoApplVO rfCgoApplVO
	 * @param String caFlg
	 * @exception EventException
	 */
	public void modifyCntrFlgByRfCgo(RfCgoApplVO rfCgoApplVO, String caFlg) throws EventException;
	
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
     *  Reactivate Container(ESM_BKG_0000_1) -> reactivateBooking
     *  
     * @author      KYOUNG IL MOON
     * @param       BkgBlNoVO bkgBlNoVO
     * @param       SignOnUserAccount account
     * @exception   EventException
     */
    public void activateBkgCntr(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException;
}