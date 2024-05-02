/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSaq0077ViewAdapter.java
*@FileTitle : Model Result
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.09
*@LastModifier : 김종호
*@LastVersion : 1.2
* 2008-11-24 Lee SeungYol (Default View Adapter 제공)
* 2009.08.31 김종호
* 1.0 Creation (new F/W 전환작업)
* 2010.03.09 VO에 사용되는 get메소드 명칭 수정   
* 2011.02.14 김종준 [T-선사] YEARLY QTA 부분 삭제
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.event;

import java.util.List;

import com.clt.apps.opus.esm.saq.common.SAQUtil;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.vo.SearchMonthlyQuotaInfoList0077VO;
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
public class EsmSaq0077ViewAdapter extends ViewAdapter {

	
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
		SearchMonthlyQuotaInfoList0077VO listVo = null; 
		// 아래 AbstractValueObject에서 vo 를 사용하기 때문에 여기서는 listVo로 명명하였다.
		
		StringBuilder sbufXML = new StringBuilder();
		
		int totCnt = vos.size(); // 측정된 데이터의 갯수
		int realCnt = vos.size();
		
//		double ratio = 0;

		AbstractValueObject vo = (AbstractValueObject)vos.get(0);
//		String[] realColNms=getColHeader(vo);
//		String[] changedColNms = getChangedColNms(realColNms, prefix);
		
		if(vo.getMaxRows()>0){
			totCnt = vo.getMaxRows();
		}
		
		sbufXML.append("<DATA TOTAL='" + totCnt +"'>\n");
		// ViewAdapter에서는 ☜☞ 를 구분자로 사용하지만 이번에는 사용할 필요가 없기 때문에 separator 부분을 제거했다. 
		for(int i=0;i<realCnt;i++){
			//Map<String, String> colValues = vos.get(i).getColumnValues();
			// 맵으로 받지 않고 리스트로 받았기 때문에 
			listVo = (SearchMonthlyQuotaInfoList0077VO) vos.get(i);
			//기존 VOs에서 받아온 데이터를 형변환 하여 VO에 입력
			sbufXML.append("<TR LEVEL=\"" + listVo.getSlevel() + "\">"); //  \ <=이 기호 사이의 값은 문자로만 인식한다.
//			int colCnt = realColNms.length;
//			
//			for (int j = 0 ; j < colCnt-1 ; j++) {  // 원래는 컬럼의 갯수만큼 루프를 돌아 값을 만들지만, 기존 소스와 같이 하나하나 나열하여 입력하는 걸로 해서 주석처리.
//				sbufXML.append(getNull(colValues.get(realColNms[j])) + DELIMITER);
//	        }
			// <TD>를 사용해 기존 077GS의 값을 하나씩 대입한다. <![CDATA 이부분은 제거하는 편이 결과값 출력이 더 잘 된다.
			sbufXML.append("<TD>" + listVo.getTrdCd() + "</TD>");
			sbufXML.append("<TD>" + listVo.getDirCd() + "</TD>");
			sbufXML.append("<TD>" + listVo.getSubTrdCd() + "</TD>");
			
			sbufXML.append("<TD>" + listVo.getMdlLoad() + "</TD>");
			sbufXML.append("<TD></TD>");
			
			sbufXML.append("<TD></TD>");
			
			sbufXML.append("<TD>" + listVo.getMdlGrossRevenue() + "</TD>");
			
			sbufXML.append("<TD>" + listVo.getMdlCm() + "</TD>");
			
			sbufXML.append("<TD>" + listVo.getMdlOp() + "</TD>");
			
			sbufXML.append("<TD>" + listVo.getAccMdlLoad() + "</TD>");
			
			sbufXML.append("<TD>" + listVo.getAccMdlRev() + "</TD>");
		
			sbufXML.append("<TD>" + listVo.getMdlCapa() + "</TD>");
						
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
		// 하지만 ESM_SAQ_0077의 경우 DBRowSet을 사용하지 않기 때문에 이부분은 골격만 만들어 놓는다.
		return null;
	}

}
