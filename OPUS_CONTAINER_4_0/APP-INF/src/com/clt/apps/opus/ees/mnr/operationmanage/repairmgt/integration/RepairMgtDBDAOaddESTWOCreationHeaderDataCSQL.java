/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RepairMgtDBDAOaddESTWOCreationHeaderDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepairMgtDBDAOaddESTWOCreationHeaderDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Repair Work Order List 입력 (Header)
	  * </pre>
	  */
	public RepairMgtDBDAOaddESTWOCreationHeaderDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_ord_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_rqst_ver_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rqst_eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_ord_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rpr_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration").append("\n"); 
		query.append("FileName : RepairMgtDBDAOaddESTWOCreationHeaderDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MNR_ORD_HDR(" ).append("\n"); 
		query.append("         MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("        ,MNR_ORD_SEQ" ).append("\n"); 
		query.append("        ,EQ_KND_CD" ).append("\n"); 
		query.append("        ,MNR_GRP_TP_CD" ).append("\n"); 
		query.append("        ,MNR_WO_TP_CD" ).append("\n"); 
		query.append("        ,COST_CD" ).append("\n"); 
		query.append("        ,TRSM_MOD_CD" ).append("\n"); 
		query.append("        ,AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("        ,AGMT_SEQ" ).append("\n"); 
		query.append("        ,AGMT_VER_NO" ).append("\n"); 
		query.append("        ,CURR_CD" ).append("\n"); 
		query.append("        ,MNR_AGMT_AMT" ).append("\n"); 
		query.append("        ,MNR_WRK_AMT" ).append("\n"); 
		query.append("        ,ORD_ISS_OFC_CD" ).append("\n"); 
		query.append("        ,COST_OFC_CD" ).append("\n"); 
		query.append("        ,VNDR_SEQ" ).append("\n"); 
		query.append("        ,SPR_PRT_SPL_TP_CD" ).append("\n"); 
		query.append("        ,VSL_CD" ).append("\n"); 
		query.append("        ,SKD_VOY_NO" ).append("\n"); 
		query.append("        ,SKD_DIR_CD" ).append("\n"); 
		query.append("        ,SPR_PRT_BRTH_DT" ).append("\n"); 
		query.append("        ,SPR_PRT_SPL_YD_CD" ).append("\n"); 
		query.append("        ,SPR_PRT_SPL_DT" ).append("\n"); 
		query.append("        ,ORD_HDR_RMK" ).append("\n"); 
		query.append("        ,MNR_INP_DT" ).append("\n"); 
		query.append("        ,CRE_USR_ID" ).append("\n"); 
		query.append("        ,CRE_DT" ).append("\n"); 
		query.append("        ,UPD_USR_ID" ).append("\n"); 
		query.append("        ,UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT @[mnr_ord_ofc_cty_cd]" ).append("\n"); 
		query.append("     , @[mnr_ord_seq]" ).append("\n"); 
		query.append("     , EQ_KND_CD" ).append("\n"); 
		query.append("     , 'RPR'  MNR_GRP_TP_CD" ).append("\n"); 
		query.append("     , 'EST'  MNR_WO_TP_CD" ).append("\n"); 
		query.append("     , @[cost_cd]" ).append("\n"); 
		query.append("     , (SELECT TRSM_MOD_CD FROM MNR_PARTNER WHERE MNR_PRNR_SEQ = VNDR_SEQ AND MNR_GRP_TP_CD = 'RPR' AND CTRL_OFC_CD = COST_OFC_CD) TRSM_MOD_CD" ).append("\n"); 
		query.append("     , AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("     , AGMT_SEQ" ).append("\n"); 
		query.append("     , AGMT_VER_NO" ).append("\n"); 
		query.append("     , CURR_CD" ).append("\n"); 
		query.append("     , MNR_AGMT_AMT" ).append("\n"); 
		query.append("     , MNR_WRK_AMT" ).append("\n"); 
		query.append("     , '' ORD_ISS_OFC_CD" ).append("\n"); 
		query.append("     , COST_OFC_CD" ).append("\n"); 
		query.append("     , VNDR_SEQ" ).append("\n"); 
		query.append("     , '' SPR_PRT_SPL_TP_CD" ).append("\n"); 
		query.append("     , '' VSL_CD" ).append("\n"); 
		query.append("     , '' SKD_VOY_NO" ).append("\n"); 
		query.append("     , '' SKD_DIR_CD" ).append("\n"); 
		query.append("     , '' SPR_PRT_BRTH_DT" ).append("\n"); 
		query.append("     , '' SPR_PRT_SPL_YD_CD" ).append("\n"); 
		query.append("     , '' SPR_PRT_SPL_DT" ).append("\n"); 
		query.append("     , MNR_RPR_RMK" ).append("\n"); 
		query.append("     , RQST_DT AS MNR_INP_DT" ).append("\n"); 
		query.append("     , @[cre_usr_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("     , @[upd_usr_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("  FROM MNR_RPR_RQST_HDR" ).append("\n"); 
		query.append(" WHERE RQST_EQ_NO = @[rqst_eq_no]" ).append("\n"); 
		query.append("   AND RPR_RQST_SEQ = @[rpr_rqst_seq] " ).append("\n"); 
		query.append("   AND RPR_RQST_VER_NO = @[rpr_rqst_ver_no]  " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}