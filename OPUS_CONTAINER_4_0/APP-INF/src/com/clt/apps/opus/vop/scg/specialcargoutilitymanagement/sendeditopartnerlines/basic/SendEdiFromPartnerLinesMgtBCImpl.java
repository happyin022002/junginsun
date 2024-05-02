/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : SendEdiFromPartnerLinesMgtBCImpl.java
 *@FileTitle : SendEdiFromPartnerLinesMgtBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.12.19
 *@LastModifier : dongsoo
 *@LastVersion : 1.0
 * 2014.12.19 dongsoo 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.sendeditopartnerlines.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SendDgEdiRequestVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SendDgEmailRequestVO;
import com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.basic.IMDGCodeMgtBC;
import com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.basic.IMDGCodeMgtBCImpl;
import com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.UNNumberListOptionVO;
import com.clt.apps.opus.vop.scg.scgcommon.scgutileai.basic.ScgUtilEai;
import com.clt.apps.opus.vop.scg.scgcommon.scgutileai.vo.DgEdiFltFileVO;
import com.clt.apps.opus.vop.scg.scgcommon.scgutileai.vo.FlatFileAckVO;
import com.clt.apps.opus.vop.scg.scgcommon.scgutileai.vo.SendDgEdiHeaderInfoVO;
import com.clt.apps.opus.vop.scg.scgcommon.scgutileai.vo.SendFlatFileVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.common.ScgUtil;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.integration.ReceiveEdiFromParnterLinesMgtDBDAO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.vo.ScgPrnrSpclCgoCntrLogVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.vo.ScgPrnrSpclCgoDtlLogVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.vo.ScgPrnrSpclCgoTrsmHdrVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.sendeditopartnerlines.integration.SendEdiFromParnterLinesMgtDBDAO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.sendeditopartnerlines.vo.SendEdiFromBkgDtlVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.sendeditopartnerlines.vo.SendEdiFromBkgHdrVO;
import com.clt.bizcommon.edi.broker.ReferenceNumberGeneratorBroker;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MdmVslCntrVO;

/**
 * Send Edi From PartnerLines Mgt Basic Command implementation<br>
 * 
 * @author 
 * @see 
 * @since J2EE 1.6
 */
public class SendEdiFromPartnerLinesMgtBCImpl extends BasicCommandSupport implements SendEdiFromPartnerLinesMgtBC{
	// Database Access Object
	private transient 	SendEdiFromParnterLinesMgtDBDAO		dbDao   			= null;
	// Database Access Object
	private transient 	ReceiveEdiFromParnterLinesMgtDBDAO	dbDao1  			= null;
	private final 		String 								G_SPCL_CATE_CD_DG	= "DG";
	//private final 	String 								G_SPCL_CATE_CD_EM	= "EM";
	private final 		String							 	G_TRSM_BND_CD 		= "O";
	private 			String 								USER_ID     		= "";
	
	ScgPrnrSpclCgoTrsmHdrVO scgHdrVO = new ScgPrnrSpclCgoTrsmHdrVO();
	
	/**
	 * ReceiveEdiFromPartnerLinesMgtBCImpl object creation<br>
	 * ReceiveEdiFromParnterLinesMgtDBDAO creation<br>
	 */
	public SendEdiFromPartnerLinesMgtBCImpl() {
		dbDao   = new SendEdiFromParnterLinesMgtDBDAO();
		dbDao1  = new ReceiveEdiFromParnterLinesMgtDBDAO();
	}
	
	/**
	 * FlatFile
	 * 
	 * @param SendDgEdiRequestVO sendDgEdiRequestVO
	 * @param SignOnUserAccount account
	 * @return boolean
	 * @throws DAOException 
	 */
	public boolean sendDgApvlOwnBkgEdi(SendDgEdiRequestVO sendDgEdiRequestVO, SignOnUserAccount account) {
		
		String sbMergeFlatFile = "";
		
		try{
			
			ScgUtilEai utilCommand = new ScgUtilEai();
			
			USER_ID = account.getUsr_id() == null||"".equals(account.getUsr_id()) ? "NO_ACCOUNT" : account.getUsr_id();
			
			/***********************************************************************************
			 * Send Cancellation EDI to Partner Lines
			 * =================================================================================
			 * Code definition for DG Cancel Request
			 * --------------------------------------------------------------------------------- 
			 * 'SR'	: O/B EDI Success and Request  Cancellation EDI
			 * 'SX'	: O/B EDI Success and Complete Cancellation EDI
			 * ---------------------------------------------------------------------------------
			 */
			
			/*
			 * R인 대상은 화면에서 DG CANCEL
			 */			
			//:: 'R' - Cancel EDI Target Only for EDI Cancellation :://
			if ("EDI_MNL_CXL".equals(sendDgEdiRequestVO.getEdiStatus())) {	
				
				/** Making Flat File and Insert Transmit Header Table **/
				sbMergeFlatFile = this.manageFlatFileEDICancel(sendDgEdiRequestVO);
				this.modifyScgPrnrAproRqst	("SR", account.getOfc_cd(), null); 	// SEND SUCCESS > EDI CANCEL REQUEST
				
			}else if ("EDI_AUTO_CXL".equals(sendDgEdiRequestVO.getEdiStatus())) {	
					
				/** Making Flat File and Insert Transmit Header Table **/
				sbMergeFlatFile = this.manageFlatFileEDICancel(sendDgEdiRequestVO);
				this.modifyScgPrnrAproRqst	("SR", account.getOfc_cd(), null); 	// SEND SUCCESS > EDI CANCEL REQUEST
				
			//:: 'Y' - EDI Target for VVD Change Only :://
				//::2016-04-06:by TOP://} else if ("Y".equals(sendDgEdiRequestVO.getEdiDelStsCd()) && "N".equals(sendDgEdiRequestVO.getEdiMsgStsCd())) {
				
				//::2016-04-06:by TOP://sbMergeFlatFile = this.manageFlatFileEDICancel(sendDgEdiRequestVO);
				//::2016-04-06:by TOP://modifyScgPrnrAproRqst		("SR", account.getOfc_cd()); // SEND SUCCESS > EDI CANCEL REQUEST
				
				//::2016-04-06:by TOP://sbMergeFlatFile = this.manageFlatFileEDINormal(sendDgEdiRequestVO, "VVD_CHANGE");
				//::2016-04-06:by TOP://modifyScgPrnrAproRqst		("R", account.getOfc_cd()); // REQUEST
			
			//:: Initial EDI :://
			} else {
				
				sbMergeFlatFile = this.manageFlatFileEDINormal(sendDgEdiRequestVO, "NORMAL");
				modifyScgPrnrAproRqst		("R", account.getOfc_cd(), null); // REQUEST
				
			}
			
			//::2015-03-27:TOP:://modifyScgPrnrAproRqst("SR", account.getOfc_cd()); // SEND SUCCESS > EDI CANCEL REQUEST			
			FlatFileAckVO flatFileAckVO 	= utilCommand.sendFlatFile(this.setSendFlatFile(sbMergeFlatFile));
			
			//APERAK 전송
			//scgPrnrSpclCgoTrsmAckSend(scgHdrVO, flatFileAckVO.getAckStsCd(), "");
			//본테이블 상태 수정 
			
			if ("EDI_MNL_CXL".equals(sendDgEdiRequestVO.getEdiStatus()) || "EDI_AUTO_CXL".equals(sendDgEdiRequestVO.getEdiStatus())) {
				this.modifyScgPrnrAproRqst("SX", account.getOfc_cd(), sendDgEdiRequestVO.getEdiStatus()); 	//SX : SEND SUCCESS > EDI CANCEL SUCCESS 
			} else {
				this.modifyScgPrnrAproRqst(flatFileAckVO.getAckStsCd(), account.getOfc_cd(), null); 		//S : SEND SUCCESS
			}
			
			this.addScgPrnrSpclCgoFltFile(sbMergeFlatFile, "Own BKG O/B DG EDI");
			
			return true;
			
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			this.addScgPrnrSpclCgoFltFile(sbMergeFlatFile, "[[ Exeption occured during logging O/B DG EDI history ]]   "+ex.getMessage());
			return false;
		}
	}
	
