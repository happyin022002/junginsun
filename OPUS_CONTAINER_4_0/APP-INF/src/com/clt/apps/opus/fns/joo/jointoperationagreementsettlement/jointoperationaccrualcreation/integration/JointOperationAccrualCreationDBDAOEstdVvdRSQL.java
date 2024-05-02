/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JointOperationAccrualCreationDBDAOEstdVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationAccrualCreationDBDAOEstdVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public JointOperationAccrualCreationDBDAOEstdVvdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration").append("\n"); 
		query.append("FileName : JointOperationAccrualCreationDBDAOEstdVvdRSQL").append("\n"); 
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
		query.append("SELECT RLANE_CD" ).append("\n"); 
		query.append("     , VVDCODE" ).append("\n"); 
		query.append("  FROM (SELECT RLANE_CD" ).append("\n"); 
		query.append("             , VVDCODE" ).append("\n"); 
		query.append("          FROM (SELECT DISTINCT G.RLANE_CD" ).append("\n"); 
		query.append("                     , G.VSL_CD||G.SKD_VOY_NO||G.SKD_DIR_CD||G.REV_DIR_CD AS VVDCODE" ).append("\n"); 
		query.append("                  FROM GL_ESTM_REV_VVD G" ).append("\n"); 
		query.append("                     , (SELECT DISTINCT A.RLANE_CD" ).append("\n"); 
		query.append("                             , A.VSL_CD||A.SKD_VOY_NO||A.DIR_CD AS VVDCODE" ).append("\n"); 
		query.append("                          FROM COA_MON_VVD A" ).append("\n"); 
		query.append("                             , BSA_VVD_MST B" ).append("\n"); 
		query.append("                             , (SELECT MIN(REV_YRMON) AS MIN_REV_YRMON" ).append("\n"); 
		query.append("                                     , MAX(REV_YRMON) AS MAX_REV_YRMON" ).append("\n"); 
		query.append("                                  FROM JOO_ESTM_ACT_RSLT J" ).append("\n"); 
		query.append("                                 WHERE J.EXE_YRMON = REPLACE( @[exe_yrmon],'-','') ) M" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("                           AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND A.DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND A.TRD_CD = B.TRD_CD" ).append("\n"); 
		query.append("                           AND A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("                           AND A.COST_YRMON BETWEEN M.MIN_REV_YRMON AND M.MAX_REV_YRMON " ).append("\n"); 
		query.append("                       ) J" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   --AND G.EXE_YRMON = REPLACE([exe_yrmon],'-','')" ).append("\n"); 
		query.append("                   AND G.ESTM_BC_DIV_CD = 'C'" ).append("\n"); 
		query.append("                   AND G.RLANE_CD = J.RLANE_CD" ).append("\n"); 
		query.append("                   AND G.VSL_CD||G.SKD_VOY_NO||G.SKD_DIR_CD = J.VVDCODE " ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("         MINUS" ).append("\n"); 
		query.append("        SELECT DISTINCT J.RLANE_CD" ).append("\n"); 
		query.append("             , J.VSL_CD||J.SKD_VOY_NO||J.SKD_DIR_CD||J.REV_DIR_CD" ).append("\n"); 
		query.append("          FROM JOO_ESTM_ACT_RSLT J" ).append("\n"); 
		query.append("         WHERE EXE_YRMON = REPLACE( @[exe_yrmon], '-' , '')" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" ORDER BY 1, 2" ).append("\n"); 

	}
}