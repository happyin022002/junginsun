/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0072ViewAdapter.java
*@FileTitle : EsmMas0072ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 김기식
*@LastVersion : 1.0
* 2009.10.23 김기식
* 1.0 Creation
* ========================================================
* 2013.06.12 최성민 [CHM-201324876] [MAS] MAS Report내 "IAS Region " / "Bound2" 추가
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.event;

import java.sql.SQLException;
import java.util.List;

import com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.vo.MultiDimensionRptRtnVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ESM_MAS_0072 에 대한 ViewAdapter<br>
 * - ESM_MAS_0072HTMLAction에서 작성<br>
 *
 * @author 김기식
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0072ViewAdapter2 extends DefaultViewAdapter {
	
    public EsmMas0072ViewAdapter2(){
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
    	log.debug("########### EsmMas0072ViewAdapter2 ########### [START]");
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
					strBuilder.append("\n<TD>").append(JSPUtil.getNull(rowSet[1].getString("sls_yrmon").substring(4))).append("</TD>");
					strBuilder.append("\n<TD>").append(JSPUtil.getNull(rowSet[1].getString("trd_cd"))).append("</TD>");
					strBuilder.append("\n<TD>").append(JSPUtil.getNull(rowSet[1].getString("sub_trd_cd"))).append("</TD>	");			
					strBuilder.append("\n<TD>").append(JSPUtil.getNull(rowSet[1].getString("rlane_cd"))).append("</TD>");
					strBuilder.append("\n<TD>").append(JSPUtil.getNull(rowSet[1].getString("ioc_cd"))).append("</TD>");
					strBuilder.append("\n<TD>").append(JSPUtil.getNull(rowSet[1].getString("dir_cd"))).append("</TD>");
					strBuilder.append("\n<TD>").append(JSPUtil.getNull(rowSet[1].getString("hul_bnd_cd"))).append("</TD>");
				    
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
		
		log.debug("########### EsmMas0072ViewAdapter2 ########### [END]");        
	    return strBuilder.toString();
    }     
}
