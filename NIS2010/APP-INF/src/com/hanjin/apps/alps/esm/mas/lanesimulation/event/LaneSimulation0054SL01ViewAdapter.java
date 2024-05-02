/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneSimulation0054SL01ViewAdapter.java
*@FileTitle : COST CALCULATION
*Open Issues : 
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 윤진영
*@LastVersion : 1.12
* 2009.10.05 윤진영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.lanesimulation.event;

import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ESM_MAS_0054 SEARCHLIST01 에 대한 ViewAdapter<br>
 * - ESM_MAS_0054_HTMLAction에서 작성<br>
 *
 * @author 윤진영
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */

public class LaneSimulation0054SL01ViewAdapter extends DefaultViewAdapter {
    public LaneSimulation0054SL01ViewAdapter(){
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
    	StringBuilder strBuilder = new StringBuilder();
	    try{
			if(totCnt > 0) {
				int i = 1;
		        strBuilder.append("\n  <DATA TOTAL='"+totCnt+"'>");
		        if (rowSet != null) {
		            while (rowSet.next()) {
		            	strBuilder.append("<TR>");
		            	for (int j = 0; j < rowSet.getMetaData().getColumnCount(); j++) {
							strBuilder.append("<TD><![CDATA["+JSPUtil.getNull(rowSet.getString(i++))+"]]></TD>");
						}
		            	strBuilder.append("</TR>");
		            	i = 1;
		            }// end while
		        }// end if
				strBuilder.append("\n  </DATA>");
			}	
        } catch(Exception e){
			log.error("err "+e.toString(),e);
        }
	    return strBuilder.toString();
    }
}
