
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
 * EesEqr0080 화면 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author ChungEunHo
 * @see ViewAdapter 참조
 * @since J2EE 1.6
 */
public class EesEqr0069ViewAdapter extends ViewAdapter {

	
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
		
		//editPosition = tpszLength*1 + 18 + 4;  // edit 여부를 결정하는 변수(SORTNUM 위치)

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
					dataFormat="DATA-TYPE=\"\" ";
					mtyEditStatus="EDIT=\"TRUE\" ";		
					rowBgColor = "";
					
					sbufXML.append("<TR "+editStatus+" "+ rowBgColor+" >\n");
					sbufXML.append("<TD "+ mtyEditStatus +">R</TD>");
					sbufXML.append("<TD></TD>");
					
					for (int j=0; j < colCount ; j++) {
						mtyEditStatus="EDIT=\"\" ";	
						if(j == 2) {
							mtyEditStatus="EDIT=\"FALSE\" ";		
						}
						sbufXML.append("<TD "+dataFormat +" "+ mtyEditStatus +"><![CDATA["+JSPUtil.getNull(rowSet.getString(i++))+ "]]></TD>");
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
