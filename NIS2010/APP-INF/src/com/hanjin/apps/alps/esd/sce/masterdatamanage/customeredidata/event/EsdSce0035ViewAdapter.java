/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName :  EsdSce0035ViewAdapter.java
*@FileTitle : EsdSce0035ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2009-11-03
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2009-11-03 전병석
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 *
 * @author 전병석
 * @see DefaultViewAdapter 클래스 참조
 * @since J2EE 1.5
 */
public class EsdSce0035ViewAdapter extends com.hanjin.framework.core.controller.DefaultViewAdapter{
	Event event = null;
	/**
	 * @param request HttpServletRequest 
	 * @param response HttpServletResponse   
	 * @return String
	 * @throws
	 */	
	@Override
	public String makeXML(HttpServletRequest request, HttpServletResponse response){  
		event		= (Event)request.getAttribute("Event");
		//FormCommand		formcommand	= event.getFormCommand();
		log.debug("##EsdSce0035- making xml....");
		if(event.getFormCommand().isCommand(FormCommand.MULTI05)){
			   String xml = super.makeXML(request, response);
			   if(xml != null && xml.indexOf("etc_count") >=0){
				   return xml;
			   }else{
				   return "";
			   }
			   
		}else{
			   return super.makeXML(request, response);
		}//if
		 
	}
	
	
	/**
	 * @param prefix String 
	 * @param vos List<AbstractValueObject> 
	 * @return String
	 * @throws
	 */		
	@Override
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
        log.debug("##EsdSce0035  Adapter starting....");
        //FormCommand		formcommand	= event.getFormCommand();

//        if (event.getFormCommand().isCommand(FormCommand.SEARCH01)) {
//            
//        }else if(event.getFormCommand().isCommand(FormCommand.SEARCH02)) {
//            
//        }else if(event.getFormCommand().isCommand(FormCommand.SEARCH03)) {
//           
//        }else if(event.getFormCommand().isCommand(FormCommand.MULTI01)) {
//            
//        }else if(event.getFormCommand().isCommand(FormCommand.MULTI02)) {
//            
//        }else if(event.getFormCommand().isCommand(FormCommand.MULTI03)) {
//            
//        }else if(event.getFormCommand().isCommand(FormCommand.MULTI04)) {
//           
//        }
        
        if(event.getFormCommand().isCommand(FormCommand.MULTI05)) {
         /*Creating ETC Data*/
        	return makeDataTagForETC(vos,prefix);
        }else if(event.getFormCommand().isCommand(FormCommand.MULTI06)) {
        /*Creating ETC Data*/
        	return super.makeDataTag(vos, prefix);
        }//if
        
        return null;
	}
	/**
	 * @param vos DBRowSet  
	 * @param prefix String  
	 * @return String
	 * @throws
	 */		
	@Override
	protected String makeDataTag(DBRowSet vos, String prefix){
        log.debug("##EsdSce0035  Adapter Rowset starting....");
        //FormCommand		formcommand	= event.getFormCommand();
        if (event.getFormCommand().isCommand(FormCommand.SEARCH01)) {
        	return super.makeDataTag(vos, prefix);
        }else if(event.getFormCommand().isCommand(FormCommand.SEARCH02)) {
        	return super.makeDataTag(vos, prefix);
        }else if(event.getFormCommand().isCommand(FormCommand.SEARCH03)) {
        	return super.makeDataTag(vos, prefix);
        }else if(event.getFormCommand().isCommand(FormCommand.MULTI01)) {
        	return super.makeDataTag(vos, prefix);
        }else if(event.getFormCommand().isCommand(FormCommand.MULTI02)) {
        	return super.makeDataTag(vos, prefix);
        }else if(event.getFormCommand().isCommand(FormCommand.MULTI03)) {
        	return super.makeDataTag(vos, prefix);
        }else if(event.getFormCommand().isCommand(FormCommand.MULTI04)) {
        	return super.makeDataTag(vos, prefix);
        } //else if(event.getFormCommand().isCommand(FormCommand.MULTI05)) {
         /*Do Nothing*/
        else if(event.getFormCommand().isCommand(FormCommand.MULTI06)) {
        /*Creating ETC Data*/
        	return super.makeDataTag(vos, prefix);
        }//if
        return null;
	}
	/** etc 데이터를  위한 XML 출력을  하는 함수
	 * @param vos List<AbstractValueObject>
	 * @param prefix String     
	 * @return String
	 * @throws
	 */		
	protected String makeDataTagForETC(List<AbstractValueObject> vos, String prefix) {
		StringBuffer sbufXML = new StringBuffer();
		sbufXML.append("<ETC-DATA>");
		if(vos != null){
			Map<String, String> colValues = null;
			int realCnt = vos.size();
			
			if(realCnt>0){
					colValues = vos.get(0).getColumnValues();
					sbufXML.append("<ETC NAME='etc_count'><![CDATA[" + realCnt + "]]></ETC>" + "\n");
					sbufXML.append("<ETC NAME='cs_grp_id'><![CDATA[" + JSPUtil.getNull(colValues.get("cs_grp_id")) + "]]></ETC>" + "\n");
					sbufXML.append("<ETC NAME='tp_id'><![CDATA[" + JSPUtil.getNull(colValues.get("tp_id")) + "]]></ETC>" + "\n");
					sbufXML.append("<ETC NAME='grp_nm'><![CDATA[" + JSPUtil.getNull(colValues.get("cs_desc")) + "]]></ETC>" + "\n");
					sbufXML.append("<ETC NAME='edi_sts'><![CDATA[" + JSPUtil.getNull(colValues.get("edi_sts")) + "]]></ETC>" + "\n");
					sbufXML.append("<ETC NAME='tp_id_cnt'><![CDATA[" + JSPUtil.getNull(colValues.get("cust_cd"))+ "]]></ETC>" + "\n");
			}
		}else{
			sbufXML.append("<ETC NAME='etc_count'><![CDATA[]]></ETC>\n");
			sbufXML.append("<ETC NAME='cs_grp_id'><![CDATA[]]></ETC>\n");
			sbufXML.append("<ETC NAME='tp_id'><![CDATA[]]></ETC>\n");
			sbufXML.append("<ETC NAME='grp_nm'><![CDATA[]]></ETC>\n");
			sbufXML.append("<ETC NAME='edi_sts'><![CDATA[]]></ETC>\n");
			sbufXML.append("<ETC NAME='tp_id_cnt'><![CDATA[]]></ETC>\n");			
		}
		
		sbufXML.append("</ETC-DATA>");		
		return sbufXML.toString();
	}

}
