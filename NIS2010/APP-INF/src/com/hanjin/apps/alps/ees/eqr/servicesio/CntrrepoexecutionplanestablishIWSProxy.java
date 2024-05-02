/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrrepoexecutionplanestablishIWSProxy.java
*@FileTitle : ETS 연동 OffHire Return WebService
*Open Issues :
*Change history :
*@LastModifyDate : 2009-11-30
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009-11-19 정은호
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.servicesio;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.apache.log4j.Logger;

import weblogic.jws.WLHttpTransport;

import com.hanjin.apps.alps.ees.eqr.repoplanmanage.RepoPlanManageSC;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event.EtsEqr0001Event;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EtsEqr0001OffHireReturnVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.ModifyFromTrsOffHireReturnVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;



/**
 * Cntrrepoexecutionplanestablish 에 대한 WebService Proxy<br>
 * 
 * @author ChungEunHo
 * @see RepoPlanManageSC , CntrRepoExecutionPlanEstablishBCImpl  참조 
 * @since J2EE 1.6
 */
@WebService(name="CntrrepoexecutionplanestablishIWSProxyPortType", serviceName="CntrrepoexecutionplanestablishIWSProxy",
        targetNamespace="http://www.hanjin.com/integration/alps")

@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,
         use=SOAPBinding.Use.LITERAL,
         parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)

@WLHttpTransport(contextPath="/hanjin/webservices", serviceUri="/CntrrepoexecutionplanestablishIWSProxy",
             portName="CntrrepoexecutionplanestablishIWSProxyPort")
public class CntrrepoexecutionplanestablishIWSProxy {
	/**
	 * Log
	 */
    protected transient Logger log = Logger.getLogger(this.getClass().getName());
    
    /**
     * 서비스명 제공
     * 
     * @return response String
     */
    @WebMethod()
    public String getServiceName() {
    	return "Cntrrepoexecutionplanestablish Web-Service";
    }



   /**
     * ETS - EQR OffHire 직반납<br>
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
			 * EVENT 생성 / 전송 
			 */
    		event = new EtsEqr0001Event(doc);
    		
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI);
			event.setFormCommand(f);
			/**
			 * EventResponse로 부터 전송 객체의 생성 
			 */
			GeneralEventResponse  eventResponse = (GeneralEventResponse) rsc.perform(event);
			docOut = (ModifyFromTrsOffHireReturnVO)eventResponse.getRsVoList().get(0);
			
			retVal = docOut.getReturnCode()+"|"+docOut.getNewRefId();
			
			List<String> refSeqList = docOut.getRefSeqList();
			
			if(refSeqList.size() > 0){
				for(int i = 0 ; i < refSeqList.size() ; i++){
					String refSeq = refSeqList.get(i);
					retVal = retVal + "|"+ refSeq;
				}
			}
			
		}  catch (Exception de){
			log.error(de.getMessage(), de);
		}
		
    	return retVal;
    }
    
}
