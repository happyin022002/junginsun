/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdSce0074ViewAdapter.java
*@FileTitle : EsdSce0074ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-31
*@LastModifier : Jun Byoung Suk
*@LastVersion : 1.0
* 2009-08-31 Jun Byoung Suk
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchMissingListVO;
import com.hanjin.framework.component.common.AbstractValueObject;
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
public class EsdSce0074ViewAdapter extends com.hanjin.framework.core.controller.DefaultViewAdapter{
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
		log.debug("##EsdSce0074- making xml.... event:"+event);
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
        log.debug("##EsdSce0074  Adapter starting....");
        //FormCommand		formcommand	= event.getFormCommand();
        if (event.getFormCommand().isCommand(FormCommand.SEARCH01)|| event.getFormCommand().isCommand(FormCommand.SEARCH02)
        		||event.getFormCommand().isCommand(FormCommand.MULTI01)) {
log.debug("\n SEARCH01||SEARCH02 || MULTI01" );        	
            return makeDataTagForSearch(vos, prefix);
        }else{
log.debug("\n  return null");        	
        	return null;
        }


	}
	
    protected String makeDataTagForSearch(List vos, String prefix)
    {
        StringBuilder sbufXML = new StringBuilder();
        String totCnt = "0";
        int realCnt = vos.size();
log.debug("\n==== realCnt:"+realCnt);        
        AbstractValueObject vo = (AbstractValueObject)vos.get(0);
        String realColNms[] = getColHeader(vo);
        String changedColNms[] = getChangedColNms(realColNms, prefix);
        if(realCnt > 0){
        	SearchMissingListVO tempVo = (SearchMissingListVO)vos.get(0);
        	totCnt = tempVo.getTotcnt();
        }
        sbufXML.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' COLSEPARATOR='").append("\u261C\u261E").append("' TOTAL='").append(totCnt).append("'>\n").toString());
        for(int i = 0; i < realCnt; i++)
        {
            Map colValues = ((AbstractValueObject)vos.get(i)).getColumnValues();
            sbufXML.append("\t<TR><![CDATA[");
            //sbufXML.append("\t<TR>");
            int colCnt = realColNms.length;
            for(int j = 0; j < colCnt - 1; j++){
                sbufXML.append((new StringBuilder(String.valueOf(getNull((String)colValues.get(realColNms[j]))))).append("\u261C\u261E").toString());

            }
            sbufXML.append((new StringBuilder(String.valueOf(getNull((String)colValues.get(realColNms[colCnt - 1]))))).append("]]></TR>\n").toString());
            //sbufXML.append("</TR>\n");
        }

        sbufXML.append("</DATA>\n");
        return sbufXML.toString();
    }

}
