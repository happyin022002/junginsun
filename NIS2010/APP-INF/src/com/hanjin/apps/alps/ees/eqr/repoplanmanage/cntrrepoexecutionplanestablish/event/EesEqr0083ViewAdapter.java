
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0083ViewAdapter.java
*@FileTitle : EesEqr0083 화면 조회 시 데이터 가져오기  IBSheet Generation Class
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-21
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009-08-21 정은호
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event;

import java.sql.SQLException;
import java.util.List;

import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0059ConditionVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.controller.ViewAdapter;

/**
 * EesEqr0083 화면 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author ChungEunHo
 * @see ViewAdapter 참조
 * @since J2EE 1.6
 */
public class EesEqr0083ViewAdapter extends ViewAdapter {

	
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
		CommonRsVO listVO = new CommonRsVO();
		AbstractValueObject rsVO = (AbstractValueObject)vos.get(0);
		ObjectCloner.build(rsVO, listVO);
		EesEqr0059ConditionVO conditionVO = (EesEqr0059ConditionVO) listVO.getConditionVO();
		DBRowSet rowSet  = listVO.getDbRowset();
	
		StringBuilder sbufXML = new StringBuilder();
		int rowCount	 = 0;								 //DB ResultSet 리스트의 건수

		String tpsztype  = "";
		String[] tpszArr= null;
		int tpszLength = 0;
		int editPosition = 0;  // edit 여부를 결정하는 변수
		int colCount = 0;
		if(rowSet != null){
			 rowCount = rowSet.getRowCount();
		} 
		sbufXML.append("<DATA TOTAL='"+rowCount+"'>\n");
		
		tpsztype = conditionVO.getTpsztype();
		tpszArr  = tpsztype.split(",");
		tpszLength=tpszArr.length;
		
		editPosition = tpszLength*2 + 13 + 4;  // edit 여부를 결정하는 변수
		String editStatus = "";
		String dataFormat = "";	
		String rowBgColor = "";
		
		int i =1;
		try {
			
			if (rowSet != null) {
				colCount = rowSet.getMetaData().getColumnCount();
			// INLAND 는 FROM, TO중 하나만 맞으면 작업을 허용합니다.
				while (rowSet.next()) {
					if(rowSet.getString(editPosition).equals("2")    &&      // SORTNUM, EXECUTE라인
					   rowSet.getString(editPosition + 1).equals("1") &&     // NUM      NORMAL 라인
					   !rowSet.getString(11).equals("Y")       	  			 // SO ISS FLAG 'Y'가 아닌 경우
					) {   
						editStatus="";
					}else {
						editStatus="EDIT=\"FALSE\" "; 
					}	
					
					// ROW별 색상셋팅(TOTAL, SUB TOTAL, PLAN)
					if(rowSet.getString(editPosition + 1).equals("2") ) {      // SUB TOTAL 라인					   
						rowBgColor="BGCOLOR=\"249,223,155\" ";
					}else if(rowSet.getString(editPosition + 1).equals("3") ) {// GRAND TOTAL 라인					   
						rowBgColor="BGCOLOR=\"254,189,182\" ";
					}else {
						rowBgColor=""; 
					}		
					sbufXML.append("<TR "+editStatus+" "+ rowBgColor+" >\n");
					sbufXML.append("<TD>R</TD>\n");
					sbufXML.append("<TD></TD>\n");
					for (int j=0; j< colCount; j++) {
						if(j==10) {  //so send check box 제어
							if(rowSet.getString(editPosition).equals("2") && rowSet.getString(editPosition+1).equals("1")) {
								dataFormat="DATA-TYPE=\"dtCheckBox\" ";
							}else {
								dataFormat="";
							}
						}else {
							dataFormat=""; 
						}		 
						sbufXML.append("<TD "+dataFormat +" ><![CDATA["+JSPUtil.getNull(rowSet.getString(i++)) +"]]></TD>\n");
					}
					sbufXML.append("</TR>\n");
					i = 1;
					
				}
			}
		}catch(SQLException ex){
			throw new RuntimeException(ex.getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
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

}
