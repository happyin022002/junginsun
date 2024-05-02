/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : EsdEas0373ViewAdapter.java
*@FileTitle : Default IBSheet Generation Class
*Open Issues :
*Change history :
*@LastModifyDate : 2015-06-09
*@LastModifier : Jong-Ock Kim
*@LastVersion : 1.2
* 2015-06-09 Jong-Ock Kim
* 1.0 최초 생성
*----------------------------------------------------------
* History
=========================================================*/
package com.hanjin.apps.alps.esd.eas.tesadvanceaudit.event;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.eas.common.util.EasDefaultViewAdapter;
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
 * @author Jong-Ock Kim
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */

public class EsdEas0373ViewAdapter extends EasDefaultViewAdapter {
 
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix, Event event)
	{
		FormCommand	 formcommand	= event.getFormCommand();
		StringBuilder sbufXML = new StringBuilder();
        int totCnt = vos.size();
        int realCnt = vos.size();
        AbstractValueObject vo = (AbstractValueObject)vos.get(0);
        String realColNms[] = getColHeader(vo);
        String changedColNms[] = getChangedColNms(realColNms, prefix);
        if(vo.getMaxRows() > 0)
            totCnt = vo.getMaxRows();

        if( formcommand.isCommand(FormCommand.SEARCHLIST01) ){
        	String colName = "";
        	sbufXML.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' TOTAL='").append(totCnt).append("'>\n").toString());
            for(int i = 0; i < realCnt; i++)
            {
                Map colValues = ((AbstractValueObject)vos.get(i)).getColumnValues();
                String sExceedAvgFlg = getNull(colValues.get("exceed_avg_flg")).toString();
                String sVolDiffFlg = getNull(colValues.get("vol_diff_flg")).toString();
                
                sbufXML.append("\t<TR>");

                int colCnt = realColNms.length; 
                for(int j = 0; j < colCnt; j++) {
                	colName =  (String)realColNms[j];
                	if (colName.equals("estm_amt")) {
                		sbufXML.append((new StringBuilder())
                				.append("<TD")
                				.append(sExceedAvgFlg.equals("Y")?" COLOR='255, 0, 0'":"")
                				.append(">")
                				.append(JSPUtil.getNull(getNull(colValues.get(realColNms[j])).toString()))
                				.append("</TD>").toString());
                	}else if (colName.equals("calc_vol_qty")) {
                		sbufXML.append((new StringBuilder())
                				.append("<TD")
                				.append(sVolDiffFlg.equals("Y")?" COLOR='255, 0, 0'":"")
                				.append(">")
                				.append(JSPUtil.getNull(getNull(colValues.get(realColNms[j])).toString()))
                				.append("</TD>").toString());
	            	}else if (colName.equals("rvis_vol_qty")) {
	            		sbufXML.append((new StringBuilder())
	            				.append("<TD")
	            				.append(sVolDiffFlg.equals("Y")?" COLOR='255, 0, 0'":"")
	            				.append(">")
	            				.append(JSPUtil.getNull(getNull(colValues.get(realColNms[j])).toString()))
	            				.append("</TD>").toString());
                	}else{
                		if (getNull(colValues.get(realColNms[j])).toString().length()>0) {
                			sbufXML.append("<TD><![CDATA[");
                			sbufXML.append(getNull(colValues.get(realColNms[j])).toString());
                			sbufXML.append("]]></TD>");
                		}else{
                			sbufXML.append((new StringBuilder()).append("<TD></TD>"));
                		}
                	}
                }
                sbufXML.append((new StringBuilder(String.valueOf(getNull((String)colValues.get(realColNms[colCnt - 1]))))).append("</TR>\n").toString());
            }
        }else{
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
            String changedColNms[] = getChangedColNms(realColNms, prefix);
            if( formcommand.isCommand(FormCommand.MULTI) ){
              	sb.append("<RESULT><TR-ALL> OK </TR-ALL></RESULT>");
            }else{
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
