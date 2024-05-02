
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0074ViewAdapter.java
*@FileTitle : EesLse0074ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.13
*@LastModifier : NK Jin-Ho
*@LastVersion : 1.0
* 2011.05.23 NK Jin-Ho
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.event;

import java.sql.SQLException;
import java.util.List;

import com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.vo.ReportSearchReceivableVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.controller.html.HTMLAction;

/**
 * EES_LSE_0074 에 대한 ViewAdapter<br>
 * - EES_LSE_0074HTMLAction에서 작성<br>
 *
 * @author 남궁진호
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesLse0074ViewAdapter extends DefaultViewAdapter {
	
    public EesLse0074ViewAdapter(){ 
    	super();
    }
    
    @SuppressWarnings("unchecked")
	protected String makeDataTag(List<AbstractValueObject> list, String prefix) {
    	log.debug("########### EesLse0074ViewAdapter.makeDataTag(List<AbstractValueObject> list, String prefix) ########### [START]");
    	ReportSearchReceivableVO rsVo = (ReportSearchReceivableVO)list.get(0);
		
		DBRowSet rowSet = rsVo.getDbRowset();
		String rptType = rsVo.getReportType();
		String strHead = JSPUtil.replace(rsVo.getTysz(),",","|");
		List<String> headSet = JSPUtil.convertStringToArrayList(strHead);
		
		int headCnt = headSet.size();
		
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
		    
		    strBuilder.append("<DATA TOTAL=\""+totCnt+"\">\n");
		    if(totCnt > 0){
	    		while(rowSet.next()){

					strBuilder.append("<TR>");
					strBuilder.append("  <TD>R</TD>");
					if (rptType.equals("rp_0076")){
						strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)rowSet.getString("charge_type"	))+"]]></TD>");
						strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)rowSet.getString("div"			))+"]]></TD>");
						strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)rowSet.getString("g_ttl"		))+"]]></TD>");
					}else{
						strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)rowSet.getString("cost_yrmon"		))+"]]></TD>");
						strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)rowSet.getString("charge_type"		))+"]]></TD>");
						strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)rowSet.getString("vndr_seq"		))+"]]></TD>");
						strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)rowSet.getString("abbr_nm"		))+"]]></TD>");
						strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)rowSet.getString("lstm_cd"		))+"]]></TD>");
						strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)rowSet.getString("agmt_no"		))+"]]></TD>");
						strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)rowSet.getString("g_ttl"		))+"]]></TD>");
					}
					//TySz 만큼 추출
					for(int idx=0; idx<headCnt; idx++) {
						strBuilder.append(" <TD><![CDATA["+JSPUtil.getNull(rowSet.getString(headSet.get(idx))) +"]]></TD>");
					} // end of for
					
					strBuilder.append("</TR>\n");
	    		}
		    }
		   
		    strBuilder.append("</DATA>");
		    strBuilder.append("<ETC-DATA>");
		    strBuilder.append("  <ETC KEY=\"row\">"+headCnt+"</ETC>");
		    strBuilder.append("  <ETC KEY=\"headSet\">"+headSet+"</ETC>");
		    strBuilder.append("</ETC-DATA>");			    
        }
        catch(SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
        catch(Exception ex){
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex.getMessage());
        }
		
		log.debug("########### EesLse0074ViewAdapter.makeDataTag(List<AbstractValueObject> list, String prefix) ########### [END]");
	    return strBuilder.toString();
	}
    
}
