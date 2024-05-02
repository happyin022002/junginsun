/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneSimulation0053SL07ViewAdapter.java
*@FileTitle : AFTER OCEAN T/S RETREIVE
*Open Issues : 
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 윤진영
*@LastVersion : 1.12
* 2009.10.05 윤진영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.lanesimulation.event;

import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.DefaultViewAdapter;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.core.layer.event.EventException;

/**
 * ESM_COA_0053 SEARCHLIST07 에 대한 ViewAdapter<br>
 * - ESM_COA_0053_HTMLAction에서 작성<br>
 *
 * @author 윤진영
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */


public class LaneSimulation0053SL07ViewAdapter extends DefaultViewAdapter {
    public LaneSimulation0053SL07ViewAdapter(){
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
    protected String makeDataTag(DBRowSet rowSet, String prefix) {
    	int totCnt = rowSet.getRowCount();
        //String xmlString = "";
		String tml_cd = "";
		String cy_cd = "";
        StringBuilder strBuilder = new StringBuilder();
	    try{
		    if (rowSet != null) {
		    	strBuilder.append("\n  <DATA TOTAL='"+totCnt+"'>");
		        while (rowSet.next()) {
		        	if(JSPUtil.getNull(rowSet.getString("tml_cd")).equals("")){
		            	tml_cd = "";
		            	cy_cd = "";
		        	} else {
		            	tml_cd = JSPUtil.getNull(rowSet.getString("tml_cd")).substring(0,5);
		            	cy_cd = JSPUtil.getNull(rowSet.getString("tml_cd")).substring(5);
		        	}
		        	strBuilder.append("\n <TR>");
		        	strBuilder.append("\n <TD>1</TD>");
		    		strBuilder.append("\n <TD>"+ JSPUtil.getNull(rowSet.getString("sect_no")).replaceAll("0","") +"</TD>");
		  			strBuilder.append("\n <TD>"+ JSPUtil.getNull(rowSet.getString("sect_no")).replaceAll("0","") + JSPUtil.getNull(rowSet.getString("vsl_capa")) +"</TD>");
		   		    strBuilder.append("\n <TD>Sec."+ JSPUtil.getNull(rowSet.getString("sect_no")).replaceAll("0","") +"</TD>");
		    		strBuilder.append("\n <TD>"+JSPUtil.getNull(rowSet.getString("sect_no"))+"</TD>");
					strBuilder.append("\n <TD>"+JSPUtil.getNull(rowSet.getString("rlane_cd"))+"</TD>");
			        strBuilder.append("\n <TD>"+JSPUtil.getNull(rowSet.getString("skd_dir_cd"))+"</TD>");
			        strBuilder.append("\n <TD>"+JSPUtil.getNull(rowSet.getString("bsa_capa"))+"</TD>");
			        strBuilder.append("\n <TD>"+JSPUtil.getNull(rowSet.getString("vsl_cd"))+"</TD>");
			        strBuilder.append("\n <TD>"+tml_cd+"</TD>");
			        strBuilder.append("\n <TD>"+cy_cd+"</TD>");
			        strBuilder.append("\n <TD>"+JSPUtil.getNull(rowSet.getString("vsl_dbl_call_seq"))+"</TD>");
			        strBuilder.append("\n <TD>"+JSPUtil.getNull(rowSet.getString("dir_asgn_rto"))+"</TD>");
			        strBuilder.append("\n <TD>"+JSPUtil.getNull(rowSet.getString("local_rto"))+"</TD>");
			        strBuilder.append("\n <TD>"+JSPUtil.getNull(rowSet.getString("pt_tf"))+"</TD>");
			        strBuilder.append("\n <TD>"+JSPUtil.getNull(rowSet.getString("cl_tf"))+"</TD>");
			        strBuilder.append("\n <TD>"+JSPUtil.getNull(rowSet.getString("sea_dys"))+"</TD>");
			        strBuilder.append("\n <TD>"+JSPUtil.getNull(rowSet.getString("port_dys"))+"</TD>");
			        strBuilder.append("\n <TD>"+JSPUtil.getNull(rowSet.getString("f_o"))+"</TD>");
			        strBuilder.append("\n <TD>"+JSPUtil.getNull(rowSet.getString("d_o"))+"</TD>");
			        strBuilder.append("\n <TD>"+JSPUtil.getNull(rowSet.getString("ttl_dys"))+"</TD>");
		            for (int j = 0 ; j <= rowSet.getMetaData().getColumnCount() ; j++) {
		            	if(j>16){
		            		strBuilder.append("\n <TD>"+JSPUtil.getNull(rowSet.getString(j))+"</TD>");
		            	}
		            }
		            strBuilder.append("\n </TR>");
		        }
		    }
        strBuilder.append("\n </DATA>");
        } catch(Exception e){
			log.error("err "+e.toString(),e);
        }
	    return strBuilder.toString();
    }
}
