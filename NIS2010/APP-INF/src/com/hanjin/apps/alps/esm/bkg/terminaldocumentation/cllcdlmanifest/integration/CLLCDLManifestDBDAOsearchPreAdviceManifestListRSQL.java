/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchPreAdviceManifestListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.10.30
*@LastModifier : 
*@LastVersion : 1.0
* 2017.10.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchPreAdviceManifestListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchPreAdviceManifestList
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchPreAdviceManifestListRSQL(){
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
		params.put("op_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_full_rtn_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_full_rtn_yd_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("op_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchPreAdviceManifestListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	'SML' LINE_CD,   " ).append("\n"); 
		query.append("    NVL( (SELECT REPLACE(S.CUST_NM,CHR(13)||CHR(10),'  ') AS CUST_NM     FROM BKG_CUSTOMER S WHERE S.BKG_NO=B.BKG_NO AND S.BKG_CUST_TP_CD='S' AND ROWNUM=1 ), ' ' ) AS CUST_NM," ).append("\n"); 
		query.append("    C.CNTR_NO, " ).append("\n"); 
		query.append("    C.CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    CASE SUBSTR(C.CNTR_TPSZ_CD,2,1) WHEN '2' THEN '20`'" ).append("\n"); 
		query.append("                                  WHEN '4' THEN '40`'" ).append("\n"); 
		query.append("                                  ELSE DECODE(CNTR_NO,'','',decode(CNTR_TPSZ_CD, 'D5', '40`', 'R5', '40`', '45`'))" ).append("\n"); 
		query.append("    END CNTR_SZ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    CASE SUBSTR(C.CNTR_TPSZ_CD,1,1) WHEN 'D' THEN 'GP'" ).append("\n"); 
		query.append("                                  WHEN 'R' THEN 'RF'" ).append("\n"); 
		query.append("                                  WHEN 'O' THEN 'OT'" ).append("\n"); 
		query.append("                                  WHEN 'A' THEN 'FR'" ).append("\n"); 
		query.append("                                  WHEN 'P' THEN 'PL'" ).append("\n"); 
		query.append("                                  WHEN 'T' THEN 'TK'" ).append("\n"); 
		query.append("     END  CNTR_TP, " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    CASE SUBSTR(C.CNTR_TPSZ_CD,2,1) WHEN '2' THEN '86'" ).append("\n"); 
		query.append("                                    WHEN '4' THEN '86'" ).append("\n"); 
		query.append("                                    ELSE DECODE(C.CNTR_NO,'','','96')" ).append("\n"); 
		query.append("    END Height," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    B.POR_CD," ).append("\n"); 
		query.append("    B.POL_CD," ).append("\n"); 
		query.append("    (SELECT VSL_ENG_NM FROM MDM_VSL_CNTR M WHERE A.VSL_CD = M.VSL_CD)   VSL_ENG_NM," ).append("\n"); 
		query.append("    A.SKD_VOY_NO||A.SKD_DIR_CD SKD_VOY_NO," ).append("\n"); 
		query.append("    B.BKG_NO," ).append("\n"); 
		query.append("    C.CNTR_WGT," ).append("\n"); 
		query.append("    C.WGT_UT_CD," ).append("\n"); 
		query.append("    DECODE(B.BKG_CGO_TP_CD,'P','M','F','F') BKG_CGO_TP_CD, " ).append("\n"); 
		query.append("     (SELECT DECODE(AA.POD_YD_CD, 'KRPUSHN', 'PU1', 'KRPUSYG', 'PU2', AA.POD_CD)" ).append("\n"); 
		query.append("      FROM BKG_VVD AA " ).append("\n"); 
		query.append("      WHERE  ROWNUM =1 " ).append("\n"); 
		query.append("      AND AA.BKG_NO = B.BKG_NO " ).append("\n"); 
		query.append("      AND AA.POD_CD IN (       " ).append("\n"); 
		query.append("          SELECT BKG_GET_VVD_POD(B.BKG_NO,'1')  FROM DUAL)" ).append("\n"); 
		query.append("     ) DISCH_PORT1," ).append("\n"); 
		query.append("      (SELECT DECODE(AA.POD_YD_CD, 'KRPUSHN', 'PU1', 'KRPUSYG', 'PU2', AA.POD_CD)" ).append("\n"); 
		query.append("       FROM BKG_VVD AA " ).append("\n"); 
		query.append("       WHERE  ROWNUM =1 " ).append("\n"); 
		query.append("       AND AA.BKG_NO = B.BKG_NO " ).append("\n"); 
		query.append("       AND AA.POD_CD IN (       " ).append("\n"); 
		query.append("          SELECT BKG_GET_VVD_POD(B.BKG_NO,'2')  FROM DUAL)" ).append("\n"); 
		query.append("     ) DISCH_PORT2," ).append("\n"); 
		query.append("    B.DEL_CD," ).append("\n"); 
		query.append("    --(SELECT CDO_TEMP FROM BKG_RF_CGO R WHERE B.BKG_NO = R.BKG_NO) CDO_TEMP," ).append("\n"); 
		query.append(" ( SELECT /*+ INDEX_ASC(RF XPKBKG_RF_CGO) */ CDO_TEMP  " ).append("\n"); 
		query.append("           FROM BKG_RF_CGO RF" ).append("\n"); 
		query.append("          WHERE 1=1 " ).append("\n"); 
		query.append("            AND BKG_NO = A.BKG_NO " ).append("\n"); 
		query.append("            AND ROWNUM = 1 ) AS CDO_TEMP," ).append("\n"); 
		query.append("    DECODE(( SELECT /*+ INDEX_ASC(RF XPKBKG_RF_CGO) */ CDO_TEMP  " ).append("\n"); 
		query.append("           FROM BKG_RF_CGO RF" ).append("\n"); 
		query.append("          WHERE 1=1 " ).append("\n"); 
		query.append("            AND BKG_NO = A.BKG_NO " ).append("\n"); 
		query.append("            AND ROWNUM = 1 ),'','','C') TEMP_UNIT," ).append("\n"); 
		query.append("    (SELECT NVL(VENT_RTO, CBM_PER_HR_QTY) " ).append("\n"); 
		query.append("       FROM BKG_RF_CGO R " ).append("\n"); 
		query.append("      WHERE B.BKG_NO = R.BKG_NO " ).append("\n"); 
		query.append("        AND R.RC_SEQ = (SELECT /*+ INDEX_DESC(RF XPKBKG_RF_CGO) */ RC_SEQ AS MAX_RC_SEQ" ).append("\n"); 
		query.append("                          FROM BKG_RF_CGO RF" ).append("\n"); 
		query.append("                         WHERE RF.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                            AND ROWNUM = 1" ).append("\n"); 
		query.append("        )) VENT_RTO," ).append("\n"); 
		query.append("    (SELECT DECODE(VENT_RTO,0,'CMH','% Open')  " ).append("\n"); 
		query.append("       FROM BKG_RF_CGO R " ).append("\n"); 
		query.append("      WHERE B.BKG_NO = R.BKG_NO" ).append("\n"); 
		query.append("        AND R.RC_SEQ = (SELECT /*+ INDEX_DESC(RF XPKBKG_RF_CGO) */ RC_SEQ AS MAX_RC_SEQ" ).append("\n"); 
		query.append("                          FROM BKG_RF_CGO RF" ).append("\n"); 
		query.append("                         WHERE RF.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                            AND ROWNUM = 1" ).append("\n"); 
		query.append("        )) VENT_RTO_UNIT," ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("     ( SELECT /*+ INDEX_ASC(DG XPKBKG_DG_CGO) */ IMDG_CLSS_CD" ).append("\n"); 
		query.append("           FROM BKG_DG_CGO DG" ).append("\n"); 
		query.append("          WHERE 1=1 " ).append("\n"); 
		query.append("            AND BKG_NO = A.BKG_NO " ).append("\n"); 
		query.append("            AND ROWNUM = 1 ) AS IMDG_CLSS_CD," ).append("\n"); 
		query.append("      ( SELECT /*+ INDEX_ASC(DG XPKBKG_DG_CGO) */ IMDG_UN_NO" ).append("\n"); 
		query.append("           FROM BKG_DG_CGO DG" ).append("\n"); 
		query.append("          WHERE 1=1 " ).append("\n"); 
		query.append("            AND BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("            AND ROWNUM = 1 ) AS IMDG_UN_NO," ).append("\n"); 
		query.append("    (SELECT CNTR_SEAL_NO FROM BKG_CNTR_SEAL_NO S WHERE B.BKG_NO=S.BKG_NO AND S.CNTR_NO=C.CNTR_NO AND S.CNTR_SEAL_SEQ =1) CNTR_SEAL_NO," ).append("\n"); 
		query.append("     (SELECT DECODE(ORG_PPD_RCV_CD,'C','Credit','Cash') FROM BKG_BL_ISS L WHERE B.BKG_NO=L.BKG_NO) ORG_PPD_RCV_CD," ).append("\n"); 
		query.append("     B.CMDT_CD," ).append("\n"); 
		query.append("     MC.CMDT_NM," ).append("\n"); 
		query.append("     (SELECT  " ).append("\n"); 
		query.append("              INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("     FROM     COM_INTG_CD_DTL" ).append("\n"); 
		query.append("     WHERE    INTG_CD_ID = 'CD02146'" ).append("\n"); 
		query.append("     AND      (APLY_ST_DT <= TO_CHAR(SYSDATE, 'YYYYMMDD') AND APLY_END_DT >= TO_CHAR(SYSDATE, 'YYYYMMDD'))" ).append("\n"); 
		query.append("     AND      INTG_CD_VAL_CTNT(+) = B.STWG_CD" ).append("\n"); 
		query.append("     ) STWG_CD," ).append("\n"); 
		query.append("     B.AWK_CGO_FLG," ).append("\n"); 
		query.append("     B.BLCK_STWG_CD" ).append("\n"); 
		query.append("  FROM BKG_VVD A, BKG_BOOKING B, BKG_CONTAINER C" ).append("\n"); 
		query.append("       ,MDM_COMMODITY MC" ).append("\n"); 
		query.append(" WHERE 1=1 " ).append("\n"); 
		query.append("   AND A.BKG_NO = B.BKG_NO " ).append("\n"); 
		query.append("   AND B.BKG_STS_CD != 'X' " ).append("\n"); 
		query.append("   AND A.BKG_NO = C.BKG_NO(+) " ).append("\n"); 
		query.append("   AND B.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("   AND B.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("   AND B.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("   AND A.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("   AND A.VSL_CD = SUBSTR(@[s_vvd],1,4)" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO = SUBSTR(@[s_vvd],5,4)" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD = SUBSTR(@[s_vvd],9,1)" ).append("\n"); 
		query.append("   AND C.CNMV_STS_CD = 'OP'" ).append("\n"); 
		query.append("   AND B.CMDT_CD = MC.CMDT_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${s_por_cd} != '')" ).append("\n"); 
		query.append("   AND B.POR_CD like NVL(@[s_por_cd]||'%','%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${s_full_rtn_yd_cd} != '')" ).append("\n"); 
		query.append("   AND B.FULL_RTN_YD_CD like NVL(@[s_full_rtn_yd_cd]||@[s_full_rtn_yd_nod_cd]||'%','%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${op_fm_dt} != '' && ${op_to_dt} != '')" ).append("\n"); 
		query.append("   AND C.CNMV_EVNT_DT BETWEEN TO_DATE(@[op_fm_dt],'YYYY-MM-DD') AND TO_DATE(@[op_to_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("ORDER BY A.BKG_NO, C.CNTR_NO" ).append("\n"); 

	}
}