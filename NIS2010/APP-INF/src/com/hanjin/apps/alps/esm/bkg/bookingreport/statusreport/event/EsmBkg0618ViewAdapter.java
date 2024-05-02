/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0618ViewAdapter.java
 *@FileTitle : TRO Status List
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.13
 *@LastModifier : 김기종
 *@LastVersion : 1.0
 * 2009.07.13 김기종
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Kim Ki Jong
 * @see ViewAdapter 참조
 * @since J2EE 1.6
 */
public class EsmBkg0618ViewAdapter extends ViewAdapter {

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

		int totCnt = vos.size();
		int realCnt = vos.size();

		AbstractValueObject vo = (AbstractValueObject) vos.get(0);

		if (vo.getMaxRows() > 0) {
			totCnt = vo.getMaxRows();
		}

		Map<String, String> colValues = null;
		String groupByTemp = "";
		String groupByTitle = "";

		sbufXML.append("<SHEET>\n");
		// 토탈 개수 조정
		sbufXML.append("\n<DATA TOTAL='").append(totCnt).append("'>\n");
		for (int i = 0; i < realCnt; i++) {

			colValues = vos.get(i).getColumnValues();
			groupByTemp = colValues.get("subgroup_title");

			// 이전 GroupBy Title과 현재 데이타의 값이 틀리면 제목을 새로 생성한다.
			if (!groupByTitle.equals(groupByTemp)) {

				// OrderBy XML생성
				sbufXML.append(" <TR MERGE=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n");
				sbufXML.append("		<TD BOLD='TRUE' DATA-ALIGN='daLeft' EDIT='false'><![CDATA[").append(groupByTemp).append("]]></TD>\n");
				/* sbufXML.append("  		<TD DATA-TYPE=\"dtData\"><![CDATA[0]]></TD>\n"); */
				for (int j = 0; j < 16; j++) {
					sbufXML.append("		<TD DATA-ALIGN='daLeft' EDIT='false'><![CDATA[").append(groupByTemp).append("]]></TD>\n");
				}

				sbufXML.append("	</TR>\n");
				sbufXML.append("	\n");
				sbufXML.append(" <TR MERGE=\"TRUE\" HIDDEN='TRUE'>\n");
				sbufXML.append("	</TR>\n");
				sbufXML.append("	\n");

				groupByTitle = groupByTemp;
				// orderbyCnt++;
			}

			sbufXML.append("	<TR >\n");
			sbufXML.append("		<TD><![CDATA[").append("R").append("]]></TD>\n");

			sbufXML.append("  		<TD DATA-TYPE=\"dtCheckBox\"><![CDATA[0]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("rnum"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("bkg_ref_no"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("bkg_no"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("sc_no"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("por_cd"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("pod_cd"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("del_cd"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("cntr_no"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("cnmv_sts_cd"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("cntc_pson_fax_no"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("cntc_pson_eml"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("subgroup_title"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("bkg_cust_tp_cd"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("vvd_cd"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("bkg_ofc_cd"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("bkg_c_person"))).append("]]></TD>\n");

			sbufXML.append("	</TR>\n");
			sbufXML.append("	\n");

