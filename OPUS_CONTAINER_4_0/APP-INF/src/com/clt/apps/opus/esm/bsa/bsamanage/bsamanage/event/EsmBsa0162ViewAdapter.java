
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBsa0021ViewAdapter.java
*@FileTitle : EsmBsa0021ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대
* 1.0 Creation
=========================================================
* History :
* 2010.10.04 이행지 [CHM-201005758-01] BSA  Architecture 위배사항 수정 (CommonSC)
=========================================================*/
package com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.event;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.esm.bsa.common.basic.CommonBC;
import com.clt.apps.opus.esm.bsa.common.basic.CommonBCImpl;
import com.clt.apps.opus.esm.bsa.common.vo.CommonBsaRsVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.DefaultViewAdapter;
import com.clt.framework.core.controller.html.HTMLAction;

/**
 * ESM_BSA_0028 에 대한 ViewAdapter<br>
 * - ESM_BSA_0028HTMLAction에서 작성<br>
 *
 * @author 남궁진호
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBsa0162ViewAdapter extends DefaultViewAdapter {

	CommonBC comBC = new CommonBCImpl();
	
    public EsmBsa0162ViewAdapter(){
    	super();
    }
    
    @SuppressWarnings("unchecked")
	protected String makeDataTag(List<AbstractValueObject> list, String prefix) {
    	log.debug("########### EsmBsa0162ViewAdapter.makeDataTag(List<AbstractValueObject> list, String prefix) ########### [START]");
    	CommonBsaRsVO rsVo = (CommonBsaRsVO)list.get(0);
    	CommonBsaRsVO[] arrayVo = rsVo.getCommonBsaRsVOArray();
		
		log.debug("arrayVo.length = " + arrayVo.length);
		
		DBRowSet rowSet1 = arrayVo[0].getDbRowset();
		DBRowSet rowSet2 = arrayVo[1].getDbRowset();
		
		
		if(rowSet1 == null || rowSet2 == null ){
			if(rowSet1 == null){
				log.debug("rowSet1 은 널입니다.");
			}			
			if(rowSet2 == null){
				log.debug("rowSet2 은 널입니다.");
			}
			return "";
		}
		log.debug("getRowSetCnt(rowSet1) = " + getRowSetCnt(rowSet1));
		log.debug("getRowSetCnt(rowSet2) = " + getRowSetCnt(rowSet2));
		// 첫번째 RowSet ========================================================================================== S
		// =======================================================================================================
		String[] headText = {"","",""};
		int headCnt = rowSet1.getRowCount();
		
		String bsa_op_jb_cd = "";
		
    	int totCnt  = getRowSetCnt(rowSet1);//rs.getRowCount()
    	
    	log.debug("totCnt = " + totCnt);
        
    	try{
		    if(rowSet1.getMaxRows() > 0){
		      	totCnt = rowSet1.getMaxRows();
		    }  
		    
		    if(totCnt > 0){
		        StringBuffer sb1 = new StringBuffer();											//SJH.20150508.소스품질      		
		        StringBuffer sb2 = new StringBuffer();
		        StringBuffer sb3 = new StringBuffer();
		        
	    		while(rowSet1.next()){
	    			
    				bsa_op_jb_cd = JSPUtil.getNull(rowSet1.getString("bsa_op_jb_cd"));
//    				headText[0] = headText[0] + "|" + bsa_op_jb_cd;
//    				headText[1] = headText[1] + "|" + JSPUtil.getNull(rowSet1.getString("bsa_op_jb_nm"));
//    				headText[2] = headText[2] + "|" + JSPUtil.getNull(rowSet1.getString("crr_cd"));
    				sb1.append("|").append(bsa_op_jb_cd);										//SJH.20150508.소스품질                    
    				sb2.append("|").append(JSPUtil.getNull(rowSet1.getString("bsa_op_jb_nm")));
    				sb3.append("|").append(JSPUtil.getNull(rowSet1.getString("crr_cd")));
    				headText[0] = sb1.toString();												//SJH.20150508.소스품질 
    				headText[1] = sb2.toString();	
    				headText[2] = sb3.toString();	    				
    				
	    		}
		    }
        }
        catch(SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
        catch(Exception ex){
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex.getMessage());
        }
        // =======================================================================================================
        // 첫번째 RowSet ========================================================================================== E
        
        
        // 두번째 RowSet ========================================================================================== S
        // =======================================================================================================
        
        StringBuilder strBuilder = new StringBuilder();
        if(rowSet2.isPivot()){
        	strBuilder.append(makePivotDataTag(rowSet2));
        	return strBuilder.toString();
        }        
        
    	int totCnt2  = getRowSetCnt(rowSet2);//rs.getRowCount()
    	
    	log.debug("totCnt2 = " + totCnt2);
        
    	try{
		    if(rowSet2.getMaxRows() > 0){
		      	totCnt2 = rowSet2.getMaxRows();
		    }  
		    
		    strBuilder.append("<DATA TOTAL=\""+totCnt2+"\">");
		    if(totCnt2 > 0){
	    		String vRLane = " | ";
				HashMap rLane  = null;
				rLane  = comBC.getCodeIBCombo("rLane4");
				
	    		
				while(rowSet2.next()){
	    			if(rLane != null)  vRLane = "|" + rLane.get(JSPUtil.getNull(rowSet2.getString("trd_cd")));
	    			
	    			String tdText = "DATA-TYPE=\"dtCombo\" COMBO-TEXT="+"\""+ vRLane +"\""+" COMBO-CODE="+"\""+ vRLane+"\"";
	    			
					strBuilder.append("<TR>");
					strBuilder.append("  <TD></TD>");
					strBuilder.append("  <TD>R</TD>");
					
					strBuilder.append("  <TD>"+JSPUtil.getNull((String)rowSet2.getString("grp"			))+"</TD>");
					strBuilder.append("  <TD>"+JSPUtil.getNull((String)rowSet2.getString("seq"  		))+"</TD>");
					strBuilder.append("  <TD>"+JSPUtil.getNull((String)rowSet2.getString("vvd_cd"		))+"</TD>");
					strBuilder.append("  <TD>"+JSPUtil.getNull((String)rowSet2.getString("bsa_slt_prc_fm_dt"	))+"</TD>");
					strBuilder.append("  <TD>"+JSPUtil.getNull((String)rowSet2.getString("bsa_slt_prc_to_dt"	))+"</TD>");						
					strBuilder.append("  <TD>"+JSPUtil.getNull((String)rowSet2.getString("trd_cd"				))+"</TD>");
					strBuilder.append("  <TD " + tdText +" ><![CDATA["+JSPUtil.getNull((String)rowSet2.getString("rlane_cd"	))+"]]></TD>");
					strBuilder.append("  <TD>"+JSPUtil.getNull((String)rowSet2.getString("dir_cd"				))+"</TD>");
					strBuilder.append("  <TD>"+JSPUtil.getNull((String)rowSet2.getString("fm_port_cd"			))+"</TD>");
					strBuilder.append("  <TD>"+JSPUtil.getNull((String)rowSet2.getString("to_port_cd"			))+"</TD>");
					strBuilder.append("  <TD>"+JSPUtil.getNull((String)rowSet2.getString("ovr_usd_slt_prc_seq"	))+"</TD>");
					
					strBuilder.append("  <TD>"+JSPUtil.getNull((String)rowSet2.getString("bzc_chtr_uc_amt"		))+"</TD>");
					strBuilder.append("  <TD>"+JSPUtil.getNull((String)rowSet2.getString("chtr_uc_amt"			))+"</TD>");
					strBuilder.append("  <TD>"+JSPUtil.getNull((String)rowSet2.getString("add_chtr_uc_amt"		))+"</TD>");
					
					//Detail수 만큼 추출
					for(int idx=0; idx<headCnt; idx++) {
						String ucAmt = JSPUtil.getNull(rowSet2.getString("uc_amt" + idx));
						strBuilder.append("<TD>"+ucAmt+"</TD>");
						
					} // end of for
						
					strBuilder.append("</TR>\n");
					
					//log.debug("strBuilder = " + strBuilder);
	    		}
		    }
		    
		   
		    strBuilder.append("</DATA>");
		    strBuilder.append("<ETC-DATA>");
		    strBuilder.append("  <ETC KEY=\"row\">"+headCnt+"</ETC>/n");
		    strBuilder.append("  <ETC KEY=\"head1\">"+headText[1]+"</ETC>\n");
		    strBuilder.append("  <ETC KEY=\"head2\">"+headText[2]+"</ETC>\n");		    
		    strBuilder.append("</ETC-DATA>");			    
        }
        catch(SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
        catch(Exception ex){
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex.getMessage());
        }
        // =======================================================================================================
        // 두번째 RowSet ========================================================================================== E
		
		log.debug("########### EsmBsa0162ViewAdapter.makeDataTag(List<AbstractValueObject> list, String prefix) ########### [END]");
	    return strBuilder.toString();
	}
    
	
}
