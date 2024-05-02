/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ActualScheduleManagementJMSProxy.java
*@FileTitle : ENIS Interface 연동 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : 서창열
*@LastVersion : 1.1
* 2007-04-10 
* 1.0 최초 생성
* 2009.08.26 서창열
* 1.1 Creation (NIS2010 new F/W 전환작업)
 =========================================================*/
package com.hanjin.apps.alps.vop.vsk.servicesio;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.apache.log4j.Logger;

import weblogic.jws.WLHttpTransport;

import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ActualScheduleManagementSC;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.event.VopVskSPPVSK0003Event;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdMgtVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.SchedulePlanningOperationSC;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVskSPPVSK0004Event;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVskSPPVSK0005Event;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdByVvdVO;
import com.hanjin.apps.alps.vop.vsk.vskcommonutil.vskgeneralutil.VSKGeneralUtil;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 *  WebService를 통해서 SPP와 연동한다
 *
 *
 * @author 서창열
 * @see ActualScheduleMgtBCImpl
 * @since J2EE 1.4
 */
@WebService(name="SchedulePlanningOperationWSProxyPortType", serviceName="SchedulePlanningOperationWSProxy",
        targetNamespace="http://www.smlines.com/integration/alps")

@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,
         use=SOAPBinding.Use.LITERAL,
         parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)

@WLHttpTransport(contextPath="/hanjin/webservices", serviceUri="/SchedulePlanningOperationWSProxy",
             portName="SchedulePlanningOperationWSProxyPort")
public class SchedulePlanningOperationWSProxy {
	protected transient Logger log = Logger.getLogger(this.getClass().getName());
	
	/**
     * SPP에서 입력한 Feeder VVD를 이용해 Feeder Schedule 조회.
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
             * EVENT 생성 / 전송 
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
            /**
             * EventResponse로 부터 전송 객체의 생성 
             */

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
     * Feeder Schedule 등록 및 변경  (SPP)
     * 
     * @param CstSkdByVvdVO[] cstSkdByVvdVOs
     * @return String
     */
	@WebMethod()
    public String manageCstSkdByVvd(CstSkdByVvdVO[]  cstSkdByVvdVOs) {
    	
		//Interface ID  SPP_VSK-0005
		Event 						event 		= null;
		SchedulePlanningOperationSC sc 			= new SchedulePlanningOperationSC();
		String 						result 		= "";
		String						sDateFormat	= "yyyyMMddHHmm";
    	
    	log.debug("SchedulePlanningOperationWSProxy manageCstSkdByVvd");
    	try {
    		
    		
    		/*******************************************************
    		 * 입력된 Data Type Data에 대한 유효성체크 ::2013-04-23
    		 * -----------------------------------------------------
    		 * VSKGeneralUtil.isEffectiveDate
    		 */
    		
    		log.debug("\n\n ::=======::jskjskjsk::SchedulePlanningOperationWSProxy::input date effectiveness check started !\n");
    		
    		for(int i=0; i<cstSkdByVvdVOs.length; i++){
    			String	sEta	= cstSkdByVvdVOs[i].getVpsEtaDt() == null ? "" : cstSkdByVvdVOs[i].getVpsEtaDt();
    			String	sEtb	= cstSkdByVvdVOs[i].getVpsEtbDt() == null ? "" : cstSkdByVvdVOs[i].getVpsEtbDt();
				String	sEtd	= cstSkdByVvdVOs[i].getVpsEtdDt() == null ? "" : cstSkdByVvdVOs[i].getVpsEtdDt();
				
				log.debug("\n\n :: sEta ["+sEta+"] sEtb ["+sEtb+"] sEtd ["+sEtd+"] :: \n");
				
    			if(!"".equals(sEta)){
    				log.debug("\n\n :: sEta >>> ["+sEta+"] \n");
    				if(!this.isEffectiveDate(sEta, sDateFormat))	return	"Invalid ETA";
    			}
    				
    			if(!"".equals(sEtb)){
    				log.debug("\n\n :: sEtb >>> ["+sEtb+"] \n");
    				if(!this.isEffectiveDate(sEtb, sDateFormat))	return	"Invalid ETB";
    			}  
    				
    			if(!"".equals(sEtd)){
    				log.debug("\n\n :: sEtd >>> ["+sEtd+"] \n");
    				if(!this.isEffectiveDate(sEtd, sDateFormat))	return	"Invalid ETD";
    			}
    			
    		}
    		
    		log.debug("\n\n ::=======::jskjskjsk::SchedulePlanningOperationWSProxy::input date effectiveness check finished !\n");
    		/////////////////////////////////////////////////////////
    		
            /**
             * EVENT 생성 / 전송 
             */
    		for(int i=0; i<cstSkdByVvdVOs.length; i++){
    			cstSkdByVvdVOs[i].setUpdUsrId("ESVCUSER");
    		}
    		event = new VopVskSPPVSK0005Event();
            
            FormCommand f = new FormCommand();
            f.setCommand(FormCommand.MULTI);
            event.setFormCommand(f);
            
            ((VopVskSPPVSK0005Event) event).setCstSkdByVvdVOs(cstSkdByVvdVOs);
            /**
             * EventResponse로 부터 전송 객체의 생성 
             */

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
	
	/**
	 * 입력된 날짜에 대하여 유효성을 체크한다.
	 * 
	 * @param String sInputDate
	 * @param String sDateFormat
	 * @return boolean
	 */	
	public boolean isEffectiveDate(String sInputDate, String sDateFormat){
		
		boolean				isEffectiveNess	= false;
		//SimpleDateFormat	formatter		= new SimpleDateFormat("yyyyMMddHHmmss", java.util.Locale.KOREA);
		//Date				dtTmpFormatDate	= null;
		SimpleDateFormat	formatter		= new SimpleDateFormat(sDateFormat);
		
		try{
			
			formatter.setLenient(false);	//cf. ::true << 엄밀하지않은해석:://

			sInputDate = sInputDate.replace("-", "");
			sInputDate = sInputDate.replace(":", "");
			sInputDate = sInputDate.replace(" ", "");
			sInputDate = sInputDate.replace("/", "");
			
			formatter.parse(sInputDate);
			isEffectiveNess	= true;			//::Inputed Data Effective Date:://
			
			//if("20130413235900".equals(sInputDate) || "201304132359".equals(sInputDate))	return false;
			
		}catch(java.text.ParseException pe){
			log.error(pe.getMessage());
			return false;
		}catch(Exception ex){
			log.error(ex.getMessage());
		}
		return isEffectiveNess;
	}
	
}
