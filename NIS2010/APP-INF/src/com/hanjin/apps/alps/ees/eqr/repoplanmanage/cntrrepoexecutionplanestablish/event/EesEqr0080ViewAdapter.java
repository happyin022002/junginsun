
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0080ViewAdapter.java
*@FileTitle : EesEqr0080 화면 조회 시 데이터 가져오기  IBSheet Generation Class
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
 * EesEqr0080 화면 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author ChungEunHo
 * @see ViewAdapter 참조
 * @since J2EE 1.6
 */
public class EesEqr0080ViewAdapter extends ViewAdapter {

	
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
		String user_level 			= "";
		//String user_modify_div 		= "";
		String user_modify_location = "";
		String tpsztype  = "";
		String[] tpszArr= null;
		int tpszLength = 0;
		int editPosition = 0;  // edit 여부를 결정하는 변수(t2_sortnum의 위치임, 매우중요)
		int rowCount	 = 0;
		int colCount	 = 0;
		
		StringBuilder sbufXML = new StringBuilder();
		
		tpsztype = conditionVO.getTpsztype();
		tpszArr  = tpsztype.split(",");
		tpszLength=tpszArr.length;
		
		editPosition = tpszLength*2 + 19 + 4;  // edit 여부를 결정하는 변수(SORTNUM 위치)

		user_level 			 = conditionVO.getUserLevel();
		//user_modify_div 	 = conditionVO.getUserModifyDiv();
		user_modify_location = conditionVO.getUserModifyLocation();	
		if(rowSet != null){	
			rowCount = rowSet.getRowCount();			
		}
		
		sbufXML.append("<DATA TOTAL='"+rowCount+"'>\n");
		
		
		
		String editStatus = "";
		String dataFormat = "";	
		String mtyEditStatus="";		
		String rowBgColor = "";
		
        // plan 의 종류를 구분한다.
        // EQR_VSL_LODG_DCHG_PLN 테이블의 PAST_REPO_PLN_FLG컬럼이 'Y' 이면 Plan (Fixed)
        //                                                      'N' 이면 Plan 
		String planDiv = ""; 
        
