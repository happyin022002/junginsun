/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0052ViewAdapter.java
*@FileTitle : 최적화된 REPO InOut 계획 수량 조회/수정
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	Lee Byoung Hun	2009.08.27		1.0 최초 생성
*
*@LastModifyDate : 2009.08.27
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.08.27
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.event;

import java.sql.SQLException;
import java.util.List;

import com.clt.apps.opus.ees.eqr.common.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0052ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.SearchCntrRepoInOutPlanLaneVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.SearchCntrRepoInOutPlanVVDVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Lee SeungYol
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EesEqr0052ViewAdapter extends ViewAdapter {

	
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
		String returnStr = "";
		EesEqr0052ConditionVO conditionVO = (EesEqr0052ConditionVO) vos.get(0);
		
		// 조회결과 생성
		if ("1".equals(conditionVO.getSearchFlag())) {
			returnStr = makeSheetDataTag(vos, prefix);
			
		// VVD Combo 생성
		} else if ("2".equals(conditionVO.getSearchFlag())) {
			returnStr = makeVvdCombo(vos, prefix);
			
		// From LOC Combo 생성
		} else if ("3".equals(conditionVO.getSearchFlag())) {
			returnStr = makeFromLocCombo(vos, prefix);
		
		// To LOC Combo 생성
		} else if ("4".equals(conditionVO.getSearchFlag())) {
			returnStr = makeToLocCombo(vos, prefix);
		}
		
		return returnStr;
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
		return null;
	}
	
	/**
	 * 조회결과 생성
	 * 
	 * @param vos
	 * @param prefix
	 * @return
	 */
	protected String makeSheetDataTag(List<AbstractValueObject> vos, String prefix) {
		CommonRsVO commonRsVO = (CommonRsVO) vos.get(1);
		EesEqr0052ConditionVO conditionVO = (EesEqr0052ConditionVO) vos.get(0);
		DBRowSet rs = commonRsVO.getDbRowset();
		
		String statusType = conditionVO.getStatusType();
		
		StringBuilder sb = new StringBuilder();

		String[] realColNms = getColHeader(rs);

		try{
			String[] changedColNms = getChangedColNms(realColNms, prefix);
			String colNms = "del|ibflag|" + JSPUtil.convertStringArrayToString(changedColNms, "|") ;
			
			sb.append("<DATA COLORDER='" + colNms + "' TOTAL='" + getRowSetCnt(rs) + "'>\n");
			
			int colCount = realColNms.length;
			
			while (rs.next()) { 
				sb.append("	<TR EDIT=\"" + statusType + "\">");
				
				if ("Y".equals(rs.getString("PAST_REPO_PLN_FLG"))) {
					sb.append("<TD EDIT=\"FALSE\"></TD>");
				} else {
					sb.append("<TD></TD>");
				}
				
				sb.append("<TD>R</TD>");
				
				for (int j = 1 ; j < colCount ; j++) {
					if ("Y".equals(rs.getString("PAST_REPO_PLN_FLG"))) {
						sb.append("<TD BGCOLOR=\"181,232,224\" EDIT=\"FALSE\">" + getNull(rs.getObject(j)) + "</TD>");
					} else {
						sb.append("<TD>" + getNull(rs.getObject(j)) + "</TD>");
					}
				}
				sb.append("<TD>" + getNull(rs.getObject(colCount)) + "</TD></TR>\n");
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
	 * VVD Combo 생성
	 * 
	 * @param vos
	 * @param prefix
	 * @return
	 */
	protected String makeVvdCombo(List<AbstractValueObject> vos, String prefix) {
		StringBuilder sbufXML = new StringBuilder();
		SearchCntrRepoInOutPlanLaneVO vo = null;
		EesEqr0052ConditionVO conditionVO = (EesEqr0052ConditionVO) vos.get(0);
		int totCnt = vos.size() - 1;
		StringBuffer vvd = new StringBuffer(512);
		String row = conditionVO.getRow();
		
		if (totCnt != 0) {
			for(int i=1;i<totCnt + 1;i++){
				vo = (SearchCntrRepoInOutPlanLaneVO) vos.get(i);
				vvd.append(vo.getVvd()+"|");
			}
		} else {
			vvd.append("| |");
		}
		
		sbufXML.append("<DATA>\n");
		sbufXML.append("<TR ROW= \"" + row + "\" >\n");
		sbufXML.append("<TD COL=\"vvd\" DATA-TYPE=\"dtCombo\" COMBO-TEXT=\"" + vvd + "\" COMBO-CODE=\"" + vvd + "\"></TD>\n");
		sbufXML.append("<TD COL=\"laneCnt\" DATA-TYPE=\"dtData\">" + totCnt + "</TD>\n");
		sbufXML.append("</TR>\n");
		sbufXML.append("</DATA>\n");
		
		return sbufXML.toString();
	}
	
	/**
	 * From LOC Combo 생성
	 * 
	 * @param vos
	 * @param prefix
	 * @return
	 */
	protected String makeFromLocCombo(List<AbstractValueObject> vos, String prefix) {
		StringBuilder sbufXML = new StringBuilder();
		SearchCntrRepoInOutPlanVVDVO vo = null;
		EesEqr0052ConditionVO conditionVO = (EesEqr0052ConditionVO) vos.get(0);
		int totCnt = vos.size() - 1;
		String row = conditionVO.getRow();
		StringBuffer loc = new StringBuffer();
		
		loc.append("| |");
		
		if (totCnt != 0) {
			for(int i=1;i<totCnt + 1;i++){
				vo = (SearchCntrRepoInOutPlanVVDVO) vos.get(i);
				loc.append(((i == 1) ? "" : "|") + vo.getVslLocCd().replaceAll("&","&amp;")+"\t" + vo.getVslEtdDt().trim());
			}
		}
		
		sbufXML.append("<DATA>\n");
		sbufXML.append("<TR ROW= \"" + row + "\" >\n");
		sbufXML.append("<TD COL=\"fm_ecc_cd_tmp\" DATA-TYPE=\"dtCombo\" COMBO-TEXT=\"" + loc.toString() + "\" COMBO-CODE=\"" + loc.toString() + "\"></TD>\n");
		sbufXML.append("<TD COL=\"vvdCnt\" DATA-TYPE=\"dtData\">" + totCnt + "</TD>\n");
		sbufXML.append("</TR>\n");
		sbufXML.append("</DATA>\n");
		
		return sbufXML.toString();
	}
	
	/**
	 * To LOC Combo 생성
	 * 
	 * @param vos
	 * @param prefix
	 * @return
	 */
	protected String makeToLocCombo(List<AbstractValueObject> vos, String prefix) {
		StringBuilder sbufXML = new StringBuilder();
		SearchCntrRepoInOutPlanVVDVO vo = null;
		EesEqr0052ConditionVO conditionVO = (EesEqr0052ConditionVO) vos.get(0);
		int totCnt = vos.size() - 1;
		String row = conditionVO.getRow();
		StringBuffer loc = new StringBuffer();
		
		loc.append("| |");
		
		if (totCnt != 0) {
			for(int i=1;i<totCnt + 1;i++){
				vo = (SearchCntrRepoInOutPlanVVDVO) vos.get(i);
				loc.append(((i == 1) ? "" : "|") + vo.getVslLocCd().replaceAll("&","&amp;")+"\t" + vo.getVslEtbDt().trim());
			}
		}
		
		sbufXML.append("<DATA>\n");
		sbufXML.append("<TR ROW= \"" + row + "\" >\n");
		sbufXML.append("<TD COL=\"to_ecc_cd_tmp\" DATA-TYPE=\"dtCombo\" COMBO-TEXT=\"" + loc.toString() + "\" COMBO-CODE=\"" + loc.toString() + "\"></TD>\n");
		sbufXML.append("<TD COL=\"vvdCnt\" DATA-TYPE=\"dtData\">" + totCnt + "</TD>\n");
		sbufXML.append("</TR>\n");
		sbufXML.append("</DATA>\n");
		
		return sbufXML.toString();
	}

}
