/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0066ViewAdapter.java
*@FileTitle : EsmCoa0066ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 김기식
*@LastVersion : 1.0
* 2009.09.23 김기식
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.event;

import java.util.List;

import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.SearchStpInOut0135ListVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ESM_COA_0070 에 대한 ViewAdapter<br>
 * - ESM_COA_0070HTMLAction에서 작성<br>
 *
 * @author 김기식
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0135ViewAdapter extends DefaultViewAdapter {
	
    public EsmCoa0135ViewAdapter(){
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
    	log.debug("########### EsmCoa0135ViewAdapter ########### [START]");
    	StringBuilder strBuilder = new StringBuilder();
        
    	//String strErrMsg = "";								//에러메세지
    	int rowCount = list.size();			//리스트의 건수
		
    	SearchStpInOut0135ListVO listVo = null;
				
    	try{
			strBuilder.append("      <DATA TOTAL=\""+rowCount+"\">");	
		    
			for(int i =0; i <rowCount; i++)	{
				listVo = (SearchStpInOut0135ListVO)list.get(i);
				
				strBuilder.append("<TR>");
				
				strBuilder.append("<TD>" + JSPUtil.getNull(listVo.getCondOfcCd())+ "</TD>");
				strBuilder.append("<TD>" + JSPUtil.getNull(listVo.getAgmtSgnOfcCd())+ "</TD>");
				strBuilder.append("<TD>" + JSPUtil.getNull(listVo.getBkgNo())+ "</TD>");
				strBuilder.append("<TD><![CDATA[" +JSPUtil.getNull(listVo.getSlsActDesc())+ "]]> </TD>");
				strBuilder.append("<TD>"+ JSPUtil.getNull(listVo.getStpRev())+ "</TD>");
				strBuilder.append("<TD>"+ JSPUtil.getNull(listVo.getOthCost())+ "</TD>");
				strBuilder.append("<TD>"+ JSPUtil.getNull(listVo.getStpIncome())+ "</TD>");
				
				strBuilder.append("</TR>");					
			}			
							
			strBuilder.append("      </DATA>");			    
        }        
        catch(Exception ex){
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex.getMessage());
        }	

		log.debug("########### EsmCoa0135ViewAdapter ########### [END]");        
	    return strBuilder.toString();
    }     
}
