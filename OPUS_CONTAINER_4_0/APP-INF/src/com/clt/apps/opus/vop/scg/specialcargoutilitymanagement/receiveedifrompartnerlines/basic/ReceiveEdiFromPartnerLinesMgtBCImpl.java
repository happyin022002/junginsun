/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ReceiveEdiFromPartnerLinesMgtBCImpl.java
*@FileTitle : Receive Edi From PartnerLines Mgt
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.14
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.basic;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration.PartnerLinesDangerousCargoApprovalDBDAO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.PartnerApprovalRequestVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrAproRqstCgoVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrAproRqstVO;
import com.clt.apps.opus.vop.scg.scgcommon.scgexternalfinder.basic.SCGExternalFinderBC;
import com.clt.apps.opus.vop.scg.scgcommon.scgexternalfinder.basic.SCGExternalFinderBCImpl;
import com.clt.apps.opus.vop.scg.scgcommon.scgexternalfinder.vo.SearchPortVO;
import com.clt.apps.opus.vop.scg.scgcommon.scginternalfinder.basic.SCGInternalFinderBC;
import com.clt.apps.opus.vop.scg.scgcommon.scginternalfinder.basic.SCGInternalFinderBCImpl;
import com.clt.apps.opus.vop.scg.scgcommon.scgutileai.basic.ScgUtilEai;
import com.clt.apps.opus.vop.scg.scgcommon.scgutileai.vo.DgEdiFltFileVO;
import com.clt.apps.opus.vop.scg.scgcommon.scgutileai.vo.FlatFileAckVO;
import com.clt.apps.opus.vop.scg.scgcommon.scgutileai.vo.SendFlatFileVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.integration.ReceiveEdiFromParnterLinesMgtDBDAO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.integration.ReceiveEdiFromParnterLinesMgtDBDAOSelectMatchedPolClptIndSeqforEDIRSQL;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.vo.EDISpclCgoSeqMapgVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.vo.FlatFilePartnerLineVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.vo.ScgPrnrCgoDtlLogUnmapVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.vo.ScgPrnrCntrLogUnmapVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.vo.ScgPrnrSpclCgoCntrLogVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.vo.ScgPrnrSpclCgoDtlErrVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.vo.ScgPrnrSpclCgoDtlLogVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.vo.ScgPrnrSpclCgoTrsmAckVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.vo.ScgPrnrSpclCgoTrsmErrVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.vo.ScgPrnrSpclCgoTrsmHdrVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.vo.ScgPrnrTrsmHdrUnmapVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.basic.VSKCodeFinderBC;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.basic.VSKCodeFinderBCImpl;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.EffectiveVvdVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.LocationVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VesselVO;
import com.clt.apps.opus.vop.vsk.vskcommonutil.vskgeneralutil.VSKGeneralUtil;
import com.clt.bizcommon.edi.broker.ReferenceNumberGeneratorBroker;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.MdmCntrTpSzVO;
/* adding VO on FEB 11st in 2016 */


/**
 * OPUS-Receive Edi From PartnerLines Business Logic Basic Command implementation<br>
 * - Handling business transactions of OPUS-Receive Edi From PartnerLines<br>
 *
 * @author
 * @see ReceiveEdiFromPartnerLinesMgtBC
 * @since J2EE 1.6
 */
public class ReceiveEdiFromPartnerLinesMgtBCImpl extends BasicCommandSupport implements ReceiveEdiFromPartnerLinesMgtBC{
	
	// Database Access Object
	private transient ReceiveEdiFromParnterLinesMgtDBDAO      dbDao  	= null;
	// Database Access Object
	private transient PartnerLinesDangerousCargoApprovalDBDAO dbDao1 	= null;
	
	//private final String  DEFAULT_VSL_OPR_CD							= "NYK";
	String				  G_VSL_OPR_CD									= "";
	String				  G_CGO_OPR_CD									= "";
	String				  G_BKG_REF_NO									= "";
	String				  G_TRSM_DT										= "";
	String				  G_PRNR_SPCL_CGO_SEQ							= "";
	String				  G_EDI_MSG_STS_CD								= "";
	
	String				  G_EDI_MSG_REFERENCE_NO						= "";
	
	private final String  USER_ID        								= "EDI";
	private final String  CATE_CD        								= "DG";
	private final String  TRSM_IN_BND_CD 								= "I";
	private final String  TRSM_OUT_BND_CD 								= "O";
	
	/**
	 * ReceiveEdiFromPartnerLinesMgtBCImpl object creation<br>
	 * ReceiveEdiFromParnterLinesMgtDBDAO creation<br>
	 * PartnerLinesDangerousCargoApprovalDBDAO creation<br>
	 * SpecialCargoReceiptDBDAO creation<br>
	 */
	public ReceiveEdiFromPartnerLinesMgtBCImpl() {
		dbDao  = new ReceiveEdiFromParnterLinesMgtDBDAO();
		dbDao1 = new PartnerLinesDangerousCargoApprovalDBDAO();
	}
	
