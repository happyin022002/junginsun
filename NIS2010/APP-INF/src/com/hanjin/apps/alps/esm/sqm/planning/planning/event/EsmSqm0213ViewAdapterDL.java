/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmSqm0213ViewAdapterDL.java
*@FileTitle : EsmSqm0213ViewAdapterDL
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
* 2015.09.17 김용습 [CHM-201537764] [CSR 전환건] QTA Set up by Head Office for IAS Sector 화면 내 Raw Data Export 버튼 신규 생성 
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.planning.planning.event;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;

/**
 * ESM_SQM_0213에 대한 ViewAdapter<br>
 * - ESM_SQM_0213HTMLAction에서 작성<br>
 *
 * @author 
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmSqm0213ViewAdapterDL extends ViewAdapter {

    public EsmSqm0213ViewAdapterDL(){
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
    	DBRowSet rowSet = eventResponse.getRs();							   	//DB ResultSet
    	String savedName = "RawDataOfQTASetUpByHOSector.csv";
    	
		try{			
    		if(rowSet != null){
        		strBuilder.append("Seq., Year, Quarter, Office View,  Trade, Sub Trade, IAS Region, Lane, Lane Bound,");
        		strBuilder.append("Trade Direction, P/F SKD Group, Supply, RHQ, Office, POL, POD, Main/Sector,");
        		strBuilder.append("Load(Previous Quarter Input Item), G.RPB(Previous Quarter Input Item),G.REV(Previous Quarter Input Item),");
        		strBuilder.append("Load(Input Item), G.RPB(Input Item), G.REV(Input Item),");
        		strBuilder.append("Load(Past MAS PFMC), G.RPB(Past MAS PFMC), G.REV(Past MAS PFMC)");
        		strBuilder.append("\n");

    			int seq=0;
				while(rowSet.next()) {
					seq++;
					strBuilder.append(seq);
					strBuilder.append(",");
						
					for(int k=1; k<=rowSet.getMetaData().getColumnCount(); k++) {
							strBuilder.append(JSPUtil.getNull(rowSet.getString(k)).trim().replaceAll(",", ""));
							strBuilder.append(",");
					}
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

        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex.getMessage());
        }
    	return "";
    }

    /*
 	 * (non-Javadoc)
 	 * 
 	 * @see
 	 * com.hanjin.framework.core.controller.ViewAdapter#makeDataTag(java.util.List, java.lang.String)
 	 */
 	protected String makeDataTag(List<AbstractValueObject> arg0, String arg1) {
 		return null;
 	}

 	/*
 	 * (non-Javadoc)
 	 * 
 	 * @see
 	 * com.hanjin.framework.core.controller.ViewAdapter#makeDataTag(com.hanjin.framework.component.rowset.DBRowSet, java.lang.String)
 	 */
 	protected String makeDataTag(DBRowSet arg0, String arg1) {
 		return null;
 	}
}
