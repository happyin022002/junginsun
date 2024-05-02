/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInvoiceCorrectionBackEndBCImpl.java
*@FileTitle : Unmatched Revenue VVD Inquiry BackEndJob
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.10.22 정휘택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBC;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration.InvoiceIssueDBDAO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.BLMaxIfNoVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.CustomerListForIssueVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.GeneralInvoiceVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvIssVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.INVMainInfoForIssueVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.INVChargeInfoForIssueVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;

/**
 * AccountReceivableInvoiceMgt Business Logic Basic Command implementation<br>
 * - AccountReceivableInvoiceMgt 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Jung Hwi Taek
 * @see InvoiceIssueDBDAO 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class InvoiceIssueBackEndJob extends BackEndCommandSupport {
	
	private static final long serialVersionUID = -8569053557386320221L;
	
	private transient InvoiceIssueDBDAO dbDao = null;
	//private transient InvoiceIssueEAIDAO eaiDao = null;
	//private BookingARCreationDBDAO dbDao2;

	GeneralInvoiceVO genInvVo = null;
	CustomerListForIssueVO[] customerListForIssueVOs = null;
	
	private String userId = "";
	
	public void setGenInvVo(GeneralInvoiceVO genInvVo) {
		this.genInvVo = genInvVo;
	}
	
	public void setCustomerListForIssueVOs(CustomerListForIssueVO[] customerListForIssueVOs) {
		this.customerListForIssueVOs = customerListForIssueVOs;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * FNS_INV_0034_01 : Paper Issue, Goto Send <br>
	 * 구주지역, 서남아 일부지역, 북중국지역의 Invoice 를 발행함.(BackEndJob) <br>
	 * 
	 * @return String 
	 * @exception EventException
	 */
	@Override
	public String doStart() throws Exception {
		this.dbDao = new InvoiceIssueDBDAO();
		//this.dbDao2 = new BookingARCreationDBDAO();

		InvoiceIssueBC command = new InvoiceIssueBCImpl();
		BookingARCreationBC command2 = new BookingARCreationBCImpl();
		//List<IssueTargetVO> list2 = new ArrayList<IssueTargetVO>();			
		//String blNos = "";
		//INVCommonUtil utilCmd = new INVCommonUtil();
		
		String[] rtnValue = {"",""};
		StringBuffer invNos = new StringBuffer("");		
		String resultMsg = "";
		int cnt = 0;
		String blNos = "";
		
		GeneralInvoiceVO paramGenInvVO = new GeneralInvoiceVO();
		
		
		try {
			
			if (customerListForIssueVOs != null && customerListForIssueVOs.length > 0 ) {
				
				List<INVMainInfoForIssueVO> iNVMainInfoForIssueVOs = null;	
				List<INVMainInfoForIssueVO> targetIssueVOs = new ArrayList<INVMainInfoForIssueVO>();
				
				List<INVChargeInfoForIssueVO> chrgVOs = null;
				List<INVChargeInfoForIssueVO> targetChrgVOs = new ArrayList<INVChargeInfoForIssueVO>();
				String chkTax = null;
				
				for(int i=0; i < customerListForIssueVOs.length; i++ ) { 
					
					if("Y".equals(customerListForIssueVOs[i].getTargetYn())) { 
						
						cnt++;
						
						ObjectCloner.build(genInvVo, paramGenInvVO);
						
						//blNos = blNos + customerListForIssueVOs[i].getBlSrcNo() + (i == customerListForIssueVOs.length -1 ? "" : ", ");
						
					
						paramGenInvVO.setActCustCntCd(customerListForIssueVOs[i].getActCustCntCd());
						paramGenInvVO.setActCustSeq(customerListForIssueVOs[i].getActCustSeq());
						paramGenInvVO.setDfltInvCurrDivCd(customerListForIssueVOs[i].getDfltInvCurrDivCd());
						paramGenInvVO.setBlSrcNo(customerListForIssueVOs[i].getBlSrcNo());
						paramGenInvVO.setTargetYn(customerListForIssueVOs[i].getTargetYn());
						paramGenInvVO.setUserId(userId);
						
						iNVMainInfoForIssueVOs = dbDao.searchINVMainInfoForIssue(paramGenInvVO);
						
						if(iNVMainInfoForIssueVOs == null || iNVMainInfoForIssueVOs.size() == 0) {
							resultMsg =new ErrorHandler("INV00097", new String[]{}).getUserMessage();  //There is no data for issue.
							throw new EventException(resultMsg);
						}
						
						
						for(int j=0; j < iNVMainInfoForIssueVOs.size(); j++ ) {
							
							blNos = blNos.concat("'" + iNVMainInfoForIssueVOs.get(j).getBlSrcNo() + "',");
							
							//targetIssueVOs
							targetIssueVOs.add(iNVMainInfoForIssueVOs.get(j));
							
							if(!"MTH".equals(iNVMainInfoForIssueVOs.get(j).getRevTpSrcCd()) &&  !"MTP".equals(iNVMainInfoForIssueVOs.get(j).getRevTpSrcCd()) ) {
								if(  iNVMainInfoForIssueVOs.get(j).getActCustCntCd().equals(iNVMainInfoForIssueVOs.get(j).getRepCustCntCd()) 
								  && iNVMainInfoForIssueVOs.get(j).getActCustSeq().equals(iNVMainInfoForIssueVOs.get(j).getRepCustSeq())		
								) {
									resultMsg = "["+paramGenInvVO.getBlSrcNo()+"]'s customer is not actual customer.";
									throw new EventException(resultMsg);
								}
							}
							
							chrgVOs = dbDao.searchINVChargeInfoForIssue(iNVMainInfoForIssueVOs.get(j).getArIfNo());
							
							if(chrgVOs == null || chrgVOs.size() == 0 ) {
								resultMsg =new ErrorHandler("INV00097", new String[]{}).getUserMessage();  //There is no data for issue.
								throw new EventException(resultMsg);
							}
							
							chkTax = dbDao.searchValidTaxChgCurr(iNVMainInfoForIssueVOs.get(j).getArIfNo());
							if(chkTax != null && chkTax.equals("FAIL") ) {
								resultMsg = "In this B/L["+paramGenInvVO.getBlSrcNo()+"], tax amount has not calculated in local currency due to lack of Ex.rate.\nSo please register proper Ex.rate and issue again.";
								throw new EventException(resultMsg);
							}
							
							for(int k=0; k < chrgVOs.size(); k++) {
								chrgVOs.get(k).setUserId(userId);
								if(!paramGenInvVO.getLoclCurrCd().equals(iNVMainInfoForIssueVOs.get(j).getBfrInvCurrCd())) {
									//ExchangeRateVO exchangeRateVO = new ExchangeRateVO();
									//VVDCustomerVO vVDCustomerVO = new VVDCustomerVO();
									
									//String vvd = iNVMainInfoForIssueVOs.get(j).getVslCd()+ iNVMainInfoForIssueVOs.get(j).getSkdVoyNo()+iNVMainInfoForIssueVOs.get(j).getSkdDirCd();
									//String port = 	iNVMainInfoForIssueVOs.get(j).getIoBndCd().equals("O")?iNVMainInfoForIssueVOs.get(j).getPolCd():iNVMainInfoForIssueVOs.get(j).getPodCd();
									
									//String saDate = utilCmd.searchSADate(vvd , port, iNVMainInfoForIssueVOs.get(j).getIoBndCd());
									
									/*vVDCustomerVO.setInvCntryCd(iNVMainInfoForIssueVOs.get(j).getInvCustCntCd());
									vVDCustomerVO.setInvCustCd(iNVMainInfoForIssueVOs.get(j).getInvCustSeq());
									vVDCustomerVO.setOfcCd(iNVMainInfoForIssueVOs.get(j).getArOfcCd());
									
									String invCurrCd = "";
									invCurrCd = JSPUtil.getNull(paramGenInvVO.getInvCurrCd()).equals("") ? iNVMainInfoForIssueVOs.get(j).getInvCurrCd() : paramGenInvVO.getInvCurrCd();
									vVDCustomerVO.setLclCurr(invCurrCd);					//**
									
									vVDCustomerVO.setBnd(iNVMainInfoForIssueVOs.get(j).getIoBndCd());
									vVDCustomerVO.setVsl(iNVMainInfoForIssueVOs.get(j).getVslCd());
									vVDCustomerVO.setVoy(iNVMainInfoForIssueVOs.get(j).getSkdVoyNo());
									vVDCustomerVO.setDep(iNVMainInfoForIssueVOs.get(j).getSkdDirCd());
									vVDCustomerVO.setPol(iNVMainInfoForIssueVOs.get(j).getPolCd());
									vVDCustomerVO.setPod(iNVMainInfoForIssueVOs.get(j).getPodCd());
									//vVDCustomerVO.setSaDt(!saDate.equals("")?saDate.replace("-", ""):saDate);
									vVDCustomerVO.setSaDt(iNVMainInfoForIssueVOs.get(j).getSailArrDt());
									
									vVDCustomerVO.setBkgNo(iNVMainInfoForIssueVOs.get(j).getBkgNo());
									vVDCustomerVO.setSvcScp(iNVMainInfoForIssueVOs.get(j).getSvcScpCd());
									
									vVDCustomerVO.setCurr(chrgVOs.get(k).getCurrCd());						// **
									
									String issXchRt = "";
									if (!chrgVOs.get(k).getCurrCd().equals(invCurrCd)) {
										if (iNVMainInfoForIssueVOs.get(j).getInvDeltDivCd().equals("X")) {
											issXchRt = dbDao.searchPreInvIssXchRt(chrgVOs.get(k));
										} else {
											exchangeRateVO = utilCmd.searchExchangeRate(vVDCustomerVO);
											issXchRt = exchangeRateVO.getExRate();
										}
									} else {
										issXchRt = "1";
									}
									
									//exchangeRateVO = utilCmd.searchExchangeRate(vVDCustomerVO);
									*/
									chrgVOs.get(k).setIssXchRt(chrgVOs.get(k).getUsdXchRt());
									
								} else {
									chrgVOs.get(k).setIssXchRt(chrgVOs.get(k).getInvXchRt());
								}
								
								targetChrgVOs.add(chrgVOs.get(k));
								
							}  // end of for k 
						}	//end of for j 
						
					}	//end of if (targetYN) 	
				
				}	//end of for i
				
				blNos = blNos + "'XXX'";
				
				if(cnt == 0) {
					resultMsg =new ErrorHandler("INV00097", new String[]{}).getUserMessage();  //There is no data for issue.
					throw new EventException(resultMsg);
				}
				
				//환율체크
				for(int k=0; k < targetChrgVOs.size(); k++) {
					if(    targetChrgVOs.get(k).getInvXchRt().equals("") || targetChrgVOs.get(k).getInvXchRt().equals("0") 
						|| targetChrgVOs.get(k).getIssXchRt().equals("") || targetChrgVOs.get(k).getIssXchRt().equals("0") ) {
						
						log.debug("curr_cd:::" + targetChrgVOs.get(k).getCurrCd() );
						log.debug("targetChrgVOs.get(k).getInvXchRt():::" + targetChrgVOs.get(k).getInvXchRt());
						log.debug("targetChrgVOs.get(k).getIssXchRt():::" + targetChrgVOs.get(k).getIssXchRt());
						
						resultMsg = "No exchange rate exists in ["+targetChrgVOs.get(k).getBlSrcNo()+"]'s some charges.";
						throw new EventException(resultMsg);
					}
				}
				
				List<BLMaxIfNoVO> splitBl = dbDao.searchSplitBLList(genInvVo.getArOfcCd2(), blNos);
				
				int blCnt = 0;
				
				if(splitBl.size() > 0) blCnt = Integer.parseInt(splitBl.get(0).getBlCnt());
				
				if(splitBl.size() == 1 && blCnt == 1)	{
					resultMsg = "GOTOSPLIT|" + splitBl.get(0).getMaxArIfNo() + "|" + splitBl.get(0).getInvDeltDivCd();
					throw new EventException(resultMsg);
				}else if((splitBl.size() == 1 && blCnt > 1) || (splitBl.size() > 1)) {
					String blNoList = "";
					
					for(int t = 0; t < splitBl.size(); t++){
						blNoList = blNoList.concat(splitBl.get(t).getBlSrcNo());
						if(t < splitBl.size() - 1) blNoList = blNoList + ", ";
					}
					
					resultMsg = "The following B/Ls have already been split between multiple payers " + blNoList + "."
							  + "\n\nFor each of these B/Ls please use \"Invoice Split Before Invoice Issue\" UI to manually create credit notes and new invoices. " 
							  + "Please refer to Business Process Procedures as to how to manage the split.";
					throw new EventException(resultMsg);
				}
				
				/*
				invoice no 채번	searchInvoiceMaxSequence			
				ISSUE TEMP 테이블 INSERT	addInvoiceIssueFilter
				INV_AR_ISS 테이블 INSERT	addInvoiceIssue
				INV_AR_CHG 테이블 UPDATE	modifyInvoiceCharge
				INV_AR_ISS_DTL 테이블 INSERT	addInvoiceIssueDetail			
				INV_AR_MN 테이블 UPDATE (ISSUE FLAG, CLEAR FLAG, INV REF NO, TEU, FEU)	modifyInvoiceMainByBkgNo			
				INV_AR_MN 테이블 UPDATE(DUE DATE 재계산)	modifyDuedateInvoiceMainByIfNo			
				INV_AR_CNTR 테이블 DELETE	removeInvoiceContainer			
				INV_AR_CNTR 테이블 INSERT	addInvoiceContainer			
				ISSUE TEMP 테이블 DELETE	removeInvoiceIssueTemp
				*/
				
				log.debug("InvoiceIssueBackEndJob========================>>>>>>>>>>>>>>>start");			
				InvIssVO invIssVO = new InvIssVO();
				
				//Invoice issue 실행
				invIssVO = command.searchInvoiceMaxSequence(genInvVo, targetIssueVOs);
				
				invIssVO.setInvCurrCd(paramGenInvVO.getInvCurrCd());
				
				if(invIssVO.getInvSeq().equals("0")){
					throw new EventException(new ErrorHandler("COM12240").getMessage());
				}
				log.debug("InvoiceIssueBackEndJob========================>>>>>>>>>>>>>>>1");
				//INV_AR_CHG 테이블 UPDATE
				command2.modifyInvoiceCharge(invIssVO);
				log.debug("InvoiceIssueBackEndJob========================>>>>>>>>>>>>>>>2");
				//INV_AR_ISS_DTL 테이블 INSERT
				command.addInvoiceIssueDetail(invIssVO);
				log.debug("InvoiceIssueBackEndJob========================>>>>>>>>>>>>>>>3");
				
				//Add for checking issued 2016.09.12
				String issIfNo = dbDao.searchIssuedIfNo(invIssVO.getWrkNo());
				
				if(!("").equals(issIfNo)){
					resultMsg = "I/F No [" + issIfNo + "] was already issued or sys cleared. Please check again.";
					throw new EventException(resultMsg);
				}
				
				//INV_AR_MN 테이블 UPDATE
				command2.modifyInvoiceMain(invIssVO);
				log.debug("InvoiceIssueBackEndJob========================>>>>>>>>>>>>>>>4");
				//INV_AR_CHG 테이블 UPDATE 2014.11.26
				dbDao.modifyInvoiceCharge(targetChrgVOs);
				log.debug("InvoiceIssueBackEndJob========================>>>>>>>>>>>>>>>5");
				
				//inv_no 조회, ISSUE TEMP 테이블 DELETE 한다.
				List<String> list = command.removeInvoiceIssueFilter(invIssVO);						

				for (int i = 0; i < list.size(); i++) {
					invNos.append(list.get(i)).append("|");
				}
								
				resultMsg = "SUCCESS";
				log.debug("invNos========================>>>>>>>>>>>>>>>"+invNos);
				log.debug("InvoiceIssueBackEndJob========================>>>>>>>>>>>>>>>end");
				rtnValue[0] = invNos.toString();
				rtnValue[1] = resultMsg;
				
				//Add for checking Duplication invoice no 2016.07.12
				for(int p = 0; p < targetIssueVOs.size(); p++){
					String dupBlNo = dbDao.searchDupInvoiceNo(targetIssueVOs.get(p).getArIfNo());
					
					if(!("").equals(dupBlNo)){
						resultMsg = "B/L No [" + dupBlNo + "] was already issued. Please check again.";
						throw new EventException(resultMsg);
					}
				}
			}
			
			
			return invNos.toString();
			
			

		} catch (EventException de) {
			log.error("err2=============>> " + de.toString(), de);
			throw new EventException(de.getMessage(),de);
		} catch (Exception de) {
			log.error("err3=============>> " + de.toString(), de);
			throw new EventException(de.getMessage(),de);
		}
	}
	
	/*
	public String doStart() throws Exception {
		//log.info("########## event.getGenInvVo() BackEndBC : "+genInvVo.getVvd());
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
		BookingARCreationBC command2 = new BookingARCreationBCImpl();
		List<IssueTargetVO> list2 = new ArrayList<IssueTargetVO>();
		String blNos = "";
		String invNos = "";
		
		try {
			
			// Issue 비발행 대상을 조회한다
			List<String> blList = command.searchErrorBLNumberList(genInvVo);
			for (int i = 0; i < blList.size(); i++) {
				blNos = blNos + blList.get(i) + (i == blList.size() -1 ? "" : ", ");
			}
			
			log.info("\n########## Issue 비발행 대상  blNos : "+blNos);
			
		    if (!blNos.equals("") && (!genInvVo.getVvd().equals("")||!genInvVo.getCustCntCd().equals(""))) {
		    	
		    	return "&"+blNos;
		    	
		    } else {			
			
				// Issue 대상을 조회한다
				List<IssueTargetVO> list = command.searchTargetBLForIssue(genInvVo);
				
				InvIssueVO invIssueVO = null;
	
				// 조회된 Issue 대상만큼 Looping 
				for (int ii = 0; ii < list.size(); ii++) {
					
					log.info("\n########## list.get("+String.valueOf(ii)+").getArIfNo()_1 : "+list.get(ii).getArIfNo());
					
					list2 = command.issueGeneralInvoice(list.get(ii), genInvVo, userId);
					
					log.info("\n########## list.size() : "+list.size());
					log.info("\n########## list2.size() : "+list2.size());
					
					if (list2.size() > 0) {
						invNos = invNos + list2.get(0).getInvNo() + "|";
						
						log.info("\n########## invNos : "+invNos);
						
						// 반환된 업데이트 대상만큼 Looping
						for (int j = 0; j < list2.size(); j++) {
		
							invIssueVO = new InvIssueVO();
							invIssueVO.setInvno(list2.get(j).getInvNo());
							invIssueVO.setIssflg("Y");
							invIssueVO.setIfno(list2.get(j).getArIfNo());
							invIssueVO.setDuedt(list2.get(j).getDueDt());
							invIssueVO.setBkgno(list2.get(j).getBkgNo());
							invIssueVO.setInvrmk(list2.get(j).getInvRmk());
		
							command2.modifyInvoiceIssue(invIssueVO, genInvVo.getOtsSmryCd(), userId);
						}
					}
				}
				return invNos+"&"+blNos;
		    }
			
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage(), ex);
		}
	}
	*/
}