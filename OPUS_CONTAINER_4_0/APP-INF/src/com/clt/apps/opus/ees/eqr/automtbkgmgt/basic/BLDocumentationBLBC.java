/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLDocumentationBLBC.java
*@FileTitle : Container Information
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.automtbkgmgt.basic;

import java.util.List;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.OpusXptImpLicListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyBookingCreateVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyBookingSplitVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SelectCntrVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SplitBkgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RepoBkgForUpdateVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestModificationVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.CoveredBlListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateMainInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BlCopyInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BlCopyOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmGoodsDescVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.DGCargoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblForMndVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblTmpltVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.MndVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.XptImpLicInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.XptImpLicVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlIssInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlDtListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgBlDocVO;
import com.clt.syscommon.common.table.BkgCoffTmVO;

/**
 * OPUS-TerminalDocumentation Business Logic Basic Command implementation<br>
 * - OPUS-TerminalDocumentation handling business logic<br>
 *
 * @author 
 * @see Ui_bkg-0079-04EventResponse Reference
 * @since J2EE 1.4
 */

public interface BLDocumentationBLBC {
	/**
	 * BKG_CHG_RT BkgBooking Data Information is changed.<br>
	 * 
	 * @author 
	 * @param RateMainInfoVO rateMainInfoVO
	 * @param String mcflag
	 * @param String caflag
	 * @exception EventException
	 */
	public void modifyChgRateBkgBlDocMasterCovered(RateMainInfoVO rateMainInfoVO, String mcflag ,String caflag) throws EventException;	 
	/**
	* EsmBkg0771Event save events<br>
	* Covered B/L of the Master B/L information is updated to Null<br>
	 * BL_CVRD_TP_CD is updated to Null<br>
	 * 
	 * @author 
	 * @param String bkg_no
	 * @param String bl_no
	 * @param CoveredBlListVO[] coveredBlListVOs
	 * @return String
	 * @exception EventException
	 */
	public String manageCoveredBl(String bkg_no, String bl_no, CoveredBlListVO[] coveredBlListVOs) throws EventException;
	/**
	 * 'BkgBooking Data' in the 'BKG_CHG_RT'  is modified<br>
	 * 
	 * @author 
	 * @param RateMainInfoVO rateMainInfoVO
	 * @param String caflag
	 * @exception EventException
	 */
	public void modifyChgRateBkgBlDoc(RateMainInfoVO rateMainInfoVO, String caflag) throws EventException;	
	/**
	 * EsmBkg007909Event Saving events<br>
	 * 'bl issue'  to process <br>
	 * @author 
	 * @param BlIssInfoVO blIssInfoVO
	 * @exception EventException
	 */
	public void manageBlIssueFlg(BlIssInfoVO blIssInfoVO) throws EventException;	
    /**
     * B/L Doc to change the information. -- UI_BKG-0079-09, BKG B/L ISSUE.
     * 
     * @author 
     * @param BlIssInfoVO blIssInfoVO
     * @exception EventException
     */
	public void modifyBlIssInfoForBlDoc(BlIssInfoVO blIssInfoVO) throws EventException;
	
    /**
     * retrieving mark & description .
     * 
     * @param bkgBlNoVO
     * @return MndVO
     * @exception EventException
     */
	public MndVO searchMnd(BkgBlNoVO bkgBlNoVO) throws EventException;

    /**
     * mark & description -> storage validation
     * 
     * @param mndVO
     * @exception EventException
     */
    public void validateMnd(MndVO mndVO) throws EventException;

    /**
     * MND will correct the information.-- UI_BKG-0079-06
     * Integrated with the eBooking Sea NACCS
     * 
     * @param mndVO
     * @param account
     * @param caFlg
     * @exception EventException
     */
    public void manageMnd(MndVO mndVO, SignOnUserAccount account, String caFlg) throws EventException;

    /**
     * dangerous cargo  retrieve.
     * @param bkgNo
     * @return List<DGCargoVO>
     * @exception EventException
     */
    public List<DGCargoVO> searchDG(String bkgNo) throws EventException;

    /**
     * Package Type code check handling (ESM_BKG_0361_01~06)
     * 
     * @param XptImpLicVO[] xptImpLicVO
     * @author Choi Do Soon
     * @exception EventException
     */
    public void validateExportImportNumber(XptImpLicVO[] xptImpLicVO) throws EventException;

