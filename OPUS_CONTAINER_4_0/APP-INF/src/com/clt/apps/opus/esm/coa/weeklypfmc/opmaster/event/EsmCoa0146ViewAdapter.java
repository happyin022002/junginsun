/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0146ViewAdapter.java
*@FileTitle : EsmCoa0146ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대 
* 1.0 Creation
* 2011.01.27 최윤성 [CHM-201108537-01] Create VSL Table 수정
*  - OPR, OPR2 동적 메소드 적용
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.event;

import java.sql.SQLException;
import java.util.HashMap;

import com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr;
import com.clt.apps.opus.esm.coa.common.basic.CommonBC;
import com.clt.apps.opus.esm.coa.common.basic.CommonBCImpl;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.DefaultViewAdapter;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.core.layer.event.EventException;

/**
 * ESM_COA_0146 에 대한 ViewAdapter<br>
 * - ESM_COA_0146HTMLAction에서 작성<br>
 *
 * @author 김기대
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0146ViewAdapter extends DefaultViewAdapter {
	
    public EsmCoa0146ViewAdapter(){
    	super();
    }
    
	/**
	 * View Adapter 생성시 자동으로 호출된다.<br>
	 *  - RowSet 데이타에 대해서 XML을 구현한 문자열을 구현하여 준다.<br>
	 * 
	 * @param DBRowSet rs
	 * @param String prefix
	 * @return String
	 * @exception EventException
	 */	      
    protected String makeDataTag(DBRowSet rs, String prefix){
        StringBuilder strBuilder = new StringBuilder();
        
        if(rs.isPivot()){
        	strBuilder.append(makePivotDataTag(rs));
        	return strBuilder.toString();
        }        
        
    	int totCnt  = getRowSetCnt(rs);//rs.getRowCount()
    	
    	//로직----------------------------------------
	    CommonBC commonBc = new CommonBCImpl();
	    String comboCode = " | ";
		String vOPR  = null;
		String vOPR2 = null;
		HashMap opr  = null;
		HashMap opr2 = null;
		
		try{
    		opr  = commonBc.getCodeCombo("vsl_oshp_cd", "VslOwner", ConstantMgr.getCompanyCode(), "code"); 
    		opr2 = commonBc.getCodeCombo("vsl_oshp_cd", "VslOwner", "OTH", "code");
    		
    		vOPR  = (String)opr.get("");
    		vOPR2 = (String)opr2.get("");
    		
    		if(!"".equals(vOPR)){
                int tIdx = 0;
                if(vOPR.startsWith("|")){
                    tIdx = vOPR.indexOf("|");
                    vOPR = vOPR.substring(tIdx+1);
                    tIdx = 0;
                }
            }
    		
    		if(!"".equals(vOPR2)){
                int tIdx = 0;
                if(vOPR2.startsWith("|")){
                    tIdx = vOPR2.indexOf("|");
                    vOPR2 = vOPR2.substring(tIdx+1);
                    tIdx = 0;
                }
            }
    		
		}catch(Exception e){
			log.error("err " + e.toString(), e);
		}
		//----------------------------------------------
		
    	try{
		    if(rs.getMaxRows() > 0){
		      	totCnt = rs.getMaxRows();
		    }    

		    strBuilder.append("<DATA TOTAL=\""+totCnt+"\">");
		    if(totCnt > 0){
		    		while(rs.next()){
		    			int i=7;	// 6개 항목은 직접 append 했으므로 6 부터.
		    			
		    			if(!JSPUtil.getNull(rs.getString("VOP_CD")).equals("")) comboCode = "|" + (JSPUtil.getNull(rs.getString("VOP_CD")).equals("OTH")?vOPR2:vOPR);
		    			
		    			strBuilder.append("<TR ");
    					if(JSPUtil.getNull(rs.getString("cre_usr_id")).equals("BATCH")){ 
    						strBuilder.append("BGCOLOR='243,252,220'");
    					}
    					strBuilder.append(">");		    			
    					strBuilder.append("<TD></TD>");
    					
    					strBuilder.append("	<TD><![CDATA["+JSPUtil.getNull(rs.getString("IBFLAG"))+"]]></TD>\n");
    					strBuilder.append("	<TD><![CDATA["+JSPUtil.getNull(rs.getString("VSL_SEQ"))+"]]></TD>\n");
    					strBuilder.append("	<TD><![CDATA["+JSPUtil.getNull(rs.getString("VSL_CD"))+"]]></TD>\n");
    					strBuilder.append("	<TD><![CDATA["+JSPUtil.getNull(rs.getString("VSL_TP_CD"))+"]]></TD>\n");
    					strBuilder.append("	<TD><![CDATA["+JSPUtil.getNull(rs.getString("VOP_CD"))+"]]></TD>\n");
    					strBuilder.append("	<TD DATA-TYPE=\"dtCombo\" COMBO-TEXT=\""+ comboCode +"\" COMBO-CODE=\""+ comboCode +"\"><![CDATA["+JSPUtil.getNull(rs.getString("VSL_OSHP_CD"))+"]]></TD>\n");
    					
		    			for (int j = 6 ; j < rs.getMetaData().getColumnCount() ; j++) {
		    				strBuilder.append("<TD><![CDATA["+JSPUtil.getNull(rs.getString(i++))+"]]></TD>");
			    		}
			    		
			    		strBuilder.append("</TR>");
		    		}
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
