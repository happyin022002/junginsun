/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmSaq0128ViewAdapter10.java
*@FileTitle      : Regional Office
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 최초 생성
=========================================================*/

package com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.event;

import java.util.List;


import com.clt.apps.opus.esm.saq.common.SAQUtil;
import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.vo.SearchMonthlyQuotaInquiry0128Tab10VO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.controller.ViewAdapter;


/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Lee SeungYol
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */

public class EsmSaq0128ViewAdapter10 extends ViewAdapter {
	
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
		ReturnVO returnVO = (ReturnVO)vos.get(0); //넘겨받은 vos에는 데이터가 returnVO 한개 밖에 없으므로 첫번째 로우를 넘겨받는다.
		QuotaConditionVO quotaConditionVO = returnVO.getConditionVO();  // 넘겨받은 returnVO에는 조건VO와 결과값 리스트가 있으므로 게터함수를 통해 조건VO 정보를 담는다.
		List<AbstractValueObject> list = returnVO.getValueObjectVOs();  // 또한 결과값도 받기 위해 리스트형태의 결과값을 추출한다.

		// 기존 파일에서는 dbrowset으로 결과를 반환했지만 new F/W 작업으로 인해 
		// 결과값을 리턴 VO로 받아야하므로 다음을 추가.
		// 아래 AbstractValueObject에서 vo 를 사용하기 때문에 여기서는 listVo로 명명.
		// AbstractValueObject 는 모든 결과 VO의 상속을 받는 클래스.
		SearchMonthlyQuotaInquiry0128Tab10VO listVo = null; // 차후 루프문을 통해 결과리스트의 정보를 한 로우씩 입력할 결과VO를 세팅 
		
		int totCnt = list.size(); // 측정된 데이터의 갯수
		int realCnt = list.size(); 
//		String isExpand="";

		AbstractValueObject vo = (AbstractValueObject)list.get(0); // vo 에 vos의 첫번째 로우의 데이터 하나를 가져와서 세팅
		
		if(vo.getMaxRows()>0){
			totCnt = vo.getMaxRows(); // 빼내온 vo 데이터에서 가장 큰 로우의 값을 받아와서 결국 전체 데이터의 갯수를 측정. (왜 두번 측정하는지는 모르겠음)
		}
		
		// Tree 관련 색상 지정
		String[] bgColor = new String[9];
		String[] colors = SAQUtil.getColors();
		int j = 0;
		for (int i=0; i<9; i++) {
			bgColor[i] = colors[j++];
			if (j == 3) {
				j = 0;
			}
		}
		
				
		String unit = quotaConditionVO.getUnit();
		float multiplier = 1F;
		
