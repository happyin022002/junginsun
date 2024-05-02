/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : EsdTrs0105ViewAdapter.java
*@FileTitle : Default IBSheet Generation Class
*Open Issues :
*Change history :
*@LastModifyDate : 2008-10-01
*@LastModifier : Eunju Son
*@LastVersion : 1.0
* 2008-10-01 Eunju Son
* 1.0 최초 생성
* 2013.08.22 조인영 [] SQL 튜닝
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.expensesummary.event;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.common.util.TrsDefaultViewAdapter;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Eunju Son
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */

public class EsdTrs0105ViewAdapter extends TrsDefaultViewAdapter {

	protected String makeDataTag(List vos, String prefix, Event event)
    {
//		FormCommand	 formcommand	= event.getFormCommand();
        StringBuilder sbufXML = new StringBuilder();
        int totCnt = vos.size();
        int realCnt = vos.size();
        AbstractValueObject vo = (AbstractValueObject)vos.get(0);
        String realColNms[] = getColHeader(vo);
        String changedColNms[] = getChangedColNms(realColNms, prefix);
        if(vo.getMaxRows() > 0)
            totCnt = vo.getMaxRows();
        sbufXML.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' COLSEPARATOR='").append("\u261C\u261E").append("' TOTAL='").append(totCnt).append("'>\n").toString());
        for(int i = 0; i < realCnt; i++)
        {
            Map colValues = ((AbstractValueObject)vos.get(i)).getColumnValues();
            sbufXML.append("\t<TR><![CDATA[");
            int colCnt = realColNms.length;
            for(int j = 0; j < colCnt - 1; j++)
                sbufXML.append((new StringBuilder(String.valueOf(getNull((String)colValues.get(realColNms[j]))))).append("\u261C\u261E").toString());

            sbufXML.append((new StringBuilder(String.valueOf(getNull((String)colValues.get(realColNms[colCnt - 1]))))).append("]]></TR>\n").toString());
        }

        sbufXML.append("</DATA>\n");
        return sbufXML.toString();
    }
    
    protected String makeDataTag(DBRowSet rs, String prefix, Event event)
    {        
    	FormCommand	 formcommand	= event.getFormCommand();
        StringBuilder sb = new StringBuilder();
        String bColor = "255,255,255";	
        if(rs.isPivot())
        {
            sb.append(makePivotDataTag(rs));
            return sb.toString();
        }
        String realColNms[] = getColHeader(rs);
        try
        {
        	if( formcommand.isCommand(FormCommand.MULTI) ||
    				formcommand.isCommand(FormCommand.ADD) ||
    				formcommand.isCommand(FormCommand.REMOVE) ||
    				formcommand.isCommand(FormCommand.MODIFY) ){	//저장XML인 경우
    			
    			sb.append("<RESULT>");
    			sb.append("<TR-ALL>OK</TR-ALL>");
    			sb.append("</RESULT>");
        	}else if( formcommand.isCommand(FormCommand.SEARCH01) || formcommand.isCommand(FormCommand.SEARCH02) ) {		
    			String changedColNms[] = getChangedColNms(realColNms, prefix);
                sb.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' TOTAL='").append(getRowSetCnt(rs)).append("'>\n").toString());
                int colCount = realColNms.length;
                String sDiv = "";
                String sEdit = "";
                String sBold = "";
                while(rs.next())  {    
                	sDiv = rs.getString("DIV");	
	                if(sDiv.equals("22") || sDiv.equals("23")){
						    bColor="255,248,220";
						    sBold = "TRUE";
	                		sEdit = "FALSE";
	            	}else if(sDiv.equals("33")){
	    					bColor="255,246,143";
	    					sBold = "TRUE";
	                    	sEdit = "FALSE";		
					}else if(sDiv.equals("44")){
					  	bColor="247,225,236" ;
					  	sBold = "TRUE";
	            		sEdit = "FALSE";
					}else {
					  	bColor="255,255,255";
					  	sBold = "FALSE";
	            		sEdit = "TRUE";
					}
                	
                	
                    sb.append("\t<TR BGCOLOR='"+bColor+"'>");
                    
					
                    for(int j = 1; j < colCount+1; j++){
                    	
                    	if ( "chk".equals(changedColNms[j-1])){
	                    	sb.append("<TD EDIT='"+sEdit+"'><![CDATA[");
	                        sb.append((new StringBuilder()).append(getNull(rs.getObject(j))).toString());
	                        sb.append("]]></TD>");	
                    	}else{
							sb.append("<TD BOLD='"+sBold+"'><![CDATA[");
	                        sb.append((new StringBuilder()).append(getNull(rs.getObject(j))).toString());
	                        sb.append("]]></TD>");							
						}   
                    }                   
                    sb.append("</TR>\n");
                }
                sb.append("</DATA>\n");   

    		}else{
    			String changedColNms[] = getChangedColNms(realColNms, prefix);
                sb.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' COLSEPARATOR='").append("\u261C\u261E").append("' TOTAL='").append(getRowSetCnt(rs)).append("'>\n").toString());
                int colCount = realColNms.length;
                for(; rs.next(); sb.append((new StringBuilder()).append(getNull(rs.getObject(colCount))).append("]]></TR>\n").toString()))
                {
                    sb.append("\t<TR><![CDATA[");
                    for(int j = 1; j < colCount; j++)
                        sb.append((new StringBuilder()).append(getNull(rs.getObject(j))).append("\u261C\u261E").toString());
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

