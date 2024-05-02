/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0335ViewAdapter.java
*@FileTitle : EsmMas0335ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.13
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2015.01.13 김종옥 
* 1.0 Creation
* 
* 2015.10.26  1Cycle 이 안되면 TTL 의 배경색 노란색으로 변경.
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
 * ESM_MAS_0335 에 대한 ViewAdapter<br>
 * - ESM_MAS_0335HTMLAction에서 작성<br>
 *
 * @author 김종옥
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0335ViewAdapter extends DefaultViewAdapter {
	
    public EsmMas0335ViewAdapter(){
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
    	String rowBgColor = "";
    	
    	AbstractValueObject vo = (AbstractValueObject)list.get(0);
	      
	    if(vo.getMaxRows() > 0){
	      	totCnt = vo.getMaxRows();
	    }  
	    
	    StringBuilder strBuilder = new StringBuilder();
	    
	    strBuilder.append("<DATA TOTAL=\""+totCnt+"\">");
	    if(totCnt > 0){
	    	try{
	    		
	    		//로직-------------------------------------------------------------------------------------------------            
	            for(int i=0; i<totCnt; i++){
	            	Map colValues = ((AbstractValueObject)list.get(i)).getColumnValues();  
	            	String costYrmon = String.valueOf(colValues.get("cost_yrmon"));
	            	String misTtl = String.valueOf(colValues.get("mis_ttl"));
	            	if(costYrmon.equals("TTL")) {
	            		if( colValues.get("cycle_flg")!= null && "N".equals( colValues.get("cycle_flg") ))
	            			rowBgColor="BGCOLOR=\"255,255,0\"";
	            		else
	            			rowBgColor="BGCOLOR=\"247,231,236\"";
					}else {
						rowBgColor="";
					}
	            	
	            	if( misTtl!=null && misTtl.equals("Y"))
	            		rowBgColor="BGCOLOR=\"245,46,51\"";
	            	
                    strBuilder.append("<TR>");
                    strBuilder.append("  <TD "+rowBgColor+"></TD>");
                    strBuilder.append("  <TD "+rowBgColor+">"+JSPUtil.getNull((String)colValues.get("cost_yrmon"))+"</TD>");  
                    strBuilder.append("  <TD "+rowBgColor+">"+JSPUtil.getNull((String)colValues.get("cost_wk"))+"</TD>");  
                    strBuilder.append("  <TD "+rowBgColor+">"+JSPUtil.getNull((String)colValues.get("trd_cd"))+"</TD>");      
                    strBuilder.append("  <TD "+rowBgColor+">"+JSPUtil.getNull((String)colValues.get("sub_trd_cd"))+"</TD>");  
                    strBuilder.append("  <TD "+rowBgColor+">"+JSPUtil.getNull((String)colValues.get("rlane_cd"))+"</TD>");    
                    strBuilder.append("  <TD "+rowBgColor+">"+JSPUtil.getNull((String)colValues.get("dir_cd"))+"</TD>");      
                    strBuilder.append("  <TD "+rowBgColor+">"+JSPUtil.getNull((String)colValues.get("hul_bnd_cd"))+"</TD>");  
                    strBuilder.append("  <TD "+rowBgColor+">"+JSPUtil.getNull((String)colValues.get("vsl_oshp_cd"))+"</TD>");
                    strBuilder.append("  <TD "+rowBgColor+">"+JSPUtil.getNull((String)colValues.get("vsl_clss_capa"))+"</TD>");
                    strBuilder.append("  <TD "+rowBgColor+">"+JSPUtil.getNull((String)colValues.get("vvd"))+"</TD>");         
                    strBuilder.append("  <TD "+rowBgColor+">"+JSPUtil.getNull((String)colValues.get("ttl_amt"))+"</TD>");     
                    strBuilder.append("  <TD "+rowBgColor+">"+JSPUtil.getNull((String)colValues.get("ttl_days"))+"</TD>");    
                    strBuilder.append("  <TD "+rowBgColor+">"+JSPUtil.getNull((String)colValues.get("eff_yrmon"))+"</TD>");   
                    strBuilder.append("  <TD "+rowBgColor+">"+JSPUtil.getNull((String)colValues.get("dhir_amt"))+"</TD>");    
                    strBuilder.append("  <TD "+rowBgColor+">"+JSPUtil.getNull((String)colValues.get("vvd_bsa_capa"))+"</TD>");
                    strBuilder.append("  <TD "+rowBgColor+">"+JSPUtil.getNull((String)colValues.get("teu_uc_amt"))+"</TD>");  
                    strBuilder.append("  <TD "+rowBgColor+">"+JSPUtil.getNull((String)colValues.get("cycle_flg"))+"</TD>");   
                    strBuilder.append("  <TD "+rowBgColor+">"+JSPUtil.getNull((String)colValues.get("stnd_cost_cd"))+"</TD>");
                    strBuilder.append("  <TD "+rowBgColor+">"+JSPUtil.getNull((String)colValues.get("vsl_cd"))+"</TD>");      
                    strBuilder.append("  <TD "+rowBgColor+">"+JSPUtil.getNull((String)colValues.get("skd_voy_no"))+"</TD>");
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