
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0031ViewAdapter.java
*@FileTitle : EesLse0031ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.13
*@LastModifier : NK Jin-Ho
*@LastVersion : 1.0
* 2011.05.23 NK Jin-Ho
* 1.0 Creation
* ******************************************************
* 2013.08.13 채창호 [CHM-201325598]Split 02-EQR T/F 관련 LEGACY 연계 방안 및 일정
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.event;

import java.sql.SQLException;
import java.util.List;

import com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.vo.OnhireApprovalVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.controller.html.HTMLAction;

/**
 * EES_LSE_0031 에 대한 ViewAdapter<br>
 * - EES_LSE_0031HTMLAction에서 작성<br>
 *
 * @author 남궁진호
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesLse0030ViewAdapter extends DefaultViewAdapter {
	
    public EesLse0030ViewAdapter(){ 
    	super();
    }
    
    @SuppressWarnings("unchecked")
	protected String makeDataTag(List<AbstractValueObject> list, String prefix) {
    	log.debug("########### EesLse0031ViewAdapter.makeDataTag(List<AbstractValueObject> list, String prefix) ########### [START]");
    	OnhireApprovalVO rsVo = (OnhireApprovalVO)list.get(0);
		
		DBRowSet rowSet = rsVo.getDbRowset();
		String strHead = JSPUtil.replace(rsVo.getTysz(),",","|");
		String strReqNo = rsVo.getReqNo();
		String strTotalList = rsVo.getTotalList();
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
	    			//log.debug("======값=====" + JSPUtil.getNull((String)rowSet.getString("ecc_cd")));
	    			strBuilder.append("<TR >");
	    			strBuilder.append("  <TD>R</TD>");
					strBuilder.append("  <TD>N</TD>");
					if (JSPUtil.getNull((String)rowSet.getString("lstm"	)).equals("OW") || JSPUtil.getNull((String)rowSet.getString("lstm"	)).equals("ST") || JSPUtil.getNull((String)rowSet.getString("lstm"	)).equals("LT")){
						if (!JSPUtil.getNull((String)rowSet.getString("lse_rqst_no"	)).equals("")){
							strBuilder.append("  <TD EDIT ='FALSE'><![CDATA["+JSPUtil.getNull((String)rowSet.getString("agmt_cty_cd"	))+"]]></TD>");
							strBuilder.append("  <TD EDIT ='FALSE'><![CDATA["+JSPUtil.getNull((String)rowSet.getString("agmt_seq"	))+"]]></TD>");
							strBuilder.append("  <TD EDIT ='FALSE'><![CDATA["+JSPUtil.getNull((String)rowSet.getString("ref_no"	))+"]]></TD>");
							strBuilder.append("  <TD EDIT ='FALSE'><![CDATA["+JSPUtil.getNull((String)rowSet.getString("lstm"		))+"]]></TD>");
							strBuilder.append("  <TD EDIT ='FALSE'><![CDATA["+JSPUtil.getNull((String)rowSet.getString("lstm_cd"	))+"]]></TD>");
							strBuilder.append("  <TD EDIT ='FALSE'><![CDATA["+JSPUtil.getNull((String)rowSet.getString("onh_ord_yr"	))+"]]></TD>");
							strBuilder.append("  <TD EDIT ='FALSE'><![CDATA["+JSPUtil.getNull((String)rowSet.getString("mft_yr"	))+"]]></TD>");
							strBuilder.append("  <TD EDIT ='FALSE'><![CDATA["+JSPUtil.getNull((String)rowSet.getString("free_dys"	))+"]]></TD>");
							strBuilder.append("  <TD EDIT ='FALSE'><![CDATA["+JSPUtil.getNull((String)rowSet.getString("pkup_chg_amt"		))+"]]></TD>");
							strBuilder.append("  <TD EDIT ='FALSE'><![CDATA["+JSPUtil.getNull((String)rowSet.getString("pkup_chg_cr_amt"	))+"]]></TD>");
							strBuilder.append("  <TD EDIT ='FALSE'><![CDATA["+JSPUtil.getNull((String)rowSet.getString("min_onh_dys"	))+"]]></TD>");
							strBuilder.append("  <TD EDIT ='FALSE'><![CDATA["+JSPUtil.getNull((String)rowSet.getString("ecc_cd"	))+"]]></TD>");
							strBuilder.append("  <TD EDIT ='FALSE'><![CDATA["+JSPUtil.getNull((String)rowSet.getString("loc_cod"	))+"]]></TD>");
							strBuilder.append("  <TD EDIT ='FALSE'><![CDATA["+JSPUtil.getNull((String)rowSet.getString("div_total"	))+"]]></TD>");
					
							//TySz 만큼 추출
							for(int idx=0; idx<headCnt; idx++) {
								strBuilder.append(" <TD EDIT ='FALSE'><![CDATA["+JSPUtil.getNull(rowSet.getString(headSet.get(idx)+"_old")) +"]]></TD>");
								strBuilder.append(" <TD EDIT ='FALSE'><![CDATA["+JSPUtil.getNull(rowSet.getString(headSet.get(idx)+"_lon")) +"]]></TD>");
								strBuilder.append(" <TD EDIT ='FALSE'><![CDATA["+JSPUtil.getNull(rowSet.getString(headSet.get(idx)+"_new")) +"]]></TD>");
							} // end of for
							strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)rowSet.getString("s_pkup_due_dt"))+"]]></TD>");
							strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)rowSet.getString("s_apro_rmk"	))+"]]></TD>");
							strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull(strReqNo)+"]]></TD>");
							strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull(strTotalList)+"]]></TD>");
						}else {
							strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)rowSet.getString("agmt_cty_cd"	))+"]]></TD>");
							strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)rowSet.getString("agmt_seq"	))+"]]></TD>");
							strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)rowSet.getString("ref_no"	))+"]]></TD>");
							strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)rowSet.getString("lstm"		))+"]]></TD>");
							strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)rowSet.getString("lstm_cd"	))+"]]></TD>");
							strBuilder.append("  <TD EDIT ='FALSE'><![CDATA["+JSPUtil.getNull((String)rowSet.getString("onh_ord_yr"	))+"]]></TD>");
							strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)rowSet.getString("mft_yr"	))+"]]></TD>");
							strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)rowSet.getString("free_dys"	))+"]]></TD>");
							strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)rowSet.getString("pkup_chg_amt"		))+"]]></TD>");
							strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)rowSet.getString("pkup_chg_cr_amt"	))+"]]></TD>");
							strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)rowSet.getString("min_onh_dys"	))+"]]></TD>");
							strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)rowSet.getString("ecc_cd"	))+"]]></TD>");
							strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)rowSet.getString("loc_cod"	))+"]]></TD>");
							strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)rowSet.getString("div_total"	))+"]]></TD>");
							
							//TySz 만큼 추출
							for(int idx=0; idx<headCnt; idx++) {
								strBuilder.append(" <TD><![CDATA["+JSPUtil.getNull(rowSet.getString(headSet.get(idx)+"_old")) +"]]></TD>");
								strBuilder.append(" <TD><![CDATA["+JSPUtil.getNull(rowSet.getString(headSet.get(idx)+"_lon")) +"]]></TD>");
								strBuilder.append(" <TD><![CDATA["+JSPUtil.getNull(rowSet.getString(headSet.get(idx)+"_new")) +"]]></TD>");
							} // end of for
							strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)rowSet.getString("s_pkup_due_dt"))+"]]></TD>");
							strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)rowSet.getString("s_apro_rmk"	))+"]]></TD>");
							strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull(strReqNo)+"]]></TD>");
							strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull(strTotalList)+"]]></TD>");
						}
					}else {
						strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)rowSet.getString("agmt_cty_cd"	))+"]]></TD>");
						strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)rowSet.getString("agmt_seq"	))+"]]></TD>");
						strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)rowSet.getString("ref_no"	))+"]]></TD>");
						strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)rowSet.getString("lstm"		))+"]]></TD>");
						strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)rowSet.getString("lstm_cd"	))+"]]></TD>");
						strBuilder.append("  <TD EDIT ='FALSE'><![CDATA["+JSPUtil.getNull((String)rowSet.getString("onh_ord_yr"	))+"]]></TD>");
						strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)rowSet.getString("mft_yr"	))+"]]></TD>");
						strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)rowSet.getString("free_dys"	))+"]]></TD>");
						strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)rowSet.getString("pkup_chg_amt"		))+"]]></TD>");
						strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)rowSet.getString("pkup_chg_cr_amt"	))+"]]></TD>");
						strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)rowSet.getString("min_onh_dys"	))+"]]></TD>");
						strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)rowSet.getString("ecc_cd"	))+"]]></TD>");
						strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)rowSet.getString("loc_cod"	))+"]]></TD>");
						strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)rowSet.getString("div_total"	))+"]]></TD>");
						
						//TySz 만큼 추출
						for(int idx=0; idx<headCnt; idx++) {
							strBuilder.append(" <TD><![CDATA["+JSPUtil.getNull(rowSet.getString(headSet.get(idx)+"_old")) +"]]></TD>");
							strBuilder.append(" <TD><![CDATA["+JSPUtil.getNull(rowSet.getString(headSet.get(idx)+"_lon")) +"]]></TD>");
							strBuilder.append(" <TD><![CDATA["+JSPUtil.getNull(rowSet.getString(headSet.get(idx)+"_new")) +"]]></TD>");
						} // end of for
						strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)rowSet.getString("s_pkup_due_dt"))+"]]></TD>");
						strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)rowSet.getString("s_apro_rmk"	))+"]]></TD>");
						strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull(strReqNo)+"]]></TD>");
						strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull(strTotalList)+"]]></TD>");	
					}
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
		
		log.debug("########### EesLse0031ViewAdapter.makeDataTag(List<AbstractValueObject> list, String prefix) ########### [END]");
	    return strBuilder.toString();
	}
    
}
