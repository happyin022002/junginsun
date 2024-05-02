/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FnsTot0026ViewAdapter.java
*@FileTitle : TOT
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.22
*@LastModifier : 이병훈
*@LastVersion : 1.0
* 2010.12.22 이병훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.event;

import java.util.List;

import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.vo.SearchHiringOutAndLayingUpSummaryVO;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Lee Byoung Hun
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class FnsTot0026ViewAdapter extends ViewAdapter {
	
	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 객체
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 */	
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
		StringBuilder sbufXML = new StringBuilder();
		int rowCnt = vos.size();
		
		SearchHiringOutAndLayingUpSummaryVO resultVO = null; // 현재 Row의 정보
		
		String vslCd = ""; // 현재 Row의 VSL Code
		String edtEndNextDay = ""; // 현재 Row의 ETD END의 Next Day
		
		String nextVslCd = ""; // Next Row의 VSL Code
		String nextEtdStart = ""; // Next Row의 ETD START
		
		int sumDay = 0; // sum(Day)
		int sumAmount = 0; // sum(Amount)
		boolean isNewGroup = true;
		
		String etdStart = "";
		String day = "";
		String amount = "";
		String netRgstTongWgt = "";
		double nrgAmt = 0;
		
		sbufXML.append("<DATA COLSEPARATOR='" + DELIMITER + "'>\n");
		
		for(int i=0;i<rowCnt;i++){
			resultVO = (SearchHiringOutAndLayingUpSummaryVO) vos.get(i);
			
			vslCd = resultVO.getVslCd();
			edtEndNextDay = resultVO.getEtdEndNextDay();
			
			nextVslCd = resultVO.getNextVslCd();
			nextEtdStart = resultVO.getNextEtdStart();
			
			// 수식계산에 사용되는 값들 null 체크
			day = checkIntegerNull(resultVO.getDay());
			amount = checkIntegerNull(resultVO.getAmount());
			netRgstTongWgt = checkIntegerNull(resultVO.getNetRgstTongWgt());
			
			// Day, Amount 합계처리
			sumDay = sumDay + Integer.parseInt(day); // sum(Day)
			sumAmount = sumAmount + Integer.parseInt(amount); // sum(Amount)
			
			// Next Row 와 VSL Code가 같고 EDT END가 Next Row의 EDT START와 동일한 경우(동일 Group)
			if (vslCd.equals(nextVslCd) && edtEndNextDay.equals(nextEtdStart)) {
				
				// New Group 의 시작일 경우 ETD START 셋팅
				if (isNewGroup) {
					etdStart = resultVO.getEtdStart();
				}
				isNewGroup = false;
				
			// Next Row 와 VSL Code가 같고 EDT END가 Next Row의 EDT START와 동일하지 않은경우
			} else {
				nrgAmt = Double.parseDouble(netRgstTongWgt) * sumDay * 100;
				
				sbufXML.append("	<TR><![CDATA[");
				sbufXML.append(DELIMITER); // Seq.
				sbufXML.append(resultVO.getTrade()).append(DELIMITER); // Trade
				sbufXML.append(resultVO.getLaneCd()).append(DELIMITER); // Lane
				sbufXML.append(resultVO.getVslCd()).append(DELIMITER); // VSL Code
				sbufXML.append(resultVO.getVslEngNm()).append(DELIMITER); // VSL Name
				sbufXML.append(resultVO.getNetRgstTongWgt()).append(DELIMITER); // NRT
				sbufXML.append(etdStart).append(DELIMITER); // ETD START
				sbufXML.append(resultVO.getEtdEnd()).append(DELIMITER); // ETD END
				sbufXML.append(resultVO.getUsage()).append("%").append(DELIMITER); // USE(%)
				sbufXML.append(sumDay).append(DELIMITER); // DAY
				sbufXML.append(resultVO.getPerTonRev()).append(DELIMITER); // REV per TON
				sbufXML.append(nrgAmt).append(DELIMITER); // NRT AMT
				sbufXML.append(sumAmount); // Taxable AMT
				sbufXML.append("]]></TR>\n");
				
				sumDay = 0; // Next New Group 를 위해 sum(Day) 값 초기화
				sumAmount = 0; // Next New Group 를 위해 sum(Amount) 값 초기화
				isNewGroup = true;
			}
			
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
	 */
	protected String makeDataTag(DBRowSet rs,String prefix) {
		return null;
	}
	
	/**
	 * Argument 가 BLANK 또는 null 일경우 "0" 반환, 아닐경우 Argument 그대로 반환
	 * 
	 * @param arg String
	 * @return String
	 */
	protected String checkIntegerNull(String arg) {
		String returnStr = null;
		
		if ("".equals(arg) || arg == null) {
			returnStr = "0";
		} else {
			returnStr = arg;
		}
		
		return returnStr;
	}

}
