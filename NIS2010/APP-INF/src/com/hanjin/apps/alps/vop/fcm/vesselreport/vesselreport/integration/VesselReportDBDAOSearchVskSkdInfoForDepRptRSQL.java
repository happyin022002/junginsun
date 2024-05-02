/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : VesselReportDBDAOSearchVskSkdInfoForDepRptRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselReportDBDAOSearchVskSkdInfoForDepRptRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Departure Report PK 로 Vessel Schedule 참고 정보 조회
	  * </pre>
	  */
	public VesselReportDBDAOSearchVskSkdInfoForDepRptRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("dep_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.integration").append("\n"); 
		query.append("FileName : VesselReportDBDAOSearchVskSkdInfoForDepRptRSQL").append("\n"); 
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
		query.append("WITH VSL_SKD_TMP AS (" ).append("\n"); 
		query.append("    -- Last Port Schedule 를 추출하기 위한 쿼리" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("        T1.VSL_CD" ).append("\n"); 
		query.append("        ,T1.SKD_VOY_NO" ).append("\n"); 
		query.append("        ,T1.SKD_DIR_CD" ).append("\n"); 
		query.append("        ,T1.VPS_PORT_CD" ).append("\n"); 
		query.append("        ,T1.CLPT_IND_SEQ" ).append("\n"); 
		query.append("		,LAG(T1.VSL_CD) OVER (PARTITION BY T1.VSL_CD ORDER BY T1.SKD_VOY_NO, T2.VSL_SLAN_DIR_SEQ, T1.CLPT_SEQ) AS LAST_VSL_CD" ).append("\n"); 
		query.append("		,LAG(T1.SKD_VOY_NO) OVER (PARTITION BY T1.VSL_CD ORDER BY T1.SKD_VOY_NO, T2.VSL_SLAN_DIR_SEQ, T1.CLPT_SEQ) AS LAST_SKD_VOY_NO" ).append("\n"); 
		query.append("		,LAG(T1.SKD_DIR_CD) OVER (PARTITION BY T1.VSL_CD ORDER BY T1.SKD_VOY_NO, T2.VSL_SLAN_DIR_SEQ, T1.CLPT_SEQ) AS LAST_SKD_DIR_CD" ).append("\n"); 
		query.append("        ,LAG(T1.VPS_PORT_CD) OVER (PARTITION BY T1.VSL_CD ORDER BY T1.SKD_VOY_NO, T2.VSL_SLAN_DIR_SEQ, T1.CLPT_SEQ) AS LAST_PORT_CD" ).append("\n"); 
		query.append("        ,LAG(T1.CLPT_IND_SEQ) OVER (PARTITION BY T1.VSL_CD ORDER BY T1.SKD_VOY_NO, T2.VSL_SLAN_DIR_SEQ, T1.CLPT_SEQ) AS LAST_CLPT_IND_SEQ" ).append("\n"); 
		query.append("    FROM VSK_VSL_PORT_SKD T1, MDM_VSL_SVC_LANE_DIR T2" ).append("\n"); 
		query.append("    WHERE T1.SLAN_CD = T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("    AND T1.SKD_DIR_CD = T2.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("    AND T1.TURN_PORT_IND_CD IN ('Y','N')" ).append("\n"); 
		query.append("    AND NVL(T1.SKD_CNG_STS_CD, 'X')<>'S'" ).append("\n"); 
		query.append("    AND T1.VSL_CD IN (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("        T1.VSL_CD" ).append("\n"); 
		query.append("        FROM MDM_VSL_CNTR T1, FCM_VSL_CNTR_RGST T2" ).append("\n"); 
		query.append("        WHERE T1.VSL_CD=T2.VSL_CD" ).append("\n"); 
		query.append("        AND T1.DELT_FLG='N'" ).append("\n"); 
		query.append("        AND T1.CRR_CD='SML'" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    AND T1.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	VSL_CD" ).append("\n"); 
		query.append("    ,SKD_VOY_NO" ).append("\n"); 
		query.append("    ,SKD_DIR_CD" ).append("\n"); 
		query.append("    ,VPS_PORT_CD" ).append("\n"); 
		query.append("    ,DECODE(CLPT_IND_SEQ, '1', 'F', '2', 'S', '3', 'T') AS CLPT_IND_SEQ" ).append("\n"); 
		query.append("	,LAST_VSL_CD" ).append("\n"); 
		query.append("	,LAST_SKD_VOY_NO" ).append("\n"); 
		query.append("	,LAST_SKD_DIR_CD" ).append("\n"); 
		query.append("    ,LAST_PORT_CD" ).append("\n"); 
		query.append("    ,DECODE(LAST_CLPT_IND_SEQ, '1', 'F', '2', 'S', '3', 'T') AS LAST_CLPT_IND_SEQ" ).append("\n"); 
		query.append("FROM VSL_SKD_TMP" ).append("\n"); 
		query.append("WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[voy_dir_cd], 1, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[voy_dir_cd], 5, 1)" ).append("\n"); 
		query.append("AND VPS_PORT_CD = @[dep_port_cd]" ).append("\n"); 
		query.append("#if( ${clpt_ind_seq} != '' )" ).append("\n"); 
		query.append("AND CLPT_IND_SEQ = DECODE(@[clpt_ind_seq], 'F', '1', 'S', '2', 'T', '3')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}