/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ManualARCreationBCImpl.java
*@FileTitle : Other Revenue Invoice Entry
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARInvoiceCreationVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArChgVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArCntrVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArMnVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration.ManualARCreationDBDAO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.BKGContainerVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.BKGInvoiceVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.BKGMainVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.BKGQtyVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.BKGRefNoVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.BKGTvvdPortVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.BKGVVDSaDtVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.CustomerDueDtVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.MRIInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.NonShippingARVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.NonShippingChargeVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.NonShippingInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.NonShippingListVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.NonShippingMainVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.RevenueAcctVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceChargeSumVO;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.ARCustomerVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * AccountReceivableInvoiceCreation Business Logic Basic Command implementation<br>
 * - AccountReceivableInvoiceCreation logic process<br>
 *
 * @author saeil kim
 * @see FNS_INV_0022EventResponse,ManualARCreationBC
 * @since J2EE 1.4
 */

public class ManualARCreationBCImpl extends BasicCommandSupport implements ManualARCreationBC {

	// Database Access Object
	private transient ManualARCreationDBDAO dbDao = null;

	/**
	 * ManualARCreationBCImpl object creation.<br>
	 * ManualARCreationDBDAO creation.<br>
	 */
	public ManualARCreationBCImpl() {
		dbDao = new ManualARCreationDBDAO();
	}
	
