/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0038ViewAdapter.java
*@FileTitle : EsmMas0038ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.opmaster.event;

import java.sql.SQLException;

import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ESM_MAS_0038 에 대한 ViewAdapter<br>
 * - ESM_MAS_0038HTMLAction에서 작성<br>
 *
 * @author 김기대
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0038ViewAdapter extends DefaultViewAdapter {
	
    public EsmMas0038ViewAdapter(){
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

    	try{
		    if(rs.getMaxRows() > 0){
		      	totCnt = rs.getMaxRows();
		    }    

		    strBuilder.append("<DATA TOTAL=\""+totCnt+"\">");
		    if(totCnt > 0){
		    		while(rs.next()){			    		
			    		strBuilder.append("<TR>");
			    		strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull(rs.getString("CODE"))+"]]></TD>");
			    		strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull(rs.getString("NAME"))+"]]></TD>");
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
