/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : FACCalcBCImpl.java
*@FileTitle : FAC Calculation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.agt.agtcalculation.faccalc.basic;

import java.util.ArrayList;
import java.util.HashMap;

import com.clt.apps.opus.esm.agt.agtaudit.facaudit.basic.FACAuditBC;
import com.clt.apps.opus.esm.agt.agtaudit.facaudit.event.EsmAgt0033Event;
import com.clt.apps.opus.esm.agt.agtaudit.facaudit.vo.FACCommVO;
import com.clt.apps.opus.esm.agt.agtcalculation.brkgcalc.basic.BRKGCalcBC;
import com.clt.apps.opus.esm.agt.agtcalculation.brkgcalc.basic.BRKGCalcBCImpl;
import com.clt.apps.opus.esm.agt.agtcalculation.faccalc.integration.FACCalcDBDAO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-agt Business Logic Basic Command implementation<br>
 * - OPUS-agt handling Business Logic Basic Command implementation<br>
 * 
 * @author 
 * @see ESM_AGT_008_03EventResponse,FACCalcBC 
 * @since J2EE 1.4
 */
public class FACCalcBCImpl extends BasicCommandSupport implements FACCalcBC {

	// Database Access Object
	private transient FACCalcDBDAO dbDao=null;
	private transient BRKGCalcBC brkgBC=null;
	//private transient FACAuditBC facAuditBC=null;

	/**
	 * FACCalcBCImpl object creation<br>
	 * FACCalcDBDAO creation<br>
	 */
	public FACCalcBCImpl(){
		dbDao = new FACCalcDBDAO();
		brkgBC = new BRKGCalcBCImpl();
	}

	/**
	 * FAC Commission Calculate event process<br>
	 * 
	 * @param String bkg_no
	 * @return int
	 * @exception EventException
	 */
	public int createFACCommInv(String bkg_no) throws EventException{

		HashMap bkgMap = new HashMap(); 
		
		int cnt = -1;
		
		bkgMap.put("BKG_NO", bkg_no);				// booking no.
		bkgMap.put("FF_CNT_CD", "");				// booking ff_cnt_cd
		bkgMap.put("FF_CUST_SEQ", "");				// booking ff_cust_seq
		bkgMap.put("SHPR_CNT_CD", "");				// booking shpr_cnt_cd
		bkgMap.put("SHPR_CUST_SEQ", "");			// booking shpr_cust_seq
		bkgMap.put("reCalcYN", "N");				// reCalculation flag
		
		try {

			// Booking information
			bkgMap = brkgBC.searchBookingInfoforComm(bkgMap);
			
			// Error return 
			if(checkError( bkgMap )) {
				 if ("B".equals((String)bkgMap.get("COVERED_CHECK")))
					{
						processFacCancel(bkg_no, "COMMISSION");
					}
					else if ("C".equals((String)bkgMap.get("COVERED_CHECK")))
					{
						processFacCancel(bkg_no, "COMMISSION");
					}

				return 0;
			}
			
			// S/A Date
			bkgMap = brkgBC.searchAGTSADate(bkgMap);
			
			// Error return
			if(checkError( bkgMap )) {
				return 0;
			}

			// SC NO, RFA NO, PPD OFFICE, CCT OFFICE, ACTUAL CUSTOMER, CGO_RCV_DT 
			bkgMap = brkgBC.searchAGTContractInfo(bkgMap);
			
			// Error return 
			if(checkError( bkgMap )) {
				return 0;
			}
			
			// Booking QTY
			bkgMap = dbDao.searchBKGQTYInfo(bkgMap);
			// Error return 
			if(checkError( bkgMap )) {
				return 0;
			}
			
			// Revenue Lane, Revenue VVD	
			bkgMap = brkgBC.searchRevLanebndInfo(bkgMap);
			
			// Error return
			if(checkError( bkgMap )) {
				return 0;
			}
			
			// Before FAC Calculation, Save Booking Commission information to AGT_COMM_BKG_INFO
			brkgBC.createBKGMasterInfo(bkgMap);

			// AGT_BKG_REV_VVD_PRC Procedure Call
			//brkgBC.callProcedure(bkg_no);
			
			// FAC Calculation
			createActualFACComm(bkgMap);
			cnt = 1;
			
		} catch (Exception e) {
			log.error("err "+e.toString(),e);
			throw new EventException(e.getMessage());
		}
		
		return cnt;
	}

	
	/**
	 * FAC Commission Calculate event process<br>
	 * 
	 * @param String bkg_no
	 * @return Object batch result
	 * @exception EventException
	 */
	public Object createFACComm(String bkg_no) throws EventException{

		HashMap bkgMap = new HashMap(); 
		
		bkgMap.put("BKG_NO", bkg_no);				// booking no
		bkgMap.put("FF_CNT_CD", "");				// booking ff_cnt_cd
		bkgMap.put("FF_CUST_SEQ", "");				// booking ff_cust_seq
		bkgMap.put("SHPR_CNT_CD", "");				// booking shpr_cnt_cd
		bkgMap.put("SHPR_CUST_SEQ", "");			// booking shpr_cust_seq
		bkgMap.put("reCalcYN", "N");				// reCalculation flag
		
		try {

			// Booking information
			bkgMap = brkgBC.searchBookingInfoforComm(bkgMap);
			
			// Error return
			if(checkError( bkgMap )) {
				 if ("B".equals((String)bkgMap.get("COVERED_CHECK")))
					{
						processFacCancel(bkg_no, "COMMISSION");
					}
					else if ("C".equals((String)bkgMap.get("COVERED_CHECK")))
					{
						processFacCancel(bkg_no, "COMMISSION");
					}

				return 0;
			}
			
			// S/A Date
			bkgMap = brkgBC.searchAGTSADate(bkgMap);
			
			// Error return
			if(checkError( bkgMap )) {
				return 0;
			}

			// SC NO, RFA NO, PPD OFFICE, CCT OFFICE, ACTUAL CUSTOMER, CGO_RCV_DT 
			bkgMap = brkgBC.searchAGTContractInfo(bkgMap);
			
			// Error return 
			if(checkError( bkgMap )) {
				return 0;
			}
			
			// Booking QTY.	
			bkgMap = dbDao.searchBKGQTYInfo(bkgMap);
			// Error return 
			if(checkError( bkgMap )) {
				return 0;
			}
			
			// Revenue Lane, Revenue VVD	
			bkgMap = brkgBC.searchRevLanebndInfo(bkgMap);
			
			// Error return
			if(checkError( bkgMap )) {
				return 0;
			}
			
			// Booking Commission information save
			brkgBC.createBKGMasterInfo(bkgMap);

			// AGT_BKG_REV_VVD_PRC Procedure call
			//brkgBC.callProcedure(bkg_no);
			
			// FAC calculation
			createActualFACComm(bkgMap);
			
		} catch (Exception e) {
			log.error("err "+e.toString(),e);
			throw new EventException(e.getMessage());
		}
		
		return 0;
	}

	
	
