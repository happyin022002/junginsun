/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0103_01ViewAdapter.java
 *@FileTitle : Booking Status Report AWKWARD
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.03.08
 *@LastModifier : 이일민
 *@LastVersion : 1.0
 * 2010.03.08 이일민
 * 1.0 Creation 
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Kim Gyoung Sub
 * @see ViewAdapter 참조
 * @since J2EE 1.6
 */
public class EsmBkg027801ViewAdapter extends ViewAdapter {

	private String getStartTag(boolean isFirstSheet, boolean isSave, GeneralEventResponse eventResponse) throws Exception {
		StringBuilder sb = new StringBuilder();
		if (isFirstSheet) {
			if (isSave) {
				sb.append("<RESULT>\n");
				sb.append("<TR-ALL>OK</TR-ALL>\n");
			} else {
				sb.append("<SHEET>\n");
			}
			sb.append(getETCData(eventResponse));
			sb.append(getUserMessageXML(eventResponse));
		} else {
			sb.append("|$$|<SHEET>\n");
		}
		return sb.toString();
	}

	private String getEndTag(StringBuilder sb) {
		String endTag = "";
		String tmp = sb.toString();
		int sheetLoc = tmp.lastIndexOf("<SHEET>");
		int resultLoc = tmp.lastIndexOf("<RESULT>");
		if (sheetLoc > resultLoc)
			endTag = "</SHEET>\n";
		else
			endTag = "</RESULT>\n";
		return endTag;
	}

	@SuppressWarnings("unchecked")
	private String makeSuccessXML(boolean isUpload, HttpServletRequest request, GeneralEventResponse eventResponse) throws Exception {
		Event event = (Event) request.getAttribute("Event");
		boolean isSave = isSaveCommand(event);
		StringBuilder sb = new StringBuilder();
		List rsVoList = eventResponse.getRsVoList();

		boolean isFirstSheet = true;
		String prefixs[] = getPrefixFromHttp(request);
		List dataCntList = eventResponse.getDataCntList();
		if (isUpload) {
			sb.append("<pre>\n");
		}
		int setExeCnt = dataCntList.size();
		Iterator it = rsVoList.iterator();
		List list = new ArrayList();
		List tmpList = null;
		int curLoc = 0;
		for (int i = 0; i<setExeCnt; i++) {
			int voCnt = ((Integer) dataCntList.get(i)).intValue();
			if (0==voCnt) {
				sb.append(getStartTag(isFirstSheet, isSave, eventResponse));
				sb.append("\t<DATA  TOTAL='0'>\n");
				sb.append("\t</DATA>\n");
				sb.append(getEndTag(sb));
				isFirstSheet = false;
			} else if (rsVoList.get(curLoc) instanceof DBRowSet) {
				sb.append(getStartTag(isFirstSheet, isSave, eventResponse));
				sb.append(makeDataTag((DBRowSet) it.next(), prefixs[i]));
				sb.append(getEndTag(sb));
				curLoc++;
				isFirstSheet = false;
			} else {
				tmpList = new ArrayList();
				for (int j = 0; j < voCnt; j++) {
					Object obj = it.next();
					tmpList.add(obj);
					curLoc++;
				}
				list.add(tmpList);
				isFirstSheet = false;
			}
		}
		sb.append(makeDataTag(list, prefixs[0]));
		removeListAllElements(tmpList);
		if (isUpload) {
			sb.append("</pre>\n");
		}
		return sb.toString();
	}

