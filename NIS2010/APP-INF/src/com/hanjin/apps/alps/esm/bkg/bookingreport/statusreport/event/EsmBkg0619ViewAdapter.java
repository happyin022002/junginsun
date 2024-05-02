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
 * 2012.02.29 변종건 [CHM-201216420-01] Outbound CNTR Movement Status에 Trade, Sub Trade 옵션 추가 요청
 * 2013.02.01 김진주[CHM-201322839] 리포트 보완 -O/B Container Movement Stauts 화면
 * 2013.02.06 김진주[CHM-201322839] 리포트 보완 -O/B Container Movement Stauts 화면
 * 2014.08.05 이한나[CHM-201431231] O/B CNTR MOVEMENT STATUS REPORT 보완
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event;

import java.math.BigDecimal;
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
public class EsmBkg0619ViewAdapter extends ViewAdapter {

	/**
	 * String 형태의 숫자를 Double형으로 변환한다.<br>
	 * 
	 * @param String input
	 * 
	 * @return double
	 * @exception
	 */
	public static double stringToDouble(String input) {
		if (input == null) input = "0.0";
		if (input.equals("")) input = "0.0";
		if (input.indexOf(".") < 0) input = input + ".0";
		double dBmQty = Double.parseDouble(input);
		return dBmQty;
	}

	/**
	 * Double형 숫자를 자리수 적용하여 반환한다.<br>
	 * 
	 * @param double dataDouble
	 * @param int seat
	 * 
	 * @return BigDecimal
	 * @exception
	 */

