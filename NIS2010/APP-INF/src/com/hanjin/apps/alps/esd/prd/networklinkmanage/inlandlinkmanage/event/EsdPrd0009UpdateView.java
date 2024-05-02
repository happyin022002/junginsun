/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EsdPrd0009UpdateView.java
 *@FileTitle : Inland Link management update Viewer
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-08-317
 *@LastModifier : KIMKWIJIN
 *@LastVersion : 1.0
 * 2006-08-30 KIMKWIJIN
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandlinkmanage.event;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;

/**
 * Inland Link management update Viewer
 * 
 * 2009-08-17 kim kwijin 생성
 * @author kim kwijin
 * @see 
 * @since J2EE 1.4
 */
public class EsdPrd0009UpdateView extends ViewAdapter{

	/**
	 *
	 * @param vos
	 * @param prefix
	 * @return
	 */
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix){
		StringBuilder sbufXML = new StringBuilder();
		int totCnt = vos.size();
		int realCnt = vos.size();

		AbstractValueObject vo = (AbstractValueObject) vos.get(0);
//		String[] realColNms = getColHeader(vo);
//		String[] changedColNms = getChangedColNms(realColNms, prefix);

		if(vo.getMaxRows() > 0){
			totCnt = vo.getMaxRows();
		}

		sbufXML.append("<RESULT>");
		sbufXML.append("<TR>");
		for(int i = 0; i < realCnt; i++){
			Map<String, String> colValues = vos.get(i).getColumnValues();
			//log.debug("★:::" + colValues);



			sbufXML.append("<TD><![CDATA[");
			sbufXML.append(getNull(colValues.get("result")) + "]]></TD>\n");
		}
		sbufXML.append("</TR>\n");
		sbufXML.append("<TR-DATA>\n");

		for(int i = 0; i < realCnt; i++){
			Map<String, String> colValues = vos.get(i).getColumnValues();
			sbufXML.append("<TD><_sResult><![CDATA[" + getNull(colValues.get("result")) + "]]></_sResult></TD>");

		}
		sbufXML.append("</TR-DATA>\n");

		sbufXML.append("<ETC-DATA>\n");
		for(int i = 0; i < realCnt; i++){
			if(realCnt == vos.size()){
				Map<String, String> colValues = vos.get(i).getColumnValues();

				sbufXML.append("<ETC KEY='validUpdateRoute'>" + colValues.get("valid_update_route") + "</ETC>");
				sbufXML.append("<ETC KEY='validAgmtNoRoute'>" + colValues.get("valid_agmt_no_route") + "</ETC>");
			}
		}
		sbufXML.append("</ETC-DATA>\n");
		sbufXML.append("</RESULT>");

		return sbufXML.toString();
	}

	/**
	 * 
	 * @param rs
	 * @param prefix
	 * @return
	 */
	protected String makeDataTag(DBRowSet rs, String prefix){

		return "";
	}

	/**
	 *
	 * @param rs
	 * @return
	 */
	protected String makePivotDataTag(DBRowSet rs){
		return "";

	}

	/**
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@Override
	public String makeXML(HttpServletRequest request, HttpServletResponse response){
		Event event = null;
		GeneralEventResponse eventResponse = null;
		Exception serverException = null;
		String strXML = "";

		try{
			serverException = (Exception) request.getAttribute("com.hanjin.framework.core.comm.EXCEPTION_OBJECT      ");

			event = (Event) request.getAttribute("Event");
			eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
//			List rsVoList = null;
//			boolean isSave = isSaveCommand(event);
			if(eventResponse != null){
				strXML = makeDataTag(eventResponse.getRsVoList(), "");
			}
			log.debug(strXML);

		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			strXML = getErrorXML((new ErrorHandler(ex)).loadPopupMessage(), false);
		}
		return strXML;
	}
}
