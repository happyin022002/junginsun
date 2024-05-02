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
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.PriEdiRfGenInfVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RfaSlsLdCtrtInfoVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.TriPropSendMailVO;
import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.config.SiteConfigFactory;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.irep.cms.CMS0010001Document;
import com.hanjin.irep.cms.CMS0010001Document.CMS0010001;
import com.hanjin.irep.cms.CMS0010001Document.CMS0010001.DataArea.RFACollection;
import com.hanjin.irep.cms.CMS0010001Document.CMS0010001.DataArea.RFACollection.RFARequest;
import com.hanjin.irep.edi.EDI0080001Document;
import com.hanjin.irep.edi.EDI0080001Document.EDI0080001;
import com.hanjin.irep.edi.EDI0080001Document.EDI0080001.DataArea.RFGENINFCollection;
import com.hanjin.irep.edi.EDI0080001Document.EDI0080001.DataArea.RFGENINFCollection.RFGENINF;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;
import com.jf.transfer.ws.AxAyDocClient;

/**
 * CRM에 대한 EAI 처리를 담당<br>
 * - CRM Business Logic을 처리하기 위한 EAI 작업수행.<br>
 * 
 * @author Moon Dong Gyu
 * @see RFAProposalMainImpl 참조
 * @since J2EE 1.4
 */
public class RFAProposalMainEAIDAO extends EAIDAOSupport{

