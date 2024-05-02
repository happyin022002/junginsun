
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBsa0021ViewAdapter.java
*@FileTitle : EsmBsa0021ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.event;

import java.sql.SQLException;
import java.util.List;

import com.hanjin.apps.alps.esm.bsa.common.vo.CommonBsaRsVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.controller.html.HTMLAction;

/**
 * ESM_BSA_0028 에 대한 ViewAdapter<br>
 * - ESM_BSA_0028HTMLAction에서 작성<br>
 *
 * @author 남궁진호
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBsa0172ViewAdapter extends DefaultViewAdapter {
	
    public EsmBsa0172ViewAdapter(){
    	super();
    }
    
    protected String makeDataTag(List<AbstractValueObject> list, String prefix) {
    	log.debug("########### EsmBsa0172ViewAdapter.makeDataTag(List<AbstractValueObject> list, String prefix) ########### [START]");
    	CommonBsaRsVO rsVo = (CommonBsaRsVO)list.get(0);
		
		DBRowSet rowSet1 =rsVo.getDbRowset();
		
		
		if(rowSet1 == null  ){
			if(rowSet1 == null){
				log.debug("rowSet1 은 널입니다.");
			}			
			return "";
		}
		log.debug("getRowSetCnt(rowSet1) = " + getRowSetCnt(rowSet1));
		        
        // RowSet ========================================================================================== S
        
        StringBuilder strBuilder = new StringBuilder();
        if(rowSet1.isPivot()){
        	strBuilder.append(makePivotDataTag(rowSet1));
        	return strBuilder.toString();
        }        
        
    	int totCnt2  = getRowSetCnt(rowSet1);//rs.getRowCount()
    	
    	log.debug("totCnt2 = " + totCnt2);
    	
    	String[] realColNms = getColHeader(rowSet1);
    	int colCount = realColNms.length;
    	try{
		      
		    if(rowSet1.getMaxRows() > 0){
		      	totCnt2 = rowSet1.getMaxRows();
		    }  
		    
		    strBuilder.append("<DATA TOTAL=\""+totCnt2+"\">");
		    if(totCnt2 > 0){
	    		while(rowSet1.next()){		
					strBuilder.append("<TR>");
					strBuilder.append("  <TD></TD>");
					strBuilder.append("  <TD>R</TD>");
					
					for (int j = 1 ; j <= colCount ; j++) {
						strBuilder.append("<TD><![CDATA["+getNull(rowSet1.getObject(j)) + "]]></TD>");
					}	
					strBuilder.append("</TR>\n");
					//log.debug("strBuilder = " + strBuilder);
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
        // RowSet ========================================================================================== E
		
		log.debug("########### EsmBsa0172ViewAdapter.makeDataTag(List<AbstractValueObject> list, String prefix) ########### [END]");
	    return strBuilder.toString();
	}
    
}
