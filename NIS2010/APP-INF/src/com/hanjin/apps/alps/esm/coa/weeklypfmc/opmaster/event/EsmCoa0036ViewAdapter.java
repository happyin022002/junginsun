/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0036ViewAdapter.java
*@FileTitle : EsmCoa0036ViewAdapter
*Open Issues :
*Change history :
*2009.12.23 최인경 IBSHEET컬럼 2개 추가
*
*
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대 
* 1.0 Creation
* 
* 2012.09.17 이석준[CHM-201220161] 실시간 영업현황 관련 UI- Create Lane Table 기능 추가
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
public class EsmCoa0036ViewAdapter extends DefaultViewAdapter {
	
    public EsmCoa0036ViewAdapter(){
    	super();
    }
    
	/**
	 * View Adapter 생성시 자동으로 호출된다. <br>
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
	    		String  tmpStr  = " | ";
	    		HashMap<String, String> subTrd	= null;
	    		CommonBC commonBC = new CommonBCImpl();
	    		subTrd = commonBC.getCodeCombo("sub_trd_cd", "subTrade", "", "code");
	    	    //----------------------------------------------	    		
	    		
	    		//로직-------------------------------------------------------------------------------------------------            
	            for(int i=0; i<totCnt; i++){
	            	Map colValues = ((AbstractValueObject)list.get(i)).getColumnValues();          	

        			if(subTrd != null){
        				tmpStr = (String)subTrd.get(JSPUtil.getNull((String)colValues.get("trd_cd")));
        				if(tmpStr == null)tmpStr = " | ";
        			}                    
                    
        			strBuilder.append("<TR>");
        			strBuilder.append("  <TD></TD>");
        			strBuilder.append("  <TD>R</TD>");
        			strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("trd_cd"))+"]]></TD>");
        			strBuilder.append("  <TD DATA-TYPE=\"dtCombo\" COMBO-TEXT=\""+ tmpStr +"\" COMBO-CODE=\""+ tmpStr +"\"><![CDATA[ "+JSPUtil.getNull((String)colValues.get("sub_trd_cd"))+"]]></TD>");
        			strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("slan_cd"))+"]]></TD>");
        			strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("rlane_cd"))+"]]></TD>");
        			strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("dir_cd"))+"]]></TD>");
        			strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("hul_bnd_cd"))+"]]></TD>");
        			strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("ias_rgn_cd"))+"]]></TD>");
        			strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("ioc_cd"))+"]]></TD>");
        			strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("vsl_lane_tp_cd"))+"]]></TD>");
        			strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("op_lane_tp_cd"))+"]]></TD>");
        			strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("pctl_lane_chk_flg"))+"]]></TD>");
        			strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("stup_flg"))+"]]></TD>");
        			strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("sctr_prc_flg"))+"]]></TD>");
        			strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("trns_pcf_flg"))+"]]></TD>");
        			strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("eur_flg"))+"]]></TD>");
        			strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("trns_atlan_flg"))+"]]></TD>");
        			strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("intr_asia_flg"))+"]]></TD>");
        			strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("trnk_ipt_flg"))+"]]></TD>");
        			strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("lod_spl_cng_flg"))+"]]></TD>");
        			strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("rvs_bnd_flg"))+"]]></TD>");
        			strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("mkt_rt_flg"))+"]]></TD>");
        			strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("sub_trd_desc"))+"]]></TD>");
        			strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("lane_tp_his_flg"))+"]]></TD>");
        			strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("delt_flg"))+"]]></TD>");
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
