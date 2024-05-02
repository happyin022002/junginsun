/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ConstraintManageDBDAOSearchRouteConstraintRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
		params.put("por",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.integration").append("\n"); 
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
		query.append("SELECT DELT_FLG" ).append("\n"); 
		query.append("      ,TRNK_LANE_CD" ).append("\n"); 
		query.append("      ,DIR_CD" ).append("\n"); 
		query.append("      ,SUBSTR(POR_NOD_CD, 1, 5) POR_CD" ).append("\n"); 
		query.append("      ,SUBSTR(POR_NOD_CD, 6) POR_NODE" ).append("\n"); 
		query.append("      ,SUBSTR(POL_NOD_CD, 1, 5) POL_CD" ).append("\n"); 
		query.append("      ,SUBSTR(POL_NOD_CD, 6) POL_NOD" ).append("\n"); 
		query.append("      ,ROUT_CNST_SEQ" ).append("\n"); 
		query.append("      ,N1ST_LANE_CD" ).append("\n"); 
		query.append("      ,N1ST_TS_PORT_CD" ).append("\n"); 
		query.append("      ,N2ND_LANE_CD" ).append("\n"); 
		query.append("      ,N2ND_TS_PORT_CD" ).append("\n"); 
		query.append("      ,N3RD_LANE_CD" ).append("\n"); 
		query.append("      ,SUBSTR(POD_NOD_CD, 1, 5) POD_CD" ).append("\n"); 
		query.append("      ,SUBSTR(POD_NOD_CD, 6) POD_NOD" ).append("\n"); 
		query.append("      ,SUBSTR(DEL_NOD_CD, 1, 5) DEL_CD" ).append("\n"); 
		query.append("      ,SUBSTR(DEL_NOD_CD, 6) DEL_NODE" ).append("\n"); 
		query.append("      ,SVC_USE_FLG" ).append("\n"); 
		query.append("      ,ROUT_CNST_RMK" ).append("\n"); 
		query.append("      ,TO_CHAR(CRE_DT, 'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append("      ,CRE_OFC_CD" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,TO_CHAR(UPD_DT, 'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("      ,UPD_OFC_CD" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,SPCL_CGO_CNTR_TP_CD" ).append("\n"); 
		query.append("      ,CNTR_TP_CD" ).append("\n"); 
		query.append("      ,CNTR_SZ_CD" ).append("\n"); 
		query.append("  FROM PRD_ROUT_CNST" ).append("\n"); 
		query.append(" WHERE DECODE(TRNK_LANE_CD, 'ALL', @[tlane] || '%', TRNK_LANE_CD) LIKE @[tlane] || '%'" ).append("\n"); 
		query.append("   AND NVL(POR_NOD_CD, ' ') LIKE @[por] || '%'" ).append("\n"); 
		query.append("   AND POL_NOD_CD LIKE @[pol] || '%'" ).append("\n"); 
		query.append("   AND (NVL(N1ST_TS_PORT_CD, ' ') LIKE @[tsport] || '%' OR NVL(N2ND_TS_PORT_CD, ' ') LIKE @[tsport] || '%')" ).append("\n"); 
		query.append("   AND POD_NOD_CD LIKE @[pod] || '%'" ).append("\n"); 
		query.append("   AND NVL(DEL_NOD_CD, ' ') LIKE @[del] || '%'" ).append("\n"); 
		query.append("   AND NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("   AND NVL(dir_cd, 'X') like @[dir_cd] || '%'" ).append("\n"); 
		query.append("   AND SVC_USE_FLG = DECODE(@[svc], 'A', SVC_USE_FLG, @[svc])" ).append("\n"); 

	}
}