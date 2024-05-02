/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : DefaultViewAdapter.java
*@FileTitle : Default IBSheet Generation Class
*Open Issues :
*Change history :
*@LastModifyDate : 2012-05-31
*@LastModifier : SHKIM
*@LastVersion : 1.0
* 1.0 최초 생성
* =======================================================
* History : 
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.event;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.mas.common.basic.CommonBC;
import com.hanjin.apps.alps.esm.mas.common.basic.CommonBCImpl;
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
public class EsmMas0121ViewAdapter extends DefaultViewAdapter {
	
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
		String subTrdCd= "";
		String rlaneCd = "";
		String dirCd= "";
		String convDirCd= "";
		
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
				subTrdCd = getNull(colValues.get("sub_trd_cd"));
				rlaneCd= getNull(colValues.get("rlane_cd"));
				dirCd = getNull(colValues.get("dir_cd"));
				convDirCd = getNull(colValues.get("conv_dir_cd"));
				
				sbufXML.append("<TR>");
				sbufXML.append("<TD></TD>");
				sbufXML.append("<TD></TD>");
				sbufXML.append("<TD>"+trdCd + "</TD>");				
				sbufXML.append("<TD>"+subTrdCd + "</TD>");
				sbufXML.append("<TD COL='rlane_cd'  DATA-TYPE='dtCombo' COMBO-TEXT='" + vRLane +"' COMBO-CODE='"+ vRLane +"'><![CDATA["+rlaneCd+"]]></TD>");
				sbufXML.append("<TD>"+dirCd + "</TD>");
				sbufXML.append("<TD>"+convDirCd + "</TD>");
				
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
