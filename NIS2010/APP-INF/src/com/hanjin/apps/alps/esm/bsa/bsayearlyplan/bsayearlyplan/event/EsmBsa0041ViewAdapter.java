/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmBsa0041ViewAdapter.java
*@FileTitle : EsmBsa0041ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.25
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2011.01.25 이행지
* 1.0 Creation
*=========================================================
* History :
* 2011.01.25 이행지 [CHM-201108497-01] 사업계획 노출 방지를 위한 사업계획용 메뉴 추가 개발
* 2011.05.25 최윤성 [CHM-201110971-01] BSA // Slot Price Creation 화면 기능 보완
* 2011.07.15 이행지 [CHM-201112101-01] Currency Code 추가
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.event;

import java.sql.SQLException;
import java.util.List;

import com.hanjin.apps.alps.esm.bsa.common.vo.CommonBsaRsVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.controller.html.HTMLAction;

/**
 * ESM_BSA_0041 에 대한 ViewAdapter<br>
 * - ESM_BSA_0041HTMLAction에서 작성<br>
 *
 * @author 이행지
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBsa0041ViewAdapter extends DefaultViewAdapter {
	
    public EsmBsa0041ViewAdapter(){
    	super();
    }
    
    protected String makeDataTag(List<AbstractValueObject> list, String prefix) {
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
		String[] headText = {"","",""};
		int headCnt = rowSet1.getRowCount();
		
		String bsaOpJbCd = "";
		
    	int totCnt  = getRowSetCnt(rowSet1);//rs.getRowCount()
    	
    	log.debug("totCnt = " + totCnt);

    	try{
		      
		    if(rowSet1.getMaxRows() > 0){
		      	totCnt = rowSet1.getMaxRows();
		    }  
		    
		    if(totCnt > 0){
	    		while(rowSet1.next()){
	    			
	    			bsaOpJbCd = JSPUtil.getNull(rowSet1.getString("bsa_op_jb_cd"));
    				headText[0] = headText[0] + "|" + bsaOpJbCd;
    				headText[1] = headText[1] + "|" + JSPUtil.getNull(rowSet1.getString("bsa_op_jb_nm"));
    				headText[2] = headText[2] + "|" + JSPUtil.getNull(rowSet1.getString("crr_cd"));
    				
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
        // 첫번째 RowSet ========================================================================================== E
        
        
        // 두번째 RowSet ========================================================================================== S
        
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
	    		while(rowSet2.next()){
	    			String bzcFlg = ""; 
					String subFlg = ""; 
					String crsFlg = ""; 

			        String bgBzcColor = ""; 
			        String bgSubColor = ""; 
			        String bgCrsColor = ""; 
	
			        String sltPrcCapa = ""; 
			        String capaFlg = ""; 
	
			        String bgColor = ""; 
			        
			        int colorChkCnt = 0;
					
					bzcFlg = JSPUtil.getNull(rowSet2.getString("bzc_flg"));
					subFlg = JSPUtil.getNull(rowSet2.getString("sub_flg"));
					crsFlg = JSPUtil.getNull(rowSet2.getString("crs_flg"));

					bgBzcColor = "";
					if (!bzcFlg.equals("0")) {
						bgBzcColor = " BGCOLOR='YELLOW'"; 
						colorChkCnt++;
					}
					bgSubColor = ""; 
					if (!subFlg.equals("0")) {
						bgSubColor = " BGCOLOR='YELLOW'";
						colorChkCnt++;
					}
					bgCrsColor = ""; 
					if (!crsFlg.equals("0")) {
						bgCrsColor = " BGCOLOR='YELLOW'";
						colorChkCnt++;
					}
					
					strBuilder.append("<TR>");
					strBuilder.append("  <TD></TD>");
					strBuilder.append("  <TD>R</TD>");
					
					strBuilder.append("  <TD>"+JSPUtil.getNull((String)rowSet2.getString("grp"			))+"</TD>");
					strBuilder.append("  <TD>"+JSPUtil.getNull((String)rowSet2.getString("maxseq"  		))+"</TD>");
					strBuilder.append("  <TD>"+JSPUtil.getNull((String)rowSet2.getString("slt_prc_seq"	))+"</TD>");
					strBuilder.append("  <TD>"+JSPUtil.getNull((String)rowSet2.getString("slt_prc_seq"	))+"</TD>");
					strBuilder.append("  <TD>"+JSPUtil.getNull((String)rowSet2.getString("vvd_cd"		))+"</TD>");
					
					strBuilder.append("  <TD>"+JSPUtil.getNull((String)rowSet2.getString("bsa_slt_prc_fm_dt"	))+"</TD>");
					strBuilder.append("  <TD>"+JSPUtil.getNull((String)rowSet2.getString("bsa_slt_prc_to_dt"	))+"</TD>");
					strBuilder.append("  <TD>"+JSPUtil.getNull((String)rowSet2.getString("trd_cd"				))+"</TD>");
					strBuilder.append("  <TD>"+JSPUtil.getNull((String)rowSet2.getString("rlane_cd"				))+"</TD>");
					strBuilder.append("  <TD>"+JSPUtil.getNull((String)rowSet2.getString("dir_cd"				))+"</TD>");
					strBuilder.append("  <TD>"+JSPUtil.getNull((String)rowSet2.getString("curr_cd"				))+"</TD>");
					strBuilder.append("  <TD>"+JSPUtil.getNull((String)rowSet2.getString("bsa_slt_cost_tp_cd"	))+"</TD>");
					
					strBuilder.append("  <TD " + bgBzcColor + ">"+JSPUtil.getNull((String)rowSet2.getString("hjs_bfr_sub_capa"	))+"</TD>");
					strBuilder.append("  <TD " + bgSubColor + ">"+JSPUtil.getNull((String)rowSet2.getString("sub_chtr_bsa_capa"	))+"</TD>");
					strBuilder.append("  <TD " + bgCrsColor + ">"+JSPUtil.getNull((String)rowSet2.getString("crs_chtr_bsa_capa"	))+"</TD>");
					
					//Detail수 만큼 추출
					for(int idx=0; idx<headCnt; idx++) {
						sltPrcCapa = JSPUtil.getNull(rowSet2.getString("slt_prc_capa" + idx));
						capaFlg     = JSPUtil.getNull(rowSet2.getString("capa_flg" + idx));
						bgColor = "";
						if (!capaFlg.equals("0")) {
							bgColor = " BGCOLOR='YELLOW'"; 
							colorChkCnt++;
						}
						strBuilder.append("<TD"+ bgColor+">"+sltPrcCapa+"</TD>");
						
					} // end of for
					
					strBuilder.append("  <TD>"+colorChkCnt+"</TD>");
					strBuilder.append("</TR>\n");
					
					//log.debug("strBuilder = " + strBuilder);
	    		}
		    }
		   
		    strBuilder.append("</DATA>");
		    strBuilder.append("<ETC-DATA>");
		    strBuilder.append("  <ETC KEY=\"row\">"+headCnt+"</ETC>");
		    strBuilder.append("  <ETC KEY=\"head1\">"+headText[1]+"</ETC>");
		    strBuilder.append("  <ETC KEY=\"head2\">"+headText[2]+"</ETC>");		    
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
		return strBuilder.toString();
	}
    
}
