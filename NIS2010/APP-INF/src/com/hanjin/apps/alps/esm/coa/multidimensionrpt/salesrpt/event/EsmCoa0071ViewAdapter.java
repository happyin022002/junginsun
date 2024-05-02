/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0071ViewAdapter.java
*@FileTitle : EsmCoa0071ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 김기식
*@LastVersion : 1.0
* 2009.10.20 김기식
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.event;

import java.sql.SQLException;
import java.util.List;

import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.SalesOffiRepoRtnVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ESM_COA_0071 에 대한 ViewAdapter<br>
 * - ESM_COA_0071HTMLAction에서 작성<br>
 *
 * @author 김기식
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0071ViewAdapter extends DefaultViewAdapter {
	
    public EsmCoa0071ViewAdapter(){
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
    	log.debug("########### EsmCoa0071ViewAdapter ########### [START]");
    	StringBuilder strBuilder = new StringBuilder();
        
    	DBRowSet rowSet = null;							   	//DB ResultSet
    	//String strErrMsg = "";								//에러메세지
    	
    	SalesOffiRepoRtnVO listVo = (SalesOffiRepoRtnVO)list.get(0);
        rowSet = listVo.getRowSet();
				
		strBuilder.append("<ETC-DATA>");
		
    	try{			    
    		strBuilder.append("  <ETC KEY=\"rdXml\">");
			strBuilder.append("    <![CDATA[");
			//strBuilder.append("    <?xml version=\"1.0\" ?>");	    	
			strBuilder.append("    <ETC>");
			strBuilder.append("    <SHEET1>");
			strBuilder.append("      <DATA>");				
			if(rowSet != null){
				while (rowSet.next()) {					
					strBuilder.append("<TR>");			        
					strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("cost_wk"))+"</TD>");
					strBuilder.append("<TD>"+ Double.parseDouble(JSPUtil.getNull(rowSet.getString("rev")))/(JSPUtil.getNull(rowSet.getString("load"))=="0" ? 1 : Double.parseDouble(JSPUtil.getNull(rowSet.getString("load"))))+"</TD>");
					strBuilder.append("<TD>"+ (Double.parseDouble(JSPUtil.getNull(rowSet.getString("bkg_rev"))) - Double.parseDouble(JSPUtil.getNull(rowSet.getString("cm_cost"))))/(JSPUtil.getNull(rowSet.getString("load"))=="0" ? 1 : Double.parseDouble(JSPUtil.getNull(rowSet.getString("load"))))+"</TD>");
					strBuilder.append("</TR>");
	    		}
			}else{
				strBuilder.append("<TR>");
				strBuilder.append("	<TD>0</TD>");
				strBuilder.append("	<TD>0</TD>");
				strBuilder.append("	<TD>0</TD>");
				strBuilder.append("</TR>");
			}						    
		    strBuilder.append("      </DATA>");
		    strBuilder.append("    </SHEET1>");
		    
		    strBuilder.append("    <SHEET2>");
			strBuilder.append("      <DATA>");				
			if(rowSet != null){
				rowSet.beforeFirst();
				while (rowSet.next()) {					
					strBuilder.append("<TR>");			        
					strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("cost_wk"))+"</TD>");
					strBuilder.append("<TD>"+ Double.parseDouble(JSPUtil.getNull(rowSet.getString("rev")))/1000 +"</TD>");
					strBuilder.append("<TD>"+ (Double.parseDouble(JSPUtil.getNull(rowSet.getString("bkg_rev"))) - Double.parseDouble(JSPUtil.getNull(rowSet.getString("cm_cost"))))/1000+"</TD>");
					
					strBuilder.append("</TR>");
	    		}
			}else{
				strBuilder.append("<TR>");
				strBuilder.append("		<TD>0</TD>");
				strBuilder.append("		<TD>0</TD>");
				strBuilder.append("		<TD>0</TD>");
				strBuilder.append("</TR>");
			}						    
		    strBuilder.append("      </DATA>");
		    strBuilder.append("    </SHEET2>");
		    
		    strBuilder.append("    <SHEET3>");
			strBuilder.append("      <DATA>");				
			if(rowSet != null){
				rowSet.beforeFirst();
				while (rowSet.next()) {					
					strBuilder.append("<TR>");			        
					strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("cost_wk"))+"</TD>");
					strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("load")) +"</TD>");
					strBuilder.append("</TR>");
	    		}
			}else{
				strBuilder.append("<TR>");
				strBuilder.append("		<TD>0</TD>");
				strBuilder.append("		<TD>0</TD>");
				strBuilder.append("</TR>");
			}
						    
		    strBuilder.append("      </DATA>");
		    strBuilder.append("    </SHEET3>");
		    
		    strBuilder.append("    <SHEET4>");
			strBuilder.append("      <DATA>");				
			
				strBuilder.append("<TR>");
				strBuilder.append("		<TD></TD>");
				strBuilder.append("		<TD></TD>");
				strBuilder.append("		<TD></TD>");
				strBuilder.append("		<TD></TD>");
				strBuilder.append("		<TD></TD>");
				strBuilder.append("		<TD></TD>");
				strBuilder.append("		<TD></TD>");
				strBuilder.append("</TR>");
						    
		    strBuilder.append("      </DATA>");
		    strBuilder.append("    </SHEET4>");
		    
		    strBuilder.append("    </ETC>");
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
		
		strBuilder.append("</ETC-DATA>");

		log.debug("########### EsmCoa0071ViewAdapter ########### [END]");        
	    return strBuilder.toString();
    }     
}
