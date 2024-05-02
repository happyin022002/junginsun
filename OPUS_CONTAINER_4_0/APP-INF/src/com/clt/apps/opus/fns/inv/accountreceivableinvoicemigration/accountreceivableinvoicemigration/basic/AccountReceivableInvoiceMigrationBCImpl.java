/*=========================================================
 * Copyright(c) 2009 CyberLogitec
 * @FileName : AccountReceivableInvoiceMigrationBCImpl.java
 * @FileTitle : Migration Interface
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2015.11.26
 * @LastModifier : 박성용
 * @LastVersion : 1.0
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.basic;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.integration.AccountReceivableInvoiceMigrationDBDAO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.ARBkgInterfaceCreationVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.ARCreditInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.ARCreditVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.ARCurrCdVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.ARInvoiceCreationVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.ActInvCustVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.ArOfcAgtMkVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.ArOfcAttributeVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.ArOfficeVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.BKGMainDocVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.BLNoBKGStatusVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.BkgOfcPayIndVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.ChinaDailyExrateInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.CustExrateInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.CustInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.CutOffLaneVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.ExchangeRateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.InvArAmtVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.InvArChgVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.InvArIfNoVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.InvArIssDtlVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.InvArIssVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.InvArMnVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.InvBkgIfChgVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.VVDCustomerVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.VVDExrateInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.VvdLanePortVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.VvdPortVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.VvdSaDtVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.ARInterfaceCreationVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.InvArIfChgVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.InvArIfMnVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.InvIssMainVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.IssueOptionVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.REVTypeSourceVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.basic.AccountReceivableOutstandingMigrationBC;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.basic.AccountReceivableOutstandingMigrationBCImpl;
import com.clt.bizcommon.edi.broker.ReferenceNumberGeneratorBroker;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.util.ScheduleUtil;
import com.clt.syscommon.common.table.BkgVvdVO;
import com.clt.syscommon.common.table.MdmCustomerVO;
import com.clt.syscommon.common.table.MdmOrganizationVO;
import com.clt.syscommon.common.table.VskVslPortSkdVO;
import com.clt.framework.component.util.DateTime;


/**
 * OPUS-AccountReceivableInvoiceMigration Business Logic Basic Command implementation<br>
 * - OPUS-AccountReceivableInvoiceMigration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author sung yong park
 * @see FNS_INV_9001EventResponse,AccountReceivableInvoiceMigrationBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
 
public class AccountReceivableInvoiceMigrationBCImpl extends BasicCommandSupport implements AccountReceivableInvoiceMigrationBC {

	// Database Access Object
	private transient AccountReceivableInvoiceMigrationDBDAO dbDao = null;

	/** 
	 * AccountReceivableInvoiceMigrationBCImpl 객체 생성<br>
	 * AccountReceivableInvoiceMigrationDBDAO를 생성한다.<br>
	 */
	public AccountReceivableInvoiceMigrationBCImpl() {
		dbDao = new AccountReceivableInvoiceMigrationDBDAO();
	}
	
	
	/**
	 * BKG Migration Interface<br>
	 * 
	 * @param String fmCtrtOfcCd
	 * @param String toCtrtOfcCd
	 * @param String bkgNo
	 * @return String
	 * @exception EventException
	 */
	public String executeBookingMigration(String fmCtrtOfcCd, String toCtrtOfcCd, String bkgNo ) throws EventException {
		String batResult = "";
		String param = "BKG" + "#" + fmCtrtOfcCd + "#" + toCtrtOfcCd + "#" + bkgNo;
		
		try {			
				ScheduleUtil su = new ScheduleUtil();
				batResult = su.directExecuteJob("FNS_INV_B9001",param);
		
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		}
		
		return batResult;
	}
	
	/**
	 * Other Migration Interface<br>
	 * 
	 * @param String ofcCd
	 * @param String fmSrcIfSeq
	 * @param String toSrcIfSeq
	 * @return String
	 * @exception EventException
	 */
	public String executeOtherMigration(String ofcCd, String fmSrcIfSeq, String toSrcIfSeq ) throws EventException {
		String batResult = "";
		String param = "OTH" + "#" + ofcCd + "#" + fmSrcIfSeq + "#" + toSrcIfSeq;
		
		try {			
				ScheduleUtil su = new ScheduleUtil();
				batResult = su.directExecuteJob("FNS_INV_B9001",param);
		
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		}
		
		return batResult;
	}
	
	/**
	 * VVD Ex. Rate Creation<br>
	 * 
	 * @param String arOfcCd
	 * @param String vvdCd
	 * @return String
	 * @exception EventException
	 */
	public String createVVDExchangeRate(String arOfcCd, String vvdCd) throws EventException {
		String batResult = "";
		String param = "VVD" + "#" + arOfcCd + "#" + vvdCd;
		
		try {			
				ScheduleUtil su = new ScheduleUtil();
				batResult = su.directExecuteJob("FNS_INV_B9001",param);
		
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		}
		
		return batResult;
	}
	
	/**
	 * Daily USD Ex. Rate Creation<br>
	 * 
	 * @param String arOfcCd
	 * @return String
	 * @exception EventException
	 */
	public String createDailyUSDExchangeRate(String arOfcCd) throws EventException {
		String batResult = "";
		String param = "DLY" + "#" + arOfcCd;
		
		try {			
				ScheduleUtil su = new ScheduleUtil();
				batResult = su.directExecuteJob("FNS_INV_B9001",param);
		
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		}
		
		return batResult;
	}
	
	/**
	 * Interface from booking migration<br>
	 * 
	 * @param ARBkgInterfaceCreationVO bkgIfVo
	 * @return List<InvArIfNoVO>
	 * @exception EventException
	 */
	public List<InvArIfNoVO> executeInterfaceBKGARInvoiceToINV(ARBkgInterfaceCreationVO bkgIfVo) throws EventException{
		
		AccountReceivableOutstandingMigrationBC command = new AccountReceivableOutstandingMigrationBCImpl();
		
		try {
				
			List<InvArIfNoVO> ifNos = new ArrayList<InvArIfNoVO>();
			
			String bkgNo = bkgIfVo.getBkgNo();
			String bkgSeq = bkgIfVo.getBkgSeq();
			String bkgUserId = bkgIfVo.getUserId();
			String bkgOfcCd = bkgIfVo.getBkgOfcCd();
			//String userId = "BKG I/F";
			//String bkgCorrNo = "";
			//int updCnt = 0;
			
			if(bkgOfcCd.equals("")){
				dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", new ErrorHandler("INV00038", new String[] {}).getUserMessage(), bkgUserId);
				return null;
			}
			
			String newBkgNo = dbDao.searchMaxBKGNo("BKG", bkgNo, bkgSeq, bkgOfcCd);
			
			/*
			// BkgNo call in case(Manual Interface screen)
			if(bkgIfVo.getManDivInd().equals("M")&&bkgIfVo.getBkgSeq().equals("")){
				
				//IF Table Insert			
				bkgSeq = dbDao.addInvBkgIf(bkgNo, bkgCorrNo, bkgUserId);
				if (bkgSeq==null){					
					throw new EventException(new ErrorHandler("INV00113", new String[] {}).getMessage());
				}	
				
				return null;
			
			// Manual Interface screen BKG is BKG_SEQ setting
			}else{
				bkgSeq = bkgIfVo.getBkgSeq();
			}

			int cntPpdOfc = dbDao.checkEurPpdOfc(bkgNo);
			
			if(cntPpdOfc > 0){
				createFACComm(bkgNo);
				
				BkgOfcPayIndVO bkgOfcPayIndVO = dbDao.searchEurPpdOfc( bkgNo );
				
				dbDao.addInvBkgIfFacChg( bkgNo, bkgSeq, bkgOfcPayIndVO.getOfcCd(), bkgOfcPayIndVO.getCustCntCd(), bkgOfcPayIndVO.getCustSeq() );
			}	
			// FAC creation End
			*/
			
			BLNoBKGStatusVO bLNoBKGStatusVO = dbDao.searchBLNoByBKGNo(bkgNo,bkgSeq);
			
			if( bLNoBKGStatusVO == null){
				dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", new ErrorHandler("INV00172", new String[] {}).getUserMessage(), bkgUserId);
			} else {			
				if(bLNoBKGStatusVO.getBlSrcNo().equals("")||bLNoBKGStatusVO.getCxlFlg().equals("")||bLNoBKGStatusVO.getBkgStsCd().equals("")||bLNoBKGStatusVO.getObrdDt().equals("")){				
					if(bLNoBKGStatusVO.getBlSrcNo().equals("")){
						dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", new ErrorHandler("INV00173", new String[] {}).getUserMessage(), bkgUserId);
					} else if (bLNoBKGStatusVO.getCxlFlg().equals("")){
						dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", new ErrorHandler("INV00174", new String[] {}).getUserMessage(), bkgUserId);
					} else if (bLNoBKGStatusVO.getBkgStsCd().equals("")){
						dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", new ErrorHandler("INV00175", new String[] {}).getUserMessage(), bkgUserId);
					} else if (bLNoBKGStatusVO.getObrdDt().equals("")){
						dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", new ErrorHandler("INV00098", new String[] {}).getUserMessage(), bkgUserId);
					}
				} else {
					
					//List<InvArIfNoVO> mainIfNos = new ArrayList<InvArIfNoVO>();
					
					String blSrcNo = bLNoBKGStatusVO.getBlSrcNo();
					String autoMnlDivCd = bLNoBKGStatusVO.getAutoMnlDivCd();
					String chnAgnCd = bLNoBKGStatusVO.getChnAgnCd();					
					
					//dbDao.searchMaxInterfaceForUpdate(bLNoBKGStatusVO.getBlSrcNo());
					
					// Max IF Main data
					//List<MaxIFMainVO> maxIFMainVOs = dbDao.searchMaxInterfaceList(bLNoBKGStatusVO.getBlSrcNo());
					
					
					List<BkgOfcPayIndVO> bkgOfcPayIndVOs = dbDao.searchBKGOfficeList(bkgNo,bkgSeq);
					
					/*
					// Booking Cancel Flag = 'Y'
					if(bLNoBKGStatusVO.getCxlFlg().equals("Y")||bkgOfcPayIndVOs.size()==0){
						for(int i=0;i< maxIFMainVOs.size();i++){
							
							// Delete Division Code = 'N'  
							if(maxIFMainVOs.get(i).getInvDeltDivCd().equals("N")){
								
								// Good Date IS NOT NULL
								if(!maxIFMainVOs.get(i).getBlInvCfmDt().equals("")){
									String cancelIfNo = "";
									
									// A/R Office is korean in case
									if(maxIFMainVOs.get(i).getLocCd().equals("KR")){
										int cnt = dbDao.checkDecWHF(maxIFMainVOs.get(i).getArIfNo());
										
										//Dec WHF is exist in case
										if(cnt>0){
											cancelIfNo = createMaxIFCancel(maxIFMainVOs.get(i).getArIfNo(),"Y", maxIFMainVOs.get(i).getCreUsrId(),"N");
											if(!cancelIfNo.equals("")){
												InvArIfNoVO ifNo = new InvArIfNoVO();
												ifNo.setIfNo(cancelIfNo);
												ifNos.add(ifNo);
											}
										
										//Dec WHF is not exist in case
										}else{
											cancelIfNo = createMaxIFCancel(maxIFMainVOs.get(i).getArIfNo(),"N", maxIFMainVOs.get(i).getCreUsrId(),"N");
											
											if(!cancelIfNo.equals("")){
												InvArIfNoVO ifNo = new InvArIfNoVO();
												ifNo.setIfNo(cancelIfNo);
												ifNos.add(ifNo);
											}
										}								
										
									//A/R Office is not korean in case	
									}else{
										cancelIfNo = createMaxIFCancel(maxIFMainVOs.get(i).getArIfNo(),"N",maxIFMainVOs.get(i).getCreUsrId(),"N");
										
										if(!cancelIfNo.equals("")){
											InvArIfNoVO ifNo = new InvArIfNoVO();
											ifNo.setIfNo(cancelIfNo);
											ifNos.add(ifNo);
										}
									}

									updCnt = dbDao.modifySysClearFlag(maxIFMainVOs.get(i).getArIfNo(),cancelIfNo, userId);
									
									// SysClear ifNo ERP send
									if(updCnt==2){
										InvArIfNoVO mainIfNoVo = new InvArIfNoVO();
										mainIfNoVo.setIfNo(maxIFMainVOs.get(i).getArIfNo());
										mainIfNos.add(mainIfNoVo);
									}									
									
								//Good Date IS NULL	
								}else if(maxIFMainVOs.get(i).getBlInvCfmDt().equals("")){
									dbDao.modifyDelCode(maxIFMainVOs.get(i).getArIfNo(), userId);
								}
							}
						}
						
						if(bLNoBKGStatusVO.getCxlFlg().equals("Y")){
							dbDao.modifyInvArIfStatus(bkgNo,bkgSeq, "Y", new ErrorHandler("INV00176", new String[] {}).getUserMessage(), bkgUserId);
						}else{
							if(maxIFMainVOs.size()>0){
								dbDao.modifyInvArIfStatus(bkgNo,bkgSeq, "Y", new ErrorHandler("INV00176", new String[] {}).getUserMessage(), bkgUserId);
							}else{
								dbDao.modifyInvArIfStatus(bkgNo,bkgSeq, "C", new ErrorHandler("INV00177", new String[] {}).getUserMessage(), bkgUserId);
							}
						}
						
					//Booking Cancel Flag = 'N'	
					}else{
					*/	
						List<ARInvoiceCreationVO> invCreVos = new ArrayList<ARInvoiceCreationVO>();				
						//List<BkgOfcPayIndVO> bkgOfcPayIndVOs = dbDao.searchBKGOfficeList(bkgNo,bkgSeq);
						
						String arCtrlOfcCd = "";
						String arOfcCd = "";
						String subAgnFlg = "";
						String vvd = "";
						String portCd = "";
						String sailArrDt = "";
						String actCustCntCd = "";
						String actCustSeq = "";
						String invCustCntCd = "";
						String invCustSeq= "";
						String slanCd = "";
						String svcScpCd = "";
						String revVvd = "";
						String rlaneCd ="";
						String sailDt = "";
						String arCurrCd = "";
						String polCd = "";
						String podCd = "";
						String porCd = "";
						String delCd = "";
						String locCd = "";
						String arHdQtrOfcCd = "";
						String arAgnStlCd = "";
						String znIocCd = "";
						
						if(bkgOfcPayIndVOs.size()==0){
							dbDao.modifyInvArIfStatus(bkgNo,bkgSeq, "C", new ErrorHandler("INV00177", new String[] {}).getUserMessage(), bkgUserId);
							return null;
						}

						for(int i=0; i <bkgOfcPayIndVOs.size();i++){
							ARInvoiceCreationVO invCreVo = new ARInvoiceCreationVO();
							InvArMnVO invArMnVO = new InvArMnVO();
							
							VvdLanePortVO vvdLanePortVO = searchVVDForNewInterface( bkgNo, bkgSeq, bkgOfcPayIndVOs.get(i).getIoBndCd(), bkgOfcPayIndVOs.get(i).getOfcCd());
							
							vvd = vvdLanePortVO.getVvd();
							portCd = vvdLanePortVO.getPortCd();
							sailArrDt = vvdLanePortVO.getSailArrDt();
							slanCd = vvdLanePortVO.getSlanCd();
							svcScpCd = vvdLanePortVO.getSvcScpCd();
							revVvd = vvdLanePortVO.getRevVvd();
							rlaneCd = vvdLanePortVO.getRlaneCd();
							sailDt = vvdLanePortVO.getSailDt();
							polCd = vvdLanePortVO.getPolCd();
							podCd = vvdLanePortVO.getPodCd();
							porCd = vvdLanePortVO.getPorCd();
							delCd = vvdLanePortVO.getDelCd();
							znIocCd = vvdLanePortVO.getZnIocCd();
							
							if((slanCd!=null&&slanCd.equals("")) || slanCd==null ){
								dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", new ErrorHandler("INV00178", new String[] {}).getUserMessage(), bkgUserId);
								return null;
							}
							
							if((svcScpCd!=null&&svcScpCd.equals("")) || svcScpCd==null){
								dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", new ErrorHandler("INV00179", new String[] {}).getUserMessage(), bkgUserId);
								return null;
							}
							
							if((vvd!=null&&vvd.equals("")) || vvd==null){
								dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", new ErrorHandler("INV00180", new String[] {}).getUserMessage(), bkgUserId);
								return null;
							}
							
							if((polCd!=null&&polCd.equals("")) || polCd==null){
								dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", new ErrorHandler("INV00181", new String[] {}).getUserMessage(), bkgUserId);
								return null;
							}
							
							if((podCd!=null&&podCd.equals("")) || podCd==null){
								dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", new ErrorHandler("INV00182", new String[] {}).getUserMessage(), bkgUserId);
								return null;
							}

							// rev vvd , rlane cd is not exist in case, error
							if((revVvd!=null&&revVvd.equals("")) || revVvd==null){
								dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", new ErrorHandler("INV00183", new String[] {}).getUserMessage(), bkgUserId);
								return null;
							}
							
							if((sailDt!=null&&sailDt.equals("")) || sailDt==null){
								
								sailDt = bLNoBKGStatusVO.getObrdDt();
								
								if((sailDt!=null&&sailDt.equals("")) || sailDt==null){
									dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", new ErrorHandler("INV00132", new String[] {}).getUserMessage(), bkgUserId);
									return null;
								}
							}
							
							if((sailArrDt!=null&&sailArrDt.equals("")) || sailArrDt==null){
								dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", new ErrorHandler("INV00011", new String[] {}).getUserMessage(), bkgUserId);
								return null;
							}
							
							/*
							if((rlaneCd!=null&&rlaneCd.equals("")) || rlaneCd==null){
								dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", new ErrorHandler("INV00184", new String[] {}).getUserMessage(), bkgUserId);
								return null;
							}
							*/
							
							CutOffLaneVO cutOffLaneVO = new CutOffLaneVO();
							cutOffLaneVO.setIoBndCd(bkgOfcPayIndVOs.get(i).getIoBndCd());
							cutOffLaneVO.setOfcCd(bkgOfcPayIndVOs.get(i).getOfcCd());
							cutOffLaneVO.setPortCd(portCd);
							cutOffLaneVO.setVvd(vvd);
							cutOffLaneVO.setSailArrDt(sailArrDt);
							
							ArOfficeVO arOfficeVO = searchAROfficeList(cutOffLaneVO);					
							arCtrlOfcCd = arOfficeVO.getArCtrlOfcCd();
							arOfcCd = arOfficeVO.getArOfcCd();
							subAgnFlg = arOfficeVO.getSubAgnFlg();
							arCurrCd = arOfficeVO.getArCurrCd();
							locCd =  arOfficeVO.getLocCd();
							arHdQtrOfcCd = arOfficeVO.getArHdQtrOfcCd();
							arAgnStlCd = arOfficeVO.getArAgnStlCd();//ofc_agent_mark						
							
							if((arOfcCd!=null&&arOfcCd.equals("")) || arOfcCd==null){
								dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", new ErrorHandler("INV00185", new String[] {bkgOfcPayIndVOs.get(i).getOfcCd()}).getUserMessage() , bkgUserId);
								return null;
							}
							
							if((arCurrCd!=null&&arCurrCd.equals("")) || arCurrCd==null){
								dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", new ErrorHandler("INV00186", new String[] {}).getUserMessage(), bkgUserId);
								return null;
							}
								
							CustInputVO custInputVO = new CustInputVO();
							custInputVO.setBkgNo(bkgNo);
							custInputVO.setBkgSeq(bkgSeq);
							custInputVO.setBlSrcNo(blSrcNo);
							custInputVO.setCustCntCd(bkgOfcPayIndVOs.get(i).getCustCntCd());
							custInputVO.setCustSeq(bkgOfcPayIndVOs.get(i).getCustSeq());
							custInputVO.setIoBndCd(bkgOfcPayIndVOs.get(i).getIoBndCd());
							custInputVO.setArCtrlOfcCd(arCtrlOfcCd);
							custInputVO.setAutoMnlDivCd(autoMnlDivCd);
							custInputVO.setN3rdFlg(bkgOfcPayIndVOs.get(i).getN3rdFlg());
							custInputVO.setArOfcCd(arOfcCd);
							custInputVO.setVvd(vvd);
							custInputVO.setPortCd(portCd);
							custInputVO.setSubAgnFlg(subAgnFlg);
							custInputVO.setChnAgnCd(chnAgnCd);
							custInputVO.setOfcCd(bkgOfcPayIndVOs.get(i).getOfcCd());
							custInputVO.setPolCd(polCd);
							custInputVO.setPodCd(podCd);
							custInputVO.setPorCd(porCd);
							custInputVO.setDelCd(delCd);
							
							ActInvCustVO actInvCustVO = searchCustomerCode(custInputVO);
							
							actCustCntCd = actInvCustVO.getActCustCntCd();
							actCustSeq = actInvCustVO.getActCustSeq();
							invCustCntCd = actInvCustVO.getInvCustCntCd();
							invCustSeq= actInvCustVO.getInvCustSeq();
							
							int actCustCnt = dbDao.checkCustomer(actCustCntCd, actCustSeq);
							
							int invCustCnt = dbDao.checkCustomer(invCustCntCd, invCustSeq);
							
							if(actCustCnt == 0 ){
								dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", new ErrorHandler("INV00008", new String[] {}).getUserMessage(), bkgUserId);
								return null;
								//actCustCntCd = arOfficeVO.getRepCustCntCd();
								//actCustSeq = arOfficeVO.getRepCustSeq();
							}
							
							if(invCustCnt == 0 ){
								dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", new ErrorHandler("INV00008", new String[] {}).getUserMessage(), bkgUserId);
								return null;
								//invCustCntCd =  arOfficeVO.getRepCustCntCd();
								//invCustSeq= arOfficeVO.getRepCustSeq();
							}
							
							/*
							if((actCustCntCd!=null&&actCustCntCd.equals("")) || actCustCntCd==null){
//										dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", new ErrorHandler("INV00150", new String[] {bkgOfcPayIndVOs.get(i).getCustCntCd()+ bkgOfcPayIndVOs.get(i).getCustSeq()}).getUserMessage(), bkgUserId);
//										return null;
								actCustCntCd = arOfficeVO.getRepCustCntCd();
								actCustSeq = arOfficeVO.getRepCustSeq();
							}
							
							if((actCustSeq!=null&&actCustSeq.equals("")) || actCustSeq==null){
//										dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", new ErrorHandler("INV00151", new String[] {bkgOfcPayIndVOs.get(i).getCustCntCd()+ bkgOfcPayIndVOs.get(i).getCustSeq()}).getUserMessage(), bkgUserId);
//										return null;
								actCustCntCd = arOfficeVO.getRepCustCntCd();
								actCustSeq = arOfficeVO.getRepCustSeq();
							}
							
							if((invCustCntCd!=null&&invCustCntCd.equals("")) || invCustCntCd==null){
//										dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", new ErrorHandler("INV00152", new String[] {bkgNo}).getUserMessage(), bkgUserId);
//										return null;
								invCustCntCd =  arOfficeVO.getRepCustCntCd();
								invCustSeq= arOfficeVO.getRepCustSeq();
							}
							
							if((invCustSeq!=null&&invCustSeq.equals("")) || invCustSeq==null){
//										dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", new ErrorHandler("INV00153", new String[] {bkgNo}).getUserMessage(), bkgUserId);
//										return null;
								invCustCntCd =  arOfficeVO.getRepCustCntCd();
								invCustSeq= arOfficeVO.getRepCustSeq();
							}
							*/
							
							//String svrId = dbDao.searchServerID(arOfcCd);

							List<InvBkgIfChgVO> invBkgIfChgVOs = dbDao.searchInvoiceChargeList(bkgNo, bkgSeq, bkgOfcPayIndVOs.get(i).getOfcCd(), bkgOfcPayIndVOs.get(i).getIoBndCd(), bkgOfcPayIndVOs.get(i).getN3rdFlg());
														
							List<InvArChgVO> invArChgVOs = new ArrayList<InvArChgVO>();					
							
							for(int j=0; j< invBkgIfChgVOs.size();j++){	
								
								InvArChgVO  invArChgVO = new InvArChgVO();
								String tvaFlg = "N";								

								invArChgVO.setTvaFlg(tvaFlg);      
								
								invArChgVO.setChgCd(invBkgIfChgVOs.get(j).getChgCd());
								invArChgVO.setCurrCd(invBkgIfChgVOs.get(j).getCurrCd());
								invArChgVO.setPerTpCd(invBkgIfChgVOs.get(j).getPerTpCd());
								invArChgVO.setTrfRtAmt(invBkgIfChgVOs.get(j).getTrfRtAmt());
								invArChgVO.setRatAsCntrQty(invBkgIfChgVOs.get(j).getRatAsCntrQty());
								invArChgVO.setChgAmt(invBkgIfChgVOs.get(j).getChgAmt());
								invArChgVO.setInvXchRt(invBkgIfChgVOs.get(j).getInvXchRt());
								invArChgVO.setTrfNo(invBkgIfChgVOs.get(j).getTrfNo());
								
								if(invBkgIfChgVOs.get(j).getChgCd().equals("FAC")){
									invArChgVO.setMfDivCd("N");
								}else{
									invArChgVO.setMfDivCd("M");
								}						
								
								invArChgVO.setWhfFlg(invBkgIfChgVOs.get(j).getWhfFlg());
								
								
								invArChgVOs.add(invArChgVO);
							}
							
							invArMnVO.setArOfcCd(arOfcCd);
							invArMnVO.setIoBndCd(bkgOfcPayIndVOs.get(i).getIoBndCd());
							invArMnVO.setLoclCurrCd(arCurrCd);
							invArMnVO.setVslCd(vvd.substring(0,4));
							invArMnVO.setSkdVoyNo(vvd.substring(4,8));
							invArMnVO.setSkdDirCd(vvd.substring(8,9));
							invArMnVO.setActCustCntCd(actCustCntCd);
							invArMnVO.setActCustSeq(actCustSeq);
							invArMnVO.setInvCustCntCd(invCustCntCd);
							invArMnVO.setInvCustSeq(invCustSeq);
							invArMnVO.setPolCd(polCd);
							invArMnVO.setPodCd(podCd);
							invArMnVO.setBkgNo(newBkgNo);
							invArMnVO.setBlSrcNo(newBkgNo);
							invArMnVO.setInvSrcNo(bkgNo);
							invArMnVO.setOrgInvNo(blSrcNo);
							invArMnVO.setSlanCd(slanCd);
							invArMnVO.setSvcScpCd(svcScpCd);
							invArMnVO.setInvSvcScpCd(svcScpCd);
							invArMnVO.setRevVslCd(revVvd.length() == 10?revVvd.substring(0,4):"");
							invArMnVO.setRevSkdVoyNo(revVvd.length() == 10?revVvd.substring(4,8):"");
							invArMnVO.setRevSkdDirCd(revVvd.length() == 10?revVvd.substring(8,9):"");
							invArMnVO.setRevDirCd(revVvd.length() == 10?revVvd.substring(9,10):"");
							invArMnVO.setRlaneCd(rlaneCd);
							invArMnVO.setSailDt(sailDt);
							invArMnVO.setSailArrDt(sailArrDt);
							invArMnVO.setZnIocCd(znIocCd);

							invArMnVO.setSlsOfcCd(bkgOfcPayIndVOs.get(i).getOfcCd());
							invArMnVO.setInvOrgOfcCd(bkgOfcPayIndVOs.get(i).getOfcCd());
							
							//InvArMnVO teuFeu = dbDao.searchBkgIfTeuFeu(bkgNo,bkgSeq);
							
							invArMnVO.setBkgTeuQty("0");
							invArMnVO.setBkgFeuQty("0");	
							invArMnVO.setBkgCorrNo("");	
							
							invArMnVO.setN3rdFlg(bkgOfcPayIndVOs.get(i).getN3rdFlg());
							
							invCreVo.setInvArMnVO(invArMnVO);
							invCreVo.setInvArChgVOs(invArChgVOs);
							invCreVo.setLocCd(locCd);
							invCreVo.setArHdQtrOfcCd(arHdQtrOfcCd);
							invCreVo.setArAgnStlCd(arAgnStlCd);
							invCreVos.add(invCreVo);
						}				
						
						int invCreFlgCnt = 0;
						//String cntrDiv = "N";
						
						/*
						//[Max I/F 1...n] For
						for( int i = 0; i< maxIFMainVOs.size(); i++ ){
							int divCnt = 0;				
							int ofcDivCnt = 0;	
							String vvdTrnsFlg = "N";	
							
							//[New I/F 1...n] For
							for( int j = 0; j < invCreVos.size(); j++ ){
								
								//Max I/F's A/R Office and new I/F's A/R Office is same in case
								if(maxIFMainVOs.get(i).getArOfcCd().equals(invCreVos.get(j).getInvArMnVO().getArOfcCd())){
									ofcDivCnt = ofcDivCnt + 1;									
									
									//Max I/F's Delete Division Code = 'N' in case
									if(maxIFMainVOs.get(i).getInvDeltDivCd().equals("N")){
										
										//Max I/F's Good Date IS NOT NULL in case
										if(!maxIFMainVOs.get(i).getBlInvCfmDt().equals("")){
											
											// VVD, Service Scope, Lane, POL(POD), Revenue VVD, Revenue Lane, Charge Type, Per Type, Currency, Rate, Rated As, Amount, Exchange Rate
											if(!maxIFMainVOs.get(i).getVvdCd().equals(invCreVos.get(j).getInvArMnVO().getVslCd()+invCreVos.get(j).getInvArMnVO().getSkdVoyNo()+invCreVos.get(j).getInvArMnVO().getSkdDirCd())){
												vvdTrnsFlg = "Y";
												divCnt = divCnt+1;
											}
											if(!maxIFMainVOs.get(i).getSvcScpCd().equals(invCreVos.get(j).getInvArMnVO().getSvcScpCd())){
												divCnt = divCnt+1;
											}
											if(!maxIFMainVOs.get(i).getSlanCd().equals(invCreVos.get(j).getInvArMnVO().getSlanCd())){
												divCnt = divCnt+1;
											}
											if(!maxIFMainVOs.get(i).getPolCd().equals(invCreVos.get(j).getInvArMnVO().getPolCd())){
												divCnt = divCnt+1;
											}
											if(!maxIFMainVOs.get(i).getPodCd().equals(invCreVos.get(j).getInvArMnVO().getPodCd())){
												divCnt = divCnt+1;
											}
											if(!maxIFMainVOs.get(i).getRevVvdCd().equals(invCreVos.get(j).getInvArMnVO().getRevVslCd()+invCreVos.get(j).getInvArMnVO().getRevSkdVoyNo()+invCreVos.get(j).getInvArMnVO().getRevSkdDirCd()+invCreVos.get(j).getInvArMnVO().getRevDirCd())){
												divCnt = divCnt+1;
											}
											if(!maxIFMainVOs.get(i).getRlaneCd().equals(invCreVos.get(j).getInvArMnVO().getRlaneCd())){
												divCnt = divCnt+1;
											}
											if(!maxIFMainVOs.get(i).getIoBndCd().equals(invCreVos.get(j).getInvArMnVO().getIoBndCd())){
												divCnt = divCnt+1;
											}										
											if(!maxIFMainVOs.get(i).getBkgTeuQty().equals(invCreVos.get(j).getInvArMnVO().getBkgTeuQty())||!maxIFMainVOs.get(i).getBkgFeuQty().equals(invCreVos.get(j).getInvArMnVO().getBkgFeuQty())){
												cntrDiv = "Y";
											}		
											
											int whfDeclNoCnt = 0;
											String whfChk = "";
											
											if(invCreVos.get(j).getLocCd().substring(0,2).equals("KR")){
												// chacking exist Whf Decl No from BKG.
												whfDeclNoCnt = dbDao.checkExistsDecWHFByBL(bLNoBKGStatusVO.getBlSrcNo(), maxIFMainVOs.get(i).getArOfcCd(),bLNoBKGStatusVO.getWhfDeclNo());
												
												whfChk = whfDeclNoCnt>0?"Y":"N";

												if(!bLNoBKGStatusVO.getWhfDeclNo().equals("")&&whfChk.equals("N")){
													divCnt = divCnt+1;
												}
												
												// WHF CANCEL in case. 
												if(bLNoBKGStatusVO.getWhfDeclCxlFlg().equals("Y")){
													divCnt = divCnt+1;
												}
											}

											List<MaxIFChgeVO> compIFChgeVOs = dbDao.compareBkgIFChargeList(bkgNo, bkgSeq, invCreVos.get(j).getInvArMnVO().getSlsOfcCd(), whfChk, maxIFMainVOs.get(i).getArOfcCd());
											
											if(compIFChgeVOs.size()>0){
												divCnt = divCnt+1;
											}
											
											// Max IF Chg data
											List<MaxIFChgeVO> maxIFChgeVOs = dbDao.searchChargeListForMaxInterface(bLNoBKGStatusVO.getBlSrcNo(),maxIFMainVOs.get(i).getArOfcCd(), whfChk); 
											
											// Chg data
											List<InvBkgIfChgVO> bkgIFChgeVOs = dbDao.searchInvoiceIfChargeList(bkgNo,bkgSeq,invCreVos.get(j).getInvArMnVO().getSlsOfcCd(), whfChk);
											
											int chgDivCnt = 0;	
											
											//Charge item comparison
											for(int k=0;k< maxIFChgeVOs.size();k++){
												for(int l=0;l< bkgIFChgeVOs.size();l++){														
													
													if(maxIFChgeVOs.get(k).getChgCd().equals(bkgIFChgeVOs.get(l).getChgCd())&&
															maxIFChgeVOs.get(k).getCurrCd().equals(bkgIFChgeVOs.get(l).getCurrCd())&&
																	maxIFChgeVOs.get(k).getPerTpCd().equals(bkgIFChgeVOs.get(l).getPerTpCd())&&
																		maxIFChgeVOs.get(k).getTrfRtAmt().equals(bkgIFChgeVOs.get(l).getTrfRtAmt())&&
																			maxIFChgeVOs.get(k).getRatAsCntrQty().equals(bkgIFChgeVOs.get(l).getRatAsCntrQty())){
														
														chgDivCnt = chgDivCnt + 1;
														
														if(!maxIFChgeVOs.get(k).getChgAmt().equals(bkgIFChgeVOs.get(l).getChgAmt())){
															divCnt = divCnt+1;
														}
													}
												}
											}
											
											if(chgDivCnt==0&&maxIFChgeVOs.size()>0){
												divCnt = divCnt+1;
											}
											
											if(chgDivCnt!=maxIFChgeVOs.size()){
												divCnt = divCnt+1;
											}										
											
											if(maxIFChgeVOs.size()!=bkgIFChgeVOs.size()){
												divCnt = divCnt+1;
											}
											
											// Max I/F and New I/F's VVD, Charge items comparison									
											if(divCnt>0){
												
												String cancelIfNo = "";
												
												//A/R Office is korean in case
												if(maxIFMainVOs.get(i).getLocCd().equals("KR")){
													int cnt = dbDao.checkDecWHF(maxIFMainVOs.get(i).getArIfNo());
													
													
													//Dec WHF is exist in case
													if(cnt>0){
														cancelIfNo = createMaxIFCancel(maxIFMainVOs.get(i).getArIfNo(),"Y", maxIFMainVOs.get(i).getCreUsrId(), vvdTrnsFlg);
														
														if(!cancelIfNo.equals("")){
															InvArIfNoVO ifNo = new InvArIfNoVO();
															ifNo.setIfNo(cancelIfNo);
															ifNos.add(ifNo);
														}
													
													//Dec WHF is not exist in case
													}else{
														cancelIfNo = createMaxIFCancel(maxIFMainVOs.get(i).getArIfNo(),"N", maxIFMainVOs.get(i).getCreUsrId(), vvdTrnsFlg);
														
														if(!cancelIfNo.equals("")){
															InvArIfNoVO ifNo = new InvArIfNoVO();
															ifNo.setIfNo(cancelIfNo);
															ifNos.add(ifNo);
														}
													}											
												
												//A/R Office is not korean in case.
												}else{
													cancelIfNo = createMaxIFCancel(maxIFMainVOs.get(i).getArIfNo(),"N", maxIFMainVOs.get(i).getCreUsrId(), vvdTrnsFlg);
													
													if(!cancelIfNo.equals("")){
														InvArIfNoVO ifNo = new InvArIfNoVO();
														ifNo.setIfNo(cancelIfNo);
														ifNos.add(ifNo);
													}
												}

												updCnt = dbDao.modifySysClearFlag(maxIFMainVOs.get(i).getArIfNo(),cancelIfNo, userId);
												
												// SysClear ifNo ERP send
												if(updCnt==2){
													InvArIfNoVO mainIfNoVo = new InvArIfNoVO();
													mainIfNoVo.setIfNo(maxIFMainVOs.get(i).getArIfNo());
													mainIfNos.add(mainIfNoVo);
												}
												
												invCreVos.get(j).setInvCreFlg("Y");
												invCreFlgCnt = invCreFlgCnt + 1;

											}else{
												invCreVos.get(j).setInvCreFlg("N");
											}
											
										//Max I/F's Good Date IS NULL in case	
										}else{
											dbDao.modifyDelCode(maxIFMainVOs.get(i).getArIfNo(), userId);
											invCreVos.get(j).setInvCreFlg("Y");
											invCreFlgCnt = invCreFlgCnt + 1;
										}
									
									//Max I/F's Delete Division Code = 'X' in case
									}else if(maxIFMainVOs.get(i).getInvDeltDivCd().equals("X")){
										invCreVos.get(j).setInvCreFlg("Y");
										invCreFlgCnt = invCreFlgCnt + 1;
									}
									
									// Change Container in case, Max IF update.
									if(invCreVos.get(j).getInvCreFlg().equals("N")&&cntrDiv.equals("Y")){
										
										List<InvBkgIfCntrVO> invBkgIfCntrVOs= dbDao.searchBkgIfContainerList(bkgNo,bkgSeq);
										List<InvArCntrVO> invArCntrVOs = new ArrayList<InvArCntrVO>();
										
										String troFlg = "";							
										troFlg = dbDao.searchTroFlag(bkgNo,bkgSeq)==null?"":dbDao.searchTroFlag(bkgNo,bkgSeq);
										String svrId = dbDao.searchServerID(invCreVos.get(j).getInvArMnVO().getArOfcCd());
										
										for(int k = 0 ; k< invBkgIfCntrVOs.size(); k++){
											InvArCntrVO invArCntrVO = new InvArCntrVO();
											String cntrSeq = invBkgIfCntrVOs.get(k).getCntrSeq();
											String cntrNo = invBkgIfCntrVOs.get(k).getCntrNo();
											String cntrTpszCd = invBkgIfCntrVOs.get(k).getCntrTpszCd();
											
											if(svrId.equals("EUR")&&troFlg.equals("Y")&&!invCreVos.get(j).getInvArMnVO().getBkgCorrNo().equals("")&&invCreVos.get(j).getInvArMnVO().getBkgCorrNo().length()==10){
												cntrNo = invBkgIfCntrVOs.get(k).getTroCntrNo();
												cntrTpszCd = invBkgIfCntrVOs.get(k).getTroCntrTpszCd();
											}
											
											invArCntrVO.setCntrSeq(cntrSeq);
											invArCntrVO.setCntrNo(cntrNo);
											invArCntrVO.setCntrTpszCd(cntrTpszCd);
											invArCntrVO.setArIfNo(maxIFMainVOs.get(i).getArIfNo());
											invArCntrVO.setCreUsrId(userId);
											invArCntrVO.setUpdUsrId(userId);
											
											invArCntrVOs.add(invArCntrVO);
										}									
										
										if(invArCntrVOs.size()>0){
											dbDao.removeARInvoiceContainer(maxIFMainVOs.get(i).getArIfNo());										
											dbDao.addInvContainer(invArCntrVOs, userId);
										}
									}
								}								
							}
							
							//Max I/F's A/R Office and new I/F's A/R Office is not in case
							if(ofcDivCnt==0){								
								
								// Max I/F's Delete Division Code = 'N' in case
								if(maxIFMainVOs.get(i).getInvDeltDivCd().equals("N")){
									String cancelIfNo = "";
									
									//Max I/F's Good Date IS NOT NULL in case
									if(!maxIFMainVOs.get(i).getBlInvCfmDt().equals("")){
									
										//A/R Office is korean in case
										if(maxIFMainVOs.get(i).getLocCd().equals("KR")){
											int cnt = dbDao.checkDecWHF(maxIFMainVOs.get(i).getArIfNo());
											
											
											//Dec WHF is exist in case.
											if(cnt>0){
												cancelIfNo = createMaxIFCancel(maxIFMainVOs.get(i).getArIfNo(),"Y", maxIFMainVOs.get(i).getCreUsrId(),vvdTrnsFlg);
												
												if(!cancelIfNo.equals("")){
													InvArIfNoVO ifNo = new InvArIfNoVO();
													ifNo.setIfNo(cancelIfNo);
													ifNos.add(ifNo);
												}
											
											//Dec WHF is not exist in case
											}else{
												cancelIfNo = createMaxIFCancel(maxIFMainVOs.get(i).getArIfNo(),"N", maxIFMainVOs.get(i).getCreUsrId(),vvdTrnsFlg);
												
												if(!cancelIfNo.equals("")){
													InvArIfNoVO ifNo = new InvArIfNoVO();
													ifNo.setIfNo(cancelIfNo);
													ifNos.add(ifNo);
												}
											}
											
										//A/R Office is not korean in case
										}else{
											cancelIfNo = createMaxIFCancel(maxIFMainVOs.get(i).getArIfNo(),"N", maxIFMainVOs.get(i).getCreUsrId(),vvdTrnsFlg);
											
											if(!cancelIfNo.equals("")){
												InvArIfNoVO ifNo = new InvArIfNoVO();
												ifNo.setIfNo(cancelIfNo);
												ifNos.add(ifNo);
											}
										}

										updCnt = dbDao.modifySysClearFlag(maxIFMainVOs.get(i).getArIfNo(),cancelIfNo, userId);
										
										// SysClear ifNo ERP send
										if(updCnt==2){
											InvArIfNoVO mainIfNoVo = new InvArIfNoVO();
											mainIfNoVo.setIfNo(maxIFMainVOs.get(i).getArIfNo());
											mainIfNos.add(mainIfNoVo);
										}
									
									// Same office is not exist and no good in case, delt_div_cd update.
									}else{
										dbDao.modifyDelCode(maxIFMainVOs.get(i).getArIfNo(), userId);
									}
									
								}
							}
							
						}
						*/
						
						//[New I/F 1...n] For 
						for( int i = 0; i < invCreVos.size(); i++ ){					
							//Invoice Create Flag is null in case, input 'Y'
							if(invCreVos.get(i).getInvCreFlg()==null){
								invCreVos.get(i).setInvCreFlg("Y");
								invCreFlgCnt = invCreFlgCnt + 1;
							}
						}

						// If data will creation on INV in new I/F.
						if(invCreFlgCnt>0){
							
							//[New I/F 1...n] For
							for( int i = 0; i < invCreVos.size(); i++ ){
								BKGMainDocVO bKGMainDocVO = dbDao.searchBKGInterface( bkgNo, bkgSeq ,invCreVos.get(i).getInvArMnVO().getSlsOfcCd());								
								
								// If INV target for creation
								if(invCreVos.get(i).getInvCreFlg().equals("Y")){
									invCreVos.get(i).getInvArMnVO().setTrnkVslCd(bKGMainDocVO.getTrnkVslCd());
									invCreVos.get(i).getInvArMnVO().setTrnkSkdVoyNo(bKGMainDocVO.getTrnkSkdVoyNo());
									invCreVos.get(i).getInvArMnVO().setTrnkSkdDirCd(bKGMainDocVO.getTrnkSkdDirCd());
									invCreVos.get(i).getInvArMnVO().setPorCd(bKGMainDocVO.getPorCd());
									invCreVos.get(i).getInvArMnVO().setDelCd(bKGMainDocVO.getDelCd());
									invCreVos.get(i).getInvArMnVO().setCgoWgt(bKGMainDocVO.getCgoWgt());
									invCreVos.get(i).getInvArMnVO().setCgoMeasQty(bKGMainDocVO.getCgoMeasQty());
									invCreVos.get(i).getInvArMnVO().setSrepCd(bKGMainDocVO.getSrepCd());
									invCreVos.get(i).getInvArMnVO().setDestTrnsSvcModCd(bKGMainDocVO.getDestSvcModCd());
									invCreVos.get(i).getInvArMnVO().setMstBlNo(bKGMainDocVO.getMstBlNo());
									invCreVos.get(i).getInvArMnVO().setBkgRefNo(bKGMainDocVO.getBkgRefNo());
									invCreVos.get(i).getInvArMnVO().setInvRefNo(bKGMainDocVO.getInvRefNo());
									invCreVos.get(i).getInvArMnVO().setSiRefNo(bKGMainDocVO.getSiRefNo());
									invCreVos.get(i).getInvArMnVO().setFrtFwrdCntCd(bKGMainDocVO.getFrtFwrdCntCd());
									invCreVos.get(i).getInvArMnVO().setFrtFwrdCustSeq(bKGMainDocVO.getFrtFwrdCustSeq());
									invCreVos.get(i).getInvArMnVO().setScNo(bKGMainDocVO.getScNo());
									invCreVos.get(i).getInvArMnVO().setRfaNo(bKGMainDocVO.getRfaNo());
									invCreVos.get(i).getInvArMnVO().setBkgTeuQty(bKGMainDocVO.getBkgTeuQty());
									invCreVos.get(i).getInvArMnVO().setBkgFeuQty(bKGMainDocVO.getBkgFeuQty());
									invCreVos.get(i).getInvArMnVO().setBkgCorrNo(bKGMainDocVO.getBkgCorrNo());
									invCreVos.get(i).getInvArMnVO().setBkgCorrDt(bKGMainDocVO.getBkgCorrDt());
									invCreVos.get(i).getInvArMnVO().setCxlFlg(bKGMainDocVO.getCxlFlg());
									invCreVos.get(i).getInvArMnVO().setBkgSeq(bkgSeq);

									invCreVos.get(i).getInvArMnVO().setObrdDt(bKGMainDocVO.getObrdDt());
 
									invCreVos.get(i).getInvArMnVO().setCtrtOfcCd(bKGMainDocVO.getCtrtOfcCd());
									invCreVos.get(i).getInvArMnVO().setOtsPayCd(bKGMainDocVO.getOtsPayCd());
									invCreVos.get(i).getInvArMnVO().setIssDt(bKGMainDocVO.getInvDt());
									
									/*
									// If A/R Office is korean
									if(invCreVos.get(i).getLocCd().substring(0,2).equals("KR")){
										
										// If WHF CANCEL
										if(bLNoBKGStatusVO.getWhfDeclCxlFlg().equals("Y")){
											
											// Same Whf Decl No on BKG checking
											int whfDeclNoCnt = dbDao.checkExistsDecWHFByBL(blSrcNo, invCreVos.get(i).getInvArMnVO().getArOfcCd(),bKGMainDocVO.getWhfDeclNo());
											
											if(whfDeclNoCnt > 0 && bKGMainDocVO.getWhfFlg().equals("Y")){
												dbDao.modifyWhfDeclNo(blSrcNo, invCreVos.get(i).getInvArMnVO().getArOfcCd(), bKGMainDocVO.getWhfDeclNo(), bkgUserId);
																								
												invCreVos.get(i).getInvArMnVO().setWhfFlg("C");
												invCreVos.get(i).getInvArMnVO().setInvRmk(bKGMainDocVO.getWhfDeclNo());
												
												//WHF_FLG 'Y' in case WHF CHG
												List<InvArChgVO> invArWhfChgVOs = new ArrayList<InvArChgVO>();		
												
												for(int j = 0 ; j < invCreVos.get(i).getInvArChgVOs().size(); j++){
													if(!invCreVos.get(i).getInvArChgVOs().get(j).getChgCd().equals("WHF")){												
														invArWhfChgVOs.add(invCreVos.get(i).getInvArChgVOs().get(j));												
													} else {
														if(invCreVos.get(i).getInvArChgVOs().get(j).getWhfFlg().equals("Y")){
															invArWhfChgVOs.add(invCreVos.get(i).getInvArChgVOs().get(j));			
														}
													}
												}
												
												invCreVos.get(i).setInvArChgVOs(invArWhfChgVOs);
											} else { 
												List<InvArChgVO> invArWhfChgVOs = new ArrayList<InvArChgVO>();		
												
												for(int j = 0 ; j < invCreVos.get(i).getInvArChgVOs().size(); j++){
													//Charge item WHF include row delete
													if(!invCreVos.get(i).getInvArChgVOs().get(j).getChgCd().equals("WHF")){												
														//invCreVos.get(i).getInvArChgVOs().remove(invCreVos.get(i).getInvArChgVOs().get(j));
														invArWhfChgVOs.add(invCreVos.get(i).getInvArChgVOs().get(j));												
													}
												}
												
												invCreVos.get(i).setInvArChgVOs(invArWhfChgVOs);
											}
											
										} else {									
										
											// Same Whf Decl No checking
											int whfDeclNoCnt = dbDao.checkExistsDecWHFByBL(blSrcNo, invCreVos.get(i).getInvArMnVO().getArOfcCd(),bKGMainDocVO.getWhfDeclNo());

											if(whfDeclNoCnt==0&&bKGMainDocVO.getWhfFlg().equals("Y")){
												//A/R Office is korean 
												invCreVos.get(i).getInvArMnVO().setWhfDeclNo(bKGMainDocVO.getWhfDeclNo());
												invCreVos.get(i).getInvArMnVO().setWhfDeclCfmDt(bKGMainDocVO.getWhfDeclCfmDt());
												invCreVos.get(i).getInvArMnVO().setWhfDeclOfcCd(bKGMainDocVO.getWhfDeclOfcCd());
												invCreVos.get(i).getInvArMnVO().setWhfMrnNo(bKGMainDocVO.getWhfMrnNo());
												invCreVos.get(i).getInvArMnVO().setWhfDeclVslCd(bKGMainDocVO.getWhfDeclVslCd());
												invCreVos.get(i).getInvArMnVO().setWhfDeclVoyNo(bKGMainDocVO.getWhfDeclVoyNo());
												invCreVos.get(i).getInvArMnVO().setWhfDeclDirCd(bKGMainDocVO.getWhfDeclDirCd());
												invCreVos.get(i).getInvArMnVO().setWhfNtcNo(bKGMainDocVO.getWhfNtcNo());
												invCreVos.get(i).getInvArMnVO().setWhfFlg(bKGMainDocVO.getWhfFlg());
												invCreVos.get(i).getInvArMnVO().setCsrNo(bKGMainDocVO.getCsrNo());	
												
												// WHF_FLG 'Y' WHF CHG
												List<InvArChgVO> invArWhfChgVOs = new ArrayList<InvArChgVO>();		
												
												for(int j = 0 ; j < invCreVos.get(i).getInvArChgVOs().size(); j++){
													if(!invCreVos.get(i).getInvArChgVOs().get(j).getChgCd().equals("WHF")){												
														invArWhfChgVOs.add(invCreVos.get(i).getInvArChgVOs().get(j));												
													} else {
														if(invCreVos.get(i).getInvArChgVOs().get(j).getWhfFlg().equals("Y")){
															invArWhfChgVOs.add(invCreVos.get(i).getInvArChgVOs().get(j));			
														}
													}
												}
												
												invCreVos.get(i).setInvArChgVOs(invArWhfChgVOs);
											}
											
											int whfCnt = dbDao.checkDecWHFByBL(blSrcNo, invCreVos.get(i).getInvArMnVO().getArOfcCd());
											
											// If Dec WHF is exist
											if(whfCnt>0){	
												//2009-11-26 WHF update.
												dbDao.modifyWhfNtcNo(blSrcNo, invCreVos.get(i).getInvArMnVO().getArOfcCd(), bKGMainDocVO.getWhfNtcNo(), bKGMainDocVO.getWhfDeclNo());
																						

												if(bKGMainDocVO.getWhfDeclNo().equals("")||whfDeclNoCnt>0){
													List<InvArChgVO> invArWhfChgVOs = new ArrayList<InvArChgVO>();		
													
													for(int j = 0 ; j < invCreVos.get(i).getInvArChgVOs().size(); j++){
														// Charge item WHF include row delete
														if(!invCreVos.get(i).getInvArChgVOs().get(j).getChgCd().equals("WHF")){												
															//invCreVos.get(i).getInvArChgVOs().remove(invCreVos.get(i).getInvArChgVOs().get(j));
															invArWhfChgVOs.add(invCreVos.get(i).getInvArChgVOs().get(j));												
														}
													}
													
													invCreVos.get(i).setInvArChgVOs(invArWhfChgVOs);
												}																				
											}
										
										}
									}
									*/
									
									ARCreditInputVO arCrdtVo = new ARCreditInputVO();
									arCrdtVo.setActCustCntCd(invCreVos.get(i).getInvArMnVO().getActCustCntCd());
									arCrdtVo.setActCustSeq(invCreVos.get(i).getInvArMnVO().getActCustSeq());
									arCrdtVo.setSailArrDt(invCreVos.get(i).getInvArMnVO().getIssDt());
									arCrdtVo.setIoBndCd(invCreVos.get(i).getInvArMnVO().getIoBndCd());
									arCrdtVo.setDestTrnsSvcModCd(invCreVos.get(i).getInvArMnVO().getDestTrnsSvcModCd());
									arCrdtVo.setArOfcCd(invCreVos.get(i).getInvArMnVO().getArOfcCd());
									arCrdtVo.setLocCd(invCreVos.get(i).getLocCd().substring(0,2));
									arCrdtVo.setDelCd(invCreVos.get(i).getInvArMnVO().getDelCd());
									
									ARCreditVO aRCreditVO = searchARCredit(arCrdtVo);
									
									if(aRCreditVO != null){
										invCreVos.get(i).getInvArMnVO().setDueDt(aRCreditVO.getDueDt());
										invCreVos.get(i).getInvArMnVO().setCrTermDys(aRCreditVO.getCrTerm());
										invCreVos.get(i).getInvArMnVO().setCustCrFlg(aRCreditVO.getCrFlg());
									}
									
									/*
									if(!bKGMainDocVO.getBkgCorrNo().equals("")){
										if(bKGMainDocVO.getCaRsnCd().equals("E")||bKGMainDocVO.getCaRsnCd().equals("F")){
											invCreVos.get(i).getInvArMnVO().setTrspRqstOrdFlg("Y");
										}
									}
									*/
									
									//String zoneIOC = dbDao.searchZoneIOC(invCreVos.get(i).getInvArMnVO().getPolCd(), invCreVos.get(i).getInvArMnVO().getPodCd());
									invCreVos.get(i).getInvArMnVO().setZnIocCd("");
									
									//String cityCd = dbDao.searchCityCd(invCreVos.get(i).getInvArMnVO().getArOfcCd()); 
									invCreVos.get(i).getInvArMnVO().setArCtyCd("");
									
									//String bdrIndFlg = bKGMainDocVO.getBdrIndFlg();	
									String revTpCd = "";
									String revSrcCd = "";
									
									REVTypeSourceVO revTypeSrcVo = dbDao.searchREVTypeSource("BKG", bkgNo, bkgSeq, "");
							        
									if (revTypeSrcVo != null) {
								        revTpCd = revTypeSrcVo.getRevTpCd();
								        revSrcCd = revTypeSrcVo.getRevSrcCd();
							        } 
							        
									/*
									// DELT FLG is not 'Y' in case chechking IFNO
									int fisrtFlg = dbDao.checkFirstInterface(invCreVos.get(i).getInvArMnVO().getBlSrcNo(), invCreVos.get(i).getInvArMnVO().getArOfcCd());
									
									if(fisrtFlg==0){
										if(bKGMainDocVO.getBkgCorrNo().equals("")){
											revTpCd = bdrIndFlg.equals("N")?"B":"C";
											revSrcCd = bdrIndFlg.equals("N")?"BL":"CA";
										}else{
											revTpCd = bdrIndFlg.equals("N")?"B":"C";
											revSrcCd = bdrIndFlg.equals("N")?"CS":"CA";
										}
									}else{
										revTpCd = bdrIndFlg.equals("N")?"B":"C";
										revSrcCd = bdrIndFlg.equals("N")?"CS":"CA";
									}
									*/
									
									invCreVos.get(i).getInvArMnVO().setRevTpCd(revTpCd);
									invCreVos.get(i).getInvArMnVO().setRevSrcCd(revSrcCd);
									
									String glEffDt = invCreVos.get(i).getInvArMnVO().getSailDt();  //dbDao.searchEffectiveDate(invCreVos.get(i).getInvArMnVO().getArOfcCd(), invCreVos.get(i).getInvArMnVO().getSailDt(), revTpCd, revSrcCd);
									invCreVos.get(i).getInvArMnVO().setGlEffDt(glEffDt);
									invCreVos.get(i).getInvArMnVO().setAcctXchRtYrmon(glEffDt.length()==8?glEffDt.substring(0,6):"");
									
									
									//String troFlg = "";
									
									//troFlg = dbDao.searchTroFlag(bkgNo,bkgSeq)==null?"":dbDao.searchTroFlag(bkgNo,bkgSeq);	
									
									String invCoaInterCoCd =  "";  //dbDao.searchInterCompany(invCreVos.get(i).getInvArMnVO().getActCustCntCd(),invCreVos.get(i).getInvArMnVO().getActCustSeq());	
									
									//CoaVO coaVO = dbDao.searchCOA(invCreVos.get(i).getInvArMnVO().getArOfcCd());
									
									String invCoaCoCd = "";
									String invCoaCtrCd = "";
									String invCoaRgnCd = "";
									
									/*
									if(coaVO!=null){
										invCoaCoCd = coaVO.getInvCoaCoCd()!=null?coaVO.getInvCoaCoCd():"";
										invCoaCtrCd = coaVO.getInvCoaCtrCd()!=null?coaVO.getInvCoaCtrCd():"";
										invCoaRgnCd = coaVO.getInvCoaRgnCd()!=null?coaVO.getInvCoaRgnCd():"";
									}
									*/
									
									//String svrId = dbDao.searchServerID(invCreVos.get(i).getInvArMnVO().getArOfcCd());
									
									//String acct_div_cd = dbDao.searchAccountDivision(revTpCd + revSrcCd);
									String revCoaAcctCd ="";
									String revCoaVslCd = "";
									String revCoaVoyNo = "";
									String revCoaSkdDirCd = "";
									String revCoaDirCd = "";
									String acctCd = "";
									
									//String arTaxIndCd = dbDao.searchArTaxInd( bkgNo,  bkgSeq, invCreVos.get(i).getInvArMnVO().getSlsOfcCd());
									
									invCreVos.get(i).getInvArMnVO().setArTaxIndCd("");
									
									for(int j = 0 ; j < invCreVos.get(i).getInvArChgVOs().size(); j++){
										//String repChgCd = dbDao.searchRepCharge(invCreVos.get(i).getInvArChgVOs().get(j).getChgCd());
										
										invCreVos.get(i).getInvArChgVOs().get(j).setRepChgCd("");
										
										//String chgFullNm= dbDao.searchChargeName(invCreVos.get(i).getInvArChgVOs().get(j).getChgCd());
										invCreVos.get(i).getInvArChgVOs().get(j).setChgFullNm("");								
										
										/*
										// If Account Division Code = 'P'
										if (acct_div_cd.equals("P")) {
											acctCd = dbDao.searchAccountCdFromCharge(invCreVos.get(i).getInvArChgVOs().get(j).getChgCd());
										} else {
											acctCd = dbDao.searchAccountCdFromRevAcct(invCreVos.get(i).getInvArChgVOs().get(j).getChgCd());
										}

										acctCd = dbDao.searchAccountCd( invCreVos.get(i).getInvArMnVO().getArOfcCd(), invCreVos.get(i).getInvArChgVOs().get(j).getChgCd(), revTpCd , revSrcCd, svrId,  acctCd);
										
										revCoaAcctCd = dbDao.searchRevCoaAcctCd( invCreVos.get(i).getInvArMnVO().getArOfcCd(), invCreVos.get(i).getInvArChgVOs().get(j).getChgCd(), revTpCd , revSrcCd, svrId,  acctCd);
										*/
										
										revCoaVslCd = invCreVos.get(i).getInvArMnVO().getRevVslCd().equals("")?"":invCreVos.get(i).getInvArMnVO().getRevVslCd();
										revCoaVoyNo = invCreVos.get(i).getInvArMnVO().getRevSkdVoyNo().equals("")?"":invCreVos.get(i).getInvArMnVO().getRevSkdVoyNo();
										revCoaSkdDirCd = invCreVos.get(i).getInvArMnVO().getRevSkdDirCd().equals("")?"":invCreVos.get(i).getInvArMnVO().getRevSkdDirCd();
										revCoaDirCd = invCreVos.get(i).getInvArMnVO().getRevDirCd().equals("")?"":invCreVos.get(i).getInvArMnVO().getRevDirCd();
																				
										invCreVos.get(i).getInvArChgVOs().get(j).setAcctCd(acctCd);	
										invCreVos.get(i).getInvArChgVOs().get(j).setRevCoaInterCoCd(invCoaInterCoCd);
										invCreVos.get(i).getInvArChgVOs().get(j).setRevCoaCoCd(invCoaCoCd);
										invCreVos.get(i).getInvArChgVOs().get(j).setRevCoaCtrCd(invCoaCtrCd);
										invCreVos.get(i).getInvArChgVOs().get(j).setRevCoaRgnCd(invCoaRgnCd);
										invCreVos.get(i).getInvArChgVOs().get(j).setRevCoaAcctCd(revCoaAcctCd);
										invCreVos.get(i).getInvArChgVOs().get(j).setRevCoaVslCd(revCoaVslCd);
										invCreVos.get(i).getInvArChgVOs().get(j).setRevCoaVoyNo(revCoaVoyNo);
										invCreVos.get(i).getInvArChgVOs().get(j).setRevCoaSkdDirCd(revCoaSkdDirCd);
										invCreVos.get(i).getInvArChgVOs().get(j).setRevCoaDirCd(revCoaDirCd);								
									}
									
									/*
									List<InvBkgIfCntrVO> invBkgIfCntrVOs= dbDao.searchBkgIfContainerList(bkgNo,bkgSeq);
									List<InvArCntrVO> invArCntrVOs = new ArrayList<InvArCntrVO>();
									for(int j = 0 ; j < invBkgIfCntrVOs.size(); j++){
										InvArCntrVO invArCntrVO = new InvArCntrVO();
										String cntrSeq = invBkgIfCntrVOs.get(j).getCntrSeq();
										String cntrNo = invBkgIfCntrVOs.get(j).getCntrNo();
										String cntrTpszCd = invBkgIfCntrVOs.get(j).getCntrTpszCd();
										
										if(svrId.equals("EUR")&&troFlg.equals("Y")&&!bKGMainDocVO.getBkgCorrNo().equals("")&&bKGMainDocVO.getBkgCorrNo().length()==10){
											cntrNo = invBkgIfCntrVOs.get(j).getTroCntrNo();
											cntrTpszCd = invBkgIfCntrVOs.get(j).getTroCntrTpszCd();
										}
										
										invArCntrVO.setCntrSeq(cntrSeq);
										invArCntrVO.setCntrNo(cntrNo);
										invArCntrVO.setCntrTpszCd(cntrTpszCd);
										
										invArCntrVOs.add(invArCntrVO);
									}
									
									invCreVos.get(i).setInvArCntrVOs(invArCntrVOs);
									*/
									
									String newIfNo = createBKGInvoice(invCreVos.get(i), bkgUserId);
	
									if(!newIfNo.equals("")){
										InvArIfNoVO ifNo = new InvArIfNoVO();
										ifNo.setIfNo(newIfNo);
										ifNos.add(ifNo);
			
										dbDao.modifyInvArIfStatus(bkgNo,bkgSeq, "Y", new ErrorHandler("INV00187", new String[] {}).getUserMessage(), bkgUserId);
									} else {
										return null;
									}
								}					
							}
						}else{
							dbDao.modifyInvArIfStatus(bkgNo,bkgSeq, "X", new ErrorHandler("INV00188", new String[] {}).getUserMessage(), bkgUserId);
						}
				//	}

				}
			}
			
			if(ifNos!= null && ifNos.size()>0){
				command.createOutstandingInfo(ifNos);
			}
			
			return null;
			
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Interface from other migration<br>
	 * 
	 * @param ARInterfaceCreationVO genIfVo
	 * @return String
	 * @exception EventException
	 */
	public String interfaceGeneralARInvoiceToINV(ARInterfaceCreationVO genIfVo) throws EventException{

		AccountReceivableOutstandingMigrationBC command = new AccountReceivableOutstandingMigrationBCImpl();
		//List<ARInterfaceCreationVO> genIfVos = new ArrayList<ARInterfaceCreationVO>(); 
		//ARInterfaceCreationVO genIfVo = null;
		//List <InvArIfMnVO> invArIfMnVOs = new ArrayList<InvArIfMnVO>();
		//List <InvArIfChgVO> invArIfChgVOs = null;
		//InvArIfMnVO invArIfMnVO = new InvArIfMnVO();
		InvArMnVO invArMnVo = null;
		//List<InvArIfChgVO> invArIfChgVOs = new ArrayList<InvArIfChgVO>();
		List<InvArChgVO> invArChgVos = null;
		InvArChgVO invArChgVo = null;
		//InvArAmtVO invArAmtVo = null;
		MdmOrganizationVO mdmOrgVo = null;
		//MdmCustomerVO mdmCustVo = null;
		//VVDCustomerVO vvdCustomerVo = null;
		BkgVvdVO bkgVvdVo = null;
		VskVslPortSkdVO vskVslPortSkdVo = null;
		//ExchangeRateVO exchangeRateVo = null;
		REVTypeSourceVO revTypeSrcVo = null;
		ARCreditVO aRCreditVO = new ARCreditVO();
		ARCreditInputVO arCrdtVo = new ARCreditInputVO();
		List<InvArIssDtlVO> invArIssDtlVOs = null;
		String ofcCd = "";
		String srcIfDt = "";
		String srcIfSeq = "";
		String vslCd = "";
		String skdVoyNo = "";
		String skdDirCd = "";
		String port = "";
		String trnkSkdVoyNo = "";
		String trnkVslCd = "";
		String trnkSkdDirCd = "";
		//String rgnCdPor = "";
		//String rgnCdDel = "";
		String svcScpCd = "";
		String sailDt = "";
		String sailArrDt = "";
		String slanCd = "";
		String dueDt = "";
		String glEffDt = "";
		String blInvCfmDt = "";
		String bkgNo = "";
		String ioBndCd = "";
		String porCd = "";
		String polCd = "";
		String podCd = "";
		String delCd = "";
		String errRsn = "";
		//String errFlag = "N";
		String locCd = "";
		String lclCurr = "";
		String arOfcCd = "";
		//String dmdtInvAplyBlFlg = "";
		//String arInvIssFlg = "";
		String ifFlag = "";
		String localTime = "";
    	String crTermDys="";
	    String custCrFlg="";
	    String usdXchRt="0";
        String revTpCd = "M";
        String revSrcCd = "TM";
        String arIfNo = "";
       // String chgFullNm = "";	
        //String erpIfOfcCd = "";
        String acctCd = "";
        String invRevTpSrcCd = "";
        String invXchRt = "0";
        String invUsdXchRt = "0";
        String tjSrcNm = "";
        String zoneIoc = "";
        String invCoaRgnCd = "";
        String invCoaCtrCd = "";
       // StringBuffer arIfNos = new StringBuffer("");
        String blSrcNo = "";
        String newBkgNo = "";
        String newInvNo = "";
       // String noGoodFlg = "N";
        String otsPayCd = "";
		
		try {

			ofcCd = genIfVo.getInvArIfMnVO().getOfcCd();
			srcIfDt = genIfVo.getInvArIfMnVO().getSrcIfDt();
			srcIfSeq = genIfVo.getInvArIfMnVO().getSrcIfSeq();	
			newBkgNo = dbDao.searchMaxBKGNo("AR", srcIfDt, srcIfSeq, ofcCd);
			
			vslCd = genIfVo.getInvArIfMnVO().getVslCd() != null ? genIfVo.getInvArIfMnVO().getVslCd() : ""; ///// Main
			skdVoyNo = genIfVo.getInvArIfMnVO().getSkdVoyNo() != null ? genIfVo.getInvArIfMnVO().getSkdVoyNo() : ""; ///// Main
			skdDirCd = genIfVo.getInvArIfMnVO().getSkdDirCd() != null ? genIfVo.getInvArIfMnVO().getSkdDirCd() : ""; ///// Main
			port = genIfVo.getInvArIfMnVO().getIoBndCd().equals("O") ? genIfVo.getInvArIfMnVO().getPolCd() : genIfVo.getInvArIfMnVO().getPodCd(); ///// Main
			trnkSkdVoyNo = genIfVo.getInvArIfMnVO().getTrnkSkdVoyNo() != null ? genIfVo.getInvArIfMnVO().getTrnkSkdVoyNo() : ""; ///// Main
			trnkVslCd = genIfVo.getInvArIfMnVO().getTrnkVslCd() != null ? genIfVo.getInvArIfMnVO().getTrnkVslCd() : ""; ///// Main
			trnkSkdDirCd = genIfVo.getInvArIfMnVO().getTrnkSkdDirCd() != null ? genIfVo.getInvArIfMnVO().getTrnkSkdDirCd() : ""; ///// Main
			//rgnCdPor = genIfVo.getInvArIfMnVO().getPorCd();
	        //rgnCdDel = genIfVo.getInvArIfMnVO().getDelCd();
	        svcScpCd = genIfVo.getInvArIfMnVO().getSvcScpCd();
	        sailDt = genIfVo.getInvArIfMnVO().getSailDt();
	        sailArrDt = genIfVo.getInvArIfMnVO().getSailArrDt();
	        slanCd = genIfVo.getInvArIfMnVO().getSlanCd();
	        dueDt = genIfVo.getInvArIfMnVO().getDueDt();
	        glEffDt = genIfVo.getInvArIfMnVO().getGlEffDt();
	        bkgNo = genIfVo.getInvArIfMnVO().getBkgNo() != null ? genIfVo.getInvArIfMnVO().getBkgNo() : "";		        
	        //tsDivCd = genIfVo.getInvArIfMnVO().getDestTrnsSvcModCd()!= null ? genIfVo.getInvArIfMnVO().getDestTrnsSvcModCd(): "";
	        //ofcTrnsFlg = genIfVo.getInvArIfMnVO().getOfcTrnsFlg()!= null ? genIfVo.getInvArIfMnVO().getOfcTrnsFlg(): "";
	        ioBndCd = genIfVo.getInvArIfMnVO().getIoBndCd()!= null ? genIfVo.getInvArIfMnVO().getIoBndCd(): "";
	        porCd = genIfVo.getInvArIfMnVO().getPorCd()!= null ? genIfVo.getInvArIfMnVO().getPorCd(): "";
	        polCd = genIfVo.getInvArIfMnVO().getPolCd()!= null ? genIfVo.getInvArIfMnVO().getPolCd(): "";
	        podCd = genIfVo.getInvArIfMnVO().getPodCd()!= null ? genIfVo.getInvArIfMnVO().getPodCd(): "";
	        delCd = genIfVo.getInvArIfMnVO().getDelCd()!= null ? genIfVo.getInvArIfMnVO().getDelCd(): "";
	        blSrcNo = genIfVo.getInvArIfMnVO().getBlSrcNo();
	        otsPayCd = genIfVo.getInvArIfMnVO().getOtsPayCd();
	        
	        /*
			if(genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET")){
				int dupCnt = dbDao.searchLastDMTInvNo(blSrcNo);
				
				if( dupCnt > 0 ){
					errRsn =  new ErrorHandler("INV00017", new String[] {}).getUserMessage();
					dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
					errFlag = "Y";
					break;		
				}
			}
			*/
	        
			// genIfVo looping start
			for (int idx = 0; idx < 1; idx++) {
				
				if (genIfVo.getInvArIfMnVO().getOfcCd().equals("")) {
					errRsn = new ErrorHandler("INV00075", new String[] {}).getUserMessage();
					dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
					//errFlag = "Y";
					return null;						
				}					
				
				if (bkgNo.equals("")) {
					errRsn = new ErrorHandler("PRD00071", new String[] {}).getUserMessage();
					dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
					//errFlag = "Y";
					return null;						
				}	
				
				if (genIfVo.getInvArIfChgVOs() != null) {
					
					int cnt = 0;
					String chgCd = "";
					String trfRtAmt = "";
					String ratAsCntrQty = "";
					String chgAmt = "";
					String currCd = "";
					invArChgVos = new ArrayList<InvArChgVO>();
					for (int rowNum2 = 0; rowNum2 < genIfVo.getInvArIfChgVOs().size(); rowNum2++) {
						
						trfRtAmt = genIfVo.getInvArIfChgVOs().get(rowNum2).getTrfRtAmt() != null ? genIfVo.getInvArIfChgVOs().get(rowNum2).getTrfRtAmt() : "" ;
						chgCd = genIfVo.getInvArIfChgVOs().get(rowNum2).getChgCd() != null ? genIfVo.getInvArIfChgVOs().get(rowNum2).getChgCd() : "";
						ratAsCntrQty = genIfVo.getInvArIfChgVOs().get(rowNum2).getRatAsCntrQty() != null ? genIfVo.getInvArIfChgVOs().get(rowNum2).getRatAsCntrQty() : "";
						chgAmt = genIfVo.getInvArIfChgVOs().get(rowNum2).getChgAmt() != null ? genIfVo.getInvArIfChgVOs().get(rowNum2).getChgAmt() : "";
						currCd = genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd() != null ? genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd() : "";
						
                        if (chgCd.equals("") || chgCd.equals("0")) {
                        	errRsn = new ErrorHandler("BKG00897", new String[] {}).getUserMessage();
                        	cnt++;
                        }
                        
                        if (currCd.equals("") || currCd.equals("0")) {
                        	errRsn = new ErrorHandler("BKG00898", new String[] {}).getUserMessage();
                        	cnt++;
                        }
					 	
                        
                        if (trfRtAmt.equals("") || trfRtAmt.equals("0")) {
                        	errRsn = new ErrorHandler("BKG00899", new String[] {}).getUserMessage();
                        	cnt++;
                        }
                        
                        if (ratAsCntrQty.equals("") || ratAsCntrQty.equals("0")) {
                        	errRsn = new ErrorHandler("BKG00900", new String[] {}).getUserMessage();
                        	cnt++;
                        }
                        
                        if (chgAmt.equals("") || chgAmt.equals("0")) {
                        	errRsn = new ErrorHandler("BKG08116", new String[] {}).getUserMessage();
                        	cnt++;
                        }	
						
					}
					
					if (cnt > 0) {
						dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
						//errFlag = "Y";
						return null;
					}
				}
				
				// bl_no exist check
				// charge exist check
				ifFlag = dbDao.searchInterfaceMain(srcIfDt, srcIfSeq);
				
				if (ifFlag.equals("NO_BL")) {
					// Error check #1
					errRsn = new ErrorHandler("INV00173", new String[] {}).getUserMessage();
					dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
					//errFlag = "Y";
					return null;
					
				} else if (ifFlag.equals("NO_CHG")) {
					// Error check #2
					errRsn = new ErrorHandler("INV00177", new String[] {}).getUserMessage();
					dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
					//errFlag = "Y";
					return null;
				}
				
				localTime = dbDao.searchLocalTime(genIfVo.getInvArIfMnVO().getOfcCd());
				
				mdmOrgVo = dbDao.searchOfficeAttribute(genIfVo.getInvArIfMnVO().getIfSrcCd(), genIfVo.getInvArIfMnVO().getOfcCd());
				// -- Add : 2009.12.22 ------------------------------------------------
				if(mdmOrgVo == null) {
					errRsn = new ErrorHandler("INV00075", new String[] {}).getUserMessage();
					dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
					//errFlag = "Y";
					return null;
				}
				// ------------------------------------------------------------------------
				
		        //rhq = mdmOrgVo.getArHdQtrOfcCd(); ///// Main
		        lclCurr = mdmOrgVo.getArCurrCd(); ///// Main
		        arOfcCd = mdmOrgVo.getOfcCd();
		        //ofcAgentMark = mdmOrgVo.getArAgnStlCd();
		        //dmdtInvAplyBlFlg = mdmOrgVo.getDeltFlg();
		        //arInvIssFlg = mdmOrgVo.getSubAgnFlg();
		        //otsSmryCd = mdmOrgVo.getOfcSlsDeltFlg();
		        //cntCd = mdmOrgVo.getLocCd().substring(0,2);
		        	
		       /*
				if(tsDivCd.equals("TSP")){//2010-08-12 DEM/DET VVD logic add.(2ND)
					if ((genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET"))){
											
						bkgVvdVo = dbDao.searchBkgVvd(ioBndCd, bkgNo);
						//2010-08-03 null check
						if(bkgVvdVo != null){
							vslCd = bkgVvdVo.getVslCd(); 
							skdVoyNo = bkgVvdVo.getSkdVoyNo(); 
					        skdDirCd = bkgVvdVo.getSkdDirCd(); 
					        port = bkgVvdVo.getPolCd(); 
						}

				        if (dbDao.searchVskVslSkd(vslCd, skdVoyNo, skdDirCd, port).equals("")){
				        	if(!vslCd.equals("CFDR") && !vslCd.equals("CNTC")) {
				        		vslCd = genIfVo.getInvArIfMnVO().getVslCd() != null ? genIfVo.getInvArIfMnVO().getVslCd() : ""; ///// Main
								skdVoyNo = genIfVo.getInvArIfMnVO().getSkdVoyNo() != null ? genIfVo.getInvArIfMnVO().getSkdVoyNo() : ""; ///// Main
								skdDirCd = genIfVo.getInvArIfMnVO().getSkdDirCd() != null ? genIfVo.getInvArIfMnVO().getSkdDirCd() : ""; ///// Main
								port = ioBndCd.equals("O") ? polCd : podCd; ///// Main								
				        	}
				        }						
					}
				}
				*/
		       
		        /*
				sailDt = genIfVo.getInvArIfMnVO().getSailDt() == null ? "" : genIfVo.getInvArIfMnVO().getSailDt();
				if (sailDt.equals("")) {
					sailDt = dbDao.searchSailingDateByVvd(vslCd, skdVoyNo, skdDirCd, port);
				}
				*/

		        if(vslCd.equals("")){
					// error #4
					errRsn = new ErrorHandler("INV00160", new String[] {}).getUserMessage();
					dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
					//errFlag = "Y";
					return null;
				}
		        
				if(!("CFDR").equals(vslCd)){
					if(("").equals(port)){
						errRsn = new ErrorHandler("INV00050", new String[] {}).getUserMessage();
						dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
						//errFlag = "Y";
						return null;
					}else{
						if (("").equals(dbDao.searchVskVslSkd(vslCd, skdVoyNo, skdDirCd, port))){
							bkgVvdVo = dbDao.searchArMstRevVvdTml();
							vslCd = bkgVvdVo.getVslCd();
							skdVoyNo = bkgVvdVo.getSkdVoyNo();
					        skdDirCd = bkgVvdVo.getSkdDirCd();
						}
					}
				}
				/*
				else {
					bkgVvdVo = dbDao.searchArMstRevVvdTml();
					vslCd = bkgVvdVo.getVslCd();
					skdVoyNo = bkgVvdVo.getSkdVoyNo();
			        skdDirCd = bkgVvdVo.getSkdDirCd();
			        
			        if(vslCd.equals("")){
						// error #4
						errRsn = new ErrorHandler("INV00160", new String[] {}).getUserMessage();
						dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
						//errFlag = "Y";
						return null;
					}
				}
				*/
				
				/*
				if (dbDao.searchVskVslSkd(vslCd, skdVoyNo, skdDirCd, port).equals("")){
					if (genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET")) {
						bkgVvdVo = dbDao.searchArMstRevVvdTml();
						vslCd = bkgVvdVo.getVslCd();
						skdVoyNo = bkgVvdVo.getSkdVoyNo();
				        skdDirCd = bkgVvdVo.getSkdDirCd();
					} else {							
						if (dbDao.searchArMstRevVvd(vslCd, skdVoyNo, skdDirCd).equals("")){
							if (genIfVo.getInvArIfMnVO().getIfSrcCd().equals("TML")) {
								bkgVvdVo = dbDao.searchArMstRevVvdTml();
								vslCd = bkgVvdVo.getVslCd();
								skdVoyNo = bkgVvdVo.getSkdVoyNo();
						        skdDirCd = bkgVvdVo.getSkdDirCd();
							} else {
								// error #4
								errRsn = new ErrorHandler("INV00160", new String[] {}).getUserMessage();
								dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
								errFlag = "Y";
								break;
							}
						}
					}					
				}

				if(ofcTrnsFlg.equals("Y")){
					InvArMnVO maxVVDVO = dbDao.searchVVDForMaxINVInterface(genIfVo.getInvArIfMnVO().getBlSrcNo(), arOfcCd);
					
					if( maxVVDVO != null ){
						vslCd = maxVVDVO.getVslCd();
						skdVoyNo = maxVVDVO.getSkdVoyNo();
				        skdDirCd = maxVVDVO.getSkdDirCd();
				        ioBndCd = maxVVDVO.getIoBndCd();
				        
				        sailDt = maxVVDVO.getSailDt();
				        sailArrDt = maxVVDVO.getSailArrDt();
				        slanCd = maxVVDVO.getSlanCd();
				        trnkVslCd = maxVVDVO.getTrnkVslCd();
				        trnkSkdVoyNo = maxVVDVO.getTrnkSkdVoyNo();
				        trnkSkdDirCd = maxVVDVO.getTrnkSkdDirCd();
				        porCd = maxVVDVO.getPorCd();
				        polCd = maxVVDVO.getPolCd();
				        podCd = maxVVDVO.getPodCd();
				        delCd = maxVVDVO.getDelCd();
				        svcScpCd = maxVVDVO.getSvcScpCd();					       
				        port = ioBndCd.equals("O") ? polCd : podCd; 
				        
					} else { 
						bkgVvdVo = dbDao.searchArMstRevVvdTml();
						vslCd = bkgVvdVo.getVslCd();
						skdVoyNo = bkgVvdVo.getSkdVoyNo();
				        skdDirCd = bkgVvdVo.getSkdDirCd();
					}
				}
				*/
				
				if (vslCd.equals("CFDR") || vslCd.equals("USAC")) {
					sailDt = glEffDt;
				} 

				if(sailDt.equals("")){
					errRsn = new ErrorHandler("INV00132", new String[] {}).getUserMessage();
					dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
					//errFlag = "Y";
					return null;
				}
				
				if(glEffDt.equals("")){
					errRsn = new ErrorHandler("INV00122", new String[] {}).getUserMessage();
					dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
					//errFlag = "Y";
					return null;
				}
				
				// Customer Check
				int actCustCnt = dbDao.checkCustomer(genIfVo.getInvArIfMnVO().getCustCntCd(), genIfVo.getInvArIfMnVO().getCustSeq());
				
				if(actCustCnt == 0 ){
					errRsn = new ErrorHandler("INV00008", new String[] {}).getUserMessage();
					dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
					//errFlag = "Y";
					return null;
				}
				
				//sailArrDt, slanCd 없는경우
				if(sailArrDt.equals("") || slanCd.equals("")){
					vskVslPortSkdVo = dbDao.searchSaDtLane(glEffDt); 
					if (vskVslPortSkdVo != null) {
						sailArrDt = vskVslPortSkdVo.getVpsEtbDt();
				        slanCd = vskVslPortSkdVo.getSlanCd();
					} else {
						errRsn = new ErrorHandler("INV00160", new String[] {}).getUserMessage();
						dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
						//errFlag = "Y";
						return null;
					}
					
				}
				
				// svcScpCd 없는경우
				//svcScpCd = dbDao.searchBKGSvcScp(bkgNo);
				//if (svcScpCd.equals("")) {
					
					//rgnCdPor = dbDao.searchRgnCd(porCd); ///// Main 					
					//rgnCdDel = dbDao.searchRgnCd(delCd); ///// Main					
					//svcScpCd = dbDao.searchSvcScp(rgnCdPor, rgnCdDel, slanCd); ///// Main
									
					if (svcScpCd.equals("")) {
						//if (genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET")){
							// Add : 2010.02.03
							//if(vslCd.equals("CFDR") || vslCd.equals("CNTC")) {
							//	svcScpCd = "OTH";
							//} else {
								// error #6
								errRsn = new ErrorHandler("INV00179", new String[] {}).getUserMessage();
								dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
								//errFlag = "Y";
								return null;
							//}
						//} else {
							// If value is not DEM/DET, OTH
						//	svcScpCd = "OTH";
						//}											
					}				
				//}
				
				arCrdtVo.setActCustCntCd(genIfVo.getInvArIfMnVO().getCustCntCd());
				arCrdtVo.setActCustSeq(genIfVo.getInvArIfMnVO().getCustSeq());
				arCrdtVo.setArOfcCd(genIfVo.getInvArIfMnVO().getOfcCd());
				//if (genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET")){
					arCrdtVo.setSailArrDt(sailArrDt);
				//} else {
				//	arCrdtVo.setSailArrDt(genIfVo.getInvArIfMnVO().getSailArrDt());
				//}
				arCrdtVo.setIoBndCd(ioBndCd);
				arCrdtVo.setLocCd(mdmOrgVo.getLocCd());
				arCrdtVo.setDelCd(delCd);
				
				aRCreditVO = searchARCredit(arCrdtVo);
				
				if (!dueDt.equals("")) {
					
					if(aRCreditVO != null){
						crTermDys = aRCreditVO.getCrTerm();
						custCrFlg = aRCreditVO.getCrFlg();					
					}	
				
				} else {				
					
					if(aRCreditVO != null){
						dueDt = aRCreditVO.getDueDt();
						crTermDys = aRCreditVO.getCrTerm();
						custCrFlg = aRCreditVO.getCrFlg();					
					}	
					
					if(dueDt.equals("")){
						errRsn = new ErrorHandler("JOO00102", new String[] {}).getUserMessage();
						dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
						//errFlag = "Y";
						return null;
					}
										
				}
				
				//svrId = dbDao.searchSeverId(genIfVo.getInvArIfMnVO().getOfcCd()); 
				// MAIN currency converter			
				//if (genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET")){
					
					/*
					if (lclCurr.equals("USD")) {
						usdXchRt = "1";
					} else {
						vvdCustomerVo = new VVDCustomerVO();
						vvdCustomerVo.setInvCntryCd(genIfVo.getInvArIfMnVO().getCustCntCd());
						vvdCustomerVo.setInvCustCd(genIfVo.getInvArIfMnVO().getCustSeq());
						vvdCustomerVo.setVsl(vslCd);
						vvdCustomerVo.setVoy(skdVoyNo);
						vvdCustomerVo.setDep(skdDirCd);
						vvdCustomerVo.setLclCurr(lclCurr);
						vvdCustomerVo.setSvcScp(svcScpCd);
						vvdCustomerVo.setBnd(ioBndCd);
						vvdCustomerVo.setOfcCd(arOfcCd);
						vvdCustomerVo.setBkgNo(bkgNo);
						vvdCustomerVo.setSaDt(sailArrDt);
						vvdCustomerVo.setBlSrcNo(genIfVo.getInvArIfMnVO().getBlSrcNo());
						
						if (ioBndCd.equals("O")) {
							vvdCustomerVo.setPol(port);
							vvdCustomerVo.setPod(podCd);
						} else {	
							vvdCustomerVo.setPod(port);
							vvdCustomerVo.setPol(polCd);
						}

						vvdCustomerVo.setCurr("USD"); 
						exchangeRateVo = searchExchangeRate(vvdCustomerVo);
						usdXchRt = exchangeRateVo.getExRate();

						
						if(usdXchRt.equals("") || usdXchRt == null || usdXchRt.equals("0")) {
							usdXchRt = dbDao.searchUsdXchRtByAcctMonth(localTime, lclCurr);
						}
						
						
						
						if(usdXchRt.equals("") || usdXchRt == null || usdXchRt.equals("0")) {	
							errRsn = new ErrorHandler("INV00001", new String[] {}).getUserMessage();
							dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
							errFlag = "Y";
							break;
						}
						
					}
				 	*/
				
					/* 2014.11.26 DMT 에서 넘어오는 Due Date 는 그대로 유지
					if (dmdtInvAplyBlFlg.equals("Y")) {						
						dueDateVo = dbDao.searchDueDtForMaxINVInterface(genIfVo.getInvArIfMnVO().getInvSrcNo(), genIfVo.getInvArIfMnVO().getOfcCd()); ///// Main						
					}else{
						dueDateVo = dbDao.searchDueDtForMaxINVInterface(genIfVo.getInvArIfMnVO().getBlSrcNo(), genIfVo.getInvArIfMnVO().getOfcCd());
					}
					*/
											
					//destTrnsSvcModCd = dbDao.searchDestSVCModeCode(bkgNo); ///// Main
					
					//DueDt : Mandatory
					/* 
					if(dueDt.equals("")) {
				    	dueDt = dbDao.searchCreditCustomerForCredit(genIfVo.getInvArIfMnVO(), sailArrDt);
				          
			    	     if (dueDt.equals("") || crTermDys.equals("0")) {
			    		     dueDt = dbDao.searchOfficeForCredit(genIfVo.getInvArIfMnVO(), sailArrDt);
			    		     
			    	     }
				    }
				    */
				       
					
				//} else {
					/*
					// Get credit_term and credit_mark
					dueDateVo = dbDao.searchDueDtByCustomerSadt(ioBndCd, genIfVo.getInvArIfMnVO().getCustCntCd(), genIfVo.getInvArIfMnVO().getCustSeq(), sailArrDt);
					if (dueDateVo != null) {
						crTermDys = dueDateVo.getCrTermDys(); ///// Main
                        custCrFlg = dueDateVo.getCustCrFlg(); ///// Main
					}
					
					if (dueDt.equals("") || crTermDys.equals("0")) {
						dueDateVo = dbDao.searchDueDtByOffice(ioBndCd, genIfVo.getInvArIfMnVO().getOfcCd());
						crTermDys = dueDateVo.getCrTermDys(); ///// Main
                        custCrFlg = dueDateVo.getCustCrFlg(); ///// Main
					}
					*/
					
					/*
					if (lclCurr.equals("USD")) {
						usdXchRt = "1"; ///// Chg
					} else {
						usdXchRt = dbDao.searchUsdXchRtByAcctMonth(localTime, lclCurr);
					}
					*/
				//}
				
				usdXchRt = "0";
					
				/*
				mriMaxYymm = dbDao.searchMriMaxYymm(genIfVo.getInvArIfMnVO().getOfcCd());
				
				if (mriMaxYymm.equals("")) {
					mriMaxYymm = dbDao.searchMriMaxYymm(rhq);
				}
				
				if (mriMaxYymm.equals("")) {
					// Error #7
					errRsn = new ErrorHandler("INV00122", new String[] {}).getUserMessage();
					dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
					errFlag = "Y";
					break;
				}
				
				glEffDt = dbDao.searchGlEffDtOther(genIfVo.getInvArIfMnVO().getOfcCd(), mriMaxYymm, glEffDt);
				 */
									
		        revTypeSrcVo = dbDao.searchREVTypeSource("OTH", "", "", genIfVo.getInvArIfMnVO().getIfSrcCd());
		        if (revTypeSrcVo != null) {
			        revTpCd = revTypeSrcVo.getRevTpCd();
			        revSrcCd = revTypeSrcVo.getRevSrcCd();
		        }    
		        
		        //if (!revSrcCd.equals("TM") && !glEffDt.equals("")) {
		        	blInvCfmDt = localTime;
		        //} 
		        
				//zoneIoc = dbDao.searchZoneIOC(polCd, podCd); ///// Main
				
				/*
				genIfVo.getInvArIfMnVO().setSlanCd(slanCd);
				mriRevVvdLaneVo = dbDao.searchMRIRevenueVVDLaneByVvdPort(genIfVo.getInvArIfMnVO()); 
				
				if (mriRevVvdLaneVo.getRevVvd().equals("")) {
					mriRevVvdLaneVo = dbDao.searchMRIRevenueVVDLane(genIfVo.getInvArIfMnVO(), zoneIoc); 
				}
		        
				if (mriRevVvdLaneVo.getRevVvd().equals("")) {
					mriRevVvdLaneVo = dbDao.searchMRIRevenueVVDLane(genIfVo.getInvArIfMnVO(), "OO");
				}
				
				if (mriRevVvdLaneVo.getRevVvd().equals("")) {
					mriRevVvdLaneVo = dbDao.searchMRIRevenueVVDLaneRowNum(genIfVo.getInvArIfMnVO());
				}
				
				
				if (mriRevVvdLaneVo.getRevVvd().equals("")) {
					// If rev_src_cd is 'RD', vsl change 'CNTC'
					if (revSrcCd.equals("RD")) {
						tVslCd = "CNTC";
					} else {
						tVslCd = vslCd;
					}
					mriRevVvdLaneVo = dbDao.searchMRIRevenueVVDLaneRd(tVslCd); 
				}
				
				if (mriRevVvdLaneVo.getRevVvd().equals("")) {
					// Error #8
					errRsn = new ErrorHandler("INV00183", new String[] {}).getUserMessage();
					dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
					errFlag = "Y";
					break;
				} else { 		
					revLane = mriRevVvdLaneVo.getRevLane(); ///// Main
			        revVvd = mriRevVvdLaneVo.getRevVvd(); ///// Main
				}
				*/
				
		        locCd = dbDao.searchCityCd(arOfcCd); ///// Main
				
		        /*
		        if (!bkgNo.equals("")) { 
		        	blObrdDt = dbDao.searchBLOnDate(bkgNo); ///// Main
		        }

				subsCoCd = dbDao.searchInterCompany(genIfVo.getInvArIfMnVO().getCustCntCd(), genIfVo.getInvArIfMnVO().getCustSeq()); ///// Main
				*/
				
			} // genIfVo looping end
			
			// TML start
			
			//if (errFlag.equals("Y")) {					
			//	break;
			//}
						
			// AR_IF_NO
			ofcCd = genIfVo.getInvArIfMnVO().getOfcCd();
			arIfNo = dbDao.searchMRIInterfaceNo(srcIfDt, srcIfSeq, ofcCd);
			newInvNo = dbDao.searchMaxInvoiceNo("AR", srcIfDt, srcIfSeq, arOfcCd);
			
			/*
			if (arIfNo.equals("")) {
				dbDao.addMRIInterfaceNo(ofcCd, genIfVo.getInvArIfMnVO().getIfSrcCd().substring(0, 2)+"_IF");
				
				arIfNo = ofcCd.substring(0, 3) + 'M' + String.valueOf(DateTime.getYear()).substring(2, 4) + "00001";

			} else {
				dbDao.modifyMRIInterfaceNo(ofcCd, arIfNo, genIfVo.getInvArIfMnVO().getIfSrcCd().substring(0, 2)+"_IF");
			}
			*/
			// ------------------------------------------------------------------------
			
			//arIfNos = arIfNos + arIfNo + ((rowNum == 0 && genIfVos.size() == 2)? "|" : "");		
			//arIfNos.append(arIfNo).append(((rowNum == 0 && genIfVos.size() == 2)? "|" : ""));
			
			//////////////////////////////////////////////////
			// INV_AR_CHG information setting
			
	        //int seq = 1;
	        
	        //int ifSalar = 0;
	        //int ifNonre = 0;
	        //int ifMriar = 0;
	        //int ifOther = 0;
	        //int ifVat = 0;
	        //int ifWhf = 0;
	        //int ifCtt = 0;
	        //int if3rd = 0;
	        //int ifXxx = 0;
	         
	        //int erpSalar = 0;
	        //int erpNonre = 0;
	        //int erpMriar = 0;
	        //int erpOther = 0;
	        //int erpVat = 0;
	        //int erpWhf = 0;
	        //int erpCtt = 0;
	        //int erp3rd = 0;
	        //int erpXxx = 0;
	        
	        
	        //String curr_cd = "";
	        String apArOffstNo = "";
	        
	       // InvArChgVO invChgeVo = null;
	        InvArMnVO invArMnVo2 = new InvArMnVO();
	        invArMnVo2.setArOfcCd(genIfVo.getInvArIfMnVO().getOfcCd());
	        invArMnVo2.setRevTpCd(revTpCd);
	        invArMnVo2.setRevSrcCd(revSrcCd);
	        
			if (genIfVo.getInvArIfChgVOs() != null) {
				
				invArChgVos = new ArrayList<InvArChgVO>();
				invArIssDtlVOs = new ArrayList<InvArIssDtlVO>();
				
				// invArIfChgVOs looping start
				for (int rowNum2 = 0; rowNum2 < genIfVo.getInvArIfChgVOs().size(); rowNum2++) {
					
					invArChgVo = new InvArChgVO();
					
					//repChgCd = dbDao.searchRepCharge(genIfVo.getInvArIfChgVOs().get(rowNum2).getChgCd());  ///// Chg	
					//chgFullNm = dbDao.searchChargeName(genIfVo.getInvArIfChgVOs().get(rowNum2).getChgCd()); ///// Chg

					//if(chgFullNm.equals("")) {
					//	chgFullNm = genIfVo.getInvArIfChgVOs().get(rowNum2).getChgFullNm();
					//}
						
					//if (erpIfOfcCd.equals("")) {
					//	erpIfOfcCd = genIfVo.getInvArIfMnVO().getOfcCd();
					//}
					
					invRevTpSrcCd = revTpCd + revSrcCd;
					
					invArChgVo.setRevCoaAcctCd("");
					
					//if (genIfVo.getInvArIfMnVO().getIfSrcCd().equals("TPB")) {
						
						//acctCd = genIfVo.getInvArIfChgVOs().get(rowNum2).getChgRmk();
						
						/* 2015.02.06 block
						if (acctCd.equals("")) {
							// Error #9
							errRsn = new ErrorHandler("INV00166", new String[] {}).getUserMessage();
							dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
							errFlag = "Y";
							break;
						}
						*/
						
						//invChgeVo = dbDao.searchInvRevTpSrcCd(genIfVo.getInvArIfChgVOs().get(rowNum2).getChgCd(), invArMnVo2, acctCd);
						
						//invArChgVo.setRevCoaAcctCd("");
						
						//invRevTpSrcCd = invChgeVo.getInvRevTpSrcCd(); 
						//revCoaCoCd = invChgeVo.getRevCoaCoCd();
						//revCoaRgnCd = invChgeVo.getRevCoaRgnCd();
						//revCoaCtrCd = invChgeVo.getRevCoaCtrCd();
												
						
					//} else if (!genIfVo.getInvArIfMnVO().getIfSrcCd().equals("TPB") && !genIfVo.getInvArIfMnVO().getIfSrcCd().equals("TML")){
						
						/*
						invAcctDivCd = dbDao.searchAccountDivision(revTpCd, revSrcCd); 
						
						if (invAcctDivCd.equals("P")) {
							acctCd = dbDao.searchAccountCdFromCharge(genIfVo.getInvArIfChgVOs().get(rowNum2).getChgCd()); ///// Chg
						} else {
							acctCd = dbDao.searchAccountCdFromRevAcct(genIfVo.getInvArIfChgVOs().get(rowNum2).getChgCd()); 
						}
						*/
						
						//acctCd = dbDao.searchAccountCdConversion(arOfcCd, genIfVo.getInvArIfChgVOs().get(rowNum2).getChgCd(), revTpCd, revSrcCd, acctCd);

						/* 2015.02.06 block
						if (acctCd.equals("")) {
							// Error #9
							errRsn = new ErrorHandler("INV00166", new String[] {}).getUserMessage();
							dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
							errFlag = "Y";
							break;
						}
													
						 */
						//invChgeVo = dbDao.searchInvRevTpSrcCd(genIfVo.getInvArIfChgVOs().get(rowNum2).getChgCd(), invArMnVo2, acctCd);
						
						//invArChgVo.setRevCoaAcctCd(invChgeVo.getRevCoaAcctCd());
						
						//invRevTpSrcCd = invChgeVo.getInvRevTpSrcCd(); 
						//revCoaCoCd = invChgeVo.getRevCoaCoCd();
						//revCoaRgnCd = invChgeVo.getRevCoaRgnCd();
						//revCoaCtrCd = invChgeVo.getRevCoaCtrCd();
						
					//}
					
					//if(("CFDR").equals(vslCd)){
					//if(!invXchRt.equals("0") && !invXchRt.equals("")){
					if(lclCurr.equals(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd())){
						invXchRt = "1";
					} else {
						invXchRt = genIfVo.getInvArIfChgVOs().get(rowNum2).getInvXchRt();
					}
					
					if(("USD").equals(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd())){
						invUsdXchRt = "1";
					} else {
						invUsdXchRt = genIfVo.getInvArIfChgVOs().get(rowNum2).getUsdXchRt();    //dbDao.searchAccountRate(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd(), "USD", glEffDt.substring(0,6));
					}
						
					/*	
					} else {
						vvdCustomerVo = new VVDCustomerVO();
						
						vvdCustomerVo.setInvCntryCd(genIfVo.getInvArIfMnVO().getCustCntCd());
						vvdCustomerVo.setInvCustCd(genIfVo.getInvArIfMnVO().getCustSeq());
						vvdCustomerVo.setVsl(vslCd);
						vvdCustomerVo.setVoy(skdVoyNo);
						vvdCustomerVo.setDep(skdDirCd);
						vvdCustomerVo.setLclCurr(lclCurr);
						//if (svrId.equals("EUR") || svrId.equals("KOR")) {
						//	vvdCustomerVo.setSvcScp("OTH");
						//} else {
							vvdCustomerVo.setSvcScp(svcScpCd);
						//}
						vvdCustomerVo.setBnd(ioBndCd);
						vvdCustomerVo.setOfcCd(arOfcCd);
						vvdCustomerVo.setBkgNo(bkgNo);
						vvdCustomerVo.setSaDt(sailArrDt);
						vvdCustomerVo.setPol(polCd);
						vvdCustomerVo.setPod(podCd);
						vvdCustomerVo.setCurr(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd());
						vvdCustomerVo.setBlSrcNo(genIfVo.getInvArIfMnVO().getBlSrcNo());

						exchangeRateVo = searchExchangeRate(vvdCustomerVo); ////////////////////////////////////////////////////////////////
						
						
						// CHARGE currency converter
						//if (exchangeRateVo != null 
						//	&& (genIfVo.getInvArIfChgVOs().get(rowNum2).getInvXchRt().equals("0") || genIfVo.getInvArIfChgVOs().get(rowNum2).getInvXchRt().equals(""))
						//	&& genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET")) {															
							
							if (genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd().equals(lclCurr)) {
								invXchRt = "1";
							} else {
								invXchRt = exchangeRateVo.getExRate();	
							}
					*/
							/*
							if (invXchRt.equals("0")||invXchRt.equals("")|invXchRt==null){
									invXchRt = utilCmd.searchAccountRate(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd(), lclCurr, localTime.length()==8?localTime.substring(0,6):"");									
							}
							*/
					/*									
					//	} else { 
							//invXchRt = utilCmd.searchAccountRate(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd(), lclCurr, localTime.length()==8?localTime.substring(0,6):"");
						//	if(invXchRt.equals("")){
						//		invXchRt = genIfVo.getInvArIfChgVOs().get(rowNum2).getInvXchRt();
						//	}
						//}
							
						//Add USD_XCH_RT in INV_AR_CHG table - 2015.03.04 /////////// START
						vvdCustomerVo.setLclCurr("USD");
						
						exchangeRateVo = searchExchangeRate(vvdCustomerVo); ////////////////////////////////////////////////////////////////
						
						// CHARGE currency converter
						//if (exchangeRateVo != null 
						//	&& genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET")) {															
							
							if (genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd().equals("USD")) {
								invUsdXchRt = "1";
							} else {
								invUsdXchRt = exchangeRateVo.getExRate();	
							}
					*/		
							/*
							if (invUsdXchRt.equals("0")||invUsdXchRt.equals("")|invUsdXchRt==null){
								invUsdXchRt = utilCmd.searchAccountRate(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd(), "USD", localTime.length()==8?localTime.substring(0,6):"");									
							}
							*/
					/*									
						//} else { 
							//invUsdXchRt = utilCmd.searchAccountRate(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd(), "USD", localTime.length()==8?localTime.substring(0,6):"");
						//}
						//Add USD_XCH_RT in INV_AR_CHG table - 2015.03.04 /////////// END
					}
					*/
					
					if(invXchRt.equals("0") || invXchRt.equals("") || invUsdXchRt.equals("0") || invUsdXchRt.equals("")){
						errRsn = new ErrorHandler("INV00098", new String[] {}).getUserMessage();
						dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
						//errFlag = "Y";
						return null;
					}
					
					tjSrcNm = dbDao.searchTjSrcNm(arOfcCd, genIfVo.getInvArIfChgVOs().get(rowNum2).getChgCd(), invRevTpSrcCd, "");

					invArChgVo.setArIfNo(arIfNo);
					invArChgVo.setChgSeq(Integer.toString(rowNum2 + 1));
					invArChgVo.setChgCd(genIfVo.getInvArIfChgVOs().get(rowNum2).getChgCd());
					invArChgVo.setTjSrcNm(tjSrcNm);
					invArChgVo.setOfcCd(arOfcCd);
					
					////////////////////////////////////////////////////////////////////////
					///// AR_IF_SER_NO creation
					/*
					if (tjSrcNm.equals("SALAR")) {
						if (ifSalar == 0 || !curr_cd.equals(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd())) {
							ifSalar = seq++;
						}
						invArChgVo.setArIfSerNo(String.valueOf(ifSalar));
						if (curr_cd.equals(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd())) {
							erpSalar++;
						} else {
							erpSalar = 1;
						}						
						invArChgVo.setArIfChgSeq(String.valueOf(erpSalar));
					} else if (tjSrcNm.equals("NONRE")) {
						if (ifNonre == 0 || !curr_cd.equals(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd())) {
					        ifNonre = seq++;
						}
						invArChgVo.setArIfSerNo(String.valueOf(ifNonre));
						if (curr_cd.equals(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd())) {
							erpNonre++;
						} else {
							erpNonre = 1;
						}						
						invArChgVo.setArIfChgSeq(String.valueOf(erpNonre));
					} else if (tjSrcNm.equals("MRIAR")) {
						if (ifMriar == 0 || !curr_cd.equals(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd())) {
							ifMriar = seq++;							
						}
						invArChgVo.setArIfSerNo(String.valueOf(ifMriar));
						if (curr_cd.equals(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd())) {
							erpMriar++;
						} else {
							erpMriar = 1;
						}						
						invArChgVo.setArIfChgSeq(String.valueOf(erpMriar));						
					} else if (tjSrcNm.equals("OTHER")) {
						if (ifOther == 0 || !curr_cd.equals(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd())) {
							ifOther = seq++;
						} 	
						invArChgVo.setArIfSerNo(String.valueOf(ifOther));
						if (curr_cd.equals(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd())) {
							erpOther++;
						} else {
							erpOther = 1;
						}						
						invArChgVo.setArIfChgSeq(String.valueOf(erpOther));
					} else if (tjSrcNm.equals("VAT")) {
						if (ifVat == 0 || !curr_cd.equals(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd())) {
							ifVat = seq++;
						}
						invArChgVo.setArIfSerNo(String.valueOf(ifVat));
						if (curr_cd.equals(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd())) {
							erpVat++;
						} else {
							erpVat = 1;
						}						
						invArChgVo.setArIfChgSeq(String.valueOf(erpVat));
					} else if (tjSrcNm.equals("WHF")) {
						if (ifWhf == 0 || !curr_cd.equals(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd())) {
							ifWhf = seq++;
						}
						invArChgVo.setArIfSerNo(String.valueOf(ifWhf));
						if (curr_cd.equals(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd())) {
							erpWhf++;
						} else {
							erpWhf = 1;
						}						
						invArChgVo.setArIfChgSeq(String.valueOf(erpWhf));
					} else if (tjSrcNm.equals("CTT")) {
						if (ifCtt == 0 || !curr_cd.equals(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd())) {
							ifCtt = seq++;
						}
						invArChgVo.setArIfSerNo(String.valueOf(ifCtt));
						if (curr_cd.equals(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd())) {
							erpCtt++;
						} else {
							erpCtt = 1;
						}						
						invArChgVo.setArIfChgSeq(String.valueOf(erpCtt));
					} else if (tjSrcNm.equals("3RD")) {
						if (if3rd == 0 || !curr_cd.equals(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd())) {
							if3rd = seq++;
						}
						invArChgVo.setArIfSerNo(String.valueOf(if3rd));
						if (curr_cd.equals(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd())) {
							erp3rd++;
						} else {
							erp3rd = 1;
						}						
						invArChgVo.setArIfChgSeq(String.valueOf(erp3rd));
					} else if (tjSrcNm.equals("XXX")) {
						if (ifXxx == 0 || !curr_cd.equals(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd())) {
							ifXxx = seq++;
						}
						invArChgVo.setArIfSerNo(String.valueOf(ifXxx));
						if (curr_cd.equals(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd())) {
							erpXxx++;
						} else {
							erpXxx = 1;
						}						
						invArChgVo.setArIfChgSeq(String.valueOf(erpXxx));
					}	
					
					curr_cd = genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd();
					*/
					////////////////////////////////////////////////////////////////////////
					////////////////////////////////////////////////////////////////////////
						
					
						invArChgVo.setRepChgCd("");                                                           
						invArChgVo.setChgFullNm("");    

						//2015.07.01 OTS Summary 에 관계없이 Issue Flag 찍히도록 수정 by IY Cho
						/*
						if((arInvIssFlg.equals("N")) ||
						   (!genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") &&
						    !genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET") &&
						    !genIfVo.getInvArIfMnVO().getIfSrcCd().equals("TPB"))) {
						*/
							invArChgVo.setInvIssFlg("Y");         
						/*
						} else {
							invArChgVo.setInvIssFlg("N");   
						}
						*/
							
						invArChgVo.setRevCoaInterCoCd("");
						invArChgVo.setRevCoaCtrCd("");    
						
						/* 2015.02.09 block
						if (!acctCd.substring(0, 1).equals("4") && !acctCd.substring(0, 1).equals("7") && !acctCd.substring(0, 2).equals("51")) {
							invArChgVo.setRevCoaVslCd("0000");                                                                                                            
							invArChgVo.setRevCoaVoyNo("0000");                                                                                                                       
							invArChgVo.setRevCoaSkdDirCd("0");                                                                                                                      
							invArChgVo.setRevCoaDirCd("0");   
						} else { */
						/*
							if (revVvd.length() == 9) {
								invArChgVo.setRevCoaVslCd(revVvd.substring(0,4));                                                                                                            
								invArChgVo.setRevCoaVoyNo(revVvd.substring(4,8));                                                                                                                       
								invArChgVo.setRevCoaSkdDirCd(revVvd.substring(8,9));                                                                                                                      
								invArChgVo.setRevCoaDirCd(revVvd.substring(8,9));                                                                                                                   
							} else if (revVvd.length() == 10) {
								invArChgVo.setRevCoaVslCd(revVvd.substring(0,4));                                                                                                            
								invArChgVo.setRevCoaVoyNo(revVvd.substring(4,8));                                                                                                                       
								invArChgVo.setRevCoaSkdDirCd(revVvd.substring(8,9));                                                                                                                      
								invArChgVo.setRevCoaDirCd(revVvd.substring(9,10));   
							}
							*/
						//}		
						invArChgVo.setRevCoaVslCd("");                                                                                                            
						invArChgVo.setRevCoaVoyNo("");                                                                                                                       
						invArChgVo.setRevCoaSkdDirCd("");
						invArChgVo.setRevCoaDirCd("");     
						
						invArChgVo.setAcctCd(acctCd);                                          
						invArChgVo.setInvRevTpSrcCd(invRevTpSrcCd);                                                                        
						invArChgVo.setCurrCd(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd());                                                                                                                                    
						invArChgVo.setPerTpCd(genIfVo.getInvArIfChgVOs().get(rowNum2).getPerTpCd());                                                                                                                                        
						invArChgVo.setTrfRtAmt(genIfVo.getInvArIfChgVOs().get(rowNum2).getTrfRtAmt()); 
						invArChgVo.setRatAsCntrQty(genIfVo.getInvArIfChgVOs().get(rowNum2).getRatAsCntrQty());                                                                                                                                
						invArChgVo.setChgAmt(genIfVo.getInvArIfChgVOs().get(rowNum2).getChgAmt());
						
						invArChgVo.setInvXchRt(invXchRt);
						invArChgVo.setUsdXchRt(invUsdXchRt);
						invArChgVo.setTrfNo(genIfVo.getInvArIfChgVOs().get(rowNum2).getTrfNo());                                                                                                                                           
						invArChgVo.setSobId("1");                                                                                                                                                
						invArChgVo.setRevCoaCoCd("");  
						invArChgVo.setRevCoaRgnCd("");						
						invArChgVo.setTvaFlg(genIfVo.getInvArIfChgVOs().get(rowNum2).getTvaFlg());

						//if (genIfVo.getInvArIfMnVO().getIfSrcCd().equals("TPB")) {
						//	invArChgVo.setChgRmk("");
						//} else {
							invArChgVo.setChgRmk(genIfVo.getInvArIfChgVOs().get(rowNum2).getChgRmk());
						//}
						// ------------------------------------------------------------------------
						
						invArChgVo.setMnlFlg("N");                                                                                                                                                
						invArChgVo.setMfDivCd("N");                                                                                                                                              
						invArChgVo.setCreUsrId(genIfVo.getInvArIfChgVOs().get(rowNum2).getCreUsrId());                                                                                                                                     
						invArChgVo.setCreDt(genIfVo.getInvArIfChgVOs().get(rowNum2).getCreDt());                                                                                                                                          
						invArChgVo.setUpdUsrId(genIfVo.getInvArIfChgVOs().get(rowNum2).getUpdUsrId());                                                                                                                                     
						invArChgVo.setUpdDt(genIfVo.getInvArIfChgVOs().get(rowNum2).getUpdDt());              
						

					//invArChgVo.setIfSrcCd(genIfVo.getInvArIfMnVO().getIfSrcCd());

					invArChgVos.add(invArChgVo);
					
					InvArIssDtlVO invArIssDtlVO = new InvArIssDtlVO();
					
					invArIssDtlVO.setInvNo(newInvNo);
					invArIssDtlVO.setArIfNo(arIfNo);
					invArIssDtlVO.setChgSeq(invArChgVo.getChgSeq());
					invArIssDtlVO.setUserId(invArChgVo.getCreUsrId());
					
					invArIssDtlVOs.add(invArIssDtlVO);
				} // invArIfChgVOs looping end	
				
				//if (errFlag.equals("Y")) {					
				//	break;
				//}
									
				if (invArChgVos.size() > 0) {
					// INV_AR_CHG table save.	
					dbDao.addOtherInvCharge(invArChgVos);
				}
				
			} // if (genIfVo.getInvArIfChgVOs() != null)
			
			///////////////////////////////////////////////////////
			// INV_AR_MN information setting
			invArMnVo = new InvArMnVO();
			
			invArMnVo.setArIfNo(arIfNo);
			invArMnVo.setLoclCurrCd(lclCurr);
			invArMnVo.setActCustCntCd(genIfVo.getInvArIfMnVO().getCustCntCd());        	
			invArMnVo.setInvCustCntCd(genIfVo.getInvArIfMnVO().getCustCntCd());        
			invArMnVo.setActCustSeq(genIfVo.getInvArIfMnVO().getCustSeq());        	
			invArMnVo.setInvCustSeq(genIfVo.getInvArIfMnVO().getCustSeq());        
			invArMnVo.setVslCd(vslCd); 
			invArMnVo.setSkdVoyNo(skdVoyNo); 
			invArMnVo.setSkdDirCd(skdDirCd); 
			invArMnVo.setPolCd(polCd); 
			invArMnVo.setPodCd(podCd); 
			/*
			if ((genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET")) && !port.equals("")) {
				if (ioBndCd.equals("O")) {
					invArMnVo.setPolCd(port); 
				} else {	
					invArMnVo.setPodCd(port);        
				}
			} 
			*/
			invArMnVo.setPorCd(porCd);  
			invArMnVo.setDelCd(delCd); 
			if(polCd.equals("")){
				invArMnVo.setPolCd(locCd);
			}
			if(podCd.equals("")){
				invArMnVo.setPodCd(locCd);
			}
			if(porCd.equals("")){
				invArMnVo.setPorCd(locCd);
			}
			if(delCd.equals("")){
				invArMnVo.setDelCd(locCd);
			}
			invArMnVo.setSvcScpCd(svcScpCd); 
			//if(vslCd.equals("CNTC") || vslCd.equals("CFDR")) {
			//	invArMnVo.setSailArrDt(sailDt);
			//} else {
				invArMnVo.setSailArrDt(sailArrDt);
			//}
			invArMnVo.setSlanCd(slanCd); 
			invArMnVo.setDueDt(dueDt);
			invArMnVo.setCrTermDys(crTermDys);        
			invArMnVo.setCustCrFlg(custCrFlg);        
			invArMnVo.setDestTrnsSvcModCd(""); 
			invArMnVo.setGlEffDt(glEffDt);
			invArMnVo.setBlInvCfmDt(blInvCfmDt);
			invArMnVo.setZnIocCd(zoneIoc);
			invArMnVo.setRlaneCd(""); 
			/*
			if (revVvd.length() == 9) {
				invArMnVo.setRevVslCd(revVvd.substring(0,4)); 
				invArMnVo.setRevSkdVoyNo(revVvd.substring(4,8));        
				invArMnVo.setRevSkdDirCd(revVvd.substring(8,9));        
				invArMnVo.setRevDirCd(revVvd.substring(8,9));        
			} else if (revVvd.length() == 10) {
			*/
				invArMnVo.setRevVslCd(vslCd); 
				invArMnVo.setRevSkdVoyNo(skdVoyNo);        
				invArMnVo.setRevSkdDirCd(skdDirCd);        
				invArMnVo.setRevDirCd(skdDirCd);        
			//}
			invArMnVo.setArCtyCd(""); 
			invArMnVo.setObrdDt(""); 
			invArMnVo.setArTaxIndCd("");
			invArMnVo.setRevTpCd(revTpCd);
			invArMnVo.setRevSrcCd(revSrcCd);        
			invArMnVo.setUsdXchRt(usdXchRt);
			invArMnVo.setArOfcCd(arOfcCd);
			invArMnVo.setBkgCorrDt(genIfVo.getInvArIfMnVO().getBkgCorrDt());
			invArMnVo.setBkgCorrNo("");
			invArMnVo.setBkgFeuQty("0");
			invArMnVo.setBkgTeuQty("0");
			invArMnVo.setBkgNo(newBkgNo);
			invArMnVo.setBlSrcNo(newBkgNo);
			invArMnVo.setInvSrcNo(bkgNo);
			invArMnVo.setOrgInvNo(blSrcNo);
			invArMnVo.setBkgRefNo(genIfVo.getInvArIfMnVO().getBkgRefNo());
			invArMnVo.setBlInvIfDt(genIfVo.getInvArIfMnVO().getBlInvIfDt());
			invArMnVo.setBlNo("");
			invArMnVo.setInvNo(newInvNo);
			invArMnVo.setIssDt(genIfVo.getInvArIfMnVO().getInvDt());
			/*
			if ((genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET")) && dmdtInvAplyBlFlg.equals("Y")) {
				invArMnVo.setBlSrcNo(genIfVo.getInvArIfMnVO().getInvSrcNo());
			} else {
				invArMnVo.setBlSrcNo(genIfVo.getInvArIfMnVO().getBlSrcNo());
			}
			*/
			invArMnVo.setBlTpCd(genIfVo.getInvArIfMnVO().getBlTpCd());
			invArMnVo.setCgoMeasQty(genIfVo.getInvArIfMnVO().getCgoMeasQty());
			invArMnVo.setCgoWgt(genIfVo.getInvArIfMnVO().getCgoWgt());
			invArMnVo.setCreDt(genIfVo.getInvArIfMnVO().getCreDt());
			invArMnVo.setCreUsrId(genIfVo.getInvArIfMnVO().getCreUsrId());
			invArMnVo.setCxlFlg("N");
			invArMnVo.setFrtFwrdCntCd(genIfVo.getInvArIfMnVO().getFrtFwrdCntCd());
			invArMnVo.setFrtFwrdCustSeq(genIfVo.getInvArIfMnVO().getFrtFwrdCustSeq());
			invArMnVo.setInvDeltDivCd("N");
			invArMnVo.setInvRefNo(genIfVo.getInvArIfMnVO().getInvRefNo());
			invArMnVo.setInvRmk(genIfVo.getInvArIfMnVO().getInvRmk());
			//invArMnVo.setInvSrcNo(genIfVo.getInvArIfMnVO().getInvSrcNo());
			invArMnVo.setIoBndCd(ioBndCd);
			invArMnVo.setMstBlNo(genIfVo.getInvArIfMnVO().getMstBlNo());
			invArMnVo.setRfaNo(genIfVo.getInvArIfMnVO().getRfaNo());
			invArMnVo.setSailDt(sailDt);
			invArMnVo.setScNo(genIfVo.getInvArIfMnVO().getScNo());
			invArMnVo.setSiRefNo(genIfVo.getInvArIfMnVO().getSiRefNo());
			invArMnVo.setSlsOfcCd(genIfVo.getInvArIfMnVO().getSlsOfcCd());
			invArMnVo.setSrepCd(genIfVo.getInvArIfMnVO().getSrepCd());
			invArMnVo.setTaxXchRt("0");
			if (trnkSkdVoyNo.equals("") ) {
				invArMnVo.setTrnkVslCd(vslCd);
				invArMnVo.setTrnkSkdVoyNo(skdVoyNo);
				invArMnVo.setTrnkSkdDirCd(skdDirCd);
			} else {
				invArMnVo.setTrnkSkdVoyNo(trnkSkdVoyNo);
				invArMnVo.setTrnkVslCd(trnkVslCd);
				invArMnVo.setTrnkSkdDirCd(trnkSkdDirCd);
			}
							
			invArMnVo.setTrspRqstOrdFlg(genIfVo.getInvArIfMnVO().getTrspRqstOrdFlg());
			invArMnVo.setUpdDt(genIfVo.getInvArIfMnVO().getUpdDt());
			invArMnVo.setUpdUsrId(genIfVo.getInvArIfMnVO().getUpdUsrId());
			invArMnVo.setVvdTrnsFlg(genIfVo.getInvArIfMnVO().getVvdTrnsFlg());
							
			//if(("CFDR").equals(vslCd)){
			//	invArMnVo.setXchRtN3rdTpCd("A");
			//	invArMnVo.setXchRtUsdTpCd("A");
			//} else {
				invArMnVo.setXchRtN3rdTpCd("V");
				invArMnVo.setXchRtUsdTpCd("V");
			//}
			
			invArMnVo.setXchRtDt("");
			invArMnVo.setAcctXchRtYrmon("");
			
			/*
			vvdCustomerVo = new VVDCustomerVO();
			
			vvdCustomerVo.setInvCntryCd(genIfVo.getInvArIfMnVO().getCustCntCd());
			vvdCustomerVo.setInvCustCd(genIfVo.getInvArIfMnVO().getCustSeq());
			vvdCustomerVo.setVsl(vslCd);
			vvdCustomerVo.setVoy(skdVoyNo);
			vvdCustomerVo.setDep(skdDirCd);
			vvdCustomerVo.setLclCurr(lclCurr);
			vvdCustomerVo.setSvcScp(svcScpCd);
			vvdCustomerVo.setBnd(ioBndCd);
			vvdCustomerVo.setOfcCd(arOfcCd);
			vvdCustomerVo.setBkgNo(bkgNo);
			vvdCustomerVo.setSaDt(sailArrDt);
			vvdCustomerVo.setPol(polCd);
			vvdCustomerVo.setPod(podCd);
			vvdCustomerVo.setCurr("USD"); 
			vvdCustomerVo.setBlSrcNo(genIfVo.getInvArIfMnVO().getBlSrcNo());

			exchangeRateVo = searchExchangeRate(vvdCustomerVo);
			
			if (genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET")){
				invArMnVo.setXchRtN3rdTpCd(exchangeRateVo.getThirdExrateType());
				invArMnVo.setXchRtUsdTpCd(exchangeRateVo.getUsdExrateType());
				invArMnVo.setXchRtDt(exchangeRateVo.getExRateDate());
				
				if(exchangeRateVo.getExRate().equals("")||exchangeRateVo.getExRate().equals("0")){
					invArMnVo.setXchRtN3rdTpCd("A");
					invArMnVo.setXchRtUsdTpCd("A");
				}
			}else{
				invArMnVo.setXchRtN3rdTpCd("A");
				invArMnVo.setXchRtUsdTpCd("A");
			}
			
			if (exchangeRateVo.getExRateDate() != null && exchangeRateVo.getExRateDate().length() >= 6) {
				invArMnVo.setAcctXchRtYrmon(exchangeRateVo.getExRateDate().substring(0, 6));
			} else {
				invArMnVo.setAcctXchRtYrmon(exchangeRateVo.getExRateDate());
			}
			*/
			
			invArMnVo.setInvClrFlg("N");

			//if((arInvIssFlg.equals("N")) ||
			//   (!genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") &&
			//    !genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET") &&
			//    !genIfVo.getInvArIfMnVO().getIfSrcCd().equals("TPB"))) {

				invArMnVo.setInvIssFlg("Y");
			//} else {
			//	invArMnVo.setInvIssFlg("N");
			//}
			
			invArMnVo.setInvSvcScpCd(svcScpCd);
			
			// If apArOffstNo is "" by Locl Charge, apArOffstNo setting.
			//if(apArOffstNo.equals("")){
			//	apArOffstNo = genIfVo.getInvArIfMnVO().getApArOffstNo();
			//}

			invArMnVo.setApArOffstNo(apArOffstNo);
			invArMnVo.setOtsPayCd(otsPayCd);
			
			/*
			String revVslCd2 		 =	invArMnVo.getRevVslCd();
			String revSkdDirCd2      =	invArMnVo.getRevSkdDirCd();
			String revSkdVoyNo2      =	invArMnVo.getRevSkdVoyNo();
			String sailArrDt2        =	invArMnVo.getSailArrDt();
			String sailDt2           =	invArMnVo.getSailDt();
			String dueDt2            =	invArMnVo.getDueDt();
			String xchRtN3rdTpCd2    =	invArMnVo.getXchRtN3rdTpCd();
			String xchRtUsdTpCd2     =	invArMnVo.getXchRtUsdTpCd();
			String arCtyCd2          =	invArMnVo.getArCtyCd();
			String glEffDt2          =	invArMnVo.getGlEffDt();
			String actCustSeq2       =	invArMnVo.getActCustSeq();
			String usdXchRt2       	 =	invArMnVo.getUsdXchRt();
			
			if(revVslCd2 == null) revVslCd2 = "";
			if(revSkdDirCd2 == null) revSkdDirCd2 = "";
			if(revSkdVoyNo2 == null) revSkdVoyNo2 = "";
			if(sailArrDt2 == null) sailArrDt2 = "";
			if(sailDt2 == null) sailDt2 = "";
			if(dueDt2 == null) dueDt2 = "";
			if(xchRtN3rdTpCd2 == null) xchRtN3rdTpCd2 = "";
			if(xchRtUsdTpCd2 == null) xchRtUsdTpCd2 = "";
			if(arCtyCd2 == null) arCtyCd2 = "";
			if(glEffDt2 == null) glEffDt2 = "";
			if(actCustSeq2 == null) actCustSeq2 = "";
			if(usdXchRt2 == null) usdXchRt2 = "";
			
			noGoodFlg = "N";
			
			if(revVslCd2.equals("") || revSkdDirCd2.equals("") || revSkdVoyNo2.equals("") || sailArrDt2.equals("") || sailDt2.equals("") || dueDt2.equals("")
					|| xchRtN3rdTpCd2.equals("") || xchRtUsdTpCd2.equals("") || glEffDt2.equals("") || actCustSeq2.equals("") || usdXchRt2.equals("")){
				invArMnVo.setBlInvCfmDt("");
				noGoodFlg = "Y";
			}
			*/
			
			dbDao.addOtherInvMain(invArMnVo);				
							
			MdmOrganizationVO mdmOrganizationVO = new MdmOrganizationVO();
			mdmOrganizationVO = dbDao.searchInvCoaRgnInvCoaCtr(genIfVo.getInvArIfMnVO().getOfcCd()); 
			
			if (mdmOrganizationVO != null) {
				invCoaRgnCd = mdmOrganizationVO.getFincRgnCd();
				invCoaCtrCd = mdmOrganizationVO.getArCtrCd();
			}
			
			/*
			invArAmtVo = new InvArAmtVO();
			
			invArAmtVo.setArInvSrcCd("NISAR");
			invArAmtVo.setInvCoaCoCd("01");
			invArAmtVo.setInvCoaRgnCd(invCoaRgnCd);
			invArAmtVo.setInvCoaCtrCd(invCoaCtrCd);
			invArAmtVo.setInvCoaInterCoCd("00");
			invArAmtVo.setInvCoaVslCd("0000");
			invArAmtVo.setInvCoaVoyNo("0000");
			invArAmtVo.setInvCoaSkdDirCd("0");
			invArAmtVo.setInvCoaRevDirCd("0");
			invArAmtVo.setErpIfGlDt(glEffDt);   
			invArAmtVo.setErpIfOfcCd(arOfcCd);
			
			/////////////////////////////////////////////////////////
			// INV_AR_AMT table save	
			dbDao.addOtherInvAmount(arIfNo, "", invArMnVo, invArAmtVo);
			*/ 		
			
			List<InvArAmtVO> invArAmtVOs = dbDao.searchInvArAmount(arIfNo);
			
			if (invArAmtVOs.size() > 0) {
				for (int i = 0; i < invArAmtVOs.size(); i++) {
					
					invArAmtVOs.get(i).setArInvSrcCd("NISAR");
					invArAmtVOs.get(i).setInvCoaCoCd("01");
					invArAmtVOs.get(i).setInvCoaRgnCd(invCoaRgnCd);
					invArAmtVOs.get(i).setInvCoaCtrCd(invCoaCtrCd);
					invArAmtVOs.get(i).setInvCoaAcctCd("");
					invArAmtVOs.get(i).setInvCoaInterCoCd("00");
					invArAmtVOs.get(i).setInvCoaVslCd("0000");
					invArAmtVOs.get(i).setInvCoaVoyNo("0000");
					invArAmtVOs.get(i).setInvCoaSkdDirCd("0");
					invArAmtVOs.get(i).setInvCoaRevDirCd("0");
					invArAmtVOs.get(i).setErpIfGlDt(glEffDt);
					invArAmtVOs.get(i).setErpIfOfcCd(arOfcCd);	
					invArAmtVOs.get(i).setCreUsrId(genIfVo.getInvArIfMnVO().getCreUsrId());
					invArAmtVOs.get(i).setUpdUsrId(genIfVo.getInvArIfMnVO().getUpdUsrId());	
				}
			}
			
			dbDao.addInvAmount(invArAmtVOs);
			dbDao.modifyInvArChg(arIfNo);
			
			/////////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////
			// INV_AR_CNTR information setting.
			/*
			if (genIfVo.getInvArIfCntrVOs() != null) {
				
				invArCntrVos = new ArrayList<InvArCntrVO>();

				for (int rowNum3 = 0; rowNum3 < genIfVo.getInvArIfCntrVOs().size(); rowNum3++) {
					invArCntrVo = new InvArCntrVO();

					invArCntrVo.setArIfNo(arIfNo);
					invArCntrVo.setCntrSeq(Integer.toString(rowNum3 + 1));
					invArCntrVo.setCntrNo(genIfVo.getInvArIfCntrVOs().get(rowNum3).getCntrNo());
					invArCntrVo.setCntrTpszCd(genIfVo.getInvArIfCntrVOs().get(rowNum3).getCntrTpszCd());
					invArCntrVo.setCreUsrId(genIfVo.getInvArIfCntrVOs().get(rowNum3).getCreUsrId());
					invArCntrVo.setCreDt(genIfVo.getInvArIfCntrVOs().get(rowNum3).getCreDt());
					invArCntrVo.setUpdUsrId(genIfVo.getInvArIfCntrVOs().get(rowNum3).getUpdUsrId());
					invArCntrVo.setUpdDt(genIfVo.getInvArIfCntrVOs().get(rowNum3).getUpdDt());

					invArCntrVos.add(invArCntrVo);
					
					//cntrNos = cntrNos + invArCntrVos.get(rowNum3).getCntrNo() + (rowNum3 != genIfVo.getInvArIfCntrVOs().size() - 1 ? "," : "");
					cntrNosSb.append(invArCntrVos.get(rowNum3).getCntrNo()).append((rowNum3 != genIfVo.getInvArIfCntrVOs().size() - 1 ? "," : ""));
				}
				
				if (cntrNosSb.toString().length() > 150) { 
					cntrNos = cntrNosSb.toString().substring(0, 150);
					lastIdx = cntrNos.lastIndexOf(",");		
					cntrNos = cntrNos.substring(0, lastIdx);	
				}
				
				if (invArCntrVos.size() > 0) {
					bookingARCreationBC.addOtherInvContainer(invArCntrVos);
					
				}
			}
			*/
			
			InvArIssVO invArIssVO = new InvArIssVO();
			
			invArIssVO.setInvNo(newInvNo);
			invArIssVO.setOfcCd(arOfcCd);
			invArIssVO.setUserId(invArMnVo.getCreUsrId());
			invArIssVO.setIssGrpTpCd("C");
			invArIssVO.setIssDt(invArMnVo.getIssDt());
			
			dbDao.addInvIss(invArIssVO);
			dbDao.addInvIssDtl(invArIssDtlVOs);
			
			// INV_AR_IF_MN Table AR_IF_NO update
			dbDao.modifyIfNo(srcIfDt, srcIfSeq, arIfNo, genIfVo.getInvArIfMnVO().getOfcCd(), genIfVo.getInvArIfMnVO().getUpdUsrId());
			
			///////////////////////////////////////////////////////////
			///////////////////////////////////////////////////////////
			// ISSUE process

			/*
			if((arInvIssFlg.equals("N")) ||
			   (!genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") &&
			    !genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET") &&
			    !genIfVo.getInvArIfMnVO().getIfSrcCd().equals("TPB"))) {

				InvIssMainVO issMainVo = null;	
				InvIssMainVO[] issMainVos = new InvIssMainVO[1];
				IssueOptionVO issOptionVO = new IssueOptionVO();
				
				issMainVo = new InvIssMainVO();
				
				issMainVo.setInvNo(genIfVo.getInvArIfMnVO().getInvSrcNo());
				
				issMainVo.setCreUsrId(genIfVo.getInvArIfMnVO().getCreUsrId());
				issMainVos[0] = issMainVo;
				issOptionVO.setIssueGubn("O");
				issOptionVO.setIssOfcCd(genIfVo.getInvArIfMnVO().getOfcCd());
				issOptionVO.setSendFlag("");
				issOptionVO.setSendFlag2("");
				*/
				/*
				// Issue Data creation
				invoiceIssueBC.createIssueMain(issMainVos, issOptionVO, genIfVo.getInvArIfMnVO().getCreUsrId());
				
				if (genIfVo.getInvArIfChgVOs() != null) {						
					for (int rowNum5 = 0; rowNum5 < invArChgVos.size(); rowNum5++) {

						IssueEachTargetVO issEachTgtVo = new IssueEachTargetVO();
						
						issEachTgtVo.setArIfNo(arIfNo);
						issEachTgtVo.setArIfSerNo(invArChgVos.get(rowNum5).getArIfSerNo());
						issEachTgtVo.setChgSeq(invArChgVos.get(rowNum5).getChgSeq());
						
						// INV_AR_ISS_DTL Data Creation
						invoiceIssueBC.createInvoiceMapping(issMainVo.getInvNo(), issEachTgtVo, genIfVo.getInvArIfMnVO().getCreUsrId());
					}
				
				}
				
				// invno issdt update logic add.
				bookingARCreationBC.modifyIssueFlag(issMainVo.getInvNo(), invArMnVo.getInvIssFlg(), genIfVo.getInvArIfMnVO().getCreUsrId());
				*/
			//}							

			//if(("N").equals(noGoodFlg)){
				//2014.07.07 AR OTS Creation
				List<InvArIfNoVO> ifNos = new ArrayList<InvArIfNoVO>();
				InvArIfNoVO invArIfNoVO = new InvArIfNoVO();
				invArIfNoVO.setIfNo(arIfNo);
				ifNos.add(invArIfNoVO);

				command.createOutstandingInfo(ifNos);
			//}
			
			/*
			if (errFlag.equals("Y")) {
				return "E::"+errRsn;
			} else {
				return "S::"+arIfNos;
			}
			*/
						
			return null;
			
		} catch(DAOException ex) {
			log.error("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>dao err:" + ex.getMessage());
			throw new EventException(new ErrorHandler("INV00053",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>exp err:" + ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Create VVD Ex. Rate<br>
	 * 
	 * @param String arOfcCd
	 * @param String vvdCd
	 * @exception EventException
	 */
	public void createVVDExRate(String arOfcCd, String vvdCd) throws EventException{
		try {
			dbDao.addVVDExchangeRate(arOfcCd, vvdCd);
		} catch(DAOException ex) {
			log.error("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>dao err:" + ex.getMessage());
			throw new EventException(new ErrorHandler("INV00053",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>exp err:" + ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Create Daily USD Ex. Rate<br>
	 * 
	 * @param String arOfcCd
	 * @exception EventException
	 */
	public void createDailyUSDExRate(String arOfcCd) throws EventException{
		try {
			dbDao.addDailyUSDExchangeRate(arOfcCd);
		} catch(DAOException ex) {
			log.error("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>dao err:" + ex.getMessage());
			throw new EventException(new ErrorHandler("INV00053",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>exp err:" + ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * New I/F receivables data's VVD, Lane, Scope, Port, S/A Date, <br>
	 * Sailing Date, Revenue VVD, Revenue Lane information retrieve<br>
	 * 
	 * @param String bkgNo
	 * @param String bkgSeq
	 * @param String ioBndCd
	 * @param String ofcCd
	 * @return VvdLanePortVO
	 * @exception EventException
	 */
	public VvdLanePortVO searchVVDForNewInterface(String bkgNo, String bkgSeq, String ioBndCd, String ofcCd) throws EventException{
		VvdLanePortVO vvdLanePortVO = new VvdLanePortVO();
		String portCd = "";
		String vvd = "";
		String sailArrDt = "";
		String slanCd = "";
		String svcScpCd = "";
		//String revVvd = "";
		//String rlaneCd ="";
		String sailDt = "";
		String polCd = "";
		String podCd = "";
		String porCd = "";
		String delCd = "";
		String znIocCd = "";
		String tmpVvd = "";
		String orgVvd = "";
		try {
			
			VvdPortVO vvdPortVO = new VvdPortVO();
			vvdPortVO = dbDao.searchPort(bkgNo, bkgSeq, ioBndCd);
			
			portCd = vvdPortVO.getPortCd();
			polCd = vvdPortVO.getPolCd();
			podCd = vvdPortVO.getPodCd();
			porCd = vvdPortVO.getPorCd();
			delCd = vvdPortVO.getDelCd();
			
			vvd = dbDao.searchPolPodVvd(bkgNo, bkgSeq, ioBndCd);
			
			if(vvd != null && !vvd.equals("")){
				if(vvd.substring(0,4).equals("CFDR")){
					
					sailArrDt = "20" + vvd.substring(4,8) + "01";
				
				} else {
					VvdSaDtVO vvdSaDtVO = dbDao.searchVVDSaDt(bkgNo, bkgSeq, portCd, ioBndCd);
					
					if(vvdSaDtVO != null){
						//vvd = vvdSaDtVO.getVvd();
						sailArrDt =  vvdSaDtVO.getSailArrDt();
					}
					
					if(sailArrDt == null || ("").equals(sailArrDt)){
						orgVvd = vvd;
						vvdSaDtVO = dbDao.searchVVDSaDtByVslVoy(orgVvd.substring(0,4), orgVvd.substring(4,8), orgVvd.substring(8,9), portCd, ioBndCd, "A");
						
						if(vvdSaDtVO != null){
							vvd = vvdSaDtVO.getVvd();
							sailArrDt =  vvdSaDtVO.getSailArrDt();
						}
						
						if(sailArrDt == null || ("").equals(sailArrDt)){
							vvdSaDtVO = dbDao.searchVVDSaDtByVslVoy(orgVvd.substring(0,4), orgVvd.substring(4,8), orgVvd.substring(8,9), portCd, ioBndCd, "B");
							
							if(vvdSaDtVO != null){
								vvd = vvdSaDtVO.getVvd();
								sailArrDt =  vvdSaDtVO.getSailArrDt();
							}
							
							if(sailArrDt == null || ("").equals(sailArrDt)){
								vvd = "CFDR1608E";
								sailArrDt = "20160801";
							}
						}
					}
					
				}
			}
			
			tmpVvd = dbDao.searchPolPodVvd(bkgNo, bkgSeq, "O");
			
			if(tmpVvd != null && !tmpVvd.equals("")){
				if(tmpVvd.substring(0,4).equals("CFDR")){
					sailDt = "20" + tmpVvd.substring(4,8) + "01";
				}else{
					sailDt = dbDao.searchSailingDate(bkgNo);
				}
			}
			
			//String svrId = dbDao.searchServerID(ofcCd);
			
			// If VVD, S/A Date is not exist or Europe			
			//2015.03.24	if((vvd==null||sailArrDt==null)||svrId.equals("EUR")){
			/*
			if(vvd==null||sailArrDt==null){	
				vvdPortVO = dbDao.searchTvvdPort(bkgNo, bkgSeq, ioBndCd);
				if(vvdPortVO != null){
					vvd = vvdPortVO.getVvd()!=null&&!vvdPortVO.getVvd().equals("")?vvdPortVO.getVvd():"";
					portCd = vvdPortVO.getPortCd()!=null&&!vvdPortVO.getPortCd().equals("")?vvdPortVO.getPortCd():"";
				}
				
				if(vvd != null){
					sailArrDt = dbDao.searchTrunkSaDt( vvd, portCd, ioBndCd );
				} else {
					sailArrDt = dbDao.searchTrunkSaDt( null, portCd, ioBndCd );
				}
			}
			*/
			
			slanCd = dbDao.searchLane( bkgNo, bkgSeq );
			svcScpCd = dbDao.searchServiceScope( bkgNo, bkgSeq );
			
			/*
			RevVVDLaneVO revVVDLaneVO = dbDao.searchRevenueVVDLane(bkgNo);
			
			if(revVVDLaneVO != null){
				revVvd = revVVDLaneVO.getRevVvd();
				rlaneCd = revVVDLaneVO.getRlaneCd();				
			}
			
			if(revVvd.equals("X")){
				revVVDLaneVO = dbDao.searchRevenueVVDLaneRd(vvd);
				if(revVVDLaneVO != null){
					revVvd = revVVDLaneVO.getRevVvd();
					rlaneCd = revVVDLaneVO.getRlaneCd();
					znIocCd = "OO";
				}
			}
			*/
			
			vvdLanePortVO.setPortCd(portCd);
			if(vvd != null && !vvd.equals("")){
				vvdLanePortVO.setVvd(vvd);
			} else {
				vvdLanePortVO.setVvd(null);
			}
			vvdLanePortVO.setSailArrDt(sailArrDt==null?"":sailArrDt);
			vvdLanePortVO.setSlanCd(slanCd);
			vvdLanePortVO.setSvcScpCd(svcScpCd);
			if(vvd == null || vvd.equals("")) vvdLanePortVO.setRevVvd("");
			else vvdLanePortVO.setRevVvd(vvd+vvd.substring(8,9));
			vvdLanePortVO.setRlaneCd("");
			vvdLanePortVO.setSailDt(sailDt);
			vvdLanePortVO.setPolCd(ioBndCd.equals("O")?portCd:polCd);
			vvdLanePortVO.setPodCd(ioBndCd.equals("I")?portCd:podCd);
			vvdLanePortVO.setZnIocCd(znIocCd);
			vvdLanePortVO.setPorCd(porCd);
			vvdLanePortVO.setDelCd(delCd);
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		
		return vvdLanePortVO;
	}
	
	/**
	 * A/R Office information retrieve.<br>
	 * 
	 * @param CutOffLaneVO cutOffLaneVO
	 * @return ArOfficeVO
	 * @exception EventException
	 */
	public ArOfficeVO searchAROfficeList(CutOffLaneVO cutOffLaneVO) throws EventException{
		ArOfficeVO arOfficeVO = new ArOfficeVO();
		String arOfcCd = "";
		String cutOffAplyDtTpCd = "";
		String aplyDt = "";
		String arCurrCd = "";
		String arCtrCd = "";
		String arHdQtrOfcCd = "";
		String locCd = "";
		String rgnCd = "";
		String soIfCd = "";
		String arAgnStlCd = "";
		String arCtrlOfcCd = "";
		String repCustCntCd = "";
		String repCustSeq = "";
		String subAgnFlg = "";
		try{
			//A/R Office,Sub Agent Mark
			ArOfcAgtMkVO arOfcAgtMkVO = dbDao.searchAROfficeAgtMk ( cutOffLaneVO.getOfcCd() );
			
			arOfcCd = arOfcAgtMkVO.getArOfcCd()!=null&&!arOfcAgtMkVO.getArOfcCd().equals("")?arOfcAgtMkVO.getArOfcCd():"";
			arAgnStlCd = arOfcAgtMkVO.getArAgnStlCd()!=null&&!arOfcAgtMkVO.getArAgnStlCd().equals("")?arOfcAgtMkVO.getArAgnStlCd():"";
			
			/*
			//cut_off_aply_dt_tp_cd, aply_dt, new_ar_ofc_cd
			ArOfcApplDtVO arOfcApplDtVO =  dbDao.searchCutOffLaneOffice(arOfcCd.equals("")?cutOffLaneVO.getOfcCd():arOfcCd, cutOffLaneVO.getVvd(), cutOffLaneVO.getIoBndCd(), cutOffLaneVO.getPortCd(), cutOffLaneVO.getSailArrDt());
			
			arOfcCd = arOfcApplDtVO.getArOfcCd()!=null&&!arOfcApplDtVO.getArOfcCd().equals("")?arOfcApplDtVO.getArOfcCd():arOfcCd; 
			cutOffAplyDtTpCd = arOfcApplDtVO.getCutOffAplyDtTpCd()!=null&&!arOfcApplDtVO.getCutOffAplyDtTpCd().equals("")?arOfcApplDtVO.getCutOffAplyDtTpCd():"";
			aplyDt = arOfcApplDtVO.getAplyDt()!=null&&!arOfcApplDtVO.getAplyDt().equals("")?arOfcApplDtVO.getAplyDt():"";
			*/
			
			//A/R Office, Local Currency, Center Code, Region Code, Office Euro Mark, Office Agent Mark, Sub Agent Mark, customer code
			ArOfcAttributeVO arOfcAttributeVO =  dbDao.searchOfficeAttribute(arOfcCd);
			if(arOfcAttributeVO!=null){
				arCurrCd = arOfcAttributeVO.getArCurrCd();
				arCtrCd = arOfcAttributeVO.getArCtrCd();
				arHdQtrOfcCd = arOfcAttributeVO.getArHdQtrOfcCd();
				locCd = arOfcAttributeVO.getLocCd();
				rgnCd = arOfcAttributeVO.getRgnCd();
				soIfCd = arOfcAttributeVO.getSoIfCd();
				arAgnStlCd = arOfcAttributeVO.getArAgnStlCd();
				arCtrlOfcCd = arOfcAttributeVO.getArCtrlOfcCd();
				repCustCntCd = arOfcAttributeVO.getRepCustCntCd();
				repCustSeq = arOfcAttributeVO.getRepCustSeq();
				subAgnFlg = arOfcAttributeVO.getSubAgnFlg();
			}			
			
			arOfficeVO.setArOfcCd(arOfcCd);
			arOfficeVO.setCutOffAplyDtTpCd(cutOffAplyDtTpCd);
			arOfficeVO.setAplyDt(aplyDt);
			arOfficeVO.setArCurrCd(arCurrCd);
			arOfficeVO.setArCtrCd(arCtrCd);
			arOfficeVO.setArHdQtrOfcCd(arHdQtrOfcCd);
			arOfficeVO.setLocCd(locCd);
			arOfficeVO.setRgnCd(rgnCd);
			arOfficeVO.setSoIfCd(soIfCd);
			arOfficeVO.setArAgnStlCd(arAgnStlCd);
			arOfficeVO.setArCtrlOfcCd(arCtrlOfcCd);
			arOfficeVO.setRepCustCntCd(repCustCntCd);
			arOfficeVO.setRepCustSeq(repCustSeq);
			arOfficeVO.setSubAgnFlg(subAgnFlg);
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		
		return arOfficeVO;
	}
	
	/**
	 * Actual / Invoice Customer Code retrieve<br>
	 * 
	 * @param CustInputVO custInputVO 
	 * @return ActInvCustVO
	 * @exception EventException
	 */
	public ActInvCustVO searchCustomerCode(CustInputVO custInputVO) throws EventException{
		ActInvCustVO actInvCustVO = new ActInvCustVO();
		String actCustCntCd = "";
		String actCustSeq = "";
		String invCustCntCd = "";
		String invCustSeq = "";
		
		try{
			invCustCntCd = custInputVO.getCustCntCd();
			invCustSeq = custInputVO.getCustSeq();
			
			/*
			actInvCustVO = dbDao.searchMaxInterfaceCustomerCode(custInputVO.getArOfcCd(),custInputVO.getBlSrcNo());
			
			if(actInvCustVO.getActCustCntCd()!=null&&!actInvCustVO.getActCustCntCd().equals("")){
					actCustCntCd = actInvCustVO.getActCustCntCd()!=null&&!actInvCustVO.getActCustCntCd().equals("")?actInvCustVO.getActCustCntCd():invCustCntCd;
					actCustSeq   = actInvCustVO.getActCustSeq()!=null&&!actInvCustVO.getActCustSeq().equals("")?actInvCustVO.getActCustSeq():invCustSeq;
					invCustCntCd = actInvCustVO.getInvCustCntCd()!=null&&!actInvCustVO.getInvCustCntCd().equals("")?actInvCustVO.getInvCustCntCd():invCustCntCd;
					invCustSeq   = actInvCustVO.getInvCustSeq()!=null&&!actInvCustVO.getInvCustSeq().equals("")?actInvCustVO.getInvCustSeq():invCustSeq;
					
			}else{			
			*/	
				//Charge Indicator = 'P' or 'C'
				if(custInputVO.getIoBndCd().equals("I")||custInputVO.getIoBndCd().equals("O")){
					
					/*
					// If Charge Indicator = 'T'
					if(custInputVO.getN3rdFlg().equals("Y")){
						actCustCntCd = custInputVO.getCustCntCd();
						actCustSeq = custInputVO.getCustSeq();
					}
					*/
					
					if(actCustCntCd.equals("")||actCustSeq.equals("")){
						/*
						// Sub Agent Mark Booking Office setting
						ArOfcAttributeVO arOfcAttributeVO =  dbDao.searchOfficeAttribute(custInputVO.getOfcCd());
						String subAgnFlg = "";
						if(arOfcAttributeVO!=null){
							subAgnFlg = arOfcAttributeVO.getSubAgnFlg();
						}
						
						//Sub Agent Mark = 'N' 				
						if(subAgnFlg.equals("N")){*/
							actInvCustVO = dbDao.searchActualCustomerCode(invCustCntCd,invCustSeq);
							
							actCustCntCd = actInvCustVO.getActCustCntCd()!=null&&!actInvCustVO.getActCustCntCd().equals("")?actInvCustVO.getActCustCntCd():custInputVO.getCustCntCd();
							actCustSeq   = actInvCustVO.getActCustSeq()!=null&&!actInvCustVO.getActCustSeq().equals("")?actInvCustVO.getActCustSeq():custInputVO.getCustSeq();							
						/*
						//Sub Agent Mark = 'Y' in case Bkg Office's Customer
						}else if(subAgnFlg.equals("Y")){
							actInvCustVO = dbDao.searchRepCustomerCode(custInputVO.getOfcCd());
							
							actCustCntCd = actInvCustVO.getActCustCntCd()!=null&&!actInvCustVO.getActCustCntCd().equals("")?actInvCustVO.getActCustCntCd():custInputVO.getCustCntCd();
							actCustSeq   = actInvCustVO.getActCustSeq()!=null&&!actInvCustVO.getActCustSeq().equals("")?actInvCustVO.getActCustSeq():custInputVO.getCustSeq();
							
						}else{							
							actCustCntCd = custInputVO.getCustCntCd();
							actCustSeq = custInputVO.getCustSeq();							
						}*/
					}
					
				}  
			//}
			
			actInvCustVO.setActCustCntCd(actCustCntCd);
			actInvCustVO.setActCustSeq(actCustSeq);
			actInvCustVO.setInvCustCntCd(invCustCntCd);
			actInvCustVO.setInvCustSeq(invCustSeq);
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		
		return actInvCustVO;
	}
	
	/**
	 * Actual Customer's Credit Flag, Credit Term, Due Date information retrieve.<br>
	 * 
	 * @param ARCreditInputVO arCrdtVo
	 * @return ARCreditVO
	 * @exception EventException
	 */
	public ARCreditVO searchARCredit(ARCreditInputVO arCrdtVo) throws EventException{
		ARCreditVO aRCreditVO = new ARCreditVO();
		ARInvoiceCreationVO invCreVo = new ARInvoiceCreationVO();
		String dueDt = "";
		String crTermDys = "";
		String custCrFlg = "";
		//String otsSmryCd = "";
		//String svrId = "";
		//int ifCnt = 0;
		
		try{
			invCreVo.setCustCntCd(arCrdtVo.getActCustCntCd());
			invCreVo.setCustSeq(arCrdtVo.getActCustSeq());
			invCreVo.setOfcCd(arCrdtVo.getArOfcCd());
			invCreVo.setSailArrDt(arCrdtVo.getSailArrDt().replace("-", ""));
			invCreVo.setIoBndCd(arCrdtVo.getIoBndCd());
			invCreVo.setDueDt("X");

			invCreVo.setLocCd(arCrdtVo.getLocCd());
			aRCreditVO = dbDao.searchCreditCustomerForCredit(invCreVo); 
			
			if(aRCreditVO != null){
				dueDt = aRCreditVO.getDueDt()!=null?aRCreditVO.getDueDt():"";
				crTermDys = aRCreditVO.getCrTerm()!=null?aRCreditVO.getCrTerm():"0";
				custCrFlg = aRCreditVO.getCrFlg()!=null?aRCreditVO.getCrFlg():"";
			}
			// If Credit Customer data is not exist or Credit term = 0
			if(dueDt.equals("")||crTermDys.equals("0")){
				aRCreditVO = dbDao.searchOfficeForCredit(invCreVo);
				
				if(aRCreditVO != null){
					dueDt = aRCreditVO.getDueDt()!=null?aRCreditVO.getDueDt():"";
					crTermDys = aRCreditVO.getCrTerm()!=null?aRCreditVO.getCrTerm():"0";
					custCrFlg = aRCreditVO.getCrFlg()!=null?aRCreditVO.getCrFlg():"";
				}
			}
			
			if(aRCreditVO != null){
				if(dueDt != null){
					aRCreditVO.setDueDt(dueDt);
				} else {
					aRCreditVO.setDueDt(null);
				}
				if(crTermDys != null){
					aRCreditVO.setCrTerm(crTermDys);
				} else {
					aRCreditVO.setCrTerm(null);
				}
				if(custCrFlg != null){
					aRCreditVO.setCrFlg(custCrFlg);
				} else {
					aRCreditVO.setCrFlg(null);
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		
		return aRCreditVO;
	}
	
	/**
	 * Booking Interface data creation.<br>
	 * 
	 * @param ARInvoiceCreationVO invCreVo
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */
	public String createBKGInvoice (ARInvoiceCreationVO invCreVo, String userId) throws EventException{
		//INVCommonUtil utilCmd = new INVCommonUtil();
		//ARInvoiceExRateMgtBC command = new ARInvoiceExRateMgtBCImpl();
		//VVDExrateInputVO vvdExrateVo = new VVDExrateInputVO();
		String rtIfNo = "";
		try {
			
			InvArMnVO invArMnVO = invCreVo.getInvArMnVO();
			List<InvArChgVO> invArChgVOs = invCreVo.getInvArChgVOs();
			//List<InvArCntrVO> invArCntrVOs = invCreVo.getInvArCntrVOs();
			
			String newIfNo = dbDao.searchBKGInterfaceNo(invArMnVO.getInvSrcNo(), invArMnVO.getBkgSeq(), invArMnVO.getArOfcCd());			
			
			/*
			if (maxSeq == null) {
				dbDao.addNewInterfaceNo(invArMnVO.getArOfcCd(), userId);
				maxSeq = "00000001";				
			} else {
				dbDao.modifyNewInterfaceNo(invArMnVO.getArOfcCd(), maxSeq, userId);
			}
			*/
			
			//String newIfNo = invArMnVO.getArOfcCd().substring(0, 3) + maxSeq;
			String newInvNo = dbDao.searchMaxInvoiceNo("BKG", invArMnVO.getInvSrcNo(), invArMnVO.getBkgSeq(), invArMnVO.getArOfcCd());
			
			invArMnVO.setArIfNo(newIfNo);			
			invArMnVO.setCreUsrId(userId);
			invArMnVO.setUpdUsrId(userId);
			invArMnVO.setInvDeltDivCd("N");
			//Bkg Interface Split Flag null setting.
			invArMnVO.setInvSplitCd("");
			invArMnVO.setInvVvdCxlCd("N");			
			invArMnVO.setBlInvCfmDt("");
			//Main Table Iss Flg setting
			invArMnVO.setInvIssFlg("Y");
			invArMnVO.setInvClrFlg("N");

			invArMnVO.setInvNo(newInvNo);
			//invArMnVO.setIssDt("");
			
			String revTpSrcCd = invArMnVO.getRevTpCd()+invArMnVO.getRevSrcCd();
			//String svrId = dbDao.searchServerID(invArMnVO.getArOfcCd());
			
			//com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.ExchangeRateVO exchangeRateVo = null;
			ExchangeRateVO exchangeRateVo = new ExchangeRateVO();
			VVDCustomerVO vvdCustomerVo = new VVDCustomerVO();
			
			vvdCustomerVo.setInvCntryCd(invArMnVO.getInvCustCntCd());
			vvdCustomerVo.setInvCustCd(invArMnVO.getInvCustSeq());
			vvdCustomerVo.setVsl(invArMnVO.getVslCd());
			vvdCustomerVo.setVoy(invArMnVO.getSkdVoyNo());
			vvdCustomerVo.setDep(invArMnVO.getSkdDirCd());
			vvdCustomerVo.setLclCurr(invArMnVO.getLoclCurrCd());
			vvdCustomerVo.setSvcScp(invArMnVO.getInvSvcScpCd());
			vvdCustomerVo.setBnd(invArMnVO.getIoBndCd());
			vvdCustomerVo.setOfcCd(invArMnVO.getArOfcCd());
			vvdCustomerVo.setBkgNo(invArMnVO.getBkgNo());
			vvdCustomerVo.setSaDt(invArMnVO.getSailArrDt());
			vvdCustomerVo.setPol(invArMnVO.getPolCd());
			vvdCustomerVo.setPod(invArMnVO.getPodCd());
			vvdCustomerVo.setObrdDt(invArMnVO.getObrdDt());
			
			/*
			vvdExrateVo.setVsl(invArMnVO.getVslCd());
            vvdExrateVo.setVoy(invArMnVO.getSkdVoyNo());
            vvdExrateVo.setDep(invArMnVO.getSkdDirCd());
            vvdExrateVo.setBnd(invArMnVO.getIoBndCd());
            vvdExrateVo.setPol(invArMnVO.getPolCd());
            vvdExrateVo.setPod(invArMnVO.getPodCd());
            vvdExrateVo.setLclCurr(invArMnVO.getLoclCurrCd());
            vvdExrateVo.setSvcScp(invArMnVO.getInvSvcScpCd());
            vvdExrateVo.setOfcCd(invArMnVO.getArOfcCd());
			*/
			
            //BigDecimal invTtlLoclAmt = new BigDecimal("0");
			//int currPoint = 0;
			
            /*
            //2015.04.24 in case of 3rd office, create VVD exrate automatically
            if(("Y").equals(invArMnVO.getN3rdFlg())){
				vvdCustomerVo.setCurr("USD");
				exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);
				
				if(("V").equals(exchangeRateVo.getUsdExrateType()) || ("V").equals(exchangeRateVo.getThirdExrateType())){
					
					VVDExrateVO[] vvdXchVos = new VVDExrateVO[1];
					VVDExrateVO vvdXchVo = dbDao.searchVVDExrateDateForThirdOffice(vvdCustomerVo);
					
					if(vvdXchVo != null) {
						vvdXchVos[0] = vvdXchVo;
						command.manageVVDExchangeRateDate(vvdXchVos, userId, "N");
					}
				}
			}
            */
            
			List<InvArIssDtlVO> invArIssDtlVOs = new ArrayList<InvArIssDtlVO>();
			
			for (int i = 0; i < invArChgVOs.size(); i++) {
				
				String tjSrcNm = "";
				String invRevTpSrcCd = "";
				
				vvdCustomerVo.setLclCurr(invArMnVO.getLoclCurrCd());
				vvdCustomerVo.setCurr(invArChgVOs.get(i).getCurrCd());
				
				exchangeRateVo = searchExchangeRate(vvdCustomerVo);	
				
				invArChgVOs.get(i).setInvXchRt(exchangeRateVo.getExRate());
				invArChgVOs.get(i).setInvXchRtDt(exchangeRateVo.getExRateDate());
				
				tjSrcNm = dbDao.searchTjSrcNm(invArMnVO.getArOfcCd(),invArChgVOs.get(i).getChgCd(), revTpSrcCd, "");
				
				invRevTpSrcCd = revTpSrcCd;  //dbDao.searchArInvRevTpSrcCd(invArMnVO.getArOfcCd(), invArChgVOs.get(i).getChgCd(), invArMnVO.getRevTpCd(), invArMnVO.getRevSrcCd(), svrId);
				
				invArChgVOs.get(i).setInvRevTpSrcCd(invRevTpSrcCd);
				
				invArChgVOs.get(i).setTjSrcNm(tjSrcNm);
				invArChgVOs.get(i).setArIfNo(newIfNo);
				invArChgVOs.get(i).setArIfSerNo("1");
				invArChgVOs.get(i).setSobId("1");				                                                                                                                           
				invArChgVOs.get(i).setMnlFlg("N");  
				invArChgVOs.get(i).setInvIssFlg("Y");
				invArChgVOs.get(i).setInvClrFlg("N");					
				invArChgVOs.get(i).setChgSeq(Integer.toString(i+1));
				invArChgVOs.get(i).setCreUsrId(userId);
				invArChgVOs.get(i).setUpdUsrId(userId);	
				invArChgVOs.get(i).setOfcCd(invArMnVO.getArOfcCd());		
				
				/*
				// VVD rates is 0 in case VVD rates table Insert
				if((exchangeRateVo.getUsdExrateType().equals("V") && invArChgVOs.get(i).getCurrCd().equals("USD")) || (exchangeRateVo.getThirdExrateType().equals("V") && !invArChgVOs.get(i).getCurrCd().equals("USD"))){
					vvdExrateVo.setCurr(invArChgVOs.get(i).getCurrCd());
					if(!invArMnVO.getLoclCurrCd().equals(invArChgVOs.get(i).getCurrCd())){
						dbDao.addVVDExRate(vvdExrateVo,userId);
					}
				}
				*/
				
				//Add USD_XCH_RT in INV_AR_CHG table - 2015.03.04
				vvdCustomerVo.setLclCurr("USD");
				exchangeRateVo = searchExchangeRate(vvdCustomerVo);	
				invArChgVOs.get(i).setUsdXchRt(exchangeRateVo.getExRate());
				
				InvArIssDtlVO invArIssDtlVO = new InvArIssDtlVO();
				
				invArIssDtlVO.setInvNo(newInvNo);
				invArIssDtlVO.setArIfNo(newIfNo);
				invArIssDtlVO.setChgSeq(invArChgVOs.get(i).getChgSeq());
				invArIssDtlVO.setUserId(userId);
				
				invArIssDtlVOs.add(invArIssDtlVO);
				
				if(invArChgVOs.get(i).getInvXchRt().equals("0") || invArChgVOs.get(i).getInvXchRt().equals("") ||
				   invArChgVOs.get(i).getUsdXchRt().equals("0") || invArChgVOs.get(i).getUsdXchRt().equals("")){
					dbDao.modifyInvArIfStatus(invArMnVO.getInvSrcNo(), invArMnVO.getBkgSeq(), "E", new ErrorHandler("INV00098", new String[] {}).getUserMessage(), userId);
					return "";
				}
			}
			
			vvdCustomerVo.setLclCurr(invArMnVO.getLoclCurrCd());
			vvdCustomerVo.setCurr("USD");
			exchangeRateVo = searchExchangeRate(vvdCustomerVo);
			
			/*
			//VVD rates is 0 in case VVD rates table Insert
			if(exchangeRateVo.getUsdExrateType().equals("V")){
				vvdExrateVo.setCurr("USD");	
				if(!invArMnVO.getLoclCurrCd().equals("USD")){
					dbDao.addVVDExRate(vvdExrateVo,userId);
				}
			}
			*/
			
			invArMnVO.setUsdXchRt(exchangeRateVo.getExRate());
			invArMnVO.setInvLoclXchRt(exchangeRateVo.getExRate());
			invArMnVO.setXchRtUsdTpCd(exchangeRateVo.getUsdExrateType());
			invArMnVO.setXchRtN3rdTpCd(exchangeRateVo.getThirdExrateType());
			invArMnVO.setXchRtDt(exchangeRateVo.getExRateDate());

			invArMnVO.setObrdDt(exchangeRateVo.getCngIndivCd().equals("B") ? exchangeRateVo.getExRateDate() : invArMnVO.getObrdDt());

			vvdCustomerVo.setLclCurr("USD");
			vvdCustomerVo.setCurr(invArMnVO.getLoclCurrCd());
			exchangeRateVo = searchExchangeRate(vvdCustomerVo);
			
			invArMnVO.setInvUsdXchRt(exchangeRateVo.getExRate());
			
			if(invArChgVOs.size() > 0) {
				if(!invArMnVO.getLoclCurrCd().equals(invArChgVOs.get(0).getCurrCd()) && !("USD").equals(invArChgVOs.get(0).getCurrCd())){
					invArMnVO.setInvCurrCd(invArMnVO.getLoclCurrCd());
					invArMnVO.setBfrInvCurrCd(invArMnVO.getLoclCurrCd());
				} else {
					invArMnVO.setInvCurrCd(invArChgVOs.get(0).getCurrCd());
					invArMnVO.setBfrInvCurrCd(invArChgVOs.get(0).getCurrCd());
				}
			}
			
			if((invArMnVO.getDueDt()!=null&&invArMnVO.getDueDt().equals("")) || invArMnVO.getDueDt()==null){
				dbDao.modifyInvArIfStatus(invArMnVO.getInvSrcNo(), invArMnVO.getBkgSeq(), "E", new ErrorHandler("JOO00102", new String[] {}).getUserMessage(), userId);
				return "";
			}
			
			if((invArMnVO.getGlEffDt()!=null&&invArMnVO.getGlEffDt().equals("")) || invArMnVO.getGlEffDt()==null){
				dbDao.modifyInvArIfStatus(invArMnVO.getInvSrcNo(), invArMnVO.getBkgSeq(), "E", new ErrorHandler("INV00122", new String[] {}).getUserMessage(), userId);
				return "";
			}
			
			if((invArMnVO.getXchRtUsdTpCd()!=null&&invArMnVO.getXchRtUsdTpCd().equals("")) || invArMnVO.getXchRtUsdTpCd()==null){
				dbDao.modifyInvArIfStatus(invArMnVO.getInvSrcNo(), invArMnVO.getBkgSeq(), "E", new ErrorHandler("INV00098", new String[] {}).getUserMessage(), userId);
				return "";
			}
			
			if((invArMnVO.getXchRtN3rdTpCd()!=null&&invArMnVO.getXchRtN3rdTpCd().equals("")) || invArMnVO.getXchRtN3rdTpCd()==null){
				dbDao.modifyInvArIfStatus(invArMnVO.getInvSrcNo(), invArMnVO.getBkgSeq(), "E", new ErrorHandler("INV00098", new String[] {}).getUserMessage(), userId);
				return "";
			}
			
			if(dbDao.checkAccountRateExist(invArMnVO.getGlEffDt()) == 0){
				dbDao.modifyInvArIfStatus(invArMnVO.getInvSrcNo(), invArMnVO.getBkgSeq(), "E", new ErrorHandler("INV00001", new String[] {}).getUserMessage(), userId);
				return "";
			}
			
			dbDao.addInvMain(invArMnVO);			
			dbDao.addInvCharge(invArChgVOs);	
			
			List<InvArAmtVO> invArAmtVOs = dbDao.searchInvArAmount(newIfNo);
			
			String invCoaInterCoCd =  ""; //dbDao.searchInterCompany(invArMnVO.getActCustCntCd(),invArMnVO.getActCustSeq());	
			
			//CoaVO coaVO = dbDao.searchCOA(invArMnVO.getArOfcCd());
			
			String invCoaCoCd = "";
			String invCoaCtrCd = "";
			String invCoaRgnCd = "";
			
			/*
			if(coaVO!=null){
				invCoaCoCd = coaVO.getInvCoaCoCd()!=null?coaVO.getInvCoaCoCd():"";
				invCoaCtrCd = coaVO.getInvCoaCtrCd()!=null?coaVO.getInvCoaCtrCd():"";
				invCoaRgnCd = coaVO.getInvCoaRgnCd()!=null?coaVO.getInvCoaRgnCd():"";
			}
			*/
			
			String erpIfOfcCd = "";

			String invCoaAcctCd = "";
						
			if (invArAmtVOs.size() > 0) {
				for (int i = 0; i < invArAmtVOs.size(); i++) {
					
					invCoaAcctCd = "";  //dbDao.searchInvCoaAccount( invArAmtVOs.get(i).getTjSrcNm(), svrId , invArMnVO.getRevTpCd(), invArMnVO.getRevSrcCd(), invArMnVO.getAcctCd());
					
					invArAmtVOs.get(i).setArInvSrcCd("NISAR");
					invArAmtVOs.get(i).setInvCoaCoCd(invCoaCoCd);
					invArAmtVOs.get(i).setInvCoaRgnCd(invCoaRgnCd);
					invArAmtVOs.get(i).setInvCoaCtrCd(invCoaCtrCd);
					invArAmtVOs.get(i).setInvCoaAcctCd(invCoaAcctCd);
					invArAmtVOs.get(i).setInvCoaInterCoCd(invCoaInterCoCd);
					invArAmtVOs.get(i).setInvCoaVslCd("0000");
					invArAmtVOs.get(i).setInvCoaVoyNo("0000");
					invArAmtVOs.get(i).setInvCoaSkdDirCd("0");
					invArAmtVOs.get(i).setInvCoaRevDirCd("0");
					invArAmtVOs.get(i).setErpIfGlDt(invArMnVO.getGlEffDt());
					invArAmtVOs.get(i).setErpIfOfcCd(erpIfOfcCd!=null&&!erpIfOfcCd.equals("")?erpIfOfcCd:invArMnVO.getArOfcCd());	
					invArAmtVOs.get(i).setCreUsrId(userId);
					invArAmtVOs.get(i).setUpdUsrId(userId);	
				}
			}
			
			dbDao.addInvAmount(invArAmtVOs);
			
			dbDao.modifyInvArChg(newIfNo);

			//Add to update TVA Flag 2015.05.12
			//dbDao.modifyTVAFlag(invArMnVO.getArOfcCd(), invArMnVO.getBkgNo(), newIfNo);
			
			dbDao.modifyInvTotalLocalAmount(invArMnVO.getArIfNo());
			
			/*
			if (invArCntrVOs.size() > 0) {
				for (int i = 0; i < invArCntrVOs.size(); i++) {
					invArCntrVOs.get(i).setArIfNo(newIfNo);
					invArCntrVOs.get(i).setCreUsrId(userId);
					invArCntrVOs.get(i).setUpdUsrId(userId);
				}
			}

			if (invArCntrVOs.size() > 0) {
				dbDao.addInvContainer(invArCntrVOs, userId);
			}
			*/
			
			/*
			List<InvArIfNoVO> ifNos = new ArrayList<InvArIfNoVO>();
			InvArIfNoVO ifNo = new InvArIfNoVO();
			ifNo.setIfNo(newIfNo);
			ifNos.add(ifNo);
			*/
			
			InvArIssVO invArIssVO = new InvArIssVO();
			
			invArIssVO.setInvNo(newInvNo);
			invArIssVO.setOfcCd(invArMnVO.getArOfcCd());
			invArIssVO.setUserId(userId);
			invArIssVO.setIssGrpTpCd("C");
			invArIssVO.setIssDt(invArMnVO.getIssDt());
			
			dbDao.addInvIss(invArIssVO);
			dbDao.addInvIssDtl(invArIssDtlVOs);
			
			/*
			int cnt = dbDao.checkAccountRateExist(invArMnVO.getGlEffDt());

			String revVslCd2 		 =	invArMnVO.getRevVslCd();
			String revSkdDirCd2      =	invArMnVO.getRevSkdDirCd();
			String revSkdVoyNo2      =	invArMnVO.getRevSkdVoyNo();
			String sailArrDt2        =	invArMnVO.getSailArrDt();
			String sailDt2           =	invArMnVO.getSailDt();
			String dueDt2            =	invArMnVO.getDueDt();
			String xchRtN3rdTpCd2    =	invArMnVO.getXchRtN3rdTpCd();
			String xchRtUsdTpCd2     =	invArMnVO.getXchRtUsdTpCd();
			String arCtyCd2          =	invArMnVO.getArCtyCd();
			String glEffDt2          =	invArMnVO.getGlEffDt();
			String actCustSeq2       =	invArMnVO.getActCustSeq();
			
			if(revVslCd2 == null) revVslCd2 = "";
			if(revSkdDirCd2 == null) revSkdDirCd2 = "";
			if(revSkdVoyNo2 == null) revSkdVoyNo2 = "";
			if(sailArrDt2 == null) sailArrDt2 = "";
			if(sailDt2 == null) sailDt2 = "";
			if(dueDt2 == null) dueDt2 = "";
			if(xchRtN3rdTpCd2 == null) xchRtN3rdTpCd2 = "";
			if(xchRtUsdTpCd2 == null) xchRtUsdTpCd2 = "";
			if(arCtyCd2 == null) arCtyCd2 = "";
			if(glEffDt2 == null) glEffDt2 = "";
			if(actCustSeq2 == null) actCustSeq2 = "";
						
			*/
			//if (cnt > 0) {
			//	if(revVslCd2.equals("") || revSkdDirCd2.equals("") || revSkdVoyNo2.equals("") || sailArrDt2.equals("") || sailDt2.equals("") || dueDt2.equals("")
			//			|| xchRtN3rdTpCd2.equals("") || xchRtUsdTpCd2.equals("") || glEffDt2.equals("") || actCustSeq2.equals("")){
			//		dbDao.modifyCFMDate(invArMnVO.getArIfNo(), "", invArMnVO.getArOfcCd(), invArMnVO.getBlSrcNo());		
			//	}else{
					// ERP I/F process
					dbDao.modifyCFMDate(invArMnVO.getArIfNo(), "good", invArMnVO.getArOfcCd(), invArMnVO.getBlSrcNo());

					rtIfNo = newIfNo;
			//	}
			//}else{
			//	dbDao.modifyCFMDate(invArMnVO.getArIfNo(), "", invArMnVO.getArOfcCd(), invArMnVO.getBlSrcNo());		
			//}		
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
		
		return rtIfNo;
	}
	
	/**
	 * retrieve event process<br>
	 * INVCommonscreen Ex.Rage value.<br>
	 * 
	 * @param VVDCustomerVO exRate
	 * @return ExchangeRateVO
	 * @exception EventException
	 */
	public ExchangeRateVO searchExchangeRate(VVDCustomerVO exRate) throws EventException {
		//log.info("INVCommonBC:searchExchangeRate");
//		DBRowSet rowSet = null;
//		List<ExrateDivisionVO> list = new ArrayList<ExrateDivisionVO>();
		//ExrateDivisionVO exrateDivisionVo = new ExrateDivisionVO();
		//CustExrateInputVO custExrateVo = new CustExrateInputVO();
		//VVDExrateInputVO vvdExrateVo = new VVDExrateInputVO();
		ChinaDailyExrateInputVO chinaDailyExrateVo = new ChinaDailyExrateInputVO();
		ExchangeRateVO exchangeRateVo = new ExchangeRateVO();
		
		//String invCntryCd = "";
		//String invCustCd = "";
		String ofcCd = "";
		String lclCurr = "";
		String curr = "";
		String bnd = "";
		//String vsl = ""; 
		//String voy = "";
		//String dep = "";
		//String pol = "";
		//String pod = "";
		//String saDt = "";
		//String bkgNo = "";
		//String blSrcNo = "";
		//String svcScp = "";
		String arCurr = "";
		//String altnCd = "";
		//String lclFlg = "N";
				
		//String divCd1 = "";
		//String divCd2 = "";
		//String aplyStdt = "";
		String cngIndivCd = "";		
		String exRateDate = "";
		//String portCd = "";
		
		String v_exRate = "0";
		String usdExrateType = "";
		//String usdExrateType_temp = "";
		String thirdExrateType = "";
		
		try {
			//invCntryCd = exRate.getInvCntryCd();
			//invCustCd = exRate.getInvCustCd();
			ofcCd = exRate.getOfcCd();
			lclCurr = exRate.getLclCurr();
			curr = exRate.getCurr();
			bnd = exRate.getBnd();
			//vsl = exRate.getVsl(); 
			//voy = exRate.getVoy(); 
			//dep = exRate.getDep(); 
			//pol = exRate.getPol(); 
			//pod = exRate.getPod(); 
			
			/*
			if(exRate.getSaDt() != null) {
				saDt = exRate.getSaDt().replace("-", ""); 
			} else {
				saDt = exRate.getSaDt(); 
			}
			
			bkgNo = exRate.getBkgNo();

			if( bkgNo.equals("") && exRate.getBlSrcNo() != null ){
				if(!exRate.getBlSrcNo().equals("")){
					bkgNo= dbDao.searchBkgNoByBlNo(exRate.getBlSrcNo());
				}
			}
			*/
			
			//svcScp = exRate.getSvcScp();			
			
			ARCurrCdVO arCurrCdVo = dbDao.searchOfficeCurrency(ofcCd);
			
			if(arCurrCdVo != null){
				arCurr = arCurrCdVo.getArCurrCd();
				//altnCd = arCurrCdVo.getAltnCurrCd();
			}
			
			//if(("LCL").equals(altnCd) && !("USD").equals(arCurr) && ("USD").equals(lclCurr)) lclFlg = "Y";
			
			//if(!("").equals(exRate.getObrdDt()) && exRate.getObrdDt() != null){
				
				chinaDailyExrateVo.setBnd(bnd);
				chinaDailyExrateVo.setSaDt(exRate.getObrdDt());
				chinaDailyExrateVo.setCurr(curr);
				chinaDailyExrateVo.setLclCurr(lclCurr);
				chinaDailyExrateVo.setOfcCd(ofcCd);			
				chinaDailyExrateVo.setRvsFlg("N");
				
				v_exRate = dbDao.searchChinaDailyExrate(chinaDailyExrateVo);
				if(v_exRate.equals("0")||v_exRate.equals("")){
					chinaDailyExrateVo.setRvsFlg("Y");
					v_exRate = dbDao.searchChinaDailyExrate(chinaDailyExrateVo);
				}
					
				if(!(lclCurr).equals(arCurr) && ("USD").equals(lclCurr)) {
					if(v_exRate.equals("0")||v_exRate.equals("")){
						v_exRate = dbDao.searchAccountRate(curr, "USD", exRate.getObrdDt().substring(0,6));
					}
				}
				
				usdExrateType = "D";
				thirdExrateType = "D";
				exRateDate = exRate.getObrdDt();
				cngIndivCd = "";
				
			/*	
			} else {
			
				vvdExrateVo.setVsl(vsl);
	            vvdExrateVo.setVoy(voy);
	            vvdExrateVo.setDep(dep);
	            vvdExrateVo.setBnd(bnd);
	            vvdExrateVo.setPol(pol);
	            vvdExrateVo.setPod(pod);
	            vvdExrateVo.setLclCurr(lclCurr);
	            vvdExrateVo.setCurr(curr);
	            vvdExrateVo.setSvcScp(svcScp);
	            vvdExrateVo.setOfcCd(ofcCd);				
				
	            if(("N").equals(lclFlg)) {
	            	v_exRate = dbDao.searchVVDExrate(vvdExrateVo);
	            } else {
	            	vvdExrateVo.setLclCurr(arCurr);
	            	v_exRate = dbDao.searchVVDUSDExrate(vvdExrateVo);
	            }
				
	            usdExrateType = "V";
				thirdExrateType = "V";
				exRateDate = "";
				cngIndivCd = "";
			}
			*/
			/*
			//2015.01.09 add search office currency
			arCurr = dbDao.searchOfficeCurrency(ofcCd);
			
			log.info("########## invCntryCd : "+invCntryCd);
			log.info("########## invCustCd : "+invCustCd);
			log.info("########## ofcCd : "+ofcCd);
			log.info("########## lclCurr : "+lclCurr);
			log.info("########## curr : "+curr);
			log.info("########## bnd : "+bnd);
			log.info("########## vsl : "+vsl);
			log.info("########## voy : "+voy);
			log.info("########## dep : "+dep);
			log.info("########## pol : "+pol);
			log.info("########## pod : "+pod);
			log.info("########## saDt : "+saDt);
			log.info("########## bkgNo : "+bkgNo);
			log.info("########## svcScp : "+svcScp);
			log.info("########## arCurr : "+arCurr);
			
			exrateDivisionVo = dbDao.searchCustomerExrateDivision(invCntryCd, invCustCd); //////////////////////	
			
			log.info("########## exrateDivisionVo : "+exrateDivisionVo);
			
			if (exrateDivisionVo != null) {
				divCd1 = exrateDivisionVo.getDivCd1();  
				divCd2 = exrateDivisionVo.getDivCd2(); 
				aplyStdt = exrateDivisionVo.getAplyStDt();
				cngIndivCd = exrateDivisionVo.getCngIndivCd();
			}		
			
			log.info("########## divCd1 : "+divCd1);
			log.info("########## divCd2 : "+divCd2);
			log.info("########## aplyStdt : "+aplyStdt);
			log.info("########## cngIndivCd : "+cngIndivCd);
			

			if (divCd1.equals(bnd) || divCd1.equals("A")) {
				usdExrateType = "I";
				if (divCd2.equals("3")) {
					thirdExrateType = "I";
				} else {
					thirdExrateType = dbDao.searchSetupOfficeForThirdExrateType(ofcCd);
				}
			} else {				
				usdExrateType_temp = dbDao.searchSetupOfficeForExrateType(ofcCd); ////////////////////////////////
				if(usdExrateType_temp!=null&&!usdExrateType_temp.equals("")) {
					usdExrateType = usdExrateType_temp.substring(0, 1);
					thirdExrateType = usdExrateType_temp.substring(1, 2);
				} 
			}
 
			
//			<(:usd_exrate_type = 'I' AND :curr = 'USD') OR (:third_exrate_type = 'I' AND :curr <> 'USD')>
			
			if ((usdExrateType.equals("I") && (curr.equals("USD") || curr.equals(arCurr))) || (thirdExrateType.equals("I") && !curr.equals("USD") && !curr.equals(arCurr))) {
				
				if (cngIndivCd.equals("O")) {
					
					exRateDate = dbDao.searchSailingDate( bkgNo );
					log.info("\n########## exRateDate1 : "+exRateDate);
					
					
//				<:cng_indiv_cd = 'B'>	
				} else if (cngIndivCd.equals("B")) {
					
					exRateDate = dbDao.searchBLOnDate(bkgNo);	
					log.info("\n########## exRateDate2 : "+exRateDate);
					
//				<:cng_indiv_cd = 'C'>	
				} else if (cngIndivCd.equals("C")) {
					
					exRateDate = dbDao.searchCargoReceiveDate(bkgNo);
					log.info("\n########## exRateDate3 : "+exRateDate);
					
					
//				<:cng_indiv_cd = 'N'>	
				} else if (cngIndivCd.equals("N")) {
					
					//portCd = dbDao.searchBKGPortCd(bnd, bkgNo);							
					//exRateDate = dbDao.searchSailingArrivalDate(bnd, bkgNo, portCd);
					
					exRateDate = saDt;
					log.info("\n########## exRateDate4 : "+exRateDate);
					
				}
				
//				<:ex_rate_date >= :aply_st_dt>
				if(!exRateDate.equals("")&&!aplyStdt.equals("")){
					if (Integer.parseInt(exRateDate) >= Integer.parseInt(aplyStdt)) {					
						
						custExrateVo.setInvCntryCd(invCntryCd);
						custExrateVo.setInvCustCd(invCustCd);
						custExrateVo.setBnd(bnd);
						custExrateVo.setCurr(curr);
						custExrateVo.setLclCurr(lclCurr);
						custExrateVo.setOfcCd(ofcCd);
						custExrateVo.setExRateDate(exRateDate);					
						
						v_exRate = dbDao.searchCustomerExrate(custExrateVo);
					

					} else {
						usdExrateType_temp = dbDao.searchSetupOfficeForExrateType(ofcCd); ////////////////////////////////
						if(usdExrateType_temp!=null&&!usdExrateType_temp.equals("")) {
							usdExrateType = usdExrateType_temp.substring(0, 1);
							thirdExrateType = usdExrateType_temp.substring(1, 2);
							exRateDate = "";
						} 
					}

				} else { 
					vvdExrateVo.setVsl(vsl);
		            vvdExrateVo.setVoy(voy);
		            vvdExrateVo.setDep(dep);
		            vvdExrateVo.setBnd(bnd);
		            vvdExrateVo.setPol(pol);
		            vvdExrateVo.setPod(pod);
		            vvdExrateVo.setLclCurr(lclCurr);
		            vvdExrateVo.setCurr(curr);
		            vvdExrateVo.setSvcScp(svcScp);
		            vvdExrateVo.setOfcCd(ofcCd);				
					
					v_exRate = dbDao.searchVVDExrate(vvdExrateVo);
				}
			} 
			
			
//			<(:usd_exrate_type = 'V' AND :curr = 'USD') OR (:third_exrate_type = 'V' AND :curr <> 'USD')>				
			
			if((usdExrateType.equals("V") && (curr.equals("USD") || curr.equals(arCurr))) || (thirdExrateType.equals("V") && !curr.equals("USD") && !curr.equals(arCurr))) {
				
				vvdExrateVo.setVsl(vsl);
	            vvdExrateVo.setVoy(voy);
	            vvdExrateVo.setDep(dep);
	            vvdExrateVo.setBnd(bnd);
	            vvdExrateVo.setPol(pol);
	            vvdExrateVo.setPod(pod);
	            vvdExrateVo.setLclCurr(lclCurr);
	            vvdExrateVo.setCurr(curr);
	            vvdExrateVo.setSvcScp(svcScp);
	            vvdExrateVo.setOfcCd(ofcCd);				
				
				v_exRate = dbDao.searchVVDExrate(vvdExrateVo);
				
//			<(:usd_exrate_type = 'A' AND :curr = 'USD') OR (:third_exrate_type = 'A' AND :curr <> 'USD')>	
			
			} else if((usdExrateType.equals("A") && (curr.equals("USD") || curr.equals(arCurr))) || (thirdExrateType.equals("A") && !curr.equals("USD") && !curr.equals(arCurr))) {
				
				v_exRate = dbDao.searchAccountExrate(bkgNo, curr, lclCurr);	///////////////////////////////////////	
				
//			<(:usd_exrate_type = 'F' AND :curr = 'USD') OR (:third_exrate_type = 'F' AND :curr <> 'USD')>	
				
			} else if((usdExrateType.equals("F") && (curr.equals("USD") || curr.equals(arCurr))) || (thirdExrateType.equals("F") && !curr.equals("USD") && !curr.equals(arCurr))) {
				
				v_exRate = dbDao.searchFixedExrate(ofcCd);				
				
//			<(:usd_exrate_type = 'C' AND :curr = 'USD') OR (:third_exrate_type = 'C' AND :curr <> 'USD')>	
				
			} else if((usdExrateType.equals("C") && (curr.equals("USD") || curr.equals(arCurr))) || (thirdExrateType.equals("C") && !curr.equals("USD") && !curr.equals(arCurr))) {
	
				chinaDailyExrateVo.setBnd(bnd);
				chinaDailyExrateVo.setSaDt(saDt);
				chinaDailyExrateVo.setCurr(curr);
				chinaDailyExrateVo.setLclCurr(lclCurr);
				chinaDailyExrateVo.setOfcCd(ofcCd);
				chinaDailyExrateVo.setExrateType("C");
				
				v_exRate = dbDao.searchChinaDailyExrate(chinaDailyExrateVo);				
				exRateDate = saDt;
				
				// If daily rates = 0, accounting rates
				if(v_exRate.equals("0")||v_exRate.equals("")){
					v_exRate = dbDao.searchAccountExrate(bkgNo, curr, lclCurr);
				}	
			
			} else if((usdExrateType.equals("D") && (curr.equals("USD") || curr.equals(arCurr))) || (thirdExrateType.equals("D") && !curr.equals("USD") && !curr.equals(arCurr))) {
	
				chinaDailyExrateVo.setBnd(bnd);
				chinaDailyExrateVo.setSaDt(saDt);
				chinaDailyExrateVo.setCurr(curr);
				chinaDailyExrateVo.setLclCurr(lclCurr);
				chinaDailyExrateVo.setOfcCd(ofcCd);
				chinaDailyExrateVo.setExrateType("D");
				
				v_exRate = dbDao.searchChinaDailyExrate(chinaDailyExrateVo);				
				exRateDate = saDt;
				
				if(v_exRate.equals("0")||v_exRate.equals("")){
					v_exRate = dbDao.searchAccountExrate(bkgNo, curr, lclCurr);
				}	
			}
			
			if(!thirdExrateType.equals("") && !curr.equals("USD") && !curr.equals(arCurr)){
				if(v_exRate.equals("0")||v_exRate.equals("")){
					v_exRate = dbDao.searchAccountExrate(bkgNo, curr, lclCurr); ///////////////
				}				
			}
			*/
			
//			<:lcl_curr = :curr in case>
			if (lclCurr.equals(curr)) {
				v_exRate = "1";
			}
			
			log.info("########## curr : "+curr);
			log.info("########## exRate : "+v_exRate);
			log.info("########## usdExrateType : "+usdExrateType);
			log.info("########## thirdExrateType : "+thirdExrateType);
			log.info("########## exRateDate : "+exRateDate);
			
			exchangeRateVo.setCurr(curr);
			exchangeRateVo.setExRate(v_exRate);
			exchangeRateVo.setUsdExrateType(usdExrateType);
			exchangeRateVo.setThirdExrateType(thirdExrateType);
			exchangeRateVo.setExRateDate(exRateDate);			
			exchangeRateVo.setCngIndivCd(cngIndivCd);
			return exchangeRateVo;
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Search BKG Migration List<br>
	 * 
	 * @param String fmBkgOfcCd
	 * @param String toBkgOfcCd
	 * @param String bkgNo
	 * @return List<ARBkgInterfaceCreationVO>
	 * @exception EventException
	 */
	public List<ARBkgInterfaceCreationVO> searchBKGMigrationList(String fmBkgOfcCd, String toBkgOfcCd, String bkgNo) throws EventException{
		try {
			return dbDao.searchBKGMigrationList(fmBkgOfcCd, toBkgOfcCd, bkgNo);
		} catch(DAOException ex) {
			log.error("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>dao err:" + ex.getMessage());
			throw new EventException(new ErrorHandler("INV00053",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>exp err:" + ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Search Other Migration Main List<br>
	 * 
	 * @param String ofcCd
	 * @param String fmSrcIfSeq
	 * @param String toSrcIfSeq
	 * @return List<InvArIfMnVO>
	 * @exception EventException
	 */
	public List<InvArIfMnVO> searchInvArIfMain(String ofcCd, String fmSrcIfSeq, String toSrcIfSeq) throws EventException{
		try {
			return dbDao.searchInvArIfMain(ofcCd, fmSrcIfSeq, toSrcIfSeq);
		} catch(DAOException ex) {
			log.error("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>dao err:" + ex.getMessage());
			throw new EventException(new ErrorHandler("INV00053",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>exp err:" + ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Search Other Migration Charge List<br>
	 * 
	 * @param String srcIfDt
	 * @param String srcIfSeq
	 * @return List<InvArIfChgVO>
	 * @exception EventException
	 */
	public List<InvArIfChgVO> searchInvArIfChg(String srcIfDt, String srcIfSeq) throws EventException{
		try {
			return dbDao.searchInvArIfChg(srcIfDt, srcIfSeq);
		} catch(DAOException ex) {
			log.error("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>dao err:" + ex.getMessage());
			throw new EventException(new ErrorHandler("INV00053",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>exp err:" + ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
}
