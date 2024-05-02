/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerPurTrendViewAdapter.java
*@FileTitle : Container Purchasing Trend by Year inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.06.30 이호선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.event;
import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;

/**
 * IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author LEE HO SUN
 * @see ViewAdapter 참조      
 * @since J2EE 1.6   
 */
public class ContainerPurTrendViewAdapter extends ViewAdapter {

	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 객체
	 * @param colOrder String[] Column명 문자열 
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception 
	 */	
	protected String makeDataTag(List<AbstractValueObject> vos, String arg1) {

		StringBuilder sbufXML = new StringBuilder();
		
		int totCnt = vos.size();
		int realCnt = vos.size();

		AbstractValueObject vo = (AbstractValueObject)vos.get(0);
		if(vo.getMaxRows()>0){
			totCnt = vo.getMaxRows();
		}
		
		sbufXML.append("<DATA COLSEPARATOR='|' TOTAL='" + totCnt +"'>\n");

		for(int i=0;i<realCnt;i++){
			Map<String, String> colValues = vos.get(i).getColumnValues();
			
			sbufXML.append("<TR><![CDATA[\n");
			sbufXML.append(JSPUtil.getNull(colValues.get("pur_list")+"]]></TR>\n"));
		}
		sbufXML.append("</DATA>\n");
		return sbufXML.toString();

	}

	@Override
	protected String makeDataTag(DBRowSet arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