	/**
	 * FlatFile	 * 
	 * @param SendDgEdiRequestVO sendDgEdiRequestVO
	 * @return String
	 * @throws DAOException 
	 */
	private String manageFlatFileEDINormal(SendDgEdiRequestVO sendDgEdiRequestVO, String sFlatFileRefNoKind) throws Exception {
		
		IMDGCodeMgtBC 					IMDGcmd 			= new IMDGCodeMgtBCImpl();
		
		List<ScgPrnrSpclCgoCntrLogVO>   scgcntrLogVOs 		= new ArrayList<ScgPrnrSpclCgoCntrLogVO>();
		List<ScgPrnrSpclCgoDtlLogVO>  	scgCntrDtlLogVOs 	= new ArrayList<ScgPrnrSpclCgoDtlLogVO>();
		List<SendDgEdiHeaderInfoVO> 	dgEdiHeaderInfoVOs 	= null; 
		ScgPrnrSpclCgoCntrLogVO         scgcntrLogVO 		= null;
		
		String							sEDIMsgStsCd		= null;
		
		// sbMergeFlatFile
		StringBuilder 					sbMergeFlatFile 	= new StringBuilder();
		StringBuilder 					sbCntrFlatFile 		= new StringBuilder();
		StringBuilder  					sbDGCargoFlatFile 	= new StringBuilder();
		
		Map<String, String> mapVO 		= new HashMap<String, String>();
		
		mapVO.put("bkg_no"    			, sendDgEdiRequestVO.getBkgNo		());
		mapVO.put("crr_cd"    			, sendDgEdiRequestVO.getCrrCd		());
		mapVO.put("loc_cd"    			, sendDgEdiRequestVO.getPolCd		());
		mapVO.put("slan_cd"   			, sendDgEdiRequestVO.getSlanCd		());
		mapVO.put("vsl_cd"    			, sendDgEdiRequestVO.getVslCd		());
		mapVO.put("skd_voy_no"			, sendDgEdiRequestVO.getSkdVoyNo	());
		mapVO.put("skd_dir_cd"			, sendDgEdiRequestVO.getSkdDirCd	());
		
		/**********************************************************************
		 * Adding Variables for Selecting Proper DG Approval Information
		 * --------------------------------------------------------------------
		 * 2015-05-18 by TOP
		 */
		mapVO.put("vsl_pre_pst_cd"		, sendDgEdiRequestVO.getVslPrePstCd	());
		mapVO.put("vsl_seq"				, sendDgEdiRequestVO.getVslSeq		());
		/**********************************************************************/
		
		ScgUtilEai utilCommand 			= new ScgUtilEai();
		dgEdiHeaderInfoVOs     			= utilCommand.searchSendEdiHeader(mapVO);
		//EDI HEADER
		String header          			= dgEdiHeaderInfoVOs.get(0).getHeader		();
		String sndrId          			= dgEdiHeaderInfoVOs.get(0).getSenderId		();	    // SNDR_ID 20
		String rcvrId          			= dgEdiHeaderInfoVOs.get(0).getReceiverId	();	    // RCVR_ID 20
		String ediMsgTp        			= dgEdiHeaderInfoVOs.get(0).getMessageType	();		// EDI_MSG_TP_ID 10
		
		/** ======================================================================================================
		 *  Change to select new FLAT FILE REFERENCE NUMBER in case of UPDATING for Own DG Application
		 *  2015-09-10 :: by TOP
		 *  ======================================================================================================
		 */
		//String tmpEdiMsgStsCd			= sendDgEdiRequestVO.getEdiMsgStsCd();
		String flatFileRefNo			= null;
		
		//		if(tmpEdiMsgStsCd != null && !"N".equals(tmpEdiMsgStsCd)){
		//			/** searSendEdiFromParnterLinesMgtDBDAOSelectOriginalFlatFileReferenceNORSQL **/
		//			flatFileRefNo   			= dbDao.selectOriginalFlatFileReferenceNO(sendDgEdiRequestVO);					// FLAT_FILE_REFERENCE_NO 15
		//		}else{
		//			flatFileRefNo   			= ReferenceNumberGeneratorBroker.getKey("SCG","SCG_PRNR_SPCL_CGO_EDI_SEQ"); 	// FLAT_FILE_REFERENCE_NO 15
		//		}
		
		/** searSendEdiFromParnterLinesMgtDBDAOSelectOriginalFlatFileReferenceNORSQL **/
		sendDgEdiRequestVO.setEdiRcvrId	(rcvrId);
		
		
		//:2016-03-10:Commented by TOP://
//		if("VVD_CHANGE".equals(sFlatFileRefNoKind)){
//			flatFileRefNo   			= ReferenceNumberGeneratorBroker.getKey("SCG","SCG_PRNR_SPCL_CGO_EDI_SEQ"); 	// FLAT_FILE_REFERENCE_NO 15
//		}else{
//
//			flatFileRefNo   			= dbDao.selectOriginalFlatFileReferenceNO(sendDgEdiRequestVO);						// FLAT_FILE_REFERENCE_NO 15
//			
//			if(flatFileRefNo == null || "".equals(flatFileRefNo))	
//				flatFileRefNo   		= ReferenceNumberGeneratorBroker.getKey("SCG","SCG_PRNR_SPCL_CGO_EDI_SEQ"); 	// FLAT_FILE_REFERENCE_NO 15
//			
//		}
		//:2016-03-10:Commented by TOP://
		
		
		flatFileRefNo   				= ReferenceNumberGeneratorBroker.getKey("SCG","SCG_PRNR_SPCL_CGO_EDI_SEQ"); 	// FLAT_FILE_REFERENCE_NO 15
		/** ====================================================================================================== */
		
		String ediHederMsg     			= header + sndrId + rcvrId + ediMsgTp + flatFileRefNo;
		
		
		List<SendEdiFromBkgHdrVO> hdrVO = dbDao.searchBkgHdr(mapVO);
		
		sbMergeFlatFile.append(ediHederMsg).append("\n");
		sbMergeFlatFile.append("BKGNBR:").append(sendDgEdiRequestVO.getBkgNo()).append("\n");
		sbMergeFlatFile.append("BKG_DT:").append(hdrVO.get(0).getBkgDt()).append("\n");
		
		sbMergeFlatFile.append("BRAC:").append(sendDgEdiRequestVO.getEdiMsgStsCd()).append("\n");
		sbMergeFlatFile.append("REFNBR:").append(flatFileRefNo).append("\n");
		
		sbMergeFlatFile.append("CTRLREFNBR:").append("").append("\n");
		
		sbMergeFlatFile.append("VSL_CALLSIGN:").append(hdrVO.get(0).getCallSgnNo()).append("\n");
		sbMergeFlatFile.append("VSL_LLOYDCODE:").append(hdrVO.get(0).getLloydNo()).append("\n");
		sbMergeFlatFile.append("VSL_FULLNAME:").append(hdrVO.get(0).getVslEngNm()).append("\n");
		sbMergeFlatFile.append("VVD_REF_NO:").append("").append("\n");
		
		sbMergeFlatFile.append("CONSORT_VOY:").append(hdrVO.get(0).getObCssmVoyNo()).append("\n");
		
		sbMergeFlatFile.append("POL_CD:").append(hdrVO.get(0).getPolCd()).append("\n");
		sbMergeFlatFile.append("POL_NM:").append(hdrVO.get(0).getPolNm()).append("\n");
		sbMergeFlatFile.append("POD_CD:").append(hdrVO.get(0).getPodCd()).append("\n");
		sbMergeFlatFile.append("POD_NM:").append(hdrVO.get(0).getPodNm()).append("\n");
		sbMergeFlatFile.append("PLD_CD:").append(hdrVO.get(0).getDelCd()).append("\n");
		sbMergeFlatFile.append("PLD_NM:").append(hdrVO.get(0).getDelNm()).append("\n");
		
		
		/** Making Object for Inserting Normal(New+Update) EDI Transmit Header Information **/
		String spclSeq  				= String.valueOf(dbDao1.searchHdrSequence());
		String trsmDate 				= dbDao1.searchTrsmDate().substring(0, 8);
		
		scgHdrVO.setTrsmBndCd			(G_TRSM_BND_CD);              	// TRANSMIT BOUND CODE V2
		scgHdrVO.setTrsmDt				(trsmDate);                    	// TRANSMIT DATE  DB SYSDATE
		scgHdrVO.setSpclCgoCateCd		(G_SPCL_CATE_CD_DG);              		// SPECIAL CARGO CATEGORY CODE V2
		scgHdrVO.setPrnrSpclCgoSeq		(spclSeq);             			// PARTNER SPECIAL CARGO SEQUENCE (ORACLE SEQUENCE)
		scgHdrVO.setTrsmMzdCd			("EDI");                    	// TRANSMIT METHOD CODE V3
		scgHdrVO.setFltFileRefNo		(flatFileRefNo);         		// FLAT FILE REFERENCE NUMBER V20
		
		scgHdrVO.setEdiHdrMsg			(ediHederMsg);
		scgHdrVO.setEdiIfId				(flatFileRefNo);
		scgHdrVO.setEdiMsgId			(ediMsgTp);
		
		scgHdrVO.setCgoOprCd			(sndrId.substring(0, 3));
		
		scgHdrVO.setEdiRcvrId			(rcvrId);
		scgHdrVO.setEdiSndrId			(sndrId);
		scgHdrVO.setCreUsrId			(USER_ID);
		scgHdrVO.setUpdUsrId			(USER_ID);
		scgHdrVO.setEmlSndNo			("");                                       		// E-MAIL SEND NO
		
		scgHdrVO.setBkgRefNo			(sendDgEdiRequestVO.getBkgNo());            		//BKGNBR
		scgHdrVO.setBkgCreLoclDt		(hdrVO.get(0).getBkgDt());
		scgHdrVO.setBkgCreLoclDtCtnt	(hdrVO.get(0).getBkgDt());	
		
		/***********************************************************************************/
		sEDIMsgStsCd					= sendDgEdiRequestVO.getEdiMsgStsCd()==null||"".equals(sendDgEdiRequestVO.getEdiMsgStsCd())?"X":sendDgEdiRequestVO.getEdiMsgStsCd();
		//::2015-05-20:://scgHdrVO.setEdiMsgStsCd(sendDgEdiRequestVO.getEdiMsgStsCd());   	//BRAC	// N(New), R(Cancel), U(Update)
		//::2015-06-09:://scgHdrVO.setEdiMsgStsCd(sendDgEdiRequestVO.getEdiStatus());		//BRAC	// N(New), R(Cancel), U(Update)
		scgHdrVO.setEdiMsgStsCd			(sEDIMsgStsCd);
		/***********************************************************************************/
		
		scgHdrVO.setEdiMsgRefNo			(flatFileRefNo);                         
		scgHdrVO.setCtrlRefNo			("");                                      			//CTRLREFNBR		
		scgHdrVO.setCallSgnNo			(hdrVO.get(0).getCallSgnNo());             			//VSL_CALLSIGN
		scgHdrVO.setLloydNo				(hdrVO.get(0).getLloydNo());                 		//VSL_LLOYDCODE 
		scgHdrVO.setVslEngFullNm		(hdrVO.get(0).getVslEngNm());           			//VSL_FULLNAME 
		scgHdrVO.setOutBndCssmVoyNo		(hdrVO.get(0).getObCssmVoyNo());     				//CONSORT_VOY 
		scgHdrVO.setPorCd				("");                                          		//POR_CD 
		scgHdrVO.setPorNm				("");                                          		//POR_NM
		scgHdrVO.setPolCd				(hdrVO.get(0).getPolCd());                     		//POL_CD
	    scgHdrVO.setPolYdCd				(hdrVO.get(0).getPolNodCd());                		//POL_YD_CD
	    
	    scgHdrVO.setPolClptIndSeq		(hdrVO.get(0).getPolClptIndSeq());
	    scgHdrVO.setPodClptIndSeq		(hdrVO.get(0).getPodClptIndSeq());
	    
	    scgHdrVO.setPolNm				(hdrVO.get(0).getPolNm());                     		//POL_NM 
	    scgHdrVO.setPodCd				(hdrVO.get(0).getPodCd());                     		//POD_CD 
		scgHdrVO.setPodYdCd				(hdrVO.get(0).getPodNodCd());                		//POD_YD_CD 
		scgHdrVO.setPodNm				(hdrVO.get(0).getPodNm());                     		//POD_NM 
		 
		scgHdrVO.setDelCd				(hdrVO.get(0).getDelCd());                     		//DEL_CD
		scgHdrVO.setDelNm				(hdrVO.get(0).getDelNm());                     		//PLD_NM
		
		scgHdrVO.setRgnShpOprCd			(sendDgEdiRequestVO.getRgnShpOprCd());   			//RGN_SHP_OPR_CD
		scgHdrVO.setSlanCd				(hdrVO.get(0).getSlanCd());                   		//SLAND_CD
		scgHdrVO.setVslCd				(hdrVO.get(0).getVslCd());                     		//VSL_CD
		scgHdrVO.setSkdVoyNo			(hdrVO.get(0).getSkdVoyNo());               		//SKD_VOY_NO
		scgHdrVO.setSkdDirCd			(hdrVO.get(0).getSkdDirCd());               		//SKD_DIR_CD
		scgHdrVO.setMapgCrrCd			(sendDgEdiRequestVO.getCrrCd());
		scgHdrVO.setMapgBkgRefNo		(sendDgEdiRequestVO.getBkgNo());
		scgHdrVO.setMapgSpclCgoRqstSeq	(sendDgEdiRequestVO.getSpclCgoRqstSeq());		
		scgHdrVO.setSpclCgoAproRqstSeq	(sendDgEdiRequestVO.getSpclCgoAproRqstSeq());
		scgHdrVO.setVslPrePstCd			(sendDgEdiRequestVO.getVslPrePstCd());
		scgHdrVO.setVslSeq				(sendDgEdiRequestVO.getVslSeq());
		
		scgHdrVO.setErrKndCd			("O");
		/**************************************************************************/
		
		
		List<SendEdiFromBkgDtlVO> dtlVO 			= dbDao.searchBkgDtl		(mapVO);
		
		//07-31//String 	dgCntrSeq    		= "";
		String 	sDmyCntrNbr 			= "";
		String	sTmpDmyCntrNbr			= "";
		
		int		iItemSeq				= 0;
		
		//int		iTtlCntrKnt			= Integer.parseInt(dtlVO.get(0).getTtlCntrKnt()==null||"".equals(dtlVO.get(0).getTtlCntrKnt())?"0":dtlVO.get(0).getTtlCntrKnt());
		boolean	isEQSegGenerateTarget	= false;
		String	sDGCntrSeq				= "";
		
		for (SendEdiFromBkgDtlVO list : dtlVO) {
			
			iItemSeq++;
			
			//07-31//if (!dgCntrSeq.equals(list.getDgCntrSeq())) {
				
			/**================================================================ 
			 * Making CONTAINER SEGMENT STARTING...
			 * ----------------------------------------------------------------
			 */
			String	sTmpDGCntrSeq		= list.getDgCntrSeq		();
			String 	sTmpCntrCgoSeq		= list.getCntrCgoSeq	();
			
			String	sTmpCntrDmyRefNo	= list.getCntrDmyRefNo	();
			
			if(sDGCntrSeq == null || "".equals(sDGCntrSeq) || !sDGCntrSeq.equals(sTmpDGCntrSeq) ){
				isEQSegGenerateTarget	= true;
			}else{
				isEQSegGenerateTarget	= false;
			}
			
			sDGCntrSeq					= sTmpDGCntrSeq;
			
			
			//:2016-03-31:by TOP://if(sTmpCntrCgoSeq != null && "1".equals(sTmpCntrCgoSeq)){
			if(isEQSegGenerateTarget){	
				
				sbCntrFlatFile.append("{CNTR_INFO").append("\n");
				sbCntrFlatFile.append("CNTR_SEQ:").append(sTmpDGCntrSeq).append("\n");
				
				if(sTmpCntrDmyRefNo == null || "".equals(sTmpCntrDmyRefNo)){
					sDmyCntrNbr = (list.getCntrNo() == null || "".equals(list.getCntrNo())) ? dbDao.searchCntrSequence() : list.getCntrNo();	
				}else{
					sDmyCntrNbr	= sTmpCntrDmyRefNo;
				}
				
				sbCntrFlatFile.append("CNTR_NO:").append(sDmyCntrNbr).append("\n");
				sbCntrFlatFile.append("CNTR_TPSZ:").append(list.getCntrTpszCd()).append("\n");
				sbCntrFlatFile.append("}CNTR_INFO").append("\n");
				
				sTmpDmyCntrNbr	= sDmyCntrNbr;
			}
			/**---------------------------------------------------------------- 
			 * Making CONTAINER SEGMENT FINISHED...
			 * ================================================================
			 */

			
			//07-31//dgCntrSeq = list.getDgCntrSeq();
			
			//SCG_PRNR_SPCL_CGO_CNTR_LOG					
			scgcntrLogVO 					= new ScgPrnrSpclCgoCntrLogVO();
			scgcntrLogVO.setTrsmBndCd		(G_TRSM_BND_CD);
			scgcntrLogVO.setTrsmDt			(trsmDate);
			scgcntrLogVO.setSpclCgoCateCd	(G_SPCL_CATE_CD_DG);
			scgcntrLogVO.setPrnrSpclCgoSeq	(spclSeq);
			scgcntrLogVO.setCreUsrId		(USER_ID);
			scgcntrLogVO.setUpdUsrId		(USER_ID);
			scgcntrLogVO.setCntrSeq			(list.getDgCntrSeq	());		//CNTR_SEQ 
			scgcntrLogVO.setCntrRefNo		(sDmyCntrNbr);					//CNTR_NO      
			scgcntrLogVO.setCntrTpszCdCtnt	(list.getCntrTpszCd	());		//CNTR_TPSZ
			
			scgcntrLogVOs.add				(scgcntrLogVO);
				
			//07-31//}
			
			/**================================================================ 
			 * Making DG CARGO SEGMENT STARTING...
			 * ----------------------------------------------------------------
			 */
				
			sbDGCargoFlatFile.append("{CNTR_DG").append("\n");			
			sbDGCargoFlatFile.append("ITEM_SEQ:").append(String.valueOf(iItemSeq)).append("\n");
			
			//"VVD별 UNIQUE NO로서 신규/수정/삭제 CGO  구분목적 - BKG NO + '-' + BKG/SCG_DG_SEQ.DCGO_SEQ"
			//::2015-05-24:by TOP:://String dgRef = list.getBkgNo() + "-" + JSPUtil.getLPAD(list.getDcgoSeq(), 3, "0");
			//::2015-05-24:by TOP:://sbDGCargoFlatFile.append("DG_REF:").append(dgRef).append("\n");
			sbDGCargoFlatFile.append("DG_REF:").append(list.getDcgoRefNo()).append("\n");
			////////////////////////////////////////////////////////////////////////////////
			
			sbDGCargoFlatFile.append("MV_TP:3").append("\n");
			//NUMBER OF OUTER PACKAGES
			sbDGCargoFlatFile.append("OPKG_QTY:").append(list.getOutImdgPckQty1()).append("\n");
			//OUTER  PACKAGES TYPE CODE
			sbDGCargoFlatFile.append("OPKG_TP:").append(list.getOutImdgPckCd1()).append("\n");
			//OUTER  PACKAGES DESCRIPTION
			sbDGCargoFlatFile.append("OPKG_DESC:").append(list.getOutImdgPckDesc1()).append("\n");
			//NUMBER OF MIDDLE PACKAGES
			sbDGCargoFlatFile.append("MPKG_QTY:").append(list.getIntmdImdgPckQty1()).append("\n");
			//MIDDLE PACKAGES TYPE CODE
			sbDGCargoFlatFile.append("MPKG_TP:").append(list.getIntmdImdgPckCd1()).append("\n");
			//MIDDLE PACKAGES DESCRIPTION
			sbDGCargoFlatFile.append("MPKG_DESC:").append(list.getIntmdImdgPckDesc1()).append("\n");
			//NUMBER OF INNER PACKAGES
			sbDGCargoFlatFile.append("IPKG_QTY:").append(list.getInImdgPckQty1()).append("\n");
			//INNER PACKAGES TYPE CODE
			sbDGCargoFlatFile.append("IPKG_TP:").append(list.getInImdgPckCd1()).append("\n");
			//INNER PACKAGES DESCRIPTION
			sbDGCargoFlatFile.append("IPKG_DESC:").append(list.getInImdgPckDesc1()).append("\n");			
			sbDGCargoFlatFile.append("HAZ_CONT:").append("").append("\n");
			sbDGCargoFlatFile.append("PROP_SHIP_NM:").append(list.getPrpShpNm()).append("\n");
			sbDGCargoFlatFile.append("TECH_NM:").append(list.getHzdDesc()).append("\n");	
			
			/**===========================================================================
			 * Adding element 'IMDG AMENDMENT NUMBER'
			 * 2015-07-30 by TOP
			 * ---------------------------------------------------------------------------
			 */
			sbDGCargoFlatFile.append("IMO_AMDT_NO:").append(list.getImdgAmdtNo()).append("\n");		
			/*****************************************************************************/
			
			sbDGCargoFlatFile.append("IMO_CLASS:").append(list.getImdgClssCd()).append("\n");	
			
			/** SUBSIDIARY RISK(S)	**/
			UNNumberListOptionVO unNumberListOptionVO	= new UNNumberListOptionVO	();
			unNumberListOptionVO.setImdgUnNo			(list.getImdgUnNo	());
			unNumberListOptionVO.setImdgUnNoSeq			(list.getImdgUnNoSeq());
			String[] 					subRskLblList 	= IMDGcmd.searchSubsRskLblList(unNumberListOptionVO);
			
			String	sSubRisks							= ScgUtil.addUserSpChar(subRskLblList, "/");
			
			sbDGCargoFlatFile.append("SUB_RISKS:").append(sSubRisks).append("\n");
			
			sbDGCargoFlatFile.append("IMO_PAGE:").append("").append("\n");				
			sbDGCargoFlatFile.append("UN_NBR:").append(list.getImdgUnNo()).append("\n");
			sbDGCargoFlatFile.append("UN_NBR_SEQ:").append(list.getImdgUnNoSeq()).append("\n");
			
			if ("Y".equals(list.getCfrFlg())) {
				sbDGCargoFlatFile.append("CFR_NBR:").append(list.getImdgUnNo()).append("\n");
			} else {
				sbDGCargoFlatFile.append("CFR_NBR:").append("").append("\n");
			}
			
			sbDGCargoFlatFile.append("FLASH:").append(list.getFlshPntCdoTemp()).append("\n");
			
			if (list.getFlshPntCdoTemp() == null || "".equals(list.getFlshPntCdoTemp())) {
				sbDGCargoFlatFile.append("FLASH_UNIT:").append("\n");
			} else {
				sbDGCargoFlatFile.append("FLASH_UNIT:CEL").append("\n");
			}
			sbDGCargoFlatFile.append("PKG_GROUP:").append(list.getImdgPckGrpCd()).append("\n");
			
			sbDGCargoFlatFile.append("CTRL_TEMP:").append(list.getCtrlTempCtnt()).append("\n");
			
			sbDGCargoFlatFile.append("EMS_NBR:").append(list.getEmsNo()).append("\n");	
			
			//SEGMENT 순서 맞게 재 배치 
			sbDGCargoFlatFile.append("MFAG:").append("").append("\n");
			
			//:temporary setting:by TOP:2016-05-02://
			//sbDGCargoFlatFile.append("ESPN:").append(list.getEmsNo()).append("\n");	
			sbDGCargoFlatFile.append("ESPN:").append("\n");
			//:temporary setting:by TOP:2016-05-02://
			
			/********************************************************************
			 * ::Adding 2015-10-22::
			 * CGO_STS			e.g. L(Liquid), P(Paste), G(Gas), S(Solid)
			 * SEG_GRP			e.g. Acids
			 * SEG_GRPS_NBR	e.g. 1 (1~18)
			 * ::Adding 2015-10-22::
			 ********************************************************************/
			sbDGCargoFlatFile.append("CGO_STS:").append(list.getDcgoStsCd()).append("\n");
			sbDGCargoFlatFile.append("SEG_GRP:").append(list.getImdgSegrGrpNm()).append("\n");
			
			String sTmpImdgN1stSegrGrpNo	= list.getImdgN1stSegrGrpNo();
			String sTmpImdgN2ndSegrGrpNo	= list.getImdgN2ndSegrGrpNo();
			String sTmpImdgN3rdSegrGrpNo	= list.getImdgN3rdSegrGrpNo();
			String sTmpImdgN4thSegrGrpNo	= list.getImdgN4thSegrGrpNo();
			
			String sTmpDelimeter			= " ";
			StringBuffer sbImdgSegrGrpNo	= new  StringBuffer("");
			
			if(sTmpImdgN1stSegrGrpNo != null && !"".equals(sTmpImdgN1stSegrGrpNo))		sbImdgSegrGrpNo.append(sTmpImdgN1stSegrGrpNo);
			if(sTmpImdgN2ndSegrGrpNo != null && !"".equals(sTmpImdgN2ndSegrGrpNo))		sbImdgSegrGrpNo.append(sTmpDelimeter).append(sTmpImdgN2ndSegrGrpNo);
			if(sTmpImdgN3rdSegrGrpNo != null && !"".equals(sTmpImdgN3rdSegrGrpNo))		sbImdgSegrGrpNo.append(sTmpDelimeter).append(sTmpImdgN3rdSegrGrpNo);
			if(sTmpImdgN4thSegrGrpNo != null && !"".equals(sTmpImdgN4thSegrGrpNo))		sbImdgSegrGrpNo.append(sTmpDelimeter).append(sTmpImdgN4thSegrGrpNo);
			
			list.setImdgSegrGrpNos(sbImdgSegrGrpNo.toString());
			sbDGCargoFlatFile.append("SEG_GRPS_NBR:").append(sbImdgSegrGrpNo.toString()).append("\n");
			
			//:2016-04-27://sbDGCargoFlatFile.append("POLLUTANT:").append(("Y".equals(list.getMrnPolutFlg()) ? "P" : "")).append("\n");
			sbDGCargoFlatFile.append("POLLUTANT:").append(("Y".equals(list.getMrnPolutFlg()) ? "P" : "NP")).append("\n");
			
			sbDGCargoFlatFile.append("IMO_LIMIT:").append(list.getImdgLmtQtyFlg()).append("\n");								
			
			if (Double.parseDouble(list.getGrsWgt()) <= 0) {
				sbDGCargoFlatFile.append("GROSWGT:").append("").append("\n");
				sbDGCargoFlatFile.append("GROSSWGT_UNIT:").append("\n");
			} else {
				sbDGCargoFlatFile.append("GROSWGT:").append(list.getGrsWgt()).append("\n");
				sbDGCargoFlatFile.append("GROSSWGT_UNIT:").append(list.getWgtUtCd()).append("\n");
			}
			
			if (Double.parseDouble(list.getNetWgt()) <= 0) {
				sbDGCargoFlatFile.append("NETWGT:").append("").append("\n");
				sbDGCargoFlatFile.append("NETWGT_UNIT:").append("\n");
			} else {
				sbDGCargoFlatFile.append("NETWGT:").append(list.getNetWgt()).append("\n");
				sbDGCargoFlatFile.append("NETWGT_UNIT:").append(list.getWgtUtCd()).append("\n");
			}
			
			if (Double.parseDouble(list.getNetExploWgt()) <= 0) {
				sbDGCargoFlatFile.append("NETPWDRWGT:").append("").append("\n");
				sbDGCargoFlatFile.append("NETPWDRWGT_UNIT:").append("\n");
			} else {
				sbDGCargoFlatFile.append("NETPWDRWGT:").append(list.getNetExploWgt()).append("\n");
				sbDGCargoFlatFile.append("NETPWDRWGT_UNIT:").append(list.getWgtUtCd()).append("\n");
			}
						
			sbDGCargoFlatFile.append("VOL:").append("").append("\n");
			sbDGCargoFlatFile.append("VOL_UNIT:").append("").append("\n");
			
			//:2015-07-31:by TOP://sbDGCargoFlatFile.append("CNTRNBR:").append(sDmyCntrNbr).append("\n");		
			
			/**===========================================================================
			 * Adding segment '{DG_CNTR_INFO --- }DG_CNTR_INFO'
			 * {DG_CNTR_INFO
				DG_CNTRNBR
				}DG_CNTR_INFO
			 * 2015-07-30 by TOP
			 * ---------------------------------------------------------------------------
			 */
			sbDGCargoFlatFile.append("{DG_CNTR_INFO").append("\n");
			
			/** ====== Replace to Container Dummy Number ====== **/
			if(sTmpCntrCgoSeq == null && !"1".equals(sTmpCntrCgoSeq)){
				sDmyCntrNbr	= sTmpDmyCntrNbr;
			}
			/** =============================================== **/
			
			sbDGCargoFlatFile.append("DG_CNTRNBR:").append(sDmyCntrNbr).append("\n");
			sbDGCargoFlatFile.append("}DG_CNTR_INFO").append("\n");
			/*****************************************************************************/
			
			sbDGCargoFlatFile.append("RESIDUE:").append(list.getRsdFlg()).append("\n");
			sbDGCargoFlatFile.append("CONTACT:").append(list.getEmerCntcPsonNm()).append("\n");
			sbDGCargoFlatFile.append("PHONE:").append(list.getEmerCntcPhnNoCtnt()).append("\n");				
			sbDGCargoFlatFile.append("{REMARK").append("").append("\n");
			sbDGCargoFlatFile.append("REMARK:").append(list.getDiffRmk()).append("\n");
			sbDGCargoFlatFile.append("}REMARK").append("").append("\n");
			
			sbDGCargoFlatFile.append("}CNTR_DG").append("\n");
			
			/**---------------------------------------------------------------- 
			 * Making DG CARGO SEGMENT FINISHED...
			 * ================================================================
			 */
			

			//log
			//::2015-05-24:by TOP:://scgCntrDtlLogVOs.add(setScgCntrDtlLog(list, trsmDate, spclSeq, dgRef, sCntrNbr));
			scgCntrDtlLogVOs.add(this.setScgCntrDtlLog(list, trsmDate, spclSeq, list.getDcgoRefNo(), sDmyCntrNbr));
			
		}
		
		sbMergeFlatFile.append(sbCntrFlatFile.toString		());
		sbMergeFlatFile.append(sbDGCargoFlatFile.toString	());
		
		// SCG PARTNER SPECIAL CARGO TRANSMIT HEADER INSERT			
		if (scgHdrVO != null) {
			dbDao1.addScgPrnrSpclCgoTrsmHdr(scgHdrVO);
		}
		
		
		// SCG PARTNER SPECIAL CARGO CONTAINER LOG INSERT 
		if (scgcntrLogVOs != null && scgcntrLogVOs.size() > 0) {
			
			String	sTrsmBndCd		= "";
			String	sTrsmDt			= "";
			String	sSpclCgoCateCd	= "";
			String	sPrnrSpclCgoSeq	= "";
			String	sCntrSeq		= "";
			
			String	sTmpKey			= "";
			
			List<String> 					dupCheckList	= new ArrayList<String>();
			List<ScgPrnrSpclCgoCntrLogVO>	tmpVOs			= new ArrayList<ScgPrnrSpclCgoCntrLogVO>();
			
			/** Removing duplication container number **/
			for(ScgPrnrSpclCgoCntrLogVO tmpVO:scgcntrLogVOs){
			
				sTrsmBndCd			= tmpVO.getTrsmBndCd		();
				sTrsmDt				= tmpVO.getTrsmDt			();
				sSpclCgoCateCd		= tmpVO.getSpclCgoCateCd	();
				sPrnrSpclCgoSeq		= tmpVO.getPrnrSpclCgoSeq	();
				sCntrSeq			= tmpVO.getCntrSeq			();	
					
				sTmpKey				= sTrsmBndCd+sTrsmDt+sSpclCgoCateCd+sPrnrSpclCgoSeq+sCntrSeq;
				
				//if(tmpVOs.size() < 0){
				//	tmpVOs.add		(tmpVO);
				//}
				
				if(!dupCheckList.contains(sTmpKey)){
					tmpVOs.add		(tmpVO);
				}
				
				dupCheckList.add	(sTmpKey);				
				
			}
			/*******************************************/
			////::2015-06-13::dbDao1.addScgPrnrSpclCgoCntrLog(scgcntrLogVOs);
			
			dbDao1.addScgPrnrSpclCgoCntrLog	(tmpVOs);			/** << TABLE NAME : SCG_PRNR_SPCL_CGO_CNTR_LOG >> */
			
		}
		
		// SCG PARTNER SPECIAL CARGO DETAIL LOG INSERT 	
		if (scgCntrDtlLogVOs != null && scgCntrDtlLogVOs.size() > 0) {
			dbDao1.addScgPrnrSpclCgoDtlLog(scgCntrDtlLogVOs);	/** << TABLE NAME : SCG_PRNR_SPCL_CGO_DTL_LOG >> */
		}
		
		return sbMergeFlatFile.toString();
	}
	
	
	/**
	 * email trans info save <br>
	 * 
	 * @param SendDgEdiRequestVO sendDgEdiRequestVO
	 * @return String
	 * @exception EventException
	 */
	private String manageFlatFileEDICancel(SendDgEdiRequestVO sendDgEdiRequestVO) throws Exception {
		
		StringBuilder sbMergeFlatFile = new StringBuilder();
		
		try{
			
			List<ScgPrnrSpclCgoCntrLogVO>    scgcntrLogVOs 	= new ArrayList<ScgPrnrSpclCgoCntrLogVO>();
			List<ScgPrnrSpclCgoDtlLogVO>  scgCntrDtlLogVOs 	= new ArrayList<ScgPrnrSpclCgoDtlLogVO>();
			List<SendDgEdiHeaderInfoVO> dgEdiHeaderInfoVOs 	= null; 
			ScgPrnrSpclCgoCntrLogVO           scgcntrLogVO 	= null;
			
			// sbMergeFlatFile

			StringBuilder 				sbCntrFlatFile 		= new StringBuilder();
			StringBuilder  				sbDGCargoFlatFile 	= new StringBuilder();
			
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("bkg_no"         	, sendDgEdiRequestVO.getBkgNo		());
			//mapVO.put("vsl_pre_pst_cd" 	, sendDgEdiRequestVO.getVslPrePstCd	());
			mapVO.put("spcl_cgo_apro_rqst_seq"	, sendDgEdiRequestVO.getSpclCgoAproRqstSeq());
			mapVO.put("vsl_seq"        	, sendDgEdiRequestVO.getVslSeq		());
			mapVO.put("crr_cd"         	, sendDgEdiRequestVO.getCrrCd		());
			mapVO.put("loc_cd"         	, sendDgEdiRequestVO.getPolCd		());
			
			mapVO.put("vsl_cd"    		, sendDgEdiRequestVO.getVslCd		());
			mapVO.put("skd_voy_no"		, sendDgEdiRequestVO.getSkdVoyNo	());
			mapVO.put("skd_dir_cd"		, sendDgEdiRequestVO.getSkdDirCd	());
			
			ScgUtilEai utilCommand 		= new ScgUtilEai();
			dgEdiHeaderInfoVOs     		= utilCommand.searchSendEdiHeader			(mapVO);
			
			//EDI HEADER
			String header          		= dgEdiHeaderInfoVOs.get(0).getHeader		();
			String sndrId          		= dgEdiHeaderInfoVOs.get(0).getSenderId		();	    // SNDR_ID 20
			String rcvrId          		= dgEdiHeaderInfoVOs.get(0).getReceiverId	();	// RCVR_ID 20
			String ediMsgTp        		= dgEdiHeaderInfoVOs.get(0).getMessageType	();	// EDI_MSG_TP_ID 10
			
			/** ======================================================================================================
			 *  Change to select new FLAT FILE REFERENCE NUMBER in case of CANCELLATION for Own DG Application
			 *  2015-09-10 :: by TOP
			 *  ======================================================================================================
			 */
			//String tmpEdiMsgStsCd			= sendDgEdiRequestVO.getEdiMsgStsCd();
			String flatFileRefNo			= null;
			
			/** searSendEdiFromParnterLinesMgtDBDAOSelectOriginalFlatFileReferenceNORSQL **/
			sendDgEdiRequestVO.setEdiRcvrId	(rcvrId);
			//:2016-03-10:Commented by TOP://flatFileRefNo   			= dbDao.selectOriginalFlatFileReferenceNO(sendDgEdiRequestVO);						// FLAT_FILE_REFERENCE_NO 15
			
			//:2016-03-10:Commented by TOP://if(flatFileRefNo == null || "".equals(flatFileRefNo))	
			flatFileRefNo   			= ReferenceNumberGeneratorBroker.getKey("SCG","SCG_PRNR_SPCL_CGO_EDI_SEQ"); 	// FLAT_FILE_REFERENCE_NO 15
			/** ====================================================================================================== */
			
			String ediHederMsg     = header + sndrId + rcvrId + ediMsgTp + flatFileRefNo;
			
			List<SendEdiFromBkgHdrVO> hdrVO = dbDao.searchAproRqstCancelForVVDChange(mapVO);
				
			sbMergeFlatFile.append(ediHederMsg).append("\n");
			sbMergeFlatFile.append("BKGNBR:").append(sendDgEdiRequestVO.getBkgNo()).append("\n");
			sbMergeFlatFile.append("BKG_DT:").append(hdrVO.get(0).getBkgDt()).append("\n");
			
			sbMergeFlatFile.append("BRAC:").append(sendDgEdiRequestVO.getEdiMsgStsCd()).append("\n");
			
			//::2016-04-07:by TOP:://sbMergeFlatFile.append("REFNBR:").append(sendDgEdiRequestVO.getFltFileRefNo()).append("\n");
			sbMergeFlatFile.append("REFNBR:").append(flatFileRefNo).append("\n");
			
			sbMergeFlatFile.append("CTRLREFNBR:").append("").append("\n");
			
			sbMergeFlatFile.append("VSL_CALLSIGN:").append(hdrVO.get(0).getCallSgnNo()).append("\n");
			sbMergeFlatFile.append("VSL_LLOYDCODE:").append(hdrVO.get(0).getLloydNo()).append("\n");
			sbMergeFlatFile.append("VSL_FULLNAME:").append(hdrVO.get(0).getVslEngNm()).append("\n");
			sbMergeFlatFile.append("VVD_REF_NO:").append("").append("\n");
			
			sbMergeFlatFile.append("CONSORT_VOY:").append(hdrVO.get(0).getObCssmVoyNo()).append("\n");
			
			sbMergeFlatFile.append("POL_CD:").append(hdrVO.get(0).getPolCd()).append("\n");
			sbMergeFlatFile.append("POL_NM:").append(hdrVO.get(0).getPolNm()).append("\n");
			sbMergeFlatFile.append("POD_CD:").append(hdrVO.get(0).getPodCd()).append("\n");
			sbMergeFlatFile.append("POD_NM:").append(hdrVO.get(0).getPodNm()).append("\n");
			sbMergeFlatFile.append("PLD_CD:").append(hdrVO.get(0).getDelCd()).append("\n");
			sbMergeFlatFile.append("PLD_NM:").append(hdrVO.get(0).getDelNm()).append("\n");
			
			
			/** Making Object for Inserting Cancel EDI Transmit Header Information **/
			String spclSeq  = String.valueOf(dbDao1.searchHdrSequence());
			String trsmDate = dbDao1.searchTrsmDate().substring(0, 8);
			
			scgHdrVO.setTrsmBndCd			(G_TRSM_BND_CD);              // TRANSMIT BOUND CODE V2
			scgHdrVO.setTrsmDt				(trsmDate);                 // TRANSMIT DATE  DB SYSDATE
			scgHdrVO.setSpclCgoCateCd		(G_SPCL_CATE_CD_DG);              	// SPECIAL CARGO CATEGORY CODE V2
			scgHdrVO.setPrnrSpclCgoSeq		(spclSeq);             		// PARTNER SPECIAL CARGO SEQUENCE (ORACLE SEQUENCE)
			scgHdrVO.setTrsmMzdCd			("EDI");                    // TRANSMIT METHOD CODE V3
			scgHdrVO.setFltFileRefNo		(flatFileRefNo);         	// FLAT FILE REFERENCE NUMBER V20
			
			scgHdrVO.setEdiHdrMsg			(ediHederMsg);
			scgHdrVO.setEdiIfId				(flatFileRefNo);
			scgHdrVO.setEdiMsgId			(ediMsgTp);
			scgHdrVO.setCgoOprCd			(sndrId.substring(0, 3));
			scgHdrVO.setEdiRcvrId			(rcvrId);
			scgHdrVO.setEdiSndrId			(sndrId);
			scgHdrVO.setCreUsrId			(USER_ID);
			scgHdrVO.setUpdUsrId			(USER_ID);
			scgHdrVO.setEmlSndNo			("");                                       // E-MAIL SEND NO
			
			scgHdrVO.setBkgRefNo			(sendDgEdiRequestVO.getBkgNo());            //BKGNBR
			scgHdrVO.setBkgCreLoclDt		(hdrVO.get(0).getBkgDt());
			scgHdrVO.setBkgCreLoclDtCtnt	(hdrVO.get(0).getBkgDt());	
			
			//::2015-05-20:://scgHdrVO.setEdiMsgStsCd			(sendDgEdiRequestVO.getEdiMsgStsCd());      //BRAC : N(New), R(Cancel), U(Update)   
			scgHdrVO.setEdiMsgStsCd			(sendDgEdiRequestVO.getEdiMsgStsCd());      //BRAC : N(New), R(Cancel), U(Update)   
			
			scgHdrVO.setEdiMsgRefNo			(flatFileRefNo);                        	
			scgHdrVO.setCtrlRefNo			("");                                      	//CTRLREFNBR		
			scgHdrVO.setCallSgnNo			(hdrVO.get(0).getCallSgnNo());             	//VSL_CALLSIGN
			scgHdrVO.setLloydNo				(hdrVO.get(0).getLloydNo());                //VSL_LLOYDCODE 
			scgHdrVO.setVslEngFullNm		(hdrVO.get(0).getVslEngNm());           	//VSL_FULLNAME 
			scgHdrVO.setOutBndCssmVoyNo		(hdrVO.get(0).getObCssmVoyNo());     		//CONSORT_VOY 
			scgHdrVO.setPorCd				("");                                       //POR_CD 
			scgHdrVO.setPorNm				("");                                       //POR_NM
			scgHdrVO.setPolCd				(hdrVO.get(0).getPolCd());                  //POL_CD
			scgHdrVO.setPolClptIndSeq		(hdrVO.get(0).getPolClptIndSeq());
			
		    scgHdrVO.setPolYdCd				(hdrVO.get(0).getPolNodCd());               //POL_YD_CD
		    scgHdrVO.setPolNm				(hdrVO.get(0).getPolNm());                  //POL_NM 
		    scgHdrVO.setPodCd				(hdrVO.get(0).getPodCd());                  //POD_CD 
		    scgHdrVO.setPodClptIndSeq		(hdrVO.get(0).getPodClptIndSeq());
		    
			scgHdrVO.setPodYdCd				(hdrVO.get(0).getPodNodCd());               //POD_YD_CD 
			scgHdrVO.setPodNm				(hdrVO.get(0).getPodNm());                  //POD_NM 
			 
			scgHdrVO.setDelCd				(hdrVO.get(0).getDelCd());                  //DEL_CD
			scgHdrVO.setDelNm				(hdrVO.get(0).getDelNm());                  //PLD_NM
			
			scgHdrVO.setRgnShpOprCd			(sendDgEdiRequestVO.getRgnShpOprCd());   	//RGN_SHP_OPR_CD
			scgHdrVO.setSlanCd				(hdrVO.get(0).getSlanCd());                 //SLAND_CD
			scgHdrVO.setVslCd				(hdrVO.get(0).getVslCd());                  //VSL_CD
			scgHdrVO.setSkdVoyNo			(hdrVO.get(0).getSkdVoyNo());               //SKD_VOY_NO
			scgHdrVO.setSkdDirCd			(hdrVO.get(0).getSkdDirCd());               //SKD_DIR_CD
			scgHdrVO.setMapgCrrCd			(sendDgEdiRequestVO.getCrrCd());
			scgHdrVO.setMapgBkgRefNo		(sendDgEdiRequestVO.getBkgNo());
			scgHdrVO.setMapgSpclCgoRqstSeq	(sendDgEdiRequestVO.getSpclCgoRqstSeq());		
			scgHdrVO.setSpclCgoAproRqstSeq	(sendDgEdiRequestVO.getSpclCgoAproRqstSeq());
			scgHdrVO.setVslPrePstCd			(sendDgEdiRequestVO.getVslPrePstCd());
			scgHdrVO.setVslSeq				(sendDgEdiRequestVO.getVslSeq());
			scgHdrVO.setErrKndCd			("O");
			/****************************************************************************/
			
			List<SendEdiFromBkgDtlVO> dtlVO = dbDao.searchBkgDtl(mapVO);
			
			sbCntrFlatFile.append("{CNTR_INFO").append("\n");
			sbCntrFlatFile.append("CNTR_SEQ:").append("").append("\n");
			sbCntrFlatFile.append("CNTR_NO:").append("").append("\n");
			sbCntrFlatFile.append("CNTR_TPSZ:").append("").append("\n");
			sbCntrFlatFile.append("}CNTR_INFO").append("\n");
			sbDGCargoFlatFile.append("{CNTR_DG").append("\n");			
			sbDGCargoFlatFile.append("ITEM_SEQ:").append("").append("\n");
			sbDGCargoFlatFile.append("DG_REF:").append("").append("\n");
			sbDGCargoFlatFile.append("MV_TP:").append("\n");
			//NUMBER OF OUTER PACKAGES
			sbDGCargoFlatFile.append("OPKG_QTY:").append("").append("\n");
			//OUTER  PACKAGES TYPE CODE
			sbDGCargoFlatFile.append("OPKG_TP:").append("").append("\n");
			//OUTER  PACKAGES DESCRIPTION
			sbDGCargoFlatFile.append("OPKG_DESC:").append("").append("\n");
			//NUMBER OF MIDDLE PACKAGES
			sbDGCargoFlatFile.append("MPKG_QTY:").append("").append("\n");
			//MIDDLE PACKAGES TYPE CODE
			sbDGCargoFlatFile.append("MPKG_TP:").append("").append("\n");
			//MIDDLE PACKAGES DESCRIPTION
			sbDGCargoFlatFile.append("MPKG_DESC:").append("").append("\n");
			//NUMBER OF INNER PACKAGES
			sbDGCargoFlatFile.append("IPKG_QTY:").append("").append("\n");
			//INNER PACKAGES TYPE CODE
			sbDGCargoFlatFile.append("IPKG_TP:").append("").append("\n");
			//INNER PACKAGES DESCRIPTION
			sbDGCargoFlatFile.append("IPKG_DESC:").append("").append("\n");			
			sbDGCargoFlatFile.append("HAZ_CONT:").append("").append("\n");
			sbDGCargoFlatFile.append("PROP_SHIP_NM:").append("").append("\n");
			sbDGCargoFlatFile.append("TECH_NM:").append("").append("\n");			
			sbDGCargoFlatFile.append("IMO_CLASS:").append("").append("\n");				
			sbDGCargoFlatFile.append("IMO_PAGE:").append("").append("\n");				
			sbDGCargoFlatFile.append("UN_NBR:").append("").append("\n");
			sbDGCargoFlatFile.append("UN_NBR_SEQ:").append("").append("\n");
			sbDGCargoFlatFile.append("CFR_NBR:").append("").append("\n");
			sbDGCargoFlatFile.append("FLASH:").append("").append("\n");
			sbDGCargoFlatFile.append("FLASH_UNIT:").append("").append("\n");
			sbDGCargoFlatFile.append("PKG_GROUP:").append("").append("\n");
			sbDGCargoFlatFile.append("EMS_NBR:").append("").append("\n");				
			sbDGCargoFlatFile.append("MFAG:").append("").append("\n");				
			sbDGCargoFlatFile.append("ESPN:").append("").append("\n");				
			sbDGCargoFlatFile.append("POLLUTANT:").append("").append("\n");
			sbDGCargoFlatFile.append("IMO_LIMIT:").append("").append("\n");								
			sbDGCargoFlatFile.append("GROSWGT:").append("").append("\n");
			sbDGCargoFlatFile.append("GROSSWGT_UNIT:").append("").append("\n");
			sbDGCargoFlatFile.append("NETWGT:").append("").append("\n");
			sbDGCargoFlatFile.append("NETWGT_UNIT:").append("\n");
			sbDGCargoFlatFile.append("NETPWDRWGT:").append("").append("\n");
			sbDGCargoFlatFile.append("NETPWDRWGT_UNIT:").append("\n");
			sbDGCargoFlatFile.append("VOL:").append("").append("\n");
			sbDGCargoFlatFile.append("VOL_UNIT:").append("").append("\n");
			sbDGCargoFlatFile.append("CNTRNBR:").append("").append("\n");				
			sbDGCargoFlatFile.append("RESIDUE:").append("").append("\n");
			sbDGCargoFlatFile.append("CONTACT:").append("").append("\n");
			sbDGCargoFlatFile.append("PHONE:").append("").append("\n");				
			sbDGCargoFlatFile.append("{REMARK").append("").append("\n");
			sbDGCargoFlatFile.append("REMARK:").append("").append("\n");
			sbDGCargoFlatFile.append("}REMARK").append("").append("\n");
			
			sbDGCargoFlatFile.append("}CNTR_DG").append("\n");
			
			String dgCntrSeq    = "";
			String sCntrNbr 	= "";
			
			for (SendEdiFromBkgDtlVO list : dtlVO) {
				
				if (!dgCntrSeq.equals(list.getDgCntrSeq())) {
					
					//::2015-07-31:by TOP://sCntrNbr = (list.getCntrNo() == null || "".equals(list.getCntrNo())) ? dbDao.searchCntrSequence() : list.getCntrNo();
					sCntrNbr = list.getCntrNo();
					
					dgCntrSeq = list.getDgCntrSeq();
					
					//SCG_PRNR_SPCL_CGO_CNTR_LOG					
					scgcntrLogVO = new ScgPrnrSpclCgoCntrLogVO();
					scgcntrLogVO.setTrsmBndCd		(G_TRSM_BND_CD);
					scgcntrLogVO.setTrsmDt			(trsmDate);
					scgcntrLogVO.setSpclCgoCateCd	(G_SPCL_CATE_CD_DG);
					scgcntrLogVO.setPrnrSpclCgoSeq	(spclSeq);
					scgcntrLogVO.setCreUsrId		(USER_ID);
					scgcntrLogVO.setUpdUsrId		(USER_ID);
					scgcntrLogVO.setCntrSeq			(list.getDgCntrSeq());			//CNTR_SEQ 
					scgcntrLogVO.setCntrRefNo		(sCntrNbr);                     //CNTR_NO      
					scgcntrLogVO.setCntrTpszCdCtnt	(list.getCntrTpszCd());         //CNTR_TPSZ
					scgcntrLogVOs.add				(scgcntrLogVO);
				}
				
				//String dgRef = list.getBkgNo() + "-" + JSPUtil.getLPAD(list.getDcgoSeq(), 3, "0");
				//log
				//scgCntrDtlLogVOs.add(this.setScgCntrDtlLog(list, trsmDate, spclSeq, dgRef, sCntrNbr));
				scgCntrDtlLogVOs.add(this.setScgCntrDtlLog(list, trsmDate, spclSeq, list.getDcgoRefNo(), sCntrNbr));
				
			}
			
			sbMergeFlatFile.append(sbCntrFlatFile.toString		());
			sbMergeFlatFile.append(sbDGCargoFlatFile.toString	());
			
			// SCG PARTNER SPECIAL CARGO TRANSMIT HEADER INSERT			
			if (scgHdrVO != null) {
				dbDao1.addScgPrnrSpclCgoTrsmHdr(scgHdrVO);
			}
			
			
			// SCG PARTNER SPECIAL CARGO CONTAINER LOG INSERT 
			////if (scgcntrLogVOs != null && scgcntrLogVOs.size() > 0) {
			////	dbDao1.addScgPrnrSpclCgoCntrLog(scgcntrLogVOs);
			////}
			
			// SCG PARTNER SPECIAL CARGO CONTAINER LOG INSERT 
			if (scgcntrLogVOs != null && scgcntrLogVOs.size() > 0) {
				
				String	sTrsmBndCd		= "";
				String	sTrsmDt			= "";
				String	sSpclCgoCateCd	= "";
				String	sPrnrSpclCgoSeq	= "";
				String	sCntrSeq		= "";
				
				String	sTmpKey			= "";
				
				List<String> 					dupCheckList	= new ArrayList<String>();
				List<ScgPrnrSpclCgoCntrLogVO>	tmpVOs			= new ArrayList<ScgPrnrSpclCgoCntrLogVO>();
				
				/** Removing duplication container number **/
				for(ScgPrnrSpclCgoCntrLogVO tmpVO:scgcntrLogVOs){
				
					sTrsmBndCd			= tmpVO.getTrsmBndCd		();
					sTrsmDt				= tmpVO.getTrsmDt			();
					sSpclCgoCateCd		= tmpVO.getSpclCgoCateCd	();
					sPrnrSpclCgoSeq		= tmpVO.getPrnrSpclCgoSeq	();
					sCntrSeq			= tmpVO.getCntrSeq			();	
						
					sTmpKey				= sTrsmBndCd+sTrsmDt+sSpclCgoCateCd+sPrnrSpclCgoSeq+sCntrSeq;
					
					//if(tmpVOs.size() < 0){
					//	tmpVOs.add		(tmpVO);
					//}
					
					if(!dupCheckList.contains(sTmpKey)){
						tmpVOs.add		(tmpVO);
					}
					
					dupCheckList.add	(sTmpKey);				
					
				}
				/*******************************************/
				////::2015-06-13::dbDao1.addScgPrnrSpclCgoCntrLog(scgcntrLogVOs);
				
				dbDao1.addScgPrnrSpclCgoCntrLog	(tmpVOs);			/** << TABLE NAME : SCG_PRNR_SPCL_CGO_CNTR_LOG >> */
				
			}
			
			
			// SCG PARTNER SPECIAL CARGO DETAIL LOG INSERT 	
			if (scgCntrDtlLogVOs != null && scgCntrDtlLogVOs.size() > 0) {
				dbDao1.addScgPrnrSpclCgoDtlLog(scgCntrDtlLogVOs);
			}
			
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		

		return sbMergeFlatFile.toString();
	}
	
	private ScgPrnrSpclCgoDtlLogVO setScgCntrDtlLog(SendEdiFromBkgDtlVO list, String trsmDate, String spclSeq, String sDcgoRefNo, String sCntrNbr) throws DAOException {
		//log				
		ScgPrnrSpclCgoDtlLogVO scgCntrDtlLogVO 	= new ScgPrnrSpclCgoDtlLogVO();
		scgCntrDtlLogVO.setTrsmBndCd			(G_TRSM_BND_CD);
		scgCntrDtlLogVO.setTrsmDt				(trsmDate	);
		scgCntrDtlLogVO.setSpclCgoCateCd		(G_SPCL_CATE_CD_DG	);
		scgCntrDtlLogVO.setPrnrSpclCgoSeq		(spclSeq	);
		
		//Map<String, String> logVO = new HashMap<String, String>();
		//logVO.put("trsm_bnd_cd"      , scgCntrDtlLogVO.getTrsmBndCd());
		//logVO.put("trsm_dt"          , scgCntrDtlLogVO.getTrsmDt());
		//logVO.put("spcl_cgo_G_SPCL_CATE_CD" , scgCntrDtlLogVO.getSpclCgoCateCd());
		//logVO.put("prnr_spcl_cgo_seq", scgCntrDtlLogVO.getPrnrSpclCgoSeq());
		
		ScgPrnrSpclCgoTrsmHdrVO tmpVO			= new ScgPrnrSpclCgoTrsmHdrVO();
		tmpVO.setTrsmBndCd						(G_TRSM_BND_CD);
		tmpVO.setTrsmDt							(trsmDate	);
		tmpVO.setSpclCgoCateCd					(G_SPCL_CATE_CD_DG	);
		tmpVO.setPrnrSpclCgoSeq					(spclSeq	);
		
		//:2016-02-12:by TOP://scgCntrDtlLogVO.setPrnrSpclCgoSubSeq(String.valueOf(dbDao1.searchDtlLogSequence(tmpVO)));
		
		//CNTR_TPSZ_CD_CTNT
		scgCntrDtlLogVO.setCntrTpszCdCtnt(list.getCntrTpszCd());
		//CNTR_TPSZ_ISO_CD
		scgCntrDtlLogVO.setIsoCntrTpszCd(list.getCntrTpszIsoCd());		
		//ITEM_SEQ
		scgCntrDtlLogVO.setCgoSeq	(list.getCntrCgoSeq	());    
		
		/** Adding column on 10JUL **/
		scgCntrDtlLogVO.setDcgoSeq	(list.getDcgoSeq	());
		
		//DG_REF
		//scgCntrDtlLogVO.setRefNo	(dcgoRefNo);
		//scgCntrDtlLogVO.setDcgoRefNo(dcgoRefNo);
		scgCntrDtlLogVO.setDcgoRefNo(sDcgoRefNo);
		
		scgCntrDtlLogVO.setMvmtSpclTpCd("3");
		//NUMBER OF OUTER PACKAGES
		scgCntrDtlLogVO.setOutN1stImdgPckQtyCtnt(list.getOutImdgPckQty1());
		//OUTER  PACKAGES TYPE CODE
		scgCntrDtlLogVO.setOutN1stImdgPckCdCtnt(list.getOutImdgPckCd1()); 
		//OUTER  PACKAGES DESCRIPTION
		scgCntrDtlLogVO.setOutN1stImdgPckDesc(list.getOutImdgPckDesc1());
		
		//NUMBER OF MIDDLE PACKAGES   
		scgCntrDtlLogVO.setIntmdN1stImdgPckQtyCtnt(list.getIntmdImdgPckQty1());
		//MIDDLE PACKAGES TYPE CODE
		scgCntrDtlLogVO.setIntmdN1stImdgPckCdCtnt(list.getIntmdImdgPckCd1());   
		//MIDDLE PACKAGES DESCRIPTION
		scgCntrDtlLogVO.setIntmdN1stImdgPckDesc(list.getIntmdImdgPckDesc1());
		//NUMBER OF INNER PACKAGES
		scgCntrDtlLogVO.setInN1stImdgPckQtyCtnt(list.getInImdgPckQty1()); 
		//INNER PACKAGES TYPE CODE
		scgCntrDtlLogVO.setInN1stImdgPckCdCtnt(list.getInImdgPckCd1());   
		//INNER PACKAGES DESCRIPTION
		scgCntrDtlLogVO.setInN1stImdgPckDesc(list.getInImdgPckDesc1()); 
		//HAZ_CONT
		scgCntrDtlLogVO.setHzdDesc(list.getHzdDesc());
		//PROP_SHIP_NM
		scgCntrDtlLogVO.setPrpShpNm(list.getPrpShpNm());
		//TECH_NM 
		scgCntrDtlLogVO.setImdgTecNm(list.getHzdDesc());
		//IMO_CLASS 
		scgCntrDtlLogVO.setImdgClssCdCtnt(list.getImdgClssCd());
		//IMO_PAGE
		scgCntrDtlLogVO.setImdgPprNo("");
		//UN_NBR
		scgCntrDtlLogVO.setImdgUnNoCtnt(list.getImdgUnNo());                                                           
		//UN_NBR_SEQ
		scgCntrDtlLogVO.setImdgUnNoSeq(list.getImdgUnNoSeq()); 
		//CFR_FLG
		scgCntrDtlLogVO.setCfrFlg(list.getCfrFlg());                  
		//CFR_NBR
		if ("Y".equals(list.getCfrFlg())) {
			scgCntrDtlLogVO.setCfrNo(list.getImdgUnNo());
		}
		//FLASH
		scgCntrDtlLogVO.setFlshPntTempCtnt(list.getFlshPntCdoTemp());
		//FLASH_UNIT
		if (list.getFlshPntCdoTemp() == null || "".equals(list.getFlshPntCdoTemp())) {
			scgCntrDtlLogVO.setFlshPntUtCdCtnt("");
		} else {
			scgCntrDtlLogVO.setFlshPntUtCdCtnt("CEL");  
		}
		              
		//PKG_GROUP
		scgCntrDtlLogVO.setImdgPckGrpCdCtnt(list.getImdgPckGrpCd());  
		
		//CTRL_TEMP
		scgCntrDtlLogVO.setCtrlTempCtnt(list.getCtrlTempCtnt()); 
		
		//EMS_NBR
		scgCntrDtlLogVO.setEmsNo(list.getEmsNo());
		//MFAG
		scgCntrDtlLogVO.setMfagNo("");     
		//ESPN
		scgCntrDtlLogVO.setEspNo("");                    
		//POLLUTANT
		scgCntrDtlLogVO.setImdgMrnPolutFlg(list.getMrnPolutFlg());
		scgCntrDtlLogVO.setImdgMrnPolutCdCtnt(("Y".equals(list.getMrnPolutFlg()) ? "P" : ""));
		//IMO_LIMIT
		scgCntrDtlLogVO.setImdgLmtQtyFlgCtnt(list.getImdgLmtQtyFlg());
		//GROSWGT
		//GROSSWGT_UNIT
		if (Double.parseDouble(list.getGrsWgt()) <= 0) {
			scgCntrDtlLogVO.setGrsWgtCtnt("");
			scgCntrDtlLogVO.setGrsWgtUtCdCtnt("");
		} else {
			scgCntrDtlLogVO.setGrsWgtCtnt(list.getGrsWgt());
			scgCntrDtlLogVO.setGrsWgtUtCdCtnt(list.getWgtUtCd());
		}
		
		//NETWGT
		//NETWGT_UNIT
		if (Double.parseDouble(list.getNetWgt()) <= 0) {
			scgCntrDtlLogVO.setNetWgtCtnt("");
			scgCntrDtlLogVO.setNetWgtUtCdCtnt("");
		} else {
			scgCntrDtlLogVO.setNetWgtCtnt(list.getNetWgt());
			scgCntrDtlLogVO.setNetWgtUtCdCtnt(list.getWgtUtCd());
		}
		//NETEXPL
		//NETEXPL_UNIT
		if (Double.parseDouble(list.getNetExploWgt()) <= 0) {
			scgCntrDtlLogVO.setNetExploWgtCtnt("");
			scgCntrDtlLogVO.setNetExploWgtUtCdCtnt("");
		} else {
			scgCntrDtlLogVO.setNetExploWgtCtnt(list.getNetExploWgt());
			scgCntrDtlLogVO.setNetExploWgtUtCdCtnt(list.getWgtUtCd());
		}
		
		//VOL
		scgCntrDtlLogVO.setPckQtyCtnt("");
		//VOL_UNIT
		scgCntrDtlLogVO.setPckTpCdCtnt("");
		//CNTRNBR
		scgCntrDtlLogVO.setCntrRefNo(sCntrNbr);
		//RESIDUE
		scgCntrDtlLogVO.setRsdFlgCtnt(list.getRsdFlg());
		//REMARK
		scgCntrDtlLogVO.setDiffRmk(list.getDiffRmk());
		//CONTACT
		scgCntrDtlLogVO.setEmerCntcPsonNm(list.getEmerCntcPsonNm()); 
		//PHONE
		scgCntrDtlLogVO.setEmerCntcPhnNo(list.getEmerCntcPhnNoCtnt());
		//PSA_NO
		scgCntrDtlLogVO.setPsaNo(list.getPsaNo());
		//CNTR_DMY_REF_NO
		scgCntrDtlLogVO.setCntrDmyRefNo((list.getCntrNo() == null || "".equals(list.getCntrNo())) ? sCntrNbr : "");
		scgCntrDtlLogVO.setCreUsrId(USER_ID);
		scgCntrDtlLogVO.setUpdUsrId(USER_ID);
		
		//::2015-10-22:://
		scgCntrDtlLogVO.setDcgoDtlStsCdCtnt		(list.getDcgoStsCd		());
		scgCntrDtlLogVO.setImdgAddSegrGrpNoCtnt	(list.getImdgSegrGrpNm	());
		scgCntrDtlLogVO.setImdgSegrGrpNoCtnt	(list.getImdgSegrGrpNos	());
		
		
		return scgCntrDtlLogVO;
	}
	
//	private void scgPrnrSpclCgoTrsmAckSend(ScgPrnrSpclCgoTrsmHdrVO scgHdrVO, String ackStsCd, String errCode) throws Exception {
//		
//		ScgPrnrSpclCgoTrsmAckVO ackVO = new ScgPrnrSpclCgoTrsmAckVO();		
//		String[] err = errCode.split(":");
//		ackVO.setTrsmBndCd(scgHdrVO.getTrsmBndCd());
//		ackVO.setTrsmDt(scgHdrVO.getTrsmDt());
//		ackVO.setSpclCgoCateCd(scgHdrVO.getSpclCgoCateCd());
//		ackVO.setPrnrSpclCgoSeq(scgHdrVO.getPrnrSpclCgoSeq());
//		ackVO.setEdiMsgId(scgHdrVO.getEdiMsgId());
//		ackVO.setEdiSndrId(scgHdrVO.getEdiSndrId());
//		ackVO.setEdiRcvrId(scgHdrVO.getEdiRcvrId());
//		ackVO.setEdiIfId(scgHdrVO.getEdiIfId());
//		ackVO.setTrsmStsCd(ackStsCd);
//		ackVO.setEdiHdrMsg(scgHdrVO.getEdiHdrMsg());
//		ackVO.setOrgMsgRcvrNm(scgHdrVO.getEdiRcvrId());
//		ackVO.setOrgMsgKeyNo(scgHdrVO.getCtrlRefNo());
//		ackVO.setOrgMsgTpCd("");
//		ackVO.setMsgUpdFlg("");
//		ackVO.setOrgMsgNm("IFTMBF");
//		ackVO.setMsgAckTpCd("S");
//		ackVO.setMsgAckRsltCd(ackStsCd);
//		
//		ackVO.setMsgAckLoclDt(scgHdrVO.getTrsmDt());
//		ackVO.setMsgAckGdt(scgHdrVO.getTrsmDt());
//		
//		ackVO.setErrDtlCd((err.length == 4) ? err[0] : "" );
//		ackVO.setMsgRjctCd((err.length == 4) ? err[1] : "" );
//		ackVO.setMsgRjctRsn((err.length == 4) ? err[2] : "" );
//		ackVO.setMsgAcptRefNo("");
//		ackVO.setCreUsrId(USER_ID);
//		ackVO.setUpdUsrId(USER_ID);
//		
//		dbDao1.AddScgPrnrSpclCgoTrsmAck(ackVO);
//		
//		/***********************************************************
//		 * EDI 전송 START
//		 ***********************************************************/		
////		ScgUtilEai utilCommand = new ScgUtilEai();
////		
////		FlatFileAckVO flatFileAckVO = utilCommand.sendFlatFile(setSendFlatFile(manageFlatFileEDINormal(ackVO)));
////		if (flatFileAckVO.getAckStsCd().equals("E"))
////			throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
//	}
//	
//	private String manageFlatFileEDINormal(ScgPrnrSpclCgoTrsmAckVO ackVO)  throws Exception {
//		// sbMergeFlatFile
//		StringBuilder sbMergeFlatFile = new StringBuilder();
//		
//		//EDI HEADER
//		String header        = "$$$MSGSTART:";
//		String sndrId        = JSPUtil.getRPAD(ackVO.getEdiRcvrId(), 20, " ");	       // SNDR_ID 20
//		String rcvrId        = JSPUtil.getRPAD(ackVO.getEdiSndrId(), 20, " ");		   // RCVR_ID 20
//		String ediMsgTp      = JSPUtil.getRPAD("APERAK", 10, " ");		               // EDI_MSG_TP_ID 10
//		String flatFileRefNo = ReferenceNumberGeneratorBroker.getKey("SCG","SCG_PRNR_SPCL_CGO_EDI_SEQ");		// FLAT_FILE_REFERENCE_NO 15
//		sbMergeFlatFile.append(header + sndrId + rcvrId + ediMsgTp + flatFileRefNo).append("\n");
//		
//		sbMergeFlatFile.append("ORG_MSG_RCV:").append(ackVO.getEdiRcvrId()).append("\n");	   //Original Msg Receiver
//		sbMergeFlatFile.append("ORG_MSG_KEY:").append(ackVO.getOrgMsgKeyNo()).append("\n");   //Original Msg's key value
//		sbMergeFlatFile.append("ORG_MSG_TP:").append("").append("\n");	                   //Original Msg Type
//		sbMergeFlatFile.append("MSG_UDT_FLG:").append("").append("\n");	                   //Msg UDT Flag
//		sbMergeFlatFile.append("ORG_MSG_NM:").append("IFTMBF").append("\n");	               //Original Msg Name
//		sbMergeFlatFile.append("MSG_ACK_TP:").append("S").append("\n");	                   //Msg Ack Type
//		sbMergeFlatFile.append("MSG_ACK_RSLT:").append(ackVO.getMsgAckRsltCd()).append("\n"); //Msg Ack Result
//		sbMergeFlatFile.append("MSG_ACK_LDT:").append(ackVO.getMsgAckLoclDt()).append("\n");  //Msg Ack Local Date
//		sbMergeFlatFile.append("MSG_ACK_GDT:").append(ackVO.getMsgAckGdt()).append("\n");	   //Msg Ack GMT Date
//		sbMergeFlatFile.append("MSG_R_CD:").append(ackVO.getMsgRjctCd()).append("\n");	       //Msg Error Code
//		sbMergeFlatFile.append("MSG_R_REASON:").append(ackVO.getMsgRjctRsn()).append("\n");   //Msg Reject Reason
//		sbMergeFlatFile.append("MSG_ACCEPT_REF:").append("").append("\n");	                   //Msg Ref Number
//		
//		return sbMergeFlatFile.toString();
//	}
	
	private SendFlatFileVO setSendFlatFile(String sbMergeFlatFile) {
		
		SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
		sendFlatFileVO.setFlatFile(sbMergeFlatFile);
		sendFlatFileVO.setTarget(SubSystemConfigFactory.get      ("SCG.SCG_EDI_DGRQST.IBMMQ.URL"));		
		sendFlatFileVO.setTransferType(SubSystemConfigFactory.get("SCG.SCG_EDI_DGRQST.IBMMQ.TRANSFERTYPE"));		
		sendFlatFileVO.setChannel(SubSystemConfigFactory.get     ("SCG.SCG_EDI_DGRQST.IBMMQ.CHANNEL"));		
		sendFlatFileVO.setFactory(SubSystemConfigFactory.get     ("SCG.SCG_EDI_DGRQST.IBMMQ.FACTORY"));		
		sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get     ("SCG.SCG_EDI_DGRQST.IBMMQ.QUEUE"));
		sendFlatFileVO.setTargetClient(SubSystemConfigFactory.get("SCG.SCG_EDI_DGRQST.IBMMQ.TARGETCLIENT"));
		
		return sendFlatFileVO;
	}
	