	/**
	 * makeXML
	 * 
	 * @param HttpServletRequest request
	 * @param HttpServletResponse response
	 * @return String
	 */
	public String makeXML(HttpServletRequest request, HttpServletResponse response) {
		GeneralEventResponse eventResponse = null;
		Exception serverException = null;
		String strXML = "";
		boolean isupload = isUploadFile(request);
		try {
			serverException = (Exception) request.getAttribute("com.clt.framework.core.comm.EXCEPTION_OBJECT");
			if (null!=serverException) {
				strXML = getErrorXML((new ErrorHandler(serverException)).loadPopupMessage(), isupload);
			} else {
				boolean isUpload = isUploadFile(request);
				eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
				if (null!=eventResponse) {
					if (2>eventResponse.getDataCntList().size() || 0==((Integer) eventResponse.getDataCntList().get(1)).intValue()) {
						strXML = "<SHEET> <ETC-DATA> </ETC-DATA> 	<DATA  TOTAL='0'> 	</DATA> </SHEET>|$$|<SHEET> <ETC-DATA> </ETC-DATA> 	<DATA  TOTAL='0'> 	</DATA> </SHEET>";
					} else {
						strXML = makeSuccessXML(isUpload, request, eventResponse);
					}
				}
			}
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			strXML = getErrorXML((new ErrorHandler(ex)).loadPopupMessage(), isupload);
		}
		//if (log.isDebugEnabled()) {
			//log.debug((new StringBuilder("\n")).append(strXML).toString());
		//}
		return strXML;
	}

	private boolean isUploadFile(HttpServletRequest request) {
		boolean isUpload = false;
		String contentType = request.getContentType();
		if (contentType != null
				&& contentType.startsWith("multipart/form-data"))
			isUpload = true;
		return isUpload;
	}

