/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneSimulation0053SL01ViewAdapter.java
*@FileTitle : CM RETREIVE
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 윤진영
*@LastVersion : 1.12
* 2009.10.05 윤진영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.lanesimulation.event;

import java.util.List;

import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchSimRtnRowSetVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ESM_MAS_0053 SEARCHLIST01 에 대한 ViewAdapter<br>
 * - ESM_MAS_0053_HTMLAction에서 작성<br>
 *
 * @author 윤진영
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */

public class LaneSimulation0053SL01ViewAdapter extends DefaultViewAdapter {
    public LaneSimulation0053SL01ViewAdapter(){
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
	    strBuilder.append("<DATA TOTAL=\""+totCnt+"\">");
	    if(totCnt > 0){
	    	try{
	    		if(totCnt > 0) {
		    		while(rowSet.next()){
		            	strBuilder.append("\n<TR>");
	                    for (int j = 1 ; j <= rowSet.getMetaData().getColumnCount() ; j++) {
	                    	strBuilder.append("\n  <TD>"+JSPUtil.getNull(rowSet.getString(j))+"</TD>");
	                    }
	                    strBuilder.append("\n</TR>");
		    		}
	    		}	
            } catch(Exception e){
    			log.error("err "+e.toString(),e);
            }
	    }
	    strBuilder.append("\n</DATA>");
	    return strBuilder.toString();
    }
    
    /**
     * 화면의 그리드롤 동시에 두개이상 한번에 뿌리기 위해서 ETC에 xml을 만듬
     * @param list List
     * @param prefix
     * @return
     */
    protected String makeDataTag(List list, String prefix) {
    	StringBuilder strBuilder = new StringBuilder();
    	DBRowSet[] rowSet = null;
    	SearchSimRtnRowSetVO vo = null;
    	try{
    		vo = (SearchSimRtnRowSetVO)list.get(0);
    		rowSet = vo.getRowSets();
	    	if(rowSet.length>0){
	    		strBuilder.append("\n<ETC-DATA>");
	    		for(int i=0;i<rowSet.length;i++){
	    			strBuilder.append("\n<ETC KEY='sxml"+(i+1)+"'>");
	    			strBuilder.append("\n<![CDATA[");
//	    			strBuilder.append("\n<?xml version='1.0'  ?>");
	    			strBuilder.append("\n<SHEET>");
	    			strBuilder.append("\n  <DATA>");
	    			if(rowSet[i] != null){
	    				while(rowSet[i].next()){
	    					strBuilder.append("\n    <TR>");
	    					strBuilder.append("\n      <TD></TD>");
	    					for (int j = 1 ; j < rowSet[i].getMetaData().getColumnCount() ; j++) {
	    						strBuilder.append("\n      <TD>"+JSPUtil.getNull(rowSet[i].getString(j))+"</TD>");
	    					}
	    					strBuilder.append("\n    </TR>");
	    				}
	    			}
	    			strBuilder.append("\n  </DATA>");
	    			strBuilder.append("\n</SHEET>");
	    			strBuilder.append("\n]]>");
	    			strBuilder.append("\n</ETC>");
	    		}
	    		strBuilder.append("\n</ETC-DATA>");
	    	}

        } catch(Exception e){
			log.error("err "+e.toString(),e);
        }

	    return strBuilder.toString();
    }    
}
