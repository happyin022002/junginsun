/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsdAoc0221ViewAdapter.java
*@FileTitle : Agreement rate IBSheet Generation Class
*Open Issues :
*Change history :
*@LastModifyDate : 2010-04-30
*@LastModifier : cjh
*@LastVersion : 1.0
* 2010-04-30 cjh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.event;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.aoc.common.util.AocDefaultViewAdapter;
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
 * @author 
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */

public class EsdAoc3302ViewAdapter extends AocDefaultViewAdapter {
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix, Event event)
    {
		FormCommand	 formcommand	= event.getFormCommand();
        StringBuilder sbufXML = new StringBuilder();
        int totCnt = vos.size();
        int realCnt = vos.size();
        AbstractValueObject vo = (AbstractValueObject)vos.get(0);
        String realColNms[] = getColHeader(vo);
        String changedColNms[] = getChangedColNms(realColNms, prefix);
        if(vo.getMaxRows() > 0) totCnt = vo.getMaxRows();
        
        if( formcommand.isCommand(FormCommand.SEARCH) ) {
        	String sFcolor = "";
			String cost_trf_sts_cd = "";
			String sStsFlg = "";
        	sbufXML.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' TOTAL='").append(totCnt).append("'>\n").toString());
	        for(int i = 0; i < realCnt; i++)
	        {
	        	Map colValues = ((AbstractValueObject)vos.get(i)).getColumnValues();

	        	sbufXML.append((new StringBuilder())
    					.append("\n<TR")
    					.append(sFcolor))
    					.append(">");
    			int colCnt = realColNms.length;
    			String colName = "";
    			cost_trf_sts_cd = "U";//(String)colValues.get("cost_trf_sts_cd");
                if ( cost_trf_sts_cd.equals("C")) {           	  
                	sStsFlg = " EDIT='FALSE'";
                }else{
                	sStsFlg = " EDIT='TRUE'";
                }
    			for(int j = 0; j < colCnt - 1; j++) {
    				colName = realColNms[j];
    				if (colName.equals("loc_grp_no") || colName.equals("trsp_20ft_adj_cost_amt")|| colName.equals("trsp_40ft_adj_cost_amt")
    						|| colName.equals("mty_trsp_20ft_adj_cost_amt")|| colName.equals("mty_trsp_40ft_adj_cost_amt")
    						|| colName.equals("tml_20ft_adj_cost_amt")|| colName.equals("tml_40ft_adj_cost_amt")
    						) {
    					sbufXML.append((new StringBuilder())
    							.append("<TD")
    							.append(sStsFlg)
    							.append(">")
    							.append(getNull(String.valueOf(getNull((String)colValues.get(realColNms[j])))))
    							.append("</TD>").toString());
    				}else  if (colName.equals("n1st_vndr_nm") || colName.equals("n2nd_vndr_nm")
    						) {
    					sbufXML.append((new StringBuilder())
    							.append("<TD")
    							.append(" EDIT='").append("TRUE").append("'")
    							.append(">")
    							.append("<![CDATA[")
    							.append(getNull(String.valueOf(getNull((String)colValues.get(realColNms[j])))))
    							.append("]]>")
    							.append("</TD>").toString());
    				}else{
    					sbufXML.append((new StringBuilder())
    							.append("<TD")
    							.append(" EDIT='").append("FALSE").append("'")
    							.append(">")
    							.append(getNull(String.valueOf(getNull((String)colValues.get(realColNms[j])))))
    							.append("</TD>").toString());    					
    				}
    			}
    			sbufXML.append("</TR>");
	        }
	        sbufXML.append("\n</DATA>\n");
	        return sbufXML.toString();
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
//		FormCommand	 formcommand	= event.getFormCommand();
        StringBuilder sbufXML = new StringBuilder();
        String realColNms[] = getColHeader(rs);
        try
        {
//        	StringBuilder sb = new StringBuilder();

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