	private void modifyScgPrnrAproRqst (String ackStsCd, String sRqstOfcCd, String sEdiStatus) throws DAOException {
		
		Map<String, String> mapVO = new HashMap<String, String>();
		
		mapVO.put("bkg_no"                    	, scgHdrVO.getBkgRefNo());
		mapVO.put("spcl_cgo_apro_rqst_seq"    	, scgHdrVO.getSpclCgoAproRqstSeq());
		mapVO.put("vsl_pre_pst_cd"            	, scgHdrVO.getVslPrePstCd());
		mapVO.put("vsl_seq"                   	, scgHdrVO.getVslSeq());
		mapVO.put("mapg_trsm_bnd_cd"          	, scgHdrVO.getTrsmBndCd());
		mapVO.put("mapg_trsm_dt"              	, scgHdrVO.getTrsmDt());
		mapVO.put("mapg_trsm_spcl_cgo_cate_cd"	, G_SPCL_CATE_CD_DG); 
		mapVO.put("mapg_prnr_spcl_cgo_seq"    	, scgHdrVO.getPrnrSpclCgoSeq());
		mapVO.put("cxl_edi_snd_ofc_cd"        	, sRqstOfcCd	);
		mapVO.put("mapg_edi_trsm_sts_cd"      	, ackStsCd);	//:: SR, SX :://
		
		mapVO.put("edi_status"                  , sEdiStatus);
		  
		dbDao.modifyScgPrnrAproRqst				(mapVO);
	}
	
