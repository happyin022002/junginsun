/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JOOFindCodeAndCheckDBDAORLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.14
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.01.14 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOOFindCodeAndCheckDBDAORLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LaneCode조회
	  * </pre>
	  */
	public JOOFindCodeAndCheckDBDAORLaneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("super_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("super_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.integration").append("\n"); 
		query.append("FileName : JOOFindCodeAndCheckDBDAORLaneRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	   RLANE_CD AS CODE," ).append("\n"); 
		query.append("	   RLANE_NM AS NAME," ).append("\n"); 
		query.append("       CASE WHEN (SELECT 'R' FROM JOO_CARRIER A WHERE A.JO_CRR_CD = @[super_cd2] AND A.RLANE_CD = X.RLANE_CD AND A.DELT_FLG = 'N') IS NULL" ).append("\n"); 
		query.append("            THEN 'W'" ).append("\n"); 
		query.append("            ELSE NVL((SELECT JO_CRR_AUTH_CD FROM JOO_CRR_AUTH A WHERE A.JO_CRR_CD = @[super_cd2] AND A.RLANE_CD = X.RLANE_CD AND A.AUTH_OFC_CD = @[ofc_cd] AND A.DELT_FLG = 'N'),'R')" ).append("\n"); 
		query.append("       END  AS AUTH_CD	   " ).append("\n"); 
		query.append("FROM   MDM_REV_LANE X" ).append("\n"); 
		query.append("WHERE  X.VSL_TP_CD = 'C'" ).append("\n"); 
		query.append("AND	   X.DELT_FLG  = 'N'" ).append("\n"); 
		query.append("#if (${super_cd1} != '')" ).append("\n"); 
		query.append("AND	   X.REP_TRD_CD = @[super_cd1]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${code} != '')" ).append("\n"); 
		query.append("AND    X.RLANE_CD = @[code]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 

	}
}