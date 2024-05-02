/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOGetVslCdForGateNewRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.11
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2010.05.11 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOGetVslCdForGateNewRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOGetVslCdForGateNewRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lloyd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_sgn_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOGetVslCdForGateNewRSQL").append("\n"); 
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
		query.append("SELECT VSL_CD" ).append("\n"); 
		query.append("FROM (SELECT V1.VSL_CD" ).append("\n"); 
		query.append("FROM MDM_VSL_CNTR V1" ).append("\n"); 
		query.append("#if (${lloyd_no} != '')" ).append("\n"); 
		query.append(", (SELECT DISTINCT V.VSL_CD" ).append("\n"); 
		query.append("FROM MDM_VSL_CNTR V," ).append("\n"); 
		query.append("VSK_VSL_SKD VS" ).append("\n"); 
		query.append("WHERE V.LLOYD_NO IS NOT NULL" ).append("\n"); 
		query.append("AND V.LLOYD_NO = TRIM (@[lloyd_no])" ).append("\n"); 
		query.append("AND V.VSL_CD = VS.VSL_CD" ).append("\n"); 
		query.append("AND NVL (V.DELT_FLG, ' ') <> 'Y'" ).append("\n"); 
		query.append("AND VS.SKD_STS_CD = 'ACT'" ).append("\n"); 
		query.append("AND VS.N1ST_PORT_BRTH_DT >= SYSDATE - 120" ).append("\n"); 
		query.append("AND VS.N1ST_PORT_BRTH_DT < SYSDATE) V2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${call_sgn_no} != '')" ).append("\n"); 
		query.append("AND V1.CALL_SGN_NO = TRIM (@[call_sgn_no])" ).append("\n"); 
		query.append("AND NVL (V1.DELT_FLG, '') <> 'Y'" ).append("\n"); 
		query.append("#elseif (${lloyd_no} != '')" ).append("\n"); 
		query.append("AND V1.VSL_CD = V2.VSL_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY V1.CRE_DT DESC)" ).append("\n"); 
		query.append("WHERE ROWNUM <= 3" ).append("\n"); 

	}
}