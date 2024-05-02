/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : AccountReceivableOutstandingMigrationBCImpl.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier :
 *@LastVersion : 1.0
 * 2015.11.26 authorName
 * 1.0 Creation
 * --------------------------------------------------------
 * History
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.basic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.InvArIfNoVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration.AccountReceivableOutstandingMigrationDBDAO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.vo.AROutstandingChgVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.vo.AROutstandingHistVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.vo.AROutstandingHdrVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.vo.AROutstandingDtlVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.vo.AROutstandingCheckVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.vo.OutstandingDtrbVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.vo.LookupInfoVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.vo.CurrencyCodeVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.vo.RegionCenterVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.vo.OutstandingAccountCondVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.vo.OutstandingAccountVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.vo.LedgerCombinationCondVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.vo.ARExrateVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.vo.ASAAccountCondVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * AccountReceivableOutstandingMigrationBCImpl Business Logic ServiceCommand - Handling
 * AccountReceivableOutstandingMigrationBCImpl Business transaction.
 * 
 * @author
 * @see AccountReceivableOutstandingMigrationDBDAO
 * @since J2EE 1.6
 */
public class AccountReceivableOutstandingMigrationBCImpl extends BasicCommandSupport implements AccountReceivableOutstandingMigrationBC {	
 
	// Database Access Object
	private transient AccountReceivableOutstandingMigrationDBDAO dbDao = null;
	
	/**
	 * AccountReceivableOutstandingMigrationBCImpl object creation.<br>
	 * AccountReceivableOutstandingDBDAO creation.<br>
	 */
	public AccountReceivableOutstandingMigrationBCImpl() {
		
		dbDao = new AccountReceivableOutstandingMigrationDBDAO();
		
	}
	
