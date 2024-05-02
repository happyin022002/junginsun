/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : JapanTerminalTransmissionDBDAOsearchBkgInfoForScheduleRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanTerminalTransmissionDBDAOsearchBkgInfoForScheduleRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBkgInfoForSchedule
	  * </pre>
	  */
	public JapanTerminalTransmissionDBDAOsearchBkgInfoForScheduleRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration").append("\n"); 
		query.append("FileName : JapanTerminalTransmissionDBDAOsearchBkgInfoForScheduleRSQL").append("\n"); 
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
		query.append("SELECT V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD AS VVD_CD," ).append("\n"); 
		query.append("       V.VSL_CD," ).append("\n"); 
		query.append("       V.SKD_VOY_NO," ).append("\n"); 
		query.append("       V.SKD_DIR_CD," ).append("\n"); 
		query.append("       CASE" ).append("\n"); 
		query.append("          WHEN T.JP_TML_VSL_NO IS NOT NULL THEN" ).append("\n"); 
		query.append("             T.JP_TML_VSL_NO" ).append("\n"); 
		query.append("          WHEN S.OB_CSSM_VOY_NO IS NOT NULL THEN" ).append("\n"); 
		query.append("             S.OB_CSSM_VOY_NO" ).append("\n"); 
		query.append("          ELSE" ).append("\n"); 
		query.append("             V.SKD_VOY_NO||V.SKD_DIR_CD" ).append("\n"); 
		query.append("       END AS JP_TML_VSL_NO," ).append("\n"); 
		query.append("       B.POL_CD," ).append("\n"); 
		query.append("       B.POL_NOD_CD POL_YD_CD," ).append("\n"); 
		query.append("       B.POR_CD," ).append("\n"); 
		query.append("       B.POR_NOD_CD POR_YD_CD," ).append("\n"); 
		query.append("       M.CALL_SGN_NO," ).append("\n"); 
		query.append("       TO_CHAR(S.VPS_ETA_DT-14, 'YYYY-MM-DD') BAT_SKD_PRD_FM_DT," ).append("\n"); 
		query.append("       TO_CHAR(S.VPS_ETA_DT, 'YYYY-MM-DD') BAT_SKD_PRD_TO_DT," ).append("\n"); 
		query.append("       B.BKG_NO," ).append("\n"); 
		query.append("       DECODE(T.SNACCS_TML_EDI_STS_CNG_FLG, 'Y', T.SNACCS_TML_EDI_STS_CD, DECODE(B.BKG_STS_CD, 'X', 'D', NVL2(T.BKG_NO, 'Rv', 'R'))) BKRBKC," ).append("\n"); 
		query.append("       DECODE(T.SNACCS_TML_EDI_STS_CNG_FLG, 'Y', T.SNACCS_TML_EDI_STS_CD, DECODE(B.BKG_STS_CD, 'X', 'D', NVL2(T.BKG_NO, 'V', 'R'))) BE_BKRBKC," ).append("\n"); 
		query.append("       TO_CHAR(T.EDI_SND_DT, 'YYYY-MM-DD') EDI_SND_DT," ).append("\n"); 
		query.append("       TO_CHAR(T.EDI_SND_DT, 'HH:MM:SS') EDI_SND_TM," ).append("\n"); 
		query.append("       NVL(T.EDI_SND_OFC_CD, @[ofc_cd]) EDI_SND_OFC_CD," ).append("\n"); 
		query.append("       NVL(T.EDI_SND_USR_ID, @[usr_id]) EDI_SND_USR_ID," ).append("\n"); 
		query.append("       NVL(T.SNACCS_TML_EDI_STS_CNG_FLG, 'N') SNACCS_TML_EDI_STS_CNG_FLG," ).append("\n"); 
		query.append("       T.OTR_NTFY_YD_CD," ).append("\n"); 
		query.append("       C.CNTR_TPSZ_CD1," ).append("\n"); 
		query.append("       C.CNTR_VOL_QTY1," ).append("\n"); 
		query.append("       C.CNTR_TPSZ_CD2," ).append("\n"); 
		query.append("       C.CNTR_VOL_QTY2," ).append("\n"); 
		query.append("       C.CNTR_TPSZ_CD3," ).append("\n"); 
		query.append("       C.CNTR_VOL_QTY3," ).append("\n"); 
		query.append("       C.CNTR_TPSZ_CD4," ).append("\n"); 
		query.append("       C.CNTR_VOL_QTY4," ).append("\n"); 
		query.append("       C.CNTR_TPSZ_CD5," ).append("\n"); 
		query.append("       C.CNTR_VOL_QTY5" ).append("\n"); 
		query.append("  FROM BKG_VVD V," ).append("\n"); 
		query.append("       BKG_BOOKING B," ).append("\n"); 
		query.append("       VSK_VSL_PORT_SKD S," ).append("\n"); 
		query.append("       BKG_TML_EDI_JP_BAT_VVD_SKD BS," ).append("\n"); 
		query.append("       MDM_VSL_CNTR M," ).append("\n"); 
		query.append("       BKG_TML_EDI_JP_BL T," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("        SELECT (SELECT MIN(BKG_NO)" ).append("\n"); 
		query.append("                    FROM BKG_VVD" ).append("\n"); 
		query.append("                   WHERE BKG_NO LIKE SUBSTR(@[in_bkg_no], 1, 10)||'%'" ).append("\n"); 
		query.append("                   GROUP BY SUBSTR(BKG_NO, 1, 10)" ).append("\n"); 
		query.append("                 ) BKG_NO," ).append("\n"); 
		query.append("               MAX(DECODE(MOD(RN,5), 1, CNTR_TPSZ_CD, '')) CNTR_TPSZ_CD1 ," ).append("\n"); 
		query.append("               MAX(DECODE(MOD(RN,5), 1, CNTR_VOL_QTY, '')) CNTR_VOL_QTY1 ," ).append("\n"); 
		query.append("               MAX(DECODE(MOD(RN,5), 2, CNTR_TPSZ_CD, '')) CNTR_TPSZ_CD2 ," ).append("\n"); 
		query.append("               MAX(DECODE(MOD(RN,5), 2, CNTR_VOL_QTY, '')) CNTR_VOL_QTY2 ," ).append("\n"); 
		query.append("               MAX(DECODE(MOD(RN,5), 3, CNTR_TPSZ_CD, '')) CNTR_TPSZ_CD3 ," ).append("\n"); 
		query.append("               MAX(DECODE(MOD(RN,5), 3, CNTR_VOL_QTY, '')) CNTR_VOL_QTY3 ," ).append("\n"); 
		query.append("               MAX(DECODE(MOD(RN,5), 4, CNTR_TPSZ_CD, '')) CNTR_TPSZ_CD4 ," ).append("\n"); 
		query.append("               MAX(DECODE(MOD(RN,5), 4, CNTR_VOL_QTY, '')) CNTR_VOL_QTY4 ," ).append("\n"); 
		query.append("               MAX(DECODE(MOD(RN,5), 0, CNTR_TPSZ_CD, '')) CNTR_TPSZ_CD5 ," ).append("\n"); 
		query.append("               MAX(DECODE(MOD(RN,5), 0, CNTR_VOL_QTY, '')) CNTR_VOL_QTY5 ," ).append("\n"); 
		query.append("               SUM( NVL(CNTR_VOL_QTY, 0) ) CNTR_VOL_QTY_TOT --JS추가" ).append("\n"); 
		query.append("          FROM ( SELECT BKG_NO," ).append("\n"); 
		query.append("                        CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                        SUM(OP_CNTR_QTY) OVER (PARTITION BY BKG_NO, CNTR_TPSZ_CD) CNTR_VOL_QTY," ).append("\n"); 
		query.append("                        RANK() OVER ( PARTITION BY BKG_NO ORDER BY CNTR_TPSZ_CD) RN" ).append("\n"); 
		query.append("                   FROM (" ).append("\n"); 
		query.append("                         SELECT" ).append("\n"); 
		query.append("                             BKG_NO," ).append("\n"); 
		query.append("                             CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                             SUM(OP_CNTR_QTY) OP_CNTR_QTY" ).append("\n"); 
		query.append("                         FROM" ).append("\n"); 
		query.append("                           (" ).append("\n"); 
		query.append("                           SELECT (SELECT MIN(BKG_NO)" ).append("\n"); 
		query.append("                                    FROM BKG_BOOKING" ).append("\n"); 
		query.append("                                   WHERE BKG_NO LIKE SUBSTR(@[in_bkg_no], 1, 10)||'%'" ).append("\n"); 
		query.append("                                     AND BKG_STS_CD != 'X' ) BKG_NO," ).append("\n"); 
		query.append("                                  Q.CNTR_TPSZ_CD CNTR_TPSZ_CD ," ).append("\n"); 
		query.append("                                  Q.OP_CNTR_QTY OP_CNTR_QTY" ).append("\n"); 
		query.append("                             FROM BKG_QUANTITY Q" ).append("\n"); 
		query.append("                            WHERE Q.BKG_NO LIKE SUBSTR(@[in_bkg_no], 1, 10)||'%'" ).append("\n"); 
		query.append("                           ) GROUP BY BKG_NO, CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("        GROUP BY BKG_NO" ).append("\n"); 
		query.append("       ) C" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND V.POL_CD LIKE 'JP%'" ).append("\n"); 
		query.append("  AND B.BKG_NO=V.BKG_NO" ).append("\n"); 
		query.append("  AND B.POL_CD=V.POL_CD" ).append("\n"); 
		query.append("  AND S.VSL_CD=V.VSL_CD" ).append("\n"); 
		query.append("  AND S.SKD_VOY_NO=V.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND S.SKD_DIR_CD=V.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND S.VPS_PORT_CD=V.POL_CD" ).append("\n"); 
		query.append("  AND S.CLPT_IND_SEQ=V.POL_CLPT_IND_SEQ --double calling 여부 문의" ).append("\n"); 
		query.append("  AND BS.VSL_CD=V.VSL_CD" ).append("\n"); 
		query.append("  AND BS.SKD_VOY_NO=V.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND BS.SKD_DIR_CD=V.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND BS.POL_CD=B.POL_CD" ).append("\n"); 
		query.append("  AND BS.POL_YD_CD=B.POL_NOD_CD" ).append("\n"); 
		query.append("  AND BS.POR_CD=B.POR_CD" ).append("\n"); 
		query.append("  AND BS.POR_YD_CD=B.POR_NOD_CD" ).append("\n"); 
		query.append("  AND M.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("  AND B.BKG_NO = T.BKG_NO(+)" ).append("\n"); 
		query.append("  AND T.BKG_SKD_SEQ(+) = 0" ).append("\n"); 
		query.append("  AND T.BKG_SKD_DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("  AND B.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("  AND V.BKG_NO = (SELECT MIN(BKG_NO)" ).append("\n"); 
		query.append("                    FROM BKG_VVD" ).append("\n"); 
		query.append("                   WHERE BKG_NO LIKE SUBSTR(@[in_bkg_no], 1, 10)||'%'" ).append("\n"); 
		query.append("					 AND BKG_STS_CD != 'X'" ).append("\n"); 
		query.append("                 )" ).append("\n"); 

	}
}