		int colorIdx = 0;
	    int tree_lvl = 0;
		
//		sbufXML.append("<DATA COLORDER='" + JSPUtil.convertStringArrayToString(changedColNms, "|") + "' COLSEPARATOR='" + DELIMITER + "' TOTAL='" + totCnt +"'>\n");
		// ViewAdapter에서는 ☜☞ 를 구분자로 사용하지만 이번에는 사용할 필요가 없기 때문에 separator 부분 제거.
		sbufXML.append("<DATA TOTAL='" + totCnt +"'>\n"); // 데이터의 총 갯수를 최상단에 출력
 
		
		for(int k=0;k<realCnt;k++){ 
						
			listVo = (SearchMonthlyQuotaInquiry0128Tab10VO) list.get(k); //list 에서 한 줄 씩 빼내서 결과vo에 입력
		
			// 종전의 rowSet의 경우 getString 및 getInt 함수를 사용해서 해당 값들을 뽑아왔지만
			// VO 사용의 경우 각 값마다의 게터가 있으므로 게터 함수로 수정하는 작업이 필요.
			
			String saq_tgt_grp_cd = listVo.getSaqTgtGrpCd();
			String trd_cd = listVo.getTrdCd();
			String dir_cd = listVo.getDirCd();
			String item_nm = listVo.getText();
			double cal_val_01 = Double.parseDouble(listVo.getCalVal01());
			double cal_val_02 = Double.parseDouble(listVo.getCalVal02());
			double cal_val_03 = Double.parseDouble(listVo.getCalVal03());
			double cal_tot = Double.parseDouble(listVo.getCalTot());

			 
			//unit 적용
			if (unit.equals("F")) {
				if (item_nm.equalsIgnoreCase("SUPPLY") || item_nm.equalsIgnoreCase("VOLUME")) {
					multiplier = 0.5F;
				} else if (item_nm.equalsIgnoreCase("G.RPB") || item_nm.equalsIgnoreCase("CMPB") ) {
					multiplier = 2F;
				} else {
					multiplier = 1F;
				}					
			} else if (unit.equals("T")) {
				multiplier = 1F;
			}


			if( "1".equals(listVo.getGrpSaqTgtGrpCd())){
				colorIdx = 0;
				tree_lvl = 0;
				saq_tgt_grp_cd = "TOTAL";
				trd_cd = " ";
				dir_cd = " ";			
//				isExpand = "true";					
			}else if( "1".equals(listVo.getGrpTrdCd())){
				colorIdx = 1;
				tree_lvl= 1;
				trd_cd = "TOTAL";
				dir_cd = " ";	
//				isExpand = "false";					
				if( "98".equals(listVo.getCode()) || "99".equals(listVo.getCode())){
					continue;
				}					
			}else{
				colorIdx = 2;
				tree_lvl = 2;
//				isExpand = "false";					
				if( "98".equals(listVo.getCode()) || "99".equals(listVo.getCode())){
					continue;
				}
			}
//			if (item_nm.equalsIgnoreCase("G.REV") 
//					|| item_nm.equalsIgnoreCase("CM")
//					) {
//				item_nm = item_nm + "*";
//			}
//			String saq_tgt_grp_image = "";	
//			String trd_image = "";	
//			if( saq_tgt_grp_cd.toUpperCase().equals("TOTAL") ){
//				saq_tgt_grp_image = "IMAGE=\"0\"";				
//			}else if( trd_cd.toUpperCase().equals("TOTAL") ){
//				trd_image = "IMAGE=\"0\"";										
//			} 		
//			
						
			// <TD>를 사용해 기존 GS의 값을 하나씩 대입한다. 
			
//			sbufXML.append("<TR LEVEL=\"" + tree_lvl + "\" expand=\"" + isExpand + "\">");
			sbufXML.append("<TR>");
			sbufXML.append("<TD bgColor=\"" + bgColor[colorIdx] + "\"><![CDATA[" + saq_tgt_grp_cd + "]]></TD>");
			sbufXML.append("<TD bgColor=\"" + bgColor[colorIdx] + "\"><![CDATA[" + trd_cd + "]]></TD>");
			sbufXML.append("<TD bgColor=\"" + bgColor[colorIdx] + "\"><![CDATA[" + dir_cd + "]]></TD>");
			sbufXML.append("<TD bgColor=\"" + bgColor[colorIdx] + "\"><![CDATA[" + item_nm + "]]></TD>");
			sbufXML.append("<TD bgColor=\"" + bgColor[colorIdx] + "\"><![CDATA[" + cal_tot * multiplier + "]]></TD>");
			sbufXML.append("<TD bgColor=\"" + bgColor[colorIdx] + "\"><![CDATA[" + cal_val_01 * multiplier + "]]></TD>");
			sbufXML.append("<TD bgColor=\"" + bgColor[colorIdx] + "\"><![CDATA[" + cal_val_02 * multiplier + "]]></TD>");
			sbufXML.append("<TD bgColor=\"" + bgColor[colorIdx] + "\"><![CDATA[" + cal_val_03 * multiplier + "]]></TD>");
			sbufXML.append("<TD>" + tree_lvl + "</TD>");
			sbufXML.append("</TR>\n");
		}
		sbufXML.append("</DATA>\n");
				
		return sbufXML.toString(); //스트링 버퍼로 받은 값들을 스트링으로 변환하여 반환한다.
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
		// ViewAdapter에는 위의 List로 받는 부분과 이 쪽의 DBRowSet으로 받는 두 부분은 무조건 구현이 되어있어야한다.
		// 하지만 DBRowSet을 사용하지 않기 때문에 이부분은 골격만 만들어 놓는다.
		return null;	}
}