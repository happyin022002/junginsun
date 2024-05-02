/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : JOOFindCodeAndCheckDBDAOTgtCrrCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.20
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2016.07.20 박정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Min Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOOFindCodeAndCheckDBDAOTgtCrrCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Settlement Target에서 Carrier Code를 조회한다.
	  * </pre>
	  */
	public JOOFindCodeAndCheckDBDAOTgtCrrCodeRSQL(){
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
		params.put("lane_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.integration").append("\n"); 
		query.append("FileName : JOOFindCodeAndCheckDBDAOTgtCrrCodeRSQL").append("\n"); 
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
		query.append("WITH OUS_TGT AS (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("         J.TRD_CD" ).append("\n"); 
		query.append("        ,J.RLANE_CD" ).append("\n"); 
		query.append("        ,J.VSL_CD" ).append("\n"); 
		query.append("        ,J.SKD_VOY_NO" ).append("\n"); 
		query.append("        ,J.SKD_DIR_CD" ).append("\n"); 
		query.append("    FROM  (" ).append("\n"); 
		query.append("			SELECT * FROM JOO_LODG_TGT J" ).append("\n"); 
		query.append("			WHERE 1=1" ).append("\n"); 
		query.append("			AND J.STL_TGT_FLG = '1'" ).append("\n"); 
		query.append("			AND J.STL_CLZ_FLG = '0'" ).append("\n"); 
		query.append("            AND J.REV_YRMON BETWEEN REPLACE(@[super_cd1],'-','') AND REPLACE(@[super_cd2],'-','')" ).append("\n"); 
		query.append("            AND J.RE_DIVR_CD = 'E'" ).append("\n"); 
		query.append("            AND J.TRD_CD    = @[code]" ).append("\n"); 
		query.append("            AND J.RLANE_CD  = @[lane_cd]" ).append("\n"); 
		query.append("		  ) J" ).append("\n"); 
		query.append("), OUS_TGT_CRR AS (" ).append("\n"); 
		query.append("    SELECT A4.CRR_CD" ).append("\n"); 
		query.append("    FROM OUS_TGT O, BSA_VVD_CRR_PERF A4" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND O.TRD_CD = A4.TRD_CD(+)" ).append("\n"); 
		query.append("    AND O.RLANE_CD = A4.RLANE_CD(+)" ).append("\n"); 
		query.append("    AND O.VSL_CD = A4.VSL_CD(+)" ).append("\n"); 
		query.append("    AND O.SKD_VOY_NO = A4.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("    AND O.SKD_DIR_CD = A4.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("    AND A4.BSA_OP_JB_CD IN ('000','003','005')  " ).append("\n"); 
		query.append("), OUS_TGT_MST AS (" ).append("\n"); 
		query.append("    SELECT A4.CRR_CD" ).append("\n"); 
		query.append("    FROM OUS_TGT O, BSA_VVD_MST A4" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND O.TRD_CD = A4.TRD_CD(+)" ).append("\n"); 
		query.append("    AND O.RLANE_CD = A4.RLANE_CD(+)" ).append("\n"); 
		query.append("    AND O.VSL_CD = A4.VSL_CD(+)" ).append("\n"); 
		query.append("    AND O.SKD_VOY_NO = A4.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("    AND O.SKD_DIR_CD = A4.SKD_DIR_CD(+)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	    '' AS CODE" ).append("\n"); 
		query.append("	   ,'' AS NAME" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("	    CRR_CD AS CODE" ).append("\n"); 
		query.append("	   ,CRR_CD AS NAME" ).append("\n"); 
		query.append("FROM OUS_TGT_CRR" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("	    CRR_CD AS CODE" ).append("\n"); 
		query.append("	   ,CRR_CD AS NAME" ).append("\n"); 
		query.append("FROM OUS_TGT_MST" ).append("\n"); 
		query.append("ORDER BY CODE NULLS FIRST" ).append("\n"); 

	}
}