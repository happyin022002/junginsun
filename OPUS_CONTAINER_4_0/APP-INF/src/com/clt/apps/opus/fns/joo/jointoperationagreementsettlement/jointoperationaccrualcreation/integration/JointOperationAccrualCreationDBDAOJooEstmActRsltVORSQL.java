/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JointOperationAccrualCreationDBDAOJooEstmActRsltVORSQL.java
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

public class JointOperationAccrualCreationDBDAOJooEstmActRsltVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public JointOperationAccrualCreationDBDAOJooEstmActRsltVORSQL(){
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
		query.append("FileName : JointOperationAccrualCreationDBDAOJooEstmActRsltVORSQL").append("\n"); 
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
		query.append("SELECT ITEM" ).append("\n"); 
		query.append("     , REV_YRMON" ).append("\n"); 
		query.append("     , RLANE_CD" ).append("\n"); 
		query.append("     , RVVD" ).append("\n"); 
		query.append("     , SUM(ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("     , SUM(ACT_AMT) ACT_AMT" ).append("\n"); 
		query.append("     , SUM(ACCL_AMT) ACCL_AMT" ).append("\n"); 
		query.append("  FROM (SELECT DECODE(SUBSTR(ACCT_CD,1,1),'4','REV','5','EXP') ITEM" ).append("\n"); 
		query.append("             , REV_YRMON" ).append("\n"); 
		query.append("             , RLANE_CD" ).append("\n"); 
		query.append("             , VSL_CD||SKD_VOY_NO||SKD_DIR_CD||REV_DIR_CD RVVD" ).append("\n"); 
		query.append("             , ESTM_AMT" ).append("\n"); 
		query.append("             , ACT_AMT" ).append("\n"); 
		query.append("             , ACCL_AMT" ).append("\n"); 
		query.append("          FROM JOO_ESTM_ACT_RSLT" ).append("\n"); 
		query.append("         WHERE EXE_YRMON = REPLACE( @[exe_yrmon],'-','') " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" GROUP BY ITEM" ).append("\n"); 
		query.append("     , REV_YRMON" ).append("\n"); 
		query.append("     , RLANE_CD" ).append("\n"); 
		query.append("     , RVVD" ).append("\n"); 
		query.append(" ORDER BY ITEM" ).append("\n"); 
		query.append("     , RLANE_CD" ).append("\n"); 
		query.append("     , RVVD" ).append("\n"); 

	}
}