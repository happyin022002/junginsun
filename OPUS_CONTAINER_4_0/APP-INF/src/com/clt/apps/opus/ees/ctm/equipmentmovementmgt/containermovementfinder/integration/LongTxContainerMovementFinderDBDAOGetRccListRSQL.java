/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LongTxContainerMovementFinderDBDAOGetRccListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.09.03 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LongTxContainerMovementFinderDBDAOGetRccListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RCC LIST를 받아온다
	  * </pre>
	  */
	public LongTxContainerMovementFinderDBDAOGetRccListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.longtxcontainermovementfinder.integration").append("\n"); 
		query.append("FileName : LongTxContainerMovementFinderDBDAOGetRccListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT B.RCC_CD, DECODE (A.RCC_CD, NULL, '0', '1') CHECKED" ).append("\n"); 
		query.append("FROM (SELECT RCC_CD" ).append("\n"); 
		query.append("FROM MDM_LOCATION LOC," ).append("\n"); 
		query.append("MDM_EQ_ORZ_CHT EQ," ).append("\n"); 
		query.append("MDM_ORGANIZATION OFC" ).append("\n"); 
		query.append("WHERE LOC.SCC_CD = EQ.SCC_CD" ).append("\n"); 
		query.append("AND OFC.LOC_CD = LOC.LOC_CD" ).append("\n"); 
		query.append("AND OFC.OFC_CD = @[ofc_cd]) A," ).append("\n"); 
		query.append("(SELECT RCC_CD" ).append("\n"); 
		query.append("FROM MDM_LOCATION LOC," ).append("\n"); 
		query.append("MDM_EQ_ORZ_CHT EQ" ).append("\n"); 
		query.append("WHERE LOC.SCC_CD = EQ.SCC_CD) B" ).append("\n"); 
		query.append("WHERE B.RCC_CD = A.RCC_CD(+)" ).append("\n"); 

	}
}