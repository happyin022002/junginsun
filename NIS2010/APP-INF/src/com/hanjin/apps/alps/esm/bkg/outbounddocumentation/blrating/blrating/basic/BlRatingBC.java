/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BlRatingBC.java
 *@FileTitle : Exchange Rate
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.18
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.06.18 김영출
 * 1.0 Creation
=========================================================
 History
 2010.11.04 이일민 [CHM-201005869-01] Collection Office / Code자동 업데이트 관련 수정 요청 (Customer Code 변경 및 B/L Issue 화면 연동)
 2010.11.04 이일민 [CHM-201005878-01] Split 01-Collection Office / Code자동 업데이트 관련 수정 요청 (Customer Code 변경 및 B/L Issue 화면 연동)
 2011.10.20 정선용 [CHM-201113441-01] BKG 화면의 C.OFC 및 C.REP SELECT POPUP 추가 요청
 2012.09.18 조정민 [CHM-201219895] [BKG] Memo split 시 Manul/ Auto 관계없이 모든 charge copy 되지 않도록 logic 수정 요청
 2013.04.19 김진주 [CHM-201323704] [Charge Adjustment] 팝업 개발 및 오토레이팅 연계 요청
 2013.05.27 김진주 [CHM-201324374] [TMO - Surcharge 종합 시스템 구축 ] Surcharge tariff 오토레이팅 배치 로직 요청
 2013.11.06 김진주 [CHM-201327427] [BKG/DOC - Revenue Audit System] 수입심사 배치대상 추가 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroCfmVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgBookingInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgChgRateVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgCntrVgmInfoListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgModiOfcPrcVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgQtyOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgRevCostVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BlKrWhfExptVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ChargeAdjustmentVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ChargeRemarkVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.CntrRtOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.CntrRtVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.CoveredBlListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ExchangeRateVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.GroupRatingVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.InvIfDiffVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ChargeAmendAuthRequestVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ChargeAmendAuthRequestListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ChargeAmendAuthDetailVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.OrganizationChartVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.PpdCctCustInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.PpdCctCustOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateMainInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateQtyVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.RfaInformInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.RfaInformOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScInformInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScInformListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScInformOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScNoteInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScNoteOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchFocByFreightListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchRatingApplyDateVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchScOftAutoratingListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchTpbInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ServiceScopeVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.TaaInformInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.TaaInformListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.TaaInformOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.EmailPpdInfoVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.PriEmailTargetListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgRateVO;

/**
 * NIS2010-Blrating Business Logic Command Interface<br>
 * - NIS2010-Blrating에 대한 비지니스 로직에 대한 인터페이스<br>
 *  
 * @author Kim Youngchul
 * @see Esm_bkg_0945EventResponse 참조
 * @since J2EE 1.6
 */

public interface BlRatingBC {
	/**
	 * EsmBkg007908Event 저장 이벤트 처리<br>
	 * BlRatingDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * BKG_CHG_RT_HIS Data에 해당하는 Master정보를 처리한다.
	 * 
	 * @author LEE JIN SEO
	 * @param RateInVO rateInVO
	 * @exception EventException
	 */
	public void autoRatingHistory(RateInVO rateInVO)  throws EventException;
	/**
	 * EsmBkg007908Event 저장 이벤트 처리<br>
	 * BlRatingDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * BKG_CHG_RT Data에 해당하는 Master정보를 처리한다.
	 * 
	 * @author LEE JIN SEO
	 * @param RateMainInfoVO  rateMainInfoVO 
	 * @param String caflag
	 * @exception EventException
	 */
	public void modifyChgRateMaster(RateMainInfoVO rateMainInfoVO, String caflag)  throws EventException;
	/**
	 * BlRatingDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 다건의 BKG_CHG_RT Data에 해당하는 정보를 처리한다.
	 * @author LEE JIN SEO
	 * @param RateInVO rateInVO
	 * @throws EventException
	 */
	public void manageRate(RateInVO rateInVO)  throws EventException;
	
