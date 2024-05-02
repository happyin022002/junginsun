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

import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.SearchDailyBKGView0078ListVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ESM_COA_0078 에 대한 ViewAdapter<br>
 * - ESM_COA_0078HTMLAction에서 작성<br>
 *
 * @author 김기식
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0078ViewAdapter extends DefaultViewAdapter {
	
    public EsmCoa0078ViewAdapter(){
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
    	log.debug("########### EsmCoa0078ViewAdapter ########### [START]");
    	StringBuilder strBuilder = new StringBuilder();
        
    	//String strErrMsg = "";								//에러메세지
    	int rowCount = list.size();			//리스트의 건수
		
    	SearchDailyBKGView0078ListVO listVo = null;
				
    	try{
			strBuilder.append("      <DATA TOTAL=\""+rowCount+"\">");	
		    
			for(int i =0; i <rowCount; i++)	{
				listVo = (SearchDailyBKGView0078ListVO)list.get(i);
				
				strBuilder.append("<TR>");				
				
				strBuilder.append("\n          <TD><![CDATA["+ JSPUtil.getNull(listVo.getTrdCd())  +"]]></TD>");
				strBuilder.append("\n          <TD><![CDATA["+ JSPUtil.getNull(listVo.getRlaneCd())+"]]></TD>");
				strBuilder.append("\n          <TD><![CDATA["+ JSPUtil.getNull(listVo.getDirCd())  +"]]></TD>");
				strBuilder.append("\n          <TD><![CDATA["+ JSPUtil.getNull(listVo.getCostWk()) +"]]></TD>");
				strBuilder.append("\n          <TD><![CDATA["+ JSPUtil.getNull(listVo.getVvdCd())  +"]]></TD>");
				strBuilder.append("\n          <TD><![CDATA["+ JSPUtil.getNull(listVo.getBkgPorCd())  +"]]></TD>");
				strBuilder.append("\n          <TD><![CDATA["+ JSPUtil.getNull(listVo.getBkgPolCd())  +"]]></TD>");
				strBuilder.append("\n          <TD><![CDATA["+ JSPUtil.getNull(listVo.getBkgPodCd())  +"]]></TD>");
				strBuilder.append("\n          <TD><![CDATA["+ JSPUtil.getNull(listVo.getBkgDelCd())  +"]]></TD>");
				strBuilder.append("\n          <TD><![CDATA["+ JSPUtil.getNull(listVo.getCOfcCd())  +"]]></TD>");
				strBuilder.append("\n          <TD><![CDATA["+ JSPUtil.getNull(listVo.getLOfcCd())  +"]]></TD>");
				strBuilder.append("\n          <TD><![CDATA["+ JSPUtil.getNull(listVo.getCRepCd()) +"]]></TD>");
				strBuilder.append("\n          <TD><![CDATA["+ JSPUtil.getNull(listVo.getLRepCd()) +"]]></TD>");
				strBuilder.append("\n          <TD><![CDATA["+ JSPUtil.getNull(listVo.getScNo()) +"]]></TD>");
				strBuilder.append("\n          <TD><![CDATA["+ JSPUtil.getNull(listVo.getRfaNo()) +"]]></TD>");
				strBuilder.append("\n          <TD><![CDATA["+ JSPUtil.getNull(listVo.getShprNm()) +"]]></TD>");
				strBuilder.append("\n          <TD><![CDATA["+ JSPUtil.getNull(listVo.getCmdtCd())  +"]]></TD>");
				strBuilder.append("\n          <TD><![CDATA["+ JSPUtil.getNull(listVo.getCmdtNm())  +"]]></TD>");
				strBuilder.append("\n          <TD><![CDATA["+ JSPUtil.getNull(listVo.getBkgNo())  +"]]></TD>");
				strBuilder.append("\n          <TD><![CDATA["+ JSPUtil.getNull(listVo.getLoad())    +"]]></TD>");
				strBuilder.append("\n          <TD><![CDATA["+ JSPUtil.getNull(listVo.getRev())     +"]]></TD>");
				strBuilder.append("\n          <TD><![CDATA["+ JSPUtil.getNull(listVo.getCm())      +"]]></TD>");
				strBuilder.append("\n          <TD></TD>");
				strBuilder.append("\n          <TD><![CDATA["+ JSPUtil.getNull(listVo.getCmCost()) +"]]></TD>");
				strBuilder.append("\n          <TD><![CDATA["+ JSPUtil.getNull(listVo.getOpCost()) +"]]></TD>");
				strBuilder.append("\n          <TD></TD>");
				strBuilder.append("\n          <TD></TD>");
				strBuilder.append("\n          <TD></TD>");
				
				strBuilder.append("</TR>");					
			}			
							
			strBuilder.append("      </DATA>");			    
        }        
        catch(Exception ex){
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex.getMessage());
        }	

		log.debug("########### EsmCoa0078ViewAdapter ########### [END]");        
	    return strBuilder.toString();
    }     
}
