/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingARCreationBCImpl.java
*@FileTitle : Invoice Update by User ID
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBC;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARCreditInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARCreditVO;
//import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.Fns0120001VO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration.GeneralARInvoiceCreationDBDAO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.ARInterfaceCreationVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.DueDateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArAmtVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArChgVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArCntrVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfChgVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfCntrVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfMnVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArMnVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.MRIRevenueVVDLaneVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.REVTypeSourceVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.basic.ManualARCreationBC;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.basic.ManualARCreationBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvArIfNoVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.basic.InvoiceIssueBC;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.basic.InvoiceIssueBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvIssMainVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.IssueEachTargetVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.IssueOptionVO;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.basic.INVCommonUtil;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.ExchangeRateVO;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.VVDCustomerVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.basic.AccountReceivableOutstandingBC;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.basic.AccountReceivableOutstandingBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.DateTime;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.BkgVvdVO;
import com.clt.syscommon.common.table.MdmCustomerVO;
import com.clt.syscommon.common.table.MdmOrganizationVO;
import com.clt.syscommon.common.table.VskVslPortSkdVO;
 
/**
 * AccountReceivableInvoiceCreation Business Logic Basic Command implementation<br>
 * - AccountReceivableInvoiceCreation logic process<br>
 *
 * @author Jung Hwi Taek
 * @see GeneralARInvoiceCreationBC
 * @since J2EE 1.6
 */
public class GeneralARInvoiceCreationBCImpl extends BasicCommandSupport implements GeneralARInvoiceCreationBC {

	// Database Access Object
	private transient GeneralARInvoiceCreationDBDAO dbDao = null;
	//private transient BookingARCreationEAIDAO eaiDao = null;

	/**
	 * GeneralARInvoiceCreationBCImpl object creation<br>
	 * GeneralARInvoiceCreationBCImpl creation.<br>
	 */
	public GeneralARInvoiceCreationBCImpl() {
		dbDao = new GeneralARInvoiceCreationDBDAO();
		//eaiDao = new BookingARCreationEAIDAO();
	}
	
	/**
	 * GeneralARInvoiceCreationBCImpl object creation<br>
	 * GeneralARInvoiceCreationBCImpl creation.<br>
	 *  @param String dataSource
	 */
	public GeneralARInvoiceCreationBCImpl(String dataSource) {
		dbDao = new GeneralARInvoiceCreationDBDAO(dataSource);
		//eaiDao = new BookingARCreationEAIDAO();
	}


	
	/**
	 * DEM, DET, TPB, MNR, LSE publication receivables information Interface. <br>
	 * 
	 * @param List<ARInterfaceCreationVO> genIfVos
	 * @return List<ARInterfaceCreationVO>
	 * @exception EventException
	 */
	public List<ARInterfaceCreationVO> interfaceGeneralARInvoiceToIF(List<ARInterfaceCreationVO> genIfVos) throws EventException{
		
		ARInterfaceCreationVO genIfVo = null;		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); 
		Date dt = new Date();
		
		String srcIfDt = "";
		String srcIfSeq = "";
		
		List<ARInterfaceCreationVO> genIfVosDb = new ArrayList<ARInterfaceCreationVO>();
		ARInterfaceCreationVO genIfVoDb = null;
		InvArIfMnVO invArIfMnVO = null;
		List<InvArIfChgVO> invArIfChgVOs = null;
		List<InvArIfCntrVO> invArIfCntrVOs = null;
                