	/**
	 * Saving and Checking MQ Full Message<br>
	 * Saving EDI Message from terminal to DB[VSK_ACT_PORT_SKD_EDI_LOG]
	 * 
	 * @param String ediFlatFile
	 * @return VskActPortSkdEdiLogVO
	 * @exception EventException
	 */
	public List<FlatFilePartnerLineVO> manageDGEDIfromPartnerLines(String ediFlatFile) {
		
		List<FlatFilePartnerLineVO> 	flatFilePartnerLineVOs 		= new ArrayList<FlatFilePartnerLineVO>();
		List<ScgPrnrSpclCgoCntrLogVO>   scgPrnrSpclCgoCntrLogVOs	= new ArrayList<ScgPrnrSpclCgoCntrLogVO>();		
		List<ScgPrnrSpclCgoDtlLogVO>    scgPrnrSpclCgoDtlLogVOs 	= new ArrayList<ScgPrnrSpclCgoDtlLogVO>();
		
		List<EDISpclCgoSeqMapgVO>		ediSpclCgoSeqMapgVOs		= new ArrayList<EDISpclCgoSeqMapgVO>();
		List<EDISpclCgoSeqMapgVO>		finalEdiSpclCgoSeqMapgVOs	= new ArrayList<EDISpclCgoSeqMapgVO>();
		
		List<ScgPrnrSpclCgoDtlErrVO>    scgDtlErrVOs 				= new ArrayList<ScgPrnrSpclCgoDtlErrVO>();
		List<ScgPrnrSpclCgoTrsmErrVO>   scgTrsmErrVOs 				= new ArrayList<ScgPrnrSpclCgoTrsmErrVO>();
		
		/* Adding VO to handle validation checking of inputting EDI */
		List<ScgPrnrTrsmHdrUnmapVO>    	trsmHdrUnmapVOs				= new ArrayList<ScgPrnrTrsmHdrUnmapVO>	();
		List<ScgPrnrCntrLogUnmapVO>   	trsmCntrLogUnmapVOs 		= new ArrayList<ScgPrnrCntrLogUnmapVO>();
		List<ScgPrnrCgoDtlLogUnmapVO>   trsmCgoDtlLogUnmapVOs 		= new ArrayList<ScgPrnrCgoDtlLogUnmapVO>();
		
		
		VSKCodeFinderBC                 command1 					= new VSKCodeFinderBCImpl();
		SCGExternalFinderBC             command2 					= new SCGExternalFinderBCImpl();
		
		SCGInternalFinderBC             commandScgInternal 			= new SCGInternalFinderBCImpl();
		
		ScgPrnrSpclCgoTrsmHdrVO			scgHdrVO 					= new ScgPrnrSpclCgoTrsmHdrVO();
		
		boolean							isErrorExist 				= false;
		String							sErrorCode					= "";
		
		boolean							isCancelEDIforInBound		= false;
		
		try {
			
			//Split MQ Message up \n and drop new line
			ArrayList<String> flatFileList = flatFileConvertList	(ediFlatFile);
			
			//Setting {MAIN -> start, }MAIN -> end
			//Setting each {Main -> startSb because Multi data
			//Setting each }Main -> endSb because Multi data
			
			boolean isCNTRSegment 				= false;
			boolean isDGCargoSegment   			= false;
			boolean isCNTRDGCargoMappingSegment	= false;
			
			ScgPrnrSpclCgoDtlLogVO  scgPrnrSpclCgoDtlLogVO 	= new ScgPrnrSpclCgoDtlLogVO	();
			ScgPrnrSpclCgoCntrLogVO scgcntrLogVO    		= new ScgPrnrSpclCgoCntrLogVO	();			
			
			String header        		= flatFileList.get(0).toString();  
			
			G_CGO_OPR_CD				= header.substring(12,15).trim();		// SNDR_ID
			G_VSL_OPR_CD   				= header.substring(32,51).trim();		// RCVR_ID
			
			String ediMsgTp      		= header.substring(52,61).trim();		// EDI_MSG_TP_ID
			String flatFileRefNo 		= header.substring(62).trim();			// FLAT_FILE_REFERENCE_NO
			
			G_PRNR_SPCL_CGO_SEQ			= String.valueOf(searchHdrSequence());
			G_TRSM_DT					= searchTrsmDate().substring(0,8);
			scgHdrVO.setTrsmBndCd		(TRSM_IN_BND_CD);   					// TRANSMIT BOUND CODE V2
			scgHdrVO.setTrsmDt			(G_TRSM_DT);            				// TRANSMIT DATE  DB SYSDATE
			scgHdrVO.setSpclCgoCateCd	(CATE_CD);      						// SPECIAL CARGO CATEGORY CODE V2
			scgHdrVO.setPrnrSpclCgoSeq	(G_PRNR_SPCL_CGO_SEQ);     				// PARTNER SPECIAL CARGO SEQUENCE (ORACLE SEQUENCE)
			scgHdrVO.setTrsmMzdCd		(USER_ID);          					// TRANSMIT METHOD CODE V3
			scgHdrVO.setFltFileRefNo	(flatFileRefNo); 						// FLAT FILE REFERENCE NUMBER V20
			
			scgHdrVO.setEdiHdrMsg		(header);
			scgHdrVO.setEdiIfId			(flatFileRefNo);

			scgHdrVO.setCrrCd			(G_VSL_OPR_CD);
			scgHdrVO.setEdiRcvrId		(G_VSL_OPR_CD);
			
			scgHdrVO.setCgoOprCd		(G_CGO_OPR_CD);
			scgHdrVO.setEdiSndrId		(G_CGO_OPR_CD);

			scgHdrVO.setEdiMsgId		(ediMsgTp);
			scgHdrVO.setCreUsrId		(USER_ID);
			scgHdrVO.setUpdUsrId		(USER_ID);
			scgHdrVO.setEmlSndNo		(""); 									// E-MAIL SEND NO
			
			boolean	isGettingVVD		= false;
			String errPrefixChk 		= ""; // flatfile에 체크 대상 항목이 없이 들어 오는 경우 check
			
			int ffSize 					= flatFileList.size();
			
			for (int ffRow = 0; ffRow < ffSize ; ffRow++) {
				
				String[] flatKeyArr = flatFileList.get(ffRow).toString().trim().split(":",2);
				String flatKey 		= flatKeyArr[0];
				
				////2015-05-22 by TOP////scgcntrLogVO = new ScgPrnrSpclCgoCntrLogVO();
				if ("BKGNBR".equals(flatKey)) {
					String[] bkgnbrArr 	= flatFileList.get(ffRow).toString().trim().split(":",2);
					
					//String bkgNo       = VSKGeneralUtil.getCheckNullToString(bkgnbrArr[1]);
					G_BKG_REF_NO		= VSKGeneralUtil.getCheckNullToString(bkgnbrArr[1]);
							
					//if (!"".equals(bkgNo) && bkgNo.length() > 12) {
					//	bkgNo = bkgNo.substring(0, 12);
					//}
					
					if (!"".equals(G_BKG_REF_NO) && G_BKG_REF_NO.length() > 12) {
						G_BKG_REF_NO = G_BKG_REF_NO.substring(0,12);
					}
					
					scgHdrVO.setBkgRefNo(G_BKG_REF_NO);                                                              //BKGNBR		
					
				} else if ("BKG_DT".equals(flatKey)) {
					String[] bkgDtArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
					scgHdrVO.setBkgCreLoclDt	(VSKGeneralUtil.getCheckNullToString(bkgDtArr[1]));                  //BKG_DT       
					scgHdrVO.setBkgCreLoclDtCtnt(VSKGeneralUtil.getCheckNullToString(bkgDtArr[1]));                  //BKG_DT
				} else if ("BRAC".equals(flatKey)) {               
					String[] bracArr = flatFileList.get(ffRow).toString().trim().split(":",2);
					scgHdrVO.setEdiMsgStsCd(VSKGeneralUtil.getCheckNullToString(bracArr[1]));                        //BRAC     // N(New), R(Cancel), U(Update)     
					
					G_EDI_MSG_STS_CD	= scgHdrVO.getEdiMsgStsCd();
					
					/** Adding for REJECT : 2015-09-14 **/
					if("R".equals(G_EDI_MSG_STS_CD))	isCancelEDIforInBound	= true;
					
					/** ======================================================================
					 *  Mandatory Item In case of cancellation EDI :: 2015-09-24 by Huma Syed
					 *  There are only 2 items.
					 *  ----------------------------------------------------------------------
					 * 	1. BOOKING NUMBER
					 *  2. POL
					 *  ======================================================================
					 */
					
				} else if ("REFNBR".equals(flatKey)) {               
					String[] refnbrArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
					scgHdrVO.setEdiMsgRefNo(VSKGeneralUtil.getCheckNullToString(refnbrArr[1]));                    	//REFNBR       
				} else if ("CTRLREFNBR".equals(flatKey)) {               
					String[] ctrlRefNbrArr = flatFileList.get(ffRow).toString().trim().split(":", 2);               
					scgHdrVO.setCtrlRefNo(VSKGeneralUtil.getCheckNullToString(ctrlRefNbrArr[1]));                   //CTRLREFNBR					
				} else if ("VSL_CALLSIGN".equals(flatKey)) {               
					String[] vslCallsingArr = flatFileList.get(ffRow).toString().trim().split(":", 2);               
					scgHdrVO.setCallSgnNo(VSKGeneralUtil.getCheckNullToString(vslCallsingArr[1]));          //VSL_CALLSIGN
				} else if ("VSL_LLOYDCODE".equals(flatKey)) {               
					String[] vslLloydcodeArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
					scgHdrVO.setLloydNo(VSKGeneralUtil.getCheckNullToString(vslLloydcodeArr[1]));        //VSL_LLOYDCODE
				} else if ("VSL_FULLNAME".equals(flatKey)) {               
					String[] vslFullnameArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
					scgHdrVO.setVslEngFullNm(VSKGeneralUtil.getCheckNullToString(vslFullnameArr[1]));          //VSL_FULLNAME 
				} else if ("VVD_REF_NO".equals(flatKey)) {               
					String[] vvdRefNoArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
					scgHdrVO.setShpCallNo(VSKGeneralUtil.getCheckNullToString(vvdRefNoArr[1]));                //VVD_REF_NO   
				} else if ("CONSORT_VOY".equals(flatKey)) {               
					String[] consortVoyArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
					scgHdrVO.setInBndCssmVoyNo	("");            
					scgHdrVO.setOutBndCssmVoyNo	(VSKGeneralUtil.getCheckNullToString(consortVoyArr[1]));            //CONSORT_VOY 
				} else if ("POR_CD".equals(flatKey)) {               
					String[] polCdArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
					scgHdrVO.setPorCd(VSKGeneralUtil.getCheckNullToString(polCdArr[1]));                      //POL_CD       
				}  else if ("POR_NM".equals(flatKey)) {               
					String[] polCdArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
					scgHdrVO.setPorNm(VSKGeneralUtil.getCheckNullToString(polCdArr[1]));                      //POL_CD       
				} else if ("POL_CD".equals(flatKey)) {               
					String[] polCdArr     = flatFileList.get(ffRow).toString().trim().split(":",2);     
					LocationVO locationVO = new LocationVO();
					
					if (polCdArr[1] != null && polCdArr[1].length() == 5) {
					    scgHdrVO.setPolCd	(VSKGeneralUtil.getCheckNullToString(polCdArr[1]));                      //POL_CD
					    scgHdrVO.setPolYdCd	(VSKGeneralUtil.getCheckNullToString(polCdArr[1]));                    //POL_CD
					    locationVO.setLocCd	(VSKGeneralUtil.getCheckNullToString(polCdArr[1]));
					} else if (polCdArr[1] != null && polCdArr[1].length() == 7){
						scgHdrVO.setPolCd	(VSKGeneralUtil.getCheckNullToString(polCdArr[1]).substring(0,5));
						scgHdrVO.setPolYdCd	(VSKGeneralUtil.getCheckNullToString(polCdArr[1]));
						locationVO.setLocCd	(VSKGeneralUtil.getCheckNullToString(polCdArr[1]).substring(0,5));
					} else if (polCdArr[1] == null || "".equals(polCdArr[1])) {
						locationVO.setLocCd	("");
					}
					
					String sRgnShpOprCd		= commandScgInternal.searchRSOforSpecificPort(locationVO);
					
					if(sRgnShpOprCd != null && !"".equals(sRgnShpOprCd)){
						scgHdrVO.setRgnShpOprCd	(sRgnShpOprCd);
					}else{
						//:2016-02-11:by TOP://scgTrsmErrVOs.add(setTrsmErr(scgHdrVO, 50003));
						
						/** 
						 *	"011" : "Cannot find proper RSO" 
						 *  "012" : "Not exist corresponding POL in VVD"	
						 *  "013" : "Not exist corresponding POD in VVD"	
						 *  "021" : "Cannot find proper calling indicator in POL"	
						 *  "022" : "Cannot find proper calling indicator in POD"	
						 **/
						trsmHdrUnmapVOs.add	(this.setTrsmHdrUnmap(scgHdrVO, "011"));
						
						//XXX//scgHdrVO.setEdiUnmapKndCd						("XXX");
					}
					
				} else if ("POL_NM".equals(flatKey)) {               
					String[] polNmArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
					scgHdrVO.setPolNm(VSKGeneralUtil.getCheckNullToString(polNmArr[1]));                      //POL_NM       
				} else if ("POD_CD".equals(flatKey)) {               
					String[] podCdArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
					
					if (podCdArr[1] != null && podCdArr[1].length() == 5) {
						scgHdrVO.setPodCd	(VSKGeneralUtil.getCheckNullToString(podCdArr[1])); 
						scgHdrVO.setPodYdCd	(VSKGeneralUtil.getCheckNullToString(podCdArr[1])); 
					} else if (podCdArr[1] != null && podCdArr[1].length() == 7) {
						scgHdrVO.setPodCd	(VSKGeneralUtil.getCheckNullToString(podCdArr[1]).substring(0,5)); 
						scgHdrVO.setPodYdCd	(VSKGeneralUtil.getCheckNullToString(podCdArr[1])); 
					} else {
						scgHdrVO.setPodCd	(""); 
						scgHdrVO.setPodYdCd	(""); 
					}    
					
				} else if ("POD_NM".equals(flatKey)) {               
					String[] podNmArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
					scgHdrVO.setPodNm(VSKGeneralUtil.getCheckNullToString(podNmArr[1]));                      //POD_NM       

				} else if ("PLD_CD".equals(flatKey)) {               
					String[] pldCdArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
					
					if (pldCdArr[1] != null && pldCdArr[1].length() == 5) {
						scgHdrVO.setDelCd	(VSKGeneralUtil.getCheckNullToString(pldCdArr[1]));                    //PLD_CD 
						scgHdrVO.setDelYdCd	(VSKGeneralUtil.getCheckNullToString(pldCdArr[1])); 						
					} else if (pldCdArr[1] != null && pldCdArr[1].length() == 7){
						scgHdrVO.setDelCd	(VSKGeneralUtil.getCheckNullToString(pldCdArr[1]).substring(0,5)); 
						scgHdrVO.setDelYdCd	(VSKGeneralUtil.getCheckNullToString(pldCdArr[1])); 						
					} else {
						scgHdrVO.setDelCd	(""); 
						scgHdrVO.setDelYdCd	(""); 
					}
				} else if ("PLD_NM".equals(flatKey)) {
					String[] pldNmArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
					scgHdrVO.setDelNm(VSKGeneralUtil.getCheckNullToString(pldNmArr[1]));                      //PLD_NM     
					
					isGettingVVD = true;	/** The last part among DG item segment	**/
					
				}
				
				if(flatFileList.get(ffRow).indexOf("{CNTR_INFO") > -1) {
					
					isCNTRSegment     = true;
					
					////2015-05-22 by TOP////
					scgcntrLogVO = new ScgPrnrSpclCgoCntrLogVO();
					
					scgcntrLogVO.setTrsmBndCd		(TRSM_IN_BND_CD);
					scgcntrLogVO.setTrsmDt			(G_TRSM_DT);
					scgcntrLogVO.setSpclCgoCateCd	(CATE_CD);
					scgcntrLogVO.setPrnrSpclCgoSeq	(G_PRNR_SPCL_CGO_SEQ);
					scgcntrLogVO.setCreUsrId		(USER_ID);
					scgcntrLogVO.setUpdUsrId		(USER_ID);
					
					continue;
				}
				
				if(flatFileList.get(ffRow).indexOf("}CNTR_INFO") > -1) {
					isCNTRSegment = false;
					
					scgPrnrSpclCgoCntrLogVOs.add(scgcntrLogVO);
					continue;
				}
				
				
				if (isCNTRSegment) {

					if ("CNTR_SEQ".equals(flatKey)) {
						String[] cntrSeqArr 	= flatFileList.get(ffRow).toString().trim().split(":",2);               
						scgcntrLogVO.setCntrSeq	(VSKGeneralUtil.getCheckNullToString(cntrSeqArr[1]));                 	//CNTR_SEQ
						
					} else if ("CNTR_NO".equals(flatKey)) {
						String[] cntrNoArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
						scgcntrLogVO.setCntrRefNo(VSKGeneralUtil.getCheckNullToString(cntrNoArr[1]));                   //CNTR_NO   
						
					} else if ("CNTR_TPSZ".equals(flatKey)) {
						String[] cntrTpszArr 	= flatFileList.get(ffRow).toString().trim().split(":",2);               
						scgcntrLogVO.setCntrTpszCdCtnt(VSKGeneralUtil.getCheckNullToString(cntrTpszArr[1]));            //CNTR_TPSZ    
						
						String sTmpCntrSzTp		= cntrTpszArr[1];
						
						MdmCntrTpSzVO mdmCntrTpSzVO 		= new MdmCntrTpSzVO();
						mdmCntrTpSzVO.setCntrTpszCd			(sTmpCntrSzTp == null || "".equals(sTmpCntrSzTp) ? "XXXXX" : sTmpCntrSzTp );
					    //System.out.println(">>>>>>>>>>>>>>>>>>>>TEST TEST<<<<<<<<<<<<<" + ">>>>>>>>>>>>>>>>" + sTmpCntrSzTp + ":::::::" + mdmCntrTpSzVO  );
					    
						List<MdmCntrTpSzVO> tpszList 		= command2.searchCNTRTPSZ(mdmCntrTpSzVO);	
						
						if(tpszList != null && tpszList.size()>0){
							
							scgcntrLogVO.setIsoCntrTpszCd	(VSKGeneralUtil.getCheckNullToString(tpszList.get(0).getCntrTpszIsoCd()));	
						}else{
							
							/** 
							 *	"101" : "Unmapped container type/size with conversion table"
							 *  ----------------------------------------------------------------
							 *  "201" : "Cannot find proper UN No SEQ." 
							 *  "202" : "No technical name in DG Application."	
							 **/
							
							trsmCntrLogUnmapVOs.add			(this.setTrsmCntrLogUnmap(scgcntrLogVO, "101"));
							
							
						}
					}
				}
				
				///////////////////////// Getting Proper VVD Information ///////////////////////////////////////////////////////
				if (isGettingVVD) {
					
					VesselVO vesselVO 		= new VesselVO();
					vesselVO.setCallSgnNo	(scgHdrVO.getCallSgnNo	());
					vesselVO.setLloydNo		(scgHdrVO.getLloydNo	());
					
					// VVD CHECK
					List<String> vslCdList 	= new ArrayList<String>();
					List<VesselVO> list 	= command1.searchVslCd(vesselVO);	/** Finding Vessel Code by using Call Sign No or Lloyd Number **/

					for (int row = 0; row < list.size(); row++) {
						vslCdList.add(list.get(row).getVslCd());
					}
					
					if (vslCdList.size() <= 0) {
						scgTrsmErrVOs.add(setTrsmErr(scgHdrVO, 13003));			/** 13003 :  "VESSEL DOES NOT EXIST." **/
					}else if(vslCdList.size() == 1) {
						scgHdrVO.setVslCd	(list.get(0).getVslCd());
					}
					
					EffectiveVvdVO	paramVO	= new EffectiveVvdVO();
					paramVO.setCallSgnNo			(scgHdrVO.getCallSgnNo		());
					paramVO.setLloydNo				(scgHdrVO.getLloydNo		());
					paramVO.setObCssmVoyNo			(scgHdrVO.getOutBndCssmVoyNo());
					
					paramVO.setPolCd				(scgHdrVO.getPolCd			());
					paramVO.setPodCd				(scgHdrVO.getPodCd			());
					
					//:VSKCodeFinderDBDAOIdentifyProperVVDinCandidateRSQL://
					EffectiveVvdVO	tmpEffVO		= command1.searchProperVVDinCandidate(paramVO, "DG_EDI");
					
					if("S".equals(tmpEffVO.getEffectiveVvdChkRsltCd())){
						scgHdrVO.setSlanCd			(tmpEffVO.getVslSlanCd	());
						scgHdrVO.setVslCd			(tmpEffVO.getVslCd		());
						scgHdrVO.setSkdVoyNo		(tmpEffVO.getSkdVoyNo	());
						scgHdrVO.setSkdDirCd		(tmpEffVO.getSkdDirCd	());
					}else{
						scgTrsmErrVOs.add			(this.setTrsmErr(scgHdrVO, 13013));		/** 13013 :  "V/V/L OF BOOKING IS DIFFERENT FROM ORIGINAL." **/
					}
					
					/********************************************************************************
					 *  Making POL/POD Calling Port Indicator 
					 * ==============================================================================
					 */
					paramVO.setVslCd				(scgHdrVO.getVslCd			());
					paramVO.setSkdVoyNo				(scgHdrVO.getSkdVoyNo		());
					paramVO.setSkdDirCd				(scgHdrVO.getSkdDirCd		());
					
					paramVO.setPolClptIndSeq		(scgHdrVO.getPolClptIndSeq	());
					
					//:ReceiveEdiFromParnterLinesMgtDBDAOSelectMatchedPolClptIndSeqforEDIRSQL://
					String sMatchedPolClptIndSeq	= dbDao.selectMatchedPolClptIndSeqforEDI(paramVO);
					
					if(Integer.parseInt(sMatchedPolClptIndSeq)<=0){
						//:2016-02-11:by TOP://scgTrsmErrVOs.add	(this.setTrsmErr(scgHdrVO, 90011));		/** 90011 :  "Cannot find Proper Calling Indicator of POL" **/
						
						/** 
						 *	"011" : "Cannot find proper RSO" 
						 *  "012" : "Not exist corresponding POL in VVD"	
						 *  "013" : "Not exist corresponding POD in VVD"	
						 *  "021" : "Cannot find proper calling indicator in POL"	
						 *  "022" : "Cannot find proper calling indicator in POD"	
						 **/
						trsmHdrUnmapVOs.add	(this.setTrsmHdrUnmap(scgHdrVO, "021"));
						
					}else{
						
						scgHdrVO.setPolClptIndSeq		(sMatchedPolClptIndSeq);
						paramVO.setPolClptIndSeq		(sMatchedPolClptIndSeq);	
						
						/** Exit in case of cancellation EDI :: 2015-09-24 **/
						if(!isCancelEDIforInBound){
							
							String sMatchedPodClptIndSeq	= dbDao.selectMatchedPodClptIndSeqforEDI(paramVO);
							if(Integer.parseInt(sMatchedPodClptIndSeq)<=0){
								//:2016-02-11:by TOP://scgTrsmErrVOs.add	(this.setTrsmErr(scgHdrVO, 90012));	/** 90012 :  "Cannot find Proper Calling Indicator of POD" **/
								
								/** 
								 *	"011" : "Cannot find proper RSO" 
								 *  "012" : "Not exist corresponding POL in VVD"	
								 *  "013" : "Not exist corresponding POD in VVD"	
								 *  "021" : "Cannot find proper calling indicator in POL"	
								 *  "022" : "Cannot find proper calling indicator in POD"	
								 **/
								trsmHdrUnmapVOs.add	(this.setTrsmHdrUnmap(scgHdrVO, "022"));
								
							}else{
								scgHdrVO.setPolClptIndSeq	(sMatchedPolClptIndSeq);
								paramVO.setPolClptIndSeq	(sMatchedPolClptIndSeq);						
							}
							scgHdrVO.setPodClptIndSeq		(sMatchedPodClptIndSeq);	
							
						}

					}
					/********************************************************************************/

				}
				
				isGettingVVD	= false;
				///////////////////////// Getting Proper VVD Information ///////////////////////////////////////////////////////
			}
			
			
			/** ========================================================================
			 *  Correction evaluation for EDI Message Status : ['NEW','UPDATE','REJECT'] 
			 *  ------------------------------------------------------------------------
			 *  2015-07-28 by TOP
			 *  CARGO OPERATOR, BKG REF NO, POL, POD
			 *  ========================================================================
			 */
			//Map<String, String> mapVO 		= new HashMap<String, String>();
			//mapVO.put("trsm_bnd_cd"      	, scgHdrVO.getTrsmBndCd			());
			//mapVO.put("trsm_dt"          	, scgHdrVO.getTrsmDt			());
			//mapVO.put("spcl_cgo_cate_cd" 	, scgHdrVO.getSpclCgoCateCd		());
			//mapVO.put("prnr_spcl_cgo_seq"	, scgHdrVO.getPrnrSpclCgoSeq	());
			//mapVO.put("bkg_no"           	, scgHdrVO.getBkgRefNo			());
			//mapVO.put("cgo_opr_cd"			, scgHdrVO.getCgoOprCd			());
			
			String ediMsgStsCd 				= dbDao.searchRejectStatus		(scgHdrVO);
			/** ========================================================================*/
			
			
			if ("".equals(ediMsgStsCd) && !"N".equals(scgHdrVO.getEdiMsgStsCd())) {
				scgTrsmErrVOs.add(setTrsmErr(scgHdrVO, 13007));			/** 13007 : "BOOKING NOT RECEIVED WENT SEND AS ORIGINAL."		*/
			} else if ("N".equals(ediMsgStsCd) && "N".equals(scgHdrVO.getEdiMsgStsCd())) {
				scgTrsmErrVOs.add(setTrsmErr(scgHdrVO, 13006));			/** 13006 : "BOOKING ALREADY RECEIVED WENT SENT AS ORIGINAL." 	*/
			} else if ("U".equals(ediMsgStsCd) && "N".equals(scgHdrVO.getEdiMsgStsCd())) {
				scgTrsmErrVOs.add(setTrsmErr(scgHdrVO, 13006));			/** 13006 : "BOOKING ALREADY RECEIVED WENT SENT AS ORIGINAL." 	*/
			} else if ("R".equals(ediMsgStsCd) && "R".equals(scgHdrVO.getEdiMsgStsCd())) {
				scgTrsmErrVOs.add(setTrsmErr(scgHdrVO, 13006));			/** 13006 : "BOOKING ALREADY RECEIVED WENT SENT AS ORIGINAL." 	*/
			}
			
			String srcTpCd     				= dbDao.searchChkSystemByManual	(scgHdrVO);
			// system에서 manual로 입력시 srcTpCd 'MNL', 'M'
            // edi로 넘겨 왔을 경우 'EDI', 'E'
			if ("M".equals(srcTpCd)) {
				scgTrsmErrVOs.add(setTrsmErr(scgHdrVO, 13011));			/** 13011 : "BOOKING ALREADY RECEIVED FROM BOOKING SYSTEM BY MANUALY."	**/
			} else if ("N".equals(scgHdrVO.getEdiMsgStsCd()) && !"".equals(srcTpCd)) {
				scgTrsmErrVOs.add(setTrsmErr(scgHdrVO, 13011));			/** 13011 : "BOOKING ALREADY RECEIVED FROM BOOKING SYSTEM BY MANUALY."	**/
			}		
			
			
			/** =============================================================================================== 
			 *  Adding Functionality for CANCELLATION DG EDI IN BOUND 
			 *  -----------------------------------------------------------------------------------------------
			 *  2015-09-14 by TOP
			 *  =============================================================================================== **/
			if(isCancelEDIforInBound){
				
				//SUCCESS FOR CANCELLATION
				//if(scgTrsmErrVOs.isEmpty()){
					
					this.manageCancelDGEDIfromPartnerLines(ediFlatFile, scgHdrVO, scgTrsmErrVOs);
					return null;
					
				//FAIL FOR CANCELLATION
				//}else{
					
				//}
				
			}
			/** =============================================================================================== **/
			
			//13008
			
			String sPolEtaDt = "";
			String sPodEtaDt = "";
			
			//vvd별 loc_cd로  vps_eta_dt조회 
			
			if (scgHdrVO.getVslCd	() != null && scgHdrVO.getVslCd		().length() > 0 &&
				scgHdrVO.getSkdVoyNo() != null && scgHdrVO.getSkdVoyNo	().length() > 0 &&
				scgHdrVO.getSkdDirCd() != null && scgHdrVO.getSkdDirCd	().length() > 0) 
			{
			
				SearchPortVO searchPortVO 	= new SearchPortVO();
				
				searchPortVO.setVslCd		(scgHdrVO.getVslCd			());
				searchPortVO.setSkdVoyNo	(scgHdrVO.getSkdVoyNo		());
				searchPortVO.setSkdDirCd	(scgHdrVO.getSkdDirCd		());
				searchPortVO.setLocCd		(scgHdrVO.getPolCd() 			== null || "".equals(scgHdrVO.getPolCd()) 			? "XXXXX" 	: scgHdrVO.getPolCd());
				searchPortVO.setClptIndSeq	(scgHdrVO.getPolClptIndSeq() 	== null || "".equals(scgHdrVO.getPolClptIndSeq()) 	? "0" 		: scgHdrVO.getPolClptIndSeq());
				
				List<SearchPortVO> searchPortList = command2.searchPort(searchPortVO);	/*	SCGExternalFinderDBDAOSearchPortVORSQL	*/
				
				if (searchPortList.size() > 0) {
					sPolEtaDt = searchPortList.get(0).getVpsEtaDt();
				} else {
					//:2016-02-11:by TOP://scgTrsmErrVOs.add(setTrsmErr(scgHdrVO, 50001));
					
					/** 
					 *	"011" : "Cannot find proper RSO" 
					 *  "012" : "Not exist corresponding POL in VVD"	
					 *  "013" : "Not exist corresponding POD in VVD"	
					 *  "021" : "Cannot find proper calling indicator in POL"	
					 *  "022" : "Cannot find proper calling indicator in POD"	
					 **/
					trsmHdrUnmapVOs.add	(this.setTrsmHdrUnmap(scgHdrVO, "012"));
					
					//XXX//scgHdrVO.setEdiUnmapKndCd						("XXX");
				}
				
				
				//searchPortVO.setLocCd		(scgHdrVO.getPodCd			());
				//searchPortVO.setClptIndSeq	(scgHdrVO.getPodClptIndSeq	());
				searchPortVO.setLocCd		(scgHdrVO.getPodCd() 			== null || "".equals(scgHdrVO.getPodCd()) 			? "XXXXX" 	: scgHdrVO.getPodCd());
				searchPortVO.setClptIndSeq	(scgHdrVO.getPodClptIndSeq() 	== null || "".equals(scgHdrVO.getPodClptIndSeq()) 	? "0" 		: scgHdrVO.getPodClptIndSeq());
				
				searchPortList = command2.searchPort(searchPortVO);
				if (searchPortList.size() > 0) {
					sPodEtaDt = searchPortList.get(0).getVpsEtaDt();
				} else {
					//:2016-02-11:by TOP://scgTrsmErrVOs.add(setTrsmErr(scgHdrVO, 50002));

					/** 
					 *	"011" : "Cannot find proper RSO" 
					 *  "012" : "Not exist corresponding POL in VVD"	
					 *  "013" : "Not exist corresponding POD in VVD"	
					 *  "021" : "Cannot find proper calling indicator in POL"	
					 *  "022" : "Cannot find proper calling indicator in POD"	
					 **/
					trsmHdrUnmapVOs.add	(this.setTrsmHdrUnmap(scgHdrVO, "013"));
					
					//XXX//scgHdrVO.setEdiUnmapKndCd						("XXX");
				}
			}
			
			int prnrSpclCgoSubSeq  = searchDtlLogSequence	(scgHdrVO);	
			
			
			/********** Starting parsing in DG Item Segment	***********//********** Starting parsing in DG Item Segment	***********/
			/**********************************************************************************************************************/
			
			// SCG PARTNER SPECIAL CARGO DETAIL LOG INSERT 			
			for (int ffRow = 0; ffRow < ffSize; ffRow++ ) {
				
				String[] flatKeyArr = flatFileList.get(ffRow).toString().trim().split(":",2);

				if(flatFileList.get(ffRow).indexOf("{CNTR_DG") > -1) {
					
					scgPrnrSpclCgoDtlLogVO 						= new ScgPrnrSpclCgoDtlLogVO();
					
					scgPrnrSpclCgoDtlLogVO.setTrsmBndCd			(TRSM_IN_BND_CD);
					scgPrnrSpclCgoDtlLogVO.setTrsmDt			(G_TRSM_DT);
					scgPrnrSpclCgoDtlLogVO.setSpclCgoCateCd		(CATE_CD);
					scgPrnrSpclCgoDtlLogVO.setPrnrSpclCgoSeq	(G_PRNR_SPCL_CGO_SEQ);
					scgPrnrSpclCgoDtlLogVO.setPrnrSpclCgoSubSeq	(String.valueOf(prnrSpclCgoSubSeq));
					scgPrnrSpclCgoDtlLogVO.setCreUsrId			(USER_ID);
					scgPrnrSpclCgoDtlLogVO.setUpdUsrId			(USER_ID);
					
					isDGCargoSegment 							= true;
					
					continue;
				}
				
				//CARGO Level 
				if(flatFileList.get(ffRow).indexOf("}CNTR_DG") > -1) {
					
					Map<String, String> cgoMap 		= new HashMap<String, String>();
					cgoMap.put("bkg_no"           	, scgHdrVO.getBkgRefNo					());
					cgoMap.put("cntr_ref_no"      	, scgPrnrSpclCgoDtlLogVO.getCntrRefNo	());
					
					//::2015-05-30:by TOP:://cgoMap.put("ref_no"           , scgPrnrSpclCgoDtlLogVO.getRefNo());
					cgoMap.put("dcgo_ref_no"      	, scgPrnrSpclCgoDtlLogVO.getDcgoRefNo	());
					
					cgoMap.put("trsm_bnd_cd"      	, scgPrnrSpclCgoDtlLogVO.getTrsmBndCd	());
					
					boolean isCNTRSegmentError 		= false;

					
					/** Starting parsing CNTR Segment *******************************
					 * --------------------------------------------------------------
					 * {CNTR_INFO
					 * CNTR_SEQ
					 * CNTR_NO
					 * CNTR_TPSZ
					 * }CNTR_INFO
					 * --------------------------------------------------------------
					 */
					for (int cntrRow = 0; cntrRow < scgPrnrSpclCgoCntrLogVOs.size(); cntrRow++) {
						
						//::2015-09-03:No need because of multi container & multi cargo:://if (scgPrnrSpclCgoDtlLogVO.getCntrRefNo().equals(scgPrnrSpclCgoCntrLogVOs.get(cntrRow).getCntrRefNo())) {
							
							//::2015-09-03:No need because of multi container & multi cargo:://scgPrnrSpclCgoDtlLogVO.setCntrTpszCdCtnt(scgPrnrSpclCgoCntrLogVOs.get(cntrRow).getCntrTpszCdCtnt());
							//::2015-09-03:No need because of multi container & multi cargo:://scgPrnrSpclCgoDtlLogVO.setIsoCntrTpszCd	(scgPrnrSpclCgoCntrLogVOs.get(cntrRow).getIsoCntrTpszCd	());
							
							//::2015-09-03:No need because of multi container & multi cargo:://scgPrnrSpclCgoDtlLogVO.setCntrSeq		(scgPrnrSpclCgoCntrLogVOs.get(cntrRow).getCntrSeq		());
							
							//:2015-07-21:by TOP://isCNTRSegmentError = true;
							/** <<NEW>> DG BKG ******************************/
							if ("N".equals(scgHdrVO.getEdiMsgStsCd())) {
								
								scgPrnrSpclCgoCntrLogVOs.get(cntrRow).setIbflag	("I");
								scgPrnrSpclCgoDtlLogVO.setIbflag				("I");
								scgPrnrSpclCgoDtlLogVO.setDcgoStsCdCtnt			("N");
							
							/** <<REJECT>> DG BKG ***************************/
							} else if("R".equals(scgHdrVO.getEdiMsgStsCd())) {
								
								scgPrnrSpclCgoCntrLogVOs.get(cntrRow).setIbflag	("D");
								scgPrnrSpclCgoDtlLogVO.setIbflag				("D");
								scgPrnrSpclCgoDtlLogVO.setDcgoStsCdCtnt			("X");			/* -- ::2015-07-28:by TOP:: -- */
								
								Map<String, String> cntrMap 									= dbDao.searchDgCntrStatus	(scgHdrVO);
								scgPrnrSpclCgoCntrLogVOs.get(cntrRow).setMapgTrsmBndCd			(cntrMap.get("trsm_bnd_cd"));
								scgPrnrSpclCgoCntrLogVOs.get(cntrRow).setMapgTrsmDt				(cntrMap.get("trsm_dt"));
								scgPrnrSpclCgoCntrLogVOs.get(cntrRow).setMapgTrsmSpclCgoCateCd	(cntrMap.get("spcl_cgo_cate_cd"));
								scgPrnrSpclCgoCntrLogVOs.get(cntrRow).setMapgPrnrSpclCgoSeq		(cntrMap.get("prnr_spcl_cgo_seq"));
								
							/** <<UPDATE>> DG BKG **************************/
							} else if ("U".equals(scgHdrVO.getEdiMsgStsCd())) {
								
								//dg : searchDgCntrStatus
								Map<String, String> cntrMap = dbDao.searchDgCntrStatus	(scgHdrVO);								
								String 				cntrCnt = cntrMap.get("cntr_cnt");
								
								if("Y".equals(cntrCnt)) {
									scgPrnrSpclCgoCntrLogVOs.get(cntrRow).setIbflag					("U");
									scgPrnrSpclCgoCntrLogVOs.get(cntrRow).setMapgTrsmBndCd			(cntrMap.get("trsm_bnd_cd"));
									scgPrnrSpclCgoCntrLogVOs.get(cntrRow).setMapgTrsmDt				(cntrMap.get("trsm_dt"));
									scgPrnrSpclCgoCntrLogVOs.get(cntrRow).setMapgTrsmSpclCgoCateCd	(cntrMap.get("spcl_cgo_cate_cd"));
									scgPrnrSpclCgoCntrLogVOs.get(cntrRow).setMapgPrnrSpclCgoSeq		(cntrMap.get("prnr_spcl_cgo_seq"));
								} else {
									scgPrnrSpclCgoCntrLogVOs.get(cntrRow).setIbflag					("I");	/* -- ::2015-07-28:by TOP:: -- */
								}
								
								//cntr : searchDgCgoCnt
								scgHdrVO.setDcgoRefNo(scgPrnrSpclCgoDtlLogVO.getDcgoRefNo());
								String rtnStr = dbDao.searchDgCgoCnt		(scgHdrVO);
								
								if("Y".equals(rtnStr)) {
									scgPrnrSpclCgoDtlLogVO.setIbflag		("U");
									scgPrnrSpclCgoDtlLogVO.setDcgoStsCdCtnt	("U");
								} else {									
									scgPrnrSpclCgoDtlLogVO.setIbflag		("I");
									scgPrnrSpclCgoDtlLogVO.setDcgoStsCdCtnt	("N");	/* -- ::2015-07-28:by TOP:: -- */
								}
							}
							/** END OF IDENTIFICATION DG BKG STATUS **/
							
							break;
						
						//::2015-09-03:No need because of multi container & multi cargo:://}
							
					}
					/** Finished parsing CNTR Segment ********************************/
					/*****************************************************************/
					
					
					//:2015-07-21:by TOP://if (!isCNTRSegmentError) {
					if (isCNTRSegmentError) {
						scgDtlErrVOs.add(setDtlErr(scgPrnrSpclCgoDtlLogVO, 50004)); // cntr no not exists
						
						/** 
						 *	"000" : "Segment structure error in EDI file" 
						 *  "001" : "Container Number mismatched in EDI file"	
						 **/
						trsmHdrUnmapVOs.add	(this.setTrsmHdrUnmap(scgHdrVO, "000"));
						
						//XXX//scgHdrVO.setEdiUnmapKndCd						("XXX");
					}
					
					
					/** Appending VO to VOs for *CargoDtlLog ***********//** Appending VO to VOs for *CargoDtlLog ***********//** Appending VO to VOs for *CargoDtlLog ***********/
					scgPrnrSpclCgoDtlLogVOs.add	(scgPrnrSpclCgoDtlLogVO);
					/*************************************************************************************************************************************************************/
					
					//CHEMICAL NAME REQUIRED.
					////if(!"1".equals(dbDao.searchUnNoIno(scgPrnrSpclCgoDtlLogVO.getImdgUnNoCtnt(), scgPrnrSpclCgoDtlLogVO.getPrpShpNm()))) {
					////	scgDtlErrVOs.add(setDtlErr(scgPrnrSpclCgoDtlLogVO, 13009));
					////}

					//CHEMICAL NAME REQUIRED. -- In case of including 'NOS' in PSN  
					//if(		(scgPrnrSpclCgoDtlLogVO.getPrpShpNm().contains("NOS"))	|| scgPrnrSpclCgoDtlLogVO.getPrpShpNm().contains("N.O.S") 
					//	&&	(scgPrnrSpclCgoDtlLogVO.getImdgTecNm() == null 			|| "".equals(scgPrnrSpclCgoDtlLogVO.getImdgTecNm()))
					//	&&	!"Y".equals(scgPrnrSpclCgoDtlLogVO.getCfrFlg())
					//	) 
					//{
						/** 2015-09-09:Commented by TOP:Requested by Huma Syed & Tom Waller, 2015-09-15 : Rollback by TOM Waller **/
					//	scgDtlErrVOs.add(setDtlErr(scgPrnrSpclCgoDtlLogVO, 13009));
					//}
					
					//NET POWDER WEIGHT REQUIRED FOR CLASS 1.   
					if ("1".equals(scgPrnrSpclCgoDtlLogVO.getImdgClssCdCtnt()) && "".equals(scgPrnrSpclCgoDtlLogVO.getNetExploWgtCtnt())) {
						scgDtlErrVOs.add(setDtlErr(scgPrnrSpclCgoDtlLogVO, 12006));
					}
					
					++prnrSpclCgoSubSeq;
					isDGCargoSegment 				= false;
					
					continue;
				}
				
				
				String flatKey = flatKeyArr[0];
				
				/** Starting parsing CNTR Segment ******************************
				 * -------------------------------------------------------------
				 * {CNTR_DG
					ITEM_SEQ
					...
					
					
					::Adding 2015-10-22::
					CGO_STS			e.g. L(Liquid), P(Paste), G(Gas), S(Solid)
					SEG_GRP			e.g. Acids
					SEG_GRPS_NBR	e.g. 1 (1~18)
					::Adding 2015-10-22::
					  
					 
					CNTRNBR
					{DG_CNTR_INFO
					DG_CNTRNBR
					}DG_CNTR_INFO
					...
					{REMARK
					REMARK
					}REMARK
					}CNTR_DG
				 * -------------------------------------------------------------
				 */
				if (isDGCargoSegment) {
					
					if ("ITEM_SEQ".equals(flatKey)) {
						String[] itemSeqArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
						//:2015-07-25://scgPrnrSpclCgoDtlLogVO.setCgoSeq(VSKGeneralUtil.getCheckNullToString(itemSeqArr[1]));                 //ITEM_SEQ <== CGO_SEQ
						scgPrnrSpclCgoDtlLogVO.setEdiItmSeq(VSKGeneralUtil.getCheckNullToString(itemSeqArr[1]));
						//scgPrnrSpclCgoDtlLogVO.setCgoSeq(VSKGeneralUtil.getCheckNullToString(itemSeqArr[1]));
						//TOP.TOP.TOP 2015-07-25 나중에 삭제대상임//
						
					} else if ("DG_REF".equals(flatKey)) {
						String[] dcgoRefArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
						scgPrnrSpclCgoDtlLogVO.setDcgoRefNo(VSKGeneralUtil.getCheckNullToString(dcgoRefArr[1]));              //DG_REF - DG REF NO     
					} else if ("MV_TP".equals(flatKey)) {
						String[] mvTpArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
						scgPrnrSpclCgoDtlLogVO.setMvmtSpclTpCd(VSKGeneralUtil.getCheckNullToString(mvTpArr[1]));               
					} else if ("OPKG_QTY".equals(flatKey)) {
						String[] opkgQtyArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
						scgPrnrSpclCgoDtlLogVO.setOutN1stImdgPckQtyCtnt(VSKGeneralUtil.getCheckNullToString(opkgQtyArr[1]));
						
						if (!isNumeric(opkgQtyArr[1]) || Integer.parseInt(opkgQtyArr[1]) <= 0) {
							scgDtlErrVOs.add(setDtlErr(scgPrnrSpclCgoDtlLogVO, 12003));
						}
						errPrefixChk = errPrefixChk + "OPKG_QTY" + ":";
					} else if ("OPKG_TP".equals(flatKey)) {
						String[] opkgTpArr 				= flatFileList.get(ffRow).toString().trim().split(":",2);               
						
						String sTmpOuterPackagingCode 	= dbDao.checkDGPackagingCodeEffectiveness(opkgTpArr[1], "", "O");
						scgPrnrSpclCgoDtlLogVO.setOutN1stImdgPckCdCtnt(sTmpOuterPackagingCode); 
						
					} else if ("OPKG_DESC".equals(flatKey)) {
						String[] opkgDescArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
						scgPrnrSpclCgoDtlLogVO.setOutN1stImdgPckDesc(VSKGeneralUtil.getCheckNullToString(opkgDescArr[1]));  
						
						if((opkgDescArr[1] == null || "".equals(opkgDescArr[1])) && scgPrnrSpclCgoDtlLogVO.getOutN1stImdgPckCdCtnt() == null){
							scgDtlErrVOs.add(setDtlErr(scgPrnrSpclCgoDtlLogVO, 12004));		/** "12004"	: TYPE OF OUTER PACKAGE REQUIRED.	**/
						}else if(opkgDescArr[1] != null && !"".equals(opkgDescArr[1]) && scgPrnrSpclCgoDtlLogVO.getOutN1stImdgPckCdCtnt() == null){
							
							/** "ZZZ" : "DO NOT USE - EDI I/B UNMAPPED DESCS"	**/
							scgPrnrSpclCgoDtlLogVO.setOutN1stImdgPckCdCtnt	("ZZZ");		/** 2016-02-11:by TOP:Inforced Mapping for inner package code **/
						}
						
					} else if ("MPKG_QTY".equals(flatKey)) {               
						String[] mpkgQtyArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
						scgPrnrSpclCgoDtlLogVO.setIntmdN1stImdgPckQtyCtnt(VSKGeneralUtil.getCheckNullToString(mpkgQtyArr[1]));               
					} else if ("MPKG_TP".equals(flatKey)) {               
						String[] mpkgTpArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
						scgPrnrSpclCgoDtlLogVO.setIntmdN1stImdgPckCdCtnt(VSKGeneralUtil.getCheckNullToString(mpkgTpArr[1]));               
					} else if ("MPKG_DESC".equals(flatKey)) {               
						String[] mpkgDescArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
						scgPrnrSpclCgoDtlLogVO.setIntmdN1stImdgPckDesc(VSKGeneralUtil.getCheckNullToString(mpkgDescArr[1]));               
					} else if ("IPKG_QTY".equals(flatKey)) {               
						String[] ipkgQtyArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
						scgPrnrSpclCgoDtlLogVO.setInN1stImdgPckQtyCtnt(VSKGeneralUtil.getCheckNullToString(ipkgQtyArr[1]));               
					} else if ("IPKG_TP".equals(flatKey)) {               
						String[] ipkgTpArr 				= flatFileList.get(ffRow).toString().trim().split(":",2);               
						
						String sTmpInnerPackagingCode 	= dbDao.checkDGPackagingCodeEffectiveness(ipkgTpArr[1], "", "I");
						scgPrnrSpclCgoDtlLogVO.setInN1stImdgPckCdCtnt	(sTmpInnerPackagingCode);
						
						//////////////////////////////////////////////////////////////////////////
						//if (sTmpInnerPackagingCode == null || "".equals(sTmpInnerPackagingCode)) {
						//	
							/** "ZZZ" : "DO NOT USE - EDI I/B UNMAPPED DESCS"	**/
						//	scgPrnrSpclCgoDtlLogVO.setInN1stImdgPckCdCtnt	("ZZZ");	/** 2016-01-22:by TOP:Inforced Mapping for inner package code **/
						//}
						//////////////////////////////////////////////////////////////////////////
						
					} else if ("IPKG_DESC".equals(flatKey)) {               
						String[] ipkgDescArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
						scgPrnrSpclCgoDtlLogVO.setInN1stImdgPckDesc(VSKGeneralUtil.getCheckNullToString(ipkgDescArr[1])); 
						
						if(ipkgDescArr[1] != null && !"".equals(ipkgDescArr[1]) && scgPrnrSpclCgoDtlLogVO.getInN1stImdgPckCdCtnt() == null){
							
							/** "ZZZ" : "DO NOT USE - EDI I/B UNMAPPED DESCS"	**/
							scgPrnrSpclCgoDtlLogVO.setInN1stImdgPckCdCtnt	("ZZZ");	/** 2016-02-11:by TOP:Inforced Mapping for inner package code **/
						}
						
					} else if ("HAZ_CONT".equals(flatKey)) {               
						String[] hazContArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
						scgPrnrSpclCgoDtlLogVO.setHzdDesc(VSKGeneralUtil.getCheckNullToString(hazContArr[1]));                 //HAZ_CONT     
					} else if ("PROP_SHIP_NM".equals(flatKey)) {               
						String[] propShipNmArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
						scgPrnrSpclCgoDtlLogVO.setPrpShpNm(VSKGeneralUtil.getCheckNullToString(propShipNmArr[1]));              //PROP_SHIP_NM 
					} else if ("TECH_NM".equals(flatKey)) {               
						String[] techNmArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
						scgPrnrSpclCgoDtlLogVO.setImdgTecNm(VSKGeneralUtil.getCheckNullToString(techNmArr[1]));                  //TECH_NM   
						
					} else if ("IMO_AMDT_NO".equals(flatKey)) {               
						String[] imdgAmdtNoArr 	= flatFileList.get(ffRow).toString().trim().split(":",2); 
						String	 sImdgAmdtNo	= VSKGeneralUtil.getCheckNullToString(imdgAmdtNoArr[1]);
						
						scgPrnrSpclCgoDtlLogVO.setImdgAmdtNo	(sImdgAmdtNo);                									//IMDG AMENDMENT NUMBER
						
					} else if ("IMO_CLASS".equals(flatKey)) {               
						String[] imoClassArr 		= flatFileList.get(ffRow).toString().trim().split(":",2);              
						
						String	tmpClassCd			= imoClassArr[1];
						boolean	isInclUpperAlphabet	= false;
						String	tmpUpperAlphabet	= "";
						
						/** Adding check logic for COMPATIBILITY GROUP of CLASS 1 **/
						if(tmpClassCd != null && !"".equals(tmpClassCd) && tmpClassCd.length()>0){
							//int tmpClassCdLen	= tmpClassCd.length();
							
							if("1".equals(tmpClassCd.substring(0, 1))){
								
								Scanner	scan	= new Scanner(tmpClassCd);
								String line		= scan.nextLine();
								
								for(int k=0; k<line.length(); k++){
									char current	= line.charAt(k);
									if(current >= 'A' && current <= 'Z'){
										isInclUpperAlphabet	= true;
										tmpUpperAlphabet	= String.valueOf(current);
									}
								}
								
								scan.close();
							}
						}
						
						if(isInclUpperAlphabet){
							scgPrnrSpclCgoDtlLogVO.setImdgClssCdCtnt(tmpClassCd.replace(tmpUpperAlphabet, ""));         	//IMO_CLASS
							scgPrnrSpclCgoDtlLogVO.setImdgCompGrpCd	(tmpUpperAlphabet);         							//IMO_CLASS
						}else{
							scgPrnrSpclCgoDtlLogVO.setImdgClssCdCtnt(tmpClassCd);         									//IMO_CLASS	
						}
						/** ===================================================== **/
						    
					} else if ("SUB_RISKS".equals(flatKey)) {
						
						/** 2016-05-02:by TOP : Add logic which identify SUB_RISKS	**/
						
						String[] imdgSubRisk= flatFileList.get(ffRow).toString().trim().split(":",2);
						if(imdgSubRisk[1]	!= null){
							StringTokenizer	stSubRisks	=	new StringTokenizer(imdgSubRisk[1], "/");
							
							int inx			= 0;
							while(stSubRisks.hasMoreTokens()){
								inx++;
								switch(inx)
								{
									case 1:
										scgPrnrSpclCgoDtlLogVO.setN1stImdgSubsRskLblCd(stSubRisks.nextToken());
										break;
									case 2:
										scgPrnrSpclCgoDtlLogVO.setN2ndImdgSubsRskLblCd(stSubRisks.nextToken());
										break;
									case 3:
										scgPrnrSpclCgoDtlLogVO.setN3rdImdgSubsRskLblCd(stSubRisks.nextToken());
										break;
									case 4:
										scgPrnrSpclCgoDtlLogVO.setN4thImdgSubsRskLblCd(stSubRisks.nextToken());
										break;
									case 5:
										scgPrnrSpclCgoDtlLogVO.setN5thImdgSubsRskLblCd(stSubRisks.nextToken());
										break;
									case 6:
										scgPrnrSpclCgoDtlLogVO.setN6thImdgSubsRskLblCd(stSubRisks.nextToken());
										break;
									case 7:
										scgPrnrSpclCgoDtlLogVO.setN7thImdgSubsRskLblCd(stSubRisks.nextToken());
										break;
									case 8:
										scgPrnrSpclCgoDtlLogVO.setN8thImdgSubsRskLblCd(stSubRisks.nextToken());
										break;
								}
							}
						}
						
					} else if ("IMO_PAGE".equals(flatKey)) {               
						String[] imoPageArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
						scgPrnrSpclCgoDtlLogVO.setImdgPprNo(VSKGeneralUtil.getCheckNullToString(imoPageArr[1]));              //IMO_PAGE     
					} else if ("UN_NBR".equals(flatKey)) {               
						String[] unNbrArr = flatFileList.get(ffRow).toString().trim().split(":",2);
						
						String unNbr 	= VSKGeneralUtil.getCheckNullToString(unNbrArr[1]);
						scgPrnrSpclCgoDtlLogVO.setImdgUnNoCtnt(unNbr);                                                         //UN_NBR  
						
						
						
//						if (!"".equals(unNbr) && unNbr.length() > 0) {
//							if(!"1".equals(dbDao.searchUnNoIno(unNbr))) {
//								scgDtlErrVOs.add(setDtlErr(scgPrnrSpclCgoDtlLogVO, 13005));
//							}
//						} else {
//							scgDtlErrVOs.add(setDtlErr(scgPrnrSpclCgoDtlLogVO, 13005));
//						}						
//						errPrefixChk = errPrefixChk + "UN_NBR" + ":";
						
						
						
					//} else if ("UN_NBR_SEQ".equals(flatKey)) {
						//String[] unNbrSeqArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
						//scgPrnrSpclCgoDtlLogVO.setImdgUnNoSeq(VSKGeneralUtil.getCheckNullToString(unNbrSeqArr[1]));           //UN_NBR_SEQ   
					} else if ("CFR_NBR".equals(flatKey)) {               
						String[] cfrNbrArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
						scgPrnrSpclCgoDtlLogVO.setCfrNo	(VSKGeneralUtil.getCheckNullToString(cfrNbrArr[1]));                  	//CFR_NBR  
						scgPrnrSpclCgoDtlLogVO.setCfrFlg(("".equals(scgPrnrSpclCgoDtlLogVO.getCfrNo())) ? "N" : "Y");       	//CFR_FLG  
						
						/********* Decision for IMDG Amendment Number **********/
						String	 	sImdgAmdtNo	= VSKGeneralUtil.getCheckNullToString(scgPrnrSpclCgoDtlLogVO.getImdgAmdtNo());
						String 		sCFRFlg		= scgPrnrSpclCgoDtlLogVO.getCfrFlg			();
						
						String		sIMDGClass	= scgPrnrSpclCgoDtlLogVO.getImdgClssCdCtnt	();
						String		sUnNumber	= scgPrnrSpclCgoDtlLogVO.getImdgUnNoCtnt	();
						
						if("Y".equals(sCFRFlg)){
							sImdgAmdtNo	= "";
							scgPrnrSpclCgoDtlLogVO.setImdgUnNoCtnt(cfrNbrArr[1]);
							
							/************************************************************************** 
							 * Find out proper IMDG Class for CFR interfaced through EDI 
							 *	=======================================================================
							 *	1993	: COMBUSTIBLE LIQUID, N.O.S.						3
							 *	3082	: OTHER REGULATED SUBSTANCES, LIQUID, N.O.S.		9
							 *	1263	: PAINT AS COMBUSTIBLE LIQUID, N.O.S.				3
							 *			  - There are multiple CFR.
							 *	1987	: ALCOHOLS, N.O.S. AS COMBUSTIBLE LIQUID, N.O.S.	3
							 **************************************************************************/
							
							if(sIMDGClass == null || "".equals(sIMDGClass)){
								String sTmpImdgClassCd	= dbDao.checkValidationforIMDGClassUNNo	(scgPrnrSpclCgoDtlLogVO);
								scgPrnrSpclCgoDtlLogVO.setImdgClssCdCtnt(sTmpImdgClassCd);
							}
							
							
						}else if(sImdgAmdtNo != null && !"".equals(sImdgAmdtNo) && "N".equals(sCFRFlg)){
							
							/** User Exception raise in case of no having UN Number in EDI **/

							if (!"".equals(sUnNumber) && sUnNumber.length() > 0) {
								if(!"1".equals(dbDao.searchUnNoIno(sUnNumber))) {
									scgDtlErrVOs.add(setDtlErr(scgPrnrSpclCgoDtlLogVO, 13005));		/** 13005 : "IMDG CODE UNMATCH." 	*/
								}
							} else {
								scgDtlErrVOs.add	(setDtlErr(scgPrnrSpclCgoDtlLogVO, 13005));		/** 13005 : "IMDG CODE UNMATCH." 	*/
							}						
							errPrefixChk = errPrefixChk + "UN_NBR" + ":";
							
							
							//-------------------------------------------------------------------//
//							if(		sImdgAmdtNo.contains("36-12") 
//								||	sImdgAmdtNo.contains("37-14") 
//								||	sImdgAmdtNo.contains("38-16")
//								||	sImdgAmdtNo.contains("39-18")
//								||	sImdgAmdtNo.contains("40-20")
//								||	sImdgAmdtNo.contains("41-22")
//								||	sImdgAmdtNo.contains("42-24")
//								||	sImdgAmdtNo.contains("43-26")
//								||	sImdgAmdtNo.contains("44-28")
//								||	sImdgAmdtNo.contains("45-30")
//							){
//								//
//							}else 
								
								
							if("6".equals(sImdgAmdtNo.substring(0,1)) || "36".equals(sImdgAmdtNo.substring(0,2))){
								sImdgAmdtNo	= "36-12";
							}else if("7".equals(sImdgAmdtNo.substring(0,1)) || "37".equals(sImdgAmdtNo.substring(0,2))){
								sImdgAmdtNo	= "37-14";
							}else if("8".equals(sImdgAmdtNo.substring(0,1)) || "38".equals(sImdgAmdtNo.substring(0,2))){
								sImdgAmdtNo	= "38-16";
							}else if("9".equals(sImdgAmdtNo.substring(0,1)) || "39".equals(sImdgAmdtNo.substring(0,2))){
								sImdgAmdtNo	= "39-18";
							}else{
								/** EXCEPTION OCCURED IN CASE OF empty IMDG AMENDMENT NO. by TOP 2015-08-28 **/
								scgTrsmErrVOs.add(this.setTrsmErr(scgHdrVO, 13005));			/** 13005 : "IMDG CODE UNMATCH." 	*/
							}
							//-------------------------------------------------------------------//							
						}
						
						scgPrnrSpclCgoDtlLogVO.setImdgAmdtNo	(sImdgAmdtNo);
						/*************************************************************/
						
					} else if ("FLASH".equals(flatKey)) {               
						String[] flashArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
						scgPrnrSpclCgoDtlLogVO.setFlshPntTempCtnt(VSKGeneralUtil.getCheckNullToString(flashArr[1]));                   //FLASH        
					} else if ("FLASH_UNIT".equals(flatKey)) {               
						String[] flashUnitArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
						scgPrnrSpclCgoDtlLogVO.setFlshPntUtCdCtnt(VSKGeneralUtil.getCheckNullToString(flashUnitArr[1]));               //FLASH_UNIT   
					} else if ("PKG_GROUP".equals(flatKey)) {
						String[] pkgGroupArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
						scgPrnrSpclCgoDtlLogVO.setImdgPckGrpCdCtnt(VSKGeneralUtil.getCheckNullToString(pkgGroupArr[1]));                //PKG_GROUP  
						
					} else if ("CTRL_TEMP".equals(flatKey)) {
						String[] ctrlTemp = flatFileList.get(ffRow).toString().trim().split(":",2);               
						scgPrnrSpclCgoDtlLogVO.setCtrlTempCtnt(VSKGeneralUtil.getCheckNullToString(ctrlTemp[1]));                //CONTROL TEMPERATURE FOR REEFER DG : added FEB 12nd 2016

					} else if ("EMS_NBR".equals(flatKey)) {
						String[] emsNbrArr 			= flatFileList.get(ffRow).toString().trim().split(":",2);         
						
						/** Revision EMS Number **/
						//String	sEmsNofmUNMst		= VSKGeneralUtil.getCheckNullToString(scgPrnrSpclCgoDtlLogVO.getEmsNo());
						String	sEmsNofmFlatFile	= VSKGeneralUtil.getCheckNullToString(emsNbrArr[1]);
						
						if(!"".equals(sEmsNofmFlatFile)){
							scgPrnrSpclCgoDtlLogVO.setEmsNo(sEmsNofmFlatFile);                  //EMS_NBR	
						}
						
						/** Checking validation for matching between IMDG CLASS and UN NO ************/
						String sTmpImdgClassCd								= dbDao.checkValidationforIMDGClassUNNo	(scgPrnrSpclCgoDtlLogVO);
						if(sTmpImdgClassCd == null || "".equals(sTmpImdgClassCd)){
							/** EXCEPTION OCCURED IN CASE OF MISMATCH IMDG CLASS AND UN NO. by TOP 2015-08-28  **/
							scgTrsmErrVOs.add(this.setTrsmErr(scgHdrVO, 13005));			/** 13005 : "IMDG CODE UNMATCH." 	*/
						}
						
						/** Finding and Setting proper UN No SEQ & EMS to VO *************************/
						ScgPrnrSpclCgoDtlLogVO	unNoSeqEmsVO				= this.identifyProperUNInfofromDGEDI	(scgPrnrSpclCgoDtlLogVO);
						
						if(unNoSeqEmsVO == null){
							//::2015-08-28:by TOP:://scgDtlErrVOs.add	(this.setDtlErr(scgPrnrSpclCgoDtlLogVO, 90001));			/** See this.getErrMessage : 90001 "Cannot found Proper UN(Seq) Information(PSN, Packing Group)" **/
							//scgHdrVO.setEdiUnmapKndCd						("UNS");								/** UNS **/
							//scgPrnrSpclCgoDtlLogVO.setEdiCgoUnmapDtlCd		("201");								
							
							/** 
							 *	"101" : "Unmapped container type/size with conversion table"
							 *  ----------------------------------------------------------------
							 *  "201" : "Cannot find proper UN No SEQ." 	
							 *  "202" : "No technical name in DG Application."	
							 **/
							trsmCgoDtlLogUnmapVOs.add						(this.setTrsmCgoDtlLogUnmap(scgPrnrSpclCgoDtlLogVO, "201"));
							
						}else{
							
							scgPrnrSpclCgoDtlLogVO.setImdgUnNoSeq			(unNoSeqEmsVO.getImdgUnNoSeq			());
							scgPrnrSpclCgoDtlLogVO.setImdgCompGrpCd			(unNoSeqEmsVO.getImdgCompGrpCd			());
							
							if(scgPrnrSpclCgoDtlLogVO.getEmsNo() == null || "".equals(scgPrnrSpclCgoDtlLogVO.getEmsNo())){
								scgPrnrSpclCgoDtlLogVO.setEmsNo				(unNoSeqEmsVO.getEmsNo					());
							}
							
						}
						/*****************************************************************************/
						
					} else if ("MFAG".equals(flatKey)) {               
						String[] mfagArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
						scgPrnrSpclCgoDtlLogVO.setMfagNo(VSKGeneralUtil.getCheckNullToString(mfagArr[1]));                    //MFAG         
					} else if ("ESPN".equals(flatKey)) {               
						String[] espnArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
						scgPrnrSpclCgoDtlLogVO.setEspNo(VSKGeneralUtil.getCheckNullToString(espnArr[1]));                    //ESPN     
						
						//:temporary setting:by TOP:2016-05-02://
						//if(scgPrnrSpclCgoDtlLogVO.getEmsNo() == null && scgPrnrSpclCgoDtlLogVO.getEspNo() != null){
						//	scgPrnrSpclCgoDtlLogVO.setEmsNo(scgPrnrSpclCgoDtlLogVO.getEspNo());
						//}
						
					} else if ("POLLUTANT".equals(flatKey)) {               
						String[] pollutantArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
						scgPrnrSpclCgoDtlLogVO.setImdgMrnPolutCdCtnt(VSKGeneralUtil.getCheckNullToString(pollutantArr[1]));
						//scgPrnrSpclCgoDtlLogVO.setImdgMrnPolutFlg((VSKGeneralUtil.getCheckNullToString(pollutantArr[1])));               //POLLUTANT   
						
						if(pollutantArr[1] != null && !"".equals(pollutantArr[1]) && "P".equals(pollutantArr[1])){
							scgPrnrSpclCgoDtlLogVO.setImdgMrnPolutFlg("Y");	
							scgPrnrSpclCgoDtlLogVO.setImdgMrnPolutCdCtnt(pollutantArr[1]);
						}else{
							scgPrnrSpclCgoDtlLogVO.setImdgMrnPolutFlg("N");
							scgPrnrSpclCgoDtlLogVO.setImdgMrnPolutCdCtnt(pollutantArr[1]);
						}
						
						
						/** 2016-05-02:by TOP : Add check logic TECH_NM - MANDATORY **/
						
						ScgPrnrSpclCgoDtlLogVO	tmpVO	= new ScgPrnrSpclCgoDtlLogVO();
						tmpVO.setImdgAmdtNo		(scgPrnrSpclCgoDtlLogVO.getImdgAmdtNo	());
						tmpVO.setImdgUnNoCtnt	(scgPrnrSpclCgoDtlLogVO.getImdgUnNoCtnt	());
						
						boolean	isTechMandatory	= dbDao.checkTechNmMandatoryForSpclProvi(tmpVO);
						
						if(	((	"Y".equals(scgPrnrSpclCgoDtlLogVO.getImdgMrnPolutFlg())	&& scgPrnrSpclCgoDtlLogVO.getImdgMrnPolutFlg() != null)
								||	
								isTechMandatory
							)
							&&
							("".equals	(scgPrnrSpclCgoDtlLogVO.getImdgTecNm()) || scgPrnrSpclCgoDtlLogVO.getImdgTecNm	() 	== null)
							&&
							(!"Y".equals(scgPrnrSpclCgoDtlLogVO.getCfrFlg	())	|| scgPrnrSpclCgoDtlLogVO.getCfrFlg		()	== null)
						)
						{
							
							/** 2015-09-09:Commented by TOP:Requested by Huma Syed & Tom Waller, 2015-09-15 : Rollback by TOM Waller 
							 *  2016-04-29:Changed checking logic
							 * **/
							/** 
							 *	"101" : "Unmapped container type/size with conversion table"
							 *  ----------------------------------------------------------------
							 *  "201" : "Cannot find proper UN No SEQ." 	
							 *  "202" : "No technical name in DG Application."	
							 **/
							trsmCgoDtlLogUnmapVOs.add						(this.setTrsmCgoDtlLogUnmap(scgPrnrSpclCgoDtlLogVO, "202"));
						}
						
					} else if ("IMO_LIMIT".equals(flatKey)) {
						String[] imoLimitArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
						scgPrnrSpclCgoDtlLogVO.setImdgLmtQtyFlgCtnt(VSKGeneralUtil.getCheckNullToString(imoLimitArr[1]));                //IMO_LIMIT    
					} else if ("GROSWGT".equals(flatKey)) {
						String[] groswgtArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
						scgPrnrSpclCgoDtlLogVO.setGrsWgtCtnt(VSKGeneralUtil.getCheckNullToString(groswgtArr[1]));                 //GROSWGT  
						if (!isNumeric(groswgtArr[1]) || Double.parseDouble(groswgtArr[1]) <= 0) {
							scgDtlErrVOs.add(setDtlErr(scgPrnrSpclCgoDtlLogVO, 12005));
						}
						errPrefixChk = errPrefixChk + "GROSWGT" + ":";
					} else if ("GROSSWGT_UNIT".equals(flatKey)) {
						String[] grosswgtUnitArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
						scgPrnrSpclCgoDtlLogVO.setGrsWgtUtCdCtnt(VSKGeneralUtil.getCheckNullToString(grosswgtUnitArr[1]));            //GROSSWGT_UNIT
					} else if ("NETWGT".equals(flatKey)) {
						String[] netwgtArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
						scgPrnrSpclCgoDtlLogVO.setNetWgtCtnt(VSKGeneralUtil.getCheckNullToString(netwgtArr[1]));                  //NETWGT       
					} else if ("NETWGT_UNIT".equals(flatKey)) {
						String[] netwgtUnitArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
						scgPrnrSpclCgoDtlLogVO.setNetWgtUtCdCtnt(VSKGeneralUtil.getCheckNullToString(netwgtUnitArr[1]));              //NETWGT_UNIT  
					} else if ("NETPWDRWGT".equals(flatKey)) {
						String[] netPwdrWgtArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
						scgPrnrSpclCgoDtlLogVO.setNetExploWgtCtnt(VSKGeneralUtil.getCheckNullToString(netPwdrWgtArr[1]));              //NETWGT_UNIT 	
						
						
					} else if ("NETPWDRWGT_UNIT".equals(flatKey)) {               
						String[] netPwdrWgtUnitArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
						scgPrnrSpclCgoDtlLogVO.setNetExploWgtUtCdCtnt(VSKGeneralUtil.getCheckNullToString(netPwdrWgtUnitArr[1]));              //NETWGT_UNIT  
						
						
					} else if ("VOL".equals(flatKey)) {
						String[] volArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
						scgPrnrSpclCgoDtlLogVO.setPckQtyCtnt(VSKGeneralUtil.getCheckNullToString(volArr[1]));                     //VOL          
					} else if ("VOL_UNIT".equals(flatKey)) {
						String[] volUnitArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
						scgPrnrSpclCgoDtlLogVO.setPckTpCdCtnt(VSKGeneralUtil.getCheckNullToString(volUnitArr[1]));                 //VOL_UNIT     
					
					//:2015-09-02://} else if ("CNTRNBR".equals(flatKey)) {
					//::2015-09-03:No need because of multi container & multi cargo:://} else if ("DG_CNTRNBR".equals(flatKey)) {
						//::2015-09-03:No need because of multi container & multi cargo:://String[] cntrNbrArr = flatFileList.get(ffRow).toString().trim().split(":",2);
						//::2015-09-03:No need because of multi container & multi cargo:://scgPrnrSpclCgoDtlLogVO.setCntrRefNo(VSKGeneralUtil.getCheckNullToString(cntrNbrArr[1]));
						
					} else if ("RESIDUE".equals(flatKey)) {
						String[] residueArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
						scgPrnrSpclCgoDtlLogVO.setRsdFlgCtnt(VSKGeneralUtil.getCheckNullToString(residueArr[1]));                  	//RESIDUE       
					
					} else if ("REMARK".equals(flatKey)	&& flatKey.indexOf("{")<=-1 && flatKey.indexOf("}")<=-1) {     
						
						String[] 		remarkArr 		= flatFileList.get(ffRow).toString().trim().split(":",2);    
						String			sTmpRemark		= VSKGeneralUtil.getCheckNullToString(remarkArr[1]);
						
						StringBuffer	sbCombineRemark	= new StringBuffer();
						sbCombineRemark					= sbCombineRemark.append(VSKGeneralUtil.getCheckNullToString(scgPrnrSpclCgoDtlLogVO.getDiffRmk()));
						if(sbCombineRemark.toString() != null && !"".equals(sbCombineRemark.toString())){
							sbCombineRemark				= sbCombineRemark.append("\n");	
						}
						sbCombineRemark					= sbCombineRemark.append(sTmpRemark);
						
						scgPrnrSpclCgoDtlLogVO.setDiffRmk(VSKGeneralUtil.getCheckNullToString(sbCombineRemark.toString()));                  		//REMARK   
						
					} else if ("CONTACT".equals(flatKey)) {               
						String[] contactArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
						scgPrnrSpclCgoDtlLogVO.setEmerCntcPsonNm(VSKGeneralUtil.getCheckNullToString(contactArr[1]));                 //CONTACT      
					} else if ("PHONE".equals(flatKey)) {               
						String[] phoneArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
						scgPrnrSpclCgoDtlLogVO.setEmerCntcPhnNo(VSKGeneralUtil.getCheckNullToString(phoneArr[1]));                   //PHONE     
						
					//::Adding elements [CGO_STS, SEG_GRP, SEG_GRPS_NBR] : 2015-10-22:://	
					} else if ("CGO_STS".equals(flatKey)) {               
						String[] cgoDtlSts = flatFileList.get(ffRow).toString().trim().split(":",2);               
						scgPrnrSpclCgoDtlLogVO.setDcgoDtlStsCdCtnt(VSKGeneralUtil.getCheckNullToString(cgoDtlSts[1]));					//Dangerous Cargo Status    
					} else if ("SEG_GRP".equals(flatKey)) {               
						String[] segGrp = flatFileList.get(ffRow).toString().trim().split(":",2);               
						scgPrnrSpclCgoDtlLogVO.setImdgAddSegrGrpNoCtnt(VSKGeneralUtil.getCheckNullToString(segGrp[1]));					//Additional Segregation Group   
					} else if ("SEG_GRPS_NBR".equals(flatKey)) {               
							String[] 		segGrpsNbr 		= flatFileList.get(ffRow).toString().trim().split(":",2);     
							
							String	 		sTmpOrgSegGrps	= segGrpsNbr[1] == null?"":segGrpsNbr[1];
							String[] 		sArrOrgSegGrps	= null;	
							StringBuffer	sbConvSegGrps	= new StringBuffer("");
							
							sArrOrgSegGrps	= sTmpOrgSegGrps.split(" ");		/** Delimeter for Segregation Groups through EDI is space character : 2015-10-22 **/
							
							for(int i=0; i<sArrOrgSegGrps.length; i++){
								sbConvSegGrps.append(sArrOrgSegGrps[i]).append("*");
							}
							
							scgPrnrSpclCgoDtlLogVO.setImdgSegrGrpNoCtnt(VSKGeneralUtil.getCheckNullToString(sbConvSegGrps.toString()));	//Default Segregation Groups from UN Info. 
					}
					
				}
				/** Finished parsing DG Segment **********************************/
				/*****************************************************************/
				
				/** Starting parsing DG CNTR Segment *****************************
				 * {CNTR_DG

					CNTRNBR
					----------------------------------------------------------
					{DG_CNTR_INFO
					DG_CNTRNBR
					}DG_CNTR_INFO
					----------------------------------------------------------
					
					}CNTR_DG
				 * -------------------------------------------------------------
				 */
				if(flatFileList.get(ffRow).indexOf("{DG_CNTR_INFO") > -1) {
					isCNTRDGCargoMappingSegment	= true;
				}
				
				if(flatFileList.get(ffRow).indexOf("}DG_CNTR_INFO") > -1) {
					isCNTRDGCargoMappingSegment = false;
				}
				
				if(isCNTRDGCargoMappingSegment){
					
					if ("DG_CNTRNBR".equals(flatKey)) {   
						String	sTmpCntrNo[]				= flatFileList.get(ffRow).toString().trim().split(":",2);
						String	sCntrRefNo					= VSKGeneralUtil.getCheckNullToString(sTmpCntrNo[1]);
						
						
						/** Mapping CNTR_SEQ & CGO_SEQ ****************************************/
						EDISpclCgoSeqMapgVO	tmpEDISpclCgoSeqMapgVO	= new EDISpclCgoSeqMapgVO();
						/**********************************************************************/
						
						tmpEDISpclCgoSeqMapgVO.setEdiItmSeq	(scgPrnrSpclCgoDtlLogVO.getEdiItmSeq	()	);
						tmpEDISpclCgoSeqMapgVO.setDcgoRefNo	(scgPrnrSpclCgoDtlLogVO.getDcgoRefNo	()	);
						tmpEDISpclCgoSeqMapgVO.setCntrRefNo	(sCntrRefNo									);
						
						ediSpclCgoSeqMapgVOs.add			(tmpEDISpclCgoSeqMapgVO);
					}
				}
				/** Finished parsing DG CNTR Segment *****************************/
				/*****************************************************************/
				
			}		
			/********** Finished parsing in DG Item Segment	***********//********** Finished parsing in DG Item Segment	***********/
			/**********************************************************************************************************************/
			
			
			/** Making Mapping VO included CNTR_SEQ & CGO_SEQ ******************************
			 * 
			 * 
			 */
			int	iMapgSeq	= 0;
			for(ScgPrnrSpclCgoCntrLogVO tmpCntrVO : scgPrnrSpclCgoCntrLogVOs){
				
				String tmp1_CntrSeq			= tmpCntrVO.getCntrSeq			();
				String tmp1_CntrRefNo		= tmpCntrVO.getCntrRefNo		();
				String tmp1_CntrTpSzCd		= tmpCntrVO.getCntrTpszCdCtnt	();
				
				for(EDISpclCgoSeqMapgVO tmpDGCgoVO : ediSpclCgoSeqMapgVOs){
					
					String tmp2_EdiItemSeq	= tmpDGCgoVO.getEdiItmSeq		();
					String tmp2_DcgoRefNo	= tmpDGCgoVO.getDcgoRefNo		();
					String tmp2_CntrRefNo	= tmpDGCgoVO.getCntrRefNo		();
					
					if(tmp1_CntrRefNo.equals(tmp2_CntrRefNo)){
						
						EDISpclCgoSeqMapgVO	mapgVO		= new EDISpclCgoSeqMapgVO	();
						
						mapgVO.setPrnrSpclCgoSeq		(G_PRNR_SPCL_CGO_SEQ		);
						mapgVO.setCgoMapgSeq			(String.valueOf(++iMapgSeq)	);
						
						mapgVO.setCntrSeq				(tmp1_CntrSeq				);
						
						int iNewCgoSeq					= 1;
						for(EDISpclCgoSeqMapgVO tmpMapgVO : finalEdiSpclCgoSeqMapgVOs){
							if(tmp1_CntrRefNo.equals(tmpMapgVO.getCntrRefNo())){
								iNewCgoSeq++;
							}
						}
						
						mapgVO.setCgoSeq				(String.valueOf(iNewCgoSeq)	);
						
						mapgVO.setCntrRefNo				(tmp1_CntrRefNo				);
						mapgVO.setCntrTpszCd			(tmp1_CntrTpSzCd			);
						mapgVO.setEdiItmSeq				(tmp2_EdiItemSeq			);
						mapgVO.setDcgoRefNo				(tmp2_DcgoRefNo				);
						
						finalEdiSpclCgoSeqMapgVOs.add	(mapgVO						);
					}
				}
				
			}
			

			/** TARGET TABLE : SCG_PRNR_SPCL_CGO_SEQ_MAPG									*/
			if(finalEdiSpclCgoSeqMapgVOs != null && finalEdiSpclCgoSeqMapgVOs.size()>0){
				dbDao.addScgPrnrSpclCgoSeqMapg				(finalEdiSpclCgoSeqMapgVOs);				
			}else{
				/** 99001 : errMsg  = "Mismatch Container No between CNTR & CGO Segment" **/
				scgDtlErrVOs.add	(setDtlErr(scgPrnrSpclCgoDtlLogVO, 99001));
				
				/** 
				 *	"000" : "Segment structure error in EDI file" 
				 *  "001" : "Container Number mismatched in EDI file"	
				 **/
				trsmHdrUnmapVOs.add	(this.setTrsmHdrUnmap(scgHdrVO, "001"));	
				
				//XXX//scgHdrVO.setEdiUnmapKndCd						("XXX");
			}
			/********************************************************************************/
			
			
			/*****************************************************************************************************************
			 * STARTED...flatfile log 생성
			 * ===============================================================================================================
			 */
			this.addScgPrnrSpclCgoFltFileLog	(TRSM_IN_BND_CD, scgHdrVO.getPrnrSpclCgoSeq(), scgHdrVO.getBkgRefNo(), ediFlatFile, "IFTMBF FlatFile Log");

			// SCG PARTNER SPECIAL CARGO TRANSMIT HEADER INSERT			
			dbDao.addScgPrnrSpclCgoTrsmHdr		(scgHdrVO);							/** << TABLE NAME : SCG_PRNR_SPCL_CGO_TRSM_HDR >> */
			
			/***************************************************************************************************/
			/** SCG PARTNER SPECIAL CARGO CONTAINER LOG INSERT +++ Error Logging (SCG_PRNR_SPCL_CGO_TRSM_ERR) **/
			if (scgPrnrSpclCgoCntrLogVOs != null && scgPrnrSpclCgoCntrLogVOs.size() > 0) {
				dbDao.addScgPrnrSpclCgoCntrLog	(scgPrnrSpclCgoCntrLogVOs);			/** << TABLE NAME : SCG_PRNR_SPCL_CGO_CNTR_LOG >> */
			}
			
			if (scgTrsmErrVOs != null && scgTrsmErrVOs.size() > 0) {
				
				for (ScgPrnrSpclCgoTrsmErrVO VOs : scgTrsmErrVOs) {
					dbDao.addScgPrnrSpclCgoTrsmErr(VOs);							/** << TABLE NAME : SCG_PRNR_SPCL_CGO_TRSM_ERR >> */
				}
				
				scgHdrVO.setLstTrsmStsCd		("F");
				scgHdrVO.setErrKndCd			("R");
				scgHdrVO.setUpdUsrId			(USER_ID);
				//mapVO.put("lst_trsm_sts_cd"	, "F"		);
				//mapVO.put("err_knd_cd"     	, "R"		);
				//mapVO.put("upd_usr_id"     	, USER_ID	);
				
				dbDao.modifyErrTrsmHdr			(scgHdrVO);
				int minVal = 100;
				
				for (ScgPrnrSpclCgoTrsmErrVO vo : scgTrsmErrVOs) {							
					if (Integer.parseInt(vo.getErrLvl()) < minVal) {
						sErrorCode = vo.getErrDtlCd() + ":" +vo.getApErrCd() + ":" + vo.getErrDtlRmk() + ":" + vo.getErrLvl();								
					}
					minVal = Integer.parseInt(vo.getErrLvl());
				}
				isErrorExist  = true;
			}
			
			
			/***********************************************************************************************/
			/** SCG PARTNER SPECIAL CARGO DETAIL LOG INSERT +++ Error Logging (SCG_PRNR_SPCL_CGO_DTL_ERR) **/ 			
			if (scgPrnrSpclCgoDtlLogVOs != null && scgPrnrSpclCgoDtlLogVOs.size() > 0) {
				
				dbDao.addScgPrnrSpclCgoDtlLog	(scgPrnrSpclCgoDtlLogVOs);				/** << TABLE NAME : SCG_PRNR_SPCL_CGO_DTL_LOG 	>> */
				
				
				/********************************************************************
				 * Making Unmapping Data History 
				 ********************************************************************/
				if(trsmHdrUnmapVOs != null && trsmHdrUnmapVOs.size()>0){
					for(ScgPrnrTrsmHdrUnmapVO tmpVO : trsmHdrUnmapVOs){
						dbDao.addScgPrnrTrsmHdrUnmap		(tmpVO);					/** << TABLE NAME : SCG_PRNR_TRSM_HDR_UNMAP 	>> */
					}
				}
				
				if(trsmCntrLogUnmapVOs != null && trsmCntrLogUnmapVOs.size()>0){
					for(ScgPrnrCntrLogUnmapVO tmpVO : trsmCntrLogUnmapVOs){

						dbDao.addScgPrnrTrsmCntrLogUnmap		(tmpVO);				/** << TABLE NAME : SCG_PRNR_CNTR_LOG_UNMAP 	>> */
					}
				}
				
				
				if(trsmCgoDtlLogUnmapVOs != null && trsmCgoDtlLogUnmapVOs.size()>0){
					for(ScgPrnrCgoDtlLogUnmapVO tmpVO : trsmCgoDtlLogUnmapVOs){
						dbDao.addScgPrnrTrsmCgoDtlLogUnmap	(tmpVO);					/** << TABLE NAME : SCG_PRNR_CGO_DTL_LOG_UNMAP 	>> */
					}
				}
				/********************************************************************/
				
				
				if(scgDtlErrVOs != null && scgDtlErrVOs.size() > 0) {
					
					for(ScgPrnrSpclCgoDtlErrVO scgDtlErrVO : scgDtlErrVOs) {
						dbDao.addScgPrnrSpclCgoDtlErr(scgDtlErrVO);						/** << TABLE NAME : SCG_PRNR_SPCL_CGO_DTL_ERR 	>> */
					}
					
					scgHdrVO.setLstTrsmStsCd		("F");
					scgHdrVO.setErrKndCd			("R");
					scgHdrVO.setUpdUsrId			(USER_ID);
					//mapVO.put("lst_trsm_sts_cd"	, "F"		);
					//mapVO.put("err_knd_cd"     	, "R"		);
					//mapVO.put("upd_usr_id"     	, USER_ID	);
					
					dbDao.modifyErrTrsmHdr			(scgHdrVO);
					
					if (!isErrorExist) {
						int minVal        = 100;
						
						String[] arrErrCd = null;
						if (sErrorCode.length() > 0) {
							arrErrCd = sErrorCode.split(":");
						}
						
						//level기준으로 우선 순위를 설정 함 
						//level이 가장 작은 값을 aperak로 넘겨줌
						for (ScgPrnrSpclCgoDtlErrVO vo : scgDtlErrVOs) {
							if (Integer.parseInt(vo.getErrLvl()) < minVal) {
								if (arrErrCd == null) {
									sErrorCode = vo.getErrDtlCd() + ":" +vo.getApErrCd() + ":" + vo.getErrDtlRmk()+ ":" + vo.getErrLvl();
								     minVal = Integer.parseInt(vo.getErrLvl());
								} else if (Integer.parseInt(arrErrCd[3]) > Integer.parseInt(vo.getErrLvl())) {
									sErrorCode = vo.getErrDtlCd() + ":" +vo.getApErrCd() + ":" + vo.getErrDtlRmk()+ ":" + vo.getErrLvl();
									 minVal = Integer.parseInt(arrErrCd[3]);
								}
							}
						}
						isErrorExist = true;
					}
				}
				
				dbDao.addScgPrnrSpclCgoTrsmDtl	(scgHdrVO);				/** << TABLE NAME : SCG_PRNR_SPCL_CGO_TRSM_DTL 	>> */
				
				
				/********************************************************************
				 * Making Unmapping Data History 
				 ********************************************************************/
				dbDao.addScgPrnrTrsmDtlUnmap	(scgHdrVO);				/** << TABLE NAME : SCG_PRNR_TRSM_DTL_UNMAP 	>> */
				/********************************************************************/
			}
			/*****************************************************************************************************************
			 * FINISHED...flatfile log 생성
			 * ===============================================================================================================
			 */
			
			
			if (!isErrorExist) {
			
				/********************************************************************************
				 * Started...Setting Partner Line's Booking Header Information from EDI 
				 * ==============================================================================
				 */
				ScgPrnrAproRqstVO[] scgPrnrAproRqstVOs = new ScgPrnrAproRqstVO[scgPrnrSpclCgoCntrLogVOs.size()];
				
				for (int nRow = 0; nRow < scgPrnrSpclCgoCntrLogVOs.size(); nRow++) {
					
					ScgPrnrAproRqstVO scgPrnrAproRqstVO = new ScgPrnrAproRqstVO();
					
					scgPrnrAproRqstVO.setDgFlg					("Y");
					scgPrnrAproRqstVO.setAwkFlg					("N");
					
					/** Setting Vessel Operator(Carrier)	**/
					scgPrnrAproRqstVO.setCrrCd					(scgHdrVO.getCrrCd());
					
					scgPrnrAproRqstVO.setBkgRefNo				(VSKGeneralUtil.getCheckNullToString(scgHdrVO.getBkgRefNo()));				
					scgPrnrAproRqstVO.setCgoOprCd				(VSKGeneralUtil.getCheckNullToString(scgHdrVO.getCgoOprCd()));				
					
					scgPrnrAproRqstVO.setVslCd					(VSKGeneralUtil.getCheckNullToString(scgHdrVO.getVslCd()));
					scgPrnrAproRqstVO.setSkdVoyNo				(VSKGeneralUtil.getCheckNullToString(scgHdrVO.getSkdVoyNo()));
					scgPrnrAproRqstVO.setSkdDirCd				(VSKGeneralUtil.getCheckNullToString(scgHdrVO.getSkdDirCd()));				
									
					scgPrnrAproRqstVO.setPolCd					(VSKGeneralUtil.getCheckNullToString(scgHdrVO.getPolCd())); 		//POL_CD + POL_CLPT_IND_SEQ <== remove:2015-05-22
					scgPrnrAproRqstVO.setPolClptIndSeq			(VSKGeneralUtil.getCheckNullToString(scgHdrVO.getPolClptIndSeq())); //POL_CD + POL_CLPT_IND_SEQ <== remove:2015-05-22
					scgPrnrAproRqstVO.setEtaDt					(sPolEtaDt);
					
					scgPrnrAproRqstVO.setPodCd					(VSKGeneralUtil.getCheckNullToString(scgHdrVO.getPodCd())); 		//POD_CD + POD_CLPT_IND_SEQ <== remove:2015-05-22
					scgPrnrAproRqstVO.setPodClptIndSeq			(VSKGeneralUtil.getCheckNullToString(scgHdrVO.getPodClptIndSeq())); //POL_CD + POL_CLPT_IND_SEQ <== remove:2015-05-22
					
					scgPrnrAproRqstVO.setRgnShpOprCd			(VSKGeneralUtil.getCheckNullToString(scgHdrVO.getRgnShpOprCd()));				
					scgPrnrAproRqstVO.setSlanCd					(VSKGeneralUtil.getCheckNullToString(scgHdrVO.getSlanCd()));
					scgPrnrAproRqstVO.setMapgTrsmBndCd			(scgPrnrSpclCgoCntrLogVOs.get(nRow).getTrsmBndCd());
					scgPrnrAproRqstVO.setMapgTrsmDt				(scgPrnrSpclCgoCntrLogVOs.get(nRow).getTrsmDt());
					scgPrnrAproRqstVO.setMapgTrsmSpclCgoCateCd	(scgPrnrSpclCgoCntrLogVOs.get(nRow).getSpclCgoCateCd());
					scgPrnrAproRqstVO.setMapgPrnrSpclCgoSeq		(scgPrnrSpclCgoCntrLogVOs.get(nRow).getPrnrSpclCgoSeq());
					scgPrnrAproRqstVO.setMapgEdiTrsmStsCd		(scgHdrVO.getEdiMsgStsCd());
					
					scgPrnrAproRqstVO.setLstRqstDatFlg			("Y");
					scgPrnrAproRqstVO.setSrcTpCd				("EDI");
					scgPrnrAproRqstVO.setUpdUsrId				(USER_ID);
					
					scgPrnrAproRqstVO.setIbflag					(scgPrnrSpclCgoCntrLogVOs.get(nRow).getIbflag());
					
					
					if ("U".equals(scgPrnrSpclCgoCntrLogVOs.get(nRow).getIbflag()) || "D".equals(scgPrnrSpclCgoCntrLogVOs.get(nRow).getIbflag())) {
						
						Map<String, String> cntrKeyMap 			= new HashMap<String, String>();
						cntrKeyMap.put("mapg_trsm_bnd_cd"       , scgPrnrSpclCgoCntrLogVOs.get(nRow).getMapgTrsmBndCd());
						cntrKeyMap.put("mapg_trsm_dt"           , scgPrnrSpclCgoCntrLogVOs.get(nRow).getMapgTrsmDt());
						cntrKeyMap.put("mapg_trsm_cgo_cate_cd"  , scgPrnrSpclCgoCntrLogVOs.get(nRow).getMapgTrsmSpclCgoCateCd());
						cntrKeyMap.put("mapg_prnr_spcl_cgo_seq" , scgPrnrSpclCgoCntrLogVOs.get(nRow).getMapgPrnrSpclCgoSeq());
						
						Map<String, String> rtnCntrKeyMap 		= dbDao.searchDgCntrKey	(cntrKeyMap);
						
						scgPrnrAproRqstVO.setCrrCd				(rtnCntrKeyMap.get("crr_cd")			);
						scgPrnrAproRqstVO.setBkgRefNo			(rtnCntrKeyMap.get("bkg_ref_no")		);
						scgPrnrAproRqstVO.setSpclCgoRqstSeq		(rtnCntrKeyMap.get("spcl_cgo_rqst_Seq")	);

						for (int dtlRow = 0; dtlRow < scgPrnrSpclCgoDtlLogVOs.size(); dtlRow++) {
							if (scgPrnrSpclCgoDtlLogVOs.get(dtlRow).getCntrRefNo().equals	(scgPrnrSpclCgoCntrLogVOs.get(nRow).getCntrRefNo())) {
								scgPrnrSpclCgoDtlLogVOs.get(dtlRow).setCrrCd				(rtnCntrKeyMap.get("crr_cd"));
								scgPrnrSpclCgoDtlLogVOs.get(dtlRow).setSpclCgoRqstSeq		(rtnCntrKeyMap.get("spcl_cgo_rqst_Seq"));
							}
						}
					}
					
					scgPrnrAproRqstVO.setCreUsrId(USER_ID);
					scgPrnrAproRqstVO.setUpdUsrId(USER_ID);
					
					scgPrnrAproRqstVOs[nRow] = scgPrnrAproRqstVO;
				}
				/********************************************************************************
				 * Finished...Setting Partner Line's Booking Header Information from EDI 
				 * ==============================================================================
				 */
				
				
				/********************************************************************************
				 * Started...Setting Partner Line's Booking Detail Information from EDI 
				 * ==============================================================================
				 */
				ScgPrnrAproRqstCgoVO[] scgPrnrAproRqstCgoVOs = new ScgPrnrAproRqstCgoVO[scgPrnrSpclCgoDtlLogVOs.size()];
				
				for (int nRow = 0; nRow < scgPrnrSpclCgoDtlLogVOs.size(); nRow++) {
					
					ScgPrnrAproRqstCgoVO scgPrnrAproRqstCgoVO = new ScgPrnrAproRqstCgoVO();
					
					if ("U".equals(scgPrnrSpclCgoDtlLogVOs.get(nRow).getIbflag()) || "D".equals(scgPrnrSpclCgoDtlLogVOs.get(nRow).getIbflag())) {
						scgPrnrAproRqstCgoVO.setCrrCd			(scgPrnrSpclCgoDtlLogVOs.get(nRow).getCrrCd());
						scgPrnrAproRqstCgoVO.setSpclCgoRqstSeq	(scgPrnrSpclCgoDtlLogVOs.get(nRow).getSpclCgoRqstSeq());						
					}
					
					scgPrnrAproRqstCgoVO.setDgFlg				("Y");
					scgPrnrAproRqstCgoVO.setAwkFlg				("N");
					
					/** SETTING CONTAINER SEQ + CARGO SEQ ******************************************************/
					scgPrnrAproRqstCgoVO.setSpclCntrSeq			(scgPrnrSpclCgoDtlLogVOs.get(nRow).getCntrSeq	());
					scgPrnrAproRqstCgoVO.setSpclCgoSeq			(scgPrnrSpclCgoDtlLogVOs.get(nRow).getCgoSeq	());
					scgPrnrAproRqstCgoVO.setEdiItmSeq			(scgPrnrSpclCgoDtlLogVOs.get(nRow).getEdiItmSeq	());
					
					//------------- IMDG MASTER INFORMATION ---------------------------------------------------//
					
					/** Adding setup IMDG Amendment Number **/
					scgPrnrAproRqstCgoVO.setImdgAmdtNo			(scgPrnrSpclCgoDtlLogVOs.get(nRow).getImdgAmdtNo());

					scgPrnrAproRqstCgoVO.setImdgClssCd			(scgPrnrSpclCgoDtlLogVOs.get(nRow).getImdgClssCdCtnt());
					
					/** Search unique UN#_SEQ from IMDG Master for specific UN No, PSN and Packing Group Code **/
					scgPrnrAproRqstCgoVO.setImdgUnNo			(scgPrnrSpclCgoDtlLogVOs.get(nRow).getImdgUnNoCtnt());
					scgPrnrAproRqstCgoVO.setImdgUnNoSeq			(scgPrnrSpclCgoDtlLogVOs.get(nRow).getImdgUnNoSeq());	
					
					scgPrnrAproRqstCgoVO.setCfrFlg				(scgPrnrSpclCgoDtlLogVOs.get(nRow).getCfrFlg());
					
					scgPrnrAproRqstCgoVO.setImdgCoGrpCd			(scgPrnrSpclCgoDtlLogVOs.get(nRow).getImdgCompGrpCd());		//:IMDG_CO_GRP_CD://
					scgPrnrAproRqstCgoVO.setImdgCompGrpCd		(scgPrnrSpclCgoDtlLogVOs.get(nRow).getImdgCompGrpCd());		//xxxxxxxxxxxxxxxx//
					
					
					scgPrnrAproRqstCgoVO.setImdgPckGrpCd		(scgPrnrSpclCgoDtlLogVOs.get(nRow).getImdgPckGrpCdCtnt()); 	// Packing Group
					
					/** Search EMS# from IMDG Master for specific UN No ************************************/
					scgPrnrAproRqstCgoVO.setEmsNo				(scgPrnrSpclCgoDtlLogVOs.get(nRow).getEmsNo());
					
					scgPrnrAproRqstCgoVO.setPrpShpNm			(scgPrnrSpclCgoDtlLogVOs.get(nRow).getPrpShpNm());
					scgPrnrAproRqstCgoVO.setImdgLmtQtyFlg		(scgPrnrSpclCgoDtlLogVOs.get(nRow).getImdgLmtQtyFlgCtnt());
					
					scgPrnrAproRqstCgoVO.setImdgTecNm			(scgPrnrSpclCgoDtlLogVOs.get(nRow).getImdgTecNm());
					
					
					//sub label 
					scgPrnrAproRqstCgoVO.setN1stImdgSubsRskLblCd(scgPrnrSpclCgoDtlLogVOs.get(nRow).getN1stImdgSubsRskLblCd());
					scgPrnrAproRqstCgoVO.setN2ndImdgSubsRskLblCd(scgPrnrSpclCgoDtlLogVOs.get(nRow).getN2ndImdgSubsRskLblCd());
					scgPrnrAproRqstCgoVO.setN3rdImdgSubsRskLblCd(scgPrnrSpclCgoDtlLogVOs.get(nRow).getN3rdImdgSubsRskLblCd());
					scgPrnrAproRqstCgoVO.setN4thImdgSubsRskLblCd(scgPrnrSpclCgoDtlLogVOs.get(nRow).getN4thImdgSubsRskLblCd());
					scgPrnrAproRqstCgoVO.setN5thImdgSubsRskLblCd(scgPrnrSpclCgoDtlLogVOs.get(nRow).getN5thImdgSubsRskLblCd());
					scgPrnrAproRqstCgoVO.setN6thImdgSubsRskLblCd(scgPrnrSpclCgoDtlLogVOs.get(nRow).getN6thImdgSubsRskLblCd());
					scgPrnrAproRqstCgoVO.setN7thImdgSubsRskLblCd(scgPrnrSpclCgoDtlLogVOs.get(nRow).getN7thImdgSubsRskLblCd());
					scgPrnrAproRqstCgoVO.setN8thImdgSubsRskLblCd(scgPrnrSpclCgoDtlLogVOs.get(nRow).getN8thImdgSubsRskLblCd());
					
					
					scgPrnrAproRqstCgoVO.setImdgSubsRskLblRmk	("");
					scgPrnrAproRqstCgoVO.setRadaSkdNo			("");
					
					scgPrnrAproRqstCgoVO.setCntrTpszCd			(scgPrnrSpclCgoDtlLogVOs.get(nRow).getCntrTpszCdCtnt());	
					scgPrnrAproRqstCgoVO.setUpdUsrId			(USER_ID);
					scgPrnrAproRqstCgoVO.setHcdgFlg				("");
					scgPrnrAproRqstCgoVO.setAuthOfcCd			("");
					scgPrnrAproRqstCgoVO.setHcdgIntmdBcRstrDesc	("");
					scgPrnrAproRqstCgoVO.setSpclCgoCateCd		(CATE_CD);
					scgPrnrAproRqstCgoVO.setSkdVoyNo			(scgHdrVO.getSkdVoyNo());
					scgPrnrAproRqstCgoVO.setVoidSltQty			("");
					
					scgPrnrAproRqstCgoVO.setPolCd				(scgHdrVO.getPolCd());											//::POL:://
					scgPrnrAproRqstCgoVO.setPodCd				(scgHdrVO.getPodCd());											//::POD:://
					
					scgPrnrAproRqstCgoVO.setHgtOvrDimLen		("");
					scgPrnrAproRqstCgoVO.setIntmdN2ndImdgPckDesc("");
					scgPrnrAproRqstCgoVO.setRadaAmt				("");
					scgPrnrAproRqstCgoVO.setNetExploWgt			("");
					scgPrnrAproRqstCgoVO.setCmdtDesc			("");

					scgPrnrAproRqstCgoVO.setEmerRspnGidNo		("");
					scgPrnrAproRqstCgoVO.setAuthUsrId			("");
					scgPrnrAproRqstCgoVO.setCneeDtlDesc			("");
					
					scgPrnrAproRqstCgoVO.setEmerCntcPhnNo		(scgPrnrSpclCgoDtlLogVOs.get(nRow).getEmerCntcPhnNo());
					
					scgPrnrAproRqstCgoVO.setFlshPntCdoTemp		(scgPrnrSpclCgoDtlLogVOs.get(nRow).getFlshPntTempCtnt());
					scgPrnrAproRqstCgoVO.setImdgLmtQtyMeasUtCd	("");
					scgPrnrAproRqstCgoVO.setIntmdN2ndImdgPckQty	("");
					scgPrnrAproRqstCgoVO.setIntmdN1stImdgPckQty	(scgPrnrSpclCgoDtlLogVOs.get(nRow).getIntmdN1stImdgPckQtyCtnt());
					scgPrnrAproRqstCgoVO.setIntmdN1stImdgPckCd	(scgPrnrSpclCgoDtlLogVOs.get(nRow).getIntmdN1stImdgPckCdCtnt());
					scgPrnrAproRqstCgoVO.setIntmdN1stImdgPckDesc(scgPrnrSpclCgoDtlLogVOs.get(nRow).getIntmdN1stImdgPckDesc());
					
					scgPrnrAproRqstCgoVO.setImdgLmtQty			("");
					
					
					/** Adding IMDG Packaging Code + Quantity **/
					scgPrnrAproRqstCgoVO.setInN1stImdgPckQty	(scgPrnrSpclCgoDtlLogVOs.get(nRow).getInN1stImdgPckQtyCtnt());
					scgPrnrAproRqstCgoVO.setInN1stImdgPckCd		(scgPrnrSpclCgoDtlLogVOs.get(nRow).getInN1stImdgPckCdCtnt());
					scgPrnrAproRqstCgoVO.setInN1stImdgPckDesc	(scgPrnrSpclCgoDtlLogVOs.get(nRow).getInN1stImdgPckDesc());
					
					scgPrnrAproRqstCgoVO.setOutN2ndImdgPckQty	("");
					scgPrnrAproRqstCgoVO.setOutN2ndImdgPckDesc	("");
					scgPrnrAproRqstCgoVO.setOutN2ndImdgPckCd	("");
					
					scgPrnrAproRqstCgoVO.setMaxInPckQty			("");
					
					scgPrnrAproRqstCgoVO.setInN2ndImdgPckQty	("");
					scgPrnrAproRqstCgoVO.setInN2ndImdgPckDesc	("");
					scgPrnrAproRqstCgoVO.setInN2ndImdgPckCd		("");
					
					scgPrnrAproRqstCgoVO.setMeasTpCd			(scgPrnrSpclCgoDtlLogVOs.get(nRow).getPckTpCdCtnt());
					scgPrnrAproRqstCgoVO.setMeasQty				(scgPrnrSpclCgoDtlLogVOs.get(nRow).getPckQtyCtnt());
					
					scgPrnrAproRqstCgoVO.setSpclStwgRqstDesc	(scgPrnrSpclCgoDtlLogVOs.get(nRow).getSpclStwgRqstDesc());
					
					
					scgPrnrAproRqstCgoVO.setDiffRmk				(scgPrnrSpclCgoDtlLogVOs.get(nRow).getDiffRmk());
					
					//:2015-08-28://scgPrnrAproRqstCgoVO.setAuthStsCd			(("D".equals(scgPrnrSpclCgoDtlLogVOs.get(nRow).getIbflag()) ? "X" : "R"));
					scgPrnrAproRqstCgoVO.setAuthStsCd			(("D".equals(scgPrnrSpclCgoDtlLogVOs.get(nRow).getIbflag()) ? "C" : "R"));
					
					scgPrnrAproRqstCgoVO.setOutN1stImdgPckQty	(scgPrnrSpclCgoDtlLogVOs.get(nRow).getOutN1stImdgPckQtyCtnt());
					scgPrnrAproRqstCgoVO.setOutN1stImdgPckCd	(scgPrnrSpclCgoDtlLogVOs.get(nRow).getOutN1stImdgPckCdCtnt());
					scgPrnrAproRqstCgoVO.setOutN1stImdgPckDesc	(scgPrnrSpclCgoDtlLogVOs.get(nRow).getOutN1stImdgPckDesc());
					
					
					scgPrnrAproRqstCgoVO.setSlanCd				(scgHdrVO.getSlanCd());
					scgPrnrAproRqstCgoVO.setVslCd				(scgHdrVO.getVslCd());
					scgPrnrAproRqstCgoVO.setSkdDirCd			(scgHdrVO.getSkdDirCd());
					
					scgPrnrAproRqstCgoVO.setBkgRefNo			(scgHdrVO.getBkgRefNo());
					
					scgPrnrAproRqstCgoVO.setCgoOprCd			(scgHdrVO.getCgoOprCd());
					
					scgPrnrAproRqstCgoVO.setCntrRefNo			(scgPrnrSpclCgoDtlLogVOs.get(nRow).getCntrRefNo());
					
					scgPrnrAproRqstCgoVO.setTtlDimWdt			("");
					scgPrnrAproRqstCgoVO.setPsaNo				("");
					
					scgPrnrAproRqstCgoVO.setDcgoStsCd			(scgPrnrSpclCgoDtlLogVOs.get(nRow).getDcgoStsCdCtnt());
					scgPrnrAproRqstCgoVO.setEmerCntcPsonNm		(scgPrnrSpclCgoDtlLogVOs.get(nRow).getEmerCntcPsonNm());
					
					scgPrnrAproRqstCgoVO.setImdgSpclProviNo		("");
					//scgPrnrAproRqstCgoVO.setCrrCd("NYK");
					scgPrnrAproRqstCgoVO.setLfSdOvrDimLen		("");
					
					scgPrnrAproRqstCgoVO.setFwrdOvrDimLen		("");
					scgPrnrAproRqstCgoVO.setWgtUtCd				(scgPrnrSpclCgoDtlLogVOs.get(nRow).getGrsWgtUtCdCtnt());
					
					if ("P".equals(scgPrnrSpclCgoDtlLogVOs.get(nRow).getImdgMrnPolutCdCtnt()) || 
						"PP".equals(scgPrnrSpclCgoDtlLogVOs.get(nRow).getImdgMrnPolutCdCtnt())) {
						scgPrnrAproRqstCgoVO.setMrnPolutFlg		("Y");
					} else {
						scgPrnrAproRqstCgoVO.setMrnPolutFlg		("N");
					}
					
					
					scgPrnrAproRqstCgoVO.setAuthDt				("");
					scgPrnrAproRqstCgoVO.setNetWgt				(scgPrnrSpclCgoDtlLogVOs.get(nRow).getNetWgtCtnt());
					
					scgPrnrAproRqstCgoVO.setTtlDimHgt			("");
					scgPrnrAproRqstCgoVO.setCreUsrId			(USER_ID);
					scgPrnrAproRqstCgoVO.setCgoLclFlg			("");
					scgPrnrAproRqstCgoVO.setHzdDesc				(scgPrnrSpclCgoDtlLogVOs.get(nRow).getImdgTecNm());
					scgPrnrAproRqstCgoVO.setTtlDimLen			("");
					scgPrnrAproRqstCgoVO.setCgoRqstDt			(G_TRSM_DT);						// TO_CHAR
					scgPrnrAproRqstCgoVO.setEmerRspnGidChrNo	("");
					scgPrnrAproRqstCgoVO.setAproRefNo			("");
					scgPrnrAproRqstCgoVO.setEmerTempCtnt		("");
					scgPrnrAproRqstCgoVO.setGrsWgt				(scgPrnrSpclCgoDtlLogVOs.get(nRow).getGrsWgtCtnt());
					scgPrnrAproRqstCgoVO.setRtSdOvrDimLen		("");
					
					scgPrnrAproRqstCgoVO.setCreDt				("");
					scgPrnrAproRqstCgoVO.setRadaTrspNo			("");
					scgPrnrAproRqstCgoVO.setMaxInPckTpCd		("");
					scgPrnrAproRqstCgoVO.setRadaUtCd			("");
					scgPrnrAproRqstCgoVO.setIbflag				(scgPrnrSpclCgoDtlLogVOs.get(nRow).getIbflag());
					
					//::2015-05-30:by TOP:://scgPrnrAproRqstCgoVO.setRefNo(scgPrnrSpclCgoDtlLogVOs.get(nRow).getRefNo());
					scgPrnrAproRqstCgoVO.setDcgoRefNo			(scgPrnrSpclCgoDtlLogVOs.get(nRow).getDcgoRefNo());
					
					// 확인 
					scgPrnrAproRqstCgoVO.setCertiNo				("");
					scgPrnrAproRqstCgoVO.setHcdgPckRstrDesc		("");
					scgPrnrAproRqstCgoVO.setIntmdN2ndImdgPckCd	("");
					scgPrnrAproRqstCgoVO.setImdgExptQtyFlg		("N");
					scgPrnrAproRqstCgoVO.setImdgExptQtyCd		("");
					
					scgPrnrAproRqstCgoVO.setUpdDt				("");
					scgPrnrAproRqstCgoVO.setClodFlg				("");
					scgPrnrAproRqstCgoVO.setBkwdOvrDimLen		("");

					scgPrnrAproRqstCgoVO.setCtrlTempCtnt		("");
					scgPrnrAproRqstCgoVO.setHcdgTnkRstrDesc		("");
					
					
					scgPrnrAproRqstCgoVOs[nRow] 				= scgPrnrAproRqstCgoVO;
				}
				/********************************************************************************
				 * Finished...Setting Partner Line's Booking Detail Information from EDI 
				 * ==============================================================================
				 */
				
				PartnerApprovalRequestVO partnerApprovalRequestVO = new PartnerApprovalRequestVO();
				
				partnerApprovalRequestVO.setRgnShpOprCd				(VSKGeneralUtil.getCheckNullToString(scgHdrVO.getRgnShpOprCd()));
				partnerApprovalRequestVO.setCrrCd					(G_VSL_OPR_CD);
				partnerApprovalRequestVO.setBkgRefNo				(G_BKG_REF_NO);
				partnerApprovalRequestVO.setDgFlg					("Y");
				partnerApprovalRequestVO.setAwkFlg					("N");
				partnerApprovalRequestVO.setEdiTrsmStsCd			(G_EDI_MSG_STS_CD);
				
				/** Setting TRSM_DT & PRNR_SPCL_CGO_SEQ **/
				partnerApprovalRequestVO.setTrsmDt					(G_TRSM_DT			);
				partnerApprovalRequestVO.setPrnrSpclCgoSeq			(G_PRNR_SPCL_CGO_SEQ);
				
				partnerApprovalRequestVO.setScgPrnrAproRqstVOs		(scgPrnrAproRqstVOs		);		/** << TABLE NAME : SCG_PRNR_APRO_RQST 		>> */
				partnerApprovalRequestVO.setScgPrnrAproRqstCgoVOs	(scgPrnrAproRqstCgoVOs	);		/** << TABLE NAME : SCG_PRNR_APRO_RQST_CGO 	>> */
				
				partnerApprovalRequestVO.setEdiUnmapKndCd			(scgHdrVO.getEdiUnmapKndCd());	/** adding EDI_UNMAP_KND_CD : 2015-08-28 **/ 
				
				scgHdrVO.setLstTrsmStsCd							("S");
				scgHdrVO.setErrKndCd								("O");
				scgHdrVO.setUpdUsrId								(USER_ID);
				//mapVO.put("lst_trsm_sts_cd"	, "S");
				//mapVO.put("err_knd_cd"     	, "O");
				//mapVO.put("upd_usr_id"     	, USER_ID);
				
				dbDao.modifyErrTrsmHdr								(scgHdrVO);
				
				/*************************************************************** 
				 * Creation Header Table for Partner Lines	
				 * ============================================================
				 * 1. SCG_PRNR_APRO_RQST	
				 * 2. SCG_PRNR_APRO_RQST_CGO
				 * ------------------------------------------------------------
				 * **/
				this.managePartnerSCGfromEDI						(partnerApprovalRequestVO, trsmHdrUnmapVOs, trsmCntrLogUnmapVOs, trsmCgoDtlLogUnmapVOs);	/** << TABLE NAME : SCG_PRNR_APRO_RQST + SCG_PRNR_APRO_RQST_CGO >> */
				
			}
			
			/** Sending Acknowledge for IFTMBF(I/B) ***********************/ 
			this.scgPrnrSpclCgoTrsmAckSend							(scgHdrVO, isErrorExist, sErrorCode);	/** << TABLE NAME : SCG_PRNR_SPCL_CGO_TRSM_ACK >> */
			
		} catch (Exception ex) {
			
			//ack 처리				
			try {
				scgPrnrSpclCgoTrsmAckSend(scgHdrVO, isErrorExist, sErrorCode);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
			log.error(ex.getMessage());
			addScgPrnrSpclCgoFltFile(scgHdrVO.getTrsmBndCd(), scgHdrVO.getPrnrSpclCgoSeq(), scgHdrVO.getBkgRefNo(), ediFlatFile, ex.getMessage());
		}

		return flatFilePartnerLineVOs;
	}
	
	
	/**
	 * VOP_SCG_0022 : Save <br>
	 * SPCL CGO APVL for Partner Lines create,modify,delete <br>
	 * 
	 * @param PartnerApprovalRequestVO partnerApprovalRequestVO
	 * @param List<ScgPrnrTrsmHdrUnmapVO> trsmHdrUnmapVOs
	 * @param List<ScgPrnrCntrLogUnmapVO> trsmCntrLogUnmapVOs
	 * @param List<ScgPrnrCgoDtlLogUnmapVO>   trsmCgoDtlLogUnmapVOs
	 * @return int
	 * @exception EventException
	 */
	public int managePartnerSCGfromEDI(PartnerApprovalRequestVO partnerApprovalRequestVO, List<ScgPrnrTrsmHdrUnmapVO> trsmHdrUnmapVOs, List<ScgPrnrCntrLogUnmapVO> trsmCntrLogUnmapVOs, List<ScgPrnrCgoDtlLogUnmapVO> trsmCgoDtlLogUnmapVOs) throws EventException{
		
		try {
		
			if(partnerApprovalRequestVO != null) {
				
				ScgPrnrAproRqstVO[]     scgPrnrAproRqstVOs     	= partnerApprovalRequestVO.getScgPrnrAproRqstVOs	();	
				ScgPrnrAproRqstCgoVO[]  scgPrnrAproRqstCgoVOs  	= partnerApprovalRequestVO.getScgPrnrAproRqstCgoVOs	();
				List<ScgPrnrAproRqstVO> insertVoList1 			= new ArrayList<ScgPrnrAproRqstVO>();
				List<ScgPrnrAproRqstVO> updateVoList1 			= new ArrayList<ScgPrnrAproRqstVO>();
				List<ScgPrnrAproRqstVO> deleteVoList1 			= new ArrayList<ScgPrnrAproRqstVO>();
				
				List<ScgPrnrAproRqstCgoVO> insertVoList2 		= new ArrayList<ScgPrnrAproRqstCgoVO>();
				List<ScgPrnrAproRqstCgoVO> updateVoList2 		= new ArrayList<ScgPrnrAproRqstCgoVO>();
				List<ScgPrnrAproRqstCgoVO> deleteVoList2 		= new ArrayList<ScgPrnrAproRqstCgoVO>();
				
				if(scgPrnrAproRqstVOs != null) {
					
					//Sort by booking number and Cargo number
					int bkgRqtCt 	= scgPrnrAproRqstVOs.length;
					int cagoRqtCt 	= scgPrnrAproRqstCgoVOs==null?0:scgPrnrAproRqstCgoVOs.length;
					
					
					for ( int bkgIdx=0; bkgIdx < bkgRqtCt; bkgIdx++ ) {
						
						scgPrnrAproRqstVOs[bkgIdx].setRgnShpOprCd	(partnerApprovalRequestVO.getRgnShpOprCd	());
						scgPrnrAproRqstVOs[bkgIdx].setCrrCd			(partnerApprovalRequestVO.getCrrCd			());
						scgPrnrAproRqstVOs[bkgIdx].setBkgRefNo		(partnerApprovalRequestVO.getBkgRefNo		());
						
						scgPrnrAproRqstVOs[bkgIdx].setDgFlg			(partnerApprovalRequestVO.getDgFlg			());	
						scgPrnrAproRqstVOs[bkgIdx].setAwkFlg		(partnerApprovalRequestVO.getAwkFlg			());
						scgPrnrAproRqstVOs[bkgIdx].setSpclCgoCateCd	("DG");
						
						scgPrnrAproRqstVOs[bkgIdx].setEdiUnmapKndCd	(partnerApprovalRequestVO.getEdiUnmapKndCd	());
						
						scgPrnrAproRqstVOs[bkgIdx].setCreUsrId		(USER_ID);
						scgPrnrAproRqstVOs[bkgIdx].setUpdUsrId		(USER_ID);
						

						//In case of DG Detail Pop-Up, sort BKG & CARGO's parameter by SLAN_CD.
						////if(scgPrnrAproRqstVOs[bkgIdx].getBkgRefNo() != null && !"".equals(scgPrnrAproRqstVOs[bkgIdx].getBkgRefNo()) && !"".equals(scgPrnrAproRqstVOs[bkgIdx].getSlanCd())) {
						if(scgPrnrAproRqstVOs[bkgIdx].getBkgRefNo() != null && !"".equals(scgPrnrAproRqstVOs[bkgIdx].getBkgRefNo())) {
									
							if ("I".equals(scgPrnrAproRqstVOs[bkgIdx].getIbflag()) ||
								"U".equals(scgPrnrAproRqstVOs[bkgIdx].getIbflag()) ||
								"D".equals(scgPrnrAproRqstVOs[bkgIdx].getIbflag())) {	
								
								insertVoList1.add(scgPrnrAproRqstVOs[bkgIdx]);								
							}
							
							if ("U".equals(scgPrnrAproRqstVOs[bkgIdx].getIbflag())) {
								updateVoList1.add(scgPrnrAproRqstVOs[bkgIdx]);
							} else if ("D".equals(scgPrnrAproRqstVOs[bkgIdx].getIbflag())) {
								deleteVoList1.add(scgPrnrAproRqstVOs[bkgIdx]);
							}
						}
					}
					
					for ( int cgoIdx=0; cgoIdx<cagoRqtCt; cgoIdx++ ) {
						
						// compulsory items handling exception
						Method[] 	methods  	= scgPrnrAproRqstCgoVOs[cgoIdx].getClass().getMethods();		
						String 		gMethodNm 	= "";
						String		sMethodNm 	= "";
						
						for(int mIdx1=0; mIdx1<methods.length; mIdx1++) {
							Method gMethod = methods[mIdx1];
							
							if (gMethod.getName().indexOf("get") != -1) {
								if(gMethod.getReturnType().getName().equals("java.lang.String")) {
									String val = (String)gMethod.invoke(scgPrnrAproRqstCgoVOs[cgoIdx]);									
						            if(val == null || "".equals(val)) {
						            	gMethodNm = gMethod.getName();
										gMethodNm = gMethodNm.substring(3,gMethodNm.length());								
							            for(int mIdx2=0; mIdx2<methods.length; mIdx2++) {
											Method sMethod = methods[mIdx2];
											sMethodNm = sMethod.getName();
											sMethodNm = sMethodNm.substring(3,sMethodNm.length());
											if(sMethod.getName().indexOf("set") != -1 && gMethodNm.equals(sMethodNm)) {
												if("AproRefNo".equals(gMethodNm)        || "PckQty".equals(gMethodNm)           ||
												   "InN1stImdgPckQty".equals(gMethodNm) || "InN2ndImdgPckQty".equals(gMethodNm) ||
												   "MaxInPckQty".equals(gMethodNm)      || "MeasQty".equals(gMethodNm)          ||
												   "OutN1stImdgPckQty".equals(gMethodNm)|| "OutN2ndImdgPckQty".equals(gMethodNm)||
												   "ImdgUnNo".equals(gMethodNm)         || "ImdgUnNoSeq".equals(gMethodNm)
											      ) {
													sMethod.invoke(scgPrnrAproRqstCgoVOs[cgoIdx], "0");
												} else if(gMethodNm.equals("ClodFlg")) {
													sMethod.invoke(scgPrnrAproRqstCgoVOs[cgoIdx], "N");
												}
											}
							            }
						            }
								}
					        }
						}
						
						//In case of DG Detail Pop-Up, sort BKG & CARGO's parameter by CNTR_SEQ.
						//if(scgPrnrAproRqstCgoVOs[cgoIdx].getSpclCntrSeq() != null && !"".equals(scgPrnrAproRqstCgoVOs[cgoIdx].getSpclCntrSeq())) {
						if(scgPrnrAproRqstCgoVOs[cgoIdx].getEdiItmSeq() != null && !"".equals(scgPrnrAproRqstCgoVOs[cgoIdx].getEdiItmSeq())) {
									
							scgPrnrAproRqstCgoVOs[cgoIdx].setCrrCd			(partnerApprovalRequestVO.getCrrCd			());
							scgPrnrAproRqstCgoVOs[cgoIdx].setBkgRefNo		(partnerApprovalRequestVO.getBkgRefNo		());
							
							/** Setting TRSM_DT & PRNR_SPCL_CGO_SEQ **/
							scgPrnrAproRqstCgoVOs[cgoIdx].setTrsmDt			(partnerApprovalRequestVO.getTrsmDt			());
							scgPrnrAproRqstCgoVOs[cgoIdx].setPrnrSpclCgoSeq	(partnerApprovalRequestVO.getPrnrSpclCgoSeq	());
							
							scgPrnrAproRqstCgoVOs[cgoIdx].setEdiTrsmStsCd	(G_EDI_MSG_STS_CD);
							scgPrnrAproRqstCgoVOs[cgoIdx].setDgFlg			(partnerApprovalRequestVO.getDgFlg			());	
							scgPrnrAproRqstCgoVOs[cgoIdx].setAwkFlg			(partnerApprovalRequestVO.getAwkFlg			());
							
							scgPrnrAproRqstCgoVOs[cgoIdx].setAuthOfcCd		("");
							scgPrnrAproRqstCgoVOs[cgoIdx].setAuthUsrId		("");
							scgPrnrAproRqstCgoVOs[cgoIdx].setCreUsrId		(USER_ID);
							scgPrnrAproRqstCgoVOs[cgoIdx].setUpdUsrId		(USER_ID);
							
							if ("I".equals(scgPrnrAproRqstCgoVOs[cgoIdx].getIbflag()) ||
								"U".equals(scgPrnrAproRqstCgoVOs[cgoIdx].getIbflag()) ||
								"D".equals(scgPrnrAproRqstCgoVOs[cgoIdx].getIbflag())) {
								
								insertVoList2.add(scgPrnrAproRqstCgoVOs[cgoIdx]);
							}

							if ("U".equals(scgPrnrAproRqstCgoVOs[cgoIdx].getIbflag())) {							
								updateVoList2.add(scgPrnrAproRqstCgoVOs[cgoIdx]);
							} else if ("D".equals(scgPrnrAproRqstCgoVOs[cgoIdx].getIbflag())) {
								deleteVoList2.add(scgPrnrAproRqstCgoVOs[cgoIdx]);
							}
						}
					}
					
					//1. delete process
					if ( deleteVoList2.size() > 0 ) {
						//1-1. Delete Cargo
						
						//-- ::2015-07-25:by TOP:: --
						
						//AS-IS:dbDao1.removePartnerEdiSCGCGO		(deleteVoList2);	/** << TABLE NAME : SCG_PRNR_APRO_RQST_CGO >> **/
						dbDao1.modifyPartnerEdiSCGCGO				(deleteVoList2);	/** << TABLE NAME : SCG_PRNR_APRO_RQST_CGO >> **/
						////dbDao.UpdateScgPrnrAproRqstCgoAuthStatus(deleteVoList2);	/** << TABLE NAME : SCG_PRNR_APRO_RQST_CGO >> **/
						
						//1-2. If all cargoes are deleted, delete request.
						Iterator 	list 	= deleteVoList1.iterator();	
						String[] 	rmList 	= new String[deleteVoList1.size()];	
						int 		isCt 	= 0;
						int			expCt 	= 0;
						
			        	while(list.hasNext()){
			        		ScgPrnrAproRqstVO vo = (ScgPrnrAproRqstVO)list.next();
			        		
			        		//-- ::2015-07-25:by TOP:: --
			        		isCt = dbDao1.searchPatnerSCGCGOIsSeq(vo);
			        		if(isCt > 0) {
			        			rmList[expCt] = "Y";
			        		}
			        		expCt++;
			        	}
			        	
//			        	for(int delCt=rmList.length-1; delCt >= 0; delCt--) {
//							if("Y".equals(rmList[delCt])) deleteVoList1.remove(delCt);
//		        		}
			        	
			        	if ( deleteVoList1.size() > 0 ) {
			        		//-- ::2015-07-25:by TOP:: --
							//AS-IS:dbDao1.removePartnerEdiSCG		(deleteVoList1);
							dbDao1.modifyPartnerEdiSCG				(deleteVoList1);	/** << TABLE NAME : SCG_PRNR_APRO_RQST     >> **/
						}
					}
					
					//2. modify process
					if ( updateVoList1.size() > 0 ) {
						//-- ::2015-07-25:by TOP:: --
						dbDao.modifyPartnerDGEdiforPreRqst			(updateVoList1);	/** << TABLE NAME : SCG_PRNR_APRO_RQST     >> **/
					}
					if ( updateVoList2.size() > 0 ) {
						//-- ::2015-07-25:by TOP:: --
						dbDao1.modifyPartnerEdiSCGCGO				(updateVoList2);	/** << TABLE NAME : SCG_PRNR_APRO_RQST_CGO >> **/
					}
					
					//3. create process
					if ( insertVoList2.size() > 0 ) {
						//3-1. Sort request by <standard:BKG Company, BKG No, VVD CD, POL, POD>
						String[] 	rmList 	= new String[insertVoList1.size()];	
						String 		valStr1 = "", valStr2 = "";
						
						
						for(int expCt1=0; expCt1<insertVoList1.size(); expCt1++) {
							
							ScgPrnrAproRqstVO vo1 		= (ScgPrnrAproRqstVO)insertVoList1.get(expCt1);
							valStr1 					= vo1.getCgoOprCd() + vo1.getBkgRefNo() + vo1.getVslCd() + vo1.getSkdVoyNo() + vo1.getSkdDirCd() + vo1.getPolCd() + vo1.getPolClptIndSeq() + vo1.getPodCd() + vo1.getPodClptIndSeq();
						
							for(int expCt2=expCt1+1; expCt2<insertVoList1.size(); expCt2++) {
								ScgPrnrAproRqstVO vo2 	= (ScgPrnrAproRqstVO)insertVoList1.get(expCt2);
								valStr2 				= vo2.getCgoOprCd() + vo2.getBkgRefNo() + vo2.getVslCd() + vo2.getSkdVoyNo() + vo2.getSkdDirCd() + vo2.getPolCd() + vo2.getPolClptIndSeq() + vo2.getPodCd() + vo2.getPodClptIndSeq();
								
								if(valStr1.equals(valStr2)) rmList[expCt1] = "Y";
							}
						}
						
			        	for(int delCt=rmList.length-1; delCt >= 0; delCt--) {
							if("Y".equals(rmList[delCt])) insertVoList1.remove(delCt);
		        		}
			        	
			        	//3-2. Create request numbers.
			        	//:2015-07-16:by TOP://int spclCgoRqstSeq = dbDao1.searchPatnerSCGMaxSeq();
			        	
			        	String	sTmpSpclCgoRqstSeq	= dbDao.searchPartnerDGEDIAproRqstSeq	(insertVoList1.get(0));

			        	int spclCgoRqstSeq 			= sTmpSpclCgoRqstSeq == null || "".equals(sTmpSpclCgoRqstSeq) ? 0 : Integer.parseInt(sTmpSpclCgoRqstSeq);
			        	
			        	for(int insCt1=0; insCt1<insertVoList1.size(); insCt1++) {
			        		insertVoList1.get(insCt1).setSpclCgoRqstSeq(Integer.toString(spclCgoRqstSeq));
			        		valStr1 	= insertVoList1.get(insCt1).getCgoOprCd() + insertVoList1.get(insCt1).getBkgRefNo() + insertVoList1.get(insCt1).getVslCd() + insertVoList1.get(insCt1).getSkdVoyNo() + insertVoList1.get(insCt1).getSkdDirCd() + insertVoList1.get(insCt1).getPolCd() + insertVoList1.get(insCt1).getPodCd();
			        		
			        		//Label request number on Cargo
			        		for(int insCt2 = 0; insCt2<insertVoList2.size(); insCt2++) {
			        			valStr2 = insertVoList2.get(insCt2).getCgoOprCd() + insertVoList2.get(insCt2).getBkgRefNo() + insertVoList2.get(insCt2).getVslCd() + insertVoList2.get(insCt2).getSkdVoyNo() + insertVoList2.get(insCt2).getSkdDirCd() + insertVoList2.get(insCt2).getPolCd() + insertVoList2.get(insCt2).getPodCd();
			        			
			        			if(valStr1.equals(valStr2)) {
			        				insertVoList2.get(insCt2).setSpclCgoRqstSeq(Integer.toString(spclCgoRqstSeq));
			        			}
			        		}
			        		////::2016-02-15:by TOP:////spclCgoRqstSeq++;
			        	}
			        	
			        	int						 iPrnrRqstSeq		= 0;
			        	
			        	//3-4. Create request.
			        	if(insertVoList1.size() > 0) {
			        		
			        		//Map<String, String> mapVO = new HashMap<String, String>();
			        		//mapVO.put("upd_usr_id", insertVoList1.get(0).getUpdUsrId());
			        		//mapVO.put("crr_cd"    , insertVoList1.get(0).getCrrCd	());
			        		//mapVO.put("bkg_ref_no", insertVoList1.get(0).getBkgRefNo());
			        		dbDao1.modifyScgPrnrAproLstRqstDatFlg	(insertVoList1.get(0));
			        		List<ScgPrnrAproRqstVO>  convScgPrnrAproRqstVOs	= new ArrayList<ScgPrnrAproRqstVO>();
			        		for(ScgPrnrAproRqstVO tmpVO:insertVoList1){
			        			
			        			ScgPrnrAproRqstVO scgPrnrAproRqstVO	= new ScgPrnrAproRqstVO();
			        			scgPrnrAproRqstVO.setCrrCd			(G_VSL_OPR_CD			);
			        			scgPrnrAproRqstVO.setCgoOprCd		(G_CGO_OPR_CD			);
			        			scgPrnrAproRqstVO.setBkgRefNo		(G_BKG_REF_NO			);
			        			scgPrnrAproRqstVO.setSpclCgoCateCd	("DG"					);
			        			scgPrnrAproRqstVO.setVslCd			(tmpVO.getVslCd		()	);
			        			scgPrnrAproRqstVO.setSkdVoyNo		(tmpVO.getSkdVoyNo	()	);
			        			scgPrnrAproRqstVO.setSkdDirCd		(tmpVO.getSkdDirCd	()	);
			        			scgPrnrAproRqstVO.setPolCd			(tmpVO.getPolCd		()	);
			        			scgPrnrAproRqstVO.setPodCd			(tmpVO.getPodCd		()	);
			        			
			        			boolean isSameBKGExistKnt			= dbDao.checkPartnerDGEDISameBKGExist	(scgPrnrAproRqstVO, null);
			        			String sTmpSeq						= "";
			        			
			        			if(!isSameBKGExistKnt){
			        				iPrnrRqstSeq					= dbDao.searchPartnerNewSpclCgoRqstSeq();					/** ReceiveEdiFromParnterLinesMgtDBDAOSearchPartnerSpclCgoRqstSeqRSQL **/
			        			}else{
			        				sTmpSeq							= dbDao.searchPartnerOrgSpclCgoRqstSeq(scgPrnrAproRqstVO);	/** ReceiveEdiFromParnterLinesMgtDBDAOSearchPartnerOrgSpclCgoRqstSeqRSQL **/
			        				iPrnrRqstSeq					= sTmpSeq == null || "".equals(sTmpSeq) ? 0 : Integer.parseInt(sTmpSeq);
			        			}
			        			
			        			tmpVO.setPrnrCgoRqstSeq				(String.valueOf(iPrnrRqstSeq));
			        			//tmpVO.setSpclCgoRqstSeq			(spclCgoRqstSeq)
			        			
			        			convScgPrnrAproRqstVOs.add			(tmpVO);
			        		}
			        		
			        		//-- ::2015-07-25:by TOP:: --
			        		//::2015-09-15:by TOP:://dbDao1.addPartnerSCG(convScgPrnrAproRqstVOs);		/** << TABLE NAME : SCG_PRNR_APRO_RQST >> : ReceiveEdiFromParnterLinesMgtDBDAOCreatePrnrAproRqstFromPartnerEDICSQL **/
			        		dbDao.createPrnrAproRqstforDG			(convScgPrnrAproRqstVOs);			/** << TABLE NAME : SCG_PRNR_APRO_RQST >> : ReceiveEdiFromParnterLinesMgtDBDAOCreatePrnrAproRqstFromPartnerEDICSQL **/


			        		/********************************************************************
							 * Making Unmapping Data History 
							 ********************************************************************/
			        		if(trsmHdrUnmapVOs != null && trsmHdrUnmapVOs.size()>0){
			        			dbDao.addScgPrnrRqstUnmap			(convScgPrnrAproRqstVOs);			/** << TABLE NAME : SCG_PRNR_RQST_UNMAP >>	**/
			        		}
			        		/********************************************************************/
			        		
			        	}
			        	
			        	//3-5. Create DG Cargo.
			        	if (insertVoList2.size() > 0) {
			        		
			        		/** Creation Partner DG EDI Cargo Information **************************************************
			        		 * TABLE NAME	: SCG_PRNR_APRO_RQST_CGO
			        		 * *********************************************************************************************/
			        		//-- ::2015-07-25:by TOP:: --
			        		//AS-IS:dbDao1.addPartnerSCGCGO	(insertVoList2);						/** << TABLE NAME : SCG_PRNR_APRO_RQST_CGO >> **/
			        		
			        		List<ScgPrnrAproRqstCgoVO> 					tmpScgPrnrAproRqstCgoVOs	= new ArrayList<ScgPrnrAproRqstCgoVO>();
			        		ScgPrnrAproRqstCgoVO						tmpScgPrnrAproRqstCgoVO		= new ScgPrnrAproRqstCgoVO();
			        		tmpScgPrnrAproRqstCgoVO													= insertVoList2.get(0);
			        		
			        		if(tmpScgPrnrAproRqstCgoVO.getSpclCgoRqstSeq() == null || "".equals(tmpScgPrnrAproRqstCgoVO.getSpclCgoRqstSeq())){
			        			tmpScgPrnrAproRqstCgoVO.setSpclCgoRqstSeq(String.valueOf(spclCgoRqstSeq));
			        		}
			        		
			        		tmpScgPrnrAproRqstCgoVO.setPrnrCgoRqstSeq	(String.valueOf(iPrnrRqstSeq));
			        		//tmpScgPrnrAproRqstCgoVO.setSpclCgoRqstSeq	(spclCgoRqstSeq)
			        		tmpScgPrnrAproRqstCgoVO.setEdiTrsmStsCd		(G_EDI_MSG_STS_CD);
			        		
			        		
			        		String sAuthStsCd							= "R";
			        		if(		(trsmHdrUnmapVOs 		!= null && trsmHdrUnmapVOs.size()		>0)
			        			||	(trsmCntrLogUnmapVOs 	!= null && trsmCntrLogUnmapVOs.size()	>0)
			        			||	(trsmCgoDtlLogUnmapVOs 	!= null && trsmCgoDtlLogUnmapVOs.size()	>0))
			        		{
			        			sAuthStsCd	= null;
			        		}
			        		tmpScgPrnrAproRqstCgoVO.setAuthStsCd		(sAuthStsCd);
			        		
			        		
			        		tmpScgPrnrAproRqstCgoVOs.add				(tmpScgPrnrAproRqstCgoVO);
			        		
			        		dbDao.createScgPrnrAproRqstCgo				(tmpScgPrnrAproRqstCgoVOs);			/** << TABLE NAME : SCG_PRNR_APRO_RQST_CGO >> **/
			        		
			        		/* Execution for EDI TRANSMIT STATUS CODE 'U' Only	*/
			        		if("U".equals(G_EDI_MSG_STS_CD)){
			        			dbDao.correctScgPrnrAproRqstCgoDcgoSeq	(tmpScgPrnrAproRqstCgoVO);	
			        		}
			        		/***********************************************************************************************/
			        		
			        		
							/********************************************************************
							 * Making Unmapping Data History 
							 ********************************************************************/
			        		if((	(trsmCntrLogUnmapVOs 	!= null && trsmCntrLogUnmapVOs.size()	> 0))
			        			||	(trsmCgoDtlLogUnmapVOs 	!= null && trsmCgoDtlLogUnmapVOs.size()	> 0))
			        		{
			        			dbDao.addScgPrnrRqstCgoUnmap			(tmpScgPrnrAproRqstCgoVOs);			/** << TABLE NAME : SCG_PRNR_RQST_CGO_UNMAP >>	**/
			        		}
			        		/********************************************************************/
			        	}
			        	//::2016-11-10 
			        	//LST_RQST_DAT_FLG Update again
			        	dbDao.modifyPartnerDGEdiforPreRqst(insertVoList1);
			        	//::2016-11-10
			        	//LST_RQST_DAT_FLG Update again
					}

					
					//4. Duplication check
					List<ScgPrnrAproRqstVO> dupList = null;					
					dupList = dbDao1.searchPatnerSCGRqstDup(scgPrnrAproRqstCgoVOs[0]);	
					
					
					if(dupList.size() > 0) {
						return 0;
					}
				}				
			}
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO APVL for Partner Lines"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO APVL for Partner Lines"}).getMessage(), ex);
        }
		
		return 1;
	}
	
	/**
	 * Handling MQ List. Split MQ Message up \n and drop new line
	 * 
	 * @param String sFlatFile
	 * @return ArrayList<String>
	 * @throws EventException
	 */
	private ArrayList<String> flatFileConvertList(String sFlatFile) throws EventException {
		ArrayList<String> rtnArr = new ArrayList<String>();
		try{
			StringTokenizer token = new StringTokenizer(sFlatFile, "\n");
			while (token.hasMoreTokens()) {				
				rtnArr.add(token.nextToken());
			}
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		return rtnArr;
	}
	
	/**
	 * vsl_cd 리스트를 조회합니다.
	 * 
	 * @param VesselVO vesselVO
	 * @return List<VesselVO>
	 * @exception EventException
	 */
//	private List<VvdVO> searchVvd(List<String> vslCdList, String outBndCssmVoyNo) throws EventException {
//		try {
//			return dbDao.searchVvd(vslCdList, outBndCssmVoyNo);
//		} catch (DAOException ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
//		} 
//	}
	
	/**
	 * master sequence조회.
	 * 
	 * @param 
	 * @return int
	 * @exception EventException
	 */
	private int searchHdrSequence() throws EventException {
		try {
			return dbDao.searchHdrSequence();
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} 
	}
	
	/**
	 * SCG_PRNR_SPCL_CGO_DTL_LOG max sequence 조회합니다.
	 * 
	 * @param ScgPrnrSpclCgoTrsmHdrVO scgHdrVO
	 * @return scgHdrVO
	 * @exception EventException
	 */
	private int searchDtlLogSequence(ScgPrnrSpclCgoTrsmHdrVO scgHdrVO) throws EventException {
		try {
			return dbDao.searchDtlLogSequence	(scgHdrVO);
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} 
	}
	
	/**
	 * Transmit Date 를  조회합니다.
	 * 
	 * @param ScgPrnrSpclCgoTrsmHdrVO scgHdrVO
	 * @return String
	 * @exception EventException
	 */
	private String searchTrsmDate() throws EventException {
		try {
			return dbDao.searchTrsmDate();
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} 
	}
	
	
	/**
	 * Transmit Date 를  조회합니다.
	 * 
	 * @param ScgPrnrSpclCgoTrsmHdrVO scgHdrVO
	 * @return String
	 * @exception EventException
	 */
	private String searchGmtTrsmDate() throws EventException {
		try {
			return dbDao.searchGmtTrsmDate();
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} 
	}
	
	
	
	
	/**
	 * error code SCG_PRNR_SPCL_CGO_TRSM_ERR
	 * 
	 * @param ScgPrnrSpclCgoTrsmHdrVO scgHdrVO, int sErrorCode
	 * @return ArrayList<String>
	 * @throws EventException
	 */
	private ScgPrnrSpclCgoTrsmErrVO setTrsmErr(ScgPrnrSpclCgoTrsmHdrVO scgHdrVO, int sErrorCode) throws Exception {
		
		ScgPrnrSpclCgoTrsmErrVO 			scgCntrTrsmErrVO = new ScgPrnrSpclCgoTrsmErrVO();
		scgCntrTrsmErrVO.setTrsmBndCd      	(scgHdrVO.getTrsmBndCd		());			
		scgCntrTrsmErrVO.setTrsmDt         	(scgHdrVO.getTrsmDt			());
		scgCntrTrsmErrVO.setSpclCgoCateCd  	(scgHdrVO.getSpclCgoCateCd	());
		scgCntrTrsmErrVO.setPrnrSpclCgoSeq 	(scgHdrVO.getPrnrSpclCgoSeq	());
		
		String[] msg = getErrMessage		(sErrorCode).split(":");
		scgCntrTrsmErrVO.setErrKndCd		(msg[0]);
		scgCntrTrsmErrVO.setErrDtlCd		(String.valueOf(sErrorCode));
		scgCntrTrsmErrVO.setErrDtlRmk		(msg[1]);
		scgCntrTrsmErrVO.setApErrCd			(msg[2]);	
		scgCntrTrsmErrVO.setErrLvl			(msg[3]);
		scgCntrTrsmErrVO.setCreUsrId		(USER_ID);
		scgCntrTrsmErrVO.setUpdUsrId		(USER_ID);
		
		return scgCntrTrsmErrVO;
	}
	
	/**
	 * error code SCG_PRNR_SPCL_CGO_TRSM_ERR
	 * 
	 * @param ScgPrnrSpclCgoTrsmHdrVO scgHdrVO, int sErrorCode
	 * @return ArrayList<String>
	 * @throws EventException
	 */
	private ScgPrnrSpclCgoDtlErrVO setDtlErr(ScgPrnrSpclCgoDtlLogVO scgPrnrSpclCgoDtlLogVO, int sErrorCode) throws Exception {
		
		ScgPrnrSpclCgoDtlErrVO scgCntrDtlErrVO = new ScgPrnrSpclCgoDtlErrVO();
		
		scgCntrDtlErrVO.setTrsmBndCd        (scgPrnrSpclCgoDtlLogVO.getTrsmBndCd());			
		scgCntrDtlErrVO.setTrsmDt           (scgPrnrSpclCgoDtlLogVO.getTrsmDt());
		scgCntrDtlErrVO.setSpclCgoCateCd    (scgPrnrSpclCgoDtlLogVO.getSpclCgoCateCd());
		scgCntrDtlErrVO.setPrnrSpclCgoSeq   (scgPrnrSpclCgoDtlLogVO.getPrnrSpclCgoSeq());			
		scgCntrDtlErrVO.setPrnrSpclCgoSubSeq(scgPrnrSpclCgoDtlLogVO.getPrnrSpclCgoSubSeq());
		
		String[] msg = this.getErrMessage(sErrorCode).split(":");
		scgCntrDtlErrVO.setErrKndCd			(msg[0]);
		scgCntrDtlErrVO.setErrDtlCd			(String.valueOf(sErrorCode));
		scgCntrDtlErrVO.setErrDtlRmk		(msg[1]);
		scgCntrDtlErrVO.setApErrCd			(msg[2]);
		scgCntrDtlErrVO.setErrLvl			(msg[3]);
		scgCntrDtlErrVO.setCreUsrId			(USER_ID);
		scgCntrDtlErrVO.setUpdUsrId			(USER_ID);
		
		return scgCntrDtlErrVO;
	}
	
	
	/**
	 * SCG_PRNR_TRSM_HDR_UNMAP
	 * 
	 * @param ScgPrnrSpclCgoTrsmHdrVO scgHdrVO, String sUnmapCode
	 * @return ScgPrnrTrsmHdrUnmapVO
	 * @throws EventException
	 */
	private ScgPrnrTrsmHdrUnmapVO setTrsmHdrUnmap(ScgPrnrSpclCgoTrsmHdrVO scgHdrVO, String sUnmapCode) throws Exception {
		
		ScgPrnrTrsmHdrUnmapVO tmpVO = new ScgPrnrTrsmHdrUnmapVO();
		
		tmpVO.setTrsmBndCd        	(scgHdrVO.getTrsmBndCd		());			
		tmpVO.setTrsmDt           	(scgHdrVO.getTrsmDt			());
		tmpVO.setSpclCgoCateCd    	(scgHdrVO.getSpclCgoCateCd	());
		tmpVO.setPrnrSpclCgoSeq		(scgHdrVO.getPrnrSpclCgoSeq	());			
		
		tmpVO.setEdiUnmapDtlCd		(sUnmapCode);
		
		/** 
		 *	"011" : "Cannot find proper RSO" 
		 *  "012" : "Not exist corresponding POL in VVD"	
		 *  "013" : "Not exist corresponding POD in VVD"	
		 *  "021" : "Cannot find proper calling indicator in POL"	
		 *  "022" : "Cannot find proper calling indicator in POD"	
		 **/
		String 	sUnmapDtlDesc	= null;
		int		iUnmapCode		= sUnmapCode == null || "".equals(sUnmapCode) ? 0 : Integer.parseInt(sUnmapCode);
		
		switch(iUnmapCode){
		case 11:
			sUnmapDtlDesc	= "Cannot find proper RSO";
			break;
			
		case 12:
			sUnmapDtlDesc	= "Not exist corresponding POL in VVD";
			break;
			
		case 13:
			sUnmapDtlDesc	= "Not exist corresponding POD in VVD";
			break;
			
		case 21:
			sUnmapDtlDesc	= "Cannot find proper calling indicator in POL";
			break;
			
		case 22:
			sUnmapDtlDesc	= "Cannot find proper calling indicator in POD";
			break;
		
		}
		tmpVO.setEdiUnmapDtlDesc	(sUnmapDtlDesc);
		
		tmpVO.setCreUsrId			(USER_ID);
		tmpVO.setUpdUsrId			(USER_ID);
		
		return tmpVO;
	}
	

	/**
	 * SCG_PRNR_CNTR_LOG_UNMAP
	 * 
	 * @param ScgPrnrSpclCgoCntrLogVO scgcntrLogVO, String sUnmapCode
	 * @return ScgPrnrCgoDtlLogUnmapVO
	 * @throws EventException
	 */
	private ScgPrnrCntrLogUnmapVO setTrsmCntrLogUnmap(ScgPrnrSpclCgoCntrLogVO scgcntrLogVO, String sUnmapCode) throws Exception {
		
		ScgPrnrCntrLogUnmapVO tmpVO = new ScgPrnrCntrLogUnmapVO();
		
		tmpVO.setTrsmBndCd        	(scgcntrLogVO.getTrsmBndCd		());			
		tmpVO.setTrsmDt           	(scgcntrLogVO.getTrsmDt			());
		tmpVO.setSpclCgoCateCd    	(scgcntrLogVO.getSpclCgoCateCd	());
		tmpVO.setPrnrSpclCgoSeq		(scgcntrLogVO.getPrnrSpclCgoSeq	());	
		tmpVO.setCntrSeq			(scgcntrLogVO.getCntrSeq		());
		
		tmpVO.setCntrRefNo			(scgcntrLogVO.getCntrRefNo		());
		
		tmpVO.setEdiUnmapDtlCd		(sUnmapCode);
		
		/** 
		 *	"101" : "Unmapped container type/size with conversion table"
		 *  ----------------------------------------------------------------
		 *  "201" : "Cannot find proper UN No SEQ." 	
		 *  "202" : "No technical name in DG Application."	
		 **/
		String 	sUnmapDtlDesc	= null;
		int		iUnmapCode		= sUnmapCode == null || "".equals(sUnmapCode) ? 0 : Integer.parseInt(sUnmapCode);
		
		switch(iUnmapCode){
		case 101:
			sUnmapDtlDesc	= "Unmapped container type/size with conversion table";
			break;
		
		}
		tmpVO.setEdiUnmapDtlDesc	(sUnmapDtlDesc);
		
		tmpVO.setCreUsrId			(USER_ID);
		tmpVO.setUpdUsrId			(USER_ID);
		
		return tmpVO;
	}
	
	/**
	 * SCG_PRNR_CGO_DTL_LOG_UNMAP
	 * 
	 * @param ScgPrnrSpclCgoDtlLogVO scgPrnrSpclCgoDtlLogVO, String sUnmapCode
	 * @return ScgPrnrCgoDtlLogUnmapVO
	 * @throws EventException
	 */
	private ScgPrnrCgoDtlLogUnmapVO setTrsmCgoDtlLogUnmap(ScgPrnrSpclCgoDtlLogVO scgPrnrSpclCgoDtlLogVO, String sUnmapCode) throws Exception {
		
		ScgPrnrCgoDtlLogUnmapVO tmpVO = new ScgPrnrCgoDtlLogUnmapVO();
		
		tmpVO.setTrsmBndCd        	(scgPrnrSpclCgoDtlLogVO.getTrsmBndCd		());			
		tmpVO.setTrsmDt           	(scgPrnrSpclCgoDtlLogVO.getTrsmDt			());
		tmpVO.setSpclCgoCateCd    	(scgPrnrSpclCgoDtlLogVO.getSpclCgoCateCd	());
		tmpVO.setPrnrSpclCgoSeq		(scgPrnrSpclCgoDtlLogVO.getPrnrSpclCgoSeq	());	
		tmpVO.setPrnrSpclCgoSubSeq	(scgPrnrSpclCgoDtlLogVO.getPrnrSpclCgoSubSeq());
		
		tmpVO.setEdiUnmapDtlCd		(sUnmapCode);
		
		tmpVO.setEdiItmSeq			(scgPrnrSpclCgoDtlLogVO.getEdiItmSeq		());
		
		/** 
		 *	"101" : "Unmapped container type/size with conversion table"
		 *  ----------------------------------------------------------------
		 *  "201" : "Cannot find proper UN No SEQ." 
		 *  "202" : "No technical name in DG Application."		
		 **/
		String 	sUnmapDtlDesc	= null;
		int		iUnmapCode		= sUnmapCode == null || "".equals(sUnmapCode) ? 0 : Integer.parseInt(sUnmapCode);
		
		switch(iUnmapCode){
		case 201:
			sUnmapDtlDesc	= "Cannot find proper UN No SEQ.";
			break;
		case 202:
			sUnmapDtlDesc	= "No technical name in DG Application.";
			break;			
		
		}
		tmpVO.setEdiUnmapDtlDesc	(sUnmapDtlDesc);
		
		tmpVO.setCreUsrId			(USER_ID);
		tmpVO.setUpdUsrId			(USER_ID);
		
		return tmpVO;
	}
	
	
	private boolean isNumeric(String s) {
		if (s == null) return false;	    
	    return s.matches("^[-+]?\\d+(\\.\\d+)?$");
	}
	
	private void scgPrnrSpclCgoTrsmAckSend(ScgPrnrSpclCgoTrsmHdrVO scgHdrVO, boolean errFlag, String sErrorCode) throws Exception {
		
		ScgPrnrSpclCgoTrsmAckVO ackVO = new ScgPrnrSpclCgoTrsmAckVO();
		
		//EDI HEADER
		String header        	= "$$$MSGSTART:";
		String sndrId        	= JSPUtil.getRPAD(scgHdrVO.getEdiRcvrId(), 20, " ");	    // SNDR_ID 20
		
		/** Receiver ID Rule *************************************************************************
		 * 	HLC	: Multiple
		 * 		  - HLCAS, HLCUS, HLCEU
		 * 	HMM	: Single
		 * 	OOL	: Single
		 *********************************************************************************************/
		String	sTmpRcvrId		= scgHdrVO.getEdiSndrId		() == null?"":scgHdrVO.getEdiSndrId		();
		String	sRSO			= scgHdrVO.getRgnShpOprCd	() == null?"":scgHdrVO.getRgnShpOprCd	();
		
		if("HLC".equals(sTmpRcvrId)){
			if("ASR".equals(sRSO)){
				sTmpRcvrId	= "HLCAS";
			}else if("AMR".equals(sRSO)){
				sTmpRcvrId	= "HLCUS";
			}else if("EUR".equals(sRSO)){
				sTmpRcvrId	= "HLCEU";
			}
		}
		
		String rcvrId        	= JSPUtil.getRPAD(sTmpRcvrId, 20, " ");		// RCVR_ID 20
		String ediMsgTp      	= JSPUtil.getRPAD("APERAK", 10, " ");		            	// EDI_MSG_TP_ID 10
		
		//::2015-09-14:by TOP:://
		String sNewEdiHdrRefNo 	= ReferenceNumberGeneratorBroker.getKey("SCG","SCG_PRNR_SPCL_CGO_EDI_SEQ");		// FLAT_FILE_REFERENCE_NO 15
		String sEdiMsgRefNo		= scgHdrVO.getEdiMsgRefNo();
         
		String[] err 			= sErrorCode.split(":");
		ackVO.setTrsmBndCd		(TRSM_OUT_BND_CD);
		ackVO.setTrsmDt			(scgHdrVO.getTrsmDt());
		ackVO.setSpclCgoCateCd	(scgHdrVO.getSpclCgoCateCd());
		ackVO.setPrnrSpclCgoSeq	(scgHdrVO.getPrnrSpclCgoSeq());
		ackVO.setEdiMsgId		(ediMsgTp);
		ackVO.setEdiSndrId		(sndrId);
		ackVO.setEdiRcvrId		(rcvrId);
		ackVO.setEdiIfId		(scgHdrVO.getEdiIfId());
		ackVO.setTrsmStsCd		((errFlag==true) ? "F" : "S");
		
		//2016-09-22
		ackVO.setMsgAckRsltCd   ((errFlag==true) ?  "R" : "A");
		
		
		ackVO.setEdiHdrMsg		(header + sndrId + rcvrId + ediMsgTp + sNewEdiHdrRefNo);
		ackVO.setOrgMsgRcvrNm	(scgHdrVO.getEdiRcvrId());
		
		//:2015-09-16:by TOP://ackVO.setOrgMsgKeyNo	(scgHdrVO.getCtrlRefNo());
		ackVO.setOrgMsgKeyNo	(sEdiMsgRefNo);
				
		//:2016-09-21
		String orgMsgRcvDt   = 	dbDao.searchOrgMsgReceiveDate(scgHdrVO);
	    ackVO.setOrgMsgRcvDt(orgMsgRcvDt);

		ackVO.setOrgMsgTpCd		("IFTMBF");
		ackVO.setMsgUpdFlg		(scgHdrVO.getEdiMsgStsCd());
		ackVO.setOrgMsgNm		("IFTMBF");
		ackVO.setMsgAckTpCd		("S");
		
		String ackLoclDt 		= searchTrsmDate();
		String ackGmtDt         = searchGmtTrsmDate();
		ackVO.setMsgAckGdt		(ackGmtDt);
		ackVO.setMsgAckLoclDt	(ackLoclDt);
		//ackVO.setMsgAckGdt		(ackLoclDt);
		

		
		ackVO.setErrDtlCd		((err.length == 4) ? err[0] : "" );
		ackVO.setMsgRjctCd		((err.length == 4) ? err[1] : "" );
		ackVO.setMsgRjctRsn		((err.length == 4) ? err[2] : "" );
		ackVO.setMsgAcptRefNo	("");
		ackVO.setCreUsrId		(USER_ID);
		ackVO.setUpdUsrId		(USER_ID);
		
		//::2016-10-28 Original 없이 Cancel EDI 오는 경우, APERAK은 AP로 내보낸다.
		//::2016-11-03 RollBack
		/**
		String MsgUpdFlg = scgHdrVO.getEdiMsgStsCd();
		String ErrDtlCd = ((err.length == 4) ? err[0] : "" );
		String MsgRjctCd = ((err.length == 4) ? err[1] : "" );
		//String MsgRjctRsn = ((err.length == 4) ? err[2] : "" );
		//log.debug("TW TEST APERAK =================== " +ErrDtlCd + "====== " + MsgRjctCd);
	    if("R".equals(MsgUpdFlg) &&  "13007".equals(ErrDtlCd) ){
		   ackVO.setMsgAckRsltCd("A");
		   ackVO.setMsgRjctRsn("");
		}
		else{
			ackVO.setMsgAckRsltCd   ((errFlag==true) ?  "R" : "A");
			ackVO.setMsgRjctRsn		((err.length == 4) ? err[2] : "" );
		}
		**/
		//::2016-10-28
		//::2016-11-03 RollBack
		
		String ediFlatFile 		= makeFlatFile(ackVO);
		/***********************************************************
		 * flatfile log생성 
		 ***********************************************************/
		addScgPrnrSpclCgoFltFileLog(TRSM_OUT_BND_CD, G_PRNR_SPCL_CGO_SEQ, scgHdrVO.getBkgRefNo(), ediFlatFile, "APERAK FlatFile Log");
		/***********************************************************
		 * EDI 전송 START
		 ***********************************************************/
		SendFlatFileVO 	sendFlatFileVO 	= new SendFlatFileVO();
		ScgUtilEai 		utilCommand 	= new ScgUtilEai();
		
		sendFlatFileVO.setFlatFile		(ediFlatFile);
		sendFlatFileVO.setTarget		(SubSystemConfigFactory.get("SCG.SCG_EDI_DGRQST.IBMMQ.URL"));		
		sendFlatFileVO.setTransferType	(SubSystemConfigFactory.get("SCG.SCG_EDI_DGRQST.IBMMQ.TRANSFERTYPE"));		
		sendFlatFileVO.setChannel		(SubSystemConfigFactory.get("SCG.SCG_EDI_DGRQST.IBMMQ.CHANNEL"));		
		sendFlatFileVO.setFactory		(SubSystemConfigFactory.get("SCG.SCG_EDI_DGRQST.IBMMQ.FACTORY"));		
		sendFlatFileVO.setQueueNm		(SubSystemConfigFactory.get("SCG.SCG_EDI_DGRQST.IBMMQ.QUEUE"));
		sendFlatFileVO.setTargetClient	(SubSystemConfigFactory.get("SCG.SCG_EDI_DGRQST.IBMMQ.TARGETCLIENT"));
		FlatFileAckVO flatFileAckVO 	= utilCommand.sendFlatFile(sendFlatFileVO);
		
		
		/****************** MESSAGE ACKKNOWLEDGE RESULT CODE ***********************/
		//2016-09-22
		//ackVO.setMsgAckRsltCd(("F".equals(flatFileAckVO.getAckStsCd())) ? "R" : "A");
		/***************************************************************************/
				
		if ("F".equals(flatFileAckVO.getAckStsCd())) {
			throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
		} else {
			dbDao.addScgPrnrSpclCgoTrsmAck(ackVO);
		}
	}
	
	private String makeFlatFile(ScgPrnrSpclCgoTrsmAckVO ackVO)  throws Exception {
		// flatFile
		StringBuilder flatFile = new StringBuilder();
		
		flatFile.append(ackVO.getEdiHdrMsg()).append("\n");
		flatFile.append("ORG_MSG_RCV:")		.append(ackVO.getEdiRcvrId		()==null?"":ackVO.getEdiRcvrId		()).append("\n");	   	//Original Msg Receiver
		flatFile.append("ORG_MSG_KEY:")		.append(ackVO.getOrgMsgKeyNo	()==null?"":ackVO.getOrgMsgKeyNo	()).append("\n");   	//Original Msg's key value
		flatFile.append("ORG_MSG_TP:")		.append(ackVO.getOrgMsgTpCd		()==null?"":ackVO.getOrgMsgTpCd		()).append("\n");    	//Original Msg Type
		
		//:2016-09-21
		flatFile.append("ORG_MSG_DT:")		.append(ackVO.getOrgMsgRcvDt		()==null?"":ackVO.getOrgMsgRcvDt		()).append("\n");    	//Original Msg Type
		//:2016-09-21
			
		flatFile.append("MSG_UDT_FLG:")		.append(ackVO.getMsgUpdFlg		()==null?"":ackVO.getMsgUpdFlg		()).append("\n");     	//Msg UDT Flag
		flatFile.append("ORG_MSG_NM:")		.append("IFTMBF").append("\n");	               												//Original Msg Name
		flatFile.append("MSG_ACK_TP:")		.append("S").append("\n");	                   												//Msg Ack Type
		
		flatFile.append("MSG_ACK_RSLT:")	.append(ackVO.getMsgAckRsltCd	()==null?"":ackVO.getMsgAckRsltCd	()).append("\n"); 		//Msg Ack Result
		
		flatFile.append("MSG_ACK_LDT:")		.append(ackVO.getMsgAckLoclDt	()==null?"":ackVO.getMsgAckLoclDt	()).append("\n");  		//Msg Ack Local Date
		flatFile.append("MSG_ACK_GDT:")		.append(ackVO.getMsgAckGdt		()==null?"":ackVO.getMsgAckGdt		()).append("\n");	   	//Msg Ack GMT Date
		flatFile.append("MSG_R_CD:")		.append(ackVO.getMsgRjctCd		()==null?"":ackVO.getMsgRjctCd		()).append("\n");	    //Msg Error Code
		flatFile.append("MSG_R_REASON:")	.append(ackVO.getMsgRjctRsn		()==null?"":ackVO.getMsgRjctRsn		()).append("\n");   	//Msg Reject Reason
		flatFile.append("MSG_ACCEPT_REF:")	.append("").append("\n");	                   												//Msg Ref Number
		
		return flatFile.toString();
	}
	
	private String getErrMessage(int sErrorCode) {
		
		String errMsg  = "";
		String errType = "";
		String apErrCd = "";
		String errLvl  = "";
		
		switch(sErrorCode) {
			case 12003 : errMsg  = "NUMBER OF OUTER PACKAGE REQUIRED."; 
			             errType = "R";
			             apErrCd = "153";
			             errLvl  = "41";
			break;       // OUTER 패키지 번호가 필요합니다
			case 12004 : errMsg  = "TYPE OF OUTER PACKAGE REQUIRED.";
						 errType = "R";
						 apErrCd = "228";
						 errLvl  = "42";
			break;		    // OUTER 유형의 패키지가 필요합니다
			case 12005 : errMsg  = "GROSS WEIGHT REQUIRED."; 
						 errType = "R";
						 apErrCd = "230";
						 errLvl  = "31";
			break;		            // 총중량 필수
			case 12006 : errMsg  = "NET POWDER WEIGHT REQUIRED FOR CLASS 1."; 
						 errType = "R";
						 apErrCd = "232";
						 errLvl  = "32";
			break;		
			case 12007 : errMsg  = "CARRIER IDENTIFIER IS NOT SMDG CARRIER CODE."; 
						 errType = "R";
						 apErrCd = "130";
						 errLvl  = "12";
			break;		
			case 13003 : errMsg  = "VESSEL DOES NOT EXIST."; 
						 errType = "R";
						 apErrCd = "340";
						 errLvl  = "11";
			break;		
			case 13005 : errMsg  = "IMDG CODE UNMATCH."; 
						 errType = "R";
						 apErrCd = "221";
						 errLvl  = "13";
			break;
			case 13006 : errMsg  = "BOOKING ALREADY RECEIVED WENT SENT AS ORIGINAL."; 
						 errType = "R";
						 apErrCd = "116";
						 errLvl  = "1";
			break;
			case 13007 : errMsg  = "BOOKING NOT RECEIVED WENT SEND AS ORIGINAL."; 
						 errType = "R";
						 apErrCd = "999";
						 errLvl  = "2";
			break;
			case 13008 : errMsg  = "UPDATE RECEIVED BUT LATER UPDATE ALREADY APPLIED.";
						 errType = "R";
						 apErrCd = "118";
						 errLvl  = "3";
			break;
			
			//case 13009 : errMsg  = "CHEMICAL NAME REQUIRED."; 
			//			 errType = "R";
			//			 apErrCd = "225";
			//			 errLvl  = "14";
			//break;
			
			case 13011 : errMsg  = "BOOKING ALREADY RECEIVED FROM BOOKING SYSTEM BY MANUALLY. "; 
						 errType = "R";
						 apErrCd = "999";
						 errLvl  = "4";
			 break;
			case 13013 : errMsg  = "V/V/L OF BOOKING IS DIFFERENT FROM ORIGINAL. "; 
						 errType = "R";
						 apErrCd = "999";
						 errLvl  = "5";
			 break;
			 
			 
			case 50001 : errMsg  = "NOT EXIST POL IN CORRESPONDING VVD."; 
			 			 errType = "R";
			 			 apErrCd = "999";
			 			 //:2015-08-29://apErrCd = "50001";
			 			 errLvl  = "91";
			 break;
			case 50002 : errMsg  = "NOT EXIST POD IN CORRESPONDING VVD."; 
			 			 errType = "R";
			 			 apErrCd = "999";
			 			 //:2015-08-29://apErrCd = "50002";
			 			 errLvl  = "92";
			 break;
			case 50003 : errMsg  = "ETC ERROR (RSO).";
			 			 errType = "R";
			 			 apErrCd = "999";
			 			 //:2015-08-29://apErrCd = "50003";
			 			 errLvl  = "93";
			 break;
			case 50004 : errMsg  = "ETC ERROR (CNTR ERROR).";
						 errType = "R";
						 apErrCd = "999";
			 			 //:2015-08-29://apErrCd = "50004";
						 errLvl  = "94";
			break;
			
			/** Additional Error Code for appended validation by TOP **/
			case 90001 : errMsg  = "Cannot find Proper UN No SEQ(PSN, Packing Group)";
			 			 errType = "R"	;		/** for REJECTION		**/
			 			 apErrCd = "999";
			 			 //:2015-08-29://apErrCd = "90001";		/**	REJECTION CODE		**/
			 			 errLvl  = "99";		/** Error Code Sequence	**/
			 break;

			case 90011 : errMsg  = "Cannot find Proper Calling Indicator(1st or 2nd) of POL";
			 			 errType = "R"	;		/** for REJECTION		**/
			 			 apErrCd = "999";
			 			 //:2015-08-29://apErrCd = "90001";		/**	REJECTION CODE		**/
			 			 errLvl  = "99";		/** Error Code Sequence	**/
			 break;
				 
			case 90012 : errMsg  = "Cannot find Proper Calling Indicator(1st or 2nd) of POD";
			 			 errType = "R"	;		/** for REJECTION		**/
			 			 apErrCd = "999";
			 			 //:2015-08-29://apErrCd = "90001";		/**	REJECTION CODE		**/
			 			 errLvl  = "99";		/** Error Code Sequence	**/
			 			 
			case 99001 : errMsg  = "Mismatch Container Number between CNTR & CGO EDI SEGMENT";
			 			 errType = "R"	;		/** for REJECTION		**/
			 			 apErrCd = "999";
			 			 errLvl  = "99";		/** Error Code Sequence	**/
			 
			 break;
				 
				 
		}
		return errType + ":" + errMsg + ":" + apErrCd + ":" + errLvl;
	}
	
	private void addScgPrnrSpclCgoFltFile(String trsmBndCd,String prnrSpclCgoSeq, String bkgRefNo, String flatFile, String msg) {
		
		try {
			ScgUtilEai 				utilCommand = new ScgUtilEai();
			DgEdiFltFileVO 			excVO = new DgEdiFltFileVO();
			excVO.setTrsmBndCd		(trsmBndCd		);
			excVO.setPrnrSpclCgoSeq	(prnrSpclCgoSeq	);
			excVO.setBkgRefNo		(bkgRefNo		);
			excVO.setFltFileDatCtnt	(flatFile		);
			excVO.setExptMsg		(msg			);
			excVO.setCreUsrId		(USER_ID		);
			excVO.setUpdUsrId		(USER_ID		);
		
			utilCommand.addScgPrnrSpclCgoFltFile(excVO);	/** SCG_PRNR_SPCL_CGO_FLT_FILE **/
			
		} catch (EventException e) {
			log.error(msg);
		}
	}
	
	/*
	 * FLATFILE 별도 LOG
	 */
	private void addScgPrnrSpclCgoFltFileLog(String trsmBndCd, String prnrSpclCgoSeq, String bkgRefNo, String flatFile, String msg) {
		
		try {
		
			ScgUtilEai utilCommand 	= new ScgUtilEai();
			DgEdiFltFileVO excVO 	= new DgEdiFltFileVO();
			
			excVO.setTrsmBndCd		(trsmBndCd);			
			//:2015-09-09://excVO.setPrnrSpclCgoSeq	(String.valueOf(searchHdrSequence()));
			excVO.setPrnrSpclCgoSeq	(prnrSpclCgoSeq);
			
			excVO.setBkgRefNo		(bkgRefNo);
			excVO.setFltFileDatCtnt	(flatFile);
			excVO.setExptMsg		(msg);
			excVO.setCreUsrId		(USER_ID);
			excVO.setUpdUsrId		(USER_ID);
		
			utilCommand.addScgPrnrSpclCgoFltFile(excVO);	/** SCG_PRNR_SPCL_CGO_FLT_FILE **/
			
		} catch (EventException e) {
			log.error(msg);
		}
	}
	
	/**
	 * UN No SEQ & EMS 정보를 조회합니다.
	 * 
	 * @param ScgPrnrSpclCgoDtlLogVO tmpVO
	 * @return ScgPrnrSpclCgoDtlLogVO
	 * @exception EventException
	 */
	private ScgPrnrSpclCgoDtlLogVO identifyProperUNInfofromDGEDI(ScgPrnrSpclCgoDtlLogVO tmpVO) throws EventException {
		
		List<ScgPrnrSpclCgoDtlLogVO>	list	= null;
		ScgPrnrSpclCgoDtlLogVO			rtnVO	= null;
		
		try {
			
			list	= dbDao.identifyProperUNInfofromDGEDI(tmpVO);
			
			if(list != null && list.size() == 1){
				rtnVO	= list.get(0);
			}
			
			
//			else if(list == null || list.size() == 0){
//				//
//			}else if(list.size() > 1){
//				//
//			}
			
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} 
		
		return	rtnVO;
	}
	
	
	
	private void manageCancelDGEDIfromPartnerLines(String ediFlatFile, ScgPrnrSpclCgoTrsmHdrVO scgHdrVO, List<ScgPrnrSpclCgoTrsmErrVO> scgTrsmErrVOs) throws EventException {
		
		try {
			
			String	sErrorCode				= "";
			boolean	isErrorExist			= false;
			
			if(scgHdrVO == null)			return;
			
			this.addScgPrnrSpclCgoFltFileLog	(TRSM_IN_BND_CD, scgHdrVO.getPrnrSpclCgoSeq(), scgHdrVO.getBkgRefNo(), ediFlatFile, "IFTMBF FlatFile Log");

			// SCG PARTNER SPECIAL CARGO TRANSMIT HEADER INSERT			
			dbDao.addScgPrnrSpclCgoTrsmHdr		(scgHdrVO);							/** << TABLE NAME : SCG_PRNR_SPCL_CGO_TRSM_HDR >> */
			
			if (scgTrsmErrVOs != null && scgTrsmErrVOs.size() > 0) {
				
				for (ScgPrnrSpclCgoTrsmErrVO VOs : scgTrsmErrVOs) {
					dbDao.addScgPrnrSpclCgoTrsmErr(VOs);							/** << TABLE NAME : SCG_PRNR_SPCL_CGO_TRSM_ERR >> */
				}
				
				scgHdrVO.setLstTrsmStsCd		("F");
				scgHdrVO.setErrKndCd			("R");
				scgHdrVO.setUpdUsrId			(USER_ID);
				
				dbDao.modifyErrTrsmHdr			(scgHdrVO);
				
				int 	minVal 					= 100;
				
				for (ScgPrnrSpclCgoTrsmErrVO vo : scgTrsmErrVOs) {							
					if (Integer.parseInt(vo.getErrLvl()) < minVal) {
						sErrorCode = vo.getErrDtlCd() + ":" +vo.getApErrCd() + ":" + vo.getErrDtlRmk() + ":" + vo.getErrLvl();								
					}
					minVal = Integer.parseInt(vo.getErrLvl());
				}
				isErrorExist  = true;
				
			}else{
				
				scgHdrVO.setLstTrsmStsCd		("S");
				scgHdrVO.setErrKndCd			("O");
				scgHdrVO.setUpdUsrId			(USER_ID);
				
				dbDao.modifyErrTrsmHdr			(scgHdrVO);
				
				/** UPDATE SCG_PRNR_APRO_RQST + SCG_PRNR_APRO_RQST_CGO **/
				dbDao.updatePrnrAproRqstforDGCancellation	(scgHdrVO);	/** SCG_PRNR_APRO_RQST 		: ReceiveEdiFromParnterLinesMgtDBDAOUpdatePrnrAproRqstforDGCancellationUSQL 	**/
				dbDao.updatePrnrAproRqstCgoforDGCancellation(scgHdrVO);	/** SCG_PRNR_APRO_RQST_CGO 	: ReceiveEdiFromParnterLinesMgtDBDAOUpdatePrnrAproRqstCgoforDGCancellationUSQL 	**/
				
			}
			
			/** Sending Acknowledge for IFTMBF(I/B) ***********************/ 
			this.scgPrnrSpclCgoTrsmAckSend							(scgHdrVO, isErrorExist, sErrorCode);	/** << TABLE NAME : SCG_PRNR_SPCL_CGO_TRSM_ACK >> */
			
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} 
	}
	
	
	/**
	 * Saving and Checking MQ Full Message<br>
	 * Saving EDI Message from terminal to DB[VSK_ACT_PORT_SKD_EDI_LOG]
	 * 
	 * @param String ediFlatFile
	 * @exception EventException
	 */
	public void manageAckDGEDIfromPartnerLines(String ediFlatFile) {
		
		ScgPrnrSpclCgoTrsmAckVO ackVO = new ScgPrnrSpclCgoTrsmAckVO();
		String bkgNo  = "";
		try {
			
			//Split MQ Message up \n and drop new line
			ArrayList<String> flatFileList = flatFileConvertList(ediFlatFile);
			
			String header        	= flatFileList.get(0).toString();  
			String sndrId        	= header.substring(12,31).trim();		// SNDR_ID
			String rcvrId        	= header.substring(32,51).trim();		// RCVR_ID
			String ediMsgTp      	= header.substring(52,61).trim();		// EDI_MSG_TP_ID
			String flatFileRefNo 	= header.substring(62).trim();			// FLAT_FILE_REFERENCE_NO
			
			String trsmDate 		= searchTrsmDate().substring(0,8);
			int fiatSize 			= flatFileList.size();
			
			ackVO.setTrsmBndCd		(TRSM_IN_BND_CD);
			ackVO.setTrsmDt			(trsmDate);
			ackVO.setSpclCgoCateCd	(CATE_CD);
			
			ackVO.setEdiMsgId		(ediMsgTp);
			ackVO.setEdiSndrId		(sndrId);
			ackVO.setEdiRcvrId		(rcvrId);
			ackVO.setEdiIfId		(flatFileRefNo);
			ackVO.setTrsmStsCd		("S");
			ackVO.setEdiHdrMsg		(header);
			
			ackVO.setCreUsrId		(USER_ID);
			ackVO.setUpdUsrId		(USER_ID);
			
			for (int ffRow = 0; ffRow < fiatSize ; ffRow++ ) {
				
				String[] flatKeyArr = flatFileList.get(ffRow).toString().trim().split(":",2);
				
				String flatKey = flatKeyArr[0];
				
				if ("ORG_MSG_RCV".equals(flatKey)) {
					String[] orgMsgRcvArr = flatFileList.get(ffRow).toString().trim().split(":",2);
					ackVO.setOrgMsgRcvrNm(VSKGeneralUtil.getCheckNullToString(orgMsgRcvArr[1]));                    //ORG_MSG_RCV					
				} else if ("ORG_MSG_KEY".equals(flatKey)) {
					String[] orgMsgKeyArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
					ackVO.setOrgMsgKeyNo(VSKGeneralUtil.getCheckNullToString(orgMsgKeyArr[1]));                      //ORG_MSG_KEY
					
					Map<String, String> hdrKeyMap = new HashMap<String, String>();
					hdrKeyMap.put("org_msg_key"   , VSKGeneralUtil.getCheckNullToString(orgMsgKeyArr[1]));
					
					Map<String, String> rtnCntrKeyMap = dbDao.searchTrsmHdrKey(hdrKeyMap);
					
					if (rtnCntrKeyMap.get("prnr_spcl_cgo_seq") == null || "".equals(rtnCntrKeyMap.get("prnr_spcl_cgo_seq"))) {						
						throw new EventException("CTRL NOT FOUND.");
					}
					
					ackVO.setPrnrSpclCgoSeq(rtnCntrKeyMap.get("prnr_spcl_cgo_seq"));
					bkgNo = rtnCntrKeyMap.get("bkg_ref_no");
				} else if ("ORG_MSG_TP".equals(flatKey)) {
					String[] orgMsgTpArr = flatFileList.get(ffRow).toString().trim().split(":",2);
					ackVO.setOrgMsgTpCd(VSKGeneralUtil.getCheckNullToString(orgMsgTpArr[1]));                //ORG_MSG_TP     
				} else if ("MSG_UDT_FLG".equals(flatKey)) {
					String[] msgUpdFlgArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
					ackVO.setMsgUpdFlg(VSKGeneralUtil.getCheckNullToString(msgUpdFlgArr[1]));                //MSG_UDT_FLG       
				} else if ("ORG_MSG_NM".equals(flatKey)) {               
					String[] orgMsgNmArr = flatFileList.get(ffRow).toString().trim().split(":", 2);               
					ackVO.setOrgMsgNm(VSKGeneralUtil.getCheckNullToString(orgMsgNmArr[1]));                  //ORG_MSG_NM					
				} else if ("MSG_ACK_TP".equals(flatKey)) {               
					String[] msgAckTpArr = flatFileList.get(ffRow).toString().trim().split(":", 2);               
					ackVO.setMsgAckTpCd(VSKGeneralUtil.getCheckNullToString(msgAckTpArr[1]));                //MSG_ACK_TP
				} else if ("MSG_ACK_RSLT".equals(flatKey)) {               
					String[] msgAckRsltArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
					ackVO.setMsgAckRsltCd(VSKGeneralUtil.getCheckNullToString(msgAckRsltArr[1]));            //MSG_ACK_GDT
				} else if ("MSG_ACK_LDT".equals(flatKey)) {               
					String[] msgAckLdtArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
					ackVO.setMsgAckLoclDt(VSKGeneralUtil.getCheckNullToString(msgAckLdtArr[1]));             //MSG_ACK_GDT 
				} else if ("MSG_ACK_GDT".equals(flatKey)) {               
					String[] msgAckGdtArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
					ackVO.setMsgAckGdt(VSKGeneralUtil.getCheckNullToString(msgAckGdtArr[1]));                //MSG_ACK_GDT   
				} else if ("MSG_R_CD".equals(flatKey)) {               
					String[] msgRCdArr = flatFileList.get(ffRow).toString().trim().split(":",2);
					ackVO.setMsgRjctCd(VSKGeneralUtil.getCheckNullToString(msgRCdArr[1]));                   //MSG_R_CD 
				} else if ("MSG_R_REASON".equals(flatKey)) {               
					String[] msgRReasonArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
					ackVO.setMsgRjctRsn(VSKGeneralUtil.getCheckNullToString(msgRReasonArr[1]));              //MSG_R_REASON       
				}  else if ("MSG_ACCEPT_REF".equals(flatKey)) {               
					String[] msgAcceptRefArr = flatFileList.get(ffRow).toString().trim().split(":",2);               
					ackVO.setMsgAcptRefNo(VSKGeneralUtil.getCheckNullToString(msgAcceptRefArr[1]));          //MSG_ACCEPT_REF       
				}
			}
			
			dbDao.addScgPrnrSpclCgoTrsmAck(ackVO);
			/*
			 * flatfile log 생성
			 */
			addScgPrnrSpclCgoFltFileLog(TRSM_IN_BND_CD, ackVO.getPrnrSpclCgoSeq(), bkgNo, ediFlatFile, "APERAK FlatFile Log");
			
		} catch (Exception ex) {
			String seqHdrNum = "";
			try {
				seqHdrNum = String.valueOf(searchHdrSequence());
				
			} catch (EventException e) {
				log.error(e.getMessage(),e);
			}
			log.error(ex.getMessage(),ex);
			addScgPrnrSpclCgoFltFile(TRSM_IN_BND_CD, seqHdrNum, bkgNo, ediFlatFile, ex.getMessage());
		}
	}
	
}
