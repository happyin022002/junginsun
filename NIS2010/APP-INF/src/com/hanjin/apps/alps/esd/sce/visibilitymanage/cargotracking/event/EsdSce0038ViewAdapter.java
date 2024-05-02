/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdSce0038ViewAdapter.java
*@FileTitle : EsdSce0038ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-18
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2006-09-18 전병석
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.cargotracking.event;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
/**
 * EsdSce038 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EsdSce038HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seong-mun Kang
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */ 
public class EsdSce0038ViewAdapter extends com.hanjin.framework.core.controller.DefaultViewAdapter{
	Event event = null;
	/**
	 * @param request HttpServletRequest 
	 * @param response HttpServletResponse 
	 * @return
	 * @throws
	 */
	public String makeXML(HttpServletRequest request, HttpServletResponse response){  
		event		= (Event)request.getAttribute("Event");
//		FormCommand		formcommand	= event.getFormCommand();
		log.debug("##EsdSce0038- making xml....");	
		return super.makeXML(request, response);
	}
	/**
	 * @param vos List<AbstractValueObject>
	 * @param prefix String 
	 * @return String 
	 * @throws
	 */	
	@Override
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
		log.debug("##EsdSce0038- makeDataTag List....");
	    
		if(event.getFormCommand().isCommand(FormCommand.SEARCH)) {
        	return super.makeDataTag(vos, prefix);
	    }else{
	    	return super.makeDataTag(vos, prefix);
	    }
	}
	/**
	 * @param vos DBRowSet 
	 * @param prefix String 
	 * @return String 
	 * @throws
	 */		
	@Override
	protected String makeDataTag(DBRowSet vos, String prefix){
//		FormCommand		formcommand	= event.getFormCommand();
		log.debug("##EsdSce0038- makeDataTag RowSet....");
		
		if(event.getFormCommand().isCommand(FormCommand.SEARCH)) {
        	return makeDataTagForETC(vos, prefix);
	    }else{
	    	return super.makeDataTag(vos, prefix);
	    }
	}	
	/**
	 * @param eventResponse EventResponse 
	 * @return String 
	 * @throws
	 */		
	@Override
	protected String getETCData(EventResponse eventResponse) {
		HashMap map = (HashMap)eventResponse.getETCData();
		
		if(map != null)// in order to use the original ETC Data, as the framework function dose,
			return super.getETCData(eventResponse);
		else          // in order to use overridden function in this class, neutralize the original function of getETCData.  
		    return "";
	}
	/**
	 * @param rs DBRowSet
	 * @param prefix String 
	 * @return String 
	 * @throws
	 */		
	protected String makeDataTagForETC(DBRowSet rs, String prefix) {
		StringBuffer sbufXML = new StringBuffer();
		sbufXML.append("<ETC-DATA>");
		try {
			  if(rs.next()){
					sbufXML.append("<ETC NAME='cust_nm'><![CDATA[" +  JSPUtil.getNull(rs.getObject("cust_lgl_eng_nm")) + "]]></ETC>" + "\n");
			  }//if
		} catch(Exception e){
			throw new RuntimeException(e.getMessage());  
        }
		sbufXML.append("</ETC-DATA>");
		
		return sbufXML.toString();
	}

}
