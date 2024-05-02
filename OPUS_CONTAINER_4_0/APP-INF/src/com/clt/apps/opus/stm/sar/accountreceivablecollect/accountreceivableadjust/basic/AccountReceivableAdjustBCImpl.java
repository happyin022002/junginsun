/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : AccountReceivableAdjustBCImpl.java
 *@FileTitle : AccountReceivableAdjustBCImpl
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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.SapInvoiceInterfaceDetailVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.integration.AccountReceivableAgentDBDAO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.BatHisVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration.AccountReceivableAdjustDBDAO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.AdjViewAccountingListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.AdjustCondVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.AdjustDtlListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.AdjustHdrListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.AdjustHisListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.AdjustNoSeqVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.ApIfSetVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.AutoSettlementInfoVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.AutoSettlementSubInfoVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.AutosettlementCondVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.CurrRndChkVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.OffsetAPPopupListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.OffsetARPopupListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.OffsetInfoVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.OtsTypeExcludeListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.SapInvIfDtlVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.SapInvIfHdrVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.SarAcctMtxVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.SarDtrbVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablecollectif.basic.AccountReceivableCollectIFBC;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablecollectif.basic.AccountReceivableCollectIFBCImpl;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.basic.AccountReceivableCommonBC;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.basic.AccountReceivableCommonBCImpl;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration.AccountReceivableCommonDBDAO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.AROfficeListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.CurrencyCodeVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.PayGroupInfoVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.VendorInfoVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration.AccountReceivableOutstandingDBDAO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.AROutstandingCheckVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.AROutstandingChgVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.AROutstandingDtlVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.AROutstandingHdrVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.AROutstandingHistVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OTSForApplyAdjustVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SarAdjHisVO;
import com.clt.syscommon.common.table.SarAsaMstVO;
import com.clt.syscommon.common.table.SarOffstMstVO;
import com.clt.syscommon.common.table.SarOtsHisVO;
import com.clt.syscommon.common.util.ScheduleUtil;

/**
 * AccountReceivableAdjustBCImpl Business Logic 
 * - Handling AccountReceivableAgent Business transaction.
 * 
 * @author 
 * @see AccountReceivableAdjustDBDAO
 * @since J2EE 1.6
 */ 

public class AccountReceivableAdjustBCImpl extends BasicCommandSupport implements AccountReceivableAdjustBC {	

	
	// Database Access Object
    private transient AccountReceivableAdjustDBDAO dbDao = null;    
    private transient AccountReceivableOutstandingDBDAO otsDao = null;
    private transient AccountReceivableCommonDBDAO comDao = null;
    private transient AccountReceivableAgentDBDAO agtDao = null;  
    
    public AccountReceivableAdjustBCImpl()
    {
        dbDao = new AccountReceivableAdjustDBDAO();
        otsDao = new AccountReceivableOutstandingDBDAO();
        comDao = new AccountReceivableCommonDBDAO();
        agtDao = new AccountReceivableAgentDBDAO();
    }
    
