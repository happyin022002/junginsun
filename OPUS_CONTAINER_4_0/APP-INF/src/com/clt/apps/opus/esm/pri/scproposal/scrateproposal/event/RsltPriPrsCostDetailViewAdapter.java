/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : RsltPriPrsCostDetailViewAdapter.java
*@FileTitle : Default IBSheet Generation Class
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.08.07 공백진
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scrateproposal.event;

import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.RsltPriPrsCostDetailVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Kong Back Jin
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class RsltPriPrsCostDetailViewAdapter extends ViewAdapter {

    /**
     * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
     * 
     * @param vos List<AbstractValueObject> List 객체
     * @param colOrder String[] Column명 문자열 
     * @param prefix String IBSheet savename's prefix
     * @return String <Data>태그 부분의 XML문자열
     * @exception 
     */ 
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
		StringBuilder sbufXML = new StringBuilder();
		int totCnt = vos.size();
		int realCnt = vos.size();

		AbstractValueObject vo = (AbstractValueObject)vos.get(0);
		String[] realColNms=getColHeader(vo);
		String[] changedColNms = getChangedColNms(realColNms, prefix);
		String lvl = null;
		String color = "";
		String level= "";
		
		if(vo.getMaxRows()>0){
			totCnt = vo.getMaxRows();
		}

		
		sbufXML.append("<DATA COLORDER='" + JSPUtil.convertStringArrayToString(changedColNms, "|") + "'  TOTAL='" + totCnt +"'>\n");

		for(int i=0;i<realCnt;i++){
			Map<String, String> colValues = vos.get(i).getColumnValues();
			
		    // 화면에 sheet가 두개 인데 두번째 sheet(RsltPriPrsCostDetailVO) 일때만 동작하면 된다.
			if( vos.get(i) instanceof RsltPriPrsCostDetailVO){
				lvl = colValues.get("lvl");
				if( "0".equals(lvl)){
					color = " BGCOLOR='255,255,180' ";
				}else{
					level  = " LEVEL='"+lvl+"' ";
				}
			}			
			sbufXML.append("	<TR  ").append(color).append(level).append(">");
			int colCnt = realColNms.length;
			
			for (int j = 0 ; j < colCnt ; j++) {
	
				sbufXML.append("<TD>");
				sbufXML.append(getNull(colValues.get(realColNms[j])) );
				sbufXML.append("</TD>\n");
				color = "";
	        }
			sbufXML.append( "</TR>\n");
		}
		sbufXML.append("</DATA>\n");
		
		return sbufXML.toString();
	}

    /**
     * DBRowSet를 Parsing하여 <DATA>태그를 생성한다.<br>
     * IBSheet의 prefix값이 있는 경우 COLORDER에 prefix를 붙인 column명으로 표시해 준다.<br>
     * 
     * @param rs DBRowSet       VO객체
     * @param prefix String         IBSheet savename's prefix string
     * @return String IBSheet       <DATA>태그
     * @exception 
     */
	protected String makeDataTag(DBRowSet rs, String prifix) {
		return null;
	}


}