		try {
			
			for (int rowNum = 0; rowNum < genIfVos.size(); rowNum++) {
				// add : 2010.02.04 ---------------------------------------------------
				genIfVoDb = new ARInterfaceCreationVO();
				// ------------------------------------------------------------------------
				
				genIfVo = genIfVos.get(rowNum);
				
									
				// Key
				srcIfDt = sdf.format(dt);					
				srcIfSeq = dbDao.searchSrcIfSeq();
				
				// INV_AR_IF_MN table save
				genIfVo.getInvArIfMnVO().setSrcIfDt(srcIfDt);	
				genIfVo.getInvArIfMnVO().setSrcIfSeq(srcIfSeq);		
				dbDao.addInterfaceMain(genIfVo.getInvArIfMnVO());
								
				// INV_AR_IF_CHG table save
				if (genIfVo.getInvArIfChgVOs() != null) {
					for(int i = 0; i < genIfVo.getInvArIfChgVOs().size(); i++) {
						genIfVo.getInvArIfChgVOs().get(i).setSrcIfDt(srcIfDt);
						genIfVo.getInvArIfChgVOs().get(i).setSrcIfSeq(srcIfSeq);
					}
					dbDao.addInterfaceCharge(genIfVo.getInvArIfChgVOs());
				}
				
				// INV_AR_IF_CNTR table save
				if (genIfVo.getInvArIfCntrVOs() != null) {
					for(int i = 0; i < genIfVo.getInvArIfCntrVOs().size(); i++) {
						genIfVo.getInvArIfCntrVOs().get(i).setSrcIfDt(srcIfDt);
						genIfVo.getInvArIfCntrVOs().get(i).setSrcIfSeq(srcIfSeq);
					}					
					dbDao.addInterfaceContainer(genIfVo.getInvArIfCntrVOs());
				}		
				
				invArIfMnVO = dbDao.searchInvArIfMain(srcIfDt, srcIfSeq);
				log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>searchInvArIfMain");
				invArIfChgVOs = dbDao.searchInvArIfChg(srcIfDt, srcIfSeq);
				log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>searchInvArIfChg");
				invArIfCntrVOs = dbDao.searchInvArIfCntr(srcIfDt, srcIfSeq);
				log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>searchInvArIfCntr");
				
				genIfVoDb.setInvArIfMnVO(invArIfMnVO);
				log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>invArIfMnVO");
				genIfVoDb.setInvArIfChgVOs(invArIfChgVOs);
				log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>invArIfChgVOs");
				genIfVoDb.setInvArIfCntrVOs(invArIfCntrVOs);				
				log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>invArIfCntrVOs");
				genIfVosDb.add(genIfVoDb);
				log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>genIfVoDb");
		    
			}
		
		} catch(DAOException ex) {
			log.error("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>interfaceGeneralARInvoiceToIF err" + ex.getMessage());
			throw new EventException(new ErrorHandler("INV00053",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>interfaceGeneralARInvoiceToIF err" + ex.getMessage());
			throw new EventException(new ErrorHandler("INV00053",new String[]{}).getMessage(), ex);
		}	
		
		//return genIfVos;
		return genIfVosDb;
	}
		
	/**
	 * Creation information by DEM, DET, TPB, MNR, LSE Interface information. <br>
	 * 
	 * @param List<ARInterfaceCreationVO> genIfVos
	 * @return String
	 * @exception EventException
	 */
	public String interfaceGeneralARInvoiceToINV(List<ARInterfaceCreationVO> genIfVos) throws EventException {
			
		INVCommonUtil utilCmd = new INVCommonUtil();
		InvoiceIssueBC invoiceIssueBC = new InvoiceIssueBCImpl();
		BookingARCreationBC bookingARCreationBC = new BookingARCreationBCImpl();
		ManualARCreationBC manualARCreationBC = new ManualARCreationBCImpl();
		AccountReceivableOutstandingBC arOtsBC = new AccountReceivableOutstandingBCImpl();
		
		VVDCustomerVO vvdCustomerVo = null;
		ExchangeRateVO exchangeRateVo = null;
		
		ARInterfaceCreationVO genIfVo = null;
		
		String errFlag = "N";
			
		String srcIfDt = "";
		String srcIfSeq = "";
		String ifFlag = "";
			
		String localTime = "";
		
		MdmOrganizationVO mdmOrgVo = null;
        String rhq = "";
        String arOfcCd = "";
        String lclCurr = "";
        //String fxCurrRt = "";
        //String repCustCntCd = "";
        //String repCustSeq = "";
        //String ofcAgentMark = "";
        //String ofcArControl = "";
        String invCoaCtrCd = "";
        String dmdtInvAplyBlFlg = "N";
        String arInvIssFlg = "N";
        //String otsSmryCd = "";
		
		BkgVvdVO bkgVvdVo = null;
		String vslCd = ""; ///// Main
		String skdVoyNo = ""; ///// Main
		String skdDirCd = ""; ///// Main
		String port = ""; ///// Main
				
		String trnkSkdVoyNo = ""; ///// Main
		String trnkVslCd = ""; ///// Main
		String trnkSkdDirCd = ""; ///// Main
		
		String sailDt = ""; ///// Main
				
        MdmCustomerVO mdmCustVo = null;
        
        String rgnCdPor = "";
        String rgnCdDel = "";
        String svcScpCd = "";
        
        String usdXchRt = "0";
        
        VskVslPortSkdVO vskVslPortSkdVo = null;        
        String sailArrDt = "";
        String slanCd = "";
        
//        MdmCrCustVO mdmCrCustVo = null;
//        String crFlg = "";
//        String crTerm = "0";
        
        DueDateVO dueDateVo = null;
        String dueDt = "";
        // -- modify : 2009.12.23(0->"") -----------------------------------------
        String crTermDys = "";
        // ------------------------------------------------------------------------
        String custCrFlg = "N";
        
        String destTrnsSvcModCd = "";
        
        String mriMaxYymm = "";
        String svrId = "";
        String glEffDt = "";
        String blInvCfmDt = "";
        
        String taxInd = "0";
        
        String zoneIoc = "";
        
        String revLane = "";
        String revVvd = "";
        
        String tVslCd = "";
        
        String locCd = "";
        
        String blObrdDt = "";

        String subsCoCd = "";
        
        String repChgCd = "";		
        String chgFullNm = "";	
        String erpIfOfcCd = "";
        REVTypeSourceVO revTypeSrcVo = null;
        String revTpCd = "M";
        String revSrcCd = "TM";
        String invRevTpSrcCd = "";
        String revCoaCoCd = "";
		String revCoaRgnCd = "";
		String revCoaCtrCd = "";
        String invXchRt = "0";
        String invUsdXchRt = "0";
        String invAcctDivCd = "";		
        String acctCd = "";
        String tjSrcNm = "";
        
        MRIRevenueVVDLaneVO mriRevVvdLaneVo = null;
        
        InvArMnVO invArMnVo = null;
        String arIfNo = "";
        StringBuffer arIfNos = new StringBuffer("");
        
        String invCoaRgnCd = "";
        
        List<InvArChgVO> invArChgVos = null;
        InvArChgVO invArChgVo = null;
        
        List<InvArCntrVO> invArCntrVos = null;
        InvArCntrVO invArCntrVo = null;
        
		StringBuffer cntrNosSb = new StringBuffer("");
		String cntrNos = "";
		int lastIdx = 0;
		
		InvArAmtVO invArAmtVo = null;
		
		String bkgNo = "";
		String errRsn = "";
		//String dueDtYn = "N";
		//String cntCd = "";
        String ofcCd = "";
        
        ARCreditVO aRCreditVO = new ARCreditVO();
        ARCreditInputVO arCrdtVo = new ARCreditInputVO();
        
        String tsDivCd = "";
        
        String ofcTrnsFlg = "";
        String ioBndCd = "";
        String porCd = "";
        String polCd = "";
        String podCd = "";
        String delCd = "";

		try {
			// genIfVos looping start
			for (int rowNum = 0; rowNum < genIfVos.size(); rowNum++) { 
				genIfVo = genIfVos.get(rowNum);
				
				srcIfDt = genIfVo.getInvArIfMnVO().getSrcIfDt();
				srcIfSeq = genIfVo.getInvArIfMnVO().getSrcIfSeq();	
				
				vslCd = genIfVo.getInvArIfMnVO().getVslCd() != null ? genIfVo.getInvArIfMnVO().getVslCd() : ""; ///// Main
				skdVoyNo = genIfVo.getInvArIfMnVO().getSkdVoyNo() != null ? genIfVo.getInvArIfMnVO().getSkdVoyNo() : ""; ///// Main
				skdDirCd = genIfVo.getInvArIfMnVO().getSkdDirCd() != null ? genIfVo.getInvArIfMnVO().getSkdDirCd() : ""; ///// Main
				port = genIfVo.getInvArIfMnVO().getIoBndCd().equals("O") ? genIfVo.getInvArIfMnVO().getPolCd() : genIfVo.getInvArIfMnVO().getPodCd(); ///// Main
				trnkSkdVoyNo = genIfVo.getInvArIfMnVO().getTrnkSkdVoyNo() != null ? genIfVo.getInvArIfMnVO().getTrnkSkdVoyNo() : ""; ///// Main
				trnkVslCd = genIfVo.getInvArIfMnVO().getTrnkVslCd() != null ? genIfVo.getInvArIfMnVO().getTrnkVslCd() : ""; ///// Main
				trnkSkdDirCd = genIfVo.getInvArIfMnVO().getTrnkSkdDirCd() != null ? genIfVo.getInvArIfMnVO().getTrnkSkdDirCd() : ""; ///// Main
				rgnCdPor = genIfVo.getInvArIfMnVO().getPorCd();
		        rgnCdDel = genIfVo.getInvArIfMnVO().getDelCd();
		        svcScpCd = genIfVo.getInvArIfMnVO().getSvcScpCd();
		        sailArrDt = genIfVo.getInvArIfMnVO().getSailArrDt();
		        slanCd = genIfVo.getInvArIfMnVO().getSlanCd();
		        dueDt = genIfVo.getInvArIfMnVO().getDueDt();
		        glEffDt = genIfVo.getInvArIfMnVO().getGlEffDt();
		        bkgNo = genIfVo.getInvArIfMnVO().getBkgNo() != null ? genIfVo.getInvArIfMnVO().getBkgNo() : "";		        
		        tsDivCd = genIfVo.getInvArIfMnVO().getDestTrnsSvcModCd()!= null ? genIfVo.getInvArIfMnVO().getDestTrnsSvcModCd(): "";
		      
		        ofcTrnsFlg = genIfVo.getInvArIfMnVO().getOfcTrnsFlg()!= null ? genIfVo.getInvArIfMnVO().getOfcTrnsFlg(): "";
		        ioBndCd = genIfVo.getInvArIfMnVO().getIoBndCd()!= null ? genIfVo.getInvArIfMnVO().getIoBndCd(): "";
		        porCd = genIfVo.getInvArIfMnVO().getPorCd()!= null ? genIfVo.getInvArIfMnVO().getPorCd(): "";
		        polCd = genIfVo.getInvArIfMnVO().getPolCd()!= null ? genIfVo.getInvArIfMnVO().getPolCd(): "";
		        podCd = genIfVo.getInvArIfMnVO().getPodCd()!= null ? genIfVo.getInvArIfMnVO().getPodCd(): "";
		        delCd = genIfVo.getInvArIfMnVO().getDelCd()!= null ? genIfVo.getInvArIfMnVO().getDelCd(): "";
		        
		        
				if(genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET")){
					int dupCnt = dbDao.searchLastDMTInvNo(genIfVo.getInvArIfMnVO().getBlSrcNo(), genIfVo.getInvArIfMnVO().getInvSrcNo());
					
					if( dupCnt > 0 ){
						errRsn =  new ErrorHandler("INV00052", new String[] {}).getUserMessage();
						dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
						errFlag = "Y";
						break;		
					}
				}
				
				// genIfVo looping start
				for (int idx = 0; idx < 1; idx++) {
					
					
					if (genIfVo.getInvArIfMnVO().getOfcCd().equals("")) {
						errRsn = new ErrorHandler("INV00075", new String[] {}).getUserMessage();
						dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
						errFlag = "Y";
						break;						
					}					
					
					if (bkgNo.equals("") && (genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET"))) {
						errRsn = new ErrorHandler("INV00003", new String[] {}).getUserMessage();
						dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
						errFlag = "Y";
						break;						
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
                            	errRsn = new ErrorHandler("INV00072", new String[] {}).getUserMessage();
                            	cnt++;
                            }
                            
                            if (currCd.equals("") || currCd.equals("0")) {
                            	errRsn = new ErrorHandler("INV00072", new String[] {}).getUserMessage();
                            	cnt++;
                            }
						 	
                            
                            if (trfRtAmt.equals("") || trfRtAmt.equals("0")) {
                            	errRsn = new ErrorHandler("INV00072", new String[] {}).getUserMessage();
                            	cnt++;
                            }
                            
                            if (ratAsCntrQty.equals("") || ratAsCntrQty.equals("0")) {
                            	errRsn = new ErrorHandler("INV00072", new String[] {}).getUserMessage();
                            	cnt++;
                            }
                            
                            if (chgAmt.equals("") || chgAmt.equals("0")) {
                            	errRsn = new ErrorHandler("INV00072", new String[] {}).getUserMessage();
                            	cnt++;
                            }	
							
						}
						
						
						if (cnt > 0) {
							
							dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
							errFlag = "Y";
							break;
						
						}
					
					}
					
					
					// bl_no exist check
					// charge exist check
					ifFlag = dbDao.searchInterfaceMain(srcIfDt, srcIfSeq);
					
					if (ifFlag.equals("NO_BL")) {
						// Error check #1
						errRsn = new ErrorHandler("INV00003", new String[] {}).getUserMessage();
						dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
						errFlag = "Y";
						break;
						
					} else if (ifFlag.equals("NO_CHG")) {
						// Error check #2
						errRsn = new ErrorHandler("INV00177", new String[] {}).getUserMessage();
						dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
						errFlag = "Y";
						break;
					}
					
					localTime = dbDao.searchLocalTime(genIfVo.getInvArIfMnVO().getOfcCd());
					
					mdmOrgVo = dbDao.searchOfficeAttribute(genIfVo.getInvArIfMnVO().getIfSrcCd(), genIfVo.getInvArIfMnVO().getOfcCd());
					// -- Add : 2009.12.22 ------------------------------------------------
					if(mdmOrgVo == null) {
						errRsn = new ErrorHandler("INV00075", new String[] {}).getUserMessage();
						dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
						errFlag = "Y";
						break;
					}
					// ------------------------------------------------------------------------
					
					
			        rhq = mdmOrgVo.getArHdQtrOfcCd(); ///// Main
			        lclCurr = mdmOrgVo.getArCurrCd(); ///// Main
			        arOfcCd = mdmOrgVo.getOfcCd();
			        //ofcAgentMark = mdmOrgVo.getArAgnStlCd();
			        dmdtInvAplyBlFlg = mdmOrgVo.getDeltFlg();
			        arInvIssFlg = mdmOrgVo.getSubAgnFlg();
			        //otsSmryCd = mdmOrgVo.getOfcSlsDeltFlg();
			        //cntCd = mdmOrgVo.getLocCd().substring(0,2);
			        	
			       
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
					
					sailDt = genIfVo.getInvArIfMnVO().getSailDt() == null ? "" : genIfVo.getInvArIfMnVO().getSailDt();
					if (sailDt.equals("")) {
						sailDt = dbDao.searchSailingDateByVvd(vslCd, skdVoyNo, skdDirCd, port);
						
					}
					
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
					
					if (vslCd.equals("CFDR") || vslCd.equals("USAC")) {
						sailDt = localTime;
					} 
										
					// mdmOrgVo.getSoIfCd() checking
					mdmCustVo = dbDao.checkCustomer(mdmOrgVo, genIfVo.getInvArIfMnVO().getCustCntCd(), genIfVo.getInvArIfMnVO().getCustSeq());
					
					if (mdmCustVo == null) {
						errRsn = new ErrorHandler("INV00008", new String[] {}).getUserMessage();
						dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
						errFlag = "Y";
						break;
					} 
					
					if (genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET")){
						
						if (ioBndCd.equals("O")) {
							vskVslPortSkdVo = dbDao.searchSaDtLaneOb(genIfVo.getInvArIfMnVO());
						} else if (ioBndCd.equals("I")) {
							vskVslPortSkdVo = dbDao.searchSaDtLaneIb(genIfVo.getInvArIfMnVO());
						}
						
						if (vskVslPortSkdVo != null) {
					        sailArrDt = sailArrDt.equals("")?vskVslPortSkdVo.getVpsEtbDt():sailArrDt; ///// Main
					        slanCd = slanCd.equals("")?vskVslPortSkdVo.getSlanCd():slanCd; ///// Main
						} else {							
							vskVslPortSkdVo = dbDao.searchSaDtLane(localTime); 
							sailArrDt = sailArrDt.equals("")?vskVslPortSkdVo.getVpsEtbDt():sailArrDt;
					        slanCd = slanCd.equals("")?vskVslPortSkdVo.getSlanCd():slanCd;
						}					
						
					}
					
					// 2015.08.12 add
					svcScpCd = dbDao.searchBKGSvcScp(bkgNo);
					
					if (svcScpCd.equals("")) {
						
						rgnCdPor = dbDao.searchRgnCd(porCd); ///// Main 					
						rgnCdDel = dbDao.searchRgnCd(delCd); ///// Main					
						svcScpCd = dbDao.searchSvcScp(rgnCdPor, rgnCdDel, slanCd); ///// Main
										
						if (svcScpCd.equals("")) {
							if (genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET")){
								// Add : 2010.02.03
								if(vslCd.equals("CFDR") || vslCd.equals("CNTC")) {
									svcScpCd = "OTH";
								} else {
									// error #6
									errRsn = new ErrorHandler("INV00179", new String[] {}).getUserMessage();
									dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
									errFlag = "Y";
									break;
								}
							} else {
								// If value is not DEM/DET, OTH
								svcScpCd = "OTH";
							}											
						}				
					}
					
					//add 2016.04.01
					if(vslCd.equals("CFDR") || vslCd.equals("CNTC")) {
						svcScpCd = "OTH";
					}
					
					arCrdtVo.setActCustCntCd(genIfVo.getInvArIfMnVO().getCustCntCd());
					arCrdtVo.setActCustSeq(genIfVo.getInvArIfMnVO().getCustSeq());
					arCrdtVo.setArOfcCd(genIfVo.getInvArIfMnVO().getOfcCd());
					if (genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET")){
						arCrdtVo.setSailArrDt(sailArrDt);
					} else {
						arCrdtVo.setSailArrDt(genIfVo.getInvArIfMnVO().getSailArrDt());
					}
					arCrdtVo.setIoBndCd(ioBndCd);
					arCrdtVo.setLocCd(mdmOrgVo.getLocCd());
					arCrdtVo.setDelCd(delCd);
					
					aRCreditVO = bookingARCreationBC.searchARCredit(arCrdtVo);
						
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
											
					}
					
					svrId = dbDao.searchSeverId(genIfVo.getInvArIfMnVO().getOfcCd()); 
					// MAIN currency converter
					if (genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET")){
						
						// If lcl_curr is USD, '1'
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
							exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);
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
							// ------------------------------------------------------------------------
						}
					
						/* 2014.11.26 DMT 에서 넘어오는 Due Date 는 그대로 유지
						if (dmdtInvAplyBlFlg.equals("Y")) {						
							dueDateVo = dbDao.searchDueDtForMaxINVInterface(genIfVo.getInvArIfMnVO().getInvSrcNo(), genIfVo.getInvArIfMnVO().getOfcCd()); ///// Main						
						}else{
							dueDateVo = dbDao.searchDueDtForMaxINVInterface(genIfVo.getInvArIfMnVO().getBlSrcNo(), genIfVo.getInvArIfMnVO().getOfcCd());
						}
						*/
						
						if (dueDateVo != null) {
							//dueDtYn = "Y";
							dueDt = dueDateVo.getDueDt(); ///// Main
							crTermDys = dueDateVo.getCrTermDys(); ///// Main
	                        custCrFlg = dueDateVo.getCustCrFlg(); ///// Main
						} /*else {
							//dueDtYn = "N";
						}*/
												
						destTrnsSvcModCd = dbDao.searchDestSVCModeCode(bkgNo); ///// Main
						
						if(dueDt.equals("")) {
					    	dueDt = dbDao.searchCreditCustomerForCredit(genIfVo.getInvArIfMnVO(), sailArrDt);
					          
				    	     if (dueDt.equals("") || crTermDys.equals("0")) {
				    		     dueDt = dbDao.searchOfficeForCredit(genIfVo.getInvArIfMnVO(), sailArrDt);
				    		     
				    	     }
					    }
					       
						
					} else {
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
						
						
						if (lclCurr.equals("USD")) {
							usdXchRt = "1"; ///// Chg
						} else {
							usdXchRt = dbDao.searchUsdXchRtByAcctMonth(localTime, lclCurr);
						}
					}
					
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
										
			        revTypeSrcVo = dbDao.searchREVTypeSource(genIfVo.getInvArIfMnVO().getIfSrcCd());
			        if (revTypeSrcVo != null) {
				        revTpCd = revTypeSrcVo.getRevTpCd();
				        revSrcCd = revTypeSrcVo.getRevSrcCd();
			        }    
			        
			        if (!revSrcCd.equals("TM") && !glEffDt.equals("")) {
			        	blInvCfmDt = localTime;
			        } 
			        
					zoneIoc = dbDao.searchZoneIOC(polCd, podCd); ///// Main
					
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
					
					
			        locCd = dbDao.searchCityCd(arOfcCd); ///// Main
					
			        if (!bkgNo.equals("")) { 
			        	blObrdDt = dbDao.searchBLOnDate(bkgNo); ///// Main
			        }
					
					subsCoCd = dbDao.searchInterCompany(genIfVo.getInvArIfMnVO().getCustCntCd(), genIfVo.getInvArIfMnVO().getCustSeq()); ///// Main
					
					
	
					
				} // genIfVo looping end
				
