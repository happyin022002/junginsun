/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AgentCanalTransitFeeBCDBDAOsearchCanalTzBkgVvdCountDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.18
*@LastModifier : 안준상
*@LastVersion : 1.0
* 2009.11.18 안준상
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jsahn
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgentCanalTransitFeeBCDBDAOsearchCanalTzBkgVvdCountDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCanalTzBkgVvdCountData
	  * </pre>
	  */
	public AgentCanalTransitFeeBCDBDAOsearchCanalTzBkgVvdCountDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("str_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.integration").append("\n"); 
		query.append("FileName : AgentCanalTransitFeeBCDBDAOsearchCanalTzBkgVvdCountDataRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) CNT" ).append("\n"); 
		query.append("FROM PSO_TGT_VVD T1," ).append("\n"); 
		query.append("VSK_VSL_SKD T3," ).append("\n"); 
		query.append("VSK_VSL_PORT_SKD T4," ).append("\n"); 
		query.append("MDM_VSL_SVC_LANE T5" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND T1.PSO_BZTP_CD      = 6  --5" ).append("\n"); 
		query.append("AND T1.VSL_CD           = T3.VSL_CD" ).append("\n"); 
		query.append("AND T1.SKD_VOY_NO       = T3.SKD_VOY_NO" ).append("\n"); 
		query.append("AND T1.SKD_DIR_CD       = T3.SKD_DIR_CD" ).append("\n"); 
		query.append("AND T3.VSL_CD           = T4.VSL_CD" ).append("\n"); 
		query.append("AND T3.SKD_VOY_NO       = T4.SKD_VOY_NO" ).append("\n"); 
		query.append("AND T3.SKD_DIR_CD       = T4.SKD_DIR_CD" ).append("\n"); 
		query.append("AND T3.VSL_SLAN_CD      = T5.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND T5.CNL_AGN_VNDR_SEQ = @[vndr_seq]  --'2132'" ).append("\n"); 
		query.append("AND T4.VPS_ETB_DT >= (TO_DATE(REPLACE(@[str_dt],'-',''),'YYYYMMDD')) AND T4.VPS_ETB_DT < TO_DATE(REPLACE(@[end_dt],'-',''),'YYYYMMDD')+1  --'20090501' '20090531'" ).append("\n"); 
		query.append("AND VPS_PORT_CD = 'PAPAC'" ).append("\n"); 

	}
}