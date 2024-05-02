/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName       : EsdTrs0920ViewAdapter.java
*@FileTitle      : EsdTrs0920ViewAdapter IBSheet Generation Class
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009-09-29
*@LastModifier   : CHOICE
*@LastVersion    : 1.0
* 2009-09-23 CHOICE
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.cydoorsomanage.combinedtransportationcasetwosomanage.event;

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

public class EsdTrs0920ViewAdapter extends TrsDefaultViewAdapter {

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
        	String ofc_cd = event.getSignOnUserAccount().getOfc_cd();
        	if( formcommand.isCommand(FormCommand.MULTI) || 
        			formcommand.isCommand(FormCommand.ADD) || 
        			formcommand.isCommand(FormCommand.MODIFY) || 
        			formcommand.isCommand(FormCommand.REMOVE) || 
        			formcommand.isCommand(FormCommand.REMOVELIST) ){	//저장XML인 경우
    			
    			sb.append("<RESULT>");
    			sb.append("<TR-ALL>OK</TR-ALL>");
    			sb.append("</RESULT>");
    		}else {	//조회XML인 경우
    			String colName = "" ;
    			String changedColNms[] = getChangedColNms(realColNms, prefix);
                sb.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("referencenumber' TOTAL='").append(getRowSetCnt(rs)).append("'>\n").toString());
                int colCount = realColNms.length;
                int i =1;
                while(rs.next()){
					
                	sb.append("\t<TR>");

                    for(int j = 1; j <= colCount; j++){
                    	colName = rs.getMetaData().getColumnName(j);
                    	
                    	if( colName.equals("FM_NOD_CD") || colName.equals("VIA_NOD_CD") || colName.equals("TO_NOD_CD") || colName.equals("DOR_NOD_CD") ) {
                    		sb.append("<TD>").append(getNull(rs.getObject(i++))).append("</TD>");   
                    	}else if( colName.equals("FM_NOD_YARD") ||  colName.equals("VIA_NOD_YARD") || colName.equals("TO_NOD_YARD") || colName.equals("DOR_NOD_YARD")) {
                    		sb.append("<TD");
							sb.append(" COMBO-TEXT='");
							sb.append(getNull(rs.getObject(i)));
							sb.append("' COMBO-CODE='");
							sb.append(getNull(rs.getObject(i)));
							sb.append("'>");
							sb.append(getNull(rs.getObject(i++)));
							sb.append("</TD>");		
														
                    	} else if( colName.equals("TRSP_SO_OFC_CTY_CD") ) {
                    		i++;
                    		sb.append("<TD>").append(ofc_cd).append("</TD>");
                    	} else if( colName.equals("CRE_USR_ID") || colName.equals("UPD_USR_ID") ) {
                    		i++;
                    		sb.append("<TD>").append(usr_id).append("</TD>");
                    		
//
                    	} else if (colName.equals("FM_NOD_CD2")) {
                    		i++;
                    		sb.append((new StringBuilder())
                    				.append("<TD>")
                    				.append(getNull(rs.getObject("FM_NOD_CD")))
                    				.append("</TD>").toString());
                    	} else if (colName.equals("VIA_NOD_CD2")) {
                    		i++;
                    		sb.append((new StringBuilder())
                    				.append("<TD>")
                    				.append(getNull(rs.getObject("VIA_NOD_CD")))
                    				.append("</TD>").toString());
                    	} else if (colName.equals("TO_NOD_CD2")) {
                    		i++;
                    		sb.append((new StringBuilder())
                    				.append("<TD>")
                    				.append(getNull(rs.getObject("TO_NOD_CD")))
                    				.append("</TD>").toString());
                    	} else if (colName.equals("DOR_NOD_CD2")) {
                    		i++;
                    		sb.append((new StringBuilder())
                    				.append("<TD>")
                    				.append(getNull(rs.getObject("DOR_NOD_CD")))
                    				.append("</TD>").toString());
            			}else if (colName.equals("FM_NOD_YARD2")) {
            				i++;
            				sb.append((new StringBuilder())
            						.append("<TD>")
            						.append(JSPUtil.getNull(rs.getObject("FM_NOD_YARD")))
            						.append("</TD>").toString());
            			}else if (colName.equals("VIA_NOD_YARD2")) {
            				i++;
            				sb.append((new StringBuilder())
            						.append("<TD>")
            						.append(JSPUtil.getNull(rs.getObject("VIA_NOD_YARD")))
            						.append("</TD>").toString());
            			}else if (colName.equals("TO_NOD_YARD2")) {
            				i++;
            				sb.append((new StringBuilder())
            						.append("<TD>")
            						.append(JSPUtil.getNull(rs.getObject("TO_NOD_YARD")))
            						.append("</TD>").toString());
            			}else if (colName.equals("DOR_NOD_YARD2")) {
            				i++;
            				sb.append((new StringBuilder())
            						.append("<TD>")
            						.append(JSPUtil.getNull(rs.getObject("DOR_NOD_YARD")))
            						.append("</TD>").toString());
            			}else if (colName.equals("TRSP_CRR_MOD_CD2")) {
            				i++;
            				sb.append((new StringBuilder())
            						.append("<TD>")
            						.append(JSPUtil.getNull(rs.getObject("TRSP_CRR_MOD_CD")))
            						.append("</TD>").toString());

                    	}else{
                        	sb.append("<TD><![CDATA[");
    						sb.append(getNull(rs.getObject(i++)));
    						sb.append("]]></TD>");                    		
                    	}
                    }
                    i = 1;
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

