/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOsearchEdiPHILSListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.09
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOsearchEdiPHILSListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdiPHILSList
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOsearchEdiPHILSListRSQL(){
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
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOsearchEdiPHILSListRSQL").append("\n"); 
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
		query.append("SELECT BL_SRC_NO," ).append("\n"); 
		query.append("  EDI_SND_DT," ).append("\n"); 
		query.append("  DECODE(ACK_RSLT_CD, 'A', 'Accept', 'R', 'Reject', '') ACK_RSLT_CD," ).append("\n"); 
		query.append("  FRT_USD_RT_AMT," ).append("\n"); 
		query.append("  OTR_USD_CONV_AMT," ).append("\n"); 
		query.append("  TTL_USD_AMT," ).append("\n"); 
		query.append("  VVD," ).append("\n"); 
		query.append("  SAIL_ARR_DT," ).append("\n"); 
		query.append("  PHILS_LOC_CD_CTNT, " ).append("\n"); 
		query.append("  CUST_REF_NO_CTNT," ).append("\n"); 
		query.append("  POR_CD," ).append("\n"); 
		query.append("  POL_CD," ).append("\n"); 
		query.append("  POD_CD," ).append("\n"); 
		query.append("  DEL_CD," ).append("\n"); 
		query.append("  INV_CUST_CNT_CD," ).append("\n"); 
		query.append("  INV_CUST_SEQ," ).append("\n"); 
		query.append("  ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("  ACT_CUST_SEQ, " ).append("\n"); 
		query.append("  OFC_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("  SELECT BL_SRC_NO," ).append("\n"); 
		query.append("    EDI_SND_DT," ).append("\n"); 
		query.append("    ACK_RSLT_CD," ).append("\n"); 
		query.append("    FRT_USD_RT_AMT," ).append("\n"); 
		query.append("    OTR_USD_CONV_AMT," ).append("\n"); 
		query.append("    TTL_USD_AMT," ).append("\n"); 
		query.append("    VVD," ).append("\n"); 
		query.append("    SAIL_ARR_DT," ).append("\n"); 
		query.append("    PHILS_LOC_CD_CTNT," ).append("\n"); 
		query.append("    CUST_REF_NO_CTNT," ).append("\n"); 
		query.append("    POR_CD," ).append("\n"); 
		query.append("    POL_CD," ).append("\n"); 
		query.append("    POD_CD," ).append("\n"); 
		query.append("    DEL_CD," ).append("\n"); 
		query.append("    INV_CUST_CNT_CD," ).append("\n"); 
		query.append("    INV_CUST_SEQ," ).append("\n"); 
		query.append("    ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("    ACT_CUST_SEQ," ).append("\n"); 
		query.append("    AR_OFC_CD AS OFC_CD," ).append("\n"); 
		query.append("    CASE WHEN EDI_SND_DT IS NULL" ).append("\n"); 
		query.append("                AND BL_SRC_NO = LEAD(BL_SRC_NO) OVER (ORDER BY BL_SRC_NO, EDI_SND_DT DESC)" ).append("\n"); 
		query.append("                AND FRT_USD_RT_AMT = LEAD(FRT_USD_RT_AMT) OVER (ORDER BY BL_SRC_NO, EDI_SND_DT DESC)" ).append("\n"); 
		query.append("                AND OTR_USD_CONV_AMT = LEAD(OTR_USD_CONV_AMT) OVER (ORDER BY BL_SRC_NO, EDI_SND_DT DESC)" ).append("\n"); 
		query.append("                AND TTL_USD_AMT = LEAD(TTL_USD_AMT) OVER (ORDER BY BL_SRC_NO, EDI_SND_DT DESC)" ).append("\n"); 
		query.append("           THEN 'N'" ).append("\n"); 
		query.append("         ELSE 'Y'" ).append("\n"); 
		query.append("    END IS_VIEW" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("    SELECT PHILS.BL_SRC_NO," ).append("\n"); 
		query.append("      TO_CHAR(PHILS.EDI_SND_DT, 'YYYY-MM-DD HH:MI:SS') EDI_SND_DT," ).append("\n"); 
		query.append("      ACK.ACK_RSLT_CD," ).append("\n"); 
		query.append("      PHILS.FRT_USD_RT_AMT," ).append("\n"); 
		query.append("      PHILS.OTR_USD_CONV_AMT," ).append("\n"); 
		query.append("      PHILS.TTL_USD_AMT," ).append("\n"); 
		query.append("      PHILS.VSL_CD || PHILS.SKD_VOY_NO || PHILS.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("      PHILS.SAIL_ARR_DT," ).append("\n"); 
		query.append("      PHILS.PHILS_LOC_CD_CTNT," ).append("\n"); 
		query.append("      PHILS.CUST_REF_NO_CTNT," ).append("\n"); 
		query.append("      PHILS.POR_CD," ).append("\n"); 
		query.append("      PHILS.POL_CD," ).append("\n"); 
		query.append("      PHILS.POD_CD," ).append("\n"); 
		query.append("      PHILS.DEL_CD," ).append("\n"); 
		query.append("      PHILS.INV_CUST_CNT_CD," ).append("\n"); 
		query.append("      LPAD(TO_CHAR(PHILS.INV_CUST_SEQ),6,'0') INV_CUST_SEQ," ).append("\n"); 
		query.append("      PHILS.ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("      PHILS.ACT_CUST_SEQ," ).append("\n"); 
		query.append("      PHILS.AR_OFC_CD" ).append("\n"); 
		query.append("    FROM INV_EDI_PHILS PHILS," ).append("\n"); 
		query.append("      INV_EDI_ACK ACK" ).append("\n"); 
		query.append("    WHERE PHILS.FLT_FILE_REF_NO = ACK.ACK_KEY_NO(+)" ).append("\n"); 
		query.append("      AND PHILS.AR_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#if (${retr_opt} == 'B')  -- B/L NO" ).append("\n"); 
		query.append("      AND PHILS.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${act_cust_cnt_cd} != '' && ${act_cust_seq} != ''  )" ).append("\n"); 
		query.append("      AND PHILS.ACT_CUST_CNT_CD = @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("      AND PHILS.ACT_CUST_SEQ = TO_NUMBER(@[act_cust_seq])" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${retr_opt} == 'S')  -- S/A DATE" ).append("\n"); 
		query.append("      AND PHILS.SAIL_ARR_DT BETWEEN REPLACE(@[fm_dt], '-', '') AND REPLACE(@[to_dt], '-', '') " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${retr_opt} == 'V')  -- VVD" ).append("\n"); 
		query.append("      AND PHILS.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("      AND PHILS.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("      AND PHILS.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${retr_opt} == 'E')" ).append("\n"); 
		query.append("      AND PHILS.EDI_SND_DT BETWEEN TO_DATE(@[fm_dt] || ' 00:00:00', 'YYYY-MM-DD HH24:MI:SS') AND TO_DATE(@[to_dt] || ' 23:59:59', 'YYYY-MM-DD HH24:MI:SS')     -- EDI_SND_DT 는 DATE TYPE 이므로 주의" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("    UNION" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("    SELECT T.BL_SRC_NO," ).append("\n"); 
		query.append("      '' EDI_SND_DT," ).append("\n"); 
		query.append("      '' ACK_RSLT_CD," ).append("\n"); 
		query.append("      T.FRT_USD_RT_AMT," ).append("\n"); 
		query.append("      T.OTR_USD_CONV_AMT," ).append("\n"); 
		query.append("      ( T.FRT_USD_RT_AMT + T.OTR_USD_CONV_AMT ) AS TTL_USD_AMT," ).append("\n"); 
		query.append("      T.VVD," ).append("\n"); 
		query.append("      T.SAIL_ARR_DT," ).append("\n"); 
		query.append("      (SELECT NVL(L.PHILS_LOC_CD_CTNT, '') FROM INV_EDI_PHILS_LOC L WHERE L.CUST_CNT_CD = T.INV_CUST_CNT_CD AND L.CUST_SEQ = T.INV_CUST_SEQ) PHILS_LOC_CD_CTNT," ).append("\n"); 
		query.append("      (SELECT NVL(CUST_REF_NO_CTNT, '') FROM BKG_REFERENCE WHERE BKG_NO = T.BKG_NO AND BKG_REF_TP_CD = 'FINV') CUST_REF_NO_CTNT,      " ).append("\n"); 
		query.append("      T.POR_CD," ).append("\n"); 
		query.append("      T.POL_CD," ).append("\n"); 
		query.append("      T.POD_CD," ).append("\n"); 
		query.append("      T.DEL_CD," ).append("\n"); 
		query.append("      T.INV_CUST_CNT_CD," ).append("\n"); 
		query.append("      T.INV_CUST_SEQ," ).append("\n"); 
		query.append("      T.ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("      T.ACT_CUST_SEQ," ).append("\n"); 
		query.append("      T.AR_OFC_CD" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("      SELECT A.BL_SRC_NO," ).append("\n"); 
		query.append("        A.BKG_NO," ).append("\n"); 
		query.append("       ( SELECT NVL(SUM(ROUND(B.CHG_AMT, 2)),0)" ).append("\n"); 
		query.append("         FROM  INV_AR_MN M , INV_AR_CHG B" ).append("\n"); 
		query.append("         WHERE M.BL_SRC_NO = A.BL_SRC_NO" ).append("\n"); 
		query.append("         AND M.AR_OFC_CD   = A.AR_OFC_CD" ).append("\n"); 
		query.append("         AND M.ACT_CUST_CNT_CD = A.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("         AND M.ACT_CUST_SEQ    = A.ACT_CUST_SEQ" ).append("\n"); 
		query.append("         AND M.INV_DELT_DIV_CD <> 'Y'" ).append("\n"); 
		query.append("         AND M.REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("         AND M.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("         AND B.CURR_CD  = 'USD' ) AS FRT_USD_RT_AMT," ).append("\n"); 
		query.append("       ( SELECT NVL(SUM(ROUND(B.CHG_AMT * B.INV_XCH_RT, 2)),0)" ).append("\n"); 
		query.append("         FROM   INV_AR_MN M , INV_AR_CHG B" ).append("\n"); 
		query.append("         WHERE M.BL_SRC_NO = A.BL_SRC_NO" ).append("\n"); 
		query.append("         AND M.AR_OFC_CD   = A.AR_OFC_CD" ).append("\n"); 
		query.append("         AND M.ACT_CUST_CNT_CD = A.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("         AND M.ACT_CUST_SEQ    = A.ACT_CUST_SEQ" ).append("\n"); 
		query.append("         AND M.INV_DELT_DIV_CD <> 'Y'" ).append("\n"); 
		query.append("         AND M.REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("         AND M.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("         AND B.CURR_CD <> 'USD' ) AS  OTR_USD_CONV_AMT," ).append("\n"); 
		query.append("        0 AS TTL_USD_AMT," ).append("\n"); 
		query.append("        A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("        A.SAIL_ARR_DT," ).append("\n"); 
		query.append("        A.POR_CD," ).append("\n"); 
		query.append("        A.POL_CD," ).append("\n"); 
		query.append("        A.POD_CD," ).append("\n"); 
		query.append("        A.DEL_CD, " ).append("\n"); 
		query.append("        A.INV_CUST_CNT_CD," ).append("\n"); 
		query.append("        LPAD(TO_CHAR(A.INV_CUST_SEQ),6,'0') INV_CUST_SEQ," ).append("\n"); 
		query.append("        A.ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("        A.ACT_CUST_SEQ," ).append("\n"); 
		query.append("        A.AR_OFC_CD" ).append("\n"); 
		query.append("      FROM INV_AR_MN A," ).append("\n"); 
		query.append("        (SELECT BL_SRC_NO, MAX(AR_IF_NO) AR_IF_NO" ).append("\n"); 
		query.append("         FROM INV_AR_MN" ).append("\n"); 
		query.append("         WHERE AR_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("    #if (${retr_opt} == 'B')  -- B/L NO" ).append("\n"); 
		query.append("           AND BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${act_cust_cnt_cd} != '' && ${act_cust_seq} != ''  )" ).append("\n"); 
		query.append("           AND ACT_CUST_CNT_CD = @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("           AND ACT_CUST_SEQ = TO_NUMBER(@[act_cust_seq])" ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("           AND INV_DELT_DIV_CD <> 'Y'" ).append("\n"); 
		query.append("           AND REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("         GROUP BY BL_SRC_NO" ).append("\n"); 
		query.append("        ) C" ).append("\n"); 
		query.append("      WHERE A.AR_IF_NO = C.AR_IF_NO" ).append("\n"); 
		query.append("#if (${retr_opt} == 'B')  -- B/L NO" ).append("\n"); 
		query.append("        AND A.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${retr_opt} == 'S')  -- S/A DATE" ).append("\n"); 
		query.append("        AND A.SAIL_ARR_DT BETWEEN REPLACE(@[fm_dt], '-', '') AND REPLACE(@[to_dt], '-', '')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${retr_opt} == 'V')  -- VVD" ).append("\n"); 
		query.append("		AND A.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("		AND A.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("		AND A.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    ) T" ).append("\n"); 
		query.append("   WHERE ( T.FRT_USD_RT_AMT + OTR_USD_CONV_AMT ) <> 0 " ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("  ORDER BY BL_SRC_NO, EDI_SND_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE IS_VIEW = 'Y'" ).append("\n"); 
		query.append("#if (${sent_stat} == 'Y')" ).append("\n"); 
		query.append("  AND EDI_SND_DT IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sent_stat} == 'N')" ).append("\n"); 
		query.append("  AND EDI_SND_DT IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}