				// TML start
				
				if (errFlag.equals("Y")) {					
					break;
				}
							
				// AR_IF_NO
				ofcCd = genIfVo.getInvArIfMnVO().getOfcCd();
				arIfNo = manualARCreationBC.searchMRIInterfaceNo(ofcCd);
				
				
				if (arIfNo.equals("")) {
					manualARCreationBC.addMRIInterfaceNo(ofcCd, genIfVo.getInvArIfMnVO().getIfSrcCd().substring(0, 2)+"_IF");
					
					arIfNo = ofcCd.substring(0, 3) + 'M' + String.valueOf(DateTime.getYear()).substring(2, 4) + "00001";

				} else {
					manualARCreationBC.modifyMRIInterfaceNo(ofcCd, arIfNo, genIfVo.getInvArIfMnVO().getIfSrcCd().substring(0, 2)+"_IF");
				}
				// ------------------------------------------------------------------------
				
				//arIfNos = arIfNos + arIfNo + ((rowNum == 0 && genIfVos.size() == 2)? "|" : "");		
				arIfNos.append(arIfNo).append(((rowNum == 0 && genIfVos.size() == 2)? "|" : ""));
				
				//////////////////////////////////////////////////
				// INV_AR_CHG information setting
				
		        int seq = 1;
		        