	private String replaceSortText(Map<String,String> cds,String text) {
		String sep1 = " / ";
		String sep2 = " : ";
		String[] cols = null;
		String[] cods = null;
		StringBuilder sb = new StringBuilder();
		if (!"".equalsIgnoreCase(text)) {
			cols = text.split(sep1);
			if (null!=cols && 0<cols.length) {
				for (String str : cols) {
					if (!"".equalsIgnoreCase(str)) {
						cods = str.split(sep2);
						if (null!=cods) {
							//sb.append(cds.get(cods[0]));  //intg_cd_val_desc
							sb.append(cods[0]);  //intg_cd_val_dp_desc
							sb.append(sep2);
							if (2==cods.length) {
								sb.append(cods[1]);
							}
						}
					}
					if (sb.length()!=sb.lastIndexOf(sep1)+sep1.length()) {
						sb.append(sep1);
					}
				}
				if (0<=sb.indexOf(sep1)) {
					sb.delete(sb.lastIndexOf(sep1), sb.length());
				}
			} else {
				sb.append(text);
			}
		}
		return sb.toString();
	}

	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 객체
	 * @param colOrder String[] Column명 문자열
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception
	 */
	@SuppressWarnings("unchecked")
	protected String makeDataTag(List list, String prefix) {
		List<AbstractValueObject> cds = (List)list.get(0);
		Map<String,String> orderbyTitleMap = new HashMap<String,String>();
		if (null!=cds && 0<cds.size()) {
			for (AbstractValueObject vo : cds) {
				vo = (BkgComboVO)vo;
				orderbyTitleMap.put(vo.getColumnValues().get("name"),vo.getColumnValues().get("desc"));
			}
		}
		StringBuilder sbufXML = new StringBuilder();
		Map<String, String> colValues = null;
		String orderByTemp = "";
		String orderByTitle = "";
		if (1<list.size()) {
			List<AbstractValueObject> vos = (List)list.get(1);
			if (0<vos.size()) {
				colValues = vos.get(0).getColumnValues();
			}
			sbufXML.append("<SHEET>");
			sbufXML.append("\n<DATA TOTAL=\"").append(vos.size()).append("\">");
			int idx = 0;
			for (AbstractValueObject vo : vos) {
				colValues = vo.getColumnValues();
				orderByTemp = colValues.get("orderby_title");
				if (!orderByTitle.equalsIgnoreCase(orderByTemp)) {
					sbufXML.append("\n	<TR MERGE=\"TRUE\" BGCOLOR=\"239,235,239\">");
					for (int j=0; j<34; j++) {
						sbufXML.append("\n		<TD BOLD=\"TRUE\" DATA-TYPE=\"dtData\" DATA-ALIGN=\"daLeft\" EDIT=\"FALSE\"><![CDATA[");
						sbufXML.append(replaceSortText(orderbyTitleMap,orderByTemp));
						sbufXML.append("]]></TD>");
					}
					for (int j=0; j<8; j++) {
						sbufXML.append("\n		<TD><![CDATA[]]></TD>");  //blank
					}
					sbufXML.append("\n	</TR>");
					orderByTitle = orderByTemp;
				}
				sbufXML.append("\n	<TR MARGE=\"FALSE\">");
				sbufXML.append("\n		<TD DATA-TYPE=\"dtCheckBox\" EDIT=\"TRUE\"><![CDATA[]]></TD>");  //Check
				sbufXML.append("\n		<TD><![CDATA["+(++idx)+"]]></TD>");  //Seq

				sbufXML.append("\n		<TD><![CDATA[").append(colValues.get("bl_no"       )).append("]]></TD>"); // bl_no
				sbufXML.append("\n		<TD><![CDATA[").append(colValues.get("por"         )).append("]]></TD>"); // por
				sbufXML.append("\n		<TD><![CDATA[").append(colValues.get("pol"         )).append("]]></TD>"); // pol
				sbufXML.append("\n		<TD><![CDATA[").append(colValues.get("pod"         )).append("]]></TD>"); // pod
				sbufXML.append("\n		<TD><![CDATA[").append(colValues.get("del"         )).append("]]></TD>"); // del
				sbufXML.append("\n		<TD><![CDATA[").append(colValues.get("r_term"      )).append("]]></TD>"); // r_term
				sbufXML.append("\n		<TD><![CDATA[").append(colValues.get("d_term"      )).append("]]></TD>"); // d_term
				sbufXML.append("\n		<TD><![CDATA[").append(colValues.get("rly_pol_cd"  )).append("]]></TD>"); // rly_pol_cd
				sbufXML.append("\n		<TD><![CDATA[").append(colValues.get("rly_pod_cd"  )).append("]]></TD>"); // rly_pod_cd
				sbufXML.append("\n		<TD><![CDATA[").append(colValues.get("rep"         )).append("]]></TD>"); // rep

				sbufXML.append("\n		<TD><![CDATA[").append(colValues.get("commodity"   )).append("]]></TD>"); // commodity
				sbufXML.append("\n		<TD><![CDATA[").append(colValues.get("d_sc"        )).append("]]></TD>"); // d_sc
				sbufXML.append("\n		<TD><![CDATA[").append(colValues.get("r_sc"        )).append("]]></TD>"); // r_sc
				sbufXML.append("\n		<TD><![CDATA[").append(colValues.get("a_sc"        )).append("]]></TD>"); // a_sc
				sbufXML.append("\n		<TD><![CDATA[").append(colValues.get("b_sc"        )).append("]]></TD>"); // b_sc
				sbufXML.append("\n		<TD><![CDATA[").append(colValues.get("a_s"         )).append("]]></TD>"); // a_s
				sbufXML.append("\n		<TD><![CDATA[").append(colValues.get("st"          )).append("]]></TD>"); // st
				sbufXML.append("\n		<TD><![CDATA[").append(colValues.get("bdr"         )).append("]]></TD>"); // bdr
				sbufXML.append("\n		<TD><![CDATA[").append(colValues.get("ca"          )).append("]]></TD>"); // ca
				sbufXML.append("\n		<TD><![CDATA[").append(colValues.get("twn_so_no"   )).append("]]></TD>"); // twn_so_no

				sbufXML.append("\n		<TD><![CDATA[").append(colValues.get("por_eq"      )).append("]]></TD>"); // por_eq
				sbufXML.append("\n		<TD><![CDATA[").append(colValues.get("del_eq"      )).append("]]></TD>"); // del_eq
				sbufXML.append("\n		<TD><![CDATA[").append(colValues.get("sc_rfa_no"   )).append("]]></TD>"); // sc_rfa_no
				sbufXML.append("\n		<TD><![CDATA[").append(colValues.get("aes"         )).append("]]></TD>"); // aes
				sbufXML.append("\n		<TD><![CDATA[").append(colValues.get("caed"        )).append("]]></TD>"); // caed
				sbufXML.append("\n		<TD><![CDATA[").append(colValues.get("manifest"    )).append("]]></TD>"); // manifest
				sbufXML.append("\n		<TD><![CDATA[").append(colValues.get("rate"        )).append("]]></TD>"); // rate
				sbufXML.append("\n		<TD><![CDATA[").append(colValues.get("consignee"   )).append("]]></TD>"); // consignee
				sbufXML.append("\n		<TD><![CDATA[").append(colValues.get("shipper"     )).append("]]></TD>"); // shipper
				sbufXML.append("\n		<TD><![CDATA[").append(colValues.get("obl_iss_flg" )).append("]]></TD>"); // obl_iss_flg

				sbufXML.append("\n		<TD><![CDATA[").append(colValues.get("obl_prn_flg" )).append("]]></TD>"); // obl_prn_flg
				sbufXML.append("\n		<TD><![CDATA[").append(colValues.get("obl_rlse_flg")).append("]]></TD>"); // obl_rlse_flg
				sbufXML.append("\n		<TD><![CDATA[").append(colValues.get("bkg_no"      )).append("]]></TD>"); // bkg_no
				sbufXML.append("\n		<TD><![CDATA[").append(colValues.get("bl_bkg_no"   )).append("]]></TD>"); // bl_bkg_no
				sbufXML.append("\n		<TD><![CDATA[").append(colValues.get("bl_act_wgt"  )).append("]]></TD>"); // bl_act_wgt
				sbufXML.append("\n		<TD><![CDATA[").append(colValues.get("bl_meas_qty" )).append("]]></TD>"); // bl_meas_qty
				sbufXML.append("\n		<TD><![CDATA[").append(colValues.get("order_col"   )).append("]]></TD>"); // order_col
				sbufXML.append("\n		<TD><![CDATA[chk]]></TD>");  //blank
				sbufXML.append("\n		<TD><![CDATA[]]></TD>");  //ibflag
				sbufXML.append("\n	</TR>");
			}
			sbufXML.append("\n</DATA>");
			sbufXML.append("\n<ETC-DATA></ETC-DATA>");
			sbufXML.append("\n</SHEET>");
			sbufXML.append("\n|$$|\n<SHEET>\n");
			sbufXML.append(makeDataTagDefault(vos, prefix));
			sbufXML.append("</SHEET>\n");
		}
		return sbufXML.toString();
	}

	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 객체
	 * @param colOrder String[] Column명 문자열
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception
	 */
	protected String makeDataTagDefault(List<AbstractValueObject> vos, String prefix) {
		StringBuilder sbufXML = new StringBuilder();

		int totCnt = vos.size();
		int realCnt = vos.size();

		AbstractValueObject vo = (AbstractValueObject) vos.get(0);
		String[] realColNms = getColHeader(vo);
		String[] changedColNms = getChangedColNms(realColNms, prefix);

		if (vo.getMaxRows() > 0) {
			totCnt = vo.getMaxRows();
		}

		sbufXML.append("<DATA COLORDER='"
				+ JSPUtil.convertStringArrayToString(changedColNms, "|")
				+ "' COLSEPARATOR='" + DELIMITER + "' TOTAL='" + totCnt
				+ "'>\n");

		for (int i = 0; i < realCnt; i++) {
			Map<String, String> colValues = vos.get(i).getColumnValues();

			sbufXML.append("	<TR><![CDATA[");
			int colCnt = realColNms.length;

			for (int j = 0; j < colCnt - 1; j++) {
				sbufXML.append(getNull(colValues.get(realColNms[j]))
						+ DELIMITER);
			}
			sbufXML.append(getNull(colValues.get(realColNms[colCnt - 1]))
					+ "]]></TR>\n");
		}
		sbufXML.append("</DATA>\n");

		return sbufXML.toString();
	}

