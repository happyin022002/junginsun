/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsdTrs0223ViewAdapter.java
*@FileTitle : Agreement Rail Surcharge
*Open Issues :
*Change history :
*@LastModifyDate : 2010-06-09
*@LastModifier : pjy
*@LastVersion : 1.0
* 2010-06-09 pjy
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event;

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
 * @author Yeonsil-Kim
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */

public class EsdTrs0223ViewAdapter extends TrsDefaultViewAdapter {
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
        String resultStr = null;
        String resultRow = null;
        String resultStr2 = null;
//        String resultStr3 = null;
        
        if(rs.isPivot())
        {
            sb.append(makePivotDataTag(rs));
            return sb.toString();
        }
        String realColNms[] = getColHeader(rs);
        try
        {
        	if( formcommand.isCommand(FormCommand.SEARCH03)
            		|| formcommand.isCommand(FormCommand.SEARCH04)
            		|| formcommand.isCommand(FormCommand.SEARCH06)
            		) {
            	int intResultRow = 0;
            	String errBgColor = "BGCOLOR=\"181,201,253\"";
            	String norBgColor = "BGCOLOR=\"0,0,0\"";
            	String bgColor = null;
//            	String changedColNms[] = getChangedColNms(realColNms, prefix);
            	sb.append("<DATA>\n");
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
                	}else{
                		bgColor = norBgColor;
                		resultStr = "OK";
                		ckVfStr = "0";
                	}
                	
                	if(resultStr2 != null && !resultStr2.equals("")){
                		bgColor = errBgColor;
                	}
                	
                	sb.append("<TR ROW='" + (intResultRow+1) + "'>");
                	sb.append("<TD COL='rlt' "+bgColor+"><![CDATA[" + resultStr + "]]></TD>");
                	
                	if( resultStr2 != null && !resultStr2.equals("") ){
                		sb.append("<TD COL='rlt2' "+bgColor+"><![CDATA[Dup!]]></TD>");
                		sb.append("<TD COL='trsp_agmt_scg_seq'>" + resultStr2 + "</TD>");
                	}else{
                		sb.append("<TD COL='rlt2' "+bgColor+"></TD>");
                	}
                	
                	sb.append("<TD COL='ck_vf'>" + ckVfStr + "</TD>");                	
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
}

