/* =========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : PRIMasterDataJMSProxy.java
 *@FileTitle : Receive WebLogic JMS Queue Proxy
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.10
 *@LastModifier : 문동규
 *@LastVersion : 1.0
 * 2009.08.10 문동규
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.pri.servicesio;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;

import com.hanjin.apps.alps.esm.pri.primasterdata.PRIMasterDataSC;
import com.hanjin.apps.alps.esm.pri.primasterdata.crmkeyman.event.Cms0120001Event;
import com.hanjin.apps.alps.esm.pri.primasterdata.crmsaleslead.event.Cms0110001Event;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.irep.cms.CMS0110001Document;
import com.hanjin.irep.cms.CMS0120001Document;
import com.hanjin.irep.cms.CMS0110001Document.CMS0110001;
import com.hanjin.irep.cms.CMS0110001Document.CMS0110001.DataArea.SalesLeadCollection;
import com.hanjin.irep.cms.CMS0110001Document.CMS0110001.DataArea.SalesLeadCollection.SalesLead;
import com.hanjin.irep.cms.CMS0120001Document.CMS0120001;
import com.hanjin.irep.cms.CMS0120001Document.CMS0120001.DataArea.KeyManCollection;
import com.hanjin.irep.cms.CMS0120001Document.CMS0120001.DataArea.KeyManCollection.KeyMan;
import com.hanjin.syscommon.common.table.PriCrmCustKmanVO;
import com.hanjin.syscommon.common.table.PriCrmSlsLdVO;
import com.jf.transfer.TransferEAI;

/**
 * JMS Inbound 연동 프로그램<br>
 * - CRM 과 Interface 작업을 처리하는 클래스이다.<br>
 * 
 * @author Moon Dong Gyu
 * @see
 * @since J2EE 1.6 May 25, 2009
 */
public class PRIMasterDataJMSProxy {

    protected transient Logger log = Logger.getLogger(this.getClass().getName());