		        int ifSalar = 0;
		        int ifNonre = 0;
		        int ifMriar = 0;
		        int ifOther = 0;
		        int ifVat = 0;
		        int ifWhf = 0;
		        int ifCtt = 0;
		        int if3rd = 0;
		        int ifXxx = 0;
		         
		        int erpSalar = 0;
		        int erpNonre = 0;
		        int erpMriar = 0;
		        int erpOther = 0;
		        int erpVat = 0;
		        int erpWhf = 0;
		        int erpCtt = 0;
		        int erp3rd = 0;
		        int erpXxx = 0;
		        
		        
		        String curr_cd = "";
		        String apArOffstNo = "";
		        
		        InvArChgVO invChgeVo = null;
		        InvArMnVO invArMnVo2 = new InvArMnVO();
		        invArMnVo2.setArOfcCd(genIfVo.getInvArIfMnVO().getOfcCd());
		        invArMnVo2.setRevTpCd(revTpCd);
		        invArMnVo2.setRevSrcCd(revSrcCd);
		        
				if (genIfVo.getInvArIfChgVOs() != null) {
					
					invArChgVos = new ArrayList<InvArChgVO>();
					
					// invArIfChgVOs looping start
					for (int rowNum2 = 0; rowNum2 < genIfVo.getInvArIfChgVOs().size(); rowNum2++) {
						
						invArChgVo = new InvArChgVO();
						
						repChgCd = dbDao.searchRepCharge(genIfVo.getInvArIfChgVOs().get(rowNum2).getChgCd());  ///// Chg	
						chgFullNm = dbDao.searchChargeName(genIfVo.getInvArIfChgVOs().get(rowNum2).getChgCd()); ///// Chg

						if(chgFullNm.equals("")) {
							chgFullNm = genIfVo.getInvArIfChgVOs().get(rowNum2).getChgFullNm();
						}
							
						if (erpIfOfcCd.equals("")) {
							erpIfOfcCd = genIfVo.getInvArIfMnVO().getOfcCd();
						}
						
						if (genIfVo.getInvArIfMnVO().getIfSrcCd().equals("TPB")) {
							
							acctCd = genIfVo.getInvArIfChgVOs().get(rowNum2).getChgRmk();
							
							/* 2015.02.06 block
							if (acctCd.equals("")) {
								// Error #9
								errRsn = new ErrorHandler("INV00166", new String[] {}).getUserMessage();
								dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
								errFlag = "Y";
								break;
							}
							*/
							
							invChgeVo = dbDao.searchInvRevTpSrcCd(genIfVo.getInvArIfChgVOs().get(rowNum2).getChgCd(), invArMnVo2, svrId, acctCd);
							
							invArChgVo.setRevCoaAcctCd(invChgeVo.getRevCoaAcctCd());
							
							invRevTpSrcCd = invChgeVo.getInvRevTpSrcCd(); 
							revCoaCoCd = invChgeVo.getRevCoaCoCd();
							revCoaRgnCd = invChgeVo.getRevCoaRgnCd();
							revCoaCtrCd = invChgeVo.getRevCoaCtrCd();
													
							
						} else if (!genIfVo.getInvArIfMnVO().getIfSrcCd().equals("TPB") && !genIfVo.getInvArIfMnVO().getIfSrcCd().equals("TML")){
							
							invAcctDivCd = dbDao.searchAccountDivision(revTpCd, revSrcCd); 
							
							if (invAcctDivCd.equals("P")) {
								acctCd = dbDao.searchAccountCdFromCharge(genIfVo.getInvArIfChgVOs().get(rowNum2).getChgCd()); ///// Chg
							} else {
								acctCd = dbDao.searchAccountCdFromRevAcct(genIfVo.getInvArIfChgVOs().get(rowNum2).getChgCd()); 
							}
							
							acctCd = dbDao.searchAccountCdConversion(arOfcCd, genIfVo.getInvArIfChgVOs().get(rowNum2).getChgCd(), revTpCd, revSrcCd, svrId, acctCd);

							/* 2015.02.06 block
							if (acctCd.equals("")) {
								// Error #9
								errRsn = new ErrorHandler("INV00166", new String[] {}).getUserMessage();
								dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
								errFlag = "Y";
								break;
							}
							*/
														
							invChgeVo = dbDao.searchInvRevTpSrcCd(genIfVo.getInvArIfChgVOs().get(rowNum2).getChgCd(), invArMnVo2, svrId, acctCd);
							
							invArChgVo.setRevCoaAcctCd(invChgeVo.getRevCoaAcctCd());
							
							invRevTpSrcCd = invChgeVo.getInvRevTpSrcCd(); 
							revCoaCoCd = invChgeVo.getRevCoaCoCd();
							revCoaRgnCd = invChgeVo.getRevCoaRgnCd();
							revCoaCtrCd = invChgeVo.getRevCoaCtrCd();
							
						}
												
											
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

						exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo); ////////////////////////////////////////////////////////////////
						
						
						// CHARGE currency converter
						if (exchangeRateVo != null 
							&& (genIfVo.getInvArIfChgVOs().get(rowNum2).getInvXchRt().equals("0") || genIfVo.getInvArIfChgVOs().get(rowNum2).getInvXchRt().equals(""))
							&& genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET")) {															
							
							if (genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd().equals(lclCurr)) {
								invXchRt = "1";
							} else {
								invXchRt = exchangeRateVo.getExRate();	
							}

							if (invXchRt.equals("0")||invXchRt.equals("")|invXchRt==null){
									invXchRt = utilCmd.searchAccountRate(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd(), lclCurr, localTime.length()==8?localTime.substring(0,6):"");									
							}
														
						} else { 
							invXchRt = utilCmd.searchAccountRate(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd(), lclCurr, localTime.length()==8?localTime.substring(0,6):"");
							if(invXchRt.equals("")){
								invXchRt = genIfVo.getInvArIfChgVOs().get(rowNum2).getInvXchRt();
							}
						}
							
						//Add USD_XCH_RT in INV_AR_CHG table - 2015.03.04 /////////// START
						vvdCustomerVo.setLclCurr("USD");
						
						exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo); ////////////////////////////////////////////////////////////////
						
