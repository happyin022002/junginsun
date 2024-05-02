
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm2211ViewAdapter.java
*@FileTitle : EesCgm2211ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.23
*@LastModifier : NK Jin-Ho
*@LastVersion : 1.0
* 2011.05.23 NK Jin-Ho
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event;

import java.sql.SQLException;
import java.util.List;

import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.OnOffHireSummarybyMonthVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.controller.html.HTMLAction;

/**
 * EES_CGM_2211 에 대한 ViewAdapter<br>
 * - EES_CGM_2211HTMLAction에서 작성<br>
 *
 * @author 남궁진호
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesCgm2211ViewAdapter extends DefaultViewAdapter {
	
    public EesCgm2211ViewAdapter(){
    	super();
    }
    
    protected String makeDataTag(List<AbstractValueObject> list, String prefix) {
    	log.debug("########### EesCgm2211ViewAdapter.makeDataTag(List<AbstractValueObject> list, String prefix) ########### [START]");
    	OnOffHireSummarybyMonthVO rsVo = (OnOffHireSummarybyMonthVO)list.get(0);
		
		DBRowSet rowSet = rsVo.getDbRowset();
		String[] headset = rsVo.getArrTpszCd().split(",");
		
		int headCnt = headset.length;
		
		if(rowSet == null  ){
			if(rowSet == null){
				log.debug("rowSet 은 NULL입니다.");
			}			
			return "";
		}
		log.debug("getRowSetCnt(rowSet) = " + getRowSetCnt(rowSet));
        
        StringBuilder strBuilder = new StringBuilder();
        if(rowSet.isPivot()){
        	strBuilder.append(makePivotDataTag(rowSet));
        	return strBuilder.toString();
        }        
        
    	int totCnt  = getRowSetCnt(rowSet);//rs.getRowCount()
    	
    	log.debug("totCnt = " + totCnt);
        
    	try{
		      
		    if(rowSet.getMaxRows() > 0){
		    	totCnt = rowSet.getMaxRows();
		    }  
		    
		    strBuilder.append("<DATA TOTAL=\""+totCnt+"\">");
		    if(totCnt > 0){
	    		while(rowSet.next()){

					strBuilder.append("<TR>");
					strBuilder.append("  <TD>R</TD>");
					
					strBuilder.append("  <TD>"+JSPUtil.getNull((String)rowSet.getString("ym"	))+"</TD>");
					
					
					//Detail수 만큼 추출
					for(int idx=0; idx<headCnt; idx++) {
						strBuilder.append(" <TD>"+JSPUtil.getNull(rowSet.getString(headset[idx])) +"</TD>");
						
					} // end of for
					strBuilder.append("  <TD>"+JSPUtil.getNull((String)rowSet.getString("div_total"				))+"</TD>");
					strBuilder.append("  <TD>"+JSPUtil.getNull((String)rowSet.getString("ratio"	))+"</TD>");
						
					strBuilder.append("</TR>\n");
					
					//log.debug("strBuilder = " + strBuilder);
	    		}
		    }
		   
		    strBuilder.append("</DATA>");
		    strBuilder.append("<ETC-DATA>");
		    strBuilder.append("  <ETC KEY=\"row\">"+headCnt+"</ETC>");
		    strBuilder.append("  <ETC KEY=\"headSet\">"+headset+"</ETC>");
		    strBuilder.append("</ETC-DATA>");			    
        }
        catch(SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
        catch(Exception ex){
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex.getMessage());
        }
		
		log.debug("########### EesCgm2211ViewAdapter.makeDataTag(List<AbstractValueObject> list, String prefix) ########### [END]");
	    return strBuilder.toString();
	}
    
}
