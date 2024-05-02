/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmSaq0127ViewAdapter02.java
*@FileTitle      : Monthly Quota Inquiry(RHQ)
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
import com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.vo.SearchMonthlyQuotaInquiry0126Tab02VO;
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

public class EsmSaq0127ViewAdapter02 extends ViewAdapter {
	
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
		SearchMonthlyQuotaInquiry0126Tab02VO listVo = null; // 차후 루프문을 통해 결과리스트의 정보를 한 로우씩 입력할 결과VO를 세팅 (0126공유)
		
		int totCnt = list.size(); // 측정된 데이터의 갯수
		int realCnt = list.size(); 
//		String isExpand="";

		AbstractValueObject vo = (AbstractValueObject)list.get(0); // vo 에 vos의 첫번째 로우의 데이터 하나를 가져와서 세팅
		
		if(vo.getMaxRows()>0){
			totCnt = vo.getMaxRows(); // 빼내온 vo 데이터에서 가장 큰 로우의 값을 받아와서 결국 전체 데이터의 갯수를 측정. (왜 두번 측정하는지는 모르겠음)
		}
		
		// Tree 관련 색상 지정
		String[] bgColor = SAQUtil.getColors(9);
		
		String items[] = quotaConditionVO.getItem().split(":"); // 선택된 item text array
		if (items[0].equals("ALL")) {
			items = new String[]{"ALL"};
		}

		int level = 1;
		String unit = quotaConditionVO.getUnit();
		float multiplier = 1F;
		//수치 데이터 저장(Total, 1~12월)
		float[] values = new float[4];
		String fontColor = "";
	
		
//		sbufXML.append("<DATA COLORDER='" + JSPUtil.convertStringArrayToString(changedColNms, "|") + "' COLSEPARATOR='" + DELIMITER + "' TOTAL='" + totCnt +"'>\n");
		// ViewAdapter에서는 ☜☞ 를 구분자로 사용하지만 이번에는 사용할 필요가 없기 때문에 separator 부분 제거.
		sbufXML.append("<DATA TOTAL='" + totCnt +"'>\n"); // 데이터의 총 갯수를 최상단에 출력
 
		
		for(int j=0;j<realCnt;j++){ 
			listVo = (SearchMonthlyQuotaInquiry0126Tab02VO) list.get(j); //list 에서 한 줄 씩 빼내서 결과vo에 입력
			
			// 종전의 rowSet의 경우 getString 및 getInt 함수를 사용해서 해당 값들을 뽑아왔지만
			// VO 사용의 경우 각 값마다의 게터가 있으므로 게터 함수로 수정하는 작업이 필요.
			level = Integer.parseInt(listVo.getSlevel());  
			
			fontColor = "COLOR=\"0,0,0\"";						
			if(listVo.getConvDirCd()!="") fontColor = "COLOR=\"255,0,0\"";
			
			String dir_cd = listVo.getDirCd();
			String sub_trd_cd = listVo.getSubTrdCd();
			String rlane_cd = listVo.getRlaneCd();
			String item = listVo.getItem();
			
			dir_cd = dir_cd.equals("") ? " " : dir_cd;
			sub_trd_cd = sub_trd_cd.equals("") ? " " : sub_trd_cd;
			rlane_cd = rlane_cd.equals("") ? " " : rlane_cd;

			//unit 적용
			if (unit.equals("F")) {
				if (item.equalsIgnoreCase("SUPPLY") || item.equalsIgnoreCase("VOLUME")) {
					multiplier = 0.5F;
				} else if (item.equalsIgnoreCase("G.RPB") || item.equalsIgnoreCase("CMB")
						 || item.equalsIgnoreCase("CMPB")) {
					multiplier = 2F;
				} else {
					multiplier = 1F;
				}					
			} else if (unit.equals("T")) {
				multiplier = 1F;
			}

			
//			//Total 및 월별 수치 데이터를 배열에 저장
//			for (int i=0; i<values.length; i++) {
//				String colSuffix = "";
//				if (i < 10) {
//					colSuffix = "0" + i;
//				} else {
//					colSuffix = String.valueOf(i);
//				}
//				values[i] = rowSet.getFloat("val_" + colSuffix) * multiplier;
//			}

			// 위의 for 문을 통해 val_00 ~ val_03 을 만드는데 이것은 조건VO의 get함수를 사용하는 방식으로는 만들기가 난해하며, 
			// 또한 해당 쿼리문에서 루프문을 통해 변수를 사용한 것이 아니라 가변성을 고려하지 않고 하드코딩으로 각 변수를 하나하나 지정하여 사용하기 때문에
			// 특별히 유동적으로 만들 필요성이 없기 때문에 위 로직 대신 쿼리문에서 사용하는 것과 같이 하드코딩으로 선언하여 사용. 
				values[0] = Float.parseFloat(listVo.getVal00()) * multiplier;
				values[1] = Float.parseFloat(listVo.getVal01()) * multiplier;
				values[2] = Float.parseFloat(listVo.getVal02()) * multiplier;
				values[3] = Float.parseFloat(listVo.getVal03()) * multiplier;

			
			String strVal_00 = values[0] == 0 ? "" : String.valueOf(values[0]);
			String strVal_01 = values[1] == 0 ? "" : String.valueOf(values[1]);
			String strVal_02 = values[2] == 0 ? "" : String.valueOf(values[2]);
			String strVal_03 = values[3] == 0 ? "" : String.valueOf(values[3]);
			
			
//			if( listVo.getSlevel().equals("1") ){
//				isExpand = "true";
//			}else{
//				isExpand = "false";
//			}
//			String sub_trd_image = "";
//			String dir_image = "";
//			String rlane_image = "";								
//			if( sub_trd_cd.toUpperCase().equals("TOTAL") ){
//				sub_trd_image = "IMAGE=\"0\"";				
//			}else if( dir_cd.toUpperCase().equals("TOTAL") ){
//				dir_image = "IMAGE=\"0\"";				
//			}else if( rlane_cd.toUpperCase().equals("TOTAL") ){
//				rlane_image = "IMAGE=\"0\"";											
//			} 				
			
						
			// <TD>를 사용해 기존 GS의 값을 하나씩 대입한다. 
			sbufXML.append("<TR>");
//			sbufXML.append("<TR LEVEL=\"" + listVo.getSlevel() + "\" expand= \"" + isExpand + "\">");
			sbufXML.append("<TD bgColor=\"" + bgColor[level-1] + "\"><![CDATA[" + dir_cd + "]]></TD>");
			sbufXML.append("<TD bgColor=\"" + bgColor[level-1] + "\"><![CDATA[" + sub_trd_cd + "]]></TD>");
			sbufXML.append("<TD bgColor=\"" + bgColor[level-1] + "\" " + fontColor + "><![CDATA[" + rlane_cd + "]]></TD>");
			sbufXML.append("<TD bgColor=\"" + bgColor[level-1] + "\"><![CDATA[" + item + "]]></TD>");
			sbufXML.append("<TD bgColor=\"" + bgColor[level-1] + "\"><![CDATA[" + strVal_00 + "]]></TD>");
			sbufXML.append("<TD bgColor=\"" + bgColor[level-1] + "\"><![CDATA[" + strVal_01 + "]]></TD>");
			sbufXML.append("<TD bgColor=\"" + bgColor[level-1] + "\"><![CDATA[" + strVal_02 + "]]></TD>");
			sbufXML.append("<TD bgColor=\"" + bgColor[level-1] + "\"><![CDATA[" + strVal_03 + "]]></TD>");
			sbufXML.append("<TD bgColor=\"" + bgColor[level-1] + "\"></TD>");
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