	/**
	 * FAC calculation batch implement event process<br>
	 * 
	 * @param HashMap bkgMap
	 * @return String
	 * @exception EventException
	 */
	public String createActualFACComm(HashMap bkgMap) throws EventException{

		log.debug("\n\n BCImpl createActualFACComm Method start");

		String bkg_sts_cd = "";
		String ff_cnt_cd = "";
		String sFf_cust_seq = "";
		String sShpr_cust_seq = "";
		String fac_ofc_cd = "";
		String facRtBreakYN = "N";

		int ff_cust_seq = 0;
		int ff_cust_seq_tmp = 999999;

		HashMap facMap = new HashMap();	// FAC HashMap 
		HashMap facCalcRtMap = new HashMap();	// FAC Rate HashMap 	

		try {
			// cancel flag
			bkg_sts_cd = dbDao.checkNull((String)bkgMap.get("BKG_STS_CD"));

			// FAC Agrement rate information
			fac_ofc_cd = dbDao.checkNull((String)bkgMap.get("PPD_OFC_CD")); // PPD_OFC_CD
			ff_cnt_cd = dbDao.checkNull((String)bkgMap.get("FF_CNT_CD"));
			sFf_cust_seq = dbDao.checkNull((String)bkgMap.get("FF_CUST_SEQ"));
			sShpr_cust_seq =  dbDao.checkNull((String)bkgMap.get("SHPR_CUST_SEQ"));

//			if( fac_ofc_cd.length() <= 0 ) {
//				bkgMap.put("PPD_OFC_CD", (String)bkgMap.get("BKG_SLS_OFC_CD"));
//				fac_ofc_cd = dbDao.checkNull((String)bkgMap.get("PPD_OFC_CD"));
//			}
			
			if(sFf_cust_seq.length() > 0 && !"*".equals(sFf_cust_seq)) {
				ff_cust_seq = Integer.parseInt(sFf_cust_seq);
			}
			if(sFf_cust_seq.length() == 0 || "*".equals(sFf_cust_seq)) {
				sFf_cust_seq = "000000";
			}
			if(sShpr_cust_seq.length() == 0 || "*".equals(sShpr_cust_seq)) {
				sShpr_cust_seq = "000000";
			}
			
			// FAC HashMap
			facMap.put("BKG_NO", (String)bkgMap.get("BKG_NO"));					// booking no
			facMap.put("COMM_PROC_STS_CD", "CE");								// comm_proc_sts_cd = "CE"
			facMap.put("COMM_PROC_RSLT_RSN", "");								// comm_proc_rslt_rsn
			facMap.put("TRUNK_ETD_DT", (String)bkgMap.get("TRUNK_ETD_DT"));		// Trunk
			facMap.put("SLS_OFC_CD", fac_ofc_cd);								// PPD_OFC_CD = SLS_OFC_CD
			facMap.put("FRT_FWRD_CNT_CD", ff_cnt_cd);							// FRT_FWRD_CNT_CD
			facMap.put("FRT_FWRD_SEQ", String.valueOf(ff_cust_seq));			// FRT_FWRD_SEQ 
			bkgMap.put("facRtBreakYN", facRtBreakYN); 							// FAC Reta flag

			bkgMap.put("facMap", facMap);										// FAC HashMap -> Booking Map
			bkgMap.put("facCalcRtMap", facCalcRtMap);							// FAC Rate HashMap
			bkgMap.put("FF_CUST_SEQ", sFf_cust_seq);							// 6 digits
			bkgMap.put("SHPR_CUST_SEQ", sShpr_cust_seq);						// 6 digits

			// FAC check
			if(!dbDao.createActualFACComm( bkgMap )) {
				return null;
			}

			// FAC Sequence
			bkgMap = dbDao.searchFACRateSequenceInfo( bkgMap );	

			if("X".equals(bkg_sts_cd)) {	// Interface. but status is cancel, retrieve Cancel amt
				
				// Cancel amt
				bkgMap = dbDao.searchFACBKGCancelInfo(bkgMap);

				// Error return
				if(checkFacError( bkgMap )) {
					return null;
				}

			} else {

				// when Rate of PPD_OFC_CD is NULL, set 3rd Part to PPD_OFC_CD .
				bkgMap = dbDao.checkPpdOfcCd(bkgMap);
				
				//Error return 
				if(checkFacError( bkgMap )) {
					return null;
				}
				
				
				// checking relation FAC Freight Forwarder and Shipper
				bkgMap = dbDao.searchFACCustShprInterestInfo(bkgMap);
				
				// Error return
				if(checkFacError( bkgMap )) {
					return null;
				}
				
				// MEMO BL check
				bkgMap = dbDao.checkFACOtherInfo(bkgMap);
				
				// Error return 
				if(checkFacError( bkgMap )) {
					return null;
				}
				
				// Freight Forwarder
				ff_cnt_cd = dbDao.checkNull((String)bkgMap.get("FF_CNT_CD"));
				sFf_cust_seq = dbDao.checkNull((String)bkgMap.get("FF_CUST_SEQ"));
				
				if(sFf_cust_seq.length() > 0 && !"*".equals(sFf_cust_seq)) {
					ff_cust_seq = Integer.parseInt(sFf_cust_seq);
				}
				
				facMap = (HashMap)bkgMap.get("facMap");
				facMap.put("FRT_FWRD_CNT_CD", ff_cnt_cd);					// FRT_FWRD_CNT_CD 
				facMap.put("FRT_FWRD_SEQ", String.valueOf(ff_cust_seq));	// FRT_FWRD_SEQ 
				bkgMap.put("facMap", facMap);

				// PPD_OFC_CD rate information
				// FAC Agrement rate information - first
				bkgMap = dbDao.searchFACAGMTRateInfo( bkgMap, fac_ofc_cd, ff_cnt_cd, ff_cust_seq, false );
				// Error return 
				if(checkFacError( bkgMap )) {
					return null;
				}

				// Rete flag
				facRtBreakYN = dbDao.checkNull((String)bkgMap.get("facRtBreakYN"));
				if( "N".equals(facRtBreakYN) ) { // Rate does not exist
					
					// FAC Agrement rate information does not exists, retrieve on ff_cust_seq=999999 - 2nd
					bkgMap = dbDao.searchFACAGMTRateInfo( bkgMap, fac_ofc_cd, ff_cnt_cd, ff_cust_seq_tmp, false );
					// Error return 
					if(checkFacError( bkgMap )) {
						return null;
					}

					// Rete 
					facRtBreakYN = dbDao.checkNull((String)bkgMap.get("facRtBreakYN"));
					// PPD_OFC_CD AR_OFC_CD
					if( "N".equals(facRtBreakYN) ) { // Rate does not exist

						facMap = (HashMap)bkgMap.get("facMap");		
						fac_ofc_cd = dbDao.checkNull((String)facMap.get("AR_OFC_CD"));
						
						// FAC Agrement rate information. 3rd
						bkgMap = dbDao.searchFACAGMTRateInfo( bkgMap, fac_ofc_cd, ff_cnt_cd, ff_cust_seq, false );
						// Error return
						if(checkFacError( bkgMap )) {
							return null;
						}

						// Rete 
						facRtBreakYN = dbDao.checkNull((String)bkgMap.get("facRtBreakYN"));				
						if( "N".equals(facRtBreakYN) ) { // Rate does not exist
							
							//  AR_OFC_CD, ff_cust_seq=999999 - 4th
							bkgMap = dbDao.searchFACAGMTRateInfo( bkgMap, fac_ofc_cd, ff_cnt_cd, ff_cust_seq_tmp, false );
							// Error return
							if(checkFacError( bkgMap )) {
								return null;
							}
						}
					}
				}

				facMap = (HashMap)bkgMap.get("facMap");
				facMap.put("FAC_RT_OFC_CD", fac_ofc_cd);
				
				// on Contaner type/size, FAC Commission calculation
				bkgMap = dbDao.calcFACCommInfo(bkgMap);
				//log.info("BKGMAP : "+bkgMap);
				// Error return
				if(checkFacError( bkgMap )) {
					return null;
				}


				// FAC Commission save
				bkgMap = dbDao.createFACCommInfo(bkgMap);
				
				// Error return 
				if(checkFacError( bkgMap )) {
					return null;
				}
			}
			
			// FAC Commission Detail
			bkgMap = dbDao.createFACTPSZCommInfo(bkgMap);
			
			// Error return 
			if(checkFacError( bkgMap )) {
				return null;
			}
			
			// Summation 
			bkgMap = dbDao.createFACTPSZSummation(bkgMap);
			
			return null;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
			
			return de.toString();
		}
	}

	
	
	
	
	
	
