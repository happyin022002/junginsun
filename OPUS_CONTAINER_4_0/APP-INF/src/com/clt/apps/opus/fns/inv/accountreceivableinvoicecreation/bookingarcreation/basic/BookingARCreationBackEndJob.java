/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BookingARCreationBackEndBCImpl.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.29
 *@LastModifier : 최도순
 *@LastVersion : 0.1
 * 2009.07.29
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic;

//import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration.BookingARCreationBackEndDBDAO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration.BookingARCreationDBDAO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARBkgInterfaceCreationVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.CancelInvoiceVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExRateCountVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateChgVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateMainVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateTargetChgVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateTargetMainVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.RevVVDLaneVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.ARInvoiceVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.ExchangeRateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.basic.ARInvoiceCorrectionBC;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.basic.ARInvoiceCorrectionBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARCorrectionCkReturnVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.DueDateInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvArIfNoVO;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.basic.INVCommonUtil;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.VVDCustomerVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.basic.AccountReceivableOutstandingBC;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.basic.AccountReceivableOutstandingBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBCImpl;
import com.clt.syscommon.common.table.BkgInvTaxIfVO;

/**
 * AccountReceivableInvoiceCreation Business Logic Basic Command implementation<br>
 * - AccountReceivableInvoiceCreation에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Choi Do Soon
 * @see BookingARCreationBackEndDBDAO 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class BookingARCreationBackEndJob extends BackEndCommandSupport {
	
	private static final long serialVersionUID = -3034414164961318353L;
	
	/**
	 * Backend job을 위한 DAO
	 */
	private BookingARCreationBackEndDBDAO dbDao;
	private BookingARCreationDBDAO dbDao2;

	private ExchangeRateVO[] exRateVOs;	
	private List<ExrateInputVO> exrateInputVOs;
	private ExrateInputVO exrateInputVO;
	private ARBkgInterfaceCreationVO aRBkgInterfaceCreationVO;
	private List<ARBkgInterfaceCreationVO> aRBkgInterfaceCreationVOs;
	private DueDateInputVO[] dueDateInputVOs;
	
	private String userId;
	private String uiType;
	private String runOpt;
	private String actCustCntCd;
	private String actCustSeq;
	private String invCustCntCd;
	private String invCustSeq;
	
	public void setARBkgInterfaceCreationVO(
			ARBkgInterfaceCreationVO bkgInterfaceCreationVO) {
		aRBkgInterfaceCreationVO = bkgInterfaceCreationVO;
	}
	
	public void setARBkgInterfaceCreationVOs(
			List<ARBkgInterfaceCreationVO> bkgInterfaceCreationVOs) {
		aRBkgInterfaceCreationVOs = bkgInterfaceCreationVOs;
	}

	public void setExchangeRateVOs(ExchangeRateVO[] exRateVOs) {
		if (exRateVOs != null) {
			ExchangeRateVO[] tmpVOs = new ExchangeRateVO[exRateVOs.length];
			System.arraycopy(exRateVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.exRateVOs = tmpVOs;
		}
	}
	
	public void setExrateInputVO(ExrateInputVO exrateInputVO) {
		this.exrateInputVO = exrateInputVO;
	}

	public void setExrateInputVOs(List<ExrateInputVO> exrateInputVOs) {
		this.exrateInputVOs = exrateInputVOs;
	}
	
	public void setDueDateInputVOs(DueDateInputVO[] dueDateInputVOs) {
		if (dueDateInputVOs != null) {
			DueDateInputVO[] tmpVOs = new DueDateInputVO[dueDateInputVOs.length];
			System.arraycopy(dueDateInputVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.dueDateInputVOs = tmpVOs;
		}
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public void setActCustCntCd(String actCustCntCd) {
		this.actCustCntCd = actCustCntCd;
	}
	
	public void setActCustSeq(String actCustSeq) {
		this.actCustSeq = actCustSeq;
	}
	
	public void setInvCustCntCd(String invCustCntCd) {
		this.invCustCntCd = invCustCntCd;
	}
	
	public void setInvCustSeq(String invCustSeq) {
		this.invCustSeq = invCustSeq;
	}
	
	
	public void setUiType(String uiType) {
		this.uiType = uiType;
	}
	
	public void setRunOpt(String runOpt) {
		this.runOpt = runOpt;
	}

	/**
	 * uiType = "C" 일 경우 FNS_INV_0100,FNS_INV_0101,FNS_INV_0007,FNS_INV_0089,FNS_INV_0008화면<br>
	 * 환율대상 검색 후 반영<br>
	 * uiType = "U" 일 경우 FNS_INV_0027 경리환율, VVD 환율 등 환율 정보과 없는 경우 해당 테이블의 환율을 읽어 일괄 Update<br>
	 * uiType = "B" 일 경우 BKG Interface 호출 return 안 받음<br>
	 * uiType = "L" 일 경우 BKG Interface List 호출<br>
	 * uiType = "I" 일 경우 FNS_INV_0094_02 Invoice Customer Change(Multi) 2010-03-22<br>
 	 * 
	 * @return List<ExRateCountVO>
	 * @exception EventException
	 */
	@Override
	public List<ExRateCountVO> doStart() throws Exception {
		this.dbDao = new BookingARCreationBackEndDBDAO();
		this.dbDao2 = new BookingARCreationDBDAO();
		
		//ExchangeRateVO exRateVo = new ExchangeRateVO();
		//ARInvoiceVO invoiceVO = new ARInvoiceVO();
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		try {			
			Thread.sleep(1000);
			
			List<ExRateCountVO> exRateCountVOs = new ArrayList<ExRateCountVO>();  
			
			//if(uiType.equals("C")){
				
				//BookingARCreationBC command = new BookingARCreationBCImpl();
				//command.modifyBLExchangeRate(exRateVOs, userId);	
				
			//}else 
			if(uiType.equals("B")){
				//BookingARCreationBC bCommand = new BookingARCreationBCImpl();
				
				//List<InvArIfNoVO> ifNos = bCommand.executeInterfaceBKGARInvoiceToINV(aRBkgInterfaceCreationVO);
				
				
				count1 = 1;
				count2 = 1;
				count3 = 1;
				
			}else if(uiType.equals("L")){
				BookingARCreationBC bCommand = new BookingARCreationBCImpl();
				//ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
				
				List<InvArIfNoVO> allIfNos = new ArrayList<InvArIfNoVO>();
				
				if(aRBkgInterfaceCreationVOs.size()>0){
					for(int i= 0; i< aRBkgInterfaceCreationVOs.size();i++ ){
						List<InvArIfNoVO> ifNos = bCommand.executeInterfaceBKGARInvoiceToINV(aRBkgInterfaceCreationVOs.get(i));
						
						if(ifNos!=null && ifNos.size()>0){
							log.error("ifNos.size() = "+ifNos.size());
							
							allIfNos.addAll(ifNos);
						}
						
					}
					
				}
				
				count1 = 1;
				count2 = 1;
				count3 = 1;
			
			//2010-03-22 FNS_INV_0094_02 Invoice Customer Change(Multi) 추가	
			}else if(uiType.equals("I")){
				
				ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
				BookingARCreationBC bCommand = new BookingARCreationBCImpl();
				AccountReceivableOutstandingBC command2 = new AccountReceivableOutstandingBCImpl();

				List<InvArIfNoVO> ifNos = new ArrayList<InvArIfNoVO>();
				InvArIfNoVO invArIfNoVO = new InvArIfNoVO();	
				String newIfNo="";	
				
				if (dueDateInputVOs != null) {

					for (int i = 0; i < dueDateInputVOs.length; i++) {
							
						ARCorrectionCkReturnVO arCorrectionCkReturnVO = command.searchRevTypeSrc(dueDateInputVOs[i].getBkgNo(), "C");

						CancelInvoiceVO cancelInvoiceVO = new CancelInvoiceVO();

						cancelInvoiceVO.setIfNo(dueDateInputVOs[i].getArIfNo());
						cancelInvoiceVO.setOtsSmryCd("");
						cancelInvoiceVO.setUserId(userId);
						cancelInvoiceVO.setInvNo(dueDateInputVOs[i].getInvNo());
						cancelInvoiceVO.setRevTpCd(dueDateInputVOs[i].getRevTpCd().equals("M")?dueDateInputVOs[i].getRevTpCd():arCorrectionCkReturnVO.getRevTpCd());
						cancelInvoiceVO.setRevSrcCd(dueDateInputVOs[i].getRevTpCd().equals("M")?dueDateInputVOs[i].getRevSrcCd():arCorrectionCkReturnVO.getRevSrcCd());
						cancelInvoiceVO.setUiType("C");
						cancelInvoiceVO.setInvCurrCd(dueDateInputVOs[i].getInvCurrCd());
						
						newIfNo = bCommand.createCancelIssueARInvoice(cancelInvoiceVO);
						
						if(!newIfNo.equals("")){
							invArIfNoVO = new InvArIfNoVO();
							invArIfNoVO.setIfNo(newIfNo);
							ifNos.add(invArIfNoVO);
						}

						CancelInvoiceVO newInvoiceVO = new CancelInvoiceVO();

						newInvoiceVO.setActCustCntCd(actCustCntCd);
						newInvoiceVO.setActCustSeq(actCustSeq);
						newInvoiceVO.setInvCustCntCd(invCustCntCd);
						newInvoiceVO.setInvCustSeq(invCustSeq);
						newInvoiceVO.setIfNo(dueDateInputVOs[i].getArIfNo());
						newInvoiceVO.setInvNo(dueDateInputVOs[i].getInvNo());
						newInvoiceVO.setRevTpCd(dueDateInputVOs[i].getRevTpCd().equals("M")?dueDateInputVOs[i].getRevTpCd():arCorrectionCkReturnVO.getRevTpCd());
						newInvoiceVO.setRevSrcCd(dueDateInputVOs[i].getRevTpCd().equals("M")?dueDateInputVOs[i].getRevSrcCd():arCorrectionCkReturnVO.getRevSrcCd());
						newInvoiceVO.setUiType("C");
						newInvoiceVO.setUserId(userId);
						newInvoiceVO.setInvCurrCd(dueDateInputVOs[i].getInvCurrCd());
						
						
						// New Data 생성
						//if(dueDateInputVOs[i].getRevTpCd().equals("M")&&dueDateInputVOs[i].getBkgNo().equals("")){
						if(dueDateInputVOs[i].getRevTpCd().equals("M")){
							newIfNo = bCommand.createNewMIssueARInvoice(newInvoiceVO);
						}else{
							newIfNo = bCommand.createNewIssueARInvoice(newInvoiceVO);
						}
						
						
						if(!newIfNo.equals("")){
							invArIfNoVO = new InvArIfNoVO();
							invArIfNoVO.setIfNo(newIfNo);
							ifNos.add(invArIfNoVO);
						}
						
						//2009-12-02 REV_TP_CD ='M' 포함 하면서 수정
						bCommand.modifySplitCodebyInvNo(dueDateInputVOs[i].getInvNo(), dueDateInputVOs[i].getOfcCd(),"M", userId);					
					}
				}
				
				// 2014.06.13 AR OTS creation
				if(ifNos!= null && ifNos.size()>0){
					command2.createOutstandingInfo(ifNos);
				}
				
				count1 = 1;
				count2 = 1;
				count3 = 1;
				
			}else if(uiType.equals("U")){
				
				ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
				BookingARCreationBC bCommand = new BookingARCreationBCImpl();
				AccountReceivableOutstandingBC command2 = new AccountReceivableOutstandingBCImpl();
				//AccountReceivableOutstandingIFBC command3 = new AccountReceivableOutstandingIFBCImpl();
				INVCommonUtil utilCmd = new INVCommonUtil();
				List<InvArIfNoVO> ifNos = new ArrayList<InvArIfNoVO>();
				List<InvArIfNoVO> exceclIfNos = new ArrayList<InvArIfNoVO>();
				InvArIfNoVO invArIfNoVO = new InvArIfNoVO();	
				String newIfNo="";	
				String vvd = "";
				String port = "";
				String saDate = "";
				String sailDt = "";
				
				List<ExrateTargetMainVO> exrateTargetMainVOs = null;

				int good_cnt = 0;
				int no_good_cnt = 0;
				int tot_cnt = 0;

				// NoGood조건인 경우(runOption='N')
				if (runOpt.equals("N")) {

					exrateTargetMainVOs = command.searchInvoiceForExrateList(exrateInputVO);

					VVDCustomerVO vVDCustomerVO = new VVDCustomerVO();
					com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.ExchangeRateVO exchangeRateVO = null;
					ExrateMainVO exrateMainVO = new ExrateMainVO();
					ExrateChgVO exrateChgVO = new ExrateChgVO();

					String usd_xch_rt = "";
					

					if (exrateTargetMainVOs != null) {

						tot_cnt = exrateTargetMainVOs.size();

						for (int i = 0; i < exrateTargetMainVOs.size(); i++) {
							
							usd_xch_rt = utilCmd.searchAccountRate("USD", exrateTargetMainVOs.get(i).getLoclCurrCd(), !exrateTargetMainVOs.get(i).getSailDt().equals("")?exrateTargetMainVOs.get(i).getSailDt().substring(0, 6):"");
							vvd = exrateTargetMainVOs.get(i).getVslCd()+ exrateTargetMainVOs.get(i).getSkdVoyNo()+exrateTargetMainVOs.get(i).getSkdDirCd();
							port = 	exrateTargetMainVOs.get(i).getIoBndCd().equals("O")?exrateTargetMainVOs.get(i).getPolCd():exrateTargetMainVOs.get(i).getPodCd();
							
							sailDt = utilCmd.searchSailingDate(exrateTargetMainVOs.get(i).getBkgNo());
							saDate = utilCmd.searchSADate(vvd , port, exrateTargetMainVOs.get(i).getIoBndCd());
							
							RevVVDLaneVO revVVDLaneVO = dbDao2.searchRevenueVVDLane(exrateTargetMainVOs.get(i).getBkgNo());
							
							String revVvd = "";
							String rlaneCd = "";	
							
							if(revVVDLaneVO != null){
								revVvd = revVVDLaneVO.getRevVvd();
								rlaneCd = revVVDLaneVO.getRlaneCd();				
							}
							
							if(revVvd.equals("X")){
								revVVDLaneVO = dbDao2.searchRevenueVVDLaneRd(vvd);
								if(revVVDLaneVO != null){
									revVvd = revVVDLaneVO.getRevVvd();
									rlaneCd = revVVDLaneVO.getRlaneCd();
								}
							}
							
							if (usd_xch_rt.equals("")||sailDt.equals("")||saDate.equals("")||revVvd.length() != 10) {
								// 경리 환율이 없는 경우 No Good Count 증가
								no_good_cnt = no_good_cnt + 1;
							} else {
								// 경리환율이 있는 경우 Good Count 증가
								good_cnt = good_cnt + 1;

								List<ExrateTargetChgVO> exrateTargetChgVOs = null;
								exrateTargetChgVOs = command.searchInvoiceChgForExrateList(exrateTargetMainVOs.get(i).getArIfNo());

								//BigDecimal invTtlLoclAmt = new BigDecimal("0");
								//int currPoint = 0;

								vVDCustomerVO.setInvCntryCd(exrateTargetMainVOs.get(i).getInvCustCntCd());
								vVDCustomerVO.setInvCustCd(exrateTargetMainVOs.get(i).getInvCustSeq());
								vVDCustomerVO.setOfcCd(exrateTargetMainVOs.get(i).getArOfcCd());
								vVDCustomerVO.setLclCurr(exrateTargetMainVOs.get(i).getLoclCurrCd());
								vVDCustomerVO.setBnd(exrateTargetMainVOs.get(i).getIoBndCd());
								vVDCustomerVO.setVsl(exrateTargetMainVOs.get(i).getVslCd());
								vVDCustomerVO.setVoy(exrateTargetMainVOs.get(i).getSkdVoyNo());
								vVDCustomerVO.setDep(exrateTargetMainVOs.get(i).getSkdDirCd());
								vVDCustomerVO.setPol(exrateTargetMainVOs.get(i).getPolCd());
								vVDCustomerVO.setPod(exrateTargetMainVOs.get(i).getPodCd());
								vVDCustomerVO.setSaDt(!saDate.equals("")?saDate.replace("-", ""):saDate);
								vVDCustomerVO.setBkgNo(exrateTargetMainVOs.get(i).getBkgNo());
								vVDCustomerVO.setSvcScp(exrateTargetMainVOs.get(i).getSvcScpCd());

								if (exrateTargetChgVOs != null) {
									for (int j = 0; j < exrateTargetChgVOs.size(); j++) {									
										
										vVDCustomerVO.setCurr(exrateTargetChgVOs.get(j).getCurrCd());
										
										exchangeRateVO = utilCmd.searchExchangeRate(vVDCustomerVO);

										exrateChgVO.setArIfNo(exrateTargetChgVOs.get(j).getArIfNo());
										exrateChgVO.setArIfSerNo(exrateTargetChgVOs.get(j).getArIfSerNo());
										exrateChgVO.setChgSeq(exrateTargetChgVOs.get(j).getChgSeq());
										exrateChgVO.setInvXchRt(exchangeRateVO.getExRate());
										exrateChgVO.setInvXchRtDt(exchangeRateVO.getExRateDate());
										exrateChgVO.setRevVvd(revVvd);
										exrateChgVO.setUpdUsrId(userId);
										exrateChgVO.setNoGoodFlg("Y");

										bCommand.modifyInvoiceExrateChg(exrateChgVO);
										
										//currPoint = dbDao2.searchCurrencyPoint(exrateTargetChgVOs.get(j).getCurrCd());
										
										//BigDecimal chgAmt = new BigDecimal(exrateTargetChgVOs.get(j).getChgAmt());
										//BigDecimal exRate = new BigDecimal(exchangeRateVO.getExRate());	
										//invTtlLoclAmt = invTtlLoclAmt.add(chgAmt.multiply(exRate).setScale(currPoint,BigDecimal.ROUND_HALF_UP));

									}
								}
								
								//2015.03.16 add USD exrate //////////////////////////////////////// START
								vVDCustomerVO.setLclCurr("USD");
								
								if (exrateTargetChgVOs != null) {
									for (int j = 0; j < exrateTargetChgVOs.size(); j++) {									
										
										vVDCustomerVO.setCurr(exrateTargetChgVOs.get(j).getCurrCd());
										
										exchangeRateVO = utilCmd.searchExchangeRate(vVDCustomerVO);

										exrateChgVO.setArIfNo(exrateTargetChgVOs.get(j).getArIfNo());
										exrateChgVO.setArIfSerNo(exrateTargetChgVOs.get(j).getArIfSerNo());
										exrateChgVO.setChgSeq(exrateTargetChgVOs.get(j).getChgSeq());
										exrateChgVO.setInvXchRt(exchangeRateVO.getExRate());
										exrateChgVO.setInvXchRtDt(exchangeRateVO.getExRateDate());
										exrateChgVO.setRevVvd(revVvd);
										exrateChgVO.setUpdUsrId(userId);
										exrateChgVO.setNoGoodFlg("Y");

										dbDao.modifyInvoiceUSDExrateChg(exrateChgVO);

									}
								}
								//2015.03.16 add USD exrate //////////////////////////////////////// END
								
								vVDCustomerVO.setLclCurr("USD");
								vVDCustomerVO.setCurr(exrateTargetMainVOs.get(i).getLoclCurrCd());
								exchangeRateVO = utilCmd.searchExchangeRate(vVDCustomerVO);
								
								if (exrateTargetChgVOs != null) {
									for (int j = 0; j < exrateTargetChgVOs.size(); j++) {

										exrateChgVO.setArIfNo(exrateTargetChgVOs.get(j).getArIfNo());
										exrateChgVO.setArIfSerNo(exrateTargetChgVOs.get(j).getArIfSerNo());											
										exrateChgVO.setInvXchRt(exchangeRateVO.getExRate());										
										exrateChgVO.setUpdUsrId(userId);
										exrateChgVO.setLoclCurrCd(exrateTargetMainVOs.get(i).getLoclCurrCd());											
										
										dbDao.modifyINVMainINVUSDExrate(exrateChgVO);				
							
									}
								}
								
								vVDCustomerVO.setLclCurr(exrateTargetMainVOs.get(i).getLoclCurrCd());
								vVDCustomerVO.setCurr("USD");
								exchangeRateVO = utilCmd.searchExchangeRate(vVDCustomerVO);
								
								if (exrateTargetChgVOs != null) {
									for (int j = 0; j < exrateTargetChgVOs.size(); j++) {

										exrateChgVO.setArIfNo(exrateTargetChgVOs.get(j).getArIfNo());
										exrateChgVO.setArIfSerNo(exrateTargetChgVOs.get(j).getArIfSerNo());											
										exrateChgVO.setInvXchRt(exchangeRateVO.getExRate());										
										exrateChgVO.setUpdUsrId(userId);
										exrateChgVO.setLoclCurrCd(exrateTargetMainVOs.get(i).getLoclCurrCd());											
										
										dbDao.modifyINVMainINVLCLExrate(exrateChgVO);					
							
									}
								}
								
								exrateMainVO.setXchRtDt(exchangeRateVO.getExRateDate());
								exrateMainVO.setXchRtUsdTpCd(exchangeRateVO.getUsdExrateType());
								exrateMainVO.setXchRtN3rdTpCd(exchangeRateVO.getThirdExrateType());
								exrateMainVO.setObrdDt(exchangeRateVO.getCngIndivCd().equals("B") ? exchangeRateVO.getExRateDate() : "");
								exrateMainVO.setUsdXchRt(exchangeRateVO.getExRate());
								//exrateMainVO.setInvTtlLoclAmt(invTtlLoclAmt.toString());
								
								//vvd = exrateTargetMainVOs.get(i).getVslCd()+ exrateTargetMainVOs.get(i).getSkdVoyNo()+exrateTargetMainVOs.get(i).getSkdDirCd();
								//port = 	exrateTargetMainVOs.get(i).getIoBndCd().equals("O")?exrateTargetMainVOs.get(i).getPolCd():exrateTargetMainVOs.get(i).getPodCd();
								//saDate = utilCmd.searchSADate(vvd , port, exrateTargetMainVOs.get(i).getIoBndCd());
								
								//Due Dt 구하는 로직 BC에서 직접 구하는 방식으로 변경 2009-11-30
								/*
								DueDateInputVO dueDateInputVO = new DueDateInputVO();

								dueDateInputVO.setBnd(exrateTargetMainVOs.get(i).getIoBndCd());
								dueDateInputVO.setCustCntCd(exrateTargetMainVOs.get(i).getActCustCntCd());
								dueDateInputVO.setCustSeq(exrateTargetMainVOs.get(i).getActCustSeq());
								dueDateInputVO.setSaDt(!saDate.equals("")?saDate.replace("-", ""):saDate);
								dueDateInputVO.setOfcCd(exrateTargetMainVOs.get(i).getArOfcCd());
								// Due Date 조회
								List<DueDateVO> list = command.searchDueDate(dueDateInputVO);
								
								if (list.size() > 0) {
									// Due Date 세팅
									exrateMainVO.setDueDt(list.get(0).getDueDate());
									exrateMainVO.setCustCrFlg(list.get(0).getCrFlg());
									exrateMainVO.setCrTermDys(list.get(0).getCrTermDys());
								}
								*/
								exrateMainVO.setArOfcCd(exrateTargetMainVOs.get(i).getArOfcCd());
								exrateMainVO.setSailArrDt(!saDate.equals("")?saDate.replace("-", ""):saDate);								
								exrateMainVO.setArIfNo(exrateTargetMainVOs.get(i).getArIfNo());
								exrateMainVO.setRevTpCd(exrateTargetMainVOs.get(i).getRevTpCd());
								exrateMainVO.setRevSrcCd(exrateTargetMainVOs.get(i).getRevSrcCd());
								exrateMainVO.setBkgNo(exrateTargetMainVOs.get(i).getBkgNo());
								exrateMainVO.setUpdUsrId(userId);
								exrateMainVO.setVvd(vvd);
								exrateMainVO.setPort(port);
								//2010-01-20 추가
								log.debug("revVvd = "+revVvd);
								log.debug("rlaneCd = "+rlaneCd);
								
								exrateMainVO.setRevVvd(revVvd);
								exrateMainVO.setRlaneCd(rlaneCd);

								newIfNo = bCommand.modifyInvoiceExrateMain(exrateMainVO);
								
								if(!newIfNo.equals("")){
									invArIfNoVO = new InvArIfNoVO();
									invArIfNoVO.setIfNo(newIfNo);
									ifNos.add(invArIfNoVO);
									exceclIfNos.add(invArIfNoVO);
								}

							}
						}
					}

					// Cusomer조건인 경우(runOption='C')
				} else if (runOpt.equals("C")) {

					exrateTargetMainVOs = command.searchInvoiceForExrateList(exrateInputVO);

					VVDCustomerVO vVDCustomerVO = new VVDCustomerVO();
					com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.ExchangeRateVO exchangeRateVO = null;
					ExrateMainVO exrateMainVO = new ExrateMainVO();
					ExrateChgVO exrateChgVO = new ExrateChgVO();

					//String usd_xch_rt = "";

					if (exrateTargetMainVOs != null) {

						tot_cnt = exrateTargetMainVOs.size();

						for (int i = 0; i < exrateTargetMainVOs.size(); i++) {
							//usd_xch_rt = utilCmd.searchAccountRate("USD", exrateTargetMainVOs.get(i).getLoclCurrCd(), !exrateTargetMainVOs.get(i).getSailDt().equals("")?exrateTargetMainVOs.get(i).getSailDt().substring(0, 6):"");
							
							log.debug("issFlg = "+exrateTargetMainVOs.get(i).getIssFlg());
							log.debug("clrFlg = "+exrateTargetMainVOs.get(i).getInvClrFlg());
							log.debug("otsSmryCd = "+exrateTargetMainVOs.get(i).getOtsSmryCd());
							log.debug("dmdtArInvIssFlg = "+exrateTargetMainVOs.get(i).getDmdtArInvIssFlg());
							
							if (
									(!exrateTargetMainVOs.get(i).getOtsSmryCd().equals("BL") && 
										(exrateTargetMainVOs.get(i).getIssFlg().equals("N") || 
											// ((exrateTargetMainVOs.get(i).getRevSrcCd().equals("DM")||exrateTargetMainVOs.get(i).getRevSrcCd().equals("DT")) && exrateTargetMainVOs.get(i).getDmdtArInvIssFlg().equals("N"))||
											exrateTargetMainVOs.get(i).getInvClrFlg().equals("Y")
										)
									) 
									|| exrateTargetMainVOs.get(i).getOtsSmryCd().equals("BL")
								){
								
							
								//if (!usd_xch_rt.equals("")) {
									// 경리환율이 있는 경우 Good Count 증가
									//good_cnt = good_cnt + 1;

									List<ExrateTargetChgVO> exrateTargetChgVOs = null;
									exrateTargetChgVOs = command.searchInvoiceChgForExrateList(exrateTargetMainVOs.get(i).getArIfNo());

									//BigDecimal invTtlLoclAmt = new BigDecimal("0");
									//int currPoint = 0;
									
									vvd = exrateTargetMainVOs.get(i).getVslCd()+ exrateTargetMainVOs.get(i).getSkdVoyNo()+exrateTargetMainVOs.get(i).getSkdDirCd();
									port = 	exrateTargetMainVOs.get(i).getIoBndCd().equals("O")?exrateTargetMainVOs.get(i).getPolCd():exrateTargetMainVOs.get(i).getPodCd();
									saDate = utilCmd.searchSADate(vvd , port, exrateTargetMainVOs.get(i).getIoBndCd());

									vVDCustomerVO.setInvCntryCd(exrateTargetMainVOs.get(i).getInvCustCntCd());
									vVDCustomerVO.setInvCustCd(exrateTargetMainVOs.get(i).getInvCustSeq());
									vVDCustomerVO.setOfcCd(exrateTargetMainVOs.get(i).getArOfcCd());
									vVDCustomerVO.setLclCurr(exrateTargetMainVOs.get(i).getLoclCurrCd());
									vVDCustomerVO.setBnd(exrateTargetMainVOs.get(i).getIoBndCd());
									vVDCustomerVO.setVsl(exrateTargetMainVOs.get(i).getVslCd());
									vVDCustomerVO.setVoy(exrateTargetMainVOs.get(i).getSkdVoyNo());
									vVDCustomerVO.setDep(exrateTargetMainVOs.get(i).getSkdDirCd());
									vVDCustomerVO.setPol(exrateTargetMainVOs.get(i).getPolCd());
									vVDCustomerVO.setPod(exrateTargetMainVOs.get(i).getPodCd());
									vVDCustomerVO.setSaDt(!saDate.equals("")?saDate.replace("-", ""):saDate);
									vVDCustomerVO.setBkgNo(exrateTargetMainVOs.get(i).getBkgNo());
									vVDCustomerVO.setSvcScp(exrateTargetMainVOs.get(i).getSvcScpCd());

									if (exrateTargetChgVOs != null) {
										for (int j = 0; j < exrateTargetChgVOs.size(); j++) {
											
											
											vVDCustomerVO.setCurr(exrateTargetChgVOs.get(j).getCurrCd());
											exchangeRateVO = utilCmd.searchExchangeRate(vVDCustomerVO);

											exrateChgVO.setArIfNo(exrateTargetChgVOs.get(j).getArIfNo());
											exrateChgVO.setArIfSerNo(exrateTargetChgVOs.get(j).getArIfSerNo());
											exrateChgVO.setChgSeq(exrateTargetChgVOs.get(j).getChgSeq());
											exrateChgVO.setInvXchRt(exchangeRateVO.getExRate());
											exrateChgVO.setInvXchRtDt(exchangeRateVO.getExRateDate());
											exrateChgVO.setUpdUsrId(userId);
											exrateChgVO.setLoclCurrCd(exrateTargetMainVOs.get(i).getLoclCurrCd());
											exrateChgVO.setCurrCd(exrateTargetChgVOs.get(j).getCurrCd());
											exrateChgVO.setNoGoodFlg("N");

											bCommand.modifyInvoiceExrateChg(exrateChgVO);
											
											//Update OTS local exchange rate and flag - 2015.02.27
											dbDao.modifyOTSDetailLoclExrate(exrateChgVO);
											dbDao.modifyOTSHistoryLoclExrate(exrateChgVO);
											dbDao.modifyOTSHeaderRateFlg(exrateChgVO);
											
											//currPoint = dbDao2.searchCurrencyPoint(exrateTargetChgVOs.get(j).getCurrCd());
											
											//BigDecimal chgAmt = new BigDecimal(exrateTargetChgVOs.get(j).getChgAmt());
											//BigDecimal exRate = new BigDecimal(exchangeRateVO.getExRate());	
											//invTtlLoclAmt = invTtlLoclAmt.add(chgAmt.multiply(exRate).setScale(currPoint,BigDecimal.ROUND_HALF_UP));
								
										}
										
										vVDCustomerVO.setLclCurr("USD");
										
										//Update OTS USD exchange rate and flag - 2015.02.27
										for (int j = 0; j < exrateTargetChgVOs.size(); j++) {
																						
											vVDCustomerVO.setCurr(exrateTargetChgVOs.get(j).getCurrCd());
											exchangeRateVO = utilCmd.searchExchangeRate(vVDCustomerVO);

											exrateChgVO.setArIfNo(exrateTargetChgVOs.get(j).getArIfNo());
											exrateChgVO.setArIfSerNo(exrateTargetChgVOs.get(j).getArIfSerNo());
											exrateChgVO.setChgSeq(exrateTargetChgVOs.get(j).getChgSeq());
											exrateChgVO.setInvXchRt(exchangeRateVO.getExRate());
											exrateChgVO.setInvXchRtDt(exchangeRateVO.getExRateDate());
											exrateChgVO.setUpdUsrId(userId);
											exrateChgVO.setCurrCd(exrateTargetChgVOs.get(j).getCurrCd());
											exrateChgVO.setNoGoodFlg("N");
											
											dbDao.modifyInvoiceUSDExrateChg(exrateChgVO);
											
											dbDao.modifyOTSDetailUSDExrate(exrateChgVO);
											dbDao.modifyOTSHistoryUSDExrate(exrateChgVO);
											dbDao.modifyOTSHeaderRateFlg(exrateChgVO);								
								
										}
									}
									
									vVDCustomerVO.setLclCurr("USD");
									vVDCustomerVO.setCurr(exrateTargetMainVOs.get(i).getLoclCurrCd());
									exchangeRateVO = utilCmd.searchExchangeRate(vVDCustomerVO);
									
									//Update OTS invoice exchange rate - 2015.02.27
									if (exrateTargetChgVOs != null) {
										for (int j = 0; j < exrateTargetChgVOs.size(); j++) {
	
											exrateChgVO.setArIfNo(exrateTargetChgVOs.get(j).getArIfNo());
											exrateChgVO.setArIfSerNo(exrateTargetChgVOs.get(j).getArIfSerNo());											
											exrateChgVO.setInvXchRt(exchangeRateVO.getExRate());										
											exrateChgVO.setUpdUsrId(userId);
											exrateChgVO.setLoclCurrCd(exrateTargetMainVOs.get(i).getLoclCurrCd());											
											
											dbDao.modifyINVMainINVUSDExrate(exrateChgVO);
											dbDao.modifyOTSHeaderINVUSDExrate(exrateChgVO);
											dbDao.modifyOTSHistoryINVUSDExrate(exrateChgVO);						
								
										}
									}
									
									vVDCustomerVO.setLclCurr(exrateTargetMainVOs.get(i).getLoclCurrCd());
									vVDCustomerVO.setCurr("USD");
									exchangeRateVO = utilCmd.searchExchangeRate(vVDCustomerVO);
									
									//Update OTS invoice exchange rate - 2015.02.27
									if (exrateTargetChgVOs != null) {
										for (int j = 0; j < exrateTargetChgVOs.size(); j++) {
	
											exrateChgVO.setArIfNo(exrateTargetChgVOs.get(j).getArIfNo());
											exrateChgVO.setArIfSerNo(exrateTargetChgVOs.get(j).getArIfSerNo());											
											exrateChgVO.setInvXchRt(exchangeRateVO.getExRate());										
											exrateChgVO.setUpdUsrId(userId);
											exrateChgVO.setLoclCurrCd(exrateTargetMainVOs.get(i).getLoclCurrCd());											
											
											dbDao.modifyINVMainINVLCLExrate(exrateChgVO);
											dbDao.modifyOTSHeaderINVExrate(exrateChgVO);
											dbDao.modifyOTSHistoryINVExrate(exrateChgVO);						
								
										}
									}
									
									//Process sakura I/F - 2015.02.27
									//if (exrateTargetChgVOs != null) {
									//	for (int j = 0; j < exrateTargetChgVOs.size(); j++) {
									//		command3.createSakuraOTSIFdata(exrateTargetChgVOs.get(j).getArIfNo()+exrateTargetChgVOs.get(j).getArIfSerNo(), "E");
									//	}
									//}
									
									exrateMainVO.setXchRtDt(exchangeRateVO.getExRateDate());
									exrateMainVO.setXchRtUsdTpCd(exchangeRateVO.getUsdExrateType());
									exrateMainVO.setXchRtN3rdTpCd(exchangeRateVO.getThirdExrateType());
									exrateMainVO.setObrdDt(exchangeRateVO.getCngIndivCd().equals("B") ? exchangeRateVO.getExRateDate() : "");
									exrateMainVO.setUsdXchRt(exchangeRateVO.getExRate());
									//exrateMainVO.setInvTtlLoclAmt(invTtlLoclAmt.toString());
									
									
									vvd = exrateTargetMainVOs.get(i).getVslCd()+ exrateTargetMainVOs.get(i).getSkdVoyNo()+exrateTargetMainVOs.get(i).getSkdDirCd();
									port = 	exrateTargetMainVOs.get(i).getIoBndCd().equals("O")?exrateTargetMainVOs.get(i).getPolCd():exrateTargetMainVOs.get(i).getPodCd();
									saDate = utilCmd.searchSADate(vvd , port, exrateTargetMainVOs.get(i).getIoBndCd());
									
									//Due Dt 구하는 로직 BC에서 직접 구하는 방식으로 변경 2009-11-30
									/*
									DueDateInputVO dueDateInputVO = new DueDateInputVO();

									dueDateInputVO.setBnd(exrateTargetMainVOs.get(i).getIoBndCd());
									dueDateInputVO.setCustCntCd(exrateTargetMainVOs.get(i).getActCustCntCd());
									dueDateInputVO.setCustSeq(exrateTargetMainVOs.get(i).getActCustSeq());
									dueDateInputVO.setSaDt(!saDate.equals("")?saDate.replace("-", ""):saDate);
									dueDateInputVO.setOfcCd(exrateTargetMainVOs.get(i).getArOfcCd());
									// Due Date 조회
									List<DueDateVO> list = command.searchDueDate(dueDateInputVO);
									
									if (list.size() > 0) {
										// Due Date 세팅
										exrateMainVO.setDueDt(list.get(0).getDueDate());
										exrateMainVO.setCustCrFlg(list.get(0).getCrFlg());
										exrateMainVO.setCrTermDys(list.get(0).getCrTermDys());
									}
									*/
									exrateMainVO.setArOfcCd(exrateTargetMainVOs.get(i).getArOfcCd());
									exrateMainVO.setSailArrDt(!saDate.equals("")?saDate.replace("-", ""):saDate);									
									exrateMainVO.setArIfNo(exrateTargetMainVOs.get(i).getArIfNo());
									exrateMainVO.setRevTpCd(exrateTargetMainVOs.get(i).getRevTpCd());
									exrateMainVO.setRevSrcCd(exrateTargetMainVOs.get(i).getRevSrcCd());
									exrateMainVO.setBkgNo(exrateTargetMainVOs.get(i).getBkgNo());
									exrateMainVO.setUpdUsrId(userId);
									exrateMainVO.setVvd(vvd);
									exrateMainVO.setPort(port);

									newIfNo = bCommand.modifyInvoiceExrateMain(exrateMainVO);
									
									if(!newIfNo.equals("")){
										//good_cnt = good_cnt + 1;
										invArIfNoVO = new InvArIfNoVO();
										invArIfNoVO.setIfNo(newIfNo);
										ifNos.add(invArIfNoVO);
										exceclIfNos.add(invArIfNoVO);
									}else{
										//no_good_cnt = no_good_cnt + 1;
										good_cnt = good_cnt + 1;
									}
								/*
								} else {
									// 경리 환율이 없는 경우 No Good Count 증가
									no_good_cnt = no_good_cnt + 1;
								}
								*/
								// Issue Data 인 경우
							} else {
								
								String invNo = command.searchInvoiceNoByIfNo(exrateTargetMainVOs.get(i).getArIfNo());
								
								// BL No 로 Max IF No 조회
								String maxIfNo = command.searchMaxInterfaceForExrate(exrateTargetMainVOs.get(i).getArOfcCd(), exrateTargetMainVOs.get(i).getBlSrcNo(), invNo);
								
								// Max IF No 와 같으면 Cancel->Create
								if (exrateTargetMainVOs.get(i).getArIfNo().equals(maxIfNo)) {									
									//good_cnt = good_cnt + 1;									
									
									ARCorrectionCkReturnVO arCorrectionCkReturnVO = command.searchRevTypeSrc(exrateTargetMainVOs.get(i).getBkgNo(), "C");

									CancelInvoiceVO cancelInvoiceVO = new CancelInvoiceVO();

									cancelInvoiceVO.setIfNo(exrateTargetMainVOs.get(i).getArIfNo());
									cancelInvoiceVO.setOtsSmryCd("");
									cancelInvoiceVO.setUserId(userId);
									cancelInvoiceVO.setInvNo(invNo);
									cancelInvoiceVO.setUiType("E");
									cancelInvoiceVO.setRevTpCd(arCorrectionCkReturnVO.getRevTpCd());
									cancelInvoiceVO.setRevSrcCd(arCorrectionCkReturnVO.getRevSrcCd());

									newIfNo = bCommand.createCancelIssueARInvoice(cancelInvoiceVO);
									
									if(!newIfNo.equals("")){
										invArIfNoVO = new InvArIfNoVO();
										invArIfNoVO.setIfNo(newIfNo);
										ifNos.add(invArIfNoVO);
									}									
									
									CancelInvoiceVO newInvoiceVO = new CancelInvoiceVO();

									newInvoiceVO.setIfNo(exrateTargetMainVOs.get(i).getArIfNo());
									newInvoiceVO.setInvNo(invNo);
									newInvoiceVO.setRevTpCd(arCorrectionCkReturnVO.getRevTpCd());
									newInvoiceVO.setRevSrcCd(arCorrectionCkReturnVO.getRevSrcCd());
									newInvoiceVO.setUiType("E");
									newInvoiceVO.setUserId(userId);

									// New Data 생성
									newIfNo = bCommand.createNewIssueARInvoice(newInvoiceVO);
									
									//bCommand.modifySplitCodebyInvNo(invNo, exrateTargetMainVOs.get(i).getArOfcCd(),"M", userId);									
									
									if(!newIfNo.equals("")){
										good_cnt = good_cnt + 1;
										invArIfNoVO = new InvArIfNoVO();
										invArIfNoVO.setIfNo(newIfNo);
										ifNos.add(invArIfNoVO);
										exceclIfNos.add(invArIfNoVO);
									}else{
										no_good_cnt = no_good_cnt + 1;
									}
									
									// Max IF No 와 다르면 Skip
								} else {
									good_cnt = good_cnt + 1;
								}
								
							}
						}
					}
					// VVD 조건인 경우
				} else if (runOpt.equals("V")) {
					if (exrateInputVOs != null) {
						// VVD 갯수
						for (int k = 0; k < exrateInputVOs.size(); k++) {
							ExrateInputVO exrateLocalInputVO = new ExrateInputVO();

							exrateLocalInputVO.setOfcCd(exrateInputVOs.get(k).getOfcCd());
							exrateLocalInputVO.setVvd(exrateInputVOs.get(k).getVvd());
							exrateLocalInputVO.setIoBndCd(exrateInputVOs.get(k).getIoBndCd());
							exrateLocalInputVO.setRunOpt(exrateInputVOs.get(k).getRunOpt());
							//exrateInputVO.setBlSrcNo(exrateInputVOs.get(k).getBlSrcNo());

							exrateTargetMainVOs = command.searchInvoiceForExrateList(exrateLocalInputVO);

							VVDCustomerVO vVDCustomerVO = new VVDCustomerVO();
							com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.ExchangeRateVO exchangeRateVO = null;
							ExrateMainVO exrateMainVO = new ExrateMainVO();
							ExrateChgVO exrateChgVO = new ExrateChgVO();

							//String usd_xch_rt = "";

							if (exrateTargetMainVOs != null) {

								tot_cnt = tot_cnt + exrateTargetMainVOs.size();

								for (int i = 0; i < exrateTargetMainVOs.size(); i++) {
									//usd_xch_rt = utilCmd.searchAccountRate("USD", exrateTargetMainVOs.get(i).getLoclCurrCd(), !exrateTargetMainVOs.get(i).getSailDt().equals("")?exrateTargetMainVOs.get(i).getSailDt().substring(0, 6):"");

									log.debug("issFlg = "+exrateTargetMainVOs.get(i).getIssFlg());
									log.debug("clrFlg = "+exrateTargetMainVOs.get(i).getInvClrFlg());
									log.debug("otsSmryCd = "+exrateTargetMainVOs.get(i).getOtsSmryCd());
									log.debug("dmdtArInvIssFlg = "+exrateTargetMainVOs.get(i).getDmdtArInvIssFlg());
									
									if (
											(!exrateTargetMainVOs.get(i).getOtsSmryCd().equals("BL") && 
												(exrateTargetMainVOs.get(i).getIssFlg().equals("N") || 
													// ((exrateTargetMainVOs.get(i).getRevSrcCd().equals("DM")||exrateTargetMainVOs.get(i).getRevSrcCd().equals("DT")) && exrateTargetMainVOs.get(i).getDmdtArInvIssFlg().equals("N"))||
													exrateTargetMainVOs.get(i).getInvClrFlg().equals("Y")
												)
											) 
											|| exrateTargetMainVOs.get(i).getOtsSmryCd().equals("BL")
										){
										
										//if (!usd_xch_rt.equals("")) {
											// 경리환율이 있는 경우 Good Count 증가
											//good_cnt = good_cnt + 1;

											List<ExrateTargetChgVO> exrateTargetChgVOs = null;
											exrateTargetChgVOs = command.searchInvoiceChgForExrateList(exrateTargetMainVOs.get(i).getArIfNo());

											//BigDecimal invTtlLoclAmt = new BigDecimal("0");
											//int currPoint = 0;
											
											vvd = exrateTargetMainVOs.get(i).getVslCd()+ exrateTargetMainVOs.get(i).getSkdVoyNo()+exrateTargetMainVOs.get(i).getSkdDirCd();
											port = 	exrateTargetMainVOs.get(i).getIoBndCd().equals("O")?exrateTargetMainVOs.get(i).getPolCd():exrateTargetMainVOs.get(i).getPodCd();
											saDate = utilCmd.searchSADate(vvd , port, exrateTargetMainVOs.get(i).getIoBndCd());

											vVDCustomerVO.setInvCntryCd(exrateTargetMainVOs.get(i).getInvCustCntCd());
											vVDCustomerVO.setInvCustCd(exrateTargetMainVOs.get(i).getInvCustSeq());
											vVDCustomerVO.setOfcCd(exrateTargetMainVOs.get(i).getArOfcCd());
											vVDCustomerVO.setLclCurr(exrateTargetMainVOs.get(i).getLoclCurrCd());
											vVDCustomerVO.setBnd(exrateTargetMainVOs.get(i).getIoBndCd());
											vVDCustomerVO.setVsl(exrateTargetMainVOs.get(i).getVslCd());
											vVDCustomerVO.setVoy(exrateTargetMainVOs.get(i).getSkdVoyNo());
											vVDCustomerVO.setDep(exrateTargetMainVOs.get(i).getSkdDirCd());
											vVDCustomerVO.setPol(exrateTargetMainVOs.get(i).getPolCd());
											vVDCustomerVO.setPod(exrateTargetMainVOs.get(i).getPodCd());
											vVDCustomerVO.setSaDt(!saDate.equals("")?saDate.replace("-", ""):saDate);
											vVDCustomerVO.setBkgNo(exrateTargetMainVOs.get(i).getBkgNo());
											vVDCustomerVO.setSvcScp(exrateTargetMainVOs.get(i).getSvcScpCd());

											if (exrateTargetChgVOs != null) {
												for (int j = 0; j < exrateTargetChgVOs.size(); j++) {
													
													vVDCustomerVO.setCurr(exrateTargetChgVOs.get(j).getCurrCd());

													exchangeRateVO = utilCmd.searchExchangeRate(vVDCustomerVO);

													exrateChgVO.setArIfNo(exrateTargetChgVOs.get(j).getArIfNo());
													exrateChgVO.setArIfSerNo(exrateTargetChgVOs.get(j).getArIfSerNo());
													exrateChgVO.setChgSeq(exrateTargetChgVOs.get(j).getChgSeq());
													exrateChgVO.setInvXchRt(exchangeRateVO.getExRate());
													exrateChgVO.setInvXchRtDt(exchangeRateVO.getExRateDate());
													exrateChgVO.setUpdUsrId(userId);
													exrateChgVO.setLoclCurrCd(exrateTargetMainVOs.get(i).getLoclCurrCd());
													exrateChgVO.setCurrCd(exrateTargetChgVOs.get(j).getCurrCd());
													exrateChgVO.setNoGoodFlg("N");

													bCommand.modifyInvoiceExrateChg(exrateChgVO);
													
													//Update OTS local exchange rate and flag - 2015.02.27
													dbDao.modifyOTSDetailLoclExrate(exrateChgVO);
													dbDao.modifyOTSHistoryLoclExrate(exrateChgVO);
													dbDao.modifyOTSHeaderRateFlg(exrateChgVO);

													//currPoint = dbDao2.searchCurrencyPoint(exrateTargetChgVOs.get(j).getCurrCd());
													
													//BigDecimal chgAmt = new BigDecimal(exrateTargetChgVOs.get(j).getChgAmt());
													//BigDecimal exRate = new BigDecimal(exchangeRateVO.getExRate());	
													//invTtlLoclAmt = invTtlLoclAmt.add(chgAmt.multiply(exRate).setScale(currPoint,BigDecimal.ROUND_HALF_UP));
												}
												
												vVDCustomerVO.setLclCurr("USD");
												
												//Update OTS USD exchange rate and flag - 2015.02.27
												for (int j = 0; j < exrateTargetChgVOs.size(); j++) {
																								
													vVDCustomerVO.setCurr(exrateTargetChgVOs.get(j).getCurrCd());
													exchangeRateVO = utilCmd.searchExchangeRate(vVDCustomerVO);

													exrateChgVO.setArIfNo(exrateTargetChgVOs.get(j).getArIfNo());
													exrateChgVO.setArIfSerNo(exrateTargetChgVOs.get(j).getArIfSerNo());
													exrateChgVO.setChgSeq(exrateTargetChgVOs.get(j).getChgSeq());
													exrateChgVO.setInvXchRt(exchangeRateVO.getExRate());
													exrateChgVO.setInvXchRtDt(exchangeRateVO.getExRateDate());
													exrateChgVO.setUpdUsrId(userId);
													exrateChgVO.setCurrCd(exrateTargetChgVOs.get(j).getCurrCd());
													exrateChgVO.setNoGoodFlg("N");
													
													dbDao.modifyInvoiceUSDExrateChg(exrateChgVO);
													
													dbDao.modifyOTSDetailUSDExrate(exrateChgVO);
													dbDao.modifyOTSHistoryUSDExrate(exrateChgVO);
													dbDao.modifyOTSHeaderRateFlg(exrateChgVO);								
										
												}
											}
											
											vVDCustomerVO.setLclCurr("USD");
											vVDCustomerVO.setCurr(exrateTargetMainVOs.get(i).getLoclCurrCd());
											exchangeRateVO = utilCmd.searchExchangeRate(vVDCustomerVO);
											
											//Update OTS invoice exchange rate - 2015.02.27
											if (exrateTargetChgVOs != null) {
												for (int j = 0; j < exrateTargetChgVOs.size(); j++) {
			
													exrateChgVO.setArIfNo(exrateTargetChgVOs.get(j).getArIfNo());
													exrateChgVO.setArIfSerNo(exrateTargetChgVOs.get(j).getArIfSerNo());											
													exrateChgVO.setInvXchRt(exchangeRateVO.getExRate());										
													exrateChgVO.setUpdUsrId(userId);
													exrateChgVO.setLoclCurrCd(exrateTargetMainVOs.get(i).getLoclCurrCd());											
													
													dbDao.modifyINVMainINVUSDExrate(exrateChgVO);
													dbDao.modifyOTSHeaderINVUSDExrate(exrateChgVO);
													dbDao.modifyOTSHistoryINVUSDExrate(exrateChgVO);						
										
												}
											}
											
											vVDCustomerVO.setLclCurr(exrateTargetMainVOs.get(i).getLoclCurrCd());
											vVDCustomerVO.setCurr("USD");
											exchangeRateVO = utilCmd.searchExchangeRate(vVDCustomerVO);
											
											//Update OTS invoice exchange rate - 2015.02.27
											if (exrateTargetChgVOs != null) {
												for (int j = 0; j < exrateTargetChgVOs.size(); j++) {
			
													exrateChgVO.setArIfNo(exrateTargetChgVOs.get(j).getArIfNo());
													exrateChgVO.setArIfSerNo(exrateTargetChgVOs.get(j).getArIfSerNo());											
													exrateChgVO.setInvXchRt(exchangeRateVO.getExRate());										
													exrateChgVO.setUpdUsrId(userId);
													exrateChgVO.setLoclCurrCd(exrateTargetMainVOs.get(i).getLoclCurrCd());											
													
													dbDao.modifyINVMainINVLCLExrate(exrateChgVO);
													dbDao.modifyOTSHeaderINVExrate(exrateChgVO);
													dbDao.modifyOTSHistoryINVExrate(exrateChgVO);	
													
												}
											}
											
											//Process sakura I/F - 2015.02.27
											//if (exrateTargetChgVOs != null) {
											//	for (int j = 0; j < exrateTargetChgVOs.size(); j++) {
											//		command3.createSakuraOTSIFdata(exrateTargetChgVOs.get(j).getArIfNo()+exrateTargetChgVOs.get(j).getArIfSerNo(), "E");
											//	}
											//}
											
											exrateMainVO.setXchRtDt(exchangeRateVO.getExRateDate());
											exrateMainVO.setXchRtUsdTpCd(exchangeRateVO.getUsdExrateType());
											exrateMainVO.setXchRtN3rdTpCd(exchangeRateVO.getThirdExrateType());
											exrateMainVO.setObrdDt(exchangeRateVO.getCngIndivCd().equals("B") ? exchangeRateVO.getExRateDate() : "");
											exrateMainVO.setUsdXchRt(exchangeRateVO.getExRate());
											//exrateMainVO.setInvTtlLoclAmt(invTtlLoclAmt.toString());
											
											vvd = exrateTargetMainVOs.get(i).getVslCd()+ exrateTargetMainVOs.get(i).getSkdVoyNo()+exrateTargetMainVOs.get(i).getSkdDirCd();
											port = 	exrateTargetMainVOs.get(i).getIoBndCd().equals("O")?exrateTargetMainVOs.get(i).getPolCd():exrateTargetMainVOs.get(i).getPodCd();
											saDate = utilCmd.searchSADate(vvd , port, exrateTargetMainVOs.get(i).getIoBndCd());
											
											//Due Dt 구하는 로직 BC에서 직접 구하는 방식으로 변경 2009-11-30
											/*
											DueDateInputVO dueDateInputVO = new DueDateInputVO();

											dueDateInputVO.setBnd(exrateTargetMainVOs.get(i).getIoBndCd());
											dueDateInputVO.setCustCntCd(exrateTargetMainVOs.get(i).getActCustCntCd());
											dueDateInputVO.setCustSeq(exrateTargetMainVOs.get(i).getActCustSeq());
											dueDateInputVO.setSaDt(!saDate.equals("")?saDate.replace("-", ""):saDate);
											dueDateInputVO.setOfcCd(exrateTargetMainVOs.get(i).getArOfcCd());
											// Due Date 조회
											List<DueDateVO> list = command.searchDueDate(dueDateInputVO);
											
											if (list.size() > 0) {
												// Due Date 세팅
												exrateMainVO.setDueDt(list.get(0).getDueDate());
												exrateMainVO.setCustCrFlg(list.get(0).getCrFlg());
												exrateMainVO.setCrTermDys(list.get(0).getCrTermDys());
											}
											*/
											exrateMainVO.setArOfcCd(exrateTargetMainVOs.get(i).getArOfcCd());
											exrateMainVO.setSailArrDt(!saDate.equals("")?saDate.replace("-", ""):saDate);											
											exrateMainVO.setArIfNo(exrateTargetMainVOs.get(i).getArIfNo());
											exrateMainVO.setRevTpCd(exrateTargetMainVOs.get(i).getRevTpCd());
											exrateMainVO.setRevSrcCd(exrateTargetMainVOs.get(i).getRevSrcCd());
											exrateMainVO.setBkgNo(exrateTargetMainVOs.get(i).getBkgNo());
											exrateMainVO.setUpdUsrId(userId);
											exrateMainVO.setVvd(vvd);
											exrateMainVO.setPort(port);

											newIfNo = bCommand.modifyInvoiceExrateMain(exrateMainVO);
											
											if(!newIfNo.equals("")){
												//good_cnt = good_cnt + 1;
												invArIfNoVO = new InvArIfNoVO();
												invArIfNoVO.setIfNo(newIfNo);
												ifNos.add(invArIfNoVO);
												exceclIfNos.add(invArIfNoVO);
											}else{
												//no_good_cnt = no_good_cnt + 1;
												good_cnt = good_cnt + 1;
											}
										/*
										} else {
											// 경리 환율이 없는 경우 No Good Count 증가
											no_good_cnt = no_good_cnt + 1;
										}
										*/
										// Issue Data 인 경우
									} else {
										
										String invNo = command.searchInvoiceNoByIfNo(exrateTargetMainVOs.get(i).getArIfNo());
										
										// BL No 로 Max IF No 조회
										String maxIfNo = command.searchMaxInterfaceForExrate(exrateTargetMainVOs.get(i).getArOfcCd(), exrateTargetMainVOs.get(i).getBlSrcNo(), invNo);
										
										// Max IF No 와 같으면 Cancel->Create
										if (exrateTargetMainVOs.get(i).getArIfNo().equals(maxIfNo)) {									
											//good_cnt = good_cnt + 1;									
											
											ARCorrectionCkReturnVO arCorrectionCkReturnVO = command.searchRevTypeSrc(exrateTargetMainVOs.get(i).getBkgNo(), "C");

											CancelInvoiceVO cancelInvoiceVO = new CancelInvoiceVO();

											cancelInvoiceVO.setIfNo(exrateTargetMainVOs.get(i).getArIfNo());
											cancelInvoiceVO.setOtsSmryCd("");
											cancelInvoiceVO.setUserId(userId);
											cancelInvoiceVO.setInvNo(invNo);
											cancelInvoiceVO.setUiType("E");
											cancelInvoiceVO.setRevTpCd(arCorrectionCkReturnVO.getRevTpCd());
											cancelInvoiceVO.setRevSrcCd(arCorrectionCkReturnVO.getRevSrcCd());

											newIfNo = bCommand.createCancelIssueARInvoice(cancelInvoiceVO);
											
											if(!newIfNo.equals("")){
												invArIfNoVO = new InvArIfNoVO();
												invArIfNoVO.setIfNo(newIfNo);
												ifNos.add(invArIfNoVO);
											}									
											
											CancelInvoiceVO newInvoiceVO = new CancelInvoiceVO();

											newInvoiceVO.setIfNo(exrateTargetMainVOs.get(i).getArIfNo());
											newInvoiceVO.setInvNo(invNo);
											newInvoiceVO.setRevTpCd(arCorrectionCkReturnVO.getRevTpCd());
											newInvoiceVO.setRevSrcCd(arCorrectionCkReturnVO.getRevSrcCd());
											newInvoiceVO.setUiType("E");
											newInvoiceVO.setUserId(userId);

											// New Data 생성
											newIfNo = bCommand.createNewIssueARInvoice(newInvoiceVO);
											
											//bCommand.modifySplitCodebyInvNo(invNo, exrateTargetMainVOs.get(i).getArOfcCd(),"M", userId);									
											
											if(!newIfNo.equals("")){
												good_cnt = good_cnt + 1;
												invArIfNoVO = new InvArIfNoVO();
												invArIfNoVO.setIfNo(newIfNo);
												ifNos.add(invArIfNoVO);
												exceclIfNos.add(invArIfNoVO);
											}else{
												no_good_cnt = no_good_cnt + 1;
											}
											
											// Max IF No 와 다르면 Skip
										} else {
											good_cnt = good_cnt + 1;
										}
									}
								}
							}
						}
					}
					// B/L 조건인 경우
				} else if (runOpt.equals("B")) {
					if (exrateInputVOs != null) {
						// B/L  갯수
						for (int k = 0; k < exrateInputVOs.size(); k++) {
							ExrateInputVO exrateLocalInputVO = new ExrateInputVO();

							exrateLocalInputVO.setOfcCd(exrateInputVOs.get(k).getOfcCd());
							exrateLocalInputVO.setRunOpt(exrateInputVOs.get(k).getRunOpt());
							exrateLocalInputVO.setBlSrcNo(exrateInputVOs.get(k).getBlSrcNo());

							exrateTargetMainVOs = command.searchInvoiceForExrateList(exrateLocalInputVO);

							VVDCustomerVO vVDCustomerVO = new VVDCustomerVO();
							com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.ExchangeRateVO exchangeRateVO = null;
							ExrateMainVO exrateMainVO = new ExrateMainVO();
							ExrateChgVO exrateChgVO = new ExrateChgVO();

							//String usd_xch_rt = "";

							if (exrateTargetMainVOs != null) {

								tot_cnt = tot_cnt + exrateTargetMainVOs.size();

								for (int i = 0; i < exrateTargetMainVOs.size(); i++) {
									//usd_xch_rt = utilCmd.searchAccountRate("USD", exrateTargetMainVOs.get(i).getLoclCurrCd(), !exrateTargetMainVOs.get(i).getSailDt().equals("")?exrateTargetMainVOs.get(i).getSailDt().substring(0, 6):"");

									log.debug("issFlg = "+exrateTargetMainVOs.get(i).getIssFlg());
									log.debug("clrFlg = "+exrateTargetMainVOs.get(i).getInvClrFlg());
									log.debug("otsSmryCd = "+exrateTargetMainVOs.get(i).getOtsSmryCd());
									log.debug("dmdtArInvIssFlg = "+exrateTargetMainVOs.get(i).getDmdtArInvIssFlg());
									
									// Not Issue Data이거나  OtsSmryCD가 BL이 아니고 DmdtArInvIssFlg가 N인 경우
									if (
											(!exrateTargetMainVOs.get(i).getOtsSmryCd().equals("BL") && 
												(exrateTargetMainVOs.get(i).getIssFlg().equals("N") || 
													// ((exrateTargetMainVOs.get(i).getRevSrcCd().equals("DM")||exrateTargetMainVOs.get(i).getRevSrcCd().equals("DT")) && exrateTargetMainVOs.get(i).getDmdtArInvIssFlg().equals("N")) ||
													exrateTargetMainVOs.get(i).getInvClrFlg().equals("Y")
												)
											) 
											|| exrateTargetMainVOs.get(i).getOtsSmryCd().equals("BL")
										){
										
										//if (!usd_xch_rt.equals("")) {
											// 경리환율이 있는 경우 Good Count 증가
											//good_cnt = good_cnt + 1;

											List<ExrateTargetChgVO> exrateTargetChgVOs = null;
											exrateTargetChgVOs = command.searchInvoiceChgForExrateList(exrateTargetMainVOs.get(i).getArIfNo());
											
											//BigDecimal invTtlLoclAmt = new BigDecimal("0");
											//int currPoint = 0;
											
											vvd = exrateTargetMainVOs.get(i).getVslCd()+ exrateTargetMainVOs.get(i).getSkdVoyNo()+exrateTargetMainVOs.get(i).getSkdDirCd();
											port = 	exrateTargetMainVOs.get(i).getIoBndCd().equals("O")?exrateTargetMainVOs.get(i).getPolCd():exrateTargetMainVOs.get(i).getPodCd();
											saDate = utilCmd.searchSADate(vvd , port, exrateTargetMainVOs.get(i).getIoBndCd());

											vVDCustomerVO.setInvCntryCd(exrateTargetMainVOs.get(i).getInvCustCntCd());
											vVDCustomerVO.setInvCustCd(exrateTargetMainVOs.get(i).getInvCustSeq());
											vVDCustomerVO.setOfcCd(exrateTargetMainVOs.get(i).getArOfcCd());
											vVDCustomerVO.setLclCurr(exrateTargetMainVOs.get(i).getLoclCurrCd());
											vVDCustomerVO.setBnd(exrateTargetMainVOs.get(i).getIoBndCd());
											vVDCustomerVO.setVsl(exrateTargetMainVOs.get(i).getVslCd());
											vVDCustomerVO.setVoy(exrateTargetMainVOs.get(i).getSkdVoyNo());
											vVDCustomerVO.setDep(exrateTargetMainVOs.get(i).getSkdDirCd());
											vVDCustomerVO.setPol(exrateTargetMainVOs.get(i).getPolCd());
											vVDCustomerVO.setPod(exrateTargetMainVOs.get(i).getPodCd());
											vVDCustomerVO.setSaDt(!saDate.equals("")?saDate.replace("-", ""):saDate);
											vVDCustomerVO.setBkgNo(exrateTargetMainVOs.get(i).getBkgNo());
											vVDCustomerVO.setSvcScp(exrateTargetMainVOs.get(i).getSvcScpCd());

											if (exrateTargetChgVOs != null) {
												for (int j = 0; j < exrateTargetChgVOs.size(); j++) {
													
													vVDCustomerVO.setCurr(exrateTargetChgVOs.get(j).getCurrCd());

													exchangeRateVO = utilCmd.searchExchangeRate(vVDCustomerVO);

													exrateChgVO.setArIfNo(exrateTargetChgVOs.get(j).getArIfNo());
													exrateChgVO.setArIfSerNo(exrateTargetChgVOs.get(j).getArIfSerNo());
													exrateChgVO.setChgSeq(exrateTargetChgVOs.get(j).getChgSeq());
													exrateChgVO.setInvXchRt(exchangeRateVO.getExRate());
													exrateChgVO.setInvXchRtDt(exchangeRateVO.getExRateDate());
													exrateChgVO.setUpdUsrId(userId);
													exrateChgVO.setLoclCurrCd(exrateTargetMainVOs.get(i).getLoclCurrCd());
													exrateChgVO.setCurrCd(exrateTargetChgVOs.get(j).getCurrCd());
													exrateChgVO.setNoGoodFlg("N");

													bCommand.modifyInvoiceExrateChg(exrateChgVO);
													
													//Update OTS local exchange rate and flag - 2015.02.27
													dbDao.modifyOTSDetailLoclExrate(exrateChgVO);
													dbDao.modifyOTSHistoryLoclExrate(exrateChgVO);
													dbDao.modifyOTSHeaderRateFlg(exrateChgVO);
													//currPoint = dbDao2.searchCurrencyPoint(exrateTargetChgVOs.get(j).getCurrCd());
													
													//BigDecimal chgAmt = new BigDecimal(exrateTargetChgVOs.get(j).getChgAmt());
													//BigDecimal exRate = new BigDecimal(exchangeRateVO.getExRate());	
													//invTtlLoclAmt = invTtlLoclAmt.add(chgAmt.multiply(exRate).setScale(currPoint,BigDecimal.ROUND_HALF_UP));

												}
												
												vVDCustomerVO.setLclCurr("USD");
												
												//Update OTS USD exchange rate and flag - 2015.02.27
												for (int j = 0; j < exrateTargetChgVOs.size(); j++) {
																								
													vVDCustomerVO.setCurr(exrateTargetChgVOs.get(j).getCurrCd());
													exchangeRateVO = utilCmd.searchExchangeRate(vVDCustomerVO);

													exrateChgVO.setArIfNo(exrateTargetChgVOs.get(j).getArIfNo());
													exrateChgVO.setArIfSerNo(exrateTargetChgVOs.get(j).getArIfSerNo());
													exrateChgVO.setChgSeq(exrateTargetChgVOs.get(j).getChgSeq());
													exrateChgVO.setInvXchRt(exchangeRateVO.getExRate());
													exrateChgVO.setInvXchRtDt(exchangeRateVO.getExRateDate());
													exrateChgVO.setUpdUsrId(userId);
													exrateChgVO.setCurrCd(exrateTargetChgVOs.get(j).getCurrCd());
													exrateChgVO.setNoGoodFlg("N");
													
													dbDao.modifyInvoiceUSDExrateChg(exrateChgVO);
													
													dbDao.modifyOTSDetailUSDExrate(exrateChgVO);
													dbDao.modifyOTSHistoryUSDExrate(exrateChgVO);
													dbDao.modifyOTSHeaderRateFlg(exrateChgVO);								
										
												}
											}
											
											vVDCustomerVO.setLclCurr("USD");
											vVDCustomerVO.setCurr(exrateTargetMainVOs.get(i).getLoclCurrCd());
											exchangeRateVO = utilCmd.searchExchangeRate(vVDCustomerVO);
											
											//Update OTS invoice exchange rate - 2015.02.27
											if (exrateTargetChgVOs != null) {
												for (int j = 0; j < exrateTargetChgVOs.size(); j++) {
			
													exrateChgVO.setArIfNo(exrateTargetChgVOs.get(j).getArIfNo());
													exrateChgVO.setArIfSerNo(exrateTargetChgVOs.get(j).getArIfSerNo());											
													exrateChgVO.setInvXchRt(exchangeRateVO.getExRate());										
													exrateChgVO.setUpdUsrId(userId);
													exrateChgVO.setLoclCurrCd(exrateTargetMainVOs.get(i).getLoclCurrCd());											
													
													dbDao.modifyINVMainINVUSDExrate(exrateChgVO);
													dbDao.modifyOTSHeaderINVUSDExrate(exrateChgVO);
													dbDao.modifyOTSHistoryINVUSDExrate(exrateChgVO);						
										
												}
											}
											
											vVDCustomerVO.setLclCurr(exrateTargetMainVOs.get(i).getLoclCurrCd());
											vVDCustomerVO.setCurr("USD");
											exchangeRateVO = utilCmd.searchExchangeRate(vVDCustomerVO);
											
											//Update OTS invoice exchange rate - 2015.02.27
											if (exrateTargetChgVOs != null) {
												for (int j = 0; j < exrateTargetChgVOs.size(); j++) {
			
													exrateChgVO.setArIfNo(exrateTargetChgVOs.get(j).getArIfNo());
													exrateChgVO.setArIfSerNo(exrateTargetChgVOs.get(j).getArIfSerNo());											
													exrateChgVO.setInvXchRt(exchangeRateVO.getExRate());										
													exrateChgVO.setUpdUsrId(userId);
													exrateChgVO.setLoclCurrCd(exrateTargetMainVOs.get(i).getLoclCurrCd());											
													
													dbDao.modifyINVMainINVLCLExrate(exrateChgVO);
													dbDao.modifyOTSHeaderINVExrate(exrateChgVO);
													dbDao.modifyOTSHistoryINVExrate(exrateChgVO);						
										
												}
											}
											
											//Process sakura I/F - 2015.02.27
											//if (exrateTargetChgVOs != null) {
											//	for (int j = 0; j < exrateTargetChgVOs.size(); j++) {
											//		command3.createSakuraOTSIFdata(exrateTargetChgVOs.get(j).getArIfNo()+exrateTargetChgVOs.get(j).getArIfSerNo(), "E");
											//	}
											//}
											
											exrateMainVO.setXchRtDt(exchangeRateVO.getExRateDate());
											exrateMainVO.setXchRtUsdTpCd(exchangeRateVO.getUsdExrateType());
											exrateMainVO.setXchRtN3rdTpCd(exchangeRateVO.getThirdExrateType());
											exrateMainVO.setObrdDt(exchangeRateVO.getCngIndivCd().equals("B") ? exchangeRateVO.getExRateDate() : "");
											exrateMainVO.setUsdXchRt(exchangeRateVO.getExRate());
											//exrateMainVO.setInvTtlLoclAmt(invTtlLoclAmt.toString());
											
											vvd = exrateTargetMainVOs.get(i).getVslCd()+ exrateTargetMainVOs.get(i).getSkdVoyNo()+exrateTargetMainVOs.get(i).getSkdDirCd();
											port = 	exrateTargetMainVOs.get(i).getIoBndCd().equals("O")?exrateTargetMainVOs.get(i).getPolCd():exrateTargetMainVOs.get(i).getPodCd();
											saDate = utilCmd.searchSADate(vvd , port, exrateTargetMainVOs.get(i).getIoBndCd());											
											
											exrateMainVO.setArOfcCd(exrateTargetMainVOs.get(i).getArOfcCd());
											exrateMainVO.setSailArrDt(!saDate.equals("")?saDate.replace("-", ""):saDate);											
											exrateMainVO.setArIfNo(exrateTargetMainVOs.get(i).getArIfNo());
											exrateMainVO.setRevTpCd(exrateTargetMainVOs.get(i).getRevTpCd());
											exrateMainVO.setRevSrcCd(exrateTargetMainVOs.get(i).getRevSrcCd());
											exrateMainVO.setBkgNo(exrateTargetMainVOs.get(i).getBkgNo());
											exrateMainVO.setUpdUsrId(userId);
											exrateMainVO.setVvd(vvd);
											exrateMainVO.setPort(port);

											newIfNo = bCommand.modifyInvoiceExrateMain(exrateMainVO);
											
											if(!newIfNo.equals("")){
												//good_cnt = good_cnt + 1;
												invArIfNoVO = new InvArIfNoVO();
												invArIfNoVO.setIfNo(newIfNo);
												ifNos.add(invArIfNoVO);
												exceclIfNos.add(invArIfNoVO);
											}else{
												//no_good_cnt = no_good_cnt + 1;
												good_cnt = good_cnt + 1;
											}
										/*
										} else {
											// 경리 환율이 없는 경우 No Good Count 증가
											no_good_cnt = no_good_cnt + 1;
										}
										*/
										// Issue Data 인 경우
									} else {
										
										String invNo = command.searchInvoiceNoByIfNo(exrateTargetMainVOs.get(i).getArIfNo());
										
										// BL No 로 Max IF No 조회
										String maxIfNo = command.searchMaxInterfaceForExrate(exrateTargetMainVOs.get(i).getArOfcCd(), exrateTargetMainVOs.get(i).getBlSrcNo(), invNo);
										
										// Max IF No 와 같으면 Cancel->Create
										if (exrateTargetMainVOs.get(i).getArIfNo().equals(maxIfNo)) {									
											//good_cnt = good_cnt + 1;									
											
											ARCorrectionCkReturnVO arCorrectionCkReturnVO = command.searchRevTypeSrc(exrateTargetMainVOs.get(i).getBkgNo(), "C");

											CancelInvoiceVO cancelInvoiceVO = new CancelInvoiceVO();

											cancelInvoiceVO.setIfNo(exrateTargetMainVOs.get(i).getArIfNo());
											cancelInvoiceVO.setOtsSmryCd("");
											cancelInvoiceVO.setUserId(userId);
											cancelInvoiceVO.setInvNo(invNo);
											cancelInvoiceVO.setUiType("E");
											cancelInvoiceVO.setRevTpCd(arCorrectionCkReturnVO.getRevTpCd());
											cancelInvoiceVO.setRevSrcCd(arCorrectionCkReturnVO.getRevSrcCd());

											newIfNo = bCommand.createCancelIssueARInvoice(cancelInvoiceVO);
											
											if(!newIfNo.equals("")){
												invArIfNoVO = new InvArIfNoVO();
												invArIfNoVO.setIfNo(newIfNo);
												ifNos.add(invArIfNoVO);
											}									
											
											CancelInvoiceVO newInvoiceVO = new CancelInvoiceVO();

											newInvoiceVO.setIfNo(exrateTargetMainVOs.get(i).getArIfNo());
											newInvoiceVO.setInvNo(invNo);
											newInvoiceVO.setRevTpCd(arCorrectionCkReturnVO.getRevTpCd());
											newInvoiceVO.setRevSrcCd(arCorrectionCkReturnVO.getRevSrcCd());
											newInvoiceVO.setUiType("E");
											newInvoiceVO.setUserId(userId);

											// New Data 생성
											newIfNo = bCommand.createNewIssueARInvoice(newInvoiceVO);
											
											//bCommand.modifySplitCodebyInvNo(invNo, exrateTargetMainVOs.get(i).getArOfcCd(),"M", userId);									
											
											if(!newIfNo.equals("")){
												good_cnt = good_cnt + 1;
												invArIfNoVO = new InvArIfNoVO();
												invArIfNoVO.setIfNo(newIfNo);
												ifNos.add(invArIfNoVO);
												exceclIfNos.add(invArIfNoVO);
											}else{
												no_good_cnt = no_good_cnt + 1;
											}
											
											// Max IF No 와 다르면 Skip
										} else {
											good_cnt = good_cnt + 1;
										}
									}
								}
							}
						}
					}
				}
				
				
				count1 = tot_cnt;
				count2 = good_cnt;
				count3 = no_good_cnt;
				
				log.debug("tot_cnt:"+tot_cnt);
				log.debug("good_cnt:"+good_cnt);
				log.debug("no_good_cnt:"+no_good_cnt);
				
				if(exceclIfNos.size()>0){
					exRateCountVOs = dbDao2.searchInvoiceExrateMain(exceclIfNos);
				}
				
				// 2015.02.26 AR OTS creation
				if(ifNos!= null && ifNos.size()>0){
					command2.createOutstandingInfo(ifNos);
				}
			}
			if(exRateCountVOs.size()>0){			
				exRateCountVOs.get(0).setCount1(String.valueOf(count1));
				exRateCountVOs.get(0).setCount2(String.valueOf(count2));
				exRateCountVOs.get(0).setCount3(String.valueOf(count3));
			}else{
				ExRateCountVO exRateCountVO = new ExRateCountVO();
				exRateCountVO.setCount1(String.valueOf(count1));
				exRateCountVO.setCount2(String.valueOf(count2));
				exRateCountVO.setCount3(String.valueOf(count3));
				exRateCountVOs.add(exRateCountVO);
			}
			//log.debug("exRateCountVOs.size():"+exRateCountVOs.size());
			return exRateCountVOs;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getUserMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage(),de);
		}
	}
}