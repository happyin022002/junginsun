/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0043ViewAdapter.java
*@FileTitle : EsmMas0043ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.event;

import java.sql.SQLException;
import java.util.List;

import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.NetworkCostCommonVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ESM_MAS_0043 에 대한 ViewAdapter<br>
 * - ESM_MAS_0043HTMLAction에서 작성<br>
 *
 * @author 김기대
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0043ViewAdapter extends DefaultViewAdapter {
	
    public EsmMas0043ViewAdapter(){
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
    protected String makeDataTag(List<AbstractValueObject> list, String prefix) {
        StringBuilder strBuilder = new StringBuilder();
        
        NetworkCostCommonVO vo = (NetworkCostCommonVO)list.get(0);
        NetworkCostCommonVO[] arrayVo = vo.getNetworkCostCommonVOArray();
		
		DBRowSet rowSet1 = arrayVo[0].getRowSet();
		DBRowSet rowSet2 = arrayVo[1].getRowSet();
	
		strBuilder.append("<ETC-DATA>");
		
		if(rowSet1 != null){
			int i=1;
	    	int totCnt = getRowSetCnt(rowSet1);//rs.getRowCount()
	        
	    	try{
			    if(rowSet1.getMaxRows() > 0){
			      	totCnt = rowSet1.getMaxRows();
			    }  
				strBuilder.append("  <ETC KEY=\"xml1\">");
				strBuilder.append("    <![CDATA[");    	
				strBuilder.append("    <SHEET>");
				strBuilder.append("      <DATA TOTAL=\""+totCnt+"\">");			    
			    
			    if(totCnt > 0){
			    		while(rowSet1.next()){
			    			strBuilder.append("<TR>");
			    			strBuilder.append("  <TD>R</TD>");
			    			for (int j = 0 ; j < rowSet1.getMetaData().getColumnCount() ; j++) {
			    				strBuilder.append("<TD>"+JSPUtil.getNull(rowSet1.getString(i++))+"</TD>");
			    			}
			    			i=1;
			    			strBuilder.append("</TR>");
			    		}
			    }
			    
			    strBuilder.append("      </DATA>");
			    strBuilder.append("    </SHEET>");
			    strBuilder.append("    ]]>");
			    strBuilder.append("  </ETC>");		    
	        }
	        catch(SQLException ex){
	            throw new RuntimeException(ex.getMessage());
	        }
	        catch(Exception ex){
	            log.error(ex.getMessage(), ex);
	            throw new RuntimeException(ex.getMessage());
	        }	    	
		}
		
		if(rowSet2 != null){
			int i=1;
	    	int totCnt = getRowSetCnt(rowSet2);//rs.getRowCount()
	        
	    	try{
			    if(rowSet2.getMaxRows() > 0){
			      	totCnt = rowSet2.getMaxRows();
			    }  

				strBuilder.append("  <ETC KEY=\"xml2\">");
				strBuilder.append("    <![CDATA[");    	
				strBuilder.append("    <SHEET>");
				strBuilder.append("      <DATA TOTAL=\""+totCnt+"\">");			    
			    
			    if(totCnt > 0){
			    		while(rowSet2.next()){
			    			strBuilder.append("<TR>");
			    			for (int j = 0 ; j < rowSet2.getMetaData().getColumnCount() ; j++) {
			    				strBuilder.append("<TD>"+JSPUtil.getNull(rowSet2.getString(i++))+"</TD>");
			    			}
			    			i = 1;
			    			strBuilder.append("</TR>");
			    		}
			    }
			    
			    strBuilder.append("      </DATA>");
			    strBuilder.append("    </SHEET>");
			    strBuilder.append("    ]]>");
			    strBuilder.append("  </ETC>");
	        }
	        catch(SQLException ex){
	            throw new RuntimeException(ex.getMessage());
	        }
	        catch(Exception ex){
	            log.error(ex.getMessage(), ex);
	            throw new RuntimeException(ex.getMessage());
	        }	    	
		}	
		strBuilder.append("</ETC-DATA>");

	    return strBuilder.toString();
    }     
}
