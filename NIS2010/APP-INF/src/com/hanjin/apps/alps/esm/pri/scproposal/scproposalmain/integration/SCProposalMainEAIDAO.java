/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAProposalMainEAIDAO.java
*@FileTitle : 고객별 RFA 이력 조회
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.07.30 문동규
* 1.0 Creation
=========================================================
* History
* 2014.09.17 송호진 [CHM-201430558] FMC Auto-filing 개발 요청
* 2014.09.23 송호진 [CHM-201432102] FMC Auto-Filing 과 관련하여 성능 이슈 해결을 위한 Log 생성 - Key 추가
* 2015.05.15 송호진 [CHM-201535875] 10 번 Paragraph 관련 현상 해결 /rsumunknownvar argument 추가
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration;

import gov.fmc.servconWebServices.FileContractDocument;
import gov.fmc.servconWebServices.FileContractDocument.FileContract;
import gov.fmc.servconWebServices.FileContractResponseDocument;
import gov.fmc.servconWebServices.FileContractResponseDocument.FileContractResponse;
import gov.fmc.servconWebServices.FileCorrectedCopyDocument;
import gov.fmc.servconWebServices.FileCorrectedCopyDocument.FileCorrectedCopy;
import gov.fmc.servconWebServices.FileCorrectedCopyResponseDocument;
import gov.fmc.servconWebServices.FileCorrectedCopyResponseDocument.FileCorrectedCopyResponse;
import gov.fmc.servconWebServices.ServiceContractFiling;

import java.io.File;
import java.rmi.Naming;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;

import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.CstPriSpMnFileDtVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriEdiScGenInfVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.ScSlsLdCtrtInfoVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.TriPropSendMailVO;
import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rdexport.ReportDesignerExporter;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.io.FileUtils;
import com.hanjin.framework.core.config.SiteConfigFactory;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.irep.cms.CMS0020001Document;
import com.hanjin.irep.cms.CMS0020001Document.CMS0020001;
import com.hanjin.irep.cms.CMS0020001Document.CMS0020001.DataArea.SCCollection;
import com.hanjin.irep.cms.CMS0020001Document.CMS0020001.DataArea.SCCollection.SCRequest;
import com.hanjin.irep.edi.EDI0090001Document;
import com.hanjin.irep.edi.EDI0090001Document.EDI0090001;
import com.hanjin.irep.edi.EDI0090001Document.EDI0090001.DataArea.SCGENINFCollection;
import com.hanjin.irep.edi.EDI0090001Document.EDI0090001.DataArea.SCGENINFCollection.SCGENINF;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;
import com.jf.transfer.ws.AxAyDocClient;
import com.web.service.RMIInterface;
import com.web.service.rmi.model.RmiFmcObject;
/* RD Report Generate Module Import */
/* Webservice Module Import */


/**
 * CRM에 대한 EAI 처리를 담당<br>
 * - CRM Business Logic을 처리하기 위한 EAI 작업수행.<br>
 * 
 * @author Moon Dong Gyu
 * @see RFAProposalMainImpl 참조
 * @since J2EE 1.6
 */
public class SCProposalMainEAIDAO extends EAIDAOSupport{

