/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0149ViewAdapter.java
*@FileTitle : EsmMas0149ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.event;

import java.util.List;

import com.hanjin.apps.alps.esm.mas.common.Utils;
import com.hanjin.apps.alps.esm.mas.common.vo.CommonMasRsVO;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * ESM_MAS_0149 에 대한 ViewAdapter<br>
 * - ESM_MAS_0149HTMLAction에서 작성<br>
 *
 * @author 김기대
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0149ViewAdapter extends DefaultViewAdapter {

    public EsmMas0149ViewAdapter(){
    	super();
    }
	/**
	 * View Adapter 생성시 자동으로 호출된다.<br>
	 *  - List 데이타에 대해서 XML을 구현한 문자열을 구현하여 준다.<br>
	 * 
	 * @param List list
	 * @param String prefix
	 * @return String
	 * @exception EventException
	 */	    
    protected String makeDataTag(List list, String prefix) {
    	
        //##############################################################
    	CommonMasRsVO vo = (CommonMasRsVO)list.get(0);
    	//##############################################################
    	
    	String	eventName = "";

    	DBRowSet rowSet = vo.getDbRowset();
    	eventName = vo.getEventName();
    	
    	int totCnt = rowSet.getRowCount();

    	StringBuilder strBuilder = new StringBuilder();
	    strBuilder.append("<DATA TOTAL=\""+totCnt+"\">");
	    
	    if(totCnt > 0){
	    	try{
		    	int lvl = 0;
	
		    	//트리데이터로 가져온다. level과 expand를 세팅해준다.
		    	/*
		    	<%
		    	int lvl = 0;

		    	//트리데이터로 가져온다. level과 expand를 세팅해준다.
		    	if (rowSet != null) {
		    		while (rowSet.next()) {
		    			lvl = rowSet.getInt("lvl");
		    	%>
		    		<TR LEVEL="<%=lvl%>" <%if(lvl==1){%>EXPAND="TRUE" SUM="FALSE"<%}%>>
		    			<TD><%=JSPUtil.getNull(rowSet.getString("nod_cd"))%></TD>
		    			<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("grp"))%>]]></TD>
		    			<%if(lvl==1){%>
		    			<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("sgrp_cost_cd_desc"))%>]]></TD>
		    			<%} else {%>
		    			<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("stnd_cost_nm"))%>]]></TD>
		    			<%}%>
		    			<TD><%=JSPUtil.getNull(rowSet.getString("wtr_rcv_term_cd"))%></TD>	
		    			<TD><%=JSPUtil.getNull(rowSet.getString("wtr_de_term_cd"))%></TD>	
		    			<TD><%=JSPUtil.getNull(rowSet.getString("amt"))%></TD>	
		    		</TR>
		    	<%
		    		}
		    	}
		    	*/

		    	if (rowSet != null) {
		    		while (rowSet.next()) {
		    			lvl = rowSet.getInt("lvl");
		    			
		    			strBuilder.append("<TR LEVEL='"+ lvl +"'" +Utils.iif(lvl==1, " EXPAND='TRUE' SUM='FALSE' ", "") + " >" );
		    		
		    			strBuilder.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("nod_cd"))+ "]]></TD>" );
		    			strBuilder.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("grp"))+ "]]></TD>" );
		    			if(lvl==1){
		    				strBuilder.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("sgrp_cost_cd_desc"))+ "]]></TD>" );
		    			} else {
		    				strBuilder.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("stnd_cost_nm"))+ "]]></TD>" );
		    			}
	    				strBuilder.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("wtr_rcv_term_cd"))+ "]]></TD>" );
	    				strBuilder.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("wtr_de_term_cd"))+ "]]></TD>" );
	    				strBuilder.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("amt"))+ "]]></TD>" );
		    			strBuilder.append("</TR>" );
		    			strBuilder.append("\n" );

		    		}
		    	}
            } catch(Exception e){
            	log.error("err "+e.toString(),e);
            }
	    }
        strBuilder.append("</DATA>" );
        
	    return strBuilder.toString();
    }    

}
