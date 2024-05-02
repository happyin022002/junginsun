/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSaq0149ViewAdapter.java
*@FileTitle : Regional Group Vs Regional Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : Choi.M.C
*@LastVersion : 1.0
* 2007-03-05 byyoo
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.event;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.clt.apps.opus.esm.saq.common.SAQUtil;
import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.vo.SearchMonthlyQuotaAdjustmentRhqModifyListVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.core.layer.event.EventResponse;
/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Choi.M.C
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EsmSaq0149ViewAdapter extends ViewAdapter {

	public EsmSaq0149ViewAdapter() {
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
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
		// TODO Auto-generated method stub
		StringBuilder sbufXML = new StringBuilder();
		
		ReturnVO listVO = (ReturnVO)vos.get(0);
		QuotaConditionVO conditionVO = (QuotaConditionVO) listVO.getList(1);
		
		// Sheet 관련 색상 지정
		String bgColor[] = SAQUtil.getColors(4);	
		
		if(conditionVO.getChkCommand().equals("SEARCHLIST")){
			
			List<SearchMonthlyQuotaAdjustmentRhqModifyListVO> list01=  (List<SearchMonthlyQuotaAdjustmentRhqModifyListVO>) listVO.getList(0);
			int totCnt = list01.size();
			
			sbufXML.append("<DATA TOTAL='" + totCnt +"'>\n");
			
			for(int j=0; j<totCnt; j++){
				
				SearchMonthlyQuotaAdjustmentRhqModifyListVO colValues = list01.get(j);
				
				sbufXML.append("<TR>");
				sbufXML.append("	<TD BGCOLOR=\""+bgColor[1]+"\">"+colValues.getSubTrdCd()+"</TD>	");
				sbufXML.append("	<TD BGCOLOR=\""+bgColor[1]+"\">"+colValues.getLaneGrp()+"</TD>	");
				sbufXML.append("	<TD BGCOLOR=\""+bgColor[1]+"\">"+colValues.getOfcCd()+"</TD>	");
				sbufXML.append("	<TD BGCOLOR=\""+bgColor[1]+"\">"+colValues.getGrpSeq1()+"</TD>	");
				sbufXML.append("	<TD BGCOLOR=\""+bgColor[1]+"\">"+colValues.getLoad1()+"</TD>	");
				sbufXML.append("	<TD BGCOLOR=\""+bgColor[1]+"\">"+colValues.getLoad1()+"</TD>	");
				sbufXML.append("	<TD BGCOLOR=\""+bgColor[1]+"\">"+colValues.getGRpb1()+"</TD>	");
				sbufXML.append("	<TD BGCOLOR=\""+bgColor[1]+"\">"+colValues.getGRpb1()+"</TD>	");
				sbufXML.append("	<TD BGCOLOR=\""+bgColor[1]+"\">"+colValues.getGrpSeq2()+"</TD>	");
				sbufXML.append("	<TD BGCOLOR=\""+bgColor[1]+"\">"+colValues.getLoad2()+"</TD>	");
				if(colValues.getLoad2().equals("")){
					sbufXML.append("	<TD BGCOLOR='DEFBF8'>"+colValues.getLoad2()+"</TD>	");
				}else{
					sbufXML.append("	<TD BGCOLOR=\""+bgColor[2]+"\">"+colValues.getLoad2()+"</TD>	");
				}
				sbufXML.append("	<TD BGCOLOR=\""+bgColor[1]+"\">"+colValues.getGRpb2()+"</TD>	");
				if(colValues.getGRpb2().equals("")){
					sbufXML.append("	<TD BGCOLOR='DEFBF8'>"+colValues.getGRpb2()+"</TD>	");
				}else{
					sbufXML.append("	<TD BGCOLOR=\""+bgColor[2]+"\">"+colValues.getGRpb2()+"</TD>	");
				}
				sbufXML.append("	<TD BGCOLOR=\""+bgColor[1]+"\">"+colValues.getGrpSeq3()+"</TD>	");
				sbufXML.append("	<TD BGCOLOR=\""+bgColor[1]+"\">"+colValues.getLoad3()+"</TD>	");
				if(colValues.getLoad3().equals("")){
					sbufXML.append("	<TD BGCOLOR='DEFBF8'>"+colValues.getLoad3()+"</TD>	");
				}else{
					sbufXML.append("	<TD BGCOLOR=\""+bgColor[2]+"\">"+colValues.getLoad3()+"</TD>	");
				}
				sbufXML.append("	<TD BGCOLOR=\""+bgColor[1]+"\">"+colValues.getGRpb3()+"</TD>	");
				if(colValues.getGRpb3().equals("")){
					sbufXML.append("	<TD BGCOLOR='DEFBF8'>"+colValues.getGRpb3()+"</TD>	");
				}else{
					sbufXML.append("	<TD BGCOLOR=\""+bgColor[2]+"\">"+colValues.getGRpb3()+"</TD>	");
				}
				sbufXML.append("	<TD BGCOLOR=\""+bgColor[1]+"\">"+colValues.getTotBsa()+"</TD>	    ");
				sbufXML.append("	<TD BGCOLOR=\""+bgColor[1]+"\">"+colValues.getRlaneCd()+"</TD>	    ");
				sbufXML.append("	<TD BGCOLOR=\""+bgColor[1]+"\">"+colValues.getSprtGrpCd()+"</TD>	");
				sbufXML.append("	<TD BGCOLOR=\""+bgColor[1]+"\">"+colValues.getBsaGrpCd()+"</TD>	    ");
				sbufXML.append("	<TD BGCOLOR=\""+bgColor[1]+"\">"+colValues.getCtrtRgnOfcCd()+"</TD>	");
				sbufXML.append("	<TD BGCOLOR=\""+bgColor[1]+"\">"+colValues.getTrdCd()+"</TD>	    ");
				sbufXML.append("	<TD>R</TD>	");
				sbufXML.append("	<TD></TD>	");
				sbufXML.append("</TR>");
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
