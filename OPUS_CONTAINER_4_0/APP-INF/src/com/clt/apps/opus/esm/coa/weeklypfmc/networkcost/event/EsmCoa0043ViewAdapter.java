/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0043ViewAdapter.java
*@FileTitle : EsmCoa0043ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.event;

import java.sql.SQLException;
import java.util.List;

import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.NetworkCostCommonVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.DefaultViewAdapter;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.core.layer.event.EventException;

/**
 * ESM_COA_0043 에 대한 ViewAdapter<br>
 * - ESM_COA_0043HTMLAction에서 작성<br>
 *
 * @author 김기대
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0043ViewAdapter extends DefaultViewAdapter {
	
    public EsmCoa0043ViewAdapter(){
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
	
		strBuilder.append("</ETC-DATA>");

	    return strBuilder.toString();
    }     
}
