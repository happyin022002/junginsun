/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0056ViewAdapter.java
*@FileTitle : Inquiry by T/S port
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.10.14 한상훈
* 1.0 Creation
* 2010.06.22 Lee Sang-Yong : 프로젝트 CHM-201004171  53ft(DW,DX) 추가
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2014.07.02 김용습 R4J 패치 사전 작업
* 2014.07.30 차상영 [CHM-201431081] SPC Allocation Control Option 추가 보완
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.spc.common.SPCUtil;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ComplexMainVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlTsVolumnListVO;
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
public class EsmSpc0056ViewAdapter extends ViewAdapter{
	

	
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
		StringBuilder sbufXML = new StringBuilder();
		ComplexMainVO complexMainVO = (ComplexMainVO)vos.get(0);
		int rowCount	 = 0;
		if( complexMainVO.getEventCommand().equals("SEARCHLIST")){	//2.1
			
			String[] colors = SPCUtil.getColors(3);
			colors[2] = "";
			String ofc_cd = null;
			String rgn_cd = null;
			String rhq_cd = null;
			int treeLvl = 0;
			int color = 2;
			
			List<SearchSpaceControlTsVolumnListVO> viewList = new ArrayList<SearchSpaceControlTsVolumnListVO>();
			viewList = complexMainVO.getSearchSpaceControlTsVolumnListVO();
			
			if(viewList != null) rowCount = viewList.size();
			
//			sbufXML.append("<SHEET>\n");
			sbufXML.append("<DATA TOTAL=\""+rowCount+"\">\n");		
			if (viewList != null) {//3.1
				int idx = 0;
				for(int i=0;i<rowCount;i++){
					
					ofc_cd = viewList.get(i).getSlsOfcCd();
					rgn_cd = viewList.get(i).getSlsRgnOfcCd();
					rhq_cd = viewList.get(i).getSlsRhqCd();
					
					if(rgn_cd.equals(" ")){
						color = 0;
						rgn_cd = rhq_cd;
						ofc_cd = "TTL";
						treeLvl = 0;
					}
					else if(ofc_cd.equals(" ")){
						color = 1;
						ofc_cd = "TTL";
						treeLvl = 0;
					}
					else{
						color = 2;
						treeLvl = 1;
					}					
					
			sbufXML.append("<TR LEVEL='" + treeLvl+ "'>");
			
			sbufXML.append("	<TD>"+viewList.get(i).getEtbDt()+"</TD>");
			sbufXML.append("	<TD>"+viewList.get(i).getRepTrdCd()+"</TD>");	
			sbufXML.append("	<TD>"+viewList.get(i).getRepSubTrdCd()+"</TD>");
			sbufXML.append("	<TD>"+viewList.get(i).getTrdCd()+"</TD>");
			sbufXML.append("	<TD>"+viewList.get(i).getSubTrdCd()+"</TD>");
			sbufXML.append("	<TD>"+viewList.get(i).getRlaneCd()+"</TD>");	
			sbufXML.append("	<TD>"+viewList.get(i).getCostWk()+"</TD>");	
			sbufXML.append("	<TD>"+viewList.get(i).getVvd()+"</TD>");	
			sbufXML.append("	<TD>"+viewList.get(i).getIocCd()+"</TD>");	
			sbufXML.append("	<TD>"+rhq_cd+"</TD>");													
			sbufXML.append("	<TD INDENT='1'>"+viewList.get(i).getSlsAqCd()+"</TD>");	
 			sbufXML.append("	<TD BGCOLOR='"+(color==0?colors[color]:"")+"'>"+rgn_cd+"</TD>");	
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"' INDENT='1'>"+ofc_cd+"</TD>");	
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getUsaBkgModCd()+"</TD>"); //Local/IPI(US MOD)			
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"' INDENT='1'>"+viewList.get(i).getPodCd()+"</TD>"); //pod
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+(idx++)+"</TD>");			
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getDestLocCd()+"</TD>"); //Dest
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getFcastTtl()+"</TD>");	
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getFcastD2()+"</TD>");	//Forecast-D2
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getFcastD4()+"</TD>");	//Forecast-D4
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getFcastHc()+"</TD>");	
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getFcast45()+"</TD>");
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getFcast53()+"</TD>");
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getFcastRf()+"</TD>");
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getFcastRd()+"</TD>");	//Forecast-RD
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getFcastWgt()+"</TD>");		
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getAsgnTtl()+"</TD>");
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getAsgnD2()+"</TD>");	//Allocation-D2
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getAsgnD4()+"</TD>");	//Allocation-D4			
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getAsgnHc()+"</TD>");	
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getAsgn45()+"</TD>");
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getAsgn53()+"</TD>");
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getAsgnRf()+"</TD>");	
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getAsgnRd()+"</TD>");	//Allocation-RD
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getAsgnWgt()+"</TD>");		
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getDifTtl()+"</TD>");	
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getDifD2()+"</TD>");	//Alloc Diff-D2
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getDifD4()+"</TD>");	//Alloc Diff-D4	
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getDifHc()+"</TD>");	
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getDif45()+"</TD>");
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getDif53()+"</TD>");
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getDifRf()+"</TD>");	
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getDifRd()+"</TD>");	//Alloc Diff-RD
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getDifWgt()+"</TD>");	
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getBkgTtl()+"</TD>");	
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getBkgS20()+"</TD>");	
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getBkgS40()+"</TD>");	
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getBkgD2()+"</TD>");	//Booking-D2			
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getBkg20()+"</TD>");	//Booking-20(TEU)	
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getBkgD4()+"</TD>");	//Booking-D4				
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getBkg40()+"</TD>");	//Booking-40(FEU)	
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getBkgHc()+"</TD>");	
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getBkg45()+"</TD>");
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getBkg53()+"</TD>");
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getBkgRf20()+"</TD>");	
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getBkgRf40()+"</TD>");	
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getBkgRd20()+"</TD>");	//Booking-RD20
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getBkgRd40()+"</TD>");	//Booking-RD40
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getBkgWgt()+"</TD>");
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getBkgVolVgm()+"</TD>");	
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getBkgWgtVgm()+"</TD>");	
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getPreRepTrdCd()+"</TD>");	
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getPreRepSubTrdCd()+"</TD>");	
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getPreRlaneCd()+"</TD>");		
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getPreVvd()+"</TD>");	
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getPreEtbDt()+"</TD>");	
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getDisTtl()+"</TD>");	
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getDisS20()+"</TD>");	
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getDisS40()+"</TD>");	
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getDisD2()+"</TD>");	//Booking-D2			
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getDis20()+"</TD>");	//Booking-20(TEU)
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getDisD4()+"</TD>");	//Booking-D4			
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getDis40()+"</TD>");	//Booking-40(FEU)
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getDisHc()+"</TD>");	
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getDis45()+"</TD>");
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getDis53()+"</TD>");
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getDisRf20()+"</TD>");	
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getDisRf40()+"</TD>");
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getDisRd20()+"</TD>");	//Booking-RD20
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getDisRd40()+"</TD>");	//Booking-RD40
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getDisWgt()+"</TD>");
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getDisVolVgm()+"</TD>");
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+viewList.get(i).getDisWgtVgm()+"</TD>");
			sbufXML.append("	<TD BGCOLOR='"+colors[color]+"'>"+treeLvl+"</TD>");	
			
			sbufXML.append("</TR>\n");
				
				}//4.9
			}//3.9
			
			sbufXML.append("</DATA>\n");
