/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CgmCodeMgtDBDAOSearchHasAcceptAuthDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CgmCodeMgtDBDAOSearchHasAcceptAuthDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	  * 2014-04-07 by Jonghee HAN CSR Ticket : CHM-201429628, Title : Pricing-S/C Creation and Amendation 시, Amend Button 활성화 요청, 
	  *                   S/C Exception 최초 생성시 Logic 및 Accept Cancel Check SQL 변경
	  * 2015 조직코드개편 Chang-Young Kim 
	  * ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	  * </pre>
	  */
	public CgmCodeMgtDBDAOSearchHasAcceptAuthDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.integration").append("\n"); 
		query.append("FileName : CgmCodeMgtDBDAOSearchHasAcceptAuthDataRSQL").append("\n"); 
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
		query.append("SELECT	COUNT(PROP_NO)" ).append("\n"); 
		query.append("FROM  (" ).append("\n"); 
		query.append("		SELECT	PROP_NO" ).append("\n"); 
		query.append("		FROM	PRI_SP_SCP_MN" ).append("\n"); 
		query.append("		WHERE	1=1" ).append("\n"); 
		query.append("#if(${prop_no} == '')" ).append("\n"); 
		query.append("		AND PROP_NO = (SELECT DISTINCT PROP_NO" ).append("\n"); 
		query.append("						 FROM PRI_SP_HDR" ).append("\n"); 
		query.append("						WHERE SC_NO = @[sc_no])" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		AND PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		AND PROP_SCP_APRO_OFC_CD = DECODE(@[ofc_cd], 'SHARCS', 'SHARC', " ).append("\n"); 
		query.append("                                                     'NYCRAS', 'NYCRA', 'NYCRAC','NYCRA'," ).append("\n"); 
		query.append("                                                     'HAMRUS', 'HAMRU', 'HAMRUC','HAMRU'," ).append("\n"); 
		query.append("                                                     'SINRSC', 'SINRS', @[ofc_cd])" ).append("\n"); 
		query.append("        AND PROP_SCP_STS_CD <> 'A'" ).append("\n"); 
		query.append("		UNION" ).append("\n"); 
		query.append("		SELECT	PROP_NO" ).append("\n"); 
		query.append("		FROM	PRI_SP_MN" ).append("\n"); 
		query.append("		WHERE	1=1" ).append("\n"); 
		query.append("#if(${prop_no} == '')" ).append("\n"); 
		query.append("		AND PROP_NO = (SELECT DISTINCT PROP_NO" ).append("\n"); 
		query.append("						 FROM PRI_SP_HDR" ).append("\n"); 
		query.append("						WHERE SC_NO = @[sc_no])" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		AND PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		AND	PROP_APRO_OFC_CD = DECODE(@[ofc_cd], 'SHARCS', 'SHARC', " ).append("\n"); 
		query.append("                                                 'NYCRAS', 'NYCRA', 'NYCRAC','NYCRA'," ).append("\n"); 
		query.append("                                                 'HAMRUS', 'HAMRU', 'HAMRUC','HAMRU'," ).append("\n"); 
		query.append("                                                 'SINRSC', 'SINRS', @[ofc_cd])" ).append("\n"); 
		query.append("        AND PROP_STS_CD NOT IN ('F', 'A')" ).append("\n"); 
		query.append("		)" ).append("\n"); 

	}
}