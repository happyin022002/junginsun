/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0053ViewAdapter.java
*@FileTitle : spaceallocationmanage
*@LastModifyDate : 2009.09.22
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.09.22 한상훈
* 1.0 Creation
* 2010.06.22 Lee Sang-Yong : 프로젝트 CHM-201004171  53ft(DW,DX) 추가
* 2011.11.21 김종준 [CLT-111121290-01] R4J 패치 이후 발생한 결함 건 수정(Null dereference)
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0053ManageListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SpaceAllocationManageVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;

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
		String ctrlAcct = null;
		String for_volum = null;
		String for_hc = null;
		String for_hc45 = null;
		String for_53ft = null;
		String for_reefer = null;
		String for_weight = null;
		String load_volum = "";
		String load_hc = "";
		String load_hc45 = "";
		String load_53ft = "";
		String load_reefer = "";
		String load_weight = "";
		
		String ctrl_d2_flg = "";
		String ctrl_d4_flg = "";
		String ctrl_rd_flg = "";
		String ctrl_ecc_flg = "";
		String ctrl_loc_flg = "";
		String ctrl_dest_lvl_cd= "";
		String ctrl_usa_svc_mod_flg = "";
		String ctrl_acct_flg = "";
		
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
			hc45 = JSPUtil.getNull(viewList.get(i).getCtrl45ftHcFlg());  
			ctrl53ft = JSPUtil.getNull(viewList.get(i).getCtrl53ftFlg());
			reefer = JSPUtil.getNull(viewList.get(i).getCtrlRfFlg());
			pol = JSPUtil.getNull(viewList.get(i).getCtrlPortFlg());   
			weight = JSPUtil.getNull(viewList.get(i).getCtrlWgtFlg());
			ctrlAcct = JSPUtil.getNull(viewList.get(i).getAcctGrpCtrlFlg());
			for_volum = JSPUtil.getNull(viewList.get(i).getForVolum());
			for_hc = JSPUtil.getNull(viewList.get(i).getForHc());
			for_hc45 = JSPUtil.getNull(viewList.get(i).getForHc45());
			for_53ft = JSPUtil.getNull(viewList.get(i).getFor53ft());
			for_reefer = JSPUtil.getNull(viewList.get(i).getForReefer());
			for_weight = JSPUtil.getNull(viewList.get(i).getForWeight());
			
			ctrl_d2_flg = JSPUtil.getNull(viewList.get(i).getCtrlD2flg());
			ctrl_d4_flg = JSPUtil.getNull(viewList.get(i).getCtrlD4flg());
			ctrl_rd_flg = JSPUtil.getNull(viewList.get(i).getCtrlRdFlg());
			ctrl_ecc_flg = JSPUtil.getNull(viewList.get(i).getCtrlEccFlg());		
			ctrl_loc_flg = JSPUtil.getNull(viewList.get(i).getCtrlLocFlg());
			ctrl_dest_lvl_cd = JSPUtil.getNull(viewList.get(i).getCtrlDestLvlCd());
			ctrl_usa_svc_mod_flg = JSPUtil.getNull(viewList.get(i).getCtrlUsaSvcModFlg());
			ctrl_acct_flg = JSPUtil.getNull(viewList.get(i).getCtrlAcctFlg());
			
			sbufXML.append("	<TR>");	
			sbufXML.append("	<TD>"+rep_trd_cd+"</TD>");
			sbufXML.append("	<TD INDENT='1'>"+sub_trd_cd+"</TD>");
			sbufXML.append("	<TD>"+lane+"</TD>");
			sbufXML.append("	<TD>"+bound+"</TD>");
			sbufXML.append("	<TD>"+week+"</TD>");
			sbufXML.append("	<TD>"+vvd+"</TD>");
			sbufXML.append("	<TD>"+volume+"</TD>");
			
			sbufXML.append("	<TD>"+ctrl_d2_flg+"</TD>");
			sbufXML.append("	<TD>"+ctrl_d4_flg+"</TD>");
						
			sbufXML.append("	<TD>"+hc40+"</TD>");
			sbufXML.append("	<TD>"+hc45+"</TD>");
			sbufXML.append("	<TD>"+ctrl53ft+"</TD>");
			sbufXML.append("	<TD>"+reefer+"</TD>");
			
			sbufXML.append("	<TD>"+ctrl_rd_flg+"</TD>");
			
			sbufXML.append("	<TD>"+pol+"</TD>");
			sbufXML.append("	<TD>"+weight+"</TD>");
			
			sbufXML.append("	<TD>"+ctrl_ecc_flg+"</TD>");
			sbufXML.append("	<TD>"+ctrl_loc_flg+"</TD>");
			sbufXML.append("	<TD>"+ctrl_dest_lvl_cd+"</TD>");
			sbufXML.append("	<TD>"+ctrl_usa_svc_mod_flg+"</TD>");
			sbufXML.append("	<TD>"+ctrl_acct_flg+"</TD>");
			
			sbufXML.append("	<TD>"+ctrlAcct+"</TD>");
			
			sbufXML.append("	<TD>"+for_volum+"</TD>");
			sbufXML.append("	<TD>"+for_hc+"</TD>");
			sbufXML.append("	<TD>"+for_hc45+"</TD>");
			sbufXML.append("	<TD>"+for_53ft+"</TD>");
			sbufXML.append("	<TD>"+for_reefer+"</TD>");
			sbufXML.append("	<TD>"+for_weight+"</TD>");
			
			sbufXML.append("	<TD>"+load_volum+"</TD>");
			sbufXML.append("	<TD>"+load_hc+"</TD>");
			sbufXML.append("	<TD>"+load_hc45+"</TD>");
			sbufXML.append("	<TD>"+load_53ft+"</TD>");
			sbufXML.append("	<TD>"+load_reefer+"</TD>");
			sbufXML.append("	<TD>"+load_weight+"</TD>");
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