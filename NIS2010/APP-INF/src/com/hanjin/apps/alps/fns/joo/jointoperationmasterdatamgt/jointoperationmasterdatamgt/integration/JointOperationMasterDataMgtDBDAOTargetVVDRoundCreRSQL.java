/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOTargetVVDRoundCreRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationMasterDataMgtDBDAOTargetVVDRoundCreRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Target VVD Creation용 Round
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOTargetVVDRoundCreRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOTargetVVDRoundCreRSQL").append("\n"); 
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
		query.append("WITH BAS AS (" ).append("\n"); 
		query.append("   SELECT /*+ ORDERED */" ).append("\n"); 
		query.append("         J.JO_CRR_CD, J.TRD_CD, J.RLANE_CD,J.JO_STL_ITM_CD, J.STL_TGT_VVD_BSS_CD, J.JO_STL_TGT_TP_CD, J.JO_PRD_FR, J.JO_PRD_TO, BPORT1, BPORT2, BPORT3, PPORT1, PPORT2, PPORT3," ).append("\n"); 
		query.append("         J.UC_BSS_PORT_CD, V.VSL_CD, V.SKD_VOY_NO, V.SKD_DIR_CD, VPS_PORT_CD, VPS_ETA_DT, VPS_ETB_DT, VPS_ETD_DT, J.MNTH_COND, J.PORT_COND, J.PORT_TYPE, J.OPTP_COND," ).append("\n"); 
		query.append("         J.BPORT, J.SEQ, ROW_NUMBER() OVER (PARTITION BY V.VSL_CD, V.SKD_VOY_NO, V.SKD_DIR_CD, J.JO_STL_ITM_CD ORDER BY J.SEQ) AS RN" ).append("\n"); 
		query.append("   FROM  (" ).append("\n"); 
		query.append("          SELECT 1 AS SEQ, A.N1ST_STL_BZC_PORT_CD AS BPORT," ).append("\n"); 
		query.append("                 A.JO_CRR_CD, A.TRD_CD, A.RLANE_CD, A.SKD_DIR_CD, A.JO_STL_ITM_CD, A.STL_TGT_VVD_BSS_CD, A.JO_STL_TGT_TP_CD, A.UC_BSS_PORT_CD," ).append("\n"); 
		query.append("                 A.N1ST_STL_BZC_PORT_CD  AS BPORT1, A.N2ND_STL_BZC_PORT_CD  AS BPORT2, A.N3RD_STL_BZC_PORT_CD  AS BPORT3," ).append("\n"); 
		query.append("                 A.N1ST_STL_PAIR_PORT_CD AS PPORT1, A.N2ND_STL_PAIR_PORT_CD AS PPORT2, A.N3RD_STL_PAIR_PORT_CD AS PPORT3," ).append("\n"); 
		query.append("                 A.AGMT_MON_COND_CD AS MNTH_COND , A.AGMT_PORT_COND_CD AS PORT_COND," ).append("\n"); 
		query.append("                 A.AGMT_PORT_TP_COND_CD AS PORT_TYPE   , A.AGMT_OP_TP_COND_CD AS OPTP_COND," ).append("\n"); 
		query.append("                 CASE WHEN A.AGMT_MON_COND_CD = 'B' THEN ADD_MONTHS(TO_DATE(@[acct_yrmon],'YYYYMM'), -1)" ).append("\n"); 
		query.append("                      WHEN A.AGMT_MON_COND_CD = 'N' THEN ADD_MONTHS(TO_DATE(@[acct_yrmon],'YYYYMM'), +1)" ).append("\n"); 
		query.append("                      WHEN A.AGMT_MON_COND_CD = 'T' THEN ADD_MONTHS(TO_DATE(@[acct_yrmon],'YYYYMM'), -2)" ).append("\n"); 
		query.append("                      WHEN A.AGMT_MON_COND_CD = 'C' THEN TO_DATE(@[acct_yrmon],'YYYYMM')" ).append("\n"); 
		query.append("                 END JO_PRD_FR," ).append("\n"); 
		query.append("                 CASE WHEN A.AGMT_MON_COND_CD = 'B' THEN LAST_DAY(ADD_MONTHS(TO_DATE(@[acct_yrmon],'YYYYMM'), -1))+0.99999" ).append("\n"); 
		query.append("                      WHEN A.AGMT_MON_COND_CD = 'N' THEN LAST_DAY(ADD_MONTHS(TO_DATE(@[acct_yrmon],'YYYYMM'), +1))+0.99999" ).append("\n"); 
		query.append("                      WHEN A.AGMT_MON_COND_CD = 'T' THEN LAST_DAY(ADD_MONTHS(TO_DATE(@[acct_yrmon],'YYYYMM'), -2))+0.99999" ).append("\n"); 
		query.append("                      WHEN A.AGMT_MON_COND_CD = 'C' THEN LAST_DAY(TO_DATE(@[acct_yrmon],'YYYYMM'))+0.99999" ).append("\n"); 
		query.append("                 END JO_PRD_TO" ).append("\n"); 
		query.append("          FROM   JOO_STL_BSS_PORT A" ).append("\n"); 
		query.append("          WHERE  A.JO_CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("          AND    A.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("          UNION ALL" ).append("\n"); 
		query.append("          SELECT 2 AS SEQ, A.N2ND_STL_BZC_PORT_CD AS BPORT," ).append("\n"); 
		query.append("                 A.JO_CRR_CD, A.TRD_CD, A.RLANE_CD, A.SKD_DIR_CD, A.JO_STL_ITM_CD, A.STL_TGT_VVD_BSS_CD, A.JO_STL_TGT_TP_CD, A.UC_BSS_PORT_CD," ).append("\n"); 
		query.append("                 A.N1ST_STL_BZC_PORT_CD  AS BPORT1, A.N2ND_STL_BZC_PORT_CD  AS BPORT2, A.N3RD_STL_BZC_PORT_CD  AS BPORT3," ).append("\n"); 
		query.append("                 A.N1ST_STL_PAIR_PORT_CD AS PPORT1, A.N2ND_STL_PAIR_PORT_CD AS PPORT2, A.N3RD_STL_PAIR_PORT_CD AS PPORT3," ).append("\n"); 
		query.append("                 A.AGMT_MON_COND_CD AS MNTH_COND , A.AGMT_PORT_COND_CD AS PORT_COND," ).append("\n"); 
		query.append("                 A.AGMT_PORT_TP_COND_CD AS PORT_TYPE   , A.AGMT_OP_TP_COND_CD AS OPTP_COND," ).append("\n"); 
		query.append("                 CASE WHEN A.AGMT_MON_COND_CD = 'B' THEN ADD_MONTHS(TO_DATE(@[acct_yrmon],'YYYYMM'), -1)" ).append("\n"); 
		query.append("                      WHEN A.AGMT_MON_COND_CD = 'N' THEN ADD_MONTHS(TO_DATE(@[acct_yrmon],'YYYYMM'), +1)" ).append("\n"); 
		query.append("                      WHEN A.AGMT_MON_COND_CD = 'T' THEN ADD_MONTHS(TO_DATE(@[acct_yrmon],'YYYYMM'), -2)" ).append("\n"); 
		query.append("                      WHEN A.AGMT_MON_COND_CD = 'C' THEN TO_DATE(@[acct_yrmon],'YYYYMM')" ).append("\n"); 
		query.append("                 END JO_PRD_FR," ).append("\n"); 
		query.append("                 CASE WHEN A.AGMT_MON_COND_CD = 'B' THEN LAST_DAY(ADD_MONTHS(TO_DATE(@[acct_yrmon],'YYYYMM'), -1))+0.99999" ).append("\n"); 
		query.append("                      WHEN A.AGMT_MON_COND_CD = 'N' THEN LAST_DAY(ADD_MONTHS(TO_DATE(@[acct_yrmon],'YYYYMM'), +1))+0.99999" ).append("\n"); 
		query.append("                      WHEN A.AGMT_MON_COND_CD = 'T' THEN LAST_DAY(ADD_MONTHS(TO_DATE(@[acct_yrmon],'YYYYMM'), -2))+0.99999" ).append("\n"); 
		query.append("                      WHEN A.AGMT_MON_COND_CD = 'C' THEN LAST_DAY(TO_DATE(@[acct_yrmon],'YYYYMM'))+0.99999" ).append("\n"); 
		query.append("                 END JO_PRD_TO" ).append("\n"); 
		query.append("          FROM   JOO_STL_BSS_PORT A" ).append("\n"); 
		query.append("          WHERE  A.JO_CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("          AND    A.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("          UNION ALL" ).append("\n"); 
		query.append("          SELECT 3 AS SEQ, A.N3RD_STL_BZC_PORT_CD AS BPORT," ).append("\n"); 
		query.append("                 A.JO_CRR_CD, A.TRD_CD, A.RLANE_CD, A.SKD_DIR_CD, A.JO_STL_ITM_CD, A.STL_TGT_VVD_BSS_CD, A.JO_STL_TGT_TP_CD, A.UC_BSS_PORT_CD," ).append("\n"); 
		query.append("                 A.N1ST_STL_BZC_PORT_CD  AS BPORT1, A.N2ND_STL_BZC_PORT_CD  AS BPORT2, A.N3RD_STL_BZC_PORT_CD  AS BPORT3," ).append("\n"); 
		query.append("                 A.N1ST_STL_PAIR_PORT_CD AS PPORT1, A.N2ND_STL_PAIR_PORT_CD AS PPORT2, A.N3RD_STL_PAIR_PORT_CD AS PPORT3," ).append("\n"); 
		query.append("                 A.AGMT_MON_COND_CD AS MNTH_COND , A.AGMT_PORT_COND_CD AS PORT_COND," ).append("\n"); 
		query.append("                 A.AGMT_PORT_TP_COND_CD AS PORT_TYPE   , A.AGMT_OP_TP_COND_CD AS OPTP_COND," ).append("\n"); 
		query.append("                 CASE WHEN A.AGMT_MON_COND_CD = 'B' THEN ADD_MONTHS(TO_DATE(@[acct_yrmon],'YYYYMM'), -1)" ).append("\n"); 
		query.append("                      WHEN A.AGMT_MON_COND_CD = 'N' THEN ADD_MONTHS(TO_DATE(@[acct_yrmon],'YYYYMM'), +1)" ).append("\n"); 
		query.append("                      WHEN A.AGMT_MON_COND_CD = 'T' THEN ADD_MONTHS(TO_DATE(@[acct_yrmon],'YYYYMM'), -2)" ).append("\n"); 
		query.append("                      WHEN A.AGMT_MON_COND_CD = 'C' THEN TO_DATE(@[acct_yrmon],'YYYYMM')" ).append("\n"); 
		query.append("                 END JO_PRD_FR," ).append("\n"); 
		query.append("                 CASE WHEN A.AGMT_MON_COND_CD = 'B' THEN LAST_DAY(ADD_MONTHS(TO_DATE(@[acct_yrmon],'YYYYMM'), -1))+0.99999" ).append("\n"); 
		query.append("                      WHEN A.AGMT_MON_COND_CD = 'N' THEN LAST_DAY(ADD_MONTHS(TO_DATE(@[acct_yrmon],'YYYYMM'), +1))+0.99999" ).append("\n"); 
		query.append("                      WHEN A.AGMT_MON_COND_CD = 'T' THEN LAST_DAY(ADD_MONTHS(TO_DATE(@[acct_yrmon],'YYYYMM'), -2))+0.99999" ).append("\n"); 
		query.append("                      WHEN A.AGMT_MON_COND_CD = 'C' THEN LAST_DAY(TO_DATE(@[acct_yrmon],'YYYYMM'))+0.99999" ).append("\n"); 
		query.append("                 END JO_PRD_TO" ).append("\n"); 
		query.append("          FROM   JOO_STL_BSS_PORT A" ).append("\n"); 
		query.append("          WHERE  A.JO_CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("          AND    A.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("          ) J," ).append("\n"); 
		query.append("          VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("   WHERE  SUBSTR(J.RLANE_CD,1,3) = V.SLAN_CD" ).append("\n"); 
		query.append("   AND    J.SKD_DIR_CD           = V.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND    NVL(V.SKD_CNG_STS_CD,'N') <> 'S'" ).append("\n"); 
		query.append("   AND    V.VPS_PORT_CD  = J.BPORT" ).append("\n"); 
		query.append("   AND    V.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("   AND   (CASE WHEN J.OPTP_COND = 'A' THEN V.VPS_ETA_DT" ).append("\n"); 
		query.append("               WHEN J.OPTP_COND = 'B' THEN V.VPS_ETB_DT" ).append("\n"); 
		query.append("               WHEN J.OPTP_COND = 'D' THEN V.VPS_ETD_DT" ).append("\n"); 
		query.append("          END) BETWEEN J.JO_PRD_FR AND J.JO_PRD_TO" ).append("\n"); 
		query.append("   --다른월에 BPORT1,2,3가 포함된 항차는 누락시킨다." ).append("\n"); 
		query.append("   AND    NOT EXISTS (" ).append("\n"); 
		query.append("        SELECT 'X'" ).append("\n"); 
		query.append("        FROM   VSK_VSL_PORT_SKD T3" ).append("\n"); 
		query.append("        WHERE  T3.VSL_CD       = V.VSL_CD" ).append("\n"); 
		query.append("        AND    T3.SKD_VOY_NO   = V.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND    T3.SKD_DIR_CD   = V.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND    T3.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("        AND    NVL(T3.SKD_CNG_STS_CD,'N') <> 'S'" ).append("\n"); 
		query.append("        AND    T3.VPS_PORT_CD  IN (J.BPORT1, J.BPORT2, J.BPORT3)" ).append("\n"); 
		query.append("        AND    T3.VPS_PORT_CD <> V.VPS_PORT_CD" ).append("\n"); 
		query.append("        AND    ((J.PORT_COND = 'F' AND J.OPTP_COND = 'A' AND J.JO_PRD_FR > T3.VPS_ETA_DT)" ).append("\n"); 
		query.append("             OR (J.PORT_COND = 'F' AND J.OPTP_COND = 'B' AND J.JO_PRD_FR > T3.VPS_ETB_DT)" ).append("\n"); 
		query.append("             OR (J.PORT_COND = 'F' AND J.OPTP_COND = 'D' AND J.JO_PRD_FR > T3.VPS_ETD_DT)" ).append("\n"); 
		query.append("             OR (J.PORT_COND = 'L' AND J.OPTP_COND = 'A' AND J.JO_PRD_TO < T3.VPS_ETA_DT)" ).append("\n"); 
		query.append("             OR (J.PORT_COND = 'L' AND J.OPTP_COND = 'B' AND J.JO_PRD_TO < T3.VPS_ETB_DT)" ).append("\n"); 
		query.append("             OR (J.PORT_COND = 'L' AND J.OPTP_COND = 'D' AND J.JO_PRD_TO < T3.VPS_ETD_DT)))" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       'I' AS IBFLAG" ).append("\n"); 
		query.append("      ,O.VSL_CD" ).append("\n"); 
		query.append("      ,O.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,O.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,O.REV_DIR_CD" ).append("\n"); 
		query.append("      ,O.JO_STL_ITM_CD" ).append("\n"); 
		query.append("      ,'0' AS JO_MNL_CRE_FLG" ).append("\n"); 
		query.append("      ,O.STL_BZC_PORT_CD" ).append("\n"); 
		query.append("      ,O.STL_TGT_VVD_BSS_CD" ).append("\n"); 
		query.append("      ,'Y' AS JO_STL_CFM_CD" ).append("\n"); 
		query.append("      ,O.BZC_PORT_ETA_DT" ).append("\n"); 
		query.append("      ,O.BZC_PORT_ETD_DT" ).append("\n"); 
		query.append("      ,O.STL_PAIR_PORT_CD" ).append("\n"); 
		query.append("      ,O.PAIR_PORT_ETA_DT" ).append("\n"); 
		query.append("      ,O.PAIR_PORT_ETD_DT" ).append("\n"); 
		query.append("      ,O.UC_BSS_PORT_CD" ).append("\n"); 
		query.append("      ,O.UC_BSS_PORT_ETD_DT" ).append("\n"); 
		query.append("      ,O.STL_RMK" ).append("\n"); 
		query.append("      ,@[acct_yrmon] AS ACCT_YRMON" ).append("\n"); 
		query.append("      ,0 AS STL_VVD_SEQ" ).append("\n"); 
		query.append("      ,O.TRD_CD" ).append("\n"); 
		query.append("      ,O.JO_CRR_CD" ).append("\n"); 
		query.append("      ,O.RLANE_CD" ).append("\n"); 
		query.append("      ,O.JO_MNU_NM" ).append("\n"); 
		query.append("      ,O.JO_MNU_NM AS JO_MNU_NM1" ).append("\n"); 
		query.append("      ,'N' AS PROC_JB_FLG" ).append("\n"); 
		query.append("      ,@[re_divr_cd] AS RE_DIVR_CD" ).append("\n"); 
		query.append("      ,O.AGMT_MON_COND_CD" ).append("\n"); 
		query.append("      ,O.AGMT_PORT_COND_CD" ).append("\n"); 
		query.append("      ,O.AGMT_PORT_TP_COND_CD" ).append("\n"); 
		query.append("      ,O.AGMT_OP_TP_COND_CD" ).append("\n"); 
		query.append("      ,O.REV_YRMON" ).append("\n"); 
		query.append("      ,'N' AS RVS_FLG" ).append("\n"); 
		query.append("      ,O.PENDING_FLG" ).append("\n"); 
		query.append("FROM  (" ).append("\n"); 
		query.append("      SELECT" ).append("\n"); 
		query.append("             N.VSL_CD, N.SKD_VOY_NO, N.SKD_DIR_CD ,N.REV_DIR_CD ,N.JO_STL_ITM_CD ,N.STL_BZC_PORT_CD ,N.STL_TGT_VVD_BSS_CD ,N.BZC_PORT_ETA_DT, N.BZC_PORT_ETD_DT ," ).append("\n"); 
		query.append("             N.STL_PAIR_PORT_CD ,N.PAIR_PORT_ETA_DT ,N.PAIR_PORT_ETD_DT ,N.UC_BSS_PORT_CD ,N.UC_BSS_PORT_ETD_DT ,N.TRD_CD ,N.JO_CRR_CD, N.RLANE_CD ,N.JO_MNU_NM," ).append("\n"); 
		query.append("             N.AGMT_MON_COND_CD, N.AGMT_PORT_COND_CD, N.AGMT_PORT_TP_COND_CD, N.AGMT_OP_TP_COND_CD, N.REV_YRMON," ).append("\n"); 
		query.append("             ROW_NUMBER() OVER(PARTITION BY N.VSL_CD, N.SKD_VOY_NO, N.SKD_DIR_CD, N.JO_STL_ITM_CD ORDER BY RN) AS RNK, N.STL_RMK, N.PENDING_FLG" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("                   M.VSL_CD ,M.SKD_VOY_NO ,N.VSL_SLAN_DIR_CD AS SKD_DIR_CD ,A.RLANE_DIR_CD AS REV_DIR_CD ,M.JO_STL_ITM_CD, A.REV_YRMON," ).append("\n"); 
		query.append("                   CASE WHEN M.JO_STL_ITM_CD = 'OUS' THEN  DECODE(M.JO_STL_TGT_TP_CD,'R','RDR','T','TDR','') ELSE M.JO_STL_ITM_CD END AS JO_MNU_NM," ).append("\n"); 
		query.append("                   M.STL_TGT_VVD_BSS_CD ,M.STL_BZC_PORT_CD ,M.BZC_PORT_ETA_DT ,M.BZC_PORT_ETD_DT ,M.STL_PAIR_PORT_CD ,M.PAIR_PORT_ETA_DT ,M.PAIR_PORT_ETD_DT," ).append("\n"); 
		query.append("                   M.UC_BSS_PORT_CD ,M.UC_BSS_PORT_ETD_DT ,M.TRD_CD ,M.JO_CRR_CD ,M.RLANE_CD,M.MNTH_COND AGMT_MON_COND_CD, M.PORT_COND AGMT_PORT_COND_CD, M.PORT_TYPE AGMT_PORT_TP_COND_CD, M.OPTP_COND AGMT_OP_TP_COND_CD,2 AS RN, '' AS STL_RMK, M.PENDING_FLG -- 전월 PENDING처리된 것과 중복될 경우 PENDING된 것이 우선하기 위해 2로 처리한다." ).append("\n"); 
		query.append("            FROM   (" ).append("\n"); 
		query.append("                --PAIR PORT 가 NOT NULL 인 경우" ).append("\n"); 
		query.append("                SELECT" ).append("\n"); 
		query.append("                       T0.JO_CRR_CD, T0.TRD_CD, T0.RLANE_CD, T0.JO_STL_ITM_CD, T0.STL_TGT_VVD_BSS_CD, T0.JO_STL_TGT_TP_CD, T0.MNTH_COND, T0.PORT_COND, T0.PORT_TYPE, T0.OPTP_COND," ).append("\n"); 
		query.append("      	      	       --BSS_PORT에 UCB PORT가 NULL이면 BASIC PORT중 첫번째 것을 취하고 NOT NULL 인 경우 해당 PORT것을 가져온다." ).append("\n"); 
		query.append("                       CASE WHEN T0.UC_BSS_PORT_CD IS NULL THEN T0.VPS_PORT_CD " ).append("\n"); 
		query.append("                            ELSE CASE WHEN T2.VSL_CD IS NULL THEN NULL " ).append("\n"); 
		query.append("                                      ELSE CASE WHEN NVL(T2.SKD_CNG_STS_CD,'N') = 'S' THEN NULL" ).append("\n"); 
		query.append("                                                ELSE T2.VPS_PORT_CD" ).append("\n"); 
		query.append("                                            END" ).append("\n"); 
		query.append("                                 END" ).append("\n"); 
		query.append("                       END AS UC_BSS_PORT_CD," ).append("\n"); 
		query.append("                       CASE WHEN T0.UC_BSS_PORT_CD IS NULL THEN TO_CHAR(T0.VPS_ETD_DT,'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("                            ELSE CASE WHEN T2.VSL_CD IS NULL THEN NULL " ).append("\n"); 
		query.append("                                      ELSE CASE WHEN NVL(T2.SKD_CNG_STS_CD,'N') = 'S' THEN NULL" ).append("\n"); 
		query.append("                                                ELSE TO_CHAR(T2.VPS_ETD_DT,'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("                                            END" ).append("\n"); 
		query.append("                                 END" ).append("\n"); 
		query.append("                       END AS UC_BSS_PORT_ETD_DT," ).append("\n"); 
		query.append("                       T0.VSL_CD, T0.SKD_VOY_NO, T0.SKD_DIR_CD," ).append("\n"); 
		query.append("                       T0.VPS_PORT_CD AS STL_BZC_PORT_CD, TO_CHAR(T0.VPS_ETA_DT,'YYYYMMDDHH24MISS') AS BZC_PORT_ETA_DT, TO_CHAR(T0.VPS_ETD_DT,'YYYYMMDDHH24MISS') AS BZC_PORT_ETD_DT," ).append("\n"); 
		query.append("                       T1.VPS_PORT_CD AS STL_PAIR_PORT_CD,TO_CHAR(T1.VPS_ETA_DT,'YYYYMMDDHH24MISS') AS PAIR_PORT_ETA_DT,TO_CHAR(T1.VPS_ETD_DT,'YYYYMMDDHH24MISS') AS PAIR_PORT_ETD_DT," ).append("\n"); 
		query.append("--2009.10.19 ==> Pair Port는 F,L에 상관없이 가장 작은 일자 것을 가져온다. (By 박효숙 차장)" ).append("\n"); 
		query.append("                       CASE WHEN T0.OPTP_COND = 'A'  THEN ROW_NUMBER() OVER (PARTITION BY T0.VSL_CD, T0.SKD_VOY_NO, T0.SKD_DIR_CD, T0.JO_STL_ITM_CD ORDER BY T1.VPS_ETA_DT)" ).append("\n"); 
		query.append("                            WHEN T0.OPTP_COND = 'B'  THEN ROW_NUMBER() OVER (PARTITION BY T0.VSL_CD, T0.SKD_VOY_NO, T0.SKD_DIR_CD, T0.JO_STL_ITM_CD ORDER BY T1.VPS_ETB_DT)" ).append("\n"); 
		query.append("                            WHEN T0.OPTP_COND = 'D'  THEN ROW_NUMBER() OVER (PARTITION BY T0.VSL_CD, T0.SKD_VOY_NO, T0.SKD_DIR_CD, T0.JO_STL_ITM_CD ORDER BY T1.VPS_ETD_DT)" ).append("\n"); 
		query.append("                       END P_RN," ).append("\n"); 
		query.append("                       'N' AS PENDING_FLG" ).append("\n"); 
		query.append("                FROM  ( SELECT A.* FROM BAS A WHERE PPORT1 IS NOT NULL) T0," ).append("\n"); 
		query.append("      		          VSK_VSL_PORT_SKD T1, -- PAIR PORTS" ).append("\n"); 
		query.append("      		          VSK_VSL_PORT_SKD T2  -- UCB PORTS" ).append("\n"); 
		query.append("                WHERE T0.RN         = 1" ).append("\n"); 
		query.append("                AND   T0.VSL_CD     = T1.VSL_CD" ).append("\n"); 
		query.append("                AND   T0.SKD_VOY_NO = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("                --AND   T1.SKD_DIR_CD = T0.SKD_DIR_CD -- ROUND는 LOADING일때 반대방향 조건이 필요없음" ).append("\n"); 
		query.append("                --2009.10.21 하룻만에 진술번복하심 박차장님 --+" ).append("\n"); 
		query.append("                AND   T1.SKD_DIR_CD = DECODE(T0.PORT_TYPE,'D', T0.SKD_DIR_CD, DECODE(T0.SKD_DIR_CD,'E','W','W','E','N','S','S','N')) -- Pair Port의 Direction은 E-W, N-S 쌍으로 찾는다." ).append("\n"); 
		query.append("                AND   NVL(T1.SKD_CNG_STS_CD,'N') <> 'S'" ).append("\n"); 
		query.append("                AND   T1.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("                AND   T1.TURN_PORT_IND_CD NOT IN ('D','V','F')" ).append("\n"); 
		query.append("                AND   T1.VPS_PORT_CD IN (T0.PPORT1, T0.PPORT2, T0.PPORT3) -- PAIR PORT가 null인 경우" ).append("\n"); 
		query.append("                AND   T0.VSL_CD         = T2.VSL_CD     (+)" ).append("\n"); 
		query.append("                AND   T0.SKD_VOY_NO     = T2.SKD_VOY_NO (+) " ).append("\n"); 
		query.append("                AND   T0.SKD_DIR_CD     = T2.SKD_DIR_CD (+) " ).append("\n"); 
		query.append("                AND   T0.UC_BSS_PORT_CD = T2.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                --PAIR PORT 가 NULL 인 경우" ).append("\n"); 
		query.append("                SELECT" ).append("\n"); 
		query.append("                       T0.JO_CRR_CD, T0.TRD_CD, T0.RLANE_CD, T0.JO_STL_ITM_CD, T0.STL_TGT_VVD_BSS_CD, T0.JO_STL_TGT_TP_CD, T0.MNTH_COND, T0.PORT_COND, T0.PORT_TYPE, T0.OPTP_COND," ).append("\n"); 
		query.append("      	      	       --BSS_PORT에 UCB PORT가 NULL이면 BASIC PORT중 첫번째 것을 취하고 NOT NULL 인 경우 해당 PORT것을 가져온다." ).append("\n"); 
		query.append("                       CASE WHEN T0.UC_BSS_PORT_CD IS NULL THEN T0.VPS_PORT_CD " ).append("\n"); 
		query.append("                            ELSE CASE WHEN T2.VSL_CD IS NULL THEN NULL " ).append("\n"); 
		query.append("                                      ELSE CASE WHEN NVL(T2.SKD_CNG_STS_CD,'N') = 'S' THEN NULL" ).append("\n"); 
		query.append("                                                ELSE T2.VPS_PORT_CD" ).append("\n"); 
		query.append("                                            END" ).append("\n"); 
		query.append("                                 END" ).append("\n"); 
		query.append("                       END AS UC_BSS_PORT_CD," ).append("\n"); 
		query.append("                       CASE WHEN T0.UC_BSS_PORT_CD IS NULL THEN TO_CHAR(T0.VPS_ETD_DT,'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("                            ELSE CASE WHEN T2.VSL_CD IS NULL THEN NULL " ).append("\n"); 
		query.append("                                      ELSE CASE WHEN NVL(T2.SKD_CNG_STS_CD,'N') = 'S' THEN NULL" ).append("\n"); 
		query.append("                                                ELSE TO_CHAR(T2.VPS_ETD_DT,'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("                                            END" ).append("\n"); 
		query.append("                                 END" ).append("\n"); 
		query.append("                       END AS UC_BSS_PORT_ETD_DT," ).append("\n"); 
		query.append("                       T0.VSL_CD, T0.SKD_VOY_NO, T0.SKD_DIR_CD," ).append("\n"); 
		query.append("                       T0.VPS_PORT_CD AS STL_BZC_PORT_CD, TO_CHAR(T0.VPS_ETA_DT,'YYYYMMDDHH24MISS') AS BZC_PORT_ETA_DT, TO_CHAR(T0.VPS_ETD_DT,'YYYYMMDDHH24MISS') AS BZC_PORT_ETD_DT," ).append("\n"); 
		query.append("                       NULL AS STL_PAIR_PORT_CD,NULL AS PAIR_PORT_ETA_DT, NULL AS PAIR_PORT_ETD_DT," ).append("\n"); 
		query.append("                       1 AS P_RN," ).append("\n"); 
		query.append("                       'N' AS PENDING_FLG" ).append("\n"); 
		query.append("                FROM  ( SELECT A.* FROM BAS A WHERE PPORT1 IS NULL) T0," ).append("\n"); 
		query.append("      		          VSK_VSL_PORT_SKD T2  -- UCB PORTS" ).append("\n"); 
		query.append("                WHERE T0.RN             = 1" ).append("\n"); 
		query.append("                AND   T0.VSL_CD         = T2.VSL_CD     (+) " ).append("\n"); 
		query.append("                AND   T0.SKD_VOY_NO     = T2.SKD_VOY_NO (+)" ).append("\n"); 
		query.append("                AND   T0.SKD_DIR_CD     = T2.SKD_DIR_CD (+)" ).append("\n"); 
		query.append("                AND   T0.UC_BSS_PORT_CD = T2.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("                 ) M," ).append("\n"); 
		query.append("                  MDM_VSL_SVC_LANE_DIR N," ).append("\n"); 
		query.append("                  AR_MST_REV_VVD A" ).append("\n"); 
		query.append("            WHERE M.P_RN       = 1" ).append("\n"); 
		query.append("			AND   SUBSTR(M.RLANE_CD,1,3) = N.VSL_SLAN_CD" ).append("\n"); 
		query.append("			AND   N.DELT_FLG   = 'N'" ).append("\n"); 
		query.append("            AND   M.VSL_CD     = A.VSL_CD" ).append("\n"); 
		query.append("            AND   M.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND   N.VSL_SLAN_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND   M.RLANE_CD   = A.RLANE_CD" ).append("\n"); 
		query.append("            AND   NVL(A.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("            --전월에 pending된 항차도 추가함" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("                   M.VSL_CD, M.SKD_VOY_NO, M.SKD_DIR_CD, M.REV_DIR_CD, M.JO_STL_ITM_CD, M.ACCT_YRMON AS REV_YRMON, M.JO_MNU_NM, M.STL_TGT_VVD_BSS_CD," ).append("\n"); 
		query.append("                   M.STL_BZC_PORT_CD , TO_CHAR(M.BZC_PORT_ETA_DT,'YYYYMMDDHH24MISS') , TO_CHAR(M.BZC_PORT_ETD_DT,'YYYYMMDDHH24MISS')," ).append("\n"); 
		query.append("                   M.STL_PAIR_PORT_CD, TO_CHAR(M.PAIR_PORT_ETA_DT,'YYYYMMDDHH24MISS'), TO_CHAR(M.PAIR_PORT_ETD_DT,'YYYYMMDDHH24MISS')," ).append("\n"); 
		query.append("                   M.UC_BSS_PORT_CD, TO_CHAR(M.UC_BSS_PORT_ETD_DT,'YYYYMMDDHH24MISS'), M.TRD_CD, M.JO_CRR_CD, M.RLANE_CD," ).append("\n"); 
		query.append("                   M.AGMT_MON_COND_CD, M.AGMT_PORT_COND_CD, M.AGMT_PORT_TP_COND_CD, M.AGMT_OP_TP_COND_CD, 1 AS RN, M.STL_RMK, 'Y' AS PENDING_FLG" ).append("\n"); 
		query.append("            FROM   JOO_STL_VVD M" ).append("\n"); 
		query.append("            WHERE  M.ACCT_YRMON = TO_CHAR(ADD_MONTHS(TO_DATE(@[acct_yrmon],'YYYYMM'),-1),'YYYYMM')" ).append("\n"); 
		query.append("            AND    M.JO_CRR_CD  = @[jo_crr_cd]" ).append("\n"); 
		query.append("            AND    M.RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("            AND    M.RE_DIVR_CD = @[re_divr_cd]" ).append("\n"); 
		query.append("            AND    M.JO_STL_CFM_CD = 'P' --pending" ).append("\n"); 
		query.append("            ) N" ).append("\n"); 
		query.append("       ) O" ).append("\n"); 
		query.append("#if (${proc_jb_flg} == 'Y')" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("       SELECT VSL_CD" ).append("\n"); 
		query.append("       FROM   MDM_VSL_CNTR" ).append("\n"); 
		query.append("       WHERE  CRR_CD = DECODE(@[re_divr_cd],'R','SML',@[jo_crr_cd])" ).append("\n"); 
		query.append("       AND    DELT_FLG = 'N'" ).append("\n"); 
		query.append("       ) V   " ).append("\n"); 
		query.append("WHERE  O.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    O.RNK = 1" ).append("\n"); 
		query.append("AND    NOT EXISTS (" ).append("\n"); 
		query.append("         SELECT 1" ).append("\n"); 
		query.append("         FROM   JOO_STL_VVD X" ).append("\n"); 
		query.append("         WHERE  X.ACCT_YRMON = @[acct_yrmon]" ).append("\n"); 
		query.append("         AND    X.JO_CRR_CD  = @[jo_crr_cd]" ).append("\n"); 
		query.append("         AND    X.RE_DIVR_CD = @[re_divr_cd]" ).append("\n"); 
		query.append("         AND    X.TRD_CD     = @[trd_cd]" ).append("\n"); 
		query.append("         AND    X.RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("         AND    X.VSL_CD     = O.VSL_CD" ).append("\n"); 
		query.append("         AND    X.SKD_VOY_NO = O.SKD_VOY_NO" ).append("\n"); 
		query.append("         AND    X.SKD_DIR_CD = O.SKD_DIR_CD" ).append("\n"); 
		query.append("         AND    X.REV_DIR_CD = O.REV_DIR_CD" ).append("\n"); 
		query.append("         AND    X.JO_STL_ITM_CD = O.JO_STL_ITM_CD" ).append("\n"); 
		query.append("         AND    X.JO_MNU_NM     = O.JO_MNU_NM" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("UNION  ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       'R' AS IBFLAG," ).append("\n"); 
		query.append("       A.VSL_CD," ).append("\n"); 
		query.append("       A.SKD_VOY_NO," ).append("\n"); 
		query.append("       A.SKD_DIR_CD," ).append("\n"); 
		query.append("       A.REV_DIR_CD," ).append("\n"); 
		query.append("       A.JO_STL_ITM_CD," ).append("\n"); 
		query.append("       CASE WHEN A.JO_MNU_NM = A.JO_STL_ITM_CD THEN '0'" ).append("\n"); 
		query.append("            ELSE " ).append("\n"); 
		query.append("                CASE WHEN A.JO_STL_ITM_CD = 'OUS' THEN" ).append("\n"); 
		query.append("                     CASE WHEN A.JO_MNU_NM IN ('RDR','TDR') THEN '0'" ).append("\n"); 
		query.append("                          WHEN A.JO_MNU_NM = 'M/S' THEN '1'" ).append("\n"); 
		query.append("                     END" ).append("\n"); 
		query.append("                     ELSE '1'                      " ).append("\n"); 
		query.append("                END" ).append("\n"); 
		query.append("       END AS JO_MNL_CRE_FLG," ).append("\n"); 
		query.append("       A.STL_BZC_PORT_CD," ).append("\n"); 
		query.append("       A.STL_TGT_VVD_BSS_CD," ).append("\n"); 
		query.append("       A.JO_STL_CFM_CD," ).append("\n"); 
		query.append("       TO_CHAR(A.BZC_PORT_ETA_DT,'YYYYMMDDHH24MISS') AS BZC_PORT_ETA_DT," ).append("\n"); 
		query.append("       TO_CHAR(A.BZC_PORT_ETD_DT,'YYYYMMDDHH24MISS') AS BZC_PORT_ETD_DT," ).append("\n"); 
		query.append("       A.STL_PAIR_PORT_CD," ).append("\n"); 
		query.append("       TO_CHAR(A.PAIR_PORT_ETA_DT,'YYYYMMDDHH24MISS') AS PAIR_PORT_ETA_DT," ).append("\n"); 
		query.append("       TO_CHAR(A.PAIR_PORT_ETD_DT,'YYYYMMDDHH24MISS') AS PAIR_PORT_ETD_DT," ).append("\n"); 
		query.append("       A.UC_BSS_PORT_CD," ).append("\n"); 
		query.append("       TO_CHAR(A.UC_BSS_PORT_ETD_DT,'YYYYMMDDHH24MISS') AS UC_BSS_PORT_ETD_DT," ).append("\n"); 
		query.append("       A.STL_RMK," ).append("\n"); 
		query.append("       A.ACCT_YRMON," ).append("\n"); 
		query.append("       A.STL_VVD_SEQ," ).append("\n"); 
		query.append("       A.TRD_CD," ).append("\n"); 
		query.append("       A.JO_CRR_CD," ).append("\n"); 
		query.append("       A.RLANE_CD," ).append("\n"); 
		query.append("       A.JO_MNU_NM," ).append("\n"); 
		query.append("       NVL((SELECT Y.INTG_CD_VAL_DP_DESC AS JO_MNU_NM" ).append("\n"); 
		query.append("            FROM   JOO_STL_BSS_PORT X," ).append("\n"); 
		query.append("                   COM_INTG_CD_DTL  Y" ).append("\n"); 
		query.append("            WHERE  X.JO_STL_TGT_TP_CD = Y.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("            AND    Y.INTG_CD_ID = 'CD01867'" ).append("\n"); 
		query.append("            AND    X.JO_CRR_CD  = A.JO_CRR_CD" ).append("\n"); 
		query.append("            AND    X.RLANE_CD   = A.RLANE_CD" ).append("\n"); 
		query.append("            AND    X.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND    X.JO_STL_ITM_CD = A.JO_STL_ITM_CD" ).append("\n"); 
		query.append("       ),A.JO_MNU_NM) AS JO_MNU_NM1," ).append("\n"); 
		query.append("       DECODE(A.PROC_JB_FLG,'Y','Y','') AS PROC_JB_FLG," ).append("\n"); 
		query.append("       A.RE_DIVR_CD," ).append("\n"); 
		query.append("       A.AGMT_MON_COND_CD," ).append("\n"); 
		query.append("       A.AGMT_PORT_COND_CD," ).append("\n"); 
		query.append("       A.AGMT_PORT_TP_COND_CD," ).append("\n"); 
		query.append("       A.AGMT_OP_TP_COND_CD," ).append("\n"); 
		query.append("       '' AS REV_YRMON," ).append("\n"); 
		query.append("       --2010.03.29 정상CSR 끊긴 것과 REVERSE 된 것이 1:1이면 JO_STL_CFM_CD를 수정가능하게 한다." ).append("\n"); 
		query.append("       DECODE(A.PROC_JB_FLG,'Y',DECODE(NVL(B.CNT,0),0,'Y','N'),'N') AS RVS_FLG," ).append("\n"); 
		query.append("       'N' PENDING_FLG" ).append("\n"); 
		query.append("FROM   JOO_STL_VVD A," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("       --2010.03.29 REVERSE 된 SETTLEMENT를 우선 삭제한 다음에 PENDING을 수정하기로 함 (박효숙차장)" ).append("\n"); 
		query.append("       SELECT X.ACCT_YRMON, X.STL_VVD_SEQ, SUM(DECODE(NVL(X.CMB_CFM_FLG,'N'),'Y',Y.CNT,1)) AS CNT" ).append("\n"); 
		query.append("       FROM   JOO_SETTLEMENT X," ).append("\n"); 
		query.append("              (" ).append("\n"); 
		query.append("              SELECT A.ACCT_YRMON, A.STL_VVD_SEQ, A.STL_SEQ, SUM(DECODE(C.RVS_CSR_FLG,'Y',-1,1)) CNT" ).append("\n"); 
		query.append("              FROM   JOO_STL_CMB_DTL A," ).append("\n"); 
		query.append("                     JOO_STL_CMB     B," ).append("\n"); 
		query.append("                     JOO_CSR         C" ).append("\n"); 
		query.append("              WHERE  A.ACCT_YRMON = B.ACCT_YRMON" ).append("\n"); 
		query.append("              AND    A.JO_CRR_CD  = B.JO_CRR_CD" ).append("\n"); 
		query.append("              AND    A.STL_CMB_SEQ= B.STL_CMB_SEQ" ).append("\n"); 
		query.append("              AND    A.RE_DIVR_CD = B.RE_DIVR_CD" ).append("\n"); 
		query.append("              AND    B.SLP_TP_CD  = C.SLP_TP_CD  (+)" ).append("\n"); 
		query.append("              AND    B.SLP_FUNC_CD= C.SLP_FUNC_CD(+)" ).append("\n"); 
		query.append("              AND    B.SLP_OFC_CD = C.SLP_OFC_CD (+)" ).append("\n"); 
		query.append("              AND    B.SLP_ISS_DT = C.SLP_ISS_DT (+)" ).append("\n"); 
		query.append("              AND    B.SLP_SER_NO = C.SLP_SER_NO (+)" ).append("\n"); 
		query.append("              GROUP  BY" ).append("\n"); 
		query.append("                     A.ACCT_YRMON, A.STL_VVD_SEQ, A.STL_SEQ" ).append("\n"); 
		query.append("              ) Y" ).append("\n"); 
		query.append("       WHERE  X.ACCT_YRMON  = Y.ACCT_YRMON (+)" ).append("\n"); 
		query.append("       AND    X.STL_VVD_SEQ = Y.STL_VVD_SEQ(+)" ).append("\n"); 
		query.append("       AND    X.STL_SEQ     = Y.STL_SEQ    (+)" ).append("\n"); 
		query.append("       GROUP  BY X.ACCT_YRMON, X.STL_VVD_SEQ" ).append("\n"); 
		query.append("       ) B        " ).append("\n"); 
		query.append("WHERE  A.ACCT_YRMON  = B.ACCT_YRMON (+)" ).append("\n"); 
		query.append("AND    A.STL_VVD_SEQ = B.STL_VVD_SEQ(+)" ).append("\n"); 
		query.append("AND    A.ACCT_YRMON = @[acct_yrmon]" ).append("\n"); 
		query.append("AND    A.JO_CRR_CD  = @[jo_crr_cd]" ).append("\n"); 
		query.append("AND    A.RE_DIVR_CD = @[re_divr_cd]" ).append("\n"); 
		query.append("AND    A.TRD_CD     = @[trd_cd]" ).append("\n"); 
		query.append("AND    A.RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("ORDER  BY 1, SKD_DIR_CD, BZC_PORT_ETA_DT, VSL_CD, SKD_VOY_NO, JO_STL_ITM_CD, JO_MNU_NM" ).append("\n"); 

	}
}