						// CHARGE currency converter
						if (exchangeRateVo != null 
							&& genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET")) {															
							
							invUsdXchRt = exchangeRateVo.getExRate();	

							if (invUsdXchRt.equals("0")||invUsdXchRt.equals("")|invUsdXchRt==null){
								invUsdXchRt = utilCmd.searchAccountRate(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd(), "USD", localTime.length()==8?localTime.substring(0,6):"");									
							}
														
						} else { 
							invUsdXchRt = utilCmd.searchAccountRate(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd(), "USD", localTime.length()==8?localTime.substring(0,6):"");
						}
						//Add USD_XCH_RT in INV_AR_CHG table - 2015.03.04 /////////// END
						
						tjSrcNm = dbDao.searchTjSrcNm(arOfcCd, genIfVo.getInvArIfChgVOs().get(rowNum2).getChgCd(), revTpCd, revSrcCd, svrId);

						invArChgVo.setArIfNo(arIfNo);
						invArChgVo.setChgSeq(Integer.toString(rowNum2 + 1));
						invArChgVo.setChgCd(genIfVo.getInvArIfChgVOs().get(rowNum2).getChgCd());
						invArChgVo.setTjSrcNm(tjSrcNm);
						invArChgVo.setOfcCd(arOfcCd);
						
