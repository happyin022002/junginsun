/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VesselInformationMgtDBDAOLoadFactorListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselInformationMgtDBDAOLoadFactorListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Load Factor List 를 조회한다.
	  * </pre>
	  */
	public VesselInformationMgtDBDAOLoadFactorListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.integration").append("\n"); 
		query.append("FileName : VesselInformationMgtDBDAOLoadFactorListVORSQL").append("\n"); 
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
		query.append("SELECT    X.VSL_SLAN_CD" ).append("\n"); 
		query.append("       ,  X.PF_SKD_TP_CD" ).append("\n"); 
		query.append("       ,  D.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("       ,  D.VSL_SLAN_DIR_SEQ" ).append("\n"); 
		query.append("       ,  X.VSL_CD" ).append("\n"); 
		query.append("          -------------------------------------------------------------              " ).append("\n"); 
		query.append("       ,  CASE WHEN COUNT(1) = 0 THEN 0" ).append("\n"); 
		query.append("               ELSE SUM(NVL(H.BSA_CAPA,0)) / COUNT(1)" ).append("\n"); 
		query.append("          END  AS AVG_BSA_CAPA_QTY" ).append("\n"); 
		query.append("          -------------------------------------------------------------" ).append("\n"); 
		query.append("       ,  CASE WHEN COUNT(1) = 0 THEN 0" ).append("\n"); 
		query.append("               ELSE SUM(NVL(R.TTL_CNTR_OBRD_TEU,0)) / COUNT(1)" ).append("\n"); 
		query.append("          END  AS AVG_TTL_LOAD_TEU_QTY" ).append("\n"); 
		query.append("       ,  CASE WHEN SUM(NVL(R.TTL_CNTR_OBRD_TEU,0)) = 0 THEN 0" ).append("\n"); 
		query.append("               ELSE SUM(NVL(H.BSA_CAPA,0)) / SUM(NVL(R.TTL_CNTR_OBRD_TEU,0)) " ).append("\n"); 
		query.append("          END  AS AVG_LOAD_FACT_RATIO" ).append("\n"); 
		query.append("       ,  CASE WHEN COUNT(1) = 0 THEN 0" ).append("\n"); 
		query.append("               ELSE SUM(NVL(R.DEP_BLST_WGT,0)) / COUNT(1)" ).append("\n"); 
		query.append("          END  AS AVG_LAST_PORT_BLST_QTY" ).append("\n"); 
		query.append("       ,  CASE WHEN COUNT(1) = 0 THEN 0" ).append("\n"); 
		query.append("               ELSE SUM(NVL(R.DEP_MID_DRFT_HGT,0)) / COUNT(1) " ).append("\n"); 
		query.append("          END  AS AVG_LAST_PORT_DRFT_QTY" ).append("\n"); 
		query.append("          -------------------------------------------------------------" ).append("\n"); 
		query.append("FROM      BSA_VVD_MST     H" ).append("\n"); 
		query.append("       ,  (" ).append("\n"); 
		query.append("          --=============================================================================" ).append("\n"); 
		query.append("          --=============================================================================" ).append("\n"); 
		query.append("          SELECT    XX.*" ).append("\n"); 
		query.append("          FROM      (" ).append("\n"); 
		query.append("                    --===================================================================" ).append("\n"); 
		query.append("                    SELECT      X.*" ).append("\n"); 
		query.append("                    FROM        (" ).append("\n"); 
		query.append("                                ---------------------------------------------------------------------" ).append("\n"); 
		query.append("                                SELECT    VS.*" ).append("\n"); 
		query.append("                                      ,   RANK() OVER (PARTITION BY PS.VSL_CD, PS.SKD_VOY_NO, PS.SKD_DIR_CD ORDER BY PS.CLPT_SEQ DESC) LAST_PORT_ORDER" ).append("\n"); 
		query.append("                                      ,   PS.VPS_PORT_CD            AS LAST_PORT_CD" ).append("\n"); 
		query.append("                                FROM      VSK_VSL_SKD               VS" ).append("\n"); 
		query.append("                                      ,   VSK_VSL_PORT_SKD          PS" ).append("\n"); 
		query.append("                                WHERE     1 = 1                 " ).append("\n"); 
		query.append("                                AND       VS.VSL_CD                 = PS.VSL_CD" ).append("\n"); 
		query.append("                                AND       VS.SKD_VOY_NO             = PS.SKD_VOY_NO" ).append("\n"); 
		query.append("                                AND       VS.SKD_DIR_CD             = PS.SKD_DIR_CD" ).append("\n"); 
		query.append("                                AND       NVL(PS.SKD_CNG_STS_CD,'*')<> 'S'" ).append("\n"); 
		query.append("                                AND       PS.TURN_PORT_IND_CD       IN ('Y','N')" ).append("\n"); 
		query.append("                                AND       VS.VSL_CD                 = @[vsl_cd]" ).append("\n"); 
		query.append("								AND       VS.PF_SKD_TP_CD           = VSK_VESSEL_SCHEDULE_PKG.GET_PF_SVC_TP_FOR_CUR_VSL_FNC(@[vsl_cd])" ).append("\n"); 
		query.append("                                AND       VS.N1ST_PORT_BRTH_DT      > SYSDATE" ).append("\n"); 
		query.append("                                " ).append("\n"); 
		query.append("                                ---------------------------------------------------------------------                    " ).append("\n"); 
		query.append("                                ) X" ).append("\n"); 
		query.append("                    WHERE       1 = 1" ).append("\n"); 
		query.append("                    AND         X.LAST_PORT_ORDER = 1" ).append("\n"); 
		query.append("                    ORDER BY    X.N1ST_PORT_BRTH_DT      ASC" ).append("\n"); 
		query.append("                    --===================================================================                    " ).append("\n"); 
		query.append("                    ) XX" ).append("\n"); 
		query.append("          WHERE     ROWNUM    = 1" ).append("\n"); 
		query.append("          UNION ALL" ).append("\n"); 
		query.append("          SELECT    XX.*" ).append("\n"); 
		query.append("          FROM      (" ).append("\n"); 
		query.append("                    --===================================================================" ).append("\n"); 
		query.append("                    SELECT      X.*" ).append("\n"); 
		query.append("                    FROM        (" ).append("\n"); 
		query.append("                                ---------------------------------------------------------------------" ).append("\n"); 
		query.append("                                SELECT    VS.*" ).append("\n"); 
		query.append("                                      ,   RANK() OVER (PARTITION BY PS.VSL_CD, PS.SKD_VOY_NO, PS.SKD_DIR_CD ORDER BY PS.CLPT_SEQ DESC) LAST_PORT_ORDER" ).append("\n"); 
		query.append("                                      ,   PS.VPS_PORT_CD            AS LAST_PORT_CD" ).append("\n"); 
		query.append("                                FROM      VSK_VSL_SKD               VS" ).append("\n"); 
		query.append("                                      ,   VSK_VSL_PORT_SKD          PS" ).append("\n"); 
		query.append("                                WHERE     1 = 1                 " ).append("\n"); 
		query.append("                                AND       VS.VSL_CD                 = PS.VSL_CD" ).append("\n"); 
		query.append("                                AND       VS.SKD_VOY_NO             = PS.SKD_VOY_NO" ).append("\n"); 
		query.append("                                AND       VS.SKD_DIR_CD             = PS.SKD_DIR_CD" ).append("\n"); 
		query.append("                                AND       NVL(PS.SKD_CNG_STS_CD,'*')<> 'S'" ).append("\n"); 
		query.append("                                AND       PS.TURN_PORT_IND_CD       IN ('Y','N')" ).append("\n"); 
		query.append("                                AND       VS.VSL_CD                 = @[vsl_cd]" ).append("\n"); 
		query.append("								AND       VS.PF_SKD_TP_CD           = VSK_VESSEL_SCHEDULE_PKG.GET_PF_SVC_TP_FOR_CUR_VSL_FNC(@[vsl_cd])" ).append("\n"); 
		query.append("                                AND       VS.N1ST_PORT_BRTH_DT      <= SYSDATE" ).append("\n"); 
		query.append("                                " ).append("\n"); 
		query.append("                                ---------------------------------------------------------------------                    " ).append("\n"); 
		query.append("                                ) X" ).append("\n"); 
		query.append("                    WHERE       1 = 1" ).append("\n"); 
		query.append("                    AND         X.LAST_PORT_ORDER = 1" ).append("\n"); 
		query.append("                    ORDER BY    X.N1ST_PORT_BRTH_DT      DESC" ).append("\n"); 
		query.append("                    --===================================================================                    " ).append("\n"); 
		query.append("                    ) XX" ).append("\n"); 
		query.append("          WHERE     ROWNUM      <= 5" ).append("\n"); 
		query.append("          --=============================================================================" ).append("\n"); 
		query.append("          --=============================================================================          " ).append("\n"); 
		query.append("          ) X" ).append("\n"); 
		query.append("       ,  MDM_VSL_SVC_LANE_DIR  D" ).append("\n"); 
		query.append("       ,  FCM_DEP_RPT           R" ).append("\n"); 
		query.append("WHERE     1 = 1" ).append("\n"); 
		query.append("AND       X.VSL_SLAN_CD         = D.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND       X.SKD_DIR_CD          = D.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("AND       X.VSL_CD              = H.VSL_CD         (+)" ).append("\n"); 
		query.append("AND       X.SKD_VOY_NO          = H.SKD_VOY_NO     (+)" ).append("\n"); 
		query.append("AND       X.SKD_DIR_CD          = H.SKD_DIR_CD     (+)    " ).append("\n"); 
		query.append("AND       X.VSL_CD              = R.VSL_CD         (+)" ).append("\n"); 
		query.append("AND       X.SKD_VOY_NO          = R.SKD_VOY_NO     (+)" ).append("\n"); 
		query.append("AND       X.SKD_DIR_CD          = R.SKD_DIR_CD     (+)" ).append("\n"); 
		query.append("AND       X.LAST_PORT_CD        = R.DEP_PORT_CD    (+)" ).append("\n"); 
		query.append("GROUP BY  X.VSL_SLAN_CD" ).append("\n"); 
		query.append("       ,  X.PF_SKD_TP_CD" ).append("\n"); 
		query.append("       ,  D.VSL_SLAN_DIR_CD       " ).append("\n"); 
		query.append("       ,  D.VSL_SLAN_DIR_SEQ" ).append("\n"); 
		query.append("       ,  X.VSL_CD" ).append("\n"); 
		query.append("ORDER BY  D.VSL_SLAN_DIR_SEQ    ASC" ).append("\n"); 

	}
}