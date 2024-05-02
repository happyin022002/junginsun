/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ConstraintManageDBDAOSearchRouteConstraintRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.07
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2012.03.07 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Mangeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintManageDBDAOSearchRouteConstraintRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchRouteConstraint
	  * </pre>
	  */
	public ConstraintManageDBDAOSearchRouteConstraintRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cmdt_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tsport",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tlane",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.integration").append("\n"); 
		query.append("FileName : ConstraintManageDBDAOSearchRouteConstraintRSQL").append("\n"); 
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
		query.append("SELECT DELT_FLG, TRNK_LANE_CD, DIR_CD, POL_CD, POL_NOD_CD, ROUT_CNST_SEQ, N1ST_LANE_CD, N1ST_TS_PORT_CD," ).append("\n"); 
		query.append("       N2ND_LANE_CD, N2ND_TS_PORT_CD, N3RD_LANE_CD, POD_CD, POD_NOD_CD, DEL_CD, DEL_NOD_CD, SVC_USE_FLG," ).append("\n"); 
		query.append("       ROUT_CNST_RMK, CRE_DT, CRE_OFC_CD, CRE_USR_ID, UPD_DT, UPD_OFC_CD, UPD_USR_ID," ).append("\n"); 
		query.append("       CNTR_TP_CD, CMDT_CD, CMDT_NM, VVD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("      SELECT DELT_FLG, TRNK_LANE_CD,DIR_CD," ).append("\n"); 
		query.append("              SUBSTR(POL_NOD_CD, 1, 5) POL_CD, SUBSTR(POL_NOD_CD, 6) POL_NOD_CD, ROUT_CNST_SEQ, N1ST_LANE_CD, N1ST_TS_PORT_CD, N2ND_LANE_CD, N2ND_TS_PORT_CD, N3RD_LANE_CD," ).append("\n"); 
		query.append("              SUBSTR(POD_NOD_CD, 1, 5) POD_CD, SUBSTR(POD_NOD_CD, 6) POD_NOD_CD, SUBSTR(DEL_NOD_CD, 1, 5) DEL_CD, SUBSTR(DEL_NOD_CD,6) DEL_NOD_CD, SVC_USE_FLG, ROUT_CNST_RMK, TO_CHAR(CRE_DT, 'YYYY-MM-DD') CRE_DT, CRE_OFC_CD, CRE_USR_ID, " ).append("\n"); 
		query.append("              TO_CHAR(UPD_DT, 'YYYY-MM-DD') UPD_DT, UPD_OFC_CD, UPD_USR_ID," ).append("\n"); 
		query.append("              CNTR_TP_CD, CMDT_CD, (SELECT CMDT_NM FROM MDM_COMMODITY M WHERE M.CMDT_CD  = P.CMDT_CD) CMDT_NM," ).append("\n"); 
		query.append("              VSL_CD || SKD_VOY_NO || SKD_DIR_CD VVD" ).append("\n"); 
		query.append("          FROM PRD_ROUT_CNST P" ).append("\n"); 
		query.append("          WHERE DECODE(TRNK_LANE_CD,'ALL',@[tlane]||'%',TRNK_LANE_CD) LIKE @[tlane] ||'%' " ).append("\n"); 
		query.append("          AND POL_NOD_CD LIKE @[pol]||'%' " ).append("\n"); 
		query.append("          AND (NVL(N1ST_TS_PORT_CD, '#') LIKE @[tsport] ||'%' OR NVL(N2ND_TS_PORT_CD, '#') LIKE @[tsport] ||'%') " ).append("\n"); 
		query.append("          AND POD_NOD_CD LIKE @[pod] ||'%' " ).append("\n"); 
		query.append("          AND NVL(DEL_NOD_CD, '#') LIKE @[del] ||'%' " ).append("\n"); 
		query.append("          AND NVL(DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("          AND NVL(DIR_CD, '#') like @[dir_cd] ||'%'  --세트" ).append("\n"); 
		query.append("          AND SVC_USE_FLG = DECODE(@[svc], 'A', SVC_USE_FLG, NULL, SVC_USE_FLG, @[svc] )" ).append("\n"); 
		query.append("          AND NVL(CMDT_CD, 'X') = NVL(TRIM(@[cmdt_cd]), NVL(CMDT_CD, 'X')) " ).append("\n"); 
		query.append("          AND (   NVL(N1ST_LANE_CD, '#') = NVL(TRIM(@[vsl_slan_cd]), NVL(N1ST_LANE_CD,'#'))" ).append("\n"); 
		query.append("               OR NVL(N2ND_LANE_CD, '#') = NVL(TRIM(@[vsl_slan_cd]), NVL(N2ND_LANE_CD,'#'))" ).append("\n"); 
		query.append("               OR NVL(N3RD_LANE_CD, '#') = NVL(TRIM(@[vsl_slan_cd]), NVL(N3RD_LANE_CD,'#'))" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("--          AND NVL(VSL_CD || SKD_VOY_NO || SKD_DIR_CD, '#') = NVL(TRIM(:vvd), NVL(VSL_CD || SKD_VOY_NO || SKD_DIR_CD,'#'))" ).append("\n"); 
		query.append("          AND NVL(VSL_CD || SKD_VOY_NO || SKD_DIR_CD, '#') LIKE NVL(TRIM(@[vvd]), NVL(VSL_CD || SKD_VOY_NO || SKD_DIR_CD,'%'))" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE NVL(UPPER(CMDT_NM), '#') LIKE DECODE(TRIM(@[cmdt_nm]), NULL, '%', '%' || UPPER(TRIM(@[cmdt_nm])) || '%')" ).append("\n"); 

	}
}