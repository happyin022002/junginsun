/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmSpc0053ViewAdapter.java
*@FileTitle      : Control Option Inquiry
*@LastModifyDate : 2009.09.22
*@LastModifier   : 한상훈
*@LastVersion    : 1.0
* 2009.09.22
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.event;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0053ManageListVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SpaceAllocationManageVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author 한상훈
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EsmSpc0053ViewAdapter extends ViewAdapter{	
	
	
	
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
		
		int rowCount	 = 0;
		
		List<SearchSpaceAllocation0053ManageListVO> viewList = new ArrayList<SearchSpaceAllocation0053ManageListVO>();
		viewList = spaceAllocationManageVO.getSearchSpaceAllocation0053ManageListVOs();
		
		if(viewList != null) rowCount = viewList.size();
		
		sbufXML.append("<DATA TOTAL='" + rowCount +"'>\n");

		String rep_trd_cd = null;
		String sub_trd_cd = null;
		String lane = null;
		String bound = null;
		String week = null;
		String vvd = null;
		String volume = null;
		String hc40 = null;
		String hc45 = null;
		String ctrl53ft = null;
		String reefer = null;
		String pol = null;
		String weight = null;
		String for_volum = null;
		String for_hc = null;
		String for_hc45 = null;
		String for_53ft = null;
		String for_reefer = null;
		String for_weight = null;
//		String load_volum = null; //소스 품질 수정 요청건
//		String load_hc = null;
//		String load_hc45 = null;
//		String load_53ft = null;
//		String load_reefer = null;
//		String load_weight = null;
		int hc40_new = 0;
		int hc45_new = 0;
		int ctrl53ft_new = 0;
		int reefer_new = 0;
		int weight_new = 0;
		
		for(int i=0;i<rowCount;i++){
			
			
			rep_trd_cd = JSPUtil.getNull(viewList.get(i).getRepTrdCd());
			sub_trd_cd = JSPUtil.getNull(viewList.get(i).getRepSubTrdCd());
			lane = JSPUtil.getNull(viewList.get(i).getRlaneCd());
			bound = JSPUtil.getNull(viewList.get(i).getDirCd());  
			week = JSPUtil.getNull(viewList.get(i).getWeek());
			if(week.length()==5){
				week = week.substring(0,4)+"0"+week.substring(4);
			}
			vvd = JSPUtil.getNull(viewList.get(i).getVvd());     
			volume = JSPUtil.getNull(viewList.get(i).getCtrlSpcFlg());
			hc40 = JSPUtil.getNull(viewList.get(i).getCtrl40ftHcFlg()); 
			if(hc40.equals("Y")){
				hc40_new = 1;
			}else{
				hc40_new = 0;
			}
			hc45 = JSPUtil.getNull(viewList.get(i).getCtrl45ftHcFlg());  
			if(hc45.equals("Y")){
				hc45_new = 1;
			}else{
				hc45_new = 0;
			}
			ctrl53ft = JSPUtil.getNull(viewList.get(i).getCtrl53ftFlg());
			if(ctrl53ft.equals("Y")){
				ctrl53ft_new = 1;
			}else{
				ctrl53ft_new = 0;
			}
			reefer = JSPUtil.getNull(viewList.get(i).getCtrlRfFlg());
			if(reefer.equals("Y")){
				reefer_new = 1;
			}else{
				reefer_new = 0;
			}
			pol = JSPUtil.getNull(viewList.get(i).getCtrlPortFlg());   
			weight = JSPUtil.getNull(viewList.get(i).getCtrlWgtFlg());
			if(weight.equals("Y")){
				weight_new = 1;
			}else{
				weight_new = 0;
			}
			for_volum = JSPUtil.getNull(viewList.get(i).getForVolum());
			for_hc = JSPUtil.getNull(viewList.get(i).getForHc());
			for_hc45 = JSPUtil.getNull(viewList.get(i).getForHc45());
			for_53ft = JSPUtil.getNull(viewList.get(i).getFor53ft());
			for_reefer = JSPUtil.getNull(viewList.get(i).getForReefer());
			for_weight = JSPUtil.getNull(viewList.get(i).getForWeight());
			
			sbufXML.append("	<TR>");	
			sbufXML.append("	<TD>"+rep_trd_cd+"</TD>");
			sbufXML.append("	<TD INDENT='1'>"+sub_trd_cd+"</TD>");
			sbufXML.append("	<TD>"+lane+"</TD>");
			sbufXML.append("	<TD>"+bound+"</TD>");
			sbufXML.append("	<TD>"+week+"</TD>");
			sbufXML.append("	<TD>"+vvd+"</TD>");
			sbufXML.append("	<TD>"+volume+"</TD>");
			sbufXML.append("	<TD>"+hc40_new+"</TD>");
			sbufXML.append("	<TD>"+hc45_new+"</TD>");
			sbufXML.append("	<TD>"+ctrl53ft_new+"</TD>");
			sbufXML.append("	<TD>"+reefer_new+"</TD>");
			sbufXML.append("	<TD>"+pol+"</TD>");
			sbufXML.append("	<TD>"+weight_new+"</TD>");
			
			sbufXML.append("	<TD>"+for_volum+"</TD>");
			sbufXML.append("	<TD>"+for_hc+"</TD>");
			sbufXML.append("	<TD>"+for_hc45+"</TD>");
			sbufXML.append("	<TD>"+for_53ft+"</TD>");
			sbufXML.append("	<TD>"+for_reefer+"</TD>");
			sbufXML.append("	<TD>"+for_weight+"</TD>");
			
//			sbufXML.append("	<TD>"+load_volum+"</TD>"); //소스 품질 수정 요청건
//			sbufXML.append("	<TD>"+load_hc+"</TD>");
//			sbufXML.append("	<TD>"+load_hc45+"</TD>");
//			sbufXML.append("	<TD>"+load_53ft+"</TD>");
//			sbufXML.append("	<TD>"+load_reefer+"</TD>");
//			sbufXML.append("	<TD>"+load_weight+"</TD>");
			
			sbufXML.append("	<TD></TD>");
			sbufXML.append("	<TD></TD>");
			sbufXML.append("	<TD></TD>");
			sbufXML.append("	<TD></TD>");
			sbufXML.append("	<TD></TD>");
			sbufXML.append("	<TD></TD>");
			
			sbufXML.append("</TR>\n");
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