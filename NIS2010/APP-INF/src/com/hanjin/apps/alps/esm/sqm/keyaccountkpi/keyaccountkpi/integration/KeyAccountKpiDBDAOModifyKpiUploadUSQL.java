/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : KeyAccountKpiDBDAOModifyKpiUploadUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.keyaccountkpi.keyaccountkpi.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KeyAccountKpiDBDAOModifyKpiUploadUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyKpiUpload
	  * [CHM-201535626] (SQM) TPS 자리수 Validation
	  * </pre>
	  */
	public KeyAccountKpiDBDAOModifyKpiUploadUSQL(){
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
		params.put("bse_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_tgt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_grp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lod_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ra_cmpb_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trd_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.keyaccountkpi.keyaccountkpi.integration").append("\n"); 
		query.append("FileName : KeyAccountKpiDBDAOModifyKpiUploadUSQL").append("\n"); 
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
		query.append("MERGE INTO SQM_KEY_ACCT_CFM_QTA X" ).append("\n"); 
		query.append("USING  (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("               @[bse_tp_cd] AS BSE_TP_CD" ).append("\n"); 
		query.append("              ,@[bse_yr]    AS BSE_YR" ).append("\n"); 
		query.append("              ,DECODE(@[bse_tp_cd], 'Y', '00', @[bse_qtr_cd])AS BSE_QTR_CD" ).append("\n"); 
		query.append("              ,SUBSTR(@[acct_tgt_cd], 1, 1) AS ACCT_TGT_CD" ).append("\n"); 
		query.append("              ,SUBSTR(@[trd_bnd_cd], 1, 3) AS TRD_CD" ).append("\n"); 
		query.append("              ,DECODE( SUBSTR(@[trd_bnd_cd], 4, 1) , null, 'X', SUBSTR(@[trd_bnd_cd], 4, 1) ) AS DIR_CD" ).append("\n"); 
		query.append("              ,DECODE( SUBSTR(@[trd_bnd_cd], 4, 1) , null, 'X', SUBSTR(@[trd_bnd_cd], 4, 1) ) AS CONV_DIR_CD" ).append("\n"); 
		query.append("			  ,@[bse_wk]      AS BSE_WK" ).append("\n"); 
		query.append("              ,@[cust_grp_id] AS CUST_GRP_ID" ).append("\n"); 
		query.append("              ,@[lod_qty]     AS LOD_QTY" ).append("\n"); 
		query.append("              ,@[ra_cmpb_amt] AS RA_CMPB_AMT" ).append("\n"); 
		query.append("          FROM DUAL" ).append("\n"); 
		query.append("        ) Y" ).append("\n"); 
		query.append("ON (        X.BSE_TP_CD     = Y.BSE_TP_CD" ).append("\n"); 
		query.append("        AND X.BSE_YR        = Y.BSE_YR" ).append("\n"); 
		query.append("        AND X.BSE_QTR_CD    = Y.BSE_QTR_CD" ).append("\n"); 
		query.append("        AND X.ACCT_TGT_CD   = Y.ACCT_TGT_CD" ).append("\n"); 
		query.append("        AND X.TRD_CD        = Y.TRD_CD" ).append("\n"); 
		query.append("        AND X.CONV_DIR_CD   = Y.CONV_DIR_CD" ).append("\n"); 
		query.append("        AND X.CUST_GRP_ID   = Y.CUST_GRP_ID" ).append("\n"); 
		query.append("		AND X.BSE_WK		= Y.BSE_WK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE SET" ).append("\n"); 
		query.append("       X.LOD_QTY     = Y.LOD_QTY" ).append("\n"); 
		query.append("      ,X.RA_CMPB_AMT = Y.RA_CMPB_AMT" ).append("\n"); 
		query.append("      ,UPD_USR_ID    = @[upd_usr_id]" ).append("\n"); 
		query.append("      ,UPD_DT        = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT (" ).append("\n"); 
		query.append("             X.BSE_TP_CD" ).append("\n"); 
		query.append("            ,X.BSE_YR" ).append("\n"); 
		query.append("            ,X.BSE_QTR_CD" ).append("\n"); 
		query.append("            ,X.ACCT_TGT_CD" ).append("\n"); 
		query.append("            ,X.TRD_CD" ).append("\n"); 
		query.append("            ,X.DIR_CD" ).append("\n"); 
		query.append("            ,X.CONV_DIR_CD" ).append("\n"); 
		query.append("			,X.BSE_WK" ).append("\n"); 
		query.append("            ,X.CUST_GRP_ID" ).append("\n"); 
		query.append("            ,X.LOD_QTY" ).append("\n"); 
		query.append("            ,X.RA_CMPB_AMT" ).append("\n"); 
		query.append("            ,X.CRE_USR_ID" ).append("\n"); 
		query.append("            ,X.CRE_DT" ).append("\n"); 
		query.append("            ,X.UPD_USR_ID" ).append("\n"); 
		query.append("            ,X.UPD_DT" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("    VALUES (" ).append("\n"); 
		query.append("             Y.BSE_TP_CD" ).append("\n"); 
		query.append("            ,Y.BSE_YR" ).append("\n"); 
		query.append("            ,Y.BSE_QTR_CD" ).append("\n"); 
		query.append("            ,Y.ACCT_TGT_CD" ).append("\n"); 
		query.append("            ,Y.TRD_CD" ).append("\n"); 
		query.append("            ,Y.DIR_CD" ).append("\n"); 
		query.append("            ,Y.CONV_DIR_CD" ).append("\n"); 
		query.append("			,Y.BSE_WK" ).append("\n"); 
		query.append("            ,Y.CUST_GRP_ID" ).append("\n"); 
		query.append("            ,Y.LOD_QTY" ).append("\n"); 
		query.append("            ,Y.RA_CMPB_AMT" ).append("\n"); 
		query.append("            ,@[cre_usr_id]" ).append("\n"); 
		query.append("            ,SYSDATE" ).append("\n"); 
		query.append("            ,@[upd_usr_id]" ).append("\n"); 
		query.append("            ,SYSDATE" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}