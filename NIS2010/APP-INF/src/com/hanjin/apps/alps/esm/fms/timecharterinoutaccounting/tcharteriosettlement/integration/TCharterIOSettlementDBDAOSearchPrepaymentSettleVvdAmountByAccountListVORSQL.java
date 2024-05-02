/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOSettlementDBDAOSearchPrepaymentSettleVvdAmountByAccountListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.20
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2015.10.20 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son, Jin-Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOSettlementDBDAOSearchPrepaymentSettleVvdAmountByAccountListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 미 정리된 선급금 전표를 항차별로 분리한 목록 중 계정별 csr_amt합계를 가져온다
	  * </pre>
	  */
	public TCharterIOSettlementDBDAOSearchPrepaymentSettleVvdAmountByAccountListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_slp_iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_slp_seq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_slip_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_slp_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_slp_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_slp_func_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_slp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.integration").append("\n"); 
		query.append("FileName : TCharterIOSettlementDBDAOSearchPrepaymentSettleVvdAmountByAccountListVORSQL").append("\n"); 
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
		query.append("ACCT_CD," ).append("\n"); 
		query.append("SUM(CSR_AMT) AS CSR_AMT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT 	@[acct_cd] ACCT_CD, @[vndr_seq] VNDR_SEQ, @[ctr_cd] CTR_CD," ).append("\n"); 
		query.append("		@[slp_loc_cd] SLP_LOC_CD, REPLACE(@[eff_dt],'-','') EFF_DT, " ).append("\n"); 
		query.append("		@[slp_desc] CSR_DESC, NULL PPAY_HIR_NO, TO_NUMBER(@[inv_seq]) INV_SEQ," ).append("\n"); 
		query.append("		CASE WHEN A.VED_DT IS NULL THEN 'NOVVD'" ).append("\n"); 
		query.append("	 		 WHEN A.VED_DT < A.EXP_DT THEN 'NOVVD'" ).append("\n"); 
		query.append("	 		 WHEN DISCNT > 0 THEN 'DISVVD'" ).append("\n"); 
		query.append("	 		 ELSE '' END VVD_CD," ).append("\n"); 
		query.append("       	'' VSL_CD, '' SKD_VOY_NO, '' SKD_DIR_CD, '' REV_DIR_CD," ).append("\n"); 
		query.append("       	@[org_slip_no] SLP_KEY_NO," ).append("\n"); 
		query.append("		@[org_slp_tp_cd] ORG_SLP_TP_CD," ).append("\n"); 
		query.append("		@[org_slp_func_cd] ORG_SLP_FUNC_CD," ).append("\n"); 
		query.append("		@[org_slp_ofc_cd] ORG_SLP_OFC_CD," ).append("\n"); 
		query.append("		@[org_slp_iss_dt] ORG_SLP_ISS_DT," ).append("\n"); 
		query.append("		@[org_slp_ser_no] ORG_SLP_SER_NO," ).append("\n"); 
		query.append("		@[org_slp_seq_no] ORG_SLP_SEQ_NO," ).append("\n"); 
		query.append("		TO_CHAR(TO_DATE(@[vvd_eff_dt],'YYYYMMDD'),'YYYY-MM-DD') START_DT," ).append("\n"); 
		query.append("		TO_CHAR(TO_DATE(@[vvd_exp_dt],'YYYYMMDD'),'YYYY-MM-DD') END_DT," ).append("\n"); 
		query.append("       	TO_NUMBER(@[slp_amt])*-1 CSR_AMT," ).append("\n"); 
		query.append("		TO_NUMBER(@[slp_amt])*-1/" ).append("\n"); 
		query.append("		DECODE(@[csr_curr_cd], 'USD', 1, (SELECT NVL(EX1.USD_LOCL_XCH_RT,1)  " ).append("\n"); 
		query.append("										  FROM 	 GL_MON_XCH_RT EX1" ).append("\n"); 
		query.append("										  WHERE  EX1.CURR_CD = @[csr_curr_cd] " ).append("\n"); 
		query.append("										  AND    EX1.ACCT_XCH_RT_YRMON = SUBSTR(REPLACE(@[eff_dt],'-',''),1,6) " ).append("\n"); 
		query.append("										  AND    EX1.ACCT_XCH_RT_LVL = '1')) TRNS_AMT" ).append("\n"); 
		query.append("FROM    DUAL, (SELECT 	MIN(A.VST_DT) VST_DT, TO_CHAR(MIN(B.EFF_DT),'YYYYMMDD') EFF_DT," ).append("\n"); 
		query.append("						MAX(A.VED_DT) VED_DT, TO_CHAR(MAX(DECODE(B.EXP_DT,TRUNC(B.EXP_DT),B.EXP_DT-1,B.EXP_DT)),'YYYYMMDD') EXP_DT" ).append("\n"); 
		query.append("				FROM 	FMS_VVD A, FMS_INV_DTL B" ).append("\n"); 
		query.append("				WHERE 	A.VSL_CD IN (SELECT @[vsl_cd] FROM DUAL " ).append("\n"); 
		query.append("									 UNION ALL " ).append("\n"); 
		query.append("									 SELECT VSL_CD FROM FMS_ID_VSL " ).append("\n"); 
		query.append("									  WHERE FLET_CTRT_NO = @[flet_ctrt_no] " ).append("\n"); 
		query.append("										AND USE_FLG = 'Y')" ).append("\n"); 
		query.append("				AND 	B.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("				AND 	A.VST_DT <= @[vvd_exp_dt]" ).append("\n"); 
		query.append("				AND 	A.VED_DT >= @[vvd_eff_dt]" ).append("\n"); 
		query.append("				AND		A.VST_DT < TO_CHAR(B.EXP_DT, 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("				AND		A.VED_DT >= TO_CHAR(B.EFF_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("				AND 	B.FLET_ISS_TP_CD = 'PRE'" ).append("\n"); 
		query.append("				AND 	B.SLP_TP_CD  = @[org_slp_tp_cd]" ).append("\n"); 
		query.append("				AND 	B.SLP_FUNC_CD= @[org_slp_func_cd]" ).append("\n"); 
		query.append("				AND 	B.SLP_OFC_CD = @[org_slp_ofc_cd]" ).append("\n"); 
		query.append("				AND 	B.SLP_ISS_DT = @[org_slp_iss_dt]" ).append("\n"); 
		query.append("				AND 	B.SLP_SER_NO = @[org_slp_ser_no]" ).append("\n"); 
		query.append("				-- AND 	B.ACCT_CD = '510911'" ).append("\n"); 
		query.append("              ) A," ).append("\n"); 
		query.append("	   (SELECT SUM(CASE WHEN A.VED_DT <> TO_CHAR(TO_DATE(B.VST_DT,'YYYYMMDD')-1,'YYYYMMDD') THEN 1 ELSE 0 END) DISCNT" ).append("\n"); 
		query.append("		FROM   (SELECT A.VST_DT, A.VED_DT, row_number() over(partition by vsl_cd order by VST_DT desc) row_num" ).append("\n"); 
		query.append("				FROM   FMS_VVD A" ).append("\n"); 
		query.append("				WHERE A.VSL_CD IN (SELECT @[vsl_cd] FROM DUAL " ).append("\n"); 
		query.append("								   UNION ALL SELECT VSL_CD FROM FMS_ID_VSL " ).append("\n"); 
		query.append("								   WHERE FLET_CTRT_NO = @[flet_ctrt_no] " ).append("\n"); 
		query.append("									 AND USE_FLG = 'Y')" ).append("\n"); 
		query.append("						AND 	A.VST_DT < @[vvd_exp_dt]" ).append("\n"); 
		query.append("						AND 	A.VED_DT >= @[vvd_eff_dt]) A," ).append("\n"); 
		query.append("			   (SELECT A.VST_DT, A.VED_DT, row_number() over(partition by vsl_cd order by VST_DT desc) row_num" ).append("\n"); 
		query.append("				FROM   FMS_VVD A" ).append("\n"); 
		query.append("				WHERE A.VSL_CD IN (SELECT @[vsl_cd] FROM DUAL " ).append("\n"); 
		query.append("								   UNION ALL SELECT VSL_CD FROM FMS_ID_VSL " ).append("\n"); 
		query.append("								   WHERE FLET_CTRT_NO = @[flet_ctrt_no] " ).append("\n"); 
		query.append("									 AND USE_FLG = 'Y')" ).append("\n"); 
		query.append("						AND 	A.VST_DT < @[vvd_exp_dt]" ).append("\n"); 
		query.append("						AND 	A.VED_DT >= @[vvd_eff_dt]) B" ).append("\n"); 
		query.append("		WHERE A.ROW_NUM =B.ROW_NUM+1) B" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    ACCT_CD, VNDR_SEQ, CTR_CD, SLP_LOC_CD, EFF_DT, CSR_DESC, PPAY_HIR_NO," ).append("\n"); 
		query.append("    INV_SEQ, VVD_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD," ).append("\n"); 
		query.append("    '' SLP_KEY_NO," ).append("\n"); 
		query.append("	'' ORG_SLP_TP_CD," ).append("\n"); 
		query.append("	'' ORG_SLP_FUNC_CD," ).append("\n"); 
		query.append("	'' ORG_SLP_OFC_CD," ).append("\n"); 
		query.append("	'' ORG_SLP_ISS_DT," ).append("\n"); 
		query.append("	'' ORG_SLP_SER_NO," ).append("\n"); 
		query.append("	'' ORG_SLP_SEQ_NO," ).append("\n"); 
		query.append("    TO_CHAR(START_DT, 'YYYY-MM-DD') START_DT," ).append("\n"); 
		query.append("    TO_CHAR(END_DT, 'YYYY-MM-DD') END_DT," ).append("\n"); 
		query.append("    ROUND(TTL_AMT, 2) CSR_AMT," ).append("\n"); 
		query.append("	TRUNC(TTL_AMT  / DECODE(@[csr_curr_cd], 'USD', 1, (SELECT NVL(EX1.USD_LOCL_XCH_RT,1) " ).append("\n"); 
		query.append("										  FROM 	 GL_MON_XCH_RT EX1" ).append("\n"); 
		query.append("										  WHERE  EX1.CURR_CD = @[csr_curr_cd] " ).append("\n"); 
		query.append("										  AND    EX1.ACCT_XCH_RT_YRMON = SUBSTR(REPLACE(@[eff_dt],'-',''),1,6) " ).append("\n"); 
		query.append("										  AND    EX1.ACCT_XCH_RT_LVL = '1')), 2) TRNS_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT SEQ_DT ," ).append("\n"); 
		query.append("     	   DT_AMT," ).append("\n"); 
		query.append("           MI_AMT ," ).append("\n"); 
		query.append("      	   SUM(DT_AMT) OVER (PARTITION BY START_DT, END_DT) TTL_AMT ," ).append("\n"); 
		query.append("      	   ROW_NUMBER() OVER (PARTITION BY START_DT, END_DT" ).append("\n"); 
		query.append("                ORDER BY SEQ_DT) AS MAX_SEQ ," ).append("\n"); 
		query.append("           START_DT," ).append("\n"); 
		query.append("           END_DT" ).append("\n"); 
		query.append("           ,ACCT_CD, VNDR_SEQ, CTR_CD, SLP_LOC_CD, EFF_DT, CSR_DESC, PPAY_HIR_NO," ).append("\n"); 
		query.append("           INV_SEQ, VVD_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("    FROM " ).append("\n"); 
		query.append("     ( -- HAP" ).append("\n"); 
		query.append("        SELECT   SEQ_DT ," ).append("\n"); 
		query.append("         		 DT_AMT," ).append("\n"); 
		query.append("         		 MI_AMT ," ).append("\n"); 
		query.append("         		 DT ," ).append("\n"); 
		query.append("          		 MIN(DT) OVER () AS MIN_DT ," ).append("\n"); 
		query.append("         		 MAX(DT) OVER () AS MAX_DT ," ).append("\n"); 
		query.append("         		 NVL(START_DT, MAX(START_DT) OVER (ORDER BY SEQ_DT)) AS START_DT ," ).append("\n"); 
		query.append("         		 NVL(END_DT , MAX(END_DT ) OVER ( ORDER BY SEQ_DT)) AS END_DT" ).append("\n"); 
		query.append("                ,ACCT_CD, VNDR_SEQ, CTR_CD, SLP_LOC_CD, EFF_DT, CSR_DESC, PPAY_HIR_NO," ).append("\n"); 
		query.append("                INV_SEQ, VVD_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD" ).append("\n"); 
		query.append("        FROM " ).append("\n"); 
		query.append("        (  --T11" ).append("\n"); 
		query.append("          SELECT  START_DT, END_DT,DT, ACCT_CD, VNDR_SEQ, CTR_CD, SLP_LOC_CD, EFF_DT, CSR_DESC, PPAY_HIR_NO," ).append("\n"); 
		query.append("                  INV_SEQ, VVD_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD" ).append("\n"); 
		query.append("          FROM    " ).append("\n"); 
		query.append("           ( --AA" ).append("\n"); 
		query.append("            SELECT START_DT," ).append("\n"); 
		query.append("                   END_DT ," ).append("\n"); 
		query.append("                   MAX(DECODE(NO, 1, START_DT, END_DT)) AS DT," ).append("\n"); 
		query.append("                   ACCT_CD, VNDR_SEQ, CTR_CD, SLP_LOC_CD, EFF_DT, CSR_DESC, PPAY_HIR_NO," ).append("\n"); 
		query.append("                   INV_SEQ, VVD_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD" ).append("\n"); 
		query.append("            FROM " ).append("\n"); 
		query.append("             ( --T01" ).append("\n"); 
		query.append("                SELECT CASE WHEN A.VST_DT <= TO_CHAR(B.EFF_DT, 'YYYYMMDD') THEN  TO_DATE(TO_CHAR(B.EFF_DT, 'YYYYMMDD'), 'YYYYMMDD') ELSE TO_DATE(A.VST_DT, 'YYYYMMDD') END AS START_DT ," ).append("\n"); 
		query.append("                       CASE WHEN A.VED_DT >= TO_CHAR(B.EXP_DT, 'YYYYMMDD') THEN TO_DATE(TO_CHAR(DECODE(B.EXP_DT, TRUNC(B.EXP_DT), B.EXP_DT-1," ).append("\n"); 
		query.append("                              DECODE(B.INV_USD_DYS /  DECODE(TRUNC(B.INV_USD_DYS), 0, 1), 1,  B.EXP_DT-1,  B.EXP_DT )), 'YYYYMMDD'), 'YYYYMMDD') ELSE TO_DATE(A.VED_DT, 'YYYYMMDD') END AS END_DT," ).append("\n"); 
		query.append("                       B.ACCT_CD, @[vndr_seq] VNDR_SEQ, @[ctr_cd] CTR_CD," ).append("\n"); 
		query.append("		               @[slp_loc_cd] SLP_LOC_CD, REPLACE(@[eff_dt],'-','') EFF_DT," ).append("\n"); 
		query.append("		               (SELECT ACCT_ITM_NM FROM FMS_ACCT_ITM WHERE ACCT_CD = B.ACCT_CD AND ACCT_ITM_SEQ = B.ACCT_ITM_SEQ) CSR_DESC, " ).append("\n"); 
		query.append("		               F.PPAY_HIR_NO, F.INV_SEQ," ).append("\n"); 
		query.append("		               A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD VVD_CD," ).append("\n"); 
		query.append("		               A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD" ).append("\n"); 
		query.append("                FROM FMS_VVD A, FMS_INVOICE F, FMS_INV_DTL B" ).append("\n"); 
		query.append("                WHERE A.VSL_CD IN (" ).append("\n"); 
		query.append("                    SELECT @[vsl_cd]" ).append("\n"); 
		query.append("                    FROM DUAL" ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("                    SELECT VSL_CD" ).append("\n"); 
		query.append("                    FROM FMS_ID_VSL" ).append("\n"); 
		query.append("                    WHERE FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("                      AND USE_FLG = 'Y')" ).append("\n"); 
		query.append("                  AND F.FLET_CTRT_NO = B.FLET_CTRT_NO" ).append("\n"); 
		query.append("                  AND F.FLET_ISS_TP_CD = B.FLET_ISS_TP_CD" ).append("\n"); 
		query.append("                  AND F.INV_SEQ = B.INV_SEQ" ).append("\n"); 
		query.append("                  AND B.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("                  AND B.FLET_ISS_TP_CD = 'PRE'" ).append("\n"); 
		query.append("                  AND B.SLP_TP_CD = @[org_slp_tp_cd]" ).append("\n"); 
		query.append("                  AND B.SLP_FUNC_CD= @[org_slp_func_cd]" ).append("\n"); 
		query.append("                  AND B.SLP_OFC_CD = @[org_slp_ofc_cd]" ).append("\n"); 
		query.append("                  AND B.SLP_ISS_DT = @[org_slp_iss_dt]" ).append("\n"); 
		query.append("                  AND B.SLP_SER_NO = @[org_slp_ser_no]" ).append("\n"); 
		query.append("                  AND B.ACCT_CD = '510911'" ).append("\n"); 
		query.append("                  AND A.VST_DT <= @[vvd_exp_dt]" ).append("\n"); 
		query.append("                  AND A.VED_DT >= @[vvd_eff_dt]" ).append("\n"); 
		query.append("                  AND A.VST_DT < TO_CHAR(B.EXP_DT, 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("                  AND A.VED_DT >= TO_CHAR(B.EFF_DT, 'YYYYMMDD') ) T01," ).append("\n"); 
		query.append("              (" ).append("\n"); 
		query.append("                SELECT 1 NO" ).append("\n"); 
		query.append("                FROM DUAL" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT 2" ).append("\n"); 
		query.append("                FROM DUAL" ).append("\n"); 
		query.append("              ) T02" ).append("\n"); 
		query.append("              GROUP BY START_DT, END_DT, NO" ).append("\n"); 
		query.append("                , ACCT_CD, VNDR_SEQ, CTR_CD,SLP_LOC_CD, EFF_DT, CSR_DESC, PPAY_HIR_NO, INV_SEQ, VVD_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD" ).append("\n"); 
		query.append("           )  --AA" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           WHERE START_DT <= END_DT" ).append("\n"); 
		query.append("           GROUP BY START_DT, END_DT , dt  , ACCT_CD, VNDR_SEQ, CTR_CD, SLP_LOC_CD, EFF_DT, CSR_DESC, PPAY_HIR_NO," ).append("\n"); 
		query.append("                  INV_SEQ, VVD_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD              " ).append("\n"); 
		query.append("          ) T11," ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("          (  --T12" ).append("\n"); 
		query.append("            SELECT SEQ_DT," ).append("\n"); 
		query.append("              --CUR," ).append("\n"); 
		query.append("              ORG_DT_AMT," ).append("\n"); 
		query.append("              MI_AMT ," ).append("\n"); 
		query.append("              SEQ_DT2 ," ).append("\n"); 
		query.append("              MI_AMT * (END_DT - SEQ_DT) * (24*60) AS DT_AMT" ).append("\n"); 
		query.append("            FROM " ).append("\n"); 
		query.append("            (  -- BB" ).append("\n"); 
		query.append("                SELECT --CUR," ).append("\n"); 
		query.append("                  DT_AMT AS ORG_DT_AMT," ).append("\n"); 
		query.append("                  MI_AMT ," ).append("\n"); 
		query.append("                  EFF_DT + SEQ AS SEQ_DT ," ).append("\n"); 
		query.append("                  TO_DATE(TO_CHAR(EFF_DT + SEQ, 'YYYYMMDD'), 'YYYYMMDD') SEQ_DT2 ," ).append("\n"); 
		query.append("                  NVL(LEAD(EFF_DT + SEQ) OVER (ORDER BY EXP_DT, SEQ), EXP_DT) AS END_DT" ).append("\n"); 
		query.append("                FROM " ).append("\n"); 
		query.append("                ( --T01" ).append("\n"); 
		query.append("                    SELECT " ).append("\n"); 
		query.append("                     CASE WHEN  F.EFF_DT >  H.EFF_DT THEN  F.EFF_DT ELSE H.EFF_DT  END AS EFF_DT ," ).append("\n"); 
		query.append("                     CASE WHEN  F.EXP_DT >  H.EXP_DT THEN  H.EXP_DT ELSE F.EXP_DT  END AS EXP_DT ," ).append("\n"); 
		query.append("                      CASE WHEN @[csr_curr_cd] = H.HIR_CURR_N1ST_CD THEN   H.HIR_RT_N1ST_AMT  ELSE H.HIR_RT_N2ND_AMT   END AS DT_AMT ," ).append("\n"); 
		query.append("                      CASE WHEN @[csr_curr_cd] = H.HIR_CURR_N1ST_CD THEN   H.HIR_RT_N1ST_AMT / (24 * 60) ELSE  H.HIR_RT_N2ND_AMT / (24 * 60)   END AS MI_AMT," ).append("\n"); 
		query.append("                      (H.EXP_DT - H.EFF_DT) AS TM" ).append("\n"); 
		query.append("                    FROM FMS_HIRE H, FMS_INVOICE F, FMS_INV_DTL B" ).append("\n"); 
		query.append("                    WHERE H.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("                    AND   (H.HIR_CURR_N1ST_CD = @[csr_curr_cd]  OR H.HIR_CURR_N2ND_CD = @[csr_curr_cd] )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                  AND H.FLET_CTRT_NO = F.FLET_CTRT_NO" ).append("\n"); 
		query.append("                  AND F.FLET_CTRT_NO = B.FLET_CTRT_NO" ).append("\n"); 
		query.append("                  AND F.FLET_ISS_TP_CD = B.FLET_ISS_TP_CD" ).append("\n"); 
		query.append("                  AND F.INV_SEQ = B.INV_SEQ" ).append("\n"); 
		query.append("                  AND B.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("                  AND B.FLET_ISS_TP_CD = 'PRE'" ).append("\n"); 
		query.append("                  AND B.SLP_TP_CD = @[org_slp_tp_cd]" ).append("\n"); 
		query.append("                  AND B.SLP_FUNC_CD= @[org_slp_func_cd]" ).append("\n"); 
		query.append("                  AND B.SLP_OFC_CD = @[org_slp_ofc_cd]" ).append("\n"); 
		query.append("                  AND B.SLP_ISS_DT = @[org_slp_iss_dt]" ).append("\n"); 
		query.append("                  AND B.SLP_SER_NO = @[org_slp_ser_no]" ).append("\n"); 
		query.append("                  AND B.ACCT_CD = '510911'" ).append("\n"); 
		query.append("                  ) T01," ).append("\n"); 
		query.append("                  (" ).append("\n"); 
		query.append("                    SELECT ROWNUM - 1 AS SEQ" ).append("\n"); 
		query.append("                    FROM MDM_VENDOR" ).append("\n"); 
		query.append("                    WHERE ROWNUM <= 5000" ).append("\n"); 
		query.append("                  ) T02" ).append("\n"); 
		query.append("                WHERE SEQ BETWEEN 0 AND TM" ).append("\n"); 
		query.append("                AND EFF_DT + SEQ  <= EXP_DT" ).append("\n"); 
		query.append("				AND EFF_DT <> EXP_DT" ).append("\n"); 
		query.append("              )  -- BB" ).append("\n"); 
		query.append("           ) T12" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("          --AND T11.DT(+) = T12.SEQ_DT2" ).append("\n"); 
		query.append("          AND TO_DATE(TO_CHAR(T11.DT(+), 'YYYYMMDD'), 'YYYYMMDD') = T12.SEQ_DT2" ).append("\n"); 
		query.append("        ORDER BY T12.SEQ_DT " ).append("\n"); 
		query.append("    )  --HAP" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("      --AND TO_DATE(TO_CHAR(SEQ_DT, 'YYYYMMDD'), 'YYYYMMDD') BETWEEN MIN_DT AND MAX_DT " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE MAX_SEQ = 1 " ).append("\n"); 
		query.append("AND ROUND(TTL_AMT, 2) > 0" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  B.ACCT_CD, @[vndr_seq] VNDR_SEQ, @[ctr_cd] CTR_CD," ).append("\n"); 
		query.append("		@[slp_loc_cd] SLP_LOC_CD, REPLACE(@[eff_dt],'-','') EFF_DT," ).append("\n"); 
		query.append("		(SELECT ACCT_ITM_NM FROM FMS_ACCT_ITM WHERE ACCT_CD = B.ACCT_CD AND ACCT_ITM_SEQ = B.ACCT_ITM_SEQ) CSR_DESC, " ).append("\n"); 
		query.append("		F.PPAY_HIR_NO, F.INV_SEQ," ).append("\n"); 
		query.append("		A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD VVD_CD," ).append("\n"); 
		query.append("		A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD," ).append("\n"); 
		query.append("		'' SLP_KEY_NO," ).append("\n"); 
		query.append("		'' ORG_SLP_TP_CD," ).append("\n"); 
		query.append("		'' ORG_SLP_FUNC_CD," ).append("\n"); 
		query.append("		'' ORG_SLP_OFC_CD," ).append("\n"); 
		query.append("		'' ORG_SLP_ISS_DT," ).append("\n"); 
		query.append("		'' ORG_SLP_SER_NO," ).append("\n"); 
		query.append("		'' ORG_SLP_SEQ_NO," ).append("\n"); 
		query.append("		TO_CHAR(CASE WHEN A.VST_DT <= TO_CHAR(B.EFF_DT,'YYYYMMDD') THEN B.EFF_DT ELSE TO_DATE(A.VST_DT,'YYYYMMDD') END,'YYYY-MM-DD') START_DT," ).append("\n"); 
		query.append("		TO_CHAR(CASE WHEN A.VED_DT >= TO_CHAR(B.EXP_DT,'YYYYMMDD') THEN DECODE(B.EXP_DT,TRUNC(B.EXP_DT),B.EXP_DT-1,B.EXP_DT) ELSE TO_DATE(A.VED_DT,'YYYYMMDD') END,'YYYY-MM-DD') END_DT," ).append("\n"); 
		query.append("		TRUNC(B.INV_AMT*(CASE WHEN A.VED_DT < TO_CHAR(B.EXP_DT,'YYYYMMDD') THEN TO_DATE(A.VED_DT, 'YYYYMMDD') ELSE B.EXP_DT-1 END -" ).append("\n"); 
		query.append("				   CASE WHEN A.VST_DT > TO_CHAR(B.EFF_DT,'YYYYMMDD') THEN TO_DATE(A.VST_DT, 'YYYYMMDD') ELSE B.EFF_DT END +1)/B.INV_USD_DYS,2) CSR_AMT," ).append("\n"); 
		query.append("		TRUNC(B.INV_AMT*(CASE WHEN A.VED_DT < TO_CHAR(B.EXP_DT,'YYYYMMDD') THEN TO_DATE(A.VED_DT, 'YYYYMMDD') ELSE B.EXP_DT-1 END -" ).append("\n"); 
		query.append("				   CASE WHEN A.VST_DT > TO_CHAR(B.EFF_DT,'YYYYMMDD') THEN TO_DATE(A.VST_DT, 'YYYYMMDD') ELSE B.EFF_DT END +1)/B.INV_USD_DYS" ).append("\n"); 
		query.append("	   /DECODE(@[csr_curr_cd], 'USD', 1, (SELECT NVL(EX1.USD_LOCL_XCH_RT,1) " ).append("\n"); 
		query.append("										  FROM 	 GL_MON_XCH_RT EX1" ).append("\n"); 
		query.append("										  WHERE  EX1.CURR_CD = @[csr_curr_cd] " ).append("\n"); 
		query.append("										  AND    EX1.ACCT_XCH_RT_YRMON = SUBSTR(REPLACE(@[eff_dt],'-',''),1,6) " ).append("\n"); 
		query.append("										  AND    EX1.ACCT_XCH_RT_LVL = '1')),2) TRNS_AMT" ).append("\n"); 
		query.append("FROM	FMS_VVD A, FMS_INVOICE F, FMS_INV_DTL B" ).append("\n"); 
		query.append("WHERE 	A.VSL_CD IN (SELECT @[vsl_cd] FROM DUAL " ).append("\n"); 
		query.append("					 UNION ALL " ).append("\n"); 
		query.append("					 SELECT VSL_CD FROM FMS_ID_VSL " ).append("\n"); 
		query.append("					  WHERE FLET_CTRT_NO = @[flet_ctrt_no] " ).append("\n"); 
		query.append("						AND USE_FLG = 'Y')" ).append("\n"); 
		query.append("AND 	F.FLET_CTRT_NO = B.FLET_CTRT_NO" ).append("\n"); 
		query.append("AND 	F.FLET_ISS_TP_CD = B.FLET_ISS_TP_CD" ).append("\n"); 
		query.append("AND 	F.INV_SEQ = B.INV_SEQ" ).append("\n"); 
		query.append("AND 	B.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("AND 	B.FLET_ISS_TP_CD = 'PRE'" ).append("\n"); 
		query.append("AND 	B.SLP_TP_CD   = @[org_slp_tp_cd]" ).append("\n"); 
		query.append("AND 	B.SLP_FUNC_CD= @[org_slp_func_cd]" ).append("\n"); 
		query.append("AND 	B.SLP_OFC_CD = @[org_slp_ofc_cd]" ).append("\n"); 
		query.append("AND 	B.SLP_ISS_DT = @[org_slp_iss_dt]" ).append("\n"); 
		query.append("AND 	B.SLP_SER_NO = @[org_slp_ser_no]" ).append("\n"); 
		query.append("AND 	B.ACCT_CD NOT IN ('510911','511351')" ).append("\n"); 
		query.append("AND 	A.VST_DT <= @[vvd_exp_dt]" ).append("\n"); 
		query.append("AND 	A.VED_DT >= @[vvd_eff_dt]" ).append("\n"); 
		query.append("AND		A.VST_DT < TO_CHAR(B.EXP_DT, 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("AND		A.VED_DT >= TO_CHAR(B.EFF_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("AND TRUNC(B.INV_AMT*(CASE WHEN A.VED_DT < TO_CHAR(B.EXP_DT,'YYYYMMDD') THEN TO_DATE(A.VED_DT, 'YYYYMMDD') ELSE B.EXP_DT-1 END -" ).append("\n"); 
		query.append("CASE WHEN A.VST_DT > TO_CHAR(B.EFF_DT,'YYYYMMDD') THEN TO_DATE(A.VST_DT, 'YYYYMMDD') ELSE B.EFF_DT END +1)/B.INV_USD_DYS,2)  > 0" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  ACCT_CD, @[vndr_seq] VNDR_SEQ, @[ctr_cd] CTR_CD," ).append("\n"); 
		query.append("		@[slp_loc_cd] SLP_LOC_CD, REPLACE(@[eff_dt],'-','') EFF_DT," ).append("\n"); 
		query.append("		(SELECT ACCT_ITM_NM FROM FMS_ACCT_ITM WHERE ACCT_CD = A.ACCT_CD AND ACCT_ITM_SEQ = A.ACCT_ITM_SEQ) CSR_DESC, " ).append("\n"); 
		query.append("		PPAY_HIR_NO, INV_SEQ," ).append("\n"); 
		query.append("		VSL_CD||SKD_VOY_NO||SKD_DIR_CD||REV_DIR_CD VVD_CD," ).append("\n"); 
		query.append("		VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD," ).append("\n"); 
		query.append("		'MVM-'||@[vsl_cd]||'-L-'||SUBSTR(REPLACE(@[eff_dt],'-',''),1,6)||'-'||" ).append("\n"); 
		query.append("		LPAD((SELECT NVL(TO_NUMBER(MAX(SUBSTR(LSG_GR_NO,19))),0)" ).append("\n"); 
		query.append("		FROM 	 FMS_CSUL_SLP" ).append("\n"); 
		query.append("		WHERE  LSG_GR_NO LIKE 'MVM-'||@[vsl_cd]||'-L-'||SUBSTR(REPLACE(@[eff_dt],'-',''),1,6)||'%')+ROWNUM,4,'0') SLP_KEY_NO," ).append("\n"); 
		query.append("		'' ORG_SLP_TP_CD," ).append("\n"); 
		query.append("		'' ORG_SLP_FUNC_CD," ).append("\n"); 
		query.append("		'' ORG_SLP_OFC_CD," ).append("\n"); 
		query.append("		'' ORG_SLP_ISS_DT," ).append("\n"); 
		query.append("		'' ORG_SLP_SER_NO," ).append("\n"); 
		query.append("		'' ORG_SLP_SEQ_NO," ).append("\n"); 
		query.append("		TO_CHAR(CASE WHEN A.VST_DT <= TO_CHAR(A.EFF_DT,'YYYYMMDD') THEN A.EFF_DT ELSE TO_DATE(A.VST_DT,'YYYYMMDD') END,'YYYY-MM-DD') START_DT," ).append("\n"); 
		query.append("		TO_CHAR(CASE WHEN A.VED_DT >= TO_CHAR(A.EXP_DT,'YYYYMMDD') THEN DECODE(A.EXP_DT,TRUNC(A.EXP_DT),A.EXP_DT-1,A.EXP_DT) ELSE TO_DATE(A.VED_DT,'YYYYMMDD') END,'YYYY-MM-DD') END_DT," ).append("\n"); 
		query.append("		TRUNC(INV_AMT*(CASE WHEN VED_DT < TO_CHAR(EXP_DT,'YYYYMMDD') THEN TO_DATE(VED_DT, 'YYYYMMDD') ELSE EXP_DT-1 END -" ).append("\n"); 
		query.append("				 CASE WHEN VST_DT > TO_CHAR(EFF_DT,'YYYYMMDD') THEN TO_DATE(VST_DT, 'YYYYMMDD') ELSE EFF_DT END +1)/INV_USD_DYS,2) CSR_AMT," ).append("\n"); 
		query.append("		TRUNC(INV_AMT*(CASE WHEN VED_DT < TO_CHAR(EXP_DT,'YYYYMMDD') THEN TO_DATE(VED_DT, 'YYYYMMDD') ELSE EXP_DT-1 END -" ).append("\n"); 
		query.append("				 CASE WHEN VST_DT > TO_CHAR(EFF_DT,'YYYYMMDD') THEN TO_DATE(VST_DT, 'YYYYMMDD') ELSE EFF_DT END +1)/INV_USD_DYS" ).append("\n"); 
		query.append("	   /DECODE(@[csr_curr_cd], 'USD', 1, (SELECT NVL(EX1.USD_LOCL_XCH_RT,1) " ).append("\n"); 
		query.append("										  FROM 	 GL_MON_XCH_RT EX1" ).append("\n"); 
		query.append("										  WHERE  EX1.CURR_CD = @[csr_curr_cd] " ).append("\n"); 
		query.append("										  AND    EX1.ACCT_XCH_RT_YRMON = SUBSTR(REPLACE(@[eff_dt],'-',''),1,6) " ).append("\n"); 
		query.append("										  AND    EX1.ACCT_XCH_RT_LVL = '1')),2) TRNS_AMT" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("SELECT 	B.ACCT_CD, B.ACCT_ITM_SEQ," ).append("\n"); 
		query.append("		B.EFF_DT, B.EXP_DT, B.INV_USD_DYS, F.PPAY_HIR_NO, F.INV_SEQ," ).append("\n"); 
		query.append("		A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD, A.VST_DT, A.VED_DT," ).append("\n"); 
		query.append("		B.INV_AMT" ).append("\n"); 
		query.append("		FROM 	FMS_VVD A, FMS_INVOICE F, FMS_INV_DTL B" ).append("\n"); 
		query.append("		WHERE 	A.VSL_CD IN (SELECT @[vsl_cd] FROM DUAL " ).append("\n"); 
		query.append("							 UNION ALL " ).append("\n"); 
		query.append("							 SELECT VSL_CD FROM FMS_ID_VSL " ).append("\n"); 
		query.append("							  WHERE FLET_CTRT_NO = @[flet_ctrt_no] " ).append("\n"); 
		query.append("								AND USE_FLG = 'Y')" ).append("\n"); 
		query.append("		AND 	F.FLET_CTRT_NO = B.FLET_CTRT_NO" ).append("\n"); 
		query.append("		AND 	F.FLET_ISS_TP_CD = B.FLET_ISS_TP_CD" ).append("\n"); 
		query.append("		AND 	F.INV_SEQ = B.INV_SEQ" ).append("\n"); 
		query.append("		AND 	B.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("		AND 	B.FLET_ISS_TP_CD = 'PRE'" ).append("\n"); 
		query.append("		AND 	B.SLP_TP_CD   = @[org_slp_tp_cd]" ).append("\n"); 
		query.append("		AND 	B.SLP_FUNC_CD= @[org_slp_func_cd]" ).append("\n"); 
		query.append("		AND 	B.SLP_OFC_CD = @[org_slp_ofc_cd]" ).append("\n"); 
		query.append("		AND 	B.SLP_ISS_DT = @[org_slp_iss_dt]" ).append("\n"); 
		query.append("		AND 	B.SLP_SER_NO = @[org_slp_ser_no]" ).append("\n"); 
		query.append("		AND 	B.ACCT_CD = '511351'" ).append("\n"); 
		query.append("		AND 	A.VST_DT <= @[vvd_exp_dt]" ).append("\n"); 
		query.append("		AND 	A.VED_DT >= @[vvd_eff_dt]" ).append("\n"); 
		query.append("		AND		A.VST_DT < TO_CHAR(B.EXP_DT, 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("		AND		A.VED_DT >= TO_CHAR(B.EFF_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("		ORDER BY A.VST_DT) A" ).append("\n"); 
		query.append("		WHERE TRUNC(INV_AMT*(CASE WHEN VED_DT < TO_CHAR(EXP_DT,'YYYYMMDD') THEN TO_DATE(VED_DT, 'YYYYMMDD') ELSE EXP_DT-1 END -" ).append("\n"); 
		query.append("		CASE WHEN VST_DT > TO_CHAR(EFF_DT,'YYYYMMDD') THEN TO_DATE(VST_DT, 'YYYYMMDD') ELSE EFF_DT END +1)/INV_USD_DYS,2) > 0" ).append("\n"); 
		query.append("ORDER BY ACCT_CD, START_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND ACCT_CD NOT IN '111431'" ).append("\n"); 
		query.append("GROUP BY ACCT_CD" ).append("\n"); 

	}
}