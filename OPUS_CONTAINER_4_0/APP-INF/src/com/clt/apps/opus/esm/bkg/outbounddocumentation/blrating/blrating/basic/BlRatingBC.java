/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BlRatingBC.java
 *@FileTitle : Exchange Rate
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroCfmVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgChgRateVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgModiOfcPrcVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgQtyOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.BlKrWhfExptVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.ChargeRemarkVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.CntrRtOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.CntrRtVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.CoveredBlListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.DocLocVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.ExchangeRateVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.PpdCctCustInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.PpdCctCustOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateMainInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateQtyVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.RfaInformInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.RfaInformOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScInformInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScInformListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScInformOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScNoteInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScNoteOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchFocByFreightListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchRatingApplyDateVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchTpbInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.TaaInformInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.TaaInformListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.TaaInformOutVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgInvTaxIfVO;
import com.clt.syscommon.common.table.BkgRateVO;

/**
 * OPUS-Blrating Business Logic Command Interface<br>
 * - OPUS-Blrating biz Logic Interface<br>
 * 
 * @author
 * @see Esm_bkg_0945EventResponse reference
 * @since J2EE 1.6
 */

public interface BlRatingBC {
	
	/**
	 * Searching the Master Info of BKG_CHG_RT_HIS Data
	 * 
	 * @param RateInVO rateInVO
	 * @exception EventException
	 */
	public void autoRatingHistory(RateInVO rateInVO)  throws EventException;
	
	/**
	 * Modifying the Master Info of BKG_CHG_RT Data
	 * 
	 * @param RateMainInfoVO  rateMainInfoVO 
	 * @param String caflag
	 * @exception EventException
	 */
	public void modifyChgRateMaster(RateMainInfoVO rateMainInfoVO, String caflag)  throws EventException;
	
	/**
	 * Modifying the multiple Master Info of BKG_CHG_RT Data

	 * @param RateInVO rateInVO
	 * @throws EventException
	 */
	public void manageRate(RateInVO rateInVO)  throws EventException;
	
	/**
	 * Modifying the Master Info of BKG_CHG_RT Data
	 * 
	 * @param CoveredBlListVO  coveredBlListVO 
	 * @param String caflag
	 * @exception EventException
	 */
	public void modifyCoveredBl(CoveredBlListVO  coveredBlListVO, String caflag)  throws EventException;
	
	/**
	 * Updating the Status after Audit in PRI<br>
	 * 
	 * @param String bkgNo
	 * @param String audSts
	 * @param SignOnUserAccount account
	 * @param String caFlg
	 * @exception EventException
	 */
	public void modifyAudSts(String bkgNo, String audSts, SignOnUserAccount account,  String caFlg ) throws EventException;

	/**
	 * Updating the revAudDt after Audit in PRI<br>
	 * 
	 * @param String bkgNo
	 * @param String revAudDt
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyAudDt(String bkgNo, String revAudDt, SignOnUserAccount account) throws EventException ;
	
	/**
	 * Insert to BKG_RATE for the CHG in TRO<br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createRateForTro(String bkgNo, String caFlg,SignOnUserAccount account) throws EventException;

	/**
	 * Searching for Booking customer screen<br>
	 * ESM_BKG_0961 Booking customer Inquiry << Use Case UC-BKG-012:Rating Creation>>
	 * 
	 * @param PpdCctCustInVO ppdCctCustInVO
	 * @return List<PpdCctCustOutVO>
	 * @exception EventException
	 */
	public List<PpdCctCustOutVO> searchPayerCode(PpdCctCustInVO ppdCctCustInVO) throws EventException;

	/**
	 * Searching the Freight & Charge_S/C Note<br>
	 * 
	 * @param ScNoteInVO scNoteInVO
	 * @return List<ScNoteOutVO>
	 * @exception EventException
	 */
	public List<ScNoteOutVO> searchScNote(ScNoteInVO scNoteInVO) throws EventException;

