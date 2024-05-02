/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselScheduleMgtEAIDAO.java
*@FileTitle : VesselScheduleMgtEAIDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : Jeong Myounghun
*@LastVersion : 1.0
* 2009.06.22 Jeong Myounghun
* 1.0 Creation
* 
* History
* 2010.10.28 CHM-201006456-01 유혁 SKD Auto Update 기능 보완
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.ErpMsgFns017VO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.irep.erp.EAIHeaderType;
import com.hanjin.irep.erp.FNS0170001Document;
import com.hanjin.irep.erp.FNS0170001Document.FNS0170001;
import com.hanjin.irep.erp.FNS0170001Document.FNS0170001.DataArea.SKDCollection;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;
import com.jf.transfer.jms.send.vandor.IBMSendQClient;
import com.jf.transfer.jms.send.vandor.WeblogicSendQClient;

/**
 * It's ASynch IBM MQ Listener 
 * @author Jeong Myounghun
 * @see 
 * @since J2EE 1.6
 * June 22, 2009
 */
public class VesselScheduleMgtEAIDAO extends EAIDAOSupport {
	/**
	 * EDI : ALPSVSK_T_UDEVHJS_VENDOR_VSK
	 * 부산(KRPUS) 터미널에서 Costal Schedule 변경 내역, Berth Window 정보를 KL-Net, 신항만('KRPUSHN') 쪽에 EDI로 전송 한다.<br>
	 * 
	 * @param String queueName
	 * @param String flatFile
	 * @return String
	 * @exception EAIException
	 */
	public String sendEdiVslSkdCstSkdBerthWdo(String queueName, String flatFile) throws DAOException {
		
		TransferEAI eai = null;
		String reString = "";
		
		try{
			//String integrationId = "ALPSVSK_T_UDEVHJS_VENDOR_VSK" + (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
			String integrationId = "VSK.ALPSVSK_UBIZHJS_VENDOR_VSK" + (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
	
			/* System properties : classpath/properties/subsystem-config.properties */
			String target = SubSystemConfigFactory.get("VSK.ALPSVSK_UBIZHJS_VENDOR_VSK.IBMMQ.URL");
			String transfertype = SubSystemConfigFactory.get("VSK.ALPSVSK_UBIZHJS_VENDOR_VSK.IBMMQ.TRANSFERTYPE");
			String channel = SubSystemConfigFactory.get("VSK.ALPSVSK_UBIZHJS_VENDOR_VSK.IBMMQ.CHANNEL");
			String factory = SubSystemConfigFactory.get("VSK.ALPSVSK_UBIZHJS_VENDOR_VSK.IBMMQ.FACTORY");
			String queue = queueName;//SubSystemConfigFactory.get("BKG.IBMMQ.QUEUE");
			String targetclient = SubSystemConfigFactory.get("VSK.ALPSVSK_UBIZHJS_VENDOR_VSK.IBMMQ.TARGETCLIENT");
	
			eai = new IBMSendQClient(target, this.getClass());
			eai.setTransferType(transfertype);
			eai.setChannel(channel);
			eai.setFactory(factory);
			eai.setQueue(queue);
			eai.setTargetClient(targetclient);
			eai.setMessage(flatFile);

			reString = eai.commit(integrationId); // <== EAI SEND QUEUE 방식에 따른
			log.info("#####################################");
			log.info("EDI 전송결과 : " + reString);
			log.info("#####################################");
			
			return reString;
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
			eai.close();	
		}
	}
	
	/**
	 * ERP : FNS017-0001
	 * EDI : ETA, ETB, ETD, Yard Code 가 바뀔 경우에 ERP에 Vessel Schedule 정보를 전송한다.<br>
	 * 
	 * @param List<ErpMsgFns017VO> erpMsgFns017VOs
	 * @return String
	 * @exception DAOException 
	 */
	public String sendVslSkdErpIf(List<ErpMsgFns017VO> erpMsgFns017VOs) throws DAOException {
		TransferEAI eai = null;

		String sendUrl = "";
		String factory	= "";
		String queue = "";
		String reString = "";
		
		try{
			
			//Request Start
			String 	integrationId = "";
			
			sendUrl = SubSystemConfigFactory.get("VOP.VSK.JMS.SEND.URL");
			factory = SubSystemConfigFactory.get("VOP.VSK.JMS.SEND.FACTORY");
			queue 	= SubSystemConfigFactory.get("VOP.VSK.JMS.SEND.QUEUE");

			FNS0170001Document 	document 		= FNS0170001Document.Factory.newInstance();
			FNS0170001 			fns0170001 		= FNS0170001.Factory.newInstance();
			
			EAIHeaderType 		headerType 		= fns0170001.addNewEAIHeader();
			
			FNS0170001.DataArea dataArea 		= fns0170001.addNewDataArea();
			
			SKDCollection  		skdCollection 	= dataArea.addNewSKDCollection();
			
			for(int i=0; i<erpMsgFns017VOs.size(); i++){

				if(erpMsgFns017VOs.get(i) != null){

					FNS0170001.DataArea.SKDCollection.SKD skd = skdCollection.addNewSKD();
					
					if(erpMsgFns017VOs.get(i).getSeq() != null){
						integrationId = erpMsgFns017VOs.get(i).getSeq();
					}
					if(erpMsgFns017VOs.get(i).getLifid() != null){
						skd.setLIFID(erpMsgFns017VOs.get(i).getLifid());
					}
					if(erpMsgFns017VOs.get(i).getSeq() != null){
						skd.setSEQ(erpMsgFns017VOs.get(i).getSeq());
					}
		            if(erpMsgFns017VOs.get(i).getTotalCount() != null){
		            	skd.setTOTALCOUNT(erpMsgFns017VOs.get(i).getTotalCount());
		            }
		            if(erpMsgFns017VOs.get(i).getRowNum() != null){
		            	skd.setROWNUM(erpMsgFns017VOs.get(i).getRowNum());
		            }
		            if(erpMsgFns017VOs.get(i).getVsl() != null){
		            	skd.setVSL(erpMsgFns017VOs.get(i).getVsl());
		            }
		            if(erpMsgFns017VOs.get(i).getVoyNo() != null){
		            	skd.setVOYNO(erpMsgFns017VOs.get(i).getVoyNo());
		            }
		            if(erpMsgFns017VOs.get(i).getDep() != null){
		            	skd.setDEP(erpMsgFns017VOs.get(i).getDep());
		            }
		            if(erpMsgFns017VOs.get(i).getVoyTp() != null){
		            	skd.setVOYTP(erpMsgFns017VOs.get(i).getVoyTp());
		            }
		            if(erpMsgFns017VOs.get(i).getLane() != null){
		            	skd.setLANE(erpMsgFns017VOs.get(i).getLane());
		            }
		            if(erpMsgFns017VOs.get(i).getLoadQnt() != null){
		            	skd.setLOADQNT(erpMsgFns017VOs.get(i).getLoadQnt());
		            }
		            if(erpMsgFns017VOs.get(i).getSurvey() != null){
		            	skd.setSURVEY(erpMsgFns017VOs.get(i).getSurvey());
		            }
		            if(erpMsgFns017VOs.get(i).getVesselCheck() != null){
		            	skd.setVESSELCHECK(erpMsgFns017VOs.get(i).getVesselCheck());
		            }
		            if(erpMsgFns017VOs.get(i).getLineCnt() != null){
		            	skd.setLINECNT(erpMsgFns017VOs.get(i).getLineCnt());
		            }
		            if(erpMsgFns017VOs.get(i).getDtlVsl() != null){
		            	skd.setDTLVSL(erpMsgFns017VOs.get(i).getDtlVsl());
		            }
		            if(erpMsgFns017VOs.get(i).getDtlVoyNo() != null){
		            	skd.setDTLVOYNO(erpMsgFns017VOs.get(i).getDtlVoyNo());
		            }
		            if(erpMsgFns017VOs.get(i).getDtlDep() != null){
		            	skd.setDTLDEP(erpMsgFns017VOs.get(i).getDtlDep());
		            }
		            if(erpMsgFns017VOs.get(i).getPortSeq() != null){
		            	skd.setPORTSEQ(erpMsgFns017VOs.get(i).getPortSeq());
		            }
		            if(erpMsgFns017VOs.get(i).getPt() != null){
		            	skd.setPT(erpMsgFns017VOs.get(i).getPt());
		            }
		            if(erpMsgFns017VOs.get(i).getEstArrDt() != null){
		            	skd.setESTARRDT(erpMsgFns017VOs.get(i).getEstArrDt());
		            }
		            if(erpMsgFns017VOs.get(i).getEstSailDt() != null){
		            	skd.setESTSAILDT(erpMsgFns017VOs.get(i).getEstSailDt());
		            }
		            if(erpMsgFns017VOs.get(i).getActArrDt() != null){
		            	skd.setACTARRDT(erpMsgFns017VOs.get(i).getActArrDt());
		            }
		            if(erpMsgFns017VOs.get(i).getActSailDt() != null){
		            	skd.setACTSAILDT(erpMsgFns017VOs.get(i).getActSailDt());
		            }
		            if(erpMsgFns017VOs.get(i).getPosition() != null){
		            	skd.setPOSITION(erpMsgFns017VOs.get(i).getPosition());
		            }
		            if(erpMsgFns017VOs.get(i).getLogRgst() != null){
		            	skd.setLOGRGST(erpMsgFns017VOs.get(i).getLogRgst());
		            }
		            if(erpMsgFns017VOs.get(i).getLogUpdt() != null){
		            	skd.setLOGUPDT(erpMsgFns017VOs.get(i).getLogUpdt());
		            }
		            if(erpMsgFns017VOs.get(i).getLogUserid() != null){
		            	skd.setLOGUSERID(erpMsgFns017VOs.get(i).getLogUserid());
		            }
		            if(erpMsgFns017VOs.get(i).getChangeInd() != null){
		            	skd.setCHANGEIND(erpMsgFns017VOs.get(i).getChangeInd());
		            }
		            if(erpMsgFns017VOs.get(i).getDelMk() != null){
		            	skd.setDELMK(erpMsgFns017VOs.get(i).getDelMk());
		            }
		            if(erpMsgFns017VOs.get(i).getTurnInd() != null){
		            	skd.setTURNIND(erpMsgFns017VOs.get(i).getTurnInd());
		            }
		            if(erpMsgFns017VOs.get(i).getHRemark() != null){
		            	skd.setHREMARK(erpMsgFns017VOs.get(i).getHRemark());
		            }
		            if(erpMsgFns017VOs.get(i).getDRemark() != null){
		            	skd.setDREMARK(erpMsgFns017VOs.get(i).getDRemark());
		            }
		            if(erpMsgFns017VOs.get(i).getNewSailDt() != null){
		            	skd.setNEWSAILDT(erpMsgFns017VOs.get(i).getNewSailDt());
		            }
		            if(erpMsgFns017VOs.get(i).getNewArrDt() != null){
		            	skd.setNEWARRDT(erpMsgFns017VOs.get(i).getNewArrDt());
		            }
		            if(erpMsgFns017VOs.get(i).getSkdSkdStat() != null){
		            	skd.setSKDSKDSTAT(erpMsgFns017VOs.get(i).getSkdSkdStat());
		            }
		            if(erpMsgFns017VOs.get(i).getVpsSkdStat() != null){
		            	skd.setVPSSKDSTAT(erpMsgFns017VOs.get(i).getVpsSkdStat());
		            }
		            // [CHM-201221884] CNTR 진행기준 대상항차 선정기능 보완
		            if(erpMsgFns017VOs.get(i).getClptIndSeq() != null){
		            	skd.setCLPTINDSEQ(erpMsgFns017VOs.get(i).getClptIndSeq());
		            }
		            if(erpMsgFns017VOs.get(i).getTurnSkdVoyNo() != null){
		            	skd.setTURNSKDVOYNO(erpMsgFns017VOs.get(i).getTurnSkdVoyNo());
		            }
		            if(erpMsgFns017VOs.get(i).getTurnSkdDirCd() != null){
		            	skd.setTURNSKDDIRCD(erpMsgFns017VOs.get(i).getTurnSkdDirCd());
		            }
	
		            skdCollection.setSKDArray(i, skd);
		           
		           
				}
			}
			
			String sysDate = (new SimpleDateFormat("yyyyMMdd")).format(new Date());
	
			headerType.setInstanceId("FNS017-0001"+ erpMsgFns017VOs.get(0).getVsl() + erpMsgFns017VOs.get(0).getVoyNo() + erpMsgFns017VOs.get(0).getDep() + sysDate);
			
			dataArea.setSKDCollection(skdCollection);
			fns0170001.setDataArea(dataArea);
			document.setFNS0170001(fns0170001);
                
			eai = new WeblogicSendQClient(sendUrl, this.getClass());
			eai.setFactory(factory); 
			eai.setQueue(queue);
			eai.setDestination("FNS017-0001");
			eai.setObj(document);
			
			/* EAI I/F ID와 F/W LOG I/F ID 일치화 작업 :: 2012-12-14 */
			////::jsk::reString = eai.commit("FNS017-0001"+ (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date()));
			reString = eai.commit("FNS017-0001"+ erpMsgFns017VOs.get(0).getVsl() + erpMsgFns017VOs.get(0).getVoyNo() + erpMsgFns017VOs.get(0).getDep() + sysDate);
			
			
			return reString + ":"+ document.getFNS0170001().getEAIHeader().getInstanceId();
			
		} catch (EAIException e) {
			if(eai!=null){
				eai.rollback(e);
			}
	    	log.error("EAIException : " + e.getMessage(),e);
	        throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			if(eai!=null){
				eai.rollback(e);
			}
			log.error("Exception : " + e.getMessage(),e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}finally{
			eai.close();
		}
	}
	
	/**
	 * ERP : ALPSVSK_T_UDEVHJS_VENDOR_VSK
	 * KTNET에게 송신, BKG이 들어오고 이를 (주)한진으로 국내운송 ORDER를 내릴때
	 * (주)한진 시스템에 선명이 등록되어 있어야 하기 때문에 선명마다,
	 * 또 PORT마다 (주)한지 시스템에 직접 입력하여 선명등록 EDI 전송하는 형식임<br>
	 * 
	 * @param String queueName
	 * @param String flatFile
	 * @return String
	 * @exception DAOException 
	 */
	public String sendEdiToDLS(String queueName, String flatFile) throws DAOException {
		TransferEAI eai = null;

		String reString = "" ; 

		try {
			
			String integrationId = "VSK.ALPSVSK_UBIZHJS_VENDOR_VSK" + (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
			
	        /* System properties : classpath/properties/subsystem-config.properties */
	        String target = SubSystemConfigFactory.get("VSK.ALPSVSK_UBIZHJS_VENDOR_VSK.IBMMQ.URL");
	        String transfertype =  SubSystemConfigFactory.get("VSK.ALPSVSK_UBIZHJS_VENDOR_VSK.IBMMQ.TRANSFERTYPE");
	        String channel =  SubSystemConfigFactory.get("VSK.ALPSVSK_UBIZHJS_VENDOR_VSK.IBMMQ.CHANNEL");
	        String factory =  SubSystemConfigFactory.get("VSK.ALPSVSK_UBIZHJS_VENDOR_VSK.IBMMQ.FACTORY");
	        //String queue =  SubSystemConfigFactory.get("VSK.ALPSVSK_UBIZHJS_VENDOR_VSK.IBMMQ.QUEUE");
	        String targetclient =  SubSystemConfigFactory.get("VSK.ALPSVSK_UBIZHJS_VENDOR_VSK.IBMMQ.TARGETCLIENT");
	    
	        eai = new IBMSendQClient(target, this.getClass());
	        eai.setTransferType(transfertype);
	        eai.setChannel(channel);
	        eai.setFactory(factory); 
	        eai.setQueue(queueName); 
	        eai.setTargetClient(targetclient);
	        eai.setMessage(flatFile);
        
            reString = eai.commit(integrationId); // 연동 ID부여를 준용한다.
            log.info("#####################################");
			log.info("EDI 전송결과 : " + reString);
			log.info("#####################################");
            
            
            return reString;
		} catch (EAIException e) {
			if(eai!=null){
				eai.rollback(e);
			}
	    	log.error("EAIException : " + e.getMessage(),e);
	        throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			if(eai!=null){
				eai.rollback(e);
			}
			log.error("Exception : " + e.getMessage(),e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}finally{
			eai.close();
		}
	}	
}