						////////////////////////////////////////////////////////////////////////
						///// AR_IF_SER_NO creation
						
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
						
						////////////////////////////////////////////////////////////////////////
						////////////////////////////////////////////////////////////////////////
							
						
							invArChgVo.setRepChgCd(repChgCd);                                                           
							invArChgVo.setChgFullNm(chgFullNm);    

							//2015.07.01 OTS Summary 에 관계없이 Issue Flag 찍히도록 수정 by IY Cho
							if((arInvIssFlg.equals("N")) || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("LSE")) {
							 //  (!genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") &&
							 //   !genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET") &&
							 //   !genIfVo.getInvArIfMnVO().getIfSrcCd().equals("TPB"))) {

								invArChgVo.setInvIssFlg("Y");         
							} else {
								invArChgVo.setInvIssFlg("N");   
							}

							invArChgVo.setRevCoaInterCoCd(subsCoCd);                             
							invArChgVo.setRevCoaCtrCd(revCoaCtrCd);    
							
							/* 2015.02.09 block
							if (!acctCd.substring(0, 1).equals("4") && !acctCd.substring(0, 1).equals("7") && !acctCd.substring(0, 2).equals("51")) {
								invArChgVo.setRevCoaVslCd("0000");                                                                                                            
								invArChgVo.setRevCoaVoyNo("0000");                                                                                                                       
								invArChgVo.setRevCoaSkdDirCd("0");                                                                                                                      
								invArChgVo.setRevCoaDirCd("0");   
							} else { */
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
							//}		
							
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
							invArChgVo.setRevCoaCoCd(revCoaCoCd);  
							invArChgVo.setRevCoaRgnCd(revCoaRgnCd);						
							invArChgVo.setTvaFlg(genIfVo.getInvArIfChgVOs().get(rowNum2).getTvaFlg());

							if (genIfVo.getInvArIfMnVO().getIfSrcCd().equals("TPB")) {
								invArChgVo.setChgRmk("");
							} else {
								invArChgVo.setChgRmk(genIfVo.getInvArIfChgVOs().get(rowNum2).getChgRmk());
							}
							// ------------------------------------------------------------------------
							
