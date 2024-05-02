package com.hanjin.apps.alps.bcm.ccd.ccdcommon.ccdcommon.integration;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.colatech.eai.client.framework.core.InterfaceData.ApplicationArea;
import com.colatech.eai.client.framework.core.TransferType;
import com.colatech.eai.client.framework.core.send.WebLogicQueueClient;
import com.colatech.eai.client.framework.core.util.ObjectCopy;
import com.hanjin.apps.alps.bcm.ccd.commoncode.asset.vo.ContainerVesselEAIVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.asset.vo.ContainerVesselMainIfVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.DaySavingTimeEAIVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.DaySavingTimeIfVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.LocationEaiVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.LocationMainIfVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.LseComYardEAIVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.LseComYardIfVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.YardEaiVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.YardMainIfVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.organization.vo.OfficeMainEAIVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.organization.vo.OfficeMainIfVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.VendorCheckDeliveryEaiVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.VendorCheckDeliveryIfVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.VendorContactEaiVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.VendorContactVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.VendorEaiVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.VendorIfVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.VendorTotalEaiVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.VendorTotalIfVO;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.integration.EAIException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
  
public class CcdCommonEAIDAO extends EAIDAOSupport {
	
	public void sendContainerVesselToMdm(ContainerVesselMainIfVO containerVesselMainIfVO, String usrId, String cudFlag) throws EAIException  {
		String url = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.SEND.URL");//"t3://172.20.94.187:7001";
		String factory = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.FACTORY");//"jms/ALPSJ_CFA";
		String queue = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.QUEUE");//"jms/ALPSJ_DQRA";
		log.debug("=======================================");
		log.debug("    \n Parameter Marshalling Start!    ");
		log.debug("=======================================");

		try{
			TransferType queueSend = new WebLogicQueueClient(url, WebLogicQueueClient.class);

			ApplicationArea appl = queueSend.getApplicationArea();
			appl.setSrcSysCd("CCD");
			appl.setMsgCreDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
			appl.setOpCd(cudFlag);
			appl.setMsgEtt("MDM VESSEL CONTAINER");
			
			/** 마스터 데이타 */
			ContainerVesselEAIVO containerVesselEaiVO =(ContainerVesselEAIVO) ObjectCopy.build(containerVesselMainIfVO, ContainerVesselEAIVO.class);
			containerVesselEaiVO.setFrbrdCapa(containerVesselMainIfVO.getFbdCapa());
			containerVesselEaiVO.setGnrTpCd(containerVesselMainIfVO.getGnrTpDesc());
			containerVesselEaiVO.setBwthstTpCd(containerVesselMainIfVO.getBwthstTpDesc());
			queueSend.getDataArea().setData(containerVesselEaiVO);
			
			String integrationId = (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
			queueSend.setFactory(factory);
			queueSend.setQueue(queue);
			queueSend.setDestination("MDM025_0001");
			System.out.println(queueSend.commit(integrationId));
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		}
	}
	
	public void sendOfcToMdm(OfficeMainIfVO ofcVO, String usrId, String cudFlag) throws EAIException  {
		String url = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.SEND.URL");//"t3://172.20.94.187:7001";
		String factory = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.FACTORY");//"jms/ALPSJ_CFA";
		String queue = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.QUEUE");//"jms/ALPSJ_DQRA";
		
		log.debug("=======================================");
		log.debug("    \n Parameter Marshalling Start!    ");
		log.debug("=======================================");
	
		try{
			TransferType queueSend = new WebLogicQueueClient(url, WebLogicQueueClient.class);
			
			ApplicationArea appl = queueSend.getApplicationArea();
			appl.setSrcSysCd("CCD");
			appl.setMsgCreDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
			appl.setOpCd(cudFlag);
			appl.setMsgEtt("MDM ORGANIZATION");
		
			/** 마스터 데이타 */
			OfficeMainEAIVO ofcEaiVO = (OfficeMainEAIVO) ObjectCopy.build(ofcVO, OfficeMainEAIVO.class);
			ofcEaiVO.setOfcRepreEml(ofcVO.getOfcRepEml());
			ofcEaiVO.setBkgSvrSearchRoutCd(ofcVO.getBkgSvrSrchRoutCd());
			ofcEaiVO.setOpnDt(ofcVO.getOpnDt());
			ofcEaiVO.setArCentrCd(ofcVO.getArCtrCd());
			ofcEaiVO.setRepreCntCd(ofcVO.getRepCustCntCd());
			ofcEaiVO.setRepreCustSeq(ofcVO.getRepCustSeq());
			ofcEaiVO.setApCentrCd(ofcVO.getApCtrCd());
			ofcEaiVO.setBfrOfcCd(ofcVO.getBfrOfcCd());
			ofcEaiVO.setGlCentrCd(ofcVO.getGlCtrCd());
			
			queueSend.getDataArea().setData(ofcEaiVO);

			String integrationId = (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
			queueSend.setFactory(factory);
			queueSend.setQueue(queue);
			queueSend.setDestination("MDM027_0001");
			System.out.println(queueSend.commit(integrationId));
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		}
	}
	public void sendDyLgtSavTmToMdm(DaySavingTimeIfVO dystVO, String usrId, String cudFlag) throws EAIException  {
		String url = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.SEND.URL");//"t3://172.20.94.187:7001";
		String factory = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.FACTORY");//"jms/ALPSJ_CFA";
		String queue = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.QUEUE");//"jms/ALPSJ_DQRA";
		
		log.debug("=======================================");
		log.debug("    \n Parameter Marshalling Start!    ");
		log.debug("=======================================");
		
		try{
			TransferType queueSend = new WebLogicQueueClient(url, WebLogicQueueClient.class);

			
			ApplicationArea appl = queueSend.getApplicationArea();
			appl.setSrcSysCd("CCD");
			appl.setMsgCreDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
			appl.setOpCd(cudFlag);
			appl.setMsgEtt("MDM DST");
		
			/** 마스터 데이타 */
			DaySavingTimeEAIVO dystEaiVO = (DaySavingTimeEAIVO) ObjectCopy.build(dystVO, DaySavingTimeEAIVO.class);
			dystEaiVO.setDstSteCd(dystVO.getDstNotAplySteCd());
			queueSend.getDataArea().setData(dystEaiVO);
			
			String integrationId = (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
			queueSend.setFactory(factory);
			queueSend.setQueue(queue);
			queueSend.setDestination("MDM061_0001");
			System.out.println(queueSend.commit(integrationId));
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		}
	}
	public void sendLseCoYdToMdm(LseComYardIfVO lseCoYdVO, String usrId, String cudFlag) throws EAIException  {
		String url = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.SEND.URL");//"t3://172.20.94.187:7001";
		String factory = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.FACTORY");//"jms/ALPSJ_CFA";
		String queue = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.QUEUE");//"jms/ALPSJ_DQRA";
		
		log.debug("=======================================");
		log.debug("    \n Parameter Marshalling Start!    ");
		log.debug("=======================================");
		
		try{
			TransferType queueSend = new WebLogicQueueClient(url, WebLogicQueueClient.class);
			
			ApplicationArea appl = queueSend.getApplicationArea();
			appl.setSrcSysCd("CCD");
			appl.setMsgCreDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
			appl.setOpCd(cudFlag);
			appl.setMsgEtt("MDM LEASING YARD");
		
			/** 마스터 데이타 */
			LseComYardEAIVO lseCoYdEaiVO = (LseComYardEAIVO) ObjectCopy.build(lseCoYdVO, LseComYardEAIVO.class);
			lseCoYdEaiVO.setLeasingCoYdCd(lseCoYdVO.getLseCoYdCd());
			lseCoYdEaiVO.setLeasingCoYdNm(lseCoYdVO.getLseCoYdNm());
			lseCoYdEaiVO.setOnoffHireYdFlg(lseCoYdVO.getOnfHirYdFlg());
			lseCoYdEaiVO.setLeasingCoVndrSeq1(lseCoYdVO.getLseCoVndrSeq1());
			lseCoYdEaiVO.setLeasingCoVndrSeq2(lseCoYdVO.getLseCoVndrSeq2());
			lseCoYdEaiVO.setLeasingCoVndrSeq3(lseCoYdVO.getLseCoVndrSeq3());
			lseCoYdEaiVO.setLeasingCoVndrSeq4(lseCoYdVO.getLseCoVndrSeq4());
			lseCoYdEaiVO.setLeasingCoVndrSeq5(lseCoYdVO.getLseCoVndrSeq5());
			lseCoYdEaiVO.setLeasingCoVndrSeq6(lseCoYdVO.getLseCoVndrSeq6());
			lseCoYdEaiVO.setLeasingCoVndrSeq7(lseCoYdVO.getLseCoVndrSeq7());
			lseCoYdEaiVO.setLeasingCoVndrSeq8(lseCoYdVO.getLseCoVndrSeq8());
			lseCoYdEaiVO.setLeasingCoVndrSeq9(lseCoYdVO.getLseCoVndrSeq9());
			lseCoYdEaiVO.setLeasingCoVndrSeq10(lseCoYdVO.getLseCoVndrSeq10());
			lseCoYdEaiVO.setLeasingCoVndrSeq11(lseCoYdVO.getLseCoVndrSeq11());
			lseCoYdEaiVO.setLeasingCoVndrSeq12(lseCoYdVO.getLseCoVndrSeq12());
			lseCoYdEaiVO.setLeasingCoVndrSeq13(lseCoYdVO.getLseCoVndrSeq13());
			lseCoYdEaiVO.setLeasingCoVndrSeq14(lseCoYdVO.getLseCoVndrSeq14());
			lseCoYdEaiVO.setLeasingCoVndrSeq15(lseCoYdVO.getLseCoVndrSeq15());
			lseCoYdEaiVO.setLeasingCoVndrSeq16(lseCoYdVO.getLseCoVndrSeq16());
			lseCoYdEaiVO.setLeasingCoVndrSeq17(lseCoYdVO.getLseCoVndrSeq17());
			lseCoYdEaiVO.setLeasingCoVndrSeq18(lseCoYdVO.getLseCoVndrSeq18());
			lseCoYdEaiVO.setLeasingCoVndrSeq19(lseCoYdVO.getLseCoVndrSeq19());
			lseCoYdEaiVO.setLeasingCoVndrSeq20(lseCoYdVO.getLseCoVndrSeq20());

			queueSend.getDataArea().setData(lseCoYdEaiVO);

			String integrationId = (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
			queueSend.setFactory(factory);
			queueSend.setQueue(queue);
			queueSend.setDestination("MDM055_0001");
			System.out.println(queueSend.commit(integrationId));
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		}
	}
	
	public void sendLocToEai(LocationMainIfVO locMainIfVO) throws EAIException {
		String url = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.SEND.URL");//"t3://172.20.94.187:7001";
		String factory = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.FACTORY"); //"jms/ALPSJ_CFA";
		String queue = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.QUEUE"); //"jms/ALPSJ_DQRA";
		
		log.debug("=========================================");
		log.debug("    \n Parameter Marshalling Start!      ");
		log.debug("=========================================");
		
		try {
			TransferType queueSend = new WebLogicQueueClient(url, WebLogicQueueClient.class);
			
			ApplicationArea appl = queueSend.getApplicationArea();
			appl.setSrcSysCd("CCD");
			appl.setMsgCreDt(new SimpleDateFormat("yyyyMMddHHssSSS").format(new Date()));
			appl.setOpCd(locMainIfVO.getCudFlg());
			appl.setMsgEtt("MDM LOCATION");
			
			LocationEaiVO locEaiVO = (LocationEaiVO) ObjectCopy.build(locMainIfVO, LocationEaiVO.class);
			locEaiVO.setGmtHors(locMainIfVO.getGmtHrs());
			locEaiVO.setUnLocFlg(locMainIfVO.getUnLocIndCd());
			locEaiVO.setBfrOfcChngDt(locMainIfVO.getBfrOfcCngDt());
			queueSend.getDataArea().setData(locEaiVO);
			
			String integrationId = (new SimpleDateFormat("yyyyMMddHHssSSS").format(new Date()));
			queueSend.setFactory(factory);
			queueSend.setQueue(queue);
			queueSend.setDestination("MDM031-0001");
			System.out.println(queueSend.commit(integrationId));
		} catch(Exception e) {
			e.printStackTrace();
		} 
	}
	
	public void sendYardToEai(YardMainIfVO ydMainIfVO) throws EAIException {
		String url = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.SEND.URL");//"t3://172.20.94.187:7001";
		String factory = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.FACTORY");
		String queue = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.QUEUE");
		
		log.debug("=========================================");
		log.debug("     \n Parameter Marshalling Start!     ");
		log.debug("=========================================");
		
		try {
			TransferType queueSend = new WebLogicQueueClient(url, WebLogicQueueClient.class);
			
			ApplicationArea appl = queueSend.getApplicationArea();
			appl.setSrcSysCd("CCD");
			appl.setMsgCreDt(new SimpleDateFormat("yyyyMMddHHssSSS").format(new Date()));
			appl.setOpCd(ydMainIfVO.getCudFlg());
			appl.setMsgEtt("MDM YARD");
			
			YardEaiVO ydEaiVO = (YardEaiVO) ObjectCopy.build(ydMainIfVO, YardEaiVO.class);
			ydEaiVO.setOnoffHireYdFlg(ydMainIfVO.getOnfHirYdFlg());
			ydEaiVO.setYdCgoClzHrMntDesc(ydMainIfVO.getYdCgoClzHrmntMsg());
			ydEaiVO.setYdInrRailFlg(ydMainIfVO.getYdInrlFlg());
			ydEaiVO.setYdPstPnmGcrnKnt(ydMainIfVO.getYdPstPgcKnt());
			ydEaiVO.setYdPnmGcrnKnt(ydMainIfVO.getYdPgcKnt());
			ydEaiVO.setYdStrdlCarrKnt(ydMainIfVO.getYdStrdlCrrKnt());
			ydEaiVO.setBfrOfcChngDt(ydMainIfVO.getBfrOfcCngDt());
			queueSend.getDataArea().setData(ydEaiVO);
			
			String integrationId = (new SimpleDateFormat("yyyyMMddHHssSSS").format(new Date()));
			queueSend.setFactory(factory);
			queueSend.setQueue(queue);
			queueSend.setDestination("MDM029-0001");
			System.out.println(queueSend.commit(integrationId));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sendVndrTotToEai(VendorTotalIfVO vndrTotIfVO) throws EAIException {
		String url = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.SEND.URL");//"t3://172.20.94.187:7001";
		String factory = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.FACTORY");
		String queue = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.QUEUE");
		
		log.debug("=========================================");
		log.debug("     \n Parameter Marshalling Start!     ");
		log.debug("=========================================");
		
		try {
			TransferType queueSend = new WebLogicQueueClient(url, WebLogicQueueClient.class);
			
			ApplicationArea appl = queueSend.getApplicationArea();
			appl.setSrcSysCd("CCD");
			appl.setMsgCreDt(new SimpleDateFormat("yyyyMMddHHssSSS").format(new Date()));
			appl.setOpCd(vndrTotIfVO.getCudFlg());
			appl.setMsgEtt("MDM VENDOR TOTAL");
			
			VendorTotalEaiVO vndrTotEaiVO = (VendorTotalEaiVO) ObjectCopy.build(vndrTotIfVO, VendorTotalEaiVO.class);
			vndrTotEaiVO.setTaxPayrId(vndrTotIfVO.getTaxId());
			vndrTotEaiVO.setDgCgoHndlFlg(vndrTotIfVO.getDcgoHndlFlg());
			vndrTotEaiVO.setCntcPsonNmNm(vndrTotIfVO.getCntcPsonNm());
			vndrTotEaiVO.setMtyRlseRdeOrdEdiUseFlg(vndrTotIfVO.getMtyRroEdiUseFlg());
			vndrTotEaiVO.setProcurementFlg(vndrTotIfVO.getProcuFlg());
			vndrTotEaiVO.setVndrCntcPrmryFlg(vndrTotIfVO.getPrmryChkFlg());
			vndrTotEaiVO.setInterCoCd(vndrTotIfVO.getSubsCoCd());
			queueSend.getDataArea().setData(vndrTotEaiVO);
			
			String integrationId = (new SimpleDateFormat("yyyyMMddHHssSSS").format(new Date()));
			queueSend.setFactory(factory);
			queueSend.setQueue(queue);
			queueSend.setDestination("MDM019-0001");
			System.out.println(queueSend.commit(integrationId));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sendVndrToEai(VendorIfVO vndrIfVO) throws EAIException {
		String url = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.SEND.URL");//"t3://172.20.94.187:7001";
		String factory = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.FACTORY");
		String queue = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.QUEUE");
		
		log.debug("=========================================");
		log.debug("     \n Parameter Marshalling Start!     ");
		log.debug("=========================================");
		
		
		try {
			TransferType queueSend = new WebLogicQueueClient(url, WebLogicQueueClient.class);
			
			ApplicationArea appl = queueSend.getApplicationArea();
			appl.setSrcSysCd("CCD");
			appl.setMsgCreDt(new SimpleDateFormat("yyyyMMddHHssSSS").format(new Date()));
			appl.setOpCd(vndrIfVO.getCudFlg());
			appl.setMsgEtt("MDM VENDOR");
			
			VendorEaiVO vndrEaiVO = (VendorEaiVO) ObjectCopy.build(vndrIfVO, VendorEaiVO.class);
			vndrEaiVO.setTaxPayrId(vndrIfVO.getTaxId());
			vndrEaiVO.setDgCgoHndlFlg(vndrIfVO.getDcgoHndlFlg());
			vndrEaiVO.setCntcPsonNmNm(vndrIfVO.getCntcPsonNm());
			vndrEaiVO.setMtyRlseRdeOrdEdiUseFlg(vndrIfVO.getMtyRroEdiUseFlg());
			vndrEaiVO.setProcurementFlg(vndrIfVO.getProcuFlg());
			vndrEaiVO.setInterCoCd(vndrIfVO.getSubsCoCd());
			queueSend.getDataArea().setData(vndrEaiVO);
			
			String integrationId = (new SimpleDateFormat("yyyyMMddHHssSSS").format(new Date()));
			queueSend.setFactory(factory);
			queueSend.setQueue(queue);
			queueSend.setDestination("MDM021-0001");
			System.out.println(queueSend.commit(integrationId));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sendVndrCntcToEai(VendorContactVO vndrCntcVO) throws EAIException {
		String url = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.SEND.URL");//"t3://172.20.94.187:7001";
		String factory = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.FACTORY");
		String queue = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.QUEUE");
		
		log.debug("=========================================");
		log.debug("     \n Parameter Marshalling Start!     ");
		log.debug("=========================================");
		
		try {
			TransferType queueSend = new WebLogicQueueClient(url, WebLogicQueueClient.class);
			
			ApplicationArea appl = queueSend.getApplicationArea();
			appl.setSrcSysCd("CCD");
			appl.setMsgCreDt(new SimpleDateFormat("yyyyMMddHHssSSS").format(new Date()));
			appl.setOpCd(vndrCntcVO.getCudFlg());
			appl.setMsgEtt("MDM VENDOR CONTACT POINT");
			
			VendorContactEaiVO vndrCntcEaiVO = (VendorContactEaiVO) ObjectCopy.build(vndrCntcVO, VendorContactEaiVO.class);
			vndrCntcEaiVO.setVndrCntcPrmryFlg(vndrCntcVO.getPrmryChkFlg());
			queueSend.getDataArea().setData(vndrCntcEaiVO);
			
			String integrationId = (new SimpleDateFormat("yyyyMMddHHssSSS").format(new Date()));
			queueSend.setFactory(factory);
			queueSend.setQueue(queue);
			queueSend.setDestination("MDM022-0001");
			System.out.println(queueSend.commit(integrationId));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param vndrChkDelIfVO
	 * @throws EAIException
	 */
	public void sendVndrChkDelToEai(VendorCheckDeliveryIfVO vndrChkDelIfVO) throws EAIException {
		String url = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.SEND.URL");//"t3://172.20.94.187:7001";
		String factory = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.FACTORY");
		String queue = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.QUEUE");
		
		log.debug("=========================================");
		log.debug("     \n Parameter Marshalling Start!     ");
		log.debug("=========================================");
		
		try {
			TransferType queueSend = new WebLogicQueueClient(url, WebLogicQueueClient.class);

			ApplicationArea appl = queueSend.getApplicationArea();
			appl.setSrcSysCd("CCD");
			appl.setMsgCreDt(new SimpleDateFormat("yyyyMMddHHssSSS").format(new Date()));
			appl.setOpCd(vndrChkDelIfVO.getCudFlg());
			appl.setMsgEtt("MDM VENDOR CHECK DELIVERY ADDRESS");
			
			VendorCheckDeliveryEaiVO vndrChkDelEaiVO = (VendorCheckDeliveryEaiVO) ObjectCopy.build(vndrChkDelIfVO, VendorCheckDeliveryEaiVO.class);
			queueSend.getDataArea().setData(vndrChkDelEaiVO);

			String integrationId = (new SimpleDateFormat("yyyyMMddHHssSSS").format(new Date()));
			queueSend.setFactory(factory);
			queueSend.setQueue(queue);
			queueSend.setDestination("MDM059-0001");
			System.out.println(queueSend.commit(integrationId));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
