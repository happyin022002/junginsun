/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrrepoexecutionplanestablishIWSProxy.java
*@FileTitle : ETS OffHire Return WebService
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.servicesio;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.apache.log4j.Logger;

import weblogic.jws.WLHttpTransport;

import com.clt.apps.opus.ees.eqr.repoplanmanage.RepoPlanManageSC;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event.EtsEqr0001Event;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EtsEqr0001OffHireReturnVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.ModifyFromTrsOffHireReturnVO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;



/**
 * Cntrrepoexecutionplanestablish about WebService Proxy<br>
 * 
 * @author 
 * @see RepoPlanManageSC , CntrRepoExecutionPlanEstablishBCImpl 
 * @since J2EE 1.6
 */
@WebService(name="CntrrepoexecutionplanestablishIWSProxyPortType", serviceName="CntrrepoexecutionplanestablishIWSProxy",
        targetNamespace="http://www.clt.com/integration/opus")

@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,
         use=SOAPBinding.Use.LITERAL,
         parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)

@WLHttpTransport(contextPath="/opuscntr/webservices", serviceUri="/CntrrepoexecutionplanestablishIWSProxy",
             portName="CntrrepoexecutionplanestablishIWSProxyPort")
public class CntrrepoexecutionplanestablishIWSProxy {
	/**
	 * Log
	 */
    protected transient Logger log = Logger.getLogger(this.getClass().getName());
    
    /**
     * 
     * @return response String
     */
    @WebMethod()
    public String getServiceName() {
    	return "Cntrrepoexecutionplanestablish Web-Service";
    }



   /**
     * ETS - EQR OffHire <br>
     * 
     * @param docIn EtsEqr0001OffHireReturnVO
     * @return String
     * @exception EventException
     */
    @WebMethod()
	public String modifyOffHireReturn(EtsEqr0001OffHireReturnVO docIn) { 
		
		Event	 event	= null;
		RepoPlanManageSC	rsc		= new RepoPlanManageSC();
		ModifyFromTrsOffHireReturnVO	docOut	= new ModifyFromTrsOffHireReturnVO();
		String retVal = "";
		StringBuilder sb = new StringBuilder();
    	try {
    		
    		ModifyFromTrsOffHireReturnVO doc = new  ModifyFromTrsOffHireReturnVO();
    		doc.setChdCntrQty(docIn.getChdCntrQty());
    		doc.setRepoPlnId(docIn.getRepoPlnId());
    		doc.setRefId(docIn.getRefId());
    		if(docIn.getCntrNo() != null){
    			doc.addCntrNoList(docIn.getCntrNo());
    		}
    		doc.setCntrTpszCd(docIn.getCntrTpszCd());
    		doc.setPlnYrwk(docIn.getPlnYrwk());
    		doc.setChdToYdCd(docIn.getChdToYdCd());
    		doc.addOldRefSeqList(docIn.getRefSeq());
    		
    		if(docIn.getTrspSoStsCd() != null){
    			doc.setTrspSoStsCd(docIn.getTrspSoStsCd());
    		}
    		
			/**
			 * creating/sending EVENT
			 */
    		event = new EtsEqr0001Event(doc);
    		
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI);
			event.setFormCommand(f);
			/**
			 * creating sending object from EventResponse
			 */
			GeneralEventResponse  eventResponse = (GeneralEventResponse) rsc.perform(event);
			docOut = (ModifyFromTrsOffHireReturnVO)eventResponse.getRsVoList().get(0);
			
			retVal = docOut.getReturnCode()+"|"+docOut.getNewRefId();
			
			List<String> refSeqList = docOut.getRefSeqList();
			
			if(refSeqList.size() > 0){
				for(int i = 0 ; i < refSeqList.size() ; i++){
					String refSeq = refSeqList.get(i);
					sb.append(retVal).append("|").append(refSeq);
					//retVal = retVal + "|"+ refSeq;
				}
			}
			
			retVal = sb.toString();
		}  catch (Exception de){
			log.error(de.getMessage(), de);
		}
		
    	return retVal;
    }
    
}
