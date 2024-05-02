/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0021ViewAdapter8.java
*@FileTitle : spacecontrolinquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.27
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ComplexMainVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiry021AllocPortViewListVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.core.layer.event.EventResponse;



/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author 한상훈
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EsmSpc0021ViewAdapter8 extends ViewAdapter{
	
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
				
		ComplexMainVO comMain = (ComplexMainVO)vos.get(0);
		
	
		List<SearchSpaceControlInquiry021AllocPortViewListVO> viewList = new ArrayList<SearchSpaceControlInquiry021AllocPortViewListVO>();

		viewList = comMain.getInquiry021AllocPortViewListVO();
		
		
		
		int rowCountview = viewList.size();
		String trd_cd = "";
		String rlane_cd = "";
		
		sbufXML.append("<DATA TOTAL=\""+rowCountview+"\">\n");
		
		if (rowCountview > 0 && viewList != null) {//3.1
			for(int i =0 ; i < rowCountview ; i++){
				
				trd_cd = viewList.get(i).getTrdCd();
				rlane_cd = viewList.get(i).getRlaneCd();
				
				sbufXML.append("<tr BGCOLOR=\"").append(trd_cd.equals("Grand")?"223,232,247":(rlane_cd.isEmpty()?"247,231,236":"")).append("\">\n");
				sbufXML.append("<td BGCOLOR=\"").append(trd_cd.equals("Grand")?"":"223,232,247").append("\">" + trd_cd  + "</td>\n");
				sbufXML.append("<td BGCOLOR=\"").append(rlane_cd.isEmpty()?"":"232,255,198").append("\">" + (rlane_cd.isEmpty()?trd_cd:rlane_cd.substring(0, 3)) + "</td>\n");
				sbufXML.append("<td>" + (viewList.get(i).getVvd1().isEmpty()?"Total":viewList.get(i).getVvd1()) + "</td>\n");
				sbufXML.append("<td>" + viewList.get(i).getAqCd() + "</td>\n");
				
				for(int j=1; j<7; j++){
					String temp1 = "";
					String temp2 = "";
					String temp3 = "";
					String temp4 = "";
					String temp5 = "";
					
					switch(j){
					case 1: 
						temp1 = viewList.get(i).getQta11();
						temp2 = viewList.get(i).getFct11();
						temp3 = viewList.get(i).getBkg11();
						temp4 = viewList.get(i).getPref11();
						temp5 = viewList.get(i).getAlc11();
						break;
					case 2: 
						temp1 = viewList.get(i).getQta21();
						temp2 = viewList.get(i).getFct21();
						temp3 = viewList.get(i).getBkg21();
						temp4 = viewList.get(i).getPref21();
						temp5 = viewList.get(i).getAlc21();
						break;
					case 3: 
						temp1 = viewList.get(i).getQta31();
						temp2 = viewList.get(i).getFct31();
						temp3 = viewList.get(i).getBkg31();
						temp4 = viewList.get(i).getPref31();
						temp5 = viewList.get(i).getAlc31();
						break;
					case 4: 
						temp1 = viewList.get(i).getQta41();
						temp2 = viewList.get(i).getFct41();
						temp3 = viewList.get(i).getBkg41();
						temp4 = viewList.get(i).getPref41();
						temp5 = viewList.get(i).getAlc41();
						break;
					case 5: 
						temp1 = viewList.get(i).getQta51();
						temp2 = viewList.get(i).getFct51();
						temp3 = viewList.get(i).getBkg51();
						temp4 = viewList.get(i).getPref51();
						temp5 = viewList.get(i).getAlc51();
						break;
					case 6: 
						temp1 = viewList.get(i).getQta61();
						temp2 = viewList.get(i).getFct61();
						temp3 = viewList.get(i).getBkg61();
						temp4 = viewList.get(i).getPref61();
						temp5 = viewList.get(i).getAlc61();
						break;
					}
					sbufXML.append("<td DATA-FORMAT=\"dfInteger\">" + temp1 + "</td>\n");
					sbufXML.append("<td DATA-FORMAT=\"dfInteger\">" + temp2 + "</td>\n");
					sbufXML.append("<td DATA-FORMAT=\"dfInteger\">" + temp3 + "</td>\n");
					sbufXML.append("<td DATA-FORMAT=\"dfNone\">"    + temp4 + "%</td>\n");
					
					if(j==4||j==5||j==6){
						sbufXML.append("<td DATA-FORMAT=\"dfInteger\">" + temp5 + "</td>\n");
					}
				}

				sbufXML.append("<td></td>\n");
				sbufXML.append("</tr>\n");
			}
			
		}
		sbufXML.append("</DATA>\n");
		
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
	protected String makeDataTag(DBRowSet rs,String prefix) {
		StringBuilder sb = new StringBuilder();
		
		return sb.toString();
	} 
	
	/**
	 * Pivot Table용 Data tag를 생성한다.<br>
	 * 
	 * @param rs			DBRowSet 		VO객체
	 * @return String 	IBSheet 			<DATA>태그
	 * @exception 
	 */
	protected String makePivotDataTag(DBRowSet rs) {
		StringBuilder sb = new StringBuilder();

		return sb.toString();
	}
	
	protected String getETCData(EventResponse eventResponse) {
		return "";
	}
}