	/**
     * CRM : CMS001_0001<br>
     * RFA Sales Lead Contract 정보를 송신합니다.<br>
     * 
     * @param RfaSlsLdCtrtInfoVO rfaVo
     * @exception DAOException
     */
    public void transferRfaSalesLeadContractInfo (RfaSlsLdCtrtInfoVO rfaVo) throws DAOException {
        String target = "";
        String reString = "";
        TransferEAI eai = null;
        CMS0010001Document doc = null;
        CMS0010001 cms0010001 = null;
        com.hanjin.irep.cms.EAIHeaderType hearderType = null;
        RFACollection rfaCollection = null;
        RFARequest rfaRequest = null;

        try {
            target = SubSystemConfigFactory.get("PRI.CMS0010001.WSDL");
            eai = new AxAyDocClient(target, this.getClass());

            doc = CMS0010001Document.Factory.newInstance();
            cms0010001 = doc.addNewCMS0010001();
            hearderType = cms0010001.addNewEAIHeader();
            com.hanjin.irep.cms.EAIHeaderType.Parameters params = hearderType.addNewParameters();
            com.hanjin.irep.cms.EAIHeaderType.Parameters.Parameter param = params.addNewParameter();
            hearderType.setInstanceId("CMS001_0001" + (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date()));
            param.setStringValue("CMS001_0001--Header");

            rfaCollection = cms0010001.addNewDataArea().addNewRFACollection();

            if (rfaVo != null) {
                rfaRequest = rfaCollection.addNewRFARequest();

                rfaRequest.setPROPNO(JSPUtil.getNull(rfaVo.getPropNo()));
                rfaRequest.setAMDTSEQ(JSPUtil.getNull(rfaVo.getAmdtSeq()));
                rfaRequest.setRFANO(JSPUtil.getNull(rfaVo.getRfaNo()));
                rfaRequest.setCUSTCODE(JSPUtil.getNull(rfaVo.getCustCode()));
                rfaRequest.setSVCSCPCD(JSPUtil.getNull(rfaVo.getSvcScpCd()));
                rfaRequest.setEFFDT(JSPUtil.getNull(rfaVo.getEffDt()));
                rfaRequest.setEXPDT(JSPUtil.getNull(rfaVo.getExpDt()));
                rfaRequest.setPROPSREPCD(JSPUtil.getNull(rfaVo.getPropSrepCd()));
                rfaRequest.setPROPOFCCD(JSPUtil.getNull(rfaVo.getPropOfcCd()));
                rfaRequest.setSLSLDNO(JSPUtil.getNull(rfaVo.getSlsLdNo()));
                rfaRequest.setFNLMQCQTY(JSPUtil.getNull(rfaVo.getFnlMqcQty()));
                rfaRequest.setFILEDT(JSPUtil.getNull(rfaVo.getFileDt()));
            }

            eai.setMessage(doc.toString());
            long startTime = Calendar.getInstance().getTimeInMillis();
            log.debug("==============================================================================");
            log.debug(" EAIDAO start : " + startTime);
            log.debug("==============================================================================");
            log.debug("    transferRfaSalesLeadContractInfo Send   : \n" + doc.toString());
            log.debug("==============================================================================");

            reString = eai.commit(hearderType.getInstanceId());
            log.debug("==============================================================================");
            log.debug("    transferRfaSalesLeadContractInfo Result : \n" + reString);
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
     * EDI : EDI008_0001<br>
     * RFA General Information 을 송신합니다.<br>
     * 
     * @param PriEdiRfGenInfVO priEdiRfGenInfVO
     * @exception DAOException
     */
    public void transferRfaGeneralInfo (PriEdiRfGenInfVO priEdiRfGenInfVO) throws DAOException {
        String target = "";
        String reString = "";
        TransferEAI eai = null;
        EDI0080001Document doc = null;
        EDI0080001 edi0080001 = null;
        com.hanjin.irep.edi.EAIHeaderType hearderType = null;
        RFGENINFCollection rfgeninfCollection = null;
        RFGENINF rfgeninf = null;

        try {
            target = SubSystemConfigFactory.get("PRI.EDI0080001.WSDL");
            eai = new AxAyDocClient(target, this.getClass());

            doc = EDI0080001Document.Factory.newInstance();
            edi0080001 = doc.addNewEDI0080001();
            hearderType = edi0080001.addNewEAIHeader();
            com.hanjin.irep.edi.EAIHeaderType.Parameters params = hearderType.addNewParameters();
            com.hanjin.irep.edi.EAIHeaderType.Parameters.Parameter param = params.addNewParameter();
            hearderType.setInstanceId("EDI008_0001" + (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date()));
            param.setStringValue("EDI008_0001--Header");

            rfgeninfCollection = edi0080001.addNewDataArea().addNewRFGENINFCollection();

            if (priEdiRfGenInfVO != null) {
                rfgeninf = rfgeninfCollection.addNewRFGENINF();

                rfgeninf.setPROPNO(JSPUtil.getNull(priEdiRfGenInfVO.getPropNo()));
                rfgeninf.setAMENDSEQ(JSPUtil.getNull(priEdiRfGenInfVO.getAmdtSeq()));
                rfgeninf.setRFANO(JSPUtil.getNull(priEdiRfGenInfVO.getRfaNo()));
                rfgeninf.setCTRTCUSTCNTCD(JSPUtil.getNull(priEdiRfGenInfVO.getCtrtCustCntCd()));
                rfgeninf.setCTRTCUSTSEQ(JSPUtil.getNull(priEdiRfGenInfVO.getCtrtCustSeq()));
                rfgeninf.setPROPOFCCD(JSPUtil.getNull(priEdiRfGenInfVO.getPropOfcCd()));
                rfgeninf.setPROPSREPCD(JSPUtil.getNull(priEdiRfGenInfVO.getPropSrepCd()));
                rfgeninf.setCTRTEFFDT(JSPUtil.getNull(priEdiRfGenInfVO.getCtrtEffDt()));
                rfgeninf.setCTRTEXPDT(JSPUtil.getNull(priEdiRfGenInfVO.getCtrtExpDt()));
                rfgeninf.setEAISTS(JSPUtil.getNull(priEdiRfGenInfVO.getEaiSts()));
                rfgeninf.setEAIDT(JSPUtil.getNull(priEdiRfGenInfVO.getEaiDt()));
            }

            eai.setMessage(doc.toString());
            // eai.setObj(doc);
            long startTime = Calendar.getInstance().getTimeInMillis();
            log.debug("==============================================================================");
            log.debug(" EAIDAO start : " + startTime);
            log.debug("==============================================================================");
            log.debug("    transferRfaGeneralInfo Send   : \n" + doc.toString());
            log.debug("==============================================================================");

            reString = eai.commit(hearderType.getInstanceId());
            log.debug("==============================================================================");
            log.debug("    transferRfaGeneralInfo Result : \n" + reString);
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
     * RFA APPROVE 시 유저에게 G/W 메일 발송한다.<br>
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
    
}