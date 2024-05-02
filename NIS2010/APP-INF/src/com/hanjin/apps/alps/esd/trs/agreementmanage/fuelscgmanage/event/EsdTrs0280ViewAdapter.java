/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsdTrs0280ViewAdapter.java
*@FileTitle : Agreement rate IBSheet Generation Class
*Open Issues :
*Change history :
*@LastModifyDate : 2015-04-30
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2015-04-30 SHIN DONG IL
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.fuelscgmanage.event;

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
 * @author Yeonsil-Kim
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */

public class EsdTrs0280ViewAdapter extends TrsDefaultViewAdapter {
	protected String makeDataTag(List vos, String prefix, Event event)
    {
		FormCommand	 formcommand	= event.getFormCommand();
		StringBuilder sbufXML = new StringBuilder();

		if( formcommand.isCommand(FormCommand.MULTI))  {
			sbufXML.append("<RESULT>");
			sbufXML.append("  <TR-ALL>OK</TR-ALL> ");
			sbufXML.append("</RESULT>");		
		}
        return sbufXML.toString();
    }
    
	protected String makeDataTag(DBRowSet rs, String prefix, Event event)
    {
		FormCommand	 formcommand	= event.getFormCommand();
        StringBuilder sbufXML = new StringBuilder();
        String resultStr = null;
        String resultRow = null;
        String resultStr2 = null;
        String headerRow = ((EsdTrs0280Event) event).getHeaderRow();
        if(rs.isPivot())
        {
        	sbufXML.append(makePivotDataTag(rs));
            return sbufXML.toString();
        }
        String realColNms[] = getColHeader(rs);
        try
        {
            if(  formcommand.isCommand(FormCommand.SEARCH02)
            		) {
            	int intHeaderRow = Integer.parseInt(headerRow);
            	int intResultRow = 0;
            	String errBgColor = "BGCOLOR=\"181,201,253\"";
            	String norBgColor = "BGCOLOR=\"0,0,0\"";
            	String bgColor = null;
//            	String changedColNms[] = getChangedColNms(realColNms, prefix);
            	sbufXML.append("<DATA>\n");
            	int errCount = 0;
            	String ckVfStr = null;
            	for(int k=0;rs.next();k++)
                {
                	resultStr  = rs.getString("RMK");
                	resultStr2 = rs.getString("RMK2");
                	resultRow = rs.getString("SR");
                	intResultRow = Integer.parseInt(resultRow);
                	if (resultStr != null && !resultStr.equals("")){
                		bgColor = errBgColor;
                		ckVfStr = "1";
                		errCount ++;
                	}else{
                		bgColor = norBgColor;
                		ckVfStr = "0";
                		resultStr = "OK";
                	}
                	sbufXML.append("<TR ROW='" + (intResultRow+intHeaderRow) + "'>");
                	sbufXML.append("<TD COL='chk'>0</TD>");
                	sbufXML.append("<TD COL='rlt' "+bgColor+"><![CDATA[" + resultStr + "]]></TD>");
                	sbufXML.append("<TD COL='rlt2' "+bgColor+"><![CDATA[" + resultStr2 + "]]></TD>");
                	sbufXML.append("<TD COL='ck_vf'>0</TD>");
                	sbufXML.append("</TR>\n");
                }

                sbufXML.append("</DATA>\n");
                sbufXML.append("<ETC-DATA>\n");
                sbufXML.append("<ETC KEY='err_cnt2'>"+errCount+"</ETC>\n");
                sbufXML.append("</ETC-DATA>\n");
			}else if( formcommand.isCommand(FormCommand.SEARCH07)){
				String  sofc_cd   = "";
            	int   n           = 0;
            	sbufXML.append("\t<OFFICE>");
            	if( rs != null ) {
            		while( rs.next() ) {
            			sofc_cd = JSPUtil.getNull(rs.getString("OFC_CD"));
            			sbufXML.append("<sub-office>");
            			sbufXML.append(sofc_cd);
            			sbufXML.append("</sub-office>");
            			n++;
            		}
            	}
            	sbufXML.append("<row-count>");
            	sbufXML.append(String.valueOf(n));
            	sbufXML.append("</row-count>");
            	sbufXML.append("\n</OFFICE>");
			}else{
				String changedColNms[] = getChangedColNms(realColNms, prefix);
	            sbufXML.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' COLSEPARATOR='").append("\u261C\u261E").append("' TOTAL='").append(getRowSetCnt(rs)).append("'>\n").toString());
	            int colCount = realColNms.length;
	            for(; rs.next(); sbufXML.append((new StringBuilder()).append(getNull(rs.getObject(colCount))).append("]]></TR>\n").toString()))
	            {
	                sbufXML.append("\t<TR><![CDATA[");
	                for(int j = 1; j < colCount; j++)
	                    sbufXML.append((new StringBuilder()).append(getNull(rs.getObject(j))).append("\u261C\u261E").toString());
	
	            }
	
	            sbufXML.append("</DATA>\n");
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
        return sbufXML.toString();
    }
}

