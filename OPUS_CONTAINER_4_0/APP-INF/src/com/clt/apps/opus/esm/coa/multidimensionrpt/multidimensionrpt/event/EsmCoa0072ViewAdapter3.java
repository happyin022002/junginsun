/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0072ViewAdapter.java
*@FileTitle : EsmCoa0072ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 김기식
*@LastVersion : 1.0
* 2009.10.23 김기식
* 1.0 Creation
* 2010.08.24 윤진영 [CHM-201005423] RHQ 컬럼 추가
=========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.event;

import java.sql.SQLException;
import java.util.List;

import com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.vo.MultiDimensionRptRtnVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.DefaultViewAdapter;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.core.layer.event.EventException;

/**
 * ESM_COA_0072 에 대한 ViewAdapter<br>
 * - ESM_COA_0072HTMLAction에서 작성<br>
 *
 * @author 김기식
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0072ViewAdapter3 extends DefaultViewAdapter {
	
    public EsmCoa0072ViewAdapter3(){
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
    	log.debug("########### EsmCoa0072ViewAdapter3 ########### [START]");
    	StringBuilder strBuilder = new StringBuilder();
        DBRowSet[] rowSet = null;
        MultiDimensionRptRtnVO listVo = null;
        
        StringBuilder headCode = new StringBuilder(); //헤더가변
        StringBuilder headName = new StringBuilder(); //헤더가변
		
        strBuilder.append("      \n<DATA>");	
        
    	try{	
    		listVo = (MultiDimensionRptRtnVO)list.get(0);
    		rowSet = listVo.getRowSets();
    		
			if (rowSet != null) {
				int headCnt = rowSet[0].getRowCount();
				while (rowSet[0].next()) {
					headCode.append("|").append(JSPUtil.getNull(rowSet[0].getString("stnd_cost_cd")));
					headName.append("|").append(JSPUtil.getNull(rowSet[0].getString("rpt_itm_desc")));
				}
				
				while (rowSet[1].next()) {
					
					strBuilder.append("\n<TR>");
					strBuilder.append("\n<TD></TD>");
					strBuilder.append("\n<TD>").append(JSPUtil.getNull(rowSet[1].getString("cost_yrmon").substring(4))).append("</TD>");
					strBuilder.append("\n<TD>").append(JSPUtil.getNull(rowSet[1].getString("sls_yrmon").substring(4))).append("</TD>");
					strBuilder.append("\n<TD>").append(JSPUtil.getNull(rowSet[1].getString("cost_wk"))).append("</TD>");
					strBuilder.append("\n<TD>").append(JSPUtil.getNull(rowSet[1].getString("rhq"))).append("</TD>");
					strBuilder.append("\n<TD>").append(JSPUtil.getNull(rowSet[1].getString("trd_cd"))).append("</TD>");
					strBuilder.append("\n<TD>").append(JSPUtil.getNull(rowSet[1].getString("sub_trd_cd"))).append("</TD>	");			
					strBuilder.append("\n<TD>").append(JSPUtil.getNull(rowSet[1].getString("rlane_cd"))).append("</TD>");
					strBuilder.append("\n<TD>").append(JSPUtil.getNull(rowSet[1].getString("ioc_cd"))).append("</TD>");
					strBuilder.append("\n<TD>").append(JSPUtil.getNull(rowSet[1].getString("vsl_cd"))).append("</TD>");
					strBuilder.append("\n<TD>").append(JSPUtil.getNull(rowSet[1].getString("skd_voy_no"))).append("</TD>");
					strBuilder.append("\n<TD>").append(JSPUtil.getNull(rowSet[1].getString("dir_cd"))).append("</TD>");
				    
				    //Detail수 만큼 추출
					for(int idx=1; idx<=headCnt; idx++) {
						strBuilder.append("\n<TD>").append(JSPUtil.getNull(rowSet[1].getString("cost_amt" + idx))).append("</TD>");
					}
				    
					strBuilder.append("\n</TR>");		    
				}
			}
        }
        catch(SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
        catch(Exception ex){
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex.getMessage());
        }	
        
        strBuilder.append("\n</DATA>");
        strBuilder.append("\n<ETC-DATA>");
        strBuilder.append("\n<ETC KEY='headCode'>").append(headCode.toString()).append("</ETC>");
        strBuilder.append("\n<ETC KEY='headName'>").append(headName.toString().replaceAll("&","&amp;")).append("</ETC>");
        strBuilder.append("\n</ETC-DATA>");
		
		log.debug("########### EsmCoa0072ViewAdapter3 ########### [END]");        
	    return strBuilder.toString();
    }     
}