	/**
	 * DBRowSet를 Parsing하여 <DATA>태그를 생성한다.<br>
	 * IBSheet의 prefix값이 있는 경우 COLORDER에 prefix를 붙인 column명으로 표시해 준다.<br>
	 * 
	 * @param rs DBRowSet VO객체
	 * @param prefix String IBSheet savename's prefix string
	 * @return String IBSheet <DATA>태그
	 * @exception
	 */
	protected String makeDataTag(DBRowSet rs, String prefix) {
		StringBuilder sb = new StringBuilder();

		// Pivot Table인 경우 makePivotDataTag 실행하여 return한
		if (rs.isPivot()) {
			sb.append(makePivotDataTag(rs));
			return sb.toString();
		}

		String[] realColNms = getColHeader(rs);

		try {
			String[] changedColNms = getChangedColNms(realColNms, prefix);

			sb.append("<DATA COLORDER='"
					+ JSPUtil.convertStringArrayToString(changedColNms, "|")
					+ "' COLSEPARATOR='" + DELIMITER + "' TOTAL='"
					+ getRowSetCnt(rs) + "'>\n");

			int colCount = realColNms.length;

			while (rs.next()) {
				sb.append("	<TR><![CDATA[");
				for (int j = 1; j < colCount; j++) {
					sb.append(getNull(rs.getObject(j)) + DELIMITER);
				}
				sb.append(getNull(rs.getObject(colCount)) + "]]></TR>\n");
			}
			sb.append("</DATA>\n");
		} catch (Exception ex) {
			throw new RuntimeException(ex.getMessage());
		}
		return sb.toString();
	}

