/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOHc45DepImpVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.09
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOHc45DepImpVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOHc45DepImpVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOHc45DepImpVORSQL").append("\n"); 
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
		query.append("SELECT  Y.OPR_CD," ).append("\n"); 
		query.append("  ---------------------------" ).append("\n"); 
		query.append("  -- 20HC" ).append("\n"); 
		query.append("  ---------------------------" ).append("\n"); 
		query.append("        Y.HC_BSA_20," ).append("\n"); 
		query.append("        Y.HC_OR_20," ).append("\n"); 
		query.append("  ---------------------------" ).append("\n"); 
		query.append("  -- 40HC" ).append("\n"); 
		query.append("  ---------------------------" ).append("\n"); 
		query.append("        Y.HC_BSA_40," ).append("\n"); 
		query.append("        Y.HC_OR_40," ).append("\n"); 
		query.append("  ---------------------------" ).append("\n"); 
		query.append("  -- 45" ).append("\n"); 
		query.append("  ---------------------------" ).append("\n"); 
		query.append("        Y.HC_BSA_45," ).append("\n"); 
		query.append("        Y.HC_UR_45," ).append("\n"); 
		query.append("        Y.HC_OR_45," ).append("\n"); 
		query.append("        Y.TEU_WGT" ).append("\n"); 
		query.append("FROM     " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT A.CRR_CD AS OPR_CD," ).append("\n"); 
		query.append("           SUM(DECODE(A.BSA_OP_JB_CD,'007',DECODE(B.PORT_BSA_CAPA,NULL,A.CRR_BSA_CAPA,0,A.CRR_BSA_CAPA,B.PORT_BSA_CAPA)))          AS TTL_QTY," ).append("\n"); 
		query.append("           SUM(DECODE(A.BSA_OP_JB_CD,'009',DECODE(B.PORT_BSA_CAPA,NULL,A.CRR_BSA_CAPA,0,A.CRR_BSA_CAPA,B.PORT_BSA_CAPA)))          AS TTL_WGT," ).append("\n"); 
		query.append("           SUM(DECODE(A.BSA_OP_JB_CD,'022',DECODE(B.PORT_BSA_CAPA,NULL,A.CRR_BSA_CAPA,0,A.CRR_BSA_CAPA,B.PORT_BSA_CAPA)))          AS HC_BSA_20," ).append("\n"); 
		query.append("           MAX(DECODE(C.CNTR_TPSZ_CD,'D3',C.HC_OVR_RT,0))                                                                          AS HC_OR_20," ).append("\n"); 
		query.append("           SUM(DECODE(A.BSA_OP_JB_CD,'013',DECODE(B.PORT_BSA_CAPA,NULL,A.CRR_BSA_CAPA,0,A.CRR_BSA_CAPA,B.PORT_BSA_CAPA)))          AS HC_BSA_40," ).append("\n"); 
		query.append("           MAX(DECODE(C.CNTR_TPSZ_CD,'D5',C.HC_OVR_RT,0))                                                                          AS HC_OR_40," ).append("\n"); 
		query.append("           SUM(DECODE(A.BSA_OP_JB_CD,'014',DECODE(B.PORT_BSA_CAPA,NULL,A.CRR_BSA_CAPA,0,A.CRR_BSA_CAPA,B.PORT_BSA_CAPA)))          AS HC_BSA_45," ).append("\n"); 
		query.append("           MAX(DECODE(C.CNTR_TPSZ_CD,'D7',C.HC_RT,0))                                                                              AS HC_UR_45," ).append("\n"); 
		query.append("           MAX(DECODE(C.CNTR_TPSZ_CD,'D7',C.HC_OVR_RT,0))                                                                          AS HC_OR_45," ).append("\n"); 
		query.append("           ROUND(SUM(DECODE(A.BSA_OP_JB_CD,'008',DECODE(B.PORT_BSA_CAPA,NULL,A.CRR_BSA_CAPA,0,A.CRR_BSA_CAPA,B.PORT_BSA_CAPA))),1) AS TEU_WGT" ).append("\n"); 
		query.append("    FROM   BSA_VVD_OTR_CRR A," ).append("\n"); 
		query.append("           ( SELECT B.RLANE_CD, B.DIR_CD, B.TRD_CD, B.CRR_CD, B.BSA_OP_JB_CD," ).append("\n"); 
		query.append("                    SUBSTR(MAX('0'||B.BSA_SEQ||B.PORT_BSA_CAPA),3) PORT_BSA_CAPA" ).append("\n"); 
		query.append("             FROM   BSA_SLT_CHTR_PORT_DWN B" ).append("\n"); 
		query.append("             WHERE  PORT_CD(+) = @[port_cd]  --:port_cd" ).append("\n"); 
		query.append("             AND    RLANE_CD = ( SELECT D.RLANE_CD" ).append("\n"); 
		query.append("                                 FROM   MDM_REV_LANE R, MDM_DTL_REV_LANE D, VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("                                 WHERE  D.RLANE_CD    = R.RLANE_CD" ).append("\n"); 
		query.append("                                 AND    V.VSL_CD      = @[vsl_cd]   --:vsl_cd" ).append("\n"); 
		query.append("                                 AND    V.SKD_VOY_NO  = @[voy_no]   --:skd_voy_no" ).append("\n"); 
		query.append("                                 AND    V.SKD_DIR_CD  = @[dir_cd]      --:skd_dir_cd" ).append("\n"); 
		query.append("                                 AND    V.VPS_PORT_CD = @[port_cd]  --:port_cd" ).append("\n"); 
		query.append("                                 AND    V.CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 
		query.append("                                 AND    R.VSL_SLAN_CD = V.SLAN_CD" ).append("\n"); 
		query.append("                                 AND    ( D.FM_CONTI_CD, D.TO_CONTI_CD ) IN (" ).append("\n"); 
		query.append("                                          SELECT CONTI_CD, NVL(LEAD_CONTI_CD, CONTI_CD)" ).append("\n"); 
		query.append("                                          FROM   ( SELECT V.CLPT_SEQ, V.VPS_PORT_CD, L.CONTI_CD," ).append("\n"); 
		query.append("                                                          LEAD(CONTI_CD) OVER (PARTITION BY V.VSL_CD, V.SKD_VOY_NO, V.SKD_DIR_CD ORDER BY V.CLPT_SEQ) LEAD_CONTI_CD" ).append("\n"); 
		query.append("                                                   FROM   VSK_VSL_PORT_SKD V, MDM_LOCATION L" ).append("\n"); 
		query.append("                                                   WHERE  V.VSL_CD      = @[vsl_cd]       --:vsl_cd" ).append("\n"); 
		query.append("                                                   AND    V.SKD_VOY_NO  = @[voy_no]       --:skd_voy_no" ).append("\n"); 
		query.append("                                                   AND    V.SKD_DIR_CD  = @[dir_cd]          --:skd_dir_cd" ).append("\n"); 
		query.append("                                                   AND    V.VPS_PORT_CD = @[port_cd]      --:port_cd" ).append("\n"); 
		query.append("                                                   AND V.CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 
		query.append("                                                   AND    V.VPS_PORT_CD = L.LOC_CD )" ).append("\n"); 
		query.append("                                       	WHERE  1 = 1" ).append("\n"); 
		query.append("                           				----AND    CONTI_CD = 'A'" ).append("\n"); 
		query.append("                           				AND    CONTI_CD = (SELECT ML.CONTI_CD FROM MDM_LOCATION ML WHERE ML.LOC_CD  = @[port_cd])" ).append("\n"); 
		query.append("                                        AND    CONTI_CD <> NVL(LEAD_CONTI_CD,'X') )" ).append("\n"); 
		query.append("                                 AND    D.VSL_SLAN_DIR_CD = NVL(@[dir_cd],D.VSL_SLAN_DIR_CD)  --:skd_dir_cd" ).append("\n"); 
		query.append("                                 AND    D.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("                                 AND    ROWNUM = 1 )" ).append("\n"); 
		query.append("             AND    DIR_CD       = @[dir_cd]                                                  --:skd_dir_cd" ).append("\n"); 
		query.append("             AND    BSA_OP_JB_CD IN ('007', '009', '013', '014', '008', '022')" ).append("\n"); 
		query.append("             GROUP BY RLANE_CD, DIR_CD, TRD_CD, CRR_CD, BSA_OP_JB_CD ) B," ).append("\n"); 
		query.append("           ( SELECT M.RLANE_CD, M.DIR_CD, M.TRD_CD, D.CRR_CD, M.CNTR_TPSZ_CD, D.HC_RT, D.HC_OVR_RT" ).append("\n"); 
		query.append("             FROM   BSA_HIGH_CUBIC_RT_MST M, BSA_HIGH_CUBIC_RT_DTL D" ).append("\n"); 
		query.append("             WHERE  M.CNTR_TPSZ_CD = D.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("             AND    M.BSA_SEQ      = D.BSA_SEQ" ).append("\n"); 
		query.append("             AND    M.RLANE_CD = ( SELECT D.RLANE_CD" ).append("\n"); 
		query.append("                                   FROM   MDM_REV_LANE R, MDM_DTL_REV_LANE D, VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("                                   WHERE  D.RLANE_CD    = R.RLANE_CD" ).append("\n"); 
		query.append("                                   AND    V.VSL_CD      = @[vsl_cd]   --:vsl_cd" ).append("\n"); 
		query.append("                                   AND    V.SKD_VOY_NO  = @[voy_no]   --:skd_voy_no" ).append("\n"); 
		query.append("                                   AND    V.SKD_DIR_CD  = @[dir_cd]   --:skd_dir_cd" ).append("\n"); 
		query.append("                                   AND    V.VPS_PORT_CD = @[port_cd]  --:port_cd" ).append("\n"); 
		query.append("                                   AND V.CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 
		query.append("                                   AND    R.VSL_SLAN_CD = V.SLAN_CD" ).append("\n"); 
		query.append("                                   AND    ( D.FM_CONTI_CD, D.TO_CONTI_CD ) IN (" ).append("\n"); 
		query.append("                                            SELECT CONTI_CD, NVL(LEAD_CONTI_CD, CONTI_CD)" ).append("\n"); 
		query.append("                                            FROM   ( SELECT V.CLPT_SEQ, V.VPS_PORT_CD, L.CONTI_CD," ).append("\n"); 
		query.append("                                                            LEAD(CONTI_CD) OVER (PARTITION BY V.VSL_CD, V.SKD_VOY_NO, V.SKD_DIR_CD ORDER BY V.CLPT_SEQ) LEAD_CONTI_CD" ).append("\n"); 
		query.append("                                                     FROM   VSK_VSL_PORT_SKD V, MDM_LOCATION L" ).append("\n"); 
		query.append("                                                     WHERE  V.VSL_CD      = @[vsl_cd]       --:vsl_cd" ).append("\n"); 
		query.append("                                                     AND    V.SKD_VOY_NO  = @[voy_no]       --:skd_voy_no" ).append("\n"); 
		query.append("                                                     AND    V.SKD_DIR_CD  = @[dir_cd]          --:skd_dir_cd" ).append("\n"); 
		query.append("                                                     AND    V.VPS_PORT_CD = @[port_cd]      --:port_cd" ).append("\n"); 
		query.append("                                                     AND V.CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 
		query.append("                                                     AND    V.VPS_PORT_CD = L.LOC_CD )" ).append("\n"); 
		query.append("                                       		WHERE  1 = 1" ).append("\n"); 
		query.append("                           				----AND    CONTI_CD = 'A'" ).append("\n"); 
		query.append("                           					AND    CONTI_CD = (SELECT ML.CONTI_CD FROM MDM_LOCATION ML WHERE ML.LOC_CD  = @[port_cd])" ).append("\n"); 
		query.append("                                            AND    CONTI_CD <> NVL(LEAD_CONTI_CD,'X') )" ).append("\n"); 
		query.append("                                   AND    D.VSL_SLAN_DIR_CD = NVL(@[dir_cd],D.VSL_SLAN_DIR_CD)  --:skd_dir_cd" ).append("\n"); 
		query.append("                                   AND    D.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("                                   AND    ROWNUM = 1 )" ).append("\n"); 
		query.append("               AND    DIR_CD       = @[dir_cd] ) C" ).append("\n"); 
		query.append("    WHERE  A.RLANE_CD     = B.RLANE_CD(+)" ).append("\n"); 
		query.append("    AND    A.SKD_DIR_CD   = B.DIR_CD(+)" ).append("\n"); 
		query.append("    AND    A.TRD_CD       = B.TRD_CD(+)" ).append("\n"); 
		query.append("    AND    A.CRR_CD       = B.CRR_CD(+)" ).append("\n"); 
		query.append("    AND    A.BSA_OP_JB_CD = B.BSA_OP_JB_CD(+)" ).append("\n"); 
		query.append("    AND    A.RLANE_CD     = C.RLANE_CD(+)" ).append("\n"); 
		query.append("    AND    A.SKD_DIR_CD   = C.DIR_CD(+)" ).append("\n"); 
		query.append("    AND    A.TRD_CD       = C.TRD_CD(+)" ).append("\n"); 
		query.append("    AND    A.CRR_CD       = C.CRR_CD(+)" ).append("\n"); 
		query.append("    AND    A.RLANE_CD     = ( SELECT D.RLANE_CD" ).append("\n"); 
		query.append("                              FROM   MDM_REV_LANE R, MDM_DTL_REV_LANE D, VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("                              WHERE  D.RLANE_CD    = R.RLANE_CD" ).append("\n"); 
		query.append("                              AND    V.VSL_CD      = @[vsl_cd]   --:vsl_cd" ).append("\n"); 
		query.append("                              AND    V.SKD_VOY_NO  = @[voy_no]   --:skd_voy_no" ).append("\n"); 
		query.append("                              AND    V.SKD_DIR_CD  = @[dir_cd]      --:skd_dir_cd" ).append("\n"); 
		query.append("                              AND    V.VPS_PORT_CD = @[port_cd]  --:port_cd" ).append("\n"); 
		query.append("                              AND    R.VSL_SLAN_CD = V.SLAN_CD" ).append("\n"); 
		query.append("                               AND V.CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 
		query.append("                              AND    ( D.FM_CONTI_CD, D.TO_CONTI_CD ) IN (" ).append("\n"); 
		query.append("                                       SELECT CONTI_CD, NVL(LEAD_CONTI_CD, CONTI_CD)" ).append("\n"); 
		query.append("                                       FROM   ( SELECT V.CLPT_SEQ, V.VPS_PORT_CD, L.CONTI_CD," ).append("\n"); 
		query.append("                                                       LEAD(CONTI_CD) OVER (PARTITION BY V.VSL_CD, V.SKD_VOY_NO, V.SKD_DIR_CD ORDER BY V.CLPT_SEQ) LEAD_CONTI_CD" ).append("\n"); 
		query.append("                                                FROM   VSK_VSL_PORT_SKD V, MDM_LOCATION L" ).append("\n"); 
		query.append("                                                WHERE  V.VSL_CD      = @[vsl_cd]       --:vsl_cd" ).append("\n"); 
		query.append("                                                AND    V.SKD_VOY_NO  = @[voy_no]       --:skd_voy_no" ).append("\n"); 
		query.append("                                                AND    V.SKD_DIR_CD  = @[dir_cd]          --:skd_dir_cd" ).append("\n"); 
		query.append("                                                AND    V.VPS_PORT_CD = @[port_cd]      --:port_cd" ).append("\n"); 
		query.append("                                                AND V.CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 
		query.append("                                                AND    V.VPS_PORT_CD = L.LOC_CD )" ).append("\n"); 
		query.append("                                       WHERE  1 = 1" ).append("\n"); 
		query.append("                           			----AND    CONTI_CD = 'A'" ).append("\n"); 
		query.append("                           				AND    CONTI_CD = (SELECT ML.CONTI_CD FROM MDM_LOCATION ML WHERE ML.LOC_CD  = @[port_cd])" ).append("\n"); 
		query.append("                                       	AND    CONTI_CD <> NVL(LEAD_CONTI_CD,'X') )" ).append("\n"); 
		query.append("                              AND    D.VSL_SLAN_DIR_CD = NVL(@[dir_cd],D.VSL_SLAN_DIR_CD)  --:skd_dir_cd" ).append("\n"); 
		query.append("                              AND    D.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("                              AND    ROWNUM = 1 )" ).append("\n"); 
		query.append("    AND    A.VSL_CD       = @[vsl_cd]" ).append("\n"); 
		query.append("    AND    A.SKD_VOY_NO   = @[voy_no]" ).append("\n"); 
		query.append("    AND    A.SKD_DIR_CD   = @[dir_cd]" ).append("\n"); 
		query.append("    AND    A.BSA_OP_JB_CD IN ('007', '009', '013', '014', '008')" ).append("\n"); 
		query.append("    AND    ( A.CRR_BSA_CAPA > 0 OR B.PORT_BSA_CAPA > 0 )" ).append("\n"); 
		query.append("    GROUP BY A.CRR_CD, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD" ).append("\n"); 
		query.append("    ORDER BY A.CRR_CD" ).append("\n"); 
		query.append(")Y" ).append("\n"); 
		query.append("ORDER BY Y.OPR_CD" ).append("\n"); 

	}
}