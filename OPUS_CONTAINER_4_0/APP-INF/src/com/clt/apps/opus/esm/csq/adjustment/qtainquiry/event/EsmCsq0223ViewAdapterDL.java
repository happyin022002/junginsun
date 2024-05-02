/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmCsq0223ViewAdapterDL.java
*@FileTitle : EsmCsq0223ViewAdapterDL
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.adjustment.qtainquiry.event;

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
 * ESM_CSQ_0223에 대한 ViewAdapter<br>
 * - ESM_CSQ_0223HTMLAction에서 작성<br>
 *
 * @author 이혜민
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCsq0223ViewAdapterDL extends ViewAdapter {

    public EsmCsq0223ViewAdapterDL(){
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
    	String savedName = "YearlyReportSector.csv";

		try{			
    		if(rowSet != null){
        		strBuilder.append("Seq., Year, Office View, Trade, Sub Trade, R.Lane, Lane Bound,");
        		strBuilder.append("Month, Week, VVD, Supply, RHQ, Office, POL, POD, Main/Sector, Load, G.RPB,");
        		strBuilder.append("G.REV, CM Cost(PA), CM Cost(RA), CMCB(PA), CMCB(RA), CM(PA), CM(RA), CMPB(PA), CMPB(RA)");
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
 	 * com.clt.framework.core.controller.ViewAdapter#makeDataTag(java.util.List, java.lang.String)
 	 */
 	protected String makeDataTag(List<AbstractValueObject> arg0, String arg1) {
 		return null;
 	}

 	/*
 	 * (non-Javadoc)
 	 * 
 	 * @see
 	 * com.clt.framework.core.controller.ViewAdapter#makeDataTag(com.clt.framework.component.rowset.DBRowSet, java.lang.String)
 	 */
 	protected String makeDataTag(DBRowSet arg0, String arg1) {
 		return null;
 	}
}
