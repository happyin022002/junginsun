/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : DefaultViewAdapter.java
*@FileTitle : Default IBSheet Generation Class
*Open Issues :
*Change history :
*@LastModifyDate : 2008-11-24
*@LastModifier : Lee SeungYol
*@LastVersion : 1.0
* 2008-11-24 Lee SeungYol
* 1.0 최초 생성
* =======================================================
* History : 
* 2010.12.15 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.event;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.coa.common.basic.CommonBC;
import com.hanjin.apps.alps.esm.coa.common.basic.CommonBCImpl;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Lee SeungYol
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EsmCoa0177ViewAdapter extends DefaultViewAdapter {
	
	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 객체
	 * @param colOrder String[] Column명 문자열 
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception 
	 */	
	@SuppressWarnings("unchecked")
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
		StringBuilder sbufXML = new StringBuilder();
		CommonBC commonBc = new CommonBCImpl();
		int totCnt = vos.size();
		int realCnt = vos.size();

		AbstractValueObject vo = (AbstractValueObject)vos.get(0);
		
		HashMap rLane  = null;
		String vRLane = "";
		String trdCd = "";
		String rlaneCd = "";
		String dirCd= "";
		String freqNo= "";
		
		if(vo.getMaxRows()>0){
			totCnt = vo.getMaxRows();
		}
		try {
			rLane  = commonBc.getCodeCombo("rlane_cd", "rLane2", "", "code");
			sbufXML.append("<DATA TOTAL='" + totCnt +"'>\n");
	
			for(int i=0;i<realCnt;i++){
				Map<String, String> colValues = vos.get(i).getColumnValues();
				trdCd = getNull(colValues.get("trd_cd"));
				if(rLane != null){
					vRLane = "" + rLane.get(getNull(trdCd));
					if(i != 0) vRLane = vRLane + "|";
				}
				rlaneCd= JSPUtil.getNull(colValues.get("rlane_cd"));
				dirCd = getNull(colValues.get("dir_cd"));
				freqNo = getNull(colValues.get("freq_no"));
				rlaneCd= getNull(colValues.get("rlane_cd"));
				
				sbufXML.append("<TR>");
				sbufXML.append("<TD></TD>");
				sbufXML.append("<TD></TD>");
				sbufXML.append("<TD>"+trdCd + "</TD>");
				sbufXML.append("<TD COL='rlane_cd'  DATA-TYPE='dtCombo' COMBO-TEXT='" + vRLane +"' COMBO-CODE='"+ vRLane +"'><![CDATA["+rlaneCd+"]]></TD>");
				sbufXML.append("<TD>"+dirCd + "</TD>");
				sbufXML.append("<TD>"+freqNo + "</TD>");
				sbufXML.append("</TR>\n");
			}
			sbufXML.append("</DATA>\n");
		} catch (EventException e) {
			// TODO Auto-generated catch block
			log.error("err " + e.toString(), e);
		}
		
		return sbufXML.toString();
	}

}
