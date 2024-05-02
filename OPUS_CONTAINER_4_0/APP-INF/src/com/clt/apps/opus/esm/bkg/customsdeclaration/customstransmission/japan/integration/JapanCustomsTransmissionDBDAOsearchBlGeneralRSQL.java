/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : JapanCustomsTransmissionDBDAOsearchBlGeneralRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.06
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.06 
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

public class JapanCustomsTransmissionDBDAOsearchBlGeneralRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBlGeneral
	  * </pre>
	  */
	public JapanCustomsTransmissionDBDAOsearchBlGeneralRSQL(){
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
		query.append("FileName : JapanCustomsTransmissionDBDAOsearchBlGeneralRSQL").append("\n"); 
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
		query.append("SELECT RPAD(NVL(SUBSTR(@[in_call_sgn_no], 1, 9), ' '), 9, ' ') AS IN_CALL_SGN_NO," ).append("\n"); 
		query.append("       RPAD(NVL(JP_TML_VSL_NO, SUBSTR(@[in_vvd_cd], 5, 5)), 10, ' ') AS IN_VVD_CD," ).append("\n"); 
		query.append("       RPAD(NVL(JP_TML_VSL_NO, ' '), 10, ' ') AS JP_TML_VSL_NO," ).append("\n"); 
		query.append("       RPAD(' ', 1, ' ') AS DATA1, --7 POD Split No (1)" ).append("\n"); 
		query.append("       RPAD(NVL(A.CY_OPR_ID, ' '), 5, ' ') AS CY_OPR_CD," ).append("\n"); 
		query.append("       RPAD(COM_ConstantMgr_PKG.COM_getScacCode_FNC()||@[bl_no], 35, ' ') AS DATA2," ).append("\n"); 
		query.append("       CASE" ).append("\n"); 
		query.append("          WHEN SUBSTR(L1.LOC_CD, 1, 2) = 'JP' THEN" ).append("\n"); 
		query.append("             NVL(L3.ATTR_CTNT2, L1.LOC_CD)" ).append("\n"); 
		query.append("          ELSE" ).append("\n"); 
		query.append("             DECODE(L3.ATTR_CTNT2, NULL, DECODE(SUBSTR(L1.LOC_CD, 1, 2), 'AW', 'AN', 'CS', 'CB', 'EU', 'ZY', 'KZ', 'KA', 'LI', 'ZY', 'RU', 'RS', 'TJ', 'TA', 'UA', 'UK', 'UZ', 'UB', 'YU', 'YE', SUBSTR(L1.LOC_CD, 1, 2))||'ZZZ', L3.ATTR_CTNT2)" ).append("\n"); 
		query.append("       END AS UN_LOC_ID1," ).append("\n"); 
		query.append("       RPAD(' ', 5, ' ') AS DATA3, --12 Final. DEST Code  (5) C" ).append("\n"); 
		query.append("       RPAD(' ', 20, ' ') AS DATA4, --13 Final. DEST Name  (20) C" ).append("\n"); 
		query.append("       CASE" ).append("\n"); 
		query.append("          WHEN SUBSTR(L2.LOC_CD, 1, 2) = 'JP' THEN" ).append("\n"); 
		query.append("             NVL(L4.ATTR_CTNT2, L2.LOC_CD)" ).append("\n"); 
		query.append("          ELSE" ).append("\n"); 
		query.append("             DECODE(L4.ATTR_CTNT2, NULL, DECODE(SUBSTR(L2.LOC_CD, 1, 2), 'AW', 'AN', 'CS', 'CB', 'EU', 'ZY', 'KZ', 'KA', 'LI', 'ZY', 'RU', 'RS', 'TJ', 'TA', 'UA', 'UK', 'UZ', 'UB', 'YU', 'YE', SUBSTR(L2.LOC_CD, 1, 2))||'ZZZ', L4.ATTR_CTNT2)" ).append("\n"); 
		query.append("       END AS UN_LOC_ID2," ).append("\n"); 
		query.append("       RPAD(SUBSTR(UPPER(L2.LOC_NM), 1, 20), 20, ' ') AS LOC_NM," ).append("\n"); 
		query.append("       --RPAD(' ', 4, ' ') AS DATA5, --47 대표 품목번호  (4)   C" ).append("\n"); 
		query.append("       (SELECT NVL(SUBSTR(MAX(CMDT_HS_CD), 1, 4), '    ')" ).append("\n"); 
		query.append("          FROM BKG_CNTR_MF_DESC" ).append("\n"); 
		query.append("         WHERE BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("           AND CNTR_MF_WGT IN (SELECT MAX(CMD.CNTR_MF_WGT)" ).append("\n"); 
		query.append("                                 FROM BKG_CNTR_MF_DESC CMD" ).append("\n"); 
		query.append("                                WHERE CMD.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                                  AND SUBSTR(CMD.CMDT_HS_CD, 1, 2) NOT IN ('00', '98', '99'))" ).append("\n"); 
		query.append("           AND SUBSTR(CMDT_HS_CD, 1, 2) NOT IN ('00', '98', '99')) AS DATA5, --47 대표 품목번호  (4)   C" ).append("\n"); 
		query.append("       LPAD(NVL(A.PCK_QTY, 0), 8, ' ') AS PCK_QTY," ).append("\n"); 
		query.append("       RPAD(DECODE(P.CSTMS_PCK_TP_CD, NULL, 'ZZ', P.CSTMS_PCK_TP_CD), 3, ' ') AS PCK_CSTMS_CD," ).append("\n"); 
		query.append("       --LPAD(DECODE(NVL(A.GRS_WGT, 0), 0, 0, SUBSTR(TO_CHAR(NVL(A.GRS_WGT, 0), '0999999.999'), 2)), 10, ' ') AS GRS_WGT," ).append("\n"); 
		query.append("       LPAD(TO_CHAR(NVL(A.GRS_WGT, 0), 'FM999990.000'), 10, ' ') AS GRS_WGT," ).append("\n"); 
		query.append("       DECODE(NVL(A.WGT_UT_CD, 'KGS'), 'LBS', 'LBR', 'KGS', 'KGM', A.WGT_UT_CD ) AS WGT_UT_CD," ).append("\n"); 
		query.append("       RPAD(' ', 10, ' ') AS DATA6, --53 인터넷중량  (10)   C" ).append("\n"); 
		query.append("       RPAD(' ', 3, ' ') AS DATA7, --54 중량단위 코드  (3)   C-M" ).append("\n"); 
		query.append("       --LPAD(DECODE(NVL(A.MEAS_QTY, 0), 0, 0, SUBSTR(TO_CHAR(NVL(A.MEAS_QTY, 0), '0999999.999'), 2)), 10, ' ') AS MEAS_QTY," ).append("\n"); 
		query.append("       LPAD(TO_CHAR(NVL(A.MEAS_QTY, 0), 'FM999990.000'), 10, ' ') AS MEAS_QTY," ).append("\n"); 
		query.append("       DECODE(NVL(A.MEAS_UT_CD, 'CBM'), 'CMF', 'FTQ', 'MTQ') AS MEAS_UT_CD," ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA8, --57 원산국 코드  (2)   C" ).append("\n"); 
		query.append("       RPAD(' ', 3, ' ') AS DATA9, --58 위험화물등 코드  (3)   C" ).append("\n"); 
		query.append("       RPAD(' ', 18, ' ') AS DATA10, --59 해상운임(후레토】)  (18)   C" ).append("\n"); 
		query.append("       RPAD(' ', 3, ' ') AS DATA11, --60 해상운임통화종별코드  (3)   M" ).append("\n"); 
		query.append("       RPAD(' ', 18, ' ') AS DATA12, --61 가격  (18)   C" ).append("\n"); 
		query.append("       RPAD(' ', 3, ' ') AS DATA13, --62 가격통화종별코드  (3)   C-M" ).append("\n"); 
		query.append("       RPAD(NVL(A.APRO_NO, ' '), 11, ' ') AS DATA14, --63 포괄 보세 운송 승인 번호 (11) C" ).append("\n"); 
		query.append("       DECODE(NVL(A.LOCL_TS_IND_CD, 'L'), 'T', '28 ', '   ') AS LOCL_TS_FLG1," ).append("\n"); 
		query.append("       DECODE(NVL(A.LOCL_TS_IND_CD, ' '), 'T', NVL(A.JP_CSTMS_TRNS_CD, ' '), '   ') AS LOCL_TS_FLG2," ).append("\n"); 
		query.append("       DECODE(NVL(A.LOCL_TS_IND_CD, ' '), 'T', SUBSTR(TO_CHAR(NVL(A.LMT_NO, 0), '99'), 2), '  ') AS LOCL_TS_FLG3," ).append("\n"); 
		query.append("       RPAD(' ', 8, ' ') AS DATA15, --67 운송 기간시작 예정일  (8)   C" ).append("\n"); 
		query.append("       RPAD(' ', 8, ' ') AS DATA16, --68 운송 기간종료 예정일  (8)   C" ).append("\n"); 
		query.append("       --RPAD(NVL(A.TRSP_MOD_CD, ' '), 2, ' ') DATA17, --69 개별운송 또는 가양육 화물보세 운송의 운송 도구 코드 (2) C" ).append("\n"); 
		query.append("       RPAD(NVL(DECODE(A.TRSP_MOD_CD, 'SH', '11', 'BA', '16', 'RA', '25', 'TR', '31', 'OT', '17', NULL), ' '), 2, ' ') AS DATA17, --69 개별운송 또는 가양육 화물보세 운송의 운송 도구 코드 (2) C" ).append("\n"); 
		query.append("       RPAD(NVL(A.CSTMS_CD, ' '), 5, ' ') AS DATA18, --70 도착지코드 (5) C" ).append("\n"); 
		query.append("       RPAD(NVL((SELECT NVL(WH_NM, ' ')" ).append("\n"); 
		query.append("                   FROM BKG_CSTMS_JP_WH" ).append("\n"); 
		query.append("                  WHERE CSTMS_CD = A.CSTMS_CD" ).append("\n"); 
		query.append("                    AND ROWNUM = 1), ' '), 35, ' ') AS DATA19, --71 도착지명 (35) C" ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA20, --72 타법령 코드  (2)   5[반복]   C" ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA21, --72 타법령 코드  (2)   5[반복]   C" ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA22, --72 타법령 코드  (2)   5[반복]   C" ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA23, --72 타법령 코드  (2)   5[반복]   C" ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA24, --72 타법령 코드  (2)   5[반복]   C" ).append("\n"); 
		query.append("       RPAD(' ', 140, ' ') AS DATA25 --73 기사  (140)   C" ).append("\n"); 
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