/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SCExceptionTariffMgtDBDAOHasAcceptAuthRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.12
*@LastModifier : 김기태
*@LastVersion : 1.0
* 2015.08.12 김기태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kitae Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCExceptionTariffMgtDBDAOHasAcceptAuthRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/C Exception Tariff 를 Accept, Accept Cancel 할 수 있는 권한이 있는지를 조회하는 쿼리
	  * </pre>
	  */
	public SCExceptionTariffMgtDBDAOHasAcceptAuthRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : SCExceptionTariffMgtDBDAOHasAcceptAuthRSQL").append("\n"); 
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
		query.append("		WHERE	PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("		AND PROP_SCP_APRO_OFC_CD = DECODE(@[ofc_cd], 'SHARCS', 'SHARC', " ).append("\n"); 
		query.append("                                                     'NYCRAS', 'NYCRA', 'NYCRAC','NYCRA'," ).append("\n"); 
		query.append("                                                     'HAMRUS', 'HAMRU', 'HAMRUC','HAMRU'," ).append("\n"); 
		query.append("                                                     'SINRSC', 'SINRS', @[ofc_cd])" ).append("\n"); 
		query.append("		UNION" ).append("\n"); 
		query.append("		SELECT	PROP_NO" ).append("\n"); 
		query.append("		FROM	PRI_SP_MN" ).append("\n"); 
		query.append("		WHERE	PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("		AND	PROP_APRO_OFC_CD = DECODE(@[ofc_cd], 'SHARCS', 'SHARC', " ).append("\n"); 
		query.append("                                                 'NYCRAS', 'NYCRA', 'NYCRAC','NYCRA'," ).append("\n"); 
		query.append("                                                 'HAMRUS', 'HAMRU', 'HAMRUC','HAMRU'," ).append("\n"); 
		query.append("                                                 'SINRSC', 'SINRS', @[ofc_cd])" ).append("\n"); 
		query.append("		)" ).append("\n"); 

	}
}