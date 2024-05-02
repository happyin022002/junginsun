/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExternalFinderDBDAOSearchCheckAcctCdVvdLevelRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.09.21 정윤태
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.fmscommon.externalfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JUNGYOONTAE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExternalFinderDBDAOSearchCheckAcctCdVvdLevelRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ExternalFinderDBDAOSearchCheckAcctCdVvdLevelRSQL
	  * </pre>
	  */
	public ExternalFinderDBDAOSearchCheckAcctCdVvdLevelRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.fmscommon.externalfinder.integration").append("\n"); 
		query.append("FileName : ExternalFinderDBDAOSearchCheckAcctCdVvdLevelRSQL").append("\n"); 
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
		query.append("SELECT DECODE(SUM(COUNT(*)),0,NULL,SUM(COUNT(*))) VSL_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("VSL_CD" ).append("\n"); 
		query.append("FROM AR_MST_REV_VVD" ).append("\n"); 
		query.append("WHERE VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("AND RLANE_DIR_CD = SUBSTR(@[vvd_cd],10,1)" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT DISTINCT 'OK'" ).append("\n"); 
		query.append("FROM AR_MST_REV_VVD A" ).append("\n"); 
		query.append("WHERE A.VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("AND EXISTS (SELECT 'Y'" ).append("\n"); 
		query.append("FROM MDM_ACCOUNT B" ).append("\n"); 
		query.append("WHERE B.ACCT_CD = @[acct_cd]" ).append("\n"); 
		query.append("AND A.VVD_COM_LVL IN (DECODE(B.VVD_LVL_FLG1, 'Y', '1', '')," ).append("\n"); 
		query.append("DECODE(B.VVD_LVL_FLG2, 'Y', '2', '')," ).append("\n"); 
		query.append("DECODE(B.VVD_LVL_FLG3, 'Y', '3', '')," ).append("\n"); 
		query.append("DECODE(B.VVD_LVL_FLG4, 'Y', '4', '')," ).append("\n"); 
		query.append("DECODE(B.VVD_LVL_FLG5, 'Y', '5', '')," ).append("\n"); 
		query.append("DECODE(B.VVD_LVL_FLG6, 'Y', '6', '')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") GROUP BY VSL_CD" ).append("\n"); 

	}
}