/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BSAManageDBDAOMultiBsaOpSltPrcCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BSAManageDBDAOMultiBsaOpSltPrcCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MERGE INTO bsa_slt_prc
	  * </pre>
	  */
	public BSAManageDBDAOMultiBsaOpSltPrcCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_slt_prc_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crs_chtr_bsa_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sub_chtr_bsa_capa",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slt_prc_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("co_bfr_sub_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_slt_prc_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.integration").append("\n"); 
		query.append("FileName : BSAManageDBDAOMultiBsaOpSltPrcCSQL").append("\n"); 
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
		query.append("MERGE INTO BSA_OP_SLT_PRC A" ).append("\n"); 
		query.append(" USING (SELECT @[slt_prc_seq]       AS SLT_PRC_SEQ," ).append("\n"); 
		query.append("               @[trd_cd]            AS TRD_CD," ).append("\n"); 
		query.append("               @[rlane_cd]          AS RLANE_CD," ).append("\n"); 
		query.append("               @[dir_cd]            AS DIR_CD," ).append("\n"); 
		query.append("               @[vsl_capa]          AS VSL_CAPA," ).append("\n"); 
		query.append("               @[vvd_cd]            AS VVD_CD," ).append("\n"); 
		query.append("               @[bsa_slt_prc_fm_dt] AS BSA_SLT_PRC_FM_DT," ).append("\n"); 
		query.append("               @[bsa_slt_prc_to_dt] AS BSA_SLT_PRC_TO_DT," ).append("\n"); 
		query.append("               @[co_bfr_sub_capa]   AS CO_BFR_SUB_CAPA," ).append("\n"); 
		query.append("               @[sub_chtr_bsa_capa] AS SUB_CHTR_BSA_CAPA," ).append("\n"); 
		query.append("               @[crs_chtr_bsa_capa] AS CRS_CHTR_BSA_CAPA," ).append("\n"); 
		query.append("               @[upd_usr_id]        AS USR_ID" ).append("\n"); 
		query.append("        FROM DUAL" ).append("\n"); 
		query.append("       ) B" ).append("\n"); 
		query.append(" ON ( A.SLT_PRC_SEQ   = B.SLT_PRC_SEQ AND" ).append("\n"); 
		query.append("      A.TRD_CD        = B.TRD_CD      AND" ).append("\n"); 
		query.append("      A.RLANE_CD      = B.RLANE_CD    AND" ).append("\n"); 
		query.append("      A.DIR_CD        = B.DIR_CD      AND" ).append("\n"); 
		query.append("      A.VSL_CAPA      = B.VSL_CAPA" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(" WHEN MATCHED THEN" ).append("\n"); 
		query.append("      UPDATE" ).append("\n"); 
		query.append("      SET    VVD_CD            = B.VVD_CD," ).append("\n"); 
		query.append("             BSA_SLT_PRC_FM_DT = B.BSA_SLT_PRC_FM_DT," ).append("\n"); 
		query.append("             BSA_SLT_PRC_TO_DT = B.BSA_SLT_PRC_TO_DT," ).append("\n"); 
		query.append("             CO_BFR_SUB_CAPA   = B.CO_BFR_SUB_CAPA," ).append("\n"); 
		query.append("             SUB_CHTR_BSA_CAPA = B.SUB_CHTR_BSA_CAPA," ).append("\n"); 
		query.append("             CRS_CHTR_BSA_CAPA = B.CRS_CHTR_BSA_CAPA," ).append("\n"); 
		query.append("             UPD_USR_ID        = B.USR_ID," ).append("\n"); 
		query.append("             UPD_DT            = SYSDATE" ).append("\n"); 
		query.append(" WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("      INSERT (TRD_CD, " ).append("\n"); 
		query.append("              RLANE_CD, " ).append("\n"); 
		query.append("              DIR_CD, " ).append("\n"); 
		query.append("              VSL_CAPA, " ).append("\n"); 
		query.append("              SLT_PRC_SEQ," ).append("\n"); 
		query.append("              VVD_CD, " ).append("\n"); 
		query.append("              BSA_SLT_PRC_FM_DT, " ).append("\n"); 
		query.append("              BSA_SLT_PRC_TO_DT," ).append("\n"); 
		query.append("              CO_BFR_SUB_CAPA, " ).append("\n"); 
		query.append("              SUB_CHTR_BSA_CAPA, " ).append("\n"); 
		query.append("              CRS_CHTR_BSA_CAPA," ).append("\n"); 
		query.append("              CRE_USR_ID, " ).append("\n"); 
		query.append("              CRE_DT, " ).append("\n"); 
		query.append("              UPD_USR_ID, " ).append("\n"); 
		query.append("              UPD_DT)" ).append("\n"); 
		query.append("      VALUES (B.TRD_CD, " ).append("\n"); 
		query.append("              B.RLANE_CD, " ).append("\n"); 
		query.append("              B.DIR_CD, " ).append("\n"); 
		query.append("              B.VSL_CAPA, " ).append("\n"); 
		query.append("              B.SLT_PRC_SEQ," ).append("\n"); 
		query.append("              B.VVD_CD, " ).append("\n"); 
		query.append("              B.BSA_SLT_PRC_FM_DT, " ).append("\n"); 
		query.append("              B.BSA_SLT_PRC_TO_DT," ).append("\n"); 
		query.append("              B.CO_BFR_SUB_CAPA, " ).append("\n"); 
		query.append("              B.SUB_CHTR_BSA_CAPA, " ).append("\n"); 
		query.append("              B.CRS_CHTR_BSA_CAPA," ).append("\n"); 
		query.append("              B.USR_ID, " ).append("\n"); 
		query.append("              SYSDATE, " ).append("\n"); 
		query.append("              B.USR_ID, " ).append("\n"); 
		query.append("              SYSDATE)" ).append("\n"); 

	}
}