	/**
	 * Searching the Freight & Charge_Freight & Charge Remark<br>
	 * 
	 * @param String bkg_no
	 * @param String ca_flg
	 * @return List<ChargeRemarkVO>
	 * @exception EventException
	 */
	public List<ChargeRemarkVO> searchChargeRemark(String bkg_no, String ca_flg) throws EventException;

	/**
	 * Searching the Freight & Charge_Freight & Charge Remark<br>
	 * 
	 * @param String bkg_no
	 * @param String diff_rmk
 	 * @param String inter_rmk
	 * @param String user_id
	 * @param String ca_flg
	 * @exception EventException
	 */
	public void manageChargeRemark(String bkg_no, String diff_rmk, String inter_rmk, String user_id, String ca_flg) throws EventException;

	/**
	 * Searching the Freight & Charge_BKG Q'TY Inquiry<br>
	 * 
	 * @param String bkg_no
	 * @return List<BkgQtyOutVO>
	 * @exception EventException
	 */
	public List<BkgQtyOutVO> searchQtyForRate(String bkg_no) throws EventException;

	/**
	 * Searching the Freight & Charge_S/C Information<br>
	 * 
	 * @param ScInformInVO scInformInVO
	 * @return ScInformOutVO
	 * @exception EventException
	 */
	public ScInformOutVO searchScInform(ScInformInVO scInformInVO) throws EventException;

	/**
	 * Searching the TP/CGO/QTY<br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List<RateQtyVO>
	 * @exception EventException
	 */
	public List<RateQtyVO> searchRateQtyList(BkgBlNoVO bkgBlNoVO) throws EventException;
	
	/**
	 * Searching the Freight & Charge_S/C Information<br>
	 * Searching the BKG Customer and S/C Customer in PRI
	 * 
	 * @param ScInformInVO scInformInVO
	 * @return List<ScInformListVO>
	 * @exception EventException
	 */
	public List<ScInformListVO> searchScInformList(ScInformInVO scInformInVO) throws EventException;

	/**
	 * Searching the Freight & Charge_S/C Information in RFA<br>
	 * 
	 * @param RfaInformInVO rfaInformInVO
	 * @return RfaInformOutVO
	 * @exception EventException
	 */
	public RfaInformOutVO searchRfaInform(RfaInformInVO rfaInformInVO) throws EventException;

	/**
	 * Searching the Covered B/L No of Master BKG by BKG No.<br>
	 * 
	 * @param String bkg_no
	 * @param String bl_no
	 * @param String caFlg
	 * @return List<CoveredBlListVO>
	 * @exception EventException
	 */
	public List<CoveredBlListVO> searchCoveredBl(String bkg_no, String bl_no, String caFlg) throws EventException;

	/**
	 * Updating the Master B/L of Covered B/L as Null<br>
	 * 
	 * @param String bkg_no
	 * @param String bl_no
	 * @param CoveredBlListVO[] coveredBlListVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String manageCoveredBl(String bkg_no, String bl_no, CoveredBlListVO[] coveredBlListVOs,SignOnUserAccount account) throws EventException;

	/**
	 * Searching the Exchange Rate<br>
	 * 
	 * @param String bkg_no
	 * @return List<ExchangeRateVO>
	 * @exception EventException
	 */
	public List<ExchangeRateVO> searchXchRt(String bkg_no) throws EventException;

	/**
	 * Searching the Freight & Charge<br>
	 * 
	 * @param RateInVO rateInVO
	 * @return RateOutVO
	 * @exception EventException
	 */
	 public RateOutVO searchRate(RateInVO rateInVO) throws EventException;
	
	/**
	 * Modifying the Cargo Receiving Date<br>
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
	 * Copying the manual rate in the bkg_rate table and bkg_chg_rate table when the booking split<br>
	 * 
	 * @param BkgBlNoVO sourceBkg
	 * @param BkgBlNoVO[] targetBkg
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyManualChgByBkg(BkgBlNoVO sourceBkg, BkgBlNoVO[] targetBkg, SignOnUserAccount account) throws EventException;
	
	/**
     * ESM_BKG_0079_02c : confirm (ESM_BKG_0906)    
     * permitted if boundCd == 'I'
     * 
     * @param  TroCfmVO troCfmVO
     * @param  SignOnUserAccount account
     * @return String
     * @throws EventException
     */
    public String createCHRevenue(TroCfmVO troCfmVO, SignOnUserAccount account) throws EventException;
    
