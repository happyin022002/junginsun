/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0070ViewIASSectorAdapter.java
*@FileTitle : EsmCoa0070ViewIASSectorAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 김기식
*@LastVersion : 1.0
* 2009.09.23 김기식
* 1.0 Creation
=========================================================
* History
=========================================================
*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.event;

import java.sql.SQLException;
import java.util.List;

import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.SalesOffiRepoConditionVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.SalesOffiRepoRtnVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ESM_COA_0070 에 대한 ViewAdapter<br>
 * - ESM_COA_0070HTMLAction에서 작성<br>
 *
 * @author 김기식
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0070ViewIASSectorAdapter extends DefaultViewAdapter {
	
    public EsmCoa0070ViewIASSectorAdapter(){
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
    	log.debug("########### EsmCoa0070ViewIASSectorAdapter ########### [START]");
    	StringBuilder strBuilder = new StringBuilder();
        
    	DBRowSet rowSet = null;							   	//DB ResultSet
    	SalesOffiRepoConditionVO conVo = null;
    	//String strErrMsg = "";								//에러메세지
    	int rowCount	 = 0;								//DB ResultSet 리스트의 건수
    	String rptItem   = "";
    	String preWeek = "";
    	String dir_sts = "";
    	String ofc_sts = "";
    	String wk_sts = "";
    	String r_month_sts = "";
    	
    	String hul_bnd_sts = "";    	
    	String ias_rgn_sts = "";  
    	    	
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
		wk_sts = JSPUtil.getNull(conVo.getFWkSts());
		r_month_sts = JSPUtil.getNull(conVo.getFRMonthSts());
		
		hul_bnd_sts = JSPUtil.getNull(conVo.getFHulBndSts());
		ias_rgn_sts = JSPUtil.getNull(conVo.getFIasRgnSts());
		
    	try{
    		strBuilder.append("      <DATA TOTAL=\""+rowCount+"\">");	
			
			if(rowSet != null){
				while (rowSet.next()) {
					
					strBuilder.append("<TR>");
			        if(ofc_sts.equals("Y")) { 
			        	strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("ofc_cd1"))+"</TD>");
			        	strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("ofc_cd2"))+"</TD>");
			        } 
			        if(rptItem.equals("1")) { 
			        	strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("trd_cd"))+"</TD>");
			          
				        if (ias_rgn_sts.equals("Y")) {
					          strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("ias_rgn_cd"))+"</TD>");
				        }
			          
			          
			        } else if(rptItem.equals("2")) { 
			        	strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("trd_cd"))+"</TD>");
			          
				        if (ias_rgn_sts.equals("Y")) {
					          strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("ias_rgn_cd"))+"</TD>");
				        }
			          
				        strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("sub_trd_cd"))+"</TD>");
			        } else if(rptItem.equals("3")) { 
			        	strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("trd_cd"))+"</TD>");
			          
				        if (ias_rgn_sts.equals("Y")) {
					          strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("ias_rgn_cd"))+"</TD>");
				        }
			          
				        strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("sub_trd_cd"))+"</TD>");
				        strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("rlane_cd"))+"</TD>");
			        } else if(rptItem.equals("4")) {
			        	strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("cost_yrmon"))+"</TD>");
			          	strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("cost_wk"))+"</TD>");
			          	strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("trd_cd"))+"</TD>");
			          
				        if (ias_rgn_sts.equals("Y")) {
					          strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("ias_rgn_cd"))+"</TD>");
				        }
			          
				        strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("sub_trd_cd"))+"</TD>");
				        strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("rlane_cd"))+"</TD>");
				        strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("vsl_cd")) + JSPUtil.getNull(rowSet.getString("skd_voy_no")) + JSPUtil.getNull(rowSet.getString("dir_cd"))+"</TD>");
			        }
			        if (dir_sts.equals("Y")) {
			          strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("dir_cd"))+"</TD>");
			        }

			       
			          
			        if (hul_bnd_sts.equals("Y")) {
				          strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("hul_bnd_cd"))+"</TD>");
			        }
			        
			        
			        strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("pol_cd"))+"</TD>");
			        strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("pod_cd"))+"</TD>");
			        strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("mn_sctr_flg"))+"</TD>");
			          
			        
			        if (!rptItem.equals("4") & r_month_sts.equals("Y")) {
			        	strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("cost_yrmon"))+"</TD>");
				    } 
			        if (!rptItem.equals("4") & wk_sts.equals("Y")) {
			          strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("cost_wk"))+"</TD>");
			        } 
			       
			          
					  //-- Load --%>
			          strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("qta_load"))+"</TD>");
			          strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("coa_load"))+"</TD>");
			           
			          if( Double.parseDouble(JSPUtil.getNull(rowSet.getString("qta_load")))*Double.parseDouble(JSPUtil.getNull(rowSet.getString("coa_load"))) > 0 ) { 
			        	  strBuilder.append("<TD>" + JSPUtil.getNull(rowSet.getString("load_chng")) + "</TD>");
			        	  
			          } else if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("qta_load")))*Double.parseDouble(JSPUtil.getNull(rowSet.getString("coa_load"))) < 0) {
			        	  if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("qta_load")))>0) {
				        	  strBuilder.append("<TD IMAGE='1'></TD>");
			        	  } else {
				          	  strBuilder.append("<TD IMAGE='0'></TD>");
			        	  }
			          } else if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("qta_load")))*Double.parseDouble(JSPUtil.getNull(rowSet.getString("coa_load"))) == 0)  { 
			        	  if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("qta_load"))) == 0) {
			        		  if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("coa_load"))) < 0) {
				        	  	strBuilder.append("<TD IMAGE='1'></TD>");
			        		  } else {
				        	  	strBuilder.append("<TD IMAGE='0'></TD>");
			        		  }
			        	  } else {
			        		  if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("qta_load"))) < 0) {
			  	        	  	strBuilder.append("<TD IMAGE='0'></TD>");
			          		  } else {
			  	        	  	strBuilder.append("<TD IMAGE='1'></TD>");
			          		  }        	  
			        	  }
			          }
			          
			          //-- Freight Revenue --%>
			          strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("qta_rev"))+"</TD>");
			          strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("coa_rev"))+"</TD>");
			           
			          if( Double.parseDouble(JSPUtil.getNull(rowSet.getString("qta_rev")))*Double.parseDouble(JSPUtil.getNull(rowSet.getString("coa_rev"))) > 0 ) { 
			        	  strBuilder.append("<TD>" + JSPUtil.getNull(rowSet.getString("rev_chng")) + "</TD>");
			        	  
			          } else if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("qta_rev")))*Double.parseDouble(JSPUtil.getNull(rowSet.getString("coa_rev"))) < 0) {
			        	  if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("qta_rev")))>0) {
				        	  strBuilder.append("<TD IMAGE='1'></TD>");
			        	  } else {
				          	  strBuilder.append("<TD IMAGE='0'></TD>");
			        	  }
			        	  
			          } else if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("qta_rev")))*Double.parseDouble(JSPUtil.getNull(rowSet.getString("coa_rev"))) == 0)  { 
			        	  if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("qta_rev"))) == 0) {
			        		  if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("coa_rev"))) < 0) {
			  	        	  	strBuilder.append("<TD IMAGE='1'></TD>");
			          		  } else {
			  	        	  	strBuilder.append("<TD IMAGE='0'></TD>");
			          		  }
			        	  } else {
			        		  if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("qta_rev"))) < 0) {
			   	        	  	strBuilder.append("<TD IMAGE='0'></TD>");
			           		  } else {
			   	        	  	strBuilder.append("<TD IMAGE='1'></TD>");
			           		  }        	  
			        	  }
			          }

			          //-- BKG CM --%>
			          strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("qta_cm"))+"</TD>");
			          strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("coa_cm"))+"</TD>");
			           
			          if( Double.parseDouble(JSPUtil.getNull(rowSet.getString("qta_cm")))*Double.parseDouble(JSPUtil.getNull(rowSet.getString("coa_cm"))) > 0 ) { 
			        	  strBuilder.append("<TD>" + JSPUtil.getNull(rowSet.getString("bkg_cm_chng")) + "</TD>");
			        	  
			          } else if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("qta_cm")))*Double.parseDouble(JSPUtil.getNull(rowSet.getString("coa_cm"))) < 0) {
			        	  if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("qta_cm")))>0) {
				        	  strBuilder.append("<TD IMAGE='1'></TD>");
			        	  } else {
				          	  strBuilder.append("<TD IMAGE='0'></TD>");
			        	  }
			        	  
			          } else if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("qta_cm")))*Double.parseDouble(JSPUtil.getNull(rowSet.getString("coa_cm"))) == 0)  { 
			        	  if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("qta_cm"))) == 0) {
			        		  if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("coa_cm"))) < 0) {
			   	        	  	strBuilder.append("<TD IMAGE='1'></TD>");
			           		  } else {
			   	        	  	strBuilder.append("<TD IMAGE='0'></TD>");
			           		  }
			          	  } else {
			          		  if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("qta_cm"))) < 0) {
			   	        	  	strBuilder.append("<TD IMAGE='0'></TD>");
			           		  } else {
			   	        	  	strBuilder.append("<TD IMAGE='1'></TD>");
			           		  }  
			        	  }
			          }
		
			          //-- G.RPB --%>
			          strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("qta_rpb"))+"</TD>");
			          strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("coa_rpb"))+"</TD>");
			           
			          if( Double.parseDouble(JSPUtil.getNull(rowSet.getString("qta_rpb")))*Double.parseDouble(JSPUtil.getNull(rowSet.getString("coa_rpb"))) > 0 ) { 
			        	  strBuilder.append("<TD>" + JSPUtil.getNull(rowSet.getString("rpb_chng")) + "</TD>");
			        	  
			          } else if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("qta_rpb")))*Double.parseDouble(JSPUtil.getNull(rowSet.getString("coa_rpb"))) < 0) {
			        	  if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("qta_rpb")))>0) {
				        	  strBuilder.append("<TD IMAGE='1'></TD>");
			        	  } else {
				          	  strBuilder.append("<TD IMAGE='0'></TD>");
			        	  }
			        	  
			          } else if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("qta_rpb")))*Double.parseDouble(JSPUtil.getNull(rowSet.getString("coa_rpb"))) == 0)  { 
			        	  if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("qta_rpb"))) == 0) {
			        		  if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("coa_rpb"))) < 0) {
			   	        	  	strBuilder.append("<TD IMAGE='1'></TD>");
			           		  } else {
			   	        	  	strBuilder.append("<TD IMAGE='0'></TD>");
			           		  }
			          	  } else {
			          		  if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("qta_rpb"))) < 0) {
			   	        	  	strBuilder.append("<TD IMAGE='0'></TD>");
			           		  } else {
			   	        	  	strBuilder.append("<TD IMAGE='1'></TD>");
			           		  }  
			          	  }
			          }			                 
					  
			          //-- CMB --%>
			          strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("qta_cmb"))+"</TD>");
			          strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("coa_cmb"))+"</TD>");
			           
			          if( Double.parseDouble(JSPUtil.getNull(rowSet.getString("qta_cmb")))*Double.parseDouble(JSPUtil.getNull(rowSet.getString("coa_cmb"))) > 0 ) { 
			        	  strBuilder.append("<TD>" + JSPUtil.getNull(rowSet.getString("cmb_chng")) + "</TD>");
			        	  
			          } else if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("qta_cmb")))*Double.parseDouble(JSPUtil.getNull(rowSet.getString("coa_cmb"))) < 0) {
			        	  if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("qta_cmb")))>0) {
				        	  strBuilder.append("<TD IMAGE='1'></TD>");
			        	  } else {
				          	  strBuilder.append("<TD IMAGE='0'></TD>");
			        	  }
			        	  
			          } else if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("qta_cmb")))*Double.parseDouble(JSPUtil.getNull(rowSet.getString("coa_cmb"))) == 0)  { 
			        	  if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("qta_cmb"))) == 0) {
			        		  if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("coa_cmb"))) < 0) {
			   	        	  	strBuilder.append("<TD IMAGE='1'></TD>");
			           		  } else {
			   	        	  	strBuilder.append("<TD IMAGE='0'></TD>");
			           		  }
			           	  } else {
			           		  if (Double.parseDouble(JSPUtil.getNull(rowSet.getString("qta_cmb"))) < 0) {
			   	        	  	strBuilder.append("<TD IMAGE='0'></TD>");
			           		  } else {
			   	        	  	strBuilder.append("<TD IMAGE='1'></TD>");
			           		  }  
			        	  }
			          }			          
	

			          //-- BSA Capa --%>
			          strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("qta_bsa"))+"</TD>");
			          strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("coa_bsa_capa"))+"</TD>");
			          strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("bsa_chng"))+"</TD>");

			          //-- L/F --%>
			          strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("qta_lf"))+"</TD>");
			          strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("coa_lf"))+"</TD>");
			          strBuilder.append("<TD>"+ (Double.parseDouble(JSPUtil.getNull(rowSet.getString("coa_lf")))-Double.parseDouble(JSPUtil.getNull(rowSet.getString("qta_lf")))) +"</TD>");
			          strBuilder.append("</TR>");					
	    		}
			}	
						    
		    strBuilder.append("      </DATA>");
		    strBuilder.append("<ETC-DATA>");
    		strBuilder.append("<ETC KEY=\"f_pre_week\">"+preWeek+"</ETC>");
		    strBuilder.append("  <ETC KEY=\"sXml4\">");
			strBuilder.append("    <![CDATA[");  	
			strBuilder.append("    <SHEET>");
			strBuilder.append("      <DATA TOTAL=\""+rowCount+"\">");	
		    
			if(rowSet != null){
				rowSet.beforeFirst();
				
				while (rowSet.next()) {
					
					strBuilder.append("<TR>");
			        if(ofc_sts.equals("Y")) { 
			        	strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("ofc_cd1"))+"</TD>");
			        	strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("ofc_cd2"))+"</TD>");
			        } 
			        if(rptItem.equals("1")) {  
			        	strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("trd_cd"))+"</TD>");
			        	
				        if (ias_rgn_sts.equals("Y")) {
					          strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("ias_rgn_cd"))+"</TD>");
				        }
			        	
			        } else if(rptItem.equals("2")) {
			        	strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("trd_cd"))+"</TD>");
			        	
				        if (ias_rgn_sts.equals("Y")) {
					          strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("ias_rgn_cd"))+"</TD>");
				        }
			        	
			        	strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("sub_trd_cd"))+"</TD>");
			        } else if(rptItem.equals("3")) {
			        	strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("trd_cd"))+"</TD>");

			        	if (ias_rgn_sts.equals("Y")) {
					          strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("ias_rgn_cd"))+"</TD>");
				        }
			        	
			        	strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("sub_trd_cd"))+"</TD>");
			        	strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("rlane_cd"))+"</TD>");
			        } else if(rptItem.equals("4")) {
			        	strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("cost_yrmon"))+"</TD>");
			        	strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("cost_wk"))+"</TD>");
			        	strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("trd_cd"))+"</TD>");
			        	
				        if (ias_rgn_sts.equals("Y")) {
					          strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("ias_rgn_cd"))+"</TD>");
				        }
			        	
			        	strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("sub_trd_cd"))+"</TD>");
			        	strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("rlane_cd"))+"</TD>");
			        	strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("vsl_cd")) + JSPUtil.getNull(rowSet.getString("skd_voy_no")) + JSPUtil.getNull(rowSet.getString("dir_cd"))+"</TD>");
			        }
			        if (dir_sts.equals("Y")) {
			        	strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("dir_cd"))+"</TD>");
			        }
			        if (hul_bnd_sts.equals("Y")) {
				          strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("hul_bnd_cd"))+"</TD>");
			        }

			        strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("pol_cd"))+"</TD>");
			        strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("pod_cd"))+"</TD>");
			        strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("mn_sctr_flg"))+"</TD>");
			          

			        if (!rptItem.equals("4") & r_month_sts.equals("Y")) {
			        	strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("cost_yrmon"))+"</TD>");
			        }
			        if (!rptItem.equals("4") & wk_sts.equals("Y")) {
			        	strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("cost_wk"))+"</TD>");
			        } 
			        		  
					  //-- G.REV Increase/Decrease --%>
			        strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("by_load_grev"))+"</TD>");
			        strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("by_rpb_grev"))+"</TD>");
			        strBuilder.append("<TD></TD>");
			          //-- Cost Increase/Decrease --%>
			        strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("by_load_cost"))+"</TD>");
			        strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("by_cpb_cost"))+"</TD>");
			        strBuilder.append("<TD></TD>");
			          //-- Loaded Vol Share --%>
			        strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("qta_load_share"))+"</TD>");
			        strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("coa_load_share"))+"</TD>");
			        strBuilder.append("<TD></TD>");
			          //-- CM Share --%>
			        strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("qta_cm_share"))+"</TD>");
			        strBuilder.append("<TD>"+ JSPUtil.getNull(rowSet.getString("coa_cm_share"))+"</TD>");
			        strBuilder.append("<TD></TD>");

			        strBuilder.append("</TR>");	
					
				}
			}
							
			strBuilder.append("      </DATA>");
		    strBuilder.append("    </SHEET>");
		    strBuilder.append("    ]]>");
		    strBuilder.append("  </ETC>");			
		    strBuilder.append("</ETC-DATA>");
		    
        }
        catch(SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
        catch(Exception ex){
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex.getMessage());
        }	
		
		

		log.debug("########### EsmCoa0070ViewAdapter2 ########### [END]");        
	    return strBuilder.toString();
    }     
}
