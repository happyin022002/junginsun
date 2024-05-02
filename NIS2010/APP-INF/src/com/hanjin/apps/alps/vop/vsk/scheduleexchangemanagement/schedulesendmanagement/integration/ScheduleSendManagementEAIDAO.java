/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ScheduleSendManagementEAIDAO.java
*@FileTitle : Schedule Send Management
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.30
*@LastModifier : JEONG SANG-KI
*@LastVersion : 1.0
* 2014.04.30 JEONG SANG-KI
* 1.0 Creation
* 
* History
* 2015.07.22 이병훈 [CHM-201536635] Split11-2015년 소스 보안 품질 3단계 중 4차 작업 진행 요청
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulesendmanagement.integration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulesendmanagement.vo.VslSkdXchEdiDtlVO;
import com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulesendmanagement.vo.VslSkdXchEdiHdrVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;
import com.jf.transfer.jms.send.vandor.IBMSendQClient;

/**
 * ScheduleSendManagementEAIDAO Business Logic BasicCommand
 * 
 * @author JEONG SANG-KI
 * @see ScheduleSendManagementEAIDAO
 * @since J2EE 1.6
 */
public class ScheduleSendManagementEAIDAO extends EAIDAOSupport {
	/**
	 * EDI : ALPSVSK_T_UDEVHJS_SKD_ALLIANCE
	 * 부산(KRPUS) 터미널에서 Costal Schedule 변경 내역, Berth Window 정보를 KL-Net, 신항만('KRPUSHN') 쪽에 EDI로 전송 한다.<br>
	 * 
	 * @param VslSkdXchEdiHdrVO vslSkdXchEdiHdrVO
	 * @param List<VslSkdXchEdiDtlVO> vslSkdXchEdiDtlVOs
	 * @return String
	 * @exception EAIException
	 */
	public boolean sendEdiForScheduleExchangeCKYH(VslSkdXchEdiHdrVO vslSkdXchEdiHdrVO, List<VslSkdXchEdiDtlVO> vslSkdXchEdiDtlVOs) throws DAOException {
		
		TransferEAI eai 		= null;
		String 		reString 	= "";
		boolean		isSuccess	= false;
		
		try{
			
			/***************************************************************************
			 * MQ Name	: Schedule Exchange among Alliance through EDI
			 * -------------------------------------------------------------------------
			 * <LIVE>
			 * I/B : UBIZHJS_ALPSVSK_SKD_ALLIANCE
			 * O/B : ALPSVSK_UBIZHJS_SKD_ALLIANCE
			 * 
			 * <TEST>
			 * I/B : UDEVHJS_ALPSVSK_T_SKD_ALLIANCE
			 * O/B : ALPSVSK_T_UDEVHJS_SKD_ALLIANCE
			 * 
			 * =========================================================================
			 * VSK.ALPSVSK_UBIZHJS_ALLIANCE_VSK.IBMMQ.URL=203.246.130.159:1414
			 * VSK.ALPSVSK_UBIZHJS_ALLIANCE_VSK.IBMMQ.TRANSFERTYPE=MQJMS_TP_CLIENT_MQ_TCPIP
			 * VSK.ALPSVSK_UBIZHJS_ALLIANCE_VSK.IBMMQ.CHANNEL=WEBCHL
			 * VSK.ALPSVSK_UBIZHJS_ALLIANCE_VSK.IBMMQ.FACTORY=NIS2010_T
			 * VSK.ALPSVSK_UBIZHJS_ALLIANCE_VSK.IBMMQ.QUEUE=UDEVHJS_ALPSVSK_T_SKD_ALLIANCE
			 * VSK.ALPSVSK_UBIZHJS_ALLIANCE_VSK.IBMMQ.TARGETCLIENT=MQJMS_CLIENT_NONJMS_MQ
			 * -------------------------------------------------------------------------
			 */
			
			/***************************************************************************
			 * EDI FLAT FILE STRUCTURE
			 * -------------------------------------------------------------------------
			 * <HEADER>
			 * $$$MSGSTART:SMCU                RCV                 IFTSAI    ENT04110877629	
			 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			 * <BODY>
			 * BODY_01		FUNC_CD			:	N
			 * BODY_02		CO_CD			:	SML
			 * BODY_03		VSL_SLAN_CD		:	CAX
			 * BODY_04		SKD_CNG_STS_CD	:	S
			 * BODY_05		VSL_CD			:	KCIB
			 * BODY_06		CALLSIGN		:	DSQL8
			 * BODY_07		SKD_VOYAGE_NO	:	0030
			 * BODY_08		SKD_DIR_CD		:	E
			 * BODY_09		AR_DR_IND		:	ARV
			 * BODY_10		LLOYDS_CD		:	9247558
			 * BODY_11		VSL_ENG_NM		:	CHICAGO BRIDGE
			 * BODY_12		PIC_NM			:	HONG GIL DONG
			 * BODY_13		CONTACT_TYPE	:	TE
			 * BODY_14		CONTACT_NO		:	82-2-1234-5678
			 * BODY_15		REMARK			:	
			 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			 * <BODY LOOP>
			 * {VSL_SKD	
			 * BODY_LOOP_01	LOC_IND			:	153
			 * BODY_LOOP_02	CAL_IND_SEQ		:	1
			 * BODY_LOOP_03	CLPT_SEQ		:	1
			 * BODY_LOOP_04	LOC_CD			:	KRPUS
			 * BODY_LOOP_05	LOC_DESC		:	PUSAN
			 * BODY_LOOP_06	LOC_ETA			:	200701010000
			 * BODY_LOOP_07	LOC_ETB			:	200701010000
			 * BODY_LOOP_08	LOC_ETD			:	200701010000
			 * BODY_LOOP_09	LOC_ATA			:	200701010000
			 * BODY_LOOP_10	LOC_ATB			:	200701010000
			 * BODY_LOOP_11	LOC_ATD			:	200701010000
			 * }VSL_SKD	
			 * -------------------------------------------------------------------------
			 * {VSL_SKD	
			 * LOC_IND		:	153
			 * CAL_IND_SEQ	:	1
			 * CLPT_SEQ		:	2
			 * LOC_CD		:	USLGB
			 * LOC_DESC		:	LONG BEACH,CA
			 * LOC_ETA		:	200701010000
			 * LOC_ETB		:	200701010000
			 * LOC_ETD		:	200701010000
			 * LOC_ATA		:	
			 * LOC_ATB		:	
			 * }VSL_SKD
			 * </BODY LOOP>
			 * =========================================================================
			 */
			
			//String sQueueName 		= SubSystemConfigFactory.get("VSK.ALPSVSK_UBIZHJS_ALLIANCE_VSK.IBMMQ.QUEUE");
			
			StringBuffer	sbMessage	= new StringBuffer();
			
			//String header 			= vslSkdXchEdiHdrVO.getEdiHdrMsg();		//dbDao.searchEdiHdToKlnet	(headerSeq			);
			//String body 			= null;									//dbDao.searchEdiMsgToKlnet	(cstSkdBerthWdoVO	);
			
			
			//::<HEADER>:://////////////////////////////////////////////////////////////////////
			sbMessage.append(vslSkdXchEdiHdrVO.getEdiHdrMsg()).append("\n");
			//::</HEADER>:://///////////////////////////////////////////////////////////////////

			//::<BODY>:://////////////////////////////////////////////////////////////////////
			sbMessage.append("FUNC_CD:").append("N").append("\n");										//BODY_01		FUNC_CD			:	N
			sbMessage.append("CO_CD:").append("SML").append("\n");										//BODY_02		CO_CD			:	SML
			sbMessage.append("VSL_SLAN_CD:").append(vslSkdXchEdiHdrVO.getVslSlanCdCtnt()).append("\n");	//BODY_03		VSL_SLAN_CD		:	CAX
			sbMessage.append("SKD_CNG_STS_CD:").append("").append("\n"); 									//BODY_04		SKD_CNG_STS_CD	:	S
			sbMessage.append("VSL_CD:").append(vslSkdXchEdiHdrVO.getVslCdCtnt()).append("\n"); 			//BODY_05		VSL_CD			:	KCIB
			sbMessage.append("CALLSIGN:").append(vslSkdXchEdiHdrVO.getCallSgnNo()).append("\n");		 	//BODY_06		CALLSIGN		:	DSQL8
			sbMessage.append("SKD_VOYAGE_NO:").append(vslSkdXchEdiHdrVO.getSkdVoyNoCtnt()).append("\n");	//BODY_07		SKD_VOYAGE_NO	:	0030
			sbMessage.append("SKD_DIR_CD:").append(vslSkdXchEdiHdrVO.getSkdDirCdCtnt()).append("\n");		//BODY_08		SKD_DIR_CD		:	E
			sbMessage.append("AR_DR_IND:").append("").append("\n"); 										//BODY_09		AR_DR_IND		:	ARV
			sbMessage.append("LLOYDS_CD:").append(vslSkdXchEdiHdrVO.getLloydNo()).append("\n");		 	//BODY_10		LLOYDS_CD		:	9247558
			sbMessage.append("VSL_ENG_NM:").append(vslSkdXchEdiHdrVO.getVslEngNm()).append("\n");		 	//BODY_11		VSL_ENG_NM		:	CHICAGO BRIDGE
			sbMessage.append("PIC_NM:").append(vslSkdXchEdiHdrVO.getPicNm()).append("\n");		 		//BODY_12		PIC_NM			:	HONG GIL DONG
			sbMessage.append("CONTACT_EMAIL:").append(vslSkdXchEdiHdrVO.getPicCntcNo()).append("\n");		//E-MAIL ADDRESS// 							//BODY_13		CONTACT_TYPE	:	TE
			sbMessage.append("CONTACT_TEL:").append("\n");		 											//BODY_14		CONTACT_NO		:	82-2-1234-5678
			sbMessage.append("REMARK:").append("").append("\n");		 									//BODY_15		REMARK			:	
			//::</BODY>:://///////////////////////////////////////////////////////////////////			

			for(VslSkdXchEdiDtlVO tmpVO : vslSkdXchEdiDtlVOs){
			
				//::<BODY LOOP>:://///////////////////////////////////////////////////////////////////
				sbMessage.append("{VSL_SKD").append("\n"); 													//{VSL_SKD	
				sbMessage.append("LOC_IND:").append("\n"); 												//BODY_LOOP_01	LOC_IND			:	153
				sbMessage.append("CAL_IND_SEQ:").append(tmpVO.getClptIndSeqCtnt()).append("\n");			//BODY_LOOP_02	CAL_IND_SEQ		:	1
				sbMessage.append("CLPT_SEQ:").append(tmpVO.getClptSeqCtnt()).append("\n");				//BODY_LOOP_03	CLPT_SEQ		:	1
				
				////sbMessage.append("LOC_CD : ").append(tmpVO.getVpsPortCdCtnt()).append("\n");				//BODY_LOOP_04	LOC_CD			:	KRPUS
				sbMessage.append("LOC_CD:").append(tmpVO.getAllnPortCdCtnt()).append("\n");				//BODY_LOOP_04	LOC_CD			:	KRPUS
				
				sbMessage.append("LOC_DESC:").append(tmpVO.getVpsPortNm()).append("\n");					//BODY_LOOP_05	LOC_DESC		:	PUSAN
				sbMessage.append("LOC_ETA:").append(tmpVO.getVpsEtaDtCtnt()).append("\n");				//BODY_LOOP_06	LOC_ETA			:	200701010000
				sbMessage.append("LOC_ETB:").append(tmpVO.getVpsEtbDtCtnt()).append("\n");				//BODY_LOOP_07	LOC_ETB			:	200701010000
				sbMessage.append("LOC_ETD:").append(tmpVO.getVpsEtdDtCtnt()).append("\n");				//BODY_LOOP_08	LOC_ETD			:	200701010000
				sbMessage.append("LOC_ATA:").append(tmpVO.getActArrDtCtnt()).append("\n");				//BODY_LOOP_09	LOC_ATA			:	200701010000
				sbMessage.append("LOC_ATB:").append(tmpVO.getActBrthDtCtnt()).append("\n");				//BODY_LOOP_10	LOC_ATB			:	200701010000
				sbMessage.append("LOC_ATD:").append(tmpVO.getActDepDtCtnt()).append("\n");				//BODY_LOOP_11	LOC_ATD			:	200701010000
				sbMessage.append("}VSL_SKD").append("\n"); 													//}VSL_SKD	
				//::</BODY LOOP>:://///////////////////////////////////////////////////////////////////		
				
			}
			
			
			log.info("\n\n###############################################################");
			log.info("\n::2007816:: EDI F/F : \n" + sbMessage.toString());
			log.info("\n#################################################################");
			
			
			String sIntegrationId 	= "VSK.ALPSVSK_UBIZHJS_ALLIANCE_VSK" + (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
	
			/* System properties : classpath/properties/subsystem-config.properties */
			String sTarget 			= SubSystemConfigFactory.get("VSK.ALPSVSK_UBIZHJS_ALLIANCE_VSK.IBMMQ.URL");
			String sTransfertype 	= SubSystemConfigFactory.get("VSK.ALPSVSK_UBIZHJS_ALLIANCE_VSK.IBMMQ.TRANSFERTYPE");
			String sChannel 		= SubSystemConfigFactory.get("VSK.ALPSVSK_UBIZHJS_ALLIANCE_VSK.IBMMQ.CHANNEL");
			String sFactory 		= SubSystemConfigFactory.get("VSK.ALPSVSK_UBIZHJS_ALLIANCE_VSK.IBMMQ.FACTORY");
			String sQueueName		= SubSystemConfigFactory.get("VSK.ALPSVSK_UBIZHJS_ALLIANCE_VSK.IBMMQ.QUEUE");
			String sTargetclient 	= SubSystemConfigFactory.get("VSK.ALPSVSK_UBIZHJS_VENDOR_VSK.IBMMQ.TARGETCLIENT");
	
			eai = new IBMSendQClient(sTarget, this.getClass());
			eai.setTransferType		(sTransfertype	);
			eai.setChannel			(sChannel		);
			eai.setFactory			(sFactory		);
			eai.setQueue			(sQueueName		);
			eai.setTargetClient		(sTargetclient	);
			eai.setMessage			(sbMessage.toString());

			reString = eai.commit	(sIntegrationId	); // <== EAI SEND QUEUE 방식에 따른
			
			log.info("\n\n###############################################################");
			log.info("\n::2007816:: EDI Transfer Result : [" + reString + "]");
			log.info("\n#################################################################");
			
			if("SUCCESS".equals(reString))	isSuccess	= true;
			
		} catch (EAIException ea) {
			if(eai!=null){
				eai.rollback(ea);
			}
			log.error(ea.getMessage(), ea);
			throw new DAOException(new ErrorHandler(ea).getMessage(), ea);
		} catch (Exception e) {
			if(eai!=null){
				eai.rollback(e);
			}
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} finally {
			if(eai!=null){
				eai.close();	
			}
		}
		
		return isSuccess;
	}
	
}