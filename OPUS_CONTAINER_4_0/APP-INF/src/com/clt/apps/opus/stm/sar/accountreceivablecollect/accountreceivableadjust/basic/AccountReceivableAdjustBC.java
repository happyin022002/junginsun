/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : AccountReceivableAdjustBC.java
 *@FileTitle : AccountReceivableAdjustBC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.03.03 authorName
 * 1.0 Creation
 * --------------------------------------------------------
 * History
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.basic;

import java.util.List;

import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SarAsaMstVO;
import com.clt.syscommon.common.table.SarOffstMstVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.SapInvoiceInterfaceDetailVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.AdjViewAccountingListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.AdjustCondVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.AdjustDtlListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.AdjustHdrListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.AdjustNoSeqVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.ApIfSetVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.AutoSettlementInfoVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.AutoSettlementSubInfoVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.AutosettlementCondVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.OffsetAPPopupListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.OffsetARPopupListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.OffsetInfoVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.OtsTypeExcludeListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.SapInvIfDtlVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.SapInvIfHdrVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.SarAcctMtxVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.AROfficeListVO;
	
/**
 * AccountReceivableAdjustBC Business Logic 
 * - Handling AccountReceivableAgent Business transaction.
 * 
 * @author 
 * @see AccountReceivableAdjustBCImpl
 * @since J2EE 1.6
 */ 

public interface AccountReceivableAdjustBC {
    
    /**
     * searchOtsTypeExcludeList<br>
     * 
     * @author EYLEE
     * @category STM_SAR_0161
     * @category searchOtsTypeExcludeList
     * @return List<OtsTypeExcludeListVO>
     * @throws EventException
     */    
    public List<OtsTypeExcludeListVO> searchOtsTypeExcludeList() throws EventException;
    
	/**
	 * AP Search Popup
	 * @author jinyoonoh 2014. 4. 7. 
	 * @param OffsetAPPopupListVO offsetAPPopupListVO
	 * @return List<OffsetAPPopupListVO>
	 * @throws EventException
	 */
	public List<OffsetAPPopupListVO> searchOffsetAPPopupList(OffsetAPPopupListVO offsetAPPopupListVO) throws EventException;    

	/**
	 * AR Search Popup
	 * @author jinyoonoh 2014. 4. 10. 
	 * @param AROfficeListVO arOfficeListVO 
	 * @param OffsetARPopupListVO offsetARPopupListVO
	 * @return List<OffsetARPopupListVO>
	 * @throws EventException
	 */
	public List<OffsetARPopupListVO> searchOffsetARPopupList(AROfficeListVO arOfficeListVO,  OffsetARPopupListVO offsetARPopupListVO) throws EventException ;
	
	/**
	 * Create Offset<br>
	 * @author jinyoonoh 2014. 4. 18.
	 * @param List<SarOffstMstVO> offstList
	 * @param String adjTpCd
	 * @return String
	 * @throws EventException
	 */
	public String manageOffset(List<SarOffstMstVO> offstList, String adjTpCd)
			throws EventException ;
	
	/**
	 * Reverse Receipt Info<br>
	 * @author jinyoonoh 2014. 4. 18.
	 * @param SarOffstMstVO paramVO
	 * @return String 
	 * @throws EventException
	 */
	public String reverseOffset(SarOffstMstVO paramVO)
			throws EventException ;	
	
	/**
	 * Search  Offset master
	 * @author jinyoonoh 2014. 4. 18.
	 * @param OffsetInfoVO offsetInfoVO
	 * @return List<OffsetInfoVO>
	 * @throws EventException
	 */
	public List<OffsetInfoVO> searchOffsetList(OffsetInfoVO offsetInfoVO)
			throws EventException ;	
	
	/**
	 * Retrieve Outstanding Adjustment <br>
	 * 
	 * @param AdjustCondVO adjustCondVO
	 * @return List<AdjustHdrListVO>
	 * @exception EventException
	 */
	public List<AdjustHdrListVO> searchAdjustHdrList(AdjustCondVO adjustCondVO) throws EventException;
		
	
	/**
	 * Retrieve Outstanding Adjustment <br>
	 * 
	 * @param AdjustCondVO adjustCondVO
	 * @return List<AdjustDtlListVO>
	 * @exception EventException
	 */
	public List<AdjustDtlListVO> searchAdjustDtlList(AdjustCondVO adjustCondVO) throws EventException;
	
	
	/**
	 * Retrieve Outstanding Adjustment <br>
	 * 
	 * @param AdjustCondVO adjustCondVO
	 * @return List<AdjustHdrListVO>
	 * @exception EventException
	 */
	public List<AdjustHdrListVO> searchOtsAdjustHdrList(AdjustCondVO adjustCondVO) throws EventException;
	
	
	/**
	 * Retrieve Outstanding Adjustment <br>
	 * 
	 * @param AdjustCondVO adjustCondVO
	 * @return List<AdjustDtlListVO>
	 * @exception EventException
	 */
	public List<AdjustDtlListVO> searchOtsAdjustDtlList(AdjustCondVO adjustCondVO) throws EventException;
	
