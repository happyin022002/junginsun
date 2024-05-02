package com.hanjin.sample.eai.jms.send;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.colatech.eai.client.framework.core.InterfaceData.ApplicationArea;
import com.colatech.eai.client.framework.core.InterfaceData.DataArea;
import com.colatech.eai.client.framework.core.TransferType;
import com.colatech.eai.client.framework.core.send.WebLogicQueueClient;

public class WeblogicJms {

	public static void main(String[] args) throws Exception {
		String url = "t3://172.20.94.187:7001";
		String factory = "jms/ALPSJ_CFA";
		String queue = "jms/ALPSJ_DQRA";
		try{
			
			TransferType queueSend = new WebLogicQueueClient(url, WebLogicQueueClient.class);
		
			ApplicationArea appl = queueSend.getApplicationArea();
			appl.setSrcSysCd("CE");
			appl.setMsgCreDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
			appl.setOpCd("U");
			appl.setMsgEtt("MDM CUSTOMER");
		
			DataArea data = queueSend.getDataArea();
		
			MdmCustomerVO vo = new MdmCustomerVO();
			vo.setCustCntCd("KR");
			vo.setCustSeq("585");
			vo.setCntrDivFlg("Y");
			vo.setBlkDivFlg("N");
			vo.setCustGrpId("G-KR000585");
			vo.setCustLglEngNm("SAMSUNG ELECTRONICS CO.,LTD. TEST");
			vo.setRvisCntrCustTpCd("B");
			vo.setOfcCd("SELSC");
			
			data.setData(vo);
			
			String integrationId = (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
			queueSend.setFactory(factory);
			queueSend.setQueue(queue);
			queueSend.setDestination("MDM002-0001");
			System.out.println(queueSend.commit(integrationId));
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		}
	}
	
	/* 단건 전송
	public static void main(String[] args) throws Exception {
		String url = "t3://172.20.94.187:7001";
		String factory = "jms/ALPSJ_CFA";
		String queue = "jms/ALPSJ_DQRA";
		
		TransferType queueSend = new WebLogicQueueClient(url, WebLogicQueueClient.class);
							  // 프로젝트명.모듈명.생성날짜
		String integrationId = (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
		try{
			MdmLocationVO vo = new MdmLocationVO();
			vo.setCreUsrId("Test");
			queueSend.setFactory(factory);
			queueSend.setQueue(queue);
			queueSend.setDestination("ALPS.MDM001-0001");
			queueSend.setMessage(vo);
			System.out.println(queueSend.commit(integrationId));
		}catch(Exception e){
			
		}finally{
			queueSend.close();
		}
	}
	*/

}