	/**
	 * Miscellaneous Revenue Invoice Entry Rev. Type screen retrieve event process<br>
	 * 
	 * @param String svrId
	 * @param String rhqCd
	 * @param String ofcCd
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchOfficeRevenueSourceList(String svrId, String rhqCd, String ofcCd) throws EventException {
		List<String> list = new ArrayList<String>();
 
		try {
		
//			IV
//			IC
//			svr_id = USA, SWA, EUR => + CT
//			ofc = rhq => + OC
//			terminal ofc => + TM
//			svr_id = KOR, JPN => + TN
//			svr_id = KOR => + WC
//			svr_id = USA => + EQ
//			svr_id = USA, EUR => + TS

//			list.add("IV");
//			list.add("IC");
//			if(svrId.equals("USA")||svrId.equals("SWA")||svrId.equals("EUR")){
//				list.add("CT");
//			}
//			if(ofcCd.equals(rhqCd)) {
//				list.add("OC");				
//			}
//			if(tmlInvIssFlg.equals("Y")){
//				list.add("TM");
//			}
//			if(svrId.equals("KOR")||svrId.equals("JPN")){
//				list.add("TN");
//			}
//			if(svrId.equals("KOR")){
//				list.add("WC");
//			}
//			if(svrId.equals("USA")){
//				list.add("EQ");
//			}
//			if(svrId.equals("USA")||svrId.equals("EUR")){
//				list.add("TS");
//			}
			
			log.info("\n########## rhqCd2 : "+rhqCd);
			log.info("\n########## ofcCd2 : "+ofcCd);
			log.info("\n########## svrId2 : "+svrId);
			
			list.add("IV");
			list.add("IC");
			list.add("OS");
			if (rhqCd.equals(ofcCd)) {
				list.add("OC");	
//
//				list.add("BN");	
			}
//			if(rhqCd.equals("KOR")||svrId.equals("JPN")){
//				list.add("TN");
//		    }
//			if(svrId.equals("KOR")&&ofcCd.substring(3,5).equals("BO")){
//				list.add("TN");
//		    }
//			if(rhqCd.equals("KOR")||svrId.equals("JPN")){
//				list.add("TN");
//		    }
//			if(svrId.equals("KOR")){
//				list.add("WC");
//			}
//			if (rhqCd.equals("HAMUR")||rhqCd.equals("NYCNA")) {
//				list.add("TS");				
//			}
//			if (rhqCd.equals("NYCNA")) {
//				list.add("EQ");				
//			}			
			
//			log.info("\n########## list.size() : "+list.size());
			
			return list;
			

			
		} catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
	    }
	}

	/**
	 * Miscellaneous Revenue Invoice Entry Rev. Type screen retrieve event process<br>
	 * 
	 * @param String svrId
	 * @param String ofcCd
	 * @param String blNo
	 * @param String locCd
	 * @return List<BKGInvoiceVO>
	 * @exception EventException
	 */
	public List<BKGInvoiceVO> searchBKGMaxInterface(String svrId, String ofcCd, String blNo, String locCd) throws EventException {
		//log.info("########## GeneralARInvoiceMasterDataMgtBCImpl");
		//DBRowSet rowSet = null;
		List<BKGInvoiceVO> list = new ArrayList<BKGInvoiceVO>();
		List<BKGContainerVO> list2 = new ArrayList<BKGContainerVO>();
		BKGInvoiceVO bkgInvoiceVo = null;

		try {
			
			log.info("\n########## svrId : "+svrId);
			
			if(svrId.equals("USA")||svrId.equals("KOR")||svrId.equals("JPN")){
				
				// Get same Country ar_ofc information				
				log.info("\n########## list1");
				list = dbDao.searchRHQGoodInvMaxInterface(blNo, locCd);
				
				if (list.size()>0) {
										
					list2 = dbDao.searchRHQGoodCntrMaxInterface(blNo, locCd);					
					bkgInvoiceVo = list.get(0);
					bkgInvoiceVo.setBkgContainerVo(list2);
					list.clear();
					list.add(bkgInvoiceVo);
					
				} else {
					
					log.info("\n########## list2");
					list = dbDao.searchRHQNoGoodInvMaxInterface(blNo, locCd);
					
					if (list.size()>0) {
						
						list2 = dbDao.searchRHQNoGoodCntrMaxInterface(blNo, locCd);					
						bkgInvoiceVo = list.get(0);
						bkgInvoiceVo.setBkgContainerVo(list2);
						list.clear();
						list.add(bkgInvoiceVo);
						
					} else {
						
						log.info("\n########## list3");
						list = dbDao.searchRHQInvMaxInterfacebyMRI(blNo, locCd);
						
						if (list.size()>0) {
							
							list2 = dbDao.searchRHQCntrMaxInterfacebyMRI(blNo, locCd);					
							bkgInvoiceVo = list.get(0);
							bkgInvoiceVo.setBkgContainerVo(list2);
							list.clear();
							list.add(bkgInvoiceVo);
							
						}
						
					}
					
				}
			
			} else {
				
				list = dbDao.searchOFCGoodInvMaxInterface(ofcCd, blNo);
				
				if (list.size()>0) {
					list2 = dbDao.searchOFCGoodCntrMaxInterface(ofcCd, blNo);
					
					bkgInvoiceVo = list.get(0);
					bkgInvoiceVo.setBkgContainerVo(list2);
					list.clear();
					list.add(bkgInvoiceVo);
				} else {
					
					list = dbDao.searchOFCNoGoodInvMaxInterface(ofcCd, blNo);
					
					if (list.size()>0) {
						list2 = dbDao.searchOFCNoGoodCntrMaxInterface(ofcCd, blNo);					
						bkgInvoiceVo = list.get(0);
						bkgInvoiceVo.setBkgContainerVo(list2);
						list.clear();
						list.add(bkgInvoiceVo);
						
					} else {
						
						list = dbDao.searchOFCInvMaxInterfacebyMRI(ofcCd, blNo);
						
						if (list.size()>0) {							
							list2 = dbDao.searchOFCCntrMaxInterfacebyMRI(ofcCd, blNo);					
							bkgInvoiceVo = list.get(0);
							bkgInvoiceVo.setBkgContainerVo(list2);
							list.clear();
							list.add(bkgInvoiceVo);
							
						}
						
					}
					
				}
				
			}
			
			return list;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		} catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
	    }
	}
	
	/**
	 * Miscellaneous Revenue Invoice Entry Rev. Type screen retrieve event process<br>
	 * 
	 * @param MRIInputVO mirInputVo
	 * @return List<BKGInvoiceVO>
	 * @exception EventException
	 */
	public List<BKGInvoiceVO> searchBKGNewInvoice(MRIInputVO mirInputVo) throws EventException {
		//log.info("########## GeneralARInvoiceMasterDataMgtBCImpl");
		//DBRowSet rowSet = null;
		List<BKGInvoiceVO> list = new ArrayList<BKGInvoiceVO>();
		List<BKGContainerVO> list2 = new ArrayList<BKGContainerVO>();
		BKGInvoiceVO bkgInvoiceVo = new BKGInvoiceVO();
		
		List<BKGMainVO> list11 = new ArrayList<BKGMainVO>();
		List<BKGVVDSaDtVO> list12 = new ArrayList<BKGVVDSaDtVO>();
		List<BKGTvvdPortVO> list13 = new ArrayList<BKGTvvdPortVO>();
		List<BKGQtyVO> list14 = new ArrayList<BKGQtyVO>();	
		List<BKGRefNoVO> list15 = new ArrayList<BKGRefNoVO>();	
		List<CustomerDueDtVO> list16 = new ArrayList<CustomerDueDtVO>();			
		
		String bl_no = mirInputVo.getBlno();
		String bkg_no = mirInputVo.getBkgno();	
		String bnd = mirInputVo.getBnd();
		String svr_id = mirInputVo.getSvrid();
		String ofc_cd = mirInputVo.getOfccd();
		
		log.info("########## bl_no : "+bl_no);
		log.info("########## bkg_no : "+bkg_no);	
		log.info("########## bnd : "+bnd);
		log.info("########## svr_id : "+svr_id);
		log.info("########## ofc_cd : "+ofc_cd);
		
		String portCd = "";
		String vslCd = "";
		String skdVoyNo = "";
		String skdDirCd = "";
		
		String porCd = "";     //
		String masterInv = ""; //
		String custRefNo1 = "";// 
		String custRefNo2 = "";// 
		String lclVvd = "";    //
		String custRefNo3 = "";// 
		String svcScpCd = "";  //
		String trunkVvd = "";  //
		String sailArrDt = ""; //
		//String pagerows = ""; 
		//String ibflag = ""; 
		String polCd = "";     //
		String bkgFeuQty = ""; //
		String invCustCntCd = ""; //
		String actCustCntCd = ""; //
		String dueDt = "";     //
		String blSrcNo = "";   //
		//String bkgNoSplit = "";//
		String invCustSeq = ""; //
		String actCustSeq = ""; //
		//String loclCurrCd = ""; 
		String delCd = "";     //
		//String ioBndCd = ""; 
		//String custCrFlg = ""; 
		String podCd = "";     //
		String bkgNo = "";     //
		String bkgTeuQty = ""; //	

		try {
				
			list11 = dbDao.searchBKGMain(bl_no, bkg_no); // 27
			
			if (list11.size() > 0) {
				bkgNo = list11.get(0).getBkgNo();
//				bkgNoSplit = list11.get(0).getBkgNoSplit();
		        
		        blSrcNo = list11.get(0).getBlSrcNo();
		        trunkVvd = list11.get(0).getTrunkVvd();
		        porCd = list11.get(0).getPorCd();
		        polCd = list11.get(0).getPolCd();
		        podCd = list11.get(0).getPodCd();
		        delCd = list11.get(0).getDelCd();
		        svcScpCd = list11.get(0).getSvcScpCd();
		        masterInv = list11.get(0).getMasterInv();
			}
			
	        portCd = dbDao.searchBKGPortCd(bkgNo, bnd); // 28	
	        
	        list12 = dbDao.searchBKGVVDSaDt(bkgNo, bnd , portCd); // 29	        
	        
	        if (list12.size() > 0) {
				vslCd = list12.get(0).getVslCd();
				skdVoyNo = list12.get(0).getSkdVoyNo();
				skdDirCd = list12.get(0).getSkdDirCd();
		        
				lclVvd = vslCd + skdVoyNo + skdDirCd;
				sailArrDt = list12.get(0).getSailArrDt();
	        }
	        
			if(vslCd.equals("")||skdVoyNo.equals("")||skdDirCd.equals("")||sailArrDt.equals("")||svr_id.equals("EUR")) {
				
				list13 = dbDao.searchBKGTvvdPortCd(bkgNo, bnd); // 31
				
				if (list13.size() > 0) {
					vslCd = list13.get(0).getVslCd();
					skdVoyNo = list13.get(0).getSkdVoyNo();
					skdDirCd = list13.get(0).getSkdDirCd();
					portCd = list13.get(0).getPortCd();
					
					lclVvd = vslCd + skdVoyNo + skdDirCd;
										
					sailArrDt = dbDao.searchBKGSaDtForTvvd(lclVvd, bnd, portCd); //32
								
					if(bnd.equals("O")){
						polCd = portCd;
						
					}else if(bnd.equals("I")){
						podCd = portCd;
					}		
				}
							
			}
			
			list14 = dbDao.searchBKGQuantity(bkgNo); // 33
			
			if (list14.size() > 0) {
				bkgTeuQty = list14.get(0).getBkgTeuQty();
				bkgFeuQty = list14.get(0).getBkgFeuQty();
			}
	        
			list15 = dbDao.searchBKGRefNo(bkgNo); // 34
			
			if (list15.size() > 0) {
				custRefNo1 = list15.get(0).getCustRefNo1();
				custRefNo2 = list15.get(0).getCustRefNo2();
				custRefNo3 = list15.get(0).getCustRefNo3();
			}
			
			list16 = dbDao.searchCustomerDueDt(ofc_cd, bnd, sailArrDt); // 35
			
			if (list16.size() > 0) {
				actCustCntCd = list16.get(0).getActCustCntCd();
				actCustSeq = list16.get(0).getActCustSeq();
				invCustCntCd = list16.get(0).getInvCustCntCd();
				invCustSeq = list16.get(0).getInvCustSeq();
				dueDt = list16.get(0).getDueDt();
			}
			
			list2 = dbDao.searchBKGContainerList(bkgNo); // 36			
			
			bkgInvoiceVo.setBkgNo(bkgNo);
//			bkgInvoiceVo.setBkgNoSplit(bkgNoSplit);
			bkgInvoiceVo.setBlSrcNo(blSrcNo);
			bkgInvoiceVo.setTrunkVvd(trunkVvd);
			bkgInvoiceVo.setPorCd(porCd);
			bkgInvoiceVo.setPolCd(polCd);
			bkgInvoiceVo.setPodCd(podCd);
			bkgInvoiceVo.setDelCd(delCd);
			bkgInvoiceVo.setSvcScpCd(svcScpCd);
			bkgInvoiceVo.setMasterInv(masterInv);
			bkgInvoiceVo.setLclVvd(lclVvd);
			bkgInvoiceVo.setSailArrDt(sailArrDt);
			bkgInvoiceVo.setBkgTeuQty(bkgTeuQty);
			bkgInvoiceVo.setBkgFeuQty(bkgFeuQty);
			bkgInvoiceVo.setCustRefNo1(custRefNo1);
			bkgInvoiceVo.setCustRefNo2(custRefNo2);
			bkgInvoiceVo.setCustRefNo3(custRefNo3);
			bkgInvoiceVo.setActCustCntCd(actCustCntCd);
			bkgInvoiceVo.setActCustSeq(actCustSeq);
			bkgInvoiceVo.setInvCustCntCd(invCustCntCd);
			bkgInvoiceVo.setInvCustSeq(invCustSeq);
			bkgInvoiceVo.setDueDt(dueDt);
			bkgInvoiceVo.setIoBndCd(bnd);
			
			bkgInvoiceVo.setBkgContainerVo(list2);

			list.add(bkgInvoiceVo);			
	        
			return list;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		} catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
	    }
	}	

	/**
	 * ManualARCreation screen retrieve event process<br>
	 * 
	 * @param String vsl
	 * @param String voy
	 * @param String dep
	 * @param String port
	 * @param String scp
	 * @exception EventException
	 */
	public void checkMiscellaneousAR(String vsl, String voy, String dep, String port, String scp) throws EventException {
		boolean checkSkd = false;
		boolean checkScp = false;
		boolean checkPort = false;	
		String errCode = "";
		
		try {
			checkSkd = dbDao.searchVesselSKD(vsl, voy, dep);

			if(checkSkd == true) {
				checkScp = dbDao.searchServiceScope(scp);

				if(checkScp == true || scp.equals("OTH")) {
					checkPort = dbDao.searchVesselPortSKD(vsl, voy, dep, port);
					
					if(checkPort == false){
						errCode = "INV00007";				
					}
					
				} else {
					errCode = "INV00006";
				}			
			
			} else {
				errCode = "INV00005";		
			}
						
			//return errCode;
			
			//log.info("\n########## errCode : "+errCode);
			
			if (!errCode.equals("")) {
				throw new EventException(new ErrorHandler(errCode,new String[]{}).getMessage());
			}	
			
		} catch (EventException ex) {	
			throw ex;	
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		} catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
	    }
		
	}		
	
	/**
	 * Retrieve event process<br>
	 *  Revenue Account code information's list retrieve<br>
	 * 
	 * @param  String glEffDt
	 * @return List<RevenueAcctVO>
	 * @exception EventException
	 */
	public List<RevenueAcctVO> searchRevenueAcctCdList(String glEffDt) throws EventException {
		try {
			return dbDao.searchRevenueAcctCdList(glEffDt);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		} catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
	    }
	}
	
	/**
	 * Retrieve event process<br>
	 *  Revenue Account code information's list retrieve<br>
	 * 
	 * @param  String glEffDt
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchRevenueAcctMaxEndDate(String glEffDt) throws EventException {
		try {
			return dbDao.searchRevenueAcctMaxEndDate(glEffDt);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		} catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
	    }
	}	
	
	/**
	 * Retrieve event process<br>
	 * searchDefaultDRRevAcct<br>
	 * 
	 * @param  String glEffDt
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchDefaultDRRevAcct(String glEffDt) throws EventException {
		try {
			return dbDao.searchDefaultDRRevAcct(glEffDt);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		} catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
	    }
	}	
	
	/**
	 * Closing's check<br>
	 * 
	 * @param String ofc
	 * @param String effDt
	 * @param String pgmGubn
	 * @return String
	 * @exception DAOException
	 */
	public String searchClosingStatus (String ofc, String effDt, String pgmGubn) throws EventException {
		try {
			return dbDao.searchClosingStatus(ofc, effDt, pgmGubn);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		} catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
	    }
	 }
	

	/**
	 * B/L No increment.<br>
	 * 
	 * @param String ofcCd
	 * @param String userId
	 * @return String
	 * @exception DAOException
	 */
	public String searchAutoBLNo (String ofcCd, String userId) throws EventException {
		String blMaxNo = null;
		String blMaxSeq = null;
		
		try {
			blMaxNo = dbDao.searchAutoBLNo(ofcCd);
		
	        blMaxSeq = blMaxNo.substring(9, 12);
			
			if (Integer.parseInt(blMaxSeq) == 1) {
				dbDao.addNewBLNo(ofcCd, blMaxNo, userId);
			}
			else {
				dbDao.modifyNewBLNo(ofcCd, blMaxNo, userId);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		} catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
	    }
		
		return blMaxNo;
	 }	
	
	/**
	 * Retrieve event process<br>
	 * Receivables information retrieve<br>
	 * 
	 * @param NonShippingInputVO mthVo
	 * @return List<NonShippingListVO>
	 * @exception EventException
	 */	
	public List<NonShippingListVO> searchNonShippingARList (NonShippingInputVO mthVo ) throws EventException {
		List<NonShippingListVO> resultVOs = null;
		try {
			resultVOs = dbDao.searchNonShippingARList(mthVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		} catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
	    }		
		return resultVOs;
	}
	
	
	/**
	 * Document number retrieve<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchSlipNo (String ofcCd) throws EventException {
		try {
			return dbDao.searchSlipNo(ofcCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		} catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
	    }
	 }
	
	/**
	 * Input I/F No's receivables information retrieve.<br>
	 * 
	 * @author JungJin Park
	 * @param String ifNo
	 * @return NonShippingARVO
	 * @exception DAOException
	 */
	public NonShippingARVO searchNonShippingARByIFNo (String ifNo) throws EventException {
		NonShippingARVO nonShippingARVO = new NonShippingARVO();
		NonShippingMainVO mainVO = null;
		List<NonShippingChargeVO> chargeListVOS = null;
		try {
			mainVO = dbDao.searchNonShippingARMain(ifNo);
			
			nonShippingARVO.setNonShippingMainVO(mainVO);
			
			chargeListVOS = dbDao.searchNonShippingARCharge(ifNo);
			
			nonShippingARVO.setNonShippingChargeVOS(chargeListVOS);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		} catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
	    }	
		
		return nonShippingARVO;
	 }
	 
	/**
	 * Retrieve event process<br>
	 * Customer information retrieve<br>
	 * 
	 * @param String ofcCd
	 * @param String blNo
	 * @return List<ARCustomerVO>
	 * @exception EventException
	 */
	public List<ARCustomerVO> searchBLCustomer (String ofcCd, String blNo) throws EventException {
		try {
			return dbDao.searchBLCustomer (ofcCd, blNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		} catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
	    }	
	}
	
	/**
	 * Interface retrieve event process<br>
	 * FnsInv0071Event event list retrieve event process<br>
	 * 
	 * @param String arIfNo
	 * @return ARInvoiceCreationVO
	 * @exception EventException
	 */	
	public ARInvoiceCreationVO searchMiscellaneousARByIFNo (String arIfNo) throws EventException {
		ARInvoiceCreationVO arInvCreVo = new ARInvoiceCreationVO();
		InvArMnVO invArMnVO = null;
		List<InvArChgVO> invArChgVOs = null;
		List<ARInvoiceChargeSumVO> arInvChgSumVOs = null;
		List<InvArCntrVO> invArCntrVOs = null;
		
		try {
			invArMnVO = dbDao.searchMiscellaneousARByIFNo(arIfNo);
			invArChgVOs = dbDao.searchMiscellaneousARChg(arIfNo);
			arInvChgSumVOs = dbDao.searchMiscellaneousARChgSum(arIfNo);
			invArCntrVOs = dbDao.searchMiscellaneousARCntr(arIfNo);
			
			arInvCreVo.setInvArMnVO(invArMnVO);
			arInvCreVo.setInvArChgVOs(invArChgVOs);
			arInvCreVo.setArInvChgSumVOs(arInvChgSumVOs);
			arInvCreVo.setInvArCntrVOs(invArCntrVOs);
			
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		} catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
	    }	
		
		return arInvCreVo;
	}
	
	/**
	 * INV_AR_MRI_IF_NO table MRI_MAX_SEQ retrieve. <br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchMRIInterfaceNo(String ofcCd) throws EventException {
		
		try {
			return dbDao.searchMRIInterfaceNo(ofcCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		} catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
	    }
	}
	
	/**
	 * INV_AR_MRI_IF_NO table MRI_MAX_SEQ insert <br>
	 * 
	 * @param String ofcCd
	 * @param String userId
	 * @exception DAOException
	 */
	public void addMRIInterfaceNo(String ofcCd, String userId) throws EventException {
		
		try {
			dbDao.addMRIInterfaceNo(ofcCd, userId);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		} catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
	    }
	}
	
	/**
	 * INV_AR_MRI_IF_NO table MRI_MAX_SEQ update <br>
	 * 
	 * @param String ofcCd
	 * @param String mriMaxSeq
	 * @param String userId
	 * @exception DAOException
	 */
	public void modifyMRIInterfaceNo(String ofcCd, String mriMaxSeq, String userId) throws EventException{
		
		try {
			dbDao.modifyMRIInterfaceNo(ofcCd, mriMaxSeq, userId);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		} catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
	    }
	}
	
	/**
	 * Local Time retrieve<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchLocalTime(String ofcCd) throws EventException {
		try {
			return dbDao.searchLocalTime(ofcCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		} catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
	    }
	}	
	
	/**
	 * office block charge retrieve<br>
	 * 
	 * @param String chgCd
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchBlckChg(String chgCd, String ofcCd) throws EventException {
		try {
			return dbDao.searchBlckChg(chgCd, ofcCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		} catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
	    }
	}	
	
	/**
	 * Retrieve event process<br>
	 * Checking port<br>
	 * 
	 * @param String port
	 * @exception EventException
	 */
	public void checkPort(String port) throws EventException {
		
		try {
			int portCnt = dbDao.checkPort(port);
			
			if(portCnt==0){
				throw new EventException(new ErrorHandler("INV00050",new String[]{}).getMessage());
			}
			
		}	catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	

	/**
	 * VLCBB MIC in case get IVA rate by input IFNo<br>
	 * 
	 * @param String mstIfNo
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchIvaRateMstIFNo(String mstIfNo, String ofcCd) throws EventException {
		
		try {
			return dbDao.searchIvaRateMstIFNo(mstIfNo, ofcCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * [FNS_INV_0071-01] 입력된 B/L No.이 Invoice Main 과 Booking Main 테이블에 존재하는지 체크한다.<br>
	 * 
	 * @param String bkgNo
	 * @return String (Y/N, Y:존재, N:존재하지않음)
	 * @exception EventException
	 */
	public String searchBlNoCntForMOS (String bkgNo) throws EventException {
		
		try {
			return dbDao.searchBlNoCntForMOS(bkgNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * [FNS_INV_0071-01] 입력된 Master Invoice No.가 Invoice Main 의 Original Invoice No.에 존재하는지 체크한다.<br>
	 * 
	 * @param String mstInvNo
	 * @param String arOfcCd
	 * @return String (Y/N, Y:존재, N:존재하지않음)
	 * @exception EventException
	 */
	public String searchMasterInvNo (String mstInvNo, String arOfcCd) throws EventException {
		
		try {
			return dbDao.searchMasterInvNo(mstInvNo, arOfcCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
		
	
}