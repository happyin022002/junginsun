/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0035HTMLAction.java
*@FileTitle : EsdSce0035
*Open Issues :
*Change history :
*@LastModifyDate : 2009-11-12
*@LastModifier : 전병석
*@LastVersion : 1.7
* 2006-09-20 yongcheon_shin
* 1.0 최초 생성
* 2009-11-12 전병석
* 1.7 버전 커밋 
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315SendVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchEDIPerformanceOptionsVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchEdiSummaryReportOptionsVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
/**
 * HTTP Parser<br>
 * - com.hanjin.apps 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 UserManagerSC로 실행요청<br>
 * - UserManagerSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author yong_cheon_shin
 * @see ReserveSendManagerEvent , PNSendManagerEventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_SCE_0035HTMLAction  extends HTMLActionSupport{
    
    /** Constructor
     * 
     */
	private static final long serialVersionUID = 1L;
    public ESD_SCE_0035HTMLAction(){
        
    }
    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 IbatchVisibilityEvent로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		log.debug("Event 0035 spawn.");
		EsdSce0035Event e = new EsdSce0035Event();
		FormCommand command = FormCommand.fromRequest(request);
		
        if (command.isCommand(FormCommand.SEARCH01)) {
        	log.debug("Event 0035 spawn---SEARCH01");
        	e.setSchSROptsVO((SearchEdiSummaryReportOptionsVO) getVO(request,SearchEdiSummaryReportOptionsVO.class));
        }else if(command.isCommand(FormCommand.SEARCH02)) {
        	log.debug("Event 0035 spawn---SEARCH02");
        	e.setSchSROptsVO((SearchEdiSummaryReportOptionsVO) getVO(request,SearchEdiSummaryReportOptionsVO.class));  
        }else if(command.isCommand(FormCommand.SEARCH03)) {
        	log.debug("Event 0035 spawn---SEARCH03");
        	e.setSchSROptsVO((SearchEdiSummaryReportOptionsVO) getVO(request,SearchEdiSummaryReportOptionsVO.class)); 
        }else if(command.isCommand(FormCommand.MULTI01)) {
        	log.debug("Event 0035 - MULTI01 ");
        	e.setSchSROptsVO((SearchEdiSummaryReportOptionsVO) getVO(request,SearchEdiSummaryReportOptionsVO.class));  
        	List<Edi315SendVO> sendvos =  null;
        	String prefix = "sheet2_";
        	int length = request.getParameterValues(prefix + "ibflg").length;
        	log.debug( length  + " cell[s] are selected");
        	
        	if(length >0 ){
        		sendvos = new ArrayList<Edi315SendVO>();
        		String[] params1  = (JSPUtil.getParameter(request, prefix +"por_cd".trim(),length));         
        		String[] params2  = (JSPUtil.getParameter(request, prefix +"pol_cd".trim(),length));         
        		String[] params3  = (JSPUtil.getParameter(request, prefix +"pod_cd".trim(),length));         
        		String[] params4  = (JSPUtil.getParameter(request, prefix +"del_cd".trim(),length));         
        		String[] params5  = (JSPUtil.getParameter(request, prefix +"edi_sts_cd".trim(),length));   
        		String[] params6  = (JSPUtil.getParameter(request, prefix +"edi_sub_sts_cd".trim(),length)); 
        		String[] params7  = (JSPUtil.getParameter(request, prefix +"edi_snd_knt".trim(),length));    
        		String[] params8  = (JSPUtil.getParameter(request, prefix +"act_dt1".trim(),length));     
        		String[] params9  = (JSPUtil.getParameter(request, prefix +"act_dt2".trim(),length));    
        		String[] params10 = (JSPUtil.getParameter(request, prefix +"nod_cd".trim(),length));     
        		String[] params11 = (JSPUtil.getParameter(request, prefix +"edi_prc_dt1".trim(),length));    
        		String[] params12 = (JSPUtil.getParameter(request, prefix +"edi_prc_dt2".trim(),length));    
        		String[] params13 = (JSPUtil.getParameter(request, prefix +"edi_lcl_dt1".trim(),length));    
        		String[] params14 = (JSPUtil.getParameter(request, prefix +"edi_lcl_dt2".trim(),length));       
        		String[] params15 = (JSPUtil.getParameter(request, prefix +"cop_no".trim(),length));               
        		String[] params16 = (JSPUtil.getParameter(request, prefix +"ibflg".trim(),length));     	       
        		String[] params17 = (JSPUtil.getParameter(request, prefix +"ts_port".trim(),length));            
        		String[] params18 = (JSPUtil.getParameter(request, prefix +"rail".trim(),length));      
        		String[] params19 = (JSPUtil.getParameter(request, prefix +"flt_file_ref_no".trim(),length));
        		String[] params20 = (JSPUtil.getParameter(request, prefix + "vvd".trim(),length));             
        		String[] params21 = (JSPUtil.getParameter(request, prefix +"bkg_no".trim(),length));         
        		String[] params22 = (JSPUtil.getParameter(request, prefix +"bl_no".trim(),length));          
        		String[] params23 = (JSPUtil.getParameter(request, prefix +"cntr_no".trim(),length)); 
        		
        		for(int i=0;i<length;i++){
        			Edi315SendVO sendvo = new Edi315SendVO();
        			log.debug("params1[" + i + "]: " + params1[i]); 
        			log.debug("params2[" + i + "]: " + params2[i]); 
        			log.debug("params3[" + i + "]: " + params3[i]); 
        			log.debug("params4[" + i + "]: " + params4[i]); 
        			log.debug("params5[" + i + "]: " + params5[i]); 
        			log.debug("params6[" + i + "]: " + params6[i]); 
        			log.debug("params7[" + i + "]: " + params7[i]); 
        			log.debug("params8[" + i + "]: " + params8[i]); 
        			log.debug("params9[" + i + "]: " + params9[i]); 
        			log.debug("params10[" + i + "]: " + params10[i]); 
        			log.debug("params11[" + i + "]: " + params11[i]); 
        			log.debug("params12[" + i + "]: " + params12[i]); 
        			log.debug("params13[" + i + "]: " + params13[i]); 
        			log.debug("params14[" + i + "]: " + params14[i]); 
        			log.debug("params15[" + i + "]: " + params15[i]); 
        			log.debug("params16[" + i + "]: " + params16[i]); 
        			log.debug("params17[" + i + "]: " + params17[i]); 
        			log.debug("params18[" + i + "]: " + params18[i]);        			
        			log.debug("params19[" + i + "]: " + params19[i]);
        			log.debug("params20[" + i + "]: " + params20[i]); 
        			log.debug("params21[" + i + "]: " + params21[i]); 
        			log.debug("params22[" + i + "]: " + params22[i]);        			
        			log.debug("params23[" + i + "]: " + params23[i]);

        			/*기 정의된값 세팅*/
                    sendvo.setCreId("");
        			sendvo.setUpdId("");
        			sendvo.setCallFrom("MAN");
        			sendvo.setLogFlg("Y");
        			sendvo.setManFlg("Y");
        			
        			/*화면에서 받아온 값을 VO 에 정의함*/
                    sendvo.setEdiStatus (params5[i] );
                    sendvo.setCustStatus(params6[i] );
                    sendvo.setEventDt   (params8[i] + params9[i]);
        			sendvo.setBkgNo     (params21[i]);
        			sendvo.setEventYard( params10[i]);
        			sendvo.setCntrNo    (params23[i]);

        			log.debug("upid [" + i + "]: " +     sendvo.getUpdId()); 
        			log.debug("cre id[" + i + "]: " +    sendvo.getCreId());        			
        			log.debug("setCntrNo[" + i + "]: " + sendvo.getCntrNo());
        			
        			sendvos.add(sendvo);
        		}//for       		
        			e.setEdi315SendVOs(sendvos);
        	}//if

        }else if(command.isCommand(FormCommand.MULTI02)) {
        	log.debug("Event 0035 - MULTI02 ");
        	e.setSchSROptsVO((SearchEdiSummaryReportOptionsVO) getVO(request,SearchEdiSummaryReportOptionsVO.class));  
        	List<Edi315SendVO> sendvos =  null;
        	String prefix = "sheet2_";
        	int length = request.getParameterValues(prefix + "ibflg").length;
        	log.debug( length  + " cell[s] are selected");
        	
        	if(length >0 ){
        		sendvos = new ArrayList<Edi315SendVO>();
        		String[] params1  = (JSPUtil.getParameter(request, prefix +"por_cd".trim(),length));         
        		String[] params2  = (JSPUtil.getParameter(request, prefix +"pol_cd".trim(),length));         
        		String[] params3  = (JSPUtil.getParameter(request, prefix +"pod_cd".trim(),length));         
        		String[] params4  = (JSPUtil.getParameter(request, prefix +"del_cd".trim(),length));         
        		String[] params5  = (JSPUtil.getParameter(request, prefix +"edi_sts_cd".trim(),length));   
        		String[] params6  = (JSPUtil.getParameter(request, prefix +"edi_sub_sts_cd".trim(),length)); 
        		String[] params7  = (JSPUtil.getParameter(request, prefix +"edi_snd_knt".trim(),length));    
        		String[] params8  = (JSPUtil.getParameter(request, prefix +"act_dt1".trim(),length));     
        		String[] params9  = (JSPUtil.getParameter(request, prefix +"act_dt2".trim(),length));    
        		String[] params10 = (JSPUtil.getParameter(request, prefix +"nod_cd".trim(),length));     
        		String[] params11 = (JSPUtil.getParameter(request, prefix +"edi_prc_dt1".trim(),length));    
        		String[] params12 = (JSPUtil.getParameter(request, prefix +"edi_prc_dt2".trim(),length));    
        		String[] params13 = (JSPUtil.getParameter(request, prefix +"edi_lcl_dt1".trim(),length));    
        		String[] params14 = (JSPUtil.getParameter(request, prefix +"edi_lcl_dt2".trim(),length));       
        		String[] params15 = (JSPUtil.getParameter(request, prefix +"cop_no".trim(),length));               
        		String[] params16 = (JSPUtil.getParameter(request, prefix +"ibflg".trim(),length));     	       
        		String[] params17 = (JSPUtil.getParameter(request, prefix +"ts_port".trim(),length));            
        		String[] params18 = (JSPUtil.getParameter(request, prefix +"rail".trim(),length));      
        		String[] params19 = (JSPUtil.getParameter(request, prefix +"flt_file_ref_no".trim(),length));
        		String[] params20 = (JSPUtil.getParameter(request, prefix + "vvd".trim(),length));             
        		String[] params21 = (JSPUtil.getParameter(request, prefix +"bkg_no".trim(),length));         
        		String[] params22 = (JSPUtil.getParameter(request, prefix +"bl_no".trim(),length));          
        		String[] params23 = (JSPUtil.getParameter(request, prefix +"cntr_no".trim(),length)); 
        		
        		for(int i=0;i<length;i++){
        			Edi315SendVO sendvo = new Edi315SendVO();
        			log.debug("params1[" + i + "]: " + params1[i]); 
        			log.debug("params2[" + i + "]: " + params2[i]); 
        			log.debug("params3[" + i + "]: " + params3[i]); 
        			log.debug("params4[" + i + "]: " + params4[i]); 
        			log.debug("params5[" + i + "]: " + params5[i]); 
        			log.debug("params6[" + i + "]: " + params6[i]); 
        			log.debug("params7[" + i + "]: " + params7[i]); 
        			log.debug("params8[" + i + "]: " + params8[i]); 
        			log.debug("params9[" + i + "]: " + params9[i]); 
        			log.debug("params10[" + i + "]: " + params10[i]); 
        			log.debug("params11[" + i + "]: " + params11[i]); 
        			log.debug("params12[" + i + "]: " + params12[i]); 
        			log.debug("params13[" + i + "]: " + params13[i]); 
        			log.debug("params14[" + i + "]: " + params14[i]); 
        			log.debug("params15[" + i + "]: " + params15[i]); 
        			log.debug("params16[" + i + "]: " + params16[i]); 
        			log.debug("params17[" + i + "]: " + params17[i]); 
        			log.debug("params18[" + i + "]: " + params18[i]);        			
        			log.debug("params19[" + i + "]: " + params19[i]);
        			log.debug("params20[" + i + "]: " + params20[i]); 
        			log.debug("params21[" + i + "]: " + params21[i]); 
        			log.debug("params22[" + i + "]: " + params22[i]);        			
        			log.debug("params23[" + i + "]: " + params23[i]);

        			/*기 정의된값 세팅*/
                    sendvo.setCreId("");
        			sendvo.setUpdId("");
        			sendvo.setCallFrom("MAN");
        			sendvo.setManFlg("Y");
        			
        			/*화면에서 받아온 값을 VO 에 정의함*/
                    sendvo.setEdiStatus (params5[i] );
                    sendvo.setCustStatus(params6[i] );
                    sendvo.setEventDt   (params8[i] + params9[i]);
        			sendvo.setBkgNo     (params21[i]);
        			sendvo.setEventYard( params10[i]);
        			sendvo.setCntrNo    (params23[i]);

        			log.debug("upid [" + i + "]: " +     sendvo.getUpdId()); 
        			log.debug("cre id[" + i + "]: " +    sendvo.getCreId());        			
        			log.debug("setCntrNo[" + i + "]: " + sendvo.getCntrNo());
        			
        			sendvos.add(sendvo);
        		}//for       		
        			e.setEdi315SendVOs(sendvos);
        	}//if

        }else if(command.isCommand(FormCommand.MULTI03)) {
        	log.debug("Event 0035 - MULTI03 ");
        	e.setSchSROptsVO((SearchEdiSummaryReportOptionsVO) getVO(request,SearchEdiSummaryReportOptionsVO.class));  
        	List<Edi315SendVO> sendvos =  null;
        	String prefix = "sheet3_";
        	int length = request.getParameterValues(prefix + "ibflg").length;
        	log.debug( length  + " cell[s] are selected");
        	
        	if(length >0 ){
        		sendvos = new ArrayList<Edi315SendVO>();
        		String[] params1   = (JSPUtil.getParameter(request, prefix +"vvd".trim(),length)); 
        		String[] params2   = (JSPUtil.getParameter(request, prefix +"bkg_no".trim(),length));
        		String[] params3   = (JSPUtil.getParameter(request, prefix +"bl_no".trim(),length));
        		String[] params4   = (JSPUtil.getParameter(request, prefix +"cntr_no".trim(),length));
        		String[] params5   = (JSPUtil.getParameter(request, prefix +"por_cd".trim(),length));
        		String[] params6   = (JSPUtil.getParameter(request, prefix +"pol_cd".trim(),length));
        		String[] params7   = (JSPUtil.getParameter(request, prefix +"pod_cd".trim(),length));
        		String[] params8   = (JSPUtil.getParameter(request, prefix +"del_cd".trim(),length));
        		String[] params9   = (JSPUtil.getParameter(request, prefix +"flag".trim(),length));
        		String[] params10  = (JSPUtil.getParameter(request, prefix +"edi_sts_cd".trim(),length));
        		String[] params11  = (JSPUtil.getParameter(request, prefix +"edi_sub_sts_cd".trim(),length));
        		String[] params12  = (JSPUtil.getParameter(request, prefix +"edi_snd_knt".trim(),length));
        		String[] params13  = (JSPUtil.getParameter(request, prefix +"act_dt1".trim(),length));
        		String[] params14  = (JSPUtil.getParameter(request, prefix +"act_dt2".trim(),length));
        		String[] params15  = (JSPUtil.getParameter(request, prefix +"nod_cd".trim(),length));
        		String[] params16  = (JSPUtil.getParameter(request, prefix +"cre_dt1".trim(),length));
        		String[] params17  = (JSPUtil.getParameter(request, prefix +"cre_dt2".trim(),length));
        		String[] params18  = (JSPUtil.getParameter(request, prefix +"gmt_dt1".trim(),length));
        		String[] params19  = (JSPUtil.getParameter(request, prefix +"gmt_dt2".trim(),length));
        		String[] params20  = (JSPUtil.getParameter(request, prefix +"rbtn".trim(),length));
        		String[] params21  = (JSPUtil.getParameter(request, prefix +"cop_no".trim(),length));
        		String[] params22  = (JSPUtil.getParameter(request, prefix +"flag".trim(),length));
        		String[] params23  = (JSPUtil.getParameter(request, prefix +"ts_port".trim(),length));
        		String[] params24  = (JSPUtil.getParameter(request, prefix +"rail".trim(),length));
        		String[] params25  = (JSPUtil.getParameter(request, prefix +"flt_file_ref_no".trim(),length));
        		
        		for(int i=0;i<length;i++){
        			Edi315SendVO sendvo = new Edi315SendVO();
        			log.debug("params1[" + i + "]: " + params1[i]); 
        			log.debug("params2[" + i + "]: " + params2[i]); 
        			log.debug("params3[" + i + "]: " + params3[i]); 
        			log.debug("params4[" + i + "]: " + params4[i]); 
        			log.debug("params5[" + i + "]: " + params5[i]); 
        			log.debug("params6[" + i + "]: " + params6[i]); 
        			log.debug("params7[" + i + "]: " + params7[i]); 
        			log.debug("params8[" + i + "]: " + params8[i]); 
        			log.debug("params9[" + i + "]: " + params9[i]); 
        			log.debug("params10[" + i + "]: " + params10[i]); 
        			log.debug("params11[" + i + "]: " + params11[i]); 
        			log.debug("params12[" + i + "]: " + params12[i]); 
        			log.debug("params13[" + i + "]: " + params13[i]); 
        			log.debug("params14[" + i + "]: " + params14[i]); 
        			log.debug("params15[" + i + "]: " + params15[i]); 
        			log.debug("params16[" + i + "]: " + params16[i]); 
        			log.debug("params17[" + i + "]: " + params17[i]); 
        			log.debug("params18[" + i + "]: " + params18[i]);        			
        			log.debug("params19[" + i + "]: " + params19[i]);
        			log.debug("params20[" + i + "]: " + params20[i]); 
        			log.debug("params21[" + i + "]: " + params21[i]); 
        			log.debug("params22[" + i + "]: " + params22[i]);        			
        			log.debug("params23[" + i + "]: " + params23[i]);
        			log.debug("params24[" + i + "]: " + params24[i]);        			
        			log.debug("params25[" + i + "]: " + params25[i]);

        			/*기 정의된값 세팅*/
                    sendvo.setCreId("");
        			sendvo.setUpdId("");
        			sendvo.setCallFrom("MAN");
        			sendvo.setLogFlg("Y");
        			sendvo.setManFlg("Y");
        			
        			/*화면에서 받아온 값을 VO 에 정의함*/
                    sendvo.setEdiStatus (params10[i] );
                    sendvo.setCustStatus(params11[i] );
                    sendvo.setEventDt   (params13[i] + params14[i]);
        			sendvo.setBkgNo     (params2[i]);
        			sendvo.setEventYard( params15[i]);
        			sendvo.setCntrNo    (params4[i]);

        			log.debug("upid [" + i + "]: " +     sendvo.getUpdId()); 
        			log.debug("cre id[" + i + "]: " +    sendvo.getCreId());        			
        			log.debug("setCntrNo[" + i + "]: " + sendvo.getCntrNo());
        			
        			sendvos.add(sendvo);
        		}//for       		
        			e.setEdi315SendVOs(sendvos);
        	}//if        	
        }else if(command.isCommand(FormCommand.MULTI04)) {
        	log.debug("Event 0035 - MULTI04 ");
        	e.setSchSROptsVO((SearchEdiSummaryReportOptionsVO) getVO(request,SearchEdiSummaryReportOptionsVO.class));  
        	List<Edi315SendVO> sendvos =  null;
        	String prefix = "sheet3_";
        	int length = request.getParameterValues(prefix + "ibflg").length;
        	log.debug( length  + " cell[s] are selected");
        	
        	if(length >0 ){
        		sendvos = new ArrayList<Edi315SendVO>();
        		String[] params1   = (JSPUtil.getParameter(request, prefix +"vvd".trim(),length)); 
        		String[] params2   = (JSPUtil.getParameter(request, prefix +"bkg_no".trim(),length));
        		String[] params3   = (JSPUtil.getParameter(request, prefix +"bl_no".trim(),length));
        		String[] params4   = (JSPUtil.getParameter(request, prefix +"cntr_no".trim(),length));
        		String[] params5   = (JSPUtil.getParameter(request, prefix +"por_cd".trim(),length));
        		String[] params6   = (JSPUtil.getParameter(request, prefix +"pol_cd".trim(),length));
        		String[] params7   = (JSPUtil.getParameter(request, prefix +"pod_cd".trim(),length));
        		String[] params8   = (JSPUtil.getParameter(request, prefix +"del_cd".trim(),length));
        		String[] params9   = (JSPUtil.getParameter(request, prefix +"flag".trim(),length));
        		String[] params10  = (JSPUtil.getParameter(request, prefix +"edi_sts_cd".trim(),length));
        		String[] params11  = (JSPUtil.getParameter(request, prefix +"edi_sub_sts_cd".trim(),length));
        		String[] params12  = (JSPUtil.getParameter(request, prefix +"edi_snd_knt".trim(),length));
        		String[] params13  = (JSPUtil.getParameter(request, prefix +"act_dt1".trim(),length));
        		String[] params14  = (JSPUtil.getParameter(request, prefix +"act_dt2".trim(),length));
        		String[] params15  = (JSPUtil.getParameter(request, prefix +"nod_cd".trim(),length));
        		String[] params16  = (JSPUtil.getParameter(request, prefix +"cre_dt1".trim(),length));
        		String[] params17  = (JSPUtil.getParameter(request, prefix +"cre_dt2".trim(),length));
        		String[] params18  = (JSPUtil.getParameter(request, prefix +"gmt_dt1".trim(),length));
        		String[] params19  = (JSPUtil.getParameter(request, prefix +"gmt_dt2".trim(),length));
        		String[] params20  = (JSPUtil.getParameter(request, prefix +"rbtn".trim(),length));
        		String[] params21  = (JSPUtil.getParameter(request, prefix +"cop_no".trim(),length));
        		String[] params22  = (JSPUtil.getParameter(request, prefix +"flag".trim(),length));
        		String[] params23  = (JSPUtil.getParameter(request, prefix +"ts_port".trim(),length));
        		String[] params24  = (JSPUtil.getParameter(request, prefix +"rail".trim(),length));
        		String[] params25  = (JSPUtil.getParameter(request, prefix +"flt_file_ref_no".trim(),length));
        		
        		for(int i=0;i<length;i++){
        			Edi315SendVO sendvo = new Edi315SendVO();
        			log.debug("params1[" + i + "]: " + params1[i]); 
        			log.debug("params2[" + i + "]: " + params2[i]); 
        			log.debug("params3[" + i + "]: " + params3[i]); 
        			log.debug("params4[" + i + "]: " + params4[i]); 
        			log.debug("params5[" + i + "]: " + params5[i]); 
        			log.debug("params6[" + i + "]: " + params6[i]); 
        			log.debug("params7[" + i + "]: " + params7[i]); 
        			log.debug("params8[" + i + "]: " + params8[i]); 
        			log.debug("params9[" + i + "]: " + params9[i]); 
        			log.debug("params10[" + i + "]: " + params10[i]); 
        			log.debug("params11[" + i + "]: " + params11[i]); 
        			log.debug("params12[" + i + "]: " + params12[i]); 
        			log.debug("params13[" + i + "]: " + params13[i]); 
        			log.debug("params14[" + i + "]: " + params14[i]); 
        			log.debug("params15[" + i + "]: " + params15[i]); 
        			log.debug("params16[" + i + "]: " + params16[i]); 
        			log.debug("params17[" + i + "]: " + params17[i]); 
        			log.debug("params18[" + i + "]: " + params18[i]);        			
        			log.debug("params19[" + i + "]: " + params19[i]);
        			log.debug("params20[" + i + "]: " + params20[i]); 
        			log.debug("params21[" + i + "]: " + params21[i]); 
        			log.debug("params22[" + i + "]: " + params22[i]);        			
        			log.debug("params23[" + i + "]: " + params23[i]);
        			log.debug("params24[" + i + "]: " + params24[i]);        			
        			log.debug("params25[" + i + "]: " + params25[i]);

        			/*기 정의된값 세팅*/
                    sendvo.setCreId("");
        			sendvo.setUpdId("");
        			sendvo.setCallFrom("MAN");
        			sendvo.setManFlg("Y");
        			
        			/*화면에서 받아온 값을 VO 에 정의함*/
                    sendvo.setEdiStatus (params10[i] );
                    sendvo.setCustStatus(params11[i] );
                    sendvo.setEventDt   (params13[i] + params14[i]);
        			sendvo.setBkgNo     (params2[i]);
        			sendvo.setEventYard( params15[i]);
        			sendvo.setCntrNo    (params4[i]);

        			log.debug("upid [" + i + "]: " +     sendvo.getUpdId()); 
        			log.debug("cre id[" + i + "]: " +    sendvo.getCreId());        			
        			log.debug("setCntrNo[" + i + "]: " + sendvo.getCntrNo());
        			
        			sendvos.add(sendvo);
        		}//for       		
        			e.setEdi315SendVOs(sendvos);
        	}//if         	
        }else if(command.isCommand(FormCommand.MULTI05)) {
        	log.debug("Event 0035 spawn---MULTI05");
        	e.setSchSROptsVO((SearchEdiSummaryReportOptionsVO) getVO(request,SearchEdiSummaryReportOptionsVO.class));        	
        }else if(command.isCommand(FormCommand.MULTI06)) {
        	e.setSchEpOpts((SearchEDIPerformanceOptionsVO) getVO(request,SearchEDIPerformanceOptionsVO.class));
        }
		request.setAttribute("Event", e);
		return  e;
    }

    /**
     * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
     * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @param eventResponse EventResponse interface를 구현한 객체
     */
    public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
        request.setAttribute("EventResponse", eventResponse);
    }

    /**
     * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
     * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @param event Event interface를 구현한 객체
     */
    public void doEnd(HttpServletRequest request, Event event) {
        request.setAttribute("Event", event);
    }
}
