/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PsoAdvanceAuditDBDAOSearchVslClassRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.psoadvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PsoAdvanceAuditDBDAOSearchVslClassRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PsoAdvanceAuditDBDAOSearchVslClass 
	  * </pre>
	  */
	public PsoAdvanceAuditDBDAOSearchVslClassRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("contractType",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.psoadvanceaudit.integration").append("\n"); 
		query.append("FileName : PsoAdvanceAuditDBDAOSearchVslClassRSQL").append("\n"); 
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
		query.append("SELECT  CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if ( ${contractType} != '' && ${contractType} != 'ALL')" ).append("\n"); 
		query.append("	AND VSL_CD IN (SELECT VSL_CD FROM FMS_CONTRACT WHERE FLET_CTRT_TP_CD = @[contractType]) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${contractType} == '' ) " ).append("\n"); 
		query.append("	AND VSL_CD IN (SELECT VSL_CD FROM FMS_CONTRACT WHERE FLET_CTRT_TP_CD IN ('TI','T0', 'OW'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND   CNTR_VSL_CLSS_CAPA IS NOT NULL" ).append("\n"); 
		query.append("GROUP BY CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("ORDER BY CNTR_VSL_CLSS_CAPA" ).append("\n"); 

	}
}