	/**
	 * Pivot Table용 Data tag를 생성한다.<br>
	 * 
	 * @param rs DBRowSet VO객체
	 * @return String IBSheet <DATA>태그
	 * @exception
	 */
	protected String makePivotDataTag(DBRowSet rs) {
		StringBuilder sb = new StringBuilder();
		int colCnt = 0;
		int rowCnt = rs.getRowCount();

		String[][] arrRowSet = null;

		try {
			colCnt = rs.getMetaData().getColumnCount();
			arrRowSet = new String[rowCnt][colCnt];

			int rowIdx = 0;
			while (rs.next()) {
				for (int j = 1; j <= colCnt; j++) {
					arrRowSet[rowIdx][j - 1] = getNull(rs.getObject(j))
							.toString();
				}
				rowIdx++;
			}
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new RuntimeException(ex.getMessage());
		}

		try {
			sb.append("<DATA COLSEPARATOR='" + DELIMITER + "'>\n");
			if (rowCnt > 0) {
				for (int coIdx = 0; coIdx < colCnt; coIdx++) {
					sb.append("	<TR><![CDATA[");
					for (int roIdx = 0; roIdx < rowCnt - 1; roIdx++) {
						sb.append(arrRowSet[roIdx][coIdx] + DELIMITER);
					}
					sb.append(arrRowSet[rowCnt - 1][coIdx] + "]]></TR>\n");
				}// end for coIdx
			}// end for roIdx
			sb.append("</DATA>\n");
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new RuntimeException(ex.getMessage());
		}
		return sb.toString();
	}

	protected String getETCData(EventResponse eventResponse) {
		if (eventResponse == null)
			return "";
		StringBuilder sb = new StringBuilder();
		Map<String, String> etc_data = eventResponse.getETCData();
		sb.append("<ETC-DATA>\n");
		if (etc_data != null && etc_data.size() > 0) {
			String key;
			String val;
			for (Iterator<String> it = etc_data.keySet().iterator(); it
					.hasNext(); sb.append((new StringBuilder("<ETC KEY='"))
					.append(key).append("'><![CDATA[").append(val).append(
							"]]></ETC>\n").toString())) {
				key = (String) it.next();
				val = (new StringBuilder()).append((String) etc_data.get(key))
						.toString();
			}

		}
		sb.append(getPivotETCData(eventResponse));
		sb.append("</ETC-DATA>\n");
		return sb.toString();
	}

}
