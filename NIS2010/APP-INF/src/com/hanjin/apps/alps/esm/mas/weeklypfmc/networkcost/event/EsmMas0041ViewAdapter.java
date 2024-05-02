/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0041ViewAdapter.java
*@FileTitle : EsmMas0041ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대 
* 1.0 Creation
=========================================================
* History
* 2011.04.18 최윤성 [CHM-201110236-01] Bunker Fee 메뉴 컬럼 추가
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.event;

import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ESM_MAS_0041 에 대한 ViewAdapter<br>
 * - ESM_MAS_0041HTMLAction에서 작성<br>
 *
 * @author 김기대
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0041ViewAdapter extends DefaultViewAdapter {
	
    public EsmMas0041ViewAdapter(){
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
    	int totCnt  = list.size();  
    	
    	AbstractValueObject vo = (AbstractValueObject)list.get(0);
	      
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
                    strBuilder.append("<TR>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("flag"         ))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("cost_yrmon"   ))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("cost_wk"      ))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("trd_cd"       ))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("sub_trd_cd"   ))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("slan_cd"      ))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("rlane_cd"     ))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("dir_cd"       ))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("hul_bnd_cd"       ))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("vsl_info")).replace('/', ',').substring(1)+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("vsl_clss_capa"))+"</TD>");                    
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("foil_csm"     ))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("foil_avg_csm" ))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("foil_uc_amt"  ))+"</TD>");
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
