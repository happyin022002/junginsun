/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PlanMgtDBDAOsearchRepairExpensePlanHeaderDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.17
*@LastModifier : 한종희
*@LastVersion : 1.0
* 2014.06.17 한종희
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Justin(Jonghee) HAN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PlanMgtDBDAOsearchRepairExpensePlanHeaderDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	  * Repair Expense Plan - M & R Budget Summary 조회
	  * 2014-06-16 BY JUSTIN HAN CSR ID : CHM-201430738, TITLE ALPS MNR-General Performance에서 Local Currency-> USD로 변환하는 로직 수정 요청
	  *                   REMOVE OUTER JOIN OF MNR_PLN_SEQ
	  * ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	  * </pre>
	  */
	public PlanMgtDBDAOsearchRepairExpensePlanHeaderDataRSQL(){
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
		query.append("FileName : PlanMgtDBDAOsearchRepairExpensePlanHeaderDataRSQL").append("\n"); 
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
		query.append("SELECT A.MNR_PLN_YR" ).append("\n"); 
		query.append(",	B.CTRL_OFC_CD" ).append("\n"); 
		query.append(",   A.MNR_PLN_OFC_CD" ).append("\n"); 
		query.append(",	A.UPD_USR_ID CRE_USR_ID" ).append("\n"); 
		query.append(",	To_CHAR(A.UPD_DT, 'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append(",   B.ACCT_CD" ).append("\n"); 
		query.append(",   B.MNR_PLN_AMT" ).append("\n"); 
		query.append(",   A.MNR_PLN_SEQ" ).append("\n"); 
		query.append(",	B.OFC_TP_CD" ).append("\n"); 
		query.append(",	A.MNR_PLN_GRP_NO" ).append("\n"); 
		query.append(",   NVL((SELECT A.MNR_PLN_FLG FROM MNR_PLN_HDR A WHERE A.MNR_GRP_TP_CD = 'RPR' AND A.MNR_PLN_YR = @[mnr_pln_yr] AND A.MNR_PLN_OFC_CD = @[mnr_pln_ofc_cd] AND ROWNUM = 1), 'N') MNR_PLN_FLG" ).append("\n"); 
		query.append("  FROM MNR_PLN_HDR A, MNR_PLN_DTL B" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.MNR_GRP_TP_CD = 'RPR'" ).append("\n"); 
		query.append("   AND A.MNR_PLN_SEQ   = B.MNR_PLN_SEQ" ).append("\n"); 
		query.append("   AND A.MNR_PLN_YR    = @[mnr_pln_yr]" ).append("\n"); 
		query.append("   AND B.CTRL_OFC_CD   = @[mnr_pln_ofc_cd]" ).append("\n"); 
		query.append("   AND B.OFC_TP_CD	    IN ('HO', 'HQ')" ).append("\n"); 
		query.append(" #if (${hoofc} != 'true') " ).append("\n"); 
		query.append("   AND A.MNR_PLN_FLG = NVL((SELECT MNR_PLN_FLG " ).append("\n"); 
		query.append("                              FROM MNR_PLN_HDR A" ).append("\n"); 
		query.append("                             WHERE 1 = 1 " ).append("\n"); 
		query.append("                               AND A.MNR_PLN_YR = @[mnr_pln_yr]" ).append("\n"); 
		query.append("                               AND A.MNR_PLN_OFC_CD = @[mnr_pln_ofc_cd] " ).append("\n"); 
		query.append("                               AND A.MNR_GRP_TP_CD = 'RPR' " ).append("\n"); 
		query.append("                               AND ROWNUM = 1), 'Y')" ).append("\n"); 
		query.append(" #end" ).append("\n"); 

	}
}