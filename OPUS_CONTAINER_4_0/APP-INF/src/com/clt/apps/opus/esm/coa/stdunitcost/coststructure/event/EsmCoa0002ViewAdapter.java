/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0002ViewAdapter.java
*@FileTitle : EsmCoa0002ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대 
* 1.0 Creation
* 2010.02.05 임옥영 품질검토 결과 반영 (사용하지 않는 지역변수 주석처리 realColNms) 
* 2010.12.15 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.coststructure.event;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.coa.common.basic.CommonBC;
import com.clt.apps.opus.esm.coa.common.basic.CommonBCImpl;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.DefaultViewAdapter;
import com.clt.framework.core.controller.html.HTMLAction;

/**
 * ESM_COA_0002 에 대한 ViewAdapter<br>
 * - ESM_COA_0002HTMLAction에서 작성<br>
 *
 * @author 김기대
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0002ViewAdapter extends DefaultViewAdapter {
	
    public EsmCoa0002ViewAdapter(){
    	super();
    }
    
	protected String makeDataTag(List list, String prefix) {
    	int totCnt  = list.size();  
    	
    	AbstractValueObject vo = (AbstractValueObject)list.get(0);
		//String realColNms[] = getColHeader(vo);
	    //String changedColNms[] = getChangedColNms(realColNms, prefix);
	      
	    if(vo.getMaxRows() > 0){
	      	totCnt = vo.getMaxRows();
	    }  
	    
	    StringBuilder strBuilder = new StringBuilder();
	    
	    //로직----------------------------------------
	    CommonBC commonBc = new CommonBCImpl();
        String tmpStr 	 = "";
        String tmpStrTxt = "";

        HashMap mnGrp 		= null;
        HashMap mnGrpTxt 	= null;
        HashMap subGrp 		= null;
        HashMap subGrpTxt 	= null;

        //ra 콤보관련
        String 	raMnCd 		= "";
        String 	raMnTxt 	= "";
        HashMap raSubGrpCd 	= null;
        HashMap raSubGrpTxt = null;	    
	    //----------------------------------------------
	    
	    strBuilder.append("<DATA TOTAL=\""+totCnt+"\">");
	    if(totCnt > 0){
	    	try{
	    		
	    		//로직-------------------------------------------------------------------------------------------------
                mnGrp 	 	= commonBc.getCodeCombo("mgrp_cost_nm", "mnGroup", "", "code");
                mnGrpTxt 	= commonBc.getCodeCombo("mgrp_cost_nm", "mnGroup", "", "name");

                subGrp 	  	= commonBc.getCodeCombo("sgrp_cost_nm", "subGroup", "", "code");
                subGrpTxt 	= commonBc.getCodeCombo("sgrp_cost_nm", "subGroup", "", "name");
                //
                raMnCd 	  	= commonBc.getIbCodeCombo("ra_mn_cost_nm","raMnGrp", "", "code");
                raMnTxt 	= commonBc.getIbCodeCombo("ra_mn_cost_nm","raMnGrp", "", "name");

                raSubGrpCd 	= commonBc.getCodeCombo("ra_sgrp_cost_nm", "raSubGrp", "", "code");
                raSubGrpTxt = commonBc.getCodeCombo("ra_sgrp_cost_nm", "raSubGrp", "", "name");
            
	            for(int i=0; i<totCnt; i++){
	            	Map colValues = ((AbstractValueObject)list.get(i)).getColumnValues();

	                if(mnGrp != null){
	                    int tIdx = 0;

	                    tmpStr = (String)mnGrp.get(JSPUtil.getNull((String)colValues.get("stnd_cost_tp_cd")));
	
	                    if(tmpStr.trim().startsWith("|")){
	                        tIdx = tmpStr.indexOf("|");
	                        tmpStr = tmpStr.substring(tIdx+1);
	                        tIdx = 0;
	                    }
	
	                    tmpStrTxt = (String)mnGrpTxt.get(JSPUtil.getNull((String)colValues.get("stnd_cost_tp_cd")));
	                    if(tmpStrTxt.trim().startsWith("|")){
	                        tIdx = tmpStrTxt.indexOf("|");
	                        tmpStrTxt = tmpStrTxt.substring(tIdx+1);
	                        tIdx = 0;
	                    }
	                }
	
	                if(!"".equals(raMnCd)){
	                    int tIdx = 0;
	                    if(raMnCd.startsWith("|")){
	                        tIdx = raMnCd.indexOf("|");
	                        raMnCd = raMnCd.substring(tIdx+1);
	                        tIdx = 0;
	                    }
	
	                    if(raMnTxt.startsWith("|")){
	                        tIdx = raMnTxt.indexOf("|");
	                        raMnTxt = raMnTxt.substring(tIdx+1);
	                        tIdx = 0;
	                    }
	                }
	
	                String mCd 		= JSPUtil.getNull((String)colValues.get("mgrp_cost_cd"));
	                String sCdCode 	= (String)subGrp.get(mCd);
	                String sCdTxt 	= ((String)subGrpTxt.get(mCd)).replaceAll("&", "&amp;");	//SJH.20141212.MOD

	                String raMCd 	= JSPUtil.getNull((String)colValues.get("ra_mn_cost_cd"));
	                String raSCd 	= (String)raSubGrpCd.get(raMCd);
	                String raSTxt 	= (String)raSubGrpTxt.get(raMCd);

	                strBuilder.append("<TR>");
	                strBuilder.append("    <TD>"+JSPUtil.getNull((String)colValues.get("delt_flg"))+"</TD>");
	                strBuilder.append("    <TD></TD>");
	                strBuilder.append("    <TD>"+JSPUtil.getNull((String)colValues.get("stnd_cost_tp_cd"))+"</TD>");
	                strBuilder.append("    <TD DATA-TYPE=\"dtCombo\" COMBO-TEXT=\""+tmpStrTxt+"\" COMBO-CODE=\""+ tmpStr+"\">"+JSPUtil.getNull((String)colValues.get("mgrp_cost_cd"))+"</TD>");
	                strBuilder.append("    <TD>"+JSPUtil.getNull((String)colValues.get("mgrp_cost_cd"))+"</TD>");
	                strBuilder.append("    <TD DATA-TYPE=\"dtCombo\" COMBO-TEXT=\""+sCdTxt+"\" COMBO-CODE=\""+sCdCode+"\">"+JSPUtil.getNull((String)colValues.get("sgrp_cost_cd"))+"</TD>");
	                strBuilder.append("    <TD>"+JSPUtil.getNull((String)colValues.get("sgrp_cost_cd"))+"</TD>");
	                strBuilder.append("    <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("stnd_cost_nm"))+"]]></TD>");
	                strBuilder.append("    <TD>"+JSPUtil.getNull((String)colValues.get("stnd_cost_cd"))+"</TD>");
	                strBuilder.append("    <TD>"+JSPUtil.getNull((String)colValues.get("perf_vw_cd"))+"</TD>");
	                strBuilder.append("    <TD>"+JSPUtil.getNull((String)colValues.get("acct_dp_seq"))+"</TD>");
	                strBuilder.append("    <TD>"+JSPUtil.getNull((String)colValues.get("hir_scp_flg"))+"</TD>");	               
	                strBuilder.append("    <TD DATA-TYPE=\"dtCombo\" COMBO-TEXT=\""+raMnTxt+"\" COMBO-CODE=\""+raMnCd+"\">"+JSPUtil.getNull((String)colValues.get("ra_mn_cost_cd"))+"</TD>");
	                strBuilder.append("    <TD>"+JSPUtil.getNull((String)colValues.get("ra_mn_cost_cd"))+"</TD>");
	                strBuilder.append("    <TD DATA-TYPE=\"dtCombo\" COMBO-TEXT=\""+raSTxt+"\" COMBO-CODE=\""+raSCd+"\">"+JSPUtil.getNull((String)colValues.get("ra_sgrp_cost_cd"))+"</TD>");
	                strBuilder.append("    <TD>"+JSPUtil.getNull((String)colValues.get("ra_sgrp_cost_cd"))+"</TD>");
	                strBuilder.append("    <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("ra_stnd_cost_desc"))+"]]></TD>");
	                strBuilder.append("    <TD>"+JSPUtil.getNull((String)colValues.get("ra_acct_cd"))+"</TD>");
	                strBuilder.append("    <TD>"+JSPUtil.getNull((String)colValues.get("ra_perf_vw_cd"))+"</TD>");
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

	protected String makeDataTag(DBRowSet rs, String prefix){        
        StringBuilder strBuilder = new StringBuilder();
        
        if(rs.isPivot()){
        	strBuilder.append(makePivotDataTag(rs));
        	return strBuilder.toString();
        }        
        
    	int totCnt  = getRowSetCnt(rs);//rs.getRowCount()
        
		//String realColNms[] = getColHeader(rs);
    	
    	//로직--------------------------------
    	CommonBC commonBc = new CommonBCImpl();
        String tmpStr 	 = "";
        String tmpStrTxt = "";

        HashMap mnGrp 		= null;
        HashMap mnGrpTxt 	= null;
        HashMap subGrp 		= null;
        HashMap subGrpTxt 	= null;

        //ra 콤보관련
        String 	raMnCd 		= "";
        String 	raMnTxt 	= "";
        HashMap raSubGrpCd 	= null;
        HashMap raSubGrpTxt = null;	     
        //--------------------------------------

    	try{
		    //String changedColNms[] = getChangedColNms(realColNms, prefix);
		      
		    if(rs.getMaxRows() > 0){
		      	totCnt = rs.getMaxRows();
		    }  
		    
		    strBuilder.append("<DATA TOTAL=\""+totCnt+"\">");
		    if(totCnt > 0){
		    		//로직-----------------------------------------------------------------------------
	                mnGrp 	 	= commonBc.getCodeCombo("mgrp_cost_nm", "mnGroup", "", "code");
	                mnGrpTxt 	= commonBc.getCodeCombo("mgrp_cost_nm", "mnGroup", "", "name");

	                subGrp 	  	= commonBc.getCodeCombo("sgrp_cost_nm", "subGroup", "", "code");
	                subGrpTxt 	= commonBc.getCodeCombo("sgrp_cost_nm", "subGroup", "", "name");
	                //
	                raMnCd 	  	= commonBc.getIbCodeCombo("ra_mn_cost_nm", "raMnGrp", "", "code");
	                raMnTxt 	= commonBc.getIbCodeCombo("ra_mn_cost_nm", "raMnGrp", "", "name");

	                raSubGrpCd 	= commonBc.getCodeCombo("ra_sgrp_cost_nm", "raSubGrp", "", "code");
	                raSubGrpTxt = commonBc.getCodeCombo("ra_sgrp_cost_nm", "raSubGrp", "", "name");

	                while(rs.next()){
		                if(mnGrp != null){
		                    int tIdx = 0;

		                    tmpStr = (String)mnGrp.get(JSPUtil.getNull((String)rs.getString("stnd_cost_tp_cd")));
		
		                    if(tmpStr.trim().startsWith("|")){
		                        tIdx = tmpStr.indexOf("|");
		                        tmpStr = tmpStr.substring(tIdx+1);
		                        tIdx = 0;
		                    }
		
		                    tmpStrTxt = (String)mnGrpTxt.get(JSPUtil.getNull((String)rs.getString("stnd_cost_tp_cd")));
		                    if(tmpStrTxt.trim().startsWith("|")){
		                        tIdx = tmpStrTxt.indexOf("|");
		                        tmpStrTxt = tmpStrTxt.substring(tIdx+1);
		                        tIdx = 0;
		                    }
		                }	
		                
		                if(!"".equals(raMnCd)){
		                    int tIdx = 0;
		                    if(raMnCd.startsWith("|")){
		                        tIdx = raMnCd.indexOf("|");
		                        raMnCd = raMnCd.substring(tIdx+1);
		                        tIdx = 0;
		                    }
		
		                    if(raMnTxt.startsWith("|")){
		                        tIdx = raMnTxt.indexOf("|");
		                        raMnTxt = raMnTxt.substring(tIdx+1);
		                        tIdx = 0;
		                    }
		                }
		                
		                String mCd 		= JSPUtil.getNull((String)rs.getString("mgrp_cost_cd"));
		                String sCdCode 	= (String)subGrp.get(mCd);
		                String sCdTxt 	= (String)subGrpTxt.get(mCd);

		                String raMCd 	= JSPUtil.getNull((String)rs.getString("ra_mn_cost_cd"));
		                String raSCd 	= (String)raSubGrpCd.get(raMCd);
		                String raSTxt 	= (String)raSubGrpTxt.get(raMCd);	
		                
		                strBuilder.append("<TR>");
		                strBuilder.append("    <TD>"+JSPUtil.getNull((String)rs.getString("delt_flg"))+"</TD>");
		                strBuilder.append("    <TD></TD>");
		                strBuilder.append("    <TD>"+JSPUtil.getNull((String)rs.getString("stnd_cost_tp_cd"))+"</TD>");
		                strBuilder.append("    <TD DATA-TYPE=\"dtCombo\" COMBO-TEXT=\""+tmpStrTxt+"\" COMBO-CODE=\""+ tmpStr+"\">"+JSPUtil.getNull((String)rs.getString("mgrp_cost_cd"))+"</TD>");
		                strBuilder.append("    <TD>"+JSPUtil.getNull((String)rs.getString("mgrp_cost_cd"))+"</TD>");
		                strBuilder.append("    <TD DATA-TYPE=\"dtCombo\" COMBO-TEXT=\""+sCdTxt+"\" COMBO-CODE=\""+sCdCode+"\">"+JSPUtil.getNull((String)rs.getString("sgrp_cost_cd"))+"</TD>");
		                strBuilder.append("    <TD>"+JSPUtil.getNull((String)rs.getString("sgrp_cost_cd"))+"</TD>");
		                strBuilder.append("    <TD><![CDATA["+JSPUtil.getNull((String)rs.getString("stnd_cost_nm"))+"]]></TD>");
		                strBuilder.append("    <TD>"+JSPUtil.getNull((String)rs.getString("stnd_cost_cd"))+"</TD>");
		                strBuilder.append("    <TD>"+JSPUtil.getNull((String)rs.getString("perf_vw_cd"))+"</TD>");
		                strBuilder.append("    <TD>"+JSPUtil.getNull((String)rs.getString("acct_dp_seq"))+"</TD>");
		                strBuilder.append("    <TD>"+JSPUtil.getNull((String)rs.getString("hir_scp_flg"))+"</TD>");		                
		                strBuilder.append("    <TD DATA-TYPE=\"dtCombo\" COMBO-TEXT=\""+raMnTxt+"\" COMBO-CODE=\""+raMnCd+"\">"+JSPUtil.getNull((String)rs.getString("ra_mn_cost_cd"))+"</TD>");
		                strBuilder.append("    <TD>"+JSPUtil.getNull((String)rs.getString("ra_mn_cost_cd"))+"</TD>");
		                strBuilder.append("    <TD DATA-TYPE=\"dtCombo\" COMBO-TEXT=\""+raSTxt+"\" COMBO-CODE=\""+raSCd+"\">"+JSPUtil.getNull((String)rs.getString("ra_sgrp_cost_cd"))+"</TD>");
		                strBuilder.append("    <TD>"+JSPUtil.getNull((String)rs.getString("ra_sgrp_cost_cd"))+"</TD>");
		                strBuilder.append("    <TD><![CDATA["+JSPUtil.getNull((String)rs.getString("ra_stnd_cost_desc"))+"]]></TD>");
		                strBuilder.append("    <TD>"+JSPUtil.getNull((String)rs.getString("ra_acct_cd"))+"</TD>");
		                strBuilder.append("    <TD>"+JSPUtil.getNull((String)rs.getString("ra_perf_vw_cd"))+"</TD>");
		                strBuilder.append("</TR>"); 		                
	                }
		    		//---------------------------------------------------------------------------------------
	            
		    }
	    
		    strBuilder.append("</DATA>");  
        }
        catch(SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
        catch(Exception ex){
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex.getMessage());
        }
        return strBuilder.toString();        
    }
}
