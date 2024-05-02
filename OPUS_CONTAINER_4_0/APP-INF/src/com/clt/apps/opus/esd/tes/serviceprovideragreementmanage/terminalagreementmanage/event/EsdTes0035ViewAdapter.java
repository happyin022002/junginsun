/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTes0035ViewAdapter.java
*@FileTitle : EsdTes0035 관리
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.10.13 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author yOng hO lEE
 * @see ViewAdapter 참조
 * @since J2EE 1.6
 */
public class EsdTes0035ViewAdapter extends ViewAdapter{
    /**
     * EsdTes0035ViewAdapter 
     */
    public EsdTes0035ViewAdapter()
    {
    	log = Logger.getLogger(getClass().getName());
    }
    
    /**
     * @param HttpServletRequest request
     * @param HttpServletResponse response
     * @return String
     * @see com.clt.framework.core.controller.ViewAdapter#makeXML(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public String makeXML(HttpServletRequest request, HttpServletResponse response)
    {
        GeneralEventResponse	eventResponse	= null;
        Exception				serverException	= null;
    	DBRowSet				rowSet			= null;		//DB ResultSet

        StringBuilder			sbuXML			= new StringBuilder();

        String					strXML			= "";
        String					prefix			= "";
		String					colOrder		= "";
		StringBuffer			colOrderBuf	= new  StringBuffer();

		int			rowCount		= 0;
    	boolean		isupload		= isUploadFile(request);
    	
    	try
        {
            serverException = (Exception)request.getAttribute("com.clt.framework.core.comm.EXCEPTION_OBJECT      ");

            if(serverException != null)
            {
                strXML = getErrorXML((new ErrorHandler(serverException)).loadPopupMessage(), isupload);
            } else
            {
            	
                eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
                
        		if (eventResponse != null) {
        			prefix = eventResponse.getETCData("sheet_prefix");
        			rowSet = eventResponse.getRs();
        			if ( rowSet != null ) {
        				rowCount	= rowSet.getRowCount();
	    				for(int k = 1; k < rowSet.getMetaData().getColumnCount() + 1 ; k++) {
//							colOrder = colOrder + prefix + rowSet.getMetaData().getColumnName(k);
							colOrderBuf.append(prefix).append(rowSet.getMetaData().getColumnName(k));
							
							if(k != rowSet.getMetaData().getColumnCount()){
//								colOrder = colOrder + "|";
								colOrderBuf.append("|");
							}
						}
        			}
        			
        			colOrder = colOrderBuf.toString();
    				colOrder = (colOrder == null ? colOrder : colOrder.toLowerCase() );
    				
        			sbuXML.append("<SHEET>\n");
           			sbuXML.append( getETCData(eventResponse, request) );
        			sbuXML.append("	<DATA TOTAL='").append(rowCount).append("' COLORDER='").append(colOrder).append("'>\n");

            		int		i	= 1;
            		if (rowSet != null) {
    					while (rowSet.next()) {
    						
    	    				sbuXML.append("<TR>\n");
    	    				for (int j = 0; j < rowSet.getMetaData().getColumnCount(); j++) {
    	    					sbuXML.append("   <TD><![CDATA[").append(JSPUtil.getNull(rowSet.getString(rowSet.getMetaData().getColumnName(i++)))).append("]]></TD>\n");
    	    				}
    	    				sbuXML.append("</TR>\n");
	    					i	= 1;
    					}// while..[]
    				}// if..[]
    				
           			sbuXML.append("	</DATA>\n");
           			
        			sbuXML.append("</SHEET>");

        		} // end if        
        	strXML	= sbuXML.toString();
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
     * @param eventResponse
     * @param request
     * @return String <ETC-DATA>태그 부분의 XML문자열
     */
    @SuppressWarnings("unchecked")
	protected String getETCData(EventResponse eventResponse, HttpServletRequest request)
    {
        if(eventResponse == null)
            return "";
        StringBuilder			sb			= new StringBuilder();
        HashMap<String, String>	etc_data	= (HashMap<String, String>)eventResponse.getETCData();

        sb.append("<ETC-DATA>\n");
        if(etc_data != null && etc_data.size() > 0)
        {
            String key;
            String val;
            for(Iterator it = etc_data.keySet().iterator(); it.hasNext(); sb.append((new StringBuilder("<ETC KEY='")).append(key).append("'><![CDATA[").append(val).append("]]></ETC>\n").toString()))
            {
                key = (String)it.next();
                val = (new StringBuilder()).append((String)etc_data.get(key)).toString();
            }//for..[]

        }
        sb.append(getPivotETCData(eventResponse));
        sb.append("</ETC-DATA>\n");
        
        return sb.toString();
    }
	
	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 객체
	 * @param colOrder String[] Column명 문자열 
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception 
	 */	
    @SuppressWarnings("unchecked")
	protected String makeDataTag(List vos, String prefix)
    {
        StringBuilder sbufXML = new StringBuilder();

        return sbufXML.toString();
    }

	/**
	 * DBRowSet를 Parsing하여 <DATA>태그를 생성한다.<br>
	 * IBSheet의 prefix값이 있는 경우 COLORDER에 prefix를 붙인 column명으로 표시해 준다.<br>
	 * 
	 * @param rs DBRowSet 		VO객체
	 * @param prefix String 		IBSheet savename's prefix string
	 * @return String IBSheet 		<DATA>태그
	 * @exception 
	 */
    protected String makeDataTag(DBRowSet rs, String prefix)
    {
        StringBuilder sb = new StringBuilder();
        return sb.toString();
    }
    
    /**
     * 파일 업로드 여부
     * @param request
     * @return boolean
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