    /**
     * Copying the rehandling charge from bkg_cod_cost table to bkg_chg_rt table
     * 
     * @param String codRqstSeq
     * @param BkgBlNoVO bkgBlNoVO
     * @param SignOnUserAccount account
     * @throws EventException
     */
    public void addCodRehandlingChg (String codRqstSeq, BkgBlNoVO bkgBlNoVO, SignOnUserAccount account ) throws EventException;

    /**
     * Copying the bkg_chg_rt Info of sourceBkg to targetBkg(ESM_BKG_0076)
     * 
     * @param BkgBlNoVO[] sourceBkg
     * @param BkgBlNoVO targetBkg
     * @param SignOnUserAccount account
     * @throws EventException
     */
    public void copyChgRateByBkg(BkgBlNoVO[] sourceBkg, BkgBlNoVO targetBkg, SignOnUserAccount account ) throws EventException;
    
	/**
	 * Copying the BKG tables for C/A
	 * 
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		String copyTypeCd
	 * @exception 	EventException
	 */
	public void createRateCA(BkgBlNoVO bkgBlNoVO, String copyTypeCd) throws EventException;
	
	/**
	 * Deleting the BKG tables for C/A
	 * 
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		String copyTypeCd
	 * @exception 	EventException
	 */
	public void removeCA(BkgBlNoVO bkgBlNoVO, String copyTypeCd) throws EventException;

    /**
     * Searching the Container Rate
     *
     * @param String bkgNo
     * @return CntrRtOutVO
     * @exception EventException
     */
    public CntrRtOutVO searchCntrRate(String bkgNo) throws EventException;

    /**
     * Modifying the Container Rate
     *
     * @param List<CntrRtVO> cntrRtVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageCntrRate(List<CntrRtVO> cntrRtVOs, SignOnUserAccount account) throws EventException;

    /**
     * Rate by Container
     * 
     * @param String bkgNo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void distributeCntrRate(String bkgNo, SignOnUserAccount account) throws EventException;
    
	/**
	 * Copying the ppd ofc and cct ofc
	 * 
	 * @param  	BkgBlNoVO sourceBkg
	 * @param   BkgBlNoVO targetBkg
	 * @param   SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void copyPpdCctByBkg(BkgBlNoVO sourceBkg , BkgBlNoVO targetBkg, SignOnUserAccount account) throws EventException;

    
    /**
     * Modifying the exempted reason and exempted shipper Info of KOREA Wharfage
     * 
     * @param BlKrWhfExptVO blKrWhfExptVO
     * @param SignOnUserAccount account
     * @exception   EventException
     */
    public void modifyBlKrWhfExpt( BlKrWhfExptVO blKrWhfExptVO, SignOnUserAccount account ) throws EventException;
    
    /**
     * Updating or Inserting the Wharfage Info 
     * 
     * @param BkgRateVO bkgRateVO
     * @exception   EventException
     */
    public void manageWhfExptInfo(BkgRateVO bkgRateVO) throws EventException;

    /**
     * manage Frt Term Cd
     * 
     * @param String bkgNo
     * @param String frtTermCd
     * @param String frtTermPrnFlg
     * @param SignOnUserAccount account 
     * @param String caFlg
     * @exception EventException
     */
    public void manageFrtTerm(String bkgNo, String frtTermCd, String frtTermPrnFlg, SignOnUserAccount account, String caFlg) throws EventException;
    
    /**
	 * Searching the Freight & Charge_Taa Information<br>
	 * 
	 * @param TaaInformInVO taaInformInVO
	 * @return TaaInformOutVO
	 * @exception EventException
	 */
	public TaaInformOutVO searchTaaInform(TaaInformInVO taaInformInVO) throws EventException;

