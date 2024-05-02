/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : SppUserManageWSProxy.java
 *@FileTitle : SppUserManagement
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.25
 *@LastModifier : jun sang ahn
 *@LastVersion : 1.0
 * 2009.06.25 jun sang ahn
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.exp.spp.usermanage.servicesio;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import org.apache.log4j.Logger;
import weblogic.jws.WLHttpTransport;

import com.hanjin.apps.alps.exp.spp.usermanage.sppusermanage.SppUserManageSC;
import com.hanjin.apps.alps.exp.spp.usermanage.sppusermanage.basic.SppUserManageBCImpl;
import com.hanjin.apps.alps.exp.spp.usermanage.sppusermanage.event.SppusermanageEvent;
import com.hanjin.apps.alps.exp.spp.usermanage.sppusermanage.vo.MnrPartnerGRPVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.MdmVendorVO;
import com.hanjin.syscommon.common.table.MnrPartnerVO;
import com.hanjin.syscommon.common.table.MnrPrnrCntcPntVO;

/**
 * SppUserManagement 처리를 담당<br>
 * SppUserManagement Logic을 처리하기 위한 작업수행.<br>
 * 
 * @author jun sang ahn
 * @see SppUserManageBCImpl 참조
 * @since J2EE 1.4
 */
@WebService(name="SppUserManageWSProxyPortType", serviceName="SppUserManageWSProxy",
        targetNamespace="http://www.hanjin.com/integration/alps")

@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,
         use=SOAPBinding.Use.LITERAL,
         parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)

@WLHttpTransport(contextPath="/hanjin/webservices", serviceUri="/SppUserManageWSProxy",
             portName="SppUserManageWSProxyPort")
public class SppUserManageWSProxy {
	/**
	 * Log
	 */
    protected transient Logger log = Logger.getLogger(this.getClass().getName());
    
    /**
     * spp userid 에 해당하는 정보를 가져온다.
     * @param spp_id String
     * @return mnrPartnerGRPVO MnrPartnerGRPVO
     */
    @WebMethod()
	@SuppressWarnings("unchecked")
    public MnrPartnerGRPVO searchSppBidUserInfo(String spp_id) {
    	
    	SppUserManageSC msc				= new SppUserManageSC();
    	MnrPartnerGRPVO mnrPartnerGRPVO = new MnrPartnerGRPVO();
    	
    	log.debug("SppUserManageWSProxy searchSppBidUserInfo");
    	try {
            /**
             * EVENT 생성 / 전송 
             */
    		SppusermanageEvent event = new SppusermanageEvent();
    		event.setSpPtalId(spp_id);
            
            FormCommand f = new FormCommand();
            f.setCommand(FormCommand.SEARCH);
            event.setFormCommand(f);
            
            /**
             * EventResponse로 부터 전송 객체의 생성 
             */
            EventResponse eventResponse = (EventResponse)msc.perform(event);
            
            MnrPartnerVO 			vo1 = (MnrPartnerVO)eventResponse.getCustomData().get("vo1");
            List<MnrPrnrCntcPntVO>  vo2 = (List)eventResponse.getCustomData().get("vo2");
            
            if(vo1 !=null) {
            	mnrPartnerGRPVO.setMnrPartnerVO(vo1);
            	if(vo2 !=null && vo2.size() >0){
    	            MnrPrnrCntcPntVO[] mnrPrnrCntcPntVO = new MnrPrnrCntcPntVO[vo2.size()];
    	            for(int i=0;i< vo2.size(); i++){
    	            	mnrPrnrCntcPntVO[i] = vo2.get(i);
    	            }
    	            mnrPartnerGRPVO.setMnrPrnrCntcPntVOS(mnrPrnrCntcPntVO);
                }    
            }
           
    	}catch(EventException ee) {
            log.error("SppUserManageWSProxy Error : " + ee.toString(), ee);
            
    	}catch(Exception e) {
            log.error("SppUserManageWSProxy Error : " + e.toString(), e);
    	}
    	
    	return mnrPartnerGRPVO;
    }
    