	/**
	 * EsmBkg007908Event 저장 이벤트 처리<br>
	 * BlRatingDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * BKG_CHG_RT Data에 해당하는 정보를 처리한다.
	 * 
	 * @author LEE JIN SEO
	 * @param CoveredBlListVO  coveredBlListVO 
	 * @param String caflag
	 * @exception EventException
	 */
	public void modifyCoveredBl(CoveredBlListVO  coveredBlListVO, String caflag)  throws EventException;
	/**
	 * EsmBkg007908Event 조회 이벤트 처리<br>
	 * PRI 에서 Audit 이후 Status 업데이트 처리한다.<br>
	 * 
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String audSts
	 * @param SignOnUserAccount account
	 * @param String caFlg
	 * @exception EventException
	 */
	public void modifyAudSts(String bkgNo, String audSts, SignOnUserAccount account,  String caFlg ) throws EventException;
	/**
	 * EsmBkg007908Event 조회 이벤트 처리<br>
	 * PRI 에서 Audit 이후 revAudDt 업데이트 처리한다.<br>
	 * 
	 * @author KIM TAE KYOUNG
	 * @param String bkgNo
	 * @param String revAudDt
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyAudDt(String bkgNo, String revAudDt, SignOnUserAccount account) throws EventException ;
	

	/**
	 * Contract(S/C, RFA, TAA) Amend시, amend된 Contract의 Effective Date 이전의 
	 * Application Date 정보를 가지는 BKG들에 운임 확인 요청하는 내용의 자동메일 발송됨
	 * 메일자동발행 대상 BKG을 심사 BATCH 대상에 추가하기 위해 revenue Audit Date 업데이트 처리
	 * 
	 * @author KIM JIN JOO
	 * @param List<PriEmailTargetListVO>  priEmailTargetList
	 * @exception EventException
	 */

	public void modifyAudDt(List<PriEmailTargetListVO> priEmailTargetList) throws EventException;
	
	/**
	 * EsmBkg0906Event 저장 이벤트 처리<br>
	 * TRO 에서 CHG 를 넣기 위해 BKG_RATE 에 Insert 한다.<br>
	 * 
	 * @author KIM TAE KYOUNG
	 * @param String bkgNo
	 * @param String caFlg
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	
	public void createRateForTro(String bkgNo, String caFlg,SignOnUserAccount account) throws EventException;
	/**
	 * EsmBkg0961Event 조회 이벤트 처리<br>
	 * Booking customer 화면에 대한 조회 이벤트 처리<br>
	 * 화면번호 : ESM_BKG_0961 Booking customer Inquiry <<관련 Use Case UC-BKG-012:
	 * Rating Creation>>
	 * 
	 * @author LEE JIN SEO
	 * @param PpdCctCustInVO ppdCctCustInVO
	 * @return List<PpdCctCustOutVO>
	 * @exception EventException
	 */
	public List<PpdCctCustOutVO> searchPayerCode(PpdCctCustInVO ppdCctCustInVO) throws EventException;

	/**
	 * EsmBkg0270Event 조회 이벤트 처리<br>
	 * Freight & Charge_S/C Note 를 조회한다<br>
	 * 
	 * @author LEE JIN SEO
	 * @param ScNoteInVO scNoteInVO
	 * @return List<ScNoteOutVO>
	 * @exception EventException
	 */
	public List<ScNoteOutVO> searchScNote(ScNoteInVO scNoteInVO) throws EventException;

	/**
	 * EsmBkg0265Event 조회 이벤트 처리<br>
	 * Freight & Charge_Freight & Charge Remark 를 조회한다<br>
	 * 
	 * @author LEE JIN SEO
	 * @param String bkg_no
	 * @param String ca_flg
	 * @return List<ChargeRemarkVO>
	 * @exception EventException
	 */
	public List<ChargeRemarkVO> searchChargeRemark(String bkg_no, String ca_flg) throws EventException;

	/**
	 * EsmBkg0265Event 조회 이벤트 처리<br>
	 * Freight & Charge_Freight & Charge Remark 를 조회한다<br>
	 * 
	 * @author LEE JIN SEO
	 * @param String  bkg_no
	 * @param String  ca_flg
	 * @param String diff_rmk
	 * @param String inter_rmk
	 * @param String doc_inter_rmk
	 * @param String  user_id
	 * @exception EventException
	 */
	public void manageChargeRemark(String bkg_no, String ca_flg, String diff_rmk, String inter_rmk, String doc_inter_rmk, String user_id) throws EventException;

	/**
	 * EsmBkg0264Event 조회 이벤트 처리<br>
	 * Freight & Charge_BKG Q'TY Inquiry 를 조회한다<br>
	 * 
	 * @author LEE JIN SEO
	 * @param String bkg_no
	 * @return List<BkgQtyOutVO>
	 * @exception EventException
	 */
	public List<BkgQtyOutVO> searchQtyForRate(String bkg_no) throws EventException;

