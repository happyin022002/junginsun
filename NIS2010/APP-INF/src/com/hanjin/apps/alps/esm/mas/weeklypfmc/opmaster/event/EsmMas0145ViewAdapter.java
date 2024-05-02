/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0145ViewAdapter.java
*@FileTitle : EsmMas0145ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대 
* 1.0 Creation
* 2016.03.03 Create Lane Table, Create Vessel Table history 자동 관리
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.opmaster.event;

import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ESM_MAS_0145 에 대한 ViewAdapter<br>
 * - ESM_MAS_0145HTMLAction에서 작성<br>
 *
 * @author 김기대
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0145ViewAdapter extends DefaultViewAdapter {
	
    public EsmMas0145ViewAdapter(){
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

	    strBuilder.append("<DATA TOTAL=\""+totCnt+"\">");
	    if(totCnt > 0){
	    	try{
	    	    //로직----------------------------------------

	    	    //----------------------------------------------	    		
	    		
	    		//로직-------------------------------------------------------------------------------------------------            
	            for(int i=0; i<totCnt; i++){
	            	Map colValues = ((AbstractValueObject)list.get(i)).getColumnValues();          	  
        			
        			strBuilder.append("<TR>");
        			strBuilder.append("  <TD></TD>");
        			strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("flag"))+"]]></TD>");
        			strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("lane_seq"))+"]]></TD>");
        			strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("trd_cd"))+"]]></TD>");
        			strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("sub_trd_cd"))+"]]></TD>");
        			strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("slan_cd"))+"]]></TD>");
        			strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("rlane_cd"))+"]]></TD>");
        			strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("dir_cd"))+"]]></TD>");
        			strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("ioc_cd"))+"]]></TD>");
        			strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("vsl_lane_tp_cd"))+"]]></TD>");
        			strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("op_lane_tp_cd"))+"]]></TD>");
        			strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("stup_flg"))+"]]></TD>");
        			strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("vvd_cd"))+"]]></TD>");
        			strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("lane_aply_fom_dt"))+"]]></TD>");
        			strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("lane_aply_to_dt"))+"]]></TD>");
        			strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("upd_usr_id"))+"]]></TD>");
        			strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("upd_dt"))+"]]></TD>");
        			strBuilder.append("</TR>");
	            }
	            //-------------------------------------------------------------------------------------------------
            } catch(Exception e){
                log.error("err " + e.toString(), e);
            }
	    }
	    strBuilder.append("</DATA>");  
	    return strBuilder.toString();
    }
}
