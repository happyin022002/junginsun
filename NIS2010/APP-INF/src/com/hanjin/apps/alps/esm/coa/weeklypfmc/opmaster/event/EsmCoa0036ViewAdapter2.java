/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0036ViewAdapter2.java
*@FileTitle : EsmCoa0036ViewAdapter2
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.opmaster.event;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.coa.common.basic.CommonBC;
import com.hanjin.apps.alps.esm.coa.common.basic.CommonBCImpl;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ESM_COA_0036 에 대한 ViewAdapter<br>
 * - ESM_COA_0036HTMLAction에서 작성<br>
 *
 * @author 김기대
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0036ViewAdapter2 extends DefaultViewAdapter {
	
    public EsmCoa0036ViewAdapter2(){
    	super();
    }
    
	/**
	 * View Adapter 생성시 자동으로 호출된다.<br>
	 *  - List 데이타에 대해서 XML을 구현한 문자열을 구현하여 준다.<br>
	 * 
	 * @param List<AbstractValueObject> list
	 * @param String prefix
	 * @return String
	 * @exception EventException
	 */	      
    protected String makeDataTag(List<AbstractValueObject> list, String prefix) {
    	int totCnt  = list.size();  
    	
    	AbstractValueObject vo = (AbstractValueObject)list.get(0);
	      
	    if(vo.getMaxRows() > 0){
	      	totCnt = vo.getMaxRows();
	    }  
	    
	    StringBuilder strBuilder = new StringBuilder();
	    
	    //로직----------------------------------------
		String sRow = "";
		String trd_cd = "";
		String ibSubTrd = "";	    
	    //----------------------------------------------

	    strBuilder.append("<DATA>");
	    if(totCnt > 0){
	    	try{
	    		//로직------------------------------------------------------------------------------------------------- 
	    		Map colValues = ((AbstractValueObject)list.get(0)).getColumnValues();   
	    		
	    		sRow = JSPUtil.getNull((String)colValues.get("sRow"));
	    		trd_cd = JSPUtil.getNull((String)colValues.get("trade"));
	    		
	    		if(!trd_cd.equals("")){
	    			HashMap<String, String> subTrd	= null;
	    			CommonBC commonBC = new CommonBCImpl();
	    			subTrd = commonBC.getCodeCombo("sub_trd_cd", "subTrade", trd_cd, "code");
	    			ibSubTrd = (String)subTrd.get(trd_cd);
	    			if(ibSubTrd.equals(""))ibSubTrd = " | ";
	    		}	   	    		
                
                strBuilder.append("<TR ROW=\""+ sRow +"\">");
                strBuilder.append("  <TD COL=\"sub_trd_cd\" DATA-TYPE=\"dtCombo\" COMBO-TEXT=\""+ ibSubTrd +"\" COMBO-CODE=\""+ ibSubTrd +"\"> </TD>");
                strBuilder.append("</TR>");
	    		
	            //-------------------------------------------------------------------------------------------------
            } catch(Exception e){
                log.error("err " + e.toString(), e);
            }	
	    }
	    strBuilder.append("</DATA>");  
	    return strBuilder.toString();
    }
}
