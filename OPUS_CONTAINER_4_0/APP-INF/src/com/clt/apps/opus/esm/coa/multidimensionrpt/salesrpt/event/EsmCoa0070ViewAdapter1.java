/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0066ViewAdapter.java
*@FileTitle : EsmCoa0066ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 김기식
*@LastVersion : 1.0
* 2009.09.23 김기식
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.event;

import java.sql.SQLException;
import java.util.List;

import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.SalesOffiRepoConditionVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.SalesOffiRepoRtnVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.DefaultViewAdapter;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.core.layer.event.EventException;

/**
 * ESM_COA_0070 에 대한 ViewAdapter<br>
 * - ESM_COA_0070HTMLAction에서 작성<br>
 *
 * @author 김기식
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0070ViewAdapter1 extends DefaultViewAdapter {
	
    public EsmCoa0070ViewAdapter1(){
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
    	log.debug("########### EsmCoa0070ViewAdapter ########### [START]");
    	StringBuilder strBuilder = new StringBuilder();
        
    	DBRowSet rowSet = null;							   	//DB ResultSet
    	SalesOffiRepoConditionVO conVo = null;
    	//String strErrMsg = "";								//에러메세지
    	int rowCount	 = 0;								//DB ResultSet 리스트의 건수
    	String rptItem   = "";
    	String preWeek = "";
    	String dir_sts = "";
    	String ofc_sts = "";
    	String pro_vw = "";
    	String pro_lvl = "";
    	String ofc_vw = "";
		
    	SalesOffiRepoRtnVO listVo = (SalesOffiRepoRtnVO)list.get(0);
        
        rowSet = listVo.getRowSet();
        conVo = listVo.getSalesOffiRepoConditionVO();
		preWeek = listVo.getFPreWeek();
		if(rowSet != null){
			 rowCount = rowSet.getRowCount();
		}
		
		rptItem = JSPUtil.getNull(conVo.getFRptItem());
		dir_sts = JSPUtil.getNull(conVo.getFDirSts());
		ofc_sts = JSPUtil.getNull(conVo.getFOfcSts());
		pro_vw = JSPUtil.getNull(conVo.getFProVw());
		ofc_vw = JSPUtil.getNull(conVo.getFOfcVw());
		pro_lvl = JSPUtil.getNull(conVo.getFProLvl());
		
		strBuilder.append("<ETC-DATA>");
		
    	try{			    
    		strBuilder.append("<ETC KEY=\"f_pre_week\">"+preWeek+"</ETC>");
    		strBuilder.append("  <ETC KEY=\"sXml1\">");
			strBuilder.append("    <![CDATA[");
			//strBuilder.append("    <?xml version=\"1.0\" ?>");	    	
			strBuilder.append("    <SHEET>");
			strBuilder.append("      <DATA TOTAL=\""+rowCount+"\">");	
			
			if(rowSet != null){
				while (rowSet.next()) {
					
					strBuilder.append("<TR>");
			        if(ofc_sts.equals("Y")) { 
			        	strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("ofc_cd1"))+"</TD>");
			        	strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("ofc_cd2"))+"</TD>");
			        }
			        if(rptItem.equals("T")) { 
			        	strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("trd_cd"))+"</TD>");
			        } else if(rptItem.equals("S")) { 
			        	strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("trd_cd"))+"</TD>");
			        	strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("sub_trd_cd"))+"</TD>");
			        } else if(rptItem.equals("L")) { 
			        	strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("trd_cd"))+"</TD>");
			        	strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("sub_trd_cd"))+"</TD>");
			        	strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("rlane_cd"))+"</TD>");
			        } else if(rptItem.equals("V")) { 
			        	strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("trd_cd"))+"</TD>");
			        	strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("sub_trd_cd"))+"</TD>");
			        	strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("rlane_cd"))+"</TD>");
			        	strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("vsl_cd")) + JSPUtil.getNull(rowSet.getString("skd_voy_no")) + JSPUtil.getNull(rowSet.getString("dir_cd"))+"</TD>");
			        }
			        if (dir_sts.equals("Y")) {
			        	strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("dir_cd"))+"</TD>");
			        } 
			       
			          // Loaded Vol. 
			        strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("prev_load")) +"</TD>");
			        strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("curr_load")) +"</TD>");
			           
			          if( Double.parseDouble(JSPUtil.getNull(rowSet.getString("prev_load")))*Double.parseDouble(JSPUtil.getNull(rowSet.getString("curr_load"))) > 0 ) { 
			        	  strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("load_chng")) + "</TD>");
			          } else if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("prev_load")))*Double.parseDouble(JSPUtil.getNull(rowSet.getString("curr_load"))) < 0) {
			        	  if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("prev_load")))>0) {
			        		  strBuilder.append("<TD IMAGE='1'></TD>");
			        	  } else {
			        		  strBuilder.append("<TD IMAGE='0'></TD>");
			        	  }
			          } else if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("prev_load")))*Double.parseDouble(JSPUtil.getNull(rowSet.getString("curr_load"))) == 0)  { 
			        	  if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("prev_load"))) == 0) {
			        		  strBuilder.append("<TD IMAGE='0'></TD>");
			        	  } else {
			        		  strBuilder.append("<TD IMAGE='1'></TD>");
			        	  }
			          }
			          
			          // Gross REV 
			          strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("prev_rev")) + "</TD>");
			          strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("curr_rev")) + "</TD>");
			           
			          if( Double.parseDouble(JSPUtil.getNull(rowSet.getString("prev_rev")))*Double.parseDouble(JSPUtil.getNull(rowSet.getString("curr_rev"))) > 0 ) { 
			        	  strBuilder.append("<TD>" + JSPUtil.getNull(rowSet.getString("rev_chng")) + "</TD>");
			          } else if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("prev_rev")))*Double.parseDouble(JSPUtil.getNull(rowSet.getString("curr_rev"))) < 0) {
			        	  if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("prev_rev")))>0) {
			        		  strBuilder.append("<TD IMAGE='1'></TD>");
			        	  } else {
			        		  strBuilder.append("<TD IMAGE='0'></TD>");
			        	  }
			        	  
			          } else if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("prev_rev")))*Double.parseDouble(JSPUtil.getNull(rowSet.getString("curr_rev"))) == 0)  { 
			        	  if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("prev_rev"))) == 0) {
			        		  strBuilder.append("<TD IMAGE='0'></TD>");
			        	  } else {
			        		  strBuilder.append("<TD IMAGE='1'></TD>");
			        	  }
			          }			                  
			          
			          // BKG Contribution Margin 
			          strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("prev_cm")) + "</TD>");
			          strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("curr_cm")) + "</TD>");
			           
			          if( Double.parseDouble(JSPUtil.getNull(rowSet.getString("prev_cm")))*Double.parseDouble(JSPUtil.getNull(rowSet.getString("curr_cm"))) > 0 ) { 
			        	  strBuilder.append("<TD>" + JSPUtil.getNull(rowSet.getString("cm_chng")) + "</TD>");
			        	  
			          } else if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("prev_cm")))*Double.parseDouble(JSPUtil.getNull(rowSet.getString("curr_cm"))) < 0) {
			        	  if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("prev_cm")))>0) {
			        		  strBuilder.append("<TD IMAGE='1'></TD>");
			        	  } else {
			        		  strBuilder.append("<TD IMAGE='0'></TD>");
			        	  }
			        	  
			          } else if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("prev_cm")))*Double.parseDouble(JSPUtil.getNull(rowSet.getString("curr_cm"))) == 0)  { 
			        	  if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("prev_cm"))) == 0) {
			        		  strBuilder.append("<TD IMAGE='0'></TD>");
			        	  } else {
			        		  strBuilder.append("<TD IMAGE='1'></TD>");
			        	  }
			          }
			                     
					  if (pro_vw.equals("R")){ 
					   	if (ofc_vw.equals("C")){ 
						          // OTH ABC(By SVC OFC) 
					   		strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("prev_oth_abc_svc")) + "</TD>");
					   		strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("curr_oth_abc_svc")) + "</TD>");

						          // STP REV --%>
					   		strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("prev_stp_rev"))+ "</TD>");
					   		strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("curr_stp_rev")) + "</TD>");
								            
						          // Balance(by SVC OFC) --%>
					   		strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("prev_balance_svc")) + "</TD>");
					   		strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("curr_balance_svc")) + "</TD>");
								  
						          //OTH ABC(CONT OFC) --%>
					   		strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("prev_oth_abc_cont")) + "</TD>");
					   		strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("curr_oth_abc_cont")) + "</TD>");
								            
						          // STP Cost --%>
					   		strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("prev_stp_cost")) + "</TD>");
					   		strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("curr_stp_cost")) + "</TD>");
								            
						          // Balance(Cont OFC) --%>
					   		strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("prev_balance_cont")) + "</TD>");
					   		strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("curr_balance_cont")) + "</TD>");
								            
						          // STP Profit --%>
					   		strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("prev_stp_profit")) + "</TD>");
					   		strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("curr_stp_profit")) + "</TD>");
						          
						          // Branch CM --%>
					   		strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("prev_branch_cm")) + "</TD>");
					   		strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("curr_branch_cm")) + "</TD>");
					   		strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("branch_chng")) + "</TD>");
							  
						   	}
						  if (pro_lvl.equals("O")){ 
							  // BKG OP --%>
							  strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("prev_bkg_op")) + "</TD>");
							  strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("curr_bkg_op")) + "</TD>");
					           
					          if( Double.parseDouble(JSPUtil.getNull(rowSet.getString("prev_bkg_op")))*Double.parseDouble(JSPUtil.getNull(rowSet.getString("curr_bkg_op"))) > 0 ) { 
					        	  strBuilder.append("<TD>" + JSPUtil.getNull(rowSet.getString("bkg_op_chng")) + "</TD>");
					          } else if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("prev_bkg_op")))*Double.parseDouble(JSPUtil.getNull(rowSet.getString("curr_bkg_op"))) < 0) {
					        	  if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("prev_bkg_op")))>0) {
					        		  strBuilder.append("<TD IMAGE='1'></TD>");
					        	  } else {
					        		  strBuilder.append("<TD IMAGE='0'></TD>");
					        	  }
					          } else if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("prev_bkg_op")))*Double.parseDouble(JSPUtil.getNull(rowSet.getString("curr_bkg_op"))) == 0)  { 
					        	  if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("prev_bkg_op"))) == 0) {
					        		  strBuilder.append("<TD IMAGE='0'></TD>");
					        	  } else {
					        		  strBuilder.append("<TD IMAGE='1'></TD>");
					        	  }
					          }
					                        
							  // OP --%>
				    		  if(ofc_vw.equals("C") && pro_lvl.equals("O")){
				    			  strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("prev_op")) + "</TD>");
				    			  strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("curr_op")) + "</TD>");
				    			  strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("op_chng")) + "</TD>");
					          }
				          }
			          }
			          //-- G.RPB --%>
					  strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("prev_rpb"))+ "</TD>");
					  strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("curr_rpb"))+ "</TD>");
			           
			          if( Double.parseDouble(JSPUtil.getNull(rowSet.getString("prev_rpb")))*Double.parseDouble(JSPUtil.getNull(rowSet.getString("curr_rpb"))) > 0 ) { 
			        	  strBuilder.append("<TD>" + JSPUtil.getNull(rowSet.getString("rpb_chng")) + "</TD>");
			        	  
			          } else if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("prev_rpb")))*Double.parseDouble(JSPUtil.getNull(rowSet.getString("curr_rpb"))) < 0) {
			        	  if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("prev_rpb")))>0) {
			        		  strBuilder.append("<TD IMAGE='1'></TD>");
			        	  } else {
			        		  strBuilder.append("<TD IMAGE='0'></TD>");
			        	  }
			        	  
			          } else if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("prev_rpb")))*Double.parseDouble(JSPUtil.getNull(rowSet.getString("curr_rpb"))) == 0)  { 
			        	  if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("prev_rpb"))) == 0) {
			        		  strBuilder.append("<TD IMAGE='0'></TD>");
			        	  } else {
			        		  strBuilder.append("<TD IMAGE='1'></TD>");
			        	  }
			          }			          

			          //-- BKG Contribution Margin Box --%>
			          strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("prev_cmb")) + "</TD>");
			          strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("curr_cmb")) + "</TD>");
			            
			          if( Double.parseDouble(JSPUtil.getNull(rowSet.getString("prev_cmb")))*Double.parseDouble(JSPUtil.getNull(rowSet.getString("curr_cmb"))) > 0 ) { 
			        	  strBuilder.append("<TD>" + JSPUtil.getNull(rowSet.getString("cmb_chng")) + "</TD>");
			        	  
			          } else if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("prev_cmb")))*Double.parseDouble(JSPUtil.getNull(rowSet.getString("curr_cmb"))) < 0) {
			        	  if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("prev_cmb")))>0) {
			        		  strBuilder.append("<TD IMAGE='1'></TD>");
			        	  } else {
			        		  strBuilder.append("<TD IMAGE='0'></TD>");
			        	  }
			        	  
			          } else if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("prev_cmb")))*Double.parseDouble(JSPUtil.getNull(rowSet.getString("curr_cmb"))) == 0)  { 
			        	  if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("prev_cmb"))) == 0) {
			        		  strBuilder.append("<TD IMAGE='0'></TD>");
			        	  } else {
			        		  strBuilder.append("<TD IMAGE='1'></TD>");
			        	  }
			          }			            
					  
					   if (pro_vw.equals("R")&&pro_lvl.equals("O")){ 
					  // OPB --%>
						   strBuilder.append("<TD></TD>");
						   strBuilder.append("<TD></TD>");
						   strBuilder.append("<TD></TD>");
					  }

			          //-- BSA Capa --%>
					   strBuilder.append("<TD>" + JSPUtil.getNull(rowSet.getString("prev_bsa_capa")) + "</TD>");
					   strBuilder.append("<TD>" + JSPUtil.getNull(rowSet.getString("curr_bsa_capa")) + "</TD>");
			           
			          if( Double.parseDouble(JSPUtil.getNull(rowSet.getString("prev_bsa_capa")))*Double.parseDouble(JSPUtil.getNull(rowSet.getString("curr_bsa_capa"))) > 0 ) { 
			        	  strBuilder.append("<TD>" + JSPUtil.getNull(rowSet.getString("bsa_capa_chng")) + "</TD>");
			        	  
			          } else if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("prev_bsa_capa")))*Double.parseDouble(JSPUtil.getNull(rowSet.getString("curr_bsa_capa"))) < 0) {
			        	  if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("prev_bsa_capa")))>0) {
			        		  strBuilder.append("<TD IMAGE='1'></TD>");
			        	  } else {
			        		  strBuilder.append("<TD IMAGE='0'></TD>");
			        	  }
			        	  
			          } else if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("prev_bsa_capa")))*Double.parseDouble(JSPUtil.getNull(rowSet.getString("curr_bsa_capa"))) == 0)  { 
			        	  if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("prev_bsa_capa"))) == 0) {
			        		  strBuilder.append("<TD IMAGE='0'></TD>");
			        	  } else {
			        		  strBuilder.append("<TD IMAGE='1'></TD>");
			        	  }
			          }			             
			          
			          // L/F(%) --%>
			          strBuilder.append("<TD>" + JSPUtil.getNull(rowSet.getString("prev_lf")) + "</TD>");
			          strBuilder.append("<TD>" + JSPUtil.getNull(rowSet.getString("curr_lf")) + "</TD>");
			            
			          if( Double.parseDouble(JSPUtil.getNull(rowSet.getString("prev_lf")))*Double.parseDouble(JSPUtil.getNull(rowSet.getString("curr_lf"))) > 0 ) { 
			        	  strBuilder.append("<TD>" + JSPUtil.getNull(rowSet.getString("lf_chng")) + "</TD>");
			        	  
			          } else if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("prev_lf")))*Double.parseDouble(JSPUtil.getNull(rowSet.getString("curr_lf"))) < 0) {
			        	  if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("prev_lf")))>0) {
			        		  strBuilder.append("<TD IMAGE='1'></TD>");
			        	  } else {
			        		  strBuilder.append("<TD IMAGE='0'></TD>");
			        	  }
			        	  
			          } else if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("prev_lf")))*Double.parseDouble(JSPUtil.getNull(rowSet.getString("curr_lf"))) == 0)  { 
			        	  if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("prev_lf"))) == 0) {
			        		  strBuilder.append("<TD IMAGE='0'></TD>");
			        	  } else {
			        		  strBuilder.append("<TD IMAGE='1'></TD>");
			        	  }
			          } 			          
			       
	    			strBuilder.append("</TR>");
	    		}
			}	
			
						    
		    strBuilder.append("      </DATA>");
		    strBuilder.append("    </SHEET>");
		    strBuilder.append("    ]]>");
		    strBuilder.append("  </ETC>");	
		    strBuilder.append("  <ETC KEY=\"sXml2\">");
			strBuilder.append("    <![CDATA[");
			//strBuilder.append("    <?xml version=\"1.0\" ?>");	    	
			strBuilder.append("    <SHEET>");
			strBuilder.append("      <DATA TOTAL=\""+rowCount+"\">");	
		    
			if(rowSet != null){
				rowSet.beforeFirst();
				
				while (rowSet.next()) {
					
					strBuilder.append("<TR>");
			        if(ofc_sts.equals("Y")) { 
			        	strBuilder.append("<TD>" + JSPUtil.getNull(rowSet.getString("ofc_cd1"))+ "</TD>");
			        	strBuilder.append("<TD>" + JSPUtil.getNull(rowSet.getString("ofc_cd2"))+ "</TD>");
			        } 
			        if(rptItem.equals("T")) { 
			        	strBuilder.append("<TD>" + JSPUtil.getNull(rowSet.getString("trd_cd"))+ "</TD>");
			        } else if(rptItem.equals("S")) {
			        	strBuilder.append("<TD>" + JSPUtil.getNull(rowSet.getString("trd_cd"))+ "</TD>");
			        	strBuilder.append("<TD>" + JSPUtil.getNull(rowSet.getString("sub_trd_cd"))+ "</TD>");
			        } else if(rptItem.equals("L")) { 
			        	strBuilder.append("<TD>" + JSPUtil.getNull(rowSet.getString("trd_cd"))+ "</TD>");
			        	strBuilder.append("<TD>" + JSPUtil.getNull(rowSet.getString("sub_trd_cd"))+ "</TD>");
			        	strBuilder.append("<TD>" + JSPUtil.getNull(rowSet.getString("rlane_cd"))+ "</TD>");
			        } else if(rptItem.equals("V")) { 
			        	strBuilder.append("<TD>" + JSPUtil.getNull(rowSet.getString("trd_cd"))+ "</TD>");
			        	strBuilder.append("<TD>" + JSPUtil.getNull(rowSet.getString("sub_trd_cd"))+ "</TD>");
			        	strBuilder.append("<TD>" + JSPUtil.getNull(rowSet.getString("rlane_cd"))+ "</TD>");
			        	strBuilder.append("<TD>" + JSPUtil.getNull(rowSet.getString("vsl_cd")) + JSPUtil.getNull(rowSet.getString("skd_voy_no")) + JSPUtil.getNull(rowSet.getString("dir_cd"))+ "</TD>");
			        }
			        if (dir_sts.equals("Y")) {
			        	strBuilder.append("<TD>" + JSPUtil.getNull(rowSet.getString("dir_cd"))+ "</TD>");
			        } 
			          
			          // G.REV Increase/Decrease --
			        strBuilder.append("<TD>" + JSPUtil.getNull(rowSet.getString("by_load_grev"))+ "</TD>");
			        strBuilder.append("<TD>" + JSPUtil.getNull(rowSet.getString("by_rpb_grev"))+ "</TD>");
			        strBuilder.append("<TD></TD>");
			          // Cost Increase/Decrease --
			        strBuilder.append("<TD>" + JSPUtil.getNull(rowSet.getString("by_load_cost"))+ "</TD>");
			        strBuilder.append("<TD>" + JSPUtil.getNull(rowSet.getString("by_cpb_cost"))+ "</TD>");
			        strBuilder.append("<TD></TD>");
			          // Loaded Vol. Share --%>
			        strBuilder.append("<TD>" + JSPUtil.getNull(rowSet.getString("prev_load_share")) + "</TD>");
			        strBuilder.append("<TD>" + JSPUtil.getNull(rowSet.getString("curr_load_share")) + "</TD>");
			        strBuilder.append("<TD></TD>");
			          // CM Share --%>
			        strBuilder.append("<TD>" + JSPUtil.getNull(rowSet.getString("prev_cm_share")) + "</TD>");
			        strBuilder.append("<TD>" + JSPUtil.getNull(rowSet.getString("curr_cm_share")) + "</TD>");
			        strBuilder.append("<TD></TD>");
			          // OP Share --%>
					if (pro_vw.equals("R")&&pro_lvl.equals("O")){ 
						strBuilder.append("<TD>" + JSPUtil.getNull(rowSet.getString("prev_bkg_op_share")) + "</TD>");
						strBuilder.append("<TD>" + JSPUtil.getNull(rowSet.getString("curr_bkg_op_share")) + "</TD>");
						strBuilder.append("<TD></TD>");
					}         
			        strBuilder.append("</TR>");
					
				}
			}
							
			strBuilder.append("      </DATA>");
		    strBuilder.append("    </SHEET>");
		    strBuilder.append("    ]]>");
		    strBuilder.append("  </ETC>");			
			
		    
        }
        catch(SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
        catch(Exception ex){
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex.getMessage());
        }	
		
		strBuilder.append("</ETC-DATA>");

		log.debug("########### EsmCoa0070ViewAdapter ########### [END]");        
	    return strBuilder.toString();
    }     
}
