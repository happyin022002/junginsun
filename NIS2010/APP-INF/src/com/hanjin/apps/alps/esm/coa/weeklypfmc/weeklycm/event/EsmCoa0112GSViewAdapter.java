/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0112GSViewAdapter.java
*@FileTitle : EsmCoa0112GSViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 박수훈
*@LastVersion : 1.0
* 2009.09.18 박수훈 최초생성
* 1.0 최초 생성
* 2010.02.05 임옥영 품질검토 결과 반영 (사용하지 않는 지역변수 주석처리 realColNms) 
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.event;

import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * EsmCoa0112GSViewAdapter 에 대한 ViewAdapter<br>
 *  EsmCoa0112GSViewAdapter 작성<br>
 *
 * @author 박수훈
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0112GSViewAdapter extends DefaultViewAdapter {
	
    public EsmCoa0112GSViewAdapter(){
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
    protected String makeDataTag(List list, String prefix) {
    	StringBuilder strBuilder = new StringBuilder();

    	int totCnt  = list.size(); 
    	
    	String ls_rslt_cd  = null;
		String ls_delt_flg = null;
		String ls_color    = null;
		String ls_hidden   = null;
    	
    	AbstractValueObject vo = (AbstractValueObject)list.get(0);
	    //String realColNms[] = getColHeader(vo);
	      
	    if(vo.getMaxRows() > 0){
	      	totCnt = vo.getMaxRows();
	    }      
	    try{
		    strBuilder.append("<DATA TOTAL='"+totCnt+"'>");
		    if(totCnt > 0){
	            for(int i=0; i<totCnt; i++){
	            	Map colValues = ((AbstractValueObject)list.get(i)).getColumnValues();
	            	 ls_rslt_cd = String.valueOf(colValues.get("rslt_cd"));  
	            	 ls_delt_flg = String.valueOf(colValues.get("delt_flg"));  
	            	
	            	
	 				if (ls_rslt_cd.equals("A")){ 
						ls_color = " COLOR='black'";
					}else if (ls_rslt_cd.equals("B")) {
						ls_color = " COLOR='blue'";
					}else if (ls_rslt_cd.equals("C")) {					
						ls_color = " COLOR='blue'";					
					}			
					
					if (ls_delt_flg.equals("Y")){ 
						ls_color = " COLOR='red'";
					}
					
					// Both Hidden처리 
					if (ls_rslt_cd.equals("B")){
						ls_hidden = " HIDDEN='TRUE'";
					}else{
						ls_hidden = " HIDDEN='FALSE'";
					}
					
					strBuilder.append("<TR "+ls_color+" "+ls_hidden+">	");
					strBuilder.append("\n    <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("ibflag"))+"]]></TD>");
					strBuilder.append("\n    <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("rslt_cd"))+"]]></TD>");
					strBuilder.append("\n    <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("rslt"))+"]]></TD>");
					strBuilder.append("\n    <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("cost_yrmon"))+"]]></TD>");
					strBuilder.append("\n    <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("cost_wk"))+"]]></TD>");
					strBuilder.append("\n    <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("mon_tgt_flg"))+"]]></TD>");
					strBuilder.append("\n    <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("delt_flg"))+"]]></TD>");
					strBuilder.append("\n    <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("vvd"))+"]]></TD>");
					strBuilder.append("\n    <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("trd_cd"))+"]]></TD>");
					strBuilder.append("\n    <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("rlane_cd"))+"]]></TD>");
					strBuilder.append("\n    <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("ioc_cd"))+"]]></TD>");
					strBuilder.append("\n    <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("lst_lodg_port_cd"))+"]]></TD>");
					strBuilder.append("\n    <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("vsl_cd"))+"]]></TD>");
					strBuilder.append("\n    <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("skd_voy_no"))+"]]></TD>");
					strBuilder.append("\n    <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("dir_cd"))+"]]></TD>");
					
					strBuilder.append("\n</TR>");  	
	            }
		    }
		    strBuilder.append("\n</DATA>");
		    
        } catch(Exception e){
            log.error("err " + e.toString(), e);
        }
	    
	    return strBuilder.toString();
    }    
}