/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdEas0007ViewAdapter.java
*@FileTitle : C/H Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2007-11-29
*@LastModifier : yujin
*@LastVersion : 1.0
* 2007-11-29 yujin
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.event;

import java.sql.SQLException;
import java.util.List;

import com.hanjin.apps.alps.esd.eas.common.util.EasDefaultViewAdapter;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Eun-Hee Choi
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */

public class EsdEas0007ViewAdapter extends EasDefaultViewAdapter {

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
        	//String usr_id = event.getSignOnUserAccount().getUsr_id();
    		if( formcommand.isCommand(FormCommand.MULTI) || 
    				formcommand.isCommand(FormCommand.ADD) || 
    				formcommand.isCommand(FormCommand.MODIFY) || 
    				formcommand.isCommand(FormCommand.REMOVE) || 
    				formcommand.isCommand(FormCommand.REMOVELIST) ){	//저장XML인 경우
    			
    			sb.append("<RESULT>\n");
    			sb.append("<TR-ALL>OK</TR-ALL>\n");
    			sb.append("</RESULT>\n");
    		} else if( formcommand.isCommand(FormCommand.SEARCH11) ){
    			sb.append("<EffectDate>\n");
    			if (rs != null) {
	    			while(rs.next()){
	    				sb.append("<EffDate>\n");
	    				sb.append("<sub-sortKey>"+rs.getObject("sortKey")+"</sub-sortKey>");
	    				sb.append("<sub-code>"+rs.getObject("code")+"</sub-code>");
						sb.append("<sub-name>"+rs.getObject("name")+"</sub-name>");
	    				sb.append("</EffDate>\n");
	    			}
    			}
    			sb.append("<row-count>"+rs.getRowCount()+"</row-count>\n");
    			sb.append("</EffectDate>\n");
    		} else if( formcommand.isCommand(FormCommand.SEARCH01) ){
    			sb.append("<EUROFFCD>\n");
    			if (rs != null) {
	    			while(rs.next()){
	    				sb.append("<sub-sortKey>"+rs.getString("OFC_CD")+"</sub-sortKey>\n");
	    			}   
    			}
    			sb.append("<row-count>"+rs.getRowCount()+"</row-count>\n");
    			sb.append("</EUROFFCD>\n");    			
    		}else if( formcommand.isCommand(FormCommand.SEARCH02) ){ //중복 데이터 입력 체크.
    			sb.append("<ETC-DATA>\n");
	 		 	String key = "";
				String value = "";  
				if (rs != null) {
	    			while(rs.next()){
	 					key 	= "dupCnt";
						value 	= rs.getString("dup_cnt");    	
						sb.append("<ETC KEY='"+key+"'><![CDATA["+JSPUtil.getNull(value)+"]]></ETC>\n");
	    			}  
				}
    			sb.append("</ETC-DATA>\n"); 
    			sb.append("<TR-ALL>OK</TR-ALL>\n");

    		}else if( formcommand.isCommand(FormCommand.SEARCH03) ){	//MDM내 입력된 Location code의 존재 여부 확인.
    			sb.append("<ETC-DATA>\n");
	 		 	String key = "";
				String value = ""; 
				if (rs != null) {
	    			while(rs.next()){
	 					key 	= "locCnt";
						value 	= rs.getString("loc_cnt");    	
						sb.append("<ETC KEY='"+key+"'><![CDATA["+JSPUtil.getNull(value)+"]]></ETC>\n");
	    				
	    			}
				}
    			sb.append("</ETC-DATA>\n"); 
    			sb.append("<TR-ALL>OK</TR-ALL>\n");
  			
    		}else if( formcommand.isCommand(FormCommand.SEARCH04) ){	//MDM내 입력된 Customer code의 존재 여부 확인.
    			sb.append("<ETC-DATA>\n");
	 		 	String key = "";
	 			String key1 = "";
				String value = "";
				String value1 = "";
				if (rs != null) {
	    			while(rs.next()){
	 					key 	= "custCnt";
	 					key1 	= "custInfo";
						value 	= rs.getString("cust_cnt");
						value1 	= rs.getString("cust_info");	
						sb.append("<ETC KEY='"+key+"'><![CDATA["+JSPUtil.getNull(value)+"]]></ETC>\n");
						sb.append("<ETC KEY='"+key1+"'><![CDATA["+JSPUtil.getNull(value1)+"]]></ETC>\n");
	    			}
				}
    			sb.append("</ETC-DATA>\n"); 
    			sb.append("<TR-ALL>OK</TR-ALL>\n");

    		}else if( formcommand.isCommand(FormCommand.SEARCH05) ){	//MDM내 입력된 cntr tpsz code의 존재 여부 확인.
    			sb.append("<ETC-DATA>\n");
	 		 	String key = "";
				String value = ""; 
				if (rs != null) {
	    			while(rs.next()){
	 					key 	= "tpszCnt";
						value 	= rs.getString("tpsz_cnt");    	
						sb.append("<ETC KEY='"+key+"'><![CDATA["+JSPUtil.getNull(value)+"]]></ETC>\n");
	    				
	    			}
				}
    			sb.append("</ETC-DATA>\n"); 
    			sb.append("<TR-ALL>OK</TR-ALL>\n");

    			
    		}else if( formcommand.isCommand(FormCommand.SEARCH06) ){	//MDM내 입력된 currency code의 존재 여부 확인.
    			sb.append("<ETC-DATA>\n");
	 		 	String key = "";
				String value = ""; 
				if (rs != null) {
	    			while(rs.next()){
	 					key 	= "currCnt";
						value 	= rs.getString("curr_cnt");    	
						sb.append("<ETC KEY='"+key+"'><![CDATA["+JSPUtil.getNull(value)+"]]></ETC>\n");
	    				
	    			}
				}
    			sb.append("</ETC-DATA>\n"); 
    			sb.append("<TR-ALL>OK</TR-ALL>\n");
  			
    		}else {	//조회XML인 경우
    			String changedColNms[] = getChangedColNms(realColNms, prefix);
                sb.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' TOTAL='").append(getRowSetCnt(rs)).append("'>\n").toString());
                int colCount = realColNms.length;
                while(rs.next()){
                	 sb.append("<TR>\n");
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
        catch(SQLException ex)
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
}