			/*
			 * sbufXML.append(" <TR MERGE=\"TRUE\" HIDDEN='TRUE'>\n"); sbufXML.append("	</TR>\n");
			 */
		}

		sbufXML.append("</DATA>\n");
		sbufXML.append("</SHEET>\n");
		/*
		 * sbufXML.append("|$$|<SHEET>\n"); sbufXML.append(makeDataTagDefault(vos, prefix)); sbufXML.append("</SHEET>\n");
		 */
		return sbufXML.toString();
	}

	private String getStartTag(boolean isFirstSheet, boolean isSave, GeneralEventResponse eventResponse) {
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
		if (sheetLoc > resultLoc) endTag = "</SHEET>\n";
		else
			endTag = "</RESULT>\n";
		return endTag;
	}

	/**
	 * DBRowSet를 Parsing하여 XML문자열 태그를 생성한다.<br>
	 * 
	 * @param boolean isUpload
	 * @param HttpServletRequest request
	 * @param EventResponse eventResponse
	 * 
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception
	 */
	@SuppressWarnings("unchecked")
	private String makeSuccessXML(boolean isUpload, HttpServletRequest request, GeneralEventResponse eventResponse) {
		Event event = (Event) request.getAttribute("Event");
		boolean isSave = isSaveCommand(event);
		StringBuilder sb = new StringBuilder();
		List rsVoList = eventResponse.getRsVoList();
		/* int cnt = rsVoList.size(); */
		/*String preVOName = "";*/
		boolean isFirstSheet = true;
		/* List voList = new ArrayList(); */
		String prefixs[] = getPrefixFromHttp(request);
		List dataCntList = eventResponse.getDataCntList();
		if (isUpload) sb.append("<pre>\n");
		int setExeCnt = dataCntList.size();
		Iterator it = rsVoList.iterator();
		int curLoc = 0;
		for (int i = 0; i < setExeCnt; i++) {
			int voCnt = ((Integer) dataCntList.get(i)).intValue();
			if (voCnt == 0) {
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
				List tmpList = new ArrayList();
				for (int j = 0; j < voCnt; j++) {
					Object obj = it.next();
					tmpList.add(obj);
					curLoc++;
				}

				// sb.append(getStartTag(isFirstSheet, isSave, eventResponse));
				sb.append(makeDataTag(tmpList, prefixs[i]));
				// sb.append(getEndTag(sb));
				removeListAllElements(tmpList);
				isFirstSheet = false;
			}
		}

		if (isUpload) sb.append("</pre>\n");
		return sb.toString();
	}

	/**
	 * DBRowSet를 Parsing하여 XML문자열 태그를 생성한다.<br>
	 * 
	 * @param HttpServletRequest request
	 * @param HttpServletResponse response
	 * 
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception
	 */

	public String makeXML(HttpServletRequest request, HttpServletResponse response) {
		Event event = null;
		GeneralEventResponse eventResponse = null;
		Exception serverException = null;
		String strXML = "";
		boolean isupload = isUploadFile(request);
		try {
			serverException = (Exception) request.getAttribute("com.hanjin.framework.core.comm.EXCEPTION_OBJECT      ");
			if (serverException != null) {
				strXML = getErrorXML((new ErrorHandler(serverException)).loadPopupMessage(), isupload);
			} else {
				boolean isUpload = isUploadFile(request);
				event = (Event) request.getAttribute("Event");
				eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
				//List rsVoList = null;
				boolean isSave = isSaveCommand(event);
				if (eventResponse != null) {
					//rsVoList = eventResponse.getRsVoList();
					if (eventResponse.getDataCntList().size() == 0) strXML = getNoSearchResultXML(isUpload, isSave, eventResponse);
					else
						strXML = makeSuccessXML(isUpload, request, eventResponse);
				}
			}
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			strXML = getErrorXML((new ErrorHandler(ex)).loadPopupMessage(), isupload);
		}
		if (log.isDebugEnabled()) log.debug((new StringBuilder("\n")).append(strXML).toString());
		return strXML;
	}

	private boolean isUploadFile(HttpServletRequest request) {
		boolean isUpload = false;
		String contentType = request.getContentType();
		if (contentType != null && contentType.startsWith("multipart/form-data")) isUpload = true;
		return isUpload;
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

		sbufXML.append("<DATA COLORDER='" + JSPUtil.convertStringArrayToString(changedColNms, "|") + "' COLSEPARATOR='" + DELIMITER + "' TOTAL='" + totCnt + "'>\n");

		for (int i = 0; i < realCnt; i++) {
			Map<String, String> colValues = vos.get(i).getColumnValues();

			sbufXML.append("	<TR><![CDATA[");
			int colCnt = realColNms.length;

			for (int j = 0; j < colCnt - 1; j++) {
				sbufXML.append(getNull(colValues.get(realColNms[j])) + DELIMITER);
			}
			sbufXML.append(getNull(colValues.get(realColNms[colCnt - 1])) + "]]></TR>\n");
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

			sb.append("<DATA COLORDER='" + JSPUtil.convertStringArrayToString(changedColNms, "|") + "' COLSEPARATOR='" + DELIMITER + "' TOTAL='" + getRowSetCnt(rs) + "'>\n");

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
			log.error(ex.getMessage(), ex);
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
					arrRowSet[rowIdx][j - 1] = getNull(rs.getObject(j)).toString();
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

	/**
	 * DBRowSet를 Parsing하여 <ETC DATA>태그를 생성한다.<br>
	 * 
	 * @param EventResponse eventResponse
	 * @return String ETC DATA <DATA>태그
	 * @exception
	 */

	protected String getETCData(EventResponse eventResponse) {
		if (eventResponse == null) return "";
		StringBuilder sb = new StringBuilder();
		Map<String,String> etc_data = eventResponse.getETCData();
		sb.append("<ETC-DATA>\n");
		if (etc_data != null && etc_data.size() > 0) {
			String key;
			String val;
			for (Iterator<String> it = etc_data.keySet().iterator(); it.hasNext(); sb.append((new StringBuilder("<ETC KEY='")).append(key).append("'><![CDATA[").append(val).append("]]></ETC>\n").toString())) {
				key = (String) it.next();
				val = (new StringBuilder()).append((String) etc_data.get(key)).toString();
			}

		}
		sb.append(getPivotETCData(eventResponse));
		sb.append("</ETC-DATA>\n");
		return sb.toString();
	}

}
