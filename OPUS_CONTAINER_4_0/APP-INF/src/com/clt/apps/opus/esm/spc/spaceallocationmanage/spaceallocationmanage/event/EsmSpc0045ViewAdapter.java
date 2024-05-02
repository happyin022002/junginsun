/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmSpc0045ViewAdapter.java
*@FileTitle      : Bottleneck Check
*Open Issues     :
*Change history  : 
*@LastModifyDate : 2009.09.16
*@LastModifier   : 한상훈
*@LastVersion    : 1.0
* 2009.09.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.event;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.spc.common.SPCUtil;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocationManage045QtyListVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocationManage045VVDListVO;
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
public class EsmSpc0045ViewAdapter extends ViewAdapter{
	
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
		if( spaceAllocationManageVO.getEventCommend().equals("SEARCHLIST01")){	//2.1
			
			List<SearchSpaceAllocationManage045VVDListVO> viewList = new ArrayList<SearchSpaceAllocationManage045VVDListVO>();
			viewList = spaceAllocationManageVO.getSearchSpaceAllocationManage045VVDListVOs();
			
			if(viewList != null) rowCount = viewList.size();
			
			sbufXML.append("<DATA TOTAL=\""+rowCount+"\">\n");	
			
			String vvds = "";
			String rel_vvds = "";
			
			StringBuffer sbVvds = new StringBuffer(); //소스 품질 수정 요청건
			StringBuffer sbRrelVvds = new StringBuffer(); //소스 품질 수정 요청건
			
			if (viewList != null) {//3.1					
				for(int i=0;i<rowCount;i++){		
					//vvds = vvds + "|" + JSPUtil.getNull(viewList.get(i).getVvd());
					//rel_vvds = rel_vvds + "|" + JSPUtil.getNull(viewList.get(i).getRelVvd());
					
					sbVvds.append("|").append(JSPUtil.getNull(viewList.get(i).getVvd())); //소스 품질 수정 요청건
					sbRrelVvds.append("|").append(JSPUtil.getNull(viewList.get(i).getRelVvd())); //소스 품질 수정 요청건		
				}//4.9			
			}//3.9
			
			vvds = sbVvds.toString(); //소스 품질 수정 요청건
			rel_vvds = sbRrelVvds.toString(); //소스 품질 수정 요청건
			
			sbufXML.append("</DATA>\n");
			sbufXML.append("<ETC-DATA>\n");
				sbufXML.append("<ETC KEY=\"vvd\">"+(vvds.length()>1?vvds.substring(1):vvds)+"</ETC>\n");
				sbufXML.append("<ETC KEY=\"relvvd\">"+(rel_vvds.length()>1?rel_vvds.substring(1):rel_vvds)+"</ETC>\n");
			sbufXML.append("</ETC-DATA>\n");
			
		}
		else if( spaceAllocationManageVO.getEventCommend().equals("SEARCHLIST02")){	//2.1
			
			List<SearchSpaceAllocationManage045QtyListVO> list1 = new ArrayList<SearchSpaceAllocationManage045QtyListVO>();
			list1 = spaceAllocationManageVO.getSearchSpaceAllocationManage045QtyListVOs();
			if(list1 != null) rowCount = list1.size();			
			
			sbufXML.append("<DATA TOTAL='"+rowCount+"'>\n");
		
				if (list1 != null) {//3.1
					String[] bgcolors = {SPCUtil.getColor(0), SPCUtil.getColor(1), "", SPCUtil.getColor(2)};
					String bgcolor = "";
					String ioc_cd = "";
					String src_cd = "";
					String old_src_cd = "";
					int flg = 0;
					int level = 1;
					
					for(int i=0;i<rowCount;i++){//while (rowSet.next()) {//4.1
						src_cd = JSPUtil.getNull(list1.get(i).getSrc());
						ioc_cd = JSPUtil.getNull(list1.get(i).getIocCd());
						flg = Integer.parseInt(list1.get(i).getFlg());
						if(src_cd.equals(old_src_cd)){
							level = 2;
						}
						else{
							level = 1;
						}
						bgcolor = ioc_cd.equals("TOTAL")?bgcolors[0]:"";
		
			sbufXML.append("<TR LEVEL='"+level+"' COLOR='"+(JSPUtil.getNull(list1.get(i).getPast()).equals("Y")?"70,70,200":"")+"'>\n");
			sbufXML.append("<TD BGCOLOR='"+bgcolors[flg]+"'>"+JSPUtil.getNull(list1.get(i).getPortCd())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(list1.get(i).getBsa())+"</TD>\n");
			sbufXML.append("<TD BGCOLOR='"+bgcolor+"'>"+ioc_cd+"</TD>\n");
					
			sbufXML.append("<TD BGCOLOR='"+bgcolor+"'>"+JSPUtil.getNull(list1.get(i).getLodTtl())+"</TD>\n");
			sbufXML.append("<TD BGCOLOR='"+bgcolor+"'>"+JSPUtil.getNull(list1.get(i).getDisTtl())+"</TD>\n");
			sbufXML.append("<TD BGCOLOR='"+bgcolor+"'>"+JSPUtil.getNull(list1.get(i).getOnTtl())+"</TD>\n");
					
			sbufXML.append("<TD BGCOLOR='"+bgcolor+"'></TD>\n");
			sbufXML.append("<TD>"+src_cd+"</TD>\n");
			sbufXML.append("</TR>\n");
		
						old_src_cd = src_cd;
					}//4.9 while
				}//3.9 rs
			
			sbufXML.append("</DATA>\n");
			sbufXML.append("</SHEET>\n");

			sbufXML.append("	[+]		\n");

			SpaceAllocationManageVO spaceAllocationManageVO2 = (SpaceAllocationManageVO)vos.get(1);
			List<SearchSpaceAllocationManage045QtyListVO> list2 = new ArrayList<SearchSpaceAllocationManage045QtyListVO>();
			list2 = spaceAllocationManageVO2.getSearchSpaceAllocationManage045QtyListVOs();
			if(list2 != null) rowCount = list2.size();	
		
			sbufXML.append("<SHEET>\n");
			sbufXML.append("<DATA TOTAL='"+rowCount+"'>\n");
		
				if (list2 != null) {//3.1
					String[] bgcolors = {SPCUtil.getColor(0), SPCUtil.getColor(1), "", SPCUtil.getColor(2)};
					String bgcolor = "";
					String ioc_cd = "";
					String src_cd = "";
					String old_src_cd = "";
					int flg = 0;
					int level = 1;
					
					for(int i=0;i<rowCount;i++){//while (rowSet.next()) {//4.1
						src_cd = JSPUtil.getNull(list2.get(i).getSrc());
						ioc_cd = JSPUtil.getNull(list2.get(i).getIocCd());
						flg = Integer.parseInt(list2.get(i).getFlg());
						if(src_cd.equals(old_src_cd)){
							level = 2;
						}
						else{
							level = 1;
						}
						bgcolor = ioc_cd.equals("TOTAL")?bgcolors[0]:"";
		
			sbufXML.append("<TR LEVEL='"+level+"' COLOR='"+(JSPUtil.getNull(list2.get(i).getPast()).equals("Y")?"70,70,200":"")+"'>\n");
			sbufXML.append("<TD BGCOLOR='"+bgcolors[flg]+"'>"+JSPUtil.getNull(list2.get(i).getPortCd())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(list2.get(i).getBsa())+"</TD>\n");
			sbufXML.append("<TD BGCOLOR='"+bgcolor+"'>"+ioc_cd+"</TD>\n");
					
			sbufXML.append("<TD BGCOLOR='"+bgcolor+"'>"+JSPUtil.getNull(list2.get(i).getLodTtl())+"</TD>\n");
			sbufXML.append("<TD BGCOLOR='"+bgcolor+"'>"+JSPUtil.getNull(list2.get(i).getDisTtl())+"</TD>\n");
			sbufXML.append("<TD BGCOLOR='"+bgcolor+"'>"+JSPUtil.getNull(list2.get(i).getOnTtl())+"</TD>\n");
					
			sbufXML.append("<TD BGCOLOR='"+bgcolor+"'></TD>\n");
			sbufXML.append("<TD>"+src_cd+"</TD>\n");
			sbufXML.append("</TR>\n");
		
						old_src_cd = src_cd;
					}//4.9 while
				}//3.9 rs
			
			sbufXML.append("</DATA>\n");
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