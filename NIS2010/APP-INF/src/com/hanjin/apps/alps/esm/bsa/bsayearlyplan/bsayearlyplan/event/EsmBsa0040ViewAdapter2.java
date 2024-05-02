/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmBsa0040ViewAdapter2.java
*@FileTitle : EsmBsa0040ViewAdapter2
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.17
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2011.01.17 이행지
* 1.0 Creation
*=========================================================
* History :
* 2011.01.17 이행지 [CHM-201108497-01] 사업계획 노출 방지를 위한 사업계획용 메뉴 추가 개발
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
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ESM_BSA_0040 에 대한 ViewAdapter<br>
 * - ESM_BSA_0040HTMLAction에서 작성<br>
 *
 * @author 김기대
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBsa0040ViewAdapter2 extends DefaultViewAdapter {
	
    public EsmBsa0040ViewAdapter2(){
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
    	CommonBsaRsVO vo = (CommonBsaRsVO)list.get(0);
    	CommonBsaRsVO[] arrayVo = vo.getCommonBsaRsVOArray();
		
		DBRowSet rowSet1 = arrayVo[0].getDbRowset();
		DBRowSet rowSet2 = arrayVo[1].getDbRowset();
		
		
		// 첫번째 RowSet ========================================================================================== S
		// =======================================================================================================
		String[] headText = {"","",""};
		int headCnt = rowSet1.getRowCount();
		
		int fixCnt = 17 - 1;  //고정 컬럼수 - 1 --> 'scht_desc'는 가변뒤에 있음  (※주의: ESM_BSA_0040.js에서도 수정할 것)		
		
		String logicFnlCapa = "";
		String logicSubCapa = "";
		
		String bsaOpJbCd = "";
		int i = 0;  		     
        
    	int totCnt  = getRowSetCnt(rowSet1);//rs.getRowCount()
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
    				
    				if (bsaOpJbCd.equals("001")) {
    					logicFnlCapa = logicFnlCapa + "+|" + (fixCnt + i) + "|";
    					logicSubCapa = logicSubCapa + "+|" + (fixCnt + i) + "|";
    				} else if (bsaOpJbCd.equals("002")) {
    					logicFnlCapa = logicFnlCapa + "-|" + (fixCnt + i) + "|";
    				} else if (bsaOpJbCd.equals("003")) {
    					logicFnlCapa = logicFnlCapa + "+|" + (fixCnt + i) + "|";
    				} else if (bsaOpJbCd.equals("004")) {
    					logicFnlCapa = logicFnlCapa + "-|" + (fixCnt + i) + "|";
    				} else if (bsaOpJbCd.equals("005")) {
    					logicFnlCapa = logicFnlCapa + "+|" + (fixCnt + i) + "|"; 
    				}
    				i++;
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
        
		// 첫번째 인자 '+/-' 제거
		if (logicFnlCapa.length()>0) { logicFnlCapa = logicFnlCapa.substring(1); } 
		if (logicSubCapa.length()>0) { logicSubCapa = logicSubCapa.substring(1); } 		
		        
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
	    		int count = 1;
	    		while(rowSet2.next()){
					String bgcolor = "";
					String userId  = JSPUtil.getNull((String)rowSet2.getString("upd_usr_id"));
					if (userId.equals("SYSTEM") || userId.equals("BATCH")) {
						bgcolor = " BGCOLOR='247,253,204'";
					} else {
						bgcolor = "";
					}
					
					strBuilder.append("<TR"+bgcolor+" >");
					strBuilder.append("  <TD>R</TD>");

					log.debug("["+count+"] 번째 ##############################");
					log.debug("bsa_group = " + JSPUtil.getNull((String)rowSet2.getString("bsa_group"				)));
					log.debug("bsa_seq = " + JSPUtil.getNull((String)rowSet2.getString("bsa_seq"				)));
					log.debug("vvd_cd = " + JSPUtil.getNull((String)rowSet2.getString("vvd_cd"				)));
					log.debug("bsa_fm_dt = " + JSPUtil.getNull((String)rowSet2.getString("bsa_fm_dt"				)));
					log.debug("bsa_to_dt = " + JSPUtil.getNull((String)rowSet2.getString("bsa_to_dt"				)));
					
					log.debug("trd_cd = " + JSPUtil.getNull((String)rowSet2.getString("trd_cd"				)));
					log.debug("rlane_cd = " + JSPUtil.getNull((String)rowSet2.getString("rlane_cd"				)));
					log.debug("dir_cd = " + JSPUtil.getNull((String)rowSet2.getString("dir_cd"				)));
					log.debug("vsl_bsa_chk_flg = " + JSPUtil.getNull((String)rowSet2.getString("vsl_bsa_chk_flg"				)));
					log.debug("vsl_seq = " + JSPUtil.getNull((String)rowSet2.getString("vsl_seq"				)));
					
					log.debug("vsl_cd = " + JSPUtil.getNull((String)rowSet2.getString("vsl_cd"				)));
					log.debug("hjs_fnl_bsa_capa = " + JSPUtil.getNull((String)rowSet2.getString("hjs_fnl_bsa_capa"				)));
					log.debug("hjs_bsa_bfr_sub_capa = " + JSPUtil.getNull((String)rowSet2.getString("hjs_bsa_bfr_sub_capa"				)));
					log.debug("vsl_mlt_inp_flg = " + JSPUtil.getNull((String)rowSet2.getString("vsl_mlt_inp_flg"				)));
					log.debug("user_id = " + userId);
					log.debug("\n\n");
					
					
					strBuilder.append("  <TD>"+JSPUtil.getNull((String)rowSet2.getString("bsa_group"			))+"</TD>");
					strBuilder.append("  <TD>"+JSPUtil.getNull((String)rowSet2.getString("bsa_seq"  			))+"</TD>");
					strBuilder.append("  <TD>"+JSPUtil.getNull((String)rowSet2.getString("vvd_cd"				))+"</TD>");
					strBuilder.append("  <TD>"+JSPUtil.getNull((String)rowSet2.getString("bsa_fm_dt"			))+"</TD>");
					strBuilder.append("  <TD>"+JSPUtil.getNull((String)rowSet2.getString("bsa_to_dt"			))+"</TD>");
					
					strBuilder.append("  <TD>"+JSPUtil.getNull((String)rowSet2.getString("trd_cd"				))+"</TD>");
					strBuilder.append("  <TD>"+JSPUtil.getNull((String)rowSet2.getString("rlane_cd"				))+"</TD>");
					strBuilder.append("  <TD>"+JSPUtil.getNull((String)rowSet2.getString("dir_cd"				))+"</TD>");
					strBuilder.append("  <TD>"+JSPUtil.getNull((String)rowSet2.getString("vsl_bsa_chk_flg"		))+"</TD>");
					strBuilder.append("  <TD>"+JSPUtil.getNull((String)rowSet2.getString("vsl_seq"				))+"</TD>");
					
					strBuilder.append("  <TD>"+JSPUtil.getNull((String)rowSet2.getString("vsl_cd"				))+"</TD>");
					strBuilder.append("  <TD>"+JSPUtil.getNull((String)rowSet2.getString("hjs_fnl_bsa_capa"		))+"</TD>");
					strBuilder.append("  <TD>"+JSPUtil.getNull((String)rowSet2.getString("hjs_bsa_bfr_sub_capa"	))+"</TD>");
					strBuilder.append("  <TD>"+JSPUtil.getNull((String)rowSet2.getString("vsl_mlt_inp_flg"		))+"</TD>");
					strBuilder.append("  <TD>"+userId+"</TD>");
					
					//Detail수 만큼 추출
					for(int idx=0; idx<headCnt; idx++) {
						strBuilder.append("  <TD>"+JSPUtil.getNull((String)rowSet2.getString("crr_bsa_capa"+ idx))+"</TD>");
					} // end of for
						
					strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)rowSet2.getString("scht_desc"	))+"]]></TD>");
					
					
					
					strBuilder.append("</TR>\n");
					count++;
					//log.debug("strBuilder = " + strBuilder);
	    		}
		    }
		    
		    log.debug("headCnt = " + headCnt);
		    log.debug("headText[1] = " + headText[1]);
		    log.debug("headText[2] = " + headText[2]);
		    log.debug("logicFnlCapa = " + logicFnlCapa);
		    log.debug("logicSubCapa = " + logicSubCapa);
	    
		    strBuilder.append("</DATA>");
		    //strBuilder.append("|$$|");
		    strBuilder.append("<ETC-DATA>");
		    strBuilder.append("  <ETC KEY=\"row\">"+headCnt+"</ETC>");
		    strBuilder.append("  <ETC KEY=\"head1\">"+headText[1]+"</ETC>\n");
		    strBuilder.append("  <ETC KEY=\"head2\">"+headText[2]+"</ETC>\n");
		    strBuilder.append("  <ETC KEY=\"head3\">"+headText[0]+"</ETC>\n");
		    strBuilder.append("  <ETC KEY=\"logic1\">"+logicFnlCapa+"</ETC>\n");
		    strBuilder.append("  <ETC KEY=\"logic2\">"+logicSubCapa+"</ETC>\n");
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