	/**
	 * CRM : CMS002_0001<br>
     * S/C Sales Lead Contract 정보를 송신합니다.<br>
     * 
     * @param ScSlsLdCtrtInfoVO scVo
     * @throws DAOException
	 */
	public void transferScSalesLeadContractInfo(ScSlsLdCtrtInfoVO scVo) throws DAOException{
        String target                       = "";
        String reString                     = "";
        TransferEAI eai                     = null;
        CMS0020001Document doc              = null;
        CMS0020001 cms0020001               = null;
        com.hanjin.irep.cms.EAIHeaderType hearderType = null;
        SCCollection scCollection           = null;
        SCRequest scRequest                 = null;

        try{
            target = SubSystemConfigFactory.get("PRI.CMS0020001.WSDL");
            eai = new AxAyDocClient(target, this.getClass());
            
            doc = CMS0020001Document.Factory.newInstance();
            cms0020001  = doc.addNewCMS0020001();
            hearderType = cms0020001.addNewEAIHeader();
            com.hanjin.irep.cms.EAIHeaderType.Parameters params = hearderType.addNewParameters();
            com.hanjin.irep.cms.EAIHeaderType.Parameters.Parameter param = params.addNewParameter();
            hearderType.setInstanceId("CMS002_0001"+(new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date()));
            param.setStringValue("CMS002_0001--Header");

            scCollection = cms0020001.addNewDataArea().addNewSCCollection(); 
            
            if (scVo != null) {
                scRequest = scCollection.addNewSCRequest();
                
                scRequest.setPROPNO(JSPUtil.getNull(scVo.getPropNo()));
                scRequest.setAMDTSEQ(JSPUtil.getNull(scVo.getAmdtSeq()));
                scRequest.setSCNO(JSPUtil.getNull(scVo.getScNo()));
                scRequest.setCUSTCODE(JSPUtil.getNull(scVo.getCustCode()));
                scRequest.setEFFDT(JSPUtil.getNull(scVo.getEffDt()));
                scRequest.setEXPDT(JSPUtil.getNull(scVo.getExpDt()));
                scRequest.setPROPSREPCD(JSPUtil.getNull(scVo.getPropSrepCd()));
                scRequest.setPROPOFCCD(JSPUtil.getNull(scVo.getPropOfcCd()));
                scRequest.setSLSLDNO(JSPUtil.getNull(scVo.getSlsLdNo()));
                scRequest.setFNLMQCQTY(JSPUtil.getNull(scVo.getFnlMqcQty()));
                scRequest.setFILEDT(JSPUtil.getNull(scVo.getFileDt()));
            }
            
            eai.setMessage(doc.toString());

            long startTime = Calendar.getInstance().getTimeInMillis();
            log.debug("==============================================================================");
            log.debug(" EAIDAO start : "+startTime);
            log.debug("==============================================================================");
            log.debug("    transferScSalesLeadContractInfo Send   : \n"+doc.toString());
            log.debug("==============================================================================");
            
            reString = eai.commit(hearderType.getInstanceId());
            log.debug("==============================================================================");
            log.debug("    transferScSalesLeadContractInfo Result : \n" + reString);
            log.debug("==============================================================================");
            log.debug(" EAIDAO end : " + String.valueOf(Calendar.getInstance().getTimeInMillis() - startTime));
            log.debug("==============================================================================");

        } catch (EAIException e) {
            eai.rollback(e);
            log.error("EAIException : " + e.getMessage(),e);
            throw new DAOException(e.getMessage());
        } catch (Exception e) {
            eai.rollback(e);
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        }

        eai.close();
	}