	public static BigDecimal getRound(double dataDouble, int seat) {

		BigDecimal bd = new BigDecimal(dataDouble);
		bd = bd.setScale(seat, BigDecimal.ROUND_HALF_UP);

		return bd;

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
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
		StringBuilder sbufXML = new StringBuilder();

		int totCnt = vos.size();
		int realCnt = vos.size();
		Double s_a10 = 0.0;
		Double s_a11 = 0.0;
		Double s_a12 = 0.0;
		Double s_a13 = 0.0;
		Double s_a14 = 0.0;
		Double s_a15 = 0.0;
		Double s_a16 = 0.0;
		Double s_a17 = 0.0;
		Double s_a20 = 0.0;
		Double s_a21 = 0.0;
		Double s_a22 = 0.0;
		Double s_a23 = 0.0;
		Double s_a24 = 0.0;
		Double s_a25 = 0.0;
		Double s_a26 = 0.0;
		Double s_a27 = 0.0;
		Double s_a28 = 0.0;
		Double s_a29 = 0.0;
		int rowNum = 1;
		AbstractValueObject vo = (AbstractValueObject) vos.get(0);

		if (vo.getMaxRows() > 0) {
			totCnt = vo.getMaxRows();
		}

		Map<String, String> colValues = null;
		Map<String, String> colValues2 = null;
		Map<String, String> colValues0 = null;
		String groupByTemp = "";
		String groupByTemp2 = "";
		String groupByTitle = "";
		sbufXML.append("<SHEET>\n");
		// 토탈 개수 조정
		sbufXML.append("\n<DATA TOTAL='").append(totCnt).append("'>\n");

		for (int i = 0; i < realCnt; i++) {
			/*
			 * 1. subgroup title 1-1. 첫라인 과 다음라인 타이틀 다를 경우 2. data list 3. subtotoal 3-1. 다음라인과 타이틀 다를 경우 3-2. cnt 계산은
			 */

			colValues = vos.get(i).getColumnValues();
			if (i < realCnt - 1) {
				colValues2 = vos.get(i + 1).getColumnValues();
				groupByTemp2 = colValues2.get("subgroup_title");
			} else {
				groupByTemp2 = "";
				colValues2 = null;
			}
			groupByTemp = colValues.get("subgroup_title");

			if (JSPUtil.getNull(colValues.get("cntr_tpsz_cd_mv")).indexOf("2") > 0) {
				s_a11 = s_a11 + stringToDouble(JSPUtil.getNull(colValues.get("cntr_vol_qty")));
			} else {
				s_a10 = s_a10 + stringToDouble(JSPUtil.getNull(colValues.get("cntr_vol_qty")));
			}

			/*
			 * F는 사이즈가 40’, 40’HC인 컨테이너의 합계 (Size가 2 이외의 컨테이너) T는 사이즈가 20’인 컨테이너의 합계 (Size가 2로 표시되는 컨테이너 S/TTL(F/T) VVD와 POL별 Container 총 합계 OP Outbound P/UP 이벤트 BKG S/TTL(F/T) VVD와 POL별 Booking
			 * Volume 총 합계 OC Outbound CY Gate In 이벤트 EN + TN En Route 이벤트 (CY간 이동) Port CY Port CY의 OC인 합계 VL Vessel Loading 이벤트 Other 기타 Movement의 합계 MT Empty Return 이벤트 G/TTL(F/T) Container 전체 합계
			 * BKG G/TTL(F/T) BKG Volume 전체 합계
			 */

			if (JSPUtil.getNull(colValues.get("cnmv_sts_cd")).equals("OP")) {
				if (JSPUtil.getNull(colValues.get("cntr_tpsz_cd_mv")).indexOf("2") > 0) {
					s_a13 = s_a13 + stringToDouble(JSPUtil.getNull(colValues.get("cntr_vol_qty")));
				} else {
					s_a12 = s_a12 + stringToDouble(JSPUtil.getNull(colValues.get("cntr_vol_qty")));
				}
			} else if (JSPUtil.getNull(colValues.get("cnmv_sts_cd")).equals("OC")) {
				if (JSPUtil.getNull(colValues.get("cntr_tpsz_cd_mv")).indexOf("2") > 0) {
					s_a15 = s_a15 + stringToDouble(JSPUtil.getNull(colValues.get("cntr_vol_qty")));
				} else {
					s_a14 = s_a14 + stringToDouble(JSPUtil.getNull(colValues.get("cntr_vol_qty")));
				}
			} else if (JSPUtil.getNull(colValues.get("cnmv_sts_cd")).equals("EN") || JSPUtil.getNull(colValues.get("cnmv_sts_cd")).equals("TN")) {
				if (JSPUtil.getNull(colValues.get("cntr_tpsz_cd_mv")).indexOf("2") > 0) {
					s_a17 = s_a17 + stringToDouble(JSPUtil.getNull(colValues.get("cntr_vol_qty")));
				} else {
					s_a16 = s_a16 + stringToDouble(JSPUtil.getNull(colValues.get("cntr_vol_qty")));
				}
			} else if (JSPUtil.getNull(colValues.get("cnmv_sts_cd")).equals("CY")) {
				if (JSPUtil.getNull(colValues.get("cntr_tpsz_cd_mv")).indexOf("2") > 0) {
					s_a23 = s_a23 + stringToDouble(JSPUtil.getNull(colValues.get("cntr_vol_qty")));
				} else {
					s_a22 = s_a22 + stringToDouble(JSPUtil.getNull(colValues.get("cntr_vol_qty")));
				}
			} else if (JSPUtil.getNull(colValues.get("cnmv_sts_cd")).equals("VL")) {
				if (JSPUtil.getNull(colValues.get("cntr_tpsz_cd_mv")).indexOf("2") > 0) {
					s_a25 = s_a25 + stringToDouble(JSPUtil.getNull(colValues.get("cntr_vol_qty")));
				} else {
					s_a24 = s_a24 + stringToDouble(JSPUtil.getNull(colValues.get("cntr_vol_qty")));
				}
			} else if (JSPUtil.getNull(colValues.get("cnmv_sts_cd")).equals("MT")) {
				if (JSPUtil.getNull(colValues.get("cntr_tpsz_cd_mv")).indexOf("2") > 0) {
					s_a29 = s_a29 + stringToDouble(JSPUtil.getNull(colValues.get("cntr_vol_qty")));
				} else {
					s_a28 = s_a28 + stringToDouble(JSPUtil.getNull(colValues.get("cntr_vol_qty")));
				}
			} else {
				if (JSPUtil.getNull(colValues.get("cntr_tpsz_cd_mv")).indexOf("2") > 0) {
					s_a27 = s_a27 + stringToDouble(JSPUtil.getNull(colValues.get("cntr_vol_qty")));
				} else {
					s_a26 = s_a26 + stringToDouble(JSPUtil.getNull(colValues.get("cntr_vol_qty")));
				}
			}

			if (!groupByTitle.equals(groupByTemp)) {
				// OrderBy XML생성
				sbufXML.append(" <TR MERGE=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n");
				sbufXML.append("		<TD BOLD='TRUE' DATA-ALIGN='daLeft' EDIT='false'><![CDATA[").append(groupByTemp).append("]]></TD>\n");
				/* sbufXML.append("  		<TD DATA-TYPE=\"dtData\"><![CDATA[0]]></TD>\n"); */
				for (int j = 0; j < 25; j++) {
					sbufXML.append("		<TD DATA-ALIGN='daLeft' EDIT='false'><![CDATA[").append(groupByTemp).append("]]></TD>\n");
				}

				sbufXML.append("	</TR>\n");
				sbufXML.append("	\n");
				sbufXML.append(" <TR MERGE=\"TRUE\" HIDDEN='TRUE'>\n");
				sbufXML.append("	</TR>\n");
				sbufXML.append("	\n");
			}

			sbufXML.append("	<TR >\n");

			if (colValues0 != null && JSPUtil.getNull(colValues.get("bkg_no")).equals(JSPUtil.getNull(colValues0.get("bkg_no")))
					&& JSPUtil.getNull(colValues.get("bkg_sts_cd")).equals(JSPUtil.getNull(colValues0.get("bkg_sts_cd")))
					&& JSPUtil.getNull(colValues.get("cntr_tpsz_cd")).equals(JSPUtil.getNull(colValues0.get("cntr_tpsz_cd")))
					&& JSPUtil.getNull(colValues.get("por_cd")).equals(JSPUtil.getNull(colValues0.get("por_cd")))
					&& JSPUtil.getNull(colValues.get("trunk_pod_cd")).equals(JSPUtil.getNull(colValues0.get("trunk_pod_cd")))  // 2014.08.06 CHM-201431231
					&& JSPUtil.getNull(colValues.get("pod_cd")).equals(JSPUtil.getNull(colValues0.get("pod_cd")))
					&& JSPUtil.getNull(colValues.get("del_cd")).equals(JSPUtil.getNull(colValues0.get("del_cd")))
					&& JSPUtil.getNull(colValues.get("rcv_term_cd")).equals(JSPUtil.getNull(colValues0.get("rcv_term_cd")))) {
				sbufXML.append("		<TD></TD>\n");
				sbufXML.append("  		<TD EDIT=\"FALSE\"></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(rowNum).append("]]></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("vvd_cd"))).append("]]></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("trd_cd"))).append("]]></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("sub_trd_cd"))).append("]]></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("rlane_cd"))).append("]]></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("bkg_no"))).append("]]></TD>\n");

				sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("bkg_sts_cd"))).append("]]></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("por_cd"))).append("]]></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("trunk_pod_cd"))).append("]]></TD>\n");    // 2014.08.06 CHM-201431231
				sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("pod_cd"))).append("]]></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("del_cd"))).append("]]></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("rcv_term_cd_mv"))).append("]]></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("de_term_cd_mv"))).append("]]></TD>\n");

				sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("cntr_tpsz_cd"))).append("]]></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\" DATA-ALIGN='daRight'><![CDATA[").append(JSPUtil.getNull(colValues.get("op_cntr_qty"))).append("]]></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\" DATA-ALIGN='daRight'><![CDATA[").append(JSPUtil.getNull(colValues.get("rd_cntr_qty"))).append("]]></TD>\n");

			} else {

				/************************************************************/
				if (JSPUtil.getNull(colValues.get("cntr_tpsz_cd")).indexOf("2") > 0) {
					s_a21 = s_a21 + stringToDouble(JSPUtil.getNull(colValues.get("op_cntr_qty")));
				} else {
					s_a20 = s_a20 + stringToDouble(JSPUtil.getNull(colValues.get("op_cntr_qty")));
				}
				/************************************************************/

				sbufXML.append("		<TD><![CDATA[").append("R").append("]]></TD>\n");
				sbufXML.append("  		<TD  DATA-TYPE=\"dtCheckBox\"><![CDATA[0]]></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(rowNum).append("]]></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("vvd_cd"))).append("]]></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("trd_cd"))).append("]]></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("sub_trd_cd"))).append("]]></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("rlane_cd"))).append("]]></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("bkg_no"))).append("]]></TD>\n");

				sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("bkg_sts_cd"))).append("]]></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("por_cd"))).append("]]></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("trunk_pod_cd"))).append("]]></TD>\n");   // 2014.08.06 CHM-201431231
				sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("pod_cd"))).append("]]></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("del_cd"))).append("]]></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("rcv_term_cd_mv"))).append("]]></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("de_term_cd_mv"))).append("]]></TD>\n");

				sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("cntr_tpsz_cd"))).append("]]></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\" DATA-ALIGN='daRight'><![CDATA[").append(JSPUtil.getNull(colValues.get("op_cntr_qty"))).append("]]></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\" DATA-ALIGN='daRight'><![CDATA[").append(JSPUtil.getNull(colValues.get("rd_cntr_qty"))).append("]]></TD>\n");
				rowNum++;

			}

			sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("cntr_no"))).append("]]></TD>\n");
			sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("cntr_tpsz_cd_mv"))).append("]]></TD>\n");
			sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("cntr_check"))).append("]]></TD>\n");
			sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("rcv_term_cd"))).append("]]></TD>\n");

			sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("de_term_cd"))).append("]]></TD>\n");
			sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("cnmv_sts_cd"))).append("]]></TD>\n");
			sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("org_yd_cd"))).append("]]></TD>\n");
			sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("cnmv_evnt_dt"))).append("]]></TD>\n");
			sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("clm_sght_cd"))).append("]]></TD>\n");

			sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("arr_loc_nm"))).append("]]></TD>\n");
			sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("arr_ste_cd"))).append("]]></TD>\n");
			sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("arr_dt"))).append("]]></TD>\n");
			sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("dep_dt"))).append("]]></TD>\n");
			sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("cust_nm"))).append("]]></TD>\n");

			sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("dg_sts"))).append("]]></TD>\n");
			sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("dg"))).append("]]></TD>\n");
			sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("rf_sts"))).append("]]></TD>\n");
			sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("rf"))).append("]]></TD>\n");
			sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("pwr_spl_cbl_flg"))).append("]]></TD>\n");
			sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("ak_sts"))).append("]]></TD>\n");
			sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("ak"))).append("]]></TD>\n");
			sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("vsl_pre_pst_cd"))).append("]]></TD>\n");
			sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("cntr_prt_flg"))).append("]]></TD>\n");
			sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("cop_no"))).append("]]></TD>\n");
			sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("cbkg_no"))).append("]]></TD>\n");
			sbufXML.append("		<TD EDIT=\"FALSE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("clm_dt"))).append("]]></TD>\n");
			
			sbufXML.append("	</TR>\n");
			sbufXML.append("	\n");

			colValues0 = vos.get(i).getColumnValues();

			sbufXML.append(" <TR MERGE=\"TRUE\" HIDDEN='TRUE'>\n");
			sbufXML.append("	</TR>\n");
			sbufXML.append("	\n");

			// 이전 GroupBy Title과 현재 데이타의 값이 틀리면 제목을 새로 생성한다.
			if (!groupByTemp2.equals(groupByTemp)) {

				/**************************** 1 ************************************/
				sbufXML.append("	<TR >\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"></TD>\n");
				sbufXML.append("  		<TD EDIT=\"FALSE\" BGCOLOR=\"229, 234, 255\">S/TTL(F/T)</TD>\n"); // dtCheckBox
				sbufXML.append("		<TD EDIT=\"FALSE\" DATA-ALIGN='daRight' BOLD='TRUE'><![CDATA[").append(getRound(s_a10, 2)).append("]]></TD>\n"); // rnum
				sbufXML.append("		<TD EDIT=\"FALSE\" DATA-ALIGN='daRight' BOLD='TRUE'><![CDATA[").append(getRound(s_a11, 2)).append("]]></TD>\n"); // bkg_no

				sbufXML.append("		<TD EDIT=\"FALSE\" BGCOLOR=\"229, 234, 255\">OP</TD>\n"); // bkg_sts_cd
				sbufXML.append("		<TD EDIT=\"FALSE\" DATA-ALIGN='daRight' BOLD='TRUE'><![CDATA[").append(getRound(s_a12, 2)).append("]]></TD>\n"); // por_cd
				sbufXML.append("		<TD EDIT=\"FALSE\" DATA-ALIGN='daRight' BOLD='TRUE'><![CDATA[").append(getRound(s_a13, 2)).append("]]></TD>\n"); // pod_cd
				sbufXML.append("		<TD EDIT=\"FALSE\" BGCOLOR=\"229, 234, 255\">OC</TD>\n"); // rcv_term_cd
				sbufXML.append("		<TD EDIT=\"FALSE\" DATA-ALIGN='daRight' BOLD='TRUE'><![CDATA[").append(getRound(s_a14, 2)).append("]]></TD>\n"); // de_term_cd

				sbufXML.append("		<TD EDIT=\"FALSE\" DATA-ALIGN='daRight' BOLD='TRUE'><![CDATA[").append(getRound(s_a15, 2)).append("]]></TD>\n"); // cntr_tpsz_cd
				sbufXML.append("		<TD EDIT=\"FALSE\" BGCOLOR=\"229, 234, 255\">EN+TN</TD>\n"); // op_cntr_qty
				sbufXML.append("		<TD EDIT=\"FALSE\" DATA-ALIGN='daRight' BOLD='TRUE'><![CDATA[").append(getRound(s_a16, 2)).append("]]></TD>\n"); // cntr_no
				sbufXML.append("		<TD EDIT=\"FALSE\" DATA-ALIGN='daRight' BOLD='TRUE'><![CDATA[").append(getRound(s_a17, 2)).append("]]></TD>\n"); // cntr_tpsz_cd_mv
				sbufXML.append("		<TD EDIT=\"FALSE\" ></TD>\n"); // rcv_term_cd_mv

				sbufXML.append("		<TD EDIT=\"FALSE\"></TD>\n"); // de_term_cd_mv
				sbufXML.append("		<TD EDIT=\"FALSE\"></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"></TD>\n");

				sbufXML.append("		<TD EDIT=\"FALSE\"></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"></TD>\n");

				sbufXML.append("		<TD EDIT=\"FALSE\"></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"></TD>\n");

				sbufXML.append("	</TR>\n");
				sbufXML.append("	\n");
				sbufXML.append(" <TR MERGE=\"TRUE\" HIDDEN='TRUE'>\n");
				sbufXML.append("	</TR>\n");
				sbufXML.append("	\n");
				/************************** 2 ***************************************/
				sbufXML.append("	<TR >\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"></TD>\n");
				sbufXML.append("  		<TD EDIT=\"FALSE\" BGCOLOR=\"229, 234, 255\">BKG S/TTL(F/T)</TD>\n"); // dtCheckBox
				sbufXML.append("		<TD EDIT=\"FALSE\" DATA-ALIGN='daRight' BOLD='TRUE'><![CDATA[").append(getRound(s_a20, 2)).append("]]></TD>\n"); // rnum
				sbufXML.append("		<TD EDIT=\"FALSE\" DATA-ALIGN='daRight' BOLD='TRUE'><![CDATA[").append(getRound(s_a21, 2)).append("]]></TD>\n"); // bkg_no

				sbufXML.append("		<TD EDIT=\"FALSE\" BGCOLOR=\"229, 234, 255\">Port CY</TD>\n"); // bkg_sts_cd
				sbufXML.append("		<TD EDIT=\"FALSE\" DATA-ALIGN='daRight' BOLD='TRUE'><![CDATA[").append(getRound(s_a22, 2)).append("]]></TD>\n"); // por_cd
				sbufXML.append("		<TD EDIT=\"FALSE\" DATA-ALIGN='daRight' BOLD='TRUE'><![CDATA[").append(getRound(s_a23, 2)).append("]]></TD>\n"); // pod_cd
				sbufXML.append("		<TD EDIT=\"FALSE\" BGCOLOR=\"229, 234, 255\">VL</TD>\n"); // rcv_term_cd
				sbufXML.append("		<TD EDIT=\"FALSE\" DATA-ALIGN='daRight' BOLD='TRUE'><![CDATA[").append(getRound(s_a24, 2)).append("]]></TD>\n"); // de_term_cd

				sbufXML.append("		<TD EDIT=\"FALSE\" DATA-ALIGN='daRight' BOLD='TRUE'><![CDATA[").append(getRound(s_a25, 2)).append("]]></TD>\n"); // cntr_tpsz_cd
				sbufXML.append("		<TD EDIT=\"FALSE\" BGCOLOR=\"229, 234, 255\">Other</TD>\n"); // op_cntr_qty
				sbufXML.append("		<TD EDIT=\"FALSE\" DATA-ALIGN='daRight' BOLD='TRUE'><![CDATA[").append(getRound(s_a26, 2)).append("]]></TD>\n"); // cntr_no
				sbufXML.append("		<TD EDIT=\"FALSE\" DATA-ALIGN='daRight' BOLD='TRUE'><![CDATA[").append(getRound(s_a27, 2)).append("]]></TD>\n"); // cntr_tpsz_cd_mv
				sbufXML.append("		<TD EDIT=\"FALSE\" BGCOLOR=\"229, 234, 255\">MT</TD>\n"); // rcv_term_cd_mv

				sbufXML.append("		<TD EDIT=\"FALSE\" DATA-ALIGN='daRight' BOLD='TRUE'><![CDATA[").append(getRound(s_a28, 2)).append("]]></TD>\n"); // de_term_cd_mv
				sbufXML.append("		<TD EDIT=\"FALSE\" DATA-ALIGN='daRight' BOLD='TRUE'><![CDATA[").append(getRound(s_a29, 2)).append("]]></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"></TD>\n");

				sbufXML.append("		<TD EDIT=\"FALSE\"></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\" ></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"></TD>\n");

				sbufXML.append("		<TD EDIT=\"FALSE\"></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"></TD>\n");
				sbufXML.append("		<TD EDIT=\"FALSE\"></TD>\n");

				sbufXML.append("	</TR>\n");
				sbufXML.append("	\n");
				/*****************************************************************/

				s_a10 = 0.0;
				s_a11 = 0.0;
				s_a12 = 0.0;
				s_a13 = 0.0;
				s_a14 = 0.0;
				s_a15 = 0.0;
				s_a16 = 0.0;
				s_a17 = 0.0;
				s_a20 = 0.0;
				s_a21 = 0.0;
				s_a22 = 0.0;
				s_a23 = 0.0;
				s_a24 = 0.0;
				s_a25 = 0.0;
				s_a26 = 0.0;
				s_a27 = 0.0;
				s_a28 = 0.0;
				s_a29 = 0.0;

			}
			groupByTitle = groupByTemp;
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
				if (i == 0) {
					sb.append(makeDataTag(tmpList, prefixs[i]));
				} else {
					// sb.append("|$$|<SHEET>\n");
					sb.append(getStartTag(isFirstSheet, isSave, eventResponse));
					sb.append(makeDataTagDefault(tmpList, prefixs[i]));
					// sb.append("</SHEET>\n");
					sb.append(getEndTag(sb));
				}
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
