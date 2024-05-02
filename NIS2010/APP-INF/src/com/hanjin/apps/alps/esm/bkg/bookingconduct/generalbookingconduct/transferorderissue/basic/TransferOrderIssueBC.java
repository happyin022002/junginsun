/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TransferOrderIssueBC.java
*@FileTitle : TRO(Transportation Request Order) for Inland Haulage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.04.30 이남경
* 1.0 Creation
* 2010.09.02 김민정 [CHM-201005290-01] Booking Split 할때 TRO 자동 배분 기능 추가개발
* 2011.10.27 윤태승 [CHM-201113981-01]ALPS > Booking Creation > TRO/O remarks 에 문구 삽입 요청드립니다.
* 2012.06.25 전성진 [CHM-201217633] 구주 Hinterland Operation 개선 Project - T1&Revenue Guideline 적용
* 2014.02.07 문동선 [CHM-201428756] TROI notice 화면상 CNTR 선택기능 및 글자굵기 수정요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.basic;

import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SelectTroVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.BkgEurCntrListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.BkgTroActCustExtVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.BkgTroXterIfVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.CombineTroNewSeqVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroMstVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroMtyRelByCtmVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.GlineRevInVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.GlineRevOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroActCustDefaultVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroActCustVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroCfmVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroDtlVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroMultiBkgVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroMultiCancelFrustVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgEurTroVO;
import com.hanjin.syscommon.common.table.BkgTroActCustVO;
import com.hanjin.syscommon.common.table.BkgTroActRepVO;
import com.hanjin.syscommon.common.table.MdmCustomerVO;




/**
 * ALPS-Generalbookingconduct Business Logic Command Interface<br>
 * - ALPS-Generalbookingconduct에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Lee Nam Kyung
 * @see Esm_bkg_0079_02cEventResponse 참조
 * @since J2EE 1.4
 */

public interface TransferOrderIssueBC {

	/**
	 * (ESM_BKG_0079_02A) 구주 Tro 관련 조회처리<br>
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  String boundCd
	 * @param  String rtnTroFlg
	 * @param  SignOnUserAccount account
	 * @return TroVO
	 * @exception EventException
	 */
	public TroVO searchTro(BkgBlNoVO bkgBlNoVO, String boundCd, String rtnTroFlg, SignOnUserAccount account) throws EventException;

