/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MonthlyQuotaCreationDBDAOCreateOfcAdjustCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaCreationDBDAOCreateOfcAdjustCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Office Adjust 정보를 입력한다.
	  * </pre>
	  */
	public MonthlyQuotaCreationDBDAOCreateOfcAdjustCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mqta_mdl_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cm_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grs_rpb_rev",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("st_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaCreationDBDAOCreateOfcAdjustCSQL").append("\n"); 
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
		query.append("INSERT INTO SAQ_MON_FCAST_TRNS" ).append("\n"); 
		query.append("       ( " ).append("\n"); 
		query.append("           MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("         , SLS_FCAST_NO " ).append("\n"); 
		query.append("         , ALTN_FCAST_SEQ " ).append("\n"); 
		query.append("         , RLANE_CD " ).append("\n"); 
		query.append("         , DIR_CD " ).append("\n"); 
		query.append("         , CTRT_OFC_CD " ).append("\n"); 
		query.append("         , SLS_OFC_CD " ).append("\n"); 
		query.append("         , LOD_QTY " ).append("\n"); 
		query.append("         , GRS_RPB_REV " ).append("\n"); 
		query.append("         , CM_UC_AMT " ).append("\n"); 
		query.append("         , MDL_ALOC_QTY " ).append("\n"); 
		query.append("         , REP_TRD_CD " ).append("\n"); 
		query.append("         , REP_SUB_TRD_CD " ).append("\n"); 
		query.append("         , TRD_CD " ).append("\n"); 
		query.append("         , SUB_TRD_CD " ).append("\n"); 
		query.append("         , IOC_CD " ).append("\n"); 
		query.append("         , CTRT_RHQ_CD " ).append("\n"); 
		query.append("         , CTRT_AQ_CD " ).append("\n"); 
		query.append("         , CTRT_RGN_OFC_CD " ).append("\n"); 
		query.append("         , SLS_RHQ_CD " ).append("\n"); 
		query.append("         , SLS_AQ_CD " ).append("\n"); 
		query.append("         , SLS_RGN_OFC_CD " ).append("\n"); 
		query.append("         , ST_DT " ).append("\n"); 
		query.append("         , ORG_LOD_QTY " ).append("\n"); 
		query.append("         , ORG_GRS_RPB_REV " ).append("\n"); 
		query.append("         , ORG_CM_UC_AMT " ).append("\n"); 
		query.append("         , FCAST_TRNS_STS_CD " ).append("\n"); 
		query.append("         , RA_CM_UC_AMT" ).append("\n"); 
		query.append("         , RA_OPFIT_UC_AMT" ).append("\n"); 
		query.append("         , CRE_USR_ID " ).append("\n"); 
		query.append("         , CRE_DT " ).append("\n"); 
		query.append("         , UPD_USR_ID " ).append("\n"); 
		query.append("         , UPD_DT " ).append("\n"); 
		query.append("       ) " ).append("\n"); 
		query.append("WITH TEMP AS " ).append("\n"); 
		query.append("       (SELECT @[mqta_mdl_ver_no] AS MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("            , @[rlane_cd] AS RLANE_CD " ).append("\n"); 
		query.append("            , @[dir_cd] AS DIR_CD " ).append("\n"); 
		query.append("            , @[ctrt_ofc_cd] AS CTRT_OFC_CD " ).append("\n"); 
		query.append("            , @[sls_ofc_cd] AS SLS_OFC_CD " ).append("\n"); 
		query.append("            , @[lod_qty] AS LOD_QTY " ).append("\n"); 
		query.append("            , @[grs_rpb_rev] AS GRS_RPB_REV " ).append("\n"); 
		query.append("            , @[cm_uc_amt] AS CM_UC_AMT " ).append("\n"); 
		query.append("            , @[lod_qty] AS MDL_ALOC_QTY " ).append("\n"); 
		query.append("            , @[trd_cd] AS REP_TRD_CD " ).append("\n"); 
		query.append("            , @[sub_trd_cd] AS REP_SUB_TRD_CD " ).append("\n"); 
		query.append("            , @[trd_cd] AS TRD_CD " ).append("\n"); 
		query.append("            , @[sub_trd_cd] AS SUB_TRD_CD " ).append("\n"); 
		query.append("            , @[ioc_cd] AS IOC_CD " ).append("\n"); 
		query.append("            , @[ctrt_ofc_cd] AS CTRT_RGN_OFC_CD " ).append("\n"); 
		query.append("            , @[sls_ofc_cd] AS SLS_RGN_OFC_CD " ).append("\n"); 
		query.append("            , @[lod_qty] AS ORG_LOD_QTY " ).append("\n"); 
		query.append("            , @[grs_rpb_rev] AS ORG_GRS_RPB_REV " ).append("\n"); 
		query.append("            , @[cm_uc_amt] AS ORG_CM_UC_AMT " ).append("\n"); 
		query.append("            , @[user_id] AS CRE_USR_ID " ).append("\n"); 
		query.append("            , SYSDATE AS CRE_DT " ).append("\n"); 
		query.append("            , @[user_id] AS UPD_USR_ID " ).append("\n"); 
		query.append("            , SYSDATE AS UPD_DT " ).append("\n"); 
		query.append("         FROM DUAL " ).append("\n"); 
		query.append("       ) " ).append("\n"); 
		query.append("SELECT T1.MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("     , " ).append("\n"); 
		query.append("       (SELECT MAX(SLS_FCAST_NO)+T4.CNT " ).append("\n"); 
		query.append("         FROM SAQ_MON_FCAST_TRNS " ).append("\n"); 
		query.append("        WHERE MQTA_MDL_VER_NO = @[mqta_mdl_ver_no] " ).append("\n"); 
		query.append("       ) AS SLS_FCAST_NO " ).append("\n"); 
		query.append("     , 0 AS ALTN_FCAST_SEQ " ).append("\n"); 
		query.append("     , T1.RLANE_CD " ).append("\n"); 
		query.append("     , T1.DIR_CD " ).append("\n"); 
		query.append("     , T2.OFC_CD AS CTRT_OFC_CD " ).append("\n"); 
		query.append("     , T3.OFC_CD AS SLS_OFC_CD " ).append("\n"); 
		query.append("     , T1.LOD_QTY " ).append("\n"); 
		query.append("     , T1.GRS_RPB_REV " ).append("\n"); 
		query.append("     , T1.CM_UC_AMT " ).append("\n"); 
		query.append("     , T1.MDL_ALOC_QTY " ).append("\n"); 
		query.append("     , T1.REP_TRD_CD " ).append("\n"); 
		query.append("     , T1.REP_SUB_TRD_CD " ).append("\n"); 
		query.append("     , T1.TRD_CD " ).append("\n"); 
		query.append("     , T1.SUB_TRD_CD " ).append("\n"); 
		query.append("     , T1.IOC_CD " ).append("\n"); 
		query.append("     , T2.N2ND_PRNT_OFC_CD AS CTRT_RHQ_CD " ).append("\n"); 
		query.append("     , T2.N3RD_PRNT_OFC_CD AS CTRT_AQ_CD " ).append("\n"); 
		query.append("     , T2.OFC_CD AS CTRT_RGN_OFC_CD " ).append("\n"); 
		query.append("     , T3.N2ND_PRNT_OFC_CD AS SLS_RHQ_CD " ).append("\n"); 
		query.append("     , T3.N3RD_PRNT_OFC_CD AS SLS_AQ_CD " ).append("\n"); 
		query.append("     , T3.OFC_CD AS SLS_RGN_OFC_CD " ).append("\n"); 
		query.append("     , TO_DATE(SUBSTR(@[st_dt] , 1, 4)||to_char(DECODE(SUBSTR(@[mqta_mdl_ver_no] , 3, 2), '1Q', 0, '2Q', 3, '3Q', 6, '4Q', 9)+T4.CNT, 'FM00')||'01','YYYY/MM/DD') AS ST_DT " ).append("\n"); 
		query.append("     , T1.ORG_LOD_QTY " ).append("\n"); 
		query.append("     , T1.ORG_GRS_RPB_REV " ).append("\n"); 
		query.append("     , T1.ORG_CM_UC_AMT " ).append("\n"); 
		query.append("     , '0' AS FCAST_TRNS_STS_CD " ).append("\n"); 
		query.append("     , 0 AS RA_CM_UC_AMT" ).append("\n"); 
		query.append("     , 0 AS RA_OPFIT_UC_AMT" ).append("\n"); 
		query.append("     , T1.CRE_USR_ID " ).append("\n"); 
		query.append("     , T1.CRE_DT " ).append("\n"); 
		query.append("     , T1.UPD_USR_ID " ).append("\n"); 
		query.append("     , T1.UPD_DT " ).append("\n"); 
		query.append("  FROM TEMP T1 " ).append("\n"); 
		query.append("     , " ).append("\n"); 
		query.append("       (SELECT OFC_CD" ).append("\n"); 
		query.append("            , N2ND_PRNT_OFC_CD " ).append("\n"); 
		query.append("            , N3RD_PRNT_OFC_CD " ).append("\n"); 
		query.append("            , N4TH_PRNT_OFC_CD " ).append("\n"); 
		query.append("         FROM SAQ_ORGANIZATION_V " ).append("\n"); 
		query.append("        WHERE OFC_CD = @[ctrt_ofc_cd]" ).append("\n"); 
		query.append("       ) T2 " ).append("\n"); 
		query.append("     , " ).append("\n"); 
		query.append("       (SELECT OFC_CD" ).append("\n"); 
		query.append("            , N2ND_PRNT_OFC_CD " ).append("\n"); 
		query.append("            , N3RD_PRNT_OFC_CD " ).append("\n"); 
		query.append("            , N4TH_PRNT_OFC_CD " ).append("\n"); 
		query.append("         FROM SAQ_ORGANIZATION_V " ).append("\n"); 
		query.append("        WHERE OFC_CD = @[sls_ofc_cd] " ).append("\n"); 
		query.append("       ) T3 " ).append("\n"); 
		query.append("     , " ).append("\n"); 
		query.append("       (SELECT LEVEL AS CNT " ).append("\n"); 
		query.append("         FROM DUAL CONNECT BY LEVEL <= 3 " ).append("\n"); 
		query.append("       ) T4" ).append("\n"); 

	}
}