	private void addScgPrnrSpclCgoFltFile(String sbMergeFlatFile, String msg) {
		
		try {
			ScgUtilEai 				utilCommand = new ScgUtilEai();
			DgEdiFltFileVO 			excVO		= new DgEdiFltFileVO();
		
			excVO.setTrsmBndCd		(scgHdrVO.getTrsmBndCd		());
			excVO.setPrnrSpclCgoSeq	(scgHdrVO.getPrnrSpclCgoSeq	());
			excVO.setBkgRefNo		(scgHdrVO.getBkgRefNo		());
			excVO.setFltFileDatCtnt	(sbMergeFlatFile);
			excVO.setExptMsg		(msg);
			excVO.setCreUsrId		(USER_ID);
			excVO.setUpdUsrId		(USER_ID);
		
			utilCommand.addScgPrnrSpclCgoFltFile(excVO);	/** SCG_PRNR_SPCL_CGO_FLT_FILE **/
			
		} catch (EventException e) {
			log.error(msg);
		}
	}
	
	/**
	 * EMAIL LOG
	 * 
	 * @param setEmailHis 생성 
	 * @param SendDgEmailRequestVO
	 * @return VOID
	 * @throws DAOException 
	 */
	
	public void setEmailHis(SendDgEmailRequestVO sendDgEmailRequestVO, SignOnUserAccount account) throws EventException {
		
		try{
			USER_ID = account.getUsr_id();
			setEmailSaveHis(sendDgEmailRequestVO);	
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO APVL for Own BKG HISTORY "}).getMessage(), ex);
		}
	}
	
