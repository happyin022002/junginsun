
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTrs0028ViewAdapterDL.java
*@FileTitle : EsdTrs0028ViewAdapterDL
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.15
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2009.12.15 박준용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.visibilitymanage.vesselreport.event;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.GeneralEventResponse;

/**
 * ESD_TRS_0128 에 대한 ViewAdapter<br>
 * - ESD_TRS_0128HTMLAction에서 작성<br>
 *
 * @author 박준용
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsdSce0205ViewAdapterDL extends ViewAdapter {
	
    public EsdSce0205ViewAdapterDL(){
    	super();
    }
    
	/**
	 * View Adapter 생성시 자동으로 호출된다.<br>
	 *  <br>
	 * 
	 * @param HttpServletRequest request
	 * @param HttpServletResponse response
	 * @return String
	 * @exception EventException
	 */	      
    public String makeXML(HttpServletRequest request, HttpServletResponse response) {
    	GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse"); 
 		
 		StringBuilder strBuilder = new StringBuilder();
    	DBRowSet rowSet = null;							   	//DB ResultSet
    	String savedName = "ESD_SCE_0205DL.csv";  
 		
    	rowSet = (DBRowSet)eventResponse.getCustomData("rowset");
    	String[] title = (String[])eventResponse.getCustomData("title");
    	
		try{			
    		if(rowSet != null){
    			for(int i =0; i < title.length; i ++){
					strBuilder.append(title[i]);
					strBuilder.append(",");    				
    			}
    			strBuilder.append("\n");
    			int seq=0;
				while(rowSet.next()){
					
					strBuilder.append(seq);
					strBuilder.append(",");	
					seq++;
					
					strBuilder.append(JSPUtil.getNull(rowSet.getString("bkg_no")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("bl_no")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("unmatch_flg")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("bkg_pod_cd")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("bkg_del_cd")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("cop_pod_cd")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("cop_del_cd")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("cntr_no")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("tpsz")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("mvmt_sts")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("mvmt_yd")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("mvmt_dt")).trim().replaceAll(",", "")).append(",");

					strBuilder.append(JSPUtil.getNull(rowSet.getString("dup_flg")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("vvd")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("lane")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("eta")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("spe")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("rail_dest")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("cstms_loc_cd")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("eq_ctrl_ofc_cd")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("term")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("add_trsp")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("rl_so_pln_flg")).trim().replaceAll(",", "")).append(",");

					strBuilder.append(JSPUtil.getNull(rowSet.getString("rl_so_flg")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("rl_wo_flg")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("ts_so_pln_flg")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("ts_so_flg")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("ts_wo_flg")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("dr_so_pln_flg")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("dr_so_flg")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("dr_wo_flg")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("dr_wo_dt")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("dr_fm")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("dr_to")).trim().replaceAll(",", "")).append(",");
					
					strBuilder.append(JSPUtil.getNull(rowSet.getString("dr_sp")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("dr_sp_nm")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("cop_sts_cd")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("frm")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("guide")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("pkup_yd_cd")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("pkup_aval_dt")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("pkup_free_dt")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("f")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("o")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("c")).trim().replaceAll(",", "")).append(",");
					
					strBuilder.append(JSPUtil.getNull(rowSet.getString("dspo_cd")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("pkup_no")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("pkup_ofc_cd")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("pkup_end")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("sc_no")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("cnee_nm")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("cnee_addr")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("shpr_nm")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("shpr_addr")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("ntfy_nm")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("ntfy_addr")).trim().replaceAll(",", "")).append(",");
					
					strBuilder.append(JSPUtil.getNull(rowSet.getString("filer")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("it_no")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("it_date")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("po_no")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("seal_no")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("cntr_wgt")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("clm_crnt_sts")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("clm_loc")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("clm_state")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("clm_dt")).trim().replaceAll(",", "")).append(",");
					strBuilder.append(JSPUtil.getNull(rowSet.getString("bkg_cntr_rmk")).trim().replaceAll(",", "")).append(",");
					
					/*for(int k=1; k<=rowSet.getMetaData().getColumnCount(); k++){
//						strBuilder.append(JSPUtil.getNull(rowSet.getString(k)));
						strBuilder.append(JSPUtil.getNull(rowSet.getString(k)).trim().replaceAll(",", ""));
						strBuilder.append(",");						
					}*/
					strBuilder.append("\n");
				}
			}  
     			
 			response.reset();
 			response.setContentType("application/vnd.ms.excel");
 			String strClient = request.getHeader("user-agent");
 
 			if (strClient.indexOf("MSIE 5.5") != -1) {
 				response.setHeader("Content-Type",
 						"doesn/matter; charset=euc-kr");
 				response.setHeader("Content-Disposition", "filename="
 						+ savedName + "; charset=euc-kr");
 			} else {
 				response.setHeader("Content-Type",
 						"application/octet-stream; charset=euc-kr");
 				response.setHeader("Content-Disposition",
 						"attachment;filename=" + savedName + ";");
 			} 			     		
     		
    		PrintWriter pout = response.getWriter();
			pout.print(strBuilder.toString());
			pout.flush();
			pout.close();
    				    
        }    	
    	catch(Exception ex){
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex.getMessage());
        }    	
    	return "";
    }
    
    /*
 	 * (non-Javadoc)
 	 * 
 	 * @see
 	 * com.clt.framework.core.controller.ViewAdapter#makeDataTag(java.util
 	 * .List, java.lang.String)
 	 */
 	protected String makeDataTag(List<AbstractValueObject> arg0, String arg1) {
 		return null;
 	}
 
 	/*
 	 * (non-Javadoc)
 	 * 
 	 * @see
 	 * com.clt.framework.core.controller.ViewAdapter#makeDataTag(com.clt
 	 * .framework.component.rowset.DBRowSet, java.lang.String)
 	 */
 	protected String makeDataTag(DBRowSet arg0, String arg1) {
 		return null;
 	}
}
