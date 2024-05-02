/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : PlanMgtDBDAOsearchRepairExpensePlanDetailDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.27
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.27 
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

public class PlanMgtDBDAOsearchRepairExpensePlanDetailDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	  * Repair Expense Plan - M & R Budget Detail Data 조회
	  * 2014-06-16 BY JUSTIN HAN CSR ID : CHM-201430738, TITLE ALPS MNR-General Performance에서 Local Currency-> USD로 변환하는 로직 수정 요청
	  *                   SELOPB로 조회시 HQ에서 수립한 BB 예산이 추가로 조회되어 문제 발생
	  * ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	  * </pre>
	  */
	public PlanMgtDBDAOsearchRepairExpensePlanDetailDataRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.integration").append("\n"); 
		query.append("FileName : PlanMgtDBDAOsearchRepairExpensePlanDetailDataRSQL").append("\n"); 
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
		query.append("SELECT    B.MNR_PLN_SEQ                         " ).append("\n"); 
		query.append("        , A.MNR_PLN_DTL_SEQ                     " ).append("\n"); 
		query.append("        , B.MNR_PLN_YR                          " ).append("\n"); 
		query.append("        , A.CTRL_OFC_CD                         " ).append("\n"); 
		query.append("        , B.MNR_PLN_OFC_CD                      " ).append("\n"); 
		query.append("        , B.CRE_USR_ID                          " ).append("\n"); 
		query.append("        , To_CHAR(B.UPD_DT, 'YYYY-MM-DD') AS CRE_DT                          " ).append("\n"); 
		query.append("        , A.ACCT_CD                             " ).append("\n"); 
		query.append("        , A.MNR_PLN_AMT" ).append("\n"); 
		query.append("        , A.OFC_TP_CD" ).append("\n"); 
		query.append("        , NVL((SELECT A.MNR_PLN_FLG FROM MNR_PLN_HDR A WHERE A.MNR_GRP_TP_CD = 'RPR' AND A.MNR_PLN_YR = @[mnr_pln_yr] AND A.MNR_PLN_OFC_CD = @[mnr_pln_ofc_cd] AND ROWNUM = 1), 'N') MNR_PLN_FLG                     " ).append("\n"); 
		query.append("        , A.CTRL_OFC_CD AS MNR_PLN_OFC_HDR_CD" ).append("\n"); 
		query.append("        , A.OFC_TP_CD   AS OFC_TP_HDR_CD" ).append("\n"); 
		query.append("        , A.MNR_PLN_SEQ AS MNR_PLN_HDR_SEQ         " ).append("\n"); 
		query.append("   FROM MNR_PLN_DTL A, (SELECT MNR_PLN_SEQ, MNR_PLN_GRP_NO, MNR_PLN_OFC_CD, MNR_PLN_YR, UPD_DT, CRE_USR_ID" ).append("\n"); 
		query.append("						  FROM MNR_PLN_HDR" ).append("\n"); 
		query.append("						 WHERE 1=1" ).append("\n"); 
		query.append("						   AND MNR_PLN_YR     = @[mnr_pln_yr]		   " ).append("\n"); 
		query.append("                        #if(${mnr_pln_ofc_cd} != 'SELCON')" ).append("\n"); 
		query.append("                           AND MNR_PLN_OFC_CD = @[mnr_pln_ofc_cd]" ).append("\n"); 
		query.append("                        #end                        " ).append("\n"); 
		query.append("                        ) B" ).append("\n"); 
		query.append("						 " ).append("\n"); 
		query.append("   WHERE 1=1" ).append("\n"); 
		query.append("     AND A.MNR_PLN_SEQ = B.MNR_PLN_SEQ   " ).append("\n"); 
		query.append("  #if(${mnr_pln_ofc_cd} == 'SELCON')" ).append("\n"); 
		query.append("     AND A.CTRL_OFC_CD = B.MNR_PLN_OFC_CD" ).append("\n"); 
		query.append("	 AND A.OFC_TP_CD = 'HQ'" ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("	 AND A.OFC_TP_CD = 'BB'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${mnr_ofc_cd} != ''&& ${mnr_ofc_cd} != 'ALL')" ).append("\n"); 
		query.append("     AND A.CTRL_OFC_CD = @[mnr_ofc_cd]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT    B.MNR_PLN_SEQ                         " ).append("\n"); 
		query.append("        , A.MNR_PLN_DTL_SEQ                     " ).append("\n"); 
		query.append("        , B.MNR_PLN_YR                          " ).append("\n"); 
		query.append("        , A.CTRL_OFC_CD                         " ).append("\n"); 
		query.append("        , B.MNR_PLN_OFC_CD                      " ).append("\n"); 
		query.append("        , B.CRE_USR_ID                          " ).append("\n"); 
		query.append("        , To_CHAR(B.UPD_DT, 'YYYY-MM-DD') AS CRE_DT                          " ).append("\n"); 
		query.append("        , A.ACCT_CD                             " ).append("\n"); 
		query.append("        , A.MNR_PLN_AMT" ).append("\n"); 
		query.append("        , A.OFC_TP_CD " ).append("\n"); 
		query.append("        , NVL((SELECT A.MNR_PLN_FLG FROM MNR_PLN_HDR A WHERE A.MNR_GRP_TP_CD = 'RPR' AND A.MNR_PLN_YR = @[mnr_pln_yr] AND A.MNR_PLN_OFC_CD = @[mnr_pln_ofc_cd] AND ROWNUM = 1), 'N') MNR_PLN_FLG                     " ).append("\n"); 
		query.append("        , A.CTRL_OFC_CD AS MNR_PLN_OFC_HDR_CD" ).append("\n"); 
		query.append("        , A.OFC_TP_CD   AS OFC_TP_HDR_CD" ).append("\n"); 
		query.append("        , A.MNR_PLN_SEQ AS MNR_PLN_HDR_SEQ        " ).append("\n"); 
		query.append("   FROM MNR_PLN_DTL A, (SELECT MNR_PLN_SEQ, MNR_PLN_GRP_NO, MNR_PLN_OFC_CD, MNR_PLN_YR, UPD_DT, CRE_USR_ID" ).append("\n"); 
		query.append("						  FROM MNR_PLN_HDR" ).append("\n"); 
		query.append("						 WHERE 1=1" ).append("\n"); 
		query.append("						   AND MNR_PLN_YR     = @[mnr_pln_yr]" ).append("\n"); 
		query.append("                        #if(${mnr_pln_ofc_cd} != 'SELCON')" ).append("\n"); 
		query.append("                           AND MNR_PLN_OFC_CD = @[mnr_pln_ofc_cd]" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        ) B" ).append("\n"); 
		query.append("   WHERE 1=1" ).append("\n"); 
		query.append("     AND A.MNR_PLN_SEQ = B.MNR_PLN_SEQ" ).append("\n"); 
		query.append("     AND A.OFC_TP_CD = 'BB'   " ).append("\n"); 
		query.append("  #if(${mnr_pln_ofc_cd} == 'SELCON')" ).append("\n"); 
		query.append("     AND A.CTRL_OFC_CD = @[mnr_pln_ofc_cd]" ).append("\n"); 
		query.append("  #end	   " ).append("\n"); 
		query.append("  #if (${mnr_ofc_cd} != ''&& ${mnr_ofc_cd} != 'ALL')" ).append("\n"); 
		query.append("     AND A.CTRL_OFC_CD = @[mnr_ofc_cd]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("ORDER BY 1, 5, 2, 4" ).append("\n"); 

	}
}