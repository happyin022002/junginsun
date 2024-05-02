/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeCalculationDBDAOAddManualBatchHistoryCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOAddManualBatchHistoryCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAOAddManualBatchHistoryCSQL
	  * </pre>
	  */
	public ChargeCalculationDBDAOAddManualBatchHistoryCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("batch_cntr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bat_run_tm_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOAddManualBatchHistoryCSQL").append("\n"); 
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
		query.append("INSERT INTO DMT_MNL_BAT_HIS" ).append("\n"); 
		query.append("            (BKG_NO            " ).append("\n"); 
		query.append("            ,CNTR_NO       		" ).append("\n"); 
		query.append("            ,DMDT_TRF_CD   	 " ).append("\n"); 
		query.append("            ,BAT_RUN_TM_ID 	" ).append("\n"); 
		query.append("            ,BAT_RSLT_FLG  " ).append("\n"); 
		query.append("            ,CRE_USR_ID		" ).append("\n"); 
		query.append("            ,CRE_DT		" ).append("\n"); 
		query.append("            ,UPD_USR_ID" ).append("\n"); 
		query.append("            ,UPD_DT" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("SELECT DISTINCT BKG_NO            " ).append("\n"); 
		query.append("            ,CNTR_NO       		" ).append("\n"); 
		query.append("            ,DMDT_TRF_CD   	 " ).append("\n"); 
		query.append("            ,BAT_RUN_TM_ID 	" ).append("\n"); 
		query.append("            ,BAT_RSLT_FLG  " ).append("\n"); 
		query.append("            ,CRE_USR_ID		" ).append("\n"); 
		query.append("            ,CRE_DT		" ).append("\n"); 
		query.append("            ,UPD_USR_ID" ).append("\n"); 
		query.append("            ,UPD_DT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	   @[bkg_no] BKG_NO" ).append("\n"); 
		query.append("     , CNTR_NO CNTR_NO" ).append("\n"); 
		query.append("     , @[dmdt_trf_cd] DMDT_TRF_CD" ).append("\n"); 
		query.append("     , @[bat_run_tm_id] BAT_RUN_TM_ID" ).append("\n"); 
		query.append("     , 'N' BAT_RSLT_FLG" ).append("\n"); 
		query.append("     , @[user_id] CRE_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE CRE_DT" ).append("\n"); 
		query.append("     , @[user_id] UPD_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE UPD_DT" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BKG_NO			= @[bkg_no]" ).append("\n"); 
		query.append("#if (${batch_cntr} != '')" ).append("\n"); 
		query.append("AND CNTR_NO = @[batch_cntr]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT @[bkg_no]" ).append("\n"); 
		query.append("     , A.CNTR_NO" ).append("\n"); 
		query.append("     , @[dmdt_trf_cd]" ).append("\n"); 
		query.append("     , @[bat_run_tm_id]" ).append("\n"); 
		query.append("     , 'N'" ).append("\n"); 
		query.append("     , @[user_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("     , @[user_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("FROM DMT_CHG_BKG_CNTR A, DMT_CHG_CALC B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.SYS_AREA_GRP_ID = B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("AND A.CNTR_CYC_NO = B.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND B.DMDT_TRF_CD = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("#if (${batch_cntr} != '')" ).append("\n"); 
		query.append("AND A.CNTR_NO = @[batch_cntr]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}