    /**
     * CRM : CMS011_0001<br>
     * CRM으로부터 받은 Sales Lead 정보를 저장합니다.<br>
     * 
     * @param TransferEAI eai
     */
    public void receiveCRMSalesLead (TransferEAI eai){

        log.debug("<<<<<<<<<< JMS receiveCRMSalesLead Start >>>>>>>>>>>>>>>>");

        String str = eai.getMessage();
        log.debug("S ======================================");
        log.debug("xml : \n" + str);
        log.debug("E ======================================");

        Event event = null;
        PRIMasterDataSC priMasterDataSC = new PRIMasterDataSC();

        try {
            event = new Cms0110001Event();

            FormCommand f = new FormCommand();
            f.setCommand(FormCommand.MULTI);
            event.setFormCommand(f);

            CMS0110001Document doc = CMS0110001Document.Factory.parse(str);
            CMS0110001 cms0110001 = doc.getCMS0110001();
            com.hanjin.irep.cms.CMS0110001Document.CMS0110001.DataArea dataArea = cms0110001.getDataArea();
            
            SalesLeadCollection salesLeadCollection = dataArea.getSalesLeadCollection();
            
            int cnt = salesLeadCollection.sizeOfSalesLeadArray();
            
            if (cnt > 0) {
                SalesLead[] salesLeads = salesLeadCollection.getSalesLeadArray();
                ArrayList<PriCrmSlsLdVO> list = new ArrayList<PriCrmSlsLdVO>();
                PriCrmSlsLdVO priCrmSlsLdVO = new PriCrmSlsLdVO();
                PriCrmSlsLdVO[] priCrmSlsLdVOs = new PriCrmSlsLdVO[cnt];

                for (int i = 0; i < cnt; i++) {
                    priCrmSlsLdVO = new PriCrmSlsLdVO();
                    priCrmSlsLdVO.setSlsLdNo(salesLeads[i].getSLSLDNO());
                    priCrmSlsLdVO.setSlsLdNm(salesLeads[i].getSLSLDNM());
                    priCrmSlsLdVO.setSlsLdCustCntCd((salesLeads[i].getSLSLDCUSTCD() != null && salesLeads[i].getSLSLDCUSTCD().length() > 2) ? salesLeads[i].getSLSLDCUSTCD().substring(0, 2) : "");
                    priCrmSlsLdVO.setSlsLdCustSeq((salesLeads[i].getSLSLDCUSTCD() != null && salesLeads[i].getSLSLDCUSTCD().length() == 8) ? salesLeads[i].getSLSLDCUSTCD().substring(2) : "");
                    priCrmSlsLdVO.setSlsLdStDt((salesLeads[i].getSLSLDSTDT() != null && salesLeads[i].getSLSLDSTDT().length() > 7) ? salesLeads[i].getSLSLDSTDT().substring(0,8):"");
                    priCrmSlsLdVO.setSlsLdSrepCd(salesLeads[i].getSLSLDSREPCD());
                    priCrmSlsLdVO.setSlsLdStsCd("I");
                    list.add(priCrmSlsLdVO);
                }
                list.toArray(priCrmSlsLdVOs);
                ((Cms0110001Event) event).setPriCrmSlsLdVOs(priCrmSlsLdVOs);
                priMasterDataSC.perform(event);
            }

            eai.commit(doc.getCMS0110001().getEAIHeader().getInstanceId());
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
        log.debug("<<<<<<<<<< JMS receiveCRMSalesLead End >>>>>>>>>>>>>>>>");
    }

    /**
     * CRM : CMS012_0001<br>
     * CRM으로부터 받은 Keyman 정보를 저장합니다.
     * 현재사용안함.<br>
     * 
     * @param TransferEAI eai
     */
    public void receiveCRMKeyman(TransferEAI eai) {

        log.debug("<<<<<<<<<< JMS receiveCRMKeyman Start >>>>>>>>>>>>>>>>");

        String str = eai.getMessage();
        log.debug("======================================");
        log.debug("xml : " + str);
        log.debug("======================================");

        Event event = null;
        PRIMasterDataSC priMasterDataSC = new PRIMasterDataSC();

        try {
            event = new Cms0120001Event();

            FormCommand f = new FormCommand();
            f.setCommand(FormCommand.MULTI);
            event.setFormCommand(f);

            CMS0120001Document doc = CMS0120001Document.Factory.parse(str);
            CMS0120001 cms0120001 = doc.getCMS0120001();
            com.hanjin.irep.cms.CMS0120001Document.CMS0120001.DataArea dataArea = cms0120001.getDataArea();
            
            KeyManCollection keyManCollection = dataArea.getKeyManCollection();
            int cnt = keyManCollection.sizeOfKeyManArray();

            if (cnt > 0) {
                KeyMan[] keymans = keyManCollection.getKeyManArray();
                ArrayList<PriCrmCustKmanVO> list = new ArrayList<PriCrmCustKmanVO>();
                PriCrmCustKmanVO priCrmCustKmanVO = new PriCrmCustKmanVO();
                PriCrmCustKmanVO[] priCrmCustKmanVOs = new PriCrmCustKmanVO[cnt];
                String register = "SYSTEM";

                for (int i = 0; i < cnt; i++) {
                    priCrmCustKmanVO = new PriCrmCustKmanVO();
                    priCrmCustKmanVO.setCustCntCd((keymans[i].getCUSTCNTCD() != null && keymans[i].getCUSTCNTCD().length() > 2) ? keymans[i].getCUSTCNTCD().substring(0,2) : "");
                    priCrmCustKmanVO.setCustSeq((keymans[i].getCUSTCNTCD() != null && keymans[i].getCUSTCNTCD().length() == 8) ? keymans[i].getCUSTCNTCD().substring(2) : "");
                    priCrmCustKmanVO.setN1stNm(keymans[i].getN1STNM());
                    priCrmCustKmanVO.setLstNm(keymans[i].getLSTNM());
                    priCrmCustKmanVO.setJbTitNm(keymans[i].getJBTITNM());
                    priCrmCustKmanVO.setIntlPhnNo(keymans[i].getCNTPHNNO());
                    priCrmCustKmanVO.setPhnNo(keymans[i].getPHNNO());
                    priCrmCustKmanVO.setFaxNo(keymans[i].getFAXNO());
                    priCrmCustKmanVO.setKmanEml(keymans[i].getKMANEML());
                    priCrmCustKmanVO.setPrmryKmanFlg(keymans[i].getPRMRYKMANFLG());
                    priCrmCustKmanVO.setCreUsrId(register);
                    priCrmCustKmanVO.setUpdUsrId(register);
                    list.add(priCrmCustKmanVO);
                }
                list.toArray(priCrmCustKmanVOs);
                ((Cms0120001Event) event).setPriCrmCustKmanVOs(priCrmCustKmanVOs);
                priMasterDataSC.perform(event);
            }

            eai.commit(doc.getCMS0120001().getEAIHeader().getInstanceId());
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
        log.debug("<<<<<<<<<< JMS receiveCRMKeyman End >>>>>>>>>>>>>>>>");
    }

}