    /**
     * searchOtsTypeExcludeList<br>
     * 
     * @author EYLEE
     * @category STM_SAR_0161
     * @category searchOtsTypeExcludeList
     * @return List<OtsTypeExcludeListVO>
     * @throws EventException
     */   
    public List<OtsTypeExcludeListVO> searchOtsTypeExcludeList() throws EventException {
    	try {
    	//	 List<PopSupplierListVO> returnList = dbDao.searchPopSupplierList(vendorName); 
    		// returnList = dbDao.searchPopSupplierList(vendorName); 
   		 //   return returnList;
    		return dbDao.searchOtsTypeExcludeList(); 
   		    
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		}
    }
    
    
    /**
	 * AP Search Popup
	 * @author jinyoonoh 2014. 4. 7. 
	 * @param OffsetAPPopupListVO offsetAPPopupListVO
	 * @return List<OffsetAPPopupListVO>
	 * @throws EventException
	 */
	public List<OffsetAPPopupListVO> searchOffsetAPPopupList(OffsetAPPopupListVO offsetAPPopupListVO) throws EventException {
		try {
			
			List<OffsetAPPopupListVO> list = dbDao.searchOffsetAPPopupList(offsetAPPopupListVO);
			
			return list;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
		    
	
	/**
	 * AR Search Popup
	 * @author jinyoonoh 2014. 4. 10. 
	 * @param AROfficeListVO arOfficeListVO 
	 * @param OffsetARPopupListVO offsetARPopupListVO
	 * @return List<OffsetARPopupListVO>
	 * @throws EventException
	 */
	public List<OffsetARPopupListVO> searchOffsetARPopupList(AROfficeListVO arOfficeListVO,  OffsetARPopupListVO offsetARPopupListVO) throws EventException {
		try {
			
			List<OffsetARPopupListVO> list = dbDao.searchOffsetARPopupList(arOfficeListVO, offsetARPopupListVO);
			
			return list;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}		
	}
	
	/**
	 * Create Offset<br>
	 * @author jinyoonoh 2014. 4. 18.
	 * @param List<SarOffstMstVO> offstList
	 * @param String adjTpCd
	 * @return String
	 * @throws EventException
	 */
	public String manageOffset(List<SarOffstMstVO> offstList, String adjTpCd)
			throws EventException {
		try {

			AccountReceivableCommonBC commonBC = new AccountReceivableCommonBCImpl();
			
			// #####################################################
			// 1. AR Settlement
			//  update or insert [AR(header,  charge , detail , history), ADJUST(history)]
			// #####################################################
			
			
			// get local time
			String lclTime = commonBC.searchLocalTime(offstList.get(0).getOfcCd());
			
			String arOffstNo = commonBC.searchAdjustReceiptNo("OFF", offstList.get(0).getOfcCd(), offstList.get(0).getCreUsrId(), offstList.get(0).getOffstOfcCd());

			String funcCurr = comDao.searchFunctionalCurrency("FUNCTIONAL CURRENCY");
			List<CurrencyCodeVO> list = comDao.searchCurrencyCode(funcCurr);
			String dpPrcsKnt = list.get(0).getDpPrcsKnt();
			
			// ===============================================================
			// 1.1. Check GL Date 
			// Get Max G/L Date, AP
			// ===============================================================
			String maxGlDt = "";
			String maxOffstTpCd = "";
			
			int arOffstSeq = 0;
			for (SarOffstMstVO vo : offstList) {
				
				// CREATE OFFSET MASTER KEY
				vo.setArOffstNo(arOffstNo);	
				arOffstSeq++;
				vo.setArOffstSeq(arOffstSeq + "");
				vo.setArOffstDt(lclTime);		
				if (maxGlDt.equals("")) {				
					maxGlDt = vo.getGlDt();
				}
				
				String glDt = vo.getGlDt();
								
				if(maxGlDt.compareTo(glDt) < 0) {
					maxGlDt = glDt;
					maxOffstTpCd = vo.getOffstTpCd();
				}
				
			}
			
			String arApDivCd = "";			
			String sysDivCd = "";	
			
			// Checking AP Period
			sysDivCd = "34";
			arApDivCd = "P";
			
			maxGlDt = commonBC.getGlDate(maxGlDt, offstList.get(0).getOffstOfcCd(), sysDivCd, arApDivCd, "O");			
			if (StringUtils.isEmpty(maxGlDt)) {
				throw new EventException(new ErrorHandler("SAR00003",new String[]{"AP Period " + maxGlDt}).getMessage());
			}			

			// Checking AR Period
			sysDivCd = "28";
			arApDivCd = "R";
			
			maxGlDt = commonBC.getGlDate(maxGlDt, offstList.get(0).getOffstOfcCd(), sysDivCd, arApDivCd, "O");			
			if (StringUtils.isEmpty(maxGlDt)) {
				throw new EventException(new ErrorHandler("SAR00003",new String[]{"AR Period " + maxGlDt}).getMessage());
			}

			//ADJUST SEQUENCE
			List<String> adjSeqList = new ArrayList<String>();
			
			// ===============================================================
			// 1.2. Create SAR_ADJ_HIS
			// ===============================================================
			for (SarOffstMstVO vo : offstList) {	
				
				if (!"AR".equals(vo.getOffstTpCd())) {
					continue;
				}
	
				
				// offset Amount (user input data)
				BigDecimal offsetAmt = new BigDecimal(vo.getOffstAmt());	
				offsetAmt = offsetAmt.multiply(new BigDecimal(-1));
								
				// -----------------------------------
				// check balance amount 
				// -----------------------------------							
				AROutstandingCheckVO param = new AROutstandingCheckVO();
				param.setRhqCd(vo.getRhqCd());					
				param.setChgTpCd(vo.getChgTpCd());
				param.setOtsOfcCd(vo.getOfcCd());
				param.setBlNo(vo.getBlNo());
				param.setInvNo(vo.getInvNo());
				param.setBlCurrCd(vo.getCurrCd());
				String otsBalAmt = otsDao.searchOutstandingBalance(param);					
				
				if(StringUtils.isEmpty(otsBalAmt)) {
					// changed balance amount
					throw new EventException(new ErrorHandler("SAR00019",new String[]{}).getMessage());
				}
				
				BigDecimal searchOtsBalAmt = new BigDecimal(otsBalAmt);
				BigDecimal screenOtsBalAmt = new BigDecimal(vo.getOtsBalAmt());
				
				if (searchOtsBalAmt.compareTo(screenOtsBalAmt) != 0) {
					// changed balance amount
					throw new EventException(new ErrorHandler("SAR00019",new String[]{}).getMessage());
				}
								
				// ======================================== 
				// select Target AR charge , History  (SAR_OTS_CHG, SAR_OTS_HIS)
				// ========================================			
				AROutstandingCheckVO targetVO = new AROutstandingCheckVO();
				targetVO.setOtsOfcCd(vo.getOfcCd());//INV_OFC_CD 
				targetVO.setBlNo(vo.getBlNo());
				targetVO.setInvNo(vo.getInvNo());
				targetVO.setBlCurrCd(vo.getCurrCd());
				targetVO.setChgTpCd(vo.getChgTpCd());				
				List<OTSForApplyAdjustVO> targetList = otsDao.searchOutstandingForApplyAdjust(targetVO);
				
				int lastIndex = targetList.size() - 1;

				// -----------------------------------------
				// loop adjust target data
				// -----------------------------------------
				for (int i = 0; i < targetList.size(); i++) {
					
					OTSForApplyAdjustVO tgVO = targetList.get(i);
					
					// ----------------------------------------
					// get Adjust amount
					// ----------------------------------------
					BigDecimal chgBalAmt = new BigDecimal(tgVO.getChgBalAmt());
					
					BigDecimal adjAmt = new BigDecimal(0);
					
					if(offsetAmt.signum() == chgBalAmt.signum()){
						adjAmt = offsetAmt;
						offsetAmt = new BigDecimal(0);
					} else {
						if(offsetAmt.abs().compareTo(chgBalAmt.abs()) <= 0){
							adjAmt = offsetAmt;
						} else {
							adjAmt = chgBalAmt;
						}  
						
						if(adjAmt.signum() != offsetAmt.signum()){
							adjAmt = adjAmt.negate();
						}
						offsetAmt = offsetAmt.subtract(adjAmt);
					}
					
					if (i == lastIndex  && offsetAmt.compareTo(new BigDecimal(0)) != 0) {
						adjAmt = adjAmt.add(offsetAmt);		// 2014.09.02 modify
					}
					
					// ========================================
					// insert adjust history(SAR_ADJ_HIS)
					// ========================================
					SarAdjHisVO adjHisVO = new SarAdjHisVO();					
					//ADJUST SEQUENCE
					String  adjHisSeq = comDao.getSequence("SAR_ADJ_HIS_SEQ").toPlainString();					
					adjHisVO.setAdjHisSeq(adjHisSeq);
					
					adjHisVO.setAdjNo(vo.getArOffstNo()); // ADJUST NO.
					adjHisVO.setAdjStsCd("ADJUST"); // ADJUST STATUS CODE
					adjHisVO.setAdjAmt(adjAmt.toPlainString()); // ADJUST AMOUNT (Menus)
					adjHisVO.setAdjAplyDt(lclTime); // ADJUST APPLY DATE 
					adjHisVO.setAdjGlDt(maxGlDt); // ADJUST G/L DATE 
					adjHisVO.setAdjCdCmbSeq("-1"); // ADJUST CODE COMBINATION SEQUENCE 
					adjHisVO.setChgTpCd(vo.getChgTpCd()); // CHARGE TYPE CODE 
					adjHisVO.setApRmk(vo.getApRmk());
					
					//String adjTpCd = "OFF"; //ARAP Offset					
					if (!vo.getOffstCurrCd().equals(tgVO.getCurrCd())) {
						//adjTpCd = "OFFC"; //ARAP CrossCurrency Offset
						// ------------------------------------
						// 2015.05.12 타겟 currency 로 분개하기위해 
						// ------------------------------------
						adjHisVO.setGlCrsCurrCd(vo.getOffstCurrCd());
						adjHisVO.setGlCrsCurrAmt(adjAmt.multiply(new BigDecimal(vo.getOffstXchRt().replace(",",""))).negate().toString());
						String funcCurrRateTarget = dbDao.searchFunctionalCurrencyRate(vo.getOffstCurrCd(), funcCurr, maxGlDt);
						adjHisVO.setGlCrsExRate(funcCurrRateTarget);
					}							
					
					// offset currency equals AP currency
					adjHisVO.setAdjTpCd(adjTpCd); // ADJUST TYPE CODE
					adjHisVO.setAdjRmk(""); // ADJUST REMARK 
					adjHisVO.setGlTrnsSeq("-1"); // G/L TRANSFER SEQUENCE 
					adjHisVO.setGlTrnsDt(""); // G/L TRANSFER DATE 
					
					String funcCurrRate = dbDao.searchFunctionalCurrencyRate(vo.getCurrCd(), funcCurr, maxGlDt);
					
					if(funcCurrRate == null || funcCurrRate.equals("")){
						throw new EventException(new ErrorHandler("SAR00025",new String[]{}).getMessage());
					}					
					
					BigDecimal funcCurrRt = new BigDecimal(funcCurrRate);										
					adjHisVO.setAdjAcctAmt(adjAmt.multiply(funcCurrRt).toPlainString()); // ADJUST ACCOUNT AMOUNT 
					
					adjHisVO.setOrzSeq("-1"); // ORGANIZATION SEQUENCE 
					adjHisVO.setAcctgEvntSeq("-1"); // ACCOUNTING EVENT SEQUENCE 
					adjHisVO.setCreUsrId(vo.getCreUsrId()); // CREATE USER ID 
					adjHisVO.setCreDt(""); // CREATE DATE 
					adjHisVO.setUpdUsrId(vo.getUpdUsrId()); // UPDATE USER ID 
					adjHisVO.setUpdDt(""); // UPDATE DATE 
					adjHisVO.setOtsHisSeq(tgVO.getOtsHisSeq()); // OUTSTANDING HISTORY SEQUENCE

					// ACCOUNT MATRIX SEQUENCE
					String acctMtxSeq = dbDao.searchAcctMtxSeq(adjTpCd, maxGlDt);
					
					
					if(acctMtxSeq == null || acctMtxSeq.equals("")){
						throw new EventException(new ErrorHandler("SAR00034",new String[]{}).getMessage());
					}
					
					adjHisVO.setAcctMtxSeq(acctMtxSeq);
					
					adjHisVO.setAdjKeyNo(vo.getArOffstNo());// ADJUST KEY NUMBER
					adjHisVO.setAdjOfcCd(vo.getOffstOfcCd());
					
					// ------------------------------------
					// Insert SAR_ADJ_HIS
					// ------------------------------------
					dbDao.addSarAdjHis(adjHisVO);
					
					// ------------------------------------
					// INSERT SAR DISTRIBUTION TABLE / UPDATE ADJUST HISTORY TABLE
					// ------------------------------------
					manageDistribution(adjHisSeq, adjHisVO.getAdjGlDt()
							, vo.getCurrCd(), funcCurrRate
							, dpPrcsKnt, acctMtxSeq, adjHisVO.getAdjStsCd());

					
					// Ad ADJUST SEQUENCE 
					adjSeqList.add(adjHisSeq);
					
					// 2014.09.02 modify
					if(offsetAmt.compareTo(new BigDecimal(0)) == 0) {
						break;
	                }
					
				}
				
				// ===============================================
				// 1.3. Insert Offset Master
				// ===============================================
				// Do not change ots_bal_amt 
				//BigDecimal totOffstAmt = new BigDecimal(vo.getOffstAmt());				
				//vo.setOtsBalAmt(searchOtsBalAmt.subtract(totOffstAmt).toPlainString());
				vo.setCxlFlg("N");//Reverse Y/N
				vo.setGlDt(maxGlDt);
				dbDao.addOffsetInfo(vo);					
			}
			
			// ===============================================
			// 1.4. Processing OTS Table 
			// ===============================================
			List<String> adjNoList = new ArrayList<String>();
			adjNoList.add(arOffstNo);
			modifyOutstandingForAjust(adjNoList,"ADJUST");
			
			// ===============================================
			// Insert Offset IF DATA
			// ===============================================
			AccountReceivableCollectIFBC sakuraIFBC = new AccountReceivableCollectIFBCImpl();
			sakuraIFBC.createOffsetSakuraIFdata(arOffstNo,"P");
			
			// #####################################################
			// 2. AP Settlement
			// #####################################################			
			for (SarOffstMstVO vo : offstList) {	
				
				if (!"AP".equals(vo.getOffstTpCd())) {
					continue;
				}
				vo.setCxlFlg("N");//Reverse Y/N
				vo.setGlDt(maxGlDt);
				dbDao.addOffsetInfo(vo);
			}
			
			
			
			return arOffstNo;

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",
					new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * Reverse Receipt Info<br>
	 * @author jinyoonoh 2014. 4. 18.
	 * @param SarOffstMstVO paramVO
	 * @return String 
	 * @throws EventException
	 */
	public String reverseOffset(SarOffstMstVO paramVO)
			throws EventException {
		try {

			// -------------------------------------------------
			// Import & parameter 
			// -------------------------------------------------
			AccountReceivableCommonBC commonBC = new AccountReceivableCommonBCImpl();
		
			
			String arOffstNo = paramVO.getArOffstNo();
			String arOfcCd = paramVO.getOfcCd();
			
			// ----------------------------------------------------
			// Get MAX G/L Date
			// Select Offset Master
			// ----------------------------------------------------
			OffsetInfoVO offsetInfoVO = new OffsetInfoVO();
			offsetInfoVO.setArOffstNo(arOffstNo);
			offsetInfoVO.setOffstOfcCd(arOfcCd);
			List<OffsetInfoVO> offstList = dbDao.searchOffsetList(offsetInfoVO);
			
			String maxGlDt = "";
			String maxOffstTpCd = "";
			for (OffsetInfoVO vo : offstList) {
				if (maxGlDt.equals("")) {				
					maxGlDt = vo.getGlDt();
				}
				
				String glDt = vo.getGlDt();
								
				if(maxGlDt.compareTo(glDt) < 0) {
					maxGlDt = glDt;
					maxOffstTpCd = vo.getOffstTpCd();
				}			
			}
			
			String arApDivCd = "";			
			String sysDivCd = "";	
			
			// Checking AP Period
			sysDivCd = "34";
			arApDivCd = "P";
			
			maxGlDt = commonBC.getGlDate(maxGlDt, offstList.get(0).getOffstOfcCd(), sysDivCd, arApDivCd, "O");			
			if (StringUtils.isEmpty(maxGlDt)) {
				throw new EventException(new ErrorHandler("SAR00003",new String[]{"AP Period " + maxGlDt}).getMessage());
			}	
			
			// Checking AR Period
			sysDivCd = "28";
			arApDivCd = "R";
			
			maxGlDt = commonBC.getGlDate(maxGlDt, offstList.get(0).getOffstOfcCd(), sysDivCd, arApDivCd, "O");			
			if (StringUtils.isEmpty(maxGlDt)) {
				throw new EventException(new ErrorHandler("SAR00003",new String[]{"AR Period " + maxGlDt}).getMessage());
			}
			
			// ----------------------------------------------------
			// Select Adjust history
			// Create reverse adjust history
			// ----------------------------------------------------
			SarAdjHisVO sarAdjHisVO = new SarAdjHisVO();
			sarAdjHisVO.setAdjKeyNo(arOffstNo);			
			List<SarAdjHisVO> adjHisList = dbDao.searchSarAdjHisList(sarAdjHisVO);
						
			//ADJUST SEQUENCE
			List<String> adjSeqList = new ArrayList<String>();
			
			for (SarAdjHisVO vo : adjHisList) {
				// set primary key
				String  adjHisSeq = comDao.getSequence("SAR_ADJ_HIS_SEQ").toPlainString();					
				vo.setAdjHisSeq(adjHisSeq);

				// set plus adjust amount
				BigDecimal adjAmt = new BigDecimal(vo.getAdjAmt());
				adjAmt = adjAmt.negate();				
				vo.setAdjAmt(adjAmt.toPlainString());
				
				// set plus account mtx amount
				BigDecimal adjAcctAmt = new BigDecimal(vo.getAdjAcctAmt());
				adjAcctAmt = adjAcctAmt.negate();				
				vo.setAdjAcctAmt(adjAcctAmt.toPlainString());				
								
				// set g/l date
				vo.setAdjGlDt(maxGlDt);
				
				// set user info
				vo.setCreUsrId(paramVO.getCreUsrId());
				vo.setUpdUsrId(paramVO.getUpdUsrId());
				
				// set adjust status
				vo.setAdjStsCd("REVERSE");
				
				// insert adjust history
				dbDao.addSarAdjHis(vo);
				
				// get b/l currency code
				SarOtsHisVO otsHisParamVO = new SarOtsHisVO();
				otsHisParamVO.setOtsHisSeq(vo.getOtsHisSeq());				
				List<SarOtsHisVO> otsHisList = dbDao.searchArOtsHisList(otsHisParamVO);				
				String blCurrCd = otsHisList.get(0).getCurrCd();
				
				// ------------------------------------
				// Manage Distribution Table 
				// ------------------------------------
				manageDistribution(adjHisSeq, vo.getAdjGlDt()
						, blCurrCd, ""
						, "","", vo.getAdjStsCd());
				
				
				//add sequence
				adjSeqList.add(adjHisSeq);
				
				
			}
			
			
			// ===============================================
			// Insert Offset IF DATA
			// ===============================================
			AccountReceivableCollectIFBC sakuraIFBC = new AccountReceivableCollectIFBCImpl();
			sakuraIFBC.createOffsetSakuraIFdata(arOffstNo,"P");
			
			// ----------------------------------------------------
			// Processing OTS Table
			// ----------------------------------------------------
			//ADJUST SEQUENCE
			List<String> adjNoList = new ArrayList<String>();
			adjNoList.add(arOffstNo);
			modifyOutstandingForAjust(adjNoList,"REVERSE");
			
			
			// ----------------------------------------------------
			// Update Offset Master
			// ----------------------------------------------------
			for (OffsetInfoVO vo : offstList) {
				
				SarOffstMstVO offstVO = new SarOffstMstVO();
				
				if ("AR".equals(vo.getOffstTpCd())) {
					//get balance amount
					AROutstandingCheckVO param = new AROutstandingCheckVO();
					param.setRhqCd(vo.getRhqCd());					
					param.setChgTpCd(vo.getChgTpCd());
					param.setOtsOfcCd(vo.getOtsOfcCd());
					param.setBlNo(vo.getBlNo());
					param.setInvNo(vo.getInvNo());
					param.setBlCurrCd(vo.getCurrCd());
					String otsBalAmt = otsDao.searchOutstandingBalance(param);
					
					offstVO.setOtsBalAmt(otsBalAmt);
				}
				
				// PK
				offstVO.setArOffstNo(vo.getArOffstNo());
				offstVO.setArOffstSeq(vo.getArOffstSeq());
				
				offstVO.setCxlFlg("Y");//Reverse Y/N
				offstVO.setUpdUsrId(paramVO.getUpdUsrId());
				
				dbDao.updateOffsetInfo(offstVO);		
				
			}			
			
			
			
			return arOffstNo;

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",
					new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Search  Offset master
	 * @author jinyoonoh 2014. 4. 18.
	 * @param OffsetInfoVO offsetInfoVO
	 * @return List<OffsetInfoVO>
	 * @throws EventException
	 */
	public List<OffsetInfoVO> searchOffsetList(OffsetInfoVO offsetInfoVO) throws EventException {
		try {
			List<OffsetInfoVO> list = dbDao.searchOffsetList(offsetInfoVO);
			return list;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}			
		
	}
	
	/**
	 * Retrieve Outstanding Adjustment <br>
	 * 
	 * @param AdjustCondVO adjustCondVO
	 * @return List<AdjustHdrListVO>
	 * @exception EventException
	 */
	public List<AdjustHdrListVO> searchAdjustHdrList(AdjustCondVO adjustCondVO) throws EventException {
		try {
			return dbDao.searchAdjustHdrList(adjustCondVO);
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
		
	
	/**
	 * Retrieve Outstanding Adjustment <br>
	 * 
	 * @param AdjustCondVO adjustCondVO
	 * @return List<AdjustDtlListVO>
	 * @exception EventException
	 */
	public List<AdjustDtlListVO> searchAdjustDtlList(AdjustCondVO adjustCondVO) throws EventException {
		try {
			return dbDao.searchAdjustDtlList(adjustCondVO);
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Retrieve Outstanding Adjustment <br>
	 * 
	 * @param AdjustCondVO adjustCondVO
	 * @return List<AdjustHdrListVO>
	 * @exception EventException
	 */
	public List<AdjustHdrListVO> searchOtsAdjustHdrList(AdjustCondVO adjustCondVO) throws EventException {
		try {
			return dbDao.searchOtsAdjustHdrList(adjustCondVO);
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Retrieve Outstanding Adjustment <br>
	 * 
	 * @param AdjustCondVO adjustCondVO
	 * @return List<AdjustDtlListVO>
	 * @exception EventException
	 */
	public List<AdjustDtlListVO> searchOtsAdjustDtlList(AdjustCondVO adjustCondVO) throws EventException {
		try {
			return dbDao.searchOtsAdjustDtlList(adjustCondVO);
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * get Sequence No for Adjust No <br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchAdjustSeqNo() throws EventException {
		try {
			return dbDao.searchAdjustSeqNo();
			
		}catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
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
	public void modifyAdjustList(AdjustHdrListVO[] adjustHdrListVOs, AdjustDtlListVO[] adjustDtlListVOs, AdjustCondVO adjustCondVO, List<AdjustNoSeqVO> adjustNoSeqVOs, String usrId, String lOfcCd) throws EventException {

		List<AdjustHdrListVO> insertHdrVoList = new ArrayList<AdjustHdrListVO>();
		List<AdjustDtlListVO> insertDtlVoList = new ArrayList<AdjustDtlListVO>();
		
		List<String> adjNoList = new ArrayList<String>();
		
		AccountReceivableOutstandingDBDAO arOtsDao = new AccountReceivableOutstandingDBDAO();
		AccountReceivableCommonDBDAO arComDao = new AccountReceivableCommonDBDAO();
		
		String otsBalAmt = "";
		String adjDt = "";
		String glDt = "";
		String adjHisSeq = "";
		String funcCurr = "";
		String funcCurrRate = "";
		String acctMtxSeq = "";
		String adjTpCd = "";
		String dpPrcsKnt = "";
		
		BigDecimal oldBalAmt = null;
		BigDecimal newBalAmt = null;
		BigDecimal otsAplyAmt = null;
		BigDecimal otsGlDt = null;
		BigDecimal adjDtB = null;
		BigDecimal chgBalAmt = null;
		BigDecimal balAplyAmt = null;
		BigDecimal adjAmt = null;
		BigDecimal funcCurrRt = null;
		BigDecimal funcCurrAmt = null;
		
		try {
			
			funcCurr = arComDao.searchFunctionalCurrency("FUNCTIONAL CURRENCY");
			List<CurrencyCodeVO> list = arComDao.searchCurrencyCode(funcCurr);
			dpPrcsKnt = list.get(0).getDpPrcsKnt();
			
			for(int i=0; i<adjustHdrListVOs.length; i++){
				// set Header Object
				adjustHdrListVOs[i].setAdjNo(adjustNoSeqVOs.get(i).getAdjNo());
				adjNoList.add(adjustNoSeqVOs.get(i).getAdjNo());
				adjustHdrListVOs[i].setOtsAdjSeq(adjustNoSeqVOs.get(i).getOtsAdjSeq());
				adjustHdrListVOs[i].setCreUsrId(usrId);
				adjustHdrListVOs[i].setAdjDt(adjustCondVO.getAdjDt());
				adjustHdrListVOs[i].setAdjKeyNo(adjustNoSeqVOs.get(i).getAdjKeyNo());
				adjustHdrListVOs[i].setAdjOfcCd(adjustCondVO.getAdjtOfcCd());
				
				insertHdrVoList.add(adjustHdrListVOs[i]);

				// set Dtl Object
				for(int j=0; j<adjustDtlListVOs.length; j++){
					if(adjustHdrListVOs[i].getOtsHdrKey().equals(adjustDtlListVOs[j].getOtsDtlKey())){
						if( !"".equals(adjustDtlListVOs[j].getOtsAdjBalAmt()) ){
							adjustDtlListVOs[j].setOtsAdjSeq(adjustHdrListVOs[i].getOtsAdjSeq());
							adjustDtlListVOs[j].setCreUsrId(usrId);
							
							String legrXchRt = dbDao.searchLegrXchRtList(adjustDtlListVOs[j], adjustCondVO);
							adjustDtlListVOs[j].setLegrXchRt(legrXchRt);						
							
							insertDtlVoList.add(adjustDtlListVOs[j]);							
						}
						
						// INSERT DATA INTO SAR ADJ HISTORY
						AROutstandingCheckVO arOutstandingCheckVO = new AROutstandingCheckVO();
						List<OTSForApplyAdjustVO> otsForApplyAdjustVOs = new ArrayList<OTSForApplyAdjustVO>();
						
						arOutstandingCheckVO.setOtsOfcCd(adjustHdrListVOs[i].getInvOfcCd());
						arOutstandingCheckVO.setBlNo(adjustHdrListVOs[i].getBlNo());
						arOutstandingCheckVO.setInvNo(adjustHdrListVOs[i].getInvNo());
						arOutstandingCheckVO.setBlCurrCd(adjustDtlListVOs[j].getBlCurrCd());
						arOutstandingCheckVO.setChgTpCd(adjustDtlListVOs[j].getChgTpCd());
						
						otsForApplyAdjustVOs = arOtsDao.searchOutstandingForApplyAdjust(arOutstandingCheckVO);
		
						otsBalAmt = arOtsDao.searchOutstandingBalance(arOutstandingCheckVO);
						
						if(!otsBalAmt.equals("")){
							oldBalAmt = new BigDecimal(otsBalAmt);
							newBalAmt = new BigDecimal(adjustDtlListVOs[j].getOtsBalAmt().replace(",", ""));
							if(oldBalAmt.compareTo(newBalAmt) != 0){
								throw new EventException(new ErrorHandler("SAR00019",new String[]{}).getMessage());
							}
						}
						
						if(!"".equals(adjustDtlListVOs[j].getOtsAdjBalAmt())){
							otsAplyAmt = new BigDecimal(adjustDtlListVOs[j].getOtsAdjBalAmt().replace(",", ""));
							
							for(int k = 0; k < otsForApplyAdjustVOs.size(); k++){	
								if(otsAplyAmt.compareTo(new BigDecimal(0)) != 0){								
									
									otsGlDt = new BigDecimal(otsForApplyAdjustVOs.get(k).getGlDt());
									
									adjDt = adjustCondVO.getAdjDt().replace("-", "");
									adjDtB = new BigDecimal(adjDt);
									
									if(otsGlDt.compareTo(adjDtB) > 0){ 
										throw new EventException(new ErrorHandler("SAR00042",new String[]{}).getMessage());
									} else {
										glDt = adjDtB.toString();
									}
									
									chgBalAmt = new BigDecimal(otsForApplyAdjustVOs.get(k).getChgBalAmt());
								
									//his adj amt 는 입력한 부호
									if(otsAplyAmt.signum() == chgBalAmt.signum()){
										balAplyAmt = otsAplyAmt;
										otsAplyAmt = new BigDecimal(0);
									} else {
										if(otsAplyAmt.abs().compareTo(chgBalAmt.abs()) <= 0){
											balAplyAmt = otsAplyAmt;
										} else {
											balAplyAmt = chgBalAmt;
										}  
										
										if(balAplyAmt.signum() != otsAplyAmt.signum()){
											balAplyAmt = balAplyAmt.negate();
										}
										otsAplyAmt  = otsAplyAmt.subtract(balAplyAmt);
									}
									
									if(k == otsForApplyAdjustVOs.size() - 1 && otsAplyAmt.compareTo(new BigDecimal(0)) != 0){
										balAplyAmt = balAplyAmt.add(otsAplyAmt);
										otsAplyAmt = new BigDecimal(0);
									}
									
									if(balAplyAmt.compareTo(new BigDecimal(0)) != 0){
										
										AdjustHisListVO adjustHisListVO = new AdjustHisListVO();
																
										adjHisSeq = dbDao.searchAdjustHisSeqNo();
										funcCurrRate = dbDao.searchFunctionalCurrencyRate(otsForApplyAdjustVOs.get(k).getCurrCd(), funcCurr, adjustCondVO.getAdjDt());
										
										if(funcCurrRate == null || funcCurrRate.equals("")){
											throw new EventException(new ErrorHandler("SAR00025",new String[]{}).getMessage());
										}
										
										adjTpCd = adjustHdrListVOs[i].getChgAdjTpCd();
										
										acctMtxSeq = dbDao.searchAcctMtxSeq(adjTpCd, glDt);
										
										if(acctMtxSeq == null || acctMtxSeq.equals("")){
											throw new EventException(new ErrorHandler("SAR00034",new String[]{}).getMessage());
										}
										
										//applSeqList.add(adjHisSeq);
										
										adjAmt = new BigDecimal(balAplyAmt.toString());
										funcCurrRt = new BigDecimal(funcCurrRate);
										funcCurrAmt = adjAmt.multiply(funcCurrRt).setScale(Integer.parseInt(dpPrcsKnt), BigDecimal.ROUND_HALF_UP);
										
										// SET ADJUST HISTORY VO 
										adjustHisListVO.setAdjHisSeq(adjHisSeq);
										adjustHisListVO.setAdjNo(adjustNoSeqVOs.get(i).getAdjNo());
										adjustHisListVO.setAdjStsCd("ADJUST");
										adjustHisListVO.setAdjAmt(balAplyAmt.toString());
										adjustHisListVO.setAdjGlDt(glDt);
										adjustHisListVO.setAdjCdCmbSeq("-1");
										adjustHisListVO.setOtsHisSeq(otsForApplyAdjustVOs.get(k).getOtsHisSeq());
										adjustHisListVO.setChgTpCd(otsForApplyAdjustVOs.get(k).getChgTpCd());
										adjustHisListVO.setAdjTpCd(adjTpCd);
										adjustHisListVO.setAdjRmk(adjustHdrListVOs[i].getAdjRmk());
										adjustHisListVO.setGlTrnsSeq("-1");
										adjustHisListVO.setGlTrnsDt("");
										adjustHisListVO.setAdjAcctAmt(funcCurrAmt.toString());
										adjustHisListVO.setOrzSeq("-1");
										adjustHisListVO.setAcctgEvntSeq("-1");
										adjustHisListVO.setAcctMtxSeq("-1");
										adjustHisListVO.setCreUsrId(usrId);
										adjustHisListVO.setUpdUsrId(usrId);
										adjustHisListVO.setAdjKeyNo(adjustHdrListVOs[i].getAdjKeyNo());
										adjustHisListVO.setLOfcCd(lOfcCd);
										adjustHisListVO.setAdjCrsCurrAmt(adjustDtlListVOs[j].getAdjCrsCurrAmt());
										adjustHisListVO.setAdjCrsCurrCd(adjustDtlListVOs[j].getAdjCrsCurrCd());
										if(!("").equals(adjustDtlListVOs[j].getAdjCrsCurrCd()) && !adjustDtlListVOs[j].getBlCurrCd().equals(adjustDtlListVOs[j].getAdjCrsCurrCd())){
											adjustHisListVO.setGlCrsCurrCd(adjustDtlListVOs[j].getAdjCrsCurrCd());
											adjustHisListVO.setGlCrsCurrAmt(balAplyAmt.multiply(new BigDecimal(adjustDtlListVOs[j].getAdjXchRt().replace(",",""))).toString());
											String funcCurrRateTarget = dbDao.searchFunctionalCurrencyRate(adjustDtlListVOs[j].getAdjCrsCurrCd(), funcCurr, glDt);
											adjustHisListVO.setGlCrsExRate(funcCurrRateTarget);								
										}
										
										adjustHisListVO.setApRmk(adjustHdrListVOs[i].getApRmk());
										adjustHisListVO.setAdjOfcCd(adjustCondVO.getAdjtOfcCd());
										
										dbDao.addAdjustHisList(adjustHisListVO);
										
										
										// INSERT SAR DISTRIBUTION TABLE / UPDATE ADJUST HISTORY TABLE  
										manageDistribution(adjHisSeq, glDt, adjustDtlListVOs[j].getBlCurrCd(), funcCurrRate, dpPrcsKnt, acctMtxSeq, adjustHisListVO.getAdjStsCd());
										
									}
								}
							}							
						}
					}
				}
			}
		
			dbDao.addAdjustHdrList(insertHdrVoList);
			dbDao.addAdjustDtlList(insertDtlVoList);			
			
			// Processing OutStanding Table(hdr, dtl, chg, his)
			if(adjNoList.size() > 0){
				modifyOutstandingForAjust(adjNoList,"ADJUST");				
			}
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
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
	public void modifyAdjustInfoRvs(AdjustHdrListVO[] adjustHdrListVOs, AdjustDtlListVO[] adjustDtlListVOs, AdjustCondVO adjustCondVO, String usrId, String lOfcCd) throws EventException {
		AccountReceivableCommonDBDAO arComDao = new AccountReceivableCommonDBDAO();
			
		//List<String> applSeqList = new ArrayList<String>();
		List<String> adjNoList = new ArrayList<String>();
		
		String glDt = "";
		String adjHisSeq = "";
		
		BigDecimal adjRvsAmt = null;
		
		try {
			
			for(int i=0; i<adjustHdrListVOs.length; i++){

				for(int j=0; j<adjustDtlListVOs.length; j++){

					if(adjustHdrListVOs[i].getOtsHdrKey().equals(adjustDtlListVOs[j].getOtsDtlKey())){

						// INSERT DATA INTO SAR ADJ HISTORY
						List<AdjustHisListVO> adjustHisListVOs = new ArrayList<AdjustHisListVO>();
						
						adjustHisListVOs = dbDao.searchOutstandingForApplyAdjustRvs(adjustDtlListVOs[j].getChgTpCd(), adjustDtlListVOs[j].getBlCurrCd(), adjustCondVO);
						
						for(int k = 0; k < adjustHisListVOs.size(); k++){
							if(!"".equals(adjustHisListVOs.get(k).getAdjAmt())){
								adjRvsAmt = new BigDecimal(adjustHisListVOs.get(k).getAdjAmt().replace(",", ""));
								
								if(adjRvsAmt.compareTo(new BigDecimal(0)) != 0){								
									//check GL Date
									glDt = arComDao.searchEffectiveDate(adjustHisListVOs.get(k).getAdjGlDt(), adjustCondVO.getAdjtOfcCd(), "27");
									
									if(glDt == null || glDt.equals("")){
										throw new EventException(new ErrorHandler("SAR00003",new String[]{"period status"}).getMessage());
									}
									
									AdjustHisListVO adjustHisListVO = new AdjustHisListVO();
									
									adjHisSeq = dbDao.searchAdjustHisSeqNo();
									
									//applSeqList.add(adjHisSeq);
									
									adjustHisListVO.setAdjHisSeq(adjHisSeq);
									adjustHisListVO.setAdjNo(adjustHisListVOs.get(k).getAdjNo());
									adjustHisListVO.setAdjStsCd("REVERSE");
									adjustHisListVO.setAdjAmt(adjustHisListVOs.get(k).getAdjAmt());
									adjustHisListVO.setAdjGlDt(glDt);
									adjustHisListVO.setAdjCdCmbSeq(adjustHisListVOs.get(k).getAdjCdCmbSeq());
									adjustHisListVO.setOtsHisSeq(adjustHisListVOs.get(k).getOtsHisSeq());
									adjustHisListVO.setChgTpCd(adjustHisListVOs.get(k).getChgTpCd());
									adjustHisListVO.setAdjTpCd(adjustHisListVOs.get(k).getAdjTpCd());
									//adjustHisListVO.setAdjRmk(adjustHisListVOs.get(k).getAdjRmk());
									adjustHisListVO.setAdjRmk(adjustCondVO.getAdjRmk()); 
									adjustHisListVO.setGlTrnsSeq(adjustHisListVOs.get(k).getGlTrnsSeq());
									adjustHisListVO.setGlTrnsDt(adjustHisListVOs.get(k).getGlTrnsDt());
									adjustHisListVO.setAdjAcctAmt(adjustHisListVOs.get(k).getAdjAcctAmt());
									adjustHisListVO.setOrzSeq(adjustHisListVOs.get(k).getOrzSeq());
									adjustHisListVO.setAcctgEvntSeq(adjustHisListVOs.get(k).getAcctgEvntSeq());
									adjustHisListVO.setAcctMtxSeq(adjustHisListVOs.get(k).getAcctMtxSeq());
									adjustHisListVO.setCreUsrId(usrId);
									adjustHisListVO.setUpdUsrId(usrId);
									adjustHisListVO.setAdjKeyNo(adjustHisListVOs.get(k).getAdjKeyNo());
									adjustHisListVO.setLOfcCd(lOfcCd);
									adjustHisListVO.setAdjCrsCurrAmt(adjustHisListVOs.get(k).getAdjCrsCurrAmt());
									adjustHisListVO.setAdjCrsCurrCd(adjustHisListVOs.get(k).getAdjCrsCurrCd());
									adjustHisListVO.setApRmk(adjustHisListVOs.get(k).getApRmk());
									adjustHisListVO.setAdjOfcCd(adjustHisListVOs.get(k).getAdjOfcCd());
									adjustHisListVO.setGlCrsCurrAmt(adjustHisListVOs.get(k).getGlCrsCurrAmt());
									adjustHisListVO.setGlCrsCurrCd(adjustHisListVOs.get(k).getGlCrsCurrCd());
									adjustHisListVO.setGlCrsExRate(adjustHisListVOs.get(k).getGlCrsExRate());
									dbDao.addAdjustHisList(adjustHisListVO);
									
									// INSERT SAR DISTRIBUTION TABLE / UPDATE ADJUST HISTORY TABLE  
									manageDistribution(adjHisSeq, glDt, adjustDtlListVOs[j].getBlCurrCd(), "", "", "", adjustHisListVO.getAdjStsCd());
									
								}
							}
						}
					}
				}
			}
			
			dbDao.modifyAdjustInfoRvs(adjustCondVO, usrId);
			
			// Processing OutStanding Table(hdr, dtl, chg, his)  
			adjNoList.add(adjustCondVO.getAdjNo()); 
			if(adjNoList.size() > 0){
				modifyOutstandingForAjust(adjNoList,"REVERSE");
			}				
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Search Ledger exchange Rate<br> 
	 * 
	 * @param AdjustDtlListVO[] adjustDtlListVOs
	 * @param AdjustCondVO adjustCondVO
	 * @return String
	 * @exception EventException
	 */
	public String searchLegrXchRtList(AdjustDtlListVO[] adjustDtlListVOs, AdjustCondVO adjustCondVO) throws EventException {
		try {
			String legrXchRt = ""; 
			String temp = "";
			
			for(int i=0; i<adjustDtlListVOs.length; i++){
				
				temp = dbDao.searchLegrXchRtList(adjustDtlListVOs[i], adjustCondVO);
				
				if(adjustDtlListVOs[i].getBlCurrCd().equals(adjustDtlListVOs[i].getAdjCrsCurrCd())){
					temp = "1";
				}
				
				if(i == 0){
					legrXchRt = temp;
				}else{
					legrXchRt = legrXchRt + "|" +temp;
				}
	
			}
			
			return legrXchRt;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Search Sail Arrival Date, GL Date, Balance Update Date<br> 
	 * @param String lOfcCd
	 * @return List<AutosettlementCondVO>
	 * @throws EventException
	 */
	public List<AutosettlementCondVO> searchAutosettlementSetupDate(String lOfcCd) throws EventException{
		List<AutosettlementCondVO> list = null;
		try {
			list = dbDao.searchAutosettlementSetupDate(lOfcCd);	
			return list;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}

	
	/**
	 * Temp Autosettlement insert <br>
	 * 
	 * @param AutosettlementCondVO autosettlementCondVO
	 * @return String
	 * @exception EventException
	 */
	public String createAutoSettlementList(AutosettlementCondVO autosettlementCondVO) throws EventException{
		String batSeq = "";
		try {
			batSeq = agtDao.searchBatHisSeqData(); 
			autosettlementCondVO.setBackendjobKey(batSeq);
			if("S".equals(autosettlementCondVO.getAutoTpCd())){
				dbDao.addSmallOutstandingList(autosettlementCondVO);				
			}else if("O".equals(autosettlementCondVO.getAutoTpCd())){
				dbDao.addOverpaymentOutstandingList(autosettlementCondVO);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return batSeq;
	}
	
	/**
	 * Retrieve Temporary Autosettlement Entry Summary<br>
	 * 
	 * @param String batSeq
	 * @return List<AutoSettlementSubInfoVO>
	 * @exception EventException
	 */
	public List<AutoSettlementSubInfoVO> searchAutoSettlementSummaryList(String batSeq) throws EventException{
		List<AutoSettlementSubInfoVO> list = null;
		try {
			list = dbDao.searchAutoSettlementSummaryList(batSeq);
			return list;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
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
	public void createAutoSettlementInfo(List<AutoSettlementInfoVO> autoSettlementInfoVOs, AutosettlementCondVO autosettlementCondVO, List<AdjustNoSeqVO> adjustNoSeqVOs, String usrId, String lOfcCd) throws EventException {
		try {
			List<AutoSettlementInfoVO> insertAutosettlementHdrVoList = new ArrayList<AutoSettlementInfoVO>();
			List<AutoSettlementInfoVO> insertAutosettlementDtlVoList = new ArrayList<AutoSettlementInfoVO>();
			
			List<String> applSeqList = new ArrayList<String>();
			List<String> adjNoList = new ArrayList<String>();
			
			AccountReceivableOutstandingDBDAO arOtsDao = new AccountReceivableOutstandingDBDAO();
			AccountReceivableCommonDBDAO arComDao = new AccountReceivableCommonDBDAO();
			
			String otsBalAmt = "";
			String adjDt = "";
			String glDt = "";
			String adjHisSeq = "";
			String funcCurr = "";
			String funcCurrRate = "";
			String acctMtxSeq = "";
			String dpPrcsKnt = "";
			
			BigDecimal oldBalAmt = null;
			BigDecimal newBalAmt = null;
			BigDecimal otsAplyAmt = null;
			BigDecimal otsGlDt = null;
			BigDecimal adjDtB = null;
			BigDecimal chgBalAmt = null;
			BigDecimal balAplyAmt = null;
			BigDecimal adjAmt = null;
			BigDecimal funcCurrRt = null;
			BigDecimal funcCurrAmt = null;
			
			String adjSeqKeyTmp = "";
			
			funcCurr = arComDao.searchFunctionalCurrency("FUNCTIONAL CURRENCY");
			List<CurrencyCodeVO> list = arComDao.searchCurrencyCode(funcCurr);
			dpPrcsKnt = list.get(0).getDpPrcsKnt();
			
			for(int i=0; i<autoSettlementInfoVOs.size(); i++){
				//ADJ_TP_CD||RHQ_CD||OTS_OFC_CD||CLT_OFC_CD||BL_NO||INV_NO 
				String adjNoKey = autoSettlementInfoVOs.get(i).getAdjTpCd() +
							      autoSettlementInfoVOs.get(i).getRhqCd() +
							      autoSettlementInfoVOs.get(i).getOtsOfcCd() +
							      autoSettlementInfoVOs.get(i).getCltOfcCd() +
							      autoSettlementInfoVOs.get(i).getBlNo() +
							      autoSettlementInfoVOs.get(i).getInvNo();
				autoSettlementInfoVOs.get(i).setAdjNoKey(adjNoKey);
				
				if( !adjSeqKeyTmp.equals(autoSettlementInfoVOs.get(i).getAdjNoKey()) ){
					// set Header Object
					autoSettlementInfoVOs.get(i).setAdjNo(adjustNoSeqVOs.get(i).getAdjNo());
					autoSettlementInfoVOs.get(i).setOtsAdjSeq(adjustNoSeqVOs.get(i).getOtsAdjSeq());
					autoSettlementInfoVOs.get(i).setCreUsrId(usrId);
					autoSettlementInfoVOs.get(i).setAdjDt(autosettlementCondVO.getAdjDt());
					autoSettlementInfoVOs.get(i).setAdjKeyNo(adjustNoSeqVOs.get(i).getAdjKeyNo());
					
					insertAutosettlementHdrVoList.add(autoSettlementInfoVOs.get(i));
					
					adjSeqKeyTmp = autoSettlementInfoVOs.get(i).getAdjNoKey();
				}
				
				adjNoList.add(adjustNoSeqVOs.get(i).getAdjNo()); 
				
				// after setting Header then setting Detail Object
				autoSettlementInfoVOs.get(i).setAdjNo(adjustNoSeqVOs.get(i).getAdjNo());
				autoSettlementInfoVOs.get(i).setOtsAdjSeq(adjustNoSeqVOs.get(i).getOtsAdjSeq());
				autoSettlementInfoVOs.get(i).setCreUsrId(usrId);
				autoSettlementInfoVOs.get(i).setAdjDt(autosettlementCondVO.getAdjDt());
				autoSettlementInfoVOs.get(i).setAdjKeyNo(adjustNoSeqVOs.get(i).getAdjKeyNo());
				
				insertAutosettlementDtlVoList.add(autoSettlementInfoVOs.get(i));	
				
				
				// INSERT DATA INTO SAR ADJ HISTORY
				AROutstandingCheckVO arOutstandingCheckVO = new AROutstandingCheckVO();
				List<OTSForApplyAdjustVO> otsForApplyAdjustVOs = new ArrayList<OTSForApplyAdjustVO>();
				
				arOutstandingCheckVO.setOtsOfcCd(autoSettlementInfoVOs.get(i).getCltOfcCd());
				arOutstandingCheckVO.setBlNo(autoSettlementInfoVOs.get(i).getBlNo());
				arOutstandingCheckVO.setInvNo(autoSettlementInfoVOs.get(i).getInvNo());
				arOutstandingCheckVO.setBlCurrCd(autoSettlementInfoVOs.get(i).getBlCurrCd());
				arOutstandingCheckVO.setChgTpCd(autoSettlementInfoVOs.get(i).getChgTpCd());
				
				otsForApplyAdjustVOs = arOtsDao.searchOutstandingForApplyAdjust(arOutstandingCheckVO);

				otsBalAmt = arOtsDao.searchOutstandingBalance(arOutstandingCheckVO);
				
				if(!otsBalAmt.equals("")){
					oldBalAmt = new BigDecimal(otsBalAmt);
					newBalAmt = new BigDecimal(autoSettlementInfoVOs.get(i).getOtsBalAmt().replace(",", ""));
					
					if(oldBalAmt.compareTo(newBalAmt) != 0){
						throw new EventException(new ErrorHandler("SAR00019",new String[]{}).getMessage());
					}
				}
				
				otsAplyAmt = new BigDecimal(autoSettlementInfoVOs.get(i).getOtsBalAmt().replace(",", ""));
				otsAplyAmt = otsAplyAmt.multiply(new BigDecimal(-1));
				
				for(int k = 0; k < otsForApplyAdjustVOs.size(); k++){	
					if(otsAplyAmt.compareTo(new BigDecimal(0)) != 0){								
						
						otsGlDt = new BigDecimal(otsForApplyAdjustVOs.get(k).getGlDt());
						
						adjDt = autosettlementCondVO.getAdjDt().replace("-", "");
						adjDtB = new BigDecimal(adjDt);
						
						if(otsGlDt.compareTo(adjDtB) > 0){
							throw new EventException(new ErrorHandler("SAR00042",new String[]{}).getMessage());
						} else {
							glDt = adjDtB.toString();
						}
						
						chgBalAmt = new BigDecimal(otsForApplyAdjustVOs.get(k).getChgBalAmt());
					
						if(otsAplyAmt.signum() == chgBalAmt.signum()){
							balAplyAmt = otsAplyAmt;
							otsAplyAmt = new BigDecimal(0);
						} else {
							if(otsAplyAmt.abs().compareTo(chgBalAmt.abs()) <= 0){
								balAplyAmt = otsAplyAmt;
							} else {
								balAplyAmt = chgBalAmt;
							}  
							
							if(balAplyAmt.signum() != otsAplyAmt.signum()){
								balAplyAmt = balAplyAmt.negate();
							}
							otsAplyAmt  = otsAplyAmt.subtract(balAplyAmt);
						}
						
						if(k == otsForApplyAdjustVOs.size() - 1 && otsAplyAmt.compareTo(new BigDecimal(0)) != 0){
							balAplyAmt = balAplyAmt.add(otsAplyAmt);
							otsAplyAmt = new BigDecimal(0);
						}
						
						if(balAplyAmt.compareTo(new BigDecimal(0)) != 0){
							
							AdjustHisListVO adjustHisListVO = new AdjustHisListVO();
													
							adjHisSeq = dbDao.searchAdjustHisSeqNo();
							funcCurrRate = dbDao.searchFunctionalCurrencyRate(otsForApplyAdjustVOs.get(k).getCurrCd(), funcCurr, autosettlementCondVO.getAdjDt());
							
							if(funcCurrRate == null || funcCurrRate.equals("")){
								throw new EventException(new ErrorHandler("SAR00025",new String[]{}).getMessage());
							}
							
							acctMtxSeq = dbDao.searchAcctMtxSeq(autoSettlementInfoVOs.get(i).getAdjTpCd(), glDt);
							
							if(acctMtxSeq == null || acctMtxSeq.equals("")){
								throw new EventException(new ErrorHandler("SAR00034",new String[]{}).getMessage());
							}
							
							applSeqList.add(adjHisSeq);
							
							adjAmt = new BigDecimal(balAplyAmt.toString());
							funcCurrRt = new BigDecimal(funcCurrRate);
							funcCurrAmt = adjAmt.multiply(funcCurrRt).setScale(Integer.parseInt(dpPrcsKnt), BigDecimal.ROUND_HALF_UP);
							
							adjustHisListVO.setAdjHisSeq(adjHisSeq);
							adjustHisListVO.setAdjNo(adjustNoSeqVOs.get(i).getAdjNo());
							adjustHisListVO.setAdjStsCd("ADJUST");
							adjustHisListVO.setAdjAmt(balAplyAmt.toString());
							adjustHisListVO.setAdjGlDt(glDt);
							adjustHisListVO.setAdjCdCmbSeq("-1");
							adjustHisListVO.setOtsHisSeq(otsForApplyAdjustVOs.get(k).getOtsHisSeq());
							adjustHisListVO.setChgTpCd(otsForApplyAdjustVOs.get(k).getChgTpCd());
							adjustHisListVO.setAdjTpCd(autoSettlementInfoVOs.get(i).getAdjTpCd());
							adjustHisListVO.setAdjRmk("");
							adjustHisListVO.setGlTrnsSeq("-1");
							adjustHisListVO.setGlTrnsDt("");
							adjustHisListVO.setAdjAcctAmt(funcCurrAmt.toString());
							adjustHisListVO.setOrzSeq("-1");
							adjustHisListVO.setAcctgEvntSeq("-1");
							adjustHisListVO.setAcctMtxSeq("-1");
							adjustHisListVO.setCreUsrId(usrId);
							adjustHisListVO.setUpdUsrId(usrId);
							adjustHisListVO.setAdjKeyNo(autoSettlementInfoVOs.get(i).getAdjKeyNo());
							adjustHisListVO.setLOfcCd(lOfcCd);
							adjustHisListVO.setApRmk(""); 
							adjustHisListVO.setAdjOfcCd(autoSettlementInfoVOs.get(i).getCltOfcCd());
							
							dbDao.addAdjustHisList(adjustHisListVO);
							
							
							// INSERT SAR DISTRIBUTION TABLE / UPDATE ADJUST HISTORY TABLE  
							manageDistribution(adjHisSeq, glDt, otsForApplyAdjustVOs.get(k).getCurrCd(), funcCurrRate, dpPrcsKnt, acctMtxSeq, adjustHisListVO.getAdjStsCd());
							
						}
					}
				}
			}
			
			dbDao.createAutoSettlementHeaderlInfo(insertAutosettlementHdrVoList);
			dbDao.createAutoSettlementDetailInfo(insertAutosettlementDtlVoList);
			
			// Processing OutStanding Table(hdr, dtl, chg, his)  
			if(adjNoList.size() > 0){ 
				modifyOutstandingForAjust(adjNoList,"ADJUST");		
			}
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Retrieve Temporary Autosettlement Entry <br>
	 * 
	 * @param String batSeq
	 * @return List<AutoSettlementInfoVO>
	 * @exception EventException
	 */
	public List<AutoSettlementInfoVO> searchAutoSettlementTemporaryList(String batSeq) throws EventException {
		List<AutoSettlementInfoVO> list = null;
		try {
			list = dbDao.searchAutoSettlementTemporaryList(batSeq);
			
			return list;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Modify OutStanding Table <br>
	 * 
	 * @param List<String> adjNoList
	 * @param String stsCd
	 * @exception EventException
	 */
	public void modifyOutstandingForAjust(List<String> adjNoList,String stsCd) throws EventException {
		AccountReceivableOutstandingDBDAO arOtsDao = new AccountReceivableOutstandingDBDAO();
		
		try {
			List<AROutstandingHdrVO> arOutstandingHdrVOs = new ArrayList<AROutstandingHdrVO>();
			List<AROutstandingHistVO> arOutstandingHistVOs = new ArrayList<AROutstandingHistVO>();
			List<AROutstandingDtlVO> arOutstandingDtlVOs = new ArrayList<AROutstandingDtlVO>();
			List<AROutstandingChgVO> arOutstandingChgVOs = new ArrayList<AROutstandingChgVO>();
			
			arOutstandingHdrVOs = dbDao.searchAdjustForOTSHeader(adjNoList,stsCd);
			arOutstandingHistVOs = dbDao.searchAdjustForOTSHistory(adjNoList,stsCd);
			arOutstandingDtlVOs = dbDao.searchAdjustForOTSDetail(adjNoList,stsCd);
			arOutstandingChgVOs = dbDao.searchAdjustForOTSCharge(adjNoList,stsCd);
			
			//arOtsDao.modifyOutstandingChargeAmt(arOutstandingChgVOs);
			for(int i = 0; i < arOutstandingChgVOs.size(); i++){
				arOtsDao.modifyOutstandingChargeAmtByEach(arOutstandingChgVOs.get(i));
			}
			
			for(int i = 0; i < arOutstandingHistVOs.size(); i++){
				arOutstandingHistVOs.get(i).setOtsHisSeq(arOtsDao.searchOutstandingHistSeq());
			}
			
			arOtsDao.addOutstandingHist(arOutstandingHistVOs);
			arOtsDao.modifyOutstandingDetail(arOutstandingDtlVOs);
			
			for(int i = 0; i < arOutstandingHdrVOs.size(); i++){
				arOtsDao.modifyOTSSettleFlag(arOutstandingHdrVOs.get(i));
				
				//2015.04.01 modify BKG OTS
				arOtsDao.modifyBKGOutstanding(arOutstandingHdrVOs.get(i));
			}
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
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
	public void manageDistribution(String adjHisSeq, String adjOffDt, String blCurrCd, String funcCurrRate, String dpPrcsKnt, String acctMtxSeq, String adjStsCd) throws EventException {

		try {
			// Adjust Process
			if("ADJUST".equals(adjStsCd)){
				String otsCdCmbSeq = "";
				String adjCdCmbSeq = "";
				String sysCdCmbSeq = "";
				String tjCd = "";
				
				SarDtrbVO sarDtrbAdjVO = new SarDtrbVO();
				SarDtrbVO sarDtrbRecVO = new SarDtrbVO();
				SarDtrbVO sarDtrbGainLossVO = new SarDtrbVO();
				SarDtrbVO sarDtrbRoundingVO = new SarDtrbVO();
				SarAcctMtxVO sarAcctMtxVO = new SarAcctMtxVO();
				SarAdjHisVO adjHisVO = new SarAdjHisVO();
				SarAdjHisVO updAdjHisVO = new SarAdjHisVO();
				CurrRndChkVO currRndChkVO = new CurrRndChkVO();				
					
				// GET SAR ADJUST HISTORY
				adjHisVO = dbDao.searchAdjHisList(adjHisSeq);
				
				// GET CODE COMBINATION SEQUENCE( CASE 'ADJ' )	
				tjCd = "ADJ";
				otsCdCmbSeq = dbDao.searchOtsCdCmbSeq(adjHisVO.getOtsHisSeq(), adjHisVO.getChgTpCd());
				sarAcctMtxVO = dbDao.searchAcctCdForAdjCdCmbSeq(tjCd, adjHisVO.getAdjTpCd());
				sarAcctMtxVO.setOtsCdCmbSeq(otsCdCmbSeq);
				adjCdCmbSeq = dbDao.searchAdjCdCmbSeq(sarAcctMtxVO);			
								
				// 2014.06.19 임시 로직 추가 
				// CODE COMBINATION SEQUENCE 없으면 저장하고 조회 로직
				if(adjCdCmbSeq == null || adjCdCmbSeq.equals("")){
					dbDao.addAdjCdCmbSeq(sarAcctMtxVO);
					adjCdCmbSeq = dbDao.searchAdjCdCmbSeq(sarAcctMtxVO);
				}
				
				// 2014.06.19 임시 로직 추가
				if(adjCdCmbSeq == null || adjCdCmbSeq.equals("")){
					throw new EventException(new ErrorHandler("SAR00035",new String[]{}).getMessage());
				}
				
				
				// SET SAR DISTRIBUTION VO For Insert( CASE 'ADJ' )										
				sarDtrbAdjVO.setAdjHisSeq(adjHisSeq);
				sarDtrbAdjVO.setFuncCurrRt(funcCurrRate);
				sarDtrbAdjVO.setDpPrcsKnt(dpPrcsKnt);
				sarDtrbAdjVO.setBlCurrCd(blCurrCd);										
				sarDtrbAdjVO.setAdjDt(adjOffDt);
				sarDtrbAdjVO.setChgTpCd(adjHisVO.getChgTpCd());
				sarDtrbAdjVO.setCdCmbSeq(adjCdCmbSeq);
				sarDtrbAdjVO.setGlCurrCd(adjHisVO.getGlCrsCurrCd());
				
				dbDao.addSarDtrbAdjList(sarDtrbAdjVO);										
				
				
				// CHECK REC AMOUNT, CURRENCY ROUNDING AMOUNT/TYPE CODE
				currRndChkVO = dbDao.searchCurrencyRoundingCheckList(adjHisVO, dpPrcsKnt);
				
				
				// SET SAR DISTRIBUTION VO For Insert( CASE 'REC' )										
				sarDtrbRecVO.setAdjHisSeq(adjHisSeq);
				sarDtrbRecVO.setAdjAmt(adjHisVO.getAdjAmt());
				sarDtrbRecVO.setRecAcctAmt(currRndChkVO.getRecAcctAmt());
				sarDtrbRecVO.setCreUsrId(adjHisVO.getCreUsrId());
				sarDtrbRecVO.setUpdUsrId(adjHisVO.getUpdUsrId());
				sarDtrbRecVO.setOtsHisSeq(adjHisVO.getOtsHisSeq());
				sarDtrbRecVO.setChgTpCd(adjHisVO.getChgTpCd());
				sarDtrbRecVO.setGlCrsCurrCd(adjHisVO.getGlCrsCurrCd());
				sarDtrbRecVO.setGlCrsCurrAmt(adjHisVO.getGlCrsCurrAmt());
				sarDtrbRecVO.setGlCrsExRate(adjHisVO.getGlCrsExRate());
				
				dbDao.addSarDtrbRecList(sarDtrbRecVO);
				 
				
				// GET SAR DISTRIBUTION ( CASE 'EXCH_GAIN', 'EXCH_LOSS', CONV_XCH_RT_FLG )
				sarDtrbGainLossVO = dbDao.searchSarDtrbExchGainLossList(adjHisSeq);	
				
				if( "RND".equals(sarDtrbGainLossVO.getConvXchRtFlg()) ){
					// GET SAR DISTRIBUTION ( CASE 'ROUNDING' )
					if(!"".equals(currRndChkVO.getDtrbSrcTpCd())){
						// GET CODE COMBINATION SEQUENCE( CASE 'ROUNDING' )	
						tjCd = "SYS";
						sarAcctMtxVO = dbDao.searchAcctCdForAdjCdCmbSeq(tjCd, currRndChkVO.getDtrbSrcTpCd());
						sarAcctMtxVO.setOtsCdCmbSeq(otsCdCmbSeq);
						sarAcctMtxVO.setSrcTpCd(currRndChkVO.getDtrbSrcTpCd());
						sysCdCmbSeq = dbDao.searchAdjCdCmbSeq(sarAcctMtxVO);
						
						// 2014.06.19 임시 로직 추가 
						// CODE COMBINATION SEQUENCE 없으면 저장하고 조회 로직
						if(sysCdCmbSeq == null || sysCdCmbSeq.equals("")){
							dbDao.addAdjCdCmbSeq(sarAcctMtxVO);
							sysCdCmbSeq = dbDao.searchAdjCdCmbSeq(sarAcctMtxVO);
						}
						// 2014.06.19 임시 로직 추가 
						
						if(sysCdCmbSeq == null || sysCdCmbSeq.equals("")){
							throw new EventException(new ErrorHandler("SAR00035",new String[]{}).getMessage());
						}
						
						// SET SAR DISTRIBUTION VO For Insert( CASE 'EXCH_GAIN', 'EXCH_LOSS' )	
						sarDtrbRoundingVO.setDtrbSrcSeq(adjHisSeq);
						sarDtrbRoundingVO.setDtrbSrcTpCd(currRndChkVO.getDtrbSrcTpCd());
						sarDtrbRoundingVO.setCdCmbSeq(sysCdCmbSeq);
						sarDtrbRoundingVO.setAdjAmt(adjHisVO.getAdjAmt());
						sarDtrbRoundingVO.setRecAcctAmt(currRndChkVO.getCurrRound());
						sarDtrbRoundingVO.setBlCurrCd(blCurrCd);
						sarDtrbRoundingVO.setCreUsrId(adjHisVO.getCreUsrId());
						sarDtrbRoundingVO.setUpdUsrId(adjHisVO.getUpdUsrId());
						sarDtrbRoundingVO.setCustCntCd(sarDtrbGainLossVO.getCustCntCd());
						sarDtrbRoundingVO.setCustSeq(sarDtrbGainLossVO.getCustSeq());
						sarDtrbRoundingVO.setDiffFlg(sarDtrbGainLossVO.getDiffFlg());
						
						dbDao.addSarDtrbRoundingList(sarDtrbRoundingVO);
					}
				}else if( "EXCH".equals(sarDtrbGainLossVO.getConvXchRtFlg()) ){
					if(!"".equals(sarDtrbGainLossVO.getDtrbSrcTpCd())){
						// GET CODE COMBINATION SEQUENCE( CASE 'EXCH_GAIN', 'EXCH_LOSS' )	
						tjCd = "SYS";
						sarAcctMtxVO = dbDao.searchAcctCdForAdjCdCmbSeq(tjCd, sarDtrbGainLossVO.getDtrbSrcTpCd());
						sarAcctMtxVO.setOtsCdCmbSeq(otsCdCmbSeq);
						sarAcctMtxVO.setSrcTpCd(sarDtrbGainLossVO.getDtrbSrcTpCd());
						sysCdCmbSeq = dbDao.searchAdjCdCmbSeq(sarAcctMtxVO);
						
						// 2014.06.19 임시 로직 추가 
						// CODE COMBINATION SEQUENCE 없으면 저장하고 조회 로직
						if(sysCdCmbSeq == null || sysCdCmbSeq.equals("")){
							dbDao.addAdjCdCmbSeq(sarAcctMtxVO);
							sysCdCmbSeq = dbDao.searchAdjCdCmbSeq(sarAcctMtxVO);
						}
						// 2014.06.19 임시 로직 추가 
						
						if(sysCdCmbSeq == null || sysCdCmbSeq.equals("")){
							throw new EventException(new ErrorHandler("SAR00035",new String[]{}).getMessage());
						}
							
						// SET SAR DISTRIBUTION VO For Insert( CASE 'EXCH_GAIN', 'EXCH_LOSS' )										
						sarDtrbGainLossVO.setCdCmbSeq(sysCdCmbSeq);
						sarDtrbGainLossVO.setCreUsrId(adjHisVO.getCreUsrId());
						sarDtrbGainLossVO.setUpdUsrId(adjHisVO.getUpdUsrId());
						sarDtrbGainLossVO.setCustCntCd(sarDtrbGainLossVO.getCustCntCd());
						sarDtrbGainLossVO.setCustSeq(sarDtrbGainLossVO.getCustSeq());
						
						dbDao.addSarDtrbExchGainLossList(sarDtrbGainLossVO);					
					}
				}
				
				//환율 틀린경우 
				if(adjHisVO.getGlCrsCurrCd() != null && !adjHisVO.getGlCrsCurrCd().equals("")){
					//tagert currency 분개 
					if(sarDtrbGainLossVO.getGlDtrbSrcTpCd().equals("EXCH_LOSS") || sarDtrbGainLossVO.getGlDtrbSrcTpCd().equals("EXCH_GAIN")){
						tjCd = "SYS";
						sarAcctMtxVO = dbDao.searchAcctCdForAdjCdCmbSeq(tjCd, sarDtrbGainLossVO.getGlDtrbSrcTpCd());
						sarAcctMtxVO.setOtsCdCmbSeq(otsCdCmbSeq);
						sarAcctMtxVO.setSrcTpCd(sarDtrbGainLossVO.getGlDtrbSrcTpCd());
						sysCdCmbSeq = dbDao.searchAdjCdCmbSeq(sarAcctMtxVO);
						
						// 2014.06.19 임시 로직 추가 
						// CODE COMBINATION SEQUENCE 없으면 저장하고 조회 로직
						if(sysCdCmbSeq == null || sysCdCmbSeq.equals("")){
							dbDao.addAdjCdCmbSeq(sarAcctMtxVO);
							sysCdCmbSeq = dbDao.searchAdjCdCmbSeq(sarAcctMtxVO);
						}
						// 2014.06.19 임시 로직 추가 
						
						if(sysCdCmbSeq == null || sysCdCmbSeq.equals("")){
							throw new EventException(new ErrorHandler("SAR00035",new String[]{}).getMessage());
						}
						
						// SET SAR DISTRIBUTION VO For Insert( CASE 'EXCH_GAIN', 'EXCH_LOSS' )										
						sarDtrbGainLossVO.setCdCmbSeq(sysCdCmbSeq);
						sarDtrbGainLossVO.setCreUsrId(adjHisVO.getCreUsrId());
						sarDtrbGainLossVO.setUpdUsrId(adjHisVO.getUpdUsrId());
						sarDtrbGainLossVO.setCustCntCd(sarDtrbGainLossVO.getCustCntCd());
						sarDtrbGainLossVO.setCustSeq(sarDtrbGainLossVO.getCustSeq());
						sarDtrbGainLossVO.setGlCurrCd(adjHisVO.getGlCrsCurrCd());
						//blCurrCd not null 항목 
						sarDtrbGainLossVO.setBlCurrCd(blCurrCd);
						
						dbDao.addSarTargetDtrbExchGainLossList(sarDtrbGainLossVO);	 	
					}
				//같은경우
				} else {
					dbDao.modifySarTargetDtrbExchGainLossList(sarDtrbGainLossVO);
				}
				
				
				//WF 인 경우 추가 요청 
				if(adjHisVO.getAdjTpCd().equals("WF")){
					//EX GAIN LOSS HRD 제거 
					dbDao.modifyWFDtrbExchGainLossList(sarDtrbGainLossVO);
					//REC -> ADJ 로 복사  
					dbDao.modifyWFRECToADJDtrb(sarDtrbGainLossVO);  
				}
				
				// SET SAR ADJUST HISTORY VO For UPDATE CODE COMBINATION SEQUENCE, ACCOUNT MATRIX SEQUENCE
				updAdjHisVO.setAdjCdCmbSeq(adjCdCmbSeq);
				updAdjHisVO.setAcctMtxSeq(acctMtxSeq);
				updAdjHisVO.setAdjHisSeq(adjHisSeq);
				updAdjHisVO.setUpdUsrId(adjHisVO.getUpdUsrId());
				
				dbDao.modifyAdjustHisList(updAdjHisVO);				
			}else if("REVERSE".equals(adjStsCd)){ // Reverse Process
				String orgAdjHisSeq = "";
				
				SarDtrbVO sarDtrbVO = new SarDtrbVO();
				SarAdjHisVO adjHisVO = new SarAdjHisVO();
				
				// GET SAR ADJUST HISTORY
				adjHisVO = dbDao.searchAdjHisList(adjHisSeq);	
				
				
				// GET ORIGIN ADJUST HISTORY SEQUENCE
				orgAdjHisSeq = dbDao.searchOriginAdjustHisSeqList(adjHisVO);
				
				
				// SET SAR DISTRIBUTION VO For Insert
				sarDtrbVO.setAdjHisSeq(adjHisSeq);
				sarDtrbVO.setOrgAdjHisSeq(orgAdjHisSeq);
				sarDtrbVO.setCreUsrId(adjHisVO.getUpdUsrId());
				sarDtrbVO.setUpdUsrId(adjHisVO.getUpdUsrId());
				
				dbDao.addSarDtrbForRvsList(sarDtrbVO);	
				
			}			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Retrieve AP GL DT <br>
	 * 
	 * @param String adjNo
	 * @param String rvsFlg
	 * @param String dtTpCd
	 * @return String
	 * @exception EventException
	 */
	public String searchApGlDtList(String adjNo, String rvsFlg, String dtTpCd) throws EventException{
		try {
			return dbDao.searchApGlDtList(adjNo, rvsFlg, dtTpCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Retrieve AP INTERFACE Header Info <br>
	 * 
	 * @param ApIfSetVO apIfSetVO
	 * @return List<SapInvIfHdrVO>
	 * @exception EventException
	 */
	public List<SapInvIfHdrVO> searchSapInvIfHdrList(ApIfSetVO apIfSetVO) throws EventException{
		AccountReceivableCommonDBDAO arComDao = new AccountReceivableCommonDBDAO();
		
		List<SapInvIfHdrVO> sapInvIfHdrVO = new ArrayList<SapInvIfHdrVO>();
				
		Boolean rtnVal = false;
		try {
			sapInvIfHdrVO = dbDao.searchSapInvIfHdrList(apIfSetVO);
			
			for(int i=0; i<sapInvIfHdrVO.size(); i++){
				// AP PERIOD VALIDATION...
				rtnVal = arComDao.checkAPPeriod(sapInvIfHdrVO.get(i).getOfcCd(), apIfSetVO.getApGlDt());
				
				if(rtnVal == false){
					throw new EventException(new ErrorHandler("SAR00003",new String[]{"A/P Period Status"}).getMessage());
				}
				
				
				// AP VENDOR VALIDATION...
				VendorInfoVO vendorInfoVO = arComDao.searchVendorInfo(sapInvIfHdrVO.get(i).getVndrNo());
				
				if(vendorInfoVO == null){
					throw new EventException(new ErrorHandler("SAR00039",new String[]{""}).getMessage());
				} else {	
					if(vendorInfoVO.getInterCoCd().equals("") || vendorInfoVO.getGenPayTermCd().equals("") || vendorInfoVO.getApPayMzdLuCd().equals("")){
						throw new EventException(new ErrorHandler("SAR00039",new String[]{}).getMessage());
					}
				}
				
				
				// PAY GROUP VALIDATION...
				PayGroupInfoVO payGroupInfoVO = arComDao.searchPayGroupInfo(sapInvIfHdrVO.get(i).getOfcCd());
				
				if(payGroupInfoVO == null){
					throw new EventException(new ErrorHandler("SAR00040",new String[]{""}).getMessage());
				} else {	
					if(payGroupInfoVO.getPayGrpLuCd().equals("")){
						throw new EventException(new ErrorHandler("SAR00043",new String[]{}).getMessage());
					} else if(payGroupInfoVO.getApCtrCd().equals("")){
						throw new EventException(new ErrorHandler("SAR00044",new String[]{}).getMessage());
					}
				}
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return sapInvIfHdrVO;
	}
	
	/**
	 * Retrieve AP INTERFACE Detail Info <br>
	 * 
	 * @param ApIfSetVO apIfSetVO
	 * @return List<SapInvIfDtlVO>
	 * @exception EventException
	 */
	public List<SapInvIfDtlVO> searchSapInvIfDtlList(ApIfSetVO apIfSetVO) throws EventException{
		try {
			return dbDao.searchSapInvIfDtlList(apIfSetVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * get Sequence No for AP HDR IF <br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchSapInvHdrIfSeqNo() throws EventException{
		try {
			return dbDao.searchSapInvHdrIfSeqNo();			
		}catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * get Code Combination Sequence No for AP HDR IF <br>
	 * 
	 * @param SapInvIfHdrVO sapInvIfHdrVO
	 * @param String adjTpcd
	 * @param String sysTpCd
	 * @return String
	 * @exception EventException
	 */
	public String searchSapInvHdrIfCdCmbSeq(SapInvIfHdrVO sapInvIfHdrVO, String adjTpcd, String sysTpCd) throws EventException{
		try {
			return dbDao.searchSapInvHdrIfCdCmbSeq(sapInvIfHdrVO, adjTpcd, sysTpCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * get Sequence No for AP DTL IF <br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchSapInvDtlIfSeqNo() throws EventException{
		try {
			return dbDao.searchSapInvDtlIfSeqNo();			
		}catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
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
	public String searchSapInvDtlIfCdCmbSeq(SapInvIfDtlVO sapInvIfDtlVO, String adjTpcd, String sysTpCd, String adjNo, String offArAcctCd, String offInterCoCd) throws EventException{
		try {
			//2014.08.18 add adjNo
			return dbDao.searchSapInvDtlIfCdCmbSeq(sapInvIfDtlVO, adjTpcd, sysTpCd, adjNo, offArAcctCd, offInterCoCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
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
	public String searchSapInvDtlIfCdCmbNextSeq(SapInvIfDtlVO sapInvIfDtlVO, String adjTpcd, String dtrbCdCmbSeq, String offGainAndLssAcctCd, String sysTpCd, String rvsFlg) throws EventException{
		try {
			//2014.08.18 add dtrbCdCmbSeq
			return dbDao.searchSapInvDtlIfCdCmbNextSeq(sapInvIfDtlVO, adjTpcd, dtrbCdCmbSeq, offGainAndLssAcctCd, sysTpCd, rvsFlg);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
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
	public void addSapInvHdrIfCdCmbSeq(SapInvIfHdrVO sapInvIfHdrVO, String adjTpcd, String sysTpCd) throws EventException{
		try {
			dbDao.addSapInvHdrIfCdCmbSeq(sapInvIfHdrVO, adjTpcd, sysTpCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
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
	public void addSapInvDtlIfCdCmbSeq(SapInvIfDtlVO sapInvIfDtlVO, String adjTpcd, String sysTpCd, String adjNo, String offArAcctCd, String offInterCoCd) throws EventException{
		try {
			//2014.08.18 add adjNo
			dbDao.addSapInvDtlIfCdCmbSeq(sapInvIfDtlVO, adjTpcd, sysTpCd, adjNo, offArAcctCd, offInterCoCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
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
	public void addSapInvDtlIfCdCmbNextSeq(SapInvIfDtlVO sapInvIfDtlVO, String adjTpcd, String sysTpCd, String dtrbCdCmbSeq, String offGainAndLssAcctCd, String rvsFlg) throws EventException{
		try {
			//2014.08.18 add dtrbCdCmbSeq
			dbDao.addSapInvDtlIfCdCmbNextSeq(sapInvIfDtlVO, adjTpcd, sysTpCd, dtrbCdCmbSeq, offGainAndLssAcctCd, rvsFlg);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Search ASA No, Currency List<br> 
	 * 
	 * @param AdjustCondVO adjustCondVO
	 * @return List<SarAsaMstVO>
	 * @exception EventException
	 */
	public List<SarAsaMstVO> searchAsaNoList(AdjustCondVO adjustCondVO) throws EventException{
		try {
			List<SarAsaMstVO> list = dbDao.searchAsaNoList(adjustCondVO);
			
			return list;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	
    /**
     * Search Adjust view accounting
     * @author jinyoonoh 2014. 7. 16.
     * @param AdjViewAccountingListVO vo
     * @return List<AdjViewAccountingListVO>
     * @throws EventException
     */
    public List<AdjViewAccountingListVO> searchAdjViewAccountingList(AdjViewAccountingListVO vo) throws EventException {
		try {
			
			List<AdjViewAccountingListVO> list = dbDao.searchAdjViewAccountingList(vo);
			return list;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
    }	

    /**
	 * Call Ap Functional Exchange Rate Function<br>
	 * @param ApIfSetVO apIfSetVO
	 * @return String
	 * @throws EventException
	 */
	public String searchSarGetGlXchRtFncList(ApIfSetVO apIfSetVO) throws EventException {
		try {
			return dbDao.searchSarGetGlXchRtFncList(apIfSetVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Search sum of adj_acct_amt<br>
	 * @param String offsetNo
	 * @param String rvsFlg
	 * @return String
	 * @throws EventException
	 */
	public String searchAdjAcctAmtSumList(String offsetNo, String rvsFlg) throws EventException {
		try {
			return dbDao.searchAdjAcctAmtSumList(offsetNo, rvsFlg);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Search sum of offst_amt<br>
	 * @param String offsetNo
	 * @return String
	 * @throws EventException
	 */
	public String searchOffsetAmtSumList(String offsetNo) throws EventException {
		try {
			return dbDao.searchOffsetAmtSumList(offsetNo);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Search AR/GAIN/LOSS Account Code<br>
	 * @param String adjTpCd
	 * @return SarAcctMtxVO
	 * @throws EventException
	 */
	public SarAcctMtxVO searchSarAcctCodeList(String adjTpCd) throws EventException {
		try {
			return dbDao.searchSarAcctCodeList(adjTpCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
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
	public SapInvoiceInterfaceDetailVO searchApLineAmtCalcList(String offApFuncExRt, String offAdjAcctAmt, String offMstSumAmt, String offApHdrAmt, String dpPrcsKnt, String adjTpcd, String rvsFlg) throws EventException {
		try {
			return dbDao.searchApLineAmtCalcList(offApFuncExRt, offAdjAcctAmt, offMstSumAmt, offApHdrAmt, dpPrcsKnt, adjTpcd, rvsFlg);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Setting INV NO of Offset, INV TYPE LOOKUP CODE<br>
	 * @author 
	 * @param ApIfSetVO apIfSetVO
	 * @param String offApHdrAmt
	 * @param String offOfcCd
	 * @return List<SapInvIfHdrVO>
	 * @throws EventException
	 */
	public List<SapInvIfHdrVO> searchOffSapInvNoList(ApIfSetVO apIfSetVO, String offApHdrAmt, String offOfcCd) throws EventException{
		
		List<SapInvIfHdrVO> sapInvIfHdrTmpVO = new ArrayList<SapInvIfHdrVO>();
				
		try {
			sapInvIfHdrTmpVO = dbDao.searchOffSapInvNoList(apIfSetVO, offApHdrAmt, offOfcCd);			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return sapInvIfHdrTmpVO;
	}
	
	/**
     * SCO_BAT_HIS 테이블에 데이타를 생성한다.    
     * @author myoungsin park
     * @param String batSeq
     * @param SignOnUserAccount account
     * @param AutosettlementCondVO paramVO
     * @return String
     * @throws EventException
     */
    public String createAutoSettlementBat(String batSeq,SignOnUserAccount account,AutosettlementCondVO paramVO) throws EventException {
    	try {
    		
    		dbDao.removeAutoSettlementTemporaryList(); 
    		BatHisVO batHisVO = new BatHisVO();  
    		String params = ""; 
    		params = batSeq + "#" + account.getUsr_id() + "#" + paramVO.getAdjTjTpKeyCd() + "#" + paramVO.getAdjTjTpCd() + "#" + paramVO.getAdjDt() + "#" + account.getOfc_cd();
    		batHisVO.setBatSeq(batSeq);
    		batHisVO.setBatRsltCd("W");
    		batHisVO.setPgmSubSysCd("SAR");
    		batHisVO.setBatPgmNo("STM_SAR_B3003");
    		batHisVO.setApplPgmNo("STM_SAR_3003");
    		batHisVO.setBatParaCtnt(params);
    		batHisVO.setCreUsrId(account.getUsr_id());
    		batHisVO.setUpdUsrId(account.getUsr_id());
    		agtDao.addBatHis(batHisVO);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
    		throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
    	}
    	return batSeq;
    }
    
    /**
     * Autosettle Batch run
     * @param String batSeq
     * @return String
     * @throws EventException
     */
    public String excuteAutoSettlementBat(String batSeq) throws EventException {
    	try{
    		ScheduleUtil su = new ScheduleUtil(); 
        	su.directExecuteJob("STM_SAR_B3003", batSeq);
		} catch (DAOException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"AutoSettlement Batch"}).getMessage(),e);
		} catch (Exception e){ 
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"AutoSettlement Batch"}).getMessage(),e);
		}
		return batSeq;
    } 
	
    /**
     * removeAutoSettlementDelCheckList
     * @param AutoSettlementInfoVO[] autoSettlementInfoVOs
     * @throws EventException
     */
    public void removeAutoSettlementDelCheckList(AutoSettlementInfoVO[] autoSettlementInfoVOs) throws EventException {
    	try {
    		dbDao.removeAutoSettlementDelCheckList(autoSettlementInfoVOs);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
    
	/**
	 * check batch status
	 * R: Running
	 * S: Start
	 * 
	 * @param pgmNo
	 * @return
	 * @throws EventException
	 */
	public String searchAutoSettlementBatStsCd(String pgmNo) throws EventException{
		ScheduleUtil su = new ScheduleUtil();
		boolean isRunningStatus = false;
		
		try {
			isRunningStatus = su.isRunning(pgmNo);			
			log.error("Auto Settlement Batch Running:::"+isRunningStatus+"\n");
			if(isRunningStatus){
				return "R"; // Running
			}else{
				return "S"; // Start 
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}	
	
	/**
	 * batch 가 running 상태일 경우, E로 update
	 * 
	 * @param batSeq
	 * @param account
	 * @throws EventException
	 */
	public void manageCancelAutoSettlementBat(String batSeq, SignOnUserAccount account) throws EventException {
		try {
			
			dbDao.manageCancelAutoSettlementBat(batSeq); // 'E'로 update
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}		
	    
}
