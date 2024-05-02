/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmSpc0047ViewAdapter.java
*@FileTitle      : Control by RHQ
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.09.07
*@LastModifier   : 한상훈
*@LastVersion    : 1.0
* 2009.09.07
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.event;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.spc.common.common.vo.ConditionVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0047DetailListVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0047MasterListVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SpaceAllocationManageVO;
import com.clt.framework.component.common.AbstractValueObject;
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
public class EsmSpc0047ViewAdapter extends ViewAdapter{
	
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
			
			List<SearchSpaceAllocation0047MasterListVO> viewList = new ArrayList<SearchSpaceAllocation0047MasterListVO>();
			viewList = spaceAllocationManageVO.getSearchSpaceAllocation0047MasterListVOs();
			
			if(viewList != null) rowCount = viewList.size();
			
			sbufXML.append("<DATA TOTAL=\""+rowCount+"\">\n");		
			if (viewList != null) {//3.1
			
				for(int i=0;i<rowCount;i++){
		
					sbufXML.append("<TR>\n");
					sbufXML.append("<TD></TD>\n");	
					sbufXML.append("<TD>"+viewList.get(i).getTrdCd()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getSubTrdCd()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getRlaneCd()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getDirCd()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getCostYr()+viewList.get(i).getCostWk()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getVvd()+"</TD>\n");
					
					sbufXML.append("<TD>"+viewList.get(i).getBsaVol()+"</TD>\n");	
					sbufXML.append("<TD>"+viewList.get(i).getBsaWgt()+"</TD>\n");	
			
					sbufXML.append("<TD>"+viewList.get(i).getLodVol()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getLodWgt()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getLodHc()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getLod45()+"</TD>\n");	
					sbufXML.append("<TD>"+viewList.get(i).getLodRf()+"</TD>\n");	
					
					sbufXML.append("<TD>"+viewList.get(i).getFdVol()+"</TD>\n");	
					sbufXML.append("<TD>"+viewList.get(i).getFdWgt()+"</TD>\n");	
			
					sbufXML.append("<TD>"+viewList.get(i).getQtaOcn()+"</TD>\n");	
					sbufXML.append("<TD>"+viewList.get(i).getQtaIpc()+"</TD>\n");	
			
					sbufXML.append("<TD>"+viewList.get(i).getFcOcnVol()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFcOcnWgt()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFcIpcVol()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFcIpcWgt()+"</TD>\n");
							
					Double bsaVol = 0.0;
					if(viewList.get(i).getBsaVol().length() > 0 ){
						bsaVol = Double.parseDouble(viewList.get(i).getBsaVol());
					}
					
					Double fcIpcVol = 0.0;
					if(viewList.get(i).getFcIpcVol().length() > 0 ){
						fcIpcVol = Double.parseDouble(viewList.get(i).getFcIpcVol());
					}
					
					Double fcOcnVol = 0.0;
					if(viewList.get(i).getFcOcnVol().length() > 0 ){
						fcOcnVol = Double.parseDouble(viewList.get(i).getFcOcnVol());
					}
					
					sbufXML.append("<TD>" + ((bsaVol == 0)?"":((viewList.get(i).getTrdCd().startsWith("I")?fcIpcVol:fcOcnVol) * 100 / bsaVol))+""+"</TD>\n");	
					sbufXML.append("<TD>"+viewList.get(i).getEpVol()+"</TD>\n");
			
					sbufXML.append("<TD>"+viewList.get(i).getAlOcnVol()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getAlOcnWgt()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getAlIpcVol()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getAlIpcWgt()+"</TD>\n");
			
					sbufXML.append("<TD>"+viewList.get(i).getBkgOcnVol()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkgOcnWgt()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkgIpcVol()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkgIpcWgt()+"</TD>\n");
			
					sbufXML.append("<TD CALCU-LOGIC=\"|lod_vol|-|").append(viewList.get(i).getTrdCd().startsWith("I")?"alloc_ipc_vol":"alloc_ocn_vol").append("|\"></TD>\n");
					sbufXML.append("<TD CALCU-LOGIC=\"|lod_wgt|-|").append(viewList.get(i).getTrdCd().startsWith("I")?"alloc_ipc_wgt":"alloc_ocn_wgt").append("|\"></TD>\n");
					
					sbufXML.append("<TD>"+viewList.get(i).getVslCd()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getSkdVoyNo()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getSkdDirCd()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getCtrlSpcFlg()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getCtrlPortFlg()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getCtrl40ftHcFlg()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getCtrl45ftHcFlg()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getCtrl53ftFlg()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getCtrlRfFlg()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getCtrlWgtFlg()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getIbflag()+"</TD>\n");
					sbufXML.append("<TD></TD>\n");
					
					sbufXML.append("<TD>"+viewList.get(i).getMtyGnte()+"</TD>\n");
					sbufXML.append("</TR>\n");
			
				}//4.9
			}//3.9
			
