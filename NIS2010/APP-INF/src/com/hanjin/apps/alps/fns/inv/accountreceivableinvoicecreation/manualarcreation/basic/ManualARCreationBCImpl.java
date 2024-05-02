/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ManualARCreationBCImpl.java
*@FileTitle : Other Revenue Invoice Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.04.27 김세일
* 1.0 Creation
* --------------------------------------------------------
* History
* 2010.09.16 최도순 [] MRI 생성시 SERVICE SCOPE 체크할때 OTH는 예외처리
* 2011.02.08 최도순 [CHM-201108232] DEM/DET 에서 INV로 INTERFACE 시 I/F NO 누락 방지를 위한 로직 변경
* 2011.11.14 오요한 [CHM-201113617] SVAT Reg. No for CMBSC
* 2011.11.23 권 민 [CHM-201114430-01] MRI 생성 관련 CREDIT TERM 로직 보완 요청
* 2012.09.11 오요한 [CHM-201219996] BKG I/F시 PAYMENT DATE 적용 - DUE DATE  (BL 단위 관리 지역)
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration.BookingARCreationDBDAO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARInvoiceCreationVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArCntrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArMnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration.ManualARCreationDBDAO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.BKGContainerVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.BKGInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.BKGMainVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.BKGQtyVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.BKGRefNoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.BKGTvvdPortVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.BKGVVDSaDtVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.CustomerDueDtVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.MRIInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.NonShippingARVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.NonShippingChargeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.NonShippingInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.NonShippingListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.NonShippingMainVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.RevenueAcctVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceChargeSumVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.VvdVO;
import com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.ARCustomerVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-AccountReceivableInvoiceCreation Business Logic Basic Command implementation<br>
 * - ALPS-AccountReceivableInvoiceCreation에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author saeil kim
 * @see FNS_INV_0022EventResponse,ManualARCreationBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class ManualARCreationBCImpl extends BasicCommandSupport implements ManualARCreationBC {

	// Database Access Object
	private transient ManualARCreationDBDAO dbDao = null;
	private transient BookingARCreationDBDAO bkgArDbDao = null;
	//private String tmlInvIssFlg;  // ##R4J : 사용하지 않는 private 변수들을 점검한다.

	/**
	 * ManualARCreationBCImpl 객체 생성<br>
	 * ManualARCreationDBDAO를 생성한다.<br>
	 */
	public ManualARCreationBCImpl() {
		dbDao = new ManualARCreationDBDAO();
		bkgArDbDao = new BookingARCreationDBDAO();
	}
	
	/**
	 * ManualARCreationBCImpl 객체 생성<br>
	 * ManualARCreationDBDAO를 생성한다.<br>
	 * @param String dataSource
	 */
	public ManualARCreationBCImpl(String dataSource) {
		dbDao = new ManualARCreationDBDAO(dataSource);
	}
	
	/**
	 * Miscellaneous Revenue Invoice Entry Rev. Type 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String svrId
	 * @param String rhqCd
	 * @param String ofcCd
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchOfficeRevenueSourceList(String svrId, String rhqCd, String ofcCd) throws EventException {
		//log.info("########## GeneralARInvoiceMasterDataMgtBCImpl");
		List<String> list = new ArrayList<String>();
//		String tmlInvIssFlg = ""; // ##R4J : 사용하지 않는 private 변수들을 점검한다. 
		try {
//			tmlInvIssFlg = dbDao.searchOfficeRevenueSourceList(ofcCd); // ##R4J : 사용하지 않는 private 변수들을 점검한다.
		
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
			if (rhqCd.equals(ofcCd)) {
				list.add("OC");	
				//20100527 BN 추가 김동진 수석
				list.add("BN");	
			}
			if(rhqCd.equals("KOR")||svrId.equals("JPN")){
				list.add("TN");
		    }
			if(svrId.equals("KOR")&&ofcCd.substring(3,5).equals("BO")){
				list.add("TN");
		    }
//			if(rhqCd.equals("KOR")||svrId.equals("JPN")){
//				list.add("TN");
//		    }
//			if(svrId.equals("KOR")){ KOR 조건을 막고 SELADG 추가
//				list.add("WC");
//			}
			if(ofcCd.equals("SELADG")){
			    list.add("WC");
			}
			if (rhqCd.equals("HAMRU")||rhqCd.equals("NYCRA")) {
				list.add("TS");				
			}
			if (rhqCd.equals("NYCRA")) {
				list.add("EQ");				
			}			
			
//			log.info("\n########## list.size() : "+list.size());
			
			return list;
			
// ##R4J : 사용하지 않는 private 변수들을 점검한다.
//		} catch (DAOException ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("INV00095",new String[]{}).getUserMessage());
// ##R4J : 사용하지 않는 private 변수들을 점검한다.
			
		} catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
	    }
	}

	/**
	 * Miscellaneous Revenue Invoice Entry Rev. Type 화면에 대한 조회 이벤트 처리<br>
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
				
				// 동일 Country 소속의 ar_ofc 정보를 가져온다				
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
	 * Miscellaneous Revenue Invoice Entry Rev. Type 화면에 대한 조회 이벤트 처리<br>
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
	 * ManualARCreation화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String chgCd
	 * @param String ofcCd
	 * @return boolean
	 * @exception EventException
	 */
	public boolean searchLocalChargeExist(String chgCd, String ofcCd) throws EventException {
		try {
			return dbDao.searchLocalChargeExist(chgCd, ofcCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		} catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
	    }
	}	
	
	/**
	 * ManualARCreation화면에 대한 조회 이벤트 처리<br>
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
				
				//OTH는 예외처리 추가
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
	 * 조회 이벤트 처리<br>
	 *  Revenue Account(계정) 코드 정보의 리스트를 조회한다.<br>
	 * @param String ofcCd
	 * @param String rhqOfcCd
	 * @return List<RevenueAcctVO>
	 * @exception EventException
	 */
	public List<RevenueAcctVO> searchRevenueAcctCdList(String ofcCd, String rhqOfcCd) throws EventException {
		try {
			return dbDao.searchRevenueAcctCdList(ofcCd, rhqOfcCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		} catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
	    }
	}
	
	/**
	 * 데이터 분류/office로 관리되는 결산월의 마감여부를 체크한다<br>
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
	 * B/L No 를 채번한다.<br>
	 * 비해운 운임수입 매출채권 생성시 Office 별로 관리하고 있는 B/L No 를 채번하여 구한다.<br>
	 * RHQ가 'SELHO'인 OFC는 OFC 앞 3자리 대신 뒤 3자리로 생성한다
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
	 * 조회 이벤트 처리<br>
	 * 여러건의 비해운 운임수입 매출채권 정보들을 조회한다.<br>
	 * 
	 * @param NonShippingInputVO mthVo
	 * @return List<NonShippingListVO>
	 * @exception EventException
	 */	
	public List<NonShippingListVO> searchNonShippingARList (NonShippingInputVO mthVo ) throws EventException {
		List<NonShippingListVO> resultVOs = null;		// 데이터 전송을 위해 VO 객체
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
	 * 전표번호를 조회한다.<br>
	 * 입력받은 Office Code 에 대해 Sequence 객체에서 Next 값을 구하여 Slip No 를 구한다.<br>
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
	 * 입력한 I/F No 의 비해운 운임수입 매출채권 정보를 조회한다.<br>
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
	 * 조회 이벤트 처리<br>
	 * 해당 B/L NO로 동일 Office 내 기 생성된 데이터(Max(AR_IF_NO)로 생성된 데이터)의 Customer 정보를 가져온다.<br>
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
	 * Interface 조회 이벤트 처리<br>
	 * FnsInv0071Event event에 대한 특정 리스트 조회 이벤트 처리<br>
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
	 * INV_AR_MRI_IF_NO table 에서 MRI_MAX_SEQ 조회. <br>
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
	 * INV_AR_MRI_IF_NO table 에 MRI_MAX_SEQ insert <br>
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
	 * INV_AR_MRI_IF_NO table 에 MRI_MAX_SEQ update <br>
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
	 * office 별 Local Time 조회<br>
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
	 * office 별 block charge 조회 <br>
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
	 * 조회 이벤트 처리<br>
	 * 존재하는 port인지 체크<br>
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
	 * VLCSC MIC 일 경우 입력된 IFNo 로 IVA 요율을 가져온다. <br>
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
	 * CMBSC일 경우 입력된 CustCd로 INV_AR_SPND_VAT_RGST_NO테이블에서 SPND_VAT_RGST_NO값을 가져온다. <br>
	 * 
	 * @param String custCntCd 
	 * @param String custSeq
	 * @return String
	 * @exception EventException
	 */
	public String searchSpndVatRgstNo(String custCntCd, String custSeq) throws EventException {
		
		try {
			return dbDao.searchSpndVatRgstNo(custCntCd, custSeq);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * SA Date 에 따른 Due Date 값을 계산하여 가져온다. <br>
	 * 
	 * @param String bnd
	 * @param String saDate
	 * @param String custCntCd
	 * @param String custSeq
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchDueDate(String bnd, String saDate, String custCntCd, String custSeq, String ofcCd) throws EventException {
		
		try {
			
			String dueDt = "";
			dueDt = dbDao.searchDueDate(bnd, saDate, custCntCd, custSeq, ofcCd);
			
			// [CHM-201219996] BKG I/F시 PAYMENT DATE 적용  - DUE DATE  (BL 단위 관리 지역) - 2012.09.11
		    // Credit Customer에 Payment Day가 존재할 경우 이전에 구한 Due_dt에 신용화주별 Payment Day를 적용하여 새로 Due_dt를 구함.
	        // Paymet Day가 존재하지 않거나 신용화주가 아닐경우 입력받은 Due_dt를 유지함
			String tmpdueDt = "";
			tmpdueDt = 	bkgArDbDao.searchDueDateByCustPayDay(dueDt, custCntCd, custSeq);
			if (!tmpdueDt.equals("")) {
				dueDt = tmpdueDt;
			}
			return dueDt;
			
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * VVD변경여부를 판별하기위해 BKG으로부터 VVD정보를 가져온다.<br>
	 * 
	 * @param String blNo
	 * @return VvdVO
	 * @exception EventException
	 */	
	public VvdVO searchVvdByBkgNo (String blNo) throws EventException {
		VvdVO vvdVo = new VvdVO();
		
		try {
			
			vvdVo = dbDao.searchVvdByBkgNo(blNo);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		} catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
	    }	
		
		return vvdVo;
	}
	
	/**
	 * POL_CD, POD_CD 를 이용하여 EU여부를 체크한다. <br>
	 * 
	 * @param String polCd 
	 * @param String podCd
	 * @return String
	 * @exception EventException
	 */
	public String searchEuCheck(String polCd, String podCd) throws EventException {
		
		try {
			return dbDao.searchEuCheck(polCd, podCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
}