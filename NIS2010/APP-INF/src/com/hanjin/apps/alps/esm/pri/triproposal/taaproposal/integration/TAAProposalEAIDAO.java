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
* 2011-08-17 송호진 [CHM-2011128680-01] [PRI] TAA화면에서 EAI(CMS013_0001)호출을 Confirm 후 Sales Rep. 변경시에도 호출 할수 있도록 변경
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.integration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.vo.RsltTaaMnVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.TriPropSendMailVO;
import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.config.SiteConfigFactory;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.irep.cms.CMS0130001Document;
import com.hanjin.irep.cms.CMS0130001Document.CMS0130001;
import com.hanjin.irep.cms.CMS0130001Document.CMS0130001.DataArea.TAACollection;
import com.hanjin.irep.cms.CMS0130001Document.CMS0130001.DataArea.TAACollection.TAARequest;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;
import com.jf.transfer.ws.AxAyDocClient;

/**
 * CRM에 대한 EAI 처리를 담당<br>
 * - CRM Business Logic을 처리하기 위한 EAI 작업수행.<br>
 * 
 * @author Moon Dong Gyu
 * @see TAAProposalImpl 참조
 * @since J2EE 1.6
 */
public class TAAProposalEAIDAO extends EAIDAOSupport{

    /**
     * CRM : CMS013_0001<br>
     * TAA 기본 정보를 CRM으로 송신합니다.<br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @return String
     * @exception DAOException
     */
    public String transferTAAMainInfo (RsltTaaMnVO rsltTaaMnVO) throws DAOException {
        String target = "";
        String reString = "";
        String reEaiIfId = "";
        TransferEAI eai = null;
        CMS0130001Document doc = null;
        CMS0130001 cms0130001 = null;
        com.hanjin.irep.cms.EAIHeaderType hearderType = null;
        TAACollection taaCollection = null;
        TAARequest taaRequest = null;

        try {
            target = SubSystemConfigFactory.get("PRI.CMS0130001.WSDL");
            log.debug(">>>>>>>>>>>>>>>>> TARGET : " + target);
            eai = new AxAyDocClient(target, this.getClass());

            doc = CMS0130001Document.Factory.newInstance();
            cms0130001 = doc.addNewCMS0130001();
            hearderType = cms0130001.addNewEAIHeader();
            com.hanjin.irep.cms.EAIHeaderType.Parameters params = hearderType.addNewParameters();
            com.hanjin.irep.cms.EAIHeaderType.Parameters.Parameter param = params.addNewParameter();
            reEaiIfId = "CMS013_0001" + (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
            hearderType.setInstanceId(reEaiIfId);
            param.setStringValue("CMS013_0001--Header");

            taaCollection = cms0130001.addNewDataArea().addNewTAACollection();

            if (rsltTaaMnVO != null) {
                taaRequest = taaCollection.addNewTAARequest();

                taaRequest.setTAAPROPNO(JSPUtil.getNull(rsltTaaMnVO.getTaaPropNo()));
                taaRequest.setAMDTSEQ(JSPUtil.getNull(rsltTaaMnVO.getAmdtSeq()));
                taaRequest.setTAANO(JSPUtil.getNull(rsltTaaMnVO.getTaaNo()));
                taaRequest.setCUSTCODE(JSPUtil.getNull(rsltTaaMnVO.getCtrtCustCd()));
                taaRequest.setSVCSCPCD(JSPUtil.getNull(rsltTaaMnVO.getSvcScpCd()));
                taaRequest.setEFFDT(JSPUtil.getNull(rsltTaaMnVO.getEffDt()));
                taaRequest.setEXPDT(JSPUtil.getNull(rsltTaaMnVO.getExpDt()));
                taaRequest.setPROPSREPCD(JSPUtil.getNull(rsltTaaMnVO.getRespbSrepCd()));
                taaRequest.setRESPBSLSOFCCD(JSPUtil.getNull(rsltTaaMnVO.getRespbSlsOfcCd()));
                taaRequest.setTAASTS(JSPUtil.getNull(rsltTaaMnVO.getTaaSts()));
            }

            eai.setMessage(doc.toString());
            long startTime = Calendar.getInstance().getTimeInMillis();
            log.debug("==============================================================================");
            log.debug(" EAIDAO start : " + startTime);
            log.debug("==============================================================================");
            log.debug("    transferTaaMainInfo Send   : \n" + doc.toString());
            log.debug("==============================================================================");

            reString = eai.commit(hearderType.getInstanceId());
            log.debug("==============================================================================");
            log.debug("    transferTaaMainInfo Result : \n" + reString );        
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
        return reEaiIfId;
    }
    
    /**
     * TAA confirm 이후 유저에게 G/W 메일 발송한다.<br>
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