    /**
     * EDI : EDI009_0001<br>
     * S/C General Information 을 송신합니다.<br>
     * 
     * @param PriEdiScGenInfVO priEdiScGenInfVO
     * @exception DAOException
     */
    public void transferScGeneralInfo (PriEdiScGenInfVO priEdiScGenInfVO) throws DAOException {
        String target = "";
        String reString = "";
        TransferEAI eai = null;
        EDI0090001Document doc = null;
        EDI0090001 edi0090001 = null;
        com.hanjin.irep.edi.EAIHeaderType hearderType = null;
        SCGENINFCollection scgeninfCollection = null;
        SCGENINF scgeninf = null;

        try {
            target = SubSystemConfigFactory.get("PRI.EDI0090001.WSDL");
            eai = new AxAyDocClient(target, this.getClass());

            doc = EDI0090001Document.Factory.newInstance();
            edi0090001 = doc.addNewEDI0090001();
            hearderType = edi0090001.addNewEAIHeader();
            com.hanjin.irep.edi.EAIHeaderType.Parameters params = hearderType.addNewParameters();
            com.hanjin.irep.edi.EAIHeaderType.Parameters.Parameter param = params.addNewParameter();
            hearderType.setInstanceId("EDI009_0001" + (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date()));
            param.setStringValue("EDI009_0001--Header");

            scgeninfCollection = edi0090001.addNewDataArea().addNewSCGENINFCollection();

            if (priEdiScGenInfVO != null) {
                scgeninf = scgeninfCollection.addNewSCGENINF();

                scgeninf.setPROPNO(JSPUtil.getNull(priEdiScGenInfVO.getPropNo()));
                scgeninf.setAMENDSEQ(JSPUtil.getNull(priEdiScGenInfVO.getAmdtSeq()));
                scgeninf.setSCNO(JSPUtil.getNull(priEdiScGenInfVO.getScNo()));
                scgeninf.setCUSTCNTCD(JSPUtil.getNull(priEdiScGenInfVO.getCustCntCd()));
                scgeninf.setCUSTSEQ(JSPUtil.getNull(priEdiScGenInfVO.getCustSeq()));
                scgeninf.setPROPOFCCD(JSPUtil.getNull(priEdiScGenInfVO.getPropOfcCd()));
                scgeninf.setPROPSREPCD(JSPUtil.getNull(priEdiScGenInfVO.getPropSrepCd()));
                scgeninf.setCTRTEFFDT(JSPUtil.getNull(priEdiScGenInfVO.getCtrtEffDt()));
                scgeninf.setCTRTEXPDT(JSPUtil.getNull(priEdiScGenInfVO.getCtrtExpDt()));
                scgeninf.setEAISTS(JSPUtil.getNull(priEdiScGenInfVO.getEaiSts()));
                scgeninf.setEAIDT(JSPUtil.getNull(priEdiScGenInfVO.getEaiDt()));
            }

            eai.setMessage(doc.toString());

            long startTime = Calendar.getInstance().getTimeInMillis();
            log.debug("==============================================================================");
            log.debug(" EAIDAO start : " + startTime);
            log.debug("==============================================================================");
            log.debug("    transferScGeneralInfo Send   : \n" + doc.toString());
            log.debug("==============================================================================");

            reString = eai.commit(hearderType.getInstanceId());
            log.debug("==============================================================================");
            log.debug("    transferScGeneralInfo Result : \n" + reString);
            log.debug("==============================================================================");
            log.debug(" EAIDAO end : " + String.valueOf(Calendar.getInstance().getTimeInMillis() - startTime));
            log.debug("==============================================================================");

        } catch (EAIException e) {
            eai.rollback(e);
            log.error("EAIException : " + e.getMessage(), e);
            throw new DAOException(e.getMessage(), e);
        } catch (Exception e) {
            eai.rollback(e);
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage(), e);
        }

