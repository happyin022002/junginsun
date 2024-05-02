/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLDocumentationBLBC.java
*@FileTitle : Container Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.23
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.04.23 김영출
* 1.0 Creation
* -----------------------------------------------------------
* History
* 2010.11.23 최도순 [CHM-201007206] Actual customer column 보완 및 M&D 화면에 자동 DISPLAY 요청
* 2012.02.28 정선용 [CHM-201215444-01] [웹 리뉴얼] Rider 및 D/G Rider 항목 보완 (E-bkg/E-SI)
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.CustTpIdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.AlpsXptImpLicListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BlRiderVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyBookingCreateVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyBookingSplitVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SelectCntrVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SplitBkgVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RepoBkgForUpdateVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.CntrComboVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestModificationVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.CoveredBlListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateMainInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgDescVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgIfManageInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgIfManageListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgIfManagerEdiInputVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgIfManagerEdiVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BlCopyInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BlCopyOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmGoodsDescVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmSelfMailVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.DGCargoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblForMndVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblTmpltVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.MndVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.XptImpLicInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.XptImpLicVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.XterVgmInfoValidationVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.XterVgmRqstListInputVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.XterVgmRqstListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlIssInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlDtListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgBlDocVO;
import com.hanjin.syscommon.common.table.BkgCoffTmVO;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;

/**
 * ALPS-Outboundblmgt Business Logic Command Interface<br>
 * - ALPS-Outboundblmgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim Youngchul
 * @see Ui_bkg-0079-04EventResponse 참조
 * @since J2EE 1.4
 */

public interface BLDocumentationBLBC {
	/**
	 * BKG_CHG_RT에서 BkgBooking Data에 해당하는 정보를 수정한다.<br>
	 * //[결함관리지침에 따른 이동]
	 * @author LEE JIN SEO
	 * @param RateMainInfoVO rateMainInfoVO
	 * @param String mcflag
	 * @param String caflag
	 * @exception EventException
	 */
	public void modifyChgRateBkgBlDocMasterCovered(RateMainInfoVO rateMainInfoVO, String mcflag ,String caflag) throws EventException;	
	/**
	 * EsmBkg0771 데이터를 갱신처리<br>
	 * 해당 BKG_NO를 Master B/L로 하는 Covered B/L의 Master B/L 정보를 Null로 업데이트 한다.<br>
	 * BL_CVRD_TP_CD 도 Null로 업데이트 한다.<br>
	 * //[결함관리지침에 따른 이동]
	 * @author LEE JIN SEO
	 * @param String bkg_no
	 * @param String bl_no
	 * @param CoveredBlListVO[] coveredBlListVOs
	 * @return String
	 * @exception EventException
	 */
	public String manageCoveredBl(String bkg_no, String bl_no, CoveredBlListVO[] coveredBlListVOs) throws EventException;
	/**
	 * BKG_CHG_RT에서 BkgBooking Data에 해당하는 정보를 수정한다.<br>
	 * //[결함관리지침에 따른 이동]
	 * @author LEE JIN SEO
	 * @param RateMainInfoVO rateMainInfoVO
	 * @param String caflag
	 * @exception EventException
	 */
	public void modifyChgRateBkgBlDoc(RateMainInfoVO rateMainInfoVO, String caflag) throws EventException;	
	/**
	 * EsmBkg007909Event 저장 이벤트 처리<br>
	 * B/L Issue  관련 정보를 관리한다<br>
	 * //[결함관리지침에 따른 이동]
	 * @author LEE JIN SEO
	 * @param BlIssInfoVO blIssInfoVO
	 * @exception EventException
	 */
	public void manageBlIssueFlg(BlIssInfoVO blIssInfoVO) throws EventException;	
    /**
     * B/L Issue 관련 B/L Doc 정보를 변경한다. -- UI_BKG-0079-09, BKG B/L ISSUE.
     * 
     * @author LEE JIN SEO
     * @param BlIssInfoVO blIssInfoVO
     * @exception EventException
     */
	public void modifyBlIssInfoForBlDoc(BlIssInfoVO blIssInfoVO) throws EventException;
	
