/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OnTimeResultAnalysisDBDAOSearchRsltRmkDtlListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.16
*@LastModifier : 임창빈
*@LastVersion : 1.0
* 2010.04.16 임창빈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chang-Bin Lim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnTimeResultAnalysisDBDAOSearchRsltRmkDtlListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public OnTimeResultAnalysisDBDAOSearchRsltRmkDtlListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tab_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ig_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("port_skp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_grp_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.integration").append("\n"); 
		query.append("FileName : OnTimeResultAnalysisDBDAOSearchRsltRmkDtlListRSQL").append("\n"); 
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
		query.append("SELECT  VVD, VPS_PORT_CD, REASON_PORT, ARR_DEP, RSN_CD, TO_CHAR(SUM(DELAY_TM)) AS DELAY_TM,  RMK" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  VVD" ).append("\n"); 
		query.append("                , VPS_PORT_CD" ).append("\n"); 
		query.append("                , REASON_PORT" ).append("\n"); 
		query.append("                , DECODE(SEQ, 1, ARR_DEP1 , 2, ARR_DEP2 , 3, ARR_DEP3 , 4, ARR_DEP4  ) AS ARR_DEP" ).append("\n"); 
		query.append("                , DECODE(SEQ, 1, RSN_CD1  , 2, RSN_CD2  , 3, RSN_CD3  , 4, RSN_CD4   ) AS RSN_CD" ).append("\n"); 
		query.append("                , DECODE(SEQ, 1, DELAY_TM1, 2, DELAY_TM2, 3, DELAY_TM3, 4, DELAY_TM4 ) AS DELAY_TM" ).append("\n"); 
		query.append("                , DECODE(SEQ, 1, RMK1     , 2, RMK2     , 3, RMK3     , 4, RMK4      ) AS RMK" ).append("\n"); 
		query.append("        FROM    (" ).append("\n"); 
		query.append("                SELECT  T1.VSL_CD || T1.SKD_VOY_NO || T1.SUB_TRD_DIR_CD AS VVD" ).append("\n"); 
		query.append("                        ,T1.VPS_PORT_CD" ).append("\n"); 
		query.append("                        ,' '                                            AS REASON_PORT" ).append("\n"); 
		query.append("                        ,'ARR1'                                         AS ARR_DEP1" ).append("\n"); 
		query.append("                        ,ARR_DLAY_RSN_CD1                               AS RSN_CD1" ).append("\n"); 
		query.append("                        ,TO_CHAR(ARR_DLAY_HRS1)                         AS DELAY_TM1" ).append("\n"); 
		query.append("                        ,ARR_RMK1                                       AS RMK1" ).append("\n"); 
		query.append("                        ,'ARR2'                                         AS ARR_DEP2" ).append("\n"); 
		query.append("                        ,ARR_DLAY_RSN_CD2                               AS RSN_CD2" ).append("\n"); 
		query.append("                        ,TO_CHAR(ARR_DLAY_HRS2)                         AS DELAY_TM2" ).append("\n"); 
		query.append("                        ,ARR_RMK2                                       AS RMK2" ).append("\n"); 
		query.append("                        ,'DEP1'                                         AS ARR_DEP3" ).append("\n"); 
		query.append("                        ,DEP_DLAY_RSN_CD1                               AS RSN_CD3" ).append("\n"); 
		query.append("                        ,TO_CHAR(DEP_DLAY_HRS1)                         AS DELAY_TM3" ).append("\n"); 
		query.append("                        ,DEP_RMK1                                       AS RMK3" ).append("\n"); 
		query.append("                        ,'DEP2'                                         AS ARR_DEP4" ).append("\n"); 
		query.append("                        ,DEP_DLAY_RSN_CD2                               AS RSN_CD4" ).append("\n"); 
		query.append("                        ,TO_CHAR(DEP_DLAY_HRS2)                         AS DELAY_TM4" ).append("\n"); 
		query.append("                        ,DEP_RMK2                                       AS RMK4" ).append("\n"); 
		query.append("                FROM    VSK_VSL_SKD_RSLT T1,  VSK_VSL_SKD T2, MDM_VSL_CNTR T3" ).append("\n"); 
		query.append("                WHERE   T1.VSL_CD        = T2.VSL_CD" ).append("\n"); 
		query.append("                AND     T1.SKD_VOY_NO    = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("                AND     T1.SKD_DIR_CD    = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND     T1.VSL_CD        = T3.VSL_CD" ).append("\n"); 
		query.append("                #if (${vsl_cd} != '') " ).append("\n"); 
		query.append("                AND     T2.VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${vps_port_cd} != '') " ).append("\n"); 
		query.append("                AND     T1.VPS_PORT_CD   = @[vps_port_cd]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${crr_cd} != '') " ).append("\n"); 
		query.append("                AND     T3.CRR_CD        = @[crr_cd]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                AND     ACT_INP_YRMON   >= TO_CHAR(TO_DATE(@[fm_dt], 'YYYY-MM'), 'YYYYMM')" ).append("\n"); 
		query.append("                AND     ACT_INP_YRMON   <= TO_CHAR(TO_DATE(@[to_dt], 'YYYY-MM'), 'YYYYMM')" ).append("\n"); 
		query.append("                AND     (   (DECODE(@[ig_flg], 'I', T2.VSL_SLAN_CD) = NVL(@[vsl_slan_cd], T2.VSL_SLAN_CD))  " ).append("\n"); 
		query.append("                        OR  (DECODE(@[ig_flg], 'G', T2.VSL_SLAN_CD) IN  (SELECT VSL_SLAN_CD FROM VSK_USR_LANE_GRP WHERE USR_ID = @[usr_id] AND LANE_GRP_NM = @[lane_grp_nm]))" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                AND     DECODE(@[tab_flg], '1', 'Y', 'N') = 'Y'" ).append("\n"); 
		query.append("                ) T1, ( SELECT   1 AS SEQ FROM DUAL UNION ALL" ).append("\n"); 
		query.append("                        SELECT   2        FROM DUAL UNION ALL" ).append("\n"); 
		query.append("                        SELECT   3        FROM DUAL UNION ALL" ).append("\n"); 
		query.append("                        SELECT   4        FROM DUAL)" ).append("\n"); 
		query.append("        WHERE   1 = 1" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("WHERE   RSN_CD IS NOT NULL" ).append("\n"); 
		query.append("GROUP BY VVD, VPS_PORT_CD, REASON_PORT, ARR_DEP, RSN_CD, RMK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  T1.VSL_CD || T1.SKD_VOY_NO || T1.SKD_DIR_CD     AS VVD" ).append("\n"); 
		query.append("        ,T1.VPS_PORT_CD" ).append("\n"); 
		query.append("        ,T1.PORT_SKP_RSN_OFFR_RMK                       AS REASON_PORT" ).append("\n"); 
		query.append("        ,' '                                            AS ARR_DEP" ).append("\n"); 
		query.append("        ,PORT_SKP_RSN_CD                                AS RSN_CD" ).append("\n"); 
		query.append("        ,' '                                            AS DELAY_TM" ).append("\n"); 
		query.append("        ,VPS_RMK                                        AS RMK" ).append("\n"); 
		query.append("FROM    VSK_VSL_PORT_SKD T1, VSK_VSL_SKD T2, MDM_VSL_CNTR T3" ).append("\n"); 
		query.append("WHERE   1                   = 1" ).append("\n"); 
		query.append("AND     T1.VSL_CD           = T2.VSL_CD" ).append("\n"); 
		query.append("AND     T1.SKD_VOY_NO       = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     T1.SKD_DIR_CD       = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     T2.VSL_CD           = T3.VSL_CD" ).append("\n"); 
		query.append("AND     T1.VPS_ETA_DT       BETWEEN  TO_DATE(@[fm_dt], 'YYYY-MM')" ).append("\n"); 
		query.append("                            AND      LAST_DAY(TO_DATE(@[to_dt], 'YYYY-MM')) + 0.99999" ).append("\n"); 
		query.append("AND     (   (DECODE(@[ig_flg], 'I', T1.SLAN_CD) = NVL(@[vsl_slan_cd], T1.SLAN_CD))  " ).append("\n"); 
		query.append("        OR  (DECODE(@[ig_flg], 'G', T1.SLAN_CD) IN  (SELECT VSL_SLAN_CD FROM VSK_USR_LANE_GRP WHERE USR_ID = @[usr_id] AND LANE_GRP_NM = @[lane_grp_nm]))" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#if (${vsl_cd} != '') " ).append("\n"); 
		query.append("AND     T2.VSL_CD           = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vps_port_cd} != '') " ).append("\n"); 
		query.append("AND     T1.VPS_PORT_CD      = @[vps_port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${crr_cd} != '') " ).append("\n"); 
		query.append("AND     T3.CRR_CD           = @[crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND     T1.PORT_SKP_TP_CD   = DECODE(@[port_skp_tp_cd], 'A', PORT_SKP_TP_CD, @[port_skp_tp_cd])" ).append("\n"); 
		query.append("AND     T1.TURN_PORT_IND_CD NOT IN ('V', 'D', 'F')" ).append("\n"); 
		query.append("AND     T1.SKD_CNG_STS_CD   = 'S'" ).append("\n"); 
		query.append("AND     DECODE(@[tab_flg], '2', 'Y', 'N') = 'Y'" ).append("\n"); 
		query.append("AND     T1.USD_FLG          = 'Y' " ).append("\n"); 
		query.append("ORDER BY 1, 2, 3, 4" ).append("\n"); 

	}
}