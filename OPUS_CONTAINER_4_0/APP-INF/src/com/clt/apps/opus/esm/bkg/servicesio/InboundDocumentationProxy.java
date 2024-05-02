/* =========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : InboundDocumentationProxy.java
 *@FileTitle : Receive WebLogic JMS Queue Proxy
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010-05-20
 *@LastModifier : 2002640
 *@LastVersion : 1.0
 * 2009-08-13
 * 1.0 최초 생성
 * --------------------------------------------------------------------------------------
 * History
 * 2010.09.06 이지영 [CHM-201005721-01] [ESM-BKG] VVD별 OTS 미수금 수신
 * 2010.09.29 이지영 R4j결함 수정
=========================================================*/
package com.clt.apps.opus.esm.bkg.servicesio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.CargoReleaseOrderMgtSC;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.ESM0710001Event;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.irep.enisEsm.ESM0710001Document;
import com.clt.irep.enisEsm.ESM0710001Document.ESM0710001;
import com.clt.irep.enisEsm.ESM0710001Document.ESM0710001.DataArea.ROW;
import com.jf.transfer.TransferEAI;
/**
 * It's InboundDocumentationProxy.java
 * 
 * @author 
 * @see
 * @since J2EE 1.6 May 25, 2009
 */
public class InboundDocumentationProxy{
    protected transient Logger log = Logger.getLogger(this.getClass().getName());
/**
 * VVD별 Ots 정보 받기
 * @param eai
 */
    public void receiveOtsInfo(TransferEAI eai) {

        String str = eai.getMessage();
        Event event = null;
        CargoReleaseOrderMgtSC rsc = new CargoReleaseOrderMgtSC();
        try {

            event = new ESM0710001Event("ESM0710001Event");
            FormCommand f = new FormCommand();
            f.setCommand(FormCommand.SEARCH);
            event.setFormCommand(f);

            //Parsing
            ESM0710001Document esdDoc = ESM0710001Document.Factory.parse(str);
            //ESM0710001Document esdDoc = ESM0710001Document.Factory.parse(str);
            log.debug("Proxy---------------------------------------------6");


            ESM0710001 esm0710001 = esdDoc.getESM0710001();
            log.debug("Proxy---------------------------------------------6-1");
            ESM0710001.DataArea dataAreaRes = esm0710001.getDataArea();
            log.debug("Proxy---------------------------------------------6-2");

            ROW otsCollectionRes = dataAreaRes.getROW();

            log.debug("Proxy---------------------------------------------6-3" + otsCollectionRes);

             //ERP 시스템으로 부터 수신 받은 정보를 Value Object에 세팅한다.
            this.settingValue(otsCollectionRes);
            log.debug("Proxy---------------------------------------------6-4");

            event.setAttribute("otsCollectionRes", otsCollectionRes);
            log.debug("Proxy---------------------------------------------6-5");


            ((ESM0710001Event) event).setXmlObject(esdDoc);
            log.debug("Proxy---------------------------------------------7");
            log.debug("esdDoc "+ esdDoc);
            log.debug("Proxy---------------------------------------------8");

            log.debug("Proxy---------------------------------------------9");
            rsc.perform(event);            
            log.debug("Proxy---------------------------------------------10");
            eai.commit(esdDoc.getESM0710001().getEAIHeader().getInstanceId());
            log.debug("Proxy---------------------------------------------11");
        } catch (EventException e) {
            eai.rollback(e);
            log.error("\n EventException: "+e.getMessage());
        } catch (XmlException e) {
            eai.rollback(e);
            log.error("\n XmlException: "+e.getMessage());
        } catch (com.jf.transfer.eai.exception.EAIException e) {
            eai.rollback(e);
            log.error("\n EAIException: "+e.getMessage());
        }
        eai.close();
    }
    /**
     * 가져온 값들을 설정한다.
     * @param otsCollectionRes
     */
    private void settingValue(ROW otsCollectionRes) {
        otsCollectionRes.setOFC(nullToEmpty(otsCollectionRes.getOFC()));
        log.debug("Proxy --------------------- otsCollectionRes.getOFC()   " + otsCollectionRes.getOFC());

        otsCollectionRes.setOFC(nullToEmpty(otsCollectionRes.getOFC()));
        otsCollectionRes.setBLNO(nullToEmpty(otsCollectionRes.getBLNO()));
        otsCollectionRes.setINVNO(nullToEmpty(otsCollectionRes.getINVNO()));
        otsCollectionRes.setOFCCURRENCY(nullToEmpty(otsCollectionRes.getOFCCURRENCY()));

        otsCollectionRes.setBKGNO(nullToEmpty(otsCollectionRes.getBKGNO()));
        otsCollectionRes.setDUEDT(nullToEmpty(otsCollectionRes.getDUEDT()));
        otsCollectionRes.setSTLMK(nullToEmpty(otsCollectionRes.getSTLMK()));
        otsCollectionRes.setEXCHANGERATETYPE(nullToEmpty(otsCollectionRes.getEXCHANGERATETYPE()));
        otsCollectionRes.setCOLLECTIONREMARK(nullToEmpty(otsCollectionRes.getCOLLECTIONREMARK()));
        otsCollectionRes.setOTSGRPTY(nullToEmpty(otsCollectionRes.getOTSGRPTY()));
        otsCollectionRes.setOTSTY(nullToEmpty(otsCollectionRes.getOTSTY()));
        otsCollectionRes.setCRDTMK(nullToEmpty(otsCollectionRes.getCRDTMK()));
        otsCollectionRes.setCUSTBILLTOCD(nullToEmpty(otsCollectionRes.getCUSTBILLTOCD()));
        otsCollectionRes.setCOLLECTIONOFFICE(nullToEmpty(otsCollectionRes.getCOLLECTIONOFFICE()));
        otsCollectionRes.setTRXDATE(nullToEmpty(otsCollectionRes.getTRXDATE()));
        otsCollectionRes.setDTLOFC(nullToEmpty(otsCollectionRes.getDTLOFC()));
        otsCollectionRes.setDTLBLNO(nullToEmpty(otsCollectionRes.getDTLBLNO()));
        otsCollectionRes.setDTLINVNO(nullToEmpty(otsCollectionRes.getDTLINVNO()));
        otsCollectionRes.setBLCURRENCY(nullToEmpty(otsCollectionRes.getBLCURRENCY()));
        otsCollectionRes.setINVFRTAMT(nullToEmpty(otsCollectionRes.getINVFRTAMT()));
        otsCollectionRes.setINVWFTAMT(nullToEmpty(otsCollectionRes.getINVWFTAMT()));
        otsCollectionRes.setINVCTTAMT(nullToEmpty(otsCollectionRes.getINVCTTAMT()));
        otsCollectionRes.setINVTAXAMT(nullToEmpty(otsCollectionRes.getINVTAXAMT()));
        otsCollectionRes.setINVRSVAMT(nullToEmpty(otsCollectionRes.getINVRSVAMT()));
        otsCollectionRes.setINVUPDTDT(nullToEmpty(otsCollectionRes.getINVUPDTDT()));
        otsCollectionRes.setCOLFRTAMT(nullToEmpty(otsCollectionRes.getCOLFRTAMT()));
        otsCollectionRes.setCOLWFTAMT(nullToEmpty(otsCollectionRes.getCOLWFTAMT()));
        otsCollectionRes.setCOLCTTAMT(nullToEmpty(otsCollectionRes.getCOLCTTAMT()));
        otsCollectionRes.setCOLTAXAMT(nullToEmpty(otsCollectionRes.getCOLTAXAMT()));
        otsCollectionRes.setCOLRSVAMT(nullToEmpty(otsCollectionRes.getCOLRSVAMT()));
        otsCollectionRes.setCOLUPDTDT(nullToEmpty(otsCollectionRes.getCOLUPDTDT()));
        otsCollectionRes.setADJFRTAMT(nullToEmpty(otsCollectionRes.getADJFRTAMT()));
        otsCollectionRes.setADJWFTAMT(nullToEmpty(otsCollectionRes.getADJWFTAMT()));
        otsCollectionRes.setADJCTTAMT(nullToEmpty(otsCollectionRes.getADJCTTAMT()));
        otsCollectionRes.setADJTAXAMT(nullToEmpty(otsCollectionRes.getADJTAXAMT()));
        otsCollectionRes.setADJRSVAMT(nullToEmpty(otsCollectionRes.getADJRSVAMT()));
        otsCollectionRes.setADJUPDTDT(nullToEmpty(otsCollectionRes.getADJUPDTDT()));
        otsCollectionRes.setBALFRTAMT(nullToEmpty(otsCollectionRes.getBALFRTAMT()));
        otsCollectionRes.setBALWFTAMT(nullToEmpty(otsCollectionRes.getBALWFTAMT()));
        otsCollectionRes.setBALCTTAMT(nullToEmpty(otsCollectionRes.getBALCTTAMT()));
        otsCollectionRes.setBALTAXAMT(nullToEmpty(otsCollectionRes.getBALTAXAMT()));
        otsCollectionRes.setBALRSVAMT(nullToEmpty(otsCollectionRes.getBALRSVAMT()));
        otsCollectionRes.setBALUPDTDT(nullToEmpty(otsCollectionRes.getBALUPDTDT()));
        otsCollectionRes.setWRITEOFFAMT(nullToEmpty(otsCollectionRes.getWRITEOFFAMT()));
        otsCollectionRes.setWRITEOFFUPDTDT(nullToEmpty(otsCollectionRes.getWRITEOFFUPDTDT()));
        otsCollectionRes.setPREAMT(nullToEmpty(otsCollectionRes.getPREAMT()));
        otsCollectionRes.setPREUPDTDT(nullToEmpty(otsCollectionRes.getPREUPDTDT()));
        otsCollectionRes.setEXRATELCL(nullToEmpty(otsCollectionRes.getEXRATELCL()));
        otsCollectionRes.setEXRATEUSD(nullToEmpty(otsCollectionRes.getEXRATEUSD()));
        otsCollectionRes.setEXRATELCLL(nullToEmpty(otsCollectionRes.getEXRATELCLL()));
        otsCollectionRes.setEXRATEUSDL(nullToEmpty(otsCollectionRes.getEXRATEUSDL()));
        otsCollectionRes.setBALFRTAMTLCL(nullToEmpty(otsCollectionRes.getBALFRTAMTLCL()));
        otsCollectionRes.setBALWFTAMTLCL(nullToEmpty(otsCollectionRes.getBALWFTAMTLCL()));
        otsCollectionRes.setBALCTTAMTLCL(nullToEmpty(otsCollectionRes.getBALCTTAMTLCL()));
        otsCollectionRes.setBALTAXAMTLCL(nullToEmpty(otsCollectionRes.getBALTAXAMTLCL()));
        otsCollectionRes.setBALRSVAMTLCL(nullToEmpty(otsCollectionRes.getBALRSVAMTLCL()));
        otsCollectionRes.setBALFRTAMTUSD(nullToEmpty(otsCollectionRes.getBALFRTAMTUSD()));
        otsCollectionRes.setBALWFTAMTUSD(nullToEmpty(otsCollectionRes.getBALWFTAMTUSD()));
        otsCollectionRes.setBALCTTAMTUSD(nullToEmpty(otsCollectionRes.getBALCTTAMTUSD()));
        otsCollectionRes.setBALTAXAMTUSD(nullToEmpty(otsCollectionRes.getBALTAXAMTUSD()));
        otsCollectionRes.setBALRSVAMTUSD(nullToEmpty(otsCollectionRes.getBALRSVAMTUSD()));
        otsCollectionRes.setTRANSEQ(nullToEmpty(otsCollectionRes.getTRANSEQ()));
        
    }
/**
 * VVD별 받기 테스트
 * 
 */
    public void receiveOtsInfoTest() {

    	StringBuffer buff = null;
        Event event = null;
        CargoReleaseOrderMgtSC rsc = new CargoReleaseOrderMgtSC();
        try {
            log.debug("Proxy---------------------------------------------1");
            event = new ESM0710001Event("ESM0710001Event");
            log.debug("Proxy---------------------------------------------2");
            FormCommand f = new FormCommand();
            log.debug("Proxy---------------------------------------------3");
            f.setCommand(FormCommand.SEARCH);
            log.debug("Proxy---------------------------------------------4");
            event.setFormCommand(f);
            log.debug("Proxy---------------------------------------------5");


            BufferedReader br = null;
//            try {
                br = new BufferedReader(new FileReader("c:/rdata_20100330.xml"));
                String tmp = "";
                buff =  new StringBuffer();
                while((tmp = br.readLine()) != null){                   
                  //  str += tmp;
                     buff.append(tmp);
                }

                br.close();
//		    } catch (FileNotFoundException e) {
//		        log.error("err " + e.toString(), e);
//		        // TODO Auto-generated catch block
//		    } catch (IOException e) {
//		    	log.error("err " + e.toString(), e);
//		        // TODO Auto-generated catch block
//		    }

            ESM0710001Document esdDoc = ESM0710001Document.Factory.parse(buff.toString());

            ESM0710001 esm0710001 = esdDoc.getESM0710001();

            ESM0710001.DataArea dataAreaRes = esm0710001.getDataArea();

            //ESM0710001.DataArea.OTSVVDCollection otsCollectionRes = dataAreaRes.getOTSVVDCollection();
            ROW otsCollectionRes = dataAreaRes.getROW();

            this.settingValue(otsCollectionRes);

            event.setAttribute("otsCollectionRes", otsCollectionRes);

            //ESM0710001Document esdDoc = ESM0710001Document.Factory.parse(buff.toString());
            log.debug("Proxy---------------------------------------------6");

            ((ESM0710001Event) event).setXmlObject(esdDoc);
            log.debug("Proxy---------------------------------------------7");
            //log.debug("esdDoc "+ esdDoc);
            //log.debug("esdDoc "+ esdDoc.xmlText());
            log.debug("Proxy---------------------------------------------8");

            log.debug("Proxy---------------------------------------------9");
            rsc.perform(event);
            log.debug("Proxy---------------------------------------------10");

            log.debug("Proxy---------------------------------------------11");
        } catch (EventException e) {
            log.error("\n EventException: "+e.getMessage());
        } catch (XmlException e) {
            log.error("\n XmlException: "+e.getMessage());
	    } catch (FileNotFoundException e) {
	        log.error("err " + e.toString(), e);
	        // TODO Auto-generated catch block
	    } catch (IOException e) {
	    	log.error("err " + e.toString(), e);
	        // TODO Auto-generated catch block
	    }
        
    }

   
   

    /**
     * 스트링 변환 유틸리티 메소드
     * 스트링이 null이면 빈 스트링을 리턴한다.
     *
     * @param string 체크할 스트링
     * @return 스트링이 null인 경우 빈 스트링; 스트링이 null이 아닌 경우 스트링 자신
     */
    public static String nullToEmpty(String string) {
        String strRtn = null;
        if (string == null) {
            strRtn = "";
        }else{
            strRtn = string;
        }
        return strRtn;
    }
/**
 * Main Test 
 * @param args
 * @throws DAOException
 */
    public static void main(String[] args) throws DAOException{

        InboundDocumentationProxy proxy = new InboundDocumentationProxy();
        proxy.receiveOtsInfoTest();
    }      

}