    /**
     * mark & description 조회.
     * 
     * @param bkgBlNoVO
     * @return MndVO
     * @exception EventException
     */
	public MndVO searchMnd(BkgBlNoVO bkgBlNoVO) throws EventException;

    /**
     * mark & description 저장선 validation
     * 
     * @param mndVO
     * @exception EventException
     */
    public void validateMnd(MndVO mndVO) throws EventException;

    /**
     * MND 정보를 수정한다.-- UI_BKG-0079-06
     * Sea NACCS가 eBooking과 통합하게 되어 예외처리되어 구현되었던 부분을 구현하지 않는다.
     * 
     * @param mndVO
     * @param account
     * @param caFlg
     * @exception EventException
     */
    public void manageMnd(MndVO mndVO, SignOnUserAccount account, String caFlg) throws EventException;

    /**
     * dangerous cargo 정보를 조회한다.
     * @param bkgNo
     * @return List<DGCargoVO>
     * @exception EventException
     */
    public List<DGCargoVO> searchDG(String bkgNo) throws EventException;

    /**
     * Package Type code 체크 처리 (ESM_BKG_0361_01~06)
     * 
     * @param XptImpLicVO[] xptImpLicVO
     * @author Choi Do Soon
     * @exception EventException
     */
    public void validateExportImportNumber(XptImpLicVO[] xptImpLicVO) throws EventException;

    /**
     * Export / Import Information 국가별 조회 처리 (ESM_BKG_0361_01~06)
     * 
     * @author Choi Do Soon
     * @param xptImpLicIn
     * @param String caFlg
     * @return List<XptImpLicVO>
     * @exception EventException
     */
    public  List<XptImpLicVO> searchExportImportNumber(XptImpLicInVO xptImpLicIn, String caFlg) throws EventException;

    /**
     * Export / Import Information 국가별 입력 처리 (ESM_BKG_0361_01~06)
     * 
     * @author Choi Do Soon
     * @param xptImpLicVOs
     * @param cntCd
     * @param String caFlg
     * @exception EventException
     */
    public void createExportImportNumber(List<XptImpLicVO> xptImpLicVOs, String cntCd, String caFlg) throws EventException;
    
    /**
     * Export / Import Information 국가별 수정 처리 (ESM_BKG_0361_01~06)
     * 
     * @author Choi Do Soon
     * @param xptImpLicVOs
     * @param cntCd
     * @param String caFlg
     * @exception EventException
     */
    public void modifyExportImportNumber(List<XptImpLicVO> xptImpLicVOs, String cntCd, String caFlg) throws EventException;
    
    /**
     * Export / Import Information 국가별 삭제 처리 (ESM_BKG_0361_01~06)
     * 
     * @param List<XptImpLicVO> xptImpLicVOs
     * @param String caFlg
     * @author Choi Do Soon
     * @exception EventException
     */
    public void removeExportImportNumber(List<XptImpLicVO> xptImpLicVOs, String caFlg) throws EventException;

    /**
     * split시 new booking에 b/l, cntr, c/m 정보를 넣는다.<br>
     * 1. copyBkgBlDocByBkg()를 실행하여 bkg_bl_doc table을 복사한다(일부 값(pkg, wgt, meas 수정)<br>
     * 2. copyMndByBkg()를 실행하여 bkg_bl_mk_desc table을 복사한다.<br>
     * 
     * @param BkgBlNoVO sourceBkg
     * @param BkgBlNoVO[] targetBkg
     * @param SplitBkgVO splitBkgVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyBlDocByBkg(BkgBlNoVO sourceBkg, BkgBlNoVO[] targetBkg,SplitBkgVO splitBkgVO,SignOnUserAccount account) throws EventException;

    /**
     * bkg_hbl 테이블을 sourceBkg -> targetBkg로 복사한다<br>
     *  cntr_mf_no는 ORG_CNTR_MF_NO로 복사한다.<br>
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
     * Container Manifest에서 M&D 정보에 업데이트 하기 위해 Data를 조회한다. -- UI_BKG-0707
     * 
     * @param bkg_no
     * @return CmGoodsDescVO
     * @exception EventException
     */
    public CmGoodsDescVO searchGoodsDescByCm(String bkg_no) throws EventException;

