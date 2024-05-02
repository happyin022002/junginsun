/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PlanMgtDBDAOsearchRepairExpensePlanMaxSequenceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PlanMgtDBDAOsearchRepairExpensePlanMaxSequenceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Header의 데이터로 MNR_PLN_DTL_SEQ 정보를 조회한다.
	  * </pre>
	  */
	public PlanMgtDBDAOsearchRepairExpensePlanMaxSequenceRSQL(){
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
		params.put("ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.integration").append("\n"); 
		query.append("FileName : PlanMgtDBDAOsearchRepairExpensePlanMaxSequenceRSQL").append("\n"); 
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
		query.append("SELECT NVL(MAX(MNR_PLN_DTL_SEQ),0) AS MNR_PLN_DTL_SEQ" ).append("\n"); 
		query.append("  FROM MNR_PLN_DTL" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND MNR_PLN_SEQ = (SELECT MNR_PLN_SEQ" ).append("\n"); 
		query.append("            	  		FROM MNR_PLN_HDR" ).append("\n"); 
		query.append("            	 		WHERE 1=1" ).append("\n"); 
		query.append("                   		AND MNR_PLN_YR  = @[mnr_pln_yr]" ).append("\n"); 
		query.append("            			AND MNR_PLN_OFC_CD = @[ctrl_ofc_cd] " ).append("\n"); 
		query.append("                	)" ).append("\n"); 

	}
}