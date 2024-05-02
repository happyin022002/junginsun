/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName       : EsmSpc0044ViewAdapter.java
 *@FileTitle      : Allocation Control by Main Office
 *Open Issues     :
 *Change history  :
 *@LastModifyDate : 2009.09.16
 *@LastModifier   : 한상훈
 *@LastVersion    : 1.0
 * 2009.09.16
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.event;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.spc.common.common.vo.ConditionVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0044DetailListVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0044MasterListVO;
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
public class EsmSpc0044ViewAdapter extends ViewAdapter { 

	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos
	 *            List<AbstractValueObject> List 객체
	 * @param colOrder
	 *            String[] Column명 문자열
	 * @param prefix
	 *            String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception
	 */
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
		StringBuilder sbufXML = new StringBuilder();

		SpaceAllocationManageVO spaceAllocationManageVO = (SpaceAllocationManageVO) vos.get(0);

		int rowCount = 0;
		if (spaceAllocationManageVO.getEventCommend().equals("SEARCHLIST01")) { // 2.1

			List<SearchSpaceAllocation0044MasterListVO> viewList = new ArrayList<SearchSpaceAllocation0044MasterListVO>();
			viewList = spaceAllocationManageVO.getSearchSpaceAllocation0044MasterListVOs();

			if (viewList != null)
				rowCount = viewList.size();

			sbufXML.append("<DATA TOTAL=\"" + rowCount + "\">\n");
			if (viewList != null) {// 3.1

				for (int i = 0; i < rowCount; i++) {

					sbufXML.append("<TR>\n");
					sbufXML.append("<TD></TD>\n");
					sbufXML.append("<TD>" + viewList.get(i).getTrdCd() + "</TD>\n");
					sbufXML.append("<TD>" + viewList.get(i).getSubTrdCd() + "</TD>\n");
					sbufXML.append("<TD>" + viewList.get(i).getRlaneCd() + "</TD>\n");
					sbufXML.append("<TD>" + viewList.get(i).getDirCd() + "</TD>\n");
					sbufXML.append("<TD>" + viewList.get(i).getCostWk() + "</TD>\n");
					sbufXML.append("<TD>" + viewList.get(i).getVvd() + "</TD>\n");

					sbufXML.append("<TD>" + viewList.get(i).getAdVol() + "</TD>\n");
					sbufXML.append("<TD>" + viewList.get(i).getAdWgt() + "</TD>\n");
					sbufXML.append("<TD>" + viewList.get(i).getTsVol() + "</TD>\n");
					sbufXML.append("<TD>" + viewList.get(i).getTsWgt() + "</TD>\n");

					sbufXML.append("<TD>" + viewList.get(i).getQtaVol() + "</TD>\n");
					sbufXML.append("<TD>" + viewList.get(i).getQtaCmb() + "</TD>\n");

					sbufXML.append("<TD>" + viewList.get(i).getFcVol() + "</TD>\n");
					sbufXML.append("<TD>" + viewList.get(i).getFcWgt() + "</TD>\n");
					sbufXML.append("<TD>" + viewList.get(i).getFcTsVol() + "</TD>\n");
					sbufXML.append("<TD>" + viewList.get(i).getFcTsWgt() + "</TD>\n");

					sbufXML.append("<TD>" + viewList.get(i).getApVol() + "</TD>\n");
					sbufXML.append("<TD>" + viewList.get(i).getApWgt() + "</TD>\n");
					sbufXML.append("<TD>" + viewList.get(i).getApTsVol() + "</TD>\n");
					sbufXML.append("<TD>" + viewList.get(i).getApTsWgt() + "</TD>\n");

					sbufXML.append("<TD>" + viewList.get(i).getBkgVol() + "</TD>\n");
					sbufXML.append("<TD>" + viewList.get(i).getBkgWgt() + "</TD>\n");
					sbufXML.append("<TD>" + viewList.get(i).getBkgTsVol() + "</TD>");
					sbufXML.append("<TD>" + viewList.get(i).getBkgTsWgt() + "</TD>");

					// sbufXML.append("<TD></TD>\n");
					if ((getNull(viewList.get(i).getTrdCd()).startsWith("I"))) {
						sbufXML.append("	<TD CALCU-LOGIC=\"|alloced_vol|+|alloced_ts_vol|-|alloc_vol|-|alloc_ts_vol" + "|\"></TD>\n");
					} else {
						sbufXML.append("	<TD CALCU-LOGIC=\"|alloced_vol|-|alloc_vol" + "|\"></TD>\n");
					}
					sbufXML.append("<TD>" + viewList.get(i).getVslCd() + "</TD>\n");
					sbufXML.append("<TD>" + viewList.get(i).getSkdVoyNo() + "</TD>\n");
					sbufXML.append("<TD>" + viewList.get(i).getSkdDirCd() + "</TD>\n");
					sbufXML.append("<TD>" + viewList.get(i).getCtrlSpcFlg() + "</TD>\n");
					sbufXML.append("<TD>" + viewList.get(i).getCtrlPortFlg() + "</TD>\n");
					sbufXML.append("<TD>" + viewList.get(i).getCtrl40ftHcFlg() + "</TD>\n");
					sbufXML.append("<TD>" + viewList.get(i).getCtrl45ftHcFlg() + "</TD>\n");
					sbufXML.append("<TD>" + viewList.get(i).getCtrl53ftFlg() + "</TD>\n");
					sbufXML.append("<TD>" + viewList.get(i).getCtrlRfFlg() + "</TD>\n");
					sbufXML.append("<TD>" + viewList.get(i).getCtrlWgtFlg() + "</TD>\n");
					sbufXML.append("<TD>" + viewList.get(i).getIbflag() + "</TD>\n");
					sbufXML.append("</TR>\n");

				}// 4.9
			}// 3.9

			sbufXML.append("</DATA>\n");

		} else if (spaceAllocationManageVO.getEventCommend().equals("SEARCHLIST02")) { // 2.1

			List<SearchSpaceAllocation0044DetailListVO> detailList = new ArrayList<SearchSpaceAllocation0044DetailListVO>();
			detailList = spaceAllocationManageVO.getSearchSpaceAllocation0044DetailListVOs();
			if (detailList != null)
				rowCount = detailList.size();

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

			try {
				if (rsEtc != null && rsEtc.next()) {
					controlVl = rsEtc.getString("volume").equals("Y");
					controlPort = rsEtc.getString("pol_pod");
					controlHC = rsEtc.getString("hc40").equals("Y");
					control45 = rsEtc.getString("hc45").equals("Y");
					control53 = rsEtc.getString("hc53").equals("Y");
					controlRF = rsEtc.getString("reefer").equals("Y");
					controlWGT = rsEtc.getString("weight").equals("Y");
				}

				sbufXML.append("<DATA TOTAL=\"" + rowCount + "\">\n");

				String trade = conditionVO.getTrade();
				String subTrade = conditionVO.getSubtrade();
				String rlane = conditionVO.getLane();
				String dir = conditionVO.getBound();
				String vvd = conditionVO.getVvd();
				String vsl_cd = vvd.substring(0, 4);
				String voy_no = vvd.substring(4, 8);
				String dir_cd = vvd.substring(8);
				String office = conditionVO.getOffice();
				String pol, pod;
				String oip;
				String bfoip = "";								//20160120.ADD
				String bfoffice = "";							//20160120.ADD				
				int lvl = 0;
				int lvl1Row = 0;
				int lvl2Row = 0;
				String vOffice = "";
				String editColor = "";
				boolean tsEdit = true;
				boolean cfm_flg = false;
				String editRow = "FALSE";
				for (int i = 0; i < rowCount; i++) { // 4.1
					pol = detailList.get(i).getPolCd();
					pod = detailList.get(i).getPodCd();
					lvl = Integer.parseInt(detailList.get(i).getLvl());
					oip = detailList.get(i).getIocCd();
					vOffice = detailList.get(i).getOfcCd();
					tsEdit = detailList.get(i).getEdit().equals("Y");
					cfm_flg = detailList.get(i).getCfmFlg().equals("Y");
					if (lvl == 1) {
						lvl1Row = -1;
					}
					if (lvl == 2) {
						lvl2Row = -1;
					}
					lvl1Row = lvl1Row + 1;
					lvl2Row = lvl2Row + 1;
					editRow = String.valueOf(detailList.get(i).getEdit().equals("1") && Integer.parseInt(detailList.get(i).getChildCnt()) > 0);
					sbufXML.append("<TR LEVEL='" + lvl + "' EDIT='" + editRow + "'>\n");					
					if (lvl == 0) {
		            	//20160118.ADD/MOD            	
		            	sbufXML.append("<TD>" + (getNull(oip).equals(bfoip)?"":oip) + "</TD>\n");
						sbufXML.append("<TD></TD>\n");							//20160120.ADD : 추가
						sbufXML.append("<TD></TD>\n");
						sbufXML.append("<TD></TD>\n");
						sbufXML.append("<TD></TD>\n");
						
						sbufXML.append("<TD>" + oip + "</TD>\n");				//20160120.MOD : 위치변경
						sbufXML.append("<TD></TD>\n");
						sbufXML.append("<TD></TD>\n");
						sbufXML.append("<TD></TD>\n");
						sbufXML.append("<TD></TD>\n");
						sbufXML.append("<TD></TD>\n");
					} else {
						//20160120.ADD : 추가,변경
						sbufXML.append("<TD>" + (getNull(oip).equals(bfoip)?"":oip) + "</TD>\n");
						sbufXML.append("<TD>" + (getNull(office).equals(bfoffice)?"":office) + "</TD>\n");
						sbufXML.append("<TD>" + (lvl<1?"":(lvl==1?vOffice:"")) + "</TD>\n");
						sbufXML.append("<TD").append((lvl == 1) ? " DATA-TYPE=\"dtImage\"" : "").append(">").append((lvl < 1) ? ("") : ((lvl == 1) ? (Integer.parseInt(detailList.get(i).getChildCnt()) > 0 ? ("LD".indexOf(controlPort) >= 0 ? "-" : "+") : "-1") : (lvl==2?pol:""))).append("</TD>\n");
						sbufXML.append("<TD").append((lvl == 2) ? " DATA-TYPE=\"dtImage\"" : "").append(">").append((lvl <= 1) ? ("") : ((lvl == 2) ? (Integer.parseInt(detailList.get(i).getChildCnt()) > 0 ? ("D".indexOf(controlPort) >= 0 ? "-" : "+") : "-1") : pod)).append("</TD>\n");
						
						sbufXML.append("<TD>" + oip + "</TD>\n");
						sbufXML.append("<TD>" + office + "</TD>\n");
						sbufXML.append("<TD>" + vOffice + "</TD>\n");
						sbufXML.append("<TD").append((lvl == 1) ? " DATA-TYPE=\"dtImage\"" : "").append(">").append((lvl < 1) ? ("") : ((lvl == 1) ? (Integer.parseInt(detailList.get(i).getChildCnt()) > 0 ? ("LD".indexOf(controlPort) >= 0 ? "-" : "+") : "-1") : pol)).append("</TD>\n");
						sbufXML.append("<TD").append((lvl == 2) ? " DATA-TYPE=\"dtImage\"" : "").append(">").append((lvl <= 1) ? ("") : ((lvl == 2) ? (Integer.parseInt(detailList.get(i).getChildCnt()) > 0 ? ("D".indexOf(controlPort) >= 0 ? "-" : "+") : "-1") : pod)).append("</TD>\n");
						sbufXML.append("<TD></TD>\n");
					}
					sbufXML.append("<TD>" + detailList.get(i).getBkgQuota() + "</TD>\n");
					sbufXML.append("<TD>" + detailList.get(i).getCmb() + "</TD>\n");
					sbufXML.append("<TD>" + detailList.get(i).getFctCmb() + "</TD>\n");

					sbufXML.append("<TD>" + detailList.get(i).getFcTtlTeu() + "</TD>\n");
					sbufXML.append("<TD>" + detailList.get(i).getFcTeu() + "</TD>\n");
					sbufXML.append("<TD>" + detailList.get(i).getFcHc() + "</TD>\n");
					sbufXML.append("<TD>" + detailList.get(i).getFc45() + "</TD>\n");
					sbufXML.append("<TD>" + detailList.get(i).getFc53() + "</TD>\n");
					sbufXML.append("<TD>" + detailList.get(i).getFcRf() + "</TD>\n");
					sbufXML.append("<TD>" + detailList.get(i).getFcWgt() + "</TD>\n");

					editColor = !vOffice.equals("+") && (lvl == 1 || lvl == 2) && cfm_flg ? "BLUE" : "";

					sbufXML.append("<TD COLOR=\"" + editColor + "\">" + detailList.get(i).getUgTeu() + "</TD>\n");
					sbufXML.append("<TD COLOR=\"" + editColor + "\">" + detailList.get(i).getUgHc() + "</TD>\n");
					sbufXML.append("<TD COLOR=\"" + editColor + "\">" + detailList.get(i).getUg45() + "</TD>\n");
					sbufXML.append("<TD COLOR=\"" + editColor + "\">" + detailList.get(i).getUg53() + "</TD>\n");
					sbufXML.append("<TD COLOR=\"" + editColor + "\">" + detailList.get(i).getUgRf() + "</TD>\n");
					sbufXML.append("<TD COLOR=\"" + editColor + "\">" + detailList.get(i).getUgWgt() + "</TD>\n");

					sbufXML.append("<TD>" + detailList.get(i).getBkTeu() + "</TD>\n");
					sbufXML.append("<TD>" + detailList.get(i).getBk20() + "</TD>\n");
					sbufXML.append("<TD>" + detailList.get(i).getBk40() + "</TD>\n");
					sbufXML.append("<TD>" + detailList.get(i).getBkHc() + "</TD>\n");
					sbufXML.append("<TD>" + detailList.get(i).getBk45() + "</TD>\n");
					sbufXML.append("<TD>" + detailList.get(i).getBk53() + "</TD>\n");
					sbufXML.append("<TD>" + detailList.get(i).getBkRf() + "</TD>\n");
					sbufXML.append("<TD>" + detailList.get(i).getBkWgt() + "</TD>\n");

					sbufXML.append("<TD>" + detailList.get(i).getBtTeu() + "</TD>\n");
					sbufXML.append("<TD>" + detailList.get(i).getBt20() + "</TD>\n");
					sbufXML.append("<TD>" + detailList.get(i).getBt40() + "</TD>\n");
					sbufXML.append("<TD>" + detailList.get(i).getBtHc() + "</TD>\n");
					sbufXML.append("<TD>" + detailList.get(i).getBt45() + "</TD>\n");
					sbufXML.append("<TD>" + detailList.get(i).getBt53() + "</TD>\n");
					sbufXML.append("<TD>" + detailList.get(i).getBtRf() + "</TD>\n");
					sbufXML.append("<TD>" + detailList.get(i).getBtWgt() + "</TD>\n");

					sbufXML.append("<TD>" + detailList.get(i).getAdTeu() + "</TD>\n");
					sbufXML.append("<TD>" + detailList.get(i).getAdHc() + "</TD>\n");
					sbufXML.append("<TD>" + detailList.get(i).getAd45() + "</TD>\n");
					sbufXML.append("<TD>" + detailList.get(i).getAd53() + "</TD>\n");
					sbufXML.append("<TD>" + detailList.get(i).getAdRf() + "</TD>\n");
					sbufXML.append("<TD>" + detailList.get(i).getAdWgt() + "</TD>\n");

					int apTeu = 0;
					int gtTeu = 0;
					if (detailList.get(i).getApTeu() != "" && detailList.get(i).getGtTeu() != "") {
						editColor = (0 > Double.compare(Double.parseDouble(detailList.get(i).getApTeu()), Double.parseDouble(detailList.get(i).getGtTeu()))) ? "RED" : "";

					} else if (detailList.get(i).getApTeu() == "" && detailList.get(i).getGtTeu() != "") {
						editColor = (0 > Double.compare(apTeu, Double.parseDouble(detailList.get(i).getGtTeu()))) ? "RED" : "";
						
					} else if (detailList.get(i).getApTeu() != "" && detailList.get(i).getGtTeu() == "") {
						editColor = (0 > Double.compare(Double.parseDouble(detailList.get(i).getApTeu()), gtTeu)) ? "RED" : "";
					}

					sbufXML.append("<TD COLOR=\"" + editColor + "\">" + detailList.get(i).getApTeu() + "</TD>\n");
					sbufXML.append("<TD COLOR=\"" + editColor + "\">" + detailList.get(i).getApHc() + "</TD>\n");
					sbufXML.append("<TD COLOR=\"" + editColor + "\">" + detailList.get(i).getAp45() + "</TD>\n");
					sbufXML.append("<TD COLOR=\"" + editColor + "\">" + detailList.get(i).getAp53() + "</TD>\n");
					sbufXML.append("<TD COLOR=\"" + editColor + "\">" + detailList.get(i).getApRf() + "</TD>\n");
					sbufXML.append("<TD COLOR=\"" + editColor + "\">" + detailList.get(i).getApWgt() + "</TD>\n");

					sbufXML.append("<TD>" + detailList.get(i).getGtTeu() + "</TD>\n");
					sbufXML.append("<TD>" + detailList.get(i).getGtHc() + "</TD>\n");
					sbufXML.append("<TD>" + detailList.get(i).getGt45() + "</TD>\n");
					sbufXML.append("<TD>" + detailList.get(i).getGt53() + "</TD>\n");
					sbufXML.append("<TD>" + detailList.get(i).getGtRf() + "</TD>\n");
					sbufXML.append("<TD>" + detailList.get(i).getGtWgt() + "</TD>\n");

					sbufXML.append("<TD>" + detailList.get(i).getApTeu() + "</TD>\n");
					sbufXML.append("<TD>" + detailList.get(i).getApHc() + "</TD>\n");
					sbufXML.append("<TD>" + detailList.get(i).getAp45() + "</TD>\n");
					sbufXML.append("<TD>" + detailList.get(i).getAp53() + "</TD>\n");
					sbufXML.append("<TD>" + detailList.get(i).getApRf() + "</TD>\n");
					sbufXML.append("<TD>" + detailList.get(i).getApWgt() + "</TD>\n");

					sbufXML.append("<TD>").append((lvl < 3) ? "R" : (detailList.get(i).getApMd().equals("0") ? "I" : "R")).append("</TD>\n");
					sbufXML.append("<TD></TD>\n");

					sbufXML.append("<TD>" + rlane + "</TD>\n");
					sbufXML.append("<TD>" + dir + "</TD>\n");
					sbufXML.append("<TD>" + vsl_cd + "</TD>\n");
					sbufXML.append("<TD>" + voy_no + "</TD>\n");
					sbufXML.append("<TD>" + dir_cd + "</TD>\n");
					sbufXML.append("<TD>").append((oip.indexOf("T/S") >= 0) ? "Y" : "N").append("</TD>\n");
					sbufXML.append("<TD>").append(oip.startsWith("T-") ? "Y" : "N").append("</TD>\n");
					sbufXML.append("<TD>" + office + "</TD>\n");
					sbufXML.append("<TD>" + lvl1Row + "</TD>\n");
					sbufXML.append("<TD>" + lvl2Row + "</TD>\n");
					sbufXML.append("<TD>" + detailList.get(i).getChildCnt() + "</TD>\n");
					sbufXML.append("<TD>" + detailList.get(i).getLeafCnt() + "</TD>\n");
					sbufXML.append("<TD>" + detailList.get(i).getPodCnt() + "</TD>\n");
					sbufXML.append("<TD>" + lvl + "</TD>\n");
					sbufXML.append("<TD>").append((!vOffice.equals("+") && !tsEdit) ? "Y" : "").append("</TD>\n");
					sbufXML.append("<TD>" + trade + "</TD>\n");
					sbufXML.append("<TD>" + subTrade + "</TD>\n");
					sbufXML.append("<TD><![CDATA[" + detailList.get(i).getSpcCtrlAlocRmk() + "]]></TD>\n");
					sbufXML.append("<TD><![CDATA[" + detailList.get(i).getSpcCtrlAlocPolRmk() + "]]></TD>\n");
					sbufXML.append("<TD><![CDATA[" + detailList.get(i).getSpcCtrlAlocPodRmk() + "]]></TD>\n");
					sbufXML.append("</TR>\n");
					
					bfoip   = oip;										//20160120.ADD
					bfoffice = getNull(office);							//20160120.ADD

				}// 4.9

				sbufXML.append("</DATA>\n");
				sbufXML.append("<ETC-DATA>\n");
				sbufXML.append("<ETC KEY=\"volume\">").append(controlVl ? "Y" : "N").append("</ETC>\n");
				sbufXML.append("<ETC KEY=\"pol_pod\">" + controlPort + "</ETC>\n");
				sbufXML.append("<ETC KEY=\"hc40\">").append(controlHC ? "Y" : "N").append("</ETC>\n");
				sbufXML.append("<ETC KEY=\"hc45\">").append(control45 ? "Y" : "N").append("</ETC>\n");
				sbufXML.append("<ETC KEY=\"53ft\">").append(control53 ? "Y" : "N").append("</ETC>\n");
				sbufXML.append("<ETC KEY=\"reefer\">").append(controlRF ? "Y" : "N").append("</ETC>\n");
				sbufXML.append("<ETC KEY=\"weight\">").append(controlWGT ? "Y" : "N").append("</ETC>\n");
				sbufXML.append("</ETC-DATA>\n");

			} catch (SQLException ex) {
				throw new RuntimeException(ex.getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new RuntimeException(ex.getMessage());
			}

		}

		return sbufXML.toString();
	}

	/**
	 * DBRowSet를 Parsing하여 <DATA>태그를 생성한다.<br>
	 * IBSheet의 prefix값이 있는 경우 COLORDER에 prefix를 붙인 column명으로 표시해 준다.<br>
	 * 
	 * @param rs
	 *            DBRowSet VO객체
	 * @param prefix
	 *            String IBSheet savename's prefix string
	 * @return String IBSheet <DATA>태그
	 * @exception
	 */
	protected String makeDataTag(DBRowSet rs, String prefix) {
		StringBuilder sb = new StringBuilder();

		return sb.toString();
	}

	/**
	 * Pivot Table용 Data tag를 생성한다.<br>
	 * 
	 * @param rs
	 *            DBRowSet VO객체
	 * @return String IBSheet <DATA>태그
	 * @exception
	 */
	protected String makePivotDataTag(DBRowSet rs) {
		StringBuilder sb = new StringBuilder();

		return sb.toString();
	}

}