	private void setEmailSaveHis(SendDgEmailRequestVO sendDgEmailRequestVO) throws Exception {
		List<ScgPrnrSpclCgoCntrLogVO>    scgcntrLogVOs = new ArrayList<ScgPrnrSpclCgoCntrLogVO>();
		List<ScgPrnrSpclCgoDtlLogVO>  scgCntrDtlLogVOs = new ArrayList<ScgPrnrSpclCgoDtlLogVO>();		
		ScgPrnrSpclCgoCntrLogVO           scgcntrLogVO = null;
		
		Map<String, String> mapVO = new HashMap<String, String>();
		
		mapVO.put("bkg_no", sendDgEmailRequestVO.getBkgNo());
		mapVO.put("vsl_pre_pst_cd", sendDgEmailRequestVO.getVslPrePstCd());
		mapVO.put("vsl_seq", sendDgEmailRequestVO.getVslSeq());
		
		List<SendEdiFromBkgHdrVO> hdrVO = dbDao.searchBkgHdr(mapVO);
		
		String spclSeq  = String.valueOf(dbDao1.searchHdrSequence());
		String trsmDate = dbDao1.searchTrsmDate().substring(0, 8);
		
		scgHdrVO.setTrsmBndCd(G_TRSM_BND_CD);              // TRANSMIT BOUND CODE V2
		scgHdrVO.setTrsmDt(trsmDate);                    // TRANSMIT DATE  DB SYSDATE
		scgHdrVO.setSpclCgoCateCd(G_SPCL_CATE_CD_DG);              // SPECIAL CARGO CATEGORY CODE V2
		scgHdrVO.setPrnrSpclCgoSeq(spclSeq);             // PARTNER SPECIAL CARGO SEQUENCE (ORACLE SEQUENCE)
		scgHdrVO.setTrsmMzdCd("EML");                    // TRANSMIT METHOD CODE V3
		scgHdrVO.setFltFileRefNo("");                    // FLAT FILE REFERENCE NUMBER V20
		
		scgHdrVO.setEdiHdrMsg("");
		scgHdrVO.setEdiIfId("");
		scgHdrVO.setEdiMsgId("");
		scgHdrVO.setCgoOprCd("");
		scgHdrVO.setEdiRcvrId("");
		scgHdrVO.setEdiSndrId("");
		scgHdrVO.setCreUsrId(USER_ID);
		scgHdrVO.setUpdUsrId(USER_ID);
		scgHdrVO.setEmlSndNo("");                                       // E-MAIL SEND NO
		
		scgHdrVO.setBkgRefNo(sendDgEmailRequestVO.getBkgNo());            //BKGNBR
		scgHdrVO.setBkgCreLoclDt(hdrVO.get(0).getBkgDt());
		scgHdrVO.setBkgCreLoclDtCtnt(hdrVO.get(0).getBkgDt());	
		scgHdrVO.setEdiMsgStsCd("");                                   //BRAC     // N(New), R(Cancel), U(Update)   
		scgHdrVO.setEdiMsgRefNo("");                         
		scgHdrVO.setCtrlRefNo("");                                      //CTRLREFNBR		
		scgHdrVO.setCallSgnNo(hdrVO.get(0).getCallSgnNo());             //VSL_CALLSIGN
		scgHdrVO.setLloydNo(hdrVO.get(0).getLloydNo());                 //VSL_LLOYDCODE 
		scgHdrVO.setVslEngFullNm(hdrVO.get(0).getVslEngNm());           //VSL_FULLNAME 
		scgHdrVO.setOutBndCssmVoyNo(hdrVO.get(0).getObCssmVoyNo());     //CONSORT_VOY 
		scgHdrVO.setPorCd("");                                          //POR_CD 
		scgHdrVO.setPorNm("");                                          //POR_NM
		scgHdrVO.setPolCd			(hdrVO.get(0).getPolCd());                     //POL_CD
		scgHdrVO.setPolClptIndSeq	(hdrVO.get(0).getPolClptIndSeq());
		
	    scgHdrVO.setPolYdCd(hdrVO.get(0).getPolNodCd());                //POL_YD_CD
	    scgHdrVO.setPolNm(hdrVO.get(0).getPolNm());                     //POL_NM 
	    scgHdrVO.setPodCd(hdrVO.get(0).getPodCd());                     //POD_CD 
	    scgHdrVO.setPodClptIndSeq	(hdrVO.get(0).getPodClptIndSeq());
	    
		scgHdrVO.setPodYdCd(hdrVO.get(0).getPodNodCd());                //POD_YD_CD 
		scgHdrVO.setPodNm(hdrVO.get(0).getPodNm());                     //POD_NM 
		 
		scgHdrVO.setDelCd(hdrVO.get(0).getDelCd());                     //DEL_CD
		scgHdrVO.setDelNm(hdrVO.get(0).getDelNm());                     //PLD_NM
		
		scgHdrVO.setRgnShpOprCd(sendDgEmailRequestVO.getRgnShpOprCd());   //RGN_SHP_OPR_CD
		scgHdrVO.setSlanCd(hdrVO.get(0).getSlanCd());                   //SLAND_CD
		scgHdrVO.setVslCd(hdrVO.get(0).getVslCd());                     //VSL_CD
		scgHdrVO.setSkdVoyNo(hdrVO.get(0).getSkdVoyNo());               //SKD_VOY_NO
		scgHdrVO.setSkdDirCd(hdrVO.get(0).getSkdDirCd());               //SKD_DIR_CD
		scgHdrVO.setMapgCrrCd(sendDgEmailRequestVO.getCrrCd());
		scgHdrVO.setMapgBkgRefNo(sendDgEmailRequestVO.getBkgNo());
		scgHdrVO.setMapgSpclCgoRqstSeq(sendDgEmailRequestVO.getSpclCgoRqstSeq());
		scgHdrVO.setErrKndCd("O");
		
		List<SendEdiFromBkgDtlVO> dtlVO = dbDao.searchBkgDtl(mapVO);
		
		String dgCntrSeq = "";
		
		for (SendEdiFromBkgDtlVO list : dtlVO) {
				//SCG_PRNR_SPCL_CGO_CNTR_LOG
			if (!dgCntrSeq.equals(list.getDgCntrSeq())) {	
				
				dgCntrSeq = list.getDgCntrSeq();
				
				scgcntrLogVO = new ScgPrnrSpclCgoCntrLogVO();
				scgcntrLogVO.setTrsmBndCd		(G_TRSM_BND_CD);
				scgcntrLogVO.setTrsmDt			(trsmDate);
				scgcntrLogVO.setSpclCgoCateCd	(G_SPCL_CATE_CD_DG);
				scgcntrLogVO.setPrnrSpclCgoSeq	(spclSeq);
				scgcntrLogVO.setCreUsrId		(USER_ID);
				scgcntrLogVO.setUpdUsrId		(USER_ID);
				scgcntrLogVO.setCntrSeq			(list.getDgCntrSeq());			//CNTR_SEQ 
				scgcntrLogVO.setCntrRefNo		(list.getCntrNo());				//CNTR_NO      
				scgcntrLogVO.setCntrTpszCdCtnt	(list.getCntrTpszCd());			//CNTR_TPSZ
				scgcntrLogVOs.add				(scgcntrLogVO);
			}
			//"VVD별 UNIQUE NO로서 신규/수정/삭제 CGO  구분목적 - BKG NO + '-' + BKG/SCG_DG_SEQ.DCGO_SEQ"
			//String dgRef = list.getBkgNo() + "-" + JSPUtil.getLPAD(list.getDcgoSeq(), 3, "0");
			
			scgCntrDtlLogVOs.add(this.setScgCntrDtlLog(list, trsmDate, spclSeq, null, list.getCntrNo()));
		}
		
		// SCG PARTNER SPECIAL CARGO TRANSMIT HEADER INSERT			
		if (scgHdrVO != null) {
			dbDao1.addScgPrnrSpclCgoTrsmHdr(scgHdrVO);
		}
		
		// SCG PARTNER SPECIAL CARGO CONTAINER LOG INSERT 
		////if (scgcntrLogVOs != null && scgcntrLogVOs.size() > 0) {
		////	dbDao1.addScgPrnrSpclCgoCntrLog(scgcntrLogVOs);
		////}

		// SCG PARTNER SPECIAL CARGO CONTAINER LOG INSERT 
		if (scgcntrLogVOs != null && scgcntrLogVOs.size() > 0) {
			
			String	sTrsmBndCd		= "";
			String	sTrsmDt			= "";
			String	sSpclCgoCateCd	= "";
			String	sPrnrSpclCgoSeq	= "";
			String	sCntrSeq		= "";
			
			String	sTmpKey			= "";
			
			List<String> 					dupCheckList	= new ArrayList<String>();
			List<ScgPrnrSpclCgoCntrLogVO>	tmpVOs			= new ArrayList<ScgPrnrSpclCgoCntrLogVO>();
			
			/** Removing duplication container number **/
			for(ScgPrnrSpclCgoCntrLogVO tmpVO:scgcntrLogVOs){
			
				sTrsmBndCd			= tmpVO.getTrsmBndCd		();
				sTrsmDt				= tmpVO.getTrsmDt			();
				sSpclCgoCateCd		= tmpVO.getSpclCgoCateCd	();
				sPrnrSpclCgoSeq		= tmpVO.getPrnrSpclCgoSeq	();
				sCntrSeq			= tmpVO.getCntrSeq			();	
					
				sTmpKey				= sTrsmBndCd+sTrsmDt+sSpclCgoCateCd+sPrnrSpclCgoSeq+sCntrSeq;
				
				//if(tmpVOs.size() < 0){
				//	tmpVOs.add		(tmpVO);
				//}
				
				if(!dupCheckList.contains(sTmpKey)){
					tmpVOs.add		(tmpVO);
				}
				
				dupCheckList.add	(sTmpKey);				
				
			}
			/*******************************************/
			////::2015-06-13::dbDao1.addScgPrnrSpclCgoCntrLog(scgcntrLogVOs);
			
			dbDao1.addScgPrnrSpclCgoCntrLog	(tmpVOs);			/** << TABLE NAME : SCG_PRNR_SPCL_CGO_CNTR_LOG >> */
			
		}
		
		
		// SCG PARTNER SPECIAL CARGO DETAIL LOG INSERT 	
		if (scgCntrDtlLogVOs != null && scgCntrDtlLogVOs.size() > 0) {
			dbDao1.addScgPrnrSpclCgoDtlLog(scgCntrDtlLogVOs);
		}
	}
}
