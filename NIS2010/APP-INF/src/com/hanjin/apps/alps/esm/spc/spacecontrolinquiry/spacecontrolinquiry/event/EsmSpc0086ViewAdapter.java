/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0086ViewAdapter.java
*@FileTitle : VVD Input
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.21
*@LastModifier : KSJ
*@LastVersion : 1.0
* 2012.09.21 KSJ
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ComplexMainVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.syscommon.common.table.SpcTgtVvdVO;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author 한상훈
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EsmSpc0086ViewAdapter extends ViewAdapter{
	
	
	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 객체
	 * @param colOrder String[] Column명 문자열 
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception 
	 */	
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) 
	{
		StringBuilder sbufXML = new StringBuilder();
		ComplexMainVO complexMainVO = (ComplexMainVO)vos.get(0);
		
		List<SpcTgtVvdVO> voList = complexMainVO.getSpcTgtVvdVOs();
		
		int totCnt  = voList.size();
		int realCnt = voList.size();
		String bse_dt = "";
		
		if( complexMainVO.getEventCommand().equals("SEARCH")){	//2.1
			sbufXML.append("<DATA TOTAL='" + totCnt + "'>\n");
				
  		   for(int i=0;i<realCnt;i++){

				Map<String, String> colValues = voList.get(i).getColumnValues();
				if(i==0){
					bse_dt = colValues.get("bse_dt");
				}
						
				sbufXML.append("<TR>\n");
	            sbufXML.append("<TD></TD>");
	            sbufXML.append("<TD></TD>");
	 			
	            sbufXML.append("<TD>" + colValues.get("trd_cd")   + "</TD>");
	            sbufXML.append("<TD>" + colValues.get("rlane_cd") + "</TD>");
	            sbufXML.append("<TD>" + colValues.get("vvd")      + "</TD>");
			    sbufXML.append("<TD></TD>");
	        
				sbufXML.append("</TR>\n");
				
				
					
			}//For End	

			sbufXML.append("</DATA>\n");
			sbufXML.append("<ETC-DATA>\n");
			sbufXML.append("<ETC KEY=\"bseDt\">").append(bse_dt).append("</ETC>\n");
			sbufXML.append("</ETC-DATA>\n");
	
 	    }//if End

		
		return sbufXML.toString();
	}

	/**
	 * DBRowSet를 Parsing하여 <DATA>태그를 생성한다.<br>
	 * IBSheet의 prefix값이 있는 경우 COLORDER에 prefix를 붙인 column명으로 표시해 준다.<br>
	 * 
	 * @param rs DBRowSet 		VO객체
	 * @param prefix String 		IBSheet savename's prefix string
	 * @return String IBSheet 		<DATA>태그
	 * @exception 
	 */
	@Override
	protected String makeDataTag(DBRowSet arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	
}