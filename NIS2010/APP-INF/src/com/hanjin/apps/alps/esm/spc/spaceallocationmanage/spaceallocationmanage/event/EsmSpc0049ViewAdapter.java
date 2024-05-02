/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0049ViewAdapter.java
*@FileTitle : EsmSpc0049ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.25
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2011.08.25 김종준
* 1.0 Creation
* 2011.08.25 김종준 [CHM-201113071-01] control by HO/RHQ 화면과 COA 링크 팝업 추가
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event;

import java.sql.SQLException;

import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ESM_SPC_0049 에 대한 ViewAdapter<br>
 * - ESM_SPC_0049HTMLAction에서 작성<br>
 *
 * @author 김종준
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmSpc0049ViewAdapter extends DefaultViewAdapter {
	
    public EsmSpc0049ViewAdapter(){
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