		int i =1;
		try {
			if (rowSet != null) {
				colCount = rowSet.getMetaData().getColumnCount();
			// INLAND 는 FROM, TO중 하나만 맞으면 작업을 허용합니다.
				while (rowSet.next()) {

					editStatus = "";
					dataFormat = "";	
					mtyEditStatus="";		
					rowBgColor = "";
					boolean level_Check = false;
					
					if(
							user_level.equals("1")                                                                      ||	   
						   ( user_level.equals("2") && (user_modify_location.equals(rowSet.getString(editPosition + 3)) || user_modify_location.equals(rowSet.getString(editPosition + 4))) ) || 
						   ( user_level.equals("5") && (user_modify_location.equals(rowSet.getString(editPosition + 5)) || user_modify_location.equals(rowSet.getString(editPosition + 6))) )
					  ){
						level_Check = true;
					}
					
					if(rowSet.getString(editPosition).equals("2")                                  &&      // SORTNUM, EXECUTE라인
					   rowSet.getString(editPosition + 1).equals("1")                              &&     // NUM      NORMAL 라인
					   (!rowSet.getString(13).equals("Y") || !rowSet.getString(14).equals("Y"))    &&  // SO ISS FLAG 'Y'가 아닌 경우
				       (
//						   user_level.equals("1")                                                                      ||	   
//						   ( user_level.equals("2") && (user_modify_location.equals(rowSet.getString(editPosition + 3)) || user_modify_location.equals(rowSet.getString(editPosition + 4))) ) || 
//						   ( user_level.equals("5") && (user_modify_location.equals(rowSet.getString(editPosition + 5)) || user_modify_location.equals(rowSet.getString(editPosition + 6))) )
				    	   level_Check
						)					       
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

					}else if(rowSet.getString(editPosition).equals("1")   &&
					         rowSet.getString(editPosition+1).equals("1") &&
					         rowSet.getString(editPosition+2).equals("Y")
					) {    														// (과거에서 내려온)REPO PLAN 라인					   
						rowBgColor="BGCOLOR=\"181,232,224\" ";

					}else if(rowSet.getString(editPosition).equals("1") ) {    // PLAN 라인					   
						rowBgColor="BGCOLOR=\"203,239,234\" ";
						
					}else {
						rowBgColor=""; 
					}	
					
					// SO SEND = 'Y' || BKG = 'Y' 인 경우 삭제불가로 잠근다.
					if(rowSet.getString(13).equals("Y") || rowSet.getString(14).equals("Y")) { // SO SEND='Y'
						dataFormat="";
						mtyEditStatus="EDIT=\"FALSE\" ";	
					}	
					
					sbufXML.append("<TR "+editStatus+" "+ rowBgColor+" >\n");
					sbufXML.append("<TD "+ mtyEditStatus +">R</TD>");
					sbufXML.append("<TD></TD>");
					
					for (int j=0; j < colCount ; j++) {
					
						if(j==0) { // week 제어(sub, grand total은 데이타 그대로 보여줌)							
							if(rowSet.getString(editPosition+1).equals("2") || !rowSet.getString(editPosition+1).equals("3")) {
								dataFormat="DATA-FORMAT=\"dfNone\" ";  
							}else {   
								dataFormat=""; 
							}
						/*
						}else if(j==1) { // company combo box 제어							
							if(rowSet.getString(editPosition).equals("1") || !rowSet.getString(editPosition+1).equals("1")) {
								dataFormat="DATA-TYPE=\"dtData\" ";
							}else {   
								dataFormat=""; 
							}
						*/
						}else if(j==2) {  // Div 에서 plan 명 조정

							if(rowSet.getString(editPosition).equals("1")   &&
							   rowSet.getString(editPosition+1).equals("1") &&
							   rowSet.getString(editPosition+2).equals("Y")
							) {    		// confirm plan	
								planDiv = "  (Fixed)"; 
							}else {
								planDiv = "";
							}						
						}else if(j==12) {  //so send check box 제어
							if(rowSet.getString(editPosition).equals("2") && rowSet.getString(editPosition+1).equals("1")) {
								dataFormat="DATA-TYPE=\"dtCheckBox\" ";
								
								// WATER & SO SEND=Y 이면 SO CHECK BOX 수정 불가
								if(rowSet.getString(13).equals("Y")) mtyEditStatus="EDIT=\"FALSE\" ";
								else  								 mtyEditStatus="";								
							}else {
								dataFormat="";
								mtyEditStatus="EDIT=\"FALSE\" "; 
							}
						}else if(j==13) {  // mty check box 제어 (Water일때만 checkBox로 표현)
							if(rowSet.getString(editPosition).equals("2") && rowSet.getString(editPosition+1).equals("1")) {								
								if(rowSet.getString(4).equals("W")) {
									dataFormat="DATA-TYPE=\"dtCheckBox\" ";

									// WATER & MTY BKG=Y 이면 MTY CHECK BOX 수정 불가
									if(rowSet.getString(14).equals("Y")) mtyEditStatus="EDIT=\"FALSE\" ";
									else  								 mtyEditStatus="";
								}else{
									dataFormat="";
									mtyEditStatus="EDIT=\"FALSE\" "; 
								}                                 
							}else {
								dataFormat="";	
								mtyEditStatus="";							
							}	
						}else if(j>16) {  // WATER, EXECUTE, NORMAL 라인의 SO, MTY가 둘다 체크되지 않은 경우 VOL 수정가능
							if(rowSet.getString(4).equals("W")                                          &&  // Item = 'Water'
							   rowSet.getString(editPosition).equals("2")                               &&  // SORTNUM, EXECUTE라인
					   		   rowSet.getString(editPosition + 1).equals("1")                           &&  // NUM      NORMAL 라인
					          (!rowSet.getString(13).equals("Y") && !rowSet.getString(14).equals("Y"))  &&  // SO ISS FLAG 'Y'가 아닌 경우
					          (
//								 user_level.equals("1")                                                                      ||	   
//								 ( user_level.equals("2") && (user_modify_location.equals(rowSet.getString(editPosition + 3)) || user_modify_location.equals(rowSet.getString(editPosition + 4))) ) || 
//								 ( user_level.equals("5") && (user_modify_location.equals(rowSet.getString(editPosition + 5)) || user_modify_location.equals(rowSet.getString(editPosition + 6))) )
					             level_Check
							  )							          
							) {
								dataFormat="";
								mtyEditStatus=""; 								
							}						
						}else { // SO SEND = 'Y'이거나 MTY BKG='Y' 경우 모두 수정불가로 잠근다.
							planDiv = "";
							if(rowSet.getString(13).equals("Y") || rowSet.getString(14).equals("Y")) { // SO SEND='Y'
								dataFormat="";
								mtyEditStatus="EDIT=\"FALSE\" "; 
							}else {
								dataFormat="";
								mtyEditStatus=""; 
							}
						}		  							

						sbufXML.append("<TD "+dataFormat +" "+ mtyEditStatus +"><![CDATA["+JSPUtil.getNull(rowSet.getString(i++))+ planDiv +"]]></TD>\n");

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
