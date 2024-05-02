/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0039ViewAdapter.java
*@FileTitle : EsmCoa0039ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대 
* 1.0 Creation
* 2010.02.05 임옥영 품질검토 결과 반영 (사용하지 않는 지역변수 주석처리 realColNms) 
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.event;

import java.util.List;
import java.util.Map;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.DefaultViewAdapter;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.core.layer.event.EventException;

/**
 * ESM_BSA_0039 에 대한 ViewAdapter<br>
 * - ESM_BSA_0039HTMLAction에서 작성<br>
 *
 * @author 김기대
 * @see HTMLAction 참조
 * @since J2EE 1.6 
 */
public class EsmCoa0039ViewAdapter extends DefaultViewAdapter {
	
    public EsmCoa0039ViewAdapter(){
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
	    //String realColNms[] = getColHeader(vo);
	      
	    if(vo.getMaxRows() > 0){
	      	totCnt = vo.getMaxRows();
	    }  
	    
	    StringBuilder strBuilder = new StringBuilder();
	    
	    //로직----------------------------------------

	    //----------------------------------------------
	    
	    strBuilder.append("<DATA TOTAL=\""+totCnt+"\">");
	    if(totCnt > 0){
	    	try{
	    		//로직-------------------------------------------------------------------------------------------------            
	            for(int i=0; i<totCnt; i++){
	            	Map colValues = ((AbstractValueObject)list.get(i)).getColumnValues();    
                    strBuilder.append("<TR ");
                    if(Float.parseFloat(JSPUtil.getNull((String)colValues.get("sea_dys")))<0 
                    	|| Float.parseFloat(JSPUtil.getNull((String)colValues.get("port_dys")))<0
                    	|| Float.parseFloat(JSPUtil.getNull((String)colValues.get("ttl_tz_dys")))<0){
                    	strBuilder.append("BGCOLOR='247,231,236'");
                    }
                    strBuilder.append(">");
                    strBuilder.append("<TD></TD>");
                    strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("cost_yrwk"       ))+"]]></TD>");
                    strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("vsl_cd"          ))+"]]></TD>");
                    strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("skd_voy_no"      ))+"]]></TD>");
                    strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("dir_cd"          ))+"]]></TD>");
                    strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("conti_nm"        ))+"]]></TD>");
                    strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("slan_cd"         ))+"]]></TD>");
                    strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("trd_cd"          ))+"]]></TD>");
                    strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("rlane_cd"        ))+"]]></TD>");
                    strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("ioc_cd"          ))+"]]></TD>");
                    strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("loc_cd"          ))+"]]></TD>");
                    strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("vsl_dbl_call_seq"))+"]]></TD>");
                    strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("clpt_seq"        ))+"]]></TD>");
                    strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("port_dys"        ))+"]]></TD>");
                    strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("sea_dys"         ))+"]]></TD>");
                    strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("ttl_tz_dys"      ))+"]]></TD>");
                    strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("aply_voy_rto"    ))+"]]></TD>");                    
                    strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("pndlm_rto"       ))+"]]></TD>");		//20151029.ADD
                    strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("vvd_rmk"         ))+"]]></TD>");
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
