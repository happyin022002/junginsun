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
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.common.Constants;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.integration.ChinaCustomsTransmissionDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlInfoListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaCMCntrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaCncusBlListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaCncusCntrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaCncusDangerCntrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaCncusVvdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaVslInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo.TransKeyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.basic.ManifestListDownloadBC;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.basic.ChinaManifestListDownloadBCImpl;
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
public class ChinaCustomsTransmissionBackEndJob extends BackEndCommandSupport {
	private static final long serialVersionUID = -3034414164961318353L;
	private ManifestTransmitVO manifestTransmitVO;
	private SignOnUserAccount account;

	// Database Access Object
	private ChinaCustomsTransmissionDBDAO dbDao = null;
	
	/**
	 * 다운로드 할 데이터 세팅
	 * 
	 * @param manifestListDetailVOs
	 * @param account
	 */
	public void setManifestTransmitVO(ManifestTransmitVO manifestTransmitVO, SignOnUserAccount account, ChinaCustomsTransmissionDBDAO dbDao) {
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
		ChinaManifestTransmitVO chinaManifestTranmitVO = null;
		ChinaBlInfoListVO[] chinaBlInfoListVOs = null;
		String blNo = null;
		String transMode = null;
		String msgType = null;
		String vvd = null;
		String locCd = null;
		String blFlag = null;
		
		// FlatFile 데이터 조회 - 조건 VO
		List<TransKeyVO> transKeyVOs = new ArrayList<TransKeyVO>();
		TransKeyVO transKeyVO = null;
		// FlatFile 저장 버퍼	
		String[] strFlatFile = null;
		StringBuffer flatFile = new StringBuffer();
		
		try {
			chinaManifestTranmitVO  = (ChinaManifestTransmitVO)manifestTransmitVO;
			chinaBlInfoListVOs 		= chinaManifestTranmitVO.getChinaBlInfoListVOs();
			transKeyVO				= chinaManifestTranmitVO.getTransKeyVO();
			transMode 	= transKeyVO.getTransMode();
			msgType 	= transKeyVO.getMsgType();
			vvd			= transKeyVO.getVvd();
			locCd		= transKeyVO.getLocCd();
			blFlag		= transKeyVO.getBlFlag();
			

			/***********************************************************************************************/
			/***********************전송 내역 검사***********************************************************/
			/***********************************************************************************************/
			if(chinaBlInfoListVOs != null){			
			
				for ( int h=0; h < chinaBlInfoListVOs.length; h++ ) {
					
					blNo = chinaBlInfoListVOs[h].getBlNo();
					
					int rsCnt = dbDao.searchSendLogVvd ( blNo , transMode );
					
					/**
					 * B/L Inquiry 에서 송부하는 경우 Message Type 이 'Change'(5) or 'Delete'(3) 일 때
					 * 전송내역 중에 Message Type 이 9 or 0 이 있으면  BKG06024 메세지를 보여주고 끝냄.
					 */
					if( "Y".equals(blFlag)){
						if( msgType.equals(Constants.TransMsgType.CHANGE) || msgType.equals(Constants.TransMsgType.DELETE) ){
							if(rsCnt == 0){
								// Original MSG should be filed First. - [bl_no]
								throw new EventException(new ErrorHandler("BKG06041", new String[] {blNo}).getMessage());
							}
						}
						else if( msgType.equals(Constants.TransMsgType.ORIGINAL_POL) || msgType.equals(Constants.TransMsgType.ORIGINAL_POD) ){
							if(rsCnt == 1){
								// Original MFT already transmitted. Select other MSG Type. - [bl_no]
								throw new EventException(new ErrorHandler("BKG06042", new String[] {blNo}).getMessage());
							}
						}
					}
					else{
						if( msgType.equals(Constants.TransMsgType.CHANGE) || msgType.equals(Constants.TransMsgType.DELETE) ){
							if(rsCnt == 0){
								// Original MSG should be filed First. - [bl_no]
								throw new EventException(new ErrorHandler("BKG06041", new String[] {blNo}).getMessage());
							}
						}
					}
				}
			} //if
			
			// IN 절에 들어갈 bl_no 문자열 담은 VO 리스트 생성
			List<String> blNoList = generateBlNoList(chinaBlInfoListVOs);
			
			if(blNoList != null){			
				for ( int g=0; g < blNoList.size(); g++ ) {
					transKeyVO = new TransKeyVO();
					transKeyVO.setVvd(vvd);
					transKeyVO.setTransMode(transMode);
					transKeyVO.setMsgType(msgType);
					transKeyVO.setLocCd(locCd);
					//transKeyVO.setBkgPolCd(chinaManifestTranmitVO.getBkgPolCd());
					//transKeyVO.setBkgPodCd(chinaManifestTranmitVO.getBkgPodCd());
					transKeyVO.setBlNo(blNoList.get(g));
					transKeyVO.setOfcCd(account.getOfc_cd());
					transKeyVO.setUsrId(account.getUsr_id());
					
					transKeyVOs.add(transKeyVO);
				}				
			} // if

			/***********************************************************************************************/
			/*******************************POL 분리 작업***************************************************/
			/***********************************************************************************************/
			String pol = null;
			List<String> polList = new ArrayList<String>();
			

			/**
			 * trans_mode = O : CHINA 외 지역에서 POL 기준으로 전송(Origin)
			 * trans_mode = D : CHINA 외 지역에서 POD기준으로 전송  (Destination)
			 * trnss_mdoe = P : CHINA 지역에서 POL 기준으로 전송(pre-stowage) **/
			if( "D".equals(transMode) ){
				// trans_mode == 'D' 인 경우에만 pol List 를 조회
				polList = dbDao.searchVvdInfo ( transKeyVOs );
			}else{
				// trans_mode != 'D' 이면 입력받은 pol을 List 에 등록
				polList.add(locCd);
			}
			
			if(polList != null){
			
				strFlatFile = new String[polList.size()];
				
				for ( int i=0; i < polList.size(); i++ ) {
					pol = polList.get(i);
					
					strFlatFile[i] = makeChinaManifestTransmitFlatFile(transKeyVOs, pol);
					flatFile.append(strFlatFile[i]);
					
					/*==============================================================*/
					/* Queue 전송													*/
					/*==============================================================*/
					SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
					sendFlatFileVO.setFlatFile(strFlatFile[i]);
					sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_CNCUS.IBMMQ.QUEUE"));				
					
					flatFileAckVO = new BookingUtil().sendFlatFile(sendFlatFileVO);				
					
					if("CNSHA".equals(transKeyVO.getLocCd()))
					{		
						SendFlatFileVO sendFlatFileVO1 = new SendFlatFileVO();
						sendFlatFileVO1.setFlatFile(strFlatFile[i].replaceFirst("CHNCUS", "SHACUS"));
						sendFlatFileVO1.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_CNCUS.IBMMQ.QUEUE"));
						flatFileAckVO1 = new BookingUtil().sendFlatFile(sendFlatFileVO1);
					}

					if("CNNBO".equals(transKeyVO.getLocCd()))
					{		
						SendFlatFileVO sendFlatFileVO1 = new SendFlatFileVO();
						sendFlatFileVO1.setFlatFile(strFlatFile[i].replaceFirst("CHNCUS", "NBOCUS"));
						sendFlatFileVO1.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_CNCUS.IBMMQ.QUEUE"));
						flatFileAckVO1 = new BookingUtil().sendFlatFile(sendFlatFileVO1);
					}
					
	 				if ( "E".equals(flatFileAckVO.getAckStsCd()) || (flatFileAckVO1 != null && "E".equals(flatFileAckVO1.getAckStsCd()))) {
						throw new EventException(new ErrorHandler("BKG00205",new String[]{}).getMessage());
					}
					
				} // for end : polList
			}//if			
			return flatFile.toString();
			
		}
		catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		}
		catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[]{}).getMessage(), ex);
		}
		catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * POL 지역 별 FlatFile을 생성하여 리턴한다.
	 * 
	 * @param List<TransKeyVO> transKeyVOs 
	 * @param String pol 
	 * @return String
	 * @exception EventException
	 */
	private String makeChinaManifestTransmitFlatFile( List<TransKeyVO> transKeyVOs, String pol ) throws EventException {

		// FlatFile 데이터 조회 - 조건 VO
		TransKeyVO transKeyVO = null;
		
		// FlatFile 데이터 조회 - 리턴 VO
		ChinaVslInfoVO chinaVslInfoVO = null;
		ChinaCncusVvdVO chinaCncusVvdVO = null;
		BkgCstmsChnSndLogVO bkgCstmsChnSndLogVO = null;
		BkgCstmsChnSndLogBlVO bkgCstmsChnSndLogBlVO = null;
		BkgCstmsChnSndLogCntrVO bkgCstmsChnSndLogCntrVO = null;
		
		// 책임테이블 관련 ManisfestListDownloadBC 생성
		ManifestListDownloadBC downloadBC = new ChinaManifestListDownloadBCImpl();
		
		String vvd 			= null;
		String transMode 	= null;
		String msgType 		= null;
		String ediRefId 	= null;
		String ofcCd 		= null;
		String usrId 		= null;
		String blNo			= null;
		String sendDate		= null;
		
		try {
			transKeyVO  = transKeyVOs.get(0);
			vvd 		= transKeyVO.getVvd();
			transMode 	= transKeyVO.getTransMode();
			msgType 	= transKeyVO.getMsgType();
			ofcCd	 	= transKeyVO.getOfcCd();
			usrId	 	= transKeyVO.getUsrId();
			blNo		= transKeyVO.getBlNo();		// 추가
			
			/*============================================================== */
			/* Master Flat Buffer Creation					                 */
			/*============================================================== */
			/* Flat	File Header 및 VVD 정보	구성				             	 */
			/*============================================================== */

			// FlatFile Header를 생성한다.
			BookingUtil command = new BookingUtil();
			String header = command.searchCstmsEdiHeader("SML", "CHNCUS", "IFCSUM");
			StringBuffer flatFile = new StringBuffer();
			flatFile.append(header).append("\n");
			
			ediRefId = header.substring(62);
			
			// 1.VSL/VVD정보 가져오기
			chinaVslInfoVO = dbDao.searchVslInfo ( vvd );
			chinaCncusVvdVO = dbDao.searchCncusVvd ( transKeyVO, pol );
			sendDate = chinaCncusVvdVO.getSenddate();
//			transKeyVO.setSendDate(sendDate);

			if ( chinaCncusVvdVO != null) {
				flatFile.append("MSG_FUNC:")		.append(msgType)             					  .append("\n");
				flatFile.append("VSLFULLNAME:")	    .append(chinaCncusVvdVO.getVslfullname())         .append("\n");
				flatFile.append("VSLCD:")		    .append(chinaCncusVvdVO.getVslcd())               .append("\n");
				flatFile.append("VSLVOY:")		    .append(chinaCncusVvdVO.getVslvoy())              .append("\n");
				flatFile.append("VSLDIR:")		    .append(chinaCncusVvdVO.getVsldir())              .append("\n");
				flatFile.append("CALLSIGN:")		.append(chinaCncusVvdVO.getCallsign())            .append("\n");
				flatFile.append("SENDDATE:")		.append(chinaCncusVvdVO.getSenddate())            .append("\n");
				flatFile.append("NATION_CODE:")	    .append(chinaVslInfoVO.getNationCd())	          .append("\n");
				flatFile.append("REP_PERSON:")	    .append(chinaCncusVvdVO.getRepPerson())           .append("\n");
				flatFile.append("POL:")			    .append(chinaCncusVvdVO.getPol())                 .append("\n");
				flatFile.append("POLNAME:")		    .append(chinaCncusVvdVO.getPolname())             .append("\n");
				flatFile.append("POL_ETD:")		    .append(chinaCncusVvdVO.getPolEtd())              .append("\n");
				flatFile.append("FPORT_IN_CHN:")	.append(chinaVslInfoVO.getFstPort())         	  .append("\n");
				flatFile.append("FPORT_NAME:")	    .append(chinaVslInfoVO.getFstPortNm())            .append("\n");
				flatFile.append("FPORT_ARRV_DT:")   .append(chinaVslInfoVO.getFstArrDt())        	  .append("\n");
				flatFile.append("PPORT:")		    .append(chinaCncusVvdVO.getPport())               .append("\n");
				flatFile.append("PPORTNAME:")	    .append(chinaCncusVvdVO.getPportname())           .append("\n");
				flatFile.append("NPORT:")		    .append(chinaCncusVvdVO.getNport())               .append("\n");
				flatFile.append("NPORTNAME:")	    .append(chinaCncusVvdVO.getNportname())           .append("\n");
				flatFile.append("ETA:")			    .append(chinaCncusVvdVO.getEta())                 .append("\n");
				flatFile.append("ETD:")			    .append(chinaCncusVvdVO.getEtd())                 .append("\n");
				flatFile.append("IMO_NO:")		    .append(chinaCncusVvdVO.getImoNo())               .append("\n");
				flatFile.append("LANE:")			.append(chinaCncusVvdVO.getLane())                .append("\n");
			}

			/*===============================================================*/
			/*                      LOG 저장                                 					 */
			/*===============================================================*/
			bkgCstmsChnSndLogVO = new BkgCstmsChnSndLogVO();
			bkgCstmsChnSndLogVO.setEdiRefId(ediRefId);
			bkgCstmsChnSndLogVO.setChnMfSndIndCd(transMode);
			bkgCstmsChnSndLogVO.setMfSndDt(sendDate);
			bkgCstmsChnSndLogVO.setMfSndOfcCd(ofcCd);
			bkgCstmsChnSndLogVO.setMfSndUsrId(usrId);
			bkgCstmsChnSndLogVO.setTrsmMsgTpId(msgType);
			bkgCstmsChnSndLogVO.setVslCd(vvd);
			bkgCstmsChnSndLogVO.setBkgPolCd(pol);
			bkgCstmsChnSndLogVO.setCreUsrId(usrId);
			bkgCstmsChnSndLogVO.setUpdUsrId(usrId);
			dbDao.addSendLogVvd ( bkgCstmsChnSndLogVO, blNo );
			

			/*==============================================================*/
			/* BL TRANS IND	UPDATE											*/
			/*==============================================================*/
			/* DEL별로 관리되는 Trans. Mode를 구한다							*/
			/*	- Barge, Rail, Truck, International T/S						*/
			/*==============================================================*/
			downloadBC.modifyBl ( transKeyVOs );


			/*==============================================================*/
			/* BL 별 flatFile 데이터 생성										*/
			/*==============================================================*/
			List<ChinaCncusBlListVO> chinaCncusBlListVOs = dbDao.searchCncusBl ( transKeyVOs , pol );
			
			if(chinaCncusBlListVOs.size() > 0){

				String[] blData = null;
				String[] podRout = null;
				
				for ( int j=0; j < chinaCncusBlListVOs.size(); j++ ) {
					
					blNo = chinaCncusBlListVOs.get(j).getBlNo();
					blData = chinaCncusBlListVOs.get(j).getBlData().split("\t");
					podRout = blData[32].split(";");

					/*********************************/
					/** Flat File 생성 - B/L	Body 	**/
					/*********************************/
					flatFile.append("{BL_INFO")			.append("\n");
						flatFile.append("BLNBR:")		    .append(blData[0])    .append("\n");                     
						flatFile.append("BOARDDATE:")	    .append(blData[1])    .append("\n");
						flatFile.append("BLPOD_ETA:")       .append(blData[2])    .append("\n");
						flatFile.append("ISSUEDATE:")	    .append(blData[3])    .append("\n");
						flatFile.append("ISSUE_LOC:")	    .append(blData[4])    .append("\n");
						flatFile.append("ISSUE_LOC_NAME:")  .append(blData[5])    .append("\n");
						flatFile.append("BLPOR:")		    .append(blData[6])    .append("\n");
						flatFile.append("BLPORNAME:")	    .append(blData[7])    .append("\n");
						flatFile.append("BLPOL:")		    .append(blData[8])    .append("\n");
						flatFile.append("BLPOLNAME:")	    .append(blData[9])    .append("\n");
						flatFile.append("BLPOD:")		    .append(blData[10])   .append("\n");
						flatFile.append("BLPODNAME:")	    .append(blData[11])   .append("\n");
						flatFile.append("BLDEL:")		    .append(blData[12])   .append("\n");
						flatFile.append("BLDELNAME:")       .append(blData[13])   .append("\n");
						flatFile.append("TRANS_IND:")       .append(blData[14])   .append("\n");
						flatFile.append("RDTERM:")		    .append(blData[15])   .append("\n");
						flatFile.append("PRFLAG:")		    .append(blData[16])   .append("\n");
						flatFile.append("SHPR1:")	        .append(blData[17])   .append("\n");
						flatFile.append("SHPR2:")	        .append(blData[18])   .append("\n");
						flatFile.append("SHPR3:")	        .append(blData[19])   .append("\n");
						flatFile.append("SHPR4:")	        .append(blData[20])   .append("\n");
						flatFile.append("SHPR5:")	        .append(blData[21])   .append("\n");
						flatFile.append("SHPR6:")			.append(blData[50])	  .append("\n");
						flatFile.append("SHPR7:")           .append(blData[51])	  .append("\n");
						flatFile.append("SHPRRGSTNO:")		.append(blData[47])   .append("\n");
						flatFile.append("CNEE1:")	        .append(blData[22])   .append("\n");
						flatFile.append("CNEE2:")	        .append(blData[23])   .append("\n");
						flatFile.append("CNEE3:")	        .append(blData[24])   .append("\n");
						flatFile.append("CNEE4:")	        .append(blData[25])   .append("\n");
						flatFile.append("CNEE5:")	        .append(blData[26])   .append("\n");
						flatFile.append("CNEE6:")           .append(blData[52])	  .append("\n");
						flatFile.append("CNEE7:")           .append(blData[53])	  .append("\n");
						flatFile.append("CNEERGSTNO:")		.append(blData[48])   .append("\n");
						flatFile.append("NTFY1:")	        .append(blData[27])   .append("\n");
						flatFile.append("NTFY2:")	        .append(blData[28])   .append("\n");
						flatFile.append("NTFY3:")	        .append(blData[29])   .append("\n");
						flatFile.append("NTFY4:")	        .append(blData[30])   .append("\n");
						flatFile.append("NTFY5:")	        .append(blData[31])   .append("\n");
						flatFile.append("NTFY6:")           .append(blData[54])	  .append("\n");
						flatFile.append("NTFY7:")           .append(blData[55])   .append("\n");
						flatFile.append("NTFYRGSTNO:")		.append(blData[49])   .append("\n");
						for( int k=0; k < podRout.length; k++ ) {
							if(podRout[k].startsWith("PORT")){
								podRout[k] = podRout[k].substring(podRout[k].indexOf(":")+1);
							}
							flatFile.append("PORT").append(k+1).append(":")		.append(podRout[k])		.append("\n");
						}
						flatFile.append("{CGO_INFO")		.append("\n");
							flatFile.append("DESC1:")		    .append(blData[33])   .append("\n");
							flatFile.append("MARK1:")		    .append(blData[34])   .append("\n");
							flatFile.append("MARK2:")		    .append(blData[35])   .append("\n");
							flatFile.append("MARK3:")		    .append(blData[36])   .append("\n");
							flatFile.append("MARK4:")		    .append(blData[37])   .append("\n");
							flatFile.append("MARK5:")		    .append(blData[38])   .append("\n");
							flatFile.append("BLWGT:")		    .append(blData[39])   .append("\n");
							flatFile.append("BLPKG:")		    .append(blData[40])   .append("\n");
							flatFile.append("BLPKGU:")		    .append(blData[41])   .append("\n");
							flatFile.append("REEFER_IND:")	    .append(blData[42])   .append("\n");
							flatFile.append("REEFER:")		    .append(blData[43])   .append("\n");
							flatFile.append("RUNIT:")	        .append(blData[44])   .append("\n");
							flatFile.append("BLMEA:")	        .append(blData[45])   .append("\n");
							flatFile.append("GOODNO:")		    .append(blData[46])   .append("\n");
						flatFile.append("}CGO_INFO")		.append("\n");

						/*===============================================================*/
						/*             			BL LOG 저장                                 	 				 */
						/*===============================================================*/
						bkgCstmsChnSndLogBlVO = new BkgCstmsChnSndLogBlVO();
						bkgCstmsChnSndLogBlVO.setEdiRefId(ediRefId);
						bkgCstmsChnSndLogBlVO.setBlNo(blNo);
						bkgCstmsChnSndLogBlVO.setBkgPolCd(pol);
						//bkgCstmsChnSndLogBlVO.setBkgPodCd(transKeyVO.getBkgPodCd());
						bkgCstmsChnSndLogBlVO.setCreUsrId(usrId);
						bkgCstmsChnSndLogBlVO.setUpdUsrId(usrId);
						dbDao.addSendLogBl ( bkgCstmsChnSndLogBlVO, transMode );
				

						/*****************************************************/
						/** Flat File 생성 - Special Cargo Info.	(위험화물) 	**/
						/*****************************************************/
						List<ChinaCncusDangerCntrVO> chinaCncusDangerCntrVOs = dbDao.searchCncusDangerCntr ( blNo , transMode );

						if(chinaCncusDangerCntrVOs.size() > 0) {
							for ( int k=0; k < chinaCncusDangerCntrVOs.size(); k++ ) {
									
								flatFile.append("{SPEC_INFO")		.append("\n");       
									flatFile.append("CLASS:")		    .append(chinaCncusDangerCntrVOs.get(k).getClss())          .append("\n");
									flatFile.append("PAGE:")		    .append(chinaCncusDangerCntrVOs.get(k).getPage())          .append("\n");
									flatFile.append("UNDGNO:")		    .append(chinaCncusDangerCntrVOs.get(k).getUndgno())        .append("\n");
									flatFile.append("LABEL:")		    .append(chinaCncusDangerCntrVOs.get(k).getLabel())         .append("\n");
									flatFile.append("FLASH_POINT:")		.append(chinaCncusDangerCntrVOs.get(k).getFlashPoint())	   .append("\n");
									flatFile.append("EMS_NO:")			.append(chinaCncusDangerCntrVOs.get(k).getEmsNo())	   	   .append("\n");
									flatFile.append("CONTACT_NAME:")    .append(chinaCncusDangerCntrVOs.get(k).getContactName())   .append("\n");
									flatFile.append("CONTACT_TEL:")	    .append(chinaCncusDangerCntrVOs.get(k).getContactTel())    .append("\n");
								flatFile.append("}SPEC_INFO")       .append("\n");
							}
						}
						

						
						/********************************/
						/** Flat File 생성 - Container **/
						/********************************/
						List<ChinaCncusCntrVO> chinaCncusCntrVOs = dbDao.searchCncusCntr ( blNo , transMode );
						
						String[] cntrData = null;
						String cntrNo = null;
						
						String[] multiCntrSealNo = null;
						String[] multiCntrSealKindCd = null;
						String[] multiCntrSealerCd = null;
						
						String sealnbr = "";
						String sealkind = "";
						String sealer = "";
												
						if(chinaCncusCntrVOs.size() > 0) {
							for ( int k=0; k < chinaCncusCntrVOs.size(); k++ ) {
								
								cntrData = chinaCncusCntrVOs.get(k).getCntrData().split("\t");
								cntrNo = chinaCncusCntrVOs.get(k).getCntrNo();
								
								// 멀티 SealNo, SealKindCd, SealerCd를 @ 구분자로 분리한다.
								multiCntrSealNo = cntrData[1].split("@");
								multiCntrSealKindCd = cntrData[2].split("@");
								multiCntrSealerCd = cntrData[3].split("@");
								
								int cntrSealNOMaxCnt = multiCntrSealNo.length;
								
								if(cntrSealNOMaxCnt > 0) {
                                    sealnbr = multiCntrSealNo[0];
                                    sealkind = (multiCntrSealKindCd.length > 0 ) ? multiCntrSealKindCd[0] : "";
                                    sealer = (multiCntrSealerCd.length > 0 ) ? multiCntrSealerCd[0] :  "";
								} else {
									sealnbr = "";
									sealkind = "";
									sealer = "";
								}
																								
								flatFile.append("{CNTR_INFO")       .append("\n");   
									flatFile.append("CNTRNBR:")         .append(cntrData[0])          .append("\n");
									flatFile.append("SEALNBR:")         .append(sealnbr)              .append("\n");
									flatFile.append("SEALKIND:")        .append(sealkind)             .append("\n");
									flatFile.append("SEALER:")          .append(sealer)               .append("\n");
									flatFile.append("CNTRTYPE:")        .append(cntrData[4])          .append("\n");
									flatFile.append("LDMT:")		    .append(cntrData[5])          .append("\n");
									flatFile.append("CNTRWGT:")	        .append(cntrData[6])          .append("\n");
									flatFile.append("TWGT:")	        .append(cntrData[7])          .append("\n");
									flatFile.append("OVF:")	            .append(cntrData[8])          .append("\n");
									flatFile.append("OVR:")	            .append(cntrData[9])          .append("\n");
									flatFile.append("OVH:")	            .append(cntrData[10])         .append("\n");
									flatFile.append("OVLW:")		    .append(cntrData[11])         .append("\n");
									flatFile.append("OVRW:")		    .append(cntrData[12])         .append("\n");
									flatFile.append("CNTRMEA:")	        .append(cntrData[13])         .append("\n");
									flatFile.append("CGOODNO:")	        .append(cntrData[14])         .append("\n");
									flatFile.append("PKGQTY:")	        .append(cntrData[15])         .append("\n");
									
									// 멀티 Seal NO 갯수만큼 SealNo, SealKind, SealerCD가 생성되어진다.
									if(cntrSealNOMaxCnt > 0) {
                                        for(int sealIdx = 0; sealIdx < cntrSealNOMaxCnt; sealIdx++) {
                                                   flatFile.append("{CNTR_SEAL_NO").append("\n");
                                                   flatFile.append("SEAL_NO:").append(multiCntrSealNo[sealIdx]).append("\n");
                                                   flatFile.append("SEAL_KIND:").append((multiCntrSealKindCd.length > sealIdx) ? multiCntrSealKindCd[sealIdx].trim() : "").append("\n");
                                                   flatFile.append("SEALER_CD:").append((multiCntrSealerCd.length > sealIdx) ? multiCntrSealerCd[sealIdx].trim() : "").append("\n");
                                                   flatFile.append("}CNTR_SEAL_NO").append("\n");
                                        }                                                                                                         
									}
														
								flatFile.append("}CNTR_INFO")       .append("\n");  

								/*===============================================================*/
								/*                      CNTR LOG 저장                                 			 	 */
								/*===============================================================*/
								bkgCstmsChnSndLogCntrVO = new BkgCstmsChnSndLogCntrVO();
								bkgCstmsChnSndLogCntrVO.setEdiRefId(ediRefId);
								bkgCstmsChnSndLogCntrVO.setBlNo(blNo);
								bkgCstmsChnSndLogCntrVO.setCntrNo(cntrNo);
								bkgCstmsChnSndLogCntrVO.setCreUsrId(usrId);
								bkgCstmsChnSndLogCntrVO.setUpdUsrId(usrId);
								dbDao.addSendLogCntr ( bkgCstmsChnSndLogCntrVO );
								
							}
						}
						
						//[CHM-201111935] 수정 및 삭제 시 Amend code 출력 
						if(!"9".equals(msgType) && !"0".equals(msgType)){
							flatFile.append("AMEND_CODE:999")			.append("\n");
						}
						
						//[CHM-201113536] Multi-Commodity bkg 관련 로직변경 요청 
						
						List<ChinaCMCntrVO> chinaCMCntrVOs = dbDao.searchCMCntr ( blNo , transMode );
						
						if(chinaCMCntrVOs.size() > 0) {
							for ( int k=0; k < chinaCMCntrVOs.size(); k++ ) {

								flatFile.append("{CM_INFO")       .append("\n");   
									flatFile.append("CM_SEQ:")    		.append(chinaCMCntrVOs.get(k).getCntrMfSeq())          .append("\n");
									flatFile.append("CM_DESC1:")        .append(chinaCMCntrVOs.get(k).getCntrMfGdsDesc())      .append("\n");
									flatFile.append("CM_MARK1:")        .append(chinaCMCntrVOs.get(k).getCntrMfMkDesc1())       .append("\n");
									flatFile.append("CM_MARK2:")        .append(chinaCMCntrVOs.get(k).getCntrMfMkDesc2())       .append("\n");
									flatFile.append("CM_MARK3:")        .append(chinaCMCntrVOs.get(k).getCntrMfMkDesc3())       .append("\n");
									flatFile.append("CM_MARK4:")		.append(chinaCMCntrVOs.get(k).getCntrMfMkDesc4())       .append("\n");
									flatFile.append("CM_MARK5:")	    .append(chinaCMCntrVOs.get(k).getCntrMfMkDesc5())       .append("\n");
									flatFile.append("CM_WGT:")	        .append(chinaCMCntrVOs.get(k).getCntrMfWgt())          .append("\n");
									flatFile.append("CM_PKG:")	        .append(chinaCMCntrVOs.get(k).getPckQty())        	   .append("\n");
									flatFile.append("CM_PKG_U:")	    .append(chinaCMCntrVOs.get(k).getPckTpCd())            .append("\n");
									flatFile.append("CM_REEFER_IND:")	.append(chinaCMCntrVOs.get(k).getRcFlg())         	   .append("\n");
									flatFile.append("CM_REEFER:")		.append(chinaCMCntrVOs.get(k).getDoTemp())             .append("\n");
									flatFile.append("CM_RUNIT:")		.append(chinaCMCntrVOs.get(k).getTempUn())             .append("\n");
									flatFile.append("CM_MEA:")	        .append(chinaCMCntrVOs.get(k).getMeasQty())            .append("\n");
									flatFile.append("CM_GOODNO:")	    .append(chinaCMCntrVOs.get(k).getGoodno())             .append("\n");
								flatFile.append("}CM_INFO")			.append("\n");
							}
						}
							
						flatFile.append("}BL_INFO")			.append("\n");

						downloadBC.modifyBl2(transKeyVOs, pol);
						downloadBC.modifyVvd(transKeyVO, pol);
						
				} // for end : chinaCncusBlListVOs
			} // if end

			return flatFile.toString();
		}
		catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088",new String[]{}).getMessage(), ex);
		}
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
	private List<String> generateBlNoList(ChinaBlInfoListVO[] blInfoVOs) throws EventException {
		try{
			List<String> arrString = new ArrayList();  //BKG_NO
			StringBuffer sb = new StringBuffer();
			int bkgCnt = blInfoVOs.length;
			int quotaCnt = bkgCnt / 1000;
			int restCnt = bkgCnt % 1000;
			
			for (int i=1; i<=quotaCnt; i++) {
				sb.delete(0, sb.length());
				for (int j=i*1000-1000; j<i*1000; j++) {	
					if(j == i*1000-1000){
						sb.append("'").append(blInfoVOs[j].getBlNo()).append("'");
					}else{
						sb.append(",'").append(blInfoVOs[j].getBlNo()).append("'");
					}
				}
				arrString.add(sb.toString());
			}
			
			if(restCnt > 0){
				sb.delete(0, sb.length());
				for (int i=quotaCnt*1000; i<bkgCnt; i++) {	
					if(i == quotaCnt*1000){
						sb.append("'").append(blInfoVOs[i].getBlNo()).append("'");
					}else{
						sb.append(",'").append(blInfoVOs[i].getBlNo()).append("'");
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