	/**
	 * EsmBkg0269Event 조회 이벤트 처리<br>
	 * Freight & Charge_S/C Information 를 조회한다<br>
	 * BKG 데이터 조회
	 * 
	 * @author LEE JIN SEO
	 * @param ScInformInVO scInformInVO
	 * @return ScInformOutVO
	 * @exception EventException
	 */
	public ScInformOutVO searchScInform(ScInformInVO scInformInVO) throws EventException;

	/**
	 * EsmBkg0739 , EsmBkg0269Event 조회 이벤트 처리<br>
	 * TP/CGO/QTY 를 조회한다<br>
	 * 
	 * @author LEE JIN SEO
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List<RateQtyVO>
	 * @exception EventException
	 */
	public List<RateQtyVO> searchRateQtyList(BkgBlNoVO bkgBlNoVO) throws EventException;
	
	/**
	 * EsmBkg0269Event 조회 이벤트 처리<br>
	 * Freight & Charge_S/C Information 를 조회한다<br>
	 * BKG Customer와 PRI에서 S/C Customer를 조회한다
	 * 
	 * @author LEE JIN SEO
	 * @param ScInformInVO scInformInVO
	 * @return List<ScInformListVO>
	 * @exception EventException
	 */
	public List<ScInformListVO> searchScInformList(ScInformInVO scInformInVO) throws EventException;

	/**
	 * EsmBkg0739Event 조회 이벤트 처리<br>
	 * Freight & Charge_S/C Information 를 조회한다<br>
	 * RFA에 입력된 운임 정보
	 * 
	 * @author LEE JIN SEO
	 * @param RfaInformInVO rfaInformInVO
	 * @return RfaInformOutVO
	 * @exception EventException
	 */
	public RfaInformOutVO searchRfaInform(RfaInformInVO rfaInformInVO) throws EventException;
	
	/**
     * EsmBkg0739Event 조회 이벤트 처리<br>
     * BKG Container VGM Info를 조회한다<br>
     * 
     * @author KIM DONG HO
     * @param String bkg_no
     * @param String ca_flg
     * @return List<BkgCntrVgmInfoListVO>
     * @exception EventException
     */
    public List<BkgCntrVgmInfoListVO> searchBkgCntrVGMInfoList(String bkg_no, String ca_flg) throws EventException;

	/**
	 * EsmBkg0771Event 조회 이벤트 처리<br>
	 * BKG No로 현재 Master BKG가 가지고 있는 Covered B/L No를 조회한다<br>
	 * 
	 * @author LEE JIN SEO
	 * @param String bkg_no
	 * @param String bl_no
	 * @param String caFlg
	 * @return List<CoveredBlListVO>
	 * @exception EventException
	 */
	public List<CoveredBlListVO> searchCoveredBl(String bkg_no, String bl_no, String caFlg) throws EventException;

	/**
	 * EsmBkg0771Event 저장 이벤트 처리<br>
	 * 해당 BKG_NO를 Master B/L로 하는 Covered B/L의 Master B/L 정보를 Null로 업데이트 한다<br>
	 * 
	 * @author LEE JIN SEO
	 * @param String bkg_no
	 * @param String bl_no
	 * @param CoveredBlListVO[] coveredBlListVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String manageCoveredBl(String bkg_no, String bl_no, CoveredBlListVO[] coveredBlListVOs,SignOnUserAccount account) throws EventException;

	/**
	 * EsmBkg0945Event 조회 이벤트 처리<br>
	 * Exchange Rate 를 조회한다<br>
	 * 
	 * @author LEE JIN SEO
	 * @param String bkg_no
	 * @return List<ExchangeRateVO>
	 * @exception EventException
	 */
	public List<ExchangeRateVO> searchXchRt(String bkg_no) throws EventException;

	/**
	 * EsmBkg007908Event 조회 이벤트 처리<br>
	 * Freight & Charge - 를 조회한다<br>
	 * 
	 * @author LEE JIN SEO
	 * @param RateInVO rateInVO
	 * @return RateOutVO
	 * @exception EventException
	 */
	 public RateOutVO searchRate(RateInVO rateInVO) throws EventException;
	
	/**
	 * Cargo Receiving Date 수정 <br>
	 * 
	 * @param String bkgNo 
	 * @param String crdDt
	 * @param String caFlg
	 * @exception EventException
	 */
	public void manageCrdDt(String bkgNo, String crdDt, String caFlg) throws EventException;

	/**
	 * removeCntrRateByCntr
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @param String cntrRtSeq
	 * @exception EventException
	 */
	public void removeCntrRateByCntr(String bkgNo, String cntrNo, String cntrRtSeq) throws EventException;

