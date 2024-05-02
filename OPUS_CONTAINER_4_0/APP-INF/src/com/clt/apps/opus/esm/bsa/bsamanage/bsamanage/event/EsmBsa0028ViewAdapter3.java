
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
=========================================================*/
package com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.event;

import java.sql.SQLException;
import java.util.List;

import com.clt.apps.opus.esm.bsa.common.vo.CommonBsaRsVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
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
public class EsmBsa0028ViewAdapter3 extends DefaultViewAdapter {
	
    public EsmBsa0028ViewAdapter3(){
    	super();
    }
    
    protected String makeDataTag(List<AbstractValueObject> list, String prefix) {
    	log.debug("########### EsmBsa0028ViewAdapter3.makeDataTag(List<AbstractValueObject> list, String prefix) ########### [START]");
    	CommonBsaRsVO rsVo = (CommonBsaRsVO)list.get(0);
    	CommonBsaRsVO[] arrayVo = rsVo.getCommonBsaRsVOArray();
		
		log.debug("arrayVo.length = " + arrayVo.length);
		
		DBRowSet rowSet1 = arrayVo[0].getDbRowset();
		
		
		if(rowSet1 == null  ){
			if(rowSet1 == null){
				log.debug("rowSet1 은 널입니다.");
			}			
			return "";
		}
		log.debug("getRowSetCnt(rowSet1) = " + getRowSetCnt(rowSet1));
		        
        // RowSet ========================================================================================== S
        // =======================================================================================================
        
        StringBuilder strBuilder = new StringBuilder();
        if(rowSet1.isPivot()){
        	strBuilder.append(makePivotDataTag(rowSet1));
        	return strBuilder.toString();
        }        
        
    	int totCnt2  = getRowSetCnt(rowSet1);//rs.getRowCount()
    	
    	log.debug("totCnt2 = " + totCnt2);
    	
    	String[] realColNms = getColHeader(rowSet1);
    	int colCount = realColNms.length;
    	try{
		      
		    if(rowSet1.getMaxRows() > 0){
		      	totCnt2 = rowSet1.getMaxRows();
		    }  
		    
		    strBuilder.append("<DATA TOTAL=\""+totCnt2+"\">");
		    if(totCnt2 > 0){
	    		while(rowSet1.next()){		
					strBuilder.append("<TR>");
					strBuilder.append("  <TD></TD>");
					strBuilder.append("  <TD>R</TD>");
					
					strBuilder.append("	<TD>"+getNull(rowSet1.getString("grp"))+"</TD>");
					strBuilder.append("	<TD>"+getNull(rowSet1.getString("maxseq"))+"</TD>");
					strBuilder.append("	<TD>"+getNull(rowSet1.getString("ovr_usd_slt_prc_seq"))+"</TD>");
					strBuilder.append("	<TD>"+getNull(rowSet1.getString("ovr_usd_slt_prc_seq"))+"</TD>");
					strBuilder.append("	<TD>"+getNull(rowSet1.getString("vvd_cd"))+"</TD>");
					strBuilder.append("	<TD>"+getNull(rowSet1.getString("bsa_slt_prc_fm_dt"))+"</TD>");
					strBuilder.append("	<TD>"+getNull(rowSet1.getString("bsa_slt_prc_to_dt"))+"</TD>");
					strBuilder.append("	<TD>"+getNull(rowSet1.getString("trd_cd"))+"</TD>");
					strBuilder.append("	<TD>"+getNull(rowSet1.getString("rlane_cd"))+"</TD>");
					strBuilder.append("	<TD>"+getNull(rowSet1.getString("dir_cd"))+"</TD>");
					strBuilder.append("	<TD>"+getNull(rowSet1.getString("cntr_full_flg"))+"</TD>");
					strBuilder.append("	<TD>"+getNull(rowSet1.getString("bsa_slt_cost_tp_cd"))+"</TD>");
					for (int j = 12 ; j <= colCount ; j++) {
						strBuilder.append("<TD>"+getNull(rowSet1.getObject(j)) + "</TD>");
					}	
					strBuilder.append("</TR>\n");
					
					//log.debug("strBuilder = " + strBuilder);
	    		}
		    }
		    
		   
		    strBuilder.append("</DATA>");
		    strBuilder.append("<ETC-DATA>");		    
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
		
		log.debug("########### EsmBsa0028ViewAdapter3.makeDataTag(List<AbstractValueObject> list, String prefix) ########### [END]");
	    return strBuilder.toString();
	}
}
