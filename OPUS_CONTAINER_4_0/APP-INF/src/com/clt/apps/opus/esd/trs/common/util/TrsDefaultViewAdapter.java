/*=========================================================
 *Copyright(c) 2008 CyberLogitec
 *@FileName : TrsDefaultViewAdapter.java
 *@FileTitle : TRS Default IBSheet Generation Class
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2008-11-24
 *@LastModifier : Lee SeungYol
 *@LastVersion : 1.0
 * 2008-11-24 Lee SeungYol
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.common.util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.GeneralEventResponse;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Poong-Yeon Cho
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public abstract class TrsDefaultViewAdapter extends ViewAdapter {

	@SuppressWarnings("rawtypes")
	protected String makeDataTag(List vos, String prefix) {
		StringBuilder sbufXML = new StringBuilder();
		int totCnt = vos.size();
		int realCnt = vos.size();
		AbstractValueObject vo = (AbstractValueObject) vos.get(0);
		String realColNms[] = getColHeader(vo);
		String changedColNms[] = getChangedColNms(realColNms, prefix);
		if (vo.getMaxRows() > 0)
			totCnt = vo.getMaxRows();
		sbufXML.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' COLSEPARATOR='").append("\u261C\u261E").append("' TOTAL='").append(totCnt).append("'>\n").toString());
		for (int i = 0; i < realCnt; i++) {
			Map<String, String> colValues = ((AbstractValueObject) vos.get(i)).getColumnValues();
			sbufXML.append("\t<TR><![CDATA[");
			int colCnt = realColNms.length;
			for (int j = 0; j < colCnt - 1; j++)
				sbufXML.append((new StringBuilder(String.valueOf(getNull((String) colValues.get(realColNms[j]))))).append("\u261C\u261E").toString());

			sbufXML.append((new StringBuilder(String.valueOf(getNull((String) colValues.get(realColNms[colCnt - 1]))))).append("]]></TR>\n").toString());
		}

		sbufXML.append("</DATA>\n");
		return sbufXML.toString();
	}

	protected String makeDataTag(DBRowSet rs, String prefix) {
		StringBuilder sb = new StringBuilder();
		if (rs.isPivot()) {
			sb.append(makePivotDataTag(rs));
			return sb.toString();
		}
		String realColNms[] = getColHeader(rs);
		try {
			String changedColNms[] = getChangedColNms(realColNms, prefix);
			sb.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' COLSEPARATOR='").append("\u261C\u261E").append("' TOTAL='").append(getRowSetCnt(rs)).append("'>\n").toString());
			int colCount = realColNms.length;
			for (; rs.next(); sb.append((new StringBuilder()).append(getNull(rs.getObject(colCount))).append("]]></TR>\n").toString())) {
				sb.append("\t<TR><![CDATA[");
				for (int j = 1; j < colCount; j++)
					sb.append((new StringBuilder()).append(getNull(rs.getObject(j))).append("\u261C\u261E").toString());

			}

			sb.append("</DATA>\n");
		} catch (SQLException ex) {
			throw new RuntimeException(ex.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new RuntimeException(ex.getMessage());
		}
		return sb.toString();
	}

	protected abstract String makeDataTag(List<AbstractValueObject> vos, String prefix, Event event);

	protected abstract String makeDataTag(DBRowSet rs, String prefix, Event event);

	protected String makePivotDataTag(DBRowSet rs) {
		StringBuilder sb = new StringBuilder();
		int colCnt = 0;
		int rowCnt = rs.getRowCount();
		String arrRowSet[][] = (String[][]) null;
		try {
			colCnt = rs.getMetaData().getColumnCount();
			arrRowSet = new String[rowCnt][colCnt];
			for (int rowIdx = 0; rs.next(); rowIdx++) {
				for (int j = 1; j <= colCnt; j++)
					arrRowSet[rowIdx][j - 1] = getNull(rs.getObject(j)).toString();
			}
		} catch (SQLException ex) {
			log.error(ex.getMessage(), ex);
			throw new RuntimeException(ex.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new RuntimeException(ex.getMessage());
		}
		try {
			sb.append("<DATA COLSEPARATOR='\u261C\u261E'>\n");
			if (rowCnt > 0) {
				for (int coIdx = 0; coIdx < colCnt; coIdx++) {
					sb.append("\t<TR><![CDATA[");
					for (int roIdx = 0; roIdx < rowCnt - 1; roIdx++) {
						sb.append((new StringBuilder(String.valueOf(arrRowSet[roIdx][coIdx]))).append("\u261C\u261E").toString());
					}
					sb.append((new StringBuilder(String.valueOf(arrRowSet[rowCnt - 1][coIdx]))).append("]]></TR>\n").toString());
				}

			}
			sb.append("</DATA>\n");
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new RuntimeException(ex.getMessage());
		}
		return sb.toString();
	}

	/**
	 * @param request
	 * @param response
	 * @return
	 */
	public String makeXML(HttpServletRequest request, HttpServletResponse response) {
		Event event = null;
		GeneralEventResponse eventResponse = null;
		Exception serverException = null;
		String strXML = "";
		boolean isupload = isUploadFile(request);
		try {
			serverException = (Exception) request.getAttribute("com.clt.framework.core.comm.EXCEPTION_OBJECT      ");
			if (serverException != null) {
				strXML = getErrorXML((new ErrorHandler(serverException)).loadPopupMessage(), isupload);
			} else {
				boolean isUpload = isUploadFile(request);
				event = (Event) request.getAttribute("Event");
				eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
				boolean isSave = isSaveCommand(event);
				if (eventResponse != null) {
					if (eventResponse.getDataCntList() != null && eventResponse.getDataCntList().size() == 0) {
						strXML = getNoSearchResultXML(isUpload, isSave, eventResponse);
					} else {
						strXML = makeSuccessXML(isUpload, request, eventResponse);
					}
				}
			}
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			strXML = getErrorXML((new ErrorHandler(ex)).loadPopupMessage(), isupload);
		}
		return strXML;
	}

	/**
	 * @param isUpload
	 * @param request
	 * @param eventResponse
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private String makeSuccessXML(boolean isUpload, HttpServletRequest request, GeneralEventResponse eventResponse) {
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
				sb.append(makeDataTag((DBRowSet) it.next(), prefixs[i], event));
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

				sb.append(getStartTag(isFirstSheet, isSave, eventResponse));
				sb.append(makeDataTag(tmpList, prefixs[i], event));
				sb.append(getEndTag(sb));
				removeListAllElements(tmpList);
				isFirstSheet = false;
			}
		}

		if (isUpload)
			sb.append("</pre>\n");
		return sb.toString();
	}

	private boolean isUploadFile(HttpServletRequest request) {
		boolean isUpload = false;
		String contentType = request.getContentType();
		if (contentType != null && contentType.startsWith("multipart/form-data"))
			isUpload = true;
		return isUpload;
	}

	/**
	 * @param isFirstSheet
	 * @param isSave
	 * @param eventResponse
	 * @return
	 */
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

	/**
	 * @param sb
	 * @return
	 */
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
}