    /**
     * Export / Import Information search by country (ESM_BKG_0361_01~06)
     * 
     * @author Choi Do Soon
     * @param xptImpLicIn
     * @param String caFlg
     * @return List<XptImpLicVO>
     * @exception EventException
     */
    public  List<XptImpLicVO> searchExportImportNumber(XptImpLicInVO xptImpLicIn, String caFlg) throws EventException;

    /**
     * Export / Import Information input by country  (ESM_BKG_0361_01~06)
     * 
     * @author Choi Do Soon
     * @param xptImpLicVOs
     * @param cntCd
     * @param String caFlg
     * @exception EventException
     */
    public void createExportImportNumber(List<XptImpLicVO> xptImpLicVOs, String cntCd, String caFlg) throws EventException;
    
    /**
     * Export / Import Information update by country  (ESM_BKG_0361_01~06)
     * 
     * @author Choi Do Soon
     * @param xptImpLicVOs
     * @param cntCd
     * @param String caFlg
     * @exception EventException
     */
    public void modifyExportImportNumber(List<XptImpLicVO> xptImpLicVOs, String cntCd, String caFlg) throws EventException;
    
    /**
     * Export / Import Information delete by country(ESM_BKG_0361_01~06)
     * 
     * @param List<XptImpLicVO> xptImpLicVOs
     * @param String caFlg
     * @author Choi Do Soon
     * @exception EventException
     */
    public void removeExportImportNumber(List<XptImpLicVO> xptImpLicVOs, String caFlg) throws EventException;

    /**
     * split-> new booking (b / l, cntr, c / m) to set the information.<br>
     * 1. copyBkgBlDocByBkg () will copy bkg_bl_doc table by running, value(pkg, wgt, meas modify)<br>
     * 2. copyMndByBkg () will copy bkg_bl_mk_desc table by running.<br>
     * 
     * @param BkgBlNoVO sourceBkg
     * @param BkgBlNoVO[] targetBkg
     * @param SplitBkgVO splitBkgVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyBlDocByBkg(BkgBlNoVO sourceBkg, BkgBlNoVO[] targetBkg,SplitBkgVO splitBkgVO,SignOnUserAccount account) throws EventException;

    /**
     * bkg_hbl table sourceBkg -> targetBkg be copied to<br>
     *  cntr_mf_no-> Copy as ORG_CNTR_MF_NO.<br>
     * 
     * @param String copyModeCd
     * @param BkgBlNoVO sourceBkg
     * @param BkgBlNoVO[] targetBkg
     * @param SelectCntrVO selectCntrVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyHblByBkg(String copyModeCd,BkgBlNoVO sourceBkg,BkgBlNoVO[] targetBkg,List<SelectCntrVO> selectCntrVO,SignOnUserAccount account) throws EventException;

    /**
     * retrieve Container Manifest -- UI_BKG-0707
     * 
     * @param bkg_no
     * @return CmGoodsDescVO
     * @exception EventException
     */
    public CmGoodsDescVO searchGoodsDescByCm(String bkg_no) throws EventException;

    /**
     * update On-Board Date -- UI_BKG-0726
     * @param grpBlDtListVO
     * @exception EventException
     */
    public void modifyBlObrdDt(GrpBlDtListVO grpBlDtListVO) throws EventException;

    /**
     * retrieve  HB/L description -- UI_BKG-0360
     * M&D add HB/L of the information
     * 
     * @param bkgNo
     * @return List<HblForMndVO>
     * @exception EventException
     */
    public List<HblForMndVO> searchHblForMnd(String bkgNo) throws EventException;

    /**
     * HB / L  retrieve a template for the information of the shipper . -- UI_BKG-0399
     * @param shprNm
     * @param cneeNm
     * @param ofcCd
     * @return HblTmpltVO
     * @exception EventException
     */
    public HblTmpltVO searchHblTmplt(String shprNm, String cneeNm, String ofcCd) throws EventException;

    /**
     * HB / L  handle a template for the information of the shipper. -- UI_BKG-0399
     * @param hblTmpltVO
     * @param s_usr_id
     * @exception EventException
     */
    public void manageHblTmplt(HblTmpltVO hblTmpltVO, String s_usr_id) throws EventException;
    
