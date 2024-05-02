/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ChinaCustomsTransmissionBackEndJob.java
 *@FileTitle : ChinaCustomsTransmissionBackEndJob
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.11.26
 *@LastModifier : 이수빈
 *@LastVersion : 1.0
 * 2009.11.26 이수빈
 * 1.0 Creation
 * History : 
 * 2010.12.20 2010.12.22 이수진 [CHM-201007563] 중국 Manifest Second Seal 정보 추가 요청
 *            :Manifest 전송시 SealNo 갯수만큼 SEAL NO, SEAL KIND CODE, SEALER CODE 정보가 보여지도록 수정.
 * 2010.12.22 이수진 [CHM-201007563] 중국 Manifest Second Seal 정보 추가 요청
 *            :SEAL NO가 1개 이상인데 SEAL KIND CODE, SEALER CODE가 없는 경우에는 " "값으로 인식하도록 수정
 * 2010.12.24 이수진 [CHM-201007563] 중국 Manifest Second Seal 정보 추가 요청
 *            :SEAL KIND CODE, SEALER CODE가 없는 경우 " "로 처리했던것을 ""로 변경
 * 2011.06.16 민정호 [CHM-201111127] Split 03-Split 08-ALPS Error 처리 요청            
 * 2011.11.28 민정호 [CLT-111121274-01] R4J 패치 이후 발생한 결함 건 수정(Null dereference)
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.common.Constants;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.integration.RussiaCustomsTransmissionDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.vo.RussiaBlInfoListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.vo.RussiaCMCntrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.vo.RussiaCncusBlListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.vo.RussiaCncusCntrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.vo.RussiaCncusDangerCntrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.vo.RussiaCncusVvdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.vo.RussiaManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.vo.RussiaVslInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.vo.RussiatransmitBlListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.vo.TransKeyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.basic.ManifestListDownloadBC;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.russia.basic.RussiaManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.russia.vo.RussiaManifestListDetailVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCstmsChnSndLogBlVO;
import com.hanjin.syscommon.common.table.BkgCstmsChnSndLogCntrVO;
import com.hanjin.syscommon.common.table.BkgCstmsChnSndLogVO;

/**
 * NIS2010-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - NIS2010-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Lee Subin 
 * @see ESM_BKG_1046EventResponse,UsaManifestListDownloadBackEndJob 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class RussiaCustomsTransmissionBackEndJob extends BackEndCommandSupport {
	private static final long serialVersionUID = -3034414164961318353L;
	private ManifestTransmitVO manifestTransmitVO;
	private SignOnUserAccount account;

	// Database Access Object
	private RussiaCustomsTransmissionDBDAO dbDao = null;
	
	/**
	 * 다운로드 할 데이터 세팅
	 * 
	 * @param manifestListDetailVOs
	 * @param account
	 */
	public void setManifestTransmitVO(ManifestTransmitVO manifestTransmitVO, SignOnUserAccount account, RussiaCustomsTransmissionDBDAO dbDao) {
		this.manifestTransmitVO = manifestTransmitVO;
		this.account = account;
		this.dbDao = dbDao;
	}

	/**
	 * BackEndJob Start
	 * 
	 * @return String
	 * @exception Exception
	 */
	public String doStart() throws Exception {
		/***********************************************************
		 * FlatFile 생성
		 ***********************************************************/
		return transmitManifest();
	}

	/**
	 * 중국 세관 신고를 위해 FlatFile을 생성한다.
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String transmitManifest() throws EventException {
		FlatFileAckVO flatFileAckVO = null;		
		FlatFileAckVO flatFileAckVO1= null;		
		RussiaManifestTransmitVO russiaManifestTranmitVO = null;
		RussiaBlInfoListVO[] russiaBlInfoListVOs = null;
		RussiaManifestListDetailVO[] russiaManifestListDetailVOs = null;
		
		String modeType = null;
		String vvd 		= null;
		String pol		= null;
		String polYdcd	= null;
		String pod		= null;
		String podYdcd	= null;
		String blNo = null;
		
		
		// FlatFile 데이터 조회 - 조건 VO
		List<TransKeyVO> transKeyVOs = new ArrayList<TransKeyVO>();
		TransKeyVO transKeyVO = null;
		// FlatFile 저장 버퍼	
		String[] strFlatFile = null;
		StringBuffer flatFile = new StringBuffer();
		
		try {
			
			russiaManifestTranmitVO  = (RussiaManifestTransmitVO) manifestTransmitVO;
			russiaManifestListDetailVOs 	= russiaManifestTranmitVO.getRussiaManifestListDetailVOs();
			transKeyVO				= russiaManifestTranmitVO.getTransKeyVO();
	
			modeType 	= transKeyVO.getModeType();
			vvd 		= transKeyVO.getVvdCd();
			pol			= transKeyVO.getPolCd();
			polYdcd		= transKeyVO.getPolYdCd();
			pod			= transKeyVO.getPodCd();
			podYdcd		= transKeyVO.getPodYdCd();
	
			

			/***********************************************************************************************/
			/***********************전송 내역 검사***********************************************************/
			/***********************************************************************************************/
