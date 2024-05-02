/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : DefaultViewAdapter.java
*@FileTitle : Default IBSheet Generation Class
*Open Issues :
*Change history :
*@LastModifyDate : 2008-11-24
*@LastModifier : Lee SeungYol
*@LastVersion : 1.0
* 2008-11-24 Lee SeungYol
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceaudit.event;

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
 * @author Poong-Yeon Cho
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */

public class EsdTrs0038ViewAdapter extends TrsDefaultViewAdapter {

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
    		}else if( formcommand.isCommand(FormCommand.SEARCH) ){    			
    			String changedColNms[] = getChangedColNms(realColNms, prefix);
                sb.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' TOTAL='").append(getRowSetCnt(rs)).append("'>\n").toString());
                int colCount = realColNms.length;
                while(rs.next())
                {                	
                    sb.append("\t<TR>");
                    for(int j = 1; j < colCount+1; j++){
                    	if ( "fm_nod_cd2".equals(changedColNms[j-1]) || "to_nod_cd2".equals(changedColNms[j-1]) ){
                    		sb.append("<TD COMBO-TEXT='");
                    		sb.append((new StringBuilder()).append(getNull(rs.getObject(j))).toString());
                    		sb.append("' COMBO-CODE='");
                    		sb.append((new StringBuilder()).append(getNull(rs.getObject(j))).toString());
                    		sb.append("'><![CDATA[");
	                        sb.append((new StringBuilder()).append(getNull(rs.getObject(j))).toString());
	                        sb.append("]]></TD>");                    		
						}else{
							sb.append("<TD><![CDATA[");
	                        sb.append((new StringBuilder()).append(getNull(rs.getObject(j))).toString());
	                        sb.append("]]></TD>");							
						}                   	
                    }                   
                    sb.append("</TR>");
                }
                sb.append("</DATA>\n");                
    		}else if( formcommand.isCommand(FormCommand.SEARCH20) ){
    			String changedColNms[] = getChangedColNms(realColNms, prefix);
                sb.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' TOTAL='").append(getRowSetCnt(rs)).append("'>\n").toString());
                int colCount = realColNms.length;
                while(rs.next())
                {
                    sb.append("\t<TR ROW = '");
                    sb.append((new StringBuilder()).append(getNull(rs.getObject("seq"))).toString());
                    sb.append("'>");
                    for(int j = 1; j < colCount; j++){
                    	sb.append("<TD COL='eq_tpsz_cd'><![CDATA[");
                        sb.append((new StringBuilder()).append(getNull(rs.getObject("eq_tpsz_cd"))).toString());
                        sb.append("]]></TD>");                    	
                    }
                    sb.append("</TR>");
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

