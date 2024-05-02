/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : Jp24CustomsTransmissionDBDAOSearchEdiAdvJpBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Jp24CustomsTransmissionDBDAOSearchEdiAdvJpBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public Jp24CustomsTransmissionDBDAOSearchEdiAdvJpBlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_split_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_split_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.integration").append("\n"); 
		query.append("FileName : Jp24CustomsTransmissionDBDAOSearchEdiAdvJpBlRSQL").append("\n"); 
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
		query.append("SELECT -- 03 Service provider code" ).append("\n"); 
		query.append("       RPAD(' ', 16, ' ') AS DATA00," ).append("\n"); 
		query.append("       -- 04 Call sign" ).append("\n"); 
		query.append("--       RPAD(NVL(SUBSTR(DECODE(SUBSTR(VVD.POD_CD, 1,2), 'JP', VSL.CALL_SGN_NO, ''), 1, 9), ' '), 9, ' ') AS DATA01," ).append("\n"); 
		query.append("       RPAD(NVL(SUBSTR(JVSL.CALL_SGN_NO, 1, 9), ' '), 9, ' ') AS DATA01," ).append("\n"); 
		query.append("       -- 05 vessel name" ).append("\n"); 
		query.append("       RPAD(NVL(SUBSTR(VSL.VSL_ENG_NM, 1, 35), ' '), 35, ' ') AS DATA02," ).append("\n"); 
		query.append("       -- 06 vessel contury" ).append("\n"); 
		query.append("       RPAD(NVL(DECODE(SUBSTR(VSL.VSL_RGST_CNT_CD, 1, 2),'IM', 'GB', SUBSTR(VSL.VSL_RGST_CNT_CD, 1, 2)), ' '), 2, ' ') AS DATA03," ).append("\n"); 
		query.append("       -- 07 voyage no" ).append("\n"); 
		query.append("       RPAD(DECODE(JVSL.IB_CSSM_VOY_NO, NULL, SUBSTR(@[vvd], 5, 5), JVSL.IB_CSSM_VOY_NO), 10, ' ') AS DATA04," ).append("\n"); 
		query.append("       -- 07_1 CONSORTIUM VOYAGE NUMBER" ).append("\n"); 
		query.append("       RPAD(NVL(JVSL.IB_CSSM_VOY_NO, ' '), 10, ' ') AS DATA05," ).append("\n"); 
		query.append("       -- 08 company code" ).append("\n"); 
		query.append("       COM_ConstantMgr_PKG.COM_getScacCode_FNC() AS DATA06," ).append("\n"); 
		query.append("       -- 09 loading loc" ).append("\n"); 
		query.append("       CASE" ).append("\n"); 
		query.append("          WHEN SUBSTR(L1.LOC_CD, 1, 2) = 'JP' THEN" ).append("\n"); 
		query.append("             NVL(H1.ATTR_CTNT2, L1.LOC_CD)" ).append("\n"); 
		query.append("          ELSE" ).append("\n"); 
		query.append("             DECODE(H1.ATTR_CTNT2, NULL, DECODE(SUBSTR(L1.LOC_CD, 1, 2), 'AW', 'AN', 'CS', 'CB', 'EU', 'ZY', 'KZ', 'KA', 'LI', 'ZY', 'RU', 'RS', 'TJ', 'TA', 'UA', 'UK', 'UZ', 'UB', 'YU', 'YE', SUBSTR(L1.LOC_CD, 1, 2))||'ZZZ', H1.ATTR_CTNT2)" ).append("\n"); 
		query.append("       END AS DATA07," ).append("\n"); 
		query.append("       -- 10 POL NAME" ).append("\n"); 
		query.append("       RPAD(UPPER(L1.LOC_NM), 20, ' ') AS DATA08," ).append("\n"); 
		query.append("       -- 11 POL Split No (1)" ).append("\n"); 
		query.append("--       RPAD(' ', 1, ' ') AS DATA09," ).append("\n"); 
		query.append("       DECODE(@[pol_split_no], '', ' ', @[pol_split_no]) AS DATA09," ).append("\n"); 
		query.append("       -- 12 B/L NO" ).append("\n"); 
		query.append("       RPAD(COM_ConstantMgr_PKG.COM_getScacCode_FNC()||A.BL_NO||A.BL_SPLIT_NO, 35, ' ') AS DATA10," ).append("\n"); 
		query.append("       -- 13 출항예정 년월" ).append("\n"); 
		query.append("--       TO_CHAR(POL_SKD.VPS_ETD_DT, 'YYYYMMDD') AS DATA11," ).append("\n"); 
		query.append("       TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(L1.LOC_CD, POL_SKD.VPS_ETD_DT, 'GMT'), 'YYYYMMDD') AS DATA11," ).append("\n"); 
		query.append("       -- 14 출항예정 시각" ).append("\n"); 
		query.append("--       TO_CHAR(POL_SKD.VPS_ETD_DT, 'HH24MI') AS DATA12," ).append("\n"); 
		query.append("       TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(L1.LOC_CD, POL_SKD.VPS_ETD_DT,'GMT'), 'HH24MI') AS DATA12," ).append("\n"); 
		query.append("       -- 15 그리니치표준" ).append("\n"); 
		query.append("--       DECODE(SIGN(L1.GMT_HRS), -1, '-', '+')||DECODE(TRUNC(ABS(L1.GMT_HRS)/60), 0, '00', LPAD(TRUNC(ABS(L1.GMT_HRS)/60), 2, '0'))||LPAD((MOD(ABS(L1.GMT_HRS), 60)), 2, '0') AS DATA13," ).append("\n"); 
		query.append("       '00000' AS DATA13," ).append("\n"); 
		query.append("       -- 16 완화조치예상지역" ).append("\n"); 
		query.append("       RPAD(NVL(JVSL.JO_CD1, ' '), 1, ' ') AS DATA14," ).append("\n"); 
		query.append("       -- 17 Master B/L 식별" ).append("\n"); 
		query.append("       --RPAD(' ', 1, ' ') AS DATA15," ).append("\n"); 
		query.append("       RPAD(DECODE(A.RVIS_CNTR_CUST_TP_CD, 'N', 'M', ' '), 1, ' ') AS DATA15," ).append("\n"); 
		query.append("       -- 18 통지처코드 (반복3)" ).append("\n"); 
		query.append("       RPAD(' ', 5, ' ') AS DATA16," ).append("\n"); 
		query.append("       -- 18 통지처코드 (반복3)" ).append("\n"); 
		query.append("       RPAD(' ', 5, ' ') AS DATA17," ).append("\n"); 
		query.append("       -- 18 통지처코드 (반복3)" ).append("\n"); 
		query.append("       RPAD(' ', 5, ' ') AS DATA18," ).append("\n"); 
		query.append("       -- 19 discharging loc" ).append("\n"); 
		query.append("       CASE" ).append("\n"); 
		query.append("          WHEN SUBSTR(L2.LOC_CD, 1, 2) = 'JP' THEN" ).append("\n"); 
		query.append("             NVL(H2.ATTR_CTNT2, L2.LOC_CD)" ).append("\n"); 
		query.append("          ELSE" ).append("\n"); 
		query.append("             DECODE(H2.ATTR_CTNT2, NULL, DECODE(SUBSTR(L2.LOC_CD, 1, 2), 'AW', 'AN', 'CS', 'CB', 'EU', 'ZY', 'KZ', 'KA', 'LI', 'ZY', 'RU', 'RS', 'TJ', 'TA', 'UA', 'UK', 'UZ', 'UB', 'YU', 'YE', SUBSTR(L2.LOC_CD, 1, 2))||'ZZZ', H2.ATTR_CTNT2)" ).append("\n"); 
		query.append("       END AS DATA19," ).append("\n"); 
		query.append("       -- 20 POD Split No (1)" ).append("\n"); 
		query.append("--       RPAD(' ', 1, ' ') AS DATA20," ).append("\n"); 
		query.append("       DECODE(@[pod_split_no], '', ' ', @[pod_split_no]) AS DATA20," ).append("\n"); 
		query.append("       -- 21 입항예정 년월" ).append("\n"); 
		query.append("       TO_CHAR(POD_SKD.VPS_ETA_DT, 'YYYYMMDD') AS DATA21," ).append("\n"); 
		query.append("       -- 22 오퍼레이션회사 코드" ).append("\n"); 
		query.append("       RPAD(' ', 5, ' ') AS DATA22," ).append("\n"); 
		query.append("       -- 23 booking POL 코드" ).append("\n"); 
		query.append("       CASE" ).append("\n"); 
		query.append("          WHEN SUBSTR(L3.LOC_CD, 1, 2) = 'JP' THEN" ).append("\n"); 
		query.append("             NVL(H3.ATTR_CTNT2, L3.LOC_CD)" ).append("\n"); 
		query.append("          ELSE" ).append("\n"); 
		query.append("             DECODE(H3.ATTR_CTNT2, NULL, DECODE(SUBSTR(L3.LOC_CD, 1, 2), 'AW', 'AN', 'CS', 'CB', 'EU', 'ZY', 'KZ', 'KA', 'LI', 'ZY', 'RU', 'RS', 'TJ', 'TA', 'UA', 'UK', 'UZ', 'UB', 'YU', 'YE', SUBSTR(L3.LOC_CD, 1, 2))||'ZZZ', H3.ATTR_CTNT2)" ).append("\n"); 
		query.append("       END AS DATA23," ).append("\n"); 
		query.append("       -- 24 pol 코드명" ).append("\n"); 
		query.append("       RPAD(UPPER(L3.LOC_NM), 20, ' ') AS DATA24," ).append("\n"); 
		query.append("       -- 25 booking DEL 코드" ).append("\n"); 
		query.append("       CASE" ).append("\n"); 
		query.append("          WHEN SUBSTR(L4.LOC_CD, 1, 2) = 'JP' THEN" ).append("\n"); 
		query.append("             NVL(H4.ATTR_CTNT2, L4.LOC_CD)" ).append("\n"); 
		query.append("          ELSE" ).append("\n"); 
		query.append("             DECODE(H4.ATTR_CTNT2, NULL, DECODE(SUBSTR(L4.LOC_CD, 1, 2), 'AW', 'AN', 'CS', 'CB', 'EU', 'ZY', 'KZ', 'KA', 'LI', 'ZY', 'RU', 'RS', 'TJ', 'TA', 'UA', 'UK', 'UZ', 'UB', 'YU', 'YE', SUBSTR(L4.LOC_CD, 1, 2))||'ZZZ', H4.ATTR_CTNT2)" ).append("\n"); 
		query.append("       END AS DATA25," ).append("\n"); 
		query.append("       -- 26 del 코드명" ).append("\n"); 
		query.append("       RPAD(UPPER(L4.LOC_NM), 20, ' ') AS DATA26," ).append("\n"); 
		query.append("       -- 27 최종 del 코드" ).append("\n"); 
		query.append("       RPAD(' ', 5, ' ') AS DATA27," ).append("\n"); 
		query.append("       -- 28 최종 del 코드명" ).append("\n"); 
		query.append("       RPAD(' ', 20, ' ') AS DATA28" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ADV_JP_BL A," ).append("\n"); 
		query.append("       BKG_CSTMS_CD_CONV_CTNT H1," ).append("\n"); 
		query.append("       BKG_CSTMS_CD_CONV_CTNT H2," ).append("\n"); 
		query.append("       BKG_CSTMS_CD_CONV_CTNT H3," ).append("\n"); 
		query.append("       BKG_CSTMS_CD_CONV_CTNT H4," ).append("\n"); 
		query.append("       MDM_VSL_CNTR VSL," ).append("\n"); 
		query.append("       MDM_LOCATION L1," ).append("\n"); 
		query.append("       MDM_LOCATION L2," ).append("\n"); 
		query.append("       MDM_LOCATION L3," ).append("\n"); 
		query.append("       MDM_LOCATION L4," ).append("\n"); 
		query.append("       VSK_VSL_PORT_SKD POL_SKD," ).append("\n"); 
		query.append("       VSK_VSL_PORT_SKD POD_SKD," ).append("\n"); 
		query.append("       BKG_VVD VVD," ).append("\n"); 
		query.append("       BKG_BOOKING BKG," ).append("\n"); 
		query.append("       BKG_CSTMS_ADV_JP_VSL_SKD JVSL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND A.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("   AND A.BL_SPLIT_NO = NVL(@[bl_split_no], '  ')" ).append("\n"); 
		query.append("   AND A.POL_CD = L1.LOC_CD(+)" ).append("\n"); 
		query.append("   AND A.POD_CD = L2.LOC_CD(+)" ).append("\n"); 
		query.append("   AND A.BKG_POL_CD = L3.LOC_CD(+)" ).append("\n"); 
		query.append("   AND A.BKG_DEL_CD = L4.LOC_CD(+)" ).append("\n"); 
		query.append("   AND H1.CNT_CD(+) = 'JP'" ).append("\n"); 
		query.append("   AND H1.CSTMS_DIV_ID(+) = 'JAPAN_LOC'" ).append("\n"); 
		query.append("   AND A.POL_CD = H1.ATTR_CTNT1(+)" ).append("\n"); 
		query.append("   AND H2.CNT_CD(+) = 'JP'" ).append("\n"); 
		query.append("   AND H2.CSTMS_DIV_ID(+) = 'JAPAN_LOC'" ).append("\n"); 
		query.append("   AND A.POD_CD = H2.ATTR_CTNT1(+)" ).append("\n"); 
		query.append("   AND H3.CNT_CD(+) = 'JP'" ).append("\n"); 
		query.append("   AND H3.CSTMS_DIV_ID(+) = 'JAPAN_LOC'" ).append("\n"); 
		query.append("   AND A.BKG_POL_CD = H3.ATTR_CTNT1(+)" ).append("\n"); 
		query.append("   AND H4.CNT_CD(+) = 'JP'" ).append("\n"); 
		query.append("   AND H4.CSTMS_DIV_ID(+) = 'JAPAN_LOC'" ).append("\n"); 
		query.append("   AND A.BKG_DEL_CD = H4.ATTR_CTNT1(+)" ).append("\n"); 
		query.append("   AND VSL.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND POL_SKD.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND POL_SKD.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND POL_SKD.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("   AND POL_SKD.VPS_PORT_CD = A.POL_CD" ).append("\n"); 
		query.append("   AND POL_SKD.CLPT_IND_SEQ = (SELECT MIN(P.CLPT_IND_SEQ) " ).append("\n"); 
		query.append("                                 FROM VSK_VSL_PORT_SKD P" ).append("\n"); 
		query.append("                                WHERE 1=1" ).append("\n"); 
		query.append("                                  AND P.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                                  AND P.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                                  AND P.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("                                  AND P.VPS_PORT_CD = A.POL_CD" ).append("\n"); 
		query.append("                                  AND NVL(P.SKD_CNG_STS_CD, 'X') <> 'S')    /* Skip */" ).append("\n"); 
		query.append("   AND POD_SKD.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND POD_SKD.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND POD_SKD.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("   AND POD_SKD.VPS_PORT_CD = VVD.POD_CD" ).append("\n"); 
		query.append("   AND POD_SKD.CLPT_IND_SEQ = (SELECT MIN(P.CLPT_IND_SEQ) " ).append("\n"); 
		query.append("                                 FROM VSK_VSL_PORT_SKD P" ).append("\n"); 
		query.append("                                WHERE 1=1" ).append("\n"); 
		query.append("                                  AND P.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                                  AND P.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                                  AND P.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("                                  AND P.VPS_PORT_CD = VVD.POD_CD" ).append("\n"); 
		query.append("                                  AND NVL(P.SKD_CNG_STS_CD, 'X') <> 'S')    /* Skip */" ).append("\n"); 
		query.append("   AND A.BL_NO = BKG.BL_NO" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("   AND A.POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("   AND POL_SKD.VSL_CD = JVSL.VSL_CD" ).append("\n"); 
		query.append("   AND POL_SKD.SKD_VOY_NO = JVSL.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND POL_SKD.SKD_DIR_CD = JVSL.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND POL_SKD.VPS_PORT_CD = JVSL.POL_CD" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}