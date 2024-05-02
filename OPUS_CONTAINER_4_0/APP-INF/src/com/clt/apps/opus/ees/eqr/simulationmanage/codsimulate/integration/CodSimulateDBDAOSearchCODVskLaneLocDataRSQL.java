/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CodSimulateDBDAOSearchCODVskLaneLocDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodSimulateDBDAOSearchCODVskLaneLocDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD에 따른 LOC 조회
	  * </pre>
	  */
	public CodSimulateDBDAOSearchCODVskLaneLocDataRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_yrwk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.integration ").append("\n"); 
		query.append("FileName : CodSimulateDBDAOSearchCODVskLaneLocDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("	VSL_LOC_CD AS VSL_LOC_CD" ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("	SELECT" ).append("\n"); 
		query.append("		VSL_LOC_CD" ).append("\n"); 
		query.append("		FROM ( " ).append("\n"); 
		query.append("		SELECT VPS_PORT_CD AS VSL_LOC_CD" ).append("\n"); 
		query.append("	    FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("		    WHERE VSL_CD 	= @[vsl_cd]" ).append("\n"); 
		query.append("	 	    AND SKD_VOY_NO 	= @[skd_voy_no]" ).append("\n"); 
		query.append("	 	    AND SKD_DIR_CD 	= @[skd_dir_cd]" ).append("\n"); 
		query.append("		    AND EXISTS ( SELECT 'X'" ).append("\n"); 
		query.append("	                        FROM   MDM_EQ_ORZ_CHT CHT, MDM_LOCATION ML" ).append("\n"); 
		query.append("	                        WHERE  CHT.SCC_CD = ML.SCC_CD" ).append("\n"); 
		query.append("                              AND    VPS_PORT_CD = ML.LOC_CD" ).append("\n"); 
		query.append("                              AND    ROWNUM      = 1)" ).append("\n"); 
		query.append("                        AND SLAN_CD 	    = DECODE(@[vsl_lane_cd], NULL, DECODE(@[vsl_cd], NULL, @[vsl_lane_cd], SLAN_CD)  , null)" ).append("\n"); 
		query.append("                        AND TO_CHAR(VPS_ETD_DT ,'YYYYMMDD') >= (SELECT WK_ST_DT FROM EQR_WK_PRD WHERE PLN_YR || PLN_WK = @[pln_yrwk] )" ).append("\n"); 
		query.append("		                ORDER BY  VPS_ETD_DT" ).append("\n"); 
		query.append("		      ) Z" ).append("\n"); 
		query.append("         )" ).append("\n"); 

	}
}