/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TargetGroupDBDAOMultiCostManagementSave0170CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.09
*@LastModifier : 김종호
*@LastVersion : 1.0
* 2010.03.09 김종호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Ho Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TargetGroupDBDAOMultiCostManagementSave0170CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TargetGroupDBDAOMultiCostManagementSaveCSQL  : Cost Management 저장
	  * </pre>
	  */
	public TargetGroupDBDAOMultiCostManagementSave0170CSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("appl_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_div_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("appl_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.integration").append("\n"); 
		query.append("FileName : TargetGroupDBDAOMultiCostManagementSave0170CSQL").append("\n"); 
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
		query.append("MERGE INTO SAQ_COST_APPL_BSE A                   " ).append("\n"); 
		query.append(" USING (                                          " ).append("\n"); 
		query.append("         SELECT   @[bse_yr] AS BSE_YR                     " ).append("\n"); 
		query.append("                , @[bse_qtr_cd] AS BSE_QTR_CD                 " ).append("\n"); 
		query.append("                , @[cost_div_cd] AS COST_DIV_CD                " ).append("\n"); 
		query.append("                , @[cost_div_desc] AS COST_DIV_DESC              " ).append("\n"); 
		query.append("                , @[appl_yr] AS APPL_YR                    " ).append("\n"); 
		query.append("                , @[appl_mon] AS APPL_MON                   " ).append("\n"); 
		query.append("                , @[cre_usr_id] AS CRE_USR_ID                 " ).append("\n"); 
		query.append("                , @[upd_usr_id] AS UPD_USR_ID                 " ).append("\n"); 
		query.append("           FROM DUAL                              " ).append("\n"); 
		query.append("       ) B                                        " ).append("\n"); 
		query.append("    ON (                                          " ).append("\n"); 
		query.append("                A.BSE_YR      = B.BSE_YR          " ).append("\n"); 
		query.append("            AND A.BSE_QTR_CD  = B.BSE_QTR_CD      " ).append("\n"); 
		query.append("            AND A.COST_DIV_CD = B.COST_DIV_CD  )  " ).append("\n"); 
		query.append("  WHEN MATCHED THEN                               " ).append("\n"); 
		query.append("      UPDATE SET   A.APPL_YR    = B.APPL_YR       " ).append("\n"); 
		query.append("                 , A.APPL_MON   = B.APPL_MON      " ).append("\n"); 
		query.append("                 , A.UPD_USR_ID = B.UPD_USR_ID    " ).append("\n"); 
		query.append("                 , A.UPD_DT     = SYSDATE         " ).append("\n"); 
		query.append("  WHEN NOT MATCHED THEN                           " ).append("\n"); 
		query.append("      INSERT (   A.BSE_YR                         " ).append("\n"); 
		query.append("               , A.BSE_QTR_CD                     " ).append("\n"); 
		query.append("               , A.COST_DIV_CD                    " ).append("\n"); 
		query.append("               , A.COST_DIV_DESC                  " ).append("\n"); 
		query.append("               , A.APPL_YR                        " ).append("\n"); 
		query.append("               , A.APPL_MON                       " ).append("\n"); 
		query.append("               , A.CRE_USR_ID                     " ).append("\n"); 
		query.append("               , A.CRE_DT                         " ).append("\n"); 
		query.append("               , A.UPD_USR_ID                     " ).append("\n"); 
		query.append("               , A.UPD_DT      )                  " ).append("\n"); 
		query.append("      VALUES (   B.BSE_YR                         " ).append("\n"); 
		query.append("               , B.BSE_QTR_CD                     " ).append("\n"); 
		query.append("               , B.COST_DIV_CD                    " ).append("\n"); 
		query.append("               , B.COST_DIV_DESC                  " ).append("\n"); 
		query.append("               , B.APPL_YR                        " ).append("\n"); 
		query.append("               , B.APPL_MON                       " ).append("\n"); 
		query.append("               , B.CRE_USR_ID                     " ).append("\n"); 
		query.append("               , SYSDATE                          " ).append("\n"); 
		query.append("               , B.UPD_USR_ID                     " ).append("\n"); 
		query.append("               , SYSDATE       )" ).append("\n"); 

	}
}