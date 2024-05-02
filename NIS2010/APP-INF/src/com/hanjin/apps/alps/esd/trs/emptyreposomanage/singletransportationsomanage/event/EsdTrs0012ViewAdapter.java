/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName       : EsdTrs0012ViewAdapter.java
*@FileTitle      : EsdTrs0012ViewAdapter IBSheet Generation Class
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009-10-01
*@LastModifier   : Eunju Son
*@LastVersion    : 1.0
* 2009-10-01 Eunju Son
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.event;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.common.util.TrsDefaultViewAdapter;
import com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.vo.TrspSoSeqVO;
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

public class EsdTrs0012ViewAdapter extends TrsDefaultViewAdapter {

	protected String makeDataTag(List vos, String prefix, Event event)
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
        
        if( formcommand.isCommand(FormCommand.MULTI) ){
        	sbufXML.append((new StringBuilder("<DATA TOTAL='")).append(totCnt).append("'>\n").toString());
	        for(int i = 0; i < realCnt; i++){
	        	String chk_flg = "N";
				if(((TrspSoSeqVO)vos.get(i)).getSpotBidFlg().equals("Y")){
					chk_flg ="Y";
				}else{
					chk_flg = "N";
				}
	        	
	        	//Map colValues = ((TrspSoSeqVO)vos.get(i)).getColumnValues();
			    sbufXML.append("\t<TR>");
	            sbufXML.append("\n<TD>" + chk_flg + "</TD>");
	            sbufXML.append("\n<TD>" + ((TrspSoSeqVO)vos.get(i)).getTrspSoOfcCtyCd() + "</TD>");
	            sbufXML.append("\n<TD>" + ((TrspSoSeqVO)vos.get(i)).getTrspSoSeq() + "</TD>");
	            sbufXML.append("\n<TD>" + ((TrspSoSeqVO)vos.get(i)).getSpotBidFlg() + "</TD>");
	            sbufXML.append("\n<TD>" + ((TrspSoSeqVO)vos.get(i)).getSpotBidDueDt() + "</TD>");
	            sbufXML.append("\n<TD>" + ((TrspSoSeqVO)vos.get(i)).getSpotBidDueDtHms() + "</TD>");
	            sbufXML.append("\n<TD>" + ((TrspSoSeqVO)vos.get(i)).getTrspCrrModCd() + "</TD>");
	            sbufXML.append("\n<TD>" + ((TrspSoSeqVO)vos.get(i)).getFmNodCd() + "</TD>");
	            sbufXML.append("\n<TD>" + ((TrspSoSeqVO)vos.get(i)).getViaNodCd() + "</TD>");
	            sbufXML.append("\n<TD>" + ((TrspSoSeqVO)vos.get(i)).getDorNodCd() + "</TD>");
	            sbufXML.append("\n<TD>" + ((TrspSoSeqVO)vos.get(i)).getToNodCd() + "</TD>");
	            sbufXML.append("</TR>\n");
	        }
	
	        sbufXML.append("</DATA>\n");
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
	
	        sbufXML.append("</DATA>\n");
        }
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
    		if( formcommand.isCommand(FormCommand.MULTI)  || 
				formcommand.isCommand(FormCommand.ADD)    || 
				formcommand.isCommand(FormCommand.MODIFY) || 
				formcommand.isCommand(FormCommand.REMOVE) || 
				formcommand.isCommand(FormCommand.REMOVELIST) ){	//저장XML인 경우
    			
    			sb.append("<RESULT>");
    			sb.append("<TR-ALL>OK</TR-ALL>");
    			sb.append("</RESULT>");
    			
    		}else if(formcommand.isCommand(FormCommand.SEARCH02)) {	//조회XML인 경우
                sb.append((new StringBuilder("<DATA TOTAL='").append(getRowSetCnt(rs)).append("'>\n").toString()));
                int i =1;
                
                if( rs != null ){
                	
                    while(rs.next()){
                    	
                    	sb.append("\t<TR>");
                    	
                        for(int j = 0; j < rs.getMetaData().getColumnCount(); j++){

                        	sb.append("<TD><![CDATA[");
    						sb.append(getNull(rs.getObject(i++)));
    						sb.append("]]></TD>");
                        }//for end
                        i = 1;
                        sb.append("</TR>\n");
                    }//while end
                }//if end
                sb.append("</DATA>\n");    
    		} else {
    			String colName = "";
    			String changedColNms[] = getChangedColNms(realColNms, prefix);
                sb.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("\u261C\u261E").append("' TOTAL='").append(getRowSetCnt(rs)).append("'>\n").toString());
                
 //               int i =1;
                
                if( rs != null ){
                	
                    while(rs.next()){
                    	
                    	sb.append("\t<TR>");
                    	
                        for(int j = 1; j < rs.getMetaData().getColumnCount()+1; j++){
                        	colName = rs.getMetaData().getColumnName(j);
	            			if (colName.equals("FM_NOD_CD") || colName.equals("TO_NOD_CD")) {
	            				sb.append((new StringBuilder())
	            						.append("<TD")
	            						.append(" COMBO-TEXT='").append(JSPUtil.getNull(rs.getObject(j))).append("'")
	            						.append(" COMBO-CODE='").append(JSPUtil.getNull(rs.getObject(j))).append("'")
	            						.append(">")
	            						.append(JSPUtil.getNull(rs.getObject(j)))
	            						.append("</TD>").toString());
	            			}else{
	                        	sb.append("<TD><![CDATA[");
	    						sb.append(getNull(rs.getObject(j)));
	    						sb.append("]]></TD>");
	            			}
                        }//for end
 //                       i = 1;
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

