/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderPreviewEAIDAO.java
*@FileTitle : W/O 발행화면
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-06
*@LastModifier : poong_yeon
*@LastVersion : 1.0
* 2006-12-06 poong_yeon
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration;

import java.util.ArrayList;
import java.util.List;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;
import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ServerExportException;

import com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.basic.WorkOrderPreviewBCImpl;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.event.EsdTrs0024Event;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.vo.WorkOrderPreviewVO;
import com.hanjin.framework.component.fax.FaxMetaInfo;
import com.hanjin.framework.component.fax.FaxUtility;
import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.framework.table.ComRptDsgnXptInfoVO;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;
import com.jf.transfer.jms.send.vandor.IBMSendQClient;


/**
 * ESD-workordermanage에 대한 EAI 처리를 담당<br>
 * - ESD-workordermanage Business Logic을 처리하기 위한 EAI 작업수행.<br>
 * 
 * @author poong_yeon
 * @see WorkOrderPreviewBCImpl 참조
 * @since J2EE 1.4
 */
public class WorkOrderPreviewEAIDAO extends EAIDAOSupport {	
		
    /**
	 * WorkOrder Send FAX
	 * @param e
	 * @param userId
	 * @exception Exception
	 */	
	public void sendEaiFax(Event e,String userId) throws EventException {
        EsdTrs0024Event event = (EsdTrs0024Event)e;
        try {
        	// Fax Utility를 이용하는 것은 SC, BC, DAO 어디에서든 가능하지만...
        	// DB Transaction이 발생하므로, begin(), commit(), rollback() 처리를 반드시 해주어야 함
          
            // 1. FaxMetaInfo를 생성한다.
            //    <Parameter>
            //    1) sysCd : 시스템 코드 (TPB, TRS 등)
            //    2) appCd : 업무 코드 (임시적으로 템플릿 파일명으로 정의한다.)
            //    3) batchInd : Batch 업무 유무 (Y/N)
            //    4) title : FAX 제목
            //    5) param : Report 생성시 필요한 Parameter
            //    6) rcvInfo : 수신자 정보
            //    7) office : 사용자의 Office 코드    
        	WorkOrderPreviewVO 	woVO = event.getWorkOrderPreviewVO();
           	String sysCd = woVO.getFaxSysCd();
        	String appCd = woVO.getFaxAppCd();
        	String batchInd = woVO.getFaxBatchInd();
        	String title = woVO.getFaxTitle();
        	String faxParam = woVO.getFaxParam();
        	String rcvInfo = woVO.getFaxRcvInfo();
        	String officeCd = event.getFormUsrOfcCd();
        	
        	String faxNo01 = woVO.getWoN1stFaxNo();
        	String faxNo02 = woVO.getWoN2ndFaxNo();
        	String faxNo03 = woVO.getWoN3rdFaxNo();
       	
        	if(faxNo01!=null && !faxNo01.equals("")){
        		faxNo01 = getOnlyNumber(faxNo01);
        		FaxMetaInfo info = new FaxMetaInfo(sysCd, appCd, batchInd, title, faxParam, rcvInfo+";"+faxNo01, officeCd, userId);
        		FaxUtility.registerDB(info);
        		woVO.setFaxNo01(info.getSndNo());
        	}
        	
        	if(faxNo02!=null && !faxNo02.equals("")){
        		faxNo02 = getOnlyNumber(faxNo02);
        		FaxMetaInfo info = new FaxMetaInfo(sysCd, appCd, batchInd, title, faxParam, rcvInfo+";"+faxNo02, officeCd, userId);
        		FaxUtility.registerDB(info);
        		woVO.setFaxNo02(info.getSndNo());
        	}
        	
        	if(faxNo03!=null && !faxNo03.equals("")){
        		faxNo03 = getOnlyNumber(faxNo03);
        		FaxMetaInfo info = new FaxMetaInfo(sysCd, appCd, batchInd, title, faxParam, rcvInfo+";"+faxNo03, officeCd, userId);
        		FaxUtility.registerDB(info);
           		woVO.setFaxNo03(info.getSndNo());
        	}
        	event.setWorkOrderPreviewVO(woVO);
        } catch (ServerExportException se) {
        	log.error(se.toString(), se);
			throw new EventException(se.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}

	/**
	 * Flat File을 전송한다. <br>
	 * EDI에 Flat파일을 전송한다.<br>
	 * 
	 * @param flatFile
	 * @param vndrSeq
	 * @return response ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public String sendFlatMessage(String flatFile, String vndrSeq) throws EventException {
		
		String resultStr = null;
		TransferEAI eai = null;
		String queue = "";
		try{
			String url = SubSystemConfigFactory.get("TRS.TRS_EDI_WO.IBMMQ.URL");
			String intergrationID = "1209";
			String transfertype = SubSystemConfigFactory.get("TRS.TRS_EDI_WO.IBMMQ.TRANSFERTYPE");
			String channel = SubSystemConfigFactory.get("TRS.TRS_EDI_WO.IBMMQ.CHANNEL");
			String factory = SubSystemConfigFactory.get("TRS.TRS_EDI_WO.IBMMQ.FACTORY");
			if(vndrSeq.equals("100253")) {
				queue = SubSystemConfigFactory.get("TRS.TRS_EDI_WO.IBMMQ.102297.QUEUE");
			} else {
				queue = SubSystemConfigFactory.get("TRS.TRS_EDI_WO.IBMMQ."+vndrSeq+".QUEUE");
			}
			String targetclient = SubSystemConfigFactory.get("TRS.TRS_EDI_WO.IBMMQ.TARGETCLIENT");
			
			eai = new IBMSendQClient(url, this.getClass());
			eai.setTransferType(transfertype);
			eai.setChannel(channel);
			eai.setFactory(factory);
			eai.setQueue(queue); 
			eai.setTargetClient(targetclient);
			eai.setMessage(flatFile);
			
			resultStr = eai.commit(intergrationID);
		} catch (EAIException eaie) {
			eai.rollback(eaie);
			
			log.error("err "+eaie.toString(),eaie);
			throw new EventException(eaie.getMessage());
		} 
		eai.close();
		
		return resultStr;
	}
	
	/**
	 * Flat File을 전송한다. <br>
	 * EDI에 Flat파일을 전송한다.<br>
	 * 
	 * @param flatFile
	 * @param vndrSeq
	 * @return response ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public String sendFlatMessageForESUM(String flatFile, String vndrSeq) throws EventException {

		String resultStr = null;
		TransferEAI eai = null;

		try{
			String url = SubSystemConfigFactory.get("TRS.TRS_EDI_WO_ESUM.IBMMQ.URL");
			String intergrationID = "1209";
			String transfertype = SubSystemConfigFactory.get("TRS.TRS_EDI_WO_ESUM.IBMMQ.TRANSFERTYPE");
			String channel = SubSystemConfigFactory.get("TRS.TRS_EDI_WO_ESUM.IBMMQ.CHANNEL");
			String factory = SubSystemConfigFactory.get("TRS.TRS_EDI_WO_ESUM.IBMMQ.FACTORY");
			String queue = SubSystemConfigFactory.get("TRS.TRS_EDI_WO_ESUM.IBMMQ."+vndrSeq+".QUEUE");
			String targetclient = SubSystemConfigFactory.get("TRS.TRS_EDI_WO_ESUM.IBMMQ.TARGETCLIENT");
			
			eai = new IBMSendQClient(url, this.getClass()); 
			eai.setTransferType(transfertype);
			eai.setChannel(channel);
			eai.setFactory(factory);
			eai.setQueue(queue); 
			eai.setTargetClient(targetclient);
			eai.setMessage(flatFile);
			
			resultStr = eai.commit(intergrationID); //EAI SEND QUEUE 방식에 따른 연동 ID부여를 준용한다.
			
		} catch (EAIException eaie) {
			eai.rollback(eaie);

			log.error("err "+eaie.toString(),eaie);
			throw new EventException(eaie.getMessage());
		} 
		eai.close();
		
		return resultStr;
	}
	
	/**
	 * Flat File을 전송한다. <br>
	 * EDI에 Flat파일을 전송한다.<br>
	 * 
	 * @param flatFile
	 * @return response ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public String sendUsaFlatMessage(String flatFile) throws EventException {

		String resultStr = null;
		TransferEAI eai = null;
		try{
			String url = SubSystemConfigFactory.get("TRS.TRS_EDI_USA204.IBMMQ.URL");
			String intergrationID = "12082";
			String transfertype = SubSystemConfigFactory.get("TRS.TRS_EDI_USA204.IBMMQ.TRANSFERTYPE");
			String channel = SubSystemConfigFactory.get("TRS.TRS_EDI_USA204.IBMMQ.CHANNEL");
			String factory = SubSystemConfigFactory.get("TRS.TRS_EDI_USA204.IBMMQ.FACTORY");
			String queue = SubSystemConfigFactory.get("TRS.TRS_EDI_USA204.IBMMQ.QUEUE");
			String targetclient = SubSystemConfigFactory.get("TRS.TRS_EDI_USA204.IBMMQ.TARGETCLIENT");
			
			eai = new IBMSendQClient(url, this.getClass());
			eai.setTransferType(transfertype);
			eai.setChannel(channel);
			eai.setFactory(factory);
			eai.setQueue(queue); 
			eai.setTargetClient(targetclient);
			eai.setMessage(flatFile);
			
			resultStr = eai.commit(intergrationID);
		} catch (EAIException eaie) {
			eai.rollback(eaie);
			
			log.error("err "+eaie.toString(),eaie);
			throw new EventException(eaie.getMessage());
		} 
		eai.close();
		
		return resultStr;
	}
	
	/**
	 * number만 가져오기<br>
	 * fax number로 가져온 String값중 int에 해당되는 값만 가져오기<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private String getOnlyNumber(String src){
		StringBuffer returnStr = null;
		int valueInt = 0;
		String src_temp = null;
		if (src == null || src.length() == 0){
			returnStr = null;
		}else{
			returnStr = new StringBuffer();
			for(int i=0; i<src.length(); i++){
				src_temp = src.substring(i, i+1);
				valueInt = src_temp.getBytes()[0];
				if( valueInt>=48 && valueInt <= 57){
					returnStr.append(src_temp);
				}
			}
		}
		
		return returnStr.toString();
	}	
	
	/**
	 * Flat File을 전송한다. <br>
	 * EDI에 Flat파일을 전송한다.<br>
	 * 
	 * @param flatFile
	 * @return response ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public String send317FlatMessage(String flatFile) throws EventException {
		log.debug("\n\n ★★★★★★★★★★★★★★★★★★ send317FlatMessage  ");
		String resultStr = null;
		TransferEAI eai = null;
		
		try{
			String url = SubSystemConfigFactory.get("TRS.TRS_EDI_USA317.IBMMQ.URL");
			String intergrationID = "12082";
			String transfertype = "MQJMS_TP_CLIENT_MQ_TCPIP";//SubSystemConfigFactory.get("TRS.TRS_EDI_USA317.IBMMQ.TRANSFERTYPE");
			String channel = SubSystemConfigFactory.get("TRS.TRS_EDI_USA317.IBMMQ.CHANNEL");
			String factory = SubSystemConfigFactory.get("TRS.TRS_EDI_USA317.IBMMQ.FACTORY");
			String queue = SubSystemConfigFactory.get("TRS.TRS_EDI_USA317.IBMMQ.QUEUE");
			String targetclient = SubSystemConfigFactory.get("TRS.TRS_EDI_USA317.IBMMQ.TARGETCLIENT");
			eai = new IBMSendQClient(url, this.getClass());
			eai.setTransferType(transfertype);
			eai.setChannel(channel);
			eai.setFactory(factory);
			eai.setQueue(queue); 
			eai.setTargetClient(targetclient);
			eai.setMessage(flatFile);	
			resultStr = eai.commit(intergrationID);
		} catch (EAIException eaie) {
			eai.rollback(eaie);
			
			log.error("err "+eaie.toString(),eaie);
			throw new EventException(eaie.getMessage());
			
		}
		
		eai.close();
		
		return resultStr;
	}
	
	/**
	 * @param e
	 * @param wonoRowSet
	 * @return
	 * @throws EventException
	 */
	public List emailSend(Event e,DBRowSet wonoRowSet) throws EventException{
		
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EsdTrs0024Event event = (EsdTrs0024Event)e;

        List<Mail> arrWoMail = new ArrayList();
        Mail woMail = null;
        
		String seml_snd1_no = "";
		String seml_snd2_no = "";
		String seml_snd3_no = ""; 
		int i = 0;
        try {
			WorkOrderPreviewVO 	woVO 		= event.getWorkOrderPreviewVO();
        	
        	String sysCd = woVO.getFaxSysCd();
        	String appCd = woVO.getFaxAppCd();
         	String emailParam = woVO.getFaxParam();
        	String emailTitle = woVO.getEmailTitle();
        	String emailContents = woVO.getEmailContents();
        	String userNm = event.getSignOnUserAccount().getUsr_nm();
        	String userEml = event.getSignOnUserAccount().getUsr_eml();
        	String userId = event.getSignOnUserAccount().getUsr_id();
        	
        	userEml = (userEml==null||userEml.trim().equals("")?"seokho9@smlines.com":userEml);
        	
         	String emailNo01 = woVO.getWoN1stEml();
        	String emailNo02 = woVO.getWoN2ndEml();
        	String emailNo03 = woVO.getWoN3rdEml();
       	
        	
        	if(wonoRowSet != null && wonoRowSet.next()){
        		emailTitle = emailTitle + "\'" 
        				+ wonoRowSet.getString("trsp_wo_ofc_cty_cd")
        				+ wonoRowSet.getString("trsp_wo_seq")
        				+ "\'";
        	}
       	
	    	List<ComRptDsgnXptInfoVO> comRptDsgnXptInfoVOs = new ArrayList<ComRptDsgnXptInfoVO>();
	    	ComRptDsgnXptInfoVO comRptDsgnXptInfoVO = null;
    		
    		comRptDsgnXptInfoVO = new ComRptDsgnXptInfoVO();
    		comRptDsgnXptInfoVO.setRdTmpltNm(appCd);
    		comRptDsgnXptInfoVO.setRdApplCd(sysCd);
    		comRptDsgnXptInfoVO.setRdParaCtnt(emailParam);
    		comRptDsgnXptInfoVO.setXptFileNm("Confirm MSG.pdf");
    		comRptDsgnXptInfoVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
    		comRptDsgnXptInfoVO.setCreUsrId(userId);
    		comRptDsgnXptInfoVO.setUpdUsrId(userId);
    		comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO);
    		
	    	if(emailNo01!=null && !emailNo01.equals("")){
	    		woMail = new Mail();	    		
	    		woMail.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOs);
	    		// woMail.setBatFlg(batch_ind);
	    		woMail.setRdSubSysCd(sysCd);		
	    		woMail.setSubject(emailTitle);
	    		woMail.setTextContent(emailContents);
	    		woMail.setRecipient(emailNo01);
	    		woMail.setFrom(userEml, userNm);
	    		arrWoMail.add(i, woMail);
	    		seml_snd1_no=woMail.send();
	    		woVO.setEmlNo01(seml_snd1_no);
	    		++i;
	    	}
    	
	    	if(emailNo02!=null && !emailNo02.equals("")){    		
	    		woMail = new Mail();	    		
	    		woMail.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOs);
	    		// woMail.setBatFlg(batch_ind);
	    		woMail.setRdSubSysCd(sysCd);		
	    		woMail.setSubject(emailTitle);
	    		woMail.setTextContent(emailContents);
	    		woMail.setRecipient(emailNo02);
	    		woMail.setFrom(userEml, userNm);
	    		arrWoMail.add(i, woMail);
	    		seml_snd2_no=woMail.send();
	    		woVO.setEmlNo02(seml_snd2_no);
	    		++i;
	    	}
    	
	    	if(emailNo03!=null && !emailNo03.equals("")){	    		
	    		woMail = new Mail();	    		
	    		woMail.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOs);
	    		// woMail.setBatFlg(batch_ind);
	    		woMail.setRdSubSysCd(sysCd);		
	    		woMail.setSubject(emailTitle);
	    		woMail.setTextContent(emailContents);
	    		woMail.setRecipient(emailNo03);
	    		woMail.setFrom(userEml, userNm);
	    		arrWoMail.add(i, woMail);
	    		seml_snd3_no=woMail.send();
	    		woVO.setEmlNo03(seml_snd3_no);
	    	}
						
			event.setWorkOrderPreviewVO(woVO);
		    		
	    } catch (ServerExportException se) {
	    	log.error("err " + se.toString(), se);
	    	throw new EventException(se.getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
		return arrWoMail;
	}	
}