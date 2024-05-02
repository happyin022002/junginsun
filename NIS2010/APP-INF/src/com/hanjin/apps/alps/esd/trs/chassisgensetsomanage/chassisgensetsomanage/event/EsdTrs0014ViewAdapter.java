/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdTrs0014ViewAdapter.java
*@FileTitle : Service Order 생성화면 - Chassis or Genset
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-04
*@LastModifier : poong
*@LastVersion : 1.0
* 2006-10-04 poong
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.chassisgensetsomanage.chassisgensetsomanage.event;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.hanjin.apps.alps.esd.trs.common.util.TrsDefaultViewAdapter;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Eun-Hee Choi
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */

public class EsdTrs0014ViewAdapter extends TrsDefaultViewAdapter {
	public String rowNum = "";
	
	protected String makeDataTag(List vos, String prefix, Event event)
    {
		return "";
    }
    
    protected String makeDataTag(DBRowSet rs, String prefix, Event event)
    {       	
    	FormCommand	 formcommand	= event.getFormCommand();
        StringBuilder sb = new StringBuilder();
        if(rs.isPivot())
        {
            sb.append(makePivotDataTag(rs));
            return sb.toString();
        }
        String realColNms[] = getColHeader(rs);
        try
        {	
        	if( formcommand.isCommand(FormCommand.MULTI) || 
        			formcommand.isCommand(FormCommand.MODIFY) || 
        			formcommand.isCommand(FormCommand.REMOVE) ||
        			formcommand.isCommand(FormCommand.REMOVE01) || 
        			formcommand.isCommand(FormCommand.REMOVELIST) ){	//저장XML인 경우
    			
    			sb.append("<RESULT>");
    			sb.append("<TR-ALL>OK</TR-ALL>");
    			sb.append("</RESULT>");
    		}else{	//조회XML인 경우
    			if( formcommand.isCommand(FormCommand.SEARCH01) || formcommand.isCommand(FormCommand.SEARCH02)) {
    				String xmlString = "";
    				String columnValue = "";
    				boolean isNext = false;
    				if (rs != null && rs.next()) isNext = true;
    				
    				sb.append("<DATA>\n");
    				sb.append("<TR ROW = '"+rowNum+"'> \n");
    				for (int j = 0 ; j < rs.getMetaData().getColumnCount() ; j++) {
    					xmlString = rs.getMetaData().getColumnName(j+1).toLowerCase();
    					if (isNext) columnValue = JSPUtil.getNull(rs.getString(xmlString));
    					sb.append("<TD COL='"+xmlString+"'>"+columnValue+"</TD>");
    				}
    				sb.append("</TR>\n");
    				sb.append("</DATA>\n");    				
    			}else{  			
        			String changedColNms[] = getChangedColNms(realColNms, prefix);
                    sb.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' TOTAL='").append(getRowSetCnt(rs)).append("'>\n").toString());
                    int colCount = realColNms.length;
                    while(rs.next()){    
                    	sb.append("\t<TR>");
                    	 for(int j = 1; j <= colCount; j++){
                         	sb.append("<TD><![CDATA[");
    						sb.append(getNull(rs.getObject(j)));
    						sb.append("]]></TD>");                          		 
                    	 }
                    	sb.append("</TR>\n");
                    }
                    sb.append("</DATA>\n"); 
    			}
        }
    }catch(SQLException ex)
        {
            throw new RuntimeException(ex.getMessage());
        }
        catch(Exception ex)
        {
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex.getMessage());
        }
        return sb.toString();
    }
    
	protected String getETCData(EventResponse eventResponse) { //for only rownum setting
    	if(eventResponse==null) 
        	return ""; 

        	StringBuilder sb = new StringBuilder(); 
        	HashMap<String, String> etc_data = (HashMap<String, String>) eventResponse.getETCData(); 

        	sb.append("<ETC-DATA>\n"); 
        	if(etc_data !=null && etc_data.size()>0){ 
        		Iterator it = etc_data.keySet().iterator(); 
	        	while(it.hasNext()){ 
	        	String key = (String)it.next(); 
	        	String val = "" + etc_data.get(key); 
					if(key.equals("ROW")){
						rowNum = val;
					}else{
						sb.append("<ETC KEY='" + key + "'><![CDATA[" + val + "]]></ETC>\n"); 
		        	} 
	        	} 
        	}
        	sb.append("</ETC-DATA>\n");
        	return sb.toString(); 
    } 		
    
}