//			if(russiaBlInfoListVOs != null){			
//			
//				for ( int h=0; h < russiaBlInfoListVOs.length; h++ ) {
//					
//					blNo = russiaManifestListDetailVOs[h].getBlNo();
//					
////					int rsCnt = dbDao.searchSendLogVvd ( blNo , transMode );
//					
//					/**
//					 * B/L Inquiry 에서 송부하는 경우 Message Type 이 'Change'(5) or 'Delete'(3) 일 때
//					 * 전송내역 중에 Message Type 이 9 or 0 이 있으면  BKG06024 메세지를 보여주고 끝냄.
//					 */
////					if( "Y".equals(blFlag)){
////						if( msgType.equals(Constants.TransMsgType.CHANGE) || msgType.equals(Constants.TransMsgType.DELETE) ){
//////							if(rsCnt == 0){
//////								// Original MSG should be filed First. - [bl_no]
//////								throw new EventException(new ErrorHandler("BKG06041", new String[] {blNo}).getMessage());
//////							}
////						}
////						else if( msgType.equals(Constants.TransMsgType.ORIGINAL_POL) || msgType.equals(Constants.TransMsgType.ORIGINAL_POD) ){
//////							if(rsCnt == 1){
//////								// Original MFT already transmitted. Select other MSG Type. - [bl_no]
//////								throw new EventException(new ErrorHandler("BKG06042", new String[] {blNo}).getMessage());
//////							}
////						}
////					}
////					else{
////						if( msgType.equals(Constants.TransMsgType.CHANGE) || msgType.equals(Constants.TransMsgType.DELETE) ){
//////							if(rsCnt == 0){
//////								// Original MSG should be filed First. - [bl_no]
//////								throw new EventException(new ErrorHandler("BKG06041", new String[] {blNo}).getMessage());
//////							}
////						}
////					}
//				}
//			} //if
			
			// IN 절에 들어갈 bl_no 문자열 담은 VO 리스트 생성
			List<String> blNoList = generateBlNoList(russiaManifestListDetailVOs);
			
			if(blNoList != null){			
				for ( int g=0; g < blNoList.size(); g++ ) {
					transKeyVO = new TransKeyVO();
					transKeyVO.setVvdCd(vvd);
					transKeyVO.setModeType(modeType);
//					transKeyVO.setMsgType(msgType);
//					transKeyVO.setLocCd(locCd);
					transKeyVO.setPolCd(pol);
					transKeyVO.setPodCd(pod);
					//transKeyVO.setBkgPolCd(chinaManifestTranmitVO.getBkgPolCd());
					//transKeyVO.setBkgPodCd(chinaManifestTranmitVO.getBkgPodCd());
					transKeyVO.setBkgNo(blNoList.get(g));
//					transKeyVO.setOfcCd(account.getOfc_cd());
//					transKeyVO.setUsrId(account.getUsr_id());
					
					transKeyVOs.add(transKeyVO);
				}				
			} // if

			/***********************************************************************************************/
			/*******************************POL 분리 작업***************************************************/
			/***********************************************************************************************/