	/**
	 * (ESM_BKG_0079_02C) 구주 Tro 관련 조회처리<br>
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  String boundCd
	 * @param  SignOnUserAccount account
	 * @return EurTroVO
	 * @exception EventException
	 */
	public EurTroVO searchEurTro(BkgBlNoVO bkgBlNoVO, String boundCd, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * (ESM_BKG_0079_02B) [KR]Tro Request 이벤트 처리<br>
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  String troSeq
	 * @param  String modCd
	 * @param  String rtnTroFlg
	 * @param  String ownrTrkFlg
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void createTroEdi(BkgBlNoVO bkgBlNoVO, String troSeq, String modCd, String rtnTroFlg, String ownrTrkFlg,SignOnUserAccount account) throws EventException;

	/**
	 * (ESM_BKG_0079_02B) [KR]Tro Request 완료여부 수정처리<br>
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  String troSeq
	 * @param  String rtnTroFlg
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyBkgTroRqst(BkgBlNoVO bkgBlNoVO, String troSeq, String rtnTroFlg, SignOnUserAccount account) throws EventException;

	/**
	 * (ESM_BKG_0079_02B) [KR]Tro Request Receive 저장처리<br>
	 * @author Lee NamKyung
	 * @param  String flatfile
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void receiptHjtTroEdiAck(String flatfile, SignOnUserAccount account) throws EventException;

	/**
	 * (ESM_BKG_0079_02A) 미주 Tro 관련 저장처리<br>
	 * @author Lee NamKyung
	 * @param  TroVO troVO
	 * @param  account SignOnUserAccount
	 * @return Map<String,Object>
	 * @exception EventException
	 */
	public Map<String,Object> manageTro(TroVO troVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * (ESM_BKG_0079_02A) 한국 Tro 관련 저장처리<br>
	 * @author Lee NamKyung
	 * @param  TroVO troVO
	 * @param  account SignOnUserAccount
	 * @return Map<String,Object>
	 * @exception EventException
	 */
	public Map<String,Object> manageKrTro(TroVO troVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * (ESM_BKG_0079_01) Booking Full Return CY -> TRO Rerturn cy update<br>
	 * @author Yun TaeSeung
	 * @param  String bkgNo
	 * @param  account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyKrTroReturnCy(String bkgNo, SignOnUserAccount account) throws EventException;
	
	/**
	 * (ESM_BKG_0079_01) Booking POL:KR, RCV Term CFS -> TRO Create<br>
	 * @author jklim
	 * @param  String bkgNo
	 * @param  account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageTroKrCfs(String bkgNo, SignOnUserAccount account) throws EventException;
	
	/**
	 * (ESM_BKG_0079_02B) Tro TRO/O Tab 의 Remarks에 문구 삽입<br>
	 * @author Yun TaeSeung
	 * @param  TroVO troVO
	 * @param  account SignOnUserAccount
	 * @return Map<String,Object>
	 * @exception EventException
	 */
	public Map<String,Object> modifyKrTroRmk(TroVO troVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * (ESM_BKG_0079_02C) 구주 Tro 관련 저장처리<br>
	 * @author Lee NamKyung
	 * @param  EurTroVO eurTroVO
	 * @param  account SignOnUserAccount
	 * @return Map<String,Object>
	 * @exception EventException
	 */
	public Map<String,Object> manageEurTro(EurTroVO eurTroVO, SignOnUserAccount account) throws EventException;

	/**
	 * (ESM_BKG_0907) EurTro의 Cntainer 조회<br>
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  String boundCd
	 * @return List<BkgEurCntrListVO>
	 * @exception EventException
	 */
	public List<BkgEurCntrListVO> searchEurTroCntrList(BkgBlNoVO bkgBlNoVO, String boundCd) throws EventException;

	/**
	 * (ESM_BKG_0704) IFResult 조회<br>
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @return List<BkgTroXterIfVO>
	 * @exception EventException
	 */
	public List<BkgTroXterIfVO> searchTroIfResultList(BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
	 * (ESM_BKG_0703) cancel/frust 처리대상 조회<br>
	 * @author Lee NamKyung
	 * @param  String io_bnd_cd
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @return List<TroMultiCancelFrustVO>
	 * @exception EventException
	 */
	public List<TroMultiCancelFrustVO> searchEurTroForCancelFrust(String io_bnd_cd, BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
	 * (ESM_BKG_0921) Multi 조회<br>
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  String cntrNo
	 * @param  String boundCd
	 * @return List<TroMultiBkgVO>
	 * @exception EventException
	 */
	public List<TroMultiBkgVO> searchMultiBkg(BkgBlNoVO bkgBlNoVO, String cntrNo, String boundCd) throws EventException;

	/**
	 * ESM_BKG_0079_02c 화면의 confirm팝업(ESM_BKG_0906)시, confirm 대상 조회<br>
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  String boundCd
	 * @return TroCfmVO
	 * @exception EventException
	 */
	public TroCfmVO searchEurTroListForCfm(BkgBlNoVO bkgBlNoVO, String boundCd) throws EventException;
	
	/**
	 * confirm 이벤트 처리<br>
	 * ESM_BKG_0079_02c 화면의 confirm팝업(ESM_BKG_0906)시 confirm 처리<br>
	 * @author Lee NamKyung
	 * @param  TroCfmVO troCfmVO
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void confirmEurTro(TroCfmVO troCfmVO, SignOnUserAccount account) throws EventException;

	/**
	 * ESM_BKG_0079_02C 화면의 ESM_BKG_0703 popup에서 cancel/Frust 처리<br>
	 * @author Lee NamKyung
	 * @param  TroMultiCancelFrustVO[] troMultiCancelFrustVOs
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelFrustEurTro(TroMultiCancelFrustVO[] troMultiCancelFrustVOs, SignOnUserAccount account) throws EventException;

	/**
	 * ESM_BKG_0079_02C 화면의 ESM_BKG_0920 popup에서 TroCopy 처리<br>
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO sourceBkg
	 * @param  String boundCd
	 * @param  String sourceTroSeq
	 * @param  BkgBlNoVO[] arrTagetBkgBlNoVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyTro(BkgBlNoVO sourceBkg, String boundCd, String sourceTroSeq, BkgBlNoVO[] arrTagetBkgBlNoVO, SignOnUserAccount account) throws EventException;	

	
	/* : confirm 관련로직시, 수정후 사용예정
	/--**
	 * (ESM_BKG_0079_02C : ESM_BKG_0703 popup)<br>
	 * @author Lee NamKyung
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String boundCd
	 * @param String troSeq
	 * @param String newTroStsCd
	 * @exception EventException
	 *--/
	public void changeEurTroStatus(BkgBlNoVO bkgBlNoVO, String boundCd, String troSeq, String newTroStsCd) throws EventException;
	*/

	/**
	 * (ESM_BKG_0905) TroActCust Dtl I/U/D 처리<br>
	 * @author Lee NamKyung
	 * @param troActCustVO TroActCustVO
	 * @param account SignOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String manageTroActCust(TroActCustVO troActCustVO, SignOnUserAccount account) throws EventException;

	/**
	 * (ESM_BKG_0905) Customer탭 마스터 조회<br>
	 * @author Lee NamKyung
	 * @param  String custCntCd
	 * @param  String custSeq
	 * @param  String custNm
	 * @return List<MdmCustomerVO>
	 * @exception EventException
	 */
	public List<MdmCustomerVO> searchMdmCustForTro(String custCntCd, String custSeq, String custNm) throws EventException;

	/**
	 * (ESM_BKG_0905) Customer탭 상세 조회<br>
	 * @author Lee NamKyung
	 * @param  String ofcCd
	 * @param  String cntCd
	 * @param  String custSeq
	 * @return List<BkgTroActCustVO>
	 * @exception EventException
	 */
	public List<BkgTroActCustVO> searchTroActCustByCust(String ofcCd, String cntCd, String custSeq) throws EventException;
	
	/**
	 * (ESM_BKG_0905) ActCustRep Master 조회<br>
	 * @author Lee NamKyung
	 * @param  String doorLoc
	 * @param  String ofcCd
	 * @param  String custNm
	 * @return List<BkgTroActRepVO>
	 * @exception EventException
	 */
	public List<BkgTroActRepVO> searchActCustRep(String doorLoc, String ofcCd, String custNm) throws EventException;

	/**
	 * (ESM_BKG_0905) TroActCust Eq Dtl 조회<br>
	 * @author Lee NamKyung
	 * @param  String doorLoc
	 * @param  String ofcCd
	 * @param  String troActRepSeq
	 * @return List<BkgTroActCustExtVO>
	 * @exception EventException
	 */
	public List<BkgTroActCustExtVO> searchTroActCustByEq(String doorLoc, String ofcCd, String troActRepSeq) throws EventException;

	/**
	 * (ESM_BKG_0905) Vendor Name 조회<br>
	 * @author Lee NamKyung
	 * @param  String cntCd
	 * @param  String vndrSeq
	 * @return String
	 * @exception EventException
	 */
	public String searchVndrName(String cntCd, String vndrSeq) throws EventException;

	/**
	 * (ESM_BKG_0079_02C) CntrNo별 Cago weight 조회<br>
	 * @author    Lee NamKyung
	 * @param     String bkgNo
	 * @param     String cntrNo
	 * @return    String
	 * @exception EventException
	 */
	public String searchBkgCntrWgt(String bkgNo, String cntrNo) throws EventException;
	
	/**
	 * (ESM_BKG_0317) Search Guideline Revenue<br>
	 * @author    Jeon Sungjin
	 * @param     GlineRevInVO glineRevInVO
	 * @return    GlineRevOutVO
	 * @exception EventException
	 */
	public GlineRevOutVO searchGlineRev(GlineRevInVO glineRevInVO) throws EventException;
	
	/**
	 * (ESM_BKG_0905) Open시, Default값 초기화를 위한 정보 조회<br>
	 * @author Lee NamKyung
	 * @param  String doorLoc
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @return TroActCustDefaultVO
	 * @exception EventException
	 */
	public TroActCustDefaultVO searchTroActCustDefault(String doorLoc, BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
	 *  BKG_TRO Flag 변경.(ESM_BKG_0079_01)<br>
	 * @author 	Kim Byung Kyu
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @param 	SignOnUserAccount account
     * @exception EventException
     */
    public void unconfirmTro(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException;

	/**
	 * BKG_EUR_TRO Flag 변경.(ESM_BKG_0079_01)<br>
	 * @author 	Kim Byung Kyu
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @param 	String boundCd
	 * @param 	SignOnUserAccount account
     * @exception EventException
     */
    public void unconfirmEurTro(BkgBlNoVO bkgBlNoVO, String boundCd, SignOnUserAccount account) throws EventException;
    
    /**
     * tro 관련 정보를 sourceBkg에서 targetBkg으로 복사한다. <br>
     * 
     * @param String copyModeCd
     * @param BkgBlNoVO sourceBkg
     * @param BkgBlNoVO[] targetBkg
     * @param List<SelectTroVO> selectTroVO
     * @param String troTp
     * @param SignOnUserAccount account
     * @return List<CombineTroNewSeqVO>
     * @exception EventException
     */
    public List<CombineTroNewSeqVO> copyTroByBkg(String copyModeCd, BkgBlNoVO sourceBkg, BkgBlNoVO[] targetBkg, List<SelectTroVO> selectTroVO,String troTp, SignOnUserAccount account) throws EventException; 

    /**
	 * (ESM_BKG_0229_06) eBooking Tro 관련 저장처리<br>
	 * : Tro/EurTro 포함 
	 * 
	 * @author Lee NamKyung
	 * @param  TroVO troVO
	 * @param  EurTroVO eurTroVO
	 * @param  String isEurFlg
	 * @param  SignOnUserAccount account
	 * @return Map<String,Object>
	 * @exception EventException
	 */
	public Map<String,Object> manageTroByXter(TroVO troVO, EurTroVO eurTroVO, String isEurFlg, SignOnUserAccount account) throws EventException;
	
	/**
	 * CTM에서 EUR mty release를 했을 때의 처리<br>
	 *
	 * @param EurTroMtyRelByCtmVO eurTroMtyRelByCtmVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyEurTroByEmptyRelease(EurTroMtyRelByCtmVO eurTroMtyRelByCtmVO, SignOnUserAccount account) throws EventException;
	
	/**
     * inland route Validation<br>
     * 변경하려는 route가 inland route로 등록되어 있는지 확인한다.<br>
     * @author 		Ryu Daeyoung
	 * @param       BkgBlNoVO bkgBlNoVO
	 * @param 		String boundCd
	 * @param       String fullCy
	 * @param       String door
	 * @param		String trspModCd
	 * @exception 	EventException
	 */
	public void validateInlaneRoute(BkgBlNoVO bkgBlNoVO, String boundCd, String fullCy, String door, String trspModCd) throws EventException;
	
	/**
     * USA TRO 에 cancel시에 SO 여부 check ..<br>
     * @author 		Shin JaYoung
	 * @param       BkgBlNoVO bkgBlNoVO
	 * @param 		String boundCd
	 * @param       String troSeq
	 * @param       SignOnUserAccount account
	 * @exception 	EventException
	 */
	//public void validateSoCancel(String bkgNo, String boundCd, String troSeq) throws EventException;
	
	/**
     * eur tro에 pctl_no를 갱신한다..<br>
     * @author 		Ryu Daeyoung
	 * @param       BkgBlNoVO bkgBlNoVO
	 * @param 		String boundCd
	 * @param       String troSeq
	 * @param       SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void modifyEurTroPctlNo(BkgBlNoVO bkgBlNoVO, String boundCd, String troSeq,  SignOnUserAccount account) throws EventException;
	
	/**
     * general tro에 pctl_no를 갱신한다..<br>
     * @author 		Ryu Daeyoung
	 * @param       BkgBlNoVO bkgBlNoVO
	 * @param       String troSeq
	 * @param       SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void modifyTroPctlNo(BkgBlNoVO bkgBlNoVO, String troSeq,  SignOnUserAccount account) throws EventException;
	
	/**
	 * tro 관련 정보를 sourceBkg에서 targetBkg으로 복사한다.
	 * @param sourceBkg String 
	 * @param targetBkgNoList String[]
	 * @param account SignOnUserAccount
	 * @throws EventException
	 */
	public void copyTroBySplit(String sourceBkg, String[] targetBkgNoList, SignOnUserAccount account) throws EventException;

	/**
	 * sourceBkg을 cancel한다.
	 * @param sourceBkg String 
	 * @param targetBkgNoList String[]
	 * @param account SignOnUserAccount
	 * @throws EventException
	 */
	public void cancelTroBySplit(String sourceBkg, String[] targetBkgNoList, SignOnUserAccount account) throws EventException;
	
	/** (ESM_BKG_0317) Search arbitary Revenue<br>
	 * @author    Kim Jinjoo
	 * @param     GlineRevInVO glineRevInVO
	 * @return    List<GlineRevOutVO>
	 * @exception EventException
	 */
	public List<GlineRevOutVO> searchArbitraryRev(GlineRevInVO glineRevInVO) throws EventException;	
	
	/** (ESM_BKG_0317) Search arbitary Revenue<br>
	 * @author    Kim Jinjoo
	 * @param     GlineRevInVO glineRevInVO
	 * @return    List<GlineRevOutVO>
	 * @exception EventException
	 */
	public List<GlineRevOutVO> searchArbitraryRevChk(GlineRevInVO glineRevInVO) throws EventException;	
	
	/** (ESM_BKG_1139) Cntr List 조회한다.<br>
	 * @author    Moon Dongsun
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @return    List<BkgEurTroVO>
	 * @exception EventException
	 */
	public List<BkgEurTroVO> searchTroCntrListByBkg(BkgBlNoVO bkgBlNoVO) throws EventException;	
	
	/**
	 * cop상의 qty와 tro qty일치하는지 check
	 * @param TroDtlVO troDtlVO
	 * @return String
	 * @throws EventException
	 */
	public String checkCopQty(TroDtlVO troDtlVO) throws EventException;
	
	
	/**
	 * inv로 운임이 if되었는지 체크
	 * @param String bkgNo
	 * @param String cntrNo
	 * @return String
	 * @throws EventException
	 */
	public String checkInvChgIf(String bkgNo, String cntrNo) throws EventException;
	
	/**Return CY,pick up cy정보를 업데이트한다.
	 * @param EurTroMstVO vo
	 * @throws EventException
	 */
	public void modifyEurTroCyInfo(EurTroMstVO vo) throws EventException; 
}