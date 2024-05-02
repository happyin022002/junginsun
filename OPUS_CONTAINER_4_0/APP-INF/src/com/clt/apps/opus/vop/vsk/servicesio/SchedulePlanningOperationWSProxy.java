/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ActualScheduleManagementJMSProxy.java
*@FileTitle : ENIS Interface Link
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
 =========================================================*/
package com.clt.apps.opus.vop.vsk.servicesio;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.apache.log4j.Logger;

import weblogic.jws.WLHttpTransport;

import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.basic.ActualScheduleMgtBCImpl;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.SchedulePlanningOperationSC;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVskSPPVSK0004Event;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVskSPPVSK0005Event;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdByVvdVO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * Link to SPP through WebService
 *
 *
 * @author
 * @see ActualScheduleMgtBCImpl
 * @since J2EE 1.4
 */
@WebService(name="SchedulePlanningOperationWSProxyPortType", serviceName="SchedulePlanningOperationWSProxy", targetNamespace="http://www.clt.com/integration")

@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,
         use=SOAPBinding.Use.LITERAL,
         parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)

@WLHttpTransport(contextPath="/opuscntr/webservices", serviceUri="/SchedulePlanningOperationWSProxy",
             portName="SchedulePlanningOperationWSProxyPort")
public class SchedulePlanningOperationWSProxy {
	protected transient Logger log = Logger.getLogger(this.getClass().getName());
	
	/**
     * Retrieving Feeder Schedule using Feeder VVD from SPP
     * 
     * @param String vsl_cd
     * @param String skd_voy_no
     * @param String skd_dir_cd
     * @return CstSkdByVvdVO[]
     */
	@WebMethod()
	@SuppressWarnings("unchecked")
    public CstSkdByVvdVO[] searchCstSkdByVvd(String vsl_cd, String skd_voy_no, String skd_dir_cd) {
    	
		//Interface ID  SPP_VSK-0004
		Event event = null;
		SchedulePlanningOperationSC sc = new SchedulePlanningOperationSC();
		List<CstSkdByVvdVO> cstSkdByVvdVOs = null;
		CstSkdByVvdVO[] cstSkdByVvdVOS = null;
    	
    	log.debug("SchedulePlanningOperationWSProxy searchCstSkdByVvd");
    	try {
            /**
             * EVENT Create / Transmit 
             */
    		event = new VopVskSPPVSK0004Event();
    		CstSkdByVvdVO cstSkdByVvdVO = new CstSkdByVvdVO();
    		cstSkdByVvdVO.setVslCd(vsl_cd);
    		cstSkdByVvdVO.setSkdVoyNo(skd_voy_no);
    		cstSkdByVvdVO.setSkdDirCd(skd_dir_cd);
    		
            FormCommand f = new FormCommand();
            f.setCommand(FormCommand.SEARCH);
            event.setFormCommand(f);
            
            ((VopVskSPPVSK0004Event) event).setCstSkdByVvdVO((cstSkdByVvdVO));

            EventResponse eventResponse = (EventResponse)sc.perform(event);
            
            cstSkdByVvdVOs = (List)eventResponse.getRsVoList();
            
            if(cstSkdByVvdVOs != null && cstSkdByVvdVOs.size() > 0){
            	cstSkdByVvdVOS = new CstSkdByVvdVO[cstSkdByVvdVOs.size()];
            	for(int i=0; i<cstSkdByVvdVOs.size(); i++){
            		cstSkdByVvdVOS[i] = cstSkdByVvdVOs.get(i);
            	}
            }
           
    	}catch(EventException ee) {
            log.error("SchedulePlanningOperationWSProxy Error : " + ee.toString(), ee);
            
    	}catch(Exception e) {
            log.error("SchedulePlanningOperationWSProxy Error : " + e.toString(), e);
    	}
    	
    	return cstSkdByVvdVOS;
    }
	
	/**
     * Managing Feeder Schedule (SPP)
     * 
     * @param CstSkdByVvdVO[] cstSkdByVvdVOs
     * @return String
     */
	@WebMethod()
    public String manageCstSkdByVvd(CstSkdByVvdVO[]  cstSkdByVvdVOs) {
    	
		//Interface ID  SPP_VSK-0005
		Event event = null;
		SchedulePlanningOperationSC sc = new SchedulePlanningOperationSC();
		String result = "";
    	
    	log.debug("SchedulePlanningOperationWSProxy manageCstSkdByVvd");
    	try {
    		for(int i=0; i<cstSkdByVvdVOs.length; i++){
    			cstSkdByVvdVOs[i].setUpdUsrId("ESVCUSER");
    		}
    		event = new VopVskSPPVSK0005Event();
            
            FormCommand f = new FormCommand();
            f.setCommand(FormCommand.MULTI);
            event.setFormCommand(f);
            
            ((VopVskSPPVSK0005Event) event).setCstSkdByVvdVOs(cstSkdByVvdVOs);

            sc.perform(event);
            
            result	= "Success";
           
    	}catch(EventException ee) {
    		log.error("SchedulePlanningOperationWSProxy Error : " + ee.toString(), ee);
    		result = ee.toString();
    		
    	}catch(Exception e) {
    		log.error("SchedulePlanningOperationWSProxy Error : " + e.toString(), e);
    		result = e.toString();
    	}
    	return result;
    }	
}