    /**
     * On-Board Date를 업데이트 한다. -- UI_BKG-0726
     * @param grpBlDtListVO
     * @exception EventException
     */
    public void modifyBlObrdDt(GrpBlDtListVO grpBlDtListVO) throws EventException;

    /**
     * house bl의 description 정보를 조회한다. -- UI_BKG-0360
     * M&D에 HB/L의 정보를 추가하기 위해 사용한다.
     * 
     * @param bkgNo
     * @return List<HblForMndVO>
     * @exception EventException
     */
    public List<HblForMndVO> searchHblForMnd(String bkgNo) throws EventException;

    /**
     * House B/L의 화주 정보에 대한 template 정보를 조회한다. -- UI_BKG-0399
     * @param shprNm
     * @param cneeNm
     * @param ofcCd
     * @return HblTmpltVO
     * @exception EventException
     */
    public HblTmpltVO searchHblTmplt(String shprNm, String cneeNm, String ofcCd) throws EventException;

    /**
     * House B/L의 화주 정보에 대한 template 정보를 관리한다. -- UI_BKG-0399
     * @param hblTmpltVO
     * @param s_usr_id
     * @exception EventException
     */
    public void manageHblTmplt(HblTmpltVO hblTmpltVO, String s_usr_id) throws EventException;
    
    /**
     * Empty Repo Booking의 containe 정보, B/L 정보를 insert update한다<br>
     * 
     * @author      KimByungKyu
     * @param       MtyBookingCreateVO mtyBookingCreateVO
     * @param       SignOnUserAccount account
     * @exception   EventException
     */
    public void createMtyRepoBlCntr(MtyBookingCreateVO mtyBookingCreateVO, SignOnUserAccount account) throws EventException;

    /**
     * house bl 정보를 조회한다.-- UI_BKG-0366
     * 
     * @param BkgBlNoVO bkgBlNoVO
     * @return HblVO
     * @exception EventException
     */
    public HblVO searchHbl(BkgBlNoVO bkgBlNoVO) throws EventException;

    /**
     * House B/L, B/L Customer, Manifest 정보를 관리한다. -- UI_BKG-0366
     * @param hblVO
     * @param account
     * @param caFlg 
     * @exception EventException
     */
    public void manageHbl(HblVO hblVO, SignOnUserAccount account, String caFlg) throws EventException;

    /**
     * House B/L 정보를 저장가능한지 확인한다.-- UI_BKG-0366
     * @param hblVO
     * @exception EventException
     */
    public void validateHbl(HblVO hblVO) throws EventException;    

	/**
	 * bkg_bl_doc에 ORG_CNT_NM column을 update한다<br>
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
     * HBL에 Manifest File No를 생성하는 조건을 검사한다. -- UI_BKG-0366
     * 
     * @param BkgBlNoVO bkgBlNoVO
     * @exception EventException
     */
    public void validateMfNo(BkgBlNoVO bkgBlNoVO) throws EventException;

    /**
     * Nvocc File No 수정
     * @param bkgNo
     * @param hblSeq
     * @param nvoccFileNo
     * @param account
     * @param caFlg 
     * @exception EventException
     */
    public void modifyNvoccFileNo(String bkgNo, String hblSeq, String nvoccFileNo, SignOnUserAccount account, String caFlg) throws EventException;

    /**
     * Max HBL Manifest No를 생성한다.
     * @param bkgNo
     * @param blNo
     * @param caFlg 
     * @return String
     * @exception EventException
     */
    public String searchMaxMfNo(String bkgNo, String blNo, String caFlg) throws EventException;   
    
