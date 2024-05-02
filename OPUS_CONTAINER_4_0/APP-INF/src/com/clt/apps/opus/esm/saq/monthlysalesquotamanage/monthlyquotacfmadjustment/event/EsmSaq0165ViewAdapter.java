/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSaq0165ViewAdapter.java
*@FileTitle : 월간 판매목표 사후 조정 - QTA Editing
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : Choi.M.C
*@LastVersion : 1.0
* 2008-04-10 Lee Ho Ik (CSR No. N200804140003)
* 1.0 Creation
* 2008-06-19 Y.S.CHOI : IBSheet 컬럼 추가에 따른 수정
* 2008-12-10 Y.S.CHOI : CSR No.N200812090019 Reefer, GAMer 와 같이 사용으로 인한 IBSheet 컬럼 변경에 따른 수정
* 2011-02-16 김종준 : [T-선사]  GAMer 관련 hidden 필드 삭제
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.event;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.vo.SearchMonthlyQtaEditListVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author ChoiI.M.C
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EsmSaq0165ViewAdapter extends ViewAdapter {

	public EsmSaq0165ViewAdapter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 객체
	 * @param colOrder String[] Column명 문자열 
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception 
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
		// TODO Auto-generated method stub
		StringBuilder sbufXML = new StringBuilder();

		ReturnVO listVO = (ReturnVO)vos.get(0);
		QuotaConditionVO conditionVO = listVO.getConditionVO();

		if(conditionVO.getChkCommand().equals("SEARCHLIST")){

			List<SearchMonthlyQtaEditListVO> list =  (List<SearchMonthlyQtaEditListVO>) listVO.getList(0);
			int totCnt = list.size();
			
			sbufXML.append("<DATA TOTAL='" + totCnt +"'>\n");
			for(int j=0; j<totCnt; j++){

				SearchMonthlyQtaEditListVO colValues = list.get(j);
				
				sbufXML.append("<TR>");
				sbufXML.append("<TD>R</TD>");
				sbufXML.append("<TD>"+colValues.getRn()+"</TD>");
				sbufXML.append("<TD>"+colValues.getMqtaRlseVerNo()+"</TD>");
				sbufXML.append("<TD>"+colValues.getBseYr()+"</TD>");
				sbufXML.append("<TD>"+colValues.getBseQtrCd()+"</TD>");
				sbufXML.append("<TD>"+colValues.getQtaTgtCd()+"</TD>");
				sbufXML.append("<TD>"+colValues.getTrdCd()+"</TD>");
				sbufXML.append("<TD>"+colValues.getDirCd()+"</TD>");
				sbufXML.append("<TD>"+colValues.getSubTrdCd()+"</TD>");
				sbufXML.append("<TD>"+colValues.getRlaneCd()+"</TD>");
				sbufXML.append("<TD>"+colValues.getVvdCd()+"</TD>");
				sbufXML.append("<TD>"+colValues.getLaneGrp()+"</TD>");
				sbufXML.append("<TD>"+colValues.getBseMon()+"</TD>");
				sbufXML.append("<TD>"+colValues.getBseWk()+"</TD>");
				sbufXML.append("<TD>"+colValues.getFnlBsaCapa()+"</TD>");
				sbufXML.append("<TD>"+colValues.getRgnOfcCd()+"</TD>");
				sbufXML.append("<TD>"+colValues.getRhqCd()+"</TD>");
				sbufXML.append("<TD>"+colValues.getAqCd()+"</TD>");
				sbufXML.append("<TD>"+colValues.getUnit()+"</TD>");
				sbufXML.append("<TD>"+colValues.getLodQty()+"</TD>");
				sbufXML.append("<TD>"+colValues.getGrsRev()+"</TD>");
				sbufXML.append("<TD>"+colValues.getGrsRpbRev()+"</TD>");
				sbufXML.append("<TD>"+colValues.getCmAmt()+"</TD>");
				sbufXML.append("<TD>"+colValues.getCmUcAmt()+"</TD>");
				sbufXML.append("<TD>"+colValues.getOpfitUcAmt()+"</TD>");
				sbufXML.append("<TD>"+colValues.getFullStvgUcAmt()+"</TD>");
				sbufXML.append("<TD>"+colValues.getFullTrspUcAmt()+"</TD>");
				sbufXML.append("<TD>"+colValues.getMtyStvgUcAmt()+"</TD>");
				sbufXML.append("<TD>"+colValues.getMtyTrspUcAmt()+"</TD>");
				sbufXML.append("<TD>"+colValues.getCntrFxUcAmt()+"</TD>");
				sbufXML.append("<TD>"+colValues.getChssFxUcAmt()+"</TD>");
				sbufXML.append("<TD>"+colValues.getAgnCommUtAmt()+"</TD>");
				sbufXML.append("<TD>"+colValues.getBizActUcAmt()+"</TD>");
				sbufXML.append("<TD>"+colValues.getSltMgmtUcAmt()+"</TD>");
				sbufXML.append("<TD>"+colValues.getOwnVolActUcAmt()+"</TD>");
				sbufXML.append("<TD>"+colValues.getStpUcAmt()+"</TD>");
				sbufXML.append("<TD>"+colValues.getEqHldUcAmt()+"</TD>");
				sbufXML.append("<TD>"+colValues.getEqRepoUcAmt()+"</TD>");
				sbufXML.append("<TD>"+colValues.getEqSimUcAmt()+"</TD>");
				sbufXML.append("<TD>"+colValues.getConvDirCd()+"</TD>");
				sbufXML.append("<TD>"+colValues.getSaqMiscRevAmt()+"</TD>");
				sbufXML.append("<TD>"+colValues.getCustGrpId()+"</TD>");
				sbufXML.append("<TD>"+colValues.getAddTpCd()+"</TD>");
				sbufXML.append("</TR>\n");
				
			}
			sbufXML.append("</DATA>\n");
			
		}
		return sbufXML.toString();
	}
	
	@SuppressWarnings("unchecked")
	protected String getETCData(EventResponse eventResponse) { 
		if(eventResponse==null) 
			return ""; 

			StringBuilder sb = new StringBuilder(); 
			HashMap<String, String> etc_data = (HashMap<String, String>) eventResponse.getETCData();

			sb.append("<ETC-DATA>\n"); 
			if(etc_data !=null && etc_data.size()>0){ 
				Iterator it = etc_data.keySet().iterator(); 
				while(it.hasNext()) {
					String key = (String)it.next();
					String val = "" + etc_data.get(key); 
					sb.append("<ETC KEY='" + key + "'><![CDATA[" + val + "]]></ETC>\n");
					
				} 
			}

			sb.append("</ETC-DATA>\n"); 
			//Pivot 관련 ETC-DATA생성 
			sb.append(getPivotETCData(eventResponse)); 

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
	@Override
	protected String makeDataTag(DBRowSet arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
