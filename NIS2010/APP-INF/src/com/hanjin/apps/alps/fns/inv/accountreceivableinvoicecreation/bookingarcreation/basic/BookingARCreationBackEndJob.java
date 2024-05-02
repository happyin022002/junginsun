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
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic;

//import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.acm.acmcalculation.agncommcalculation.basic.AGNCommCalculationBC;
import com.hanjin.apps.alps.esm.acm.acmcalculation.agncommcalculation.basic.AGNCommCalculationBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration.BookingARCreationBackEndDBDAO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration.BookingARCreationDBDAO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.CancelInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateMainVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateTargetChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateTargetMainVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExRateCountVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARBkgInterfaceCreationVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.RevVVDLaneVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.ExchangeRateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.ARInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.basic.ARInvoiceCorrectionBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.basic.ARInvoiceCorrectionBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARCorrectionCkReturnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.DueDateInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvArIfNoVO;
import com.hanjin.apps.alps.fns.inv.invcommon.invcommon.basic.INVCommonUtil;
import com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.VVDCustomerVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
/**
 * ALPS-AccountReceivableInvoiceCreation Business Logic Basic Command implementation<br>
 * - ALPS-AccountReceivableInvoiceCreation에 대한 비지니스 로직을 처리한다.<br>
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
		this.exRateVOs = exRateVOs;
	}
	
	public void setExrateInputVO(ExrateInputVO exrateInputVO) {
		this.exrateInputVO = exrateInputVO;
	}

	public void setExrateInputVOs(List<ExrateInputVO> exrateInputVOs) {
		this.exrateInputVOs = exrateInputVOs;
	}
	
	public void setDueDateInputVOs(DueDateInputVO[] dueDateInputVOs) {
		this.dueDateInputVOs = dueDateInputVOs;
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
		
		ExchangeRateVO exRateVo = new ExchangeRateVO();
		ARInvoiceVO invoiceVO = new ARInvoiceVO();
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		try {			
			Thread.sleep(1000);
			
			List<ExRateCountVO> exRateCountVOs = new ArrayList<ExRateCountVO>();  
			
			if(uiType.equals("C")){
			
				DBRowSet rowSet = null;
				
				List<String> bkgNos = new ArrayList<String>();
				List<String> uniqueBkgNos = new ArrayList<String>();
				AGNCommCalculationBC command = new AGNCommCalculationBCImpl();

				log.info("exRateVOs .length:"+exRateVOs .length);
				
				for ( int i=0; i<exRateVOs .length; i++ ) {						
					
					if ( exRateVOs[i].getIbflag().equals("I")||exRateVOs[i].getIbflag().equals("U")){
						exRateVo.setVslCd(exRateVOs[i].getVslCd());
						exRateVo.setSkdVoyNo(exRateVOs[i].getSkdVoyNo());
						exRateVo.setSkdDirCd(exRateVOs[i].getSkdDirCd());
						exRateVo.setIoBndCd(exRateVOs[i].getIoBndCd());
						exRateVo.setLoclCurrCd(exRateVOs[i].getLoclCurrCd());
						exRateVo.setPortCd(exRateVOs[i].getPortCd());
						exRateVo.setSvcScpCd(exRateVOs[i].getSvcScpCd());
						exRateVo.setChgCurrCd(exRateVOs[i].getChgCurrCd());
						
						exRateVo.setXchRtTpCd(exRateVOs[i].getXchRtTpCd());
						exRateVo.setCustCntCd(exRateVOs[i].getCustCntCd());
						exRateVo.setCustSeq(exRateVOs[i].getCustSeq());
						exRateVo.setFmDt(exRateVOs[i].getFmDt());
						exRateVo.setToDt(exRateVOs[i].getToDt());
						
						log.info("exRateVOs[i].getInvXchRt():"+exRateVOs[i].getInvXchRt());						
						
						rowSet = dbDao.searchARInvoiceExchangeRateList(exRateVo);				
						log.info("rowSet.getRowCount():"+rowSet.getRowCount());
						
						if(rowSet.getRowCount()>0 ){
							while(rowSet.next()){
				            	invoiceVO.setArIfNo(rowSet.getString("ar_if_no"));
								invoiceVO.setArIfSerNo(rowSet.getString("ar_if_ser_no"));
								invoiceVO.setChgSeq(rowSet.getString("chg_seq"));
								invoiceVO.setInvXchRtDt(rowSet.getString("xch_rt_dt"));
								invoiceVO.setInvXchRt(exRateVOs[i].getInvXchRt());
								invoiceVO.setUpdUsrId(userId);
								
								count1 = dbDao.modifyARInvoiceExRate(invoiceVO);
								count2 = dbDao.modifyARInvoiceExRateMain(invoiceVO);
								
				            }
						}
						if(exRateVOs[i].getChgCurrCd().equals("USD")){					
							rowSet = dbDao.searchUSDExchangeRateList(exRateVo);	
							if(rowSet.getRowCount()>0 ){
								while(rowSet.next()){
					            	invoiceVO.setArIfNo(rowSet.getString("ar_if_no"));
									invoiceVO.setUsdXchRt(exRateVOs[i].getInvXchRt());		
									invoiceVO.setUpdUsrId(userId);
									
									count3 = dbDao.modifyUSDExrateMain(invoiceVO);
									
					            }
							}
							
							//2018.02.22 환율 입력 시 대리점비 재계산 로직 추가
							rowSet = dbDao.searchACMBkgNo(exRateVo);	
							if(rowSet.getRowCount()>0 ){
								while(rowSet.next()){
									bkgNos.add(rowSet.getString("bkg_no"));
					            }
							}
						}
					}
				}
				
				//2018.02.22 환율 입력 시 대리점비 재계산 로직 추가
				if(bkgNos != null && bkgNos.size() > 0){
					for(int i = 0; i < bkgNos.size(); i++){
						if(bkgNos.get(i) != null && !("").equals(bkgNos.get(i))){
							if(!uniqueBkgNos.contains(String.valueOf(bkgNos.get(i)))){
								uniqueBkgNos.add(bkgNos.get(i));
							}
						}
					}
				}

				//2018.02.22 환율 입력 시 대리점비 재계산 로직 추가
				if(uniqueBkgNos != null && uniqueBkgNos.size() > 0){
					for(int i = 0; i < uniqueBkgNos.size(); i++){
						command.addCalcBatchByINV(uniqueBkgNos.get(i), "INV_XCHRT");
					}
				}

				log.info("result:"+count1);
				log.info("result2:"+count2);
				log.info("result3:"+count3);	
				
			}else if(uiType.equals("B")){
				BookingARCreationBC bCommand = new BookingARCreationBCImpl();
				
				List<InvArIfNoVO> ifNos = bCommand.executeInterfaceBKGARInvoiceToINV(aRBkgInterfaceCreationVO);
				
				if(ifNos!= null && ifNos.size()>0){
					log.error("ifNos.size() = "+ifNos.size());
					
					bCommand.interfaceARInvoiceToERPAR(ifNos, "C");
				}
				
				count1 = 1;
				count2 = 1;
				count3 = 1;
				
			}else if(uiType.equals("L")){
				BookingARCreationBC bCommand = new BookingARCreationBCImpl();
				ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
				
				List<InvArIfNoVO> allIfNos = new ArrayList<InvArIfNoVO>();
				
				if(aRBkgInterfaceCreationVOs.size()>0){
					for(int i= 0; i< aRBkgInterfaceCreationVOs.size();i++ ){
						List<InvArIfNoVO> ifNos = bCommand.executeInterfaceBKGARInvoiceToINV(aRBkgInterfaceCreationVOs.get(i));
						
						if(ifNos!=null && ifNos.size()>0){
							log.error("ifNos.size() = "+ifNos.size());
							
							allIfNos.addAll(ifNos);
						}
						//Unmatch Rev 관련 2009-12-02
						if(aRBkgInterfaceCreationVOs.get(i).getBkgDiv()!=null&&aRBkgInterfaceCreationVOs.get(i).getBkgDiv().equals("U")){
							command.modifyBKGInterfaceFlag(aRBkgInterfaceCreationVOs.get(i).getBkgNo());
						}
					}
					
					if(allIfNos!= null && allIfNos.size()>0){
						log.error("allIfNos.size() = "+allIfNos.size());
						
						bCommand.interfaceARInvoiceToERPAR(allIfNos, "C");
					}
				}
				
				count1 = 1;
				count2 = 1;
				count3 = 1;
			
			//2010-03-22 FNS_INV_0094_02 Invoice Customer Change(Multi) 추가	
			}else if(uiType.equals("I")){
				
				ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
				BookingARCreationBC bCommand = new BookingARCreationBCImpl();

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
				
				//Good Data인 IfNo 모아서 ERP전송
				if(ifNos!= null && ifNos.size()>0){
					bCommand.interfaceARInvoiceToERPAR(ifNos, "C");
				}
				
				count1 = 1;
				count2 = 1;
				count3 = 1;
				
			}else if(uiType.equals("U")){
				
				ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
				BookingARCreationBC bCommand = new BookingARCreationBCImpl();
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
					com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.ExchangeRateVO exchangeRateVO = null;
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

										bCommand.modifyInvoiceExrateChg(exrateChgVO);
										
										//currPoint = dbDao2.searchCurrencyPoint(exrateTargetChgVOs.get(j).getCurrCd());
										
										//BigDecimal chgAmt = new BigDecimal(exrateTargetChgVOs.get(j).getChgAmt());
										//BigDecimal exRate = new BigDecimal(exchangeRateVO.getExRate());	
										//invTtlLoclAmt = invTtlLoclAmt.add(chgAmt.multiply(exRate).setScale(currPoint,BigDecimal.ROUND_HALF_UP));

									}
								}
								
								vVDCustomerVO.setCurr("USD");
								exchangeRateVO = utilCmd.searchExchangeRate(vVDCustomerVO);
								
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
					com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.ExchangeRateVO exchangeRateVO = null;
					ExrateMainVO exrateMainVO = new ExrateMainVO();
					ExrateChgVO exrateChgVO = new ExrateChgVO();

					String usd_xch_rt = "";

					if (exrateTargetMainVOs != null) {

						tot_cnt = exrateTargetMainVOs.size();

						for (int i = 0; i < exrateTargetMainVOs.size(); i++) {
							usd_xch_rt = utilCmd.searchAccountRate("USD", exrateTargetMainVOs.get(i).getLoclCurrCd(), !exrateTargetMainVOs.get(i).getSailDt().equals("")?exrateTargetMainVOs.get(i).getSailDt().substring(0, 6):"");
							
							log.debug("issFlg = "+exrateTargetMainVOs.get(i).getIssFlg());
							log.debug("clrFlg = "+exrateTargetMainVOs.get(i).getInvClrFlg());
							log.debug("otsSmryCd = "+exrateTargetMainVOs.get(i).getOtsSmryCd());
							log.debug("dmdtArInvIssFlg = "+exrateTargetMainVOs.get(i).getDmdtArInvIssFlg());
							
							if (
									(!exrateTargetMainVOs.get(i).getOtsSmryCd().equals("BL") && 
										(exrateTargetMainVOs.get(i).getIssFlg().equals("N") || 
											((exrateTargetMainVOs.get(i).getRevSrcCd().equals("DM")||exrateTargetMainVOs.get(i).getRevSrcCd().equals("DT")) && exrateTargetMainVOs.get(i).getDmdtArInvIssFlg().equals("N"))||
											exrateTargetMainVOs.get(i).getInvClrFlg().equals("Y")
										)
									) 
									|| exrateTargetMainVOs.get(i).getOtsSmryCd().equals("BL")
								){
								
								if (!usd_xch_rt.equals("")) {
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

											bCommand.modifyInvoiceExrateChg(exrateChgVO);
											
											//currPoint = dbDao2.searchCurrencyPoint(exrateTargetChgVOs.get(j).getCurrCd());
											
											//BigDecimal chgAmt = new BigDecimal(exrateTargetChgVOs.get(j).getChgAmt());
											//BigDecimal exRate = new BigDecimal(exchangeRateVO.getExRate());	
											//invTtlLoclAmt = invTtlLoclAmt.add(chgAmt.multiply(exRate).setScale(currPoint,BigDecimal.ROUND_HALF_UP));
								
										}
									}
									
									vVDCustomerVO.setCurr("USD");
									exchangeRateVO = utilCmd.searchExchangeRate(vVDCustomerVO);
									
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
										good_cnt = good_cnt + 1;
										invArIfNoVO = new InvArIfNoVO();
										invArIfNoVO.setIfNo(newIfNo);
										ifNos.add(invArIfNoVO);
										exceclIfNos.add(invArIfNoVO);
									}else{
										no_good_cnt = no_good_cnt + 1;
									}

								} else {
									// 경리 환율이 없는 경우 No Good Count 증가
									no_good_cnt = no_good_cnt + 1;
								}

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
									no_good_cnt = no_good_cnt + 1;
								}
							}
						}
					}
					// VVD 조건인 경우
				} else if (runOpt.equals("V")) {
					if (exrateInputVOs != null) {
						// VVD 갯수
						for (int k = 0; k < exrateInputVOs.size(); k++) {
							ExrateInputVO exInputVO = new ExrateInputVO();

							exInputVO.setOfcCd(exrateInputVOs.get(k).getOfcCd());
							exInputVO.setVvd(exrateInputVOs.get(k).getVvd());
							exInputVO.setIoBndCd(exrateInputVOs.get(k).getIoBndCd());
							exInputVO.setRunOpt(exrateInputVOs.get(k).getRunOpt());
							//exInputVO.setBlSrcNo(exrateInputVOs.get(k).getBlSrcNo());

							exrateTargetMainVOs = command.searchInvoiceForExrateList(exInputVO);

							VVDCustomerVO vVDCustomerVO = new VVDCustomerVO();
							com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.ExchangeRateVO exchangeRateVO = null;
							ExrateMainVO exrateMainVO = new ExrateMainVO();
							ExrateChgVO exrateChgVO = new ExrateChgVO();

							String usd_xch_rt = "";

							if (exrateTargetMainVOs != null) {

								tot_cnt = tot_cnt + exrateTargetMainVOs.size();

								for (int i = 0; i < exrateTargetMainVOs.size(); i++) {
									usd_xch_rt = utilCmd.searchAccountRate("USD", exrateTargetMainVOs.get(i).getLoclCurrCd(), !exrateTargetMainVOs.get(i).getSailDt().equals("")?exrateTargetMainVOs.get(i).getSailDt().substring(0, 6):"");

									log.debug("issFlg = "+exrateTargetMainVOs.get(i).getIssFlg());
									log.debug("clrFlg = "+exrateTargetMainVOs.get(i).getInvClrFlg());
									log.debug("otsSmryCd = "+exrateTargetMainVOs.get(i).getOtsSmryCd());
									log.debug("dmdtArInvIssFlg = "+exrateTargetMainVOs.get(i).getDmdtArInvIssFlg());
									
									if (
											(!exrateTargetMainVOs.get(i).getOtsSmryCd().equals("BL") && 
												(exrateTargetMainVOs.get(i).getIssFlg().equals("N") || 
													((exrateTargetMainVOs.get(i).getRevSrcCd().equals("DM")||exrateTargetMainVOs.get(i).getRevSrcCd().equals("DT")) && exrateTargetMainVOs.get(i).getDmdtArInvIssFlg().equals("N"))||
													exrateTargetMainVOs.get(i).getInvClrFlg().equals("Y")
												)
											) 
											|| exrateTargetMainVOs.get(i).getOtsSmryCd().equals("BL")
										){
										if (!usd_xch_rt.equals("")) {
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

													bCommand.modifyInvoiceExrateChg(exrateChgVO);
													
													//currPoint = dbDao2.searchCurrencyPoint(exrateTargetChgVOs.get(j).getCurrCd());
													
													//BigDecimal chgAmt = new BigDecimal(exrateTargetChgVOs.get(j).getChgAmt());
													//BigDecimal exRate = new BigDecimal(exchangeRateVO.getExRate());	
													//invTtlLoclAmt = invTtlLoclAmt.add(chgAmt.multiply(exRate).setScale(currPoint,BigDecimal.ROUND_HALF_UP));
												}
											}
											
											vVDCustomerVO.setCurr("USD");
											exchangeRateVO = utilCmd.searchExchangeRate(vVDCustomerVO);
											
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
												good_cnt = good_cnt + 1;
												invArIfNoVO = new InvArIfNoVO();
												invArIfNoVO.setIfNo(newIfNo);
												ifNos.add(invArIfNoVO);
												exceclIfNos.add(invArIfNoVO);
											}else{
												no_good_cnt = no_good_cnt + 1;
											}

										} else {
											// 경리 환율이 없는 경우 No Good Count 증가
											no_good_cnt = no_good_cnt + 1;
										}

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
											no_good_cnt = no_good_cnt + 1;
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
							ExrateInputVO exInputVO = new ExrateInputVO();

							exInputVO.setOfcCd(exrateInputVOs.get(k).getOfcCd());
							exInputVO.setRunOpt(exrateInputVOs.get(k).getRunOpt());
							exInputVO.setBlSrcNo(exrateInputVOs.get(k).getBlSrcNo());

							exrateTargetMainVOs = command.searchInvoiceForExrateList(exInputVO);

							VVDCustomerVO vVDCustomerVO = new VVDCustomerVO();
							com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.ExchangeRateVO exchangeRateVO = null;
							ExrateMainVO exrateMainVO = new ExrateMainVO();
							ExrateChgVO exrateChgVO = new ExrateChgVO();

							String usd_xch_rt = "";

							if (exrateTargetMainVOs != null) {

								tot_cnt = tot_cnt + exrateTargetMainVOs.size();

								for (int i = 0; i < exrateTargetMainVOs.size(); i++) {
									usd_xch_rt = utilCmd.searchAccountRate("USD", exrateTargetMainVOs.get(i).getLoclCurrCd(), !exrateTargetMainVOs.get(i).getSailDt().equals("")?exrateTargetMainVOs.get(i).getSailDt().substring(0, 6):"");

									log.debug("issFlg = "+exrateTargetMainVOs.get(i).getIssFlg());
									log.debug("clrFlg = "+exrateTargetMainVOs.get(i).getInvClrFlg());
									log.debug("otsSmryCd = "+exrateTargetMainVOs.get(i).getOtsSmryCd());
									log.debug("dmdtArInvIssFlg = "+exrateTargetMainVOs.get(i).getDmdtArInvIssFlg());
									
									// Not Issue Data이거나  OtsSmryCD가 BL이 아니고 DmdtArInvIssFlg가 N인 경우
									if (
											(!exrateTargetMainVOs.get(i).getOtsSmryCd().equals("BL") && 
												(exrateTargetMainVOs.get(i).getIssFlg().equals("N") || 
													((exrateTargetMainVOs.get(i).getRevSrcCd().equals("DM")||exrateTargetMainVOs.get(i).getRevSrcCd().equals("DT")) && exrateTargetMainVOs.get(i).getDmdtArInvIssFlg().equals("N")) ||
													exrateTargetMainVOs.get(i).getInvClrFlg().equals("Y")
												)
											) 
											|| exrateTargetMainVOs.get(i).getOtsSmryCd().equals("BL")
										){
										if (!usd_xch_rt.equals("")) {
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

													bCommand.modifyInvoiceExrateChg(exrateChgVO);
													
													//currPoint = dbDao2.searchCurrencyPoint(exrateTargetChgVOs.get(j).getCurrCd());
													
													//BigDecimal chgAmt = new BigDecimal(exrateTargetChgVOs.get(j).getChgAmt());
													//BigDecimal exRate = new BigDecimal(exchangeRateVO.getExRate());	
													//invTtlLoclAmt = invTtlLoclAmt.add(chgAmt.multiply(exRate).setScale(currPoint,BigDecimal.ROUND_HALF_UP));

												}
											}
											
											vVDCustomerVO.setCurr("USD");
											exchangeRateVO = utilCmd.searchExchangeRate(vVDCustomerVO);
											
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
												good_cnt = good_cnt + 1;
												invArIfNoVO = new InvArIfNoVO();
												invArIfNoVO.setIfNo(newIfNo);
												ifNos.add(invArIfNoVO);
												exceclIfNos.add(invArIfNoVO);
											}else{
												no_good_cnt = no_good_cnt + 1;
											}

										} else {
											// 경리 환율이 없는 경우 No Good Count 증가
											no_good_cnt = no_good_cnt + 1;
										}

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
											no_good_cnt = no_good_cnt + 1;
										}
									}
								}
							}
						}
					}
				} else if (runOpt.equals("O")) {
					log.debug("======================================== runOpt = O start ===============================================");
					log.debug("runOpt 2012.04.26 => " + runOpt);
					exrateTargetMainVOs	= command.searchInvoiceForExrateList(exrateInputVO);
					
					String cancelIfNo			= "";
					String invDeltDivCd		= "";
					String maxIfNoStatus	= "";
					
					if (exrateTargetMainVOs != null) {
						
						tot_cnt			= exrateTargetMainVOs.size();
						
						good_cnt		= 0;
						no_good_cnt	= 0;
						
						for (int i = 0; i < tot_cnt; i++) {
							
							/*****
							처음에 2012/04/17 17:47:24 에 한번 환율일괄업데이트를 실행하고
							두번째로 2012/04/17 17:51:08 한번 더 실행함
							처음 실행 시 일단 CANCEL 먼저 생성하고 BKG I/F 를 했지만 이미 BKG I/F 쪽에 다른 데이터들이 적체되어 있어서 실행되지 않고 있다가
							두번째 실행 시 일단 CANCEL 먼저 생성하고 BKG I/F 를 한 것임
							최종 BKG I/F 는 마지막 1건만 처리됨
							결국 중간에 CANCEL 이 2번 처리된것이고 두번째 데이터가 바라본 MASTER 가 바로 이전에 생성된 I/F NO 로 처리가 된 이유도 바로 이것 때문입니다.
							즉, ON BOARD DATE 옵션으로 환율일괄업데이트를 하는 경우에 일단 MAX(I/F NO) 가 개별환율이 0 인것을 찾은 다음 일단 CANCEL 처리하고 BKG I/F 를 하기 때문입니다.
							RUN 버튼을 누를때마다 그리고 그 시점에 BKG I/F 가 바로 되지 않고 대기중이라면 이번 경우처럼 RUN 버튼 누른 횟수만큼 CANCEL 데이터가 생긴다는 것입니다.
							이를 방지하기 위해서 MAX(I/F NO) 의 STATUS 를 한번 더 체크를 해서 X 즉 CANCEL 상태라면 (누군가가 선 작업을 통해서 기 CANCEL 을 했다고 판단) 더 이상 CANCEL 하지 말고 그냥 BKG I/F 만 하도록 변경함
							*****/
							
							invDeltDivCd	= exrateTargetMainVOs.get(i).getInvDeltDivCd();
							log.debug("invDeltDivCd 2012.04.26 => " + invDeltDivCd);
							if(("X").equals(invDeltDivCd)){

								maxIfNoStatus = "X";
                                
							}else{

								int cnt	= dbDao2.checkDecWHF(exrateTargetMainVOs.get(i).getArIfNo());
	
								// Dec WHF 존재하는 경우
								if(cnt > 0){
									cancelIfNo	= bCommand.createMaxIFCancel(exrateTargetMainVOs.get(i).getArIfNo(), "Y", userId, "N");
								// Dec WHF 존재하지 않는 경우
								}else{
									cancelIfNo	= bCommand.createMaxIFCancel(exrateTargetMainVOs.get(i).getArIfNo(), "N", userId, "N");
								}
							}
							log.debug("maxIfNoStatus 2012.04.26 => " + maxIfNoStatus);
							if(cancelIfNo != null && !cancelIfNo.equals("")){
								// INV, CLR TYPE 인 경우 AUTO SYS CLEAR
								dbDao2.modifySysClearFlag(exrateTargetMainVOs.get(i).getArIfNo(), cancelIfNo, userId);
								
								// B/L TYPE 인 경우 AUTO SYS CLEAR
								dbDao2.modifySysClearFlagForBLType(exrateTargetMainVOs.get(i).getArIfNo(), cancelIfNo, userId);
								
								// CANCEL DATA ERP 전송
								invArIfNoVO.setIfNo(cancelIfNo);
								ifNos.add(invArIfNoVO);
								bCommand.interfaceARInvoiceToERPAR(ifNos, "C");
								
								ARBkgInterfaceCreationVO bkgIfVO = new ARBkgInterfaceCreationVO();
								bkgIfVO.setBkgNo(exrateTargetMainVOs.get(i).getBkgNo());
								bkgIfVO.setBkgSeq("");
								bkgIfVO.setManDivInd("M");
								bkgIfVO.setUserId(userId);					
								
								// 매뉴얼 BKG I/F
								bCommand.executeInterfaceBKGARInvoiceToINV(bkgIfVO);
								
								// good count add
								good_cnt++;
								
							}else if(("X").equals(maxIfNoStatus)){						 
								ARBkgInterfaceCreationVO bkgIfVO = new ARBkgInterfaceCreationVO();
								bkgIfVO.setBkgNo(exrateTargetMainVOs.get(i).getBkgNo());
								bkgIfVO.setBkgSeq("");
								bkgIfVO.setManDivInd("M");
								bkgIfVO.setUserId(userId);				
								
								// 매뉴얼 BKG I/F
								bCommand.executeInterfaceBKGARInvoiceToINV(bkgIfVO);
								
								// good count add
								good_cnt++;

							}else{
								// no good count add
								no_good_cnt++;
							}
						}
					}
					
					count1 = tot_cnt;
					count2 = good_cnt;
					count3 = no_good_cnt;
					
					log.debug("tot_cnt:"+tot_cnt);
					log.debug("good_cnt:"+good_cnt);
					log.debug("no_good_cnt:"+no_good_cnt);
					
					ExRateCountVO exRateCountVO = new ExRateCountVO();
					exRateCountVO.setCount1(String.valueOf(count1));
					exRateCountVO.setCount2(String.valueOf(count2));
					exRateCountVO.setCount3(String.valueOf(count3));
					exRateCountVOs.add(exRateCountVO);
					
					log.debug("======================================== runOpt = O end ===============================================");
				
				} else if (runOpt.equals("P")) {

					exrateTargetMainVOs = command.searchInvoiceForExrateList(exrateInputVO);

					VVDCustomerVO vVDCustomerVO = new VVDCustomerVO();
					com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.ExchangeRateVO exchangeRateVO = null;
					ExrateMainVO exrateMainVO = new ExrateMainVO();
					ExrateChgVO exrateChgVO = new ExrateChgVO();

					if (exrateTargetMainVOs != null) {

						tot_cnt = exrateTargetMainVOs.size();

						for (int i = 0; i < exrateTargetMainVOs.size(); i++) {
							
							vvd = exrateTargetMainVOs.get(i).getVslCd()+ exrateTargetMainVOs.get(i).getSkdVoyNo()+exrateTargetMainVOs.get(i).getSkdDirCd();
							port = 	exrateTargetMainVOs.get(i).getIoBndCd().equals("O")?exrateTargetMainVOs.get(i).getPolCd():exrateTargetMainVOs.get(i).getPodCd();
							
							saDate = utilCmd.searchSADate(vvd , port, exrateTargetMainVOs.get(i).getIoBndCd());

							List<ExrateTargetChgVO> exrateTargetChgVOs = null;

							exrateTargetChgVOs = command.searchInvoiceChgForExrateList(exrateTargetMainVOs.get(i).getArIfNo());

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

									bCommand.modifyInvoiceExrateChg(exrateChgVO);

								}
							}
							
							vVDCustomerVO.setCurr("USD");

							exchangeRateVO = utilCmd.searchExchangeRate(vVDCustomerVO);
                                                             
                            /* 기존은 정말로 GOOD 처리된것과 NO GOOD 처리된것을 작업 완료 후 화면에 보여주고 있지만 */
                            /* PERIOD 환율 또는 CHINA 환율이 존재하는 경우에 한해서 GOOD CNT 를 증가하고 작업 완료 후 화면에 보여주도록 하자 !!! */
                            /* 예 : exchangeRateVO.getExRate 가 0 이 아니고, 존재하면 GOOD CNT 를 증가하고,
                                    이 외는 NO GOOD CNT 를 증가하는것을 이부분에 추가하자 */

							
							exrateMainVO.setXchRtDt(exchangeRateVO.getExRateDate());
							exrateMainVO.setXchRtUsdTpCd(exchangeRateVO.getUsdExrateType());
							exrateMainVO.setXchRtN3rdTpCd(exchangeRateVO.getThirdExrateType());
							exrateMainVO.setObrdDt(exchangeRateVO.getCngIndivCd().equals("B") ? exchangeRateVO.getExRateDate() : "");
							exrateMainVO.setUsdXchRt(exchangeRateVO.getExRate());
							
							
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
								invArIfNoVO = new InvArIfNoVO();
								invArIfNoVO.setIfNo(newIfNo);
								ifNos.add(invArIfNoVO);
								exceclIfNos.add(invArIfNoVO);
							}
							good_cnt++;
						}  // end for
					}			
					
					
					count1 = tot_cnt;
					count2 = good_cnt;
					count3 = no_good_cnt;
					
					log.debug("tot_cnt:"+tot_cnt);
					log.debug("good_cnt:"+good_cnt);
					log.debug("no_good_cnt:"+no_good_cnt);
					
					ExRateCountVO exRateCountVO = new ExRateCountVO();
					exRateCountVO.setCount1(String.valueOf(count1));
					exRateCountVO.setCount2(String.valueOf(count2));
					exRateCountVO.setCount3(String.valueOf(count3));
					exRateCountVOs.add(exRateCountVO);
					
				}
				
				if(!("O").equals(runOpt) && !("P").equals(runOpt)){  
					//Good Data인 IfNo 모아서 ERP전송
					if(ifNos!= null && ifNos.size()>0){
						bCommand.interfaceARInvoiceToERPAR(ifNos, "C");
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
				}
			}
			log.debug("======================================== start count show logic ===============================================");
			if(!("O").equals(runOpt) && !("P").equals(runOpt)){
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
			}
			log.debug("exRateCountVOs.size():"+exRateCountVOs.size());
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