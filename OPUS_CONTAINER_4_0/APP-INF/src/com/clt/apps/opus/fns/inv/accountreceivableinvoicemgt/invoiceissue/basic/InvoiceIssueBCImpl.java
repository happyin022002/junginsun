/**
 * Copyright(c) 2009 CyberLogitec
 * @FileName : InvoiceIssueBCImpl.java
 * @FileTitle : (Korea) Terminal GIRO Inquiry
 * Open Issues :
 * Change history :
 * @LastModifyDate :
 * @LastModifier :
 * @LastVersion : 1.0
 */
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBC;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvArIfNoVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration.InvoiceIssueDBDAO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration.InvoiceIssueEAIDAO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.CustomerListForIssueVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.GeneralInvoiceVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.INVMainInfoForIssueVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvEmlVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvIssMainVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvIssVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvoiceARIssueTempVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvoiceFaxEmailListVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvoiceNumberVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.IssueEachTargetVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.IssueOptionVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.IssueTargetVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.PrintInvoiceVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.SetupOfficeVO;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.basic.INVCommonUtil;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.basic.AccountReceivableOutstandingBC;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.basic.AccountReceivableOutstandingBCImpl;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.InvArIssVO;
import com.clt.syscommon.common.table.MdmCrCustVO;
import com.clt.syscommon.common.util.ScheduleUtil;

/**
 * AccountReceivableInvoiceMgt Business Logic Basic Command implementation<br />
 * - AccountReceivableInvoiceMgt logic process<br />
 *
 * @author Jung Hwi Taek
 * @see FNS_INV_0064EventResponse,InvoiceIssueBC
 * @since J2EE 1.4
 */ 
public class InvoiceIssueBCImpl extends BasicCommandSupport implements InvoiceIssueBC {

	// Database Access Object
	private transient InvoiceIssueDBDAO dbDao = null;
	private transient InvoiceIssueEAIDAO eaiDao = null;

	/**
	 * InvoiceIssueBCImpl Object Creation<br>
	 * InvoiceIssueDBDAO Creation<br>
	 */
	public InvoiceIssueBCImpl() {
		dbDao = new InvoiceIssueDBDAO();
		eaiDao = new InvoiceIssueEAIDAO();
	}

