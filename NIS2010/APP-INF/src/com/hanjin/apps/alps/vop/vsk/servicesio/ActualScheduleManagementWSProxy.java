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
* 
* History
* 2011.12.06 CHM-201114962-01 진마리아 SPP를 통해 스케줄 업데이트 하는 로직 변경
 =========================================================*/
package com.hanjin.apps.alps.vop.vsk.servicesio;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.apache.log4j.Logger;

import weblogic.jws.WLHttpTransport;

import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ActualScheduleManagementSC;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.basic.ActualScheduleMgtBCImpl;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.event.VopVskSPPVSK0001Event;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.event.VopVskSPPVSK0002Event;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.event.VopVskSPPVSK0003Event;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdMgtVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.VvdListByPortVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 *  인터페이스 ID : EXP005-0001
 *
 * Actual Skd를 입력 대상 Port를 Calling하는 VVD 리스트 조회 (SPP)
 *
 * @author 서창열
 * @see ActualScheduleMgtBCImpl
 * @since J2EE 1.4
 */
@WebService(name="ActualScheduleManagementWSProxyPortType", serviceName="ActualScheduleManagementWSProxy",
        targetNamespace="http://www.smlines.com/integration/alps")

@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,
         use=SOAPBinding.Use.LITERAL,
         parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)

@WLHttpTransport(contextPath="/hanjin/webservices", serviceUri="/ActualScheduleManagementWSProxy",
             portName="ActualScheduleManagementWSProxyPort")
public class ActualScheduleManagementWSProxy {
	protected transient Logger log = Logger.getLogger(this.getClass().getName());
	
	/**
     * 입력받은 Port Code를 ETA 기준 -7일 ~ +7일에 Calling하는 Vvd를 조회한다.
     * 
     * @param String vps_port_cd
     * @param String vsl_svc_tp_cd
     * @return VvdListByPortVO[]
     */
	@WebMethod()
	@SuppressWarnings("unchecked")
    public VvdListByPortVO[] searchSppVvdListByPort(String vps_port_cd, String vsl_svc_tp_cd) {
    	
		//Interface ID  SPP_VSK-0001
		Event event = null;
		ActualScheduleManagementSC sc = new ActualScheduleManagementSC();
		List<VvdListByPortVO> vvdListByPortVOs = null;
		VvdListByPortVO[] vvdListByPortVOS = null;
    	
    	log.debug("ActualScheduleManagementWSProxy searchSppVvdListByPort");
    	try {
            /**
             * EVENT 생성 / 전송 
             */
    		event = new VopVskSPPVSK0001Event();
    		VvdListByPortVO vvdListByPortVO = new VvdListByPortVO();
    		vvdListByPortVO.setVpsPortCd(vps_port_cd);
    		vvdListByPortVO.setVslSvcTpCd(vsl_svc_tp_cd);
    		
            
            FormCommand f = new FormCommand();
            f.setCommand(FormCommand.SEARCH);
            event.setFormCommand(f);
            
            ((VopVskSPPVSK0001Event) event).setVvdListByPortVO(vvdListByPortVO);
            /**
             * EventResponse로 부터 전송 객체의 생성 
             */

            EventResponse eventResponse = (EventResponse)sc.perform(event);
            
            vvdListByPortVOs = (List)eventResponse.getRsVoList();
            
            if(vvdListByPortVOs != null && vvdListByPortVOs.size() > 0){
            	vvdListByPortVOS = new VvdListByPortVO[vvdListByPortVOs.size()];
            	for(int i=0; i<vvdListByPortVOs.size(); i++){
            		vvdListByPortVOS[i] = vvdListByPortVOs.get(i);
            	}
            }
           
    	}catch(EventException ee) {
            log.error("ActualScheduleManagementWSProxy Error : " + ee.toString(), ee);
            
    	}catch(Exception e) {
            log.error("ActualScheduleManagementWSProxy Error : " + e.toString(), e);
    	}
    	
    	return vvdListByPortVOS;
    }
	
