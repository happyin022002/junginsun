/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmSpc0042ViewAdapter2.java
*@FileTitle      : Control by HO
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.08.17
*@LastModifier   : 최윤성
*@LastVersion    : 1.0
* 2009.08.17
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.event;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.spc.common.common.vo.ConditionVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0042DetailListVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SpaceAllocationManageVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author CHOI Yun Sung 
 * @see ViewAdapter 참조
 * @since CHOI Yun Sung
 */
public class EsmSpc0042ViewAdapter2 extends ViewAdapter {

	
	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 객체
	 * @param colOrder String[] Column명 문자열 
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception 
	 */	
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
		StringBuilder sbufXML = new StringBuilder();
		
		SpaceAllocationManageVO spaceAllocationManageVO = (SpaceAllocationManageVO)vos.get(0);
		ConditionVO conditionVO = spaceAllocationManageVO.getConditionVO();
		List<DBRowSet> dbRowSet = spaceAllocationManageVO.getRsList();
		DBRowSet rowSet1 = dbRowSet.get(0);
		
		List<SearchSpaceAllocation0042DetailListVO> searchSpaceAllocation0042DetailListVOs = spaceAllocationManageVO.getSearchSpaceAllocation0042DetailListVOs();
		
		if(searchSpaceAllocation0042DetailListVOs.size() > 0) {
			AbstractValueObject vo = (AbstractValueObject)searchSpaceAllocation0042DetailListVOs.get(0);
			
			int totCnt  = searchSpaceAllocation0042DetailListVOs.size();
			int realCnt = searchSpaceAllocation0042DetailListVOs.size();
			
			try{
				boolean controlVl   = false;
				String  controlPort = "";
				boolean controlHC   = false;
				boolean control45   = false;
				boolean control53   = false;
				boolean controlRF   = false;
				boolean controlWGT  = false;
				
				if(rowSet1 != null && rowSet1.next()){ 
					controlVl   = rowSet1.getString("volume").equals("Y");
					controlPort = rowSet1.getString("pol_pod");
					controlHC   = rowSet1.getString("hc40").equals("Y");
					control45   = rowSet1.getString("hc45").equals("Y");
					control53   = rowSet1.getString("hc53").equals("Y");
					controlRF   = rowSet1.getString("reefer").equals("Y");
					controlWGT  = rowSet1.getString("weight").equals("Y");
				}
				
				if(vo.getMaxRows()>0){
					totCnt = vo.getMaxRows();
				}
				
				String rlane  = conditionVO.getLane();
				String dir    = conditionVO.getBound();
				String vvd    = conditionVO.getVvd();
				String vsl_cd = vvd.substring(0, 4);
				String voy_no = vvd.substring(4, 8);
				String dir_cd = vvd.substring(8);
				String office = conditionVO.getOffice();
				String pol;
				String pod;
				String oip;
				String bfoip = "";								//20160118.ADD
				String bfarea_cd = "";							//20160118.ADD
				int lvl     = 0;
				int lvl1Row = 0;
				int lvl2Row = 0;
				String vOffice   = "";
				String editColor = "";
				boolean tsEdit   = true;
				boolean past     = false;
				boolean cfm_flg  = false;
				String editRow   = "FALSE";
				sbufXML.append("<DATA TOTAL='" + totCnt + "'>\n");
				
				for(int i=0;i<realCnt;i++){
					Map<String, String> colValues = searchSpaceAllocation0042DetailListVOs.get(i).getColumnValues();
					
					pol     = getNull(colValues.get("pol_cd"));
					pod     = getNull(colValues.get("pod_cd"));
					lvl     = Integer.parseInt(nullToZero(getNull(colValues.get("lvl"))));
					oip     = getNull(colValues.get("ioc_cd"));
					vOffice = getNull(colValues.get("ofc_cd"));	
					
					if(vOffice.equals("NULL")){
						vOffice = "";
					}
					
					tsEdit  = colValues.get("edit").equals("Y");
					past    = colValues.get("past").equals("Y");
					cfm_flg = colValues.get("cfm_flg").equals("Y");
					
					if(lvl == 1){
						lvl1Row = -1;
					}
					
					if(lvl == 2){
						lvl2Row = -1;
					}
					
					lvl1Row = lvl1Row + 1;
					lvl2Row = lvl2Row + 1;
					String officeBGColor = (lvl==0)?"BGCOLOR=\"245,250,255\"":"";
					String editBGColor = "BGCOLOR=\"#FFFF00\"";
					editRow   = String.valueOf(colValues.get("edit").equals("1"));
					editColor = !vOffice.equals("+")&&(lvl==1||lvl==2)&&cfm_flg?"BLUE":"";
					
					//sbufXML.append("<TR LEVEL='" + lvl+ "' EDIT='" + editRow + "'>");
					sbufXML.append("<TR EDIT='" + editRow + "'>");					
		            
		            if(lvl == 0){
		            	
		            	//20160118.ADD/MOD            	
		            	sbufXML.append("	<TD>" + (getNull(oip).equals(bfoip)?"":oip) + "</TD>");
		            	sbufXML.append("	<TD></TD>");
		            	sbufXML.append("	<TD>TTL</TD>"); 
		            	sbufXML.append("	<TD></TD>");
		            	sbufXML.append("	<TD></TD>");
		            	
		            	sbufXML.append("	<TD>" + oip + "</TD>");
		            	sbufXML.append("	<TD></TD>");
		            	sbufXML.append("	<TD>TTL</TD>"); 
		            	sbufXML.append("	<TD></TD>");
		            	sbufXML.append("	<TD></TD>");
		            	sbufXML.append("	<TD></TD>");		            	
		            } else {
		            	//20160118.ADD/MOD
		            	sbufXML.append("	<TD>" + (getNull(oip).equals(bfoip)?"":oip) + "</TD>");
		            	sbufXML.append("	<TD INDENT='1'>" + (getNull(colValues.get("area_cd")).equals(bfarea_cd)?"":getNull(colValues.get("area_cd"))) + "</TD>");
		            	sbufXML.append("	<TD INDENT='1'>" + (lvl<1?"":(lvl==1?vOffice:"")) + "</TD>");
		            	sbufXML.append("	<TD " + officeBGColor + (Integer.parseInt(nullToZero(getNull(colValues.get("pol_skip"))))==1?" COLOR=\"BLUE\"":"") + (lvl==1?" DATA-TYPE=\"dtImage\"":"") + ">" + (lvl<1?"":(lvl==1?(Integer.parseInt(nullToZero(getNull(colValues.get("child_cnt"))))>0?("LD".indexOf(controlPort)>=0?"+":"-"):""):(lvl==2?pol:""))) + "</TD>");
		            	sbufXML.append("	<TD " + officeBGColor + (Integer.parseInt(nullToZero(getNull(colValues.get("pod_skip"))))==1?" COLOR=\"BLUE\"":"") + (lvl==2?" DATA-TYPE=\"dtImage\"":"") + ">" + (lvl<=1?"":(lvl==2?(Integer.parseInt(nullToZero(getNull(colValues.get("child_cnt"))))>0?("D".indexOf(controlPort)>=0?"+":"-"):""):pod)) + "</TD>");
		            	
		            	sbufXML.append("	<TD>" + oip + "</TD>");
		            	sbufXML.append("	<TD INDENT='1'>" + getNull(colValues.get("area_cd")) + "</TD>");
		            	sbufXML.append("	<TD INDENT='1'>" + (lvl<1?"":vOffice) + "</TD>");
		            	sbufXML.append("	<TD " + officeBGColor + (Integer.parseInt(nullToZero(getNull(colValues.get("pol_skip"))))==1?" COLOR=\"BLUE\"":"") + (lvl==1?" DATA-TYPE=\"dtImage\"":"") + ">" + (lvl<1?"":(lvl==1?(Integer.parseInt(nullToZero(getNull(colValues.get("child_cnt"))))>0?("LD".indexOf(controlPort)>=0?"+":"-"):""):pol)) + "</TD>");
		            	sbufXML.append("	<TD " + officeBGColor + (Integer.parseInt(nullToZero(getNull(colValues.get("pod_skip"))))==1?" COLOR=\"BLUE\"":"") + (lvl==2?" DATA-TYPE=\"dtImage\"":"") + ">" + (lvl<=1?"":(lvl==2?(Integer.parseInt(nullToZero(getNull(colValues.get("child_cnt"))))>0?("D".indexOf(controlPort)>=0?"+":"-"):""):pod)) + "</TD>");
		            	sbufXML.append("	<TD " + officeBGColor + "></TD>");
		            }
		            sbufXML.append("	<TD " + officeBGColor + ">" + getNull(colValues.get("bkg_quota")) + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + ">" + getNull(colValues.get("cmb"))       + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + ">0</TD>");
		            
		            sbufXML.append("	<TD " + officeBGColor + " COLOR='" + (past?"BLUE":"") + "'>" + getNull(colValues.get("fc_ttl_teu")) + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + " COLOR='" + (past?"BLUE":"") + "'>" + getNull(colValues.get("fc_teu"))     + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + ">" + getNull(colValues.get("fc_hc"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + ">" + getNull(colValues.get("fc_45"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + ">" + getNull(colValues.get("fc_53"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + ">" + getNull(colValues.get("fc_rf"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + ">" + getNull(colValues.get("fc_wgt")) + "</TD>");
		            
		            sbufXML.append("	<TD " + officeBGColor + " COLOR='" + editColor + "'>" + getNull(colValues.get("ug_teu")) + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + " COLOR='" + editColor + "'>" + getNull(colValues.get("ug_hc"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + " COLOR='" + editColor + "'>" + getNull(colValues.get("ug_45"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + " COLOR='" + editColor + "'>" + getNull(colValues.get("ug_53"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + " COLOR='" + editColor + "'>" + getNull(colValues.get("ug_rf"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + " COLOR='" + editColor + "'>" + getNull(colValues.get("ug_wgt")) + "</TD>");
		            
		            sbufXML.append("	<TD " + officeBGColor + ">" + getNull(colValues.get("mr_teu")) + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + ">" + getNull(colValues.get("mr_hc"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + ">" + getNull(colValues.get("mr_45"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + ">" + getNull(colValues.get("mr_53"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + ">" + getNull(colValues.get("mr_rf"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + ">" + getNull(colValues.get("mr_wgt")) + "</TD>");
		            
		            if(colValues.get("edit").equals("1")){
			            sbufXML.append("	<TD " + (editBGColor) + " COLOR='" + (0 > Double.compare(Double.parseDouble(nullToZero(getNull(colValues.get("ap_teu")))), Double.parseDouble(nullToZero(getNull(colValues.get("gt_teu")))))?"RED":"") + "'>" + getNull(colValues.get("ap_teu")) + "</TD>"); //소스 품질 수정 요청
			            sbufXML.append("	<TD " + (editBGColor) + " COLOR='" + (Integer.parseInt(nullToZero(getNull(colValues.get("ap_hc"))))  < Integer.parseInt(nullToZero(getNull(colValues.get("gt_hc")))) ?"RED":"") + "'>" + getNull(colValues.get("ap_hc"))  + "</TD>");
			            sbufXML.append("	<TD " + (editBGColor) + " COLOR='" + (Integer.parseInt(nullToZero(getNull(colValues.get("ap_45"))))  < Integer.parseInt(nullToZero(getNull(colValues.get("gt_45")))) ?"RED":"") + "'>" + getNull(colValues.get("ap_45"))  + "</TD>");
			            sbufXML.append("	<TD " + (editBGColor) + " COLOR='" + (Integer.parseInt(nullToZero(getNull(colValues.get("ap_53"))))  < Integer.parseInt(nullToZero(getNull(colValues.get("gt_53")))) ?"RED":"") + "'>" + getNull(colValues.get("ap_53"))  + "</TD>");
			            sbufXML.append("	<TD " + (editBGColor) + " COLOR='" + (Integer.parseInt(nullToZero(getNull(colValues.get("ap_rf"))))  < Integer.parseInt(nullToZero(getNull(colValues.get("gt_rf")))) ?"RED":"") + "'>" + getNull(colValues.get("ap_rf"))  + "</TD>");
			            sbufXML.append("	<TD " + (editBGColor) + " COLOR='" + (Integer.parseInt(nullToZero(getNull(colValues.get("ap_wgt")))) < Integer.parseInt(nullToZero(getNull(colValues.get("gt_wgt"))))?"RED":"") + "'>" + getNull(colValues.get("ap_wgt")) + "</TD>");
		            } else {
			            sbufXML.append("	<TD " + (officeBGColor) + " COLOR='" + (0 > Double.compare(Double.parseDouble(nullToZero(getNull(colValues.get("ap_teu")))), Double.parseDouble(nullToZero(getNull(colValues.get("gt_teu")))))?"RED":"") + "'>" + getNull(colValues.get("ap_teu")) + "</TD>"); //소스 품질 수정 요청
			            sbufXML.append("	<TD " + (officeBGColor) + " COLOR='" + (Integer.parseInt(nullToZero(getNull(colValues.get("ap_hc"))))  < Integer.parseInt(nullToZero(getNull(colValues.get("gt_hc")))) ?"RED":"") + "'>" + getNull(colValues.get("ap_hc"))  + "</TD>");
			            sbufXML.append("	<TD " + (officeBGColor) + " COLOR='" + (Integer.parseInt(nullToZero(getNull(colValues.get("ap_45"))))  < Integer.parseInt(nullToZero(getNull(colValues.get("gt_45")))) ?"RED":"") + "'>" + getNull(colValues.get("ap_45"))  + "</TD>");
			            sbufXML.append("	<TD " + (officeBGColor) + " COLOR='" + (Integer.parseInt(nullToZero(getNull(colValues.get("ap_53"))))  < Integer.parseInt(nullToZero(getNull(colValues.get("gt_53")))) ?"RED":"") + "'>" + getNull(colValues.get("ap_53"))  + "</TD>");
			            sbufXML.append("	<TD " + (officeBGColor) + " COLOR='" + (Integer.parseInt(nullToZero(getNull(colValues.get("ap_rf"))))  < Integer.parseInt(nullToZero(getNull(colValues.get("gt_rf")))) ?"RED":"") + "'>" + getNull(colValues.get("ap_rf"))  + "</TD>");
			            sbufXML.append("	<TD " + (officeBGColor) + " COLOR='" + (Integer.parseInt(nullToZero(getNull(colValues.get("ap_wgt")))) < Integer.parseInt(nullToZero(getNull(colValues.get("gt_wgt"))))?"RED":"") + "'>" + getNull(colValues.get("ap_wgt")) + "</TD>");
		            	
		            }
		            sbufXML.append("	<TD " + officeBGColor + ">" + getNull(colValues.get("bk_teu")) + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + ">" + getNull(colValues.get("bk_20"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + ">" + getNull(colValues.get("bk_40"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + ">" + getNull(colValues.get("bk_hc"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + ">" + getNull(colValues.get("bk_45"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + ">" + getNull(colValues.get("bk_53"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + ">" + getNull(colValues.get("bk_rf"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + ">" + getNull(colValues.get("bk_wgt")) + "</TD>");
		            
		            sbufXML.append("	<TD " + officeBGColor + ">" + getNull(colValues.get("bt_teu")) + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + ">" + getNull(colValues.get("bt_20"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + ">" + getNull(colValues.get("bt_40"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + ">" + getNull(colValues.get("bt_hc"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + ">" + getNull(colValues.get("bt_45"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + ">" + getNull(colValues.get("bt_53"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + ">" + getNull(colValues.get("bt_rf"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + ">" + getNull(colValues.get("bt_wgt")) + "</TD>");
		            
		            sbufXML.append("	<TD " + officeBGColor + ">" + getNull(colValues.get("gt_teu")) + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + ">" + getNull(colValues.get("gt_hc"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + ">" + getNull(colValues.get("gt_45"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + ">" + getNull(colValues.get("gt_53"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + ">" + getNull(colValues.get("gt_rf"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + ">" + getNull(colValues.get("gt_wgt")) + "</TD>");
		            
		            sbufXML.append("	<TD>" + getNull(colValues.get("ap_teu")) + "</TD>");
		            sbufXML.append("	<TD>" + getNull(colValues.get("ap_hc"))  + "</TD>");
		            sbufXML.append("	<TD>" + getNull(colValues.get("ap_45"))  + "</TD>");
		            sbufXML.append("	<TD>" + getNull(colValues.get("ap_53"))  + "</TD>");
		            sbufXML.append("	<TD>" + getNull(colValues.get("ap_rf"))  + "</TD>");
		            sbufXML.append("	<TD>" + getNull(colValues.get("ap_wgt")) + "</TD>");
		            
		            sbufXML.append("	<TD>" + (lvl<3?"R":getNull(colValues.get("ap_md")).equals("0")?"I":"R") + "</TD>");
		            sbufXML.append("	<TD></TD>");
		            
		            sbufXML.append("	<TD>" + getNull(colValues.get("rhq_cd")) + "</TD>");
		            sbufXML.append("	<TD>" + rlane  + "</TD>");
		            sbufXML.append("	<TD>" + dir    + "</TD>");
		            sbufXML.append("	<TD>" + vsl_cd + "</TD>");
		            sbufXML.append("	<TD>" + voy_no + "</TD>");
		            sbufXML.append("	<TD>" + dir_cd + "</TD>");
		            sbufXML.append("	<TD>" + (oip.indexOf("T/S")>=0?"Y":"N") + "</TD>");
		            sbufXML.append("	<TD>" + (oip.startsWith("T-")?"Y":"N")  + "</TD>");
		            sbufXML.append("	<TD>" + office  + "</TD>");
		            sbufXML.append("	<TD>" + lvl1Row + "</TD>");
		            sbufXML.append("	<TD>" + lvl2Row + "</TD>");
		            sbufXML.append("	<TD>" + getNull(colValues.get("child_cnt")) + "</TD>");
		            sbufXML.append("	<TD>" + getNull(colValues.get("leaf_cnt"))  + "</TD>");
		            sbufXML.append("	<TD>" + getNull(colValues.get("pod_cnt"))   + "</TD>");
		            sbufXML.append("	<TD>" + lvl + "</TD>");
		            sbufXML.append("	<TD>" + (!vOffice.equals("+")&&!tsEdit?"Y":"") + "</TD>");
		            sbufXML.append("	<TD>" + getNull(colValues.get("trd_cd"))       + "</TD>");
		            sbufXML.append("	<TD>" + getNull(colValues.get("sub_trd_cd"))   + "</TD>");
		            
		            
		            if(colValues.get("edit").equals("1")){		 	           
		            	sbufXML.append("	<TD " + (editBGColor)+ " ><![CDATA[" + getNull(colValues.get("spc_ctrl_aloc_rmk"))     + "]]></TD>");
			            sbufXML.append("	<TD " + (editBGColor)+ " ><![CDATA[" + getNull(colValues.get("spc_ctrl_aloc_pol_rmk")) + "]]></TD>");
			            sbufXML.append("	<TD " + (editBGColor)+ " ><![CDATA[" + getNull(colValues.get("spc_ctrl_aloc_pod_rmk")) + "]]></TD>");
		            } else {			          
		            	sbufXML.append("	<TD " + (officeBGColor)+ " ><![CDATA[" + getNull(colValues.get("spc_ctrl_aloc_rmk"))     + "]]></TD>");
			            sbufXML.append("	<TD " + (officeBGColor)+ " ><![CDATA[" + getNull(colValues.get("spc_ctrl_aloc_pol_rmk")) + "]]></TD>");
			            sbufXML.append("	<TD " + (officeBGColor)+ " ><![CDATA[" + getNull(colValues.get("spc_ctrl_aloc_pod_rmk")) + "]]></TD>");
		            }
					sbufXML.append("</TR>\n");
					
					bfoip   = oip;										//2016018.ADD
					bfarea_cd = getNull(colValues.get("area_cd"));		//2016018.ADD
				}
				sbufXML.append("</DATA>\n");
				
			}catch(SQLException ex){
				throw new RuntimeException(ex.getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new RuntimeException(ex.getMessage());
			}
		} else {
			sbufXML.append("<DATA TOTAL='0'>\n");
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
		
		//Pivot Table인 경우 makePivotDataTag 실행하여  return한
		if(rs.isPivot()){
			sb.append(makePivotDataTag(rs));
			return sb.toString();
		}

		String[] realColNms = getColHeader(rs);

		try{
			String[] changedColNms = getChangedColNms(realColNms, prefix);
			
			sb.append("<DATA COLORDER='" + JSPUtil.convertStringArrayToString(changedColNms, "|") + "' COLSEPARATOR='" + DELIMITER + "' TOTAL='" + getRowSetCnt(rs) + "'>\n");
			
			int colCount = realColNms.length;
			
			while (rs.next()) { 
				sb.append("	<TR><![CDATA[");
				for (int j = 1 ; j < colCount ; j++) {
					sb.append(getNull(rs.getObject(j)) + DELIMITER);
				}	
				sb.append(getNull(rs.getObject(colCount))  + "]]></TR>\n");
			}
			sb.append("</DATA>\n");
		}catch(SQLException ex){
			throw new RuntimeException(ex.getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}

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
		int colCnt = 0;
		int rowCnt = rs.getRowCount();
		String[][] arrRowSet = null;

		try{
			colCnt = rs.getMetaData().getColumnCount();
			arrRowSet = new String[rowCnt][colCnt];
			
			int rowIdx = 0;
			while (rs.next()) { 
				for (int j = 1 ; j <= colCnt ; j++) {
					arrRowSet[rowIdx][j-1] = getNull(rs.getObject(j)).toString();
				}
				rowIdx++;
			}
		}catch(SQLException ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}

		
		try{
			sb.append("<DATA COLSEPARATOR='" + DELIMITER + "'>\n");
			if(rowCnt>0){
				for (int coIdx = 0 ;coIdx < colCnt ; coIdx++) {
					sb.append("	<TR><![CDATA[");
					for(int roIdx=0;roIdx < rowCnt-1; roIdx++){
						sb.append(arrRowSet[roIdx][coIdx] + DELIMITER);
					}
					sb.append(arrRowSet[rowCnt-1][coIdx]  + "]]></TR>\n");
				}//end for coIdx
			}//end for roIdx
			sb.append("</DATA>\n");
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}
		return sb.toString();
	}
	
	private String nullToZero(String str) {
		String rtnStr = ""; //소스 품질 수정 요청건
		//if(str == null || str == "") //소스 품질 수정 요청건
		if(str == null || "".equals(str)) {
			rtnStr = "0";
		} else {
			rtnStr = str;			
		}
		return rtnStr;
	}
	
	protected String getETCData(EventResponse eventResponse) {
		if(eventResponse==null) 
			return "";
		
		SpaceAllocationManageVO spaceAllocationManageVO = (SpaceAllocationManageVO)eventResponse.getRsVoList().get(0);
		List<DBRowSet> dbRowSet = spaceAllocationManageVO.getRsList();
		DBRowSet rowSet1 = dbRowSet.get(0);
		
		StringBuilder sb = new StringBuilder();
		
		try{
			boolean controlVl   = false;
			String  controlPort = "";
			boolean controlHC   = false;
			boolean control45   = false;
			boolean control53   = false;
			boolean controlRF   = false;
			boolean controlWGT  = false;
			
			if(rowSet1 != null && rowSet1.next()){
				controlVl   = rowSet1.getString("volume").equals("Y");
				controlPort = rowSet1.getString("pol_pod");
				controlHC   = rowSet1.getString("hc40").equals("Y");
				control45   = rowSet1.getString("hc45").equals("Y");
				control53   = rowSet1.getString("hc53").equals("Y");
				controlRF   = rowSet1.getString("reefer").equals("Y");
				controlWGT  = rowSet1.getString("weight").equals("Y");
			}
			
			sb.append("<ETC-DATA>\n");
			sb.append("    <ETC KEY='volume'><![CDATA["   + (controlVl?"Y":"N")  + "]]></ETC>\n");
			sb.append("    <ETC KEY='pol_pod'><![CDATA["  + controlPort          + "]]></ETC>\n");
			sb.append("    <ETC KEY='hc40'><![CDATA["     + (controlHC?"Y":"N")  + "]]></ETC>\n");
			sb.append("    <ETC KEY='hc45'><![CDATA["     + (control45?"Y":"N")  + "]]></ETC>\n");
			sb.append("    <ETC KEY='53ft'><![CDATA["     + (control53?"Y":"N")  + "]]></ETC>\n");
			sb.append("    <ETC KEY='reefer'><![CDATA["   + (controlRF?"Y":"N")  + "]]></ETC>\n");
			sb.append("    <ETC KEY='weight'><![CDATA["   + (controlWGT?"Y":"N") + "]]></ETC>\n");
			sb.append("</ETC-DATA>\n");
		}catch(SQLException ex){
			throw new RuntimeException(ex.getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}
		return sb.toString();
	} 

}