	/**
	 * get Sequence No for Adjust No <br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchAdjustSeqNo() throws EventException;
	
	/**
	 * Save Adjust List <br>
	 * 
	 * @param AdjustHdrListVO[] adjustHdrListVOs
	 * @param AdjustDtlListVO[] adjustDtlListVOs
	 * @param AdjustCondVO adjustCondVO
	 * @param List<AdjustNoSeqVO> adjustNoSeqVOs
	 * @param String usrId
	 * @param String lOfcCd
	 * @exception EventException
	 */
	public void modifyAdjustList(AdjustHdrListVO[] adjustHdrListVOs, AdjustDtlListVO[] adjustDtlListVOs, AdjustCondVO adjustCondVO, List<AdjustNoSeqVO> adjustNoSeqVOs, String usrId, String lOfcCd) throws EventException;
	
	/**
	 * Reverse Adjust List <br>
	 * 
	 * @param AdjustHdrListVO[] adjustHdrListVOs
	 * @param AdjustDtlListVO[] adjustDtlListVOs
	 * @param AdjustCondVO adjustCondVO
	 * @param String usrId
	 * @param String lOfcCd
	 * @exception EventException
	 */
	public void modifyAdjustInfoRvs(AdjustHdrListVO[] adjustHdrListVOs, AdjustDtlListVO[] adjustDtlListVOs, AdjustCondVO adjustCondVO, String usrId, String lOfcCd) throws EventException;
	 
	/**
	 * Search Ledger exchange Rate<br> 
	 * 
	 * @param AdjustDtlListVO[] adjustDtlListVOs
	 * @param AdjustCondVO adjustCondVO
	 * @return String
	 * @exception EventException
	 */
	public String searchLegrXchRtList(AdjustDtlListVO[] adjustDtlListVOs, AdjustCondVO adjustCondVO) throws EventException;
	
	/**
	 * Search Sail Arrival Date, GL Date, Balance Update Date<br> 
	 * @param String lOfcCd
	 * @return List<AutosettlementCondVO>
	 * @throws EventException
	 */
	public List<AutosettlementCondVO> searchAutosettlementSetupDate(String lOfcCd) throws EventException;
	
	/**
	 * Temp Autosettlement insert <br>
	 * 
	 * @param AutosettlementCondVO autosettlementCondVO
	 * @return String
	 * @exception EventException
	 */
	public String createAutoSettlementList(AutosettlementCondVO autosettlementCondVO) throws EventException;
	
	/**
	 * Retrieve Temporary Autosettlement Entry Summary<br>
	 * 
	 * @param String batSeq
	 * @return List<AutoSettlementSubInfoVO>
	 * @exception EventException
	 */
	public List<AutoSettlementSubInfoVO> searchAutoSettlementSummaryList(String batSeq) throws EventException;
	
	/**
	 * Save Autosettlement Data <br>
	 * 
	 * @param List<AutoSettlementInfoVO> autoSettlementInfoVOs
	 * @param AutosettlementCondVO autosettlementCondVO
	 * @param List<AdjustNoSeqVO> adjustNoSeqVOs
	 * @param String usrId
	 * @param String lOfcCd
	 * @exception EventException
	 */
	public void createAutoSettlementInfo(List<AutoSettlementInfoVO> autoSettlementInfoVOs, AutosettlementCondVO autosettlementCondVO, List<AdjustNoSeqVO> adjustNoSeqVOs, String usrId, String lOfcCd) throws EventException;
	
	/**
	 * Retrieve Temporary Autosettlement Entry <br>
	 * 
	 * @param String batSeq
	 * @return List<AutoSettlementInfoVO>
	 * @exception EventException
	 */
	public List<AutoSettlementInfoVO> searchAutoSettlementTemporaryList(String batSeq) throws EventException;
	
	/**
	 * Retrieve AP GL DT <br>
	 * 
	 * @param String adjNo
	 * @param String rvsFlg
	 * @param String dtTpCd
	 * @return String
	 * @exception EventException
	 */
	public String searchApGlDtList(String adjNo, String rvsFlg, String dtTpCd) throws EventException;
	
	/**
	 * Retrieve AP INTERFACE Header Info <br>
	 * 
	 * @param ApIfSetVO apIfSetVO
	 * @return List<SapInvIfHdrVO>
	 * @exception EventException
	 */
	public List<SapInvIfHdrVO> searchSapInvIfHdrList(ApIfSetVO apIfSetVO) throws EventException;
	
