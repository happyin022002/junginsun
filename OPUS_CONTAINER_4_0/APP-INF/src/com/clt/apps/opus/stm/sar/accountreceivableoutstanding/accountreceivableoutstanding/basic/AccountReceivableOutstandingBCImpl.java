/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : AccountReceivableOutstandingBCImpl.java
 *@FileTitle : 
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
package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.basic;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.python.modules.newmodule;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvArIfNoVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.basic.AccountReceivableAgentBCImpl;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.BatHisVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.basic.AccountReceivableCommonBC;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.basic.AccountReceivableCommonBCImpl;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration.AccountReceivableCommonDBDAO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.ARExrateVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.CurrencyCodeVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration.AccountReceivableOutstandingDBDAO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration.AccountReceivableOutstandingEAIDAO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.AROustandingbySADateVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.AROutstandingCheckVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.AROutstandingChgVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.AROutstandingDtlVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.AROutstandingHdrVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.AROutstandingHistVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.ASAAccountCondVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.ApplyOutstandingCondVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.ApplyOutstandingListVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.LedgerCombinationCondVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OTSAgingBaseVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OTSAgingBucketVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OTSAgingListVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OTSAgingPKVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OTSViewAccountingListVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OutstandingAccountCondVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OutstandingAccountVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OutstandingDtlByBlVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OutstandingDtrbVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OutstandingHdrByBlVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OutstandingHisByDateVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OutstandingInterfaceVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OutstandingSumByBlVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.PaymentRequestLetterByEmailFaxVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.PaymentRequestLetterHisVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.PaymentRequestLetterSumVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.PaymentRequestLetterVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.RegionCenterVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.SarOtsRctTmpVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstandingif.basic.AccountReceivableOutstandingIFBC;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstandingif.basic.AccountReceivableOutstandingIFBCImpl;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration.StatementCommonDBDAO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.LookupInfoVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SarOtsHdrVO;
import com.clt.syscommon.common.util.ScheduleUtil;

/**
 * AccountReceivableOutstandingBCImpl Business Logic ServiceCommand - Handling
 * AccountReceivableOutstandingBCImpl Business transaction.
 * 
 * @author
 * @see AccountReceivableOutstandingDBDAO
 * @see AccountReceivableOutstandingEAIDAO
 * @since J2EE 1.6
 */
public class AccountReceivableOutstandingBCImpl extends BasicCommandSupport implements AccountReceivableOutstandingBC {	

	// Database Access Object
	private transient AccountReceivableOutstandingDBDAO dbDao = null;
	private transient AccountReceivableOutstandingEAIDAO eaiDao = null;
	
