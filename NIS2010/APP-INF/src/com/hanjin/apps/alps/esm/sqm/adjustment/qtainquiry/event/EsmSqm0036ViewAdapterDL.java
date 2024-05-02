/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmSqm0036ViewAdapterDL.java
*@FileTitle : EsmSqm0036ViewAdapterDL
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
* 2015.02.17 이혜민				   RHQ, Office 컬럼 Supply 뒤에 위치
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.adjustment.qtainquiry.event;

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
 * ESM_SQM_0036에 대한 ViewAdapter<br>
 * - ESM_SQM_0036HTMLAction에서 작성<br>
 *
 * @author 이혜민
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmSqm0036ViewAdapterDL extends ViewAdapter {

    public EsmSqm0036ViewAdapterDL(){
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
    	String savedName = "YearlyReport.csv";

		try{			
    		if(rowSet != null){
        		strBuilder.append("Seq., Year, Y/Q, Office View,  Trade, Sub Trade, Lane, Lane Bound,");
        		strBuilder.append("Trade Direction, Month, Week, VVD, Supply, RHQ, Office, Load, G.REV,");
        		strBuilder.append("G.RPB, Decimal G.RPB, CM Cost(PA), CM Cost(RA), CMCB(PA), CMCB(RA), CM(PA), CM(RA), CMPB(PA), CMPB(RA)");
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
