/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0620ViewAdapter.java
 *@FileTitle : TRO Status List
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.13
 *@LastModifier : 김기종
 *@LastVersion : 1.0
 * 2009.07.13 김기종
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

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
public class EsmBkg0620ViewAdapter extends ViewAdapter {

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
		int d2 = 0;
		int d4 = 0;
		int d5 = 0;
		int d7 = 0;
		int d8 = 0;
		int d9 = 0;
		int dw = 0;
		int dx = 0;
		int r2 = 0;
		int r4 = 0;
		int r5 = 0;
		int f2 = 0;
		int f4 = 0;
		int f5 = 0;
		int o2 = 0;
		int o4 = 0;
		int o5 = 0;
		int s2 = 0;
		int s4 = 0;
		int t2 = 0;
		int t4 = 0;
		int a2 = 0;
		int a4 = 0;
		int a5 = 0;
		int p2 = 0;
		int p4 = 0;
		int z2 = 0;
		int z4 = 0;
		int tot_sum = 0;

		String groupByTitle = "";

		sbufXML.append("<SHEET>\n");
		// 토탈 개수 조정
		sbufXML.append("\n<DATA TOTAL='").append(totCnt).append("'>\n");
		for (int i = 0; i < realCnt; i++) {

			colValues = vos.get(i).getColumnValues();

			d2 += Integer.parseInt(JSPUtil.getNull(colValues.get("d2")));
			d4 += Integer.parseInt(JSPUtil.getNull(colValues.get("d4")));
			d5 += Integer.parseInt(JSPUtil.getNull(colValues.get("d5")));
			d7 += Integer.parseInt(JSPUtil.getNull(colValues.get("d7")));
			d8 += Integer.parseInt(JSPUtil.getNull(colValues.get("d8")));
			d9 += Integer.parseInt(JSPUtil.getNull(colValues.get("d9")));
			dw += Integer.parseInt(JSPUtil.getNull(colValues.get("dw")));
			dx += Integer.parseInt(JSPUtil.getNull(colValues.get("dx")));
			r2 += Integer.parseInt(JSPUtil.getNull(colValues.get("r2")));
			r4 += Integer.parseInt(JSPUtil.getNull(colValues.get("r4")));
			r5 += Integer.parseInt(JSPUtil.getNull(colValues.get("r5")));
			f2 += Integer.parseInt(JSPUtil.getNull(colValues.get("f2")));
			f4 += Integer.parseInt(JSPUtil.getNull(colValues.get("f4")));
			f5 += Integer.parseInt(JSPUtil.getNull(colValues.get("f5")));
			o2 += Integer.parseInt(JSPUtil.getNull(colValues.get("o2")));
			o4 += Integer.parseInt(JSPUtil.getNull(colValues.get("o4")));
			o5 += Integer.parseInt(JSPUtil.getNull(colValues.get("o5")));
			s2 += Integer.parseInt(JSPUtil.getNull(colValues.get("s2")));
			s4 += Integer.parseInt(JSPUtil.getNull(colValues.get("s4")));
			t2 += Integer.parseInt(JSPUtil.getNull(colValues.get("t2")));
			t4 += Integer.parseInt(JSPUtil.getNull(colValues.get("t4")));
			a2 += Integer.parseInt(JSPUtil.getNull(colValues.get("a2")));
			a4 += Integer.parseInt(JSPUtil.getNull(colValues.get("a4")));
			a5 += Integer.parseInt(JSPUtil.getNull(colValues.get("a5")));
			p2 += Integer.parseInt(JSPUtil.getNull(colValues.get("p2")));
			p4 += Integer.parseInt(JSPUtil.getNull(colValues.get("p4")));
			z2 += Integer.parseInt(JSPUtil.getNull(colValues.get("z2")));
			z4 += Integer.parseInt(JSPUtil.getNull(colValues.get("z4")));

			groupByTemp = colValues.get("subgroup_title");

			// 이전 GroupBy Title과 현재 데이타의 값이 틀리면 제목을 새로 생성한다.
			if (!groupByTitle.equals(groupByTemp)) {

				// OrderBy XML생성
				sbufXML.append(" <TR MERGE=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n");
				sbufXML.append("		<TD BOLD='TRUE' DATA-ALIGN='daLeft'><![CDATA[").append(groupByTemp).append("]]></TD>\n");
				for (int j = 0; j < 16; j++) {
					sbufXML.append("		<TD DATA-ALIGN='daLeft'><![CDATA[").append(groupByTemp).append("]]></TD>\n");
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
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("rnum"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("bkg_no"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("tro_seq"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("teu_a"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("teu_b"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("cntr_tpsz_cd"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("tro_qty"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("dor_arr_dt"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("pkup_loc_cd"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("rcv_term_cd"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("dor_loc_cd"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("act_shpr_nm"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("pol_cd"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("diff_rmk"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("subgroup_title"))).append("]]></TD>\n");

			sbufXML.append("	</TR>\n");
			sbufXML.append("	\n");

			sbufXML.append("	<TR>\n");
			sbufXML.append("		<TD><![CDATA[").append("R").append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("rnum"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("bkg_no"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("tro_seq"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("teu_a"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("teu_b"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("cntr_tpsz_cd"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("tro_qty"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("rqst_dt"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("rtn_loc_cd"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("so_flg"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("eq_ctrl_ofc_cd"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("cntc_pson_nm"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("pod_cd"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("diff_rmk"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("subgroup_title"))).append("]]></TD>\n");

			sbufXML.append("	</TR>\n");
			sbufXML.append("	\n");

			/*
			 * sbufXML.append(" <TR MERGE=\"TRUE\" HIDDEN='TRUE'>\n"); sbufXML.append("	</TR>\n");
			 */

			sbufXML.append("	 <TR MERGE=\"TRUE\" HIDDEN='TRUE'>\n");
			sbufXML.append("		<TD><![CDATA[").append("R").append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("rnum"))).append("]]></TD>\n");
			sbufXML.append("		<TD></TD>\n");
			sbufXML.append("		<TD></TD>\n");
			sbufXML.append("		<TD></TD>\n");
			sbufXML.append("		<TD></TD>\n");
			sbufXML.append("		<TD></TD>\n");
			sbufXML.append("		<TD></TD>\n");
			sbufXML.append("		<TD></TD>\n");
			sbufXML.append("		<TD></TD>\n");
			sbufXML.append("		<TD></TD>\n");
			sbufXML.append("		<TD></TD>\n");
			sbufXML.append("		<TD></TD>\n");
			sbufXML.append("		<TD></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("diff_rmk"))).append("]]></TD>\n");
			sbufXML.append("		<TD></TD>\n");

			sbufXML.append("	</TR>\n");
			sbufXML.append("	\n");
		}

		sbufXML.append("</DATA>\n");

		if (realCnt > 0) {
			tot_sum = d2 + d4 + d5 + d7 + d8 + d9 + dw + dx + r2 + r4 + r5 + f2 + f4 + f5 + o2 + o4 + o5 + s2 + s4 + t2 + t4 + a2 + a4 + a5 + p2 + p4 + z2 + z4;

			sbufXML.append("<ETC-DATA>");
			sbufXML.append("<ETC KEY='d2'><![CDATA[").append(d2).append("]]></ETC>");
			sbufXML.append("<ETC KEY='d4'><![CDATA[").append(d4).append("]]></ETC>");
			sbufXML.append("<ETC KEY='d5'><![CDATA[").append(d5).append("]]></ETC>");
			sbufXML.append("<ETC KEY='d7'><![CDATA[").append(d7).append("]]></ETC>");
			sbufXML.append("<ETC KEY='d8'><![CDATA[").append(d8).append("]]></ETC>");
			sbufXML.append("<ETC KEY='d9'><![CDATA[").append(d9).append("]]></ETC>");
			sbufXML.append("<ETC KEY='dw'><![CDATA[").append(dw).append("]]></ETC>");
			sbufXML.append("<ETC KEY='dx'><![CDATA[").append(dx).append("]]></ETC>");
			sbufXML.append("<ETC KEY='r2'><![CDATA[").append(r2).append("]]></ETC>");
			sbufXML.append("<ETC KEY='r4'><![CDATA[").append(r4).append("]]></ETC>");
			sbufXML.append("<ETC KEY='r5'><![CDATA[").append(r5).append("]]></ETC>");
			sbufXML.append("<ETC KEY='f2'><![CDATA[").append(f2).append("]]></ETC>");
			sbufXML.append("<ETC KEY='f4'><![CDATA[").append(f4).append("]]></ETC>");
			sbufXML.append("<ETC KEY='f5'><![CDATA[").append(f5).append("]]></ETC>");
			sbufXML.append("<ETC KEY='o2'><![CDATA[").append(o2).append("]]></ETC>");
			sbufXML.append("<ETC KEY='o4'><![CDATA[").append(o4).append("]]></ETC>");
			sbufXML.append("<ETC KEY='o5'><![CDATA[").append(o5).append("]]></ETC>");
			sbufXML.append("<ETC KEY='s2'><![CDATA[").append(s2).append("]]></ETC>");
			sbufXML.append("<ETC KEY='s4'><![CDATA[").append(s4).append("]]></ETC>");
			sbufXML.append("<ETC KEY='t2'><![CDATA[").append(t2).append("]]></ETC>");
			sbufXML.append("<ETC KEY='t4'><![CDATA[").append(t4).append("]]></ETC>");
			sbufXML.append("<ETC KEY='a2'><![CDATA[").append(a2).append("]]></ETC>");
			sbufXML.append("<ETC KEY='a4'><![CDATA[").append(a4).append("]]></ETC>");
			sbufXML.append("<ETC KEY='a5'><![CDATA[").append(a5).append("]]></ETC>");
			sbufXML.append("<ETC KEY='p2'><![CDATA[").append(p2).append("]]></ETC>");
			sbufXML.append("<ETC KEY='p4'><![CDATA[").append(p4).append("]]></ETC>");
			sbufXML.append("<ETC KEY='z2'><![CDATA[").append(z2).append("]]></ETC>");
			sbufXML.append("<ETC KEY='z4'><![CDATA[").append(z4).append("]]></ETC>");
			sbufXML.append("<ETC KEY='tot_sum'><![CDATA[").append(tot_sum).append("]]></ETC>");
			sbufXML.append("</ETC-DATA>");
		}
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
		boolean isFirstSheet = true;
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
