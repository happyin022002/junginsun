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
package com.clt.apps.opus.esd.sce.copmanage.copsearch.event;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.SearchCOPMainListVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 *
 * @author 전병석
 * @see DefaultViewAdapter 클래스 참조
 * @since J2EE 1.5
 */
public class EsdSce0001ViewAdapter extends com.clt.framework.core.controller.DefaultViewAdapter{
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
		log.debug("##EsdSce0001- making xml....");
		return super.makeXML(request, response);
	}
	
	/**
	 * @param prefix String 
	 * @param vos List<AbstractValueObject> 
	 * @return String
	 * @throws
	 */		
	@Override
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
        log.debug("##EsdSce0001  Adapter starting....");
        
        if (event.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
            return makeDataTagForSearch(vos, prefix);
        }else{
        	return null;
        }
	}
	
	/**
	 * make DataTag For Search 
	 * @param List vos
	 * @param String prefix
	 * @return String
	 * @throws
	 */
    protected String makeDataTagForSearch(List<AbstractValueObject> vos, String prefix) {
        StringBuilder sbufXML = new StringBuilder();
        String totCnt = "0";
        int realCnt = vos.size();
        AbstractValueObject vo = (AbstractValueObject)vos.get(0);
        String realColNms[] = getColHeader(vo);
        String changedColNms[] = getChangedColNms(realColNms, prefix);
        
        if(realCnt > 0){
        	SearchCOPMainListVO tempVo = (SearchCOPMainListVO)vos.get(0);
        	totCnt = tempVo.getTotcnt();
        }
        
        sbufXML.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' COLSEPARATOR='").append("\u261C\u261E").append("' TOTAL='").append(totCnt).append("'>\n").toString());
        for(int i = 0; i < realCnt; i++) {
            Map<String, String> colValues = ((AbstractValueObject)vos.get(i)).getColumnValues();
            sbufXML.append("\t<TR><![CDATA[");
            //sbufXML.append("\t<TR>");
            int colCnt = realColNms.length;
            for(int j = 0; j < colCnt - 1; j++){
                sbufXML.append((new StringBuilder(String.valueOf(getNull((String)colValues.get(realColNms[j]))))).append("\u261C\u261E").toString());
//            	String editable = "FALSE";
//            	if("cop_sts_cd".equals(realColNms[j])){
//            		if("T".equals(realColNms[j])|| "F".equals(realColNms[j]) ){
//            			editable = "TRUE";
//            		}
//            	}
//            	if("cop_sub_sts_cd".equals(realColNms[j])){
//            		//sbufXML.append("<TD><![CDATA[]]</TD>".toString());
//            		sbufXML.append("<TD EDIT='"+editable+"'><![CDATA[" + String.valueOf(getNull((String)colValues.get(realColNms[j]))) + "]]></TD>".toString());
//            	}else{
//            		sbufXML.append("<TD><![CDATA[" + String.valueOf(getNull((String)colValues.get(realColNms[j]))) + "]]></TD>".toString());
//
//
//            	}

            }
            sbufXML.append((new StringBuilder(String.valueOf(getNull((String)colValues.get(realColNms[colCnt - 1]))))).append("]]></TR>\n").toString());
            //sbufXML.append("</TR>\n");
        }

        sbufXML.append("</DATA>\n");
        return sbufXML.toString();
    }

}