        eai.close();
    }
    
    /**
     * S/C FILING 시 유저에게 G/W 메일 발송한다.<br>
     *  
     * @param TriPropSendMailVO sendMailVO
     * @param List<String> emailList
     * @return String
     * @exception DAOException 
     */
    public String sendEmail(TriPropSendMailVO sendMailVO, List<String> emailList) throws DAOException {
        try {
            Mail mail = new Mail();
            mail.setFrom(sendMailVO.getFromUser(), sendMailVO.getFromUserNm()); // FROM
            mail.setOfficeCode(sendMailVO.getOfcCd());

            String ssoTargetUrl = JSPUtil.getNull(SiteConfigFactory.get("COM.HANJIN.SSO.TARGET"));
            boolean isLive = false;     // Live 여부
            if (ssoTargetUrl.indexOf("alps.smlines.com") > 0) {
                isLive = true;
            } 
            
            if (isLive) {
                mail.setRecipients(emailList);          // TO : 담당자 리스트
            } else {
                List<String> elist = new ArrayList<String>();
                List<String> elistShort = new ArrayList<String>();
                elist.add("standy@cyberlogitec.com");
                elist.add("yjjeon@cyberlogitec.com");
                elist.add("seomijin@cyberlogitec.com");
                
                String preUsrId = "";
                for (int i = 0 ; i < elist.size() ; i++) {            	
                	if(!elist.get(i).equals(preUsrId)){
                		elistShort.add(elist.get(i));
                	}            	
                	preUsrId = elist.get(i);
                }                
                
                mail.setRecipients(elistShort);
            }

            mail.setRdSubSysCd("PRI");
            mail.setSubject(sendMailVO.getSubject()); 
            mail.setHtmlContent(sendMailVO.getHtmlContent());
            mail.setGroupwareMail();

            String sndNo = mail.send();
            log.debug(">>>>>>>>>> Send Mail No : "+sndNo);
            return sndNo;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(new ErrorHandler(e).getMessage(), e);
        }
    }

    /**
     * S/C FILING 을 Webservice 를 통해 FMC 에 송부 한 후 결과를 VO에 저장한다.<br>
     * FILECONTRACT<br>
     *  
     * @param CstPriSpMnFileDtVO vo
     * @exception DAOException 
     */
	public void sendFmcFileContract(CstPriSpMnFileDtVO vo) throws DAOException {
		//TransferEAI eai = null;
		FileContractResponseDocument docRes = null;
		String result = "";
		
		try {
			
			log.error ("RMI-FileContract-#2-1|"+vo.getScNo()+"|"+vo.getAmdtSeq()+"|"+vo.getFileProgSeq());
			//FileContract
			FileContractDocument fileContractDocument = FileContractDocument.Factory.newInstance();	
			FileContract fileContract = FileContract.Factory.newInstance();
			
			//RD 파일 첨부 (수정되어져야함)
			//File filename = new File("D:/WORK/GLO142607_#000.doc");
			log.error ("RMI-FileContract-#2-2|"+vo.getScNo()+"|"+vo.getAmdtSeq()+"|"+vo.getFileProgSeq());
			File filename = makeRdFile(vo);
	        log.error ("RMI-FileContract-#2-2-2|filename="+filename);

			log.error ("FileContract-#2-3|"+vo.getScNo()+"|"+vo.getAmdtSeq()+"|"+vo.getFileProgSeq());
			byte[] fileArray = FileUtils.getBytesFromFile(filename); 
			log.error ("FileContract-#2-4|"+vo.getScNo()+"|"+vo.getAmdtSeq()+"|"+vo.getFileProgSeq());
	        log.error ("FileContract-#2-date|"+vo.getEffDt());

			fileContract.setFileData(fileArray);
			fileContract.setFileName(filename.getName());
			
			fileContract.setOrgNum("027049");
			fileContract.setConNum(vo.getScNo());
			fileContract.setEffDate(vo.getEffDt());
			fileContract.setAmdNum(vo.getAmdtSeq());
			fileContract.setUserName("srjeon");
			
			fileContractDocument.setFileContract(fileContract);

			log.error ("FileContract-#2-5|"+vo.getScNo()+"|"+vo.getAmdtSeq()+"|"+vo.getFileProgSeq());
			//WSDL URL 지정
//			eai = new AxDocClient(SubSystemConfigFactory.get("FMC.WSDL"), this.getClass());
//			//SSL 접속 아이디/비밀번호
//			eai.setUserId("srjeon");
//			eai.setUserPasswd("H-z6eG5}!");
			//새로운 URL 테스트
//            eai = new AxDocClient("https://servconwebservicetest.fmc.gov/SERVCONWebservice.asmx", this.getClass());
//            //SSL 접속 아이디/비밀번호
//            eai.setUserId("TP_SERVCON_filing@smlines.com");
//            eai.setUserPasswd("027049SMLM*");			
//            log.error(">>>027049SMLM*<<<");
//
//			eai.setDestination(SubSystemConfigFactory.get("FMC.FILECONTRACT.URL"));
//		
//			eai.setMessage(fileContractDocument.toString());
//			log.error ("FileContract-#2-6|"+vo.getScNo()+"|"+vo.getAmdtSeq()+"|"+vo.getFileProgSeq());
//			eai.setCallTimeOut(300000);
//			log.error ("FileContract-#2-7|"+vo.getScNo()+"|"+vo.getAmdtSeq()+"|"+vo.getFileProgSeq());
//			result = eai.commit("");
			
            ///////////////////////////////////////////////////////////
            String serverUrl =SubSystemConfigFactory.get("FMC.RMI.URL");
            RMIInterface rmiClient =  (RMIInterface)Naming.lookup(serverUrl);
            RmiFmcObject object = new RmiFmcObject();
            object.setUserId("TP_SERVCON_filing@smlines.com");
            object.setUserPasswd("027049SMLM*");
            object.setDefaultServer(SubSystemConfigFactory.get("FMC.WSDL"));
            object.setSoapAction(SubSystemConfigFactory.get("FMC.FILECONTRACT.URL"));
            object.setMessage(fileContractDocument.toString());
            
            result = rmiClient.fmc(object);
            ////////////////////////////////////////////////////////////			
			
			log.error ("FileContract-#2-8|"+vo.getScNo()+"|"+vo.getAmdtSeq()+"|"+vo.getFileProgSeq());
			
            log.error ("\n\n=================================SEND Start==========================================\n\n");

            //log.error (fileContractDocument.toString());
            log.error ("\n\n=================================SEND End==========================================\n\n");

			log.error(result);
			
			docRes = FileContractResponseDocument.Factory.parse(result);
			FileContractResponse fileContractResponse = docRes.getFileContractResponse();
			ServiceContractFiling serviceContractFiling  = fileContractResponse.getFileContractResult();
			
			log.error(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			log.error(serviceContractFiling.toString());
			log.error(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			
			vo.setFmcFileNm(serviceContractFiling.getFileName());
			vo.setOrzNo(serviceContractFiling.getOrgNum());
			vo.setFmcCtrtNo(serviceContractFiling.getConNum());
			vo.setFmcAmdtNo(serviceContractFiling.getAmdNum()+"");
			vo.setFmcFileUsrId(serviceContractFiling.getUserName());
			vo.setFmcFileSessId(serviceContractFiling.getSessionId()+"");
			vo.setFmcNo(serviceContractFiling.getFMCNum()+"");
			vo.setFmcEffDt(serviceContractFiling.getEffDate());
			vo.setCfmNo(serviceContractFiling.getConfirmNum());
			vo.setFileSzCapa(serviceContractFiling.getFileSize()+"");
			
			
			vo.setErrCodeUserName(serviceContractFiling.getErrCodeUserName()+"");
			vo.setErrCodeOrgNum(serviceContractFiling.getErrCodeOrgNum()+"");
			vo.setErrCodeConNum(serviceContractFiling.getErrCodeConNum()+"");
			vo.setErrCodeAmdNum(serviceContractFiling.getErrCodeAmdNum()+"");
			vo.setErrCodeEffDate(serviceContractFiling.getErrCodeEffDate()+"");
			vo.setErrCodeFile(serviceContractFiling.getErrCodeFile()+"");
			
			vo.setErrMsgUserName(serviceContractFiling.getErrMsgUserName());
			vo.setErrMsgOrgNum(serviceContractFiling.getErrMsgOrgNum());
			vo.setErrMsgConNum(serviceContractFiling.getErrMsgConNum());
			vo.setErrMsgAmdNum(serviceContractFiling.getErrMsgAmdNum());
			vo.setErrMsgEffDate(serviceContractFiling.getErrMsgEffDate());
			vo.setErrMsgFile(serviceContractFiling.getErrMsgFile());
			log.error ("FileContract-#2-9|"+vo.getScNo()+"|"+vo.getAmdtSeq()+"|"+vo.getFileProgSeq());
			
			
			
		} catch (EAIException e) {
		    log.error ("FileContract-Exception1 ==>"+e.toString());
			//eai.rollback(e);
            throw new DAOException(e.getMessage());
		} catch (Exception e) {
	        log.error ("FileContract-Exception2 ==>"+e.toString());

			//eai.rollback(e);
			throw new DAOException(e.getMessage());
		}finally{
			//eai.close();
		}
	}
	
    /**
     * S/C FILING 을 Webservice 를 통해 FMC 에 송부 한 후 결과를 VO에 저장한다.<br>
     * FILECORRECTEDCOPY<br>
     *  
     * @param CstPriSpMnFileDtVO vo
     * @exception DAOException 
     */
	public void sendFmcFileCorrectedCopy(CstPriSpMnFileDtVO vo) throws DAOException {
		//TransferEAI eai = null;
		FileCorrectedCopyResponseDocument docRes = null;
		String result = "";
		
		try {
			
			log.error ("RMI-FileCorrectedCopy-#2-1|"+vo.getScNo()+"|"+vo.getAmdtSeq()+"|"+vo.getFileProgSeq());
			//FileCorrectedCopy
			FileCorrectedCopyDocument fileCorrectedCopyDocument = FileCorrectedCopyDocument.Factory.newInstance();	
			FileCorrectedCopy fileCorrectedCopy = FileCorrectedCopy.Factory.newInstance();
			
			//RD 파일 첨부 (수정되어져야함)
			//File filename = new File("D:/WORK/GLO142607_#000.doc");
			
			log.error ("RMI-FileCorrectedCopy-#2-2|"+vo.getScNo()+"|"+vo.getAmdtSeq()+"|"+vo.getFileProgSeq());
			File filename = makeRdFile(vo);
			log.error ("RMI-FileCorrectedCopy-#2-3|"+vo.getScNo()+"|"+vo.getAmdtSeq()+"|"+vo.getFileProgSeq());
			byte[] fileArray = FileUtils.getBytesFromFile(filename); 
			log.error ("FileCorrectedCopy-#2-4|"+vo.getScNo()+"|"+vo.getAmdtSeq()+"|"+vo.getFileProgSeq());
			fileCorrectedCopy.setFileData(fileArray);
			fileCorrectedCopy.setFileName(filename.getName());
			
			fileCorrectedCopy.setNewOrgNum("027049");
			fileCorrectedCopy.setOldOrgNum("027049");
			fileCorrectedCopy.setNewConNum(vo.getScNo());
			fileCorrectedCopy.setOldConNum(vo.getScNo());
			fileCorrectedCopy.setChangeFlag("File");
			fileCorrectedCopy.setAmdNum(vo.getAmdtSeq());
			fileCorrectedCopy.setUserName("srjeon");
			fileCorrectedCopy.setComments(vo.getFileCorrCmtCtnt());
			
			fileCorrectedCopyDocument.setFileCorrectedCopy(fileCorrectedCopy);
			
			log.error ("FileCorrectedCopy-#2-5|"+vo.getScNo()+"|"+vo.getAmdtSeq()+"|"+vo.getFileProgSeq());
			//WSDL URL 지정
//			eai = new AxDocClient(SubSystemConfigFactory.get("FMC.WSDL"), this.getClass());
//			//SSL 접속 아이디/비밀번호
//			eai.setUserId("srjeon");
//			eai.setUserPasswd("H-z6eG5}!");
//            log.error(">>>H-z6eG5}!<<<");
//            eai = new AxDocClient("https://servconwebservicetest.fmc.gov/SERVCONWebservice.asmx", this.getClass());
//            //SSL 접속 아이디/비밀번호
//            eai.setUserId("TP_SERVCON_filing@smlines.com");
//            eai.setUserPasswd("027049SMLM*");           
//            log.error(">>>027049SMLM*<<<");
//            
//            
//			eai.setDestination(SubSystemConfigFactory.get("FMC.FILECORRECTEDCOPY.URL")); 
//		
//			
//            log.error ("\n\n=================================SEND Start==========================================\n\n");
//
//            log.error (fileCorrectedCopyDocument.toString());
//            log.error ("\n\n=================================SEND End==========================================\n\n");
//
//			
//			log.error ("FileCorrectedCopy-#2-6|"+vo.getScNo()+"|"+vo.getAmdtSeq()+"|"+vo.getFileProgSeq());
//			eai.setMessage(fileCorrectedCopyDocument.toString());
//			eai.setCallTimeOut(300000);
//			log.error ("FileCorrectedCopy-#2-7|"+vo.getScNo()+"|"+vo.getAmdtSeq()+"|"+vo.getFileProgSeq());
//			result = eai.commit("");
//			
			
			
			
			
			///////////////////////////////////////////////////////////
		    String serverUrl =SubSystemConfigFactory.get("FMC.RMI.URL");
		    RMIInterface rmiClient =  (RMIInterface)Naming.lookup(serverUrl);
	        RmiFmcObject object = new RmiFmcObject();
	        object.setUserId("TP_SERVCON_filing@smlines.com");
	        object.setUserPasswd("027049SMLM*");
	        object.setDefaultServer(SubSystemConfigFactory.get("FMC.WSDL"));
	        object.setSoapAction(SubSystemConfigFactory.get("FMC.FILECORRECTEDCOPY.URL"));
	        object.setMessage(fileCorrectedCopyDocument.toString());
	        
	        result = rmiClient.fmc(object);
			////////////////////////////////////////////////////////////

			log.error ("FileCorrectedCopy-#2-8|"+vo.getScNo()+"|"+vo.getAmdtSeq()+"|"+vo.getFileProgSeq());
			log.error(result);
			
			docRes = FileCorrectedCopyResponseDocument.Factory.parse(result);
			FileCorrectedCopyResponse fileCorrectedCopyResponse = docRes.getFileCorrectedCopyResponse();
			ServiceContractFiling serviceContractFiling  = fileCorrectedCopyResponse.getFileCorrectedCopyResult();
			
			log.error(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			log.error(serviceContractFiling.toString());
			log.error(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			
			vo.setFmcFileNm(serviceContractFiling.getFileName());
			vo.setOrzNo(serviceContractFiling.getOrgNum());
			vo.setFmcCtrtNo(serviceContractFiling.getConNum());
			vo.setFmcAmdtNo(serviceContractFiling.getAmdNum()+"");
			vo.setFmcFileUsrId(serviceContractFiling.getUserName());
			vo.setFmcFileSessId(serviceContractFiling.getSessionId()+"");
			vo.setFmcNo(serviceContractFiling.getFMCNum()+"");
			vo.setFmcEffDt(serviceContractFiling.getEffDate());
			vo.setCfmNo(serviceContractFiling.getConfirmNum());
			vo.setFileSzCapa(serviceContractFiling.getFileSize()+"");
			
			
			vo.setErrCodeUserName(serviceContractFiling.getErrCodeUserName()+"");
			vo.setErrCodeOrgNum(serviceContractFiling.getErrCodeOrgNum()+"");
			vo.setErrCodeConNum(serviceContractFiling.getErrCodeConNum()+"");
			vo.setErrCodeAmdNum(serviceContractFiling.getErrCodeAmdNum()+"");
			vo.setErrCodeEffDate(serviceContractFiling.getErrCodeEffDate()+"");
			vo.setErrCodeFile(serviceContractFiling.getErrCodeFile()+"");
			
			vo.setErrMsgUserName(serviceContractFiling.getErrMsgUserName());
			vo.setErrMsgOrgNum(serviceContractFiling.getErrMsgOrgNum());
			vo.setErrMsgConNum(serviceContractFiling.getErrMsgConNum());
			vo.setErrMsgAmdNum(serviceContractFiling.getErrMsgAmdNum());
			vo.setErrMsgEffDate(serviceContractFiling.getErrMsgEffDate());
			vo.setErrMsgFile(serviceContractFiling.getErrMsgFile());
			log.error ("FileCorrectedCopy-#2-9|"+vo.getScNo()+"|"+vo.getAmdtSeq()+"|"+vo.getFileProgSeq());
			
			
		} catch (EAIException e) {
	        log.error ("FileCorrectedCopy-Exception1 ==>"+e.toString());

			//eai.rollback(e);
            throw new DAOException(e.getMessage());
		} catch (Exception e) {
            log.error ("FileCorrectedCopy-Exception2 ==>"+e.toString());

			//eai.rollback(e);
			throw new DAOException(e.getMessage());
		}finally{
			//eai.close();
		}

	}
	
   /**
     * S/C FILING RD 를 생성한다..<br>
     *  
     * @param CstPriSpMnFileDtVO vo
     * @return File
     * @exception Exception 
     */	
    private File makeRdFile(CstPriSpMnFileDtVO vo) throws Exception {
        File file = null;
        
        try {
            ReportDesignerExporter designerExport = new ReportDesignerExporter();
            designerExport.setExportFileName(vo.getScNo() + "_#000".substring(0, 5 - vo.getAmdtSeq().length()) + vo.getAmdtSeq()+".doc");       // 결과 파일명
            designerExport.setFileType(ExportInfo.FTYPE_DOC);   // 상수값
            // MRD 파일 명
            if ( Integer.parseInt(vo.getAmdtSeq()) == 0 ) {
                designerExport.setRdTmpltNm("ESM_PRI_0061.mrd");    
                designerExport.setReportParameters("/rsumunknownvar /rp [" + vo.getPropNo() +"] ["+vo.getAmdtSeq()+"] [Y] [Y] [A]");                // /rv 등 리포트 Parameter
            }
            else if ( Integer.parseInt(vo.getAmdtSeq()) > 0 ) {
                designerExport.setRdTmpltNm("ESM_PRI_0079.mrd");
                designerExport.setReportParameters("/rsumunknownvar /rp [" + vo.getPropNo() +"] ["+vo.getAmdtSeq()+"] [Y] [Y]");                // /rv 등 리포트 Parameter
            }
            
            String path = designerExport.doExportAndReturnPath();       
        
            file = new File(path);
                
        } catch(Exception e) {
            log.error(e.getMessage());
            throw e;
        }
        
        return file;
        
    }
}