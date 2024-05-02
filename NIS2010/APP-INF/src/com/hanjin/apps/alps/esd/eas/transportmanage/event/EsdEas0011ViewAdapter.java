/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdEas0011ViewAdapter.java
*@FileTitle : C/H Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2012-03-06
*@LastModifier : sungho park
*@LastVersion : 1.0
* 2012-03-06 sungho park
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

public class EsdEas0011ViewAdapter extends EasDefaultViewAdapter {

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
    		if( formcommand.isCommand(FormCommand.MULTI)){	//저장XML인 경우    			
    			sb.append("<RESULT>\n");
    			sb.append("<TR-ALL>OK</TR-ALL>\n");
    			sb.append("</RESULT>\n");    			
    		} else if( formcommand.isCommand(FormCommand.SEARCH11) ){
    			sb.append("<ETC-DATA>\n");
	 		 	String key = "";
				String value = ""; 
				if (rs != null) {
	    			while(rs.next()){
	 					key 	= "rfaChk";
						value 	= rs.getString("rfa_chk");
						sb.append("<ETC KEY='"+key+"'><![CDATA["+JSPUtil.getNull(value)+"]]></ETC>\n");
	    				
	    			}
				}
    			sb.append("</ETC-DATA>\n"); 
    			sb.append("<TR-ALL>OK</TR-ALL>\n");
    		} else if( formcommand.isCommand(FormCommand.SEARCH12) ){
    			sb.append("<ETC-DATA>\n");
	 		 	String key1 = "";
				String value1 = "";
	 		 	String key2 = "";
				String value2 = ""; 				
	 		 	String key3 = "";
				String value3 = ""; 								
				if (rs != null) {
	    			while(rs.next()){
	 					key1 	= "CURR_LIST_CTNT2";
						value1 	= rs.getString("CURR_LIST_CTNT2");
	 					key2 	= "PORT_INLND_CD2";
						value2 	= rs.getString("PORT_INLND_CD2");
	 					key3 	= "SCC_YD_CHK";
						value3 	= rs.getString("SCC_YD_CHK");												
						sb.append("<ETC KEY='"+key1+"'><![CDATA["+JSPUtil.getNull(value1)+"]]></ETC>\n");
						sb.append("<ETC KEY='"+key2+"'><![CDATA["+JSPUtil.getNull(value2)+"]]></ETC>\n");
						sb.append("<ETC KEY='"+key3+"'><![CDATA["+JSPUtil.getNull(value3)+"]]></ETC>\n");						
	    			}
				}
    			sb.append("</ETC-DATA>\n"); 
    			sb.append("<TR-ALL>OK</TR-ALL>\n");    			
//    		} else if( formcommand.isCommand(FormCommand.SEARCH03) ){
//    			sb.append("<ETC-DATA>\n");
//	 		 	String key = "";
//	 		 	String key1 = "";
//				String value = "";
//				String value1 = "";
//				if (rs != null) {
//	    			while(rs.next()){
//	 					key 	= "cntCd";
//	 					key1 	= "cntNm";
//						value 	= rs.getString("cnt_cd");
//						value1 	= rs.getString("cnt_nm");
//						sb.append("<ETC KEY='"+key+"'><![CDATA["+JSPUtil.getNull(value)+"]]></ETC>\n");
//						sb.append("<ETC KEY='"+key1+"'><![CDATA["+JSPUtil.getNull(value1)+"]]></ETC>\n");
//	    			}
//				}
//    			sb.append("</ETC-DATA>\n"); 
//    			sb.append("<TR-ALL>OK</TR-ALL>\n");
//  			
//    		}else if( formcommand.isCommand(FormCommand.SEARCH04) ){	//MDM내 입력된 Customer code의 존재 여부 확인.
//    			sb.append("<ETC-DATA>\n");
//	 		 	String key = "";
//				String value = "";
//				if (rs != null) {
//	    			while(rs.next()){
//	 					key 	= "sccYdChk";
//						value 	= rs.getString("scc_yd_chk");
//						sb.append("<ETC KEY='"+key+"'><![CDATA["+JSPUtil.getNull(value)+"]]></ETC>\n");
//	    			}
//				}
//    			sb.append("</ETC-DATA>\n"); 
//    			sb.append("<TR-ALL>OK</TR-ALL>\n");
//
//    		}else if( formcommand.isCommand(FormCommand.SEARCH05) ){	//MDM내 입력된 cntr tpsz code의 존재 여부 확인.
//    			sb.append("<ETC-DATA>\n");
//	 		 	String key = "";
//				String value = ""; 
//				if (rs != null) {
//	    			while(rs.next()){
//	 					key 	= "tpszCnt";
//						value 	= rs.getString("tpsz_cnt");    	
//						sb.append("<ETC KEY='"+key+"'><![CDATA["+JSPUtil.getNull(value)+"]]></ETC>\n");
//	    				
//	    			}
//				}
//    			sb.append("</ETC-DATA>\n"); 
//    			sb.append("<TR-ALL>OK</TR-ALL>\n");
//
//    			
//    		}else if( formcommand.isCommand(FormCommand.SEARCH06) ){	//MDM내 입력된 currency code의 존재 여부 확인.
//    			sb.append("<ETC-DATA>\n");
//	 		 	String key = "";
//				String value = ""; 
//				if (rs != null) {
//	    			while(rs.next()){
//	 					key 	= "currCnt";
//						value 	= rs.getString("curr_cnt");    	
//						sb.append("<ETC KEY='"+key+"'><![CDATA["+JSPUtil.getNull(value)+"]]></ETC>\n");
//	    				
//	    			}
//				}
//    			sb.append("</ETC-DATA>\n"); 
//    			sb.append("<TR-ALL>OK</TR-ALL>\n");
  			
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

