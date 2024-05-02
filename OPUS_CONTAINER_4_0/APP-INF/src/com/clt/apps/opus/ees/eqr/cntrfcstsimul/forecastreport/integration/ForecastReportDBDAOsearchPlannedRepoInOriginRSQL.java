/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ForecastReportDBDAOsearchPlannedRepoInOriginRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.29
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrfcstsimul.forecastreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ForecastReportDBDAOsearchPlannedRepoInOriginRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EES_EQR_1040 의 초기값 조회
	  * </pre>
	  */
	public ForecastReportDBDAOsearchPlannedRepoInOriginRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etb",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tpsz",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sts",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrfcstsimul.forecastreport.integration").append("\n"); 
		query.append("FileName : ForecastReportDBDAOsearchPlannedRepoInOriginRSQL").append("\n"); 
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
		query.append("WITH DUMMY_YARD AS " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT C.YD_CD, A.SCC_CD" ).append("\n"); 
		query.append("    FROM MDM_EQ_ORZ_CHT A" ).append("\n"); 
		query.append("        ,MDM_LOCATION B" ).append("\n"); 
		query.append("        ,MDM_YARD C                      " ).append("\n"); 
		query.append("  #if(${loc_grp_cd} == 'L')          " ).append("\n"); 
		query.append("    WHERE A.LCC_CD = @[loc_cd] -- E:ECC, L:LCC, S:SCC " ).append("\n"); 
		query.append("  #elseif(${loc_grp_cd} == 'E')         " ).append("\n"); 
		query.append("    WHERE A.ECC_CD = @[loc_cd] -- E:ECC, L:LCC, S:SCC" ).append("\n"); 
		query.append("  #elseif(${loc_grp_cd} == 'S')    " ).append("\n"); 
		query.append("    WHERE A.SCC_CD = @[loc_cd] -- E:ECC, L:LCC, S:SCC " ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("  #end        	                 	     " ).append("\n"); 
		query.append("    AND   A.SCC_CD = B.SCC_CD" ).append("\n"); 
		query.append("    AND   B.LOC_CD = C.LOC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("SELECT FIN_SEQ " ).append("\n"); 
		query.append("      ,STS" ).append("\n"); 
		query.append("      ,LANE" ).append("\n"); 
		query.append("      ,VSL_CD" ).append("\n"); 
		query.append("      ,SKD_VOY_NO" ).append("\n"); 
		query.append("      ,SKD_DIR_CD" ).append("\n"); 
		query.append("      ,YARD" ).append("\n"); 
		query.append("      ,ETB" ).append("\n"); 
		query.append("      ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,CNTR_QTY" ).append("\n"); 
		query.append("      ,CHK_FLG" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("	SELECT ROW_NUMBER() OVER (PARTITION BY VSL_CD, SKD_VOY_NO, SKD_DIR_CD, YARD, ETB, CNTR_TPSZ_CD ORDER BY DP_SEQ ASC) FIN_SEQ -- MANUAL 조회(P+G) > (PLAN > GUIDELINE)" ).append("\n"); 
		query.append("	      ,STS" ).append("\n"); 
		query.append("	      ,LANE" ).append("\n"); 
		query.append("	      ,VSL_CD" ).append("\n"); 
		query.append("	      ,SKD_VOY_NO" ).append("\n"); 
		query.append("	      ,SKD_DIR_CD" ).append("\n"); 
		query.append("	      ,YARD" ).append("\n"); 
		query.append("	      ,ETB" ).append("\n"); 
		query.append("	      ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	      ,CNTR_QTY" ).append("\n"); 
		query.append("	      ,CHK_FLG" ).append("\n"); 
		query.append("	FROM" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("		-- < PLAN 조회 > ----------------------------------------------------------------------------------------- " ).append("\n"); 
		query.append("		-- PLAN, GUIDE LINE 중에 PLAN > GUIDELINE 순으로 집계" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		SELECT 2 DP_SEQ     -- MANUAL P/G이 1순위이고 PLAN-GUIDELINE은 2순위" ).append("\n"); 
		query.append("		      ,PLN_REPO_STS_CD STS" ).append("\n"); 
		query.append("		      ,SLAN_CD         LANE      " ).append("\n"); 
		query.append("		      ,VSL_CD      " ).append("\n"); 
		query.append("		      ,SKD_VOY_NO  " ).append("\n"); 
		query.append("		      ,SKD_DIR_CD  " ).append("\n"); 
		query.append("		      ,POD_YD_CD       YARD" ).append("\n"); 
		query.append("		      ,TO_CHAR(VPS_ETB_DT, 'YYYY-MM-DD')   ETB  " ).append("\n"); 
		query.append("		      ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		      ,CNTR_QTY " ).append("\n"); 
		query.append("		      ,'N' CHK_FLG -- 적색표시" ).append("\n"); 
		query.append("		FROM" ).append("\n"); 
		query.append("		(         " ).append("\n"); 
		query.append("		    SELECT ROW_NUMBER() OVER (PARTITION BY VSL_CD, SKD_VOY_NO, SKD_DIR_CD, POD_YD_CD, CNTR_TPSZ_CD, VPS_ETB_DT ORDER BY DP_SEQ ASC) SEL_CD -- PLAN > GUIDELINE" ).append("\n"); 
		query.append("		          ,PLN_REPO_STS_CD" ).append("\n"); 
		query.append("		          ,VSL_CD      " ).append("\n"); 
		query.append("		          ,SKD_VOY_NO  " ).append("\n"); 
		query.append("		          ,SKD_DIR_CD  " ).append("\n"); 
		query.append("		          ,POD_YD_CD   " ).append("\n"); 
		query.append("		          ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		          ,CNTR_QTY " ).append("\n"); 
		query.append("		          ,SLAN_CD" ).append("\n"); 
		query.append("		          ,VPS_PORT_CD" ).append("\n"); 
		query.append("		          ,VPS_ETB_DT   " ).append("\n"); 
		query.append("		    FROM" ).append("\n"); 
		query.append("		    (         " ).append("\n"); 
		query.append("		        --- < PLAN > --------------------------  " ).append("\n"); 
		query.append("		        SELECT 1 DP_SEQ" ).append("\n"); 
		query.append("		              ,'P' PLN_REPO_STS_CD " ).append("\n"); 
		query.append("		              ,B.VSL_CD      " ).append("\n"); 
		query.append("		              ,B.SKD_VOY_NO  " ).append("\n"); 
		query.append("		              ,B.SKD_DIR_CD  " ).append("\n"); 
		query.append("		              ,B.POD_YD_CD   " ).append("\n"); 
		query.append("		              ,B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		              ,B.CNTR_QTY " ).append("\n"); 
		query.append("		              ,A.SLAN_CD" ).append("\n"); 
		query.append("		              ,A.VPS_PORT_CD" ).append("\n"); 
		query.append("		              ,A.VPS_ETB_DT   " ).append("\n"); 
		query.append("		        FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("		            ,(" ).append("\n"); 
		query.append("		                SELECT A.VSL_CD" ).append("\n"); 
		query.append("		                  ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("		                  ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("		                  ,A.POL_YD_CD" ).append("\n"); 
		query.append("		                  ,A.POD_YD_CD" ).append("\n"); 
		query.append("		                  ,B.CNTR_TPSZ_CD           " ).append("\n"); 
		query.append("		                  ,B.CNTR_QTY" ).append("\n"); 
		query.append("		                FROM EQR_CTRL_MTY_DCHG_PLN A" ).append("\n"); 
		query.append("		                    ,EQR_CTRL_MTY_DCHG_PLN_QTY B" ).append("\n"); 
		query.append("		                    ,DUMMY_YARD C" ).append("\n"); 
		query.append("		                WHERE A.POD_YD_CD  = C.YD_CD          " ).append("\n"); 
		query.append("		                AND   A.VSL_CD     = B.VSL_CD" ).append("\n"); 
		query.append("		                AND   A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("		                AND   A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("		                AND   A.POL_YD_CD  = B.POL_YD_CD " ).append("\n"); 
		query.append("		                AND   A.POD_YD_CD  = B.POD_YD_CD  " ).append("\n"); 
		query.append("		                AND   A.MTY_PLN_SHW_FLG = 'Y'   -- 하드코딩  " ).append("\n"); 
		query.append("		            ) B" ).append("\n"); 
		query.append("		        WHERE A.VSL_CD(+)     = B.VSL_CD" ).append("\n"); 
		query.append("		        AND   A.SKD_VOY_NO(+) = B.SKD_VOY_NO" ).append("\n"); 
		query.append("		        AND   A.SKD_DIR_CD(+) = B.SKD_DIR_CD  " ).append("\n"); 
		query.append("		        AND   A.YD_CD(+)      = B.POD_YD_CD" ).append("\n"); 
		query.append("		        AND   A.CLPT_IND_SEQ = '1'  -- 하드코딩    " ).append("\n"); 
		query.append("		        AND   A.VPS_ETB_DT BETWEEN  TO_DATE(@[etb],'YYYY-MM-DD') AND TO_DATE(@[etb],'YYYY-MM-DD')+0.9999" ).append("\n"); 
		query.append("		        " ).append("\n"); 
		query.append("		            -- < GUIDELINE 조회 > -----------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("		        UNION ALL         " ).append("\n"); 
		query.append("		        SELECT 2 DP_SEQ" ).append("\n"); 
		query.append("		              ,'G' PLN_REPO_STS_CD " ).append("\n"); 
		query.append("		              ,B.VSL_CD      " ).append("\n"); 
		query.append("		              ,B.SKD_VOY_NO  " ).append("\n"); 
		query.append("		              ,B.SKD_DIR_CD  " ).append("\n"); 
		query.append("		              ,B.POD_YD_CD   " ).append("\n"); 
		query.append("		              ,B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		              ,B.CNTR_QTY " ).append("\n"); 
		query.append("		              ,A.SLAN_CD" ).append("\n"); 
		query.append("		              ,A.VPS_PORT_CD" ).append("\n"); 
		query.append("		              ,A.VPS_ETB_DT   " ).append("\n"); 
		query.append("		        FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("		            ,(" ).append("\n"); 
		query.append("		                SELECT A.VSL_CD" ).append("\n"); 
		query.append("		                  ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("		                  ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("		                  ,A.POD_YD_CD" ).append("\n"); 
		query.append("		                  ,B.CNTR_TPSZ_CD           " ).append("\n"); 
		query.append("		                  ,B.CNTR_QTY" ).append("\n"); 
		query.append("		                FROM EQR_CTRL_PLN_SNAP A" ).append("\n"); 
		query.append("		                    ,EQR_CTRL_PLN_SNAP_QTY B" ).append("\n"); 
		query.append("		                    ,DUMMY_YARD C" ).append("\n"); 
		query.append("		                WHERE A.POD_YD_CD  = C.YD_CD          " ).append("\n"); 
		query.append("		                AND   A.VSL_CD     = B.VSL_CD" ).append("\n"); 
		query.append("		                AND   A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("		                AND   A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("		                AND   A.POD_YD_CD  = B.POD_YD_CD  " ).append("\n"); 
		query.append("		                AND   A.TO_ETB_DT  = B.TO_ETB_DT" ).append("\n"); 
		query.append("		                AND   A.TO_ETB_DT BETWEEN  TO_DATE(@[etb],'YYYY-MM-DD') AND TO_DATE(@[etb],'YYYY-MM-DD')+0.9999" ).append("\n"); 
		query.append("		            ) B" ).append("\n"); 
		query.append("		        WHERE A.VSL_CD(+)     = B.VSL_CD" ).append("\n"); 
		query.append("		        AND   A.SKD_VOY_NO(+) = B.SKD_VOY_NO" ).append("\n"); 
		query.append("		        AND   A.SKD_DIR_CD(+) = B.SKD_DIR_CD  " ).append("\n"); 
		query.append("		        AND   A.YD_CD(+)      = B.POD_YD_CD" ).append("\n"); 
		query.append("		        AND   A.CLPT_IND_SEQ  = '1'  -- 하드코딩    " ).append("\n"); 
		query.append("		    )      " ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("		WHERE SEL_CD = 1   " ).append("\n"); 
		query.append("	   " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE FIN_SEQ = 1    " ).append("\n"); 
		query.append("AND   STS          = @[sts]         " ).append("\n"); 
		query.append("AND   LANE         = @[lane]        " ).append("\n"); 
		query.append("AND   VSL_CD       = @[vsl_cd]      " ).append("\n"); 
		query.append("AND   SKD_VOY_NO   = @[skd_voy_no]  " ).append("\n"); 
		query.append("AND   SKD_DIR_CD   = @[skd_dir_cd]  " ).append("\n"); 
		query.append("AND   YARD         = @[yard]        " ).append("\n"); 
		query.append("AND   ETB          = @[etb]         " ).append("\n"); 
		query.append("AND   CNTR_TPSZ_CD = @[tpsz]" ).append("\n"); 

	}
}