	/**
	 * AccountReceivableOutstandingBCImpl object creation.<br>
	 * AccountReceivableOutstandingDBDAO creation.<br>
	 */
	public AccountReceivableOutstandingBCImpl() {
		
		dbDao = new AccountReceivableOutstandingDBDAO();
		eaiDao = new AccountReceivableOutstandingEAIDAO();
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
					
					//Add 2016.08.01
					String bkgStlFlg = arOutstandingHdrVO.getBkgStlFlg();
					
					hdrUpdFlg = "Y";
					
					//Check to update Outstanding Header by revenue type - 2015.03.02
					if(otsRevTypeCd != null && !"".equals(otsRevTypeCd)){
						if(((otsRevTypeCd.substring(0,1).equals("B") || otsRevTypeCd.substring(0,1).equals("C")) && newRevTypeCd.substring(0,1).equals("M") && ("N").equals(bkgStlFlg)) ||
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
					
					//2015.11.30 modify OBL Issue Office
					dbDao.modifyOBLIssueOffice(arOutstandingHdrVO);
					
					//2015.04.01 modify BKG OTS
					dbDao.modifyBKGOutstanding(arOutstandingHdrVO);
					
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
						dbDao.modifyBKGOutstanding(arOutstandingHdrVO);
						
						//2015.03.11 Interface to SAKURA in case of invoice issue (OTS SMRY is INV)
						/*for(int o = 0; o < arOutstandingHistVOs.size(); o++){
							sakuraIf.createSakuraOTSIFdata(arOutstandingHistVOs.get(o).getIfNo(),"P");
						}*/
					} else {
						// 2014.08.18 add search OTS history sequence
						for(int m = 0; m < arOutstandingHistVOs.size(); m++){
							
							if(dbDao.checkOutstandingHist(arOutstandingHistVOs.get(m).getIfNo())) {
								throw new EventException(new ErrorHandler("COM12226", new String[]{"OTS B/L No : "+arOutstandingHistVOs.get(m).getBlNo()}).getMessage());
							}
							
							otsHisSeq = dbDao.searchOutstandingHistSeq();
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
			
			BigDecimal recInpAmt = null;
			BigDecimal revInpAmt = null;
			BigDecimal recAcctAmt = null;
			BigDecimal revAcctAmt = null;
			
			AccountReceivableOutstandingIFBC sakuraIf = new AccountReceivableOutstandingIFBCImpl();
			AccountReceivableCommonDBDAO arComDao = new AccountReceivableCommonDBDAO();
			StatementCommonDBDAO stmComDao = new StatementCommonDBDAO();
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
			lookupInfoVOs = stmComDao.searchLookupList("FUNCTIONAL CURRENCY");
			funcCurrCd = lookupInfoVOs.get(0).getLuCd();
			currencyCodeVOs = arComDao.searchCurrencyCode(funcCurrCd);
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
					
					convXchRt = arComDao.searchAccountExrate(arExrateVO);
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
					
					outstandingDtrbVOs.add(outstandingDtrbVO);
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
			
			List<String> otsHisLists = new ArrayList<String>();
					
			//2014.11.26 Interface to SAKURA
			for(int i = 0; i < arOutstandingHistVOs.size(); i++){
				otsHisLists.add(arOutstandingHistVOs.get(i).getOtsHisSeq());
				//sakuraIf.createSakuraOTSIFdata(arOutstandingHistVOs.get(i).getIfNo(),"P");
			}
			//2015.08.13 VAT 항목 합쳐서 보낸다.  
			List<AROutstandingHistVO> reFindHistVOs = dbDao.searchReFindSakuraIfNo(otsHisLists);
			for(int i = 0; i < reFindHistVOs.size(); i++){  
				sakuraIf.createSakuraOTSIFdata(reFindHistVOs.get(i).getIfNo(),"P"); 
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
	 * Search OTS for Apply List<br> 
	 * 
	 * @param ApplyOutstandingCondVO applyOutstandingCondVO
	 * @param SarOtsRctTmpVO[] sarOtsRctTmpVOs
	 * @param String usrId
	 * @return List<ApplyOutstandingListVO>
	 * @exception EventException
	 */
	public List<ApplyOutstandingListVO> searchApplyOutstandingList(ApplyOutstandingCondVO applyOutstandingCondVO, SarOtsRctTmpVO[] sarOtsRctTmpVOs, String usrId) throws EventException{
		
		try {
			
			List<SarOtsRctTmpVO> addVoList = new ArrayList<SarOtsRctTmpVO>();
			
			if (sarOtsRctTmpVOs != null ) {
				for (int i=0; i<sarOtsRctTmpVOs.length; i++) {		
					sarOtsRctTmpVOs[i].setOtsRctTmpSeq(applyOutstandingCondVO.getOtsRctTmpSeq());
					sarOtsRctTmpVOs[i].setCreUsrId(usrId);
					sarOtsRctTmpVOs[i].setUpdUsrId(usrId);
					
					addVoList.add(sarOtsRctTmpVOs[i]);
				}
			}
			
			if (addVoList.size() > 0) {
				dbDao.addOutstandingReceiptTemp(addVoList);
			}
			
			List<ApplyOutstandingListVO> list = dbDao.searchApplyOutstandingList(applyOutstandingCondVO);
			
			if (addVoList.size() > 0) {
				dbDao.removeOutstandingReceiptTemp(applyOutstandingCondVO.getOtsRctTmpSeq());
			}
			
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
     * Outstanding Inquiry<br>
     * 
     * @author YJLEE
     * @category STM_SAR_1002
     * @category searchOustandingByDate
     * @param AROustandingbySADateVO aROustandingbySADateVO      
     * @return List<AROustandingbySADateVO>
     * @throws EventException
     */    
    public List<AROustandingbySADateVO> searchOustandingByDate(AROustandingbySADateVO aROustandingbySADateVO) throws EventException {
    	try {
    		 List<AROustandingbySADateVO> returnList = dbDao.searchOustandingByDate(aROustandingbySADateVO);
   		
    		 if(returnList != null && returnList.size() > 0) {
    			 returnList.get(0).setMaxRows(Integer.parseInt(returnList.get(0).getTotalCnt()));
    			 log.error("STM_SAR_1002 Total Row Count " + Integer.parseInt(returnList.get(0).getTotalCnt()));
    		 }
    		 
    		 return returnList;    		
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		}
    }
    
    /**
     * Payment Request Letter<br>
     * 
     * @author YJLEE
     * @category STM_SAR_1005
     * @category searchPaymentRequestLetter
     * @param PaymentRequestLetterVO paymentRequestLetterVO       
     * @return List<PaymentRequestLetterVO>
     * @throws EventException
     */    
    public List<PaymentRequestLetterVO> searchPaymentRequestLetter(PaymentRequestLetterVO paymentRequestLetterVO) throws EventException {
    	try {
    		 List<PaymentRequestLetterVO> returnList = dbDao.searchPaymentRequestLetter(paymentRequestLetterVO);
   		
    		 return returnList;    		
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		}
    }
    
    /**
     * Payment Request Letter Sum<br>
     * 
     * @author YJLEE
     * @category STM_SAR_1005
     * @category searchPaymentRequestLetter
     * @param PaymentRequestLetterVO paymentRequestLetterVO       
     * @return List<PaymentRequestLetterSumVO>
     * @throws EventException
     */    
    public List<PaymentRequestLetterSumVO> searchPaymentRequestLetterSum(PaymentRequestLetterVO paymentRequestLetterVO) throws EventException {
    	try {
    		List<PaymentRequestLetterSumVO> returnList = dbDao.searchPaymentRequestLetterSum(paymentRequestLetterVO);
    		return returnList;     	 	
    	} catch (DAOException e) { 
    		log.error("err " + e.toString(), e);
    		throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
    	}
    }
    
    /**
     * Payment Request Letter<br>
     * 
     * @author YJLEE
     * @category STM_SAR_1005
     * @category searchEmailSeq
     * @param PaymentRequestLetterVO paymentRequestLetterVO       
     * @return String
     * @throws EventException
     */    
    public String searchEmailSeq(PaymentRequestLetterVO paymentRequestLetterVO) throws EventException {
    	try {
    		String arEmlSeq = dbDao.searchPaymentRequestLetterSeq();
   		
    		 return arEmlSeq;    		
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		}
    }
    
    /**
     * Payment Request Letter customer Email Fax<br>
     * 
     * @author YJLEE
     * @category STM_SAR_1005
     * @category searchEmailFax
     * @param PaymentRequestLetterVO paymentRequestLetterVO       
     * @return List<PaymentRequestLetterVO>
     * @throws EventException
     */    
    public List<PaymentRequestLetterVO> searchEmailFax(PaymentRequestLetterVO paymentRequestLetterVO) throws EventException {
    	try {
    		List<PaymentRequestLetterVO> returnList = dbDao.searchPaymentRequestLetterEmailFax(paymentRequestLetterVO);
       		return returnList;   
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		}
    }
    
    /**
     * Outstanding Inquiry by B/L(Invoice) Header
     * @author jinyoonoh 2014. 4. 22.
     * @param OutstandingHdrByBlVO outstandingHdrByBlVO
     * @return List<OutstandingHdrByBlVO>
     * @throws EventException
     */
    public List<OutstandingHdrByBlVO> searchOutstandingHdrByBl(OutstandingHdrByBlVO outstandingHdrByBlVO) throws EventException {
		try {
			
			List<OutstandingHdrByBlVO> list = dbDao.searchOutstandingHdrByBl(outstandingHdrByBlVO);
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
     * Outstanding Inquiry by B/L(Invoice) Detail
     * @author jinyoonoh 2014. 4. 22.
     * @param OutstandingDtlByBlVO outstandingDtlByBlVO
     * @return List<OutstandingDtlByBlVO>
     * @throws EventException
     */
    public List<OutstandingDtlByBlVO> searchOutstandingDtlByBl(OutstandingDtlByBlVO outstandingDtlByBlVO) throws EventException {
		try {
			
			List<OutstandingDtlByBlVO> list = dbDao.searchOutstandingDtlByBl(outstandingDtlByBlVO);
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
     * Outstanding Inquiry by B/L(Invoice) Summary
     * @author jinyoonoh 2014. 4. 22.
     * @param OutstandingSumByBlVO outstandingSumByBlVO
     * @return List<OutstandingSumByBlVO>
     * @throws EventException
     */
    public List<OutstandingSumByBlVO> searchOutstandingSumByBl(OutstandingSumByBlVO outstandingSumByBlVO) throws EventException {
		try {
			
			List<OutstandingSumByBlVO> list = dbDao.searchOutstandingSumByBl(outstandingSumByBlVO);
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
     * Outstanding Inquiry by B/L(Invoice) History
     * @author jinyoonoh 2014. 4. 22.
     * @param OutstandingHisByDateVO outstandingHisByDateVO
     * @return List<OutstandingHisByDateVO>
     * @throws EventException
     */
    public List<OutstandingHisByDateVO> searchOutstandingHisByDate(OutstandingHisByDateVO outstandingHisByDateVO) throws EventException {
		try {
			
			List<OutstandingHisByDateVO> list = dbDao.searchOutstandingHisByDate(outstandingHisByDateVO);
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
     * Search outstanding aging inquiry
     *   
     * @author jinyoonoh 2014. 5. 21.
     * @param OTSAgingBaseVO paramVO
     * @return List<OTSAgingListVO>
     * @throws EventException
     */
    public List<OTSAgingListVO> searchOTSAgingList(OTSAgingBaseVO paramVO) throws EventException {
		try {
			
			// key -> clt_ofc_cd
			Map<String, Map<String, String>> retMap = new LinkedHashMap<String, Map<String,String>>();
			
			// init ret value
			//String  cltOfcCd = paramVO.getCltOfcCd(); // search condition sql in clause
			
			
			{
		    	// search aging  pk
		    	List<OTSAgingPKVO> list = dbDao.searchOTSAgingPK(paramVO);
		    	    	
		    	for (OTSAgingPKVO vo: list) {
		    		Map<String, String> map = new HashMap<String, String>();    
		    		// set default number
		    		for(int j = 1; j <= 81; j++) {
		    			map.put(StringUtils.leftPad(j+"", 2 , "0"), "0");
		    		}
		    		
		    		map.put("clt_ofc_cd", vo.getCltOfcCd());
		    		map.put("cust_num", vo.getCustNum());
		    		map.put("cust_nm", vo.getCustNm());
		    		map.put("rhq_cd", vo.getArHdQtrOfcCd());
		    		
		        	retMap.put(vo.getPrimaryKey(), map);
				}
			}			
			
			
			
//            O/B  |  NoEx.RateCNT   |  CNT |  BadOTS |         | CNT | Below30D | CNT | Below120D
//            -------------------------------------------------------------------------------------------
//            I/B  |  NotArrived     |  CNT | W/ITerm |TTLL/TOTS| CNT | Below60D | CNT | Below180D
//            -------------------------------------------------------------------------------------------
//            TTL  |  NotArrivedCNT  |  CNT | TTLOTS  |L/TCNT   | CNT | Below90D | CNT | over180D
//            -------------------------------------------------------------------------------------------
//            1    |  2              |3     |    4    |  5      |  6  |  7       |  8  | 9                    O/B
//            -------------------------------------------------------------------------------------------
//            10   | 11              |12    |   13    | 14      | 15  | 16       | 17  | 18                   O/B
//            -------------------------------------------------------------------------------------------
//            19   | 20              |21    |   22    | 23      | 24  | 25       | 26  | 27                   O/B     
//            -------------------------------------------------------------------------------------------
//            28   | 29              |30    |   31    | 32      | 33  | 34       | 35  | 36                   I/B
//            -------------------------------------------------------------------------------------------
//            37   | 38              |39    |   40    | 41      | 42  | 43       | 44  | 45                   I/B
//            -------------------------------------------------------------------------------------------
//            46   | 47              |48    |   49    | 50      | 51  | 52       | 53  | 54                   I/B
//            -------------------------------------------------------------------------------------------
//            55   | 56              |57    |   58    | 59      | 60  | 61       | 62  | 63                   TTL
//            -------------------------------------------------------------------------------------------
//            64   | 65              |66    |   67    | 68      | 69  | 70       | 71  | 72                   TTL
//            -------------------------------------------------------------------------------------------
//            73   | 74              |75    |   76    | 77      | 78  | 79       | 80  | 81                   TTL 
//            -------------------------------------------------------------------------------------------

			//USD , LCL amount Display
			String blCurrCd = paramVO.getBlCurrCd();

			OTSAgingBaseVO baseVO = new OTSAgingBaseVO();
			// Base search condition
			baseVO.setBlCurrCd(paramVO.getBlCurrCd()); //OFFICE CURRENCY CODE
			baseVO.setOtsSrcCd(paramVO.getOtsSrcCd()); //OUTSTANDING SOURCE CODE('src1' ,'src2' ....) SQL in clause
			baseVO.setSumTp(paramVO.getSumTp()); // Summary Type (each of office, customer, all)
			baseVO.setBlSumTp(paramVO.getBlSumTp()); // BL summary type [OTS , OPY(over pay)]
			baseVO.setBlInvTp(paramVO.getBlInvTp()); // is Invoice ? (invoice: INV)
			baseVO.setCrMkFlg(paramVO.getCrMkFlg()); //CREDIT MARK FLAG
			baseVO.setCltOfcCd(paramVO.getCltOfcCd()); //COLLECTION OFFICE CODE('offcd1' ,'offcd2', ....) SQL in clause
			baseVO.setBilToCustCntCd(paramVO.getBilToCustCntCd()); // Customer Country
			baseVO.setBilToCustSeq(paramVO.getBilToCustSeq()); // Customer Sequence
			baseVO.setSumOfcCustTp(paramVO.getSumOfcCustTp());// Customer, office 
			// -------------------------------------------------------
			// Aging Base : No Ex. Rate CNT
			// -------------------------------------------------------
			{	
				baseVO.setDueDt(""); //DUE DATE
				baseVO.setSailArrDt("");//SAILING ARRIVAL DATE
				baseVO.setStlFlg("N"); //SETTLEMENT FLAG				
				baseVO.setOtsGrpTpCd(""); //OUTSTANDING GROUP TYPE CODE - bad OTS(01)				
				baseVO.setOtsRtFlg("N"); //OUTSTANDING RATE FLAG [N: No Ex. Rate]
				log.debug(">>>>>>>>>>> No Ex. Rate CNT START");
				List<OTSAgingBaseVO> agingCntList = dbDao.searchOTSAgingBaseCntList(baseVO);
				log.debug(">>>>>>>>>>> No Ex. Rate CNT END");
				for (OTSAgingBaseVO vo : agingCntList) {
				
					Map<String, String> map = retMap.get(vo.getPrimaryKey());
					
					if (map == null) {
						continue;
					}
					
					map.put("01", "O/B");// O/B title
					map.put("10", "O/B");// O/B title
					map.put("19", "O/B");// O/B title
					
					map.put("28", "I/B");// I/B title
					map.put("37", "I/B");// I/B title
					map.put("46", "I/B");// I/B title
					
					map.put("55", "TTL");// TTL title
					map.put("64", "TTL");// TTL title
					map.put("73", "TTL");// TTL title
					
					map.put("02", vo.getObCnt());// O/B Not Ex. Rate CNT
					map.put("29", vo.getIbCnt());// I/B Not Ex. Rate CNT					
					map.put("56", vo.getTotCnt());// TTL Not Ex. Rate CNT
					
				}
			}
			
			// -------------------------------------------------------
			// Aging Base : Not Arrived, Not Arrived CNT
			// -------------------------------------------------------
			{
				baseVO.setDueDt(""); //DUE DATE
				baseVO.setSailArrDt(paramVO.getDueDt());//SAILING ARRIVAL DATE
				baseVO.setStlFlg("N"); //SETTLEMENT FLAG				
				baseVO.setOtsGrpTpCd(""); //OUTSTANDING GROUP TYPE CODE - bad OTS(01)				
				baseVO.setOtsRtFlg("Y"); //OUTSTANDING RATE FLAG [N: No Ex. Rate]
				 
				List<OTSAgingBaseVO> agingAmtList = dbDao.searchOTSAgingBaseAmtList(baseVO);
				
				List<OTSAgingBaseVO> agingCntList = dbDao.searchOTSAgingBaseCntList(baseVO);
				
				for (OTSAgingBaseVO vo : agingAmtList) {
					
					Map<String, String> map = retMap.get(vo.getPrimaryKey());

					if (map == null) {
						continue;
					}
					
					
					if ("USD".equals(blCurrCd)) {
						map.put("11", vo.getObBalUsdAmt());// O/B Not Arrived Amount
						map.put("38", vo.getIbBalUsdAmt());// I/B Not Arrived Amount						
						map.put("65", vo.getBalUsdAmt());// TTL Not Arrived Amount						
					} else {
						map.put("11", vo.getObBalLoclAmt());// O/B Not Arrived Amount
						map.put("38", vo.getIbBalLoclAmt());// I/B Not Arrived Amount						
						map.put("65", vo.getBalLoclAmt());// TTL Not Arrived Amount						
					}					
					
					for (OTSAgingBaseVO cntVO : agingCntList) {
						if (cntVO.getPrimaryKey().equals(vo.getPrimaryKey())) {
							map.put("20", cntVO.getObCnt());// O/B Not Arrived CNT
							map.put("47", cntVO.getIbCnt());// I/B Not Arrived CNT					
							map.put("74", cntVO.getTotCnt());// TTL Not Arrived CNT
							break;
						}						
					}
										
			

				}
			}			
			
			// -------------------------------------------------------
			// Aging Base : Bad OTS Amount, Cnt
			// -------------------------------------------------------
			{
				baseVO.setDueDt(paramVO.getDueDt()); //DUE DATE
				baseVO.setDueTp("BAD_OTS");
				baseVO.setSailArrDt("");//SAILING ARRIVAL DATE
				baseVO.setStlFlg("N"); //SETTLEMENT FLAG				
				baseVO.setOtsGrpTpCd("01"); //OUTSTANDING GROUP TYPE CODE - bad OTS(01)				
				baseVO.setOtsRtFlg(""); //OUTSTANDING RATE FLAG [N: No Ex. Rate]
				log.debug(">>>> BAD_OTS START "); 
				List<OTSAgingBaseVO> agingAmtList = dbDao.searchOTSAgingBaseAmtList(baseVO);
				
				List<OTSAgingBaseVO> agingCntList = dbDao.searchOTSAgingBaseCntList(baseVO);
				log.debug(">>>> BAD_OTS END "); 
				for (OTSAgingBaseVO vo : agingAmtList) {
					
					Map<String, String> map = retMap.get(vo.getPrimaryKey());
					
					if (map == null) {
						continue;
					}					
					
					if ("USD".equals(blCurrCd)) {
						map.put("04", vo.getObBalUsdAmt());// O/B Bad OTS Amount
						map.put("31", vo.getIbBalUsdAmt());// I/B Bad OTS Amount						
						map.put("58", vo.getBalUsdAmt());// TTL Bad OTS Amount						
					} else {
						map.put("04", vo.getObBalLoclAmt());// O/B Bad OTS Amount
						map.put("31", vo.getIbBalLoclAmt());// I/B Bad OTS Amount						
						map.put("58", vo.getBalLoclAmt());// TTL Bad OTS Amount						
					}
										
					for (OTSAgingBaseVO cntVO : agingCntList) {
						if (cntVO.getPrimaryKey().equals(vo.getPrimaryKey())) {
							map.put("03", cntVO.getObCnt());// O/B Bad OTS CNT
							map.put("30", cntVO.getIbCnt());// I/B Bad OTS CNT					
							map.put("57", cntVO.getTotCnt());// TTL Bad OTS CNT 
							break;
						}						
					}					
						
				}
			}			
			
			// -------------------------------------------------------
			// Aging Base : W/ITerm Amount, Cnt
			// -------------------------------------------------------
			{
				baseVO.setDueDt(paramVO.getDueDt()); //DUE DATE
				baseVO.setDueTp("WI_TERM_OTS");
				baseVO.setSailArrDt("");//SAILING ARRIVAL DATE
				baseVO.setStlFlg("N"); //SETTLEMENT FLAG				
				baseVO.setOtsGrpTpCd(""); //OUTSTANDING GROUP TYPE CODE - bad OTS(01)				
				baseVO.setOtsRtFlg("Y"); //OUTSTANDING RATE FLAG [N: No Ex. Rate]
				log.debug(">>>>>>>>>>>>>>>> WI_TERM_OTS START"); 
				List<OTSAgingBaseVO> agingAmtList = dbDao.searchOTSAgingBaseAmtList(baseVO);
				
				//List<OTSAgingBaseVO> agingCntList = dbDao.searchOTSAgingBaseCntList(baseVO);
				log.debug(">>>>>>>>>>>>>>>> WI_TERM_OTS END"); 
				for (OTSAgingBaseVO vo : agingAmtList) {					
					
					Map<String, String> map = retMap.get(vo.getPrimaryKey());
					
					if (map == null) {
						continue;
					}
					
					if ("USD".equals(blCurrCd)) {
						map.put("13", vo.getObBalUsdAmt());// O/B W/ITerm Amount
						map.put("40", vo.getIbBalUsdAmt());// I/B W/ITerm Amount						
						map.put("67", vo.getBalUsdAmt());// TTL W/ITerm Amount						
					} else {
						map.put("13", vo.getObBalLoclAmt());// O/B W/ITerm Amount
						map.put("40", vo.getIbBalLoclAmt());// I/B W/ITerm Amount						
						map.put("67", vo.getBalLoclAmt());// TTL W/ITerm Amount						
					}
					
					map.put("12", vo.getObCnt());// O/B W/ITerm CNT
					map.put("39", vo.getIbCnt());// I/B W/ITerm CNT					
					map.put("66", vo.getTotCnt());// TTL W/ITerm CNT
					
				}
			}			
						
			// -------------------------------------------------------
			// Aging Bucket list 
			// -------------------------------------------------------
			{
				
				OTSAgingBucketVO bucketVO = new OTSAgingBucketVO();
				// Base search condition
				bucketVO.setBlCurrCd(paramVO.getBlCurrCd()); //OFFICE CURRENCY CODE
				bucketVO.setOtsSrcCd(paramVO.getOtsSrcCd()); //OUTSTANDING SOURCE CODE('src1' ,'src2' ....) SQL in clause
				bucketVO.setSumTp(paramVO.getSumTp()); // Summary Type (each of office, customer, all)
				bucketVO.setBlSumTp(paramVO.getBlSumTp()); // BL summary type [OTS , OPY(over pay)]
				bucketVO.setBlInvTp(paramVO.getBlInvTp()); // is Invoice ? (invoice: INV)
				bucketVO.setCrMkFlg(paramVO.getCrMkFlg()); //CREDIT MARK FLAG
				bucketVO.setCltOfcCd(paramVO.getCltOfcCd()); //COLLECTION OFFICE CODE('offcd1' ,'offcd2', ....) SQL in clause
				bucketVO.setSumOfcCustTp(paramVO.getSumOfcCustTp());// Customer, office
				
				bucketVO.setDueDt(paramVO.getDueDt()); //DUE DATE				
				bucketVO.setSailArrDt("");//SAILING ARRIVAL DATE
				bucketVO.setStlFlg("N"); //SETTLEMENT FLAG				
				bucketVO.setOtsGrpTpCd(""); //OUTSTANDING GROUP TYPE CODE - bad OTS(01)				
				bucketVO.setOtsRtFlg("Y"); //OUTSTANDING RATE FLAG [N: No Ex. Rate]
				bucketVO.setBk1(paramVO.getBk1());
				bucketVO.setBk2(paramVO.getBk2());
				bucketVO.setBk3(paramVO.getBk3());
				bucketVO.setBk4(paramVO.getBk4());
				bucketVO.setBk5(paramVO.getBk5());
				bucketVO.setBk6(paramVO.getBk6());
				bucketVO.setRhq(paramVO.getRhq());
				
				bucketVO.setBilToCustCntCd(paramVO.getBilToCustCntCd());
				bucketVO.setBilToCustSeq(paramVO.getBilToCustSeq());
				
				 
				List<OTSAgingBucketVO> bucketList = dbDao.searchOTSAgingBucketList(bucketVO);
				
				for (OTSAgingBucketVO vo : bucketList) {					
					
					Map<String, String> map = retMap.get(vo.getPrimaryKey());
					
					if (map == null) {
						continue;
					}
					
					if ("USD".equals(blCurrCd)) {
						map.put("07", vo.getObBk1BalUsdAmt());// O/B BK1 30
						map.put("34", vo.getIbBk1BalUsdAmt());// I/B BK1 30						
						map.put("61", vo.getTotBk1BalUsdAmt());// TTL BK1 30
						
						map.put("16", vo.getObBk2BalUsdAmt());// O/B BK2 60
						map.put("43", vo.getIbBk2BalUsdAmt());// I/B BK2 60						
						map.put("70", vo.getTotBk2BalUsdAmt());// TTL BK2 60
						
						map.put("25", vo.getObBk3BalUsdAmt());// O/B BK3 90
						map.put("52", vo.getIbBk3BalUsdAmt());// I/B BK3 90						
						map.put("79", vo.getTotBk3BalUsdAmt());// TTL BK3 90
						
						map.put("09", vo.getObBk4BalUsdAmt());// O/B BK4 120
						map.put("36", vo.getIbBk4BalUsdAmt());// I/B BK4 120						
						map.put("63", vo.getTotBk4BalUsdAmt());// TTL BK4 120
						
						map.put("18", vo.getObBk5BalUsdAmt());// O/B BK5 180
						map.put("45", vo.getIbBk5BalUsdAmt());// I/B BK5 180						
						map.put("72", vo.getTotBk5BalUsdAmt());// TTL BK5 180
						
						map.put("27", vo.getObBk6BalUsdAmt());// O/B BK5 over 180
						map.put("54", vo.getIbBk6BalUsdAmt());// I/B BK5 over 180						
						map.put("81", vo.getTotBk6BalUsdAmt());// TTL BK5 over180
					} else {
						map.put("07", vo.getObBk1BalLoclAmt());// O/B BK1 30
						map.put("34", vo.getIbBk1BalLoclAmt());// I/B BK1 30						
						map.put("61", vo.getTotBk1BalLoclAmt());// TTL BK1 30
						
						map.put("16", vo.getObBk2BalLoclAmt());// O/B BK2 60
						map.put("43", vo.getIbBk2BalLoclAmt());// I/B BK2 60						
						map.put("70", vo.getTotBk2BalLoclAmt());// TTL BK2 60
						
						map.put("25", vo.getObBk3BalLoclAmt());// O/B BK3 90
						map.put("52", vo.getIbBk3BalLoclAmt());// I/B BK3 90						
						map.put("79", vo.getTotBk3BalLoclAmt());// TTL BK3 90
						
						map.put("09", vo.getObBk4BalLoclAmt());// O/B BK4 120
						map.put("36", vo.getIbBk4BalLoclAmt());// I/B BK4 120						
						map.put("63", vo.getTotBk4BalLoclAmt());// TTL BK4 120
						
						map.put("18", vo.getObBk5BalLoclAmt());// O/B BK5 180
						map.put("45", vo.getIbBk5BalLoclAmt());// I/B BK5 180						
						map.put("72", vo.getTotBk5BalLoclAmt());// TTL BK5 180
						
						map.put("27", vo.getObBk6BalLoclAmt());// O/B BK5 over 180
						map.put("54", vo.getIbBk6BalLoclAmt());// I/B BK5 over 180						
						map.put("81", vo.getTotBk6BalLoclAmt());// TTL BK5 over180				
					}
					
					map.put("06", vo.getObBk1Cnt());// O/B BK1 30
					map.put("33", vo.getIbBk1Cnt());// I/B BK1 30						
					map.put("60", vo.getTotBk1Cnt());// TTL BK1 30
					
					map.put("15", vo.getObBk2Cnt());// O/B BK2 60
					map.put("42", vo.getIbBk2Cnt());// I/B BK2 60						
					map.put("69", vo.getTotBk2Cnt());// TTL BK2 60
					
					map.put("24", vo.getObBk3Cnt());// O/B BK3 90
					map.put("51", vo.getIbBk3Cnt());// I/B BK3 90						
					map.put("78", vo.getTotBk3Cnt());// TTL BK3 90
					
					map.put("08", vo.getObBk4Cnt());// O/B BK4 120
					map.put("35", vo.getIbBk4Cnt());// I/B BK4 120						
					map.put("62", vo.getTotBk4Cnt());// TTL BK4 120
					
					map.put("17", vo.getObBk5Cnt());// O/B BK5 180
					map.put("44", vo.getIbBk5Cnt());// I/B BK5 180						
					map.put("71", vo.getTotBk5Cnt());// TTL BK5 180
					
					map.put("26", vo.getObBk6Cnt());// O/B BK5 over 180
					map.put("53", vo.getIbBk6Cnt());// I/B BK5 over 180						
					map.put("80", vo.getTotBk6Cnt());// TTL BK5 over180
					
				}
				
			}						
			
			// -------------------------------------------------------
			// TTL L/T OTS (14,41,68), TTL L/T CNT (23,50,77)   
			// below30 + below60 + below90 + below120 + below1800 + over below180	
			// TTL OTS(22,49,76) , TTL CNT(21, 48, 75)
			// BAD OTS + WI TERM + TTL L/T OTS (14,41,68) 
			// -------------------------------------------------------			
			for (String key : retMap.keySet()) {	
				// ----------------------------------
				// set TTL L/T OTS (14,41,68)
				// ----------------------------------
				Map<String, String> map = retMap.get(key);
				// O/B 07 + 16 + 25 + 9 + 18 + 27
				BigDecimal ob14 = new BigDecimal(map.get("07"))
				                    .add(new BigDecimal(map.get("16")))
				                    .add(new BigDecimal(map.get("25")))
				                    .add(new BigDecimal(map.get("09")))
				                    .add(new BigDecimal(map.get("18")))
				                    .add(new BigDecimal(map.get("27")))				                    
				                    ;
				map.put("14", ob14.toPlainString());
				
				// I/B 34 + 43 + 52 + 36 + 45 + 54
				BigDecimal ib41 = new BigDecimal(map.get("34"))
				                    .add(new BigDecimal(map.get("43")))
				                    .add(new BigDecimal(map.get("52")))
				                    .add(new BigDecimal(map.get("36")))
				                    .add(new BigDecimal(map.get("45")))
				                    .add(new BigDecimal(map.get("54")))				                    
				                    ;
				map.put("41", ib41.toPlainString());
				
				// tot 
				BigDecimal tt68 = ob14.add(ib41);
				map.put("68", tt68.toPlainString());
				
				
				// ----------------------------------
				// set TTL TTL L/T CNT (23,50,77)  
				// ----------------------------------
				
				// O/B 07 + 16 + 25 + 9 + 18 + 27
				BigDecimal ob23 = new BigDecimal(map.get("06"))
				                    .add(new BigDecimal(map.get("15")))
				                    .add(new BigDecimal(map.get("24")))
				                    .add(new BigDecimal(map.get("08")))
				                    .add(new BigDecimal(map.get("17")))
				                    .add(new BigDecimal(map.get("26")))				                    
				                    ;
				map.put("23", ob23.toPlainString());
				
				// I/B 34 + 43 + 52 + 36 + 45 + 54
				BigDecimal ib50 = new BigDecimal(map.get("33"))
				                    .add(new BigDecimal(map.get("42")))
				                    .add(new BigDecimal(map.get("51")))
				                    .add(new BigDecimal(map.get("35")))
				                    .add(new BigDecimal(map.get("44")))
				                    .add(new BigDecimal(map.get("53")))				                    
				                    ;
				map.put("50", ib50.toPlainString());
				
				// tot 
				BigDecimal tt77 = ob23.add(ib50);
				map.put("77", tt77.toPlainString());
				
				// ---------------------------------------------------				
				// Set TTL OTS(22,49,76) , TTL CNT(21, 48, 75)
				// BAD OTS + WI TERM + TTL L/T OTS (14,41,68)
				// ---------------------------------------------------				
				BigDecimal ob22 = ob14.add(new BigDecimal(map.get("04")))                    
								      .add(new BigDecimal(map.get("13")));					                				
				map.put("22", ob22.toPlainString());
				
				BigDecimal ib49 = ib41.add(new BigDecimal(map.get("31")))                    
					                  .add(new BigDecimal(map.get("40")));		                            	
				map.put("49", ib49.toPlainString());

				// tot 
				BigDecimal ib76 = ob22.add(ib49);                      	
				map.put("76", ib76.toPlainString());
				
				
				//  TTL CNT(21, 48, 75)
				BigDecimal ob21 = ob23.add(new BigDecimal(map.get("03")))                    
					      .add(new BigDecimal(map.get("12")));		                				
				map.put("21", ob21.toPlainString());				
				BigDecimal ib48 = ib50.add(new BigDecimal(map.get("30")))                    
					                  .add(new BigDecimal(map.get("39")));
			                      	
				map.put("48", ib48.toPlainString());
			
				// tot 
				BigDecimal ib75 = ob21.add(ib48);                      	
				map.put("75", ib75.toPlainString());				
				
			}
			
			// ===========================================================
			// set return list
			// ===========================================================			
			List<OTSAgingListVO> list = new ArrayList<OTSAgingListVO>();
			
			for (String key : retMap.keySet()) {	
				
				Map<String, String> map = retMap.get(key);
				OTSAgingListVO vo = new OTSAgingListVO();
				
				Class<?> paramString[] = new Class[1];
				paramString[0] = String.class;
								
				for (int i = 1; i <= 81; i++) {
					String colNum = StringUtils.leftPad(i+"", 2, "0");					
					Method method = vo.getClass().getDeclaredMethod("setCol" + colNum , paramString);
					method.invoke(vo, (String)map.get(colNum));
				}
				
				vo.setCltOfcCd(map.get("clt_ofc_cd"));
				vo.setCustNum(map.get("cust_num"));
				vo.setCustNm(map.get("cust_nm"));
				vo.setRhqCd(map.get("rhq_cd"));
				
				list.add(vo);
				
			}
						
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
	 * Add to OTS interface<br> 
	 * 
	 * @param List<OutstandingInterfaceVO> outstandingInterfaceVOs
	 * @exception EventException
	 */
	public void addOutstandingInterface(List<OutstandingInterfaceVO> outstandingInterfaceVOs) throws EventException{
		
		try {
			
			dbDao.addOutstandingInterface(outstandingInterfaceVOs);
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Create Outstanding from interface info<br> 
	 * 
	 * @param String ifNo
	 * @exception EventException
	 */
	public void createOutstandingByInterface(String ifNo) throws EventException{
	
		try {
				
			AccountReceivableCommonBC arCommon = new AccountReceivableCommonBCImpl();
			List<OutstandingInterfaceVO> outstandingInterfaceVOs = new ArrayList<OutstandingInterfaceVO>();
			//AccountReceivableOutstandingIFBC sakuraIf = new AccountReceivableOutstandingIFBCImpl();
			
			//Search outstanding interface info
			outstandingInterfaceVOs = dbDao.searchOutstandingInterface(ifNo);
			
			String otsIfSeq = "";
			String EMPTYINVNO = "**********";
			String otsHisSeq = "";
			
			BigDecimal orgOtsAmt = null;
			BigDecimal calOtsAmt = null;
			
			for (int i = 0; i < outstandingInterfaceVOs.size(); i++) {
				
				AROutstandingHdrVO arOutstandingHdrVO = new AROutstandingHdrVO();
				AROutstandingDtlVO arOutstandingDtlVO = new AROutstandingDtlVO();		
				AROutstandingHistVO arOutstandingHistVO = new AROutstandingHistVO();
				AROutstandingChgVO arOutstandingChgVO = new AROutstandingChgVO();
				List<AROutstandingDtlVO> arOutstandingDtlVOs = new ArrayList<AROutstandingDtlVO>();		
				List<AROutstandingHistVO> arOutstandingHistVOs = new ArrayList<AROutstandingHistVO>();
				List<AROutstandingChgVO> arOutstandingChgVOs = new ArrayList<AROutstandingChgVO>();
				AROutstandingCheckVO arOutstandingCheckVO = new AROutstandingCheckVO();
				ARExrateVO arExrateVO = new ARExrateVO();
				List<CurrencyCodeVO> currencyCodeVOs = new ArrayList<CurrencyCodeVO>();
				
				otsIfSeq = outstandingInterfaceVOs.get(i).getOtsIfSeq();
				
				//Add for checking amount by currency's precision - 2015.06.18
				orgOtsAmt = new BigDecimal(outstandingInterfaceVOs.get(i).getOtsAmt());
				currencyCodeVOs = arCommon.searchCurrencyCode(outstandingInterfaceVOs.get(i).getBlCurrCd());
				calOtsAmt = orgOtsAmt.setScale(Integer.parseInt(currencyCodeVOs.get(0).getDpPrcsKnt()), BigDecimal.ROUND_HALF_UP);
				
				if(!calOtsAmt.stripTrailingZeros().equals(orgOtsAmt.stripTrailingZeros())) throw new EventException(new ErrorHandler("SAR00001",new String[]{}).getMessage());
				
				//Search outstanding interface info for OTS header/detail/history/charge by OTS interface sequence
				arOutstandingHdrVO = dbDao.searchInterfaceForOutstandingHeader(otsIfSeq);			
				arOutstandingDtlVO = dbDao.searchInterfaceForOutstandingDetail(otsIfSeq);
				arOutstandingHistVO = dbDao.searchInterfaceForOutstandingHist(otsIfSeq);
				arOutstandingChgVO = dbDao.searchInterfaceForOutstandingCharge(otsIfSeq);
				
				arOutstandingCheckVO.setRhqCd(arOutstandingHdrVO.getRhqCd());
				arOutstandingCheckVO.setOtsOfcCd(arOutstandingHdrVO.getOtsOfcCd());
				arOutstandingCheckVO.setBlNo(arOutstandingHdrVO.getBlNo());
				arOutstandingCheckVO.setInvNo(arOutstandingHdrVO.getInvNo());
						
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
				arExrateVO.setArOfcCd(arOutstandingHistVO.getInvOfcCd());
				
				String xchRtUsdTpCd = arOutstandingHdrVO.getXchRtTpCd();
				String xchRt3rdTpCd = arOutstandingHdrVO.getXchRtN3rdTpCd();
				String lclCurrCd = arOutstandingHdrVO.getOfcCurrCd();
				//String invCurrCd = arOutstandingHdrVO.getInvCurrCd();
				String chgCurrCd = arOutstandingHistVO.getCurrCd();
				//String invUsdXchRt = "";
				String loclXchRt = "";
				String usdXchRt = "";
				
				/*
				if(("USD").equals(invCurrCd)){
					invUsdXchRt = "1";
				} else {
					arExrateVO.setLclCurrCd("USD");
					arExrateVO.setChgCurrCd(invCurrCd);
					
					if(xchRtUsdTpCd.equals("V")) invUsdXchRt = arCommon.searchVVDExrate(arExrateVO);
					else if(xchRtUsdTpCd.equals("I")) invUsdXchRt = arCommon.searchIndExrate(arExrateVO);
					else if(xchRtUsdTpCd.equals("D")) invUsdXchRt = arCommon.searchDailyExrate(arExrateVO);
					else if(xchRtUsdTpCd.equals("A")) invUsdXchRt = arCommon.searchAccountExrate(arExrateVO);
					else invUsdXchRt = arCommon.searchAccountExrate(arExrateVO);
				}
				
				if(invUsdXchRt == null || invUsdXchRt.equals("")) invUsdXchRt = "0";
				arOutstandingHdrVO.setInvUsdXchRt(invUsdXchRt);
				arOutstandingHistVO.setInvUsdXchRt(invUsdXchRt);
				*/
				
				arExrateVO.setLclCurrCd(arOutstandingHdrVO.getOfcCurrCd());
				arExrateVO.setChgCurrCd(arOutstandingHistVO.getCurrCd());
				
				//Search exchange rate by Charge Currency for local currency conversion
				if(chgCurrCd.equals(lclCurrCd)){
					
					loclXchRt = "1";
				
				}else{
					
					if((xchRtUsdTpCd.equals("V") && chgCurrCd.equals("USD")) || (xchRt3rdTpCd.equals("V") && !chgCurrCd.equals("USD"))){
						loclXchRt = arCommon.searchVVDExrate(arExrateVO);
					}else if((xchRtUsdTpCd.equals("I") && chgCurrCd.equals("USD")) || (xchRt3rdTpCd.equals("I") && !chgCurrCd.equals("USD"))){
						loclXchRt = arCommon.searchIndExrate(arExrateVO);
					}else if((xchRtUsdTpCd.equals("D") && chgCurrCd.equals("USD")) || (xchRt3rdTpCd.equals("D") && !chgCurrCd.equals("USD"))){
						loclXchRt = arCommon.searchDailyExrate(arExrateVO);
					}else if((xchRtUsdTpCd.equals("A") && chgCurrCd.equals("USD")) || (xchRt3rdTpCd.equals("A") && !chgCurrCd.equals("USD"))){
						loclXchRt = arCommon.searchAccountExrate(arExrateVO);
					}else{
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
						usdXchRt = arCommon.searchIndExrate(arExrateVO);
					}else if((xchRtUsdTpCd.equals("D") && chgCurrCd.equals(lclCurrCd)) || (xchRt3rdTpCd.equals("D") && !chgCurrCd.equals(lclCurrCd))){
						usdXchRt = arCommon.searchDailyExrate(arExrateVO);
					}else if((xchRtUsdTpCd.equals("A") && chgCurrCd.equals(lclCurrCd)) || (xchRt3rdTpCd.equals("A") && !chgCurrCd.equals(lclCurrCd))){
						usdXchRt = arCommon.searchAccountExrate(arExrateVO);
					}else{
						usdXchRt = arCommon.searchAccountExrate(arExrateVO);
					}
				}
				
				//Search exchange rate for 3rd currency
				if(!chgCurrCd.equals("USD") && !chgCurrCd.equals(lclCurrCd)){
					if(loclXchRt == null || loclXchRt.equals("") || loclXchRt.equals("0")){
						arExrateVO.setLclCurrCd(lclCurrCd);
						loclXchRt = arCommon.searchAccountExrate(arExrateVO);
					}
					
					if(usdXchRt == null || usdXchRt.equals("") || usdXchRt.equals("0")){
						arExrateVO.setLclCurrCd("USD");
						usdXchRt = arCommon.searchAccountExrate(arExrateVO);
					}
				}
				
				if(usdXchRt == null || usdXchRt.equals("")) usdXchRt = "0";
				if(loclXchRt == null || loclXchRt.equals("")) loclXchRt = "0";
				
				arOutstandingHistVO.setLoclXchRt(loclXchRt);
				arOutstandingHistVO.setUsdXchRt(usdXchRt);
				arOutstandingDtlVO.setLoclXchRt(loclXchRt);
				arOutstandingDtlVO.setUsdXchRt(usdXchRt);
				
				arOutstandingDtlVOs.add(arOutstandingDtlVO);
				arOutstandingHistVOs.add(arOutstandingHistVO);
				arOutstandingChgVOs.add(arOutstandingChgVO);
				
				//Check Outstanding Header
				if(!dbDao.checkOutstandingHeader(arOutstandingCheckVO)) {
					
					dbDao.addOutstandingDetail(arOutstandingDtlVOs);
					dbDao.addOutstandingHeader(arOutstandingHdrVO);
				
				}else{
						
					arOutstandingCheckVO.setBlCurrCd(arOutstandingDtlVO.getBlCurrCd());
					arOutstandingCheckVO.setChgTpCd(arOutstandingDtlVO.getChgTpCd());
					
					//Check Outstanding Detail
					if(dbDao.checkOutstandingDetail(arOutstandingCheckVO)){	
						dbDao.modifyOutstandingDetail(arOutstandingDtlVOs);	
					}else{
						dbDao.addOutstandingDetail(arOutstandingDtlVOs);
					}

					dbDao.modifyOutstandingHeader(arOutstandingHdrVO);
					
				}
				
				//If there is invoice no then create negative amount for B/L
				arOutstandingCheckVO.setInvNo(EMPTYINVNO);
				
				if(dbDao.checkOutstandingHeader(arOutstandingCheckVO) && !(EMPTYINVNO).equals(arOutstandingHdrVO.getInvNo())){
					
					arOutstandingHdrVO.setInvNo(EMPTYINVNO);
					arOutstandingDtlVOs.get(0).setInvNo(EMPTYINVNO);
					
					BigDecimal invAmt = new BigDecimal(arOutstandingDtlVOs.get(0).getInvAmt()).multiply(new BigDecimal(-1));
					
					arOutstandingDtlVOs.get(0).setInvAmt(invAmt.toString());
					arOutstandingDtlVOs.get(0).setLoclXchRt("");
					arOutstandingDtlVOs.get(0).setUsdXchRt("");
					
					dbDao.modifyOutstandingDetail(arOutstandingDtlVOs);
					dbDao.modifyOTSSettleFlag(arOutstandingHdrVO);
					dbDao.modifyOutstandingHistInvNo(arOutstandingHistVOs);
					dbDao.modifyOutstandingChargeInvNo(arOutstandingChgVOs);
					
					//2015.03.11 Interface to SAKURA in case of invoice issue (OTS SMRY is INV)
					//sakuraIf.createSakuraOTSIFdata(arOutstandingHistVOs.get(0).getIfNo(),"P");
				} else {
					otsHisSeq = dbDao.searchOutstandingHistSeq();
					arOutstandingHistVOs.get(0).setOtsHisSeq(otsHisSeq);
					arOutstandingChgVOs.get(0).setOtsHisSeq(otsHisSeq);
					
					dbDao.addOutstandingHist(arOutstandingHistVOs);
					dbDao.addOutstandingCharge(arOutstandingChgVOs);
					
					//Create outstanding account distribution info
					createOutstandingAccount(arOutstandingHistVOs, arOutstandingChgVOs);
				}
				
				//Update OTS interface status flag
				dbDao.modifyOTSInterfaceFlag(otsIfSeq, "Y");
				
				//ASA DTL Update 2015-05-29
				if(outstandingInterfaceVOs.get(i).getOtsSrcCd().equals("STM AP")){ 
					AccountReceivableAgentBCImpl agtcommand = new AccountReceivableAgentBCImpl();
					agtcommand.updateASADtlForCall(outstandingInterfaceVOs.get(i).getBlNo(), outstandingInterfaceVOs.get(i).getUpdUsrId());
				}
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("SAR00001", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("SAR00001", new String[] {}).getMessage(), ex);
		}
	}
	
	
    
	/**
	 *  update Outstanding item collection
	 * @author jinyoonoh 2014. 7. 4.
	 * @param OutstandingHdrByBlVO paramVO
	 * @throws EventException
	 */
	public void manageItemCollection(OutstandingHdrByBlVO paramVO) throws EventException {
		try {
			
			AccountReceivableCommonDBDAO arComDao = new AccountReceivableCommonDBDAO();
			SarOtsHdrVO vo = new SarOtsHdrVO();
			//set PK
			vo.setRhqCd(paramVO.getRhqCd());
			vo.setOtsOfcCd(paramVO.getOtsOfcCd());
			vo.setBlNo(paramVO.getBlNo());
			vo.setInvNo(paramVO.getInvNo());
			
			// set update item
			vo.setOtsGrpTpCd(paramVO.getOtsGrpTpCd());
			vo.setOtsTpCd(paramVO.getOtsTpCd());
			vo.setOtsRmk(paramVO.getOtsRmk());
			vo.setUpdUsrId(paramVO.getUpdUsrId());
			
			arComDao.modifySarOtsHdr(vo);
						
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	

    /**
     * Search Outstanding view accounting
     * @author jinyoonoh 2014. 7. 16.
     * @param OTSViewAccountingListVO vo
     * @return List<OTSViewAccountingListVO> 
     * @throws EventException
     */
    public List<OTSViewAccountingListVO> searchOTSViewAccountingList(OTSViewAccountingListVO vo) throws EventException {
		try {
			
			List<OTSViewAccountingListVO> list = dbDao.searchOTSViewAccountingList(vo);
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
     * Payment Request Letter<br>
     * 
     * @author YJLEE
     * @category STM_SAR_1005
     * @category managePaymentRequestLetterBasic
     * @param PaymentRequestLetterVO[] paymentRequestLetterVOS      
     * @param SignOnUserAccount account    
     * @return List<PaymentRequestLetterVO>
     * @throws EventException
     */    
    @Override
	public List<PaymentRequestLetterVO> managePaymentRequestLetterBasic(PaymentRequestLetterVO[] paymentRequestLetterVOS, SignOnUserAccount account) throws EventException {
		try {
			String arEmlSeq = "";
			String arOfcCd = "";
			
			List<PaymentRequestLetterVO> allList = new ArrayList<PaymentRequestLetterVO>();
			arEmlSeq = paymentRequestLetterVOS[0].getArEmlSeq();  // dbDao.searchPaymentRequestLetterSeq();
			arOfcCd = paymentRequestLetterVOS[0].getArOfcCd();
			
			for (int i = 0; i < paymentRequestLetterVOS.length; i++) {
				if (paymentRequestLetterVOS[i].getIbflag().equals("U")) {
					paymentRequestLetterVOS[i].setArOfcCd(arOfcCd);
					paymentRequestLetterVOS[i].setArEmlSeq(arEmlSeq);
					paymentRequestLetterVOS[i].setAccountUsrId(account.getUsr_id());
					allList.add(paymentRequestLetterVOS[i]);
				} 
			}
			dbDao.addPaymentRequestLetterTemp(allList);
			
			return allList;
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
    
	/**
     * Retrieve Payment Request Letter Email fax event
     * @author JBLEE
     * @param PaymentRequestLetterByEmailFaxVO paymentRequestLetterByEmailFaxVO
     * @return String
     * @throws EventException
     */
    public String sendPaymentRequestLetterByFaxEmail(PaymentRequestLetterByEmailFaxVO paymentRequestLetterByEmailFaxVO)  throws EventException {
		try {
			return eaiDao.sendPaymentRequestLetterByFaxEmail(paymentRequestLetterByEmailFaxVO);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}	
    }
    
    /**
     * addPaymentRequestLetterHistory 
     * @author myoung sin park
     * @param PaymentRequestLetterByEmailFaxVO paymentRequestLetterByEmailFaxVO 
     * @return String
     * @throws EventException
     */
    public String addPaymentRequestLetterHisHdr(PaymentRequestLetterByEmailFaxVO paymentRequestLetterByEmailFaxVO) throws EventException {
    	try {
			//search his seq
			String arEmlHisSeq = dbDao.searchPaymentRequestLetterHisSeq();
			//insert header 
			paymentRequestLetterByEmailFaxVO.setStmtHisSeq(arEmlHisSeq);
			dbDao.addPaymentRequestLetterHisHdr(paymentRequestLetterByEmailFaxVO);
			return arEmlHisSeq; 
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
    
	/**
	 * modifyPaymentRequestLetterHistoryDtl
	 * @author myoung sin park
	 * @param String arEmlHisSeq
	 * @param List<PaymentRequestLetterByEmailFaxVO> list
	 * @throws EventException 
	 */
	public void modifyPaymentRequestLetterHistoryDtl(String arEmlHisSeq, List<PaymentRequestLetterByEmailFaxVO> list)
			throws EventException {
		try {
			if (list.size() > 0) { 
				// search his seq
				for (int i = 0; i < list.size(); i++) {
					list.get(i).setStmtHisSeq(arEmlHisSeq);
				}
				// inser detail
				dbDao.addPaymentRequestLetterHisDtl(list); 
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
	 * modifyPaymentRequestLetterHistoryHdr
	 * @author myoung sin park
	 * @param String arEmlHisSeq
	 * @throws EventException 
	 */
	public void modifyPaymentRequestLetterHistoryHdr(String arEmlHisSeq) throws EventException {
		try {
			dbDao.modifyPaymentRequestLetterHisHdr(arEmlHisSeq);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
    /**
     * Payment Request Letter<br>
     * @author myoungsin park
     * @category STM_SAR_1005
     * @category managePaymentRequestLetterOFC
     * @param String batSeq       
     * @return
     * @throws EventException
     */    
    public String managePaymentRequestLetterOFC(String batSeq) throws EventException {
    	String batResult = "";
    	try{  
	          ScheduleUtil su = new ScheduleUtil();
	          su.directExecuteJob("STM_SAR_B1005", batSeq);
	          batResult = batSeq;
		} catch (DAOException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"PaymentRequestLetter BY OFC Batch"}).getMessage(),e);
		} catch (Exception e){
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"PaymentRequestLetter BY OFC Batch"}).getMessage(),e);
		} 
		return batResult;
    } 
    
    /**
     * searchPaymentRequestLetterCustomer<br>
     * @author myoungsin park
     * @category STM_SAR_1005
     * @param PaymentRequestLetterVO paymentRequestLetterVO    
     * @return
     * @throws EventException
     */    
    public List<PaymentRequestLetterVO> searchPaymentRequestLetterCustomer(PaymentRequestLetterVO paymentRequestLetterVO) throws EventException {
    	try {
    		 List<PaymentRequestLetterVO> returnList = dbDao.searchPaymentRequestLetterCustomer(paymentRequestLetterVO);
    		 
    		 return returnList;    		
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		}
    }
    
    /**
     * Payment Request Letter<br>
     * @author myoungsin park
     * @category STM_SAR_1005
     * @param List<PaymentRequestLetterVO> updateVoList
     * @throws EventException
     */    
	public void managePaymentRequestLetterEmlSeq(List<PaymentRequestLetterVO> updateVoList) throws EventException {
		try {
			dbDao.addPaymentRequestLetterTemp(updateVoList);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	 /**
     * Payment Request Letter<br>
     * @author myoungsin park
     * @category STM_SAR_1009
	 * @param PaymentRequestLetterHisVO paramVO
	 * @return List<PaymentRequestLetterHisVO>
	 * @exception EventException
	 */
	public List<PaymentRequestLetterHisVO> searchPaymentRequestLetterHistory(PaymentRequestLetterHisVO paramVO) throws EventException{
		try { 
			List<PaymentRequestLetterHisVO> list = dbDao.searchPaymentRequestLetterHistory(paramVO);
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
     * SCO_BAT_HIS 테이블에 데이타를 생성한다.    
     * @author myoungsin park
     * @param PaymentRequestLetterVO paymentRequestLetterVO
     * @param SignOnUserAccount account
     * @return String
     * @throws EventException
     */
    public String createPaymentRequestLetterBat(PaymentRequestLetterVO paymentRequestLetterVO,SignOnUserAccount account) throws EventException {
    	String batSeq = "";
    	try {
			  String otsSmryCd= paymentRequestLetterVO.getOtsSmryCd();
			  //String custCd = paymentRequestLetterVO.getCustCd();
			  String blNo= paymentRequestLetterVO.getBlNo();
			  String sailArrDt= paymentRequestLetterVO.getSailArrDt();
			  String vvdCd= paymentRequestLetterVO.getVvdCd();
			  String xcldOtsTpCd= paymentRequestLetterVO.getXcldOtsTpCd();
			  String overdueTo= paymentRequestLetterVO.getOverdueTo();
			  String bnd= paymentRequestLetterVO.getBnd();
			  String arOfcCd= paymentRequestLetterVO.getArOfcCd();  
			  String invNo= paymentRequestLetterVO.getInvNo();
			  String overdueFrom= paymentRequestLetterVO.getOverdueFrom();
			  String otsOpy= paymentRequestLetterVO.getOtsOpy();
			  String rhqCd= paymentRequestLetterVO.getRhqCd();
			  String agnOfcCdText= paymentRequestLetterVO.getAgnOfcCdText();
			  String accountUsrEml = paymentRequestLetterVO.getAccountUsrEml();
			  
			  StringBuilder sb = new StringBuilder("");
			  sb.append(otsSmryCd).append("#");
			  sb.append("").append("#");
			  sb.append(blNo).append("#");
			  sb.append(sailArrDt).append("#");
			  sb.append(vvdCd).append("#");
			  sb.append(xcldOtsTpCd).append("#");
			  sb.append(overdueTo).append("#");
			  sb.append(bnd).append("#");
			  sb.append(arOfcCd).append("#");
			  sb.append(invNo).append("#");
			  sb.append(overdueFrom).append("#");
			  sb.append(otsOpy).append("#");
			  sb.append(rhqCd).append("#");
			  sb.append(account.getUsr_id()).append("#");
			  String name = account.getUsr_nm().replaceAll(" ", "_");
			  sb.append(name).append("#");
			  sb.append(account.getOfc_cd()).append("#");
//			  sb.append(account.getUsr_eml()).append("#");
			  sb.append(accountUsrEml).append("#");
			  sb.append(agnOfcCdText);
    		  
			  batSeq = dbDao.searchBatHisSeqData();
			  BatHisVO batHisVO = new BatHisVO();
			  batHisVO.setBatSeq(batSeq);
			  batHisVO.setPgmSubSysCd("SAR");
			  batHisVO.setBatPgmNo("STM_SAR_B1005");
			  batHisVO.setApplPgmNo("STM_SAR_1005");
			  batHisVO.setBatParaCtnt(sb.toString());
			  batHisVO.setCreUsrId(account.getUsr_id());
			  batHisVO.setUpdUsrId(account.getUsr_id());
			  dbDao.addBatHis(batHisVO);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
    		throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
    	}
    	return batSeq;
    }
    
    /**
     * Insert/Update SAR OUTSTANDING RECEIPT TEMP
     * @author sung yong park
     * @param SarOtsRctTmpVO[] sarOtsRctTmpVOs
     * @param String otsRctTmpSeq
     * @param String usrId
     * @throws EventException
     */
    public void manageOutstandingReceiptTemp(SarOtsRctTmpVO[] sarOtsRctTmpVOs, String otsRctTmpSeq, String usrId) throws EventException {
    	try {
    		
    		List<SarOtsRctTmpVO> addVoList = new ArrayList<SarOtsRctTmpVO>();
			
			if (sarOtsRctTmpVOs != null ) {
				for (int i=0; i<sarOtsRctTmpVOs.length; i++) {		
					sarOtsRctTmpVOs[i].setOtsRctTmpSeq(otsRctTmpSeq);
					sarOtsRctTmpVOs[i].setCreUsrId(usrId);
					sarOtsRctTmpVOs[i].setUpdUsrId(usrId);
					
					addVoList.add(sarOtsRctTmpVOs[i]);
				}
			}
					
    		if (addVoList.size() > 0) {
				dbDao.addOutstandingReceiptTemp(addVoList);
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
	 * delete SAR OUTSTANDING RECEIPT TEMP<br> 
     * @author sung yong park
	 * @param String otsRctTmpSeq
	 * @exception EventException
	 */
	public void removeOutstandingReceiptTemp(String otsRctTmpSeq) throws EventException{
	
		try {
			dbDao.removeOutstandingReceiptTemp(otsRctTmpSeq);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Search Outstanding Receipt Temp Sequence<br> 
     * @author sung yong park
	 * @return String
	 * @exception EventException
	 */
	public String searchOutstandingReceiptTempSeq() throws EventException{
	
		try {
			return dbDao.searchOutstandingReceiptTempSeq();
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
	
	/**
	 * check batch status
	 * R: Running
	 * S: Start
	 * 
	 * @param pgmNo
	 * @return
	 * @throws EventException
	 */
	public String searchBatStsCdLetterOFC(String pgmNo) throws EventException{
		ScheduleUtil su = new ScheduleUtil();
		boolean isRunningStatus = false;
		
		try {
			isRunningStatus = su.isRunning(pgmNo);			
			log.error("PaymentRequestLetter BY OFC Batch Running:::"+isRunningStatus+"\n");
			
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
	public void manageCancelBatLetterOFC(String batSeq, SignOnUserAccount account) throws EventException {
		try {
			
			dbDao.manageCancelBatLetterOFC(batSeq); // 'E'로 update
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
}