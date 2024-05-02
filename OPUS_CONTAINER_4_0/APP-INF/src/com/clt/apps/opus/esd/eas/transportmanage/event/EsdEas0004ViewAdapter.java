/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdEas0004ViewAdapter.java
*@FileTitle : Default IBSheet Generation Class
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-16
*@LastModifier : Choice
*@LastVersion : 1.0
* 2009-10-16 Choice
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.eas.transportmanage.event;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.eas.common.util.EasDefaultViewAdapter;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Jin-O Choi
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EsdEas0004ViewAdapter extends EasDefaultViewAdapter {
	protected String makeDataTag(List vos, String prefix, Event event)
    {
		//FormCommand	 formcommand	= event.getFormCommand();
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
    
    protected String makeDataTag(DBRowSet rowSet, String prefix, Event event)
    {        
    	FormCommand	 formcommand	= event.getFormCommand();
        StringBuilder sb = new StringBuilder();
        if(rowSet.isPivot())
        {
            sb.append(makePivotDataTag(rowSet));
            return sb.toString();
        }
        try
        {
        	if( formcommand.isCommand(FormCommand.SEARCH11) ){	//Sub-Office 조회 XML인 경우
    			
        		String sofc_cd = "";
        		int n = 0;
        		sb.append("<OFFICE>");
        		if( rowSet != null ) {
        			while( rowSet.next() ) {
        				sofc_cd = JSPUtil.getNull(rowSet.getString("OFC_CD"));
        				sb.append("<sub-office>").append(sofc_cd).append("</sub-office>");
        				n++;
        			}
        		}
        		sb.append("<row-count>").append(getNull(rowSet.getRowCount())).append("</row-count>");
        		
        		sb.append("</OFFICE>");
    			
    		}else {	//조회XML인 경우
                sb.append((new StringBuilder("<DATA TOTAL='")).append(getRowSetCnt(rowSet)).append("'>\n").toString());
                
                int i =1;
                int seq = 1;
                if( rowSet != null ){
                	
                    while(rowSet.next()){
                    	
                    	sb.append("<TR>");
                    	sb.append("<TD><![CDATA[").append(seq).append("]]></TD>");
                    	
                        for(int j = 0; j < rowSet.getMetaData().getColumnCount(); j++){
                        	sb.append("<TD><![CDATA[").append(getNull(rowSet.getObject(i++)) + "]]></TD>");
                        }//for end
                        i = 1;
                        seq++;
                        sb.append("</TR>\n");
                    }//while end
                }//if end
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
