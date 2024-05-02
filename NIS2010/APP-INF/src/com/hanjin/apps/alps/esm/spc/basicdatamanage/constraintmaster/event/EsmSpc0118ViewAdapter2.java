/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EsmSpc0118ViewAdapter2.java
*@FileTitle : EsmSpc0118ViewAdapter2
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.14 Seung-Man KIM
* 1.0 Creation
* cr반영용
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.event;

import java.sql.SQLException;

import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ESM_COA_0060 에 대한 ViewAdapter<br>
 * - ESM_COA_0060HTMLAction에서 작성<br>
 *
 * @author 김기대
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmSpc0118ViewAdapter2 extends DefaultViewAdapter {
	
    public EsmSpc0118ViewAdapter2(){
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
		    if(rs.getMaxRows() > 0){
		      	totCnt = rs.getMaxRows();
		    }    

		    strBuilder.append("<DATA TOTAL=\""+totCnt+"\" COLSEPARATOR='|'>");
		    if(totCnt > 0){
		    		int i =1;
		    		while(rs.next()){
		    			
		    			strBuilder.append("<TR>");
		    			strBuilder.append("<![CDATA[");
		    			for (int j = 0 ; j < rs.getMetaData().getColumnCount() ; j++) {
		    				strBuilder.append(JSPUtil.getNull(rs.getString(i++)));
		    				strBuilder.append("|");
			    		}
		    			strBuilder.append("  ]]>\n");
		    			strBuilder.append("</TR>");
			    		i = 1;	
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
