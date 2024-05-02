/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TargetGroupDBDAOMultiCostManagementCopy0170CSQL.java
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

public class TargetGroupDBDAOMultiCostManagementCopy0170CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TargetGroupDBDAOMultiCostManagementCopyCSQL : Management Copy (Insert)
	  * </pre>
	  */
	public TargetGroupDBDAOMultiCostManagementCopy0170CSQL(){
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
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("copyBse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("copyBse_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.integration").append("\n"); 
		query.append("FileName : TargetGroupDBDAOMultiCostManagementCopy0170CSQL").append("\n"); 
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
		query.append("INSERT INTO SAQ_COST_APPL_BSE (  " ).append("\n"); 
		query.append("            BSE_YR                " ).append("\n"); 
		query.append("          , BSE_QTR_CD            " ).append("\n"); 
		query.append("          , COST_DIV_CD           " ).append("\n"); 
		query.append("          , COST_DIV_DESC         " ).append("\n"); 
		query.append("          , APPL_YR               " ).append("\n"); 
		query.append("          , APPL_MON              " ).append("\n"); 
		query.append("          , CRE_USR_ID            " ).append("\n"); 
		query.append("          , CRE_DT                " ).append("\n"); 
		query.append("          , UPD_USR_ID            " ).append("\n"); 
		query.append("          , UPD_DT )              " ).append("\n"); 
		query.append("   SELECT   @[bse_yr]                     " ).append("\n"); 
		query.append("          , @[bse_qtr_cd]                     " ).append("\n"); 
		query.append("          , COST_DIV_CD           " ).append("\n"); 
		query.append("          , COST_DIV_DESC         " ).append("\n"); 
		query.append("          , APPL_YR               " ).append("\n"); 
		query.append("          , APPL_MON              " ).append("\n"); 
		query.append("          , @[cre_usr_id]                     " ).append("\n"); 
		query.append("          , SYSDATE               " ).append("\n"); 
		query.append("          , @[cre_usr_id]                     " ).append("\n"); 
		query.append("          , SYSDATE               " ).append("\n"); 
		query.append("     FROM SAQ_COST_APPL_BSE       " ).append("\n"); 
		query.append("    WHERE BSE_YR     = @[copyBse_yr]          " ).append("\n"); 
		query.append("      AND BSE_QTR_CD = @[copyBse_qtr_cd]" ).append("\n"); 

	}
}