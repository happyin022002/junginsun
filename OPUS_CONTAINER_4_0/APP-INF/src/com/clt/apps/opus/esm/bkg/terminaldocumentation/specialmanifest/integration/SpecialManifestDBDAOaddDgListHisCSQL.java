/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpecialManifestDBDAOaddDgListHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.15
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.02.15 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialManifestDBDAOaddDgListHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 위험물 정보들을 신규생성한다.
	  * </pre>
	  */
	public SpecialManifestDBDAOaddDgListHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration").append("\n"); 
		query.append("FileName : SpecialManifestDBDAOaddDgListHisCSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("  INTO BKG_CSTMS_EUR_DG_HIS" ).append("\n"); 
		query.append("      (EUR_DG_DECL_TP_CD" ).append("\n"); 
		query.append("      ,VSL_CD" ).append("\n"); 
		query.append("      ,SKD_VOY_NO" ).append("\n"); 
		query.append("      ,SKD_DIR_CD" ).append("\n"); 
		query.append("      ,PORT_CD" ).append("\n"); 
		query.append("      ,CNTR_NO" ).append("\n"); 
		query.append("      ,CNTR_CGO_SEQ" ).append("\n"); 
		query.append("      ,HIS_SEQ" ).append("\n"); 
		query.append("      ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,BL_NO" ).append("\n"); 
		query.append("      ,POL_CD" ).append("\n"); 
		query.append("      ,POD_CD" ).append("\n"); 
		query.append("      ,CELL_PSN_NO" ).append("\n"); 
		query.append("      ,ANR_FWRD_ID" ).append("\n"); 
		query.append("      ,SVC_RQST_NO" ).append("\n"); 
		query.append("      ,ANR_CRR_TP_CD" ).append("\n"); 
		query.append("      ,FDR_SVC_RQST_NO" ).append("\n"); 
		query.append("      ,FDR_VVD_ID" ).append("\n"); 
		query.append("      ,FDR_VSL_NM" ).append("\n"); 
		query.append("      ,FDR_VSL_LLOYD_NO" ).append("\n"); 
		query.append("      ,IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append("      ,IMDG_CLSS_CD" ).append("\n"); 
		query.append("      ,IMDG_UN_NO" ).append("\n"); 
		query.append("      ,IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("      ,ANR_SPCL_TP_ID" ).append("\n"); 
		query.append("      ,FLSH_PNT_CDO_TEMP" ).append("\n"); 
		query.append("      ,NET_WGT" ).append("\n"); 
		query.append("      ,GRS_WGT" ).append("\n"); 
		query.append("      ,MFAG_NO" ).append("\n"); 
		query.append("      ,PRP_SHP_NM" ).append("\n"); 
		query.append("      ,HZD_DESC" ).append("\n"); 
		query.append("      ,BRTH_YD_CD" ).append("\n"); 
		query.append("      ,BRTH_YD_NM" ).append("\n"); 
		query.append("      ,IMDG_LMT_QTY_FLG" ).append("\n"); 
		query.append("      ,PCK_QTY" ).append("\n"); 
		query.append("      ,PCK_TP_CD" ).append("\n"); 
		query.append("      ,OUT_IMDG_PCK_QTY1" ).append("\n"); 
		query.append("      ,OUT_IMDG_PCK_CD1" ).append("\n"); 
		query.append("      ,EUR_OUTR_PCK_DESC" ).append("\n"); 
		query.append("      ,IN_IMDG_PCK_QTY1" ).append("\n"); 
		query.append("      ,IN_IMDG_PCK_CD1" ).append("\n"); 
		query.append("      ,EUR_INR_PCK_DESC" ).append("\n"); 
		query.append("      ,EMS_NO" ).append("\n"); 
		query.append("      ,ANR_ROLE_DIV_CD" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append("      ,EUR_PCK_DESC" ).append("\n"); 
		query.append("      ,EUR_DCGO_MRN_POLUT_CD" ).append("\n"); 
		query.append("      ,XTD_STAY_PRMT_NO" ).append("\n"); 
		query.append("      ,DIFF_RMK" ).append("\n"); 
		query.append("      ,CRR_DT" ).append("\n"); 
		query.append("      ,NET_EXPLO_WGT" ).append("\n"); 
		query.append("      ,CGO_OPR_CD" ).append("\n"); 
		query.append("      ,APLY_NO" ).append("\n"); 
		query.append("      ,CNTR_REF_NO" ).append("\n"); 
		query.append("	  ,EMER_CNTC_PHN_NO" ).append("\n"); 
		query.append("	  ,EMER_CNTC_PSON_NM" ).append("\n"); 
		query.append("      ,IMDG_SUBS_RSK_LBL_CD1" ).append("\n"); 
		query.append("      ,IMDG_SUBS_RSK_LBL_CD2" ).append("\n"); 
		query.append("      ,IMDG_SUBS_RSK_LBL_CD3" ).append("\n"); 
		query.append("      ,IMDG_SUBS_RSK_LBL_CD4" ).append("\n"); 
		query.append("      ,EMER_RSPN_GID_NO" ).append("\n"); 
		query.append("      ,DCGO_REF_NO" ).append("\n"); 
		query.append("      ,SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("      ,SPCL_CGO_SEQ" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("SELECT EUR_DG_DECL_TP_CD" ).append("\n"); 
		query.append("      ,VSL_CD" ).append("\n"); 
		query.append("      ,SKD_VOY_NO" ).append("\n"); 
		query.append("      ,SKD_DIR_CD" ).append("\n"); 
		query.append("      ,PORT_CD" ).append("\n"); 
		query.append("      ,CNTR_NO" ).append("\n"); 
		query.append("      ,CNTR_CGO_SEQ" ).append("\n"); 
		query.append("      ,(SELECT NVL(MAX(HIS_SEQ),0) + 1" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_EUR_DG_HIS" ).append("\n"); 
		query.append("         WHERE 0=0" ).append("\n"); 
		query.append("           AND VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("           AND SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("           AND SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("           AND CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("           AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("      ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,BL_NO" ).append("\n"); 
		query.append("      ,POL_CD" ).append("\n"); 
		query.append("      ,POD_CD" ).append("\n"); 
		query.append("      ,CELL_PSN_NO" ).append("\n"); 
		query.append("      ,ANR_FWRD_ID" ).append("\n"); 
		query.append("      ,SVC_RQST_NO" ).append("\n"); 
		query.append("      ,ANR_CRR_TP_CD" ).append("\n"); 
		query.append("      ,FDR_SVC_RQST_NO" ).append("\n"); 
		query.append("      ,FDR_VVD_ID" ).append("\n"); 
		query.append("      ,FDR_VSL_NM" ).append("\n"); 
		query.append("      ,FDR_VSL_LLOYD_NO" ).append("\n"); 
		query.append("      ,IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append("      ,IMDG_CLSS_CD" ).append("\n"); 
		query.append("      ,IMDG_UN_NO" ).append("\n"); 
		query.append("      ,IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("      ,ANR_SPCL_TP_ID" ).append("\n"); 
		query.append("      ,FLSH_PNT_CDO_TEMP" ).append("\n"); 
		query.append("      ,NET_WGT" ).append("\n"); 
		query.append("      ,GRS_WGT" ).append("\n"); 
		query.append("      ,MFAG_NO" ).append("\n"); 
		query.append("      ,PRP_SHP_NM" ).append("\n"); 
		query.append("      ,HZD_DESC" ).append("\n"); 
		query.append("      ,BRTH_YD_CD" ).append("\n"); 
		query.append("      ,BRTH_YD_NM" ).append("\n"); 
		query.append("      ,IMDG_LMT_QTY_FLG" ).append("\n"); 
		query.append("      ,PCK_QTY" ).append("\n"); 
		query.append("      ,PCK_TP_CD" ).append("\n"); 
		query.append("      ,OUT_IMDG_PCK_QTY1" ).append("\n"); 
		query.append("      ,OUT_IMDG_PCK_CD1" ).append("\n"); 
		query.append("      ,EUR_OUTR_PCK_DESC" ).append("\n"); 
		query.append("      ,IN_IMDG_PCK_QTY1" ).append("\n"); 
		query.append("      ,IN_IMDG_PCK_CD1" ).append("\n"); 
		query.append("      ,EUR_INR_PCK_DESC" ).append("\n"); 
		query.append("      ,EMS_NO" ).append("\n"); 
		query.append("      ,ANR_ROLE_DIV_CD" ).append("\n"); 
		query.append("      ,@[upd_usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      ,@[upd_usr_id]" ).append("\n"); 
		query.append("      ,TO_DATE(@[upd_dt],'YYYY/MM/DD HH24:MI:SS')" ).append("\n"); 
		query.append("      ,EUR_PCK_DESC" ).append("\n"); 
		query.append("      ,EUR_DCGO_MRN_POLUT_CD" ).append("\n"); 
		query.append("      ,XTD_STAY_PRMT_NO" ).append("\n"); 
		query.append("      ,DIFF_RMK" ).append("\n"); 
		query.append("      ,CRR_DT" ).append("\n"); 
		query.append("      ,NET_EXPLO_WGT" ).append("\n"); 
		query.append("      ,CGO_OPR_CD" ).append("\n"); 
		query.append("      ,APLY_NO" ).append("\n"); 
		query.append("      ,CNTR_REF_NO" ).append("\n"); 
		query.append("      ,EMER_CNTC_PHN_NO" ).append("\n"); 
		query.append("	  ,EMER_CNTC_PSON_NM" ).append("\n"); 
		query.append("      ,IMDG_SUBS_RSK_LBL_CD1" ).append("\n"); 
		query.append("      ,IMDG_SUBS_RSK_LBL_CD2" ).append("\n"); 
		query.append("      ,IMDG_SUBS_RSK_LBL_CD3" ).append("\n"); 
		query.append("      ,IMDG_SUBS_RSK_LBL_CD4" ).append("\n"); 
		query.append("      ,EMER_RSPN_GID_NO" ).append("\n"); 
		query.append("      ,DCGO_REF_NO" ).append("\n"); 
		query.append("      ,SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("      ,SPCL_CGO_SEQ" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_EUR_DG" ).append("\n"); 
		query.append(" WHERE EUR_DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("   AND VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("   AND SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("   AND SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("   AND PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("   AND CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("   AND BL_NO = @[bl_no]" ).append("\n"); 

	}
}