/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0060ViewAdapter.java
*@FileTitle : EsmCoa0060ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대 
* 1.0 Creation
* 2010.02.05 임옥영 품질검토 결과 반영 (사용하지 않는 지역변수 주석처리 realColNms) 
=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.event;

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
public class EsmCoa0060ViewAdapter extends DefaultViewAdapter {
	
    public EsmCoa0060ViewAdapter(){
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
