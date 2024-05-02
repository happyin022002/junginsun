/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0104ViewAdapter.java
*@FileTitle : dailyforecastmanage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.08.28 한상훈
* 1.0 Creation
* 2010.07.08 Lee Sang-Yong : [프로젝트] Ticket ID : CHM-201004171 53ft 추가 
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2014.07.30 [CHM-201431081] SPC Allocation Control Option 추가 보완 요청
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.event;

import java.util.List;

import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.DailyforecastmanageMainVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchDailyForecastHistoryOfcListVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchDailyForecastHistorySrepAcctListVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author 한상훈
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EsmSpc0104ViewAdapter extends ViewAdapter{
	
	
	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 객체
	 * @param colOrder String[] Column명 문자열 
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception 
	 */	
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) 
	{
		log.debug("EsmSpc0104ViewAdapter makeDataTag List<AbstractValueObject> vos, String prefix..............");
		StringBuilder sbufXML = new StringBuilder();
		
		DailyforecastmanageMainVO comMain = (DailyforecastmanageMainVO)vos.get(0);
			
		if( comMain.getEventCommand().equals("SEARCHLIST01"))
		{
			if(comMain.getHistoryOfcList().size() > 0){
			
				List<SearchDailyForecastHistoryOfcListVO> list = comMain.getHistoryOfcList();
				
				int rowCount = list.size();
				String cust_ctrl = "";
				
				//sbufXML.append("<SHEET>\n");
				sbufXML.append("<DATA TOTAL='"+rowCount+"'>\n");
				
				if (rowCount > 0) {//3.1					
					int lvl = 1;
					String pol="";
					String pod="";
					String dest="";
					
					String vOffice = "";
					//String controlPort = "";
					int lvl1Row = 0;
					int lvl2Row = 0;
					
					for(int i = 0; i < rowCount;i++){
						pol = list.get(i).getPolCd();
						pod = list.get(i).getPodCd();
						dest = list.get(i).getDestLocCd();
						lvl = Integer.parseInt(list.get(i).getLvl());
						cust_ctrl = list.get(i).getCustCtrlCd();
						
						vOffice = list.get(i).getSlsOfcCd();
						if(vOffice.equals("NULL")){
							vOffice = "";
						}
						if(lvl == 1){
							lvl1Row = -1;
						}
						if(lvl == 2){
							lvl2Row = -1;
						}
						lvl1Row = lvl1Row + 1;
						lvl2Row = lvl2Row + 1;
						
						
						sbufXML.append("<TR LEVEL='"+lvl+"'>\n");
						sbufXML.append("<TD>"+list.get(i).getTrdCd()+"</TD>\n");	
						sbufXML.append("<TD>"+list.get(i).getSubTrdCd()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getRlaneCd()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getSkdDirCd()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getIocCd()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getSlsOfcCd()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getBseWk()+"</TD>\n");	
						sbufXML.append("<TD>"+list.get(i).getVvd()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getBseDt()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getCustCtrlCd()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getUsaBkgModCd()+"</TD>\n");
						if(lvl == 0){
							sbufXML.append("<TD></TD>\n");
							sbufXML.append("<TD></TD>\n");
							sbufXML.append("<TD></TD>\n");
						} else {	
//							sbufXML.append("<TD>").append((lvl<2)?"":((lvl==1)?("LD".indexOf(controlPort)>=0?"-":"+"):pol)).append("</TD>\n");
//							sbufXML.append("<TD>").append((lvl<=2)?"":((lvl==2)?("D".indexOf(controlPort)>=0?"-":"+"):pod)).append("</TD>\n");
							sbufXML.append("<TD>").append(pol).append("</TD>\n");
							sbufXML.append("<TD>").append(pod).append("</TD>\n");
							sbufXML.append("<TD>").append(dest).append("</TD>\n");
						}
						sbufXML.append("<TD>"+list.get(i).getFcastTtlTeuQty()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getFcastLodQty()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getFcast20ftDryQty()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getFcast40ftDryQty()+"</TD>\n");						
						sbufXML.append("<TD>"+list.get(i).getFcast40ftHcQty()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getFcast45ftHcQty()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getFcast53ftQty()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getFcastRfQty()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getFcastRdQty()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getFcastTtlWgt()+"</TD>\n");
						
						if(cust_ctrl.equals("C")){
							sbufXML.append("<TD BGCOLOR='228, 228, 228'></TD>\n");
							sbufXML.append("<TD BGCOLOR='228, 228, 228'></TD>\n");
							sbufXML.append("<TD BGCOLOR='228, 228, 228'></TD>\n");
							sbufXML.append("<TD BGCOLOR='228, 228, 228'></TD>\n");
							sbufXML.append("<TD BGCOLOR='228, 228, 228'></TD>\n");
							sbufXML.append("<TD BGCOLOR='228, 228, 228'></TD>\n");
							sbufXML.append("<TD BGCOLOR='228, 228, 228'></TD>\n");
						}else{
							sbufXML.append("<TD>"+nullToZero(getNull(list.get(i).getCfcastTtlTeuQty()))+"</TD>\n");
							sbufXML.append("<TD>"+nullToZero(getNull(list.get(i).getCfcastLodQty()))+"</TD>\n");
							sbufXML.append("<TD>"+nullToZero(getNull(list.get(i).getCfcast40ftHcQty()))+"</TD>\n");
							sbufXML.append("<TD>"+nullToZero(getNull(list.get(i).getCfcast45ftHcQty()))+"</TD>\n");
							sbufXML.append("<TD>"+nullToZero(getNull(list.get(i).getCfcast53ftQty()))+"</TD>\n");
							sbufXML.append("<TD>"+nullToZero(getNull(list.get(i).getCfcastRfQty()))+"</TD>\n");
							sbufXML.append("<TD>"+nullToZero(getNull(list.get(i).getCfcastTtlWgt()))+"</TD>\n");
						}
						
						sbufXML.append("<TD>"+nullToZero(getNull(list.get(i).getAlocTtlQty()))+"</TD>\n");
						sbufXML.append("<TD>"+nullToZero(getNull(list.get(i).getAloc20ftDryQty()))+"</TD>\n");
						sbufXML.append("<TD>"+nullToZero(getNull(list.get(i).getAloc40ftDryQty()))+"</TD>\n");
						sbufXML.append("<TD>"+nullToZero(getNull(list.get(i).getAloc40ftHcQty()))+"</TD>\n");
						sbufXML.append("<TD>"+nullToZero(getNull(list.get(i).getAloc45ftHcQty()))+"</TD>\n");
						sbufXML.append("<TD>"+nullToZero(getNull(list.get(i).getAloc53ftQty()))+"</TD>\n"); 
						sbufXML.append("<TD>"+nullToZero(getNull(list.get(i).getAlocRfQty()))+"</TD>\n");
						sbufXML.append("<TD>"+nullToZero(getNull(list.get(i).getAlocRdQty()))+"</TD>\n");
						sbufXML.append("<TD>"+nullToZero(getNull(list.get(i).getAlocTtlWgt()))+"</TD>\n");
						
						sbufXML.append("<TD>"+list.get(i).getBkgTtlTeuQty()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getBkg20ftQty()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getBkg40ftQty()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getBkg40ftHcQty()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getBkg45ftHcQty()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getBkg20ftDryQty()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getBkg40ftDryQty()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getBkg53ftQty()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getBkgRfQty()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getBkgRdQty()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getBkgTtlWgt()+"</TD>\n");
						
						sbufXML.append("<TD>"+list.get(i).getLvl()+"</TD>\n");
						sbufXML.append("<TD></TD>\n");
						sbufXML.append("</TR>\n");
				
					}
				}
				sbufXML.append("</DATA>\n");
				//sbufXML.append("</SHEET>\n");		
			}
			else{
//				sbufXML.append("<SHEET>\n");
				sbufXML.append("<DATA TOTAL='0'>\n");
				sbufXML.append("</DATA>\n");
//				sbufXML.append("</SHEET>\n");
			}
		}
		else if( comMain.getEventCommand().equals("SEARCHLIST02")){
			if(comMain.getSerpAcctList().size() > 0){
				List<SearchDailyForecastHistorySrepAcctListVO> list = comMain.getSerpAcctList();
				
				int rowCount = list.size();
				//sbufXML.append("<SHEET>\n");
				sbufXML.append("<DATA TOTAL=\""+rowCount+"\">\n");
				
				if (rowCount > 0) {//3.1					
					int lvl = 1;
					String pol="";
					String pod="";
					String dest="";
					String vOffice = "";
					//String controlPort = ""; //쓰지도 않으면서.
					int lvl1Row = 0;
					int lvl2Row = 0;
//					for(int i = 0; i < 11;i++){
					for(int i = 0; i < rowCount;i++){
						pol = list.get(i).getPolCd();
						pod = list.get(i).getPodCd();
						dest = list.get(i).getDestLocCd();
						lvl = Integer.parseInt(list.get(i).getLvl());
						
						vOffice = list.get(i).getSlsOfcCd();
						if(vOffice.equals("NULL")){
							vOffice = "";
						}
						if(lvl == 1){
							lvl1Row = -1;
						}
						if(lvl == 2){
							lvl2Row = -1;
						}
						lvl1Row = lvl1Row + 1;
						lvl2Row = lvl2Row + 1;
					
						sbufXML.append("<TR LEVEL='"+lvl+"' >\n");
						sbufXML.append("<TD>"+list.get(i).getSlsOfcCd()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getSrepUsrId()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getSrepNm()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getModiGdt()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getModiUsr()+"</TD>\n");	
						sbufXML.append("<TD>"+list.get(i).getFcastCustTpCd()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getUsaBkgModCd()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getCustCd()+"</TD>\n");
						sbufXML.append("<TD><![CDATA["+list.get(i).getCustNm()+"]]></TD>\n");
						if(lvl == 0){
							sbufXML.append("<TD></TD>\n");
							sbufXML.append("<TD></TD>\n");
							sbufXML.append("<TD></TD>\n");
						} else {
//							sbufXML.append("<TD>").append((lvl<1)?(""):((lvl==1)?("LD".indexOf(controlPort)>=0?"-":"+"):pol)).append("</TD>\n");
//							sbufXML.append("<TD>").append((lvl<=1)?(""):((lvl==2)?("D".indexOf(controlPort)>=0?"-":"+"):pod)).append("</TD>\n");
//							sbufXML.append("<TD>").append((lvl<=1)?(""):((lvl==2)?"-":pol)).append("</TD>\n");
//							sbufXML.append("<TD>").append((lvl<1)?(""):((lvl==1)?"-":pod)).append("</TD>\n");
							sbufXML.append("<TD>").append(pol).append("</TD>\n");
							sbufXML.append("<TD>").append(pod).append("</TD>\n");
							sbufXML.append("<TD>").append(dest).append("</TD>\n");
						}
						// Loading Forecast
						sbufXML.append("<TD>"+list.get(i).getFcastTtlTeuQty()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getFcastTtlQty()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getFcast20ftDryQty()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getFcast40ftDryQty()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getFcast40ftHcQty()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getFcast45ftHcQty()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getFcast53ftQty()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getFcastRfQty()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getFcastRdQty()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getFcastTtlWgt()+"</TD>\n");
						
						// Contract Forecast
						sbufXML.append("<TD>"+list.get(i).getCfcastTtlTeuQty()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getCfcastTtlQty()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getCfcast40ftHcQty()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getCfcast45ftHcQty()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getCfcast53ftQty()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getCfcastRfQty()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getCfcastTtlWgt()+"</TD>\n");
						
						// Booking
						sbufXML.append("<TD>"+list.get(i).getUsdBkgTtlQty()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getUsdBkg20ftQty()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getUsdBkg40ftQty()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getUsdBkg20ftDryQty()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getUsdBkg40ftDryQty()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getUsdBkg45ftHcQty()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getUsdBkg53ftQty()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getUsdBkgRfQty()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getUsdBkgRdQty()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getUsdBkgTtlWgt()+"</TD>\n");
						sbufXML.append("<TD>"+list.get(i).getLvl()+"</TD>\n");
						sbufXML.append("<TD></TD>\n");
						sbufXML.append("</TR>\n");
				
					}
				}
				sbufXML.append("</DATA>\n");
			//sbufXML.append("</SHEET>\n");
			}
			else{
//				sbufXML.append("<SHEET>\n");
				sbufXML.append("<DATA TOTAL='0'>\n");
				sbufXML.append("</DATA>\n");
//				sbufXML.append("</SHEET>\n");
			}
		}			
//		else
//		{
//			sbufXML.append("<RESULT>\n");
//			sbufXML.append("<ETC-DATA>\n");
//			sbufXML.append("<ETC KEY='status'>OK</ETC>\n"); 
//			sbufXML.append("</ETC-DATA>\n");
//			sbufXML.append("<TR-ALL>OK</TR-ALL>\n");
//			sbufXML.append("<MESSAGE> <![CDATA[ "+new ErrorHandler("SPC00010").getUserMessage()+"]]> </MESSAGE>\n");
//			sbufXML.append("</RESULT>\n");
//		}
		
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
	protected String makeDataTag(DBRowSet rowSet,String prefix) {
		StringBuilder sbufXML = new StringBuilder();
			
		return sbufXML.toString();
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
	
	private String nullToZero(String str) {
		if(str == null || str.equals(""))
			str = "0";
		return str;
	}
	
	protected String getETCData(EventResponse eventResponse) {
		if(eventResponse==null) 
			return "";
		
		List<Object> vos = eventResponse.getRsVoList();
		String conti_cd  = "";
		
		DailyforecastmanageMainVO comMain = (DailyforecastmanageMainVO)vos.get(0);
		
		if( comMain.getEventCommand().equals("SEARCHLIST01")){
			if(comMain.getHistoryOfcList().size() > 0){
				List<SearchDailyForecastHistoryOfcListVO> list = comMain.getHistoryOfcList();
				conti_cd = list.get(0).getContiCd();
			}
		}else if( comMain.getEventCommand().equals("SEARCHLIST02")){
			if(comMain.getSerpAcctList().size() > 0){
				List<SearchDailyForecastHistorySrepAcctListVO> list = comMain.getSerpAcctList();
				conti_cd = list.get(0).getContiCd();
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		try{
			
			sb.append("<ETC-DATA>\n");
			sb.append("    <ETC KEY='status'>OK</ETC>\n");
			sb.append("    <ETC KEY='contiCd'>" + conti_cd + "</ETC>\n");
			sb.append("</ETC-DATA>\n");
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}
		return sb.toString();
	} 
	
	
	
	
}