    /**
     * Container Information, B / L to insert or update the information<br>
     * 
     * @author      KimByungKyu
     * @param       MtyBookingCreateVO mtyBookingCreateVO
     * @param       SignOnUserAccount account
     * @exception   EventException
     */
    public void createMtyRepoBlCntr(MtyBookingCreateVO mtyBookingCreateVO, SignOnUserAccount account) throws EventException;

    /**
     * retrieving house bl-- UI_BKG-0366
     * 
     * @param BkgBlNoVO bkgBlNoVO
     * @return HblVO
     * @exception EventException
     */
    public HblVO searchHbl(BkgBlNoVO bkgBlNoVO) throws EventException;

    /**
     * House B/L, B/L Customer, Manifest handling  -- UI_BKG-0366
     * @param hblVO
     * @param account
     * @param caFlg 
     * @exception EventException
     */
    public void manageHbl(HblVO hblVO, SignOnUserAccount account, String caFlg) throws EventException;

    /**
     * House B / L  information validation check-- UI_BKG-0366
     * @param hblVO
     * @exception EventException
     */
    public void validateHbl(HblVO hblVO) throws EventException;    

	/**
	 * bkg_bl_doc ORG_CNT_NM column update <br>
	 * 
     * @author		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		String orgCntNm
	 * @param 		SignOnUserAccount account
	 * @param 		String oldActCustCd
	 * @param 		String newActCustCd
	 * @exception 	EventException
	 */
    public void modifyBkgBlDocByCust(BkgBlNoVO bkgBlNoVO, String orgCntNm, SignOnUserAccount account, String oldActCustCd, String newActCustCd) throws EventException;

    /**
     * Manifest File No Validation check -- UI_BKG-0366
     * 
     * @param BkgBlNoVO bkgBlNoVO
     * @exception EventException
     */
    public void validateMfNo(BkgBlNoVO bkgBlNoVO) throws EventException;

    /**
     * Nvocc File No modify
     * @param bkgNo
     * @param hblSeq
     * @param nvoccFileNo
     * @param account
     * @param caFlg 
     * @exception EventException
     */
    public void modifyNvoccFileNo(String bkgNo, String hblSeq, String nvoccFileNo, SignOnUserAccount account, String caFlg) throws EventException;

    /**
     * Max HBL Manifest No Generation
     * @param bkgNo
     * @param blNo
     * @param caFlg 
     * @return String
     * @exception EventException
     */
    public String searchMaxMfNo(String bkgNo, String blNo, String caFlg) throws EventException;    

	/**
     * HBL Count update.<br>
	 * 
     * @author KimByungKyu
	 * @param hblCount
	 * @param bkgBlNoVO
	 * @param account
	 * @exception EventException
	 */
    public void modifyHblCount(int hblCount, BkgBlNoVO bkgBlNoVO, SignOnUserAccount account)  throws EventException;

    /**
     * will update in the  targetBkg bkg_bl_doc.

     * @author KimByungKyu
     * @param sourceBkg
     * @param targetBkg
     * @param account
     * @exception EventException
     */
    public void combineBlDoc(BkgBlNoVO[] sourceBkg, BkgBlNoVO targetBkg, SignOnUserAccount account) throws EventException;

	/**
	 * retrieve BlCopyOutVO<br>
	 * 
	 * @param String bkgNo
	 * @return BlCopyOutVO
	 * @exception EventException
	 */
	public BlCopyOutVO searchForCopyBl(String bkgNo) throws EventException;

	/**
	 * retrieve BlCopyOutVO<br>
	 * 
	 * @param BlCopyInVO blCopyInVo
	 * @return BlCopyInVO
	 * @exception EventException
	 */
	public BlCopyInVO searchForCopyBl(BlCopyInVO blCopyInVo) throws EventException;

	/**
	 * BL Copy UI Call
     * MND Copy -- UI_BKG-0648
	 * @param blCopyInVo
	 * @param account
	 * @return BlCopyInVO
	 * @exception EventException
	 */
	public BlCopyInVO copyDocByBlCopy(BlCopyInVO blCopyInVo, SignOnUserAccount account) throws EventException;
	
