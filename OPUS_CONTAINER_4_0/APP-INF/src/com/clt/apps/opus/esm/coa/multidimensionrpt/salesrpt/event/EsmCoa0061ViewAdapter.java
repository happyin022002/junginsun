/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0061ViewAdapter.java
*@FileTitle : EsmCoa0061ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.event;

import java.util.List;

import com.clt.apps.opus.esm.coa.common.Utils;
import com.clt.apps.opus.esm.coa.common.vo.CommonCoaRsVO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.DefaultViewAdapter;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.core.layer.event.EventException;

/**
 * ESM_COA_0061 에 대한 ViewAdapter<br>
 * - ESM_COA_0061HTMLAction에서 작성<br>
 *
 * @author 김기대
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0061ViewAdapter extends DefaultViewAdapter {

    public EsmCoa0061ViewAdapter(){
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
    	CommonCoaRsVO vo = (CommonCoaRsVO)list.get(0);
    	//##############################################################
    	
    	String header 	  = "";
    	String	eventName = "";

    	DBRowSet rowSet = vo.getDbRowset();
    	eventName = vo.getEventName();
    	
    	int totCnt = rowSet.getRowCount();

    	StringBuilder strBuilder = new StringBuilder();
	    strBuilder.append("<DATA TOTAL=\""+totCnt+"\">");
	    
	    if ( "GS2".equals(eventName) ) {
		    if(totCnt > 0){
		    	try{
		    		int i = 1;
		    		if(totCnt > 0) {
			    		while(rowSet.next()){
			            	strBuilder.append("<TR>");
		                    for (int j = 0 ; j < rowSet.getMetaData().getColumnCount() ; j++) {
		                    	strBuilder.append("<TD>"+JSPUtil.getNull(rowSet.getString(i++))+"</TD>");
		                    }
		                    i = 1;
		                    strBuilder.append("</TR>");
		                    strBuilder.append("\n");
			    		}
		    		}	
	            } catch(Exception e){
	            	log.error("err "+e.toString(),e);
	            }
		    }
		    strBuilder.append("</DATA>");
	    	header 	   = JSPUtil.getNull(vo.getHeader());
	    	log.debug("header=="+header);
		    strBuilder.append("<ETC-DATA>");
		    strBuilder.append("  <ETC KEY='header'><![CDATA["+header+"]]></ETC>");
		    strBuilder.append("  <ETC KEY='result'>OK</ETC>");
		    strBuilder.append("</ETC-DATA>");
	    }
	    else if ( "GS3".equals(eventName)) {
		    if(totCnt > 0){
		    	try{
			    	int lvl = 0;
		
			    	//트리데이터로 가져온다. level과 expand를 세팅해준다.

			    	if (rowSet != null) {
			    		while (rowSet.next()) {
			    			lvl = rowSet.getInt("lvl");
			    			
			    			strBuilder.append("<TR LEVEL='"+ lvl +"'" +Utils.iif(lvl==1, " EXPAND='TRUE' SUM='FALSE' ", "") + " >" );
			    		
			    			strBuilder.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("nod_cd"))+ "]]></TD>" );
			    			strBuilder.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("grp"))+ "]]></TD>" );
			    			if(lvl==1){
			    				strBuilder.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("nod_cd"))+ "]]></TD>" );
			    				strBuilder.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("grp"))+ "]]></TD>" );
			    			} else {
			    				strBuilder.append("<TD></TD>" );
			    				strBuilder.append("<TD></TD>" );
			    			}
			    			if(lvl==1){
			    				strBuilder.append("<TD BGCOLOR=\"236,231,247\"><![CDATA[" + JSPUtil.getNull(rowSet.getString("sgrp_cost_cd_desc"))+ "]]></TD>" );
			    				strBuilder.append("<TD BGCOLOR=\"236,231,247\"><![CDATA[" + JSPUtil.getNull(rowSet.getString("sgrp_cost_cd_desc"))+ "]]></TD>" );
			    			} else {
			    				strBuilder.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("stnd_cost_nm"))+ "]]></TD>" );
			    				strBuilder.append("<TD><![CDATA[ - " + JSPUtil.getNull(rowSet.getString("stnd_cost_nm"))+ "]]></TD>" );
			    			}
			    			strBuilder.append("<TD" + Utils.iif( lvl==1, " BGCOLOR=\"236,231,247\" " , "") + "><![CDATA[" + JSPUtil.getNull(rowSet.getString("wtr_rcv_term_cd")) + "]]></TD>" );	
			    			strBuilder.append("<TD" + Utils.iif( lvl==1, " BGCOLOR=\"236,231,247\" " , "") + "><![CDATA[" + JSPUtil.getNull(rowSet.getString("wtr_de_term_cd")) + "]]></TD>" );	
			    			strBuilder.append("<TD" + Utils.iif( lvl==1, " BGCOLOR=\"236,231,247\" " , "") + "><![CDATA[" + JSPUtil.getNull(rowSet.getString("amt")) + "]]></TD>" );	
			    			strBuilder.append("</TR>" );
			    			strBuilder.append("\n" );

			    		}
			    	}
	            } catch(Exception e){
	            	log.error("err "+e.toString(),e);
	            }
		    }
            strBuilder.append("</DATA>" );
	    }
	    return strBuilder.toString();
    }    

}