    /**
     * MndTsSyFlg를 생성한다.
     * @param bkgNo
     * @return String
     * @exception EventException
     */
    public String searchMndTsSyFlg (String bkgNo) throws EventException; 

	/**
     * HBL Count를 수정한다.<br>
	 * 
     * @author KimByungKyu
	 * @param hblCount
	 * @param bkgBlNoVO
	 * @param account
	 * @exception EventException
	 */
    public void modifyHblCount(int hblCount, BkgBlNoVO bkgBlNoVO, SignOnUserAccount account)  throws EventException;

    /**
     * bkg combine시 cancel되는 bkg의 package, measure, weight를 합산하여 master bkg에 더한다.
     * sourceBkg으로 bkg_bl_doc에서 pck_qty, meas_wgt, act_wgt를 차례로 읽어서 합한뒤 targetBkg의 bkg_bl_doc에 update한다.

     * @author KimByungKyu
     * @param sourceBkg
     * @param targetBkg
     * @param account
     * @exception EventException
     */
    public void combineBlDoc(BkgBlNoVO[] sourceBkg, BkgBlNoVO targetBkg, SignOnUserAccount account) throws EventException;

	/**
	 * BlCopyOutVO을 조회합니다.<br>
	 * 
	 * @param String bkgNo
	 * @return BlCopyOutVO
	 * @exception EventException
	 */
	public BlCopyOutVO searchForCopyBl(String bkgNo) throws EventException;

	/**
	 * copy를 위한 BlCopyInVO 을 확인합니다.<br>
	 * 
	 * @param BlCopyInVO blCopyInVo
	 * @return BlCopyInVO
	 * @exception EventException
	 */
	public BlCopyInVO searchForCopyBl(BlCopyInVO blCopyInVo) throws EventException;

	/**
	 * BL Copy UI에서 호출 된다.
     * MND 정보를 복사한다. -- UI_BKG-0648
	 * @param blCopyInVo
	 * @param account
	 * @return BlCopyInVO
	 * @exception EventException
	 */
	public BlCopyInVO copyDocByBlCopy(BlCopyInVO blCopyInVo, SignOnUserAccount account) throws EventException;
	
