/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0066ViewAdapter.java
*@FileTitle : EsmMas0066ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 김기식
*@LastVersion : 1.0
* 2009.09.23 김기식
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.event;

import java.sql.SQLException;
import java.util.List;

import com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.vo.MultiDimensionPfmcByOfficeListVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ESM_MAS_0066 에 대한 ViewAdapter<br>
 * - ESM_MAS_0066HTMLAction에서 작성<br>
 *
 * @author 김기식
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0066ViewAdapter extends DefaultViewAdapter {
	
    public EsmMas0066ViewAdapter(){
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
    	log.debug("########### EsmMas0066ViewAdapter ########### [START]");
    	StringBuilder strBuilder = new StringBuilder();
        DBRowSet rowSet = null;
        int rowCount	= 0;	 //DB ResultSet 리스트의 건수
        String[] hArr = null;
        String[] rtoArr = null;
        String tmp1 = "";
		String tmp2 = "";
		
		MultiDimensionPfmcByOfficeListVO listVo = (MultiDimensionPfmcByOfficeListVO)list.get(0);
        
        rowSet = listVo.getRowSet();
		hArr = listVo.getCArr();
		rtoArr = listVo.getRtoArr();
		if(rowSet != null){
			 rowCount = rowSet.getRowCount();
		}
		
		//strBuilder.append("<ETC-DATA>");
		
    	try{			    
			//strBuilder.append("  <ETC KEY=\"xml1\">");
			//strBuilder.append("    <![CDATA[");
			//strBuilder.append("    <?xml version=\"1.0\" ?>");	    	
			//strBuilder.append("    <SHEET>");
			strBuilder.append("      <DATA TOTAL=\""+rowCount+"\">");	
			
			if(rowSet != null){
				while (rowSet.next()) {										
	    			strBuilder.append("<TR>");
	    			strBuilder.append("<TD>"+JSPUtil.getNull(rowSet.getString("item"))+"</TD>");
	    			strBuilder.append("<TD>"+JSPUtil.getNull(rowSet.getString("item_nm"))+"</TD>");
	    			strBuilder.append("<TD>"+JSPUtil.getNull(rowSet.getString("estm_total"))+"</TD>");
	    			strBuilder.append("<TD>"+JSPUtil.getNull(rowSet.getString("repo_total"))+"</TD>");
	    			
	    			if(hArr != null){						
						for(int k=0; k<hArr.length; k++){
							tmp1 = "estm_" +  hArr[k];
							tmp2 = "repo_" + hArr[k];
							
							strBuilder.append("<TD>"+JSPUtil.getNull(rowSet.getString(tmp1))+"</TD>");
							strBuilder.append("<TD>"+JSPUtil.getNull(rowSet.getString(tmp2))+"</TD>");
						}
	    			}
	    			strBuilder.append("</TR>");
	    		}
			}	
			strBuilder.append("<TR>");
			strBuilder.append("<TD></TD>");
			strBuilder.append("<TD>Cost Total</TD>");
			strBuilder.append("<TD></TD>");
			strBuilder.append("<TD></TD>");				
			if(hArr != null) {
				for(int k=0; k<hArr.length; k++){
					strBuilder.append("<TD></TD><TD></TD>");
				}
			}
			strBuilder.append("</TR>");		
			
			strBuilder.append("<TR>");
			strBuilder.append("<TD></TD>");
			strBuilder.append("<TD>Contribution Margin</TD>");
			strBuilder.append("<TD></TD>");
			strBuilder.append("<TD></TD>");				
			if(hArr != null) {
				for(int k=0; k<hArr.length; k++){
					strBuilder.append("<TD></TD><TD></TD>");
				}
			}
			strBuilder.append("</TR>");
			
			strBuilder.append("<TR>");
			strBuilder.append("<TD></TD>");
			strBuilder.append("<TD>Cost Saving</TD>");
			strBuilder.append("<TD></TD>");
			strBuilder.append("<TD></TD>");				
			if(hArr != null) {
				for(int k=0; k<hArr.length; k++){
					strBuilder.append("<TD></TD><TD></TD>");
				}
			}
			strBuilder.append("</TR>");
			
			strBuilder.append("<TR>");
			strBuilder.append("<TD></TD>");
			strBuilder.append("<TD>Credit Amount</TD>");
			strBuilder.append("<TD></TD>");
			strBuilder.append("<TD></TD>");				
			if(hArr != null) {
				for(int k=0; k<hArr.length; k++){
					strBuilder.append("<TD></TD><TD></TD>");
				}
			}
			strBuilder.append("</TR>");
			
			strBuilder.append("<TR>");
			strBuilder.append("<TD></TD>");
			strBuilder.append("<TD>Credit Ratio(%)</TD>");
			strBuilder.append("<TD></TD>");
			strBuilder.append("<TD></TD>");				
			if(hArr != null) {
				for(int k=0; k<hArr.length; k++){
					strBuilder.append("<TD>"+rtoArr[k]+"</TD><TD></TD>");
				}
			}
			strBuilder.append("</TR>");
						    
		    strBuilder.append("      </DATA>");
		    //strBuilder.append("    </SHEET>");
		    //strBuilder.append("    ]]>");
		    //strBuilder.append("  </ETC>");		    
        }
        catch(SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
        catch(Exception ex){
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex.getMessage());
        }	
		
		//strBuilder.append("</ETC-DATA>");

		log.debug("########### EsmMas0066ViewAdapter ########### [END]");        
	    return strBuilder.toString();
    }     
}