	/**
	 * changeCntrRate
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @param String cntrNoOld
	 * @exception EventException 
	 */
	public void changeCntrRate(String bkgNo, String cntrNo, String cntrNoOld) throws EventException;

	/**
	 * booking split 시 bkg_rate 테이블과 bkg_chg_rate 테이블의 manual rate 부분을 복사한다. <br>
	 * 
	 * @param BkgBlNoVO sourceBkg
	 * @param BkgBlNoVO[] targetBkg
	 * @param SignOnUserAccount account
	 * @param String splitRsnCd
	 * @throws EventException
	 */
	public void copyManualChgByBkg(BkgBlNoVO sourceBkg, BkgBlNoVO[] targetBkg, SignOnUserAccount account, String splitRsnCd) throws EventException;
	
	/**
     * booking ESM_BKG_0079_02c 화면의 confirm팝업에서, confirm시 처리.(ESM_BKG_0906)    
     * : boundCd == 'I' 일때만 실행됨
     * 
     * @author Lee NamKyung
     * @param  TroCfmVO troCfmVO
     * @param  SignOnUserAccount account
     * @return String
     * @throws EventException
     */
    public String createCHRevenue(TroCfmVO troCfmVO, SignOnUserAccount account) throws EventException;
    
    /**
     * bkg_cod_cost에서 bkg_chg_rt 로 rehandling charge를 복사한다.
     * 
     * @param String codRqstSeq
     * @param BkgBlNoVO bkgBlNoVO
     * @param SignOnUserAccount account
     * @throws EventException
     */
    public void addCodRehandlingChg (String codRqstSeq, BkgBlNoVO bkgBlNoVO, SignOnUserAccount account ) throws EventException;

    /**
     * sourceBkg의 bkg_chg_rt정보를 targetBkg로 복사한다.(ESM_BKG_0076)
     * 
	 * @author 	Jun Yong Jin
     * @param BkgBlNoVO[] sourceBkg
     * @param BkgBlNoVO targetBkg
     * @param SignOnUserAccount account
     * @throws EventException
     */
    public void copyChgRateByBkg(BkgBlNoVO[] sourceBkg, BkgBlNoVO targetBkg, SignOnUserAccount account ) throws EventException;
    
	/**
	 * C/A를 위해 해당 bkg의 table들을 복사한다.
	 * 
	 * @author 		Lee NamKyung
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		String copyTypeCd
	 * @exception 	EventException
	 */
	public void createRateCA(BkgBlNoVO bkgBlNoVO, String copyTypeCd) throws EventException;
	
	/**
	 * C/A를 위해 해당 bkg의 table들을 삭제한다.
	 * 
	 * @author 		Lee NamKyung
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		String copyTypeCd
	 * @exception 	EventException
	 */
	public void removeCA(BkgBlNoVO bkgBlNoVO, String copyTypeCd) throws EventException;

    /**
     * Container Rate를 조회하는 메소드.
     *
     * @author KimYoungchul
     * @param String bkgNo
     * @return CntrRtOutVO
     * @exception EventException
     */
    public CntrRtOutVO searchCntrRate(String bkgNo) throws EventException;

    /**
     * Container Rate를 수정하는 메소드.
     *
     * @author KimYoungchul
     * @param List<CntrRtVO> cntrRtVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageCntrRate(List<CntrRtVO> cntrRtVOs, SignOnUserAccount account) throws EventException;

    /**
     * Container 별 Rate 배분.
     * 
     * @author KimYoungchul
     * @param String bkgNo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void distributeCntrRate(String bkgNo, SignOnUserAccount account) throws EventException;
    
	/**
	 * booking copy시 ppd ofc와 cct ofc를 copy해준다.
	 * 
	 * @author 	Kim Byung Kyu
	 * @param  	BkgBlNoVO sourceBkg
	 * @param   BkgBlNoVO targetBkg
	 * @param   SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void copyPpdCctByBkg(BkgBlNoVO sourceBkg , BkgBlNoVO targetBkg, SignOnUserAccount account) throws EventException;

    
    /**
     * B/L별 한국 Wharfage 면제 사유 및 면제 화주 등록 정보 수정
     * 
     * @param BlKrWhfExptVO blKrWhfExptVO
     * @param SignOnUserAccount account
     * @exception   EventException
     */
    public void modifyBlKrWhfExpt( BlKrWhfExptVO blKrWhfExptVO, SignOnUserAccount account ) throws EventException;
    