	/**
     * bkg_bl_doc의 CA 시작 정보(C/A No, C/A User, office, date)를 수정함<br>
	 * 
     * @author Lee NamKyung
	 * @param bkgBlNoVO
	 * @param account
	 * @exception EventException
	 */
	public void modifyCaStart(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException;
	
	/**
     * C/A를 위해 booking 관련 BlDocumantationBC 책임table을 복사한다.
	 * 
     * @author Lee NamKyung
	 * @param bkgBlNoVO
	 * @param copyTypeCd
	 * @exception EventException
	 */
	public void createBlCA(BkgBlNoVO bkgBlNoVO, String copyTypeCd) throws EventException;
	
	/**
     * 이전에 기록했던 CA 시작 정보(C/A No, C/A User, office, date)를 bkg_bl_doc에서 지운다.<br>
	 * 
     * @author Lee NamKyung
	 * @param bkgBlNoVO
	 * @exception EventException
	 */
	public void modifyCaComplete(BkgBlNoVO bkgBlNoVO) throws EventException;
	
	/**
	 * C/A를 위해 booking 관련 BlDocumantationBC 책임table을 삭제한다.
	 * 
	 * @author 		Lee NamKyung
	 * @param 		bkgBlNoVO
	 * @param 		copyTypeCd
	 * @exception 	EventException
	 */
	public void removeCA(BkgBlNoVO bkgBlNoVO, String copyTypeCd) throws EventException;
	
	/**
	 * empty repo Booking을 split한다.<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		MtyBookingSplitVO mtyBookingSplitVO
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void splitMtyRepoBlCntr(MtyBookingSplitVO mtyBookingSplitVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * empty Repo Booking의 container 정보, B/L 정보를 insert update delete한다.<br>
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
	 * bkg_bl_doc 테이블를 update한다.<br>
	 * 
	 * @param BkgCoffTmVO[] bkgCoffTmVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyBkgClose (BkgCoffTmVO[] bkgCoffTmVOs, SignOnUserAccount account)throws EventException;
	
	/**
	 * BL DOC 정보 수정
	 * 
	 * @param bkgBlDocVO
	 * @throws EventException
	 */
	public void modifyBlDoc(BkgBlDocVO bkgBlDocVO) throws EventException;
	
//   /** 미사용(20100402 류대영)
//     * Booking Close 여부를 판단한다.(ESM_BKG_007901)<br>
//     * @author KimByungKyu
//     * @param  BkgBlNoVO bkgBlNoVO
//     * @param  SignOnUserAccount account
//     * @return String
//     * @exception EventException
//     */
//	public String searchBkgClose(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ANCS 세관 테이블에 Customr, Container, Commodity(CM) 등의 BL 정보를 BL 테이블로 부터 다운 로드 받음
	 * 
	 * @param ManifestModificationVO[] manifestModificationVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageManifest(ManifestModificationVO[] manifestModificationVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Vessel Schedule B/L Data Release 저장이벤트를 처리한다. (ESM_BKG_0596)<br>
	 * container BDR을 처리.
	 * 
	 * @param String bkgNo
	 * @param String flag
	 * @param String usrId
	 * @exception EventException
	 */	
	public void modifyCntrCFM(String bkgNo, String flag, String usrId) throws EventException ;
	/**
	 * Vessel Schedule B/L Data Release 저장이벤트를 처리한다. (ESM_BKG_0596)<br>
	 * BKG_BL_DOC BDR을 처리.
	 * 
	 * @param String bkgNo
	 * @param String flag
	 * @param String hisFlg
	 * @param String usrId
	 * @exception EventException
	 */	
	public void modifyBKGBDR(String bkgNo, String flag, String hisFlg, String usrId) throws EventException ;
	
	/**
	 * Vessel Schedule B/L Data Release 저장이벤트를 처리한다. (ESM_BKG_0596_01)<br>
	 * BKG_BL_DOC BDR을 처리.
	 * 
	 * @param String bkgNo
	 * @param String flag
	 * @param String hisFlg
	 * @param String usrId
	 * @param String bdrRsnCd
	 * @param String bdrRsnRmk
	 * @exception EventException
	 */	
	public void modifyBKGBDRRHQ(String bkgNo, String flag, String hisFlg, String usrId, String bdrRsnCd, String bdrRsnRmk) throws EventException ;
	/**
     * eBKG에서 House B/L, B/L Customer, Manifest 정보를 관리한다. -- UI_BKG-0229-10
     * @param HblVO hblVO
	 * @param XterRqstNoVO rqstNoVO 
     * @param SignOnUserAccount account
     * @param String caFlg
     * @exception EventException
     */
    public void manageHblByXter(HblVO hblVO, XterRqstNoVO rqstNoVO, SignOnUserAccount account, String caFlg) throws EventException;
    
	/**
     * eBKG에서 Export licens 정보를 관리한다. -- UI_BKG-0229-04
     * @param BkgBlNoVO bkgBlNoVO
	 * @param AlpsXptImpLicListVO[] alpsXptImpLicListVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
	public void manageXptLicByXter(BkgBlNoVO bkgBlNoVO, AlpsXptImpLicListVO[] alpsXptImpLicListVOs, SignOnUserAccount account) throws EventException;
	/**
	 * bl rider save 
	 * @param BlRiderVO[] blRiderVOs
	 * @param SignOnUserAccount account
	 * @param String bkgNo 
	 * @throws EventException
	 */
	public void manageBlrider(BlRiderVO[] blRiderVOs, SignOnUserAccount account, String bkgNo) throws EventException;
	
    /**
     * MND 정보를 수정한다.-- UI_BKG-0079-06
     * Last VVD POL이 VNSGN Y2 이고 POD 가 KHPNH Y4 인 모든 Booking 에 문구 삽입
     * 
     * @param MndVO mndVO
     * @param SignOnUserAccount account
     * @param String caFlg
     * @exception EventException
     */
    public void manageMndCmdtDescKHPNH(MndVO mndVO, SignOnUserAccount account, String caFlg) throws EventException;
    
    /**
     * MND 정보를 수정한다.-- UI_BKG-0079-06
     * POD 가 JOAQJ 일 경우  Tariff 항목 추가 (SC일경우 shipper 나 consignee가 NBCO , RFA일때는 Shipper가 NBCO 일때만)
     * 
     * @param String bkgNo
     * @param SignOnUserAccount account
     * @param String caFlg
     * @exception EventException
     */
    public void manageMndCmdtDescJOAQJ(String bkgNo, SignOnUserAccount account, String caFlg) throws EventException;
    
    /**
     * BKG Interface Management 조회.
     * 
     * @param bkgIfManageInVO
     * @return List<BkgIfManageListVO>
     * @exception EventException
     */
	public List<BkgIfManageListVO> searchBkgIfList(BkgIfManageInVO bkgIfManageInVO) throws EventException;
	
	/**
     * searchBkgIfList01 조회.
     * 
     * @param BkgIfManagerEdiInputVO bkgIfManagerEdiInputVO
     * @param String msgTypeCd
     * @return List<BkgIfManagerEdiVO>
     * @exception EventException
     */
	public List<BkgIfManagerEdiVO> searchBkgIfList01(BkgIfManagerEdiInputVO bkgIfManagerEdiInputVO, String msgTypeCd) throws EventException;
	
	/**
	 * ESM_BKG_3004 : customer click <br>
	 * Customer정보를 Flat File로 생성하여 EDI로 전송한다.<br>
	 * 
	 * @param BkgBlNoVO[] bkgBlNoVO
	 * @param CustTpIdVO[] custTpIdVO
	 * @param String typeGbn
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String bkgManagerEdiMulti(BkgBlNoVO[] bkgBlNoVO, CustTpIdVO[] custTpIdVO, String typeGbn, SignOnUserAccount account) throws EventException;
	
	/**
	 * Customer EDI로 전송 BackEndJob 결과확인<br>
	 * 
	 * @param String key
	 * @return String
	 * @throws EventException
	 */
	public String searchBkgSendList(String key) throws EventException;
	
    /**
     * P/O & Other No.화면에 값들이 setup화면에 세팅되어있는대로 존재하는지 조회
     * @param String bkgNo
     * @return String
     * @throws EventException
     */
    public String searchPoExist(String bkgNo) throws EventException;
    
    /**
     * RVIS_CNTR_CUST_TP_CD 조회.
     * @param String bkgNo
     * @param String caFlg
     * @return String 
     * @throws EventException
     */
    public String searchRvisCntrCustTpCd(String bkgNo, String caFlg) throws EventException;
    
    
    /**
     * 위험화물 문구가 포함된 BKG의 문구중 가장 등급이 높은 문구를 조회한다.
     * @param BkgDescVO bkgDescVO
     * @return String[]
     * @throws EventException
     */
    public String[] searchkeywordByBkg(BkgDescVO bkgDescVO) throws EventException;
    
    
    /**
     * Booking Vvd 정보를 조회한다.(ESM_BKG_0079_06)<br>
     * @param String bkgNo
     * @param String caFlg
     * @return List<VslSkdVO>
     * @throws EventException
     */
    public List<VslSkdVO> searchVvdSkdForTsRouteKNPNH(String bkgNo, String caFlg) throws EventException;
    
    /**
     * POL이 나이지리아일 경우 EXS 데이터 존재여부<br>
     * POD이 나이지리아일 경우 ENS 데이터 존재여부<br>
     * @param String bkgNo
     * @return String
     * @throws EventException
     */
    public String []chkNgExsEnsNo(String bkgNo) throws EventException;
    
    /**
     * POL이 토고일 경우 ECTN 데이터 존재여부<br>
     * POD이 토고일 경우 ECTN 데이터 존재여부<br>
     * @param String bkgNo
     * @return String
     * @throws EventException
     */
    public String []chkTgEctnNo(String bkgNo) throws EventException;
    

	/**
	 * BL body에 찍힐 WPM관련 문구를 생성한다.
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String oldDesc
	 * @param String usrId
	 * @throws EventException
	 */
	public void modifyBlDescByWpm(BkgBlNoVO bkgBlNoVO, String oldDesc, String usrId) throws EventException;
	
	/**
	 * CNTR 콤보를 위해 컨테이너를 검색한다.
	 * @param String bkgNo
	 * @return List<CntrComboVO>
	 * @throws EventException
	 */
	public List<CntrComboVO> searchCntrList(String bkgNo) throws EventException;
	
	/**
     * US filer가 01이면서 C/M 탭에 Self가 찍혀있다면 
     * BKG Creation의 화면에 저장된 BKG,SI Contact 이메일로 notification을 보낸다
     * @param String bkgNo
     * @param String caFlg
     * @return String[]
     * @throws EventException
     */
    public String[] checkSelfFilingCM(String bkgNo, String caFlg) throws EventException;
    
    /**
     * CM에서 이메일 보내기 
     * @param String bkgNo
     * @param String emailAdd
     * @param CmSelfMailVO cmSelfMailVO
     * @return BkgNtcHisVO
     * @throws EventException
     */
    public BkgNtcHisVO sendChkSelfCMByEmail (String bkgNo, String emailAdd, CmSelfMailVO cmSelfMailVO) throws EventException;
    
    /**
     * Self auto notification 내용 검색
     * @param String bkgNo
     * @param String caFlg
     * @return CmSelfMailVO
     * @exception DAOException
     */
    public CmSelfMailVO searchContentsForSelfMail(String bkgNo, String caFlg) throws EventException;
    
    /**
     * CM에서 Self로 인해 auto email이 나갔었는지 여부 체크
     * @param String bkgNo
     * @return String
     * @throws EventException
     */
    public String chkCsEmailHisoty(String bkgNo) throws EventException;
    
    /**
     * CM에서 Self가 있는지의 여부만 판단
     * @param String bkgNo
     * @param String caFlg
     * @return String
     * @exception DAOException
     */
    public String chkSelfFlgCM(String bkgNo, String caFlg) throws EventException;
   	
	/**
	 * XTER VGM Request List 정보를 조회 한다.
	 * 
	 * @param XterVgmRqstListInputVO xterVgmRqstListInputVO
	 * @return List<XterVgmRqstListVO>
	 * @throws EventException
	 */
	public List<XterVgmRqstListVO> searchXterVgmList(XterVgmRqstListInputVO xterVgmRqstListInputVO) throws EventException;

	/**
	 * XTER VGM 정보를 Update 전 validation 확인 한다.
	 * 
	 * @param XterVgmRqstListVO xterVgmRqstListVO
	 * @return XterVgmInfoValidationVO
	 * @throws EventException
	 */
	public XterVgmInfoValidationVO searchXterVgmInfoValidation(XterVgmRqstListVO xterVgmRqstListVO) throws EventException;
	
	/**
	 * XTER VGM 정보를 Update 한다.
	 * 
	 * @param XterVgmRqstListVO xterVgmRqstListVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void uploadXterVgmInfo(XterVgmRqstListVO xterVgmRqstListVO, SignOnUserAccount account) throws EventException;
	
	/**
     * Export Import 인바운드가 터키인 BKG의 Consignee, Notify tax id 데이터 유무 판단
     * @param String bkgNo
     * @param String caFlg
     * @return String
     * @throws DAOException
     */
    public String checkTurkeyTaxId(String bkgNo, String caFlg) throws EventException;

}