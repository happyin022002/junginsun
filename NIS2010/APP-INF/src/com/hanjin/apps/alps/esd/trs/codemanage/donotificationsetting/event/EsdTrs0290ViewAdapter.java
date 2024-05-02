/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : DefaultViewAdapter.java
*@FileTitle : Default IBSheet Generation Class
*Open Issues :
*Change history :
*@LastModifyDate : 2016-05-30
*@LastModifier : geun hwan park
*@LastVersion : 1.0
* 2016-05-30 geun hwan park
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.donotificationsetting.event;

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

public class EsdTrs0290ViewAdapter extends TrsDefaultViewAdapter {
 
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix, Event event)
	{
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
            String changedColNms[] = getChangedColNms(realColNms, prefix);
            if( formcommand.isCommand(FormCommand.MULTI) ){
              	sb.append("<RESULT><TR-ALL> OK </TR-ALL></RESULT>");
            }else if( formcommand.isCommand(FormCommand.SEARCH01) ){
            	sb.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' TOTAL='").append(getRowSetCnt(rs)).append("'>\n").toString());
            	int colCount = realColNms.length;
            	String colName = "";
                boolean editableYn  = false;
                /*boolean ratioEditableYn = false;
                boolean fuelEditableYn = true;*/

                for(; rs.next(); )
            	{
                	String do_ntfc_set_seq = JSPUtil.getNull(rs.getString("DO_NTFC_SET_SEQ"));
                	
                    //status 가 Request saved이거나 Reject상태만 수정 가능해야 한다.
                    if(do_ntfc_set_seq.equals("") ) {
                    	editableYn = true;
                    } else {
                    	editableYn = false;
                    }
                    
                    sb.append("\n<TR>");
                    
            		for(int j = 1; j < colCount+1; j++) {
            			colName = rs.getMetaData().getColumnName(j);
            			
            			if (colName.equals("CTRT_TP_CD") ||
            				colName.equals("SC_NO") || 
        					colName.equals("CTRT_CUST_CD") ||
        					colName.equals("CTRT_EFF_DT") ||
        					colName.equals("CTRT_EXP_DT") ||
        					colName.equals("DEST_NOD_CD") ||
        					colName.equals("DEST_NOD_YD") ||
        					colName.equals("UPD_DT") ||
        					colName.equals("DO_NTFC_SET_SEQ") ||
        					colName.equals("CTRT_CUST_CNT_CD")||
        					colName.equals("CTRT_CUST_SEQ")) {
            				sb.append((new StringBuilder())
            						.append("<TD")
            						.append(editableYn?"":" EDIT='FALSE'")
            						.append(">")
            						.append(JSPUtil.getNull(rs.getObject(j)))
            						.append("</TD>").toString());

            			} else if(colName.equals("CTRT_CUST_NM")||
            					colName.equals("DEST_NOD_NM")||
            					colName.equals("UPD_USR_NM")||
            					colName.equals("DEST_NOD_NM")||
            					colName.equals("CTRT_CUST_NM")){
            				sb.append((new StringBuilder())
            						.append("<TD")
            						.append(editableYn?"":" EDIT='FALSE'")
            						.append("><![CDATA[")
            						.append(JSPUtil.getNull(rs.getObject(j)))
            						.append("]]></TD>").toString());
            			} else if(colName != null && !colName.equals("")) {
            				sb.append("<TD><![CDATA[");
            				sb.append(getNull(rs.getObject(j)));
            				sb.append("]]></TD>");
            			} else {
            				if (getNull(rs.getObject(j)).toString().length()>0) {
            					sb.append("<TD><![CDATA[");
            					sb.append(getNull(rs.getObject(j)));
            					sb.append("]]></TD>");
            				}else{
            					sb.append((new StringBuilder()).append("<TD></TD>"));
            				}
            			}
            		}
            		sb.append("</TR>");
            	}

                sb.append("\n</DATA>\n");

//              log.debug("##################### DBRowSet sb.toString() [\n" + sb.toString() + "\n]");
                return sb.toString();
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
