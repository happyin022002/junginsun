
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr003ViewAdapter.java
*@FileTitle : EesEqr0003 화면 IBSheet Generation Class
*Open Issues :
*Change history :
*@LastModifyDate : 2009-07-24
*@LastModifier : chung eun ho
*@LastVersion : 1.0
* 2009-07-24 chung eun ho
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.inputdatarlaexamine.event;

import java.sql.SQLException;
import java.util.List;

import com.hanjin.apps.alps.ees.eqr.scenariomanage.inputdatarlaexamine.vo.EesEqr0003ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.inputdatarlaexamine.vo.InputDataRLAExamineRsVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.controller.ViewAdapter;

/**
 * EesEqr0003 화면 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author chung eun ho
 * @see ViewAdapter 참조
 * @since J2EE 1.6
 */
public class EesEqr0003ViewAdapter extends ViewAdapter {

	
	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 객체
	 * @param colOrder String[] Column명 문자열 
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception 
	 */	
	protected String makeDataTag(List<AbstractValueObject> OBVOS, String prefix) {
		StringBuilder sb = new StringBuilder();
		InputDataRLAExamineRsVO listVO = new InputDataRLAExamineRsVO();
		AbstractValueObject vo = (AbstractValueObject)OBVOS.get(0) ;
		ObjectCloner.build(vo, listVO);

		EesEqr0003ConditionVO condiVO = (EesEqr0003ConditionVO)listVO.getConditionVo();
		DBRowSet rowSet				  = listVO.getDBRowSet();
		
		
		
		String tpsztype  = "";
		String[] tpszArr= null;
		int tpszLength = 0;
		int editPosition = 0;  // edit 여부를 결정하는 변수
		int firstFixedFieldSize = 10; // 
		try{
			tpsztype = condiVO.getTpsztype();
			tpszArr  = tpsztype.split(",");
			tpszLength=tpszArr.length;
			editPosition = tpszLength*4 + firstFixedFieldSize;  // edit 여부를 결정하는 변수
			
			
			sb.append("<DATA  TOTAL='" + getRowSetCnt(rowSet) + "'>\n");
			
			
			String rowEidtStatus = "";
			String volEditStatus = "";
			String amtEditStatus = "";
			int i =1;
			if (rowSet != null) {
				while (rowSet.next()) { 
					 // 1 --> Input Data Type : Link Info
				    // 2 --> Input Data Type : ECC Info
					if(rowSet.getString(editPosition).equals("1") ||
					   rowSet.getString(editPosition).equals("2")
					) {                                              
						volEditStatus="EDIT=\"FALSE\" ";
						rowEidtStatus = "";
					}else { // 1,2 이외의것은 모두 수정불가(임시)
						volEditStatus="";
						rowEidtStatus="EDIT=\"FALSE\" ";				
					}		
					sb.append( "<TR "+ rowEidtStatus +"> \n");
					sb.append( "<TD>R</TD>");
					for(int f = 0 ; f < firstFixedFieldSize -1 ;f++){
						sb.append( "<TD><![CDATA["+JSPUtil.getNull(rowSet.getString(i++))+"]]></TD>");
					}
					for(int j=0; j<tpszArr.length; j++) {  // type size 별 vol, cost	
						sb.append( "<TD "+volEditStatus+"><![CDATA["+JSPUtil.getNull(rowSet.getString(i++))+"]]></TD> ");
						// Link Info(1)이고 amt=0 은 수정하지 않는다.
						// ECC Info(2)이고 amt=0이거나 item=TRS 은 수정하지 않는다.
						if((rowSet.getString(editPosition).equals("1") && rowSet.getString(i).equals("0")) ||
						   (rowSet.getString(editPosition).equals("2") && (rowSet.getString(i).equals("0") || rowSet.getString(editPosition+1).equals("TRS"))) 
						) {
							amtEditStatus="EDIT=\"FALSE\" ";
						}else {
							amtEditStatus="";
						}	
						sb.append( "<TD "+amtEditStatus+"><![CDATA["+JSPUtil.getNull(rowSet.getString(i++))+"]]></TD>\n");
					} 
					sb.append( "<TD><![CDATA["+JSPUtil.getNull(rowSet.getString(i++))+"]]></TD>\n");
					
					for(int j=0; j<tpszArr.length; j++) {  // type size 별 vol, cost flag
						sb.append( "<TD><![CDATA["+JSPUtil.getNull(rowSet.getString(i++))+"]]></TD>\n");
						sb.append( "<TD><![CDATA["+JSPUtil.getNull(rowSet.getString(i++))+"]]></TD>\n");
					}
					sb.append( "<TD><![CDATA["+JSPUtil.getNull(rowSet.getString(i++))+"]]></TD>\n");
					sb.append( "<TD><![CDATA["+JSPUtil.getNull(rowSet.getString(i++))+"]]></TD>\n");
					i = 1;
					sb.append( "</TR>\n");
				}
			}
			sb.append("</DATA>\n");
		}catch(SQLException ex){
			throw new RuntimeException(ex.getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}
		
		return sb.toString();
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
	protected String makeDataTag(DBRowSet rowSet,String prefix) {
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
