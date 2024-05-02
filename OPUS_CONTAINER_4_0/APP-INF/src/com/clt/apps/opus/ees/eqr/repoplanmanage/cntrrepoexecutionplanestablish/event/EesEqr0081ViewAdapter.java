
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0081ViewAdapter.java
*@FileTitle : EesEqr0081 화면  조회 데이터 가져오기  IBSheet Generation Class
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-11
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009-09-11 정은호
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event;

import java.sql.SQLException;
import java.util.List;

import com.clt.apps.opus.ees.eqr.common.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0059ConditionVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.controller.ViewAdapter;

/**
 * EesEqr0081 화면 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author ChungEunHo
 * @see ViewAdapter 참조
 * @since J2EE 1.6
 */
public class EesEqr0081ViewAdapter extends ViewAdapter {

	
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
		String tpsztype  = "";
		String[] tpszArr= null;
		int tpszLength 		= 0;
		int editPosition 	= 0;  // edit 여부를 결정하는 변수
		int rowCount	 	= 0;
		int colCount 		= 0;

		String user_level 			= "";
		String user_modify_location = "";
		
		String editStatus = "";
		String dataFormat = "";
		String rowBgColor = "";	
		
		int i =1;
		
		StringBuilder sbufXML = new StringBuilder();
		
		try {
			tpsztype = conditionVO.getTpsztype();
			tpszArr  = tpsztype.split(",");
			tpszLength=tpszArr.length;
			
			editPosition = tpszLength*1 + 16 + 7 ;  // edit 여부를 결정하는 변수(SORTNUM 위치)

			user_level 			 = conditionVO.getUserLevel();
			user_modify_location = conditionVO.getUserModifyLocation();	
			if(rowSet != null){
				rowCount = rowSet.getRowCount();
			}
			sbufXML.append("<DATA TOTAL='"+rowCount+"'>");
			if (rowSet != null) {
				colCount = rowSet.getMetaData().getColumnCount();
				// INLAND 는 FROM, TO중 하나만 맞으면 작업을 허용합니다.
				while (rowSet.next()) {
					editStatus = "";
					dataFormat = "";
					rowBgColor = "";
					if(rowSet.getString(editPosition).equals("2")     &&    // SORTNUM, EXECUTE라인
					   rowSet.getString(editPosition + 1).equals("1") &&    // NUM      NORMAL 라인
					   !rowSet.getString(12).equals("Y")              && 
					   !rowSet.getString(13).equals("Y")             
					  /* &&    // SO ISS FLAG, NO SO ISS FLAG둘다 'Y'가 아닌 경우
					   (                                                    // FROM, TO 어느 한쪽만 맞아도 인정
					   	   user_level.equals("1")                                                                      ||	   
						   (user_level.equals("2") && (user_modify_location.equals(rowSet.getString(editPosition + 2)) || user_modify_location.equals(rowSet.getString(editPosition + 3))) ) || 
						   (user_level.equals("5") && (user_modify_location.equals(rowSet.getString(editPosition + 4)) || user_modify_location.equals(rowSet.getString(editPosition + 5))) ) 	
					   )*/
					   
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
					}else if(rowSet.getString(editPosition).equals("1") ) {    // PLAN 라인					   
						rowBgColor="BGCOLOR=\"203,239,234\" ";
					}else {
						rowBgColor=""; 
					}
					
					sbufXML.append("<TR "+editStatus+" "+ rowBgColor + ">");
					sbufXML.append("<TD>R</TD>");
					sbufXML.append("<TD></TD>");
					for (int j=0; j < colCount ; j++) {
						dataFormat=""; 
						if(j==0){
							// week 제어(sub, grand total은 데이타 그대로 보여줌)	
							if(rowSet.getString(editPosition+1).equals("2") || !rowSet.getString(editPosition+1).equals("3")) {
								dataFormat="DATA-FORMAT=\"dfNone\" ";  
							}
						}else if(j == 1 ){
							// company combo box 제어
							if(rowSet.getString(editPosition).equals("1") || !rowSet.getString(editPosition+1).equals("1")) {
								dataFormat="DATA-TYPE=\"dtData\" ";
							}
						}else if(j == 11 || j == 12){
							// so send check box 제어
							if(rowSet.getString(editPosition).equals("2") && rowSet.getString(editPosition+1).equals("1")) {
								dataFormat="DATA-TYPE=\"dtCheckBox\" ";
							}
						}else if(j >= 17 && j <= 17 + tpszLength){
							// Item이 Off-Hire 는 vol을 입력할 수 없다. 제어
							if(rowSet.getString(4).equals("F") && rowSet.getString(editPosition+1).equals("1")) {
								dataFormat="EDIT=\"FALSE\" ";
							}	
						}
						sbufXML.append("<TD "+dataFormat +" ><![CDATA["+JSPUtil.getNull(rowSet.getString(i++))+ "]]></TD>");

					}

					i = 1;
					sbufXML.append("</TR>\n");
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