	/**
     * 입력 대상 VVD에 Actual Port Schedule 정보 조회  (SPP)
     * 
     * @param String vsl_cd
     * @param String skd_voy_no
     * @param String skd_dir_cd
     * @param String vps_port_cd
     * @param String clpt_ind_seq
     * @return ActSkdMgtVO[]
     */
	@WebMethod()
	@SuppressWarnings("unchecked")
    public ActSkdMgtVO[] searchActPortSkd(String vsl_cd, String skd_voy_no, String skd_dir_cd, String vps_port_cd, String clpt_ind_seq) {
    	
		//Interface ID  SPP_VSK-0002
		Event event = null;
		ActualScheduleManagementSC sc = new ActualScheduleManagementSC();
		List<ActSkdMgtVO> actSkdMgtVOs = null;
		ActSkdMgtVO[] actSkdMgtVOS = null;
    	
    	log.debug("ActualScheduleManagementWSProxy searchSppActPortSkd");
    	try {
            /**
             * EVENT 생성 / 전송 
             */
    		event = new VopVskSPPVSK0002Event();
    		ActSkdMgtVO actSkdMgtVO = new ActSkdMgtVO();
    		actSkdMgtVO.setVslCd(vsl_cd);
    		actSkdMgtVO.setSkdVoyNo(skd_voy_no);
    		actSkdMgtVO.setSkdDirCd(skd_dir_cd);
    		actSkdMgtVO.setVpsPortCd(vps_port_cd.substring(0, 5));
    		actSkdMgtVO.setClptIndSeq(clpt_ind_seq);
            
            FormCommand f = new FormCommand();
            f.setCommand(FormCommand.SEARCH);
            event.setFormCommand(f);
            
            ((VopVskSPPVSK0002Event) event).setActSkdMgtVO(actSkdMgtVO);
            /**
             * EventResponse로 부터 전송 객체의 생성 
             */

            EventResponse eventResponse = (EventResponse)sc.perform(event);
            
            actSkdMgtVOs = (List)eventResponse.getRsVoList();
            
            if(actSkdMgtVOs != null && actSkdMgtVOs.size() > 0){
            	actSkdMgtVOS = new ActSkdMgtVO[actSkdMgtVOs.size()];
            	for(int i=0; i<actSkdMgtVOs.size(); i++){
            		actSkdMgtVOS[i] = actSkdMgtVOs.get(i);
            	}
            }
           
    	}catch(EventException ee) {
            log.error("ActualScheduleManagementWSProxy Error : " + ee.toString(), ee);
            
    	}catch(Exception e) {
            log.error("ActualScheduleManagementWSProxy Error : " + e.toString(), e);
    	}
    	
    	return actSkdMgtVOS;
    }
	
	/**
     * 입력 대상 VVD에 Actual Port Schedule 정보 생성 및 변경  (SPP)
     * @param ActSkdMgtVO  actSkdMgtVO
     * @return String
     */
	@WebMethod()
    public String manageActPortSkd(ActSkdMgtVO  actSkdMgtVO) {
    	
		//Interface ID  SPP_VSK-0003
		Event event = null;
		ActualScheduleManagementSC sc = new ActualScheduleManagementSC();
		String result = "";
    	
    	log.debug("ActualScheduleManagementWSProxy manageActPortSkd");
    	try {
            /**
             * EVENT 생성 / 전송 
             */
    		actSkdMgtVO.setUpdUsrId("ESVCUSER");
    		
    		event = new VopVskSPPVSK0003Event();
            
            FormCommand f = new FormCommand();
            f.setCommand(FormCommand.MULTI);
            event.setFormCommand(f);
            
            ((VopVskSPPVSK0003Event) event).setActSkdMgtVO(actSkdMgtVO);
            /**
             * EventResponse로 부터 전송 객체의 생성 
             */

            sc.perform(event);
            
            result	= "Success";
           
    	}catch(EventException ee) {
            log.error("ActualScheduleManagementWSProxy Error : " + ee.toString(), ee);
    		result = ee.toString();
            
    	}catch(Exception e) {
            log.error("ActualScheduleManagementWSProxy Error : " + e.toString(), e);
            result = e.toString();
    	}
    	
    	return result;
    }
}
