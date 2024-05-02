/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0070ViewAdapter.java
*@FileTitle : spaceallocationmanage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.10.01 한상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.spc.common.SPCUtil;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchNoShowAdjustmentListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchNoShowDownloadDateListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SpaceAllocationManageVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.controller.ViewAdapter;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author 한상훈
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EsmSpc0070ViewAdapter extends ViewAdapter{
	
	

	
	
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
				
		SpaceAllocationManageVO spaceAllocationManageVO = (SpaceAllocationManageVO)vos.get(0);

		boolean searchOffice = !spaceAllocationManageVO.getConditionVO().getOffice().equals("");
		boolean searchVVD = !spaceAllocationManageVO.getConditionVO().getVvd().equals("");
		boolean searchWeek = !spaceAllocationManageVO.getConditionVO().getWeek().equals("");
		boolean searchLane = !spaceAllocationManageVO.getConditionVO().getLane().equals("");
		
		int rowCount	 = 0;
		if( spaceAllocationManageVO.getEventCommend().equals("SEARCHLIST01")){	//2.1
			
			List<SearchNoShowAdjustmentListVO> viewList = new ArrayList<SearchNoShowAdjustmentListVO>();
			viewList = spaceAllocationManageVO.getSearchNoShowAdjustmentListVOs();
			
			if(viewList != null) rowCount = viewList.size();
			
//			sbufXML.append("<SHEET>\n");
			sbufXML.append("<DATA TOTAL=\""+rowCount+"\">\n");		
			
			String[] color = SPCUtil.getColors(6);
			color[3] = "255,255,255";
			color[4] = "255,255,255";
			color[5] = "255,255,255";
			int[] level = {0, 0, 0, 0, 0};
			int row = 0;
			if(viewList != null && viewList.size() > 0){
				int lvl = 0;
				String lane = null;
				String week = null;
				String area = null;
				String office = null;
				String pol = null;
				for(int i=0;i<rowCount;i++){
					lvl = Integer.parseInt(viewList.get(i).getLvl());
					lane = viewList.get(i).getRlaneCd();
					week = viewList.get(i).getCostWk();
					area = viewList.get(i).getAqCd();
					office = viewList.get(i).getOfcCd();
					pol = viewList.get(i).getPolYdCd();
					if(lane.equals("")){
						lane = "-";
						level[0] = 0;
						level[1] = 0;
						level[2] = 0;
						level[3] = 0;
						level[4] = 0;
					}
					else if(week.equals("")){
						week = "-";
						level[1] = 0;
						level[2] = 0;
						level[3] = 0;
						level[4] = 0;
					}
					else if(area.equals("")){
						area = "+";
						level[2] = 0;
						level[3] = 0;
						level[4] = 0;
					}
					else if(office.equals("")){
						office = "-";
						level[3] = 0;
						level[4] = 0;
					}
					else if(pol.equals("")){
						pol = "-";
						level[4] = 0;
					}
					
					if((!searchOffice || (lvl != 3 && lvl != 4)) && (!searchVVD || (lvl >= 3)) && (!searchWeek || lvl != 2) && (!searchLane || lvl != 1)){
	
			sbufXML.append("<tr BGCOLOR='"+color[lvl-1]+"' LEVEL='"+lvl+"' EXPAND='"+(lvl!=3?"TRUE":"FALSE")+"' EDIT='"+(lvl==6)+"' MERGE='FALSE'>\n");
			sbufXML.append("<td BGCOLOR='"+color[5]+"'>"+viewList.get(i).getTrdCd()+"</td>\n");
			sbufXML.append("<td BGCOLOR='"+(lvl>1?color[5]:color[lvl-1])+"'>"+lane+"</td>\n");
			sbufXML.append("<td BGCOLOR='"+(lvl>2?color[5]:color[lvl-1])+"'>"+week+"</td>\n");
			sbufXML.append("<td BGCOLOR='"+(lvl>2?color[5]:color[lvl-1])+"'>"+viewList.get(i).getVvd()+"</td>\n");
			sbufXML.append("<td>"+area+"</td>\n");
			sbufXML.append("<td>"+office+"</td>\n");
			sbufXML.append("<td>"+pol+"</td>\n");
			sbufXML.append("<td INDENT='"+(1+(row%2))+"' DATA-FORMAT='"+(lvl<6?"dfNone":"dfInteger")+"'>"+(lvl<6?"":viewList.get(i).getOrgFcastLodQty())+"</td>\n");
			sbufXML.append("<td INDENT='"+(2+(row%2))+"' DATA-FORMAT='"+(lvl<6?"dfNone":"dfInteger")+"' BGCOLOR='"+(lvl==6?"255,255,128":"")+"'>"+(lvl<6?"":viewList.get(i).getFcastLodQty())+"</td>\n");
			sbufXML.append("<td INDENT='"+(1+(row%2))+"' DATA-FORMAT='"+(lvl<6?"dfNone":"dfInteger")+"'>"+(lvl<6?"":viewList.get(i).getBkgLodQty())+"</td>\n");
			sbufXML.append("<td INDENT='"+(2+(row%2))+"' DATA-FORMAT='"+(lvl<6?"dfNone":"dfInteger")+"'>"+(lvl<6?"":viewList.get(i).getOrgAlocLodQty())+"</td>\n");
			sbufXML.append("<td INDENT='"+(1+(row%2))+"' DATA-FORMAT='"+(lvl<6?"dfNone":"dfInteger")+"' BGCOLOR='"+(lvl==6?"255,255,128":"")+"'>"+(lvl<6?"":viewList.get(i).getAlocLodQty())+"</td>\n");
			sbufXML.append("<td INDENT='"+(2+(row%2))+"' DATA-FORMAT='"+(lvl<6?"dfNone":"dfInteger")+"'>"+(lvl<6?"":viewList.get(i).getShortfall())+"</td>\n");
			sbufXML.append("<td INDENT='"+(1+(row%2))+"' DATA-FORMAT='"+(lvl<6?"dfNone":"dfNone")+"'>"+(lvl<6?"":viewList.get(i).getRatio()+"%")+"</td>\n");
			sbufXML.append("<td>"+viewList.get(i).getAlocDdctBseCd()+"</td>\n");
			sbufXML.append("<td>"+viewList.get(i).getOfcKndCd()+"</td>\n");
			sbufXML.append("<td>"+viewList.get(i).getSkdDirCd()+"</td>\n");
			sbufXML.append("<td>"+viewList.get(i).getVslCd()+"</td>\n");
			sbufXML.append("<td>"+viewList.get(i).getSkdVoyNo()+"</td>\n");
			sbufXML.append("<td>"+viewList.get(i).getSkdDirCd()+"</td>\n");
			sbufXML.append("<td></td>\n");
	
						row = row + 1;
						for(int j = 0 ; j < level.length ; j++){
	
			sbufXML.append("<td>"+level[j]+"</td>\n");
	
							level[j] = level[j] + 1;
						}
	
			sbufXML.append("<td>"+lvl+"</td>\n");
			sbufXML.append("</tr>\n");
	
					}
				}
			}

			sbufXML.append("</DATA>\n");
//			sbufXML.append("</SHEET>\n");
	
		}
		else if( spaceAllocationManageVO.getEventCommend().equals("SEARCHLIST02")){	//2.1
			
			List<SearchNoShowDownloadDateListVO> viewList = new ArrayList<SearchNoShowDownloadDateListVO>();
			viewList = spaceAllocationManageVO.getSearchNoShowDownloadDateListVOs();
			
			String[] days = {
					"01|02|03|04|05|06|07|08|09|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31",
					"01|02|03|04|05|06|07|08|09|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30",
					"01|02|03|04|05|06|07|08|09|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29",
					"01|02|03|04|05|06|07|08|09|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28"
				};
			
			if(viewList != null) rowCount = viewList.size();
			
//			sbufXML.append("<SHEET>\n");
			sbufXML.append("<DATA TOTAL=\""+rowCount+"\">\n");		
			
			if(viewList != null && rowCount > 0){
				int d = 0;
				for(int i=0;i<rowCount;i++){
					d = Integer.parseInt(viewList.get(i).getDays());
	
			sbufXML.append("<tr>\n");
			sbufXML.append("<td>"+viewList.get(i).getBseMon()+"</td>\n");
			sbufXML.append("<td COMBO-TEXT='"+days[d]+"' COMBO-CODE='"+days[d]+"'>"+viewList.get(i).getDwnLodDy()+"</td>\n");
			sbufXML.append("<td>"+viewList.get(i).getWeek()+"</td>\n");
			sbufXML.append("<td>"+viewList.get(i).getExeDt()+"</td>\n");
			sbufXML.append("<td>"+viewList.get(i).getSweek()+"</td>\n");
			sbufXML.append("<td>"+viewList.get(i).getBseYrmon()+"</td>\n");
			sbufXML.append("</tr>\n");
	
				}
			}

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
	
	
}