	/**
	 * Retrieve AP INTERFACE Detail Info <br>
	 * 
	 * @param ApIfSetVO apIfSetVO
	 * @return List<SapInvIfDtlVO>
	 * @exception EventException
	 */
	public List<SapInvIfDtlVO> searchSapInvIfDtlList(ApIfSetVO apIfSetVO) throws EventException;
	
	/**
	 * get Sequence No for AP HDR IF <br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchSapInvHdrIfSeqNo() throws EventException;
	
	/**
	 * get Code Combination Sequence No for AP HDR IF <br>
	 * 
	 * @param SapInvIfHdrVO sapInvIfHdrVO
	 * @param String adjTpcd
	 * @param String sysTpCd
	 * @return String
	 * @exception EventException
	 */
	public String searchSapInvHdrIfCdCmbSeq(SapInvIfHdrVO sapInvIfHdrVO, String adjTpcd, String sysTpCd) throws EventException;
	
	/**
	 * get Sequence No for AP DTL IF <br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchSapInvDtlIfSeqNo() throws EventException;
	
	/**
	 * get Code Combination Sequence No for AP DTL IF <br>
	 * 
	 * @param SapInvIfDtlVO sapInvIfDtlVO
	 * @param String adjTpcd
	 * @param String sysTpCd
	 * @param String adjNo
	 * @param String offArAcctCd
	 * @param String offInterCoCd
	 * @return String
	 * @exception EventException
	 */
	public String searchSapInvDtlIfCdCmbSeq(SapInvIfDtlVO sapInvIfDtlVO, String adjTpcd, String sysTpCd, String adjNo, String offArAcctCd, String offInterCoCd) throws EventException;
	
	/**
	 * get Next Code Combination Sequence No for AP DTL IF <br>
	 * 
	 * @param SapInvIfDtlVO sapInvIfDtlVO
	 * @param String adjTpcd
	 * @param String dtrbCdCmbSeq
	 * @param String offGainAndLssAcctCd
	 * @param String sysTpCd
	 * @param String rvsFlg
	 * @return String
	 * @exception EventException
	 */
	public String searchSapInvDtlIfCdCmbNextSeq(SapInvIfDtlVO sapInvIfDtlVO, String adjTpcd, String dtrbCdCmbSeq, String offGainAndLssAcctCd, String sysTpCd, String rvsFlg) throws EventException;
	
	/**
	 * Manage Distribution Table <br>
	 * 
	 * @param String adjHisSeq
	 * @param String adjOffDt
	 * @param String blCurrCd
	 * @param String funcCurrRate
	 * @param String dpPrcsKnt
	 * @param String acctMtxSeq
	 * @param String adjStsCd
	 * @exception EventException
	 */
	public void manageDistribution(String adjHisSeq, String adjOffDt, String blCurrCd, String funcCurrRate, String dpPrcsKnt, String acctMtxSeq, String adjStsCd) throws EventException ;	
	
	/**
	 * Modify OutStanding Table <br>
	 * 
	 * @param List<String> adjNoList
	 * @param String stsCd
	 * @exception EventException
	 */
	public void modifyOutstandingForAjust(List<String> adjNoList,String stsCd) throws EventException;
	
	/**
	 * 2014.06.19 임시 로직 추가        
	 * CODE COMBINATION SEQUENCE 없으면 저장하고 조회 로직
	 * Insert SCO_LEGR_CD_CMB Table <br>
	 * 
	 * @param SapInvIfHdrVO sapInvIfHdrVO
	 * @param String adjTpcd
	 * @param String sysTpCd
	 * @exception EventException
	 */
	public void addSapInvHdrIfCdCmbSeq(SapInvIfHdrVO sapInvIfHdrVO, String adjTpcd, String sysTpCd) throws EventException ;
	
	/**
	 * 2014.06.19 임시 로직 추가 
	 * CODE COMBINATION SEQUENCE 없으면 저장하고 조회 로직
	 * Insert SCO_LEGR_CD_CMB Table <br>
	 * 
	 * @param SapInvIfDtlVO sapInvIfDtlVO
	 * @param String adjTpcd
	 * @param String sysTpCd
	 * @param String adjNo
	 * @param String offArAcctCd
	 * @param String offInterCoCd
	 * @exception EventException
	 */
	public void addSapInvDtlIfCdCmbSeq(SapInvIfDtlVO sapInvIfDtlVO, String adjTpcd, String sysTpCd, String adjNo, String offArAcctCd, String offInterCoCd) throws EventException ;
	