    /**
     * Wharfage 정보를 조회한 후 존재하면 UPDATE, 존재하지 않으면 INSERT 처리
     * 
     * @param BkgRateVO bkgRateVO
     * @exception   EventException
     */
    public void manageWhfExptInfo(BkgRateVO bkgRateVO) throws EventException;

    /**
     * manage Frt Term Cd
     * 
     * @author KimYoungchul
     * @param String bkgNo
     * @param String frtTermCd
     * @param String frtTermPrnFlg
     * @param SignOnUserAccount account 
     * @param String caFlg
     * @exception EventException
     */
    public void manageFrtTerm(String bkgNo, String frtTermCd, String frtTermPrnFlg, SignOnUserAccount account, String caFlg) throws EventException;
    
    /**
	 * EsmBkg1076Event 조회 이벤트 처리<br>
	 * Freight & Charge_Taa Information 를 조회한다<br>
	 * BKG 데이터 조회
	 * 
	 * @author KIM TAE KYOUNG
	 * @param TaaInformInVO taaInformInVO
	 * @return TaaInformOutVO
	 * @exception EventException
	 */
	public TaaInformOutVO searchTaaInform(TaaInformInVO taaInformInVO) throws EventException;

	/**
	 * EsmBkg1076Event 조회 이벤트 처리<br>
	 * Freight & Charge_Taa Information 를 조회한다<br>
	 * BKG Customer와 PRI에서 Taa Customer를 조회한다
	 * 
	 * @author KIM TAE KYOUNG
	 * @param TaaInformInVO taaInformInVO
	 * @return List<TaaInformListVO>
	 * @exception EventException
	 */
	public List<TaaInformListVO> searchTaaInformList(TaaInformInVO taaInformInVO) throws EventException;
	
	/**
	 * EsmBkg1077Event 조회 이벤트 처리<br>
	 * Rating Application Date Search.<br>
	 * 
	 * @author KIM TAE KYOUNG
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<SearchRatingApplyDateVO>
	 * @exception EventException
	 */
	public List<SearchRatingApplyDateVO> searchRatingApplyDate(String bkgNo, String caFlg) throws EventException;
    
	/**
	 * TPB 관련 대상을 조회한다.<br>
	 * 
	 * @param String bkgNo
	 * @param String ntcSeq
	 * @return List<SearchTpbInfoVO>
	 * @exception EventException
	 */
	public List<SearchTpbInfoVO> searchTpbInfo(String bkgNo, String ntcSeq) throws EventException;
    
	/**
	 * Collect, 3rd Collect 를 조회한다.<br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<SearchFocByFreightListVO>
	 * @exception EventException
	 */
	public List<SearchFocByFreightListVO> searchFocByFreightList(String bkgNo,String caFlg) throws EventException;
	
	/**
	 * PPD, CLT CNT_CODE UPDATE 를 한다 <br>
	 * 
	 * @author KIM TAE KYOUNG
	 * @param String bkgNo
	 * @param SignOnUserAccount account
	 * @param String caFlg
	 * @exception EventException
	 */
	public void modifyRateCntCd(String bkgNo, SignOnUserAccount account,  String caFlg ) throws EventException;
	
	/**
	 * EsmBkg007908Event 조회 이벤트 처리<br>
	 * PRI 에서 Audit 이후 Status 업데이트 처리한다.<br>
	 * 
	 * @authorKIM TAE KYOUNG
	 * @param String bkgNo
	 * @param String ctrtTpCd
	 * @param SignOnUserAccount account
	 * @param String caFlg
	 * @exception EventException
	 */
	public void modifyCtrtTpCd(String bkgNo, String ctrtTpCd, SignOnUserAccount account,  String caFlg ) throws EventException;

	/**
	 * callBkgModiIssOfcPrc 프러시져 호출
	 * @param  BkgModiOfcPrcVO bkgModiOfcPrcVO
	 * @throws EventException
	 */
    public void callBkgModiIssOfcPrc(BkgModiOfcPrcVO bkgModiOfcPrcVO) throws EventException;

	/**
	 * callBkgModiChgOfcPrc 프러시져 호출
	 * @param  BkgModiOfcPrcVO bkgModiOfcPrcVO
	 * @throws EventException
	 */
    public void callBkgModiChgOfcPrc(BkgModiOfcPrcVO bkgModiOfcPrcVO) throws EventException;
    
