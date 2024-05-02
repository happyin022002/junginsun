/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : InvoiceIssueDBDAOInvIssFilterForDupCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.18
*@LastModifier : 
*@LastVersion : 1.0
* 2018.05.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOInvIssFilterForDupCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvIssFilterForDup
	  * </pre>
	  */
	public InvoiceIssueDBDAOInvIssFilterForDupCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scp",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("if_user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("port",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("wrk_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bnd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOInvIssFilterForDupCSQL").append("\n"); 
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
		query.append("INSERT INTO INV_AR_ISS_FTR" ).append("\n"); 
		query.append("(TMP_ISS_NO" ).append("\n"); 
		query.append(",INV_ISS_WRK_NO,ACT_CUST_CNT_CD,ACT_CUST_SEQ,VSL_CD,SKD_VOY_NO,SKD_DIR_CD,IO_BND_CD,PORT_CD,SVC_SCP_CD,BL_SRC_NO,INV_SPLIT_CD,USD_XCH_RT     " ).append("\n"); 
		query.append(",INV_ISS_TP_CD,AR_IF_NO,CHG_CD,CURR_CD,AR_OFC_CD,CRE_USR_ID,UPD_USR_ID, RVS_CHG_FLG  ) " ).append("\n"); 
		query.append("SELECT INV_AR_ISS_TMP_SEQ.NEXTVAL" ).append("\n"); 
		query.append("	 ,T2.WRK_NO" ).append("\n"); 
		query.append("     , T2.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("     , T2.ACT_CUST_SEQ" ).append("\n"); 
		query.append("     , T2.VSL_CD" ).append("\n"); 
		query.append("     , T2.SKD_VOY_NO" ).append("\n"); 
		query.append("     , T2.SKD_DIR_CD" ).append("\n"); 
		query.append("     , T2.IO_BND_CD" ).append("\n"); 
		query.append("     , T2.PORT_CD" ).append("\n"); 
		query.append("     , T2.SVC_SCP_CD" ).append("\n"); 
		query.append("     , T2.BL_SRC_NO" ).append("\n"); 
		query.append("     , T2.INV_SPLIT_CD" ).append("\n"); 
		query.append("     , T2.USD_XCH_RT" ).append("\n"); 
		query.append("     , T2.INV_ISS_TP_CD" ).append("\n"); 
		query.append("     , T2.AR_IF_NO" ).append("\n"); 
		query.append("     , T2.CHG_CD" ).append("\n"); 
		query.append("     , T2.CURR_CD" ).append("\n"); 
		query.append("     , T2.AR_OFC_CD" ).append("\n"); 
		query.append("     , T2.USER_ID" ).append("\n"); 
		query.append("     , T2.USER_ID" ).append("\n"); 
		query.append("     , T2.RVS_CHG_FLG" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT @[wrk_no]            AS WRK_NO" ).append("\n"); 
		query.append("    , T.ACT_CUST_CNT_CD     AS ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("    , T.ACT_CUST_SEQ        AS ACT_CUST_SEQ" ).append("\n"); 
		query.append("    , T.VSL_CD              AS VSL_CD" ).append("\n"); 
		query.append("    , T.SKD_VOY_NO          AS SKD_VOY_NO" ).append("\n"); 
		query.append("    , T.SKD_DIR_CD          AS SKD_DIR_CD" ).append("\n"); 
		query.append("    , T.IO_BND_CD           AS IO_BND_CD" ).append("\n"); 
		query.append("    , DECODE(T.IO_BND_CD, 'I', T.POD_CD, T.POL_CD) AS PORT_CD" ).append("\n"); 
		query.append("    , T.SVC_SCP_CD          AS SVC_SCP_CD" ).append("\n"); 
		query.append("      #if (${inv_mlt_bl_iss_flg} != 'Y') " ).append("\n"); 
		query.append("    , T.BL_SRC_NO           AS BL_SRC_NO" ).append("\n"); 
		query.append("      #else" ).append("\n"); 
		query.append("    ,''						AS BL_SRC_NO" ).append("\n"); 
		query.append("	  #end" ).append("\n"); 
		query.append("    , NVL(DECODE(T.INV_SPLIT_CD, 'C','*', T.INV_SPLIT_CD),'*') AS INV_SPLIT_CD" ).append("\n"); 
		query.append("    , T.USD_XCH_RT          AS USD_XCH_RT" ).append("\n"); 
		query.append("	  #if (${ar_ofc_cd2} == 'BOMSC' && (${ind_iss_tp_cd} == 'P' || ${ind_iss_tp_cd} == 'T')) 	--2017.07.20 인도 GST 세법 변경 관련 보완" ).append("\n"); 
		query.append("    , 'S' 					AS INV_ISS_TP_CD" ).append("\n"); 
		query.append("	  #else" ).append("\n"); 
		query.append("    , I.INV_ISS_TP_CD       AS INV_ISS_TP_CD" ).append("\n"); 
		query.append("	  #end" ).append("\n"); 
		query.append("    , T.AR_IF_NO            AS AR_IF_NO" ).append("\n"); 
		query.append("    , G.CHG_CD              AS CHG_CD" ).append("\n"); 
		query.append("    , G.CURR_CD             AS CURR_CD" ).append("\n"); 
		query.append("    , T.AR_OFC_CD           AS AR_OFC_CD    " ).append("\n"); 
		query.append("    , @[user_id]            AS USER_ID" ).append("\n"); 
		query.append("    , SUM(G.CHG_AMT) OVER (PARTITION BY  T.BL_SRC_NO" ).append("\n"); 
		query.append("                                       , T.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("                                       , T.ACT_CUST_SEQ" ).append("\n"); 
		query.append("                                       , T.VSL_CD" ).append("\n"); 
		query.append("                                       , T.SKD_VOY_NO" ).append("\n"); 
		query.append("                                       , T.SKD_DIR_CD" ).append("\n"); 
		query.append("                                       , T.IO_BND_CD" ).append("\n"); 
		query.append("                                       , T.USD_XCH_RT" ).append("\n"); 
		query.append("                                       , DECODE(T.IO_BND_CD, 'I', T.POD_CD, T.POL_CD)" ).append("\n"); 
		query.append("                                       , T.SVC_SCP_CD" ).append("\n"); 
		query.append("                                       , G.CURR_CD" ).append("\n"); 
		query.append("                                       , G.CHG_CD  ) AS AMT" ).append("\n"); 
		query.append("     , T.REV_TP_CD          AS REV_TP_CD" ).append("\n"); 
		query.append("     , T.REV_SRC_CD         AS REV_SRC_CD" ).append("\n"); 
		query.append("     , T.RVS_CHG_FLG        AS RVS_CHG_FLG" ).append("\n"); 
		query.append("FROM INV_AR_MN  T" ).append("\n"); 
		query.append("   , INV_AR_CHG G" ).append("\n"); 
		query.append("   , INV_AR_STUP_OFC I   " ).append("\n"); 
		query.append("WHERE T.AR_IF_NO = G.AR_IF_NO" ).append("\n"); 
		query.append("  AND T.AR_OFC_CD = I.AR_OFC_CD" ).append("\n"); 
		query.append("  AND T.AR_OFC_CD = @[ar_ofc_cd2]" ).append("\n"); 
		query.append("  AND NVL(T.INV_DELT_DIV_CD, 'N') <> 'Y'  " ).append("\n"); 
		query.append("  AND T.INV_CLR_FLG = 'N' " ).append("\n"); 
		query.append("  #if (${rev_type} != '')" ).append("\n"); 
		query.append("  	#if (${rev_type} == 'M')     " ).append("\n"); 
		query.append("    AND T.REV_TP_CD = 'M'" ).append("\n"); 
		query.append("    #elseif (${rev_type} == 'F')     " ).append("\n"); 
		query.append("    AND T.REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${from_dt} != '' && ${to_dt} != '') " ).append("\n"); 
		query.append("     #if (${dt_option} == 'G') " ).append("\n"); 
		query.append("     AND T.BL_INV_CFM_DT BETWEEN REPLACE(@[from_dt],'-','') AND REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("	 #else" ).append("\n"); 
		query.append("     AND T.UPD_DT >= TO_DATE(REPLACE(@[from_dt],'-',''), 'YYYYMMDD') AND T.UPD_DT < TO_DATE(REPLACE(@[to_dt],'-',''), 'YYYYMMDD') + 1" ).append("\n"); 
		query.append("     AND T.UPD_USR_ID = @[user_id]" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append(" #if (${bl_nos} != '') " ).append("\n"); 
		query.append("   AND T.BL_SRC_NO IN (${bl_nos})" ).append("\n"); 
		query.append(" #end                                                 " ).append("\n"); 
		query.append(" #if (${cust_cnt_cd} != '') " ).append("\n"); 
		query.append("   AND T.ACT_CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${cust_seq} != '') " ).append("\n"); 
		query.append("   AND T.ACT_CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${if_user_id} != '') " ).append("\n"); 
		query.append("   AND T.UPD_USR_ID = @[if_user_id]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${vvd} != '') " ).append("\n"); 
		query.append("   AND T.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND T.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4) " ).append("\n"); 
		query.append("   AND T.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${port} != '') " ).append("\n"); 
		query.append("   AND DECODE(T.IO_BND_CD, 'I', T.POD_CD, T.POL_CD) = @[port]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${scp} != '') " ).append("\n"); 
		query.append("   AND T.SVC_SCP_CD = @[scp]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${bnd} != 'A' && ${bnd} != '')     " ).append("\n"); 
		query.append("   AND T.IO_BND_CD = @[bnd]" ).append("\n"); 
		query.append(" #end                                 " ).append("\n"); 
		query.append(" #if (${inv_dup_flg} != 'Y') " ).append("\n"); 
		query.append("   AND T.INV_ISS_FLG = 'N'   " ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(") T2" ).append("\n"); 
		query.append(", MDM_CUSTOMER F" ).append("\n"); 
		query.append("WHERE --T2.AMT <> 0" ).append("\n"); 
		query.append("  NOT EXISTS ( SELECT 'X'" ).append("\n"); 
		query.append("                     FROM INV_AR_MN S" ).append("\n"); 
		query.append("                    WHERE S.AR_OFC_CD = T2.AR_OFC_CD   " ).append("\n"); 
		query.append("                      AND S.BL_SRC_NO = T2.BL_SRC_NO                                          " ).append("\n"); 
		query.append("                      AND NVL(S.INV_DELT_DIV_CD, 'N') <> 'Y' " ).append("\n"); 
		query.append("                      --AND ( S.BL_INV_CFM_DT IS NULL  OR  S.USD_XCH_RT = 0 )" ).append("\n"); 
		query.append("					  AND (S.INV_CLR_FLG = 'N' AND ( S.BL_INV_CFM_DT IS NULL  OR  S.USD_XCH_RT = 0 ) )" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("  AND T2.ACT_CUST_CNT_CD||T2.ACT_CUST_SEQ NOT IN (SELECT DECODE(T2.REV_TP_CD||T2.REV_SRC_CD,'MTH','XX','MTP','XX', S2.REP_CUST_CNT_CD||S2.REP_CUST_SEQ)" ).append("\n"); 
		query.append("                                                    FROM INV_AR_STUP_OFC S1" ).append("\n"); 
		query.append("                                                        ,MDM_ORGANIZATION S2" ).append("\n"); 
		query.append("                                                   WHERE S1.AR_OFC_CD = @[ar_ofc_cd2]" ).append("\n"); 
		query.append("                                                     AND S1.OTS_SMRY_CD <> 'BL'" ).append("\n"); 
		query.append("                                                     AND S1.AR_OFC_CD = S2.AR_OFC_CD" ).append("\n"); 
		query.append("                                                     AND S2.REP_CUST_CNT_CD IS NOT NULL" ).append("\n"); 
		query.append("                                                     AND S2.REP_CUST_SEQ IS NOT NULL" ).append("\n"); 
		query.append("                                                     AND S2.DELT_FLG = 'N')" ).append("\n"); 
		query.append("  AND T2.ACT_CUST_CNT_CD = F.CUST_CNT_CD" ).append("\n"); 
		query.append("  AND T2.ACT_CUST_SEQ    = F.CUST_SEQ" ).append("\n"); 
		query.append("  AND NVL(F.CNTR_DIV_FLG, 'N') = 'Y'" ).append("\n"); 
		query.append("  AND F.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("#if (${ar_ofc_cd2} == 'BOMSC') 			--2017.07.20 인도 GST 세법 변경 관련 보완" ).append("\n"); 
		query.append("    #if (${ind_iss_tp_cd} == 'P' || ${ind_iss_tp_cd} == 'T') " ).append("\n"); 
		query.append("        AND NOT EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                        FROM INV_AR_MN" ).append("\n"); 
		query.append("                        WHERE AR_OFC_CD = T2.AR_OFC_CD" ).append("\n"); 
		query.append("                        AND BL_SRC_NO = T2.BL_SRC_NO" ).append("\n"); 
		query.append("                        AND NVL(IDA_ISS_TP_CD, 'P') IN ('T', 'C', 'D'))" ).append("\n"); 
		query.append("		-- 2018.05.16 인도지역 Split Invoice Issue 기능 보완 " ).append("\n"); 
		query.append("        AND NOT EXISTS (SELECT 'X'      " ).append("\n"); 
		query.append("                        FROM INV_AR_MN" ).append("\n"); 
		query.append("                        WHERE AR_OFC_CD = T2.AR_OFC_CD" ).append("\n"); 
		query.append("                        AND BL_SRC_NO = T2.BL_SRC_NO" ).append("\n"); 
		query.append("                        AND NVL(IDA_INV_SPLIT_FLG, 'N') = 'Y')" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}