	/**
	 * FAC Commission ReCalculate event process<br>
	 * 
	 * @param  Event ev
	 * @return Object 
	 * @exception EventException
	 */
	public Object reCalcFACComm(Event ev) throws EventException{

		EsmAgt0033Event event=(EsmAgt0033Event)ev;
		FACCommVO[] facCommVOs = event.getFACCommVOS();
		SignOnUserAccount account = event.getSignOnUserAccount();
//		ArrayList arrayList = new ArrayList();

		String usrId = "";
		//String sCheck = "";
		String bkg_no = "";
		String bkg_sts_cd = "";
		String ff_cnt_cd = "";
		String sFf_cust_seq = "";
		String sShpr_cust_seq = "";
		String fac_ofc_cd = "";
		String facRtBreakYN = "N";
		
//		int cnt = 0;
		int ff_cust_seq = 0;
//		int ff_cust_seq_tmp = 999999;

//		String[] sBkg_no 		= null;//event.getObject("bkg_no");
//		String[] check 			= null;//event.getObject("check");

//		String[][] array = null;
		
//		int arraySize = 0; 
		try {
			
//			if(check != null){
				
				usrId = account.getUsr_id();
				log.debug("\nLoginID: " + usrId + "\n\n");
				
				// Loop
//				for (int j=0; j<check.length; j++) {
	
//					sCheck = check[j]==null?"":check[j];

//					if ( sCheck.equals("1") ) {
				
				
				log.debug("\n\n\n====================>"+facCommVOs.length+"\n");
				for(int i=0; i<facCommVOs.length; i++)
				{
					if ( facCommVOs[i].getIbflag().equals("U"))
					{
						HashMap bkgMap = new HashMap(); // Booking Map.
						HashMap facMap = new HashMap();	// FAC HashMap 
						HashMap facCalcRtMap = new HashMap(); // FAC HashMap 

						bkg_sts_cd = ""; 
						ff_cnt_cd = ""; 
						sFf_cust_seq = ""; 
						sShpr_cust_seq = ""; 
						fac_ofc_cd = ""; 
						facRtBreakYN = "N"; 
						ff_cust_seq = 0; 

						bkg_no = facCommVOs[i].getBkgNo();
						log.debug("\nBkgNo: " + bkg_no + "\n\n");

						bkgMap.put("BKG_NO", bkg_no);				// booking no
						bkgMap.put("FF_CNT_CD", "");				// booking ff_cnt_cd
						bkgMap.put("FF_CUST_SEQ", "");				// booking ff_cust_seq
						bkgMap.put("SHPR_CNT_CD", "");				// booking shpr_cnt_cd
						bkgMap.put("SHPR_CUST_SEQ", "");			// booking shpr_cust_seq
						bkgMap.put("USRID", usrId);					// reCalculation UserID
						bkgMap.put("reCalcYN", "Y");				// reCalculation flag
						
						// Booking information
						bkgMap = brkgBC.searchBookingInfoforComm(bkgMap);
						
						// Error return 
						if(checkError( bkgMap )) {
							 if ("B".equals((String)bkgMap.get("COVERED_CHECK")))
								{
									processFacCancel(bkg_no, "COMMISSION");
								}
								else if ("C".equals((String)bkgMap.get("COVERED_CHECK")))
								{
									processFacCancel(bkg_no, "COMMISSION");
								}

							continue;
						}
						
						// S/A Date
						bkgMap = brkgBC.searchAGTSADate(bkgMap);
						
						// Error  return 
						if(checkError( bkgMap )) {
							continue;
						}

						// SC NO, RFA NO, PPD OFFICE, CCT OFFICE, ACTUAL CUSTOMER, CGO_RCV_DT 
						bkgMap = brkgBC.searchAGTContractInfo(bkgMap);
						
						// Error return 
						if(checkError( bkgMap )) {
							continue;
						}
						
						// Booking QTY
						bkgMap = dbDao.searchBKGQTYInfo(bkgMap);
						// Error return 
						if(checkError( bkgMap )) {
							continue;
						}
						
						// Revenue Lane, Revenue VVD	
						bkgMap = brkgBC.searchRevLanebndInfo(bkgMap);
						
						// Error return 
						if(checkError( bkgMap )) {
							continue;
						}
						
						// Booking Commission 
						brkgBC.createBKGMasterInfo(bkgMap);

						// AGT_BKG_REV_VVD_PRC Procedure call
						//brkgBC.callProcedure(bkg_no);
						
						// FAC calculation---------------start---------------
						// cancel  Booking Status
						bkg_sts_cd = dbDao.checkNull((String)bkgMap.get("BKG_STS_CD"));

						// FAC Agrement rate information
						fac_ofc_cd = dbDao.checkNull((String)bkgMap.get("PPD_OFC_CD"));
						ff_cnt_cd = dbDao.checkNull((String)bkgMap.get("FF_CNT_CD"));
						sFf_cust_seq = dbDao.checkNull((String)bkgMap.get("FF_CUST_SEQ"));
						sShpr_cust_seq =  dbDao.checkNull((String)bkgMap.get("SHPR_CUST_SEQ"));
						
						
						if(sFf_cust_seq.length() > 0 && !"*".equals(sFf_cust_seq)) {
							ff_cust_seq = Integer.parseInt(sFf_cust_seq);
						}
						if(sFf_cust_seq.length() == 0 || "*".equals(sFf_cust_seq)) {
							sFf_cust_seq = "000000";
						}
						if(sShpr_cust_seq.length() == 0 || "*".equals(sShpr_cust_seq)) {
							sShpr_cust_seq = "000000";
						}
						
						facMap.put("BKG_NO", (String)bkgMap.get("BKG_NO"));					// booking no
						facMap.put("COMM_PROC_STS_CD", "CE");								// comm_proc_sts_cd = "CE"
						facMap.put("COMM_PROC_RSLT_RSN", "");								// comm_proc_rslt_rsn
						facMap.put("TRUNK_ETD_DT", (String)bkgMap.get("TRUNK_ETD_DT"));		// TRUNK_ETD_DT
						facMap.put("SLS_OFC_CD", fac_ofc_cd);								// PPD_OFC_CD = SLS_OFC_CD
						facMap.put("FRT_FWRD_CNT_CD", ff_cnt_cd);							// FRT_FWRD_CNT_CD
						facMap.put("FRT_FWRD_SEQ", String.valueOf(ff_cust_seq));			// FRT_FWRD_SEQ 
						bkgMap.put("facRtBreakYN", facRtBreakYN); 							// FAC Reta 

						bkgMap.put("facMap", facMap);										// Booking Map
						bkgMap.put("facCalcRtMap", facCalcRtMap);							// FAC Rate HashMap
						bkgMap.put("FF_CUST_SEQ", sFf_cust_seq);							// 6 digits
						bkgMap.put("SHPR_CUST_SEQ", sShpr_cust_seq);						// 6 digits
						
						// FAC
						if(!dbDao.createActualFACComm( bkgMap )) {
							continue;
						}
						
						// FAC Sequence
						bkgMap = dbDao.searchFACRateSequenceInfo( bkgMap );	

						if("X".equals(bkg_sts_cd)) {	// Cancel amt
							
							// Cancel amt
							bkgMap = dbDao.searchFACBKGCancelInfo(bkgMap);
							
							// Error return 
							if(checkFacError( bkgMap )) {
								continue;
							}			

						} else {
							
							// 3rd Part PPD_OFC_CD
							bkgMap = dbDao.checkPpdOfcCd(bkgMap);
							
							//Error return 
							if(checkFacError( bkgMap )) {
								return null;
							}

							// FAC Freight Forwarder &  Shipper
							bkgMap = dbDao.searchFACCustShprInterestInfo(bkgMap);
							
							// Error return
							if(checkFacError( bkgMap )) {
								continue;
							}
							
							//  MEMO BL check
							bkgMap = dbDao.checkFACOtherInfo(bkgMap);
				
							// Error return
							if(checkFacError( bkgMap )) {
								continue;
							}

							// Freight Forwarder
							ff_cnt_cd = dbDao.checkNull((String)bkgMap.get("FF_CNT_CD"));
							sFf_cust_seq = dbDao.checkNull((String)bkgMap.get("FF_CUST_SEQ"));
							
							if(sFf_cust_seq.length() > 0 && !"*".equals(sFf_cust_seq)) {
								ff_cust_seq = Integer.parseInt(sFf_cust_seq);
							}
							
							facMap = (HashMap)bkgMap.get("facMap");
							facMap.put("FRT_FWRD_CNT_CD", ff_cnt_cd);					// FRT_FWRD_CNT_CD 
							facMap.put("FRT_FWRD_SEQ", String.valueOf(ff_cust_seq));	// FRT_FWRD_SEQ 
							bkgMap.put("facMap", facMap);

							// 1. retrieve rate information on PPD_OFC_CD
							// 2. if it doesn't exist, retrieve rate information on AR_OFC_CD
							// 3. retrieve FAC Agrement rate information - 1st
							// 4. if it doesn't exist, retrieve FAC Agrement rate information (ff_cust_seq=999999)
							bkgMap = dbDao.searchFACAGMTRateInfo( bkgMap, fac_ofc_cd, ff_cnt_cd, ff_cust_seq, false );
							
							// Error return
							if(checkFacError( bkgMap )) {
								continue;
							}

							// Rete 
							facRtBreakYN = dbDao.checkNull((String)bkgMap.get("facRtBreakYN"));


							facMap = (HashMap)bkgMap.get("facMap");
							facMap.put("FAC_RT_OFC_CD", fac_ofc_cd); //  Office

							// calculate FAC Commission according Contaner type/size
							bkgMap = dbDao.calcFACCommInfo(bkgMap);
							
							// Error return 
							if(checkFacError( bkgMap )) {
								continue;
							}
							
							// FAC Commission
							bkgMap = dbDao.createFACCommInfo(bkgMap);
							
							// Error return
							if(checkFacError( bkgMap )) {
								continue;
							}
						}
						
						// save FAC Commission Detail
						bkgMap = dbDao.createFACTPSZCommInfo(bkgMap);
						
						// Error return
						if(checkFacError( bkgMap )) {
							continue;
						}
						
						// Summation 
						bkgMap = dbDao.createFACTPSZSummation(bkgMap);
						
						// FAC calculation---------------end---------------
					} // end if
				} // end for
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error("err "+e.toString(),e);
			throw new EventException(e.getMessage());
		}
		
		return null;
	}

	
	
	
	
	
	
	
	
	
	
	
	/**
	 * FAC Commission ReCalculate event process<br>
	 * 
	 * @param String bkg_no
	 * @param SignOnUserAccount account
	 * @return Object batch result
	 * @exception EventException
	 */
	public Object recalcFACComm(String bkg_no, SignOnUserAccount account) throws EventException{

//		ArrayList arrayList = new ArrayList();

		String usrId = "";
		String bkg_sts_cd = "";
		String ff_cnt_cd = "";
		String sFf_cust_seq = "";
		String sShpr_cust_seq = "";
		String fac_ofc_cd = "";
		String facRtBreakYN = "N";
		
//		int cnt = 0;
		int ff_cust_seq = 0;
//		int ff_cust_seq_tmp = 999999;

//		String[] sBkg_no 		= null;//event.getObject("bkg_no");
//		String[] check 			= null;//event.getObject("check");

//		String[][] array = null;
		
//		int arraySize = 0; 
		
		try {
			
//			if(check != null){
				
				usrId = account.getUsr_id();
				log.debug("\nLoginID: " + usrId + "\n\n");
				
				// Loop
//				for (int j=0; j<check.length; j++) {
	
//					sCheck = check[j]==null?"":check[j];

//					if ( sCheck.equals("1") ) {
				
				
						HashMap bkgMap = new HashMap(); //  Booking Map.
						HashMap facMap = new HashMap();	// FAC HashMap 
						HashMap facCalcRtMap = new HashMap(); // FAC HashMap 

						bkg_sts_cd = ""; 
						ff_cnt_cd = ""; 
						sFf_cust_seq = ""; 
						sShpr_cust_seq = ""; 
						fac_ofc_cd = ""; 
						facRtBreakYN = "N"; 
						ff_cust_seq = 0; 

						log.debug("\nBkgNo: " + bkg_no + "\n\n");

						// Booking Map
						bkgMap.put("BKG_NO", bkg_no);				// booking no
						bkgMap.put("FF_CNT_CD", "");				// booking ff_cnt_cd
						bkgMap.put("FF_CUST_SEQ", "");				// booking ff_cust_seq
						bkgMap.put("SHPR_CNT_CD", "");				// booking shpr_cnt_cd
						bkgMap.put("SHPR_CUST_SEQ", "");			// booking shpr_cust_seq
						bkgMap.put("USRID", usrId);					// reCalculation UserID
						bkgMap.put("reCalcYN", "Y");				// reCalculation 
						
						// Booking information
						bkgMap = brkgBC.searchBookingInfoforComm(bkgMap);
						
						// Error return
						if(checkError( bkgMap )) {
							 if ("B".equals((String)bkgMap.get("COVERED_CHECK")))
								{
									processFacCancel(bkg_no, "COMMISSION");
								}
								else if ("C".equals((String)bkgMap.get("COVERED_CHECK")))
								{
									processFacCancel(bkg_no, "COMMISSION");
								}
							 return null;
						}
						
						// S/A Date
						bkgMap = brkgBC.searchAGTSADate(bkgMap);
						
						// Error return
						if(checkError( bkgMap )) {
							return null;
						}

						// SC NO, RFA NO, PPD OFFICE, CCT OFFICE, ACTUAL CUSTOMER, CGO_RCV_DT 
						bkgMap = brkgBC.searchAGTContractInfo(bkgMap);
						
						// Error return
						if(checkError( bkgMap )) {
							return null;
						}
						
						// Booking QTY
						bkgMap = dbDao.searchBKGQTYInfo(bkgMap);
						// Error return
						if(checkError( bkgMap )) {
							return null;
						}
						
						// Revenue Lane, Revenue VVD
						bkgMap = brkgBC.searchRevLanebndInfo(bkgMap);
						
						// Error return
						if(checkError( bkgMap )) {
							return null;
						}
						
						// Booking Commission 
						brkgBC.createBKGMasterInfo(bkgMap);

						// AGT_BKG_REV_VVD_PRC Procedure call
						//brkgBC.callProcedure(bkg_no);
						
						// FAC calculation---------------start---------------
						// cancel chaeck, Booking Status
						bkg_sts_cd = dbDao.checkNull((String)bkgMap.get("BKG_STS_CD"));

						// FAC Agrement 
						fac_ofc_cd = dbDao.checkNull((String)bkgMap.get("PPD_OFC_CD"));
						ff_cnt_cd = dbDao.checkNull((String)bkgMap.get("FF_CNT_CD"));
						sFf_cust_seq = dbDao.checkNull((String)bkgMap.get("FF_CUST_SEQ"));
						sShpr_cust_seq =  dbDao.checkNull((String)bkgMap.get("SHPR_CUST_SEQ"));
						
						
						if(sFf_cust_seq.length() > 0 && !"*".equals(sFf_cust_seq)) {
							ff_cust_seq = Integer.parseInt(sFf_cust_seq);
						}
						if(sFf_cust_seq.length() == 0 || "*".equals(sFf_cust_seq)) {
							sFf_cust_seq = "000000";
						}
						if(sShpr_cust_seq.length() == 0 || "*".equals(sShpr_cust_seq)) {
							sShpr_cust_seq = "000000";
						}
						
						// FAC HashMap
						facMap.put("BKG_NO", (String)bkgMap.get("BKG_NO"));					// booking no
						facMap.put("COMM_PROC_STS_CD", "CE");								// comm_proc_sts_cd = "CE"
						facMap.put("COMM_PROC_RSLT_RSN", "");								// comm_proc_rslt_rsn
						facMap.put("TRUNK_ETD_DT", (String)bkgMap.get("TRUNK_ETD_DT"));		// Trunk
						facMap.put("SLS_OFC_CD", fac_ofc_cd);								// PPD_OFC_CD = SLS_OFC_CD
						facMap.put("FRT_FWRD_CNT_CD", ff_cnt_cd);							// FRT_FWRD_CNT_CD 
						facMap.put("FRT_FWRD_SEQ", String.valueOf(ff_cust_seq));			// FRT_FWRD_SEQ 
						bkgMap.put("facRtBreakYN", facRtBreakYN); 							// FAC Reta 

						bkgMap.put("facMap", facMap);										// FAC HashMap
						bkgMap.put("facCalcRtMap", facCalcRtMap);							// FAC Rate HashMap
						bkgMap.put("FF_CUST_SEQ", sFf_cust_seq);							// 6
						bkgMap.put("SHPR_CUST_SEQ", sShpr_cust_seq);						// 6
						
						// FAC check
						if(!dbDao.createActualFACComm( bkgMap )) {
							return null;
						}
						
						// FAC Sequence
						bkgMap = dbDao.searchFACRateSequenceInfo( bkgMap );	

						if("X".equals(bkg_sts_cd)) {	// Cancel amt
							
							// Cancel amt
							bkgMap = dbDao.searchFACBKGCancelInfo(bkgMap);
							
							// Error return
							if(checkFacError( bkgMap )) {
								return null;
							}			

						} else {
							
							// PPD_OFC_CD-> 3rd Part
							bkgMap = dbDao.checkPpdOfcCd(bkgMap);
							
							//Error return
							if(checkFacError( bkgMap )) {
								return null;
							}

							// FAC Freight Forwarder & Shipper
							bkgMap = dbDao.searchFACCustShprInterestInfo(bkgMap);
							
							// Error return
							if(checkFacError( bkgMap )) {
								return null;
							}
							
							// MEMO BL check
							bkgMap = dbDao.checkFACOtherInfo(bkgMap);
				
							// Error return
							if(checkFacError( bkgMap )) {
								return null;
							}

							// Freight Forwarder
							ff_cnt_cd = dbDao.checkNull((String)bkgMap.get("FF_CNT_CD"));
							sFf_cust_seq = dbDao.checkNull((String)bkgMap.get("FF_CUST_SEQ"));
							
							if(sFf_cust_seq.length() > 0 && !"*".equals(sFf_cust_seq)) {
								ff_cust_seq = Integer.parseInt(sFf_cust_seq);
							}
							
							facMap = (HashMap)bkgMap.get("facMap");
							facMap.put("FRT_FWRD_CNT_CD", ff_cnt_cd);					// FRT_FWRD_CNT_CD
							facMap.put("FRT_FWRD_SEQ", String.valueOf(ff_cust_seq));	// FRT_FWRD_SEQ 
							bkgMap.put("facMap", facMap);

							// 1. retrieve rate information on PPD_OFC_CD
							// 2. if it doesn't exist, retrieve rate information on AR_OFC_CD
							// 3. retrieve FAC Agrement rate information - 1st
							// 4. if it doesn't exist, retrieve FAC Agrement rate information (ff_cust_seq=999999)
							bkgMap = dbDao.searchFACAGMTRateInfo( bkgMap, fac_ofc_cd, ff_cnt_cd, ff_cust_seq, false );
							
							// Error return
							if(checkFacError( bkgMap )) {
								return null;
							}

							// Rete 
							facRtBreakYN = dbDao.checkNull((String)bkgMap.get("facRtBreakYN"));


							facMap = (HashMap)bkgMap.get("facMap");
							facMap.put("FAC_RT_OFC_CD", fac_ofc_cd); // Office

							// Contaner type/size FAC Commission
							bkgMap = dbDao.calcFACCommInfo(bkgMap);
							
							// Error return
							if(checkFacError( bkgMap )) {
								return null;
							}
							
							// FAC Commission
							bkgMap = dbDao.createFACCommInfo(bkgMap);
							
							// Error return
							if(checkFacError( bkgMap )) {
								return null;
							}
						}
						
						// FAC Commission Detail
						bkgMap = dbDao.createFACTPSZCommInfo(bkgMap);
						
						// Error return
						if(checkFacError( bkgMap )) {
							return null;
						}
						
						// Summation 
						bkgMap = dbDao.createFACTPSZSummation(bkgMap);
						

						// FAC calculation--------------end---------------
						return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error("err "+e.toString(),e);
			throw new EventException(e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * agt  biz scenario closing<br>
	 * AGTCalc biz scenario closing<br>
	 */	
	public void doEnd() {
		dbDao = null;
	}
	
	/**
	 * retun after checking Error <br>
	 * 
	 * @param HashMap map
	 * @return boolean Error 유무
	 * @exception EventException
	 */
	public boolean checkError( HashMap map ) {

		String error_msg = dbDao.checkNull((String)map.get("COMM_PROC_RSLT_RSN"));
		
		if(error_msg.length() > 0) {
			return true;
		}
		
		return false;
	}

	/**
	 * retun after checking FAC Error<br>
	 * 
	 * @param HashMap map
	 * @return boolean Error 유무
	 * @exception EventException
	 */
	public boolean checkFacError( HashMap map ) {

		HashMap fMap = (HashMap)map.get("facMap");
		String error_msg = dbDao.checkNull((String)fMap.get("COMM_PROC_RSLT_RSN"));
		
		if(error_msg.length() > 0) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * FAC Cancel event process<br>
	 * 
	 * @param String bkg_no
	 * @param String FLG0507
	 * @exception EventException
	 */
	public void processFacCancel(String bkg_no, String FLG0507) throws EventException{

		HashMap bkgMap = new HashMap();
		HashMap facMap = new HashMap();
		
		String errMsg = "";
		
		try {
			facMap.put("BKG_NO", bkg_no);				// booking no
			bkgMap.put("facMap", facMap);
			
			bkgMap.put("BKG_NO", bkg_no);
			bkgMap.put("FLG0507", FLG0507);
			
			// FAC Sequence
			bkgMap = dbDao.searchFACRateSequenceInfo( bkgMap );
			errMsg = dbDao.checkNull((String)bkgMap.get("CANCEL_FAC"));
			if(!errMsg.equals("")){
				return;
			}
			//Cancel amt
			bkgMap = bkgMap = dbDao.searchFACBKGCancelInfo(bkgMap);

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Booking QTY retrieve event process<br>
	 * 
	 * @param HashMap bkgMap
	 * @return HashMap
	 * @exception EventException
	 */
	public HashMap searchBKGQTYInfo(HashMap bkgMap) throws EventException{

		try {

			// Booking 
			bkgMap = dbDao.searchBKGQTYInfo(bkgMap);

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		
		return bkgMap;
	}
	

}