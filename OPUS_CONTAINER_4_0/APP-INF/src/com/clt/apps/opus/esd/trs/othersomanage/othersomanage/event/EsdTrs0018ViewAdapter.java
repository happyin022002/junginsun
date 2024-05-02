/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTrs0018ViewAdapter.java
*@FileTitle : Default IBSheet Generation Class
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-14
*@LastModifier : Jin Kim
*@LastVersion : 1.0
* 2009-09-14 Jin Kim
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.othersomanage.othersomanage.event;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.trs.common.util.TrsDefaultViewAdapter;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Jin Kim
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */

public class EsdTrs0018ViewAdapter extends TrsDefaultViewAdapter {
	
	public String rowNum = "";

	protected String makeDataTag(List vos, String prefix, Event event){
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
    
    protected String makeDataTag(DBRowSet rs, String prefix, Event event){        
    	FormCommand	 formcommand	= event.getFormCommand();

        StringBuilder sb = new StringBuilder();
        if(rs.isPivot()){
            sb.append(makePivotDataTag(rs));
            return sb.toString();
        }
        
        String realColNms[] = getColHeader(rs);
        try{
			if( 
				formcommand.isCommand(FormCommand.MULTI) || 
				formcommand.isCommand(FormCommand.MODIFY) || 
				formcommand.isCommand(FormCommand.REMOVE) || 
				formcommand.isCommand(FormCommand.REMOVELIST) ){	//저장XML인 경우

    			sb.append("<RESULT>");
    			sb.append("<TR-ALL>OK</TR-ALL>");
    			sb.append("</RESULT>");
    			
			}else if(
						formcommand.isCommand(FormCommand.ADD) ||
						formcommand.isCommand(FormCommand.SEARCH) || 
						formcommand.isCommand(FormCommand.SEARCH04) || 
						formcommand.isCommand(FormCommand.SEARCH05) || 
						formcommand.isCommand(FormCommand.SEARCH06) ||
						formcommand.isCommand(FormCommand.SEARCH07) ||
						formcommand.isCommand(FormCommand.SEARCH08) ||
						formcommand.isCommand(FormCommand.SEARCH09)) {	//조회XML인 경우

    			String changedColNms[] = getChangedColNms(realColNms, prefix);
                sb.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' COLSEPARATOR='").append("\u261C\u261E").append("' TOTAL='").append(getRowSetCnt(rs)).append("'>\n").toString());

				int colCount = realColNms.length;
				for(; rs.next(); sb.append((new StringBuilder()).append(getNull(rs.getObject(colCount))).append("]]></TR>\n").toString())){
					sb.append("\t<TR><![CDATA[");
					for(int j = 1; j < colCount; j++)
						sb.append((new StringBuilder()).append(getNull(rs.getObject(j))).append("\u261C\u261E").toString());
				}
				sb.append("</DATA>\n");
				
			}else if(	formcommand.isCommand(FormCommand.SEARCH10) ||
						formcommand.isCommand(FormCommand.SEARCH11) ||
						formcommand.isCommand(FormCommand.SEARCH12)) {	//조회XML인 경우

				sb.append("<DATA>\n");
				
				if( rs != null && rs.next() ){
					sb.append("<TR ROW = '"+getNull(rs.getString("s_row"))+"'> \n");
					sb.append("<TD COL='eq_no'><![CDATA["+getNull(rs.getString("eq_no"))+"]]></TD>");
					sb.append("<TD COL='eq_tpsz_cd'><![CDATA["+getNull(rs.getString("eq_tpsz_cd"))+"]]></TD>");
				}else{
					sb.append("<TR ROW = '"+rowNum+"'> \n");
					sb.append("<TD COL='eq_no'></TD>");
					sb.append("<TD COL='eq_tpsz_cd'></TD>");
				}
				sb.append("</TR>\n");
				sb.append("</DATA>\n");
		   }
        }catch(SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex.getMessage());
        }
        return sb.toString();
    }

    protected String getETCData(EventResponse eventResponse) { 
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
    	sb.append("<ETC KEY='" + key + "'><![CDATA[" + val + "]]></ETC>\n"); 
    	} 
    	} 
    	//Pivot 관련 ETC-DATA생성 
    	sb.append(getPivotETCData(eventResponse)); 
    	sb.append("</ETC-DATA>\n"); 

    	return sb.toString(); 
    	} 
}