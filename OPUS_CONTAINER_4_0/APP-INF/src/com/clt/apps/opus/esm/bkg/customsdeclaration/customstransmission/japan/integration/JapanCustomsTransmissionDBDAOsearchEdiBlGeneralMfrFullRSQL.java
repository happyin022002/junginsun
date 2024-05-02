/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : JapanCustomsTransmissionDBDAOsearchEdiBlGeneralMfrFullRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.09
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanCustomsTransmissionDBDAOsearchEdiBlGeneralMfrFullRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public JapanCustomsTransmissionDBDAOsearchEdiBlGeneralMfrFullRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_split_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_call_sgn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.integration").append("\n"); 
		query.append("FileName : JapanCustomsTransmissionDBDAOsearchEdiBlGeneralMfrFullRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT --06.Vessel Code (9)" ).append("\n"); 
		query.append("       RPAD(NVL(SUBSTR(@[in_call_sgn_no], 1, 9), ' '), 9, ' ') AS DATA00," ).append("\n"); 
		query.append("       --07.Operating Carrier Voyage Number (10)" ).append("\n"); 
		query.append("       RPAD(NVL(JP_TML_VSL_NO, SUBSTR(@[in_vvd_cd], 5, 5)), 10, ' ') AS DATA01," ).append("\n"); 
		query.append("       --08.Voyage Number (10)" ).append("\n"); 
		query.append("       RPAD(NVL(JP_TML_VSL_NO, SUBSTR(@[in_vvd_cd], 5, 5)), 10, ' ') AS DATA02," ).append("\n"); 
		query.append("       --09.Consortium Voyage Number (10)" ).append("\n"); 
		query.append("       RPAD(NVL(JP_TML_VSL_NO, ' '), 10, ' ') AS DATA03," ).append("\n"); 
		query.append("       --10.Carrier Code (4)" ).append("\n"); 
		query.append("       COM_ConstantMgr_PKG.COM_getScacCode_FNC() AS DATA04," ).append("\n"); 
		query.append("       --------------------------------------------------------------------" ).append("\n"); 
		query.append("       --14.Container Operator Code (5)" ).append("\n"); 
		query.append("       RPAD(NVL(A.CY_OPR_ID, ' '), 5, ' ') AS DATA05," ).append("\n"); 
		query.append("       --15.B/L Number (35)" ).append("\n"); 
		query.append("       RPAD(COM_ConstantMgr_PKG.COM_getScacCode_FNC()||@[bl_no], 35, ' ') AS DATA06," ).append("\n"); 
		query.append("       --16.Port of Loading Code (5)" ).append("\n"); 
		query.append("       CASE" ).append("\n"); 
		query.append("          WHEN SUBSTR(L1.LOC_CD, 1, 2) = 'JP' THEN" ).append("\n"); 
		query.append("             NVL(L3.ATTR_CTNT2, L1.LOC_CD)" ).append("\n"); 
		query.append("          ELSE" ).append("\n"); 
		query.append("             NVL(L3.ATTR_CTNT2, DECODE(SUBSTR(L1.LOC_CD, 1, 2), 'AW', 'AN', 'CS', 'CB', 'EU', 'ZY', 'KZ', 'KA', 'LI', 'ZY', 'RU', 'RS', 'TJ', 'TA', 'UA', 'UK', 'UZ', 'UB', 'YU', 'YE', SUBSTR(L1.LOC_CD, 1, 2))||'ZZZ')" ).append("\n"); 
		query.append("       END AS DATA07," ).append("\n"); 
		query.append("       --17.Final Destination Code (5)" ).append("\n"); 
		query.append("       RPAD(' ', 5, ' ') AS DATA08," ).append("\n"); 
		query.append("       --18.Final Destination Name (20)" ).append("\n"); 
		query.append("       RPAD(' ', 20, ' ') AS DATA09," ).append("\n"); 
		query.append("       --19.Place of Delivery Code (5)" ).append("\n"); 
		query.append("       CASE" ).append("\n"); 
		query.append("          WHEN SUBSTR(L2.LOC_CD, 1, 2) = 'JP' THEN" ).append("\n"); 
		query.append("             NVL(L4.ATTR_CTNT2, L2.LOC_CD)" ).append("\n"); 
		query.append("          ELSE" ).append("\n"); 
		query.append("             NVL(L4.ATTR_CTNT2, DECODE(SUBSTR(L2.LOC_CD, 1, 2), 'AW', 'AN', 'CS', 'CB', 'EU', 'ZY', 'KZ', 'KA', 'LI', 'ZY', 'RU', 'RS', 'TJ', 'TA', 'UA', 'UK', 'UZ', 'UB', 'YU', 'YE', SUBSTR(L2.LOC_CD, 1, 2))||'ZZZ')" ).append("\n"); 
		query.append("       END AS DATA10," ).append("\n"); 
		query.append("       --20.Place of Delivery Name (20)" ).append("\n"); 
		query.append("       RPAD(SUBSTR(UPPER(L2.LOC_NM), 1, 20), 20, ' ') AS DATA11," ).append("\n"); 
		query.append("       --------------------------------------------------------------------" ).append("\n"); 
		query.append("       --52.HS Code (The First 6-digit) (6)" ).append("\n"); 
		query.append("       (SELECT NVL(SUBSTR(MAX(CMDT_HS_CD), 1, 6), '      ')" ).append("\n"); 
		query.append("          FROM BKG_CNTR_MF_DESC" ).append("\n"); 
		query.append("         WHERE BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("           AND CNTR_MF_WGT IN (SELECT MAX(CMD.CNTR_MF_WGT)" ).append("\n"); 
		query.append("                                 FROM BKG_CNTR_MF_DESC CMD" ).append("\n"); 
		query.append("                                WHERE CMD.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                                  AND SUBSTR(CMD.CMDT_HS_CD, 1, 2) NOT IN ('00', '98', '99'))" ).append("\n"); 
		query.append("           AND SUBSTR(CMDT_HS_CD, 1, 2) NOT IN ('00', '98', '99')) AS DATA12," ).append("\n"); 
		query.append("       --54.Number of Packages (8)" ).append("\n"); 
		query.append("       LPAD(NVL(A.PCK_QTY, 0), 8, ' ') AS DATA13," ).append("\n"); 
		query.append("       --55.Number of Packages Unit Code (3)" ).append("\n"); 
		query.append("       RPAD(NVL(P.CSTMS_PCK_TP_CD, 'ZZ'), 3, ' ') AS DATA14," ).append("\n"); 
		query.append("       --56.Gross Weight (10)" ).append("\n"); 
		query.append("       LPAD(TO_CHAR(NVL(A.GRS_WGT, 0), 'FM999990.000'), 10, ' ') AS DATA15," ).append("\n"); 
		query.append("       --57.Weight Unit Code (3)" ).append("\n"); 
		query.append("       DECODE(NVL(A.WGT_UT_CD, 'KGS'), 'LBS', 'LBR', 'KGS', 'KGM', A.WGT_UT_CD ) AS DATA16," ).append("\n"); 
		query.append("       --58.Net Weight (10)" ).append("\n"); 
		query.append("       RPAD(' ', 10, ' ') AS DATA17," ).append("\n"); 
		query.append("       --59.Weight Unit Code (3)" ).append("\n"); 
		query.append("       RPAD(' ', 3, ' ') AS DATA18," ).append("\n"); 
		query.append("       --60.Measurement (10)" ).append("\n"); 
		query.append("       LPAD(TO_CHAR(NVL(A.MEAS_QTY, 0), 'FM999990.000'), 10, ' ') AS DATA19," ).append("\n"); 
		query.append("       --61.Measurement Unit Code (3)" ).append("\n"); 
		query.append("       DECODE(NVL(A.MEAS_UT_CD, 'CBM'), 'CMF', 'FTQ', 'MTQ') AS DATA20," ).append("\n"); 
		query.append("       --62.Country of Origin Code (2)" ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA21," ).append("\n"); 
		query.append("       --63.Dangerous Cargo Code (3)" ).append("\n"); 
		query.append("       RPAD(' ', 3, ' ') AS DATA22," ).append("\n"); 
		query.append("       --64.Freight (18)" ).append("\n"); 
		query.append("       RPAD(' ', 18, ' ') AS DATA23," ).append("\n"); 
		query.append("       --65.Freight Currency Code (3)" ).append("\n"); 
		query.append("       RPAD(' ', 3, ' ') AS DATA24," ).append("\n"); 
		query.append("       --66.Value (18)" ).append("\n"); 
		query.append("       RPAD(' ', 18, ' ') AS DATA25," ).append("\n"); 
		query.append("       --67.Value Currency Code (3)" ).append("\n"); 
		query.append("       RPAD(' ', 3, ' ') AS DATA26," ).append("\n"); 
		query.append("       --------------------------------------------------------------------" ).append("\n"); 
		query.append("       --68.Comprehensive In-Bond Transportation Approval Number (11)" ).append("\n"); 
		query.append("       RPAD(NVL(A.APRO_NO, ' '), 11, ' ') AS DATA27," ).append("\n"); 
		query.append("       --69.Temporary Discharge Identifier (3)" ).append("\n"); 
		query.append("       DECODE(NVL(A.LOCL_TS_IND_CD, 'L'), 'T', '28 ', '   ') AS DATA28," ).append("\n"); 
		query.append("       --70.Reason for Temporary Discharge Code (3)" ).append("\n"); 
		query.append("       DECODE(NVL(A.LOCL_TS_IND_CD, ' '), 'T', NVL(A.JP_CSTMS_TRNS_CD, ' '), '   ') AS DATA29," ).append("\n"); 
		query.append("       --71.Duration of Temporary Discharge (2)" ).append("\n"); 
		query.append("       DECODE(NVL(A.LOCL_TS_IND_CD, ' '), 'T', SUBSTR(TO_CHAR(NVL(A.LMT_NO, 0), '99'), 2), '  ') AS DATA30," ).append("\n"); 
		query.append("       --72.Estimated Start Date of Transportation (8)" ).append("\n"); 
		query.append("       RPAD(' ', 8, ' ') AS DATA31," ).append("\n"); 
		query.append("       --73.Estimated Finish Date of Transportation (8)" ).append("\n"); 
		query.append("       RPAD(' ', 8, ' ') AS DATA32," ).append("\n"); 
		query.append("       --74.Code of Transportation Mode of Separate Transit/In-Bond Transportation of Temporary Discharge Cargo (2)" ).append("\n"); 
		query.append("       RPAD(NVL(DECODE(A.TRSP_MOD_CD, 'SH', '11', 'BA', '16', 'RA', '25', 'TR', '31', 'OT', '17', NULL), ' '), 2, ' ') AS DATA33," ).append("\n"); 
		query.append("       --75.Arrival Place Code (5)" ).append("\n"); 
		query.append("       RPAD(NVL(A.CSTMS_CD, ' '), 5, ' ') AS DATA34," ).append("\n"); 
		query.append("       --76.Arrival Place Name (35)" ).append("\n"); 
		query.append("       RPAD(NVL((SELECT NVL(WH_NM, ' ')" ).append("\n"); 
		query.append("                   FROM BKG_CSTMS_JP_WH" ).append("\n"); 
		query.append("                  WHERE CSTMS_CD = A.CSTMS_CD" ).append("\n"); 
		query.append("                    AND ROWNUM = 1), ' '), 35, ' ') AS DATA35," ).append("\n"); 
		query.append("       --77.Code of Other Relevant Laws and Ordinances (2) x5" ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA36," ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA37," ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA38," ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA39," ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA40," ).append("\n"); 
		query.append("       --78.Remark (140)" ).append("\n"); 
		query.append("       RPAD(' ', 140, ' ') AS DATA41" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_JP_BL A," ).append("\n"); 
		query.append("       BKG_BOOKING B," ).append("\n"); 
		query.append("       MDM_LOCATION L1," ).append("\n"); 
		query.append("       MDM_LOCATION L2," ).append("\n"); 
		query.append("       BKG_CSTMS_PCK_TP_CONV P," ).append("\n"); 
		query.append("       BKG_CSTMS_CD_CONV_CTNT L3," ).append("\n"); 
		query.append("       BKG_CSTMS_CD_CONV_CTNT L4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE A.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("   AND A.BL_SPLIT_NO = NVL(@[bl_split_no], '  ')" ).append("\n"); 
		query.append("   AND A.BL_NO = B.BL_NO" ).append("\n"); 
		query.append("   AND A.POL_CD = L1.LOC_CD(+)" ).append("\n"); 
		query.append("   AND A.BKG_DEL_CD = L2.LOC_CD(+)" ).append("\n"); 
		query.append("   AND L3.CNT_CD(+) = 'JP'" ).append("\n"); 
		query.append("   AND L3.CSTMS_DIV_ID(+) = 'JAPAN_LOC'" ).append("\n"); 
		query.append("   AND A.POL_CD = L3.ATTR_CTNT1(+)" ).append("\n"); 
		query.append("   AND L4.CNT_CD(+) = 'JP'" ).append("\n"); 
		query.append("   AND L4.CSTMS_DIV_ID(+) = 'JAPAN_LOC'" ).append("\n"); 
		query.append("   AND A.BKG_DEL_CD = L4.ATTR_CTNT1(+)" ).append("\n"); 
		query.append("   AND A.PCK_TP_CD = P.PCK_TP_CD(+)" ).append("\n"); 
		query.append("   AND P.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("   AND P.CNT_CD(+) = 'JP'" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}