	/**
	 * Create AR Information to Outstanding<br> 
	 * 
	 * @param List<InvArIfNoVO> ifNos
	 * @exception EventException
	 */
	public void createOutstandingInfo(List<InvArIfNoVO> ifNos) throws EventException{
	
		try {
			if(ifNos != null){
				
				//AccountReceivableCommonBC arCommon = new AccountReceivableCommonBCImpl();
				//AccountReceivableOutstandingIFBC sakuraIf = new AccountReceivableOutstandingIFBCImpl();
				
				String EMPTYINVNO = "**********";
				String otsHisSeq = "";
				String hdrUpdFlg = "Y";
				
				for (int i = 0; i < ifNos.size(); i++) {
					
					AROutstandingHdrVO arOutstandingHdrVO = null;
					List<AROutstandingDtlVO> arOutstandingDtlVOs = null;					
					List<AROutstandingHistVO> arOutstandingHistVOs = null;	
					List<AROutstandingChgVO> arOutstandingChgVOs = null;	
					AROutstandingCheckVO arOutstandingCheckVO = new AROutstandingCheckVO();
					
					arOutstandingHdrVO = dbDao.searchINVForOutstandingHeader(ifNos.get(i).getIfNo());			
					arOutstandingDtlVOs = dbDao.searchINVForOutstandingDetail(ifNos.get(i).getIfNo());
					arOutstandingHistVOs = dbDao.searchINVForOutstandingHist(ifNos.get(i).getIfNo());
					arOutstandingChgVOs = dbDao.searchINVForOutstandingCharge(ifNos.get(i).getIfNo());
					
					arOutstandingCheckVO.setRhqCd(arOutstandingHdrVO.getRhqCd());
					arOutstandingCheckVO.setOtsOfcCd(arOutstandingHdrVO.getOtsOfcCd());
					arOutstandingCheckVO.setBlNo(arOutstandingHdrVO.getBlNo());
					arOutstandingCheckVO.setInvNo(arOutstandingHdrVO.getInvNo());
					
					String newRevTypeCd = arOutstandingHdrVO.getRevTpSrcCd();
					String otsRevTypeCd = dbDao.searchOutstandingRevType(arOutstandingCheckVO);
					
					hdrUpdFlg = "Y";
					
					//Check to update Outstanding Header by revenue type - 2015.03.02
					if(otsRevTypeCd != null && !"".equals(otsRevTypeCd)){
						if(((otsRevTypeCd.substring(0,1).equals("B") || otsRevTypeCd.substring(0,1).equals("C")) && newRevTypeCd.substring(0,1).equals("M")) ||
						   ((otsRevTypeCd.equals("MDM") || otsRevTypeCd.equals("MDT")) && !newRevTypeCd.equals("MDM") && !newRevTypeCd.equals("MDT") && newRevTypeCd.substring(0,1).equals("M"))){
							hdrUpdFlg = "N";
						}
					}
					
					/* block - 2015.03.06
					ARExrateVO arExrateVO = new ARExrateVO();
					
					//Mapping to arExrateVO the exchange rate parameters
					arExrateVO.setInvCustCntCd(arOutstandingHdrVO.getShpToCustCntCd());
					arExrateVO.setInvCustSeq(arOutstandingHdrVO.getShpToCustSeq());
					arExrateVO.setVslCd(arOutstandingHdrVO.getVslCd());
					arExrateVO.setSkdVoyNo(arOutstandingHdrVO.getSkdVoyNo());
					arExrateVO.setSkdDirCd(arOutstandingHdrVO.getDirCd());
					arExrateVO.setIoBndCd(arOutstandingHdrVO.getBkgIoBndCd());
					arExrateVO.setSvcScpCd(arOutstandingHdrVO.getSvcScpCd());
					arExrateVO.setPolCd(arOutstandingHdrVO.getPolCd());
					arExrateVO.setPodCd(arOutstandingHdrVO.getPodCd());
					arExrateVO.setXchRtDt(arOutstandingHdrVO.getXchRtDt());
					arExrateVO.setArOfcCd(arOutstandingHdrVO.getArOfcCd());
					
					String xchRtUsdTpCd = arOutstandingHdrVO.getXchRtTpCd();
					String xchRt3rdTpCd = arOutstandingHdrVO.getXchRtN3rdTpCd();
					String lclCurrCd = arOutstandingHdrVO.getOfcCurrCd();
					String invCurrCd = arOutstandingHdrVO.getInvCurrCd();
					String invLoclXchRt = "";
					String invUsdXchRt = "";
					
					if(!"".equals(invCurrCd)){
						if(invCurrCd.equals(lclCurrCd)){
							invLoclXchRt = "1";
						} else {
							arExrateVO.setLclCurrCd(lclCurrCd);
							arExrateVO.setChgCurrCd(invCurrCd);
							
							if(xchRtUsdTpCd.equals("V")) invLoclXchRt = arCommon.searchVVDExrate(arExrateVO);
							else if(xchRtUsdTpCd.equals("I")) {
								if("".equals(arExrateVO.getXchRtDt())) invLoclXchRt = arCommon.searchVVDExrate(arExrateVO);
								else invLoclXchRt = arCommon.searchIndExrate(arExrateVO);
							}
							else if(xchRtUsdTpCd.equals("D")) {
								invLoclXchRt = arCommon.searchDailyExrate(arExrateVO);
								if(invLoclXchRt == null || invLoclXchRt.equals("") || invLoclXchRt.equals("0")){
									arExrateVO.setXchRtDt(arOutstandingHdrVO.getSailDt());
									invLoclXchRt = arCommon.searchAccountExrate(arExrateVO);
								}
							}
							else if(xchRtUsdTpCd.equals("A")) {
								arExrateVO.setXchRtDt(arOutstandingHdrVO.getSailDt());
								invLoclXchRt = arCommon.searchAccountExrate(arExrateVO);
							}
							else {
								arExrateVO.setXchRtDt(arOutstandingHdrVO.getSailDt());
								invLoclXchRt = arCommon.searchAccountExrate(arExrateVO);
							}
						}
						
						if(("USD").equals(invCurrCd)){
							invUsdXchRt = "1";
						} else {
							arExrateVO.setLclCurrCd("USD");
							arExrateVO.setChgCurrCd(invCurrCd);
							arExrateVO.setXchRtDt(arOutstandingHdrVO.getXchRtDt());
							
							if(xchRtUsdTpCd.equals("V")) invUsdXchRt = arCommon.searchVVDExrate(arExrateVO);
							else if(xchRtUsdTpCd.equals("I")) {
								if("".equals(arExrateVO.getXchRtDt())) invUsdXchRt = arCommon.searchVVDExrate(arExrateVO);
								else invUsdXchRt = arCommon.searchIndExrate(arExrateVO);
							}
							else if(xchRtUsdTpCd.equals("D")) {
								invUsdXchRt = arCommon.searchDailyExrate(arExrateVO);
								if(invUsdXchRt == null || invUsdXchRt.equals("") || invUsdXchRt.equals("0")){
									arExrateVO.setXchRtDt(arOutstandingHdrVO.getSailDt());
									invUsdXchRt = arCommon.searchAccountExrate(arExrateVO);
								}
							}
							else if(xchRtUsdTpCd.equals("A")) {
								arExrateVO.setXchRtDt(arOutstandingHdrVO.getSailDt());
								invUsdXchRt = arCommon.searchAccountExrate(arExrateVO);
							}
							else {
								arExrateVO.setXchRtDt(arOutstandingHdrVO.getSailDt());
								invUsdXchRt = arCommon.searchAccountExrate(arExrateVO);
							}
						}
						
						if(invLoclXchRt == null || invLoclXchRt.equals("")) invLoclXchRt = "0";
						if(invUsdXchRt == null || invUsdXchRt.equals("")) invUsdXchRt = "0";
						arOutstandingHdrVO.setInvLoclXchRt(invLoclXchRt);
						arOutstandingHdrVO.setInvUsdXchRt(invUsdXchRt);
					}
					
					for(int p = 0; p < arOutstandingHistVOs.size(); p++){
								
						arExrateVO.setLclCurrCd(lclCurrCd);
						arExrateVO.setChgCurrCd(arOutstandingHistVOs.get(p).getCurrCd());
						arExrateVO.setXchRtDt(arOutstandingHdrVO.getXchRtDt());
						
						String chgCurrCd = arOutstandingHistVOs.get(p).getCurrCd();
						String loclXchRt = "";	//2015.03.02 arOutstandingHistVOs.get(p).getLoclXchRt();
						String usdXchRt = "";
						
						//Search exchange rate by Charge Currency for Local currency conversion - 2015.03.02 add
						if(chgCurrCd.equals(lclCurrCd)){
							
							loclXchRt = "1";
						
						}else{
							
							if((xchRtUsdTpCd.equals("V") && chgCurrCd.equals("USD")) || (xchRt3rdTpCd.equals("V") && !chgCurrCd.equals("USD"))){
								loclXchRt = arCommon.searchVVDExrate(arExrateVO);
							}else if((xchRtUsdTpCd.equals("I") && chgCurrCd.equals("USD")) || (xchRt3rdTpCd.equals("I") && !chgCurrCd.equals("USD"))){
								if("".equals(arExrateVO.getXchRtDt())) loclXchRt = arCommon.searchVVDExrate(arExrateVO);
								else loclXchRt = arCommon.searchIndExrate(arExrateVO);
							}else if((xchRtUsdTpCd.equals("D") && chgCurrCd.equals("USD")) || (xchRt3rdTpCd.equals("D") && !chgCurrCd.equals("USD"))){
								loclXchRt = arCommon.searchDailyExrate(arExrateVO);
								if(loclXchRt == null || loclXchRt.equals("") || loclXchRt.equals("0")){
									arExrateVO.setXchRtDt(arOutstandingHdrVO.getSailDt());
									loclXchRt = arCommon.searchAccountExrate(arExrateVO);
								}
							}else if((xchRtUsdTpCd.equals("A") && chgCurrCd.equals("USD")) || (xchRt3rdTpCd.equals("A") && !chgCurrCd.equals("USD"))){
								arExrateVO.setXchRtDt(arOutstandingHdrVO.getSailDt());
								loclXchRt = arCommon.searchAccountExrate(arExrateVO);
							}else{
								arExrateVO.setXchRtDt(arOutstandingHdrVO.getSailDt());
								loclXchRt = arCommon.searchAccountExrate(arExrateVO);
							}
						}
						
						arExrateVO.setLclCurrCd("USD");
						
						//Search exchange rate by Charge Currency for USD conversion
						if(chgCurrCd.equals("USD")){
							
							usdXchRt = "1";
						
						}else{
							
							if((xchRtUsdTpCd.equals("V") && chgCurrCd.equals(lclCurrCd)) || (xchRt3rdTpCd.equals("V") && !chgCurrCd.equals(lclCurrCd))){
								usdXchRt = arCommon.searchVVDExrate(arExrateVO);
							}else if((xchRtUsdTpCd.equals("I") && chgCurrCd.equals(lclCurrCd)) || (xchRt3rdTpCd.equals("I") && !chgCurrCd.equals(lclCurrCd))){
								if("".equals(arExrateVO.getXchRtDt())) usdXchRt = arCommon.searchVVDExrate(arExrateVO);
								else usdXchRt = arCommon.searchIndExrate(arExrateVO);
							}else if((xchRtUsdTpCd.equals("D") && chgCurrCd.equals(lclCurrCd)) || (xchRt3rdTpCd.equals("D") && !chgCurrCd.equals(lclCurrCd))){
								usdXchRt = arCommon.searchDailyExrate(arExrateVO);
								if(usdXchRt == null || usdXchRt.equals("") || usdXchRt.equals("0")){
									arExrateVO.setXchRtDt(arOutstandingHdrVO.getSailDt());
									usdXchRt = arCommon.searchAccountExrate(arExrateVO);
								}
							}else if((xchRtUsdTpCd.equals("A") && chgCurrCd.equals(lclCurrCd)) || (xchRt3rdTpCd.equals("A") && !chgCurrCd.equals(lclCurrCd))){
								arExrateVO.setXchRtDt(arOutstandingHdrVO.getSailDt());
								usdXchRt = arCommon.searchAccountExrate(arExrateVO);
							}else{
								arExrateVO.setXchRtDt(arOutstandingHdrVO.getSailDt());
								usdXchRt = arCommon.searchAccountExrate(arExrateVO);
							}
						}
						
						//Search exchange rate for 3rd currency
						if(!chgCurrCd.equals("USD") && !chgCurrCd.equals(lclCurrCd)){
							if(usdXchRt == null || usdXchRt.equals("") || usdXchRt.equals("0")){
								arExrateVO.setXchRtDt(arOutstandingHdrVO.getSailDt());
								usdXchRt = arCommon.searchAccountExrate(arExrateVO);
							}
							
							if(loclXchRt == null || loclXchRt.equals("") || loclXchRt.equals("0")){
								arExrateVO.setLclCurrCd(lclCurrCd);
								arExrateVO.setXchRtDt(arOutstandingHdrVO.getSailDt());
								loclXchRt = arCommon.searchAccountExrate(arExrateVO);
							}
						}
						
						if(usdXchRt == null || usdXchRt.equals("")) usdXchRt = "0";
						if(loclXchRt == null || loclXchRt.equals("")) loclXchRt = "0";
						
						arOutstandingHistVOs.get(p).setUsdXchRt(usdXchRt);
						arOutstandingHistVOs.get(p).setLoclXchRt(loclXchRt);
						arOutstandingHistVOs.get(p).setInvLoclXchRt(invLoclXchRt);
						arOutstandingHistVOs.get(p).setInvUsdXchRt(invUsdXchRt);
						
						for(int r = 0; r < arOutstandingDtlVOs.size(); r++){
							if(arOutstandingHistVOs.get(p).getCurrCd().equals(arOutstandingDtlVOs.get(r).getBlCurrCd())){
								arOutstandingDtlVOs.get(r).setLoclXchRt(loclXchRt);
								arOutstandingDtlVOs.get(r).setUsdXchRt(usdXchRt);
							}
						}
						*/		
						/* 2014.08.18 block
						if((EMPTYINVNO).equals(arOutstandingHdrVO.getInvNo())){		
							otsHisSeq = dbDao.searchOutstandingHistSeq();
							arOutstandingHistVOs.get(p).setOtsHisSeq(otsHisSeq);
							
							for(int t = 0; t < arOutstandingChgVOs.size(); t++){
								if(arOutstandingHistVOs.get(p).getIfNo().equals(arOutstandingChgVOs.get(t).getIfNo())){
									arOutstandingChgVOs.get(t).setOtsHisSeq(otsHisSeq);
								}
							}
						}
						*/
				//	}
				
					//Check Outstanding Header
					if(!dbDao.checkOutstandingHeader(arOutstandingCheckVO)) {
						
						dbDao.addOutstandingDetail(arOutstandingDtlVOs);
						dbDao.addOutstandingHeader(arOutstandingHdrVO);
					
					}else{
						
						for(int s = 0; s < arOutstandingDtlVOs.size(); s++){
							
							List<AROutstandingDtlVO> separateDtlVOs = new ArrayList<AROutstandingDtlVO>();
							separateDtlVOs.add(arOutstandingDtlVOs.get(s));
							
							arOutstandingCheckVO.setBlCurrCd(arOutstandingDtlVOs.get(s).getBlCurrCd());
							arOutstandingCheckVO.setChgTpCd(arOutstandingDtlVOs.get(s).getChgTpCd());
							
							//Check Outstanding Detail
							if(dbDao.checkOutstandingDetail(arOutstandingCheckVO)){	
								dbDao.modifyOutstandingDetail(separateDtlVOs);	
							}else{
								dbDao.addOutstandingDetail(separateDtlVOs);
							}
						}

						if("Y".equals(hdrUpdFlg)) {
							dbDao.modifyOutstandingHeader(arOutstandingHdrVO);
						}else{
							dbDao.modifyOTSSettleFlag(arOutstandingHdrVO);
							dbDao.modifyOTSHeaderINVExrate(arOutstandingHdrVO);
						}
						
						//block - 2015.03.02
						//Check to update Outstanding Header by revenue type
						/*
						if(newRevTypeCd.substring(0,1).equals("B") || newRevTypeCd.substring(0,1).equals("C") || 
						   newRevTypeCd.equals("MDM") || newRevTypeCd.equals("MDT") ||
						   (!newRevTypeCd.equals("MDM") && !newRevTypeCd.equals("MDT") && newRevTypeCd.substring(0,1).equals("M") && 
						    !otsRevTypeCd.equals("MDM") && !otsRevTypeCd.equals("MDT") && otsRevTypeCd.substring(0,1).equals("M"))) {
						
						 	dbDao.modifyOutstandingHeader(arOutstandingHdrVO);
						
						}else{
							
							dbDao.modifyOTSSettleFlag(arOutstandingHdrVO);
						}
						*/
					}
					
					//2015.04.01 modify BKG OTS
					//dbDao.modifyBKGOutstanding(arOutstandingHdrVO);
					
					//If there is invoice no then create negative amount for B/L
					arOutstandingCheckVO.setInvNo(EMPTYINVNO);
					
					if(dbDao.checkOutstandingHist(ifNos.get(i).getIfNo() + "1") && dbDao.checkOutstandingHeader(arOutstandingCheckVO) && !(EMPTYINVNO).equals(arOutstandingHdrVO.getInvNo())){
						
						arOutstandingHdrVO.setInvNo(EMPTYINVNO);
						
						for(int l = 0; l < arOutstandingDtlVOs.size(); l++){
							arOutstandingDtlVOs.get(l).setInvNo(EMPTYINVNO);
							
							BigDecimal invAmt = new BigDecimal(arOutstandingDtlVOs.get(l).getInvAmt()).multiply(new BigDecimal(-1));
							
							arOutstandingDtlVOs.get(l).setInvAmt(invAmt.toString());
							arOutstandingDtlVOs.get(l).setLoclXchRt("");
							arOutstandingDtlVOs.get(l).setUsdXchRt("");
						}
						
						dbDao.modifyOutstandingDetail(arOutstandingDtlVOs);
						dbDao.modifyOTSSettleFlag(arOutstandingHdrVO);
						dbDao.modifyOutstandingHistInvNo(arOutstandingHistVOs);
						dbDao.modifyOutstandingChargeInvNo(arOutstandingChgVOs);
						
						//2015.04.01 modify BKG OTS
						//dbDao.modifyBKGOutstanding(arOutstandingHdrVO);
						
						//2015.03.11 Interface to SAKURA in case of invoice issue (OTS SMRY is INV)
						//for(int o = 0; o < arOutstandingHistVOs.size(); o++){
						//	sakuraIf.createSakuraOTSIFdata(arOutstandingHistVOs.get(o).getIfNo(),"P");
						//}
					} else {
						// 2014.08.18 add search OTS history sequence
						for(int m = 0; m < arOutstandingHistVOs.size(); m++){
							
							if(dbDao.checkOutstandingHist(arOutstandingHistVOs.get(m).getIfNo())) {
								throw new EventException(new ErrorHandler("COM12226", new String[]{"OTS B/L No : "+arOutstandingHistVOs.get(m).getBlNo()}).getMessage());
							}
							
							otsHisSeq = dbDao.searchOutstandingHistSeq(Integer.toString(m));
							arOutstandingHistVOs.get(m).setOtsHisSeq(otsHisSeq);
							
							for(int n = 0; n < arOutstandingChgVOs.size(); n++){
								if(arOutstandingHistVOs.get(m).getIfNo().equals(arOutstandingChgVOs.get(n).getIfNo())){
									arOutstandingChgVOs.get(n).setOtsHisSeq(otsHisSeq);
								}
							}
						}
						
						dbDao.addOutstandingHist(arOutstandingHistVOs);
						dbDao.addOutstandingCharge(arOutstandingChgVOs);
						
						//Create outstanding account distribution info
						createOutstandingAccount(arOutstandingHistVOs, arOutstandingChgVOs);
					}
				}
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Create Outstanding Account distribution Info<br> 
	 * 
	 * @param List<AROutstandingHistVO> arOutstandingHistVOs
	 * @param List<AROutstandingChgVO> arOutstandingChgVOs
	 * @exception EventException
	 */
	public void createOutstandingAccount(List<AROutstandingHistVO> arOutstandingHistVOs, List<AROutstandingChgVO> arOutstandingChgVOs) throws EventException{
		
		try {
			
			String otsHisSeq = "";
			String recAcctMtxSeq = "";
			String revAcctMtxSeq = "";
			String recArAcctCd = "";
			String revArAcctCd = "";
			String clrAcctCd = "";
			String revAcctDivCd = "";
			String subsCoCd = "";
			String recCmbSeq = "";
			String revCmbSeq = "";
			String cmbSeq = "";
			String funcCurrCd = "";
			String otsCurrCd = "";
			String fncCurrScale = "";
			String convXchRt = "";
			String invOfcCd = "";
			String glDt = "";
			String shpToCustCntCd = "";
			String bilToCustCntCd = "";
			String shpToCustSeq = "";
			String bilToCustSeq = "";
			String revVvdCd = "";
			String revTpSrcCd = "";
			String creUsrId = "";
			String updUsrId = "";
			String acctClssCd = "";
			String chgTpCd = "";
			String tjSrcNm = "";	
			String inpDrAmt = "";
			String inpCrAmt = "";
			String acctDrAmt = "";
			String acctCrAmt = "";
			String otsSrcCd = "";
			
			int dtrbCnt = 0;
			
			BigDecimal recInpAmt = null;
			BigDecimal revInpAmt = null;
			BigDecimal recAcctAmt = null;
			BigDecimal revAcctAmt = null;
			
			//AccountReceivableOutstandingIFBC sakuraIf = new AccountReceivableOutstandingIFBCImpl();
			//AccountReceivableCommonDBDAO arComDao = new AccountReceivableCommonDBDAO();
			//StatementCommonDBDAO stmComDao = new StatementCommonDBDAO();
			List<LookupInfoVO> lookupInfoVOs = new ArrayList<LookupInfoVO>();
			List<CurrencyCodeVO> currencyCodeVOs = new ArrayList<CurrencyCodeVO>();
			RegionCenterVO regionCenterVO = new RegionCenterVO();
			OutstandingAccountCondVO recAccountCondVO = new OutstandingAccountCondVO();
			OutstandingAccountVO recAccountVO = new OutstandingAccountVO();
			LedgerCombinationCondVO recLegrCmbCondVO = new LedgerCombinationCondVO();
			List<OutstandingDtrbVO> outstandingDtrbVOs = new ArrayList<OutstandingDtrbVO>();
			
			//Set parameter from OTS history
			invOfcCd = arOutstandingHistVOs.get(0).getInvOfcCd();
			glDt = arOutstandingHistVOs.get(0).getGlDt();
			shpToCustCntCd = arOutstandingHistVOs.get(0).getShpToCustCntCd();
			shpToCustSeq = arOutstandingHistVOs.get(0).getShpToCustSeq();
			bilToCustCntCd = arOutstandingHistVOs.get(0).getBilToCustCntCd();
			bilToCustSeq = arOutstandingHistVOs.get(0).getBilToCustSeq();
			revVvdCd = arOutstandingHistVOs.get(0).getRevVvdCd();
			revTpSrcCd = arOutstandingHistVOs.get(0).getRevTpSrcCd();
			otsSrcCd = arOutstandingHistVOs.get(0).getOtsSrcCd();
			creUsrId = arOutstandingHistVOs.get(0).getCreUsrId();
			updUsrId = arOutstandingHistVOs.get(0).getUpdUsrId();
			
			//Search functional currency code and precision
			lookupInfoVOs = dbDao.searchLookupList("FUNCTIONAL CURRENCY");
			funcCurrCd = lookupInfoVOs.get(0).getLuCd();
			currencyCodeVOs = dbDao.searchCurrencyCode(funcCurrCd);
			fncCurrScale = currencyCodeVOs.get(0).getDpPrcsKnt();
			
			//Search region/center code and inter company code
			regionCenterVO = dbDao.searchRegionCenter(invOfcCd);
			subsCoCd = dbDao.searchInterCompany(bilToCustCntCd, bilToCustSeq);
			
			//Search account matrix info for RECEIVABLE
			recAccountCondVO.setAcctCtnt1("REC");
			recAccountCondVO.setAcctCtnt2(otsSrcCd);
			recAccountCondVO.setAcctTpCd(revTpSrcCd);
			recAccountCondVO.setGlDt(glDt);
			
			recAccountVO = dbDao.searchOutstandingAccount(recAccountCondVO);
			
			if(recAccountVO == null){
				throw new EventException(new ErrorHandler("SAR00034",new String[]{}).getMessage());
			}
			
			recAcctMtxSeq = recAccountVO.getAcctMtxSeq();
			recArAcctCd = recAccountVO.getArAcctCd();
			clrAcctCd = recAccountVO.getClrAcctCd();
			
			//Search ledger combination sequence for RECEIVABLE
			recLegrCmbCondVO.setSgmCtnt1("01");
			recLegrCmbCondVO.setSgmCtnt2(regionCenterVO.getRgnCd());
			recLegrCmbCondVO.setSgmCtnt3(regionCenterVO.getCtrCd());
			recLegrCmbCondVO.setSgmCtnt4(recArAcctCd);
			recLegrCmbCondVO.setSgmCtnt5(subsCoCd);
			recLegrCmbCondVO.setSgmCtnt6("0000000000");
			recLegrCmbCondVO.setGlDt(glDt);
			
			recCmbSeq = dbDao.searchLedgerCombination(recLegrCmbCondVO);
			
			if(recCmbSeq == null || recCmbSeq.equals("")){
				//throw new EventException(new ErrorHandler("SAR00035",new String[]{}).getMessage());
				
				dbDao.addLedgerCombination(recLegrCmbCondVO);
				recCmbSeq = dbDao.searchLedgerCombination(recLegrCmbCondVO);
			}
			
			//Search ledger combination sequence for CLEARING ACCOUNT
			if(!clrAcctCd.equals("")) {
				revAcctMtxSeq = recAcctMtxSeq;
				recLegrCmbCondVO.setSgmCtnt4(clrAcctCd);
				revCmbSeq = dbDao.searchLedgerCombination(recLegrCmbCondVO);
				
				if(revCmbSeq == null || revCmbSeq.equals("")){
					//throw new EventException(new ErrorHandler("SAR00035",new String[]{}).getMessage());
					
					dbDao.addLedgerCombination(recLegrCmbCondVO);
					revCmbSeq = dbDao.searchLedgerCombination(recLegrCmbCondVO);
				}
			}
			
			//Process accounting by OTS Charge info
			for(int i = 0; i < arOutstandingChgVOs.size(); i++){
				otsHisSeq = arOutstandingChgVOs.get(i).getOtsHisSeq();
				chgTpCd = arOutstandingChgVOs.get(i).getChgTpCd();
				tjSrcNm = arOutstandingChgVOs.get(i).getTjSrcNm();
				otsCurrCd = arOutstandingChgVOs.get(i).getBlCurrCd();
				recInpAmt = new BigDecimal(arOutstandingChgVOs.get(i).getInvAmt());
				
				//Set revenue amount in case of ASA cross currency charge or normal charge
				if("AGENT".equals(tjSrcNm) && "AGC".equals(chgTpCd)){
					revInpAmt = new BigDecimal(searchASARevenueAmount(arOutstandingChgVOs.get(i), funcCurrCd, glDt));
				} else {
					revInpAmt = new BigDecimal(arOutstandingChgVOs.get(i).getInvAmt());
				}
				
				//Search account exchange rate to convert to functional currency
				if(funcCurrCd.equals(otsCurrCd)){
					convXchRt = "1";
				} else {
					ARExrateVO arExrateVO = new ARExrateVO();
					
					arExrateVO.setXchRtDt(glDt);
					arExrateVO.setLclCurrCd(funcCurrCd);
					arExrateVO.setChgCurrCd(otsCurrCd);
					
					convXchRt = dbDao.searchAccountExrate(arExrateVO);
				}
				
				if(convXchRt == null || convXchRt.equals("")){
					throw new EventException(new ErrorHandler("SAR00025",new String[]{}).getMessage());
				}
				
				recAcctAmt = recInpAmt.multiply(new BigDecimal(convXchRt)).setScale(Integer.parseInt(fncCurrScale), BigDecimal.ROUND_HALF_UP);
				
				if("AGENT".equals(tjSrcNm) && ("AGT".equals(chgTpCd) || "AGC".equals(chgTpCd))){
					revAcctAmt = new BigDecimal(searchASARevenueAmount(arOutstandingChgVOs.get(i), "", ""));
				} else {
					revAcctAmt = revInpAmt.multiply(new BigDecimal(convXchRt)).setScale(Integer.parseInt(fncCurrScale), BigDecimal.ROUND_HALF_UP);
				}
				
				for(int j = 0; j < 2; j++){
					if(j == 0){		//Process RECEIVABLE ACCOUNT
						acctClssCd = "REC";
						cmbSeq = recCmbSeq;	
						
						if(recInpAmt.compareTo(new BigDecimal(0)) > 0) {
							inpDrAmt = recInpAmt.toString();
							inpCrAmt = "";
							acctDrAmt = recAcctAmt.toString();
							acctCrAmt = "";
						} else {
							inpDrAmt = "";
							inpCrAmt = recInpAmt.abs().toString();
							acctDrAmt = "";
							acctCrAmt = recAcctAmt.abs().toString();
						}							
					} else {	//Process REVENUE ACCOUNT
						acctClssCd = "REV";
						
						if(revInpAmt.compareTo(new BigDecimal(0)) > 0) {
							inpDrAmt = "";
							inpCrAmt = revInpAmt.toString();
							acctDrAmt = "";
							acctCrAmt = revAcctAmt.toString();
						} else {
							inpDrAmt = revInpAmt.abs().toString();
							inpCrAmt = "";
							acctDrAmt = revAcctAmt.abs().toString();
							acctCrAmt = "";
						}
						
						//Process revenue account in case of not existing clearing account 
						if(clrAcctCd.equals("")) {
							OutstandingAccountCondVO revAccountCondVO = new OutstandingAccountCondVO();
							OutstandingAccountVO revAccountVO = new OutstandingAccountVO();
							LedgerCombinationCondVO revLegrCmbCondVO = new LedgerCombinationCondVO();
														
							//Search account matrix info for REVENUE
							revAccountCondVO.setAcctCtnt1("REV");
							revAccountCondVO.setAcctCtnt2(otsSrcCd);
							revAccountCondVO.setAcctCtnt3(tjSrcNm);
							revAccountCondVO.setAcctCtnt4(revTpSrcCd);
							revAccountCondVO.setAcctTpCd(chgTpCd);
							revAccountCondVO.setGlDt(glDt);
							
							revAccountVO = dbDao.searchOutstandingAccount(revAccountCondVO);
							
							if(revAccountVO == null){
								throw new EventException(new ErrorHandler("SAR00034",new String[]{}).getMessage());
							}
							
							revAcctMtxSeq = revAccountVO.getAcctMtxSeq();
							revArAcctCd = revAccountVO.getArAcctCd();
							revAcctDivCd = revAccountVO.getRevAcctDivCd();
							
							//Search account code from MDM charge
							if(revAcctDivCd.equals("P")){
								revArAcctCd = dbDao.searchMDMChargeForAccount(chgTpCd);
							}	
							
							//Search ledger combination sequence for REVENUE ACCOUNT
							revLegrCmbCondVO.setSgmCtnt1("01");
							revLegrCmbCondVO.setSgmCtnt2(regionCenterVO.getRgnCd());
							revLegrCmbCondVO.setSgmCtnt3(regionCenterVO.getCtrCd());
							revLegrCmbCondVO.setSgmCtnt4(revArAcctCd);
							revLegrCmbCondVO.setSgmCtnt5(subsCoCd);
							revLegrCmbCondVO.setSgmCtnt6(revVvdCd);
							revLegrCmbCondVO.setGlDt(glDt);
							
							revCmbSeq = dbDao.searchLedgerCombination(revLegrCmbCondVO);
							
							if(revCmbSeq == null || revCmbSeq.equals("")){
								//throw new EventException(new ErrorHandler("SAR00035",new String[]{}).getMessage());
								
								dbDao.addLedgerCombination(revLegrCmbCondVO);
								revCmbSeq = dbDao.searchLedgerCombination(revLegrCmbCondVO);
							}
						}
						
						cmbSeq = revCmbSeq;	
					}
					
					//Set distribution info to OutstandingDtrbVO
					OutstandingDtrbVO outstandingDtrbVO = new OutstandingDtrbVO();

					outstandingDtrbVO.setOtsHisSeq(otsHisSeq);
					outstandingDtrbVO.setOtsCdCmbSeq(cmbSeq);
					outstandingDtrbVO.setInpDrAmt(inpDrAmt);
					outstandingDtrbVO.setInpCrAmt(inpCrAmt);
					outstandingDtrbVO.setAcctDrAmt(acctDrAmt);
					outstandingDtrbVO.setAcctCrAmt(acctCrAmt);
					outstandingDtrbVO.setCurrCd(otsCurrCd);
					outstandingDtrbVO.setConvXchRt(convXchRt);
					outstandingDtrbVO.setAcctXchRtDt(glDt);
					outstandingDtrbVO.setShpToCustCntCd(shpToCustCntCd);
					outstandingDtrbVO.setShpToCustSeq(shpToCustSeq);
					outstandingDtrbVO.setBilToCustCntCd(bilToCustCntCd);
					outstandingDtrbVO.setBilToCustSeq(bilToCustSeq);
					outstandingDtrbVO.setGlTrnsSeq("-1");
					outstandingDtrbVO.setCreUsrId(creUsrId);
					outstandingDtrbVO.setUpdUsrId(updUsrId);
					outstandingDtrbVO.setAcctClssCd(acctClssCd);
					outstandingDtrbVO.setChgTpCd(chgTpCd);
					outstandingDtrbVO.setAcctXchRtLvl("1");
					outstandingDtrbVO.setDtrbCnt(Integer.toString(dtrbCnt));
					
					outstandingDtrbVOs.add(outstandingDtrbVO);
					
					dtrbCnt++;
				}
		
				//Create ASA exchange gain/loss account in case of ASA cross currency charge
				if("AGENT".equals(tjSrcNm) && ("AGT".equals(chgTpCd) || "AGC".equals(chgTpCd))){
					createASAExchangeGainLossAccount(outstandingDtrbVOs, fncCurrScale, glDt, revAcctMtxSeq);
				}
				
				//Set account matrix sequence
				arOutstandingChgVOs.get(i).setRecAcctMtxSeq(recAcctMtxSeq);
				arOutstandingChgVOs.get(i).setRevAcctMtxSeq(revAcctMtxSeq);
			}
			
			//Update account matrix sequence to OTS Charge and create distribution info
			dbDao.modifyOTSChargeAcctMtxSeq(arOutstandingChgVOs);
			dbDao.addOutstandingDistribution(outstandingDtrbVOs);
			
			if("AGENT".equals(tjSrcNm)){ 
				copyForASAApproval(arOutstandingHistVOs);
			}
			
			// SAKURA Interface section
			//List<String> otsHisLists = new ArrayList<String>();
					
			//2014.11.26 Interface to SAKURA
			//for(int i = 0; i < arOutstandingHistVOs.size(); i++){
			//	otsHisLists.add(arOutstandingHistVOs.get(i).getOtsHisSeq());
				//sakuraIf.createSakuraOTSIFdata(arOutstandingHistVOs.get(i).getIfNo(),"P");
			//}
			//2015.08.13 VAT 항목 합쳐서 보낸다.  
			//List<AROutstandingHistVO> reFindHistVOs = dbDao.searchReFindSakuraIfNo(otsHisLists);
			//for(int i = 0; i < reFindHistVOs.size(); i++){  
			//	sakuraIf.createSakuraOTSIFdata(reFindHistVOs.get(i).getIfNo(),"P"); 
			//}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Search ASA Revenue Amount<br> 
	 * 
	 * @param AROutstandingChgVO arOutstandingChgVO
	 * @param String funcCurrCd
	 * @param String glDt
	 * @return String
	 * @exception EventException
	 */
	private String searchASARevenueAmount(AROutstandingChgVO arOutstandingChgVO, String funcCurrCd, String glDt) throws EventException{
		
		try {
			
			String blNo = "";
			String otsCurrCd = "";
			String orgCurrCd = "";
			//String convXchRt = "";
			String revAmt = "";
			
			//AccountReceivableCommonDBDAO arComDao = new AccountReceivableCommonDBDAO();
			
			blNo = arOutstandingChgVO.getBlNo();
			otsCurrCd = arOutstandingChgVO.getBlCurrCd();
			orgCurrCd = arOutstandingChgVO.getOrgBlCurrCd();
			
			// Search Account Exchange Rate functional currency to ASA currency
			/*
			if(funcCurrCd.equals(otsCurrCd)){
				convXchRt = "1";
			} else {
				ARExrateVO arExrateVO = new ARExrateVO();
				
				arExrateVO.setXchRtDt(glDt);
				arExrateVO.setLclCurrCd(otsCurrCd);
				arExrateVO.setChgCurrCd(funcCurrCd);
				arExrateVO.setRvsFlg("N");
				
				convXchRt = arComDao.searchAccountExrate(arExrateVO);
			
				if(convXchRt == null || convXchRt.equals("")){
					
					arExrateVO.setRvsFlg("Y");
					
					convXchRt = arComDao.searchAccountExrate(arExrateVO);
					
					if(convXchRt == null || convXchRt.equals("")){
						throw new EventException(new ErrorHandler("SAR00025",new String[]{}).getMessage());
					}
				}
			}
			*/
			
			// Search ASA revenue amount from adjust history info
			revAmt = dbDao.searchASARevenueAmount(blNo, orgCurrCd, glDt, otsCurrCd, funcCurrCd);
			
			return revAmt;
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Create ASA exchange gain/loss account<br> 
	 * 
	 * @param List<OutstandingDtrbVO> outstandingDtrbVOs
	 * @param String fncCurrScale
	 * @param String glDt
	 * @param String revAcctMtxSeq
	 * @exception EventException
	 */
	private void createASAExchangeGainLossAccount(List<OutstandingDtrbVO> outstandingDtrbVOs, String fncCurrScale, String glDt, String revAcctMtxSeq) throws EventException{
		
		try {
			
			int dtrbCnt = 0;
			
			String recCdCmbSeq = "";
			String convXchRt = "";
			String drSumAmt = "";
			String crSumAmt = "";
			String acctClssCd = "";
			String inpDrAmt = "";
			String inpCrAmt = "";
			String acctDrAmt = "";
			String acctCrAmt = "";
			String acctCtnt1 = "";
			String cmbSeq = "";
			
			BigDecimal recInpAmt = null;
			BigDecimal revInpAmt = null;
			BigDecimal exhInpAmt = null;
			BigDecimal exhAcctAmt = null;
			BigDecimal rndAcctAmt = null;
			
			dtrbCnt = outstandingDtrbVOs.size() - 1;
			recCdCmbSeq = outstandingDtrbVOs.get(dtrbCnt - 1).getOtsCdCmbSeq();
			convXchRt = outstandingDtrbVOs.get(dtrbCnt).getConvXchRt();
			
			for(int i = 0; i < 2; i++){
				acctClssCd = "";
				
				if(i == 0){
					acctCtnt1 = "REV";
					
					//Set ASA exchange gain/loss input amount and account amount
					if(!"".equals(outstandingDtrbVOs.get(dtrbCnt - 1).getInpDrAmt())){
						recInpAmt = new BigDecimal(outstandingDtrbVOs.get(dtrbCnt - 1).getInpDrAmt());
						revInpAmt = new BigDecimal(outstandingDtrbVOs.get(dtrbCnt).getInpCrAmt());
						exhInpAmt = recInpAmt.subtract(revInpAmt);
					} else {
						recInpAmt = new BigDecimal(outstandingDtrbVOs.get(dtrbCnt - 1).getInpCrAmt());
						revInpAmt = new BigDecimal(outstandingDtrbVOs.get(dtrbCnt).getInpDrAmt());
						exhInpAmt = revInpAmt.subtract(recInpAmt);
					}
					
					exhAcctAmt = exhInpAmt.multiply(new BigDecimal(convXchRt)).setScale(Integer.parseInt(fncCurrScale), BigDecimal.ROUND_HALF_UP);
					
					if((new BigDecimal(0)).compareTo(exhInpAmt) != 0){
						if(exhInpAmt.compareTo(new BigDecimal(0)) > 0) {
							acctClssCd = "EXCH_GAIN";
							
							inpDrAmt = "";
							inpCrAmt = exhInpAmt.toString();
							acctDrAmt = "";
							acctCrAmt = exhAcctAmt.toString();
						} else {
							acctClssCd = "EXCH_LOSS";
							
							inpDrAmt = exhInpAmt.abs().toString();
							inpCrAmt = "";
							acctDrAmt = exhAcctAmt.abs().toString();
							acctCrAmt = "";
						}	
					}
				} else {
					acctCtnt1 = "SYS";
					
					rndAcctAmt = new BigDecimal(0);
					
					//Set ASA round account amount
					for(int j = dtrbCnt - 1; j < outstandingDtrbVOs.size(); j++){
						drSumAmt = outstandingDtrbVOs.get(j).getAcctDrAmt();
						crSumAmt = outstandingDtrbVOs.get(j).getAcctCrAmt();
						
						if(drSumAmt != null && !"".equals(drSumAmt)) rndAcctAmt = rndAcctAmt.add(new BigDecimal(drSumAmt));
						if(crSumAmt != null && !"".equals(crSumAmt)) rndAcctAmt = rndAcctAmt.subtract(new BigDecimal(crSumAmt));
					}
					
					if((new BigDecimal(0)).compareTo(rndAcctAmt) != 0){
						acctClssCd = "HDR_RND";
						
						if(rndAcctAmt.compareTo(new BigDecimal(0)) > 0) {
							inpDrAmt = "";
							inpCrAmt = "0";
							acctDrAmt = "";
							acctCrAmt = rndAcctAmt.toString();
						} else {
							inpDrAmt = "0";
							inpCrAmt = "";
							acctDrAmt = rndAcctAmt.abs().toString();
							acctCrAmt = "";
						}	
					}
				}
			
				if(!"".equals(acctClssCd)){
					ASAAccountCondVO asaAccountCondVO = new ASAAccountCondVO();
					LedgerCombinationCondVO legrCmbCondVO = new LedgerCombinationCondVO();
					
					//Search COA value for ASA exchange gain/loss, round account
					asaAccountCondVO.setRecCdCmbSeq(recCdCmbSeq);
					asaAccountCondVO.setRevAcctMtxSeq(revAcctMtxSeq);
					asaAccountCondVO.setAcctCtnt1(acctCtnt1);
					asaAccountCondVO.setAcctTpCd(acctClssCd);
					asaAccountCondVO.setGlDt(glDt);
					
					legrCmbCondVO = dbDao.searchASAAccount(asaAccountCondVO);
					
					cmbSeq = dbDao.searchLedgerCombination(legrCmbCondVO);
					
					if(cmbSeq == null || cmbSeq.equals("")){
						//throw new EventException(new ErrorHandler("SAR00035",new String[]{}).getMessage());
						
						dbDao.addLedgerCombination(legrCmbCondVO);
						cmbSeq = dbDao.searchLedgerCombination(legrCmbCondVO);
					}
					
					OutstandingDtrbVO outstandingDtrbVO = new OutstandingDtrbVO();
		
					outstandingDtrbVO.setOtsHisSeq(outstandingDtrbVOs.get(dtrbCnt).getOtsHisSeq());
					outstandingDtrbVO.setOtsCdCmbSeq(cmbSeq);
					outstandingDtrbVO.setInpDrAmt(inpDrAmt);
					outstandingDtrbVO.setInpCrAmt(inpCrAmt);
					outstandingDtrbVO.setAcctDrAmt(acctDrAmt);
					outstandingDtrbVO.setAcctCrAmt(acctCrAmt);
					outstandingDtrbVO.setCurrCd(outstandingDtrbVOs.get(dtrbCnt).getCurrCd());
					outstandingDtrbVO.setConvXchRt(convXchRt);
					outstandingDtrbVO.setAcctXchRtDt(outstandingDtrbVOs.get(dtrbCnt).getAcctXchRtDt());
					outstandingDtrbVO.setShpToCustCntCd(outstandingDtrbVOs.get(dtrbCnt).getShpToCustCntCd());
					outstandingDtrbVO.setShpToCustSeq(outstandingDtrbVOs.get(dtrbCnt).getShpToCustSeq());
					outstandingDtrbVO.setBilToCustCntCd(outstandingDtrbVOs.get(dtrbCnt).getBilToCustCntCd());
					outstandingDtrbVO.setBilToCustSeq(outstandingDtrbVOs.get(dtrbCnt).getBilToCustSeq());
					outstandingDtrbVO.setGlTrnsSeq("-1");
					outstandingDtrbVO.setCreUsrId(outstandingDtrbVOs.get(dtrbCnt).getCreUsrId());
					outstandingDtrbVO.setUpdUsrId(outstandingDtrbVOs.get(dtrbCnt).getUpdUsrId());
					outstandingDtrbVO.setAcctClssCd(acctClssCd);
					outstandingDtrbVO.setChgTpCd(outstandingDtrbVOs.get(dtrbCnt).getChgTpCd());
					outstandingDtrbVO.setAcctXchRtLvl("1");
					
					outstandingDtrbVOs.add(outstandingDtrbVO);
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * copy for Approval<br> 
	 * 
	 * @param List<AROutstandingHistVO> arOutstandingHistVOs
	 * @exception EventException
	 */
	public void copyForASAApproval(List<AROutstandingHistVO> arOutstandingHistVOs) throws EventException{
		try {
			String otsHisSeq = "";
			for(int i = 0; i < arOutstandingHistVOs.size(); i++){
				otsHisSeq = arOutstandingHistVOs.get(i).getOtsHisSeq();
				OutstandingDtrbVO outstandingDtrbVO = new OutstandingDtrbVO();
				outstandingDtrbVO.setOtsHisSeq(otsHisSeq);
				dbDao.modifyOtsDtrbForASAApproval(outstandingDtrbVO);
			}
			
			for(int i = 0; i < arOutstandingHistVOs.size(); i++){
				otsHisSeq = arOutstandingHistVOs.get(i).getOtsHisSeq();
				OutstandingDtrbVO outstandingDtrbVO = new OutstandingDtrbVO();
				outstandingDtrbVO.setOtsHisSeq(otsHisSeq);
				outstandingDtrbVO.setAcctClssCd("REC");
				
				//Search For REV
				List<OutstandingDtrbVO> outstandingDtrbVOs = dbDao.searchOtsDtrbREVASA(outstandingDtrbVO);
				dbDao.modifyOtsDtrbREVASAApproval(outstandingDtrbVOs); 
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

}