							invArChgVo.setMnlFlg("N");                                                                                                                                                
							invArChgVo.setMfDivCd("N");                                                                                                                                              
							invArChgVo.setCreUsrId(genIfVo.getInvArIfChgVOs().get(rowNum2).getCreUsrId());                                                                                                                                     
							invArChgVo.setCreDt(genIfVo.getInvArIfChgVOs().get(rowNum2).getCreDt());                                                                                                                                          
							invArChgVo.setUpdUsrId(genIfVo.getInvArIfChgVOs().get(rowNum2).getUpdUsrId());                                                                                                                                     
							invArChgVo.setUpdDt(genIfVo.getInvArIfChgVOs().get(rowNum2).getUpdDt());              
							

						invArChgVo.setIfSrcCd(genIfVo.getInvArIfMnVO().getIfSrcCd());

						invArChgVos.add(invArChgVo);
					} // invArIfChgVOs looping end	
					
					if (errFlag.equals("Y")) {					
						break;
					}
										
					if (invArChgVos.size() > 0) {
						// INV_AR_CHG table save.	
						bookingARCreationBC.addOtherInvCharge(invArChgVos);
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
				if ((genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET")) && !port.equals("")) {
					if (ioBndCd.equals("O")) {
						invArMnVo.setPolCd(port); 
					} else {	
						invArMnVo.setPodCd(port);        
					}
				} 
				invArMnVo.setPorCd(porCd);  
				invArMnVo.setDelCd(delCd); 
				invArMnVo.setSvcScpCd(svcScpCd); 
				if(vslCd.equals("CNTC") || vslCd.equals("CFDR")) {
					invArMnVo.setSailArrDt(sailDt);
				} else {
					invArMnVo.setSailArrDt(sailArrDt);
				}
				invArMnVo.setSlanCd(slanCd); 
				invArMnVo.setDueDt(dueDt);
				invArMnVo.setCrTermDys(crTermDys);        
				invArMnVo.setCustCrFlg(custCrFlg);        
				invArMnVo.setDestTrnsSvcModCd(destTrnsSvcModCd); 
				invArMnVo.setGlEffDt(glEffDt);
				invArMnVo.setBlInvCfmDt(blInvCfmDt);
				invArMnVo.setZnIocCd(zoneIoc);
				invArMnVo.setRlaneCd(revLane); 
				if (revVvd.length() == 9) {
					invArMnVo.setRevVslCd(revVvd.substring(0,4)); 
					invArMnVo.setRevSkdVoyNo(revVvd.substring(4,8));        
					invArMnVo.setRevSkdDirCd(revVvd.substring(8,9));        
					invArMnVo.setRevDirCd(revVvd.substring(8,9));        
				} else if (revVvd.length() == 10) {
					invArMnVo.setRevVslCd(revVvd.substring(0,4)); 
					invArMnVo.setRevSkdVoyNo(revVvd.substring(4,8));        
					invArMnVo.setRevSkdDirCd(revVvd.substring(8,9));        
					invArMnVo.setRevDirCd(revVvd.substring(9,10));        
				}
				invArMnVo.setArCtyCd(locCd); 
				invArMnVo.setObrdDt(blObrdDt); 
				invArMnVo.setArTaxIndCd(taxInd);
				invArMnVo.setRevTpCd(revTpCd);
				invArMnVo.setRevSrcCd(revSrcCd);        
				invArMnVo.setUsdXchRt(usdXchRt);
				invArMnVo.setArOfcCd(arOfcCd);
				invArMnVo.setBkgCorrDt(genIfVo.getInvArIfMnVO().getBkgCorrDt());
				invArMnVo.setBkgCorrNo(genIfVo.getInvArIfMnVO().getBkgCorrNo());
				invArMnVo.setBkgFeuQty(genIfVo.getInvArIfMnVO().getBkgFeuQty());
				invArMnVo.setBkgNo(bkgNo);
				invArMnVo.setBkgRefNo(genIfVo.getInvArIfMnVO().getBkgRefNo());
				invArMnVo.setBkgTeuQty(genIfVo.getInvArIfMnVO().getBkgTeuQty());
				invArMnVo.setBlInvIfDt(genIfVo.getInvArIfMnVO().getBlInvIfDt());
				invArMnVo.setBlNo(genIfVo.getInvArIfMnVO().getBlNo());

				if ((genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET")) && dmdtInvAplyBlFlg.equals("Y")) {
					invArMnVo.setBlSrcNo(genIfVo.getInvArIfMnVO().getInvSrcNo());
				} else {
					invArMnVo.setBlSrcNo(genIfVo.getInvArIfMnVO().getBlSrcNo());
				}
				
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
				invArMnVo.setInvSrcNo(genIfVo.getInvArIfMnVO().getInvSrcNo());
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

				exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);
				
				if (genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET")){
					invArMnVo.setXchRtN3rdTpCd(exchangeRateVo.getThirdExrateType());
					invArMnVo.setXchRtUsdTpCd(exchangeRateVo.getUsdExrateType());
					invArMnVo.setXchRtDt(exchangeRateVo.getExRateDate());
					
					/*
					if(exchangeRateVo.getExRate().equals("")||exchangeRateVo.getExRate().equals("0")){
						invArMnVo.setXchRtN3rdTpCd("A");
						invArMnVo.setXchRtUsdTpCd("A");
					}
					*/
				}else{
					invArMnVo.setXchRtN3rdTpCd("A");
					invArMnVo.setXchRtUsdTpCd("A");
				}
				
				if (exchangeRateVo.getExRateDate() != null && exchangeRateVo.getExRateDate().length() >= 6) {
					invArMnVo.setAcctXchRtYrmon(exchangeRateVo.getExRateDate().substring(0, 6));
				} else {
					invArMnVo.setAcctXchRtYrmon(exchangeRateVo.getExRateDate());
				}
				invArMnVo.setInvClrFlg("N");

				if((arInvIssFlg.equals("N")) || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("LSE")) {
				   //(!genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") &&
				   // !genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET") &&
				   // !genIfVo.getInvArIfMnVO().getIfSrcCd().equals("TPB"))) {

					invArMnVo.setInvIssFlg("Y");
				} else {
					invArMnVo.setInvIssFlg("N");
				}
				
				invArMnVo.setInvSvcScpCd(svcScpCd);
				
				// If apArOffstNo is "" by Locl Charge, apArOffstNo setting.
				if(apArOffstNo.equals("")){
					apArOffstNo = genIfVo.getInvArIfMnVO().getApArOffstNo();
				}

				invArMnVo.setApArOffstNo(apArOffstNo);
				
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
				
				if(revVslCd2.equals("") || revSkdDirCd2.equals("") || revSkdVoyNo2.equals("") || sailArrDt2.equals("") || sailDt2.equals("") || dueDt2.equals("")
						|| xchRtN3rdTpCd2.equals("") || xchRtUsdTpCd2.equals("") || arCtyCd2.equals("") || glEffDt2.equals("") || actCustSeq2.equals("") || usdXchRt2.equals("")){
					invArMnVo.setBlInvCfmDt("");
				}

				bookingARCreationBC.addOtherInvMain(invArMnVo);				
								
				MdmOrganizationVO mdmOrganizationVO = new MdmOrganizationVO();
				mdmOrganizationVO = dbDao.searchInvCoaRgnInvCoaCtr(genIfVo.getInvArIfMnVO().getOfcCd()); 
				
				if (mdmOrganizationVO != null) {
					invCoaRgnCd = mdmOrganizationVO.getFincRgnCd();
					invCoaCtrCd = mdmOrganizationVO.getArCtrCd();
				}
				
				invArAmtVo = new InvArAmtVO();
				
				invArAmtVo.setArInvSrcCd("NISAR");
				invArAmtVo.setInvCoaCoCd("01");
				invArAmtVo.setInvCoaRgnCd(invCoaRgnCd);
				invArAmtVo.setInvCoaCtrCd(invCoaCtrCd);
				invArAmtVo.setInvCoaInterCoCd(subsCoCd);
				invArAmtVo.setInvCoaVslCd("0000");
				invArAmtVo.setInvCoaVoyNo("0000");
				invArAmtVo.setInvCoaSkdDirCd("0");
				invArAmtVo.setInvCoaRevDirCd("0");
				invArAmtVo.setErpIfGlDt(glEffDt);   
				invArAmtVo.setErpIfOfcCd(arOfcCd);
				
				/////////////////////////////////////////////////////////
				// INV_AR_AMT table save	
				bookingARCreationBC.addOtherInvAmount(arIfNo, svrId, invArMnVo, invArAmtVo);
								
				/////////////////////////////////////////////////////////
				/////////////////////////////////////////////////////////
				// INV_AR_CNTR information setting.
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
				
				// INV_AR_IF_MN Table AR_IF_NO update
				dbDao.modifyIfNo(srcIfDt, srcIfSeq, arIfNo, genIfVo.getInvArIfMnVO().getOfcCd(), genIfVo.getInvArIfMnVO().getUpdUsrId());
				
				///////////////////////////////////////////////////////////
				///////////////////////////////////////////////////////////
				// ISSUE process

				if((arInvIssFlg.equals("N")) || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("LSE")) {
				   //(!genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") &&
				   // !genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET") &&
				   // !genIfVo.getInvArIfMnVO().getIfSrcCd().equals("TPB"))) {

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
					
				}							

				//2014.07.07 AR OTS Creation
				List<InvArIfNoVO> ifNos = new ArrayList<InvArIfNoVO>();
				InvArIfNoVO invArIfNoVO = new InvArIfNoVO();
				invArIfNoVO.setIfNo(arIfNo);
				ifNos.add(invArIfNoVO);

				arOtsBC.createOutstandingInfo(ifNos);
				
			} // genIfVos looping end
			
			if (errFlag.equals("Y")) {
				return "E::"+errRsn;
			} else {
				return "S::"+arIfNos;
			}
						
		} catch(DAOException ex) {
			log.error("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>dao err:" + ex.getMessage());
			throw new EventException(new ErrorHandler("INV00053",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>exp err:" + ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * INV_AR_IF_MN Table retrieve <br>
	 * 
	 * @param String srcIfDt
	 * @param String srcIfSeq
	 * @return InvArIfMnVO
	 * @exception EventException
	 */
	public InvArIfMnVO searchInvArIfMain(String srcIfDt, String srcIfSeq) throws EventException {
		try {
			return dbDao.searchInvArIfMain(srcIfDt, srcIfSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * INV_AR_IF_CHG Table retrieve <br>
	 * 
	 * @param String srcIfDt
	 * @param String srcIfSeq
	 * @return List<InvArIfChgVO>
	 * @exception EventException
	 */
	public List<InvArIfChgVO> searchInvArIfChg(String srcIfDt, String srcIfSeq) throws EventException {
		try {
			return dbDao.searchInvArIfChg(srcIfDt, srcIfSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}	
	
	/**
	 * INV_AR_IF_CNTR Table retrieve <br>
	 * 
	 * @param String srcIfDt
	 * @param String srcIfSeq
	 * @return List<InvArIfCntrVO>
	 * @exception EventException
	 */
	public List<InvArIfCntrVO> searchInvArIfCntr(String srcIfDt, String srcIfSeq) throws EventException {
		try {
			return dbDao.searchInvArIfCntr(srcIfDt, srcIfSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}		
	
	/**
	 * INV_AR_MN Table delete <br>
	 * 
	 * @param String arIfNo
	 * @exception EventException
	 */
	public void removeArIfMain(String arIfNo) throws EventException {
		try {
			dbDao.removeArIfMain(arIfNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}	
	
	/**
	 * INV_AR_AMT Table delete <br>
	 * 
	 * @param String arIfNo
	 * @exception EventException
	 */
	public void removeArIfAmt(String arIfNo) throws EventException {
		try {
			dbDao.removeArIfAmt(arIfNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}	
	
	/**
	 * INV_AR_CHG Table delete <br>
	 * 
	 * @param String arIfNo
	 * @exception EventException
	 */
	public void removeArIfChg(String arIfNo) throws EventException {
		try {
			dbDao.removeArIfChg(arIfNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}	
	
	/**
	 * INV_AR_CNTR Table delete <br>
	 * 
	 * @param String arIfNo
	 * @exception EventException
	 */
	public void removeArIfCntr(String arIfNo) throws EventException {
		try {
			dbDao.removeArIfCntr(arIfNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}	
}