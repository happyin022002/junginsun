/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BudgetPortChargeMgtDBDAOgetIoRatioRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BudgetPortChargeMgtDBDAOgetIoRatioRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Creation & Audit 화면에서 Save Button Click 시 해다 PORT별 VVD 의 IO Ration 정보를 조회한다.
	  * =====================================================================
	  * 2011.03.28 진마리아 [선처리(SRM-201114694)] 사업계획 항비 로직 수정 요청
	  * </pre>
	  */
	public BudgetPortChargeMgtDBDAOgetIoRatioRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("org_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bud_scnr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.integration").append("\n"); 
		query.append("FileName : BudgetPortChargeMgtDBDAOgetIoRatioRSQL").append("\n"); 
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
		query.append("-- IoRatio VO " ).append("\n"); 
		query.append("  SELECT   VSL_CD," ).append("\n"); 
		query.append("           SKD_VOY_NO," ).append("\n"); 
		query.append("           SKD_DIR_CD," ).append("\n"); 
		query.append("           TURN," ).append("\n"); 
		query.append("           SLAN_CD," ).append("\n"); 
		query.append("           VPS_PORT_CD," ).append("\n"); 
		query.append("           RLANE_DIR_CD," ).append("\n"); 
		query.append("           OB_RTO," ).append("\n"); 
		query.append("           IB_RTO," ).append("\n"); 
		query.append("           RLANE_CD," ).append("\n"); 
		query.append("           REV_YRMON" ).append("\n"); 
		query.append("    FROM   (--Budget 의 경우" ).append("\n"); 
		query.append("            SELECT   V.VSL_CD," ).append("\n"); 
		query.append("                     V.SKD_VOY_NO," ).append("\n"); 
		query.append("                     V.SKD_DIR_CD," ).append("\n"); 
		query.append("                     V.TURN_PORT_IND_CD TURN," ).append("\n"); 
		query.append("                     V.SLAN_CD," ).append("\n"); 
		query.append("                     V.VPS_PORT_CD," ).append("\n"); 
		query.append("                     '' RLANE_DIR_CD," ).append("\n"); 
		query.append("                     DECODE (V.TURN_PORT_FLG, 'Y', 50,NVL(OB_RTO,100) ) OB_RTO," ).append("\n"); 
		query.append("                     DECODE (V.TURN_PORT_FLG, 'Y', 0, NVL(IB_RTO,0)) IB_RTO," ).append("\n"); 
		query.append("                     L.RLANE_CD," ).append("\n"); 
		query.append("                     BUD_YRMON AS REV_YRMON" ).append("\n"); 
		query.append("              FROM   VSK_BUD_VSL_PORT_SKD V, PSO_BUD_TGT_VVD L, PSO_PORT_EXPN_DIV D" ).append("\n"); 
		query.append("             WHERE       1 = 1" ).append("\n"); 
		query.append("                     AND V.VSL_CD = L.VSL_CD" ).append("\n"); 
		query.append("                     AND V.SKD_VOY_NO = L.SKD_VOY_NO" ).append("\n"); 
		query.append("                     AND V.SKD_DIR_CD = L.SKD_DIR_CD" ).append("\n"); 
		query.append("                     AND V.SLAN_CD = SUBSTR (L.RLANE_CD, 1, 3)" ).append("\n"); 
		query.append("                     AND V.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("         			 AND V.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("			         AND V.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                     AND V.VPS_PORT_CD = SUBSTR (@[yd_cd], 1, 5)" ).append("\n"); 
		query.append("					 --AND V.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("                     AND NVL (SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("                     AND D.SLAN_CD(+) = V.SLAN_CD" ).append("\n"); 
		query.append("                     AND D.SKD_DIR_CD(+) = V.SKD_DIR_CD" ).append("\n"); 
		query.append("                     AND D.LOC_CD(+) = V.VPS_PORT_CD" ).append("\n"); 
		query.append("                     --AND D.RLANE_CD(+)  =  PSO_GET_REV_LANE_FNC(V.VSL_CD,V.SKD_VOY_NO,V.SKD_DIR_CD,V.VPS_PORT_CD)" ).append("\n"); 
		query.append("                     AND D.RLANE_CD(+)  =  @[rlane_cd]" ).append("\n"); 
		query.append("                     AND V.TURN_PORT_IND_CD IN ('N', 'Y')" ).append("\n"); 
		query.append("                     AND L.bud_scnr_no = @[bud_scnr_no]" ).append("\n"); 
		query.append("                     AND L.BUD_YRMON >= REPLACE (@[rev_yrmon], '-', '')" ).append("\n"); 
		query.append("					 AND L.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("                     AND 'B' = @[org_flg]" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT   V.VSL_CD," ).append("\n"); 
		query.append("                     V.SKD_VOY_NO," ).append("\n"); 
		query.append("                     V.SKD_DIR_CD," ).append("\n"); 
		query.append("                     V.TURN_PORT_IND_CD TURN," ).append("\n"); 
		query.append("                     V.SLAN_CD," ).append("\n"); 
		query.append("                     V.VPS_PORT_CD," ).append("\n"); 
		query.append("                     '' RLANE_DIR_CD," ).append("\n"); 
		query.append("                     0 OB_RTO," ).append("\n"); 
		query.append("                     50 IB_RTO," ).append("\n"); 
		query.append("                     L.RLANE_CD," ).append("\n"); 
		query.append("                     BUD_YRMON AS REV_YRMON" ).append("\n"); 
		query.append("              FROM   VSK_BUD_VSL_PORT_SKD V, PSO_BUD_TGT_VVD L" ).append("\n"); 
		query.append("             WHERE   V.VSL_CD = L.VSL_CD" ).append("\n"); 
		query.append("                     AND V.SKD_VOY_NO = L.SKD_VOY_NO" ).append("\n"); 
		query.append("                     AND V.SKD_DIR_CD = L.SKD_DIR_CD" ).append("\n"); 
		query.append("                     AND V.SLAN_CD = SUBSTR (L.RLANE_CD, 1, 3)" ).append("\n"); 
		query.append("                     AND V.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("         			 AND V.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("			         AND V.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                     AND V.VPS_PORT_CD = SUBSTR (@[yd_cd], 1, 5)" ).append("\n"); 
		query.append("					-- AND V.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("                     AND NVL (SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("                     AND L.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("--                     AND (L.RLANE_CD =" ).append("\n"); 
		query.append("--                             NVL (" ).append("\n"); 
		query.append("--                                (SELECT   RLANE_CD" ).append("\n"); 
		query.append("--                                   FROM   VSK_VSL_PORT_SKD V," ).append("\n"); 
		query.append("--                                          AR_FINC_DIR_CONV B," ).append("\n"); 
		query.append("--                                          MDM_LOCATION L" ).append("\n"); 
		query.append("--                                  WHERE       V.VSL_CD = [vsl_cd]" ).append("\n"); 
		query.append("--                                          AND V.SKD_VOY_NO = [skd_voy_no]" ).append("\n"); 
		query.append("--                                          AND V.SKD_DIR_CD = [skd_dir_cd]" ).append("\n"); 
		query.append("--                                          AND V.VPS_PORT_CD =" ).append("\n"); 
		query.append("--                                                SUBSTR ([yd_cd], 1, 5)" ).append("\n"); 
		query.append("--                                          AND V.VPS_PORT_CD = L.LOC_CD" ).append("\n"); 
		query.append("--                                          AND V.SLAN_CD = B.SLAN_CD" ).append("\n"); 
		query.append("--                                          AND V.SKD_DIR_CD = B.SLAN_DIR_CD" ).append("\n"); 
		query.append("--                                          AND L.SCONTI_CD = B.SCONTI_CD" ).append("\n"); 
		query.append("--                                          AND ROWNUM <= 1)," ).append("\n"); 
		query.append("--                                L.RLANE_CD))" ).append("\n"); 
		query.append("                     AND EXISTS" ).append("\n"); 
		query.append("                           (SELECT   1" ).append("\n"); 
		query.append("                              FROM   pso_bud_tgt_vvd x" ).append("\n"); 
		query.append("                             WHERE       x.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("                                     AND x.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                                     AND x.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("                                     AND x.bud_scnr_no = @[bud_scnr_no]" ).append("\n"); 
		query.append("                                     AND x.BUD_YRMON >=" ).append("\n"); 
		query.append("                                           REPLACE (@[rev_yrmon], '-', ''))" ).append("\n"); 
		query.append("                     AND V.TURN_PORT_IND_CD IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("                     AND L.bud_scnr_no = @[bud_scnr_no]" ).append("\n"); 
		query.append("                     AND 'B' = @[org_flg]" ).append("\n"); 
		query.append("union all              " ).append("\n"); 
		query.append("--Monthly Estimated 의 경우" ).append("\n"); 
		query.append("SELECT   DISTINCT V.VSL_CD," ).append("\n"); 
		query.append("                  V.SKD_VOY_NO," ).append("\n"); 
		query.append("                  V.SKD_DIR_CD," ).append("\n"); 
		query.append("                  V.TURN TURN," ).append("\n"); 
		query.append("                  V.SLAN_CD," ).append("\n"); 
		query.append("                  V.VPS_PORT_CD," ).append("\n"); 
		query.append("                  V.REV_DIR_CD RLANE_DIR_CD," ).append("\n"); 
		query.append("                  DECODE (V.TURN, 'Y', 50,NVL(OB_RTO,100)  ) OB_RTO," ).append("\n"); 
		query.append("                  DECODE (V.TURN, 'Y', 0,NVL(IB_RTO,0)  ) IB_RTO," ).append("\n"); 
		query.append("                  V.RLANE_CD," ).append("\n"); 
		query.append("                  V.REV_YRMON AS REV_YRMON" ).append("\n"); 
		query.append("FROM  PSO_PORT_EXPN_DIV D," ).append("\n"); 
		query.append("      (SELECT DISTINCT A.VSL_CD," ).append("\n"); 
		query.append("                  A.SKD_VOY_NO," ).append("\n"); 
		query.append("                  A.SKD_DIR_CD," ).append("\n"); 
		query.append("                  B.REV_DIR_CD," ).append("\n"); 
		query.append("                  A.TURN_PORT_FLG TURN," ).append("\n"); 
		query.append("                  A.SLAN_CD," ).append("\n"); 
		query.append("                  A.VPS_PORT_CD," ).append("\n"); 
		query.append("                  B.RLANE_CD," ).append("\n"); 
		query.append("                  B.REV_YRMON" ).append("\n"); 
		query.append("        FROM VSK_VSL_PORT_SKD A, GL_ESTM_REV_VVD B" ).append("\n"); 
		query.append("        WHERE A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("        AND   A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND   A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("         AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("         AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("         AND A.VPS_PORT_CD = SUBSTR (@[yd_cd], 1, 5)  " ).append("\n"); 
		query.append("         AND NVL (A.SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("#if(${org_flg} == 'E')" ).append("\n"); 
		query.append("		 -- OnLine의 경우      " ).append("\n"); 
		query.append("		 AND B.REV_YRMON =  REPLACE (@[rev_yrmon], '-', '')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${org_flg} == 'M')    " ).append("\n"); 
		query.append("         AND B.EXE_YRMON =  REPLACE (@[rev_yrmon], '-', '')" ).append("\n"); 
		query.append("		 AND B.REV_YRMON >= REPLACE (@[rev_yrmon], '-', '')" ).append("\n"); 
		query.append("#end		 " ).append("\n"); 
		query.append("         AND A.TURN_PORT_IND_CD IN ('N', 'Y')" ).append("\n"); 
		query.append("		 -- Pendulum 의 경우면서 TURN = Y 인 경우 Outbound 쪽만 계산함" ).append("\n"); 
		query.append("		 AND B.RLANE_CD = DECODE(A.TURN_PORT_FLG,'Y',PSO_GET_REV_LANE_FNC(A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD,A.VPS_PORT_CD ),B.RLANE_CD)" ).append("\n"); 
		query.append("         AND A.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("       ) V    " ).append("\n"); 
		query.append("WHERE    1 = 1  " ).append("\n"); 
		query.append("         AND V.SLAN_CD = D.SLAN_CD(+)" ).append("\n"); 
		query.append("         AND V.SKD_DIR_CD = D.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("         AND V.VPS_PORT_CD = D.LOC_CD(+)" ).append("\n"); 
		query.append("         AND V.RLANE_CD = D.RLANE_CD(+)" ).append("\n"); 
		query.append("         AND ( 'E' = @[org_flg] or 'M' = @[org_flg] )  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT   DISTINCT V.VSL_CD," ).append("\n"); 
		query.append("                  V.SKD_VOY_NO," ).append("\n"); 
		query.append("                  V.SKD_DIR_CD," ).append("\n"); 
		query.append("                  V.TURN_PORT_IND_CD TURN," ).append("\n"); 
		query.append("                  V.SLAN_CD," ).append("\n"); 
		query.append("                  V.VPS_PORT_CD," ).append("\n"); 
		query.append("                  REV_DIR_CD AS RLANE_DIR_CD," ).append("\n"); 
		query.append("                  0 OB_RTO," ).append("\n"); 
		query.append("                  50 IB_RTO," ).append("\n"); 
		query.append("                  L.RLANE_CD," ).append("\n"); 
		query.append("                  REV_YRMON AS REV_YRMON" ).append("\n"); 
		query.append("  FROM   VSK_VSL_PORT_SKD V, GL_ESTM_REV_VVD L" ).append("\n"); 
		query.append(" WHERE       V.VSL_CD = L.VSL_CD" ).append("\n"); 
		query.append("         AND V.SKD_VOY_NO = L.SKD_VOY_NO" ).append("\n"); 
		query.append("         AND V.SKD_DIR_CD = L.SKD_DIR_CD" ).append("\n"); 
		query.append("         AND V.SLAN_CD = SUBSTR (L.RLANE_CD, 1, 3)" ).append("\n"); 
		query.append("         AND V.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("         AND V.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("         AND V.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("         AND V.VPS_PORT_CD = SUBSTR (@[yd_cd], 1, 5)" ).append("\n"); 
		query.append("		 AND V.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("         AND NVL (SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("         AND V.TURN_PORT_IND_CD IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("#if(${org_flg} == 'E')" ).append("\n"); 
		query.append("		 -- OnLine의 경우 " ).append("\n"); 
		query.append("		 AND L.REV_YRMON =  REPLACE (@[rev_yrmon], '-', '')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${org_flg} == 'M')" ).append("\n"); 
		query.append("         -- Batch 추정일 경우 " ).append("\n"); 
		query.append(" 		 AND L.EXE_YRMON =  REPLACE (@[rev_yrmon], '-', '')" ).append("\n"); 
		query.append(" 		 AND L.REV_YRMON >= REPLACE (@[rev_yrmon], '-', '')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         AND (L.RLANE_CD =" ).append("\n"); 
		query.append("                 NVL (" ).append("\n"); 
		query.append("                    (SELECT   RLANE_CD" ).append("\n"); 
		query.append("                       FROM   VSK_VSL_PORT_SKD V," ).append("\n"); 
		query.append("                              AR_FINC_DIR_CONV B," ).append("\n"); 
		query.append("                              MDM_LOCATION L" ).append("\n"); 
		query.append("                      WHERE       V.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                              AND V.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                              AND V.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                              AND V.VPS_PORT_CD = SUBSTR (@[yd_cd], 1, 5)" ).append("\n"); 
		query.append("                              AND V.VPS_PORT_CD = L.LOC_CD" ).append("\n"); 
		query.append("                              AND V.SLAN_CD = B.SLAN_CD" ).append("\n"); 
		query.append("                              AND V.SKD_DIR_CD = B.SLAN_DIR_CD" ).append("\n"); 
		query.append("                              AND L.SCONTI_CD = B.SCONTI_CD" ).append("\n"); 
		query.append("                              AND ROWNUM <= 1)," ).append("\n"); 
		query.append("                    L.RLANE_CD" ).append("\n"); 
		query.append("                 ))" ).append("\n"); 
		query.append("         AND ( 'E' = @[org_flg] or 'M' = @[org_flg] ) " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY   OB_RTO DESC" ).append("\n"); 

	}
}