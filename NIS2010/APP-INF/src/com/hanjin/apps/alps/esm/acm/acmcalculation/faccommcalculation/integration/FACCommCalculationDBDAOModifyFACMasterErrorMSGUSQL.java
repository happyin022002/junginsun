/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FACCommCalculationDBDAOModifyFACMasterErrorMSGUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.20
*@LastModifier : 
*@LastVersion : 1.0
* 2012.07.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FACCommCalculationDBDAOModifyFACMasterErrorMSGUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FACCommCalculationDBDAOModifyFACMasterErrorMSGUSQL
	  * </pre>
	  */
	public FACCommCalculationDBDAOModifyFACMasterErrorMSGUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_proc_rslt_rsn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.integration").append("\n"); 
		query.append("FileName : FACCommCalculationDBDAOModifyFACMasterErrorMSGUSQL").append("\n"); 
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
		query.append("MERGE" ).append("\n"); 
		query.append(" INTO ACM_AGN_BKG_INFO INF" ).append("\n"); 
		query.append("USING" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("          SELECT" ).append("\n"); 
		query.append("                 @[bkg_no]             AS BKG_NO," ).append("\n"); 
		query.append("                 @[comm_proc_rslt_rsn] AS COMM_PROC_RSLT_RSN," ).append("\n"); 
		query.append("                 'ACM System' AS CRE_USR_ID," ).append("\n"); 
		query.append("                 SYSDATE      AS DT" ).append("\n"); 
		query.append("            FROM DUAL" ).append("\n"); 
		query.append("     ) MSG" ).append("\n"); 
		query.append("    ON" ).append("\n"); 
		query.append("     (" ).append("\n"); 
		query.append("       INF.BKG_NO = MSG.BKG_NO" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append(" WHEN MATCHED" ).append("\n"); 
		query.append(" THEN" ).append("\n"); 
		query.append("          UPDATE" ).append("\n"); 
		query.append("             SET INF.COMM_PROC_RSLT_RSN = MSG.COMM_PROC_RSLT_RSN," ).append("\n"); 
		query.append("                 INF.UPD_DT             = MSG.DT," ).append("\n"); 
		query.append("				 INF.UPD_USR_ID         = MSG.CRE_USR_ID" ).append("\n"); 
		query.append(" WHEN NOT MATCHED" ).append("\n"); 
		query.append(" THEN" ).append("\n"); 
		query.append("          INSERT" ).append("\n"); 
		query.append("               (" ).append("\n"); 
		query.append("                 INF.BKG_NO," ).append("\n"); 
		query.append("                 INF.COMM_PROC_RSLT_RSN," ).append("\n"); 
		query.append("                 INF.UPD_USR_ID," ).append("\n"); 
		query.append("                 INF.UPD_DT," ).append("\n"); 
		query.append("                 INF.CRE_USR_ID," ).append("\n"); 
		query.append("                 INF.CRE_DT" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("	             VALUES" ).append("\n"); 
		query.append("               (" ).append("\n"); 
		query.append("                 MSG.BKG_NO," ).append("\n"); 
		query.append("                 MSG.COMM_PROC_RSLT_RSN," ).append("\n"); 
		query.append("                 MSG.CRE_USR_ID," ).append("\n"); 
		query.append("                 MSG.DT," ).append("\n"); 
		query.append("                 MSG.CRE_USR_ID," ).append("\n"); 
		query.append("                 MSG.DT" ).append("\n"); 
		query.append("               )" ).append("\n"); 

	}
}