    /**
     * Bidding및 Mnr spp 신규회원을 등록한다.
     * @param mnrPartnerGRPVO MnrPartnerGRPVO
     * @return result String
     */
    @WebMethod()
	@SuppressWarnings("unchecked")
    public String addSppBidUserInfo(MnrPartnerGRPVO mnrPartnerGRPVO) {
    	
    	SppUserManageSC msc				= new SppUserManageSC();
    	String result					= "";
    	
    	log.debug("SppUserManageWSProxy addSppBidUserInfo");
    	try {
            /**
             * EVENT 생성 / 전송 
             */
    		
    		SppusermanageEvent event = new SppusermanageEvent();
    		event.setMnrPartnerGRPVO(mnrPartnerGRPVO);
            
            FormCommand f = new FormCommand();
            f.setCommand(FormCommand.ADD);
            event.setFormCommand(f);
            
            /**
             * EventResponse로 부터 전송 객체의 생성 
             */
            
            msc.perform(event);
            
            result	= "Success";
            
    	}catch(EventException ee) {
            log.error("SppUserManageWSProxy Error : " + ee.toString(), ee);
            
    	}catch(Exception e) {
            log.error("SppUserManageWSProxy Error : " + e.toString(), e);
    	}
    	
    	return result;
    }
    
    /**
     * EQ Sale 회원정보를 수정한다.
     * @param MnrPartnerGRPVO mnrPartnerGRPVO
     * @return result String
     */
    @WebMethod()
	@SuppressWarnings("unchecked")
    public String modifySppBidUserInfo(MnrPartnerGRPVO mnrPartnerGRPVO) {
    	
    	SppUserManageSC msc				= new SppUserManageSC();
    	String result					= "";
    	
    	log.debug("SppUserManageWSProxy modifySppBidUserInfo");
    	try {
            /**
             * EVENT 생성 / 전송 
             */
    		
    		SppusermanageEvent event = new SppusermanageEvent();
    		event.setMnrPartnerGRPVO(mnrPartnerGRPVO);
            
            FormCommand f = new FormCommand();
            f.setCommand(FormCommand.MODIFY);
            event.setFormCommand(f);
            
            /**
             * EventResponse로 부터 전송 객체의 생성 
             */
            msc.perform(event);
            result	= "Success";
            
    	}catch(EventException ee) {
            log.error("SppUserManageWSProxy Error : " + ee.toString(), ee);
            
    	}catch(Exception e) {
            log.error("SppUserManageWSProxy Error : " + e.toString(), e);
    	}
    	
    	return result;
    }
    
    /**
     * PSO회원의 Bank info 정보를 수정한다.
     * @param String vndr_seq
     * @param String bankInfo
     * @return String
     */
    @WebMethod()
	@SuppressWarnings("unchecked")
    public String modifySppPsoUserInfo(String vndr_seq,String bankInfo) {
    	
    	SppUserManageSC msc				= new SppUserManageSC();
    	String result					= "";
    	
    	log.debug("SppUserManageWSProxy modifySppPsoUserInfo");
    	try {
            /**
             * EVENT 생성 / 전송 
             */
    		
    		MdmVendorVO mdmVendorVO = new MdmVendorVO();
    		mdmVendorVO.setVndrSeq(vndr_seq);
    		mdmVendorVO.setCnlAgnBankDesc(bankInfo);
    		
    		SppusermanageEvent event = new SppusermanageEvent();
    		event.setMdmVendorVO(mdmVendorVO);
            
            FormCommand f = new FormCommand();
            f.setCommand(FormCommand.MODIFY01);
            event.setFormCommand(f);
            
            /**
             * EventResponse로 부터 전송 객체의 생성 
             */
            msc.perform(event);
            result	= "Success";
            
    	}catch(EventException ee) {
            log.error("SppUserManageWSProxy Error : " + ee.toString(), ee);
            
    	}catch(Exception e) {
            log.error("SppUserManageWSProxy Error : " + e.toString(), e);
    	}
    	
    	return result;
    }
    
    /**
     * Bid User Password 정보를 수정한다.
     * @param MnrPartnerGRPVO mnrPartnerGRPVO
     * @return result String
     */
    @WebMethod()
	@SuppressWarnings("unchecked")
    public String modifySppUserBidPwdInfo(MnrPartnerGRPVO mnrPartnerGRPVO) {
    	
    	SppUserManageSC msc				= new SppUserManageSC();
    	String result					= "";
    	
    	log.debug("SppUserManageWSProxy modifySppUserBidPwdInfo");
    	try {
            /**
             * EVENT 생성 / 전송 
             */
    		
    		SppusermanageEvent event = new SppusermanageEvent();
    		event.setMnrPartnerGRPVO(mnrPartnerGRPVO);
            
            FormCommand f = new FormCommand();
            f.setCommand(FormCommand.MODIFY02);
            event.setFormCommand(f);
            
            /**
             * EventResponse로 부터 전송 객체의 생성 
             */
            msc.perform(event);
            result	= "Success";
            
    	}catch(EventException ee) {
            log.error("SppUserManageWSProxy Error : " + ee.toString(), ee);
            
    	}catch(Exception e) {
            log.error("SppUserManageWSProxy Error : " + e.toString(), e);
    	}
    	
    	return result;
    }

}
