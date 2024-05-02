/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa4006ViewAdapter.java
*@FileTitle : EsmCoa4006ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.precmsimulation.event;

import java.util.List;

import com.clt.apps.opus.esm.coa.common.Utils;
import com.clt.apps.opus.esm.coa.common.vo.CommonCoaRsVO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.DefaultViewAdapter;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.core.layer.event.EventException;

/**
 * ESM_COA_4006 에 대한 ViewAdapter<br>
 * - ESM_COA_4006HTMLAction에서 작성<br>
 *
 * @author 김기대
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa4006ViewAdapter extends DefaultViewAdapter {

    public EsmCoa4006ViewAdapter(){
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
			    			//20160616.MOD
			    			strBuilder.append("<TR LEVEL='"+ lvl +"'" +Utils.iif(lvl==1||lvl==2||lvl==3, " EXPAND='TRUE' SUM='FALSE' ", "") + " >" );
			    		
			    			strBuilder.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("nod_cd"))+ "]]></TD>" );
			    			strBuilder.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("grp"))+ "]]></TD>" );
			    			if(lvl==1||lvl==2||lvl==3){	//20160616.MOD
			    				strBuilder.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("nod_cd"))+ "]]></TD>" );
			    				strBuilder.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("grp"))+ "]]></TD>" );
			    			} else {
			    				strBuilder.append("<TD></TD>" );
			    				strBuilder.append("<TD></TD>" );
			    			}
			    			if(lvl==1||lvl==2||lvl==3){	//20160616.MOD
			    				strBuilder.append("<TD BGCOLOR=\"236,231,247\"><![CDATA[" + JSPUtil.getNull(rowSet.getString("sgrp_cost_cd_desc"))+ "]]></TD>" );
			    				strBuilder.append("<TD BGCOLOR=\"236,231,247\"><![CDATA[" + JSPUtil.getNull(rowSet.getString("sgrp_cost_cd_desc"))+ "]]></TD>" );
			    			} else {
			    				strBuilder.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("stnd_cost_nm"))+ "]]></TD>" );
			    				strBuilder.append("<TD><![CDATA[ - " + JSPUtil.getNull(rowSet.getString("stnd_cost_nm"))+ "]]></TD>" );
			    			}
			    			strBuilder.append("<TD" + Utils.iif( lvl==1, " BGCOLOR=\"236,231,247\" " , "") + "><![CDATA[" + JSPUtil.getNull(rowSet.getString("wtr_rcv_term_cd")) + "]]></TD>" );	
			    			strBuilder.append("<TD" + Utils.iif( lvl==1, " BGCOLOR=\"236,231,247\" " , "") + "><![CDATA[" + JSPUtil.getNull(rowSet.getString("wtr_de_term_cd")) + "]]></TD>" );	
			    			strBuilder.append("<TD" + Utils.iif( lvl==1, " BGCOLOR=\"236,231,247\" " , "") + "><![CDATA[" + JSPUtil.getNull(rowSet.getString("amt20_a")) + "]]></TD>" );	
			    			strBuilder.append("<TD" + Utils.iif( lvl==1, " BGCOLOR=\"236,231,247\" " , "") + "><![CDATA[" + JSPUtil.getNull(rowSet.getString("amt40_a")) + "]]></TD>" );
			    			strBuilder.append("<TD" + Utils.iif( lvl==1, " BGCOLOR=\"236,231,247\" " , "") + "><![CDATA[" + JSPUtil.getNull(rowSet.getString("amt45_a")) + "]]></TD>" );
			    			strBuilder.append("<TD" + Utils.iif( lvl==1, " BGCOLOR=\"236,231,247\" " , "") + "><![CDATA[" + JSPUtil.getNull(rowSet.getString("amt45_2_a")) + "]]></TD>" );
			    			strBuilder.append("<TD" + Utils.iif( lvl==1, " BGCOLOR=\"236,231,247\" " , "") + "><![CDATA[" + JSPUtil.getNull(rowSet.getString("amt20_b")) + "]]></TD>" );	
			    			strBuilder.append("<TD" + Utils.iif( lvl==1, " BGCOLOR=\"236,231,247\" " , "") + "><![CDATA[" + JSPUtil.getNull(rowSet.getString("amt40_b")) + "]]></TD>" );
			    			strBuilder.append("<TD" + Utils.iif( lvl==1, " BGCOLOR=\"236,231,247\" " , "") + "><![CDATA[" + JSPUtil.getNull(rowSet.getString("amt45_b")) + "]]></TD>" );
			    			strBuilder.append("<TD" + Utils.iif( lvl==1, " BGCOLOR=\"236,231,247\" " , "") + "><![CDATA[" + JSPUtil.getNull(rowSet.getString("amt45_2_b")) + "]]></TD>" );
			    			strBuilder.append("<TD" + Utils.iif( lvl==1, " BGCOLOR=\"236,231,247\" " , "") + "><![CDATA[" + JSPUtil.getNull(rowSet.getString("mis_avg_flg_20")) + "]]></TD>" );
			    			strBuilder.append("<TD" + Utils.iif( lvl==1, " BGCOLOR=\"236,231,247\" " , "") + "><![CDATA[" + JSPUtil.getNull(rowSet.getString("mis_avg_flg_40")) + "]]></TD>" );
			    			strBuilder.append("<TD" + Utils.iif( lvl==1, " BGCOLOR=\"236,231,247\" " , "") + "><![CDATA[" + JSPUtil.getNull(rowSet.getString("mis_avg_flg_45")) + "]]></TD>" );
			    			strBuilder.append("<TD" + Utils.iif( lvl==1, " BGCOLOR=\"236,231,247\" " , "") + "><![CDATA[" + JSPUtil.getNull(rowSet.getString("mis_avg_flg_45_2")) + "]]></TD>" );
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
