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

import com.clt.apps.opus.vop.vsk.actualschedulemanagement.ActualScheduleManagementSC;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.basic.ActualScheduleMgtBCImpl;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.event.VopVskSPPVSK0001Event;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.event.VopVskSPPVSK0002Event;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.event.VopVskSPPVSK0003Event;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdMgtSppVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdMgtVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.VvdListByPortVO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.html.FormCommand;


/**
 *  Interface ID : EXP005-0001
 *
 * Retrieving calling port vvd list for Actual Skd (SPP)
 *
 * @author 
 * @see ActualScheduleMgtBCImpl
 * @since J2EE 1.4
 */
@WebService(name="ActualScheduleManagementWSProxyPortType", serviceName="ActualScheduleManagementWSProxy", targetNamespace="http://www.clt.com/integration")

@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,
         use=SOAPBinding.Use.LITERAL,
         parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)

@WLHttpTransport(contextPath="/opuscntr/webservices", serviceUri="/ActualScheduleManagementWSProxy",
             portName="ActualScheduleManagementWSProxyPort")
public class ActualScheduleManagementWSProxy {
	protected transient Logger log = Logger.getLogger(this.getClass().getName());
	
	/**
     * Retrieving calling vvd which ETA between -7 and +7
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
             * EVENT Create / Transmit 
             */
    		event = new VopVskSPPVSK0001Event();
    		VvdListByPortVO vvdListByPortVO = new VvdListByPortVO();
    		vvdListByPortVO.setVpsPortCd(vps_port_cd);
    		vvdListByPortVO.setVslSvcTpCd(vsl_svc_tp_cd);
    		
            
            FormCommand f = new FormCommand();
            f.setCommand(FormCommand.SEARCH);
            event.setFormCommand(f);
            
