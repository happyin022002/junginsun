/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0033ViewAdapterDL.java
*@FileTitle : EsmAcm0033ViewAdapterDL
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.14
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.06.14 김봉균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.event;

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
 * ESM_ACM_0033 에 대한 ViewAdapter<br>
 * - ESM_ACM_0033HTMLAction에서 작성<br>
 *
 * @author 김봉균
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmAcm0033ViewAdapterDL extends ViewAdapter {

    public EsmAcm0033ViewAdapterDL(){
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
    	String savedName = "ESM_ACM_0033DL.csv";
    	String excel_flg = JSPUtil.getParameter(request, "excel_flg");
    	
		try{
    		if(rowSet != null){
        		strBuilder.append("Seq., BKG No., B/L No., Bound, Type, Account, R.VVD, R.Mon, Com. VVD,");
        		strBuilder.append("S/A Date, BKG Q'ty, BKG Rev, CHG DDT, Trans DDT, S. Comp, Rev. DDT,");
        		strBuilder.append("Comm AMT, RESPB_OFC, AR_OFC_CD, AP_OFC_CD, HQ_OFC_CD, OFC_CHR_LVL,");
        		if(excel_flg.equals("Y")){
        			strBuilder.append("Simulation No,");        			
        		}
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
