/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdTes0028ComboViewAdapter.java
*@FileTitle : Cost Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009-12-07
*@LastModifier : jongbaemoon
*@LastVersion : 1.0
* 2006-09-07 jongbaemoon
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.tes.codemanage.codemanage.event;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.GeneralEventResponse;

/** EsdTes0028ComboViewAdapter
 *  PDTO(Data Transfer Object including Parameters)
 *  
 *  @author 9009637
 *  @see ESD_TES_0028HTMLAction.java 참고
 *  @since J2EE 1.6
 */
public class EsdTes0028ComboViewAdapter extends ViewAdapter {

	public EsdTes0028ComboViewAdapter() {
		// TODO Auto-generated constructor stub
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
	
	/** XML 데이타로 만들기
	 *  @param HttpServletRequest request
	 *  @param HttpServletResponse response
	 *  @return String
	 */
    public String makeXML(HttpServletRequest request, HttpServletResponse response)
    {
        Event					event			= null;
        GeneralEventResponse	eventResponse	= null;
        Exception				serverException	= null;
    	DBRowSet				rowSet			= null;		//DB ResultSet

        StringBuilder			sbuXML			= new StringBuilder();
        String					strXML			= "";
        
//        String					cateString			= "";
//        String					tpString			= "";        

        StringBuffer			cateStringBuf		= new StringBuffer();
        StringBuffer			tpStringBuf		= new StringBuffer();        
    	boolean					isupload		= isUploadFile(request);
    	
    	try
        {
            serverException = (Exception)request.getAttribute("com.clt.framework.core.comm.EXCEPTION_OBJECT      ");

            if(serverException != null)
            {
                strXML = getErrorXML((new ErrorHandler(serverException)).loadPopupMessage(), isupload);
            } else
            {
            	
                event = (Event)request.getAttribute("Event");
                eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
                
                
				if (eventResponse != null) {
					List<DBRowSet>		rsList		= eventResponse.getRsList();
					
//					<SHEET>
//			    	<%
//	    	    	 if (rowSet_sc != null) {
//	   	    	        while (rowSet_sc.next()) {   	    	        	
//	   	    	        	cateString = JSPUtil.getNull(rowSet_sc.getString("lgs_cost_subj_cd"))+"--"+JSPUtil.getNull(rowSet_sc.getString("lgs_cost_subj_cd"))+"|"+cateString;
//	   	    	        }
//	    	    	 }
//	    	    	 if (rowSet_dc != null) {
//	 	    	        while (rowSet_dc.next()) { 	    	        	
//	 	    	        	tpString = JSPUtil.getNull(rowSet_dc.getString("lgs_cost_dtl_cd"))+"--"+JSPUtil.getNull(rowSet_dc.getString("lgs_cost_dtl_cd"))+"|"+tpString;
//	 	    	     }
//	 	    	 	}
//	%>
//	    	  <ETC-DATA>
//	    	    <ETC NAME="extp_cate_list"><%=cateString%></ETC>
//	    	    <ETC NAME="extp_tp_list"><%=tpString%></ETC>   
//	    	    <ETC NAME="cost_code_sc"><%=event.getLgs_cost_subj_cd()%></ETC> 
//	    	    <ETC NAME="cost_code_dc"><%=event.getLgs_cost_dtl_cd()%></ETC>     	   
//	    	  </ETC-DATA>
//	        	</SHEET> 					
					
					for ( int i = 0; i < rsList.size(); i++ ) {
						
						if( i==0 ) {
							rowSet	= (DBRowSet)rsList.get(i);
						
		   	    	        while (rowSet.next()) {   	    	        	
//		   	    	        	cateString = JSPUtil.getNull(rowSet.getString("lgs_cost_subj_cd"))+"--"+JSPUtil.getNull(rowSet.getString("lgs_cost_subj_cd"))+"|"+cateString;
		   	    	        	cateStringBuf.append(rowSet.getString("lgs_cost_subj_cd")).append("--").append(rowSet.getString("lgs_cost_subj_cd")).append("|");
		   	    	        }
						}						
						else if( i==1 ) {
							rowSet	= (DBRowSet)rsList.get(i);
						
		   	    	        while (rowSet.next()) {   	    	        	
//		   	    	        	tpString = JSPUtil.getNull(rowSet.getString("lgs_cost_dtl_cd"))+"--"+JSPUtil.getNull(rowSet.getString("lgs_cost_dtl_cd"))+"|"+tpString;
		   	    	        	tpStringBuf.append(rowSet.getString("lgs_cost_dtl_cd")).append("--").append(rowSet.getString("lgs_cost_dtl_cd")).append("|");
		   	    	        }
						}						

					}
					
										
					// Agreement Cost Code List 			
					sbuXML.append("<SHEET>\n");
					sbuXML.append("	<ETC-DATA>\n");
					sbuXML.append("		<ETC NAME='extp_cate_list'>")	.append(cateStringBuf.toString())	.append("</ETC>\n");
					sbuXML.append("		<ETC NAME='extp_tp_list'>")		.append(tpStringBuf.toString())	.append("</ETC>\n");
					sbuXML.append("		<ETC NAME='cost_code_sc'>")		.append(eventResponse.getETCData("cost_code_sc"))	.append("</ETC>\n");
					sbuXML.append("		<ETC NAME='cost_code_dc'>")		.append(eventResponse.getETCData("cost_code_dc"))	.append("</ETC>\n");
					sbuXML.append("	</ETC-DATA>\n");
					sbuXML.append("</SHEET>\n");					

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
     *  업로드 파일 
     * @param request 
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
