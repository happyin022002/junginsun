/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0160GSViewAdapter.java
*@FileTitle : Feeder Term
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 장영석
*@LastVersion : 1.3
* 2009.09.22 장영석
* 1.0 Creation
* 2010.02.05 임옥영 소스품질검토결과 반영(중첩 TRY 문 제거)
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.event;

import java.sql.SQLException;

import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ESM_MAS_0160 에 대한 ViewAdapter<br>
 * - ESM_MAS_0160HTMLAction에서 작성<br>
 *
 * @author 장영석
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0160GSViewAdapter extends DefaultViewAdapter {
	
    public EsmMas0160GSViewAdapter(){
    	super();
    }
    
	/**
	 * View Adapter 생성시 자동으로 호출된다.<br>
	 *  - RowSet 데이타에 대해서 XML을 구현한 문자열을 구현하여 준다.<br>
	 * 
	 * @param DBRowSet rs
	 * @param String prefix
	 * @return String
	 * @exception EventException
	 */	      
    protected String makeDataTag(DBRowSet rs, String prefix){
        StringBuilder strBuilder = new StringBuilder();
        
        if(rs.isPivot()){
        	strBuilder.append(makePivotDataTag(rs));
        	return strBuilder.toString();
        }        
        
    	int totCnt  = getRowSetCnt(rs);//rs.getRowCount()
        
    	//String realColNms[] = getColHeader(rs);
    	try{
		   // String changedColNms[] = getChangedColNms(realColNms, prefix);
		      
		    if(rs.getMaxRows() > 0){
		      	totCnt = rs.getMaxRows();
		    }  
		    
		    strBuilder.append("<DATA TOTAL=\""+totCnt+"\">");
		    
		    if(totCnt > 0){
		    		int i =1;
		    		while(rs.next()){
		    			strBuilder.append("<TR>");

		    			for (int j = 0 ; j < rs.getMetaData().getColumnCount() ; j++) {
		    				strBuilder.append("<TD><![CDATA["+JSPUtil.getNull(rs.getString(i++))+"]]></TD>");

			    		}
			    		i = 1;

			    		strBuilder.append("</TR>");
		    		}
		    }
	    
		    strBuilder.append("</DATA>");
        }
        catch(SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
        catch(Exception ex){
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex.getMessage());
        }
        return strBuilder.toString();
    }      
	
}