    /**
	 **  Freight & Charge 화면(ESM_BKG_0079_08)화면에서 SC No. or RFA No. or TAA No.
	 *  옆 검색 버튼을 누를 때 팝업을 연결하기 위한 필수조건인 Amend Sequend를 조회한다.
	 *  
	 * @author 		Cho wonjoo
	 * @param  		String ctrtType
	 * @param  		String ctrtNo
	 * @param  		String applicationDate
	 * @return 		String 
	 * @exception   EventException
	 */
	public String searchAmdtSeq(String ctrtType, String ctrtNo, String applicationDate) throws EventException ;
	
	/**
	 * bkg정보 조회 
	 * @param BkgBlNoVO schBkgBlNoVO
	 * @return BkgBookingInfoVO
	 * @throws EventException
	 */
	public BkgBookingInfoVO searchBkgBookingInfo(BkgBlNoVO schBkgBlNoVO)throws EventException ;
	

	/**OFT Rating 가능여부, 사용자, 날짜를 BKG RATE에 저장한다.
	 * @param String bkgNo
	 * @param String caFlg
	 * @param String oftMssFlg
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void moidfyOftPrecheckResult(String bkgNo, String caFlg, String oftMssFlg, SignOnUserAccount account ) throws EventException;
	

	
	/** CMPB산출을 위해 BKG Creation/Update시 BKG Volume에 해당되는 최저 Revenue만 남기고 나머지 정보는 삭제함
	 * @param String bkgNo
	 * @throws EventException
	 */
	public void modifyChargeRateTempForCMPB(String bkgNo) throws EventException;

	/**
	 * DHF Adjustment Location을 조회한다<br>
	 * 
	 * @param String  bkgNo
	 * @param String  caFlg
	 * @return ChargeAdjustmentVO
	 * @exception EventException
	 */
	public ChargeAdjustmentVO searchDHFAdjustment(String bkgNo, String caFlg) throws EventException ;
	
	/**
	 *DDC Adjustment Currency를 조회한다<br>
	 * 
	 * @param String  bkgNo
	 * @param String  caFlg
	 * @return ChargeAdjustmentVO
	 * @exception EventException
	 */
	public ChargeAdjustmentVO searchDDCAdjustment(String bkgNo, String caFlg) throws EventException;
	
	/**DHF Adjustment Location 저장
	 * @param ChargeAdjustmentVO vo
	 * @throws EventException
	 */
	public void modifyDHFAdjustment(ChargeAdjustmentVO vo) throws EventException;
	
	/**DDC Adjustment Currency 저장
	 * @param ChargeAdjustmentVO vo
	 * @throws EventException
	 */
	public void modifyDDCAdjustment(ChargeAdjustmentVO vo) throws EventException;
	
	/**
	 * EsmBkg007908Event 저장 이벤트 처리<br>
	 * Tariff Surcharge 정보를 저장.<br>
	 * 
	 * @author JIN JOO KIM
	 * @param List<SearchScOftAutoratingListVO> surList
	 * @param String caFlag
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void addTariffSurchargeRate(List<SearchScOftAutoratingListVO> surList, String caFlag, SignOnUserAccount account)  throws EventException;


	/**
	 * EsmBkg2006Event 조회 이벤트 처리<br>
	 * Invoice I/F Temp테이블과 BKG_CHG_RT 테이블을 비교하여 Diff발생한 BKG을 조회<br>
	 * 
	 * @author JIN JOO KIM
	 * @param InvIfDiffVO  vo
	 * @return List<InvIfDiffVO>
	 * @exception EventException
	 */
	public List<InvIfDiffVO> searchInvoiceInterfaceDifference(InvIfDiffVO vo) throws EventException ;


	/**
	 * BKG에 해당되는 Service Scope 목록 조회<br>
	 * 
	 * @author JIN JOO KIM
	 * @param String  bkgNo
	 * @param String  caFlg
	 * @return List<ServiceScopeVO>
	 * @exception EventException
	 */
	public List<ServiceScopeVO> searchServiceScopeList(String bkgNo, String caFlg) throws EventException;
	
	/**
	 * BKG에 해당되는 Service Scope 목록 조회<br>
	 * 
	 * @author JIN JOO KIM
	 * @param String  bkgNo
	 * @param String  caFlg
	 * @return List<RateMainInfoVO>
	 * @exception EventException
	 */
	public List<RateMainInfoVO> searchRateMainInfo(String bkgNo, String caFlg) throws EventException;
	
	/**
	 * BKG에 해당되는 Prepaid Charge Amout 조회<br>
	 * 
	 * @author JIN JOO KIM
	 * @param String  bkgNo
	 * @return String
	 * @exception EventException
	 */
	public String searchPpdChgAmt(String bkgNo) throws EventException;
	
