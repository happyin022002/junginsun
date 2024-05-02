/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AsiaInlandCostManageDBDAOMultiInlandCostSpecialCargoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AsiaInlandCostManageDBDAOMultiInlandCostSpecialCargoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * multiInlandCostSpecialCargo
	  * </pre>
	  */
	public AsiaInlandCostManageDBDAOMultiInlandCostSpecialCargoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cost_trf_no",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.integration").append("\n"); 
		query.append("FileName : AsiaInlandCostManageDBDAOMultiInlandCostSpecialCargoCSQL").append("\n"); 
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
		query.append("INSERT INTO AOC_CHN_INLND_SPCL_TRF_DTL" ).append("\n"); 
		query.append("        (  COST_TRF_NO" ).append("\n"); 
		query.append("         , CNTR_SZ_CD" ).append("\n"); 
		query.append("         , TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("         , CURR_CD" ).append("\n"); 
		query.append("         , DG_FX_RT" ).append("\n"); 
		query.append("         , DG_FX_RTO" ).append("\n"); 
		query.append("         , MIN_CGO_WGT" ).append("\n"); 
		query.append("         , MAX_CGO_WGT" ).append("\n"); 
		query.append("         , OVR_WGT_FX_RT" ).append("\n"); 
		query.append("         , OVR_WGT_FX_RTO" ).append("\n"); 
		query.append("         , DCGO_SVC_FLG" ).append("\n"); 
		query.append("         , OVWT_CGO_SVC_FLG" ).append("\n"); 
		query.append("         , CRE_USR_ID" ).append("\n"); 
		query.append("         , CRE_DT" ).append("\n"); 
		query.append("         , UPD_USR_ID" ).append("\n"); 
		query.append("         , UPD_DT" ).append("\n"); 
		query.append("        )        " ).append("\n"); 
		query.append("    SELECT HDR.COST_TRF_NO" ).append("\n"); 
		query.append("         , B.CNTR_SZ_CD" ).append("\n"); 
		query.append("         , A.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("--         , ( SELECT CURR_CD FROM AOC_TRF_CURR WHERE CNT_CD = HDR.CNT_CD" ).append("\n"); 
		query.append("--              UNION SELECT 'HKD' FROM DUAL WHERE 'CN' = HDR.CNT_CD) AS CURR_CD" ).append("\n"); 
		query.append("		 , C.CURR_CD" ).append("\n"); 
		query.append("         , '0' AS DG_FX_RT" ).append("\n"); 
		query.append("         , '0' AS DG_FX_RTO" ).append("\n"); 
		query.append("         , '0' AS MIN_CGO_WGT" ).append("\n"); 
		query.append("         , '0' AS MAX_CGO_WGT" ).append("\n"); 
		query.append("         , '0' AS OVR_WGT_FX_RT" ).append("\n"); 
		query.append("         , '0' AS OVR_WGT_FX_RTO" ).append("\n"); 
		query.append("         , 'N' AS DCGO_SVC_FLG" ).append("\n"); 
		query.append("         , 'N' AS OVWT_CGO_SVC_FLG" ).append("\n"); 
		query.append("         , @[cre_usr_id]" ).append("\n"); 
		query.append("         , SYSDATE" ).append("\n"); 
		query.append("         , @[upd_usr_id]" ).append("\n"); 
		query.append("         , SYSDATE         " ).append("\n"); 
		query.append("    FROM AOC_CHN_INLND_TRF_HDR HDR" ).append("\n"); 
		query.append("       , COM_INTG_CD_DTL A     " ).append("\n"); 
		query.append("       , (    SELECT  '20' CNTR_SZ_CD" ).append("\n"); 
		query.append("              FROM    DUAL" ).append("\n"); 
		query.append("              UNION ALL" ).append("\n"); 
		query.append("              SELECT  '40' CNTR_SZ_CD" ).append("\n"); 
		query.append("              FROM    DUAL" ).append("\n"); 
		query.append("         ) B   " ).append("\n"); 
		query.append("       , ( SELECT CURR_CD FROM AOC_TRF_CURR WHERE CNT_CD = (SELECT CNT_CD FROM AOC_CHN_INLND_TRF_HDR WHERE COST_TRF_NO = @[in_cost_trf_no])" ).append("\n"); 
		query.append("    	   UNION SELECT 'HKD' FROM DUAL WHERE 'CN' = (SELECT CNT_CD FROM AOC_CHN_INLND_TRF_HDR WHERE COST_TRF_NO = @[in_cost_trf_no])) C" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("   WHERE 1=1" ).append("\n"); 
		query.append("     AND HDR.COST_TRF_NO = @[in_cost_trf_no]" ).append("\n"); 
		query.append("     AND INTG_CD_ID = DECODE(HDR.IO_BND_CD,'O','CD03067','CD03068')" ).append("\n"); 
		query.append("     AND INTG_CD_VAL_CTNT||B.CNTR_SZ_CD NOT IN ( SELECT TRSP_CRR_MOD_CD||CNTR_SZ_CD" ).append("\n"); 
		query.append("                                     FROM AOC_CHN_INLND_SPCL_TRF_DTL" ).append("\n"); 
		query.append("                                    WHERE COST_TRF_NO = @[in_cost_trf_no]" ).append("\n"); 
		query.append("                                 )                               " ).append("\n"); 

	}
}