            ((VopVskSPPVSK0001Event) event).setVvdListByPortVO(vvdListByPortVO);

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
     * Retrieving Actual Port Schedule (SPP)
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
    public ActSkdMgtSppVO[] searchActPortSkd(String vsl_cd, String skd_voy_no, String skd_dir_cd, String vps_port_cd, String clpt_ind_seq) {
    	
		//Interface ID  SPP_VSK-0002
		Event event = null;
		ActualScheduleManagementSC sc = new ActualScheduleManagementSC();
		List<ActSkdMgtVO> actSkdMgtVOs = null;
		ActSkdMgtSppVO[] actSkdMgtSppVOS = null;
    	
    	log.debug("ActualScheduleManagementWSProxy searchSppActPortSkd");
    	try {
            /**
             * EVENT Create / Transmit 
             */
    		event = new VopVskSPPVSK0002Event();
    		ActSkdMgtVO actSkdMgtVO = new ActSkdMgtVO();
    		actSkdMgtVO.setVslCd(vsl_cd);
    		actSkdMgtVO.setSkdVoyNo(skd_voy_no);
    		actSkdMgtVO.setSkdDirCd(skd_dir_cd);
    		actSkdMgtVO.setVpsPortCd(vps_port_cd);
    		actSkdMgtVO.setClptIndSeq(clpt_ind_seq);
            
            FormCommand f = new FormCommand();
            f.setCommand(FormCommand.SEARCH);
            event.setFormCommand(f);
            
            ((VopVskSPPVSK0002Event) event).setActSkdMgtVO(actSkdMgtVO);

            EventResponse eventResponse = (EventResponse)sc.perform(event);
            
            actSkdMgtVOs = (List)eventResponse.getRsVoList();
            
            if(actSkdMgtVOs != null && actSkdMgtVOs.size() > 0){
            	actSkdMgtSppVOS = new ActSkdMgtSppVO[actSkdMgtVOs.size()];
            	for (int i=0; i < actSkdMgtVOs.size(); i++) {
            		actSkdMgtSppVOS[i] = new ActSkdMgtSppVO();
            		actSkdMgtSppVOS[i].setVslCd               (actSkdMgtVOs.get(i).getVslCd());
            		actSkdMgtSppVOS[i].setVslArrDlayRsnCd     (actSkdMgtVOs.get(i).getVslArrDlayRsnCd());
            		actSkdMgtSppVOS[i].setAftUnbrthAnkOffDt   (actSkdMgtVOs.get(i).getAftUnbrthAnkOffDt());
            		actSkdMgtSppVOS[i].setBfrBrthAnkDrpDt     (actSkdMgtVOs.get(i).getBfrBrthAnkDrpDt());
            		actSkdMgtSppVOS[i].setTtlGbgQty           (actSkdMgtVOs.get(i).getTtlGbgQty());
            		actSkdMgtSppVOS[i].setTurnSkdVoyNo        (actSkdMgtVOs.get(i).getTurnSkdVoyNo());
            		actSkdMgtSppVOS[i].setNxtPortCd           (actSkdMgtVOs.get(i).getNxtPortCd());
            		actSkdMgtSppVOS[i].setArrFoilWgt          (actSkdMgtVOs.get(i).getArrFoilWgt());
            		actSkdMgtSppVOS[i].setPagerows            (actSkdMgtVOs.get(i).getPagerows());
            		actSkdMgtSppVOS[i].setSplFoilWgt          (actSkdMgtVOs.get(i).getSplFoilWgt());
            		actSkdMgtSppVOS[i].setTurnPortIndCd       (actSkdMgtVOs.get(i).getTurnPortIndCd());
            		actSkdMgtSppVOS[i].setVpsPortCd           (actSkdMgtVOs.get(i).getVpsPortCd());
            		actSkdMgtSppVOS[i].setClptSeq             (actSkdMgtVOs.get(i).getClptSeq  ());
            		actSkdMgtSppVOS[i].setAftUnbrthAnkDrpDt   (actSkdMgtVOs.get(i).getAftUnbrthAnkDrpDt());
            		actSkdMgtSppVOS[i].setLstEtbDt            (actSkdMgtVOs.get(i).getLstEtbDt ());
            		actSkdMgtSppVOS[i].setArrFrshWtrWgt       (actSkdMgtVOs.get(i).getArrFrshWtrWgt());
            		actSkdMgtSppVOS[i].setNxtActInpFlg        (actSkdMgtVOs.get(i).getNxtActInpFlg());
            		actSkdMgtSppVOS[i].setPortSkdStsCd        (actSkdMgtVOs.get(i).getPortSkdStsCd());
            		actSkdMgtSppVOS[i].setDepBlstWgt          (actSkdMgtVOs.get(i).getDepBlstWgt());
            		actSkdMgtSppVOS[i].setLstEtaDt            (actSkdMgtVOs.get(i).getLstEtaDt());
            		actSkdMgtSppVOS[i].setUpdUsrId            (actSkdMgtVOs.get(i).getUpdUsrId());
            		actSkdMgtSppVOS[i].setDepTugBotKnt        (actSkdMgtVOs.get(i).getDepTugBotKnt());
            		actSkdMgtSppVOS[i].setDlayDepTm           (actSkdMgtVOs.get(i).getDlayDepTm());
            		actSkdMgtSppVOS[i].setPrePortCd           (actSkdMgtVOs.get(i).getPrePortCd());
            		actSkdMgtSppVOS[i].setDepFoilWgt          (actSkdMgtVOs.get(i).getDepFoilWgt());
            		actSkdMgtSppVOS[i].setArrFwddrHgt         (actSkdMgtVOs.get(i).getArrFwddrHgt());
            		actSkdMgtSppVOS[i].setVpsEtdDt            (actSkdMgtVOs.get(i).getVpsEtdDt());
            		actSkdMgtSppVOS[i].setSkdVoyNo            (actSkdMgtVOs.get(i).getSkdVoyNo());
            		actSkdMgtSppVOS[i].setNxtEtaDt            (actSkdMgtVOs.get(i).getNxtEtaDt());
            		actSkdMgtSppVOS[i].setVslBrthDlayRsnCd    (actSkdMgtVOs.get(i).getVslBrthDlayRsnCd());
            		actSkdMgtSppVOS[i].setVslBrthDlayRsnNm    (actSkdMgtVOs.get(i).getVslBrthDlayRsnNm());
            		actSkdMgtSppVOS[i].setCreUsrId            (actSkdMgtVOs.get(i).getCreUsrId());
            		actSkdMgtSppVOS[i].setFlag                (actSkdMgtVOs.get(i).getFlag());
            		actSkdMgtSppVOS[i].setDepFwddrHgt         (actSkdMgtVOs.get(i).getDepFwddrHgt());
            		actSkdMgtSppVOS[i].setDepGmHgt            (actSkdMgtVOs.get(i).getDepGmHgt());
            		actSkdMgtSppVOS[i].setVslDepDlayRsnCd     (actSkdMgtVOs.get(i).getVslDepDlayRsnCd());
            		actSkdMgtSppVOS[i].setVslArrDlayRsnNm     (actSkdMgtVOs.get(i).getVslArrDlayRsnNm());
            		actSkdMgtSppVOS[i].setTurnClptIndSeq      (actSkdMgtVOs.get(i).getTurnClptIndSeq());
            		actSkdMgtSppVOS[i].setPltLstUnldDt        (actSkdMgtVOs.get(i).getPltLstUnldDt());
            		actSkdMgtSppVOS[i].setActBrthDt           (actSkdMgtVOs.get(i).getActBrthDt());
            		actSkdMgtSppVOS[i].setVpsEtbDt            (actSkdMgtVOs.get(i).getVpsEtbDt());
            		actSkdMgtSppVOS[i].setVslDepDlayRsnNm     (actSkdMgtVOs.get(i).getVslDepDlayRsnNm());
            		actSkdMgtSppVOS[i].setTurnPortFlg         (actSkdMgtVOs.get(i).getTurnPortFlg());
            		actSkdMgtSppVOS[i].setCreDt               (actSkdMgtVOs.get(i).getCreDt    ());
            		actSkdMgtSppVOS[i].setDepFrshWtrWgt       (actSkdMgtVOs.get(i).getDepFrshWtrWgt());
            		actSkdMgtSppVOS[i].setDlayArrTm           (actSkdMgtVOs.get(i).getDlayArrTm());
            		actSkdMgtSppVOS[i].setArrLowSulpFoilWgt   (actSkdMgtVOs.get(i).getArrLowSulpFoilWgt());
            		actSkdMgtSppVOS[i].setBfrBrthAnkOffDt     (actSkdMgtVOs.get(i).getBfrBrthAnkOffDt());
            		actSkdMgtSppVOS[i].setSplLowSulpDoilWgt   (actSkdMgtVOs.get(i).getSplLowSulpDoilWgt());
            		actSkdMgtSppVOS[i].setActArrDt            (actSkdMgtVOs.get(i).getActArrDt());
            		actSkdMgtSppVOS[i].setDlayBrthTm          (actSkdMgtVOs.get(i).getDlayBrthTm());
            		actSkdMgtSppVOS[i].setVpsEtaDt            (actSkdMgtVOs.get(i).getVpsEtaDt());
            		actSkdMgtSppVOS[i].setSkdStsCd            (actSkdMgtVOs.get(i).getSkdStsCd());
            		actSkdMgtSppVOS[i].setTurnSkdDirCd        (actSkdMgtVOs.get(i).getTurnSkdDirCd());
            		actSkdMgtSppVOS[i].setIbflag              (actSkdMgtVOs.get(i).getIbflag());
            		actSkdMgtSppVOS[i].setArrDoilWgt          (actSkdMgtVOs.get(i).getArrDoilWgt());
            		actSkdMgtSppVOS[i].setDepDoilWgt          (actSkdMgtVOs.get(i).getDepDoilWgt());
            		actSkdMgtSppVOS[i].setArrBlstWgt          (actSkdMgtVOs.get(i).getArrBlstWgt());
            		actSkdMgtSppVOS[i].setSplFrshWtrWgt       (actSkdMgtVOs.get(i).getSplFrshWtrWgt());
            		actSkdMgtSppVOS[i].setSplDoilWgt          (actSkdMgtVOs.get(i).getSplDoilWgt());
            		actSkdMgtSppVOS[i].setUpdDt               (actSkdMgtVOs.get(i).getUpdDt());
            		actSkdMgtSppVOS[i].setArrLowSulpDoilWgt   (actSkdMgtVOs.get(i).getArrLowSulpDoilWgt());
            		actSkdMgtSppVOS[i].setTtlSlgWgt           (actSkdMgtVOs.get(i).getTtlSlgWgt());
            		actSkdMgtSppVOS[i].setPreEtdDt            (actSkdMgtVOs.get(i).getPreEtdDt());
            		actSkdMgtSppVOS[i].setPfEtdDt             (actSkdMgtVOs.get(i).getPfEtdDt());
            		actSkdMgtSppVOS[i].setLstEtdDt            (actSkdMgtVOs.get(i).getLstEtdDt());
            		actSkdMgtSppVOS[i].setSplLowSulpFoilWgt   (actSkdMgtVOs.get(i).getSplLowSulpFoilWgt());
            		actSkdMgtSppVOS[i].setPfEtaDt             (actSkdMgtVOs.get(i).getPfEtaDt());
            		actSkdMgtSppVOS[i].setPfEtbDt             (actSkdMgtVOs.get(i).getPfEtbDt());
            		actSkdMgtSppVOS[i].setArrAftdrHgt         (actSkdMgtVOs.get(i).getArrAftdrHgt());
            		actSkdMgtSppVOS[i].setArrGmHgt            (actSkdMgtVOs.get(i).getArrGmHgt());
            		actSkdMgtSppVOS[i].setDepLowSulpDoilWgt   (actSkdMgtVOs.get(i).getDepLowSulpDoilWgt());
            		actSkdMgtSppVOS[i].setDepAftdrHgt         (actSkdMgtVOs.get(i).getDepAftdrHgt());
            		actSkdMgtSppVOS[i].setSkdDirCd            (actSkdMgtVOs.get(i).getSkdDirCd());
            		actSkdMgtSppVOS[i].setArrTugBotKnt        (actSkdMgtVOs.get(i).getArrTugBotKnt());
            		actSkdMgtSppVOS[i].setActDepDt            (actSkdMgtVOs.get(i).getActDepDt());
            		actSkdMgtSppVOS[i].setDiffRmk             (actSkdMgtVOs.get(i).getDiffRmk());
            		actSkdMgtSppVOS[i].setSlanCd              (actSkdMgtVOs.get(i).getSlanCd());
            		actSkdMgtSppVOS[i].setYdCd                (actSkdMgtVOs.get(i).getYdCd());
            		actSkdMgtSppVOS[i].setClptIndSeq          (actSkdMgtVOs.get(i).getClptIndSeq());
            		actSkdMgtSppVOS[i].setDepLowSulpFoilWgt   (actSkdMgtVOs.get(i).getDepLowSulpFoilWgt());
            		actSkdMgtSppVOS[i].setActAtaInpDt         (actSkdMgtVOs.get(i).getActAtaInpDt());
            		actSkdMgtSppVOS[i].setActAtbInpDt         (actSkdMgtVOs.get(i).getActAtbInpDt());
            		actSkdMgtSppVOS[i].setActAtdInpDt         (actSkdMgtVOs.get(i).getActAtdInpDt());
            		actSkdMgtSppVOS[i].setActAtaInpUsrId      (actSkdMgtVOs.get(i).getActAtaInpUsrId());
            		actSkdMgtSppVOS[i].setActAtbInpUsrId      (actSkdMgtVOs.get(i).getActAtbInpUsrId());
            		actSkdMgtSppVOS[i].setActAtdInpUsrId      (actSkdMgtVOs.get(i).getActAtdInpUsrId());
            	}
            }
           
    	}catch(EventException ee) {
            log.error("ActualScheduleManagementWSProxy Error : " + ee.toString(), ee);
            
    	}catch(Exception e) {
            log.error("ActualScheduleManagementWSProxy Error : " + e.toString(), e);
    	}
    	
    	return actSkdMgtSppVOS;
    }
	