			sbufXML.append("</DATA>\n");
	
		}
		else if( spaceAllocationManageVO.getEventCommend().equals("SEARCHLIST02")){	//2.1
			
			List<SearchSpaceAllocation0047DetailListVO> detailList = new ArrayList<SearchSpaceAllocation0047DetailListVO>();
			detailList = spaceAllocationManageVO.getSearchSpaceAllocation0047DetailListVOs();
			
			if(detailList != null) rowCount = detailList.size();			
			
			ConditionVO conditionVO = spaceAllocationManageVO.getConditionVO();
			List<DBRowSet> dbRowSet = spaceAllocationManageVO.getRsList();
			
			DBRowSet rsEtc = dbRowSet.get(0);
			
			boolean controlVl = false;
			String controlPort = "";
			boolean controlHC = false;
			boolean control45 = false;
			boolean control53 = false;
			boolean controlRF = false;
			boolean controlWGT = false;
			
			try{
				if(rsEtc != null && rsEtc.next()){
					controlVl = rsEtc.getString("volume").equals("Y");
					controlPort = rsEtc.getString("pol_pod");
					controlHC = rsEtc.getString("hc40").equals("Y");
					control45 = rsEtc.getString("hc45").equals("Y");
					control53 = rsEtc.getString("hc53").equals("Y");
					controlRF = rsEtc.getString("reefer").equals("Y");
					controlWGT = rsEtc.getString("weight").equals("Y");
				}
				
				sbufXML.append("<DATA TOTAL=\""+rowCount+"\">\n");
				String rlane = conditionVO.getLane();
				String dir = conditionVO.getBound();
				String vvd = conditionVO.getVvd();
				String vsl_cd = vvd.substring(0, 4);
				String voy_no = vvd.substring(4, 8);
				String dir_cd = vvd.substring(8);
				String office = conditionVO.getOffice();
				String pol, pod;
				String oip;
				int lvl = 0;
				int lvl1Row = 0;
				int lvl2Row = 0;
				String vOffice = "";
				String editColor = "";
				boolean tsEdit = true;
				boolean past = false;
				boolean cfm_flg = false;
				String[] lvl_cds = {"", "O", "L", "D"};
				String editRow = "FALSE";
				for(int i=0;i<rowCount;i++){//4.1
					pol = detailList.get(i).getPolCd();
					pod = detailList.get(i).getPodCd();
					lvl = pol.equals("+")?1:(pod.equals("+")?2:3);
					oip = detailList.get(i).getIocCd();
					vOffice = detailList.get(i).getOfcCd();
					if(vOffice.equals("NULL")){
						vOffice = "";
					}
					tsEdit = detailList.get(i).getEdit().equals("Y");
					past = detailList.get(i).getPast().equals("Y");
					cfm_flg = detailList.get(i).getCfmFlg().equals("Y");
					if(lvl == 1){
						lvl1Row = -1;
					}
					if(lvl == 2){
						lvl2Row = -1;
					}
					lvl1Row = lvl1Row + 1;
					lvl2Row = lvl2Row + 1;
					
					int childCnt = 0;
					if(!(oip.startsWith("EQ")||vOffice.equals("+"))){
						editRow = String.valueOf(controlPort.equals(lvl_cds[lvl]));
						switch(lvl){
						case 1:
							editRow = String.valueOf(!oip.startsWith("T-")&&controlPort.equals("O"));
							break;
						case 2:
							editRow = String.valueOf(!oip.startsWith("T-")&&controlPort.equals("L"));
							break;
						case 3:
							editRow = String.valueOf(oip.startsWith("T-")||controlPort.equals("D"));
							break;
						}
						
						if(detailList.get(i).getChildCnt().length() > 0) childCnt = Integer.parseInt(detailList.get(i).getChildCnt());
						
						if(childCnt <= 0){
							editRow = "FALSE";
						}
					}
					else{
						editRow = "FALSE";
					}
					editRow = editRow.toUpperCase();
	
					sbufXML.append("<TR LEVEL=\""+lvl+"\" \n");
					sbufXML.append("EDIT=\""+editRow+"\"\n");
					sbufXML.append(">\n");
					sbufXML.append("<TD>"+oip+"</TD>\n");
					if(vOffice.equals("+")){
					sbufXML.append("<TD></TD>\n");
					sbufXML.append("<TD></TD>\n");
					sbufXML.append("<TD></TD>\n");
					sbufXML.append("<TD></TD>\n");
					sbufXML.append("<TD></TD>\n");
					}else{
					sbufXML.append("<TD>"+detailList.get(i).getRhqCd()+"</TD>\n");
					sbufXML.append("<TD>"+vOffice+"</TD>\n");
					sbufXML.append("<TD").append((lvl==1)?" DATA-TYPE=\"dtImage\"":"").append(">").append((lvl<1)?(""):((lvl==1)?(childCnt>0?("LD".indexOf(controlPort)>=0?"1":"0"):"-1"):pol)).append("</TD>\n");
					sbufXML.append("<TD").append((lvl==2)?" DATA-TYPE=\"dtImage\"":"").append(">").append((lvl<=1)?(""):((lvl==2)?(childCnt>0?("D".indexOf(controlPort)>=0?"1":"0"):"-1"):pod)).append("</TD>\n");
					
					
					sbufXML.append("<TD></TD>\n");
					}
					sbufXML.append("<TD>"+detailList.get(i).getBkgQuota()+"</TD>\n");
					sbufXML.append("<TD>"+detailList.get(i).getCmb()+"</TD>\n");
					sbufXML.append("<TD>"+detailList.get(i).getFctCmb()+"</TD>\n");
	
					sbufXML.append("<TD COLOR=\"").append(past?"BLUE":"").append("\">"+detailList.get(i).getFcTtlTeu()+"</TD>\n");
					sbufXML.append("<TD COLOR=\"").append(past?"BLUE":"").append("\">"+detailList.get(i).getFcTeu()+"</TD>\n");
					sbufXML.append("<TD>"+detailList.get(i).getFcHc()+"</TD>\n");
					sbufXML.append("<TD>"+detailList.get(i).getFc45()+"</TD>\n");
					sbufXML.append("<TD>"+detailList.get(i).getFc53()+"</TD>\n");
					sbufXML.append("<TD>"+detailList.get(i).getFcRf()+"</TD>\n");
					sbufXML.append("<TD>"+detailList.get(i).getFcWgt()+"</TD>\n");
	
		
					editColor = !vOffice.equals("+")&&(lvl==0||lvl==1)&&cfm_flg?"BLUE":"";
		
					sbufXML.append("<TD COLOR=\""+editColor+"\">"+detailList.get(i).getUgTeu()+"</TD>\n");
					sbufXML.append("<TD COLOR=\""+editColor+"\">"+detailList.get(i).getUgHc()+"</TD>\n");
					sbufXML.append("<TD COLOR=\""+editColor+"\">"+detailList.get(i).getUg45()+"</TD>\n");
					sbufXML.append("<TD COLOR=\""+editColor+"\">"+detailList.get(i).getUg53()+"</TD>\n");
					sbufXML.append("<TD COLOR=\""+editColor+"\">"+detailList.get(i).getUgRf()+"</TD>\n");
					sbufXML.append("<TD COLOR=\""+editColor+"\">"+detailList.get(i).getUgWgt()+"</TD>\n");
	
					sbufXML.append("<TD>"+detailList.get(i).getMrTeu()+"</TD>\n");
					sbufXML.append("<TD>"+detailList.get(i).getMrHc()+"</TD>\n");
					sbufXML.append("<TD>"+detailList.get(i).getMr45()+"</TD>\n");
					sbufXML.append("<TD>"+detailList.get(i).getMr53()+"</TD>\n");
					sbufXML.append("<TD>"+detailList.get(i).getMrRf()+"</TD>\n");
					sbufXML.append("<TD>"+detailList.get(i).getMrWgt()+"</TD>\n");
		
					int apTeu = 0;
					int gtTeu = 0;
					if(detailList.get(i).getApTeu().length()>0) apTeu = Integer.parseInt(detailList.get(i).getApTeu());
					if(detailList.get(i).getGtTeu().length()>0) apTeu = Integer.parseInt(detailList.get(i).getGtTeu());
					editColor = (apTeu < gtTeu)?"RED":"";
					String fontType = "";
					if(!vOffice.equals("+")&&!tsEdit){
						fontType = " BOLD=\"TRUE\"";
					}
		
					sbufXML.append("<TD COLOR=\""+editColor+"\">"+detailList.get(i).getApTeu()+"</TD>\n");
					sbufXML.append("<TD COLOR=\""+editColor+"\">"+detailList.get(i).getApHc()+"</TD>\n");
					sbufXML.append("<TD COLOR=\""+editColor+"\">"+detailList.get(i).getAp45()+"</TD>\n");
					sbufXML.append("<TD COLOR=\""+editColor+"\">"+detailList.get(i).getAp53()+"</TD>\n");
					sbufXML.append("<TD COLOR=\""+editColor+"\">"+detailList.get(i).getApRf()+"</TD>\n");
					sbufXML.append("<TD COLOR=\""+editColor+"\">"+detailList.get(i).getApWgt()+"</TD>\n");
	
					sbufXML.append("<TD>"+detailList.get(i).getBkTeu()+"</TD>\n");
					sbufXML.append("<TD>"+detailList.get(i).getBk20()+"</TD>\n");
					sbufXML.append("<TD>"+detailList.get(i).getBk40()+"</TD>\n");
					sbufXML.append("<TD>"+detailList.get(i).getBkHc()+"</TD>\n");
					sbufXML.append("<TD>"+detailList.get(i).getBk45()+"</TD>\n");
					sbufXML.append("<TD>"+detailList.get(i).getBk53()+"</TD>\n");
					sbufXML.append("<TD>"+detailList.get(i).getBkRf()+"</TD>\n");
					sbufXML.append("<TD>"+detailList.get(i).getBkWgt()+"</TD>\n");
					
					sbufXML.append("<TD>"+detailList.get(i).getBtTeu()+"</TD>\n");
					sbufXML.append("<TD>"+detailList.get(i).getBt20()+"</TD>\n");
					sbufXML.append("<TD>"+detailList.get(i).getBt40()+"</TD>\n");
					sbufXML.append("<TD>"+detailList.get(i).getBtHc()+"</TD>\n");
					sbufXML.append("<TD>"+detailList.get(i).getBt45()+"</TD>\n");
					sbufXML.append("<TD>"+detailList.get(i).getBt53()+"</TD>\n");
					sbufXML.append("<TD>"+detailList.get(i).getBtRf()+"</TD>\n");
					sbufXML.append("<TD>"+detailList.get(i).getBtWgt()+"</TD>\n");
	
					sbufXML.append("<TD>"+detailList.get(i).getGtTeu()+"</TD>\n");
					sbufXML.append("<TD>"+detailList.get(i).getGtHc()+"</TD>\n");
					sbufXML.append("<TD>"+detailList.get(i).getGt45()+"</TD>\n");
					sbufXML.append("<TD>"+detailList.get(i).getGt53()+"</TD>\n");
					sbufXML.append("<TD>"+detailList.get(i).getGtRf()+"</TD>\n");
					sbufXML.append("<TD>"+detailList.get(i).getGtWgt()+"</TD>\n");
	
					sbufXML.append("<TD>"+detailList.get(i).getApTeu()+"</TD>\n");
					sbufXML.append("<TD>"+detailList.get(i).getApHc()+"</TD>\n");
					sbufXML.append("<TD>"+detailList.get(i).getAp45()+"</TD>\n");
					sbufXML.append("<TD>"+detailList.get(i).getAp53()+"</TD>\n");
					sbufXML.append("<TD>"+detailList.get(i).getApRf()+"</TD>\n");
					sbufXML.append("<TD>"+detailList.get(i).getApWgt()+"</TD>\n");
	
					sbufXML.append("<TD>").append((lvl<2)?"R":(detailList.get(i).getApMd().equals("0")?"I":"R")).append("</TD>\n");
					sbufXML.append("<TD></TD>\n");
	
					sbufXML.append("<TD>"+rlane+"</TD>\n");
					sbufXML.append("<TD>"+dir+"</TD>\n");
					sbufXML.append("<TD>"+vsl_cd+"</TD>\n");
					sbufXML.append("<TD>"+voy_no+"</TD>\n");
					sbufXML.append("<TD>"+dir_cd+"</TD>\n");
					sbufXML.append("<TD>").append((oip.indexOf("T/S")>=0)?"Y":"N").append("</TD>\n");
					sbufXML.append("<TD>").append(oip.startsWith("T-")?"Y":"N").append("</TD>\n");
					sbufXML.append("<TD>"+office+"</TD>\n");
					sbufXML.append("<TD>"+lvl1Row+"</TD>\n");
					sbufXML.append("<TD>"+lvl2Row+"</TD>\n");
					sbufXML.append("<TD>"+detailList.get(i).getChildCnt()+"</TD>\n");
					sbufXML.append("<TD>"+detailList.get(i).getLeafCnt()+"</TD>\n");
					sbufXML.append("<TD>"+detailList.get(i).getPodCnt()+"</TD>\n");
					sbufXML.append("<TD>").append(vOffice.equals("+")?0:lvl).append("</TD>\n");
					sbufXML.append("<TD>").append((!vOffice.equals("+")&&!tsEdit)?"Y":"").append("</TD>\n");
					sbufXML.append("<TD>"+detailList.get(i).getTrdCd()+"</TD>\n");
					sbufXML.append("<TD>"+detailList.get(i).getSubTrdCd()+"</TD>\n");
					sbufXML.append("<TD><![CDATA["+detailList.get(i).getSpcCtrlAlocRmk()+"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+detailList.get(i).getSpcCtrlAlocPolRmk()+"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+detailList.get(i).getSpcCtrlAlocPodRmk()+"]]></TD>\n");
					sbufXML.append("</TR>\n");
				
				}//4.9
			
				sbufXML.append("</DATA>\n");
				sbufXML.append("<ETC-DATA>\n");
					sbufXML.append("<ETC KEY=\"volume\">").append(controlVl?"Y":"N").append("</ETC>\n");
					sbufXML.append("<ETC KEY=\"pol_pod\">"+controlPort+"</ETC>\n");
					sbufXML.append("<ETC KEY=\"hc40\">").append(controlHC?"Y":"N").append("</ETC>\n");
					sbufXML.append("<ETC KEY=\"hc45\">").append(control45?"Y":"N").append("</ETC>\n");
					sbufXML.append("<ETC KEY=\"53ft\">").append(control53?"Y":"N").append("</ETC>\n");
					sbufXML.append("<ETC KEY=\"reefer\">").append(controlRF?"Y":"N").append("</ETC>\n");
					sbufXML.append("<ETC KEY=\"weight\">").append(controlWGT?"Y":"N").append("</ETC>\n");
				sbufXML.append("</ETC-DATA>\n");
			}catch(SQLException ex){
				throw new RuntimeException(ex.getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new RuntimeException(ex.getMessage());
			}
			
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