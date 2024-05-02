/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmSpc0104ViewAdapter.java
*@FileTitle      : Forecast History
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.08.28
*@LastModifier   : 한상훈
*@LastVersion    : 1.0
* 2009.08.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.event;

import java.util.List;

import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo.DailyforecastmanageMainVO;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchDailyForecastHistoryOfcListVO;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchDailyForecastHistorySrepAcctListVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.controller.ViewAdapter;

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
				
				sbufXML.append("<DATA TOTAL='"+rowCount+"'>\n");
				
				if (rowCount > 0) {//3.1					
					int lvl = 1;
					String pol, pod;
					String vOffice = "";
					String controlPort = "";
					int lvl1Row = 0;
					int lvl2Row = 0;					
					
					for(int i = 0; i < rowCount;i++){
						pol = list.get(i).getPolCd();
						pod = list.get(i).getPodCd();
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
						
						
//				sbufXML.append("<TR LEVEL='"+lvl+"'>\n");
				sbufXML.append("<TR>\n");
				sbufXML.append("<TD>"+list.get(i).getTrdCd()+"</TD>\n");	
				sbufXML.append("<TD>"+list.get(i).getSubTrdCd()+"</TD>\n");
				sbufXML.append("<TD>"+list.get(i).getRlaneCd()+"</TD>\n");
				sbufXML.append("<TD>"+list.get(i).getSkdDirCd()+"</TD>\n");
				sbufXML.append("<TD>"+list.get(i).getIocCd()+"</TD>\n");
				sbufXML.append("<TD>"+list.get(i).getSlsOfcCd()+"</TD>\n");
				sbufXML.append("<TD>"+list.get(i).getBseWk()+"</TD>\n");	
				sbufXML.append("<TD>"+list.get(i).getVvd()+"</TD>\n");
				sbufXML.append("<TD>"+list.get(i).getBseDt()+"</TD>\n");
						if(lvl == 0){
				sbufXML.append("<TD></TD>\n");
				sbufXML.append("<TD></TD>\n");
						} else {	
				sbufXML.append("<TD>").append((lvl<1)?"":((lvl==1)?("LD".indexOf(controlPort)>=0?"-":"+"):pol)).append("</TD>\n");
				sbufXML.append("<TD>").append((lvl<=1)?"":((lvl==2)?("D".indexOf(controlPort)>=0?"-":"+"):pod)).append("</TD>\n");
						}
				sbufXML.append("<TD>"+list.get(i).getFcastTtlTeuQty()+"</TD>\n");
				sbufXML.append("<TD>"+list.get(i).getFcastLodQty()+"</TD>\n");
				sbufXML.append("<TD>"+list.get(i).getFcast40ftHcQty()+"</TD>\n");
				sbufXML.append("<TD>"+list.get(i).getFcast45ftHcQty()+"</TD>\n");
				sbufXML.append("<TD>"+list.get(i).getFcast53ftQty()+"</TD>\n");
				sbufXML.append("<TD>"+list.get(i).getFcastRfQty()+"</TD>\n");
				sbufXML.append("<TD>"+list.get(i).getFcastTtlWgt()+"</TD>\n");
				sbufXML.append("<TD>"+list.get(i).getAlocLodQty()+"</TD>\n");
				sbufXML.append("<TD>"+list.get(i).getAloc40ftHcQty()+"</TD>\n");
				sbufXML.append("<TD>"+list.get(i).getAloc45ftHcQty()+"</TD>\n");
				sbufXML.append("<TD>"+list.get(i).getAloc53ftQty()+"</TD>\n");
				sbufXML.append("<TD>"+list.get(i).getAlocRfQty()+"</TD>\n");
				sbufXML.append("<TD>"+list.get(i).getAlocTtlWgt()+"</TD>\n");
				sbufXML.append("<TD>"+list.get(i).getLvl()+"</TD>\n");				
				sbufXML.append("<TD>" + (lvl==1?1:0)  + "</TD>");
				sbufXML.append("<TD>" + (lvl==2?1:0)  + "</TD>");
				sbufXML.append("<TD>" + (lvl==3?1:0)  + "</TD>");
				sbufXML.append("<TD></TD>");
				sbufXML.append("</TR>\n");
				
					}
				}
				sbufXML.append("</DATA>\n");	
			}
			else{
				sbufXML.append("<DATA TOTAL='0'>\n");
				sbufXML.append("</DATA>\n");
			}
		}
		else if( comMain.getEventCommand().equals("SEARCHLIST02")){
			if(comMain.getSerpAcctList().size() > 0){
				List<SearchDailyForecastHistorySrepAcctListVO> list = comMain.getSerpAcctList();
				
				int rowCount = list.size();
				
				sbufXML.append("<DATA TOTAL=\""+rowCount+"\">\n");
				
				if (rowCount > 0) {//3.1					
					int lvl = 1;
					String pol, pod;
					String vOffice = "";
					String controlPort = "";
					int lvl1Row = 0;
					int lvl2Row = 0;
					
					for(int i = 0; i < rowCount;i++){
						pol = list.get(i).getPolCd();
						pod = list.get(i).getPodCd();
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
						
						
				sbufXML.append("<TR>\n");
				//sbufXML.append("<TR LEVEL='"+lvl+"' >\n");
				sbufXML.append("<TD>"+list.get(i).getVvdCd()+"</TD>\n");												//20160215.ADD
				sbufXML.append("<TD>"+list.get(i).getSlsOfcCd()+"</TD>\n");
				sbufXML.append("<TD>"+list.get(i).getSrepUsrId()+"</TD>\n");
				sbufXML.append("<TD>"+list.get(i).getSrepNm()+"</TD>\n");
				sbufXML.append("<TD>"+list.get(i).getModiGdt()+"</TD>\n");
				sbufXML.append("<TD>"+list.get(i).getModiUsr()+"</TD>\n");	
				sbufXML.append("<TD>"+list.get(i).getFcastCustTpCd()+"</TD>\n");
				sbufXML.append("<TD>"+list.get(i).getCustCd()+"</TD>\n");
				sbufXML.append("<TD><![CDATA["+list.get(i).getCustNm()+"]]></TD>\n");
				//20150211.ADD START
//				scNo = list.get(i).getScNo().trim();																	//4개로 했다가 머지때문에 3개로 줄임. 나중 늘릴가능성을 위해 남기기
//				rfaNo = list.get(i).getRfaNo().trim();				
//				sbufXML.append("<TD>"+((scNo.length()+rfaNo.length())>0?(scNo.length()>0?scNo:" "):"")+"</TD>\n");
//				sbufXML.append("<TD>"+((scNo.length()+rfaNo.length())>0?(rfaNo.length()>0?rfaNo:" "):"")+"</TD>\n");
				sbufXML.append("<TD>"+list.get(i).getCtrtNo()+"</TD>\n");												//20160325.MOD
				sbufXML.append("<TD>"+list.get(i).getCtrtCustCd()+"</TD>\n");
				sbufXML.append("<TD><![CDATA["+list.get(i).getCtrtCustNm()+"]]></TD>\n");
				//20160211.ADD END
				if(lvl == 0){
				sbufXML.append("<TD></TD>\n");
				sbufXML.append("<TD></TD>\n");
				} else {
				sbufXML.append("<TD>").append((lvl<1)?(""):((lvl==1)?("LD".indexOf(controlPort)>=0?"-":"+"):pol)).append("</TD>\n");
				sbufXML.append("<TD>").append((lvl<=1)?(""):((lvl==2)?("D".indexOf(controlPort)>=0?"-":"+"):pod)).append("</TD>\n");
				}
				sbufXML.append("<TD>"+list.get(i).getFcastTtlTeuQty()+"</TD>\n");
				sbufXML.append("<TD>"+list.get(i).getFcastTtlQty()+"</TD>\n");
				sbufXML.append("<TD>"+list.get(i).getFcast40ftHcQty()+"</TD>\n");
				sbufXML.append("<TD>"+list.get(i).getFcast45ftHcQty()+"</TD>\n");
				sbufXML.append("<TD>"+list.get(i).getFcast53ftQty()+"</TD>\n");
				sbufXML.append("<TD>"+list.get(i).getFcastRfQty()+"</TD>\n");
				sbufXML.append("<TD>"+list.get(i).getFcastTtlWgt()+"</TD>\n");
				sbufXML.append("<TD>"+list.get(i).getUsdBkgTtlQty()+"</TD>\n");
				sbufXML.append("<TD>"+list.get(i).getUsdBkg20ftQty()+"</TD>\n");
				sbufXML.append("<TD>"+list.get(i).getUsdBkg40ftQty()+"</TD>\n");
				sbufXML.append("<TD>"+list.get(i).getUsdBkg40ftHcQty()+"</TD>\n");
				sbufXML.append("<TD>"+list.get(i).getUsdBkg45ftHcQty()+"</TD>\n");
				sbufXML.append("<TD>"+list.get(i).getUsdBkg53ftQty()+"</TD>\n");
				sbufXML.append("<TD>"+list.get(i).getUsdBkgRfQty()+"</TD>\n");
				sbufXML.append("<TD>"+list.get(i).getUsdBkgTtlWgt()+"</TD>\n");
				sbufXML.append("<TD>"+list.get(i).getLvl()+"</TD>\n");
				sbufXML.append("<TD>" + (lvl==1?1:0)  + "</TD>");
				sbufXML.append("<TD>" + (lvl==2?1:0)  + "</TD>");
				sbufXML.append("<TD>" + (lvl==3?1:0)  + "</TD>");
				sbufXML.append("<TD></TD>\n");
				sbufXML.append("</TR>\n");
				
					}
				}
				sbufXML.append("</DATA>\n");
			}
			else{
				sbufXML.append("<DATA TOTAL='0'>\n");
				sbufXML.append("</DATA>\n");
			}
		}			
		else
		{
			sbufXML.append("<RESULT>\n");
			sbufXML.append("<ETC-DATA>\n");
			sbufXML.append("<ETC KEY='status'>OK</ETC>\n"); 
			sbufXML.append("</ETC-DATA>\n");
			sbufXML.append("<TR-ALL>OK</TR-ALL>\n");
			sbufXML.append("<MESSAGE> <![CDATA[ "+new ErrorHandler("SPC00010").getUserMessage()+"]]> </MESSAGE>\n");
			sbufXML.append("</RESULT>\n");
		}
		
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
}