/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DailyForecastManageDBDAOSpcSlsRepCustCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.04
*@LastModifier : Arie
*@LastVersion : 1.0
* 2015.12.04 Arie
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Arie
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DailyForecastManageDBDAOSpcSlsRepCustCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sales Rep별 관리되는 Account 정보를 등록/수정한다.
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * 2013.10.24 [선처리] Account Add/Del 과 Mapping 구분자 생성
	  * 2013.12.02 모델 불일치로 인한 컬럼명 수정. MAPG_FLG -> CUST_MAPG_FLG
	  * </pre>
	  */
	public DailyForecastManageDBDAOSpcSlsRepCustCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_rep_ofc_team_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rvis_cntr_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("indiv_cust_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_mapg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.integration").append("\n"); 
		query.append("FileName : DailyForecastManageDBDAOSpcSlsRepCustCSQL").append("\n"); 
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
		query.append("MERGE INTO SPC_SLS_REP_CUST S" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("#if(${sls_ofc_cd} != '')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        SELECT A.SREP_CD," ).append("\n"); 
		query.append("               A.CUST_CNT_CD," ).append("\n"); 
		query.append("               A.CUST_SEQ," ).append("\n"); 
		query.append("               A.TRD_CD," ).append("\n"); 
		query.append("               A.SUB_TRD_CD," ).append("\n"); 
		query.append("               A.RVIS_CNTR_CUST_TP_CD," ).append("\n"); 
		query.append("               R.OFC_CD AS SLS_OFC_CD," ).append("\n"); 
		query.append("               S.SLS_REP_OFC_TEAM_CD," ).append("\n"); 
		query.append("               NVL(A.DELT_FLG, 'N') AS DELT_FLG," ).append("\n"); 
		query.append("               A.INDIV_CUST_USE_FLG," ).append("\n"); 
		query.append("               A.USR_ID," ).append("\n"); 
		query.append("               A.CUST_MAPG_FLG" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                SELECT  @[srep_cd]              AS SREP_CD" ).append("\n"); 
		query.append("                      , @[cust_cnt_cd]          AS CUST_CNT_CD" ).append("\n"); 
		query.append("                      , TO_NUMBER(@[cust_seq])  AS CUST_SEQ" ).append("\n"); 
		query.append("                      , NVL(@[trade], '*')      AS TRD_CD" ).append("\n"); 
		query.append("                      , NVL(@[sub_trd_cd], '*') AS SUB_TRD_CD" ).append("\n"); 
		query.append("                      , @[rvis_cntr_cust_tp_cd] AS RVIS_CNTR_CUST_TP_CD" ).append("\n"); 
		query.append("                      , @[sls_ofc_cd]           AS SLS_OFC_CD" ).append("\n"); 
		query.append("                      , @[sls_rep_ofc_team_cd]  AS SLS_REP_OFC_TEAM_CD" ).append("\n"); 
		query.append("                      , NVL(@[delt_flg], 'N')   AS DELT_FLG" ).append("\n"); 
		query.append("                      , DECODE(NVL(@[indiv_cust_use_flg], '0'), '1', 'Y', '0', 'N', @[indiv_cust_use_flg]) AS INDIV_CUST_USE_FLG" ).append("\n"); 
		query.append("                      , @[upd_usr_id] AS USR_ID" ).append("\n"); 
		query.append("                      , NVL(@[cust_mapg_flg], 'N')   AS CUST_MAPG_FLG" ).append("\n"); 
		query.append("                 FROM DUAL" ).append("\n"); 
		query.append("#if(${sls_ofc_cd} != '')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("               ) A, " ).append("\n"); 
		query.append("               MDM_SLS_REP         R," ).append("\n"); 
		query.append("               SPC_SLS_REP_TEAM_IF S" ).append("\n"); 
		query.append("         WHERE A.SREP_CD = R.SREP_CD" ).append("\n"); 
		query.append("           AND R.SREP_CD = S.SREP_USR_ID(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ) C" ).append("\n"); 
		query.append("  ON ( " ).append("\n"); 
		query.append("            S.SREP_CD       = C.SREP_CD" ).append("\n"); 
		query.append("        AND S.CUST_CNT_CD   = C.CUST_CNT_CD" ).append("\n"); 
		query.append("        AND S.CUST_SEQ      = C.CUST_SEQ" ).append("\n"); 
		query.append("        AND S.TRD_CD        = C.TRD_CD" ).append("\n"); 
		query.append("        AND S.SUB_TRD_CD    = C.SUB_TRD_CD" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append(" WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE" ).append("\n"); 
		query.append("       SET   S.SLS_OFC_CD           = C.SLS_OFC_CD" ).append("\n"); 
		query.append("           , S.SLS_REP_OFC_TEAM_CD  = C.SLS_REP_OFC_TEAM_CD" ).append("\n"); 
		query.append("           , S.DELT_FLG             = C.DELT_FLG" ).append("\n"); 
		query.append("           , S.INDIV_CUST_USE_FLG   = C.INDIV_CUST_USE_FLG" ).append("\n"); 
		query.append("           , S.UPD_USR_ID           = C.USR_ID" ).append("\n"); 
		query.append("           , S.UPD_DT               = SYSDATE" ).append("\n"); 
		query.append("           , S.CUST_MAPG_FLG        = C.CUST_MAPG_FLG" ).append("\n"); 
		query.append(" WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT (" ).append("\n"); 
		query.append("              SREP_CD" ).append("\n"); 
		query.append("            , CUST_CNT_CD" ).append("\n"); 
		query.append("            , CUST_SEQ" ).append("\n"); 
		query.append("            , TRD_CD" ).append("\n"); 
		query.append("            , SUB_TRD_CD" ).append("\n"); 
		query.append("            , RVIS_CNTR_CUST_TP_CD" ).append("\n"); 
		query.append("            , SLS_OFC_CD" ).append("\n"); 
		query.append("            , SLS_REP_OFC_TEAM_CD" ).append("\n"); 
		query.append("            , DELT_FLG" ).append("\n"); 
		query.append("            , INDIV_CUST_USE_FLG" ).append("\n"); 
		query.append("            , CRE_USR_ID" ).append("\n"); 
		query.append("            , CRE_DT" ).append("\n"); 
		query.append("            , UPD_USR_ID" ).append("\n"); 
		query.append("            , UPD_DT" ).append("\n"); 
		query.append("            , CUST_MAPG_FLG" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("    VALUES (" ).append("\n"); 
		query.append("              C.SREP_CD" ).append("\n"); 
		query.append("            , C.CUST_CNT_CD" ).append("\n"); 
		query.append("            , C.CUST_SEQ" ).append("\n"); 
		query.append("            , C.TRD_CD" ).append("\n"); 
		query.append("            , C.SUB_TRD_CD" ).append("\n"); 
		query.append("            , C.RVIS_CNTR_CUST_TP_CD" ).append("\n"); 
		query.append("            , C.SLS_OFC_CD" ).append("\n"); 
		query.append("            , C.SLS_REP_OFC_TEAM_CD" ).append("\n"); 
		query.append("            , C.DELT_FLG" ).append("\n"); 
		query.append("            , C.INDIV_CUST_USE_FLG" ).append("\n"); 
		query.append("            , C.USR_ID" ).append("\n"); 
		query.append("            , SYSDATE" ).append("\n"); 
		query.append("            , C.USR_ID" ).append("\n"); 
		query.append("            , SYSDATE" ).append("\n"); 
		query.append("            , C.CUST_MAPG_FLG" ).append("\n"); 
		query.append("           )" ).append("\n"); 

	}
}