	/**
	 * Email 전송을 위한 Prepaid 정보 조회<br>
	 * 
	 * @author JIN JOO KIM
	 * @param String  bkgNo
	 * @param String  usrId
	 * @return List<EmailPpdInfoVO>
	 * @exception EventException
	 */
	public List<EmailPpdInfoVO> searchPpdChgInfo(String bkgNo, String usrId) throws EventException;
	
	/**
	 * Email 전송을 위한 대상자 Email 조회<br>
	 * 
	 * @author JIN JOO KIM
	 * @param String  bkgNo
	 * @return String
	 * @exception EventException
	 */
	public String searchPpdChgRlsEmail(String bkgNo) throws EventException;
	
	/**
	 * Email 전송 - Prepaid Amount 변경시 BL Issue 담당자에게 Email 전송<br>
	 * 
	 * @author JIN JOO KIM
	 * @param List<EmailPpdInfoVO> list
	 * @param String usrEml
	 * @param String accoutUsrEml
	 * @param String accuntUsrNm
	 * @exception EventException
	 */
	public void sendEmailPpdAmount(List<EmailPpdInfoVO> list, String usrEml, String accoutUsrEml, String accuntUsrNm) throws EventException;
	
	/**
	 * BKG에 해당되는 Prepaid Charge Amout 조회<br>
	 * 
	 * @author JIN JOO KIM
	 * @param String  bkgNo
	 * @return String
	 * @exception EventException
	 */
	public String searchPpdChgAmtFlg(String bkgNo) throws EventException;
	
	/**
	 * BKG에 해당되는 Retroactive Flag 수정<br>
	 * 
	 * @param String  bkgNo
	 * @param String  rtroKndCd
	 * @param String  caflag
	 * @exception EventException
	 */
	public void modifyRtroactiveKindCd(String bkgNo, String rtroKndCd, String caflag) throws EventException;
	

	/**
	 * Booking에 저장되어 있는 OFT 목록을 조회합니다.<br>
	 * 
	 * @param String bkgNo
	 * @param String chgCd
	 * @return List<ChgAmdAuthDtlVO>
	 * @exception EventException
	 */
	public List<ChargeAmendAuthDetailVO> searchCurrentOftList(String bkgNo, String chgCd) throws EventException;
	
	/** Charge Amend 승인 요청을 생성하고 승인자에거 메일을 발송한다.
	 * @param ChargeAmendAuthRequestVO request
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createChargeAmendAuthRequest(ChargeAmendAuthRequestVO request, SignOnUserAccount account) throws EventException;
    
    /**
     *  Charge Amend 요청에 대한 Approval/Reject 권한을 가진 사용자인지 조회한다.<br>
     * @param 	SignOnUserAccount account
     * @return	String
	 * @throws Exception
	 * @throws EventException
     */
    public String searchChargeAmendApprovalAuth(SignOnUserAccount account) throws EventException ;


	/**
	 * Charge Amend권한 승인 요청 목록을 조회<br>
	 * 
	 * @param ChargeAmendAuthRequestListVO vo
	 * @param SignOnUserAccount account
	 * @return List<ChargeAmendAuthRequestListVO>
	 * @exception EventException
	 */
	public List<ChargeAmendAuthRequestListVO> searchChargeAmendAuthRequestList(ChargeAmendAuthRequestListVO vo, SignOnUserAccount account) throws EventException;

	/**
	 * Charge Amend 승인 요청을 생성하고 승인자에거 메일을 발송한다.
	 * 
	 * @param ChargeAmendAuthRequestListVO vo
	 * @param String authType
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyChargeAmendAuthRequestStatus(ChargeAmendAuthRequestListVO vo, String authType, SignOnUserAccount account) throws EventException;

	/**
	 * Exempt Request 승인받은 Interface된 Charge를 삭제
	 * 
	 * @param ChargeAmendAuthRequestListVO vo
	 * @throws EventException
	 */
	public void removeInterfaceCharge(ChargeAmendAuthRequestListVO vo) throws EventException;
	
	/**
	 * 조직도를 조회합니다.<br>
	 * 
	 * @param OrganizationChartVO organizationChartVO
	 * @return List<OrganizationChartVO>
	 * @exception EventException
	 */
	public List<OrganizationChartVO> searchOrganizationChart(OrganizationChartVO organizationChartVO) throws EventException;
    
