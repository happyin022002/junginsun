/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0321ViewAdapter.java
*@FileTitle : EsmMas0321ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.13
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2015.01.13 김종옥 
* 1.0 Creation
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
 * ESM_MAS_0321 에 대한 ViewAdapter<br>
 * - ESM_MAS_0321HTMLAction에서 작성<br>
 *
 * @author 김종옥
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0321ViewAdapter extends DefaultViewAdapter {
	
    public EsmMas0321ViewAdapter(){
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
    	
    	double average = 0;
    	double weekyestimation = 0;
    	double weekyAvg = 0;
    	double rate = 0;
    	
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
	            	String lvl = String.valueOf(colValues.get("lvl"));
                    strBuilder.append("<TR>");
                    strBuilder.append("  <TD></TD>");
	                
					if(lvl.equals("0"))
						strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("cost_yrmon"))+"</TD>");
					else if(lvl.equals("1"))
						strBuilder.append("  <TD>Average</TD>");
					else if(lvl.equals("2"))
						strBuilder.append("  <TD>Weeky estimation</TD>");
					else
						strBuilder.append("  <TD></TD>");

					if(lvl.equals("0")){
		                strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("cost_wk"))+"</TD>");
						strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("trd_cd"))+"</TD>");
		                strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("sub_trd_cd"))+"</TD>");
					}else{
						strBuilder.append("  <TD></TD>");
						strBuilder.append("  <TD></TD>");
						strBuilder.append("  <TD></TD>");
					}
					
	                strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("rlane_cd"))+"</TD>");
	                strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("dir_cd"))+"</TD>");
	                strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("hul_bnd_cd"))+"</TD>");
	                strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("vsl_cd"))+"</TD>");

					if(lvl.equals("3"))
						strBuilder.append("  <TD>Weekly Avg - Avg</TD>");
					else if(lvl.equals("4"))
						strBuilder.append("  <TD>변화비율</TD>");
					else
		                strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("vsl_clss_capa"))+"</TD>");
					
					if(lvl.equals("1"))
						average = Double.parseDouble(JSPUtil.getNull((String)colValues.get("old_foil_uc_amt"),"0"));
					else if(lvl.equals("2"))
						weekyestimation = Double.parseDouble(JSPUtil.getNull((String)colValues.get("old_foil_uc_amt"),"0"));
					
					if(lvl.equals("3")){
				    	weekyAvg = weekyestimation - average;
						strBuilder.append("  <TD>"+weekyAvg+"</TD>");
					}						
					else if(lvl.equals("4")){
						rate = weekyAvg/average*100;
						strBuilder.append("  <TD>"+rate+"</TD>");
					}
					else				
						strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("old_foil_uc_amt"))+"</TD>");
	                
	                if(lvl.equals("1"))
						strBuilder.append("  <TD></TD>");
					else if(lvl.equals("2"))
						strBuilder.append("  <TD></TD>");
					else if(lvl.equals("3") || lvl.equals("4"))
						strBuilder.append("  <TD></TD>");
					else 
						strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("foil_uc_amt"))+"</TD>");
	                
	                strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("wk_avg_uc_amt"))+"</TD>");
	                strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("wk_estm_uc_amt"))+"</TD>");
	                strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("trd_cd_gp"))+"</TD>");
	                strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("lvl"))+"</TD>");
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
