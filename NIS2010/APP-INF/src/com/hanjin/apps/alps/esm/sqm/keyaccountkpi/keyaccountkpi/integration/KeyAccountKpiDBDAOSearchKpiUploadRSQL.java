/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : KeyAccountKpiDBDAOSearchKpiUploadRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.27 
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

public class KeyAccountKpiDBDAOSearchKpiUploadRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchKpiUpload
	  * 2015.04.15 김용습 [CHM-201535206] KPI Management "Week" 조건 추가
	  * 2015.04.27 김용습 [CHM-201535626] (SQM) TPS 자리수 Validation
	  * </pre>
	  */
	public KeyAccountKpiDBDAOSearchKpiUploadRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cust_grp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_conv_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_acct_tgt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.keyaccountkpi.keyaccountkpi.integration").append("\n"); 
		query.append("FileName : KeyAccountKpiDBDAOSearchKpiUploadRSQL").append("\n"); 
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
		query.append("SELECT A1.BSE_YR" ).append("\n"); 
		query.append("      ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("	  ,A1.BSE_WK" ).append("\n"); 
		query.append("      ,A1.TRD_CD||DECODE(A1.CONV_DIR_CD, 'X', '', A1.CONV_DIR_CD) AS TRD_BND_CD" ).append("\n"); 
		query.append("      ,DECODE(A1.CONV_DIR_CD, 'X', '', A1.CONV_DIR_CD) AS CONV_DIR_CD" ).append("\n"); 
		query.append("      ,DECODE(A1.ACCT_TGT_CD, 'C', 'CORE', 'R', 'REGION') AS ACCT_TGT_CD" ).append("\n"); 
		query.append("      ,A1.CUST_GRP_ID" ).append("\n"); 
		query.append("      ,(SELECT A2.CUST_GRP_NM" ).append("\n"); 
		query.append("          FROM MDM_CUST_PERF_GRP A2" ).append("\n"); 
		query.append("         WHERE A1.CUST_GRP_ID = A2.CUST_GRP_ID ) AS CUST_GRP_NM" ).append("\n"); 
		query.append("      ,A1.LOD_QTY" ).append("\n"); 
		query.append("      ,A1.RA_CMPB_AMT" ).append("\n"); 
		query.append("  FROM SQM_KEY_ACCT_CFM_QTA A1" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD   = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("   AND A1.BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("#if(${f_bse_tp_cd} == 'Q')" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD  = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_to_wk} != 'All')" ).append("\n"); 
		query.append("   AND A1.BSE_WK = @[f_to_wk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.TRD_CD      = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_conv_dir_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.CONV_DIR_CD = @[f_conv_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_acct_tgt_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.ACCT_TGT_CD = @[f_acct_tgt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_cust_grp_id} != 'All')" ).append("\n"); 
		query.append("   AND A1.CUST_GRP_ID = @[f_cust_grp_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY A1.BSE_YR, A1.TRD_CD, A1.CONV_DIR_CD, A1.BSE_WK" ).append("\n"); 

	}
}