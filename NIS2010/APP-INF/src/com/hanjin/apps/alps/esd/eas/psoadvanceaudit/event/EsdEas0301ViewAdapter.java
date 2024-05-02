/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : EsdEas0340ViewAdapter.java
*@FileTitle : Default IBSheet Generation Class
*Open Issues :
*Change history :
*@LastModifyDate : 2015-06-09
*@LastModifier : 최종혁
*@LastVersion : 1.2
* 2015-06-09 최종혁
* 1.0 최초 생성
*----------------------------------------------------------
* History
=========================================================*/
package com.hanjin.apps.alps.esd.eas.psoadvanceaudit.event;

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
 * @author 최종혁
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */

public class EsdEas0301ViewAdapter extends EasDefaultViewAdapter {
 
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
            if( formcommand.isCommand(FormCommand.MODIFY01) ){
              	sb.append("<RESULT><TR-ALL> OK </TR-ALL></RESULT>");
            }else if( formcommand.isCommand(FormCommand.SEARCH) ){
            	sb.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' TOTAL='").append(getRowSetCnt(rs)).append("'>\n").toString());
            	int colCount = realColNms.length;
            	String colName = "";
                for(; rs.next(); )
            	{
                	String sSelectFlgTemp = JSPUtil.getNull(rs.getString("SELECT_FLG_TEMP"));
                	String sSelectFlgTempFlg = sSelectFlgTemp.length()==1?"Y":"N";
                	String sAutoAuditFlg = JSPUtil.getNull(rs.getString("AUTO_AUDIT_FLG"));
                	String sAutoAuditFlgChk = "";
                	String sSelectFlg = "";
                	String sIbflag = "";
                	String sDiffFlg = "";
                	String sTariffCost = JSPUtil.getNull(rs.getString("TARIFF_COST"));
                	String sDiff = JSPUtil.getNull(rs.getString("DIFF"));
                	float fDiff = 0;
                	String sBatProgStsCd = JSPUtil.getNull(rs.getString("bat_prog_sts_cd"));
                	
                	if (sDiff.equals("") || sDiff == null ) {
                		fDiff = 0;
                	}else{
                		fDiff = Float.valueOf(sDiff).floatValue();
                	}

                	if (sTariffCost.equals("0")) sTariffCost = ""; 
                	if ( (!sTariffCost.equals("") ) & (sAutoAuditFlg.equals("C") )) {
                		sDiffFlg = "Y";
                	}

                	//미심사 건중 Auto Audit 상태가 S:Coincidence, F:Allowable Discrepancy 일 경우 자동 체크하고 Select도 Coincidence로 표시한다.
                	if (fDiff < 0  && sSelectFlgTempFlg.equals("N") ) { //미심사 건중 Diff가 마이너스일 경우 Auto Audit여부와 관계없이 Select를 Potential EAC로 표시 
                		sAutoAuditFlgChk = "0";
                		sSelectFlg = "E";
                		sIbflag = "";
                	}else if ( (sAutoAuditFlg.equals("S") || sAutoAuditFlg.equals("F")) && sSelectFlgTempFlg.equals("N") ) {
                		sAutoAuditFlgChk = "1";
                		sSelectFlg = "P";
                		sIbflag = "U";
                	}else{
                		sAutoAuditFlgChk = "0";
                		sSelectFlg = "";
                		sIbflag = "";
                	}
                	
                	sb.append("\t<TR")
                    .append(sSelectFlgTempFlg.equals("Y")?" COLOR='100,100,100'":"")
                    .append(sSelectFlgTempFlg.equals("Y")?" BGCOLOR='245,235,245'":"")
                    .append(">");
                    
            		for(int j = 1; j < colCount+1; j++) {
            			colName = rs.getMetaData().getColumnName(j);
            			if (colName.equals("IBFLAG")){
            				sb.append((new StringBuilder())
            						.append("<TD")
            						.append(">")
            						.append(sIbflag)
            						.append("</TD>").toString());
            			} else if(colName.equals("SEL")) {
            				sb.append((new StringBuilder())
            						.append("<TD")
            						.append(sBatProgStsCd.equals("P")?" BGCOLOR='255, 190, 130'":"")
            						.append(">")
            						.append(sAutoAuditFlgChk)
            						.append("</TD>").toString());
            			} else if(colName.equals("SELECT_FLG")) {
            				sb.append((new StringBuilder())
            						.append("<TD")
            						.append(">")
            						.append(sSelectFlg)
            						.append("</TD>").toString());
            			} else if(colName.equals("TARIFF_COST")) {
            				sb.append((new StringBuilder())
            						.append("<TD")
            						.append(getNull(rs.getObject(j)).equals("")?" COLOR='255, 0, 0'":"")
            						.append(">")
            						.append(getNull(rs.getObject(j)))
            						.append("</TD>").toString());            				
            			} else if(colName.equals("DIFF")) {
            				
            				sb.append((new StringBuilder())
            						.append("<TD")
            						.append(sDiffFlg.equals("Y")?" COLOR='255, 0, 0'":"")
            						.append(">")
            						.append(getNull(rs.getObject(j)))
            						.append("</TD>").toString());
            				
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