//			String pol = null;
//			List<String> polList = new ArrayList<String>();
//			
//
//	        /** trans_mode = D : CHINA 외 지역에서 POL기준으로 전송 
//	            trans_mode = O : CHINA 지역에서 POD 기준으로 전송
//	            trnss_mdoe = P : CHINA 지역에서 POL 기준으로 전송(pre-stowage) **/
//			if( "D".equals(transMode) ){
//				// trans_mode == 'D' 인 경우에만 pol List 를 조회
////				polList = dbDao.searchVvdInfo ( transKeyVOs );
//			}else{
//				// trans_mode != 'D' 이면 입력받은 pol을 List 에 등록
//				polList.add(locCd);
//			}
//			
//			if(polList != null){
			
				strFlatFile = new String[1];
				
				for ( int i=0; i < 1; i++ ) {
//					pol = polList.get(i);
					
					strFlatFile[i] = makeRussiaManifestTransmitFlatFile(transKeyVOs, transKeyVO);
//					flatFile = makeRussiaManifestTransmitFlatFile(transKeyVOs, pol);
					flatFile.append(strFlatFile[i]);
					
					/*==============================================================*/
					/* Queue 전송													*/
					/*==============================================================*/
					SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
					sendFlatFileVO.setFlatFile(strFlatFile[i]);
					sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_CNCUS.IBMMQ.QUEUE"));				
					
					flatFileAckVO = new BookingUtil().sendFlatFile(sendFlatFileVO);				
					
//					if("CNSHA".equals(transKeyVO.getLocCd()))
//					{		
//						SendFlatFileVO sendFlatFileVO1 = new SendFlatFileVO();
//						sendFlatFileVO1.setFlatFile(strFlatFile[i].replaceFirst("CHNCUS", "SHACUS"));
//						sendFlatFileVO1.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_CNCUS.IBMMQ.QUEUE"));
//						flatFileAckVO1 = new BookingUtil().sendFlatFile(sendFlatFileVO1);
//					}
					
//	 				if ( "E".equals(flatFileAckVO.getAckStsCd()) || (flatFileAckVO1 != null && "E".equals(flatFileAckVO1.getAckStsCd()))) {
//						throw new EventException(new ErrorHandler("BKG00205",new String[]{}).getMessage());
//					}
					
				} // for end : polList
//			}//if			
			return flatFile.toString();
			
		}
		catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		}
