/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0053ViewAdapter.java
*@FileTitle : 컨테이너 수급 예측실적 및 정확도 조회
*Open Issues :
*Change history :
* No.	Ver.		Modifier           					modifier date    explanation
* 1		1.0		Lee Byoung Hun				2009.09.07		1.0 최초 생성
*
*@LastModifyDate : 2009.09.07
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.09.07
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.event;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.ees.eqr.common.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0053ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.SearchCntrOnHireApprovalVO;
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
public class EesEqr0053ViewAdapter extends ViewAdapter {

	
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
		EesEqr0053ConditionVO conditionVO = (EesEqr0053ConditionVO) vos.get(0);
		
		// Sheet1 생성
		if ("1".equals(conditionVO.getSheetFlg())) {
			returnStr = makeSheet1(vos, prefix);
			
		// Sheet2 생성
		} else {
			returnStr = makeSheet2(vos, prefix);
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
	 * Sheet1 생성
	 * 
	 * @param vos
	 * @param prefix
	 * @return
	 */
	protected String makeSheet1(List<AbstractValueObject> vos, String prefix) {
		EesEqr0053ConditionVO conditionVO = (EesEqr0053ConditionVO) vos.get(0);
		DBRowSet rs = ((CommonRsVO) vos.get(1)).getDbRowset();
		
		StringBuilder sb = new StringBuilder();

		String[] realColNms = getColHeader(rs);

		try{
			String[] changedColNms = getChangedColNms(realColNms, prefix);
			
			sb.append("<DATA COLORDER='" + JSPUtil.convertStringArrayToString(changedColNms, "|") + "' COLSEPARATOR='" + DELIMITER + "' TOTAL='" + getRowSetCnt(rs) + "'>\n");
			
			int colCount = realColNms.length;
			
			while (rs.next()) { 
				sb.append("	<TR EDIT=\"" + conditionVO.getStatusType() + "\"><![CDATA[");
				for (int j = 1 ; j < colCount ; j++) {
					sb.append(getNull(rs.getObject(j)) + DELIMITER);
				}	
				sb.append(getNull(rs.getObject(colCount))  + "]]></TR>\n");
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
	 * Sheet2 생성
	 * 
	 * @param vos
	 * @param prefix
	 * @return
	 */
	protected String makeSheet2(List<AbstractValueObject> vos, String prefix) {
		EesEqr0053ConditionVO conditionVO = (EesEqr0053ConditionVO) vos.get(0);
		SearchCntrOnHireApprovalVO searchVO = null;
		String week = conditionVO.getWeek();
		String locCd = conditionVO.getLocCd();
		
		// 사용자가 선택한 TP/SZ 목록
		String tpsz = conditionVO.getCntrtpszcd3();
		String[] tpszArr = tpsz.split(",");
		
		// for loop에 사용될 변수 선언 
		String usrs11_1 = "";
	 	String usrs12_1 = "";
	 	 
	 	int    result   =  0;
		
		String	chk_auth_no = "";
		String	chk_ctrt_seq = "";
		String	chk_ctrt_ofc_city = "";
		
		StringBuilder sbufXML = new StringBuilder();
		
		// Sheet2 데이터 세팅
		ArrayList<HashMap<String, String>> vcRow = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> hmap = null;
		for (int i = 1; i < vos.size(); i++){
			searchVO = (SearchCntrOnHireApprovalVO) vos.get(i);
	
			hmap = new HashMap<String, String>();
	
			if( searchVO.getAuthNo().equals(chk_auth_no) && searchVO.getCtrtSeq().equals(chk_ctrt_seq) && searchVO.getCtrtOfcCity().equals(chk_ctrt_ofc_city) ) {

				if(i != 0) {
					hmap = (HashMap<String, String>)vcRow.get(vcRow.size() - 1);
			
					for(int j=0; j<tpszArr.length; j++) {
						if(searchVO.getCntrTpszCd().equals(tpszArr[j])) {
							usrs11_1 =  searchVO.getAppQty();
							usrs12_1 =  searchVO.getPicQty();
							result   = Integer.parseInt(usrs11_1) - Integer.parseInt(usrs12_1);
							hmap.put ("onhr_qty" + tpszArr[j], Integer.toString(result));
						}
					}
				}
			} else {
				hmap = new HashMap<String, String>();
				hmap.put("auth_no"        ,  searchVO.getAuthNo());
				hmap.put("ctrt_ofc_city"  ,  searchVO.getCtrtOfcCity());
				hmap.put("ctrt_seq"       ,  searchVO.getCtrtSeq());

				for(int j=0; j<tpszArr.length; j++) {

					if(searchVO.getCntrTpszCd().equals(tpszArr[j])) {
						usrs11_1 =  searchVO.getAppQty();
						usrs12_1 =  searchVO.getPicQty();
						result   = Integer.parseInt(usrs11_1) - Integer.parseInt(usrs12_1);
						hmap.put ("onhr_qty" + tpszArr[j], Integer.toString(result));				
					} else {
						hmap.put("onhr_qty" + tpszArr[j], "0");
			
					}
				}
		
				vcRow.add(hmap);
			}

			chk_auth_no = searchVO.getAuthNo();
			chk_ctrt_seq =  searchVO.getCtrtSeq();
			chk_ctrt_ofc_city = searchVO.getCtrtOfcCity();
		}
		
		// Sheet2 구성 시작
		sbufXML.append("<DATA TOTAL='" + vcRow.size() +"'>\n");
		for (int i = 0; i < vcRow.size(); i++) {
			HashMap<String, String> hmap2 = (HashMap<String, String>)vcRow.get(i);
			
			sbufXML.append("	<TR>\n");
			sbufXML.append("		<TD>R</TD>\n");
			sbufXML.append("		<TD></TD>\n");
			sbufXML.append("		<TD COL=\"pln_yrwk\">" + week + "</TD>\n");
			sbufXML.append("		<TD COL=\"ecc_cd\" DATA-TYPE=\"dtData\">" + locCd + "</TD>\n");
			sbufXML.append("		<TD COL=\"auth\" DATA-TYPE=\"dtData\">" + (String)hmap2.get("auth_no") + "</TD>\n");
			sbufXML.append("		<TD COL=\"agreeNo\" DATA-TYPE=\"dtData\">" + (String)hmap2.get("ctrt_ofc_city") + (String)hmap2.get("ctrt_seq") + "</TD>\n");
			sbufXML.append("		<TD></TD>\n");
			
			for(int j=0; j<tpszArr.length; j++) {
				sbufXML.append("		<TD DATA-TYPE=\"dtData\">" + (String)hmap2.get("onhr_qty" + tpszArr[j]) + "</TD>\n");
			}
			sbufXML.append("	</TR>\n");
		}
		sbufXML.append("</DATA>\n");
		
		return sbufXML.toString();
	}

}