	/**
     * bkg_bl_doc CA (C / A No, C / A User, office, date)  modify<br>
	 * 
     * @author Lee NamKyung
	 * @param bkgBlNoVO
	 * @param account
	 * @exception EventException
	 */
	public void modifyCaStart(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException;
	
	/**
     * 'booking BlDocumantationBC' Copy the relevant table
	 * 
     * @author Lee NamKyung
	 * @param bkgBlNoVO
	 * @param copyTypeCd
	 * @exception EventException
	 */
	public void createBlCA(BkgBlNoVO bkgBlNoVO, String copyTypeCd) throws EventException;
	
	/**
     * CA Information:(C/A No, C/A User, office, date) to delete from bkg_bl_doc.<br>
	 * 
     * @author Lee NamKyung
	 * @param bkgBlNoVO
	 * @exception EventException
	 */
	public void modifyCaComplete(BkgBlNoVO bkgBlNoVO) throws EventException;
	
	/**
	 * BlDocumantationBC will delete the relevant table.
	 * 
	 * @author 		Lee NamKyung
	 * @param 		bkgBlNoVO
	 * @param 		copyTypeCd
	 * @exception 	EventException
	 */
	public void removeCA(BkgBlNoVO bkgBlNoVO, String copyTypeCd) throws EventException;
	
	/**
	 * empty repo Booking split<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		MtyBookingSplitVO mtyBookingSplitVO
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void splitMtyRepoBlCntr(MtyBookingSplitVO mtyBookingSplitVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * empty Repo Booking -> container information, B / L information insert, update, delete <br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		RepoBkgForUpdateVO repoBkgForUpdateVO
	 * @param		String trunkVvd
	 * @param 		SignOnUserAccount account
	 * @return      List<CusCtmMovementVO>
	 * @exception 	EventException
	 */
	public List<CusCtmMovementVO> manageEmptyCntr(RepoBkgForUpdateVO repoBkgForUpdateVO, String trunkVvd, SignOnUserAccount account) throws EventException;	
	
	/**
	 * bkg_bl_doc table update.<br>
	 * 
	 * @param BkgCoffTmVO[] bkgCoffTmVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyBkgClose (BkgCoffTmVO[] bkgCoffTmVOs, SignOnUserAccount account)throws EventException;
	
	/**
	 * BL DOC modify
	 * 
	 * @param bkgBlDocVO
	 * @throws EventException
	 */
	public void modifyBlDoc(BkgBlDocVO bkgBlDocVO) throws EventException;
	
	
	/**
	 * Modification event<br>
	 * Indonesian customs modify the target data transmission<br>
	 * 
	 * @param ManifestModificationVO[] manifestModificationVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageManifest(ManifestModificationVO[] manifestModificationVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Vessel Schedule B/L Data Release save. (ESM_BKG_0596)<br>
	 * container BDR handling  .
	 * 
	 * @param String bkgNo
	 * @param String flag
	 * @param String usrId
	 * @exception EventException
	 */	
	public void modifyCntrCFM(String bkgNo, String flag, String usrId) throws EventException ;
	/**
	 * Vessel Schedule B/L Data Release save. (ESM_BKG_0596)<br>
	 * BKG_BL_DOC BDR handling.
	 * 
	 * @param String bkgNo
	 * @param String flag
	 * @param String usrId
	 * @exception EventException
	 */	
	public void modifyBKGBDR(String bkgNo, String flag, String usrId) throws EventException ;
	
	/**
     * eBKG -> House B/L, B/L Customer, Manifest To handle. 
     * @param HblVO hblVO
	 * @param XterRqstNoVO rqstNoVO 
     * @param SignOnUserAccount account
     * @param String caFlg
     * @exception EventException
     */
    public void manageHblByXter(HblVO hblVO, XterRqstNoVO rqstNoVO, SignOnUserAccount account, String caFlg) throws EventException;
    
	/**
     * eBKG : Export licens handling. -- UI_BKG-0229-04
     * @param BkgBlNoVO bkgBlNoVO
	 * @param OpusXptImpLicListVO[] opusXptImpLicListVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
	public void manageXptLicByXter(BkgBlNoVO bkgBlNoVO, OpusXptImpLicListVO[] opusXptImpLicListVOs, SignOnUserAccount account) throws EventException;
}