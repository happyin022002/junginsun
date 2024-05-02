/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PerformanceReportDBDAOCaIssueDateOutVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.30
*@LastModifier : 
*@LastVersion : 1.0
* 2013.12.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOCaIssueDateOutVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public PerformanceReportDBDAOCaIssueDateOutVORSQL(){
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
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOCaIssueDateOutVORSQL").append("\n"); 
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
		query.append("#if (${cnt_cd} == 'CA' || ${cnt_cd} == 'US')" ).append("\n"); 
		query.append("SELECT DISTINCT " ).append("\n"); 
		query.append(" D.BKG_NO BKG_NO" ).append("\n"); 
		query.append(",Decode(substr(A.POD_CD,1,2),'US',USA_CSTMS_FILE_CD,'CA',CND_CSTMS_FILE_CD,' ') USA_CSTMS_FILE_CD" ).append("\n"); 
		query.append(",A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD" ).append("\n"); 
		query.append(",B.BKG_NO" ).append("\n"); 
		query.append(",B.BL_NO" ).append("\n"); 
		query.append(",B.BL_TP_CD" ).append("\n"); 
		query.append(",A.POL_CD" ).append("\n"); 
		query.append(",A.POD_CD" ).append("\n"); 
		query.append(",D.CORR_NO" ).append("\n"); 
		query.append(",TO_CHAR(D.CORR_DT,'YYYY-MM-DD HH24:MI:SS') CORR_DT" ).append("\n"); 
		query.append(",D.CORR_OFC_CD" ).append("\n"); 
		query.append(",D.CA_RSN_CD " ).append("\n"); 
		query.append(",NVL((SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01632' AND INTG_CD_VAL_CTNT = D.CA_RSN_CD), D.CA_RSN_CD) CA_RSN_NM" ).append("\n"); 
		query.append(",Decode(RAT_FLG,'N',EXPN_FLG) RAT_FLG" ).append("\n"); 
		query.append(",NVL(RT_CORR_FLG,'N') 		AS KIND_A" ).append("\n"); 
		query.append(",NVL(CHG_TERM_CORR_FLG,'N')	AS KIND_B" ).append("\n"); 
		query.append(",NVL(RCVDE_TERM_CORR_FLG,'N') AS KIND_C" ).append("\n"); 
		query.append(",NVL(ROUT_CORR_FLG,'N') 		AS KIND_D" ).append("\n"); 
		query.append(",NVL(CUST_CORR_FLG,'N') 		AS KIND_E" ).append("\n"); 
		query.append(",NVL(QTY_CORR_FLG,'N')		AS KIND_F" ).append("\n"); 
		query.append(",NVL(MEAS_QTY_CORR_FLG,'N') 	AS KIND_G" ).append("\n"); 
		query.append(",NVL(CMDT_CORR_FLG,'N') 		AS KIND_H" ).append("\n"); 
		query.append(",NVL(TRNK_VSL_CORR_FLG,'N')  	AS KIND_I" ).append("\n"); 
		query.append(",NVL(PRPST_VSL_CORR_FLG,'N') 	AS KIND_J" ).append("\n"); 
		query.append(",NVL(CA_OTR_RSN_CORR_FLG,'N') AS KIND_K" ).append("\n"); 
		query.append(",REPLACE(D.BKG_CORR_RMK, CHR(13) || CHR(10), ' ') BKG_CORR_RMK" ).append("\n"); 
		query.append(",TO_CHAR(SKD.VPS_ETA_DT,'YYYY-MM-DD HH24:MI:SS') AS VPS_ETA_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   FROM BKG_CORRECTION D, BKG_BOOKING B, BKG_CSTMS_ADV_BL C, BKG_VVD A, VSK_VSL_PORT_SKD SKD    " ).append("\n"); 
		query.append("  WHERE 1=1" ).append("\n"); 
		query.append("#if (${from_dt} != '' && ${pk_tp} == 'date')" ).append("\n"); 
		query.append("	AND D.CORR_DT >= TO_DATE(@[from_dt],'YYYY-MM-DD HH24:MI')      " ).append("\n"); 
		query.append("    AND D.CORR_DT <= TO_DATE(@[to_dt],'YYYY-MM-DD HH24:MI')      " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    AND D.BKG_NO         = B.BKG_NO    " ).append("\n"); 
		query.append("    AND (B.BKG_STS_CD       = 'F'    OR   B.BKG_STS_CD       = 'W'  )    " ).append("\n"); 
		query.append("    AND B.BL_NO           > ' '    " ).append("\n"); 
		query.append("    AND B.BKG_NO        = A.BKG_NO    " ).append("\n"); 
		query.append("    AND B.BL_NO         = C.BL_NO    " ).append("\n"); 
		query.append("    AND (D.CORR_NO <>'0000000001' AND D.CORR_NO <> 'TMP0000001')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    AND C.CNT_CD = DECODE(@[cnt_cd],'US','US','CA','CA',C.CNT_CD)" ).append("\n"); 
		query.append("    #if (${vvd} != '' && ${pk_tp} == 'vvd')" ).append("\n"); 
		query.append("       AND A.VSL_CD = SUBSTR(@[vvd], 0, 4)" ).append("\n"); 
		query.append("       AND A.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("       AND A.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("    #end    " ).append("\n"); 
		query.append("    #if (${pod_cd} != '')" ).append("\n"); 
		query.append("	   AND A.POD_CD LIKE @[pod_cd] || '%'" ).append("\n"); 
		query.append("	#end    " ).append("\n"); 
		query.append("    #if (${del_cd} != '' && ${pk_tp} == 'vvd')" ).append("\n"); 
		query.append("       AND B.DEL_CD LIKE @[del_cd] || '%'" ).append("\n"); 
		query.append("    #end    " ).append("\n"); 
		query.append("    #if (${bl_no} != '' && ${pk_tp} == 'bl')" ).append("\n"); 
		query.append("       AND B.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("    #end     " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    AND D.CORR_DT > (CASE WHEN C.CA_NO IS NOT NULL" ).append("\n"); 
		query.append("                          THEN    " ).append("\n"); 
		query.append("                              (SELECT F.CORR_DT    " ).append("\n"); 
		query.append("                                FROM   BKG_CORRECTION F    " ).append("\n"); 
		query.append("                                WHERE  F.BKG_NO = B.BKG_NO AND F.CORR_NO = C.CA_NO    " ).append("\n"); 
		query.append("                                #if (${from_dt} != '' && ${pk_tp} == 'date')" ).append("\n"); 
		query.append("                                   AND D.CORR_DT BETWEEN TO_DATE(@[from_dt],'YYYY-MM-DD HH24:MI') AND TO_DATE(@[to_dt],'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("                                #end                            " ).append("\n"); 
		query.append("                                AND CORR_NO    <>  '0000000001'" ).append("\n"); 
		query.append("                               ) " ).append("\n"); 
		query.append("                           ELSE    " ).append("\n"); 
		query.append("                                TO_DATE('19000101', 'yyyymmdd') " ).append("\n"); 
		query.append("                          END)     " ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("    AND (               D.ROUT_CORR_FLG        = 'Y' OR D.CUST_CORR_FLG       = 'Y' OR    " ).append("\n"); 
		query.append("                        D.QTY_CORR_FLG         = 'Y' OR D.MEAS_QTY_CORR_FLG   = 'Y' OR    " ).append("\n"); 
		query.append("                        D.CMDT_CORR_FLG        = 'Y' OR D.TRNK_VSL_CORR_FLG   = 'Y' OR    " ).append("\n"); 
		query.append("                        D.PRPST_VSL_CORR_FLG   = 'Y' OR D.CA_OTR_RSN_CORR_FLG = 'Y' )" ).append("\n"); 
		query.append("    AND SKD.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("	AND SKD.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("	AND SKD.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("	AND SKD.VPS_PORT_CD = A.POD_CD" ).append("\n"); 
		query.append("	AND SKD.CLPT_IND_SEQ = A.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ORDER BY VVD                        " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT BKG.BKG_NO" ).append("\n"); 
		query.append("      ,BKG.USA_CSTMS_FILE_CD" ).append("\n"); 
		query.append("      ,VVD.VSL_CD || VVD.SKD_VOY_NO || VVD.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("      ,BKG.BL_NO" ).append("\n"); 
		query.append("      ,BKG.POL_CD" ).append("\n"); 
		query.append("      ,BKG.POD_CD" ).append("\n"); 
		query.append("      ,COR.CORR_NO" ).append("\n"); 
		query.append("      ,TO_CHAR(COR.CORR_DT,'YYYY-MM-DD HH:MI:SS') CORR_DT" ).append("\n"); 
		query.append("      ,COR.CORR_OFC_CD" ).append("\n"); 
		query.append("      ,COR.CA_RSN_CD" ).append("\n"); 
		query.append("      ,NVL((SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01632' AND INTG_CD_VAL_CTNT = COR.CA_RSN_CD), COR.CA_RSN_CD) CA_RSN_NM" ).append("\n"); 
		query.append("      ,NVL(COR.RAT_FLG, COR.EXPN_FLG) RAT_FLG" ).append("\n"); 
		query.append("      ,NVL(COR.RT_CORR_FLG,'N')              AS KIND_A" ).append("\n"); 
		query.append("      ,NVL(COR.CHG_TERM_CORR_FLG,'N')	     AS KIND_B" ).append("\n"); 
		query.append("      ,NVL(COR.RCVDE_TERM_CORR_FLG,'N')      AS KIND_C" ).append("\n"); 
		query.append("      ,NVL(COR.ROUT_CORR_FLG,'N')            AS KIND_D" ).append("\n"); 
		query.append("      ,NVL(COR.CUST_CORR_FLG,'N')            AS KIND_E" ).append("\n"); 
		query.append("      ,NVL(COR.QTY_CORR_FLG,'N')             AS KIND_F" ).append("\n"); 
		query.append("      ,NVL(COR.MEAS_QTY_CORR_FLG,'N')        AS KIND_G" ).append("\n"); 
		query.append("      ,NVL(COR.CMDT_CORR_FLG,'N')            AS KIND_H" ).append("\n"); 
		query.append("      ,NVL(COR.TRNK_VSL_CORR_FLG,'N')        AS KIND_I" ).append("\n"); 
		query.append("      ,NVL(COR.PRPST_VSL_CORR_FLG,'N')       AS KIND_J" ).append("\n"); 
		query.append("      ,NVL(COR.CA_OTR_RSN_CORR_FLG,'N')      AS KIND_K" ).append("\n"); 
		query.append("      ,REPLACE(COR.BKG_CORR_RMK, CHR(13) || CHR(10), ' ') BKG_CORR_RMK" ).append("\n"); 
		query.append("	  ,TO_CHAR(SKD.VPS_ETA_DT,'YYYY-MM-DD HH24:MI:SS') AS VPS_ETA_DT" ).append("\n"); 
		query.append("  FROM BKG_VVD VVD" ).append("\n"); 
		query.append("      ,BKG_BOOKING      BKG" ).append("\n"); 
		query.append("      ,BKG_CORRECTION   COR" ).append("\n"); 
		query.append("	  ,VSK_VSL_PORT_SKD SKD " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE VVD.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = COR.BKG_NO" ).append("\n"); 
		query.append("   AND (COR.CORR_NO <>'0000000001' AND COR.CORR_NO <> 'TMP0000001')" ).append("\n"); 
		query.append("   AND COR.CORR_CXL_FLG = 'N'" ).append("\n"); 
		query.append("   AND SKD.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("   AND SKD.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND SKD.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND SKD.VPS_PORT_CD = VVD.POD_CD" ).append("\n"); 
		query.append("   AND SKD.CLPT_IND_SEQ = VVD.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("    AND (               COR.ROUT_CORR_FLG        = 'Y' OR COR.CUST_CORR_FLG       = 'Y' OR    " ).append("\n"); 
		query.append("                        COR.QTY_CORR_FLG         = 'Y' OR COR.MEAS_QTY_CORR_FLG   = 'Y' OR    " ).append("\n"); 
		query.append("                        COR.CMDT_CORR_FLG        = 'Y' OR COR.TRNK_VSL_CORR_FLG   = 'Y' OR    " ).append("\n"); 
		query.append("                        COR.PRPST_VSL_CORR_FLG   = 'Y' OR COR.CA_OTR_RSN_CORR_FLG = 'Y' )" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("#if (${vvd} != '' && ${pk_tp} == 'vvd')" ).append("\n"); 
		query.append("           AND VVD.VSL_CD = SUBSTR(@[vvd], 0, 4)" ).append("\n"); 
		query.append("           AND VVD.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("           AND VVD.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${from_dt} != '' && ${pk_tp} == 'date')" ).append("\n"); 
		query.append("           AND COR.CORR_DT BETWEEN TO_DATE(@[from_dt],'YYYY-MM-DD HH24:MI') AND TO_DATE(@[to_dt],'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("#end       " ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("	#if (${pod_tp} == 'VVD') " ).append("\n"); 
		query.append("			AND VVD.POD_CD LIKE @[pod_cd] || '%'" ).append("\n"); 
		query.append("					" ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("			AND BKG.POD_CD LIKE @[pod_cd] || '%'	" ).append("\n"); 
		query.append("			AND BKG.POD_CD = VVD.POD_CD" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${del_cd} != '' && ${pk_tp} == 'vvd')" ).append("\n"); 
		query.append("   AND BKG.DEL_CD LIKE @[del_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no} != '' && ${pk_tp} == 'bl')" ).append("\n"); 
		query.append("   AND BKG.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}