//			sbufXML.append("</SHEET>\n");
	
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
	protected String makeDataTag(DBRowSet rs,String prefix) {
		StringBuilder sb = new StringBuilder();
		
		return sb.toString();
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
	
	protected String getETCData(EventResponse eventResponse) {
		if(eventResponse==null) 
			return "";
		
		List<Object> vos = eventResponse.getRsVoList();
		ComplexMainVO complexMainVO = (ComplexMainVO)vos.get(0);
		
		List<SearchSpaceControlTsVolumnListVO> viewList = new ArrayList<SearchSpaceControlTsVolumnListVO>();
		viewList = complexMainVO.getSearchSpaceControlTsVolumnListVO();
		
		int rowCount = 0;
		
		if(viewList != null) rowCount = viewList.size();
		
		String ctrl_opt[] = new String[] {"false", "false", "false", "false", "false", "false", "false", "false"};
		
		if (viewList != null) {//3.1
			
			for(int i=0;i<rowCount;i++){
				if(ctrl_opt[0].equals("false") && getNull(viewList.get(i).getCtrlHc()).equals("Y"))  ctrl_opt[0] = "true";
				if(ctrl_opt[1].equals("false") && getNull(viewList.get(i).getCtrl45()).equals("Y"))  ctrl_opt[1] = "true";
				if(ctrl_opt[2].equals("false") && getNull(viewList.get(i).getCtrl53()).equals("Y"))  ctrl_opt[2] = "true";
				if(ctrl_opt[3].equals("false") && getNull(viewList.get(i).getCtrlRf()).equals("Y"))  ctrl_opt[3] = "true";
				if(ctrl_opt[4].equals("false") && getNull(viewList.get(i).getCtrlWgt()).equals("Y")) ctrl_opt[4] = "true";
				
				//2014.07.31 csy SPC Allocation Control Option 추가 보완 적용
				if(ctrl_opt[5].equals("false") && getNull(viewList.get(i).getCtrlD2()).equals("Y")) ctrl_opt[5] = "true";
				if(ctrl_opt[6].equals("false") && getNull(viewList.get(i).getCtrlD4()).equals("Y")) ctrl_opt[6] = "true";
				if(ctrl_opt[7].equals("false") && getNull(viewList.get(i).getCtrlRd()).equals("Y")) ctrl_opt[7] = "true";
			}
		}
		
		String ctrlopt = "";
		
		//2014.07.02 김용습 R4J 패치 사전 작업
      	StringBuffer out1 = new StringBuffer();
      	
		for(int j = 0 ; j < 8; j++){
			//2014.07.02 김용습 R4J 패치 사전 작업
			//ctrlopt = ctrlopt + "|" + ctrl_opt[j];
			out1.append("|").append(ctrl_opt[j]);
		}
		ctrlopt = out1.toString();
		
		StringBuilder sb = new StringBuilder();
		
		try{
			
			sb.append("<ETC-DATA>\n");
			sb.append("    <ETC KEY='status'>OK</ETC>\n");
			sb.append("    <ETC KEY='ctrlopt'>" + ctrlopt + "</ETC>\n");
			sb.append("</ETC-DATA>\n");
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}
		return sb.toString();
	}
	
}