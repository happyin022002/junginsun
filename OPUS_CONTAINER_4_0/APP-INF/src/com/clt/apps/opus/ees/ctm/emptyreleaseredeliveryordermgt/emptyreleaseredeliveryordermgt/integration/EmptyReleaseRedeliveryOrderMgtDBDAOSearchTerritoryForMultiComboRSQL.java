/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EmptyReleaseRedeliveryOrderMgtDBDAOSearchTerritoryForMultiComboRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.25
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2011.02.25 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.clt.framework.core.layer.integration.DAO;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyReleaseRedeliveryOrderMgtDBDAOSearchTerritoryForMultiComboRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public EmptyReleaseRedeliveryOrderMgtDBDAOSearchTerritoryForMultiComboRSQL(){
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
		query.append("Path : com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration").append("\n"); 
		query.append("FileName : EmptyReleaseRedeliveryOrderMgtDBDAOSearchTerritoryForMultiComboRSQL").append("\n"); 
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
		query.append("SELECT   CASE CNTR_STK_TERR_CD" ).append("\n"); 
		query.append("            WHEN 'CEU'" ).append("\n"); 
		query.append("               THEN 'Central Europe (CEU)'" ).append("\n"); 
		query.append("            WHEN 'EEU'" ).append("\n"); 
		query.append("               THEN 'Eastern Europe (EEU)'" ).append("\n"); 
		query.append("            WHEN 'MED'" ).append("\n"); 
		query.append("               THEN 'Mediterranean Europe (MED)'" ).append("\n"); 
		query.append("            WHEN 'NEU'" ).append("\n"); 
		query.append("               THEN 'Northern Europe (NEU)'" ).append("\n"); 
		query.append("            WHEN 'SCA'" ).append("\n"); 
		query.append("               THEN 'Scandinavian (SCA)'" ).append("\n"); 
		query.append("            WHEN 'SEU'" ).append("\n"); 
		query.append("               THEN 'Southern Europe (SEU)'" ).append("\n"); 
		query.append("            WHEN 'WEU'" ).append("\n"); 
		query.append("               THEN 'Western Europe (WEU)'" ).append("\n"); 
		query.append("            WHEN 'NAF'" ).append("\n"); 
		query.append("               THEN 'Northern Africa (NAF)'" ).append("\n"); 
		query.append("            WHEN 'SAF'" ).append("\n"); 
		query.append("               THEN 'Southern Africa (SAF)'" ).append("\n"); 
		query.append("            WHEN 'EAF'" ).append("\n"); 
		query.append("               THEN 'Eastern Africa (EAF)'" ).append("\n"); 
		query.append("            WHEN 'WAF'" ).append("\n"); 
		query.append("               THEN 'Western Africa (WAF)'" ).append("\n"); 
		query.append("         END||'|'||OFC_CD AS CNTR_STK_TERR_TXT," ).append("\n"); 
		query.append("         CNTR_STK_TERR_CD" ).append("\n"); 
		query.append("    FROM CIM_TERRITORY" ).append("\n"); 
		query.append("   WHERE CO_CD IN ('A', 'H')" ).append("\n"); 
		query.append("     AND OFC_CD = DECODE (@[ofc_cd], (SELECT OFC_CD FROM TABLE (COM_OFFICECODEMGR_PKG.COM_GETOFFICECODELIST_FNC ('000001', 'CTM'))), OFC_CD, @[ofc_cd])" ).append("\n"); 
		query.append("GROUP BY CNTR_STK_TERR_CD," ).append("\n"); 
		query.append("         OFC_CD" ).append("\n"); 
		query.append("ORDER BY CNTR_STK_TERR_CD," ).append("\n"); 
		query.append("         OFC_CD" ).append("\n"); 

	}
}