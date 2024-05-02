/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PlanMgtDBDAOsearchSameRepairExpensePlanHeaderDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.29
*@LastModifier : 권영법
*@LastVersion : 1.0
* 2009.10.29 권영법
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 권영법
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PlanMgtDBDAOsearchSameRepairExpensePlanHeaderDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchSameRepairExpensePlanHeaderData select
	  * </pre>
	  */
	public PlanMgtDBDAOsearchSameRepairExpensePlanHeaderDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_pln_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_pln_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.integration").append("\n"); 
		query.append("FileName : PlanMgtDBDAOsearchSameRepairExpensePlanHeaderDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("A.MNR_PLN_YR" ).append("\n"); 
		query.append(",	A.MNR_PLN_OFC_CD" ).append("\n"); 
		query.append(",   A.MNR_PLN_SEQ" ).append("\n"); 
		query.append("FROM MNR_PLN_HDR A" ).append("\n"); 
		query.append("WHERE	A.MNR_GRP_TP_CD = 'RPR'" ).append("\n"); 
		query.append("AND A.MNR_PLN_YR = @[mnr_pln_yr]" ).append("\n"); 
		query.append("AND A.MNR_PLN_OFC_CD = @[mnr_pln_ofc_cd]" ).append("\n"); 

	}
}