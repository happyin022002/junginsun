/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EBookingReceiptEAIDAO.java
 *@FileTitle : EDI test
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.05
 *@LastModifier : 전용진
 *@LastVersion : 1.0
 * 2009.06.05 전용진
 * 1.0 Creation 
 * 2011.01.18 전성진 [] 에러메일 수신인 추가
 * 2011.04.18 손은주 [CHM-201110188-01] [ALPS] BKG/SI Notification (EDI) 메뉴 오픈 요청
 * 2011.04.21 손은주 [CHM-201110188-01] [ALPS] BKG/SI Notification (EDI) 메뉴 오픈 요청 - sendXterRqstNotice() 삭제
 * 2011.07.05 이일민 Simple EDI 오류메일 전송 라이브 적용 - 이메일 주소 변경
 * 2011.07.14 김진승 [CHM-201111820] Split 03-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치
 * 2012.07.20 김진주 e-BKG 수신 오류 메일발송대상 추가(EBD - Dcube admin계정)
 * 2012.11.09 김진주 e-BKG 수신 오류 메일발송대상 변경
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.salesrepresentative.integration;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.colatech.eai.client.framework.core.TransferType;
import com.colatech.eai.client.framework.core.InterfaceData.ApplicationArea;
import com.colatech.eai.client.framework.core.send.WebLogicQueueClient;
import com.colatech.eai.client.framework.core.util.ObjectCopy;
import com.hanjin.apps.alps.bcm.ccd.commoncode.salesrepresentative.vo.SalesRepEaiVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.salesrepresentative.vo.SalesRepIfVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.salesrepresentative.vo.SalesRepVO;

import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.jf.transfer.eai.exception.EAIException;

/**
 * ALPS EBookingReceiptEAIDAO <br>
 * - ALPS-EBookingConduct system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Jun Yong Jin
 * @see EBookingReceiptBCImpl 참조
 * @since J2EE 1.6
 */
public class SalesRepresentativeEAIDAO extends EAIDAOSupport {
	/**
	 * Customer master Interface.<br>
	 *
	 * @param String usrId
	 * @param customerVO CustomerVO
	 * @exception EAIException
	 */
	public void sendSrepCdToMdm(SalesRepIfVO salesRepIfVO, String usrId, String creFlag) throws EAIException  {
		String url = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.SEND.URL");//"t3://172.20.94.187:7001";
		String factory = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.FACTORY");//"jms/ALPSJ_CFA";
		String queue = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.QUEUE");//"jms/ALPSJ_DQRA";
		
		log.debug("=======================================");
		log.debug("    \n Parameter Marshalling Start!    ");
		log.debug("=======================================");
		
		try{
			TransferType queueSend = new WebLogicQueueClient(url, WebLogicQueueClient.class);
		
			ApplicationArea appl = queueSend.getApplicationArea();
			appl.setSrcSysCd("CMS");
			appl.setMsgCreDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
			appl.setOpCd(creFlag);
			appl.setMsgEtt("MDM SALES REP");
		
			/** 마스터 데이타 */
			SalesRepEaiVO salesRepEaiVO = (SalesRepEaiVO) ObjectCopy.build(salesRepIfVO, SalesRepEaiVO.class);
			queueSend.getDataArea().setData(salesRepEaiVO);
			
			/** 서브 데이타 */
			/*VndrSubVO subVo = new VndrSubVO();
			subVo.setCntrVndrSvcCd("");
			subVo.setVndrClssRowId("");
			subVo.setVndrCostCd("");
			queueSend.getSubDataArea().setNodeData("VndrClss/VndrClssIns", subVo);*/
			
			String integrationId = (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
			queueSend.setFactory(factory);
			queueSend.setQueue(queue);
			queueSend.setDestination("MDM004_0001");
			System.out.println(queueSend.commit(integrationId));
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		}
		
		/*TransferType queueSend = new WebLogicQueueClient(url, WebLogicQueueClient.class);
		  TransferType queueSend = null;
			
		try{
			queueSend = new WebLogicQueueClient(url, WebLogicQueueClient.class);
			  // 프로젝트명.모듈명.생성날짜
			String integrationId = (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
			salesRepVO.setCudFlg(creFlag);
			queueSend.setFactory(factory);
			queueSend.setQueue(queue);
			queueSend.setDestination("ALPS.MDM004_0001");
			queueSend.setMessage(salesRepVO);
			System.out.println(queueSend.commit(integrationId));
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if (queueSend != null) {
				queueSend.close();
			}
		}*/
	}
	
}