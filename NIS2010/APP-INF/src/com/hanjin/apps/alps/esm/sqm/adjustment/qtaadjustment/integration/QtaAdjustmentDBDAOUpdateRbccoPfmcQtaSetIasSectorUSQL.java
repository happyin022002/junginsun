/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : QtaAdjustmentDBDAOUpdateRbccoPfmcQtaSetIasSectorUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.31
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2014.03.31 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hyemin Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class QtaAdjustmentDBDAOUpdateRbccoPfmcQtaSetIasSectorUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RBCCO PFMC = QTA Setting for IAS Sector 을 Apply 한다.
	  * </pre>
	  */
	public QtaAdjustmentDBDAOUpdateRbccoPfmcQtaSetIasSectorUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pa_cm_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ra_cm_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_vw_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAOUpdateRbccoPfmcQtaSetIasSectorUSQL").append("\n"); 
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
		query.append("UPDATE SQM_CFM_QTA " ).append("\n"); 
		query.append("   SET LOD_QTY       = @[lod_qty] " ).append("\n"); 
		query.append("      ,GRS_RPB_REV   = @[grs_rpb_rev]" ).append("\n"); 
		query.append("      ,PA_CM_UC_AMT  = @[pa_cm_uc_amt]" ).append("\n"); 
		query.append("      ,RA_CM_UC_AMT  = @[ra_cm_uc_amt]" ).append("\n"); 
		query.append("      ,UPD_USR_ID    = @[upd_usr_id]" ).append("\n"); 
		query.append("      ,UPD_DT        = SYSDATE " ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND SUBSTR(QTA_RLSE_VER_NO, -2)= '02'" ).append("\n"); 
		query.append("   AND BSE_TP_CD                  = 'Q'" ).append("\n"); 
		query.append("   AND BSE_YR                     = @[bse_yr]" ).append("\n"); 
		query.append("   AND BSE_QTR_CD                 = @[bse_qtr_cd]" ).append("\n"); 
		query.append("   AND OFC_VW_CD                  = @[ofc_vw_cd]" ).append("\n"); 
		query.append("   AND TRD_CD                     = @[trd_cd]" ).append("\n"); 
		query.append("   AND RLANE_CD                   = @[rlane_cd]" ).append("\n"); 
		query.append("   AND DIR_CD                     = @[dir_cd]" ).append("\n"); 
		query.append("   AND RHQ_CD                     = @[rhq_cd]" ).append("\n"); 
		query.append("   AND RGN_OFC_CD                 = @[rgn_ofc_cd]" ).append("\n"); 
		query.append("   AND VSL_CD||SKD_VOY_NO||SKD_DIR_CD = (SELECT DISTINCT A1.VSL_CD||A1.SKD_VOY_NO||A1.SKD_DIR_CD" ).append("\n"); 
		query.append("                                        FROM SQM_CFM_QTA A1, SQM_CFM_TGT_VVD A2" ).append("\n"); 
		query.append("                                        WHERE 1=1" ).append("\n"); 
		query.append("                                        AND SUBSTR(A1.QTA_RLSE_VER_NO , -2) = '02'" ).append("\n"); 
		query.append("                                        AND A1.BSE_TP_CD = 'Q'" ).append("\n"); 
		query.append("                                        AND A1.BSE_YR = @[bse_yr]" ).append("\n"); 
		query.append("                                        AND A1.BSE_QTR_CD = @[bse_qtr_cd]" ).append("\n"); 
		query.append("                                        AND A1.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("                                        AND A1.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("                                        AND A1.DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("                                        AND A2.BSE_WK = @[bse_wk]" ).append("\n"); 
		query.append("                                        AND A1.QTA_RLSE_VER_NO = A2.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                                        AND A1.BSE_TP_CD = A2.BSE_TP_CD" ).append("\n"); 
		query.append("                                        AND A1.BSE_YR = A2.BSE_YR" ).append("\n"); 
		query.append("                                        AND A1.BSE_QTR_CD = A2.BSE_QTR_CD" ).append("\n"); 
		query.append("                                        AND A1.TRD_CD = A2.TRD_CD" ).append("\n"); 
		query.append("                                        AND A1.RLANE_CD = A2.RLANE_CD" ).append("\n"); 
		query.append("                                        AND A1.DIR_CD = A2.DIR_CD" ).append("\n"); 
		query.append("                                        AND A1.VSL_CD = A2.VSL_CD" ).append("\n"); 
		query.append("                                        AND A1.SKD_VOY_NO = A2.SKD_VOY_NO" ).append("\n"); 
		query.append("                                        AND A1.SKD_DIR_CD = A2.SKD_DIR_CD)" ).append("\n"); 

	}
}