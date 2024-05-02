/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : ARInvoiceExRateMgtEAIDAO.java
*@FileTitle      :
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.08.04
*@LastModifier   : 최도순
*@LastVersion    : 1.0
* 2009.08.04 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.basic.ARInvoiceExRateMgtBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.ExchangeRateVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.irep.erp.EAIHeaderType;
import com.hanjin.irep.erp.FNS0190001Document;
import com.hanjin.irep.erp.FNS0190002Document;
import com.hanjin.irep.erp.FNS0190001Document.FNS0190001;
import com.hanjin.irep.erp.FNS0190002Document.FNS0190002;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;
import com.jf.transfer.ws.AxAyDocClient;

/**
 * NIS2010 ARInvoiceExRateMgtEAIDAO <br>
 * - NIS2010-AccountReceivableInvoiceMasterDataMgtJMSProxy system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Choi Do Soon
 * @see ARInvoiceExRateMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class ARInvoiceExRateMgtEAIDAO extends EAIDAOSupport {

    private transient Logger log = Logger.getLogger(ARInvoiceExRateMgtEAIDAO.class.getName());

    /**
     * ERP : FNS019-0001<br>
     * Customer 및 Daily Exchange Rate를 Interface ERP AR로 전송합니다..<br>
     *
     * @param List<ExchangeRateVO> exchangeRateVOs
     * @param String usrId
     * @exception EAIException
     */
	public void interfaceExRateToERPAR0190001(List<ExchangeRateVO> exchangeRateVOs,String usrId)throws EAIException, SQLException {

        TransferEAI transferEAI = null;
        String transferMsg = "";
        try{

            log.debug("=======================================");
            log.debug("    \n Parameter Marshalling Start!    ");
            log.debug("=======================================");

            //Request Start
            String target = SubSystemConfigFactory.get("FNS.INV0190001.WSDL");

            FNS0190001Document document = FNS0190001Document.Factory.newInstance();

            FNS0190001 fns0190001 = FNS0190001.Factory.newInstance();
            String dateTime = "FNS019-0001" + (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
            String strSeq = (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date())+ usrId;
            //Set Header
            EAIHeaderType headerType = fns0190001.addNewEAIHeader();
            headerType.setInstanceId(dateTime);

            FNS0190001.DataArea dataArea = fns0190001.addNewDataArea();
            FNS0190001.DataArea.ExchRateCollection exchRateCollection = dataArea.addNewExchRateCollection();
           
            for(int i=0; i<exchangeRateVOs.size(); i++){	 	
            	
            	//20100528 0이 아닌것만 보낸다.
            	if(!exchangeRateVOs.get(i).getInvXchRt().equals("0")&&!exchangeRateVOs.get(i).getInvXchRt().equals("")){
	            	FNS0190001.DataArea.ExchRateCollection.ExchRate exchRate = exchRateCollection.addNewExchRate();
	            	
	            	exchRate.setLIFID("FNS019-0001");	    			
	    			exchRate.setSEQ(strSeq+i);
	            	exchRate.setTOTALCOUNT(Integer.toString(exchangeRateVOs.size()));
	            	exchRate.setROWNUM(Integer.toString(i));
	            	exchRate.setOPCD(exchangeRateVOs.get(i).getIbflag().equals("I")?"C":exchangeRateVOs.get(i).getIbflag());
	            	exchRate.setCNTRYCD(exchangeRateVOs.get(i).getCustCntCd());
	            	exchRate.setCUSTCD(exchangeRateVOs.get(i).getCustSeq());
	            	exchRate.setBND(exchangeRateVOs.get(i).getIoBndCd());
	            	exchRate.setFROMDT(exchangeRateVOs.get(i).getFmDt().replace("-", ""));
	            	exchRate.setTODT(exchangeRateVOs.get(i).getToDt().replace("-", ""));
	            	exchRate.setCHGCURR(exchangeRateVOs.get(i).getChgCurrCd());
	            	exchRate.setLCLCURR(exchangeRateVOs.get(i).getLoclCurrCd());
	            	exchRate.setEXRATE(exchangeRateVOs.get(i).getInvXchRt());
	            	exchRate.setDELMK(exchangeRateVOs.get(i).getIbflag().equals("D")?"Y":"N");
	            	exchRate.setLOGRGSTDT((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
	            	exchRate.setLOGUPDTDT((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
	            	exchRate.setLOGUSERID(usrId);
	            	exchRate.setNISEVENTDT((new SimpleDateFormat("yyyyMMdd")).format(new Date()));
	            	exchRate.setOFCCD(exchangeRateVOs.get(i).getArOfcCd());
	            	exchRate.setRTTYPE(exchangeRateVOs.get(i).getXchRtTpCd());
	    			
	            	exchRateCollection.setExchRateArray(i, exchRate);
            	}
    		}
            
            dataArea.setExchRateCollection(exchRateCollection);
            
            fns0190001.setDataArea(dataArea);
    		document.setFNS0190001(fns0190001);           

            transferEAI = new AxAyDocClient(target, this.getClass());

            //메세지 전송
            transferEAI.setMessage(document.toString());
            
            log.debug("==============================================================================");
            log.debug("    interfaceExRateToERPAR0190001 Doc : \n" + document.toString());
            log.debug("==============================================================================");

            transferMsg = transferEAI.commit(headerType.getInstanceId());

            log.debug("==============================================================================");
            log.debug("    interfaceExRateToERPAR0190001 Result : \n" + transferMsg);
            log.debug("==============================================================================");
            
        } catch (EAIException se) {

            log.debug("=================================");
            log.debug("    ORACLE EAI 연동 에러 코드    ");
            log.debug("=================================");

            log.debug("getTpErrCode   : "+se.getTpErrCode());
            log.debug("getTpErrDetail : "+se.getTpErrDetail());
            log.debug("getTpErrNo     : "+se.getTpErrNo());

            transferEAI.rollback(se);
            log.error(se.getMessage(),se);
            throw new EAIException(new ErrorHandler(se).getMessage());
        } catch (Exception ex) {
        	transferEAI.rollback(ex);
        	log.error(ex.getMessage(),ex);
            throw new EAIException(new ErrorHandler(ex).getMessage());
        }
        transferEAI.close();
    }
	
	/**
     *  ERP : FNS019-0001<br>
     *  VVD Exchange Rate를 Interface ERP AR로 전송합니다.<br>
     *
     * @param List<ExchangeRateVO> exchangeRateVOs
     * @param String usrId
     * @exception EAIException
     */
	public void interfaceExRateToERPAR0190002(List<ExchangeRateVO> exchangeRateVOs,String usrId)throws EAIException, SQLException {

        TransferEAI transferEAI = null;
        String transferMsg = "";
        try{

            log.debug("=======================================");
            log.debug("    \n Parameter Marshalling Start!    ");
            log.debug("=======================================");

            //Request Start
            String target = SubSystemConfigFactory.get("FNS.INV0190002.WSDL");

            FNS0190002Document document = FNS0190002Document.Factory.newInstance();

            FNS0190002 fns0190002 = FNS0190002.Factory.newInstance();
            String dateTime = "FNS019-0002" + (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
            String strSeq = (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date())+ usrId;
            //Set Header
            EAIHeaderType headerType = fns0190002.addNewEAIHeader();
            headerType.setInstanceId(dateTime);

            FNS0190002.DataArea dataArea = fns0190002.addNewDataArea();
            FNS0190002.DataArea.ExchRateCollection exchRateCollection = dataArea.addNewExchRateCollection();
            
            for(int i=0; i<exchangeRateVOs.size(); i++){	 	
            	
            	//20100528 0이 아닌것만 보낸다.
            	if(!exchangeRateVOs.get(i).getInvXchRt().equals("0")&&!exchangeRateVOs.get(i).getInvXchRt().equals("")){
	            	FNS0190002.DataArea.ExchRateCollection.ExchRate exchRate = exchRateCollection.addNewExchRate();
	            	
	            	exchRate.setLIFID("FNS019-0002");	    			
	    			exchRate.setSEQ(strSeq+i);
	            	exchRate.setTOTALCOUNT(Integer.toString(exchangeRateVOs.size()));
	            	exchRate.setROWNUM(Integer.toString(i));
	            	exchRate.setOPCD(exchangeRateVOs.get(i).getIbflag().equals("I")?"C":exchangeRateVOs.get(i).getIbflag());
	            	exchRate.setVSLCD(exchangeRateVOs.get(i).getVslCd());
	            	exchRate.setSKDVOYAGENO(exchangeRateVOs.get(i).getSkdVoyNo());
	            	exchRate.setSKDDIRCD(exchangeRateVOs.get(i).getSkdDirCd());
	            	exchRate.setVERPORT(exchangeRateVOs.get(i).getPortCd());
	            	exchRate.setVERCURCD(exchangeRateVOs.get(i).getLoclCurrCd());
	            	exchRate.setVERSVCSCP(exchangeRateVOs.get(i).getSvcScpCd());
	            	exchRate.setVERIOFLG(exchangeRateVOs.get(i).getIoBndCd());
	            	exchRate.setVERTCURCD(exchangeRateVOs.get(i).getChgCurrCd());
	            	exchRate.setVEROFCCD(exchangeRateVOs.get(i).getArOfcCd());
	            	exchRate.setVERUSDLCL(exchangeRateVOs.get(i).getInvXchRt());
	            	exchRate.setVERUSDXEU("0");
	            	exchRate.setVERXEULCL("0");
	            	exchRate.setVERAPPLDT((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
	            	exchRate.setUSRID(usrId);
	            	exchRate.setVERCRDT((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
	            	exchRate.setVERDELMK(exchangeRateVOs.get(i).getIbflag().equals("D")?"Y":"N");
	            	exchRate.setNISEVENTDT((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
	    			
	            	exchRateCollection.setExchRateArray(i, exchRate);            	
            	}
    		}
            
            dataArea.setExchRateCollection(exchRateCollection);
            
            fns0190002.setDataArea(dataArea);
    		document.setFNS0190002(fns0190002);           

            transferEAI = new AxAyDocClient(target, this.getClass());

            //메세지 전송
            transferEAI.setMessage(document.toString());
            
            log.debug("==============================================================================");
            log.debug("    interfaceExRateToERPAR0190002 Doc : \n" + document.toString());
            log.debug("==============================================================================");

            transferMsg = transferEAI.commit(headerType.getInstanceId());
            
            log.debug("==============================================================================");
            log.debug("    interfaceExRateToERPAR0190002 Result : \n" + transferMsg);
            log.debug("==============================================================================");
            
        } catch (EAIException se) {

            log.debug("=================================");
            log.debug("    ORACLE EAI 연동 에러 코드    ");
            log.debug("=================================");

            log.debug("getTpErrCode   : "+se.getTpErrCode());
            log.debug("getTpErrDetail : "+se.getTpErrDetail());
            log.debug("getTpErrNo     : "+se.getTpErrNo());

            transferEAI.rollback(se);
            log.error(se.getMessage(),se);
            throw new EAIException(new ErrorHandler(se).getMessage());
        } catch (Exception ex) {
        	transferEAI.rollback(ex);
            log.error(ex.getMessage(),ex);
            throw new EAIException(new ErrorHandler(ex).getMessage());
        }
        transferEAI.close();
    }

}