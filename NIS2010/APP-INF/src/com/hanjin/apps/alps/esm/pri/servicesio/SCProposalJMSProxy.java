/* =========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SCProposalJMSProxy.java
 *@FileTitle : Receive WebLogic JMS Queue Proxy
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.10
 *@LastModifier : 변영주
 *@LastVersion : 1.0
 * 2009.08.10 변영주
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.pri.servicesio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;

import com.hanjin.apps.alps.esm.pri.primasterdata.crmsaleslead.event.Cms0110001Event;
import com.hanjin.apps.alps.esm.pri.scproposal.SCProposalSC;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event.Esm0680001Event;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.irep.cms.CMS0110001Document;
import com.hanjin.irep.cms.CMS0110001Document.CMS0110001;
import com.hanjin.irep.cms.CMS0110001Document.CMS0110001.DataArea.SalesLeadCollection;
import com.hanjin.irep.cms.CMS0110001Document.CMS0110001.DataArea.SalesLeadCollection.SalesLead;
import com.hanjin.irep.enisEsm.ESM0680001Document;
import com.hanjin.irep.enisEsm.ESM0680001Document.ESM0680001;
import com.hanjin.irep.enisEsm.ESM0680001Document.ESM0680001.DataArea.SCProposalCollection;
import com.hanjin.irep.enisEsm.ESM0680001Document.ESM0680001.DataArea.SCProposalCollection.SCProposal;
import com.hanjin.syscommon.common.table.PriCrmSlsLdVO;
import com.jf.transfer.TransferEAI;

/**
 * JMS Inbound 연동 프로그램<br>
 * - NIS 와 Interface 작업을 처리하는 클래스이다.<br>
 * 
 * @author Byeon Young Joo
 * @see
 * @since J2EE 1.6 May 25, 2009
 */
public class SCProposalJMSProxy {

    protected transient Logger log = Logger.getLogger(this.getClass().getName());

    /**
     * CRM : ESM068_0001<br> 
     * NIS 으로부터 받은 Proposal 정보를 저장합니다.<br>
     * 
     * @param TransferEAI eai
     */
    public void receiveNISProposalInfo (TransferEAI eai){

        log.debug("<<<<<<<<<< JMS receiveNISProposalInfo Start >>>>>>>>>>>>>>>>");

        String str = eai.getMessage();
        log.debug("S ======================================");
        log.debug("xml : \n" + str);
        log.debug("E ======================================");

        Event event = null;
        SCProposalSC sCProposalSC = new SCProposalSC();

        try {
            event = new Esm0680001Event();
            FormCommand f = new FormCommand();
            f.setCommand(FormCommand.MULTI);
            event.setFormCommand(f);

            ESM0680001Document doc = ESM0680001Document.Factory.parse(str);
            ESM0680001 esm0680001 = doc.getESM0680001();
            
            com.hanjin.irep.enisEsm.ESM0680001Document.ESM0680001.DataArea dataArea = esm0680001.getDataArea();
            SCProposalCollection sCProposalCollection = dataArea.getSCProposalCollection();

            int cnt = sCProposalCollection.sizeOfSCProposalArray();
            if (cnt > 0) {
            	SCProposal[] sCProposals = sCProposalCollection.getSCProposalArray();
            	((Esm0680001Event) event).setPropNo(sCProposals[0].getPROPNO());
            	((Esm0680001Event) event).setAmdtNo(sCProposals[0].getAMDTNO());
            	((Esm0680001Event) event).setOpCd(sCProposals[0].getOPCD());
                sCProposalSC.perform(event);
            }
            eai.commit(doc.getESM0680001().getEAIHeader().getInstanceId());
        } catch (EventException ee) {
            log.error("EventException ee : " + ee.toString(), ee);
            eai.rollback(ee);
        } catch (XmlException ex) {
            log.error("XmlException ex : " + ex.toString(), ex);
            eai.rollback(ex);
        } catch (Exception e) {
            log.error("Exception e : " + e.toString());
            eai.rollback(e);
        }
        eai.close();
        log.debug("<<<<<<<<<< JMS receiveNISProposalInfo End >>>>>>>>>>>>>>>>");
    }

}