	/**
     * Creating and Changing Actual Port Schedule (SPP)
     * @param ActSkdMgtSppVO  actSkdMgtSppVO
     * @return String
     */
	@WebMethod()
    public String manageActPortSkd(ActSkdMgtSppVO  actSkdMgtSppVO) {
    	
		//Interface ID  SPP_VSK-0003
		Event event = null;
		ActualScheduleManagementSC sc = new ActualScheduleManagementSC();
		String result = "";
		ActSkdMgtVO actSkdMgtVO = null;
    	log.debug("ActualScheduleManagementWSProxy manageActPortSkd");
    	try {
            /**
             * EVENT Create / Transmit 
             */
    		 actSkdMgtVO = setActSkdMgtVO(actSkdMgtSppVO);
    		
    		 actSkdMgtVO.setUpdUsrId("ESVCUSER");
    		
    		 event = new VopVskSPPVSK0003Event();
            
             FormCommand f = new FormCommand();
             f.setCommand(FormCommand.MULTI);
             event.setFormCommand(f);
            
             ((VopVskSPPVSK0003Event) event).setActSkdMgtVO(actSkdMgtVO);

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
	
	private ActSkdMgtVO setActSkdMgtVO(ActSkdMgtSppVO actSkdMgtSppVO) {
		
		ActSkdMgtVO actSkdMgtVO = new ActSkdMgtVO();
		
		actSkdMgtVO.setVslCd               (actSkdMgtSppVO.getVslCd());
		actSkdMgtVO.setVslArrDlayRsnCd     (actSkdMgtSppVO.getVslArrDlayRsnCd());
		actSkdMgtVO.setAftUnbrthAnkOffDt   (actSkdMgtSppVO.getAftUnbrthAnkOffDt());
		actSkdMgtVO.setBfrBrthAnkDrpDt     (actSkdMgtSppVO.getBfrBrthAnkDrpDt());
		actSkdMgtVO.setTtlGbgQty           (actSkdMgtSppVO.getTtlGbgQty());
		actSkdMgtVO.setTurnSkdVoyNo        (actSkdMgtSppVO.getTurnSkdVoyNo());
		actSkdMgtVO.setNxtPortCd           (actSkdMgtSppVO.getNxtPortCd());
		actSkdMgtVO.setArrFoilWgt          (actSkdMgtSppVO.getArrFoilWgt());
		actSkdMgtVO.setPagerows            (actSkdMgtSppVO.getPagerows());
		actSkdMgtVO.setSplFoilWgt          (actSkdMgtSppVO.getSplFoilWgt());
		actSkdMgtVO.setTurnPortIndCd       (actSkdMgtSppVO.getTurnPortIndCd());
		actSkdMgtVO.setVpsPortCd           (actSkdMgtSppVO.getVpsPortCd());
		actSkdMgtVO.setClptSeq             (actSkdMgtSppVO.getClptSeq  ());
		actSkdMgtVO.setAftUnbrthAnkDrpDt   (actSkdMgtSppVO.getAftUnbrthAnkDrpDt());
		actSkdMgtVO.setLstEtbDt            (actSkdMgtSppVO.getLstEtbDt ());
		actSkdMgtVO.setArrFrshWtrWgt       (actSkdMgtSppVO.getArrFrshWtrWgt());
		actSkdMgtVO.setNxtActInpFlg        (actSkdMgtSppVO.getNxtActInpFlg());
		actSkdMgtVO.setPortSkdStsCd        (actSkdMgtSppVO.getPortSkdStsCd());
		actSkdMgtVO.setDepBlstWgt          (actSkdMgtSppVO.getDepBlstWgt());
		actSkdMgtVO.setLstEtaDt            (actSkdMgtSppVO.getLstEtaDt());
		actSkdMgtVO.setUpdUsrId            (actSkdMgtSppVO.getUpdUsrId());
		actSkdMgtVO.setDepTugBotKnt        (actSkdMgtSppVO.getDepTugBotKnt());
		actSkdMgtVO.setDlayDepTm           (actSkdMgtSppVO.getDlayDepTm());
		actSkdMgtVO.setPrePortCd           (actSkdMgtSppVO.getPrePortCd());
		actSkdMgtVO.setDepFoilWgt          (actSkdMgtSppVO.getDepFoilWgt());
		actSkdMgtVO.setArrFwddrHgt         (actSkdMgtSppVO.getArrFwddrHgt());
		actSkdMgtVO.setVpsEtdDt            (actSkdMgtSppVO.getVpsEtdDt());
		actSkdMgtVO.setSkdVoyNo            (actSkdMgtSppVO.getSkdVoyNo());
		actSkdMgtVO.setNxtEtaDt            (actSkdMgtSppVO.getNxtEtaDt());
		actSkdMgtVO.setVslBrthDlayRsnCd    (actSkdMgtSppVO.getVslBrthDlayRsnCd());
		actSkdMgtVO.setVslBrthDlayRsnNm    (actSkdMgtSppVO.getVslBrthDlayRsnNm());
		actSkdMgtVO.setCreUsrId            (actSkdMgtSppVO.getCreUsrId());
		actSkdMgtVO.setFlag                (actSkdMgtSppVO.getFlag());
		actSkdMgtVO.setDepFwddrHgt         (actSkdMgtSppVO.getDepFwddrHgt());
		actSkdMgtVO.setDepGmHgt            (actSkdMgtSppVO.getDepGmHgt());
		actSkdMgtVO.setVslDepDlayRsnCd     (actSkdMgtSppVO.getVslDepDlayRsnCd());
		actSkdMgtVO.setVslArrDlayRsnNm     (actSkdMgtSppVO.getVslArrDlayRsnNm());
		actSkdMgtVO.setTurnClptIndSeq      (actSkdMgtSppVO.getTurnClptIndSeq());
		actSkdMgtVO.setPltLstUnldDt        (actSkdMgtSppVO.getPltLstUnldDt());
		actSkdMgtVO.setActBrthDt           (actSkdMgtSppVO.getActBrthDt());
		actSkdMgtVO.setVpsEtbDt            (actSkdMgtSppVO.getVpsEtbDt());
		actSkdMgtVO.setVslDepDlayRsnNm     (actSkdMgtSppVO.getVslDepDlayRsnNm());
		actSkdMgtVO.setTurnPortFlg         (actSkdMgtSppVO.getTurnPortFlg());
		actSkdMgtVO.setCreDt               (actSkdMgtSppVO.getCreDt    ());
		actSkdMgtVO.setDepFrshWtrWgt       (actSkdMgtSppVO.getDepFrshWtrWgt());
		actSkdMgtVO.setDlayArrTm           (actSkdMgtSppVO.getDlayArrTm());
		actSkdMgtVO.setArrLowSulpFoilWgt   (actSkdMgtSppVO.getArrLowSulpFoilWgt());
		actSkdMgtVO.setBfrBrthAnkOffDt     (actSkdMgtSppVO.getBfrBrthAnkOffDt());
		actSkdMgtVO.setSplLowSulpDoilWgt   (actSkdMgtSppVO.getSplLowSulpDoilWgt());
		actSkdMgtVO.setActArrDt            (actSkdMgtSppVO.getActArrDt());
		actSkdMgtVO.setDlayBrthTm          (actSkdMgtSppVO.getDlayBrthTm());
		actSkdMgtVO.setVpsEtaDt            (actSkdMgtSppVO.getVpsEtaDt());
		actSkdMgtVO.setSkdStsCd            (actSkdMgtSppVO.getSkdStsCd());
		actSkdMgtVO.setTurnSkdDirCd        (actSkdMgtSppVO.getTurnSkdDirCd());
		actSkdMgtVO.setIbflag              (actSkdMgtSppVO.getIbflag());
		actSkdMgtVO.setArrDoilWgt          (actSkdMgtSppVO.getArrDoilWgt());
		actSkdMgtVO.setDepDoilWgt          (actSkdMgtSppVO.getDepDoilWgt());
		actSkdMgtVO.setArrBlstWgt          (actSkdMgtSppVO.getArrBlstWgt());
		actSkdMgtVO.setSplFrshWtrWgt       (actSkdMgtSppVO.getSplFrshWtrWgt());
		actSkdMgtVO.setSplDoilWgt          (actSkdMgtSppVO.getSplDoilWgt());
		actSkdMgtVO.setUpdDt               (actSkdMgtSppVO.getUpdDt());
		actSkdMgtVO.setArrLowSulpDoilWgt   (actSkdMgtSppVO.getArrLowSulpDoilWgt());
		actSkdMgtVO.setTtlSlgWgt           (actSkdMgtSppVO.getTtlSlgWgt());
		actSkdMgtVO.setPreEtdDt            (actSkdMgtSppVO.getPreEtdDt());
		actSkdMgtVO.setPfEtdDt             (actSkdMgtSppVO.getPfEtdDt());
		actSkdMgtVO.setLstEtdDt            (actSkdMgtSppVO.getLstEtdDt());
		actSkdMgtVO.setSplLowSulpFoilWgt   (actSkdMgtSppVO.getSplLowSulpFoilWgt());
		actSkdMgtVO.setPfEtaDt             (actSkdMgtSppVO.getPfEtaDt());
		actSkdMgtVO.setPfEtbDt             (actSkdMgtSppVO.getPfEtbDt());
		actSkdMgtVO.setArrAftdrHgt         (actSkdMgtSppVO.getArrAftdrHgt());
		actSkdMgtVO.setArrGmHgt            (actSkdMgtSppVO.getArrGmHgt());
		actSkdMgtVO.setDepLowSulpDoilWgt   (actSkdMgtSppVO.getDepLowSulpDoilWgt());
		actSkdMgtVO.setDepAftdrHgt         (actSkdMgtSppVO.getDepAftdrHgt());
		actSkdMgtVO.setSkdDirCd            (actSkdMgtSppVO.getSkdDirCd());
		actSkdMgtVO.setArrTugBotKnt        (actSkdMgtSppVO.getArrTugBotKnt());
		actSkdMgtVO.setActDepDt            (actSkdMgtSppVO.getActDepDt());
		actSkdMgtVO.setDiffRmk             (actSkdMgtSppVO.getDiffRmk());
		actSkdMgtVO.setSlanCd              (actSkdMgtSppVO.getSlanCd());
		actSkdMgtVO.setYdCd                (actSkdMgtSppVO.getYdCd());
		actSkdMgtVO.setClptIndSeq          (actSkdMgtSppVO.getClptIndSeq());
		actSkdMgtVO.setDepLowSulpFoilWgt   (actSkdMgtSppVO.getDepLowSulpFoilWgt());
		actSkdMgtVO.setActAtaInpDt         (actSkdMgtSppVO.getActAtaInpDt());
		actSkdMgtVO.setActAtbInpDt         (actSkdMgtSppVO.getActAtbInpDt());
		actSkdMgtVO.setActAtdInpDt         (actSkdMgtSppVO.getActAtdInpDt());
		actSkdMgtVO.setActAtaInpUsrId      (actSkdMgtSppVO.getActAtaInpUsrId());
		actSkdMgtVO.setActAtbInpUsrId      (actSkdMgtSppVO.getActAtbInpUsrId());
		actSkdMgtVO.setActAtdInpUsrId      (actSkdMgtSppVO.getActAtdInpUsrId());
		
		return actSkdMgtVO;
	}
}