	/**
	 * Invoice Remark(s) event retrieve event process<br>
	 * @author Jung Hwi Taek
	 * @param InvArIssVO invArIssVO
	 * @return List<InvArIssVO>
	 * @exception EventException
	 */
	public List<InvArIssVO> searchInvoiceRemark(InvArIssVO invArIssVO) throws EventException {
		try {
			return dbDao.searchInvoiceRemark(invArIssVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Invoice Copy count retrieve<br>
	 * 
	 * @param String ofcCd
	 * @return int
	 * @exception EventException
	 */
	public int searchInvoiceCopyCnt(String ofcCd) throws EventException {
		try {
			return dbDao.searchInvoiceCopyCnt(ofcCd);
	    } catch(DAOException ex) {
	    	log.error("err " + ex.toString(), ex);
	    	throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}	
	}
	
	/**
	 * Valid Invoice No Return and INV_AR_ISS Re-issue history save.<br>
	 * 
	 * @param PrintInvoiceVO prtInvoiceVo
	 * @return List<InvIssMainVO>
	 * @exception EventException
	 */
	public List<InvIssMainVO> searchPrintInvoice(PrintInvoiceVO prtInvoiceVo) throws EventException {
		List<InvIssMainVO> list = null;
	//	InvIssMainVO issMain = null;
		//String xchRt = "0";
	//	InvEmlVO invEmlSendNoVO = new InvEmlVO();
		
		INVCommonUtil util = new INVCommonUtil();
		
		try {
			list =  dbDao.searchPrintInvoice(prtInvoiceVo);
			
			log.info("\n########## prtInvoiceVo.getPrevFlg() : "+prtInvoiceVo.getPrevFlg());
				
			if (!prtInvoiceVo.getPrevFlg().equals("Y")) {
			
				if(list != null && list.size() > 0) {
					List<InvoiceARIssueTempVO> tmpList = new ArrayList<InvoiceARIssueTempVO>();
					
					
					InvoiceARIssueTempVO issTmpVO = new InvoiceARIssueTempVO();
					issTmpVO.setInvSglFlg(prtInvoiceVo.getFlag());
					String invs = util.undoMakeInQueryStr(prtInvoiceVo.getInvs());
					
					
					issTmpVO.setMltInvNoCtnt(invs);
					issTmpVO.setFmInvNo(prtInvoiceVo.getFInv());
					issTmpVO.setToInvNo(prtInvoiceVo.getTInv());
					issTmpVO.setIssOfcCd(prtInvoiceVo.getIssOfcCd());
					issTmpVO.setUsrId(prtInvoiceVo.getUserId());
					issTmpVO.setIssOptOfcCd(prtInvoiceVo.getUserOfc());
					issTmpVO.setAttrCtnt5(prtInvoiceVo.getGotoFlg());					
					issTmpVO.setAttrCtnt4("PAPER0035");
					issTmpVO.setAttrCtnt3(prtInvoiceVo.getPrevFlg());
					issTmpVO.setAttrCtnt2(prtInvoiceVo.getOtsSmryCd());
					issTmpVO.setIssOfcCd(prtInvoiceVo.getIssOfcCd());
					
					String issTmpSeq = dbDao.searchInvoiceIssueTempNextSeq();
					
					issTmpVO.setInvIssTmpSeq(issTmpSeq);
					issTmpVO.setInvLineNo("1");		
					
					
					tmpList.add(issTmpVO);					
					int insCnt = dbDao.addInvoiceIssueTemp(tmpList);
					
					if( insCnt == 0 ) {
						log.error("Paper Re-issue : There is no data to reissue.");
						throw new EventException(new ErrorHandler("INV00097", new String[] {}).getMessage());
					}
					
					// call batch
		    		String batParam = issTmpSeq;
				    ScheduleUtil su = new ScheduleUtil();
				    
				    // batch status check
				    if(!su.isRunningInIsolatedTrx("FNS_INV_B004")) {					    
					    String batResult = su.directExecuteJob("FNS_INV_B004",batParam);
					    log.error("Paper Re-issue batResult:::" + batResult);
				    
				    // For Online TEST START ==============================
				    
				    //List<InvoiceARIssueTempVO> argList = searchInvoiceIssueTempList(issTmpSeq);
				    //manageInvoiceReissue(argList);				    
				    
				    // For Online TEST END   ==============================
				    }else{
					    log.error("Paper Re-issue batResult:::Processing");
				    	throw new EventException(new ErrorHandler("INV00196",new String[] {}).getMessage());
				    }	
				}
			
			}

		} catch(DAOException ex) {
			log.error("err111 " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err222 " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}
	
	/**
	 * Fax / E-mail send or Invoice information retrieve<br>
	 * 
	 * @param PrintInvoiceVO prtInvoiceVo
	 * @return List<InvoiceFaxEmailListVO>
	 * @exception EventException
	 */
	public List<InvoiceFaxEmailListVO> searchIssuedGeneralInvoiceList(PrintInvoiceVO prtInvoiceVo) throws EventException {
		try {
			return dbDao.searchIssuedGeneralInvoiceList(prtInvoiceVo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Invoice information creation<br>
	 * 
	 * @param InvIssMainVO[] issMainVOs
	 * @param IssueOptionVO issOptionVO
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */
    public String createIssueMain(InvIssMainVO[] issMainVOs, IssueOptionVO issOptionVO, String userId) throws EventException {

    	int issueCnt = 0;
    	//String xchRt = "0";
    	//InvEmlVO invEmlSendNoVO = new InvEmlVO();
    	
		try {
			
			if (issOptionVO.getIssueGubn().equals("I")) {
				// issue
				for (int i = 0; i < issMainVOs.length; i++) {
					//log.info("########## issMainVOs[i].getInvNo() : "+issMainVOs[i].getInvNo());
					issMainVOs[i].setCreUsrId(userId);
					dbDao.modifyIssueMain(issMainVOs[i]);
					issueCnt++;
				}
			} /*else {
				
				
				// re-issue
				for (int i = 0; i < issMainVOs.length; i++) {
					issMainVOs[i].setCreUsrId(userId);					
					issMainVOs[i].setSendFlag(issOptionVO.getSendFlag());
					issMainVOs[i].setIssOfcCd(issOptionVO.getIssOfcCd());
					
					log.info("\n########## issOptionVO.getIssOfcCd() : "+issOptionVO.getIssOfcCd());
				
					dbDao.createIssueMain(issMainVOs[i]);
					
					log.info("\n########## issOptionVO.getSendFlag() : "+issOptionVO.getSendFlag());
					log.info("\n########## issOptionVO.getSendFlag2() : "+issOptionVO.getSendFlag2());
					
					if (issOptionVO.getSendFlag().equals("P") || (issOptionVO.getSendFlag().equals("E") && issOptionVO.getSendFlag2().equals("P"))) {
						//INV_AR_ISS_SND INSERT
						invEmlSendNoVO.setCustEml("");
						invEmlSendNoVO.setOfcCd(issOptionVO.getIssOfcCd());
						invEmlSendNoVO.setEmlSndNo("");
						dbDao.createSendNo(issMainVOs[i].getInvNo(), "P", invEmlSendNoVO, userId);
					}
					
					issueCnt++;
				}
			
			}	*/		
			return String.valueOf(issueCnt);
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00025",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00025",new String[]{}).getMessage(), ex);
		}
	}
    
    
	/**
	 * Invoice information creation<br>
	 * 
	 * @param InvIssMainVO[] issMainVOs
	 * @param IssueOptionVO issOptionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
    public String createReissueMain(InvIssMainVO[] issMainVOs, IssueOptionVO issOptionVO, SignOnUserAccount account) throws EventException {

    	int issueCnt = 0;
    	
    	try {
			
			List<InvoiceARIssueTempVO> tmpList = new ArrayList<InvoiceARIssueTempVO>();
			
			String issTmpSeq = dbDao.searchInvoiceIssueTempNextSeq();
			
			for (int i = 0; i < issMainVOs.length; i++) {
				
				InvoiceARIssueTempVO issTmpVO = new InvoiceARIssueTempVO();
				InvIssMainVO issMainVO = new InvIssMainVO();
				issMainVO = issMainVOs[i];
				
				issMainVO.setCreUsrId(account.getUsr_id());					
				issMainVO.setSendFlag(issOptionVO.getSendFlag());
				issMainVO.setIssOfcCd(issOptionVO.getIssOfcCd());
								
				
				issTmpVO.setInvIssTmpSeq(issTmpSeq);
				issTmpVO.setInvLineNo((i+1)+"");		
				
				//Setting InvIssMainVO Info
				issTmpVO.setInvNo(issMainVO.getInvNo());
				issTmpVO.setIssOfcCd(issMainVO.getIssOfcCd());
				issTmpVO.setInvIssRmk(issMainVO.getInvIssRmk());
				issTmpVO.setUsrId(account.getUsr_id());
				issTmpVO.setInvIssCmbFlg(issMainVO.getInvIssCmbFlg());
				issTmpVO.setInvXchRtDt(issMainVO.getInvXchRtDt());
				issTmpVO.setUsdXchRt(issMainVO.getUsdXchRt());
				issTmpVO.setLoclPoNo(issMainVO.getLoclPoNo());
				issTmpVO.setIssOptRptFileNm(issMainVO.getRdName());
				
				issTmpVO.setAttrCtnt6(issMainVO.getCustEml());
				issTmpVO.setAttrCtnt7(issMainVO.getVvd());
				issTmpVO.setAttrCtnt8(issMainVO.getCustCd());
				issTmpVO.setAttrCtnt9(issMainVO.getCustNm());			
				issTmpVO.setAttrCtnt10(issMainVO.getCustFaxNo());
				issTmpVO.setAttrCtnt11(issMainVO.getBlSrcNo());
				issTmpVO.setAttrCtnt12(issMainVO.getPortCd());
				issTmpVO.setAttrCtnt13(issMainVO.getFKey());
				issTmpVO.setAttrCtnt14(issMainVO.getInvSeq());
				issTmpVO.setAttrCtnt15(issMainVO.getFSaveId());
				issTmpVO.setAttrCtnt16(issMainVO.getIssGrpTpCd());
				issTmpVO.setAttrCtnt17(issMainVO.getAttach());
				issTmpVO.setAttrCtnt18(issMainVO.getAttach2());
				issTmpVO.setAttrCtnt19(issMainVO.getAttachView());
				issTmpVO.setAttrCtnt20(issMainVO.getAttachView2());
				
				issTmpVO.setAttrCtnt21(issMainVO.getUsrId());
				issTmpVO.setAttrCtnt22(issMainVO.getUsrNm());
				issTmpVO.setAttrCtnt23(issMainVO.getAccountCreUsrId());
				issTmpVO.setAttrCtnt24(issMainVO.getAccountUpdUsrId());
		
								
				//Setting IssueOptionVO info
				issTmpVO.setInvIssSndTpCd(issOptionVO.getSendFlag());
				issTmpVO.setN2ndInvIssSndTpCd(issOptionVO.getSendFlag2());
				//issTmpVO.setIssOptSndFlg(issOptionVO.getSendType());
				issTmpVO.setAttrCtnt25(issOptionVO.getSendType());
				issTmpVO.setAttrCtnt1(issOptionVO.getIssLehbb());
				issTmpVO.setIssOptLgoFlg(issOptionVO.getLogoGb());
				issTmpVO.setIssOptTpFlg(issOptionVO.getIssueType());
				issTmpVO.setIssOptCpyKnt(issOptionVO.getCopyCnt());
				//issTmpVO.setIssOptRptFileNm(issOptionVO.getRdName());
				issTmpVO.setIssOptRissFlg(issOptionVO.getIssueGubn());
	
								
				issTmpVO.setAttrCtnt4("POPUP003402");		
				issTmpVO.setAttrCtnt3(account.getUsr_nm());		 //User Name 
				issTmpVO.setAttrCtnt2(issOptionVO.getOfficeCntCd());		 //OfficeCntCd
				
				tmpList.add(issTmpVO);
				
				issueCnt++;
			}
			
			
			int insCnt = dbDao.addInvoiceIssueTemp(tmpList);
			
			if( insCnt == 0 ) {
				log.error("GotoSend Re-issue : There is no data to reissue.");
				throw new EventException(new ErrorHandler("INV00097", new String[] {}).getMessage());
			}
			
			
			// call batch
    		String batParam = issTmpSeq;
		    ScheduleUtil su = new ScheduleUtil();
		    
		    // batch status check
		    if(!su.isRunningInIsolatedTrx("FNS_INV_B004")) {		    
		    
			    String batResult = su.directExecuteJob("FNS_INV_B004",batParam);
			    log.error("Go to Send Re-issue batResult:::" + batResult);
			

		    // For Online TEST START ==============================
		    
		    //List<InvoiceARIssueTempVO> argList = searchInvoiceIssueTempList(issTmpSeq);
		    //manageInvoiceReissue(argList);				    
		    
		    // For Online TEST END   ==============================
		    }else{
			    log.error("Go to Send Re-issue batResult:::Processing");
		    	throw new EventException(new ErrorHandler("INV00196",new String[] {}).getMessage());
		    }	    	

			return String.valueOf(issueCnt);
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00025",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}    
    
	/**
	 * Invoice data retrieve<br>
	 * 
	 * @param GeneralInvoiceVO genInvVo
	 * @return List<IssueTargetVO>
	 * @exception EventException
	 */	
	public List<IssueTargetVO> searchTargetBLForIssue(GeneralInvoiceVO genInvVo) throws EventException {
		List<IssueTargetVO> list = null;
		//log.info("########## genInvVo.getBlNos() : "+genInvVo.getBlNos());
		try {
			list = dbDao.searchTargetBLForIssue(genInvVo);	
			return list;
	    } catch(DAOException ex) {
	    	log.error("err " + ex.toString(), ex);
	    	throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Europe and Southeast Asia in some areas, China's Invoice publication<br>
	 * 
	 * @param IssueTargetVO issTgtVo
	 * @param GeneralInvoiceVO genInvVo
	 * @param String userId
	 * @return List<IssueTargetVO>
	 * @exception EventException
	 */	
	public List<IssueTargetVO> issueGeneralInvoice(IssueTargetVO issTgtVo, GeneralInvoiceVO genInvVo, String userId) throws EventException {
		List<IssueEachTargetVO> list2 = null;
		String invNo = "";
		String dueDt = "";
		String issDt = "";
		InvIssMainVO issMainVo = new InvIssMainVO();
		MdmCrCustVO mdmCrCustVo = new MdmCrCustVO();
		InvoiceNumberVO invNumVo = new InvoiceNumberVO();
		String ofcCd = genInvVo.getLoginOfcCd();
		//String svrId = genInvVo.getSvrId();
		String otsSmryCd = genInvVo.getOtsSmryCd();
		
		log.info("\n########## otsSmryCd : "+otsSmryCd);
		try {
					
			// Invoice No
			invNumVo = dbDao.searchInvoiceNumber(ofcCd, issTgtVo.getIoBndCd(), userId);
			invNo = invNumVo.getInvNo();
			
			log.info("\n########## invNo : "+invNo);
			
			dbDao.modifyInvoiceNumber(invNumVo.getInvPfxCd(), invNumVo.getInvMaxSeq(), userId);
			
			issMainVo.setInvNo(invNo);
			issMainVo.setIssOfcCd(ofcCd);		
			//issMainVo.setInvIssRmk(issTgtVo.getInvRmk());
			issMainVo.setCreUsrId(userId);
			
			// Issue Data creation
			dbDao.createIssueMain(issMainVo);	
				
			// Interface No retrieve
			List<IssueTargetVO> list = dbDao.searchInterfaceNumberList(genInvVo, issTgtVo); 			
						
			for (int i = 0; i < list.size(); i++) {
				
				log.info("\n########## list.get("+String.valueOf(i)+").getArIfNo()_2 : "+list.get(i).getArIfNo());
				
				// Issue Detail creation target retrieve
				list2 = dbDao.searchEachTargetForIssue(list.get(i).getArIfNo());				
				
				for (int j = 0; j < list2.size(); j++) {
					// Issue Detail Data Creation
					log.info("\n########## invNo2 : "+invNo);
					dbDao.createInvoiceMapping(invNo, list2.get(j), userId);				
				}
					
				issDt = dbDao.searchIssDate(invNo);
				
				// Europe
				//if (svrId.equals("EUR")) {
				if (otsSmryCd.equals("INV")) {	
					
					//log.info("\n########## list.get(i).getRevTpCd() : "+list.get(i).getRevTpCd());
					log.info("\n########## list.get(i).getTrspRqstOrdFlg() : "+list.get(i).getTrspRqstOrdFlg());
					
					//(REV_TYP = 'M' or TRO_MK = 'Y')
					if(list.get(i).getRevTpCd().equals("M") || list.get(i).getTrspRqstOrdFlg().equals("Y")) {
					
						dueDt = dbDao.searchDueDateByCustomer(list.get(i), ofcCd, issDt);
						log.info("\n########## dueDt1 : "+dueDt);
						if (dueDt.equals("")){
							dueDt = dbDao.searchDueDateByOffice(list.get(i), ofcCd);  
							log.info("\n########## dueDt2 : "+dueDt);
						}		
						
					// is not (REV_TYP = 'M' or TRO_MK = 'Y')	
					} else {
						
						mdmCrCustVo = dbDao.searchPaymentDateByCustomer(list.get(i).getActCustCntCd(), list.get(i).getActCustSeq());
						
						dueDt = dbDao.searchDueDateByDivCd (list.get(i), issDt, ofcCd);
						log.info("\n########## dueDt3 : "+dueDt);
	
						if (dueDt.equals("")){
							dueDt = dbDao.searchDueDateByOffice(list.get(i), ofcCd);  
							log.info("\n########## dueDt4 : "+dueDt);
						}		
						
						if (mdmCrCustVo.getPayDtDy1() != null) { 
							if (!mdmCrCustVo.getPayDtDy1().equals("") && mdmCrCustVo.getCrFlg().equals("Y")){
								dueDt = dbDao.searchDueDateByPaymentDate(list.get(i), dueDt);	
								log.info("\n########## dueDt5 : "+dueDt);
								
							}		
						}
					}				
					
				// is not Europe	
				} else {
					
					dueDt = dbDao.searchDueDateByCustomer(list.get(i), ofcCd, issDt);
					if (dueDt.equals("")){
						dueDt = dbDao.searchDueDateByOffice(list.get(i), ofcCd);  
					}				
					
				}			
				
				//log.info("########## invNo : "+invNo);
				//log.info("########## dueDt : "+dueDt);
				list.get(i).setInvNo(invNo);
				list.get(i).setDueDt(dueDt);				
						
			}
			
			return list;
			
	    } catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}

	}
	
	/**
	 * e-mail, FAX send<br>
	 * 
	 * @param InvIssMainVO[] issMainVOs
	 * @param IssueOptionVO issOptionVO
	 * @param SignOnUserAccount account
	 * @param String ofcCntCd
	 * @exception EventException
	 */	
	public void sendGeneralInvoiceByFaxEmail(InvIssMainVO[] issMainVOs, IssueOptionVO issOptionVO, SignOnUserAccount account, String ofcCntCd) throws EventException {
		try {	
			if(ofcCntCd.equals("IN")) {
				eaiDao.sendGeneralInvoiceByFTP(issMainVOs, issOptionVO, account); //2016.03.04 FTP 방식 추가 
			} else {
				eaiDao.sendGeneralInvoiceByFaxEmail(issMainVOs, issOptionVO, account);
			}
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * Paper send<br>
	 * 
	 * @param InvIssMainVO[] issMainVOs
	 * @param IssueOptionVO issOptionVO
	 * @param SignOnUserAccount account
	 * @param String ofcCntCd
	 * @exception EventException
	 */	
	public void sendGeneralInvoiceByPaper(InvIssMainVO[] issMainVOs, IssueOptionVO issOptionVO, SignOnUserAccount account, String ofcCntCd) throws EventException {
		InvEmlVO invEmlSendNoVO = new InvEmlVO();
		String usrId = "";
		try {	
			if(account == null) {
	    		usrId = issMainVOs[0].getUsrId();
	    	} else {
	    		usrId = account.getUsr_id();
	    	}
			
			for (int i=0; i<issMainVOs.length; i++) {
				invEmlSendNoVO.setCustEml("");
				invEmlSendNoVO.setOfcCd(issOptionVO.getIssOfcCd());
				invEmlSendNoVO.setEmlSndNo("");
				// 전송정보를 INV_AR_ISS_SND 에 저장
				dbDao.createSendNo(issMainVOs[i].getInvNo(), "P", invEmlSendNoVO, usrId);
			}
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * BackEndJob Invoice publication<br>
	 * 
	 * @param GeneralInvoiceVO genInvVo
	 * @param CustomerListForIssueVO[] customerListForIssueVOs
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */	
	public String issueGeneralInvoiceBackEndJobKey(GeneralInvoiceVO genInvVo, CustomerListForIssueVO[] customerListForIssueVOs, String userId) throws EventException{
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		InvoiceIssueBackEndJob command = new InvoiceIssueBackEndJob();
		String backEndJobKey = "";
		try {			
			//String ofc = genInvVo.getArOfcCd();
			//String ofcCd = genInvVo.getArOfcCd2();
			//InvoiceNumberVO invNumVo = new InvoiceNumberVO();
			/*if(invNumVo == null){
				throw new EventException(new ErrorHandler("INV00113", new String[] {}).getMessage());
			}*/
			
			command.setGenInvVo(genInvVo);
			command.setCustomerListForIssueVOs(customerListForIssueVOs);
			command.setUserId(userId);

           	backEndJobKey = backEndJobManager.execute(command, userId, "FNS_INV_0034_01");

			return backEndJobKey;	
		/*} catch (EventException ex) {	
			log.error("errBc0=============>> " + ex.toString(), ex);
			throw ex;	*/
			/*
		} catch (DAOException ex) {
			log.error("errBc1=============>> " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);*/
		} catch (Exception ex) {
			log.error("errBc2=============>> " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieve for Invoice publication<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String getBackEndJobResutIssueGeneralInvoice(String key) throws EventException {
		try {
			InvoiceIssueEAIDAO backEaiDao = new InvoiceIssueEAIDAO();
			return backEaiDao.getBackEndJobResutIssueGeneralInvoice(key);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage());
		}
	}

	/**
	 * Invoice not publication target data retrieve. <br>
	 * 
	 * @param GeneralInvoiceVO genInvVo
	 * @return List<String>
	 * @exception EventException
	 */	
	public List<String> searchErrorBLNumberList(GeneralInvoiceVO genInvVo) throws EventException {
		List<String> list = null;
		//log.info("########## genInvVo.getBlNos() : "+genInvVo.getBlNos());
		try {
			list = dbDao.searchErrorBLNumberList(genInvVo);	
			return list;
	    } catch(DAOException ex) {
	    	log.error("err " + ex.toString(), ex);
	    	throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	
	
	/**
	 * Invoice Number <br>
	 * 
	 * @param String ofcCd
	 * @param String bnd
	 * @param String userId
	 * @return InvoiceNumberVO
	 * @exception DAOException
	 */
	public InvoiceNumberVO searchInvoiceNumber(String ofcCd, String bnd, String userId) throws EventException{
		try {
			return dbDao.searchInvoiceNumber(ofcCd, bnd, userId);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Invoice Number max_seq change. <br>
	 * 
	 * @param String invPfxCd
	 * @param String invMaxSeq
	 * @param String userId
	 * @exception DAOException
	 */
	public void modifyInvoiceNumber(String invPfxCd, String invMaxSeq, String userId) throws EventException{
		try {
			 dbDao.modifyInvoiceNumber(invPfxCd, invMaxSeq, userId);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Same INVOICE NO INTERFACE NO retrieve. <br>
	 * 
	 * @param GeneralInvoiceVO genInvVo
	 * @param IssueTargetVO issTgtVo
	 * @return List<IssueTargetVO>
	 * @exception DAOException
	 */
	public List<IssueTargetVO> searchInterfaceNumberList(GeneralInvoiceVO genInvVo, IssueTargetVO issTgtVo) throws EventException{
		try {
			return dbDao.searchInterfaceNumberList(genInvVo, issTgtVo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Invoice Detail Table save target Data retrieve. <br>
	 * 
	 * @param String arIfNo
	 * @return List<IssueEachTargetVO>
	 * @exception DAOException
	 */
	public List<IssueEachTargetVO> searchEachTargetForIssue(String arIfNo) throws EventException{
		try {
			return dbDao.searchEachTargetForIssue(arIfNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Invoice Detail information creation. <br>
	 * 
	 * @param String invNo
	 * @param IssueEachTargetVO issEachTgtVo
	 * @param String userId
	 * @exception DAOException
	 */
	public void createInvoiceMapping(String invNo, IssueEachTargetVO issEachTgtVo, String userId) throws EventException {
		try {
			dbDao.createInvoiceMapping(invNo, issEachTgtVo, userId);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		}
	}
	
	/**
	 * Invoice issue execute. <br>
	 * 
	 * @author Dong Hoon Han
	 * @param GeneralInvoiceVO genInvVo
	 * @param List<INVMainInfoForIssueVO> iNVMainInfoForIssueVOs
	 * @return InvIssVO
	 * @exception DAOException
	 */
	public InvIssVO searchInvoiceMaxSequence(GeneralInvoiceVO genInvVo,  List<INVMainInfoForIssueVO> iNVMainInfoForIssueVOs) throws EventException{
		try {
			String ofcCd = genInvVo.getArOfcCd2();
			String userId = genInvVo.getUserId();
			String issueType = genInvVo.getIssueType();
			String emailFlag = genInvVo.getEmailFlag();
			String revType = genInvVo.getRevType();
			InvoiceNumberVO invNumVo = new InvoiceNumberVO();
			SetupOfficeVO setupOfficeVO = new SetupOfficeVO();
			log.error("bl_src_no------------------------->>>>>>>>>>>>>>>"+genInvVo.getBlNo());
			log.error("bl_src_nos------------------------->>>>>>>>>>>>>>>"+genInvVo.getBlNos());
			// Select(INV_MLT_BL_ISS_FLG, INV_DUP_FLG, OTS_SMRY_CD, INV_ISS_TP_CD)
			setupOfficeVO = dbDao.searchSetupOfficeForIssue(ofcCd);
			String invMltBlIssFlg = setupOfficeVO.getInvMltBlIssFlg();
			String invDupFlg = setupOfficeVO.getInvDupFlg();
			String otsSmryCd = setupOfficeVO.getOtsSmryCd();			
			String invIssTpCd = setupOfficeVO.getInvIssTpCd();
			
			//if(invDupFlg == null) invDupFlg = "N";
			//if(otsSmryCd == null) otsSmryCd = "AA";
			//if(invIssTpCd == null) invIssTpCd = "S";
			//WRK NO
			invNumVo = dbDao.searchInvoiceMaxSequence(ofcCd, userId);
			
			String wrkNo = invNumVo.getWrkNo();
			String invPfxCd = invNumVo.getInvPfxCd();
			String invMaxSeq = invNumVo.getInvMaxSeq();
			String issDt = invNumVo.getIssDt();						
			
			//inv_ar_iss_ftr work exist checking
			String wrkNoCnt = dbDao.searchInvIssWorkNumber(wrkNo);
			
			if(!wrkNoCnt.equals("0")){
				//NextVal
				dbDao.searchIssNoNextval();
			}
			
			
			genInvVo.setWrkNo(wrkNo);
			InvIssVO invIssVO = new InvIssVO();
			invIssVO.setIssDt(issDt);
			invIssVO.setOfcCd(ofcCd);
			invIssVO.setUserId(userId);
			invIssVO.setInvPfxCd(invPfxCd);
			invIssVO.setInvMaxSeq(invMaxSeq);
			invIssVO.setWrkNo(wrkNo);
			invIssVO.setInvMltBlIssFlg(invMltBlIssFlg);
			invIssVO.setInvDupFlg(invDupFlg);
			invIssVO.setOtsSmryCd(otsSmryCd);
			invIssVO.setInvIssTpCd(invIssTpCd);
			invIssVO.setIssueType(issueType);
			invIssVO.setEmailFlag(emailFlag);
			invIssVO.setRevType(revType);
			invIssVO.setIssGrpTpCd(genInvVo.getIssGrpTpCd());	//2014.06.26 add

			String invSeq = "";

			//ISSUE TEMP table INSERT
			//2014.06.26
			//if(invDupFlg.equals("Y")){
			//	dbDao.addInvoiceIssueFilterForDup(genInvVo);
			//}else{
			
			for(int i=0; i < iNVMainInfoForIssueVOs.size(); i++) {
				iNVMainInfoForIssueVOs.get(i).setWrkNo(wrkNo);
			}
				dbDao.addInvoiceIssueFilter(iNVMainInfoForIssueVOs);
			//}
			log.error("------------------------->>>>>>>>>>>>>>>1");
			//2014.06.26
			//if(invDupFlg.equals("Y")){	
				//ISSUE TEMP table DELETE
				//dbDao.removeInvoiceIssueFilterForDup(genInvVo);
				//INV_AR_ISS table INSERT			
			//	invSeq = dbDao.addInvoiceIssueForDup(invIssVO);
			//}else if(invDupFlg.equals("N")){					
				//INV_AR_ISS table INSERT			
				invSeq = dbDao.addInvoiceIssue(invIssVO);
			//}
			log.error("------------------------->>>>>>>>>>>>>>>2");
			
			//log.info("invSeq==========>>>"+invSeq);
			invIssVO.setInvSeq(invSeq);
			dbDao.modifyInvMaxSeq(invPfxCd, invMaxSeq, invSeq, userId);
			
			return invIssVO;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * INV_AR_ISS_DTL table INSERT. <br>
	 * 
	 * @author Dong Hoon Han
	 * @param InvIssVO invIssVO
	 * @exception DAOException
	 */
	public void addInvoiceIssueDetail(InvIssVO invIssVO) throws EventException{
		try {				
			dbDao.addInvoiceIssueDetail(invIssVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * ISSUE TEMP table DELETE. <br>
	 * 
	 * @author Dong Hoon Han
	 * @param InvIssVO invIssVO
	 * @return List<String>
	 * @exception DAOException
	 */
	public List<String> removeInvoiceIssueFilter(InvIssVO invIssVO) throws EventException{
		//List<String> resultVOs = null;
		List<String> resultVOs = new ArrayList<String>();
		InvEmlVO invEmlSendNoVO = new InvEmlVO();
		try {	
			//INV_NO retrieve
			//resultVOs = dbDao.searchFilterInvoiceNumber(invIssVO);
			//if no retrieve
			List<String> ifNoList = new ArrayList<String>();	
			String wrkNo = invIssVO.getWrkNo();
			ifNoList = dbDao.searchInterfaceNumberForERP(wrkNo);
			log.error("ifNoList------------------------->>>>>>>>>>>>>>>"+ifNoList);
			//ISSUE TEMP table DELETE
			// 2010.08.31 Filter Table Sequence problem
			dbDao.removeInvoiceIssueFilter(invIssVO);
			
			String ofcCd = invIssVO.getOfcCd();
			String invPfxCd = invIssVO.getInvPfxCd();
			String invMaxSeq = invIssVO.getInvMaxSeq();
			String invSeq = invIssVO.getInvSeq();
			String userId = invIssVO.getUserId();
			//String issueType = invIssVO.getIssueType();
			/*
			if(ofcCd.equals("VLCBB") || ofcCd.equals("LEHBB")){
				//Table UPDATE
				dbDao.modifyInvMaxSeq(invPfxCd, invMaxSeq, invSeq, userId);
			}
			*/
			
			//INV_NO retrieve			
			int invMaxSeqI = Integer.parseInt(invMaxSeq);
			String invNo = "";

			for(int i=1; i<=Integer.parseInt(invSeq); i++){
				//if(ofcCd.equals("DXBBB")){
				//	invNo = invPfxCd+issueType+JSPUtil.getLPAD(Integer.toString(invMaxSeqI+i), 6, "0");
				//}else{
					invNo = invPfxCd+JSPUtil.getLPAD(Integer.toString(invMaxSeqI+i),7,"0");
				//}
				
				//INV_AR_ISS_SND INSERT				
				if(invIssVO.getEmailFlag().equals("N")){
					invEmlSendNoVO.setCustEml("");
					invEmlSendNoVO.setOfcCd(ofcCd);
					invEmlSendNoVO.setEmlSndNo("");
					dbDao.createSendNo(invNo, "P", invEmlSendNoVO, userId);
				}
				
				resultVOs.add(invNo);				
			}
			
			//interface send
			AccountReceivableOutstandingBC command2 = new AccountReceivableOutstandingBCImpl();
			List<InvArIfNoVO> ifNos = new ArrayList<InvArIfNoVO>();
			InvArIfNoVO invArIfNoVO = new InvArIfNoVO();
			
			String ifNo = "";
			// New Data creation
			for(int k=0; k<ifNoList.size(); k++){
				ifNo = ifNoList.get(k);
				if(!ifNo.equals("")){
					invArIfNoVO = new InvArIfNoVO();
					invArIfNoVO.setIfNo(ifNo);
					ifNos.add(invArIfNoVO);
				}
			}
						
			String otsSmryCd = invIssVO.getOtsSmryCd();
			if(otsSmryCd.equals("INV")){
				command2.createOutstandingInfo(ifNos);
			}
			
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
		return resultVOs;
	}
	
	/**
     * lpad function
     *
     * @param String str
     * @param int len
     * @param String addStr
     * @return String
     */
/* 2010.11.04 JSPUtil use common function
    public static String invLpad(String str, int len, String addStr) {
        String result = str;
        int templen   = len - result.length();

        for (int i = 0; i < templen; i++){
              result = addStr + result;
        }
        
        return result;
    }
*/	
	/**
	 * Other Revenue Invoice publication <br>
	 * 
	 * @param InvIssMainVO invCreVo
	 * @param List<IssueEachTargetVO> issEachTgtVOs
	 * @param String ofcCd
	 * @param String userId
	 * @return String
	 * @throws EventException
	 */
	public String issueOtherRevInvoice (InvIssMainVO invCreVo, List<IssueEachTargetVO> issEachTgtVOs, String ofcCd, String userId) throws EventException {
		try {
			InvoiceNumberVO invNumVo = new InvoiceNumberVO();
			String invNo = "";
			
			//invoice No retrieve
			invNumVo = dbDao.searchInvoiceNumber(ofcCd, "O", userId);
			invNo = invNumVo.getInvNo();
			
			dbDao.modifyInvoiceNumber(invNumVo.getInvPfxCd(), invNumVo.getInvMaxSeq(), userId);
			
			invCreVo.setInvNo(invNumVo.getInvNo());
			invCreVo.setIssOfcCd(ofcCd);
			invCreVo.setCreUsrId(userId);
			
			dbDao.createIssueMain(invCreVo);

			for (int j = 0; j < issEachTgtVOs.size(); j++) {
				dbDao.createInvoiceMapping(invNo, issEachTgtVOs.get(j), userId);
			}
			
			return invNo;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * INV_AR_ISS_SND insert. <br>
	 * @author Dong Hoon Han
	 * @param String invNo
	 * @param String sndTp
	 * @param InvEmlVO invEmlSendNoVO
	 * @param String usrId
	 * @throws EventException
	 */
	public void createSendNo(String invNo, String sndTp, InvEmlVO invEmlSendNoVO, String usrId) throws EventException {
		try {			
			dbDao.createSendNo(invNo, sndTp, invEmlSendNoVO, usrId);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	/**
	 * FNS_INV_0034_01 <br>
	 * @author CLT
	 * @param GeneralInvoiceVO genInvVo
	 * @return List<CustomerListForIssueVO>
	 * @throws EventException
	 */
	public List<CustomerListForIssueVO> searchCustomerListForIssue(GeneralInvoiceVO genInvVo) throws EventException {
		try {			
			return dbDao.searchCustomerListForIssue(genInvVo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}		
	}
	
	/**
	 * FNS_INV_0034_01 <br>
	 * @author CLT
	 * @param String blNos
	 * @return String
	 * @throws EventException
	 */
	public String searchBKGInterfaceCount(String blNos) throws EventException {
		try {			
			return dbDao.searchBKGInterfaceCount(blNos);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}		
	}
	
	/**
	 * Search Invoice Issue Temp <br>
	 * 
	 * @param String tmpSeq
	 * @return List<InvoiceARIssueTempVO>
	 * @exception EventException
	 */
	public List<InvoiceARIssueTempVO> searchInvoiceIssueTempList(String tmpSeq) throws EventException {
		try {
			return dbDao.searchInvoiceIssueTempList(tmpSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * Remove Invoice Issue Temp<br>
	 * 
	 * @param String tmpSeq
	 * @exception EventException
	 * 
	 */
	public void removeInvoiceIssueTemp(String tmpSeq) throws EventException {
		try {
			dbDao.removeInvoiceIssueTemp(tmpSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * Manage Invoice Reissue <br>
	 * 
	 * @param List<InvoiceARIssueTempVO> argList
	 * @exception EventException
	 * 
	 */
	public void manageInvoiceReissue(List<InvoiceARIssueTempVO> argList) throws EventException { 
		try {
		
			if(argList == null || argList.size() < 1) {
				log.error("manageInvoiceReissue:No data to reissue");
				throw new EventException(new ErrorHandler("INV00097", new String[] {}).getMessage());				
			}
			
			String strCaller = argList.get(0).getAttrCtnt4();
			String tmpPK = argList.get(0).getInvIssTmpSeq();
			
			
			INVCommonUtil util = new INVCommonUtil();
			BookingARCreationBC command2 = new BookingARCreationBCImpl();
			
			List<InvIssMainVO> list = null;
			InvIssMainVO issMain = null;
			InvEmlVO invEmlSendNoVO = new InvEmlVO();
			
			if(strCaller.equals("PAPER0035")) {	// 기존의 paper issue
				
				//기존 VO 로직 그대로 살리기위해.
				PrintInvoiceVO prtInvoiceVo = new PrintInvoiceVO();
				InvoiceARIssueTempVO issTmpVO = new InvoiceARIssueTempVO();
				issTmpVO = argList.get(0);
				
				
				prtInvoiceVo.setFlag(issTmpVO.getInvSglFlg());
				prtInvoiceVo.setInvs(util.makeInQueryStr(issTmpVO.getMltInvNoCtnt(), ","));
				prtInvoiceVo.setFInv(issTmpVO.getFmInvNo());
				prtInvoiceVo.setTInv(issTmpVO.getToInvNo());
				prtInvoiceVo.setIssOfcCd(issTmpVO.getIssOfcCd());
				prtInvoiceVo.setUserId(issTmpVO.getUsrId());
				prtInvoiceVo.setUserOfc(issTmpVO.getIssOptOfcCd());
				prtInvoiceVo.setGotoFlg(issTmpVO.getAttrCtnt5());
				prtInvoiceVo.setPrevFlg(issTmpVO.getAttrCtnt3());
				prtInvoiceVo.setOtsSmryCd(issTmpVO.getAttrCtnt2());
				prtInvoiceVo.setIssOfcCd(issTmpVO.getIssOfcCd());
				
				//Target List 
				list =  dbDao.searchPrintInvoice(prtInvoiceVo);
				
				for(int i=0; i<list.size(); i++) {
					issMain = new InvIssMainVO();
					issMain.setInvNo(list.get(i).getInvNo());
					issMain.setIssOfcCd(prtInvoiceVo.getUserOfc());
					issMain.setCreUsrId(prtInvoiceVo.getUserId());
					
					log.info("\n########## prtInvoiceVo.getUserOfc() : "+prtInvoiceVo.getUserOfc());
					
					dbDao.createIssueMain(issMain);		
					
					if (!prtInvoiceVo.getGotoFlg().equals("Y")) {
						
						//INV_AR_ISS_SND INSERT
						invEmlSendNoVO.setCustEml("");
						invEmlSendNoVO.setOfcCd(prtInvoiceVo.getUserOfc());
						invEmlSendNoVO.setEmlSndNo("");
						dbDao.createSendNo(list.get(i).getInvNo(), "P", invEmlSendNoVO, prtInvoiceVo.getUserId());
							
					}
					
					if (!prtInvoiceVo.getPrevFlg().equals("Y")) {
						command2.modifyInvoiceReIssue(list.get(i).getInvNo(), prtInvoiceVo.getOtsSmryCd(), prtInvoiceVo.getUserId(), prtInvoiceVo.getIssOfcCd());
					}	
				}
				
			} // end of if PAPER0035
			
			else if(strCaller.equals("POPUP003402")) {	// From GoToSend Button (FNS_INV_0034_02 popup) 
					
				
				String usrId = "";
				String usrNm = "";
				String issOfcCd = "";
				String sendFlag = "";
				String officeCntCd = "";
				
				InvIssMainVO[] issMainVOs = new InvIssMainVO[argList.size()];
				
				usrId = argList.get(0).getUsrId();
				usrNm = argList.get(0).getAttrCtnt3();
				issOfcCd = argList.get(0).getIssOfcCd();
				sendFlag = argList.get(0).getInvIssSndTpCd();
				officeCntCd = argList.get(0).getAttrCtnt2();   //OfficeCntCd
				
				for (int i = 0; i < argList.size(); i++) {
					InvoiceARIssueTempVO issTmpVO = new InvoiceARIssueTempVO();
					issTmpVO = argList.get(i);
					issMainVOs[i] = new InvIssMainVO();
					
					issMainVOs[i].setCreUsrId(issTmpVO.getUsrId());					
					issMainVOs[i].setSendFlag(issTmpVO.getInvIssSndTpCd());
					issMainVOs[i].setIssOfcCd(issTmpVO.getIssOfcCd());
				
					
					//Setting InvIssMainVO Info
					issMainVOs[i].setInvNo(issTmpVO.getInvNo());
					issMainVOs[i].setIssOfcCd(issTmpVO.getIssOfcCd());
					issMainVOs[i].setInvIssRmk(issTmpVO.getInvIssRmk());
					issMainVOs[i].setInvIssCmbFlg(issTmpVO.getInvIssCmbFlg());
					issMainVOs[i].setInvXchRtDt(issTmpVO.getInvXchRtDt());
					issMainVOs[i].setUsdXchRt(issTmpVO.getUsdXchRt());
					issMainVOs[i].setLoclPoNo(issTmpVO.getLoclPoNo());
					issMainVOs[i].setRdName(issTmpVO.getIssOptRptFileNm());
					
					issMainVOs[i].setCustEml(issTmpVO.getAttrCtnt6());
					issMainVOs[i].setVvd(issTmpVO.getAttrCtnt7());
					issMainVOs[i].setCustCd(issTmpVO.getAttrCtnt8());
					issMainVOs[i].setCustNm(issTmpVO.getAttrCtnt9());			
					issMainVOs[i].setCustFaxNo(issTmpVO.getAttrCtnt10());
					issMainVOs[i].setBlSrcNo(issTmpVO.getAttrCtnt11());
					issMainVOs[i].setPortCd(issTmpVO.getAttrCtnt12());
					issMainVOs[i].setFKey(issTmpVO.getAttrCtnt13());
					issMainVOs[i].setInvSeq(issTmpVO.getAttrCtnt14());
					issMainVOs[i].setFSaveId(issTmpVO.getAttrCtnt15());
					issMainVOs[i].setIssGrpTpCd(issTmpVO.getAttrCtnt16());
					
					issMainVOs[i].setAttach(issTmpVO.getAttrCtnt17());
					issMainVOs[i].setAttach2(issTmpVO.getAttrCtnt18());
					issMainVOs[i].setAttachView(issTmpVO.getAttrCtnt19());
					issMainVOs[i].setAttachView2(issTmpVO.getAttrCtnt20());
					
					issMainVOs[i].setUsrId(issTmpVO.getAttrCtnt21());
					issMainVOs[i].setUsrNm(issTmpVO.getAttrCtnt22());
					issMainVOs[i].setAccountCreUsrId(issTmpVO.getAttrCtnt23());
					issMainVOs[i].setAccountUpdUsrId(issTmpVO.getAttrCtnt24());
					
					
					//Setting IssueOptionVO info
					//issTmpVO.setInvIssSndTpCd(issOptionVO.getSendFlag());
					//issTmpVO.setN2ndInvIssSndTpCd(issOptionVO.getSendFlag2());
					
					dbDao.createIssueMain(issMainVOs[i]);
					
					if (issTmpVO.getInvIssSndTpCd().equals("P") || (issTmpVO.getInvIssSndTpCd().equals("E") && issTmpVO.getN2ndInvIssSndTpCd().equals("P"))) {
						//INV_AR_ISS_SND INSERT
						invEmlSendNoVO.setCustEml("");
						invEmlSendNoVO.setOfcCd(issMainVOs[i].getIssOfcCd());
						invEmlSendNoVO.setEmlSndNo("");
						dbDao.createSendNo(issMainVOs[i].getInvNo(), "P", invEmlSendNoVO, issTmpVO.getUsrId());
					}
				}
				
				command2.modifyInvoiceIssueEmail(issMainVOs, issOfcCd, "R", usrId);
				
				
				IssueOptionVO issOptionVO = new IssueOptionVO();
				
				
				issOptionVO.setSendFlag(argList.get(0).getInvIssSndTpCd());
				issOptionVO.setSendFlag2(argList.get(0).getN2ndInvIssSndTpCd());
				issOptionVO.setIssueGubn(argList.get(0).getIssOptRissFlg());
				issOptionVO.setIssOfcCd(argList.get(0).getIssOfcCd());
				issOptionVO.setRdName(argList.get(0).getIssOptRptFileNm());
				issOptionVO.setNameFlag("");
				issOptionVO.setTitleFlag("");
				issOptionVO.setSendType(argList.get(0).getAttrCtnt25()); 	//SEND TYPE
				issOptionVO.setIssueType(argList.get(0).getIssOptTpFlg());
				issOptionVO.setCopyCnt(argList.get(0).getIssOptCpyKnt());
				issOptionVO.setIssLehbb(argList.get(0).getAttrCtnt1());
				issOptionVO.setLogoGb(argList.get(0).getIssOptLgoFlg());
				
				
				
				if (sendFlag.equals("E") || sendFlag.equals("F")) {
					log.info("########## sendFlag2 : "+sendFlag);
					sendGeneralInvoiceByFaxEmail(issMainVOs, issOptionVO, null, officeCntCd); // 2016.03.04 OfficeCntCd 추가
				}
				
				
			}
			
			// Delete Temp Table
			removeInvoiceIssueTemp(tmpPK);
			
		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}

	}
	
	/**
	 * create INV_AR_ISS_TMP <br>
	 * 
	 * @param List<InvoiceARIssueTempVO> issTmpVOList
	 * @exception EventException
	 */	
	public void addInvoiceIssueTemp(List<InvoiceARIssueTempVO> issTmpVOList) throws EventException {
		try {
			dbDao.addInvoiceIssueTemp(issTmpVOList);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
}