	/**
	 * 2014.06.19 임시 로직 추가 
	 * CODE COMBINATION SEQUENCE 없으면 저장하고 조회 로직
	 * Insert SCO_LEGR_CD_CMB Table <br>
	 * 
	 * @param SapInvIfDtlVO sapInvIfDtlVO
	 * @param String adjTpcd
	 * @param String sysTpCd
	 * @param String dtrbCdCmbSeq
	 * @param String offGainAndLssAcctCd
	 * @param String rvsFlg
	 * @exception EventException
	 */
	public void addSapInvDtlIfCdCmbNextSeq(SapInvIfDtlVO sapInvIfDtlVO, String adjTpcd, String sysTpCd, String dtrbCdCmbSeq, String offGainAndLssAcctCd, String rvsFlg) throws EventException ;
	
	/**
	 * Search ASA No, Currency List<br> 
	 * 
	 * @param AdjustCondVO adjustCondVO
	 * @return List<SarAsaMstVO>
	 * @exception EventException
	 */
	public List<SarAsaMstVO> searchAsaNoList(AdjustCondVO adjustCondVO) throws EventException;
    /**
     * Search Adjust view accounting
     * @author jinyoonoh 2014. 7. 16.
     * @param AdjViewAccountingListVO vo
     * @return List<AdjViewAccountingListVO>
     * @throws EventException
     */
    public List<AdjViewAccountingListVO> searchAdjViewAccountingList(AdjViewAccountingListVO vo) throws EventException;

    /**
	 * Call Ap Functional Exchange Rate Function<br>
	 * @param ApIfSetVO apIfSetVO
	 * @return String
	 * @throws EventException
	 */
	public String searchSarGetGlXchRtFncList(ApIfSetVO apIfSetVO) throws EventException;	
	
	/**
	 * Search sum of adj_acct_amt<br>
	 * @param String offsetNo
	 * @param String rvsFlg
	 * @return String
	 * @throws EventException
	 */
	public String searchAdjAcctAmtSumList(String offsetNo, String rvsFlg) throws EventException;
	
	/**
	 * Search sum of offst_amt<br>
	 * @param String offsetNo
	 * @return String
	 * @throws EventException
	 */
	public String searchOffsetAmtSumList(String offsetNo) throws EventException;
	
	/**
	 * Search AR/GAIN/LOSS Account Code<br>
	 * @param String adjTpCd
	 * @return SarAcctMtxVO
	 * @throws EventException
	 */
	public SarAcctMtxVO searchSarAcctCodeList(String adjTpCd) throws EventException;
	
	/**
	 * Calculate Ap Line/GAIN/LOSS Amount<br>
	 * @param String offApFuncExRt
	 * @param String offAdjAcctAmt
	 * @param String offMstSumAmt
	 * @param String offApHdrAmt
	 * @param String dpPrcsKnt
	 * @param String adjTpcd
	 * @param String rvsFlg
	 * @return SapInvoiceInterfaceDetailVO
	 * @throws EventException
	 */
	public SapInvoiceInterfaceDetailVO searchApLineAmtCalcList(String offApFuncExRt, String offAdjAcctAmt, String offMstSumAmt, String offApHdrAmt, String dpPrcsKnt, String adjTpcd, String rvsFlg) throws EventException;
	
	/**
	 * Setting INV NO of Offset, INV TYPE LOOKUP CODE<br>
	 * @author 
	 * @param ApIfSetVO apIfSetVO
	 * @param String offApHdrAmt
	 * @param String offOfcCd
	 * @return List<SapInvIfHdrVO>
	 * @throws EventException
	 */
	public List<SapInvIfHdrVO> searchOffSapInvNoList(ApIfSetVO apIfSetVO, String offApHdrAmt, String offOfcCd) throws EventException;
	
	/**
     * SCO_BAT_HIS 테이블에 데이타를 생성한다.    
     * @author myoungsin park
     * @param String batSeq
     * @param SignOnUserAccount account
     * @param AutosettlementCondVO paramVO
     * @return String
     * @throws EventException
     */
    public String createAutoSettlementBat(String batSeq,SignOnUserAccount account,AutosettlementCondVO paramVO) throws EventException;
    
    /**
     * Autosettle Batch run
     * @param String batSeq
     * @return String
     * @throws EventException
     */
    public String excuteAutoSettlementBat(String batSeq) throws EventException;
    
    /**
     * removeAutoSettlementDelCheckList
     * @param AutoSettlementInfoVO[] autoSettlementInfoVOs
     * @throws EventException
     */
    public void removeAutoSettlementDelCheckList(AutoSettlementInfoVO[] autoSettlementInfoVOs) throws EventException;
    
	/**
	 * check batch status
	 * R: Running
	 * S: Start
	 * 
	 * @param pgmNo
	 * @return
	 * @throws EventException
	 */
	public String searchAutoSettlementBatStsCd(String pgmNo) throws EventException;	

	/**
	 * batch 가 running 상태일 경우, E로 update
	 * 
	 * @param batSeq
	 * @param account
	 * @throws EventException
	 */
	public void manageCancelAutoSettlementBat(String batSeq, SignOnUserAccount account) throws EventException;	
}
