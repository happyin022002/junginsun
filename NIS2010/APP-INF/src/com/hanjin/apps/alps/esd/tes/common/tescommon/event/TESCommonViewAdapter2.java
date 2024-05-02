/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TESCommonViewAdapter.java
*@FileTitle : TES Common 관리
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.07.13 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.tescommon.event;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;

/**
 * TesCommon 에 대한 <br>
 * -  TesCommonViewAdapter 작성<br>
 *
 * @author yOng hO lEE
 * @see TesCommonHTMLAction 참조
 * @since J2EE 1.6
 */
public class TESCommonViewAdapter2 extends ViewAdapter{
	
    /**
     * 
     */
    public TESCommonViewAdapter2()
    {
    	log = Logger.getLogger(getClass().getName());
    }
    
	@Override
	protected String makeDataTag(List<AbstractValueObject> arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String makeDataTag(DBRowSet arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	
    /**
     * @param HttpServletRequest request
     * @param HttpServletResponse response
     * @return String
     * @see com.hanjin.framework.core.controller.ViewAdapter#makeXML(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public String makeXML(HttpServletRequest request, HttpServletResponse response)
    {
//        Event event = null;
//        GeneralEventResponse eventResponse = null;
        Exception serverException = null;
        String strXML = "";
        
        boolean isupload = isUploadFile(request);
        try
        {
            serverException = (Exception)request.getAttribute("com.hanjin.framework.core.comm.EXCEPTION_OBJECT      ");

            if(serverException != null)
            {
                strXML = getErrorXML((new ErrorHandler(serverException)).loadPopupMessage(), isupload);
            } else
            {
            	
                StringBuilder	sbufXML		= new StringBuilder();
            	ArrayList 		sheetV 		= new ArrayList();
            	String 			emStr 		= null;
            	
            	String 			prefix 		= JSPUtil.getNull(request.getParameter("prefix"));
            	String [] 		ibflag 		= request.getParameterValues(prefix+"ibflag");
            	
                if (ibflag!=null && ibflag.length >= 1){
                	Enumeration emParamName = request.getParameterNames();
                	while (emParamName.hasMoreElements()){
                		emStr = (String) emParamName.nextElement();
//                		log.debug("emStr===>"+emStr);
//                		log.debug("request.getParameterValues(emStr)====>"+request.getParameterValues(emStr));
//                		log.debug("request.getParameterValues(emStr).length====>"+request.getParameterValues(emStr).length);
//                		log.debug("ibflag.lengthlength====>"+ibflag.length);
//                		if(request.getParameterValues(emStr).length==2){
//                			log.debug("[0]=============>"+request.getParameterValues(emStr)[0]);
//                			log.debug("[1]=============>"+request.getParameterValues(emStr)[1]);
//                		}
                		
                		if (request.getParameterValues(emStr).length==ibflag.length){
                			sheetV.add(emStr);
                		}
                	}
                }

            	/* COLORDER 생성 */
            	String colOrder = "";
            	for (int k=0; k<sheetV.size(); k++){
            		colOrder = colOrder + sheetV.get(k);
            		if (k!=sheetV.size()-1) colOrder = colOrder + "|";
            	}
            	colOrder = (colOrder==null?colOrder:colOrder.toLowerCase());
                
                
        		//TOTAL 개수 조정
        		sbufXML.append("<SHEET>\n");
        		sbufXML.append("	<DATA TOTAL='").append(ibflag.length).append("' COLORDER='"+colOrder+"'>\n");
        		for (int k=0; k<ibflag.length; k++){
    				sbufXML.append( (new StringBuilder("<TR>\n")).toString() );
    			
    				for (int j=0; j<sheetV.size(); j++){
    					sbufXML.append( (new StringBuilder("<TD><![CDATA[")).toString() );
    					sbufXML.append( JSPUtil.getNull(request.getParameterValues((String)sheetV.get(j))[k]));
    					sbufXML.append( (new StringBuilder("]]></TD>")).toString() );
    				}
    				sbufXML.append( (new StringBuilder("</TR>\n")).toString() );
        		}
        		
                sbufXML.append( (new StringBuilder(" </DATA>\n</SHEET>")).toString() );
                
                strXML = sbufXML.toString();
            	
            }
        }
        catch(Exception ex)
        {
            log.error(ex.getMessage(), ex);
            strXML = getErrorXML((new ErrorHandler(ex)).loadPopupMessage(), isupload);
        }
        
        if(log.isDebugEnabled())
            log.debug((new StringBuilder("\n")).append(strXML).toString());
        
        return strXML;
    }



    /**
     *  업로드 파일 
     * @param request HttpServletRequest
     * @return
     */
    private boolean isUploadFile(HttpServletRequest request)
    {
        boolean isUpload = false;
        String contentType = request.getContentType();
        if(contentType != null && contentType.startsWith("multipart/form-data"))
            isUpload = true;
        return isUpload;
    }    

	

}
