/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneSimulation0052SL05ViewAdapter.java
*@FileTitle : RPB INFO RETREIVE
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 윤진영
*@LastVersion : 1.12
* 2009.10.05 윤진영
* 1.0 Creation
* 2010.07.29 이윤정 : CHM-201004777-01 [COA] COA 코드매핑 불일치건 조치 요청 : SRC_PRD_CD 삭제
=========================================================*/
package com.clt.apps.opus.esm.coa.lanesimulation.event;

import java.util.List;

import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimRtnRowSetVO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.DefaultViewAdapter;
import com.clt.framework.core.layer.event.EventException;

/**
 * ESM_COA_0052 SEARCHLIST05 에 대한 ViewAdapter<br>
 * - ESM_COA_0052_HTMLAction에서 작성<br>
 *
 * @author 윤진영
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */

public class LaneSimulation0052SL05ViewAdapter extends DefaultViewAdapter {
    public LaneSimulation0052SL05ViewAdapter(){
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
    	SearchSimRtnRowSetVO vo = (SearchSimRtnRowSetVO)list.get(0);
    	//##############################################################
    	
    	String v_trd_cd   = "";
    	String v_rlane_cd = "";
    	String v_dir_cd   = "";


    	DBRowSet rowSet = vo.getRowSet();    	
    	int totCnt = rowSet.getRowCount();

    	StringBuilder strBuilder = new StringBuilder();
	    strBuilder.append("<DATA TOTAL=\""+totCnt+"\">");
	    if(totCnt > 0){
	    	try{
	    		int i = 1;
	    		if(totCnt > 0) {
		    		while(rowSet.next()){
		    			if(i==0){
			    			v_trd_cd   = JSPUtil.getNull(rowSet.getString("trd_cd"));
			    			v_rlane_cd = JSPUtil.getNull(rowSet.getString("rlane_cd"));
			    			v_dir_cd   = JSPUtil.getNull(rowSet.getString("dir_cd"));
			    			rowSet.beforeFirst();
		    			}
		            	strBuilder.append("<TR>");
		            	strBuilder.append("<TD></TD>");
	                    for (int j = 0 ; j < rowSet.getMetaData().getColumnCount()-8 ; j++) {
	                    	strBuilder.append("<TD>"+JSPUtil.getNull(rowSet.getString(i++))+"</TD>");
	                    }
	                    i = 1;
	                    strBuilder.append("</TR>");
		    		}
	    		}	
            } catch(Exception e){
    			log.error("err "+e.toString(),e);
            }
	    }
	    strBuilder.append("</DATA>");
	    strBuilder.append("<ETC-DATA>");
	    strBuilder.append("  <ETC KEY='f_trd_cd'>"+v_trd_cd+"</ETC>");
	    strBuilder.append("  <ETC KEY='f_rlane_cd'>"+v_rlane_cd+"</ETC>");
	    strBuilder.append("  <ETC KEY='f_dir_cd'>"+v_dir_cd+"</ETC>");
	    strBuilder.append("  <ETC KEY='result'>OK</ETC>");
	    strBuilder.append("</ETC-DATA>");

	    return strBuilder.toString();
    }    
}
