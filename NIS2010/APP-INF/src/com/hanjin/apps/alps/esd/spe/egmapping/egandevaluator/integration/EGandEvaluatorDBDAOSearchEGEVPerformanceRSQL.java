/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EGandEvaluatorDBDAOSearchEGEVPerformanceRSQL.java
*@FileTitle : Evaluator Inquiry Choice
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.04
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.03.04 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.egmapping.egandevaluator.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EGandEvaluatorDBDAOSearchEGEVPerformanceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Performance Evaluator 를 조회한다.
	  * </pre>
	  */
	public EGandEvaluatorDBDAOSearchEGEVPerformanceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eg_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.egmapping.egandevaluator.integration").append("\n"); 
		query.append("FileName : EGandEvaluatorDBDAOSearchEGEVPerformanceRSQL").append("\n"); 
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
		query.append("SELECT A.EG_ID" ).append("\n"); 
		query.append("     , A.EG_NM" ).append("\n"); 
		query.append("     , PER_EVR_USR_ID" ).append("\n"); 
		query.append("     , PER_EVR_USR_NM" ).append("\n"); 
		query.append("     , EV_KND_SEQ" ).append("\n"); 
		query.append("     , NVL(EV_KND_CD,'P') AS EV_KND_CD" ).append("\n"); 
		query.append("     , A.EG_RHQ_CD" ).append("\n"); 
		query.append("     , A.EG_OFC_CD" ).append("\n"); 
		query.append("  FROM SPE_EV_GRP A" ).append("\n"); 
		query.append("     , (SELECT EG_ID,PER_EVR_USR_ID,PER_EVR_USR_NM,EV_KND_SEQ, EV_KND_CD" ).append("\n"); 
		query.append("          FROM (SELECT EG_ID" ).append("\n"); 
		query.append("                     , EVR_USR_ID AS PER_EVR_USR_ID" ).append("\n"); 
		query.append("                     , USR_NM AS  PER_EVR_USR_NM" ).append("\n"); 
		query.append("                     , EV_KND_SEQ" ).append("\n"); 
		query.append("                     , EV_KND_CD " ).append("\n"); 
		query.append("                  FROM SPE_EV_GRP_EVR A" ).append("\n"); 
		query.append("                     , COM_USER B" ).append("\n"); 
		query.append("                 WHERE EV_KND_CD = 'P'" ).append("\n"); 
		query.append("                   AND A.EVR_USR_ID = B.USR_ID" ).append("\n"); 
		query.append("                   AND B.USE_FLG = 'Y'                   " ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("        ) B" ).append("\n"); 
		query.append(" WHERE A.EG_ID = B.EG_ID(+)" ).append("\n"); 
		query.append("   AND A.DELT_FLG = 'N' " ).append("\n"); 
		query.append("   AND A.EG_ID = @[eg_id]" ).append("\n"); 
		query.append("ORDER BY A.EG_ID DESC, PER_EVR_USR_ID" ).append("\n"); 

	}
}