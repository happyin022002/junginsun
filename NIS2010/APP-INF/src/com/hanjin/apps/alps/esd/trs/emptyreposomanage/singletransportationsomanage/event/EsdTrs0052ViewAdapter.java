/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName       : EsdTrs0012ViewAdapter.java
*@FileTitle      : EsdTrs0012ViewAdapter IBSheet Generation Class
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009-09-23
*@LastModifier   : CHOICE
*@LastVersion    : 1.0
* 2009-09-23 CHOICE
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.event;

import java.sql.SQLException;
import java.util.List;

import com.hanjin.apps.alps.esd.trs.common.util.TrsDefaultViewAdapter;
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

public class EsdTrs0052ViewAdapter extends TrsDefaultViewAdapter {

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
        	String usr_id = event.getSignOnUserAccount().getUsr_id();
    		if( formcommand.isCommand(FormCommand.MODIFY) || 
    			formcommand.isCommand(FormCommand.MODIFY01) ||
     			formcommand.isCommand(FormCommand.REMOVE)){	//저장XML인 경우
    			
    			sb.append("<RESULT>");
    			sb.append("<TR-ALL>OK</TR-ALL>");
    			sb.append("</RESULT>");
    		}else {	//조회XML인 경우
    			String colName = "" ;
    			boolean bCmb_seq = false;
    			boolean isEqno = false;
    			
    			String changedColNms[] = getChangedColNms(realColNms, prefix);
                sb.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' TOTAL='").append(getRowSetCnt(rs)).append("'>\n").toString());
                int colCount = realColNms.length;
                while(rs.next()){
					bCmb_seq = false;
					isEqno= false;

					if( formcommand.isCommand(FormCommand.SEARCH03) ) {
						if( JSPUtil.getNull(rs.getString("TRSP_SO_CMB_SEQ")).length() > 0 ) {
						bCmb_seq = true;
						}
					}

					if(  JSPUtil.getNull(rs.getString("EQ_NO")).length() > 0 ) {
					isEqno= true;
					}
                	sb.append("\t<TR>");

                    for(int j = 1; j <= colCount; j++){
                    	colName = rs.getMetaData().getColumnName(j);
                    	
                    	if( colName.equals("UPD_USR_ID") ) {
                    		sb.append("<TD>").append(usr_id).append("</TD>");                    		
                    	}else if( colName.equals("INTER_RMK") ||  colName.equals("SPCL_INSTR_RMK")) {
                    		sb.append("<TD");
							if(bCmb_seq == false){
								sb.append(" EDIT=''>");
							}else{
								sb.append(" EDIT='FALSE'>");
							} 
							sb.append("<![CDATA[");
							sb.append(getNull(rs.getObject(j)) + "]]></TD>");							
                    	} else if( colName.equals("EQ_NO") ) {
                    		sb.append("<TD");
							if(isEqno == false){
								sb.append(" EDIT=''>");
							}else{
								sb.append(" EDIT='FALSE'>");
							} 
							sb.append("<![CDATA[");
							sb.append(getNull(rs.getObject(j)) + "]]></TD>");	                    		
                    	}else{
                        	sb.append("<TD><![CDATA[");
    						sb.append(getNull(rs.getObject(j)));
    						sb.append("]]></TD>");                    		
                    	}
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

