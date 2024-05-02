/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EsmBkg1501ViewAdapter.java
*@FileTitle : EsmBkg1501ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.28
*@LastModifier :
*@LastVersion : 1.0
* 2013.06.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.event;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.core.controller.html.HTMLAction;


/**
 * ESm_BKG_1501 에 대한 ViewAdapter<br>
 * - ESm_BKG_1501HTMLAction에서 작성<br>
 *
 * @author
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg1501ViewAdapter extends ViewAdapter {


	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환<br>
	 *
	 * @param List<AbstractValueObject> list
	 * @param String prefix
	 * @return String
	 */
	protected String makeDataTag(List<AbstractValueObject> voList, String prefix) {

		int dispTtlbl = 0;
		int dispMissBl = 0;
		int dispSntSccBl = 0;
		int dispSntErrBl = 0;

		int dispDnl = 0;
		int dispDnu = 0;
		int dispSpd = 0;
		int dispHld = 0;

		int errSeq = 0;

		StringBuilder searchXml = new StringBuilder();

		try{
			int totCnt = voList.size();
			String[] colNmArray = getColHeader(voList.get(0));
			searchXml.append("\n<DATA COLORDER='" + JSPUtil.convertStringArrayToString(colNmArray, "|") + "' TOTAL='" + totCnt +"'>\n");

			for (int k=0; k<voList.size(); k++) {
				Map<String, String> mapColVal = voList.get(k).getColumnValues();
				boolean errInfo = false;

				// Counting (S)
				String blNo = mapColVal.get("bl_no");
				// 직후 bl_no와 다르면 카운팅
				Map<String, String> tempMapColumnValues = new HashMap<String, String>();
				if (k > 0) tempMapColumnValues = voList.get(k - 1).getColumnValues();
				if (k == 0 || (k > 0 && !blNo.equals(tempMapColumnValues.get("bl_no")))) {
					if (mapColVal.get("err_info").indexOf("N") > -1 || "E".equals(mapColVal.get("mst_bl")) || "".equals(mapColVal.get("cntr_no"))) {
						errInfo = true;
						errSeq++;
					}
					if (" ".equals(mapColVal.get("s_dt"))) {
						dispMissBl++;    // "Missing B/L" 카운팅
					} else {
						if ("Error".equals(mapColVal.get("samr_rst")) || "Error".equals(mapColVal.get("scmr_rst"))) {
							dispSntErrBl++;    // "(Sent) Error B/L" 카운팅
						} else {
							dispSntSccBl++;    // "(Sent) Success B/L" 카운팅
						}
					}
					String sa111Rst = mapColVal.get("sa111_rst");
					if (!" ".equals(sa111Rst)) {
						if ("DNL".equals(sa111Rst)) {
							dispDnl++;
						} else if ("DNU".equals(sa111Rst)) {
							dispDnu++;
						} else if ("SPD".equals(sa111Rst)) {
							dispSpd++;
						} else if ("HLD".equals(sa111Rst)) {
							dispHld++;
						}
					}
				}
				// Counting (E)

				// 조회XML 생성 (S)
				searchXml.append("<TR>");
				for (String colNm : colNmArray) {
					String colValue = mapColVal.get(colNm);
					searchXml.append("<TD");
					// Background Color & Property (S)
					if ("samr_rst".equals(colNm) || "samr_dt".equals(colNm) || ("cntr_no".equals(colNm) && "".equals(colValue))) {
						searchXml.append(" BGCOLOR='255,240,240'");
					} else if ("sa111_rst".equals(colNm) || "sa111_dt".equals(colNm)) {
						searchXml.append(" BGCOLOR='240,255,240'");
					} else if ("sc108_rst".equals(colNm) || "sc108_dt".equals(colNm)) {
						searchXml.append(" BGCOLOR='240,250,250'");
					} else if ("old_usr_eml".equals(colNm)) {
						searchXml.append(" BGCOLOR='239,240,243' ");
					} else if ("usr_eml".equals(colNm) && !"C".equals(mapColVal.get("mst_bl"))) {
						searchXml.append(" BGCOLOR='239,240,243' EDIT='FALSE'");
					}
					// Background Color & Property (E)

					// Font Color & Property (S)
					if (("mst_bl".equals(colNm) && "E".equals(colValue))
							|| ("shpr_nm".equals(colNm) || "shpr_addr".equals(colNm) || "shpr_cnt_cd".equals(colNm) || "shpr_phn_no".equals(colNm) ||
								"cnee_nm".equals(colNm) || "cnee_addr".equals(colNm) || "cnee_cnt_cd".equals(colNm) || "cnee_phn_no".equals(colNm) ||
								"ntfy_nm".equals(colNm) || "ntfy_addr".equals(colNm) || "ntfy_cnt_cd".equals(colNm) || "ntfy_phn_no".equals(colNm) ||
								"cmdt_cd".equals(colNm) || "cmdt_hs_cd".equals(colNm) || "mk_desc".equals(colNm) || "pck_qty".equals(colNm) ||
								"pck_tp_cd".equals(colNm) || "act_wgt".equals(colNm) || "wgt_ut_cd".equals(colNm) || "meas_qty".equals(colNm) ||
								"meas_ut_cd".equals(colNm) || "imdg_cls".equals(colNm) || "un_no".equals(colNm))
							&& "N".equals(colValue)) {
						searchXml.append(" COLOR='255,60,60' BOLD='TRUE'");
					} else if (("bl_no".equals(colNm) && errInfo)) {
						searchXml.append(" COLOR='255,60,60'");
					} else if ((("samr_rst".equals(colNm) ||"scmr_rst".equals(colNm) || "sc108_rst".equals(colNm)) && "Error".equals(colValue)) ||
								("sa111_rst".equals(colNm) && (!"Clear".equals(colValue) && !" ".equals(colValue)))) {
						searchXml.append(" COLOR='255,60,60' BOLD='TRUE' FontUnderline='TRUE'");
					}
					// Font Color & Property (E)

					searchXml.append(">");

					// Value Customize (S)
					if ("sc108_rst".equals(colNm) && (!"Success".equals(colValue) && !" ".equals(colValue))) {
						 // 1글자마다 잘라내어 배열생성 후 글자사이에 "," 삽입
						String[] sc108rstArray = mapColVal.get("sc108_rst_dtl").replaceAll("/","").split("(?<=\\G.{"+1+"})");
						searchXml.append(org.apache.commons.lang.StringUtils.join(sc108rstArray, ","));
					} else {
						searchXml.append(mapColVal.get(colNm));
					}
					// Value Customize (E)

					searchXml.append("</TD>");

				}
				searchXml.append("</TR>\n");
				// 조회 XML 생성 (E)

				if (k == voList.size()-1) dispTtlbl = Integer.valueOf(mapColVal.get("seq"));
			}

			searchXml.append("</DATA>\n");
			searchXml.append("<ETC-DATA>\n");
			searchXml.append("   <ETC KEY='disp_ttl_bl'>" + dispTtlbl + "</ETC>\n");
			searchXml.append("   <ETC KEY='disp_com_err_bl'>" + errSeq + "</ETC>\n");
			searchXml.append("   <ETC KEY='disp_miss_bl'>" + dispMissBl + "</ETC>\n");
			searchXml.append("   <ETC KEY='disp_snt_scc_bl'>" + dispSntSccBl + "</ETC>\n");
			searchXml.append("   <ETC KEY='disp_snt_err_bl'>" + dispSntErrBl + "</ETC>\n");
			searchXml.append("   <ETC KEY='disp_dnl'>" + dispDnl + "</ETC>\n");
			searchXml.append("   <ETC KEY='disp_dnu'>" + dispDnu + "</ETC>\n");
			searchXml.append("   <ETC KEY='disp_spd'>" + dispSpd + "</ETC>\n");
			searchXml.append("   <ETC KEY='disp_hld'>" + dispHld + "</ETC>\n");
			searchXml.append("</ETC-DATA>\n");

			return searchXml.toString();

		} catch(Exception ex) {
			throw new RuntimeException(ex.getMessage());
		}
	}

	/**
	 * makeDataTag<br>
	 *
	 * @param BRowSet dbRs
	 * @param String prefix
	 * @return String
	 */
	protected String makeDataTag(DBRowSet dbRs, String prefix) {
		return null;
	}

}