//		catch (DAOException ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("BKG06088", new String[]{}).getMessage(), ex);
//		}
//		catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("BKG06088", new String[]{}).getMessage(), ex);
//		}
	}

	/**
	 * POL 지역 별 FlatFile을 생성하여 리턴한다.
	 * 
	 * @param List<TransKeyVO> transKeyVOs 
	 * @param String pol 
	 * @return String
	 * @exception EventException
	 */
	private String makeRussiaManifestTransmitFlatFile( List<TransKeyVO> transKeyVOs, TransKeyVO transKeyVO ) throws EventException {

		// FlatFile 데이터 조회 - 조건 VO
//		TransKeyVO transKeyVO = null;
		
		// FlatFile 데이터 조회 - 리턴 VO
		RussiaVslInfoVO russiaVslInfoVO = null;
		RussiaCncusVvdVO russiaCncusVvdVO = null;
		BkgCstmsChnSndLogVO bkgCstmsChnSndLogVO = null;
		BkgCstmsChnSndLogBlVO bkgCstmsChnSndLogBlVO = null;
		BkgCstmsChnSndLogCntrVO bkgCstmsChnSndLogCntrVO = null;
		
		// 책임테이블 관련 ManisfestListDownloadBC 생성
		ManifestListDownloadBC downloadBC = new RussiaManifestListDownloadBCImpl();
		
		                         
		String modeType = null;  
		String vvd 		= null;  
//		String pol		= null;  
		String polYdcd	= null;  
		String pod		= null;  
		String podYdcd	= null;  
		String blNo = null;      
//		                         
		
		
		
		try {
				modeType 	= transKeyVO.getModeType();       
				vvd 		= transKeyVO.getVvdCd();          
//				pol			= transKeyVO.getPolCd();          
				polYdcd		= transKeyVO.getPolYdCd();        
				pod			= transKeyVO.getPodCd();          
				podYdcd		= transKeyVO.getPodYdCd();        
			                                                  
			
			
			
//			polCd		= russiaCncusVvdVO.getPolCd();
			// 추가
			
			/*============================================================== */
			/* Master Flat Buffer Creation					                 */
			/*============================================================== */
			/* Flat	File Header 및 VVD 정보	구성				             	 */
			/*============================================================== */

			// FlatFile Header를 생성한다.
			BookingUtil command = new BookingUtil();
			String header = command.searchCstmsEdiHeader("SML", "VLADIVOSTOK", "IFCSUM");
			StringBuffer flatFile = new StringBuffer();
			flatFile.append(header).append("\n");
			
//			ediRefId = header.substring(62);
			
			// 1.VSL/VVD정보 가져오기
			russiaVslInfoVO = dbDao.searchVslInfo ( transKeyVO );
			russiaCncusVvdVO = dbDao.searchCncusVvd ( transKeyVO );
//			sendDate = russiaCncusVvdVO.getSenddate();
//			transKeyVO.setSendDate(sendDate);

			if ( russiaCncusVvdVO != null) {
				flatFile.append("MSG_FUNC:")		.append("9")             					  		.append("\n");
				flatFile.append("VSLFULLNAME:")	    .append(russiaCncusVvdVO.getVslfullname())         .append("\n");
				flatFile.append("VSLCD:")		    .append(russiaCncusVvdVO.getVslcd())               .append("\n");
				flatFile.append("VSLVOY:")		    .append(russiaCncusVvdVO.getVslvoy())              .append("\n");
				flatFile.append("VSLDIR:")		    .append(russiaCncusVvdVO.getVsldir())              .append("\n");
				flatFile.append("CALLSIGN:")		.append(russiaCncusVvdVO.getCallsign())            .append("\n");
				flatFile.append("SENDDATE:")		.append(russiaCncusVvdVO.getSenddate())            .append("\n");
				flatFile.append("NATION_CODE:")	    .append(russiaVslInfoVO.getNationCd())	          .append("\n");
				flatFile.append("REP_PERSON:")	    .append(russiaCncusVvdVO.getRepPerson())           .append("\n");
				flatFile.append("POL:")			    .append(russiaCncusVvdVO.getPol())                 .append("\n");
				flatFile.append("POLNAME:")		    .append(russiaCncusVvdVO.getPolname())             .append("\n");
				flatFile.append("POL_ETD:")		    .append(russiaCncusVvdVO.getPolEtd())              .append("\n");
				flatFile.append("FPORT_IN_CHN:")	.append(russiaVslInfoVO.getFstPort())         	  .append("\n");
				flatFile.append("FPORT_NAME:")	    .append(russiaVslInfoVO.getFstPortNm())            .append("\n");
				flatFile.append("FPORT_ARRV_DT:")   .append(russiaVslInfoVO.getFstArrDt())        	  .append("\n");
				
				flatFile.append("PPORT:")		    .append("")               .append("\n");
				flatFile.append("PPORTNAME:")	    .append("")           .append("\n");
				
				flatFile.append("NPORT:")		    .append("RUVVO")               .append("\n");
				flatFile.append("NPORTNAME:")	    .append("VLADIVOSTOK")           .append("\n");
				
				if(transKeyVO.getModeType().equals("I")){
					flatFile.append("ETA:")			    .append(russiaCncusVvdVO.getPodEta())                 .append("\n");
					flatFile.append("ETD:")			    .append(russiaCncusVvdVO.getPodEtd())                 .append("\n");
				}else {
					flatFile.append("ETA:")			    .append(russiaCncusVvdVO.getPolEta())                 .append("\n");
					flatFile.append("ETD:")			    .append(russiaCncusVvdVO.getPolEtd())                 .append("\n");
				}
				
				
				flatFile.append("IMO_NO:")		    .append(russiaCncusVvdVO.getImoNo())               .append("\n");
				flatFile.append("LANE:")			.append(russiaCncusVvdVO.getLane())                .append("\n");
			}


			/*==============================================================*/
			/* BL TRANS IND	UPDATE											*/
			/*==============================================================*/
			/* DEL별로 관리되는 Trans. Mode를 구한다							*/
			/*	- Barge, Rail, Truck, International T/S						*/
			/*==============================================================*/
//			downloadBC.modifyBl ( transKeyVOs );


			/*==============================================================*/
			/* BL 별 flatFile 데이터 생성										*/
			/*==============================================================*/
//			List<RussiaCncusBlListVO> russiaCncusBlListVOs = dbDao.searchRussiaBl (transKeyVOs , transKeyVO );
			List<RussiatransmitBlListVO> russiatransmitBlListVOs = dbDao.searchRussiaBl(transKeyVOs , transKeyVO );
			
			if(russiatransmitBlListVOs.size() > 0){
//
//				String[] blData = null;
//				String[] podRout = null;
//				
				for ( int j=0; j < russiatransmitBlListVOs.size(); j++ ) {
//					
					blNo = russiatransmitBlListVOs.get(j).getBkgNo();
//					blData = russiaCncusBlListVOs.get(j).getBlData().split("\t");
//					podRout = blData[32].split(";");

					/*********************************/
					/** Flat File 생성 - B/L	Body 	**/
					/*********************************/
						flatFile.append("{BL_INFO")			.append("\n");
						flatFile.append("BLNBR:")		    .append(russiatransmitBlListVOs.get(j).getBkgNo())    .append("\n");                     
						flatFile.append("BOARDDATE:")	    .append(russiatransmitBlListVOs.get(j).getVpsEtbDt())    .append("\n");
						flatFile.append("BLPOD_ETA:")       .append(russiatransmitBlListVOs.get(j).getBlPodEtaDt())    .append("\n");
						flatFile.append("ISSUEDATE:")	    .append(russiatransmitBlListVOs.get(j).getBlIssDt())    .append("\n");
						flatFile.append("ISSUE_LOC:")	    .append(russiatransmitBlListVOs.get(j).getBlIssLocCd())    .append("\n");
						flatFile.append("ISSUE_LOC_NAME:")  .append(russiatransmitBlListVOs.get(j).getBlIssLocNm())    .append("\n");
						flatFile.append("BLPOR:")		    .append("RUVVO")    .append("\n");
						flatFile.append("BLPORNAME:")	    .append("VLADIVOSTOK")    .append("\n");
						
						flatFile.append("BLPOL:")		    .append(russiatransmitBlListVOs.get(j).getBkgPolCd())    .append("\n");
						flatFile.append("BLPOLNAME:")	    .append(russiatransmitBlListVOs.get(j).getPolNm())    .append("\n");
						
						flatFile.append("BLPOD:")		    .append(russiatransmitBlListVOs.get(j).getBkgPodCd())   .append("\n");
						flatFile.append("BLPODNAME:")	    .append(russiatransmitBlListVOs.get(j).getPodNm())   .append("\n");
						flatFile.append("BLDEL:")		    .append(russiatransmitBlListVOs.get(j).getDelCd())   .append("\n");
						flatFile.append("BLDELNAME:")       .append(russiatransmitBlListVOs.get(j).getDelNm())   .append("\n");
						
						flatFile.append("TRANS_IND:")       .append("")   .append("\n");
						flatFile.append("RDTERM:")		    .append(russiatransmitBlListVOs.get(j).getRdTerm())   .append("\n");
						
						flatFile.append("PRFLAG:")		    .append(russiatransmitBlListVOs.get(j).getPrflag())   .append("\n");
						
						flatFile.append("SHPR1:")	        .append(russiatransmitBlListVOs.get(j).getSCustNm())   .append("\n");
						flatFile.append("SHPR2:")	        .append(russiatransmitBlListVOs.get(j).getSCustAddr())   .append("\n");
//						flatFile.append("SHPR3:")	        .append("")  .append("\n");
//						flatFile.append("SHPR4:")	        .append("")   .append("\n");
//						flatFile.append("SHPR5:")	        .append("")   .append("\n");
						flatFile.append("CNEE1:")	        .append(russiatransmitBlListVOs.get(j).getCCustNm())   .append("\n");
						flatFile.append("CNEE2:")	        .append(russiatransmitBlListVOs.get(j).getCCustAddr())   .append("\n");
//						flatFile.append("CNEE3:")	        .append("")   .append("\n");
//						flatFile.append("CNEE4:")	        .append("")   .append("\n");
//						flatFile.append("CNEE5:")	        .append("")   .append("\n");
						flatFile.append("NTFY1:")	        .append(russiatransmitBlListVOs.get(j).getNCustNm())   .append("\n");
						flatFile.append("NTFY2:")	        .append(russiatransmitBlListVOs.get(j).getNCustAddr())   .append("\n");
//						flatFile.append("NTFY3:")	        .append("")   .append("\n");
//						flatFile.append("NTFY4:")	        .append("")   .append("\n");
//						flatFile.append("NTFY5:")	        .append("")   .append("\n");						
				
//						for( int k=0; k < podRout.length; k++ ) {
//							if(podRout[k].startsWith("PORT")){
//								podRout[k] = podRout[k].substring(podRout[k].indexOf(":")+1);
//							}
						
//							flatFile.append("PORT").append(k+1).append(":")		.append(podRout[k])		.append("\n");
//							flatFile.append("PORT"). append("\n");
							
//						}
							flatFile.append("{CGO_INFO")		.append("\n");
							flatFile.append("DESC1:")		    .append(russiatransmitBlListVOs.get(j).getCstmsDesc())   .append("\n");
							flatFile.append("MARK1:")		    .append(russiatransmitBlListVOs.get(j).getBlMkDesc())   .append("\n");
//							flatFile.append("MARK2:")		    .append("")   .append("\n");
//							flatFile.append("MARK3:")		    .append("")   .append("\n");
//							flatFile.append("MARK4:")		    .append("")   .append("\n");
//							flatFile.append("MARK5:")		    .append("")   .append("\n");
							flatFile.append("BLWGT:")		    .append(russiatransmitBlListVOs.get(j).getActWgt())   .append("\n");
							flatFile.append("BLPKG:")		    .append(russiatransmitBlListVOs.get(j).getPckQty())   .append("\n");
							flatFile.append("BLPKGU:")		    .append(russiatransmitBlListVOs.get(j).getPckTpCd())   .append("\n");
							flatFile.append("BLPKGU_NM:")		.append(russiatransmitBlListVOs.get(j).getBlpkguNm())   .append("\n");
//							flatFile.append("BLPKGU_NM:")		.append("")   .append("\n");
//							flatFile.append("REEFER_IND:")	    .append("")   .append("\n");
//							flatFile.append("REEFER:")		    .append("")   .append("\n");
//							flatFile.append("RUNIT:")	        .append("")   .append("\n");
							
							flatFile.append("BLMEA:")	        .append(russiatransmitBlListVOs.get(j).getMeasQty())   .append("\n");
//							flatFile.append("GOODNO:")		    .append("")   .append("\n");
							flatFile.append("}CGO_INFO")		.append("\n");
						

				

						/*****************************************************/
						/** Flat File 생성 - Special Cargo Info.	(위험화물) 	**/
						/*****************************************************/
						List<RussiaCncusDangerCntrVO> russiaCncusDangerCntrVOs = dbDao.searchCncusDangerCntr ( blNo  );
//
						if(russiaCncusDangerCntrVOs.size() > 0) {
							for ( int k=0; k < russiaCncusDangerCntrVOs.size(); k++ ) {
									
									flatFile.append("{SPEC_INFO")		.append("\n");       
									flatFile.append("CLASS:")		    .append(russiaCncusDangerCntrVOs.get(k).getClss())          .append("\n");
									flatFile.append("PAGE:")		    .append(russiaCncusDangerCntrVOs.get(k).getPage())          .append("\n");
									flatFile.append("UNDGNO:")		    .append(russiaCncusDangerCntrVOs.get(k).getUndgno())        .append("\n");
									flatFile.append("LABEL:")		    .append(russiaCncusDangerCntrVOs.get(k).getLabel())         .append("\n");
									flatFile.append("FLASH_POINT:")		.append(russiaCncusDangerCntrVOs.get(k).getFlashPoint())	   .append("\n");
									flatFile.append("EMS_NO:")			.append(russiaCncusDangerCntrVOs.get(k).getEmsNo())	   	   .append("\n");
									flatFile.append("CONTACT_NAME:")    .append(russiaCncusDangerCntrVOs.get(k).getContactName())   .append("\n");
									flatFile.append("CONTACT_TEL:")	    .append(russiaCncusDangerCntrVOs.get(k).getContactTel())    .append("\n");
									flatFile.append("}SPEC_INFO")       .append("\n");
									
							}
						}
						

						
						/********************************/
						/** Flat File 생성 - Container **/
						/********************************/
						List<RussiaCncusCntrVO> russiaCncusCntrVOs = dbDao.searchCncusCntr ( blNo );
						
						String[] cntrData = null;
						String cntrNo = null;
						
						String[] multiCntrSealNo = null;
						String[] multiCntrSealKindCd = null;
						String[] multiCntrSealerCd = null;
						
						String sealnbr = "";
						String sealkind = "";
						String sealer = "";
												
						if(russiaCncusCntrVOs.size() > 0) {
							for ( int k=0; k < russiaCncusCntrVOs.size(); k++ ) {
								
//								cntrData = russiaCncusCntrVOs.get(k).getCntrData().split("\t");
//								cntrNo = russiaCncusCntrVOs.get(k).getCntrNo();
								
								// 멀티 SealNo, SealKindCd, SealerCd를 @ 구분자로 분리한다.
								multiCntrSealNo = russiaCncusCntrVOs.get(k).getCntrSealNo().split("@");
//								multiCntrSealKindCd = cntrData[2].split("@");
//								multiCntrSealerCd = cntrData[3].split("@");
								
								int cntrSealNOMaxCnt = multiCntrSealNo.length;
								
								if(cntrSealNOMaxCnt > 0) {
                                    sealnbr = multiCntrSealNo[0];
//                                    sealkind = (multiCntrSealKindCd.length > 0 ) ? multiCntrSealKindCd[0] : "";
//                                    sealer = (multiCntrSealerCd.length > 0 ) ? multiCntrSealerCd[0] :  "";
								} 
//								else {
//									sealnbr = "";
//									sealkind = "";
//									sealer = "";
//								}
																								
									flatFile.append("{CNTR_INFO")       .append("\n");   
									flatFile.append("CNTRNBR:")         .append(russiaCncusCntrVOs.get(k).getCntrNo())          .append("\n");
									flatFile.append("SEALNBR:")         .append(sealnbr)              .append("\n");
//									flatFile.append("SEALKIND:")        .append(russiaCncusCntrVOs.get(k).)             .append("\n");
//									flatFile.append("SEALER:")          .append(russiaCncusCntrVOs.get(k).)               .append("\n");
									flatFile.append("CNTRTYPE:")        .append(russiaCncusCntrVOs.get(k).getCntrTpszIsoCd())          .append("\n");
									flatFile.append("LDMT:")		    .append(russiaCncusCntrVOs.get(k).getFullMtyCd())          .append("\n");
									flatFile.append("CNTRWGT:")	        .append(russiaCncusCntrVOs.get(k).getCntrWgt())          .append("\n");
									flatFile.append("TWGT:")	        .append(russiaCncusCntrVOs.get(k).getTareWgt())          .append("\n");
									flatFile.append("OVF:")	            .append(russiaCncusCntrVOs.get(k).getOvrDimFntLen())          .append("\n");
									flatFile.append("OVR:")	            .append(russiaCncusCntrVOs.get(k).getOvrDimRearLen())          .append("\n");
									flatFile.append("OVH:")	            .append(russiaCncusCntrVOs.get(k).getOvrHgt())         .append("\n");
									flatFile.append("OVLW:")		    .append(russiaCncusCntrVOs.get(k).getOvrDimLfLen())         .append("\n");
									flatFile.append("OVRW:")		    .append(russiaCncusCntrVOs.get(k).getOvrDimRtLen())         .append("\n");
									flatFile.append("CNTRMEA:")	        .append(russiaCncusCntrVOs.get(k).getCntrMeasQty())         .append("\n");
//									flatFile.append("CGOODNO:")	        .append()         .append("\n");
									flatFile.append("PKGQTY:")	        .append(russiaCncusCntrVOs.get(k).getPkgQty())         .append("\n");
									
			
									
								// 멀티 Seal NO 갯수만큼 SealNo, SealKind, SealerCD가 생성되어진다.
									if(cntrSealNOMaxCnt > 0) {
                                        for(int sealIdx = 0; sealIdx < cntrSealNOMaxCnt; sealIdx++) {
                                                   flatFile.append("{CNTR_SEAL_NO").append("\n");
                                                   flatFile.append("SEAL_NO:").append(multiCntrSealNo[sealIdx]).append("\n");
                                                   
//                                                 flatFile.append("SEAL_KIND:").append((multiCntrSealKindCd.length > sealIdx) ? multiCntrSealKindCd[sealIdx].trim() : "").append("\n");
//                                                 flatFile.append("SEALER_CD:").append((multiCntrSealerCd.length > sealIdx) ? multiCntrSealerCd[sealIdx].trim() : "").append("\n");
                                                   flatFile.append("}CNTR_SEAL_NO").append("\n");

                                        }                                                                                                         
									}

								flatFile.append("}CNTR_INFO")       .append("\n");  
								
							}
						}
						
						//[CHM-201111935] 수정 및 삭제 시 Amend code 출력 
//						if(!"9".equals(msgType) && !"0".equals(msgType)){
//							flatFile.append("AMEND_CODE:999")			.append("\n");
//						}
						
						//[CHM-201113536] Multi-Commodity bkg 관련 로직변경 요청 
						
						List<RussiaCMCntrVO> russiaCMCntrVOs = dbDao.searchCMCntr ( blNo );
//						
						if(russiaCMCntrVOs.size() > 0) {
							for ( int k=0; k < russiaCMCntrVOs.size(); k++ ) {

									flatFile.append("{CM_INFO")       .append("\n");   
									flatFile.append("CM_SEQ:")    		.append(russiaCMCntrVOs.get(k).getCntrMfSeq())          .append("\n");
									flatFile.append("CM_DESC1:")        .append(russiaCMCntrVOs.get(k).getCntrMfGdsDesc())      .append("\n");
									flatFile.append("CM_MARK1:")        .append(russiaCMCntrVOs.get(k).getCntrMfMkDesc1())       .append("\n");
									flatFile.append("CM_MARK2:")        .append(russiaCMCntrVOs.get(k).getCntrMfMkDesc2())       .append("\n");
									flatFile.append("CM_MARK3:")        .append(russiaCMCntrVOs.get(k).getCntrMfMkDesc3())       .append("\n");
									flatFile.append("CM_MARK4:")		.append(russiaCMCntrVOs.get(k).getCntrMfMkDesc4())       .append("\n");
									flatFile.append("CM_MARK5:")	    .append(russiaCMCntrVOs.get(k).getCntrMfMkDesc5())       .append("\n");
									flatFile.append("CM_WGT:")	        .append(russiaCMCntrVOs.get(k).getCntrMfWgt())          .append("\n");
									flatFile.append("CM_PKG:")	        .append(russiaCMCntrVOs.get(k).getPckQty())        	   .append("\n");
									flatFile.append("CM_PKG_U:")	    .append(russiaCMCntrVOs.get(k).getPckTpCd())            .append("\n");
									flatFile.append("CM_REEFER_IND:")	.append(russiaCMCntrVOs.get(k).getRcFlg())         	   .append("\n");
									flatFile.append("CM_REEFER:")		.append(russiaCMCntrVOs.get(k).getDoTemp())             .append("\n");
									flatFile.append("CM_RUNIT:")		.append(russiaCMCntrVOs.get(k).getTempUn())             .append("\n");
									flatFile.append("CM_MEA:")	        .append(russiaCMCntrVOs.get(k).getMeasQty())            .append("\n");
									flatFile.append("CM_GOODNO:")	    .append(russiaCMCntrVOs.get(k).getGoodno())             .append("\n");
								flatFile.append("}CM_INFO")			.append("\n");
								
								
							}
						}
							
						flatFile.append("}BL_INFO")			.append("\n");

//						downloadBC.modifyBl2(transKeyVOs, pol);
//						downloadBC.modifyVvd(transKeyVO, pol);
						
				} // for end : chinaCncusBlListVOs
			} // if end

			return flatFile.toString();
		}
//		catch (DAOException ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("BKG06088",new String[]{}).getMessage(), ex);
//		}
		catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("BKG06088", new String[]{}).getMessage(), e);
		}
	}

    /**
     *  IN 절에 들어갈 BL_NO 문자열로 생성
     *  IN 절에 데이터가 1000건 이상이면 ORA-1795 오류 발생하므로
     *  1000건씩 컴마로 연결된 문자열을 생성하여 넘긴다.
     *  
	 * @param ChinaBlInfoListVO[] blInfoVOs 
	 * @return List<String>
	 * @exception EventException
     */
	@SuppressWarnings("unchecked")
	private List<String> generateBlNoList(RussiaManifestListDetailVO[] russiaManifestListDetailVOs) throws EventException {
		try{
			List<String> arrString = new ArrayList();  //BKG_NO
			StringBuffer sb = new StringBuffer();
			int bkgCnt = russiaManifestListDetailVOs.length;
			int quotaCnt = bkgCnt / 1000;
			int restCnt = bkgCnt % 1000;
			
			for (int i=1; i<=quotaCnt; i++) {
				sb.delete(0, sb.length());
				for (int j=i*1000-1000; j<i*1000; j++) {	
					if(j == i*1000-1000){
						sb.append("'").append(russiaManifestListDetailVOs[j].getBkgNo()).append("'");
					}else{
						sb.append(",'").append(russiaManifestListDetailVOs[j].getBkgNo()).append("'");
					}
				}
				arrString.add(sb.toString());
			}
			
			if(restCnt > 0){
				sb.delete(0, sb.length());
				for (int i=quotaCnt*1000; i<bkgCnt; i++) {	
					if(i == quotaCnt*1000){
						sb.append("'").append(russiaManifestListDetailVOs[i].getBkgNo()).append("'");
					}else{
						sb.append(",'").append(russiaManifestListDetailVOs[i].getBkgNo()).append("'");
					}
				}
				arrString.add(sb.toString());
			}    
			
			return arrString;
		}
		catch (Exception e)	{
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), e);
		}
	}
}