    /**
     *  TEMP테이블상 저장된 Revenue Amount를 조회한다.
     *  Application Date / 경리 환율 기준으로 USD 환산한 값
     * @param  BkgRevCostVO revCostVO
     * @return BkgRevCostVO
	 * @throws Exception
	 * @throws EventException
     */
    public BkgRevCostVO searchRevenueAmount(BkgRevCostVO revCostVO) throws EventException;

	/**
	 * Revenue Amount 상세정보를 조회 <br>
	 * 
	 * @param SignOnUserAccount account
	 * @return List<BkgChgRateVO>
	 * @exception EventException
	 */
	public List<BkgChgRateVO> searchRevenueAmountDetail(SignOnUserAccount account) throws EventException;
    
    /**
     *  이전에 산출한 Revenue와  Revenue를 비교한다.
     *  두 값이 다른 경우에만  CMPB INSERT<br>
     * @param  BkgRevCostVO revCostVO
     * @return String
	 * @throws Exception
	 * @throws EventException
     */
    public String checkRevenueAmountDifference(BkgRevCostVO revCostVO) throws EventException;
    

	/**
	 * Revenue와 BKG TEU Qty를 Insert한다
	 * 
	 * @param BkgRevCostVO revCostVO
	 * @throws EventException
	 */
	public void createRevenueAmount(BkgRevCostVO revCostVO) throws EventException;

	
	/**
	 * Revenue Amount 상세정보를 저장한다.
	 * 
	 * @param List<BkgChgRateVO> revDtlVOs
	 * @throws EventException
	 */
	public void createRevenueAmountDetail(List<BkgChgRateVO> revDtlVOs) throws EventException;
	
	/**
	 * Group & Multi B/L Rating을 위한  목록 조회<br>
	 * 
	 * @param GroupRatingVO vo
	 * @return List<GroupRatingVO>
	 * @exception EventException
	 */
	public List<GroupRatingVO> searchGroupRatingList(GroupRatingVO vo) throws EventException;

	/**
	 * Group & Multi B/L Rating Self Check저장
	 * 
	 * @param GroupRatingVO ratinglist
	 * @throws EventException
	 */
	public void modifyGroupRatingList(GroupRatingVO ratinglist) throws EventException;
	
	/**
	 * EsmBkg1605Event 저장 이벤트 처리<br>
	 * BKG_AUTO_RT_HIS 정보를 저장
	 * 
	 * @param String bkgNo
	 * @exception EventException
	 */
	public void autoRatingHistory(String bkgNo)  throws EventException;

	
	/**
	 * EsmBkg1605Event GroupRating 이벤트 처리<br>
	 * BKG_RATE와 BKG_CHG_RT 를 저장한다.
	 * 
	 * @param RateMainInfoVO rateMainInfoVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGroupRating(RateMainInfoVO rateMainInfoVO, SignOnUserAccount account) throws EventException;
    
	/**
     *  조회한 운임으로 Group Rating 가능한 상태인지 확인<br>
     * @param  String bkgNo
     * @return String
	 * @throws Exception
	 * @throws EventException
     */
    public String searchGroupRatingStatus(String bkgNo) throws EventException;
    
	/**
	 * Group Rating 상태저장
	 * 성공/실패여부, 실패시 실패사유 저장
	 * 
	 * @param String bkgNo
	 * @param String grpRatRsltCd
	 * @param String grpRatFailRsnCd
	 * @throws EventException
	 */
	public void modifyGroupRatingStatus(String bkgNo, String grpRatRsltCd, String grpRatFailRsnCd) throws EventException;
	
	/**
	 * TPF Interface
	 * Group Rating에서는 I/F여부를 사용자에게 확인받지 않고 무조건 I/F진행.
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageTPFSurcharge(String bkgNo, String caFlg, SignOnUserAccount account) throws EventException;
	
	/**
	 * EsmBkg007901 checkOftRateMatch 조회 이벤트 처리
	 * SC OFT계산결과를 체크한다.
	 * @param String bkgNo
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void sendRateCheckNotice(String bkgNo, SignOnUserAccount account) throws EventException;
	
	/**
     * Charge Rate 삭제
     * 
     * @param List<BkgChgRateVO> listVO
     * @param String caflag
     * @throws EventException
     */
    public void removeChgRate(List<BkgChgRateVO> listVO, String caflag) throws EventException;
    
	/**
	 * BKG_AUTO_RT_OCN_FRT_TMP 가 생성
	 * @param String bkgNo
	 * @throws EventException
	 */
	public void createOcnFrtTmpByChgRt(String bkgNo) throws EventException;
}
