/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EesMnr0109ViewAdapter
*@FileTitle : 데이터의 상태에 따라  BackColor 와 Edit 를 설정한다.
*Open Issues :
*Change history :
*@LastModifyDate : 2011. 1. 26.
*@LastModifier :
*@LastVersion : 1.0
*2011. 1. 26. 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.event;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;

/**
 * IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 *
 * @author 박명신
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EesMnr0109ViewAdapter extends ViewAdapter {
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

		sbufXML.append("<DATA>\n");

		int realCnt = vos.size();
		for(int i=0;i<realCnt;i++){
			Map<String, String> colValues = vos.get(i).getColumnValues();

			String mnrHngrFlg 		= colValues.get("mnr_hngr_flg");
			String mnrHngrRckCd 	= colValues.get("mnr_hngr_rck_cd");
			String mnrHngrTrfCd 	= colValues.get("mnr_hngr_trf_cd");
			String hngrBarAtchKnt   = colValues.get("hngr_bar_atch_knt");

			sbufXML.append("<TR>");
			if(mnrHngrFlg.equals("Y")) {
				sbufXML.append("<TD><![CDATA[]]></TD>");
				sbufXML.append("<TD><![CDATA["+ i +"]]></TD>");
				sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("eq_no")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("eq_tpsz_cd")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("mvmt_cd")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("mnr_hngr_flg_yd_cd")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"TRUE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("mnr_hngr_flg")));sbufXML.append("]]></TD>");
				if(mnrHngrRckCd.equals("O")){
					sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("mnr_hngr_rck_cd")));sbufXML.append("]]></TD>");
				} else {
					sbufXML.append("<TD EDIT=\"TRUE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("mnr_hngr_rck_cd")));sbufXML.append("]]></TD>");
				}
				sbufXML.append("<TD EDIT=\"TRUE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("mnr_hngr_trf_cd")));sbufXML.append("]]></TD>");
				if(mnrHngrTrfCd.equals("OT")){
					sbufXML.append("<TD EDIT=\"TRUE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("mnr_hngr_trf_otr_desc")));sbufXML.append("]]></TD>");
				} else {
					sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("mnr_hngr_trf_otr_desc")));sbufXML.append("]]></TD>");
				}
				if(mnrHngrRckCd.equals("O")){
					sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("mnr_hngr_bar_tp_cd")));sbufXML.append("]]></TD>");
				} else {
					sbufXML.append("<TD EDIT=\"TRUE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("mnr_hngr_bar_tp_cd")));sbufXML.append("]]></TD>");
				}
				sbufXML.append("<TD EDIT=\"TRUE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("hngr_bar_atch_knt")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("act_invt_qty")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("mnr_hngr_dmg_qty")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("mnr_lost_hngr_qty")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("mnr_disp_hngr_qty")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"TRUE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("mnr_sts_rmk")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("wo_no")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("cre_ofc_cd")));sbufXML.append("]]></TD>");
			} else {
				sbufXML.append("<TD><![CDATA[]]></TD>");
				sbufXML.append("<TD><![CDATA["+ i +"]]></TD>");
				sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("eq_no")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("eq_tpsz_cd")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("mvmt_cd")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("mnr_hngr_flg_yd_cd")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"TRUE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("mnr_hngr_flg")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("mnr_hngr_rck_cd")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("mnr_hngr_trf_cd")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("mnr_hngr_trf_otr_desc")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("mnr_hngr_bar_tp_cd")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("hngr_bar_atch_knt")));sbufXML.append("]]></TD>");
				if(!hngrBarAtchKnt.equals("0")){
					sbufXML.append("<TD EDIT=\"TRUE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("act_invt_qty")));sbufXML.append("]]></TD>");
					sbufXML.append("<TD EDIT=\"TRUE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("mnr_hngr_dmg_qty")));sbufXML.append("]]></TD>");
					sbufXML.append("<TD EDIT=\"TRUE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("mnr_lost_hngr_qty")));sbufXML.append("]]></TD>");
					sbufXML.append("<TD EDIT=\"TRUE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("mnr_disp_hngr_qty")));sbufXML.append("]]></TD>");
					sbufXML.append("<TD EDIT=\"TRUE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("mnr_sts_rmk")));sbufXML.append("]]></TD>");
				} else {
					sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("act_invt_qty")));sbufXML.append("]]></TD>");
					sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("mnr_hngr_dmg_qty")));sbufXML.append("]]></TD>");
					sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("mnr_lost_hngr_qty")));sbufXML.append("]]></TD>");
					sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("mnr_disp_hngr_qty")));sbufXML.append("]]></TD>");
					sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("mnr_sts_rmk")));sbufXML.append("]]></TD>");
				}

				sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("wo_no")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("cre_ofc_cd")));sbufXML.append("]]></TD>");
			}

			//Hidden
			sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("eq_knd_cd")));sbufXML.append("]]></TD>");
			sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("mnr_ord_ofc_cty_cd")));sbufXML.append("]]></TD>");
			sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("mnr_ord_seq")));sbufXML.append("]]></TD>");
			sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("ofc_cd")));sbufXML.append("]]></TD>");
			sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("mnr_sts_flg")));sbufXML.append("]]></TD>");
			sbufXML.append("<TD><![CDATA[]]></TD>");
			sbufXML.append("</TR>\n");
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

		//Pivot Table인 경우 makePivotDataTag 실행하여  return한
		if(rs.isPivot()){
			sb.append(makePivotDataTag(rs));
			return sb.toString();
		}

		String[] realColNms = getColHeader(rs);

		try{
			String[] changedColNms = getChangedColNms(realColNms, prefix);

			sb.append("<DATA COLORDER='" + JSPUtil.convertStringArrayToString(changedColNms, "|") + "' COLSEPARATOR='" + DELIMITER + "' TOTAL='" + getRowSetCnt(rs) + "'>\n");

			int colCount = realColNms.length;

			while (rs.next()) {
				sb.append("	<TR><![CDATA[");
				for (int j = 1 ; j < colCount ; j++) {
					sb.append(JSPUtil.getNull(rs.getObject(j)) + DELIMITER);
				}
				sb.append(JSPUtil.getNull(rs.getObject(colCount))  + "]]></TR>\n");
			}
			sb.append("</DATA>\n");
		}catch(SQLException ex){
			throw new RuntimeException(ex.getMessage());
		}catch(Exception e){
			throw new RuntimeException(e.getMessage());
		}
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
		int colCnt = 0;
		int rowCnt = rs.getRowCount();

		String[][] arrRowSet = null;

		try{
			colCnt = rs.getMetaData().getColumnCount();
			arrRowSet = new String[rowCnt][colCnt];

			int rowIdx = 0;
			while (rs.next()) {
				for (int j = 1 ; j <= colCnt ; j++) {
					arrRowSet[rowIdx][j-1] = JSPUtil.getNull(rs.getObject(j)).toString();
				}
				rowIdx++;
			}
		}catch(SQLException ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}catch(Exception e){
			throw new RuntimeException(e.getMessage());
		}

		try{
			sb.append("<DATA COLSEPARATOR='" + DELIMITER + "'>\n");
			if(rowCnt>0){
				for (int coIdx = 0 ;coIdx < colCnt ; coIdx++) {
					sb.append(" <TR><![CDATA[");
					for(int roIdx=0;roIdx < rowCnt-1; roIdx++){
						sb.append(arrRowSet[roIdx][coIdx] + DELIMITER);
					}
					sb.append(arrRowSet[rowCnt-1][coIdx]  + "]]></TR>\n");
				}//end for coIdx
			}//end for roIdx
			sb.append("</DATA>\n");
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}
		return sb.toString();
	}

}