	/**
	 * Searching the Freight & Charge_Taa Information<br>
	 * Searching the Taa Customer in BKG Customer and PRI
	 * 
	 * @param TaaInformInVO taaInformInVO
	 * @return List<TaaInformListVO>
	 * @exception EventException
	 */
	public List<TaaInformListVO> searchTaaInformList(TaaInformInVO taaInformInVO) throws EventException;
	
	/**
	 * Rating Application Date Search.<br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<SearchRatingApplyDateVO>
	 * @exception EventException
	 */
	public List<SearchRatingApplyDateVO> searchRatingApplyDate(String bkgNo, String caFlg) throws EventException;
    
	/**
	 * Searching the TPB Info<br>
	 * 
	 * @param String bkgNo
	 * @param String ntcSeq
	 * @return List<SearchTpbInfoVO>
	 * @exception EventException
	 */
	public List<SearchTpbInfoVO> searchTpbInfo(String bkgNo, String ntcSeq) throws EventException;
    
	/**
	 * Searching the Collect, 3rd Collect<br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<SearchFocByFreightListVO>
	 * @exception EventException
	 */
	public List<SearchFocByFreightListVO> searchFocByFreightList(String bkgNo,String caFlg) throws EventException;
	
	/**
	 * Updating the PPD, CLT CNT_CODE<br>
	 * 
	 * @param String bkgNo
	 * @param SignOnUserAccount account
	 * @param String caFlg
	 * @exception EventException
	 */
	public void modifyRateCntCd(String bkgNo, SignOnUserAccount account,  String caFlg ) throws EventException;
	
	/**
	 * Updating the ctrtTpCd
	 * 
	 * @param String bkgNo
	 * @param String ctrtTpCd
	 * @param SignOnUserAccount account
	 * @param String caFlg
	 * @exception EventException
	 */
	public void modifyCtrtTpCd(String bkgNo, String ctrtTpCd, SignOnUserAccount account,  String caFlg ) throws EventException;

	/**
	 * callBkgModiIssOfcPrc
	 * @param  BkgModiOfcPrcVO bkgModiOfcPrcVO
	 * @throws EventException
	 */
    public void callBkgModiIssOfcPrc(BkgModiOfcPrcVO bkgModiOfcPrcVO) throws EventException;

	/**
	 * callBkgModiChgOfcPrc
	 * @param  BkgModiOfcPrcVO bkgModiOfcPrcVO
	 * @throws EventException
	 */
    public void callBkgModiChgOfcPrc(BkgModiOfcPrcVO bkgModiOfcPrcVO) throws EventException;
    
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
	 * Searching Doc Adjustment<br>
	 * 
	 * @param RateMainInfoVO rateMainInfoVO
	 * @param String caFlg
	 * @return List<DocLocVO>
	 * @exception EventException
	 */
	public List<DocLocVO> searchDocAdjInfo(RateMainInfoVO rateMainInfoVO, String caFlg) throws EventException;
	
	/**
	 * Updating Doc Adjustment<br>
	 * 
	 * @param RateMainInfoVO rateMainInfoVO
	 * @param String caFlg
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageDocAdj(RateMainInfoVO rateMainInfoVO, String caFlg, SignOnUserAccount account) throws EventException;
	
	/**
	 * Saving the BKG list for recalculating TAX - exchange rate change<br>
	 * 
	 * @param List<BkgInvTaxIfVO> listVO
	 * @throws EventException
	 */
	public void addInvTaxIf(List<BkgInvTaxIfVO> listVO) throws EventException;
	
	/**
	 * Saving the BKG list for recalculating TAX - exchange rate change<br>
	 * 
	 * @param BkgChgRateVO[] bkgChgRateVOs
	 * @param String bkgNo
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageTaxRateBatch(BkgChgRateVO[] bkgChgRateVOs, String bkgNo, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * BKG_RATE<br>
	 * 
	 * @param RateMainInfoVO rateMainInfoVO
	 * @param String caflag
	 * @exception DAOException
	 */
    public void modifyChgRateBkgRate(RateMainInfoVO rateMainInfoVO ,String caflag) throws EventException;
	
	
    
}
